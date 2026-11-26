package com.tencent.yybsdk.apkpatch.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class d extends java.util.concurrent.LinkedBlockingQueue {
    public d(int i) {
        super(i);
    }

    @Override // java.util.concurrent.LinkedBlockingQueue, java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean offer(java.lang.Object obj) {
        try {
            super.put(obj);
            return true;
        } catch (java.lang.InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }
}
