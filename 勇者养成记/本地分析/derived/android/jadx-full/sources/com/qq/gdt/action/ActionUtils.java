package com.qq.gdt.action;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ActionUtils {
    public static final java.lang.String CONTENT_ID = "content_id";
    public static final java.lang.String CONTENT_NAME = "content_name";
    public static final java.lang.String CONTENT_NUMBER = "content_number";
    public static final java.lang.String CONTENT_TYPE = "content_type";
    public static final java.lang.String IS_SUCCESS = "is_success";
    public static final java.lang.String IS_VIRTUAL_CURRENT = "is_virtual_currency";
    public static final java.lang.String LEVEL = "level";
    public static final java.lang.String METHOD = "method";
    public static final java.lang.String PAYMENT_AMOUNT = "value";
    public static final java.lang.String PAYMENT_CHANNEL = "payment_channel";
    public static final java.lang.String QUEST_DESC = "quest_desc";
    public static final java.lang.String QUEST_ID = "quest_id";
    public static final java.lang.String QUEST_NAME = "quest_name";
    public static final java.lang.String QUEST_NUMBER = "quest_number";
    public static final java.lang.String QUEST_TYPE = "quest_type";
    public static final java.lang.String RATE_VALUE = "rate_value";
    public static final java.lang.String REAL_CURRENCY_TYPE = "real_currency_type";
    public static final java.lang.String ROLE = "role";
    public static final java.lang.String SHARE_CHANNEL = "share_channel";
    public static final java.lang.String VIRTUAL_CURRENCY_TYPE = "virtual_currency_type";

    public static void onAddPaymentChannel(java.lang.String str, boolean z) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.putOpt(PAYMENT_CHANNEL, str);
            jSONObject.putOpt(IS_SUCCESS, java.lang.Boolean.valueOf(z));
            com.qq.gdt.action.h.l.a(jSONObject.toString(), new java.lang.Object[0]);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        com.qq.gdt.action.GDTAction.logAction("ADD_PAYMENT", jSONObject);
    }

    public static void onAddToCart(java.lang.String str, java.lang.String str2, java.lang.String str3, int i, boolean z) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.putOpt(CONTENT_TYPE, str);
            jSONObject.putOpt(CONTENT_NAME, str2);
            jSONObject.putOpt(CONTENT_ID, str3);
            jSONObject.putOpt(CONTENT_NUMBER, java.lang.Integer.valueOf(i));
            jSONObject.putOpt(IS_SUCCESS, java.lang.Boolean.valueOf(z));
            com.qq.gdt.action.h.l.a(jSONObject.toString(), new java.lang.Object[0]);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        com.qq.gdt.action.GDTAction.logAction(com.qq.gdt.action.ActionType.ADD_TO_CART, jSONObject);
    }

    public static void onBindAccount(java.lang.String str, boolean z) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.putOpt("method", str);
            jSONObject.putOpt(IS_SUCCESS, java.lang.Boolean.valueOf(z));
            com.qq.gdt.action.h.l.a(jSONObject.toString(), new java.lang.Object[0]);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        com.qq.gdt.action.GDTAction.logAction("BIND_ACCOUNT", jSONObject);
    }

    public static void onCheckout(java.lang.String str, java.lang.String str2, java.lang.String str3, int i, boolean z, java.lang.String str4, java.lang.String str5, boolean z2) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.putOpt(CONTENT_TYPE, str);
            jSONObject.putOpt(CONTENT_NAME, str2);
            jSONObject.putOpt(CONTENT_ID, str3);
            jSONObject.putOpt(CONTENT_NUMBER, java.lang.Integer.valueOf(i));
            jSONObject.putOpt(IS_VIRTUAL_CURRENT, java.lang.Boolean.valueOf(z));
            jSONObject.putOpt(VIRTUAL_CURRENCY_TYPE, str4);
            jSONObject.putOpt(REAL_CURRENCY_TYPE, str5);
            jSONObject.putOpt(IS_SUCCESS, java.lang.Boolean.valueOf(z2));
            com.qq.gdt.action.h.l.a(jSONObject.toString(), new java.lang.Object[0]);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        com.qq.gdt.action.GDTAction.logAction(com.qq.gdt.action.ActionType.INITIATE_CHECKOUT, jSONObject);
    }

    public static void onCreateRole(java.lang.String str) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.putOpt(ROLE, str);
            com.qq.gdt.action.h.l.a(jSONObject.toString(), new java.lang.Object[0]);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        com.qq.gdt.action.GDTAction.logAction("CREATE_ROLE", jSONObject);
    }

    public static void onLogin(java.lang.String str, boolean z) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.putOpt("method", str);
            jSONObject.putOpt(IS_SUCCESS, java.lang.Boolean.valueOf(z));
            com.qq.gdt.action.h.l.a(jSONObject.toString(), new java.lang.Object[0]);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        com.qq.gdt.action.GDTAction.logAction("LOGIN", jSONObject);
    }

    public static void onPurchase(java.lang.String str, java.lang.String str2, java.lang.String str3, int i, java.lang.String str4, java.lang.String str5, int i2, boolean z) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.putOpt(CONTENT_TYPE, str);
            jSONObject.putOpt(CONTENT_NAME, str2);
            jSONObject.putOpt(CONTENT_ID, str3);
            jSONObject.putOpt(CONTENT_NUMBER, java.lang.Integer.valueOf(i));
            jSONObject.putOpt(PAYMENT_CHANNEL, str4);
            jSONObject.putOpt(REAL_CURRENCY_TYPE, str5);
            jSONObject.putOpt(REAL_CURRENCY_TYPE, str5);
            jSONObject.putOpt(IS_SUCCESS, java.lang.Boolean.valueOf(z));
            jSONObject.putOpt(PAYMENT_AMOUNT, java.lang.Integer.valueOf(i2));
            com.qq.gdt.action.h.l.a(jSONObject.toString(), new java.lang.Object[0]);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        com.qq.gdt.action.GDTAction.logAction(com.qq.gdt.action.ActionType.PURCHASE, jSONObject);
    }

    public static void onQuestFinish(java.lang.String str, java.lang.String str2, java.lang.String str3, int i, java.lang.String str4, boolean z) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.putOpt(QUEST_ID, str);
            jSONObject.putOpt(QUEST_TYPE, str2);
            jSONObject.putOpt(QUEST_NAME, str3);
            jSONObject.putOpt(QUEST_NUMBER, java.lang.Integer.valueOf(i));
            jSONObject.putOpt(QUEST_DESC, str4);
            jSONObject.putOpt(IS_SUCCESS, java.lang.Boolean.valueOf(z));
            com.qq.gdt.action.h.l.a(jSONObject.toString(), new java.lang.Object[0]);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        com.qq.gdt.action.GDTAction.logAction("QUEST", jSONObject);
    }

    public static void onRateApp(float f) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.putOpt(RATE_VALUE, java.lang.Float.valueOf(f));
            com.qq.gdt.action.h.l.a(jSONObject.toString(), new java.lang.Object[0]);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        com.qq.gdt.action.GDTAction.logAction(com.qq.gdt.action.ActionType.RATE, jSONObject);
    }

    public static void onRegister(java.lang.String str, boolean z) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.putOpt("method", str);
            jSONObject.putOpt(IS_SUCCESS, java.lang.Boolean.valueOf(z));
            com.qq.gdt.action.h.l.a(jSONObject.toString(), new java.lang.Object[0]);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        com.qq.gdt.action.GDTAction.logAction(com.qq.gdt.action.ActionType.REGISTER, jSONObject);
    }

    public static void onShare(java.lang.String str, boolean z) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.putOpt(SHARE_CHANNEL, str);
            jSONObject.putOpt(IS_SUCCESS, java.lang.Boolean.valueOf(z));
            com.qq.gdt.action.h.l.a(jSONObject.toString(), new java.lang.Object[0]);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        com.qq.gdt.action.GDTAction.logAction(com.qq.gdt.action.ActionType.SHARE, jSONObject);
    }

    public static void onUpdateLevel(int i) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.putOpt(LEVEL, java.lang.Integer.valueOf(i));
            com.qq.gdt.action.h.l.a(jSONObject.toString(), new java.lang.Object[0]);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        com.qq.gdt.action.GDTAction.logAction("UPDATE_LEVEL", jSONObject);
    }

    public static void onViewContent(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.putOpt(CONTENT_TYPE, str);
            jSONObject.putOpt(CONTENT_NAME, str2);
            jSONObject.putOpt(CONTENT_ID, str3);
            com.qq.gdt.action.h.l.a(jSONObject.toString(), new java.lang.Object[0]);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        com.qq.gdt.action.GDTAction.logAction(com.qq.gdt.action.ActionType.VIEW_CONTENT, jSONObject);
    }
}
