package com.tencent.ydkqmsp.sdk.g.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c implements com.tencent.ydkqmsp.sdk.base.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.content.Context f1356a;
    private com.tencent.ydkqmsp.sdk.base.IVendorCallback b;
    private java.lang.String c = null;
    private boolean d = false;

    class a implements java.lang.Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.tencent.ydkqmsp.sdk.g.b.a.C0054a c0054aA = com.tencent.ydkqmsp.sdk.g.b.a.a(com.tencent.ydkqmsp.sdk.g.b.c.this.f1356a);
                com.tencent.ydkqmsp.sdk.g.b.c.this.c = c0054aA.a();
                c0054aA.b();
                if (!android.text.TextUtils.isEmpty(com.tencent.ydkqmsp.sdk.g.b.c.this.c)) {
                    com.tencent.ydkqmsp.sdk.g.b.c.this.d = true;
                }
                if (com.tencent.ydkqmsp.sdk.g.b.c.this.b != null) {
                    com.tencent.ydkqmsp.sdk.g.b.c.this.b.onResult(com.tencent.ydkqmsp.sdk.g.b.c.this.d, com.tencent.ydkqmsp.sdk.g.b.c.this.a(com.tencent.ydkqmsp.sdk.base.f.a(com.tencent.ydkqmsp.sdk.g.b.c.this.f1356a)), com.tencent.ydkqmsp.sdk.g.b.c.this.c);
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                if (android.text.TextUtils.isEmpty(com.tencent.ydkqmsp.sdk.g.b.c.this.c)) {
                    com.tencent.ydkqmsp.sdk.g.b.c.this.d = false;
                }
                if (com.tencent.ydkqmsp.sdk.g.b.c.this.b != null) {
                    com.tencent.ydkqmsp.sdk.base.IVendorCallback iVendorCallback = com.tencent.ydkqmsp.sdk.g.b.c.this.b;
                    boolean z = com.tencent.ydkqmsp.sdk.g.b.c.this.d;
                    com.tencent.ydkqmsp.sdk.g.b.c cVar = com.tencent.ydkqmsp.sdk.g.b.c.this;
                    iVendorCallback.onResult(z, cVar.a(com.tencent.ydkqmsp.sdk.base.f.a(cVar.f1356a)), com.tencent.ydkqmsp.sdk.g.b.c.this.c);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String a(java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return "";
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("0x1008611");
            sb.append(str);
            sb.append("0xdzfdweiwu");
            return b(sb.toString());
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    private java.lang.String b(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            java.lang.String str2 = "";
            for (byte b : java.security.MessageDigest.getInstance("MD5").digest(str.getBytes())) {
                java.lang.String hexString = java.lang.Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("0");
                    sb.append(hexString);
                    hexString = sb.toString();
                }
                str2 = str2 + hexString;
            }
            return str2;
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public java.lang.String a() {
        return this.c;
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public void a(android.content.Context context, com.tencent.ydkqmsp.sdk.base.IVendorCallback iVendorCallback) {
        this.f1356a = context;
        this.b = iVendorCallback;
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public java.lang.String b() {
        return a(com.tencent.ydkqmsp.sdk.base.f.a(this.f1356a));
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public void c() {
        new java.lang.Thread(new com.tencent.ydkqmsp.sdk.g.b.c.a()).start();
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public boolean d() {
        return false;
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public boolean e() {
        return false;
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public void f() {
    }
}
