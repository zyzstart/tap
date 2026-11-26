package android.support.v7.widget;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ShareActionProvider extends android.support.v4.view.ActionProvider {
    private static final int DEFAULT_INITIAL_ACTIVITY_COUNT = 4;
    public static final java.lang.String DEFAULT_SHARE_HISTORY_FILE_NAME = "share_history.xml";
    final android.content.Context mContext;
    private int mMaxShownActivityCount;
    private android.support.v7.widget.ActivityChooserModel.OnChooseActivityListener mOnChooseActivityListener;
    private final android.support.v7.widget.ShareActionProvider.ShareMenuItemOnMenuItemClickListener mOnMenuItemClickListener;
    android.support.v7.widget.ShareActionProvider.OnShareTargetSelectedListener mOnShareTargetSelectedListener;
    java.lang.String mShareHistoryFileName;

    public interface OnShareTargetSelectedListener {
        boolean onShareTargetSelected(android.support.v7.widget.ShareActionProvider shareActionProvider, android.content.Intent intent);
    }

    private class ShareActivityChooserModelPolicy implements android.support.v7.widget.ActivityChooserModel.OnChooseActivityListener {
        ShareActivityChooserModelPolicy() {
        }

        @Override // android.support.v7.widget.ActivityChooserModel.OnChooseActivityListener
        public boolean onChooseActivity(android.support.v7.widget.ActivityChooserModel activityChooserModel, android.content.Intent intent) {
            if (android.support.v7.widget.ShareActionProvider.this.mOnShareTargetSelectedListener == null) {
                return false;
            }
            android.support.v7.widget.ShareActionProvider.this.mOnShareTargetSelectedListener.onShareTargetSelected(android.support.v7.widget.ShareActionProvider.this, intent);
            return false;
        }
    }

    private class ShareMenuItemOnMenuItemClickListener implements android.view.MenuItem.OnMenuItemClickListener {
        ShareMenuItemOnMenuItemClickListener() {
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(android.view.MenuItem menuItem) {
            android.content.Intent intentChooseActivity = android.support.v7.widget.ActivityChooserModel.get(android.support.v7.widget.ShareActionProvider.this.mContext, android.support.v7.widget.ShareActionProvider.this.mShareHistoryFileName).chooseActivity(menuItem.getItemId());
            if (intentChooseActivity == null) {
                return true;
            }
            java.lang.String action = intentChooseActivity.getAction();
            if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
                android.support.v7.widget.ShareActionProvider.this.updateIntent(intentChooseActivity);
            }
            android.support.v7.widget.ShareActionProvider.this.mContext.startActivity(intentChooseActivity);
            return true;
        }
    }

    public ShareActionProvider(android.content.Context context) {
        super(context);
        this.mMaxShownActivityCount = 4;
        this.mOnMenuItemClickListener = new android.support.v7.widget.ShareActionProvider.ShareMenuItemOnMenuItemClickListener();
        this.mShareHistoryFileName = DEFAULT_SHARE_HISTORY_FILE_NAME;
        this.mContext = context;
    }

    private void setActivityChooserPolicyIfNeeded() {
        if (this.mOnShareTargetSelectedListener == null) {
            return;
        }
        if (this.mOnChooseActivityListener == null) {
            this.mOnChooseActivityListener = new android.support.v7.widget.ShareActionProvider.ShareActivityChooserModelPolicy();
        }
        android.support.v7.widget.ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName).setOnChooseActivityListener(this.mOnChooseActivityListener);
    }

    @Override // android.support.v4.view.ActionProvider
    public boolean hasSubMenu() {
        return true;
    }

    @Override // android.support.v4.view.ActionProvider
    public android.view.View onCreateActionView() {
        android.support.v7.widget.ActivityChooserView activityChooserView = new android.support.v7.widget.ActivityChooserView(this.mContext);
        if (!activityChooserView.isInEditMode()) {
            activityChooserView.setActivityChooserModel(android.support.v7.widget.ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName));
        }
        android.util.TypedValue typedValue = new android.util.TypedValue();
        this.mContext.getTheme().resolveAttribute(android.support.v7.appcompat.R.attr.actionModeShareDrawable, typedValue, true);
        activityChooserView.setExpandActivityOverflowButtonDrawable(android.support.v7.content.res.AppCompatResources.getDrawable(this.mContext, typedValue.resourceId));
        activityChooserView.setProvider(this);
        activityChooserView.setDefaultActionButtonContentDescription(android.support.v7.appcompat.R.string.abc_shareactionprovider_share_with_application);
        activityChooserView.setExpandActivityOverflowButtonContentDescription(android.support.v7.appcompat.R.string.abc_shareactionprovider_share_with);
        return activityChooserView;
    }

    @Override // android.support.v4.view.ActionProvider
    public void onPrepareSubMenu(android.view.SubMenu subMenu) {
        subMenu.clear();
        android.support.v7.widget.ActivityChooserModel activityChooserModel = android.support.v7.widget.ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName);
        android.content.pm.PackageManager packageManager = this.mContext.getPackageManager();
        int activityCount = activityChooserModel.getActivityCount();
        int iMin = java.lang.Math.min(activityCount, this.mMaxShownActivityCount);
        for (int i = 0; i < iMin; i++) {
            android.content.pm.ResolveInfo activity = activityChooserModel.getActivity(i);
            subMenu.add(0, i, i, activity.loadLabel(packageManager)).setIcon(activity.loadIcon(packageManager)).setOnMenuItemClickListener(this.mOnMenuItemClickListener);
        }
        if (iMin < activityCount) {
            android.view.SubMenu subMenuAddSubMenu = subMenu.addSubMenu(0, iMin, iMin, this.mContext.getString(android.support.v7.appcompat.R.string.abc_activity_chooser_view_see_all));
            for (int i2 = 0; i2 < activityCount; i2++) {
                android.content.pm.ResolveInfo activity2 = activityChooserModel.getActivity(i2);
                subMenuAddSubMenu.add(0, i2, i2, activity2.loadLabel(packageManager)).setIcon(activity2.loadIcon(packageManager)).setOnMenuItemClickListener(this.mOnMenuItemClickListener);
            }
        }
    }

    public void setOnShareTargetSelectedListener(android.support.v7.widget.ShareActionProvider.OnShareTargetSelectedListener onShareTargetSelectedListener) {
        this.mOnShareTargetSelectedListener = onShareTargetSelectedListener;
        setActivityChooserPolicyIfNeeded();
    }

    public void setShareHistoryFileName(java.lang.String str) {
        this.mShareHistoryFileName = str;
        setActivityChooserPolicyIfNeeded();
    }

    public void setShareIntent(android.content.Intent intent) {
        if (intent != null) {
            java.lang.String action = intent.getAction();
            if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
                updateIntent(intent);
            }
        }
        android.support.v7.widget.ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName).setIntent(intent);
    }

    void updateIntent(android.content.Intent intent) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            intent.addFlags(134742016);
        } else {
            intent.addFlags(524288);
        }
    }
}
