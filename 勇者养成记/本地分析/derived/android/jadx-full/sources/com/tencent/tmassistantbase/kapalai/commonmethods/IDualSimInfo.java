package com.tencent.tmassistantbase.kapalai.commonmethods;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface IDualSimInfo {
    public static final int CLASS_NUMBER = -1;

    java.lang.String getKapalaiDualSimIMEI(int i, android.content.Context context);

    java.lang.String getKapalaiDualSimIMSI(int i, android.content.Context context);

    java.lang.Object getKapalaiSimTelephonyManager(int i, android.content.Context context);
}
