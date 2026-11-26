"""Index Il2CppDumper dump.cs as text only, using the Python standard library.

Never loads an assembly, executes game code, disassembles native code, or modifies
an input dump. Output is restricted to derived/il2cpp/index under this archive.
The manually reviewed code-navigation report is not overwritten by this script.
C# snippets are metadata/signature stubs, NOT source.
"""
from __future__ import annotations

import argparse
from bisect import bisect_right
from collections import Counter, defaultdict
from datetime import datetime, timezone
import hashlib
import json
from pathlib import Path
import re

ABIS = ("arm64-v8a", "armeabi-v7a")
FOCUS = (
    "BattleCore.dll", "GameLogic.dll", "GameProto.dll", "GameNative.dll",
    "DodGameLib.dll", "DodProtoBase.dll", "DodFixLib.dll", "GameBase.dll",
    "Assembly-CSharp.dll", "Assembly-CSharp-firstpass.dll",
)
IMAGE_RE = re.compile(r"^// Image (\d+): (.+?) - (\d+)\s*$")
TYPE_RE = re.compile(r"^(.*?)\b(class|struct|enum|interface)\s+(.+?)\s*// TypeDefIndex:\s*(\d+)\s*$")
NS_RE = re.compile(r"^// Namespace:\s?(.*)$")
SECTION_RE = re.compile(r"^\s*// (Fields|Properties|Methods)\s*$")
ADDRESS_RE = re.compile(r"^\s*// RVA: (\S+) Offset: (\S+)(?: VA: (\S+))?(.*)$")
TOPICS = {
    "战斗": r"Battle|Combat|Damage|Attack|Fight|Hit|Bullet|Actor|Buff",
    "技能": r"Skill|Buff|Talent|Spell|Passive",
    "成长": r"LevelUp|Upgrade|Growth|Talent|Potential|Cultivat|Attribute|RoleLevel|PlayerLevel|HeroLevel|Strengthen",
    "装备": r"Equip|Weapon|Armor|Cloth|Gem|Forge|Refine|Suit",
    "关卡": r"Chapter|Stage|Dungeon|LevelConfig|LevelCfg|LevelData|MapConfig|Mission|Checkpoint",
    "兽潮与波次": r"Horde|Beast|MonsterWave|MonsterLibrary|WaveConfig|WaveData|Tide",
    "PVP与竞技": r"Pvp|PVP|Arena|Duel|RankBattle|PK|PkBattle",
    "宠物与伙伴": r"Pet|Partner|Companion|Familiar",
    "配置与序列化": r"Config|ResTable|BProto|ProtoBase|ResBin|Resbin|Serializer|Serialize",
    "XLua与脚本桥接": r"XLua|LuaEnv|LuaTable|LuaFunction|LuaBehaviour|LuaManager|LuaScript",
}


def sha256(path: Path) -> str:
    with path.open("rb") as stream:
        return hashlib.file_digest(stream, "sha256").hexdigest()


def write_json(path: Path, value) -> None:
    path.parent.mkdir(parents=True, exist_ok=True)
    path.write_text(json.dumps(value, ensure_ascii=False, indent=2) + "\n", encoding="utf-8")


def write_jsonl(path: Path, rows) -> None:
    path.parent.mkdir(parents=True, exist_ok=True)
    with path.open("w", encoding="utf-8", newline="\n") as stream:
        for row in rows:
            stream.write(json.dumps(row, ensure_ascii=False, separators=(",", ":")) + "\n")


def member_name(kind: str, signature: str) -> str:
    if kind == "method":
        prefix = signature.split("(", 1)[0].rstrip()
        # Preserve generic method arguments even when they contain whitespace.
        match = re.search(r"([^\s<]+(?:<.*>)?)$", prefix)
        return match.group(1) if match else prefix
    clean = re.sub(r"/\*.*?\*/", "", signature).strip()
    if kind == "property":
        clean = clean.split("{", 1)[0].strip()
    else:
        clean = clean.split(";", 1)[0]
        clean = re.split(r"\s+=\s+", clean, maxsplit=1)[0].strip()
    return clean.rsplit(None, 1)[-1] if clean else ""


