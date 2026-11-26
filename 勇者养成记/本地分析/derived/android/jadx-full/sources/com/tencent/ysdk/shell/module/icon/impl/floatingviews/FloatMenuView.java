package com.tencent.ysdk.shell.module.icon.impl.floatingviews;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class FloatMenuView extends android.widget.LinearLayout implements android.view.View.OnTouchListener {
    public static final int DEFAULT_MAX_NUM = 10;

    @androidx.annotation.ColorInt
    private static final int MENU_BACKGROUND = android.graphics.Color.parseColor("#0A0B16");
    public static final java.lang.String TAG = "YSDK FloatMenuView";
    private static final long TIME_SHOW_JS_RESULT = 3000;
    private static final java.lang.String UI_COLOR_RELEASE_MEMORY_RESULT_TIPS_TEXT_HIGHLIGHT_COLOR = "floating_winddow_result_text_color_highlight";
    private static final java.lang.String UI_ID_FLOAT_WINDOW = "com_tencent_ysdk_icon_floatwindow";
    private static final java.lang.String UI_ID_SCREEN_ICON = "com_tencent_ysdk_icon_float_view_screen_capture";
    private static final java.lang.String UI_ID_VERTICAL_ITEM = "com_tencent_ysdk_icon_float_view_vertical_Item";
    private static final java.lang.String UI_ID_XIAOXI_ICON = "com_tencent_ysdk_icon_xiaoxi_icon";
    private static final java.lang.String UI_LAYOUT_VIEW = "com_tencent_ysdk_icon_float_menu_view";
    private static final java.lang.String UI_STRING_RELEASE_MEMORY_RESULT_TIPS = "floating_window_result_release_memory_tips";
    private static final float XDISMIN = 10.0f;
    private static final float XSPEED = 100.0f;
    private int currentIndex;
    public volatile boolean hasBenAdded;
    private boolean isMenuMoving;
    private android.content.Context mContext;
    private android.view.View mFloatWindow;
    private int mItemNum;
    private java.lang.String mLastShowIconName;
    private long mLastShowIconTime;
    private java.lang.String mLastShowIconUrl;
    private android.widget.TextView mMScreenCapture;
    private android.view.View mNotchMarginView;
    private float mSpeed;
    private boolean mStatNeedShowFirstItem;
    private android.view.VelocityTracker mVelocityTracker;
    private android.widget.LinearLayout mVerticalItemLayout;
    private android.widget.ImageView mXiaoxiIcon;
    private android.widget.TextView mXiaoxiNum;
    java.util.List<com.tencent.ysdk.shell.module.icon.impl.floatingviews.MenuItemView> menuItemViews;
    java.util.List<com.tencent.ysdk.shell.module.icon.impl.floatingviews.MenuItem> menuItems;
    private boolean needShowFirstItem;
    private int xInView;
    private int xMove;
    private int yInView;

    private class UserRelationListenerImpl implements com.tencent.ysdk.module.user.UserRelationListener {
        private UserRelationListenerImpl() {
        }

        @Override // com.tencent.ysdk.module.user.UserRelationListener
        public void OnRelationNotify(com.tencent.ysdk.module.user.UserRelationRet userRelationRet) {
            if (userRelationRet.ret != 0 || 1 != userRelationRet.info_type) {
                com.tencent.ysdk.shell.libware.file.Logger.e("query user info is bad");
                return;
            }
            try {
                com.tencent.ysdk.module.user.PersonInfo personInfo = (com.tencent.ysdk.module.user.PersonInfo) userRelationRet.persons.firstElement();
                com.tencent.ysdk.shell.framework.YSDKPlayer.getInstance().setPlayerInfo(personInfo.openId, personInfo.nickName, personInfo.pictureMiddle);
                com.tencent.ysdk.shell.framework.YSDKPlayer.getInstance().setHeadBitmapToImgView(com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenuView.this.mXiaoxiIcon);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    public FloatMenuView(android.content.Context context) {
        super(context);
        this.currentIndex = 0;
        this.needShowFirstItem = false;
        this.hasBenAdded = false;
        this.mLastShowIconName = "";
        this.mLastShowIconTime = 0L;
        this.mLastShowIconUrl = "";
        this.mStatNeedShowFirstItem = false;
        android.view.LayoutInflater.from(context).inflate(com.tencent.ysdk.shell.libware.ui.res.Res.layout(UI_LAYOUT_VIEW), this);
        setOrientation(0);
        this.mContext = context;
        this.mFloatWindow = findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_ID_FLOAT_WINDOW));
        this.mFloatWindow.setBackgroundColor(MENU_BACKGROUND);
        this.mXiaoxiIcon = (android.widget.ImageView) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_ID_XIAOXI_ICON));
        this.mMScreenCapture = (android.widget.TextView) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_ID_SCREEN_ICON));
        if (!com.tencent.ysdk.shell.framework.config.Config.isSwitchEnabled(com.tencent.ysdk.shell.framework.config.Config.YSDK_ICON_CAPTURE, false)) {
            this.mMScreenCapture.setVisibility(8);
        }
        this.mNotchMarginView = new android.view.View(context);
        this.mNotchMarginView.setBackgroundColor(MENU_BACKGROUND);
        this.mNotchMarginView.setLayoutParams(new android.widget.LinearLayout.LayoutParams(0, -1));
        this.mNotchMarginView.setVisibility(8);
        addView(this.mNotchMarginView, 0);
        initOnclick();
    }

    private void createVelocityTracker(android.view.MotionEvent motionEvent) {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = android.view.VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
    }

    private int getScreenHeight() {
        return getResources().getDisplayMetrics().heightPixels - getStatusBarHeight();
    }

    private int getScrollVelocity() {
        this.mVelocityTracker.computeCurrentVelocity(1000);
        return (int) this.mVelocityTracker.getXVelocity();
    }

    private int getStatusBarHeight() {
        int i = 0;
        try {
            android.content.res.Resources resources = getContext().getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
            try {
                i = (((android.app.Activity) this.mContext).getWindow().getAttributes().flags & 1024) != 1024 ? dimensionPixelSize : 0;
                com.tencent.ysdk.shell.libware.file.Logger.w("Browser", "status_bar_height:" + i);
            } catch (java.lang.Exception e) {
                e = e;
                i = dimensionPixelSize;
                com.tencent.ysdk.shell.libware.file.Logger.e("Browser", e.toString());
            }
        } catch (java.lang.Exception e2) {
            e = e2;
        }
        return i;
    }

    private void hideView(final boolean z) {
        boolean z2 = com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewStorageHelper.getLocationXFromStorage(com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord().open_id) < com.tencent.ysdk.shell.libware.ui.ViewUtils.getScreenWidth(this.mContext) / 2;
        for (int i = 0; i < this.mVerticalItemLayout.getChildCount(); i++) {
            this.mVerticalItemLayout.getChildAt(i).setClickable(false);
        }
        android.view.animation.TranslateAnimation translateAnimation = new android.view.animation.TranslateAnimation(1, 0.0f, 1, z2 ? -1.0f : 1.0f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(400L);
        translateAnimation.setRepeatCount(0);
        translateAnimation.setInterpolator(new android.view.animation.AccelerateDecelerateInterpolator());
        translateAnimation.setAnimationListener(new android.view.animation.Animation.AnimationListener() { // from class: com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenuView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(android.view.animation.Animation animation) {
                com.tencent.ysdk.shell.module.icon.impl.IconManager.getInstance().hideFloatWindow();
                com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenuView.this.isMenuMoving = false;
                if (z) {
                    com.tencent.ysdk.shell.module.icon.impl.IconManager.getInstance().showIconWindow(null);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(android.view.animation.Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(android.view.animation.Animation animation) {
                com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenuView.this.isMenuMoving = true;
            }
        });
        this.mFloatWindow.startAnimation(translateAnimation);
    }

    private void initOnclick() {
        this.mMScreenCapture.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenuView.1
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                com.tencent.ysdk.shell.module.share.ShareApiImpl.getInstance().captureScreen();
            }
        });
        this.mXiaoxiIcon.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenuView.2
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.reportIconEvent(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.EVENT_FLOAT_HEAD_ICON_ONCLICK, 0, "head icon click", (java.util.Map<java.lang.String, java.lang.String>) null, com.tencent.ysdk.shell.module.stat.StatConstants.EventType.Click, com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.PARAM_FLOAT_WINDOW_HEAD_TARGET);
            }
        });
    }

    private void recycleVelocityTracker() {
        this.mVelocityTracker.recycle();
        this.mVelocityTracker = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportFloatTabDuration() {
        if (android.text.TextUtils.isEmpty(this.mLastShowIconName)) {
            return;
        }
        java.util.HashMap map = new java.util.HashMap();
        map.put("iconName", this.mLastShowIconName);
        map.put(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.PARA_FLOAT_DURATION, java.lang.String.valueOf(java.lang.System.currentTimeMillis() - this.mLastShowIconTime));
        map.put(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.PARAM_FLOAT_FIRST_ICON, this.menuItems.get(0).getTitle());
        map.put(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.PARAM_NEED_SHOW_FIRST_ICON, java.lang.String.valueOf(this.mStatNeedShowFirstItem));
        map.put("loadH5", this.mLastShowIconUrl);
        com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.reportIconBasicEvent(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.EVENT_FLOAT_TAB_DURATION, 0, "tabShowDuration", map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setButtonState(com.tencent.ysdk.shell.module.icon.impl.floatingviews.MenuItemView menuItemView) {
        if (this.menuItems == null || this.menuItemViews == null) {
            return;
        }
        int config = com.tencent.ysdk.shell.framework.config.Config.readConfig(com.tencent.ysdk.shell.framework.config.Config.KEY_ICON_MAX_NUM, 10);
        if (this.menuItems.size() > config - 1) {
            this.mItemNum = config;
        } else {
            this.mItemNum = this.menuItems.size();
        }
        for (int i = 0; i < this.mItemNum; i++) {
            com.tencent.ysdk.shell.module.icon.impl.floatingviews.MenuItem menuItem = this.menuItems.get(i);
            com.tencent.ysdk.shell.module.icon.impl.floatingviews.MenuItemView menuItemView2 = this.menuItemViews.get(i);
            menuItem.setBitmapToImgView(menuItemView2.itemIcon, menuItemView == menuItemView2);
        }
    }

    private void updateUserIcon() {
        com.tencent.ysdk.module.user.UserLoginRet loginRecord = com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord();
        if (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(com.tencent.ysdk.shell.framework.YSDKPlayer.getInstance().getPictureUrl(loginRecord.open_id))) {
            com.tencent.ysdk.shell.module.user.UserApi.getInstance().queryUserInfo(com.tencent.ysdk.framework.common.ePlatform.getEnum(loginRecord.platform), new com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenuView.UserRelationListenerImpl());
        } else {
            com.tencent.ysdk.shell.framework.YSDKPlayer.getInstance().setHeadBitmapToImgView(this.mXiaoxiIcon);
        }
    }

    private void updateVercialItem() {
        this.mVerticalItemLayout = (android.widget.LinearLayout) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id(UI_ID_VERTICAL_ITEM));
        this.mVerticalItemLayout.removeAllViews();
        this.menuItems = com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenu.getMenuInstance().getMenuItems();
        this.menuItemViews = new java.util.ArrayList();
        if (this.menuItems != null) {
            int config = com.tencent.ysdk.shell.framework.config.Config.readConfig(com.tencent.ysdk.shell.framework.config.Config.KEY_ICON_MAX_NUM, 10);
            if (this.menuItems.size() > config - 1) {
                this.mItemNum = config;
            } else {
                this.mItemNum = this.menuItems.size();
            }
            this.needShowFirstItem = true;
            this.mStatNeedShowFirstItem = this.needShowFirstItem;
            for (final int i = 0; i < this.mItemNum; i++) {
                final com.tencent.ysdk.shell.module.icon.impl.floatingviews.MenuItem menuItem = this.menuItems.get(i);
                java.lang.String title = menuItem.getTitle();
                final com.tencent.ysdk.shell.module.icon.impl.floatingviews.MenuItemView menuItemView = new com.tencent.ysdk.shell.module.icon.impl.floatingviews.MenuItemView(this.mContext);
                this.menuItemViews.add(menuItemView);
                menuItemView.itemWord.setText(title);
                menuItem.setBitmapToImgView(menuItemView.itemIcon, false);
                if (menuItem.isNew()) {
                    menuItemView.setRed(true);
                } else {
                    menuItemView.setRed(false);
                }
                menuItemView.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenuView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(android.view.View view) {
                        if (!com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenuView.this.mLastShowIconName.equals(menuItem.getTitle())) {
                            com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenuView.this.reportFloatTabDuration();
                            com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenuView.this.mLastShowIconName = menuItem.getTitle();
                            com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenuView.this.mLastShowIconTime = java.lang.System.currentTimeMillis();
                        }
                        menuItem.setIsNew(false);
                        menuItemView.setRed(false);
                        com.tencent.ysdk.shell.module.icon.impl.IconRedPointManager.stateUpdate(menuItem.getIconID(), menuItem.getTs());
                        java.lang.String jumpUrl = menuItem.getJumpUrl();
                        if (!android.text.TextUtils.isEmpty(jumpUrl)) {
                            jumpUrl = jumpUrl.trim();
                        }
                        java.lang.String strMarge = com.tencent.ysdk.shell.libware.util.YSDKURLUtils.marge(jumpUrl, "uniq_id=" + menuItem.getUniqId());
                        com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenuView.this.mLastShowIconUrl = strMarge;
                        com.tencent.ysdk.shell.module.icon.impl.IconManager.getInstance().loadUrlInH5(strMarge);
                        com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenuView.this.currentIndex = i;
                        com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenuView.this.setButtonState(menuItemView);
                        com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.IconEventParams iconEventParams = new com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.IconEventParams();
                        iconEventParams.setEventName(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.EVENT_FLOAT_ITEM_ONCLICK);
                        iconEventParams.setFlag(0);
                        iconEventParams.setRetDetail("click");
                        java.util.HashMap map = new java.util.HashMap();
                        map.put("iconName", menuItem.getTitle());
                        map.put("loadH5", java.lang.String.valueOf(strMarge));
                        iconEventParams.setEventParams(map);
                        iconEventParams.setPageType(com.tencent.ysdk.shell.module.stat.StatConstants.PageType.FloatWindow);
                        iconEventParams.setPageId(java.lang.String.valueOf(i));
                        iconEventParams.setPvId(java.util.UUID.randomUUID().toString().replace("-", ""));
                        iconEventParams.setEventType(com.tencent.ysdk.shell.module.stat.StatConstants.EventType.Click);
                        iconEventParams.setEventTarget(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.PARAM_FLOAT_WINDOW_TAB_TARGET);
                        com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.reportIconPageEvent(iconEventParams);
                    }
                });
                this.mVerticalItemLayout.addView(menuItemView, i);
            }
        }
    }

    public void adjustNotchIfExist(android.view.WindowManager.LayoutParams layoutParams, android.graphics.Point point) {
        int orientation = com.tencent.ysdk.shell.libware.device.DeviceUtils.getOrientation(getContext());
        if (orientation == 2) {
            this.mNotchMarginView.setVisibility(0);
            android.view.ViewGroup.LayoutParams layoutParams2 = this.mNotchMarginView.getLayoutParams();
            layoutParams2.width = point.x;
            this.mNotchMarginView.setLayoutParams(layoutParams2);
            return;
        }
        if (orientation == 1) {
            this.mNotchMarginView.setVisibility(8);
            layoutParams.y = point.y;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(android.view.KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 1 || this.isMenuMoving) {
            return super.dispatchKeyEvent(keyEvent);
        }
        hideView(true);
        return true;
    }

    public int getCurrentIndex() {
        return this.currentIndex;
    }

    public int getRealHeight() {
        return com.tencent.ysdk.shell.libware.ui.ViewUtils.dip2px(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext(), 180.0f) + com.tencent.ysdk.shell.libware.ui.ViewUtils.dip2px(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext(), this.mItemNum * 60);
    }

    public int getScreenWidth() {
        return getResources().getDisplayMetrics().widthPixels;
    }

    public void onFloatMenuClose() {
        reportFloatTabDuration();
        this.mLastShowIconName = "";
        this.mLastShowIconTime = 0L;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
        android.graphics.Rect rect = new android.graphics.Rect();
        this.mVerticalItemLayout.getGlobalVisibleRect(rect);
        createVelocityTracker(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                this.xInView = (int) motionEvent.getX();
                this.yInView = (int) motionEvent.getY();
                break;
            case 1:
                if (!this.isMenuMoving && ((java.lang.Math.abs(this.xMove - this.xInView) > XDISMIN && this.mSpeed < -100.0f) || !rect.contains(this.xInView, this.yInView))) {
                    hideView(true);
                }
                recycleVelocityTracker();
                break;
            case 2:
                this.xMove = (int) motionEvent.getX();
                this.mSpeed = getScrollVelocity();
                break;
        }
        return false;
    }

    public void setCurrentIndex(int i) {
        this.currentIndex = i;
    }

    public void showView(boolean z) {
        android.view.animation.TranslateAnimation translateAnimation = new android.view.animation.TranslateAnimation(1, z ? -1.0f : 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(300L);
        translateAnimation.setRepeatCount(0);
        translateAnimation.setAnimationListener(new android.view.animation.Animation.AnimationListener() { // from class: com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenuView.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(android.view.animation.Animation animation) {
                if (com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenuView.this.mVerticalItemLayout.getChildCount() <= 0 || !com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenuView.this.needShowFirstItem) {
                    return;
                }
                com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenuView.this.mVerticalItemLayout.getChildAt(0).performClick();
                com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenuView.this.needShowFirstItem = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(android.view.animation.Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(android.view.animation.Animation animation) {
            }
        });
        this.mFloatWindow.startAnimation(translateAnimation);
    }

    public void updateViewContent() {
        updateUserIcon();
        updateVercialItem();
    }
}
