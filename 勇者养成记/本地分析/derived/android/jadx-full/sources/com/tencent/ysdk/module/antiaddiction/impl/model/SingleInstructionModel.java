package com.tencent.ysdk.module.antiaddiction.impl.model;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class SingleInstructionModel {
    private static final java.lang.String PARAM_MODAL = "modal";
    private static final java.lang.String PARAM_MSG = "msg";
    private static final java.lang.String PARAM_RULE_FAMILY = "ruleFamily";
    private static final java.lang.String PARAM_RULE_NAME = "ruleName";
    private static final java.lang.String PARAM_TITLE = "title";
    private static final java.lang.String PARAM_TYPE = "type";
    private static final java.lang.String PARAM_URL = "url";
    private int mModal;
    private java.lang.String mMsg;
    private java.lang.String mRuleFamily;
    private java.lang.String mRuleName;
    private java.lang.String mTitle;
    private int mType;
    private java.lang.String mUrl;

    public SingleInstructionModel(org.json.JSONObject jSONObject) {
        this.mType = -1;
        this.mModal = 0;
        if (jSONObject != null) {
            try {
                if (jSONObject.has("type")) {
                    this.mType = jSONObject.getInt("type");
                }
                if (jSONObject.has("title")) {
                    this.mTitle = jSONObject.getString("title");
                }
                if (jSONObject.has("msg")) {
                    this.mMsg = jSONObject.getString("msg");
                }
                if (jSONObject.has("url")) {
                    this.mUrl = jSONObject.getString("url");
                }
                if (jSONObject.has(PARAM_MODAL)) {
                    this.mModal = jSONObject.getInt(PARAM_MODAL);
                }
                if (jSONObject.has(PARAM_RULE_NAME)) {
                    this.mRuleName = jSONObject.getString(PARAM_RULE_NAME);
                }
                if (jSONObject.has(PARAM_RULE_FAMILY)) {
                    this.mRuleFamily = jSONObject.getString(PARAM_RULE_FAMILY);
                }
            } catch (org.json.JSONException unused) {
                com.tencent.ysdk.libware.file.Logger.e("SingleInstructionModel parse json error");
            }
        }
    }

    public int getModal() {
        return this.mModal;
    }

    public java.lang.String getMsg() {
        return this.mMsg;
    }

    public java.lang.String getRuleFamily() {
        return this.mRuleFamily;
    }

    public java.lang.String getRuleName() {
        return this.mRuleName;
    }

    public java.lang.String getTitle() {
        return this.mTitle;
    }

    public int getType() {
        return this.mType;
    }

    public java.lang.String getUrl() {
        return this.mUrl;
    }

    @androidx.annotation.NonNull
    public java.lang.String toString() {
        return "type=" + this.mType + " title=" + this.mTitle + " msg=" + this.mMsg + " url=" + this.mUrl + " modal=" + this.mModal + " ruleFamily=" + this.mRuleName + " ruleFamily=" + this.mRuleFamily;
    }
}
