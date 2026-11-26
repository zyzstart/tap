package cn.yunzhisheng.nlu;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class OfflineNlu {
    static {
        java.lang.System.loadLibrary("offlinenlujni");
    }

    public java.lang.String a(java.lang.String str, java.lang.String str2) {
        return getNluJson(str, str2);
    }

    public void a() {
        clear();
    }

    public int b(java.lang.String str, java.lang.String str2) {
        return loadConf(str, str2);
    }

    public native void clear();

    public native java.lang.String getNluJson(java.lang.String str, java.lang.String str2);

    public native int loadConf(java.lang.String str, java.lang.String str2);
}