def parse_dump(source: Path, abi: str, archive: Path):
    # Reading the whole text here does not execute or load it as C#/CLR code.
    raw = source.read_text(encoding="utf-8-sig")
    lines = raw.splitlines()
    images, types, members, warnings, generic_comments = [], [], [], [], []
    namespace, namespace_line = "", 1
    starts = []
    for number, line in enumerate(lines, 1):
        image = IMAGE_RE.match(line)
        if image:
            images.append({"image_index": int(image[1]), "assembly": image[2],
                           "type_start": int(image[3]), "source_header_line": number})
        ns = NS_RE.match(line)
        if ns:
            namespace, namespace_line = ns[1].strip(), number
        declaration = TYPE_RE.match(line)
        if declaration:
            head, kind, rest, index = declaration.groups()
            name_and_base = re.split(r"\s+:\s+", rest, maxsplit=1)
            name = name_and_base[0].strip()
            types.append({"abi": abi, "type_index": int(index), "kind": kind,
                          "name": name, "namespace": namespace,
                          "qualified_name": namespace + "." + name if namespace else name,
                          "modifiers": head.strip(),
                          "bases": name_and_base[1].strip() if len(name_and_base) > 1 else "",
                          "declaration": line.strip(), "source_start_line": namespace_line,
                          "source_declaration_line": number})
            starts.append(number)
    if not images or not types:
        raise ValueError(f"Missing image/type declarations in {source}")
    image_starts = [row["type_start"] for row in images]
    if image_starts != sorted(image_starts):
        raise ValueError("Image TypeDef starts are not ordered")
    source_rel = source.relative_to(archive).as_posix()
    known = set()
    for position, row in enumerate(types):
        index = row["type_index"]
        if index in known:
            raise ValueError(f"Duplicate TypeDefIndex {index}")
        known.add(index)
        image_position = bisect_right(image_starts, index) - 1
        if image_position < 0:
            raise ValueError(f"Unmapped TypeDefIndex {index}")
        image = images[image_position]
        row.update({"image_index": image["image_index"], "assembly": image["assembly"], "source": source_rel})
        limit = types[position + 1]["source_start_line"] - 1 if position + 1 < len(types) else len(lines)
        # Dumper emits each type's closing brace at column 0, including '{}' stubs.
        end = next((n for n in range(row["source_declaration_line"] + 1, limit + 1)
                    if lines[n - 1] in ("}", "{}")), None)
        if end is None:
            raise ValueError(f"No closing type brace for {index}")
        row["source_end_line"] = end
        section, address = None, None
        counts = Counter()
        comment_start = None
        for number in range(row["source_declaration_line"] + 1, end):
            original = lines[number - 1]
            text = original.strip()
            if comment_start is not None or text.startswith("/*"):
                if comment_start is None:
                    comment_start = number
                if "*/" in text:
                    generic_comments.append({"type_index": index, "assembly": row["assembly"],
                                             "source": source_rel, "source_start_line": comment_start,
                                             "source_end_line": number,
                                             "text": "\n".join(lines[comment_start - 1:number])})
                    comment_start = None
                continue
            sec = SECTION_RE.match(original)
            if sec:
                section = {"Fields": "field", "Properties": "property", "Methods": "method"}[sec[1]]
                address = None
                continue
            addr = ADDRESS_RE.match(original)
            if addr:
                address = {"rva": addr[1], "offset": addr[2], "va": addr[3],
                           "comment": text, "source_line": number}
                continue
            if not text or text.startswith(("//", "[")) or text in ("{", "}"):
                continue
            if section is None:
                warnings.append({"type_index": index, "line": number, "text": text, "reason": "No member section"})
                continue
            if ((section == "field" and ";" not in text)
                    or (section == "method" and "(" not in text)
                    or (section == "property" and "{" not in text)):
                warnings.append({"type_index": index, "line": number, "text": text, "reason": "Unrecognized member line"})
                continue
            signature = text.split(" //", 1)[0].rstrip()
            member = {"abi": abi, "assembly": row["assembly"], "type_index": index,
                      "type_name": row["qualified_name"], "kind": section,
                      "name": member_name(section, signature), "signature": signature,
                      "source": source_rel, "source_line": number}
            if section == "field":
                offset = re.search(r"//\s*(0x[0-9A-Fa-f]+)\s*$", text)
                if offset:
                    member["field_offset"] = offset[1]
            if section == "method":
                member["has_recovered_body"] = False
                if address:
                    member["address"] = address
                address = None
            members.append(member)
            counts[section] += 1
        if comment_start is not None:
            raise ValueError(f"Unclosed comment block in TypeDefIndex {index}")
        row["member_counts"] = dict(counts)
    if known != set(range(max(known) + 1)):
        warnings.append({"reason": "Non-contiguous TypeDef indices", "count": len(known), "max": max(known)})
    by_image = defaultdict(list)
    by_type = defaultdict(list)
    for row in types:
        by_image[row["image_index"]].append(row)
    for row in members:
        by_type[row["type_index"]].append(row)
    for n, image in enumerate(images):
        own = by_image[image["image_index"]]
        image["type_end_exclusive"] = images[n + 1]["type_start"] if n + 1 < len(images) else max(known) + 1
        image["type_count"] = len(own)
        image["kinds"] = dict(Counter(row["kind"] for row in own))
        image["member_counts"] = dict(sum((Counter(row["member_counts"]) for row in own), Counter()))
        image["source"] = source_rel
        image["source_start_line"] = min((row["source_start_line"] for row in own), default=None)
        image["source_end_line"] = max((row["source_end_line"] for row in own), default=None)
    namespace_counts = Counter((row["assembly"], row["namespace"]) for row in types)
    summary = {"abi": abi, "source": source_rel, "sha256": sha256(source), "bytes": source.stat().st_size,
               "lines": len(lines), "image_count": len(images), "type_count": len(types),
               "type_kinds": dict(Counter(row["kind"] for row in types)),
               "member_count": len(members), "member_kinds": dict(Counter(row["kind"] for row in members)),
               "parse_warning_count": len(warnings), "method_bodies_recovered": False,
               "generic_instantiation_comment_blocks": len(generic_comments),
               "generic_instantiation_comment_lines": sum(r["source_end_line"] - r["source_start_line"] + 1 for r in generic_comments),
               "type_indices_contiguous": known == set(range(max(known) + 1)),
               "image_type_counts_match_boundaries": all(row["type_count"] == row["type_end_exclusive"] - row["type_start"] for row in images)}
    return {"summary": summary, "lines": lines, "images": images, "types": types,
            "members": members, "warnings": warnings, "by_type": by_type,
            "generic_comments": generic_comments,
            "namespaces": [{"assembly": key[0], "namespace": key[1], "type_count": count}
                           for key, count in sorted(namespace_counts.items())]}


