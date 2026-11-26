package com.unisound.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a extends android.os.Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.unisound.b.a.c f1447a;

    public a(android.os.Looper looper) {
        super(looper);
    }

    private java.lang.String a(int i) {
        java.lang.String str;
        java.lang.String str2;
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put(com.tencent.ysdk.framework.dynamic.constant.PluginConst.EVENT_PARAM_ERROR_CODE, i);
            jSONObject.put("registerCode", "");
            switch (i) {
                case 1011:
                    str = "message";
                    str2 = "没有网络连接错误";
                    break;
                case 1012:
                    str = "message";
                    str2 = "异常错误";
                    break;
                case 1013:
                    str = "message";
                    str2 = "返回结果为空错误";
                    break;
                case 1014:
                    str = "message";
                    str2 = "无效激活类型";
                    break;
                case 1015:
                    str = "message";
                    str2 = "激活状态错误，已经有激活操作正在执行";
                    break;
                default:
                    str = "message";
                    str2 = "未知错误";
                    break;
            }
            jSONObject.put(str, str2);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public void a(com.unisound.b.a.c cVar) {
        this.f1447a = cVar;
    }

    @Override // android.os.Handler
    public void handleMessage(android.os.Message message) {
        java.lang.String str;
        com.unisound.b.a.c cVar;
        int i;
        if (this.f1447a == null) {
            com.unisound.b.i.b("ActivatorHandler listener == null");
            return;
        }
        int i2 = message.what;
        if (i2 == 102) {
            str = "ActivatorHandler GET_RESULT";
        } else {
            if (i2 != 120) {
                switch (i2) {
                    case 106:
                        com.unisound.b.i.a("ActivatorHandler RESPONSE_IS_NULL_ERROR");
                        cVar = this.f1447a;
                        i = 1013;
                        break;
                    case 107:
                        com.unisound.b.i.a("ActivatorHandler EXCEPTION_ERROR");
                        cVar = this.f1447a;
                        i = 1012;
                        break;
                    case 108:
                        com.unisound.b.i.a("ActivatorHandler ACTIVATOR_STATUS_ERROR_MESSAGE");
                        cVar = this.f1447a;
                        i = 1015;
                        break;
                    case 109:
                        com.unisound.b.i.a("ActivatorHandler NO_NETWORK_ERROR");
                        cVar = this.f1447a;
                        i = 1011;
                        break;
                    case 110:
                        com.unisound.b.i.a("ActivatorHandler INVALID_URL_TYPE_ERROR");
                        cVar = this.f1447a;
                        i = 1014;
                        break;
                    default:
                        return;
                }
                cVar.a(a(i));
                return;
            }
            str = "ActivatorHandler NO_READ_PHONE_STATE_PERMISSION";
        }
        com.unisound.b.i.c(str);
        this.f1447a.a((java.lang.String) message.obj);
    }
}
