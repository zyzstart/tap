package com.tencent.ydkbeacon.base.net.adapter;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
/* synthetic */ class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f1220a;

    static {
        int[] iArr = new int[com.tencent.ydkbeacon.base.net.BodyType.values().length];
        f1220a = iArr;
        try {
            iArr[com.tencent.ydkbeacon.base.net.BodyType.FORM.ordinal()] = 1;
        } catch (java.lang.NoSuchFieldError unused) {
        }
        try {
            f1220a[com.tencent.ydkbeacon.base.net.BodyType.JSON.ordinal()] = 2;
        } catch (java.lang.NoSuchFieldError unused2) {
        }
        try {
            f1220a[com.tencent.ydkbeacon.base.net.BodyType.DATA.ordinal()] = 3;
        } catch (java.lang.NoSuchFieldError unused3) {
        }
    }
}
