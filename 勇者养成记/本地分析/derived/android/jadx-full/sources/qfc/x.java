package qfc;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class x {

    public enum a {
        PATTERN1("yyyy_MM_dd_HH_mm_ss"),
        PATTERN2("yyyy-MM-dd HH:mm:ss"),
        PATTERN3("yyyy-MM-dd HH:mm:ss.SSS");

        java.lang.String S;

        a(java.lang.String str) {
            this.S = str;
        }
    }

    public static java.lang.String b(java.lang.String str) {
        return new java.text.SimpleDateFormat(str, java.util.Locale.CHINA).format(new java.util.Date());
    }
}
