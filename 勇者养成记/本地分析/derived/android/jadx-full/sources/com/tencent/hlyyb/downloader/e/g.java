package com.tencent.hlyyb.downloader.e;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f633a;
    public volatile long b;
    volatile long c;
    volatile long d;
    public boolean e;
    private long f;
    private java.lang.String g = "";
    private java.lang.String h = "";
    private java.util.List i = new java.util.LinkedList();
    private java.util.List j = new java.util.LinkedList();
    private volatile long k;
    private volatile int l;

    public g(java.lang.String str) {
        this.f633a = -1L;
        this.f = 0L;
        this.b = 0L;
        this.c = 0L;
        this.d = 0L;
        this.e = false;
        this.k = 0L;
        this.l = 0;
        this.e = false;
        try {
            if (!android.text.TextUtils.isEmpty(str)) {
                try {
                    java.lang.String[] strArrSplit = str.split(com.tencent.ysdk.shell.framework.web.jsbridge.YYBJsBridgeProxy.QueryController.QUERY_FIELDS_SPLIT);
                    if (strArrSplit == null || strArrSplit.length == 0 || !strArrSplit[0].equals("3.0") || strArrSplit.length < 7) {
                        return;
                    }
                    try {
                        this.f633a = java.lang.Long.parseLong(strArrSplit[1]);
                        this.b = java.lang.Long.parseLong(strArrSplit[2]);
                        this.c = java.lang.Long.parseLong(strArrSplit[3]);
                        this.d = java.lang.Long.parseLong(strArrSplit[4]);
                        for (java.lang.String str2 : strArrSplit[5].split(";")) {
                            com.tencent.hlyyb.downloader.e.b.a aVar = new com.tencent.hlyyb.downloader.e.b.a(this, str2);
                            if (!aVar.f618a) {
                                this.i.clear();
                                return;
                            }
                            this.i.add(aVar);
                        }
                        if (strArrSplit.length >= 9) {
                            a(strArrSplit[7]);
                            b(strArrSplit[8]);
                        }
                        if (strArrSplit.length >= 11) {
                            for (java.lang.String str3 : strArrSplit[9].split(";")) {
                                com.tencent.hlyyb.downloader.e.b.a aVar2 = new com.tencent.hlyyb.downloader.e.b.a(this, str3);
                                if (aVar2.f618a) {
                                    this.j.add(aVar2);
                                } else {
                                    this.j.clear();
                                }
                            }
                            try {
                                java.lang.String[] strArrSplit2 = strArrSplit[10].split(";");
                                this.k = java.lang.Long.parseLong(strArrSplit2[0]);
                                this.l = java.lang.Integer.parseInt(strArrSplit2[1]);
                            } catch (java.lang.Throwable th) {
                                th.printStackTrace();
                                return;
                            }
                        }
                    } catch (java.lang.NumberFormatException e) {
                        e.printStackTrace();
                        return;
                    }
                } catch (java.lang.Exception unused) {
                    return;
                }
            }
            this.f = m();
            this.e = true;
        } catch (java.lang.Exception e2) {
            this.e = false;
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private com.tencent.hlyyb.downloader.e.b.a j() {
        com.tencent.hlyyb.downloader.e.b.a aVar;
        com.tencent.hlyyb.downloader.e.b.a aVar2;
        synchronized (this.i) {
            if (this.i.size() == 0) {
                aVar2 = new com.tencent.hlyyb.downloader.e.b.a(this, 0L, 0L, 0L, -1L);
            } else {
                com.tencent.hlyyb.downloader.e.b.a aVar3 = (com.tencent.hlyyb.downloader.e.b.a) this.i.get(0);
                java.util.Iterator it = this.i.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        aVar = null;
                        break;
                    }
                    aVar = (com.tencent.hlyyb.downloader.e.b.a) it.next();
                    if (!aVar.h) {
                        long j = this.f633a;
                        if (aVar.g != -1) {
                            j = aVar.g;
                        }
                        if (j - aVar.f > 0) {
                            break;
                        }
                    }
                    long j2 = this.f633a;
                    if (aVar.g != -1) {
                        j2 = aVar.g;
                    }
                    long j3 = j2 - aVar.f;
                    long j4 = this.f633a;
                    if (aVar3.g != -1) {
                        j4 = aVar3.g;
                    }
                    if (j3 > j4 - aVar3.f) {
                        aVar3 = aVar;
                    }
                }
                if (aVar == null) {
                    long j5 = this.f633a;
                    if (aVar3.g != -1) {
                        j5 = aVar3.g;
                    }
                    long j6 = j5 - aVar3.f;
                    long j7 = aVar3.f;
                    if (j6 > (com.tencent.hlyyb.downloader.a.a.c() << 1)) {
                        long j8 = j7 + (j6 / 2);
                        com.tencent.hlyyb.downloader.e.b.a aVar4 = new com.tencent.hlyyb.downloader.e.b.a(this, j8, j8, j8, aVar3.g);
                        aVar4.c = aVar3.b;
                        aVar2 = aVar4;
                    } else {
                        aVar2 = null;
                    }
                } else {
                    aVar2 = aVar;
                }
            }
            if (aVar2 != null) {
                aVar2.h = true;
            }
        }
        return aVar2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private com.tencent.hlyyb.downloader.e.b.a k() {
        com.tencent.hlyyb.downloader.e.b.a aVar;
        synchronized (this.j) {
            java.util.Iterator it = this.j.iterator();
            while (true) {
                if (!it.hasNext()) {
                    aVar = null;
                    break;
                }
                aVar = (com.tencent.hlyyb.downloader.e.b.a) it.next();
                if (!aVar.h && aVar.f != aVar.g) {
                    break;
                }
            }
            if (aVar != null) {
                aVar.h = true;
            }
        }
        return aVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private long l() {
        long j;
        long j2;
        long j3;
        synchronized (this.i) {
            j = 0;
            for (com.tencent.hlyyb.downloader.e.b.a aVar : this.i) {
                j += aVar.e - aVar.d;
            }
        }
        synchronized (this.j) {
            j2 = 0;
            for (com.tencent.hlyyb.downloader.e.b.a aVar2 : this.j) {
                j2 += aVar2.g - aVar2.d;
            }
            j3 = 0;
            for (com.tencent.hlyyb.downloader.e.b.a aVar3 : this.j) {
                j3 += aVar3.e - aVar3.d;
            }
        }
        long j4 = (j - j2) + j3;
        if (j4 > 0) {
            return j4;
        }
        return 0L;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private long m() {
        long j;
        synchronized (this.i) {
            j = 0;
            for (com.tencent.hlyyb.downloader.e.b.a aVar : this.i) {
                j += aVar.e - aVar.d;
            }
        }
        synchronized (this.j) {
            for (com.tencent.hlyyb.downloader.e.b.a aVar2 : this.j) {
                j += aVar2.e - aVar2.d;
            }
        }
        return j;
    }

    public final com.tencent.hlyyb.downloader.e.b.a a() {
        com.tencent.hlyyb.downloader.e.b.a aVarJ = j();
        return aVarJ != null ? aVarJ : k();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final com.tencent.hlyyb.downloader.e.b.a a(int i) {
        synchronized (this.i) {
            try {
                try {
                    for (com.tencent.hlyyb.downloader.e.b.a aVar : this.i) {
                        if (aVar.b == i) {
                            return aVar;
                        }
                    }
                } catch (java.lang.Exception unused) {
                }
                synchronized (this.j) {
                    try {
                        try {
                            for (com.tencent.hlyyb.downloader.e.b.a aVar2 : this.j) {
                                if (aVar2.b == i) {
                                    return aVar2;
                                }
                            }
                        } catch (java.lang.Exception unused2) {
                        }
                        return null;
                    } catch (java.lang.Throwable th) {
                        throw th;
                    }
                }
            } catch (java.lang.Throwable th2) {
                throw th2;
            }
        }
    }

    public final void a(long j, int i) {
        if (this.k != 0 && this.k > j) {
            j = this.k;
        }
        this.k = j;
        if (this.l != 0 && this.l > i) {
            i = this.l;
        }
        this.l = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void a(com.tencent.hlyyb.downloader.e.b.a aVar) {
        if (aVar.g != -1 && aVar.d < aVar.g) {
            synchronized (this.j) {
                com.tencent.hlyyb.downloader.e.b.a aVar2 = null;
                int i = 0;
                for (int i2 = 0; i2 < this.j.size(); i2++) {
                    com.tencent.hlyyb.downloader.e.b.a aVar3 = (com.tencent.hlyyb.downloader.e.b.a) this.j.get(i2);
                    if (aVar3.d == aVar.d) {
                        i = i2;
                        aVar2 = aVar3;
                        break;
                    }
                }
                if (aVar2 == null) {
                    int size = this.j.size();
                    int i3 = size > 0 ? ((com.tencent.hlyyb.downloader.e.b.a) this.j.get(size - 1)).b + 1 : 10000;
                    aVar.c = i3;
                    aVar.b = i3;
                    this.j.add(aVar);
                    return;
                }
                if (aVar.g <= aVar2.g) {
                    aVar = aVar2;
                }
                aVar.b = aVar2.b;
                aVar.c = aVar2.c;
                this.j.remove(i);
                this.j.add(i, aVar);
            }
        }
    }

    public final void a(java.lang.String str) {
        this.g = (android.text.TextUtils.isEmpty(str) || str.equals("null")) ? "" : str.replace("|", "");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int b() {
        int i;
        synchronized (this.j) {
            i = 0;
            for (com.tencent.hlyyb.downloader.e.b.a aVar : this.j) {
                i = (int) (((long) i) + (aVar.e - aVar.d));
            }
        }
        return i;
    }

    public final void b(java.lang.String str) {
        this.h = (android.text.TextUtils.isEmpty(str) || str.equals("null")) ? "" : str.replace("|", "");
    }

    public final boolean b(com.tencent.hlyyb.downloader.e.b.a aVar) {
        if (aVar.b == -1) {
            synchronized (this.i) {
                if (aVar.c == -1) {
                    if (this.i.size() == 0) {
                        aVar.b = 0;
                        aVar.g = this.f633a;
                        this.i.add(aVar);
                        return true;
                    }
                } else if (aVar.c < this.i.size()) {
                    com.tencent.hlyyb.downloader.e.b.a aVar2 = null;
                    for (com.tencent.hlyyb.downloader.e.b.a aVar3 : this.i) {
                        if (aVar3.b == aVar.c) {
                            if (aVar3.f >= aVar3.g) {
                                return false;
                            }
                            if (aVar3.f + ((long) com.tencent.hlyyb.downloader.a.a.c()) > aVar.d) {
                                return false;
                            }
                            aVar2 = aVar3;
                        } else if (aVar3.g > aVar.d && aVar3.d < aVar.g) {
                            return false;
                        }
                    }
                    if (aVar2 == null) {
                        return false;
                    }
                    aVar.b = this.i.size();
                    aVar2.g = aVar.d;
                    this.i.add(aVar);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final java.lang.String c() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("3.0");
        sb.append("|");
        sb.append(this.f633a);
        sb.append("|");
        sb.append(this.b);
        sb.append("|");
        sb.append(this.c);
        sb.append("|");
        sb.append(this.d);
        sb.append("|");
        synchronized (this.i) {
            java.util.Iterator it = this.i.iterator();
            while (it.hasNext()) {
                sb.append(((com.tencent.hlyyb.downloader.e.b.a) it.next()).a());
                sb.append(";");
            }
            if (this.i.size() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        sb.append("|");
        sb.append("null");
        sb.append("|");
        sb.append(android.text.TextUtils.isEmpty(this.g) ? "null" : this.g);
        sb.append("|");
        sb.append(android.text.TextUtils.isEmpty(this.h) ? "null" : this.h);
        sb.append("|");
        synchronized (this.j) {
            java.util.Iterator it2 = this.j.iterator();
            while (it2.hasNext()) {
                sb.append(((com.tencent.hlyyb.downloader.e.b.a) it2.next()).a());
                sb.append(";");
            }
            if (this.j.size() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        sb.append("|");
        sb.append(this.k + ";" + this.l);
        return sb.toString();
    }

    public final long d() {
        return l();
    }

    public final boolean e() {
        long j = this.f633a;
        return j > 0 && j == l();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long f() {
        long j;
        long j2;
        long j3;
        synchronized (this.i) {
            j = 0;
            for (com.tencent.hlyyb.downloader.e.b.a aVar : this.i) {
                j += aVar.f - aVar.d;
            }
        }
        synchronized (this.j) {
            j2 = 0;
            for (com.tencent.hlyyb.downloader.e.b.a aVar2 : this.j) {
                j2 += aVar2.g - aVar2.d;
            }
            j3 = 0;
            for (com.tencent.hlyyb.downloader.e.b.a aVar3 : this.j) {
                j3 += aVar3.f - aVar3.d;
            }
        }
        long j4 = (j - j2) + j3;
        if (j4 > 0) {
            return j4;
        }
        return 0L;
    }

    public final long g() {
        return m() - this.f;
    }

    public final long h() {
        return this.k;
    }

    public final int i() {
        return this.l;
    }

    public final java.lang.String toString() {
        return c();
    }
}
