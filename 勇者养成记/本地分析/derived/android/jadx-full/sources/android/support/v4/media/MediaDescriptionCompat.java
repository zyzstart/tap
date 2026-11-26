package android.support.v4.media;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class MediaDescriptionCompat implements android.os.Parcelable {
    public static final long BT_FOLDER_TYPE_ALBUMS = 2;
    public static final long BT_FOLDER_TYPE_ARTISTS = 3;
    public static final long BT_FOLDER_TYPE_GENRES = 4;
    public static final long BT_FOLDER_TYPE_MIXED = 0;
    public static final long BT_FOLDER_TYPE_PLAYLISTS = 5;
    public static final long BT_FOLDER_TYPE_TITLES = 1;
    public static final long BT_FOLDER_TYPE_YEARS = 6;
    public static final android.os.Parcelable.Creator<android.support.v4.media.MediaDescriptionCompat> CREATOR = new android.os.Parcelable.Creator<android.support.v4.media.MediaDescriptionCompat>() { // from class: android.support.v4.media.MediaDescriptionCompat.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public android.support.v4.media.MediaDescriptionCompat createFromParcel(android.os.Parcel parcel) {
            return android.os.Build.VERSION.SDK_INT < 21 ? new android.support.v4.media.MediaDescriptionCompat(parcel) : android.support.v4.media.MediaDescriptionCompat.fromMediaDescription(android.support.v4.media.MediaDescriptionCompatApi21.fromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public android.support.v4.media.MediaDescriptionCompat[] newArray(int i) {
            return new android.support.v4.media.MediaDescriptionCompat[i];
        }
    };

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public static final java.lang.String DESCRIPTION_KEY_MEDIA_URI = "android.support.v4.media.description.MEDIA_URI";

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public static final java.lang.String DESCRIPTION_KEY_NULL_BUNDLE_FLAG = "android.support.v4.media.description.NULL_BUNDLE_FLAG";
    public static final java.lang.String EXTRA_BT_FOLDER_TYPE = "android.media.extra.BT_FOLDER_TYPE";
    public static final java.lang.String EXTRA_DOWNLOAD_STATUS = "android.media.extra.DOWNLOAD_STATUS";
    public static final long STATUS_DOWNLOADED = 2;
    public static final long STATUS_DOWNLOADING = 1;
    public static final long STATUS_NOT_DOWNLOADED = 0;
    private final java.lang.CharSequence mDescription;
    private java.lang.Object mDescriptionObj;
    private final android.os.Bundle mExtras;
    private final android.graphics.Bitmap mIcon;
    private final android.net.Uri mIconUri;
    private final java.lang.String mMediaId;
    private final android.net.Uri mMediaUri;
    private final java.lang.CharSequence mSubtitle;
    private final java.lang.CharSequence mTitle;

    public static final class Builder {
        private java.lang.CharSequence mDescription;
        private android.os.Bundle mExtras;
        private android.graphics.Bitmap mIcon;
        private android.net.Uri mIconUri;
        private java.lang.String mMediaId;
        private android.net.Uri mMediaUri;
        private java.lang.CharSequence mSubtitle;
        private java.lang.CharSequence mTitle;

        public android.support.v4.media.MediaDescriptionCompat build() {
            return new android.support.v4.media.MediaDescriptionCompat(this.mMediaId, this.mTitle, this.mSubtitle, this.mDescription, this.mIcon, this.mIconUri, this.mExtras, this.mMediaUri);
        }

        public android.support.v4.media.MediaDescriptionCompat.Builder setDescription(@android.support.annotation.Nullable java.lang.CharSequence charSequence) {
            this.mDescription = charSequence;
            return this;
        }

        public android.support.v4.media.MediaDescriptionCompat.Builder setExtras(@android.support.annotation.Nullable android.os.Bundle bundle) {
            this.mExtras = bundle;
            return this;
        }

        public android.support.v4.media.MediaDescriptionCompat.Builder setIconBitmap(@android.support.annotation.Nullable android.graphics.Bitmap bitmap) {
            this.mIcon = bitmap;
            return this;
        }

        public android.support.v4.media.MediaDescriptionCompat.Builder setIconUri(@android.support.annotation.Nullable android.net.Uri uri) {
            this.mIconUri = uri;
            return this;
        }

        public android.support.v4.media.MediaDescriptionCompat.Builder setMediaId(@android.support.annotation.Nullable java.lang.String str) {
            this.mMediaId = str;
            return this;
        }

        public android.support.v4.media.MediaDescriptionCompat.Builder setMediaUri(@android.support.annotation.Nullable android.net.Uri uri) {
            this.mMediaUri = uri;
            return this;
        }

        public android.support.v4.media.MediaDescriptionCompat.Builder setSubtitle(@android.support.annotation.Nullable java.lang.CharSequence charSequence) {
            this.mSubtitle = charSequence;
            return this;
        }

        public android.support.v4.media.MediaDescriptionCompat.Builder setTitle(@android.support.annotation.Nullable java.lang.CharSequence charSequence) {
            this.mTitle = charSequence;
            return this;
        }
    }

    MediaDescriptionCompat(android.os.Parcel parcel) {
        this.mMediaId = parcel.readString();
        this.mTitle = (java.lang.CharSequence) android.text.TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mSubtitle = (java.lang.CharSequence) android.text.TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mDescription = (java.lang.CharSequence) android.text.TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mIcon = (android.graphics.Bitmap) parcel.readParcelable(null);
        this.mIconUri = (android.net.Uri) parcel.readParcelable(null);
        this.mExtras = parcel.readBundle();
        this.mMediaUri = (android.net.Uri) parcel.readParcelable(null);
    }

    MediaDescriptionCompat(java.lang.String str, java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3, android.graphics.Bitmap bitmap, android.net.Uri uri, android.os.Bundle bundle, android.net.Uri uri2) {
        this.mMediaId = str;
        this.mTitle = charSequence;
        this.mSubtitle = charSequence2;
        this.mDescription = charSequence3;
        this.mIcon = bitmap;
        this.mIconUri = uri;
        this.mExtras = bundle;
        this.mMediaUri = uri2;
    }

    public static android.support.v4.media.MediaDescriptionCompat fromMediaDescription(java.lang.Object obj) {
        android.os.Bundle bundle = null;
        if (obj == null || android.os.Build.VERSION.SDK_INT < 21) {
            return null;
        }
        android.support.v4.media.MediaDescriptionCompat.Builder builder = new android.support.v4.media.MediaDescriptionCompat.Builder();
        builder.setMediaId(android.support.v4.media.MediaDescriptionCompatApi21.getMediaId(obj));
        builder.setTitle(android.support.v4.media.MediaDescriptionCompatApi21.getTitle(obj));
        builder.setSubtitle(android.support.v4.media.MediaDescriptionCompatApi21.getSubtitle(obj));
        builder.setDescription(android.support.v4.media.MediaDescriptionCompatApi21.getDescription(obj));
        builder.setIconBitmap(android.support.v4.media.MediaDescriptionCompatApi21.getIconBitmap(obj));
        builder.setIconUri(android.support.v4.media.MediaDescriptionCompatApi21.getIconUri(obj));
        android.os.Bundle extras = android.support.v4.media.MediaDescriptionCompatApi21.getExtras(obj);
        android.net.Uri uri = extras == null ? null : (android.net.Uri) extras.getParcelable(DESCRIPTION_KEY_MEDIA_URI);
        if (uri == null) {
            bundle = extras;
        } else if (!extras.containsKey(DESCRIPTION_KEY_NULL_BUNDLE_FLAG) || extras.size() != 2) {
            extras.remove(DESCRIPTION_KEY_MEDIA_URI);
            extras.remove(DESCRIPTION_KEY_NULL_BUNDLE_FLAG);
            bundle = extras;
        }
        builder.setExtras(bundle);
        if (uri != null) {
            builder.setMediaUri(uri);
        } else if (android.os.Build.VERSION.SDK_INT >= 23) {
            builder.setMediaUri(android.support.v4.media.MediaDescriptionCompatApi23.getMediaUri(obj));
        }
        android.support.v4.media.MediaDescriptionCompat mediaDescriptionCompatBuild = builder.build();
        mediaDescriptionCompatBuild.mDescriptionObj = obj;
        return mediaDescriptionCompatBuild;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @android.support.annotation.Nullable
    public java.lang.CharSequence getDescription() {
        return this.mDescription;
    }

    @android.support.annotation.Nullable
    public android.os.Bundle getExtras() {
        return this.mExtras;
    }

    @android.support.annotation.Nullable
    public android.graphics.Bitmap getIconBitmap() {
        return this.mIcon;
    }

    @android.support.annotation.Nullable
    public android.net.Uri getIconUri() {
        return this.mIconUri;
    }

    public java.lang.Object getMediaDescription() {
        if (this.mDescriptionObj != null || android.os.Build.VERSION.SDK_INT < 21) {
            return this.mDescriptionObj;
        }
        java.lang.Object objNewInstance = android.support.v4.media.MediaDescriptionCompatApi21.Builder.newInstance();
        android.support.v4.media.MediaDescriptionCompatApi21.Builder.setMediaId(objNewInstance, this.mMediaId);
        android.support.v4.media.MediaDescriptionCompatApi21.Builder.setTitle(objNewInstance, this.mTitle);
        android.support.v4.media.MediaDescriptionCompatApi21.Builder.setSubtitle(objNewInstance, this.mSubtitle);
        android.support.v4.media.MediaDescriptionCompatApi21.Builder.setDescription(objNewInstance, this.mDescription);
        android.support.v4.media.MediaDescriptionCompatApi21.Builder.setIconBitmap(objNewInstance, this.mIcon);
        android.support.v4.media.MediaDescriptionCompatApi21.Builder.setIconUri(objNewInstance, this.mIconUri);
        android.os.Bundle bundle = this.mExtras;
        if (android.os.Build.VERSION.SDK_INT < 23 && this.mMediaUri != null) {
            if (bundle == null) {
                bundle = new android.os.Bundle();
                bundle.putBoolean(DESCRIPTION_KEY_NULL_BUNDLE_FLAG, true);
            }
            bundle.putParcelable(DESCRIPTION_KEY_MEDIA_URI, this.mMediaUri);
        }
        android.support.v4.media.MediaDescriptionCompatApi21.Builder.setExtras(objNewInstance, bundle);
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            android.support.v4.media.MediaDescriptionCompatApi23.Builder.setMediaUri(objNewInstance, this.mMediaUri);
        }
        this.mDescriptionObj = android.support.v4.media.MediaDescriptionCompatApi21.Builder.build(objNewInstance);
        return this.mDescriptionObj;
    }

    @android.support.annotation.Nullable
    public java.lang.String getMediaId() {
        return this.mMediaId;
    }

    @android.support.annotation.Nullable
    public android.net.Uri getMediaUri() {
        return this.mMediaUri;
    }

    @android.support.annotation.Nullable
    public java.lang.CharSequence getSubtitle() {
        return this.mSubtitle;
    }

    @android.support.annotation.Nullable
    public java.lang.CharSequence getTitle() {
        return this.mTitle;
    }

    public java.lang.String toString() {
        return ((java.lang.Object) this.mTitle) + ", " + ((java.lang.Object) this.mSubtitle) + ", " + ((java.lang.Object) this.mDescription);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            android.support.v4.media.MediaDescriptionCompatApi21.writeToParcel(getMediaDescription(), parcel, i);
            return;
        }
        parcel.writeString(this.mMediaId);
        android.text.TextUtils.writeToParcel(this.mTitle, parcel, i);
        android.text.TextUtils.writeToParcel(this.mSubtitle, parcel, i);
        android.text.TextUtils.writeToParcel(this.mDescription, parcel, i);
        parcel.writeParcelable(this.mIcon, i);
        parcel.writeParcelable(this.mIconUri, i);
        parcel.writeBundle(this.mExtras);
        parcel.writeParcelable(this.mMediaUri, i);
    }
}
