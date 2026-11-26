package oicq.wlogin_sdk.devicelock;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class m extends oicq.wlogin_sdk.devicelock.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1666a = 0;
    public int b = 0;

    public m() {
        this._type = 6;
    }

    @Override // oicq.wlogin_sdk.devicelock.e
    public void parse() {
        int i = this._head_len;
        this.f1666a = oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, i);
        this.b = oicq.wlogin_sdk.tools.util.buf_to_int16(this._buf, i + 2);
    }
}
