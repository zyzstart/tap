package com.tencent.tmassistantbase.kapalai.commonmethods;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class CommonDualSimInfo04 implements com.tencent.tmassistantbase.kapalai.commonmethods.IDualSimInfo {
    public static final int CLASS_NUMBER = 4;
    private android.telephony.TelephonyManager[] simTelephonyManager = null;

    @Override // com.tencent.tmassistantbase.kapalai.commonmethods.IDualSimInfo
    public java.lang.String getKapalaiDualSimIMEI(int i, android.content.Context context) {
        return ((android.telephony.TelephonyManager) context.getSystemService("phone")).getDeviceId();
    }

    @Override // com.tencent.tmassistantbase.kapalai.commonmethods.IDualSimInfo
    public java.lang.String getKapalaiDualSimIMSI(int i, android.content.Context context) {
        java.lang.reflect.Method declaredMethod;
        java.lang.String subscriberId;
        android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) getKapalaiSimTelephonyManager(i, context);
        java.lang.String str = null;
        try {
            if (i <= 0) {
                subscriberId = telephonyManager.getSubscriberId();
            } else {
                if (telephonyManager == null || (declaredMethod = telephonyManager.getClass().getDeclaredMethod("getSubscriberId", null)) == null) {
                    return null;
                }
                declaredMethod.setAccessible(true);
                subscriberId = (java.lang.String) declaredMethod.invoke(telephonyManager, null);
            }
            str = subscriberId;
            return str;
        } catch (java.lang.Exception unused) {
            return str;
        }
    }

    @Override // com.tencent.tmassistantbase.kapalai.commonmethods.IDualSimInfo
    public java.lang.Object getKapalaiSimTelephonyManager(int i, android.content.Context context) {
        if (this.simTelephonyManager == null) {
            try {
                android.telephony.TelephonyManager[] telephonyManagerArr = new android.telephony.TelephonyManager[2];
                this.simTelephonyManager = telephonyManagerArr;
                telephonyManagerArr[0] = (android.telephony.TelephonyManager) context.getSystemService("phone");
                this.simTelephonyManager[1] = (android.telephony.TelephonyManager) context.getSystemService("phone2");
            } catch (java.lang.Exception unused) {
            }
        }
        android.telephony.TelephonyManager[] telephonyManagerArr2 = this.simTelephonyManager;
        if (telephonyManagerArr2 != null) {
            return telephonyManagerArr2[i > 0 ? (char) 1 : (char) 0];
        }
        return null;
    }
}
