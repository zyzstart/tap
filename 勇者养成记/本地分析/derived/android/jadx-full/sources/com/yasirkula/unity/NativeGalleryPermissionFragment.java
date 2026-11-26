package com.yasirkula.unity;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.annotation.TargetApi(23)
public class NativeGalleryPermissionFragment extends android.app.Fragment {
    private static final int PERMISSIONS_REQUEST_CODE = 123655;
    private final com.yasirkula.unity.NativeGalleryPermissionReceiver permissionReceiver;

    public NativeGalleryPermissionFragment() {
        this.permissionReceiver = null;
    }

    public NativeGalleryPermissionFragment(com.yasirkula.unity.NativeGalleryPermissionReceiver nativeGalleryPermissionReceiver) {
        this.permissionReceiver = nativeGalleryPermissionReceiver;
    }

    @Override // android.app.Fragment
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        if (this.permissionReceiver == null) {
            getFragmentManager().beginTransaction().remove(this).commit();
        } else {
            requestPermissions(new java.lang.String[]{"android.permission.WRITE_EXTERNAL_STORAGE", com.dodjoy.permissions.Permission.READ_EXTERNAL_STORAGE}, PERMISSIONS_REQUEST_CODE);
        }
    }

    @Override // android.app.Fragment
    public void onRequestPermissionsResult(int i, java.lang.String[] strArr, int[] iArr) {
        if (i != PERMISSIONS_REQUEST_CODE) {
            return;
        }
        int i2 = 0;
        if (strArr.length == 0 || iArr.length == 0) {
            i2 = 2;
        } else {
            int i3 = 0;
            int i4 = 1;
            while (true) {
                if (i3 >= strArr.length || i3 >= iArr.length) {
                    i2 = i4;
                    break;
                }
                if (iArr[i3] == -1) {
                    if (!shouldShowRequestPermissionRationale(strArr[i3])) {
                        break;
                    } else {
                        i4 = 2;
                    }
                }
                i3++;
            }
        }
        com.yasirkula.unity.NativeGalleryPermissionReceiver nativeGalleryPermissionReceiver = this.permissionReceiver;
        if (nativeGalleryPermissionReceiver != null) {
            nativeGalleryPermissionReceiver.OnPermissionResult(i2);
        }
        getFragmentManager().beginTransaction().remove(this).commit();
    }
}
