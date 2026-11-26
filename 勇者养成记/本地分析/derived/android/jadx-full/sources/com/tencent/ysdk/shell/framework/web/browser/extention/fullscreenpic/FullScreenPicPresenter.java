package com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class FullScreenPicPresenter implements com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic.FullScreenPicContract.Presenter {
    private int currentPos;
    private java.util.ArrayList<android.widget.RelativeLayout> imageViews;
    private com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic.FullScreenPicPresenter.FullPicAdapter mAdapter;
    private com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic.FullScreenPicContract.View mView;
    private int startPos;
    private java.util.ArrayList<java.lang.String> urls;

    public class FullPicAdapter extends androidx.viewpager.widget.PagerAdapter implements androidx.viewpager.widget.ViewPager.OnPageChangeListener {
        public FullPicAdapter() {
        }

        public void destroyItem(android.view.View view, int i, java.lang.Object obj) {
            ((android.view.ViewGroup) view).removeView((android.view.View) com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic.FullScreenPicPresenter.this.imageViews.get(i));
        }

        public void finishUpdate(android.view.View view) {
        }

        public int getCount() {
            return com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic.FullScreenPicPresenter.this.urls.size();
        }

        public java.lang.Object instantiateItem(android.view.View view, final int i) {
            android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic.FullScreenPicPresenter.this.imageViews.get(i);
            ((android.view.ViewGroup) view).addView(relativeLayout);
            final android.widget.ImageView imageView = (android.widget.ImageView) relativeLayout.findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id("com_tencent_ysdk_fullscreenpic_imageView"));
            final android.widget.ImageView imageView2 = (android.widget.ImageView) relativeLayout.findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id("com_tencent_ysdk_fullscreenpic_icon"));
            final android.widget.TextView textView = (android.widget.TextView) relativeLayout.findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id("com_tencent_ysdk_fullscreenpic_loading"));
            ((android.widget.TextView) relativeLayout.findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id("com_tencent_ysdk_fullscreenpic_textView"))).setText("" + (com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic.FullScreenPicPresenter.this.currentPos + 1) + "/" + com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic.FullScreenPicPresenter.this.imageViews.size());
            imageView.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic.FullScreenPicPresenter.FullPicAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(android.view.View view2) {
                    com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic.FullScreenPicPresenter.this.close();
                }
            });
            new java.lang.Thread(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic.FullScreenPicPresenter.FullPicAdapter.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        final android.graphics.Bitmap bitmapDecodeStream = android.graphics.BitmapFactory.decodeStream(new java.net.URL((java.lang.String) com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic.FullScreenPicPresenter.this.urls.get(i)).openStream());
                        if (bitmapDecodeStream != null) {
                            imageView.post(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic.FullScreenPicPresenter.FullPicAdapter.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    imageView.setImageBitmap(bitmapDecodeStream);
                                    imageView2.setImageBitmap(null);
                                    textView.setText("");
                                }
                            });
                        }
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            return relativeLayout;
        }

        public boolean isViewFromObject(android.view.View view, java.lang.Object obj) {
            return obj == view;
        }

        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
            com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic.FullScreenPicPresenter.this.currentPos = i;
            ((android.widget.TextView) ((android.widget.RelativeLayout) com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic.FullScreenPicPresenter.this.imageViews.get(com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic.FullScreenPicPresenter.this.currentPos)).findViewById(com.tencent.ysdk.shell.libware.ui.res.Res.id("com_tencent_ysdk_fullscreenpic_textView"))).setText("" + (com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic.FullScreenPicPresenter.this.currentPos + 1) + "/" + com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic.FullScreenPicPresenter.this.imageViews.size());
        }

        public void restoreState(android.os.Parcelable parcelable, java.lang.ClassLoader classLoader) {
        }

        public android.os.Parcelable saveState() {
            return null;
        }

        public void startUpdate(android.view.View view) {
        }
    }

    @Override // com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic.FullScreenPicContract.Presenter
    public void close() {
        this.mView.close();
    }

    @Override // com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic.FullScreenPicContract.Presenter
    public void showPic(com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic.FullScreenPicContract.View view, java.util.ArrayList<java.lang.String> arrayList, int i) {
        this.urls = arrayList;
        this.imageViews = new java.util.ArrayList<>();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            this.imageViews.add((android.widget.RelativeLayout) android.view.LayoutInflater.from(view.getContext()).inflate(com.tencent.ysdk.shell.libware.ui.res.Res.layout("com_tencent_ysdk_fuscreenpic_image"), (android.view.ViewGroup) null));
        }
        this.startPos = i;
        this.mView = view;
        this.mAdapter = new com.tencent.ysdk.shell.framework.web.browser.extention.fullscreenpic.FullScreenPicPresenter.FullPicAdapter();
        this.mView.setAdapter(this.mAdapter);
        this.mView.setCurrentView(this.startPos);
    }

    @Override // com.tencent.ysdk.shell.framework.mvp.BasePresenter
    public void start() {
    }
}
