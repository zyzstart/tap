package com.tencent.tmassistantbase.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public enum a {
    UN_DETECT,
    WIFI,
    CMWAP,
    CMNET,
    UNIWAP,
    UNINET,
    WAP3G,
    NET3G,
    CTWAP,
    CTNET,
    UNKNOWN,
    UNKNOW_WAP,
    NO_NETWORK,
    WAP4G,
    NET4G;

    public byte b() {
        switch (com.tencent.tmassistantbase.b.b.f1008a[ordinal()]) {
            case 1:
                return (byte) 0;
            case 2:
                return (byte) 1;
            case 3:
                return (byte) 2;
            case 4:
                return (byte) 3;
            case 5:
                return (byte) 4;
            case 6:
                return (byte) 5;
            case 7:
                return (byte) 6;
            case 8:
                return (byte) 7;
            case 9:
                return (byte) 8;
            case 10:
                return (byte) 9;
            case 11:
            default:
                return (byte) 10;
            case 12:
                return (byte) 11;
            case 13:
                return (byte) 12;
            case 14:
                return (byte) 13;
            case 15:
                return (byte) 14;
        }
    }
}
