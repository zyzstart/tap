package com.tencent.ysdk.shell.module.file;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class FileConfig {
    public int serverFileVersion = -1;
    public java.lang.String serverFileUrl = "";
    public boolean scan = false;
    public java.util.HashMap<java.lang.String, java.util.List<java.lang.String>> fileConfig = null;

    public java.lang.String toString() {
        return "FileConfig{serverFileVersion=" + this.serverFileVersion + ", serverFileUrl='" + this.serverFileUrl + "', scan=" + this.scan + ", fileConfig=" + this.fileConfig + '}';
    }
}
