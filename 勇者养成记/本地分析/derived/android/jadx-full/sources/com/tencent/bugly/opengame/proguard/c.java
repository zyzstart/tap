package com.tencent.bugly.opengame.proguard;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c extends com.tencent.bugly.opengame.proguard.a {
    protected java.util.HashMap d = null;
    private java.util.HashMap e = new java.util.HashMap();
    private com.tencent.bugly.opengame.proguard.i f = new com.tencent.bugly.opengame.proguard.i();

    @Override // com.tencent.bugly.opengame.proguard.a
    public final /* bridge */ /* synthetic */ void a(java.lang.String str) {
        super.a(str);
    }

    @Override // com.tencent.bugly.opengame.proguard.a
    public void a(java.lang.String str, java.lang.Object obj) {
        if (this.d == null) {
            super.a(str, obj);
            return;
        }
        if (str == null) {
            throw new java.lang.IllegalArgumentException("put key can not is null");
        }
        if (obj == null) {
            throw new java.lang.IllegalArgumentException("put value can not is null");
        }
        if (obj instanceof java.util.Set) {
            throw new java.lang.IllegalArgumentException("can not support Set");
        }
        com.tencent.bugly.opengame.proguard.j jVar = new com.tencent.bugly.opengame.proguard.j();
        jVar.a(this.b);
        jVar.a(obj, 0);
        this.d.put(str, com.tencent.bugly.opengame.proguard.l.a(jVar.a()));
    }

    @Override // com.tencent.bugly.opengame.proguard.a
    public void a(byte[] bArr) {
        try {
            super.a(bArr);
        } catch (java.lang.Exception unused) {
            this.f.a(bArr);
            this.f.a(this.b);
            java.util.HashMap map = new java.util.HashMap(1);
            map.put("", new byte[0]);
            this.d = this.f.a((java.util.Map) map, 0, false);
        }
    }

    @Override // com.tencent.bugly.opengame.proguard.a
    public byte[] a() {
        if (this.d == null) {
            return super.a();
        }
        com.tencent.bugly.opengame.proguard.j jVar = new com.tencent.bugly.opengame.proguard.j(0);
        jVar.a(this.b);
        jVar.a((java.util.Map) this.d, 0);
        return com.tencent.bugly.opengame.proguard.l.a(jVar.a());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final java.lang.Object b(java.lang.String str, java.lang.Object obj) {
        java.util.HashMap map = this.d;
        if (map != null) {
            if (!map.containsKey(str)) {
                return null;
            }
            if (!this.e.containsKey(str)) {
                try {
                    this.f.a((byte[]) this.d.get(str));
                    this.f.a(this.b);
                    java.lang.Object objA = this.f.a(obj, 0, true);
                    if (objA != null) {
                        this.e.put(str, objA);
                    }
                    return objA;
                } catch (java.lang.Exception e) {
                    throw new com.tencent.bugly.opengame.proguard.b(e);
                }
            }
        } else {
            if (!this.f374a.containsKey(str)) {
                return null;
            }
            if (!this.e.containsKey(str)) {
                byte[] bArr = new byte[0];
                java.util.Iterator it = ((java.util.HashMap) this.f374a.get(str)).entrySet().iterator();
                if (it.hasNext()) {
                    java.util.Map.Entry entry = (java.util.Map.Entry) it.next();
                    entry.getKey();
                    bArr = (byte[]) entry.getValue();
                }
                try {
                    this.f.a(bArr);
                    this.f.a(this.b);
                    java.lang.Object objA2 = this.f.a(obj, 0, true);
                    this.e.put(str, objA2);
                    return objA2;
                } catch (java.lang.Exception e2) {
                    throw new com.tencent.bugly.opengame.proguard.b(e2);
                }
            }
        }
        return this.e.get(str);
    }

    public void c() {
        this.d = new java.util.HashMap();
    }
}
