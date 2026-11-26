package com.tencent.beacon.core.network.volley;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class AuthFailureError extends com.tencent.beacon.core.network.volley.VolleyError {
    private android.content.Intent mResolutionIntent;

    public AuthFailureError() {
    }

    public AuthFailureError(android.content.Intent intent) {
        this.mResolutionIntent = intent;
    }

    public AuthFailureError(com.tencent.beacon.core.network.volley.NetworkResponse networkResponse) {
        super(networkResponse);
    }

    public AuthFailureError(java.lang.String str) {
        super(str);
    }

    public AuthFailureError(java.lang.String str, java.lang.Exception exc) {
        super(str, exc);
    }

    @Override // java.lang.Throwable
    public java.lang.String getMessage() {
        return this.mResolutionIntent != null ? "[REDACTED]" : super.getMessage();
    }

    public android.content.Intent getResolutionIntent() {
        return this.mResolutionIntent;
    }
}
