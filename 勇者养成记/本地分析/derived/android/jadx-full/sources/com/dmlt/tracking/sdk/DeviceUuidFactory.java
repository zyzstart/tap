package com.dmlt.tracking.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class DeviceUuidFactory {
    protected static final java.lang.String PREFS_DEVICE_ID = "dod_device_id";
    protected static final java.lang.String PREFS_FILE = "dod_device_id.xml";
    protected static final java.lang.String PREFS_UUID = "dod_uuid";
    protected static final java.lang.String PREFS_UUID_FILE = "dod_uuid.xml";
    protected static final java.lang.String dod_uuid = "";
    protected static android.content.Context mContext;
    protected static java.util.UUID uuid;

    public DeviceUuidFactory(android.content.Context context) {
        mContext = context;
    }

    public java.util.UUID getDeviceUuid() {
        return uuid;
    }

    public java.lang.String getDodUuid() {
        if (!android.text.TextUtils.isEmpty("")) {
            return "";
        }
        android.content.SharedPreferences sharedPreferences = mContext.getSharedPreferences(PREFS_UUID_FILE, 0);
        java.lang.String string = sharedPreferences.getString(PREFS_UUID, null);
        if (!android.text.TextUtils.isEmpty(string)) {
            return string;
        }
        java.lang.String string2 = java.util.UUID.randomUUID().toString();
        sharedPreferences.edit().putString(PREFS_UUID, string2).commit();
        return string2;
    }
}
