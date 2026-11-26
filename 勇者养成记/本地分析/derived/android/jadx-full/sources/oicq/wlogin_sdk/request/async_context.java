package oicq.wlogin_sdk.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class async_context {
    public oicq.wlogin_sdk.tlv_type.tlv_t tlv528;
    public long _sappid = 0;
    public long _appid = 0;
    public long _sub_appid = 0;
    public long[] _sub_appid_list = new long[0];
    public int _main_sigmap = 0;
    public byte[] _tmp_pwd = new byte[16];
    public int _tmp_pwd_type = 0;
    public byte[] _tmp_no_pic_sig = new byte[0];
    public byte[] tgtQR = new byte[0];
    public int _last_flowid = 0;
    public int _login_bitmap = 0;
    oicq.wlogin_sdk.tools.ErrMsg _last_err_msg = new oicq.wlogin_sdk.tools.ErrMsg();
    public byte[] _tgtgt_key = new byte[16];
    public oicq.wlogin_sdk.tlv_type.tlv_t104 _t104 = new oicq.wlogin_sdk.tlv_type.tlv_t104();
    public oicq.wlogin_sdk.tlv_type.tlv_t105 _t105 = new oicq.wlogin_sdk.tlv_type.tlv_t105();
    public oicq.wlogin_sdk.tlv_type.tlv_t165 _t165 = new oicq.wlogin_sdk.tlv_type.tlv_t165();
    public oicq.wlogin_sdk.tlv_type.tlv_t126 _t126 = new oicq.wlogin_sdk.tlv_type.tlv_t126();
    public boolean _sec_guid_flag = false;
    public oicq.wlogin_sdk.tlv_type.tlv_t402 _t402 = new oicq.wlogin_sdk.tlv_type.tlv_t402();
    public oicq.wlogin_sdk.tlv_type.tlv_t403 _t403 = new oicq.wlogin_sdk.tlv_type.tlv_t403();
    public byte[] _dpwd = new byte[16];
    public byte[] _G = new byte[16];
    public oicq.wlogin_sdk.tlv_type.tlv_t174 _t174 = new oicq.wlogin_sdk.tlv_type.tlv_t174();
    public oicq.wlogin_sdk.tlv_type.tlv_t17b _t17b = new oicq.wlogin_sdk.tlv_type.tlv_t17b();
    oicq.wlogin_sdk.devicelock.DevlockInfo _devlock_info = new oicq.wlogin_sdk.devicelock.DevlockInfo();
    java.lang.String _smslogin_msg = "";
    int _smslogin_msgcnt = 0;
    int _smslogin_timelimit = 0;
    long _msalt = 0;
    java.lang.String _mpasswd = "[REDACTED]";
    boolean _isSmslogin = false;
}
