package com.tencent.smtt.export.external.interfaces;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface MediaAccessPermissionsCallback {
    public static final long ALLOW_AUDIO_CAPTURE = 4;
    public static final long ALLOW_VIDEO_CAPTURE = 2;
    public static final long BITMASK_RESOURCE_AUDIO_CAPTURE = 4;
    public static final long BITMASK_RESOURCE_VIDEO_CAPTURE = 2;

    void invoke(java.lang.String str, long j, boolean z);
}
