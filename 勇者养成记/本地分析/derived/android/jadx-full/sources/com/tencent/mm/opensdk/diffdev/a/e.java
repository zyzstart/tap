package com.tencent.mm.opensdk.diffdev.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class e {
    public static byte[] a(java.lang.String str) {
        if (str == null || str.length() == 0) {
            com.tencent.mm.opensdk.utils.Log.e("MicroMsg.SDK.NetUtil", "httpGet, url is null");
            return null;
        }
        org.apache.http.impl.client.DefaultHttpClient defaultHttpClient = new org.apache.http.impl.client.DefaultHttpClient();
        org.apache.http.client.methods.HttpGet httpGet = new org.apache.http.client.methods.HttpGet(str);
        try {
            org.apache.http.params.HttpConnectionParams.setSoTimeout(defaultHttpClient.getParams(), com.youme.im.CommonConst.SPEECH_DURATION_MAX);
            org.apache.http.HttpResponse httpResponseExecute = defaultHttpClient.execute(httpGet);
            if (httpResponseExecute.getStatusLine().getStatusCode() == 200) {
                return org.apache.http.util.EntityUtils.toByteArray(httpResponseExecute.getEntity());
            }
            com.tencent.mm.opensdk.utils.Log.e("MicroMsg.SDK.NetUtil", "httpGet fail, status code = " + httpResponseExecute.getStatusLine().getStatusCode());
            return null;
        } catch (java.lang.Exception e) {
            com.tencent.mm.opensdk.utils.Log.e("MicroMsg.SDK.NetUtil", "httpGet, Exception ex = " + e.getMessage());
            return null;
        } catch (java.lang.IncompatibleClassChangeError e2) {
            com.tencent.mm.opensdk.utils.Log.e("MicroMsg.SDK.NetUtil", "httpGet, IncompatibleClassChangeError ex = " + e2.getMessage());
            return null;
        } catch (java.lang.Throwable th) {
            com.tencent.mm.opensdk.utils.Log.e("MicroMsg.SDK.NetUtil", "httpGet, Throwable ex = " + th.getMessage());
            return null;
        }
    }
}
