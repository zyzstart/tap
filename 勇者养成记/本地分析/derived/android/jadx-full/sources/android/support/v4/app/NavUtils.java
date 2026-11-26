package android.support.v4.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class NavUtils {
    public static final java.lang.String PARENT_ACTIVITY = "android.support.PARENT_ACTIVITY";
    private static final java.lang.String TAG = "NavUtils";

    private NavUtils() {
    }

    public static android.content.Intent getParentActivityIntent(android.app.Activity activity) {
        android.content.Intent parentActivityIntent;
        if (android.os.Build.VERSION.SDK_INT >= 16 && (parentActivityIntent = activity.getParentActivityIntent()) != null) {
            return parentActivityIntent;
        }
        java.lang.String parentActivityName = getParentActivityName(activity);
        if (parentActivityName == null) {
            return null;
        }
        android.content.ComponentName componentName = new android.content.ComponentName(activity, parentActivityName);
        try {
            return getParentActivityName(activity, componentName) == null ? android.content.Intent.makeMainActivity(componentName) : new android.content.Intent().setComponent(componentName);
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            android.util.Log.e(TAG, "getParentActivityIntent: bad parentActivityName '" + parentActivityName + "' in manifest");
            return null;
        }
    }

    public static android.content.Intent getParentActivityIntent(android.content.Context context, android.content.ComponentName componentName) throws android.content.pm.PackageManager.NameNotFoundException {
        java.lang.String parentActivityName = getParentActivityName(context, componentName);
        if (parentActivityName == null) {
            return null;
        }
        android.content.ComponentName componentName2 = new android.content.ComponentName(componentName.getPackageName(), parentActivityName);
        return getParentActivityName(context, componentName2) == null ? android.content.Intent.makeMainActivity(componentName2) : new android.content.Intent().setComponent(componentName2);
    }

    public static android.content.Intent getParentActivityIntent(android.content.Context context, java.lang.Class<?> cls) throws android.content.pm.PackageManager.NameNotFoundException {
        java.lang.String parentActivityName = getParentActivityName(context, new android.content.ComponentName(context, cls));
        if (parentActivityName == null) {
            return null;
        }
        android.content.ComponentName componentName = new android.content.ComponentName(context, parentActivityName);
        return getParentActivityName(context, componentName) == null ? android.content.Intent.makeMainActivity(componentName) : new android.content.Intent().setComponent(componentName);
    }

    @android.support.annotation.Nullable
    public static java.lang.String getParentActivityName(android.app.Activity activity) {
        try {
            return getParentActivityName(activity, activity.getComponentName());
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            throw new java.lang.IllegalArgumentException(e);
        }
    }

    @android.support.annotation.Nullable
    public static java.lang.String getParentActivityName(android.content.Context context, android.content.ComponentName componentName) throws android.content.pm.PackageManager.NameNotFoundException {
        java.lang.String string;
        java.lang.String str;
        android.content.pm.ActivityInfo activityInfo = context.getPackageManager().getActivityInfo(componentName, 128);
        if (android.os.Build.VERSION.SDK_INT >= 16 && (str = activityInfo.parentActivityName) != null) {
            return str;
        }
        if (activityInfo.metaData == null || (string = activityInfo.metaData.getString(PARENT_ACTIVITY)) == null) {
            return null;
        }
        if (string.charAt(0) != '.') {
            return string;
        }
        return context.getPackageName() + string;
    }

    public static void navigateUpFromSameTask(android.app.Activity activity) {
        android.content.Intent parentActivityIntent = getParentActivityIntent(activity);
        if (parentActivityIntent != null) {
            navigateUpTo(activity, parentActivityIntent);
            return;
        }
        throw new java.lang.IllegalArgumentException("Activity " + activity.getClass().getSimpleName() + " does not have a parent activity name specified. (Did you forget to add the android.support.PARENT_ACTIVITY <meta-data>  element in your manifest?)");
    }

    public static void navigateUpTo(android.app.Activity activity, android.content.Intent intent) {
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            activity.navigateUpTo(intent);
            return;
        }
        intent.addFlags(oicq.wlogin_sdk.request.WtloginHelper.SigType.WLOGIN_QRPUSH);
        activity.startActivity(intent);
        activity.finish();
    }

    public static boolean shouldUpRecreateTask(android.app.Activity activity, android.content.Intent intent) {
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            return activity.shouldUpRecreateTask(intent);
        }
        java.lang.String action = activity.getIntent().getAction();
        return (action == null || action.equals("android.intent.action.MAIN")) ? false : true;
    }
}
