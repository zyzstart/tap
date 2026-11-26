package com.tencent.beacon.stat;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ModuleImpl extends com.tencent.beacon.core.c implements com.tencent.beacon.core.d.l {
    private static final java.lang.String KEY_COMMON_EVENT_CALLS = "common_event_calls";
    private static final java.lang.String KEY_COMMON_EVENT_WRITE_SUCC = "common_event_write_succ";
    private static final java.lang.String KEY_ON_QUA_DATE = "on_qua_date";
    private static final java.lang.String KEY_REAL_TIME_EVENT_CALLS = "real_time_event_calls";
    private static final java.lang.String KEY_REAL_TIME_EVENT_UPLOAD_SUCC = "real_time_event_upload_succ";
    private static final java.lang.String KEY_REAL_TIME_EVENT_WRITE_SUCC = "real_time_event_write_succ";
    private static int MAX_EVENT_CALLS_SYNC = 5;
    private static java.lang.String eventName = "rqd_up_qua";
    private static com.tencent.beacon.stat.ModuleImpl mInstance;
    private final java.util.concurrent.ConcurrentHashMap buffer;
    private com.tencent.beacon.stat.a commonEventCalls;
    private com.tencent.beacon.stat.a commonEventWriteSucc;
    private java.lang.Runnable doReadSyncTask;
    private java.lang.Runnable doWriteSyncTask;
    private com.tencent.beacon.stat.a eventCallsMod;
    private boolean eventSerialNumberEnable;
    public boolean isEnable;
    private int maxCnt;
    private com.tencent.beacon.stat.a onQuaDate;
    private com.tencent.beacon.stat.a quaSharedPrefs;
    private com.tencent.beacon.stat.a realTimeEventCalls;
    private com.tencent.beacon.stat.a realTimeEventUploadSucc;
    private com.tencent.beacon.stat.a realTimeEventWriteSucc;
    private int uploadCnt;

    private ModuleImpl(android.content.Context context) {
        super(context);
        this.isEnable = true;
        this.eventSerialNumberEnable = true;
        this.onQuaDate = new com.tencent.beacon.stat.a();
        this.commonEventCalls = new com.tencent.beacon.stat.a();
        this.realTimeEventCalls = new com.tencent.beacon.stat.a();
        this.commonEventWriteSucc = new com.tencent.beacon.stat.a();
        this.realTimeEventWriteSucc = new com.tencent.beacon.stat.a();
        this.realTimeEventUploadSucc = new com.tencent.beacon.stat.a();
        this.eventCallsMod = new com.tencent.beacon.stat.a();
        this.quaSharedPrefs = new com.tencent.beacon.stat.a();
        this.maxCnt = 5;
        this.doWriteSyncTask = new com.tencent.beacon.stat.e(this);
        this.doReadSyncTask = new com.tencent.beacon.stat.f(this);
        this.buffer = new java.util.concurrent.ConcurrentHashMap();
        this.eventCallsMod.a((byte) 0);
        com.tencent.beacon.core.a.d.a().a(this.doReadSyncTask);
        com.tencent.beacon.core.d.k.a(this.mContext).a(this);
    }

    private java.lang.String getBuffer() {
        java.util.concurrent.ConcurrentHashMap concurrentHashMap = this.buffer;
        if (concurrentHashMap == null || concurrentHashMap.size() <= 0) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.util.Map.Entry entry : this.buffer.entrySet()) {
            com.tencent.beacon.stat.g gVar = (com.tencent.beacon.stat.g) entry.getValue();
            sb.append(entry.getKey());
            sb.append(",");
            sb.append(gVar.c());
            sb.append(",");
            sb.append(gVar.b());
            sb.append(";");
        }
        return sb.toString();
    }

    private java.lang.String getDetailBuffer() {
        java.util.concurrent.ConcurrentHashMap concurrentHashMap = this.buffer;
        if (concurrentHashMap == null || concurrentHashMap.size() <= 0) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.util.Iterator it = this.buffer.entrySet().iterator();
        while (it.hasNext()) {
            for (com.tencent.beacon.stat.h hVar : ((com.tencent.beacon.stat.g) ((java.util.Map.Entry) it.next()).getValue()).a()) {
                sb.append(hVar.f221a);
                sb.append(",");
                sb.append(hVar.b);
                sb.append(",");
                sb.append(hVar.c ? "Y" : "N");
                sb.append(",");
                sb.append(hVar.d);
                sb.append(",");
                sb.append(hVar.e);
                sb.append(",");
                sb.append(hVar.f);
                sb.append(",");
                sb.append(hVar.g);
                sb.append(",");
                sb.append(hVar.h);
                sb.append(",");
                sb.append(hVar.i);
                sb.append(",");
                sb.append(hVar.j);
                sb.append(";");
            }
        }
        return sb.toString();
    }

    public static synchronized com.tencent.beacon.stat.ModuleImpl getInstance(android.content.Context context) {
        if (mInstance == null) {
            mInstance = new com.tencent.beacon.stat.ModuleImpl(context);
        }
        return mInstance;
    }

    private void incTotalCallsMod() {
        if (this.isEnable) {
            synchronized (this.eventCallsMod) {
                try {
                    byte bByteValue = (byte) (((java.lang.Byte) this.eventCallsMod.a()).byteValue() + 1);
                    if (bByteValue >= MAX_EVENT_CALLS_SYNC) {
                        com.tencent.beacon.core.a.d.a().a(this.doWriteSyncTask);
                        bByteValue = 0;
                    }
                    this.eventCallsMod.a(java.lang.Byte.valueOf(bByteValue));
                } catch (java.lang.Exception e) {
                    com.tencent.beacon.core.e.d.a(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetAllAnotherDay() {
        try {
            if (com.tencent.beacon.core.e.b.a().equals(this.onQuaDate.a())) {
                return;
            }
            this.onQuaDate.a(com.tencent.beacon.core.e.b.a());
            this.commonEventCalls.a(0L);
            this.realTimeEventCalls.a(0L);
            this.commonEventWriteSucc.a(0L);
            this.realTimeEventWriteSucc.a(0L);
            this.realTimeEventUploadSucc.a(0L);
            com.tencent.beacon.core.a.d.a().a(this.doWriteSyncTask);
        } catch (java.lang.Exception e) {
            com.tencent.beacon.core.e.d.a(e);
        }
    }

    @Override // com.tencent.beacon.core.d.l
    public java.lang.String getAppFirstInstallTime() {
        return this.eventSerialNumberEnable ? com.tencent.beacon.core.e.b.b(this.mContext) : "";
    }

    @Override // com.tencent.beacon.core.d.l
    public java.lang.String getEventSerialNumber(java.lang.String str, java.lang.String str2, boolean z) {
        if (this.eventSerialNumberEnable) {
            return com.tencent.beacon.stat.d.a(this.mContext, str).a(str2, z);
        }
        return null;
    }

    @Override // com.tencent.beacon.core.d.l
    public void incCommonEventCalls() {
        if (this.isEnable) {
            try {
                resetAllAnotherDay();
                this.commonEventCalls.a(java.lang.Long.valueOf(((java.lang.Long) this.commonEventCalls.a()).longValue() + 1));
                incTotalCallsMod();
            } catch (java.lang.Exception e) {
                com.tencent.beacon.core.e.d.a(e);
            }
        }
    }

    @Override // com.tencent.beacon.core.d.l
    public void incCommonEventWriteSucc(int i) {
        if (this.isEnable) {
            try {
                resetAllAnotherDay();
                this.commonEventWriteSucc.a(java.lang.Long.valueOf(((java.lang.Long) this.commonEventWriteSucc.a()).longValue() + ((long) i)));
                if (i > 1) {
                    com.tencent.beacon.core.a.d.a().a(this.doWriteSyncTask);
                }
            } catch (java.lang.Exception e) {
                com.tencent.beacon.core.e.d.a(e);
            }
        }
    }

    @Override // com.tencent.beacon.core.d.l
    public void incRealTimeEventCalls() {
        if (this.isEnable) {
            try {
                resetAllAnotherDay();
                this.realTimeEventCalls.a(java.lang.Long.valueOf(((java.lang.Long) this.realTimeEventCalls.a()).longValue() + 1));
                incTotalCallsMod();
            } catch (java.lang.Exception e) {
                com.tencent.beacon.core.e.d.a(e);
            }
        }
    }

    @Override // com.tencent.beacon.core.d.l
    public void incRealTimeEventUploadSucc(int i) {
        if (this.isEnable) {
            try {
                resetAllAnotherDay();
                this.realTimeEventUploadSucc.a(java.lang.Long.valueOf(((java.lang.Long) this.realTimeEventUploadSucc.a()).longValue() + ((long) i)));
                if (i > 1) {
                    com.tencent.beacon.core.a.d.a().a(this.doWriteSyncTask);
                }
            } catch (java.lang.Exception e) {
                com.tencent.beacon.core.e.d.a(e);
            }
        }
    }

    @Override // com.tencent.beacon.core.d.l
    public void incRealTimeEventWriteSucc(int i) {
        if (this.isEnable) {
            try {
                resetAllAnotherDay();
                this.realTimeEventWriteSucc.a(java.lang.Long.valueOf(((java.lang.Long) this.realTimeEventWriteSucc.a()).longValue() + ((long) i)));
                if (i > 1) {
                    com.tencent.beacon.core.a.d.a().a(this.doWriteSyncTask);
                }
            } catch (java.lang.Exception e) {
                com.tencent.beacon.core.e.d.a(e);
            }
        }
    }

    @Override // com.tencent.beacon.core.c
    public void onModuleStarted() {
        super.onModuleStarted();
        com.tencent.beacon.core.e.d.d("[module] stat module > %S", java.lang.Boolean.valueOf(this.isEnable));
    }

    @Override // com.tencent.beacon.core.c
    public void onModuleStrategyUpdated(int i, java.util.Map map) {
        super.onModuleStrategyUpdated(i, map);
        if (i != 1 || map == null || map.size() <= 0) {
            return;
        }
        this.isEnable = com.tencent.beacon.core.e.b.a((java.lang.String) map.get("upQa"), this.isEnable);
        this.eventSerialNumberEnable = com.tencent.beacon.core.e.b.a((java.lang.String) map.get("esnOnOff"), this.eventSerialNumberEnable);
    }

    @Override // com.tencent.beacon.core.d.l
    public synchronized void record(int i, boolean z, long j, long j2, int i2, int i3, java.lang.String str, java.lang.String str2, int i4, java.lang.String str3) {
        if (this.isEnable) {
            if (i != 0) {
                com.tencent.beacon.stat.g gVar = (com.tencent.beacon.stat.g) this.buffer.get(java.lang.Integer.valueOf(i));
                if (gVar != null) {
                    com.tencent.beacon.stat.h hVar = new com.tencent.beacon.stat.h();
                    if (z) {
                        gVar.c(gVar.c() + 1);
                    } else {
                        gVar.b(gVar.b() + 1);
                    }
                    hVar.b = i;
                    hVar.f221a = j;
                    if (j2 > 0 && i4 > 0) {
                        hVar.d = ((int) j2) / i4;
                    }
                    hVar.e = i2;
                    hVar.f = i3;
                    hVar.g = str;
                    hVar.h = str2;
                    hVar.c = z;
                    hVar.i = i4;
                    hVar.j = str3;
                    gVar.a().add(hVar);
                } else {
                    com.tencent.beacon.stat.g gVar2 = new com.tencent.beacon.stat.g();
                    gVar2.a(i);
                    if (z) {
                        gVar2.c(1);
                    } else {
                        gVar2.b(1);
                    }
                    com.tencent.beacon.stat.h hVar2 = new com.tencent.beacon.stat.h();
                    hVar2.b = i;
                    hVar2.f221a = j;
                    if (j2 > 0 && i4 > 0) {
                        hVar2.d = ((int) j2) / i4;
                    }
                    hVar2.e = i2;
                    hVar2.f = i3;
                    hVar2.g = str;
                    hVar2.h = str2;
                    hVar2.c = z;
                    hVar2.i = i4;
                    hVar2.j = str3;
                    gVar2.a().add(hVar2);
                    this.buffer.put(java.lang.Integer.valueOf(i), gVar2);
                }
                int i5 = this.uploadCnt + 1;
                this.uploadCnt = i5;
                if (i5 >= this.maxCnt) {
                    java.util.HashMap map = new java.util.HashMap();
                    map.put("B1", this.uploadCnt + "");
                    map.put("B2", getBuffer());
                    map.put("B3", getDetailBuffer());
                    try {
                        map.put("B4", java.lang.String.valueOf(this.commonEventCalls.a()));
                        map.put("B5", java.lang.String.valueOf(this.realTimeEventCalls.a()));
                        map.put("B6", java.lang.String.valueOf(com.tencent.beacon.core.event.t.a(this.mContext, com.tencent.beacon.core.info.b.b(this.mContext).a())));
                        map.put("B7", java.lang.String.valueOf(this.realTimeEventUploadSucc.a()));
                        map.put("B8", java.lang.String.valueOf(this.realTimeEventWriteSucc.a()));
                        map.put("B9", java.lang.String.valueOf(this.commonEventWriteSucc.a()));
                        map.put("B10", java.lang.String.valueOf(((java.lang.String) this.onQuaDate.a()).replace("-", "")));
                    } catch (java.lang.InterruptedException e) {
                        com.tencent.beacon.core.e.d.a(e);
                    }
                    if (com.tencent.beacon.event.UserAction.onUserAction(eventName, true, 0L, 0L, map, true)) {
                        this.buffer.clear();
                        this.uploadCnt = 0;
                        this.maxCnt = 10;
                    }
                }
            }
        }
    }
}
