package com.dodjoy.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class XXPermissionHelper {
    public static void ConstantRequestPermission(final android.app.Activity activity, java.lang.String str) {
        try {
            com.dodjoy.permissions.XXPermissions.with(activity).constantRequest().permission(str).request(new com.dodjoy.permissions.OnPermission() { // from class: com.dodjoy.utils.XXPermissionHelper.3
                @Override // com.dodjoy.permissions.OnPermission
                public void hasPermission(java.util.List<java.lang.String> list, boolean z) {
                }

                @Override // com.dodjoy.permissions.OnPermission
                public void noPermission(java.util.List<java.lang.String> list, boolean z) {
                    if (z) {
                        com.dodjoy.utils.XXPermissionHelper.showTip(activity, list);
                    }
                }
            });
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void RequestPermission(android.app.Activity activity, java.lang.String str) {
        try {
            com.dodjoy.permissions.XXPermissions.with(activity).permission(str).request(new com.dodjoy.permissions.OnPermission() { // from class: com.dodjoy.utils.XXPermissionHelper.1
                @Override // com.dodjoy.permissions.OnPermission
                public void hasPermission(java.util.List<java.lang.String> list, boolean z) {
                }

                @Override // com.dodjoy.permissions.OnPermission
                public void noPermission(java.util.List<java.lang.String> list, boolean z) {
                }
            });
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void RequestPermission(android.app.Activity activity, java.lang.String[] strArr) {
        try {
            com.dodjoy.permissions.XXPermissions.with(activity).permission(strArr).request(new com.dodjoy.permissions.OnPermission() { // from class: com.dodjoy.utils.XXPermissionHelper.2
                @Override // com.dodjoy.permissions.OnPermission
                public void hasPermission(java.util.List<java.lang.String> list, boolean z) {
                }

                @Override // com.dodjoy.permissions.OnPermission
                public void noPermission(java.util.List<java.lang.String> list, boolean z) {
                }
            });
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void showTip(final android.app.Activity activity, java.util.List<java.lang.String> list) {
        java.lang.String str = "";
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("android.permission.WRITE_EXTERNAL_STORAGE")) {
                str = str + "當前應用缺少必要權限，【存儲】 僅用於加載儲存遊戲資源，請確保應用正常運行的權限。";
            }
        }
        new android.app.AlertDialog.Builder(activity).setTitle("提示").setCancelable(false).setMessage(str).setPositiveButton("設置", new android.content.DialogInterface.OnClickListener() { // from class: com.dodjoy.utils.XXPermissionHelper.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i2) {
                com.dodjoy.permissions.XXPermissions.gotoPermissionSettings(activity);
            }
        }).setNegativeButton("退出", new android.content.DialogInterface.OnClickListener() { // from class: com.dodjoy.utils.XXPermissionHelper.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i2) {
                java.lang.System.exit(0);
            }
        }).create().show();
    }
}
