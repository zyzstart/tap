package com.tencent.ydkqmsp.sdk.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c implements android.os.Handler.Callback {
    private android.content.SharedPreferences h;
    private com.tencent.ydkqmsp.sdk.d.b i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.util.concurrent.ConcurrentHashMap f1334a = new java.util.concurrent.ConcurrentHashMap();
    final java.lang.Object c = new java.lang.Object();
    private int d = 0;
    private com.tencent.ydkqmsp.sdk.d.d.b e = null;
    private java.lang.String f = "";
    private java.lang.String g = "";
    private int j = 0;
    private android.os.Handler b = new android.os.Handler(com.tencent.ydkqmsp.sdk.app.b.e().b(), this);

    class a implements java.lang.Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.ydkqmsp.sdk.d.c.this.a();
        }
    }

    class b implements com.tencent.ydkqmsp.sdk.b.e {
        b() {
        }

        @Override // com.tencent.ydkqmsp.sdk.b.e
        public void a(int i, org.json.JSONObject jSONObject) {
            if (i != 161 || jSONObject == null) {
                return;
            }
            com.tencent.ydkqmsp.sdk.d.c.this.a(i, jSONObject);
        }
    }

    /* JADX INFO: renamed from: com.tencent.ydkqmsp.sdk.d.c$c, reason: collision with other inner class name */
    static class C0049c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1337a;
        public int b;
        public java.lang.String c;
        public java.lang.String d;
        public java.lang.String e;
        public java.lang.String f;
        public int g;
        public boolean h;
        public int i;
        public long j;
        public int k;

        public C0049c(int i, int i2, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, int i3, boolean z, int i4, long j, int i5) {
            this.f1337a = i;
            this.b = i2;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = str4;
            this.g = i3;
            this.h = z;
            this.i = i4;
            this.j = j;
            this.k = i5;
        }

        public java.lang.String toString() {
            return "filePath=" + this.c + ",fileName=" + this.d + ",fileId=" + this.b + ",fileUrl=" + this.e + ",fileHash=" + this.f + ",fileVersion=" + this.g + ",zipFlag=" + this.h + ",startTime=" + this.j + ",tryTimes=" + this.i + ",downloadFlag=" + this.k;
        }
    }

    public c(android.content.Context context) {
        this.h = null;
        this.i = null;
        this.h = context.getSharedPreferences(a(com.tencent.ydkqmsp.sdk.d.d.b), 0);
        this.i = new com.tencent.ydkqmsp.sdk.d.b();
    }

    private int a(int i, java.lang.String str) {
        java.lang.String strA;
        try {
            if (i == 0) {
                com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 1, "No matched update from server.");
                return -1;
            }
            if (this.h.getInt(a(com.tencent.ydkqmsp.sdk.d.d.d), 0) < i) {
                return 0;
            }
            java.lang.String strC = c();
            if (new java.io.File(strC).exists() && (strA = com.tencent.ydkqmsp.sdk.d.a.a(strC)) != null && strA.equalsIgnoreCase(str)) {
                return (strA == null || !strA.equalsIgnoreCase(str)) ? -1 : 1;
            }
            return 0;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private java.lang.String a(byte[] bArr) {
        return com.tencent.ydkqmsp.sdk.f.k.a(bArr);
    }

    private void a(int i, int i2) {
        try {
            org.json.JSONObject jSONObjectA = com.tencent.ydkqmsp.sdk.a.d.a(2);
            if (jSONObjectA == null) {
                return;
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put(com.tencent.ydkqmsp.sdk.a.e.a(20), i);
            jSONObject.put(com.tencent.ydkqmsp.sdk.a.e.a(21), i2);
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put(com.tencent.ydkqmsp.sdk.a.e.a(15), jSONObjectA);
            jSONObject2.put(com.tencent.ydkqmsp.sdk.a.e.a(16), jSONObject);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("[SFU] request : ");
            sb.append(jSONObject2.toString());
            com.tencent.ydkqmsp.sdk.f.g.d("Qp.QUM", 0, sb.toString());
            com.tencent.ydkqmsp.sdk.b.g.b().a(2, com.tencent.ydkqmsp.sdk.app.a.getAppID(), 2, jSONObject2, new com.tencent.ydkqmsp.sdk.d.c.b());
            a("0X80078AA", i, this.j, "", "");
            com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 1, java.lang.String.format("[SFU] send update query: fileid=%d, localversion=%d", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2)));
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(java.lang.String str, int i, int i2, java.lang.String str2, java.lang.String str3) {
        java.lang.String str4 = java.lang.String.format("%d", java.lang.Integer.valueOf(i));
        com.tencent.ydkqmsp.sdk.d.d.b bVar = this.e;
        int i3 = bVar != null ? (int) bVar.b : 0;
        com.tencent.ydkqmsp.sdk.d.d.b bVar2 = this.e;
        java.lang.String str5 = bVar2 != null ? java.lang.String.format("%d", java.lang.Long.valueOf(bVar2.f1340a)) : "";
        com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 1, java.lang.String.format("[SFU] report: actiontype=%s, actionname=%s, actionfrom=%d, actionresult=%d, sectionId=%s, reportId=%s, fileInfo: %s", str, str, java.lang.Integer.valueOf(i3), java.lang.Integer.valueOf(this.d), str5, str4, "", ""));
        com.tencent.ydkqmsp.sdk.a.g gVar = new com.tencent.ydkqmsp.sdk.a.g();
        try {
            gVar.a(str).a(str4).a(str5).a(this.d).a(i2).a(str2).a(str3);
            com.tencent.ydkqmsp.sdk.a.f.a(gVar.toString(), 2);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.tencent.ydkqmsp.sdk.f.g.b(com.tencent.ydkqmsp.sdk.f.g.f1347a, 0, "onReport error! <JsonObject userData>!");
        }
    }

    private void a(boolean z, com.tencent.ydkqmsp.sdk.b.b bVar) {
        int i;
        if (!z || bVar == null) {
            a(3);
            return;
        }
        java.io.File file = new java.io.File(bVar.b);
        com.tencent.ydkqmsp.sdk.d.c.C0049c c0049c = (com.tencent.ydkqmsp.sdk.d.c.C0049c) bVar.a();
        if (!file.exists() || c0049c == null) {
            a(3);
            return;
        }
        com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 1, java.lang.String.format("[SFU] http download complete: %s, %s", bVar.b, c0049c.e));
        int i2 = c0049c.f1337a;
        if (i2 == 1) {
            java.io.File file2 = new java.io.File(c());
            new java.io.File(bVar.b).renameTo(file2);
            a("0X80078AC", c0049c.g, this.j, "", "");
            if (!this.i.a(file2.toString())) {
                a("0X80078AD", c0049c.g, this.j, c0049c.d, c0049c.e);
                com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 1, "[SFU] invalid config (sig not accepted)");
                a(1);
                return;
            } else {
                this.h.edit().putInt(a(com.tencent.ydkqmsp.sdk.d.d.d), c0049c.g).commit();
                if (this.i.a().isEmpty()) {
                    com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 1, "[SFU] config ok but without any sections");
                    i = 16;
                } else {
                    i = 5;
                }
            }
        } else {
            if (i2 != 2) {
                return;
            }
            a("0X80078AE", c0049c.g, this.j, "", "");
            i = 7;
        }
        b(i);
    }

    private boolean a(com.tencent.ydkqmsp.sdk.d.c.C0049c c0049c) {
        if (c0049c == null) {
            return false;
        }
        if (c0049c.f1337a == 2 && c0049c.k != 1 && !com.tencent.ydkqmsp.sdk.f.f.b(com.tencent.ydkqmsp.sdk.app.a.getContext())) {
            com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 1, "[SFU] donot download file because not using wifi");
            com.tencent.ydkqmsp.sdk.a.a.a(3, 3);
            return false;
        }
        if (c0049c.i < 3 && this.f1334a.contains(c0049c.f.toLowerCase())) {
            return false;
        }
        com.tencent.ydkqmsp.sdk.b.b bVar = new com.tencent.ydkqmsp.sdk.b.b();
        bVar.f1297a = c0049c.e;
        bVar.b = c0049c.c + c0049c.d;
        bVar.d = c0049c.d;
        bVar.c = c0049c.c;
        c0049c.i = c0049c.i + 1;
        bVar.a(c0049c);
        this.f1334a.put(c0049c.f.toLowerCase(), bVar);
        try {
            com.tencent.ydkqmsp.sdk.b.d.a(bVar);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 1, java.lang.String.format("[SFU] begin http download %s", c0049c.e));
        return true;
    }

    private boolean a(com.tencent.ydkqmsp.sdk.d.d.b bVar) throws java.lang.Throwable {
        boolean z;
        if (bVar != null) {
            com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 1, java.lang.String.format("[SFU] backup: sid=%d", java.lang.Long.valueOf(bVar.f1340a)));
            long j = bVar.r;
            long j2 = 0;
            if (j == 0) {
                com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 1, "[SFU] no files need to backup");
            } else {
                if (j > 0) {
                    java.lang.String strF = f(bVar);
                    for (int i = 0; i < bVar.q.size(); i++) {
                        com.tencent.ydkqmsp.sdk.d.d.a aVar = (com.tencent.ydkqmsp.sdk.d.d.a) bVar.q.get(i);
                        if (1 == aVar.j) {
                            a(new java.io.File(aVar.f), new java.io.File(strF + aVar.c));
                            j2++;
                        }
                    }
                    com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 1, java.lang.String.format("[SFU] backup %d files of %d", java.lang.Long.valueOf(j2), java.lang.Integer.valueOf(bVar.q.size())));
                    if (bVar.r == j2) {
                    }
                }
                z = false;
            }
            z = true;
        } else {
            z = false;
        }
        com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 1, java.lang.String.format("[SFU] backup result: %b", java.lang.Boolean.valueOf(z)));
        return z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean a(java.io.File file, java.io.File file2) throws java.lang.Throwable {
        java.io.FileOutputStream fileOutputStream;
        java.io.BufferedInputStream bufferedInputStream = null;
        try {
            try {
                if (!file2.exists()) {
                    java.io.File file3 = new java.io.File(file2.getParent());
                    if (!file3.exists() && !file3.mkdirs()) {
                        return false;
                    }
                } else if (!file2.delete()) {
                    return false;
                }
                fileOutputStream = new java.io.FileOutputStream(file2);
                try {
                    java.io.BufferedInputStream bufferedInputStream2 = new java.io.BufferedInputStream(new java.io.FileInputStream(file));
                    try {
                        byte[] bArrA = com.tencent.ydkqmsp.sdk.f.a.a().a(4096);
                        while (true) {
                            int i = bufferedInputStream2.read(bArrA);
                            if (i == -1) {
                                break;
                            }
                            fileOutputStream.write(bArrA, 0, i);
                            fileOutputStream.flush();
                        }
                        com.tencent.ydkqmsp.sdk.f.a.a().a(bArrA);
                        try {
                            fileOutputStream.close();
                        } catch (java.io.IOException unused) {
                        }
                        try {
                            bufferedInputStream2.close();
                        } catch (java.io.IOException unused2) {
                        }
                        return true;
                    } catch (java.io.IOException e) {
                        e = e;
                        bufferedInputStream = bufferedInputStream2;
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (java.io.IOException unused3) {
                            }
                        }
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (java.io.IOException unused4) {
                            }
                        }
                        return false;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        bufferedInputStream = bufferedInputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (java.io.IOException unused5) {
                            }
                        }
                        if (bufferedInputStream == null) {
                            throw th;
                        }
                        try {
                            bufferedInputStream.close();
                            throw th;
                        } catch (java.io.IOException unused6) {
                            throw th;
                        }
                    }
                } catch (java.io.IOException e2) {
                    e = e2;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.io.IOException e3) {
            e = e3;
            fileOutputStream = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    private void b() {
        try {
            this.h.edit().putLong(a(com.tencent.ydkqmsp.sdk.d.d.c), java.lang.System.currentTimeMillis()).commit();
            b(2);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private void b(int i) {
        int i2 = 0;
        com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 2, java.lang.String.format("[SFU] update event: %d", java.lang.Integer.valueOf(i)));
        int i3 = 6;
        int i4 = 8;
        try {
            switch (i) {
                case 1:
                    i3 = this.d == 1 ? 17 : 14;
                    b(i3);
                    break;
                case 2:
                    i();
                    break;
                case 5:
                    if (d() && this.e != null) {
                        if (!e(this.e)) {
                            i3 = 15;
                        }
                    }
                    b(i3);
                    break;
                case 6:
                    if (this.e == null || !d(this.e)) {
                        i2 = 3;
                        a(i2);
                    }
                    break;
                case 7:
                    if (this.e != null && n(this.e)) {
                        i3 = 8;
                        b(i3);
                    } else {
                        a("0X80078AF", 0, this.j, "", "");
                        i2 = 4;
                        a(i2);
                    }
                    break;
                case 8:
                    if (this.e != null && k(this.e)) {
                        i3 = 9;
                        b(i3);
                    } else {
                        a("0X80078B0", 0, this.j, "", "");
                        i2 = 5;
                        a(i2);
                    }
                    break;
                case 9:
                    if (this.e != null && a(this.e)) {
                        i3 = 10;
                        b(i3);
                    } else {
                        a("0X80078B1", 0, this.j, "", "");
                        i2 = 6;
                        a(i2);
                    }
                    break;
                case 10:
                    if (this.e == null || !l(this.e)) {
                        i4 = 7;
                        c(i4);
                        i3 = 13;
                    } else {
                        i3 = 11;
                    }
                    b(i3);
                    break;
                case 11:
                    if (this.e == null || !m(this.e)) {
                        c(i4);
                        i3 = 13;
                    } else {
                        i3 = 12;
                    }
                    b(i3);
                    break;
                case 12:
                    if (this.e == null || !c(this.e)) {
                        i2 = 9;
                    }
                    a(i2);
                    break;
                case 13:
                    if (this.e == null || !j(this.e)) {
                        a("0X80078B3", 0, this.j, "", "");
                        i2 = 10;
                    }
                    a(i2);
                    break;
                case 14:
                    if (this.e != null) {
                        b(this.e);
                    }
                    i3 = 15;
                    b(i3);
                    break;
                case 15:
                    i(this.e);
                    this.e = null;
                    i3 = f() ? 16 : 5;
                    b(i3);
                    break;
                case 16:
                    g();
                    b(i3);
                    break;
                case 17:
                    h();
                    break;
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    private void b(com.tencent.ydkqmsp.sdk.b.c cVar) {
        if (cVar == null) {
            return;
        }
        int i = cVar.f1298a;
        if (i == 2) {
            com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 1, java.lang.String.format("[SFU] http download error=%d", java.lang.Integer.valueOf(i)));
            return;
        }
        com.tencent.ydkqmsp.sdk.d.c.C0049c c0049c = (com.tencent.ydkqmsp.sdk.d.c.C0049c) cVar.b.a();
        if (c0049c == null) {
            return;
        }
        boolean z = cVar.f1298a == 0;
        if (!z) {
            try {
                if (c0049c.i < 3) {
                    com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 1, java.lang.String.format("[SFU] retried to download, retry=%d, result=%b, url=%s", java.lang.Integer.valueOf(c0049c.i), java.lang.Boolean.valueOf(z), c0049c.e));
                    a(c0049c);
                    return;
                } else {
                    java.io.File file = new java.io.File(cVar.b.b);
                    if (file.exists()) {
                        file.delete();
                    }
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        this.f1334a.remove(c0049c.f.toLowerCase());
        a(z, cVar.b);
    }

    private void b(com.tencent.ydkqmsp.sdk.d.d.b bVar) {
        if (bVar != null) {
            com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 1, java.lang.String.format("[SFU] cleanup: sid=%d", java.lang.Long.valueOf(bVar.f1340a)));
            com.tencent.ydkqmsp.sdk.f.d.a(g(bVar), false);
        }
    }

    private java.lang.String c() {
        return e() + a(com.tencent.ydkqmsp.sdk.d.d.f1338a);
    }

    private void c(int i) {
        this.d = i;
    }

    private boolean c(com.tencent.ydkqmsp.sdk.d.d.b bVar) {
        return true;
    }

    private boolean d() {
        boolean z;
        this.e = null;
        java.util.List listA = this.i.a();
        for (int i = 0; i < listA.size(); i++) {
            com.tencent.ydkqmsp.sdk.d.d.b bVar = (com.tencent.ydkqmsp.sdk.d.d.b) listA.get(i);
            if (!bVar.a()) {
                if (bVar.m && bVar.l && bVar.n) {
                    this.e = bVar;
                    c(0);
                    com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 1, java.lang.String.format("[SFU] next update: sid=%d", java.lang.Long.valueOf(this.e.f1340a)));
                    z = true;
                    com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 1, java.lang.String.format("[SFU] get next section result? %b", java.lang.Boolean.valueOf(z)));
                    return z;
                }
                com.tencent.ydkqmsp.sdk.f.g.d("Qp.QUM", 1, java.lang.String.format("[SFU] not matched section: sid=%d, os: %b, qq:%b, cpu:%b", java.lang.Long.valueOf(bVar.f1340a), java.lang.Boolean.valueOf(bVar.m), java.lang.Boolean.valueOf(bVar.l), java.lang.Boolean.valueOf(bVar.n)));
                bVar.b();
            }
        }
        z = false;
        com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 1, java.lang.String.format("[SFU] get next section result? %b", java.lang.Boolean.valueOf(z)));
        return z;
    }

    private boolean d(com.tencent.ydkqmsp.sdk.d.d.b bVar) {
        if (bVar == null) {
            return false;
        }
        com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 1, java.lang.String.format("[SFU] download package: sid=%d", java.lang.Long.valueOf(bVar.f1340a)));
        return a(new com.tencent.ydkqmsp.sdk.d.c.C0049c(2, 0, g(bVar), bVar.c, bVar.e, bVar.d, 0, true, 0, java.lang.System.currentTimeMillis(), bVar.u));
    }

    private java.lang.String e() {
        java.lang.String strC = com.tencent.ydkqmsp.sdk.a.b.c();
        java.io.File file = new java.io.File(strC);
        if (!file.exists()) {
            file.mkdirs();
        }
        return strC;
    }

    private boolean e(com.tencent.ydkqmsp.sdk.d.d.b bVar) {
        if (bVar == null) {
            return false;
        }
        com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 1, java.lang.String.format("[SFU] get different: sid=%d", java.lang.Long.valueOf(bVar.f1340a)));
        java.util.List list = bVar.o;
        for (int i = 0; i < list.size(); i++) {
            com.tencent.ydkqmsp.sdk.d.d.a aVar = (com.tencent.ydkqmsp.sdk.d.d.a) list.get(i);
            if (new java.io.File(aVar.f).exists()) {
                java.lang.String strA = com.tencent.ydkqmsp.sdk.d.a.a(aVar.f);
                if (strA == null || !strA.equalsIgnoreCase(aVar.b)) {
                    aVar.j = 1;
                    if (strA == null) {
                        strA = "";
                    }
                    aVar.c = strA;
                    bVar.q.add(aVar);
                    bVar.r++;
                }
            } else {
                aVar.j = 2;
                bVar.q.add(aVar);
            }
        }
        com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 1, java.lang.String.format("[SFU] need to update %d files of %d", java.lang.Integer.valueOf(bVar.q.size()), java.lang.Integer.valueOf(bVar.o.size())));
        return !bVar.q.isEmpty();
    }

    private java.lang.String f(com.tencent.ydkqmsp.sdk.d.d.b bVar) {
        java.lang.String str = g(bVar) + "bak" + java.io.File.separator;
        java.io.File file = new java.io.File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    private boolean f() {
        boolean z;
        java.util.List listA = this.i.a();
        int i = 0;
        while (true) {
            if (i >= listA.size()) {
                z = true;
                break;
            }
            if (!((com.tencent.ydkqmsp.sdk.d.d.b) listA.get(i)).a()) {
                z = false;
                break;
            }
            i++;
        }
        java.lang.Object[] objArr = new java.lang.Object[1];
        objArr[0] = z ? "yes" : cn.yunzhisheng.asr.JniUscClient.aA;
        com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 1, java.lang.String.format("[SFU] all complete: %s", objArr));
        return z;
    }

    private java.lang.String g(com.tencent.ydkqmsp.sdk.d.d.b bVar) {
        java.lang.String str = e() + bVar.f1340a + java.io.File.separator;
        java.io.File file = new java.io.File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    private void g() {
        com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 1, "[SFU] all sections update complete");
        try {
            if (!android.text.TextUtils.isEmpty(this.f)) {
                com.tencent.ydkqmsp.sdk.c.f.i().e();
                this.h.edit().putString(a(com.tencent.ydkqmsp.sdk.d.d.e), this.f).putString(a(com.tencent.ydkqmsp.sdk.d.d.f), this.g).commit();
                a("0X80078B6", 0, this.j, this.f, this.g);
            }
            com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 1, java.lang.String.format("[SFU] notify update complete: %s", this.f));
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    private java.lang.String h(com.tencent.ydkqmsp.sdk.d.d.b bVar) {
        return g(bVar) + bVar.c;
    }

    private void h() {
        synchronized (this.c) {
            a("0X80078B5", 0, this.j, "", "");
            this.e = null;
            com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 1, "[SFU] update ended");
        }
    }

    private void i() {
        a(1, this.h.getInt(a(com.tencent.ydkqmsp.sdk.d.d.d), 0));
        this.h.edit().remove(a(com.tencent.ydkqmsp.sdk.d.d.e)).commit();
    }

    private void i(com.tencent.ydkqmsp.sdk.d.d.b bVar) {
        if (bVar != null) {
            com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 1, java.lang.String.format("[SFU] update complete: sid=%d", java.lang.Long.valueOf(bVar.f1340a)));
            bVar.b();
            if (j()) {
                this.f += java.lang.String.format("#%d#", java.lang.Long.valueOf(bVar.b));
                this.g += java.lang.String.format("#%d#", java.lang.Long.valueOf(bVar.f1340a));
            }
            a("0X80078B4", 0, this.j, "", "");
        }
    }

    private boolean j() {
        return this.d == 0;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00ab  */
    private boolean j(com.tencent.ydkqmsp.sdk.d.d.b bVar) throws java.lang.Throwable {
        boolean z;
        if (bVar != null) {
            com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 1, java.lang.String.format("[SFU] rollback: sid=%d", java.lang.Long.valueOf(bVar.f1340a)));
            if (bVar.p.isEmpty()) {
                com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 1, "[SFU] no files need to rollback");
            } else {
                java.lang.String strF = f(bVar);
                long j = 0;
                for (int i = 0; i < bVar.p.size(); i++) {
                    com.tencent.ydkqmsp.sdk.d.d.a aVar = (com.tencent.ydkqmsp.sdk.d.d.a) bVar.p.get(i);
                    java.io.File file = new java.io.File(aVar.f);
                    java.io.File file2 = new java.io.File(aVar.g);
                    if (file2.exists()) {
                        if (!file2.delete()) {
                            file2.deleteOnExit();
                        }
                        j++;
                    }
                    if (aVar.j == 2 && file.exists()) {
                        if (!file.delete()) {
                            file.deleteOnExit();
                        }
                        j++;
                    }
                    java.io.File file3 = new java.io.File(strF, aVar.c);
                    if (file3.exists() && file3.canRead() && file.exists() && file.canWrite()) {
                        a(file3, file);
                        j++;
                    }
                }
                if (j != bVar.p.size()) {
                    z = false;
                }
            }
            z = true;
        } else {
            z = false;
        }
        com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 1, java.lang.String.format("[SFU] rollback result: %b", java.lang.Boolean.valueOf(z)));
        return z;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0037  */
    private boolean k(com.tencent.ydkqmsp.sdk.d.d.b bVar) {
        boolean z;
        if (bVar != null) {
            com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 1, java.lang.String.format("[SFU] unzip package: sid=%d", java.lang.Long.valueOf(bVar.f1340a)));
            java.lang.String strG = g(bVar);
            java.io.File file = new java.io.File(strG);
            if (!file.exists()) {
                file.mkdir();
            }
            if (com.tencent.ydkqmsp.sdk.f.m.a(h(bVar), strG) == 0) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 1, java.lang.String.format("[SFU] unzip result: %b", java.lang.Boolean.valueOf(z)));
        return z;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0126  */
    private boolean l(com.tencent.ydkqmsp.sdk.d.d.b bVar) throws java.lang.Throwable {
        boolean z;
        if (bVar == null || bVar.q.isEmpty()) {
            z = false;
        } else {
            com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 1, java.lang.String.format("[SFU] do update files: sid=%d", java.lang.Long.valueOf(bVar.f1340a)));
            java.lang.String strG = g(bVar);
            for (int i = 0; i < bVar.q.size(); i++) {
                com.tencent.ydkqmsp.sdk.d.d.a aVar = (com.tencent.ydkqmsp.sdk.d.d.a) bVar.q.get(i);
                java.io.File file = new java.io.File(strG, aVar.b);
                java.io.File file2 = new java.io.File(aVar.f);
                if (file.exists() && file.canRead()) {
                    boolean zA = a(file, file2);
                    if (!zA) {
                        java.lang.String str = aVar.f + ".1";
                        java.io.File file3 = new java.io.File(str);
                        aVar.j = 3;
                        aVar.g = str;
                        zA = a(file, file3);
                        com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 1, java.lang.String.format("[SFU] copied failed, renamed to: %s", aVar.g));
                        if (zA) {
                            this.h.edit().putString(aVar.f, aVar.g).commit();
                        }
                    }
                    if (!zA) {
                        a("0X80078B2", (int) aVar.h, this.j, aVar.f1339a, aVar.b);
                        com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 1, java.lang.String.format("[SFU] failed copied: %s", aVar.f));
                        break;
                    }
                    com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 1, java.lang.String.format("[SFU] success copied: %s", aVar.f));
                    bVar.p.add(aVar);
                    bVar.s++;
                } else {
                    com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 1, java.lang.String.format("[SFU] copied failed, src not existed or cannot read: %s", file.toString()));
                }
            }
            com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 1, java.lang.String.format("[SFU] update %d files of %d", java.lang.Long.valueOf(bVar.s), java.lang.Integer.valueOf(bVar.q.size())));
            if (bVar.s == bVar.q.size()) {
                z = true;
            } else {
                z = false;
            }
        }
        com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 1, java.lang.String.format("[SFU] update result: %b", java.lang.Boolean.valueOf(z)));
        return z;
    }

    private boolean m(com.tencent.ydkqmsp.sdk.d.d.b bVar) {
        boolean z;
        if (bVar != null) {
            com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 1, java.lang.String.format("[SFU] verify: sid=%d", java.lang.Long.valueOf(bVar.f1340a)));
            if (bVar.q.isEmpty()) {
                com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 1, java.lang.String.format("[SFU] no diff: sid=%d", java.lang.Long.valueOf(bVar.f1340a)));
            } else {
                int i = 0;
                while (true) {
                    if (i < bVar.q.size()) {
                        com.tencent.ydkqmsp.sdk.d.d.a aVar = (com.tencent.ydkqmsp.sdk.d.d.a) bVar.q.get(i);
                        java.lang.String strA = com.tencent.ydkqmsp.sdk.d.a.a(android.text.TextUtils.isEmpty(aVar.g) ? aVar.f : aVar.g);
                        if (strA == null || !strA.equalsIgnoreCase(aVar.b)) {
                            com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 1, java.lang.String.format("[SFU] not matched: %s!=%s, sid=%d", strA, aVar.b, java.lang.Long.valueOf(bVar.f1340a)));
                            z = false;
                        } else {
                            i++;
                        }
                    }
                }
            }
            z = true;
        } else {
            z = false;
        }
        com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 1, java.lang.String.format("[SFU] verify result: %b", java.lang.Boolean.valueOf(z)));
        return z;
    }

    private boolean n(com.tencent.ydkqmsp.sdk.d.d.b bVar) {
        boolean zEqualsIgnoreCase;
        if (bVar != null) {
            com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 1, java.lang.String.format("[SFU] verify package: sid=%d", java.lang.Long.valueOf(bVar.f1340a)));
            java.lang.String strA = com.tencent.ydkqmsp.sdk.d.a.a(h(bVar));
            if (strA == null) {
                return false;
            }
            zEqualsIgnoreCase = strA.equalsIgnoreCase(bVar.d);
        } else {
            zEqualsIgnoreCase = false;
        }
        com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 1, java.lang.String.format("[SFU] verify result: %b", java.lang.Boolean.valueOf(zEqualsIgnoreCase)));
        return zEqualsIgnoreCase;
    }

    public void a() {
        if (!com.tencent.ydkqmsp.sdk.app.a.getTaskStatus()) {
            com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 1, "[SFU] Plugin Update Task Finish！");
            return;
        }
        if (!com.tencent.ydkqmsp.sdk.c.f.i().a(1001).booleanValue()) {
            a(com.tencent.ydkqmsp.sdk.app.a.getAtomUpdateInterval().get());
            return;
        }
        long j = this.h.getLong(a(com.tencent.ydkqmsp.sdk.d.d.c), 0L);
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis() - j;
        long j2 = jCurrentTimeMillis >= 0 ? jCurrentTimeMillis : 0L;
        long j3 = com.tencent.ydkqmsp.sdk.app.a.getAtomUpdateInterval().get();
        com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 2, java.lang.String.format("[SFU] startSFU last time: %d, interval: %d", java.lang.Long.valueOf(j), java.lang.Long.valueOf(j2)));
        if (j2 >= com.tencent.ydkqmsp.sdk.app.a.getAtomUpdateInterval().get()) {
            b();
        } else {
            j3 = ((long) com.tencent.ydkqmsp.sdk.app.a.getAtomUpdateInterval().get()) - j2;
            com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 0, "[SFU] next time: " + j3);
        }
        a(j3);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0020  */
    protected void a(int i) {
        com.tencent.ydkqmsp.sdk.f.g.b("Qp.QUM", 2, java.lang.String.format("[SFU] update error: %d", java.lang.Integer.valueOf(i)));
        if (i == 1) {
            java.io.File file = new java.io.File(c());
            if (file.exists()) {
                file.delete();
            }
        } else if (i != 10) {
            switch (i) {
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    c(i);
                    break;
            }
        } else {
            c(i);
        }
        b(1);
    }

    public void a(int i, java.lang.Object obj) {
        java.lang.String str;
        java.lang.String str2;
        try {
            org.json.JSONObject jSONObject = (org.json.JSONObject) obj;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("[SFU] rcv : ");
            sb.append(obj);
            boolean zA = false;
            com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 0, sb.toString());
            if (jSONObject != null) {
                int iOptInt = jSONObject.optInt("st");
                int iIntValue = java.lang.Integer.valueOf(jSONObject.optString("tsi")).intValue();
                this.j = iIntValue;
                a("0X80078B8", iOptInt, iIntValue, "", "");
                if (iOptInt == 0) {
                    int iOptInt2 = jSONObject.optInt("sc");
                    int iOptInt3 = jSONObject.optInt("fi");
                    int iOptInt4 = jSONObject.optInt("fv");
                    java.lang.String str3 = (java.lang.String) jSONObject.opt("fh");
                    java.lang.String str4 = (java.lang.String) jSONObject.opt("fu");
                    int iOptInt5 = jSONObject.optInt("zf");
                    boolean z = iOptInt5 == 1;
                    int iA = a(iOptInt4, str3);
                    com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 1, java.lang.String.format("[SFU] resp: cmd=%d, status=%d, fileid=%d, fileversion=%d, md5=%s, url=%s, zipped: %d", java.lang.Integer.valueOf(iOptInt2), java.lang.Integer.valueOf(iOptInt), java.lang.Integer.valueOf(iOptInt3), java.lang.Integer.valueOf(iOptInt4), str3, str4, java.lang.Integer.valueOf(iOptInt5)));
                    if (iA == 0) {
                        a("0X80078AB", iOptInt3, this.j, "", "");
                        com.tencent.ydkqmsp.sdk.f.g.a("Qp.QUM", 1, java.lang.String.format("Need to update config file, fileid=%d", java.lang.Integer.valueOf(iOptInt3)));
                        zA = a(new com.tencent.ydkqmsp.sdk.d.c.C0049c(1, iOptInt3, e(), a(com.tencent.ydkqmsp.sdk.d.d.f1338a), str4, str3, iOptInt4, z, 0, java.lang.System.currentTimeMillis(), 1));
                    } else if (iA != 1) {
                        str = "Qp.QUM";
                        str2 = "[SFU] NO Need UPDATE";
                    } else if (this.i.a(new java.io.File(c()).toString())) {
                        b(this.i.a().isEmpty() ? 16 : 5);
                        zA = true;
                    }
                } else {
                    str = "Qp.QUM";
                    str2 = java.lang.String.format("[SFU] Server replied with error, status=%d", java.lang.Integer.valueOf(iOptInt));
                }
                com.tencent.ydkqmsp.sdk.f.g.a(str, 1, str2);
            }
            if (zA) {
                return;
            }
            b(17);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            b(17);
        }
    }

    public void a(long j) {
        com.tencent.ydkqmsp.sdk.c.f.i().c().postDelayed(new com.tencent.ydkqmsp.sdk.d.c.a(), j);
    }

    public void a(com.tencent.ydkqmsp.sdk.b.c cVar) {
        android.os.Handler handler = this.b;
        if (handler != null) {
            handler.obtainMessage(1052688, cVar).sendToTarget();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(android.os.Message message) {
        if (message.what != 1052688) {
            return false;
        }
        b((com.tencent.ydkqmsp.sdk.b.c) message.obj);
        return false;
    }
}
