# Android 层离线静态分析

## 范围、方法与结论边界

- 仅离线读取原 APK 与完整解包目录；未执行 APK、未启动模拟器、未访问配置域名或游戏服务器。未分析 Unity 资产内容或 IL2CPP（由主代理负责）。
- 结构解析：自编只读 DEX 表解析；androguard AXML 解码；asn1crypto 证书解析；可选 jadx 关键类反编译。仅向授权 Android 派生目录及本报告写入。
- **事实**表示包内直接证据；**推断/待证**表示由静态声明推导或尚缺运行时依据。组件导出、HTTP 候选或 SDK 打包均不等于可利用漏洞、实际调用或已发生隐私采集。
- 输出已对名称含 secret/token/password/appkey 等的值及 URL 查询参数脱敏；证书公开摘要、包名、组件名、版本号、域名不是秘密。jadx 代码为近似重建，不替代原始字节码。

## 1. Manifest 身份、SDK 与权限

| 项目 | 包内事实 |
|---|---|
| package | `com.tencent.tmgp.yzycj` |
| versionName | `1.227` |
| versionCode | `227` |
| compileSdkVersion | `None` |
| minSdkVersion | `18` |
| targetSdkVersion | `28` |
| maxSdkVersion | `None` |
| application.name | `未显式声明` |
| application.debuggable | `未显式声明` |
| application.allowBackup | `false` |
| application.extractNativeLibs | `未显式声明` |
| application.usesCleartextTraffic | `true` |
| application.networkSecurityConfig | `未显式声明` |

证据：[manifest_summary.json](<../derived/android/manifest_summary.json>)、[AndroidManifest.decoded.redacted.xml](<../derived/android/AndroidManifest.decoded.redacted.xml>)。

申请权限共 **26** 项（声明不等于授予/调用）：
- `android.permission.INTERNET`
- `android.permission.ACCESS_NETWORK_STATE`
- `android.permission.READ_PHONE_STATE`
- `android.permission.WRITE_EXTERNAL_STORAGE`
- `android.permission.READ_EXTERNAL_STORAGE`
- `android.permission.WAKE_LOCK`
- `android.permission.ACCESS_WIFI_STATE`
- `android.permission.VIBRATE`
- `android.permission.RECEIVE_BOOT_COMPLETED`
- `android.permission.BROADCAST_STICKY`
- `android.permission.RECEIVE_USER_PRESENT`
- `android.permission.KILL_BACKGROUND_PROCESSES`
- `android.permission.RECORD_AUDIO`
- `android.permission.SYSTEM_ALERT_WINDOW`
- `com.android.launcher.permission.INSTALL_SHORTCUT`
- `android.permission.GET_TASKS`
- `android.permission.WRITE_SETTINGS`
- `android.permission.MOUNT_UNMOUNT_FILESYSTEMS`
- `android.permission.READ_LOGS`
- `android.permission.ACCESS_FINE_LOCATION`
- `android.permission.RESTART_PACKAGES`
- `android.permission.REQUEST_INSTALL_PACKAGES`
- `android.permission.CHANGE_WIFI_STATE`
- `android.permission.READ_SMS`
- `android.permission.SEND_SMS`
- `com.asus.msa.SupplementaryDID.ACCESS`

完整清单：[manifest_permissions.csv](<../derived/android/manifest_permissions.csv>)。
- **复核重点但非已证漏洞：** 电话状态、外部存储、录音、精确位置、短信收发为需关注的敏感能力声明；悬浮窗、修改设置、安装未知应用涉及特殊授权。READ_LOGS、MOUNT_UNMOUNT_FILESYSTEMS 等并不因写入 Manifest 就让普通第三方应用获得系统级权限。未观察运行时授权、调用时机或数据流。

## 2. 启动入口、Unity 集成与导出组件

