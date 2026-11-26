# 勇者养成记 APK · 本地静态逆向分析归档

> **本轮已从“解包+声明导航”推进到核心配置解码与客户端数值算法还原。** 这是有来源、可查询、可复跑的离线分析档案，不是完整原始 C# 源码或可玩 Unity 工程。[原始 APK](<../com.tencent.tmgp.yzycj_227.apk>) 未改动；未安装/运行样本、调用游戏原生函数或联系游戏服务器。

## 优先看这三个入口

1. **[玩法核心数据手册](<reports/玩法核心数据手册.md>)**：技能、装备、强化、掉落的完整表入口、真实样例、属性/奖励枚举与查询命令。
2. **[客户端玩法算法还原](<reports/客户端玩法算法还原.md>)**：FP 运算、MT19937、概率判定、属性合并、伤害流程；标注已经还原与尚需传入的回调/上下文。
3. **[核心配置扩展解码](<reports/核心配置扩展解码.md>)**：定长数组、嵌套结构、原生循环与字段读取证据、边界和拒绝原因。

## 这次实际拿到什么

| 项目 | 本轮结果 | 证据入口 |
|---|---|---|
| 有原生读取布局证据的配置 | **444 份源表、363,190 条记录**；全部可从归档 JSON 回编码到原载荷 | [统一目录](<derived/gameplay-catalog/catalog.json>) |
| 伴生变体候选 | **23 份、14,679 条**；逐叶值严格比对/float32 位级投影、CRC、EOF、回编码；不计入上一项 | [平面候选](<derived/config-layout-recovery/layout-index.json>) / [递归候选](<derived/config-layout-recovery-recursive/layout-index.json>) |
| 仍未完整解码 | **78 份**，原始字节、schema 缺失/布局差异和拒绝原因保留 | [未解清单](<derived/gameplay-catalog/unresolved.json>) |
| 核心技能 | 两个命名空间各 **9,568 条**；含 `AttrDamageData[2]`、`BuffID[4]` | [技能 JSON](<derived/config-extended/ResDef/SkillBaseConfg.json>) / [CSV](<derived/config-extended/ResDef/SkillBaseConfg.csv>) |
| 装备 / 强化 | **2,161 / 3,306 条**；装备属性 4 槽、孔位 6 槽，强化属性 3 槽 | [装备](<derived/config-extended/ResDef/EquipConfig.json>) / [强化](<derived/config-extended/ResDef/EquipUpLevelConfig.json>) |
| 掉落 | 两个命名空间各 **37,525 条**；含 3 个奖励参数 | [掉落 JSON](<derived/config-extended/ResDef/BootyConfig.json>) / [CSV](<derived/config-extended/ResDef/BootyConfig.csv>) |
| 客户端数值实现 | 按 ARM64 指令还原的宿主 Python 参考实现、证据片段和测试；不是只罗列 RVA | [算法报告](<reports/客户端玩法算法还原.md>) |

545 份源表来自 439 个表名；fp/nonfp 是独立源表，统计未去重，不能理解成 363,190 个独立玩法实体。“原生布局证据+回编码”仍是静态证据，不是游戏原生执行等价性证明。候选变体没有目标原生布局证明，明确单列。`RandParam` 不会未经对应抽样分支验证就换算成掉率。

## 直接检索

[查询脚本](<tools/query_gameplay.py>)使用已归档输出，不运行游戏。示例（项目目录内）：

```powershell
python -B 本地分析/tools/query_gameplay.py --table ResDef.EquipConfig --where ItemID=11101
python -B 本地分析/tools/query_gameplay.py --table ResDef.SkillBaseConfg --where SkillID=1001
python -B 本地分析/tools/query_gameplay.py --table ResDef.EquipUpLevelConfig --where Type=1 --where Level=1
python -B 本地分析/tools/query_gameplay.py --table ResDef.BootyConfig --where BootyID=9999 --limit 30
python -B 本地分析/tools/query_gameplay.py --list
```

FP 保留原始 signed int64；递归输出有十进制字符串精度镜像。超过 `2^53` 的整数请用 Python 整数/文本导入，不经 JavaScript Number 或 Excel 自动数值转换后覆盖。CSV 做安全转义，JSON 保留原值。FP 算术 Q32.32 的恢复不自动证明所有配置字段的业务单位。

## 原有全包分析仍保留

- **4,626 个 APK 文件**，大小/SHA-256 清单；Unity **2018.4.8f1 / IL2CPP**。
- ARM64/ARMv7 各 **47 程序集、11,282 类型、70,973 方法声明**：[双 ABI 索引](<derived/il2cpp/index/README.md>)、[ARM64 声明](<derived/il2cpp/arm64-v8a/dump.cs>)。
- **3,942 / 3,942 个 AssetBundle、482,147 个对象**；655 份 TextAsset 原字节、64 份可读副本、40 张选择性预览：[Unity 对象索引](<derived/unity/object-index.csv>)、[TextAsset 来源](<derived/unity/textasset-index.json>)、[预览目录](<derived/unity/previews/>)。
- Android 主 DEX 6,052 类；14 个关键类反编译成功；全量 JADX 部分失败状态保留：[Android 报告](<reports/Android层分析.md>)。

## 归档导航与复核

[逆向分析总报告](<reports/逆向分析总报告.md>) · [资源与配置解码](<reports/资源与配置解码.md>) · [玩法与代码导航](<reports/玩法与代码导航.md>) · [复现与工具说明](<reports/复现与工具说明.md>)

[完整性校验](<inventory/verification.json>)核对原 APK/4,626 解包文件并记录当前派生/支持文件哈希；[输出校验](<inventory/output-validation.json>)核对转换结构和链接；[玩法扩展校验](<inventory/gameplay-validation.json>)通过 54 项回归、生成器与交付模型各 62 项宿主检查，并从原 SO 重解 115 个入口/10,460 条指令和 30 个跳表项。清单是当前快照，不是独立签名或运行时行为证明。

**读取当前索引，不要按目录 glob 合并所有文件。** fp/nonfp 同名来源现已使用独立输出路径；扩展目录保留的 24 个旧 JSON/CSV 标为 `UNINDEXED-stale`，不计入有效表。其逐文件路径/哈希见[扩展输出审计](<derived/config-extended/output-validation.json>)。

目录：[原始解包](<unpacked/>)、[派生产物](<derived/>)、[报告](<reports/>)、[工具与依赖](<tools/>)、[日志](<logs/>)、[清单](<inventory/>)。

未恢复完整游戏工程、全部伤害特殊分支/掉落执行链或服务器业务代码；不以这些限制替代本轮客户端玩法内容的实际恢复。仅在相应授权范围内研究，不再分发商业素材。
