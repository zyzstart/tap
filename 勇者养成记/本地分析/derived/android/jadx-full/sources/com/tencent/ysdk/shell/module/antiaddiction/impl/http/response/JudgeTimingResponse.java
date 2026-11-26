package com.tencent.ysdk.shell.module.antiaddiction.impl.http.response;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class JudgeTimingResponse extends com.tencent.ysdk.shell.framework.request.HttpResponse {
    private static final java.lang.String PARAM_CONTEXT = "context";
    private static final java.lang.String PARAM_DURATION = "duration";
    private static final java.lang.String PARAM_INSTRUCTIONS = "instructions";
    private static final java.lang.String PARAM_TRACEID = "traceId";
    private java.lang.String mContext;
    private int mDuration;
    private java.util.List<com.tencent.ysdk.module.antiaddiction.impl.model.SingleInstructionModel> mInstructionList;
    private java.lang.String mTraceId;

    public java.lang.String getContext() {
        return this.mContext;
    }

    public int getDuration() {
        return this.mDuration;
    }

    public java.util.List<com.tencent.ysdk.module.antiaddiction.impl.model.SingleInstructionModel> getInstructionList() {
        return this.mInstructionList;
    }

    public java.lang.String getTraceId() {
        return this.mTraceId;
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpResponse
    public void parseJson(com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionApi.getInstance().printLogInDebug("返回数据: " + safeJSONObject.toString());
        super.parseBaseJson(safeJSONObject);
        if (this.ret == 0) {
            try {
                if (safeJSONObject.has(PARAM_TRACEID)) {
                    this.mTraceId = safeJSONObject.optString(PARAM_TRACEID);
                }
                if (safeJSONObject.has(PARAM_CONTEXT)) {
                    this.mContext = safeJSONObject.optString(PARAM_CONTEXT);
                }
                if (safeJSONObject.has(PARAM_INSTRUCTIONS)) {
                    org.json.JSONArray jSONArray = safeJSONObject.getJSONArray(PARAM_INSTRUCTIONS);
                    if (jSONArray.length() > 0) {
                        this.mInstructionList = new java.util.ArrayList();
                        for (int i = 0; i < jSONArray.length(); i++) {
                            this.mInstructionList.add(new com.tencent.ysdk.module.antiaddiction.impl.model.SingleInstructionModel(jSONArray.getJSONObject(i)));
                        }
                    }
                }
                if (safeJSONObject.has(PARAM_DURATION)) {
                    this.mDuration = safeJSONObject.optInt(PARAM_DURATION);
                }
            } catch (org.json.JSONException unused) {
                com.tencent.ysdk.shell.libware.file.Logger.e("JudgeTimingResponse parse json error");
            }
        }
    }
}
