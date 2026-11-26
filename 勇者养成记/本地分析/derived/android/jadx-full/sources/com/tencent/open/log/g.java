package com.tencent.open.log;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.tencent.open.log.g f714a = new com.tencent.open.log.g();

    public final java.lang.String a(int i) {
        if (i == 1) {
            return "V";
        }
        if (i == 2) {
            return "D";
        }
        if (i == 4) {
            return "I";
        }
        if (i == 8) {
            return "W";
        }
        if (i != 16) {
            return i != 32 ? "-" : "A";
        }
        return "E";
    }

    public java.lang.String a(int i, java.lang.Thread thread, long j, java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        long j2 = j % 1000;
        android.text.format.Time time = new android.text.format.Time();
        time.set(j);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(a(i));
        sb.append('/');
        sb.append(time.format("%Y-%m-%d %H:%M:%S"));
        sb.append('.');
        if (j2 < 10) {
            sb.append("00");
        } else if (j2 < 100) {
            sb.append('0');
        }
        sb.append(j2);
        sb.append(' ');
        sb.append('[');
        sb.append(thread == null ? "N/A" : thread.getName());
        sb.append(']');
        sb.append('[');
        sb.append(str);
        sb.append(']');
        sb.append(' ');
        sb.append(str2);
        sb.append('\n');
        if (th != null) {
            sb.append("* Exception : \n");
            sb.append(android.util.Log.getStackTraceString(th));
            sb.append('\n');
        }
        return sb.toString();
    }
}
