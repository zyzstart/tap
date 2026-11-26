package com.qq.taf.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class JceOutputStream {
    private java.nio.ByteBuffer bs;
    protected java.lang.String sServerEncoding;

    public JceOutputStream() {
        this(128);
    }

    public JceOutputStream(int i) {
        this.sServerEncoding = "GBK";
        this.bs = java.nio.ByteBuffer.allocate(i);
    }

    public JceOutputStream(java.nio.ByteBuffer byteBuffer) {
        this.sServerEncoding = "GBK";
        this.bs = byteBuffer;
    }

    public static void main(java.lang.String[] strArr) {
        com.qq.taf.jce.JceOutputStream jceOutputStream = new com.qq.taf.jce.JceOutputStream();
        jceOutputStream.write(1311768467283714885L, 0);
        java.lang.System.out.println(com.qq.taf.jce.HexUtil.bytes2HexStr(jceOutputStream.getByteBuffer().array()));
        java.lang.System.out.println(java.util.Arrays.toString(jceOutputStream.toByteArray()));
    }

    private void writeArray(java.lang.Object[] objArr, int i) {
        reserve(8);
        writeHead((byte) 9, i);
        write(objArr.length, 0);
        for (java.lang.Object obj : objArr) {
            write(obj, 0);
        }
    }

    public java.nio.ByteBuffer getByteBuffer() {
        return this.bs;
    }

    public void reserve(int i) {
        if (this.bs.remaining() < i) {
            java.nio.ByteBuffer byteBufferAllocate = java.nio.ByteBuffer.allocate((this.bs.capacity() + i) * 2);
            byteBufferAllocate.put(this.bs.array(), 0, this.bs.position());
            this.bs = byteBufferAllocate;
        }
    }

    public int setServerEncoding(java.lang.String str) {
        this.sServerEncoding = str;
        return 0;
    }

    public byte[] toByteArray() {
        byte[] bArr = new byte[this.bs.position()];
        java.lang.System.arraycopy(this.bs.array(), 0, bArr, 0, this.bs.position());
        return bArr;
    }

    public void write(byte b, int i) {
        reserve(3);
        if (b == 0) {
            writeHead((byte) 12, i);
        } else {
            writeHead((byte) 0, i);
            this.bs.put(b);
        }
    }

    public void write(double d, int i) {
        reserve(10);
        writeHead((byte) 5, i);
        this.bs.putDouble(d);
    }

    public void write(float f, int i) {
        reserve(6);
        writeHead((byte) 4, i);
        this.bs.putFloat(f);
    }

    public void write(int i, int i2) {
        reserve(6);
        if (i >= -32768 && i <= 32767) {
            write((short) i, i2);
        } else {
            writeHead((byte) 2, i2);
            this.bs.putInt(i);
        }
    }

    public void write(long j, int i) {
        reserve(10);
        if (j >= -2147483648L && j <= 2147483647L) {
            write((int) j, i);
        } else {
            writeHead((byte) 3, i);
            this.bs.putLong(j);
        }
    }

    public void write(com.qq.taf.jce.JceStruct jceStruct, int i) {
        reserve(2);
        writeHead((byte) 10, i);
        jceStruct.writeTo(this);
        reserve(2);
        writeHead((byte) 11, 0);
    }

    public void write(java.lang.Boolean bool, int i) {
        write(bool.booleanValue(), i);
    }

    public void write(java.lang.Byte b, int i) {
        write(b.byteValue(), i);
    }

    public void write(java.lang.Double d, int i) {
        write(d.doubleValue(), i);
    }

    public void write(java.lang.Float f, int i) {
        write(f.floatValue(), i);
    }

    public void write(java.lang.Integer num, int i) {
        write(num.intValue(), i);
    }

    public void write(java.lang.Long l, int i) {
        write(l.longValue(), i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void write(java.lang.Object obj, int i) {
        java.util.Collection collection;
        if (obj instanceof java.lang.Byte) {
            write(((java.lang.Byte) obj).byteValue(), i);
            return;
        }
        if (obj instanceof java.lang.Boolean) {
            write(((java.lang.Boolean) obj).booleanValue(), i);
            return;
        }
        if (obj instanceof java.lang.Short) {
            write(((java.lang.Short) obj).shortValue(), i);
            return;
        }
        if (obj instanceof java.lang.Integer) {
            write(((java.lang.Integer) obj).intValue(), i);
            return;
        }
        if (obj instanceof java.lang.Long) {
            write(((java.lang.Long) obj).longValue(), i);
            return;
        }
        if (obj instanceof java.lang.Float) {
            write(((java.lang.Float) obj).floatValue(), i);
            return;
        }
        if (obj instanceof java.lang.Double) {
            write(((java.lang.Double) obj).doubleValue(), i);
            return;
        }
        if (obj instanceof java.lang.String) {
            write((java.lang.String) obj, i);
            return;
        }
        if (obj instanceof java.util.Map) {
            write((java.util.Map) obj, i);
            return;
        }
        if (obj instanceof java.util.List) {
            collection = (java.util.List) obj;
        } else {
            if (obj instanceof com.qq.taf.jce.JceStruct) {
                write((com.qq.taf.jce.JceStruct) obj, i);
                return;
            }
            if (obj instanceof byte[]) {
                write((byte[]) obj, i);
                return;
            }
            if (obj instanceof boolean[]) {
                write((boolean[]) obj, i);
                return;
            }
            if (obj instanceof short[]) {
                write((short[]) obj, i);
                return;
            }
            if (obj instanceof int[]) {
                write((int[]) obj, i);
                return;
            }
            if (obj instanceof long[]) {
                write((long[]) obj, i);
                return;
            }
            if (obj instanceof float[]) {
                write((float[]) obj, i);
                return;
            }
            if (obj instanceof double[]) {
                write((double[]) obj, i);
                return;
            }
            if (obj.getClass().isArray()) {
                writeArray((java.lang.Object[]) obj, i);
                return;
            } else {
                if (!(obj instanceof java.util.Collection)) {
                    throw new com.qq.taf.jce.JceEncodeException("write object error: unsupport type. " + obj.getClass());
                }
                collection = (java.util.Collection) obj;
            }
        }
        write(collection, i);
    }

    public void write(java.lang.Short sh, int i) {
        write(sh.shortValue(), i);
    }

    public void write(java.lang.String str, int i) {
        byte[] bytes;
        try {
            bytes = str.getBytes(this.sServerEncoding);
        } catch (java.io.UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        reserve(bytes.length + 10);
        if (bytes.length > 255) {
            writeHead((byte) 7, i);
            this.bs.putInt(bytes.length);
        } else {
            writeHead((byte) 6, i);
            this.bs.put((byte) bytes.length);
        }
        this.bs.put(bytes);
    }

    public void write(java.util.Collection collection, int i) {
        reserve(8);
        writeHead((byte) 9, i);
        write(collection == null ? 0 : collection.size(), 0);
        if (collection != null) {
            java.util.Iterator it = collection.iterator();
            while (it.hasNext()) {
                write(it.next(), 0);
            }
        }
    }

    public void write(java.util.Map map, int i) {
        reserve(8);
        writeHead((byte) 8, i);
        write(map == null ? 0 : map.size(), 0);
        if (map != null) {
            for (java.util.Map.Entry entry : map.entrySet()) {
                write(entry.getKey(), 0);
                write(entry.getValue(), 1);
            }
        }
    }

    public void write(short s, int i) {
        reserve(4);
        if (s >= -128 && s <= 127) {
            write((byte) s, i);
        } else {
            writeHead((byte) 1, i);
            this.bs.putShort(s);
        }
    }

    public void write(boolean z, int i) {
        write(z ? (byte) 1 : (byte) 0, i);
    }

    public void write(byte[] bArr, int i) {
        reserve(bArr.length + 8);
        writeHead((byte) 13, i);
        writeHead((byte) 0, 0);
        write(bArr.length, 0);
        this.bs.put(bArr);
    }

    public void write(double[] dArr, int i) {
        reserve(8);
        writeHead((byte) 9, i);
        write(dArr.length, 0);
        for (double d : dArr) {
            write(d, 0);
        }
    }

    public void write(float[] fArr, int i) {
        reserve(8);
        writeHead((byte) 9, i);
        write(fArr.length, 0);
        for (float f : fArr) {
            write(f, 0);
        }
    }

    public void write(int[] iArr, int i) {
        reserve(8);
        writeHead((byte) 9, i);
        write(iArr.length, 0);
        for (int i2 : iArr) {
            write(i2, 0);
        }
    }

    public void write(long[] jArr, int i) {
        reserve(8);
        writeHead((byte) 9, i);
        write(jArr.length, 0);
        for (long j : jArr) {
            write(j, 0);
        }
    }

    public void write(java.lang.Object[] objArr, int i) {
        writeArray(objArr, i);
    }

    public void write(short[] sArr, int i) {
        reserve(8);
        writeHead((byte) 9, i);
        write(sArr.length, 0);
        for (short s : sArr) {
            write(s, 0);
        }
    }

    public void write(boolean[] zArr, int i) {
        reserve(8);
        writeHead((byte) 9, i);
        write(zArr.length, 0);
        for (boolean z : zArr) {
            write(z, 0);
        }
    }

    public void writeByteString(java.lang.String str, int i) {
        reserve(str.length() + 10);
        byte[] bArrHexStr2Bytes = com.qq.taf.jce.HexUtil.hexStr2Bytes(str);
        if (bArrHexStr2Bytes.length > 255) {
            writeHead((byte) 7, i);
            this.bs.putInt(bArrHexStr2Bytes.length);
        } else {
            writeHead((byte) 6, i);
            this.bs.put((byte) bArrHexStr2Bytes.length);
        }
        this.bs.put(bArrHexStr2Bytes);
    }

    public void writeHead(byte b, int i) {
        if (i < 15) {
            this.bs.put((byte) (b | (i << 4)));
        } else if (i < 256) {
            this.bs.put((byte) (b | 240));
            this.bs.put((byte) i);
        } else {
            throw new com.qq.taf.jce.JceEncodeException("tag is too large: " + i);
        }
    }

    public void writeStringByte(java.lang.String str, int i) {
        byte[] bArrHexStr2Bytes = com.qq.taf.jce.HexUtil.hexStr2Bytes(str);
        reserve(bArrHexStr2Bytes.length + 10);
        if (bArrHexStr2Bytes.length > 255) {
            writeHead((byte) 7, i);
            this.bs.putInt(bArrHexStr2Bytes.length);
        } else {
            writeHead((byte) 6, i);
            this.bs.put((byte) bArrHexStr2Bytes.length);
        }
        this.bs.put(bArrHexStr2Bytes);
    }
}
