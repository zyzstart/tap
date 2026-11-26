package com.dodjoy.thirdPlatform;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class GDTApplication extends android.app.Application {
    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        java.lang.String string = "";
        java.lang.String string2 = "";
        try {
            android.content.pm.ApplicationInfo applicationInfo = getPackageManager().getApplicationInfo(getPackageName(), 128);
            int i = applicationInfo.metaData.getInt("GDTActionSetID");
            if (i != 0) {
                string = java.lang.String.valueOf(i);
                string2 = applicationInfo.metaData.getString("[REDACTED]");
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        android.util.Log.e("Unity", "manifest actionsetid is" + string);
        if (android.text.TextUtils.isEmpty(string)) {
            try {
                java.io.InputStream inputStreamOpen = getResources().getAssets().open("SdkCfg.bytes");
                java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                while (true) {
                    int i2 = inputStreamOpen.read();
                    if (i2 == -1) {
                        break;
                    } else {
                        byteArrayOutputStream.write(i2);
                    }
                }
                org.json.JSONObject jSONObject = new org.json.JSONObject(byteArrayOutputStream.toString());
                string = jSONObject.getString("GDTActionSetID");
                if (!android.text.TextUtils.isEmpty(string)) {
                    string2 = jSONObject.getString("[REDACTED]");
                }
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
        }
        android.util.Log.e("Unity", "manifest actionsetid is " + string);
        if (android.text.TextUtils.isEmpty(string)) {
            return;
        }
        com.qq.gdt.action.GDTAction.init(this, string, string2);
        android.util.Log.e("Unity", "call GDTAction.init");
    }
}
