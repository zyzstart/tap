package com.tencent.ysdk.shell.framework.channel;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class ZipEocdCommentTool {
    public static final int CFD_LOCATOR_OFFSET = 16;
    private static final com.tencent.ysdk.shell.framework.channel.ZipLong EOCD_SIG = new com.tencent.ysdk.shell.framework.channel.ZipLong(101010256);
    public static final int MIN_EOCD_SIZE = 22;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static byte[] readComment(java.io.RandomAccessFile randomAccessFile) throws java.io.IOException {
        boolean z;
        long length = randomAccessFile.length() - 22;
        randomAccessFile.seek(length);
        byte[] bytes = EOCD_SIG.getBytes();
        int i = randomAccessFile.read();
        while (true) {
            z = true;
            if (i == -1) {
                z = false;
                break;
            }
            if (i == bytes[0] && randomAccessFile.read() == bytes[1] && randomAccessFile.read() == bytes[2] && randomAccessFile.read() == bytes[3]) {
                break;
            }
            length--;
            randomAccessFile.seek(length);
            i = randomAccessFile.read();
        }
        if (!z) {
            throw new java.util.zip.ZipException("archive is not a ZIP archive");
        }
        randomAccessFile.seek(length + 16 + 4);
        byte[] bArr = new byte[2];
        randomAccessFile.readFully(bArr);
        int value = new com.tencent.ysdk.shell.framework.channel.ZipShort(bArr).getValue();
        if (value == 0) {
            return null;
        }
        byte[] bArr2 = new byte[value];
        randomAccessFile.read(bArr2);
        return bArr2;
    }

    public static byte[] readComment(java.lang.String str) throws java.io.IOException {
        if (str == null || str.length() <= 0) {
            return null;
        }
        java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(str, "r");
        if (randomAccessFile.length() == 0) {
            randomAccessFile.close();
            java.lang.System.out.println("ERROR:[ZipEocdCommentTool]Your file length is zero!");
            return null;
        }
        byte[] comment = readComment(randomAccessFile);
        randomAccessFile.close();
        return comment;
    }

    public static boolean updateComment(java.lang.String str, byte[] bArr) throws java.lang.Exception {
        java.io.RandomAccessFile randomAccessFile;
        if (bArr == null || str == null || str.length() <= 0) {
            return false;
        }
        try {
            randomAccessFile = new java.io.RandomAccessFile(str, "rw");
            try {
                if (randomAccessFile.length() == 0) {
                    randomAccessFile.close();
                    throw new java.lang.Exception("Your file length is zero !!");
                }
                byte[] comment = readComment(randomAccessFile);
                long length = comment != null ? comment.length : 0;
                long length2 = (randomAccessFile.length() - length) + ((long) bArr.length);
                randomAccessFile.seek((randomAccessFile.length() - 2) - length);
                randomAccessFile.write(new com.tencent.ysdk.shell.framework.channel.ZipShort(bArr.length).getBytes());
                randomAccessFile.write(bArr);
                randomAccessFile.setLength(length2);
                randomAccessFile.close();
                return true;
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
}
