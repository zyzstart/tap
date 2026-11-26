package com.unisound.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class as {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.media.MediaPlayer f1475a;
    private android.content.Context b;
    private android.media.MediaPlayer.OnCompletionListener c;
    private int d;
    private java.lang.String e;

    public as(android.content.Context context) {
        this.b = context;
    }

    private void g() throws java.io.IOException {
        if (this.e != null) {
            this.f1475a = new android.media.MediaPlayer();
            this.f1475a.setDataSource(new java.io.FileInputStream(new java.io.File(this.e)).getFD());
            this.f1475a.prepare();
        } else if (b() != 0) {
            this.f1475a = android.media.MediaPlayer.create(this.b, b());
        }
    }

    public java.lang.String a() {
        return this.e;
    }

    public void a(int i) {
        this.e = null;
        this.d = i;
    }

    public void a(android.media.MediaPlayer.OnCompletionListener onCompletionListener) {
        this.c = onCompletionListener;
    }

    public void a(java.lang.String str) {
        this.d = 0;
        this.e = str;
    }

    public int b() {
        return this.d;
    }

    public android.media.MediaPlayer.OnCompletionListener c() {
        return this.c;
    }

    public void d() {
        e();
        try {
            g();
            this.f1475a.setOnCompletionListener(c());
            this.f1475a.start();
            this.f1475a.setLooping(false);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void e() {
        android.media.MediaPlayer mediaPlayer = this.f1475a;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.f1475a.release();
            this.f1475a = null;
        }
    }

    public boolean f() {
        android.media.MediaPlayer mediaPlayer = this.f1475a;
        if (mediaPlayer != null) {
            return mediaPlayer.isPlaying();
        }
        return false;
    }
}
