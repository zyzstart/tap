package com.tencent.bugly.crashreport.biz;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.content.Context f282a;
    private long b;
    private int c;
    private boolean d;

    /* JADX INFO: renamed from: com.tencent.bugly.crashreport.biz.a$2, reason: invalid class name */
    /* JADX INFO: compiled from: BUGLY */
    final class AnonymousClass2 implements java.lang.Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.tencent.bugly.crashreport.biz.a.this.c();
            } catch (java.lang.Throwable th) {
                com.tencent.bugly.proguard.x.a(th);
            }
        }
    }

    /* JADX INFO: renamed from: com.tencent.bugly.crashreport.biz.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BUGLY */
    class RunnableC0021a implements java.lang.Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f285a;
        private com.tencent.bugly.crashreport.biz.UserInfoBean b;

        public RunnableC0021a(com.tencent.bugly.crashreport.biz.UserInfoBean userInfoBean, boolean z) {
            this.b = userInfoBean;
            this.f285a = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.tencent.bugly.crashreport.common.info.a aVarB;
            try {
                if (this.b != null) {
                    com.tencent.bugly.crashreport.biz.UserInfoBean userInfoBean = this.b;
                    if (userInfoBean != null && (aVarB = com.tencent.bugly.crashreport.common.info.a.b()) != null) {
                        userInfoBean.j = aVarB.e();
                    }
                    com.tencent.bugly.proguard.x.c("[UserInfo] Record user info.", new java.lang.Object[0]);
                    com.tencent.bugly.crashreport.biz.a.a(com.tencent.bugly.crashreport.biz.a.this, this.b, false);
                }
                if (this.f285a) {
                    com.tencent.bugly.crashreport.biz.a aVar = com.tencent.bugly.crashreport.biz.a.this;
                    com.tencent.bugly.proguard.w wVarA = com.tencent.bugly.proguard.w.a();
                    if (wVarA != null) {
                        wVarA.a(aVar.new AnonymousClass2());
                    }
                }
            } catch (java.lang.Throwable th) {
                if (com.tencent.bugly.proguard.x.a(th)) {
                    return;
                }
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: BUGLY */
    class b implements java.lang.Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            if (jCurrentTimeMillis < com.tencent.bugly.crashreport.biz.a.this.b) {
                com.tencent.bugly.proguard.w.a().a(com.tencent.bugly.crashreport.biz.a.this.new b(), (com.tencent.bugly.crashreport.biz.a.this.b - jCurrentTimeMillis) + 5000);
            } else {
                com.tencent.bugly.crashreport.biz.a.this.a(3, false, 0L);
                com.tencent.bugly.crashreport.biz.a.this.a();
            }
        }
    }

    /* JADX INFO: compiled from: BUGLY */
    class c implements java.lang.Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f287a;

        public c(long j) {
            this.f287a = 21600000L;
            this.f287a = j;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.tencent.bugly.crashreport.biz.a aVar = com.tencent.bugly.crashreport.biz.a.this;
            com.tencent.bugly.proguard.w wVarA = com.tencent.bugly.proguard.w.a();
            if (wVarA != null) {
                wVarA.a(aVar.new AnonymousClass2());
            }
            com.tencent.bugly.crashreport.biz.a aVar2 = com.tencent.bugly.crashreport.biz.a.this;
            long j = this.f287a;
            com.tencent.bugly.proguard.w.a().a(aVar2.new c(j), j);
        }
    }

    public a(android.content.Context context, boolean z) {
        this.d = true;
        this.f282a = context;
        this.d = z;
    }

    private static android.content.ContentValues a(com.tencent.bugly.crashreport.biz.UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        try {
            android.content.ContentValues contentValues = new android.content.ContentValues();
            if (userInfoBean.f281a > 0) {
                contentValues.put("_id", java.lang.Long.valueOf(userInfoBean.f281a));
            }
            contentValues.put("_tm", java.lang.Long.valueOf(userInfoBean.e));
            contentValues.put("_ut", java.lang.Long.valueOf(userInfoBean.f));
            contentValues.put("_tp", java.lang.Integer.valueOf(userInfoBean.b));
            contentValues.put("_pc", userInfoBean.c);
            contentValues.put("_dt", com.tencent.bugly.proguard.z.a(userInfoBean));
            return contentValues;
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.proguard.x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static com.tencent.bugly.crashreport.biz.UserInfoBean a(android.database.Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j = cursor.getLong(cursor.getColumnIndex("_id"));
            com.tencent.bugly.crashreport.biz.UserInfoBean userInfoBean = (com.tencent.bugly.crashreport.biz.UserInfoBean) com.tencent.bugly.proguard.z.a(blob, com.tencent.bugly.crashreport.biz.UserInfoBean.CREATOR);
            if (userInfoBean != null) {
                userInfoBean.f281a = j;
            }
            return userInfoBean;
        } catch (java.lang.Throwable th) {
            if (!com.tencent.bugly.proguard.x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    static /* synthetic */ void a(com.tencent.bugly.crashreport.biz.a aVar, com.tencent.bugly.crashreport.biz.UserInfoBean userInfoBean, boolean z) {
        java.util.List<com.tencent.bugly.crashreport.biz.UserInfoBean> listA;
        if (userInfoBean != null) {
            if (!z && userInfoBean.b != 1 && (listA = aVar.a(com.tencent.bugly.crashreport.common.info.a.a(aVar.f282a).d)) != null && listA.size() >= 20) {
                com.tencent.bugly.proguard.x.a("[UserInfo] There are too many user info in local: %d", java.lang.Integer.valueOf(listA.size()));
                return;
            }
            long jA = com.tencent.bugly.proguard.p.a().a("t_ui", a(userInfoBean), (com.tencent.bugly.proguard.o) null, true);
            if (jA >= 0) {
                com.tencent.bugly.proguard.x.c("[Database] insert %s success with ID: %d", "t_ui", java.lang.Long.valueOf(jA));
                userInfoBean.f281a = jA;
            }
        }
    }

    private static void a(java.util.List<com.tencent.bugly.crashreport.biz.UserInfoBean> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = 0; i < list.size() && i < 50; i++) {
            com.tencent.bugly.crashreport.biz.UserInfoBean userInfoBean = list.get(i);
            sb.append(" or _id");
            sb.append(" = ");
            sb.append(userInfoBean.f281a);
        }
        java.lang.String string = sb.toString();
        java.lang.String strSubstring = string.length() > 0 ? string.substring(4) : string;
        sb.setLength(0);
        try {
            com.tencent.bugly.proguard.x.c("[Database] deleted %s data %d", "t_ui", java.lang.Integer.valueOf(com.tencent.bugly.proguard.p.a().a("t_ui", strSubstring, (java.lang.String[]) null, (com.tencent.bugly.proguard.o) null, true)));
        } catch (java.lang.Throwable th) {
            if (com.tencent.bugly.proguard.x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void c() {
        boolean z;
        if (this.d) {
            com.tencent.bugly.proguard.u uVarA = com.tencent.bugly.proguard.u.a();
            if (uVarA == null) {
                return;
            }
            com.tencent.bugly.crashreport.common.strategy.a aVarA = com.tencent.bugly.crashreport.common.strategy.a.a();
            if (aVarA == null) {
                return;
            }
            if (!aVarA.b() || uVarA.b(1001)) {
                java.lang.String str = com.tencent.bugly.crashreport.common.info.a.a(this.f282a).d;
                java.util.ArrayList arrayList = new java.util.ArrayList();
                final java.util.List<com.tencent.bugly.crashreport.biz.UserInfoBean> listA = a(str);
                if (listA != null) {
                    int size = listA.size() - 20;
                    if (size > 0) {
                        int i = 0;
                        while (i < listA.size() - 1) {
                            int i2 = i + 1;
                            for (int i3 = i2; i3 < listA.size(); i3++) {
                                if (listA.get(i).e > listA.get(i3).e) {
                                    com.tencent.bugly.crashreport.biz.UserInfoBean userInfoBean = listA.get(i);
                                    listA.set(i, listA.get(i3));
                                    listA.set(i3, userInfoBean);
                                }
                            }
                            i = i2;
                        }
                        for (int i4 = 0; i4 < size; i4++) {
                            arrayList.add(listA.get(i4));
                        }
                    }
                    java.util.Iterator<com.tencent.bugly.crashreport.biz.UserInfoBean> it = listA.iterator();
                    int i5 = 0;
                    while (it.hasNext()) {
                        com.tencent.bugly.crashreport.biz.UserInfoBean next = it.next();
                        if (next.f != -1) {
                            it.remove();
                            if (next.e < com.tencent.bugly.proguard.z.b()) {
                                arrayList.add(next);
                            }
                        }
                        if (next.e > java.lang.System.currentTimeMillis() - 600000 && (next.b == 1 || next.b == 4 || next.b == 3)) {
                            i5++;
                        }
                    }
                    if (i5 > 15) {
                        com.tencent.bugly.proguard.x.d("[UserInfo] Upload user info too many times in 10 min: %d", java.lang.Integer.valueOf(i5));
                        z = false;
                    } else {
                        z = true;
                    }
                } else {
                    listA = new java.util.ArrayList<>();
                    z = true;
                }
                if (arrayList.size() > 0) {
                    a(arrayList);
                }
                if (z && listA.size() != 0) {
                    com.tencent.bugly.proguard.x.c("[UserInfo] Upload user info(size: %d)", java.lang.Integer.valueOf(listA.size()));
                    com.tencent.bugly.proguard.au auVarA = com.tencent.bugly.proguard.a.a(listA, this.c == 1 ? 1 : 2);
                    if (auVarA == null) {
                        com.tencent.bugly.proguard.x.d("[UserInfo] Failed to create UserInfoPackage.", new java.lang.Object[0]);
                        return;
                    }
                    byte[] bArrA = com.tencent.bugly.proguard.a.a((com.tencent.bugly.proguard.k) auVarA);
                    if (bArrA == null) {
                        com.tencent.bugly.proguard.x.d("[UserInfo] Failed to encode data.", new java.lang.Object[0]);
                        return;
                    }
                    com.tencent.bugly.proguard.ap apVarA = com.tencent.bugly.proguard.a.a(this.f282a, uVarA.f448a ? 840 : 640, bArrA);
                    if (apVarA == null) {
                        com.tencent.bugly.proguard.x.d("[UserInfo] Request package is null.", new java.lang.Object[0]);
                        return;
                    }
                    com.tencent.bugly.proguard.t tVar = new com.tencent.bugly.proguard.t() { // from class: com.tencent.bugly.crashreport.biz.a.1
                        @Override // com.tencent.bugly.proguard.t
                        public final void a(boolean z2) {
                            if (z2) {
                                com.tencent.bugly.proguard.x.c("[UserInfo] Successfully uploaded user info.", new java.lang.Object[0]);
                                long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                                for (com.tencent.bugly.crashreport.biz.UserInfoBean userInfoBean2 : listA) {
                                    userInfoBean2.f = jCurrentTimeMillis;
                                    com.tencent.bugly.crashreport.biz.a.a(com.tencent.bugly.crashreport.biz.a.this, userInfoBean2, true);
                                }
                            }
                        }
                    };
                    com.tencent.bugly.crashreport.common.strategy.StrategyBean strategyBeanC = com.tencent.bugly.crashreport.common.strategy.a.a().c();
                    com.tencent.bugly.proguard.u.a().a(1001, apVarA, uVarA.f448a ? strategyBeanC.r : strategyBeanC.t, uVarA.f448a ? com.tencent.bugly.crashreport.common.strategy.StrategyBean.b : com.tencent.bugly.crashreport.common.strategy.StrategyBean.f294a, tVar, this.c == 1);
                    return;
                }
                com.tencent.bugly.proguard.x.c("[UserInfo] There is no user info in local database.", new java.lang.Object[0]);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00be  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final java.util.List<com.tencent.bugly.crashreport.biz.UserInfoBean> a(java.lang.String str) {
        java.lang.Throwable th;
        android.database.Cursor cursorA;
        java.lang.String str2;
        try {
            if (com.tencent.bugly.proguard.z.a(str)) {
                str2 = null;
            } else {
                str2 = "_pc = '" + str + "'";
            }
            cursorA = com.tencent.bugly.proguard.p.a().a("t_ui", null, str2, null, null, true);
            if (cursorA == null) {
                if (cursorA != null) {
                    cursorA.close();
                }
                return null;
            }
            try {
                try {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    while (cursorA.moveToNext()) {
                        com.tencent.bugly.crashreport.biz.UserInfoBean userInfoBeanA = a(cursorA);
                        if (userInfoBeanA != null) {
                            arrayList.add(userInfoBeanA);
                        } else {
                            try {
                                long j = cursorA.getLong(cursorA.getColumnIndex("_id"));
                                sb.append(" or _id");
                                sb.append(" = ");
                                sb.append(j);
                            } catch (java.lang.Throwable unused) {
                                com.tencent.bugly.proguard.x.d("[Database] unknown id.", new java.lang.Object[0]);
                            }
                        }
                    }
                    java.lang.String string = sb.toString();
                    if (string.length() > 0) {
                        com.tencent.bugly.proguard.x.d("[Database] deleted %s error data %d", "t_ui", java.lang.Integer.valueOf(com.tencent.bugly.proguard.p.a().a("t_ui", string.substring(4), (java.lang.String[]) null, (com.tencent.bugly.proguard.o) null, true)));
                    }
                    if (cursorA != null) {
                        cursorA.close();
                    }
                    return arrayList;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    if (!com.tencent.bugly.proguard.x.a(th)) {
                        th.printStackTrace();
                    }
                    if (cursorA != null) {
                        cursorA.close();
                    }
                    return null;
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                if (cursorA != null) {
                    cursorA.close();
                }
                throw th;
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
            cursorA = null;
            if (cursorA != null) {
                cursorA.close();
            }
            throw th;
        }
    }

    public final void a() {
        this.b = com.tencent.bugly.proguard.z.b() + 86400000;
        com.tencent.bugly.proguard.w.a().a(new com.tencent.bugly.crashreport.biz.a.b(), (this.b - java.lang.System.currentTimeMillis()) + 5000);
    }

    public final void a(int i, boolean z, long j) {
        com.tencent.bugly.crashreport.common.strategy.a aVarA = com.tencent.bugly.crashreport.common.strategy.a.a();
        if (aVarA != null && !aVarA.c().h && i != 1 && i != 3) {
            com.tencent.bugly.proguard.x.e("UserInfo is disable", new java.lang.Object[0]);
            return;
        }
        if (i == 1 || i == 3) {
            this.c++;
        }
        com.tencent.bugly.crashreport.common.info.a aVarA2 = com.tencent.bugly.crashreport.common.info.a.a(this.f282a);
        com.tencent.bugly.crashreport.biz.UserInfoBean userInfoBean = new com.tencent.bugly.crashreport.biz.UserInfoBean();
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
        com.tencent.bugly.proguard.w.a().a(new com.tencent.bugly.crashreport.biz.a.RunnableC0021a(userInfoBean, z), 0L);
    }

    public final void b() {
        com.tencent.bugly.proguard.w wVarA = com.tencent.bugly.proguard.w.a();
        if (wVarA != null) {
            wVarA.a(new com.tencent.bugly.crashreport.biz.a.AnonymousClass2());
        }
    }
}
