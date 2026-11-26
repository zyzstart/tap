package com.tencent.beacon.core.event;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class EventStrategyBean {
    private static volatile com.tencent.beacon.core.event.EventStrategyBean mInstance;
    private int realNumUpload = com.tencent.beacon.upload.UploadStrategy.DEFAULT_REAL_NUM_UPLOAD;
    private int realDelayUpload = com.tencent.beacon.upload.UploadStrategy.DEFAULT_REAL_TIME_DELAY;
    private int comNumDB = com.tencent.beacon.upload.UploadStrategy.DEFAULT_COM_NUM_DB;
    private int comDelayDB = com.tencent.beacon.upload.UploadStrategy.DEFAULT_COMMON_DELAY;
    private int comNumUpload = com.tencent.beacon.upload.UploadStrategy.DEFAULT_COM_NUM_UPLOAD;
    private boolean comPollUp = com.tencent.beacon.upload.UploadStrategy.DEFAULT_COM_POLL_UP;
    private boolean heartbeatUsable = true;
    private java.util.Set preventEventCode = null;
    private java.util.Map sampleEvent = null;
    private boolean isTidyEventFields = false;
    private boolean isLaunchEventSimple = false;
    private int dailyConsumeLimit = 10485760;
    private boolean zeroPeakOnOff = false;
    private float zeroPeakRate = 1.0f;
    private boolean sensorEnable = com.tencent.beacon.upload.UploadStrategy.DEFAULT_SENSOR_ENABLE;
    private boolean acceleEnable = true;
    private boolean gyroEnable = true;
    private boolean magneticEnable = true;
    private int gatherCount = 1;
    private long gatherDur = 6400;
    private int hertzCount = 20;
    private int consuming = 300;
    private int uploadErrorBound = com.tencent.beacon.upload.UploadStrategy.defaultErrorRandomBound;
    private boolean strategyQuerySuccessDaxMax = false;
    private int strategyQuerySuccessDayMaxTimes = 1;

    public static synchronized com.tencent.beacon.core.event.EventStrategyBean getInstance() {
        if (mInstance == null) {
            mInstance = new com.tencent.beacon.core.event.EventStrategyBean();
        }
        return mInstance;
    }

    public synchronized int getComDelayDB() {
        return this.comDelayDB;
    }

    public synchronized int getComNumDB() {
        return this.comNumDB;
    }

    public synchronized int getComNumUpload() {
        return this.comNumUpload;
    }

    public synchronized int getConsuming() {
        return this.consuming;
    }

    public synchronized int getDailyConsumeLimit() {
        return this.dailyConsumeLimit;
    }

    public synchronized int getGatherCount() {
        return this.gatherCount;
    }

    public synchronized long getGatherDur() {
        return this.gatherDur;
    }

    public synchronized int getHertzCount() {
        return this.hertzCount;
    }

    public synchronized int getRealDelayUpload() {
        return this.realDelayUpload;
    }

    public synchronized int getRealNumUpload() {
        return this.realNumUpload;
    }

    public synchronized int getStrategyQuerySuccessDayMaxTimes() {
        return this.strategyQuerySuccessDayMaxTimes;
    }

    public synchronized boolean isAcceleEnable() {
        return this.acceleEnable;
    }

    public synchronized boolean isComPollUp() {
        return this.comPollUp;
    }

    public synchronized boolean isGyroEnable() {
        return this.gyroEnable;
    }

    public synchronized boolean isHeartbeatUsable() {
        return this.heartbeatUsable;
    }

    public synchronized boolean isInPreventEventCode(java.lang.String str) {
        boolean zContains;
        zContains = false;
        java.util.Set set = this.preventEventCode;
        if (set != null && set.size() > 0) {
            zContains = this.preventEventCode.contains(str);
        }
        return zContains;
    }

    public synchronized boolean isLaunchEventSimple() {
        return this.isLaunchEventSimple;
    }

    public synchronized boolean isMagneticEnable() {
        return this.magneticEnable;
    }

    public synchronized boolean isSensorEnable() {
        return this.sensorEnable;
    }

    public synchronized boolean isStrategyQuerySuccessDaxMax() {
        return this.strategyQuerySuccessDaxMax;
    }

    public synchronized boolean isTidyEventFields() {
        return this.isTidyEventFields;
    }

    public synchronized boolean isUploadByRate(java.lang.String str) {
        java.util.Map map = this.sampleEvent;
        if (map != null && map.get(str.toLowerCase()) != null) {
            return new java.util.Random().nextInt(1000) + 1 <= ((int) (((java.lang.Float) this.sampleEvent.get(str.toLowerCase())).floatValue() * 1000.0f));
        }
        return true;
    }

    public synchronized boolean isZeroPeakUploadByRate() {
        boolean z;
        z = true;
        if (this.zeroPeakOnOff) {
            java.util.Calendar calendar = java.util.Calendar.getInstance();
            int i = calendar.get(11);
            int i2 = calendar.get(12);
            if (i == 0 && i2 >= 0 && 30 >= i2) {
                if (new java.util.Random().nextInt(1000) + 1 > ((int) (this.zeroPeakRate * 1000.0f))) {
                    z = false;
                }
            }
        }
        return z;
    }

    public synchronized void setPreventEventCode(java.util.Set set) {
        com.tencent.beacon.core.e.d.a("setPreventEventCode.size = " + set.size(), new java.lang.Object[0]);
        this.preventEventCode = set;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void setSampleEvent(java.util.Set set) {
        com.tencent.beacon.core.e.d.a("setSampleEvent.size = " + set.size(), new java.lang.Object[0]);
        if (this.sampleEvent == null) {
            this.sampleEvent = new java.util.HashMap();
        }
        java.util.Iterator it = set.iterator();
        while (it.hasNext()) {
            java.lang.String[] strArrSplit = ((java.lang.String) it.next()).split(",");
            if (strArrSplit.length == 3) {
                try {
                    this.sampleEvent.put(strArrSplit[0].toLowerCase(), java.lang.Float.valueOf(java.lang.Float.valueOf(strArrSplit[1]).floatValue() / java.lang.Float.valueOf(strArrSplit[2]).floatValue()));
                } catch (java.lang.Exception unused) {
                }
            }
        }
    }

    public synchronized void updateConfig(java.util.Map map) {
        if (map != null) {
            try {
                this.realNumUpload = com.tencent.beacon.core.e.b.a((java.lang.String) map.get("realNumUp"), this.realNumUpload, 1, 50);
                this.realDelayUpload = com.tencent.beacon.core.e.b.a((java.lang.String) map.get("realDelayUp"), this.realDelayUpload, 10, com.tencent.tmassistantbase.common.download.TMAssistantDownloadErrorCode.DownloadSDKErrorCode_INTERRUPTED);
                this.comNumDB = com.tencent.beacon.core.e.b.a((java.lang.String) map.get("comNumDB"), this.comNumDB, 1, 50);
                this.comDelayDB = com.tencent.beacon.core.e.b.a((java.lang.String) map.get("comDelayDB"), this.comDelayDB, 30, com.tencent.tmassistantbase.common.download.TMAssistantDownloadErrorCode.DownloadSDKErrorCode_INTERRUPTED);
                this.comNumUpload = com.tencent.beacon.core.e.b.a((java.lang.String) map.get("comNumUp"), this.comNumUpload, 1, 100);
                this.heartbeatUsable = com.tencent.beacon.core.e.b.a((java.lang.String) map.get("heartOnOff"), this.heartbeatUsable);
                this.isTidyEventFields = com.tencent.beacon.core.e.b.a((java.lang.String) map.get("tidyEF"), this.isTidyEventFields);
                this.isLaunchEventSimple = com.tencent.beacon.core.e.b.a((java.lang.String) map.get("lauEveSim"), this.isLaunchEventSimple);
                this.comPollUp = com.tencent.beacon.core.e.b.a((java.lang.String) map.get("comPollUp"), this.comPollUp);
                this.dailyConsumeLimit = com.tencent.beacon.core.e.b.a((java.lang.String) map.get("dailyNetFlowLimit"), this.dailyConsumeLimit, 204800, 10485760);
                com.tencent.beacon.core.e.d.a(com.tencent.beacon.core.e.b.a((java.lang.String) map.get("accessTestOnOff"), com.tencent.beacon.core.e.d.a()));
                this.zeroPeakOnOff = com.tencent.beacon.core.e.b.a((java.lang.String) map.get("zeroPeakOnOff"), this.zeroPeakOnOff);
                java.lang.String str = (java.lang.String) map.get("zeroPeakRate");
                if (str != null) {
                    java.lang.String strTrim = str.trim();
                    if (strTrim.length() > 0) {
                        java.lang.String[] strArrSplit = strTrim.split(",");
                        if (strArrSplit.length == 2) {
                            try {
                                this.zeroPeakRate = java.lang.Float.valueOf(strArrSplit[0]).floatValue() / java.lang.Float.valueOf(strArrSplit[1]).floatValue();
                            } catch (java.lang.Exception unused) {
                            }
                        }
                    }
                }
                this.strategyQuerySuccessDaxMax = com.tencent.beacon.core.e.b.a((java.lang.String) map.get("straOnOff"), this.strategyQuerySuccessDaxMax);
                this.strategyQuerySuccessDayMaxTimes = com.tencent.beacon.core.e.b.a((java.lang.String) map.get("straDayMaxCount"), this.strategyQuerySuccessDayMaxTimes, 1, android.support.v7.widget.ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                if (this.realDelayUpload != com.tencent.beacon.upload.UploadStrategy.DEFAULT_REAL_TIME_DELAY) {
                    com.tencent.beacon.core.event.TunnelModule.getInstance().updateSchedule();
                }
                if (this.comDelayDB != com.tencent.beacon.upload.UploadStrategy.DEFAULT_COMMON_DELAY) {
                    com.tencent.beacon.core.event.TunnelModule.getInstance().updateSchedule();
                }
                this.sensorEnable = com.tencent.beacon.core.e.b.a((java.lang.String) map.get("sensorEnable"), this.sensorEnable);
                this.acceleEnable = com.tencent.beacon.core.e.b.a((java.lang.String) map.get("acceleEnable"), this.acceleEnable);
                this.gyroEnable = com.tencent.beacon.core.e.b.a((java.lang.String) map.get("gyroEnable"), this.gyroEnable);
                this.magneticEnable = com.tencent.beacon.core.e.b.a((java.lang.String) map.get("magneticEnable"), this.magneticEnable);
                this.gatherCount = com.tencent.beacon.core.e.b.a((java.lang.String) map.get("gatherCount"), this.gatherCount, 1, 50);
                this.gatherDur = com.tencent.beacon.core.e.b.a((java.lang.String) map.get("gatherDur"), this.gatherDur, 1000L, 20000L);
                this.hertzCount = com.tencent.beacon.core.e.b.a((java.lang.String) map.get("hertzCount"), this.hertzCount, 20, 100);
                this.consuming = com.tencent.beacon.core.e.b.a((java.lang.String) map.get("consuming"), this.consuming, 60, 86400);
                com.tencent.beacon.upload.UploadStrategy.DEFAULT_BEACON_ID_ENABLE = com.tencent.beacon.core.e.b.a((java.lang.String) map.get("beaconidEnable"), true);
                java.lang.String str2 = (java.lang.String) map.get("errorBound");
                if (str2 != null) {
                    com.tencent.beacon.core.d.i.a().a(com.tencent.beacon.core.e.b.a(str2, this.uploadErrorBound, 100, cn.yunzhisheng.asr.a.b));
                    com.tencent.beacon.core.d.i.a().a(this.uploadErrorBound);
                }
            } catch (java.lang.Exception e) {
                com.tencent.beacon.core.e.d.a(e);
            }
        }
    }
}
