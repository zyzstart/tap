package com.tencent.ysdk.shell.module.icon;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.2.4")
public class IconApiImpl implements com.tencent.ysdk.module.icon.IIconApi {
    public static final int ALERT_SCENE_EXIST = 2;
    public static final int ALERT_SCENE_INIT = 1;
    private static volatile com.tencent.ysdk.shell.module.icon.IconApiImpl instance;
    protected com.tencent.ysdk.shell.module.icon.IconInterface iconInterface = null;

    private IconApiImpl() {
    }

    public static com.tencent.ysdk.shell.module.icon.IconApiImpl getInstance() {
        if (instance == null) {
            synchronized (com.tencent.ysdk.shell.module.icon.IconApiImpl.class) {
                if (instance == null) {
                    com.tencent.ysdk.shell.module.icon.IconApiImpl iconApiImpl = new com.tencent.ysdk.shell.module.icon.IconApiImpl();
                    com.tencent.ysdk.shell.module.ModuleManager moduleManager = com.tencent.ysdk.shell.module.ModuleManager.getInstance();
                    if (moduleManager != null) {
                        java.lang.Object moduleByName = moduleManager.getModuleByName("icon");
                        if (moduleByName == null || !(moduleByName instanceof com.tencent.ysdk.shell.module.icon.IconInterface)) {
                            com.tencent.ysdk.libware.file.Logger.d("YSDK_DOCTOR", "IconApi module is bad");
                        } else {
                            iconApiImpl.iconInterface = (com.tencent.ysdk.shell.module.icon.IconInterface) moduleByName;
                            com.tencent.ysdk.libware.file.Logger.d("YSDK_DOCTOR", "IconApi");
                        }
                    }
                    instance = iconApiImpl;
                }
            }
        }
        return instance;
    }

    public java.lang.String getIconVersion() {
        com.tencent.ysdk.shell.module.icon.IconInterface iconInterface = this.iconInterface;
        return iconInterface != null ? iconInterface.getIconVersion() : "";
    }

    @Override // com.tencent.ysdk.module.icon.IIconApi
    public void hideIcon() {
        com.tencent.ysdk.shell.module.icon.IconInterface iconInterface = this.iconInterface;
        if (iconInterface != null) {
            try {
                iconInterface.removeGameAssistant();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.tencent.ysdk.module.icon.IIconApi
    public void loadIcon() {
        com.tencent.ysdk.shell.module.icon.IconInterface iconInterface = this.iconInterface;
        if (iconInterface != null) {
            try {
                iconInterface.createGameAssistant();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void onDestroy(android.app.Activity activity) {
        com.tencent.ysdk.shell.module.icon.IconInterface iconInterface = this.iconInterface;
        if (iconInterface != null) {
            iconInterface.onDestroy();
        }
    }

    public void onPause(android.app.Activity activity) {
        com.tencent.ysdk.shell.module.icon.IconInterface iconInterface = this.iconInterface;
        if (iconInterface != null) {
            iconInterface.onPause();
        }
    }

    public void onResume(android.app.Activity activity) {
        com.tencent.ysdk.shell.module.icon.IconInterface iconInterface = this.iconInterface;
        if (iconInterface != null) {
            iconInterface.onResume();
        }
    }

    @Override // com.tencent.ysdk.module.icon.IIconApi
    public void showIconBubble(com.tencent.ysdk.module.msgbox.MsgItem msgItem) {
        com.tencent.ysdk.shell.module.icon.IconInterface iconInterface = this.iconInterface;
        if (iconInterface != null) {
            iconInterface.showIconBubble(msgItem);
        }
    }

    public void showPopView(int i) {
        com.tencent.ysdk.shell.module.icon.IconInterface iconInterface = this.iconInterface;
        if (iconInterface != null) {
            iconInterface.showForcePopWindow(i);
        }
    }
}
