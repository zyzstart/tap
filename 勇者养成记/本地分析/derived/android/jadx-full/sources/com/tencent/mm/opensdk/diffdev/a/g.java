package com.tencent.mm.opensdk.diffdev.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public enum g {
    UUID_EXPIRED(402),
    UUID_CANCELED(com.tencent.smtt.sdk.TbsListener.ErrorCode.INFO_MISS_SDKEXTENSION_JAR),
    UUID_SCANED(404),
    UUID_CONFIRM(com.tencent.smtt.sdk.TbsListener.ErrorCode.INFO_CAN_NOT_LOAD_TBS),
    UUID_KEEP_CONNECT(com.tencent.smtt.sdk.TbsListener.ErrorCode.INFO_CAN_NOT_DISABLED_BY_CRASH),
    UUID_ERROR(500);

    private int code;

    g(int i) {
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }

    @Override // java.lang.Enum
    public final java.lang.String toString() {
        return "UUIDStatusCode:" + this.code;
    }
}
