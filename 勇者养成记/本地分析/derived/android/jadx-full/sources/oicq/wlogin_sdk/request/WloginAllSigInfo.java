package oicq.wlogin_sdk.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class WloginAllSigInfo implements java.io.Serializable, java.lang.Cloneable {
    private static final long serialVersionUID = 1;
    public int mainSigMap;
    public oicq.wlogin_sdk.sharemem.WloginSimpleInfo _useInfo = new oicq.wlogin_sdk.sharemem.WloginSimpleInfo();
    public java.util.TreeMap _tk_map = new java.util.TreeMap();
    public long _uin = 0;

    public oicq.wlogin_sdk.request.WloginAllSigInfo get_clone() {
        try {
            oicq.wlogin_sdk.request.WloginAllSigInfo wloginAllSigInfo = (oicq.wlogin_sdk.request.WloginAllSigInfo) clone();
            if (this._tk_map != null) {
                java.util.Iterator it = this._tk_map.keySet().iterator();
                while (it.hasNext()) {
                    oicq.wlogin_sdk.sharemem.WloginSigInfo wloginSigInfo = (oicq.wlogin_sdk.sharemem.WloginSigInfo) this._tk_map.get(java.lang.Long.valueOf(((java.lang.Long) it.next()).longValue()));
                    if (wloginSigInfo != null) {
                        wloginSigInfo.cacheTickets = null;
                        wloginSigInfo.cacheUpdateStamp = 0L;
                    }
                }
            }
            return wloginAllSigInfo;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public void putNewST(long j, byte[] bArr, byte[] bArr2) {
        oicq.wlogin_sdk.sharemem.WloginSigInfo wloginSigInfo = (oicq.wlogin_sdk.sharemem.WloginSigInfo) this._tk_map.get(java.lang.Long.valueOf(j));
        if (wloginSigInfo != null) {
            this._tk_map.put(java.lang.Long.valueOf(j), wloginSigInfo.setNetST(bArr, bArr2));
        }
    }

    public int put_da2(long j, byte[] bArr) {
        oicq.wlogin_sdk.sharemem.WloginSigInfo wloginSigInfo = (oicq.wlogin_sdk.sharemem.WloginSigInfo) this._tk_map.get(java.lang.Long.valueOf(j));
        if (wloginSigInfo == null) {
            return 0;
        }
        this._tk_map.put(java.lang.Long.valueOf(j), wloginSigInfo.setDA2(bArr));
        return 0;
    }

    public int put_randseed(long j, byte[] bArr) {
        oicq.wlogin_sdk.sharemem.WloginSigInfo wloginSigInfo = (oicq.wlogin_sdk.sharemem.WloginSigInfo) this._tk_map.get(java.lang.Long.valueOf(j));
        if (wloginSigInfo == null) {
            return 0;
        }
        this._tk_map.put(java.lang.Long.valueOf(j), wloginSigInfo.setRandSeed(bArr));
        return 0;
    }

    public int put_siginfo(long j, long j2, long j3, long j4, long j5, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7, byte[] bArr8, byte[] bArr9, byte[] bArr10, byte[] bArr11, byte[] bArr12, byte[][] bArr13, long[] jArr, int i) {
        oicq.wlogin_sdk.sharemem.WloginSigInfo wloginSigInfo = (oicq.wlogin_sdk.sharemem.WloginSigInfo) this._tk_map.get(java.lang.Long.valueOf(j));
        if (wloginSigInfo == null) {
            this._tk_map.put(java.lang.Long.valueOf(j), new oicq.wlogin_sdk.sharemem.WloginSigInfo(j2, j3, j4, j5, bArr, bArr2, bArr3, bArr4, bArr5, bArr6, bArr7, bArr8, bArr9, bArr10, bArr11, bArr12, bArr13, jArr, i, this.mainSigMap));
            return 0;
        }
        wloginSigInfo.mainSigMap = this.mainSigMap;
        this._tk_map.put(java.lang.Long.valueOf(j), wloginSigInfo.Set(j2, j3, j4, j5, bArr, bArr2, bArr3, bArr4, bArr5, bArr6, bArr7, bArr8, bArr9, bArr10, bArr11, bArr12, bArr13, jArr, i));
        return 0;
    }

    public int put_siginfo(long j, long j2, long j3, byte[] bArr, byte[] bArr2) {
        this._tk_map.put(java.lang.Long.valueOf(j), new oicq.wlogin_sdk.sharemem.WloginSigInfo(j2, j3, bArr, bArr2));
        return 0;
    }

    public int put_siginfo(long j, byte[][] bArr, long j2) {
        oicq.wlogin_sdk.sharemem.WloginSigInfo wloginSigInfo = (oicq.wlogin_sdk.sharemem.WloginSigInfo) this._tk_map.get(java.lang.Long.valueOf(j));
        if (wloginSigInfo == null) {
            return 0;
        }
        this._tk_map.put(java.lang.Long.valueOf(j), wloginSigInfo.Set(bArr, j2));
        return 0;
    }

    public int put_simpleinfo(oicq.wlogin_sdk.sharemem.WloginSimpleInfo wloginSimpleInfo) {
        oicq.wlogin_sdk.sharemem.WloginSimpleInfo wloginSimpleInfo2 = this._useInfo;
        if (wloginSimpleInfo2 == null) {
            this._useInfo = wloginSimpleInfo;
            return 0;
        }
        wloginSimpleInfo2.set_info(wloginSimpleInfo);
        return 0;
    }
}
