package qfc;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class y {
    public static boolean a(java.lang.String str) {
        try {
            return qfc.v.U.getPackageManager().checkPermission(str, qfc.v.U.getPackageName()) != 0;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return true;
        }
    }
}
