package com.tencent.tmselfupdatesdk.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class k extends java.lang.ThreadLocal {
    k() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.lang.ThreadLocal
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public java.text.SimpleDateFormat initialValue() {
        return new java.text.SimpleDateFormat("yyyyMMdd");
    }
}
