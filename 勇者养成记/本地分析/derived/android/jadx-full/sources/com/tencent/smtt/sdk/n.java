package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tencent.smtt.export.external.DexLoader f943a;
    private java.lang.Object b;

    public n(com.tencent.smtt.export.external.DexLoader dexLoader, android.content.Context context) {
        this.f943a = null;
        this.b = null;
        this.f943a = dexLoader;
        this.b = dexLoader.newInstance("com.tencent.tbs.player.TbsMediaPlayerProxy", new java.lang.Class[]{android.content.Context.class}, context);
    }

    public void a(float f) {
        this.f943a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "setVolume", new java.lang.Class[]{java.lang.Float.TYPE}, java.lang.Float.valueOf(f));
    }

    public void a(int i) {
        this.f943a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "subtitle", new java.lang.Class[]{java.lang.Integer.TYPE}, java.lang.Integer.valueOf(i));
    }

    public void a(long j) {
        this.f943a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "seek", new java.lang.Class[]{java.lang.Long.TYPE}, java.lang.Long.valueOf(j));
    }

    public void a(android.graphics.SurfaceTexture surfaceTexture) {
        this.f943a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "setSurfaceTexture", new java.lang.Class[]{android.graphics.SurfaceTexture.class}, surfaceTexture);
    }

    public void a(com.tencent.smtt.sdk.TbsMediaPlayer.TbsMediaPlayerListener tbsMediaPlayerListener) {
        this.f943a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "setPlayerListener", new java.lang.Class[]{java.lang.Object.class}, tbsMediaPlayerListener);
    }

    public void a(java.lang.String str, android.os.Bundle bundle) {
        this.f943a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "startPlay", new java.lang.Class[]{java.lang.String.class, android.os.Bundle.class}, str, bundle);
    }

    public boolean a() {
        return this.b != null;
    }

    public float b() {
        java.lang.Float f = (java.lang.Float) this.f943a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "getVolume", new java.lang.Class[0], new java.lang.Object[0]);
        if (f != null) {
            return f.floatValue();
        }
        return 0.0f;
    }

    public void b(int i) {
        this.f943a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "audio", new java.lang.Class[]{java.lang.Integer.TYPE}, java.lang.Integer.valueOf(i));
    }

    public void c() {
        this.f943a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "pause", new java.lang.Class[0], new java.lang.Object[0]);
    }

    public void d() {
        this.f943a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "play", new java.lang.Class[0], new java.lang.Object[0]);
    }

    public void e() {
        this.f943a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", cn.yunzhisheng.asr.JniUscClient.s, new java.lang.Class[0], new java.lang.Object[0]);
    }
}
