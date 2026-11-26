package com.tencent.yybsdk.apkpatch.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.util.concurrent.LinkedBlockingQueue f1399a = new java.util.concurrent.LinkedBlockingQueue(3);
    private java.util.concurrent.LinkedBlockingQueue b = null;
    private java.util.concurrent.LinkedBlockingQueue c = new java.util.concurrent.LinkedBlockingQueue(3);
    private java.util.concurrent.LinkedBlockingQueue d = new java.util.concurrent.LinkedBlockingQueue(3);
    private java.util.concurrent.LinkedBlockingQueue e = new java.util.concurrent.LinkedBlockingQueue(3);
    private java.util.concurrent.LinkedBlockingQueue f = new java.util.concurrent.LinkedBlockingQueue(3);
    private com.tencent.yybsdk.apkpatch.t g;

    public b(com.tencent.yybsdk.apkpatch.t tVar) throws java.lang.InterruptedException {
        this.g = tVar;
        for (int i = 0; i < 3; i++) {
            this.f1399a.put(new java.io.RandomAccessFile(tVar.b(), "rw"));
            this.c.put(new java.io.RandomAccessFile(tVar.c(), "rw"));
            this.d.put(new com.tencent.yybsdk.apkpatch.a.b(tVar.a()));
            this.e.put(new java.util.zip.Inflater(true));
            this.f.put(new java.util.zip.Deflater(6, true));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized com.tencent.yybsdk.apkpatch.a.b a() {
        if (this.b == null) {
            this.b = new java.util.concurrent.LinkedBlockingQueue(3);
            for (int i = 0; i < 3; i++) {
                this.b.put(new com.tencent.yybsdk.apkpatch.a.b(this.g.d()));
            }
        }
        return (com.tencent.yybsdk.apkpatch.a.b) this.b.take();
    }

    public void a(com.tencent.yybsdk.apkpatch.a.b bVar) throws java.lang.InterruptedException {
        this.b.put(bVar);
    }

    public void a(java.io.RandomAccessFile randomAccessFile) throws java.lang.InterruptedException {
        this.f1399a.put(randomAccessFile);
    }

    public void a(java.util.zip.Deflater deflater) throws java.lang.InterruptedException {
        this.f.put(deflater);
    }

    public void a(java.util.zip.Inflater inflater) throws java.lang.InterruptedException {
        this.e.put(inflater);
    }

    public java.util.zip.Inflater b() {
        return (java.util.zip.Inflater) this.e.take();
    }

    public void b(com.tencent.yybsdk.apkpatch.a.b bVar) throws java.lang.InterruptedException {
        this.d.put(bVar);
    }

    public void b(java.io.RandomAccessFile randomAccessFile) throws java.lang.InterruptedException {
        this.c.put(randomAccessFile);
    }

    public java.util.zip.Deflater c() {
        return (java.util.zip.Deflater) this.f.take();
    }

    public java.io.RandomAccessFile d() {
        return (java.io.RandomAccessFile) this.f1399a.take();
    }

    public java.io.RandomAccessFile e() {
        return (java.io.RandomAccessFile) this.c.take();
    }

    public com.tencent.yybsdk.apkpatch.a.b f() {
        return (com.tencent.yybsdk.apkpatch.a.b) this.d.take();
    }

    public void g() {
        try {
            if (this.d != null && this.d.size() > 0) {
                java.util.Iterator it = this.d.iterator();
                while (it.hasNext()) {
                    ((com.tencent.yybsdk.apkpatch.a.b) it.next()).close();
                }
                this.d.clear();
            }
            if (this.c != null && this.c.size() > 0) {
                java.util.Iterator it2 = this.c.iterator();
                while (it2.hasNext()) {
                    ((java.io.RandomAccessFile) it2.next()).close();
                }
                this.c.clear();
            }
            if (this.e == null || this.e.size() <= 0) {
                return;
            }
            java.util.Iterator it3 = this.e.iterator();
            while (it3.hasNext()) {
                ((java.util.zip.Inflater) it3.next()).end();
            }
            this.e.clear();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void h() {
        try {
            if (this.f1399a != null && this.f1399a.size() > 0) {
                java.util.Iterator it = this.f1399a.iterator();
                while (it.hasNext()) {
                    ((java.io.RandomAccessFile) it.next()).close();
                }
                this.f1399a.clear();
            }
            if (this.b != null && this.b.size() > 0) {
                java.util.Iterator it2 = this.b.iterator();
                while (it2.hasNext()) {
                    ((com.tencent.yybsdk.apkpatch.a.b) it2.next()).close();
                }
                this.b.clear();
            }
            if (this.f == null || this.f.size() <= 0) {
                return;
            }
            java.util.Iterator it3 = this.f.iterator();
            while (it3.hasNext()) {
                ((java.util.zip.Deflater) it3.next()).end();
            }
            this.f.clear();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void i() {
        g();
        h();
    }
}
