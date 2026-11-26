package com.tencent.ysdk.shell.module.ad;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ADView {
    private java.lang.String action;
    private android.widget.TextView jumpOverTextView;
    private android.widget.RelativeLayout mContainer;
    private android.widget.ImageView mImageView;
    private android.view.WindowManager mWindowManager;
    private int screenHeight;
    private int screenWidth;
    private java.lang.String url;

    public ADView(java.lang.String str, java.lang.String str2) {
        this.url = str;
        this.action = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void hide() {
        try {
            this.mContainer.setVisibility(8);
            if (this.mContainer.getParent() != null) {
                this.mWindowManager.removeView(this.mContainer);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private void initUI() {
        if (this.mWindowManager == null) {
            this.mWindowManager = (android.view.WindowManager) com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity().getSystemService("window");
        }
        if (this.mImageView == null || this.mContainer == null || this.jumpOverTextView == null) {
            this.mContainer = (android.widget.RelativeLayout) android.view.LayoutInflater.from(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getPluginContext()).inflate(com.tencent.ysdk.shell.libware.ui.res.Res.layout("com_tencent_ysdk_ad"), (android.view.ViewGroup) null);
            this.mImageView = (android.widget.ImageView) this.mContainer.findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id("com_tencent_ysdk_ad_imageView"));
            this.jumpOverTextView = (android.widget.TextView) this.mContainer.findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id("com_tencent_ysdk_ad_jumpover"));
            this.jumpOverTextView.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.tencent.ysdk.shell.module.ad.ADView.2
                @Override // android.view.View.OnClickListener
                public void onClick(android.view.View view) {
                    com.tencent.ysdk.shell.module.ad.ADView.this.hide();
                }
            });
        }
        this.screenWidth = com.tencent.ysdk.shell.libware.ui.ViewUtils.getScreenWidth(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext());
        this.screenHeight = com.tencent.ysdk.shell.libware.ui.ViewUtils.getScreenHeight(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext());
        android.view.WindowManager.LayoutParams layoutParams = new android.view.WindowManager.LayoutParams(1000);
        layoutParams.height = this.screenHeight;
        layoutParams.width = this.screenWidth;
        if (this.mContainer.getParent() == null) {
            this.mWindowManager.addView(this.mContainer, layoutParams);
        } else {
            this.mWindowManager.updateViewLayout(this.mContainer, layoutParams);
        }
        this.mContainer.setVisibility(0);
        this.mImageView.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.tencent.ysdk.shell.module.ad.ADView.3
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                com.tencent.ysdk.shell.framework.web.router.IntentRouter.commonJump(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity(), com.tencent.ysdk.shell.module.ad.ADView.this.action, 2);
                com.tencent.ysdk.shell.module.ad.ADManagerStat.reportIconBasicEvent(com.tencent.ysdk.shell.module.ad.ADManagerStat.EVENT_AD_CLICK, 0, com.tencent.ysdk.shell.module.ad.ADView.this.action, null);
                com.tencent.ysdk.shell.module.ad.ADView.this.hide();
            }
        });
    }

    public void show() {
        initUI();
        com.tencent.ysdk.shell.module.ad.PicLoadManager.asyncLoadImage(this.url, this.mImageView, new com.tencent.ysdk.shell.module.ad.PicLoadManager.PicLoadListener() { // from class: com.tencent.ysdk.shell.module.ad.ADView.1
            @Override // com.tencent.ysdk.shell.module.ad.PicLoadManager.PicLoadListener
            public void onError() {
                com.tencent.ysdk.shell.module.ad.ADView.this.hide();
            }

            @Override // com.tencent.ysdk.shell.module.ad.PicLoadManager.PicLoadListener
            public void onSuccess() {
                com.tencent.ysdk.shell.module.ad.ADView.this.jumpOverTextView.setText("跳过 2");
                new android.os.Handler().postDelayed(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.module.ad.ADView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.ysdk.shell.module.ad.ADView.this.hide();
                        java.util.HashMap map = new java.util.HashMap();
                        map.put(com.tencent.ysdk.shell.module.ad.ADManagerStat.PARAM_AD_ACTION_URL, com.tencent.ysdk.shell.module.ad.ADView.this.action);
                        map.put(com.tencent.ysdk.shell.module.ad.ADManagerStat.PARAM_AD_IMAGE_URL, com.tencent.ysdk.shell.module.ad.ADView.this.url);
                        com.tencent.ysdk.shell.module.ad.ADManagerStat.reportIconBasicEvent(com.tencent.ysdk.shell.module.ad.ADManagerStat.EVENT_AD_JUMP, 0, "", null);
                    }
                }, 3000L);
                new android.os.Handler().postDelayed(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.module.ad.ADView.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.ysdk.shell.module.ad.ADView.this.jumpOverTextView.setText("跳过 0");
                    }
                }, com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewConstants.HIDE_BUBBLE_TASK_DELAY);
                new android.os.Handler().postDelayed(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.module.ad.ADView.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.ysdk.shell.module.ad.ADView.this.jumpOverTextView.setText("跳过 1");
                    }
                }, 1000L);
            }
        });
    }
}
