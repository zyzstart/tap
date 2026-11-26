package com.tencent.tmassistantbase.kapalai.commonmethods;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class CommonDualSimInfo02 implements com.tencent.tmassistantbase.kapalai.commonmethods.IDualSimInfo {
    public static final int CLASS_NUMBER = 2;
    private android.telephony.TelephonyManager[] simTelephonyManager = null;

    @Override // com.tencent.tmassistantbase.kapalai.commonmethods.IDualSimInfo
    public java.lang.String getKapalaiDualSimIMEI(int i, android.content.Context context) {
        try {
            android.telephony.TelephonyManager kapalaiSimTelephonyManager = getKapalaiSimTelephonyManager(i, context);
            if (kapalaiSimTelephonyManager != null) {
                return kapalaiSimTelephonyManager.getDeviceId();
            }
        } catch (java.lang.Exception unused) {
        }
        return null;
    }

    @Override // com.tencent.tmassistantbase.kapalai.commonmethods.IDualSimInfo
    public java.lang.String getKapalaiDualSimIMSI(int i, android.content.Context context) {
        try {
            android.telephony.TelephonyManager kapalaiSimTelephonyManager = getKapalaiSimTelephonyManager(i, context);
            if (kapalaiSimTelephonyManager != null) {
                return kapalaiSimTelephonyManager.getSubscriberId();
            }
        } catch (java.lang.Exception unused) {
        }
        return null;
    }

    @Override // com.tencent.tmassistantbase.kapalai.commonmethods.IDualSimInfo
    public android.telephony.TelephonyManager getKapalaiSimTelephonyManager(int i, android.content.Context context) {
        if (this.simTelephonyManager == null) {
            try {
                android.telephony.TelephonyManager[] telephonyManagerArr = new android.telephony.TelephonyManager[2];
                this.simTelephonyManager = telephonyManagerArr;
                telephonyManagerArr[0] = (android.telephony.TelephonyManager) com.tencent.tmassistantbase.kapalai.ReflecterHelper.invokeStaticMethod("android.telephony.TelephonyManager", "getDefault", new java.lang.Object[]{0});
                this.simTelephonyManager[1] = (android.telephony.TelephonyManager) com.tencent.tmassistantbase.kapalai.ReflecterHelper.invokeStaticMethod("android.telephony.TelephonyManager", "getDefault", new java.lang.Object[]{1});
            } catch (java.lang.Exception unused) {
            }
        }
        android.telephony.TelephonyManager[] telephonyManagerArr2 = this.simTelephonyManager;
        if (telephonyManagerArr2 == null || telephonyManagerArr2.length <= i) {
            return null;
        }
        return telephonyManagerArr2[i > 0 ? (char) 1 : (char) 0];
    }
}
