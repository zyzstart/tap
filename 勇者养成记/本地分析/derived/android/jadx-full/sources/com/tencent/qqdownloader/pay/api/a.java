package com.tencent.qqdownloader.pay.api;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class a implements com.tencent.qqdownloader.pay.api.IQQDownloaderApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.content.Context f744a;
    private com.tencent.qqdownloader.pay.api.IQQDownloaderApi.AuthListener b = null;
    private java.lang.String c = "";
    private int d = 0;

    public a(android.content.Context context) {
        this.f744a = context;
        a();
    }

    private void a() {
        android.content.pm.ApplicationInfo applicationInfo;
        android.os.Bundle bundle;
        try {
            applicationInfo = this.f744a.getPackageManager().getApplicationInfo(this.f744a.getPackageName(), 128);
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            applicationInfo = null;
        }
        if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
            return;
        }
        this.c = bundle.getString("YSDK_AUTH_KEY");
        this.d = applicationInfo.metaData.getInt("YSDK_AUTH_KEY_VERSION");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.tencent.qqdownloader.pay.api.IQQDownloaderApi.AuthListener authListener) {
        android.content.pm.PackageInfo packageInfoA = com.tencent.qqdownloader.pay.a.a.a(this.f744a, "com.tencent.android.qqdownloader", 64);
        if (packageInfoA == null) {
            a(authListener, -1);
            return;
        }
        if (packageInfoA.versionCode < com.tencent.qqdownloader.pay.utils.e.a() && !com.tencent.qqdownloader.pay.utils.e.b(this.f744a)) {
            a(authListener, -3);
        } else if (packageInfoA.signatures == null) {
            a(authListener, -2);
        } else {
            new android.os.Handler(android.os.Looper.getMainLooper()).post(new java.lang.Runnable() { // from class: com.tencent.qqdownloader.pay.api.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.qqdownloader.pay.d.a aVar = new com.tencent.qqdownloader.pay.d.a(com.tencent.qqdownloader.pay.api.a.this.f744a);
                    aVar.a(new com.tencent.qqdownloader.pay.d.a.InterfaceC0034a() { // from class: com.tencent.qqdownloader.pay.api.a.1.1
                        @Override // com.tencent.qqdownloader.pay.d.a.InterfaceC0034a
                        public void a() {
                            com.tencent.qqdownloader.pay.utils.e.a(com.tencent.qqdownloader.pay.api.a.this.f744a);
                        }

                        @Override // com.tencent.qqdownloader.pay.d.a.InterfaceC0034a
                        public void b() {
                            java.lang.System.exit(0);
                        }
                    });
                    aVar.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() { // from class: com.tencent.qqdownloader.pay.api.a.1.2
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(android.content.DialogInterface dialogInterface) {
                            java.lang.System.exit(0);
                        }
                    });
                    aVar.show();
                    aVar.a("本应用需要最新版应用宝获取版权认证");
                    aVar.c("去认证");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.tencent.qqdownloader.pay.api.IQQDownloaderApi.AuthListener authListener, final int i) {
        com.tencent.qqdownloader.pay.utils.i.a("api.impl", "Auth failed:" + i);
        if (i == -105 || i == -108) {
            com.tencent.qqdownloader.pay.a.a.a(this.f744a, "");
        }
        if (i == -106) {
            a(authListener);
        } else {
            new android.os.Handler(android.os.Looper.getMainLooper()).post(new java.lang.Runnable() { // from class: com.tencent.qqdownloader.pay.api.a.4
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.qqdownloader.pay.api.a.this.b(authListener, i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.lang.String str, final com.tencent.qqdownloader.pay.api.IQQDownloaderApi.AuthListener authListener) {
        final java.lang.String strValueOf = java.lang.String.valueOf(java.lang.System.currentTimeMillis());
        com.tencent.qqdownloader.pay.b.a.C0033a.a(this.f744a).a("[REDACTED]", str).a(strValueOf).b(this.c).a(this.d).a(new com.tencent.qqdownloader.pay.b.a.b() { // from class: com.tencent.qqdownloader.pay.api.a.2
            @Override // com.tencent.qqdownloader.pay.b.a.b
            public void a(int i) {
                com.tencent.qqdownloader.pay.api.a.this.a(authListener, i);
            }

            @Override // com.tencent.qqdownloader.pay.b.a.b
            public void a(org.json.JSONObject jSONObject) {
                com.tencent.qqdownloader.pay.c.a aVar = new com.tencent.qqdownloader.pay.c.a(jSONObject, strValueOf, com.tencent.qqdownloader.pay.api.a.this.c);
                if (aVar.b()) {
                    com.tencent.qqdownloader.pay.api.a.this.b(authListener);
                } else {
                    com.tencent.qqdownloader.pay.api.a.this.a(authListener, aVar.a());
                }
            }
        }).a().a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        android.content.Intent intent = new android.content.Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(android.net.Uri.parse("https://a.app.qq.com/o/ysdk_auth_downyyb"));
        this.f744a.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.tencent.qqdownloader.pay.api.IQQDownloaderApi.AuthListener authListener) {
        if (authListener != null) {
            new android.os.Handler(android.os.Looper.getMainLooper()).post(new java.lang.Runnable() { // from class: com.tencent.qqdownloader.pay.api.a.3
                @Override // java.lang.Runnable
                public void run() {
                    authListener.onAuthSuceed();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.tencent.qqdownloader.pay.api.IQQDownloaderApi.AuthListener authListener, int i) {
        java.lang.String str;
        com.tencent.qqdownloader.pay.d.a aVar = new com.tencent.qqdownloader.pay.d.a(this.f744a);
        aVar.show();
        if (i == -1 || i == -3 || i == -2) {
            if (i == -1) {
                aVar.a("本应用需要最新版应用宝服务支持");
                str = "去下载";
            } else {
                aVar.a("本应用需要最新版应用宝获取权限");
                str = "更新应用宝";
            }
            aVar.c(str);
            aVar.a(new com.tencent.qqdownloader.pay.d.a.InterfaceC0034a() { // from class: com.tencent.qqdownloader.pay.api.a.5
                @Override // com.tencent.qqdownloader.pay.d.a.InterfaceC0034a
                public void a() {
                    com.tencent.qqdownloader.pay.api.a.this.b();
                    java.lang.System.exit(0);
                }

                @Override // com.tencent.qqdownloader.pay.d.a.InterfaceC0034a
                public void b() {
                    java.lang.System.exit(0);
                }
            });
        } else {
            if (i == -107) {
                aVar.a("认证失败");
                aVar.b("该账号绑定设备已超过上限（5台）");
            } else {
                aVar.a("认证失败(" + java.lang.String.valueOf(i) + ")");
                aVar.c("重试");
            }
            aVar.a(new com.tencent.qqdownloader.pay.d.a.InterfaceC0034a() { // from class: com.tencent.qqdownloader.pay.api.a.6
                @Override // com.tencent.qqdownloader.pay.d.a.InterfaceC0034a
                public void a() {
                    com.tencent.qqdownloader.pay.api.a.this.auth(authListener);
                }

                @Override // com.tencent.qqdownloader.pay.d.a.InterfaceC0034a
                public void b() {
                    java.lang.System.exit(0);
                }
            });
        }
        aVar.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() { // from class: com.tencent.qqdownloader.pay.api.a.7
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(android.content.DialogInterface dialogInterface) {
                java.lang.System.exit(0);
            }
        });
    }

    @Override // com.tencent.qqdownloader.pay.api.IQQDownloaderApi
    public void auth(final com.tencent.qqdownloader.pay.api.IQQDownloaderApi.AuthListener authListener) {
        com.tencent.qqdownloader.pay.a.d.a().a(new java.lang.Runnable() { // from class: com.tencent.qqdownloader.pay.api.a.8
            @Override // java.lang.Runnable
            public void run() {
                java.lang.String strD = com.tencent.qqdownloader.pay.a.a.d(com.tencent.qqdownloader.pay.api.a.this.f744a);
                java.lang.String strH = com.tencent.qqdownloader.pay.a.a.h(com.tencent.qqdownloader.pay.api.a.this.f744a);
                java.lang.String strD2 = com.tencent.qqdownloader.pay.a.a.d(com.tencent.qqdownloader.pay.api.a.this.f744a, strD);
                com.tencent.qqdownloader.pay.api.a.this.b = authListener;
                if (android.text.TextUtils.isEmpty(strD) || android.text.TextUtils.isEmpty(strH) || android.text.TextUtils.isEmpty(strD2) || !strH.equals(strD2)) {
                    com.tencent.qqdownloader.pay.api.a.this.a(authListener);
                } else {
                    com.tencent.qqdownloader.pay.api.a.this.a(strD, authListener);
                }
            }
        });
    }

    @Override // com.tencent.qqdownloader.pay.api.IQQDownloaderApi
    public void handler(final android.content.Intent intent) {
        if (this.b == null || intent == null) {
            return;
        }
        com.tencent.qqdownloader.pay.a.d.a().a(new java.lang.Runnable() { // from class: com.tencent.qqdownloader.pay.api.a.9
            @Override // java.lang.Runnable
            public void run() {
                int intExtra = intent.getIntExtra(com.tencent.qqdownloader.pay.a.b.d, -4);
                if (intExtra != 0) {
                    com.tencent.qqdownloader.pay.api.a aVar = com.tencent.qqdownloader.pay.api.a.this;
                    aVar.a(aVar.b, intExtra);
                    return;
                }
                java.lang.String stringExtra = intent.getStringExtra(com.tencent.qqdownloader.pay.a.b.b);
                com.tencent.qqdownloader.pay.a.a.a(com.tencent.qqdownloader.pay.api.a.this.f744a, stringExtra);
                com.tencent.qqdownloader.pay.a.a.b(com.tencent.qqdownloader.pay.api.a.this.f744a, intent.getStringExtra(com.tencent.qqdownloader.pay.a.b.f740a));
                com.tencent.qqdownloader.pay.api.a aVar2 = com.tencent.qqdownloader.pay.api.a.this;
                aVar2.a(stringExtra, aVar2.b);
            }
        });
    }

    @Override // com.tencent.qqdownloader.pay.api.IQQDownloaderApi
    public void setDebug(boolean z) {
        com.tencent.qqdownloader.pay.a.a.a(z);
    }
}
