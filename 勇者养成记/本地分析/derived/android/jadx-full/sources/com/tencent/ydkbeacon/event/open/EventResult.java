package com.tencent.ydkbeacon.event.open;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class EventResult {
    public static final int ERROR_CODE_NAME_NULL = 106;
    public static final int ERROR_CODE_NOT_ENABLE = 102;
    public static final int ERROR_CODE_OFFER_FAIL = 103;
    public static final int ERROR_CODE_PREVENT = 100;
    public static final int ERROR_CODE_SAMPLE = 101;
    public static final int ERROR_CODE_SUCCESS = 0;
    public static final int ERROR_PARAMS_LONG = 105;
    public java.lang.String errMsg;
    public int errorCode;
    public long eventID;

    public static final class a {
        public static com.tencent.ydkbeacon.event.open.EventResult a(int i) {
            switch (i) {
                case 100:
                    return new com.tencent.ydkbeacon.event.open.EventResult(i, -1L, "not allowed in strategy (false).");
                case 101:
                    return new com.tencent.ydkbeacon.event.open.EventResult(i, -1L, "sampled by svr rate (false).");
                case 102:
                    return new com.tencent.ydkbeacon.event.open.EventResult(i, -1L, "event report not enable!");
                case 103:
                    return new com.tencent.ydkbeacon.event.open.EventResult(i, -1L, "insert event to db error!");
                case 104:
                default:
                    return null;
                case 105:
                    return new com.tencent.ydkbeacon.event.open.EventResult(i, -1L, "event params length > 45K!");
                case 106:
                    return new com.tencent.ydkbeacon.event.open.EventResult(i, -1L, "event code isEmpty!");
            }
        }

        public static com.tencent.ydkbeacon.event.open.EventResult a(long j) {
            return new com.tencent.ydkbeacon.event.open.EventResult(0, j, null);
        }
    }

    public EventResult(int i, long j, java.lang.String str) {
        this.errorCode = i;
        this.eventID = j;
        this.errMsg = str;
    }

    public boolean isSuccess() {
        return this.errorCode == 0;
    }
}