- **事实：Launcher Activity** 为 `com.dodjoy.unityplayer.DodUnityPlayerActivity`，具有 MAIN + LAUNCHER intent-filter。
- **事实：DEX 继承链**：`com.dodjoy.unityplayer.DodUnityPlayerActivity → android.app.Activity`。
- **静态方法体证据：** 启动类不是 UnityPlayerActivity 的子类；它直接继承 Activity，在 onCreate 中初始化 PlatformInterface、DodLib 并构造 UnityPlayer/setContentView，生命周期转发给平台桥接与 Unity。见 [jadx/com_dodjoy_unityplayer_DodUnityPlayerActivity.java](<../derived/android/jadx/com_dodjoy_unityplayer_DodUnityPlayerActivity.java>)（onCreate 第62–70行）。
- Manifest 的启动 Activity 带 `unityplayer.UnityActivity=true`；应用元数据含 `HaveDodNative=false`、`HaveHotIl2cpp=true`、`isSDKVersion=true`。这些仅是集成开关声明，不是对 native/IL2CPP 内容或实际加载的分析。
- 组件总数 **20**；分类：activity=16，receiver=1，service=2，provider=1。
- 下表“有效导出”依据目标 SDK 的显式值/传统默认值计算，未考虑运行时启停、安装环境及调用方权限；没有 intent-filter 的非导出组件不因此可从外部启动。

| 类型 | 名称 | exported 声明 | 静态有效导出 | 权限/authority |
|---|---|---|---|---|
| activity | `com.dodjoy.unityplayer.DodUnityPlayerActivity` | true | True | 未声明 |
| activity | `com.dodjoy.unitywebview.DodWebView` | None | False | 未声明 |
| activity | `com.soundcloud.android.crop.CropImageActivity` | None | False | 未声明 |
| receiver | `com.youme.im.NetworkStatusReceiver` | None | True | 未声明 |
| activity | `com.dodjoy.thirdPlatform.DodYSDKLoginActivity` | None | False | 未声明 |
| activity | `com.tencent.ysdk.module.realName.impl.RegisterRealNameActivity` | None | False | 未声明 |
| activity | `com.tencent.tauth.AuthActivity` | None | True | 未声明 |
| activity | `com.tencent.connect.common.AssistActivity` | None | False | 未声明 |
| activity | `com.tencent.tmgp.yzycj.wxapi.WXEntryActivity` | true | True | 未声明 |
| activity | `com.tencent.ysdk.module.user.impl.wx.qrcode.QRActivity` | None | False | 未声明 |
| activity | `com.tencent.ysdk.module.user.impl.freelogin.FreeLoginInfoActivity` | true | True | 未声明 |
| activity | `com.tencent.midas.proxyactivity.APMidasPayProxyActivity` | None | False | 未声明 |
| activity | `com.tencent.midas.wx.APMidasWXPayActivity` | true | True | 未声明 |
| activity | `com.tencent.midas.qq.APMidasQQWalletActivity` | true | True | 未声明 |
| activity | `com.tencent.midas.jsbridge.APWebJSBridgeActivity` | None | False | 未声明 |
| service | `com.tencent.tmdownloader.TMAssistantDownloadService` | false | False | 未声明 |
| activity | `com.tencent.tmgp.yzycj.module.submodule.inner.WebActivity` | None | False | 未声明 |
| service | `com.tencent.ysdk.module.sandbox.pipe.PipeService` | None | True | 未声明 |
| activity | `com.jakewharton.processphoenix.ProcessPhoenix` | false | False | 未声明 |
| provider | `com.tencent.ysdk.framework.YSDKInitProvider` | false | False | com.tencent.tmgp.yzycj.ysdk.ysdkinitprovider |

证据：[manifest_components.csv](<../derived/android/manifest_components.csv>)、[dex_classes.csv](<../derived/android/dex_classes.csv>)。按 target28 的传统默认值合计8个导出候选，包括未显式 exported、但带 intent-filter 的 YSDK PipeService 与网络状态 Receiver；这不等于权限绕过。系统受保护广播、组件内部校验及运行时状态尚未核验。导出 SDK 回调 Activity 是集成常见形态，未做参数注入验证。
- 包内两份 provider-path XML 含 external-path path="."，见 [com_tencent_ysdk_fileprovider_path.decoded.xml](<../derived/android/com_tencent_ysdk_fileprovider_path.decoded.xml>)、[dod_provider_paths.decoded.xml](<../derived/android/dod_provider_paths.decoded.xml>)；但本 Manifest **没有引用这两份路径资源的 FileProvider**，不能把未被引用的宽路径配置报告成已存在任意文件泄露。唯一声明的 Provider 是 exported=false 的 YSDKInitProvider。

## 3. 网络策略

- **事实：** `usesCleartextTraffic=true`；`networkSecurityConfig=None`。
- 解包 res/xml 中识别到 network-security-config：[]。
- **推断边界：** 显式允许明文意味着平台层通常不阻止 HTTP；不能据此证明某候选 URL 被访问、链路遭攻击或存在可利用漏洞。WebView、原生网络栈及系统版本的实际处理未动态核验。

