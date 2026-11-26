package com.tencent.beacon.core.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static com.tencent.beacon.core.a.l f141a;
    android.content.Context b;
    java.util.Map c;

    protected l(android.content.Context context) {
        this.b = null;
        this.c = null;
        this.b = context;
        this.c = new java.util.HashMap(5);
    }

    public static synchronized com.tencent.beacon.core.a.l a(android.content.Context context) {
        if (f141a == null) {
            f141a = new com.tencent.beacon.core.a.l(context);
        }
        return f141a;
    }

    protected synchronized java.io.File a(java.lang.String str) {
        java.io.File file;
        if (this.b.getFilesDir() == null) {
            return null;
        }
        try {
            java.io.File filesDir = this.b.getFilesDir();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("beacon_");
            sb.append(str);
            sb.append(".lock");
            file = new java.io.File(filesDir, sb.toString());
            if (!file.exists()) {
                com.tencent.beacon.core.e.d.a("[lock] create lock file: %s", file.getAbsolutePath());
                file.createNewFile();
            }
        } catch (java.io.IOException e) {
            com.tencent.beacon.core.e.d.a(e);
            file = null;
        }
        return file;
    }

    public synchronized boolean b(java.lang.String str) {
        if (str != null) {
            if (str.trim().length() > 0) {
                if (this.c.containsKey(str)) {
                    return true;
                }
                java.io.File fileA = a(str);
                if (fileA == null) {
                    return true;
                }
                try {
                    java.nio.channels.FileChannel channel = (java.nio.channels.FileChannel) this.c.get(str);
                    if (channel == null || !channel.isOpen()) {
                        com.tencent.beacon.core.e.d.a("[lock] file lock channel %s create successfully.", str);
                        channel = new java.io.FileOutputStream(fileA).getChannel();
                        this.c.put(str, channel);
                    }
                    java.nio.channels.FileLock fileLockTryLock = channel.tryLock();
                    if (fileLockTryLock != null && fileLockTryLock.isValid()) {
                        return true;
                    }
                } catch (java.lang.Throwable th) {
                    com.tencent.beacon.core.e.d.a(th);
                }
                return false;
            }
        }
        return false;
    }
}
