package com.tencent.ydkqmsp.sdk.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f1286a = {52, 125, -96, 80};
    private static final byte[] b = {107, 124, -70, 66, 61};
    private static final byte[] c = {107, 67, -107, 117, 97};

    public static java.lang.String a() {
        return com.tencent.ydkqmsp.sdk.app.a.getContext().getDir(com.tencent.ydkqmsp.sdk.f.k.a(f1286a), 0).toString();
    }

    public static java.lang.String b() {
        return a() + java.io.File.separator + com.tencent.ydkqmsp.sdk.f.k.a(b);
    }

    public static java.lang.String c() {
        return a() + java.io.File.separator + com.tencent.ydkqmsp.sdk.f.k.a(c);
    }
}
