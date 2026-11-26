package com.tencent.assistant.sdk.remote;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class SDKConst {
    public static final java.lang.String COMMAND_REALTED_UPDATE_DOWNLOAD = "cmd_updatedownload";
    public static final int IPC_REGISTE_FAIL = 2;
    public static final int IPC_UNREGISTE_FAIL = 2;
    public static final java.lang.String KEY_REALTED_COMMAND = "command";
    public static final java.lang.String KEY_REALTED_URL = "relatedurl";
    public static final java.lang.String QQDOWNLOADER_FIRST_START_ACTION_NAME = "com.tencent.assistant.ipc.firststart.action";
    public static final int REQUEST_TYPE_APPDETAIL_PAUSE = 4;
    public static final int REQUEST_TYPE_APPDETAIL_START = 1;
    public static final int REQUEST_TYPE_AUTHORIZED = 3;
    public static final int REQUEST_TYPE_DOWNLOADLIST_PAUSE = 5;
    public static final int REQUEST_TYPE_DOWNLOADLIST_START = 2;
    public static final java.lang.String SDK_APILEVEL = "com.tencent.android.qqdownloader.sdk.apilevel";
    public static final java.lang.String SDK_RELATED_ACTION = "com.tencent.android.qqdownloader.action.RELATED";
    public static final java.lang.String SELF_PACKAGENAME = "com.tencent.android.qqdownloader";
    public static final java.lang.String SERVICE_NAME = "com.tencent.android.qqdownloader.SDKService";

    public interface DownloadState {
        public static final int DELETED = 9;
        public static final int DOWNLOADING = 1;
        public static final int FAIL = 3;
        public static final int INSTALLING = 8;
        public static final int PAUSED = 2;
        public static final int QUEUING = 6;
        public static final int SUCC = 4;
    }
}
