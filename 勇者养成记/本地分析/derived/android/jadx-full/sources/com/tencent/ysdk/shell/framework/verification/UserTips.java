package com.tencent.ysdk.shell.framework.verification;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class UserTips {
    private static final java.lang.String TAG = "YSDK_TIPS";

    public static void showAndCheckIsYSDKInited(java.lang.String str) {
        try {
            if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isInit()) {
                return;
            }
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "******************* 游戏接入过程中请重点关注  *********************");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "* 在调用" + str + "之前需要先调用YSDKApi.init()进行初始化");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "***************************************************************");
            android.widget.Toast.makeText(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext(), "在调用" + str + "之前需要先调用YSDKApi.init()进行初始化", 1).show();
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.shell.libware.file.Logger.d(TAG, e.getLocalizedMessage());
        }
    }

    public static void showBeaconErrorTips() {
        if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isDev()) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "******************* 游戏接入过程中请重点关注  *********************");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "* SDK初始化会存在下面的异常，该异常并不影响正常的登录请求，可忽略不用关注：");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "[REDACTED]");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "***************************************************************");
        }
    }

    public static void showBeaconSoSelfCheck(java.lang.String str) {
        com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "******************* 游戏接入过程中请重点关注  *********************");
        com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "* 需要将" + str + "拷贝到对应的jniLibs目录下");
        com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "***************************************************************");
        android.widget.Toast.makeText(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext(), "需要将" + str + "拷贝到对应的jniLibs目录下！", 1).show();
    }

    public static void showEndSelfCheck() {
        if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isDev()) {
            com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.module.BaseModuleSelfCheck.LOG_TAG, "*   SDK自检模块检测结束,游戏可以结合检测过程日志确认配置是否正确   *");
            com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.module.BaseModuleSelfCheck.LOG_TAG, "***************************************************************");
        }
    }

    public static void showHttpsErrorTips() {
        com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "******************* 游戏接入过程中请重点关注  *********************");
        com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "* 当游戏调用YSDK接口报上面的异常导致游戏无法登录时，请先检查手机的时间设置是否正确,YSDK的登录模块使用HTTPS，对设备时间有要求。");
        com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "***************************************************************");
        android.widget.Toast.makeText(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext(), "系统异常，请调整手机时间到当地时间并重启后重试！", 1).show();
    }

    public static void showIconJSDebug() {
        com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "******************* 游戏接入过程中请重点关注  *********************");
        com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "* SDK 游戏内icon 的JS调试模式已开启,上线前请关闭");
        com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "***************************************************************");
        android.widget.Toast.makeText(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext(), "游戏内icon 的JS调试模式已开启,上线前请关闭！", 1).show();
    }

    public static void showInitChannelTips() {
        if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isDev()) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "******************* 游戏接入过程中请重点关注  *********************");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "* 如果存在下面的异常并不会影响游戏的正常使用和登录，游戏可以不用关注。");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "*     java.io.FileNotFoundException: channel.ini");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "***************************************************************");
        }
    }

    public static void showLoginNotifyTips() {
        if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isDev()) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "******************* 游戏接入过程中请重点关注  *********************");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "* LoginNotify 主要返回登陆相关的信息,回调设置请参考YSDK Demo");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "* LoginNotify 中对应回调内容以及flag说明请参照：http://wiki.open.qq.com/wiki/YSDK_Android_%E5%B8%B8%E9%87%8F%E6%9F%A5%E8%AF%A2");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "***************************************************************");
        }
    }

    public static void showMidasErrorTips() {
        if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isDev()) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "******************* 游戏接入过程中请重点关注  *********************");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "* 如果游戏支付失败,常见的错误码以及对应的解决方案，可以参考下面的链接：");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "* 支付错误码：http://wiki.open.qq.com/wiki/Android%E5%B8%B8%E8%A7%81%E9%94%99%E8%AF%AF%E7%A0%81%E6%9F%A5%E8%AF%A2");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "***************************************************************");
        }
    }

    public static void showMidasInitTips() {
        if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isDev()) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "******************* 游戏接入过程中请重点关注  *********************");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "* YSDK已经集成midas，游戏在接入过程中请不要再单独初始化或者调用米大师相关接口");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "* YSDK关于米大师接入、游戏币模式、道具直购等说明，请参考YSDK wiki：");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "* YSDK 支付接入wiki：http://wiki.open.qq.com/wiki/%E7%B1%B3%E5%A4%A7%E5%B8%88%E7%AE%80%E4%BB%8B");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "* YSDK 从1.2.2版本开始切换为midas集成版，该版本支付不再依赖腾讯充值APP，而且接入有较大调整。游戏接入时可以参考文档更新");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "* YSDK 支付接入wiki：http://wiki.open.qq.com/wiki/%E6%94%AF%E4%BB%98%EF%BC%88Midas%EF%BC%89%E6%8E%A5%E5%85%A5");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "***************************************************************");
        }
    }

    public static void showMidasYSDKActivityIsNullError() {
        if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isDev()) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "******************* 游戏接入过程中请重点关注  *********************");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "* YSDK拉起支付时的上下文为空，无法正常拉起支付，请检查：");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "*    1. 是否已经完成了YSDK的初始化");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "*    2. 是否调用了YSDK的onDestory？YSDK的onDestory函数请在应用退出时调用，一般推荐在Main Activity的onDestory调用");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "***************************************************************");
        }
    }

    public static void showNoPermissionTips() {
        com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "******************* 游戏接入过程中请重点关注  *********************");
        com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "* 当游戏调用接口报下面的错误时，表示游戏尚无对应YSDK环境权限。");
        com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "* \"{\"ret\":-2,\"msg\":\"client request's app is not existed\"}\" ");
        com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "* 游戏可以按照下面的链接在open官网开通对应的权限。");
        com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "* YSDK 环境权限说明：http://wiki.open.qq.com/wiki/YSDK%E4%BB%8B%E7%BB%8D");
        com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "***************************************************************");
    }

    public static void showPayModuleNotGoodTips() {
        if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isDev()) {
            com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.module.BaseModuleSelfCheck.LOG_TAG, "******************* 游戏接入过程中请重点关注  *********************");
            com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.module.BaseModuleSelfCheck.LOG_TAG, "* 支付模块初始化失败，如果没有接入支付模块，则不用关注，如果接入支付模块，请确认ysdkconf.ini中支付的offerid信息是否配置正确");
            com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.module.BaseModuleSelfCheck.LOG_TAG, "***************************************************************");
        }
    }

    public static void showQQInitTips() {
        if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isDev()) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "******************* 游戏接入过程中请重点关注  *********************");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "* 注意：目前的OpenSDK存在下面的异常，该异常并不影响正常的登录请求，可忽略不用关注：");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "* java.lang.ClassNotFoundException: com.tencent.stat.StatConfig");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "***************************************************************");
        }
    }

    public static void showQQLoginTips() {
        if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isDev()) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "******************* 游戏接入过程中请重点关注  *********************");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "* 游戏接入过程中，如果遇到手Q登录无回调、手Q无法登录、手Q弹100044、100416等错误，请按照下面的检查步骤检查");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "* 手Q登录异常检查步骤：http://wiki.open.qq.com/wiki/%E5%BE%AE%E4%BF%A1%E4%B8%8E%E6%89%8BQ%E6%8E%A5%E5%85%A5");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "***************************************************************");
        }
    }

    public static void showQQModuleNotGoodTips() {
        if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isDev()) {
            com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.module.BaseModuleSelfCheck.LOG_TAG, "******************* 游戏接入过程中请重点关注  *********************");
            com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.module.BaseModuleSelfCheck.LOG_TAG, "* QQ 模块初始化失败，如果没有接入QQ模块，则不用关注，如果接入QQ模块，请确认ysdkconf.ini中手Q的appid信息是否配置正确");
            com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.module.BaseModuleSelfCheck.LOG_TAG, "***************************************************************");
        }
    }

    public static void showRechargeTips() {
        if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isDev()) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "******************* 游戏接入过程中请重点关注  *********************");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "* 目前YSDK的支付使用米大师，支付过程中可能会遇到以下问题，请游戏关注：");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "* （1）由于米大师SDK的兼容性问题，在部分机型上，可能会遇到充值成功以后，无法正常弹出或者无法弹出完整支付成功界面或者，没有收到回调的问题，此时充值已经到账，建议应用触发查余额逻辑拉取余额解决。");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "* （2）由于第三方支付的实现方式的原因，游戏可能会遇到充值成功以后，没有收到成功回调的问题。通过下面的地址了解：");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "*     游戏币托管模式充值注意事项：http://wiki.open.qq.com/wiki/%E6%B8%B8%E6%88%8F%E6%8E%A5%E5%85%A5%E7%B1%B3%E5%A4%A7%E5%B8%88%E6%B5%81%E7%A8%8B");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "* （3）游戏在如果使用过老版本YSDK，集成过TencentPay.apk的，在更新到1.2.2版本以上时，切记删除该apk。负责会导致拉起支付时有如下提示：");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "*     需要注册以下Activity的权限但是未按要求注册：");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "*     com.tencent.midas.qq.APMidasQQWalletActivity");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "*     com.tencent.midas.proxyactivity.APMidasPayProxyActivity");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "*     com.tencent.midas.wx.APMidasWXPayActivity");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "***************************************************************");
        }
    }

    public static void showRelationNotifyTips() {
        if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isDev()) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "******************* 游戏接入过程中请重点关注  *********************");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "* RelationNotify 主要返回获取用户个人信息或者关系链相关的信息,回调设置请参考YSDK Demo");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "* RelationNotify 中对应回调内容以及flag说明请参照：http://wiki.open.qq.com/wiki/YSDK_Android_%E5%B8%B8%E9%87%8F%E6%9F%A5%E8%AF%A2");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "***************************************************************");
        }
    }

    public static void showStartSelfCheck() {
        if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isDev()) {
            com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.module.BaseModuleSelfCheck.LOG_TAG, "******************* 游戏接入过程中请重点关注  *********************");
            com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.module.BaseModuleSelfCheck.LOG_TAG, "*   SDK自检模块检测开始,游戏可以结合日志信息确认对应配置是否正确   *");
        }
    }

    public static void showTestDomainInfo(java.lang.String str) {
        com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "******************* 游戏接入过程中请重点关注  *********************");
        com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "* You are using: " + str);
        com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "* 游戏当前连接的是YSDK的测试环境,测试环境主要用于联调和问题定位,上线前必须切换到正式环境!");
        com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "* YSDK环境切换方式可以通过下面的链接了解");
        com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "* YSDK 配置修改：http://wiki.open.qq.com/wiki/YSDK%E5%BF%AB%E9%80%9F%E6%8E%A5%E5%85%A5");
        com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "* YSDK测试环境与正式环境权限完全分离、游戏可以通过下面的链接了解对应权限!");
        com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "* YSDK 环境权限说明：http://wiki.open.qq.com/wiki/YSDK%E4%BB%8B%E7%BB%8D");
        com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "***************************************************************");
        android.widget.Toast.makeText(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext(), "You are using: " + str, 1).show();
    }

    public static void showTestVersionInfo() {
        com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "******************* 游戏接入过程中请重点关注  *********************");
        com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "* This is a test version for YSDK!");
        com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "* 该版本非YSDK正式版本，游戏可以使用该版本定位问题、调试等，但是不可使用该版本正式上线，上线时请使用官网下载的SDK");
        com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "* YSDK 下载地址：http://wiki.open.qq.com/wiki/YSDK%E4%B8%8B%E8%BD%BD");
        com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "***************************************************************");
        android.widget.Toast.makeText(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext(), "This is a test version for YSDK", 1).show();
    }

    public static void showVersionInfo() {
        if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isDev()) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "******************* 游戏接入过程中请重点关注  *********************");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "* YSDK版本更新 - 1.3.1 * \t\n");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "***************************************************************");
        }
    }

    public static void showWXLoginTips() {
        if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isDev()) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "******************* 游戏接入过程中请重点关注  *********************");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "* 游戏接入过程中，如果遇到微信登录无回调、无法拉起微信等错误，请按照下面的检查步骤检查");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "* 微信登录异常检查步骤：http://wiki.open.qq.com/wiki/%E5%BE%AE%E4%BF%A1%E4%B8%8E%E6%89%8BQ%E6%8E%A5%E5%85%A5");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "***************************************************************");
        }
    }

    public static void showWXModuleNotGoodTips() {
        if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isDev()) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "******************* 游戏接入过程中请重点关注  *********************");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "* 微信模块初始化失败，如果没有接入微信模块，则不用关注，如果接入微信模块，请确认ysdkconf.ini中微信的appid信息是否配置正确");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "***************************************************************");
        }
    }

    public static void showWakeupNotifyTips() {
        if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isDev()) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "******************* 游戏接入过程中请重点关注  *********************");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "* WakeupNotify 仅仅返回本次应用启动的信息，不会返回登录信息，登录信息请关注onLoginNotify,回调设置请参考YSDK Demo");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "* WakeupNotify中对应回调内容以及flag说明请参照：http://wiki.open.qq.com/wiki/YSDK_Android_%E5%B8%B8%E9%87%8F%E6%9F%A5%E8%AF%A2");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "***************************************************************");
        }
    }

    public static void showYSDKInit() {
        if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isDev()) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "******************* 游戏接入过程中请重点关注  *********************");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "* YSDK 在运行过程中没秒钟都会有一行下面的日志打印，该日志不影响YSDK以及游戏的任何功能，无需关注");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "* E/anti: anti once");
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "***************************************************************");
        }
    }
}
