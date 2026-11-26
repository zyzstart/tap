package com.tencent.hlyyb.downloader.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a implements com.tencent.hlyyb.downloader.Downloader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.tencent.hlyyb.downloader.c.a f608a = new com.tencent.hlyyb.downloader.c.a();

    private a() {
        com.tencent.hlyyb.downloader.c.b.a();
    }

    public static com.tencent.hlyyb.downloader.c.a a() {
        return f608a;
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final void addNewTask(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask) throws com.tencent.hlyyb.common.HalleyException {
        if (!(downloaderTask instanceof com.tencent.hlyyb.downloader.e.h)) {
            throw new java.lang.RuntimeException("DownloaderTask should be created by Downloader.createNewTask");
        }
        com.tencent.hlyyb.downloader.c.b.a().a(downloaderTask);
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final com.tencent.hlyyb.downloader.DownloaderTask createNewTask(java.lang.String str, java.lang.String str2, java.lang.String str3, com.tencent.hlyyb.downloader.DownloaderTaskListener downloaderTaskListener) {
        return createNewTask(str, str2, str3, downloaderTaskListener, -1L, "");
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final com.tencent.hlyyb.downloader.DownloaderTask createNewTask(java.lang.String str, java.lang.String str2, java.lang.String str3, com.tencent.hlyyb.downloader.DownloaderTaskListener downloaderTaskListener, long j, java.lang.String str4) throws com.tencent.hlyyb.common.HalleyException {
        java.lang.String str5 = "";
        if (android.text.TextUtils.isEmpty(str)) {
            str5 = "url is empty.";
        } else if (downloaderTaskListener == null) {
            str5 = "listener is null.";
        }
        java.lang.String strD = com.tencent.hlyyb.common.f.c.a(str2) ? com.tencent.hlyyb.downloader.a.a.d() : str2;
        if ("".equals(str5)) {
            return new com.tencent.hlyyb.downloader.e.h(new com.tencent.hlyyb.downloader.e.d.c(str, j), strD, str3, downloaderTaskListener, j, str4);
        }
        throw new com.tencent.hlyyb.common.HalleyException(str5);
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final void deleteTask(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask, boolean z) {
        com.tencent.hlyyb.downloader.c.b.a().a(downloaderTask, z);
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final void deleteTaskByKey(java.lang.String str, boolean z) {
        com.tencent.hlyyb.downloader.c.b.a().a(str, z);
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final java.util.List getAllTasks() {
        return com.tencent.hlyyb.downloader.c.b.a().c();
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final java.util.List getCancelledTasks() {
        return com.tencent.hlyyb.downloader.c.b.a().a(true, true, false, false, true, false, false);
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final java.util.List getCompletedTasks() {
        return com.tencent.hlyyb.downloader.c.b.a().a(true, true, false, false, false, false, true);
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final java.util.List getFailedTasks() {
        return com.tencent.hlyyb.downloader.c.b.a().a(true, true, false, false, false, true, false);
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final java.util.List getIncompleteTasks() {
        return com.tencent.hlyyb.downloader.c.b.a().a(true, true, true, true, true, true, false);
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final java.util.List getRunningTasks() {
        return com.tencent.hlyyb.downloader.c.b.a().d();
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final java.lang.String getVersion() {
        return com.tencent.hlyyb.common.a.h();
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final java.util.List getWaitingTasks() {
        return com.tencent.hlyyb.downloader.c.b.a().a(true, true, false, true, false, false, false);
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final void pauseTasks(boolean z, boolean z2) {
        java.util.Iterator it = com.tencent.hlyyb.downloader.c.b.a().a(true, true, z, z2, false, false, false).iterator();
        while (it.hasNext()) {
            ((com.tencent.hlyyb.downloader.DownloaderTask) it.next()).pause();
        }
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final void resumeTasks(boolean z, boolean z2) {
        java.util.Iterator it = com.tencent.hlyyb.downloader.c.b.a().a(true, true, false, false, z, z2, false).iterator();
        while (it.hasNext()) {
            try {
                ((com.tencent.hlyyb.downloader.DownloaderTask) it.next()).resume();
            } catch (com.tencent.hlyyb.common.HalleyException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final void setNotNetworkWaitMillis(int i) {
        com.tencent.hlyyb.downloader.a.a.b(i);
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final void setPhoneGuid(java.lang.String str) {
        com.tencent.hlyyb.downloader.a.a.c(str);
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final void setProgressInterval(int i) {
        com.tencent.hlyyb.downloader.a.a.a(i);
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final void setQua1(java.lang.String str) {
        com.tencent.hlyyb.downloader.a.a.a(str);
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final void setQua2(java.lang.String str) {
        com.tencent.hlyyb.downloader.a.a.b(str);
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final void setTaskNumForCategory(com.tencent.hlyyb.downloader.DownloaderTaskCategory downloaderTaskCategory, int i) {
        com.tencent.hlyyb.downloader.f.a.a().a(downloaderTaskCategory, i);
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final void setTempFileSubfix(java.lang.String str) {
        com.tencent.hlyyb.downloader.a.a.d(str);
    }
}
