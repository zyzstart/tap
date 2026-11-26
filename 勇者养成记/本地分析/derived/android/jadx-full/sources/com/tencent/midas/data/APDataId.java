package com.tencent.midas.data;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APDataId {
    private static com.tencent.midas.data.APDataId gInstance;
    private static int paydataCount;
    private final java.lang.String TENCENTUNIPAY_DATAID_FLAG = com.tencent.midas.data.APPluginDataInterface.SHARE_PREFERENCE_NAME;
    private final java.lang.String DATA_DISCOUNT_INIT = "initdataCount";
    private final java.lang.String DATA_DISCOUNT_PAY = "dataCount";

    private APDataId() {
    }

    public static int getDataId() {
        int i = paydataCount;
        paydataCount = i + 1;
        return i;
    }

    public static void initDataId() {
        paydataCount = 0;
    }
}