## 4. 第三方 SDK 的明确证据

| SDK/桥接 | DEX 定义类数 | 直接类名证据 |
|---|---:|---|
| Unity | 92 | `com.unity3d.player.GoogleARCoreApi`、`com.unity3d.player.GoogleVrApi`、`com.unity3d.player.GoogleVrProxy$1` |
| 腾讯 YSDK | 739 | `com.tencent.ysdk.BuildConfig`、`com.tencent.ysdk.R$anim`、`com.tencent.ysdk.R$attr` |
| 腾讯 Midas | 178 | `com.pay.AndroidPay`、`com.pay.api.APPayGameService`、`com.pay.api.APPayOpenService` |
| 腾讯 QQ/OpenSDK | 165 | `com.tencent.connect.a.a`、`com.tencent.connect.auth.AuthAgent$1$1`、`com.tencent.connect.auth.AuthAgent$1` |
| 微信 OpenSDK | 134 | `com.tencent.mm.opensdk.channel.MMessageActV2$Args`、`com.tencent.mm.opensdk.channel.MMessageActV2`、`com.tencent.mm.opensdk.channel.a.a$a` |
| 腾讯 Bugly | 263 | `com.tencent.bugly.Bugly`、`com.tencent.bugly.BuglyStrategy$a`、`com.tencent.bugly.BuglyStrategy` |
| 腾讯 Beacon | 238 | `com.tencent.beacon.core.BeaconIdJNI`、`com.tencent.beacon.core.a.a.a`、`com.tencent.beacon.core.a.a.b` |
| 腾讯 TBS/X5 | 335 | `com.tencent.smtt.export.external.DexClassLoaderProvider$1`、`com.tencent.smtt.export.external.DexClassLoaderProvider$2`、`com.tencent.smtt.export.external.DexClassLoaderProvider$SpeedyDexClassLoader` |
| 腾讯 Turing/设备风控 | 212 | `com.tencent.turingfd.sdk.R`、`com.tencent.turingfd.sdk.ams.ad.A`、`com.tencent.turingfd.sdk.ams.ad.B` |
| 云知声 Unisound | 194 | `com.unisound.a.a`、`com.unisound.b.a.b`、`com.unisound.b.a.c` |
| DMLT Tracking | 45 | `com.dmlt.tracking.BuildConfig`、`com.dmlt.tracking.R$anim`、`com.dmlt.tracking.R$attr` |
| 移动安全联盟 MSA/OAID | 84 | `com.asus.msa.SupplementaryDID.IDidAidlInterface`、`com.asus.msa.sdid.BuildConfig`、`com.asus.msa.sdid.IDIDBinderStatusListener` |
| Dodjoy 桥接 | 206 | `com.dodjoy.androidbase.BuildConfig`、`com.dodjoy.androidbase.R$anim`、`com.dodjoy.androidbase.R$attr` |

- **事实：** [SdkCfg.bytes](<../unpacked/assets/SdkCfg.bytes>) 声明 `DodStaticsName=ysdk`。
- **事实：** 包含 [ysdkconf.ini](<../unpacked/assets/ysdkconf.ini>)、[ysdkinfo.ini](<../unpacked/assets/ysdkinfo.ini>)、YSDK 公钥资源与 [MidasPay.zip](<../unpacked/assets/MidasPay.zip>)；配置已脱敏写入 [supplemental_configs.redacted.json](<../derived/android/supplemental_configs.redacted.json>)。
- **明确版本证据：** [ysdkinfo.ini](<../unpacked/assets/ysdkinfo.ini>) 标注 `VERSION=1.8.1`、`DATETIME=20210817`；该值属于包内 YSDK 版本标注，不是游戏版本或在线更新后版本。支付 ZIP 成员名标注 `MidasPay_1.6.9w_171`、`MidasCore_1.6.9w_171` 等，运营商子模块另有1.6.8/1.6.9，不能把这些混为单一 SDK 总版本。
- **调用点证据：** [jadx/com_dodjoy_thirdPlatform_ThirdPlatform.java](<../derived/android/jadx/com_dodjoy_thirdPlatform_ThirdPlatform.java>) 的 initSdk 中调用 `YSDKApi.onCreate/handleIntent/init`，支付分支调用 `YSDKApi.recharge`；[jadx/com_dodjoy_thirdPlatform_ThirdPlatformFactory.java](<../derived/android/jadx/com_dodjoy_thirdPlatform_ThirdPlatformFactory.java>) 反射构造该 ThirdPlatform。Manifest 声明 YSDK 实名、免登回调、Midas支付Activity及YSDKInitProvider。结合包名、资源、组件和具体调用点，确认这是 YSDK/Midas 适配集成，仍不声称已执行登录或支付。
- SDK 归属依据包名前缀及明确资源，不把通用类名/域名当成 SDK 版本证明；按包名前缀计数可能含适配/兼容类。仅能确认打包，不证明所有 SDK 在本次运行启用。
- ZIP/JAR 内成员仅列目录、大小和 CRC，不执行或加载：[sdk_archive_members.csv](<../derived/android/sdk_archive_members.csv>)（15 个成员）。类证据：[sdk_evidence.json](<../derived/android/sdk_evidence.json>)。

