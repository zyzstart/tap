package android.support.v4.media;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class VolumeProviderCompat {
    public static final int VOLUME_CONTROL_ABSOLUTE = 2;
    public static final int VOLUME_CONTROL_FIXED = 0;
    public static final int VOLUME_CONTROL_RELATIVE = 1;
    private android.support.v4.media.VolumeProviderCompat.Callback mCallback;
    private final int mControlType;
    private int mCurrentVolume;
    private final int mMaxVolume;
    private java.lang.Object mVolumeProviderObj;

    public static abstract class Callback {
        public abstract void onVolumeChanged(android.support.v4.media.VolumeProviderCompat volumeProviderCompat);
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface ControlType {
    }

    public VolumeProviderCompat(int i, int i2, int i3) {
        this.mControlType = i;
        this.mMaxVolume = i2;
        this.mCurrentVolume = i3;
    }

    public final int getCurrentVolume() {
        return this.mCurrentVolume;
    }

    public final int getMaxVolume() {
        return this.mMaxVolume;
    }

    public final int getVolumeControl() {
        return this.mControlType;
    }

    public java.lang.Object getVolumeProvider() {
        if (this.mVolumeProviderObj == null && android.os.Build.VERSION.SDK_INT >= 21) {
            this.mVolumeProviderObj = android.support.v4.media.VolumeProviderCompatApi21.createVolumeProvider(this.mControlType, this.mMaxVolume, this.mCurrentVolume, new android.support.v4.media.VolumeProviderCompatApi21.Delegate() { // from class: android.support.v4.media.VolumeProviderCompat.1
                @Override // android.support.v4.media.VolumeProviderCompatApi21.Delegate
                public void onAdjustVolume(int i) {
                    android.support.v4.media.VolumeProviderCompat.this.onAdjustVolume(i);
                }

                @Override // android.support.v4.media.VolumeProviderCompatApi21.Delegate
                public void onSetVolumeTo(int i) {
                    android.support.v4.media.VolumeProviderCompat.this.onSetVolumeTo(i);
                }
            });
        }
        return this.mVolumeProviderObj;
    }

    public void onAdjustVolume(int i) {
    }

    public void onSetVolumeTo(int i) {
    }

    public void setCallback(android.support.v4.media.VolumeProviderCompat.Callback callback) {
        this.mCallback = callback;
    }

    public final void setCurrentVolume(int i) {
        this.mCurrentVolume = i;
        java.lang.Object volumeProvider = getVolumeProvider();
        if (volumeProvider != null && android.os.Build.VERSION.SDK_INT >= 21) {
            android.support.v4.media.VolumeProviderCompatApi21.setCurrentVolume(volumeProvider, i);
        }
        android.support.v4.media.VolumeProviderCompat.Callback callback = this.mCallback;
        if (callback != null) {
            callback.onVolumeChanged(this);
        }
    }
}
