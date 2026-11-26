package com.dodjoy.privacy;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class DodPrivacyHelper {
    private static com.dodjoy.privacy.DodPrivacyHelper _instance;
    private com.dodjoy.privacy.IDodPrivacy mDodPrivacy;

    public static com.dodjoy.privacy.DodPrivacyHelper getInstance() {
        if (_instance == null) {
            _instance = new com.dodjoy.privacy.DodPrivacyHelper();
        }
        return _instance;
    }

    public void Init(android.app.Activity activity, com.dodjoy.privacy.DodPrivacyCallback dodPrivacyCallback) {
        this.mDodPrivacy = new com.dodjoy.privacy.impl.PrivacyImpl();
        com.dodjoy.privacy.IDodPrivacy iDodPrivacy = this.mDodPrivacy;
        if (iDodPrivacy != null) {
            iDodPrivacy.Init(activity, dodPrivacyCallback);
        }
    }
}