## 5. 多渠道 Config 配置：不把 dev 默认当正式

- **事实：** 发现 **30** 份 Config*.bytes；按 verurl scheme：`{"http": 8, "https": 22}`。
- **事实：** [Config.bytes](<../unpacked/assets/Config.bytes>) 是 `dev_android`、版本 `1.5`、内网 `192.168.1.2` HTTP、`bugly_debug=1`。它只是打包默认候选，**不能据此断言本包正式请求内网**。多个候选仍使用 dev_android 字段但指向不同域名，不能单凭 channel 文本判定开发/正式。
- **Android桥接静态选择链已确认：** Manifest 应用元数据 `DOD_PLATFORM_NAME=hardtime`、`ChannelId=550`；PlatformConfig.Init 读取 ApplicationInfo.metaData；DodLibConfig.Init 读取平台名；GetConfigBytesConfig 按 `Config_%s.bytes` 组织资源名。因此这条已反编译的Android读取路径指向 [Config_hardtime.bytes](<../unpacked/assets/Config_hardtime.bytes>)，其中 `version=2.10`、`verurl=http://web.ysr.hardtime.cn/ver/check_ver.php`、`bugly_debug=0`，虽然 channel 字段仍是dev_android。证据链见 [android_static_findings.json](<../derived/android/android_static_findings.json>)、[jadx/com_dodjoy_dodlib_DodLibConfig.java](<../derived/android/jadx/com_dodjoy_dodlib_DodLibConfig.java>)（第30–44、63–74行）、[AndroidManifest.decoded.redacted.xml](<../derived/android/AndroidManifest.decoded.redacted.xml>)（第60–61行）。
- **待证边界：** 上述是配置好的Android静态代码分支，不是运行结果；不证明方法确已成功执行、该URL实际可达、属于生产环境、Unity复用此文件或没有后续覆盖。各 Config.version 与 Manifest.versionName/versionCode 是不同维度，不可混用。
- **格式异常但原件未改：** [Config_om_android.bytes](<../unpacked/assets/Config_om_android.bytes>) 尾部有逗号，严格JSON失败；派生副本仅去尾逗号解析以保留30份完整盘点，原始错误及规范化标记见 [channel_config_values.redacted.json](<../derived/android/channel_config_values.redacted.json>)。

