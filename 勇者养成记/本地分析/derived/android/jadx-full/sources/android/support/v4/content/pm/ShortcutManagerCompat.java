package android.support.v4.content.pm;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ShortcutManagerCompat {

    @android.support.annotation.VisibleForTesting
    static final java.lang.String ACTION_INSTALL_SHORTCUT = "com.android.launcher.action.INSTALL_SHORTCUT";

    @android.support.annotation.VisibleForTesting
    static final java.lang.String INSTALL_SHORTCUT_PERMISSION = "com.android.launcher.permission.INSTALL_SHORTCUT";

    private ShortcutManagerCompat() {
    }

    @android.support.annotation.NonNull
    public static android.content.Intent createShortcutResultIntent(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.NonNull android.support.v4.content.pm.ShortcutInfoCompat shortcutInfoCompat) {
        android.content.Intent intentCreateShortcutResultIntent = android.os.Build.VERSION.SDK_INT >= 26 ? ((android.content.pm.ShortcutManager) context.getSystemService(android.content.pm.ShortcutManager.class)).createShortcutResultIntent(shortcutInfoCompat.toShortcutInfo()) : null;
        if (intentCreateShortcutResultIntent == null) {
            intentCreateShortcutResultIntent = new android.content.Intent();
        }
        return shortcutInfoCompat.addToIntent(intentCreateShortcutResultIntent);
    }

    public static boolean isRequestPinShortcutSupported(@android.support.annotation.NonNull android.content.Context context) {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            return ((android.content.pm.ShortcutManager) context.getSystemService(android.content.pm.ShortcutManager.class)).isRequestPinShortcutSupported();
        }
        if (android.support.v4.content.ContextCompat.checkSelfPermission(context, INSTALL_SHORTCUT_PERMISSION) != 0) {
            return false;
        }
        java.util.Iterator<android.content.pm.ResolveInfo> it = context.getPackageManager().queryBroadcastReceivers(new android.content.Intent(ACTION_INSTALL_SHORTCUT), 0).iterator();
        while (it.hasNext()) {
            java.lang.String str = it.next().activityInfo.permission;
            if (android.text.TextUtils.isEmpty(str) || INSTALL_SHORTCUT_PERMISSION.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean requestPinShortcut(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.NonNull android.support.v4.content.pm.ShortcutInfoCompat shortcutInfoCompat, @android.support.annotation.Nullable final android.content.IntentSender intentSender) {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            return ((android.content.pm.ShortcutManager) context.getSystemService(android.content.pm.ShortcutManager.class)).requestPinShortcut(shortcutInfoCompat.toShortcutInfo(), intentSender);
        }
        if (!isRequestPinShortcutSupported(context)) {
            return false;
        }
        android.content.Intent intentAddToIntent = shortcutInfoCompat.addToIntent(new android.content.Intent(ACTION_INSTALL_SHORTCUT));
        if (intentSender == null) {
            context.sendBroadcast(intentAddToIntent);
            return true;
        }
        context.sendOrderedBroadcast(intentAddToIntent, null, new android.content.BroadcastReceiver() { // from class: android.support.v4.content.pm.ShortcutManagerCompat.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(android.content.Context context2, android.content.Intent intent) {
                try {
                    intentSender.sendIntent(context2, 0, null, null, null);
                } catch (android.content.IntentSender.SendIntentException unused) {
                }
            }
        }, null, -1, null, null);
        return true;
    }
}
