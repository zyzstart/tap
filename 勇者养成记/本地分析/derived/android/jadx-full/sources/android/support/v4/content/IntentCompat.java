package android.support.v4.content;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class IntentCompat {

    @java.lang.Deprecated
    public static final java.lang.String ACTION_EXTERNAL_APPLICATIONS_AVAILABLE = "android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE";

    @java.lang.Deprecated
    public static final java.lang.String ACTION_EXTERNAL_APPLICATIONS_UNAVAILABLE = "android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE";
    public static final java.lang.String CATEGORY_LEANBACK_LAUNCHER = "android.intent.category.LEANBACK_LAUNCHER";

    @java.lang.Deprecated
    public static final java.lang.String EXTRA_CHANGED_PACKAGE_LIST = "android.intent.extra.changed_package_list";

    @java.lang.Deprecated
    public static final java.lang.String EXTRA_CHANGED_UID_LIST = "android.intent.extra.changed_uid_list";
    public static final java.lang.String EXTRA_HTML_TEXT = "android.intent.extra.HTML_TEXT";
    public static final java.lang.String EXTRA_START_PLAYBACK = "android.intent.extra.START_PLAYBACK";

    @java.lang.Deprecated
    public static final int FLAG_ACTIVITY_CLEAR_TASK = 32768;

    @java.lang.Deprecated
    public static final int FLAG_ACTIVITY_TASK_ON_HOME = 16384;
    private static final android.support.v4.content.IntentCompat.IntentCompatBaseImpl IMPL;

    @android.support.annotation.RequiresApi(15)
    static class IntentCompatApi15Impl extends android.support.v4.content.IntentCompat.IntentCompatBaseImpl {
        IntentCompatApi15Impl() {
        }

        @Override // android.support.v4.content.IntentCompat.IntentCompatBaseImpl
        public android.content.Intent makeMainSelectorActivity(java.lang.String str, java.lang.String str2) {
            return android.content.Intent.makeMainSelectorActivity(str, str2);
        }
    }

    static class IntentCompatBaseImpl {
        IntentCompatBaseImpl() {
        }

        public android.content.Intent makeMainSelectorActivity(java.lang.String str, java.lang.String str2) {
            android.content.Intent intent = new android.content.Intent(str);
            intent.addCategory(str2);
            return intent;
        }
    }

    static {
        if (android.os.Build.VERSION.SDK_INT >= 15) {
            IMPL = new android.support.v4.content.IntentCompat.IntentCompatApi15Impl();
        } else {
            IMPL = new android.support.v4.content.IntentCompat.IntentCompatBaseImpl();
        }
    }

    private IntentCompat() {
    }

    @java.lang.Deprecated
    public static android.content.Intent makeMainActivity(android.content.ComponentName componentName) {
        return android.content.Intent.makeMainActivity(componentName);
    }

    public static android.content.Intent makeMainSelectorActivity(java.lang.String str, java.lang.String str2) {
        return IMPL.makeMainSelectorActivity(str, str2);
    }

    @java.lang.Deprecated
    public static android.content.Intent makeRestartActivityTask(android.content.ComponentName componentName) {
        return android.content.Intent.makeRestartActivityTask(componentName);
    }
}
