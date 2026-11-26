package com.tencent.ysdk.shell.module.user.impl.freelogin.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class CloudGameRequestHelper {
    private static final java.lang.String BASE_URL = "[REDACTED]";
    private static final java.lang.String TEST_BASE_URL = "[REDACTED]";

    public static java.lang.String genReqUrl(java.lang.String str) {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        return java.lang.String.format(BASE_URL, str, java.lang.Long.valueOf(jCurrentTimeMillis), java.lang.Integer.valueOf(getHashTokenValue(jCurrentTimeMillis)));
    }

    public static int getHashTokenValue(long j) {
        int i;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        while (true) {
            if (j <= 0) {
                break;
            }
            arrayList.add(0, java.lang.Short.valueOf((short) (j % 10)));
            j /= 10;
        }
        int iShortValue = 5381;
        for (i = 0; i < arrayList.size(); i++) {
            iShortValue += (iShortValue << 5) + (((java.lang.Short) arrayList.get(i)).shortValue() - 48);
        }
        return iShortValue & android.support.v7.widget.ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    }
}
