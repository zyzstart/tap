package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class TbsVideoUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.tencent.smtt.sdk.q f878a;

    private static void a(android.content.Context context) {
        synchronized (com.tencent.smtt.sdk.TbsVideoUtils.class) {
            if (f878a == null) {
                com.tencent.smtt.sdk.d.a(true).a(context, false, false);
                com.tencent.smtt.sdk.s sVarA = com.tencent.smtt.sdk.d.a(true).a();
                com.tencent.smtt.export.external.DexLoader dexLoaderB = sVarA != null ? sVarA.b() : null;
                if (dexLoaderB != null) {
                    f878a = new com.tencent.smtt.sdk.q(dexLoaderB);
                }
            }
        }
    }

    public static void deleteVideoCache(android.content.Context context, java.lang.String str) {
        a(context);
        com.tencent.smtt.sdk.q qVar = f878a;
        if (qVar != null) {
            qVar.a(context, str);
        }
    }

    public static java.lang.String getCurWDPDecodeType(android.content.Context context) {
        a(context);
        com.tencent.smtt.sdk.q qVar = f878a;
        return qVar != null ? qVar.a(context) : "";
    }
}
