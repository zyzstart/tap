package com.tencent.ysdk.shell.module.antiaddiction;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class AntiAddictionApi {
    private static volatile com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionApi mInstance;
    private com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionInterface antiAddictionImpl = null;

    public static com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionApi getInstance() {
        if (mInstance == null) {
            synchronized (com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionApi.class) {
                if (mInstance == null) {
                    com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionApi antiAddictionApi = new com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionApi();
                    com.tencent.ysdk.shell.module.ModuleManager moduleManager = com.tencent.ysdk.shell.module.ModuleManager.getInstance();
                    if (moduleManager != null) {
                        java.lang.Object moduleByName = moduleManager.getModuleByName(com.tencent.ysdk.shell.module.ModuleManager.YSDK_MODULE_NAME_ANTI_ADDICTION);
                        if (moduleByName instanceof com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionInterface) {
                            antiAddictionApi.antiAddictionImpl = (com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionInterface) moduleByName;
                        } else {
                            com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionInterface.LOG_TAG, "getModuleByName anti addiction bad");
                        }
                    }
                    mInstance = antiAddictionApi;
                }
            }
        }
        return mInstance;
    }

    public boolean checkAntiAddictionLoginRules(org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2, com.tencent.ysdk.shell.module.antiaddiction.listener.LoginAntiAddictCallBack loginAntiAddictCallBack, boolean z) {
        com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionInterface antiAddictionInterface = this.antiAddictionImpl;
        if (antiAddictionInterface != null) {
            return antiAddictionInterface.checkAntiAddictionLoginRules(jSONObject, jSONObject2, loginAntiAddictCallBack, z);
        }
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.realName.RealNameInterface.LOG_TAG, "checkAntiAddictionLoginRules bad");
        return false;
    }

    public int getGameDuration() {
        com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionInterface antiAddictionInterface = this.antiAddictionImpl;
        if (antiAddictionInterface != null) {
            return antiAddictionInterface.getGameDuration();
        }
        return -1;
    }

    public boolean isVisitorState() {
        com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionInterface antiAddictionInterface = this.antiAddictionImpl;
        if (antiAddictionInterface != null) {
            return antiAddictionInterface.isVisitorState();
        }
        return false;
    }

    public void onRegisterWindowClose() {
        com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionInterface antiAddictionInterface = this.antiAddictionImpl;
        if (antiAddictionInterface != null) {
            antiAddictionInterface.onRegisterWindowClose();
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.realName.RealNameInterface.LOG_TAG, "onRegisterWindowClose bad");
        }
    }

    public void printLogInDebug(java.lang.String str) {
        com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionInterface antiAddictionInterface = this.antiAddictionImpl;
        if (antiAddictionInterface != null) {
            antiAddictionInterface.printLogInDebug(str);
        }
    }

    public void queryCertification(com.tencent.ysdk.module.antiaddiction.listener.QueryCertificationCallback queryCertificationCallback) {
        com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionInterface antiAddictionInterface = this.antiAddictionImpl;
        if (antiAddictionInterface != null) {
            antiAddictionInterface.queryCertification(queryCertificationCallback);
        }
    }

    public void registerRealName() {
        com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionInterface antiAddictionInterface = this.antiAddictionImpl;
        if (antiAddictionInterface != null) {
            antiAddictionInterface.registerRealName();
        }
    }

    public void reportExecuteInstruction(com.tencent.ysdk.module.antiaddiction.model.AntiAddictRet antiAddictRet, long j) {
        com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionInterface antiAddictionInterface = this.antiAddictionImpl;
        if (antiAddictionInterface != null) {
            antiAddictionInterface.reportExecute(antiAddictRet, j);
        }
    }

    public void resetGameStartFromBackground() {
        com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionInterface antiAddictionInterface = this.antiAddictionImpl;
        if (antiAddictionInterface != null) {
            antiAddictionInterface.resetGameStartFromBackground();
        }
    }

    public void setAntiAddictListener(com.tencent.ysdk.module.antiaddiction.listener.AntiAddictListener antiAddictListener) {
        com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionInterface antiAddictionInterface = this.antiAddictionImpl;
        if (antiAddictionInterface != null) {
            antiAddictionInterface.setAntiAddictionListener(antiAddictListener);
        }
    }

    public void setGameBackground() {
        com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionInterface antiAddictionInterface = this.antiAddictionImpl;
        if (antiAddictionInterface != null) {
            antiAddictionInterface.setGameBackground();
        }
    }

    public boolean setGameEnd() {
        com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionInterface antiAddictionInterface = this.antiAddictionImpl;
        if (antiAddictionInterface != null) {
            return antiAddictionInterface.setGameEnd();
        }
        return false;
    }

    public boolean setGameStart() {
        com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionInterface antiAddictionInterface = this.antiAddictionImpl;
        if (antiAddictionInterface != null) {
            return antiAddictionInterface.setGameStart();
        }
        return false;
    }

    public void setLogEnable(boolean z) {
        com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionInterface antiAddictionInterface = this.antiAddictionImpl;
        if (antiAddictionInterface != null) {
            antiAddictionInterface.setLogEnable(z);
        }
    }

    public void setRegisterWindowCloseListener(com.tencent.ysdk.module.antiaddiction.listener.AntiRegisterWindowCloseListener antiRegisterWindowCloseListener) {
        com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionInterface antiAddictionInterface = this.antiAddictionImpl;
        if (antiAddictionInterface != null) {
            antiAddictionInterface.setRegisterWindowClose(antiRegisterWindowCloseListener);
        }
    }

    public void setVisitorState(boolean z) {
        com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionInterface antiAddictionInterface = this.antiAddictionImpl;
        if (antiAddictionInterface != null) {
            antiAddictionInterface.setVisitorState(z);
        }
    }

    public void visitorLogin() {
        com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionInterface antiAddictionInterface = this.antiAddictionImpl;
        if (antiAddictionInterface != null) {
            antiAddictionInterface.visitorLogin();
        }
    }
}
