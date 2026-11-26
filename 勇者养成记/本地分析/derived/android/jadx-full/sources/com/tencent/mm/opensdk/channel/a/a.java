package com.tencent.mm.opensdk.channel.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a {

    /* JADX INFO: renamed from: com.tencent.mm.opensdk.channel.a.a$a, reason: collision with other inner class name */
    public static class C0026a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public java.lang.String f641a;
        public java.lang.String action;
        public long b;
        public android.os.Bundle bundle;
        public java.lang.String content;
    }

    public static boolean a(android.content.Context context, com.tencent.mm.opensdk.channel.a.a.C0026a c0026a) {
        java.lang.String str;
        java.lang.String str2;
        if (context == null) {
            str = "MicroMsg.SDK.MMessage";
            str2 = "send fail, invalid argument";
        } else {
            if (!com.tencent.mm.opensdk.utils.d.b(c0026a.action)) {
                java.lang.String str3 = null;
                if (!com.tencent.mm.opensdk.utils.d.b(c0026a.f641a)) {
                    str3 = c0026a.f641a + ".permission.MM_MESSAGE";
                }
                android.content.Intent intent = new android.content.Intent(c0026a.action);
                android.os.Bundle bundle = c0026a.bundle;
                if (bundle != null) {
                    intent.putExtras(bundle);
                }
                java.lang.String packageName = context.getPackageName();
                intent.putExtra(com.tencent.mm.opensdk.constants.ConstantsAPI.SDK_VERSION, 620824064);
                intent.putExtra(com.tencent.mm.opensdk.constants.ConstantsAPI.APP_PACKAGE, packageName);
                intent.putExtra(com.tencent.mm.opensdk.constants.ConstantsAPI.CONTENT, c0026a.content);
                intent.putExtra(com.tencent.mm.opensdk.constants.ConstantsAPI.APP_SUPORT_CONTENT_TYPE, c0026a.b);
                intent.putExtra(com.tencent.mm.opensdk.constants.ConstantsAPI.CHECK_SUM, com.tencent.mm.opensdk.channel.a.b.a(c0026a.content, 620824064, packageName));
                context.sendBroadcast(intent, str3);
                com.tencent.mm.opensdk.utils.Log.d("MicroMsg.SDK.MMessage", "send mm message, intent=" + intent + ", perm=" + str3);
                return true;
            }
            str = "MicroMsg.SDK.MMessage";
            str2 = "send fail, action is null";
        }
        com.tencent.mm.opensdk.utils.Log.e(str, str2);
        return false;
    }
}
