package com.tencent.open;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class SocialApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tencent.open.SocialApiIml f673a;

    public SocialApi(com.tencent.connect.auth.QQToken qQToken) {
        this.f673a = new com.tencent.open.SocialApiIml(qQToken);
    }

    public void ask(android.app.Activity activity, android.os.Bundle bundle, com.tencent.tauth.IUiListener iUiListener) {
        this.f673a.ask(activity, bundle, iUiListener);
    }

    public void gift(android.app.Activity activity, android.os.Bundle bundle, com.tencent.tauth.IUiListener iUiListener) {
        this.f673a.gift(activity, bundle, iUiListener);
    }

    public void invite(android.app.Activity activity, android.os.Bundle bundle, com.tencent.tauth.IUiListener iUiListener) {
        this.f673a.invite(activity, bundle, iUiListener);
    }

    public void story(android.app.Activity activity, android.os.Bundle bundle, com.tencent.tauth.IUiListener iUiListener) {
        this.f673a.story(activity, bundle, iUiListener);
    }
}
