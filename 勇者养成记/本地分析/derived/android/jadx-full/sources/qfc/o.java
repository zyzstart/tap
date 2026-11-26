package qfc;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static java.lang.String f1702a;
    private com.tencent.tgpa.simple.Callback ae;

    public o(com.tencent.tgpa.simple.Callback callback) {
        this.ae = callback;
    }

    public static java.lang.String h() {
        java.lang.String str = f1702a;
        return str == null ? "0" : str;
    }

    public final void a(int i) {
        com.tencent.tgpa.simple.Callback callback = this.ae;
        if (callback != null) {
            callback.getInfo("OAID", java.lang.String.valueOf(i));
        }
    }
}
