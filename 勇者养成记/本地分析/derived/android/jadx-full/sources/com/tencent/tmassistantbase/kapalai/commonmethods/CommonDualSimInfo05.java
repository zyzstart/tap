package com.tencent.tmassistantbase.kapalai.commonmethods;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class CommonDualSimInfo05 implements com.tencent.tmassistantbase.kapalai.commonmethods.IDualSimInfo {
    public static final int CLASS_NUMBER = 5;
    private java.lang.Object simTelephonyManager = null;

    @Override // com.tencent.tmassistantbase.kapalai.commonmethods.IDualSimInfo
    public java.lang.String getKapalaiDualSimIMEI(int i, android.content.Context context) {
        return ((android.telephony.TelephonyManager) context.getSystemService("phone")).getDeviceId();
    }

    @Override // com.tencent.tmassistantbase.kapalai.commonmethods.IDualSimInfo
    public java.lang.String getKapalaiDualSimIMSI(int i, android.content.Context context) {
        try {
            return (java.lang.String) com.tencent.tmassistantbase.kapalai.ReflecterHelper.invokeMethod(getKapalaiSimTelephonyManager(i, context), "getSubscriberId", new java.lang.Object[]{java.lang.Integer.valueOf(i)});
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    @Override // com.tencent.tmassistantbase.kapalai.commonmethods.IDualSimInfo
    public java.lang.Object getKapalaiSimTelephonyManager(int i, android.content.Context context) {
        if (this.simTelephonyManager == null) {
            try {
                this.simTelephonyManager = context.getSystemService("phone");
            } catch (java.lang.Exception unused) {
            }
        }
        return this.simTelephonyManager;
    }
}
