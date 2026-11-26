package com.tencent.ydkbeacon.pack;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.nio.ByteBuffer f1275a;
    protected java.lang.String b = "GBK";

    /* JADX INFO: renamed from: com.tencent.ydkbeacon.pack.a$a, reason: collision with other inner class name */
    public static class C0045a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte f1276a;
        public int b;
    }

    public a() {
    }

    public a(byte[] bArr) {
        this.f1275a = java.nio.ByteBuffer.wrap(bArr);
    }

    public a(byte[] bArr, int i) {
        java.nio.ByteBuffer byteBufferWrap = java.nio.ByteBuffer.wrap(bArr);
        this.f1275a = byteBufferWrap;
        byteBufferWrap.position(i);
    }

    public static int a(com.tencent.ydkbeacon.pack.a.C0045a c0045a, java.nio.ByteBuffer byteBuffer) {
        byte b = byteBuffer.get();
        c0045a.f1276a = (byte) (b & 15);
        int i = (b & 240) >> 4;
        c0045a.b = i;
        if (i != 15) {
            return 1;
        }
        c0045a.b = byteBuffer.get() & 255;
        return 2;
    }

    private java.util.Map a(java.util.Map map, java.util.Map map2, int i, boolean z) {
        if (map2 == null || map2.isEmpty()) {
            return new java.util.HashMap();
        }
        java.util.Map.Entry entry = (java.util.Map.Entry) map2.entrySet().iterator().next();
        java.lang.Object key = entry.getKey();
        java.lang.Object value = entry.getValue();
        if (a(i)) {
            com.tencent.ydkbeacon.pack.a.C0045a c0045a = new com.tencent.ydkbeacon.pack.a.C0045a();
            a(c0045a);
            if (c0045a.f1276a != 8) {
                throw new java.lang.RuntimeException("type mismatch.");
            }
            int iA = a(0, 0, true);
            if (iA < 0) {
                throw new java.lang.RuntimeException("size invalid: " + iA);
            }
            for (int i2 = 0; i2 < iA; i2++) {
                map.put(a(key, 0, true), a(value, 1, true));
            }
        } else if (z) {
            throw new java.lang.RuntimeException("require field not exist.");
        }
        return map;
    }

    private void a(byte b) {
        int iA;
        int i = 0;
        switch (b) {
            case 0:
                b(1);
                return;
            case 1:
                b(2);
                return;
            case 2:
            case 4:
                iA = 4;
                break;
            case 3:
            case 5:
                iA = 8;
                break;
            case 6:
                iA = this.f1275a.get();
                if (iA < 0) {
                    iA += 256;
                }
                break;
            case 7:
                iA = this.f1275a.getInt();
                break;
            case 8:
                int iA2 = a(0, 0, true);
                while (i < iA2 * 2) {
                    b();
                    i++;
                }
                return;
            case 9:
                int iA3 = a(0, 0, true);
                while (i < iA3) {
                    b();
                    i++;
                }
                return;
            case 10:
                a();
                return;
            case 11:
            case 12:
                return;
            case 13:
                com.tencent.ydkbeacon.pack.a.C0045a c0045a = new com.tencent.ydkbeacon.pack.a.C0045a();
                a(c0045a);
                if (c0045a.f1276a != 0) {
                    throw new java.lang.RuntimeException("skipField with invalid type, type value: " + ((int) b) + ", " + ((int) c0045a.f1276a));
                }
                iA = a(0, 0, true);
                break;
                break;
            default:
                throw new java.lang.RuntimeException("invalid type.");
        }
        b(iA);
    }

    private int b(com.tencent.ydkbeacon.pack.a.C0045a c0045a) {
        return a(c0045a, this.f1275a.duplicate());
    }

    private void b() {
        com.tencent.ydkbeacon.pack.a.C0045a c0045a = new com.tencent.ydkbeacon.pack.a.C0045a();
        a(c0045a);
        a(c0045a.f1276a);
    }

    private void b(int i) {
        java.nio.ByteBuffer byteBuffer = this.f1275a;
        byteBuffer.position(byteBuffer.position() + i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private java.lang.Object[] b(java.lang.Object obj, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new java.lang.RuntimeException("require field not exist.");
            }
            return null;
        }
        com.tencent.ydkbeacon.pack.a.C0045a c0045a = new com.tencent.ydkbeacon.pack.a.C0045a();
        a(c0045a);
        if (c0045a.f1276a != 9) {
            throw new java.lang.RuntimeException("type mismatch.");
        }
        int iA = a(0, 0, true);
        if (iA < 0) {
            throw new java.lang.RuntimeException("size invalid: " + iA);
        }
        java.lang.Object[] objArr = (java.lang.Object[]) java.lang.reflect.Array.newInstance(obj.getClass(), iA);
        for (int i2 = 0; i2 < iA; i2++) {
            objArr[i2] = a(obj, 0, true);
        }
        return objArr;
    }

    public byte a(byte b, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new java.lang.RuntimeException("require field not exist.");
            }
            return b;
        }
        com.tencent.ydkbeacon.pack.a.C0045a c0045a = new com.tencent.ydkbeacon.pack.a.C0045a();
        a(c0045a);
        byte b2 = c0045a.f1276a;
        if (b2 == 0) {
            return this.f1275a.get();
        }
        if (b2 == 12) {
            return (byte) 0;
        }
        throw new java.lang.RuntimeException("type mismatch.");
    }

    public double a(double d, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new java.lang.RuntimeException("require field not exist.");
            }
            return d;
        }
        com.tencent.ydkbeacon.pack.a.C0045a c0045a = new com.tencent.ydkbeacon.pack.a.C0045a();
        a(c0045a);
        byte b = c0045a.f1276a;
        if (b == 4) {
            return this.f1275a.getFloat();
        }
        if (b == 5) {
            return this.f1275a.getDouble();
        }
        if (b == 12) {
            return 0.0d;
        }
        throw new java.lang.RuntimeException("type mismatch.");
    }

    public float a(float f, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new java.lang.RuntimeException("require field not exist.");
            }
            return f;
        }
        com.tencent.ydkbeacon.pack.a.C0045a c0045a = new com.tencent.ydkbeacon.pack.a.C0045a();
        a(c0045a);
        byte b = c0045a.f1276a;
        if (b == 4) {
            return this.f1275a.getFloat();
        }
        if (b == 12) {
            return 0.0f;
        }
        throw new java.lang.RuntimeException("type mismatch.");
    }

    public int a(int i, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new java.lang.RuntimeException("require field not exist.");
            }
            return i;
        }
        com.tencent.ydkbeacon.pack.a.C0045a c0045a = new com.tencent.ydkbeacon.pack.a.C0045a();
        a(c0045a);
        byte b = c0045a.f1276a;
        if (b == 0) {
            return this.f1275a.get();
        }
        if (b == 1) {
            return this.f1275a.getShort();
        }
        if (b == 2) {
            return this.f1275a.getInt();
        }
        if (b == 12) {
            return 0;
        }
        throw new java.lang.RuntimeException("type mismatch.");
    }

    public int a(java.lang.String str) {
        this.b = str;
        return 0;
    }

    public long a(long j, int i, boolean z) {
        int i2;
        if (!a(i)) {
            if (z) {
                throw new java.lang.RuntimeException("require field not exist.");
            }
            return j;
        }
        com.tencent.ydkbeacon.pack.a.C0045a c0045a = new com.tencent.ydkbeacon.pack.a.C0045a();
        a(c0045a);
        byte b = c0045a.f1276a;
        if (b == 12) {
            return 0L;
        }
        switch (b) {
            case 0:
                i2 = this.f1275a.get();
                break;
            case 1:
                i2 = this.f1275a.getShort();
                break;
            case 2:
                i2 = this.f1275a.getInt();
                break;
            case 3:
                return this.f1275a.getLong();
            default:
                throw new java.lang.RuntimeException("type mismatch.");
        }
        return i2;
    }

    public com.tencent.ydkbeacon.pack.JceStruct a(com.tencent.ydkbeacon.pack.JceStruct jceStruct, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new java.lang.RuntimeException("require field not exist.");
            }
            return null;
        }
        try {
            com.tencent.ydkbeacon.pack.JceStruct jceStruct2 = (com.tencent.ydkbeacon.pack.JceStruct) jceStruct.getClass().newInstance();
            com.tencent.ydkbeacon.pack.a.C0045a c0045a = new com.tencent.ydkbeacon.pack.a.C0045a();
            a(c0045a);
            if (c0045a.f1276a != 10) {
                throw new java.lang.RuntimeException("type mismatch.");
            }
            jceStruct2.readFrom(this);
            a();
            return jceStruct2;
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(e.getMessage());
        }
    }

    public java.lang.Object a(java.lang.Object obj, int i, boolean z) {
        if (obj instanceof java.lang.Byte) {
            return java.lang.Byte.valueOf(a((byte) 0, i, z));
        }
        if (obj instanceof java.lang.Boolean) {
            return java.lang.Boolean.valueOf(a(false, i, z));
        }
        if (obj instanceof java.lang.Short) {
            return java.lang.Short.valueOf(a((short) 0, i, z));
        }
        if (obj instanceof java.lang.Integer) {
            return java.lang.Integer.valueOf(a(0, i, z));
        }
        if (obj instanceof java.lang.Long) {
            return java.lang.Long.valueOf(a(0L, i, z));
        }
        if (obj instanceof java.lang.Float) {
            return java.lang.Float.valueOf(a(0.0f, i, z));
        }
        if (obj instanceof java.lang.Double) {
            return java.lang.Double.valueOf(a(0.0d, i, z));
        }
        if (obj instanceof java.lang.String) {
            return a(i, z);
        }
        if (obj instanceof java.util.Map) {
            return a((java.util.Map) obj, i, z);
        }
        if (obj instanceof java.util.List) {
            return a((java.util.List) obj, i, z);
        }
        if (obj instanceof com.tencent.ydkbeacon.pack.JceStruct) {
            return a((com.tencent.ydkbeacon.pack.JceStruct) obj, i, z);
        }
        if (!obj.getClass().isArray()) {
            throw new java.lang.RuntimeException("read object error: unsupport type.");
        }
        if ((obj instanceof byte[]) || (obj instanceof java.lang.Byte[])) {
            return a((byte[]) null, i, z);
        }
        if (obj instanceof boolean[]) {
            return a((boolean[]) null, i, z);
        }
        if (obj instanceof short[]) {
            return a((short[]) null, i, z);
        }
        if (obj instanceof int[]) {
            return a((int[]) null, i, z);
        }
        if (obj instanceof long[]) {
            return a((long[]) null, i, z);
        }
        if (obj instanceof float[]) {
            return a((float[]) null, i, z);
        }
        return obj instanceof double[] ? a((double[]) null, i, z) : a((java.lang.Object[]) obj, i, z);
    }

    public java.lang.String a(int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new java.lang.RuntimeException("require field not exist.");
            }
            return null;
        }
        com.tencent.ydkbeacon.pack.a.C0045a c0045a = new com.tencent.ydkbeacon.pack.a.C0045a();
        a(c0045a);
        byte b = c0045a.f1276a;
        if (b == 6) {
            int i2 = this.f1275a.get();
            if (i2 < 0) {
                i2 += 256;
            }
            byte[] bArr = new byte[i2];
            this.f1275a.get(bArr);
            try {
                return new java.lang.String(bArr, this.b);
            } catch (java.io.UnsupportedEncodingException unused) {
                return new java.lang.String(bArr, java.nio.charset.Charset.forName("UTF-8"));
            }
        }
        if (b != 7) {
            throw new java.lang.RuntimeException("type mismatch.");
        }
        int i3 = this.f1275a.getInt();
        if (i3 > 104857600 || i3 < 0 || i3 > this.f1275a.capacity()) {
            throw new java.lang.RuntimeException("String too long: " + i3);
        }
        byte[] bArr2 = new byte[i3];
        this.f1275a.get(bArr2);
        try {
            return new java.lang.String(bArr2, this.b);
        } catch (java.io.UnsupportedEncodingException unused2) {
            return new java.lang.String(bArr2, java.nio.charset.Charset.forName("UTF-8"));
        }
    }

    public java.util.HashMap a(java.util.Map map, int i, boolean z) {
        return (java.util.HashMap) a(new java.util.HashMap(), map, i, z);
    }

    public java.util.List a(java.util.List list, int i, boolean z) {
        if (list == null || list.isEmpty()) {
            return new java.util.ArrayList();
        }
        java.lang.Object[] objArrB = b(list.get(0), i, z);
        if (objArrB == null) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.Object obj : objArrB) {
            arrayList.add(obj);
        }
        return arrayList;
    }

    public short a(short s, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new java.lang.RuntimeException("require field not exist.");
            }
            return s;
        }
        com.tencent.ydkbeacon.pack.a.C0045a c0045a = new com.tencent.ydkbeacon.pack.a.C0045a();
        a(c0045a);
        byte b = c0045a.f1276a;
        if (b == 0) {
            return this.f1275a.get();
        }
        if (b == 1) {
            return this.f1275a.getShort();
        }
        if (b == 12) {
            return (short) 0;
        }
        throw new java.lang.RuntimeException("type mismatch.");
    }

    public void a() {
        com.tencent.ydkbeacon.pack.a.C0045a c0045a = new com.tencent.ydkbeacon.pack.a.C0045a();
        do {
            a(c0045a);
            a(c0045a.f1276a);
        } while (c0045a.f1276a != 11);
    }

    public void a(com.tencent.ydkbeacon.pack.a.C0045a c0045a) {
        a(c0045a, this.f1275a);
    }

    public void a(byte[] bArr) {
        this.f1275a = java.nio.ByteBuffer.wrap(bArr);
    }

    public boolean a(int i) {
        try {
            com.tencent.ydkbeacon.pack.a.C0045a c0045a = new com.tencent.ydkbeacon.pack.a.C0045a();
            while (true) {
                int iB = b(c0045a);
                if (c0045a.f1276a == 11) {
                    return false;
                }
                if (i <= c0045a.b) {
                    return i == c0045a.b;
                }
                b(iB);
                a(c0045a.f1276a);
            }
        } catch (java.nio.BufferUnderflowException | java.lang.RuntimeException unused) {
            return false;
        }
    }

    public boolean a(boolean z, int i, boolean z2) {
        return a((byte) 0, i, z2) != 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public byte[] a(byte[] bArr, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new java.lang.RuntimeException("require field not exist.");
            }
            return null;
        }
        com.tencent.ydkbeacon.pack.a.C0045a c0045a = new com.tencent.ydkbeacon.pack.a.C0045a();
        a(c0045a);
        byte b = c0045a.f1276a;
        if (b == 9) {
            int iA = a(0, 0, true);
            if (iA < 0 || iA > this.f1275a.capacity()) {
                throw new java.lang.RuntimeException("size invalid: " + iA);
            }
            byte[] bArr2 = new byte[iA];
            for (int i2 = 0; i2 < iA; i2++) {
                bArr2[i2] = a(bArr2[0], 0, true);
            }
            return bArr2;
        }
        if (b != 13) {
            throw new java.lang.RuntimeException("type mismatch.");
        }
        com.tencent.ydkbeacon.pack.a.C0045a c0045a2 = new com.tencent.ydkbeacon.pack.a.C0045a();
        a(c0045a2);
        if (c0045a2.f1276a != 0) {
            throw new java.lang.RuntimeException("type mismatch, tag: " + i + ", type: " + ((int) c0045a.f1276a) + ", " + ((int) c0045a2.f1276a));
        }
        int iA2 = a(0, 0, true);
        if (iA2 >= 0 && iA2 <= this.f1275a.capacity()) {
            byte[] bArr3 = new byte[iA2];
            this.f1275a.get(bArr3);
            return bArr3;
        }
        throw new java.lang.RuntimeException("invalid size, tag: " + i + ", type: " + ((int) c0045a.f1276a) + ", " + ((int) c0045a2.f1276a) + ", size: " + iA2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public double[] a(double[] dArr, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new java.lang.RuntimeException("require field not exist.");
            }
            return null;
        }
        com.tencent.ydkbeacon.pack.a.C0045a c0045a = new com.tencent.ydkbeacon.pack.a.C0045a();
        a(c0045a);
        if (c0045a.f1276a != 9) {
            throw new java.lang.RuntimeException("type mismatch.");
        }
        int iA = a(0, 0, true);
        if (iA < 0) {
            throw new java.lang.RuntimeException("size invalid: " + iA);
        }
        double[] dArr2 = new double[iA];
        for (int i2 = 0; i2 < iA; i2++) {
            dArr2[i2] = a(dArr2[0], 0, true);
        }
        return dArr2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float[] a(float[] fArr, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new java.lang.RuntimeException("require field not exist.");
            }
            return null;
        }
        com.tencent.ydkbeacon.pack.a.C0045a c0045a = new com.tencent.ydkbeacon.pack.a.C0045a();
        a(c0045a);
        if (c0045a.f1276a != 9) {
            throw new java.lang.RuntimeException("type mismatch.");
        }
        int iA = a(0, 0, true);
        if (iA < 0) {
            throw new java.lang.RuntimeException("size invalid: " + iA);
        }
        float[] fArr2 = new float[iA];
        for (int i2 = 0; i2 < iA; i2++) {
            fArr2[i2] = a(fArr2[0], 0, true);
        }
        return fArr2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int[] a(int[] iArr, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new java.lang.RuntimeException("require field not exist.");
            }
            return null;
        }
        com.tencent.ydkbeacon.pack.a.C0045a c0045a = new com.tencent.ydkbeacon.pack.a.C0045a();
        a(c0045a);
        if (c0045a.f1276a != 9) {
            throw new java.lang.RuntimeException("type mismatch.");
        }
        int iA = a(0, 0, true);
        if (iA < 0) {
            throw new java.lang.RuntimeException("size invalid: " + iA);
        }
        int[] iArr2 = new int[iA];
        for (int i2 = 0; i2 < iA; i2++) {
            iArr2[i2] = a(iArr2[0], 0, true);
        }
        return iArr2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long[] a(long[] jArr, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new java.lang.RuntimeException("require field not exist.");
            }
            return null;
        }
        com.tencent.ydkbeacon.pack.a.C0045a c0045a = new com.tencent.ydkbeacon.pack.a.C0045a();
        a(c0045a);
        if (c0045a.f1276a != 9) {
            throw new java.lang.RuntimeException("type mismatch.");
        }
        int iA = a(0, 0, true);
        if (iA < 0) {
            throw new java.lang.RuntimeException("size invalid: " + iA);
        }
        long[] jArr2 = new long[iA];
        for (int i2 = 0; i2 < iA; i2++) {
            jArr2[i2] = a(jArr2[0], 0, true);
        }
        return jArr2;
    }

    public java.lang.Object[] a(java.lang.Object[] objArr, int i, boolean z) {
        if (objArr == null || objArr.length == 0) {
            throw new java.lang.RuntimeException("unable to get type of key and value.");
        }
        return b(objArr[0], i, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public short[] a(short[] sArr, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new java.lang.RuntimeException("require field not exist.");
            }
            return null;
        }
        com.tencent.ydkbeacon.pack.a.C0045a c0045a = new com.tencent.ydkbeacon.pack.a.C0045a();
        a(c0045a);
        if (c0045a.f1276a != 9) {
            throw new java.lang.RuntimeException("type mismatch.");
        }
        int iA = a(0, 0, true);
        if (iA < 0) {
            throw new java.lang.RuntimeException("size invalid: " + iA);
        }
        short[] sArr2 = new short[iA];
        for (int i2 = 0; i2 < iA; i2++) {
            sArr2[i2] = a(sArr2[0], 0, true);
        }
        return sArr2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean[] a(boolean[] zArr, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new java.lang.RuntimeException("require field not exist.");
            }
            return null;
        }
        com.tencent.ydkbeacon.pack.a.C0045a c0045a = new com.tencent.ydkbeacon.pack.a.C0045a();
        a(c0045a);
        if (c0045a.f1276a != 9) {
            throw new java.lang.RuntimeException("type mismatch.");
        }
        int iA = a(0, 0, true);
        if (iA < 0) {
            throw new java.lang.RuntimeException("size invalid: " + iA);
        }
        boolean[] zArr2 = new boolean[iA];
        for (int i2 = 0; i2 < iA; i2++) {
            zArr2[i2] = a(zArr2[0], 0, true);
        }
        return zArr2;
    }
}
