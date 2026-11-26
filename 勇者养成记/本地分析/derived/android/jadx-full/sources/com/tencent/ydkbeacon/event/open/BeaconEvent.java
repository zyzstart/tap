package com.tencent.ydkbeacon.event.open;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class BeaconEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.lang.String f1261a;
    private java.lang.String b;
    private com.tencent.ydkbeacon.event.open.EventType c;
    private boolean d;
    private java.util.Map e;

    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private java.lang.String f1262a;
        private java.lang.String b;
        private com.tencent.ydkbeacon.event.open.EventType c;
        private boolean d;
        private java.util.Map e;

        private Builder() {
            this.c = com.tencent.ydkbeacon.event.open.EventType.NORMAL;
            this.d = true;
            this.e = new java.util.HashMap();
        }

        private Builder(com.tencent.ydkbeacon.event.open.BeaconEvent beaconEvent) {
            this.c = com.tencent.ydkbeacon.event.open.EventType.NORMAL;
            this.d = true;
            this.e = new java.util.HashMap();
            this.f1262a = beaconEvent.f1261a;
            this.b = beaconEvent.b;
            this.c = beaconEvent.c;
            this.d = beaconEvent.d;
            this.e.putAll(beaconEvent.e);
        }

        public com.tencent.ydkbeacon.event.open.BeaconEvent build() {
            java.lang.String strB = com.tencent.ydkbeacon.event.c.c.b(this.b);
            if (android.text.TextUtils.isEmpty(this.f1262a)) {
                this.f1262a = com.tencent.ydkbeacon.a.c.c.d().f();
            }
            return new com.tencent.ydkbeacon.event.open.BeaconEvent(this.f1262a, strB, this.c, this.d, this.e);
        }

        public com.tencent.ydkbeacon.event.open.BeaconEvent.Builder withAppKey(java.lang.String str) {
            this.f1262a = str;
            return this;
        }

        public com.tencent.ydkbeacon.event.open.BeaconEvent.Builder withCode(java.lang.String str) {
            this.b = str;
            return this;
        }

        public com.tencent.ydkbeacon.event.open.BeaconEvent.Builder withIsSucceed(boolean z) {
            this.d = z;
            return this;
        }

        public com.tencent.ydkbeacon.event.open.BeaconEvent.Builder withParams(@android.support.annotation.NonNull java.lang.String str, java.lang.String str2) {
            this.e.put(str, str2);
            return this;
        }

        public com.tencent.ydkbeacon.event.open.BeaconEvent.Builder withParams(java.util.Map map) {
            if (map != null) {
                this.e.putAll(map);
            }
            return this;
        }

        public com.tencent.ydkbeacon.event.open.BeaconEvent.Builder withType(com.tencent.ydkbeacon.event.open.EventType eventType) {
            this.c = eventType;
            return this;
        }
    }

    private BeaconEvent(java.lang.String str, java.lang.String str2, com.tencent.ydkbeacon.event.open.EventType eventType, boolean z, java.util.Map map) {
        this.f1261a = str;
        this.b = str2;
        this.c = eventType;
        this.d = z;
        this.e = map;
    }

    public static com.tencent.ydkbeacon.event.open.BeaconEvent.Builder builder() {
        return new com.tencent.ydkbeacon.event.open.BeaconEvent.Builder();
    }

    public static com.tencent.ydkbeacon.event.open.BeaconEvent.Builder newBuilder(com.tencent.ydkbeacon.event.open.BeaconEvent beaconEvent) {
        return new com.tencent.ydkbeacon.event.open.BeaconEvent.Builder();
    }

    public java.lang.String getAppKey() {
        return this.f1261a;
    }

    public java.lang.String getCode() {
        return this.b;
    }

    public java.util.Map getParams() {
        return this.e;
    }

    public com.tencent.ydkbeacon.event.open.EventType getType() {
        return this.c;
    }

    public boolean isRealtime() {
        com.tencent.ydkbeacon.event.open.EventType eventType = this.c;
        return eventType == com.tencent.ydkbeacon.event.open.EventType.DT_REALTIME || eventType == com.tencent.ydkbeacon.event.open.EventType.REALTIME;
    }

    public boolean isSucceed() {
        return this.d;
    }

    public void setAppKey(java.lang.String str) {
        this.f1261a = str;
    }

    public void setCode(java.lang.String str) {
        this.b = str;
    }

    public void setParams(java.util.Map map) {
        this.e = map;
    }

    public void setSucceed(boolean z) {
        this.d = z;
    }

    public void setType(com.tencent.ydkbeacon.event.open.EventType eventType) {
        this.c = eventType;
    }

    public java.lang.String toString() {
        return super.toString();
    }
}
