package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.tencent.smtt.sdk.u f951a;
    private static java.nio.channels.FileLock e;
    private com.tencent.smtt.sdk.v b;
    private boolean c;
    private boolean d;

    private u() {
    }

    public static com.tencent.smtt.sdk.u a() {
        if (f951a == null) {
            synchronized (com.tencent.smtt.sdk.u.class) {
                if (f951a == null) {
                    f951a = new com.tencent.smtt.sdk.u();
                }
            }
        }
        return f951a;
    }

    public com.tencent.smtt.sdk.v a(boolean z) {
        return z ? this.b : c();
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0063 A[Catch: all -> 0x01c7, TryCatch #3 {, blocks: (B:3:0x0001, B:6:0x0023, B:8:0x0027, B:17:0x005f, B:19:0x0063, B:22:0x007a, B:24:0x0096, B:41:0x0109, B:43:0x0115, B:52:0x01c3, B:44:0x013a, B:40:0x0106, B:45:0x015e, B:47:0x0164, B:48:0x0184, B:49:0x01a4, B:51:0x01c0, B:14:0x0041, B:15:0x005c, B:20:0x0072, B:28:0x00a7, B:31:0x00b1, B:32:0x00b9, B:34:0x00bd, B:35:0x00ec, B:37:0x00f0, B:9:0x0032, B:11:0x003a), top: B:60:0x0001, inners: #1, #4 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x0096 A[Catch: all -> 0x01c7, TRY_LEAVE, TryCatch #3 {, blocks: (B:3:0x0001, B:6:0x0023, B:8:0x0027, B:17:0x005f, B:19:0x0063, B:22:0x007a, B:24:0x0096, B:41:0x0109, B:43:0x0115, B:52:0x01c3, B:44:0x013a, B:40:0x0106, B:45:0x015e, B:47:0x0164, B:48:0x0184, B:49:0x01a4, B:51:0x01c0, B:14:0x0041, B:15:0x005c, B:20:0x0072, B:28:0x00a7, B:31:0x00b1, B:32:0x00b9, B:34:0x00bd, B:35:0x00ec, B:37:0x00f0, B:9:0x0032, B:11:0x003a), top: B:60:0x0001, inners: #1, #4 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x00a3 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:45:0x015e A[Catch: all -> 0x01c7, TryCatch #3 {, blocks: (B:3:0x0001, B:6:0x0023, B:8:0x0027, B:17:0x005f, B:19:0x0063, B:22:0x007a, B:24:0x0096, B:41:0x0109, B:43:0x0115, B:52:0x01c3, B:44:0x013a, B:40:0x0106, B:45:0x015e, B:47:0x0164, B:48:0x0184, B:49:0x01a4, B:51:0x01c0, B:14:0x0041, B:15:0x005c, B:20:0x0072, B:28:0x00a7, B:31:0x00b1, B:32:0x00b9, B:34:0x00bd, B:35:0x00ec, B:37:0x00f0, B:9:0x0032, B:11:0x003a), top: B:60:0x0001, inners: #1, #4 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x0164 A[Catch: all -> 0x01c7, TryCatch #3 {, blocks: (B:3:0x0001, B:6:0x0023, B:8:0x0027, B:17:0x005f, B:19:0x0063, B:22:0x007a, B:24:0x0096, B:41:0x0109, B:43:0x0115, B:52:0x01c3, B:44:0x013a, B:40:0x0106, B:45:0x015e, B:47:0x0164, B:48:0x0184, B:49:0x01a4, B:51:0x01c0, B:14:0x0041, B:15:0x005c, B:20:0x0072, B:28:0x00a7, B:31:0x00b1, B:32:0x00b9, B:34:0x00bd, B:35:0x00ec, B:37:0x00f0, B:9:0x0032, B:11:0x003a), top: B:60:0x0001, inners: #1, #4 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x0184 A[Catch: all -> 0x01c7, TryCatch #3 {, blocks: (B:3:0x0001, B:6:0x0023, B:8:0x0027, B:17:0x005f, B:19:0x0063, B:22:0x007a, B:24:0x0096, B:41:0x0109, B:43:0x0115, B:52:0x01c3, B:44:0x013a, B:40:0x0106, B:45:0x015e, B:47:0x0164, B:48:0x0184, B:49:0x01a4, B:51:0x01c0, B:14:0x0041, B:15:0x005c, B:20:0x0072, B:28:0x00a7, B:31:0x00b1, B:32:0x00b9, B:34:0x00bd, B:35:0x00ec, B:37:0x00f0, B:9:0x0032, B:11:0x003a), top: B:60:0x0001, inners: #1, #4 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x01a4 A[Catch: all -> 0x01c7, TryCatch #3 {, blocks: (B:3:0x0001, B:6:0x0023, B:8:0x0027, B:17:0x005f, B:19:0x0063, B:22:0x007a, B:24:0x0096, B:41:0x0109, B:43:0x0115, B:52:0x01c3, B:44:0x013a, B:40:0x0106, B:45:0x015e, B:47:0x0164, B:48:0x0184, B:49:0x01a4, B:51:0x01c0, B:14:0x0041, B:15:0x005c, B:20:0x0072, B:28:0x00a7, B:31:0x00b1, B:32:0x00b9, B:34:0x00bd, B:35:0x00ec, B:37:0x00f0, B:9:0x0032, B:11:0x003a), top: B:60:0x0001, inners: #1, #4 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x01c0 A[Catch: all -> 0x01c7, TryCatch #3 {, blocks: (B:3:0x0001, B:6:0x0023, B:8:0x0027, B:17:0x005f, B:19:0x0063, B:22:0x007a, B:24:0x0096, B:41:0x0109, B:43:0x0115, B:52:0x01c3, B:44:0x013a, B:40:0x0106, B:45:0x015e, B:47:0x0164, B:48:0x0184, B:49:0x01a4, B:51:0x01c0, B:14:0x0041, B:15:0x005c, B:20:0x0072, B:28:0x00a7, B:31:0x00b1, B:32:0x00b9, B:34:0x00bd, B:35:0x00ec, B:37:0x00f0, B:9:0x0032, B:11:0x003a), top: B:60:0x0001, inners: #1, #4 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:47:0x0164, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:48:0x0184, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:49:0x01a4, please report this as an issue */
    public synchronized void a(android.content.Context context) {
        java.lang.Throwable th;
        com.tencent.smtt.utils.TbsLog.i("X5CoreEngine", "init #1");
        com.tencent.smtt.sdk.d dVarA = com.tencent.smtt.sdk.d.a(true);
        dVarA.a(context, false, false);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        com.tencent.smtt.sdk.s sVarA = dVarA.a();
        if (!dVarA.b() || sVarA == null) {
            this.c = false;
            sb.append("can not use X5 by !tbs available");
        } else {
            if (!this.d) {
                com.tencent.smtt.sdk.v vVar = new com.tencent.smtt.sdk.v(sVarA.b());
                this.b = vVar;
                try {
                    boolean zA = vVar.a();
                    this.c = zA;
                    if (!zA) {
                        sb.append("can not use X5 by x5corewizard return false");
                    }
                } catch (java.lang.NoSuchMethodException unused) {
                    this.c = true;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    this.c = false;
                    sb.append("can not use x5 by throwable " + android.util.Log.getStackTraceString(th));
                    if (this.c) {
                        com.tencent.smtt.sdk.CookieManager.getInstance().a(context, true, true);
                        com.tencent.smtt.sdk.CookieManager.getInstance().a();
                    }
                    com.tencent.smtt.utils.TbsLog.i("X5CoreEngine", "init  mCanUseX5 is " + this.c);
                    if (this.c) {
                        com.tencent.smtt.utils.TbsLog.i("X5CoreEngine", "init  sTbsCoreLoadFileLock is " + e);
                        if (e == null) {
                            b(context);
                        }
                    } else {
                        com.tencent.smtt.utils.TbsLog.e("X5CoreEngine", "mCanUseX5 is false --> report");
                        if (!dVarA.b()) {
                            if (dVarA.b()) {
                                com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, com.tencent.smtt.sdk.TbsListener.ErrorCode.INFO_CAN_NOT_USE_X5_TBS_AVAILABLE, new java.lang.Throwable("mCanUseX5=false, available true, reason: " + th));
                            } else {
                                com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, com.tencent.smtt.sdk.TbsListener.ErrorCode.INFO_CAN_NOT_USE_X5_TBS_NOTAVAILABLE, new java.lang.Throwable("mCanUseX5=false, available false, reason: " + th));
                            }
                        } else if (dVarA.b()) {
                            com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, com.tencent.smtt.sdk.TbsListener.ErrorCode.INFO_CAN_NOT_USE_X5_TBS_AVAILABLE, new java.lang.Throwable("mCanUseX5=false, available true, reason: " + th));
                        } else {
                            com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, com.tencent.smtt.sdk.TbsListener.ErrorCode.INFO_CAN_NOT_USE_X5_TBS_NOTAVAILABLE, new java.lang.Throwable("mCanUseX5=false, available false, reason: " + th));
                        }
                    }
                    this.d = true;
                }
                th = null;
                if (this.c) {
                    com.tencent.smtt.sdk.CookieManager.getInstance().a(context, true, true);
                    com.tencent.smtt.sdk.CookieManager.getInstance().a();
                }
            }
            com.tencent.smtt.utils.TbsLog.i("X5CoreEngine", "init  mCanUseX5 is " + this.c);
            if (this.c) {
                com.tencent.smtt.utils.TbsLog.e("X5CoreEngine", "mCanUseX5 is false --> report");
                if (!dVarA.b() && sVarA != null && th == null) {
                    try {
                        com.tencent.smtt.export.external.DexLoader dexLoaderB = sVarA.b();
                        java.lang.Object objInvokeStaticMethod = dexLoaderB != null ? dexLoaderB.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new java.lang.Class[0], new java.lang.Object[0]) : null;
                        if (objInvokeStaticMethod instanceof java.lang.Throwable) {
                            java.lang.Throwable th3 = (java.lang.Throwable) objInvokeStaticMethod;
                            sb.append("#" + th3.getMessage() + "; cause: " + th3.getCause() + "; th: " + th3);
                        }
                        if (objInvokeStaticMethod instanceof java.lang.String) {
                            sb.append("failure detail:" + objInvokeStaticMethod);
                        }
                    } catch (java.lang.Throwable th4) {
                        th4.printStackTrace();
                    }
                    if (sb.toString().contains("isPreloadX5Disabled:-10000")) {
                        com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, com.tencent.smtt.sdk.TbsListener.ErrorCode.INFO_CAN_NOT_DISABLED_BY_CRASH, new java.lang.Throwable("X5CoreEngine::init, mCanUseX5=false, available true, details: " + sb.toString()));
                    } else {
                        com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, com.tencent.smtt.sdk.TbsListener.ErrorCode.INFO_CAN_NOT_LOAD_X5, new java.lang.Throwable("X5CoreEngine::init, mCanUseX5=false, available true, details: " + sb.toString()));
                    }
                } else if (dVarA.b()) {
                    com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, com.tencent.smtt.sdk.TbsListener.ErrorCode.INFO_CAN_NOT_USE_X5_TBS_AVAILABLE, new java.lang.Throwable("mCanUseX5=false, available true, reason: " + th));
                } else {
                    com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, com.tencent.smtt.sdk.TbsListener.ErrorCode.INFO_CAN_NOT_USE_X5_TBS_NOTAVAILABLE, new java.lang.Throwable("mCanUseX5=false, available false, reason: " + th));
                }
            } else {
                com.tencent.smtt.utils.TbsLog.i("X5CoreEngine", "init  sTbsCoreLoadFileLock is " + e);
                if (e == null) {
                    b(context);
                }
            }
            this.d = true;
        }
        th = null;
        com.tencent.smtt.utils.TbsLog.i("X5CoreEngine", "init  mCanUseX5 is " + this.c);
        if (this.c) {
            com.tencent.smtt.utils.TbsLog.e("X5CoreEngine", "mCanUseX5 is false --> report");
            if (!dVarA.b()) {
                if (dVarA.b()) {
                    com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, com.tencent.smtt.sdk.TbsListener.ErrorCode.INFO_CAN_NOT_USE_X5_TBS_AVAILABLE, new java.lang.Throwable("mCanUseX5=false, available true, reason: " + th));
                } else {
                    com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, com.tencent.smtt.sdk.TbsListener.ErrorCode.INFO_CAN_NOT_USE_X5_TBS_NOTAVAILABLE, new java.lang.Throwable("mCanUseX5=false, available false, reason: " + th));
                }
            } else if (dVarA.b()) {
                com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, com.tencent.smtt.sdk.TbsListener.ErrorCode.INFO_CAN_NOT_USE_X5_TBS_AVAILABLE, new java.lang.Throwable("mCanUseX5=false, available true, reason: " + th));
            } else {
                com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, com.tencent.smtt.sdk.TbsListener.ErrorCode.INFO_CAN_NOT_USE_X5_TBS_NOTAVAILABLE, new java.lang.Throwable("mCanUseX5=false, available false, reason: " + th));
            }
            throw th;
        }
        com.tencent.smtt.utils.TbsLog.i("X5CoreEngine", "init  sTbsCoreLoadFileLock is " + e);
        if (e == null) {
            b(context);
        }
        this.d = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public java.nio.channels.FileLock b(android.content.Context context) {
        java.lang.String str;
        java.lang.String str2;
        com.tencent.smtt.utils.TbsLog.i("X5CoreEngine", "tryTbsCoreLoadFileLock ##");
        java.nio.channels.FileLock fileLock = e;
        if (fileLock != null) {
            return fileLock;
        }
        synchronized (com.tencent.smtt.sdk.u.class) {
            if (e == null) {
                java.nio.channels.FileLock fileLockE = com.tencent.smtt.utils.f.e(context);
                e = fileLockE;
                if (fileLockE == null) {
                    str = "X5CoreEngine";
                    str2 = "init -- sTbsCoreLoadFileLock failed!";
                } else {
                    str = "X5CoreEngine";
                    str2 = "init -- sTbsCoreLoadFileLock succeeded: " + e;
                }
                com.tencent.smtt.utils.TbsLog.i(str, str2);
            }
        }
        return e;
    }

    public boolean b() {
        if (com.tencent.smtt.sdk.QbSdk.f818a) {
            return false;
        }
        return this.c;
    }

    public com.tencent.smtt.sdk.v c() {
        if (com.tencent.smtt.sdk.QbSdk.f818a) {
            return null;
        }
        return this.b;
    }

    boolean d() {
        return this.d;
    }
}
