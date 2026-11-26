package qfc;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class ac {
    private static int ax = 1;
    private static java.io.FileOutputStream az = null;
    private static boolean p = false;

    public static void a() {
        ax = 7;
    }

    public static void a(java.lang.String str, java.lang.String str2) {
        if (ax >= 3 || p) {
            if (str2 == null) {
                str2 = "";
            }
            if (p) {
                h(qfc.x.b(qfc.x.a.PATTERN2.S) + " " + str + " : " + str2 + "\n");
            }
            android.util.Log.d(str, str2);
        }
    }

    public static void a(java.lang.String str, java.util.HashMap map) {
        if (ax >= 3 || p) {
            for (java.util.Map.Entry entry : map.entrySet()) {
                a("TGPA", str + ": key: " + ((java.lang.String) entry.getKey()) + " , value: " + ((java.lang.String) entry.getValue()));
            }
        }
    }

    public static boolean a(java.lang.String str) {
        if (str == null) {
            return false;
        }
        java.io.File file = new java.io.File(str);
        if (file.exists() && file.canRead()) {
            p = true;
            try {
                if (file.length() > 10485760) {
                    file.delete();
                    file.createNewFile();
                }
                az = new java.io.FileOutputStream(file, true);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                p = false;
            }
        }
        return p;
    }

    public static void b(java.lang.String str, java.lang.String str2) {
        if (ax >= 6 || p) {
            if (p) {
                h(qfc.x.b(qfc.x.a.PATTERN2.S) + " " + str + " : " + str2 + "\n");
            }
            android.util.Log.e(str, str2);
        }
    }

    private static void h(java.lang.String str) {
        try {
            if (az != null) {
                az.write(str.getBytes());
                az.flush();
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public static void j(java.lang.String str) {
        a("TGPA", str);
    }
}
