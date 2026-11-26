package com.tencent.bugly.opengame.proguard;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.nio.ByteBuffer f396a;
    private java.lang.String b;

    public j() {
        this(128);
    }

    public j(int i) {
        this.b = "GBK";
        this.f396a = java.nio.ByteBuffer.allocate(i);
    }

    private void a(int i) {
        if (this.f396a.remaining() < i) {
            java.nio.ByteBuffer byteBufferAllocate = java.nio.ByteBuffer.allocate((this.f396a.capacity() + i) << 1);
            byteBufferAllocate.put(this.f396a.array(), 0, this.f396a.position());
            this.f396a = byteBufferAllocate;
        }
    }

    private void b(byte b, int i) {
        if (i < 15) {
            this.f396a.put((byte) (b | (i << 4)));
        } else {
            if (i >= 256) {
                throw new com.tencent.bugly.opengame.proguard.b("tag is too large: " + i);
            }
            this.f396a.put((byte) (b | 240));
            this.f396a.put((byte) i);
        }
    }

    public final int a(java.lang.String str) {
        this.b = str;
        return 0;
    }

    public final java.nio.ByteBuffer a() {
        return this.f396a;
    }

    public final void a(byte b, int i) {
        a(3);
        if (b == 0) {
            b((byte) 12, i);
        } else {
            b((byte) 0, i);
            this.f396a.put(b);
        }
    }

    public final void a(int i, int i2) {
        a(6);
        if (i >= -32768 && i <= 32767) {
            a((short) i, i2);
        } else {
            b((byte) 2, i2);
            this.f396a.putInt(i);
        }
    }

    public final void a(long j, int i) {
        a(10);
        if (j >= -2147483648L && j <= 2147483647L) {
            a((int) j, i);
        } else {
            b((byte) 3, i);
            this.f396a.putLong(j);
        }
    }

    public final void a(com.tencent.bugly.opengame.proguard.k kVar, int i) {
        a(2);
        b((byte) 10, i);
        kVar.a(this);
        a(2);
        b((byte) 11, 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void a(java.lang.Object obj, int i) {
        if (obj instanceof java.lang.Byte) {
            a(((java.lang.Byte) obj).byteValue(), i);
            return;
        }
        if (obj instanceof java.lang.Boolean) {
            a(((java.lang.Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0, i);
            return;
        }
        if (obj instanceof java.lang.Short) {
            a(((java.lang.Short) obj).shortValue(), i);
            return;
        }
        if (obj instanceof java.lang.Integer) {
            a(((java.lang.Integer) obj).intValue(), i);
            return;
        }
        if (obj instanceof java.lang.Long) {
            a(((java.lang.Long) obj).longValue(), i);
            return;
        }
        if (obj instanceof java.lang.Float) {
            float fFloatValue = ((java.lang.Float) obj).floatValue();
            a(6);
            b((byte) 4, i);
            this.f396a.putFloat(fFloatValue);
            return;
        }
        if (obj instanceof java.lang.Double) {
            double dDoubleValue = ((java.lang.Double) obj).doubleValue();
            a(10);
            b((byte) 5, i);
            this.f396a.putDouble(dDoubleValue);
            return;
        }
        if (obj instanceof java.lang.String) {
            a((java.lang.String) obj, i);
            return;
        }
        if (obj instanceof java.util.Map) {
            a((java.util.Map) obj, i);
            return;
        }
        if (obj instanceof java.util.List) {
            a((java.util.Collection) obj, i);
            return;
        }
        if (obj instanceof com.tencent.bugly.opengame.proguard.k) {
            a(2);
            b((byte) 10, i);
            ((com.tencent.bugly.opengame.proguard.k) obj).a(this);
            a(2);
            b((byte) 11, 0);
            return;
        }
        if (obj instanceof byte[]) {
            a((byte[]) obj, i);
            return;
        }
        if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            a(8);
            b((byte) 9, i);
            a(zArr.length, 0);
            for (boolean z : zArr) {
                a(z ? (byte) 1 : (byte) 0, 0);
            }
            return;
        }
        if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            a(8);
            b((byte) 9, i);
            a(sArr.length, 0);
            for (short s : sArr) {
                a(s, 0);
            }
            return;
        }
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            a(8);
            b((byte) 9, i);
            a(iArr.length, 0);
            for (int i2 : iArr) {
                a(i2, 0);
            }
            return;
        }
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            a(8);
            b((byte) 9, i);
            a(jArr.length, 0);
            for (long j : jArr) {
                a(j, 0);
            }
            return;
        }
        if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            a(8);
            b((byte) 9, i);
            a(fArr.length, 0);
            for (float f : fArr) {
                a(6);
                b((byte) 4, 0);
                this.f396a.putFloat(f);
            }
            return;
        }
        if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            a(8);
            b((byte) 9, i);
            a(dArr.length, 0);
            for (double d : dArr) {
                a(10);
                b((byte) 5, 0);
                this.f396a.putDouble(d);
            }
            return;
        }
        if (!obj.getClass().isArray()) {
            if (!(obj instanceof java.util.Collection)) {
                throw new com.tencent.bugly.opengame.proguard.b("write object error: unsupport type. " + obj.getClass());
            }
            a((java.util.Collection) obj, i);
            return;
        }
        java.lang.Object[] objArr = (java.lang.Object[]) obj;
        a(8);
        b((byte) 9, i);
        a(objArr.length, 0);
        for (java.lang.Object obj2 : objArr) {
            a(obj2, 0);
        }
    }

    public final void a(java.lang.String str, int i) {
        byte[] bytes;
        try {
            bytes = str.getBytes(this.b);
        } catch (java.io.UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        a(bytes.length + 10);
        if (bytes.length > 255) {
            b((byte) 7, i);
            this.f396a.putInt(bytes.length);
        } else {
            b((byte) 6, i);
            this.f396a.put((byte) bytes.length);
        }
        this.f396a.put(bytes);
    }

    public final void a(java.util.Collection collection, int i) {
        a(8);
        b((byte) 9, i);
        a(collection == null ? 0 : collection.size(), 0);
        if (collection != null) {
            java.util.Iterator it = collection.iterator();
            while (it.hasNext()) {
                a(it.next(), 0);
            }
        }
    }

    public final void a(java.util.Map map, int i) {
        a(8);
        b((byte) 8, i);
        a(map == null ? 0 : map.size(), 0);
        if (map != null) {
            for (java.util.Map.Entry entry : map.entrySet()) {
                a(entry.getKey(), 0);
                a(entry.getValue(), 1);
            }
        }
    }

    public final void a(short s, int i) {
        a(4);
        if (s >= -128 && s <= 127) {
            a((byte) s, i);
        } else {
            b((byte) 1, i);
            this.f396a.putShort(s);
        }
    }

    public final void a(boolean z, int i) {
        a(z ? (byte) 1 : (byte) 0, i);
    }

    public final void a(byte[] bArr, int i) {
        a(bArr.length + 8);
        b((byte) 13, i);
        b((byte) 0, 0);
        a(bArr.length, 0);
        this.f396a.put(bArr);
    }

    public final byte[] b() {
        byte[] bArr = new byte[this.f396a.position()];
        java.lang.System.arraycopy(this.f396a.array(), 0, bArr, 0, this.f396a.position());
        return bArr;
    }
}
