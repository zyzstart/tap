package com.tencent.ysdk.shell.module.share.impl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ShareModule extends com.tencent.ysdk.shell.module.Module implements com.tencent.ysdk.shell.module.share.ShareInterface {
    public static final java.lang.String TAG = "YSDK_SHARE";
    public static final java.lang.String WX_SHARE_PREFIX = "WXShare";
    com.tencent.ysdk.module.share.impl.ShareRet lastStartedShareRet;
    private boolean mIsFromScreenCapture = false;
    private com.tencent.ysdk.shell.module.share.impl.ShareModule.QQShareCallBack mQQCallBack;
    private com.tencent.ysdk.module.share.ShareCallBack mShareCallBack;
    com.tencent.ysdk.module.share.ShareCallBack mShareCallBackWrapper;
    private com.tencent.ysdk.shell.module.share.impl.SharePanelView mSharePanelView;
    private com.tencent.tauth.Tencent mTencent;
    private com.tencent.mm.opensdk.openapi.IWXAPI mWXAPI;
    private com.tencent.ysdk.shell.module.share.impl.ShareManagerBBS managerBBS;
    private com.tencent.ysdk.shell.module.share.impl.ShareManagerQQ managerQQ;
    private com.tencent.ysdk.shell.module.share.impl.ShareManagerWX managerWX;
    private com.tencent.ysdk.shell.module.share.impl.ScreenCapture screenCapture;

    public class BBSShareCallBack {
        public BBSShareCallBack() {
        }

        public void onCancel() {
            com.tencent.ysdk.shell.module.share.impl.ShareModule.this.lastStartedShareRet.retCode = com.tencent.ysdk.module.share.impl.ShareRet.ERR_BBS_USER_CANCEL;
            com.tencent.ysdk.shell.module.share.impl.ShareModule.this.lastStartedShareRet.retMsg = "用户取消";
            if (com.tencent.ysdk.shell.module.share.impl.ShareModule.this.mShareCallBackWrapper != null) {
                com.tencent.ysdk.shell.module.share.impl.ShareModule.this.mShareCallBackWrapper.onCancel(com.tencent.ysdk.shell.module.share.impl.ShareModule.this.lastStartedShareRet);
            }
        }

        public void onFail(java.lang.String str, java.lang.String str2) {
            com.tencent.ysdk.shell.module.share.impl.ShareModule.this.lastStartedShareRet.retCode = com.tencent.ysdk.module.share.impl.ShareRet.ERR_BBS_ERR_COMM;
            com.tencent.ysdk.shell.module.share.impl.ShareModule.this.lastStartedShareRet.retMsg = "BBSErrMsg:" + str2 + " QQErrCode:" + str;
            if (com.tencent.ysdk.shell.module.share.impl.ShareModule.this.mShareCallBackWrapper != null) {
                com.tencent.ysdk.shell.module.share.impl.ShareModule.this.mShareCallBackWrapper.onError(com.tencent.ysdk.shell.module.share.impl.ShareModule.this.lastStartedShareRet);
            }
        }

        public void onSuccess() {
            com.tencent.ysdk.shell.module.share.impl.ShareModule.this.lastStartedShareRet.retCode = com.tencent.ysdk.module.share.impl.ShareRet.SUCCESS;
            com.tencent.ysdk.shell.module.share.impl.ShareModule.this.lastStartedShareRet.retMsg = "分享成功";
            if (com.tencent.ysdk.shell.module.share.impl.ShareModule.this.mShareCallBackWrapper != null) {
                com.tencent.ysdk.shell.module.share.impl.ShareModule.this.mShareCallBackWrapper.onSuccess(com.tencent.ysdk.shell.module.share.impl.ShareModule.this.lastStartedShareRet);
            }
        }
    }

    class QQShareCallBack implements com.tencent.tauth.IUiListener {
        QQShareCallBack() {
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.share.impl.ShareModule.TAG, "QQ分享回调Cancel");
            com.tencent.ysdk.shell.module.share.impl.ShareModule.this.lastStartedShareRet.retCode = com.tencent.ysdk.module.share.impl.ShareRet.ERR_QQ_ERR_USER_CANCEL;
            com.tencent.ysdk.shell.module.share.impl.ShareModule.this.lastStartedShareRet.retMsg = "用户取消";
            if (com.tencent.ysdk.shell.module.share.impl.ShareModule.this.mShareCallBackWrapper != null) {
                com.tencent.ysdk.shell.module.share.impl.ShareModule.this.mShareCallBackWrapper.onCancel(com.tencent.ysdk.shell.module.share.impl.ShareModule.this.lastStartedShareRet);
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(java.lang.Object obj) {
            com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.share.impl.ShareModule.TAG, "QQ分享回调OK ");
            if (com.tencent.ysdk.shell.module.share.impl.ShareModule.this.lastStartedShareRet != null) {
                com.tencent.ysdk.shell.module.share.impl.ShareModule.this.lastStartedShareRet.retCode = com.tencent.ysdk.module.share.impl.ShareRet.SUCCESS;
                com.tencent.ysdk.shell.module.share.impl.ShareModule.this.lastStartedShareRet.retMsg = "分享成功";
                if (com.tencent.ysdk.shell.module.share.impl.ShareModule.this.mShareCallBackWrapper != null) {
                    com.tencent.ysdk.shell.module.share.impl.ShareModule.this.mShareCallBackWrapper.onSuccess(com.tencent.ysdk.shell.module.share.impl.ShareModule.this.lastStartedShareRet);
                }
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(com.tencent.tauth.UiError uiError) {
            com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.share.impl.ShareModule.TAG, "QQ分享回调Err");
            com.tencent.ysdk.shell.module.share.impl.ShareModule.this.lastStartedShareRet.retCode = com.tencent.ysdk.module.share.impl.ShareRet.ERR_QQ_ERR_COMM;
            com.tencent.ysdk.shell.module.share.impl.ShareModule.this.lastStartedShareRet.retMsg = "QQErrMsg:" + uiError.errorMessage + "QQErrCode:" + uiError.errorCode + "QQErrCode:" + uiError.errorDetail;
            if (com.tencent.ysdk.shell.module.share.impl.ShareModule.this.mShareCallBackWrapper != null) {
                com.tencent.ysdk.shell.module.share.impl.ShareModule.this.mShareCallBackWrapper.onError(com.tencent.ysdk.shell.module.share.impl.ShareModule.this.lastStartedShareRet);
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onWarning(int i) {
            com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.share.impl.ShareModule.TAG, "QQLoginCallback onWarning " + i);
        }
    }

    public ShareModule() {
        this.name = com.tencent.ysdk.shell.module.ModuleManager.YSDK_MODULE_NAME_SHARE;
    }

    private java.io.File buildShareImageInner(android.graphics.Bitmap bitmap, java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
        com.tencent.ysdk.module.share.impl.ShareRet.ShareType shareType = this.lastStartedShareRet.shareType;
        if (shareType == com.tencent.ysdk.module.share.impl.ShareRet.ShareType.QQFriend || shareType == com.tencent.ysdk.module.share.impl.ShareRet.ShareType.QZone) {
            buildShareQQImage(bitmap, str, str2, shareType);
        } else {
            buildShareWxImage(bitmap, str, str2, shareType);
        }
        java.io.File fileSaveToSD = saveToSD(bitmap);
        apiReport(0, "0", "", "build Image");
        return fileSaveToSD;
    }

    private void buildShareQQImage(android.graphics.Bitmap bitmap, final java.lang.String str, final java.lang.String str2, final com.tencent.ysdk.module.share.impl.ShareRet.ShareType shareType) throws java.lang.Throwable {
        final java.io.File fileSaveToSD = saveToSD(bitmap);
        com.tencent.ysdk.shell.framework.request.YSDKServer.getInstance().doRequest(new com.tencent.ysdk.shell.module.share.request.GetSharePicRequest(fileSaveToSD, this.lastStartedShareRet.shareType, this.mIsFromScreenCapture, new com.tencent.ysdk.shell.framework.request.HttpResponseHandler() { // from class: com.tencent.ysdk.shell.module.share.impl.ShareModule.4
            @Override // com.tencent.ysdk.shell.framework.request.HttpResponseHandler
            public void onResponse(java.lang.Object obj) {
                com.tencent.ysdk.shell.libware.file.Logger.d(obj.toString());
                com.tencent.ysdk.shell.module.share.request.GetSharePicResponse getSharePicResponse = (com.tencent.ysdk.shell.module.share.request.GetSharePicResponse) obj;
                if (getSharePicResponse.ret == 0) {
                    com.tencent.ysdk.shell.module.share.impl.ShareModule.this.apiReport(0, "0", "", "request QQ success");
                    if (shareType == com.tencent.ysdk.module.share.impl.ShareRet.ShareType.QQFriend) {
                        com.tencent.ysdk.shell.module.share.impl.ShareModule.this.managerQQ.shareToFriend(getSharePicResponse.imgUrl, str, str2);
                    } else if (shareType == com.tencent.ysdk.module.share.impl.ShareRet.ShareType.QZone) {
                        com.tencent.ysdk.shell.module.share.impl.ShareModule.this.managerQQ.shareToQZone(getSharePicResponse.imgUrl, str, str2);
                    }
                    com.tencent.ysdk.shell.module.share.impl.ShareModule.this.apiReport(0, "0", "", "requestQQ");
                } else {
                    com.tencent.ysdk.shell.libware.file.Logger.w("share get bad response");
                    com.tencent.ysdk.shell.module.share.impl.ShareModule.this.apiReport(-1, java.lang.String.valueOf(getSharePicResponse.flag), getSharePicResponse.msg, "requestQQ");
                }
                fileSaveToSD.deleteOnExit();
                com.tencent.ysdk.shell.module.share.impl.ShareModule.this.mIsFromScreenCapture = false;
            }
        }));
    }

    private void buildShareQQUrl(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, com.tencent.ysdk.module.share.impl.ShareRet.ShareType shareType) {
        if (shareType == com.tencent.ysdk.module.share.impl.ShareRet.ShareType.QQFriendURL) {
            this.managerQQ.shareURLToFriend(str, str2, str3, str4);
        } else if (shareType == com.tencent.ysdk.module.share.impl.ShareRet.ShareType.QZoneURL) {
            this.managerQQ.shareURLToQZone(str, str2, str3, str4);
        }
    }

    private void buildShareURL(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        com.tencent.ysdk.module.share.impl.ShareRet.ShareType shareType = this.lastStartedShareRet.shareType;
        if (shareType == com.tencent.ysdk.module.share.impl.ShareRet.ShareType.QQFriendURL || shareType == com.tencent.ysdk.module.share.impl.ShareRet.ShareType.QZoneURL) {
            buildShareQQUrl(str, str2, str3, str4, shareType);
        } else if (shareType == com.tencent.ysdk.module.share.impl.ShareRet.ShareType.WXFriendURL || shareType == com.tencent.ysdk.module.share.impl.ShareRet.ShareType.WXTimeLineURL) {
            buildShareWxUrl(str, str2, str3, str4, shareType);
        }
    }

    private void buildShareWxImage(android.graphics.Bitmap bitmap, final java.lang.String str, final java.lang.String str2, final com.tencent.ysdk.module.share.impl.ShareRet.ShareType shareType) throws java.lang.Throwable {
        final java.io.File fileSaveToSD = saveToSD(bitmap);
        com.tencent.ysdk.shell.framework.request.YSDKServer.getInstance().doRequest(new com.tencent.ysdk.shell.module.share.request.GetSharePicRequest(fileSaveToSD, this.lastStartedShareRet.shareType, this.mIsFromScreenCapture, new com.tencent.ysdk.shell.framework.request.HttpResponseHandler() { // from class: com.tencent.ysdk.shell.module.share.impl.ShareModule.3
            @Override // com.tencent.ysdk.shell.framework.request.HttpResponseHandler
            public void onResponse(java.lang.Object obj) {
                com.tencent.ysdk.shell.libware.file.Logger.d(obj.toString());
                final com.tencent.ysdk.shell.module.share.request.GetSharePicResponse getSharePicResponse = (com.tencent.ysdk.shell.module.share.request.GetSharePicResponse) obj;
                if (getSharePicResponse.ret == 0) {
                    new android.os.AsyncTask() { // from class: com.tencent.ysdk.shell.module.share.impl.ShareModule.3.1
                        java.io.File imageFile;

                        @Override // android.os.AsyncTask
                        protected java.lang.Object doInBackground(java.lang.Object[] objArr) {
                            try {
                                this.imageFile = com.tencent.ysdk.shell.module.share.impl.ShareModule.this.saveToSD(getSharePicResponse.imgUrl);
                                com.tencent.ysdk.shell.module.share.impl.ShareModule.this.apiReport(0, "0", "", "requestWX_Download_Image");
                            } catch (java.io.IOException e) {
                                e.printStackTrace();
                                com.tencent.ysdk.shell.module.share.impl.ShareModule.this.apiReport(-1, "-1", "downloadImageError", "requestWX_Download_Image");
                            }
                            fileSaveToSD.deleteOnExit();
                            return null;
                        }

                        @Override // android.os.AsyncTask
                        protected void onPostExecute(java.lang.Object obj2) {
                            super.onPostExecute(obj2);
                            java.io.File file = this.imageFile;
                            if (file == null || !file.exists()) {
                                return;
                            }
                            if (shareType == com.tencent.ysdk.module.share.impl.ShareRet.ShareType.BBS) {
                                com.tencent.ysdk.shell.module.share.impl.ShareModule.this.managerBBS.shareToBBS(this.imageFile, str, str2, "http://qzs.qq.com/open/mobile/community/index.html");
                            } else if (shareType == com.tencent.ysdk.module.share.impl.ShareRet.ShareType.WXFriend) {
                                com.tencent.ysdk.shell.module.share.impl.ShareModule.this.managerWX.shareToFriend(this.imageFile, str, str2);
                            } else if (shareType == com.tencent.ysdk.module.share.impl.ShareRet.ShareType.WXTimeLine) {
                                com.tencent.ysdk.shell.module.share.impl.ShareModule.this.managerWX.shareToTimeLine(this.imageFile, str, str2);
                            }
                        }
                    }.execute(new java.lang.Object[0]);
                    com.tencent.ysdk.shell.module.share.impl.ShareModule.this.mIsFromScreenCapture = false;
                    com.tencent.ysdk.shell.module.share.impl.ShareModule.this.apiReport(0, "0", "", "requestWX");
                } else {
                    com.tencent.ysdk.shell.libware.file.Logger.w("share get bad response");
                    com.tencent.ysdk.shell.module.share.impl.ShareModule.this.apiReport(-1, java.lang.String.valueOf(getSharePicResponse.flag), getSharePicResponse.msg, "requestWX");
                }
                fileSaveToSD.deleteOnExit();
            }
        }));
    }

    private void buildShareWxUrl(final java.lang.String str, final java.lang.String str2, final java.lang.String str3, final java.lang.String str4, final com.tencent.ysdk.module.share.impl.ShareRet.ShareType shareType) {
        new android.os.AsyncTask() { // from class: com.tencent.ysdk.shell.module.share.impl.ShareModule.5
            byte[] thumbBitmapBytes;

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public java.io.File doInBackground(java.lang.Object[] objArr) {
                try {
                    this.thumbBitmapBytes = com.tencent.ysdk.shell.module.share.impl.ShareModule.this.urlToByteArray(str);
                    com.tencent.ysdk.shell.module.share.impl.ShareModule.this.apiReport(0, "0", "", "requestWX_Download_Image");
                    return null;
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                    com.tencent.ysdk.shell.module.share.impl.ShareModule.this.apiReport(-1, "-1", "downloadImageError", "requestWX_Download_Image");
                    return null;
                }
            }

            @Override // android.os.AsyncTask
            protected void onPostExecute(java.lang.Object obj) {
                super.onPostExecute(obj);
                if (this.thumbBitmapBytes != null) {
                    if (shareType == com.tencent.ysdk.module.share.impl.ShareRet.ShareType.WXFriendURL) {
                        com.tencent.ysdk.shell.module.share.impl.ShareModule.this.managerWX.shareURLToFriend(this.thumbBitmapBytes, str2, str3, str4);
                    } else if (shareType == com.tencent.ysdk.module.share.impl.ShareRet.ShareType.WXTimeLineURL) {
                        com.tencent.ysdk.shell.module.share.impl.ShareModule.this.managerWX.shareURLToWXTimeline(this.thumbBitmapBytes, str2, str3, str4);
                    }
                }
            }
        }.execute(new java.lang.Object[0]);
    }

    private java.lang.String checkExtInfo(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        java.lang.String strTrim = str.trim();
        if (strTrim.length() > 20) {
            strTrim = strTrim.substring(0, 19);
        }
        return strTrim.matches("\\w+") ? strTrim : "";
    }

    private void handleShareResultByErrorCode(int i) {
        if (this.mShareCallBackWrapper == null) {
        }
        switch (i) {
            case -5:
                this.lastStartedShareRet.retCode = com.tencent.ysdk.module.share.impl.ShareRet.ERR_WX_ERR_UNSUPPORT;
                com.tencent.ysdk.module.share.impl.ShareRet shareRet = this.lastStartedShareRet;
                shareRet.retMsg = "微信不支持";
                this.mShareCallBackWrapper.onError(shareRet);
                break;
            case -4:
                this.lastStartedShareRet.retCode = com.tencent.ysdk.module.share.impl.ShareRet.ERR_WX_ERR_AUTH_DENIED;
                com.tencent.ysdk.module.share.impl.ShareRet shareRet2 = this.lastStartedShareRet;
                shareRet2.retMsg = "认证失败";
                this.mShareCallBackWrapper.onError(shareRet2);
                break;
            case -3:
                this.lastStartedShareRet.retCode = com.tencent.ysdk.module.share.impl.ShareRet.ERR_WX_ERR_SENT_FAILED;
                com.tencent.ysdk.module.share.impl.ShareRet shareRet3 = this.lastStartedShareRet;
                shareRet3.retMsg = "发送失败";
                this.mShareCallBackWrapper.onError(shareRet3);
                break;
            case -2:
                this.lastStartedShareRet.retCode = com.tencent.ysdk.module.share.impl.ShareRet.ERR_WX_ERR_USER_CANCEL;
                com.tencent.ysdk.module.share.impl.ShareRet shareRet4 = this.lastStartedShareRet;
                shareRet4.retMsg = "用户取消";
                this.mShareCallBackWrapper.onCancel(shareRet4);
                break;
            case -1:
                this.lastStartedShareRet.retCode = com.tencent.ysdk.module.share.impl.ShareRet.ERR_WX_ERR_ERR_COMM;
                com.tencent.ysdk.module.share.impl.ShareRet shareRet5 = this.lastStartedShareRet;
                shareRet5.retMsg = "一般未知错误";
                this.mShareCallBackWrapper.onError(shareRet5);
                break;
            case 0:
                this.lastStartedShareRet.retCode = com.tencent.ysdk.module.share.impl.ShareRet.SUCCESS;
                com.tencent.ysdk.module.share.impl.ShareRet shareRet6 = this.lastStartedShareRet;
                shareRet6.retMsg = "分享成功";
                this.mShareCallBackWrapper.onSuccess(shareRet6);
                break;
            default:
                this.lastStartedShareRet.retCode = com.tencent.ysdk.module.share.impl.ShareRet.ERR_WX_ERR_UNKNOWN;
                com.tencent.ysdk.module.share.impl.ShareRet shareRet7 = this.lastStartedShareRet;
                shareRet7.retMsg = "未知错误";
                this.mShareCallBackWrapper.onError(shareRet7);
                break;
        }
    }

    private void initShare() {
        this.mTencent = com.tencent.ysdk.shell.module.user.impl.qq.QQUserApi.getInstance().getQQApi();
        this.mWXAPI = com.tencent.ysdk.shell.module.user.impl.wx.WXUserApi.getInstance().getWXApi();
        this.mQQCallBack = new com.tencent.ysdk.shell.module.share.impl.ShareModule.QQShareCallBack();
        this.managerQQ = new com.tencent.ysdk.shell.module.share.impl.ShareManagerQQ(this.mTencent, this.mQQCallBack);
        this.managerWX = new com.tencent.ysdk.shell.module.share.impl.ShareManagerWX(this.mWXAPI);
        this.managerBBS = new com.tencent.ysdk.shell.module.share.impl.ShareManagerBBS(new com.tencent.ysdk.shell.module.share.impl.ShareModule.BBSShareCallBack());
        this.screenCapture = new com.tencent.ysdk.shell.module.share.impl.ScreenCapture();
        this.mShareCallBackWrapper = new com.tencent.ysdk.module.share.ShareCallBack() { // from class: com.tencent.ysdk.shell.module.share.impl.ShareModule.1
            @Override // com.tencent.ysdk.module.share.ShareCallBack
            public void onCancel(com.tencent.ysdk.module.share.impl.ShareRet shareRet) {
                if (com.tencent.ysdk.shell.module.share.impl.ShareModule.this.mShareCallBack != null) {
                    com.tencent.ysdk.shell.module.share.impl.ShareModule.this.mShareCallBack.onCancel(shareRet);
                } else {
                    com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.module.share.impl.ShareModule.TAG, "Share Call Back not reg!");
                }
                if (com.tencent.ysdk.shell.module.share.impl.ShareModuleStat.isURLShareType(shareRet)) {
                    com.tencent.ysdk.shell.module.share.impl.ShareModuleStat.reportH5URLshareEnd(-1, shareRet.url, shareRet.shareType, java.lang.String.valueOf(shareRet.retCode), shareRet.retMsg);
                    return;
                }
                try {
                    java.util.HashMap map = new java.util.HashMap();
                    map.put("shareChannel", com.tencent.ysdk.shell.module.share.impl.ShareModule.this.lastStartedShareRet.shareType.name());
                    map.put(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.PARA_SHARE_FROM, java.lang.String.valueOf(com.tencent.ysdk.shell.module.share.impl.ShareModule.this.lastStartedShareRet.isFromCap));
                    map.put(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.PARA_SHARE_EXTINFO, com.tencent.ysdk.shell.module.share.impl.ShareModule.this.lastStartedShareRet.extInfo);
                    map.put("shareResult", "CANCEL");
                    com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.reportIconBasicEvent(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.EVENT_SHARE_CALLBACK, 0, "click", map);
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // com.tencent.ysdk.module.share.ShareCallBack
            public void onError(com.tencent.ysdk.module.share.impl.ShareRet shareRet) {
                if (com.tencent.ysdk.shell.module.share.impl.ShareModule.this.mShareCallBack != null) {
                    com.tencent.ysdk.shell.module.share.impl.ShareModule.this.mShareCallBack.onError(shareRet);
                } else {
                    com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.module.share.impl.ShareModule.TAG, "Share Call Back not reg!");
                }
                if (com.tencent.ysdk.shell.module.share.impl.ShareModuleStat.isURLShareType(shareRet)) {
                    com.tencent.ysdk.shell.module.share.impl.ShareModuleStat.reportH5URLshareEnd(-1, shareRet.url, shareRet.shareType, java.lang.String.valueOf(shareRet.retCode), shareRet.retMsg);
                    return;
                }
                try {
                    java.util.HashMap map = new java.util.HashMap();
                    map.put("shareChannel", com.tencent.ysdk.shell.module.share.impl.ShareModule.this.lastStartedShareRet.shareType.name());
                    map.put(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.PARA_SHARE_FROM, java.lang.String.valueOf(com.tencent.ysdk.shell.module.share.impl.ShareModule.this.lastStartedShareRet.isFromCap));
                    map.put(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.PARA_SHARE_EXTINFO, com.tencent.ysdk.shell.module.share.impl.ShareModule.this.lastStartedShareRet.extInfo);
                    map.put("shareResult", "Error code:" + com.tencent.ysdk.shell.module.share.impl.ShareModule.this.lastStartedShareRet.retCode + " Error msg:" + com.tencent.ysdk.shell.module.share.impl.ShareModule.this.lastStartedShareRet.retMsg);
                    com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.reportIconBasicEvent(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.EVENT_SHARE_CALLBACK, 0, "click", map);
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // com.tencent.ysdk.module.share.ShareCallBack
            public void onSuccess(com.tencent.ysdk.module.share.impl.ShareRet shareRet) {
                com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.share.impl.ShareModule.TAG, shareRet.toString());
                if (com.tencent.ysdk.shell.module.share.impl.ShareModule.this.mShareCallBack != null) {
                    com.tencent.ysdk.shell.module.share.impl.ShareModule.this.mShareCallBack.onSuccess(shareRet);
                } else {
                    com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.module.share.impl.ShareModule.TAG, "Share Call Back not reg!");
                }
                if (com.tencent.ysdk.shell.module.share.impl.ShareModuleStat.isURLShareType(shareRet)) {
                    com.tencent.ysdk.shell.module.share.impl.ShareModuleStat.reportH5URLshareEnd(0, shareRet.url, shareRet.shareType, java.lang.String.valueOf(shareRet.retCode), shareRet.retMsg);
                    return;
                }
                try {
                    java.util.HashMap map = new java.util.HashMap();
                    map.put("shareChannel", com.tencent.ysdk.shell.module.share.impl.ShareModule.this.lastStartedShareRet.shareType.name());
                    map.put("shareResult", "SUCCESS");
                    map.put(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.PARA_SHARE_FROM, java.lang.String.valueOf(com.tencent.ysdk.shell.module.share.impl.ShareModule.this.lastStartedShareRet.isFromCap));
                    map.put(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.PARA_SHARE_EXTINFO, com.tencent.ysdk.shell.module.share.impl.ShareModule.this.lastStartedShareRet.extInfo);
                    com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.reportIconBasicEvent(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.EVENT_SHARE_CALLBACK, 0, "click", map);
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.io.File saveToSD(java.lang.String str) throws java.io.IOException {
        java.io.File file = new java.io.File(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext().getCacheDir().toString(), com.tencent.ysdk.shell.libware.encrypt.MD5.toMD5(str));
        if (file.exists()) {
            return file;
        }
        file.createNewFile();
        java.io.InputStream inputStream = new java.net.URL(str).openConnection().getInputStream();
        byte[] bArr = new byte[1024];
        java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                fileOutputStream.close();
                inputStream.close();
                return file;
            }
            fileOutputStream.write(bArr, 0, i);
        }
    }

    private void shareReport() {
        java.util.HashMap map = new java.util.HashMap();
        map.put("shareChannel", this.lastStartedShareRet.shareType.name());
        map.put(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.PARA_SHARE_FROM, java.lang.String.valueOf(this.lastStartedShareRet.isFromCap));
        map.put(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.PARA_SHARE_EXTINFO, this.lastStartedShareRet.extInfo);
        com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.reportIconBasicEvent(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.EVENT_SHARE_CLICK, 0, "click", map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] urlToByteArray(java.lang.String str) throws java.io.IOException {
        java.io.InputStream inputStream = new java.net.URL(str).openConnection().getInputStream();
        byte[] bArr = new byte[1024];
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                inputStream.close();
                return byteArray;
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    protected void apiReport(int i, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.util.HashMap map = new java.util.HashMap();
        map.put("shareChannel", this.lastStartedShareRet.shareType.name());
        map.put(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.PARA_SHARE_FROM, java.lang.String.valueOf(this.lastStartedShareRet.isFromCap));
        map.put(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.PARA_SHARE_EXTINFO, this.lastStartedShareRet.extInfo);
        map.put("errCode", str);
        map.put("errMsg", str2);
        com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.reportIconBasicEvent(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.EVENT_SHARE_API, i, str3, map);
    }

    java.io.File buildShareImage(android.graphics.Bitmap bitmap, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        try {
            return buildShareImageInner(bitmap, str, str2);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            apiReport(-1, "-1", "Native Error", "build Image");
            return null;
        }
    }

    @Override // com.tencent.ysdk.shell.module.share.ShareInterface
    public void captureScreen() {
        if (this.screenCapture == null) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "未注册分享截屏功能，请参考Wiki以及YSDK Demo处理截屏&分享模块");
        } else {
            new android.os.AsyncTask() { // from class: com.tencent.ysdk.shell.module.share.impl.ShareModule.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public android.graphics.Bitmap doInBackground(java.lang.Object[] objArr) {
                    try {
                        return com.tencent.ysdk.shell.module.share.impl.ShareModule.this.screenCapture.captureScreen();
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                        com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.module.share.impl.ShareModule.TAG, "获取屏幕Bitmap异常");
                        return null;
                    }
                }

                @Override // android.os.AsyncTask
                protected void onPostExecute(java.lang.Object obj) {
                    super.onPostExecute(obj);
                    if (obj == null || !(obj instanceof android.graphics.Bitmap)) {
                        com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.module.share.impl.ShareModule.TAG, "截屏功能异常，未能截取屏幕图像，请参考Wiki以及YSDK Demo处理截屏&分享模块");
                        return;
                    }
                    com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.reportIconBasicEvent(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.EVENT_CAPTURE_SCREEN_CLICK, 0, "click", null);
                    com.tencent.ysdk.shell.module.share.impl.ShareModule.this.mIsFromScreenCapture = true;
                    com.tencent.ysdk.shell.module.share.impl.ShareModule.this.innerShare((android.graphics.Bitmap) obj, com.tencent.ysdk.shell.libware.apk.PackageUtils.getAppName(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext()), "游戏截图", com.tencent.ysdk.shell.module.share.impl.ShareModule.this.mIsFromScreenCapture, "SDKcaptureImg");
                }
            }.execute(new java.lang.Object[0]);
        }
    }

    @Override // com.tencent.ysdk.shell.module.share.ShareInterface
    public boolean checkWXCallBack(android.content.Intent intent) {
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "onResp");
        if (intent == null) {
            return false;
        }
        java.lang.String stringExtra = intent.getStringExtra(com.tencent.ysdk.module.user.impl.wx.WXKey.TRANSACTION_TYPE);
        if (android.text.TextUtils.isEmpty(stringExtra) || !stringExtra.startsWith(WX_SHARE_PREFIX) || this.lastStartedShareRet == null) {
            return false;
        }
        handleShareResultByErrorCode(intent.getIntExtra(com.tencent.ysdk.module.user.impl.wx.WXKey.SHARE_CODE, -1));
        return true;
    }

    @Override // com.tencent.ysdk.shell.module.Module
    public void init() {
        super.init();
        if (com.tencent.ysdk.shell.framework.config.Config.isSwitchEnabled(com.tencent.ysdk.shell.framework.config.Config.YSDK_SHARE_SWITCH, true)) {
            initShare();
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.w(TAG, "Share Module is closed");
        }
    }

    public void innerShare(final android.graphics.Bitmap bitmap, final java.lang.String str, final java.lang.String str2, boolean z, final java.lang.String str3) {
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "show share panel");
        java.util.HashMap map = new java.util.HashMap();
        map.put(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.PARA_SHARE_FROM, java.lang.String.valueOf(z));
        map.put(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.PARA_SHARE_EXTINFO, str3);
        com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.reportIconBasicEvent(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.EVENT_SHARE_OPEN, 0, cn.yunzhisheng.asr.JniUscClient.r, map);
        if (this.mSharePanelView == null) {
            this.mSharePanelView = new com.tencent.ysdk.shell.module.share.impl.SharePanelView(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getPluginContext());
        }
        this.mSharePanelView.setIsScreenCap(z);
        this.mSharePanelView.setScreenCap(bitmap);
        this.mSharePanelView.regShareClickListener(new com.tencent.ysdk.shell.module.share.impl.SharePanelView.OnShareClickListener() { // from class: com.tencent.ysdk.shell.module.share.impl.ShareModule.6
            @Override // com.tencent.ysdk.shell.module.share.impl.SharePanelView.OnShareClickListener
            public void onShareBBS() {
                com.tencent.ysdk.shell.module.share.impl.ShareModule.this.shareToBBS(bitmap, str, str2, str3);
            }

            @Override // com.tencent.ysdk.shell.module.share.impl.SharePanelView.OnShareClickListener
            public void onShareQQ() {
                com.tencent.ysdk.shell.module.share.impl.ShareModule.this.shareToQQFriend(bitmap, str, str2, str3);
            }

            @Override // com.tencent.ysdk.shell.module.share.impl.SharePanelView.OnShareClickListener
            public void onShareQZone() {
                com.tencent.ysdk.shell.module.share.impl.ShareModule.this.shareToQZone(bitmap, str, str2, str3);
            }

            @Override // com.tencent.ysdk.shell.module.share.impl.SharePanelView.OnShareClickListener
            public void onShareWX() {
                com.tencent.ysdk.shell.module.share.impl.ShareModule.this.shareToWXFriend(bitmap, str, str2, str3);
            }

            @Override // com.tencent.ysdk.shell.module.share.impl.SharePanelView.OnShareClickListener
            public void onShareWX_Timeline() {
                com.tencent.ysdk.shell.module.share.impl.ShareModule.this.shareToWXTimeline(bitmap, str, str2, str3);
            }
        });
        this.mSharePanelView.showSharePanel();
    }

    @Override // com.tencent.ysdk.shell.module.share.ShareInterface
    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        if (i == 10103 || i == 10104) {
            com.tencent.tauth.Tencent.onActivityResultData(i, i2, intent, this.mQQCallBack);
        }
    }

    @Override // com.tencent.ysdk.shell.module.share.ShareInterface
    public void regShareCallBack(com.tencent.ysdk.module.share.ShareCallBack shareCallBack) {
        this.mShareCallBack = shareCallBack;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.graphics.Bitmap] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0077 -> B:40:0x007a). Please report as a decompilation issue!!! */
    public java.io.File saveToSD(android.graphics.Bitmap bitmap) throws java.lang.Throwable {
        java.io.File file = new java.io.File(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext().getCacheDir().toString(), java.lang.String.format("game{0}.png", new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date(java.lang.System.currentTimeMillis()))));
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
        ?? r0 = 0;
        java.io.FileOutputStream fileOutputStream = null;
        java.io.FileOutputStream fileOutputStream2 = null;
        r0 = 0;
        try {
            try {
                try {
                    java.io.FileOutputStream fileOutputStream3 = new java.io.FileOutputStream(file);
                    try {
                        android.graphics.Bitmap.CompressFormat compressFormat = android.graphics.Bitmap.CompressFormat.PNG;
                        bitmap.compress(compressFormat, 100, fileOutputStream3);
                        fileOutputStream3.flush();
                        fileOutputStream3.close();
                        r0 = compressFormat;
                    } catch (java.io.FileNotFoundException e2) {
                        e = e2;
                        fileOutputStream = fileOutputStream3;
                        e.printStackTrace();
                        r0 = fileOutputStream;
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                            r0 = fileOutputStream;
                        }
                    } catch (java.io.IOException e3) {
                        e = e3;
                        fileOutputStream2 = fileOutputStream3;
                        e.printStackTrace();
                        r0 = fileOutputStream2;
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                            r0 = fileOutputStream2;
                        }
                    } catch (java.lang.Throwable th) {
                        th = th;
                        r0 = fileOutputStream3;
                        if (r0 != 0) {
                            try {
                                r0.close();
                            } catch (java.io.IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                }
            } catch (java.io.FileNotFoundException e5) {
                e = e5;
            } catch (java.io.IOException e6) {
                e = e6;
            }
        } catch (java.io.IOException e7) {
            e7.printStackTrace();
            r0 = r0;
        }
        return file;
    }

    @Override // com.tencent.ysdk.shell.module.share.ShareInterface
    public void setScreenCapturer(com.tencent.ysdk.module.share.impl.IScreenImageCapturer iScreenImageCapturer) {
        this.screenCapture.setScreenImageCapturer(iScreenImageCapturer);
    }

    @Override // com.tencent.ysdk.shell.module.share.ShareInterface
    public void share(android.graphics.Bitmap bitmap, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.mIsFromScreenCapture = false;
        innerShare(bitmap, str, str2, this.mIsFromScreenCapture, checkExtInfo(str3));
    }

    @Override // com.tencent.ysdk.shell.module.share.ShareInterface
    public void shareToBBS(android.graphics.Bitmap bitmap, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.String strCheckExtInfo = checkExtInfo(str3);
        this.lastStartedShareRet = new com.tencent.ysdk.module.share.impl.ShareRet();
        com.tencent.ysdk.module.share.impl.ShareRet shareRet = this.lastStartedShareRet;
        shareRet.extInfo = strCheckExtInfo;
        shareRet.shareType = com.tencent.ysdk.module.share.impl.ShareRet.ShareType.BBS;
        this.lastStartedShareRet.isFromCap = this.mIsFromScreenCapture;
        buildShareImage(bitmap, str, str2, strCheckExtInfo);
        shareReport();
    }

    @Override // com.tencent.ysdk.shell.module.share.ShareInterface
    public void shareToQQFriend(android.graphics.Bitmap bitmap, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.lastStartedShareRet = new com.tencent.ysdk.module.share.impl.ShareRet();
        com.tencent.ysdk.module.share.impl.ShareRet shareRet = this.lastStartedShareRet;
        shareRet.extInfo = str3;
        shareRet.shareType = com.tencent.ysdk.module.share.impl.ShareRet.ShareType.QQFriend;
        this.lastStartedShareRet.isFromCap = this.mIsFromScreenCapture;
        buildShareImage(bitmap, str, str2, str3);
        shareReport();
    }

    @Override // com.tencent.ysdk.shell.module.share.ShareInterface
    public void shareToQZone(android.graphics.Bitmap bitmap, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.String strCheckExtInfo = checkExtInfo(str3);
        this.lastStartedShareRet = new com.tencent.ysdk.module.share.impl.ShareRet();
        com.tencent.ysdk.module.share.impl.ShareRet shareRet = this.lastStartedShareRet;
        shareRet.extInfo = strCheckExtInfo;
        shareRet.shareType = com.tencent.ysdk.module.share.impl.ShareRet.ShareType.QZone;
        this.lastStartedShareRet.isFromCap = this.mIsFromScreenCapture;
        shareReport();
        buildShareImage(bitmap, str, str2, strCheckExtInfo);
    }

    @Override // com.tencent.ysdk.shell.module.share.ShareInterface
    public void shareToWXFriend(android.graphics.Bitmap bitmap, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.String strCheckExtInfo = checkExtInfo(str3);
        this.lastStartedShareRet = new com.tencent.ysdk.module.share.impl.ShareRet();
        com.tencent.ysdk.module.share.impl.ShareRet shareRet = this.lastStartedShareRet;
        shareRet.extInfo = strCheckExtInfo;
        shareRet.shareType = com.tencent.ysdk.module.share.impl.ShareRet.ShareType.WXFriend;
        this.lastStartedShareRet.isFromCap = this.mIsFromScreenCapture;
        buildShareImage(bitmap, str, str2, strCheckExtInfo);
        shareReport();
    }

    @Override // com.tencent.ysdk.shell.module.share.ShareInterface
    public void shareToWXTimeline(android.graphics.Bitmap bitmap, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.String strCheckExtInfo = checkExtInfo(str3);
        this.lastStartedShareRet = new com.tencent.ysdk.module.share.impl.ShareRet();
        com.tencent.ysdk.module.share.impl.ShareRet shareRet = this.lastStartedShareRet;
        shareRet.extInfo = strCheckExtInfo;
        shareRet.shareType = com.tencent.ysdk.module.share.impl.ShareRet.ShareType.WXTimeLine;
        this.lastStartedShareRet.isFromCap = this.mIsFromScreenCapture;
        buildShareImage(bitmap, str, str2, strCheckExtInfo);
        shareReport();
    }

    @Override // com.tencent.ysdk.shell.module.share.ShareInterface
    public void shareURLToQQFriend(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        this.lastStartedShareRet = new com.tencent.ysdk.module.share.impl.ShareRet();
        com.tencent.ysdk.module.share.impl.ShareRet shareRet = this.lastStartedShareRet;
        shareRet.extInfo = str5;
        shareRet.shareType = com.tencent.ysdk.module.share.impl.ShareRet.ShareType.QQFriendURL;
        com.tencent.ysdk.module.share.impl.ShareRet shareRet2 = this.lastStartedShareRet;
        shareRet2.isFromCap = false;
        shareRet2.url = str2;
        buildShareURL(str, str2, str3, str4);
        com.tencent.ysdk.shell.module.share.impl.ShareModuleStat.reportH5URLshareStart(0, str2, this.lastStartedShareRet.shareType, "0", "");
    }

    @Override // com.tencent.ysdk.shell.module.share.ShareInterface
    public void shareURLToQZone(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        java.lang.String strCheckExtInfo = checkExtInfo(str5);
        this.lastStartedShareRet = new com.tencent.ysdk.module.share.impl.ShareRet();
        com.tencent.ysdk.module.share.impl.ShareRet shareRet = this.lastStartedShareRet;
        shareRet.extInfo = strCheckExtInfo;
        shareRet.shareType = com.tencent.ysdk.module.share.impl.ShareRet.ShareType.QZoneURL;
        com.tencent.ysdk.module.share.impl.ShareRet shareRet2 = this.lastStartedShareRet;
        shareRet2.isFromCap = false;
        shareRet2.url = str2;
        buildShareURL(str, str2, str3, str4);
        com.tencent.ysdk.shell.module.share.impl.ShareModuleStat.reportH5URLshareStart(0, str2, this.lastStartedShareRet.shareType, "0", "");
    }

    @Override // com.tencent.ysdk.shell.module.share.ShareInterface
    public void shareURLToWXFriend(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        java.lang.String strCheckExtInfo = checkExtInfo(str5);
        this.lastStartedShareRet = new com.tencent.ysdk.module.share.impl.ShareRet();
        com.tencent.ysdk.module.share.impl.ShareRet shareRet = this.lastStartedShareRet;
        shareRet.extInfo = strCheckExtInfo;
        shareRet.shareType = com.tencent.ysdk.module.share.impl.ShareRet.ShareType.WXFriendURL;
        com.tencent.ysdk.module.share.impl.ShareRet shareRet2 = this.lastStartedShareRet;
        shareRet2.isFromCap = false;
        shareRet2.url = str2;
        buildShareURL(str, str2, str3, str4);
        com.tencent.ysdk.shell.module.share.impl.ShareModuleStat.reportH5URLshareStart(0, str2, this.lastStartedShareRet.shareType, "0", "");
    }

    @Override // com.tencent.ysdk.shell.module.share.ShareInterface
    public void shareURLToWXTimeline(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        java.lang.String strCheckExtInfo = checkExtInfo(str5);
        this.lastStartedShareRet = new com.tencent.ysdk.module.share.impl.ShareRet();
        com.tencent.ysdk.module.share.impl.ShareRet shareRet = this.lastStartedShareRet;
        shareRet.extInfo = strCheckExtInfo;
        shareRet.shareType = com.tencent.ysdk.module.share.impl.ShareRet.ShareType.WXTimeLineURL;
        com.tencent.ysdk.module.share.impl.ShareRet shareRet2 = this.lastStartedShareRet;
        shareRet2.isFromCap = false;
        shareRet2.url = str2;
        buildShareURL(str, str2, str3, str4);
        com.tencent.ysdk.shell.module.share.impl.ShareModuleStat.reportH5URLshareStart(0, str2, this.lastStartedShareRet.shareType, "0", "");
    }
}
