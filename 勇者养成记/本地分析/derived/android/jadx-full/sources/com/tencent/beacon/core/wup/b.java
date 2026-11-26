package com.tencent.beacon.core.wup;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f199a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final byte[] b = new byte[0];
    private java.nio.ByteBuffer c;
    protected java.lang.String d;

    public b() {
        this(128);
    }

    public b(int i) {
        this.d = "GBK";
        this.c = java.nio.ByteBuffer.allocate(i);
    }

    private void a(java.lang.Object[] objArr, int i) {
        a(8);
        b((byte) 9, i);
        a(objArr.length, 0);
        for (java.lang.Object obj : objArr) {
            a(obj, 0);
        }
    }

    public int a(java.lang.String str) {
        this.d = str;
        return 0;
    }

    public java.nio.ByteBuffer a() {
        return this.c;
    }

    public void a(byte b2, int i) {
        a(3);
        if (b2 == 0) {
            b((byte) 12, i);
        } else {
            b((byte) 0, i);
            this.c.put(b2);
        }
    }

    public void a(double d, int i) {
        a(10);
        b((byte) 5, i);
        this.c.putDouble(d);
    }

    public void a(float f, int i) {
        a(6);
        b((byte) 4, i);
        this.c.putFloat(f);
    }

    public void a(int i) {
        if (this.c.remaining() < i) {
            try {
                java.nio.ByteBuffer byteBufferAllocate = java.nio.ByteBuffer.allocate((this.c.capacity() + i) * 2);
                byteBufferAllocate.put(this.c.array(), 0, this.c.position());
                this.c = byteBufferAllocate;
            } catch (java.lang.IllegalArgumentException e) {
                throw e;
            }
        }
    }

    public void a(int i, int i2) {
        a(6);
        if (i >= -32768 && i <= 32767) {
            a((short) i, i2);
        } else {
            b((byte) 2, i2);
            this.c.putInt(i);
        }
    }

    public void a(long j, int i) {
        a(10);
        if (j >= -2147483648L && j <= 2147483647L) {
            a((int) j, i);
        } else {
            b((byte) 3, i);
            this.c.putLong(j);
        }
    }

    public void a(com.tencent.beacon.core.wup.JceStruct jceStruct, int i) {
        a(2);
        b((byte) 10, i);
        jceStruct.writeTo(this);
        a(2);
        b((byte) 11, 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void a(java.lang.Object obj, int i) {
        java.util.Collection collection;
        if (obj instanceof java.lang.Byte) {
            a(((java.lang.Byte) obj).byteValue(), i);
            return;
        }
        if (obj instanceof java.lang.Boolean) {
            a(((java.lang.Boolean) obj).booleanValue(), i);
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
            a(((java.lang.Float) obj).floatValue(), i);
            return;
        }
        if (obj instanceof java.lang.Double) {
            a(((java.lang.Double) obj).doubleValue(), i);
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
            collection = (java.util.List) obj;
        } else {
            if (obj instanceof com.tencent.beacon.core.wup.JceStruct) {
                a((com.tencent.beacon.core.wup.JceStruct) obj, i);
                return;
            }
            if (obj instanceof byte[]) {
                a((byte[]) obj, i);
                return;
            }
            if (obj instanceof boolean[]) {
                a((boolean[]) obj, i);
                return;
            }
            if (obj instanceof short[]) {
                a((short[]) obj, i);
                return;
            }
            if (obj instanceof int[]) {
                a((int[]) obj, i);
                return;
            }
            if (obj instanceof long[]) {
                a((long[]) obj, i);
                return;
            }
            if (obj instanceof float[]) {
                a((float[]) obj, i);
                return;
            }
            if (obj instanceof double[]) {
                a((double[]) obj, i);
                return;
            }
            if (obj.getClass().isArray()) {
                a((java.lang.Object[]) obj, i);
                return;
            } else {
                if (!(obj instanceof java.util.Collection)) {
                    throw new java.lang.RuntimeException("write object error: unsupport type. " + obj.getClass());
                }
                collection = (java.util.Collection) obj;
            }
        }
        a(collection, i);
    }

    public void a(java.lang.String str, int i) {
        byte[] bytes;
        try {
            bytes = str.getBytes(this.d);
        } catch (java.io.UnsupportedEncodingException unused) {
            bytes = str.getBytes(java.nio.charset.Charset.forName("UTF-8"));
        }
        a(bytes.length + 10);
        if (bytes.length > 255) {
            b((byte) 7, i);
            this.c.putInt(bytes.length);
        } else {
            b((byte) 6, i);
            this.c.put((byte) bytes.length);
        }
        this.c.put(bytes);
    }

    public void a(java.util.Collection collection, int i) {
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

    public void a(java.util.Map map, int i) {
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

    public void a(short s, int i) {
        a(4);
        if (s >= -128 && s <= 127) {
            a((byte) s, i);
        } else {
            b((byte) 1, i);
            this.c.putShort(s);
        }
    }

    public void a(boolean z, int i) {
        a(z ? (byte) 1 : (byte) 0, i);
    }

    public void a(byte[] bArr, int i) {
        a(bArr.length + 8);
        b((byte) 13, i);
        b((byte) 0, 0);
        a(bArr.length, 0);
        this.c.put(bArr);
    }

    public void a(double[] dArr, int i) {
        a(8);
        b((byte) 9, i);
        a(dArr.length, 0);
        for (double d : dArr) {
            a(d, 0);
        }
    }

    public void a(float[] fArr, int i) {
        a(8);
        b((byte) 9, i);
        a(fArr.length, 0);
        for (float f : fArr) {
            a(f, 0);
        }
    }

    public void a(int[] iArr, int i) {
        a(8);
        b((byte) 9, i);
        a(iArr.length, 0);
        for (int i2 : iArr) {
            a(i2, 0);
        }
    }

    public void a(long[] jArr, int i) {
        a(8);
        b((byte) 9, i);
        a(jArr.length, 0);
        for (long j : jArr) {
            a(j, 0);
        }
    }

    public void a(short[] sArr, int i) {
        a(8);
        b((byte) 9, i);
        a(sArr.length, 0);
        for (short s : sArr) {
            a(s, 0);
        }
    }

    public void a(boolean[] zArr, int i) {
        a(8);
        b((byte) 9, i);
        a(zArr.length, 0);
        for (boolean z : zArr) {
            a(z, 0);
        }
    }

    public void b(byte b2, int i) {
        if (i < 15) {
            this.c.put((byte) (b2 | (i << 4)));
        } else if (i < 256) {
            this.c.put((byte) (b2 | 240));
            this.c.put((byte) i);
        } else {
            throw new java.lang.RuntimeException("tag is too large: " + i);
        }
    }

    public byte[] b() {
        byte[] bArr = new byte[this.c.position()];
        java.lang.System.arraycopy(this.c.array(), 0, bArr, 0, this.c.position());
        return bArr;
    }
}
