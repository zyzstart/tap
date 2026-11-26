package com.unisound.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class al {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static java.lang.String f1471a = "http://10.30.2.13:8089/data-process-service/rtc";
    private static int b = 6;
    private java.util.List<com.unisound.common.ak> c = new java.util.ArrayList();
    private com.unisound.sdk.as d;

    private int b() {
        for (int i = 1; i < b; i++) {
            if (b(i) == null) {
                return i;
            }
        }
        return -1;
    }

    private com.unisound.common.ak b(int i) {
        if (i == -1) {
            return null;
        }
        for (com.unisound.common.ak akVar : this.c) {
            if (akVar.c() == i) {
                return akVar;
            }
        }
        return null;
    }

    private com.unisound.common.ak c(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        com.unisound.common.ak akVarA = a(str);
        if (akVarA != null) {
            return akVarA;
        }
        int iB = b();
        if (iB == -1) {
            return null;
        }
        com.unisound.common.ak akVar = new com.unisound.common.ak(iB, str);
        this.c.add(akVar);
        return akVar;
    }

    public int a() {
        return this.c.size();
    }

    public com.unisound.common.ak a(int i) {
        if (this.c.size() <= i || i <= -1) {
            return null;
        }
        return this.c.get(i);
    }

    public com.unisound.common.ak a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.unisound.common.ak akVar : this.c) {
            if (akVar.b().equals(str)) {
                return akVar;
            }
        }
        return null;
    }

    public com.unisound.common.ax a(java.lang.String str, java.util.List<java.lang.String> list, com.unisound.common.am amVar) {
        com.unisound.common.ax axVar = new com.unisound.common.ax();
        axVar.a(f1471a);
        com.unisound.common.ak akVarA = a(str);
        com.unisound.client.ErrorCode errorCode = new com.unisound.client.ErrorCode();
        if (akVarA == null) {
            if (a() >= b) {
                amVar.a(axVar, errorCode.createProfessionError(com.unisound.client.ErrorCode.UPLOAD_SCENE_OUT_MAX_COUNT));
                return axVar;
            }
            akVarA = c(str);
            if (akVarA == null) {
                amVar.a(axVar, errorCode.createProfessionError(com.unisound.client.ErrorCode.UPLOAD_SCENE_OUT_MAX_COUNT));
                return axVar;
            }
        }
        axVar.a(this.d.aZ(), akVarA, list);
        axVar.a(amVar);
        return axVar;
    }

    public void a(com.unisound.common.ak akVar) {
        java.util.Iterator<com.unisound.common.ak> it = this.c.iterator();
        while (it.hasNext()) {
            if (it.next() == akVar) {
                this.c.remove(akVar);
            }
        }
    }

    public void a(com.unisound.sdk.as asVar) {
        this.d = asVar;
    }

    public void a(java.lang.String str, int i) {
        f1471a = "http://" + str + ":" + i + "/data-process-service/rtc";
    }

    public void b(java.lang.String str) {
        com.unisound.common.ak akVarA = a(str);
        if (akVarA != null) {
            a(akVarA);
        }
    }
}
