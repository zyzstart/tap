package com.qq.gdt.action.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.nio.MappedByteBuffer f77a;
    private final java.lang.Class b;
    private final java.nio.channels.FileChannel c;
    private java.util.List<com.qq.gdt.action.c.a> d = new java.util.LinkedList();
    private int e;

    f(java.lang.String str, java.lang.Class<? extends com.qq.gdt.action.c.a> cls) throws java.io.IOException {
        this.b = cls;
        boolean z = false;
        java.io.File file = new java.io.File(com.qq.gdt.action.e.a().c().getDir(com.qq.gdt.action.c.b.f74a, 0), str);
        boolean zExists = file.exists();
        long j = android.support.v4.media.session.PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        if (zExists && file.length() > 0 && file.length() % android.support.v4.media.session.PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED == 0) {
            z = true;
        }
        if (!z) {
            file.delete();
        }
        this.c = new java.io.RandomAccessFile(file, "rw").getChannel();
        this.f77a = this.c.map(java.nio.channels.FileChannel.MapMode.READ_WRITE, 0L, z ? file.length() : j);
        this.f77a.order(java.nio.ByteOrder.BIG_ENDIAN);
        if (!z) {
            this.f77a.putInt(666);
        } else {
            if (666 == this.f77a.getInt()) {
                b();
                return;
            }
            throw new com.qq.gdt.action.c.g("malformed buffer file :" + str);
        }
    }

    private java.util.List<com.qq.gdt.action.c.a> b() {
        this.d.clear();
        while (true) {
            com.qq.gdt.action.c.a aVarC = c();
            if (aVarC == null) {
                return this.d;
            }
            this.d.add(aVarC);
        }
    }

    private boolean b(int i) {
        return i <= this.f77a.remaining();
    }

    private com.qq.gdt.action.c.a c() {
        if (!b(6)) {
            return null;
        }
        int iPosition = this.f77a.position();
        int i = this.f77a.getInt();
        short s = this.f77a.getShort();
        if (i >= 0 && s >= 1 && s <= 2) {
            if (s != 1) {
                int i2 = i + 4 + 2;
                this.e += i2;
                int i3 = i2 + iPosition;
                if (i3 <= this.f77a.limit()) {
                    this.f77a.position(i3);
                    return c();
                }
            } else {
                try {
                    com.qq.gdt.action.c.a aVar = (com.qq.gdt.action.c.a) this.b.newInstance();
                    aVar.a(iPosition);
                    byte[] bArr = new byte[i];
                    this.f77a.get(bArr);
                    aVar.a(new com.qq.gdt.action.c.c(bArr));
                    return aVar;
                } catch (java.lang.IllegalAccessException | java.lang.InstantiationException | java.nio.BufferUnderflowException unused) {
                }
            }
        }
        this.f77a.position(iPosition);
        return null;
    }

    private void d() {
        if (this.e > 0) {
            this.f77a.clear();
            java.nio.MappedByteBuffer mappedByteBuffer = this.f77a;
            mappedByteBuffer.put(new byte[mappedByteBuffer.limit()]);
            this.f77a.clear();
            this.f77a.putInt(666);
            java.util.Iterator<com.qq.gdt.action.c.a> it = this.d.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            this.e = 0;
        }
    }

    public java.util.List<com.qq.gdt.action.c.a> a() {
        return this.d;
    }

    public void a(int i) {
        int iRemaining = this.f77a.remaining();
        if (i > iRemaining) {
            if (i <= iRemaining + this.e) {
                d();
                return;
            }
            int iCapacity = this.f77a.capacity();
            int iPosition = this.f77a.position();
            while (iCapacity - iPosition < i) {
                iCapacity *= 2;
            }
            this.f77a.force();
            try {
                this.f77a = this.c.map(java.nio.channels.FileChannel.MapMode.READ_WRITE, 0L, iCapacity);
                this.f77a.order(java.nio.ByteOrder.BIG_ENDIAN);
                this.f77a.position(iPosition);
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void a(com.qq.gdt.action.c.a aVar) {
        if (aVar != null) {
            byte[] bArrC = aVar.a().c();
            int length = bArrC.length;
            a(bArrC.length + 4 + 2);
            aVar.a(this.f77a.position());
            this.f77a.putInt(length).putShort((short) 1).put(bArrC);
        }
    }

    public boolean b(com.qq.gdt.action.c.a aVar) {
        if (aVar == null || aVar.b() <= 0 || aVar.b() + 4 + 2 > this.f77a.limit()) {
            return false;
        }
        int iPosition = this.f77a.position();
        this.f77a.position(aVar.b());
        int i = this.f77a.getInt();
        this.f77a.putShort((short) 2);
        this.f77a.position(iPosition);
        this.e += i + 4 + 2;
        return true;
    }
}
