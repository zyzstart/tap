package oicq.wlogin_sdk.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class WloginLastLoginInfo implements java.io.Serializable {
    private static final long serialVersionUID = 1;
    public java.lang.String mAccount;
    public long mUin;

    public WloginLastLoginInfo() {
        this.mAccount = new java.lang.String();
        this.mUin = 0L;
        this.mAccount = "";
    }

    public WloginLastLoginInfo(java.lang.String str, long j) {
        this.mAccount = new java.lang.String();
        this.mUin = 0L;
        this.mAccount = str;
        this.mUin = j;
    }
}
