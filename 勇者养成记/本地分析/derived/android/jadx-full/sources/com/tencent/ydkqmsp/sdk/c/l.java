package com.tencent.ydkqmsp.sdk.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f1329a = {96, 110, -109, 82, 109, 2, 36, -77, 108, 59, -80, 10, 112, 122, 56, -67};

    public java.lang.String a(byte[] bArr) {
        return com.tencent.ydkqmsp.sdk.f.k.a(bArr);
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0048 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean a(java.lang.String str, byte[] bArr, java.lang.String str2, int i) throws java.lang.Throwable {
        java.io.DataOutputStream dataOutputStream;
        java.io.DataOutputStream dataOutputStream2 = 0;
        try {
            if (str2 == null) {
                try {
                    str2 = a(f1329a);
                } catch (java.io.IOException e) {
                    e = e;
                    dataOutputStream = null;
                    e.printStackTrace();
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (java.io.IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    return false;
                } catch (java.lang.Throwable th) {
                    th = th;
                    if (dataOutputStream2 != 0) {
                        try {
                            dataOutputStream2.close();
                        } catch (java.io.IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            byte[] bArrA = new com.tencent.ydkqmsp.sdk.f.b().a(bArr, str2.getBytes());
            if (bArrA == null) {
                return false;
            }
            dataOutputStream = new java.io.DataOutputStream(new java.io.FileOutputStream(str));
            try {
                dataOutputStream.writeInt(305419896);
                dataOutputStream.writeInt(i);
                dataOutputStream.writeInt(1);
                dataOutputStream.write(bArrA);
                try {
                    dataOutputStream.close();
                } catch (java.io.IOException e4) {
                    e4.printStackTrace();
                }
                return true;
            } catch (java.io.IOException e5) {
                e = e5;
                e.printStackTrace();
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }
                return false;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            dataOutputStream2 = str2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.DataInputStream] */
    /* JADX WARN: Type inference failed for: r6v1, types: [boolean] */
    public byte[] a(java.lang.String str, java.lang.String str2, int i) throws java.lang.Throwable {
        java.lang.Throwable th;
        java.io.IOException e;
        java.io.DataInputStream dataInputStream;
        java.io.File file = new java.io.File(str);
        ?? Exists = file.exists();
        ?? r1 = 0;
        try {
            if (Exists == 0) {
                return null;
            }
            try {
                dataInputStream = new java.io.DataInputStream(new java.io.FileInputStream(file));
                try {
                    int iAvailable = dataInputStream.available();
                    if (iAvailable > 12 && iAvailable <= 102400) {
                        if (dataInputStream.readInt() != 305419896) {
                            try {
                                dataInputStream.close();
                            } catch (java.io.IOException e2) {
                                e2.printStackTrace();
                            }
                            return null;
                        }
                        int i2 = dataInputStream.readInt();
                        if (i2 > 0 && i2 <= i) {
                            if (dataInputStream.readInt() != 1) {
                                try {
                                    dataInputStream.close();
                                } catch (java.io.IOException e3) {
                                    e3.printStackTrace();
                                }
                                return null;
                            }
                            int i3 = iAvailable - 12;
                            byte[] bArr = new byte[i3];
                            if (i3 != dataInputStream.read(bArr)) {
                                try {
                                    dataInputStream.close();
                                } catch (java.io.IOException e4) {
                                    e4.printStackTrace();
                                }
                                return null;
                            }
                            if (str2 == null) {
                                str2 = a(f1329a);
                            }
                            byte[] bArrA = new com.tencent.ydkqmsp.sdk.f.b().a(bArr, 0, i3, str2.getBytes());
                            if (bArrA == null) {
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
                            return bArrA;
                        }
                        try {
                            dataInputStream.close();
                        } catch (java.io.IOException e7) {
                            e7.printStackTrace();
                        }
                        return null;
                    }
                    try {
                        dataInputStream.close();
                    } catch (java.io.IOException e8) {
                        e8.printStackTrace();
                    }
                    return null;
                } catch (java.io.IOException e9) {
                    e = e9;
                    e.printStackTrace();
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (java.io.IOException e10) {
                            e10.printStackTrace();
                        }
                    }
                    return null;
                }
            } catch (java.io.IOException e11) {
                e = e11;
                dataInputStream = null;
            } catch (java.lang.Throwable th2) {
                th = th2;
                if (r1 != 0) {
                    try {
                        r1.close();
                    } catch (java.io.IOException e12) {
                        e12.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (java.lang.Throwable th3) {
            r1 = Exists;
            th = th3;
        }
    }
}
