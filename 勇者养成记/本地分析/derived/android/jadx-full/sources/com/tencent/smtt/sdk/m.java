package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class m {
    private static com.tencent.smtt.sdk.m d;
    private java.nio.channels.FileLock f;
    private java.io.FileOutputStream g;
    private static final java.util.concurrent.locks.ReentrantLock i = new java.util.concurrent.locks.ReentrantLock();
    private static final java.util.concurrent.locks.Lock j = new java.util.concurrent.locks.ReentrantLock();
    private static java.nio.channels.FileLock l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static java.lang.ThreadLocal f935a = new java.lang.ThreadLocal() { // from class: com.tencent.smtt.sdk.m.1
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.lang.Integer initialValue() {
            return 0;
        }
    };
    private static android.os.Handler m = null;
    private static final java.lang.Long[][] n = {new java.lang.Long[]{44006L, 39094008L}, new java.lang.Long[]{44005L, 39094008L}, new java.lang.Long[]{43910L, 38917816L}, new java.lang.Long[]{44027L, 39094008L}, new java.lang.Long[]{44028L, 39094008L}, new java.lang.Long[]{44029L, 39094008L}, new java.lang.Long[]{44030L, 39094008L}, new java.lang.Long[]{44032L, 39094008L}, new java.lang.Long[]{44033L, 39094008L}, new java.lang.Long[]{44034L, 39094008L}, new java.lang.Long[]{43909L, 38917816L}};
    static boolean b = false;
    static final java.io.FileFilter c = new java.io.FileFilter() { // from class: com.tencent.smtt.sdk.m.2
        @Override // java.io.FileFilter
        public boolean accept(java.io.File file) {
            java.lang.String name = file.getName();
            if (name == null || name.endsWith(".jar_is_first_load_dex_flag_file")) {
                return false;
            }
            if (android.os.Build.VERSION.SDK_INT >= 21 && name.endsWith(".dex")) {
                return false;
            }
            if (android.os.Build.VERSION.SDK_INT < 26 || !name.endsWith(".prof")) {
                return android.os.Build.VERSION.SDK_INT < 26 || !name.equals("oat");
            }
            return false;
        }
    };
    private static int o = 0;
    private static boolean p = false;
    private int e = 0;
    private boolean h = false;
    private boolean k = false;

    private m() {
        if (m == null) {
            m = new android.os.Handler(com.tencent.smtt.sdk.l.a().getLooper()) { // from class: com.tencent.smtt.sdk.m.3
                @Override // android.os.Handler
                public void handleMessage(android.os.Message message) throws java.lang.Throwable {
                    com.tencent.smtt.sdk.QbSdk.setTBSInstallingStatus(true);
                    switch (message.what) {
                        case 1:
                            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE");
                            java.lang.Object[] objArr = (java.lang.Object[]) message.obj;
                            com.tencent.smtt.sdk.m.this.b((android.content.Context) objArr[0], (java.lang.String) objArr[1], ((java.lang.Integer) objArr[2]).intValue());
                            break;
                        case 2:
                            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_COPY_TBS_CORE");
                            java.lang.Object[] objArr2 = (java.lang.Object[]) message.obj;
                            com.tencent.smtt.sdk.m.this.a((android.content.Context) objArr2[0], (android.content.Context) objArr2[1], ((java.lang.Integer) objArr2[2]).intValue());
                            break;
                        case 3:
                            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE_EX");
                            java.lang.Object[] objArr3 = (java.lang.Object[]) message.obj;
                            com.tencent.smtt.sdk.m.this.b((android.content.Context) objArr3[0], (android.os.Bundle) objArr3[1]);
                            break;
                        case 4:
                            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_UNZIP_TBS_CORE");
                            java.lang.Object[] objArr4 = (java.lang.Object[]) message.obj;
                            com.tencent.smtt.sdk.m.this.b((android.content.Context) objArr4[0], (java.io.File) objArr4[1], ((java.lang.Integer) objArr4[2]).intValue());
                            com.tencent.smtt.sdk.QbSdk.setTBSInstallingStatus(false);
                            super.handleMessage(message);
                            break;
                    }
                }
            };
        }
    }

    private void A(android.content.Context context) {
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller--deleteOldCore");
        com.tencent.smtt.utils.f.a(q(context), false);
    }

    private void B(android.content.Context context) {
        com.tencent.smtt.sdk.TbsLogReport tbsLogReport;
        int i2;
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller--renameShareDir");
        java.io.File fileF = f(context, 0);
        java.io.File fileQ = q(context);
        if (fileF == null || fileQ == null) {
            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "renameTbsCoreShareDir return,tmpTbsCoreUnzipDir=" + fileF + "tbsSharePath=" + fileQ);
            return;
        }
        boolean zRenameTo = fileF.renameTo(fileQ);
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "renameTbsCoreShareDir rename success=" + zRenameTo);
        if (context != null && "com.tencent.mm".equals(context.getApplicationContext().getApplicationInfo().packageName)) {
            if (zRenameTo) {
                tbsLogReport = com.tencent.smtt.sdk.TbsLogReport.getInstance(context);
                i2 = com.tencent.smtt.sdk.TbsListener.ErrorCode.RENAME_SUCCESS;
            } else {
                tbsLogReport = com.tencent.smtt.sdk.TbsLogReport.getInstance(context);
                i2 = com.tencent.smtt.sdk.TbsListener.ErrorCode.RENAME_FAIL;
            }
            tbsLogReport.setInstallErrorCode(i2, " ");
        }
        g(context, false);
    }

    private void C(android.content.Context context) {
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller--renameTbsCoreCopyDir");
        java.io.File fileF = f(context, 1);
        java.io.File fileQ = q(context);
        if (fileF == null || fileQ == null) {
            return;
        }
        fileF.renameTo(fileQ);
        g(context, false);
    }

    private void D(android.content.Context context) {
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller--renameTbsTpatchCoreDir");
        java.io.File fileF = f(context, 5);
        java.io.File fileQ = q(context);
        if (fileF == null || fileQ == null) {
            return;
        }
        fileF.renameTo(fileQ);
        g(context, false);
    }

    private void E(android.content.Context context) {
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller--clearNewTbsCore");
        java.io.File fileF = f(context, 0);
        if (fileF != null) {
            com.tencent.smtt.utils.f.a(fileF, false);
        }
        com.tencent.smtt.sdk.k.a(context).c(0, 5);
        com.tencent.smtt.sdk.k.a(context).c(-1);
        com.tencent.smtt.sdk.QbSdk.a(context, "TbsInstaller::clearNewTbsCore forceSysWebViewInner!");
    }

    static synchronized com.tencent.smtt.sdk.m a() {
        if (d == null) {
            synchronized (com.tencent.smtt.sdk.m.class) {
                if (d == null) {
                    d = new com.tencent.smtt.sdk.m();
                }
            }
        }
        return d;
    }

    private void a(int i2, java.lang.String str, android.content.Context context) {
        java.lang.Throwable th;
        java.io.BufferedInputStream bufferedInputStream;
        new java.io.File(str).delete();
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "Local tbs apk(" + str + ") is deleted!", true);
        java.io.File file = new java.io.File(com.tencent.smtt.sdk.QbSdk.getTbsFolderDir(context), "core_unzip_tmp");
        if (file.canRead()) {
            java.io.File file2 = new java.io.File(file, "tbs.conf");
            java.util.Properties properties = new java.util.Properties();
            java.io.BufferedOutputStream bufferedOutputStream = null;
            try {
                bufferedInputStream = new java.io.BufferedInputStream(new java.io.FileInputStream(file2));
                try {
                    properties.load(bufferedInputStream);
                    java.io.BufferedOutputStream bufferedOutputStream2 = new java.io.BufferedOutputStream(new java.io.FileOutputStream(file2));
                    try {
                        properties.setProperty("tbs_local_installation", com.tencent.ysdk.shell.framework.config.Config.VALUE_SWITCH_ON);
                        properties.store(bufferedOutputStream2, (java.lang.String) null);
                        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TBS_LOCAL_INSTALLATION is set!", true);
                        try {
                            bufferedOutputStream2.close();
                        } catch (java.io.IOException e) {
                            e.printStackTrace();
                        }
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        bufferedOutputStream = bufferedOutputStream2;
                        try {
                            th.printStackTrace();
                        } finally {
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (java.io.IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (java.io.IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                        }
                    }
                } catch (java.lang.Throwable th3) {
                    th = th3;
                }
            } catch (java.lang.Throwable th4) {
                th = th4;
                bufferedInputStream = null;
            }
        }
    }

    public static void a(android.content.Context context) {
        java.lang.String str;
        java.lang.String str2;
        if (v(context)) {
            return;
        }
        if (a(context, "core_unzip_tmp")) {
            com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, com.tencent.smtt.sdk.TbsListener.ErrorCode.INFO_TEMP_CORE_EXIST_CONF_ERROR, new java.lang.Throwable("TMP_TBS_UNZIP_FOLDER_NAME"));
            str = "TbsInstaller";
            str2 = "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_UNZIP_FOLDER_NAME";
        } else if (a(context, "core_share_backup_tmp")) {
            com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, com.tencent.smtt.sdk.TbsListener.ErrorCode.INFO_TEMP_CORE_EXIST_CONF_ERROR, new java.lang.Throwable("TMP_BACKUP_TBSCORE_FOLDER_NAME"));
            str = "TbsInstaller";
            str2 = "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_BACKUP_TBSCORE_FOLDER_NAME";
        } else {
            if (!a(context, "core_copy_tmp")) {
                return;
            }
            com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, com.tencent.smtt.sdk.TbsListener.ErrorCode.INFO_TEMP_CORE_EXIST_CONF_ERROR, new java.lang.Throwable("TMP_TBS_COPY_FOLDER_NAME"));
            str = "TbsInstaller";
            str2 = "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_COPY_FOLDER_NAME";
        }
        com.tencent.smtt.utils.TbsLog.e(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:124:0x0309 A[Catch: Exception -> 0x050f, all -> 0x0529, TryCatch #0 {Exception -> 0x050f, blocks: (B:81:0x022f, B:83:0x0257, B:85:0x025c, B:87:0x0278, B:89:0x0281, B:104:0x02dc, B:124:0x0309, B:125:0x0317, B:127:0x031a, B:129:0x031e, B:131:0x0328, B:134:0x0336, B:136:0x0340, B:138:0x0346, B:141:0x0353, B:143:0x0369, B:146:0x0371, B:149:0x0391, B:154:0x03c7, B:157:0x03df, B:160:0x0409, B:162:0x0419, B:164:0x041f, B:169:0x0430, B:168:0x042b, B:170:0x0436, B:172:0x0441, B:173:0x0447, B:175:0x0452, B:177:0x045d, B:179:0x0477, B:186:0x04ba, B:185:0x04a2, B:180:0x0480, B:174:0x044b, B:121:0x0300, B:192:0x04c7, B:197:0x04d0, B:196:0x04cd, B:117:0x02f8, B:198:0x04d1, B:200:0x04fc, B:204:0x0514), top: B:222:0x022b }] */
    /* JADX WARN: Code duplicated, block: B:127:0x031a A[Catch: Exception -> 0x050f, all -> 0x0529, TRY_LEAVE, TryCatch #0 {Exception -> 0x050f, blocks: (B:81:0x022f, B:83:0x0257, B:85:0x025c, B:87:0x0278, B:89:0x0281, B:104:0x02dc, B:124:0x0309, B:125:0x0317, B:127:0x031a, B:129:0x031e, B:131:0x0328, B:134:0x0336, B:136:0x0340, B:138:0x0346, B:141:0x0353, B:143:0x0369, B:146:0x0371, B:149:0x0391, B:154:0x03c7, B:157:0x03df, B:160:0x0409, B:162:0x0419, B:164:0x041f, B:169:0x0430, B:168:0x042b, B:170:0x0436, B:172:0x0441, B:173:0x0447, B:175:0x0452, B:177:0x045d, B:179:0x0477, B:186:0x04ba, B:185:0x04a2, B:180:0x0480, B:174:0x044b, B:121:0x0300, B:192:0x04c7, B:197:0x04d0, B:196:0x04cd, B:117:0x02f8, B:198:0x04d1, B:200:0x04fc, B:204:0x0514), top: B:222:0x022b }] */
    /* JADX WARN: Code duplicated, block: B:152:0x03c4  */
    /* JADX WARN: Code duplicated, block: B:166:0x0427  */
    /* JADX WARN: Code duplicated, block: B:167:0x042a  */
    /* JADX WARN: Code duplicated, block: B:172:0x0441 A[Catch: Exception -> 0x050f, all -> 0x0529, TryCatch #0 {Exception -> 0x050f, blocks: (B:81:0x022f, B:83:0x0257, B:85:0x025c, B:87:0x0278, B:89:0x0281, B:104:0x02dc, B:124:0x0309, B:125:0x0317, B:127:0x031a, B:129:0x031e, B:131:0x0328, B:134:0x0336, B:136:0x0340, B:138:0x0346, B:141:0x0353, B:143:0x0369, B:146:0x0371, B:149:0x0391, B:154:0x03c7, B:157:0x03df, B:160:0x0409, B:162:0x0419, B:164:0x041f, B:169:0x0430, B:168:0x042b, B:170:0x0436, B:172:0x0441, B:173:0x0447, B:175:0x0452, B:177:0x045d, B:179:0x0477, B:186:0x04ba, B:185:0x04a2, B:180:0x0480, B:174:0x044b, B:121:0x0300, B:192:0x04c7, B:197:0x04d0, B:196:0x04cd, B:117:0x02f8, B:198:0x04d1, B:200:0x04fc, B:204:0x0514), top: B:222:0x022b }] */
    /* JADX WARN: Code duplicated, block: B:174:0x044b A[Catch: Exception -> 0x050f, all -> 0x0529, TryCatch #0 {Exception -> 0x050f, blocks: (B:81:0x022f, B:83:0x0257, B:85:0x025c, B:87:0x0278, B:89:0x0281, B:104:0x02dc, B:124:0x0309, B:125:0x0317, B:127:0x031a, B:129:0x031e, B:131:0x0328, B:134:0x0336, B:136:0x0340, B:138:0x0346, B:141:0x0353, B:143:0x0369, B:146:0x0371, B:149:0x0391, B:154:0x03c7, B:157:0x03df, B:160:0x0409, B:162:0x0419, B:164:0x041f, B:169:0x0430, B:168:0x042b, B:170:0x0436, B:172:0x0441, B:173:0x0447, B:175:0x0452, B:177:0x045d, B:179:0x0477, B:186:0x04ba, B:185:0x04a2, B:180:0x0480, B:174:0x044b, B:121:0x0300, B:192:0x04c7, B:197:0x04d0, B:196:0x04cd, B:117:0x02f8, B:198:0x04d1, B:200:0x04fc, B:204:0x0514), top: B:222:0x022b }] */
    /* JADX WARN: Code duplicated, block: B:179:0x0477 A[Catch: Exception -> 0x050f, all -> 0x0529, TryCatch #0 {Exception -> 0x050f, blocks: (B:81:0x022f, B:83:0x0257, B:85:0x025c, B:87:0x0278, B:89:0x0281, B:104:0x02dc, B:124:0x0309, B:125:0x0317, B:127:0x031a, B:129:0x031e, B:131:0x0328, B:134:0x0336, B:136:0x0340, B:138:0x0346, B:141:0x0353, B:143:0x0369, B:146:0x0371, B:149:0x0391, B:154:0x03c7, B:157:0x03df, B:160:0x0409, B:162:0x0419, B:164:0x041f, B:169:0x0430, B:168:0x042b, B:170:0x0436, B:172:0x0441, B:173:0x0447, B:175:0x0452, B:177:0x045d, B:179:0x0477, B:186:0x04ba, B:185:0x04a2, B:180:0x0480, B:174:0x044b, B:121:0x0300, B:192:0x04c7, B:197:0x04d0, B:196:0x04cd, B:117:0x02f8, B:198:0x04d1, B:200:0x04fc, B:204:0x0514), top: B:222:0x022b }] */
    /* JADX WARN: Code duplicated, block: B:180:0x0480 A[Catch: Exception -> 0x050f, all -> 0x0529, TRY_LEAVE, TryCatch #0 {Exception -> 0x050f, blocks: (B:81:0x022f, B:83:0x0257, B:85:0x025c, B:87:0x0278, B:89:0x0281, B:104:0x02dc, B:124:0x0309, B:125:0x0317, B:127:0x031a, B:129:0x031e, B:131:0x0328, B:134:0x0336, B:136:0x0340, B:138:0x0346, B:141:0x0353, B:143:0x0369, B:146:0x0371, B:149:0x0391, B:154:0x03c7, B:157:0x03df, B:160:0x0409, B:162:0x0419, B:164:0x041f, B:169:0x0430, B:168:0x042b, B:170:0x0436, B:172:0x0441, B:173:0x0447, B:175:0x0452, B:177:0x045d, B:179:0x0477, B:186:0x04ba, B:185:0x04a2, B:180:0x0480, B:174:0x044b, B:121:0x0300, B:192:0x04c7, B:197:0x04d0, B:196:0x04cd, B:117:0x02f8, B:198:0x04d1, B:200:0x04fc, B:204:0x0514), top: B:222:0x022b }] */
    /* JADX WARN: Code duplicated, block: B:229:0x04c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:236:0x02f8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:244:0x03c4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:251:? A[Catch: Exception -> 0x050f, all -> 0x0529, SYNTHETIC, TryCatch #0 {Exception -> 0x050f, blocks: (B:81:0x022f, B:83:0x0257, B:85:0x025c, B:87:0x0278, B:89:0x0281, B:104:0x02dc, B:124:0x0309, B:125:0x0317, B:127:0x031a, B:129:0x031e, B:131:0x0328, B:134:0x0336, B:136:0x0340, B:138:0x0346, B:141:0x0353, B:143:0x0369, B:146:0x0371, B:149:0x0391, B:154:0x03c7, B:157:0x03df, B:160:0x0409, B:162:0x0419, B:164:0x041f, B:169:0x0430, B:168:0x042b, B:170:0x0436, B:172:0x0441, B:173:0x0447, B:175:0x0452, B:177:0x045d, B:179:0x0477, B:186:0x04ba, B:185:0x04a2, B:180:0x0480, B:174:0x044b, B:121:0x0300, B:192:0x04c7, B:197:0x04d0, B:196:0x04cd, B:117:0x02f8, B:198:0x04d1, B:200:0x04fc, B:204:0x0514), top: B:222:0x022b }] */
    @android.annotation.TargetApi(11)
    public void a(android.content.Context context, android.content.Context context2, int i2) {
        java.lang.Exception exc;
        java.io.File fileF;
        java.lang.Throwable th;
        java.io.BufferedInputStream bufferedInputStream;
        java.lang.Exception exc2;
        java.util.Properties properties;
        java.io.BufferedInputStream bufferedInputStream2;
        java.io.IOException iOException;
        java.util.Properties properties2;
        boolean z;
        boolean z2;
        boolean z3;
        java.io.File fileB;
        com.tencent.smtt.sdk.TbsLogReport tbsLogReport;
        java.lang.String str;
        int i3;
        android.content.SharedPreferences sharedPreferences;
        java.lang.String backupFileName;
        java.io.File[] fileArrListFiles;
        int i4;
        java.io.File file;
        java.lang.String strA;
        java.lang.String property;
        java.io.BufferedInputStream bufferedInputStream3;
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-524);
        if (c(context2)) {
            return;
        }
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread start!  tbsCoreTargetVer is " + i2);
        if ((android.os.Build.VERSION.SDK_INT >= 11 ? context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).getInt("tbs_precheck_disable_version", -1) == i2) {
            com.tencent.smtt.utils.TbsLog.e("TbsInstaller", "TbsInstaller-copyTbsCoreInThread -- version:" + i2 + " is disabled by preload_x5_check!");
            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-525);
            return;
        }
        if (!t(context2)) {
            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-526);
            return;
        }
        boolean zTryLock = j.tryLock();
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread #1 locked is " + zTryLock);
        if (!zTryLock) {
            b();
            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-538);
            return;
        }
        i.lock();
        try {
            try {
                int iC = com.tencent.smtt.sdk.k.a(context2).c("copy_core_ver");
                int iB = com.tencent.smtt.sdk.k.a(context2).b("copy_status");
                if (iC == i2) {
                    com.tencent.smtt.sdk.QbSdk.m.onInstallFinish(com.tencent.smtt.sdk.TbsListener.ErrorCode.COPY_INSTALL_SUCCESS);
                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-528);
                    i.unlock();
                    j.unlock();
                    b();
                    return;
                }
                int i5 = i(context2);
                com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread tbsCoreInstalledVer=" + i5);
                if (i5 == i2) {
                    com.tencent.smtt.sdk.QbSdk.m.onInstallFinish(com.tencent.smtt.sdk.TbsListener.ErrorCode.COPY_INSTALL_SUCCESS);
                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-528);
                    com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread return have same version is " + i5);
                    i.unlock();
                    j.unlock();
                    b();
                    return;
                }
                int iB2 = com.tencent.smtt.sdk.k.a(context2).b();
                if ((iB2 > 0 && i2 > iB2) || (iC > 0 && i2 > iC)) {
                    o(context2);
                }
                if (iB == 3 && i5 > 0 && (i2 > i5 || i2 == 88888888)) {
                    o(context2);
                    com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread -- update TBS.....", true);
                    iB = -1;
                }
                if (!com.tencent.smtt.utils.f.b(context2)) {
                    long jA = com.tencent.smtt.utils.q.a();
                    long downloadMinFreeSpace = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context2).getDownloadMinFreeSpace();
                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-529);
                    com.tencent.smtt.sdk.TbsLogReport.getInstance(context2).setInstallErrorCode(210, "rom is not enough when copying tbs core! curAvailROM=" + jA + ",minReqRom=" + downloadMinFreeSpace);
                    i.unlock();
                    j.unlock();
                    b();
                    return;
                }
                if (iB > 0 && (com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(context2) || !com.tencent.smtt.sdk.TbsDownloader.a(context2) || i2 == h(context2))) {
                    com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread return have copied is " + h(context2));
                    i.unlock();
                    j.unlock();
                    b();
                    return;
                }
                if (iB == 0) {
                    int iC2 = com.tencent.smtt.sdk.k.a(context2).c("copy_retry_num");
                    if (iC2 > 2) {
                        com.tencent.smtt.sdk.TbsLogReport.getInstance(context2).setInstallErrorCode(211, "exceed copy retry num!");
                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-530);
                        i.unlock();
                        j.unlock();
                        b();
                        return;
                    }
                    com.tencent.smtt.sdk.k.a(context2).a("copy_retry_num", iC2 + 1);
                }
                java.io.File fileQ = q(context);
                fileF = (com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(context2) || !com.tencent.smtt.sdk.TbsDownloader.a(context2)) ? f(context2, 1) : p(context2);
                try {
                    if (fileQ == null || fileF == null) {
                        if (fileQ == null) {
                            com.tencent.smtt.sdk.TbsLogReport.getInstance(context2).setInstallErrorCode(com.tencent.smtt.sdk.TbsListener.ErrorCode.COPY_SRCDIR_ERROR, "src-dir is null when copying tbs core!");
                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-535);
                        }
                        if (fileF == null) {
                            com.tencent.smtt.sdk.TbsLogReport.getInstance(context2).setInstallErrorCode(com.tencent.smtt.sdk.TbsListener.ErrorCode.COPY_TMPDIR_ERROR, "dst-dir is null when copying tbs core!");
                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-536);
                        }
                    } else {
                        com.tencent.smtt.sdk.k.a(context2).a(i2, 0);
                        com.tencent.smtt.utils.p pVar = new com.tencent.smtt.utils.p();
                        pVar.a(fileQ);
                        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-551);
                        boolean zA = com.tencent.smtt.utils.f.a(fileQ, fileF, c);
                        if (com.tencent.smtt.sdk.TbsDownloader.a(context2)) {
                            com.tencent.smtt.sdk.TbsShareManager.b(context2);
                        }
                        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread time=" + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
                        if (zA) {
                            pVar.b(fileQ);
                            if (!pVar.a()) {
                                com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread copy-verify fail!");
                                com.tencent.smtt.utils.f.a(fileF, true);
                                com.tencent.smtt.sdk.TbsLogReport.getInstance(context2).setInstallErrorCode(com.tencent.smtt.sdk.TbsListener.ErrorCode.COPY_SRCDIR_ERROR, "TbsCopy-Verify fail after copying tbs core!");
                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-531);
                                i.unlock();
                                j.unlock();
                                b();
                                return;
                            }
                            try {
                                try {
                                    java.io.File file2 = new java.io.File(fileF, "1");
                                    properties = new java.util.Properties();
                                    try {
                                        if (file2.exists()) {
                                            java.io.BufferedInputStream bufferedInputStream4 = new java.io.BufferedInputStream(new java.io.FileInputStream(file2));
                                            try {
                                                properties.load(bufferedInputStream4);
                                                bufferedInputStream3 = bufferedInputStream4;
                                                z2 = true;
                                            } catch (java.lang.Exception e) {
                                                bufferedInputStream2 = bufferedInputStream4;
                                                exc2 = e;
                                                try {
                                                    exc2.printStackTrace();
                                                    if (bufferedInputStream2 != null) {
                                                        try {
                                                            bufferedInputStream2.close();
                                                        } catch (java.io.IOException e2) {
                                                            iOException = e2;
                                                            properties2 = properties;
                                                            z = true;
                                                            iOException.printStackTrace();
                                                            z2 = z;
                                                            properties = properties2;
                                                        }
                                                    }
                                                    z2 = true;
                                                } catch (java.lang.Throwable th2) {
                                                    th = th2;
                                                    bufferedInputStream4 = bufferedInputStream2;
                                                    bufferedInputStream = bufferedInputStream4;
                                                    if (bufferedInputStream == null) {
                                                        throw th;
                                                    }
                                                    try {
                                                        bufferedInputStream.close();
                                                        throw th;
                                                    } catch (java.io.IOException e3) {
                                                        e3.printStackTrace();
                                                        throw th;
                                                    }
                                                }
                                            } catch (java.lang.Throwable th3) {
                                                th = th3;
                                                bufferedInputStream = bufferedInputStream4;
                                                if (bufferedInputStream == null) {
                                                    throw th;
                                                }
                                                bufferedInputStream.close();
                                                throw th;
                                            }
                                        } else {
                                            z2 = false;
                                            bufferedInputStream3 = null;
                                        }
                                        if (bufferedInputStream3 != null) {
                                            try {
                                                bufferedInputStream3.close();
                                            } catch (java.io.IOException e4) {
                                                properties2 = properties;
                                                z = z2;
                                                iOException = e4;
                                                iOException.printStackTrace();
                                                z2 = z;
                                                properties = properties2;
                                            }
                                        }
                                    } catch (java.lang.Exception e5) {
                                        exc2 = e5;
                                        bufferedInputStream2 = null;
                                        exc2.printStackTrace();
                                        if (bufferedInputStream2 != null) {
                                            bufferedInputStream2.close();
                                        }
                                        z2 = true;
                                        if (z2) {
                                            fileArrListFiles = fileF.listFiles();
                                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-552);
                                            i4 = 0;
                                            while (true) {
                                                if (i4 < fileArrListFiles.length) {
                                                    file = fileArrListFiles[i4];
                                                    if (!"1".equals(file.getName())) {
                                                        strA = com.tencent.smtt.utils.a.a(file);
                                                        property = properties.getProperty(file.getName(), "");
                                                        if (property.equals("")) {
                                                        }
                                                        com.tencent.smtt.utils.TbsLog.e("TbsInstaller", "md5_check_failure for (" + file.getName() + ") targetMd5:" + property + ", realMd5:" + strA);
                                                        z3 = false;
                                                    }
                                                    i4++;
                                                } else {
                                                    z3 = true;
                                                }
                                            }
                                        } else {
                                            z3 = true;
                                        }
                                        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "copyTbsCoreInThread - md5_check_success:" + z3);
                                        if (!z2) {
                                        }
                                        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread success!");
                                        g(context2, true);
                                        fileB = com.tencent.smtt.sdk.j.b(context);
                                        if (fileB != null) {
                                            if (com.tencent.smtt.sdk.TbsDownloader.getOverSea(context2)) {
                                                backupFileName = "x5.oversea.tbs.org";
                                            } else {
                                                backupFileName = com.tencent.smtt.sdk.TbsDownloader.getBackupFileName(false);
                                            }
                                            com.tencent.smtt.sdk.j.a(new java.io.File(fileB, backupFileName), context2);
                                        }
                                        com.tencent.smtt.sdk.k.a(context2).a(i2, 1);
                                        if (this.k) {
                                            tbsLogReport = com.tencent.smtt.sdk.TbsLogReport.getInstance(context2);
                                            str = "continueInstallWithout core success";
                                        } else {
                                            tbsLogReport = com.tencent.smtt.sdk.TbsLogReport.getInstance(context2);
                                            str = com.unisound.common.y.J;
                                        }
                                        tbsLogReport.setInstallErrorCode(com.tencent.smtt.sdk.TbsListener.ErrorCode.COPY_INSTALL_SUCCESS, str);
                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-533);
                                        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread success -- version:" + i2);
                                        if (android.os.Build.VERSION.SDK_INT >= 11) {
                                            sharedPreferences = context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4);
                                            i3 = 0;
                                        } else {
                                            i3 = 0;
                                            sharedPreferences = context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0);
                                        }
                                        try {
                                            android.content.SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                                            editorEdit.putInt("tbs_preload_x5_counter", i3);
                                            editorEdit.putInt("tbs_preload_x5_recorder", i3);
                                            editorEdit.putInt("tbs_preload_x5_version", i2);
                                            editorEdit.commit();
                                        } catch (java.lang.Throwable th4) {
                                            com.tencent.smtt.utils.TbsLog.e("TbsInstaller", "Init tbs_preload_x5_counter#2 exception:" + android.util.Log.getStackTraceString(th4));
                                        }
                                        com.tencent.smtt.utils.q.a(context2);
                                        i.unlock();
                                        j.unlock();
                                        b();
                                    }
                                } catch (java.lang.Exception e6) {
                                    exc2 = e6;
                                    properties = null;
                                }
                                if (z2) {
                                    fileArrListFiles = fileF.listFiles();
                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-552);
                                    i4 = 0;
                                    while (true) {
                                        if (i4 < fileArrListFiles.length) {
                                            file = fileArrListFiles[i4];
                                            if (!"1".equals(file.getName()) && !file.getName().endsWith(".dex") && !"tbs.conf".equals(file.getName()) && !file.isDirectory() && !file.getName().endsWith(".prof")) {
                                                strA = com.tencent.smtt.utils.a.a(file);
                                                property = properties.getProperty(file.getName(), "");
                                                if (property.equals("") && strA.equals(property)) {
                                                    com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "md5_check_success for (" + file.getName() + ")");
                                                } else {
                                                    com.tencent.smtt.utils.TbsLog.e("TbsInstaller", "md5_check_failure for (" + file.getName() + ") targetMd5:" + property + ", realMd5:" + strA);
                                                    z3 = false;
                                                }
                                            }
                                            i4++;
                                        } else {
                                            z3 = true;
                                        }
                                    }
                                } else {
                                    z3 = true;
                                }
                                com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "copyTbsCoreInThread - md5_check_success:" + z3);
                                if (!z2 && !z3) {
                                    com.tencent.smtt.utils.TbsLog.e("TbsInstaller", "copyTbsCoreInThread - md5 incorrect -> delete destTmpDir!");
                                    com.tencent.smtt.utils.f.a(fileF, true);
                                    com.tencent.smtt.sdk.TbsLogReport.getInstance(context2).setInstallErrorCode(com.tencent.smtt.sdk.TbsListener.ErrorCode.COPY_SRCDIR_ERROR, "TbsCopy-Verify md5 fail after copying tbs core!");
                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-532);
                                    i.unlock();
                                    j.unlock();
                                    b();
                                    return;
                                }
                                com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread success!");
                                g(context2, true);
                                fileB = com.tencent.smtt.sdk.j.b(context);
                                if (fileB != null && fileB.exists()) {
                                    if (com.tencent.smtt.sdk.TbsDownloader.getOverSea(context2)) {
                                        backupFileName = "x5.oversea.tbs.org";
                                    } else {
                                        backupFileName = com.tencent.smtt.sdk.TbsDownloader.getBackupFileName(false);
                                    }
                                    com.tencent.smtt.sdk.j.a(new java.io.File(fileB, backupFileName), context2);
                                }
                                com.tencent.smtt.sdk.k.a(context2).a(i2, 1);
                                if (this.k) {
                                    tbsLogReport = com.tencent.smtt.sdk.TbsLogReport.getInstance(context2);
                                    str = "continueInstallWithout core success";
                                } else {
                                    tbsLogReport = com.tencent.smtt.sdk.TbsLogReport.getInstance(context2);
                                    str = com.unisound.common.y.J;
                                }
                                tbsLogReport.setInstallErrorCode(com.tencent.smtt.sdk.TbsListener.ErrorCode.COPY_INSTALL_SUCCESS, str);
                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-533);
                                com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread success -- version:" + i2);
                                if (android.os.Build.VERSION.SDK_INT >= 11) {
                                    sharedPreferences = context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4);
                                    i3 = 0;
                                } else {
                                    i3 = 0;
                                    sharedPreferences = context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0);
                                }
                                android.content.SharedPreferences.Editor editorEdit2 = sharedPreferences.edit();
                                editorEdit2.putInt("tbs_preload_x5_counter", i3);
                                editorEdit2.putInt("tbs_preload_x5_recorder", i3);
                                editorEdit2.putInt("tbs_preload_x5_version", i2);
                                editorEdit2.commit();
                                com.tencent.smtt.utils.q.a(context2);
                            } catch (java.lang.Throwable th5) {
                                th = th5;
                                bufferedInputStream = null;
                                if (bufferedInputStream == null) {
                                    throw th;
                                }
                                bufferedInputStream.close();
                                throw th;
                            }
                        } else {
                            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread fail!");
                            com.tencent.smtt.sdk.k.a(context2).a(i2, 2);
                            com.tencent.smtt.utils.f.a(fileF, false);
                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-534);
                            com.tencent.smtt.sdk.TbsLogReport.getInstance(context2).setInstallErrorCode(212, "copy fail!");
                        }
                    }
                } catch (java.lang.Exception e7) {
                    exc = e7;
                    com.tencent.smtt.sdk.TbsLogReport.getInstance(context2).setInstallErrorCode(com.tencent.smtt.sdk.TbsListener.ErrorCode.COPY_EXCEPTION, exc.toString());
                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-537);
                    try {
                        com.tencent.smtt.utils.f.a(fileF, false);
                        com.tencent.smtt.sdk.k.a(context2).a(0, -1);
                    } catch (java.lang.Exception e8) {
                        com.tencent.smtt.utils.TbsLog.e("TbsInstaller", "[TbsInstaller-copyTbsCoreInThread] delete dstTmpDir throws exception:" + e8.getMessage() + "," + e8.getCause());
                    }
                }
                i.unlock();
                j.unlock();
                b();
            } catch (java.lang.Exception e9) {
                exc = e9;
                fileF = null;
            }
        } catch (java.lang.Throwable th6) {
            i.unlock();
            j.unlock();
            b();
            throw th6;
        }
    }

    private boolean a(android.content.Context context, java.io.File file) {
        return a(context, file, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean a(android.content.Context context, java.io.File file, boolean z) {
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-unzipTbs start");
        if (!com.tencent.smtt.utils.f.c(file)) {
            com.tencent.smtt.sdk.TbsLogReport.getInstance(context).setInstallErrorCode(204, "apk is invalid!");
            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-520);
            return false;
        }
        try {
            java.io.File tbsFolderDir = com.tencent.smtt.sdk.QbSdk.getTbsFolderDir(context);
            java.io.File file2 = z ? new java.io.File(tbsFolderDir, "core_share_decouple") : new java.io.File(tbsFolderDir, "core_unzip_tmp");
            if (file2.exists() && !com.tencent.smtt.sdk.TbsDownloader.a(context)) {
                com.tencent.smtt.utils.f.b(file2);
            }
        } catch (java.lang.Throwable th) {
            com.tencent.smtt.utils.TbsLog.e("TbsInstaller", "TbsInstaller-unzipTbs -- delete unzip folder if exists exception" + android.util.Log.getStackTraceString(th));
        }
        java.io.File fileF = z ? f(context, 2) : f(context, 0);
        if (fileF == null) {
            com.tencent.smtt.sdk.TbsLogReport.getInstance(context).setInstallErrorCode(com.tencent.smtt.sdk.TbsListener.ErrorCode.UNZIP_DIR_ERROR, "tmp unzip dir is null!");
            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-521);
            return false;
        }
        try {
            try {
                try {
                    com.tencent.smtt.utils.f.a(fileF);
                    if (z) {
                        com.tencent.smtt.utils.f.a(fileF, true);
                    }
                    boolean zA = com.tencent.smtt.utils.f.a(file, fileF);
                    if (zA) {
                        zA = a(fileF, context);
                    }
                    if (z) {
                        for (java.lang.String str : fileF.list()) {
                            java.io.File file3 = new java.io.File(fileF, str);
                            if (file3.getName().endsWith(".dex")) {
                                file3.delete();
                            }
                        }
                        try {
                            new java.io.File(s(context), "x5.tbs").delete();
                        } catch (java.lang.Exception unused) {
                        }
                    }
                    if (zA) {
                        g(context, true);
                        if (z) {
                            java.io.File fileP = p(context);
                            com.tencent.smtt.utils.f.a(fileP, true);
                            fileF.renameTo(fileP);
                            com.tencent.smtt.sdk.TbsShareManager.b(context);
                        }
                    } else {
                        com.tencent.smtt.utils.f.b(fileF);
                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-522);
                        com.tencent.smtt.utils.TbsLog.e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#1! exist:" + fileF.exists());
                    }
                    com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-unzipTbs done");
                    return zA;
                } catch (java.lang.Throwable th2) {
                    com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-unzipTbs done");
                    throw th2;
                }
            } catch (java.io.IOException e) {
                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-523);
                com.tencent.smtt.sdk.TbsLogReport.getInstance(context).setInstallErrorCode(206, e);
                if ((fileF != null && fileF.exists()) && fileF != null) {
                    try {
                        com.tencent.smtt.utils.f.b(fileF);
                        com.tencent.smtt.utils.TbsLog.e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exist:" + fileF.exists());
                    } catch (java.lang.Throwable th3) {
                        com.tencent.smtt.utils.TbsLog.e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exception:" + android.util.Log.getStackTraceString(th3));
                    }
                }
                com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-unzipTbs done");
                return false;
            }
        } catch (java.lang.Exception e2) {
            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-523);
            com.tencent.smtt.sdk.TbsLogReport.getInstance(context).setInstallErrorCode(207, e2);
            if ((fileF != null && fileF.exists()) && fileF != null) {
                try {
                    com.tencent.smtt.utils.f.b(fileF);
                    com.tencent.smtt.utils.TbsLog.e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exist:" + fileF.exists());
                } catch (java.lang.Throwable th4) {
                    com.tencent.smtt.utils.TbsLog.e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exception:" + android.util.Log.getStackTraceString(th4));
                }
            }
            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-unzipTbs done");
            return false;
        }
    }

    static boolean a(android.content.Context context, java.lang.String str) {
        java.lang.String str2;
        java.lang.String str3;
        java.io.File file = new java.io.File(com.tencent.smtt.sdk.QbSdk.getTbsFolderDir(context), str);
        if (!file.exists()) {
            str2 = "TbsInstaller";
            str3 = "TbsInstaller-isPrepareTbsCore, #1";
        } else {
            if (new java.io.File(file, "tbs.conf").exists()) {
                com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-isPrepareTbsCore, #3");
                return true;
            }
            str2 = "TbsInstaller";
            str3 = "TbsInstaller-isPrepareTbsCore, #2";
        }
        com.tencent.smtt.utils.TbsLog.i(str2, str3);
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean a(java.io.File file, android.content.Context context) throws java.lang.Throwable {
        java.util.Properties properties;
        boolean z;
        boolean z2;
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "finalCheckForTbsCoreValidity - " + file + ", " + context);
        java.io.BufferedInputStream bufferedInputStream = null;
        try {
            try {
                java.io.File file2 = new java.io.File(file, "1");
                properties = new java.util.Properties();
                try {
                    if (file2.exists()) {
                        java.io.BufferedInputStream bufferedInputStream2 = new java.io.BufferedInputStream(new java.io.FileInputStream(file2));
                        try {
                            properties.load(bufferedInputStream2);
                            bufferedInputStream = bufferedInputStream2;
                            z = true;
                        } catch (java.lang.Exception e) {
                            e = e;
                            bufferedInputStream = bufferedInputStream2;
                            e.printStackTrace();
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (java.io.IOException e2) {
                                    e = e2;
                                    z = true;
                                    e.printStackTrace();
                                }
                            }
                            z = true;
                        } catch (java.lang.Throwable th) {
                            th = th;
                            bufferedInputStream = bufferedInputStream2;
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (java.io.IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } else {
                        z = false;
                    }
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (java.io.IOException e4) {
                            e = e4;
                            e.printStackTrace();
                        }
                    }
                } catch (java.lang.Exception e5) {
                    e = e5;
                }
            } catch (java.lang.Exception e6) {
                e = e6;
                properties = null;
            }
            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "finalCheckForTbsCoreValidity - need_check:" + z);
            if (z) {
                java.io.File[] fileArrListFiles = file.listFiles();
                int i2 = 0;
                while (true) {
                    if (i2 < fileArrListFiles.length) {
                        java.io.File file3 = fileArrListFiles[i2];
                        if (!"1".equals(file3.getName()) && !file3.getName().endsWith(".dex") && !"tbs.conf".equals(file3.getName()) && !file3.isDirectory() && !file3.getName().endsWith(".prof")) {
                            java.lang.String strA = com.tencent.smtt.utils.a.a(file3);
                            java.lang.String property = properties.getProperty(file3.getName(), "");
                            if (property.equals("") || !property.equals(strA)) {
                                com.tencent.smtt.utils.TbsLog.e("TbsInstaller", "md5_check_failure for (" + file3.getName() + ") targetMd5:" + property + ", realMd5:" + strA);
                                z2 = false;
                            } else {
                                com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "md5_check_success for (" + file3.getName() + ")");
                            }
                        }
                        i2++;
                    } else {
                        z2 = true;
                    }
                }
            } else {
                z2 = true;
            }
            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "finalCheckForTbsCoreValidity - md5_check_success:" + z2);
            if (!z || z2) {
                com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "finalCheckForTbsCoreValidity success!");
                return true;
            }
            com.tencent.smtt.utils.TbsLog.e("TbsInstaller", "finalCheckForTbsCoreValidity - Verify failed after unzipping!");
            return false;
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:304:0x04ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @android.annotation.TargetApi(11)
    public void b(android.content.Context context, java.lang.String str, int i2) throws java.lang.Throwable {
        java.lang.Throwable th;
        boolean z;
        int iC;
        java.lang.String strD;
        com.tencent.smtt.sdk.TbsLogReport tbsLogReport;
        int iU;
        java.lang.String str2;
        java.lang.String strD2;
        java.lang.String str3;
        java.io.File fileF;
        boolean z2;
        com.tencent.smtt.sdk.TbsLogReport tbsLogReport2;
        java.lang.String str4;
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-501);
        boolean z3 = true;
        if (c(context)) {
            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "isTbsLocalInstalled --> no installation!", true);
            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-502);
            return;
        }
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsApkPath=" + str);
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreTargetVer=" + i2);
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread currentProcessId=" + android.os.Process.myPid());
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread currentThreadName=" + java.lang.Thread.currentThread().getName());
        boolean z4 = false;
        if ((android.os.Build.VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).getInt("tbs_precheck_disable_version", -1) == i2) {
            com.tencent.smtt.utils.TbsLog.e("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- version:" + i2 + " is disabled by preload_x5_check!");
            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-503);
            return;
        }
        if (!com.tencent.smtt.utils.f.b(context)) {
            long jA = com.tencent.smtt.utils.q.a();
            long downloadMinFreeSpace = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).getDownloadMinFreeSpace();
            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-504);
            com.tencent.smtt.sdk.TbsLogReport.getInstance(context).setInstallErrorCode(210, "rom is not enough when installing tbs core! curAvailROM=" + jA + ",minReqRom=" + downloadMinFreeSpace);
            return;
        }
        if (!t(context)) {
            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-505);
            return;
        }
        boolean zTryLock = j.tryLock();
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread locked =" + zTryLock);
        if (!zTryLock) {
            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-519);
            b();
            return;
        }
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-507);
        i.lock();
        try {
            int iC2 = com.tencent.smtt.sdk.k.a(context).c("copy_core_ver");
            int iB = com.tencent.smtt.sdk.k.a(context).b();
            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreCopyVer =" + iC2);
            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreInstallVer =" + iB);
            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreTargetVer =" + i2);
            if ((iB > 0 && i2 > iB) || (iC2 > 0 && i2 > iC2)) {
                o(context);
            }
            int iC3 = com.tencent.smtt.sdk.k.a(context).c();
            int i3 = i(context);
            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread installStatus1=" + iC3);
            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreInstalledVer=" + i3);
            if (iC3 < 0 || iC3 >= 2) {
                if (iC3 == 3 && i3 >= 0 && (i2 > i3 || i2 == 88888888)) {
                    o(context);
                    com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- update TBS.....", true);
                    iC3 = -1;
                }
                z = false;
            } else {
                com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- retry.....", true);
                z = true;
            }
            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-508);
            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread installStatus2=" + iC3);
            if (iC3 < 1) {
                com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "STEP 2/2 begin installation.....", true);
                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-509);
                if (z) {
                    int iC4 = com.tencent.smtt.sdk.k.a(context).c("unzip_retry_num");
                    if (iC4 > 10) {
                        com.tencent.smtt.sdk.TbsLogReport.getInstance(context).setInstallErrorCode(201, "exceed unzip retry num!");
                        E(context);
                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-510);
                        try {
                            i.unlock();
                            j.unlock();
                        } catch (java.lang.Exception e) {
                            e.printStackTrace();
                        }
                        try {
                            b();
                            return;
                        } catch (java.lang.Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    com.tencent.smtt.sdk.k.a(context).b(iC4 + 1);
                }
                if (str == null) {
                    strD2 = com.tencent.smtt.sdk.k.a(context).d("install_apk_path");
                    if (strD2 == null) {
                        com.tencent.smtt.sdk.TbsLogReport.getInstance(context).setInstallErrorCode(202, "apk path is null!");
                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-511);
                        try {
                            i.unlock();
                            j.unlock();
                        } catch (java.lang.Exception e3) {
                            e3.printStackTrace();
                        }
                        try {
                            b();
                            return;
                        } catch (java.lang.Exception e4) {
                            e4.printStackTrace();
                            return;
                        }
                    }
                } else {
                    strD2 = str;
                }
                com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread apkPath =" + strD2);
                iC = c(context, strD2);
                if (iC == 0) {
                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-512);
                    com.tencent.smtt.sdk.TbsLogReport.getInstance(context).setInstallErrorCode(203, "apk version is 0!");
                    try {
                        i.unlock();
                        j.unlock();
                    } catch (java.lang.Exception e5) {
                        e5.printStackTrace();
                    }
                    try {
                        b();
                        return;
                    } catch (java.lang.Exception e6) {
                        e6.printStackTrace();
                        return;
                    }
                }
                com.tencent.smtt.sdk.k.a(context).a("install_apk_path", strD2);
                com.tencent.smtt.sdk.k.a(context).c(iC, 0);
                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-548);
                if (com.tencent.smtt.sdk.TbsDownloader.a(context)) {
                    if (!a(context, new java.io.File(strD2), true)) {
                        com.tencent.smtt.sdk.TbsLogReport.getInstance(context).setInstallErrorCode(207, "unzipTbsApk failed", com.tencent.smtt.sdk.TbsLogReport.EventType.TYPE_INSTALL_DECOUPLE);
                        try {
                            i.unlock();
                            j.unlock();
                        } catch (java.lang.Exception e7) {
                            e7.printStackTrace();
                        }
                        try {
                            b();
                            return;
                        } catch (java.lang.Exception e8) {
                            e8.printStackTrace();
                            return;
                        }
                    }
                } else if (!a(context, new java.io.File(strD2))) {
                    com.tencent.smtt.sdk.TbsLogReport.getInstance(context).setInstallErrorCode(207, "unzipTbsApk failed");
                    try {
                        i.unlock();
                        j.unlock();
                    } catch (java.lang.Exception e9) {
                        e9.printStackTrace();
                    }
                    try {
                        b();
                        return;
                    } catch (java.lang.Exception e10) {
                        e10.printStackTrace();
                        return;
                    }
                }
                if (z) {
                    int iB2 = com.tencent.smtt.sdk.k.a(context).b("unlzma_status");
                    if (iB2 > 5) {
                        com.tencent.smtt.sdk.TbsLogReport.getInstance(context).setInstallErrorCode(com.tencent.smtt.sdk.TbsListener.ErrorCode.EXCEED_LZMA_RETRY_NUM, "exceed unlzma retry num!");
                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-553);
                        E(context);
                        com.tencent.smtt.sdk.j.c(context);
                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_FULL_PACKAGE, java.lang.Boolean.TRUE);
                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).commit();
                        try {
                            i.unlock();
                            j.unlock();
                        } catch (java.lang.Exception e11) {
                            e11.printStackTrace();
                        }
                        try {
                            b();
                            return;
                        } catch (java.lang.Exception e12) {
                            e12.printStackTrace();
                            return;
                        }
                    }
                    com.tencent.smtt.sdk.k.a(context).d(iB2 + 1);
                }
                com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "unlzma begin");
                int i4 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance().mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, 0);
                if (i(context) != 0) {
                    java.lang.Object objA = com.tencent.smtt.sdk.QbSdk.a(context, "can_unlzma", (android.os.Bundle) null);
                    if ((objA == null || !(objA instanceof java.lang.Boolean)) ? false : ((java.lang.Boolean) objA).booleanValue()) {
                        android.os.Bundle bundle = new android.os.Bundle();
                        bundle.putInt("responseCode", i4);
                        if (com.tencent.smtt.sdk.TbsDownloader.a(context)) {
                            str3 = "unzip_temp_path";
                            fileF = p(context);
                        } else {
                            str3 = "unzip_temp_path";
                            fileF = f(context, 0);
                        }
                        bundle.putString(str3, fileF.getAbsolutePath());
                        java.lang.Object objA2 = com.tencent.smtt.sdk.QbSdk.a(context, "unlzma", bundle);
                        if (objA2 == null) {
                            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "unlzma return null");
                            tbsLogReport2 = com.tencent.smtt.sdk.TbsLogReport.getInstance(context);
                            str4 = "unlzma is null";
                        } else {
                            if (!(objA2 instanceof java.lang.Boolean)) {
                                if (!(objA2 instanceof android.os.Bundle)) {
                                    if (objA2 instanceof java.lang.Throwable) {
                                        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "unlzma failure because Throwable" + android.util.Log.getStackTraceString((java.lang.Throwable) objA2));
                                        com.tencent.smtt.sdk.TbsLogReport.getInstance(context).setInstallErrorCode(com.tencent.smtt.sdk.TbsListener.ErrorCode.UNLZMA_FAIURE, (java.lang.Throwable) objA2);
                                    }
                                    z2 = false;
                                }
                                if (!z2) {
                                    try {
                                        i.unlock();
                                        j.unlock();
                                    } catch (java.lang.Exception e13) {
                                        e13.printStackTrace();
                                    }
                                    try {
                                        b();
                                        return;
                                    } catch (java.lang.Exception e14) {
                                        e14.printStackTrace();
                                        return;
                                    }
                                }
                            } else if (((java.lang.Boolean) objA2).booleanValue()) {
                                com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "unlzma success");
                            } else {
                                com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "unlzma return false");
                                tbsLogReport2 = com.tencent.smtt.sdk.TbsLogReport.getInstance(context);
                                str4 = "unlzma return false";
                            }
                            z2 = true;
                            if (!z2) {
                                i.unlock();
                                j.unlock();
                                b();
                                return;
                            }
                        }
                        tbsLogReport2.setInstallErrorCode(com.tencent.smtt.sdk.TbsListener.ErrorCode.UNLZMA_FAIURE, str4);
                        z2 = false;
                        if (!z2) {
                            i.unlock();
                            j.unlock();
                            b();
                            return;
                        }
                    }
                }
                com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "unlzma finished");
                com.tencent.smtt.sdk.k.a(context).c(iC, 1);
            } else {
                if (com.tencent.smtt.sdk.TbsDownloader.a(context)) {
                    if (str == null) {
                        strD = com.tencent.smtt.sdk.k.a(context).d("install_apk_path");
                        if (strD == null) {
                            com.tencent.smtt.sdk.TbsLogReport.getInstance(context).setInstallErrorCode(202, "apk path is null!");
                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-511);
                            try {
                                i.unlock();
                                j.unlock();
                            } catch (java.lang.Exception e15) {
                                e15.printStackTrace();
                            }
                            try {
                                b();
                                return;
                            } catch (java.lang.Exception e16) {
                                e16.printStackTrace();
                                return;
                            }
                        }
                    } else {
                        strD = str;
                    }
                    a(context, new java.io.File(strD), true);
                }
                iC = 0;
            }
            if (iC3 < 2) {
                if (z) {
                    int iC5 = com.tencent.smtt.sdk.k.a(context).c("dexopt_retry_num");
                    if (iC5 > 10) {
                        com.tencent.smtt.sdk.TbsLogReport.getInstance(context).setInstallErrorCode(com.tencent.smtt.sdk.TbsListener.ErrorCode.EXCEED_DEXOPT_RETRY_NUM, "exceed dexopt retry num!");
                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-514);
                        E(context);
                        try {
                            i.unlock();
                            j.unlock();
                        } catch (java.lang.Exception e17) {
                            e17.printStackTrace();
                        }
                        try {
                            b();
                            return;
                        } catch (java.lang.Exception e18) {
                            e18.printStackTrace();
                            return;
                        }
                    }
                    com.tencent.smtt.sdk.k.a(context).a(iC5 + 1);
                }
                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-549);
                if (!j(context, 0)) {
                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-515);
                    try {
                        i.unlock();
                        j.unlock();
                    } catch (java.lang.Exception e19) {
                        e19.printStackTrace();
                    }
                    try {
                        b();
                        return;
                    } catch (java.lang.Exception e20) {
                        e20.printStackTrace();
                        return;
                    }
                }
                com.tencent.smtt.sdk.k.a(context).c(iC, 2);
                com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "STEP 2/2 installation completed! you can restart!", true);
                com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "STEP 2/2 installation completed! you can restart! version:" + i2);
                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-516);
                try {
                    android.content.SharedPreferences.Editor editorEdit = (android.os.Build.VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).edit();
                    editorEdit.putInt("tbs_preload_x5_counter", 0);
                    editorEdit.putInt("tbs_preload_x5_recorder", 0);
                    editorEdit.putInt("tbs_preload_x5_version", i2);
                    editorEdit.commit();
                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-517);
                } catch (java.lang.Throwable th2) {
                    com.tencent.smtt.utils.TbsLog.e("TbsInstaller", "Init tbs_preload_x5_counter#1 exception:" + android.util.Log.getStackTraceString(th2));
                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-518);
                }
                if (i2 == 88888888) {
                    a(i2, str, context);
                }
                if (this.k) {
                    tbsLogReport = com.tencent.smtt.sdk.TbsLogReport.getInstance(context);
                    iU = u(context);
                    str2 = "continueInstallWithout core success";
                } else {
                    tbsLogReport = com.tencent.smtt.sdk.TbsLogReport.getInstance(context);
                    iU = u(context);
                    str2 = com.unisound.common.y.J;
                }
                tbsLogReport.setInstallErrorCode(iU, str2);
                try {
                    i.unlock();
                    j.unlock();
                } catch (java.lang.Exception e21) {
                    e21.printStackTrace();
                }
                try {
                    b();
                } catch (java.lang.Exception e22) {
                    e22.printStackTrace();
                }
                if (!z4) {
                    throw th;
                }
                com.tencent.smtt.sdk.QbSdk.m.onInstallFinish(com.tencent.smtt.sdk.TbsListener.ErrorCode.INSTALL_SUCCESS_AND_RELEASE_LOCK);
                throw th;
            }
            if (iC3 == 2) {
                try {
                    com.tencent.smtt.sdk.QbSdk.m.onInstallFinish(200);
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    z4 = true;
                }
            } else {
                z3 = false;
            }
            try {
                i.unlock();
                j.unlock();
            } catch (java.lang.Exception e23) {
                e23.printStackTrace();
            }
            try {
                b();
            } catch (java.lang.Exception e24) {
                e24.printStackTrace();
            }
            if (z3) {
                com.tencent.smtt.sdk.QbSdk.m.onInstallFinish(com.tencent.smtt.sdk.TbsListener.ErrorCode.INSTALL_SUCCESS_AND_RELEASE_LOCK);
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
        }
    }

    private boolean b(android.content.Context context, java.io.File file) {
        try {
            java.io.File[] fileArrListFiles = file.listFiles(new java.io.FileFilter() { // from class: com.tencent.smtt.sdk.m.6
                @Override // java.io.FileFilter
                public boolean accept(java.io.File file2) {
                    return file2.getName().endsWith(".jar");
                }
            });
            int length = fileArrListFiles.length;
            if (android.os.Build.VERSION.SDK_INT < 16 && context.getPackageName() != null && context.getPackageName().equalsIgnoreCase(com.tencent.smtt.sdk.TbsConfig.APP_DEMO)) {
                try {
                    java.lang.Thread.sleep(5000L);
                } catch (java.lang.Exception unused) {
                }
            }
            java.lang.ClassLoader classLoader = context.getClassLoader();
            for (int i2 = 0; i2 < length; i2++) {
                com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "jarFile: " + fileArrListFiles[i2].getAbsolutePath());
                new dalvik.system.DexClassLoader(fileArrListFiles[i2].getAbsolutePath(), file.getAbsolutePath(), null, classLoader);
            }
            return true;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.tencent.smtt.sdk.TbsLogReport.getInstance(context).setInstallErrorCode(com.tencent.smtt.sdk.TbsListener.ErrorCode.DEXOPT_EXCEPTION, e.toString());
            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-doTbsDexOpt done");
            return false;
        }
    }

    private int c(android.content.Context context, android.os.Bundle bundle) throws java.lang.Throwable {
        com.tencent.smtt.sdk.TbsLogReport tbsLogReport;
        int i2;
        java.lang.String str;
        try {
            android.os.Bundle bundleA = com.tencent.smtt.sdk.QbSdk.a(context, bundle);
            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "tpatch finished,ret is" + bundleA);
            int i3 = bundleA.getInt("patch_result");
            if (i3 != 0) {
                java.lang.String string = bundle.getString("new_apk_location");
                if (!android.text.TextUtils.isEmpty(string)) {
                    com.tencent.smtt.utils.f.b(new java.io.File(string));
                }
                com.tencent.smtt.sdk.TbsLogReport.getInstance(context).setInstallErrorCode(i3, "tpatch fail,patch error_code=" + i3);
                return 1;
            }
            java.lang.String string2 = bundle.getString("new_apk_location");
            int i4 = bundle.getInt("new_core_ver");
            int iA = a(new java.io.File(string2));
            if (i4 != iA) {
                com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "version not equals!!!" + i4 + "patchVersion:" + iA);
                com.tencent.smtt.sdk.TbsLogReport.getInstance(context).setInstallErrorCode(com.tencent.smtt.sdk.TbsListener.ErrorCode.TPATCH_VERSION_FAILED, "version=" + i4 + ",patchVersion=" + iA);
                return 1;
            }
            java.io.File file = new java.io.File(bundle.getString("backup_apk"));
            java.lang.String strA = com.tencent.smtt.utils.b.a(context, true, file);
            if ("[REDACTED_HEX_CONSTANT]".equals(strA)) {
                if (com.tencent.smtt.sdk.TbsDownloader.a(context)) {
                    com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "Tpatch decouple success!");
                    tbsLogReport = com.tencent.smtt.sdk.TbsLogReport.getInstance(context);
                    i2 = com.tencent.smtt.sdk.TbsListener.ErrorCode.DECOUPLE_TPATCH_INSTALL_SUCCESS;
                    str = "";
                } else {
                    com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "Tpatch success!");
                    tbsLogReport = com.tencent.smtt.sdk.TbsLogReport.getInstance(context);
                    i2 = com.tencent.smtt.sdk.TbsListener.ErrorCode.TPATCH_INSTALL_SUCCESS;
                    str = "";
                }
                tbsLogReport.setInstallErrorCode(i2, str);
                return 0;
            }
            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "tpatch sig not equals!!!" + file + "signature:" + strA);
            com.tencent.smtt.sdk.TbsLogReport.getInstance(context).setInstallErrorCode(com.tencent.smtt.sdk.TbsListener.ErrorCode.TPATCH_BACKUP_NOT_VALID, "version=" + i4 + ",patchVersion=" + iA);
            com.tencent.smtt.utils.f.b(file);
            return 0;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.tencent.smtt.sdk.TbsLogReport.getInstance(context).setInstallErrorCode(com.tencent.smtt.sdk.TbsListener.ErrorCode.DECOUPLE_TPATCH_FAIL, "patch exception" + android.util.Log.getStackTraceString(e));
            return 1;
        }
    }

    private boolean c(android.content.Context context, java.io.File file) {
        try {
            java.io.File file2 = new java.io.File(file, "tbs_sdk_extension_dex.jar");
            java.io.File file3 = new java.io.File(file, "tbs_sdk_extension_dex.dex");
            new dalvik.system.DexClassLoader(file2.getAbsolutePath(), file.getAbsolutePath(), null, context.getClassLoader());
            java.lang.String strA = com.tencent.smtt.sdk.c.a(context, file3.getAbsolutePath());
            if (android.text.TextUtils.isEmpty(strA)) {
                com.tencent.smtt.sdk.TbsLogReport.getInstance(context).setInstallErrorCode(com.tencent.smtt.sdk.TbsListener.ErrorCode.DEXOAT_EXCEPTION, "can not find oat command");
                return false;
            }
            for (java.io.File file4 : file.listFiles(new java.io.FileFilter() { // from class: com.tencent.smtt.sdk.m.7
                @Override // java.io.FileFilter
                public boolean accept(java.io.File file5) {
                    return file5.getName().endsWith(".jar");
                }
            })) {
                java.lang.String strSubstring = file4.getName().substring(0, file4.getName().length() - 4);
                java.lang.Runtime.getRuntime().exec("/system/bin/dex2oat " + strA.replaceAll("tbs_sdk_extension_dex", strSubstring) + " --dex-location=" + a().q(context) + java.io.File.separator + strSubstring + ".jar").waitFor();
            }
            return true;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.tencent.smtt.sdk.TbsLogReport.getInstance(context).setInstallErrorCode(com.tencent.smtt.sdk.TbsListener.ErrorCode.DEXOAT_EXCEPTION, e);
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private synchronized boolean c(android.content.Context context, boolean z) {
        java.lang.String str;
        java.lang.String str2;
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch");
        boolean z2 = false;
        try {
            if (!t(context)) {
                return false;
            }
            boolean zTryLock = i.tryLock();
            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch Locked =" + zTryLock);
            if (zTryLock) {
                try {
                    int iB = com.tencent.smtt.sdk.k.a(context).b("tpatch_status");
                    int iA = a(false, context);
                    com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch copyStatus =" + iB);
                    com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch tbsCoreInstalledVer =" + iA);
                    if (iB == 1) {
                        if (iA == 0) {
                            str = "TbsInstaller";
                            str2 = "TbsInstaller-enableTbsCoreFromTpatch tbsCoreInstalledVer = 0";
                        } else if (z) {
                            str = "TbsInstaller";
                            str2 = "TbsInstaller-enableTbsCoreFromTpatch tbsCoreInstalledVer != 0";
                        }
                        com.tencent.smtt.utils.TbsLog.i(str, str2, true);
                        y(context);
                        z2 = true;
                    }
                    i.unlock();
                } catch (java.lang.Throwable th) {
                    i.unlock();
                    throw th;
                }
            }
            b();
        } catch (java.lang.Throwable th2) {
            com.tencent.smtt.sdk.TbsLogReport.getInstance(context).setInstallErrorCode(com.tencent.smtt.sdk.TbsListener.ErrorCode.COPY_EXCEPTION, th2.toString());
            com.tencent.smtt.sdk.QbSdk.a(context, "TbsInstaller::enableTbsCoreFromTpatch exception:" + android.util.Log.getStackTraceString(th2));
        }
        return z2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private synchronized boolean d(android.content.Context context, boolean z) {
        java.lang.String str;
        java.lang.String str2;
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy");
        boolean z2 = false;
        try {
            if (!t(context)) {
                return false;
            }
            boolean zTryLock = i.tryLock();
            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy Locked =" + zTryLock);
            if (zTryLock) {
                try {
                    int iB = com.tencent.smtt.sdk.k.a(context).b("copy_status");
                    int iA = a(false, context);
                    com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy copyStatus =" + iB);
                    com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer =" + iA);
                    if (iB == 1) {
                        if (iA == 0) {
                            str = "TbsInstaller";
                            str2 = "TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer = 0";
                        } else if (z) {
                            str = "TbsInstaller";
                            str2 = "TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer != 0";
                        }
                        com.tencent.smtt.utils.TbsLog.i(str, str2, true);
                        z(context);
                        z2 = true;
                    }
                    i.unlock();
                } catch (java.lang.Throwable th) {
                    i.unlock();
                    throw th;
                }
            }
            b();
        } catch (java.lang.Throwable th2) {
            com.tencent.smtt.sdk.TbsLogReport.getInstance(context).setInstallErrorCode(com.tencent.smtt.sdk.TbsListener.ErrorCode.COPY_EXCEPTION, th2.toString());
            com.tencent.smtt.sdk.QbSdk.a(context, "TbsInstaller::enableTbsCoreFromCopy exception:" + android.util.Log.getStackTraceString(th2));
        }
        return z2;
    }

    private boolean e(android.content.Context context, java.lang.String str) {
        android.content.pm.PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0044 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:13:0x0046 A[Catch: Exception -> 0x00be, all -> 0x00d8, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x00be, blocks: (B:9:0x003e, B:13:0x0046, B:15:0x0055, B:29:0x00ad, B:33:0x00ba, B:31:0x00b4, B:32:0x00b9), top: B:43:0x003e, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x0090 A[Catch: all -> 0x00b3, TryCatch #1 {all -> 0x00b3, blocks: (B:17:0x006b, B:19:0x0075, B:21:0x0090, B:24:0x009d, B:27:0x00a8), top: B:44:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:23:0x0099  */
    /* JADX WARN: Code duplicated, block: B:25:0x00a1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:26:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:44:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:11:0x0044, please report this as an issue */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private synchronized boolean e(android.content.Context context, boolean z) {
        boolean z2;
        boolean zTryLock;
        int iC;
        int iA;
        java.lang.String str;
        java.lang.String str2;
        if (context == null) {
            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip canRenameTmpDir =" + z);
            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "Tbsinstaller enableTbsCoreFromUnzip #1 ");
            z2 = false;
            if (!t(context)) {
                return false;
            }
            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "Tbsinstaller enableTbsCoreFromUnzip #2 ");
            zTryLock = i.tryLock();
            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip locked=" + zTryLock);
            if (zTryLock) {
                iC = com.tencent.smtt.sdk.k.a(context).c();
                com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip installStatus=" + iC);
                iA = a(false, context);
                if (iC == 2) {
                    com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "Tbsinstaller enableTbsCoreFromUnzip #4 ");
                    if (iA == 0) {
                        str = "TbsInstaller";
                        str2 = "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer = 0";
                    } else if (z) {
                        str = "TbsInstaller";
                        str2 = "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer != 0";
                    }
                    com.tencent.smtt.utils.TbsLog.i(str, str2, false);
                    x(context);
                    z2 = true;
                }
                i.unlock();
            }
            b();
            return z2;
        }
        if ("com.tencent.mm".equals(context.getApplicationContext().getApplicationInfo().packageName)) {
            com.tencent.smtt.sdk.TbsLogReport.getInstance(context).setInstallErrorCode(com.tencent.smtt.sdk.TbsListener.ErrorCode.INSTALL_FROM_UNZIP, " ");
        }
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip canRenameTmpDir =" + z);
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "Tbsinstaller enableTbsCoreFromUnzip #1 ");
        z2 = false;
        try {
            if (!t(context)) {
                return false;
            }
            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "Tbsinstaller enableTbsCoreFromUnzip #2 ");
            zTryLock = i.tryLock();
            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip locked=" + zTryLock);
            if (zTryLock) {
                try {
                    iC = com.tencent.smtt.sdk.k.a(context).c();
                    com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip installStatus=" + iC);
                    iA = a(false, context);
                    if (iC == 2) {
                        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "Tbsinstaller enableTbsCoreFromUnzip #4 ");
                        if (iA == 0) {
                            str = "TbsInstaller";
                            str2 = "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer = 0";
                        } else if (z) {
                            str = "TbsInstaller";
                            str2 = "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer != 0";
                        }
                        com.tencent.smtt.utils.TbsLog.i(str, str2, false);
                        x(context);
                        z2 = true;
                    }
                    i.unlock();
                } catch (java.lang.Throwable th) {
                    i.unlock();
                    throw th;
                }
            }
            b();
            return z2;
        } catch (java.lang.Exception e) {
            com.tencent.smtt.sdk.QbSdk.a(context, "TbsInstaller::enableTbsCoreFromUnzip Exception: " + e);
            e.printStackTrace();
        }
        throw th;
    }

    private synchronized boolean f(android.content.Context context, boolean z) {
        return false;
    }

    private void g(android.content.Context context, boolean z) {
        if (context == null) {
            com.tencent.smtt.sdk.TbsLogReport.getInstance(context).setInstallErrorCode(225, "setTmpFolderCoreToRead context is null");
            return;
        }
        try {
            java.io.File file = new java.io.File(com.tencent.smtt.sdk.QbSdk.getTbsFolderDir(context), "tmp_folder_core_to_read.conf");
            if (!z) {
                com.tencent.smtt.utils.f.b(file);
            } else if (!file.exists()) {
                file.createNewFile();
            }
        } catch (java.lang.Exception e) {
            com.tencent.smtt.sdk.TbsLogReport.getInstance(context).setInstallErrorCode(225, "setTmpFolderCoreToRead Exception message is " + e.getMessage() + " Exception cause is " + e.getCause());
        }
    }

    private void h(android.content.Context context, int i2) {
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "proceedTpatchStatus,result=" + i2);
        if (i2 == 0) {
            if (com.tencent.smtt.sdk.TbsDownloader.a(context)) {
                i(context, 6);
            } else {
                g(context, true);
                com.tencent.smtt.sdk.k.a(context).b(com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0), 1);
            }
        }
        com.tencent.smtt.sdk.QbSdk.setTBSInstallingStatus(false);
    }

    private void i(android.content.Context context, int i2) {
        java.io.File fileF = a().f(context, i2);
        a().g(context, true);
        java.io.File fileP = p(context);
        com.tencent.smtt.utils.f.a(fileP, true);
        fileF.renameTo(fileP);
        com.tencent.smtt.sdk.TbsShareManager.b(context);
    }

    private boolean j(android.content.Context context, int i2) {
        java.io.File fileF;
        boolean z;
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-doTbsDexOpt start - dirMode: " + i2);
        boolean z2 = false;
        try {
            if (i2 != 0) {
                if (i2 == 1) {
                    fileF = f(context, 1);
                } else {
                    if (i2 != 2) {
                        com.tencent.smtt.utils.TbsLog.e("TbsInstaller", "doDexoptOrDexoat mode error: " + i2);
                        return false;
                    }
                    fileF = q(context);
                }
            } else {
                if (com.tencent.smtt.sdk.TbsDownloader.a(context)) {
                    return true;
                }
                fileF = f(context, 0);
            }
            try {
                java.lang.String property = java.lang.System.getProperty("java.vm.version");
                z = property != null && property.startsWith("2");
            } catch (java.lang.Throwable th) {
                com.tencent.smtt.sdk.TbsLogReport.getInstance(context).setInstallErrorCode(com.tencent.smtt.sdk.TbsListener.ErrorCode.DEXOAT_EXCEPTION, th);
            }
            boolean z3 = android.os.Build.VERSION.SDK_INT == 23;
            boolean z4 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).mPreferences.getBoolean(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_STOP_PRE_OAT, false);
            if (z && z3 && !z4) {
                z2 = true;
            }
            if (z2 && c(context, fileF)) {
                com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "doTbsDexOpt -- doDexoatForArtVm");
                return true;
            }
            if (!z) {
                com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "doTbsDexOpt -- doDexoptForDavlikVM");
                return b(context, fileF);
            }
            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "doTbsDexOpt -- is ART mode, skip!");
            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-doTbsDexOpt done");
            return true;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.tencent.smtt.sdk.TbsLogReport.getInstance(context).setInstallErrorCode(com.tencent.smtt.sdk.TbsListener.ErrorCode.DEXOPT_EXCEPTION, e.toString());
        }
    }

    static java.io.File s(android.content.Context context) {
        java.io.File file = new java.io.File(com.tencent.smtt.sdk.QbSdk.getTbsFolderDir(context), "core_private");
        if (file.isDirectory() || file.mkdir()) {
            return file;
        }
        return null;
    }

    private int u(android.content.Context context) {
        boolean z = com.tencent.smtt.sdk.k.a(context).d() == 1;
        boolean zA = com.tencent.smtt.sdk.TbsDownloader.a(context);
        if (z) {
            return zA ? com.tencent.smtt.sdk.TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_SUCCESS : com.tencent.smtt.sdk.TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS;
        }
        if (zA) {
            return com.tencent.smtt.sdk.TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS;
        }
        return 200;
    }

    private static boolean v(android.content.Context context) {
        java.lang.String str;
        java.lang.String str2;
        if (context == null) {
            str = "TbsInstaller";
            str2 = "TbsInstaller-getTmpFolderCoreToRead, #1";
        } else {
            try {
                if (new java.io.File(com.tencent.smtt.sdk.QbSdk.getTbsFolderDir(context), "tmp_folder_core_to_read.conf").exists()) {
                    com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #2");
                    return true;
                }
                com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #3");
                return false;
            } catch (java.lang.Exception unused) {
                str = "TbsInstaller";
                str2 = "TbsInstaller-getTmpFolderCoreToRead, #4";
            }
        }
        com.tencent.smtt.utils.TbsLog.i(str, str2);
        return true;
    }

    private boolean w(android.content.Context context) {
        boolean tbsCoreLoadRenameFileLockEnable;
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock #1 ");
        try {
            tbsCoreLoadRenameFileLockEnable = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance().getTbsCoreLoadRenameFileLockEnable();
        } catch (java.lang.Throwable unused) {
            tbsCoreLoadRenameFileLockEnable = true;
        }
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock #2  enabled is " + tbsCoreLoadRenameFileLockEnable);
        l = !tbsCoreLoadRenameFileLockEnable ? com.tencent.smtt.sdk.u.a().b(context) : com.tencent.smtt.utils.f.f(context);
        if (l == null) {
            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "getTbsCoreRenameFileLock## failed!");
            return false;
        }
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock true ");
        return true;
    }

    private void x(android.content.Context context) {
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip");
        if (!w(context)) {
            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
            return;
        }
        try {
            A(context);
            B(context);
            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "after renameTbsCoreShareDir");
            if (com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(context)) {
                com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "is thirdapp and not chmod");
            } else {
                com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "prepare to shareTbsCore");
                com.tencent.smtt.sdk.TbsShareManager.a(context);
            }
            com.tencent.smtt.sdk.k.a(context).a(0);
            com.tencent.smtt.sdk.k.a(context).b(0);
            com.tencent.smtt.sdk.k.a(context).d(0);
            com.tencent.smtt.sdk.k.a(context).a("incrupdate_retry_num", 0);
            com.tencent.smtt.sdk.k.a(context).c(0, 3);
            com.tencent.smtt.sdk.k.a(context).a("");
            com.tencent.smtt.sdk.k.a(context).a("tpatch_num", 0);
            com.tencent.smtt.sdk.k.a(context).c(-1);
            if (!com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(context)) {
                int i2 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
                if (i2 <= 0 || i2 == a().h(context) || i2 != a().i(context)) {
                    com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip #1 deCoupleCoreVersion is " + i2 + " getTbsCoreShareDecoupleCoreVersion is " + a().h(context) + " getTbsCoreInstalledVerInNolock is " + a().i(context));
                } else {
                    n(context);
                }
            }
            if (com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(context)) {
                com.tencent.smtt.sdk.TbsShareManager.writeCoreInfoForThirdPartyApp(context, m(context), true);
            }
            f935a.set(0);
            o = 0;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            com.tencent.smtt.sdk.TbsLogReport.getInstance(context).setInstallErrorCode(com.tencent.smtt.sdk.TbsListener.ErrorCode.RENAME_EXCEPTION, "exception when renameing from unzip:" + th.toString());
            com.tencent.smtt.utils.TbsLog.e("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip Exception", true);
        }
        g(context);
    }

    private void y(android.content.Context context) {
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromTpatch");
        if (!w(context)) {
            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
            return;
        }
        try {
            A(context);
            D(context);
            com.tencent.smtt.sdk.TbsShareManager.a(context);
            com.tencent.smtt.sdk.k.a(context).b(0, -1);
            com.tencent.smtt.sdk.k.a(context).a("tpatch_num", 0);
            f935a.set(0);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.tencent.smtt.sdk.TbsLogReport.getInstance(context).setInstallErrorCode(com.tencent.smtt.sdk.TbsListener.ErrorCode.TPATCH_ENABLE_EXCEPTION, "exception when renameing from tpatch:" + e.toString());
        }
        g(context);
    }

    private void z(android.content.Context context) {
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromCopy");
        if (!w(context)) {
            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
            return;
        }
        try {
            A(context);
            C(context);
            com.tencent.smtt.sdk.TbsShareManager.a(context);
            com.tencent.smtt.sdk.k.a(context).a(0, 3);
            com.tencent.smtt.sdk.k.a(context).a("tpatch_num", 0);
            if (!com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(context)) {
                int i2 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
                if (i2 <= 0 || i2 == a().h(context) || i2 != a().i(context)) {
                    com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromCopy #1 deCoupleCoreVersion is " + i2 + " getTbsCoreShareDecoupleCoreVersion is " + a().h(context) + " getTbsCoreInstalledVerInNolock is " + a().i(context));
                } else {
                    n(context);
                }
            }
            f935a.set(0);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.tencent.smtt.sdk.TbsLogReport.getInstance(context).setInstallErrorCode(com.tencent.smtt.sdk.TbsListener.ErrorCode.RENAME_EXCEPTION, "exception when renameing from copy:" + e.toString());
        }
        g(context);
    }

    int a(java.io.File file) throws java.lang.Throwable {
        java.io.BufferedInputStream bufferedInputStream;
        try {
            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller--getTbsVersion  tbsShareDir is " + file);
            java.io.File file2 = new java.io.File(file, "tbs.conf");
            if (!file2.exists()) {
                return 0;
            }
            java.util.Properties properties = new java.util.Properties();
            bufferedInputStream = new java.io.BufferedInputStream(new java.io.FileInputStream(file2));
            try {
                properties.load(bufferedInputStream);
                bufferedInputStream.close();
                java.lang.String property = properties.getProperty("tbs_core_version");
                if (property == null) {
                    try {
                        bufferedInputStream.close();
                    } catch (java.io.IOException unused) {
                    }
                    return 0;
                }
                int i2 = java.lang.Integer.parseInt(property);
                try {
                    bufferedInputStream.close();
                } catch (java.io.IOException unused2) {
                }
                return i2;
            } catch (java.lang.Exception unused3) {
            } catch (java.lang.Throwable th) {
                th = th;
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (java.io.IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (java.lang.Exception unused5) {
            bufferedInputStream = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            bufferedInputStream = null;
        }
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (java.io.IOException unused6) {
            }
        }
        return 0;
    }

    int a(java.lang.String str) throws java.lang.Throwable {
        java.lang.Throwable th;
        java.io.BufferedInputStream bufferedInputStream;
        if (str == null) {
            return 0;
        }
        try {
            java.io.File file = new java.io.File(new java.io.File(str), "tbs.conf");
            if (!file.exists()) {
                return 0;
            }
            java.util.Properties properties = new java.util.Properties();
            bufferedInputStream = new java.io.BufferedInputStream(new java.io.FileInputStream(file));
            try {
                properties.load(bufferedInputStream);
                bufferedInputStream.close();
                java.lang.String property = properties.getProperty("tbs_core_version");
                if (property == null) {
                    try {
                        bufferedInputStream.close();
                    } catch (java.io.IOException unused) {
                    }
                    return 0;
                }
                int i2 = java.lang.Integer.parseInt(property);
                try {
                    bufferedInputStream.close();
                } catch (java.io.IOException unused2) {
                }
                return i2;
            } catch (java.lang.Exception unused3) {
            } catch (java.lang.Throwable th2) {
                th = th2;
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (java.io.IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (java.lang.Exception unused5) {
            bufferedInputStream = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            bufferedInputStream = null;
        }
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (java.io.IOException unused6) {
            }
        }
        return 0;
    }

    public int a(boolean z, android.content.Context context) {
        if (z || ((java.lang.Integer) f935a.get()).intValue() <= 0) {
            f935a.set(java.lang.Integer.valueOf(i(context)));
        }
        return ((java.lang.Integer) f935a.get()).intValue();
    }

    java.io.File a(android.content.Context context, int i2, boolean z) {
        java.lang.String str;
        java.lang.String str2;
        java.io.File tbsFolderDir = com.tencent.smtt.sdk.QbSdk.getTbsFolderDir(context);
        java.lang.String str3 = "";
        switch (i2) {
            case 0:
                str3 = "core_unzip_tmp";
                break;
            case 1:
                str3 = "core_copy_tmp";
                break;
            case 2:
                str3 = "core_unzip_tmp_decouple";
                break;
            case 3:
                str3 = "core_share_backup";
                break;
            case 4:
                str3 = "core_share_backup_tmp";
                break;
            case 5:
                str3 = "tpatch_tmp";
                break;
            case 6:
                str3 = "tpatch_decouple_tmp";
                break;
        }
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "type=" + i2 + "needMakeDir=" + z + "folder=" + str3);
        java.io.File file = new java.io.File(tbsFolderDir, str3);
        if (!file.isDirectory()) {
            if (!z) {
                str = "TbsInstaller";
                str2 = "getCoreDir,no need mkdir";
            } else if (!file.mkdir()) {
                str = "TbsInstaller";
                str2 = "getCoreDir,mkdir false";
            }
            com.tencent.smtt.utils.TbsLog.i(str, str2);
            return null;
        }
        return file;
    }

    public void a(android.content.Context context, int i2) {
        g(context, true);
        com.tencent.smtt.sdk.k.a(context).c(i2, 2);
    }

    void a(android.content.Context context, android.os.Bundle bundle) {
        if (bundle == null || context == null) {
            return;
        }
        java.lang.Object[] objArr = {context, bundle};
        android.os.Message message = new android.os.Message();
        message.what = 3;
        message.obj = objArr;
        m.sendMessage(message);
    }

    void a(android.content.Context context, java.io.File file, int i2) {
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "unzipTbsCoreToThirdAppTmp,ctx=" + context + "File=" + file + "coreVersion=" + i2);
        if (file == null || context == null) {
            return;
        }
        java.lang.Object[] objArr = {context, file, java.lang.Integer.valueOf(i2)};
        android.os.Message message = new android.os.Message();
        message.what = 4;
        message.obj = objArr;
        m.sendMessage(message);
    }

    void a(android.content.Context context, java.lang.String str, int i2) {
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore tbsApkPath=" + str);
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore tbsCoreTargetVer=" + i2);
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore currentProcessId=" + android.os.Process.myPid());
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore currentThreadName=" + java.lang.Thread.currentThread().getName());
        java.lang.Object[] objArr = {context, str, java.lang.Integer.valueOf(i2)};
        android.os.Message message = new android.os.Message();
        message.what = 1;
        message.obj = objArr;
        m.sendMessage(message);
    }

    void a(android.content.Context context, boolean z) throws java.lang.Throwable {
        int iC;
        int iB;
        java.lang.String strD;
        int iC2;
        int iB2;
        boolean z2 = true;
        if (z) {
            this.k = true;
        }
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessId=" + android.os.Process.myPid());
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentThreadName=" + java.lang.Thread.currentThread().getName());
        if (t(context)) {
            if (i.tryLock()) {
                try {
                    iC = com.tencent.smtt.sdk.k.a(context).c();
                    iB = com.tencent.smtt.sdk.k.a(context).b();
                    strD = com.tencent.smtt.sdk.k.a(context).d("install_apk_path");
                    iC2 = com.tencent.smtt.sdk.k.a(context).c("copy_core_ver");
                    iB2 = com.tencent.smtt.sdk.k.a(context).b("copy_status");
                    i.unlock();
                } catch (java.lang.Throwable th) {
                    i.unlock();
                    throw th;
                }
            } else {
                strD = null;
                iC = -1;
                iB = 0;
                iC2 = 0;
                iB2 = -1;
            }
            b();
            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore installStatus=" + iC);
            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsCoreInstallVer=" + iB);
            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsApkPath=" + strD);
            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsCoreCopyVer=" + iC2);
            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore copyStatus=" + iB2);
            if (com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(context)) {
                c(context, com.tencent.smtt.sdk.TbsShareManager.a(context, false));
                return;
            }
            int i2 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, 0);
            if (i2 != 1 && i2 != 2 && i2 != 4) {
                z2 = false;
            }
            if (!z2 && i2 != 0 && i2 != 5) {
                android.os.Bundle bundle = new android.os.Bundle();
                bundle.putInt("operation", 10001);
                a(context, bundle);
            }
            if (iC > -1 && iC < 2) {
                a(context, strD, iB);
            }
            if (iB2 == 0) {
                b(context, iC2);
            }
        }
    }

    public synchronized boolean a(final android.content.Context context, final android.content.Context context2) {
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp");
        if (p) {
            return true;
        }
        p = true;
        new java.lang.Thread() { // from class: com.tencent.smtt.sdk.m.4
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                java.io.File fileQ;
                com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp thread start");
                try {
                    if (context2 == null) {
                        fileQ = new java.io.File(com.tencent.smtt.sdk.TbsShareManager.getHostCorePathAppDefined());
                    } else if (com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(context) && com.tencent.smtt.sdk.TbsShareManager.c(context) != null && com.tencent.smtt.sdk.TbsShareManager.c(context).contains("decouple")) {
                        fileQ = com.tencent.smtt.sdk.m.this.p(context2);
                    } else {
                        com.tencent.smtt.sdk.m mVar = com.tencent.smtt.sdk.m.this;
                        fileQ = mVar.q(context2);
                    }
                    java.io.File fileQ2 = com.tencent.smtt.sdk.m.this.q(context);
                    int i2 = android.os.Build.VERSION.SDK_INT;
                    if (i2 != 19 && i2 < 21) {
                        com.tencent.smtt.utils.f.a(fileQ, fileQ2, new java.io.FileFilter() { // from class: com.tencent.smtt.sdk.m.4.1
                            @Override // java.io.FileFilter
                            public boolean accept(java.io.File file) {
                                return file.getName().endsWith(".dex");
                            }
                        });
                    }
                    com.tencent.smtt.utils.f.a(fileQ, fileQ2, new java.io.FileFilter() { // from class: com.tencent.smtt.sdk.m.4.2
                        @Override // java.io.FileFilter
                        public boolean accept(java.io.File file) {
                            return file.getName().endsWith("tbs.conf");
                        }
                    });
                    com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp thread done");
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        return true;
    }

    public boolean a(android.content.Context context, java.io.File[] fileArr) {
        return false;
    }

    android.content.Context b(android.content.Context context, java.lang.String str) {
        try {
            if (context.getPackageName() == str || !com.tencent.smtt.sdk.TbsPVConfig.getInstance(context).isEnableNoCoreGray()) {
                return context.createPackageContext(str, 2);
            }
            return null;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    java.io.File b(android.content.Context context, android.content.Context context2) {
        java.io.File file = new java.io.File(com.tencent.smtt.sdk.QbSdk.getTbsFolderDir(context2), "core_share");
        if (file.isDirectory() || ((context != null && com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(context)) || file.mkdir())) {
            return file;
        }
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "getTbsCoreShareDir,mkdir false");
        return null;
    }

    synchronized void b() {
        int i2 = this.e;
        if (i2 <= 0) {
            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock currentTbsFileLockStackCount=" + this.e + "call stack:" + android.util.Log.getStackTraceString(new java.lang.Throwable()));
            return;
        }
        if (i2 > 1) {
            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock with skip");
            this.e--;
        } else {
            if (i2 == 1) {
                com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock without skip");
                com.tencent.smtt.utils.f.a(this.f, this.g);
                this.e = 0;
            }
        }
    }

    public void b(android.content.Context context) {
        g(context, true);
        com.tencent.smtt.sdk.k.a(context).c(h(context), 2);
    }

    /* JADX WARN: Code duplicated, block: B:132:0x0408  */
    /* JADX WARN: Code duplicated, block: B:134:0x040c  */
    /* JADX WARN: Code duplicated, block: B:136:0x0434  */
    /* JADX WARN: Code duplicated, block: B:137:0x0447  */
    /* JADX WARN: Code duplicated, block: B:144:0x046d  */
    /* JADX WARN: Code duplicated, block: B:146:0x0471 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:147:0x0473  */
    /* JADX WARN: Code duplicated, block: B:149:0x04b5  */
    /* JADX WARN: Code duplicated, block: B:150:0x04bd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:151:0x04bf  */
    /* JADX WARN: Code duplicated, block: B:153:0x04e7  */
    /* JADX WARN: Code duplicated, block: B:154:0x04ff  */
    /* JADX WARN: Code duplicated, block: B:156:0x051a  */
    /* JADX WARN: Code duplicated, block: B:98:0x02e6  */
    /* JADX WARN: Instruction removed from duplicated block: B:153:0x04e7, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:154:0x04ff, please report this as an issue */
    void b(android.content.Context context, android.os.Bundle bundle) throws java.lang.Throwable {
        int i2;
        com.tencent.smtt.sdk.TbsLogReport tbsLogReport;
        java.lang.String str;
        int i3;
        java.lang.StringBuilder sb;
        com.tencent.smtt.sdk.TbsLogReport tbsLogReport2;
        java.lang.String string;
        int i4;
        java.lang.StringBuilder sb2;
        int i5;
        java.lang.String str2;
        com.tencent.smtt.sdk.TbsLogReport tbsLogReport3;
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller installLocalTbsCoreExInThreadthread " + java.lang.Thread.currentThread().getName() + android.util.Log.getStackTraceString(new java.lang.Throwable()));
        if (c(context)) {
            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-539);
            return;
        }
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread");
        if (bundle == null || context == null) {
            return;
        }
        if (!com.tencent.smtt.utils.f.b(context)) {
            long jA = com.tencent.smtt.utils.q.a();
            long downloadMinFreeSpace = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).getDownloadMinFreeSpace();
            com.tencent.smtt.sdk.TbsLogReport.getInstance(context).setInstallErrorCode(210, "rom is not enough when patching tbs core! curAvailROM=" + jA + ",minReqRom=" + downloadMinFreeSpace);
            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-540);
            return;
        }
        if (!t(context)) {
            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-541);
            return;
        }
        boolean zTryLock = j.tryLock();
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread locked=" + zTryLock);
        if (!zTryLock) {
            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-547);
            b();
            return;
        }
        int i6 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).mPreferences.getInt(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, 0);
        android.os.Bundle bundleA = null;
        try {
            try {
                com.tencent.smtt.sdk.QbSdk.setTBSInstallingStatus(true);
                if (i6 == 5) {
                    int iC = c(context, bundle);
                    if (iC == 1) {
                        try {
                            com.tencent.smtt.sdk.k.a(context).a("tpatch_num", com.tencent.smtt.sdk.k.a(context).c("tpatch_num") + 1);
                        } catch (java.lang.Exception e) {
                            e = e;
                        } catch (java.lang.Throwable th) {
                            th = th;
                            i2 = iC;
                            j.unlock();
                            b();
                            if (i6 == 5) {
                                h(context, i2);
                                return;
                            }
                            if (i2 == 0) {
                                com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_SUCCESS");
                                com.tencent.smtt.sdk.k.a(context).a("incrupdate_retry_num", 0);
                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-544);
                                com.tencent.smtt.sdk.k.a(context).c(0, -1);
                                com.tencent.smtt.sdk.k.a(context).c(1);
                                java.lang.String string2 = bundleA.getString("apk_path");
                                com.tencent.smtt.sdk.j.a(new java.io.File(string2), context);
                                b(context, string2, bundleA.getInt("tbs_core_ver"));
                                if (com.tencent.smtt.sdk.TbsDownloader.a(context)) {
                                    com.tencent.smtt.sdk.k.a(context).c(-1);
                                }
                            } else if (i2 != 2) {
                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-546);
                                com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL");
                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                                com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).commit();
                                if (com.tencent.smtt.sdk.TbsDownloader.a(context)) {
                                    tbsLogReport = com.tencent.smtt.sdk.TbsLogReport.getInstance(context);
                                    str = "decouple incrUpdate fail! patch ret=" + i2;
                                    i3 = com.tencent.smtt.sdk.TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_FAIL;
                                } else {
                                    tbsLogReport = com.tencent.smtt.sdk.TbsLogReport.getInstance(context);
                                    str = "incrUpdate fail! patch ret=" + i2;
                                    i3 = com.tencent.smtt.sdk.TbsListener.ErrorCode.INCR_UPDATE_FAIL;
                                }
                                tbsLogReport.setInstallErrorCode(i3, str);
                            } else {
                                com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                            }
                            com.tencent.smtt.sdk.QbSdk.setTBSInstallingStatus(false);
                            throw th;
                        }
                    }
                    j.unlock();
                    b();
                    if (i6 == 5) {
                        h(context, iC);
                        return;
                    }
                    if (iC == 0) {
                        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_SUCCESS");
                        com.tencent.smtt.sdk.k.a(context).a("incrupdate_retry_num", 0);
                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-544);
                        com.tencent.smtt.sdk.k.a(context).c(0, -1);
                        com.tencent.smtt.sdk.k.a(context).c(1);
                        java.lang.String string3 = bundleA.getString("apk_path");
                        com.tencent.smtt.sdk.j.a(new java.io.File(string3), context);
                        b(context, string3, bundleA.getInt("tbs_core_ver"));
                        if (com.tencent.smtt.sdk.TbsDownloader.a(context)) {
                            com.tencent.smtt.sdk.k.a(context).c(-1);
                        }
                    } else if (iC == 2) {
                        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                    } else {
                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-546);
                        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL");
                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).commit();
                        if (com.tencent.smtt.sdk.TbsDownloader.a(context)) {
                            com.tencent.smtt.sdk.TbsLogReport.getInstance(context).setInstallErrorCode(com.tencent.smtt.sdk.TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_FAIL, "decouple incrUpdate fail! patch ret=" + iC);
                        } else {
                            com.tencent.smtt.sdk.TbsLogReport.getInstance(context).setInstallErrorCode(com.tencent.smtt.sdk.TbsListener.ErrorCode.INCR_UPDATE_FAIL, "incrUpdate fail! patch ret=" + iC);
                        }
                    }
                    com.tencent.smtt.sdk.QbSdk.setTBSInstallingStatus(false);
                    return;
                }
                if (i(context) > 0 && com.tencent.smtt.sdk.k.a(context).d() != 1) {
                    if ((i6 == 1 || i6 == 2 || i6 == 4) || i6 == 0) {
                        i5 = 2;
                    } else {
                        int iC2 = com.tencent.smtt.sdk.k.a(context).c("incrupdate_retry_num");
                        if (iC2 > 5) {
                            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread exceed incrupdate num");
                            java.lang.String string4 = bundle.getString("old_apk_location");
                            java.lang.String string5 = bundle.getString("new_apk_location");
                            java.lang.String string6 = bundle.getString("diff_file_location");
                            if (!android.text.TextUtils.isEmpty(string4)) {
                                com.tencent.smtt.utils.f.b(new java.io.File(string4));
                            }
                            if (!android.text.TextUtils.isEmpty(string5)) {
                                com.tencent.smtt.utils.f.b(new java.io.File(string5));
                            }
                            if (!android.text.TextUtils.isEmpty(string6)) {
                                com.tencent.smtt.utils.f.b(new java.io.File(string6));
                            }
                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).commit();
                            com.tencent.smtt.sdk.TbsLogReport.getInstance(context).setInstallErrorCode(com.tencent.smtt.sdk.TbsListener.ErrorCode.EXCEED_INCR_UPDATE, "incrUpdate exceed retry max num");
                            j.unlock();
                            b();
                            if (i6 == 5) {
                                h(context, 2);
                                return;
                            } else {
                                com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                                com.tencent.smtt.sdk.QbSdk.setTBSInstallingStatus(false);
                                return;
                            }
                        }
                        com.tencent.smtt.sdk.k.a(context).a("incrupdate_retry_num", iC2 + 1);
                        java.io.File fileS = s(context);
                        if (fileS == null || !new java.io.File(fileS, "x5.tbs").exists()) {
                            i5 = 2;
                        } else {
                            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-550);
                            bundleA = com.tencent.smtt.sdk.QbSdk.a(context, bundle);
                            if (bundleA != null) {
                                i5 = bundleA.getInt("patch_result");
                                if (i5 != 0) {
                                    try {
                                        tbsLogReport3 = com.tencent.smtt.sdk.TbsLogReport.getInstance(context);
                                        str2 = "result " + i5 + " : " + bundle.getInt("new_core_ver");
                                    } catch (java.lang.Exception e2) {
                                        e = e2;
                                        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "installLocalTbsCoreExInThread exception:" + android.util.Log.getStackTraceString(e));
                                        e.printStackTrace();
                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-543);
                                        com.tencent.smtt.sdk.TbsLogReport.getInstance(context).setInstallErrorCode(com.tencent.smtt.sdk.TbsListener.ErrorCode.INCR_UPDATE_EXCEPTION, e.toString());
                                        j.unlock();
                                        b();
                                        if (i6 == 5) {
                                            h(context, 1);
                                            return;
                                        }
                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-546);
                                        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL");
                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).commit();
                                        if (com.tencent.smtt.sdk.TbsDownloader.a(context)) {
                                            tbsLogReport2 = com.tencent.smtt.sdk.TbsLogReport.getInstance(context);
                                            sb = new java.lang.StringBuilder();
                                            sb.append("incrUpdate fail! patch ret=");
                                            sb.append(1);
                                            string = sb.toString();
                                            i4 = com.tencent.smtt.sdk.TbsListener.ErrorCode.INCR_UPDATE_FAIL;
                                            tbsLogReport2.setInstallErrorCode(i4, string);
                                            com.tencent.smtt.sdk.QbSdk.setTBSInstallingStatus(false);
                                        }
                                        tbsLogReport2 = com.tencent.smtt.sdk.TbsLogReport.getInstance(context);
                                        sb2 = new java.lang.StringBuilder();
                                        sb2.append("decouple incrUpdate fail! patch ret=");
                                        sb2.append(1);
                                    }
                                }
                                com.tencent.smtt.sdk.QbSdk.setTBSInstallingStatus(false);
                            }
                            try {
                                try {
                                    com.tencent.smtt.sdk.TbsLogReport tbsLogReport4 = com.tencent.smtt.sdk.TbsLogReport.getInstance(context);
                                    str2 = "result null : " + bundle.getInt("new_core_ver");
                                    tbsLogReport3 = tbsLogReport4;
                                    i5 = 1;
                                } catch (java.lang.Exception e3) {
                                    e = e3;
                                    com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "installLocalTbsCoreExInThread exception:" + android.util.Log.getStackTraceString(e));
                                    e.printStackTrace();
                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-543);
                                    com.tencent.smtt.sdk.TbsLogReport.getInstance(context).setInstallErrorCode(com.tencent.smtt.sdk.TbsListener.ErrorCode.INCR_UPDATE_EXCEPTION, e.toString());
                                    j.unlock();
                                    b();
                                    if (i6 == 5) {
                                        h(context, 1);
                                        return;
                                    }
                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-546);
                                    com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL");
                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).commit();
                                    if (com.tencent.smtt.sdk.TbsDownloader.a(context)) {
                                        tbsLogReport2 = com.tencent.smtt.sdk.TbsLogReport.getInstance(context);
                                        sb = new java.lang.StringBuilder();
                                        sb.append("incrUpdate fail! patch ret=");
                                        sb.append(1);
                                        string = sb.toString();
                                        i4 = com.tencent.smtt.sdk.TbsListener.ErrorCode.INCR_UPDATE_FAIL;
                                        tbsLogReport2.setInstallErrorCode(i4, string);
                                        com.tencent.smtt.sdk.QbSdk.setTBSInstallingStatus(false);
                                    }
                                    tbsLogReport2 = com.tencent.smtt.sdk.TbsLogReport.getInstance(context);
                                    sb2 = new java.lang.StringBuilder();
                                    sb2.append("decouple incrUpdate fail! patch ret=");
                                    sb2.append(1);
                                }
                            } catch (java.lang.Throwable th2) {
                                th = th2;
                                i2 = 1;
                                j.unlock();
                                b();
                                if (i6 == 5) {
                                    h(context, i2);
                                    return;
                                }
                                if (i2 == 0) {
                                    com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_SUCCESS");
                                    com.tencent.smtt.sdk.k.a(context).a("incrupdate_retry_num", 0);
                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-544);
                                    com.tencent.smtt.sdk.k.a(context).c(0, -1);
                                    com.tencent.smtt.sdk.k.a(context).c(1);
                                    java.lang.String string7 = bundleA.getString("apk_path");
                                    com.tencent.smtt.sdk.j.a(new java.io.File(string7), context);
                                    b(context, string7, bundleA.getInt("tbs_core_ver"));
                                    if (com.tencent.smtt.sdk.TbsDownloader.a(context)) {
                                        com.tencent.smtt.sdk.k.a(context).c(-1);
                                    }
                                } else if (i2 != 2) {
                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-546);
                                    com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL");
                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).commit();
                                    if (com.tencent.smtt.sdk.TbsDownloader.a(context)) {
                                        tbsLogReport = com.tencent.smtt.sdk.TbsLogReport.getInstance(context);
                                        str = "decouple incrUpdate fail! patch ret=" + i2;
                                        i3 = com.tencent.smtt.sdk.TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_FAIL;
                                    } else {
                                        tbsLogReport = com.tencent.smtt.sdk.TbsLogReport.getInstance(context);
                                        str = "incrUpdate fail! patch ret=" + i2;
                                        i3 = com.tencent.smtt.sdk.TbsListener.ErrorCode.INCR_UPDATE_FAIL;
                                    }
                                    tbsLogReport.setInstallErrorCode(i3, str);
                                } else {
                                    com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                                }
                                com.tencent.smtt.sdk.QbSdk.setTBSInstallingStatus(false);
                                throw th;
                            }
                            tbsLogReport3.setInstallErrorCode(com.tencent.smtt.sdk.TbsListener.ErrorCode.INCR_ERROR_DETAIL, str2);
                        }
                    }
                    j.unlock();
                    b();
                    if (i6 == 5) {
                        h(context, i5);
                        return;
                    }
                    if (i5 == 0) {
                        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_SUCCESS");
                        com.tencent.smtt.sdk.k.a(context).a("incrupdate_retry_num", 0);
                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-544);
                        com.tencent.smtt.sdk.k.a(context).c(0, -1);
                        com.tencent.smtt.sdk.k.a(context).c(1);
                        java.lang.String string8 = bundleA.getString("apk_path");
                        com.tencent.smtt.sdk.j.a(new java.io.File(string8), context);
                        b(context, string8, bundleA.getInt("tbs_core_ver"));
                        if (com.tencent.smtt.sdk.TbsDownloader.a(context)) {
                            com.tencent.smtt.sdk.k.a(context).c(-1);
                        }
                    } else if (i5 == 2) {
                        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                    } else {
                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-546);
                        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL");
                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).commit();
                        if (com.tencent.smtt.sdk.TbsDownloader.a(context)) {
                            tbsLogReport2 = com.tencent.smtt.sdk.TbsLogReport.getInstance(context);
                            sb2 = new java.lang.StringBuilder();
                            sb2.append("decouple incrUpdate fail! patch ret=");
                            sb2.append(i5);
                            string = sb2.toString();
                            i4 = com.tencent.smtt.sdk.TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_FAIL;
                            tbsLogReport2.setInstallErrorCode(i4, string);
                        } else {
                            tbsLogReport2 = com.tencent.smtt.sdk.TbsLogReport.getInstance(context);
                            sb = new java.lang.StringBuilder();
                            sb.append("incrUpdate fail! patch ret=");
                            sb.append(i5);
                            string = sb.toString();
                            i4 = com.tencent.smtt.sdk.TbsListener.ErrorCode.INCR_UPDATE_FAIL;
                            tbsLogReport2.setInstallErrorCode(i4, string);
                        }
                    }
                    com.tencent.smtt.sdk.QbSdk.setTBSInstallingStatus(false);
                }
                com.tencent.smtt.sdk.QbSdk.setTBSInstallingStatus(false);
                j.unlock();
                b();
                if (i6 == 5) {
                    h(context, 2);
                    return;
                } else {
                    com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                    com.tencent.smtt.sdk.QbSdk.setTBSInstallingStatus(false);
                    return;
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
            }
        } catch (java.lang.Exception e4) {
            e = e4;
        } catch (java.lang.Throwable th4) {
            th = th4;
            i2 = 2;
        }
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "installLocalTbsCoreExInThread exception:" + android.util.Log.getStackTraceString(e));
        e.printStackTrace();
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-543);
        com.tencent.smtt.sdk.TbsLogReport.getInstance(context).setInstallErrorCode(com.tencent.smtt.sdk.TbsListener.ErrorCode.INCR_UPDATE_EXCEPTION, e.toString());
        j.unlock();
        b();
        if (i6 == 5) {
            h(context, 1);
            return;
        }
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-546);
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL");
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, java.lang.Boolean.TRUE);
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(context).commit();
        if (com.tencent.smtt.sdk.TbsDownloader.a(context)) {
            tbsLogReport2 = com.tencent.smtt.sdk.TbsLogReport.getInstance(context);
            sb2 = new java.lang.StringBuilder();
            sb2.append("decouple incrUpdate fail! patch ret=");
            sb2.append(1);
            string = sb2.toString();
            i4 = com.tencent.smtt.sdk.TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_FAIL;
            tbsLogReport2.setInstallErrorCode(i4, string);
            com.tencent.smtt.sdk.QbSdk.setTBSInstallingStatus(false);
        }
        tbsLogReport2 = com.tencent.smtt.sdk.TbsLogReport.getInstance(context);
        sb = new java.lang.StringBuilder();
        sb.append("incrUpdate fail! patch ret=");
        sb.append(1);
        string = sb.toString();
        i4 = com.tencent.smtt.sdk.TbsListener.ErrorCode.INCR_UPDATE_FAIL;
        tbsLogReport2.setInstallErrorCode(i4, string);
        com.tencent.smtt.sdk.QbSdk.setTBSInstallingStatus(false);
    }

    void b(android.content.Context context, boolean z) {
        java.lang.String str;
        java.lang.String str2;
        if (com.tencent.smtt.sdk.QbSdk.b) {
            return;
        }
        if (android.os.Build.VERSION.SDK_INT < 8) {
            com.tencent.smtt.utils.TbsLog.e("TbsInstaller", "android version < 2.1 no need install X5 core", true);
            return;
        }
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "Tbsinstaller installTbsCoreIfNeeded #1 ");
        if (com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(context) && com.tencent.smtt.sdk.k.a(context).b("remove_old_core") == 1 && z) {
            try {
                com.tencent.smtt.utils.f.b(a().q(context));
                com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "thirdAPP success--> delete old core_share Directory");
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
            com.tencent.smtt.sdk.k.a(context).a("remove_old_core", 0);
        }
        if (v(context)) {
            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "Tbsinstaller installTbsCoreIfNeeded #2 ");
            if (a(context, "core_unzip_tmp") && e(context, z)) {
                str = "TbsInstaller";
                str2 = "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromUnzip!!";
            } else if (a(context, "core_share_backup_tmp") && f(context, z)) {
                str = "TbsInstaller";
                str2 = "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromBackup!!";
            } else if (a(context, "core_copy_tmp") && d(context, z)) {
                str = "TbsInstaller";
                str2 = "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromCopy!!";
            } else if (!a(context, "tpatch_tmp") || !c(context, z)) {
                com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, error !!", true);
                return;
            } else {
                str = "TbsInstaller";
                str2 = "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromTpatch!!";
            }
            com.tencent.smtt.utils.TbsLog.i(str, str2, true);
        }
    }

    boolean b(android.content.Context context, int i2) throws java.lang.Throwable {
        if (com.tencent.smtt.sdk.TbsDownloader.getOverSea(context)) {
            return false;
        }
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore targetTbsCoreVer=" + i2);
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore currentProcessId=" + android.os.Process.myPid());
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore currentThreadName=" + java.lang.Thread.currentThread().getName());
        android.content.Context contextD = d(context, i2);
        if (contextD == null) {
            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller--installLocalTbsCore copy from null");
            return false;
        }
        java.lang.Object[] objArr = {contextD, context, java.lang.Integer.valueOf(i2)};
        android.os.Message message = new android.os.Message();
        message.what = 2;
        message.obj = objArr;
        m.sendMessage(message);
        return true;
    }

    public boolean b(android.content.Context context, java.io.File file, int i2) {
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "unzipTbsCoreToThirdAppTmpInThread #1");
        boolean zA = a(context, file, false);
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "unzipTbsCoreToThirdAppTmpInThread result is " + zA);
        if (zA) {
            a().a(context, i2);
        }
        return zA;
    }

    int c(android.content.Context context, java.lang.String str) {
        android.content.pm.PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 0);
        if (packageArchiveInfo != null) {
            return packageArchiveInfo.versionCode;
        }
        return 0;
    }

    java.io.File c(android.content.Context context, android.content.Context context2) {
        java.io.File file = new java.io.File(com.tencent.smtt.sdk.QbSdk.getTbsFolderDir(context2), "core_share_decouple");
        if (file.isDirectory() || ((context != null && com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(context)) || file.mkdir())) {
            return file;
        }
        return null;
    }

    void c(android.content.Context context, int i2) {
        int i3;
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreForThirdPartyApp");
        if (i2 > 0 && (i3 = i(context)) != i2) {
            android.content.Context contextE = com.tencent.smtt.sdk.TbsShareManager.e(context);
            if (contextE != null || com.tencent.smtt.sdk.TbsShareManager.getHostCorePathAppDefined() != null) {
                com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp hostContext != null");
                a(context, contextE);
            } else if (i3 <= 0) {
                com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller--installTbsCoreForThirdPartyApp hostContext == null");
                com.tencent.smtt.sdk.QbSdk.a(context, "TbsInstaller::installTbsCoreForThirdPartyApp forceSysWebViewInner #2");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19 */
    boolean c(android.content.Context context) {
        java.lang.Throwable th;
        java.io.File file = new java.io.File(q(context), "tbs.conf");
        boolean z = false;
        z = 0;
        boolean z2 = 0;
        if (!file.exists()) {
            return false;
        }
        boolean properties = new java.util.Properties();
        java.io.BufferedInputStream bufferedInputStream = null;
        try {
            try {
                java.io.BufferedInputStream bufferedInputStream2 = new java.io.BufferedInputStream(new java.io.FileInputStream(file));
                try {
                    properties.load(bufferedInputStream2);
                    boolean zBooleanValue = java.lang.Boolean.valueOf(properties.getProperty("tbs_local_installation", "false")).booleanValue();
                    if (zBooleanValue) {
                        try {
                            if (java.lang.System.currentTimeMillis() - file.lastModified() > 259200000) {
                                z2 = 1;
                            }
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            z = zBooleanValue ? 1 : 0;
                            properties = z;
                            bufferedInputStream = bufferedInputStream2;
                            try {
                                th.printStackTrace();
                                if (bufferedInputStream != null) {
                                    bufferedInputStream.close();
                                    properties = properties;
                                }
                                return properties;
                            } catch (java.lang.Throwable th3) {
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (java.io.IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                                throw th3;
                            }
                        }
                    }
                    com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TBS_LOCAL_INSTALLATION is:" + zBooleanValue + " expired=" + z2);
                    boolean z3 = (zBooleanValue ? 1 : 0) & ((z2 ^ 1) == true ? 1 : 0);
                    bufferedInputStream2.close();
                    properties = z3;
                } catch (java.lang.Throwable th4) {
                    th = th4;
                }
            } catch (java.io.IOException e2) {
                e2.printStackTrace();
            }
        } catch (java.lang.Throwable th5) {
            th = th5;
            properties = 0;
        }
        return properties;
    }

    public android.content.Context d(android.content.Context context, int i2) throws java.lang.Throwable {
        android.content.Context contextB;
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreHostContext tbsCoreTargetVer=" + i2);
        if (i2 <= 0) {
            return null;
        }
        java.lang.String[] coreProviderAppList = com.tencent.smtt.sdk.TbsShareManager.getCoreProviderAppList();
        for (int i3 = 0; i3 < coreProviderAppList.length; i3++) {
            if (!context.getPackageName().equalsIgnoreCase(coreProviderAppList[i3]) && e(context, coreProviderAppList[i3]) && (contextB = b(context, coreProviderAppList[i3])) != null) {
                if (f(contextB)) {
                    int i4 = i(contextB);
                    com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-getTbsCoreHostContext hostTbsCoreVer=" + i4);
                    if (i4 != 0 && i4 == i2) {
                        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-getTbsCoreHostContext targetApp=" + coreProviderAppList[i3]);
                        return contextB;
                    }
                } else {
                    com.tencent.smtt.utils.TbsLog.e("TbsInstaller", "TbsInstaller--getTbsCoreHostContext " + coreProviderAppList[i3] + " illegal signature go on next");
                }
            }
        }
        return null;
    }

    public java.lang.String d(android.content.Context context, java.lang.String str) throws java.lang.Throwable {
        java.io.BufferedInputStream bufferedInputStream;
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            java.io.File file = new java.io.File(q(context), "tbs.conf");
            if (!file.exists()) {
                return null;
            }
            java.util.Properties properties = new java.util.Properties();
            bufferedInputStream = new java.io.BufferedInputStream(new java.io.FileInputStream(file));
            try {
                properties.load(bufferedInputStream);
                bufferedInputStream.close();
                java.lang.String property = properties.getProperty(str);
                try {
                    bufferedInputStream.close();
                } catch (java.io.IOException unused) {
                }
                return property;
            } catch (java.lang.Exception unused2) {
            } catch (java.lang.Throwable th) {
                th = th;
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (java.io.IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (java.lang.Exception unused4) {
            bufferedInputStream = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            bufferedInputStream = null;
        }
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (java.io.IOException unused5) {
            }
        }
        return null;
    }

    public void d(android.content.Context context) throws java.io.IOException {
        java.io.BufferedInputStream bufferedInputStream;
        try {
            java.io.File file = new java.io.File(q(context), "tbs.conf");
            java.util.Properties properties = new java.util.Properties();
            java.io.BufferedOutputStream bufferedOutputStream = null;
            try {
                bufferedInputStream = new java.io.BufferedInputStream(new java.io.FileInputStream(file));
                try {
                    properties.load(bufferedInputStream);
                    java.io.BufferedOutputStream bufferedOutputStream2 = new java.io.BufferedOutputStream(new java.io.FileOutputStream(file));
                    try {
                        properties.setProperty("tbs_local_installation", "false");
                        properties.store(bufferedOutputStream2, (java.lang.String) null);
                        try {
                            bufferedOutputStream2.close();
                        } catch (java.io.IOException unused) {
                        }
                    } catch (java.lang.Throwable unused2) {
                        bufferedOutputStream = bufferedOutputStream2;
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (java.io.IOException unused3) {
                            }
                        }
                        if (bufferedInputStream == null) {
                            return;
                        }
                    }
                } catch (java.lang.Throwable unused4) {
                }
            } catch (java.lang.Throwable unused5) {
                bufferedInputStream = null;
            }
            bufferedInputStream.close();
        } catch (java.lang.Throwable unused6) {
        }
    }

    int e(android.content.Context context, int i2) {
        return a(f(context, i2));
    }

    public boolean e(android.content.Context context) {
        try {
            java.io.File file = new java.io.File(com.tencent.smtt.utils.f.a(context, 4), com.tencent.smtt.sdk.TbsDownloader.getBackupFileName(true));
            java.io.File fileF = a().f(context, 2);
            com.tencent.smtt.utils.f.a(fileF);
            com.tencent.smtt.utils.f.a(fileF, true);
            com.tencent.smtt.utils.f.a(file, fileF);
            for (java.lang.String str : fileF.list()) {
                java.io.File file2 = new java.io.File(fileF, str);
                if (file2.getName().endsWith(".dex")) {
                    file2.delete();
                }
            }
            i(context, 2);
            return true;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    java.io.File f(android.content.Context context, int i2) {
        return a(context, i2, true);
    }

    boolean f(android.content.Context context) {
        if (com.tencent.smtt.sdk.TbsShareManager.getHostCorePathAppDefined() != null) {
            return true;
        }
        try {
            android.content.pm.Signature signature = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0];
            if (context.getPackageName().equals(com.tencent.smtt.sdk.TbsConfig.APP_QB)) {
                if (!signature.toCharsString().equals("[REDACTED_HEX_CONSTANT]")) {
                    return false;
                }
            } else if (context.getPackageName().equals("com.tencent.mm")) {
                if (!signature.toCharsString().equals("[REDACTED_HEX_CONSTANT]")) {
                    return false;
                }
            } else if (context.getPackageName().equals("com.tencent.mobileqq")) {
                if (!signature.toCharsString().equals("[REDACTED_HEX_CONSTANT]")) {
                    return false;
                }
            } else if (context.getPackageName().equals(com.tencent.smtt.sdk.TbsConfig.APP_DEMO)) {
                if (!signature.toCharsString().equals("[REDACTED_HEX_CONSTANT]")) {
                    return false;
                }
            } else if (context.getPackageName().equals("com.qzone")) {
                if (!signature.toCharsString().equals("[REDACTED_HEX_CONSTANT]")) {
                    return false;
                }
            } else if (context.getPackageName().equals("com.tencent.qqpimsecure") && !signature.toCharsString().equals("[REDACTED_HEX_CONSTANT]")) {
                return false;
            }
            return true;
        } catch (java.lang.Exception unused) {
            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore getPackageInfo fail");
            return false;
        }
    }

    public void g(android.content.Context context) {
        boolean tbsCoreLoadRenameFileLockEnable;
        java.nio.channels.FileLock fileLock;
        try {
            tbsCoreLoadRenameFileLockEnable = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance().getTbsCoreLoadRenameFileLockEnable();
        } catch (java.lang.Throwable unused) {
            tbsCoreLoadRenameFileLockEnable = true;
        }
        if (tbsCoreLoadRenameFileLockEnable && (fileLock = l) != null) {
            com.tencent.smtt.utils.f.a(context, fileLock);
        }
    }

    boolean g(android.content.Context context, int i2) {
        java.io.File fileQ;
        java.lang.String str;
        java.lang.String str2;
        try {
            boolean zIsThirdPartyApp = com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(context);
            if (!zIsThirdPartyApp) {
                fileQ = q(context);
            } else {
                if (!com.tencent.smtt.sdk.TbsShareManager.j(context)) {
                    com.tencent.smtt.utils.TbsLog.e("TbsInstaller", "321");
                    return false;
                }
                fileQ = new java.io.File(com.tencent.smtt.sdk.TbsShareManager.c(context));
                if (fileQ.getAbsolutePath().contains(com.tencent.smtt.sdk.TbsConfig.APP_DEMO)) {
                    return true;
                }
            }
            if (fileQ != null) {
                for (java.lang.Long[] lArr : n) {
                    if (i2 == lArr[0].intValue()) {
                        java.io.File file = new java.io.File(fileQ, "libmttwebview.so");
                        if (file.exists() && file.length() == lArr[1].longValue()) {
                            com.tencent.smtt.utils.TbsLog.d("TbsInstaller", "check so success: " + i2 + "; file: " + file);
                            break;
                        }
                        if (!zIsThirdPartyApp) {
                            com.tencent.smtt.utils.f.b(com.tencent.smtt.sdk.QbSdk.getTbsFolderDir(context));
                        }
                        f935a.set(0);
                        str = "TbsInstaller";
                        str2 = "322";
                    }
                }
                return true;
            }
            str = "TbsInstaller";
            str2 = "323";
            com.tencent.smtt.utils.TbsLog.e(str, str2);
            return false;
        } catch (java.lang.Throwable th) {
            com.tencent.smtt.utils.TbsLog.e("TbsInstaller", "ISTBSCORELEGAL exception getMessage is " + th.getMessage());
            com.tencent.smtt.utils.TbsLog.e("TbsInstaller", "ISTBSCORELEGAL exception getCause is " + th.getCause());
            return false;
        }
    }

    int h(android.content.Context context) throws java.lang.Throwable {
        java.io.BufferedInputStream bufferedInputStream = null;
        try {
            java.io.File file = new java.io.File(p(context), "tbs.conf");
            if (!file.exists()) {
                return 0;
            }
            java.util.Properties properties = new java.util.Properties();
            java.io.BufferedInputStream bufferedInputStream2 = new java.io.BufferedInputStream(new java.io.FileInputStream(file));
            try {
                properties.load(bufferedInputStream2);
                bufferedInputStream2.close();
                java.lang.String property = properties.getProperty("tbs_core_version");
                if (property == null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (java.io.IOException unused) {
                    }
                    return 0;
                }
                int i2 = java.lang.Integer.parseInt(property);
                try {
                    bufferedInputStream2.close();
                } catch (java.io.IOException unused2) {
                }
                return i2;
            } catch (java.lang.Exception unused3) {
                bufferedInputStream = bufferedInputStream2;
            } catch (java.lang.Throwable th) {
                th = th;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (java.io.IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (java.lang.Exception unused5) {
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (java.io.IOException unused6) {
            }
        }
        return 0;
    }

    int i(android.content.Context context) throws java.lang.Throwable {
        java.io.BufferedInputStream bufferedInputStream = null;
        try {
            try {
                java.io.File file = new java.io.File(q(context), "tbs.conf");
                if (!file.exists()) {
                    return 0;
                }
                java.util.Properties properties = new java.util.Properties();
                java.io.BufferedInputStream bufferedInputStream2 = new java.io.BufferedInputStream(new java.io.FileInputStream(file));
                try {
                    properties.load(bufferedInputStream2);
                    bufferedInputStream2.close();
                    java.lang.String property = properties.getProperty("tbs_core_version");
                    if (property == null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (java.io.IOException e) {
                            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e.toString());
                        }
                        return 0;
                    }
                    int i2 = java.lang.Integer.parseInt(property);
                    if (o == 0) {
                        o = i2;
                    }
                    try {
                        bufferedInputStream2.close();
                    } catch (java.io.IOException e2) {
                        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e2.toString());
                    }
                    return i2;
                } catch (java.lang.Exception e3) {
                    e = e3;
                    bufferedInputStream = bufferedInputStream2;
                } catch (java.lang.Throwable th) {
                    th = th;
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (java.io.IOException e4) {
                            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e4.toString());
                        }
                    }
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.lang.Exception e5) {
            e = e5;
        }
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock Exception=" + e.toString());
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (java.io.IOException e6) {
                com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e6.toString());
            }
        }
        return 0;
    }

    int j(android.content.Context context) {
        int i2 = o;
        return i2 != 0 ? i2 : i(context);
    }

    void k(android.content.Context context) {
        if (o != 0) {
            return;
        }
        o = i(context);
    }

    boolean l(android.content.Context context) {
        return new java.io.File(q(context), "tbs.conf").exists();
    }

    int m(android.content.Context context) throws java.lang.Throwable {
        if (!t(context)) {
            return -1;
        }
        boolean zTryLock = i.tryLock();
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerWithLock locked=" + zTryLock);
        if (!zTryLock) {
            b();
            return 0;
        }
        java.io.BufferedInputStream bufferedInputStream = null;
        try {
            try {
                java.io.File file = new java.io.File(q(context), "tbs.conf");
                if (!file.exists()) {
                    try {
                        if (i.isHeldByCurrentThread()) {
                            i.unlock();
                        }
                    } catch (java.lang.Throwable th) {
                        com.tencent.smtt.utils.TbsLog.e("TbsInstaller", "TbsRenameLock.unlock exception: " + th);
                    }
                    b();
                    return 0;
                }
                java.util.Properties properties = new java.util.Properties();
                java.io.BufferedInputStream bufferedInputStream2 = new java.io.BufferedInputStream(new java.io.FileInputStream(file));
                try {
                    properties.load(bufferedInputStream2);
                    bufferedInputStream2.close();
                    java.lang.String property = properties.getProperty("tbs_core_version");
                    if (property == null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (java.io.IOException e) {
                            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerWithLock IOException=" + e.toString());
                        }
                        try {
                            if (i.isHeldByCurrentThread()) {
                                i.unlock();
                            }
                        } catch (java.lang.Throwable th2) {
                            com.tencent.smtt.utils.TbsLog.e("TbsInstaller", "TbsRenameLock.unlock exception: " + th2);
                        }
                        b();
                        return 0;
                    }
                    f935a.set(java.lang.Integer.valueOf(java.lang.Integer.parseInt(property)));
                    int iIntValue = ((java.lang.Integer) f935a.get()).intValue();
                    try {
                        bufferedInputStream2.close();
                    } catch (java.io.IOException e2) {
                        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerWithLock IOException=" + e2.toString());
                    }
                    try {
                        if (i.isHeldByCurrentThread()) {
                            i.unlock();
                        }
                    } catch (java.lang.Throwable th3) {
                        com.tencent.smtt.utils.TbsLog.e("TbsInstaller", "TbsRenameLock.unlock exception: " + th3);
                    }
                    b();
                    return iIntValue;
                } catch (java.lang.Exception e3) {
                    e = e3;
                    bufferedInputStream = bufferedInputStream2;
                } catch (java.lang.Throwable th4) {
                    th = th4;
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (java.io.IOException e4) {
                            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerWithLock IOException=" + e4.toString());
                        }
                    }
                    try {
                        if (i.isHeldByCurrentThread()) {
                            i.unlock();
                        }
                    } catch (java.lang.Throwable th5) {
                        com.tencent.smtt.utils.TbsLog.e("TbsInstaller", "TbsRenameLock.unlock exception: " + th5);
                    }
                    b();
                    throw th;
                }
            } catch (java.lang.Exception e5) {
                e = e5;
            }
        } catch (java.lang.Throwable th6) {
            th = th6;
        }
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerWithLock Exception=" + e.toString());
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (java.io.IOException e6) {
                com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerWithLock IOException=" + e6.toString());
            }
        }
        try {
            if (i.isHeldByCurrentThread()) {
                i.unlock();
            }
        } catch (java.lang.Throwable th7) {
            com.tencent.smtt.utils.TbsLog.e("TbsInstaller", "TbsRenameLock.unlock exception: " + th7);
        }
        b();
        return 0;
    }

    public boolean n(android.content.Context context) {
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller--coreShareCopyToDecouple #0");
        java.io.File fileQ = q(context);
        java.io.File fileP = p(context);
        try {
            com.tencent.smtt.utils.f.a(fileP, true);
            com.tencent.smtt.utils.f.a(fileQ, fileP, new java.io.FileFilter() { // from class: com.tencent.smtt.sdk.m.5
                @Override // java.io.FileFilter
                public boolean accept(java.io.File file) {
                    return (file.getName().endsWith(".dex") || file.getName().endsWith(".jar_is_first_load_dex_flag_file")) ? false : true;
                }
            });
            com.tencent.smtt.sdk.TbsShareManager.b(context);
            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller--coreShareCopyToDecouple success!!!");
            return true;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    void o(android.content.Context context) {
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller--cleanStatusAndTmpDir");
        com.tencent.smtt.sdk.k.a(context).a(0);
        com.tencent.smtt.sdk.k.a(context).b(0);
        com.tencent.smtt.sdk.k.a(context).d(0);
        com.tencent.smtt.sdk.k.a(context).a("incrupdate_retry_num", 0);
        if (com.tencent.smtt.sdk.TbsDownloader.a(context)) {
            return;
        }
        com.tencent.smtt.sdk.k.a(context).c(0, -1);
        com.tencent.smtt.sdk.k.a(context).a("");
        com.tencent.smtt.sdk.k.a(context).a("copy_retry_num", 0);
        com.tencent.smtt.sdk.k.a(context).c(-1);
        com.tencent.smtt.sdk.k.a(context).a(0, -1);
        com.tencent.smtt.utils.f.a(f(context, 0), true);
        com.tencent.smtt.utils.f.a(f(context, 1), true);
    }

    java.io.File p(android.content.Context context) {
        java.io.File file = new java.io.File(com.tencent.smtt.sdk.QbSdk.getTbsFolderDir(context), "core_share_decouple");
        if (file.isDirectory() || file.mkdir()) {
            return file;
        }
        return null;
    }

    java.io.File q(android.content.Context context) {
        return b((android.content.Context) null, context);
    }

    java.io.File r(android.content.Context context) {
        java.io.File file = new java.io.File(com.tencent.smtt.sdk.QbSdk.getTbsFolderDir(context), com.tencent.ysdk.shell.module.ModuleManager.YSDK_MODULE_NAME_SHARE);
        if (file.isDirectory() || file.mkdir()) {
            return file;
        }
        return null;
    }

    synchronized boolean t(android.content.Context context) {
        if (this.e > 0) {
            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "getTbsInstallingFileLock success,is cached= true");
            this.e++;
            return true;
        }
        java.io.FileOutputStream fileOutputStreamB = com.tencent.smtt.utils.f.b(context, true, "tbslock.txt");
        this.g = fileOutputStreamB;
        if (fileOutputStreamB == null) {
            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "getTbsInstallingFileLock get install fos failed");
            return false;
        }
        java.nio.channels.FileLock fileLockA = com.tencent.smtt.utils.f.a(context, fileOutputStreamB);
        this.f = fileLockA;
        if (fileLockA == null) {
            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "getTbsInstallingFileLock tbsFileLockFileLock == null");
            return false;
        }
        com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "getTbsInstallingFileLock success,is cached= false");
        this.e++;
        return true;
    }
}
