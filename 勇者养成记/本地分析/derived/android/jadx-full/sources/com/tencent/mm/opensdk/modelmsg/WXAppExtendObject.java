package com.tencent.mm.opensdk.modelmsg;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class WXAppExtendObject implements com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject {
    private static final int CONTENT_LENGTH_LIMIT = 10485760;
    private static final int EXTINFO_LENGTH_LIMIT = 2048;
    private static final int PATH_LENGTH_LIMIT = 10240;
    private static final java.lang.String TAG = "MicroMsg.SDK.WXAppExtendObject";
    public java.lang.String extInfo;
    public byte[] fileData;
    public java.lang.String filePath;

    public WXAppExtendObject() {
    }

    public WXAppExtendObject(java.lang.String str, java.lang.String str2) {
        this.extInfo = str;
        this.filePath = str2;
    }

    public WXAppExtendObject(java.lang.String str, byte[] bArr) {
        this.extInfo = str;
        this.fileData = bArr;
    }

    private int getFileSize(java.lang.String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        java.io.File file = new java.io.File(str);
        if (file.exists()) {
            return (int) file.length();
        }
        return 0;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        java.lang.String str;
        byte[] bArr;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4 = this.extInfo;
        if ((str4 == null || str4.length() == 0) && (((str = this.filePath) == null || str.length() == 0) && ((bArr = this.fileData) == null || bArr.length == 0))) {
            str2 = TAG;
            str3 = "checkArgs fail, all arguments is null";
        } else {
            java.lang.String str5 = this.extInfo;
            if (str5 == null || str5.length() <= 2048) {
                java.lang.String str6 = this.filePath;
                if (str6 == null || str6.length() <= PATH_LENGTH_LIMIT) {
                    java.lang.String str7 = this.filePath;
                    if (str7 == null || getFileSize(str7) <= CONTENT_LENGTH_LIMIT) {
                        byte[] bArr2 = this.fileData;
                        if (bArr2 == null || bArr2.length <= CONTENT_LENGTH_LIMIT) {
                            return true;
                        }
                        str2 = TAG;
                        str3 = "checkArgs fail, fileData is too large";
                    } else {
                        str2 = TAG;
                        str3 = "checkArgs fail, fileSize is too large";
                    }
                } else {
                    str2 = TAG;
                    str3 = "checkArgs fail, filePath is invalid";
                }
            } else {
                str2 = TAG;
                str3 = "checkArgs fail, extInfo is invalid";
            }
        }
        com.tencent.mm.opensdk.utils.Log.e(str2, str3);
        return false;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(android.os.Bundle bundle) {
        bundle.putString("_wxappextendobject_extInfo", this.extInfo);
        bundle.putByteArray("_wxappextendobject_fileData", this.fileData);
        bundle.putString("_wxappextendobject_filePath", this.filePath);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 7;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(android.os.Bundle bundle) {
        this.extInfo = bundle.getString("_wxappextendobject_extInfo");
        this.fileData = bundle.getByteArray("_wxappextendobject_fileData");
        this.filePath = bundle.getString("_wxappextendobject_filePath");
    }
}
