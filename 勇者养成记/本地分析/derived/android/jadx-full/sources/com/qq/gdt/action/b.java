package com.qq.gdt.action;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile com.qq.gdt.action.b f69a;
    private static final java.lang.Object b = new java.lang.Object();
    private static final java.util.Set<java.lang.String> c = java.util.Collections.unmodifiableSet(new java.util.HashSet<java.lang.String>() { // from class: com.qq.gdt.action.b.1
        {
            add(com.qq.gdt.action.ActionType.START_APP);
            add(com.qq.gdt.action.ActionType.PAGE_VIEW);
            add(com.qq.gdt.action.ActionType.REGISTER);
            add(com.qq.gdt.action.ActionType.VIEW_CONTENT);
            add(com.qq.gdt.action.ActionType.CONSULT);
            add(com.qq.gdt.action.ActionType.ADD_TO_CART);
            add(com.qq.gdt.action.ActionType.PURCHASE);
            add(com.qq.gdt.action.ActionType.SEARCH);
            add(com.qq.gdt.action.ActionType.ADD_TO_WISHLIST);
            add(com.qq.gdt.action.ActionType.INITIATE_CHECKOUT);
            add(com.qq.gdt.action.ActionType.COMPLETE_ORDER);
            add(com.qq.gdt.action.ActionType.DOWNLOAD_APP);
            add(com.qq.gdt.action.ActionType.RATE);
            add(com.qq.gdt.action.ActionType.RESERVATION);
            add(com.qq.gdt.action.ActionType.SHARE);
            add(com.qq.gdt.action.ActionType.APPLY);
            add(com.qq.gdt.action.ActionType.CLAIM_OFFER);
            add(com.qq.gdt.action.ActionType.NAVIGATE);
            add(com.qq.gdt.action.ActionType.PRODUCT_RECOMMEND);
        }
    });
    private final android.content.Context d;
    private final java.util.Random e = new java.util.Random(java.lang.System.currentTimeMillis());
    private volatile java.lang.String f = "0.0.0";
    private int g = 30000;
    private int h = com.youme.im.CommonConst.SPEECH_DURATION_MAX;
    private int i = 100;
    private int j = 100;
    private int k = 0;
    private int l = 0;
    private java.util.Set<java.lang.String> m = c;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final java.lang.String f70a;
        final java.lang.String b;
        final java.lang.String c;

        public a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
            this.f70a = str;
            this.b = str2;
            this.c = str3;
        }
    }

    private b(android.content.Context context) {
        this.d = context.getApplicationContext();
        h();
    }

    public static com.qq.gdt.action.b a(android.content.Context context) {
        if (f69a == null) {
            synchronized (com.qq.gdt.action.b.class) {
                if (f69a == null) {
                    f69a = new com.qq.gdt.action.b(context);
                }
            }
        }
        return f69a;
    }

    private void a(java.lang.String str, java.lang.String str2) {
        synchronized (b) {
            java.lang.String str3 = new java.lang.String(com.qq.gdt.action.h.h.b(str2));
            com.qq.gdt.action.h.l.a("======>UpdateSDKConfig:\nversion = " + str + "\noriginal_config_str = \n" + com.qq.gdt.action.h.k.a(str3), new java.lang.Object[0]);
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str3);
                this.f = str;
                java.util.Set<java.lang.String> setB = b(jSONObject);
                if (setB.isEmpty()) {
                    setB = c;
                }
                this.m = setB;
                this.g = jSONObject.optInt("flush_interval", 30000);
                this.h = jSONObject.optInt("ticket_interval", com.youme.im.CommonConst.SPEECH_DURATION_MAX);
                this.i = jSONObject.optInt("his_report_rate", 100);
                this.j = jSONObject.optInt("dp3_report_rate", 100);
                this.k = jSONObject.optInt("action_record_strategy", 0);
                this.l = jSONObject.optInt("event_record_strategy", 0);
                com.qq.gdt.action.h.l.a(com.qq.gdt.action.h.t.a("=====>Apply config:\nversion = %s\nflushInterval = %d\nhisReportRate = %d\ndp3ReportRate = %d\nimportantActionTypes = %s\nactionRecordStrategy = %d\neventRecordStrategy = %d", this.f, java.lang.Integer.valueOf(this.g), java.lang.Integer.valueOf(this.i), java.lang.Integer.valueOf(this.j), this.m, java.lang.Integer.valueOf(this.k), java.lang.Integer.valueOf(this.l)), new java.lang.Object[0]);
            } catch (org.json.JSONException e) {
                com.qq.gdt.action.h.l.b("Json parse exception", e);
            }
        }
    }

    private boolean a(java.lang.String str, java.lang.String str2, java.lang.String str3) throws java.lang.Throwable {
        if (!com.qq.gdt.action.h.j.a(str2, com.qq.gdt.action.h.r.a(com.qq.gdt.action.h.h.b(str3)))) {
            com.qq.gdt.action.h.l.c("Fail to update conf for sign check error");
            return false;
        }
        java.io.File fileK = k();
        java.io.PrintWriter printWriter = null;
        try {
            try {
                java.io.PrintWriter printWriter2 = new java.io.PrintWriter(new java.io.FileOutputStream(fileK));
                try {
                    printWriter2.println(str);
                    printWriter2.println(str2);
                    printWriter2.println(str3);
                    com.qq.gdt.action.h.i.a(fileK, j());
                    a(str, str3);
                    try {
                        printWriter2.close();
                    } catch (java.lang.Exception unused) {
                    }
                    return true;
                } catch (java.io.IOException unused2) {
                    printWriter = printWriter2;
                    com.qq.gdt.action.h.l.c("Exception while persist config");
                    if (printWriter != null) {
                        try {
                            printWriter.close();
                        } catch (java.lang.Exception unused3) {
                        }
                    }
                    return false;
                } catch (java.lang.Throwable th) {
                    th = th;
                    printWriter = printWriter2;
                    if (printWriter != null) {
                        try {
                            printWriter.close();
                        } catch (java.lang.Exception unused4) {
                        }
                    }
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.io.IOException unused5) {
        }
    }

    private java.lang.String b(java.lang.String str) {
        return str + "_" + com.qq.gdt.action.h.r.a(com.qq.gdt.action.e.a().k());
    }

    private java.util.Set<java.lang.String> b(org.json.JSONObject jSONObject) {
        org.json.JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("action_type");
        java.util.HashSet hashSet = new java.util.HashSet();
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                hashSet.add(jSONArrayOptJSONArray.optString(i));
            }
        }
        return hashSet;
    }

    private void h() {
        try {
            com.qq.gdt.action.b.a aVarI = i();
            if (aVarI != null) {
                if (com.qq.gdt.action.h.j.a(aVarI.b, com.qq.gdt.action.h.r.a(com.qq.gdt.action.h.h.b(aVarI.c)))) {
                    a(aVarI.f70a, aVarI.c);
                } else {
                    com.qq.gdt.action.h.l.c("Fail to verify local config file");
                }
            }
        } catch (java.lang.Throwable th) {
            com.qq.gdt.action.h.l.b("Load SDKConfig from local exception", th);
        }
    }

    private com.qq.gdt.action.b.a i() throws java.io.IOException {
        java.io.File fileJ = j();
        if (!fileJ.exists()) {
            com.qq.gdt.action.h.l.a("SDKConfig file not exist", new java.lang.Object[0]);
            return null;
        }
        java.util.Scanner scanner = new java.util.Scanner(new java.io.FileInputStream(fileJ));
        java.lang.String strNextLine = scanner.nextLine();
        java.lang.String strNextLine2 = scanner.nextLine();
        java.lang.String strNextLine3 = scanner.nextLine();
        scanner.close();
        return new com.qq.gdt.action.b.a(strNextLine, strNextLine2, strNextLine3);
    }

    private java.io.File j() {
        return new java.io.File(l(), b("sdk.conf"));
    }

    private java.io.File k() {
        return new java.io.File(l(), b("sdk.conf.tmp"));
    }

    private java.io.File l() {
        return this.d.getDir("a_gdt_qq_com_conf", 0);
    }

    public java.lang.String a() {
        return this.f;
    }

    public boolean a(java.lang.String str) {
        return this.m.contains(str);
    }

    public boolean a(org.json.JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        java.lang.String strOptString = jSONObject.optString("conf_version");
        java.lang.String strOptString2 = jSONObject.optString(com.tencent.ysdk.shell.framework.request.HttpRequest.PARAM_SIG);
        java.lang.String strOptString3 = jSONObject.optString(com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameFreeloginResponse.HTTP_RESP_PARAM_DATA);
        if (com.qq.gdt.action.h.t.a(strOptString) || com.qq.gdt.action.h.t.a(strOptString2) || com.qq.gdt.action.h.t.a(strOptString3)) {
            return false;
        }
        return a(strOptString, strOptString2, strOptString3);
    }

    public boolean b() {
        return this.e.nextInt(100) < this.i;
    }

    public int c() {
        return this.g;
    }

    public int d() {
        return this.h;
    }

    public boolean e() {
        return this.e.nextInt(100) < this.j;
    }

    public int f() {
        return this.k;
    }

    public int g() {
        return this.l;
    }
}
