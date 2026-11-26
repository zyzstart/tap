package com.tencent.open.log;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static java.text.SimpleDateFormat f709a = com.tencent.open.log.d.C0031d.a("yy.MM.dd.HH");
    private java.io.File g;
    private java.lang.String b = "Tracer.File";
    private int c = android.support.v7.widget.ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int d = android.support.v7.widget.ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int e = 4096;
    private long f = 10000;
    private int h = 10;
    private java.lang.String i = ".log";
    private long j = Long.MAX_VALUE;

    public b(java.io.File file, int i, int i2, int i3, java.lang.String str, long j, int i4, java.lang.String str2, long j2) {
        a(file);
        b(i);
        a(i2);
        c(i3);
        a(str);
        a(j);
        d(i4);
        b(str2);
        b(j2);
    }

    private java.lang.String c(java.lang.String str) {
        return "com.tencent.mobileqq_connectSdk." + str + ".log";
    }

    private java.io.File[] c(long j) {
        java.io.File file;
        java.io.File file2;
        java.io.File fileB = b();
        java.lang.String strC = c(d(j));
        try {
            file = new java.io.File(fileB, strC);
        } catch (java.lang.Throwable th) {
            com.tencent.open.log.SLog.e(com.tencent.open.log.SLog.TAG, "getWorkFile,get old sdcard file exception:", th);
            file = fileB;
        }
        java.lang.String strB = com.tencent.open.utils.l.b();
        if (android.text.TextUtils.isEmpty(strB) && strB == null) {
            file2 = null;
        } else {
            try {
                java.io.File file3 = new java.io.File(strB, com.tencent.open.log.c.o);
                if (!file3.exists()) {
                    file3.mkdirs();
                }
                file2 = new java.io.File(file3, strC);
            } catch (java.lang.Exception e) {
                com.tencent.open.log.SLog.e(com.tencent.open.log.SLog.TAG, "getWorkFile,get app specific file exception:", e);
                file2 = null;
            }
        }
        return new java.io.File[]{file, file2};
    }

    private java.lang.String d(long j) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return new java.text.SimpleDateFormat("yy.MM.dd.HH").format(calendar.getTime());
    }

    public void a(int i) {
        this.c = i;
    }

    public void a(long j) {
        this.f = j;
    }

    public void a(java.io.File file) {
        this.g = file;
    }

    public void a(java.lang.String str) {
        this.b = str;
    }

    public java.io.File[] a() {
        return c(java.lang.System.currentTimeMillis());
    }

    public java.io.File b() {
        java.io.File fileE = e();
        if (fileE != null) {
            fileE.mkdirs();
        }
        return fileE;
    }

    public void b(int i) {
        this.d = i;
    }

    public void b(long j) {
        this.j = j;
    }

    public void b(java.lang.String str) {
        this.i = str;
    }

    public java.lang.String c() {
        return this.b;
    }

    public void c(int i) {
        this.e = i;
    }

    public int d() {
        return this.e;
    }

    public void d(int i) {
        this.h = i;
    }

    public java.io.File e() {
        return this.g;
    }

    public int f() {
        return this.h;
    }
}
