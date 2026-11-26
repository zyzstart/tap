package com.tencent.beacon.core.network.volley;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.annotation.SuppressLint({"MissingPermission"})
public class AndroidAuthenticator implements com.tencent.beacon.core.network.volley.Authenticator {
    private final android.accounts.Account mAccount;
    private final android.accounts.AccountManager mAccountManager;
    private final java.lang.String mAuthTokenType;
    private final boolean mNotifyAuthFailure;

    AndroidAuthenticator(android.accounts.AccountManager accountManager, android.accounts.Account account, java.lang.String str, boolean z) {
        this.mAccountManager = accountManager;
        this.mAccount = account;
        this.mAuthTokenType = str;
        this.mNotifyAuthFailure = z;
    }

    public AndroidAuthenticator(android.content.Context context, android.accounts.Account account, java.lang.String str) {
        this(context, account, str, false);
    }

    public AndroidAuthenticator(android.content.Context context, android.accounts.Account account, java.lang.String str, boolean z) {
        this(android.accounts.AccountManager.get(context), account, str, z);
    }

    public android.accounts.Account getAccount() {
        return this.mAccount;
    }

    @Override // com.tencent.beacon.core.network.volley.Authenticator
    public java.lang.String getAuthToken() throws com.tencent.beacon.core.network.volley.AuthFailureError {
        android.accounts.AccountManagerFuture<android.os.Bundle> authToken = this.mAccountManager.getAuthToken(this.mAccount, this.mAuthTokenType, this.mNotifyAuthFailure, null, null);
        try {
            android.os.Bundle result = authToken.getResult();
            java.lang.String string = null;
            if (authToken.isDone() && !authToken.isCancelled()) {
                if (result.containsKey("intent")) {
                    throw new com.tencent.beacon.core.network.volley.AuthFailureError((android.content.Intent) result.getParcelable("intent"));
                }
                string = result.getString("[REDACTED]");
            }
            if (string != null) {
                return string;
            }
            throw new com.tencent.beacon.core.network.volley.AuthFailureError("[REDACTED]" + this.mAuthTokenType);
        } catch (java.lang.Exception e) {
            throw new com.tencent.beacon.core.network.volley.AuthFailureError("[REDACTED]", e);
        }
    }

    public java.lang.String getAuthTokenType() {
        return this.mAuthTokenType;
    }

    @Override // com.tencent.beacon.core.network.volley.Authenticator
    public void invalidateAuthToken(java.lang.String str) {
        this.mAccountManager.invalidateAuthToken(this.mAccount.type, str);
    }
}
