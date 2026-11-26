package com.dodjoy.permissions;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class Permission {
    public static final java.lang.String ACCESS_COARSE_LOCATION = "android.permission.ACCESS_COARSE_LOCATION";
    public static final java.lang.String ACCESS_FINE_LOCATION = "android.permission.ACCESS_FINE_LOCATION";
    public static final java.lang.String ADD_VOICEMAIL = "com.android.voicemail.permission.ADD_VOICEMAIL";
    public static final java.lang.String ANSWER_PHONE_CALLS = "android.permission.ANSWER_PHONE_CALLS";
    public static final java.lang.String BODY_SENSORS = "android.permission.BODY_SENSORS";
    public static final java.lang.String CALL_PHONE = "android.permission.CALL_PHONE";
    public static final java.lang.String CAMERA = "android.permission.CAMERA";
    public static final java.lang.String GET_ACCOUNTS = "android.permission.GET_ACCOUNTS";
    public static final java.lang.String PROCESS_OUTGOING_CALLS = "android.permission.PROCESS_OUTGOING_CALLS";
    public static final java.lang.String READ_CALENDAR = "android.permission.READ_CALENDAR";
    public static final java.lang.String READ_CALL_LOG = "android.permission.READ_CALL_LOG";
    public static final java.lang.String READ_CONTACTS = "android.permission.READ_CONTACTS";
    public static final java.lang.String READ_EXTERNAL_STORAGE = "android.permission.READ_EXTERNAL_STORAGE";
    public static final java.lang.String READ_PHONE_NUMBERS = "android.permission.READ_PHONE_NUMBERS";
    public static final java.lang.String READ_PHONE_STATE = "android.permission.READ_PHONE_STATE";
    public static final java.lang.String READ_SMS = "android.permission.READ_SMS";
    public static final java.lang.String RECEIVE_MMS = "android.permission.RECEIVE_MMS";
    public static final java.lang.String RECEIVE_SMS = "android.permission.RECEIVE_SMS";
    public static final java.lang.String RECEIVE_WAP_PUSH = "android.permission.RECEIVE_WAP_PUSH";
    public static final java.lang.String RECORD_AUDIO = "android.permission.RECORD_AUDIO";
    public static final java.lang.String REQUEST_INSTALL_PACKAGES = "android.permission.REQUEST_INSTALL_PACKAGES";
    public static final java.lang.String SEND_SMS = "android.permission.SEND_SMS";
    public static final java.lang.String SYSTEM_ALERT_WINDOW = "android.permission.SYSTEM_ALERT_WINDOW";
    public static final java.lang.String USE_SIP = "android.permission.USE_SIP";
    public static final java.lang.String WRITE_CALENDAR = "android.permission.WRITE_CALENDAR";
    public static final java.lang.String WRITE_CALL_LOG = "android.permission.WRITE_CALL_LOG";
    public static final java.lang.String WRITE_CONTACTS = "android.permission.WRITE_CONTACTS";
    public static final java.lang.String WRITE_EXTERNAL_STORAGE = "android.permission.WRITE_EXTERNAL_STORAGE";

    public static final class Group {
        public static final java.lang.String[] CALENDAR = {com.dodjoy.permissions.Permission.READ_CALENDAR, com.dodjoy.permissions.Permission.WRITE_CALENDAR};
        public static final java.lang.String[] CONTACTS = {"android.permission.READ_CONTACTS", com.dodjoy.permissions.Permission.WRITE_CONTACTS, com.dodjoy.permissions.Permission.GET_ACCOUNTS};
        public static final java.lang.String[] LOCATION = {"android.permission.ACCESS_FINE_LOCATION", com.dodjoy.permissions.Permission.ACCESS_COARSE_LOCATION};
        public static final java.lang.String[] STORAGE = {com.dodjoy.permissions.Permission.READ_EXTERNAL_STORAGE, "android.permission.WRITE_EXTERNAL_STORAGE"};
    }
}
