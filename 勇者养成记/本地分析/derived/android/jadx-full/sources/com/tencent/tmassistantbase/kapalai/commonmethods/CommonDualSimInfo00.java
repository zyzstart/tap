package com.tencent.tmassistantbase.kapalai.commonmethods;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class CommonDualSimInfo00 implements com.tencent.tmassistantbase.kapalai.commonmethods.IDualSimInfo {
    public static final int CLASS_NUMBER = 0;
    private java.lang.Object[] simTelephonyManager = null;

    @Override // com.tencent.tmassistantbase.kapalai.commonmethods.IDualSimInfo
    public java.lang.String getKapalaiDualSimIMEI(int i, android.content.Context context) {
        java.lang.Object kapalaiSimTelephonyManager = getKapalaiSimTelephonyManager(i, context);
        if (kapalaiSimTelephonyManager != null) {
            try {
                return (java.lang.String) com.tencent.tmassistantbase.kapalai.ReflecterHelper.invokeMethod(kapalaiSimTelephonyManager, "getDeviceId");
            } catch (java.lang.Exception unused) {
            }
        }
        return null;
    }

    @Override // com.tencent.tmassistantbase.kapalai.commonmethods.IDualSimInfo
    public java.lang.String getKapalaiDualSimIMSI(int i, android.content.Context context) {
        java.lang.Object kapalaiSimTelephonyManager = getKapalaiSimTelephonyManager(i, context);
        if (kapalaiSimTelephonyManager != null) {
            try {
                return (java.lang.String) com.tencent.tmassistantbase.kapalai.ReflecterHelper.invokeMethod(kapalaiSimTelephonyManager, "getSubscriberId");
            } catch (java.lang.Exception unused) {
            }
        }
        return null;
    }

    @Override // com.tencent.tmassistantbase.kapalai.commonmethods.IDualSimInfo
    public java.lang.Object getKapalaiSimTelephonyManager(int i, android.content.Context context) {
        if (this.simTelephonyManager == null) {
            try {
                java.lang.Object[] objArr = new java.lang.Object[2];
                this.simTelephonyManager = objArr;
                objArr[0] = context.getSystemService("phone");
                this.simTelephonyManager[1] = context.getSystemService("phone2");
            } catch (java.lang.Exception unused) {
            }
        }
        java.lang.Object[] objArr2 = this.simTelephonyManager;
        if (objArr2 == null || objArr2.length <= i) {
            return null;
        }
        return objArr2[i > 0 ? (char) 1 : (char) 0];
    }
}
