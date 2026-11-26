package com.dodjoy.permissions;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class XXPermissions {
    private android.app.Activity mActivity;
    private boolean mConstant;
    private java.util.List<java.lang.String> mPermissions;

    private XXPermissions(android.app.Activity activity) {
        this.mActivity = activity;
    }

    public static void gotoPermissionSettings(android.content.Context context) {
        com.dodjoy.permissions.PermissionSettingPage.start(context, false);
    }

    public static void gotoPermissionSettings(android.content.Context context, boolean z) {
        com.dodjoy.permissions.PermissionSettingPage.start(context, z);
    }

    public static boolean isHasPermission(android.content.Context context, java.util.List<java.lang.String> list) {
        java.util.ArrayList<java.lang.String> failPermissions = com.dodjoy.permissions.PermissionUtils.getFailPermissions(context, list);
        return failPermissions == null || failPermissions.isEmpty();
    }

    public static boolean isHasPermission(android.content.Context context, java.lang.String... strArr) {
        return isHasPermission(context, (java.util.List<java.lang.String>) java.util.Arrays.asList(strArr));
    }

    public static boolean isHasPermission(android.content.Context context, java.lang.String[]... strArr) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.String[] strArr2 : strArr) {
            arrayList.addAll(java.util.Arrays.asList(strArr2));
        }
        java.util.ArrayList<java.lang.String> failPermissions = com.dodjoy.permissions.PermissionUtils.getFailPermissions(context, arrayList);
        return failPermissions == null || failPermissions.isEmpty();
    }

    public static com.dodjoy.permissions.XXPermissions with(android.app.Activity activity) {
        return new com.dodjoy.permissions.XXPermissions(activity);
    }

    public com.dodjoy.permissions.XXPermissions constantRequest() {
        this.mConstant = true;
        return this;
    }

    public com.dodjoy.permissions.XXPermissions permission(java.util.List<java.lang.String> list) {
        java.util.List<java.lang.String> list2 = this.mPermissions;
        if (list2 == null) {
            this.mPermissions = list;
        } else {
            list2.addAll(list);
        }
        return this;
    }

    public com.dodjoy.permissions.XXPermissions permission(java.lang.String... strArr) {
        if (this.mPermissions == null) {
            this.mPermissions = new java.util.ArrayList(strArr.length);
        }
        this.mPermissions.addAll(java.util.Arrays.asList(strArr));
        return this;
    }

    public com.dodjoy.permissions.XXPermissions permission(java.lang.String[]... strArr) {
        if (this.mPermissions == null) {
            int length = 0;
            for (java.lang.String[] strArr2 : strArr) {
                length += strArr2.length;
            }
            this.mPermissions = new java.util.ArrayList(length);
        }
        for (java.lang.String[] strArr3 : strArr) {
            this.mPermissions.addAll(java.util.Arrays.asList(strArr3));
        }
        return this;
    }

    public void request(com.dodjoy.permissions.OnPermission onPermission) {
        java.util.List<java.lang.String> list = this.mPermissions;
        if (list == null || list.isEmpty()) {
            this.mPermissions = com.dodjoy.permissions.PermissionUtils.getManifestPermissions(this.mActivity);
        }
        java.util.List<java.lang.String> list2 = this.mPermissions;
        if (list2 == null || list2.isEmpty()) {
            throw new java.lang.IllegalArgumentException("The requested permission cannot be empty");
        }
        android.app.Activity activity = this.mActivity;
        if (activity == null) {
            throw new java.lang.IllegalArgumentException("The activity is empty");
        }
        if (onPermission == null) {
            throw new java.lang.IllegalArgumentException("The permission request callback interface must be implemented");
        }
        com.dodjoy.permissions.PermissionUtils.checkTargetSdkVersion(activity, this.mPermissions);
        java.util.ArrayList<java.lang.String> failPermissions = com.dodjoy.permissions.PermissionUtils.getFailPermissions(this.mActivity, this.mPermissions);
        if (failPermissions == null || failPermissions.isEmpty()) {
            onPermission.hasPermission(this.mPermissions, true);
        } else {
            com.dodjoy.permissions.PermissionUtils.checkPermissions(this.mActivity, this.mPermissions);
            com.dodjoy.permissions.PermissionFragment.newInstance(new java.util.ArrayList(this.mPermissions), this.mConstant).prepareRequest(this.mActivity, onPermission);
        }
    }
}
