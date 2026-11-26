package com.tencent.ysdk.shell.module.share.impl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ShareManagerQQ {
    private static final java.lang.String LOG_TAG = "YSDK_SHARE_QQ";
    private com.tencent.ysdk.shell.module.share.impl.ShareModule.QQShareCallBack mQQShareCallBack;
    private com.tencent.tauth.Tencent mTencent;
    private android.os.Bundle params;

    public ShareManagerQQ(com.tencent.tauth.Tencent tencent, com.tencent.ysdk.shell.module.share.impl.ShareModule.QQShareCallBack qQShareCallBack) {
        this.mTencent = tencent;
        this.mQQShareCallBack = qQShareCallBack;
    }

    public void shareToFriend(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.params = new android.os.Bundle();
        this.params.putInt("req_type", 1);
        this.params.putString("title", str2);
        this.params.putString("summary", str3);
        this.params.putString("imageUrl", str);
        this.params.putString("targetUrl", str);
        this.params.putString("appName", com.tencent.ysdk.shell.libware.apk.PackageUtils.getAppName(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext()));
        com.tencent.ysdk.shell.libware.thread.YSDKThreadManager.getInstance().runOnUIThread(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.module.share.impl.ShareManagerQQ.1
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.ysdk.shell.module.share.impl.ShareManagerQQ.this.mTencent.shareToQQ(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity(), com.tencent.ysdk.shell.module.share.impl.ShareManagerQQ.this.params, com.tencent.ysdk.shell.module.share.impl.ShareManagerQQ.this.mQQShareCallBack);
            }
        });
    }

    public void shareToQZone(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.params = new android.os.Bundle();
        this.params.putInt("req_type", 1);
        this.params.putString("title", str2);
        this.params.putString("summary", str3);
        this.params.putString("targetUrl", str);
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>();
        arrayList.add(str);
        this.params.putStringArrayList("imageUrl", arrayList);
        com.tencent.ysdk.shell.libware.thread.YSDKThreadManager.getInstance().runOnUIThread(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.module.share.impl.ShareManagerQQ.3
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.ysdk.shell.module.share.impl.ShareManagerQQ.this.mTencent.shareToQzone(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity(), com.tencent.ysdk.shell.module.share.impl.ShareManagerQQ.this.params, com.tencent.ysdk.shell.module.share.impl.ShareManagerQQ.this.mQQShareCallBack);
            }
        });
    }

    public void shareURLToFriend(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        this.params = new android.os.Bundle();
        this.params.putInt("req_type", 1);
        this.params.putString("title", str3);
        this.params.putString("summary", str4);
        this.params.putString("imageUrl", str);
        this.params.putString("targetUrl", str2);
        this.params.putString("appName", com.tencent.ysdk.shell.libware.apk.PackageUtils.getAppName(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext()));
        com.tencent.ysdk.shell.libware.thread.YSDKThreadManager.getInstance().runOnUIThread(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.module.share.impl.ShareManagerQQ.2
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.ysdk.shell.module.share.impl.ShareManagerQQ.this.mTencent.shareToQQ(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity(), com.tencent.ysdk.shell.module.share.impl.ShareManagerQQ.this.params, com.tencent.ysdk.shell.module.share.impl.ShareManagerQQ.this.mQQShareCallBack);
            }
        });
    }

    public void shareURLToQZone(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        this.params = new android.os.Bundle();
        this.params.putInt("req_type", 1);
        this.params.putString("title", str3);
        this.params.putString("summary", str4);
        this.params.putString("targetUrl", str2);
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>();
        arrayList.add(str);
        this.params.putStringArrayList("imageUrl", arrayList);
        com.tencent.ysdk.shell.libware.thread.YSDKThreadManager.getInstance().runOnUIThread(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.module.share.impl.ShareManagerQQ.4
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.ysdk.shell.module.share.impl.ShareManagerQQ.this.mTencent.shareToQzone(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity(), com.tencent.ysdk.shell.module.share.impl.ShareManagerQQ.this.params, com.tencent.ysdk.shell.module.share.impl.ShareManagerQQ.this.mQQShareCallBack);
            }
        });
    }
}
