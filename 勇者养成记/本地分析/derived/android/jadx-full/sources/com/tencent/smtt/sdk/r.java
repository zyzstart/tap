package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class r extends android.widget.FrameLayout implements android.media.MediaPlayer.OnErrorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.lang.Object f948a;
    private com.tencent.smtt.sdk.t b;
    private android.widget.VideoView c;
    private android.content.Context d;
    private java.lang.String e;

    public r(android.content.Context context) {
        super(context.getApplicationContext());
        this.d = null;
        this.d = context;
    }

    private void b(android.os.Bundle bundle, java.lang.Object obj) {
        boolean zA;
        a();
        if (b()) {
            bundle.putInt("callMode", bundle.getInt("callMode"));
            zA = this.b.a(this.f948a, bundle, this, obj);
        } else {
            zA = false;
        }
        if (zA) {
            return;
        }
        android.widget.VideoView videoView = this.c;
        if (videoView != null) {
            videoView.stopPlayback();
        }
        if (this.c == null) {
            this.c = new android.widget.VideoView(getContext());
        }
        java.lang.String string = bundle.getString("videoUrl");
        this.e = string;
        this.c.setVideoURI(android.net.Uri.parse(string));
        this.c.setOnErrorListener(this);
        android.content.Intent intent = new android.content.Intent("com.tencent.smtt.tbs.video.PLAY");
        intent.addFlags(268435456);
        android.content.Context applicationContext = getContext().getApplicationContext();
        intent.setPackage(applicationContext.getPackageName());
        applicationContext.startActivity(intent);
    }

    void a() {
        setBackgroundColor(-16777216);
        if (this.b == null) {
            com.tencent.smtt.sdk.d.a(true).a(getContext().getApplicationContext(), false, false);
            com.tencent.smtt.sdk.s sVarA = com.tencent.smtt.sdk.d.a(true).a();
            com.tencent.smtt.export.external.DexLoader dexLoaderB = sVarA != null ? sVarA.b() : null;
            if (dexLoaderB != null && com.tencent.smtt.sdk.QbSdk.canLoadVideo(getContext())) {
                this.b = new com.tencent.smtt.sdk.t(dexLoaderB);
            }
        }
        com.tencent.smtt.sdk.t tVar = this.b;
        if (tVar == null || this.f948a != null) {
            return;
        }
        this.f948a = tVar.a(getContext().getApplicationContext());
    }

    public void a(android.app.Activity activity) {
        android.widget.VideoView videoView;
        if (b() || (videoView = this.c) == null) {
            return;
        }
        if (videoView.getParent() == null) {
            android.view.Window window = activity.getWindow();
            android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) window.getDecorView();
            window.addFlags(1024);
            window.addFlags(128);
            frameLayout.setBackgroundColor(-16777216);
            android.widget.MediaController mediaController = new android.widget.MediaController(activity);
            mediaController.setMediaPlayer(this.c);
            this.c.setMediaController(mediaController);
            android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            frameLayout.addView(this.c, layoutParams);
        }
        if (android.os.Build.VERSION.SDK_INT >= 8) {
            this.c.start();
        }
    }

    void a(android.app.Activity activity, int i) {
        android.widget.VideoView videoView;
        android.widget.VideoView videoView2;
        if (i == 3 && !b() && (videoView2 = this.c) != null) {
            videoView2.pause();
        }
        if (i == 4) {
            this.d = null;
            if (!b() && (videoView = this.c) != null) {
                videoView.stopPlayback();
                this.c = null;
            }
        }
        if (i == 2 && !b()) {
            this.d = activity;
            a(activity);
        }
        if (b()) {
            this.b.a(this.f948a, activity, i);
        }
    }

    void a(android.os.Bundle bundle, java.lang.Object obj) {
        b(bundle, obj);
    }

    public boolean b() {
        return (this.b == null || this.f948a == null) ? false : true;
    }

    public void c() {
        if (b()) {
            this.b.a(this.f948a);
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(android.media.MediaPlayer mediaPlayer, int i, int i2) {
        try {
            if (this.d instanceof android.app.Activity) {
                android.app.Activity activity = (android.app.Activity) this.d;
                if (!activity.isFinishing()) {
                    activity.finish();
                }
            }
            android.content.Context context = getContext();
            if (context != null) {
                android.widget.Toast.makeText(context, "播放失败，请选择其它播放器播放", 1).show();
                android.content.Context applicationContext = context.getApplicationContext();
                android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW");
                intent.addFlags(268435456);
                intent.setDataAndType(android.net.Uri.parse(this.e), "video/*");
                applicationContext.startActivity(intent);
            }
            return true;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }
}
