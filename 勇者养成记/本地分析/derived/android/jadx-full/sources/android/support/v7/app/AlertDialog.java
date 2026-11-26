package android.support.v7.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class AlertDialog extends android.support.v7.app.AppCompatDialog implements android.content.DialogInterface {
    static final int LAYOUT_HINT_NONE = 0;
    static final int LAYOUT_HINT_SIDE = 1;
    final android.support.v7.app.AlertController mAlert;

    public static class Builder {
        private final android.support.v7.app.AlertController.AlertParams P;
        private final int mTheme;

        public Builder(@android.support.annotation.NonNull android.content.Context context) {
            this(context, android.support.v7.app.AlertDialog.resolveDialogTheme(context, 0));
        }

        public Builder(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.StyleRes int i) {
            this.P = new android.support.v7.app.AlertController.AlertParams(new android.view.ContextThemeWrapper(context, android.support.v7.app.AlertDialog.resolveDialogTheme(context, i)));
            this.mTheme = i;
        }

        public android.support.v7.app.AlertDialog create() {
            android.support.v7.app.AlertDialog alertDialog = new android.support.v7.app.AlertDialog(this.P.mContext, this.mTheme);
            this.P.apply(alertDialog.mAlert);
            alertDialog.setCancelable(this.P.mCancelable);
            if (this.P.mCancelable) {
                alertDialog.setCanceledOnTouchOutside(true);
            }
            alertDialog.setOnCancelListener(this.P.mOnCancelListener);
            alertDialog.setOnDismissListener(this.P.mOnDismissListener);
            if (this.P.mOnKeyListener != null) {
                alertDialog.setOnKeyListener(this.P.mOnKeyListener);
            }
            return alertDialog;
        }

        @android.support.annotation.NonNull
        public android.content.Context getContext() {
            return this.P.mContext;
        }

        public android.support.v7.app.AlertDialog.Builder setAdapter(android.widget.ListAdapter listAdapter, android.content.DialogInterface.OnClickListener onClickListener) {
            android.support.v7.app.AlertController.AlertParams alertParams = this.P;
            alertParams.mAdapter = listAdapter;
            alertParams.mOnClickListener = onClickListener;
            return this;
        }

        public android.support.v7.app.AlertDialog.Builder setCancelable(boolean z) {
            this.P.mCancelable = z;
            return this;
        }

        public android.support.v7.app.AlertDialog.Builder setCursor(android.database.Cursor cursor, android.content.DialogInterface.OnClickListener onClickListener, java.lang.String str) {
            android.support.v7.app.AlertController.AlertParams alertParams = this.P;
            alertParams.mCursor = cursor;
            alertParams.mLabelColumn = str;
            alertParams.mOnClickListener = onClickListener;
            return this;
        }

        public android.support.v7.app.AlertDialog.Builder setCustomTitle(@android.support.annotation.Nullable android.view.View view) {
            this.P.mCustomTitleView = view;
            return this;
        }

        public android.support.v7.app.AlertDialog.Builder setIcon(@android.support.annotation.DrawableRes int i) {
            this.P.mIconId = i;
            return this;
        }

        public android.support.v7.app.AlertDialog.Builder setIcon(@android.support.annotation.Nullable android.graphics.drawable.Drawable drawable) {
            this.P.mIcon = drawable;
            return this;
        }

        public android.support.v7.app.AlertDialog.Builder setIconAttribute(@android.support.annotation.AttrRes int i) {
            android.util.TypedValue typedValue = new android.util.TypedValue();
            this.P.mContext.getTheme().resolveAttribute(i, typedValue, true);
            this.P.mIconId = typedValue.resourceId;
            return this;
        }

        @java.lang.Deprecated
        public android.support.v7.app.AlertDialog.Builder setInverseBackgroundForced(boolean z) {
            this.P.mForceInverseBackground = z;
            return this;
        }

        public android.support.v7.app.AlertDialog.Builder setItems(@android.support.annotation.ArrayRes int i, android.content.DialogInterface.OnClickListener onClickListener) {
            android.support.v7.app.AlertController.AlertParams alertParams = this.P;
            alertParams.mItems = alertParams.mContext.getResources().getTextArray(i);
            this.P.mOnClickListener = onClickListener;
            return this;
        }

        public android.support.v7.app.AlertDialog.Builder setItems(java.lang.CharSequence[] charSequenceArr, android.content.DialogInterface.OnClickListener onClickListener) {
            android.support.v7.app.AlertController.AlertParams alertParams = this.P;
            alertParams.mItems = charSequenceArr;
            alertParams.mOnClickListener = onClickListener;
            return this;
        }

        public android.support.v7.app.AlertDialog.Builder setMessage(@android.support.annotation.StringRes int i) {
            android.support.v7.app.AlertController.AlertParams alertParams = this.P;
            alertParams.mMessage = alertParams.mContext.getText(i);
            return this;
        }

        public android.support.v7.app.AlertDialog.Builder setMessage(@android.support.annotation.Nullable java.lang.CharSequence charSequence) {
            this.P.mMessage = charSequence;
            return this;
        }

        public android.support.v7.app.AlertDialog.Builder setMultiChoiceItems(@android.support.annotation.ArrayRes int i, boolean[] zArr, android.content.DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            android.support.v7.app.AlertController.AlertParams alertParams = this.P;
            alertParams.mItems = alertParams.mContext.getResources().getTextArray(i);
            android.support.v7.app.AlertController.AlertParams alertParams2 = this.P;
            alertParams2.mOnCheckboxClickListener = onMultiChoiceClickListener;
            alertParams2.mCheckedItems = zArr;
            alertParams2.mIsMultiChoice = true;
            return this;
        }

        public android.support.v7.app.AlertDialog.Builder setMultiChoiceItems(android.database.Cursor cursor, java.lang.String str, java.lang.String str2, android.content.DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            android.support.v7.app.AlertController.AlertParams alertParams = this.P;
            alertParams.mCursor = cursor;
            alertParams.mOnCheckboxClickListener = onMultiChoiceClickListener;
            alertParams.mIsCheckedColumn = str;
            alertParams.mLabelColumn = str2;
            alertParams.mIsMultiChoice = true;
            return this;
        }

        public android.support.v7.app.AlertDialog.Builder setMultiChoiceItems(java.lang.CharSequence[] charSequenceArr, boolean[] zArr, android.content.DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            android.support.v7.app.AlertController.AlertParams alertParams = this.P;
            alertParams.mItems = charSequenceArr;
            alertParams.mOnCheckboxClickListener = onMultiChoiceClickListener;
            alertParams.mCheckedItems = zArr;
            alertParams.mIsMultiChoice = true;
            return this;
        }

        public android.support.v7.app.AlertDialog.Builder setNegativeButton(@android.support.annotation.StringRes int i, android.content.DialogInterface.OnClickListener onClickListener) {
            android.support.v7.app.AlertController.AlertParams alertParams = this.P;
            alertParams.mNegativeButtonText = alertParams.mContext.getText(i);
            this.P.mNegativeButtonListener = onClickListener;
            return this;
        }

        public android.support.v7.app.AlertDialog.Builder setNegativeButton(java.lang.CharSequence charSequence, android.content.DialogInterface.OnClickListener onClickListener) {
            android.support.v7.app.AlertController.AlertParams alertParams = this.P;
            alertParams.mNegativeButtonText = charSequence;
            alertParams.mNegativeButtonListener = onClickListener;
            return this;
        }

        public android.support.v7.app.AlertDialog.Builder setNeutralButton(@android.support.annotation.StringRes int i, android.content.DialogInterface.OnClickListener onClickListener) {
            android.support.v7.app.AlertController.AlertParams alertParams = this.P;
            alertParams.mNeutralButtonText = alertParams.mContext.getText(i);
            this.P.mNeutralButtonListener = onClickListener;
            return this;
        }

        public android.support.v7.app.AlertDialog.Builder setNeutralButton(java.lang.CharSequence charSequence, android.content.DialogInterface.OnClickListener onClickListener) {
            android.support.v7.app.AlertController.AlertParams alertParams = this.P;
            alertParams.mNeutralButtonText = charSequence;
            alertParams.mNeutralButtonListener = onClickListener;
            return this;
        }

        public android.support.v7.app.AlertDialog.Builder setOnCancelListener(android.content.DialogInterface.OnCancelListener onCancelListener) {
            this.P.mOnCancelListener = onCancelListener;
            return this;
        }

        public android.support.v7.app.AlertDialog.Builder setOnDismissListener(android.content.DialogInterface.OnDismissListener onDismissListener) {
            this.P.mOnDismissListener = onDismissListener;
            return this;
        }

        public android.support.v7.app.AlertDialog.Builder setOnItemSelectedListener(android.widget.AdapterView.OnItemSelectedListener onItemSelectedListener) {
            this.P.mOnItemSelectedListener = onItemSelectedListener;
            return this;
        }

        public android.support.v7.app.AlertDialog.Builder setOnKeyListener(android.content.DialogInterface.OnKeyListener onKeyListener) {
            this.P.mOnKeyListener = onKeyListener;
            return this;
        }

        public android.support.v7.app.AlertDialog.Builder setPositiveButton(@android.support.annotation.StringRes int i, android.content.DialogInterface.OnClickListener onClickListener) {
            android.support.v7.app.AlertController.AlertParams alertParams = this.P;
            alertParams.mPositiveButtonText = alertParams.mContext.getText(i);
            this.P.mPositiveButtonListener = onClickListener;
            return this;
        }

        public android.support.v7.app.AlertDialog.Builder setPositiveButton(java.lang.CharSequence charSequence, android.content.DialogInterface.OnClickListener onClickListener) {
            android.support.v7.app.AlertController.AlertParams alertParams = this.P;
            alertParams.mPositiveButtonText = charSequence;
            alertParams.mPositiveButtonListener = onClickListener;
            return this;
        }

        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public android.support.v7.app.AlertDialog.Builder setRecycleOnMeasureEnabled(boolean z) {
            this.P.mRecycleOnMeasure = z;
            return this;
        }

        public android.support.v7.app.AlertDialog.Builder setSingleChoiceItems(@android.support.annotation.ArrayRes int i, int i2, android.content.DialogInterface.OnClickListener onClickListener) {
            android.support.v7.app.AlertController.AlertParams alertParams = this.P;
            alertParams.mItems = alertParams.mContext.getResources().getTextArray(i);
            android.support.v7.app.AlertController.AlertParams alertParams2 = this.P;
            alertParams2.mOnClickListener = onClickListener;
            alertParams2.mCheckedItem = i2;
            alertParams2.mIsSingleChoice = true;
            return this;
        }

        public android.support.v7.app.AlertDialog.Builder setSingleChoiceItems(android.database.Cursor cursor, int i, java.lang.String str, android.content.DialogInterface.OnClickListener onClickListener) {
            android.support.v7.app.AlertController.AlertParams alertParams = this.P;
            alertParams.mCursor = cursor;
            alertParams.mOnClickListener = onClickListener;
            alertParams.mCheckedItem = i;
            alertParams.mLabelColumn = str;
            alertParams.mIsSingleChoice = true;
            return this;
        }

        public android.support.v7.app.AlertDialog.Builder setSingleChoiceItems(android.widget.ListAdapter listAdapter, int i, android.content.DialogInterface.OnClickListener onClickListener) {
            android.support.v7.app.AlertController.AlertParams alertParams = this.P;
            alertParams.mAdapter = listAdapter;
            alertParams.mOnClickListener = onClickListener;
            alertParams.mCheckedItem = i;
            alertParams.mIsSingleChoice = true;
            return this;
        }

        public android.support.v7.app.AlertDialog.Builder setSingleChoiceItems(java.lang.CharSequence[] charSequenceArr, int i, android.content.DialogInterface.OnClickListener onClickListener) {
            android.support.v7.app.AlertController.AlertParams alertParams = this.P;
            alertParams.mItems = charSequenceArr;
            alertParams.mOnClickListener = onClickListener;
            alertParams.mCheckedItem = i;
            alertParams.mIsSingleChoice = true;
            return this;
        }

        public android.support.v7.app.AlertDialog.Builder setTitle(@android.support.annotation.StringRes int i) {
            android.support.v7.app.AlertController.AlertParams alertParams = this.P;
            alertParams.mTitle = alertParams.mContext.getText(i);
            return this;
        }

        public android.support.v7.app.AlertDialog.Builder setTitle(@android.support.annotation.Nullable java.lang.CharSequence charSequence) {
            this.P.mTitle = charSequence;
            return this;
        }

        public android.support.v7.app.AlertDialog.Builder setView(int i) {
            android.support.v7.app.AlertController.AlertParams alertParams = this.P;
            alertParams.mView = null;
            alertParams.mViewLayoutResId = i;
            alertParams.mViewSpacingSpecified = false;
            return this;
        }

        public android.support.v7.app.AlertDialog.Builder setView(android.view.View view) {
            android.support.v7.app.AlertController.AlertParams alertParams = this.P;
            alertParams.mView = view;
            alertParams.mViewLayoutResId = 0;
            alertParams.mViewSpacingSpecified = false;
            return this;
        }

        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        @java.lang.Deprecated
        public android.support.v7.app.AlertDialog.Builder setView(android.view.View view, int i, int i2, int i3, int i4) {
            android.support.v7.app.AlertController.AlertParams alertParams = this.P;
            alertParams.mView = view;
            alertParams.mViewLayoutResId = 0;
            alertParams.mViewSpacingSpecified = true;
            alertParams.mViewSpacingLeft = i;
            alertParams.mViewSpacingTop = i2;
            alertParams.mViewSpacingRight = i3;
            alertParams.mViewSpacingBottom = i4;
            return this;
        }

        public android.support.v7.app.AlertDialog show() {
            android.support.v7.app.AlertDialog alertDialogCreate = create();
            alertDialogCreate.show();
            return alertDialogCreate;
        }
    }

    protected AlertDialog(@android.support.annotation.NonNull android.content.Context context) {
        this(context, 0);
    }

    protected AlertDialog(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.StyleRes int i) {
        super(context, resolveDialogTheme(context, i));
        this.mAlert = new android.support.v7.app.AlertController(getContext(), this, getWindow());
    }

    protected AlertDialog(@android.support.annotation.NonNull android.content.Context context, boolean z, @android.support.annotation.Nullable android.content.DialogInterface.OnCancelListener onCancelListener) {
        this(context, 0);
        setCancelable(z);
        setOnCancelListener(onCancelListener);
    }

    static int resolveDialogTheme(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.StyleRes int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        android.util.TypedValue typedValue = new android.util.TypedValue();
        context.getTheme().resolveAttribute(android.support.v7.appcompat.R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public android.widget.Button getButton(int i) {
        return this.mAlert.getButton(i);
    }

    public android.widget.ListView getListView() {
        return this.mAlert.getListView();
    }

    @Override // android.support.v7.app.AppCompatDialog, android.app.Dialog
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        this.mAlert.installContent();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
        if (this.mAlert.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, android.view.KeyEvent keyEvent) {
        if (this.mAlert.onKeyUp(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    public void setButton(int i, java.lang.CharSequence charSequence, android.content.DialogInterface.OnClickListener onClickListener) {
        this.mAlert.setButton(i, charSequence, onClickListener, null);
    }

    public void setButton(int i, java.lang.CharSequence charSequence, android.os.Message message) {
        this.mAlert.setButton(i, charSequence, null, message);
    }

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    void setButtonPanelLayoutHint(int i) {
        this.mAlert.setButtonPanelLayoutHint(i);
    }

    public void setCustomTitle(android.view.View view) {
        this.mAlert.setCustomTitle(view);
    }

    public void setIcon(int i) {
        this.mAlert.setIcon(i);
    }

    public void setIcon(android.graphics.drawable.Drawable drawable) {
        this.mAlert.setIcon(drawable);
    }

    public void setIconAttribute(int i) {
        android.util.TypedValue typedValue = new android.util.TypedValue();
        getContext().getTheme().resolveAttribute(i, typedValue, true);
        this.mAlert.setIcon(typedValue.resourceId);
    }

    public void setMessage(java.lang.CharSequence charSequence) {
        this.mAlert.setMessage(charSequence);
    }

    @Override // android.support.v7.app.AppCompatDialog, android.app.Dialog
    public void setTitle(java.lang.CharSequence charSequence) {
        super.setTitle(charSequence);
        this.mAlert.setTitle(charSequence);
    }

    public void setView(android.view.View view) {
        this.mAlert.setView(view);
    }

    public void setView(android.view.View view, int i, int i2, int i3, int i4) {
        this.mAlert.setView(view, i, i2, i3, i4);
    }
}
