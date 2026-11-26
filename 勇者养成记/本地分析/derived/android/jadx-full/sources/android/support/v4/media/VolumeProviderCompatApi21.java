package android.support.v4.media;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RequiresApi(21)
class VolumeProviderCompatApi21 {

    public interface Delegate {
        void onAdjustVolume(int i);

        void onSetVolumeTo(int i);
    }

    VolumeProviderCompatApi21() {
    }

    public static java.lang.Object createVolumeProvider(int i, int i2, int i3, final android.support.v4.media.VolumeProviderCompatApi21.Delegate delegate) {
        return new android.media.VolumeProvider(i, i2, i3) { // from class: android.support.v4.media.VolumeProviderCompatApi21.1
            @Override // android.media.VolumeProvider
            public void onAdjustVolume(int i4) {
                delegate.onAdjustVolume(i4);
            }

            @Override // android.media.VolumeProvider
            public void onSetVolumeTo(int i4) {
                delegate.onSetVolumeTo(i4);
            }
        };
    }

    public static void setCurrentVolume(java.lang.Object obj, int i) {
        ((android.media.VolumeProvider) obj).setCurrentVolume(i);
    }
}
