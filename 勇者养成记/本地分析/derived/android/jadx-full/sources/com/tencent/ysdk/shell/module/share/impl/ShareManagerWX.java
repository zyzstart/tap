package com.tencent.ysdk.shell.module.share.impl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ShareManagerWX {
    private static final int THUMB_SIZE = 150;
    private com.tencent.mm.opensdk.openapi.IWXAPI mWXApi;

    public ShareManagerWX(com.tencent.mm.opensdk.openapi.IWXAPI iwxapi) {
        this.mWXApi = iwxapi;
    }

    private byte[] bitmapToArray(android.graphics.Bitmap bitmap) {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        bitmap.recycle();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return byteArray;
    }

    private android.graphics.Bitmap fileToBitmap(java.io.File file) {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inPreferredConfig = android.graphics.Bitmap.Config.RGB_565;
        return android.graphics.BitmapFactory.decodeFile(file.getPath(), options);
    }

    public void shareToFriend(java.io.File file, java.lang.String str, java.lang.String str2) {
        android.graphics.Bitmap bitmapFileToBitmap = fileToBitmap(file);
        int width = bitmapFileToBitmap.getWidth();
        int height = bitmapFileToBitmap.getHeight();
        float f = width > height ? width / THUMB_SIZE : height / THUMB_SIZE;
        if (f > 1.0f) {
            width = (int) (width / f);
            height = (int) (height / f);
        }
        com.tencent.mm.opensdk.modelmsg.WXImageObject wXImageObject = new com.tencent.mm.opensdk.modelmsg.WXImageObject(bitmapFileToBitmap);
        com.tencent.mm.opensdk.modelmsg.WXMediaMessage wXMediaMessage = new com.tencent.mm.opensdk.modelmsg.WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        android.graphics.Bitmap bitmapCreateScaledBitmap = android.graphics.Bitmap.createScaledBitmap(bitmapFileToBitmap, width, height, true);
        wXMediaMessage.thumbData = bitmapToArray(bitmapCreateScaledBitmap);
        if (!bitmapFileToBitmap.isRecycled()) {
            bitmapFileToBitmap.recycle();
        }
        if (!bitmapCreateScaledBitmap.isRecycled()) {
            bitmapCreateScaledBitmap.recycle();
        }
        com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req req = new com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req();
        req.transaction = com.tencent.ysdk.shell.module.share.impl.ShareModule.WX_SHARE_PREFIX + java.lang.System.currentTimeMillis();
        req.message = wXMediaMessage;
        req.scene = 0;
        this.mWXApi.sendReq(req);
    }

    public void shareToTimeLine(java.io.File file, java.lang.String str, java.lang.String str2) {
        android.graphics.Bitmap bitmapFileToBitmap = fileToBitmap(file);
        int width = bitmapFileToBitmap.getWidth();
        int height = bitmapFileToBitmap.getHeight();
        float f = width > height ? width / THUMB_SIZE : height / THUMB_SIZE;
        if (f > 1.0f) {
            width = (int) (width / f);
            height = (int) (height / f);
        }
        com.tencent.mm.opensdk.modelmsg.WXImageObject wXImageObject = new com.tencent.mm.opensdk.modelmsg.WXImageObject(bitmapFileToBitmap);
        com.tencent.mm.opensdk.modelmsg.WXMediaMessage wXMediaMessage = new com.tencent.mm.opensdk.modelmsg.WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        android.graphics.Bitmap bitmapCreateScaledBitmap = android.graphics.Bitmap.createScaledBitmap(bitmapFileToBitmap, width, height, true);
        wXMediaMessage.thumbData = bitmapToArray(bitmapCreateScaledBitmap);
        if (!bitmapCreateScaledBitmap.isRecycled()) {
            bitmapCreateScaledBitmap.recycle();
        }
        if (!bitmapFileToBitmap.isRecycled()) {
            bitmapFileToBitmap.recycle();
        }
        com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req req = new com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req();
        req.transaction = com.tencent.ysdk.shell.module.share.impl.ShareModule.WX_SHARE_PREFIX + java.lang.System.currentTimeMillis();
        req.message = wXMediaMessage;
        req.scene = 1;
        this.mWXApi.sendReq(req);
    }

    public void shareURLToFriend(byte[] bArr, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.tencent.mm.opensdk.modelmsg.WXWebpageObject wXWebpageObject = new com.tencent.mm.opensdk.modelmsg.WXWebpageObject();
        wXWebpageObject.webpageUrl = str;
        com.tencent.mm.opensdk.modelmsg.WXMediaMessage wXMediaMessage = new com.tencent.mm.opensdk.modelmsg.WXMediaMessage(wXWebpageObject);
        wXMediaMessage.title = str2;
        wXMediaMessage.description = str3;
        wXMediaMessage.thumbData = bArr;
        com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req req = new com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req();
        req.transaction = com.tencent.ysdk.shell.module.share.impl.ShareModule.WX_SHARE_PREFIX + java.lang.System.currentTimeMillis();
        req.message = wXMediaMessage;
        req.scene = 0;
        this.mWXApi.sendReq(req);
    }

    public void shareURLToWXTimeline(byte[] bArr, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.tencent.mm.opensdk.modelmsg.WXWebpageObject wXWebpageObject = new com.tencent.mm.opensdk.modelmsg.WXWebpageObject();
        wXWebpageObject.webpageUrl = str;
        com.tencent.mm.opensdk.modelmsg.WXMediaMessage wXMediaMessage = new com.tencent.mm.opensdk.modelmsg.WXMediaMessage(wXWebpageObject);
        wXMediaMessage.title = str2;
        wXMediaMessage.description = str3;
        wXMediaMessage.thumbData = bArr;
        com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req req = new com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req();
        req.transaction = com.tencent.ysdk.shell.module.share.impl.ShareModule.WX_SHARE_PREFIX + java.lang.System.currentTimeMillis();
        req.message = wXMediaMessage;
        req.scene = 1;
        this.mWXApi.sendReq(req);
    }
}
