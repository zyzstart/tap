package com.bun.miitmdid.core;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.Keep
public class ZipUtils {
    private static final int BUFFER_SIZE = 16384;
    private static final int ENDHDR = 22;
    private static final int ENDSIG = 101010256;

    static class CentralDirectory {
        long offset;
        long size;

        CentralDirectory() {
        }
    }

    static long computeCrcOfCentralDir(java.io.RandomAccessFile randomAccessFile, com.bun.miitmdid.core.ZipUtils.CentralDirectory centralDirectory) throws java.io.IOException {
        java.util.zip.CRC32 crc32 = new java.util.zip.CRC32();
        long j = centralDirectory.size;
        randomAccessFile.seek(centralDirectory.offset);
        int iMin = (int) java.lang.Math.min(android.support.v4.media.session.PlaybackStateCompat.ACTION_PREPARE, j);
        byte[] bArr = new byte[16384];
        while (true) {
            int i = randomAccessFile.read(bArr, 0, iMin);
            if (i != -1) {
                crc32.update(bArr, 0, i);
                j -= (long) i;
                if (j == 0) {
                    break;
                }
                iMin = (int) java.lang.Math.min(android.support.v4.media.session.PlaybackStateCompat.ACTION_PREPARE, j);
            } else {
                break;
            }
        }
        return crc32.getValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @android.support.annotation.Keep
    static com.bun.miitmdid.core.ZipUtils.CentralDirectory findCentralDirectory(java.io.RandomAccessFile randomAccessFile) throws java.io.IOException {
        long length = randomAccessFile.length() - 22;
        if (length < 0) {
            throw new java.util.zip.ZipException("File too short to be a zip file: " + randomAccessFile.length());
        }
        long j = length - android.support.v4.media.session.PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        long j2 = j >= 0 ? j : 0L;
        int iReverseBytes = java.lang.Integer.reverseBytes(ENDSIG);
        do {
            randomAccessFile.seek(length);
            if (randomAccessFile.readInt() == iReverseBytes) {
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                com.bun.miitmdid.core.ZipUtils.CentralDirectory centralDirectory = new com.bun.miitmdid.core.ZipUtils.CentralDirectory();
                centralDirectory.size = ((long) java.lang.Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                centralDirectory.offset = ((long) java.lang.Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                return centralDirectory;
            }
            length--;
        } while (length >= j2);
        throw new java.util.zip.ZipException("End Of Central Directory signature not found");
    }

    @android.support.annotation.Keep
    public static long getZipCrc(java.io.File file) throws java.io.IOException {
        java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(file, "r");
        try {
            return computeCrcOfCentralDir(randomAccessFile, findCentralDirectory(randomAccessFile));
        } finally {
            randomAccessFile.close();
        }
    }
}
