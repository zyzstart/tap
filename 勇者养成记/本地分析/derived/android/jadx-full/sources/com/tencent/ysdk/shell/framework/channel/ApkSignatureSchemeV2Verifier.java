package com.tencent.ysdk.shell.framework.channel;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ApkSignatureSchemeV2Verifier {
    public static final long APK_SIG_BLOCK_MAGIC_HI = 3617552046287187010L;
    public static final long APK_SIG_BLOCK_MAGIC_LO = 2334950737559900225L;
    public static final int APK_SIG_BLOCK_MIN_SIZE = 32;
    public static final int SF_ATTRIBUTE_ANDROID_APK_SIGNED_ID = 2;
    public static final java.lang.String SF_ATTRIBUTE_ANDROID_APK_SIGNED_NAME = "X-Android-APK-Signed";

    public static class SignatureNotFoundException extends java.lang.Exception {
        public SignatureNotFoundException(java.lang.String str) {
            super(str);
        }

        public SignatureNotFoundException(java.lang.String str, java.lang.Throwable th) {
            super(str, th);
        }
    }

    static void checkByteOrderLittleEndian(java.nio.ByteBuffer byteBuffer) {
        if (byteBuffer.order() != java.nio.ByteOrder.LITTLE_ENDIAN) {
            throw new java.lang.IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    public static com.tencent.ysdk.shell.framework.channel.Pair<java.nio.ByteBuffer, java.lang.Long> findApkSigningBlock(java.io.RandomAccessFile randomAccessFile, long j) throws java.io.IOException, com.tencent.ysdk.shell.framework.channel.ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        if (j < 32) {
            throw new com.tencent.ysdk.shell.framework.channel.ApkSignatureSchemeV2Verifier.SignatureNotFoundException("APK too small for APK Signing Block. ZIP Central Directory offset: " + j);
        }
        java.nio.ByteBuffer byteBufferAllocate = java.nio.ByteBuffer.allocate(24);
        byteBufferAllocate.order(java.nio.ByteOrder.LITTLE_ENDIAN);
        randomAccessFile.seek(j - ((long) byteBufferAllocate.capacity()));
        randomAccessFile.readFully(byteBufferAllocate.array(), byteBufferAllocate.arrayOffset(), byteBufferAllocate.capacity());
        if (byteBufferAllocate.getLong(8) != APK_SIG_BLOCK_MAGIC_LO || byteBufferAllocate.getLong(16) != APK_SIG_BLOCK_MAGIC_HI) {
            throw new com.tencent.ysdk.shell.framework.channel.ApkSignatureSchemeV2Verifier.SignatureNotFoundException("No APK Signing Block before ZIP Central Directory");
        }
        long j2 = byteBufferAllocate.getLong(0);
        if (j2 < byteBufferAllocate.capacity() || j2 > 2147483639) {
            throw new com.tencent.ysdk.shell.framework.channel.ApkSignatureSchemeV2Verifier.SignatureNotFoundException("APK Signing Block size out of range: " + j2);
        }
        int i = (int) (8 + j2);
        long j3 = j - ((long) i);
        if (j3 < 0) {
            throw new com.tencent.ysdk.shell.framework.channel.ApkSignatureSchemeV2Verifier.SignatureNotFoundException("APK Signing Block offset out of range: " + j3);
        }
        java.nio.ByteBuffer byteBufferAllocate2 = java.nio.ByteBuffer.allocate(i);
        byteBufferAllocate2.order(java.nio.ByteOrder.LITTLE_ENDIAN);
        randomAccessFile.seek(j3);
        randomAccessFile.readFully(byteBufferAllocate2.array(), byteBufferAllocate2.arrayOffset(), byteBufferAllocate2.capacity());
        long j4 = byteBufferAllocate2.getLong(0);
        if (j4 == j2) {
            return com.tencent.ysdk.shell.framework.channel.Pair.create(byteBufferAllocate2, java.lang.Long.valueOf(j3));
        }
        throw new com.tencent.ysdk.shell.framework.channel.ApkSignatureSchemeV2Verifier.SignatureNotFoundException("APK Signing Block sizes in header and footer do not match: " + j4 + " vs " + j2);
    }

    static java.nio.ByteBuffer findApkSigningBlockWithId(java.nio.ByteBuffer byteBuffer, int i) throws com.tencent.ysdk.shell.framework.channel.ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        checkByteOrderLittleEndian(byteBuffer);
        java.nio.ByteBuffer byteBufferSliceFromTo = sliceFromTo(byteBuffer, 8, byteBuffer.capacity() - 24);
        int i2 = 0;
        while (byteBufferSliceFromTo.hasRemaining()) {
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
            if (byteBufferSliceFromTo.getInt() == i) {
                return getByteBuffer(byteBufferSliceFromTo, i3 - 4);
            }
            byteBufferSliceFromTo.position(iPosition);
        }
        return null;
    }

    static java.nio.ByteBuffer getByteBuffer(java.nio.ByteBuffer byteBuffer, int i) throws java.nio.BufferUnderflowException {
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("size: " + i);
        }
        int iLimit = byteBuffer.limit();
        int iPosition = byteBuffer.position();
        int i2 = i + iPosition;
        if (i2 < iPosition || i2 > iLimit) {
            throw new java.nio.BufferUnderflowException();
        }
        byteBuffer.limit(i2);
        try {
            java.nio.ByteBuffer byteBufferSlice = byteBuffer.slice();
            byteBufferSlice.order(byteBuffer.order());
            byteBuffer.position(i2);
            return byteBufferSlice;
        } finally {
            byteBuffer.limit(iLimit);
        }
    }

    static long getCentralDirOffset(java.nio.ByteBuffer byteBuffer, long j) throws com.tencent.ysdk.shell.framework.channel.ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        long zipEocdCentralDirectoryOffset = com.tencent.ysdk.shell.framework.channel.ZipUtils.getZipEocdCentralDirectoryOffset(byteBuffer);
        if (zipEocdCentralDirectoryOffset < j) {
            if (com.tencent.ysdk.shell.framework.channel.ZipUtils.getZipEocdCentralDirectorySizeBytes(byteBuffer) + zipEocdCentralDirectoryOffset == j) {
                return zipEocdCentralDirectoryOffset;
            }
            throw new com.tencent.ysdk.shell.framework.channel.ApkSignatureSchemeV2Verifier.SignatureNotFoundException("ZIP Central Directory is not immediately followed by End of Central Directory");
        }
        throw new com.tencent.ysdk.shell.framework.channel.ApkSignatureSchemeV2Verifier.SignatureNotFoundException("ZIP Central Directory offset out of range: " + zipEocdCentralDirectoryOffset + ". ZIP End of Central Directory offset: " + j);
    }

    static com.tencent.ysdk.shell.framework.channel.Pair<java.nio.ByteBuffer, java.lang.Long> getEocd(java.io.RandomAccessFile randomAccessFile) throws java.io.IOException, com.tencent.ysdk.shell.framework.channel.ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        com.tencent.ysdk.shell.framework.channel.Pair<java.nio.ByteBuffer, java.lang.Long> pairFindZipEndOfCentralDirectoryRecord = com.tencent.ysdk.shell.framework.channel.ZipUtils.findZipEndOfCentralDirectoryRecord(randomAccessFile);
        if (pairFindZipEndOfCentralDirectoryRecord != null) {
            return pairFindZipEndOfCentralDirectoryRecord;
        }
        throw new com.tencent.ysdk.shell.framework.channel.ApkSignatureSchemeV2Verifier.SignatureNotFoundException("Not an APK file: ZIP End of Central Directory record not found");
    }

    public static boolean hasSignature(java.lang.String str, int i) throws java.lang.Throwable {
        java.io.RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new java.io.RandomAccessFile(str, "r");
            try {
                com.tencent.ysdk.shell.framework.channel.Pair<java.nio.ByteBuffer, java.lang.Long> eocd = getEocd(randomAccessFile);
                java.nio.ByteBuffer byteBuffer = eocd.first;
                long jLongValue = eocd.second.longValue();
                if (com.tencent.ysdk.shell.framework.channel.ZipUtils.isZip64EndOfCentralDirectoryLocatorPresent(randomAccessFile, jLongValue)) {
                    throw new com.tencent.ysdk.shell.framework.channel.ApkSignatureSchemeV2Verifier.SignatureNotFoundException("ZIP64 APK not supported");
                }
                boolean z = findApkSigningBlockWithId(findApkSigningBlock(randomAccessFile, getCentralDirOffset(byteBuffer, jLongValue)).first, i) != null;
                randomAccessFile.close();
                return z;
            } catch (com.tencent.ysdk.shell.framework.channel.ApkSignatureSchemeV2Verifier.SignatureNotFoundException unused) {
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                return false;
            } catch (java.lang.Throwable th) {
                th = th;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        } catch (com.tencent.ysdk.shell.framework.channel.ApkSignatureSchemeV2Verifier.SignatureNotFoundException unused2) {
            randomAccessFile = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
    }

    static java.nio.ByteBuffer sliceFromTo(java.nio.ByteBuffer byteBuffer, int i, int i2) {
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("start: " + i);
        }
        if (i2 < i) {
            throw new java.lang.IllegalArgumentException("end < start: " + i2 + " < " + i);
        }
        int iCapacity = byteBuffer.capacity();
        if (i2 > byteBuffer.capacity()) {
            throw new java.lang.IllegalArgumentException("end > capacity: " + i2 + " > " + iCapacity);
        }
        int iLimit = byteBuffer.limit();
        int iPosition = byteBuffer.position();
        try {
            byteBuffer.position(0);
            byteBuffer.limit(i2);
            byteBuffer.position(i);
            java.nio.ByteBuffer byteBufferSlice = byteBuffer.slice();
            byteBufferSlice.order(byteBuffer.order());
            return byteBufferSlice;
        } finally {
            byteBuffer.position(0);
            byteBuffer.limit(iLimit);
            byteBuffer.position(iPosition);
        }
    }
}
