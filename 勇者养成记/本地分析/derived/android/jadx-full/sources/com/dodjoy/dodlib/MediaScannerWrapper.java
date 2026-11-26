package com.dodjoy.dodlib;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class MediaScannerWrapper implements android.media.MediaScannerConnection.MediaScannerConnectionClient {
    private android.media.MediaScannerConnection mConnection;
    private java.lang.String mMimeType;
    private java.lang.String mPath;

    public MediaScannerWrapper(android.content.Context context, java.lang.String str, java.lang.String str2) {
        this.mPath = str;
        this.mMimeType = str2;
        this.mConnection = new android.media.MediaScannerConnection(context, this);
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        this.mConnection.scanFile(this.mPath, this.mMimeType);
        android.util.Log.w("MediaScannerWrapper", "media file scanned: " + this.mPath);
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(java.lang.String str, android.net.Uri uri) {
    }

    public void scan() {
        this.mConnection.connect();
    }
}
