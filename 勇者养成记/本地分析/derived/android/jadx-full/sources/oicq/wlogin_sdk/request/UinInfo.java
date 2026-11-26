package oicq.wlogin_sdk.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class UinInfo implements java.io.Serializable {
    private static final long serialVersionUID = 1;
    public boolean _hasPassword;
    public java.lang.Long _uin;
    private int pwdState;

    public UinInfo(java.lang.Long l, boolean z) {
        this.pwdState = 0;
        this._uin = l;
        this._hasPassword = z;
        this.pwdState = z ? 1 : 2;
    }

    public boolean getHasPassword() {
        boolean z = true;
        if (!this._hasPassword && this.pwdState > 1) {
            z = false;
        }
        this._hasPassword = z;
        return z;
    }
}
