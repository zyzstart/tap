package oicq.wlogin_sdk.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected oicq.wlogin_sdk.request.t f1685a;

    public java.lang.String a(int i) {
        return new java.lang.String[]{"log.wtlogin.qq.com", "log1.wtlogin.qq.com"}[java.lang.Math.abs(i % 2)];
    }

    protected byte[] a(byte[] bArr) {
        byte[] bArr2 = oicq.wlogin_sdk.tools.util.get_rand_16byte(oicq.wlogin_sdk.request.t.f1687a);
        byte[] bArrEncrypt = oicq.wlogin_sdk.tools.cryptor.encrypt(bArr, 0, bArr.length, bArr2);
        byte[] bArr3 = new byte[bArrEncrypt.length + bArr2.length];
        java.lang.System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        java.lang.System.arraycopy(bArrEncrypt, 0, bArr3, bArr2.length, bArrEncrypt.length);
        return bArr3;
    }

    public int b(byte[] bArr) {
        int i = 0;
        if (bArr != null && bArr.length != 0) {
            oicq.wlogin_sdk.tools.util.LOGI(getClass().getName() + ":snd_rcv_req_error ...", "" + this.f1685a.f);
            int iNextInt = new java.util.Random().nextInt();
            int i2 = 0;
            while (i2 < 2) {
                oicq.wlogin_sdk.tools.util.LOGI("try http connect " + i2 + " ...", "" + this.f1685a.f);
                try {
                    java.net.URL url = new java.net.URL("http://" + a(iNextInt) + "/cgi-bin/wlogin_proxy_log");
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("url=");
                    sb.append(url);
                    oicq.wlogin_sdk.tools.util.LOGI(sb.toString(), "" + this.f1685a.f);
                    java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod(com.tencent.connect.common.Constants.HTTP_POST);
                    httpURLConnection.setRequestProperty("Content-Type", "application/octet-stream");
                    httpURLConnection.setRequestProperty("Content-Disposition", "attachment; filename=micromsgresp.dat");
                    httpURLConnection.setRequestProperty("Content-Length", new java.lang.Integer(bArr.length).toString());
                    httpURLConnection.setConnectTimeout(this.f1685a.l);
                    httpURLConnection.setReadTimeout(this.f1685a.l);
                    httpURLConnection.setDoOutput(true);
                    oicq.wlogin_sdk.tools.util.LOGI("http request connect ...", "" + this.f1685a.f);
                    if (oicq.wlogin_sdk.request.j.a(httpURLConnection, this.f1685a.l)) {
                        oicq.wlogin_sdk.tools.util.LOGI("http request write ...", "" + this.f1685a.f);
                        java.io.OutputStream outputStream = httpURLConnection.getOutputStream();
                        outputStream.write(bArr, 0, bArr.length);
                        outputStream.flush();
                        int responseCode = httpURLConnection.getResponseCode();
                        oicq.wlogin_sdk.tools.util.LOGI("http request response code=" + responseCode, "" + this.f1685a.f);
                        if (200 == responseCode) {
                            break;
                        }
                    } else {
                        oicq.wlogin_sdk.tools.util.LOGI("http request connect failed", "" + this.f1685a.f);
                    }
                } catch (java.lang.Exception e) {
                    oicq.wlogin_sdk.tools.util.printException(e, "" + this.f1685a.f);
                }
                i2++;
                iNextInt++;
            }
            i = i2 >= 1 ? -1000 : 0;
            oicq.wlogin_sdk.tools.util.LOGI(getClass().getName() + ":snd_rcv_req_error ret=" + i, "" + this.f1685a.f);
        }
        return i;
    }
}
