package com.tencent.smtt.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class e implements java.io.Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final char[] f967a = {127, 'E', 'L', 'F', 0};
    final char[] b = new char[16];
    boolean c;
    com.tencent.smtt.utils.e.j[] d;
    com.tencent.smtt.utils.e.l[] e;
    byte[] f;
    private final com.tencent.smtt.utils.c g;
    private final com.tencent.smtt.utils.e.a h;
    private final com.tencent.smtt.utils.e.k[] i;
    private byte[] j;

    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        short f968a;
        short b;
        int c;
        int d;
        short e;
        short f;
        short g;
        short h;
        short i;
        short j;

        abstract long a();

        abstract long b();
    }

    static class b extends com.tencent.smtt.utils.e.a {
        int k;
        int l;
        int m;

        b() {
        }

        @Override // com.tencent.smtt.utils.e.a
        long a() {
            return this.m;
        }

        @Override // com.tencent.smtt.utils.e.a
        long b() {
            return this.l;
        }
    }

    static class c extends com.tencent.smtt.utils.e.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f969a;
        int b;
        int c;
        int d;
        int e;
        int f;

        c() {
        }
    }

    static class d extends com.tencent.smtt.utils.e.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f970a;
        int b;
        int c;
        int d;
        int e;
        int f;

        d() {
        }

        @Override // com.tencent.smtt.utils.e.k
        public int a() {
            return this.d;
        }

        @Override // com.tencent.smtt.utils.e.k
        public long b() {
            return this.c;
        }
    }

    /* JADX INFO: renamed from: com.tencent.smtt.utils.e$e, reason: collision with other inner class name */
    static class C0038e extends com.tencent.smtt.utils.e.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f971a;
        int b;

        C0038e() {
        }
    }

    static class f extends com.tencent.smtt.utils.e.a {
        long k;
        long l;
        long m;

        f() {
        }

        @Override // com.tencent.smtt.utils.e.a
        long a() {
            return this.m;
        }

        @Override // com.tencent.smtt.utils.e.a
        long b() {
            return this.l;
        }
    }

    static class g extends com.tencent.smtt.utils.e.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f972a;
        long b;
        long c;
        long d;
        long e;
        long f;

        g() {
        }
    }

    static class h extends com.tencent.smtt.utils.e.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f973a;
        long b;
        long c;
        long d;
        long e;
        long f;

        h() {
        }

        @Override // com.tencent.smtt.utils.e.k
        public int a() {
            return (int) this.d;
        }

        @Override // com.tencent.smtt.utils.e.k
        public long b() {
            return this.c;
        }
    }

    static class i extends com.tencent.smtt.utils.e.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f974a;
        long b;

        i() {
        }
    }

    static abstract class j {
        int g;
        int h;

        j() {
        }
    }

    public static abstract class k {
        int g;
        int h;
        int i;
        int j;

        public abstract int a();

        public abstract long b();
    }

    static abstract class l {
        int c;
        char d;
        char e;
        short f;

        l() {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public e(java.io.File file) throws java.io.IOException {
        com.tencent.smtt.utils.e.a aVar;
        com.tencent.smtt.utils.c cVar = new com.tencent.smtt.utils.c(file);
        this.g = cVar;
        cVar.a(this.b);
        if (!a()) {
            throw new java.util.UnknownFormatConversionException("Invalid elf magic: " + file);
        }
        cVar.a(e());
        boolean zD = d();
        if (zD) {
            com.tencent.smtt.utils.e.f fVar = new com.tencent.smtt.utils.e.f();
            fVar.f968a = cVar.a();
            fVar.b = cVar.a();
            fVar.c = cVar.b();
            fVar.k = cVar.c();
            fVar.l = cVar.c();
            fVar.m = cVar.c();
            aVar = fVar;
        } else {
            com.tencent.smtt.utils.e.b bVar = new com.tencent.smtt.utils.e.b();
            bVar.f968a = cVar.a();
            bVar.b = cVar.a();
            bVar.c = cVar.b();
            bVar.k = cVar.b();
            bVar.l = cVar.b();
            bVar.m = cVar.b();
            aVar = bVar;
        }
        this.h = aVar;
        com.tencent.smtt.utils.e.a aVar2 = this.h;
        aVar2.d = cVar.b();
        aVar2.e = cVar.a();
        aVar2.f = cVar.a();
        aVar2.g = cVar.a();
        aVar2.h = cVar.a();
        aVar2.i = cVar.a();
        aVar2.j = cVar.a();
        this.i = new com.tencent.smtt.utils.e.k[aVar2.i];
        for (int i2 = 0; i2 < aVar2.i; i2++) {
            cVar.a(aVar2.a() + ((long) (aVar2.h * i2)));
            if (zD) {
                com.tencent.smtt.utils.e.h hVar = new com.tencent.smtt.utils.e.h();
                hVar.g = cVar.b();
                hVar.h = cVar.b();
                hVar.f973a = cVar.c();
                hVar.b = cVar.c();
                hVar.c = cVar.c();
                hVar.d = cVar.c();
                hVar.i = cVar.b();
                hVar.j = cVar.b();
                hVar.e = cVar.c();
                hVar.f = cVar.c();
                this.i[i2] = hVar;
            } else {
                com.tencent.smtt.utils.e.d dVar = new com.tencent.smtt.utils.e.d();
                dVar.g = cVar.b();
                dVar.h = cVar.b();
                dVar.f970a = cVar.b();
                dVar.b = cVar.b();
                dVar.c = cVar.b();
                dVar.d = cVar.b();
                dVar.i = cVar.b();
                dVar.j = cVar.b();
                dVar.e = cVar.b();
                dVar.f = cVar.b();
                this.i[i2] = dVar;
            }
        }
        short s = aVar2.j;
        if (s > -1) {
            com.tencent.smtt.utils.e.k[] kVarArr = this.i;
            if (s < kVarArr.length) {
                com.tencent.smtt.utils.e.k kVar = kVarArr[s];
                if (kVar.h != 3) {
                    throw new java.util.UnknownFormatConversionException("Wrong string section e_shstrndx=" + ((int) aVar2.j));
                }
                this.j = new byte[kVar.a()];
                cVar.a(kVar.b());
                cVar.a(this.j);
                if (this.c) {
                    f();
                    return;
                }
                return;
            }
        }
        throw new java.util.UnknownFormatConversionException("Invalid e_shstrndx=" + ((int) aVar2.j));
    }

    public static boolean a(java.io.File file) {
        try {
            java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(file, "r");
            long j2 = randomAccessFile.readInt();
            randomAccessFile.close();
            return j2 == 2135247942;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static boolean b(java.io.File file) {
        java.lang.StringBuilder sb;
        java.lang.String str;
        if (!g() || !a(file)) {
            return true;
        }
        try {
            new com.tencent.smtt.utils.e(file);
            return true;
        } catch (java.io.IOException e) {
            android.util.Log.e("ELF", "checkElfFile IOException: " + e);
            return false;
        } catch (java.util.UnknownFormatConversionException e2) {
            e = e2;
            sb = new java.lang.StringBuilder();
            str = "checkElfFile UnknownFormatConversionException: ";
            sb.append(str);
            sb.append(e);
            android.util.Log.e("ELF", sb.toString());
            return true;
        } catch (java.lang.Throwable th) {
            e = th;
            sb = new java.lang.StringBuilder();
            str = "checkElfFile Throwable: ";
            sb.append(str);
            sb.append(e);
            android.util.Log.e("ELF", sb.toString());
            return true;
        }
    }

    private void f() throws java.io.IOException {
        com.tencent.smtt.utils.e.a aVar = this.h;
        com.tencent.smtt.utils.c cVar = this.g;
        boolean zD = d();
        com.tencent.smtt.utils.e.k kVarA = a(".dynsym");
        if (kVarA != null) {
            cVar.a(kVarA.b());
            int iA = kVarA.a() / (zD ? 24 : 16);
            this.e = new com.tencent.smtt.utils.e.l[iA];
            char[] cArr = new char[1];
            for (int i2 = 0; i2 < iA; i2++) {
                if (zD) {
                    com.tencent.smtt.utils.e.i iVar = new com.tencent.smtt.utils.e.i();
                    iVar.c = cVar.b();
                    cVar.a(cArr);
                    iVar.d = cArr[0];
                    cVar.a(cArr);
                    iVar.e = cArr[0];
                    iVar.f974a = cVar.c();
                    iVar.b = cVar.c();
                    iVar.f = cVar.a();
                    this.e[i2] = iVar;
                } else {
                    com.tencent.smtt.utils.e.C0038e c0038e = new com.tencent.smtt.utils.e.C0038e();
                    c0038e.c = cVar.b();
                    c0038e.f971a = cVar.b();
                    c0038e.b = cVar.b();
                    cVar.a(cArr);
                    c0038e.d = cArr[0];
                    cVar.a(cArr);
                    c0038e.e = cArr[0];
                    c0038e.f = cVar.a();
                    this.e[i2] = c0038e;
                }
            }
            com.tencent.smtt.utils.e.k kVar = this.i[kVarA.i];
            cVar.a(kVar.b());
            byte[] bArr = new byte[kVar.a()];
            this.f = bArr;
            cVar.a(bArr);
        }
        this.d = new com.tencent.smtt.utils.e.j[aVar.g];
        for (int i3 = 0; i3 < aVar.g; i3++) {
            cVar.a(aVar.b() + ((long) (aVar.f * i3)));
            if (zD) {
                com.tencent.smtt.utils.e.g gVar = new com.tencent.smtt.utils.e.g();
                gVar.g = cVar.b();
                gVar.h = cVar.b();
                gVar.f972a = cVar.c();
                gVar.b = cVar.c();
                gVar.c = cVar.c();
                gVar.d = cVar.c();
                gVar.e = cVar.c();
                gVar.f = cVar.c();
                this.d[i3] = gVar;
            } else {
                com.tencent.smtt.utils.e.c cVar2 = new com.tencent.smtt.utils.e.c();
                cVar2.g = cVar.b();
                cVar2.h = cVar.b();
                cVar2.f969a = cVar.b();
                cVar2.b = cVar.b();
                cVar2.c = cVar.b();
                cVar2.d = cVar.b();
                cVar2.e = cVar.b();
                cVar2.f = cVar.b();
                this.d[i3] = cVar2;
            }
        }
    }

    private static boolean g() {
        java.lang.String property = java.lang.System.getProperty("java.vm.version");
        return property != null && property.startsWith("2");
    }

    public final com.tencent.smtt.utils.e.k a(java.lang.String str) {
        for (com.tencent.smtt.utils.e.k kVar : this.i) {
            if (str.equals(a(kVar.g))) {
                return kVar;
            }
        }
        return null;
    }

    public final java.lang.String a(int i2) {
        if (i2 == 0) {
            return "SHN_UNDEF";
        }
        int i3 = i2;
        while (true) {
            byte[] bArr = this.j;
            if (bArr[i3] == 0) {
                return new java.lang.String(bArr, i2, i3 - i2);
            }
            i3++;
        }
    }

    final boolean a() {
        return this.b[0] == f967a[0];
    }

    final char b() {
        return this.b[4];
    }

    final char c() {
        return this.b[5];
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.g.close();
    }

    public final boolean d() {
        return b() == 2;
    }

    public final boolean e() {
        return c() == 1;
    }
}