| 配置文件 | channel | 配置版本 | verurl（仅离线读取） | bugly_debug |
|---|---|---|---|---:|
| [Config.bytes](<../unpacked/assets/Config.bytes>) | `dev_android` | 1.5 | `http://192.168.1.2/agame/ver/check_ver.php` | 1 |
| [Config_chitu_android.bytes](<../unpacked/assets/Config_chitu_android.bytes>) | `chitu_android` | 1.1 | `https://web-ysr.caiyuehuyu.com/ver/check_ver.php` | 0 |
| [Config_guanwang.bytes](<../unpacked/assets/Config_guanwang.bytes>) | `dev_android` | 1.3 | `http://web.android.a3game.baoliangnet.com/ver/check_ver.php` | 0 |
| [Config_gz_a3_glwg_and.bytes](<../unpacked/assets/Config_gz_a3_glwg_and.bytes>) | `gz_a3_glwg_and` | 1.1 | `https://web-ysr.baoliangnet.com/ver/check_ver.php` | 0 |
| [Config_hardtime.bytes](<../unpacked/assets/Config_hardtime.bytes>) | `dev_android` | 2.10 | `http://web.ysr.hardtime.cn/ver/check_ver.php` | 0 |
| [Config_hardtime_test.bytes](<../unpacked/assets/Config_hardtime_test.bytes>) | `dev_android` | 2.1 | `http://web.ysr.hardtime.cn/ver/check_ver.php` | 0 |
| [Config_huiyao.bytes](<../unpacked/assets/Config_huiyao.bytes>) | `dev_android` | 3.16 | `http://web.ysr.qincaogame.com/ver/check_ver.php` | 0 |
| [Config_huiyao_small_zuqiu.bytes](<../unpacked/assets/Config_huiyao_small_zuqiu.bytes>) | `huiyao_small_zuqiu` | 1.7 | `http://web.ysr.qincaogame.com/ver/check_ver.php` | 0 |
| [Config_huiyaoios_and.bytes](<../unpacked/assets/Config_huiyaoios_and.bytes>) | `dev_android` | 3.15 | `http://web.ysr.ios.qincaogame.com/ver/check_ver.php` | 0 |
| [Config_om_android.bytes](<../unpacked/assets/Config_om_android.bytes>) | `om_android` | 1.1 | `http://web.om.a3game.topfunsoft.com/ver/check_ver.php` | 0 |
| [Config_web_a3_gdt_small.bytes](<../unpacked/assets/Config_web_a3_gdt_small.bytes>) | `web_a3_gdt_small` | 1.2 | `https://wxa3-web.dodjoy.com/ver/check_ver.php` | 0 |
| [Config_web_a3_kuaishou_small.bytes](<../unpacked/assets/Config_web_a3_kuaishou_small.bytes>) | `web_a3_kuaishou_small` | 1.2 | `https://wxa3-web.dodjoy.com/ver/check_ver.php` | 0 |
| [Config_web_a3_toutiao_small.bytes](<../unpacked/assets/Config_web_a3_toutiao_small.bytes>) | `web_a3_toutiao_small` | 1.2 | `https://wxa3-web.dodjoy.com/ver/check_ver.php` | 0 |
| [Config_web_baidu_small.bytes](<../unpacked/assets/Config_web_baidu_small.bytes>) | `web_baidu_small` | 1.2 | `https://wxa3-web.dodjoy.com/ver/check_ver.php` | 0 |
| [Config_web_douyin_and_small.bytes](<../unpacked/assets/Config_web_douyin_and_small.bytes>) | `web_douyin_and_small` | 1.2 | `https://wxa3-web.dodjoy.com/ver/check_ver.php` | 0 |
| [Config_web_douyin_guanwang_small.bytes](<../unpacked/assets/Config_web_douyin_guanwang_small.bytes>) | `web_douyin_guanwang_small` | 1.2 | `https://wxa3-web.dodjoy.com/ver/check_ver.php` | 0 |
| [Config_web_douyin_xfc_small.bytes](<../unpacked/assets/Config_web_douyin_xfc_small.bytes>) | `web_douyin_xfc_small` | 1.2 | `https://wxa3-web.dodjoy.com/ver/check_ver.php` | 0 |
| [Config_web_gdt_small.bytes](<../unpacked/assets/Config_web_gdt_small.bytes>) | `web_gdt_small` | 1.2 | `https://wxa3-web.dodjoy.com/ver/check_ver.php` | 0 |
| [Config_web_kuaishou_small.bytes](<../unpacked/assets/Config_web_kuaishou_small.bytes>) | `web_kuaishou_small` | 1.2 | `https://wxa3-web.dodjoy.com/ver/check_ver.php` | 0 |
| [Config_web_wx_350_and.bytes](<../unpacked/assets/Config_web_wx_350_and.bytes>) | `dev_android` | 2.11 | `https://wxa3-web.shanweiyule.com/ver/check_ver.php` | 0 |
| [Config_web_wx_and.bytes](<../unpacked/assets/Config_web_wx_and.bytes>) | `dev_android` | 3.11 | `https://wxa3-web.dodjoy.com/ver/check_ver.php` | 0 |
| [Config_web_wx_hy_and.bytes](<../unpacked/assets/Config_web_wx_hy_and.bytes>) | `dev_android` | 2.10 | `https://web.ysr.h5.qincaogame.com/ver/check_ver.php` | 0 |
| [Config_web_wx_same_and.bytes](<../unpacked/assets/Config_web_wx_same_and.bytes>) | `web_wx_same_and` | 1.3 | `https://wxa3-web.dodjoy.com/ver/check_ver.php` | 0 |
| [Config_web_wx_snpz_small.bytes](<../unpacked/assets/Config_web_wx_snpz_small.bytes>) | `web_wx_snpz_small` | 1.1 | `https://qq-web.sanxr.cn/ver/check_ver.php` | 0 |
| [Config_web_wx_xh_and_small.bytes](<../unpacked/assets/Config_web_wx_xh_and_small.bytes>) | `web_wx_xh_and_small` | 1.1 | `https://web-yzycj.hncqkj.cn/ver/check_ver.php` | 0 |
| [Config_web_wx_xw_and.bytes](<../unpacked/assets/Config_web_wx_xw_and.bytes>) | `web_wx_xw_and` | 1.2 | `https://wxa3-web.ziyouxi.com/ver/check_ver.php` | 0 |
| [Config_web_wx_xw_and_2.bytes](<../unpacked/assets/Config_web_wx_xw_and_2.bytes>) | `web_wx_xw_and_2` | 1.2 | `https://wxa3-web.ziyouxi.com/ver/check_ver.php` | 0 |
| [Config_web_wx_xw_and_full.bytes](<../unpacked/assets/Config_web_wx_xw_and_full.bytes>) | `web_wx_xw_and_full` | 2.0 | `https://wxa3-web.ziyouxi.com/ver/check_ver.php` | 0 |
| [Config_xianxian_android.bytes](<../unpacked/assets/Config_xianxian_android.bytes>) | `xianxian_and` | 1.1 | `https://web-xx.ysr.xxyx.cn/ver/check_ver.php` | 0 |
| [Config_xianxian_android_small.bytes](<../unpacked/assets/Config_xianxian_android_small.bytes>) | `xianxian_android_small` | 1.1 | `https://web-xx.ysr.xxyx.cn/ver/check_ver.php` | 0 |

