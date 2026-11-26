"""Join existing source-table identities into a local gameplay catalog, not fabricated data."""
from pathlib import Path
import collections, csv, hashlib, json, re
from decode_resbin_extended import safe_csv_cell
ROOT=Path(__file__).resolve().parents[1]
OUT=ROOT/'derived/gameplay-catalog'
NATIVE_STATUSES={'decoded-validated-static','decoded-validated-native-recursive'}
CANDIDATE='cross-variant-layout-candidate'
CORE=['SkillBaseConfg','BootyConfig','EquipConfig','EquipUpLevelConfig','EquipBootyConfig','LongHunEquipBootyConfig','SacredEquipBootyConfig','BuffBaseConfig','MonsterConfig','PlayerExpConfig','LevelBaseConfig','ParamConfig','AttrDataConfig','DefaultAttConfig','LongHunSkillConfig']

def load(path):return json.loads((ROOT/path).read_text(encoding='utf-8-sig'))
def write(path,obj):path.write_text(json.dumps(obj,ensure_ascii=False,indent=2,allow_nan=False)+'\n',encoding='utf-8')
def identity(x):return x['bundle'],x['path_id']
def normalized(x):
    v=dict(x)
    if isinstance(v.get('schema'),dict):v['schema']=v['schema']['namespace']+'.'+v['schema']['name']
    v['variant']='fp' if '_resbin_fp_' in v['bundle'] else 'nonfp'
    v['path_id_decimal']=str(v['path_id'])
    return v

def extract_enums():
    text=(ROOT/'derived/il2cpp/arm64-v8a/dump.cs').read_text(encoding='utf-8-sig')
    enums={}
    for m in re.finditer(r'^// Namespace: ([^\n]*)\n((?:(?!^// Namespace: ).*\n)*)',text,re.M):
        namespace,block=m.groups();namespace=namespace.strip()
        if namespace not in ('ResDef','BattleCore'):continue
        em=re.search(r'^(?:public|internal) enum (\w+)',block,re.M)
        if not em:continue
        values=re.findall(r'public const \w+ (\w+) = (-?\d+);',block)
        enums[namespace+'.'+em[1]]={'namespace':namespace,'name':em[1],'dump_line':text.count('\n',0,m.start())+2,'values':{n:int(v) for n,v in values}}
    return enums

