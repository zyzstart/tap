package com.tencent.yybsdk.apkpatch.f;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class e {
    private static final int a(java.nio.ByteBuffer byteBuffer, int i) {
        return byteBuffer.getShort(i) & com.tencent.smtt.export.external.interfaces.ISelectionInterface.HELD_NOTHING;
    }

    private static final long a(long j) {
        return j & (-1);
    }

    public static final long a(java.lang.String str) throws java.lang.Throwable {
        int iA;
        java.io.File file = new java.io.File(str);
        if (file.length() < 22) {
            java.lang.System.out.println("andygzyu-ZipUtilsERROR/[ZipUtils]findZipEndOfCentralDirectoryRecord, File size smaller than EOCD min size");
            return -1L;
        }
        int iMin = java.lang.Math.min(65557, (int) file.length());
        int i = 0;
        int iMin2 = java.lang.Math.min(8096, iMin);
        long length = file.length();
        long j = iMin2;
        while (true) {
            length -= j;
            if (iMin2 < 22) {
                return -1L;
            }
            java.nio.ByteBuffer byteBufferA = a(file, length, iMin2);
            a(byteBufferA);
            int iCapacity = byteBufferA.capacity() - 22;
            while (iCapacity >= 0) {
                if (byteBufferA.getInt(iCapacity) == 101010256 && (iA = a(byteBufferA, iCapacity + 20)) == i) {
                    if (com.tencent.yybsdk.apkpatch.f.a.b) {
                        java.lang.System.out.println("andygzyu-ZipUtilsDEBUG/[ZipUtils]findZipEndOfCentralDirectoryRecord|actualCommentLength:" + iA);
                    }
                    return length + ((long) iCapacity);
                }
                iCapacity--;
                i++;
            }
            iMin2 = java.lang.Math.min(iMin2, iMin - i);
            j = iMin2 - 21;
        }
    }

    private static final java.nio.ByteBuffer a(java.io.File file, long j, int i) throws java.lang.Throwable {
        byte[] bArr = new byte[i];
        java.io.FileInputStream fileInputStream = null;
        try {
            try {
                try {
                    java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream(file);
                    try {
                        fileInputStream2.skip(j);
                        fileInputStream2.read(bArr, 0, i);
                        fileInputStream2.close();
                    } catch (java.io.IOException e) {
                        e = e;
                        fileInputStream = fileInputStream2;
                        e.printStackTrace();
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        java.nio.ByteBuffer byteBufferWrap = java.nio.ByteBuffer.wrap(bArr);
                        byteBufferWrap.order(java.nio.ByteOrder.LITTLE_ENDIAN);
                        return byteBufferWrap;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (java.io.IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (java.io.IOException e3) {
                    e3.printStackTrace();
                }
            } catch (java.io.IOException e4) {
                e = e4;
            }
            java.nio.ByteBuffer byteBufferWrap2 = java.nio.ByteBuffer.wrap(bArr);
            byteBufferWrap2.order(java.nio.ByteOrder.LITTLE_ENDIAN);
            return byteBufferWrap2;
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    private static final void a(java.nio.ByteBuffer byteBuffer) {
        if (byteBuffer.order() != java.nio.ByteOrder.LITTLE_ENDIAN) {
            throw new java.lang.IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    public static final java.lang.String b(java.lang.String str) throws java.lang.Throwable {
        int iE = e(str);
        return iE > 0 ? com.tencent.yybsdk.apkpatch.f.d.a(str, 0L, iE) : "";
    }

    public static java.util.Map c(java.lang.String str) {
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        try {
            com.tencent.yybsdk.apkpatch.g.a aVar = new com.tencent.yybsdk.apkpatch.g.a(str);
            java.util.Iterator it = aVar.b().values().iterator();
            while (it.hasNext()) {
                java.lang.String str2 = new java.lang.String(((com.tencent.yybsdk.apkpatch.g.e) it.next()).g, "UTF-8");
                linkedHashMap.put(str2, aVar.d(str2));
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return linkedHashMap;
    }

    public static java.util.Map d(java.lang.String str) {
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        try {
            com.tencent.yybsdk.apkpatch.g.a aVar = new com.tencent.yybsdk.apkpatch.g.a(str);
            java.util.Iterator it = aVar.b().values().iterator();
            while (it.hasNext()) {
                java.lang.String str2 = new java.lang.String(((com.tencent.yybsdk.apkpatch.g.e) it.next()).g, "UTF-8");
                linkedHashMap.put(str2, java.lang.Integer.valueOf(aVar.b(str2)));
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return linkedHashMap;
    }

    private static int e(java.lang.String str) throws java.lang.Throwable {
        java.io.RandomAccessFile randomAccessFile;
        int iA = (int) a(str);
        java.nio.channels.FileChannel fileChannel = null;
        try {
            randomAccessFile = new java.io.RandomAccessFile(str, "r");
            try {
                try {
                    java.nio.channels.FileChannel channel = randomAccessFile.getChannel();
                    try {
                        long j = iA;
                        java.nio.MappedByteBuffer map = channel.map(java.nio.channels.FileChannel.MapMode.READ_ONLY, j, channel.size() - j);
                        com.tencent.yybsdk.apkpatch.g.g gVar = new com.tencent.yybsdk.apkpatch.g.g();
                        gVar.a(map);
                        randomAccessFile.seek(gVar.f - 24);
                        long jA = a(randomAccessFile.readLong());
                        byte[] bArr = new byte[16];
                        channel.map(java.nio.channels.FileChannel.MapMode.READ_ONLY, gVar.f - 16, 16L).get(bArr);
                        if (!new java.lang.String(bArr, "UTF-8").equals("APK Sig Block 42")) {
                            int i = gVar.f;
                            if (channel != null) {
                                try {
                                    channel.close();
                                } catch (java.io.IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            try {
                                randomAccessFile.close();
                            } catch (java.io.IOException e2) {
                                e2.printStackTrace();
                            }
                            return i;
                        }
                        int iA2 = (gVar.f - ((int) com.tencent.yybsdk.apkpatch.g.d.a(jA))) - 8;
                        if (channel != null) {
                            try {
                                channel.close();
                            } catch (java.io.IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        try {
                            randomAccessFile.close();
                        } catch (java.io.IOException e4) {
                            e4.printStackTrace();
                        }
                        return iA2;
                    } catch (java.lang.Exception e5) {
                        fileChannel = channel;
                        e = e5;
                        e.printStackTrace();
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                            } catch (java.io.IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (java.io.IOException e7) {
                                e7.printStackTrace();
                            }
                        }
                        return -1;
                    } catch (java.lang.Throwable th) {
                        fileChannel = channel;
                        th = th;
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                            } catch (java.io.IOException e8) {
                                e8.printStackTrace();
                            }
                        }
                        if (randomAccessFile == null) {
                            throw th;
                        }
                        try {
                            randomAccessFile.close();
                            throw th;
                        } catch (java.io.IOException e9) {
                            e9.printStackTrace();
                            throw th;
                        }
                    }
                } catch (java.lang.Exception e10) {
                    e = e10;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.lang.Exception e11) {
            e = e11;
            randomAccessFile = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            randomAccessFile = null;
        }
    }
}