证据（含 SHA-256）：[channel_configs.json](<../derived/android/channel_configs.json>)、[channel_configs.csv](<../derived/android/channel_configs.csv>)。
- 隐私文本 **声明** 涉及存储、电话与设备标识信息；这属于文案，不是实际采集数据流证据。[PrivacyConfig.json](<../unpacked/assets/PrivacyConfig.json>) 严格 JSON 解析成功：`False`；保留原始错误及宽松解析结果，不修改源文件。

## 6. DEX 包/类统计

| DEX | 字节数 | 定义类数 | string_ids | method_ids（含引用） |
|---|---:|---:|---:|---:|
| [classes.dex](<../../本地分析/unpacked/classes.dex>) | 7090504 | 6052 | 53598 | 49988 |

- [39285EFA.dex](<../unpacked/assets/39285EFA.dex>) 共71500字节，头部不是标准 `dex\n` 魔数，因此未作DEX类解析；仅记录摘要和前16字节于 [nonstandard_dex_candidates.json](<../derived/android/nonstandard_dex_candidates.json>)。仅靠扩展名或非标准头不能认定加壳、加密或恶意，亦不能当成有效第二DEX。
- [ysdk_hackdex.jar](<../unpacked/assets/ysdk_hackdex.jar>) 中有一个436字节的嵌套classes.dex成员，仅列ZIP目录，未当作根DEX总量；资源存在不证明它或其他assets文件被加载执行。
- 精确包名按类去掉末段统计；同包跨 DEX 不重复定义为不同 SDK。完整结果：[dex_summary.json](<../derived/android/dex_summary.json>)、[dex_packages.csv](<../derived/android/dex_packages.csv>)、[dex_classes.csv](<../derived/android/dex_classes.csv>)。

## 7. 签名证书摘要

- 签名结构存在性：No APK Signing Block immediately before central directory；v1 certificate container present。
- Subject：`Common Name: a, Organizational Unit: a, Organization: a, Locality: a, State/Province: a, Country: a`；Issuer：`Common Name: a, Organizational Unit: a, Organization: a, Locality: a, State/Province: a, Country: a`。
- 有效期：`2019-12-10T07:06:29+00:00` 至 `2044-12-03T07:06:29+00:00`；证书签名算法：`sha256_rsa`。
- SHA-256：`fe0c05cb8fa98464f0742676fea12b04c06f77ecabc171ff1cbe5dd62569036c`。
- SHA-1：`aafb063cea71a33b2c6e0b463c6b0e59c997a538`；MD5：`5d45e1d063d307dbdea2a216ce947716`（仅历史比对标识，不作为安全性推荐）。
- **限制：** 仅提取证书及摘要，未验证 APK/JAR 签名数学正确性、各条目完整性或证书信任链。不能据此宣称原包可信/未篡改，也不因开发者自签名认定异常。
- 证据：[certificates.json](<../derived/android/certificates.json>)。

## 8. jadx 与失败说明

