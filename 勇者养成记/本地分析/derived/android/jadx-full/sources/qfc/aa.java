package qfc;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class aa {
    public static java.lang.String a(android.content.Context context) {
        java.io.File externalFilesDir = context.getExternalFilesDir("");
        if (externalFilesDir == null) {
            externalFilesDir = context.getFilesDir();
        }
        return externalFilesDir.getPath();
    }

    public static java.lang.String b(java.lang.String str) throws java.io.IOException {
        java.io.File file = new java.io.File(str);
        if (!file.exists() || !file.canRead()) {
            return null;
        }
        java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
        byte[] bArr = new byte[1024];
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        while (true) {
            try {
                try {
                    int i = fileInputStream.read(bArr);
                    if (i <= 0) {
                        break;
                    }
                    sb.append(new java.lang.String(bArr, 0, i));
                } catch (java.lang.Exception unused) {
                    qfc.ac.j("FileUtil:readFile: exception.");
                }
            } catch (java.lang.Throwable th) {
                fileInputStream.close();
                throw th;
            }
        }
        fileInputStream.close();
        return sb.toString();
    }

    public static boolean g(java.lang.String str) {
        if (str == null) {
            return false;
        }
        return new java.io.File(str).exists();
    }
}