def emit_indexes(data, output: Path):
    abi_dir = output / data["summary"]["abi"]
    write_json(abi_dir / "images.json", data["images"])
    write_jsonl(abi_dir / "types.jsonl", data["types"])
    write_jsonl(abi_dir / "members.jsonl", data["members"])
    write_json(abi_dir / "namespaces.json", data["namespaces"])
    write_json(abi_dir / "parse-warnings.json", data["warnings"])
    write_jsonl(abi_dir / "generic-instantiations.jsonl", data["generic_comments"])
    write_json(abi_dir / "summary.json", data["summary"])
    focus_dir = abi_dir / "assemblies"
    focus_dir.mkdir(parents=True, exist_ok=True)
    for assembly in FOCUS:
        own = [row for row in data["types"] if row["assembly"] == assembly]
        if not own:
            continue
        filename = re.sub(r"[^A-Za-z0-9_.-]", "_", assembly) + ".txt"
        with (focus_dir / filename).open("w", encoding="utf-8", newline="\n") as stream:
            stream.write("// TEXT-ONLY METADATA/SIGNATURE EXCERPT; NOT RECOVERED C# IMPLEMENTATION.\n")
            stream.write(f"// Source: {data['summary']['source']}\n// SHA256: {data['summary']['sha256']}\n")
            stream.write(f"// Assembly: {assembly}; types: {len(own)}; original dump lines {own[0]['source_start_line']}-{own[-1]['source_end_line']}\n\n")
            for row in own:
                stream.write(f"// ORIGINAL DUMP LINES {row['source_start_line']}-{row['source_end_line']}; TypeDefIndex {row['type_index']}\n")
                stream.write("\n".join(data["lines"][row["source_start_line"] - 1:row["source_end_line"]]) + "\n\n")
    topic_rows = {}
    for title, pattern in TOPICS.items():
        regex = re.compile(pattern, re.I)
        rows = []
        for row in data["types"]:
            if row["assembly"] in FOCUS and regex.search(row["qualified_name"]):
                selected = {key: row[key] for key in ("assembly", "type_index", "kind", "qualified_name", "bases", "source", "source_start_line", "source_end_line", "member_counts")}
                selected["fields"] = [{"name": member["name"], "signature": member["signature"], "source_line": member["source_line"]}
                                      for member in data["by_type"][row["type_index"]] if member["kind"] == "field"]
                rows.append(selected)
        topic_rows[title] = {"selection": "Case-insensitive name regex only; not proof of runtime use", "pattern": pattern, "type_count": len(rows), "types": rows}
    write_json(abi_dir / "topics.json", topic_rows)
    return topic_rows


