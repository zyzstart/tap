package android.support.v4.net;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class ConnectivityManagerCompat {
    private static final android.support.v4.net.ConnectivityManagerCompat.ConnectivityManagerCompatImpl IMPL;
    public static final int RESTRICT_BACKGROUND_STATUS_DISABLED = 1;
    public static final int RESTRICT_BACKGROUND_STATUS_ENABLED = 3;
    public static final int RESTRICT_BACKGROUND_STATUS_WHITELISTED = 2;

    @android.support.annotation.RequiresApi(16)
    static class ConnectivityManagerCompatApi16Impl extends android.support.v4.net.ConnectivityManagerCompat.ConnectivityManagerCompatBaseImpl {
        ConnectivityManagerCompatApi16Impl() {
        }

        @Override // android.support.v4.net.ConnectivityManagerCompat.ConnectivityManagerCompatBaseImpl, android.support.v4.net.ConnectivityManagerCompat.ConnectivityManagerCompatImpl
        public boolean isActiveNetworkMetered(android.net.ConnectivityManager connectivityManager) {
            return connectivityManager.isActiveNetworkMetered();
        }
    }

    @android.support.annotation.RequiresApi(24)
    static class ConnectivityManagerCompatApi24Impl extends android.support.v4.net.ConnectivityManagerCompat.ConnectivityManagerCompatApi16Impl {
        ConnectivityManagerCompatApi24Impl() {
        }

        @Override // android.support.v4.net.ConnectivityManagerCompat.ConnectivityManagerCompatBaseImpl, android.support.v4.net.ConnectivityManagerCompat.ConnectivityManagerCompatImpl
        public int getRestrictBackgroundStatus(android.net.ConnectivityManager connectivityManager) {
            return connectivityManager.getRestrictBackgroundStatus();
        }
    }

    static class ConnectivityManagerCompatBaseImpl implements android.support.v4.net.ConnectivityManagerCompat.ConnectivityManagerCompatImpl {
        ConnectivityManagerCompatBaseImpl() {
        }

        @Override // android.support.v4.net.ConnectivityManagerCompat.ConnectivityManagerCompatImpl
        public int getRestrictBackgroundStatus(android.net.ConnectivityManager connectivityManager) {
            return 3;
        }

        @Override // android.support.v4.net.ConnectivityManagerCompat.ConnectivityManagerCompatImpl
        public boolean isActiveNetworkMetered(android.net.ConnectivityManager connectivityManager) {
            android.net.NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return true;
            }
            switch (activeNetworkInfo.getType()) {
                case 0:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    return true;
                case 1:
                case 7:
                case 9:
                    return false;
                case 8:
                default:
                    return true;
            }
        }
    }

    interface ConnectivityManagerCompatImpl {
        int getRestrictBackgroundStatus(android.net.ConnectivityManager connectivityManager);

        boolean isActiveNetworkMetered(android.net.ConnectivityManager connectivityManager);
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface RestrictBackgroundStatus {
    }

    static {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            IMPL = new android.support.v4.net.ConnectivityManagerCompat.ConnectivityManagerCompatApi24Impl();
        } else if (android.os.Build.VERSION.SDK_INT >= 16) {
            IMPL = new android.support.v4.net.ConnectivityManagerCompat.ConnectivityManagerCompatApi16Impl();
        } else {
            IMPL = new android.support.v4.net.ConnectivityManagerCompat.ConnectivityManagerCompatBaseImpl();
        }
    }

    private ConnectivityManagerCompat() {
    }

    public static android.net.NetworkInfo getNetworkInfoFromBroadcast(android.net.ConnectivityManager connectivityManager, android.content.Intent intent) {
        android.net.NetworkInfo networkInfo = (android.net.NetworkInfo) intent.getParcelableExtra("networkInfo");
        if (networkInfo != null) {
            return connectivityManager.getNetworkInfo(networkInfo.getType());
        }
        return null;
    }

    public static int getRestrictBackgroundStatus(android.net.ConnectivityManager connectivityManager) {
        return IMPL.getRestrictBackgroundStatus(connectivityManager);
    }

    @android.support.annotation.RequiresPermission(com.unisound.client.SpeechConstants.PERMISSION_ACCESS_NETWORK_STATE)
    public static boolean isActiveNetworkMetered(android.net.ConnectivityManager connectivityManager) {
        return IMPL.isActiveNetworkMetered(connectivityManager);
    }
}
