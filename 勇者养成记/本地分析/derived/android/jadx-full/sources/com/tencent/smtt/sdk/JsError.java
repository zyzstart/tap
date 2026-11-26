package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class JsError {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.tencent.smtt.export.external.jscore.interfaces.IX5JsError f811a;

    protected JsError(com.tencent.smtt.export.external.jscore.interfaces.IX5JsError iX5JsError) {
        this.f811a = iX5JsError;
    }

    public java.lang.String getMessage() {
        return this.f811a.getMessage();
    }

    public java.lang.String getStack() {
        return this.f811a.getStack();
    }
}
