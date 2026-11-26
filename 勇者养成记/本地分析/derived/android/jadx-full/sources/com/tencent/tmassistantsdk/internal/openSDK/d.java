package com.tencent.tmassistantsdk.internal.openSDK;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class d implements com.tencent.tmassistantbase.common.download.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static com.tencent.tmassistantsdk.internal.openSDK.d f1083a;
    protected com.tencent.tmassistantsdk.internal.b.a b = null;
    protected com.tencent.tmassistantsdk.ITMAssistantCallBackListener c = null;
    java.lang.String d = java.util.UUID.randomUUID().toString();

    public d() {
    }

    private d(android.content.Context context) {
        if (context != null) {
            b(context);
        }
    }

    public static synchronized com.tencent.tmassistantsdk.internal.openSDK.d a(android.content.Context context) {
        if (f1083a == null) {
            f1083a = new com.tencent.tmassistantsdk.internal.openSDK.d(context);
        }
        return f1083a;
    }

    public static byte[] a(com.qq.taf.jce.JceStruct jceStruct, java.lang.String str) {
        java.lang.String str2;
        java.lang.String str3;
        com.tencent.tmassistantbase.util.TMLog.i("QQDownloaderOpenSDKDataProcessor", "jceStruct = " + jceStruct);
        com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCRequest iPCRequestA = com.tencent.tmassistantsdk.internal.openSDK.param.a.a(jceStruct, str);
        if (iPCRequestA != null) {
            byte[] bArrA = com.tencent.tmassistantsdk.internal.openSDK.param.a.a(iPCRequestA);
            if (bArrA != null && bArrA.length > 0) {
                com.tencent.tmassistantbase.util.TMLog.i("QQDownloaderOpenSDKDataProcessor", "return sendData length = " + bArrA.length);
                return bArrA;
            }
            str2 = "QQDownloaderOpenSDKDataProcessor";
            str3 = "handleUriAction sendData = null";
        } else {
            str2 = "QQDownloaderOpenSDKDataProcessor";
            str3 = "handleUriAction IPCRequest = null";
        }
        com.tencent.tmassistantbase.util.TMLog.i(str2, str3);
        return null;
    }

    public static com.tencent.tmassistantsdk.internal.openSDK.param.jce.BatchDownloadActionRequest b(int i, java.util.ArrayList arrayList, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("batchRequestType = ");
        sb.append(i);
        sb.append(",appList size = ");
        sb.append(arrayList == null ? "null" : java.lang.Integer.valueOf(arrayList.size()));
        sb.append(",via = ");
        sb.append(str);
        sb.append(",uin = ");
        sb.append(str2);
        sb.append(",uinType = ");
        sb.append(str3);
        com.tencent.tmassistantbase.util.TMLog.i("QQDownloaderOpenSDKDataProcessor", sb.toString());
        com.tencent.tmassistantsdk.internal.openSDK.param.jce.BatchDownloadActionRequest batchDownloadActionRequest = new com.tencent.tmassistantsdk.internal.openSDK.param.jce.BatchDownloadActionRequest();
        batchDownloadActionRequest.batchRequestType = i;
        if (str != null) {
            batchDownloadActionRequest.via = str;
        }
        if (str2 != null) {
            batchDownloadActionRequest.uin = str2;
        }
        if (str3 != null) {
            batchDownloadActionRequest.uinType = str3;
        }
        batchDownloadActionRequest.batchData = new java.util.ArrayList();
        java.lang.String str4 = "appList {";
        if (arrayList != null) {
            str4 = "appList {appList.size=" + arrayList.size() + "\n";
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCBaseParam iPCBaseParamB = b((com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct) arrayList.get(i2));
                com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCDownloadParam iPCDownloadParam = new com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCDownloadParam();
                iPCDownloadParam.baseParam = iPCBaseParamB;
                batchDownloadActionRequest.batchData.add(iPCDownloadParam);
                str4 = str4 + "element:" + i2 + "IPCDownloadParam {IPCBaseParam {hostAppId:" + iPCDownloadParam.baseParam.hostAppId + "|taskAppId:" + iPCDownloadParam.baseParam.taskAppId + "|taskPackageName:" + iPCDownloadParam.baseParam.taskPackageName + "|taskVersion:" + iPCDownloadParam.baseParam.taskVersion + "}|actionFlag:" + iPCDownloadParam.actionFlag + "|verifyType:" + iPCDownloadParam.verifyType + "}\n";
            }
        }
        com.tencent.tmassistantbase.util.TMLog.i("QQDownloaderOpenSDKDataProcessor", str4 + "}");
        return batchDownloadActionRequest;
    }

    private static com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCBaseParam b(com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct) {
        if (tMAssistantCallYYBParamStruct == null) {
            return null;
        }
        com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCBaseParam iPCBaseParam = new com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCBaseParam();
        iPCBaseParam.hostAppId = tMAssistantCallYYBParamStruct.SNGAppId;
        iPCBaseParam.taskAppId = tMAssistantCallYYBParamStruct.taskAppId;
        iPCBaseParam.taskPackageName = tMAssistantCallYYBParamStruct.taskPackageName;
        iPCBaseParam.taskVersion = java.lang.String.valueOf(tMAssistantCallYYBParamStruct.taskVersion);
        iPCBaseParam.uin = tMAssistantCallYYBParamStruct.uin;
        iPCBaseParam.uinType = tMAssistantCallYYBParamStruct.uinType;
        iPCBaseParam.via = "ANDROIDSDK.YYB.DOWNLOAD." + tMAssistantCallYYBParamStruct.via;
        iPCBaseParam.channelId = tMAssistantCallYYBParamStruct.channelId;
        return iPCBaseParam;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x007d  */
    /* JADX WARN: Code duplicated, block: B:19:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:21:0x00b4  */
    /* JADX WARN: Instruction removed from duplicated block: B:17:0x007d, please report this as an issue */
    public com.tencent.tmassistantsdk.TMAssistantCallYYBTaskInfo a(com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct) {
        byte[] bArrA;
        com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCResponse iPCResponseA;
        com.tencent.tmassistantsdk.internal.openSDK.param.jce.QueryDownloadTaskResponse queryDownloadTaskResponse;
        int iA;
        com.tencent.tmassistantbase.util.TMLog.i("QQDownloaderOpenSDKDataProcessor", "getDownloadTask param.sngAppid:" + tMAssistantCallYYBParamStruct.SNGAppId + "|param.appid:" + tMAssistantCallYYBParamStruct.taskAppId + "| param.taskPackageName:" + tMAssistantCallYYBParamStruct.taskPackageName + "|param.taskVersion:" + tMAssistantCallYYBParamStruct.taskVersion);
        com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCBaseParam iPCBaseParamB = b(tMAssistantCallYYBParamStruct);
        com.tencent.tmassistantsdk.internal.openSDK.param.jce.QueryDownloadTaskRequest queryDownloadTaskRequest = new com.tencent.tmassistantsdk.internal.openSDK.param.jce.QueryDownloadTaskRequest();
        queryDownloadTaskRequest.baseParam = iPCBaseParamB;
        byte[] bArrA2 = a(queryDownloadTaskRequest, "");
        if (bArrA2 != null && bArrA2.length > 0) {
            try {
                b(com.tencent.tmassistantbase.util.k.a().b());
                if (this.b != null) {
                    bArrA = this.b.a(bArrA2);
                }
                iPCResponseA = com.tencent.tmassistantsdk.internal.openSDK.param.a.a(bArrA);
                if (iPCResponseA != null) {
                    queryDownloadTaskResponse = (com.tencent.tmassistantsdk.internal.openSDK.param.jce.QueryDownloadTaskResponse) com.tencent.tmassistantsdk.internal.openSDK.param.a.a(iPCResponseA);
                    com.tencent.tmassistantbase.util.TMLog.i("QQDownloaderOpenSDKDataProcessor", "QueryDownloadTaskResponse downloadTask state:" + queryDownloadTaskResponse.state);
                    iA = com.tencent.tmassistantbase.util.k.a(queryDownloadTaskResponse.state);
                    if (queryDownloadTaskResponse != null) {
                        return new com.tencent.tmassistantsdk.TMAssistantCallYYBTaskInfo(queryDownloadTaskResponse.url, queryDownloadTaskResponse.savePath, iA, queryDownloadTaskResponse.receivedLen, queryDownloadTaskResponse.totalLen, com.tencent.tmassistantbase.common.download.TMAssistantDownloadContentType.CONTENT_TYPE_APK);
                    }
                } else {
                    com.tencent.tmassistantbase.util.TMLog.i("QQDownloaderOpenSDKDataProcessor", "getDownloadTask IPCResponse = null");
                }
                com.tencent.tmassistantbase.util.TMLog.i("QQDownloaderOpenSDKDataProcessor", "getDownloadTask return null");
                return null;
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                com.tencent.tmassistantbase.util.TMLog.e("QQDownloaderOpenSDKDataProcessor", "getDownloadTask Exception,return null", th);
                return null;
            }
        }
        com.tencent.tmassistantbase.util.TMLog.i("QQDownloaderOpenSDKDataProcessor", "getDownloadTask sendData = null");
        bArrA = null;
        iPCResponseA = com.tencent.tmassistantsdk.internal.openSDK.param.a.a(bArrA);
        if (iPCResponseA != null) {
            queryDownloadTaskResponse = (com.tencent.tmassistantsdk.internal.openSDK.param.jce.QueryDownloadTaskResponse) com.tencent.tmassistantsdk.internal.openSDK.param.a.a(iPCResponseA);
            com.tencent.tmassistantbase.util.TMLog.i("QQDownloaderOpenSDKDataProcessor", "QueryDownloadTaskResponse downloadTask state:" + queryDownloadTaskResponse.state);
            iA = com.tencent.tmassistantbase.util.k.a(queryDownloadTaskResponse.state);
            if (queryDownloadTaskResponse != null) {
                return new com.tencent.tmassistantsdk.TMAssistantCallYYBTaskInfo(queryDownloadTaskResponse.url, queryDownloadTaskResponse.savePath, iA, queryDownloadTaskResponse.receivedLen, queryDownloadTaskResponse.totalLen, com.tencent.tmassistantbase.common.download.TMAssistantDownloadContentType.CONTENT_TYPE_APK);
            }
        } else {
            com.tencent.tmassistantbase.util.TMLog.i("QQDownloaderOpenSDKDataProcessor", "getDownloadTask IPCResponse = null");
        }
        com.tencent.tmassistantbase.util.TMLog.i("QQDownloaderOpenSDKDataProcessor", "getDownloadTask return null");
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0076  */
    /* JADX WARN: Code duplicated, block: B:23:0x007e  */
    /* JADX WARN: Code duplicated, block: B:25:0x0095  */
    /* JADX WARN: Code duplicated, block: B:28:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:30:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:33:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:36:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:37:0x0101  */
    /* JADX WARN: Code duplicated, block: B:43:0x00e0 A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:23:0x007e, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:25:0x0095, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:33:0x00e5, please report this as an issue */
    public java.util.ArrayList a(java.util.ArrayList arrayList, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCResponse iPCResponseA;
        java.lang.String str4;
        java.lang.String str5;
        com.tencent.tmassistantsdk.internal.openSDK.param.jce.BatchDownloadActionResponse batchDownloadActionResponse;
        java.lang.String str6;
        java.util.ArrayList arrayList2;
        int i;
        com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCQueryDownloadInfo iPCQueryDownloadInfo;
        int iA;
        java.util.ArrayList arrayList3 = null;
        if (arrayList == null) {
            com.tencent.tmassistantbase.util.TMLog.i("QQDownloaderOpenSDKDataProcessor", "appList = null,return null");
            return null;
        }
        com.tencent.tmassistantbase.util.TMLog.i("QQDownloaderOpenSDKDataProcessor", "getBatchTaskInfos appList.size:" + arrayList.size() + ",via = " + str + ",uin = " + str2 + ",uinType = " + str3);
        byte[] bArrA = a(b(3, arrayList, str, str2, str3), "");
        if (bArrA != null && bArrA.length > 0) {
            try {
                b(com.tencent.tmassistantbase.util.k.a().b());
                byte[] bArrA2 = this.b != null ? this.b.a(bArrA) : null;
                iPCResponseA = com.tencent.tmassistantsdk.internal.openSDK.param.a.a(bArrA2);
                if (iPCResponseA != null) {
                    batchDownloadActionResponse = (com.tencent.tmassistantsdk.internal.openSDK.param.jce.BatchDownloadActionResponse) com.tencent.tmassistantsdk.internal.openSDK.param.a.a(iPCResponseA);
                    if (batchDownloadActionResponse != null) {
                        str6 = "getBatchTaskInfos BatchDownloadActionResponse batchRequestType:" + batchDownloadActionResponse.batchRequestType;
                        if (batchDownloadActionResponse.batchData != null) {
                            str5 = str6 + "response.batchData.size:" + batchDownloadActionResponse.batchData.size();
                            arrayList2 = new java.util.ArrayList();
                            for (i = 0; i < batchDownloadActionResponse.batchData.size(); i++) {
                                iPCQueryDownloadInfo = (com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCQueryDownloadInfo) batchDownloadActionResponse.batchData.get(i);
                                iA = com.tencent.tmassistantbase.util.k.a(iPCQueryDownloadInfo.state);
                                if (iPCQueryDownloadInfo != null) {
                                    arrayList2.add(new com.tencent.tmassistantsdk.TMAssistantCallYYBTaskInfo(iPCQueryDownloadInfo.url, iPCQueryDownloadInfo.savePath, iA, iPCQueryDownloadInfo.receivedLen, iPCQueryDownloadInfo.totalLen, com.tencent.tmassistantbase.common.download.TMAssistantDownloadContentType.CONTENT_TYPE_APK));
                                }
                            }
                            arrayList3 = arrayList2;
                        } else {
                            str5 = str6 + "response.batchData = null";
                        }
                        str4 = "QQDownloaderOpenSDKDataProcessor";
                    } else {
                        str4 = "QQDownloaderOpenSDKDataProcessor";
                        str5 = "getBatchTaskInfos BatchDownloadActionResponse response = null";
                    }
                } else {
                    str4 = "QQDownloaderOpenSDKDataProcessor";
                    str5 = "getBatchTaskInfos IPCResponse resp = null";
                }
                com.tencent.tmassistantbase.util.TMLog.i(str4, str5);
                return arrayList3;
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        com.tencent.tmassistantbase.util.TMLog.i("QQDownloaderOpenSDKDataProcessor", "getBatchTaskInfos sendData = null or length = 0");
        iPCResponseA = com.tencent.tmassistantsdk.internal.openSDK.param.a.a(bArrA2);
        if (iPCResponseA != null) {
            batchDownloadActionResponse = (com.tencent.tmassistantsdk.internal.openSDK.param.jce.BatchDownloadActionResponse) com.tencent.tmassistantsdk.internal.openSDK.param.a.a(iPCResponseA);
            if (batchDownloadActionResponse != null) {
                str6 = "getBatchTaskInfos BatchDownloadActionResponse batchRequestType:" + batchDownloadActionResponse.batchRequestType;
                if (batchDownloadActionResponse.batchData != null) {
                    str5 = str6 + "response.batchData.size:" + batchDownloadActionResponse.batchData.size();
                    arrayList2 = new java.util.ArrayList();
                    while (i < batchDownloadActionResponse.batchData.size()) {
                        iPCQueryDownloadInfo = (com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCQueryDownloadInfo) batchDownloadActionResponse.batchData.get(i);
                        iA = com.tencent.tmassistantbase.util.k.a(iPCQueryDownloadInfo.state);
                        if (iPCQueryDownloadInfo != null) {
                            arrayList2.add(new com.tencent.tmassistantsdk.TMAssistantCallYYBTaskInfo(iPCQueryDownloadInfo.url, iPCQueryDownloadInfo.savePath, iA, iPCQueryDownloadInfo.receivedLen, iPCQueryDownloadInfo.totalLen, com.tencent.tmassistantbase.common.download.TMAssistantDownloadContentType.CONTENT_TYPE_APK));
                        }
                    }
                    arrayList3 = arrayList2;
                } else {
                    str5 = str6 + "response.batchData = null";
                }
                str4 = "QQDownloaderOpenSDKDataProcessor";
            } else {
                str4 = "QQDownloaderOpenSDKDataProcessor";
                str5 = "getBatchTaskInfos BatchDownloadActionResponse response = null";
            }
        } else {
            str4 = "QQDownloaderOpenSDKDataProcessor";
            str5 = "getBatchTaskInfos IPCResponse resp = null";
        }
        com.tencent.tmassistantbase.util.TMLog.i(str4, str5);
        return arrayList3;
    }

    @Override // com.tencent.tmassistantbase.common.download.a
    public void a() {
        com.tencent.tmassistantbase.util.TMLog.i("QQDownloaderOpenSDKDataProcessor", "onDownloadSDKServiceInvalid callback = " + this.c);
        com.tencent.tmassistantsdk.ITMAssistantCallBackListener iTMAssistantCallBackListener = this.c;
        if (iTMAssistantCallBackListener != null) {
            iTMAssistantCallBackListener.OnQQDownloaderInvalid();
        }
        android.content.Context contextB = com.tencent.tmassistantbase.util.k.a().b();
        if (contextB != null) {
            com.tencent.tmassistantsdk.b.a(contextB).c(this.d);
        }
        this.b = null;
    }

    public void a(com.tencent.tmassistantsdk.ITMAssistantCallBackListener iTMAssistantCallBackListener) {
        com.tencent.tmassistantbase.util.TMLog.i("QQDownloaderOpenSDKDataProcessor", "listener = " + iTMAssistantCallBackListener);
        this.c = iTMAssistantCallBackListener;
    }

    public boolean a(int i, java.util.ArrayList arrayList, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.String str4;
        java.lang.String str5;
        com.tencent.tmassistantbase.util.TMLog.i("QQDownloaderOpenSDKDataProcessor", "handleBatchUpdateAction batchRequestType:" + i + "|appList:" + arrayList);
        com.tencent.tmassistantsdk.internal.openSDK.param.jce.BatchDownloadActionRequest batchDownloadActionRequestB = b(i, arrayList, str, str2, str3);
        java.lang.String string = java.util.UUID.randomUUID().toString();
        byte[] bArrA = a(batchDownloadActionRequestB, string);
        if (bArrA == null || bArrA.length <= 0) {
            str4 = "QQDownloaderOpenSDKDataProcessor";
            str5 = "handleBatchUpdateAction sendData = null or length = 0";
        } else {
            try {
                b(com.tencent.tmassistantbase.util.k.a().b());
                if (this.b == null) {
                    com.tencent.tmassistantbase.util.TMLog.i("QQDownloaderOpenSDKDataProcessor", "result is false,openSDKClient is null");
                    return false;
                }
                this.b.b(bArrA);
                com.tencent.tmassistantbase.util.TMLog.i("QQDownloaderOpenSDKDataProcessor", "result is true");
                com.tencent.tmassistantsdk.internal.c.b.h().a(com.tencent.tmassistantsdk.internal.c.b.h().a(str, string, "V2_handleBatchRequestAction_" + i));
                return true;
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                str4 = "QQDownloaderOpenSDKDataProcessor";
                str5 = "result is false";
            }
        }
        com.tencent.tmassistantbase.util.TMLog.i(str4, str5);
        return false;
    }

    public boolean a(com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, int i, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.tencent.tmassistantbase.util.TMLog.i("QQDownloaderOpenSDKDataProcessor", "handleDownloadTask requestType:" + i + "  param.sngAppid:" + tMAssistantCallYYBParamStruct.SNGAppId + "|param.appid:" + tMAssistantCallYYBParamStruct.taskAppId + "| param.taskPackageName:" + tMAssistantCallYYBParamStruct.taskPackageName + "|param.taskVersion:" + tMAssistantCallYYBParamStruct.taskVersion + "| param.actionFlag:" + str2 + " | verifyType:" + str3);
        com.tencent.tmassistantsdk.internal.openSDK.param.jce.OperateDownloadTaskRequest operateDownloadTaskRequest = new com.tencent.tmassistantsdk.internal.openSDK.param.jce.OperateDownloadTaskRequest();
        com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCBaseParam iPCBaseParamB = b(tMAssistantCallYYBParamStruct);
        operateDownloadTaskRequest.requestType = i;
        operateDownloadTaskRequest.baseParam = iPCBaseParamB;
        operateDownloadTaskRequest.actionFlag = str2;
        operateDownloadTaskRequest.verifyType = str3;
        operateDownloadTaskRequest.opList = str;
        java.lang.String string = java.util.UUID.randomUUID().toString();
        byte[] bArrA = a(operateDownloadTaskRequest, string);
        if (bArrA == null || bArrA.length <= 0) {
            com.tencent.tmassistantbase.util.TMLog.i("QQDownloaderOpenSDKDataProcessor", "handleDownloadTask sendData = null,return false");
            return false;
        }
        try {
            b(com.tencent.tmassistantbase.util.k.a().b());
            if (this.b == null) {
                com.tencent.tmassistantbase.util.TMLog.i("QQDownloaderOpenSDKDataProcessor", "handleDownloadTask openSDKClient = null,return false");
                return false;
            }
            this.b.b(bArrA);
            com.tencent.tmassistantbase.util.TMLog.i("QQDownloaderOpenSDKDataProcessor", "return true");
            com.tencent.tmassistantsdk.internal.c.b.h().a(com.tencent.tmassistantsdk.internal.c.b.h().a(com.tencent.tmassistantsdk.internal.c.b.a(tMAssistantCallYYBParamStruct), string, "V2_handleDownloadTask_" + i));
            return true;
        } catch (java.lang.Throwable th) {
            com.tencent.tmassistantbase.util.TMLog.i("QQDownloaderOpenSDKDataProcessor", "handleDownloadTask Exception,return false", th);
            th.printStackTrace();
            return false;
        }
    }

    public boolean a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.tencent.tmassistantbase.util.TMLog.i("QQDownloaderOpenSDKDataProcessor", "uri = null,return false");
            return false;
        }
        com.tencent.tmassistantbase.util.TMLog.i("QQDownloaderOpenSDKDataProcessor", "uri = " + str);
        com.tencent.tmassistantsdk.internal.openSDK.param.jce.URIActionRequest uRIActionRequest = new com.tencent.tmassistantsdk.internal.openSDK.param.jce.URIActionRequest(str);
        java.lang.String string = java.util.UUID.randomUUID().toString();
        byte[] bArrA = a(uRIActionRequest, string);
        if (bArrA == null || bArrA.length <= 0) {
            com.tencent.tmassistantbase.util.TMLog.i("QQDownloaderOpenSDKDataProcessor", "handleUriAction sendData = null");
            return false;
        }
        try {
            b(com.tencent.tmassistantbase.util.k.a().b());
            if (this.b != null) {
                this.b.b(bArrA);
            }
            com.tencent.tmassistantsdk.internal.c.b.h().a(com.tencent.tmassistantsdk.internal.c.b.h().a(str, string, "V2_handleUriAction"));
            return false;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            com.tencent.tmassistantbase.util.TMLog.i("QQDownloaderOpenSDKDataProcessor", "handleUriAction Exception,return false", th);
            return false;
        }
    }

    public void b() {
        com.tencent.tmassistantbase.util.TMLog.i("QQDownloaderOpenSDKDataProcessor", "unregisterIQQDownloaderOpenSDKListener start");
        this.c = null;
        android.content.Context contextB = com.tencent.tmassistantbase.util.k.a().b();
        if (contextB != null) {
            com.tencent.tmassistantsdk.b.a(contextB).c(this.d);
        }
        this.b = null;
    }

    public synchronized void b(android.content.Context context) {
        if (this.b == null && context != null) {
            com.tencent.tmassistantsdk.internal.b.a aVarB = com.tencent.tmassistantsdk.b.a(context).b(this.d);
            this.b = aVarB;
            if (aVarB != null) {
                aVarB.a(this);
            }
        }
    }

    public void c() {
        com.tencent.tmassistantbase.util.TMLog.i("QQDownloaderOpenSDKDataProcessor", "releaseIPCClient openSDKClient = " + this.b);
        if (this.b != null) {
            android.content.Context contextB = com.tencent.tmassistantbase.util.k.a().b();
            if (contextB != null) {
                com.tencent.tmassistantsdk.b.a(contextB).c(this.d);
            }
            this.b = null;
        }
    }
}
