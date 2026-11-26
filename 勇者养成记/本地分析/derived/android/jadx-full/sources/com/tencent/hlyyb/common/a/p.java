package com.tencent.hlyyb.common.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.json.JSONObject f537a;

    public final synchronized java.lang.String a() {
        org.json.JSONObject jSONObject = this.f537a;
        if (jSONObject == null) {
            return "";
        }
        return jSONObject.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized java.lang.String a(java.lang.String str, int i, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        boolean z;
        if (this.f537a != null && !android.text.TextUtils.isEmpty(str)) {
            org.json.JSONObject jSONObjectOptJSONObject = this.f537a.optJSONObject(com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameFreeloginResponse.HTTP_RESP_PARAM_DATA);
            if (jSONObjectOptJSONObject == null) {
                return "";
            }
            org.json.JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(str);
            if (jSONObjectOptJSONObject2 == null) {
                return "";
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.Iterator<java.lang.String> itKeys = jSONObjectOptJSONObject2.keys();
            while (itKeys.hasNext()) {
                java.lang.String next = itKeys.next();
                if (!android.text.TextUtils.isEmpty(next)) {
                    if (next.equals("deviceid")) {
                        return jSONObjectOptJSONObject2.optString("deviceid");
                    }
                    com.tencent.hlyyb.common.a.q qVar = new com.tencent.hlyyb.common.a.q(this, next, i, str2, str3, str4, str5);
                    if (qVar.b) {
                        arrayList.add(qVar);
                    }
                }
            }
            if (arrayList.size() == 0) {
                return "";
            }
            if (arrayList.size() == 1) {
                return jSONObjectOptJSONObject2.optString(((com.tencent.hlyyb.common.a.q) arrayList.get(0)).f538a);
            }
            com.tencent.hlyyb.common.a.q qVar2 = (com.tencent.hlyyb.common.a.q) arrayList.get(0);
            for (int i2 = 1; i2 < arrayList.size(); i2++) {
                com.tencent.hlyyb.common.a.q qVar3 = (com.tencent.hlyyb.common.a.q) arrayList.get(i2);
                if (!qVar2.b || ((z = qVar3.c) == qVar2.c && (z = qVar3.d) == qVar2.d && (z = qVar3.e) == qVar2.e && (z = qVar3.f) == qVar2.f && (z = qVar3.g) == qVar2.g)) {
                    z = true;
                }
                if (z) {
                    qVar2 = qVar3;
                }
            }
            return jSONObjectOptJSONObject2.optString(qVar2.f538a);
        }
        return "";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized void a(java.lang.String str) {
        org.json.JSONObject jSONObjectOptJSONObject;
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            if (this.f537a == null) {
                this.f537a = jSONObject;
                return;
            }
            org.json.JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameFreeloginResponse.HTTP_RESP_PARAM_DATA);
            java.lang.String strOptString = jSONObject.optString(com.tencent.ysdk.shell.framework.request.HttpRequest.PARAM_VERSION);
            if (jSONObjectOptJSONObject2 != null && !android.text.TextUtils.isEmpty(strOptString)) {
                org.json.JSONObject jSONObjectOptJSONObject3 = this.f537a.optJSONObject(com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameFreeloginResponse.HTTP_RESP_PARAM_DATA);
                if (jSONObjectOptJSONObject3 == null) {
                    this.f537a.putOpt(com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameFreeloginResponse.HTTP_RESP_PARAM_DATA, jSONObjectOptJSONObject2);
                } else {
                    java.util.Iterator<java.lang.String> itKeys = jSONObjectOptJSONObject2.keys();
                    while (itKeys.hasNext()) {
                        java.lang.String next = itKeys.next();
                        if (!android.text.TextUtils.isEmpty(next) && (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject(next)) != null) {
                            jSONObjectOptJSONObject3.putOpt(next, jSONObjectOptJSONObject);
                        }
                    }
                }
                this.f537a.put(com.tencent.ysdk.shell.framework.request.HttpRequest.PARAM_VERSION, strOptString);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public final synchronized void b() {
        this.f537a = null;
    }

    public final synchronized java.lang.String c() {
        org.json.JSONObject jSONObject = this.f537a;
        if (jSONObject == null) {
            return "";
        }
        return jSONObject.optString(com.tencent.ysdk.shell.framework.request.HttpRequest.PARAM_VERSION);
    }
}
