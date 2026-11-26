package com.tencent.beaconselfupdate.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.nio.ByteBuffer f248a;
    private java.lang.String b = "GBK";

    /* JADX INFO: renamed from: com.tencent.beaconselfupdate.d.a$a, reason: collision with other inner class name */
    public final class C0020a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte f249a;
        public int b;
    }

    public a() {
    }

    public a(byte[] bArr) {
        this.f248a = java.nio.ByteBuffer.wrap(bArr);
    }

    public a(byte[] bArr, byte b) {
        java.nio.ByteBuffer byteBufferWrap = java.nio.ByteBuffer.wrap(bArr);
        this.f248a = byteBufferWrap;
        byteBufferWrap.position(4);
    }

    private double a(double d, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new java.lang.RuntimeException("require field not exist.");
            }
            return d;
        }
        com.tencent.beaconselfupdate.d.a.C0020a c0020a = new com.tencent.beaconselfupdate.d.a.C0020a();
        a(c0020a, this.f248a);
        byte b = c0020a.f249a;
        if (b == 4) {
            return this.f248a.getFloat();
        }
        if (b == 5) {
            return this.f248a.getDouble();
        }
        if (b == 12) {
            return 0.0d;
        }
        throw new java.lang.RuntimeException("type mismatch.");
    }

    private float a(float f, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new java.lang.RuntimeException("require field not exist.");
            }
            return f;
        }
        com.tencent.beaconselfupdate.d.a.C0020a c0020a = new com.tencent.beaconselfupdate.d.a.C0020a();
        a(c0020a, this.f248a);
        byte b = c0020a.f249a;
        if (b == 4) {
            return this.f248a.getFloat();
        }
        if (b == 12) {
            return 0.0f;
        }
        throw new java.lang.RuntimeException("type mismatch.");
    }

    private static int a(com.tencent.beaconselfupdate.d.a.C0020a c0020a, java.nio.ByteBuffer byteBuffer) {
        byte b = byteBuffer.get();
        c0020a.f249a = (byte) (b & 15);
        int i = (b & 240) >> 4;
        c0020a.b = i;
        if (i != 15) {
            return 1;
        }
        c0020a.b = byteBuffer.get() & 255;
        return 2;
    }

    private com.tencent.beaconselfupdate.d.c a(com.tencent.beaconselfupdate.d.c cVar, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new java.lang.RuntimeException("require field not exist.");
            }
            return null;
        }
        try {
            com.tencent.beaconselfupdate.d.c cVar2 = (com.tencent.beaconselfupdate.d.c) cVar.getClass().newInstance();
            com.tencent.beaconselfupdate.d.a.C0020a c0020a = new com.tencent.beaconselfupdate.d.a.C0020a();
            a(c0020a, this.f248a);
            if (c0020a.f249a != 10) {
                throw new java.lang.RuntimeException("type mismatch.");
            }
            cVar2.a(this);
            a();
            return cVar2;
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(e.getMessage());
        }
    }

    private java.util.Map a(java.util.Map map, java.util.Map map2, int i, boolean z) {
        if (map2 == null || map2.isEmpty()) {
            return new java.util.HashMap();
        }
        java.util.Map.Entry entry = (java.util.Map.Entry) map2.entrySet().iterator().next();
        java.lang.Object key = entry.getKey();
        java.lang.Object value = entry.getValue();
        if (a(i)) {
            com.tencent.beaconselfupdate.d.a.C0020a c0020a = new com.tencent.beaconselfupdate.d.a.C0020a();
            a(c0020a, this.f248a);
            if (c0020a.f249a != 8) {
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

    private void a() {
        com.tencent.beaconselfupdate.d.a.C0020a c0020a = new com.tencent.beaconselfupdate.d.a.C0020a();
        do {
            a(c0020a, this.f248a);
            a(c0020a.f249a);
        } while (c0020a.f249a != 11);
    }

    private void a(byte b) {
        int i = 0;
        switch (b) {
            case 0:
                java.nio.ByteBuffer byteBuffer = this.f248a;
                byteBuffer.position(byteBuffer.position() + 1);
                return;
            case 1:
                java.nio.ByteBuffer byteBuffer2 = this.f248a;
                byteBuffer2.position(byteBuffer2.position() + 2);
                return;
            case 2:
                java.nio.ByteBuffer byteBuffer3 = this.f248a;
                byteBuffer3.position(byteBuffer3.position() + 4);
                return;
            case 3:
                java.nio.ByteBuffer byteBuffer4 = this.f248a;
                byteBuffer4.position(byteBuffer4.position() + 8);
                return;
            case 4:
                java.nio.ByteBuffer byteBuffer5 = this.f248a;
                byteBuffer5.position(byteBuffer5.position() + 4);
                return;
            case 5:
                java.nio.ByteBuffer byteBuffer6 = this.f248a;
                byteBuffer6.position(byteBuffer6.position() + 8);
                return;
            case 6:
                int i2 = this.f248a.get();
                if (i2 < 0) {
                    i2 += 256;
                }
                java.nio.ByteBuffer byteBuffer7 = this.f248a;
                byteBuffer7.position(byteBuffer7.position() + i2);
                return;
            case 7:
                int i3 = this.f248a.getInt();
                java.nio.ByteBuffer byteBuffer8 = this.f248a;
                byteBuffer8.position(byteBuffer8.position() + i3);
                return;
            case 8:
                int iA = a(0, 0, true);
                while (i < (iA << 1)) {
                    com.tencent.beaconselfupdate.d.a.C0020a c0020a = new com.tencent.beaconselfupdate.d.a.C0020a();
                    a(c0020a, this.f248a);
                    a(c0020a.f249a);
                    i++;
                }
                return;
            case 9:
                int iA2 = a(0, 0, true);
                while (i < iA2) {
                    com.tencent.beaconselfupdate.d.a.C0020a c0020a2 = new com.tencent.beaconselfupdate.d.a.C0020a();
                    a(c0020a2, this.f248a);
                    a(c0020a2.f249a);
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
                com.tencent.beaconselfupdate.d.a.C0020a c0020a3 = new com.tencent.beaconselfupdate.d.a.C0020a();
                a(c0020a3, this.f248a);
                if (c0020a3.f249a == 0) {
                    int iA3 = a(0, 0, true);
                    java.nio.ByteBuffer byteBuffer9 = this.f248a;
                    byteBuffer9.position(byteBuffer9.position() + iA3);
                    return;
                } else {
                    throw new java.lang.RuntimeException("skipField with invalid type, type value: " + ((int) b) + ", " + ((int) c0020a3.f249a));
                }
            default:
                throw new java.lang.RuntimeException("invalid type.");
        }
    }

    private boolean a(int i) {
        try {
            com.tencent.beaconselfupdate.d.a.C0020a c0020a = new com.tencent.beaconselfupdate.d.a.C0020a();
            while (true) {
                int iA = a(c0020a, this.f248a.duplicate());
                if (c0020a.f249a == 11) {
                    return false;
                }
                if (i <= c0020a.b) {
                    return i == c0020a.b;
                }
                this.f248a.position(this.f248a.position() + iA);
                a(c0020a.f249a);
            }
        } catch (java.nio.BufferUnderflowException | java.lang.RuntimeException unused) {
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private java.lang.Object[] b(java.lang.Object obj, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new java.lang.RuntimeException("require field not exist.");
            }
            return null;
        }
        com.tencent.beaconselfupdate.d.a.C0020a c0020a = new com.tencent.beaconselfupdate.d.a.C0020a();
        a(c0020a, this.f248a);
        if (c0020a.f249a != 9) {
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean[] c(int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new java.lang.RuntimeException("require field not exist.");
            }
            return null;
        }
        com.tencent.beaconselfupdate.d.a.C0020a c0020a = new com.tencent.beaconselfupdate.d.a.C0020a();
        a(c0020a, this.f248a);
        if (c0020a.f249a != 9) {
            throw new java.lang.RuntimeException("type mismatch.");
        }
        int iA = a(0, 0, true);
        if (iA < 0) {
            throw new java.lang.RuntimeException("size invalid: " + iA);
        }
        boolean[] zArr = new boolean[iA];
        for (int i2 = 0; i2 < iA; i2++) {
            zArr[i2] = a((byte) 0, 0, true) != 0;
        }
        return zArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private short[] d(int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new java.lang.RuntimeException("require field not exist.");
            }
            return null;
        }
        com.tencent.beaconselfupdate.d.a.C0020a c0020a = new com.tencent.beaconselfupdate.d.a.C0020a();
        a(c0020a, this.f248a);
        if (c0020a.f249a != 9) {
            throw new java.lang.RuntimeException("type mismatch.");
        }
        int iA = a(0, 0, true);
        if (iA < 0) {
            throw new java.lang.RuntimeException("size invalid: " + iA);
        }
        short[] sArr = new short[iA];
        for (int i2 = 0; i2 < iA; i2++) {
            sArr[i2] = a(sArr[0], 0, true);
        }
        return sArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private int[] e(int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new java.lang.RuntimeException("require field not exist.");
            }
            return null;
        }
        com.tencent.beaconselfupdate.d.a.C0020a c0020a = new com.tencent.beaconselfupdate.d.a.C0020a();
        a(c0020a, this.f248a);
        if (c0020a.f249a != 9) {
            throw new java.lang.RuntimeException("type mismatch.");
        }
        int iA = a(0, 0, true);
        if (iA < 0) {
            throw new java.lang.RuntimeException("size invalid: " + iA);
        }
        int[] iArr = new int[iA];
        for (int i2 = 0; i2 < iA; i2++) {
            iArr[i2] = a(iArr[0], 0, true);
        }
        return iArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private long[] f(int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new java.lang.RuntimeException("require field not exist.");
            }
            return null;
        }
        com.tencent.beaconselfupdate.d.a.C0020a c0020a = new com.tencent.beaconselfupdate.d.a.C0020a();
        a(c0020a, this.f248a);
        if (c0020a.f249a != 9) {
            throw new java.lang.RuntimeException("type mismatch.");
        }
        int iA = a(0, 0, true);
        if (iA < 0) {
            throw new java.lang.RuntimeException("size invalid: " + iA);
        }
        long[] jArr = new long[iA];
        for (int i2 = 0; i2 < iA; i2++) {
            jArr[i2] = a(jArr[0], 0, true);
        }
        return jArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private float[] g(int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new java.lang.RuntimeException("require field not exist.");
            }
            return null;
        }
        com.tencent.beaconselfupdate.d.a.C0020a c0020a = new com.tencent.beaconselfupdate.d.a.C0020a();
        a(c0020a, this.f248a);
        if (c0020a.f249a != 9) {
            throw new java.lang.RuntimeException("type mismatch.");
        }
        int iA = a(0, 0, true);
        if (iA < 0) {
            throw new java.lang.RuntimeException("size invalid: " + iA);
        }
        float[] fArr = new float[iA];
        for (int i2 = 0; i2 < iA; i2++) {
            fArr[i2] = a(fArr[0], 0, true);
        }
        return fArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private double[] h(int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new java.lang.RuntimeException("require field not exist.");
            }
            return null;
        }
        com.tencent.beaconselfupdate.d.a.C0020a c0020a = new com.tencent.beaconselfupdate.d.a.C0020a();
        a(c0020a, this.f248a);
        if (c0020a.f249a != 9) {
            throw new java.lang.RuntimeException("type mismatch.");
        }
        int iA = a(0, 0, true);
        if (iA < 0) {
            throw new java.lang.RuntimeException("size invalid: " + iA);
        }
        double[] dArr = new double[iA];
        for (int i2 = 0; i2 < iA; i2++) {
            dArr[i2] = a(dArr[0], 0, true);
        }
        return dArr;
    }

    public final byte a(byte b, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new java.lang.RuntimeException("require field not exist.");
            }
            return b;
        }
        com.tencent.beaconselfupdate.d.a.C0020a c0020a = new com.tencent.beaconselfupdate.d.a.C0020a();
        a(c0020a, this.f248a);
        byte b2 = c0020a.f249a;
        if (b2 == 0) {
            return this.f248a.get();
        }
        if (b2 == 12) {
            return (byte) 0;
        }
        throw new java.lang.RuntimeException("type mismatch.");
    }

    public final int a(int i, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new java.lang.RuntimeException("require field not exist.");
            }
            return i;
        }
        com.tencent.beaconselfupdate.d.a.C0020a c0020a = new com.tencent.beaconselfupdate.d.a.C0020a();
        a(c0020a, this.f248a);
        byte b = c0020a.f249a;
        if (b == 0) {
            return this.f248a.get();
        }
        if (b == 1) {
            return this.f248a.getShort();
        }
        if (b == 2) {
            return this.f248a.getInt();
        }
        if (b == 12) {
            return 0;
        }
        throw new java.lang.RuntimeException("type mismatch.");
    }

    public final int a(java.lang.String str) {
        this.b = str;
        return 0;
    }

    public final long a(long j, int i, boolean z) {
        int i2;
        if (!a(i)) {
            if (z) {
                throw new java.lang.RuntimeException("require field not exist.");
            }
            return j;
        }
        com.tencent.beaconselfupdate.d.a.C0020a c0020a = new com.tencent.beaconselfupdate.d.a.C0020a();
        a(c0020a, this.f248a);
        byte b = c0020a.f249a;
        if (b == 12) {
            return 0L;
        }
        switch (b) {
            case 0:
                i2 = this.f248a.get();
                break;
            case 1:
                i2 = this.f248a.getShort();
                break;
            case 2:
                i2 = this.f248a.getInt();
                break;
            case 3:
                return this.f248a.getLong();
            default:
                throw new java.lang.RuntimeException("type mismatch.");
        }
        return i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final java.lang.Object a(java.lang.Object obj, int i, boolean z) {
        if (obj instanceof java.lang.Byte) {
            return java.lang.Byte.valueOf(a((byte) 0, i, z));
        }
        if (obj instanceof java.lang.Boolean) {
            return java.lang.Boolean.valueOf(a((byte) 0, i, z) != 0);
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
            return (java.util.HashMap) a(new java.util.HashMap(), (java.util.Map) obj, i, z);
        }
        if (obj instanceof java.util.List) {
            java.util.List list = (java.util.List) obj;
            if (list == null || list.isEmpty()) {
                return new java.util.ArrayList();
            }
            java.lang.Object[] objArrB = b(list.get(0), i, z);
            if (objArrB == null) {
                return null;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (java.lang.Object obj2 : objArrB) {
                arrayList.add(obj2);
            }
            return arrayList;
        }
        if (obj instanceof com.tencent.beaconselfupdate.d.c) {
            return a((com.tencent.beaconselfupdate.d.c) obj, i, z);
        }
        if (!obj.getClass().isArray()) {
            throw new java.lang.RuntimeException("read object error: unsupport type.");
        }
        if ((obj instanceof byte[]) || (obj instanceof java.lang.Byte[])) {
            return b(i, z);
        }
        if (obj instanceof boolean[]) {
            return c(i, z);
        }
        if (obj instanceof short[]) {
            return d(i, z);
        }
        if (obj instanceof int[]) {
            return e(i, z);
        }
        if (obj instanceof long[]) {
            return f(i, z);
        }
        if (obj instanceof float[]) {
            return g(i, z);
        }
        if (obj instanceof double[]) {
            return h(i, z);
        }
        java.lang.Object[] objArr = (java.lang.Object[]) obj;
        if (objArr == null || objArr.length == 0) {
            throw new java.lang.RuntimeException("unable to get type of key and value.");
        }
        return b(objArr[0], i, z);
    }

    public final java.lang.String a(int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new java.lang.RuntimeException("require field not exist.");
            }
            return null;
        }
        com.tencent.beaconselfupdate.d.a.C0020a c0020a = new com.tencent.beaconselfupdate.d.a.C0020a();
        a(c0020a, this.f248a);
        byte b = c0020a.f249a;
        if (b == 6) {
            int i2 = this.f248a.get();
            if (i2 < 0) {
                i2 += 256;
            }
            byte[] bArr = new byte[i2];
            this.f248a.get(bArr);
            try {
                return new java.lang.String(bArr, this.b);
            } catch (java.io.UnsupportedEncodingException unused) {
                return new java.lang.String(bArr);
            }
        }
        if (b != 7) {
            throw new java.lang.RuntimeException("type mismatch.");
        }
        int i3 = this.f248a.getInt();
        if (i3 > 104857600 || i3 < 0 || i3 > this.f248a.capacity()) {
            throw new java.lang.RuntimeException("String too long: " + i3);
        }
        byte[] bArr2 = new byte[i3];
        this.f248a.get(bArr2);
        try {
            return new java.lang.String(bArr2, this.b);
        } catch (java.io.UnsupportedEncodingException unused2) {
            return new java.lang.String(bArr2);
        }
    }

    public final java.util.HashMap a(java.util.Map map) {
        return (java.util.HashMap) a(new java.util.HashMap(), map, 0, false);
    }

    public final short a(short s, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new java.lang.RuntimeException("require field not exist.");
            }
            return s;
        }
        com.tencent.beaconselfupdate.d.a.C0020a c0020a = new com.tencent.beaconselfupdate.d.a.C0020a();
        a(c0020a, this.f248a);
        byte b = c0020a.f249a;
        if (b == 0) {
            return this.f248a.get();
        }
        if (b == 1) {
            return this.f248a.getShort();
        }
        if (b == 12) {
            return (short) 0;
        }
        throw new java.lang.RuntimeException("type mismatch.");
    }

    public final void a(byte[] bArr) {
        this.f248a = java.nio.ByteBuffer.wrap(bArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final byte[] b(int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new java.lang.RuntimeException("require field not exist.");
            }
            return null;
        }
        com.tencent.beaconselfupdate.d.a.C0020a c0020a = new com.tencent.beaconselfupdate.d.a.C0020a();
        a(c0020a, this.f248a);
        byte b = c0020a.f249a;
        if (b == 9) {
            int iA = a(0, 0, true);
            if (iA < 0 || iA > this.f248a.capacity()) {
                throw new java.lang.RuntimeException("size invalid: " + iA);
            }
            byte[] bArr = new byte[iA];
            for (int i2 = 0; i2 < iA; i2++) {
                bArr[i2] = a(bArr[0], 0, true);
            }
            return bArr;
        }
        if (b != 13) {
            throw new java.lang.RuntimeException("type mismatch.");
        }
        com.tencent.beaconselfupdate.d.a.C0020a c0020a2 = new com.tencent.beaconselfupdate.d.a.C0020a();
        a(c0020a2, this.f248a);
        if (c0020a2.f249a != 0) {
            throw new java.lang.RuntimeException("type mismatch, tag: " + i + ", type: " + ((int) c0020a.f249a) + ", " + ((int) c0020a2.f249a));
        }
        int iA2 = a(0, 0, true);
        if (iA2 >= 0 && iA2 <= this.f248a.capacity()) {
            byte[] bArr2 = new byte[iA2];
            this.f248a.get(bArr2);
            return bArr2;
        }
        throw new java.lang.RuntimeException("invalid size, tag: " + i + ", type: " + ((int) c0020a.f249a) + ", " + ((int) c0020a2.f249a) + ", size: " + iA2);
    }
}
