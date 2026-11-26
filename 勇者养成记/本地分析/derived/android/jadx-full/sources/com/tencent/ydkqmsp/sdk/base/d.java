package com.tencent.ydkqmsp.sdk.base;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public enum d {
    UNSUPPORT(-1, "unsupport"),
    HUA_WEI(0, "HUAWEI"),
    XIAOMI(1, "Xiaomi"),
    VIVO(2, "vivo"),
    OPPO(3, "oppo"),
    MOTO(4, "motorola"),
    LENOVO(5, "lenovo"),
    ASUS(6, "asus"),
    SAMSUNG(7, "samsung"),
    MEIZU(8, "meizu"),
    ALPS(9, "alps"),
    NUBIA(10, "nubia"),
    ZTE(11, "ZTE"),
    ONEPLUS(12, "OnePlus"),
    BLACKSHARK(13, "blackshark"),
    FREEMEOS(14, "freemeos"),
    SSUIOS(15, "ssui");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.lang.String f1304a;

    d(int i, java.lang.String str) {
        this.f1304a = str;
    }

    public static com.tencent.ydkqmsp.sdk.base.d a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return UNSUPPORT;
        }
        for (com.tencent.ydkqmsp.sdk.base.d dVar : values()) {
            if (dVar.f1304a.equalsIgnoreCase(str)) {
                return dVar;
            }
        }
        return UNSUPPORT;
    }
}
