package com.tencent.ysdk.shell.framework.config;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class PermissionManager {
    private static final java.lang.String DEFAULT_API_PERMISSION = "[REDACTED]";
    private static volatile com.tencent.ysdk.shell.framework.config.PermissionManager instance;
    private com.tencent.ysdk.shell.libware.util.SafeJSONObject mApiPermissionJson = null;

    public static com.tencent.ysdk.shell.framework.config.PermissionManager getInstance() {
        if (instance == null) {
            synchronized (com.tencent.ysdk.shell.framework.config.PermissionManager.class) {
                if (instance == null) {
                    instance = new com.tencent.ysdk.shell.framework.config.PermissionManager();
                }
            }
        }
        return instance;
    }

    public boolean hasApiPermission(java.lang.String str) {
        try {
            return this.mApiPermissionJson != null && this.mApiPermissionJson.has(str) && 1 == this.mApiPermissionJson.getInt(str);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void init() {
        setApiPermission(DEFAULT_API_PERMISSION);
    }

    public void setApiPermission(java.lang.String str) {
        if (str != null) {
            try {
                this.mApiPermissionJson = new com.tencent.ysdk.shell.libware.util.SafeJSONObject(str);
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
