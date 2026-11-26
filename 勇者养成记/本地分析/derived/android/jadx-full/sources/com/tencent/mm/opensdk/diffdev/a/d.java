package com.tencent.mm.opensdk.diffdev.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class d extends android.os.AsyncTask {
    private static final java.lang.String h = android.os.Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MicroMsg/oauth_qrcode.png";
    private static java.lang.String i;
    private java.lang.String appId;
    private java.lang.String j;
    private java.lang.String k;
    private com.tencent.mm.opensdk.diffdev.OAuthListener l;
    private com.tencent.mm.opensdk.diffdev.a.f m;
    private java.lang.String scope;
    private java.lang.String signature;

    static class a {
        public com.tencent.mm.opensdk.diffdev.OAuthErrCode n;
        public java.lang.String o;
        public java.lang.String p;
        public java.lang.String q;
        public int r;
        public java.lang.String s;
        public byte[] t;

        private a() {
        }

        public static com.tencent.mm.opensdk.diffdev.a.d.a a(byte[] bArr) {
            com.tencent.mm.opensdk.diffdev.OAuthErrCode oAuthErrCode;
            java.lang.Object[] objArr;
            java.lang.String str;
            com.tencent.mm.opensdk.diffdev.a.d.a aVar = new com.tencent.mm.opensdk.diffdev.a.d.a();
            if (bArr == null || bArr.length == 0) {
                com.tencent.mm.opensdk.utils.Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, buf is null");
                oAuthErrCode = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_NetworkErr;
            } else {
                try {
                    try {
                        org.json.JSONObject jSONObject = new org.json.JSONObject(new java.lang.String(bArr, com.unisound.b.f.b));
                        int i = jSONObject.getInt(com.tencent.ysdk.shell.framework.request.HttpResponse.HTTP_RESP_PARAM_CODE);
                        if (i != 0) {
                            com.tencent.mm.opensdk.utils.Log.e("MicroMsg.SDK.GetQRCodeResult", java.lang.String.format("resp errcode = %d", java.lang.Integer.valueOf(i)));
                            aVar.n = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_NormalErr;
                            aVar.r = i;
                            aVar.s = jSONObject.optString("errmsg");
                            return aVar;
                        }
                        java.lang.String string = jSONObject.getJSONObject("qrcode").getString("qrcodebase64");
                        if (string != null && string.length() != 0) {
                            byte[] bArrDecode = android.util.Base64.decode(string, 0);
                            if (bArrDecode != null && bArrDecode.length != 0) {
                                aVar.n = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_OK;
                                aVar.t = bArrDecode;
                                aVar.o = jSONObject.getString(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_USER_PARAM_UUID);
                                java.lang.String string2 = jSONObject.getString("appname");
                                aVar.p = string2;
                                com.tencent.mm.opensdk.utils.Log.d("MicroMsg.SDK.GetQRCodeResult", java.lang.String.format("parse succ, save in memory, uuid = %s, appname = %s, imgBufLength = %d", aVar.o, string2, java.lang.Integer.valueOf(aVar.t.length)));
                                return aVar;
                            }
                            com.tencent.mm.opensdk.utils.Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBuf is null");
                            aVar.n = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                            return aVar;
                        }
                        com.tencent.mm.opensdk.utils.Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBase64 is null");
                        aVar.n = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                        return aVar;
                    } catch (java.lang.Exception e) {
                        objArr = new java.lang.Object[]{e.getMessage()};
                        str = "parse json fail, ex = %s";
                        com.tencent.mm.opensdk.utils.Log.e("MicroMsg.SDK.GetQRCodeResult", java.lang.String.format(str, objArr));
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

    static {
        i = null;
        i = "https://open.weixin.qq.com/connect/sdk/qrconnect?[REDACTED]";
    }

    public d(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, com.tencent.mm.opensdk.diffdev.OAuthListener oAuthListener) {
        this.appId = str;
        this.scope = str2;
        this.j = str3;
        this.k = str4;
        this.signature = str5;
        this.l = oAuthListener;
    }

    public final boolean a() {
        com.tencent.mm.opensdk.utils.Log.i("MicroMsg.SDK.GetQRCodeTask", "cancelTask");
        com.tencent.mm.opensdk.diffdev.a.f fVar = this.m;
        return fVar == null ? cancel(true) : fVar.cancel(true);
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ java.lang.Object doInBackground(java.lang.Object[] objArr) {
        com.tencent.mm.opensdk.utils.Log.i("MicroMsg.SDK.GetQRCodeTask", "external storage available = false");
        java.lang.String str = java.lang.String.format(i, this.appId, this.j, this.k, this.scope, this.signature);
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        byte[] bArrA = com.tencent.mm.opensdk.diffdev.a.e.a(str);
        com.tencent.mm.opensdk.utils.Log.d("MicroMsg.SDK.GetQRCodeTask", java.lang.String.format("doInBackground, url = %s, time consumed = %d(ms)", str, java.lang.Long.valueOf(java.lang.System.currentTimeMillis() - jCurrentTimeMillis)));
        return com.tencent.mm.opensdk.diffdev.a.d.a.a(bArrA);
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(java.lang.Object obj) {
        com.tencent.mm.opensdk.diffdev.a.d.a aVar = (com.tencent.mm.opensdk.diffdev.a.d.a) obj;
        com.tencent.mm.opensdk.diffdev.OAuthErrCode oAuthErrCode = aVar.n;
        if (oAuthErrCode != com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_OK) {
            com.tencent.mm.opensdk.utils.Log.e("MicroMsg.SDK.GetQRCodeTask", java.lang.String.format("onPostExecute, get qrcode fail, OAuthErrCode = %s", oAuthErrCode));
            this.l.onAuthFinish(aVar.n, null);
            return;
        }
        com.tencent.mm.opensdk.utils.Log.d("MicroMsg.SDK.GetQRCodeTask", "onPostExecute, get qrcode success");
        this.l.onAuthGotQrcode(aVar.q, aVar.t);
        com.tencent.mm.opensdk.diffdev.a.f fVar = new com.tencent.mm.opensdk.diffdev.a.f(aVar.o, this.l);
        this.m = fVar;
        if (android.os.Build.VERSION.SDK_INT >= 11) {
            fVar.executeOnExecutor(android.os.AsyncTask.THREAD_POOL_EXECUTOR, new java.lang.Void[0]);
        } else {
            fVar.execute(new java.lang.Void[0]);
        }
    }
}
