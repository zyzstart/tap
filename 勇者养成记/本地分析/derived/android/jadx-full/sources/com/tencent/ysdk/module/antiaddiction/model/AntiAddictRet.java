package com.tencent.ysdk.module.antiaddiction.model;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class AntiAddictRet extends com.tencent.ysdk.framework.common.BaseRet {
    public static final java.lang.String RULE_GUEST = "xg_guset";
    public static final java.lang.String RULE_HOLIDAY_NO_PLAY = "xg_holiday_noplay";
    public static final java.lang.String RULE_HOLIDAY_TIP = "xg_holiday_tip";
    public static final java.lang.String RULE_NIGHT_NO_PLAY = "xg_alltime_noplaytime";
    public static final java.lang.String RULE_REGISTER_REAL_NAME = "xg_smrz";
    public static final java.lang.String RULE_WORK_NO_PLAY = "xg_work_noplay";
    public static final java.lang.String RULE_WORK_TIP = "xg_work_tip";
    public static final int TYPE_LOGOUT = 2;
    public static final int TYPE_OPEN_URL = 3;
    public static final int TYPE_TIPS = 1;
    public static final int TYPE_UNDEFINED = 0;
    public java.lang.String content;
    public int modal;
    public java.lang.String ruleFamily;
    public java.lang.String title;
    private java.lang.String traceId;
    private java.lang.String traceRuleName;
    public int type;
    public java.lang.String url;

    public AntiAddictRet(@androidx.annotation.NonNull com.tencent.ysdk.module.antiaddiction.impl.model.SingleInstructionModel singleInstructionModel, java.lang.String str) {
        this.type = singleInstructionModel.getType();
        this.title = singleInstructionModel.getTitle();
        this.content = singleInstructionModel.getMsg();
        this.url = singleInstructionModel.getUrl();
        this.modal = singleInstructionModel.getModal();
        this.ruleFamily = singleInstructionModel.getRuleFamily();
        this.traceId = str;
        this.traceRuleName = singleInstructionModel.getRuleName();
        this.ret = 0;
    }

    public java.lang.String getTraceId() {
        return this.traceId;
    }

    public java.lang.String getTraceRuleName() {
        return this.traceRuleName;
    }
}
