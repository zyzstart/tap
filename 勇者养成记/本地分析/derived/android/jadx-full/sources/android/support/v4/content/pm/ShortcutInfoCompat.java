package android.support.v4.content.pm;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ShortcutInfoCompat {
    private android.content.ComponentName mActivity;
    private android.content.Context mContext;
    private java.lang.CharSequence mDisabledMessage;
    private android.support.v4.graphics.drawable.IconCompat mIcon;
    private java.lang.String mId;
    private android.content.Intent[] mIntents;
    private java.lang.CharSequence mLabel;
    private java.lang.CharSequence mLongLabel;

    public static class Builder {
        private final android.support.v4.content.pm.ShortcutInfoCompat mInfo = new android.support.v4.content.pm.ShortcutInfoCompat();

        public Builder(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.NonNull java.lang.String str) {
            this.mInfo.mContext = context;
            this.mInfo.mId = str;
        }

        @android.support.annotation.NonNull
        public android.support.v4.content.pm.ShortcutInfoCompat build() {
            if (android.text.TextUtils.isEmpty(this.mInfo.mLabel)) {
                throw new java.lang.IllegalArgumentException("Shortcut much have a non-empty label");
            }
            if (this.mInfo.mIntents == null || this.mInfo.mIntents.length == 0) {
                throw new java.lang.IllegalArgumentException("Shortcut much have an intent");
            }
            return this.mInfo;
        }

        @android.support.annotation.NonNull
        public android.support.v4.content.pm.ShortcutInfoCompat.Builder setActivity(@android.support.annotation.NonNull android.content.ComponentName componentName) {
            this.mInfo.mActivity = componentName;
            return this;
        }

        @android.support.annotation.NonNull
        public android.support.v4.content.pm.ShortcutInfoCompat.Builder setDisabledMessage(@android.support.annotation.NonNull java.lang.CharSequence charSequence) {
            this.mInfo.mDisabledMessage = charSequence;
            return this;
        }

        @android.support.annotation.NonNull
        public android.support.v4.content.pm.ShortcutInfoCompat.Builder setIcon(@android.support.annotation.DrawableRes int i) {
            return setIcon(android.support.v4.graphics.drawable.IconCompat.createWithResource(this.mInfo.mContext, i));
        }

        @android.support.annotation.NonNull
        public android.support.v4.content.pm.ShortcutInfoCompat.Builder setIcon(@android.support.annotation.NonNull android.graphics.Bitmap bitmap) {
            return setIcon(android.support.v4.graphics.drawable.IconCompat.createWithBitmap(bitmap));
        }

        @android.support.annotation.NonNull
        public android.support.v4.content.pm.ShortcutInfoCompat.Builder setIcon(android.support.v4.graphics.drawable.IconCompat iconCompat) {
            this.mInfo.mIcon = iconCompat;
            return this;
        }

        @android.support.annotation.NonNull
        public android.support.v4.content.pm.ShortcutInfoCompat.Builder setIntent(@android.support.annotation.NonNull android.content.Intent intent) {
            return setIntents(new android.content.Intent[]{intent});
        }

        @android.support.annotation.NonNull
        public android.support.v4.content.pm.ShortcutInfoCompat.Builder setIntents(@android.support.annotation.NonNull android.content.Intent[] intentArr) {
            this.mInfo.mIntents = intentArr;
            return this;
        }

        @android.support.annotation.NonNull
        public android.support.v4.content.pm.ShortcutInfoCompat.Builder setLongLabel(@android.support.annotation.NonNull java.lang.CharSequence charSequence) {
            this.mInfo.mLongLabel = charSequence;
            return this;
        }

        @android.support.annotation.NonNull
        public android.support.v4.content.pm.ShortcutInfoCompat.Builder setShortLabel(@android.support.annotation.NonNull java.lang.CharSequence charSequence) {
            this.mInfo.mLabel = charSequence;
            return this;
        }
    }

    private ShortcutInfoCompat() {
    }

    android.content.Intent addToIntent(android.content.Intent intent) {
        android.content.Intent[] intentArr = this.mIntents;
        intent.putExtra("android.intent.extra.shortcut.INTENT", intentArr[intentArr.length - 1]).putExtra("android.intent.extra.shortcut.NAME", this.mLabel.toString());
        android.support.v4.graphics.drawable.IconCompat iconCompat = this.mIcon;
        if (iconCompat != null) {
            iconCompat.addToShortcutIntent(intent);
        }
        return intent;
    }

    @android.support.annotation.Nullable
    public android.content.ComponentName getActivity() {
        return this.mActivity;
    }

    @android.support.annotation.Nullable
    public java.lang.CharSequence getDisabledMessage() {
        return this.mDisabledMessage;
    }

    @android.support.annotation.NonNull
    public java.lang.String getId() {
        return this.mId;
    }

    @android.support.annotation.NonNull
    public android.content.Intent getIntent() {
        android.content.Intent[] intentArr = this.mIntents;
        return intentArr[intentArr.length - 1];
    }

    @android.support.annotation.NonNull
    public android.content.Intent[] getIntents() {
        android.content.Intent[] intentArr = this.mIntents;
        return (android.content.Intent[]) java.util.Arrays.copyOf(intentArr, intentArr.length);
    }

    @android.support.annotation.Nullable
    public java.lang.CharSequence getLongLabel() {
        return this.mLongLabel;
    }

    @android.support.annotation.NonNull
    public java.lang.CharSequence getShortLabel() {
        return this.mLabel;
    }

    @android.support.annotation.RequiresApi(26)
    android.content.pm.ShortcutInfo toShortcutInfo() {
        android.content.pm.ShortcutInfo.Builder intents = new android.content.pm.ShortcutInfo.Builder(this.mContext, this.mId).setShortLabel(this.mLabel).setIntents(this.mIntents);
        android.support.v4.graphics.drawable.IconCompat iconCompat = this.mIcon;
        if (iconCompat != null) {
            intents.setIcon(iconCompat.toIcon());
        }
        if (!android.text.TextUtils.isEmpty(this.mLongLabel)) {
            intents.setLongLabel(this.mLongLabel);
        }
        if (!android.text.TextUtils.isEmpty(this.mDisabledMessage)) {
            intents.setDisabledMessage(this.mDisabledMessage);
        }
        android.content.ComponentName componentName = this.mActivity;
        if (componentName != null) {
            intents.setActivity(componentName);
        }
        return intents.build();
    }
}
