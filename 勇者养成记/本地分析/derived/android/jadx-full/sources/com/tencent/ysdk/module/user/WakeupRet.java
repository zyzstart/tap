package com.tencent.ysdk.module.user;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class WakeupRet extends com.tencent.ysdk.framework.common.BaseRet {
    public int platform = com.tencent.ysdk.framework.common.ePlatform.None.val();
    public java.lang.String open_id = "";
    public java.lang.String media_tag_name = "";
    public java.lang.String message_ext = "";
    public java.lang.String country = "";
    public java.lang.String lang = "";
    public java.util.Vector ext_info = new java.util.Vector();

    @Override // com.tencent.ysdk.framework.common.BaseRet
    public java.lang.String toString() {
        return (super.toString() + "open_id: " + this.open_id + ";") + "msg: " + this.msg + ";";
    }
}
