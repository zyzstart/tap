package com.tencent.bugly.opengame.crashreport.biz;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.content.Context f332a;
    private long b;
    private int c;
    private boolean d;

    /* JADX INFO: renamed from: com.tencent.bugly.opengame.crashreport.biz.a$2, reason: invalid class name */
    final class AnonymousClass2 implements java.lang.Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.tencent.bugly.opengame.crashreport.biz.a.this.c();
            } catch (java.lang.Throwable th) {
                com.tencent.bugly.opengame.proguard.x.a(th);
            }
        }
    }

    /* JADX INFO: renamed from: com.tencent.bugly.opengame.crashreport.biz.a$a, reason: collision with other inner class name */
    class RunnableC0022a implements java.lang.Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f335a;
        private com.tencent.bugly.opengame.crashreport.biz.UserInfoBean b;

        public RunnableC0022a(com.tencent.bugly.opengame.crashreport.biz.UserInfoBean userInfoBean, boolean z) {
            this.b = userInfoBean;
            this.f335a = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.tencent.bugly.opengame.crashreport.common.info.a aVarB;
            try {
                if (this.b != null) {
                    com.tencent.bugly.opengame.crashreport.biz.UserInfoBean userInfoBean = this.b;
                    if (userInfoBean != null && (aVarB = com.tencent.bugly.opengame.crashreport.common.info.a.b()) != null) {
                        userInfoBean.j = aVarB.e();
                    }
                    com.tencent.bugly.opengame.proguard.x.c("[UserInfo] Record user info.", new java.lang.Object[0]);
                    com.tencent.bugly.opengame.crashreport.biz.a.a(com.tencent.bugly.opengame.crashreport.biz.a.this, this.b, false);
                }
                if (this.f335a) {
                    com.tencent.bugly.opengame.crashreport.biz.a aVar = com.tencent.bugly.opengame.crashreport.biz.a.this;
                    com.tencent.bugly.opengame.proguard.w wVarA = com.tencent.bugly.opengame.proguard.w.a();
                    if (wVarA != null) {
                        wVarA.a(aVar.new AnonymousClass2());
                    }
                }
            } catch (java.lang.Throwable th) {
                if (com.tencent.bugly.opengame.proguard.x.a(th)) {
                    return;
                }
                th.printStackTrace();
            }
        }
    }

    class b implements java.lang.Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            if (jCurrentTimeMillis < com.tencent.bugly.opengame.crashreport.biz.a.this.b) {
                com.tencent.bugly.opengame.proguard.w.a().a(com.tencent.bugly.opengame.crashreport.biz.a.this.new b(), (com.tencent.bugly.opengame.crashreport.biz.a.this.b - jCurrentTimeMillis) + 5000);
            } else {
                com.tencent.bugly.opengame.crashreport.biz.a.this.a(3, false, 0L);
                com.tencent.bugly.opengame.crashreport.biz.a.this.a();
            }
        }
    }

    class c implements java.lang.Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f337a;

        public c(long j) {
            this.f337a = 21600000L;
            this.f337a = j;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.tencent.bugly.opengame.crashreport.biz.a aVar = com.tencent.bugly.opengame.crashreport.biz.a.this;
            com.tencent.bugly.opengame.proguard.w wVarA = com.tencent.bugly.opengame.proguard.w.a();
            if (wVarA != null) {
                wVarA.a(aVar.new AnonymousClass2());
            }
            com.tencent.bugly.opengame.crashreport.biz.a aVar2 = com.tencent.bugly.opengame.crashreport.biz.a.this;
            long j = this.f337a;
            com.tencent.bugly.opengame.proguard.w.a().a(aVar2.new c(j), j);
        }
    }

    public a(android.content.Context context, boolean z) {
        this.d = true;
        this.f332a = context;
        this.d = z;
    }

    private static android.content.ContentValues a(com.tencent.bugly.opengame.crashreport.biz.UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        try {
            android.content.ContentValues contentValues = new android.content.ContentValues();
            if (userInfoBean.f331a > 0) {
                contentValues.put("_id", java.lang.Long.valueOf(userInfoBean.f331a));
            }
            contentValues.put("_tm", java.lang.Long.valueOf(userInfoBean.e));
            contentValues.put("_ut", java.lang.Long.valueOf(userInfoBean.f));
            contentValues.put("_tp", java.lang.Integer.valueOf(userInfoBean.b));
            contentValues.put("_pc", userInfoBean.c);
            contentValues.put("_dt", com.tencent.bugly.opengame.proguard.z.a(userInfoBean));
            return contentValues;
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.opengame.proguard.x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static com.tencent.bugly.opengame.crashreport.biz.UserInfoBean a(android.database.Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j = cursor.getLong(cursor.getColumnIndex("_id"));
            com.tencent.bugly.opengame.crashreport.biz.UserInfoBean userInfoBean = (com.tencent.bugly.opengame.crashreport.biz.UserInfoBean) com.tencent.bugly.opengame.proguard.z.a(blob, com.tencent.bugly.opengame.crashreport.biz.UserInfoBean.CREATOR);
            if (userInfoBean != null) {
                userInfoBean.f331a = j;
            }
            return userInfoBean;
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.opengame.proguard.x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    static /* synthetic */ void a(com.tencent.bugly.opengame.crashreport.biz.a aVar, com.tencent.bugly.opengame.crashreport.biz.UserInfoBean userInfoBean, boolean z) {
        java.util.List listA;
        if (userInfoBean != null) {
            if (!z && userInfoBean.b != 1 && (listA = aVar.a(com.tencent.bugly.opengame.crashreport.common.info.a.a(aVar.f332a).d)) != null && listA.size() >= 20) {
                com.tencent.bugly.opengame.proguard.x.a("[UserInfo] There are too many user info in local: %d", java.lang.Integer.valueOf(listA.size()));
                return;
            }
            long jA = com.tencent.bugly.opengame.proguard.p.a().a("t_ui", a(userInfoBean), (com.tencent.bugly.opengame.proguard.o) null, true);
            if (jA >= 0) {
                com.tencent.bugly.opengame.proguard.x.c("[Database] insert %s success with ID: %d", "t_ui", java.lang.Long.valueOf(jA));
                userInfoBean.f331a = jA;
            }
        }
    }

    private static void a(java.util.List list) {
        if (list == null || list.size() == 0) {
            return;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = 0; i < list.size() && i < 50; i++) {
            com.tencent.bugly.opengame.crashreport.biz.UserInfoBean userInfoBean = (com.tencent.bugly.opengame.crashreport.biz.UserInfoBean) list.get(i);
            sb.append(" or _id");
            sb.append(" = ");
            sb.append(userInfoBean.f331a);
        }
        java.lang.String string = sb.toString();
        if (string.length() > 0) {
            string = string.substring(4);
        }
        java.lang.String str = string;
        sb.setLength(0);
        try {
            com.tencent.bugly.opengame.proguard.x.c("[Database] deleted %s data %d", "t_ui", java.lang.Integer.valueOf(com.tencent.bugly.opengame.proguard.p.a().a("t_ui", str, (java.lang.String[]) null, (com.tencent.bugly.opengame.proguard.o) null, true)));
        } catch (java.lang.Throwable th) {
            if (com.tencent.bugly.opengame.proguard.x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:101:0x0176  */
    /* JADX WARN: Code duplicated, block: B:102:0x0178  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ee A[Catch: all -> 0x0187, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:11:0x000f, B:15:0x0017, B:17:0x001d, B:21:0x0027, B:23:0x003c, B:26:0x0045, B:28:0x004c, B:29:0x004f, B:31:0x0055, B:33:0x0069, B:34:0x0079, B:38:0x0081, B:39:0x008b, B:40:0x0090, B:42:0x0096, B:44:0x00a4, B:46:0x00b1, B:47:0x00b4, B:49:0x00c2, B:55:0x00cc, B:58:0x00d3, B:61:0x00e8, B:63:0x00ee, B:65:0x00f3, B:68:0x00fb, B:72:0x0113, B:74:0x0119, B:77:0x0122, B:79:0x0128, B:82:0x0131, B:86:0x013a, B:88:0x0142, B:91:0x014b, B:93:0x015c, B:95:0x0161, B:97:0x0166, B:99:0x016b, B:103:0x0179, B:98:0x0169, B:94:0x015f, B:106:0x017e, B:59:0x00e2), top: B:113:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x0110  */
    /* JADX WARN: Code duplicated, block: B:71:0x0112  */
    /* JADX WARN: Code duplicated, block: B:74:0x0119 A[Catch: all -> 0x0187, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:11:0x000f, B:15:0x0017, B:17:0x001d, B:21:0x0027, B:23:0x003c, B:26:0x0045, B:28:0x004c, B:29:0x004f, B:31:0x0055, B:33:0x0069, B:34:0x0079, B:38:0x0081, B:39:0x008b, B:40:0x0090, B:42:0x0096, B:44:0x00a4, B:46:0x00b1, B:47:0x00b4, B:49:0x00c2, B:55:0x00cc, B:58:0x00d3, B:61:0x00e8, B:63:0x00ee, B:65:0x00f3, B:68:0x00fb, B:72:0x0113, B:74:0x0119, B:77:0x0122, B:79:0x0128, B:82:0x0131, B:86:0x013a, B:88:0x0142, B:91:0x014b, B:93:0x015c, B:95:0x0161, B:97:0x0166, B:99:0x016b, B:103:0x0179, B:98:0x0169, B:94:0x015f, B:106:0x017e, B:59:0x00e2), top: B:113:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x0122 A[Catch: all -> 0x0187, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:11:0x000f, B:15:0x0017, B:17:0x001d, B:21:0x0027, B:23:0x003c, B:26:0x0045, B:28:0x004c, B:29:0x004f, B:31:0x0055, B:33:0x0069, B:34:0x0079, B:38:0x0081, B:39:0x008b, B:40:0x0090, B:42:0x0096, B:44:0x00a4, B:46:0x00b1, B:47:0x00b4, B:49:0x00c2, B:55:0x00cc, B:58:0x00d3, B:61:0x00e8, B:63:0x00ee, B:65:0x00f3, B:68:0x00fb, B:72:0x0113, B:74:0x0119, B:77:0x0122, B:79:0x0128, B:82:0x0131, B:86:0x013a, B:88:0x0142, B:91:0x014b, B:93:0x015c, B:95:0x0161, B:97:0x0166, B:99:0x016b, B:103:0x0179, B:98:0x0169, B:94:0x015f, B:106:0x017e, B:59:0x00e2), top: B:113:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x0128 A[Catch: all -> 0x0187, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:11:0x000f, B:15:0x0017, B:17:0x001d, B:21:0x0027, B:23:0x003c, B:26:0x0045, B:28:0x004c, B:29:0x004f, B:31:0x0055, B:33:0x0069, B:34:0x0079, B:38:0x0081, B:39:0x008b, B:40:0x0090, B:42:0x0096, B:44:0x00a4, B:46:0x00b1, B:47:0x00b4, B:49:0x00c2, B:55:0x00cc, B:58:0x00d3, B:61:0x00e8, B:63:0x00ee, B:65:0x00f3, B:68:0x00fb, B:72:0x0113, B:74:0x0119, B:77:0x0122, B:79:0x0128, B:82:0x0131, B:86:0x013a, B:88:0x0142, B:91:0x014b, B:93:0x015c, B:95:0x0161, B:97:0x0166, B:99:0x016b, B:103:0x0179, B:98:0x0169, B:94:0x015f, B:106:0x017e, B:59:0x00e2), top: B:113:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x0131 A[Catch: all -> 0x0187, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:11:0x000f, B:15:0x0017, B:17:0x001d, B:21:0x0027, B:23:0x003c, B:26:0x0045, B:28:0x004c, B:29:0x004f, B:31:0x0055, B:33:0x0069, B:34:0x0079, B:38:0x0081, B:39:0x008b, B:40:0x0090, B:42:0x0096, B:44:0x00a4, B:46:0x00b1, B:47:0x00b4, B:49:0x00c2, B:55:0x00cc, B:58:0x00d3, B:61:0x00e8, B:63:0x00ee, B:65:0x00f3, B:68:0x00fb, B:72:0x0113, B:74:0x0119, B:77:0x0122, B:79:0x0128, B:82:0x0131, B:86:0x013a, B:88:0x0142, B:91:0x014b, B:93:0x015c, B:95:0x0161, B:97:0x0166, B:99:0x016b, B:103:0x0179, B:98:0x0169, B:94:0x015f, B:106:0x017e, B:59:0x00e2), top: B:113:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x0135  */
    /* JADX WARN: Code duplicated, block: B:85:0x0138  */
    /* JADX WARN: Code duplicated, block: B:88:0x0142 A[Catch: all -> 0x0187, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:11:0x000f, B:15:0x0017, B:17:0x001d, B:21:0x0027, B:23:0x003c, B:26:0x0045, B:28:0x004c, B:29:0x004f, B:31:0x0055, B:33:0x0069, B:34:0x0079, B:38:0x0081, B:39:0x008b, B:40:0x0090, B:42:0x0096, B:44:0x00a4, B:46:0x00b1, B:47:0x00b4, B:49:0x00c2, B:55:0x00cc, B:58:0x00d3, B:61:0x00e8, B:63:0x00ee, B:65:0x00f3, B:68:0x00fb, B:72:0x0113, B:74:0x0119, B:77:0x0122, B:79:0x0128, B:82:0x0131, B:86:0x013a, B:88:0x0142, B:91:0x014b, B:93:0x015c, B:95:0x0161, B:97:0x0166, B:99:0x016b, B:103:0x0179, B:98:0x0169, B:94:0x015f, B:106:0x017e, B:59:0x00e2), top: B:113:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x014b A[Catch: all -> 0x0187, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:11:0x000f, B:15:0x0017, B:17:0x001d, B:21:0x0027, B:23:0x003c, B:26:0x0045, B:28:0x004c, B:29:0x004f, B:31:0x0055, B:33:0x0069, B:34:0x0079, B:38:0x0081, B:39:0x008b, B:40:0x0090, B:42:0x0096, B:44:0x00a4, B:46:0x00b1, B:47:0x00b4, B:49:0x00c2, B:55:0x00cc, B:58:0x00d3, B:61:0x00e8, B:63:0x00ee, B:65:0x00f3, B:68:0x00fb, B:72:0x0113, B:74:0x0119, B:77:0x0122, B:79:0x0128, B:82:0x0131, B:86:0x013a, B:88:0x0142, B:91:0x014b, B:93:0x015c, B:95:0x0161, B:97:0x0166, B:99:0x016b, B:103:0x0179, B:98:0x0169, B:94:0x015f, B:106:0x017e, B:59:0x00e2), top: B:113:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x015c A[Catch: all -> 0x0187, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:11:0x000f, B:15:0x0017, B:17:0x001d, B:21:0x0027, B:23:0x003c, B:26:0x0045, B:28:0x004c, B:29:0x004f, B:31:0x0055, B:33:0x0069, B:34:0x0079, B:38:0x0081, B:39:0x008b, B:40:0x0090, B:42:0x0096, B:44:0x00a4, B:46:0x00b1, B:47:0x00b4, B:49:0x00c2, B:55:0x00cc, B:58:0x00d3, B:61:0x00e8, B:63:0x00ee, B:65:0x00f3, B:68:0x00fb, B:72:0x0113, B:74:0x0119, B:77:0x0122, B:79:0x0128, B:82:0x0131, B:86:0x013a, B:88:0x0142, B:91:0x014b, B:93:0x015c, B:95:0x0161, B:97:0x0166, B:99:0x016b, B:103:0x0179, B:98:0x0169, B:94:0x015f, B:106:0x017e, B:59:0x00e2), top: B:113:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x015f A[Catch: all -> 0x0187, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:11:0x000f, B:15:0x0017, B:17:0x001d, B:21:0x0027, B:23:0x003c, B:26:0x0045, B:28:0x004c, B:29:0x004f, B:31:0x0055, B:33:0x0069, B:34:0x0079, B:38:0x0081, B:39:0x008b, B:40:0x0090, B:42:0x0096, B:44:0x00a4, B:46:0x00b1, B:47:0x00b4, B:49:0x00c2, B:55:0x00cc, B:58:0x00d3, B:61:0x00e8, B:63:0x00ee, B:65:0x00f3, B:68:0x00fb, B:72:0x0113, B:74:0x0119, B:77:0x0122, B:79:0x0128, B:82:0x0131, B:86:0x013a, B:88:0x0142, B:91:0x014b, B:93:0x015c, B:95:0x0161, B:97:0x0166, B:99:0x016b, B:103:0x0179, B:98:0x0169, B:94:0x015f, B:106:0x017e, B:59:0x00e2), top: B:113:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:97:0x0166 A[Catch: all -> 0x0187, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:11:0x000f, B:15:0x0017, B:17:0x001d, B:21:0x0027, B:23:0x003c, B:26:0x0045, B:28:0x004c, B:29:0x004f, B:31:0x0055, B:33:0x0069, B:34:0x0079, B:38:0x0081, B:39:0x008b, B:40:0x0090, B:42:0x0096, B:44:0x00a4, B:46:0x00b1, B:47:0x00b4, B:49:0x00c2, B:55:0x00cc, B:58:0x00d3, B:61:0x00e8, B:63:0x00ee, B:65:0x00f3, B:68:0x00fb, B:72:0x0113, B:74:0x0119, B:77:0x0122, B:79:0x0128, B:82:0x0131, B:86:0x013a, B:88:0x0142, B:91:0x014b, B:93:0x015c, B:95:0x0161, B:97:0x0166, B:99:0x016b, B:103:0x0179, B:98:0x0169, B:94:0x015f, B:106:0x017e, B:59:0x00e2), top: B:113:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x0169 A[Catch: all -> 0x0187, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:11:0x000f, B:15:0x0017, B:17:0x001d, B:21:0x0027, B:23:0x003c, B:26:0x0045, B:28:0x004c, B:29:0x004f, B:31:0x0055, B:33:0x0069, B:34:0x0079, B:38:0x0081, B:39:0x008b, B:40:0x0090, B:42:0x0096, B:44:0x00a4, B:46:0x00b1, B:47:0x00b4, B:49:0x00c2, B:55:0x00cc, B:58:0x00d3, B:61:0x00e8, B:63:0x00ee, B:65:0x00f3, B:68:0x00fb, B:72:0x0113, B:74:0x0119, B:77:0x0122, B:79:0x0128, B:82:0x0131, B:86:0x013a, B:88:0x0142, B:91:0x014b, B:93:0x015c, B:95:0x0161, B:97:0x0166, B:99:0x016b, B:103:0x0179, B:98:0x0169, B:94:0x015f, B:106:0x017e, B:59:0x00e2), top: B:113:0x0001 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void c() {
        boolean z;
        int i;
        com.tencent.bugly.opengame.proguard.au auVarA;
        byte[] bArrA;
        int i2;
        com.tencent.bugly.opengame.proguard.ap apVarA;
        com.tencent.bugly.opengame.crashreport.common.strategy.StrategyBean strategyBeanC;
        java.lang.String str;
        java.lang.String str2;
        boolean z2;
        int i3;
        if (this.d) {
            com.tencent.bugly.opengame.proguard.u uVarA = com.tencent.bugly.opengame.proguard.u.a();
            if (uVarA == null) {
                return;
            }
            com.tencent.bugly.opengame.crashreport.common.strategy.a aVarA = com.tencent.bugly.opengame.crashreport.common.strategy.a.a();
            if (aVarA == null) {
                return;
            }
            if (!aVarA.b() || uVarA.b(1001)) {
                java.lang.String str3 = com.tencent.bugly.opengame.crashreport.common.info.a.a(this.f332a).d;
                java.util.ArrayList arrayList = new java.util.ArrayList();
                final java.util.List listA = a(str3);
                if (listA != null) {
                    int size = listA.size() - 20;
                    if (size > 0) {
                        int i4 = 0;
                        while (i4 < listA.size() - 1) {
                            int i5 = i4 + 1;
                            for (int i6 = i5; i6 < listA.size(); i6++) {
                                if (((com.tencent.bugly.opengame.crashreport.biz.UserInfoBean) listA.get(i4)).e > ((com.tencent.bugly.opengame.crashreport.biz.UserInfoBean) listA.get(i6)).e) {
                                    com.tencent.bugly.opengame.crashreport.biz.UserInfoBean userInfoBean = (com.tencent.bugly.opengame.crashreport.biz.UserInfoBean) listA.get(i4);
                                    listA.set(i4, listA.get(i6));
                                    listA.set(i6, userInfoBean);
                                }
                            }
                            i4 = i5;
                        }
                        for (int i7 = 0; i7 < size; i7++) {
                            arrayList.add(listA.get(i7));
                        }
                    }
                    java.util.Iterator it = listA.iterator();
                    int i8 = 0;
                    while (it.hasNext()) {
                        com.tencent.bugly.opengame.crashreport.biz.UserInfoBean userInfoBean2 = (com.tencent.bugly.opengame.crashreport.biz.UserInfoBean) it.next();
                        if (userInfoBean2.f != -1) {
                            it.remove();
                            if (userInfoBean2.e < com.tencent.bugly.opengame.proguard.z.b()) {
                                arrayList.add(userInfoBean2);
                            }
                        }
                        if (userInfoBean2.e > java.lang.System.currentTimeMillis() - 600000 && ((i3 = userInfoBean2.b) == 1 || i3 == 4 || i3 == 3)) {
                            i8++;
                        }
                    }
                    if (i8 > 15) {
                        com.tencent.bugly.opengame.proguard.x.d("[UserInfo] Upload user info too many times in 10 min: %d", java.lang.Integer.valueOf(i8));
                        z = false;
                    }
                    if (arrayList.size() > 0) {
                        a(arrayList);
                    }
                    if (z && listA.size() != 0) {
                        com.tencent.bugly.opengame.proguard.x.c("[UserInfo] Upload user info(size: %d)", java.lang.Integer.valueOf(listA.size()));
                        if (this.c == 1) {
                            i = 1;
                        } else {
                            i = 2;
                        }
                        auVarA = com.tencent.bugly.opengame.proguard.a.a(listA, i);
                        if (auVarA == null) {
                            com.tencent.bugly.opengame.proguard.x.d("[UserInfo] Failed to create UserInfoPackage.", new java.lang.Object[0]);
                            return;
                        }
                        bArrA = com.tencent.bugly.opengame.proguard.a.a((com.tencent.bugly.opengame.proguard.k) auVarA);
                        if (bArrA == null) {
                            com.tencent.bugly.opengame.proguard.x.d("[UserInfo] Failed to encode data.", new java.lang.Object[0]);
                            return;
                        }
                        if (uVarA.f406a) {
                            i2 = 840;
                        } else {
                            i2 = 640;
                        }
                        apVarA = com.tencent.bugly.opengame.proguard.a.a(this.f332a, i2, bArrA);
                        if (apVarA == null) {
                            com.tencent.bugly.opengame.proguard.x.d("[UserInfo] Request package is null.", new java.lang.Object[0]);
                            return;
                        }
                        com.tencent.bugly.opengame.proguard.t tVar = new com.tencent.bugly.opengame.proguard.t() { // from class: com.tencent.bugly.opengame.crashreport.biz.a.1
                            @Override // com.tencent.bugly.opengame.proguard.t
                            public final void a(boolean z3) {
                                if (z3) {
                                    com.tencent.bugly.opengame.proguard.x.c("[UserInfo] Successfully uploaded user info.", new java.lang.Object[0]);
                                    long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                                    for (com.tencent.bugly.opengame.crashreport.biz.UserInfoBean userInfoBean3 : listA) {
                                        userInfoBean3.f = jCurrentTimeMillis;
                                        com.tencent.bugly.opengame.crashreport.biz.a.a(com.tencent.bugly.opengame.crashreport.biz.a.this, userInfoBean3, true);
                                    }
                                }
                            }
                        };
                        strategyBeanC = com.tencent.bugly.opengame.crashreport.common.strategy.a.a().c();
                        if (uVarA.f406a) {
                            str = strategyBeanC.r;
                        } else {
                            str = strategyBeanC.t;
                        }
                        java.lang.String str4 = str;
                        if (uVarA.f406a) {
                            str2 = com.tencent.bugly.opengame.crashreport.common.strategy.StrategyBean.b;
                        } else {
                            str2 = com.tencent.bugly.opengame.crashreport.common.strategy.StrategyBean.f344a;
                        }
                        java.lang.String str5 = str2;
                        com.tencent.bugly.opengame.proguard.u uVarA2 = com.tencent.bugly.opengame.proguard.u.a();
                        if (this.c == 1) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        uVarA2.a(1001, apVarA, str4, str5, tVar, z2);
                        return;
                    }
                    com.tencent.bugly.opengame.proguard.x.c("[UserInfo] There is no user info in local database.", new java.lang.Object[0]);
                }
                listA = new java.util.ArrayList();
                z = true;
                if (arrayList.size() > 0) {
                    a(arrayList);
                }
                if (z) {
                    com.tencent.bugly.opengame.proguard.x.c("[UserInfo] Upload user info(size: %d)", java.lang.Integer.valueOf(listA.size()));
                    if (this.c == 1) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                    auVarA = com.tencent.bugly.opengame.proguard.a.a(listA, i);
                    if (auVarA == null) {
                        com.tencent.bugly.opengame.proguard.x.d("[UserInfo] Failed to create UserInfoPackage.", new java.lang.Object[0]);
                        return;
                    }
                    bArrA = com.tencent.bugly.opengame.proguard.a.a((com.tencent.bugly.opengame.proguard.k) auVarA);
                    if (bArrA == null) {
                        com.tencent.bugly.opengame.proguard.x.d("[UserInfo] Failed to encode data.", new java.lang.Object[0]);
                        return;
                    }
                    if (uVarA.f406a) {
                        i2 = 840;
                    } else {
                        i2 = 640;
                    }
                    apVarA = com.tencent.bugly.opengame.proguard.a.a(this.f332a, i2, bArrA);
                    if (apVarA == null) {
                        com.tencent.bugly.opengame.proguard.x.d("[UserInfo] Request package is null.", new java.lang.Object[0]);
                        return;
                    }
                    com.tencent.bugly.opengame.proguard.t tVar2 = new com.tencent.bugly.opengame.proguard.t() { // from class: com.tencent.bugly.opengame.crashreport.biz.a.1
                        @Override // com.tencent.bugly.opengame.proguard.t
                        public final void a(boolean z3) {
                            if (z3) {
                                com.tencent.bugly.opengame.proguard.x.c("[UserInfo] Successfully uploaded user info.", new java.lang.Object[0]);
                                long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                                for (com.tencent.bugly.opengame.crashreport.biz.UserInfoBean userInfoBean3 : listA) {
                                    userInfoBean3.f = jCurrentTimeMillis;
                                    com.tencent.bugly.opengame.crashreport.biz.a.a(com.tencent.bugly.opengame.crashreport.biz.a.this, userInfoBean3, true);
                                }
                            }
                        }
                    };
                    strategyBeanC = com.tencent.bugly.opengame.crashreport.common.strategy.a.a().c();
                    if (uVarA.f406a) {
                        str = strategyBeanC.r;
                    } else {
                        str = strategyBeanC.t;
                    }
                    java.lang.String str6 = str;
                    if (uVarA.f406a) {
                        str2 = com.tencent.bugly.opengame.crashreport.common.strategy.StrategyBean.b;
                    } else {
                        str2 = com.tencent.bugly.opengame.crashreport.common.strategy.StrategyBean.f344a;
                    }
                    java.lang.String str7 = str2;
                    com.tencent.bugly.opengame.proguard.u uVarA3 = com.tencent.bugly.opengame.proguard.u.a();
                    if (this.c == 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    uVarA3.a(1001, apVarA, str6, str7, tVar2, z2);
                    return;
                }
                com.tencent.bugly.opengame.proguard.x.c("[UserInfo] There is no user info in local database.", new java.lang.Object[0]);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final java.util.List a(java.lang.String str) {
        android.database.Cursor cursorA;
        java.lang.String str2;
        try {
            if (com.tencent.bugly.opengame.proguard.z.a(str)) {
                str2 = null;
            } else {
                str2 = "_pc = '" + str + "'";
            }
            cursorA = com.tencent.bugly.opengame.proguard.p.a().a("t_ui", null, str2, null, null, true);
            if (cursorA == null) {
                if (cursorA != null) {
                    cursorA.close();
                }
                return null;
            }
            try {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                java.util.ArrayList arrayList = new java.util.ArrayList();
                while (cursorA.moveToNext()) {
                    com.tencent.bugly.opengame.crashreport.biz.UserInfoBean userInfoBeanA = a(cursorA);
                    if (userInfoBeanA != null) {
                        arrayList.add(userInfoBeanA);
                    } else {
                        try {
                            long j = cursorA.getLong(cursorA.getColumnIndex("_id"));
                            sb.append(" or _id");
                            sb.append(" = ");
                            sb.append(j);
                        } catch (java.lang.Throwable unused) {
                            com.tencent.bugly.opengame.proguard.x.d("[Database] unknown id.", new java.lang.Object[0]);
                        }
                    }
                }
                java.lang.String string = sb.toString();
                if (string.length() > 0) {
                    com.tencent.bugly.opengame.proguard.x.d("[Database] deleted %s error data %d", "t_ui", java.lang.Integer.valueOf(com.tencent.bugly.opengame.proguard.p.a().a("t_ui", string.substring(4), (java.lang.String[]) null, (com.tencent.bugly.opengame.proguard.o) null, true)));
                }
                if (cursorA != null) {
                    cursorA.close();
                }
                return arrayList;
            } catch (java.lang.Throwable th) {
                th = th;
                try {
                    if (!com.tencent.bugly.opengame.proguard.x.a(th)) {
                        th.printStackTrace();
                    }
                    return null;
                } finally {
                    if (cursorA != null) {
                        cursorA.close();
                    }
                }
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            cursorA = null;
        }
    }

    public final void a() {
        this.b = com.tencent.bugly.opengame.proguard.z.b() + 86400000;
        com.tencent.bugly.opengame.proguard.w.a().a(new com.tencent.bugly.opengame.crashreport.biz.a.b(), (this.b - java.lang.System.currentTimeMillis()) + 5000);
    }

    public final void a(int i, boolean z, long j) {
        com.tencent.bugly.opengame.crashreport.common.strategy.a aVarA = com.tencent.bugly.opengame.crashreport.common.strategy.a.a();
        if (aVarA != null && !aVarA.c().h && i != 1 && i != 3) {
            com.tencent.bugly.opengame.proguard.x.e("UserInfo is disable", new java.lang.Object[0]);
            return;
        }
        if (i == 1 || i == 3) {
            this.c++;
        }
        com.tencent.bugly.opengame.crashreport.common.info.a aVarA2 = com.tencent.bugly.opengame.crashreport.common.info.a.a(this.f332a);
        com.tencent.bugly.opengame.crashreport.biz.UserInfoBean userInfoBean = new com.tencent.bugly.opengame.crashreport.biz.UserInfoBean();
        userInfoBean.b = i;
        userInfoBean.c = aVarA2.d;
        userInfoBean.d = aVarA2.g();
        userInfoBean.e = java.lang.System.currentTimeMillis();
        userInfoBean.f = -1L;
        userInfoBean.n = aVarA2.j;
        userInfoBean.o = i == 1 ? 1 : 0;
        userInfoBean.l = aVarA2.a();
        userInfoBean.m = aVarA2.p;
        userInfoBean.g = aVarA2.q;
        userInfoBean.h = aVarA2.r;
        userInfoBean.i = aVarA2.s;
        userInfoBean.k = aVarA2.t;
        userInfoBean.r = aVarA2.B();
        userInfoBean.s = aVarA2.G();
        userInfoBean.p = aVarA2.H();
        userInfoBean.q = aVarA2.I();
        com.tencent.bugly.opengame.proguard.w.a().a(new com.tencent.bugly.opengame.crashreport.biz.a.RunnableC0022a(userInfoBean, z), 0L);
    }

    public final void b() {
        com.tencent.bugly.opengame.proguard.w wVarA = com.tencent.bugly.opengame.proguard.w.a();
        if (wVarA != null) {
            wVarA.a(new com.tencent.bugly.opengame.crashreport.biz.a.AnonymousClass2());
        }
    }
}
