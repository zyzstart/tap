package com.tencent.ysdk.shell.module.msgbox;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.3.3")
public class MsgBoxApiImpl implements com.tencent.ysdk.module.msgbox.IMsgBoxApi {
    private static volatile com.tencent.ysdk.shell.module.msgbox.MsgBoxApiImpl instance;
    private com.tencent.ysdk.shell.module.msgbox.MsgBoxInterface msgBoxInterface = null;

    private MsgBoxApiImpl() {
    }

    public static com.tencent.ysdk.shell.module.msgbox.MsgBoxApiImpl getInstance() {
        if (instance == null) {
            synchronized (com.tencent.ysdk.shell.module.msgbox.MsgBoxApiImpl.class) {
                if (instance == null) {
                    com.tencent.ysdk.shell.module.msgbox.MsgBoxApiImpl msgBoxApiImpl = new com.tencent.ysdk.shell.module.msgbox.MsgBoxApiImpl();
                    com.tencent.ysdk.shell.module.ModuleManager moduleManager = com.tencent.ysdk.shell.module.ModuleManager.getInstance();
                    if (moduleManager != null) {
                        java.lang.Object moduleByName = moduleManager.getModuleByName(com.tencent.ysdk.shell.module.ModuleManager.YSDK_MODULE_NAME_MSGBOX);
                        if (moduleByName == null || !(moduleByName instanceof com.tencent.ysdk.shell.module.msgbox.MsgBoxInterface)) {
                            com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_DOCTOR", "MsgBoxAPI module is bad");
                        } else {
                            msgBoxApiImpl.msgBoxInterface = (com.tencent.ysdk.shell.module.msgbox.MsgBoxInterface) moduleByName;
                            com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_DOCTOR", "MsgBoxAPI");
                        }
                    }
                    instance = msgBoxApiImpl;
                }
            }
        }
        return instance;
    }

    @Override // com.tencent.ysdk.module.msgbox.IMsgBoxApi
    public java.lang.String getMsgBoxVersion() {
        return "YSDK_MSGBOX_1";
    }

    @Override // com.tencent.ysdk.module.msgbox.IMsgBoxApi
    public void showMsgBoxObj(com.tencent.ysdk.module.msgbox.MsgItem msgItem) {
        this.msgBoxInterface.showObjMsg(msgItem);
    }

    @Override // com.tencent.ysdk.module.msgbox.IMsgBoxApi
    public void showMsgBoxObj(java.lang.String str) {
        this.msgBoxInterface.showJsonMsg(str);
    }
}
