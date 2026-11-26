package com.tencent.ydkbeacon.event.open;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class BeaconConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f1259a;
    private final boolean b;
    private final boolean c;
    private final boolean d;
    private final boolean e;
    private final boolean f;
    private final boolean g;
    private final boolean h;
    private final long i;
    private final long j;
    private final com.tencent.ydkbeacon.base.net.adapter.c k;
    private java.lang.String l;
    private java.lang.String m;
    private boolean n;
    private boolean o;
    private boolean p;

    public static final class Builder {
        private java.util.concurrent.ScheduledExecutorService i;
        private com.tencent.ydkbeacon.base.net.adapter.c j;
        private long k;
        private long l;
        private java.lang.String m;
        private java.lang.String n;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f1260a = 10000;
        private boolean b = true;
        private boolean c = true;
        private boolean d = true;
        private boolean e = true;
        private boolean f = true;
        private boolean g = true;
        private boolean h = true;
        private boolean o = false;
        private boolean p = true;
        private boolean q = true;

        public com.tencent.ydkbeacon.event.open.BeaconConfig.Builder auditEnable(boolean z) {
            this.c = z;
            return this;
        }

        public com.tencent.ydkbeacon.event.open.BeaconConfig.Builder bidEnable(boolean z) {
            this.d = z;
            return this;
        }

        public com.tencent.ydkbeacon.event.open.BeaconConfig build() {
            java.util.concurrent.ScheduledExecutorService scheduledExecutorService = this.i;
            if (scheduledExecutorService != null) {
                com.tencent.ydkbeacon.a.b.a.a(scheduledExecutorService);
            }
            return new com.tencent.ydkbeacon.event.open.BeaconConfig(this.f1260a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.k, this.l, this.j, this.m, this.n, this.o, this.p, this.q);
        }

        public com.tencent.ydkbeacon.event.open.BeaconConfig.Builder collectAndroidIdEnable(boolean z) {
            this.g = z;
            return this;
        }

        public com.tencent.ydkbeacon.event.open.BeaconConfig.Builder collectIMEIEnable(boolean z) {
            this.f = z;
            return this;
        }

        public com.tencent.ydkbeacon.event.open.BeaconConfig.Builder collectMACEnable(boolean z) {
            this.e = z;
            return this;
        }

        public com.tencent.ydkbeacon.event.open.BeaconConfig.Builder collectProcessInfoEnable(boolean z) {
            this.h = z;
            return this;
        }

        public com.tencent.ydkbeacon.event.open.BeaconConfig.Builder eventReportEnable(boolean z) {
            this.b = z;
            return this;
        }

        public com.tencent.ydkbeacon.event.open.BeaconConfig.Builder maxDBCount(int i) {
            this.f1260a = i;
            return this;
        }

        public com.tencent.ydkbeacon.event.open.BeaconConfig.Builder pagePathEnable(boolean z) {
            this.q = z;
            return this;
        }

        public com.tencent.ydkbeacon.event.open.BeaconConfig.Builder qmspEnable(boolean z) {
            this.p = z;
            return this;
        }

        public com.tencent.ydkbeacon.event.open.BeaconConfig.Builder setConfigHost(java.lang.String str) {
            this.n = str;
            return this;
        }

        public com.tencent.ydkbeacon.event.open.BeaconConfig.Builder setExecutorService(java.util.concurrent.ScheduledExecutorService scheduledExecutorService) {
            this.i = scheduledExecutorService;
            return this;
        }

        public com.tencent.ydkbeacon.event.open.BeaconConfig.Builder setForceEnableAtta(boolean z) {
            this.o = z;
            return this;
        }

        public com.tencent.ydkbeacon.event.open.BeaconConfig.Builder setHttpAdapter(com.tencent.ydkbeacon.base.net.adapter.c cVar) {
            this.j = cVar;
            return this;
        }

        public com.tencent.ydkbeacon.event.open.BeaconConfig.Builder setNormalPollingTime(long j) {
            this.l = j;
            return this;
        }

        public com.tencent.ydkbeacon.event.open.BeaconConfig.Builder setRealtimePollingTime(long j) {
            this.k = j;
            return this;
        }

        public com.tencent.ydkbeacon.event.open.BeaconConfig.Builder setUploadHost(java.lang.String str) {
            this.m = str;
            return this;
        }
    }

    private BeaconConfig(int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, long j, long j2, com.tencent.ydkbeacon.base.net.adapter.c cVar, java.lang.String str, java.lang.String str2, boolean z8, boolean z9, boolean z10) {
        this.f1259a = i;
        this.b = z;
        this.c = z2;
        this.d = z3;
        this.e = z4;
        this.f = z5;
        this.g = z6;
        this.h = z7;
        this.i = j;
        this.j = j2;
        this.k = cVar;
        this.l = str;
        this.m = str2;
        this.n = z8;
        this.o = z9;
        this.p = z10;
    }

    public static com.tencent.ydkbeacon.event.open.BeaconConfig.Builder builder() {
        return new com.tencent.ydkbeacon.event.open.BeaconConfig.Builder();
    }

    public java.lang.String getConfigHost() {
        return this.m;
    }

    public com.tencent.ydkbeacon.base.net.adapter.c getHttpAdapter() {
        return this.k;
    }

    public int getMaxDBCount() {
        return this.f1259a;
    }

    public long getNormalPollingTIme() {
        return this.j;
    }

    public long getRealtimePollingTime() {
        return this.i;
    }

    public java.lang.String getUploadHost() {
        return this.l;
    }

    public boolean isAuditEnable() {
        return this.c;
    }

    public boolean isBidEnable() {
        return this.d;
    }

    public boolean isCollectAndroidIdEnable() {
        return this.g;
    }

    public boolean isCollectIMEIEnable() {
        return this.f;
    }

    public boolean isCollectMACEnable() {
        return this.e;
    }

    public boolean isCollectProcessInfoEnable() {
        return this.h;
    }

    public boolean isEnableQmsp() {
        return this.o;
    }

    public boolean isEventReportEnable() {
        return this.b;
    }

    public boolean isForceEnableAtta() {
        return this.n;
    }

    public boolean isPagePathEnable() {
        return this.p;
    }

    public java.lang.String toString() {
        return "BeaconConfig{maxDBCount=" + this.f1259a + ", eventReportEnable=" + this.b + ", auditEnable=" + this.c + ", bidEnable=" + this.d + ", collectMACEnable=" + this.e + ", collectIMEIEnable=" + this.f + ", collectAndroidIdEnable=" + this.g + ", collectProcessInfoEnable=" + this.h + ", realtimePollingTime=" + this.i + ", normalPollingTIme=" + this.j + ", httpAdapter=" + this.k + ", enableQmsp=" + this.o + ", forceEnableAtta=" + this.n + ", configHost=" + this.n + ", uploadHost=" + this.n + '}';
    }
}
