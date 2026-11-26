package com.tencent.ysdk.shell.module.cloud.tasks.wakeup;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class WakeUpTaskParameter {
    private static final java.lang.String TAG = "YSDK WakeUp parameter";
    private boolean isOpen;
    private com.tencent.ysdk.shell.module.cloud.tasks.wakeup.LastWakeUpInfo lastWakeUpInfo;
    private int wakeRetryTimes;
    private int wakeTimes;
    private long wakeYybMinVersion;
    private android.content.pm.PackageInfo yybPackageInfo;

    public WakeUpTaskParameter(boolean z, int i, int i2, long j, android.content.pm.PackageInfo packageInfo, com.tencent.ysdk.shell.module.cloud.tasks.wakeup.LastWakeUpInfo lastWakeUpInfo) {
        this.isOpen = z;
        this.wakeTimes = i;
        this.wakeRetryTimes = i2;
        this.wakeYybMinVersion = j;
        this.yybPackageInfo = packageInfo;
        this.lastWakeUpInfo = lastWakeUpInfo;
    }

    public int getLastWakeCount() {
        com.tencent.ysdk.shell.module.cloud.tasks.wakeup.LastWakeUpInfo lastWakeUpInfo = this.lastWakeUpInfo;
        if (lastWakeUpInfo == null) {
            return 0;
        }
        return lastWakeUpInfo.getLastWakeCount();
    }

    public int getWakeRetryTimes() {
        return this.wakeRetryTimes;
    }

    public boolean needWakeUp() {
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "needWakeUp");
        if (!this.isOpen) {
            com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "wakeup switch close");
            return false;
        }
        if (this.yybPackageInfo == null) {
            com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "my app not install");
            return false;
        }
        long longVersionCode = android.os.Build.VERSION.SDK_INT >= 28 ? this.yybPackageInfo.getLongVersionCode() : this.yybPackageInfo.versionCode;
        if (longVersionCode >= this.wakeYybMinVersion) {
            com.tencent.ysdk.shell.module.cloud.tasks.wakeup.LastWakeUpInfo lastWakeUpInfo = this.lastWakeUpInfo;
            return lastWakeUpInfo == null || !com.tencent.ysdk.shell.libware.util.CommonUtils.isToday(lastWakeUpInfo.getLastWakeTimeStamp()) || this.lastWakeUpInfo.getLastWakeCount() < this.wakeTimes;
        }
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "my app version " + longVersionCode + " , min version " + this.wakeYybMinVersion);
        return false;
    }
}
