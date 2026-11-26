package com.tencent.mm.opensdk.modelmsg;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class WXMusicObject implements com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject {
    private static final int LENGTH_LIMIT = 10240;
    private static final java.lang.String TAG = "MicroMsg.SDK.WXMusicObject";
    public java.lang.String musicDataUrl;
    public java.lang.String musicLowBandDataUrl;
    public java.lang.String musicLowBandUrl;
    public java.lang.String musicUrl;

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4 = this.musicUrl;
        if ((str4 == null || str4.length() == 0) && ((str = this.musicLowBandUrl) == null || str.length() == 0)) {
            str2 = TAG;
            str3 = "both arguments are null";
        } else {
            java.lang.String str5 = this.musicUrl;
            if (str5 == null || str5.length() <= LENGTH_LIMIT) {
                java.lang.String str6 = this.musicLowBandUrl;
                if (str6 == null || str6.length() <= LENGTH_LIMIT) {
                    return true;
                }
                str2 = TAG;
                str3 = "checkArgs fail, musicLowBandUrl is too long";
            } else {
                str2 = TAG;
                str3 = "checkArgs fail, musicUrl is too long";
            }
        }
        com.tencent.mm.opensdk.utils.Log.e(str2, str3);
        return false;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(android.os.Bundle bundle) {
        bundle.putString("_wxmusicobject_musicUrl", this.musicUrl);
        bundle.putString("_wxmusicobject_musicLowBandUrl", this.musicLowBandUrl);
        bundle.putString("_wxmusicobject_musicDataUrl", this.musicDataUrl);
        bundle.putString("_wxmusicobject_musicLowBandDataUrl", this.musicLowBandDataUrl);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 3;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(android.os.Bundle bundle) {
        this.musicUrl = bundle.getString("_wxmusicobject_musicUrl");
        this.musicLowBandUrl = bundle.getString("_wxmusicobject_musicLowBandUrl");
        this.musicDataUrl = bundle.getString("_wxmusicobject_musicDataUrl");
        this.musicLowBandDataUrl = bundle.getString("_wxmusicobject_musicLowBandDataUrl");
    }
}
