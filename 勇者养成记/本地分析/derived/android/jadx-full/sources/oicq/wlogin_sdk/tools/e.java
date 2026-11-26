package oicq.wlogin_sdk.tools;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class e implements java.io.FilenameFilter {
    e() {
    }

    @Override // java.io.FilenameFilter
    public boolean accept(java.io.File file, java.lang.String str) {
        return str.matches("wtlogin_[0-9]+\\.log");
    }
}
