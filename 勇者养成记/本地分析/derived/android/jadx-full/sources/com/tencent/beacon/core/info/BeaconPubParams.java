package com.tencent.beacon.core.info;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class BeaconPubParams {
    private static com.tencent.beacon.core.info.BeaconPubParams sParamsHolder;
    private java.lang.String all_ssid;
    private java.lang.String android_id;
    private java.lang.String app_first_install_time;
    private java.lang.String app_last_updated_time;
    private java.lang.String app_version;
    private java.lang.String beacon_id;
    private java.lang.String boundle_id;
    private java.lang.String brand;
    private java.lang.String cid;
    private java.lang.String dpi;
    private java.lang.String dt_imei2;
    private java.lang.String dt_meid;
    private java.lang.String dt_mf;
    private java.lang.String fingerprint;
    private java.lang.String gpu;
    private java.lang.String hardware_os;
    private java.lang.String host_app_version;
    private java.lang.String imei;
    private java.lang.String imsi;
    private java.lang.String is_rooted;
    private java.lang.String language;
    private java.lang.String mac;
    private java.lang.String model;
    private java.lang.String model_apn;
    private java.lang.String network_type;
    private java.lang.String os_version;
    private java.lang.String platform;
    private java.lang.String product_id;
    private java.lang.String qimei;
    private java.lang.String resolution;
    private java.lang.String sdk_id;
    private java.lang.String sdk_version;
    private java.lang.String wifi_mac;
    private java.lang.String wifi_ssid;

    private BeaconPubParams(java.lang.String str) {
        init(str);
    }

    public static synchronized com.tencent.beacon.core.info.BeaconPubParams getPubParams(java.lang.String str) {
        if (sParamsHolder == null) {
            synchronized (com.tencent.beacon.core.info.BeaconPubParams.class) {
                if (sParamsHolder == null) {
                    sParamsHolder = new com.tencent.beacon.core.info.BeaconPubParams(str);
                }
            }
        }
        sParamsHolder.refresh();
        return sParamsHolder;
    }

    private void init(java.lang.String str) {
        android.content.Context context = com.tencent.beacon.event.UserAction.mContext;
        com.tencent.beacon.core.info.g gVarB = com.tencent.beacon.core.info.g.b(context);
        com.tencent.beacon.core.info.e eVarD = com.tencent.beacon.core.info.e.d(context);
        com.tencent.beacon.core.info.c cVarA = com.tencent.beacon.core.info.c.a(context);
        this.app_version = gVarB.a(str);
        this.boundle_id = gVarB.b();
        this.host_app_version = com.tencent.beacon.core.info.a.a(context);
        this.sdk_id = gVarB.h();
        this.sdk_version = com.tencent.beacon.core.info.b.i();
        this.product_id = str;
        this.beacon_id = com.tencent.beacon.qimei.QimeiSDK.getInstance().getBeaconIdInfo(context);
        this.app_first_install_time = com.tencent.beacon.core.e.b.b(context);
        this.app_last_updated_time = eVarD.c(context);
        this.platform = java.lang.String.valueOf((int) gVarB.g());
        this.dt_mf = eVarD.k();
        this.os_version = eVarD.n();
        this.hardware_os = eVarD.f() + "_" + eVarD.e();
        this.brand = eVarD.d();
        this.model = gVarB.e();
        this.language = eVarD.j();
        this.resolution = eVarD.m(context);
        this.dpi = java.lang.String.valueOf(eVarD.n(context));
        this.gpu = "";
        this.is_rooted = eVarD.i() ? "1" : "0";
        this.fingerprint = eVarD.p();
        this.qimei = com.tencent.beacon.qimei.QimeiSDK.getInstance().getQimeiInternal(context);
        this.mac = eVarD.i(context);
        this.wifi_mac = eVarD.p(context);
        this.wifi_ssid = eVarD.q(context);
        this.all_ssid = eVarD.a(context);
        this.cid = cVarA.b();
    }

    private void refresh() {
        android.content.Context context = com.tencent.beacon.event.UserAction.mContext;
        com.tencent.beacon.core.info.e eVarD = com.tencent.beacon.core.info.e.d(context);
        com.tencent.beacon.core.info.c cVarA = com.tencent.beacon.core.info.c.a(context);
        this.network_type = eVarD.k(context);
        this.model_apn = com.tencent.beacon.core.e.e.b(context);
        if (android.text.TextUtils.isEmpty(this.imei)) {
            this.imei = cVarA.c();
        }
        if (android.text.TextUtils.isEmpty(this.dt_imei2)) {
            this.dt_imei2 = eVarD.g(context);
        }
        if (android.text.TextUtils.isEmpty(this.dt_meid)) {
            this.dt_meid = eVarD.j(context);
        }
        if (android.text.TextUtils.isEmpty(this.imsi)) {
            this.imsi = eVarD.h(context);
        }
        if (android.text.TextUtils.isEmpty(this.android_id)) {
            this.android_id = eVarD.b(context);
        }
    }

    public java.lang.String getAll_ssid() {
        return this.all_ssid;
    }

    public java.lang.String getAndroid_id() {
        return this.android_id;
    }

    public java.lang.String getApp_first_install_time() {
        return this.app_first_install_time;
    }

    public java.lang.String getApp_last_updated_time() {
        return this.app_last_updated_time;
    }

    public java.lang.String getApp_version() {
        return this.app_version;
    }

    public java.lang.String getBeacon_id() {
        return this.beacon_id;
    }

    public java.lang.String getBoundle_id() {
        return this.boundle_id;
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

    public java.lang.String getDt_imei2() {
        return this.dt_imei2;
    }

    public java.lang.String getDt_meid() {
        return this.dt_meid;
    }

    public java.lang.String getDt_mf() {
        return this.dt_mf;
    }

    public java.lang.String getFingerprint() {
        return this.fingerprint;
    }

    public java.lang.String getHardware_os() {
        return this.hardware_os;
    }

    public java.lang.String getHost_app_version() {
        return this.host_app_version;
    }

    public java.lang.String getImei() {
        return this.imei;
    }

    public java.lang.String getImsi() {
        return this.imsi;
    }

    public java.lang.String getIs_rooted() {
        return this.is_rooted;
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

    public java.lang.String getModel_apn() {
        return this.model_apn;
    }

    public java.lang.String getNetwork_type() {
        return this.network_type;
    }

    public java.lang.String getOs_version() {
        return this.os_version;
    }

    public java.lang.String getPlatform() {
        return this.platform;
    }

    public java.lang.String getProduct_id() {
        return this.product_id;
    }

    public java.lang.String getQimei() {
        return this.qimei;
    }

    public java.lang.String getResolution() {
        return this.resolution;
    }

    public java.lang.String getSdk_id() {
        return this.sdk_id;
    }

    public java.lang.String getSdk_version() {
        return this.sdk_version;
    }

    public java.lang.String getWifi_mac() {
        return this.wifi_mac;
    }

    public java.lang.String getWifi_ssid() {
        return this.wifi_ssid;
    }

    public java.lang.String toString() {
        return super.toString();
    }
}
