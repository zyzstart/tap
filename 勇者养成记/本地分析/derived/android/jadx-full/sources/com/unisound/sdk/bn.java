package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class bn implements com.unisound.b.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.unisound.sdk.bg f1538a;

    bn(com.unisound.sdk.bg bgVar) {
        this.f1538a = bgVar;
    }

    @Override // com.unisound.b.a.c
    public void a(java.lang.String str) {
        com.unisound.common.y.b("SpeechUnderstanderInterface init activate result= " + str);
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            java.lang.String string = jSONObject.getString("returnCode");
            android.content.SharedPreferences.Editor editorEdit = this.f1538a.an.getSharedPreferences("ACTIVITY_FLAG", 0).edit();
            if (string.equals("dc_0000")) {
                editorEdit.putString("activityFlag", "activity success");
                java.lang.String string2 = new org.json.JSONObject(jSONObject.getString("[REDACTED]")).getString("[REDACTED]");
                if (!android.text.TextUtils.isEmpty(string2)) {
                    this.f1538a.d(this.f1538a.x, com.unisound.c.a.a(this.f1538a.x), string2);
                }
                this.f1538a.R();
                editorEdit.commit();
                this.f1538a.ap.sendEmptyMessage(40);
                return;
            }
            com.unisound.common.y.a(com.unisound.common.y.v, "activate errorCode = ", string);
            if (string.equals("dc_0002")) {
                this.f1538a.refreshActivate();
                return;
            }
            if (string.equals("dc_0006") && this.f1538a.aw) {
                this.f1538a.aN.a(0);
                this.f1538a.aw = false;
                return;
            }
            if (string.equals("dc_0003")) {
                this.f1538a.q(com.unisound.client.ErrorCode.ASR_SDK_ACTIVATE_ERROR);
                this.f1538a.q(com.unisound.client.ErrorCode.ASR_SDK_ACTIVATE_SIGN_ERROR);
            } else if (string.equals("dc_0004")) {
                this.f1538a.q(com.unisound.client.ErrorCode.ASR_SDK_ACTIVATE_ERROR);
                this.f1538a.q(com.unisound.client.ErrorCode.ASR_SDK_ACTIVATE_NO_PERMISSION);
            } else if (string.equals("dc_0005")) {
                this.f1538a.q(com.unisound.client.ErrorCode.ASR_SDK_ACTIVATE_ERROR);
                this.f1538a.q(com.unisound.client.ErrorCode.ASR_SDK_ACTIVATE_OVER_MAX_ACT_FREQUENCY);
            }
            this.f1538a.d(this.f1538a.x, com.unisound.c.a.a(this.f1538a.x), "");
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
