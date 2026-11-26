package com.tencent.ysdk.shell.module.hades.impl.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class AESHelper {
    private static final java.lang.String TAG = "AESHelper";
    private static final java.lang.String VIPARA = "0102030405060708";

    /* JADX WARN: Code duplicated, block: B:46:0x0096 A[Catch: IOException -> 0x0099, TRY_LEAVE, TryCatch #0 {IOException -> 0x0099, blocks: (B:44:0x0091, B:46:0x0096), top: B:51:0x0091 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.File] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static java.io.File decryptFile(java.lang.String str, java.lang.String str2, java.lang.String str3) throws java.lang.Throwable {
        java.io.FileInputStream fileInputStream;
        java.io.FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    java.io.File file = new java.io.File(str2);
                    str2 = new java.io.File(str3);
                    try {
                        if (file.exists() && file.isFile()) {
                            if (!str2.getParentFile().exists()) {
                                str2.getParentFile().mkdirs();
                            }
                            str2.createNewFile();
                            fileInputStream = new java.io.FileInputStream(file);
                            try {
                                try {
                                    java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream((java.io.File) str2);
                                    try {
                                        javax.crypto.CipherOutputStream cipherOutputStream = new javax.crypto.CipherOutputStream(fileOutputStream2, initAESCipher(str, 2));
                                        byte[] bArr = new byte[1024];
                                        while (true) {
                                            int i = fileInputStream.read(bArr);
                                            if (i < 0) {
                                                break;
                                            }
                                            cipherOutputStream.write(bArr, 0, i);
                                        }
                                        cipherOutputStream.close();
                                        fileOutputStream2.close();
                                    } catch (java.lang.Exception e) {
                                        e = e;
                                        fileOutputStream = fileOutputStream2;
                                        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "error:" + e.getMessage());
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                        if (fileInputStream != null) {
                                        }
                                        return str2;
                                    } catch (java.lang.Throwable th) {
                                        th = th;
                                        fileOutputStream = fileOutputStream2;
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                                if (fileInputStream != null) {
                                                    fileInputStream.close();
                                                }
                                            } catch (java.io.IOException unused) {
                                                throw th;
                                            }
                                        } else if (fileInputStream != null) {
                                            fileInputStream.close();
                                        }
                                        throw th;
                                    }
                                } catch (java.lang.Exception e2) {
                                    e = e2;
                                }
                                fileInputStream.close();
                                return str2;
                            } catch (java.lang.Throwable th2) {
                                th = th2;
                            }
                        }
                        return str2;
                    } catch (java.lang.Exception e3) {
                        e = e3;
                        fileInputStream = null;
                    }
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    fileInputStream = null;
                }
            } catch (java.lang.Exception e4) {
                e = e4;
                str2 = 0;
                fileInputStream = null;
            }
        } catch (java.io.IOException unused2) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:48:0x009f A[Catch: Exception -> 0x00a2, TRY_LEAVE, TryCatch #6 {Exception -> 0x00a2, blocks: (B:46:0x009a, B:48:0x009f), top: B:60:0x009a }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.File] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static java.io.File encryptFile(java.lang.String str, java.lang.String str2, java.lang.String str3) throws java.lang.Throwable {
        java.io.FileInputStream fileInputStream;
        java.io.FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    java.io.File file = new java.io.File(str2);
                    str2 = new java.io.File(str3);
                    try {
                        if (file.exists() && file.isFile()) {
                            if (!str2.getParentFile().exists()) {
                                str2.getParentFile().mkdirs();
                            }
                            str2.createNewFile();
                            fileInputStream = new java.io.FileInputStream(file);
                            try {
                                try {
                                    java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream((java.io.File) str2);
                                    try {
                                        javax.crypto.CipherInputStream cipherInputStream = new javax.crypto.CipherInputStream(fileInputStream, initAESCipher(str, 1));
                                        byte[] bArr = new byte[1024];
                                        while (true) {
                                            int i = cipherInputStream.read(bArr);
                                            if (i == -1) {
                                                break;
                                            }
                                            fileOutputStream2.write(bArr, 0, i);
                                            fileOutputStream2.flush();
                                        }
                                        cipherInputStream.close();
                                        fileOutputStream = fileOutputStream2;
                                    } catch (java.lang.Exception e) {
                                        e = e;
                                        fileOutputStream = fileOutputStream2;
                                        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "Error:=" + e.getMessage());
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                        if (fileInputStream != null) {
                                        }
                                        return str2;
                                    } catch (java.lang.Throwable th) {
                                        th = th;
                                        fileOutputStream = fileOutputStream2;
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                                if (fileInputStream != null) {
                                                    fileInputStream.close();
                                                }
                                            } catch (java.lang.Exception unused) {
                                                throw th;
                                            }
                                        } else if (fileInputStream != null) {
                                            fileInputStream.close();
                                        }
                                        throw th;
                                    }
                                } catch (java.lang.Exception e2) {
                                    e = e2;
                                }
                            } catch (java.lang.Throwable th2) {
                                th = th2;
                            }
                        } else {
                            fileInputStream = null;
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                    } catch (java.lang.Exception e3) {
                        e = e3;
                        fileInputStream = null;
                    }
                } catch (java.lang.Exception unused2) {
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                fileInputStream = null;
            }
        } catch (java.lang.Exception e4) {
            e = e4;
            str2 = 0;
            fileInputStream = null;
        }
        return str2;
    }

    private byte[] getRawKey(java.lang.String str) {
        return com.tencent.ysdk.shell.libware.encrypt.MD5.toMD5Byte(str);
    }

    private static javax.crypto.Cipher initAESCipher(java.lang.String str, int i) {
        javax.crypto.Cipher cipher = null;
        try {
            javax.crypto.spec.IvParameterSpec ivParameterSpec = new javax.crypto.spec.IvParameterSpec(VIPARA.getBytes());
            javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(str.getBytes(), "[REDACTED]");
            cipher = javax.crypto.Cipher.getInstance(com.tencent.ysdk.shell.libware.encrypt.AESHelper.DEFAULT_ALGORITHM);
            cipher.init(i, secretKeySpec, ivParameterSpec);
            return cipher;
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "init error" + e.getMessage());
            return cipher;
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0092 A[Catch: Exception -> 0x008e, TRY_LEAVE, TryCatch #1 {Exception -> 0x008e, blocks: (B:32:0x008a, B:36:0x0092), top: B:53:0x008a }] */
    /* JADX WARN: Code duplicated, block: B:47:0x00a7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:48:0x00a9 A[Catch: Exception -> 0x00a5, TRY_LEAVE, TryCatch #6 {Exception -> 0x00a5, blocks: (B:44:0x00a1, B:48:0x00a9), top: B:59:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x00a1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean aesCipher(int i, java.io.File file, java.io.File file2, java.lang.String str) throws java.lang.Throwable {
        java.nio.channels.FileChannel channel;
        java.nio.channels.FileChannel fileChannel;
        if (i != 1 && i != 2) {
            return false;
        }
        java.nio.channels.FileChannel channel2 = null;
        try {
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CFB/NoPadding");
            byte[] rawKey = getRawKey(str);
            channel = new java.io.RandomAccessFile(file, "r").getChannel();
            try {
                channel2 = new java.io.RandomAccessFile(file2, "rw").getChannel();
                cipher.init(i, new javax.crypto.spec.SecretKeySpec(rawKey, "[REDACTED]"), new javax.crypto.spec.IvParameterSpec(new byte[cipher.getBlockSize()]));
                java.nio.ByteBuffer byteBufferAllocate = java.nio.ByteBuffer.allocate(1024);
                while (channel.read(byteBufferAllocate) != -1) {
                    byteBufferAllocate.flip();
                    byte[] bArr = new byte[byteBufferAllocate.remaining()];
                    byteBufferAllocate.get(bArr, 0, bArr.length);
                    channel2.write(java.nio.ByteBuffer.wrap(cipher.doFinal(bArr)));
                    byteBufferAllocate.clear();
                }
                if (channel != null) {
                    try {
                        channel.close();
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                        return true;
                    }
                }
                if (channel2 == null) {
                    return true;
                }
                channel2.close();
                return true;
            } catch (java.lang.Exception e2) {
                e = e2;
                java.nio.channels.FileChannel fileChannel2 = channel2;
                channel2 = channel;
                fileChannel = fileChannel2;
                try {
                    e.printStackTrace();
                    if (channel2 != null) {
                        try {
                            channel2.close();
                            if (fileChannel != null) {
                                fileChannel.close();
                            }
                        } catch (java.lang.Exception e3) {
                            e3.printStackTrace();
                            return false;
                        }
                    } else if (fileChannel != null) {
                        fileChannel.close();
                    }
                    return false;
                } catch (java.lang.Throwable th) {
                    th = th;
                    java.nio.channels.FileChannel fileChannel3 = channel2;
                    channel2 = fileChannel;
                    channel = fileChannel3;
                    if (channel != null) {
                        try {
                            channel.close();
                            if (channel2 != null) {
                                channel2.close();
                            }
                        } catch (java.lang.Exception e4) {
                            e4.printStackTrace();
                            throw th;
                        }
                    } else if (channel2 != null) {
                        channel2.close();
                    }
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                if (channel != null) {
                    channel.close();
                    if (channel2 != null) {
                        channel2.close();
                    }
                } else if (channel2 != null) {
                    channel2.close();
                }
                throw th;
            }
        } catch (java.lang.Exception e5) {
            e = e5;
            fileChannel = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            channel = null;
        }
    }
}
