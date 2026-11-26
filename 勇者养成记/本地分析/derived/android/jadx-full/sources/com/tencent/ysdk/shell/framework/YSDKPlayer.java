package com.tencent.ysdk.shell.framework;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class YSDKPlayer {
    private static volatile com.tencent.ysdk.shell.framework.YSDKPlayer instance;
    private java.lang.String mOpenId = "";
    private java.lang.String mNickname = "";
    private java.lang.String mPictureMiddle = "";
    private android.graphics.Bitmap mBitmap = null;

    private YSDKPlayer() {
    }

    public static com.tencent.ysdk.shell.framework.YSDKPlayer getInstance() {
        if (instance == null) {
            synchronized (com.tencent.ysdk.shell.framework.YSDKPlayer.class) {
                if (instance == null) {
                    instance = new com.tencent.ysdk.shell.framework.YSDKPlayer();
                }
            }
        }
        return instance;
    }

    public java.lang.String getNickname(java.lang.String str) {
        com.tencent.ysdk.module.user.UserLoginRet loginRecord = com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord();
        return (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(loginRecord.open_id) || !loginRecord.open_id.equals(this.mOpenId)) ? "" : this.mNickname;
    }

    public java.lang.String getPictureUrl(java.lang.String str) {
        return (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(str) || !str.equals(this.mOpenId)) ? "" : this.mPictureMiddle;
    }

    public void logout() {
        instance = null;
    }

    public void setHeadBitmapToImgView(final android.widget.ImageView imageView) {
        com.tencent.ysdk.module.user.UserLoginRet loginRecord = com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord();
        if (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(loginRecord.open_id) || !loginRecord.open_id.equals(this.mOpenId)) {
            return;
        }
        if (this.mBitmap != null) {
            imageView.post(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.framework.YSDKPlayer.1
                @Override // java.lang.Runnable
                public void run() {
                    imageView.setImageBitmap(com.tencent.ysdk.shell.framework.YSDKPlayer.this.mBitmap);
                }
            });
        } else {
            if (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(this.mPictureMiddle)) {
                return;
            }
            new java.lang.Thread(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.framework.YSDKPlayer.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        android.graphics.Bitmap bitmapDecodeStream = android.graphics.BitmapFactory.decodeStream(new java.net.URL(com.tencent.ysdk.shell.framework.YSDKPlayer.this.mPictureMiddle).openStream());
                        if (bitmapDecodeStream != null) {
                            com.tencent.ysdk.shell.framework.YSDKPlayer.this.mBitmap = bitmapDecodeStream;
                            imageView.post(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.framework.YSDKPlayer.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    imageView.setImageBitmap(com.tencent.ysdk.shell.framework.YSDKPlayer.this.mBitmap);
                                }
                            });
                        }
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    public void setPlayerInfo(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(str) || this.mOpenId != str) {
            this.mOpenId = str;
            this.mNickname = str2;
            this.mPictureMiddle = str3;
        }
    }
}
