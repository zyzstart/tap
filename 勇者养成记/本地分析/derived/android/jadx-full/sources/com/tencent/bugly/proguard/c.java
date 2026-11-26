package com.tencent.bugly.proguard;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c extends com.tencent.bugly.proguard.a {
    protected java.util.HashMap<java.lang.String, byte[]> d = null;
    private java.util.HashMap<java.lang.String, java.lang.Object> e = new java.util.HashMap<>();
    private com.tencent.bugly.proguard.i f = new com.tencent.bugly.proguard.i();

    @Override // com.tencent.bugly.proguard.a
    public final /* bridge */ /* synthetic */ void a(java.lang.String str) {
        super.a(str);
    }

    @Override // com.tencent.bugly.proguard.a
    public <T> void a(java.lang.String str, T t) {
        if (this.d == null) {
            super.a(str, t);
            return;
        }
        if (str == null) {
            throw new java.lang.IllegalArgumentException("put key can not is null");
        }
        if (t == null) {
            throw new java.lang.IllegalArgumentException("put value can not is null");
        }
        if (t instanceof java.util.Set) {
            throw new java.lang.IllegalArgumentException("can not support Set");
        }
        com.tencent.bugly.proguard.j jVar = new com.tencent.bugly.proguard.j();
        jVar.a(this.b);
        jVar.a(t, 0);
        this.d.put(str, com.tencent.bugly.proguard.l.a(jVar.a()));
    }

    @Override // com.tencent.bugly.proguard.a
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

    @Override // com.tencent.bugly.proguard.a
    public byte[] a() {
        if (this.d == null) {
            return super.a();
        }
        com.tencent.bugly.proguard.j jVar = new com.tencent.bugly.proguard.j(0);
        jVar.a(this.b);
        jVar.a((java.util.Map) this.d, 0);
        return com.tencent.bugly.proguard.l.a(jVar.a());
    }

    public final <T> T b(java.lang.String str, T t) throws com.tencent.bugly.proguard.b {
        java.util.HashMap<java.lang.String, byte[]> map = this.d;
        if (map != null) {
            if (!map.containsKey(str)) {
                return null;
            }
            if (this.e.containsKey(str)) {
                return (T) this.e.get(str);
            }
            try {
                this.f.a(this.d.get(str));
                this.f.a(this.b);
                T t2 = (T) this.f.a((java.lang.Object) t, 0, true);
                if (t2 != null) {
                    this.e.put(str, t2);
                }
                return t2;
            } catch (java.lang.Exception e) {
                throw new com.tencent.bugly.proguard.b(e);
            }
        }
        if (!this.f416a.containsKey(str)) {
            return null;
        }
        if (this.e.containsKey(str)) {
            return (T) this.e.get(str);
        }
        byte[] value = new byte[0];
        java.util.Iterator<java.util.Map.Entry<java.lang.String, byte[]>> it = this.f416a.get(str).entrySet().iterator();
        if (it.hasNext()) {
            java.util.Map.Entry<java.lang.String, byte[]> next = it.next();
            next.getKey();
            value = next.getValue();
        }
        try {
            this.f.a(value);
            this.f.a(this.b);
            T t3 = (T) this.f.a((java.lang.Object) t, 0, true);
            this.e.put(str, t3);
            return t3;
        } catch (java.lang.Exception e2) {
            throw new com.tencent.bugly.proguard.b(e2);
        }
    }

    public void c() {
        this.d = new java.util.HashMap<>();
    }
}
