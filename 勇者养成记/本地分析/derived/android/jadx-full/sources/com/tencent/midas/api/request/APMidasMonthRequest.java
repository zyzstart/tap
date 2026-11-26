package com.tencent.midas.api.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APMidasMonthRequest extends com.tencent.midas.api.request.APMidasBaseRequest {
    public static final int SERVICETYPE_NORMAL = 1;
    public static final int SERVICETYPE_RENEW = 2;
    public static final int SERVICETYPE_UPGRADE = 3;
    private static final long serialVersionUID = -557287896140460926L;
    public int gameLogo = 0;
    public java.lang.String serviceCode = "";
    public java.lang.String serviceName = "";
    public boolean autoPay = false;
    public int serviceType = 1;

    public boolean getAutoPay() {
        return this.autoPay;
    }

    public int getGameLogo() {
        return this.gameLogo;
    }

    public java.lang.String getServiceCode() {
        return this.serviceCode;
    }

    public java.lang.String getServiceName() {
        return this.serviceName;
    }

    public int getServiceType() {
        return this.serviceType;
    }

    public void setAutoPay(boolean z) {
        this.autoPay = z;
    }

    public void setGameLogo(int i) {
        this.gameLogo = i;
    }

    public void setServiceCode(java.lang.String str) {
        this.serviceCode = str;
    }

    public void setServiceName(java.lang.String str) {
        this.serviceName = str;
    }

    public void setServiceType(int i) {
        this.serviceType = i;
    }
}
