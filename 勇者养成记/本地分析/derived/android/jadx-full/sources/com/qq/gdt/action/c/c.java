package com.qq.gdt.action.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.nio.ByteBuffer f75a;

    public c() {
        this.f75a = java.nio.ByteBuffer.allocate(4096);
        this.f75a.order(java.nio.ByteOrder.BIG_ENDIAN);
    }

    public c(byte[] bArr) {
        this.f75a = java.nio.ByteBuffer.wrap(bArr);
        this.f75a.order(java.nio.ByteOrder.BIG_ENDIAN);
    }

    private boolean b(int i) {
        return i <= this.f75a.remaining();
    }

    public com.qq.gdt.action.c.c a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            a(4);
            this.f75a.putInt(0);
        } else {
            byte[] bytes = str.getBytes(com.qq.gdt.action.c.f72a);
            a(bytes.length + 4);
            this.f75a.putInt(bytes.length);
            this.f75a.put(bytes);
        }
        return this;
    }

    public com.qq.gdt.action.c.c a(org.json.JSONObject jSONObject) {
        a(jSONObject != null ? jSONObject.toString() : null);
        return this;
    }

    public java.lang.String a() {
        int i;
        if (!b(4) || (i = this.f75a.getInt()) <= 0 || !b(i)) {
            return null;
        }
        byte[] bArr = new byte[i];
        this.f75a.get(bArr);
        return new java.lang.String(bArr, com.qq.gdt.action.c.f72a);
    }

    public void a(int i) {
        if (i > this.f75a.remaining()) {
            int iCapacity = this.f75a.capacity();
            while (iCapacity - this.f75a.position() > i) {
                iCapacity *= 2;
            }
            java.nio.ByteBuffer byteBufferAllocate = java.nio.ByteBuffer.allocate(iCapacity);
            this.f75a.flip();
            byte[] bArr = new byte[this.f75a.limit()];
            this.f75a.get(bArr);
            byteBufferAllocate.put(bArr);
            this.f75a = byteBufferAllocate;
            this.f75a.order(java.nio.ByteOrder.BIG_ENDIAN);
        }
    }

    public org.json.JSONObject b() {
        java.lang.String strA = a();
        if (android.text.TextUtils.isEmpty(strA)) {
            return null;
        }
        try {
            return new org.json.JSONObject(strA);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public byte[] c() {
        int iPosition = this.f75a.position();
        this.f75a.clear();
        byte[] bArr = new byte[iPosition];
        this.f75a.get(bArr);
        return bArr;
    }
}
