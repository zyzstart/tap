package com.tencent.msdk.dns.base.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
abstract class a implements com.tencent.msdk.dns.base.b.e {
    a() {
    }

    @Override // com.tencent.msdk.dns.base.b.e
    public boolean a(int i, java.lang.String str, java.util.Map map) {
        if (android.text.TextUtils.isEmpty(str) || map == null) {
            return false;
        }
        return b(i, str, map);
    }

    abstract boolean b(int i, java.lang.String str, java.util.Map map);
}
