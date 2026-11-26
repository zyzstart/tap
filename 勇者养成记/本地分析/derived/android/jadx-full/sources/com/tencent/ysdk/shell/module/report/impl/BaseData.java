package com.tencent.ysdk.shell.module.report.impl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class BaseData implements java.io.Serializable {
    private static final long serialVersionUID = 10000;
    public final java.util.HashMap<java.lang.String, java.lang.String> attrs = new java.util.HashMap<>();

    public BaseData(android.os.Bundle bundle) {
        if (bundle != null) {
            for (java.lang.String str : bundle.keySet()) {
                this.attrs.put(str, bundle.getString(str));
            }
        }
    }
}
