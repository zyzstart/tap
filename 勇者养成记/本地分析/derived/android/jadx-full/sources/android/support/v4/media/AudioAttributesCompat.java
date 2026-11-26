package android.support.v4.media;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class AudioAttributesCompat {
    public static final int CONTENT_TYPE_MOVIE = 3;
    public static final int CONTENT_TYPE_MUSIC = 2;
    public static final int CONTENT_TYPE_SONIFICATION = 4;
    public static final int CONTENT_TYPE_SPEECH = 1;
    public static final int CONTENT_TYPE_UNKNOWN = 0;
    private static final int FLAG_ALL = 1023;
    private static final int FLAG_ALL_PUBLIC = 273;
    public static final int FLAG_AUDIBILITY_ENFORCED = 1;
    private static final int FLAG_BEACON = 8;
    private static final int FLAG_BYPASS_INTERRUPTION_POLICY = 64;
    private static final int FLAG_BYPASS_MUTE = 128;
    private static final int FLAG_DEEP_BUFFER = 512;
    public static final int FLAG_HW_AV_SYNC = 16;
    private static final int FLAG_HW_HOTWORD = 32;
    private static final int FLAG_LOW_LATENCY = 256;
    private static final int FLAG_SCO = 4;
    private static final int FLAG_SECURE = 2;
    private static final int[] SDK_USAGES;
    private static final int SUPPRESSIBLE_CALL = 2;
    private static final int SUPPRESSIBLE_NOTIFICATION = 1;
    private static final android.util.SparseIntArray SUPPRESSIBLE_USAGES = new android.util.SparseIntArray();
    private static final java.lang.String TAG = "AudioAttributesCompat";
    public static final int USAGE_ALARM = 4;
    public static final int USAGE_ASSISTANCE_ACCESSIBILITY = 11;
    public static final int USAGE_ASSISTANCE_NAVIGATION_GUIDANCE = 12;
    public static final int USAGE_ASSISTANCE_SONIFICATION = 13;
    public static final int USAGE_ASSISTANT = 16;
    public static final int USAGE_GAME = 14;
    public static final int USAGE_MEDIA = 1;
    public static final int USAGE_NOTIFICATION = 5;
    public static final int USAGE_NOTIFICATION_COMMUNICATION_DELAYED = 9;
    public static final int USAGE_NOTIFICATION_COMMUNICATION_INSTANT = 8;
    public static final int USAGE_NOTIFICATION_COMMUNICATION_REQUEST = 7;
    public static final int USAGE_NOTIFICATION_EVENT = 10;
    public static final int USAGE_NOTIFICATION_RINGTONE = 6;
    public static final int USAGE_UNKNOWN = 0;
    private static final int USAGE_VIRTUAL_SOURCE = 15;
    public static final int USAGE_VOICE_COMMUNICATION = 2;
    public static final int USAGE_VOICE_COMMUNICATION_SIGNALLING = 3;
    private static boolean sForceLegacyBehavior;
    private android.support.v4.media.AudioAttributesCompatApi21.Wrapper mAudioAttributesWrapper;
    int mContentType;
    int mFlags;
    java.lang.Integer mLegacyStream;
    int mUsage;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface AttributeContentType {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface AttributeUsage {
    }

    private static abstract class AudioManagerHidden {
        public static final int STREAM_ACCESSIBILITY = 10;
        public static final int STREAM_BLUETOOTH_SCO = 6;
        public static final int STREAM_SYSTEM_ENFORCED = 7;
        public static final int STREAM_TTS = 9;

        private AudioManagerHidden() {
        }
    }

    public static class Builder {
        private java.lang.Object mAAObject;
        private int mContentType;
        private int mFlags;
        private java.lang.Integer mLegacyStream;
        private int mUsage;

        public Builder() {
            this.mUsage = 0;
            this.mContentType = 0;
            this.mFlags = 0;
        }

        public Builder(android.support.v4.media.AudioAttributesCompat audioAttributesCompat) {
            this.mUsage = 0;
            this.mContentType = 0;
            this.mFlags = 0;
            this.mUsage = audioAttributesCompat.mUsage;
            this.mContentType = audioAttributesCompat.mContentType;
            this.mFlags = audioAttributesCompat.mFlags;
            this.mLegacyStream = audioAttributesCompat.mLegacyStream;
            this.mAAObject = audioAttributesCompat.unwrap();
        }

        public android.support.v4.media.AudioAttributesCompat build() {
            if (android.support.v4.media.AudioAttributesCompat.sForceLegacyBehavior || android.os.Build.VERSION.SDK_INT < 21) {
                android.support.v4.media.AudioAttributesCompat audioAttributesCompat = new android.support.v4.media.AudioAttributesCompat();
                audioAttributesCompat.mContentType = this.mContentType;
                audioAttributesCompat.mFlags = this.mFlags;
                audioAttributesCompat.mUsage = this.mUsage;
                audioAttributesCompat.mLegacyStream = this.mLegacyStream;
                audioAttributesCompat.mAudioAttributesWrapper = null;
                return audioAttributesCompat;
            }
            java.lang.Object obj = this.mAAObject;
            if (obj != null) {
                return android.support.v4.media.AudioAttributesCompat.wrap(obj);
            }
            android.media.AudioAttributes.Builder usage = new android.media.AudioAttributes.Builder().setContentType(this.mContentType).setFlags(this.mFlags).setUsage(this.mUsage);
            java.lang.Integer num = this.mLegacyStream;
            if (num != null) {
                usage.setLegacyStreamType(num.intValue());
            }
            return android.support.v4.media.AudioAttributesCompat.wrap(usage.build());
        }

        public android.support.v4.media.AudioAttributesCompat.Builder setContentType(int i) {
            switch (i) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                    this.mContentType = i;
                    return this;
                default:
                    this.mUsage = 0;
                    return this;
            }
        }

        public android.support.v4.media.AudioAttributesCompat.Builder setFlags(int i) {
            this.mFlags = (i & 1023) | this.mFlags;
            return this;
        }

        public android.support.v4.media.AudioAttributesCompat.Builder setLegacyStreamType(int i) {
            if (i == 10) {
                throw new java.lang.IllegalArgumentException("STREAM_ACCESSIBILITY is not a legacy stream type that was used for audio playback");
            }
            this.mLegacyStream = java.lang.Integer.valueOf(i);
            this.mUsage = android.support.v4.media.AudioAttributesCompat.usageForStreamType(i);
            return this;
        }

        public android.support.v4.media.AudioAttributesCompat.Builder setUsage(int i) {
            switch (i) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                    this.mUsage = i;
                    return this;
                case 16:
                    if (android.support.v4.media.AudioAttributesCompat.sForceLegacyBehavior || android.os.Build.VERSION.SDK_INT <= 25) {
                        this.mUsage = 12;
                    } else {
                        this.mUsage = i;
                    }
                    return this;
                default:
                    this.mUsage = 0;
                    return this;
            }
        }
    }

    static {
        SUPPRESSIBLE_USAGES.put(5, 1);
        SUPPRESSIBLE_USAGES.put(6, 2);
        SUPPRESSIBLE_USAGES.put(7, 2);
        SUPPRESSIBLE_USAGES.put(8, 1);
        SUPPRESSIBLE_USAGES.put(9, 1);
        SUPPRESSIBLE_USAGES.put(10, 1);
        SDK_USAGES = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16};
    }

    private AudioAttributesCompat() {
        this.mUsage = 0;
        this.mContentType = 0;
        this.mFlags = 0;
    }

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public static void setForceLegacyBehavior(boolean z) {
        sForceLegacyBehavior = z;
    }

    static int toVolumeStreamType(boolean z, int i, int i2) {
        if ((i & 1) == 1) {
            return z ? 1 : 7;
        }
        if ((i & 4) == 4) {
            return z ? 0 : 6;
        }
        switch (i2) {
            case 0:
                return z ? Integer.MIN_VALUE : 3;
            case 1:
            case 12:
            case 14:
            case 16:
                return 3;
            case 2:
                return 0;
            case 3:
                return z ? 0 : 8;
            case 4:
                return 4;
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            case 11:
                return 10;
            case 13:
                return 1;
            case 15:
            default:
                if (!z) {
                    return 3;
                }
                throw new java.lang.IllegalArgumentException("Unknown usage value " + i2 + " in audio attributes");
        }
    }

    static int toVolumeStreamType(boolean z, android.support.v4.media.AudioAttributesCompat audioAttributesCompat) {
        return toVolumeStreamType(z, audioAttributesCompat.getFlags(), audioAttributesCompat.getUsage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int usageForStreamType(int i) {
        switch (i) {
            case 0:
                return 2;
            case 1:
            case 7:
                return 13;
            case 2:
                return 6;
            case 3:
                return 1;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 2;
            case 8:
                return 3;
            case 9:
            default:
                return 0;
            case 10:
                return 11;
        }
    }

    static java.lang.String usageToString(int i) {
        switch (i) {
            case 0:
                return new java.lang.String("USAGE_UNKNOWN");
            case 1:
                return new java.lang.String("USAGE_MEDIA");
            case 2:
                return new java.lang.String("USAGE_VOICE_COMMUNICATION");
            case 3:
                return new java.lang.String("USAGE_VOICE_COMMUNICATION_SIGNALLING");
            case 4:
                return new java.lang.String("USAGE_ALARM");
            case 5:
                return new java.lang.String("USAGE_NOTIFICATION");
            case 6:
                return new java.lang.String("USAGE_NOTIFICATION_RINGTONE");
            case 7:
                return new java.lang.String("USAGE_NOTIFICATION_COMMUNICATION_REQUEST");
            case 8:
                return new java.lang.String("USAGE_NOTIFICATION_COMMUNICATION_INSTANT");
            case 9:
                return new java.lang.String("USAGE_NOTIFICATION_COMMUNICATION_DELAYED");
            case 10:
                return new java.lang.String("USAGE_NOTIFICATION_EVENT");
            case 11:
                return new java.lang.String("USAGE_ASSISTANCE_ACCESSIBILITY");
            case 12:
                return new java.lang.String("USAGE_ASSISTANCE_NAVIGATION_GUIDANCE");
            case 13:
                return new java.lang.String("USAGE_ASSISTANCE_SONIFICATION");
            case 14:
                return new java.lang.String("USAGE_GAME");
            case 15:
            default:
                return new java.lang.String("unknown usage " + i);
            case 16:
                return new java.lang.String("USAGE_ASSISTANT");
        }
    }

    @android.support.annotation.Nullable
    public static android.support.v4.media.AudioAttributesCompat wrap(@android.support.annotation.NonNull java.lang.Object obj) {
        if (android.os.Build.VERSION.SDK_INT < 21 || sForceLegacyBehavior) {
            return null;
        }
        android.support.v4.media.AudioAttributesCompat audioAttributesCompat = new android.support.v4.media.AudioAttributesCompat();
        audioAttributesCompat.mAudioAttributesWrapper = android.support.v4.media.AudioAttributesCompatApi21.Wrapper.wrap((android.media.AudioAttributes) obj);
        return audioAttributesCompat;
    }

    public boolean equals(java.lang.Object obj) {
        android.support.v4.media.AudioAttributesCompatApi21.Wrapper wrapper;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        android.support.v4.media.AudioAttributesCompat audioAttributesCompat = (android.support.v4.media.AudioAttributesCompat) obj;
        if (android.os.Build.VERSION.SDK_INT >= 21 && !sForceLegacyBehavior && (wrapper = this.mAudioAttributesWrapper) != null) {
            return wrapper.unwrap().equals(audioAttributesCompat.unwrap());
        }
        if (this.mContentType == audioAttributesCompat.getContentType() && this.mFlags == audioAttributesCompat.getFlags() && this.mUsage == audioAttributesCompat.getUsage()) {
            java.lang.Integer num = this.mLegacyStream;
            if (num != null) {
                if (num.equals(audioAttributesCompat.mLegacyStream)) {
                    return true;
                }
            } else if (audioAttributesCompat.mLegacyStream == null) {
                return true;
            }
        }
        return false;
    }

    public int getContentType() {
        android.support.v4.media.AudioAttributesCompatApi21.Wrapper wrapper;
        return (android.os.Build.VERSION.SDK_INT < 21 || sForceLegacyBehavior || (wrapper = this.mAudioAttributesWrapper) == null) ? this.mContentType : wrapper.unwrap().getContentType();
    }

    public int getFlags() {
        android.support.v4.media.AudioAttributesCompatApi21.Wrapper wrapper;
        if (android.os.Build.VERSION.SDK_INT >= 21 && !sForceLegacyBehavior && (wrapper = this.mAudioAttributesWrapper) != null) {
            return wrapper.unwrap().getFlags();
        }
        int i = this.mFlags;
        int legacyStreamType = getLegacyStreamType();
        if (legacyStreamType == 6) {
            i |= 4;
        } else if (legacyStreamType == 7) {
            i |= 1;
        }
        return i & FLAG_ALL_PUBLIC;
    }

    public int getLegacyStreamType() {
        java.lang.Integer num = this.mLegacyStream;
        if (num != null) {
            return num.intValue();
        }
        return (android.os.Build.VERSION.SDK_INT < 21 || sForceLegacyBehavior) ? toVolumeStreamType(false, this.mFlags, this.mUsage) : android.support.v4.media.AudioAttributesCompatApi21.toLegacyStreamType(this.mAudioAttributesWrapper);
    }

    public int getUsage() {
        android.support.v4.media.AudioAttributesCompatApi21.Wrapper wrapper;
        return (android.os.Build.VERSION.SDK_INT < 21 || sForceLegacyBehavior || (wrapper = this.mAudioAttributesWrapper) == null) ? this.mUsage : wrapper.unwrap().getUsage();
    }

    public int getVolumeControlStream() {
        return (android.os.Build.VERSION.SDK_INT < 26 || sForceLegacyBehavior || unwrap() == null) ? toVolumeStreamType(true, this) : ((android.media.AudioAttributes) unwrap()).getVolumeControlStream();
    }

    public int hashCode() {
        android.support.v4.media.AudioAttributesCompatApi21.Wrapper wrapper;
        return (android.os.Build.VERSION.SDK_INT < 21 || sForceLegacyBehavior || (wrapper = this.mAudioAttributesWrapper) == null) ? java.util.Arrays.hashCode(new java.lang.Object[]{java.lang.Integer.valueOf(this.mContentType), java.lang.Integer.valueOf(this.mFlags), java.lang.Integer.valueOf(this.mUsage), this.mLegacyStream}) : wrapper.unwrap().hashCode();
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("AudioAttributesCompat:");
        if (unwrap() != null) {
            sb.append(" audioattributes=");
            sb.append(unwrap());
        } else {
            if (this.mLegacyStream != null) {
                sb.append(" stream=");
                sb.append(this.mLegacyStream);
                sb.append(" derived");
            }
            sb.append(" usage=");
            sb.append(usageToString());
            sb.append(" content=");
            sb.append(this.mContentType);
            sb.append(" flags=0x");
            sb.append(java.lang.Integer.toHexString(this.mFlags).toUpperCase());
        }
        return sb.toString();
    }

    @android.support.annotation.Nullable
    public java.lang.Object unwrap() {
        android.support.v4.media.AudioAttributesCompatApi21.Wrapper wrapper = this.mAudioAttributesWrapper;
        if (wrapper != null) {
            return wrapper.unwrap();
        }
        return null;
    }

    java.lang.String usageToString() {
        return usageToString(this.mUsage);
    }
}
