package com.tencent.ysdk.shell.framework.channel;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ZipComment {
    private static final int CHANNEL_HEAD = 38650;
    private static final com.tencent.ysdk.shell.framework.channel.ZipShort PROTO_HEAD = new com.tencent.ysdk.shell.framework.channel.ZipShort(CHANNEL_HEAD);
    private byte[] otherData;
    private final java.util.Properties p = new java.util.Properties();

    public void decode(byte[] bArr) throws java.io.IOException {
        if (bArr == null) {
            java.lang.System.out.println("WARNING:[YYBComment]decode|data=null|exit");
            return;
        }
        java.nio.ByteBuffer byteBufferWrap = java.nio.ByteBuffer.wrap(bArr);
        int length = PROTO_HEAD.getBytes().length;
        byte[] bArr2 = new byte[length];
        byteBufferWrap.get(bArr2);
        if (!PROTO_HEAD.equals(new com.tencent.ysdk.shell.framework.channel.ZipShort(bArr2))) {
            java.lang.System.out.println("ERROR:[YYBComment]decode|unknow protocol|exit");
            throw new java.net.ProtocolException("[YYBComment] unknow protocl [" + java.util.Arrays.toString(bArr) + "]");
        }
        if (bArr.length - length <= 2) {
            java.lang.System.out.println("ERROR:[YYBComment]decode|data.length - headLength <= 2|1|exit");
            return;
        }
        byte[] bArr3 = new byte[2];
        byteBufferWrap.get(bArr3);
        int value = new com.tencent.ysdk.shell.framework.channel.ZipShort(bArr3).getValue();
        if ((bArr.length - length) - 2 < value) {
            java.lang.System.out.println("ERROR:[YYBComment]decode|data.length - headLength <= 2|2|exit");
            return;
        }
        byte[] bArr4 = new byte[value];
        byteBufferWrap.get(bArr4);
        this.p.load(new java.io.InputStreamReader(new java.io.ByteArrayInputStream(bArr4), java.nio.charset.Charset.forName("UTF-8")));
        int length2 = ((bArr.length - length) - value) - 2;
        if (length2 > 0) {
            this.otherData = new byte[length2];
            byteBufferWrap.get(this.otherData);
        }
    }

    public byte[] encode() throws java.io.IOException {
        return encode(false);
    }

    public byte[] encode(boolean z) throws java.io.IOException {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        byteArrayOutputStream.write(PROTO_HEAD.getBytes());
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.lang.Object obj : this.p.keySet()) {
            sb.append(obj);
            sb.append("=");
            sb.append(this.p.getProperty((java.lang.String) obj));
            sb.append(com.tencent.midas.comm.log.util.APLogFileUtil.SEPARATOR_LINE);
        }
        byte[] bytes = sb.toString().getBytes(java.nio.charset.Charset.forName("UTF-8"));
        byteArrayOutputStream.write(new com.tencent.ysdk.shell.framework.channel.ZipShort(bytes.length).getBytes());
        byteArrayOutputStream.write(bytes);
        byte[] bArr = this.otherData;
        if (bArr != null) {
            byteArrayOutputStream.write(bArr);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (!z) {
            return byteArray;
        }
        int length = (byteArray.length + 12) % 4096;
        byte[] bArr2 = new byte[(length > 0 ? 4096 - length : 0) + byteArray.length];
        java.lang.System.arraycopy(byteArray, 0, bArr2, 0, byteArray.length);
        for (int length2 = byteArray.length; length2 < bArr2.length; length2++) {
            bArr2[length2] = 0;
        }
        return bArr2;
    }

    public java.util.Properties getP() {
        return this.p;
    }

    public java.lang.String toString() {
        return "YYBComment [p=" + this.p + ", otherData=" + java.util.Arrays.toString(this.otherData) + "]";
    }
}
