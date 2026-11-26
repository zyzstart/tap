package com.tencent.qqdownloader.pay.utils.kapalaiadapter.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class f implements com.tencent.qqdownloader.pay.utils.kapalaiadapter.a.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public java.lang.Object f794a = null;

    @Override // com.tencent.qqdownloader.pay.utils.kapalaiadapter.a.j
    public java.lang.String b(int i, android.content.Context context) {
        return ((android.telephony.TelephonyManager) context.getSystemService("phone")).getDeviceId();
    }
}
