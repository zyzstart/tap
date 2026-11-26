package com.tencent.ysdk.shell.module.share.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class GetSharePicRequest extends com.tencent.ysdk.shell.framework.request.HttpRequest {
    private static final java.lang.String BODY_BOUNDARY = "------WebKitFormBoundarytxaLyddD7upAabGx";
    private static final java.lang.String BOUNDARY = "----WebKitFormBoundarytxaLyddD7upAabGx";
    private static final java.lang.String HTTP_REQ_VALUE_CONTENT_TYPE = "application/x-www-form-urlencoded";
    private static final java.lang.String PARAM_APPID = "appid";
    private static final java.lang.String PARAM_FROM_SCREEN_CAPTURE = "isScreenCap";
    private static final java.lang.String PARAM_OPENID = "openid";
    private static final java.lang.String PARAM_ORIENTATION = "orientation";
    private static final java.lang.String PARAM_PKG_NAME = "pkgname";
    private static final java.lang.String PARAM_SHARE_TYPE = "shareType";
    private static final java.lang.String PATH = "https://ysdkwebs.qq.com/iconshare/share_info";
    private boolean isFromScreenCapture;
    private java.lang.String mAppid;
    private java.io.File mImage;
    private com.tencent.ysdk.framework.common.ePlatform mLoginPlatform;
    private java.lang.String mOpenId;
    private java.lang.String mPkgName;
    private com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.share.request.GetSharePicResponse> mResponseHandler;
    com.tencent.ysdk.module.share.impl.ShareRet.ShareType mSharetype;

    public GetSharePicRequest(java.io.File file, com.tencent.ysdk.module.share.impl.ShareRet.ShareType shareType, boolean z, com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.share.request.GetSharePicResponse> httpResponseHandler) {
        super(PATH);
        this.mImage = file;
        this.mSharetype = shareType;
        this.isFromScreenCapture = z;
        com.tencent.ysdk.module.user.UserLoginRet loginRecord = com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord();
        if (loginRecord != null) {
            this.mOpenId = loginRecord.open_id;
            this.mLoginPlatform = com.tencent.ysdk.framework.common.ePlatform.getEnum(loginRecord.platform);
        } else {
            this.mOpenId = "";
            this.mLoginPlatform = com.tencent.ysdk.framework.common.ePlatform.QQ;
        }
        this.mAppid = getAppid(this.mLoginPlatform);
        this.mPkgName = com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext().getPackageName());
        this.mResponseHandler = httpResponseHandler;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(buildParams("appid", this.mAppid));
        sb.append(buildParams(PARAM_PKG_NAME, this.mPkgName));
        sb.append(buildParams("openid", this.mOpenId));
        sb.append(buildParams("isScreenCap", z ? "1" : "0"));
        sb.append(buildParams(PARAM_SHARE_TYPE, this.mSharetype.name()));
        sb.append(buildParams("orientation", com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getGameScreenDir().name()));
        this.data = merge(sb.toString().getBytes(), buildFileParams(file));
    }

    private byte[] buildFileParams(java.io.File file) {
        return merge(merge(java.text.MessageFormat.format(BODY_BOUNDARY + com.tencent.midas.comm.log.util.APLogFileUtil.SEPARATOR_LINE + "Content-Disposition: form-data; name=\"image\"; filename=\"{0}\"" + com.tencent.midas.comm.log.util.APLogFileUtil.SEPARATOR_LINE + "Content-Type: image/png" + com.tencent.midas.comm.log.util.APLogFileUtil.SEPARATOR_LINE + com.tencent.midas.comm.log.util.APLogFileUtil.SEPARATOR_LINE, file.getName()).getBytes(), file2Byte(file)), (com.tencent.midas.comm.log.util.APLogFileUtil.SEPARATOR_LINE + BODY_BOUNDARY + "--" + com.tencent.midas.comm.log.util.APLogFileUtil.SEPARATOR_LINE).getBytes());
    }

    private java.lang.String buildParams(java.lang.String str, java.lang.String str2) {
        com.tencent.ysdk.shell.libware.file.Logger.d("GetSharePic", str + ": " + str2);
        return java.text.MessageFormat.format(BODY_BOUNDARY + com.tencent.midas.comm.log.util.APLogFileUtil.SEPARATOR_LINE + "Content-Disposition: form-data; name=\"{0}\"" + com.tencent.midas.comm.log.util.APLogFileUtil.SEPARATOR_LINE + com.tencent.midas.comm.log.util.APLogFileUtil.SEPARATOR_LINE + "{1}" + com.tencent.midas.comm.log.util.APLogFileUtil.SEPARATOR_LINE, str, str2);
    }

    private byte[] file2Byte(java.io.File file) {
        try {
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i == -1) {
                    fileInputStream.close();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (java.io.IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private java.lang.String getAppid(com.tencent.ysdk.framework.common.ePlatform eplatform) {
        if (com.tencent.ysdk.framework.common.ePlatform.QQ != eplatform && com.tencent.ysdk.framework.common.ePlatform.WX != eplatform) {
            eplatform = com.tencent.ysdk.framework.common.ePlatform.QQ;
        }
        return eplatform.val() == com.tencent.ysdk.framework.common.ePlatform.WX.val() ? com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getWXAppId() : com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getQQAppId();
    }

    private byte[] merge(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        java.lang.System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        java.lang.System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
    public java.lang.String getOriginHostName() {
        return "ysdkwebs.qq.com";
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
    protected java.lang.String getUrl() {
        return PATH;
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
    protected void onRequestFailure(int i, java.lang.String str) {
        com.tencent.ysdk.shell.module.share.request.GetSharePicResponse getSharePicResponse = new com.tencent.ysdk.shell.module.share.request.GetSharePicResponse();
        getSharePicResponse.parseFailureResponse(i, str);
        com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.share.request.GetSharePicResponse> httpResponseHandler = this.mResponseHandler;
        if (httpResponseHandler != null) {
            httpResponseHandler.onResponse(getSharePicResponse);
        }
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
    protected void onRequestSuccess(int i, com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        com.tencent.ysdk.shell.module.share.request.GetSharePicResponse getSharePicResponse = new com.tencent.ysdk.shell.module.share.request.GetSharePicResponse();
        getSharePicResponse.parseSuccessResponse(i, safeJSONObject);
        com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.share.request.GetSharePicResponse> httpResponseHandler = this.mResponseHandler;
        if (httpResponseHandler != null) {
            httpResponseHandler.onResponse(getSharePicResponse);
        }
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
    public void setURLConnectionCustomParam(java.net.HttpURLConnection httpURLConnection) {
        super.setURLConnectionCustomParam(httpURLConnection);
        httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=----WebKitFormBoundarytxaLyddD7upAabGx");
    }
}
