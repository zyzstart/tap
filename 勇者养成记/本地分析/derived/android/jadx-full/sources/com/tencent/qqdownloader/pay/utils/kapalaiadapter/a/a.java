package com.tencent.qqdownloader.pay.utils.kapalaiadapter.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a implements com.tencent.qqdownloader.pay.utils.kapalaiadapter.a.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public java.lang.Object[] f789a = null;

    public java.lang.Object a(int i, android.content.Context context) {
        if (this.f789a == null) {
            try {
                java.lang.Object[] objArr = new java.lang.Object[2];
                this.f789a = objArr;
                objArr[0] = context.getSystemService("phone");
                this.f789a[1] = context.getSystemService("phone2");
            } catch (java.lang.Exception unused) {
            }
        }
        java.lang.Object[] objArr2 = this.f789a;
        if (objArr2 == null || objArr2.length <= i) {
            return null;
        }
        return objArr2[i > 0 ? (char) 1 : (char) 0];
    }

    @Override // com.tencent.qqdownloader.pay.utils.kapalaiadapter.a.j
    public java.lang.String b(int i, android.content.Context context) {
        java.lang.Object objA = a(i, context);
        if (objA != null) {
            try {
                return (java.lang.String) com.tencent.qqdownloader.pay.utils.g.a(objA, "getDeviceId");
            } catch (java.lang.Exception unused) {
            }
        }
        return null;
    }
}
