package com.tencent.ydkqmsp.sdk.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f1292a = {49, 99, -3, 81, 63, 117, 116, -14, 40};
    private static final byte[] b = {4, 85, -128};
    private static final byte[] c = {4, 85, -128, 15, 13, 25, 84, -78, 21, 91, -112, 115, 123, 11, 118, -7, 33, 121, -67, 71};
    private static final byte[] d = {-58, -26, -51, -19};
    private static final byte[] e = {-58, -26, -51, -19, 30, -3, -21, -29, 87, 39, 40, 12, -119, -40, -84, 65};
    private static final com.tencent.ydkqmsp.sdk.b.a.b f = com.tencent.ydkqmsp.sdk.b.a.b.AES;
    private static java.lang.ThreadLocal g = new java.lang.ThreadLocal();

    /* JADX INFO: renamed from: com.tencent.ydkqmsp.sdk.b.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0046a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1293a;

        static {
            int[] iArr = new int[com.tencent.ydkqmsp.sdk.b.a.b.values().length];
            f1293a = iArr;
            try {
                iArr[com.tencent.ydkqmsp.sdk.b.a.b.AES.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                f1293a[com.tencent.ydkqmsp.sdk.b.a.b.NONE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
        }
    }

    public enum b {
        UNKNOWN(0, ""),
        AES(1, ""),
        NONE(2, "");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private short f1294a;
        private java.lang.String b;

        b(short s, java.lang.String str) {
            this.f1294a = s;
            this.b = str;
        }

        public static com.tencent.ydkqmsp.sdk.b.a.b a(int i) {
            if (i != 1) {
                return i != 2 ? UNKNOWN : NONE;
            }
            return AES;
        }

        public int a() {
            return this.f1294a;
        }

        @Override // java.lang.Enum
        public java.lang.String toString() {
            return this.b;
        }
    }

    private enum c {
        SUCCESS(0, ""),
        OVERLOAD(1, ""),
        FATAL(2, ""),
        CMD_UNKNOWN(3, ""),
        HOST_UNKNOWN(10, ""),
        CONN_ERR(11, ""),
        SEND_ERR(12, ""),
        RECV_ERR(13, ""),
        WRONG_FORMAT(14, ""),
        SYS_ERR(15, ""),
        DECIPHER_ERR(16, ""),
        DECODE_JSON(20, "");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f1295a;
        private java.lang.String b;

        c(int i, java.lang.String str) {
            this.f1295a = i;
            this.b = str;
        }

        public int a() {
            return this.f1295a;
        }

        @Override // java.lang.Enum
        public java.lang.String toString() {
            return this.b;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public org.json.JSONObject f1296a;
        public int b;

        public d(org.json.JSONObject jSONObject, int i) {
            this.f1296a = jSONObject;
            this.b = i;
        }
    }

    public static com.tencent.ydkqmsp.sdk.b.a.d a(int i, java.lang.String str, int i2, org.json.JSONObject jSONObject) {
        java.io.DataOutputStream dataOutputStream;
        g.set(java.lang.Integer.valueOf(com.tencent.ydkqmsp.sdk.b.a.c.SUCCESS.a()));
        java.net.InetSocketAddress inetSocketAddress = new java.net.InetSocketAddress(com.tencent.ydkqmsp.sdk.f.k.a(f1292a), 33445);
        int i3 = 0;
        while (true) {
            java.io.DataInputStream dataInputStream = null;
            if (i3 >= 1) {
                return new com.tencent.ydkqmsp.sdk.b.a.d(null, ((java.lang.Integer) g.get()).intValue());
            }
            java.net.Socket socket = new java.net.Socket();
            try {
                try {
                    socket.connect(inetSocketAddress, com.tencent.ydkqmsp.sdk.app.a.getAtomConnTimeOut().get());
                    try {
                        dataOutputStream = new java.io.DataOutputStream(new java.io.BufferedOutputStream(socket.getOutputStream()));
                        try {
                            try {
                                a(i, str, i2, jSONObject, dataOutputStream);
                                socket.setSoTimeout(com.tencent.ydkqmsp.sdk.app.a.getAtomReadTimeOut().get());
                                java.io.DataInputStream dataInputStream2 = new java.io.DataInputStream(new java.io.BufferedInputStream(socket.getInputStream()));
                                try {
                                    com.tencent.ydkqmsp.sdk.b.a.d dVar = new com.tencent.ydkqmsp.sdk.b.a.d(a(dataInputStream2), ((java.lang.Integer) g.get()).intValue());
                                    a((java.io.Closeable) dataInputStream2);
                                    a(dataOutputStream);
                                    try {
                                        socket.close();
                                    } catch (java.io.IOException e2) {
                                        e2.printStackTrace();
                                    }
                                    return dVar;
                                } catch (java.lang.Throwable unused) {
                                    dataInputStream = dataInputStream2;
                                    try {
                                        g.set(java.lang.Integer.valueOf(com.tencent.ydkqmsp.sdk.b.a.c.SYS_ERR.a()));
                                        a((java.io.Closeable) dataInputStream);
                                        a(dataOutputStream);
                                        try {
                                            socket.close();
                                        } catch (java.io.IOException e3) {
                                            e3.printStackTrace();
                                        }
                                        i3++;
                                    } catch (java.lang.Throwable th) {
                                        a((java.io.Closeable) dataInputStream);
                                        a(dataOutputStream);
                                        try {
                                            socket.close();
                                        } catch (java.io.IOException e4) {
                                            e4.printStackTrace();
                                        }
                                        throw th;
                                    }
                                }
                            } catch (java.io.IOException unused2) {
                                com.tencent.ydkqmsp.sdk.b.a.d dVar2 = new com.tencent.ydkqmsp.sdk.b.a.d(null, com.tencent.ydkqmsp.sdk.b.a.c.SEND_ERR.a());
                                a((java.io.Closeable) null);
                                a(dataOutputStream);
                                try {
                                    socket.close();
                                } catch (java.io.IOException e5) {
                                    e5.printStackTrace();
                                }
                                return dVar2;
                            }
                        } catch (java.lang.Throwable unused3) {
                        }
                    } catch (java.io.IOException unused4) {
                        dataOutputStream = null;
                    }
                } catch (java.lang.Throwable unused5) {
                    dataOutputStream = null;
                }
            } catch (java.io.IOException unused6) {
                com.tencent.ydkqmsp.sdk.b.a.d dVar3 = new com.tencent.ydkqmsp.sdk.b.a.d(null, com.tencent.ydkqmsp.sdk.b.a.c.CONN_ERR.a());
                a((java.io.Closeable) null);
                a((java.io.Closeable) null);
                try {
                    socket.close();
                } catch (java.io.IOException e6) {
                    e6.printStackTrace();
                }
                return dVar3;
            }
            i3++;
        }
    }

    private static org.json.JSONObject a(com.tencent.ydkqmsp.sdk.b.a.b bVar, byte[] bArr) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        int i = com.tencent.ydkqmsp.sdk.b.a.C0046a.f1293a[bVar.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            return new org.json.JSONObject(new java.lang.String(bArr, java.nio.charset.Charset.forName("UTF-8")));
        }
        javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(e, com.tencent.ydkqmsp.sdk.f.k.a(b));
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(com.tencent.ydkqmsp.sdk.f.k.a(c));
        cipher.init(2, secretKeySpec, new javax.crypto.spec.IvParameterSpec(e));
        return new org.json.JSONObject(new java.lang.String(cipher.doFinal(bArr), java.nio.charset.Charset.forName("UTF-8")));
    }

    private static org.json.JSONObject a(java.io.DataInputStream dataInputStream) {
        java.lang.ThreadLocal threadLocal;
        com.tencent.ydkqmsp.sdk.b.a.c cVar;
        byte[] bArr = new byte[28];
        try {
            dataInputStream.readFully(bArr);
            java.nio.ByteBuffer byteBufferWrap = java.nio.ByteBuffer.wrap(bArr, 18, 10);
            g.set(java.lang.Integer.valueOf(byteBufferWrap.getShort()));
            com.tencent.ydkqmsp.sdk.b.a.b bVarA = com.tencent.ydkqmsp.sdk.b.a.b.a(byteBufferWrap.getShort());
            int i = byteBufferWrap.getShort();
            int i2 = byteBufferWrap.getInt();
            dataInputStream.readFully(new byte[i]);
            byte[] bArr2 = new byte[i2];
            dataInputStream.readFully(bArr2);
            if (i2 == 0) {
                return null;
            }
            try {
                return a(bVarA, bArr2);
            } catch (java.lang.Exception unused) {
                threadLocal = g;
                cVar = com.tencent.ydkqmsp.sdk.b.a.c.DECIPHER_ERR;
                threadLocal.set(java.lang.Integer.valueOf(cVar.a()));
                return null;
            }
        } catch (java.io.IOException unused2) {
            threadLocal = g;
            cVar = com.tencent.ydkqmsp.sdk.b.a.c.RECV_ERR;
        }
    }

    private static void a(int i, java.lang.String str, int i2, org.json.JSONObject jSONObject, java.io.DataOutputStream dataOutputStream) throws java.io.IOException {
        byte[] bytes;
        dataOutputStream.write(d);
        dataOutputStream.writeInt(i);
        dataOutputStream.writeInt(i2);
        dataOutputStream.writeInt(0);
        dataOutputStream.writeShort(0);
        dataOutputStream.writeShort(0);
        com.tencent.ydkqmsp.sdk.b.a.b bVar = f;
        try {
            bytes = a(bVar, jSONObject);
        } catch (java.lang.Exception unused) {
            bytes = jSONObject.toString().getBytes("UTF-8");
            bVar = com.tencent.ydkqmsp.sdk.b.a.b.NONE;
        }
        dataOutputStream.writeShort(bVar.a());
        byte[] bytes2 = str.getBytes("UTF-8");
        dataOutputStream.writeShort(bytes2.length + 3);
        dataOutputStream.writeInt(bytes.length);
        dataOutputStream.write(1);
        dataOutputStream.writeShort(bytes2.length);
        dataOutputStream.write(bytes2);
        dataOutputStream.write(bytes);
        dataOutputStream.flush();
    }

    private static void a(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.io.IOException unused) {
            }
        }
    }

    private static byte[] a(com.tencent.ydkqmsp.sdk.b.a.b bVar, org.json.JSONObject jSONObject) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.io.IOException, java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        byte[] bytes = jSONObject.toString().getBytes("UTF-8");
        int i = com.tencent.ydkqmsp.sdk.b.a.C0046a.f1293a[bVar.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return bytes;
            }
            throw new java.io.IOException("unsupported");
        }
        javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(e, com.tencent.ydkqmsp.sdk.f.k.a(b));
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(com.tencent.ydkqmsp.sdk.f.k.a(c));
        cipher.init(1, secretKeySpec, new javax.crypto.spec.IvParameterSpec(e));
        return cipher.doFinal(bytes);
    }
}
