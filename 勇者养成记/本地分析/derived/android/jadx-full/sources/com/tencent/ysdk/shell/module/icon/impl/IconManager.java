package com.tencent.ysdk.shell.module.icon.impl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class IconManager {
    private static final int DEFAULT_FLOATING_BALL_LOCATION_Y = 92;
    private static final java.lang.String TAG = "YSDK MyWindowManager";
    private static final java.lang.String URL_PARA_GAME_SCREEN_DIR = "gameScreenDir";
    private static final java.lang.String URL_PARA_ICON_VERSION = "version";
    private static final java.lang.String URL_PARA_MYAPP_REPORT_ID = "scene";
    private static final java.lang.String URL_PARA_MYAPP_REPORT_ID_VALUE = "20180701";
    private static final java.lang.String URL_PARA_PKG_NAME = "pkgname";
    private static final java.lang.String URL_PARA_YSDK_VERSION = "YSDKVersion";
    private static volatile com.tencent.ysdk.shell.module.icon.impl.IconManager instance = null;
    private static long mFloatShowTime = -1;
    private static boolean sIsSupportNotch;
    private com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IHideIconViewAnimator hideIconViewAnimator;
    private android.view.View mEmptyCloseButton;
    private com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowser mH5SampleView;
    private com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconCloseView mIconCloseView;
    private com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface mIconView;
    private com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewTouchStrategy mIconViewTouchStrategy;
    private android.view.WindowManager.LayoutParams mIconWindowParams;
    private boolean mIsIconViewInit;
    private android.view.WindowManager mWindowManager;
    private android.graphics.Point mDownLocation = new android.graphics.Point();
    private int mBubbleSourceSize = com.tencent.ysdk.shell.libware.ui.ViewUtils.dip2px(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getPluginContext(), 44.0f);
    private com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewTouchStrategy.IconViewTouchCallback mIconViewTouchCallback = new com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewTouchStrategy.IconViewTouchCallback() { // from class: com.tencent.ysdk.shell.module.icon.impl.IconManager.1
        @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewTouchStrategy.IconViewTouchCallback
        public void onCancel() {
            com.tencent.ysdk.shell.module.icon.impl.IconManager.this.mIconView.clearViewAnimation();
            com.tencent.ysdk.shell.module.icon.impl.IconManager iconManager = com.tencent.ysdk.shell.module.icon.impl.IconManager.this;
            iconManager.changeVisibility(iconManager.mBackGround, false);
        }

        @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewTouchStrategy.IconViewTouchCallback
        public void onClick(android.view.View view) {
            com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.icon.impl.IconManager.TAG, "onClick");
            if (view.getAnimation() == null || !view.getAnimation().hasStarted()) {
                com.tencent.ysdk.shell.module.icon.impl.IconManager.this.hideIconViewAnimator.clearAnimator(com.tencent.ysdk.shell.module.icon.impl.IconManager.this.mIconView.getIconView());
                com.tencent.ysdk.shell.module.icon.impl.IconManager.this.handleIconViewSizeByMode();
                com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenu.getMenuInstance().setIconIsNew(false);
                android.view.animation.RotateAnimation rotateAnimation = new android.view.animation.RotateAnimation(359.0f, 0.0f, 1, 0.5f, 1, 0.5f);
                rotateAnimation.setRepeatCount(0);
                rotateAnimation.setDuration(300L);
                rotateAnimation.setFillAfter(true);
                rotateAnimation.setAnimationListener(new android.view.animation.Animation.AnimationListener() { // from class: com.tencent.ysdk.shell.module.icon.impl.IconManager.1.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(android.view.animation.Animation animation) {
                        com.tencent.ysdk.shell.module.icon.impl.IconManager.getInstance().hideIconWindow();
                        com.tencent.ysdk.shell.module.icon.impl.IconManager.getInstance().showFloatWindow();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(android.view.animation.Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(android.view.animation.Animation animation) {
                    }
                });
                view.setAnimation(rotateAnimation);
                view.startAnimation(rotateAnimation);
                if (com.tencent.ysdk.shell.module.icon.impl.IconManager.this.mIconView != null) {
                    com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.reportIconEvent(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.EVENT_ICON_CLICK, 0, "onClick", (java.util.Map<java.lang.String, java.lang.String>) null, com.tencent.ysdk.shell.module.stat.StatConstants.EventType.Click, "icon");
                }
            }
        }

        @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewTouchStrategy.IconViewTouchCallback
        public void onTouchDown() {
            if (com.tencent.ysdk.shell.module.icon.impl.IconManager.this.mIconView != null) {
                android.view.WindowManager.LayoutParams iconViewLayoutParams = com.tencent.ysdk.shell.module.icon.impl.IconManager.this.getIconViewLayoutParams();
                com.tencent.ysdk.shell.module.icon.impl.IconManager.this.mDownLocation.x = iconViewLayoutParams.x;
                com.tencent.ysdk.shell.module.icon.impl.IconManager.this.mDownLocation.y = iconViewLayoutParams.y;
            }
        }

        @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewTouchStrategy.IconViewTouchCallback
        public void onTouchMove(int i, int i2) {
            com.tencent.ysdk.shell.module.icon.impl.IconManager.this.updateIconViewLocation(i, i2);
            com.tencent.ysdk.shell.module.icon.impl.IconManager.this.updateFloatMenuBg(i, i2);
        }

        @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewTouchStrategy.IconViewTouchCallback
        public void onTouchUp(int i, int i2, int i3) {
            if (com.tencent.ysdk.shell.module.icon.impl.IconManager.this.mIconView == null) {
                return;
            }
            com.tencent.ysdk.shell.module.icon.impl.IconManager.this.mIconView.clearViewAnimation();
            if (com.tencent.ysdk.shell.module.icon.impl.IconManager.this.mBackGround.isInRange(i, i2)) {
                com.tencent.ysdk.shell.module.icon.impl.IconManager.this.hideIconWindow();
                com.tencent.ysdk.shell.module.icon.impl.IconManager.this.mIconCloseView.showNoMoreTipsWindow();
            } else {
                com.tencent.ysdk.shell.module.icon.impl.IconManager.this.moveToEdge(i3);
            }
            com.tencent.ysdk.shell.module.icon.impl.IconManager.this.reportIconMoveEvent();
            com.tencent.ysdk.shell.module.icon.impl.IconManager iconManager = com.tencent.ysdk.shell.module.icon.impl.IconManager.this;
            iconManager.changeVisibility(iconManager.mBackGround, false);
        }
    };
    private com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconCloseView.OnIconCloseTipClickCallback mIconCloseTipClickCallback = new com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconCloseView.OnIconCloseTipClickCallback() { // from class: com.tencent.ysdk.shell.module.icon.impl.IconManager.2
        @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconCloseView.OnIconCloseTipClickCallback
        public void onCloseClick() {
            com.tencent.ysdk.shell.module.icon.impl.IconManager.this.hideIconWindow();
        }

        @Override // com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconCloseView.OnIconCloseTipClickCallback
        public void onNoCloseClick() {
            com.tencent.ysdk.shell.module.icon.impl.IconManager.this.mIconView.clearIconLayoutAnimation();
            com.tencent.ysdk.shell.module.icon.impl.IconManager.this.mIconView.clearViewAnimation();
            com.tencent.ysdk.shell.module.icon.impl.IconManager.this.mIconView.getIconView().setVisibility(0);
            com.tencent.ysdk.shell.module.icon.impl.IconManager.this.mIconViewTouchStrategy.correctLocation(com.tencent.ysdk.shell.module.icon.impl.IconManager.this.mIconView.getIconView(), com.tencent.ysdk.shell.module.icon.impl.IconManager.this.mDownLocation);
            com.tencent.ysdk.shell.module.icon.impl.IconManager iconManager = com.tencent.ysdk.shell.module.icon.impl.IconManager.this;
            iconManager.updateIconViewLocation(iconManager.mDownLocation.x, com.tencent.ysdk.shell.module.icon.impl.IconManager.this.mDownLocation.y, true, false);
        }
    };
    private com.tencent.ysdk.shell.libware.thread.YSDKThreadManager mThreadManager = com.tencent.ysdk.shell.libware.thread.YSDKThreadManager.getInstance();
    private com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenuView mFloatMenuView = new com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenuView(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getPluginContext());
    private com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenuBG mBackGround = new com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenuBG(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getPluginContext());

    private IconManager() {
    }

    private int getEdgeByOrientation(int i, int i2, int i3, int i4, int i5) {
        int i6;
        if (i == 1) {
            int i7 = i4 / 2;
            if (i3 < i7) {
                return 2;
            }
            if (i3 > i5 - i7) {
                return 3;
            }
            return i2 > i7 ? 1 : 0;
        }
        if (i != 2 || i2 < (i6 = i5 / 2)) {
            return 0;
        }
        if (i2 > i4 - i6) {
            return 1;
        }
        return i3 < i6 ? 2 : 3;
    }

    private int getIconViewEdgeByLocation(int i, int i2) {
        int screenWidth = com.tencent.ysdk.shell.libware.ui.ViewUtils.getScreenWidth(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity());
        int screenHeight = com.tencent.ysdk.shell.libware.ui.ViewUtils.getScreenHeight(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity());
        android.graphics.Rect screenRect = this.mIconViewTouchStrategy.getScreenRect();
        int orientation = com.tencent.ysdk.shell.libware.device.DeviceUtils.getOrientation(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity());
        if (screenRect != null) {
            if (i <= screenRect.left + this.mIconView.getIconView().getWidth()) {
                return 0;
            }
            if (i == screenRect.right - this.mIconView.getIconView().getWidth()) {
                return 1;
            }
            if (i2 <= screenRect.top) {
                return 2;
            }
            if (i2 == screenRect.bottom - this.mIconView.getIconView().getHeight()) {
                return 3;
            }
            return getEdgeByOrientation(orientation, i, i2, screenWidth, screenHeight);
        }
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "screenRect is null");
        if (i == 0) {
            return 0;
        }
        if (i == screenWidth - this.mIconView.getIconView().getWidth()) {
            return 1;
        }
        if (i2 <= 0) {
            return 2;
        }
        if (i2 == screenHeight - this.mIconView.getIconView().getHeight()) {
            return 3;
        }
        return getEdgeByOrientation(orientation, i, i2, screenWidth, screenHeight);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.view.WindowManager.LayoutParams getIconViewLayoutParams() {
        android.view.WindowManager.LayoutParams layoutParams = this.mIconWindowParams;
        if (layoutParams != null) {
            return layoutParams;
        }
        this.mIconWindowParams = getBasicWindowManagerLayoutParams();
        this.mIconWindowParams.width = this.mIconView.getLayoutViewWidth();
        this.mIconWindowParams.height = this.mIconView.getLayoutViewHeight();
        int locationXFromStorage = com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewStorageHelper.getLocationXFromStorage(com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord().open_id);
        int locationYFromStorage = com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewStorageHelper.getLocationYFromStorage(com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord().open_id);
        if (locationYFromStorage <= 0) {
            locationYFromStorage = com.tencent.ysdk.shell.libware.ui.ViewUtils.dip2px(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getPluginContext(), 92.0f);
        }
        android.graphics.Point point = new android.graphics.Point(locationXFromStorage, locationYFromStorage);
        this.mIconWindowParams.x = point.x;
        this.mIconWindowParams.y = point.y;
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "init x : " + point.x + " , y : " + point.y + " , locationXFromStorage : " + locationXFromStorage + " , locationYFromStorage : " + locationYFromStorage);
        android.view.WindowManager.LayoutParams layoutParams2 = this.mIconWindowParams;
        layoutParams2.flags = 40;
        return layoutParams2;
    }

    public static com.tencent.ysdk.shell.module.icon.impl.IconManager getInstance() {
        if (instance == null) {
            synchronized (com.tencent.ysdk.shell.module.icon.impl.IconManager.class) {
                if (instance == null) {
                    instance = new com.tencent.ysdk.shell.module.icon.impl.IconManager();
                }
            }
        }
        return instance;
    }

    private java.util.Map<java.lang.String, java.lang.String> getMoveEventMap() {
        java.util.HashMap map = new java.util.HashMap();
        map.put(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.PARAM_ICON_MOVE_PRE_POSITION, "{" + this.mDownLocation.x + "," + this.mDownLocation.y + "}");
        android.view.WindowManager.LayoutParams iconViewLayoutParams = getIconViewLayoutParams();
        map.put(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.PARAM_ICON_MOVE_AFT_POSITION, "{" + iconViewLayoutParams.x + "," + iconViewLayoutParams.y + "}");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleIconViewSizeByMode() {
        if (this.mIconView.getCurrentIconViewMode() == 0) {
            return false;
        }
        android.view.WindowManager.LayoutParams iconViewLayoutParams = getIconViewLayoutParams();
        iconViewLayoutParams.width = this.mIconView.getLayoutViewWidth();
        iconViewLayoutParams.height = this.mIconView.getLayoutViewHeight();
        android.view.ViewGroup.LayoutParams layoutParams = this.mIconView.getIconView().getLayoutParams();
        layoutParams.width = this.mIconView.getLayoutViewWidth();
        layoutParams.height = this.mIconView.getLayoutViewHeight();
        this.mIconView.getIconView().setLayoutParams(layoutParams);
        getWindowManager().updateViewLayout(this.mIconView.getIconView(), iconViewLayoutParams);
        return true;
    }

    private void iconViewLocationInitCorrect(android.graphics.Point point) {
        int screenWindowWidth = com.tencent.ysdk.shell.libware.ui.ViewUtils.getScreenWindowWidth(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity());
        int screenWindowHeight = com.tencent.ysdk.shell.libware.ui.ViewUtils.getScreenWindowHeight(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity());
        if (point.x < 0) {
            point.x = 0;
        }
        if (point.y < 0) {
            point.y = 0;
        }
        if (point.x > screenWindowWidth - this.mIconView.getLayoutViewWidth()) {
            point.x = screenWindowWidth - this.mIconView.getLayoutViewWidth();
        }
        if (point.y > screenWindowHeight - this.mIconView.getLayoutViewHeight()) {
            point.y = screenWindowHeight - this.mIconView.getLayoutViewHeight();
        }
    }

    private void initH5Para() {
        initIconView();
        initIconView();
        int width = this.mFloatMenuView.getWidth();
        int i = 0;
        if (com.tencent.ysdk.shell.libware.device.DeviceUtils.getOrientation(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity()) == 1) {
            android.graphics.Point point = new android.graphics.Point(0, 0);
            this.mIconViewTouchStrategy.forceCorrectLocation(this.mIconView.getIconView(), point);
            i = point.y;
        }
        this.mH5SampleView = com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowserManager.getInstance(1, com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity(), 100.0f - (((width * 2) * 100.0f) / com.tencent.ysdk.shell.libware.ui.ViewUtils.getScreenWindowWidth(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity())), 100.0f - ((i * 100.0f) / com.tencent.ysdk.shell.libware.ui.ViewUtils.getScreenWindowHeight(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity())));
        this.mH5SampleView.setScene(com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowser.BrowserScene.FLOAT_MENU);
        this.mH5SampleView.regOnBrowserStateChangeListener(new com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowser.OnBrowserStateChangeListener() { // from class: com.tencent.ysdk.shell.module.icon.impl.IconManager.5
            @Override // com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowser.OnBrowserStateChangeListener
            public void onClose() {
                com.tencent.ysdk.shell.module.icon.impl.IconManager.this.removeH5();
                com.tencent.ysdk.shell.module.icon.impl.IconManager.this.hideFloatWindow();
                com.tencent.ysdk.shell.module.icon.impl.IconManager.this.showIconWindow(null);
            }

            @Override // com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowser.OnBrowserStateChangeListener
            public void onPageFinish() {
            }

            @Override // com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowser.OnBrowserStateChangeListener
            public void onPageStart() {
            }
        });
    }

    private void initIconView() {
        if (this.mIsIconViewInit) {
            return;
        }
        this.mIconViewTouchStrategy = com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewTouchStrategyFactory.getCommonTouchStrategy(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance(), this.mIconViewTouchCallback);
        this.mIconViewTouchStrategy.setAppNotchSupport(sIsSupportNotch);
        this.mIconCloseView = new com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconCloseView(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getPluginContext(), this.mIconCloseTipClickCallback);
        if (com.tencent.ysdk.shell.framework.config.Config.readConfig(com.tencent.ysdk.shell.framework.config.Config.YSDK_ICON_BUBBLE, "false").equals(com.tencent.ysdk.shell.framework.config.Config.VALUE_SWITCH_ON)) {
            this.mIconView = new com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewBubbleWrapper(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getPluginContext(), new com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconView(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getPluginContext(), this.mIconViewTouchStrategy));
        } else {
            this.mIconView = new com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconView(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getPluginContext(), this.mIconViewTouchStrategy);
        }
        if (this.mIconView instanceof com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewBubbleWrapper) {
            ((com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewBubbleWrapper) this.mIconView).setShowIconBubbleAnimator(new com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.ShowHideIconBubbleAnimatorImpl(getIconViewLayoutParams()));
        }
        this.hideIconViewAnimator = new com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.HideIconViewAnimatorImpl(getIconViewLayoutParams());
        this.mIconView.setHideIconViewAnimator(this.hideIconViewAnimator);
        this.mIsIconViewInit = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveToEdge(int i) {
        boolean z;
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "edge " + i);
        com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface iconViewInterface = this.mIconView;
        if (iconViewInterface != null) {
            iconViewInterface.getIconView().setAlpha(1.0f);
            int screenWindowWidth = com.tencent.ysdk.shell.libware.ui.ViewUtils.getScreenWindowWidth(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity());
            int navigationBarHeight = com.tencent.ysdk.shell.libware.ui.ViewUtils.getNavigationBarHeight(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity());
            int width = this.mIconWindowParams.x;
            int i2 = this.mIconWindowParams.y;
            boolean z2 = true;
            switch (i) {
                case 1:
                    z = width < screenWindowWidth + (-90);
                    width = (screenWindowWidth - this.mIconView.getIconView().getWidth()) - navigationBarHeight;
                    break;
                case 2:
                    z = i2 > 90;
                    i2 = 0;
                    break;
                case 3:
                    width = width - (this.mIconView.getIconView().getWidth() / 2) > screenWindowWidth / 2 ? (screenWindowWidth - this.mIconView.getIconView().getWidth()) - navigationBarHeight : 0;
                    z = true;
                    break;
                default:
                    z = width > 90;
                    width = 0;
                    break;
            }
            android.graphics.Point point = new android.graphics.Point(width, i2);
            this.mIconViewTouchStrategy.correctLocation(this.mIconView.getIconView(), point);
            int i3 = point.x;
            int i4 = point.y;
            if (this.mIconView.getIconView().getVisibility() != 0) {
                this.mIconView.getIconView().setVisibility(0);
            }
            updateIconViewLocation(i3, i4, true, true);
            this.mIconView.updateViewContent(com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenu.getMenuInstance().getIconIsNew());
            if (!handleIconViewSizeByMode() && !z) {
                z2 = false;
            }
            com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface iconViewInterface2 = this.mIconView;
            iconViewInterface2.startHideIcon(z2, iconViewInterface2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportIconMoveEvent() {
        com.tencent.ysdk.shell.module.stat.StatHelper.reportApiEventWithDeviceInfo(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.EVENT_ICON_MOVE, 0, "icon move", getMoveEventMap(), java.lang.System.currentTimeMillis(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFloatMenuBg(int i, int i2) {
        com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenuBG floatMenuBG = this.mBackGround;
        if (floatMenuBG == null) {
            return;
        }
        changeVisibility(floatMenuBG, true);
        com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenuBG floatMenuBG2 = this.mBackGround;
        floatMenuBG2.changeFocus(floatMenuBG2.isInRange(i, i2));
        changeVisibility(this.mEmptyCloseButton, true);
    }

    private void updateIconImage(final java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "Icon URL is Empty can`t update");
            return;
        }
        initIconView();
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.mThreadManager.start(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.module.icon.impl.IconManager.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    android.graphics.Bitmap bitmapDecodeStream = android.graphics.BitmapFactory.decodeStream(new java.net.URL(str).openStream());
                    if (bitmapDecodeStream == null || com.tencent.ysdk.shell.module.icon.impl.IconManager.this.mIconView == null) {
                        return;
                    }
                    com.tencent.ysdk.shell.module.icon.impl.IconManager.this.mIconView.updateIconImage(bitmapDecodeStream);
                } catch (java.lang.Exception e) {
                    com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.module.icon.impl.IconManager.TAG, e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateIconViewLocation(int i, int i2) {
        updateIconViewLocation(i, i2, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateIconViewLocation(int i, int i2, boolean z, boolean z2) {
        com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface iconViewInterface = this.mIconView;
        if (iconViewInterface == null || iconViewInterface.getIconView().getVisibility() != 0) {
            return;
        }
        android.view.WindowManager.LayoutParams iconViewLayoutParams = getIconViewLayoutParams();
        iconViewLayoutParams.x = i;
        iconViewLayoutParams.y = i2;
        if (z2) {
            iconViewLayoutParams.flags = 552;
        } else {
            iconViewLayoutParams.flags = 40;
        }
        int iconViewEdgeByLocation = getIconViewEdgeByLocation(iconViewLayoutParams.x, iconViewLayoutParams.y);
        getWindowManager().updateViewLayout(this.mIconView.getIconView(), iconViewLayoutParams);
        this.mIconView.setEdge(iconViewEdgeByLocation);
        if (z) {
            com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewStorageHelper.updateIconViewLocation(com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord().open_id, iconViewLayoutParams.x, iconViewLayoutParams.y);
        }
    }

    public void changeVisibility(android.view.View view, boolean z) {
        if (view == null) {
            return;
        }
        try {
            if (z) {
                if (view.getParent() == null) {
                    getWindowManager().addView(view, view.getLayoutParams());
                }
            } else if (view.getParent() != null) {
                getWindowManager().removeView(view);
            }
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, e);
        }
    }

    public void closeAllView() {
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "closeAllView");
        if (this.mH5SampleView != null) {
            removeH5();
            this.mH5SampleView = null;
        }
        com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface iconViewInterface = this.mIconView;
        if (iconViewInterface != null) {
            iconViewInterface.getIconView().setVisibility(8);
            this.mIconView.clearViewAnimation();
            try {
                getWindowManager().removeView(this.mIconView.getIconView());
            } catch (java.lang.Exception unused) {
            }
            this.mIconView = null;
            this.mIsIconViewInit = false;
        }
        com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenuView floatMenuView = this.mFloatMenuView;
        if (floatMenuView != null) {
            floatMenuView.setVisibility(8);
            try {
                getWindowManager().removeView(this.mFloatMenuView);
            } catch (java.lang.Exception unused2) {
            }
            this.mFloatMenuView = null;
        }
        com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenuBG floatMenuBG = this.mBackGround;
        if (floatMenuBG != null) {
            floatMenuBG.setVisibility(8);
            try {
                getWindowManager().removeView(this.mBackGround);
            } catch (java.lang.Exception unused3) {
            }
            this.mBackGround = null;
        }
        android.view.View view = this.mEmptyCloseButton;
        if (view != null) {
            view.setVisibility(8);
            try {
                getWindowManager().removeView(this.mEmptyCloseButton);
            } catch (java.lang.Exception unused4) {
            }
            this.mBackGround = null;
        }
        instance = null;
    }

    public android.view.WindowManager.LayoutParams getBasicWindowManagerLayoutParams() {
        android.view.WindowManager.LayoutParams layoutParams = new android.view.WindowManager.LayoutParams(1000);
        if (android.os.Build.VERSION.SDK_INT > 28) {
            layoutParams.layoutInDisplayCutoutMode = 1;
        }
        layoutParams.format = -3;
        layoutParams.gravity = 51;
        return layoutParams;
    }

    public android.view.WindowManager getWindowManager() {
        if (this.mWindowManager == null) {
            this.mWindowManager = (android.view.WindowManager) com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity().getSystemService("window");
        }
        return this.mWindowManager;
    }

    public void hideFloatWindow() {
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "hideFloatWindow");
        com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenuView floatMenuView = this.mFloatMenuView;
        if (floatMenuView != null) {
            changeVisibility(floatMenuView, false);
        }
        android.view.View view = this.mEmptyCloseButton;
        if (view != null) {
            view.setVisibility(8);
            changeVisibility(this.mEmptyCloseButton, false);
        }
    }

    public void hideIconWindow() {
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "hideIconWindow");
        com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewInterface iconViewInterface = this.mIconView;
        if (iconViewInterface != null) {
            iconViewInterface.getIconView().setVisibility(8);
        }
    }

    public com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowser loadUrlInH5(java.lang.String str) {
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "loadUrlInH5Async");
        if (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(str)) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "jumpUrl is null");
            return null;
        }
        initH5Para();
        this.mH5SampleView.loadURL(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.marge(str, "version=" + com.tencent.ysdk.shell.module.icon.IconApiImpl.getInstance().getIconVersion() + "&" + URL_PARA_PKG_NAME + "=" + com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getPluginContext().getPackageName() + "&" + URL_PARA_GAME_SCREEN_DIR + "=" + com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getGameScreenDir().val() + "&scene=" + URL_PARA_MYAPP_REPORT_ID_VALUE + "&" + URL_PARA_YSDK_VERSION + "=" + com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getVersion()));
        this.mH5SampleView.setVisibility(0);
        return this.mH5SampleView;
    }

    public void onPause() {
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "onPause");
    }

    public void onResume() {
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "onResume");
    }

    public void removeH5() {
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "removeH5Async");
        com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowser ySDKWebBrowser = this.mH5SampleView;
        if (ySDKWebBrowser != null) {
            ySDKWebBrowser.regOnBrowserStateChangeListener(null);
            this.mH5SampleView = null;
        }
    }

    public void resetAndShowIconWindow() {
        android.view.WindowManager.LayoutParams layoutParams = this.mIconWindowParams;
        int i = this.mBubbleSourceSize;
        layoutParams.width = i;
        layoutParams.height = i;
        layoutParams.x = this.mDownLocation.x;
        this.mIconWindowParams.y = this.mDownLocation.y;
        showIconWindow(null);
    }

    public void setNotchSupport(boolean z) {
        sIsSupportNotch = z;
        com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewTouchStrategy iconViewTouchStrategy = this.mIconViewTouchStrategy;
        if (iconViewTouchStrategy != null) {
            iconViewTouchStrategy.setAppNotchSupport(z);
        }
    }

    public void showErrorPage(boolean z) {
        initH5Para();
        this.mH5SampleView.showErrorPage(z);
        this.mH5SampleView.setVisibility(0);
    }

    public void showFloatWindow() {
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "showFloatWindow");
        if (!com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenu.getMenuInstance().isIconCanBeShowed()) {
            com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "float menu can't be showed by config ");
            return;
        }
        if (!com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenu.getMenuInstance().isSandboxIconCanBeShowed()) {
            com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "float menu can't be showed by sandbox config ");
            return;
        }
        initIconView();
        this.mFloatMenuView.updateViewContent();
        android.view.WindowManager.LayoutParams basicWindowManagerLayoutParams = getBasicWindowManagerLayoutParams();
        basicWindowManagerLayoutParams.width = -2;
        basicWindowManagerLayoutParams.flags = 552;
        android.graphics.Point point = new android.graphics.Point(0, 0);
        this.mIconViewTouchStrategy.forceCorrectLocation(this.mFloatMenuView, point);
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, point.toString());
        this.mFloatMenuView.adjustNotchIfExist(basicWindowManagerLayoutParams, point);
        basicWindowManagerLayoutParams.gravity = 8388627;
        this.mFloatMenuView.setLayoutParams(basicWindowManagerLayoutParams);
        this.mFloatMenuView.showView(true);
        mFloatShowTime = java.lang.System.currentTimeMillis();
        if (this.mEmptyCloseButton == null) {
            this.mEmptyCloseButton = new android.view.View(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getPluginContext());
            this.mEmptyCloseButton.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.tencent.ysdk.shell.module.icon.impl.IconManager.4
                @Override // android.view.View.OnClickListener
                public void onClick(android.view.View view) {
                    com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.icon.impl.IconManager.TAG, "empty close button click");
                    if (com.tencent.ysdk.shell.module.icon.impl.IconManager.this.mH5SampleView == null) {
                        com.tencent.ysdk.shell.module.icon.impl.IconManager.this.hideFloatWindow();
                        com.tencent.ysdk.shell.module.icon.impl.IconManager.this.showIconWindow(null);
                        return;
                    }
                    com.tencent.ysdk.shell.module.icon.impl.IconManager.this.mH5SampleView.closeFromOuter();
                    com.tencent.ysdk.shell.module.icon.impl.IconManager.this.mFloatMenuView.onFloatMenuClose();
                    java.util.HashMap map = new java.util.HashMap();
                    if (com.tencent.ysdk.shell.module.icon.impl.IconManager.mFloatShowTime > 0) {
                        map.put(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.PARA_FLOAT_DURATION, java.lang.String.valueOf(java.lang.System.currentTimeMillis() - com.tencent.ysdk.shell.module.icon.impl.IconManager.mFloatShowTime));
                        long unused = com.tencent.ysdk.shell.module.icon.impl.IconManager.mFloatShowTime = -1L;
                    }
                    com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.reportIconEvent(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.EVENT_FLOAT_WINDOW_DURATION, 0, "floatWindowDuration", map, com.tencent.ysdk.shell.module.stat.StatConstants.EventType.Click, com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.PARAM_FLOAT_WINDOW_TARGET);
                }
            });
        }
        this.mEmptyCloseButton.setVisibility(0);
        android.view.WindowManager.LayoutParams basicWindowManagerLayoutParams2 = getBasicWindowManagerLayoutParams();
        basicWindowManagerLayoutParams2.width = -1;
        basicWindowManagerLayoutParams2.height = -1;
        this.mEmptyCloseButton.setLayoutParams(basicWindowManagerLayoutParams2);
        this.mFloatMenuView.hasBenAdded = true;
        changeVisibility(this.mEmptyCloseButton, true);
        changeVisibility(this.mFloatMenuView, true);
        java.lang.String strReplace = java.util.UUID.randomUUID().toString().replace("-", "");
        com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.IconEventParams iconEventParams = new com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.IconEventParams();
        iconEventParams.setEventName(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.EVENT_FLOAT_SHOW);
        iconEventParams.setFlag(0);
        iconEventParams.setRetDetail("showFloatWindow");
        iconEventParams.setPageType(com.tencent.ysdk.shell.module.stat.StatConstants.PageType.FloatWindow);
        iconEventParams.setPageId("1");
        iconEventParams.setPvId(strReplace);
        iconEventParams.setEventType(com.tencent.ysdk.shell.module.stat.StatConstants.EventType.Show);
        iconEventParams.setEventTarget(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.PARAM_FLOAT_WINDOW_TARGET);
        com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.reportIconPageEvent(iconEventParams);
    }

    public void showIconBubble(com.tencent.ysdk.module.msgbox.MsgItem msgItem) {
        if (this.mIconView instanceof com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewBubbleWrapper) {
            this.mDownLocation.x = this.mIconWindowParams.x;
            this.mDownLocation.y = this.mIconWindowParams.y;
            ((com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewBubbleWrapper) this.mIconView).showBubble(msgItem);
        }
    }

    public synchronized void showIconWindow(java.lang.String str) {
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "showIconWindow");
        initIconView();
        if (!com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenu.getMenuInstance().isIconCanBeShowed()) {
            com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "icon can't be showed by config ");
            return;
        }
        if (!com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenu.getMenuInstance().isSandboxIconCanBeShowed()) {
            com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "icon can't be showed by sandbox config ");
            return;
        }
        android.view.WindowManager.LayoutParams basicWindowManagerLayoutParams = getBasicWindowManagerLayoutParams();
        basicWindowManagerLayoutParams.width = -1;
        basicWindowManagerLayoutParams.height = -1;
        this.mBackGround.setLayoutParams(basicWindowManagerLayoutParams);
        this.mBackGround.isAdded = true;
        android.view.WindowManager.LayoutParams iconViewLayoutParams = getIconViewLayoutParams();
        android.graphics.Point point = new android.graphics.Point(iconViewLayoutParams.x, iconViewLayoutParams.y);
        iconViewLocationInitCorrect(point);
        iconViewLayoutParams.x = point.x;
        iconViewLayoutParams.y = point.y;
        this.mIconView.getIconView().setLayoutParams(iconViewLayoutParams);
        int iconViewEdgeByLocation = getIconViewEdgeByLocation(iconViewLayoutParams.x, iconViewLayoutParams.y);
        if (this.mIconView.getIconView().getParent() != null) {
            getWindowManager().updateViewLayout(this.mIconView.getIconView(), iconViewLayoutParams);
        } else {
            getWindowManager().addView(this.mIconView.getIconView(), iconViewLayoutParams);
        }
        this.mIconView.setEdge(iconViewEdgeByLocation);
        updateIconImage(str);
        this.mIconView.updateViewContent(com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenu.getMenuInstance().getIconIsNew());
        this.mIconView.getIconView().setVisibility(0);
        this.mIconView.startShadowIcon();
        this.mIconView.startHideIcon(true, this.mIconView);
        com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.reportIconEvent(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.EVENT_ICON_SHOW, 0, "showIconWindow", (java.util.Map<java.lang.String, java.lang.String>) null, com.tencent.ysdk.shell.module.stat.StatConstants.EventType.Show, "icon");
    }

    public void updateIconViewRedPoint() {
        initIconView();
        if (this.mIconView == null) {
            android.util.Log.d(com.tencent.ysdk.shell.module.icon.impl.IconRedPointManager.TAG, "Icon notifyStateChange has no Icon to be show");
            return;
        }
        android.util.Log.d(com.tencent.ysdk.shell.module.icon.impl.IconRedPointManager.TAG, "Icon notifyStateChange updateViewRed point");
        this.mIconView.updateViewContent(com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenu.getMenuInstance().getIconIsNew());
    }
}
