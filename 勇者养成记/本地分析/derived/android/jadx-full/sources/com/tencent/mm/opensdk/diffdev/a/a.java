package com.tencent.mm.opensdk.diffdev.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a implements com.tencent.mm.opensdk.diffdev.IDiffDevOAuth {
    private com.tencent.mm.opensdk.diffdev.a.d d;
    private android.os.Handler handler = null;
    private java.util.List c = new java.util.ArrayList();
    private com.tencent.mm.opensdk.diffdev.OAuthListener e = new com.tencent.mm.opensdk.diffdev.a.b(this);

    static /* synthetic */ com.tencent.mm.opensdk.diffdev.a.d c(com.tencent.mm.opensdk.diffdev.a.a aVar) {
        aVar.d = null;
        return null;
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public final void addListener(com.tencent.mm.opensdk.diffdev.OAuthListener oAuthListener) {
        if (this.c.contains(oAuthListener)) {
            return;
        }
        this.c.add(oAuthListener);
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public final boolean auth(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, com.tencent.mm.opensdk.diffdev.OAuthListener oAuthListener) {
        com.tencent.mm.opensdk.utils.Log.i("MicroMsg.SDK.DiffDevOAuth", "start auth, appId = " + str);
        if (str == null || str.length() <= 0 || str2 == null || str2.length() <= 0) {
            com.tencent.mm.opensdk.utils.Log.d("MicroMsg.SDK.DiffDevOAuth", java.lang.String.format("auth fail, invalid argument, appId = %s, scope = %s", str, str2));
            return false;
        }
        if (this.handler == null) {
            this.handler = new android.os.Handler(android.os.Looper.getMainLooper());
        }
        addListener(oAuthListener);
        if (this.d != null) {
            com.tencent.mm.opensdk.utils.Log.d("MicroMsg.SDK.DiffDevOAuth", "auth, already running, no need to start auth again");
            return true;
        }
        com.tencent.mm.opensdk.diffdev.a.d dVar = new com.tencent.mm.opensdk.diffdev.a.d(str, str2, str3, str4, str5, this.e);
        this.d = dVar;
        if (android.os.Build.VERSION.SDK_INT >= 11) {
            dVar.executeOnExecutor(android.os.AsyncTask.THREAD_POOL_EXECUTOR, new java.lang.Void[0]);
        } else {
            dVar.execute(new java.lang.Void[0]);
        }
        return true;
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public final void detach() {
        com.tencent.mm.opensdk.utils.Log.i("MicroMsg.SDK.DiffDevOAuth", "detach");
        this.c.clear();
        stopAuth();
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public final void removeAllListeners() {
        this.c.clear();
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public final void removeListener(com.tencent.mm.opensdk.diffdev.OAuthListener oAuthListener) {
        this.c.remove(oAuthListener);
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public final boolean stopAuth() {
        boolean zA;
        com.tencent.mm.opensdk.utils.Log.i("MicroMsg.SDK.DiffDevOAuth", "stopAuth");
        try {
            zA = this.d == null ? true : this.d.a();
        } catch (java.lang.Exception e) {
            com.tencent.mm.opensdk.utils.Log.w("MicroMsg.SDK.DiffDevOAuth", "stopAuth fail, ex = " + e.getMessage());
            zA = false;
        }
        this.d = null;
        return zA;
    }
}
