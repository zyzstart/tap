package com.tencent.bugly.opengame.proguard;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.nio.ByteBuffer f394a;
    private java.lang.String b = "GBK";

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte f395a;
        public int b;
    }

    public i() {
    }

    public i(byte[] bArr) {
        this.f394a = java.nio.ByteBuffer.wrap(bArr);
    }

    public i(byte[] bArr, int i) {
        java.nio.ByteBuffer byteBufferWrap = java.nio.ByteBuffer.wrap(bArr);
        this.f394a = byteBufferWrap;
        byteBufferWrap.position(4);
    }

    private double a(double d, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new com.tencent.bugly.opengame.proguard.g("require field not exist.");
            }
            return d;
        }
        com.tencent.bugly.opengame.proguard.i.a aVar = new com.tencent.bugly.opengame.proguard.i.a();
        a(aVar, this.f394a);
        byte b = aVar.f395a;
        if (b == 4) {
            return this.f394a.getFloat();
        }
        if (b == 5) {
            return this.f394a.getDouble();
        }
        if (b == 12) {
            return 0.0d;
        }
        throw new com.tencent.bugly.opengame.proguard.g("type mismatch.");
    }

    private float a(float f, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new com.tencent.bugly.opengame.proguard.g("require field not exist.");
            }
            return f;
        }
        com.tencent.bugly.opengame.proguard.i.a aVar = new com.tencent.bugly.opengame.proguard.i.a();
        a(aVar, this.f394a);
        byte b = aVar.f395a;
        if (b == 4) {
            return this.f394a.getFloat();
        }
        if (b == 12) {
            return 0.0f;
        }
        throw new com.tencent.bugly.opengame.proguard.g("type mismatch.");
    }

    private static int a(com.tencent.bugly.opengame.proguard.i.a aVar, java.nio.ByteBuffer byteBuffer) {
        byte b = byteBuffer.get();
        aVar.f395a = (byte) (b & 15);
        int i = (b & 240) >> 4;
        aVar.b = i;
        if (i != 15) {
            return 1;
        }
        aVar.b = byteBuffer.get();
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
            com.tencent.bugly.opengame.proguard.i.a aVar = new com.tencent.bugly.opengame.proguard.i.a();
            a(aVar, this.f394a);
            if (aVar.f395a != 8) {
                throw new com.tencent.bugly.opengame.proguard.g("type mismatch.");
            }
            int iA = a(0, 0, true);
            if (iA < 0) {
                throw new com.tencent.bugly.opengame.proguard.g("size invalid: " + iA);
            }
            for (int i2 = 0; i2 < iA; i2++) {
                map.put(a(key, 0, true), a(value, 1, true));
            }
        } else if (z) {
            throw new com.tencent.bugly.opengame.proguard.g("require field not exist.");
        }
        return map;
    }

    private void a() {
        com.tencent.bugly.opengame.proguard.i.a aVar = new com.tencent.bugly.opengame.proguard.i.a();
        do {
            a(aVar, this.f394a);
            a(aVar.f395a);
        } while (aVar.f395a != 11);
    }

    private void a(byte b) {
        int i = 0;
        switch (b) {
            case 0:
                java.nio.ByteBuffer byteBuffer = this.f394a;
                byteBuffer.position(byteBuffer.position() + 1);
                return;
            case 1:
                java.nio.ByteBuffer byteBuffer2 = this.f394a;
                byteBuffer2.position(byteBuffer2.position() + 2);
                return;
            case 2:
                java.nio.ByteBuffer byteBuffer3 = this.f394a;
                byteBuffer3.position(byteBuffer3.position() + 4);
                return;
            case 3:
                java.nio.ByteBuffer byteBuffer4 = this.f394a;
                byteBuffer4.position(byteBuffer4.position() + 8);
                return;
            case 4:
                java.nio.ByteBuffer byteBuffer5 = this.f394a;
                byteBuffer5.position(byteBuffer5.position() + 4);
                return;
            case 5:
                java.nio.ByteBuffer byteBuffer6 = this.f394a;
                byteBuffer6.position(byteBuffer6.position() + 8);
                return;
            case 6:
                int i2 = this.f394a.get();
                if (i2 < 0) {
                    i2 += 256;
                }
                java.nio.ByteBuffer byteBuffer7 = this.f394a;
                byteBuffer7.position(byteBuffer7.position() + i2);
                return;
            case 7:
                int i3 = this.f394a.getInt();
                java.nio.ByteBuffer byteBuffer8 = this.f394a;
                byteBuffer8.position(byteBuffer8.position() + i3);
                return;
            case 8:
                int iA = a(0, 0, true);
                while (i < (iA << 1)) {
                    com.tencent.bugly.opengame.proguard.i.a aVar = new com.tencent.bugly.opengame.proguard.i.a();
                    a(aVar, this.f394a);
                    a(aVar.f395a);
                    i++;
                }
                return;
            case 9:
                int iA2 = a(0, 0, true);
                while (i < iA2) {
                    com.tencent.bugly.opengame.proguard.i.a aVar2 = new com.tencent.bugly.opengame.proguard.i.a();
                    a(aVar2, this.f394a);
                    a(aVar2.f395a);
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
                com.tencent.bugly.opengame.proguard.i.a aVar3 = new com.tencent.bugly.opengame.proguard.i.a();
                a(aVar3, this.f394a);
                if (aVar3.f395a == 0) {
                    int iA3 = a(0, 0, true);
                    java.nio.ByteBuffer byteBuffer9 = this.f394a;
                    byteBuffer9.position(byteBuffer9.position() + iA3);
                    return;
                } else {
                    throw new com.tencent.bugly.opengame.proguard.g("skipField with invalid type, type value: " + ((int) b) + ", " + ((int) aVar3.f395a));
                }
            default:
                throw new com.tencent.bugly.opengame.proguard.g("invalid type.");
        }
    }

    private boolean a(int i) {
        try {
            com.tencent.bugly.opengame.proguard.i.a aVar = new com.tencent.bugly.opengame.proguard.i.a();
            while (true) {
                int iA = a(aVar, this.f394a.duplicate());
                if (i <= aVar.b || aVar.f395a == 11) {
                    break;
                    break;
                }
                this.f394a.position(this.f394a.position() + iA);
                a(aVar.f395a);
            }
            return i == aVar.b;
        } catch (com.tencent.bugly.opengame.proguard.g | java.nio.BufferUnderflowException unused) {
        }
    }

    private java.lang.Object[] a(java.lang.Object[] objArr, int i, boolean z) {
        if (objArr == null || objArr.length == 0) {
            throw new com.tencent.bugly.opengame.proguard.g("unable to get type of key and value.");
        }
        return b(objArr[0], i, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private java.lang.Object[] b(java.lang.Object obj, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new com.tencent.bugly.opengame.proguard.g("require field not exist.");
            }
            return null;
        }
        com.tencent.bugly.opengame.proguard.i.a aVar = new com.tencent.bugly.opengame.proguard.i.a();
        a(aVar, this.f394a);
        if (aVar.f395a != 9) {
            throw new com.tencent.bugly.opengame.proguard.g("type mismatch.");
        }
        int iA = a(0, 0, true);
        if (iA < 0) {
            throw new com.tencent.bugly.opengame.proguard.g("size invalid: " + iA);
        }
        java.lang.Object[] objArr = (java.lang.Object[]) java.lang.reflect.Array.newInstance(obj.getClass(), iA);
        for (int i2 = 0; i2 < iA; i2++) {
            objArr[i2] = a(obj, 0, true);
        }
        return objArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean[] d(int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new com.tencent.bugly.opengame.proguard.g("require field not exist.");
            }
            return null;
        }
        com.tencent.bugly.opengame.proguard.i.a aVar = new com.tencent.bugly.opengame.proguard.i.a();
        a(aVar, this.f394a);
        if (aVar.f395a != 9) {
            throw new com.tencent.bugly.opengame.proguard.g("type mismatch.");
        }
        int iA = a(0, 0, true);
        if (iA < 0) {
            throw new com.tencent.bugly.opengame.proguard.g("size invalid: " + iA);
        }
        boolean[] zArr = new boolean[iA];
        for (int i2 = 0; i2 < iA; i2++) {
            zArr[i2] = a((byte) 0, 0, true) != 0;
        }
        return zArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private short[] e(int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new com.tencent.bugly.opengame.proguard.g("require field not exist.");
            }
            return null;
        }
        com.tencent.bugly.opengame.proguard.i.a aVar = new com.tencent.bugly.opengame.proguard.i.a();
        a(aVar, this.f394a);
        if (aVar.f395a != 9) {
            throw new com.tencent.bugly.opengame.proguard.g("type mismatch.");
        }
        int iA = a(0, 0, true);
        if (iA < 0) {
            throw new com.tencent.bugly.opengame.proguard.g("size invalid: " + iA);
        }
        short[] sArr = new short[iA];
        for (int i2 = 0; i2 < iA; i2++) {
            sArr[i2] = a(sArr[0], 0, true);
        }
        return sArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private int[] f(int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new com.tencent.bugly.opengame.proguard.g("require field not exist.");
            }
            return null;
        }
        com.tencent.bugly.opengame.proguard.i.a aVar = new com.tencent.bugly.opengame.proguard.i.a();
        a(aVar, this.f394a);
        if (aVar.f395a != 9) {
            throw new com.tencent.bugly.opengame.proguard.g("type mismatch.");
        }
        int iA = a(0, 0, true);
        if (iA < 0) {
            throw new com.tencent.bugly.opengame.proguard.g("size invalid: " + iA);
        }
        int[] iArr = new int[iA];
        for (int i2 = 0; i2 < iA; i2++) {
            iArr[i2] = a(iArr[0], 0, true);
        }
        return iArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private long[] g(int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new com.tencent.bugly.opengame.proguard.g("require field not exist.");
            }
            return null;
        }
        com.tencent.bugly.opengame.proguard.i.a aVar = new com.tencent.bugly.opengame.proguard.i.a();
        a(aVar, this.f394a);
        if (aVar.f395a != 9) {
            throw new com.tencent.bugly.opengame.proguard.g("type mismatch.");
        }
        int iA = a(0, 0, true);
        if (iA < 0) {
            throw new com.tencent.bugly.opengame.proguard.g("size invalid: " + iA);
        }
        long[] jArr = new long[iA];
        for (int i2 = 0; i2 < iA; i2++) {
            jArr[i2] = a(jArr[0], 0, true);
        }
        return jArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private float[] h(int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new com.tencent.bugly.opengame.proguard.g("require field not exist.");
            }
            return null;
        }
        com.tencent.bugly.opengame.proguard.i.a aVar = new com.tencent.bugly.opengame.proguard.i.a();
        a(aVar, this.f394a);
        if (aVar.f395a != 9) {
            throw new com.tencent.bugly.opengame.proguard.g("type mismatch.");
        }
        int iA = a(0, 0, true);
        if (iA < 0) {
            throw new com.tencent.bugly.opengame.proguard.g("size invalid: " + iA);
        }
        float[] fArr = new float[iA];
        for (int i2 = 0; i2 < iA; i2++) {
            fArr[i2] = a(fArr[0], 0, true);
        }
        return fArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private double[] i(int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new com.tencent.bugly.opengame.proguard.g("require field not exist.");
            }
            return null;
        }
        com.tencent.bugly.opengame.proguard.i.a aVar = new com.tencent.bugly.opengame.proguard.i.a();
        a(aVar, this.f394a);
        if (aVar.f395a != 9) {
            throw new com.tencent.bugly.opengame.proguard.g("type mismatch.");
        }
        int iA = a(0, 0, true);
        if (iA < 0) {
            throw new com.tencent.bugly.opengame.proguard.g("size invalid: " + iA);
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
                throw new com.tencent.bugly.opengame.proguard.g("require field not exist.");
            }
            return b;
        }
        com.tencent.bugly.opengame.proguard.i.a aVar = new com.tencent.bugly.opengame.proguard.i.a();
        a(aVar, this.f394a);
        byte b2 = aVar.f395a;
        if (b2 == 0) {
            return this.f394a.get();
        }
        if (b2 == 12) {
            return (byte) 0;
        }
        throw new com.tencent.bugly.opengame.proguard.g("type mismatch.");
    }

    public final int a(int i, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new com.tencent.bugly.opengame.proguard.g("require field not exist.");
            }
            return i;
        }
        com.tencent.bugly.opengame.proguard.i.a aVar = new com.tencent.bugly.opengame.proguard.i.a();
        a(aVar, this.f394a);
        byte b = aVar.f395a;
        if (b == 0) {
            return this.f394a.get();
        }
        if (b == 1) {
            return this.f394a.getShort();
        }
        if (b == 2) {
            return this.f394a.getInt();
        }
        if (b == 12) {
            return 0;
        }
        throw new com.tencent.bugly.opengame.proguard.g("type mismatch.");
    }

    public final int a(java.lang.String str) {
        this.b = str;
        return 0;
    }

    public final long a(long j, int i, boolean z) {
        int i2;
        if (!a(i)) {
            if (z) {
                throw new com.tencent.bugly.opengame.proguard.g("require field not exist.");
            }
            return j;
        }
        com.tencent.bugly.opengame.proguard.i.a aVar = new com.tencent.bugly.opengame.proguard.i.a();
        a(aVar, this.f394a);
        byte b = aVar.f395a;
        if (b == 12) {
            return 0L;
        }
        switch (b) {
            case 0:
                i2 = this.f394a.get();
                break;
            case 1:
                i2 = this.f394a.getShort();
                break;
            case 2:
                i2 = this.f394a.getInt();
                break;
            case 3:
                return this.f394a.getLong();
            default:
                throw new com.tencent.bugly.opengame.proguard.g("type mismatch.");
        }
        return i2;
    }

    public final com.tencent.bugly.opengame.proguard.k a(com.tencent.bugly.opengame.proguard.k kVar, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new com.tencent.bugly.opengame.proguard.g("require field not exist.");
            }
            return null;
        }
        try {
            com.tencent.bugly.opengame.proguard.k kVar2 = (com.tencent.bugly.opengame.proguard.k) kVar.getClass().newInstance();
            com.tencent.bugly.opengame.proguard.i.a aVar = new com.tencent.bugly.opengame.proguard.i.a();
            a(aVar, this.f394a);
            if (aVar.f395a != 10) {
                throw new com.tencent.bugly.opengame.proguard.g("type mismatch.");
            }
            kVar2.a(this);
            a();
            return kVar2;
        } catch (java.lang.Exception e) {
            throw new com.tencent.bugly.opengame.proguard.g(e.getMessage());
        }
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
            return java.lang.String.valueOf(b(i, z));
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
        if (obj instanceof com.tencent.bugly.opengame.proguard.k) {
            return a((com.tencent.bugly.opengame.proguard.k) obj, i, z);
        }
        if (!obj.getClass().isArray()) {
            throw new com.tencent.bugly.opengame.proguard.g("read object error: unsupport type.");
        }
        if ((obj instanceof byte[]) || (obj instanceof java.lang.Byte[])) {
            return c(i, z);
        }
        if (obj instanceof boolean[]) {
            return d(i, z);
        }
        if (obj instanceof short[]) {
            return e(i, z);
        }
        if (obj instanceof int[]) {
            return f(i, z);
        }
        if (obj instanceof long[]) {
            return g(i, z);
        }
        if (obj instanceof float[]) {
            return h(i, z);
        }
        return obj instanceof double[] ? i(i, z) : a((java.lang.Object[]) obj, i, z);
    }

    public final java.util.HashMap a(java.util.Map map, int i, boolean z) {
        return (java.util.HashMap) a(new java.util.HashMap(), map, i, z);
    }

    public final short a(short s, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new com.tencent.bugly.opengame.proguard.g("require field not exist.");
            }
            return s;
        }
        com.tencent.bugly.opengame.proguard.i.a aVar = new com.tencent.bugly.opengame.proguard.i.a();
        a(aVar, this.f394a);
        byte b = aVar.f395a;
        if (b == 0) {
            return this.f394a.get();
        }
        if (b == 1) {
            return this.f394a.getShort();
        }
        if (b == 12) {
            return (short) 0;
        }
        throw new com.tencent.bugly.opengame.proguard.g("type mismatch.");
    }

    public final void a(byte[] bArr) {
        java.nio.ByteBuffer byteBuffer = this.f394a;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        this.f394a = java.nio.ByteBuffer.wrap(bArr);
    }

    public final boolean a(int i, boolean z) {
        return a((byte) 0, i, z) != 0;
    }

    public final java.lang.String b(int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new com.tencent.bugly.opengame.proguard.g("require field not exist.");
            }
            return null;
        }
        com.tencent.bugly.opengame.proguard.i.a aVar = new com.tencent.bugly.opengame.proguard.i.a();
        a(aVar, this.f394a);
        byte b = aVar.f395a;
        if (b == 6) {
            int i2 = this.f394a.get();
            if (i2 < 0) {
                i2 += 256;
            }
            byte[] bArr = new byte[i2];
            this.f394a.get(bArr);
            try {
                return new java.lang.String(bArr, this.b);
            } catch (java.io.UnsupportedEncodingException unused) {
                return new java.lang.String(bArr);
            }
        }
        if (b != 7) {
            throw new com.tencent.bugly.opengame.proguard.g("type mismatch.");
        }
        int i3 = this.f394a.getInt();
        if (i3 > 104857600 || i3 < 0) {
            throw new com.tencent.bugly.opengame.proguard.g("String too long: " + i3);
        }
        byte[] bArr2 = new byte[i3];
        this.f394a.get(bArr2);
        try {
            return new java.lang.String(bArr2, this.b);
        } catch (java.io.UnsupportedEncodingException unused2) {
            return new java.lang.String(bArr2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final byte[] c(int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new com.tencent.bugly.opengame.proguard.g("require field not exist.");
            }
            return null;
        }
        com.tencent.bugly.opengame.proguard.i.a aVar = new com.tencent.bugly.opengame.proguard.i.a();
        a(aVar, this.f394a);
        byte b = aVar.f395a;
        if (b == 9) {
            int iA = a(0, 0, true);
            if (iA < 0) {
                throw new com.tencent.bugly.opengame.proguard.g("size invalid: " + iA);
            }
            byte[] bArr = new byte[iA];
            for (int i2 = 0; i2 < iA; i2++) {
                bArr[i2] = a(bArr[0], 0, true);
            }
            return bArr;
        }
        if (b != 13) {
            throw new com.tencent.bugly.opengame.proguard.g("type mismatch.");
        }
        com.tencent.bugly.opengame.proguard.i.a aVar2 = new com.tencent.bugly.opengame.proguard.i.a();
        a(aVar2, this.f394a);
        if (aVar2.f395a != 0) {
            throw new com.tencent.bugly.opengame.proguard.g("type mismatch, tag: " + i + ", type: " + ((int) aVar.f395a) + ", " + ((int) aVar2.f395a));
        }
        int iA2 = a(0, 0, true);
        if (iA2 >= 0) {
            byte[] bArr2 = new byte[iA2];
            this.f394a.get(bArr2);
            return bArr2;
        }
        throw new com.tencent.bugly.opengame.proguard.g("invalid size, tag: " + i + ", type: " + ((int) aVar.f395a) + ", " + ((int) aVar2.f395a) + ", size: " + iA2);
    }
}
