package com.tencent.ydkqmsp.sdk.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f1341a = {8, 89, -108, 70, 3, 26, 39, -38, 6, 67, -94, 103, 29, 18, 117, -82, 1, 65, -106, 98, 15, 10, 66, -36, 4, 36, -108, 110, 15, 31, 84, -33, 44, 65, -104, 98, 41, 10, 83, -48, 63, 32, -108, 73, 5, 42, 66, -52, 43, 96, -67, 83, 13, 51, 34, -18, 52, 73, -65, 118, 10, 54, 92, -12, 116, 105, -71, 105, 13, 21, 124, -10, 3, 114, -87, 97, 43, 15, 118, -54, 35, 63, -93, 101, 0, 48, 66, -55, 17, 33, -22, 108, 11, 99, 81, -54, 43, 36, -21, 99, 120, 104, 66, -46, 6, 88, -126, 85, 27, 61, 33, -86, 52, 105, -76, 99, 8, 14, 86, -19, 18, 37, -8, 18, 126, 12, 83, -88, 22, 113, -80, 98, 40, 63, 109, -16, 48, 118, -68, 72, 45, 24, 86, -25, 35, 88, -28, 106, 123, 33, 114, -45, 117, 81, -94, 111, 3, 60, 120, -86, 110, 123, -28, 105, 101, 52, 94, -19, 31, 97, -67, 104, 3, 41, 117, -84, 51, 82, -65, 86, 6, 57, 60, -86, 124, 115, -89, 23, 30, 11, 60, -39, 52, 67, -125, 66, 36, 41, 60, -7, 20, 69, -80, 111, 120, 41, 89, -10, 47, 103, -102, 100, 15, 10, 86, -33};
    private static final byte[] b = {8, 84, -26, 87, 39, 47, 127, -49, 22, 81};
    private static final byte[] c = {23, 67, -110};

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1342a;
        public int b;
        public int c;
        public byte[] d;

        private b() {
        }
    }

    public static com.tencent.ydkqmsp.sdk.d.e.b a(java.io.DataInputStream dataInputStream) {
        com.tencent.ydkqmsp.sdk.d.e.b bVar = new com.tencent.ydkqmsp.sdk.d.e.b();
        try {
            bVar.f1342a = dataInputStream.readInt();
            bVar.b = dataInputStream.readInt();
            int i = dataInputStream.readInt();
            bVar.c = i;
            if (i > 0 && i <= 256) {
                byte[] bArr = new byte[i];
                bVar.d = bArr;
                dataInputStream.read(bArr);
                return bVar;
            }
            return null;
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static java.security.PublicKey a(java.lang.String str) {
        if (str == null) {
            str = com.tencent.ydkqmsp.sdk.f.k.a(f1341a);
        }
        try {
            return java.security.KeyFactory.getInstance(com.tencent.ydkqmsp.sdk.f.k.a(c)).generatePublic(new java.security.spec.X509EncodedKeySpec(android.util.Base64.decode(str, 0)));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static boolean a(java.io.DataInputStream dataInputStream, int i, byte[] bArr, java.security.PublicKey publicKey) {
        try {
            java.security.Signature signature = java.security.Signature.getInstance(com.tencent.ydkqmsp.sdk.f.k.a(b));
            signature.initVerify(publicKey);
            byte[] bArr2 = new byte[8192];
            while (true) {
                int i2 = i < 8192 ? dataInputStream.read(bArr2, 0, i) : dataInputStream.read(bArr2);
                if (i2 == 0 || i2 == -1) {
                    break;
                    break;
                }
                signature.update(bArr2, 0, i2);
                i -= i2;
            }
            return signature.verify(bArr);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean a(byte[] bArr, byte[] bArr2, java.security.PublicKey publicKey) {
        try {
            java.security.Signature signature = java.security.Signature.getInstance(com.tencent.ydkqmsp.sdk.f.k.a(b));
            signature.initVerify(publicKey);
            signature.update(bArr);
            return signature.verify(bArr2);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:79:0x0092 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static byte[] a(java.io.File file, java.lang.String str) throws java.lang.Throwable {
        java.io.DataInputStream dataInputStream;
        int i;
        java.io.DataInputStream dataInputStream2 = null;
        if (!file.exists()) {
            return null;
        }
        try {
            dataInputStream = new java.io.DataInputStream(new java.io.FileInputStream(file));
            try {
                try {
                    int iAvailable = dataInputStream.available();
                    if (iAvailable >= 8 && iAvailable <= 5242880) {
                        if (dataInputStream.readInt() != 1364419939) {
                            try {
                                dataInputStream.close();
                            } catch (java.io.IOException e) {
                                e.printStackTrace();
                            }
                            return null;
                        }
                        int i2 = dataInputStream.readInt();
                        if (i2 > 0 && i2 <= 256 && i2 < (i = iAvailable - 8)) {
                            java.security.PublicKey publicKeyA = a(str);
                            if (publicKeyA == null) {
                                try {
                                    dataInputStream.close();
                                } catch (java.io.IOException e2) {
                                    e2.printStackTrace();
                                }
                                return null;
                            }
                            byte[] bArr = new byte[i2];
                            byte[] bArr2 = new byte[i - i2];
                            dataInputStream.read(bArr);
                            dataInputStream.read(bArr2);
                            if (a(bArr2, bArr, publicKeyA)) {
                                try {
                                    dataInputStream.close();
                                } catch (java.io.IOException e3) {
                                    e3.printStackTrace();
                                }
                                return bArr2;
                            }
                        }
                        try {
                            dataInputStream.close();
                        } catch (java.io.IOException e4) {
                            e4.printStackTrace();
                        }
                        return null;
                        try {
                            dataInputStream.close();
                        } catch (java.io.IOException e5) {
                            e5.printStackTrace();
                        }
                        return null;
                    }
                    try {
                        dataInputStream.close();
                    } catch (java.io.IOException e6) {
                        e6.printStackTrace();
                    }
                    return null;
                } catch (java.io.IOException e7) {
                    e = e7;
                    e.printStackTrace();
                    if (dataInputStream != null) {
                    }
                    return null;
                }
            } catch (java.lang.Throwable th) {
                th = th;
                dataInputStream2 = dataInputStream;
                if (dataInputStream2 != null) {
                    try {
                        dataInputStream2.close();
                    } catch (java.io.IOException e8) {
                        e8.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (java.io.IOException e9) {
            e = e9;
            dataInputStream = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            if (dataInputStream2 != null) {
                dataInputStream2.close();
            }
            throw th;
        }
    }

    public static boolean b(java.io.File file, java.lang.String str) throws java.lang.Throwable {
        java.io.DataInputStream dataInputStream;
        if (!file.exists()) {
            return false;
        }
        java.io.DataInputStream dataInputStream2 = null;
        try {
            try {
                dataInputStream = new java.io.DataInputStream(new java.io.FileInputStream(file));
                try {
                    int iAvailable = dataInputStream.available();
                    if (iAvailable <= 140) {
                        try {
                            dataInputStream.close();
                        } catch (java.io.IOException e) {
                            e.printStackTrace();
                        }
                        return false;
                    }
                    int i = iAvailable - com.tencent.smtt.sdk.TbsListener.ErrorCode.NEEDDOWNLOAD_1;
                    dataInputStream.skipBytes(i);
                    com.tencent.ydkqmsp.sdk.d.e.b bVarA = a(dataInputStream);
                    if (bVarA == null) {
                        try {
                            dataInputStream.close();
                        } catch (java.io.IOException e2) {
                            e2.printStackTrace();
                        }
                        return false;
                    }
                    if (bVarA.f1342a != 1364419939) {
                        try {
                            dataInputStream.close();
                        } catch (java.io.IOException e3) {
                            e3.printStackTrace();
                        }
                        return false;
                    }
                    if (bVarA.b > 0 && bVarA.b <= 5242880) {
                        if (i != bVarA.b) {
                            try {
                                dataInputStream.close();
                            } catch (java.io.IOException e4) {
                                e4.printStackTrace();
                            }
                            return false;
                        }
                        java.security.PublicKey publicKeyA = a(str);
                        if (publicKeyA == null) {
                            try {
                                dataInputStream.close();
                            } catch (java.io.IOException e5) {
                                e5.printStackTrace();
                            }
                            return false;
                        }
                        java.io.DataInputStream dataInputStream3 = new java.io.DataInputStream(new java.io.FileInputStream(file));
                        try {
                            boolean zA = a(dataInputStream3, bVarA.b, bVarA.d, publicKeyA);
                            try {
                                dataInputStream.close();
                            } catch (java.io.IOException e6) {
                                e6.printStackTrace();
                            }
                            try {
                                dataInputStream3.close();
                            } catch (java.io.IOException e7) {
                                e7.printStackTrace();
                            }
                            return zA;
                        } catch (java.io.IOException e8) {
                            e = e8;
                            dataInputStream2 = dataInputStream3;
                        } catch (java.lang.Throwable th) {
                            th = th;
                            dataInputStream2 = dataInputStream3;
                            if (dataInputStream != null) {
                                try {
                                    dataInputStream.close();
                                } catch (java.io.IOException e9) {
                                    e9.printStackTrace();
                                }
                            }
                            if (dataInputStream2 == null) {
                                throw th;
                            }
                            try {
                                dataInputStream2.close();
                                throw th;
                            } catch (java.io.IOException e10) {
                                e10.printStackTrace();
                                throw th;
                            }
                        }
                    }
                    try {
                        dataInputStream.close();
                    } catch (java.io.IOException e11) {
                        e11.printStackTrace();
                    }
                    return false;
                } catch (java.io.IOException e12) {
                    e = e12;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.io.IOException e13) {
            e = e13;
            dataInputStream = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            dataInputStream = null;
        }
        e.printStackTrace();
        if (dataInputStream != null) {
            try {
                dataInputStream.close();
            } catch (java.io.IOException e14) {
                e14.printStackTrace();
            }
        }
        if (dataInputStream2 != null) {
            try {
                dataInputStream2.close();
            } catch (java.io.IOException e15) {
                e15.printStackTrace();
            }
        }
        return false;
    }
}
