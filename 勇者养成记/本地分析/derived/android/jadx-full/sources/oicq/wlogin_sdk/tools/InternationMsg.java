package oicq.wlogin_sdk.tools;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class InternationMsg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static oicq.wlogin_sdk.tools.InternationMsg.a[] f1688a = {new oicq.wlogin_sdk.tools.InternationMsg.a(2052, oicq.wlogin_sdk.tools.InternationMsg.MSG_TYPE.MSG_0, "登录失败"), new oicq.wlogin_sdk.tools.InternationMsg.a(1028, oicq.wlogin_sdk.tools.InternationMsg.MSG_TYPE.MSG_0, "登錄失敗"), new oicq.wlogin_sdk.tools.InternationMsg.a(1033, oicq.wlogin_sdk.tools.InternationMsg.MSG_TYPE.MSG_0, "Unable to login"), new oicq.wlogin_sdk.tools.InternationMsg.a(2052, oicq.wlogin_sdk.tools.InternationMsg.MSG_TYPE.MSG_1, "请你稍后重试。"), new oicq.wlogin_sdk.tools.InternationMsg.a(1028, oicq.wlogin_sdk.tools.InternationMsg.MSG_TYPE.MSG_1, "請你稍後重試。"), new oicq.wlogin_sdk.tools.InternationMsg.a(1033, oicq.wlogin_sdk.tools.InternationMsg.MSG_TYPE.MSG_1, "Please try again later."), new oicq.wlogin_sdk.tools.InternationMsg.a(2052, oicq.wlogin_sdk.tools.InternationMsg.MSG_TYPE.MSG_2, "手机存储异常，请删除帐号重试。"), new oicq.wlogin_sdk.tools.InternationMsg.a(1028, oicq.wlogin_sdk.tools.InternationMsg.MSG_TYPE.MSG_2, "手機存儲異常，請刪除帳號重試。"), new oicq.wlogin_sdk.tools.InternationMsg.a(1033, oicq.wlogin_sdk.tools.InternationMsg.MSG_TYPE.MSG_2, "Phone memory error, please delete the account and try again."), new oicq.wlogin_sdk.tools.InternationMsg.a(2052, oicq.wlogin_sdk.tools.InternationMsg.MSG_TYPE.MSG_3, "请求失败，请你稍后重试。"), new oicq.wlogin_sdk.tools.InternationMsg.a(1028, oicq.wlogin_sdk.tools.InternationMsg.MSG_TYPE.MSG_3, "請求失敗，請你稍後重試。"), new oicq.wlogin_sdk.tools.InternationMsg.a(1033, oicq.wlogin_sdk.tools.InternationMsg.MSG_TYPE.MSG_3, "Request failed, please try again later."), new oicq.wlogin_sdk.tools.InternationMsg.a(2052, oicq.wlogin_sdk.tools.InternationMsg.MSG_TYPE.MSG_4, "网络超时，请你稍后重试。"), new oicq.wlogin_sdk.tools.InternationMsg.a(1028, oicq.wlogin_sdk.tools.InternationMsg.MSG_TYPE.MSG_4, "網絡超時，請你稍後重試。"), new oicq.wlogin_sdk.tools.InternationMsg.a(1033, oicq.wlogin_sdk.tools.InternationMsg.MSG_TYPE.MSG_4, "Network timeout, please try again later."), new oicq.wlogin_sdk.tools.InternationMsg.a(2052, oicq.wlogin_sdk.tools.InternationMsg.MSG_TYPE.MSG_5, "登录设备保护"), new oicq.wlogin_sdk.tools.InternationMsg.a(1028, oicq.wlogin_sdk.tools.InternationMsg.MSG_TYPE.MSG_5, "登錄設備保護"), new oicq.wlogin_sdk.tools.InternationMsg.a(1033, oicq.wlogin_sdk.tools.InternationMsg.MSG_TYPE.MSG_5, "Device Protection")};

    public enum MSG_TYPE {
        MSG_0,
        MSG_1,
        MSG_2,
        MSG_3,
        MSG_4,
        MSG_5
    }

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1689a;
        oicq.wlogin_sdk.tools.InternationMsg.MSG_TYPE b;
        java.lang.String c;

        public a(int i, oicq.wlogin_sdk.tools.InternationMsg.MSG_TYPE msg_type, java.lang.String str) {
            this.f1689a = i;
            this.b = msg_type;
            this.c = str;
        }
    }

    public static java.lang.String a(oicq.wlogin_sdk.tools.InternationMsg.MSG_TYPE msg_type) {
        int i = 0;
        while (true) {
            oicq.wlogin_sdk.tools.InternationMsg.a[] aVarArr = f1688a;
            if (i >= aVarArr.length) {
                return "";
            }
            if (msg_type == aVarArr[i].b) {
                int i2 = oicq.wlogin_sdk.request.t.u;
                oicq.wlogin_sdk.tools.InternationMsg.a[] aVarArr2 = f1688a;
                if (i2 == aVarArr2[i].f1689a) {
                    return aVarArr2[i].c;
                }
            }
            i++;
        }
    }
}
