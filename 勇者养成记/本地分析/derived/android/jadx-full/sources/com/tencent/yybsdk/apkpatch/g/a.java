package com.tencent.yybsdk.apkpatch.g;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {
    java.lang.String d;
    public java.io.RandomAccessFile e;
    private java.nio.channels.FileChannel f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    java.util.HashMap f1424a = new java.util.HashMap();
    java.util.LinkedHashMap b = new java.util.LinkedHashMap();
    com.tencent.yybsdk.apkpatch.g.g c = new com.tencent.yybsdk.apkpatch.g.g();
    private int g = 0;

    public a(java.lang.String str) throws java.io.IOException {
        this.d = null;
        this.e = null;
        this.f = null;
        try {
            this.d = str;
            java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(str, "r");
            this.e = randomAccessFile;
            this.f = randomAccessFile.getChannel();
            e(str);
            d();
            a();
        } catch (java.io.IOException e) {
            java.io.IOException iOException = new java.io.IOException("proCode=" + this.g + "," + e.getMessage());
            iOException.setStackTrace(e.getStackTrace());
            throw iOException;
        }
    }

    private void d() throws java.io.IOException {
        int i = this.c.f;
        java.nio.channels.FileChannel fileChannel = this.f;
        long j = i;
        java.nio.MappedByteBuffer map = fileChannel.map(java.nio.channels.FileChannel.MapMode.READ_ONLY, j, fileChannel.size() - j);
        this.g = 4;
        boolean z = false;
        while (map.remaining() >= 4 && !z) {
            int i2 = map.getInt();
            if (i2 == 1347092738) {
                com.tencent.yybsdk.apkpatch.g.e eVar = new com.tencent.yybsdk.apkpatch.g.e();
                this.g = 5;
                eVar.a(map);
                java.lang.String str = new java.lang.String(eVar.g, "UTF-8");
                this.g = 6;
                this.b.put(str, eVar);
            } else if (i2 == 1347093766) {
                z = true;
            }
        }
        this.g = 7;
    }

    private void e(java.lang.String str) throws java.io.IOException {
        int iA = (int) com.tencent.yybsdk.apkpatch.f.e.a(str);
        java.nio.channels.FileChannel fileChannel = this.f;
        long j = iA;
        this.c.a(fileChannel.map(java.nio.channels.FileChannel.MapMode.READ_ONLY, j, fileChannel.size() - j));
    }

    public com.tencent.yybsdk.apkpatch.g.e a(java.lang.String str) {
        return (com.tencent.yybsdk.apkpatch.g.e) this.b.get(str);
    }

    public void a() throws java.io.IOException {
        for (com.tencent.yybsdk.apkpatch.g.e eVar : this.b.values()) {
            int i = eVar.f;
            java.nio.MappedByteBuffer map = this.f.map(java.nio.channels.FileChannel.MapMode.READ_ONLY, i, 256L);
            if (map.getInt() != 1347093252) {
                throw new java.io.IOException("cdfh offset is error!offset=" + i);
            }
            com.tencent.yybsdk.apkpatch.g.c cVar = new com.tencent.yybsdk.apkpatch.g.c(this);
            map.position(map.position() + 22);
            cVar.f1425a = com.tencent.yybsdk.apkpatch.g.d.a(map.getShort());
            short sA = com.tencent.yybsdk.apkpatch.g.d.a(map.getShort());
            cVar.b = sA;
            int i2 = cVar.f1425a;
            if (i2 < 0) {
                throw new java.lang.NegativeArraySizeException("lfh.fileNameLen is negative!");
            }
            if (sA < 0) {
                throw new java.lang.NegativeArraySizeException("lfh.extraFieldLen is negative!");
            }
            byte[] bArr = new byte[i2];
            cVar.c = bArr;
            map.get(bArr);
            java.lang.String str = new java.lang.String(cVar.c, "UTF-8");
            java.lang.String str2 = new java.lang.String(eVar.g, "UTF-8");
            if (!str.equals(str2)) {
                throw new java.io.IOException("Not equal!,lfh name=" + str + ",cdfh name=" + str2);
            }
            this.f1424a.put(str, cVar);
        }
    }

    public int b(java.lang.String str) throws java.io.FileNotFoundException {
        com.tencent.yybsdk.apkpatch.g.e eVar = (com.tencent.yybsdk.apkpatch.g.e) this.b.get(str);
        if (eVar == null) {
            throw new java.io.FileNotFoundException("getFileDataPosition,file cdf not found");
        }
        com.tencent.yybsdk.apkpatch.g.c cVar = (com.tencent.yybsdk.apkpatch.g.c) this.f1424a.get(str);
        if (cVar != null) {
            return cVar.a() + eVar.f;
        }
        throw new java.io.FileNotFoundException("getFileDataPosition,file lfh not found");
    }

    public java.util.LinkedHashMap b() {
        return this.b;
    }

    public int c(java.lang.String str) throws java.io.FileNotFoundException {
        com.tencent.yybsdk.apkpatch.g.e eVarA = a(str);
        if (eVarA != null) {
            return eVarA.d;
        }
        throw new java.io.FileNotFoundException("getFileDataLength,file not found");
    }

    public void c() throws java.io.IOException {
        this.f.close();
        this.e.close();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public java.lang.String d(java.lang.String str) throws java.io.IOException {
        com.tencent.yybsdk.apkpatch.g.e eVarA = a(str);
        if (eVarA.b == 0) {
            return (((long) eVarA.c) | ((long) eVarA.e)) + "";
        }
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            int iC = c(str);
            int iB = b(str);
            byte[] bArr = new byte[8192];
            int i = 0;
            while (i < iC) {
                int i2 = iC - i;
                if (i2 > 8192) {
                    i2 = 8192;
                }
                this.f.map(java.nio.channels.FileChannel.MapMode.READ_ONLY, iB + i, android.support.v4.media.session.PlaybackStateCompat.ACTION_PLAY_FROM_URI).get(bArr, 0, i2);
                messageDigest.update(bArr, 0, i2);
                i += i2;
            }
            return com.tencent.yybsdk.apkpatch.f.d.a(messageDigest.digest());
        } catch (java.security.NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new java.io.IOException("MD5 is not support");
        }
    }
}
