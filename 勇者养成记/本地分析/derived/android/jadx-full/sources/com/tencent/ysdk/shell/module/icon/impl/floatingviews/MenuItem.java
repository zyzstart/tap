package com.tencent.ysdk.shell.module.icon.impl.floatingviews;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class MenuItem {
    private static final java.lang.String PARAM_RED_FLAG = "show_me";
    private static final java.lang.String PARAM_RED_HAS_RED = "has_red";
    private static final java.lang.String PARAM_RED_ID = "id";
    private static final java.lang.String PARAM_RED_TAG = "red_point";
    private static final java.lang.String PARAM_RED_TS = "last_ts";
    protected static final java.lang.String PARA_ID = "uniq_id";
    private static final java.lang.String PARA_JUMP_URL = "jmp_url";
    private static final java.lang.String PARA_PIC_URL = "pic_url";
    private static final java.lang.String PARA_PIC_URL_SELECTED = "click_pic_url";
    private static final java.lang.String PARA_TITLE = "title";
    private static final java.lang.String TAG = "MenuItem";
    private java.lang.String iconID;
    private java.lang.String ts;
    private java.lang.String mJumpUrl = "";
    private java.lang.String mPicUrl = "";
    private java.lang.String mTitle = "";
    private java.lang.String mUniqId = "";
    private java.lang.String mClickPicUrl = "";
    private boolean isNew = false;
    private boolean isShow = false;
    private android.graphics.Bitmap mPicBitmap = null;
    private android.graphics.Bitmap mClickBitmap = null;

    public MenuItem(org.json.JSONObject jSONObject) {
        if (!jSONObject.has(PARA_ID)) {
            com.tencent.ysdk.shell.libware.file.Logger.d("mUniqId is not exist");
            return;
        }
        try {
            parseMenuItem(jSONObject);
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downLoadBitmap(final android.widget.ImageView imageView, boolean z, java.lang.String str) {
        try {
            final android.graphics.Bitmap bitmapDecodeStream = android.graphics.BitmapFactory.decodeStream(new java.net.URL(str).openStream());
            if (bitmapDecodeStream != null && !bitmapDecodeStream.isRecycled()) {
                if (z) {
                    this.mClickBitmap = bitmapDecodeStream;
                } else {
                    this.mPicBitmap = bitmapDecodeStream;
                }
                imageView.post(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.module.icon.impl.floatingviews.MenuItem.2
                    @Override // java.lang.Runnable
                    public void run() {
                        imageView.setImageBitmap(bitmapDecodeStream);
                    }
                });
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private void downloadAndSetBitmap(final android.widget.ImageView imageView, final boolean z, final java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        com.tencent.ysdk.shell.libware.thread.YSDKThreadManager.getInstance().start(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.module.icon.impl.floatingviews.MenuItem.1
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.ysdk.shell.module.icon.impl.floatingviews.MenuItem.this.downLoadBitmap(imageView, z, str);
            }
        });
    }

    private void parseMenuItem(org.json.JSONObject jSONObject) {
        org.json.JSONObject jSONObjectOptJSONObject;
        this.mJumpUrl = jSONObject.optString(PARA_JUMP_URL);
        this.mPicUrl = jSONObject.optString(PARA_PIC_URL);
        this.mTitle = jSONObject.optString("title");
        this.mUniqId = jSONObject.optString(PARA_ID);
        if (jSONObject.has(PARA_PIC_URL_SELECTED)) {
            this.mClickPicUrl = jSONObject.optString(PARA_PIC_URL_SELECTED);
        }
        if (jSONObject.has(PARAM_RED_TAG) && (jSONObjectOptJSONObject = jSONObject.optJSONObject(PARAM_RED_TAG)) != null) {
            parseRed(jSONObjectOptJSONObject);
        }
    }

    private void parseRed(org.json.JSONObject jSONObject) {
        if (jSONObject.has(PARAM_RED_FLAG)) {
            this.isShow = jSONObject.optInt(PARAM_RED_FLAG) > 0;
        }
        if (jSONObject.has(PARAM_RED_HAS_RED)) {
            this.isNew = jSONObject.optInt(PARAM_RED_HAS_RED) > 0;
        }
        if (this.isNew) {
            if (jSONObject.has(PARAM_RED_ID)) {
                java.lang.String strOptString = jSONObject.optString(PARAM_RED_ID);
                if (!android.text.TextUtils.isEmpty(strOptString)) {
                    this.iconID = strOptString;
                }
            }
            if (jSONObject.has(PARAM_RED_TS)) {
                java.lang.String strOptString2 = jSONObject.optString(PARAM_RED_TS);
                if (android.text.TextUtils.isEmpty(strOptString2)) {
                    return;
                }
                this.ts = strOptString2;
            }
        }
    }

    public java.lang.String getClickPicUrl() {
        return this.mClickPicUrl;
    }

    public java.lang.String getIconID() {
        return this.iconID;
    }

    public java.lang.String getJumpUrl() {
        return this.mJumpUrl;
    }

    public java.lang.String getPicUrl() {
        return this.mPicUrl;
    }

    public java.lang.String getTitle() {
        return this.mTitle;
    }

    public java.lang.String getTs() {
        return this.ts;
    }

    public java.lang.String getUniqId() {
        return this.mUniqId;
    }

    public boolean isNew() {
        this.isNew = com.tencent.ysdk.shell.module.icon.impl.IconRedPointManager.needShowRedPoint(this.iconID, this.ts);
        return this.isNew;
    }

    public boolean isShow() {
        return this.isShow;
    }

    public void setBitmapToImgView(android.widget.ImageView imageView, boolean z) {
        if (!z) {
            android.graphics.Bitmap bitmap = this.mPicBitmap;
            if (bitmap == null || bitmap.isRecycled()) {
                downloadAndSetBitmap(imageView, false, this.mPicUrl);
                return;
            } else {
                imageView.setImageBitmap(this.mPicBitmap);
                return;
            }
        }
        android.graphics.Bitmap bitmap2 = this.mClickBitmap;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            imageView.setImageBitmap(this.mClickBitmap);
        } else {
            if (android.text.TextUtils.isEmpty(this.mClickPicUrl)) {
                return;
            }
            downloadAndSetBitmap(imageView, true, this.mClickPicUrl);
        }
    }

    public void setIsNew(boolean z) {
        this.isNew = z;
    }

    public void setSelected(com.tencent.ysdk.shell.module.icon.impl.floatingviews.MenuItemView menuItemView, boolean z) {
        setBitmapToImgView(menuItemView.itemIcon, z);
    }

    public java.lang.String toString() {
        return "MenuItem{mJumpUrl='" + this.mJumpUrl + "', mPicUrl='" + this.mPicUrl + "', mTitle='" + this.mTitle + "', mUniqId='" + this.mUniqId + "', isNew=" + this.isNew + ", isShow=" + this.isShow + '}';
    }
}
