package com.tencent.tmassistantsdk.internal.openSDK.param;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static int f1099a;

    public static int a(com.qq.taf.jce.JceStruct jceStruct) {
        if (jceStruct == null) {
            return -1;
        }
        java.lang.String simpleName = jceStruct.getClass().getSimpleName();
        return com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCCmd.convert(simpleName.substring(0, simpleName.length() - 7)).value();
    }

    public static com.qq.taf.jce.JceStruct a(com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCResponse iPCResponse) {
        com.qq.taf.jce.JceStruct jceStructA = a(com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCCmd.convert(iPCResponse.head.cmdId).toString());
        if (jceStructA != null) {
            byte[] bArr = iPCResponse.body;
            if (bArr.length > 0) {
                try {
                    com.qq.taf.jce.JceInputStream jceInputStream = new com.qq.taf.jce.JceInputStream(bArr);
                    jceInputStream.setServerEncoding(com.unisound.b.f.b);
                    jceStructA.readFrom(jceInputStream);
                    return jceStructA;
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    private static com.qq.taf.jce.JceStruct a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (com.qq.taf.jce.JceStruct) java.lang.Class.forName((com.tencent.tmassistantsdk.internal.openSDK.param.a.class.getPackage().getName() + ".jce." + str) + "Response").newInstance();
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

    public static com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCRequest a(com.qq.taf.jce.JceStruct jceStruct, java.lang.String str) {
        if (jceStruct == null) {
            return null;
        }
        com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCRequest iPCRequest = new com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCRequest();
        com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCHead iPCHead = new com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCHead();
        int i = f1099a;
        f1099a = i + 1;
        iPCHead.requestId = i;
        iPCHead.cmdId = a(jceStruct);
        iPCHead.hostPackageName = com.tencent.tmassistantbase.util.k.b(com.tencent.tmassistantbase.util.k.a().b());
        iPCHead.hostVersionCode = java.lang.String.valueOf(com.tencent.tmassistantbase.util.k.c(com.tencent.tmassistantbase.util.k.a().b()));
        iPCHead.traceId = str;
        iPCRequest.head = iPCHead;
        iPCRequest.body = b(jceStruct);
        return iPCRequest;
    }

    public static com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCResponse a(byte[] bArr) {
        if (bArr != null && bArr.length >= 4) {
            com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCResponse iPCResponse = new com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCResponse();
            try {
                com.qq.taf.jce.JceInputStream jceInputStream = new com.qq.taf.jce.JceInputStream(bArr);
                jceInputStream.setServerEncoding(com.unisound.b.f.b);
                iPCResponse.readFrom(jceInputStream);
                if (!android.text.TextUtils.isEmpty(iPCResponse.head.hostPackageName)) {
                    iPCResponse.body = com.tencent.tmassistantbase.common.d.b(iPCResponse.body, "ji*9^&43U0X-~./(".getBytes());
                }
                return iPCResponse;
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static byte[] a(com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCRequest iPCRequest) {
        if (iPCRequest == null) {
            return null;
        }
        iPCRequest.body = com.tencent.tmassistantbase.common.d.a(iPCRequest.body, "ji*9^&43U0X-~./(".getBytes());
        return b(iPCRequest);
    }

    public static byte[] b(com.qq.taf.jce.JceStruct jceStruct) {
        return com.tencent.tmassistantbase.common.d.c(jceStruct);
    }
}
