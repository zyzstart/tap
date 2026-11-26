package com.pay.http;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class APHttpReqPost extends com.pay.http.APBaseHttpReq {
    public APHttpReqPost() {
        this.httpParam.setReqWithHttps();
        this.httpParam.setSendWithPost();
    }

    private void setPostMothod() {
        try {
            this.httpURLConnection.setRequestMethod(com.tencent.connect.common.Constants.HTTP_POST);
            this.httpURLConnection.setRequestProperty("Charset", "UTF-8");
            this.httpURLConnection.setDoInput(true);
            this.httpURLConnection.setDoOutput(true);
            this.httpURLConnection.setRequestProperty("Content-Length", java.lang.String.valueOf(this.httpParam.urlParams.getBytes().length));
            this.httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // com.pay.http.APBaseHttpReq
    protected void setBody() {
        super.setBody();
    }

    @Override // com.pay.http.APBaseHttpReq
    protected void setHeader() {
        setPostMothod();
    }
}
