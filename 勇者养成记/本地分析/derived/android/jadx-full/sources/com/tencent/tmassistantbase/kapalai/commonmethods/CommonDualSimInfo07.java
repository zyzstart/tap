package com.tencent.tmassistantbase.kapalai.commonmethods;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class CommonDualSimInfo07 implements com.tencent.tmassistantbase.kapalai.commonmethods.IDualSimInfo {
    public static final int CLASS_NUMBER = 7;
    private android.telephony.TelephonyManager simTelephonyManager = null;
    private int mCardId1 = 1;
    private int mCardId2 = 5;

    @Override // com.tencent.tmassistantbase.kapalai.commonmethods.IDualSimInfo
    public java.lang.String getKapalaiDualSimIMEI(int i, android.content.Context context) {
        java.lang.Object kapalaiSimTelephonyManager = getKapalaiSimTelephonyManager(i, context);
        try {
            java.lang.Object[] objArr = new java.lang.Object[1];
            objArr[0] = java.lang.Integer.valueOf(i == 0 ? this.mCardId1 : this.mCardId2);
            return (java.lang.String) com.tencent.tmassistantbase.kapalai.ReflecterHelper.invokeMethod(kapalaiSimTelephonyManager, "getDeviceIdExt", objArr);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    @Override // com.tencent.tmassistantbase.kapalai.commonmethods.IDualSimInfo
    public java.lang.String getKapalaiDualSimIMSI(int i, android.content.Context context) {
        java.lang.Object kapalaiSimTelephonyManager = getKapalaiSimTelephonyManager(i, context);
        try {
            java.lang.Object[] objArr = new java.lang.Object[1];
            objArr[0] = java.lang.Integer.valueOf(i == 0 ? this.mCardId1 : this.mCardId2);
            return (java.lang.String) com.tencent.tmassistantbase.kapalai.ReflecterHelper.invokeMethod(kapalaiSimTelephonyManager, "getSubscriberIdExt", objArr);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    @Override // com.tencent.tmassistantbase.kapalai.commonmethods.IDualSimInfo
    public java.lang.Object getKapalaiSimTelephonyManager(int i, android.content.Context context) {
        if (this.simTelephonyManager == null) {
            try {
                this.simTelephonyManager = (android.telephony.TelephonyManager) context.getSystemService("phone");
            } catch (java.lang.Exception unused) {
            }
        }
        return this.simTelephonyManager;
    }
}
