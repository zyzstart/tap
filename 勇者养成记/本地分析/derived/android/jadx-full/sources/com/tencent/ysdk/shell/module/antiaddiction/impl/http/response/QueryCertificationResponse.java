package com.tencent.ysdk.shell.module.antiaddiction.impl.http.response;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class QueryCertificationResponse extends com.tencent.ysdk.shell.framework.request.HttpResponse {
    private static final java.lang.String PARAM_ADULT_TYPE = "adultType";
    private static final java.lang.String PARAM_CERT_INFO = "certInfo";
    private static final java.lang.String PARAM_IS_REAL_NAME = "isRealName";
    private static final java.lang.String PARAM_TRACEID = "traceId";
    private com.tencent.ysdk.module.antiaddiction.model.CertificationRect mRect;
    private java.lang.String mTraceId;

    public com.tencent.ysdk.module.antiaddiction.model.CertificationRect getCertificationRect() {
        if (this.mRect == null) {
            this.mRect = new com.tencent.ysdk.module.antiaddiction.model.CertificationRect(-1, this.msg);
        }
        return this.mRect;
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpResponse
    public void parseJson(com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionApi.getInstance().printLogInDebug("返回数据: " + safeJSONObject.toString());
        super.parseBaseJson(safeJSONObject);
        if (this.ret == 1 || this.flag != 0) {
            this.mRect = new com.tencent.ysdk.module.antiaddiction.model.CertificationRect(this.flag, this.msg);
            return;
        }
        if (safeJSONObject.has(PARAM_TRACEID)) {
            this.mTraceId = safeJSONObject.optString(PARAM_TRACEID);
        }
        org.json.JSONObject jSONObjectOptJSONObject = safeJSONObject.optJSONObject(PARAM_CERT_INFO);
        if (jSONObjectOptJSONObject == null) {
            this.mRect = new com.tencent.ysdk.module.antiaddiction.model.CertificationRect(com.tencent.ysdk.framework.common.eFlag.Certification_No_Found_Error, "certification no found");
        } else {
            this.mRect = new com.tencent.ysdk.module.antiaddiction.model.CertificationRect(jSONObjectOptJSONObject.optInt(PARAM_IS_REAL_NAME), jSONObjectOptJSONObject.optInt(PARAM_ADULT_TYPE));
        }
    }
}
