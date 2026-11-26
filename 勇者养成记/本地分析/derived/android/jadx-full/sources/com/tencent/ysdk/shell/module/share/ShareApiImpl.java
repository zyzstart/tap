package com.tencent.ysdk.shell.module.share;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.3.7")
public class ShareApiImpl implements com.tencent.ysdk.module.share.IShareApi {
    private static volatile com.tencent.ysdk.shell.module.share.ShareApiImpl instance;
    private com.tencent.ysdk.shell.module.share.ShareInterface shareInterface = null;

    private ShareApiImpl() {
    }

    public static com.tencent.ysdk.shell.module.share.ShareApiImpl getInstance() {
        if (instance == null) {
            synchronized (com.tencent.ysdk.shell.module.share.ShareApiImpl.class) {
                if (instance == null) {
                    com.tencent.ysdk.shell.module.share.ShareApiImpl shareApiImpl = new com.tencent.ysdk.shell.module.share.ShareApiImpl();
                    com.tencent.ysdk.shell.module.ModuleManager moduleManager = com.tencent.ysdk.shell.module.ModuleManager.getInstance();
                    if (moduleManager != null) {
                        java.lang.Object moduleByName = moduleManager.getModuleByName(com.tencent.ysdk.shell.module.ModuleManager.YSDK_MODULE_NAME_SHARE);
                        if (moduleByName == null || !(moduleByName instanceof com.tencent.ysdk.shell.module.share.ShareInterface)) {
                            com.tencent.ysdk.libware.file.Logger.d("YSDK_DOCTOR", "ShareApi module is bad");
                        } else {
                            shareApiImpl.shareInterface = (com.tencent.ysdk.shell.module.share.ShareInterface) moduleByName;
                            com.tencent.ysdk.libware.file.Logger.d("YSDK_DOCTOR", "ShareApi");
                        }
                    }
                    instance = shareApiImpl;
                }
            }
        }
        return instance;
    }

    @Override // com.tencent.ysdk.module.share.IShareApi
    public void captureScreen() {
        com.tencent.ysdk.shell.module.share.ShareInterface shareInterface = this.shareInterface;
        if (shareInterface != null) {
            shareInterface.captureScreen();
        }
    }

    @Override // com.tencent.ysdk.module.share.IShareApi
    public boolean checkWXCallBack(android.content.Intent intent) {
        com.tencent.ysdk.shell.module.share.ShareInterface shareInterface = this.shareInterface;
        if (shareInterface != null) {
            return shareInterface.checkWXCallBack(intent);
        }
        return false;
    }

    @Override // com.tencent.ysdk.module.share.IShareApi
    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        com.tencent.ysdk.shell.module.share.ShareInterface shareInterface = this.shareInterface;
        if (shareInterface != null) {
            shareInterface.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.tencent.ysdk.module.share.IShareApi
    public void regShareCallBack(com.tencent.ysdk.module.share.ShareCallBack shareCallBack) {
        com.tencent.ysdk.shell.module.share.ShareInterface shareInterface = this.shareInterface;
        if (shareInterface != null) {
            shareInterface.regShareCallBack(shareCallBack);
        }
    }

    @Override // com.tencent.ysdk.module.share.IShareApi
    public void setScreenCapturer(com.tencent.ysdk.module.share.impl.IScreenImageCapturer iScreenImageCapturer) {
        com.tencent.ysdk.shell.module.share.ShareInterface shareInterface = this.shareInterface;
        if (shareInterface != null) {
            shareInterface.setScreenCapturer(iScreenImageCapturer);
        }
    }

    @Override // com.tencent.ysdk.module.share.IShareApi
    public void share(android.graphics.Bitmap bitmap, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.tencent.ysdk.shell.module.share.ShareInterface shareInterface = this.shareInterface;
        if (shareInterface != null) {
            shareInterface.share(bitmap, str, str2, str3);
        }
    }

    @Override // com.tencent.ysdk.module.share.IShareApi
    public void shareToQQFriend(android.graphics.Bitmap bitmap, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.tencent.ysdk.shell.module.share.ShareInterface shareInterface = this.shareInterface;
        if (shareInterface != null) {
            shareInterface.shareToQQFriend(bitmap, str, str2, str3);
        }
    }

    @Override // com.tencent.ysdk.module.share.IShareApi
    public void shareToQZone(android.graphics.Bitmap bitmap, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.tencent.ysdk.shell.module.share.ShareInterface shareInterface = this.shareInterface;
        if (shareInterface != null) {
            shareInterface.shareToQZone(bitmap, str, str2, str3);
        }
    }

    @Override // com.tencent.ysdk.module.share.IShareApi
    public void shareToWXFriend(android.graphics.Bitmap bitmap, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.tencent.ysdk.shell.module.share.ShareInterface shareInterface = this.shareInterface;
        if (shareInterface != null) {
            shareInterface.shareToWXFriend(bitmap, str, str2, str3);
        }
    }

    @Override // com.tencent.ysdk.module.share.IShareApi
    public void shareToWXTimeline(android.graphics.Bitmap bitmap, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.tencent.ysdk.shell.module.share.ShareInterface shareInterface = this.shareInterface;
        if (shareInterface != null) {
            shareInterface.shareToWXTimeline(bitmap, str, str2, str3);
        }
    }

    @Override // com.tencent.ysdk.module.share.IShareApi
    public void shareURLToQQFriend(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        com.tencent.ysdk.shell.module.share.ShareInterface shareInterface = this.shareInterface;
        if (shareInterface != null) {
            shareInterface.shareURLToQQFriend(str, str2, str3, str4, str5);
        }
    }

    @Override // com.tencent.ysdk.module.share.IShareApi
    public void shareURLToQZone(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        com.tencent.ysdk.shell.module.share.ShareInterface shareInterface = this.shareInterface;
        if (shareInterface != null) {
            shareInterface.shareURLToQZone(str, str2, str3, str4, str5);
        }
    }

    @Override // com.tencent.ysdk.module.share.IShareApi
    public void shareURLToWXFriend(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        com.tencent.ysdk.shell.module.share.ShareInterface shareInterface = this.shareInterface;
        if (shareInterface != null) {
            shareInterface.shareURLToWXFriend(str, str2, str3, str4, str5);
        }
    }

    @Override // com.tencent.ysdk.module.share.IShareApi
    public void shareURLToWXTimeline(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        com.tencent.ysdk.shell.module.share.ShareInterface shareInterface = this.shareInterface;
        if (shareInterface != null) {
            shareInterface.shareURLToWXTimeline(str, str2, str3, str4, str5);
        }
    }
}