def run():
    OUT.mkdir(parents=True,exist_ok=True)
    baseline=load('derived/config-decoded/resbin-index.json')
    layers=[('baseline','derived/config-decoded/resbin-index.json'),('native-recursive','derived/config-extended/resbin-index.json'),('variant-candidate','derived/config-layout-recovery/layout-index.json'),('recursive-variant-candidate','derived/config-layout-recovery-recursive/layout-index.json')]
    combined={identity(x):normalized(x) for x in baseline}
    for label,path in layers:
        for x in load(path):
            if label!='baseline' and x['status'] not in NATIVE_STATUSES|{CANDIDATE}:
                combined[identity(x)].setdefault('additional_rejects',[]).append({'layer':label,'reason':x.get('reason',x.get('native_reject_reason'))})
                continue
            old=combined[identity(x)]
            v=normalized(x);v['evidence_layer']=label;v['source_record_count']=old.get('header',{}).get('record_count')
            if x['status']==CANDIDATE:
                v['prior_reason']=old.get('reason',old.get('legacy_reason'))
                if not isinstance(v.get('schema'),str):v['schema']=old.get('schema')
            combined[identity(x)]=v
    tables=sorted(combined.values(),key=lambda x:(x['name'],x['variant'],x['bundle'],x['path_id']))
    counts=collections.Counter(x['status'] for x in tables)
    native=[x for x in tables if x['status'] in NATIVE_STATUSES];candidates=[x for x in tables if x['status']==CANDIDATE];unresolved=[x for x in tables if x['status'] not in NATIVE_STATUSES|{CANDIDATE}]
    enums=extract_enums();write(OUT/'enums.json',enums)
    attrs=next(x for x in native if x['schema']=='ResDef.AttrDataConfig')
    attrdoc=load(attrs['decoded_json']);write(OUT/'attribute-dictionary.json',{'source':attrs['decoded_json'],'records':attrdoc['records'],'enum':enums['ResDef.ActorAttrDataType'],'limit':'DataType short and AddType byte fields are not enum-typed in metadata; matching numeric names aids navigation but is not a blanket proof for every table.'})
    summary={'source_tables':len(tables),'source_unique_table_names':len({x['name'] for x in tables}),'status_counts':dict(counts),'native_backed_tables':len(native),'native_backed_records':sum(x['decoded_record_count'] for x in native),'native_backed_unique_table_names':len({x['name'] for x in native}),'companion_candidate_tables':len(candidates),'companion_candidate_records':sum(x['decoded_record_count'] for x in candidates),'unresolved_tables':len(unresolved),'enum_types':len(enums),'limits':['Source-table totals include fp/nonfp variants; records are not deduplicated unique game entities.','Native-backed means static native-reader/layout evidence plus byte roundtrip, not native/game execution proof.','Cross-variant candidates remain separate and are never promoted to native-backed totals.','Table values, enum names and described text are not a recovered runtime formula.']}
    write(OUT/'catalog.json',{'summary':summary,'tables':tables})
    write(OUT/'summary.json',summary);write(OUT/'unresolved.json',unresolved)
    with (OUT/'tables.csv').open('w',encoding='utf-8-sig',newline='') as f:
        keys=['name','variant','schema','status','decoded_record_count','decoded_json','decoded_csv','bundle','path_id','path_id_decimal']
        writer=csv.DictWriter(f,fieldnames=keys,extrasaction='ignore');writer.writeheader();writer.writerows({k:safe_csv_cell(t.get(k,'')) for k in keys} for t in tables)
    examples=[]
    for name in ['SkillBaseConfg','EquipConfig','EquipUpLevelConfig','BootyConfig','EquipBootyConfig','LongHunEquipBootyConfig','SacredEquipBootyConfig']:
        for table in native:
            if table['name']!=name:continue
            rows=load(table['decoded_json'])['records']
            examples.append({'schema':table['schema'],'variant':table['variant'],'source':table['decoded_json'],'records':rows[:2]})
    write(OUT/'core-examples.json',examples)
    # Markdown is deliberately a source-linked reading guide, not a new data authority.
    md=['# 玩法核心数据手册','',f"本轮合并目录覆盖 **{len(tables)} 份源表 / {summary['source_unique_table_names']} 个表名**（包含 fp/nonfp 变体）。",'',f"- 有对应原生读取布局证据并通过回编码：**{len(native)} 份，{summary['native_backed_records']:,} 条记录**。",f"- 伴生变体约束下恢复的候选布局：**{len(candidates)} 份，{summary['companion_candidate_records']:,} 条**，不计入上一项。",f"- 仍未完整恢复：**{len(unresolved)} 份**，逐表列入[未解清单](<../derived/gameplay-catalog/unresolved.json>)。",'- 数量按源表/源记录统计，不能把 fp/nonfp 重复记录当成不同玩法内容。','- 全程离线静态处理；没有运行 APK、调用游戏原生函数或访问游戏服务器。','','## 一、直接查数据','','[完整目录 JSON](<../derived/gameplay-catalog/catalog.json>) · [表目录 CSV](<../derived/gameplay-catalog/tables.csv>) · [核心实际样例](<../derived/gameplay-catalog/core-examples.json>) · [属性字典](<../derived/gameplay-catalog/attribute-dictionary.json>) · [枚举常量](<../derived/gameplay-catalog/enums.json>)','','[查询脚本](<../tools/query_gameplay.py>)默认只检索有原生布局证据的输出；候选变体必须显式加 `--allow-candidate`。字段可以用点号访问嵌套值。','','```powershell',"python -B 本地分析/tools/query_gameplay.py --list","python -B 本地分析/tools/query_gameplay.py --table ResDef.EquipConfig --where ItemID=11101","python -B 本地分析/tools/query_gameplay.py --table ResDef.SkillBaseConfg --where SkillID=1001","python -B 本地分析/tools/query_gameplay.py --table ResDef.EquipUpLevelConfig --where Type=1 --where Level=1","python -B 本地分析/tools/query_gameplay.py --table ResDef.BootyConfig --where BootyID=9999 --limit 30",'```','','## 二、核心配置入口','','|表与变体|记录数|证据类别|实际数据|','|---|---:|---|---|']
    for name in CORE:
        for table in tables:
            if table['name']!=name or 'decoded_json' not in table:continue
            kind='原生读取布局+回编码' if table['status'] in NATIVE_STATUSES else '伴生变体候选'
            md.append(f"|{table.get('schema',name)} ({table['variant']})|{table['decoded_record_count']:,}|{kind}|[JSON](<../{table['decoded_json']}>) · [CSV](<../{table['decoded_csv']}>)|")
    md+=['','## 三、已经拿到的具体玩法内容','','### 技能','','技能主表现在含完整 `AttrDamageData[2]` 和 `BuffID[4]`，不再只剩 SkillID。`SkillID=1001` 的中文表为“剑普攻”，说明“向正前方发射一颗子弹，攻击频率中等”；第一伤害项 `MagicType=0, AttrType=1, Param1=1, Param2=0, Param3=0`。这些是原表值，不代表最终伤害只有一次乘法。','',f"`BattleCore.SkillAttrDamageType` 枚举位于[声明证据](<../derived/il2cpp/arm64-v8a/dump.cs#L168359-L168386>)：`1=ATTR_TYPE_DMG_WEAPON`；其他分支包含无防御伤害、生命/魔法比例、五行、护盾等。原表的 AttrType 是 int，枚举仅提供同名数值导航，运行时分派须看算法证据。",'','### 装备与成长','','装备主表现在含 `ImpactData[4]` 和 `OpenHoleList[6]`。`ItemID=11101`“狼牙长矛”的第一属性项为 `DataType=2, AddType=1, Value=60, LvAddValue=0`；中文描述有“命中后 1.5 秒攻速加成，最多叠加 3 层”。描述文本不是已还原的 Buff 生效代码。','','同名属性枚举中 `2=Damage`、加成枚举中 `1=ABSOLUTE_VAL`，来自[属性与加成枚举声明](<../derived/il2cpp/arm64-v8a/dump.cs#L201208-L201319>)。原字段为 short/byte，不能仅因编号相等就对所有扩展系统作同样语义假设。','','强化表 `Type=1, Level=0/1/2` 的第一属性 `Value=0/5/10`；对应 `MoneyNum=100/200/400`、`DecomposeMoneyNum=0/100/300`。这里只展示真实三行，**不把有限样例外推为全等级线性公式**；全量 3,306 行可直接查询。','','### 掉落','','Booty 主表现在恢复 `ItemParam[3]`；样例 `BootyID=9999` 包含多条奖励记录，首项 `ItemType=10, ItemID=9999901, ItemCnt=1, ItemParam=[3,0,0], RandParam=10000, AwardCnt=22`。','','[奖励类型枚举](<../derived/il2cpp/arm64-v8a/dump.cs#L202122-L202194>)里 `10=BOOTY_ITEM_TYPE_EQUIP`。这不意味着每个奖励 ItemID 都必然存在于普通装备主表；特殊生成装备/模板必须结合调用路径另查。**RandParam=10000 不能在未还原对应抽样分支时直接称为 100% 掉率**；也不默认同组归一化或独立判定。','','## 四、原始数值与候选变体','','FP 字段保留 `__raw_int64`；递归扩展输出另有 `__decimal` 十进制字符串镜像，避免 JavaScript/表格软件损失 64 位整数精度。FP 算术的 Q32.32 还原不自动证明任一字段的时间、倍率或百分数单位。','',f'另有 {len(candidates)} 份候选变体：把已验证伴生表的 float/FP 宽度、嵌套结构转移后，要求每个已命名叶子值相等或经 float32 位级投影完全一致，并验证 CRC、记录数、EOF、逐字节回编码。无目标变体对应原生 unpack 证据，因此单独列类。额外字节/字符串保留为未命名字段，未赋玩法语义。','','[平面变体候选证据](<../derived/config-layout-recovery/layout-index.json>) · [递归变体候选证据](<../derived/config-layout-recovery-recursive/layout-index.json>)','','## 五、读取与复现边界','','- 扩展表布局及循环/目标偏移证据见[扩展解码报告](<核心配置扩展解码.md>)。','- 运算函数、概率/随机边界及伤害流程的证据等级见[算法还原报告](<客户端玩法算法还原.md>)。','- 本手册不声明完整游戏源码、全部关卡实际可运行、全部掉落算法或全部伤害分支已经恢复。','- 缺失 schema、不同版本列集、目标布局与伴生表值不一致均保留原字节与失败原因，不以猜测填表。','']
    (ROOT/'reports/玩法核心数据手册.md').write_text('\n'.join(md),encoding='utf-8')
    print(json.dumps(summary,ensure_ascii=False,indent=2))

if __name__=='__main__':run()
