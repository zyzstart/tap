package com.dodjoy.platform;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ThirdStatisticsTD implements com.dodjoy.platform.ThirdStatisticsImpl {
    private static java.lang.String mAccountID;
    private static com.tendcloud.tenddata.TDGAAccount tdgaAccount;
    private java.lang.String TAG = getClass().getSimpleName();

    public com.tendcloud.tenddata.TDGAAccount getTDGAAccount() {
        if (tdgaAccount == null) {
            tdgaAccount = com.tendcloud.tenddata.TDGAAccount.setAccount(mAccountID);
        }
        return tdgaAccount;
    }

    @Override // com.dodjoy.platform.ThirdStatisticsImpl
    public void init(android.app.Activity activity, java.lang.String str, java.lang.String str2) {
        com.dodjoy.utils.DodLog.i(this.TAG, "init");
        com.tendcloud.tenddata.TalkingDataGA.init(activity, str, str2);
    }

    @Override // com.dodjoy.platform.ThirdStatisticsImpl
    public void onBegin(java.lang.String str) {
        com.dodjoy.utils.DodLog.i(this.TAG, "onBegin");
        if (tdgaAccount == null) {
            getTDGAAccount();
        }
        com.tendcloud.tenddata.TDGAMission.onBegin(str);
    }

    @Override // com.dodjoy.platform.ThirdStatisticsImpl
    public void onChargeRequest(java.lang.String str, java.lang.String str2, double d, java.lang.String str3, double d2, java.lang.String str4) {
        com.dodjoy.utils.DodLog.i(this.TAG, "onChargeRequest");
        if (tdgaAccount == null) {
            getTDGAAccount();
        }
        com.tendcloud.tenddata.TDGAVirtualCurrency.onChargeRequest(str, str2, d, str3, d2, str4);
    }

    @Override // com.dodjoy.platform.ThirdStatisticsImpl
    public void onChargeSuccess(java.lang.String str) {
        com.dodjoy.utils.DodLog.i(this.TAG, "onChargeSuccess orderID:" + str);
        if (tdgaAccount == null) {
            getTDGAAccount();
        }
        com.tendcloud.tenddata.TDGAVirtualCurrency.onChargeSuccess(str);
    }

    @Override // com.dodjoy.platform.ThirdStatisticsImpl
    public void onCompleted(java.lang.String str) {
        com.dodjoy.utils.DodLog.i(this.TAG, "onCompleted");
        if (tdgaAccount == null) {
            getTDGAAccount();
        }
        com.tendcloud.tenddata.TDGAMission.onCompleted(str);
    }

    @Override // com.dodjoy.platform.ThirdStatisticsImpl
    public void onEvent(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map) {
        com.dodjoy.utils.DodLog.i(this.TAG, "onEvent");
        if (tdgaAccount == null) {
            getTDGAAccount();
        }
        com.tendcloud.tenddata.TalkingDataGA.onEvent(str, map);
    }

    @Override // com.dodjoy.platform.ThirdStatisticsImpl
    public void onFailed(java.lang.String str, java.lang.String str2) {
        com.dodjoy.utils.DodLog.i(this.TAG, "onFailed");
        if (tdgaAccount == null) {
            getTDGAAccount();
        }
        com.tendcloud.tenddata.TDGAMission.onFailed(str, str2);
    }

    @Override // com.dodjoy.platform.ThirdStatisticsImpl
    public void onPause(android.app.Activity activity) {
        com.dodjoy.utils.DodLog.i(this.TAG, "onPause");
        com.tendcloud.tenddata.TalkingDataGA.onPause(activity);
    }

    @Override // com.dodjoy.platform.ThirdStatisticsImpl
    public void onPurchase(java.lang.String str, int i, double d) {
        com.dodjoy.utils.DodLog.i(this.TAG, "onPurchase");
        if (tdgaAccount == null) {
            getTDGAAccount();
        }
        com.tendcloud.tenddata.TDGAItem.onPurchase(str, i, d);
    }

    @Override // com.dodjoy.platform.ThirdStatisticsImpl
    public void onResume(android.app.Activity activity) {
        com.dodjoy.utils.DodLog.i(this.TAG, "onResume");
        com.tendcloud.tenddata.TalkingDataGA.onResume(activity);
    }

    @Override // com.dodjoy.platform.ThirdStatisticsImpl
    public void onReward(double d, java.lang.String str) {
        com.dodjoy.utils.DodLog.i(this.TAG, "onReward");
        if (tdgaAccount == null) {
            getTDGAAccount();
        }
        com.tendcloud.tenddata.TDGAVirtualCurrency.onReward(d, str);
    }

    @Override // com.dodjoy.platform.ThirdStatisticsImpl
    public void onUse(java.lang.String str, int i) {
        com.dodjoy.utils.DodLog.i(this.TAG, "onUse");
        if (tdgaAccount == null) {
            getTDGAAccount();
        }
        com.tendcloud.tenddata.TDGAItem.onUse(str, i);
    }

    @Override // com.dodjoy.platform.ThirdStatisticsImpl
    public void setAccount(java.lang.String str) {
        com.dodjoy.utils.DodLog.i(this.TAG, "setAccount " + str);
        mAccountID = str;
        getTDGAAccount();
    }

    @Override // com.dodjoy.platform.ThirdStatisticsImpl
    public void setAccountName(java.lang.String str) {
        com.dodjoy.utils.DodLog.i(this.TAG, "setAccountName");
        try {
            getTDGAAccount().setAccountName(str);
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // com.dodjoy.platform.ThirdStatisticsImpl
    public void setAccountType(int i) {
        com.tendcloud.tenddata.TDGAAccount.AccountType accountType;
        com.dodjoy.utils.DodLog.i(this.TAG, "setAccountType");
        switch (i) {
            case 0:
                accountType = com.tendcloud.tenddata.TDGAAccount.AccountType.REGISTERED;
                break;
            case 1:
                accountType = com.tendcloud.tenddata.TDGAAccount.AccountType.ANONYMOUS;
                break;
            case 2:
                accountType = com.tendcloud.tenddata.TDGAAccount.AccountType.ND91;
                break;
            case 3:
                accountType = com.tendcloud.tenddata.TDGAAccount.AccountType.QQ;
                break;
            case 4:
                accountType = com.tendcloud.tenddata.TDGAAccount.AccountType.QQ_WEIBO;
                break;
            case 5:
                accountType = com.tendcloud.tenddata.TDGAAccount.AccountType.SINA_WEIBO;
                break;
            case 6:
                accountType = com.tendcloud.tenddata.TDGAAccount.AccountType.TYPE1;
                break;
            case 7:
                accountType = com.tendcloud.tenddata.TDGAAccount.AccountType.TYPE2;
                break;
            case 8:
                accountType = com.tendcloud.tenddata.TDGAAccount.AccountType.TYPE3;
                break;
            case 9:
                accountType = com.tendcloud.tenddata.TDGAAccount.AccountType.TYPE4;
                break;
            case 10:
                accountType = com.tendcloud.tenddata.TDGAAccount.AccountType.TYPE5;
                break;
            case 11:
                accountType = com.tendcloud.tenddata.TDGAAccount.AccountType.TYPE6;
                break;
            case 12:
                accountType = com.tendcloud.tenddata.TDGAAccount.AccountType.TYPE7;
                break;
            case 13:
                accountType = com.tendcloud.tenddata.TDGAAccount.AccountType.TYPE8;
                break;
            case 14:
                accountType = com.tendcloud.tenddata.TDGAAccount.AccountType.TYPE9;
                break;
            case 15:
                accountType = com.tendcloud.tenddata.TDGAAccount.AccountType.TYPE10;
                break;
            default:
                accountType = com.tendcloud.tenddata.TDGAAccount.AccountType.TYPE10;
                break;
        }
        try {
            getTDGAAccount().setAccountType(accountType);
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // com.dodjoy.platform.ThirdStatisticsImpl
    public void setAge(int i) {
        com.dodjoy.utils.DodLog.i(this.TAG, "setAge");
        try {
            getTDGAAccount().setAge(i);
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // com.dodjoy.platform.ThirdStatisticsImpl
    public void setCreateAccount() {
        getTDGAAccount();
    }

    @Override // com.dodjoy.platform.ThirdStatisticsImpl
    public void setGameServer(java.lang.String str) {
        com.dodjoy.utils.DodLog.i(this.TAG, "setGameServer");
        try {
            getTDGAAccount().setGameServer(str);
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // com.dodjoy.platform.ThirdStatisticsImpl
    public void setGender(int i) {
        com.tendcloud.tenddata.TDGAAccount.Gender gender;
        com.dodjoy.utils.DodLog.i(this.TAG, "setGender");
        switch (i) {
            case 0:
                gender = com.tendcloud.tenddata.TDGAAccount.Gender.UNKNOW;
                break;
            case 1:
                gender = com.tendcloud.tenddata.TDGAAccount.Gender.MALE;
                break;
            case 2:
                gender = com.tendcloud.tenddata.TDGAAccount.Gender.FEMALE;
                break;
            default:
                gender = com.tendcloud.tenddata.TDGAAccount.Gender.UNKNOW;
                break;
        }
        try {
            getTDGAAccount().setGender(gender);
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // com.dodjoy.platform.ThirdStatisticsImpl
    public void setLevel(int i) {
        com.dodjoy.utils.DodLog.i(this.TAG, "setLevel");
        try {
            getTDGAAccount().setLevel(i);
        } catch (java.lang.Exception unused) {
        }
    }
}