- 状态：`completed`；是否尝试：`True`。
- `com.dodjoy.unityplayer.DodUnityPlayerActivity`：exit=0；[com_dodjoy_unityplayer_DodUnityPlayerActivity.java](<../derived/android/jadx/com_dodjoy_unityplayer_DodUnityPlayerActivity.java>)；日志 [com_dodjoy_unityplayer_DodUnityPlayerActivity.log](<../derived/android/jadx/com_dodjoy_unityplayer_DodUnityPlayerActivity.log>)。
- `com.dodjoy.thirdPlatform.ThirdPlatform`：exit=0；[com_dodjoy_thirdPlatform_ThirdPlatform.java](<../derived/android/jadx/com_dodjoy_thirdPlatform_ThirdPlatform.java>)；日志 [com_dodjoy_thirdPlatform_ThirdPlatform.log](<../derived/android/jadx/com_dodjoy_thirdPlatform_ThirdPlatform.log>)。
- `com.dodjoy.dodlib.DodLibConfig`：exit=0；[com_dodjoy_dodlib_DodLibConfig.java](<../derived/android/jadx/com_dodjoy_dodlib_DodLibConfig.java>)；日志 [com_dodjoy_dodlib_DodLibConfig.log](<../derived/android/jadx/com_dodjoy_dodlib_DodLibConfig.log>)。
- `com.dodjoy.dodlib.DodLibMeta`：exit=0；[com_dodjoy_dodlib_DodLibMeta.java](<../derived/android/jadx/com_dodjoy_dodlib_DodLibMeta.java>)；日志 [com_dodjoy_dodlib_DodLibMeta.log](<../derived/android/jadx/com_dodjoy_dodlib_DodLibMeta.log>)。
- `com.dodjoy.dodlib.DodLib`：exit=0；[com_dodjoy_dodlib_DodLib.java](<../derived/android/jadx/com_dodjoy_dodlib_DodLib.java>)；日志 [com_dodjoy_dodlib_DodLib.log](<../derived/android/jadx/com_dodjoy_dodlib_DodLib.log>)。
- `com.dodjoy.platform.PlatformInterface`：exit=0；[com_dodjoy_platform_PlatformInterface.java](<../derived/android/jadx/com_dodjoy_platform_PlatformInterface.java>)；日志 [com_dodjoy_platform_PlatformInterface.log](<../derived/android/jadx/com_dodjoy_platform_PlatformInterface.log>)。
- `com.dodjoy.utils.DodSdkEngine`：exit=0；[com_dodjoy_utils_DodSdkEngine.java](<../derived/android/jadx/com_dodjoy_utils_DodSdkEngine.java>)；日志 [com_dodjoy_utils_DodSdkEngine.log](<../derived/android/jadx/com_dodjoy_utils_DodSdkEngine.log>)。
- `com.dodjoy.platform.PlatformConfig`：exit=0；[com_dodjoy_platform_PlatformConfig.java](<../derived/android/jadx/com_dodjoy_platform_PlatformConfig.java>)；日志 [com_dodjoy_platform_PlatformConfig.log](<../derived/android/jadx/com_dodjoy_platform_PlatformConfig.log>)。
- `com.dodjoy.thirdPlatform.ThirdPlatformFactory`：exit=0；[com_dodjoy_thirdPlatform_ThirdPlatformFactory.java](<../derived/android/jadx/com_dodjoy_thirdPlatform_ThirdPlatformFactory.java>)；日志 [com_dodjoy_thirdPlatform_ThirdPlatformFactory.log](<../derived/android/jadx/com_dodjoy_thirdPlatform_ThirdPlatformFactory.log>)。
- `com.dodjoy.privacy.DodPrivacyHelper`：exit=0；[com_dodjoy_privacy_DodPrivacyHelper.java](<../derived/android/jadx/com_dodjoy_privacy_DodPrivacyHelper.java>)；日志 [com_dodjoy_privacy_DodPrivacyHelper.log](<../derived/android/jadx/com_dodjoy_privacy_DodPrivacyHelper.log>)。
- `com.dodjoy.thirdPlatform.DodYSDKLoginActivity`：exit=0；[com_dodjoy_thirdPlatform_DodYSDKLoginActivity.java](<../derived/android/jadx/com_dodjoy_thirdPlatform_DodYSDKLoginActivity.java>)；日志 [com_dodjoy_thirdPlatform_DodYSDKLoginActivity.log](<../derived/android/jadx/com_dodjoy_thirdPlatform_DodYSDKLoginActivity.log>)。
- `com.tencent.ysdk.api.YSDKApi`：exit=0；[com_tencent_ysdk_api_YSDKApi.java](<../derived/android/jadx/com_tencent_ysdk_api_YSDKApi.java>)；日志 [com_tencent_ysdk_api_YSDKApi.log](<../derived/android/jadx/com_tencent_ysdk_api_YSDKApi.log>)。
- `com.tencent.midas.api.APMidasPayAPI`：exit=0；[com_tencent_midas_api_APMidasPayAPI.java](<../derived/android/jadx/com_tencent_midas_api_APMidasPayAPI.java>)；日志 [com_tencent_midas_api_APMidasPayAPI.log](<../derived/android/jadx/com_tencent_midas_api_APMidasPayAPI.log>)。
- `com.unity3d.player.UnityPlayerActivity`：exit=0；[com_unity3d_player_UnityPlayerActivity.java](<../derived/android/jadx/com_unity3d_player_UnityPlayerActivity.java>)；日志 [com_unity3d_player_UnityPlayerActivity.log](<../derived/android/jadx/com_unity3d_player_UnityPlayerActivity.log>)。
- 完整结果：[jadx_status.json](<../derived/android/jadx_status.json>)；非零退出保留日志及已生成片段，不把反编译失败当成混淆/加固的唯一证明。

