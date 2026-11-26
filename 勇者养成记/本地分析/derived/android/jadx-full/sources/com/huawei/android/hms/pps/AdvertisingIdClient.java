package com.huawei.android.hms.pps;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.Keep
public class AdvertisingIdClient {

    @android.support.annotation.Keep
    public static final class Info {

        @android.support.annotation.Keep
        private final java.lang.String advertisingId;

        @android.support.annotation.Keep
        private final boolean limitAdTrackingEnabled;

        @android.support.annotation.Keep
        Info(java.lang.String str, boolean z) {
            this.advertisingId = str;
            this.limitAdTrackingEnabled = z;
        }

        @android.support.annotation.Keep
        public final native java.lang.String getId();

        @android.support.annotation.Keep
        public final native boolean isLimitAdTrackingEnabled();
    }

    @android.support.annotation.Keep
    public AdvertisingIdClient() {
    }

    @android.support.annotation.Keep
    public static native com.huawei.android.hms.pps.AdvertisingIdClient.Info getAdvertisingIdInfo(android.content.Context context);

    @android.support.annotation.Keep
    private static native java.lang.String getTag();
}
