package com.qq.gdt.action;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class GDTAction {

    public interface a {
        void a();

        void a(java.lang.String str);
    }

    private static org.json.JSONObject a(com.qq.gdt.action.a.a aVar) {
        try {
            return new org.json.JSONObject().putOpt("actionType", aVar.b()).putOpt("uniqActionId", aVar.a());
        } catch (org.json.JSONException unused) {
            return null;
        }
    }

    public static void init(android.content.Context context, java.lang.String str, java.lang.String str2) {
        com.qq.gdt.action.e.a().a(context, str, str2, null, null);
    }

    @java.lang.Deprecated
    public static void init(android.content.Context context, java.lang.String str, java.lang.String str2, com.qq.gdt.action.GDTAction.a aVar) {
        com.qq.gdt.action.e.a().a(context, str, str2, null, aVar);
    }

    public static void init(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.qq.gdt.action.e.a().a(context, str, str2, str3);
    }

    public static boolean isAutoCollectionAction(com.qq.gdt.action.a.a aVar) {
        java.lang.String strB = aVar.b();
        return "PAUSE".equals(strB) || "RESUME".equals(strB) || "TICKET".equals(strB) || "ENTER_BACKGROUND".equals(strB) || "ENTER_FOREGROUND".equals(strB);
    }

    public static void logAction(java.lang.String str) {
        logAction(str, null);
    }

    public static void logAction(java.lang.String str, org.json.JSONObject jSONObject) {
        try {
            com.qq.gdt.action.a.a aVarA = com.qq.gdt.action.d.a(str, jSONObject);
            if (!com.qq.gdt.action.e.a().b()) {
                com.qq.gdt.action.h.l.c("GDTAction未进行初始化，请先调用GDTAction的init方法成功初始化SDK后，再调用其他数据上报方法！");
                com.qq.gdt.action.f.a.a().a(1001, a(aVarA));
                return;
            }
            com.qq.gdt.action.f.a.a().a(1000, a(aVarA));
            if (!com.qq.gdt.action.h.b.a(str)) {
                com.qq.gdt.action.f.a.a().a(com.tencent.ysdk.framework.common.eFlag.QQ_NotSupportApi, a(aVarA));
                return;
            }
            com.qq.gdt.action.f.a.a().a(1004, a(aVarA));
            if (!com.qq.gdt.action.h.b.a(jSONObject)) {
                com.qq.gdt.action.f.a.a().a(1007, a(aVarA));
                return;
            }
            if (!com.qq.gdt.action.h.n.b(com.qq.gdt.action.e.a().c())) {
                com.qq.gdt.action.h.l.b("上报数据前建议在App中先申请获取动态权限！");
            }
            com.qq.gdt.action.h.b.b(str);
            if (com.qq.gdt.action.h.b.c(str)) {
                com.qq.gdt.action.e.a().a(aVarA);
            } else {
                com.qq.gdt.action.e.a().b(aVarA);
            }
        } catch (java.lang.Throwable th) {
            com.qq.gdt.action.h.l.b("Log action exception", th);
            try {
                com.qq.gdt.action.f.a.a().a(1010, new org.json.JSONObject().put(com.tencent.ysdk.framework.dynamic.constant.PluginConst.EVENT_PARAM_ERROR_CODE, -1).put("errorMsg", th.getMessage()));
            } catch (org.json.JSONException e) {
                com.qq.gdt.action.h.l.a("unexpected json exception", e);
            }
        }
    }

    public static void setUserUniqueId(java.lang.String str) {
        com.qq.gdt.action.e.a().a(str);
    }
}
