package oicq.wlogin_sdk.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class WtloginMsfListener implements java.lang.Runnable {
    public static java.lang.String CLIENT_CLASSNAME = "com.tencent.mobileqq.msf.core.auth.WtProvider";
    static java.lang.Object TicketMgr;
    private static long __seq;
    private byte[] data;
    private boolean flag;
    private int ret;
    private java.lang.String ret_serviceCmd;
    private java.lang.String ret_uin;
    private java.lang.String serviceCmd;
    private int timeout;
    private java.lang.String uin;
    private oicq.wlogin_sdk.request.WUserSigInfo userSigInfo;
    private static final java.lang.Object __SyncSeq = new java.lang.Object();
    private static final java.lang.Object __SyncCB = new java.lang.Object();
    private static java.util.Map __cbs = new java.util.HashMap();
    private final java.util.concurrent.Semaphore semp = new java.util.concurrent.Semaphore(1);
    private byte[] ret_data = null;
    private boolean ret_success = false;

    public WtloginMsfListener(java.lang.String str, java.lang.String str2, byte[] bArr, int i, boolean z, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        this.uin = str == null ? "0" : str;
        this.serviceCmd = str2 == null ? "" : str2;
        this.data = bArr == null ? new byte[0] : bArr;
        this.timeout = i <= 0 ? com.tencent.smtt.sdk.TbsReaderView.ReaderCallback.GET_BAR_ANIMATING : i;
        this.flag = z;
        this.userSigInfo = wUserSigInfo;
    }

    private static long allocateSeq() {
        long j;
        synchronized (__SyncSeq) {
            long j2 = __seq + 1;
            __seq = j2;
            j = j2 % 2147483647L;
        }
        return j;
    }

    public static void onAsyncReceive(java.lang.String str, java.lang.String str2, long j, byte[] bArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("rpc receive ");
        sb.append(str2);
        sb.append(" seq: ");
        sb.append(j);
        sb.append(" data:");
        sb.append(bArr == null ? "null" : java.lang.Integer.valueOf(bArr.length));
        oicq.wlogin_sdk.tools.util.LOGI(sb.toString(), str);
        oicq.wlogin_sdk.request.WtloginMsfListener wtloginMsfListenerPickSeq = pickSeq(j);
        if (wtloginMsfListenerPickSeq != null) {
            wtloginMsfListenerPickSeq.onReceiveData(str, str2, bArr);
        }
    }

    public static void onAsyncReceiveFail(java.lang.String str, java.lang.String str2, long j, int i) {
        oicq.wlogin_sdk.tools.util.LOGI("rpc receive " + str2 + " seq: " + j + " fail:" + i, str);
        oicq.wlogin_sdk.request.WtloginMsfListener wtloginMsfListenerPickSeq = pickSeq(j);
        if (wtloginMsfListenerPickSeq != null) {
            wtloginMsfListenerPickSeq.onReceiveFail(str, str2, i);
        }
    }

    private static oicq.wlogin_sdk.request.WtloginMsfListener pickSeq(long j) {
        oicq.wlogin_sdk.request.WtloginMsfListener wtloginMsfListener;
        synchronized (__SyncCB) {
            wtloginMsfListener = (oicq.wlogin_sdk.request.WtloginMsfListener) __cbs.get(java.lang.Long.valueOf(j));
            __cbs.remove(java.lang.Long.valueOf(j));
        }
        return wtloginMsfListener;
    }

    private int sendRPCData(byte[] bArr, int i) {
        java.lang.Object objInvoke;
        long jAllocateSeq = allocateSeq();
        oicq.wlogin_sdk.tools.util.LOGI("sendRPCData seq: " + jAllocateSeq, "");
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("mqq.manager.TicketManager");
            if (TicketMgr == null) {
                java.lang.Class<?> cls2 = java.lang.Class.forName("com.tencent.common.app.BaseApplicationImpl");
                java.lang.Class<?> cls3 = java.lang.Class.forName("mqq.app.BaseActivity");
                java.lang.Class<?> cls4 = java.lang.Class.forName("mqq.app.AppRuntime");
                java.lang.reflect.Method method = cls2.getMethod("getApplication", new java.lang.Class[0]);
                java.lang.reflect.Method method2 = cls2.getMethod("waitAppRuntime", cls3);
                java.lang.reflect.Method method3 = cls4.getMethod("getManager", java.lang.Integer.TYPE);
                java.lang.reflect.Field field = cls4.getField("TICKET_MANAGER");
                java.lang.Object objInvoke2 = method.invoke(null, new java.lang.Object[0]);
                if (objInvoke2 != null && (objInvoke = method2.invoke(objInvoke2, null)) != null) {
                    TicketMgr = method3.invoke(objInvoke, field.get(cls4));
                }
            }
            int iIntValue = java.lang.Integer.valueOf(cls.getMethod("sendRPCData", java.lang.Long.TYPE, java.lang.String.class, java.lang.String.class, byte[].class, java.lang.Integer.TYPE).invoke(TicketMgr, java.lang.Long.valueOf(jAllocateSeq), this.uin, this.serviceCmd, bArr.clone(), java.lang.Integer.valueOf(i)).toString()).intValue();
            if (iIntValue != 0) {
                return iIntValue;
            }
            synchronized (__SyncCB) {
                __cbs.put(java.lang.Long.valueOf(jAllocateSeq), this);
            }
            this.semp.acquire();
            return 99;
        } catch (java.lang.Exception e) {
            oicq.wlogin_sdk.tools.util.printException(e, this.uin);
            return -1000;
        }
    }

    public void Cancel() {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName(CLIENT_CLASSNAME);
            cls.getMethod(com.unisound.common.y.G, oicq.wlogin_sdk.request.WUserSigInfo.class).invoke(cls, this.userSigInfo);
        } catch (java.lang.Exception e) {
            oicq.wlogin_sdk.tools.util.printException(e, this.uin);
        }
    }

    public byte[] RecvData() {
        try {
            this.semp.acquire();
            if (!this.ret_success) {
                return null;
            }
            if (this.ret_uin != null && this.ret_uin.equals(this.uin)) {
                if (this.ret_serviceCmd != null && this.ret_serviceCmd.equals(this.serviceCmd)) {
                    this.semp.release();
                    return this.ret_data;
                }
                this.ret = oicq.wlogin_sdk.tools.util.E_PK_LEN;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("ret_serviceCmd: ");
                sb.append(this.ret_serviceCmd == null ? "null" : this.ret_serviceCmd);
                sb.append(", serviceCmd:");
                sb.append(this.serviceCmd == null ? "null" : this.serviceCmd);
                oicq.wlogin_sdk.tools.util.LOGI(sb.toString(), "");
                return null;
            }
            this.ret = oicq.wlogin_sdk.tools.util.E_PK_LEN;
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("ret_uin: ");
            sb2.append(this.ret_uin == null ? "null" : this.ret_uin);
            sb2.append(", uin: ");
            sb2.append(this.uin == null ? "null" : this.uin);
            oicq.wlogin_sdk.tools.util.LOGI(sb2.toString(), "");
            return null;
        } catch (java.lang.InterruptedException e) {
            oicq.wlogin_sdk.tools.util.printException(e, this.uin);
            return null;
        }
    }

    public int SendData(byte[] bArr, int i) {
        if (!oicq.wlogin_sdk.request.t.ar) {
            java.lang.String strL = oicq.wlogin_sdk.request.t.l();
            oicq.wlogin_sdk.tools.util.LOGI("mqq process: " + strL, "");
            if (!strL.endsWith(":MSF")) {
                return sendRPCData(bArr, i);
            }
        }
        try {
            oicq.wlogin_sdk.tools.util.LOGI("msf sendData", "");
            java.lang.Class<?> cls = java.lang.Class.forName(CLIENT_CLASSNAME);
            int iIntValue = java.lang.Integer.valueOf(cls.getMethod("sendData", oicq.wlogin_sdk.request.WUserSigInfo.class, java.lang.String.class, java.lang.String.class, byte[].class, java.lang.Integer.TYPE, java.lang.Boolean.TYPE, oicq.wlogin_sdk.request.WtloginMsfListener.class).invoke(cls, this.userSigInfo, this.uin, this.serviceCmd, bArr.clone(), java.lang.Integer.valueOf(i), java.lang.Boolean.valueOf(this.flag), this).toString()).intValue();
            if (iIntValue <= 0) {
                return iIntValue;
            }
            this.semp.acquire();
            return iIntValue;
        } catch (java.lang.Exception e) {
            oicq.wlogin_sdk.tools.util.printException(e, this.uin);
            return -1000;
        }
    }

    public int getRet() {
        return this.ret;
    }

    public byte[] getRetData() {
        return this.ret_data;
    }

    public void onReceiveData(java.lang.String str, java.lang.String str2, byte[] bArr) {
        this.ret_success = true;
        this.ret_uin = str;
        this.ret_serviceCmd = str2;
        this.ret = 0;
        this.ret_data = bArr;
        this.semp.release();
    }

    public void onReceiveFail(java.lang.String str, java.lang.String str2, int i) {
        this.ret_success = false;
        this.ret_uin = str;
        this.ret_serviceCmd = str2;
        this.ret = i;
        this.semp.release();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            int iSendData = SendData(this.data, this.timeout);
            this.ret = iSendData;
            if (iSendData > 0) {
                if (RecvData() == null) {
                    this.ret_data = null;
                }
            } else {
                oicq.wlogin_sdk.tools.util.LOGI("msf request send data failed, ret=" + this.ret, "");
            }
        } catch (java.lang.Exception unused) {
        }
    }
}
