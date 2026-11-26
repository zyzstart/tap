package com.tencent.ysdk.shell.framework.channel;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class ApkChannelTool {
    public static final java.lang.String ADJUST_TRACKER_TOKEN = "[REDACTED]";
    public static final java.lang.String CHANNEL_ID = "channelId";
    private static final java.lang.String TAG = "YSDK Channel";

    private static com.tencent.ysdk.shell.framework.channel.ZipComment generateZipComment(byte[] bArr) throws java.io.IOException {
        com.tencent.ysdk.shell.framework.channel.ZipComment zipComment = new com.tencent.ysdk.shell.framework.channel.ZipComment();
        try {
            zipComment.decode(bArr);
            return zipComment;
        } catch (java.net.ProtocolException e) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, e);
            return null;
        }
    }

    public static java.lang.String readChannel(java.lang.String str) throws java.io.IOException {
        com.tencent.ysdk.shell.framework.channel.ZipComment comment = readComment(str);
        if (comment == null) {
            return null;
        }
        return comment.getP().getProperty(CHANNEL_ID);
    }

    private static com.tencent.ysdk.shell.framework.channel.ZipComment readComment(java.lang.String str) throws java.io.IOException {
        boolean zIsSignatureV3Apk = com.tencent.ysdk.shell.framework.channel.ApkSignatureV2ChannelTool.isSignatureV3Apk(str);
        byte[] v2V3Comment = zIsSignatureV3Apk ? readV2V3Comment(str) : null;
        com.tencent.ysdk.shell.framework.channel.ZipComment zipCommentGenerateZipComment = v2V3Comment != null ? generateZipComment(v2V3Comment) : null;
        if (zipCommentGenerateZipComment != null) {
            com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "v3");
            return zipCommentGenerateZipComment;
        }
        boolean zIsSignatureV2Apk = com.tencent.ysdk.shell.framework.channel.ApkSignatureV2ChannelTool.isSignatureV2Apk(str);
        if (zIsSignatureV2Apk) {
            v2V3Comment = readV2V3Comment(str);
        }
        if (v2V3Comment != null) {
            zipCommentGenerateZipComment = generateZipComment(v2V3Comment);
        }
        if (zipCommentGenerateZipComment != null) {
            com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "v2");
            return zipCommentGenerateZipComment;
        }
        if (v2V3Comment == null) {
            com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "v3 " + zIsSignatureV3Apk + " , v2 " + zIsSignatureV2Apk);
            v2V3Comment = com.tencent.ysdk.shell.framework.channel.ZipEocdCommentTool.readComment(str);
        }
        if (v2V3Comment == null) {
            return null;
        }
        return generateZipComment(v2V3Comment);
    }

    private static byte[] readV2V3Comment(java.lang.String str) throws java.io.IOException {
        try {
            return com.tencent.ysdk.shell.framework.channel.ApkSignatureV2ChannelTool.readComment(str);
        } catch (com.tencent.ysdk.shell.framework.channel.ApkSignatureSchemeV2Verifier.SignatureNotFoundException e) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, e);
            return null;
        }
    }
}
