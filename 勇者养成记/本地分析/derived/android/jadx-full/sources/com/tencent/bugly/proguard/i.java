package com.tencent.bugly.proguard;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.nio.ByteBuffer f436a;
    private java.lang.String b = "GBK";

    /* JADX INFO: compiled from: BUGLY */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte f437a;
        public int b;
    }

    public i() {
    }

    public i(byte[] bArr) {
        this.f436a = java.nio.ByteBuffer.wrap(bArr);
    }

    public i(byte[] bArr, int i) {
        this.f436a = java.nio.ByteBuffer.wrap(bArr);
        this.f436a.position(4);
    }

    private double a(double d, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new com.tencent.bugly.proguard.g("require field not exist.");
            }
            return d;
        }
        com.tencent.bugly.proguard.i.a aVar = new com.tencent.bugly.proguard.i.a();
        a(aVar, this.f436a);
        byte b = aVar.f437a;
        if (b == 12) {
            return 0.0d;
        }
        switch (b) {
            case 4:
                return this.f436a.getFloat();
            case 5:
                return this.f436a.getDouble();
            default:
                throw new com.tencent.bugly.proguard.g("type mismatch.");
        }
    }

    private float a(float f, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new com.tencent.bugly.proguard.g("require field not exist.");
            }
            return f;
        }
        com.tencent.bugly.proguard.i.a aVar = new com.tencent.bugly.proguard.i.a();
        a(aVar, this.f436a);
        byte b = aVar.f437a;
        if (b == 4) {
            return this.f436a.getFloat();
        }
        if (b == 12) {
            return 0.0f;
        }
        throw new com.tencent.bugly.proguard.g("type mismatch.");
    }

    private static int a(com.tencent.bugly.proguard.i.a aVar, java.nio.ByteBuffer byteBuffer) {
        byte b = byteBuffer.get();
        aVar.f437a = (byte) (b & 15);
        aVar.b = (b & 240) >> 4;
        if (aVar.b != 15) {
            return 1;
        }
        aVar.b = byteBuffer.get();
        return 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <K, V> java.util.Map<K, V> a(java.util.Map<K, V> map, java.util.Map<K, V> map2, int i, boolean z) {
        if (map2 == null || map2.isEmpty()) {
            return new java.util.HashMap();
        }
        java.util.Map.Entry<K, V> next = map2.entrySet().iterator().next();
        K key = next.getKey();
        V value = next.getValue();
        if (a(i)) {
            com.tencent.bugly.proguard.i.a aVar = new com.tencent.bugly.proguard.i.a();
            a(aVar, this.f436a);
            if (aVar.f437a != 8) {
                throw new com.tencent.bugly.proguard.g("type mismatch.");
            }
            int iA = a(0, 0, true);
            if (iA < 0) {
                throw new com.tencent.bugly.proguard.g("size invalid: " + iA);
            }
            for (int i2 = 0; i2 < iA; i2++) {
                map.put(a(key, 0, true), a(value, 1, true));
            }
        } else if (z) {
            throw new com.tencent.bugly.proguard.g("require field not exist.");
        }
        return map;
    }

    private void a() {
        com.tencent.bugly.proguard.i.a aVar = new com.tencent.bugly.proguard.i.a();
        do {
            a(aVar, this.f436a);
            a(aVar.f437a);
        } while (aVar.f437a != 11);
    }

    private void a(byte b) {
        int i = 0;
        switch (b) {
            case 0:
                java.nio.ByteBuffer byteBuffer = this.f436a;
                byteBuffer.position(byteBuffer.position() + 1);
                return;
            case 1:
                java.nio.ByteBuffer byteBuffer2 = this.f436a;
                byteBuffer2.position(byteBuffer2.position() + 2);
                return;
            case 2:
                java.nio.ByteBuffer byteBuffer3 = this.f436a;
                byteBuffer3.position(byteBuffer3.position() + 4);
                return;
            case 3:
                java.nio.ByteBuffer byteBuffer4 = this.f436a;
                byteBuffer4.position(byteBuffer4.position() + 8);
                return;
            case 4:
                java.nio.ByteBuffer byteBuffer5 = this.f436a;
                byteBuffer5.position(byteBuffer5.position() + 4);
                return;
            case 5:
                java.nio.ByteBuffer byteBuffer6 = this.f436a;
                byteBuffer6.position(byteBuffer6.position() + 8);
                return;
            case 6:
                int i2 = this.f436a.get();
                if (i2 < 0) {
                    i2 += 256;
                }
                java.nio.ByteBuffer byteBuffer7 = this.f436a;
                byteBuffer7.position(byteBuffer7.position() + i2);
                return;
            case 7:
                int i3 = this.f436a.getInt();
                java.nio.ByteBuffer byteBuffer8 = this.f436a;
                byteBuffer8.position(byteBuffer8.position() + i3);
                return;
            case 8:
                int iA = a(0, 0, true);
                while (i < (iA << 1)) {
                    com.tencent.bugly.proguard.i.a aVar = new com.tencent.bugly.proguard.i.a();
                    a(aVar, this.f436a);
                    a(aVar.f437a);
                    i++;
                }
                return;
            case 9:
                int iA2 = a(0, 0, true);
                while (i < iA2) {
                    com.tencent.bugly.proguard.i.a aVar2 = new com.tencent.bugly.proguard.i.a();
                    a(aVar2, this.f436a);
                    a(aVar2.f437a);
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
                com.tencent.bugly.proguard.i.a aVar3 = new com.tencent.bugly.proguard.i.a();
                a(aVar3, this.f436a);
                if (aVar3.f437a == 0) {
                    int iA3 = a(0, 0, true);
                    java.nio.ByteBuffer byteBuffer9 = this.f436a;
                    byteBuffer9.position(byteBuffer9.position() + iA3);
                    return;
                } else {
                    throw new com.tencent.bugly.proguard.g("skipField with invalid type, type value: " + ((int) b) + ", " + ((int) aVar3.f437a));
                }
            default:
                throw new com.tencent.bugly.proguard.g("invalid type.");
        }
    }

    private boolean a(int i) {
        try {
            com.tencent.bugly.proguard.i.a aVar = new com.tencent.bugly.proguard.i.a();
            while (true) {
                int iA = a(aVar, this.f436a.duplicate());
                if (i <= aVar.b || aVar.f437a == 11) {
                    break;
                    break;
                }
                this.f436a.position(this.f436a.position() + iA);
                a(aVar.f437a);
            }
            return i == aVar.b;
        } catch (com.tencent.bugly.proguard.g | java.nio.BufferUnderflowException unused) {
            return false;
        }
    }

    private <T> T[] a(T[] tArr, int i, boolean z) {
        if (tArr == null || tArr.length == 0) {
            throw new com.tencent.bugly.proguard.g("unable to get type of key and value.");
        }
        return (T[]) b(tArr[0], i, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private <T> T[] b(T t, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new com.tencent.bugly.proguard.g("require field not exist.");
            }
            return null;
        }
        com.tencent.bugly.proguard.i.a aVar = new com.tencent.bugly.proguard.i.a();
        a(aVar, this.f436a);
        if (aVar.f437a != 9) {
            throw new com.tencent.bugly.proguard.g("type mismatch.");
        }
        int iA = a(0, 0, true);
        if (iA < 0) {
            throw new com.tencent.bugly.proguard.g("size invalid: " + iA);
        }
        T[] tArr = (T[]) ((java.lang.Object[]) java.lang.reflect.Array.newInstance(t.getClass(), iA));
        for (int i2 = 0; i2 < iA; i2++) {
            tArr[i2] = a((java.lang.Object) t, 0, true);
        }
        return tArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean[] d(int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new com.tencent.bugly.proguard.g("require field not exist.");
            }
            return null;
        }
        com.tencent.bugly.proguard.i.a aVar = new com.tencent.bugly.proguard.i.a();
        a(aVar, this.f436a);
        if (aVar.f437a != 9) {
            throw new com.tencent.bugly.proguard.g("type mismatch.");
        }
        int iA = a(0, 0, true);
        if (iA < 0) {
            throw new com.tencent.bugly.proguard.g("size invalid: " + iA);
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
                throw new com.tencent.bugly.proguard.g("require field not exist.");
            }
            return null;
        }
        com.tencent.bugly.proguard.i.a aVar = new com.tencent.bugly.proguard.i.a();
        a(aVar, this.f436a);
        if (aVar.f437a != 9) {
            throw new com.tencent.bugly.proguard.g("type mismatch.");
        }
        int iA = a(0, 0, true);
        if (iA < 0) {
            throw new com.tencent.bugly.proguard.g("size invalid: " + iA);
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
                throw new com.tencent.bugly.proguard.g("require field not exist.");
            }
            return null;
        }
        com.tencent.bugly.proguard.i.a aVar = new com.tencent.bugly.proguard.i.a();
        a(aVar, this.f436a);
        if (aVar.f437a != 9) {
            throw new com.tencent.bugly.proguard.g("type mismatch.");
        }
        int iA = a(0, 0, true);
        if (iA < 0) {
            throw new com.tencent.bugly.proguard.g("size invalid: " + iA);
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
                throw new com.tencent.bugly.proguard.g("require field not exist.");
            }
            return null;
        }
        com.tencent.bugly.proguard.i.a aVar = new com.tencent.bugly.proguard.i.a();
        a(aVar, this.f436a);
        if (aVar.f437a != 9) {
            throw new com.tencent.bugly.proguard.g("type mismatch.");
        }
        int iA = a(0, 0, true);
        if (iA < 0) {
            throw new com.tencent.bugly.proguard.g("size invalid: " + iA);
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
                throw new com.tencent.bugly.proguard.g("require field not exist.");
            }
            return null;
        }
        com.tencent.bugly.proguard.i.a aVar = new com.tencent.bugly.proguard.i.a();
        a(aVar, this.f436a);
        if (aVar.f437a != 9) {
            throw new com.tencent.bugly.proguard.g("type mismatch.");
        }
        int iA = a(0, 0, true);
        if (iA < 0) {
            throw new com.tencent.bugly.proguard.g("size invalid: " + iA);
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
                throw new com.tencent.bugly.proguard.g("require field not exist.");
            }
            return null;
        }
        com.tencent.bugly.proguard.i.a aVar = new com.tencent.bugly.proguard.i.a();
        a(aVar, this.f436a);
        if (aVar.f437a != 9) {
            throw new com.tencent.bugly.proguard.g("type mismatch.");
        }
        int iA = a(0, 0, true);
        if (iA < 0) {
            throw new com.tencent.bugly.proguard.g("size invalid: " + iA);
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
                throw new com.tencent.bugly.proguard.g("require field not exist.");
            }
            return b;
        }
        com.tencent.bugly.proguard.i.a aVar = new com.tencent.bugly.proguard.i.a();
        a(aVar, this.f436a);
        byte b2 = aVar.f437a;
        if (b2 == 0) {
            return this.f436a.get();
        }
        if (b2 == 12) {
            return (byte) 0;
        }
        throw new com.tencent.bugly.proguard.g("type mismatch.");
    }

    public final int a(int i, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new com.tencent.bugly.proguard.g("require field not exist.");
            }
            return i;
        }
        com.tencent.bugly.proguard.i.a aVar = new com.tencent.bugly.proguard.i.a();
        a(aVar, this.f436a);
        byte b = aVar.f437a;
        if (b == 12) {
            return 0;
        }
        switch (b) {
            case 0:
                return this.f436a.get();
            case 1:
                return this.f436a.getShort();
            case 2:
                return this.f436a.getInt();
            default:
                throw new com.tencent.bugly.proguard.g("type mismatch.");
        }
    }

    public final int a(java.lang.String str) {
        this.b = str;
        return 0;
    }

    public final long a(long j, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new com.tencent.bugly.proguard.g("require field not exist.");
            }
            return j;
        }
        com.tencent.bugly.proguard.i.a aVar = new com.tencent.bugly.proguard.i.a();
        a(aVar, this.f436a);
        byte b = aVar.f437a;
        if (b == 12) {
            return 0L;
        }
        switch (b) {
            case 0:
                return this.f436a.get();
            case 1:
                return this.f436a.getShort();
            case 2:
                return this.f436a.getInt();
            case 3:
                return this.f436a.getLong();
            default:
                throw new com.tencent.bugly.proguard.g("type mismatch.");
        }
    }

    public final com.tencent.bugly.proguard.k a(com.tencent.bugly.proguard.k kVar, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new com.tencent.bugly.proguard.g("require field not exist.");
            }
            return null;
        }
        try {
            com.tencent.bugly.proguard.k kVar2 = (com.tencent.bugly.proguard.k) kVar.getClass().newInstance();
            com.tencent.bugly.proguard.i.a aVar = new com.tencent.bugly.proguard.i.a();
            a(aVar, this.f436a);
            if (aVar.f437a != 10) {
                throw new com.tencent.bugly.proguard.g("type mismatch.");
            }
            kVar2.a(this);
            a();
            return kVar2;
        } catch (java.lang.Exception e) {
            throw new com.tencent.bugly.proguard.g(e.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final <T> java.lang.Object a(T t, int i, boolean z) {
        if (t instanceof java.lang.Byte) {
            return java.lang.Byte.valueOf(a((byte) 0, i, z));
        }
        if (t instanceof java.lang.Boolean) {
            return java.lang.Boolean.valueOf(a((byte) 0, i, z) != 0);
        }
        if (t instanceof java.lang.Short) {
            return java.lang.Short.valueOf(a((short) 0, i, z));
        }
        if (t instanceof java.lang.Integer) {
            return java.lang.Integer.valueOf(a(0, i, z));
        }
        if (t instanceof java.lang.Long) {
            return java.lang.Long.valueOf(a(0L, i, z));
        }
        if (t instanceof java.lang.Float) {
            return java.lang.Float.valueOf(a(0.0f, i, z));
        }
        if (t instanceof java.lang.Double) {
            return java.lang.Double.valueOf(a(0.0d, i, z));
        }
        if (t instanceof java.lang.String) {
            return java.lang.String.valueOf(b(i, z));
        }
        if (t instanceof java.util.Map) {
            return (java.util.HashMap) a(new java.util.HashMap(), (java.util.Map) t, i, z);
        }
        if (t instanceof java.util.List) {
            java.util.List list = (java.util.List) t;
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
        if (t instanceof com.tencent.bugly.proguard.k) {
            return a((com.tencent.bugly.proguard.k) t, i, z);
        }
        if (!t.getClass().isArray()) {
            throw new com.tencent.bugly.proguard.g("read object error: unsupport type.");
        }
        if ((t instanceof byte[]) || (t instanceof java.lang.Byte[])) {
            return c(i, z);
        }
        if (t instanceof boolean[]) {
            return d(i, z);
        }
        if (t instanceof short[]) {
            return e(i, z);
        }
        if (t instanceof int[]) {
            return f(i, z);
        }
        if (t instanceof long[]) {
            return g(i, z);
        }
        if (t instanceof float[]) {
            return h(i, z);
        }
        return t instanceof double[] ? i(i, z) : a((java.lang.Object[]) t, i, z);
    }

    public final <K, V> java.util.HashMap<K, V> a(java.util.Map<K, V> map, int i, boolean z) {
        return (java.util.HashMap) a(new java.util.HashMap(), map, i, z);
    }

    public final short a(short s, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new com.tencent.bugly.proguard.g("require field not exist.");
            }
            return s;
        }
        com.tencent.bugly.proguard.i.a aVar = new com.tencent.bugly.proguard.i.a();
        a(aVar, this.f436a);
        byte b = aVar.f437a;
        if (b == 12) {
            return (short) 0;
        }
        switch (b) {
            case 0:
                return this.f436a.get();
            case 1:
                return this.f436a.getShort();
            default:
                throw new com.tencent.bugly.proguard.g("type mismatch.");
        }
    }

    public final void a(byte[] bArr) {
        java.nio.ByteBuffer byteBuffer = this.f436a;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        this.f436a = java.nio.ByteBuffer.wrap(bArr);
    }

    public final boolean a(int i, boolean z) {
        return a((byte) 0, i, z) != 0;
    }

    public final java.lang.String b(int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new com.tencent.bugly.proguard.g("require field not exist.");
            }
            return null;
        }
        com.tencent.bugly.proguard.i.a aVar = new com.tencent.bugly.proguard.i.a();
        a(aVar, this.f436a);
        switch (aVar.f437a) {
            case 6:
                int i2 = this.f436a.get();
                if (i2 < 0) {
                    i2 += 256;
                }
                byte[] bArr = new byte[i2];
                this.f436a.get(bArr);
                try {
                    return new java.lang.String(bArr, this.b);
                } catch (java.io.UnsupportedEncodingException unused) {
                    return new java.lang.String(bArr);
                }
            case 7:
                int i3 = this.f436a.getInt();
                if (i3 > 104857600 || i3 < 0) {
                    throw new com.tencent.bugly.proguard.g("String too long: " + i3);
                }
                byte[] bArr2 = new byte[i3];
                this.f436a.get(bArr2);
                try {
                    return new java.lang.String(bArr2, this.b);
                } catch (java.io.UnsupportedEncodingException unused2) {
                    return new java.lang.String(bArr2);
                }
            default:
                throw new com.tencent.bugly.proguard.g("type mismatch.");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final byte[] c(int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new com.tencent.bugly.proguard.g("require field not exist.");
            }
            return null;
        }
        com.tencent.bugly.proguard.i.a aVar = new com.tencent.bugly.proguard.i.a();
        a(aVar, this.f436a);
        byte b = aVar.f437a;
        if (b == 9) {
            int iA = a(0, 0, true);
            if (iA < 0) {
                throw new com.tencent.bugly.proguard.g("size invalid: " + iA);
            }
            byte[] bArr = new byte[iA];
            for (int i2 = 0; i2 < iA; i2++) {
                bArr[i2] = a(bArr[0], 0, true);
            }
            return bArr;
        }
        if (b != 13) {
            throw new com.tencent.bugly.proguard.g("type mismatch.");
        }
        com.tencent.bugly.proguard.i.a aVar2 = new com.tencent.bugly.proguard.i.a();
        a(aVar2, this.f436a);
        if (aVar2.f437a != 0) {
            throw new com.tencent.bugly.proguard.g("type mismatch, tag: " + i + ", type: " + ((int) aVar.f437a) + ", " + ((int) aVar2.f437a));
        }
        int iA2 = a(0, 0, true);
        if (iA2 >= 0) {
            byte[] bArr2 = new byte[iA2];
            this.f436a.get(bArr2);
            return bArr2;
        }
        throw new com.tencent.bugly.proguard.g("invalid size, tag: " + i + ", type: " + ((int) aVar.f437a) + ", " + ((int) aVar2.f437a) + ", size: " + iA2);
    }
}
