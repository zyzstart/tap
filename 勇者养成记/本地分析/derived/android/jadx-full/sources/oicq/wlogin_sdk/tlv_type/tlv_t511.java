package oicq.wlogin_sdk.tlv_type;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class tlv_t511 extends oicq.wlogin_sdk.tlv_type.tlv_t {
    public tlv_t511() {
        this._cmd = 1297;
    }

    public byte[] get_tlv_511(java.util.List list) {
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList();
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            java.lang.String str = (java.lang.String) it.next();
            if (str != null && str.length() != 0) {
                arrayList.add(str);
            }
        }
        java.nio.ByteBuffer byteBufferAllocate = java.nio.ByteBuffer.allocate(1024);
        byteBufferAllocate.putShort((short) arrayList.size());
        for (java.lang.String strSubstring : arrayList) {
            if (strSubstring != null && strSubstring.length() != 0) {
                int iIndexOf = strSubstring.indexOf(40);
                int iIndexOf2 = strSubstring.indexOf(41);
                byte b = 1;
                if (iIndexOf == 0 && iIndexOf2 > 0) {
                    int iIntValue = java.lang.Integer.valueOf(strSubstring.substring(iIndexOf + 1, iIndexOf2)).intValue();
                    boolean z = (1048576 & iIntValue) > 0;
                    boolean z2 = (iIntValue & oicq.wlogin_sdk.request.WtloginHelper.SigType.WLOGIN_PT4Token) > 0;
                    byte b2 = z ? (byte) 1 : (byte) 0;
                    b = z2 ? (byte) (b2 | 2) : b2;
                    strSubstring = strSubstring.substring(iIndexOf2 + 1);
                }
                byteBufferAllocate.put(b);
                byteBufferAllocate.putShort((short) strSubstring.length());
                byteBufferAllocate.put(strSubstring.getBytes());
            }
        }
        fill_head(this._cmd);
        fill_body(byteBufferAllocate.array(), byteBufferAllocate.position());
        set_length();
        return get_buf();
    }
}
