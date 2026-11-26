package com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class FullScreenPicView extends android.widget.LinearLayout implements com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic.FullScreenPicContract.View {
    private android.app.Activity mActivity;
    private android.widget.LinearLayout mContainer;
    private com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic.FullScreenPicContract.Presenter mPresenter;
    private androidx.viewpager.widget.ViewPager mViewPager;
    private android.view.ViewGroup mWindowManager;

    public FullScreenPicView(android.app.Activity activity) {
        super(activity);
        this.mActivity = activity;
        initView();
        initEvents();
    }

    private int getScreenHeight() {
        return getResources().getDisplayMetrics().heightPixels;
    }

    private int getScreenWidth() {
        return getResources().getDisplayMetrics().widthPixels;
    }

    private int getStatusBarHeight() {
        int i = 0;
        try {
            android.content.res.Resources resources = getContext().getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
            try {
                i = (this.mActivity.getWindow().getAttributes().flags & 1024) != 1024 ? dimensionPixelSize : 0;
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

    private android.view.ViewGroup getWindowManager() {
        if (this.mWindowManager == null) {
            this.mWindowManager = (android.view.ViewGroup) this.mActivity.getWindow().getDecorView().getRootView();
        }
        return this.mWindowManager;
    }

    private void initEvents() {
        buildWindow();
        requestFocus();
    }

    private void initView() {
        android.view.LayoutInflater.from(getContext()).inflate(com.tencent.ysdk.shell.libware.ui.res.Res.layout("con_tencent_ysdk_fullscreenpic_view"), this);
        this.mViewPager = findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id("fullscreenpic_viewpager"));
        this.mContainer = (android.widget.LinearLayout) findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id("fullscreenpic_container"));
    }

    public void buildWindow() {
        this.mWindowManager = getWindowManager();
        this.mWindowManager.addView(this);
        android.widget.LinearLayout.LayoutParams layoutParams = (android.widget.LinearLayout.LayoutParams) this.mContainer.getLayoutParams();
        layoutParams.width = getScreenWidth();
        layoutParams.height = getScreenHeight() - getStatusBarHeight();
        layoutParams.topMargin = getStatusBarHeight();
        layoutParams.gravity = 48;
        this.mContainer.setLayoutParams(layoutParams);
        setVisibility(0);
    }

    @Override // com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic.FullScreenPicContract.View
    public void close() {
        setVisibility(8);
        this.mWindowManager.removeView(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(android.view.KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        close();
        return true;
    }

    @Override // com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic.FullScreenPicContract.View
    public void setAdapter(com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic.FullScreenPicPresenter.FullPicAdapter fullPicAdapter) {
        this.mViewPager.setAdapter(fullPicAdapter);
        this.mViewPager.setOnPageChangeListener(fullPicAdapter);
    }

    @Override // com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic.FullScreenPicContract.View
    public void setCurrentView(int i) {
        this.mViewPager.setCurrentItem(i);
    }

    @Override // com.tencent.ysdk.shell.framework.mvp.BaseView
    public void setPresenter(com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic.FullScreenPicContract.Presenter presenter) {
        this.mPresenter = presenter;
        presenter.start();
    }

    @Override // com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic.FullScreenPicContract.View
    public void showPic(java.util.ArrayList<java.lang.String> arrayList, int i) {
        if (arrayList == null || arrayList.size() == 0 || arrayList.size() <= i) {
            com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic.FullScreenPic.TAG, "PicUrls size error");
        } else {
            this.mPresenter.showPic(this, arrayList, i);
            this.mViewPager.setOffscreenPageLimit(arrayList.size());
        }
    }
}
