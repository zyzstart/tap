package oicq.wlogin_sdk.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class Ticket implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() { // from class: oicq.wlogin_sdk.request.Ticket.1
        @Override // android.os.Parcelable.Creator
        public oicq.wlogin_sdk.request.Ticket createFromParcel(android.os.Parcel parcel) {
            return new oicq.wlogin_sdk.request.Ticket(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public oicq.wlogin_sdk.request.Ticket[] newArray(int i) {
            return new oicq.wlogin_sdk.request.Ticket[i];
        }
    };
    private static final int EXPIRE_FIELD = 65535;
    public long _create_time;
    public long _expire_time;
    public java.util.Map _pskey_expire;
    public java.util.Map _pskey_map;
    public java.util.Map _pt4token_expire;
    public java.util.Map _pt4token_map;
    public byte[] _sig;
    public byte[] _sig_key;
    public int _type;

    public Ticket() {
        this._pskey_map = new java.util.HashMap();
        this._pskey_expire = new java.util.HashMap();
        this._pt4token_map = new java.util.HashMap();
        this._pt4token_expire = new java.util.HashMap();
    }

    public Ticket(int i, byte[] bArr, byte[] bArr2, long j, long j2) {
        this._pskey_map = new java.util.HashMap();
        this._pskey_expire = new java.util.HashMap();
        this._pt4token_map = new java.util.HashMap();
        this._pt4token_expire = new java.util.HashMap();
        this._type = i;
        this._sig = bArr == null ? new byte[0] : (byte[]) bArr.clone();
        this._sig_key = bArr2 == null ? new byte[0] : (byte[]) bArr2.clone();
        this._create_time = j;
        this._expire_time = j2;
    }

    public Ticket(int i, byte[] bArr, byte[] bArr2, long j, byte[] bArr3) {
        this._pskey_map = new java.util.HashMap();
        this._pskey_expire = new java.util.HashMap();
        this._pt4token_map = new java.util.HashMap();
        this._pt4token_expire = new java.util.HashMap();
        this._type = i;
        this._sig = bArr == null ? new byte[0] : (byte[]) bArr.clone();
        this._sig_key = bArr2 == null ? new byte[0] : (byte[]) bArr2.clone();
        this._create_time = j;
        this._expire_time = com.tencent.smtt.sdk.TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC + j;
        parsePsBuf(bArr3, j, this._pskey_map, this._pskey_expire);
    }

    public Ticket(int i, byte[] bArr, byte[] bArr2, long j, byte[] bArr3, byte[] bArr4) {
        this._pskey_map = new java.util.HashMap();
        this._pskey_expire = new java.util.HashMap();
        this._pt4token_map = new java.util.HashMap();
        this._pt4token_expire = new java.util.HashMap();
        this._type = i;
        this._sig = bArr == null ? new byte[0] : (byte[]) bArr.clone();
        this._sig_key = bArr2 == null ? new byte[0] : (byte[]) bArr2.clone();
        this._create_time = j;
        this._expire_time = com.tencent.smtt.sdk.TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC + j;
        parsePsBuf(bArr3, j, this._pskey_map, this._pskey_expire);
        parsePsBuf(bArr4, this._create_time, this._pt4token_map, this._pt4token_expire);
    }

    private Ticket(android.os.Parcel parcel) {
        this._pskey_map = new java.util.HashMap();
        this._pskey_expire = new java.util.HashMap();
        this._pt4token_map = new java.util.HashMap();
        this._pt4token_expire = new java.util.HashMap();
        readFromParcel(parcel);
    }

    private java.lang.String __getPskey(java.lang.String str, java.util.Map map, java.util.Map map2) {
        java.lang.Long l;
        oicq.wlogin_sdk.tools.util.LOGI("[REDACTED]" + str + "[REDACTED]", "[REDACTED]");
        if (map == null) {
            return null;
        }
        byte[] bArr = (byte[]) map.get(str);
        if (bArr == null) {
            oicq.wlogin_sdk.tools.util.LOGI("[REDACTED]" + str + "[REDACTED]", "[REDACTED]");
            return null;
        }
        if (map2 != null && (l = (java.lang.Long) map2.get(str)) != null && l.longValue() <= oicq.wlogin_sdk.request.t.f()) {
            oicq.wlogin_sdk.tools.util.LOGI("[REDACTED]" + str + "[REDACTED]" + l, "[REDACTED]");
            map2.remove(str);
            map.remove(str);
            return null;
        }
        java.lang.String str2 = new java.lang.String(bArr);
        oicq.wlogin_sdk.tools.util.LOGI("[REDACTED]" + str + "[REDACTED]" + str2.length() + "[REDACTED]" + str2.substring(0, 5) + "[REDACTED]" + str2.substring(str2.length() - 5, str2.length()), "[REDACTED]");
        return str2;
    }

    private java.lang.String getPskeyOrPt4tokenContent() {
        java.lang.String str = "";
        for (java.lang.String str2 : this._pskey_map.keySet()) {
            str = str + str2 + ":" + oicq.wlogin_sdk.tools.util.getMaskBytes((byte[]) this._pskey_map.get(str2), 3, 3) + "|";
        }
        return str;
    }

    public static boolean isPskeyExpired(long j) {
        return isTicketExpired(j);
    }

    public static boolean isPskeyStorageExpired(long j) {
        long jF = oicq.wlogin_sdk.request.t.f();
        oicq.wlogin_sdk.tools.util.LOGI("isPskeyStorageExpired expireTime:" + j + "|current: " + jF, "");
        return jF > j + com.tencent.smtt.sdk.TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC;
    }

    public static boolean isPt4TokenExpired(long j) {
        return isTicketExpired(j);
    }

    public static boolean isSkeyExpired(long j) {
        return isTicketExpired(j);
    }

    public static boolean isTicketExpired(long j) {
        long jF = oicq.wlogin_sdk.request.t.f();
        if (jF > j) {
            return true;
        }
        if (j <= com.tencent.smtt.sdk.TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC + jF) {
            return false;
        }
        oicq.wlogin_sdk.tools.util.LOGI("time for system may be  modified manually expireTime " + j + " current " + jF, "");
        return true;
    }

    protected static byte[] packPsBuf(java.util.Map map, long j, java.util.Map map2) {
        oicq.wlogin_sdk.tools.util.LOGI("pskeyMap " + map.size(), "");
        java.nio.ByteBuffer byteBufferAllocate = java.nio.ByteBuffer.allocate(4096);
        byteBufferAllocate.putShort((short) map.size());
        for (java.lang.String str : map.keySet()) {
            byteBufferAllocate.putShort((short) str.length());
            byteBufferAllocate.put(str.getBytes());
            byte[] bArr = (byte[]) map.get(str);
            byteBufferAllocate.putShort((short) bArr.length);
            byteBufferAllocate.put(bArr);
            byteBufferAllocate.putShort((short) -1);
            java.lang.Long l = (java.lang.Long) map2.get(str);
            byteBufferAllocate.putLong(l != null ? l.longValue() : com.tencent.smtt.sdk.TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC + j);
        }
        byteBufferAllocate.flip();
        byte[] bArr2 = new byte[byteBufferAllocate.limit()];
        byteBufferAllocate.get(bArr2);
        return bArr2;
    }

    protected static void parsePsBuf(byte[] bArr, long j, java.util.Map map, java.util.Map map2) {
        int iBuf_to_int16;
        int iBuf_to_int17;
        int iBuf_to_int18;
        int iBuf_to_int19;
        long jBuf_to_int64;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("ps_buf ");
        sb.append(bArr == null ? "null" : java.lang.Integer.valueOf(bArr.length));
        oicq.wlogin_sdk.tools.util.LOGI(sb.toString(), "");
        if (bArr == null || bArr.length <= 2) {
            return;
        }
        long jF = oicq.wlogin_sdk.request.t.f();
        int iBuf_to_int110 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr, 0);
        oicq.wlogin_sdk.tools.util.LOGI("domainCnt " + iBuf_to_int110, "");
        int i = 0;
        int i2 = 2;
        while (i < iBuf_to_int110) {
            int i3 = i2 + 2;
            if (bArr.length < i3 || bArr.length < (iBuf_to_int17 = i3 + (iBuf_to_int16 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr, i2)))) {
                return;
            }
            java.lang.String str = new java.lang.String(bArr, i3, iBuf_to_int16);
            int i4 = iBuf_to_int17 + 2;
            if (bArr.length < i4 || bArr.length < (iBuf_to_int19 = i4 + (iBuf_to_int18 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArr, iBuf_to_int17)))) {
                return;
            }
            byte[] bArr2 = new byte[iBuf_to_int18];
            java.lang.System.arraycopy(bArr, i4, bArr2, 0, iBuf_to_int18);
            int i5 = iBuf_to_int19 + 2;
            if (bArr.length <= i5 || oicq.wlogin_sdk.tools.util.buf_to_int16(bArr, iBuf_to_int19) != 65535) {
                jBuf_to_int64 = com.tencent.smtt.sdk.TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC + j;
            } else {
                iBuf_to_int19 = i5 + 8;
                jBuf_to_int64 = oicq.wlogin_sdk.tools.util.buf_to_int64(bArr, i5);
            }
            if (jBuf_to_int64 > jF) {
                map.put(str, bArr2);
                map2.put(str, java.lang.Long.valueOf(jBuf_to_int64));
            }
            oicq.wlogin_sdk.tools.util.LOGI(str + "[REDACTED]" + iBuf_to_int18 + "[REDACTED]" + jBuf_to_int64, "[REDACTED]");
            i++;
            i2 = iBuf_to_int19;
        }
    }

    protected static void parseSvrPs(byte[] bArr, long j, java.util.Map map, java.util.Map map2, java.util.Map map3, java.util.Map map4) {
        long j2 = j;
        oicq.wlogin_sdk.tools.util.LOGI("[REDACTED]" + map.size() + "[REDACTED]" + map3.size() + "[REDACTED]" + j2, "[REDACTED]");
        if (bArr == null || bArr.length <= 2) {
            return;
        }
        java.nio.ByteBuffer byteBufferWrap = java.nio.ByteBuffer.wrap(bArr);
        short s = byteBufferWrap.getShort();
        int i = 0;
        while (i < s) {
            byte[] bArr2 = new byte[byteBufferWrap.getShort()];
            byteBufferWrap.get(bArr2);
            java.lang.String str = new java.lang.String(bArr2);
            int i2 = byteBufferWrap.getShort();
            byte[] bArr3 = new byte[i2];
            byteBufferWrap.get(bArr3);
            int i3 = byteBufferWrap.getShort();
            byte[] bArr4 = new byte[i3];
            byteBufferWrap.get(bArr4);
            long j3 = com.tencent.smtt.sdk.TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC + j2;
            if (i2 > 0) {
                oicq.wlogin_sdk.tools.util.LOGI("parseSvrPs add domain " + str + " pskey len " + i2 + " " + j3, "");
                map.put(str, bArr3);
                map2.put(str, java.lang.Long.valueOf(j3));
            }
            if (i3 > 0) {
                java.lang.String str2 = new java.lang.String(bArr4);
                oicq.wlogin_sdk.tools.util.LOGI("[REDACTED]" + str + "[REDACTED]" + i3 + "[REDACTED]" + j3 + "[REDACTED]" + str2.substring(0, 5) + "[REDACTED]" + str2.substring(str2.length() - 5), "[REDACTED]");
                map3.put(str, bArr4);
                map4.put(str, java.lang.Long.valueOf(j3));
            }
            oicq.wlogin_sdk.tools.util.LOGI(str + "[REDACTED]" + i2 + "[REDACTED]" + i3 + "[REDACTED]" + j3, "[REDACTED]");
            i++;
            byteBufferWrap = byteBufferWrap;
            j2 = j;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.lang.String getContent() {
        if (4096 != this._type) {
            return "";
        }
        return "skey:" + oicq.wlogin_sdk.tools.util.getMaskBytes(this._sig, 2, 2);
    }

    public java.lang.String getPSkey(java.lang.String str) {
        return __getPskey(str, this._pskey_map, this._pskey_expire);
    }

    public java.lang.String getPt4Token(java.lang.String str) {
        oicq.wlogin_sdk.tools.util.LOGI("[REDACTED]" + str + "[REDACTED]", "[REDACTED]");
        return __getPskey(str, this._pt4token_map, this._pt4token_expire);
    }

    public void readFromParcel(android.os.Parcel parcel) {
        this._type = parcel.readInt();
        this._sig = parcel.createByteArray();
        this._sig_key = parcel.createByteArray();
        this._create_time = parcel.readLong();
        this._expire_time = parcel.readLong();
        this._pskey_map = parcel.readHashMap(java.util.Map.class.getClassLoader());
        this._pt4token_map = parcel.readHashMap(java.util.Map.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeInt(this._type);
        parcel.writeByteArray(this._sig);
        parcel.writeByteArray(this._sig_key);
        parcel.writeLong(this._create_time);
        parcel.writeLong(this._expire_time);
        parcel.writeMap(this._pskey_map);
        parcel.writeMap(this._pt4token_map);
    }
}
