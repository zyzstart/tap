package com.pay.http;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APBaseHttpParam {
    public static final int CONNECT_TIMEOUT = 15000;
    public static final int READ_TIMEOUT = 15000;
    public static final int TRY_TIMES = 2;
    public java.lang.String domain;
    public java.lang.String url;
    public java.lang.String reqType = "http://";
    public java.lang.String sendType = com.tencent.connect.common.Constants.HTTP_GET;
    public java.lang.String defaultDomain = "";
    public java.lang.String port = "";
    public java.lang.String urlName = "";
    public java.lang.String urlParams = "";
    public int connectTimeout = 15000;
    public int readTimeout = 15000;
    public int requestTimes = 0;
    public int reTryTimes = 2;
    public long begTime = 0;
    public long endTime = 0;
    public java.util.HashMap reqParam = new java.util.HashMap();

    public APBaseHttpParam() {
        this.domain = "";
        this.domain = com.pay.tool.APMidasTools.getSysServerDomain();
    }

    public void constructParams() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("");
        java.util.HashMap map = this.reqParam;
        if (map != null) {
            for (java.util.Map.Entry entry : map.entrySet()) {
                sb.append((java.lang.String) entry.getKey());
                sb.append("=");
                sb.append((java.lang.String) entry.getValue());
                sb.append("&");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
                this.urlParams = sb.toString();
            }
        }
        com.tencent.midas.comm.APLog.i("APBaseHttpReq", "urlParams=" + this.urlParams);
    }

    public void constructReTryUrl() {
        if (this.requestTimes < this.reTryTimes) {
            this.domain = this.defaultDomain;
            this.url = this.reqType + com.pay.http.APToolNetwork.joinDomainPort(this.domain, this.port) + this.urlName;
            this.requestTimes = this.requestTimes + 1;
        }
    }

    public void constructUrl() {
        constructParams();
        if (this.sendType.equals(com.tencent.connect.common.Constants.HTTP_GET)) {
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            stringBuffer.append(this.url);
            if (!this.url.endsWith(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START)) {
                stringBuffer.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START);
            }
            stringBuffer.append(this.urlParams.toString());
            this.url = stringBuffer.toString();
        }
    }

    public void setReportUrl(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.String str4 = com.tencent.midas.api.APMidasPayAPI.env;
        if (str4.equals(com.tencent.midas.api.APMidasPayAPI.ENV_DEV)) {
            this.domain = com.pay.http.APPluginUrlConf.UNIPAY_DEV_DOMAIN;
            this.urlName = str;
        } else if (str4.equals(com.tencent.midas.api.APMidasPayAPI.ENV_TEST)) {
            this.domain = com.pay.http.APPluginUrlConf.UNIPAY_SANDBOX_DOMAIN;
            this.urlName = str2;
        } else if (str4.equals("release") || str4.equals(com.tencent.midas.api.APMidasPayAPI.ENV_TESTING)) {
            this.domain = com.pay.http.APPluginUrlConf.UNIPAY_RELEASE_REPORT_DOMAIN;
            this.urlName = str3;
        }
        this.reTryTimes = 1;
        this.defaultDomain = this.domain;
        if (str4.equals(com.tencent.midas.api.APMidasPayAPI.ENV_DEV) || str4.equals(com.tencent.midas.api.APMidasPayAPI.ENV_TEST) || str4.equals("release") || str4.equals(com.tencent.midas.api.APMidasPayAPI.ENV_TESTING)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(this.reqType);
            sb.append(com.pay.http.APToolNetwork.joinDomainPort(this.domain, this.port));
            sb.append(this.urlName);
            this.url = sb.toString();
        }
    }

    public void setReqWithHttp() {
        this.reqType = "http://";
    }

    public void setReqWithHttps() {
        this.reqType = "https://";
    }

    public void setSendWithGet() {
        this.sendType = com.tencent.connect.common.Constants.HTTP_GET;
    }

    public void setSendWithPost() {
        this.sendType = com.tencent.connect.common.Constants.HTTP_POST;
    }

    public void setUrl(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        java.lang.StringBuilder sb;
        java.lang.String str5 = com.tencent.midas.api.APMidasPayAPI.env;
        if (str5.equals(com.tencent.midas.api.APMidasPayAPI.ENV_DEV)) {
            this.urlName = str2;
            this.defaultDomain = com.pay.http.APPluginUrlConf.UNIPAY_DEV_DOMAIN;
            sb = new java.lang.StringBuilder();
            sb.append(this.reqType);
            sb.append(com.pay.http.APToolNetwork.joinDomainPort(this.domain, this.port));
            sb.append(str2);
        } else if (str5.equals(com.tencent.midas.api.APMidasPayAPI.ENV_TEST) || str5.equals(com.tencent.midas.api.APMidasPayAPI.ENV_TESTING)) {
            this.urlName = str3;
            this.defaultDomain = com.pay.http.APPluginUrlConf.UNIPAY_SANDBOX_DOMAIN;
            sb = new java.lang.StringBuilder();
            sb.append(this.reqType);
            sb.append(com.pay.http.APToolNetwork.joinDomainPort(this.domain, this.port));
            sb.append(str3);
        } else {
            if (!str5.equals("release")) {
                return;
            }
            this.urlName = str4;
            this.defaultDomain = "api.unipay.qq.com";
            sb = new java.lang.StringBuilder();
            sb.append(this.reqType);
            sb.append(com.pay.http.APToolNetwork.joinDomainPort(this.domain, this.port));
            sb.append(str4);
        }
        this.url = sb.toString();
    }

    public void setUrlNotMidas(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        java.lang.String str5 = com.tencent.midas.api.APMidasPayAPI.env;
        this.defaultDomain = "";
        if (str5.equals(com.tencent.midas.api.APMidasPayAPI.ENV_TESTING)) {
            this.urlName = str2;
            this.url = str2;
        } else if (str5.equals(com.tencent.midas.api.APMidasPayAPI.ENV_TEST)) {
            this.urlName = str3;
            this.url = str3;
        } else if (str5.equals("release")) {
            this.urlName = str4;
            this.url = str4;
        }
    }
}
