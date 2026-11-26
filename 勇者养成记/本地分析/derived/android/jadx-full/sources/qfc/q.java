package qfc;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class q {
    public android.content.Context U;
    qfc.n V;
    public android.content.ServiceConnection X = new qfc.q.a();
    qfc.r aj;
    public boolean r;

    final class a implements android.content.ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            try {
                qfc.q.this.aj = qfc.r.a.c(iBinder);
                if (!qfc.q.this.c()) {
                    android.util.Log.d("MSA", "MSA OPPO not supported");
                    return;
                }
                android.util.Log.d("MSA", "MSA OPPO supported, oaid:" + qfc.q.this.b("OUID"));
                if (qfc.q.this.V != null) {
                    qfc.q.this.V.f(qfc.q.this.b("OUID"));
                }
            } catch (java.lang.Throwable th) {
                android.util.Log.d("TGPA_MID", "MSA OPPO oaid get exception.");
                th.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(android.content.ComponentName componentName) {
            android.util.Log.d("TGPA_MID", "OPPO MSA onServiceDisconnected ");
        }
    }

    public q(android.content.Context context, qfc.n nVar) {
        this.U = context;
        this.V = nVar;
    }

    final java.lang.String b(java.lang.String str) {
        if (!c() || !this.r) {
            return "";
        }
        java.lang.String string = "";
        android.content.pm.Signature[] signatureArr = null;
        java.lang.String packageName = this.U.getPackageName();
        try {
            signatureArr = this.U.getPackageManager().getPackageInfo(packageName, 64).signatures;
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (signatureArr != null && signatureArr.length > 0) {
            byte[] byteArray = signatureArr[0].toByteArray();
            try {
                java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("SHA1");
                if (messageDigest == null) {
                    return "";
                }
                byte[] bArrDigest = messageDigest.digest(byteArray);
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                for (byte b : bArrDigest) {
                    sb.append(java.lang.Integer.toHexString((b & 255) | 256).substring(1, 3));
                }
                string = sb.toString();
            } catch (java.security.NoSuchAlgorithmException e2) {
                e2.printStackTrace();
            }
        }
        return this.aj.a(packageName, string, str);
    }

    final boolean c() {
        try {
            android.content.pm.PackageManager packageManager = this.U.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            try {
                android.content.pm.PackageInfo packageInfo = packageManager.getPackageInfo("com.heytap.openid", 0);
                if (android.os.Build.VERSION.SDK_INT >= 28) {
                    return packageInfo != null && packageInfo.getLongVersionCode() >= 1;
                }
                return packageInfo != null && packageInfo.versionCode > 0;
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                return false;
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
