# IL2CPP 文本索引

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
