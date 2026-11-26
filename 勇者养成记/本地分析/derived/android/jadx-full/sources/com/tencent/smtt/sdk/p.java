package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class p {
    private static com.tencent.smtt.sdk.p e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    com.tencent.smtt.sdk.r f945a;
    android.content.Context b;
    com.tencent.tbs.video.interfaces.a c;
    com.tencent.tbs.video.interfaces.IUserStateChangedListener d;

    private p(android.content.Context context) {
        this.f945a = null;
        this.b = context.getApplicationContext();
        this.f945a = new com.tencent.smtt.sdk.r(this.b);
    }

    public static synchronized com.tencent.smtt.sdk.p a(android.content.Context context) {
        if (e == null) {
            e = new com.tencent.smtt.sdk.p(context);
        }
        return e;
    }

    public void a(int i, int i2, android.content.Intent intent) {
        com.tencent.tbs.video.interfaces.a aVar = this.c;
        if (aVar != null) {
            aVar.a(i, i2, intent);
        }
    }

    void a(android.app.Activity activity, int i) {
        this.f945a.a(activity, i);
    }

    public boolean a() {
        this.f945a.a();
        return this.f945a.b();
    }

    public boolean a(java.lang.String str, android.os.Bundle bundle, com.tencent.tbs.video.interfaces.a aVar) {
        if (bundle == null) {
            bundle = new android.os.Bundle();
        }
        if (!android.text.TextUtils.isEmpty(str)) {
            bundle.putString("videoUrl", str);
        }
        if (aVar != null) {
            this.f945a.a();
            if (!this.f945a.b()) {
                return false;
            }
            this.c = aVar;
            com.tencent.tbs.video.interfaces.IUserStateChangedListener iUserStateChangedListener = new com.tencent.tbs.video.interfaces.IUserStateChangedListener() { // from class: com.tencent.smtt.sdk.p.1
                @Override // com.tencent.tbs.video.interfaces.IUserStateChangedListener
                public void onUserStateChanged() {
                    com.tencent.smtt.sdk.p.this.f945a.c();
                }
            };
            this.d = iUserStateChangedListener;
            this.c.a(iUserStateChangedListener);
            bundle.putInt("callMode", 3);
        } else {
            bundle.putInt("callMode", 1);
        }
        this.f945a.a(bundle, aVar == null ? null : this);
        return true;
    }
}
