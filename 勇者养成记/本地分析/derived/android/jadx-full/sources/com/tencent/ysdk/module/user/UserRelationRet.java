package com.tencent.ysdk.module.user;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class UserRelationRet extends com.tencent.ysdk.framework.common.BaseRet {
    public static final int USER_INFO = 1;
    public int platform = com.tencent.ysdk.framework.common.ePlatform.None.val();

    @com.tencent.ysdk.framework.verification.YSDKDescription("本次用户信息回调类型为个人信息回调还是关系链回调")
    public int info_type = 1;
    public java.util.Vector persons = new java.util.Vector();

    @Override // com.tencent.ysdk.framework.common.BaseRet
    public java.lang.String toString() {
        if (this.persons == null) {
            return "friends(num): 0;";
        }
        java.lang.String str = super.toString() + "friends(num): " + this.persons.size() + ";";
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = 0; i < this.persons.size(); i++) {
            sb.append(((com.tencent.ysdk.module.user.PersonInfo) this.persons.get(i)).toString());
        }
        return str + sb.toString();
    }
}
