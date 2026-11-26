package com.tencent.yybsdk.apkpatch.bsdiff;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class e {
    public static int a(java.io.InputStream inputStream) throws java.io.IOException {
        byte[] bArr = new byte[8];
        if (inputStream.read(bArr) < 8) {
            throw new java.io.IOException("Could not read offset.");
        }
        int i = ((((((((((((((bArr[7] & 127) * 256) + (bArr[6] & 255)) * 256) + (bArr[5] & 255)) * 256) + (bArr[4] & 255)) * 256) + (bArr[3] & 255)) * 256) + (bArr[2] & 255)) * 256) + (bArr[1] & 255)) * 256) + (bArr[0] & 255);
        if (i >= 0) {
            return (bArr[7] & 128) != 0 ? -i : i;
        }
        throw new java.io.IOException("Integer overflow: 64-bit offsets not supported.");
    }
}
