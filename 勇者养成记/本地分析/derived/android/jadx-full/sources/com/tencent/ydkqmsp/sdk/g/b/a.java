package com.tencent.ydkqmsp.sdk.g.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {

    /* JADX INFO: renamed from: com.tencent.ydkqmsp.sdk.g.b.a$a, reason: collision with other inner class name */
    public static final class C0054a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final java.lang.String f1354a;
        private final boolean b;

        C0054a(java.lang.String str, boolean z) {
            this.f1354a = str;
            this.b = z;
        }

        public final java.lang.String a() {
            return this.f1354a;
        }

        public final boolean b() {
            return this.b;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static com.tencent.ydkqmsp.sdk.g.b.a.C0054a a(android.content.Context context) {
        java.lang.String str;
        java.lang.String str2;
        android.util.Log.i(a(), "getAdvertisingIdInfo " + java.lang.System.currentTimeMillis());
        if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
            com.tencent.ydkqmsp.sdk.base.c.b("Cannot be called from the main thread");
            throw new java.lang.IllegalStateException("Cannot be called from the main thread");
        }
        try {
            context.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
            com.tencent.ydkqmsp.sdk.g.b.b bVar = new com.tencent.ydkqmsp.sdk.g.b.b();
            android.content.Intent intent = new android.content.Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            if (!context.bindService(intent, bVar, 1)) {
                str = "bind failed";
                com.tencent.ydkqmsp.sdk.base.c.b(str);
                return null;
            }
            android.util.Log.i(a(), "bind ok");
            try {
                try {
                    if (bVar.f1355a) {
                        throw new java.lang.IllegalStateException();
                    }
                    bVar.f1355a = true;
                    com.tencent.ydkqmsp.sdk.g.b.d dVarA = com.tencent.ydkqmsp.sdk.g.b.d.a.a((android.os.IBinder) bVar.b.take());
                    com.tencent.ydkqmsp.sdk.g.b.a.C0054a c0054a = new com.tencent.ydkqmsp.sdk.g.b.a.C0054a(dVarA.i(), dVarA.f());
                    context.unbindService(bVar);
                    return c0054a;
                } catch (java.lang.Throwable th) {
                    context.unbindService(bVar);
                    throw th;
                }
            } catch (android.os.RemoteException unused) {
                str2 = "bind hms service RemoteException";
                com.tencent.ydkqmsp.sdk.base.c.b(str2);
                context.unbindService(bVar);
                return null;
            } catch (java.lang.InterruptedException unused2) {
                str2 = "bind hms service InterruptedException";
                com.tencent.ydkqmsp.sdk.base.c.b(str2);
                context.unbindService(bVar);
                return null;
            }
        } catch (android.content.pm.PackageManager.NameNotFoundException unused3) {
            str = "HMS not found";
        }
    }

    private static java.lang.String a() {
        return "AdId";
    }
}
