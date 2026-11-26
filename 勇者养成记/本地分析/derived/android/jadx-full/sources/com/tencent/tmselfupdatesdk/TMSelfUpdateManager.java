package com.tencent.tmselfupdatesdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class TMSelfUpdateManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile com.tencent.tmselfupdatesdk.TMSelfUpdateManager f1144a;
    private android.content.Context b;
    private java.lang.String c;
    private com.tencent.tmselfupdatesdk.ITMSelfUpdateListener d;
    private com.tencent.tmselfupdatesdk.YYBDownloadListener e;
    private java.lang.Object f;
    private java.lang.Object g;
    private com.tencent.tmselfupdatesdk.PushGetListener h;
    private com.tencent.tmselfupdatesdk.PushTouchListener i;
    private android.os.Bundle j;
    private boolean k = false;

    private TMSelfUpdateManager() {
    }

    private java.lang.Object a(com.tencent.tmselfupdatesdk.b.d dVar, java.lang.String str, java.lang.Object... objArr) {
        try {
            com.tencent.tmassistantbase.util.x.a("TMSelfUpdateManager", "调用更新包的方法:" + str);
            com.tencent.tmselfupdatesdk.b.f.a().a(dVar, str);
            return com.tencent.tmselfupdatesdk.util.c.a(dVar.d.f1152a).d("getInstance").a(str, objArr).a();
        } catch (java.lang.Throwable th) {
            com.tencent.tmassistantbase.util.x.b("TMSelfUpdateManager", "callPatchMethod exception. method:" + str);
            th.printStackTrace();
            com.tencent.tmselfupdatesdk.b.f.a().a(dVar);
            try {
                init(this.b, this.c, this.d, this.e, this.j);
                com.tencent.tmselfupdatesdk.util.c.a(this).a(str, objArr);
                return null;
            } catch (java.lang.Throwable th2) {
                th2.printStackTrace();
                return null;
            }
        }
    }

    public static com.tencent.tmselfupdatesdk.TMSelfUpdateManager getInstance() {
        if (f1144a == null) {
            synchronized (com.tencent.tmselfupdatesdk.TMSelfUpdateManager.class) {
                if (f1144a == null) {
                    f1144a = new com.tencent.tmselfupdatesdk.TMSelfUpdateManager();
                }
            }
        }
        return f1144a;
    }

    public void cancelYYBDownload() {
        com.tencent.tmselfupdatesdk.b.d dVarA = com.tencent.tmselfupdatesdk.b.f.a().a(this.b);
        if (dVarA == null) {
            com.tencent.tmselfupdatesdk.entry.TMSelfUpdateManagerImpl.getInstance().cancelYYBDownload();
            return;
        }
        if (!dVarA.i) {
            if (this.k) {
                initDebug(this.b, this.c, this.d, this.e, this.j);
            } else {
                init(this.b, this.c, this.d, this.e, this.j);
            }
        }
        com.tencent.tmassistantbase.util.x.a("TMSelfUpdateManager", "TMSelfUpdateManager cancelYYBDownload. has patch.");
        a(dVarA, "cancelYYBDownload", new java.lang.Object[0]);
    }

    public void checkSelfUpdate() {
        com.tencent.tmselfupdatesdk.b.d dVarA = com.tencent.tmselfupdatesdk.b.f.a().a(this.b);
        if (dVarA == null) {
            com.tencent.tmselfupdatesdk.entry.TMSelfUpdateManagerImpl.getInstance().checkSelfUpdate();
            return;
        }
        if (!dVarA.i) {
            if (this.k) {
                initDebug(this.b, this.c, this.d, this.e, this.j);
            } else {
                init(this.b, this.c, this.d, this.e, this.j);
            }
        }
        com.tencent.tmassistantbase.util.x.a("TMSelfUpdateManager", "TMSelfUpdateManager checkSelfUpdate. has patch.");
        a(dVarA, "checkSelfUpdate", new java.lang.Object[0]);
    }

    public void checkYYBDownloaded() {
        com.tencent.tmselfupdatesdk.b.d dVarA = com.tencent.tmselfupdatesdk.b.f.a().a(this.b);
        if (dVarA == null) {
            com.tencent.tmselfupdatesdk.entry.TMSelfUpdateManagerImpl.getInstance().checkYYBDownloaded();
            return;
        }
        if (!dVarA.i) {
            if (this.k) {
                initDebug(this.b, this.c, this.d, this.e, this.j);
            } else {
                init(this.b, this.c, this.d, this.e, this.j);
            }
        }
        com.tencent.tmassistantbase.util.x.a("TMSelfUpdateManager", "TMSelfUpdateManager checkYYBDownloaded. has patch.");
        a(dVarA, "checkYYBDownloaded", new java.lang.Object[0]);
    }

    public int checkYYBInstallState() {
        com.tencent.tmselfupdatesdk.b.d dVarA = com.tencent.tmselfupdatesdk.b.f.a().a(this.b);
        if (dVarA == null) {
            return com.tencent.tmselfupdatesdk.entry.TMSelfUpdateManagerImpl.getInstance().checkYYBInstallState();
        }
        if (!dVarA.i) {
            if (this.k) {
                initDebug(this.b, this.c, this.d, this.e, this.j);
            } else {
                init(this.b, this.c, this.d, this.e, this.j);
            }
        }
        com.tencent.tmassistantbase.util.x.a("TMSelfUpdateManager", "TMSelfUpdateManager checkYYBInstallState. has patch.");
        return ((java.lang.Integer) a(dVarA, "checkYYBInstallState", new java.lang.Object[0])).intValue();
    }

    public void destroy() {
        com.tencent.tmselfupdatesdk.b.d dVarA = com.tencent.tmselfupdatesdk.b.f.a().a(this.b);
        if (dVarA == null) {
            com.tencent.tmselfupdatesdk.entry.TMSelfUpdateManagerImpl.getInstance().destroy();
            return;
        }
        try {
            if (!dVarA.i) {
                if (this.k) {
                    initDebug(this.b, this.c, this.d, this.e, this.j);
                } else {
                    init(this.b, this.c, this.d, this.e, this.j);
                }
            }
            com.tencent.tmassistantbase.util.x.a("TMSelfUpdateManager", "TMSelfUpdateManager destroy. has patch.");
            a(dVarA, "destroy", new java.lang.Object[0]);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public int init(android.content.Context context, java.lang.String str, com.tencent.tmselfupdatesdk.ITMSelfUpdateListener iTMSelfUpdateListener, com.tencent.tmselfupdatesdk.YYBDownloadListener yYBDownloadListener, android.os.Bundle bundle) {
        this.b = context.getApplicationContext();
        this.c = str;
        this.d = iTMSelfUpdateListener;
        this.e = yYBDownloadListener;
        this.j = bundle;
        if (bundle == null) {
            this.j = new android.os.Bundle();
        }
        this.k = false;
        com.tencent.tmselfupdatesdk.b.d dVarA = com.tencent.tmselfupdatesdk.b.f.a().a(this.b);
        if (dVarA != null) {
            com.tencent.tmassistantbase.util.x.a("TMSelfUpdateManager", "TMSelfUpdateManager init. has patch.");
            try {
                this.f = com.tencent.tmselfupdatesdk.util.b.a(dVarA.d.b, this.d);
                java.lang.Object objA = com.tencent.tmselfupdatesdk.util.b.a(dVarA.d.b, this.e);
                this.g = objA;
                int iIntValue = ((java.lang.Integer) a(dVarA, "init", this.b, this.c, this.f, objA, this.j)).intValue();
                dVarA.i = true;
                return iIntValue;
            } catch (java.lang.Throwable th) {
                com.tencent.tmassistantbase.util.x.b("TMSelfUpdateManager", "TMSelfUpdateManager init exception");
                th.printStackTrace();
            }
        }
        com.tencent.tmassistantbase.util.x.a("TMSelfUpdateManager", "TMSelfUpdateManager init. no patch. just run old version.");
        return com.tencent.tmselfupdatesdk.entry.TMSelfUpdateManagerImpl.getInstance().init(context, str, iTMSelfUpdateListener, yYBDownloadListener, bundle);
    }

    public int initDebug(android.content.Context context, java.lang.String str, com.tencent.tmselfupdatesdk.ITMSelfUpdateListener iTMSelfUpdateListener, com.tencent.tmselfupdatesdk.YYBDownloadListener yYBDownloadListener, android.os.Bundle bundle) {
        this.b = context.getApplicationContext();
        this.c = str;
        this.d = iTMSelfUpdateListener;
        this.e = yYBDownloadListener;
        this.j = bundle;
        if (bundle == null) {
            this.j = new android.os.Bundle();
        }
        this.k = true;
        com.tencent.tmselfupdatesdk.b.d dVarA = com.tencent.tmselfupdatesdk.b.f.a().a(this.b);
        if (dVarA != null) {
            com.tencent.tmassistantbase.util.x.a("TMSelfUpdateManager", "TMSelfUpdateManager init. has patch.");
            try {
                com.tencent.tmassistantbase.util.x.a("TMSelfUpdateManager", " >> applicationContext: " + context + "; yybchannelId: " + str + "; ITMSelfUpdateListener: " + iTMSelfUpdateListener + "; YYBDownloadListener: " + yYBDownloadListener + ". bundle=" + this.j);
                this.f = com.tencent.tmselfupdatesdk.util.b.a(dVarA.d.b, this.d);
                java.lang.Object objA = com.tencent.tmselfupdatesdk.util.b.a(dVarA.d.b, this.e);
                this.g = objA;
                int iIntValue = ((java.lang.Integer) a(dVarA, "initDebug", this.b, this.c, this.f, objA, this.j)).intValue();
                dVarA.i = true;
                return iIntValue;
            } catch (java.lang.Throwable th) {
                com.tencent.tmassistantbase.util.x.b("TMSelfUpdateManager", "TMSelfUpdateManager init exception");
                th.printStackTrace();
            }
        }
        com.tencent.tmassistantbase.util.x.a("TMSelfUpdateManager", "TMSelfUpdateManager initDebug. no patch. just run old version.");
        return com.tencent.tmselfupdatesdk.entry.TMSelfUpdateManagerImpl.getInstance().initDebug((android.app.Application) context, str, iTMSelfUpdateListener, yYBDownloadListener, bundle);
    }

    public void initPush(android.content.Context context, com.tencent.tmselfupdatesdk.PushGetListener pushGetListener, com.tencent.tmselfupdatesdk.PushTouchListener pushTouchListener) throws java.lang.Exception {
        this.b = context.getApplicationContext();
        this.h = pushGetListener;
        this.i = pushTouchListener;
        com.tencent.tmselfupdatesdk.b.d dVarA = com.tencent.tmselfupdatesdk.b.f.a().a(this.b);
        if (dVarA != null) {
            try {
                a(dVarA, "initPush", this.b, com.tencent.tmselfupdatesdk.util.b.a(dVarA.d.b, this.h), com.tencent.tmselfupdatesdk.util.b.a(dVarA.d.b, this.i));
                dVarA.j = true;
                return;
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        com.tencent.tmassistantbase.util.x.a("TMSelfUpdateManager", "TMSelfUpdateManager initPush. no patch. just run old version.");
        com.tencent.tmselfupdatesdk.entry.TMSelfUpdateManagerImpl.getInstance().initPush(context, pushGetListener, pushTouchListener);
    }

    public void initPushDebug(android.content.Context context, com.tencent.tmselfupdatesdk.PushGetListener pushGetListener, com.tencent.tmselfupdatesdk.PushTouchListener pushTouchListener) throws java.lang.Exception {
        this.b = context.getApplicationContext();
        this.h = pushGetListener;
        this.i = pushTouchListener;
        com.tencent.tmselfupdatesdk.b.d dVarA = com.tencent.tmselfupdatesdk.b.f.a().a(this.b);
        if (dVarA != null) {
            try {
                a(dVarA, "initPushDebug", this.b, com.tencent.tmselfupdatesdk.util.b.a(dVarA.d.b, this.h), com.tencent.tmselfupdatesdk.util.b.a(dVarA.d.b, this.i));
                dVarA.j = true;
                return;
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        com.tencent.tmassistantbase.util.x.a("TMSelfUpdateManager", "TMSelfUpdateManager initPushDebug. no patch. just run old version.");
        com.tencent.tmselfupdatesdk.entry.TMSelfUpdateManagerImpl.getInstance().initPushDebug(context, pushGetListener, pushTouchListener);
    }

    public void onActivityResume() throws java.lang.Exception {
        com.tencent.tmselfupdatesdk.b.d dVarA = com.tencent.tmselfupdatesdk.b.f.a().a(this.b);
        if (dVarA == null) {
            com.tencent.tmselfupdatesdk.entry.TMSelfUpdateManagerImpl.getInstance().onActivityResume();
            return;
        }
        if (!dVarA.i) {
            if (this.k) {
                initDebug(this.b, this.c, this.d, this.e, this.j);
            } else {
                init(this.b, this.c, this.d, this.e, this.j);
            }
        }
        com.tencent.tmassistantbase.util.x.a("TMSelfUpdateManager", "TMSelfUpdateManager onActivityResume. has patch.");
        a(dVarA, "onActivityResume", new java.lang.Object[0]);
    }

    public void reInit() {
        try {
            if (this.k) {
                initDebug(this.b, this.c, this.d, this.e, this.j);
            } else {
                init(this.b, this.c, this.d, this.e, this.j);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void startPreDownloadYYB(boolean z) {
        com.tencent.tmselfupdatesdk.b.d dVarA = com.tencent.tmselfupdatesdk.b.f.a().a(this.b);
        if (dVarA == null) {
            com.tencent.tmselfupdatesdk.entry.TMSelfUpdateManagerImpl.getInstance().startPreDownloadYYB(z);
            return;
        }
        if (!dVarA.i) {
            if (this.k) {
                initDebug(this.b, this.c, this.d, this.e, this.j);
            } else {
                init(this.b, this.c, this.d, this.e, this.j);
            }
        }
        com.tencent.tmassistantbase.util.x.a("TMSelfUpdateManager", "TMSelfUpdateManager startPreDownloadYYB. has patch.");
        a(dVarA, "startPreDownloadYYB", java.lang.Boolean.valueOf(z));
    }

    public int startSelfUpdate(boolean z) {
        com.tencent.tmselfupdatesdk.b.d dVarA = com.tencent.tmselfupdatesdk.b.f.a().a(this.b);
        if (dVarA == null) {
            return com.tencent.tmselfupdatesdk.entry.TMSelfUpdateManagerImpl.getInstance().startSelfUpdate(z);
        }
        if (!dVarA.i) {
            if (this.k) {
                initDebug(this.b, this.c, this.d, this.e, this.j);
            } else {
                init(this.b, this.c, this.d, this.e, this.j);
            }
        }
        com.tencent.tmassistantbase.util.x.a("TMSelfUpdateManager", "TMSelfUpdateManager startSelfUpdate. has patch.");
        return ((java.lang.Integer) a(dVarA, "startSelfUpdate", java.lang.Boolean.valueOf(z))).intValue();
    }

    public void startYYBInstallIfDownloaded() {
        com.tencent.tmselfupdatesdk.b.d dVarA = com.tencent.tmselfupdatesdk.b.f.a().a(this.b);
        if (dVarA == null) {
            com.tencent.tmselfupdatesdk.entry.TMSelfUpdateManagerImpl.getInstance().startYYBInstallIfDownloaded();
            return;
        }
        try {
            if (!dVarA.i) {
                if (this.k) {
                    initDebug(this.b, this.c, this.d, this.e, this.j);
                } else {
                    init(this.b, this.c, this.d, this.e, this.j);
                }
            }
            com.tencent.tmassistantbase.util.x.a("TMSelfUpdateManager", "TMSelfUpdateManager startYYBInstallIfDownloaded. has patch.");
            a(dVarA, "startYYBInstallIfDownloaded", new java.lang.Object[0]);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void switchLog(boolean z) {
        com.tencent.tmselfupdatesdk.b.d dVarA = com.tencent.tmselfupdatesdk.b.f.a().a(this.b);
        if (dVarA == null) {
            com.tencent.tmselfupdatesdk.entry.TMSelfUpdateManagerImpl.getInstance().switchLog(z);
            return;
        }
        try {
            if (!dVarA.i) {
                if (this.k) {
                    initDebug(this.b, this.c, this.d, this.e, this.j);
                } else {
                    init(this.b, this.c, this.d, this.e, this.j);
                }
            }
            com.tencent.tmassistantbase.util.x.a("TMSelfUpdateManager", "TMSelfUpdateManager switchLog. has patch.");
            a(dVarA, "switchLog", java.lang.Boolean.valueOf(z));
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
