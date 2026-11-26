package com.tencent.mm.opensdk.diffdev.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class f extends android.os.AsyncTask {
    private com.tencent.mm.opensdk.diffdev.OAuthListener l;
    private java.lang.String o;
    private int u;
    private java.lang.String url;

    static class a {
        public com.tencent.mm.opensdk.diffdev.OAuthErrCode n;
        public java.lang.String v;
        public int w;

        a() {
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0042 A[Catch: Exception -> 0x005d, TryCatch #0 {Exception -> 0x005d, blocks: (B:9:0x0015, B:11:0x0026, B:15:0x003f, B:17:0x0045, B:19:0x0055, B:21:0x005a, B:20:0x0058, B:16:0x0042, B:18:0x0052), top: B:31:0x0015 }] */
        /* JADX WARN: Code duplicated, block: B:18:0x0052 A[Catch: Exception -> 0x005d, TryCatch #0 {Exception -> 0x005d, blocks: (B:9:0x0015, B:11:0x0026, B:15:0x003f, B:17:0x0045, B:19:0x0055, B:21:0x005a, B:20:0x0058, B:16:0x0042, B:18:0x0052), top: B:31:0x0015 }] */
        public static com.tencent.mm.opensdk.diffdev.a.f.a b(byte[] bArr) {
            com.tencent.mm.opensdk.diffdev.OAuthErrCode oAuthErrCode;
            java.lang.Object[] objArr;
            java.lang.String str;
            com.tencent.mm.opensdk.diffdev.OAuthErrCode oAuthErrCode2;
            com.tencent.mm.opensdk.diffdev.a.f.a aVar = new com.tencent.mm.opensdk.diffdev.a.f.a();
            if (bArr == null || bArr.length == 0) {
                com.tencent.mm.opensdk.utils.Log.e("MicroMsg.SDK.NoopingResult", "parse fail, buf is null");
                oAuthErrCode = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_NetworkErr;
            } else {
                try {
                    try {
                        org.json.JSONObject jSONObject = new org.json.JSONObject(new java.lang.String(bArr, com.unisound.b.f.b));
                        int i = jSONObject.getInt("wx_errcode");
                        aVar.w = i;
                        com.tencent.mm.opensdk.utils.Log.d("MicroMsg.SDK.NoopingResult", java.lang.String.format("nooping uuidStatusCode = %d", java.lang.Integer.valueOf(i)));
                        int i2 = aVar.w;
                        if (i2 == 408) {
                            oAuthErrCode2 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_OK;
                            aVar.n = oAuthErrCode2;
                        } else if (i2 != 500) {
                            switch (i2) {
                                case 402:
                                    oAuthErrCode2 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_Timeout;
                                    aVar.n = oAuthErrCode2;
                                    break;
                                case com.tencent.smtt.sdk.TbsListener.ErrorCode.INFO_MISS_SDKEXTENSION_JAR /* 403 */:
                                    oAuthErrCode2 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_Cancel;
                                    aVar.n = oAuthErrCode2;
                                    break;
                                case 404:
                                    oAuthErrCode2 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_OK;
                                    aVar.n = oAuthErrCode2;
                                    break;
                                case com.tencent.smtt.sdk.TbsListener.ErrorCode.INFO_CAN_NOT_LOAD_TBS /* 405 */:
                                    aVar.n = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_OK;
                                    aVar.v = jSONObject.getString(com.tencent.ysdk.module.user.impl.wx.WXKey.USER_CODE);
                                    break;
                                default:
                                    oAuthErrCode2 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_NormalErr;
                                    aVar.n = oAuthErrCode2;
                                    break;
                            }
                        } else {
                            oAuthErrCode2 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_NormalErr;
                            aVar.n = oAuthErrCode2;
                        }
                        return aVar;
                    } catch (java.lang.Exception e) {
                        objArr = new java.lang.Object[]{e.getMessage()};
                        str = "parse json fail, ex = %s";
                        com.tencent.mm.opensdk.utils.Log.e("MicroMsg.SDK.NoopingResult", java.lang.String.format(str, objArr));
                        oAuthErrCode = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_NormalErr;
                        aVar.n = oAuthErrCode;
                        return aVar;
                    }
                } catch (java.lang.Exception e2) {
                    objArr = new java.lang.Object[]{e2.getMessage()};
                    str = "parse fail, build String fail, ex = %s";
                }
            }
            aVar.n = oAuthErrCode;
            return aVar;
        }
    }

    public f(java.lang.String str, com.tencent.mm.opensdk.diffdev.OAuthListener oAuthListener) {
        this.o = str;
        this.l = oAuthListener;
        this.url = java.lang.String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?[REDACTED]", str);
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ java.lang.Object doInBackground(java.lang.Object[] objArr) {
        com.tencent.mm.opensdk.diffdev.a.f.a aVar;
        com.tencent.mm.opensdk.diffdev.OAuthErrCode oAuthErrCode;
        java.lang.String str;
        java.lang.String str2 = this.o;
        if (str2 == null || str2.length() == 0) {
            com.tencent.mm.opensdk.utils.Log.e("MicroMsg.SDK.NoopingTask", "run fail, uuid is null");
            aVar = new com.tencent.mm.opensdk.diffdev.a.f.a();
            oAuthErrCode = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_NormalErr;
        } else {
            while (!isCancelled()) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(this.url);
                if (this.u == 0) {
                    str = "";
                } else {
                    str = "&last=" + this.u;
                }
                sb.append(str);
                java.lang.String string = sb.toString();
                long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                byte[] bArrA = com.tencent.mm.opensdk.diffdev.a.e.a(string);
                long jCurrentTimeMillis2 = java.lang.System.currentTimeMillis();
                com.tencent.mm.opensdk.diffdev.a.f.a aVarB = com.tencent.mm.opensdk.diffdev.a.f.a.b(bArrA);
                com.tencent.mm.opensdk.utils.Log.d("MicroMsg.SDK.NoopingTask", java.lang.String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", string, aVarB.n.toString(), java.lang.Integer.valueOf(aVarB.w), java.lang.Long.valueOf(jCurrentTimeMillis2 - jCurrentTimeMillis)));
                com.tencent.mm.opensdk.diffdev.OAuthErrCode oAuthErrCode2 = aVarB.n;
                if (oAuthErrCode2 != com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_OK) {
                    com.tencent.mm.opensdk.utils.Log.e("MicroMsg.SDK.NoopingTask", java.lang.String.format("nooping fail, errCode = %s, uuidStatusCode = %d", oAuthErrCode2.toString(), java.lang.Integer.valueOf(aVarB.w)));
                    return aVarB;
                }
                int i = aVarB.w;
                this.u = i;
                if (i == com.tencent.mm.opensdk.diffdev.a.g.UUID_SCANED.getCode()) {
                    this.l.onQrcodeScanned();
                } else if (aVarB.w != com.tencent.mm.opensdk.diffdev.a.g.UUID_KEEP_CONNECT.getCode() && aVarB.w == com.tencent.mm.opensdk.diffdev.a.g.UUID_CONFIRM.getCode()) {
                    java.lang.String str3 = aVarB.v;
                    if (str3 == null || str3.length() == 0) {
                        com.tencent.mm.opensdk.utils.Log.e("MicroMsg.SDK.NoopingTask", "nooping fail, confirm with an empty code!!!");
                        aVarB.n = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_NormalErr;
                    }
                    return aVarB;
                }
            }
            com.tencent.mm.opensdk.utils.Log.i("MicroMsg.SDK.NoopingTask", "IDiffDevOAuth.stopAuth / detach invoked");
            aVar = new com.tencent.mm.opensdk.diffdev.a.f.a();
            oAuthErrCode = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_Auth_Stopped;
        }
        aVar.n = oAuthErrCode;
        return aVar;
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(java.lang.Object obj) {
        com.tencent.mm.opensdk.diffdev.a.f.a aVar = (com.tencent.mm.opensdk.diffdev.a.f.a) obj;
        this.l.onAuthFinish(aVar.n, aVar.v);
    }
}
