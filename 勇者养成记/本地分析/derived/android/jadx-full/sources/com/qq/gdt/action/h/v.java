package com.qq.gdt.action.h;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class v {
    public static void a(org.json.JSONObject jSONObject, android.content.Context context) {
        try {
            com.tencent.turingfd.sdk.ams.ad.ITuringDID turingDID = com.tencent.turingfd.sdk.ams.ad.TuringDIDService.getTuringDID(context);
            if (turingDID.getErrorCode() == 0) {
                jSONObject.putOpt("taid", turingDID.getTAID());
                jSONObject.putOpt("m10", turingDID.getAIDTicket());
            } else {
                com.qq.gdt.action.h.l.c("getTuringDID err:" + turingDID.getErrorCode());
            }
        } catch (java.lang.Exception e) {
            com.qq.gdt.action.h.l.b("appendTuringDID err", e);
        }
    }
}