- **全量主DEX反编译（非完全成功）：** jadx1.5.6、JDK、`-Xmx2G -j3 --no-res`，exit=`3`，耗时43.55秒，保留 **3567** 个Java文件。该文件数与6052个DEX定义类不相等，嵌套/匿名类可能合并。状态 [jadx_full_status.json](<../derived/android/jadx_full_status.json>)；原始日志 [jadx_full.log](<../derived/android/jadx_full.log>)；源码位于 [jadx-full](<../derived/android/jadx-full/>)。
- 日志仅汇总1个ERROR，不代表只有一个方法不完整：扫描有 **15** 个 `Method not decompiled` 占位、**1** 处严重JADX_ERROR。完整定位见 [java_decompilation_issues.csv](<../derived/android/java_decompilation_issues.csv>)。严重错误为RegionMakerVisitor的JadxOverflowException，见 [jadx-full/sources/com/tencent/tmassistantbase/util/e.java](<../derived/android/jadx-full/sources/com/tencent/tmassistantbase/util/e.java>) 第33行；保留原始字节码和错误，不虚报源码恢复成功。
- 全量派生代码对带凭据关键字、长十六进制字符串常量和URL查询做了脱敏（597行）。这是保守暴露控制，不保证识别所有秘密，也不可把删改过的派生代码重新编译当原始源。

## 9. 局限与复现

- 不实施联网、漏洞利用、登录/支付调用、动态权限测试；无法确认服务器状态、生产配置、SDK 活跃状态、隐私同意前后行为或运行时组件配置。
- DEX strings 的精确业务解释及 native/Unity 配置选择不在本报告保证范围。没有报告“已证实可利用漏洞”。
- 复现脚本：[analyze_android.py](<../tools/analyze_android.py>)。默认无参等同 `--phase full`，完整重算Manifest/配置/DEX/证书/报告并复用已有jadx状态，不下载依赖、不联网；`--jadx` 补做缺失关键类，已成功类不会重复；`--jadx-full` 明确重新执行全量DEX反编译。只需独立配置或DEX结构阶段时用 `--phase config` 或 `--phase structure`。pycache已禁用，Java临时目录限定在Android派生目录。
```powershell
$env:PYTHONDONTWRITEBYTECODE='1'
& 'C:\Users\Admin\.dsh\dsh-runtimes\dsh-primary-runtime\dependencies\python\python.exe' '本地分析\tools\analyze_android.py' --phase full --jadx --jadx-full 2>&1 | Out-File '本地分析\derived\android\reproduce.log' -Encoding utf8
if ($LASTEXITCODE -ne 0) { exit $LASTEXITCODE }
```
- 输入摘要与运行信息：[run_summary.json](<../derived/android/run_summary.json>)；解析失败/限制：[errors.json](<../derived/android/errors.json>)。
- `config_strict_json:本地分析/unpacked/assets/Config_om_android.bytes`：JSONDecodeError — Expecting property name enclosed in double quotes: line 13 column 1 (char 269)
- `dex:本地分析/unpacked/assets/39285EFA.dex`：ValueError — Not a standard DEX; no speculative decoding attempted
