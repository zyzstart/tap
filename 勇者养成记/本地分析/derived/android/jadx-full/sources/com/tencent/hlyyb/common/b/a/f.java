package com.tencent.hlyyb.common.b.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class f {
    public java.lang.String b;
    public byte[] d;
    private java.util.Map e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f547a = 0;
    public int c = 0;

    public f(int i, java.lang.String str, int i2) {
        this.b = str;
    }

    public final java.lang.String a(java.lang.String str) {
        if (this.e == null || android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        java.lang.String str2 = (java.lang.String) this.e.get(str.toLowerCase());
        return !android.text.TextUtils.isEmpty(str2) ? str2 : "";
    }

    public final void a(java.util.Map map) {
        this.e = new java.util.HashMap();
        if (map.size() > 0) {
            for (java.lang.String str : map.keySet()) {
                this.e.put(str.toLowerCase(), map.get(str));
            }
        }
    }

    public final java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("errorCode:");
        sb.append(this.f547a);
        sb.append(",errorInfo:");
        sb.append(this.b);
        sb.append(",httpStatus:");
        sb.append(this.c);
        sb.append(",headers:");
        sb.append(this.e);
        sb.append(",body:");
        byte[] bArr = this.d;
        sb.append(bArr != null ? java.lang.Integer.valueOf(bArr.length) : "null");
        return sb.toString();
    }
}
