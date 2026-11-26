package com.tencent.ysdk.shell.module.antiaddiction.impl.model;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class LoginJudgeModel {
    private static final java.lang.String PARAM_CONTEXT = "context";
    private static final java.lang.String PARAM_INSTRUCTIONS = "instructions";
    private static final java.lang.String PARAM_MSG = "msg";
    private static final java.lang.String PARAM_RET = "ret";
    private static final java.lang.String PARAM_TRACEID = "traceId";
    public java.lang.String context;
    public java.util.List<com.tencent.ysdk.module.antiaddiction.impl.model.SingleInstructionModel> instructionList;
    public java.lang.String msg;
    public int ret;
    public java.lang.String traceId;

    public LoginJudgeModel(org.json.JSONObject jSONObject) {
        org.json.JSONArray jSONArrayOptJSONArray;
        this.ret = -1;
        if (jSONObject != null) {
            try {
                if (jSONObject.has("ret")) {
                    this.ret = jSONObject.optInt("ret");
                    if (jSONObject.has("msg")) {
                        this.msg = jSONObject.optString("msg");
                    }
                    if (jSONObject.has(PARAM_TRACEID)) {
                        this.traceId = jSONObject.optString(PARAM_TRACEID);
                    }
                    if (jSONObject.has(PARAM_CONTEXT)) {
                        this.context = jSONObject.optString(PARAM_CONTEXT);
                    }
                    if (!jSONObject.has(PARAM_INSTRUCTIONS) || (jSONArrayOptJSONArray = jSONObject.optJSONArray(PARAM_INSTRUCTIONS)) == null || jSONArrayOptJSONArray.length() <= 0) {
                        return;
                    }
                    this.instructionList = new java.util.ArrayList();
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        this.instructionList.add(new com.tencent.ysdk.module.antiaddiction.impl.model.SingleInstructionModel(jSONArrayOptJSONArray.getJSONObject(i)));
                    }
                }
            } catch (java.lang.Throwable unused) {
                com.tencent.ysdk.libware.file.Logger.e("LoginJudgeModel parse json error");
            }
        }
    }
}
