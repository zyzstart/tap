package oicq.wlogin_sdk.devicelock;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class DevlockRst {
    public static final int E_RST_UNKOWN = -1;
    public static final int E_SEND_QUERYSIG = 1201;
    public static final int E_VERIFY_QUERYSIG = 1301;
    public static final int S_OK = 0;
    public oicq.wlogin_sdk.devicelock.TLV_CommRsp commRsp = new oicq.wlogin_sdk.devicelock.TLV_CommRsp();
    public oicq.wlogin_sdk.devicelock.k mbMobileInfo = new oicq.wlogin_sdk.devicelock.k();
    public oicq.wlogin_sdk.devicelock.i devSetupInfo = new oicq.wlogin_sdk.devicelock.i();
    public oicq.wlogin_sdk.devicelock.j mbGuideInfo = new oicq.wlogin_sdk.devicelock.j();
    public oicq.wlogin_sdk.devicelock.TLV_QuerySig querySig = new oicq.wlogin_sdk.devicelock.TLV_QuerySig();
    public oicq.wlogin_sdk.devicelock.TLV_SppKey sppKey = new oicq.wlogin_sdk.devicelock.TLV_SppKey();
    public oicq.wlogin_sdk.devicelock.m smsInfo = new oicq.wlogin_sdk.devicelock.m();
    public oicq.wlogin_sdk.devicelock.h devGuideInfo = new oicq.wlogin_sdk.devicelock.h();
    public oicq.wlogin_sdk.devicelock.e transferInfo = new oicq.wlogin_sdk.devicelock.e();

    public void setSppKey(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        oicq.wlogin_sdk.devicelock.TLV_SppKey tLV_SppKey = new oicq.wlogin_sdk.devicelock.TLV_SppKey();
        this.sppKey = tLV_SppKey;
        tLV_SppKey.set_data(bArr, bArr.length);
    }
}
