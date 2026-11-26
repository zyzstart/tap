package com.tencent.qqdownloader.pay.utils.kapalaiadapter.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class h implements com.tencent.qqdownloader.pay.utils.kapalaiadapter.a.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public android.telephony.TelephonyManager f796a = null;
    public int b = 1;
    public int c = 5;

    public java.lang.Object a(int i, android.content.Context context) {
        if (this.f796a == null) {
            try {
                this.f796a = (android.telephony.TelephonyManager) context.getSystemService("phone");
            } catch (java.lang.Exception unused) {
            }
        }
        return this.f796a;
    }

    @Override // com.tencent.qqdownloader.pay.utils.kapalaiadapter.a.j
    public java.lang.String b(int i, android.content.Context context) {
        java.lang.Object objA = a(i, context);
        try {
            java.lang.Object[] objArr = new java.lang.Object[1];
            objArr[0] = java.lang.Integer.valueOf(i == 0 ? this.b : this.c);
            return (java.lang.String) com.tencent.qqdownloader.pay.utils.g.a(objA, "getDeviceIdExt", objArr);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }
}
