package com.tencent.smtt.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class TbsLogClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static com.tencent.smtt.utils.TbsLogClient f957a = null;
    static java.io.File c = null;
    static java.lang.String d = null;
    static byte[] e = null;
    private static boolean i = true;
    android.widget.TextView b;
    private java.text.SimpleDateFormat f;
    private android.content.Context g;
    private java.lang.StringBuffer h = new java.lang.StringBuffer();

    private class a implements java.lang.Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        java.lang.String f958a;

        a(java.lang.String str) {
            this.f958a = null;
            this.f958a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            android.widget.TextView textView = com.tencent.smtt.utils.TbsLogClient.this.b;
            if (textView != null) {
                textView.append(this.f958a + "\n");
            }
        }
    }

    public TbsLogClient(android.content.Context context) {
        this.f = null;
        this.g = null;
        try {
            this.g = context.getApplicationContext();
            this.f = new java.text.SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS", java.util.Locale.US);
        } catch (java.lang.Exception unused) {
            this.f = new java.text.SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
        }
    }

    private void a() {
        java.lang.String strA;
        try {
            if (c == null) {
                if (!android.os.Environment.getExternalStorageState().equals("mounted") || (strA = com.tencent.smtt.utils.f.a(this.g, 6)) == null) {
                    c = null;
                } else {
                    c = new java.io.File(strA, "tbslog.txt");
                    d = com.tencent.smtt.utils.LogFileUtils.createKey();
                    e = com.tencent.smtt.utils.LogFileUtils.createHeaderText(c.getName(), d);
                }
            }
        } catch (java.lang.NullPointerException e2) {
            e2.printStackTrace();
        } catch (java.lang.SecurityException e3) {
            e3.printStackTrace();
        }
    }

    public static void setWriteLogJIT(boolean z) {
        i = z;
    }

    public void d(java.lang.String str, java.lang.String str2) {
    }

    public void e(java.lang.String str, java.lang.String str2) {
    }

    public void i(java.lang.String str, java.lang.String str2) {
    }

    public void setLogView(android.widget.TextView textView) {
        this.b = textView;
    }

    public void showLog(java.lang.String str) {
        android.widget.TextView textView = this.b;
        if (textView != null) {
            textView.post(new com.tencent.smtt.utils.TbsLogClient.a(str));
        }
    }

    public void v(java.lang.String str, java.lang.String str2) {
    }

    public void w(java.lang.String str, java.lang.String str2) {
    }

    public void writeLog(java.lang.String str) {
        try {
            java.lang.String str2 = this.f.format(java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
            java.lang.StringBuffer stringBuffer = this.h;
            stringBuffer.append(str2);
            stringBuffer.append(" pid=");
            stringBuffer.append(android.os.Process.myPid());
            stringBuffer.append(" tid=");
            stringBuffer.append(android.os.Process.myTid());
            stringBuffer.append(str);
            stringBuffer.append("\n");
            if (java.lang.Thread.currentThread() != android.os.Looper.getMainLooper().getThread() || i) {
                writeLogToDisk();
            }
            if (this.h.length() > 524288) {
                this.h.delete(0, this.h.length());
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    public void writeLogToDisk() {
        try {
            a();
            if (c != null) {
                com.tencent.smtt.utils.LogFileUtils.writeDataToStorage(c, d, e, this.h.toString(), true);
                this.h.delete(0, this.h.length());
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }
}
