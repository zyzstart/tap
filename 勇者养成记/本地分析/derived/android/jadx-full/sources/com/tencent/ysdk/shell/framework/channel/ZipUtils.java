package com.tencent.ysdk.shell.framework.channel;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ZipUtils {
    private static final int UINT16_MAX_VALUE = 65535;
    private static final int ZIP64_EOCD_LOCATOR_SIG_REVERSE_BYTE_ORDER = 1347094023;
    private static final int ZIP64_EOCD_LOCATOR_SIZE = 20;
    private static final int ZIP_EOCD_CENTRAL_DIR_OFFSET_FIELD_OFFSET = 16;
    private static final int ZIP_EOCD_CENTRAL_DIR_SIZE_FIELD_OFFSET = 12;
    private static final int ZIP_EOCD_COMMENT_LENGTH_FIELD_OFFSET = 20;
    private static final int ZIP_EOCD_REC_MIN_SIZE = 22;
    private static final int ZIP_EOCD_REC_SIG = 101010256;

    private ZipUtils() {
    }

    private static void assertByteOrderLittleEndian(java.nio.ByteBuffer byteBuffer) {
        if (byteBuffer.order() != java.nio.ByteOrder.LITTLE_ENDIAN) {
            throw new java.lang.IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    private static int findZipEndOfCentralDirectoryRecord(java.nio.ByteBuffer byteBuffer) {
        assertByteOrderLittleEndian(byteBuffer);
        int iCapacity = byteBuffer.capacity();
        if (iCapacity < 22) {
            return -1;
        }
        int i = iCapacity - 22;
        int iMin = java.lang.Math.min(i, 65535);
        for (int i2 = 0; i2 < iMin; i2++) {
            int i3 = i - i2;
            if (byteBuffer.getInt(i3) == ZIP_EOCD_REC_SIG && getUnsignedInt16(byteBuffer, i3 + 20) == i2) {
                return i3;
            }
        }
        return -1;
    }

    static com.tencent.ysdk.shell.framework.channel.Pair<java.nio.ByteBuffer, java.lang.Long> findZipEndOfCentralDirectoryRecord(java.io.RandomAccessFile randomAccessFile) throws java.io.IOException {
        if (randomAccessFile.length() < 22) {
            return null;
        }
        com.tencent.ysdk.shell.framework.channel.Pair<java.nio.ByteBuffer, java.lang.Long> pairFindZipEndOfCentralDirectoryRecord = findZipEndOfCentralDirectoryRecord(randomAccessFile, 0);
        return pairFindZipEndOfCentralDirectoryRecord != null ? pairFindZipEndOfCentralDirectoryRecord : findZipEndOfCentralDirectoryRecord(randomAccessFile, 65535);
    }

    private static com.tencent.ysdk.shell.framework.channel.Pair<java.nio.ByteBuffer, java.lang.Long> findZipEndOfCentralDirectoryRecord(java.io.RandomAccessFile randomAccessFile, int i) throws java.io.IOException {
        if (i < 0 || i > 65535) {
            throw new java.lang.IllegalArgumentException("maxCommentSize: " + i);
        }
        long length = randomAccessFile.length();
        if (length < 22) {
            return null;
        }
        java.nio.ByteBuffer byteBufferAllocate = java.nio.ByteBuffer.allocate(((int) java.lang.Math.min(i, length - 22)) + 22);
        byteBufferAllocate.order(java.nio.ByteOrder.LITTLE_ENDIAN);
        long jCapacity = length - ((long) byteBufferAllocate.capacity());
        randomAccessFile.seek(jCapacity);
        randomAccessFile.readFully(byteBufferAllocate.array(), byteBufferAllocate.arrayOffset(), byteBufferAllocate.capacity());
        int iFindZipEndOfCentralDirectoryRecord = findZipEndOfCentralDirectoryRecord(byteBufferAllocate);
        if (iFindZipEndOfCentralDirectoryRecord == -1) {
            return null;
        }
        byteBufferAllocate.position(iFindZipEndOfCentralDirectoryRecord);
        java.nio.ByteBuffer byteBufferSlice = byteBufferAllocate.slice();
        byteBufferSlice.order(java.nio.ByteOrder.LITTLE_ENDIAN);
        return com.tencent.ysdk.shell.framework.channel.Pair.create(byteBufferSlice, java.lang.Long.valueOf(jCapacity + ((long) iFindZipEndOfCentralDirectoryRecord)));
    }

    private static int getUnsignedInt16(java.nio.ByteBuffer byteBuffer, int i) {
        return byteBuffer.getShort(i) & com.tencent.smtt.export.external.interfaces.ISelectionInterface.HELD_NOTHING;
    }

    private static long getUnsignedInt32(java.nio.ByteBuffer byteBuffer, int i) {
        return ((long) byteBuffer.getInt(i)) & 4294967295L;
    }

    static long getZipEocdCentralDirectoryOffset(java.nio.ByteBuffer byteBuffer) {
        assertByteOrderLittleEndian(byteBuffer);
        return getUnsignedInt32(byteBuffer, byteBuffer.position() + 16);
    }

    static long getZipEocdCentralDirectorySizeBytes(java.nio.ByteBuffer byteBuffer) {
        assertByteOrderLittleEndian(byteBuffer);
        return getUnsignedInt32(byteBuffer, byteBuffer.position() + 12);
    }

    public static boolean isZip64EndOfCentralDirectoryLocatorPresent(java.io.RandomAccessFile randomAccessFile, long j) throws java.io.IOException {
        long j2 = j - 20;
        if (j2 < 0) {
            return false;
        }
        randomAccessFile.seek(j2);
        return randomAccessFile.readInt() == ZIP64_EOCD_LOCATOR_SIG_REVERSE_BYTE_ORDER;
    }

    private static void setUnsignedInt32(java.nio.ByteBuffer byteBuffer, int i, long j) {
        if (j >= 0 && j <= 4294967295L) {
            byteBuffer.putInt(byteBuffer.position() + i, (int) j);
            return;
        }
        throw new java.lang.IllegalArgumentException("uint32 value of out range: " + j);
    }

    static void setZipEocdCentralDirectoryOffset(java.nio.ByteBuffer byteBuffer, long j) {
        assertByteOrderLittleEndian(byteBuffer);
        setUnsignedInt32(byteBuffer, byteBuffer.position() + 16, j);
    }
}
