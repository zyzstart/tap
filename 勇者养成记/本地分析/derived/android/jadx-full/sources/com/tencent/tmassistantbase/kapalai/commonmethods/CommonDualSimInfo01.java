package com.tencent.tmassistantbase.kapalai.commonmethods;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class CommonDualSimInfo01 implements com.tencent.tmassistantbase.kapalai.commonmethods.IDualSimInfo {
    public static final int CLASS_NUMBER = 1;
    private android.telephony.TelephonyManager simTelephonyManager = null;

    @Override // com.tencent.tmassistantbase.kapalai.commonmethods.IDualSimInfo
    public java.lang.String getKapalaiDualSimIMEI(int i, android.content.Context context) {
        return ((android.telephony.TelephonyManager) context.getSystemService("phone")).getDeviceId();
    }

    @Override // com.tencent.tmassistantbase.kapalai.commonmethods.IDualSimInfo
    public java.lang.String getKapalaiDualSimIMSI(int i, android.content.Context context) {
        try {
            return (java.lang.String) com.tencent.tmassistantbase.kapalai.ReflecterHelper.invokeMethod((android.telephony.TelephonyManager) getKapalaiSimTelephonyManager(i, context), "getSubscriberIdGemini", new java.lang.Object[]{java.lang.Integer.valueOf(i)});
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    @Override // com.tencent.tmassistantbase.kapalai.commonmethods.IDualSimInfo
    public java.lang.Object getKapalaiSimTelephonyManager(int i, android.content.Context context) {
        if (this.simTelephonyManager == null) {
            try {
                this.simTelephonyManager = (android.telephony.TelephonyManager) com.tencent.tmassistantbase.kapalai.ReflecterHelper.invokeStaticMethod("android.telephony.TelephonyManager", "getDefault", null, null);
            } catch (java.lang.Exception unused) {
            }
        }
        return this.simTelephonyManager;
    }
}
