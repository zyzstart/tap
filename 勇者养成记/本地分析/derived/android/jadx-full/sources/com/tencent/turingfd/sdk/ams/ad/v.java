package com.tencent.turingfd.sdk.ams.ad;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class v implements java.lang.Runnable {
    public final /* synthetic */ java.util.Map La;
    public final /* synthetic */ android.content.Context za;

    public v(com.tencent.turingfd.sdk.ams.ad.w wVar, android.content.Context context, java.util.Map map) {
        this.za = context;
        this.La = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.content.SharedPreferences.Editor editorEdit = com.tencent.turingfd.sdk.ams.ad.w.i(this.za).edit();
        for (java.lang.String str : this.La.keySet()) {
            try {
                editorEdit.putString(str, com.tencent.turingfd.sdk.ams.ad.C0086b.a(com.tencent.turingfd.sdk.ams.ad.C0086b.b(((java.lang.String) this.La.get(str)).getBytes(), com.tencent.turingfd.sdk.ams.ad.C0086b.b())));
            } catch (java.lang.Throwable unused) {
            }
        }
        try {
            editorEdit.commit();
        } catch (java.lang.Throwable unused2) {
        }
    }
}
