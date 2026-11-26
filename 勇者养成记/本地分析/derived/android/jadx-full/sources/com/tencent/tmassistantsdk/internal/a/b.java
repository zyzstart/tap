package com.tencent.tmassistantsdk.internal.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final java.lang.String f1065a = "b";

    public synchronized long a(java.lang.String str, int i, java.lang.String str2, int i2, java.lang.String str3, long j, long j2, int i3, java.lang.String str4, byte[] bArr) {
        try {
            com.tencent.tmassistantbase.util.k.a().d(com.tencent.tmassistantbase.util.k.a().b());
            java.lang.String str5 = f1065a;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("hostPackageName = ");
            sb.append(str);
            sb.append(",hostVersion = ");
            sb.append(i);
            sb.append(",hostUserIdentity = ");
            sb.append(str2);
            sb.append(",dataItemType = ");
            sb.append(i2);
            sb.append(",dataItemAction = ");
            sb.append(str3);
            sb.append(",dataItemStartTime = ");
            sb.append(j);
            sb.append(",dataItemEndTime = ");
            sb.append(j2);
            sb.append(",dataItemVersion = ");
            sb.append(i3);
            sb.append(",IPCData length= ");
            sb.append(bArr == null ? "null" : java.lang.Integer.valueOf(bArr.length));
            com.tencent.tmassistantbase.util.TMLog.i(str5, sb.toString());
        } catch (java.lang.Exception e) {
            com.tencent.tmassistantbase.util.TMLog.e(f1065a, "getChannelDataItemList Exception", e);
            return -1L;
        }
        return new com.tencent.tmassistantsdk.internal.a.a().a(new com.tencent.tmassistantsdk.internal.a.c(str, i, str2, i2, str3, j, j2, i3, str4, bArr));
    }

    public synchronized java.util.ArrayList a() {
        java.util.ArrayList arrayListA;
        try {
            com.tencent.tmassistantbase.util.k.a().d(com.tencent.tmassistantbase.util.k.a().b());
            arrayListA = new com.tencent.tmassistantsdk.internal.a.a().a();
            java.lang.String str = f1065a;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("result size = ");
            sb.append(arrayListA == null ? "null" : java.lang.Integer.valueOf(arrayListA.size()));
            com.tencent.tmassistantbase.util.TMLog.i(str, sb.toString());
        } catch (java.lang.Exception e) {
            com.tencent.tmassistantbase.util.TMLog.e(f1065a, "getChannelDataItemList Exception", e);
            return null;
        }
        return arrayListA;
    }

    public synchronized boolean a(long j) {
        try {
            com.tencent.tmassistantbase.util.k.a().d(com.tencent.tmassistantbase.util.k.a().b());
            com.tencent.tmassistantbase.util.TMLog.i(f1065a, "dbIdentity = " + j);
            if (j < 0) {
                com.tencent.tmassistantbase.util.TMLog.i(f1065a, "dbIdentity < 0,return false");
                return false;
            }
            boolean zA = new com.tencent.tmassistantsdk.internal.a.a().a(j);
            com.tencent.tmassistantbase.util.TMLog.i(f1065a, "result = " + zA);
            return zA;
        } catch (java.lang.Exception e) {
            com.tencent.tmassistantbase.util.TMLog.e(f1065a, "getChannelDataItemList Exception", e);
            return false;
        }
    }
}
