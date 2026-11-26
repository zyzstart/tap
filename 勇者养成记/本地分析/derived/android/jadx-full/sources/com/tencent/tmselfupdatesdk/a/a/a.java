package com.tencent.tmselfupdatesdk.a.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.tencent.tmselfupdatesdk.a.a.b f1146a = new com.tencent.tmselfupdatesdk.a.a.b(101010256);
    private static final com.tencent.tmselfupdatesdk.a.a.c b = new com.tencent.tmselfupdatesdk.a.a.c(38650);

    public static boolean a(java.lang.String str, java.lang.String str2) throws java.lang.Exception {
        com.tencent.tmassistantbase.util.TMLog.i("ApkExternalInfoTool", "enter");
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            com.tencent.tmassistantbase.util.TMLog.i("ApkExternalInfoTool", "TextUtils.isEmpty(oldFilePath) || TextUtils.isEmpty(newFilePath)");
            com.tencent.tmassistantbase.util.TMLog.i("ApkExternalInfoTool", "exit");
            throw new java.lang.Exception("Your file path is empty!");
        }
        com.tencent.tmassistantbase.util.TMLog.i("ApkExternalInfoTool", "oldFilePath =" + str + "; newFilePath = " + str2);
        java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(str, "r");
        java.io.RandomAccessFile randomAccessFile2 = new java.io.RandomAccessFile(str2, "rw");
        if (randomAccessFile.length() == 0 || randomAccessFile2.length() == 0) {
            randomAccessFile.close();
            randomAccessFile2.close();
            throw new java.lang.Exception("Your file length is zero !!");
        }
        byte[] bArrA = a(randomAccessFile);
        byte[] bArrA2 = a(randomAccessFile2);
        int length = 0;
        if (bArrA == null) {
            com.tencent.tmassistantbase.util.TMLog.w("ApkExternalInfoTool", "old comment is null");
            return false;
        }
        com.tencent.tmassistantbase.util.TMLog.i("ApkExternalInfoTool", "old comment=" + com.tencent.tmassistantbase.util.n.b(bArrA));
        int length2 = bArrA.length;
        if (bArrA2 != null) {
            com.tencent.tmassistantbase.util.TMLog.i("ApkExternalInfoTool", "new comment=" + com.tencent.tmassistantbase.util.n.b(bArrA2));
            length = bArrA2.length;
        }
        long j = length;
        long length3 = (randomAccessFile2.length() - j) + ((long) length2);
        com.tencent.tmassistantbase.util.TMLog.i("ApkExternalInfoTool", "oldCommentLength = " + length2 + ", newCommentLength = " + length + ", oldArchiveFileLength = " + randomAccessFile.length() + ", newArchiveFileLength = " + length3);
        randomAccessFile2.seek((randomAccessFile2.length() - 2) - j);
        randomAccessFile2.write(new com.tencent.tmselfupdatesdk.a.a.c(length2).a());
        randomAccessFile2.write(bArrA);
        randomAccessFile2.setLength(length3);
        randomAccessFile.close();
        randomAccessFile2.close();
        com.tencent.tmassistantbase.util.TMLog.i("ApkExternalInfoTool", "exit");
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static byte[] a(java.io.RandomAccessFile randomAccessFile) throws java.io.IOException {
        boolean z;
        long length = randomAccessFile.length() - 22;
        randomAccessFile.seek(length);
        byte[] bArrA = f1146a.a();
        while (true) {
            int i = randomAccessFile.read();
            z = true;
            if (i == -1) {
                z = false;
                break;
            }
            if (i == bArrA[0] && randomAccessFile.read() == bArrA[1] && randomAccessFile.read() == bArrA[2] && randomAccessFile.read() == bArrA[3]) {
                break;
            }
            length--;
            randomAccessFile.seek(length);
        }
        if (!z) {
            com.tencent.tmassistantbase.util.TMLog.e("ApkExternalInfoTool", "archive is not a ZIP archive");
            throw new java.util.zip.ZipException("archive is not a ZIP archive");
        }
        randomAccessFile.seek(length + 16 + 4);
        byte[] bArr = new byte[2];
        randomAccessFile.readFully(bArr);
        int iB = new com.tencent.tmselfupdatesdk.a.a.c(bArr).b();
        if (iB == 0) {
            return null;
        }
        byte[] bArr2 = new byte[iB];
        randomAccessFile.read(bArr2);
        return bArr2;
    }
}
