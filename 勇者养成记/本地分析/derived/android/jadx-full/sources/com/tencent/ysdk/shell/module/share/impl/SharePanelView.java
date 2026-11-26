package com.tencent.ysdk.shell.module.share.impl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class SharePanelView extends android.widget.RelativeLayout implements android.view.View.OnClickListener {
    private static final java.lang.String UI_ID_BBS_VIEW = "com_tencent_ysdk_bbs";
    private static final java.lang.String UI_ID_QQ_VIEW = "com_tencent_ysdk_qq";
    private static final java.lang.String UI_ID_QZONE_VIEW = "com_tencent_ysdk_qzone";
    private static final java.lang.String UI_ID_VIEW_SCREENSHOT = "com_tencent_ysdk_screenshot";
    private static final java.lang.String UI_ID_WXTimeLine_VIEW = "com_tencent_ysdk_wx_time_line";
    private static final java.lang.String UI_ID_WX_VIEW = "com_tencent_ysdk_wx";
    private static final java.lang.String UI_LAYOUT_VIEW = "com_tencent_ysdk_share_panel_view";
    private static final java.lang.String UI_LAYOUT_VIEW_LAND = "com_tencent_ysdk_share_panel_view_land";
    private static final java.lang.String UI_VIEW_CONTAINER = "com_tencent_ysdk_container";
    private boolean isFromScreenCapture;
    private boolean isShowed;
    private com.tencent.ysdk.shell.module.share.impl.SharePanelView.OnShareClickListener listener;
    private android.widget.LinearLayout mContainer;
    private android.content.Context mContext;
    private android.graphics.Bitmap mIconCacheShareToBBS;
    private android.widget.TextView mTvBbsShare;
    private android.widget.TextView mTvQQShare;
    private android.widget.TextView mTvQZoneShare;
    private android.widget.TextView mTvWxShare;
    private android.widget.TextView mTvWxTimeLineShare;
    private android.view.WindowManager mWindowManager;

    public interface OnShareClickListener {
        void onShareBBS();

        void onShareQQ();

        void onShareQZone();

        void onShareWX();

        void onShareWX_Timeline();
    }

    public SharePanelView(android.content.Context context) {
        super(context);
        this.isShowed = false;
        this.mContext = context;
        initView();
        initClickEvent();
    }

    private android.view.WindowManager getWindowManager() {
        if (this.mWindowManager == null) {
            this.mWindowManager = (android.view.WindowManager) com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity().getSystemService("window");
        }
        return this.mWindowManager;
    }

    private void initClickEvent() {
        this.mTvBbsShare.setOnClickListener(this);
        this.mTvWxShare.setOnClickListener(this);
        this.mTvWxTimeLineShare.setOnClickListener(this);
        this.mTvQQShare.setOnClickListener(this);
        this.mTvQZoneShare.setOnClickListener(this);
        setOnClickListener(this);
    }

    private void initView() {
        android.view.LayoutInflater.from(this.mContext).inflate(com.tencent.ysdk.shell.libware.ui.res.Res.layout(UI_LAYOUT_VIEW_LAND), this);
        this.mContainer = (android.widget.LinearLayout) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_VIEW_CONTAINER));
        this.mTvBbsShare = (android.widget.TextView) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_ID_BBS_VIEW));
        this.mTvWxShare = (android.widget.TextView) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_ID_WX_VIEW));
        this.mTvWxTimeLineShare = (android.widget.TextView) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_ID_WXTimeLine_VIEW));
        this.mTvQQShare = (android.widget.TextView) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_ID_QQ_VIEW));
        this.mTvQZoneShare = (android.widget.TextView) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_ID_QZONE_VIEW));
    }

    private void loadIconImageView() {
        if (this.mTvBbsShare != null) {
            android.graphics.Bitmap bitmap = this.mIconCacheShareToBBS;
            if (bitmap == null) {
                new java.lang.Thread(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.module.share.impl.SharePanelView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            android.graphics.Bitmap bitmapDecodeStream = android.graphics.BitmapFactory.decodeStream(new java.net.URL("https://ysdkwebs.qq.com/iconshare/query_icon_logo/?[REDACTED]" + com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getQQAppId()).openStream());
                            if (bitmapDecodeStream != null) {
                                com.tencent.ysdk.shell.module.share.impl.SharePanelView.this.mIconCacheShareToBBS = bitmapDecodeStream;
                                com.tencent.ysdk.shell.module.share.impl.SharePanelView.this.mTvBbsShare.post(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.module.share.impl.SharePanelView.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        android.graphics.drawable.BitmapDrawable bitmapDrawable = new android.graphics.drawable.BitmapDrawable(com.tencent.ysdk.shell.module.share.impl.SharePanelView.this.mIconCacheShareToBBS);
                                        int iDip2px = com.tencent.ysdk.shell.libware.ui.ViewUtils.dip2px(com.tencent.ysdk.shell.module.share.impl.SharePanelView.this.mTvBbsShare.getContext(), 54.0f);
                                        bitmapDrawable.setBounds(new android.graphics.Rect(0, 0, iDip2px, iDip2px));
                                        com.tencent.ysdk.shell.module.share.impl.SharePanelView.this.mTvBbsShare.setCompoundDrawables(null, bitmapDrawable, null, null);
                                    }
                                });
                            }
                        } catch (java.lang.Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                return;
            }
            android.graphics.drawable.BitmapDrawable bitmapDrawable = new android.graphics.drawable.BitmapDrawable(bitmap);
            int iDip2px = com.tencent.ysdk.shell.libware.ui.ViewUtils.dip2px(this.mTvBbsShare.getContext(), 54.0f);
            bitmapDrawable.setBounds(new android.graphics.Rect(0, 0, iDip2px, iDip2px));
            this.mTvBbsShare.setCompoundDrawables(null, bitmapDrawable, null, null);
        }
    }

    private void reSizeIcon() {
        try {
            int iDip2px = com.tencent.ysdk.shell.libware.ui.ViewUtils.dip2px(getContext(), 54.0f);
            android.graphics.Rect rect = new android.graphics.Rect(0, 0, iDip2px, iDip2px);
            android.graphics.drawable.Drawable drawable = this.mTvBbsShare.getCompoundDrawables()[1];
            drawable.setBounds(rect);
            this.mTvBbsShare.setCompoundDrawables(null, drawable, null, null);
            android.graphics.drawable.Drawable drawable2 = this.mTvWxShare.getCompoundDrawables()[1];
            drawable2.setBounds(rect);
            this.mTvWxShare.setCompoundDrawables(null, drawable2, null, null);
            android.graphics.drawable.Drawable drawable3 = this.mTvWxTimeLineShare.getCompoundDrawables()[1];
            drawable3.setBounds(rect);
            this.mTvWxTimeLineShare.setCompoundDrawables(null, drawable3, null, null);
            android.graphics.drawable.Drawable drawable4 = this.mTvQQShare.getCompoundDrawables()[1];
            drawable4.setBounds(rect);
            this.mTvQQShare.setCompoundDrawables(null, drawable4, null, null);
            android.graphics.drawable.Drawable drawable5 = this.mTvQZoneShare.getCompoundDrawables()[1];
            drawable5.setBounds(rect);
            this.mTvQZoneShare.setCompoundDrawables(null, drawable5, null, null);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private void showToast() {
        android.widget.Toast.makeText(this.mContext, "正在分享...", 1).show();
    }

    public void hideSharePanel() {
        this.mWindowManager = getWindowManager();
        this.mWindowManager.removeView(this);
        this.isShowed = false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        com.tencent.ysdk.shell.module.share.impl.SharePanelView.OnShareClickListener onShareClickListener = this.listener;
        if (onShareClickListener == null) {
            return;
        }
        if (view == this.mTvBbsShare) {
            onShareClickListener.onShareBBS();
        } else if (view == this.mTvWxShare) {
            onShareClickListener.onShareWX();
        } else if (view == this.mTvWxTimeLineShare) {
            onShareClickListener.onShareWX_Timeline();
        } else if (view == this.mTvQQShare) {
            onShareClickListener.onShareQQ();
        } else if (view == this.mTvQZoneShare) {
            onShareClickListener.onShareQZone();
        }
        if (view != this) {
            showToast();
        }
        hideSharePanel();
    }

    public void regShareClickListener(com.tencent.ysdk.shell.module.share.impl.SharePanelView.OnShareClickListener onShareClickListener) {
        this.listener = onShareClickListener;
    }

    public void setIsScreenCap(boolean z) {
        this.isFromScreenCapture = z;
        if (z) {
            this.mTvBbsShare.setVisibility(0);
        } else {
            this.mTvBbsShare.setVisibility(8);
        }
    }

    public void setScreenCap(android.graphics.Bitmap bitmap) {
        try {
            android.widget.ImageView imageView = (android.widget.ImageView) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_ID_VIEW_SCREENSHOT));
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            imageView.setImageBitmap(bitmap);
            int height = bitmap.getHeight();
            int width = bitmap.getWidth();
            android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) imageView.getLayoutParams();
            if (this.mContext.getResources().getConfiguration().orientation == 1) {
                double d = height;
                java.lang.Double.isNaN(d);
                layoutParams.height = (int) (d / 1.5d);
                double d2 = width;
                java.lang.Double.isNaN(d2);
                layoutParams.width = (int) (d2 / 1.5d);
            } else {
                double d3 = height;
                java.lang.Double.isNaN(d3);
                layoutParams.height = (int) (d3 / 2.5d);
                double d4 = width;
                java.lang.Double.isNaN(d4);
                layoutParams.width = (int) (d4 / 2.5d);
            }
            imageView.setLayoutParams(layoutParams);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void showSharePanel() {
        if (this.isShowed) {
            return;
        }
        this.mWindowManager = getWindowManager();
        android.view.WindowManager.LayoutParams layoutParams = new android.view.WindowManager.LayoutParams(1002);
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.format = -3;
        if (getParent() == null) {
            this.mWindowManager.addView(this, layoutParams);
        } else {
            this.mWindowManager.updateViewLayout(this, layoutParams);
        }
        reSizeIcon();
        loadIconImageView();
        this.mContainer.setLayoutParams((android.widget.RelativeLayout.LayoutParams) this.mContainer.getLayoutParams());
        setVisibility(0);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        setClickable(true);
        this.isShowed = true;
    }
}
