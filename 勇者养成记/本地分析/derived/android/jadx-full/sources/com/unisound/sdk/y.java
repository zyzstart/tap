package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class y extends com.unisound.sdk.z {
    private static final int f = 50;
    private java.util.concurrent.BlockingQueue<byte[]> e;

    public y(cn.yunzhisheng.asr.a aVar, com.unisound.sdk.au auVar) {
        super(aVar, auVar, true);
        this.e = new java.util.concurrent.LinkedBlockingQueue();
    }

    @Override // com.unisound.sdk.z
    protected boolean a() {
        this.e.clear();
        return true;
    }

    @Override // com.unisound.sdk.z
    protected void b() {
    }

    @Override // com.unisound.sdk.z
    protected byte[] c() {
        byte[] bArrPoll;
        while (!e() && !f()) {
            try {
                bArrPoll = this.e.poll(50L, java.util.concurrent.TimeUnit.MILLISECONDS);
            } catch (java.lang.InterruptedException e) {
                e.printStackTrace();
                bArrPoll = null;
            }
            if (bArrPoll != null) {
                byte[] bArr = new byte[bArrPoll.length];
                return bArrPoll;
            }
        }
        return null;
    }
}
