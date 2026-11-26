package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class as extends cn.yunzhisheng.asr.a {
    public static java.lang.String aA = "poi";
    public static final java.lang.String aB = "en";
    public static final java.lang.String aC = "co";
    public static final java.lang.String aD = "cn";
    public static final java.lang.String aE = "oral";
    public static final java.lang.String aF = "cn_en_mix";
    public static final int aL = 1;
    public static final int aM = 2;
    public static final int aN = 3;
    public static final int aO = 4;
    public static final int aP = 1;
    public static final int aQ = 4;
    public static final int aR = 8;
    public static final int aS = 5;
    public static final int aT = 9;
    public static final int aU = 12;
    public static final int aV = 13;
    private static com.unisound.common.a aw = new com.unisound.common.a(com.unisound.sdk.aq.f1521a);
    public static java.lang.String ay = "http://u.hivoice.cn:8081/casr/upload";
    public static java.lang.String az = "general";
    public boolean aG;
    public boolean aH;
    public boolean aI;
    public boolean aJ;
    public boolean aK;
    public int aW;
    public boolean aX;
    public int aY;
    int aZ;
    public final java.lang.String ax;
    private java.lang.String bA;
    private com.unisound.sdk.i bB;
    private boolean bC;
    private com.unisound.common.ak bD;
    private com.unisound.common.ak bE;
    private com.unisound.sdk.cm bF;
    private com.unisound.sdk.cu bG;
    private boolean bH;
    int ba;
    int bb;
    int bc;
    int bd;
    public int be;
    public int bf;
    public boolean bg;
    public java.lang.String bh;
    java.lang.String bi;
    java.lang.String bj;
    private boolean bk;
    private java.lang.String bl;
    private java.lang.String bm;
    private java.lang.String bn;
    private java.lang.String bo;
    private java.lang.String bp;
    private java.lang.String bq;
    private long br;
    private long bs;
    private int bt;
    private java.lang.String bu;
    private boolean bv;
    private boolean bw;
    private int bx;
    private java.lang.String by;
    private java.lang.String bz;

    public as(android.content.Context context) {
        super(context);
        this.ax = "/USCService/WebApi";
        this.aG = false;
        this.aH = false;
        this.aI = true;
        this.aJ = true;
        this.aK = true;
        this.bk = true;
        this.aW = 0;
        this.aX = false;
        this.aY = 0;
        this.bl = "";
        this.bm = "";
        this.bn = "";
        this.bo = "";
        this.bp = null;
        this.bq = null;
        this.br = 0L;
        this.bs = 0L;
        this.bt = 0;
        this.bu = "";
        this.bv = false;
        this.bw = false;
        this.aZ = 0;
        this.ba = 8;
        this.bb = 1;
        this.bc = 3000;
        this.bd = 20;
        this.by = "";
        this.bz = null;
        this.bA = "";
        this.bB = new com.unisound.sdk.i();
        this.bC = false;
        this.bD = new com.unisound.common.ak(-1, "");
        this.bE = new com.unisound.common.ak(-1, "");
        this.bF = new com.unisound.sdk.cm();
        this.bG = new com.unisound.sdk.cu();
        this.be = 1;
        this.bf = 16000;
        this.bg = false;
        this.bh = "";
        this.bi = "";
        this.bj = "";
        this.bH = true;
    }

    public void A(java.lang.String str) {
        if (str != null) {
            java.lang.String[] strArrSplit = str.split("=");
            if (strArrSplit.length != 2) {
                com.unisound.common.y.c("engineParma ->set serviceParam error");
            } else {
                this.bB.a(strArrSplit[0], strArrSplit[1]);
            }
        }
    }

    public void B(java.lang.String str) {
        com.unisound.sdk.cq.f1556a = "http://" + str + "/casr/upload";
    }

    public void C(java.lang.String str) {
        com.unisound.sdk.cq.f1556a = str;
    }

    public void D(java.lang.String str) {
        this.bo = str;
    }

    public void E(java.lang.String str) {
        this.bp = str;
    }

    public void F(java.lang.String str) {
        if (str == null) {
            str = "";
        }
        this.by = str;
    }

    public void G(java.lang.String str) {
        this.bB.i(str);
        com.unisound.common.y.c("RecognizerParams:setProductLine do ", str);
    }

    public void H(java.lang.String str) {
        this.bq = str;
    }

    public void I(java.lang.String str) {
        this.bh = str;
    }

    public void I(boolean z) {
        this.bC = z;
    }

    public void J(boolean z) {
        this.aX = z;
    }

    public void K(boolean z) {
        this.bk = z;
    }

    public void L(boolean z) {
        this.bB.d(z ? com.unisound.sdk.i.d : com.unisound.sdk.i.e);
    }

    public void M(boolean z) {
        g(z);
    }

    public void N(int i) {
        this.bf = i;
    }

    public void N(boolean z) {
        this.aH = z;
    }

    public void O(int i) {
        this.be = i;
        if (i == 8 || i == 12 || i == 9 || i == 13) {
            this.bG.b(true);
        } else {
            this.bG.b(false);
        }
        this.bB.a(true);
    }

    public void O(boolean z) {
        this.bB.d(z);
    }

    public void P(boolean z) {
        this.bB.e(z);
    }

    public boolean P(int i) {
        if (!this.bB.a(i)) {
            return false;
        }
        super.C(i);
        return true;
    }

    public void Q(int i) {
        this.bt = i;
    }

    public void Q(boolean z) {
        this.bB.f(z);
    }

    public void R(int i) {
        this.bx = i;
    }

    public void R(boolean z) {
        this.bB.h(z);
    }

    public void S(int i) {
        this.bB.b(i);
    }

    public void S(boolean z) {
        this.bg = z;
    }

    public void T(int i) {
        this.bB.c(i);
    }

    public void T(boolean z) {
        this.bH = z;
        this.bB.g(z);
        com.unisound.common.y.c("RecognizerParams:setPunctuated ", java.lang.Boolean.valueOf(z));
    }

    public void U(boolean z) {
        this.bv = z;
    }

    public void V(boolean z) {
        this.bw = z;
    }

    public void a(com.unisound.common.ak akVar) {
        this.bD.a(akVar);
        this.bE.a(akVar);
    }

    public void a(com.unisound.sdk.at atVar) {
        if (atVar == com.unisound.sdk.at.VPR) {
            this.bB.a(false);
            this.bF.a(false);
            this.bG.b(true);
        } else if (atVar == com.unisound.sdk.at.ASR_NLU) {
            this.bB.a(true);
            this.bG.b(false);
            this.bF.a(true);
        } else {
            this.bB.a(false);
            this.bF.a(false);
            this.bG.b(false);
        }
    }

    void a(java.lang.String str, int i) {
        aw.b(str);
        aw.b(i);
    }

    public int aP() {
        return this.bf;
    }

    public int aQ() {
        return this.be;
    }

    public boolean aR() {
        return this.bC;
    }

    public java.lang.String aS() {
        return this.bi;
    }

    public java.lang.String aT() {
        return this.bj;
    }

    public java.lang.String aU() {
        return this.bA;
    }

    public java.lang.String aV() {
        return this.bz;
    }

    public com.unisound.sdk.cu aW() {
        return this.bG;
    }

    public com.unisound.sdk.cm aX() {
        return this.bF;
    }

    public com.unisound.common.ak aY() {
        return this.bD;
    }

    public java.lang.String aZ() {
        return this.bl;
    }

    void b(java.lang.String str, int i) {
        aw.a(str);
        aw.a(i);
        com.unisound.common.y.c("RecognizerParams:setDefaultServer server ", str, ",port ", java.lang.Integer.valueOf(i));
    }

    public com.unisound.sdk.i ba() {
        return this.bB;
    }

    com.unisound.common.a bb() {
        return aw;
    }

    void bc() {
        aw.e();
    }

    public boolean bd() {
        return this.bk;
    }

    public int be() {
        return this.bB.f();
    }

    public boolean bf() {
        return this.aH;
    }

    public com.unisound.common.ak bg() {
        return this.bE;
    }

    public boolean bh() {
        return this.aI;
    }

    public java.lang.String bi() {
        return this.bm;
    }

    public java.lang.String bj() {
        return this.bn;
    }

    public long bk() {
        return this.br;
    }

    public long bl() {
        return this.bs;
    }

    public long bm() {
        long j = this.bs - this.br;
        if (j >= 3600000 || j <= 0) {
            return 0L;
        }
        return j;
    }

    public int bn() {
        return this.bt;
    }

    public java.lang.String bo() {
        return this.bu;
    }

    public java.lang.String bp() {
        return com.unisound.sdk.cq.f1556a;
    }

    public java.lang.String bq() {
        return this.bo;
    }

    public java.lang.String br() {
        return this.bp;
    }

    public java.lang.String bs() {
        return this.by;
    }

    public int bt() {
        return this.bx;
    }

    public java.lang.String bu() {
        return this.bq;
    }

    public boolean bv() {
        return this.bg;
    }

    public java.lang.String bw() {
        return this.bh;
    }

    public boolean bx() {
        return this.bH;
    }

    public boolean by() {
        return this.bv;
    }

    public boolean bz() {
        return this.bw;
    }

    @Override // cn.yunzhisheng.asr.a
    public void d(java.lang.String str) {
        super.d(str);
        this.bB.f(str);
        this.bF.p(f(str));
    }

    public void j(long j) {
        this.br = j;
    }

    public void k(long j) {
        this.bs = j;
    }

    public void k(java.lang.String str) {
        this.bi = str;
    }

    public void l(java.lang.String str) {
        this.bj = str;
    }

    public void m(java.lang.String str) {
        this.bA = str;
    }

    public void n(java.lang.String str) {
        this.bz = str;
    }

    public void o(java.lang.String str) {
        this.bl = str;
    }

    public void p(java.lang.String str) {
        if (str == null) {
            com.unisound.common.y.a("RecognizerParams:setLanguage error language == null ");
            return;
        }
        com.unisound.common.y.c("RecognizerParams:setLanguage in ", str);
        aw.a(com.unisound.sdk.aq.a(str));
        this.af = false;
        com.unisound.sdk.cq.f1556a = ay;
        if (str.equals("en") || str.equals("co") || str.equals(aE)) {
            return;
        }
        if (!str.equals(aF)) {
            com.unisound.common.y.c("RecognizerParams:setLanguage do ", "cn");
            return;
        }
        com.unisound.sdk.cq.f1556a = "http://" + aw.b() + ":9006/casr/upload";
    }

    public void q(java.lang.String str) {
        this.bB.a(str);
        com.unisound.common.y.c("RecognizerParams:setLanguage do ", str);
    }

    public boolean r(java.lang.String str) {
        return this.bB.b(str);
    }

    public boolean s(java.lang.String str) {
        return this.bB.c(str);
    }

    public boolean t(java.lang.String str) {
        if (str == null) {
            return false;
        }
        java.lang.String[] strArrSplit = str.split(":");
        if (strArrSplit.length != 2 || strArrSplit[0].length() == 0) {
            return false;
        }
        try {
            short sIntValue = (short) java.lang.Integer.valueOf(strArrSplit[1]).intValue();
            a(strArrSplit[0], sIntValue);
            b(strArrSplit[0], sIntValue);
            return true;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean u(java.lang.String str) {
        if (str == null) {
            return false;
        }
        java.lang.String[] strArrSplit = str.split(":");
        if (strArrSplit.length != 2 || strArrSplit[0].length() == 0) {
            return false;
        }
        try {
            com.unisound.sdk.cp.f1555a = "http://" + strArrSplit[0] + ":" + ((int) ((short) java.lang.Integer.valueOf(strArrSplit[1]).intValue()));
            return true;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void v(java.lang.String str) {
        this.bB.d(str);
    }

    public void w(java.lang.String str) {
        this.bm = str;
    }

    public void x(java.lang.String str) {
        if (str.equals("")) {
            str = com.unisound.c.a.q + java.lang.System.currentTimeMillis();
        }
        this.bn = str;
    }

    public void y(java.lang.String str) {
        this.bu = str;
    }

    public void z(java.lang.String str) {
        this.bB.h(str);
    }
}
