package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class w extends com.unisound.sdk.as {
    private static boolean bB = false;
    private static final int bn = 67;
    java.util.List<java.lang.String> aw;
    private boolean bA;
    private int bC;
    private int bk;
    private int bl;
    private int bm;
    private int bo;
    private int bp;
    private int bq;
    private int br;
    private int bs;
    private int bt;
    private java.util.List<java.lang.Integer> bu;
    private java.lang.String bv;
    private java.lang.String bw;
    private boolean bx;
    private boolean by;
    private boolean bz;

    public w(android.content.Context context) {
        super(context);
        this.bk = 41;
        this.bl = 41;
        this.bm = 3;
        this.bo = 67;
        this.bp = 67;
        this.bq = 67;
        this.br = 67;
        this.bs = 0;
        this.bt = 1000;
        this.bv = "";
        this.bw = null;
        this.bx = true;
        this.by = true;
        this.bz = true;
        this.bA = false;
        this.bC = -1;
        this.aw = new java.util.ArrayList();
    }

    public void D(int i) {
        this.bk = i;
    }

    public void D(boolean z) {
        bB = z;
    }

    public void E(int i) {
        this.bl = i;
    }

    public void E(boolean z) {
        this.bx = z;
    }

    public void F(int i) {
        this.bm = i;
    }

    public void F(boolean z) {
        this.by = z;
    }

    public void G(int i) {
        if (i < 0 || i > 100) {
            com.unisound.common.y.a("FixRecognizerParams", "setWuwWakeupThreshold error , use default threshold");
        } else {
            this.bo = i;
        }
    }

    public void G(boolean z) {
        this.bz = z;
    }

    public void H(int i) {
        if (i < 0 || i > 100) {
            com.unisound.common.y.a("FixRecognizerParams", "setWuwNet0Threshold error , use default threshold");
        } else {
            this.bp = i;
        }
    }

    public void H(boolean z) {
        this.bA = z;
    }

    public void I(int i) {
        if (i < 0 || i > 100) {
            com.unisound.common.y.a("FixRecognizerParams", "setWuwNet1Threshold error , use default threshold");
        } else {
            this.bq = i;
        }
    }

    public void J(int i) {
        if (i < 0 || i > 100) {
            com.unisound.common.y.a("FixRecognizerParams", "setWuwNet2Threshold error , use default threshold");
        } else {
            this.br = i;
        }
    }

    public void K(int i) {
        this.bs = i;
    }

    public void L(int i) {
        this.bt = i;
    }

    public void M(int i) {
        this.bC = i;
    }

    public void a(java.lang.String str, boolean z) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("grammaTag", str);
            jSONObject.put("loadGrammaSuccess", z);
            this.bv = jSONObject.toString().replaceAll("/", "");
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }

    public void a(java.util.List<java.lang.Integer> list) {
        this.bu = list;
    }

    public int aA() {
        return this.bl;
    }

    public int aB() {
        return this.bm;
    }

    public int aC() {
        return this.bo;
    }

    public int aD() {
        return this.bp;
    }

    public int aE() {
        return this.bq;
    }

    public int aF() {
        return this.br;
    }

    public int aG() {
        return this.bs;
    }

    public java.lang.String aH() {
        return this.bw;
    }

    public java.util.List<java.lang.String> aI() {
        return this.aw;
    }

    public boolean aJ() {
        return this.bx;
    }

    public int aK() {
        return this.bt;
    }

    public boolean aL() {
        return this.by;
    }

    public boolean aM() {
        return this.bz;
    }

    public int aN() {
        return this.bC;
    }

    public boolean aO() {
        return this.bA;
    }

    public boolean aw() {
        return bB;
    }

    public java.lang.String ax() {
        return this.bv;
    }

    public int ay() {
        return this.bk;
    }

    public java.util.List<java.lang.Integer> az() {
        return this.bu;
    }

    public void b(java.util.List<java.lang.String> list) {
        this.aw = list;
    }

    public void i(java.lang.String str) {
        this.bw = str;
    }

    public boolean j(java.lang.String str) {
        if (this.aw != null) {
            for (int i = 0; i < this.aw.size(); i++) {
                if (str.equals(this.aw.get(i))) {
                    com.unisound.common.y.c("need oneshot = ", str);
                    return true;
                }
            }
        }
        return false;
    }
}
