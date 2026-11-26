package android.support.v4.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ActivityCompat extends android.support.v4.content.ContextCompat {

    public interface OnRequestPermissionsResultCallback {
        void onRequestPermissionsResult(int i, @android.support.annotation.NonNull java.lang.String[] strArr, @android.support.annotation.NonNull int[] iArr);
    }

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public interface RequestPermissionsRequestCodeValidator {
        void validateRequestPermissionsRequestCode(int i);
    }

    @android.support.annotation.RequiresApi(21)
    private static class SharedElementCallback21Impl extends android.app.SharedElementCallback {
        protected android.support.v4.app.SharedElementCallback mCallback;

        public SharedElementCallback21Impl(android.support.v4.app.SharedElementCallback sharedElementCallback) {
            this.mCallback = sharedElementCallback;
        }

        @Override // android.app.SharedElementCallback
        public android.os.Parcelable onCaptureSharedElementSnapshot(android.view.View view, android.graphics.Matrix matrix, android.graphics.RectF rectF) {
            return this.mCallback.onCaptureSharedElementSnapshot(view, matrix, rectF);
        }

        @Override // android.app.SharedElementCallback
        public android.view.View onCreateSnapshotView(android.content.Context context, android.os.Parcelable parcelable) {
            return this.mCallback.onCreateSnapshotView(context, parcelable);
        }

        @Override // android.app.SharedElementCallback
        public void onMapSharedElements(java.util.List<java.lang.String> list, java.util.Map<java.lang.String, android.view.View> map) {
            this.mCallback.onMapSharedElements(list, map);
        }

        @Override // android.app.SharedElementCallback
        public void onRejectSharedElements(java.util.List<android.view.View> list) {
            this.mCallback.onRejectSharedElements(list);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementEnd(java.util.List<java.lang.String> list, java.util.List<android.view.View> list2, java.util.List<android.view.View> list3) {
            this.mCallback.onSharedElementEnd(list, list2, list3);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementStart(java.util.List<java.lang.String> list, java.util.List<android.view.View> list2, java.util.List<android.view.View> list3) {
            this.mCallback.onSharedElementStart(list, list2, list3);
        }
    }

    @android.support.annotation.RequiresApi(23)
    private static class SharedElementCallback23Impl extends android.support.v4.app.ActivityCompat.SharedElementCallback21Impl {
        public SharedElementCallback23Impl(android.support.v4.app.SharedElementCallback sharedElementCallback) {
            super(sharedElementCallback);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementsArrived(java.util.List<java.lang.String> list, java.util.List<android.view.View> list2, final android.app.SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
            this.mCallback.onSharedElementsArrived(list, list2, new android.support.v4.app.SharedElementCallback.OnSharedElementsReadyListener() { // from class: android.support.v4.app.ActivityCompat.SharedElementCallback23Impl.1
                @Override // android.support.v4.app.SharedElementCallback.OnSharedElementsReadyListener
                public void onSharedElementsReady() {
                    onSharedElementsReadyListener.onSharedElementsReady();
                }
            });
        }
    }

    protected ActivityCompat() {
    }

    public static void finishAffinity(android.app.Activity activity) {
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            activity.finishAffinity();
        } else {
            activity.finish();
        }
    }

    public static void finishAfterTransition(android.app.Activity activity) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            activity.finishAfterTransition();
        } else {
            activity.finish();
        }
    }

    @android.support.annotation.Nullable
    public static android.net.Uri getReferrer(android.app.Activity activity) {
        if (android.os.Build.VERSION.SDK_INT >= 22) {
            return activity.getReferrer();
        }
        android.content.Intent intent = activity.getIntent();
        android.net.Uri uri = (android.net.Uri) intent.getParcelableExtra("android.intent.extra.REFERRER");
        if (uri != null) {
            return uri;
        }
        java.lang.String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        if (stringExtra != null) {
            return android.net.Uri.parse(stringExtra);
        }
        return null;
    }

    public static boolean invalidateOptionsMenu(android.app.Activity activity) {
        activity.invalidateOptionsMenu();
        return true;
    }

    public static void postponeEnterTransition(android.app.Activity activity) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            activity.postponeEnterTransition();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void requestPermissions(@android.support.annotation.NonNull final android.app.Activity activity, @android.support.annotation.NonNull final java.lang.String[] strArr, @android.support.annotation.IntRange(from = android.support.v4.media.MediaDescriptionCompat.BT_FOLDER_TYPE_MIXED) final int i) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            if (activity instanceof android.support.v4.app.ActivityCompat.RequestPermissionsRequestCodeValidator) {
                ((android.support.v4.app.ActivityCompat.RequestPermissionsRequestCodeValidator) activity).validateRequestPermissionsRequestCode(i);
            }
            activity.requestPermissions(strArr, i);
        } else if (activity instanceof android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback) {
            new android.os.Handler(android.os.Looper.getMainLooper()).post(new java.lang.Runnable() { // from class: android.support.v4.app.ActivityCompat.1
                @Override // java.lang.Runnable
                public void run() {
                    int[] iArr = new int[strArr.length];
                    android.content.pm.PackageManager packageManager = activity.getPackageManager();
                    java.lang.String packageName = activity.getPackageName();
                    int length = strArr.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        iArr[i2] = packageManager.checkPermission(strArr[i2], packageName);
                    }
                    ((android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback) activity).onRequestPermissionsResult(i, strArr, iArr);
                }
            });
        }
    }

    public static void setEnterSharedElementCallback(android.app.Activity activity, android.support.v4.app.SharedElementCallback sharedElementCallback) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            activity.setEnterSharedElementCallback(sharedElementCallback != null ? new android.support.v4.app.ActivityCompat.SharedElementCallback23Impl(sharedElementCallback) : null);
        } else if (android.os.Build.VERSION.SDK_INT >= 21) {
            activity.setEnterSharedElementCallback(sharedElementCallback != null ? new android.support.v4.app.ActivityCompat.SharedElementCallback21Impl(sharedElementCallback) : null);
        }
    }

    public static void setExitSharedElementCallback(android.app.Activity activity, android.support.v4.app.SharedElementCallback sharedElementCallback) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            activity.setExitSharedElementCallback(sharedElementCallback != null ? new android.support.v4.app.ActivityCompat.SharedElementCallback23Impl(sharedElementCallback) : null);
        } else if (android.os.Build.VERSION.SDK_INT >= 21) {
            activity.setExitSharedElementCallback(sharedElementCallback != null ? new android.support.v4.app.ActivityCompat.SharedElementCallback21Impl(sharedElementCallback) : null);
        }
    }

    public static boolean shouldShowRequestPermissionRationale(@android.support.annotation.NonNull android.app.Activity activity, @android.support.annotation.NonNull java.lang.String str) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
        return false;
    }

    public static void startActivityForResult(android.app.Activity activity, android.content.Intent intent, int i, @android.support.annotation.Nullable android.os.Bundle bundle) {
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            activity.startActivityForResult(intent, i, bundle);
        } else {
            activity.startActivityForResult(intent, i);
        }
    }

    public static void startIntentSenderForResult(android.app.Activity activity, android.content.IntentSender intentSender, int i, android.content.Intent intent, int i2, int i3, int i4, @android.support.annotation.Nullable android.os.Bundle bundle) throws android.content.IntentSender.SendIntentException {
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
        } else {
            activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
        }
    }

    public static void startPostponedEnterTransition(android.app.Activity activity) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            activity.startPostponedEnterTransition();
        }
    }
}
