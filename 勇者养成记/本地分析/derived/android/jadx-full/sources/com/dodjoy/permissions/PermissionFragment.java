package com.dodjoy.permissions;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class PermissionFragment extends android.app.Fragment implements java.lang.Runnable {
    private static final android.os.Handler HANDLER = new android.os.Handler(android.os.Looper.getMainLooper());
    private static final android.util.SparseArray<com.dodjoy.permissions.OnPermission> PERMISSION_ARRAY = new android.util.SparseArray<>();
    private static final java.lang.String PERMISSION_GROUP = "permission_group";
    private static final java.lang.String REQUEST_CODE = "request_code";
    private static final java.lang.String REQUEST_CONSTANT = "request_constant";
    private boolean isBackCall;

    public static com.dodjoy.permissions.PermissionFragment newInstance(java.util.ArrayList<java.lang.String> arrayList, boolean z) {
        int iNextInt;
        com.dodjoy.permissions.PermissionFragment permissionFragment = new com.dodjoy.permissions.PermissionFragment();
        android.os.Bundle bundle = new android.os.Bundle();
        do {
            iNextInt = new java.util.Random().nextInt(255);
        } while (PERMISSION_ARRAY.get(iNextInt) != null);
        bundle.putInt(REQUEST_CODE, iNextInt);
        bundle.putStringArrayList(PERMISSION_GROUP, arrayList);
        bundle.putBoolean(REQUEST_CONSTANT, z);
        permissionFragment.setArguments(bundle);
        return permissionFragment;
    }

    private void showTip(java.util.List<java.lang.String> list) {
        java.lang.String str = "";
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("android.permission.WRITE_EXTERNAL_STORAGE")) {
                str = str + "當前應用缺少必要權限，【存儲】 僅用於加載儲存遊戲資源，請確保應用正常運行的權限。";
            }
        }
        new android.app.AlertDialog.Builder(getActivity()).setTitle("提示").setCancelable(false).setMessage(str).setPositiveButton("確認", new android.content.DialogInterface.OnClickListener() { // from class: com.dodjoy.permissions.PermissionFragment.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i2) {
                com.dodjoy.permissions.PermissionFragment.this.requestPermission();
            }
        }).create().show();
    }

    @Override // android.app.Fragment
    public void onActivityCreated(android.os.Bundle bundle) {
        super.onActivityCreated(bundle);
        java.util.ArrayList<java.lang.String> stringArrayList = getArguments().getStringArrayList(PERMISSION_GROUP);
        if (stringArrayList == null) {
            return;
        }
        boolean z = false;
        if (stringArrayList.contains(com.dodjoy.permissions.Permission.REQUEST_INSTALL_PACKAGES) && !com.dodjoy.permissions.PermissionUtils.isHasInstallPermission(getActivity())) {
            startActivityForResult(new android.content.Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", android.net.Uri.parse("package:" + getActivity().getPackageName())), getArguments().getInt(REQUEST_CODE));
            z = true;
        }
        if (stringArrayList.contains(com.dodjoy.permissions.Permission.SYSTEM_ALERT_WINDOW) && !com.dodjoy.permissions.PermissionUtils.isHasOverlaysPermission(getActivity())) {
            startActivityForResult(new android.content.Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", android.net.Uri.parse("package:" + getActivity().getPackageName())), getArguments().getInt(REQUEST_CODE));
            z = true;
        }
        if (z) {
            return;
        }
        requestPermission();
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        if (this.isBackCall || i != getArguments().getInt(REQUEST_CODE)) {
            return;
        }
        this.isBackCall = true;
        HANDLER.postDelayed(this, 500L);
    }

    @Override // android.app.Fragment
    public void onRequestPermissionsResult(int i, java.lang.String[] strArr, int[] iArr) {
        com.dodjoy.permissions.OnPermission onPermission = PERMISSION_ARRAY.get(i);
        if (onPermission == null) {
            return;
        }
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (com.dodjoy.permissions.Permission.REQUEST_INSTALL_PACKAGES.equals(strArr[i2])) {
                if (com.dodjoy.permissions.PermissionUtils.isHasInstallPermission(getActivity())) {
                    iArr[i2] = 0;
                } else {
                    iArr[i2] = -1;
                }
            }
            if (com.dodjoy.permissions.Permission.SYSTEM_ALERT_WINDOW.equals(strArr[i2])) {
                if (com.dodjoy.permissions.PermissionUtils.isHasOverlaysPermission(getActivity())) {
                    iArr[i2] = 0;
                } else {
                    iArr[i2] = -1;
                }
            }
            if ((strArr[i2].equals(com.dodjoy.permissions.Permission.ANSWER_PHONE_CALLS) || strArr[i2].equals(com.dodjoy.permissions.Permission.READ_PHONE_NUMBERS)) && !com.dodjoy.permissions.PermissionUtils.isOverOreo()) {
                iArr[i2] = 0;
            }
        }
        java.util.List<java.lang.String> succeedPermissions = com.dodjoy.permissions.PermissionUtils.getSucceedPermissions(strArr, iArr);
        if (succeedPermissions.size() == strArr.length) {
            onPermission.hasPermission(succeedPermissions, true);
        } else {
            java.util.List<java.lang.String> failPermissions = com.dodjoy.permissions.PermissionUtils.getFailPermissions(strArr, iArr);
            if (getArguments().getBoolean(REQUEST_CONSTANT) && com.dodjoy.permissions.PermissionUtils.isRequestDeniedPermission(getActivity(), failPermissions)) {
                showTip(failPermissions);
                return;
            } else {
                onPermission.noPermission(failPermissions, com.dodjoy.permissions.PermissionUtils.checkMorePermissionPermanentDenied(getActivity(), failPermissions));
                if (!succeedPermissions.isEmpty()) {
                    onPermission.hasPermission(succeedPermissions, false);
                }
            }
        }
        PERMISSION_ARRAY.remove(i);
        getFragmentManager().beginTransaction().remove(this).commit();
    }

    public void prepareRequest(android.app.Activity activity, com.dodjoy.permissions.OnPermission onPermission) {
        PERMISSION_ARRAY.put(getArguments().getInt(REQUEST_CODE), onPermission);
        activity.getFragmentManager().beginTransaction().add(this, activity.getClass().getName()).commitAllowingStateLoss();
    }

    public void requestPermission() {
        if (com.dodjoy.permissions.PermissionUtils.isOverMarshmallow()) {
            java.util.ArrayList<java.lang.String> stringArrayList = getArguments().getStringArrayList(PERMISSION_GROUP);
            requestPermissions((java.lang.String[]) stringArrayList.toArray(new java.lang.String[stringArrayList.size() - 1]), getArguments().getInt(REQUEST_CODE));
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (isAdded()) {
            requestPermission();
        }
    }
}
