package oicq.wlogin_sdk.devicelock;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class l extends oicq.wlogin_sdk.devicelock.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1665a = 0;

    public l() {
        this._type = 5;
    }

    public byte[] a(long j) {
        fill_head();
        fill_body(new byte[4], 4);
        put_int32(j, this._head_len);
        return get_buf();
    }
}
