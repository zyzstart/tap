package com.tencent.ysdk.shell.framework.channel;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ApkSignatureV2ChannelTool {
    private static final int APK_SIGNATURE_SCHEME_V2_BLOCK_ID = 1896449818;
    private static final int APK_SIGNATURE_SCHEME_V3_BLOCK_ID = -262969152;
    private static final int MSDK_COMMENT_BLOCK_ID = 1903261812;
    private static final int YYB_COMMENT_BLOCK_ID = 1903261812;

    private static boolean checkNeedPaddingData(java.nio.ByteBuffer byteBuffer) {
        return new java.lang.String(byteBuffer.array()).endsWith("APK Sig Block 42");
    }

    private static com.tencent.ysdk.shell.framework.channel.Pair<java.nio.ByteBuffer, java.lang.Long> genApkSigningBlockWithNewPair(java.nio.ByteBuffer byteBuffer, int i, byte[] bArr) throws com.tencent.ysdk.shell.framework.channel.ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        long length;
        com.tencent.ysdk.shell.framework.channel.ApkSignatureSchemeV2Verifier.checkByteOrderLittleEndian(byteBuffer);
        java.nio.ByteBuffer byteBufferSliceFromTo = com.tencent.ysdk.shell.framework.channel.ApkSignatureSchemeV2Verifier.sliceFromTo(byteBuffer, 8, byteBuffer.capacity() - 24);
        int length2 = bArr.length + 12;
        java.nio.ByteBuffer byteBufferAllocate = java.nio.ByteBuffer.allocate(byteBuffer.capacity() + length2);
        byteBufferAllocate.order(java.nio.ByteOrder.LITTLE_ENDIAN);
        byteBufferAllocate.position(8);
        int i2 = 0;
        while (true) {
            if (!byteBufferSliceFromTo.hasRemaining()) {
                length = 0;
                break;
            }
            i2++;
            if (byteBufferSliceFromTo.remaining() < 8) {
                throw new com.tencent.ysdk.shell.framework.channel.ApkSignatureSchemeV2Verifier.SignatureNotFoundException("Insufficient data to read size of APK Signing Block entry #" + i2);
            }
            long j = byteBufferSliceFromTo.getLong();
            if (j < 4 || j > 2147483647L) {
                throw new com.tencent.ysdk.shell.framework.channel.ApkSignatureSchemeV2Verifier.SignatureNotFoundException("APK Signing Block entry #" + i2 + " size out of range: " + j);
            }
            int i3 = (int) j;
            int iPosition = byteBufferSliceFromTo.position() + i3;
            if (i3 > byteBufferSliceFromTo.remaining()) {
                throw new com.tencent.ysdk.shell.framework.channel.ApkSignatureSchemeV2Verifier.SignatureNotFoundException("APK Signing Block entry #" + i2 + " size out of range: " + i3 + ", available: " + byteBufferSliceFromTo.remaining());
            }
            int i4 = byteBufferSliceFromTo.getInt();
            if (i4 == i) {
                length = (bArr.length + 4) - i3;
                byteBufferAllocate.putLong(bArr.length + 4);
                byteBufferAllocate.putInt(i4);
                byteBufferAllocate.put(bArr);
                byteBufferSliceFromTo.position(iPosition);
                byteBufferAllocate.put(byteBufferSliceFromTo.array(), byteBufferSliceFromTo.arrayOffset(), byteBufferSliceFromTo.remaining());
                byteBufferSliceFromTo.position(byteBufferSliceFromTo.limit());
                break;
            }
            byteBufferAllocate.putLong(j);
            byteBufferAllocate.putInt(i4);
            byteBufferAllocate.put(com.tencent.ysdk.shell.framework.channel.ApkSignatureSchemeV2Verifier.getByteBuffer(byteBufferSliceFromTo, i3 - 4));
            byteBufferSliceFromTo.position(iPosition);
        }
        if (length == 0) {
            byteBufferAllocate.putLong(bArr.length + 4);
            byteBufferAllocate.putInt(i);
            byteBufferAllocate.put(bArr);
            length = length2;
        }
        long j2 = byteBuffer.getLong() + length;
        byteBufferAllocate.putLong(j2);
        byteBufferAllocate.put(byteBuffer.array(), byteBuffer.array().length - 16, 16);
        byteBufferAllocate.position(0);
        byteBufferAllocate.putLong(j2);
        byteBufferAllocate.position(0);
        byteBufferAllocate.limit(((int) j2) + 8);
        return com.tencent.ysdk.shell.framework.channel.Pair.create(byteBufferAllocate, java.lang.Long.valueOf(length));
    }

    private static java.nio.ByteBuffer getCdfh(java.io.RandomAccessFile randomAccessFile, long j, int i) throws java.io.IOException {
        java.nio.ByteBuffer byteBufferAllocate = java.nio.ByteBuffer.allocate(i);
        byteBufferAllocate.order(java.nio.ByteOrder.LITTLE_ENDIAN);
        randomAccessFile.seek(j);
        randomAccessFile.readFully(byteBufferAllocate.array(), byteBufferAllocate.arrayOffset(), byteBufferAllocate.capacity());
        return byteBufferAllocate;
    }

    private static java.lang.String getSignValidString(byte[] bArr) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return toHexString(messageDigest.digest());
        } catch (java.security.NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static java.lang.String getSignatureV2(java.lang.String str) throws java.lang.Throwable {
        byte[] pairValueWithId = readPairValueWithId(str, APK_SIGNATURE_SCHEME_V2_BLOCK_ID);
        if (pairValueWithId == null) {
            return null;
        }
        return getSignValidString(pairValueWithId);
    }

    public static java.lang.String getSignatureV3(java.lang.String str) throws java.lang.Throwable {
        byte[] pairValueWithId = readPairValueWithId(str, APK_SIGNATURE_SCHEME_V3_BLOCK_ID);
        if (pairValueWithId == null) {
            return null;
        }
        return getSignValidString(pairValueWithId);
    }

    public static boolean isSignatureV2Apk(java.lang.String str) throws java.io.IOException {
        return com.tencent.ysdk.shell.framework.channel.ApkSignatureSchemeV2Verifier.hasSignature(str, APK_SIGNATURE_SCHEME_V2_BLOCK_ID);
    }

    public static boolean isSignatureV3Apk(java.lang.String str) throws java.io.IOException {
        return com.tencent.ysdk.shell.framework.channel.ApkSignatureSchemeV2Verifier.hasSignature(str, APK_SIGNATURE_SCHEME_V3_BLOCK_ID);
    }

    public static byte[] readComment(java.lang.String str) throws java.io.IOException, com.tencent.ysdk.shell.framework.channel.ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        return readPairValueWithId(str, 1903261812);
    }

    private static byte[] readPairValueWithId(java.lang.String str, int i) throws java.lang.Throwable {
        java.io.RandomAccessFile randomAccessFile;
        java.io.RandomAccessFile randomAccessFile2 = null;
        byte[] bArr = null;
        randomAccessFile2 = null;
        try {
            try {
                randomAccessFile = new java.io.RandomAccessFile(str, "r");
                try {
                    com.tencent.ysdk.shell.framework.channel.Pair<java.nio.ByteBuffer, java.lang.Long> eocd = com.tencent.ysdk.shell.framework.channel.ApkSignatureSchemeV2Verifier.getEocd(randomAccessFile);
                    java.nio.ByteBuffer byteBuffer = eocd.first;
                    long jLongValue = eocd.second.longValue();
                    if (com.tencent.ysdk.shell.framework.channel.ZipUtils.isZip64EndOfCentralDirectoryLocatorPresent(randomAccessFile, jLongValue)) {
                        throw new com.tencent.ysdk.shell.framework.channel.ApkSignatureSchemeV2Verifier.SignatureNotFoundException("ZIP64 APK not supported");
                    }
                    java.nio.ByteBuffer byteBufferFindApkSigningBlockWithId = com.tencent.ysdk.shell.framework.channel.ApkSignatureSchemeV2Verifier.findApkSigningBlockWithId(com.tencent.ysdk.shell.framework.channel.ApkSignatureSchemeV2Verifier.findApkSigningBlock(randomAccessFile, com.tencent.ysdk.shell.framework.channel.ApkSignatureSchemeV2Verifier.getCentralDirOffset(byteBuffer, jLongValue)).first, i);
                    if (byteBufferFindApkSigningBlockWithId != null) {
                        bArr = new byte[byteBufferFindApkSigningBlockWithId.remaining()];
                        byteBufferFindApkSigningBlockWithId.get(bArr, 0, bArr.length);
                    }
                    randomAccessFile.close();
                    return bArr;
                } catch (com.tencent.ysdk.shell.framework.channel.ApkSignatureSchemeV2Verifier.SignatureNotFoundException e) {
                    e = e;
                    randomAccessFile2 = randomAccessFile;
                    e.printStackTrace();
                    if (randomAccessFile2 == null) {
                        return randomAccessFile2;
                    }
                    randomAccessFile2.close();
                    return 0;
                } catch (java.lang.Throwable th) {
                    th = th;
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                    throw th;
                }
            } catch (com.tencent.ysdk.shell.framework.channel.ApkSignatureSchemeV2Verifier.SignatureNotFoundException e2) {
                e = e2;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            randomAccessFile = randomAccessFile2;
        }
    }

    public static java.lang.String toHexString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            java.lang.String string = java.lang.Integer.toString(b & 255, 16);
            if (string.length() == 1) {
                string = "0" + string;
            }
            sb.append(string);
        }
        return sb.toString();
    }

    private static void updateApkWithPair(java.lang.String str, int i, com.tencent.ysdk.shell.framework.channel.ZipComment zipComment) throws java.lang.Throwable {
        java.io.RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new java.io.RandomAccessFile(str, "rw");
            try {
                com.tencent.ysdk.shell.framework.channel.Pair<java.nio.ByteBuffer, java.lang.Long> eocd = com.tencent.ysdk.shell.framework.channel.ApkSignatureSchemeV2Verifier.getEocd(randomAccessFile);
                java.nio.ByteBuffer byteBuffer = eocd.first;
                long jLongValue = eocd.second.longValue();
                if (com.tencent.ysdk.shell.framework.channel.ZipUtils.isZip64EndOfCentralDirectoryLocatorPresent(randomAccessFile, jLongValue)) {
                    throw new com.tencent.ysdk.shell.framework.channel.ApkSignatureSchemeV2Verifier.SignatureNotFoundException("ZIP64 APK not supported");
                }
                long centralDirOffset = com.tencent.ysdk.shell.framework.channel.ApkSignatureSchemeV2Verifier.getCentralDirOffset(byteBuffer, jLongValue);
                java.nio.ByteBuffer cdfh = getCdfh(randomAccessFile, centralDirOffset, (int) (jLongValue - centralDirOffset));
                com.tencent.ysdk.shell.framework.channel.Pair<java.nio.ByteBuffer, java.lang.Long> pairFindApkSigningBlock = com.tencent.ysdk.shell.framework.channel.ApkSignatureSchemeV2Verifier.findApkSigningBlock(randomAccessFile, centralDirOffset);
                java.nio.ByteBuffer byteBuffer2 = pairFindApkSigningBlock.first;
                long jLongValue2 = pairFindApkSigningBlock.second.longValue();
                com.tencent.ysdk.shell.framework.channel.Pair<java.nio.ByteBuffer, java.lang.Long> pairGenApkSigningBlockWithNewPair = genApkSigningBlockWithNewPair(byteBuffer2, i, zipComment.encode(checkNeedPaddingData(byteBuffer2)));
                java.nio.ByteBuffer byteBuffer3 = pairGenApkSigningBlockWithNewPair.first;
                long jLongValue3 = pairGenApkSigningBlockWithNewPair.second.longValue();
                com.tencent.ysdk.shell.framework.channel.ZipUtils.setZipEocdCentralDirectoryOffset(byteBuffer, centralDirOffset + jLongValue3);
                randomAccessFile.seek(jLongValue2);
                randomAccessFile.write(byteBuffer3.array(), byteBuffer3.arrayOffset() + byteBuffer3.position(), byteBuffer3.remaining());
                randomAccessFile.write(cdfh.array(), cdfh.arrayOffset() + cdfh.position(), cdfh.remaining());
                randomAccessFile.write(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
                if (jLongValue3 < 0) {
                    randomAccessFile.setLength(randomAccessFile.length() + jLongValue3);
                }
                randomAccessFile.close();
            } catch (java.lang.Throwable th) {
                th = th;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
    }

    public static void updateYYBComment(java.lang.String str, com.tencent.ysdk.shell.framework.channel.ZipComment zipComment) throws java.lang.Throwable {
        updateApkWithPair(str, 1903261812, zipComment);
    }
}