def canonical_types(data):
    return [(r["type_index"], r["assembly"], r["namespace"], r["declaration"]) for r in data["types"]]


def canonical_members(data):
    # Method RVA/VA and field offsets are intentionally ABI-specific and excluded.
    return [(r["type_index"], r["kind"], r["name"], r["signature"]) for r in data["members"]]


def validate_outputs(data, output: Path):
    checks = {}
    for abi, parsed in data.items():
        abi_dir = output / abi
        stored_types = [json.loads(x) for x in (abi_dir / "types.jsonl").read_text(encoding="utf-8").splitlines()]
        stored_members = [json.loads(x) for x in (abi_dir / "members.jsonl").read_text(encoding="utf-8").splitlines()]
        if stored_types != parsed["types"] or stored_members != parsed["members"] or parsed["warnings"]:
            raise ValueError(f"JSONL roundtrip or parse warnings failed: {abi}")
        for row in stored_types:
            if parsed["lines"][row["source_declaration_line"] - 1].strip() != row["declaration"]:
                raise ValueError(f"Type source line mismatch: {abi} {row['type_index']}")
        for row in stored_members:
            if not parsed["lines"][row["source_line"] - 1].strip().startswith(row["signature"]):
                raise ValueError(f"Member source line mismatch: {abi} {row['source_line']}")
        for assembly in FOCUS:
            excerpt = (abi_dir / "assemblies" / (assembly + ".txt")).read_text(encoding="utf-8")
            for row in parsed["types"]:
                if row["assembly"] == assembly:
                    snippet = "\n".join(parsed["lines"][row["source_start_line"] - 1:row["source_end_line"]])
                    if snippet not in excerpt:
                        raise ValueError(f"Excerpt differs from original: {abi} {row['type_index']}")
        checks[abi] = {"jsonl_roundtrip": True, "all_type_declaration_lines_match": True,
                       "all_member_signature_lines_match": True, "all_focus_excerpts_match_original_spans": True,
                       "parse_warnings": 0, "types_checked": len(stored_types), "members_checked": len(stored_members)}
    write_json(output / "verification.json", {"checks": checks, "scope": "text/index integrity only; not parser completeness proof or recovered implementation validation"})


