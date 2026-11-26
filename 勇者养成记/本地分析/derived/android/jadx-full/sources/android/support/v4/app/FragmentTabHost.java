package android.support.v4.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class FragmentTabHost extends android.widget.TabHost implements android.widget.TabHost.OnTabChangeListener {
    private boolean mAttached;
    private int mContainerId;
    private android.content.Context mContext;
    private android.support.v4.app.FragmentManager mFragmentManager;
    private android.support.v4.app.FragmentTabHost.TabInfo mLastTab;
    private android.widget.TabHost.OnTabChangeListener mOnTabChangeListener;
    private android.widget.FrameLayout mRealTabContent;
    private final java.util.ArrayList<android.support.v4.app.FragmentTabHost.TabInfo> mTabs;

    static class DummyTabFactory implements android.widget.TabHost.TabContentFactory {
        private final android.content.Context mContext;

        public DummyTabFactory(android.content.Context context) {
            this.mContext = context;
        }

        @Override // android.widget.TabHost.TabContentFactory
        public android.view.View createTabContent(java.lang.String str) {
            android.view.View view = new android.view.View(this.mContext);
            view.setMinimumWidth(0);
            view.setMinimumHeight(0);
            return view;
        }
    }

    static class SavedState extends android.view.View.BaseSavedState {
        public static final android.os.Parcelable.Creator<android.support.v4.app.FragmentTabHost.SavedState> CREATOR = new android.os.Parcelable.Creator<android.support.v4.app.FragmentTabHost.SavedState>() { // from class: android.support.v4.app.FragmentTabHost.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public android.support.v4.app.FragmentTabHost.SavedState createFromParcel(android.os.Parcel parcel) {
                return new android.support.v4.app.FragmentTabHost.SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public android.support.v4.app.FragmentTabHost.SavedState[] newArray(int i) {
                return new android.support.v4.app.FragmentTabHost.SavedState[i];
            }
        };
        java.lang.String curTab;

        SavedState(android.os.Parcel parcel) {
            super(parcel);
            this.curTab = parcel.readString();
        }

        SavedState(android.os.Parcelable parcelable) {
            super(parcelable);
        }

        public java.lang.String toString() {
            return "FragmentTabHost.SavedState{" + java.lang.Integer.toHexString(java.lang.System.identityHashCode(this)) + " curTab=" + this.curTab + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.curTab);
        }
    }

    static final class TabInfo {

        @android.support.annotation.Nullable
        final android.os.Bundle args;

        @android.support.annotation.NonNull
        final java.lang.Class<?> clss;
        android.support.v4.app.Fragment fragment;

        @android.support.annotation.NonNull
        final java.lang.String tag;

        TabInfo(@android.support.annotation.NonNull java.lang.String str, @android.support.annotation.NonNull java.lang.Class<?> cls, @android.support.annotation.Nullable android.os.Bundle bundle) {
            this.tag = str;
            this.clss = cls;
            this.args = bundle;
        }
    }

    public FragmentTabHost(android.content.Context context) {
        super(context, null);
        this.mTabs = new java.util.ArrayList<>();
        initFragmentTabHost(context, null);
    }

    public FragmentTabHost(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTabs = new java.util.ArrayList<>();
        initFragmentTabHost(context, attributeSet);
    }

    @android.support.annotation.Nullable
    private android.support.v4.app.FragmentTransaction doTabChanged(@android.support.annotation.Nullable java.lang.String str, @android.support.annotation.Nullable android.support.v4.app.FragmentTransaction fragmentTransaction) {
        android.support.v4.app.FragmentTabHost.TabInfo tabInfoForTag = getTabInfoForTag(str);
        if (this.mLastTab != tabInfoForTag) {
            if (fragmentTransaction == null) {
                fragmentTransaction = this.mFragmentManager.beginTransaction();
            }
            android.support.v4.app.FragmentTabHost.TabInfo tabInfo = this.mLastTab;
            if (tabInfo != null && tabInfo.fragment != null) {
                fragmentTransaction.detach(this.mLastTab.fragment);
            }
            if (tabInfoForTag != null) {
                if (tabInfoForTag.fragment == null) {
                    tabInfoForTag.fragment = android.support.v4.app.Fragment.instantiate(this.mContext, tabInfoForTag.clss.getName(), tabInfoForTag.args);
                    fragmentTransaction.add(this.mContainerId, tabInfoForTag.fragment, tabInfoForTag.tag);
                } else {
                    fragmentTransaction.attach(tabInfoForTag.fragment);
                }
            }
            this.mLastTab = tabInfoForTag;
        }
        return fragmentTransaction;
    }

    private void ensureContent() {
        if (this.mRealTabContent == null) {
            this.mRealTabContent = (android.widget.FrameLayout) findViewById(this.mContainerId);
            if (this.mRealTabContent != null) {
                return;
            }
            throw new java.lang.IllegalStateException("No tab content FrameLayout found for id " + this.mContainerId);
        }
    }

    private void ensureHierarchy(android.content.Context context) {
        if (findViewById(android.R.id.tabs) == null) {
            android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(context);
            linearLayout.setOrientation(1);
            addView(linearLayout, new android.widget.FrameLayout.LayoutParams(-1, -1));
            android.widget.TabWidget tabWidget = new android.widget.TabWidget(context);
            tabWidget.setId(android.R.id.tabs);
            tabWidget.setOrientation(0);
            linearLayout.addView(tabWidget, new android.widget.LinearLayout.LayoutParams(-1, -2, 0.0f));
            android.widget.FrameLayout frameLayout = new android.widget.FrameLayout(context);
            frameLayout.setId(android.R.id.tabcontent);
            linearLayout.addView(frameLayout, new android.widget.LinearLayout.LayoutParams(0, 0, 0.0f));
            android.widget.FrameLayout frameLayout2 = new android.widget.FrameLayout(context);
            this.mRealTabContent = frameLayout2;
            this.mRealTabContent.setId(this.mContainerId);
            linearLayout.addView(frameLayout2, new android.widget.LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
    }

    @android.support.annotation.Nullable
    private android.support.v4.app.FragmentTabHost.TabInfo getTabInfoForTag(java.lang.String str) {
        int size = this.mTabs.size();
        for (int i = 0; i < size; i++) {
            android.support.v4.app.FragmentTabHost.TabInfo tabInfo = this.mTabs.get(i);
            if (tabInfo.tag.equals(str)) {
                return tabInfo;
            }
        }
        return null;
    }

    private void initFragmentTabHost(android.content.Context context, android.util.AttributeSet attributeSet) {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{android.R.attr.inflatedId}, 0, 0);
        this.mContainerId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    public void addTab(@android.support.annotation.NonNull android.widget.TabHost.TabSpec tabSpec, @android.support.annotation.NonNull java.lang.Class<?> cls, @android.support.annotation.Nullable android.os.Bundle bundle) {
        tabSpec.setContent(new android.support.v4.app.FragmentTabHost.DummyTabFactory(this.mContext));
        java.lang.String tag = tabSpec.getTag();
        android.support.v4.app.FragmentTabHost.TabInfo tabInfo = new android.support.v4.app.FragmentTabHost.TabInfo(tag, cls, bundle);
        if (this.mAttached) {
            tabInfo.fragment = this.mFragmentManager.findFragmentByTag(tag);
            if (tabInfo.fragment != null && !tabInfo.fragment.isDetached()) {
                android.support.v4.app.FragmentTransaction fragmentTransactionBeginTransaction = this.mFragmentManager.beginTransaction();
                fragmentTransactionBeginTransaction.detach(tabInfo.fragment);
                fragmentTransactionBeginTransaction.commit();
            }
        }
        this.mTabs.add(tabInfo);
        addTab(tabSpec);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        java.lang.String currentTabTag = getCurrentTabTag();
        int size = this.mTabs.size();
        android.support.v4.app.FragmentTransaction fragmentTransactionBeginTransaction = null;
        for (int i = 0; i < size; i++) {
            android.support.v4.app.FragmentTabHost.TabInfo tabInfo = this.mTabs.get(i);
            tabInfo.fragment = this.mFragmentManager.findFragmentByTag(tabInfo.tag);
            if (tabInfo.fragment != null && !tabInfo.fragment.isDetached()) {
                if (tabInfo.tag.equals(currentTabTag)) {
                    this.mLastTab = tabInfo;
                } else {
                    if (fragmentTransactionBeginTransaction == null) {
                        fragmentTransactionBeginTransaction = this.mFragmentManager.beginTransaction();
                    }
                    fragmentTransactionBeginTransaction.detach(tabInfo.fragment);
                }
            }
        }
        this.mAttached = true;
        android.support.v4.app.FragmentTransaction fragmentTransactionDoTabChanged = doTabChanged(currentTabTag, fragmentTransactionBeginTransaction);
        if (fragmentTransactionDoTabChanged != null) {
            fragmentTransactionDoTabChanged.commit();
            this.mFragmentManager.executePendingTransactions();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mAttached = false;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(android.os.Parcelable parcelable) {
        if (!(parcelable instanceof android.support.v4.app.FragmentTabHost.SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        android.support.v4.app.FragmentTabHost.SavedState savedState = (android.support.v4.app.FragmentTabHost.SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.curTab);
    }

    @Override // android.view.View
    protected android.os.Parcelable onSaveInstanceState() {
        android.support.v4.app.FragmentTabHost.SavedState savedState = new android.support.v4.app.FragmentTabHost.SavedState(super.onSaveInstanceState());
        savedState.curTab = getCurrentTabTag();
        return savedState;
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    public void onTabChanged(java.lang.String str) {
        android.support.v4.app.FragmentTransaction fragmentTransactionDoTabChanged;
        if (this.mAttached && (fragmentTransactionDoTabChanged = doTabChanged(str, null)) != null) {
            fragmentTransactionDoTabChanged.commit();
        }
        android.widget.TabHost.OnTabChangeListener onTabChangeListener = this.mOnTabChangeListener;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
    }

    @Override // android.widget.TabHost
    public void setOnTabChangedListener(android.widget.TabHost.OnTabChangeListener onTabChangeListener) {
        this.mOnTabChangeListener = onTabChangeListener;
    }

    @Override // android.widget.TabHost
    @java.lang.Deprecated
    public void setup() {
        throw new java.lang.IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    public void setup(android.content.Context context, android.support.v4.app.FragmentManager fragmentManager) {
        ensureHierarchy(context);
        super.setup();
        this.mContext = context;
        this.mFragmentManager = fragmentManager;
        ensureContent();
    }

    public void setup(android.content.Context context, android.support.v4.app.FragmentManager fragmentManager, int i) {
        ensureHierarchy(context);
        super.setup();
        this.mContext = context;
        this.mFragmentManager = fragmentManager;
        this.mContainerId = i;
        ensureContent();
        this.mRealTabContent.setId(i);
        if (getId() == -1) {
            setId(android.R.id.tabhost);
        }
    }
}
