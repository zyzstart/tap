package com.tencent.smtt.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tencent.smtt.utils.p.b f983a = null;
    private com.tencent.smtt.utils.p.b b = null;

    class a {
        private java.lang.String b;
        private long c;
        private long d;

        a(java.lang.String str, long j, long j2) {
            this.b = str;
            this.c = j;
            this.d = j2;
        }

        long a() {
            return this.c;
        }

        long b() {
            return this.d;
        }
    }

    class b {
        private java.util.Map b;

        b(java.io.File file) {
            java.util.HashMap map = new java.util.HashMap();
            this.b = map;
            map.clear();
            a(file);
        }

        private void a(java.io.File file) {
            if (!file.isDirectory()) {
                if (file.isFile()) {
                    a(file.getName(), file.length(), file.lastModified());
                    return;
                }
                return;
            }
            java.io.File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null || android.os.Build.VERSION.SDK_INT < 26) {
                for (java.io.File file2 : fileArrListFiles) {
                    a(file2);
                }
            }
        }

        private void a(java.lang.String str, long j, long j2) {
            if (str == null || str.length() <= 0 || j <= 0 || j2 <= 0) {
                return;
            }
            com.tencent.smtt.utils.p.a aVar = com.tencent.smtt.utils.p.this.new a(str, j, j2);
            if (this.b.containsKey(str)) {
                return;
            }
            this.b.put(str, aVar);
        }

        java.util.Map a() {
            return this.b;
        }
    }

    private boolean a(com.tencent.smtt.utils.p.b bVar, com.tencent.smtt.utils.p.b bVar2) {
        if (bVar == null || bVar.a() == null || bVar2 == null || bVar2.a() == null) {
            return false;
        }
        java.util.Map mapA = bVar.a();
        java.util.Map mapA2 = bVar2.a();
        for (java.util.Map.Entry entry : mapA.entrySet()) {
            java.lang.String str = (java.lang.String) entry.getKey();
            com.tencent.smtt.utils.p.a aVar = (com.tencent.smtt.utils.p.a) entry.getValue();
            if (mapA2.containsKey(str)) {
                com.tencent.smtt.utils.p.a aVar2 = (com.tencent.smtt.utils.p.a) mapA2.get(str);
                if (aVar.a() != aVar2.a() || aVar.b() != aVar2.b()) {
                }
            }
            return false;
        }
        return true;
    }

    public void a(java.io.File file) {
        this.f983a = new com.tencent.smtt.utils.p.b(file);
    }

    public boolean a() {
        com.tencent.smtt.utils.p.b bVar = this.b;
        return bVar != null && this.f983a != null && bVar.a().size() == this.f983a.a().size() && a(this.f983a, this.b);
    }

    public void b(java.io.File file) {
        this.b = new com.tencent.smtt.utils.p.b(file);
    }
}
