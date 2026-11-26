package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class TbsVideoCacheTask {
    public static final java.lang.String KEY_VIDEO_CACHE_PARAM_FILENAME = "filename";
    public static final java.lang.String KEY_VIDEO_CACHE_PARAM_FOLDERPATH = "folderPath";
    public static final java.lang.String KEY_VIDEO_CACHE_PARAM_HEADER = "header";
    public static final java.lang.String KEY_VIDEO_CACHE_PARAM_URL = "url";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    android.content.Context f877a;
    com.tencent.smtt.sdk.TbsVideoCacheListener b;
    private java.lang.String e;
    private java.lang.String f;
    private boolean c = false;
    private com.tencent.smtt.sdk.o d = null;
    private java.lang.Object g = null;

    public TbsVideoCacheTask(android.content.Context context, android.os.Bundle bundle, com.tencent.smtt.sdk.TbsVideoCacheListener tbsVideoCacheListener) {
        this.f877a = null;
        this.b = null;
        this.f877a = context;
        this.b = tbsVideoCacheListener;
        if (bundle != null) {
            this.e = bundle.getString("taskId");
            this.f = bundle.getString("url");
        }
        a(bundle);
    }

    private void a(android.os.Bundle bundle) {
        com.tencent.smtt.sdk.TbsVideoCacheListener tbsVideoCacheListener;
        java.lang.String str;
        com.tencent.smtt.export.external.DexLoader dexLoaderB;
        if (this.d == null) {
            com.tencent.smtt.sdk.d.a(true).a(this.f877a, false, false);
            com.tencent.smtt.sdk.s sVarA = com.tencent.smtt.sdk.d.a(true).a();
            if (sVarA != null) {
                dexLoaderB = sVarA.b();
            } else {
                this.b.onVideoDownloadError(this, -1, "init engine error!", null);
                dexLoaderB = null;
            }
            if (dexLoaderB != null) {
                this.d = new com.tencent.smtt.sdk.o(dexLoaderB);
            } else {
                this.b.onVideoDownloadError(this, -1, "Java dexloader invalid!", null);
            }
        }
        com.tencent.smtt.sdk.o oVar = this.d;
        if (oVar != null) {
            java.lang.Object objA = oVar.a(this.f877a, this, bundle);
            this.g = objA;
            if (objA != null) {
                return;
            }
            tbsVideoCacheListener = this.b;
            str = "init task error!";
        } else {
            tbsVideoCacheListener = this.b;
            if (tbsVideoCacheListener == null) {
                return;
            } else {
                str = "init error!";
            }
        }
        tbsVideoCacheListener.onVideoDownloadError(this, -1, str, null);
    }

    public long getContentLength() {
        com.tencent.smtt.sdk.o oVar = this.d;
        if (oVar != null && this.g != null) {
            return oVar.d();
        }
        com.tencent.smtt.sdk.TbsVideoCacheListener tbsVideoCacheListener = this.b;
        if (tbsVideoCacheListener == null) {
            return 0L;
        }
        tbsVideoCacheListener.onVideoDownloadError(this, -1, "getContentLength failed, init uncompleted!", null);
        return 0L;
    }

    public int getDownloadedSize() {
        com.tencent.smtt.sdk.o oVar = this.d;
        if (oVar != null && this.g != null) {
            return oVar.e();
        }
        com.tencent.smtt.sdk.TbsVideoCacheListener tbsVideoCacheListener = this.b;
        if (tbsVideoCacheListener == null) {
            return 0;
        }
        tbsVideoCacheListener.onVideoDownloadError(this, -1, "getDownloadedSize failed, init uncompleted!", null);
        return 0;
    }

    public int getProgress() {
        com.tencent.smtt.sdk.o oVar = this.d;
        if (oVar != null && this.g != null) {
            return oVar.f();
        }
        com.tencent.smtt.sdk.TbsVideoCacheListener tbsVideoCacheListener = this.b;
        if (tbsVideoCacheListener == null) {
            return 0;
        }
        tbsVideoCacheListener.onVideoDownloadError(this, -1, "getProgress failed, init uncompleted!", null);
        return 0;
    }

    public java.lang.String getTaskID() {
        return this.e;
    }

    public java.lang.String getTaskUrl() {
        return this.f;
    }

    public void pauseTask() {
        com.tencent.smtt.sdk.o oVar = this.d;
        if (oVar != null && this.g != null) {
            oVar.a();
            return;
        }
        com.tencent.smtt.sdk.TbsVideoCacheListener tbsVideoCacheListener = this.b;
        if (tbsVideoCacheListener != null) {
            tbsVideoCacheListener.onVideoDownloadError(this, -1, "pauseTask failed, init uncompleted!", null);
        }
    }

    public void removeTask(boolean z) {
        com.tencent.smtt.sdk.o oVar = this.d;
        if (oVar != null && this.g != null) {
            oVar.a(z);
            return;
        }
        com.tencent.smtt.sdk.TbsVideoCacheListener tbsVideoCacheListener = this.b;
        if (tbsVideoCacheListener != null) {
            tbsVideoCacheListener.onVideoDownloadError(this, -1, "removeTask failed, init uncompleted!", null);
        }
    }

    public void resumeTask() {
        com.tencent.smtt.sdk.o oVar = this.d;
        if (oVar != null && this.g != null) {
            oVar.b();
            return;
        }
        com.tencent.smtt.sdk.TbsVideoCacheListener tbsVideoCacheListener = this.b;
        if (tbsVideoCacheListener != null) {
            tbsVideoCacheListener.onVideoDownloadError(this, -1, "resumeTask failed, init uncompleted!", null);
        }
    }

    public void stopTask() {
        com.tencent.smtt.sdk.o oVar = this.d;
        if (oVar != null && this.g != null) {
            oVar.c();
            return;
        }
        com.tencent.smtt.sdk.TbsVideoCacheListener tbsVideoCacheListener = this.b;
        if (tbsVideoCacheListener != null) {
            tbsVideoCacheListener.onVideoDownloadError(this, -1, "stopTask failed, init uncompleted!", null);
        }
    }
}
