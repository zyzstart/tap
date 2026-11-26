package com.tencent.ysdk.shell.framework.storage;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface ILightStorage {
    void clear();

    boolean contains(java.lang.String str);

    java.util.Map<java.lang.String, ?> readAll();

    java.lang.Boolean readBoolean(java.lang.String str, boolean z);

    java.lang.Float readFloat(java.lang.String str, java.lang.Float f);

    java.lang.Integer readInt(java.lang.String str, int i);

    java.lang.Long readLong(java.lang.String str, long j);

    java.lang.String readString(java.lang.String str, java.lang.String str2);

    boolean write(java.lang.String str, java.lang.Object obj);

    boolean writeAndCommit(java.lang.String str, java.lang.Object obj);

    <T> boolean writeMap(java.util.Map<java.lang.String, T> map);
}
