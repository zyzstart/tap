package com.tencent.ydkbeacon.core.info;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class BeaconPubParams {
    private static com.tencent.ydkbeacon.core.info.BeaconPubParams sParamsHolder;
    private java.lang.String allSsid;
    private java.lang.String androidId;
    private java.lang.String appFirstInstallTime;
    private java.lang.String appLastUpdatedTime;
    private java.lang.String appVersion;
    private java.lang.String beaconId;
    private java.lang.String boundleId;
    private java.lang.String brand;
    private java.lang.String cid;
    private android.content.Context context;
    private java.lang.String dpi;
    private java.lang.String dtImei2;
    private java.lang.String dtMeid;
    private java.lang.String dtMf;
    private java.lang.String fingerprint;
    private java.lang.String gpu;
    private java.lang.String hardwareOs;
    private java.lang.String imei;
    private java.lang.String imsi;
    private java.lang.String isRooted;
    private java.lang.String language;
    private java.lang.String mac;
    private java.lang.String model;
    private java.lang.String modelApn;
    private java.lang.String networkType;
    private java.lang.String osVersion;
    private java.lang.String platform;
    private java.lang.String productId;
    private java.lang.String qimei;
    private java.lang.String resolution;
    private java.lang.String sdkId;
    private java.lang.String sdkVersion;
    private java.lang.String wifiMac;
    private java.lang.String wifiSsid;

    private BeaconPubParams(android.content.Context context) {
        this.context = context;
        init(context);
    }

    public static synchronized com.tencent.ydkbeacon.core.info.BeaconPubParams getPubParams(android.content.Context context) {
        if (sParamsHolder == null) {
            synchronized (com.tencent.ydkbeacon.core.info.BeaconPubParams.class) {
                if (sParamsHolder == null) {
                    sParamsHolder = new com.tencent.ydkbeacon.core.info.BeaconPubParams(context);
                }
            }
        }
        sParamsHolder.refresh();
        return sParamsHolder;
    }

    private void init(android.content.Context context) {
        if (context != context.getApplicationContext()) {
            context = context.getApplicationContext();
        }
        com.tencent.ydkbeacon.a.c.c cVarD = com.tencent.ydkbeacon.a.c.c.d();
        cVarD.a(context);
        com.tencent.ydkbeacon.a.c.f fVarP = com.tencent.ydkbeacon.a.c.f.p();
        this.appVersion = com.tencent.ydkbeacon.a.c.b.a();
        this.boundleId = com.tencent.ydkbeacon.a.c.b.b();
        this.sdkId = cVarD.h();
        this.sdkVersion = cVarD.i();
        this.productId = cVarD.f();
        this.beaconId = com.tencent.ydkbeacon.qimei.QimeiSDK.getInstance().getBeaconIdInfo();
        this.appFirstInstallTime = com.tencent.ydkbeacon.a.c.b.a(context);
        this.appLastUpdatedTime = fVarP.a(context);
        this.platform = java.lang.String.valueOf((int) cVarD.g());
        this.dtMf = fVarP.t();
        this.osVersion = fVarP.z();
        this.hardwareOs = fVarP.g() + "_" + fVarP.f();
        this.brand = android.os.Build.BRAND;
        this.model = android.os.Build.MODEL;
        this.language = fVarP.r();
        this.resolution = fVarP.B();
        this.dpi = java.lang.String.valueOf(fVarP.F());
        this.gpu = "";
        this.isRooted = fVarP.q() ? "1" : "0";
        this.fingerprint = fVarP.C();
        this.qimei = com.tencent.ydkbeacon.qimei.QimeiSDK.getInstance().getQimeiInternal();
        this.mac = fVarP.s();
        this.wifiMac = fVarP.J();
        this.wifiSsid = fVarP.K();
        this.allSsid = fVarP.d();
        this.cid = fVarP.v();
    }

    private void refresh() {
        com.tencent.ydkbeacon.a.c.f fVarP = com.tencent.ydkbeacon.a.c.f.p();
        this.networkType = fVarP.w();
        this.modelApn = com.tencent.ydkbeacon.base.net.c.d.c();
        if (android.text.TextUtils.isEmpty(this.imei)) {
            this.imei = fVarP.m();
        }
        if (android.text.TextUtils.isEmpty(this.dtImei2)) {
            this.dtImei2 = fVarP.n();
        }
        if (android.text.TextUtils.isEmpty(this.dtMeid)) {
            this.dtMeid = fVarP.u();
        }
        if (android.text.TextUtils.isEmpty(this.imsi)) {
            this.imsi = fVarP.o();
        }
        if (android.text.TextUtils.isEmpty(this.androidId)) {
            this.androidId = fVarP.e();
        }
    }

    public java.lang.String getAllSsid() {
        return this.allSsid;
    }

    public java.lang.String getAndroidId() {
        return this.androidId;
    }

    public java.lang.String getAppFirstInstallTime() {
        return this.appFirstInstallTime;
    }

    public java.lang.String getAppLastUpdatedTime() {
        return this.appLastUpdatedTime;
    }

    public java.lang.String getAppVersion() {
        return this.appVersion;
    }

    public java.lang.String getBeaconId() {
        return this.beaconId;
    }

    public java.lang.String getBoundleId() {
        return this.boundleId;
    }

    public java.lang.String getBrand() {
        return this.brand;
    }

    public java.lang.String getCid() {
        return this.cid;
    }

    public java.lang.String getDpi() {
        return this.dpi;
    }

    public java.lang.String getDtImei2() {
        return this.dtImei2;
    }

    public java.lang.String getDtMeid() {
        return this.dtMeid;
    }

    public java.lang.String getDtMf() {
        return this.dtMf;
    }

    public java.lang.String getFingerprint() {
        return this.fingerprint;
    }

    public java.lang.String getHardwareOs() {
        return this.hardwareOs;
    }

    public java.lang.String getImei() {
        return this.imei;
    }

    public java.lang.String getImsi() {
        return this.imsi;
    }

    public java.lang.String getIsRooted() {
        return this.isRooted;
    }

    public java.lang.String getLanguage() {
        return this.language;
    }

    public java.lang.String getMac() {
        return this.mac;
    }

    public java.lang.String getModel() {
        return this.model;
    }

    public java.lang.String getModelApn() {
        return this.modelApn;
    }

    public java.lang.String getNetworkType() {
        return this.networkType;
    }

    public java.lang.String getOsVersion() {
        return this.osVersion;
    }

    public java.lang.String getPlatform() {
        return this.platform;
    }

    public java.lang.String getProductId() {
        return this.productId;
    }

    public java.lang.String getQimei() {
        return this.qimei;
    }

    public java.lang.String getResolution() {
        return this.resolution;
    }

    public java.lang.String getSdkId() {
        return this.sdkId;
    }

    public java.lang.String getSdkVersion() {
        return this.sdkVersion;
    }

    public java.lang.String getWifiMac() {
        return this.wifiMac;
    }

    public java.lang.String getWifiSsid() {
        return this.wifiSsid;
    }

    public java.lang.String toString() {
        return super.toString();
    }
}
