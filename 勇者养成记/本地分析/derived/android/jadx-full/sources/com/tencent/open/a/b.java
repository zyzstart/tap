package com.tencent.open.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b implements java.io.Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final java.util.HashMap f687a = new java.util.HashMap();

    public b(android.os.Bundle bundle) {
        if (bundle != null) {
            for (java.lang.String str : bundle.keySet()) {
                this.f687a.put(str, bundle.getString(str));
            }
        }
    }
}
