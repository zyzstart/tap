package com.anthonycr.grant;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class PermissionsResultAction {
    private static final java.lang.String TAG = "PermissionsResultAction";
    private android.os.Looper mLooper;
    private final java.util.Set<java.lang.String> mPermissions;

    public PermissionsResultAction() {
        this.mPermissions = new java.util.HashSet(1);
        this.mLooper = android.os.Looper.getMainLooper();
    }

    public PermissionsResultAction(@android.support.annotation.NonNull android.os.Looper looper) {
        this.mPermissions = new java.util.HashSet(1);
        this.mLooper = android.os.Looper.getMainLooper();
        this.mLooper = looper;
    }

    public abstract void onDenied(java.lang.String str);

    public abstract void onGranted();

    @android.support.annotation.CallSuper
    protected final synchronized boolean onResult(@android.support.annotation.NonNull java.lang.String str, int i) {
        try {
            if (i == 0) {
                return onResult(str, com.anthonycr.grant.Permissions.GRANTED);
            }
            return onResult(str, com.anthonycr.grant.Permissions.DENIED);
        } catch (java.lang.Throwable th) {
            throw th;
        }
    }

    @android.support.annotation.CallSuper
    protected final synchronized boolean onResult(@android.support.annotation.NonNull final java.lang.String str, com.anthonycr.grant.Permissions permissions) {
        this.mPermissions.remove(str);
        if (permissions == com.anthonycr.grant.Permissions.GRANTED) {
            if (this.mPermissions.isEmpty()) {
                new android.os.Handler(this.mLooper).post(new java.lang.Runnable() { // from class: com.anthonycr.grant.PermissionsResultAction.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.anthonycr.grant.PermissionsResultAction.this.onGranted();
                    }
                });
                return true;
            }
        } else {
            if (permissions == com.anthonycr.grant.Permissions.DENIED) {
                new android.os.Handler(this.mLooper).post(new java.lang.Runnable() { // from class: com.anthonycr.grant.PermissionsResultAction.2
                    @Override // java.lang.Runnable
                    public void run() {
                        com.anthonycr.grant.PermissionsResultAction.this.onDenied(str);
                    }
                });
                return true;
            }
            if (permissions == com.anthonycr.grant.Permissions.NOT_FOUND) {
                if (!shouldIgnorePermissionNotFound(str)) {
                    new android.os.Handler(this.mLooper).post(new java.lang.Runnable() { // from class: com.anthonycr.grant.PermissionsResultAction.4
                        @Override // java.lang.Runnable
                        public void run() {
                            com.anthonycr.grant.PermissionsResultAction.this.onDenied(str);
                        }
                    });
                    return true;
                }
                if (this.mPermissions.isEmpty()) {
                    new android.os.Handler(this.mLooper).post(new java.lang.Runnable() { // from class: com.anthonycr.grant.PermissionsResultAction.3
                        @Override // java.lang.Runnable
                        public void run() {
                            com.anthonycr.grant.PermissionsResultAction.this.onGranted();
                        }
                    });
                    return true;
                }
            }
        }
        return false;
    }

    @android.support.annotation.CallSuper
    protected final synchronized void registerPermissions(@android.support.annotation.NonNull java.lang.String[] strArr) {
        java.util.Collections.addAll(this.mPermissions, strArr);
    }

    public synchronized boolean shouldIgnorePermissionNotFound(java.lang.String str) {
        android.util.Log.d(TAG, "Permission not found: " + str);
        return true;
    }
}
