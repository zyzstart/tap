package android.support.v4.media;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RequiresApi(21)
class AudioAttributesCompatApi21 {
    private static final java.lang.String TAG = "AudioAttributesCompat";
    private static java.lang.reflect.Method sAudioAttributesToLegacyStreamType;

    static final class Wrapper {
        private android.media.AudioAttributes mWrapped;

        private Wrapper(android.media.AudioAttributes audioAttributes) {
            this.mWrapped = audioAttributes;
        }

        public static android.support.v4.media.AudioAttributesCompatApi21.Wrapper wrap(@android.support.annotation.NonNull android.media.AudioAttributes audioAttributes) {
            if (audioAttributes != null) {
                return new android.support.v4.media.AudioAttributesCompatApi21.Wrapper(audioAttributes);
            }
            throw new java.lang.IllegalArgumentException("AudioAttributesApi21.Wrapper cannot wrap null");
        }

        public android.media.AudioAttributes unwrap() {
            return this.mWrapped;
        }
    }

    AudioAttributesCompatApi21() {
    }

    public static int toLegacyStreamType(android.support.v4.media.AudioAttributesCompatApi21.Wrapper wrapper) {
        android.media.AudioAttributes audioAttributesUnwrap = wrapper.unwrap();
        try {
            if (sAudioAttributesToLegacyStreamType == null) {
                sAudioAttributesToLegacyStreamType = android.media.AudioAttributes.class.getMethod("toLegacyStreamType", android.media.AudioAttributes.class);
            }
            return ((java.lang.Integer) sAudioAttributesToLegacyStreamType.invoke(null, audioAttributesUnwrap)).intValue();
        } catch (java.lang.ClassCastException | java.lang.IllegalAccessException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException e) {
            android.util.Log.w(TAG, "getLegacyStreamType() failed on API21+", e);
            return -1;
        }
    }
}
