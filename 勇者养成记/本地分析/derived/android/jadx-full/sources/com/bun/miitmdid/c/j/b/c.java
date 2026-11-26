package com.bun.miitmdid.c.j.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.Keep
public class c extends android.database.ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @android.support.annotation.Keep
    private java.lang.String f42a;

    @android.support.annotation.Keep
    private int b;

    @android.support.annotation.Keep
    private com.bun.miitmdid.c.j.b.b c;

    @android.support.annotation.Keep
    public c(com.bun.miitmdid.c.j.b.b bVar, int i, java.lang.String str) {
        super(null);
        this.c = bVar;
        this.b = i;
        this.f42a = str;
    }

    @Override // android.database.ContentObserver
    @android.support.annotation.Keep
    public native void onChange(boolean z);
}
