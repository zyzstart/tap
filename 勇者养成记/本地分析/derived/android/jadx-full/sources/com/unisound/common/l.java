package com.unisound.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class l implements java.io.Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final java.lang.String f1494a = "journal";
    static final java.lang.String b = "journal.tmp";
    static final java.lang.String c = "libcore.io.DiskLruCache";
    static final java.lang.String d = "1";
    static final long e = -1;
    private static final java.lang.String f = "CLEAN";
    private static final java.lang.String g = "DIRTY";
    private static final java.lang.String h = "REMOVE";
    private static final java.lang.String i = "READ";
    private static final java.nio.charset.Charset j = java.nio.charset.Charset.forName("UTF-8");
    private static final int k = 8192;
    private final java.io.File l;
    private final java.io.File m;
    private final java.io.File n;
    private final int o;
    private final long p;
    private final int q;
    private java.io.Writer s;
    private int u;
    private long r = 0;
    private final java.util.LinkedHashMap<java.lang.String, com.unisound.common.p> t = new java.util.LinkedHashMap<>(0, 0.75f, true);
    private long v = 0;
    private final java.util.concurrent.ExecutorService w = new java.util.concurrent.ThreadPoolExecutor(0, 1, 60, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue());
    private final java.util.concurrent.Callable<java.lang.Void> x = new com.unisound.common.m(this);

    private l(java.io.File file, int i2, int i3, long j2) {
        this.l = file;
        this.o = i2;
        this.m = new java.io.File(file, f1494a);
        this.n = new java.io.File(file, b);
        this.q = i3;
        this.p = j2;
    }

    public static com.unisound.common.l a(java.io.File file, int i2, int i3, long j2) throws java.io.IOException {
        if (j2 <= 0) {
            throw new java.lang.IllegalArgumentException("maxSize <= 0");
        }
        if (i3 <= 0) {
            throw new java.lang.IllegalArgumentException("valueCount <= 0");
        }
        com.unisound.common.l lVar = new com.unisound.common.l(file, i2, i3, j2);
        if (lVar.m.exists()) {
            try {
                lVar.i();
                lVar.j();
                lVar.s = new java.io.BufferedWriter(new java.io.FileWriter(lVar.m, true), 8192);
                return lVar;
            } catch (java.io.IOException unused) {
                lVar.f();
            }
        }
        file.mkdirs();
        com.unisound.common.l lVar2 = new com.unisound.common.l(file, i2, i3, j2);
        lVar2.k();
        return lVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized com.unisound.common.n a(java.lang.String str, long j2) {
        m();
        e(str);
        com.unisound.common.p pVar = this.t.get(str);
        com.unisound.common.m mVar = null;
        if (j2 != -1 && (pVar == null || pVar.f != j2)) {
            return null;
        }
        if (pVar == null) {
            pVar = new com.unisound.common.p(this, str, mVar);
            this.t.put(str, pVar);
        } else if (pVar.e != null) {
            return null;
        }
        com.unisound.common.n nVar = new com.unisound.common.n(this, pVar, mVar);
        pVar.e = nVar;
        this.s.write("DIRTY " + str + '\n');
        this.s.flush();
        return nVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static java.lang.String a(java.io.InputStream inputStream) throws java.io.IOException {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(80);
        while (true) {
            int i2 = inputStream.read();
            if (i2 == -1) {
                throw new java.io.EOFException();
            }
            if (i2 == 10) {
                int length = sb.length();
                if (length > 0) {
                    int i3 = length - 1;
                    if (sb.charAt(i3) == '\r') {
                        sb.setLength(i3);
                    }
                }
                return sb.toString();
            }
            sb.append((char) i2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static java.lang.String a(java.io.Reader reader) throws java.io.IOException {
        try {
            java.io.StringWriter stringWriter = new java.io.StringWriter();
            char[] cArr = new char[1024];
            while (true) {
                int i2 = reader.read(cArr);
                if (i2 == -1) {
                    return stringWriter.toString();
                }
                stringWriter.write(cArr, 0, i2);
            }
        } finally {
            reader.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void a(com.unisound.common.n nVar, boolean z) {
        com.unisound.common.p pVar = nVar.b;
        if (pVar.e != nVar) {
            throw new java.lang.IllegalStateException();
        }
        if (z && !pVar.d) {
            for (int i2 = 0; i2 < this.q; i2++) {
                if (!pVar.b(i2).exists()) {
                    nVar.b();
                    throw new java.lang.IllegalStateException("edit didn't create file " + i2);
                }
            }
        }
        for (int i3 = 0; i3 < this.q; i3++) {
            java.io.File fileB = pVar.b(i3);
            if (!z) {
                b(fileB);
            } else if (fileB.exists()) {
                java.io.File fileA = pVar.a(i3);
                fileB.renameTo(fileA);
                long j2 = pVar.c[i3];
                long length = fileA.length();
                pVar.c[i3] = length;
                this.r = (this.r - j2) + length;
            }
        }
        this.u++;
        pVar.e = null;
        if (pVar.d || z) {
            pVar.d = true;
            this.s.write("CLEAN " + pVar.b + pVar.a() + '\n');
            if (z) {
                long j3 = this.v;
                this.v = 1 + j3;
                pVar.f = j3;
            }
        } else {
            this.t.remove(pVar.b);
            this.s.write("REMOVE " + pVar.b + '\n');
        }
        if (this.r > this.p || l()) {
            this.w.submit(this.x);
        }
    }

    public static void a(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.lang.RuntimeException e2) {
                throw e2;
            } catch (java.lang.Exception unused) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void a(java.io.File file) throws java.io.IOException {
        java.io.File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            throw new java.lang.IllegalArgumentException("not a directory: " + file);
        }
        for (java.io.File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                a(file2);
            }
            if (!file2.delete()) {
                throw new java.io.IOException("failed to delete file: " + file2);
            }
        }
    }

    private static <T> T[] a(T[] tArr, int i2, int i3) {
        int length = tArr.length;
        if (i2 > i3) {
            throw new java.lang.IllegalArgumentException();
        }
        if (i2 < 0 || i2 > length) {
            throw new java.lang.ArrayIndexOutOfBoundsException();
        }
        int i4 = i3 - i2;
        int iMin = java.lang.Math.min(i4, length - i2);
        T[] tArr2 = (T[]) ((java.lang.Object[]) java.lang.reflect.Array.newInstance(tArr.getClass().getComponentType(), i4));
        java.lang.System.arraycopy(tArr, i2, tArr2, 0, iMin);
        return tArr2;
    }

    private static void b(java.io.File file) throws java.io.IOException {
        if (file.exists() && !file.delete()) {
            throw new java.io.IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String c(java.io.InputStream inputStream) {
        return a((java.io.Reader) new java.io.InputStreamReader(inputStream, j));
    }

    private void d(java.lang.String str) throws java.io.IOException {
        java.lang.String[] strArrSplit = str.split(" ");
        if (strArrSplit.length < 2) {
            throw new java.io.IOException("unexpected journal line: " + str);
        }
        java.lang.String str2 = strArrSplit[1];
        if (strArrSplit[0].equals(h) && strArrSplit.length == 2) {
            this.t.remove(str2);
            return;
        }
        com.unisound.common.p pVar = this.t.get(str2);
        com.unisound.common.m mVar = null;
        if (pVar == null) {
            pVar = new com.unisound.common.p(this, str2, mVar);
            this.t.put(str2, pVar);
        }
        if (strArrSplit[0].equals(f) && strArrSplit.length == this.q + 2) {
            pVar.d = true;
            pVar.e = null;
            pVar.a((java.lang.String[]) a(strArrSplit, 2, strArrSplit.length));
        } else if (strArrSplit[0].equals(g) && strArrSplit.length == 2) {
            pVar.e = new com.unisound.common.n(this, pVar, mVar);
        } else {
            if (strArrSplit[0].equals(i) && strArrSplit.length == 2) {
                return;
            }
            throw new java.io.IOException("unexpected journal line: " + str);
        }
    }

    private void e(java.lang.String str) {
        if (str.contains(" ") || str.contains("\n") || str.contains("\r")) {
            throw new java.lang.IllegalArgumentException("keys must not contain spaces or newlines: \"" + str + "\"");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void i() {
        java.io.BufferedInputStream bufferedInputStream = new java.io.BufferedInputStream(new java.io.FileInputStream(this.m), 8192);
        try {
            java.lang.String strA = a((java.io.InputStream) bufferedInputStream);
            java.lang.String strA2 = a((java.io.InputStream) bufferedInputStream);
            java.lang.String strA3 = a((java.io.InputStream) bufferedInputStream);
            java.lang.String strA4 = a((java.io.InputStream) bufferedInputStream);
            java.lang.String strA5 = a((java.io.InputStream) bufferedInputStream);
            if (!c.equals(strA) || !"1".equals(strA2) || !java.lang.Integer.toString(this.o).equals(strA3) || !java.lang.Integer.toString(this.q).equals(strA4) || !"".equals(strA5)) {
                throw new java.io.IOException("unexpected journal header: [" + strA + ", " + strA2 + ", " + strA4 + ", " + strA5 + "]");
            }
            while (true) {
                try {
                    d(a((java.io.InputStream) bufferedInputStream));
                } catch (java.io.EOFException unused) {
                    a((java.io.Closeable) bufferedInputStream);
                    return;
                }
            }
        } catch (java.lang.Throwable th) {
            a((java.io.Closeable) bufferedInputStream);
            throw th;
        }
    }

    private void j() throws java.io.IOException {
        b(this.n);
        java.util.Iterator<com.unisound.common.p> it = this.t.values().iterator();
        while (it.hasNext()) {
            com.unisound.common.p next = it.next();
            int i2 = 0;
            if (next.e == null) {
                while (i2 < this.q) {
                    this.r += next.c[i2];
                    i2++;
                }
            } else {
                next.e = null;
                while (i2 < this.q) {
                    b(next.a(i2));
                    b(next.b(i2));
                    i2++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void k() {
        if (this.s != null) {
            this.s.close();
        }
        java.io.BufferedWriter bufferedWriter = new java.io.BufferedWriter(new java.io.FileWriter(this.n), 8192);
        bufferedWriter.write(c);
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(java.lang.Integer.toString(this.o));
        bufferedWriter.write("\n");
        bufferedWriter.write(java.lang.Integer.toString(this.q));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (com.unisound.common.p pVar : this.t.values()) {
            bufferedWriter.write(pVar.e != null ? "DIRTY " + pVar.b + '\n' : "CLEAN " + pVar.b + pVar.a() + '\n');
        }
        bufferedWriter.close();
        this.n.renameTo(this.m);
        this.s = new java.io.BufferedWriter(new java.io.FileWriter(this.m, true), 8192);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l() {
        int i2 = this.u;
        return i2 >= 2000 && i2 >= this.t.size();
    }

    private void m() {
        if (this.s == null) {
            throw new java.lang.IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        while (this.r > this.p) {
            c(this.t.entrySet().iterator().next().getKey());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized com.unisound.common.q a(java.lang.String str) {
        m();
        e(str);
        com.unisound.common.p pVar = this.t.get(str);
        if (pVar == null) {
            return null;
        }
        if (!pVar.d) {
            return null;
        }
        java.io.InputStream[] inputStreamArr = new java.io.InputStream[this.q];
        for (int i2 = 0; i2 < this.q; i2++) {
            try {
                inputStreamArr[i2] = new java.io.FileInputStream(pVar.a(i2));
            } catch (java.io.FileNotFoundException unused) {
                return null;
            }
        }
        this.u++;
        this.s.append((java.lang.CharSequence) ("READ " + str + '\n'));
        if (l()) {
            this.w.submit(this.x);
        }
        return new com.unisound.common.q(this, str, pVar.f, inputStreamArr, null);
    }

    public java.io.File a() {
        return this.l;
    }

    public long b() {
        return this.p;
    }

    public com.unisound.common.n b(java.lang.String str) {
        return a(str, -1L);
    }

    public synchronized long c() {
        return this.r;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized boolean c(java.lang.String str) {
        m();
        e(str);
        com.unisound.common.p pVar = this.t.get(str);
        if (pVar != null && pVar.e == null) {
            for (int i2 = 0; i2 < this.q; i2++) {
                java.io.File fileA = pVar.a(i2);
                if (!fileA.delete()) {
                    throw new java.io.IOException("failed to delete " + fileA);
                }
                this.r -= pVar.c[i2];
                pVar.c[i2] = 0;
            }
            this.u++;
            this.s.append((java.lang.CharSequence) ("REMOVE " + str + '\n'));
            this.t.remove(str);
            if (l()) {
                this.w.submit(this.x);
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.s == null) {
            return;
        }
        for (com.unisound.common.p pVar : new java.util.ArrayList(this.t.values())) {
            if (pVar.e != null) {
                pVar.e.b();
            }
        }
        n();
        this.s.close();
        this.s = null;
    }

    public boolean d() {
        return this.s == null;
    }

    public synchronized void e() {
        m();
        n();
        this.s.flush();
    }

    public void f() throws java.io.IOException {
        close();
        a(this.l);
    }

    public java.util.ArrayList<java.lang.String> g() {
        java.util.Iterator<java.lang.String> it = this.t.keySet().iterator();
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
