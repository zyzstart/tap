package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ax extends com.unisound.sdk.z {
    protected static com.unisound.sdk.ax e;
    private static java.lang.Object g = new java.lang.Object();
    int f;
    private com.unisound.client.IAudioSource h;
    private cn.yunzhisheng.asr.a i;
    private byte[] j;

    public ax(cn.yunzhisheng.asr.a aVar, com.unisound.sdk.au auVar, com.unisound.client.IAudioSource iAudioSource) {
        super(aVar, auVar);
        this.h = null;
        this.f = 0;
        this.i = aVar;
        this.h = iAudioSource;
        e = this;
    }

    public static void n() {
        com.unisound.sdk.ax axVar = e;
        if (axVar != null) {
            axVar.k();
        }
    }

    @Override // com.unisound.sdk.z
    protected boolean a() {
        this.j = new byte[(this.c.c == null || !this.c.c.a() ? !this.c.av() : this.c.c.s() && this.c.c.t()) ? this.c.ai() : this.c.ai() * 2];
        if (this.h.openAudioIn() != 0) {
            return false;
        }
        b(true);
        c(true);
        return true;
    }

    @Override // com.unisound.sdk.z
    protected void b() {
        synchronized (g) {
            b(false);
            this.h.closeAudioIn();
            this.j = null;
            if (e == this) {
                e = null;
            }
        }
    }

    @Override // com.unisound.sdk.z
    protected byte[] c() {
        java.lang.Object[] objArr;
        int length = this.j.length;
        com.unisound.common.y.f("Record Read     ");
        int data = this.h.readData(this.j, length);
        if (this.i.c != null && this.i.c.a() && this.i.c.l()) {
            if (this.i.c.s()) {
                if (this.i.c.k() != 1) {
                    objArr = new java.lang.Object[]{"4mic getOneShotReady != 1"};
                    com.unisound.common.y.c(objArr);
                    return null;
                }
            } else if (this.i.c.j() != 1) {
                objArr = new java.lang.Object[]{"4mic getOneShotReady\t != 1"};
                com.unisound.common.y.c(objArr);
                return null;
            }
        }
        if (com.unisound.common.y.l) {
            com.unisound.common.y.d("RecordingThread:: read = ", java.lang.Integer.valueOf(data), " size = ", java.lang.Integer.valueOf(this.j.length), " first byte ", java.lang.Byte.valueOf(this.j[0]));
        }
        if (data > 0) {
            return java.util.Arrays.copyOfRange(this.j, 0, data);
        }
        if (data == -9) {
            if (com.unisound.common.y.l) {
                com.unisound.common.y.d("RecordingThread:: stop signal received ");
            }
            this.f1576a = true;
            d();
            com.unisound.common.y.c("RecordingThread", "stop signal received");
            return java.util.Arrays.copyOfRange(this.d, 0, 1);
        }
        if (data >= 0) {
            return null;
        }
        this.f1576a = true;
        d();
        i();
        com.unisound.common.y.a("RecordingThread :: read error");
        return java.util.Arrays.copyOfRange(this.d, 0, 1);
    }
}
