package com.tencent.ysdk.shell.libware.device;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public enum APN {
    UN_DETECT(0),
    WIFI(1),
    CMWAP(2),
    CMNET(3),
    UNIWAP(4),
    UNINET(5),
    WAP3G(6),
    NET3G(7),
    CTWAP(8),
    CTNET(9),
    UNKNOWN(10),
    UNKNOW_WAP(11),
    NO_NETWORK(12),
    WAP4G(13),
    NET4G(14);

    private static android.util.SparseArray<java.lang.String> sAPN = new android.util.SparseArray<>();
    private java.lang.String mValueStr = "";
    private int value;

    static {
        sAPN.put(1, "wifi");
        sAPN.put(2, "cmwap");
        sAPN.put(3, "cmnet");
        sAPN.put(4, "uniwap");
        sAPN.put(5, "uninet");
        sAPN.put(6, "3gwap");
        sAPN.put(7, "3gnet");
        sAPN.put(8, "ctwap");
        sAPN.put(9, "ctnet");
        sAPN.put(10, "unknow");
        sAPN.put(11, "wap");
        sAPN.put(12, "net");
        sAPN.put(13, "4gwap");
        sAPN.put(14, "4gnet");
    }

    APN(int i) {
        this.value = 0;
        this.value = i;
    }

    public byte getByteValue() {
        return (byte) this.value;
    }

    public java.lang.String getStringValue() {
        if (!android.text.TextUtils.isEmpty(this.mValueStr)) {
            return this.mValueStr;
        }
        this.mValueStr = sAPN.get(this.value, "unknow");
        return this.mValueStr;
    }
}
