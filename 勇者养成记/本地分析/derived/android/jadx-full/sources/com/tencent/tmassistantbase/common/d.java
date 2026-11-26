package com.tencent.tmassistantbase.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class d {
    public static com.qq.taf.jce.JceStruct a(byte b, java.util.List list, java.lang.String str, int i, java.lang.String str2) {
        com.tencent.tmassistantbase.jce.ReportLogRequest reportLogRequest = new com.tencent.tmassistantbase.jce.ReportLogRequest();
        reportLogRequest.logType = b;
        reportLogRequest.logData = a(list);
        reportLogRequest.hostAppPackageName = str;
        reportLogRequest.hostAppVersion = i;
        reportLogRequest.hostUserId = str2;
        return reportLogRequest;
    }

    public static com.qq.taf.jce.JceStruct a(com.qq.taf.jce.JceStruct jceStruct, byte[] bArr) {
        com.qq.taf.jce.JceStruct jceStructD;
        if (jceStruct != null && bArr != null && (jceStructD = d(jceStruct)) != null) {
            try {
                com.qq.taf.jce.JceInputStream jceInputStream = new com.qq.taf.jce.JceInputStream(bArr);
                jceInputStream.setServerEncoding(com.unisound.b.f.b);
                jceStructD.readFrom(jceInputStream);
                return jceStructD;
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static com.qq.taf.jce.JceStruct a(byte[] bArr, java.lang.Class cls) {
        if (bArr != null) {
            try {
                com.qq.taf.jce.JceStruct jceStruct = (com.qq.taf.jce.JceStruct) cls.newInstance();
                com.qq.taf.jce.JceInputStream jceInputStream = new com.qq.taf.jce.JceInputStream(bArr);
                jceInputStream.setServerEncoding(com.unisound.b.f.b);
                jceStruct.readFrom(jceInputStream);
                return jceStruct;
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x010f  */
    /* JADX WARN: Code duplicated, block: B:17:0x0143  */
    public static com.tencent.tmassistantbase.jce.ReqHead a(com.qq.taf.jce.JceStruct jceStruct) {
        int length;
        com.tencent.tmassistantbase.jce.RomInfo romInfo;
        if (jceStruct == null) {
            return null;
        }
        com.tencent.tmassistantbase.jce.ReqHead reqHead = new com.tencent.tmassistantbase.jce.ReqHead();
        reqHead.requestId = com.tencent.tmassistantbase.util.k.l();
        java.lang.String simpleName = jceStruct.getClass().getSimpleName();
        if (!simpleName.endsWith("Request")) {
            if (simpleName.endsWith("Req")) {
                length = simpleName.length() - 3;
            }
            reqHead.cmdId = com.tencent.tmassistantbase.jce.JceCmd.convert(simpleName).value();
            reqHead.qua = com.tencent.tmassistantbase.util.k.a().d;
            reqHead.phoneGuid = com.tencent.tmassistantbase.util.k.a().f();
            com.tencent.tmassistantbase.jce.Terminal terminal = new com.tencent.tmassistantbase.jce.Terminal();
            terminal.androidId = com.tencent.tmassistantbase.util.k.a().e();
            terminal.androidIdSdCard = com.tencent.tmassistantbase.util.k.a().f();
            terminal.imei = com.tencent.tmassistantbase.util.k.a().g();
            terminal.imsi = com.tencent.tmassistantbase.util.k.a().h();
            terminal.macAdress = com.tencent.tmassistantbase.util.k.a().k();
            reqHead.terminal = terminal;
            reqHead.terminalExtra = com.tencent.tmassistantbase.util.k.a().r();
            reqHead.assistantAPILevel = com.tencent.tmassistantbase.util.k.a().n();
            reqHead.assistantVersionCode = com.tencent.tmassistantbase.util.k.a().o();
            reqHead.hostPackageName = com.tencent.tmassistantbase.util.k.b(com.tencent.tmassistantbase.util.k.a().b());
            reqHead.hostVersionCode = com.tencent.tmassistantbase.util.k.c(com.tencent.tmassistantbase.util.k.a().b());
            com.tencent.tmassistantbase.jce.SdkInfo sdkInfo = new com.tencent.tmassistantbase.jce.SdkInfo();
            com.tencent.tmassistantbase.util.k.a();
            sdkInfo.name = "selfUpdate";
            com.tencent.tmassistantbase.util.k.a();
            sdkInfo.versionCode = 3010;
            com.tencent.tmassistantbase.util.k.a();
            sdkInfo.versionName = "3.0.1";
            com.tencent.tmassistantbase.util.k.a();
            sdkInfo.builderNum = "33";
            reqHead.sdkInfo = sdkInfo;
            romInfo = new com.tencent.tmassistantbase.jce.RomInfo();
            romInfo.sysVersionCode = com.tencent.tmassistantbase.util.k.e(java.lang.String.valueOf(android.os.Build.VERSION.SDK_INT));
            romInfo.sysVersionName = com.tencent.tmassistantbase.util.k.e(android.os.Build.VERSION.RELEASE);
            if (com.tencent.tmassistantbase.util.k.a().b() != null) {
                romInfo.sysId = android.provider.Settings.Secure.getString(com.tencent.tmassistantbase.util.k.a().b().getContentResolver(), com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_ANDROID_ID_PHONE);
            }
            reqHead.romInfo = romInfo;
            com.tencent.tmassistantbase.b.c cVarD = com.tencent.tmassistantbase.b.d.d();
            com.tencent.tmassistantbase.jce.Net net = new com.tencent.tmassistantbase.jce.Net();
            net.netType = (byte) com.tencent.tmassistantbase.util.j.a(java.lang.Integer.valueOf(cVarD.f1009a.b()));
            net.isWap = cVarD.d ? (byte) 1 : (byte) 0;
            net.extNetworkOperator = cVarD.b;
            net.extNetworkType = cVarD.c;
            reqHead.net = net;
            reqHead.yybVersion = com.tencent.tmassistantbase.util.k.a().o();
            return reqHead;
        }
        length = simpleName.length() - 7;
        simpleName = simpleName.substring(0, length);
        reqHead.cmdId = com.tencent.tmassistantbase.jce.JceCmd.convert(simpleName).value();
        reqHead.qua = com.tencent.tmassistantbase.util.k.a().d;
        reqHead.phoneGuid = com.tencent.tmassistantbase.util.k.a().f();
        com.tencent.tmassistantbase.jce.Terminal terminal2 = new com.tencent.tmassistantbase.jce.Terminal();
        terminal2.androidId = com.tencent.tmassistantbase.util.k.a().e();
        terminal2.androidIdSdCard = com.tencent.tmassistantbase.util.k.a().f();
        terminal2.imei = com.tencent.tmassistantbase.util.k.a().g();
        terminal2.imsi = com.tencent.tmassistantbase.util.k.a().h();
        terminal2.macAdress = com.tencent.tmassistantbase.util.k.a().k();
        reqHead.terminal = terminal2;
        reqHead.terminalExtra = com.tencent.tmassistantbase.util.k.a().r();
        reqHead.assistantAPILevel = com.tencent.tmassistantbase.util.k.a().n();
        reqHead.assistantVersionCode = com.tencent.tmassistantbase.util.k.a().o();
        reqHead.hostPackageName = com.tencent.tmassistantbase.util.k.b(com.tencent.tmassistantbase.util.k.a().b());
        reqHead.hostVersionCode = com.tencent.tmassistantbase.util.k.c(com.tencent.tmassistantbase.util.k.a().b());
        com.tencent.tmassistantbase.jce.SdkInfo sdkInfo2 = new com.tencent.tmassistantbase.jce.SdkInfo();
        com.tencent.tmassistantbase.util.k.a();
        sdkInfo2.name = "selfUpdate";
        com.tencent.tmassistantbase.util.k.a();
        sdkInfo2.versionCode = 3010;
        com.tencent.tmassistantbase.util.k.a();
        sdkInfo2.versionName = "3.0.1";
        com.tencent.tmassistantbase.util.k.a();
        sdkInfo2.builderNum = "33";
        reqHead.sdkInfo = sdkInfo2;
        romInfo = new com.tencent.tmassistantbase.jce.RomInfo();
        romInfo.sysVersionCode = com.tencent.tmassistantbase.util.k.e(java.lang.String.valueOf(android.os.Build.VERSION.SDK_INT));
        romInfo.sysVersionName = com.tencent.tmassistantbase.util.k.e(android.os.Build.VERSION.RELEASE);
        if (com.tencent.tmassistantbase.util.k.a().b() != null) {
            romInfo.sysId = android.provider.Settings.Secure.getString(com.tencent.tmassistantbase.util.k.a().b().getContentResolver(), com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_ANDROID_ID_PHONE);
        }
        reqHead.romInfo = romInfo;
        com.tencent.tmassistantbase.b.c cVarD2 = com.tencent.tmassistantbase.b.d.d();
        com.tencent.tmassistantbase.jce.Net net2 = new com.tencent.tmassistantbase.jce.Net();
        net2.netType = (byte) com.tencent.tmassistantbase.util.j.a(java.lang.Integer.valueOf(cVarD2.f1009a.b()));
        net2.isWap = cVarD2.d ? (byte) 1 : (byte) 0;
        net2.extNetworkOperator = cVarD2.b;
        net2.extNetworkType = cVarD2.c;
        reqHead.net = net2;
        reqHead.yybVersion = com.tencent.tmassistantbase.util.k.a().o();
        return reqHead;
    }

    public static com.tencent.tmassistantbase.jce.Response a(byte[] bArr) {
        if (bArr != null && bArr.length >= 4) {
            com.tencent.tmassistantbase.jce.Response response = new com.tencent.tmassistantbase.jce.Response();
            try {
                com.qq.taf.jce.JceInputStream jceInputStream = new com.qq.taf.jce.JceInputStream(bArr);
                jceInputStream.setServerEncoding(com.unisound.b.f.b);
                response.readFrom(jceInputStream);
                if (response.head.ret == 0) {
                    if ((response.head.encryptWithPack & 2) == 2) {
                        response.body = b(response.body, "ji*9^&43U0X-~./(".getBytes());
                    }
                    if ((response.head.encryptWithPack & 1) == 1) {
                        response.body = com.tencent.tmassistantbase.util.y.b(response.body);
                    }
                    if (!android.text.TextUtils.isEmpty(response.head.phoneGuid)) {
                        com.tencent.tmassistantbase.util.k.a().a(response.head.phoneGuid);
                    }
                }
                return response;
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static byte[] a(com.tencent.tmassistantbase.jce.Request request) {
        if (request == null) {
            return null;
        }
        request.head.encryptWithPack = (byte) 0;
        byte[] bArr = request.body;
        if (bArr.length > 256) {
            request.body = com.tencent.tmassistantbase.util.y.a(bArr);
            com.tencent.tmassistantbase.jce.ReqHead reqHead = request.head;
            reqHead.encryptWithPack = (byte) (reqHead.encryptWithPack | 1);
        }
        request.body = a(request.body, "ji*9^&43U0X-~./(".getBytes());
        com.tencent.tmassistantbase.jce.ReqHead reqHead2 = request.head;
        reqHead2.encryptWithPack = (byte) (reqHead2.encryptWithPack | 2);
        return c(request);
    }

    /* JADX WARN: Code duplicated, block: B:58:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:76:? A[SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static byte[] a(java.util.List list) throws java.lang.Throwable {
        java.io.DataOutputStream dataOutputStream;
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.io.ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            try {
                dataOutputStream = new java.io.DataOutputStream(byteArrayOutputStream);
                try {
                    try {
                        java.util.Iterator it = list.iterator();
                        while (it.hasNext()) {
                            byte[] bArr = (byte[]) it.next();
                            dataOutputStream.writeInt(bArr.length);
                            dataOutputStream.write(bArr);
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        try {
                            byteArrayOutputStream.close();
                        } catch (java.io.IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            dataOutputStream.close();
                        } catch (java.io.IOException e2) {
                            e2.printStackTrace();
                        }
                        return byteArray;
                    } catch (java.lang.Exception e3) {
                        e = e3;
                        e.printStackTrace();
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (java.io.IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                            } catch (java.io.IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        return null;
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (java.io.IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    if (dataOutputStream == null) {
                        throw th;
                    }
                    try {
                        dataOutputStream.close();
                        throw th;
                    } catch (java.io.IOException e7) {
                        e7.printStackTrace();
                        throw th;
                    }
                }
            } catch (java.lang.Exception e8) {
                e = e8;
                dataOutputStream = null;
            } catch (java.lang.Throwable th2) {
                th = th2;
                dataOutputStream = null;
                byteArrayOutputStream2 = byteArrayOutputStream;
                if (byteArrayOutputStream2 != null) {
                    byteArrayOutputStream2.close();
                }
                if (dataOutputStream == null) {
                    throw th;
                }
                dataOutputStream.close();
                throw th;
            }
        } catch (java.lang.Exception e9) {
            e = e9;
            byteArrayOutputStream = null;
            dataOutputStream = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            dataOutputStream = null;
            if (byteArrayOutputStream2 != null) {
                byteArrayOutputStream2.close();
            }
            if (dataOutputStream == null) {
                throw th;
            }
            dataOutputStream.close();
            throw th;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        return new com.tencent.tmassistantbase.util.g().b(bArr, bArr2);
    }

    public static com.qq.taf.jce.JceStruct b(byte[] bArr, java.lang.Class cls) {
        if (bArr == null) {
            return null;
        }
        try {
            com.qq.taf.jce.JceInputStream jceInputStream = new com.qq.taf.jce.JceInputStream(bArr);
            jceInputStream.setServerEncoding(com.unisound.b.f.b);
            com.qq.taf.jce.JceStruct jceStruct = (com.qq.taf.jce.JceStruct) cls.newInstance();
            jceStruct.readFrom(jceInputStream);
            return jceStruct;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static com.tencent.tmassistantbase.jce.Request b(com.qq.taf.jce.JceStruct jceStruct) {
        if (jceStruct == null) {
            return null;
        }
        com.tencent.tmassistantbase.jce.Request request = new com.tencent.tmassistantbase.jce.Request();
        request.head = a(jceStruct);
        request.body = c(jceStruct);
        return request;
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        return new com.tencent.tmassistantbase.util.g().a(bArr, bArr2);
    }

    public static byte[] c(com.qq.taf.jce.JceStruct jceStruct) {
        if (jceStruct == null) {
            return null;
        }
        com.qq.taf.jce.JceOutputStream jceOutputStream = new com.qq.taf.jce.JceOutputStream();
        jceOutputStream.setServerEncoding(com.unisound.b.f.b);
        jceStruct.writeTo(jceOutputStream);
        return jceOutputStream.toByteArray();
    }

    private static com.qq.taf.jce.JceStruct d(com.qq.taf.jce.JceStruct jceStruct) {
        if (jceStruct == null) {
            return null;
        }
        java.lang.String name = jceStruct.getClass().getName();
        try {
            return (com.qq.taf.jce.JceStruct) java.lang.Class.forName(name.substring(0, name.length() - 7) + "Response").newInstance();
        } catch (java.lang.ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (java.lang.IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (java.lang.InstantiationException e3) {
            e3.printStackTrace();
            return null;
        }
    }
}