def emit_docs(output: Path):
    (output / "README.md").write_text("""# IL2CPP 文本索引

本目录由 [index_il2cpp.py](<../../../tools/index_il2cpp.py>) 生成。只使用 Python 标准库文本解析，不加载 CLR/Dummy DLL，不执行游戏代码，不反汇编。

## 总览

- [summary.json](<summary.json>)：脚本/输入 SHA-256、计数、范围与能力边界。
- [abi-comparison.json](<abi-comparison.json>)：去地址/字段偏移的声明对比，不验证机器码、对象布局或行为兼容性。
- [verification.json](<verification.json>)：JSONL 重新读取一致性、全部类型/成员原始行、重点程序集摘录逐类型原文核验。
- [manifest.json](<manifest.json>)：本目录其他文件的大小和 SHA-256，不含清单自身，亦不包含人工分析报告。
- [玩法与代码导航](<../../../reports/玩法与代码导航.md>)：人工核对的字段/方法证据、原始行链接和未恢复内容；脚本复跑不覆盖该报告。

## 每个 ABI 的文件

以下以 arm64-v8a 为例；armeabi-v7a 下有相同结构，各自保留原生地址和字段偏移。

- [images.json](<arm64-v8a/images.json>)：47 个程序集/image 与 TypeDefIndex 半开区间、各类计数。
- [types.jsonl](<arm64-v8a/types.jsonl>)：每行一个类型，含 kind、namespace、qualified_name、assembly、TypeDefIndex、原始行范围、成员计数。
- [members.jsonl](<arm64-v8a/members.jsonl>)：每行一个字段/属性/方法，含原始签名、source_line、所属类型，字段偏移/方法 RVA 按存在情况保留。
- [namespaces.json](<arm64-v8a/namespaces.json>)：程序集内命名空间计数。
- [summary.json](<arm64-v8a/summary.json>)：单 ABI 输入哈希、计数和结构检查。
- [topics.json](<arm64-v8a/topics.json>)：只在重点程序集内按类型名称正则检索的主题候选，可能重叠/误报/漏报，不是运行时使用证据或调用图。
- [parse-warnings.json](<arm64-v8a/parse-warnings.json>)：本次未解析成员告警，当前为空。
- [generic-instantiations.jsonl](<arm64-v8a/generic-instantiations.jsonl>)：GenericInstMethod 多行注释原文与归属，不作为新方法定义计数。
- [BattleCore 摘录](<arm64-v8a/assemblies/BattleCore.dll.txt>)、[GameLogic 摘录](<arm64-v8a/assemblies/GameLogic.dll.txt>)、[GameProto 摘录](<arm64-v8a/assemblies/GameProto.dll.txt>)、[GameNative 摘录](<arm64-v8a/assemblies/GameNative.dll.txt>)：另有 DodGameLib/DodProtoBase/DodFixLib/GameBase/Assembly-CSharp/Assembly-CSharp-firstpass；每种类型前有 ORIGINAL DUMP LINES 和 TypeDefIndex 标记。

## 计数与限制

- 计数包含 `<Module>`、编译器生成和第三方/引擎类型。枚举 value__ 和常量计入字段；属性访问器计入方法，同时保留属性声明。不能称为全是手写业务类。
- 命名空间、类型、成员均来自 Dumper 的元数据文本，不是恢复原始 C#。所有方法 has_recovered_body=false；空体不代表原游戏为空操作。
- “bases” 保存 C# 冒号后的声明文本，可能是接口或具体基类，不能未经解析分类就全称为基类。
- 未解析 resbin、未恢复 Lua、未推断伤害公式/奖励/掉率/权重/服务器规则。

## 复跑

在归档根目录用 Python 3.11+ 运行：

```powershell
python -B tools/index_il2cpp.py --archive .
```
""", encoding="utf-8")
    files = [{"path": p.relative_to(output).as_posix(), "bytes": p.stat().st_size, "sha256": sha256(p)}
             for p in sorted(output.rglob("*")) if p.is_file() and p.name != "manifest.json"]
    write_json(output / "manifest.json", {"algorithm": "sha256", "excludes": ["manifest.json"], "files": files})


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--archive", type=Path, default=Path(__file__).resolve().parents[1])
    args = parser.parse_args()
    archive = args.archive.resolve()
    output = archive / "derived/il2cpp/index"
    data = {}
    for abi in ABIS:
        parsed = parse_dump(archive / "derived/il2cpp" / abi / "dump.cs", abi, archive)
        data[abi] = parsed
        topics = emit_indexes(parsed, output)
        print(json.dumps({**parsed["summary"], "topic_type_counts": {key: value["type_count"] for key, value in topics.items()}}, ensure_ascii=False), flush=True)
    left, right = (data[abi] for abi in ABIS)
    comparison = {"abis": list(ABIS), "same_image_headers": [(r["assembly"], r["type_start"]) for r in left["images"]] == [(r["assembly"], r["type_start"]) for r in right["images"]],
                  "same_type_declarations": canonical_types(left) == canonical_types(right),
                  "same_member_signatures": canonical_members(left) == canonical_members(right),
                  "note": "Text declaration equality is not native-code, ABI layout, behavioral, or version compatibility verification."}
    summary = {"generated_utc": datetime.now(timezone.utc).isoformat(), "tool": "tools/index_il2cpp.py", "tool_sha256": sha256(Path(__file__)),
               "mode": "stdlib text parsing only", "abis": {abi: data[abi]["summary"] for abi in ABIS},
               "abi_comparison": comparison, "focus_assemblies": list(FOCUS),
               "limits": ["No C# method bodies recovered", "No DLL/game code execution", "No native disassembly", "No formula/drop-rate/runtime-state inference from names alone"]}
    write_json(output / "summary.json", summary)
    write_json(output / "abi-comparison.json", comparison)
    validate_outputs(data, output)
    emit_docs(output)
    print(json.dumps({"abi_comparison": comparison, "validation": "passed", "output": str(output)}, ensure_ascii=False), flush=True)


if __name__ == "__main__":
    main()
