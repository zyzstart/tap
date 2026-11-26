package com.anthonycr.grant;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class PermissionsManager {
    private static final java.lang.String TAG = "PermissionsManager";
    private static com.anthonycr.grant.PermissionsManager mInstance;
    private final java.util.Set<java.lang.String> mPendingRequests = new java.util.HashSet(1);
    private final java.util.Set<java.lang.String> mPermissions = new java.util.HashSet(1);
    private final java.util.List<java.lang.ref.WeakReference<com.anthonycr.grant.PermissionsResultAction>> mPendingActions = new java.util.ArrayList(1);

    private PermissionsManager() {
        initializePermissionsMap();
    }

    private synchronized void addPendingAction(@android.support.annotation.NonNull java.lang.String[] strArr, @android.support.annotation.Nullable com.anthonycr.grant.PermissionsResultAction permissionsResultAction) {
        if (permissionsResultAction == null) {
            return;
        }
        permissionsResultAction.registerPermissions(strArr);
        this.mPendingActions.add(new java.lang.ref.WeakReference<>(permissionsResultAction));
    }

    private void doPermissionWorkBeforeAndroidM(@android.support.annotation.NonNull android.app.Activity activity, @android.support.annotation.NonNull java.lang.String[] strArr, @android.support.annotation.Nullable com.anthonycr.grant.PermissionsResultAction permissionsResultAction) {
        for (java.lang.String str : strArr) {
            if (permissionsResultAction != null) {
                if (!this.mPermissions.contains(str)) {
                    permissionsResultAction.onResult(str, com.anthonycr.grant.Permissions.NOT_FOUND);
                } else if (android.support.v4.app.ActivityCompat.checkSelfPermission(activity, str) != 0) {
                    permissionsResultAction.onResult(str, com.anthonycr.grant.Permissions.DENIED);
                } else {
                    permissionsResultAction.onResult(str, com.anthonycr.grant.Permissions.GRANTED);
                }
            }
        }
    }

    public static com.anthonycr.grant.PermissionsManager getInstance() {
        if (mInstance == null) {
            mInstance = new com.anthonycr.grant.PermissionsManager();
        }
        return mInstance;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @android.support.annotation.NonNull
    private synchronized java.lang.String[] getManifestPermissions(@android.support.annotation.NonNull android.app.Activity activity) {
        java.util.ArrayList arrayList;
        java.lang.String[] strArr;
        android.content.pm.PackageInfo packageInfo = null;
        arrayList = new java.util.ArrayList(1);
        try {
            android.util.Log.d(TAG, activity.getPackageName());
            packageInfo = activity.getPackageManager().getPackageInfo(activity.getPackageName(), 4096);
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            android.util.Log.e(TAG, "A problem occurred when retrieving permissions", e);
        }
        if (packageInfo != null && (strArr = packageInfo.requestedPermissions) != null) {
            for (java.lang.String str : strArr) {
                android.util.Log.d(TAG, "Manifest contained permission: " + str);
                arrayList.add(str);
            }
        }
        return (java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()]);
    }

    @android.support.annotation.NonNull
    private java.util.List<java.lang.String> getPermissionsListToRequest(@android.support.annotation.NonNull android.app.Activity activity, @android.support.annotation.NonNull java.lang.String[] strArr, @android.support.annotation.Nullable com.anthonycr.grant.PermissionsResultAction permissionsResultAction) {
        java.util.ArrayList arrayList = new java.util.ArrayList(strArr.length);
        for (java.lang.String str : strArr) {
            if (this.mPermissions.contains(str)) {
                if (android.support.v4.app.ActivityCompat.checkSelfPermission(activity, str) != 0) {
                    arrayList.add(str);
                } else if (permissionsResultAction != null) {
                    permissionsResultAction.onResult(str, com.anthonycr.grant.Permissions.GRANTED);
                }
            } else if (permissionsResultAction != null) {
                permissionsResultAction.onResult(str, com.anthonycr.grant.Permissions.NOT_FOUND);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private synchronized void initializePermissionsMap() {
        java.lang.String str;
        for (java.lang.reflect.Field field : android.Manifest.permission.class.getFields()) {
            try {
                str = (java.lang.String) field.get("");
            } catch (java.lang.IllegalAccessException e) {
                android.util.Log.e(TAG, "Could not access field", e);
                str = null;
            }
            this.mPermissions.add(str);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private synchronized void removePendingAction(@android.support.annotation.Nullable com.anthonycr.grant.PermissionsResultAction permissionsResultAction) {
        java.util.Iterator<java.lang.ref.WeakReference<com.anthonycr.grant.PermissionsResultAction>> it = this.mPendingActions.iterator();
        while (it.hasNext()) {
            java.lang.ref.WeakReference<com.anthonycr.grant.PermissionsResultAction> next = it.next();
            if (next.get() == permissionsResultAction || next.get() == null) {
                it.remove();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized boolean hasAllPermissions(@android.support.annotation.Nullable android.content.Context context, @android.support.annotation.NonNull java.lang.String[] strArr) {
        if (context == null) {
            return false;
        }
        boolean zHasPermission = true;
        for (java.lang.String str : strArr) {
            zHasPermission &= hasPermission(context, str);
        }
        return zHasPermission;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0016  */
    public synchronized boolean hasPermission(@android.support.annotation.Nullable android.content.Context context, @android.support.annotation.NonNull java.lang.String str) {
        boolean z;
        if (context == null) {
            z = false;
        } else if (android.support.v4.app.ActivityCompat.checkSelfPermission(context, str) == 0 || !this.mPermissions.contains(str)) {
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void notifyPermissionsChange(@android.support.annotation.NonNull java.lang.String[] strArr, @android.support.annotation.NonNull int[] iArr) {
        int i;
        int length = strArr.length;
        if (iArr.length < length) {
            length = iArr.length;
        }
        java.util.Iterator<java.lang.ref.WeakReference<com.anthonycr.grant.PermissionsResultAction>> it = this.mPendingActions.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.anthonycr.grant.PermissionsResultAction permissionsResultAction = it.next().get();
            while (i < length) {
                i = (permissionsResultAction == null || permissionsResultAction.onResult(strArr[i], iArr[i])) ? 0 : i + 1;
                it.remove();
                break;
            }
        }
        for (i = 0; i < length; i++) {
            this.mPendingRequests.remove(strArr[i]);
        }
    }

    public synchronized void requestAllManifestPermissionsIfNecessary(@android.support.annotation.Nullable android.app.Activity activity, @android.support.annotation.Nullable com.anthonycr.grant.PermissionsResultAction permissionsResultAction) {
        if (activity == null) {
            return;
        }
        requestPermissionsIfNecessaryForResult(activity, getManifestPermissions(activity), permissionsResultAction);
    }

    public synchronized void requestPermissionsIfNecessaryForResult(@android.support.annotation.Nullable android.app.Activity activity, @android.support.annotation.NonNull java.lang.String[] strArr, @android.support.annotation.Nullable com.anthonycr.grant.PermissionsResultAction permissionsResultAction) {
        if (activity == null) {
            return;
        }
        addPendingAction(strArr, permissionsResultAction);
        if (android.os.Build.VERSION.SDK_INT < 23) {
            doPermissionWorkBeforeAndroidM(activity, strArr, permissionsResultAction);
        } else {
            java.util.List<java.lang.String> permissionsListToRequest = getPermissionsListToRequest(activity, strArr, permissionsResultAction);
            if (permissionsListToRequest.isEmpty()) {
                removePendingAction(permissionsResultAction);
            } else {
                java.lang.String[] strArr2 = (java.lang.String[]) permissionsListToRequest.toArray(new java.lang.String[permissionsListToRequest.size()]);
                this.mPendingRequests.addAll(permissionsListToRequest);
                android.support.v4.app.ActivityCompat.requestPermissions(activity, strArr2, 1);
            }
        }
    }

    public synchronized void requestPermissionsIfNecessaryForResult(@android.support.annotation.NonNull android.support.v4.app.Fragment fragment, @android.support.annotation.NonNull java.lang.String[] strArr, @android.support.annotation.Nullable com.anthonycr.grant.PermissionsResultAction permissionsResultAction) {
        android.support.v4.app.FragmentActivity activity = fragment.getActivity();
        if (activity == null) {
            return;
        }
        addPendingAction(strArr, permissionsResultAction);
        if (android.os.Build.VERSION.SDK_INT < 23) {
            doPermissionWorkBeforeAndroidM(activity, strArr, permissionsResultAction);
        } else {
            java.util.List<java.lang.String> permissionsListToRequest = getPermissionsListToRequest(activity, strArr, permissionsResultAction);
            if (permissionsListToRequest.isEmpty()) {
                removePendingAction(permissionsResultAction);
            } else {
                java.lang.String[] strArr2 = (java.lang.String[]) permissionsListToRequest.toArray(new java.lang.String[permissionsListToRequest.size()]);
                this.mPendingRequests.addAll(permissionsListToRequest);
                fragment.requestPermissions(strArr2, 1);
            }
        }
    }
}
