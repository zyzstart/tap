package com.qq.taf.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class JceInputStream {
    private java.nio.ByteBuffer bs;
    protected java.lang.String sServerEncoding = "GBK";

    public static class HeadData {
        public int tag;
        public byte type;

        public void clear() {
            this.type = (byte) 0;
            this.tag = 0;
        }
    }

    public JceInputStream() {
    }

    public JceInputStream(java.nio.ByteBuffer byteBuffer) {
        this.bs = byteBuffer;
    }

    public JceInputStream(byte[] bArr) {
        this.bs = java.nio.ByteBuffer.wrap(bArr);
    }

    public JceInputStream(byte[] bArr, int i) {
        java.nio.ByteBuffer byteBufferWrap = java.nio.ByteBuffer.wrap(bArr);
        this.bs = byteBufferWrap;
        byteBufferWrap.position(i);
    }

    public static void main(java.lang.String[] strArr) {
    }

    private int peakHead(com.qq.taf.jce.JceInputStream.HeadData headData) {
        return readHead(headData, this.bs.duplicate());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private java.lang.Object[] readArrayImpl(java.lang.Object obj, int i, boolean z) {
        if (!skipToTag(i)) {
            if (z) {
                throw new com.qq.taf.jce.JceDecodeException("require field not exist.");
            }
            return null;
        }
        com.qq.taf.jce.JceInputStream.HeadData headData = new com.qq.taf.jce.JceInputStream.HeadData();
        readHead(headData);
        if (headData.type != 9) {
            throw new com.qq.taf.jce.JceDecodeException("type mismatch.");
        }
        int i2 = read(0, 0, true);
        if (i2 < 0) {
            throw new com.qq.taf.jce.JceDecodeException("size invalid: " + i2);
        }
        java.lang.Object[] objArr = (java.lang.Object[]) java.lang.reflect.Array.newInstance(obj.getClass(), i2);
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = read(obj, 0, true);
        }
        return objArr;
    }

    public static int readHead(com.qq.taf.jce.JceInputStream.HeadData headData, java.nio.ByteBuffer byteBuffer) {
        byte b = byteBuffer.get();
        headData.type = (byte) (b & 15);
        int i = (b & 240) >> 4;
        headData.tag = i;
        if (i != 15) {
            return 1;
        }
        headData.tag = byteBuffer.get() & 255;
        return 2;
    }

    private java.util.Map readMap(java.util.Map map, java.util.Map map2, int i, boolean z) {
        if (map2 == null || map2.isEmpty()) {
            return new java.util.HashMap();
        }
        java.util.Map.Entry entry = (java.util.Map.Entry) map2.entrySet().iterator().next();
        java.lang.Object key = entry.getKey();
        java.lang.Object value = entry.getValue();
        if (skipToTag(i)) {
            com.qq.taf.jce.JceInputStream.HeadData headData = new com.qq.taf.jce.JceInputStream.HeadData();
            readHead(headData);
            if (headData.type != 8) {
                throw new com.qq.taf.jce.JceDecodeException("type mismatch.");
            }
            int i2 = read(0, 0, true);
            if (i2 < 0) {
                throw new com.qq.taf.jce.JceDecodeException("size invalid: " + i2);
            }
            for (int i3 = 0; i3 < i2; i3++) {
                map.put(read(key, 0, true), read(value, 1, true));
            }
        } else if (z) {
            throw new com.qq.taf.jce.JceDecodeException("require field not exist.");
        }
        return map;
    }

    private void skip(int i) {
        java.nio.ByteBuffer byteBuffer = this.bs;
        byteBuffer.position(byteBuffer.position() + i);
    }

    private void skipField() {
        com.qq.taf.jce.JceInputStream.HeadData headData = new com.qq.taf.jce.JceInputStream.HeadData();
        readHead(headData);
        skipField(headData.type);
    }

    private void skipField(byte b) {
        int i;
        int i2 = 0;
        switch (b) {
            case 0:
                skip(1);
                return;
            case 1:
                skip(2);
                return;
            case 2:
            case 4:
                i = 4;
                break;
            case 3:
            case 5:
                i = 8;
                break;
            case 6:
                i = this.bs.get();
                if (i < 0) {
                    i += 256;
                }
                break;
            case 7:
                i = this.bs.getInt();
                break;
            case 8:
                int i3 = read(0, 0, true);
                while (i2 < i3 * 2) {
                    skipField();
                    i2++;
                }
                return;
            case 9:
                int i4 = read(0, 0, true);
                while (i2 < i4) {
                    skipField();
                    i2++;
                }
                return;
            case 10:
                skipToStructEnd();
                return;
            case 11:
            case 12:
                return;
            case 13:
                com.qq.taf.jce.JceInputStream.HeadData headData = new com.qq.taf.jce.JceInputStream.HeadData();
                readHead(headData);
                if (headData.type != 0) {
                    throw new com.qq.taf.jce.JceDecodeException("skipField with invalid type, type value: " + ((int) b) + ", " + ((int) headData.type));
                }
                i = read(0, 0, true);
                break;
                break;
            default:
                throw new com.qq.taf.jce.JceDecodeException("invalid type.");
        }
        skip(i);
    }

    public com.qq.taf.jce.JceStruct directRead(com.qq.taf.jce.JceStruct jceStruct, int i, boolean z) {
        if (!skipToTag(i)) {
            if (z) {
                throw new com.qq.taf.jce.JceDecodeException("require field not exist.");
            }
            return null;
        }
        try {
            com.qq.taf.jce.JceStruct jceStructNewInit = jceStruct.newInit();
            com.qq.taf.jce.JceInputStream.HeadData headData = new com.qq.taf.jce.JceInputStream.HeadData();
            readHead(headData);
            if (headData.type != 10) {
                throw new com.qq.taf.jce.JceDecodeException("type mismatch.");
            }
            jceStructNewInit.readFrom(this);
            skipToStructEnd();
            return jceStructNewInit;
        } catch (java.lang.Exception e) {
            throw new com.qq.taf.jce.JceDecodeException(e.getMessage());
        }
    }

    public java.nio.ByteBuffer getBs() {
        return this.bs;
    }

    public byte read(byte b, int i, boolean z) {
        if (!skipToTag(i)) {
            if (z) {
                throw new com.qq.taf.jce.JceDecodeException("require field not exist.");
            }
            return b;
        }
        com.qq.taf.jce.JceInputStream.HeadData headData = new com.qq.taf.jce.JceInputStream.HeadData();
        readHead(headData);
        byte b2 = headData.type;
        if (b2 == 0) {
            return this.bs.get();
        }
        if (b2 == 12) {
            return (byte) 0;
        }
        throw new com.qq.taf.jce.JceDecodeException("type mismatch.");
    }

    public double read(double d, int i, boolean z) {
        if (!skipToTag(i)) {
            if (z) {
                throw new com.qq.taf.jce.JceDecodeException("require field not exist.");
            }
            return d;
        }
        com.qq.taf.jce.JceInputStream.HeadData headData = new com.qq.taf.jce.JceInputStream.HeadData();
        readHead(headData);
        byte b = headData.type;
        if (b == 4) {
            return this.bs.getFloat();
        }
        if (b == 5) {
            return this.bs.getDouble();
        }
        if (b == 12) {
            return 0.0d;
        }
        throw new com.qq.taf.jce.JceDecodeException("type mismatch.");
    }

    public float read(float f, int i, boolean z) {
        if (!skipToTag(i)) {
            if (z) {
                throw new com.qq.taf.jce.JceDecodeException("require field not exist.");
            }
            return f;
        }
        com.qq.taf.jce.JceInputStream.HeadData headData = new com.qq.taf.jce.JceInputStream.HeadData();
        readHead(headData);
        byte b = headData.type;
        if (b == 4) {
            return this.bs.getFloat();
        }
        if (b == 12) {
            return 0.0f;
        }
        throw new com.qq.taf.jce.JceDecodeException("type mismatch.");
    }

    public int read(int i, int i2, boolean z) {
        if (!skipToTag(i2)) {
            if (z) {
                throw new com.qq.taf.jce.JceDecodeException("require field not exist.");
            }
            return i;
        }
        com.qq.taf.jce.JceInputStream.HeadData headData = new com.qq.taf.jce.JceInputStream.HeadData();
        readHead(headData);
        byte b = headData.type;
        if (b == 0) {
            return this.bs.get();
        }
        if (b == 1) {
            return this.bs.getShort();
        }
        if (b == 2) {
            return this.bs.getInt();
        }
        if (b == 12) {
            return 0;
        }
        throw new com.qq.taf.jce.JceDecodeException("type mismatch.");
    }

    public long read(long j, int i, boolean z) {
        int i2;
        if (!skipToTag(i)) {
            if (z) {
                throw new com.qq.taf.jce.JceDecodeException("require field not exist.");
            }
            return j;
        }
        com.qq.taf.jce.JceInputStream.HeadData headData = new com.qq.taf.jce.JceInputStream.HeadData();
        readHead(headData);
        byte b = headData.type;
        if (b == 12) {
            return 0L;
        }
        switch (b) {
            case 0:
                i2 = this.bs.get();
                break;
            case 1:
                i2 = this.bs.getShort();
                break;
            case 2:
                i2 = this.bs.getInt();
                break;
            case 3:
                return this.bs.getLong();
            default:
                throw new com.qq.taf.jce.JceDecodeException("type mismatch.");
        }
        return i2;
    }

    public com.qq.taf.jce.JceStruct read(com.qq.taf.jce.JceStruct jceStruct, int i, boolean z) {
        if (!skipToTag(i)) {
            if (z) {
                throw new com.qq.taf.jce.JceDecodeException("require field not exist.");
            }
            return null;
        }
        try {
            com.qq.taf.jce.JceStruct jceStruct2 = (com.qq.taf.jce.JceStruct) jceStruct.getClass().newInstance();
            com.qq.taf.jce.JceInputStream.HeadData headData = new com.qq.taf.jce.JceInputStream.HeadData();
            readHead(headData);
            if (headData.type != 10) {
                throw new com.qq.taf.jce.JceDecodeException("type mismatch.");
            }
            jceStruct2.readFrom(this);
            skipToStructEnd();
            return jceStruct2;
        } catch (java.lang.Exception e) {
            throw new com.qq.taf.jce.JceDecodeException(e.getMessage());
        }
    }

    public java.lang.Object read(java.lang.Object obj, int i, boolean z) {
        if (obj instanceof java.lang.Byte) {
            return java.lang.Byte.valueOf(read((byte) 0, i, z));
        }
        if (obj instanceof java.lang.Boolean) {
            return java.lang.Boolean.valueOf(read(false, i, z));
        }
        if (obj instanceof java.lang.Short) {
            return java.lang.Short.valueOf(read((short) 0, i, z));
        }
        if (obj instanceof java.lang.Integer) {
            return java.lang.Integer.valueOf(read(0, i, z));
        }
        if (obj instanceof java.lang.Long) {
            return java.lang.Long.valueOf(read(0L, i, z));
        }
        if (obj instanceof java.lang.Float) {
            return java.lang.Float.valueOf(read(0.0f, i, z));
        }
        if (obj instanceof java.lang.Double) {
            return java.lang.Double.valueOf(read(0.0d, i, z));
        }
        if (obj instanceof java.lang.String) {
            return readString(i, z);
        }
        if (obj instanceof java.util.Map) {
            return readMap((java.util.Map) obj, i, z);
        }
        if (obj instanceof java.util.List) {
            return readArray((java.util.List) obj, i, z);
        }
        if (obj instanceof com.qq.taf.jce.JceStruct) {
            return read((com.qq.taf.jce.JceStruct) obj, i, z);
        }
        if (!obj.getClass().isArray()) {
            throw new com.qq.taf.jce.JceDecodeException("read object error: unsupport type.");
        }
        if ((obj instanceof byte[]) || (obj instanceof java.lang.Byte[])) {
            return read((byte[]) null, i, z);
        }
        if (obj instanceof boolean[]) {
            return read((boolean[]) null, i, z);
        }
        if (obj instanceof short[]) {
            return read((short[]) null, i, z);
        }
        if (obj instanceof int[]) {
            return read((int[]) null, i, z);
        }
        if (obj instanceof long[]) {
            return read((long[]) null, i, z);
        }
        if (obj instanceof float[]) {
            return read((float[]) null, i, z);
        }
        return obj instanceof double[] ? read((double[]) null, i, z) : readArray((java.lang.Object[]) obj, i, z);
    }

    public java.lang.String read(java.lang.String str, int i, boolean z) {
        if (!skipToTag(i)) {
            if (z) {
                throw new com.qq.taf.jce.JceDecodeException("require field not exist.");
            }
            return str;
        }
        com.qq.taf.jce.JceInputStream.HeadData headData = new com.qq.taf.jce.JceInputStream.HeadData();
        readHead(headData);
        byte b = headData.type;
        if (b == 6) {
            int i2 = this.bs.get();
            if (i2 < 0) {
                i2 += 256;
            }
            byte[] bArr = new byte[i2];
            this.bs.get(bArr);
            try {
                return new java.lang.String(bArr, this.sServerEncoding);
            } catch (java.io.UnsupportedEncodingException unused) {
                return new java.lang.String(bArr);
            }
        }
        if (b != 7) {
            throw new com.qq.taf.jce.JceDecodeException("type mismatch.");
        }
        int i3 = this.bs.getInt();
        if (i3 > 104857600 || i3 < 0) {
            throw new com.qq.taf.jce.JceDecodeException("String too long: " + i3);
        }
        byte[] bArr2 = new byte[i3];
        this.bs.get(bArr2);
        try {
            return new java.lang.String(bArr2, this.sServerEncoding);
        } catch (java.io.UnsupportedEncodingException unused2) {
            return new java.lang.String(bArr2);
        }
    }

    public short read(short s, int i, boolean z) {
        if (!skipToTag(i)) {
            if (z) {
                throw new com.qq.taf.jce.JceDecodeException("require field not exist.");
            }
            return s;
        }
        com.qq.taf.jce.JceInputStream.HeadData headData = new com.qq.taf.jce.JceInputStream.HeadData();
        readHead(headData);
        byte b = headData.type;
        if (b == 0) {
            return this.bs.get();
        }
        if (b == 1) {
            return this.bs.getShort();
        }
        if (b == 12) {
            return (short) 0;
        }
        throw new com.qq.taf.jce.JceDecodeException("type mismatch.");
    }

    public boolean read(boolean z, int i, boolean z2) {
        return read((byte) 0, i, z2) != 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public byte[] read(byte[] bArr, int i, boolean z) {
        if (!skipToTag(i)) {
            if (z) {
                throw new com.qq.taf.jce.JceDecodeException("require field not exist.");
            }
            return null;
        }
        com.qq.taf.jce.JceInputStream.HeadData headData = new com.qq.taf.jce.JceInputStream.HeadData();
        readHead(headData);
        byte b = headData.type;
        if (b == 9) {
            int i2 = read(0, 0, true);
            if (i2 < 0) {
                throw new com.qq.taf.jce.JceDecodeException("size invalid: " + i2);
            }
            byte[] bArr2 = new byte[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                bArr2[i3] = read(bArr2[0], 0, true);
            }
            return bArr2;
        }
        if (b != 13) {
            throw new com.qq.taf.jce.JceDecodeException("type mismatch.");
        }
        com.qq.taf.jce.JceInputStream.HeadData headData2 = new com.qq.taf.jce.JceInputStream.HeadData();
        readHead(headData2);
        if (headData2.type != 0) {
            throw new com.qq.taf.jce.JceDecodeException("type mismatch, tag: " + i + ", type: " + ((int) headData.type) + ", " + ((int) headData2.type));
        }
        int i4 = read(0, 0, true);
        if (i4 >= 0) {
            byte[] bArr3 = new byte[i4];
            this.bs.get(bArr3);
            return bArr3;
        }
        throw new com.qq.taf.jce.JceDecodeException("invalid size, tag: " + i + ", type: " + ((int) headData.type) + ", " + ((int) headData2.type) + ", size: " + i4);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public double[] read(double[] dArr, int i, boolean z) {
        if (!skipToTag(i)) {
            if (z) {
                throw new com.qq.taf.jce.JceDecodeException("require field not exist.");
            }
            return null;
        }
        com.qq.taf.jce.JceInputStream.HeadData headData = new com.qq.taf.jce.JceInputStream.HeadData();
        readHead(headData);
        if (headData.type != 9) {
            throw new com.qq.taf.jce.JceDecodeException("type mismatch.");
        }
        int i2 = read(0, 0, true);
        if (i2 < 0) {
            throw new com.qq.taf.jce.JceDecodeException("size invalid: " + i2);
        }
        double[] dArr2 = new double[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            dArr2[i3] = read(dArr2[0], 0, true);
        }
        return dArr2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float[] read(float[] fArr, int i, boolean z) {
        if (!skipToTag(i)) {
            if (z) {
                throw new com.qq.taf.jce.JceDecodeException("require field not exist.");
            }
            return null;
        }
        com.qq.taf.jce.JceInputStream.HeadData headData = new com.qq.taf.jce.JceInputStream.HeadData();
        readHead(headData);
        if (headData.type != 9) {
            throw new com.qq.taf.jce.JceDecodeException("type mismatch.");
        }
        int i2 = read(0, 0, true);
        if (i2 < 0) {
            throw new com.qq.taf.jce.JceDecodeException("size invalid: " + i2);
        }
        float[] fArr2 = new float[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            fArr2[i3] = read(fArr2[0], 0, true);
        }
        return fArr2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int[] read(int[] iArr, int i, boolean z) {
        if (!skipToTag(i)) {
            if (z) {
                throw new com.qq.taf.jce.JceDecodeException("require field not exist.");
            }
            return null;
        }
        com.qq.taf.jce.JceInputStream.HeadData headData = new com.qq.taf.jce.JceInputStream.HeadData();
        readHead(headData);
        if (headData.type != 9) {
            throw new com.qq.taf.jce.JceDecodeException("type mismatch.");
        }
        int i2 = read(0, 0, true);
        if (i2 < 0) {
            throw new com.qq.taf.jce.JceDecodeException("size invalid: " + i2);
        }
        int[] iArr2 = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            iArr2[i3] = read(iArr2[0], 0, true);
        }
        return iArr2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long[] read(long[] jArr, int i, boolean z) {
        if (!skipToTag(i)) {
            if (z) {
                throw new com.qq.taf.jce.JceDecodeException("require field not exist.");
            }
            return null;
        }
        com.qq.taf.jce.JceInputStream.HeadData headData = new com.qq.taf.jce.JceInputStream.HeadData();
        readHead(headData);
        if (headData.type != 9) {
            throw new com.qq.taf.jce.JceDecodeException("type mismatch.");
        }
        int i2 = read(0, 0, true);
        if (i2 < 0) {
            throw new com.qq.taf.jce.JceDecodeException("size invalid: " + i2);
        }
        long[] jArr2 = new long[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            jArr2[i3] = read(jArr2[0], 0, true);
        }
        return jArr2;
    }

    public com.qq.taf.jce.JceStruct[] read(com.qq.taf.jce.JceStruct[] jceStructArr, int i, boolean z) {
        return (com.qq.taf.jce.JceStruct[]) readArray(jceStructArr, i, z);
    }

    public java.lang.String[] read(java.lang.String[] strArr, int i, boolean z) {
        return (java.lang.String[]) readArray(strArr, i, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public short[] read(short[] sArr, int i, boolean z) {
        if (!skipToTag(i)) {
            if (z) {
                throw new com.qq.taf.jce.JceDecodeException("require field not exist.");
            }
            return null;
        }
        com.qq.taf.jce.JceInputStream.HeadData headData = new com.qq.taf.jce.JceInputStream.HeadData();
        readHead(headData);
        if (headData.type != 9) {
            throw new com.qq.taf.jce.JceDecodeException("type mismatch.");
        }
        int i2 = read(0, 0, true);
        if (i2 < 0) {
            throw new com.qq.taf.jce.JceDecodeException("size invalid: " + i2);
        }
        short[] sArr2 = new short[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            sArr2[i3] = read(sArr2[0], 0, true);
        }
        return sArr2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean[] read(boolean[] zArr, int i, boolean z) {
        if (!skipToTag(i)) {
            if (z) {
                throw new com.qq.taf.jce.JceDecodeException("require field not exist.");
            }
            return null;
        }
        com.qq.taf.jce.JceInputStream.HeadData headData = new com.qq.taf.jce.JceInputStream.HeadData();
        readHead(headData);
        if (headData.type != 9) {
            throw new com.qq.taf.jce.JceDecodeException("type mismatch.");
        }
        int i2 = read(0, 0, true);
        if (i2 < 0) {
            throw new com.qq.taf.jce.JceDecodeException("size invalid: " + i2);
        }
        boolean[] zArr2 = new boolean[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            zArr2[i3] = read(zArr2[0], 0, true);
        }
        return zArr2;
    }

    public java.util.List readArray(java.util.List list, int i, boolean z) {
        if (list == null || list.isEmpty()) {
            return new java.util.ArrayList();
        }
        java.lang.Object[] arrayImpl = readArrayImpl(list.get(0), i, z);
        if (arrayImpl == null) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.Object obj : arrayImpl) {
            arrayList.add(obj);
        }
        return arrayList;
    }

    public java.lang.Object[] readArray(java.lang.Object[] objArr, int i, boolean z) {
        if (objArr == null || objArr.length == 0) {
            throw new com.qq.taf.jce.JceDecodeException("unable to get type of key and value.");
        }
        return readArrayImpl(objArr[0], i, z);
    }

    public java.lang.String readByteString(java.lang.String str, int i, boolean z) {
        int i2;
        if (!skipToTag(i)) {
            if (z) {
                throw new com.qq.taf.jce.JceDecodeException("require field not exist.");
            }
            return str;
        }
        com.qq.taf.jce.JceInputStream.HeadData headData = new com.qq.taf.jce.JceInputStream.HeadData();
        readHead(headData);
        byte b = headData.type;
        if (b == 6) {
            i2 = this.bs.get();
            if (i2 < 0) {
                i2 += 256;
            }
        } else {
            if (b != 7) {
                throw new com.qq.taf.jce.JceDecodeException("type mismatch.");
            }
            i2 = this.bs.getInt();
            if (i2 > 104857600 || i2 < 0) {
                throw new com.qq.taf.jce.JceDecodeException("String too long: " + i2);
            }
        }
        byte[] bArr = new byte[i2];
        this.bs.get(bArr);
        return com.qq.taf.jce.HexUtil.bytes2HexStr(bArr);
    }

    public void readHead(com.qq.taf.jce.JceInputStream.HeadData headData) {
        readHead(headData, this.bs);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public java.util.List readList(int i, boolean z) {
        int i2;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (skipToTag(i)) {
            com.qq.taf.jce.JceInputStream.HeadData headData = new com.qq.taf.jce.JceInputStream.HeadData();
            readHead(headData);
            if (headData.type != 9) {
                throw new com.qq.taf.jce.JceDecodeException("type mismatch.");
            }
            int i3 = read(0, 0, true);
            if (i3 < 0) {
                throw new com.qq.taf.jce.JceDecodeException("size invalid: " + i3);
            }
            for (int i4 = 0; i4 < i3; i4++) {
                com.qq.taf.jce.JceInputStream.HeadData headData2 = new com.qq.taf.jce.JceInputStream.HeadData();
                readHead(headData2);
                switch (headData2.type) {
                    case 0:
                        skip(1);
                        continue;
                        break;
                    case 1:
                        i2 = 2;
                        break;
                    case 2:
                    case 4:
                        i2 = 4;
                        break;
                    case 3:
                    case 5:
                        i2 = 8;
                        break;
                    case 6:
                        i2 = this.bs.get();
                        if (i2 < 0) {
                            i2 += 256;
                        }
                        break;
                    case 7:
                        i2 = this.bs.getInt();
                        break;
                    case 8:
                    case 9:
                        continue;
                        break;
                    case 10:
                        try {
                            com.qq.taf.jce.JceStruct jceStruct = (com.qq.taf.jce.JceStruct) java.lang.Class.forName(com.qq.taf.jce.JceStruct.class.getName()).getConstructor(new java.lang.Class[0]).newInstance(new java.lang.Object[0]);
                            jceStruct.readFrom(this);
                            skipToStructEnd();
                            arrayList.add(jceStruct);
                            continue;
                        } catch (java.lang.Exception e) {
                            e.printStackTrace();
                            throw new com.qq.taf.jce.JceDecodeException("type mismatch." + e);
                        }
                        break;
                    case 11:
                    default:
                        throw new com.qq.taf.jce.JceDecodeException("type mismatch.");
                    case 12:
                        arrayList.add(new java.lang.Integer(0));
                        continue;
                        break;
                }
                skip(i2);
            }
        } else if (z) {
            throw new com.qq.taf.jce.JceDecodeException("require field not exist.");
        }
        return arrayList;
    }

    public java.util.HashMap readMap(java.util.Map map, int i, boolean z) {
        return (java.util.HashMap) readMap(new java.util.HashMap(), map, i, z);
    }

    public java.lang.String readString(int i, boolean z) {
        if (!skipToTag(i)) {
            if (z) {
                throw new com.qq.taf.jce.JceDecodeException("require field not exist.");
            }
            return null;
        }
        com.qq.taf.jce.JceInputStream.HeadData headData = new com.qq.taf.jce.JceInputStream.HeadData();
        readHead(headData);
        byte b = headData.type;
        if (b == 6) {
            int i2 = this.bs.get();
            if (i2 < 0) {
                i2 += 256;
            }
            byte[] bArr = new byte[i2];
            this.bs.get(bArr);
            try {
                return new java.lang.String(bArr, this.sServerEncoding);
            } catch (java.io.UnsupportedEncodingException unused) {
                return new java.lang.String(bArr);
            }
        }
        if (b != 7) {
            throw new com.qq.taf.jce.JceDecodeException("type mismatch.");
        }
        int i3 = this.bs.getInt();
        if (i3 > 104857600 || i3 < 0) {
            throw new com.qq.taf.jce.JceDecodeException("String too long: " + i3);
        }
        byte[] bArr2 = new byte[i3];
        this.bs.get(bArr2);
        try {
            return new java.lang.String(bArr2, this.sServerEncoding);
        } catch (java.io.UnsupportedEncodingException unused2) {
            return new java.lang.String(bArr2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public java.util.Map readStringMap(int i, boolean z) {
        java.util.HashMap map = new java.util.HashMap();
        if (skipToTag(i)) {
            com.qq.taf.jce.JceInputStream.HeadData headData = new com.qq.taf.jce.JceInputStream.HeadData();
            readHead(headData);
            if (headData.type != 8) {
                throw new com.qq.taf.jce.JceDecodeException("type mismatch.");
            }
            int i2 = read(0, 0, true);
            if (i2 < 0) {
                throw new com.qq.taf.jce.JceDecodeException("size invalid: " + i2);
            }
            for (int i3 = 0; i3 < i2; i3++) {
                map.put(readString(0, true), readString(1, true));
            }
        } else if (z) {
            throw new com.qq.taf.jce.JceDecodeException("require field not exist.");
        }
        return map;
    }

    public int setServerEncoding(java.lang.String str) {
        this.sServerEncoding = str;
        return 0;
    }

    public void skipToStructEnd() {
        com.qq.taf.jce.JceInputStream.HeadData headData = new com.qq.taf.jce.JceInputStream.HeadData();
        do {
            readHead(headData);
            skipField(headData.type);
        } while (headData.type != 11);
    }

    public boolean skipToTag(int i) {
        try {
            com.qq.taf.jce.JceInputStream.HeadData headData = new com.qq.taf.jce.JceInputStream.HeadData();
            while (true) {
                int iPeakHead = peakHead(headData);
                if (headData.type == 11) {
                    return false;
                }
                if (i <= headData.tag) {
                    return i == headData.tag;
                }
                skip(iPeakHead);
                skipField(headData.type);
            }
        } catch (com.qq.taf.jce.JceDecodeException | java.nio.BufferUnderflowException unused) {
            return false;
        }
    }

    public void warp(byte[] bArr) {
        wrap(bArr);
    }

    public void wrap(byte[] bArr) {
        this.bs = java.nio.ByteBuffer.wrap(bArr);
    }
}
