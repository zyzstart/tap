package com.tencent.ydkqmsp.sdk.g.g;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class e {
    public static final com.tencent.ydkqmsp.sdk.g.g.e f = new com.tencent.ydkqmsp.sdk.g.g.e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.tencent.ydkqmsp.sdk.g.g.d f1378a;
    public java.lang.String b;
    public java.lang.String c;
    public final java.lang.Object d = new java.lang.Object();
    public android.content.ServiceConnection e = new com.tencent.ydkqmsp.sdk.g.g.e.a();

    class a implements android.content.ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            com.tencent.ydkqmsp.sdk.g.g.e.this.f1378a = com.tencent.ydkqmsp.sdk.g.g.d.a.a(iBinder);
            synchronized (com.tencent.ydkqmsp.sdk.g.g.e.this.d) {
                com.tencent.ydkqmsp.sdk.g.g.e.this.d.notify();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(android.content.ComponentName componentName) {
            com.tencent.ydkqmsp.sdk.g.g.e.this.f1378a = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:42:0x0048 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public java.lang.String a(android.content.Context context, java.lang.String str) {
        java.lang.String strB;
        synchronized (this) {
            if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
                throw new java.lang.IllegalStateException("Cannot run on MainThread");
            }
            if (this.f1378a == null) {
                android.content.Intent intent = new android.content.Intent();
                intent.setComponent(new android.content.ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
                intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
                if (context.bindService(intent, this.e, 1)) {
                    synchronized (this.d) {
                        try {
                            this.d.wait(3000L);
                        } catch (java.lang.InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (this.f1378a == null) {
                    strB = "";
                } else {
                    try {
                        strB = b(context, str);
                    } catch (java.lang.Exception e2) {
                        e2.printStackTrace();
                        strB = "";
                    }
                }
            } else {
                strB = b(context, str);
            }
        }
        return strB;
    }

    public boolean a(android.content.Context context) {
        boolean z = false;
        try {
            android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 0);
            if (android.os.Build.VERSION.SDK_INT < 28 ? !(packageInfo == null || packageInfo.versionCode < 1) : !(packageInfo == null || packageInfo.getLongVersionCode() < 1)) {
                z = true;
            }
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return z;
    }

    public final java.lang.String b(android.content.Context context, java.lang.String str) {
        android.content.pm.Signature[] signatureArr;
        if (android.text.TextUtils.isEmpty(this.b)) {
            this.b = context.getPackageName();
        }
        if (android.text.TextUtils.isEmpty(this.c)) {
            java.lang.String string = null;
            try {
                signatureArr = context.getPackageManager().getPackageInfo(this.b, 64).signatures;
            } catch (android.content.pm.PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                signatureArr = null;
            }
            if (signatureArr != null && signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("SHA1");
                    if (messageDigest != null) {
                        byte[] bArrDigest = messageDigest.digest(byteArray);
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        for (byte b : bArrDigest) {
                            sb.append(java.lang.Integer.toHexString((b & 255) | 256).substring(1, 3));
                        }
                        string = sb.toString();
                    }
                } catch (java.security.NoSuchAlgorithmException e2) {
                    e2.printStackTrace();
                }
            }
            this.c = string;
        }
        java.lang.String strA = ((com.tencent.ydkqmsp.sdk.g.g.d.a.C0060a) this.f1378a).a(this.b, this.c, str);
        return android.text.TextUtils.isEmpty(strA) ? "" : strA;
    }
}
