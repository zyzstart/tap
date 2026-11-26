package com.tencent.ydkqmsp.sdk.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class j {
    private static final byte[][] i = {new byte[]{44, 116}, new byte[]{49, 105, -93, 69}, new byte[]{35, 124, -78, 71}, new byte[]{40, 127, -73, 69}, new byte[]{51, 117, -95}, new byte[]{20, 65, -125, 82, 33, 47, 114, -2, 49, 62, -126, 125, -96, 80}, new byte[]{20, 125, -96, 80, 29, 11}};
    private static com.tencent.ydkqmsp.sdk.c.j j;
    private com.tencent.ydkqmsp.sdk.c.e d;
    private boolean f = false;
    private boolean g = false;
    private java.util.concurrent.CopyOnWriteArrayList h = new java.util.concurrent.CopyOnWriteArrayList();
    private java.util.concurrent.CopyOnWriteArrayList b = new java.util.concurrent.CopyOnWriteArrayList();
    private com.tencent.ydkqmsp.sdk.c.i c = new com.tencent.ydkqmsp.sdk.c.i();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.util.concurrent.ConcurrentHashMap f1320a = new java.util.concurrent.ConcurrentHashMap();
    private android.os.Handler e = new com.tencent.ydkqmsp.sdk.c.j.g(com.tencent.ydkqmsp.sdk.app.b.e().c());

    class a implements com.tencent.ydkqmsp.sdk.c.e.c {
        a() {
        }

        @Override // com.tencent.ydkqmsp.sdk.c.e.c
        public void a(java.util.List list) {
            android.os.Message messageObtainMessage = com.tencent.ydkqmsp.sdk.c.j.this.e.obtainMessage(2);
            messageObtainMessage.obj = list;
            com.tencent.ydkqmsp.sdk.c.j.this.e.sendMessage(messageObtainMessage);
        }
    }

    final class b implements com.tencent.ydkqmsp.sdk.c.a.InterfaceC0047a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.tencent.ydkqmsp.sdk.c.j.f f1322a;

        b(com.tencent.ydkqmsp.sdk.c.j jVar) {
        }

        @Override // com.tencent.ydkqmsp.sdk.c.a.InterfaceC0047a
        public void a() {
            this.f1322a.d = 26;
        }

        @Override // com.tencent.ydkqmsp.sdk.c.a.InterfaceC0047a
        public void run() {
            com.tencent.ydkqmsp.sdk.c.j.f fVar;
            int i;
            java.lang.String str = this.f1322a.h;
            if (str == null || str.contains("..")) {
                fVar = this.f1322a;
                i = 15;
            } else {
                java.io.File file = new java.io.File(this.f1322a.h);
                if (file.exists()) {
                    this.f1322a.i = new com.tencent.ydkqmsp.sdk.c.n();
                    int i2 = this.f1322a.b;
                    if ((i2 == 2 || i2 == 1) && !com.tencent.ydkqmsp.sdk.d.e.b(file, null)) {
                        this.f1322a.d = 10;
                        return;
                    }
                    java.lang.Object[] objArr = new java.lang.Object[1];
                    com.tencent.ydkqmsp.sdk.c.j.f fVar2 = this.f1322a;
                    fVar2.d = com.tencent.ydkqmsp.sdk.c.f.a(2L, fVar2.b, fVar2.f1324a, 0L, fVar2.h, null, null, objArr);
                    if (objArr[0] == null || !(objArr[0] instanceof java.lang.Integer)) {
                        return;
                    }
                    this.f1322a.f = ((java.lang.Integer) objArr[0]).intValue();
                    return;
                }
                fVar = this.f1322a;
                i = 12;
            }
            fVar.d = i;
        }
    }

    class c extends com.tencent.ydkqmsp.sdk.c.j.i {
        c() {
            super(com.tencent.ydkqmsp.sdk.c.j.this, null);
        }

        @Override // com.tencent.ydkqmsp.sdk.c.j.i
        public void a() {
            if (this.f1327a) {
                com.tencent.ydkqmsp.sdk.c.j.this.c.a();
            }
        }

        @Override // com.tencent.ydkqmsp.sdk.c.j.i
        public void a(java.lang.String str, java.lang.String str2, int i, int i2, int i3, int i4) throws java.lang.Throwable {
            com.tencent.ydkqmsp.sdk.f.g.a("Qp.QLM", 1, java.lang.String.format("visitQSecSFUItem libPath = %s libVer = %s libId = %d", str, str2, java.lang.Integer.valueOf(i)));
            if (android.text.TextUtils.isEmpty(str2)) {
                return;
            }
            if (i4 != 1 && i4 != 2) {
                com.tencent.ydkqmsp.sdk.f.g.a("Qp.QLM", 1, java.lang.String.format("Invalid mode: %d", java.lang.Integer.valueOf(i4)));
                return;
            }
            com.tencent.ydkqmsp.sdk.c.i.a aVarA = com.tencent.ydkqmsp.sdk.c.j.this.c.a(i);
            if (aVarA != null) {
                com.tencent.ydkqmsp.sdk.c.j.this.c.a(aVarA.f1319a, false);
            } else {
                aVarA = new com.tencent.ydkqmsp.sdk.c.i.a();
            }
            aVarA.f1319a = i;
            aVarA.b = i2;
            aVarA.c = i3;
            aVarA.e = str;
            aVarA.d = str2;
            com.tencent.ydkqmsp.sdk.c.j.this.c.a(aVarA, false);
            this.f1327a = true;
            com.tencent.ydkqmsp.sdk.f.g.a("Qp.QLM", 1, java.lang.String.format("visitQSecSFUItem libId = %d", java.lang.Integer.valueOf(i)));
            if (i4 == 1 && com.tencent.ydkqmsp.sdk.c.j.this.d.a(i) == 1) {
                com.tencent.ydkqmsp.sdk.c.j.f fVar = (com.tencent.ydkqmsp.sdk.c.j.f) com.tencent.ydkqmsp.sdk.c.j.this.f1320a.get(java.lang.Integer.valueOf(i));
                if (fVar == null) {
                    com.tencent.ydkqmsp.sdk.c.j.this.c(com.tencent.ydkqmsp.sdk.c.j.this.a(aVarA));
                    return;
                }
                com.tencent.ydkqmsp.sdk.c.j.this.a(fVar, str2, str);
                if (fVar.d != 0) {
                    com.tencent.ydkqmsp.sdk.c.j.this.f1320a.remove(java.lang.Integer.valueOf(fVar.f1324a));
                }
            }
        }
    }

    class d implements java.lang.Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.ydkqmsp.sdk.c.j.this.i();
        }
    }

    public interface e {
        void a(int i, int i2);
    }

    private static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1324a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public java.lang.String g;
        public java.lang.String h;
        public com.tencent.ydkqmsp.sdk.c.n i;

        private f() {
            this.d = -1;
            this.g = "";
            this.h = "";
        }

        /* synthetic */ f(com.tencent.ydkqmsp.sdk.c.j.a aVar) {
            this();
        }
    }

    private class g extends android.os.Handler {
        public g(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) throws java.lang.Throwable {
            switch (message.what) {
                case 1:
                    com.tencent.ydkqmsp.sdk.c.j.this.g();
                    break;
                case 2:
                    java.lang.Object obj = message.obj;
                    if (obj != null) {
                        com.tencent.ydkqmsp.sdk.c.j.this.b((java.util.List) obj);
                    }
                    break;
                case 3:
                    com.tencent.ydkqmsp.sdk.c.j.this.h();
                    break;
                case 4:
                    com.tencent.ydkqmsp.sdk.c.j.this.i();
                    break;
                case 5:
                    java.lang.Object obj2 = message.obj;
                    if (obj2 != null) {
                        com.tencent.ydkqmsp.sdk.c.j.this.c((com.tencent.ydkqmsp.sdk.c.j.e) obj2);
                    }
                    break;
            }
        }
    }

    private static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.tencent.ydkqmsp.sdk.c.j.i f1326a;

        public h(com.tencent.ydkqmsp.sdk.c.j.i iVar) {
            this.f1326a = iVar;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void a(int i) {
            com.tencent.ydkqmsp.sdk.c.j.i iVar;
            com.tencent.ydkqmsp.sdk.f.g.a("Qp.QLM", 1, java.lang.String.format("QSecSFUReader read, bid = %d ", java.lang.Integer.valueOf(i)));
            try {
                try {
                    java.util.List<com.tencent.ydkqmsp.sdk.d.d.b> listA = new com.tencent.ydkqmsp.sdk.d.b().a(1L);
                    if (listA != null) {
                        com.tencent.ydkqmsp.sdk.f.g.a("Qp.QLM", 1, java.lang.String.format("QSecSFUReader read updateSections count = %d ", java.lang.Integer.valueOf(listA.size())));
                        for (com.tencent.ydkqmsp.sdk.d.d.b bVar : listA) {
                            if (bVar.b == i && bVar.o != null) {
                                for (com.tencent.ydkqmsp.sdk.d.d.a aVar : bVar.o) {
                                    if (!android.text.TextUtils.isEmpty(aVar.i)) {
                                        java.lang.String str = aVar.f;
                                        if (!android.text.TextUtils.isEmpty(aVar.g)) {
                                            str = aVar.g;
                                        }
                                        if (str != null) {
                                            com.tencent.ydkqmsp.sdk.f.g.a("Qp.QLM", 1, java.lang.String.format("ExtraInfo: %s path: %s", aVar.i, str));
                                            org.json.JSONObject jSONObject = new org.json.JSONObject(aVar.i);
                                            int i2 = jSONObject.getInt(com.tencent.ydkqmsp.sdk.c.j.b(0));
                                            int i3 = jSONObject.getInt(com.tencent.ydkqmsp.sdk.c.j.b(1));
                                            int i4 = jSONObject.getInt(com.tencent.ydkqmsp.sdk.c.j.b(2));
                                            int i5 = jSONObject.getInt(com.tencent.ydkqmsp.sdk.c.j.b(3));
                                            java.lang.String string = jSONObject.getString(com.tencent.ydkqmsp.sdk.c.j.b(4));
                                            if (this.f1326a != null) {
                                                this.f1326a.a(str, string, i2, i3, i4, i5);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    iVar = this.f1326a;
                    if (iVar == null) {
                        return;
                    }
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                    iVar = this.f1326a;
                    if (iVar == null) {
                        return;
                    }
                }
                iVar.a();
            } catch (java.lang.Throwable th) {
                com.tencent.ydkqmsp.sdk.c.j.i iVar2 = this.f1326a;
                if (iVar2 != null) {
                    iVar2.a();
                }
                throw th;
            }
        }
    }

    private class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected boolean f1327a;

        private i() {
            this.f1327a = false;
        }

        /* synthetic */ i(com.tencent.ydkqmsp.sdk.c.j jVar, com.tencent.ydkqmsp.sdk.c.j.a aVar) {
            this();
        }

        public void a() {
            if (this.f1327a) {
                com.tencent.ydkqmsp.sdk.c.j.this.c.a();
            }
        }

        public void a(java.lang.String str, java.lang.String str2, int i, int i2, int i3, int i4) throws java.lang.Throwable {
            com.tencent.ydkqmsp.sdk.f.g.a("Qp.QLM", 1, java.lang.String.format("visitQSecSFUItem libPath = %s libVer = %s libId = %d", str, str2, java.lang.Integer.valueOf(i)));
            if (android.text.TextUtils.isEmpty(str2)) {
                return;
            }
            com.tencent.ydkqmsp.sdk.c.i.a aVarA = com.tencent.ydkqmsp.sdk.c.j.this.c.a(i);
            if (aVarA != null && str.equals(aVarA.e) && str2.equals(aVarA.d) && i2 == aVarA.b && i3 == aVarA.c) {
                return;
            }
            if (aVarA == null) {
                aVarA = new com.tencent.ydkqmsp.sdk.c.i.a();
            } else {
                com.tencent.ydkqmsp.sdk.c.j.this.c.a(i, false);
                com.tencent.ydkqmsp.sdk.f.g.a("Qp.QLM", 1, java.lang.String.format("Database info mismatch for lib: %d", java.lang.Integer.valueOf(i)));
            }
            aVarA.f1319a = i;
            aVarA.b = i2;
            aVarA.c = i3;
            aVarA.e = str;
            aVarA.d = str2;
            com.tencent.ydkqmsp.sdk.f.g.a("Qp.QLM", 1, java.lang.String.format("Add lost lib: %d,%d,%d,%s", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(aVarA.b), java.lang.Integer.valueOf(aVarA.c), aVarA.e));
            com.tencent.ydkqmsp.sdk.c.j.this.c.a(aVarA, false);
            this.f1327a = true;
        }
    }

    private j() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.tencent.ydkqmsp.sdk.c.j.f a(com.tencent.ydkqmsp.sdk.c.i.a aVar) {
        com.tencent.ydkqmsp.sdk.c.j.f fVar = new com.tencent.ydkqmsp.sdk.c.j.f(null);
        fVar.f1324a = aVar.f1319a;
        fVar.b = aVar.b;
        fVar.c = aVar.c;
        fVar.h = aVar.e;
        fVar.g = aVar.d;
        fVar.e = 4;
        return fVar;
    }

    private void a(int i2, int i3) {
        for (com.tencent.ydkqmsp.sdk.c.j.e eVar : this.h) {
            com.tencent.ydkqmsp.sdk.f.g.a("Qp.QLM", 1, java.lang.String.format("Notify listener [%d:%d]", java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3)));
            eVar.a(i2, i3);
        }
    }

    private void a(com.tencent.ydkqmsp.sdk.c.j.f fVar) {
        this.b.add(fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.tencent.ydkqmsp.sdk.c.j.f fVar, java.lang.String str, java.lang.String str2) {
        e(fVar);
        if (fVar.e == 4) {
            java.lang.String str3 = fVar.h;
            if (str3 != null && !str3.equals(str2)) {
                com.tencent.ydkqmsp.sdk.f.d.a(fVar.h, false);
                fVar.h = str2;
            }
            java.lang.String str4 = fVar.g;
            if (str4 != null && !str4.equals(str)) {
                fVar.g = str;
            }
            fVar.f = 0;
            d(fVar);
            a(fVar);
        }
    }

    private void a(java.util.List list) throws java.lang.Throwable {
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            com.tencent.ydkqmsp.sdk.c.i.a aVar = (com.tencent.ydkqmsp.sdk.c.i.a) it.next();
            this.c.a(aVar.f1319a, false);
            java.lang.String str = aVar.e;
            if (str != null) {
                com.tencent.ydkqmsp.sdk.f.d.a(str, false);
            }
        }
        this.c.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String b(int i2) {
        return com.tencent.ydkqmsp.sdk.f.k.a(i[i2]);
    }

    private void b(com.tencent.ydkqmsp.sdk.c.j.f fVar) {
        try {
            com.tencent.ydkqmsp.sdk.a.g gVar = new com.tencent.ydkqmsp.sdk.a.g();
            gVar.a(fVar.f1324a).a(fVar.g).a(fVar.d);
            com.tencent.ydkqmsp.sdk.a.f.a(gVar.toString(), 3);
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(java.util.List list) throws java.lang.Throwable {
        if (list == null || !this.f) {
            return;
        }
        java.util.LinkedList linkedList = new java.util.LinkedList();
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            android.util.Pair pair = (android.util.Pair) it.next();
            com.tencent.ydkqmsp.sdk.f.g.a("Qp.QLM", 1, java.lang.String.format("cb changed: id(%d), cb(%d)", pair.first, pair.second));
            com.tencent.ydkqmsp.sdk.c.j.f fVar = (com.tencent.ydkqmsp.sdk.c.j.f) this.f1320a.get(pair.first);
            if (fVar == null) {
                com.tencent.ydkqmsp.sdk.c.i.a aVarA = this.c.a(((java.lang.Integer) pair.first).intValue());
                if (aVarA != null) {
                    if (((java.lang.Integer) pair.second).intValue() == 1) {
                        c(a(aVarA));
                    } else if (((java.lang.Integer) pair.second).intValue() == 2) {
                        linkedList.add(aVarA);
                    }
                }
            } else if (((java.lang.Integer) pair.second).intValue() == 1) {
                if (fVar.e == 4) {
                    d(fVar);
                    if (fVar.d != 0) {
                        this.f1320a.remove(java.lang.Integer.valueOf(fVar.f1324a));
                    }
                    a(fVar);
                }
            } else if (((java.lang.Integer) pair.second).intValue() == 2 && fVar.e == 4) {
                this.f1320a.remove(pair.first);
                com.tencent.ydkqmsp.sdk.c.i.a aVarA2 = this.c.a(((java.lang.Integer) pair.first).intValue());
                if (aVarA2 != null) {
                    linkedList.add(aVarA2);
                }
            }
        }
        if (linkedList.isEmpty()) {
            return;
        }
        a(linkedList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.tencent.ydkqmsp.sdk.c.j.e eVar) {
        for (java.util.Map.Entry entry : this.f1320a.entrySet()) {
            if (((com.tencent.ydkqmsp.sdk.c.j.f) entry.getValue()).e == 1) {
                com.tencent.ydkqmsp.sdk.f.g.a("Qp.QLM", 1, java.lang.String.format("Notify listener [%d:%d]", 1, entry.getKey()));
                eVar.a(1, ((java.lang.Integer) entry.getKey()).intValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.tencent.ydkqmsp.sdk.c.j.f fVar) {
        d(fVar);
        if (fVar.d == 0) {
            this.f1320a.put(java.lang.Integer.valueOf(fVar.f1324a), fVar);
            a(1, fVar.f1324a);
        }
        a(fVar);
    }

    private void d() {
        com.tencent.ydkqmsp.sdk.f.g.a("Qp.QLM", 1, "addLostUpgradeLibs");
        new com.tencent.ydkqmsp.sdk.c.j.h(new com.tencent.ydkqmsp.sdk.c.j.i(this, null)).a(1);
    }

    private void d(com.tencent.ydkqmsp.sdk.c.j.f fVar) {
        fVar.e = 2;
        com.tencent.ydkqmsp.sdk.c.j.b bVar = new com.tencent.ydkqmsp.sdk.c.j.b(this);
        bVar.f1322a = fVar;
        new com.tencent.ydkqmsp.sdk.c.a(java.lang.String.format("Lib%d_%s", java.lang.Integer.valueOf(fVar.f1324a), fVar.g), 43200000L).a(bVar);
        java.lang.Object[] objArr = new java.lang.Object[3];
        java.lang.String str = fVar.h;
        if (str == null) {
            str = "null";
        }
        objArr[0] = str;
        objArr[1] = com.tencent.ydkqmsp.sdk.a.c.a(fVar.f);
        objArr[2] = java.lang.Integer.valueOf(fVar.d);
        com.tencent.ydkqmsp.sdk.f.g.a("Qp.QLM", 1, java.lang.String.format("load: %s ver: %s error: %08X", objArr));
        fVar.e = fVar.d != 0 ? 4 : 1;
    }

    public static com.tencent.ydkqmsp.sdk.c.j e() {
        if (j == null) {
            synchronized (com.tencent.ydkqmsp.sdk.c.j.class) {
                if (j == null) {
                    j = new com.tencent.ydkqmsp.sdk.c.j();
                }
            }
        }
        return j;
    }

    private void e(com.tencent.ydkqmsp.sdk.c.j.f fVar) {
        com.tencent.ydkqmsp.sdk.f.g.a("Qp.QLM", 1, java.lang.String.format("Prepare to unload: %d,%d,%d,%d,%s,%s", java.lang.Integer.valueOf(fVar.f1324a), java.lang.Integer.valueOf(fVar.b), java.lang.Integer.valueOf(fVar.c), java.lang.Integer.valueOf(fVar.e), fVar.g, fVar.h));
        if ((fVar.c & 1) != 0 && fVar.e == 1) {
            fVar.e = 3;
            fVar.i.c();
            int iA = com.tencent.ydkqmsp.sdk.c.f.a(3L, fVar.f1324a, 0L, 0L, null, null, null, null);
            com.tencent.ydkqmsp.sdk.f.g.a("Qp.QLM", 1, java.lang.String.format("Unload ret: %d", java.lang.Integer.valueOf(iA)));
            if (iA == 0) {
                fVar.e = 4;
                a(2, fVar.f1324a);
            } else {
                fVar.e = 5;
                fVar.d = iA;
            }
        }
    }

    private void f() throws java.lang.Throwable {
        java.util.List<com.tencent.ydkqmsp.sdk.c.i.a> listB = this.c.b();
        if (listB == null || listB.isEmpty()) {
            return;
        }
        java.util.LinkedList linkedList = new java.util.LinkedList();
        for (com.tencent.ydkqmsp.sdk.c.i.a aVar : listB) {
            int iA = this.d.a(aVar.f1319a);
            java.lang.Object[] objArr = new java.lang.Object[6];
            objArr[0] = java.lang.Integer.valueOf(aVar.f1319a);
            objArr[1] = java.lang.Integer.valueOf(aVar.b);
            objArr[2] = java.lang.Integer.valueOf(aVar.c);
            objArr[3] = aVar.d;
            java.lang.String str = aVar.e;
            if (str == null) {
                str = "null";
            }
            objArr[4] = str;
            objArr[5] = java.lang.Integer.valueOf(iA);
            com.tencent.ydkqmsp.sdk.f.g.a("Qp.QLM", 1, java.lang.String.format("%d,%d,%d,%s,%s,%d", objArr));
            if (iA != 0 && -1 != iA) {
                if (2 == iA) {
                    linkedList.add(aVar);
                } else if (1 == iA) {
                    com.tencent.ydkqmsp.sdk.c.j.f fVarA = a(aVar);
                    c(fVarA);
                    a(fVarA);
                }
                if (!linkedList.isEmpty()) {
                    a(linkedList);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (!this.f) {
            this.g = true;
        } else {
            this.g = false;
            new com.tencent.ydkqmsp.sdk.c.j.h(new com.tencent.ydkqmsp.sdk.c.j.c()).a(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() throws java.lang.Throwable {
        com.tencent.ydkqmsp.sdk.f.g.a("Qp.QLM", 1, "onLoadLocalLibs");
        if (this.f) {
            return;
        }
        this.f = true;
        d();
        f();
        if (this.g) {
            b();
        }
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        long j2;
        android.content.SharedPreferences sharedPreferences = com.tencent.ydkqmsp.sdk.app.a.getContext().getSharedPreferences(b(6), 0);
        android.content.SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        char c2 = 1;
        try {
            java.util.Iterator it = this.b.iterator();
            j2 = 28800000;
            while (it.hasNext()) {
                try {
                    com.tencent.ydkqmsp.sdk.c.j.f fVar = (com.tencent.ydkqmsp.sdk.c.j.f) it.next();
                    java.lang.String strA = fVar.g;
                    if (fVar.f != 0) {
                        strA = com.tencent.ydkqmsp.sdk.a.c.a(fVar.f);
                    }
                    java.lang.Object[] objArr = new java.lang.Object[3];
                    objArr[0] = java.lang.Integer.valueOf(fVar.f1324a);
                    objArr[c2] = com.tencent.ydkqmsp.sdk.app.a.getUid();
                    objArr[2] = strA;
                    java.lang.String str = java.lang.String.format("Lib%d_%s_%s", objArr);
                    java.lang.Object[] objArr2 = new java.lang.Object[3];
                    objArr2[0] = java.lang.Integer.valueOf(fVar.f1324a);
                    objArr2[c2] = com.tencent.ydkqmsp.sdk.app.a.getUid();
                    objArr2[2] = strA;
                    java.lang.String str2 = java.lang.String.format("Lib%d_%s_%s_lpt", objArr2);
                    int i2 = sharedPreferences.getInt(str, -1);
                    java.util.Iterator it2 = it;
                    long jCurrentTimeMillis = java.lang.System.currentTimeMillis() - sharedPreferences.getLong(str2, 0L);
                    if (jCurrentTimeMillis >= 28800000 || fVar.d != i2) {
                        com.tencent.ydkqmsp.sdk.f.g.a("Qp.QLM", 1, java.lang.String.format("Rp: %d,%d,%s", java.lang.Integer.valueOf(fVar.f1324a), java.lang.Integer.valueOf(fVar.d), strA));
                        editorEdit.putInt(str, fVar.d);
                        editorEdit.putLong(str2, java.lang.System.currentTimeMillis());
                        b(fVar);
                        this.b.remove(fVar);
                    } else {
                        com.tencent.ydkqmsp.sdk.f.g.a("Qp.QLM", 1, java.lang.String.format("Ignore rp for: %d,%08X,%s", java.lang.Integer.valueOf(fVar.f1324a), java.lang.Integer.valueOf(fVar.d), strA));
                        long j3 = 28800000 - jCurrentTimeMillis;
                        if (j2 > j3) {
                            j2 = j3;
                        }
                    }
                    it = it2;
                    c2 = 1;
                } catch (java.lang.Exception e2) {
                    e = e2;
                    e.printStackTrace();
                }
            }
        } catch (java.lang.Exception e3) {
            e = e3;
            j2 = 28800000;
        }
        editorEdit.commit();
        com.tencent.ydkqmsp.sdk.f.g.a("Qp.QLM", 1, "next rp interval: " + j2);
        com.tencent.ydkqmsp.sdk.c.f.i().c().postDelayed(new com.tencent.ydkqmsp.sdk.c.j.d(), j2);
    }

    private void j() {
        android.os.Handler handler = this.e;
        handler.sendMessage(handler.obtainMessage(4));
    }

    public int a(int i2, int i3, int i4, java.lang.Object[] objArr, java.lang.Object[] objArr2) {
        int iA;
        com.tencent.ydkqmsp.sdk.c.j.f fVar = (com.tencent.ydkqmsp.sdk.c.j.f) this.f1320a.get(java.lang.Integer.valueOf(i2));
        if (fVar == null) {
            iA = this.c.a(i2) == null ? 4 : 17;
        } else if (i3 != 0 && i3 != fVar.f) {
            iA = 32;
        } else if (fVar.f1324a != i2) {
            iA = 5;
        } else {
            int iA2 = this.d.a(i2);
            if (1 != iA2 && iA2 != -1) {
                iA = 6;
            } else if (fVar.e == 1 && fVar.i.a()) {
                iA = com.tencent.ydkqmsp.sdk.c.f.a(4L, fVar.f1324a, i3, i4, null, null, objArr, objArr2);
                fVar.i.b();
            } else {
                iA = 7;
            }
        }
        com.tencent.ydkqmsp.sdk.f.g.a("Qp.QLM", 1, java.lang.String.format("dispatch to id: %d, cmd: %d, err: %d", java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i4), java.lang.Integer.valueOf(iA)));
        return iA;
    }

    public void a() {
        try {
            if (this.f1320a != null) {
                for (java.util.Map.Entry entry : this.f1320a.entrySet()) {
                    ((com.tencent.ydkqmsp.sdk.c.j.f) entry.getValue()).c = 1;
                    e((com.tencent.ydkqmsp.sdk.c.j.f) entry.getValue());
                }
            }
            if (j != null) {
                j = null;
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(com.tencent.ydkqmsp.sdk.c.e eVar) {
        this.d = eVar;
        eVar.a(new com.tencent.ydkqmsp.sdk.c.j.a());
    }

    public void a(com.tencent.ydkqmsp.sdk.c.j.e eVar) {
        this.h.add(eVar);
        android.os.Handler handler = this.e;
        handler.sendMessage(handler.obtainMessage(5, eVar));
    }

    public void b() {
        android.os.Handler handler = this.e;
        handler.sendMessage(handler.obtainMessage(1));
    }

    public void b(com.tencent.ydkqmsp.sdk.c.j.e eVar) {
        this.h.remove(eVar);
    }

    public void c() {
        com.tencent.ydkqmsp.sdk.f.g.a("Qp.QLM", 1, java.lang.String.format("OnEveryLogin mHasLoadLocal = %b", java.lang.Boolean.valueOf(this.f)));
        if (this.f) {
            return;
        }
        android.os.Handler handler = this.e;
        handler.sendMessage(handler.obtainMessage(3));
    }
}
