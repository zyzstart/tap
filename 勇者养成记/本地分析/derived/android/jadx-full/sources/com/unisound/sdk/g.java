package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f1563a = 0;
    public static final int b = -1;
    private static com.unisound.sdk.ab d;
    private long c = 0;
    private cn.yunzhisheng.asrfix.JniAsrFix e;

    public int a(int i) {
        long j = this.c;
        if (j == 0) {
            com.unisound.common.y.c("compile  setCompileMaxPronunciation fail handle=0");
            return -1;
        }
        int iA = this.e.a(j, i);
        if (iA == 0) {
            com.unisound.common.y.c("compile  setCompileMaxPronunciation ok");
        } else {
            com.unisound.common.y.a("compile  setCompileMaxPronunciation fail code = " + iA);
        }
        return iA;
    }

    public int a(java.lang.String str, java.lang.String str2) {
        return this.e.a(this.c, str, str2);
    }

    public int a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return this.e.a(this.c, str, str2, str3);
    }

    public int a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        if (this.c == 0) {
            com.unisound.common.y.c("compile  compileUserData fail handle=0");
        }
        int iPartialCompileUserData = this.e.partialCompileUserData(this.c, str, str2, str3, str4, str);
        com.unisound.common.y.c("compile  code = ", java.lang.Integer.valueOf(iPartialCompileUserData));
        if (iPartialCompileUserData == 0) {
            com.unisound.common.y.c("compile  compileUserData ok");
            return iPartialCompileUserData;
        }
        if (iPartialCompileUserData == -10) {
            com.unisound.common.y.a("compile compileUserData partialfile error, autofix ok");
            return 0;
        }
        com.unisound.common.y.a("compile  compileUserData fail code = " + iPartialCompileUserData);
        return iPartialCompileUserData;
    }

    public int a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        return this.e.a(str, str2, str3, str4, str5, str);
    }

    public void a(com.unisound.sdk.ab abVar) {
        d = abVar;
    }

    public boolean a() {
        return this.c != 0;
    }

    public boolean a(java.lang.String str) {
        this.e = cn.yunzhisheng.asrfix.JniAsrFix.a();
        this.c = this.e.initUserDataCompiler(str);
        if (com.unisound.common.y.l) {
            com.unisound.common.y.c("compile  initUserDataCompiler handle=", java.lang.Long.valueOf(this.c), "path = ", str);
        } else {
            com.unisound.common.y.c("compile  initUserDataCompiler handle=", java.lang.Long.valueOf(this.c));
        }
        long j = this.c;
        return j != 0 || j == 0;
    }

    public int b(int i) {
        long j = this.c;
        if (j == 0) {
            com.unisound.common.y.c("compile  setCompileOverMaxPronunciationInsertAction fail handle=0");
            return -1;
        }
        int iB = this.e.b(j, i);
        if (iB == 0) {
            com.unisound.common.y.c("compile  setCompileOverMaxPronunciationInsertAction ok");
        } else {
            com.unisound.common.y.a("compile  setCompileOverMaxPronunciationInsertAction fail code = " + iB);
        }
        return iB;
    }

    public int b(java.lang.String str) {
        return this.e.unloadGrammar(str);
    }

    public void b() {
        if (this.c != 0) {
            com.unisound.common.y.c("compile  destroyUserDataCompiler");
            this.e.destroyUserDataCompiler(this.c);
            this.e.v();
            this.c = 0L;
        }
    }

    public java.lang.String c() {
        long j = this.c;
        if (j != 0) {
            return this.e.a(j);
        }
        com.unisound.common.y.c("compile  getCompileErrorDetailInfo fail handle=0");
        return "";
    }
}
