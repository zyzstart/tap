package com.dodjoy.dodlib;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class DodPermission extends com.dodjoy.dodlib.DodLibBaseMgr {
    private android.app.Activity mActivity;
    private java.lang.String mToastDesc;
    private final int DOD_PERMISSIONS_REQUEST_CODE = 451365;
    private final java.util.Set<java.lang.String> mPermissions = new java.util.HashSet();

    private void initializePermissionsMap() {
        java.lang.String str;
        for (java.lang.reflect.Field field : android.Manifest.permission.class.getFields()) {
            try {
                str = (java.lang.String) field.get("");
            } catch (java.lang.IllegalAccessException unused) {
                str = null;
            }
            this.mPermissions.add(str);
        }
    }

    public boolean CheckAndRequesetMicroPhonePermission() {
        boolean z = android.support.v4.content.ContextCompat.checkSelfPermission(this.mActivity.getApplicationContext(), "android.permission.RECORD_AUDIO") == 0;
        if (!z) {
            android.support.v4.app.ActivityCompat.shouldShowRequestPermissionRationale(this.mActivity, "android.permission.RECORD_AUDIO");
            android.support.v4.app.ActivityCompat.requestPermissions(this.mActivity, new java.lang.String[]{"android.permission.RECORD_AUDIO"}, 0);
        }
        return z;
    }

    @Override // com.dodjoy.dodlib.DodLibBaseMgr
    public boolean Create(android.app.Activity activity) {
        this.mActivity = activity;
        initializePermissionsMap();
        return true;
    }

    public boolean IsPermissionGranted(java.lang.String str, java.lang.String str2) {
        if (android.os.Build.VERSION.SDK_INT < 23) {
            return !this.mPermissions.contains(str);
        }
        android.app.Activity activity = this.mActivity;
        if (activity == null) {
            return false;
        }
        this.mToastDesc = str2;
        if (android.support.v4.content.ContextCompat.checkSelfPermission(activity, str) == 0 || !this.mPermissions.contains(str)) {
            return true;
        }
        if (android.support.v4.app.ActivityCompat.shouldShowRequestPermissionRationale(this.mActivity, str)) {
            android.widget.Toast.makeText(this.mActivity, this.mToastDesc, 1).show();
        } else {
            android.support.v4.app.ActivityCompat.requestPermissions(this.mActivity, new java.lang.String[]{str}, 451365);
        }
        return false;
    }

    public void onRequestPermissionsResult(int i, java.lang.String[] strArr, int[] iArr) {
        if (i != 451365) {
            return;
        }
        if (iArr.length == 0) {
            android.widget.Toast.makeText(this.mActivity, this.mToastDesc, 1).show();
            return;
        }
        for (int i2 = 0; i2 < strArr.length && i2 < iArr.length; i2++) {
            if (iArr[i2] != 0) {
                android.widget.Toast.makeText(this.mActivity, this.mToastDesc, 1).show();
            }
        }
    }
}
