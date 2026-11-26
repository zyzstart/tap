package com.unisound.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static java.lang.String f1490a = "asr_start_beep.mp3";
    private static java.lang.String b = "wake_up_success.wav";
    private com.unisound.common.as c;
    private java.lang.String d;
    private java.lang.String e;

    private boolean a(java.lang.String str) {
        if (str == null) {
            return false;
        }
        this.c.a(str);
        this.c.d();
        return true;
    }

    public void a(android.content.Context context) {
        this.c = new com.unisound.common.as(context);
        this.d = (context.getFilesDir().toString() + java.io.File.separator) + f1490a;
        com.unisound.common.j.a(context, "usc" + java.io.File.separatorChar + f1490a, this.d, b);
    }

    public boolean a() {
        return a(this.d);
    }

    public boolean b() {
        return a(this.e);
    }
}
