package com.tencent.ydkbeacon.module;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public enum ModuleName {
    STRATEGY("com.tencent.ydkbeacon.module.StrategyModule"),
    EVENT("com.tencent.ydkbeacon.module.EventModule"),
    AUDIT("com.tencent.ydkbeacon.module.AuditModule"),
    STAT("com.tencent.ydkbeacon.module.StatModule"),
    QMSP("com.tencent.ydkbeacon.module.QmspModule");

    private java.lang.String className;

    ModuleName(java.lang.String str) {
        this.className = str;
    }

    public java.lang.String getClassName() {
        return this.className;
    }
}
