package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class TbsVideo {
    public static boolean canUseTbsPlayer(android.content.Context context) {
        return com.tencent.smtt.sdk.p.a(context).a();
    }

    public static boolean canUseYunbo(android.content.Context context) {
        return com.tencent.smtt.sdk.p.a(context).a() && com.tencent.smtt.sdk.QbSdk.canUseVideoFeatrue(context, 1);
    }

    public static void openVideo(android.content.Context context, java.lang.String str) {
        openVideo(context, str, null);
    }

    public static void openVideo(android.content.Context context, java.lang.String str, android.os.Bundle bundle) {
        if (android.text.TextUtils.isEmpty(str)) {
            android.util.Log.e("TbsVideo", "videoUrl is empty!");
            return;
        }
        if (bundle == null) {
            bundle = new android.os.Bundle();
        }
        bundle.putString("videoUrl", str);
        android.content.Intent intent = new android.content.Intent("com.tencent.smtt.tbs.video.PLAY");
        intent.setFlags(268435456);
        intent.setPackage(context.getPackageName());
        intent.putExtra("extraData", bundle);
        context.startActivity(intent);
    }

    public static boolean openYunboVideo(android.content.Context context, java.lang.String str, android.os.Bundle bundle, com.tencent.tbs.video.interfaces.a aVar) {
        if (canUseYunbo(context)) {
            return com.tencent.smtt.sdk.p.a(context).a(str, bundle, aVar);
        }
        return false;
    }
}
