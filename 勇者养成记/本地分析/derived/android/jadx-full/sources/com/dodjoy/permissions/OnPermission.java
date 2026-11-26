package com.dodjoy.permissions;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface OnPermission {
    void hasPermission(java.util.List<java.lang.String> list, boolean z);

    void noPermission(java.util.List<java.lang.String> list, boolean z);
}
