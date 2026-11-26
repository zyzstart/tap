package com.tencent.tmapkupdatesdk.internal.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    java.util.LinkedHashMap f994a = new java.util.LinkedHashMap();
    java.util.LinkedHashMap b = new java.util.LinkedHashMap();
    java.util.ArrayList c = new java.util.ArrayList();
    com.tencent.tmapkupdatesdk.internal.a.d d = new com.tencent.tmapkupdatesdk.internal.a.d();
    long e = 0;
    java.lang.String f = null;

    private void a(java.io.RandomAccessFile randomAccessFile) throws java.io.IOException {
        long j = this.e;
        if (1024 <= j) {
            j = 1024;
        }
        byte[] bArr = new byte[1024];
        randomAccessFile.skipBytes((int) (this.e - j));
        int i = 0;
        randomAccessFile.read(bArr, 0, (int) j);
        while (i < j - 4) {
            int i2 = i + 1;
            if ((bArr[i] << 24) + (bArr[i2] << 16) + (bArr[i + 2] << 8) + bArr[i + 3] == 1347093766) {
                try {
                    int i3 = i + 4;
                    java.io.DataInputStream dataInputStream = new java.io.DataInputStream(new java.io.ByteArrayInputStream(bArr, i3, (int) (j - ((long) i3))));
                    this.d.a(dataInputStream);
                    dataInputStream.close();
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }
            }
            i = i2;
        }
    }

    private void b() throws java.io.IOException {
        java.io.DataInputStream dataInputStream = new java.io.DataInputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(this.f)));
        dataInputStream.skip(this.d.f);
        boolean z = false;
        while (dataInputStream.available() >= 4 && !z) {
            int i = dataInputStream.readInt();
            if (i == 1347092738) {
                com.tencent.tmapkupdatesdk.internal.a.b bVar = new com.tencent.tmapkupdatesdk.internal.a.b();
                bVar.a(dataInputStream);
                java.lang.String str = new java.lang.String(bVar.s, java.nio.charset.Charset.defaultCharset().name());
                if (str.startsWith("META-INF/")) {
                    this.c.add(str);
                }
                this.b.put(str, bVar);
            } else if (i == 1347093766) {
                z = true;
            }
        }
        dataInputStream.close();
    }

    public void a() throws java.io.IOException {
        java.io.DataInputStream dataInputStream = new java.io.DataInputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(this.f)));
        boolean z = false;
        while (dataInputStream.available() >= 4 && !z) {
            int i = dataInputStream.readInt();
            if (i != 1347092738) {
                if (i == 1347093252) {
                    com.tencent.tmapkupdatesdk.internal.a.g gVar = new com.tencent.tmapkupdatesdk.internal.a.g();
                    gVar.a(dataInputStream);
                    java.lang.String str = new java.lang.String(gVar.k, java.nio.charset.Charset.defaultCharset().name());
                    com.tencent.tmapkupdatesdk.internal.a.b bVar = (com.tencent.tmapkupdatesdk.internal.a.b) this.b.get(str);
                    short s = gVar.j;
                    bVar.k = s;
                    if (s > 0) {
                        bVar.t = (byte[]) gVar.l.clone();
                    }
                    int i2 = bVar.h;
                    gVar.g = i2;
                    gVar.h = bVar.i;
                    gVar.f = bVar.g;
                    dataInputStream.skipBytes(i2);
                    this.f994a.put(str, gVar);
                } else if (i != 1347093766) {
                    if (i == 1347094280) {
                        dataInputStream.skipBytes(12);
                    }
                }
            }
            z = true;
        }
        dataInputStream.close();
    }

    public void a(java.lang.String str) throws java.io.IOException {
        this.f = str;
        java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(str, "r");
        this.e = randomAccessFile.length();
        a(randomAccessFile);
        randomAccessFile.close();
        android.util.Log.i("ZipFileParser", "readEndOfCentralDirRecord finished.");
        b();
        android.util.Log.i("ZipFileParser", "readCentralDirFileHeaderList finished.");
        a();
        android.util.Log.i("ZipFileParser", "readLocalFileHeader finished.");
    }

    public com.tencent.tmapkupdatesdk.internal.a.b b(java.lang.String str) {
        return (com.tencent.tmapkupdatesdk.internal.a.b) this.b.get(str);
    }

    public int c(java.lang.String str) throws java.io.FileNotFoundException {
        com.tencent.tmapkupdatesdk.internal.a.b bVar = (com.tencent.tmapkupdatesdk.internal.a.b) this.b.get(str);
        if (bVar == null) {
            throw new java.io.FileNotFoundException();
        }
        com.tencent.tmapkupdatesdk.internal.a.g gVar = (com.tencent.tmapkupdatesdk.internal.a.g) this.f994a.get(str);
        if (gVar != null) {
            return gVar.i + 30 + gVar.j + bVar.q;
        }
        throw new java.io.FileNotFoundException();
    }
}
