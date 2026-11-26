package com.tencent.qqdownloader.pay.utils.kapalaiadapter.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c implements com.tencent.qqdownloader.pay.utils.kapalaiadapter.a.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public android.telephony.TelephonyManager[] f791a = null;

    public android.telephony.TelephonyManager a(int i, android.content.Context context) {
        if (this.f791a == null) {
            try {
                android.telephony.TelephonyManager[] telephonyManagerArr = new android.telephony.TelephonyManager[2];
                this.f791a = telephonyManagerArr;
                telephonyManagerArr[0] = (android.telephony.TelephonyManager) com.tencent.qqdownloader.pay.utils.g.a("android.telephony.TelephonyManager", "getDefault", new java.lang.Object[]{0});
                this.f791a[1] = (android.telephony.TelephonyManager) com.tencent.qqdownloader.pay.utils.g.a("android.telephony.TelephonyManager", "getDefault", new java.lang.Object[]{1});
            } catch (java.lang.Exception unused) {
            }
        }
        android.telephony.TelephonyManager[] telephonyManagerArr2 = this.f791a;
        if (telephonyManagerArr2 == null || telephonyManagerArr2.length <= i) {
            return null;
        }
        return telephonyManagerArr2[i > 0 ? (char) 1 : (char) 0];
    }

    @Override // com.tencent.qqdownloader.pay.utils.kapalaiadapter.a.j
    public java.lang.String b(int i, android.content.Context context) {
        try {
            android.telephony.TelephonyManager telephonyManagerA = a(i, context);
            if (telephonyManagerA != null) {
                return telephonyManagerA.getDeviceId();
            }
        } catch (java.lang.Exception unused) {
        }
        return null;
    }
}
