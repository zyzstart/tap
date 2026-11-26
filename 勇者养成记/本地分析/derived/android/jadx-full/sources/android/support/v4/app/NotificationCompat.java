package android.support.v4.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class NotificationCompat {
    public static final int BADGE_ICON_LARGE = 2;
    public static final int BADGE_ICON_NONE = 0;
    public static final int BADGE_ICON_SMALL = 1;
    public static final java.lang.String CATEGORY_ALARM = "alarm";
    public static final java.lang.String CATEGORY_CALL = "call";
    public static final java.lang.String CATEGORY_EMAIL = "email";
    public static final java.lang.String CATEGORY_ERROR = "err";
    public static final java.lang.String CATEGORY_EVENT = "event";
    public static final java.lang.String CATEGORY_MESSAGE = "msg";
    public static final java.lang.String CATEGORY_PROGRESS = "progress";
    public static final java.lang.String CATEGORY_PROMO = "promo";
    public static final java.lang.String CATEGORY_RECOMMENDATION = "recommendation";
    public static final java.lang.String CATEGORY_REMINDER = "reminder";
    public static final java.lang.String CATEGORY_SERVICE = "service";
    public static final java.lang.String CATEGORY_SOCIAL = "social";
    public static final java.lang.String CATEGORY_STATUS = "status";
    public static final java.lang.String CATEGORY_SYSTEM = "sys";
    public static final java.lang.String CATEGORY_TRANSPORT = "transport";

    @android.support.annotation.ColorInt
    public static final int COLOR_DEFAULT = 0;
    public static final int DEFAULT_ALL = -1;
    public static final int DEFAULT_LIGHTS = 4;
    public static final int DEFAULT_SOUND = 1;
    public static final int DEFAULT_VIBRATE = 2;
    public static final java.lang.String EXTRA_AUDIO_CONTENTS_URI = "android.audioContents";
    public static final java.lang.String EXTRA_BACKGROUND_IMAGE_URI = "android.backgroundImageUri";
    public static final java.lang.String EXTRA_BIG_TEXT = "android.bigText";
    public static final java.lang.String EXTRA_COMPACT_ACTIONS = "android.compactActions";
    public static final java.lang.String EXTRA_CONVERSATION_TITLE = "android.conversationTitle";
    public static final java.lang.String EXTRA_INFO_TEXT = "android.infoText";
    public static final java.lang.String EXTRA_LARGE_ICON = "android.largeIcon";
    public static final java.lang.String EXTRA_LARGE_ICON_BIG = "android.largeIcon.big";
    public static final java.lang.String EXTRA_MEDIA_SESSION = "android.mediaSession";
    public static final java.lang.String EXTRA_MESSAGES = "android.messages";
    public static final java.lang.String EXTRA_PEOPLE = "android.people";
    public static final java.lang.String EXTRA_PICTURE = "android.picture";
    public static final java.lang.String EXTRA_PROGRESS = "android.progress";
    public static final java.lang.String EXTRA_PROGRESS_INDETERMINATE = "android.progressIndeterminate";
    public static final java.lang.String EXTRA_PROGRESS_MAX = "android.progressMax";
    public static final java.lang.String EXTRA_REMOTE_INPUT_HISTORY = "android.remoteInputHistory";
    public static final java.lang.String EXTRA_SELF_DISPLAY_NAME = "android.selfDisplayName";
    public static final java.lang.String EXTRA_SHOW_CHRONOMETER = "android.showChronometer";
    public static final java.lang.String EXTRA_SHOW_WHEN = "android.showWhen";
    public static final java.lang.String EXTRA_SMALL_ICON = "android.icon";
    public static final java.lang.String EXTRA_SUB_TEXT = "android.subText";
    public static final java.lang.String EXTRA_SUMMARY_TEXT = "android.summaryText";
    public static final java.lang.String EXTRA_TEMPLATE = "android.template";
    public static final java.lang.String EXTRA_TEXT = "android.text";
    public static final java.lang.String EXTRA_TEXT_LINES = "android.textLines";
    public static final java.lang.String EXTRA_TITLE = "android.title";
    public static final java.lang.String EXTRA_TITLE_BIG = "android.title.big";
    public static final int FLAG_AUTO_CANCEL = 16;
    public static final int FLAG_FOREGROUND_SERVICE = 64;
    public static final int FLAG_GROUP_SUMMARY = 512;

    @java.lang.Deprecated
    public static final int FLAG_HIGH_PRIORITY = 128;
    public static final int FLAG_INSISTENT = 4;
    public static final int FLAG_LOCAL_ONLY = 256;
    public static final int FLAG_NO_CLEAR = 32;
    public static final int FLAG_ONGOING_EVENT = 2;
    public static final int FLAG_ONLY_ALERT_ONCE = 8;
    public static final int FLAG_SHOW_LIGHTS = 1;
    public static final int GROUP_ALERT_ALL = 0;
    public static final int GROUP_ALERT_CHILDREN = 2;
    public static final int GROUP_ALERT_SUMMARY = 1;
    static final android.support.v4.app.NotificationCompat.NotificationCompatImpl IMPL;
    public static final int PRIORITY_DEFAULT = 0;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_LOW = -1;
    public static final int PRIORITY_MAX = 2;
    public static final int PRIORITY_MIN = -2;
    public static final int STREAM_DEFAULT = -1;
    public static final int VISIBILITY_PRIVATE = 0;
    public static final int VISIBILITY_PUBLIC = 1;
    public static final int VISIBILITY_SECRET = -1;

    public static class Action extends android.support.v4.app.NotificationCompatBase.Action {

        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public static final android.support.v4.app.NotificationCompatBase.Action.Factory FACTORY = new android.support.v4.app.NotificationCompatBase.Action.Factory() { // from class: android.support.v4.app.NotificationCompat.Action.1
            @Override // android.support.v4.app.NotificationCompatBase.Action.Factory
            public android.support.v4.app.NotificationCompatBase.Action build(int i, java.lang.CharSequence charSequence, android.app.PendingIntent pendingIntent, android.os.Bundle bundle, android.support.v4.app.RemoteInputCompatBase.RemoteInput[] remoteInputArr, android.support.v4.app.RemoteInputCompatBase.RemoteInput[] remoteInputArr2, boolean z) {
                return new android.support.v4.app.NotificationCompat.Action(i, charSequence, pendingIntent, bundle, (android.support.v4.app.RemoteInput[]) remoteInputArr, (android.support.v4.app.RemoteInput[]) remoteInputArr2, z);
            }

            @Override // android.support.v4.app.NotificationCompatBase.Action.Factory
            public android.support.v4.app.NotificationCompat.Action[] newArray(int i) {
                return new android.support.v4.app.NotificationCompat.Action[i];
            }
        };
        public android.app.PendingIntent actionIntent;
        public int icon;
        private boolean mAllowGeneratedReplies;
        private final android.support.v4.app.RemoteInput[] mDataOnlyRemoteInputs;
        final android.os.Bundle mExtras;
        private final android.support.v4.app.RemoteInput[] mRemoteInputs;
        public java.lang.CharSequence title;

        public static final class Builder {
            private boolean mAllowGeneratedReplies;
            private final android.os.Bundle mExtras;
            private final int mIcon;
            private final android.app.PendingIntent mIntent;
            private java.util.ArrayList<android.support.v4.app.RemoteInput> mRemoteInputs;
            private final java.lang.CharSequence mTitle;

            public Builder(int i, java.lang.CharSequence charSequence, android.app.PendingIntent pendingIntent) {
                this(i, charSequence, pendingIntent, new android.os.Bundle(), null, true);
            }

            private Builder(int i, java.lang.CharSequence charSequence, android.app.PendingIntent pendingIntent, android.os.Bundle bundle, android.support.v4.app.RemoteInput[] remoteInputArr, boolean z) {
                this.mAllowGeneratedReplies = true;
                this.mIcon = i;
                this.mTitle = android.support.v4.app.NotificationCompat.Builder.limitCharSequenceLength(charSequence);
                this.mIntent = pendingIntent;
                this.mExtras = bundle;
                this.mRemoteInputs = remoteInputArr == null ? null : new java.util.ArrayList<>(java.util.Arrays.asList(remoteInputArr));
                this.mAllowGeneratedReplies = z;
            }

            public Builder(android.support.v4.app.NotificationCompat.Action action) {
                this(action.icon, action.title, action.actionIntent, new android.os.Bundle(action.mExtras), action.getRemoteInputs(), action.getAllowGeneratedReplies());
            }

            public android.support.v4.app.NotificationCompat.Action.Builder addExtras(android.os.Bundle bundle) {
                if (bundle != null) {
                    this.mExtras.putAll(bundle);
                }
                return this;
            }

            public android.support.v4.app.NotificationCompat.Action.Builder addRemoteInput(android.support.v4.app.RemoteInput remoteInput) {
                if (this.mRemoteInputs == null) {
                    this.mRemoteInputs = new java.util.ArrayList<>();
                }
                this.mRemoteInputs.add(remoteInput);
                return this;
            }

            public android.support.v4.app.NotificationCompat.Action build() {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                java.util.ArrayList arrayList2 = new java.util.ArrayList();
                java.util.ArrayList<android.support.v4.app.RemoteInput> arrayList3 = this.mRemoteInputs;
                if (arrayList3 != null) {
                    for (android.support.v4.app.RemoteInput remoteInput : arrayList3) {
                        if (remoteInput.isDataOnly()) {
                            arrayList.add(remoteInput);
                        } else {
                            arrayList2.add(remoteInput);
                        }
                    }
                }
                return new android.support.v4.app.NotificationCompat.Action(this.mIcon, this.mTitle, this.mIntent, this.mExtras, arrayList2.isEmpty() ? null : (android.support.v4.app.RemoteInput[]) arrayList2.toArray(new android.support.v4.app.RemoteInput[arrayList2.size()]), arrayList.isEmpty() ? null : (android.support.v4.app.RemoteInput[]) arrayList.toArray(new android.support.v4.app.RemoteInput[arrayList.size()]), this.mAllowGeneratedReplies);
            }

            public android.support.v4.app.NotificationCompat.Action.Builder extend(android.support.v4.app.NotificationCompat.Action.Extender extender) {
                extender.extend(this);
                return this;
            }

            public android.os.Bundle getExtras() {
                return this.mExtras;
            }

            public android.support.v4.app.NotificationCompat.Action.Builder setAllowGeneratedReplies(boolean z) {
                this.mAllowGeneratedReplies = z;
                return this;
            }
        }

        public interface Extender {
            android.support.v4.app.NotificationCompat.Action.Builder extend(android.support.v4.app.NotificationCompat.Action.Builder builder);
        }

        public static final class WearableExtender implements android.support.v4.app.NotificationCompat.Action.Extender {
            private static final int DEFAULT_FLAGS = 1;
            private static final java.lang.String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
            private static final int FLAG_AVAILABLE_OFFLINE = 1;
            private static final int FLAG_HINT_DISPLAY_INLINE = 4;
            private static final int FLAG_HINT_LAUNCHES_ACTIVITY = 2;
            private static final java.lang.String KEY_CANCEL_LABEL = "cancelLabel";
            private static final java.lang.String KEY_CONFIRM_LABEL = "confirmLabel";
            private static final java.lang.String KEY_FLAGS = "flags";
            private static final java.lang.String KEY_IN_PROGRESS_LABEL = "inProgressLabel";
            private java.lang.CharSequence mCancelLabel;
            private java.lang.CharSequence mConfirmLabel;
            private int mFlags;
            private java.lang.CharSequence mInProgressLabel;

            public WearableExtender() {
                this.mFlags = 1;
            }

            public WearableExtender(android.support.v4.app.NotificationCompat.Action action) {
                this.mFlags = 1;
                android.os.Bundle bundle = action.getExtras().getBundle(EXTRA_WEARABLE_EXTENSIONS);
                if (bundle != null) {
                    this.mFlags = bundle.getInt(KEY_FLAGS, 1);
                    this.mInProgressLabel = bundle.getCharSequence(KEY_IN_PROGRESS_LABEL);
                    this.mConfirmLabel = bundle.getCharSequence(KEY_CONFIRM_LABEL);
                    this.mCancelLabel = bundle.getCharSequence(KEY_CANCEL_LABEL);
                }
            }

            private void setFlag(int i, boolean z) {
                if (z) {
                    this.mFlags = i | this.mFlags;
                } else {
                    this.mFlags = (i ^ (-1)) & this.mFlags;
                }
            }

            /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
            public android.support.v4.app.NotificationCompat.Action.WearableExtender m0clone() {
                android.support.v4.app.NotificationCompat.Action.WearableExtender wearableExtender = new android.support.v4.app.NotificationCompat.Action.WearableExtender();
                wearableExtender.mFlags = this.mFlags;
                wearableExtender.mInProgressLabel = this.mInProgressLabel;
                wearableExtender.mConfirmLabel = this.mConfirmLabel;
                wearableExtender.mCancelLabel = this.mCancelLabel;
                return wearableExtender;
            }

            @Override // android.support.v4.app.NotificationCompat.Action.Extender
            public android.support.v4.app.NotificationCompat.Action.Builder extend(android.support.v4.app.NotificationCompat.Action.Builder builder) {
                android.os.Bundle bundle = new android.os.Bundle();
                int i = this.mFlags;
                if (i != 1) {
                    bundle.putInt(KEY_FLAGS, i);
                }
                java.lang.CharSequence charSequence = this.mInProgressLabel;
                if (charSequence != null) {
                    bundle.putCharSequence(KEY_IN_PROGRESS_LABEL, charSequence);
                }
                java.lang.CharSequence charSequence2 = this.mConfirmLabel;
                if (charSequence2 != null) {
                    bundle.putCharSequence(KEY_CONFIRM_LABEL, charSequence2);
                }
                java.lang.CharSequence charSequence3 = this.mCancelLabel;
                if (charSequence3 != null) {
                    bundle.putCharSequence(KEY_CANCEL_LABEL, charSequence3);
                }
                builder.getExtras().putBundle(EXTRA_WEARABLE_EXTENSIONS, bundle);
                return builder;
            }

            public java.lang.CharSequence getCancelLabel() {
                return this.mCancelLabel;
            }

            public java.lang.CharSequence getConfirmLabel() {
                return this.mConfirmLabel;
            }

            public boolean getHintDisplayActionInline() {
                return (this.mFlags & 4) != 0;
            }

            public boolean getHintLaunchesActivity() {
                return (this.mFlags & 2) != 0;
            }

            public java.lang.CharSequence getInProgressLabel() {
                return this.mInProgressLabel;
            }

            public boolean isAvailableOffline() {
                return (this.mFlags & 1) != 0;
            }

            public android.support.v4.app.NotificationCompat.Action.WearableExtender setAvailableOffline(boolean z) {
                setFlag(1, z);
                return this;
            }

            public android.support.v4.app.NotificationCompat.Action.WearableExtender setCancelLabel(java.lang.CharSequence charSequence) {
                this.mCancelLabel = charSequence;
                return this;
            }

            public android.support.v4.app.NotificationCompat.Action.WearableExtender setConfirmLabel(java.lang.CharSequence charSequence) {
                this.mConfirmLabel = charSequence;
                return this;
            }

            public android.support.v4.app.NotificationCompat.Action.WearableExtender setHintDisplayActionInline(boolean z) {
                setFlag(4, z);
                return this;
            }

            public android.support.v4.app.NotificationCompat.Action.WearableExtender setHintLaunchesActivity(boolean z) {
                setFlag(2, z);
                return this;
            }

            public android.support.v4.app.NotificationCompat.Action.WearableExtender setInProgressLabel(java.lang.CharSequence charSequence) {
                this.mInProgressLabel = charSequence;
                return this;
            }
        }

        public Action(int i, java.lang.CharSequence charSequence, android.app.PendingIntent pendingIntent) {
            this(i, charSequence, pendingIntent, new android.os.Bundle(), null, null, true);
        }

        Action(int i, java.lang.CharSequence charSequence, android.app.PendingIntent pendingIntent, android.os.Bundle bundle, android.support.v4.app.RemoteInput[] remoteInputArr, android.support.v4.app.RemoteInput[] remoteInputArr2, boolean z) {
            this.icon = i;
            this.title = android.support.v4.app.NotificationCompat.Builder.limitCharSequenceLength(charSequence);
            this.actionIntent = pendingIntent;
            this.mExtras = bundle == null ? new android.os.Bundle() : bundle;
            this.mRemoteInputs = remoteInputArr;
            this.mDataOnlyRemoteInputs = remoteInputArr2;
            this.mAllowGeneratedReplies = z;
        }

        @Override // android.support.v4.app.NotificationCompatBase.Action
        public android.app.PendingIntent getActionIntent() {
            return this.actionIntent;
        }

        @Override // android.support.v4.app.NotificationCompatBase.Action
        public boolean getAllowGeneratedReplies() {
            return this.mAllowGeneratedReplies;
        }

        @Override // android.support.v4.app.NotificationCompatBase.Action
        public android.support.v4.app.RemoteInput[] getDataOnlyRemoteInputs() {
            return this.mDataOnlyRemoteInputs;
        }

        @Override // android.support.v4.app.NotificationCompatBase.Action
        public android.os.Bundle getExtras() {
            return this.mExtras;
        }

        @Override // android.support.v4.app.NotificationCompatBase.Action
        public int getIcon() {
            return this.icon;
        }

        @Override // android.support.v4.app.NotificationCompatBase.Action
        public android.support.v4.app.RemoteInput[] getRemoteInputs() {
            return this.mRemoteInputs;
        }

        @Override // android.support.v4.app.NotificationCompatBase.Action
        public java.lang.CharSequence getTitle() {
            return this.title;
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface BadgeIconType {
    }

    public static class BigPictureStyle extends android.support.v4.app.NotificationCompat.Style {
        private android.graphics.Bitmap mBigLargeIcon;
        private boolean mBigLargeIconSet;
        private android.graphics.Bitmap mPicture;

        public BigPictureStyle() {
        }

        public BigPictureStyle(android.support.v4.app.NotificationCompat.Builder builder) {
            setBuilder(builder);
        }

        @Override // android.support.v4.app.NotificationCompat.Style
        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public void apply(android.support.v4.app.NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (android.os.Build.VERSION.SDK_INT >= 16) {
                android.support.v4.app.NotificationCompatJellybean.addBigPictureStyle(notificationBuilderWithBuilderAccessor, this.mBigContentTitle, this.mSummaryTextSet, this.mSummaryText, this.mPicture, this.mBigLargeIcon, this.mBigLargeIconSet);
            }
        }

        public android.support.v4.app.NotificationCompat.BigPictureStyle bigLargeIcon(android.graphics.Bitmap bitmap) {
            this.mBigLargeIcon = bitmap;
            this.mBigLargeIconSet = true;
            return this;
        }

        public android.support.v4.app.NotificationCompat.BigPictureStyle bigPicture(android.graphics.Bitmap bitmap) {
            this.mPicture = bitmap;
            return this;
        }

        public android.support.v4.app.NotificationCompat.BigPictureStyle setBigContentTitle(java.lang.CharSequence charSequence) {
            this.mBigContentTitle = android.support.v4.app.NotificationCompat.Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        public android.support.v4.app.NotificationCompat.BigPictureStyle setSummaryText(java.lang.CharSequence charSequence) {
            this.mSummaryText = android.support.v4.app.NotificationCompat.Builder.limitCharSequenceLength(charSequence);
            this.mSummaryTextSet = true;
            return this;
        }
    }

    public static class BigTextStyle extends android.support.v4.app.NotificationCompat.Style {
        private java.lang.CharSequence mBigText;

        public BigTextStyle() {
        }

        public BigTextStyle(android.support.v4.app.NotificationCompat.Builder builder) {
            setBuilder(builder);
        }

        @Override // android.support.v4.app.NotificationCompat.Style
        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public void apply(android.support.v4.app.NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (android.os.Build.VERSION.SDK_INT >= 16) {
                android.support.v4.app.NotificationCompatJellybean.addBigTextStyle(notificationBuilderWithBuilderAccessor, this.mBigContentTitle, this.mSummaryTextSet, this.mSummaryText, this.mBigText);
            }
        }

        public android.support.v4.app.NotificationCompat.BigTextStyle bigText(java.lang.CharSequence charSequence) {
            this.mBigText = android.support.v4.app.NotificationCompat.Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        public android.support.v4.app.NotificationCompat.BigTextStyle setBigContentTitle(java.lang.CharSequence charSequence) {
            this.mBigContentTitle = android.support.v4.app.NotificationCompat.Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        public android.support.v4.app.NotificationCompat.BigTextStyle setSummaryText(java.lang.CharSequence charSequence) {
            this.mSummaryText = android.support.v4.app.NotificationCompat.Builder.limitCharSequenceLength(charSequence);
            this.mSummaryTextSet = true;
            return this;
        }
    }

    public static class Builder {
        private static final int MAX_CHARSEQUENCE_LENGTH = 5120;

        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public java.util.ArrayList<android.support.v4.app.NotificationCompat.Action> mActions;
        int mBadgeIcon;
        android.widget.RemoteViews mBigContentView;
        java.lang.String mCategory;
        java.lang.String mChannelId;
        int mColor;
        boolean mColorized;
        boolean mColorizedSet;

        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public java.lang.CharSequence mContentInfo;
        android.app.PendingIntent mContentIntent;

        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public java.lang.CharSequence mContentText;

        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public java.lang.CharSequence mContentTitle;
        android.widget.RemoteViews mContentView;

        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public android.content.Context mContext;
        android.os.Bundle mExtras;
        android.app.PendingIntent mFullScreenIntent;
        private int mGroupAlertBehavior;
        java.lang.String mGroupKey;
        boolean mGroupSummary;
        android.widget.RemoteViews mHeadsUpContentView;

        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public android.graphics.Bitmap mLargeIcon;
        boolean mLocalOnly;

        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public android.app.Notification mNotification;

        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public int mNumber;
        public java.util.ArrayList<java.lang.String> mPeople;
        int mPriority;
        int mProgress;
        boolean mProgressIndeterminate;
        int mProgressMax;
        android.app.Notification mPublicVersion;

        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public java.lang.CharSequence[] mRemoteInputHistory;
        java.lang.String mShortcutId;
        boolean mShowWhen;
        java.lang.String mSortKey;

        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public android.support.v4.app.NotificationCompat.Style mStyle;

        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public java.lang.CharSequence mSubText;
        android.widget.RemoteViews mTickerView;
        long mTimeout;

        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public boolean mUseChronometer;
        int mVisibility;

        @java.lang.Deprecated
        public Builder(android.content.Context context) {
            this(context, null);
        }

        public Builder(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.NonNull java.lang.String str) {
            this.mShowWhen = true;
            this.mActions = new java.util.ArrayList<>();
            this.mLocalOnly = false;
            this.mColor = 0;
            this.mVisibility = 0;
            this.mBadgeIcon = 0;
            this.mGroupAlertBehavior = 0;
            this.mNotification = new android.app.Notification();
            this.mContext = context;
            this.mChannelId = str;
            this.mNotification.when = java.lang.System.currentTimeMillis();
            this.mNotification.audioStreamType = -1;
            this.mPriority = 0;
            this.mPeople = new java.util.ArrayList<>();
        }

        protected static java.lang.CharSequence limitCharSequenceLength(java.lang.CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > MAX_CHARSEQUENCE_LENGTH) ? charSequence.subSequence(0, MAX_CHARSEQUENCE_LENGTH) : charSequence;
        }

        private void setFlag(int i, boolean z) {
            if (z) {
                android.app.Notification notification = this.mNotification;
                notification.flags = i | notification.flags;
            } else {
                android.app.Notification notification2 = this.mNotification;
                notification2.flags = (i ^ (-1)) & notification2.flags;
            }
        }

        public android.support.v4.app.NotificationCompat.Builder addAction(int i, java.lang.CharSequence charSequence, android.app.PendingIntent pendingIntent) {
            this.mActions.add(new android.support.v4.app.NotificationCompat.Action(i, charSequence, pendingIntent));
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder addAction(android.support.v4.app.NotificationCompat.Action action) {
            this.mActions.add(action);
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder addExtras(android.os.Bundle bundle) {
            if (bundle != null) {
                android.os.Bundle bundle2 = this.mExtras;
                if (bundle2 == null) {
                    this.mExtras = new android.os.Bundle(bundle);
                } else {
                    bundle2.putAll(bundle);
                }
            }
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder addPerson(java.lang.String str) {
            this.mPeople.add(str);
            return this;
        }

        public android.app.Notification build() {
            return android.support.v4.app.NotificationCompat.IMPL.build(this, getExtender());
        }

        public android.support.v4.app.NotificationCompat.Builder extend(android.support.v4.app.NotificationCompat.Extender extender) {
            extender.extend(this);
            return this;
        }

        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public android.widget.RemoteViews getBigContentView() {
            return this.mBigContentView;
        }

        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public int getColor() {
            return this.mColor;
        }

        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public android.widget.RemoteViews getContentView() {
            return this.mContentView;
        }

        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        protected android.support.v4.app.NotificationCompat.BuilderExtender getExtender() {
            return new android.support.v4.app.NotificationCompat.BuilderExtender();
        }

        public android.os.Bundle getExtras() {
            if (this.mExtras == null) {
                this.mExtras = new android.os.Bundle();
            }
            return this.mExtras;
        }

        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public android.widget.RemoteViews getHeadsUpContentView() {
            return this.mHeadsUpContentView;
        }

        @java.lang.Deprecated
        public android.app.Notification getNotification() {
            return build();
        }

        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public int getPriority() {
            return this.mPriority;
        }

        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public long getWhenIfShowing() {
            if (this.mShowWhen) {
                return this.mNotification.when;
            }
            return 0L;
        }

        public android.support.v4.app.NotificationCompat.Builder setAutoCancel(boolean z) {
            setFlag(16, z);
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder setBadgeIconType(int i) {
            this.mBadgeIcon = i;
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder setCategory(java.lang.String str) {
            this.mCategory = str;
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder setChannelId(@android.support.annotation.NonNull java.lang.String str) {
            this.mChannelId = str;
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder setColor(@android.support.annotation.ColorInt int i) {
            this.mColor = i;
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder setColorized(boolean z) {
            this.mColorized = z;
            this.mColorizedSet = true;
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder setContent(android.widget.RemoteViews remoteViews) {
            this.mNotification.contentView = remoteViews;
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder setContentInfo(java.lang.CharSequence charSequence) {
            this.mContentInfo = limitCharSequenceLength(charSequence);
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder setContentIntent(android.app.PendingIntent pendingIntent) {
            this.mContentIntent = pendingIntent;
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder setContentText(java.lang.CharSequence charSequence) {
            this.mContentText = limitCharSequenceLength(charSequence);
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder setContentTitle(java.lang.CharSequence charSequence) {
            this.mContentTitle = limitCharSequenceLength(charSequence);
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder setCustomBigContentView(android.widget.RemoteViews remoteViews) {
            this.mBigContentView = remoteViews;
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder setCustomContentView(android.widget.RemoteViews remoteViews) {
            this.mContentView = remoteViews;
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder setCustomHeadsUpContentView(android.widget.RemoteViews remoteViews) {
            this.mHeadsUpContentView = remoteViews;
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder setDefaults(int i) {
            android.app.Notification notification = this.mNotification;
            notification.defaults = i;
            if ((i & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder setDeleteIntent(android.app.PendingIntent pendingIntent) {
            this.mNotification.deleteIntent = pendingIntent;
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder setExtras(android.os.Bundle bundle) {
            this.mExtras = bundle;
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder setFullScreenIntent(android.app.PendingIntent pendingIntent, boolean z) {
            this.mFullScreenIntent = pendingIntent;
            setFlag(128, z);
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder setGroup(java.lang.String str) {
            this.mGroupKey = str;
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder setGroupAlertBehavior(int i) {
            this.mGroupAlertBehavior = i;
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder setGroupSummary(boolean z) {
            this.mGroupSummary = z;
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder setLargeIcon(android.graphics.Bitmap bitmap) {
            this.mLargeIcon = bitmap;
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder setLights(@android.support.annotation.ColorInt int i, int i2, int i3) {
            android.app.Notification notification = this.mNotification;
            notification.ledARGB = i;
            notification.ledOnMS = i2;
            notification.ledOffMS = i3;
            int i4 = (notification.ledOnMS == 0 || this.mNotification.ledOffMS == 0) ? 0 : 1;
            android.app.Notification notification2 = this.mNotification;
            notification2.flags = i4 | (notification2.flags & (-2));
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder setLocalOnly(boolean z) {
            this.mLocalOnly = z;
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder setNumber(int i) {
            this.mNumber = i;
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder setOngoing(boolean z) {
            setFlag(2, z);
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder setOnlyAlertOnce(boolean z) {
            setFlag(8, z);
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder setPriority(int i) {
            this.mPriority = i;
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder setProgress(int i, int i2, boolean z) {
            this.mProgressMax = i;
            this.mProgress = i2;
            this.mProgressIndeterminate = z;
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder setPublicVersion(android.app.Notification notification) {
            this.mPublicVersion = notification;
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder setRemoteInputHistory(java.lang.CharSequence[] charSequenceArr) {
            this.mRemoteInputHistory = charSequenceArr;
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder setShortcutId(java.lang.String str) {
            this.mShortcutId = str;
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder setShowWhen(boolean z) {
            this.mShowWhen = z;
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder setSmallIcon(int i) {
            this.mNotification.icon = i;
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder setSmallIcon(int i, int i2) {
            android.app.Notification notification = this.mNotification;
            notification.icon = i;
            notification.iconLevel = i2;
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder setSortKey(java.lang.String str) {
            this.mSortKey = str;
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder setSound(android.net.Uri uri) {
            android.app.Notification notification = this.mNotification;
            notification.sound = uri;
            notification.audioStreamType = -1;
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder setSound(android.net.Uri uri, int i) {
            android.app.Notification notification = this.mNotification;
            notification.sound = uri;
            notification.audioStreamType = i;
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder setStyle(android.support.v4.app.NotificationCompat.Style style) {
            if (this.mStyle != style) {
                this.mStyle = style;
                android.support.v4.app.NotificationCompat.Style style2 = this.mStyle;
                if (style2 != null) {
                    style2.setBuilder(this);
                }
            }
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder setSubText(java.lang.CharSequence charSequence) {
            this.mSubText = limitCharSequenceLength(charSequence);
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder setTicker(java.lang.CharSequence charSequence) {
            this.mNotification.tickerText = limitCharSequenceLength(charSequence);
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder setTicker(java.lang.CharSequence charSequence, android.widget.RemoteViews remoteViews) {
            this.mNotification.tickerText = limitCharSequenceLength(charSequence);
            this.mTickerView = remoteViews;
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder setTimeoutAfter(long j) {
            this.mTimeout = j;
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder setUsesChronometer(boolean z) {
            this.mUseChronometer = z;
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder setVibrate(long[] jArr) {
            this.mNotification.vibrate = jArr;
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder setVisibility(int i) {
            this.mVisibility = i;
            return this;
        }

        public android.support.v4.app.NotificationCompat.Builder setWhen(long j) {
            this.mNotification.when = j;
            return this;
        }
    }

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    protected static class BuilderExtender {
        protected BuilderExtender() {
        }

        public android.app.Notification build(android.support.v4.app.NotificationCompat.Builder builder, android.support.v4.app.NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            android.widget.RemoteViews remoteViewsMakeHeadsUpContentView;
            android.widget.RemoteViews remoteViewsMakeBigContentView;
            android.widget.RemoteViews remoteViewsMakeContentView = builder.mStyle != null ? builder.mStyle.makeContentView(notificationBuilderWithBuilderAccessor) : null;
            android.app.Notification notificationBuild = notificationBuilderWithBuilderAccessor.build();
            if (remoteViewsMakeContentView != null) {
                notificationBuild.contentView = remoteViewsMakeContentView;
            } else if (builder.mContentView != null) {
                notificationBuild.contentView = builder.mContentView;
            }
            if (android.os.Build.VERSION.SDK_INT >= 16 && builder.mStyle != null && (remoteViewsMakeBigContentView = builder.mStyle.makeBigContentView(notificationBuilderWithBuilderAccessor)) != null) {
                notificationBuild.bigContentView = remoteViewsMakeBigContentView;
            }
            if (android.os.Build.VERSION.SDK_INT >= 21 && builder.mStyle != null && (remoteViewsMakeHeadsUpContentView = builder.mStyle.makeHeadsUpContentView(notificationBuilderWithBuilderAccessor)) != null) {
                notificationBuild.headsUpContentView = remoteViewsMakeHeadsUpContentView;
            }
            return notificationBuild;
        }
    }

    public static final class CarExtender implements android.support.v4.app.NotificationCompat.Extender {
        private static final java.lang.String EXTRA_CAR_EXTENDER = "android.car.EXTENSIONS";
        private static final java.lang.String EXTRA_COLOR = "app_color";
        private static final java.lang.String EXTRA_CONVERSATION = "car_conversation";
        private static final java.lang.String EXTRA_LARGE_ICON = "large_icon";
        private static final java.lang.String TAG = "CarExtender";
        private int mColor;
        private android.graphics.Bitmap mLargeIcon;
        private android.support.v4.app.NotificationCompat.CarExtender.UnreadConversation mUnreadConversation;

        public static class UnreadConversation extends android.support.v4.app.NotificationCompatBase.UnreadConversation {
            static final android.support.v4.app.NotificationCompatBase.UnreadConversation.Factory FACTORY = new android.support.v4.app.NotificationCompatBase.UnreadConversation.Factory() { // from class: android.support.v4.app.NotificationCompat.CarExtender.UnreadConversation.1
                @Override // android.support.v4.app.NotificationCompatBase.UnreadConversation.Factory
                public android.support.v4.app.NotificationCompat.CarExtender.UnreadConversation build(java.lang.String[] strArr, android.support.v4.app.RemoteInputCompatBase.RemoteInput remoteInput, android.app.PendingIntent pendingIntent, android.app.PendingIntent pendingIntent2, java.lang.String[] strArr2, long j) {
                    return new android.support.v4.app.NotificationCompat.CarExtender.UnreadConversation(strArr, (android.support.v4.app.RemoteInput) remoteInput, pendingIntent, pendingIntent2, strArr2, j);
                }
            };
            private final long mLatestTimestamp;
            private final java.lang.String[] mMessages;
            private final java.lang.String[] mParticipants;
            private final android.app.PendingIntent mReadPendingIntent;
            private final android.support.v4.app.RemoteInput mRemoteInput;
            private final android.app.PendingIntent mReplyPendingIntent;

            public static class Builder {
                private long mLatestTimestamp;
                private final java.util.List<java.lang.String> mMessages = new java.util.ArrayList();
                private final java.lang.String mParticipant;
                private android.app.PendingIntent mReadPendingIntent;
                private android.support.v4.app.RemoteInput mRemoteInput;
                private android.app.PendingIntent mReplyPendingIntent;

                public Builder(java.lang.String str) {
                    this.mParticipant = str;
                }

                public android.support.v4.app.NotificationCompat.CarExtender.UnreadConversation.Builder addMessage(java.lang.String str) {
                    this.mMessages.add(str);
                    return this;
                }

                public android.support.v4.app.NotificationCompat.CarExtender.UnreadConversation build() {
                    java.util.List<java.lang.String> list = this.mMessages;
                    return new android.support.v4.app.NotificationCompat.CarExtender.UnreadConversation((java.lang.String[]) list.toArray(new java.lang.String[list.size()]), this.mRemoteInput, this.mReplyPendingIntent, this.mReadPendingIntent, new java.lang.String[]{this.mParticipant}, this.mLatestTimestamp);
                }

                public android.support.v4.app.NotificationCompat.CarExtender.UnreadConversation.Builder setLatestTimestamp(long j) {
                    this.mLatestTimestamp = j;
                    return this;
                }

                public android.support.v4.app.NotificationCompat.CarExtender.UnreadConversation.Builder setReadPendingIntent(android.app.PendingIntent pendingIntent) {
                    this.mReadPendingIntent = pendingIntent;
                    return this;
                }

                public android.support.v4.app.NotificationCompat.CarExtender.UnreadConversation.Builder setReplyAction(android.app.PendingIntent pendingIntent, android.support.v4.app.RemoteInput remoteInput) {
                    this.mRemoteInput = remoteInput;
                    this.mReplyPendingIntent = pendingIntent;
                    return this;
                }
            }

            UnreadConversation(java.lang.String[] strArr, android.support.v4.app.RemoteInput remoteInput, android.app.PendingIntent pendingIntent, android.app.PendingIntent pendingIntent2, java.lang.String[] strArr2, long j) {
                this.mMessages = strArr;
                this.mRemoteInput = remoteInput;
                this.mReadPendingIntent = pendingIntent2;
                this.mReplyPendingIntent = pendingIntent;
                this.mParticipants = strArr2;
                this.mLatestTimestamp = j;
            }

            @Override // android.support.v4.app.NotificationCompatBase.UnreadConversation
            public long getLatestTimestamp() {
                return this.mLatestTimestamp;
            }

            @Override // android.support.v4.app.NotificationCompatBase.UnreadConversation
            public java.lang.String[] getMessages() {
                return this.mMessages;
            }

            @Override // android.support.v4.app.NotificationCompatBase.UnreadConversation
            public java.lang.String getParticipant() {
                java.lang.String[] strArr = this.mParticipants;
                if (strArr.length > 0) {
                    return strArr[0];
                }
                return null;
            }

            @Override // android.support.v4.app.NotificationCompatBase.UnreadConversation
            public java.lang.String[] getParticipants() {
                return this.mParticipants;
            }

            @Override // android.support.v4.app.NotificationCompatBase.UnreadConversation
            public android.app.PendingIntent getReadPendingIntent() {
                return this.mReadPendingIntent;
            }

            @Override // android.support.v4.app.NotificationCompatBase.UnreadConversation
            public android.support.v4.app.RemoteInput getRemoteInput() {
                return this.mRemoteInput;
            }

            @Override // android.support.v4.app.NotificationCompatBase.UnreadConversation
            public android.app.PendingIntent getReplyPendingIntent() {
                return this.mReplyPendingIntent;
            }
        }

        public CarExtender() {
            this.mColor = 0;
        }

        public CarExtender(android.app.Notification notification) {
            this.mColor = 0;
            if (android.os.Build.VERSION.SDK_INT < 21) {
                return;
            }
            android.os.Bundle bundle = android.support.v4.app.NotificationCompat.getExtras(notification) == null ? null : android.support.v4.app.NotificationCompat.getExtras(notification).getBundle(EXTRA_CAR_EXTENDER);
            if (bundle != null) {
                this.mLargeIcon = (android.graphics.Bitmap) bundle.getParcelable(EXTRA_LARGE_ICON);
                this.mColor = bundle.getInt(EXTRA_COLOR, 0);
                this.mUnreadConversation = (android.support.v4.app.NotificationCompat.CarExtender.UnreadConversation) android.support.v4.app.NotificationCompat.IMPL.getUnreadConversationFromBundle(bundle.getBundle(EXTRA_CONVERSATION), android.support.v4.app.NotificationCompat.CarExtender.UnreadConversation.FACTORY, android.support.v4.app.RemoteInput.FACTORY);
            }
        }

        @Override // android.support.v4.app.NotificationCompat.Extender
        public android.support.v4.app.NotificationCompat.Builder extend(android.support.v4.app.NotificationCompat.Builder builder) {
            if (android.os.Build.VERSION.SDK_INT < 21) {
                return builder;
            }
            android.os.Bundle bundle = new android.os.Bundle();
            android.graphics.Bitmap bitmap = this.mLargeIcon;
            if (bitmap != null) {
                bundle.putParcelable(EXTRA_LARGE_ICON, bitmap);
            }
            int i = this.mColor;
            if (i != 0) {
                bundle.putInt(EXTRA_COLOR, i);
            }
            if (this.mUnreadConversation != null) {
                bundle.putBundle(EXTRA_CONVERSATION, android.support.v4.app.NotificationCompat.IMPL.getBundleForUnreadConversation(this.mUnreadConversation));
            }
            builder.getExtras().putBundle(EXTRA_CAR_EXTENDER, bundle);
            return builder;
        }

        @android.support.annotation.ColorInt
        public int getColor() {
            return this.mColor;
        }

        public android.graphics.Bitmap getLargeIcon() {
            return this.mLargeIcon;
        }

        public android.support.v4.app.NotificationCompat.CarExtender.UnreadConversation getUnreadConversation() {
            return this.mUnreadConversation;
        }

        public android.support.v4.app.NotificationCompat.CarExtender setColor(@android.support.annotation.ColorInt int i) {
            this.mColor = i;
            return this;
        }

        public android.support.v4.app.NotificationCompat.CarExtender setLargeIcon(android.graphics.Bitmap bitmap) {
            this.mLargeIcon = bitmap;
            return this;
        }

        public android.support.v4.app.NotificationCompat.CarExtender setUnreadConversation(android.support.v4.app.NotificationCompat.CarExtender.UnreadConversation unreadConversation) {
            this.mUnreadConversation = unreadConversation;
            return this;
        }
    }

    public static class DecoratedCustomViewStyle extends android.support.v4.app.NotificationCompat.Style {
        private static final int MAX_ACTION_BUTTONS = 3;

        private android.widget.RemoteViews createRemoteViews(android.widget.RemoteViews remoteViews, boolean z) {
            int iMin;
            boolean z2 = true;
            android.widget.RemoteViews remoteViewsApplyStandardTemplate = applyStandardTemplate(true, android.support.compat.R.layout.notification_template_custom_big, false);
            remoteViewsApplyStandardTemplate.removeAllViews(android.support.compat.R.id.actions);
            if (!z || this.mBuilder.mActions == null || (iMin = java.lang.Math.min(this.mBuilder.mActions.size(), 3)) <= 0) {
                z2 = false;
            } else {
                for (int i = 0; i < iMin; i++) {
                    remoteViewsApplyStandardTemplate.addView(android.support.compat.R.id.actions, generateActionButton(this.mBuilder.mActions.get(i)));
                }
            }
            int i2 = z2 ? 0 : 8;
            remoteViewsApplyStandardTemplate.setViewVisibility(android.support.compat.R.id.actions, i2);
            remoteViewsApplyStandardTemplate.setViewVisibility(android.support.compat.R.id.action_divider, i2);
            buildIntoRemoteViews(remoteViewsApplyStandardTemplate, remoteViews);
            return remoteViewsApplyStandardTemplate;
        }

        private android.widget.RemoteViews generateActionButton(android.support.v4.app.NotificationCompat.Action action) {
            boolean z = action.actionIntent == null;
            android.widget.RemoteViews remoteViews = new android.widget.RemoteViews(this.mBuilder.mContext.getPackageName(), z ? android.support.compat.R.layout.notification_action_tombstone : android.support.compat.R.layout.notification_action);
            remoteViews.setImageViewBitmap(android.support.compat.R.id.action_image, createColoredBitmap(action.getIcon(), this.mBuilder.mContext.getResources().getColor(android.support.compat.R.color.notification_action_color_filter)));
            remoteViews.setTextViewText(android.support.compat.R.id.action_text, action.title);
            if (!z) {
                remoteViews.setOnClickPendingIntent(android.support.compat.R.id.action_container, action.actionIntent);
            }
            if (android.os.Build.VERSION.SDK_INT >= 15) {
                remoteViews.setContentDescription(android.support.compat.R.id.action_container, action.title);
            }
            return remoteViews;
        }

        @Override // android.support.v4.app.NotificationCompat.Style
        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public void apply(android.support.v4.app.NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (android.os.Build.VERSION.SDK_INT >= 24) {
                notificationBuilderWithBuilderAccessor.getBuilder().setStyle(new android.app.Notification.DecoratedCustomViewStyle());
            }
        }

        @Override // android.support.v4.app.NotificationCompat.Style
        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public android.widget.RemoteViews makeBigContentView(android.support.v4.app.NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (android.os.Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            android.widget.RemoteViews bigContentView = this.mBuilder.getBigContentView();
            if (bigContentView == null) {
                bigContentView = this.mBuilder.getContentView();
            }
            if (bigContentView == null) {
                return null;
            }
            return createRemoteViews(bigContentView, true);
        }

        @Override // android.support.v4.app.NotificationCompat.Style
        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public android.widget.RemoteViews makeContentView(android.support.v4.app.NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (android.os.Build.VERSION.SDK_INT < 24 && this.mBuilder.getContentView() != null) {
                return createRemoteViews(this.mBuilder.getContentView(), false);
            }
            return null;
        }

        @Override // android.support.v4.app.NotificationCompat.Style
        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public android.widget.RemoteViews makeHeadsUpContentView(android.support.v4.app.NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (android.os.Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            android.widget.RemoteViews headsUpContentView = this.mBuilder.getHeadsUpContentView();
            android.widget.RemoteViews contentView = headsUpContentView != null ? headsUpContentView : this.mBuilder.getContentView();
            if (headsUpContentView == null) {
                return null;
            }
            return createRemoteViews(contentView, true);
        }
    }

    public interface Extender {
        android.support.v4.app.NotificationCompat.Builder extend(android.support.v4.app.NotificationCompat.Builder builder);
    }

    public static class InboxStyle extends android.support.v4.app.NotificationCompat.Style {
        private java.util.ArrayList<java.lang.CharSequence> mTexts = new java.util.ArrayList<>();

        public InboxStyle() {
        }

        public InboxStyle(android.support.v4.app.NotificationCompat.Builder builder) {
            setBuilder(builder);
        }

        public android.support.v4.app.NotificationCompat.InboxStyle addLine(java.lang.CharSequence charSequence) {
            this.mTexts.add(android.support.v4.app.NotificationCompat.Builder.limitCharSequenceLength(charSequence));
            return this;
        }

        @Override // android.support.v4.app.NotificationCompat.Style
        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public void apply(android.support.v4.app.NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (android.os.Build.VERSION.SDK_INT >= 16) {
                android.support.v4.app.NotificationCompatJellybean.addInboxStyle(notificationBuilderWithBuilderAccessor, this.mBigContentTitle, this.mSummaryTextSet, this.mSummaryText, this.mTexts);
            }
        }

        public android.support.v4.app.NotificationCompat.InboxStyle setBigContentTitle(java.lang.CharSequence charSequence) {
            this.mBigContentTitle = android.support.v4.app.NotificationCompat.Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        public android.support.v4.app.NotificationCompat.InboxStyle setSummaryText(java.lang.CharSequence charSequence) {
            this.mSummaryText = android.support.v4.app.NotificationCompat.Builder.limitCharSequenceLength(charSequence);
            this.mSummaryTextSet = true;
            return this;
        }
    }

    public static class MessagingStyle extends android.support.v4.app.NotificationCompat.Style {
        public static final int MAXIMUM_RETAINED_MESSAGES = 25;
        java.lang.CharSequence mConversationTitle;
        java.util.List<android.support.v4.app.NotificationCompat.MessagingStyle.Message> mMessages = new java.util.ArrayList();
        java.lang.CharSequence mUserDisplayName;

        public static final class Message {
            static final java.lang.String KEY_DATA_MIME_TYPE = "type";
            static final java.lang.String KEY_DATA_URI = "uri";
            static final java.lang.String KEY_EXTRAS_BUNDLE = "extras";
            static final java.lang.String KEY_SENDER = "sender";
            static final java.lang.String KEY_TEXT = "text";
            static final java.lang.String KEY_TIMESTAMP = "time";
            private java.lang.String mDataMimeType;
            private android.net.Uri mDataUri;
            private android.os.Bundle mExtras = new android.os.Bundle();
            private final java.lang.CharSequence mSender;
            private final java.lang.CharSequence mText;
            private final long mTimestamp;

            public Message(java.lang.CharSequence charSequence, long j, java.lang.CharSequence charSequence2) {
                this.mText = charSequence;
                this.mTimestamp = j;
                this.mSender = charSequence2;
            }

            static android.os.Bundle[] getBundleArrayForMessages(java.util.List<android.support.v4.app.NotificationCompat.MessagingStyle.Message> list) {
                android.os.Bundle[] bundleArr = new android.os.Bundle[list.size()];
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    bundleArr[i] = list.get(i).toBundle();
                }
                return bundleArr;
            }

            static android.support.v4.app.NotificationCompat.MessagingStyle.Message getMessageFromBundle(android.os.Bundle bundle) {
                try {
                    if (bundle.containsKey("text") && bundle.containsKey("time")) {
                        android.support.v4.app.NotificationCompat.MessagingStyle.Message message = new android.support.v4.app.NotificationCompat.MessagingStyle.Message(bundle.getCharSequence("text"), bundle.getLong("time"), bundle.getCharSequence(KEY_SENDER));
                        if (bundle.containsKey("type") && bundle.containsKey("uri")) {
                            message.setData(bundle.getString("type"), (android.net.Uri) bundle.getParcelable("uri"));
                        }
                        if (bundle.containsKey(KEY_EXTRAS_BUNDLE)) {
                            message.getExtras().putAll(bundle.getBundle(KEY_EXTRAS_BUNDLE));
                        }
                        return message;
                    }
                    return null;
                } catch (java.lang.ClassCastException unused) {
                    return null;
                }
            }

            static java.util.List<android.support.v4.app.NotificationCompat.MessagingStyle.Message> getMessagesFromBundleArray(android.os.Parcelable[] parcelableArr) {
                android.support.v4.app.NotificationCompat.MessagingStyle.Message messageFromBundle;
                java.util.ArrayList arrayList = new java.util.ArrayList(parcelableArr.length);
                for (int i = 0; i < parcelableArr.length; i++) {
                    if ((parcelableArr[i] instanceof android.os.Bundle) && (messageFromBundle = getMessageFromBundle((android.os.Bundle) parcelableArr[i])) != null) {
                        arrayList.add(messageFromBundle);
                    }
                }
                return arrayList;
            }

            private android.os.Bundle toBundle() {
                android.os.Bundle bundle = new android.os.Bundle();
                java.lang.CharSequence charSequence = this.mText;
                if (charSequence != null) {
                    bundle.putCharSequence("text", charSequence);
                }
                bundle.putLong("time", this.mTimestamp);
                java.lang.CharSequence charSequence2 = this.mSender;
                if (charSequence2 != null) {
                    bundle.putCharSequence(KEY_SENDER, charSequence2);
                }
                java.lang.String str = this.mDataMimeType;
                if (str != null) {
                    bundle.putString("type", str);
                }
                android.net.Uri uri = this.mDataUri;
                if (uri != null) {
                    bundle.putParcelable("uri", uri);
                }
                android.os.Bundle bundle2 = this.mExtras;
                if (bundle2 != null) {
                    bundle.putBundle(KEY_EXTRAS_BUNDLE, bundle2);
                }
                return bundle;
            }

            public java.lang.String getDataMimeType() {
                return this.mDataMimeType;
            }

            public android.net.Uri getDataUri() {
                return this.mDataUri;
            }

            public android.os.Bundle getExtras() {
                return this.mExtras;
            }

            public java.lang.CharSequence getSender() {
                return this.mSender;
            }

            public java.lang.CharSequence getText() {
                return this.mText;
            }

            public long getTimestamp() {
                return this.mTimestamp;
            }

            public android.support.v4.app.NotificationCompat.MessagingStyle.Message setData(java.lang.String str, android.net.Uri uri) {
                this.mDataMimeType = str;
                this.mDataUri = uri;
                return this;
            }
        }

        MessagingStyle() {
        }

        public MessagingStyle(@android.support.annotation.NonNull java.lang.CharSequence charSequence) {
            this.mUserDisplayName = charSequence;
        }

        public static android.support.v4.app.NotificationCompat.MessagingStyle extractMessagingStyleFromNotification(android.app.Notification notification) {
            android.os.Bundle extras = android.support.v4.app.NotificationCompat.getExtras(notification);
            if (extras != null && !extras.containsKey(android.support.v4.app.NotificationCompat.EXTRA_SELF_DISPLAY_NAME)) {
                return null;
            }
            try {
                android.support.v4.app.NotificationCompat.MessagingStyle messagingStyle = new android.support.v4.app.NotificationCompat.MessagingStyle();
                messagingStyle.restoreFromCompatExtras(extras);
                return messagingStyle;
            } catch (java.lang.ClassCastException unused) {
                return null;
            }
        }

        @android.support.annotation.Nullable
        private android.support.v4.app.NotificationCompat.MessagingStyle.Message findLatestIncomingMessage() {
            for (int size = this.mMessages.size() - 1; size >= 0; size--) {
                android.support.v4.app.NotificationCompat.MessagingStyle.Message message = this.mMessages.get(size);
                if (!android.text.TextUtils.isEmpty(message.getSender())) {
                    return message;
                }
            }
            if (this.mMessages.isEmpty()) {
                return null;
            }
            java.util.List<android.support.v4.app.NotificationCompat.MessagingStyle.Message> list = this.mMessages;
            return list.get(list.size() - 1);
        }

        private boolean hasMessagesWithoutSender() {
            for (int size = this.mMessages.size() - 1; size >= 0; size--) {
                if (this.mMessages.get(size).getSender() == null) {
                    return true;
                }
            }
            return false;
        }

        @android.support.annotation.NonNull
        private android.text.style.TextAppearanceSpan makeFontColorSpan(int i) {
            return new android.text.style.TextAppearanceSpan(null, 0, 0, android.content.res.ColorStateList.valueOf(i), null);
        }

        private java.lang.CharSequence makeMessageLine(android.support.v4.app.NotificationCompat.MessagingStyle.Message message) {
            android.support.v4.text.BidiFormatter bidiFormatter = android.support.v4.text.BidiFormatter.getInstance();
            android.text.SpannableStringBuilder spannableStringBuilder = new android.text.SpannableStringBuilder();
            boolean z = android.os.Build.VERSION.SDK_INT >= 21;
            int color = z ? -16777216 : -1;
            java.lang.CharSequence sender = message.getSender();
            if (android.text.TextUtils.isEmpty(message.getSender())) {
                sender = this.mUserDisplayName;
                if (sender == null) {
                    sender = "";
                }
                if (z && this.mBuilder.getColor() != 0) {
                    color = this.mBuilder.getColor();
                }
            }
            java.lang.CharSequence charSequenceUnicodeWrap = bidiFormatter.unicodeWrap(sender);
            spannableStringBuilder.append(charSequenceUnicodeWrap);
            spannableStringBuilder.setSpan(makeFontColorSpan(color), spannableStringBuilder.length() - charSequenceUnicodeWrap.length(), spannableStringBuilder.length(), 33);
            spannableStringBuilder.append((java.lang.CharSequence) "  ").append(bidiFormatter.unicodeWrap(message.getText() == null ? "" : message.getText()));
            return spannableStringBuilder;
        }

        @Override // android.support.v4.app.NotificationCompat.Style
        public void addCompatExtras(android.os.Bundle bundle) {
            super.addCompatExtras(bundle);
            java.lang.CharSequence charSequence = this.mUserDisplayName;
            if (charSequence != null) {
                bundle.putCharSequence(android.support.v4.app.NotificationCompat.EXTRA_SELF_DISPLAY_NAME, charSequence);
            }
            java.lang.CharSequence charSequence2 = this.mConversationTitle;
            if (charSequence2 != null) {
                bundle.putCharSequence(android.support.v4.app.NotificationCompat.EXTRA_CONVERSATION_TITLE, charSequence2);
            }
            if (this.mMessages.isEmpty()) {
                return;
            }
            bundle.putParcelableArray(android.support.v4.app.NotificationCompat.EXTRA_MESSAGES, android.support.v4.app.NotificationCompat.MessagingStyle.Message.getBundleArrayForMessages(this.mMessages));
        }

        public android.support.v4.app.NotificationCompat.MessagingStyle addMessage(android.support.v4.app.NotificationCompat.MessagingStyle.Message message) {
            this.mMessages.add(message);
            if (this.mMessages.size() > 25) {
                this.mMessages.remove(0);
            }
            return this;
        }

        public android.support.v4.app.NotificationCompat.MessagingStyle addMessage(java.lang.CharSequence charSequence, long j, java.lang.CharSequence charSequence2) {
            this.mMessages.add(new android.support.v4.app.NotificationCompat.MessagingStyle.Message(charSequence, j, charSequence2));
            if (this.mMessages.size() > 25) {
                this.mMessages.remove(0);
            }
            return this;
        }

        @Override // android.support.v4.app.NotificationCompat.Style
        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public void apply(android.support.v4.app.NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (android.os.Build.VERSION.SDK_INT >= 24) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                java.util.ArrayList arrayList2 = new java.util.ArrayList();
                java.util.ArrayList arrayList3 = new java.util.ArrayList();
                java.util.ArrayList arrayList4 = new java.util.ArrayList();
                java.util.ArrayList arrayList5 = new java.util.ArrayList();
                for (android.support.v4.app.NotificationCompat.MessagingStyle.Message message : this.mMessages) {
                    arrayList.add(message.getText());
                    arrayList2.add(java.lang.Long.valueOf(message.getTimestamp()));
                    arrayList3.add(message.getSender());
                    arrayList4.add(message.getDataMimeType());
                    arrayList5.add(message.getDataUri());
                }
                android.support.v4.app.NotificationCompatApi24.addMessagingStyle(notificationBuilderWithBuilderAccessor, this.mUserDisplayName, this.mConversationTitle, arrayList, arrayList2, arrayList3, arrayList4, arrayList5);
                return;
            }
            android.support.v4.app.NotificationCompat.MessagingStyle.Message messageFindLatestIncomingMessage = findLatestIncomingMessage();
            if (this.mConversationTitle != null) {
                notificationBuilderWithBuilderAccessor.getBuilder().setContentTitle(this.mConversationTitle);
            } else if (messageFindLatestIncomingMessage != null) {
                notificationBuilderWithBuilderAccessor.getBuilder().setContentTitle(messageFindLatestIncomingMessage.getSender());
            }
            if (messageFindLatestIncomingMessage != null) {
                notificationBuilderWithBuilderAccessor.getBuilder().setContentText(this.mConversationTitle != null ? makeMessageLine(messageFindLatestIncomingMessage) : messageFindLatestIncomingMessage.getText());
            }
            if (android.os.Build.VERSION.SDK_INT >= 16) {
                android.text.SpannableStringBuilder spannableStringBuilder = new android.text.SpannableStringBuilder();
                boolean z = this.mConversationTitle != null || hasMessagesWithoutSender();
                for (int size = this.mMessages.size() - 1; size >= 0; size--) {
                    android.support.v4.app.NotificationCompat.MessagingStyle.Message message2 = this.mMessages.get(size);
                    java.lang.CharSequence charSequenceMakeMessageLine = z ? makeMessageLine(message2) : message2.getText();
                    if (size != this.mMessages.size() - 1) {
                        spannableStringBuilder.insert(0, (java.lang.CharSequence) "\n");
                    }
                    spannableStringBuilder.insert(0, charSequenceMakeMessageLine);
                }
                android.support.v4.app.NotificationCompatJellybean.addBigTextStyle(notificationBuilderWithBuilderAccessor, null, false, null, spannableStringBuilder);
            }
        }

        public java.lang.CharSequence getConversationTitle() {
            return this.mConversationTitle;
        }

        public java.util.List<android.support.v4.app.NotificationCompat.MessagingStyle.Message> getMessages() {
            return this.mMessages;
        }

        public java.lang.CharSequence getUserDisplayName() {
            return this.mUserDisplayName;
        }

        @Override // android.support.v4.app.NotificationCompat.Style
        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        protected void restoreFromCompatExtras(android.os.Bundle bundle) {
            this.mMessages.clear();
            this.mUserDisplayName = bundle.getString(android.support.v4.app.NotificationCompat.EXTRA_SELF_DISPLAY_NAME);
            this.mConversationTitle = bundle.getString(android.support.v4.app.NotificationCompat.EXTRA_CONVERSATION_TITLE);
            android.os.Parcelable[] parcelableArray = bundle.getParcelableArray(android.support.v4.app.NotificationCompat.EXTRA_MESSAGES);
            if (parcelableArray != null) {
                this.mMessages = android.support.v4.app.NotificationCompat.MessagingStyle.Message.getMessagesFromBundleArray(parcelableArray);
            }
        }

        public android.support.v4.app.NotificationCompat.MessagingStyle setConversationTitle(java.lang.CharSequence charSequence) {
            this.mConversationTitle = charSequence;
            return this;
        }
    }

    @android.support.annotation.RequiresApi(16)
    static class NotificationCompatApi16Impl extends android.support.v4.app.NotificationCompat.NotificationCompatBaseImpl {
        NotificationCompatApi16Impl() {
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatBaseImpl, android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public android.app.Notification build(android.support.v4.app.NotificationCompat.Builder builder, android.support.v4.app.NotificationCompat.BuilderExtender builderExtender) {
            android.os.Bundle extras;
            android.support.v4.app.NotificationCompatJellybean.Builder builder2 = new android.support.v4.app.NotificationCompatJellybean.Builder(builder.mContext, builder.mNotification, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.mTickerView, builder.mNumber, builder.mContentIntent, builder.mFullScreenIntent, builder.mLargeIcon, builder.mProgressMax, builder.mProgress, builder.mProgressIndeterminate, builder.mUseChronometer, builder.mPriority, builder.mSubText, builder.mLocalOnly, builder.mExtras, builder.mGroupKey, builder.mGroupSummary, builder.mSortKey, builder.mContentView, builder.mBigContentView);
            android.support.v4.app.NotificationCompat.addActionsToBuilder(builder2, builder.mActions);
            if (builder.mStyle != null) {
                builder.mStyle.apply(builder2);
            }
            android.app.Notification notificationBuild = builderExtender.build(builder, builder2);
            if (builder.mStyle != null && (extras = android.support.v4.app.NotificationCompat.getExtras(notificationBuild)) != null) {
                builder.mStyle.addCompatExtras(extras);
            }
            return notificationBuild;
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatBaseImpl, android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public android.support.v4.app.NotificationCompat.Action getAction(android.app.Notification notification, int i) {
            return (android.support.v4.app.NotificationCompat.Action) android.support.v4.app.NotificationCompatJellybean.getAction(notification, i, android.support.v4.app.NotificationCompat.Action.FACTORY, android.support.v4.app.RemoteInput.FACTORY);
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatBaseImpl, android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public android.support.v4.app.NotificationCompat.Action[] getActionsFromParcelableArrayList(java.util.ArrayList<android.os.Parcelable> arrayList) {
            return (android.support.v4.app.NotificationCompat.Action[]) android.support.v4.app.NotificationCompatJellybean.getActionsFromParcelableArrayList(arrayList, android.support.v4.app.NotificationCompat.Action.FACTORY, android.support.v4.app.RemoteInput.FACTORY);
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatBaseImpl, android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public java.util.ArrayList<android.os.Parcelable> getParcelableArrayListForActions(android.support.v4.app.NotificationCompat.Action[] actionArr) {
            return android.support.v4.app.NotificationCompatJellybean.getParcelableArrayListForActions(actionArr);
        }
    }

    @android.support.annotation.RequiresApi(19)
    static class NotificationCompatApi19Impl extends android.support.v4.app.NotificationCompat.NotificationCompatApi16Impl {
        NotificationCompatApi19Impl() {
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatApi16Impl, android.support.v4.app.NotificationCompat.NotificationCompatBaseImpl, android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public android.app.Notification build(android.support.v4.app.NotificationCompat.Builder builder, android.support.v4.app.NotificationCompat.BuilderExtender builderExtender) {
            android.support.v4.app.NotificationCompatKitKat.Builder builder2 = new android.support.v4.app.NotificationCompatKitKat.Builder(builder.mContext, builder.mNotification, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.mTickerView, builder.mNumber, builder.mContentIntent, builder.mFullScreenIntent, builder.mLargeIcon, builder.mProgressMax, builder.mProgress, builder.mProgressIndeterminate, builder.mShowWhen, builder.mUseChronometer, builder.mPriority, builder.mSubText, builder.mLocalOnly, builder.mPeople, builder.mExtras, builder.mGroupKey, builder.mGroupSummary, builder.mSortKey, builder.mContentView, builder.mBigContentView);
            android.support.v4.app.NotificationCompat.addActionsToBuilder(builder2, builder.mActions);
            if (builder.mStyle != null) {
                builder.mStyle.apply(builder2);
            }
            return builderExtender.build(builder, builder2);
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatApi16Impl, android.support.v4.app.NotificationCompat.NotificationCompatBaseImpl, android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public android.support.v4.app.NotificationCompat.Action getAction(android.app.Notification notification, int i) {
            return (android.support.v4.app.NotificationCompat.Action) android.support.v4.app.NotificationCompatKitKat.getAction(notification, i, android.support.v4.app.NotificationCompat.Action.FACTORY, android.support.v4.app.RemoteInput.FACTORY);
        }
    }

    @android.support.annotation.RequiresApi(20)
    static class NotificationCompatApi20Impl extends android.support.v4.app.NotificationCompat.NotificationCompatApi19Impl {
        NotificationCompatApi20Impl() {
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatApi19Impl, android.support.v4.app.NotificationCompat.NotificationCompatApi16Impl, android.support.v4.app.NotificationCompat.NotificationCompatBaseImpl, android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public android.app.Notification build(android.support.v4.app.NotificationCompat.Builder builder, android.support.v4.app.NotificationCompat.BuilderExtender builderExtender) {
            android.support.v4.app.NotificationCompatApi20.Builder builder2 = new android.support.v4.app.NotificationCompatApi20.Builder(builder.mContext, builder.mNotification, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.mTickerView, builder.mNumber, builder.mContentIntent, builder.mFullScreenIntent, builder.mLargeIcon, builder.mProgressMax, builder.mProgress, builder.mProgressIndeterminate, builder.mShowWhen, builder.mUseChronometer, builder.mPriority, builder.mSubText, builder.mLocalOnly, builder.mPeople, builder.mExtras, builder.mGroupKey, builder.mGroupSummary, builder.mSortKey, builder.mContentView, builder.mBigContentView, builder.mGroupAlertBehavior);
            android.support.v4.app.NotificationCompat.addActionsToBuilder(builder2, builder.mActions);
            if (builder.mStyle != null) {
                builder.mStyle.apply(builder2);
            }
            android.app.Notification notificationBuild = builderExtender.build(builder, builder2);
            if (builder.mStyle != null) {
                builder.mStyle.addCompatExtras(android.support.v4.app.NotificationCompat.getExtras(notificationBuild));
            }
            return notificationBuild;
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatApi19Impl, android.support.v4.app.NotificationCompat.NotificationCompatApi16Impl, android.support.v4.app.NotificationCompat.NotificationCompatBaseImpl, android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public android.support.v4.app.NotificationCompat.Action getAction(android.app.Notification notification, int i) {
            return (android.support.v4.app.NotificationCompat.Action) android.support.v4.app.NotificationCompatApi20.getAction(notification, i, android.support.v4.app.NotificationCompat.Action.FACTORY, android.support.v4.app.RemoteInput.FACTORY);
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatApi16Impl, android.support.v4.app.NotificationCompat.NotificationCompatBaseImpl, android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public android.support.v4.app.NotificationCompat.Action[] getActionsFromParcelableArrayList(java.util.ArrayList<android.os.Parcelable> arrayList) {
            return (android.support.v4.app.NotificationCompat.Action[]) android.support.v4.app.NotificationCompatApi20.getActionsFromParcelableArrayList(arrayList, android.support.v4.app.NotificationCompat.Action.FACTORY, android.support.v4.app.RemoteInput.FACTORY);
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatApi16Impl, android.support.v4.app.NotificationCompat.NotificationCompatBaseImpl, android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public java.util.ArrayList<android.os.Parcelable> getParcelableArrayListForActions(android.support.v4.app.NotificationCompat.Action[] actionArr) {
            return android.support.v4.app.NotificationCompatApi20.getParcelableArrayListForActions(actionArr);
        }
    }

    @android.support.annotation.RequiresApi(21)
    static class NotificationCompatApi21Impl extends android.support.v4.app.NotificationCompat.NotificationCompatApi20Impl {
        NotificationCompatApi21Impl() {
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatApi20Impl, android.support.v4.app.NotificationCompat.NotificationCompatApi19Impl, android.support.v4.app.NotificationCompat.NotificationCompatApi16Impl, android.support.v4.app.NotificationCompat.NotificationCompatBaseImpl, android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public android.app.Notification build(android.support.v4.app.NotificationCompat.Builder builder, android.support.v4.app.NotificationCompat.BuilderExtender builderExtender) {
            android.support.v4.app.NotificationCompatApi21.Builder builder2 = new android.support.v4.app.NotificationCompatApi21.Builder(builder.mContext, builder.mNotification, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.mTickerView, builder.mNumber, builder.mContentIntent, builder.mFullScreenIntent, builder.mLargeIcon, builder.mProgressMax, builder.mProgress, builder.mProgressIndeterminate, builder.mShowWhen, builder.mUseChronometer, builder.mPriority, builder.mSubText, builder.mLocalOnly, builder.mCategory, builder.mPeople, builder.mExtras, builder.mColor, builder.mVisibility, builder.mPublicVersion, builder.mGroupKey, builder.mGroupSummary, builder.mSortKey, builder.mContentView, builder.mBigContentView, builder.mHeadsUpContentView, builder.mGroupAlertBehavior);
            android.support.v4.app.NotificationCompat.addActionsToBuilder(builder2, builder.mActions);
            if (builder.mStyle != null) {
                builder.mStyle.apply(builder2);
            }
            android.app.Notification notificationBuild = builderExtender.build(builder, builder2);
            if (builder.mStyle != null) {
                builder.mStyle.addCompatExtras(android.support.v4.app.NotificationCompat.getExtras(notificationBuild));
            }
            return notificationBuild;
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatBaseImpl, android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public android.os.Bundle getBundleForUnreadConversation(android.support.v4.app.NotificationCompatBase.UnreadConversation unreadConversation) {
            return android.support.v4.app.NotificationCompatApi21.getBundleForUnreadConversation(unreadConversation);
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatBaseImpl, android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public android.support.v4.app.NotificationCompatBase.UnreadConversation getUnreadConversationFromBundle(android.os.Bundle bundle, android.support.v4.app.NotificationCompatBase.UnreadConversation.Factory factory, android.support.v4.app.RemoteInputCompatBase.RemoteInput.Factory factory2) {
            return android.support.v4.app.NotificationCompatApi21.getUnreadConversationFromBundle(bundle, factory, factory2);
        }
    }

    @android.support.annotation.RequiresApi(24)
    static class NotificationCompatApi24Impl extends android.support.v4.app.NotificationCompat.NotificationCompatApi21Impl {
        NotificationCompatApi24Impl() {
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatApi21Impl, android.support.v4.app.NotificationCompat.NotificationCompatApi20Impl, android.support.v4.app.NotificationCompat.NotificationCompatApi19Impl, android.support.v4.app.NotificationCompat.NotificationCompatApi16Impl, android.support.v4.app.NotificationCompat.NotificationCompatBaseImpl, android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public android.app.Notification build(android.support.v4.app.NotificationCompat.Builder builder, android.support.v4.app.NotificationCompat.BuilderExtender builderExtender) {
            android.support.v4.app.NotificationCompatApi24.Builder builder2 = new android.support.v4.app.NotificationCompatApi24.Builder(builder.mContext, builder.mNotification, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.mTickerView, builder.mNumber, builder.mContentIntent, builder.mFullScreenIntent, builder.mLargeIcon, builder.mProgressMax, builder.mProgress, builder.mProgressIndeterminate, builder.mShowWhen, builder.mUseChronometer, builder.mPriority, builder.mSubText, builder.mLocalOnly, builder.mCategory, builder.mPeople, builder.mExtras, builder.mColor, builder.mVisibility, builder.mPublicVersion, builder.mGroupKey, builder.mGroupSummary, builder.mSortKey, builder.mRemoteInputHistory, builder.mContentView, builder.mBigContentView, builder.mHeadsUpContentView, builder.mGroupAlertBehavior);
            android.support.v4.app.NotificationCompat.addActionsToBuilder(builder2, builder.mActions);
            if (builder.mStyle != null) {
                builder.mStyle.apply(builder2);
            }
            android.app.Notification notificationBuild = builderExtender.build(builder, builder2);
            if (builder.mStyle != null) {
                builder.mStyle.addCompatExtras(android.support.v4.app.NotificationCompat.getExtras(notificationBuild));
            }
            return notificationBuild;
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatApi20Impl, android.support.v4.app.NotificationCompat.NotificationCompatApi19Impl, android.support.v4.app.NotificationCompat.NotificationCompatApi16Impl, android.support.v4.app.NotificationCompat.NotificationCompatBaseImpl, android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public android.support.v4.app.NotificationCompat.Action getAction(android.app.Notification notification, int i) {
            return (android.support.v4.app.NotificationCompat.Action) android.support.v4.app.NotificationCompatApi24.getAction(notification, i, android.support.v4.app.NotificationCompat.Action.FACTORY, android.support.v4.app.RemoteInput.FACTORY);
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatApi20Impl, android.support.v4.app.NotificationCompat.NotificationCompatApi16Impl, android.support.v4.app.NotificationCompat.NotificationCompatBaseImpl, android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public android.support.v4.app.NotificationCompat.Action[] getActionsFromParcelableArrayList(java.util.ArrayList<android.os.Parcelable> arrayList) {
            return (android.support.v4.app.NotificationCompat.Action[]) android.support.v4.app.NotificationCompatApi24.getActionsFromParcelableArrayList(arrayList, android.support.v4.app.NotificationCompat.Action.FACTORY, android.support.v4.app.RemoteInput.FACTORY);
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatApi20Impl, android.support.v4.app.NotificationCompat.NotificationCompatApi16Impl, android.support.v4.app.NotificationCompat.NotificationCompatBaseImpl, android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public java.util.ArrayList<android.os.Parcelable> getParcelableArrayListForActions(android.support.v4.app.NotificationCompat.Action[] actionArr) {
            return android.support.v4.app.NotificationCompatApi24.getParcelableArrayListForActions(actionArr);
        }
    }

    @android.support.annotation.RequiresApi(26)
    static class NotificationCompatApi26Impl extends android.support.v4.app.NotificationCompat.NotificationCompatApi24Impl {
        NotificationCompatApi26Impl() {
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatApi24Impl, android.support.v4.app.NotificationCompat.NotificationCompatApi21Impl, android.support.v4.app.NotificationCompat.NotificationCompatApi20Impl, android.support.v4.app.NotificationCompat.NotificationCompatApi19Impl, android.support.v4.app.NotificationCompat.NotificationCompatApi16Impl, android.support.v4.app.NotificationCompat.NotificationCompatBaseImpl, android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public android.app.Notification build(android.support.v4.app.NotificationCompat.Builder builder, android.support.v4.app.NotificationCompat.BuilderExtender builderExtender) {
            android.support.v4.app.NotificationCompatApi26.Builder builder2 = new android.support.v4.app.NotificationCompatApi26.Builder(builder.mContext, builder.mNotification, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.mTickerView, builder.mNumber, builder.mContentIntent, builder.mFullScreenIntent, builder.mLargeIcon, builder.mProgressMax, builder.mProgress, builder.mProgressIndeterminate, builder.mShowWhen, builder.mUseChronometer, builder.mPriority, builder.mSubText, builder.mLocalOnly, builder.mCategory, builder.mPeople, builder.mExtras, builder.mColor, builder.mVisibility, builder.mPublicVersion, builder.mGroupKey, builder.mGroupSummary, builder.mSortKey, builder.mRemoteInputHistory, builder.mContentView, builder.mBigContentView, builder.mHeadsUpContentView, builder.mChannelId, builder.mBadgeIcon, builder.mShortcutId, builder.mTimeout, builder.mColorized, builder.mColorizedSet, builder.mGroupAlertBehavior);
            android.support.v4.app.NotificationCompat.addActionsToBuilder(builder2, builder.mActions);
            if (builder.mStyle != null) {
                builder.mStyle.apply(builder2);
            }
            android.app.Notification notificationBuild = builderExtender.build(builder, builder2);
            if (builder.mStyle != null) {
                builder.mStyle.addCompatExtras(android.support.v4.app.NotificationCompat.getExtras(notificationBuild));
            }
            return notificationBuild;
        }
    }

    static class NotificationCompatBaseImpl implements android.support.v4.app.NotificationCompat.NotificationCompatImpl {

        public static class BuilderBase implements android.support.v4.app.NotificationBuilderWithBuilderAccessor {
            private android.app.Notification.Builder mBuilder;

            BuilderBase(android.content.Context context, android.app.Notification notification, java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3, android.widget.RemoteViews remoteViews, int i, android.app.PendingIntent pendingIntent, android.app.PendingIntent pendingIntent2, android.graphics.Bitmap bitmap, int i2, int i3, boolean z) {
                boolean z2 = true;
                android.app.Notification.Builder deleteIntent = new android.app.Notification.Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
                if ((notification.flags & 128) == 0) {
                    z2 = false;
                }
                this.mBuilder = deleteIntent.setFullScreenIntent(pendingIntent2, z2).setLargeIcon(bitmap).setNumber(i).setProgress(i2, i3, z);
            }

            @Override // android.support.v4.app.NotificationBuilderWithBuilderAccessor
            public android.app.Notification build() {
                return this.mBuilder.getNotification();
            }

            @Override // android.support.v4.app.NotificationBuilderWithBuilderAccessor
            public android.app.Notification.Builder getBuilder() {
                return this.mBuilder;
            }
        }

        NotificationCompatBaseImpl() {
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public android.app.Notification build(android.support.v4.app.NotificationCompat.Builder builder, android.support.v4.app.NotificationCompat.BuilderExtender builderExtender) {
            return builderExtender.build(builder, new android.support.v4.app.NotificationCompat.NotificationCompatBaseImpl.BuilderBase(builder.mContext, builder.mNotification, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.mTickerView, builder.mNumber, builder.mContentIntent, builder.mFullScreenIntent, builder.mLargeIcon, builder.mProgressMax, builder.mProgress, builder.mProgressIndeterminate));
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public android.support.v4.app.NotificationCompat.Action getAction(android.app.Notification notification, int i) {
            return null;
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public android.support.v4.app.NotificationCompat.Action[] getActionsFromParcelableArrayList(java.util.ArrayList<android.os.Parcelable> arrayList) {
            return null;
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public android.os.Bundle getBundleForUnreadConversation(android.support.v4.app.NotificationCompatBase.UnreadConversation unreadConversation) {
            return null;
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public java.util.ArrayList<android.os.Parcelable> getParcelableArrayListForActions(android.support.v4.app.NotificationCompat.Action[] actionArr) {
            return null;
        }

        @Override // android.support.v4.app.NotificationCompat.NotificationCompatImpl
        public android.support.v4.app.NotificationCompatBase.UnreadConversation getUnreadConversationFromBundle(android.os.Bundle bundle, android.support.v4.app.NotificationCompatBase.UnreadConversation.Factory factory, android.support.v4.app.RemoteInputCompatBase.RemoteInput.Factory factory2) {
            return null;
        }
    }

    interface NotificationCompatImpl {
        android.app.Notification build(android.support.v4.app.NotificationCompat.Builder builder, android.support.v4.app.NotificationCompat.BuilderExtender builderExtender);

        android.support.v4.app.NotificationCompat.Action getAction(android.app.Notification notification, int i);

        android.support.v4.app.NotificationCompat.Action[] getActionsFromParcelableArrayList(java.util.ArrayList<android.os.Parcelable> arrayList);

        android.os.Bundle getBundleForUnreadConversation(android.support.v4.app.NotificationCompatBase.UnreadConversation unreadConversation);

        java.util.ArrayList<android.os.Parcelable> getParcelableArrayListForActions(android.support.v4.app.NotificationCompat.Action[] actionArr);

        android.support.v4.app.NotificationCompatBase.UnreadConversation getUnreadConversationFromBundle(android.os.Bundle bundle, android.support.v4.app.NotificationCompatBase.UnreadConversation.Factory factory, android.support.v4.app.RemoteInputCompatBase.RemoteInput.Factory factory2);
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface NotificationVisibility {
    }

    public static abstract class Style {
        java.lang.CharSequence mBigContentTitle;

        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        protected android.support.v4.app.NotificationCompat.Builder mBuilder;
        java.lang.CharSequence mSummaryText;
        boolean mSummaryTextSet = false;

        private int calculateTopPadding() {
            android.content.res.Resources resources = this.mBuilder.mContext.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(android.support.compat.R.dimen.notification_top_pad);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(android.support.compat.R.dimen.notification_top_pad_large_text);
            float fConstrain = (constrain(resources.getConfiguration().fontScale, 1.0f, 1.3f) - 1.0f) / 0.29999995f;
            return java.lang.Math.round(((1.0f - fConstrain) * dimensionPixelSize) + (fConstrain * dimensionPixelSize2));
        }

        private static float constrain(float f, float f2, float f3) {
            if (f < f2) {
                return f2;
            }
            return f > f3 ? f3 : f;
        }

        private android.graphics.Bitmap createColoredBitmap(int i, int i2, int i3) {
            android.graphics.drawable.Drawable drawable = this.mBuilder.mContext.getResources().getDrawable(i);
            int intrinsicWidth = i3 == 0 ? drawable.getIntrinsicWidth() : i3;
            if (i3 == 0) {
                i3 = drawable.getIntrinsicHeight();
            }
            android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(intrinsicWidth, i3, android.graphics.Bitmap.Config.ARGB_8888);
            drawable.setBounds(0, 0, intrinsicWidth, i3);
            if (i2 != 0) {
                drawable.mutate().setColorFilter(new android.graphics.PorterDuffColorFilter(i2, android.graphics.PorterDuff.Mode.SRC_IN));
            }
            drawable.draw(new android.graphics.Canvas(bitmapCreateBitmap));
            return bitmapCreateBitmap;
        }

        private android.graphics.Bitmap createIconWithBackground(int i, int i2, int i3, int i4) {
            int i5 = android.support.compat.R.drawable.notification_icon_background;
            if (i4 == 0) {
                i4 = 0;
            }
            android.graphics.Bitmap bitmapCreateColoredBitmap = createColoredBitmap(i5, i4, i2);
            android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapCreateColoredBitmap);
            android.graphics.drawable.Drawable drawableMutate = this.mBuilder.mContext.getResources().getDrawable(i).mutate();
            drawableMutate.setFilterBitmap(true);
            int i6 = (i2 - i3) / 2;
            int i7 = i3 + i6;
            drawableMutate.setBounds(i6, i6, i7, i7);
            drawableMutate.setColorFilter(new android.graphics.PorterDuffColorFilter(-1, android.graphics.PorterDuff.Mode.SRC_ATOP));
            drawableMutate.draw(canvas);
            return bitmapCreateColoredBitmap;
        }

        private void hideNormalContent(android.widget.RemoteViews remoteViews) {
            remoteViews.setViewVisibility(android.support.compat.R.id.title, 8);
            remoteViews.setViewVisibility(android.support.compat.R.id.text2, 8);
            remoteViews.setViewVisibility(android.support.compat.R.id.text, 8);
        }

        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public void addCompatExtras(android.os.Bundle bundle) {
        }

        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public void apply(android.support.v4.app.NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        }

        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public android.widget.RemoteViews applyStandardTemplate(boolean z, int i, boolean z2) {
            boolean z3;
            boolean z4;
            android.content.res.Resources resources = this.mBuilder.mContext.getResources();
            android.widget.RemoteViews remoteViews = new android.widget.RemoteViews(this.mBuilder.mContext.getPackageName(), i);
            boolean z5 = this.mBuilder.getPriority() < -1;
            if (android.os.Build.VERSION.SDK_INT >= 16 && android.os.Build.VERSION.SDK_INT < 21) {
                if (z5) {
                    remoteViews.setInt(android.support.compat.R.id.notification_background, "setBackgroundResource", android.support.compat.R.drawable.notification_bg_low);
                    remoteViews.setInt(android.support.compat.R.id.icon, "setBackgroundResource", android.support.compat.R.drawable.notification_template_icon_low_bg);
                } else {
                    remoteViews.setInt(android.support.compat.R.id.notification_background, "setBackgroundResource", android.support.compat.R.drawable.notification_bg);
                    remoteViews.setInt(android.support.compat.R.id.icon, "setBackgroundResource", android.support.compat.R.drawable.notification_template_icon_bg);
                }
            }
            if (this.mBuilder.mLargeIcon != null) {
                if (android.os.Build.VERSION.SDK_INT >= 16) {
                    remoteViews.setViewVisibility(android.support.compat.R.id.icon, 0);
                    remoteViews.setImageViewBitmap(android.support.compat.R.id.icon, this.mBuilder.mLargeIcon);
                } else {
                    remoteViews.setViewVisibility(android.support.compat.R.id.icon, 8);
                }
                if (z && this.mBuilder.mNotification.icon != 0) {
                    int dimensionPixelSize = resources.getDimensionPixelSize(android.support.compat.R.dimen.notification_right_icon_size);
                    int dimensionPixelSize2 = dimensionPixelSize - (resources.getDimensionPixelSize(android.support.compat.R.dimen.notification_small_icon_background_padding) * 2);
                    if (android.os.Build.VERSION.SDK_INT >= 21) {
                        remoteViews.setImageViewBitmap(android.support.compat.R.id.right_icon, createIconWithBackground(this.mBuilder.mNotification.icon, dimensionPixelSize, dimensionPixelSize2, this.mBuilder.getColor()));
                    } else {
                        remoteViews.setImageViewBitmap(android.support.compat.R.id.right_icon, createColoredBitmap(this.mBuilder.mNotification.icon, -1));
                    }
                    remoteViews.setViewVisibility(android.support.compat.R.id.right_icon, 0);
                }
            } else if (z && this.mBuilder.mNotification.icon != 0) {
                remoteViews.setViewVisibility(android.support.compat.R.id.icon, 0);
                if (android.os.Build.VERSION.SDK_INT >= 21) {
                    remoteViews.setImageViewBitmap(android.support.compat.R.id.icon, createIconWithBackground(this.mBuilder.mNotification.icon, resources.getDimensionPixelSize(android.support.compat.R.dimen.notification_large_icon_width) - resources.getDimensionPixelSize(android.support.compat.R.dimen.notification_big_circle_margin), resources.getDimensionPixelSize(android.support.compat.R.dimen.notification_small_icon_size_as_large), this.mBuilder.getColor()));
                } else {
                    remoteViews.setImageViewBitmap(android.support.compat.R.id.icon, createColoredBitmap(this.mBuilder.mNotification.icon, -1));
                }
            }
            if (this.mBuilder.mContentTitle != null) {
                remoteViews.setTextViewText(android.support.compat.R.id.title, this.mBuilder.mContentTitle);
            }
            if (this.mBuilder.mContentText != null) {
                remoteViews.setTextViewText(android.support.compat.R.id.text, this.mBuilder.mContentText);
                z3 = true;
            } else {
                z3 = false;
            }
            boolean z6 = android.os.Build.VERSION.SDK_INT < 21 && this.mBuilder.mLargeIcon != null;
            if (this.mBuilder.mContentInfo != null) {
                remoteViews.setTextViewText(android.support.compat.R.id.info, this.mBuilder.mContentInfo);
                remoteViews.setViewVisibility(android.support.compat.R.id.info, 0);
                z3 = true;
                z6 = true;
            } else if (this.mBuilder.mNumber > 0) {
                if (this.mBuilder.mNumber > resources.getInteger(android.support.compat.R.integer.status_bar_notification_info_maxnum)) {
                    remoteViews.setTextViewText(android.support.compat.R.id.info, resources.getString(android.support.compat.R.string.status_bar_notification_info_overflow));
                } else {
                    remoteViews.setTextViewText(android.support.compat.R.id.info, java.text.NumberFormat.getIntegerInstance().format(this.mBuilder.mNumber));
                }
                remoteViews.setViewVisibility(android.support.compat.R.id.info, 0);
                z3 = true;
                z6 = true;
            } else {
                remoteViews.setViewVisibility(android.support.compat.R.id.info, 8);
            }
            if (this.mBuilder.mSubText == null || android.os.Build.VERSION.SDK_INT < 16) {
                z4 = false;
            } else {
                remoteViews.setTextViewText(android.support.compat.R.id.text, this.mBuilder.mSubText);
                if (this.mBuilder.mContentText != null) {
                    remoteViews.setTextViewText(android.support.compat.R.id.text2, this.mBuilder.mContentText);
                    remoteViews.setViewVisibility(android.support.compat.R.id.text2, 0);
                    z4 = true;
                } else {
                    remoteViews.setViewVisibility(android.support.compat.R.id.text2, 8);
                    z4 = false;
                }
            }
            if (z4 && android.os.Build.VERSION.SDK_INT >= 16) {
                if (z2) {
                    remoteViews.setTextViewTextSize(android.support.compat.R.id.text, 0, resources.getDimensionPixelSize(android.support.compat.R.dimen.notification_subtext_size));
                }
                remoteViews.setViewPadding(android.support.compat.R.id.line1, 0, 0, 0, 0);
            }
            if (this.mBuilder.getWhenIfShowing() != 0) {
                if (!this.mBuilder.mUseChronometer || android.os.Build.VERSION.SDK_INT < 16) {
                    remoteViews.setViewVisibility(android.support.compat.R.id.time, 0);
                    remoteViews.setLong(android.support.compat.R.id.time, "setTime", this.mBuilder.getWhenIfShowing());
                } else {
                    remoteViews.setViewVisibility(android.support.compat.R.id.chronometer, 0);
                    remoteViews.setLong(android.support.compat.R.id.chronometer, "setBase", this.mBuilder.getWhenIfShowing() + (android.os.SystemClock.elapsedRealtime() - java.lang.System.currentTimeMillis()));
                    remoteViews.setBoolean(android.support.compat.R.id.chronometer, "setStarted", true);
                }
                z6 = true;
            }
            remoteViews.setViewVisibility(android.support.compat.R.id.right_side, z6 ? 0 : 8);
            remoteViews.setViewVisibility(android.support.compat.R.id.line3, z3 ? 0 : 8);
            return remoteViews;
        }

        public android.app.Notification build() {
            android.support.v4.app.NotificationCompat.Builder builder = this.mBuilder;
            if (builder != null) {
                return builder.build();
            }
            return null;
        }

        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public void buildIntoRemoteViews(android.widget.RemoteViews remoteViews, android.widget.RemoteViews remoteViews2) {
            hideNormalContent(remoteViews);
            remoteViews.removeAllViews(android.support.compat.R.id.notification_main_column);
            remoteViews.addView(android.support.compat.R.id.notification_main_column, remoteViews2.clone());
            remoteViews.setViewVisibility(android.support.compat.R.id.notification_main_column, 0);
            if (android.os.Build.VERSION.SDK_INT >= 21) {
                remoteViews.setViewPadding(android.support.compat.R.id.notification_main_column_container, 0, calculateTopPadding(), 0, 0);
            }
        }

        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public android.graphics.Bitmap createColoredBitmap(int i, int i2) {
            return createColoredBitmap(i, i2, 0);
        }

        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public android.widget.RemoteViews makeBigContentView(android.support.v4.app.NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public android.widget.RemoteViews makeContentView(android.support.v4.app.NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public android.widget.RemoteViews makeHeadsUpContentView(android.support.v4.app.NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        protected void restoreFromCompatExtras(android.os.Bundle bundle) {
        }

        public void setBuilder(android.support.v4.app.NotificationCompat.Builder builder) {
            if (this.mBuilder != builder) {
                this.mBuilder = builder;
                android.support.v4.app.NotificationCompat.Builder builder2 = this.mBuilder;
                if (builder2 != null) {
                    builder2.setStyle(this);
                }
            }
        }
    }

    public static final class WearableExtender implements android.support.v4.app.NotificationCompat.Extender {
        private static final int DEFAULT_CONTENT_ICON_GRAVITY = 8388613;
        private static final int DEFAULT_FLAGS = 1;
        private static final int DEFAULT_GRAVITY = 80;
        private static final java.lang.String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
        private static final int FLAG_BIG_PICTURE_AMBIENT = 32;
        private static final int FLAG_CONTENT_INTENT_AVAILABLE_OFFLINE = 1;
        private static final int FLAG_HINT_AVOID_BACKGROUND_CLIPPING = 16;
        private static final int FLAG_HINT_CONTENT_INTENT_LAUNCHES_ACTIVITY = 64;
        private static final int FLAG_HINT_HIDE_ICON = 2;
        private static final int FLAG_HINT_SHOW_BACKGROUND_ONLY = 4;
        private static final int FLAG_START_SCROLL_BOTTOM = 8;
        private static final java.lang.String KEY_ACTIONS = "actions";
        private static final java.lang.String KEY_BACKGROUND = "background";
        private static final java.lang.String KEY_BRIDGE_TAG = "bridgeTag";
        private static final java.lang.String KEY_CONTENT_ACTION_INDEX = "contentActionIndex";
        private static final java.lang.String KEY_CONTENT_ICON = "contentIcon";
        private static final java.lang.String KEY_CONTENT_ICON_GRAVITY = "contentIconGravity";
        private static final java.lang.String KEY_CUSTOM_CONTENT_HEIGHT = "customContentHeight";
        private static final java.lang.String KEY_CUSTOM_SIZE_PRESET = "customSizePreset";
        private static final java.lang.String KEY_DISMISSAL_ID = "dismissalId";
        private static final java.lang.String KEY_DISPLAY_INTENT = "displayIntent";
        private static final java.lang.String KEY_FLAGS = "flags";
        private static final java.lang.String KEY_GRAVITY = "gravity";
        private static final java.lang.String KEY_HINT_SCREEN_TIMEOUT = "hintScreenTimeout";
        private static final java.lang.String KEY_PAGES = "pages";
        public static final int SCREEN_TIMEOUT_LONG = -1;
        public static final int SCREEN_TIMEOUT_SHORT = 0;
        public static final int SIZE_DEFAULT = 0;
        public static final int SIZE_FULL_SCREEN = 5;
        public static final int SIZE_LARGE = 4;
        public static final int SIZE_MEDIUM = 3;
        public static final int SIZE_SMALL = 2;
        public static final int SIZE_XSMALL = 1;
        public static final int UNSET_ACTION_INDEX = -1;
        private java.util.ArrayList<android.support.v4.app.NotificationCompat.Action> mActions;
        private android.graphics.Bitmap mBackground;
        private java.lang.String mBridgeTag;
        private int mContentActionIndex;
        private int mContentIcon;
        private int mContentIconGravity;
        private int mCustomContentHeight;
        private int mCustomSizePreset;
        private java.lang.String mDismissalId;
        private android.app.PendingIntent mDisplayIntent;
        private int mFlags;
        private int mGravity;
        private int mHintScreenTimeout;
        private java.util.ArrayList<android.app.Notification> mPages;

        public WearableExtender() {
            this.mActions = new java.util.ArrayList<>();
            this.mFlags = 1;
            this.mPages = new java.util.ArrayList<>();
            this.mContentIconGravity = 8388613;
            this.mContentActionIndex = -1;
            this.mCustomSizePreset = 0;
            this.mGravity = 80;
        }

        public WearableExtender(android.app.Notification notification) {
            this.mActions = new java.util.ArrayList<>();
            this.mFlags = 1;
            this.mPages = new java.util.ArrayList<>();
            this.mContentIconGravity = 8388613;
            this.mContentActionIndex = -1;
            this.mCustomSizePreset = 0;
            this.mGravity = 80;
            android.os.Bundle extras = android.support.v4.app.NotificationCompat.getExtras(notification);
            android.os.Bundle bundle = extras != null ? extras.getBundle(EXTRA_WEARABLE_EXTENSIONS) : null;
            if (bundle != null) {
                android.support.v4.app.NotificationCompat.Action[] actionsFromParcelableArrayList = android.support.v4.app.NotificationCompat.IMPL.getActionsFromParcelableArrayList(bundle.getParcelableArrayList(KEY_ACTIONS));
                if (actionsFromParcelableArrayList != null) {
                    java.util.Collections.addAll(this.mActions, actionsFromParcelableArrayList);
                }
                this.mFlags = bundle.getInt(KEY_FLAGS, 1);
                this.mDisplayIntent = (android.app.PendingIntent) bundle.getParcelable(KEY_DISPLAY_INTENT);
                android.app.Notification[] notificationArrayFromBundle = android.support.v4.app.NotificationCompat.getNotificationArrayFromBundle(bundle, KEY_PAGES);
                if (notificationArrayFromBundle != null) {
                    java.util.Collections.addAll(this.mPages, notificationArrayFromBundle);
                }
                this.mBackground = (android.graphics.Bitmap) bundle.getParcelable(KEY_BACKGROUND);
                this.mContentIcon = bundle.getInt(KEY_CONTENT_ICON);
                this.mContentIconGravity = bundle.getInt(KEY_CONTENT_ICON_GRAVITY, 8388613);
                this.mContentActionIndex = bundle.getInt(KEY_CONTENT_ACTION_INDEX, -1);
                this.mCustomSizePreset = bundle.getInt(KEY_CUSTOM_SIZE_PRESET, 0);
                this.mCustomContentHeight = bundle.getInt(KEY_CUSTOM_CONTENT_HEIGHT);
                this.mGravity = bundle.getInt(KEY_GRAVITY, 80);
                this.mHintScreenTimeout = bundle.getInt(KEY_HINT_SCREEN_TIMEOUT);
                this.mDismissalId = bundle.getString(KEY_DISMISSAL_ID);
                this.mBridgeTag = bundle.getString(KEY_BRIDGE_TAG);
            }
        }

        private void setFlag(int i, boolean z) {
            if (z) {
                this.mFlags = i | this.mFlags;
            } else {
                this.mFlags = (i ^ (-1)) & this.mFlags;
            }
        }

        public android.support.v4.app.NotificationCompat.WearableExtender addAction(android.support.v4.app.NotificationCompat.Action action) {
            this.mActions.add(action);
            return this;
        }

        public android.support.v4.app.NotificationCompat.WearableExtender addActions(java.util.List<android.support.v4.app.NotificationCompat.Action> list) {
            this.mActions.addAll(list);
            return this;
        }

        public android.support.v4.app.NotificationCompat.WearableExtender addPage(android.app.Notification notification) {
            this.mPages.add(notification);
            return this;
        }

        public android.support.v4.app.NotificationCompat.WearableExtender addPages(java.util.List<android.app.Notification> list) {
            this.mPages.addAll(list);
            return this;
        }

        public android.support.v4.app.NotificationCompat.WearableExtender clearActions() {
            this.mActions.clear();
            return this;
        }

        public android.support.v4.app.NotificationCompat.WearableExtender clearPages() {
            this.mPages.clear();
            return this;
        }

        /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
        public android.support.v4.app.NotificationCompat.WearableExtender m1clone() {
            android.support.v4.app.NotificationCompat.WearableExtender wearableExtender = new android.support.v4.app.NotificationCompat.WearableExtender();
            wearableExtender.mActions = new java.util.ArrayList<>(this.mActions);
            wearableExtender.mFlags = this.mFlags;
            wearableExtender.mDisplayIntent = this.mDisplayIntent;
            wearableExtender.mPages = new java.util.ArrayList<>(this.mPages);
            wearableExtender.mBackground = this.mBackground;
            wearableExtender.mContentIcon = this.mContentIcon;
            wearableExtender.mContentIconGravity = this.mContentIconGravity;
            wearableExtender.mContentActionIndex = this.mContentActionIndex;
            wearableExtender.mCustomSizePreset = this.mCustomSizePreset;
            wearableExtender.mCustomContentHeight = this.mCustomContentHeight;
            wearableExtender.mGravity = this.mGravity;
            wearableExtender.mHintScreenTimeout = this.mHintScreenTimeout;
            wearableExtender.mDismissalId = this.mDismissalId;
            wearableExtender.mBridgeTag = this.mBridgeTag;
            return wearableExtender;
        }

        @Override // android.support.v4.app.NotificationCompat.Extender
        public android.support.v4.app.NotificationCompat.Builder extend(android.support.v4.app.NotificationCompat.Builder builder) {
            android.os.Bundle bundle = new android.os.Bundle();
            if (!this.mActions.isEmpty()) {
                android.support.v4.app.NotificationCompat.NotificationCompatImpl notificationCompatImpl = android.support.v4.app.NotificationCompat.IMPL;
                java.util.ArrayList<android.support.v4.app.NotificationCompat.Action> arrayList = this.mActions;
                bundle.putParcelableArrayList(KEY_ACTIONS, notificationCompatImpl.getParcelableArrayListForActions((android.support.v4.app.NotificationCompat.Action[]) arrayList.toArray(new android.support.v4.app.NotificationCompat.Action[arrayList.size()])));
            }
            int i = this.mFlags;
            if (i != 1) {
                bundle.putInt(KEY_FLAGS, i);
            }
            android.app.PendingIntent pendingIntent = this.mDisplayIntent;
            if (pendingIntent != null) {
                bundle.putParcelable(KEY_DISPLAY_INTENT, pendingIntent);
            }
            if (!this.mPages.isEmpty()) {
                java.util.ArrayList<android.app.Notification> arrayList2 = this.mPages;
                bundle.putParcelableArray(KEY_PAGES, (android.os.Parcelable[]) arrayList2.toArray(new android.app.Notification[arrayList2.size()]));
            }
            android.graphics.Bitmap bitmap = this.mBackground;
            if (bitmap != null) {
                bundle.putParcelable(KEY_BACKGROUND, bitmap);
            }
            int i2 = this.mContentIcon;
            if (i2 != 0) {
                bundle.putInt(KEY_CONTENT_ICON, i2);
            }
            int i3 = this.mContentIconGravity;
            if (i3 != 8388613) {
                bundle.putInt(KEY_CONTENT_ICON_GRAVITY, i3);
            }
            int i4 = this.mContentActionIndex;
            if (i4 != -1) {
                bundle.putInt(KEY_CONTENT_ACTION_INDEX, i4);
            }
            int i5 = this.mCustomSizePreset;
            if (i5 != 0) {
                bundle.putInt(KEY_CUSTOM_SIZE_PRESET, i5);
            }
            int i6 = this.mCustomContentHeight;
            if (i6 != 0) {
                bundle.putInt(KEY_CUSTOM_CONTENT_HEIGHT, i6);
            }
            int i7 = this.mGravity;
            if (i7 != 80) {
                bundle.putInt(KEY_GRAVITY, i7);
            }
            int i8 = this.mHintScreenTimeout;
            if (i8 != 0) {
                bundle.putInt(KEY_HINT_SCREEN_TIMEOUT, i8);
            }
            java.lang.String str = this.mDismissalId;
            if (str != null) {
                bundle.putString(KEY_DISMISSAL_ID, str);
            }
            java.lang.String str2 = this.mBridgeTag;
            if (str2 != null) {
                bundle.putString(KEY_BRIDGE_TAG, str2);
            }
            builder.getExtras().putBundle(EXTRA_WEARABLE_EXTENSIONS, bundle);
            return builder;
        }

        public java.util.List<android.support.v4.app.NotificationCompat.Action> getActions() {
            return this.mActions;
        }

        public android.graphics.Bitmap getBackground() {
            return this.mBackground;
        }

        public java.lang.String getBridgeTag() {
            return this.mBridgeTag;
        }

        public int getContentAction() {
            return this.mContentActionIndex;
        }

        public int getContentIcon() {
            return this.mContentIcon;
        }

        public int getContentIconGravity() {
            return this.mContentIconGravity;
        }

        public boolean getContentIntentAvailableOffline() {
            return (this.mFlags & 1) != 0;
        }

        public int getCustomContentHeight() {
            return this.mCustomContentHeight;
        }

        public int getCustomSizePreset() {
            return this.mCustomSizePreset;
        }

        public java.lang.String getDismissalId() {
            return this.mDismissalId;
        }

        public android.app.PendingIntent getDisplayIntent() {
            return this.mDisplayIntent;
        }

        public int getGravity() {
            return this.mGravity;
        }

        public boolean getHintAmbientBigPicture() {
            return (this.mFlags & 32) != 0;
        }

        public boolean getHintAvoidBackgroundClipping() {
            return (this.mFlags & 16) != 0;
        }

        public boolean getHintContentIntentLaunchesActivity() {
            return (this.mFlags & 64) != 0;
        }

        public boolean getHintHideIcon() {
            return (this.mFlags & 2) != 0;
        }

        public int getHintScreenTimeout() {
            return this.mHintScreenTimeout;
        }

        public boolean getHintShowBackgroundOnly() {
            return (this.mFlags & 4) != 0;
        }

        public java.util.List<android.app.Notification> getPages() {
            return this.mPages;
        }

        public boolean getStartScrollBottom() {
            return (this.mFlags & 8) != 0;
        }

        public android.support.v4.app.NotificationCompat.WearableExtender setBackground(android.graphics.Bitmap bitmap) {
            this.mBackground = bitmap;
            return this;
        }

        public android.support.v4.app.NotificationCompat.WearableExtender setBridgeTag(java.lang.String str) {
            this.mBridgeTag = str;
            return this;
        }

        public android.support.v4.app.NotificationCompat.WearableExtender setContentAction(int i) {
            this.mContentActionIndex = i;
            return this;
        }

        public android.support.v4.app.NotificationCompat.WearableExtender setContentIcon(int i) {
            this.mContentIcon = i;
            return this;
        }

        public android.support.v4.app.NotificationCompat.WearableExtender setContentIconGravity(int i) {
            this.mContentIconGravity = i;
            return this;
        }

        public android.support.v4.app.NotificationCompat.WearableExtender setContentIntentAvailableOffline(boolean z) {
            setFlag(1, z);
            return this;
        }

        public android.support.v4.app.NotificationCompat.WearableExtender setCustomContentHeight(int i) {
            this.mCustomContentHeight = i;
            return this;
        }

        public android.support.v4.app.NotificationCompat.WearableExtender setCustomSizePreset(int i) {
            this.mCustomSizePreset = i;
            return this;
        }

        public android.support.v4.app.NotificationCompat.WearableExtender setDismissalId(java.lang.String str) {
            this.mDismissalId = str;
            return this;
        }

        public android.support.v4.app.NotificationCompat.WearableExtender setDisplayIntent(android.app.PendingIntent pendingIntent) {
            this.mDisplayIntent = pendingIntent;
            return this;
        }

        public android.support.v4.app.NotificationCompat.WearableExtender setGravity(int i) {
            this.mGravity = i;
            return this;
        }

        public android.support.v4.app.NotificationCompat.WearableExtender setHintAmbientBigPicture(boolean z) {
            setFlag(32, z);
            return this;
        }

        public android.support.v4.app.NotificationCompat.WearableExtender setHintAvoidBackgroundClipping(boolean z) {
            setFlag(16, z);
            return this;
        }

        public android.support.v4.app.NotificationCompat.WearableExtender setHintContentIntentLaunchesActivity(boolean z) {
            setFlag(64, z);
            return this;
        }

        public android.support.v4.app.NotificationCompat.WearableExtender setHintHideIcon(boolean z) {
            setFlag(2, z);
            return this;
        }

        public android.support.v4.app.NotificationCompat.WearableExtender setHintScreenTimeout(int i) {
            this.mHintScreenTimeout = i;
            return this;
        }

        public android.support.v4.app.NotificationCompat.WearableExtender setHintShowBackgroundOnly(boolean z) {
            setFlag(4, z);
            return this;
        }

        public android.support.v4.app.NotificationCompat.WearableExtender setStartScrollBottom(boolean z) {
            setFlag(8, z);
            return this;
        }
    }

    static {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            IMPL = new android.support.v4.app.NotificationCompat.NotificationCompatApi26Impl();
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            IMPL = new android.support.v4.app.NotificationCompat.NotificationCompatApi24Impl();
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            IMPL = new android.support.v4.app.NotificationCompat.NotificationCompatApi21Impl();
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 20) {
            IMPL = new android.support.v4.app.NotificationCompat.NotificationCompatApi20Impl();
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            IMPL = new android.support.v4.app.NotificationCompat.NotificationCompatApi19Impl();
        } else if (android.os.Build.VERSION.SDK_INT >= 16) {
            IMPL = new android.support.v4.app.NotificationCompat.NotificationCompatApi16Impl();
        } else {
            IMPL = new android.support.v4.app.NotificationCompat.NotificationCompatBaseImpl();
        }
    }

    static void addActionsToBuilder(android.support.v4.app.NotificationBuilderWithActions notificationBuilderWithActions, java.util.ArrayList<android.support.v4.app.NotificationCompat.Action> arrayList) {
        java.util.Iterator<android.support.v4.app.NotificationCompat.Action> it = arrayList.iterator();
        while (it.hasNext()) {
            notificationBuilderWithActions.addAction(it.next());
        }
    }

    public static android.support.v4.app.NotificationCompat.Action getAction(android.app.Notification notification, int i) {
        return IMPL.getAction(notification, i);
    }

    public static int getActionCount(android.app.Notification notification) {
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            if (notification.actions != null) {
                return notification.actions.length;
            }
            return 0;
        }
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            return android.support.v4.app.NotificationCompatJellybean.getActionCount(notification);
        }
        return 0;
    }

    public static int getBadgeIconType(android.app.Notification notification) {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            return notification.getBadgeIconType();
        }
        return 0;
    }

    public static java.lang.String getCategory(android.app.Notification notification) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            return notification.category;
        }
        return null;
    }

    public static java.lang.String getChannelId(android.app.Notification notification) {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            return notification.getChannelId();
        }
        return null;
    }

    public static android.os.Bundle getExtras(android.app.Notification notification) {
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            return notification.extras;
        }
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            return android.support.v4.app.NotificationCompatJellybean.getExtras(notification);
        }
        return null;
    }

    public static java.lang.String getGroup(android.app.Notification notification) {
        if (android.os.Build.VERSION.SDK_INT >= 20) {
            return notification.getGroup();
        }
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            return notification.extras.getString(android.support.v4.app.NotificationCompatExtras.EXTRA_GROUP_KEY);
        }
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            return android.support.v4.app.NotificationCompatJellybean.getExtras(notification).getString(android.support.v4.app.NotificationCompatExtras.EXTRA_GROUP_KEY);
        }
        return null;
    }

    public static int getGroupAlertBehavior(android.app.Notification notification) {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            return notification.getGroupAlertBehavior();
        }
        return 0;
    }

    public static boolean getLocalOnly(android.app.Notification notification) {
        if (android.os.Build.VERSION.SDK_INT >= 20) {
            return (notification.flags & 256) != 0;
        }
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            return notification.extras.getBoolean(android.support.v4.app.NotificationCompatExtras.EXTRA_LOCAL_ONLY);
        }
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            return android.support.v4.app.NotificationCompatJellybean.getExtras(notification).getBoolean(android.support.v4.app.NotificationCompatExtras.EXTRA_LOCAL_ONLY);
        }
        return false;
    }

    static android.app.Notification[] getNotificationArrayFromBundle(android.os.Bundle bundle, java.lang.String str) {
        android.os.Parcelable[] parcelableArray = bundle.getParcelableArray(str);
        if ((parcelableArray instanceof android.app.Notification[]) || parcelableArray == null) {
            return (android.app.Notification[]) parcelableArray;
        }
        android.app.Notification[] notificationArr = new android.app.Notification[parcelableArray.length];
        for (int i = 0; i < parcelableArray.length; i++) {
            notificationArr[i] = (android.app.Notification) parcelableArray[i];
        }
        bundle.putParcelableArray(str, notificationArr);
        return notificationArr;
    }

    public static java.lang.String getShortcutId(android.app.Notification notification) {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            return notification.getShortcutId();
        }
        return null;
    }

    public static java.lang.String getSortKey(android.app.Notification notification) {
        if (android.os.Build.VERSION.SDK_INT >= 20) {
            return notification.getSortKey();
        }
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            return notification.extras.getString(android.support.v4.app.NotificationCompatExtras.EXTRA_SORT_KEY);
        }
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            return android.support.v4.app.NotificationCompatJellybean.getExtras(notification).getString(android.support.v4.app.NotificationCompatExtras.EXTRA_SORT_KEY);
        }
        return null;
    }

    public static long getTimeoutAfter(android.app.Notification notification) {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            return notification.getTimeoutAfter();
        }
        return 0L;
    }

    public static boolean isGroupSummary(android.app.Notification notification) {
        if (android.os.Build.VERSION.SDK_INT >= 20) {
            return (notification.flags & 512) != 0;
        }
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            return notification.extras.getBoolean(android.support.v4.app.NotificationCompatExtras.EXTRA_GROUP_SUMMARY);
        }
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            return android.support.v4.app.NotificationCompatJellybean.getExtras(notification).getBoolean(android.support.v4.app.NotificationCompatExtras.EXTRA_GROUP_SUMMARY);
        }
        return false;
    }
}
