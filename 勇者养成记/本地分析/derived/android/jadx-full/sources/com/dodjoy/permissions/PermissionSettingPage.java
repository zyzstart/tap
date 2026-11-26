package com.dodjoy.permissions;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class PermissionSettingPage {
    private static final java.lang.String MARK = android.os.Build.MANUFACTURER.toLowerCase();

    PermissionSettingPage() {
    }

    private static android.content.Intent google(android.content.Context context) {
        android.content.Intent intent = new android.content.Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(android.net.Uri.fromParts("package", context.getPackageName(), null));
        return intent;
    }

    private static boolean hasIntent(android.content.Context context, android.content.Intent intent) {
        return !context.getPackageManager().queryIntentActivities(intent, 65536).isEmpty();
    }

    private static android.content.Intent huawei(android.content.Context context) {
        android.content.Intent intent = new android.content.Intent();
        intent.setClassName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.SingleAppActivity");
        if (hasIntent(context, intent)) {
            return intent;
        }
        intent.setComponent(new android.content.ComponentName("com.android.packageinstaller", "com.android.packageinstaller.permission.ui.ManagePermissionsActivity"));
        if (hasIntent(context, intent)) {
            return intent;
        }
        intent.setComponent(new android.content.ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
        return hasIntent(context, intent) ? intent : intent;
    }

    private static android.content.Intent meizu(android.content.Context context) {
        android.content.Intent intent = new android.content.Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.putExtra("packageName", context.getPackageName());
        intent.setComponent(new android.content.ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
        return intent;
    }

    private static android.content.Intent oppo(android.content.Context context) {
        android.content.Intent intent = new android.content.Intent();
        intent.putExtra("packageName", context.getPackageName());
        intent.setClassName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity");
        if (hasIntent(context, intent)) {
            return intent;
        }
        intent.setClassName("com.coloros.safecenter", "com.coloros.safecenter.permission.PermissionManagerActivity");
        if (hasIntent(context, intent)) {
            return intent;
        }
        try {
            if (android.text.TextUtils.isEmpty((java.lang.String) java.lang.Class.forName("android.os.SystemProperties").getDeclaredMethod("get", java.lang.String.class).invoke(null, "ro.build.version.oplusrom"))) {
                intent.setClassName("com.coloros.securitypermission", "com.coloros.securitypermission.permission.PermissionGroupsActivity");
                if (hasIntent(context, intent)) {
                    return intent;
                }
                intent.setClassName("com.coloros.securitypermission", "com.coloros.securitypermission.permission.PermissionManagerActivity");
                if (hasIntent(context, intent)) {
                    return intent;
                }
            } else {
                intent.setClassName("com.oplus.securitypermission", "com.oplus.securitypermission.permission.PermissionGroupsActivity");
                if (hasIntent(context, intent)) {
                    return intent;
                }
                intent.setClassName("com.oplus.securitypermission", "com.oplus.securitypermission.permission.PermissionManagerActivity");
                if (hasIntent(context, intent)) {
                    return intent;
                }
            }
        } catch (java.lang.Exception unused) {
        }
        intent.setClassName("com.oppo.safe", "com.oppo.safe.permission.PermissionAppListActivity");
        return hasIntent(context, intent) ? intent : intent;
    }

    static void start(android.content.Context context, boolean z) {
        android.content.Intent intentMeizu;
        if (MARK.contains("huawei")) {
            intentMeizu = huawei(context);
        } else if (MARK.contains("xiaomi")) {
            intentMeizu = xiaomi(context);
        } else if (MARK.contains("oppo")) {
            intentMeizu = oppo(context);
        } else if (MARK.contains("vivo")) {
            intentMeizu = vivo(context);
        } else {
            intentMeizu = MARK.contains("meizu") ? meizu(context) : null;
        }
        if (intentMeizu == null || !hasIntent(context, intentMeizu)) {
            intentMeizu = google(context);
        }
        if (z) {
            intentMeizu.addFlags(268435456);
        }
        try {
            context.startActivity(intentMeizu);
        } catch (java.lang.Exception unused) {
            context.startActivity(google(context));
        }
    }

    private static android.content.Intent vivo(android.content.Context context) {
        android.content.Intent intent = new android.content.Intent();
        intent.putExtra("packagename", context.getPackageName());
        intent.setClassName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity");
        if (hasIntent(context, intent)) {
            return intent;
        }
        intent.setClassName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity");
        if (hasIntent(context, intent)) {
            return intent;
        }
        intent.setClassName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.PurviewTabActivity");
        if (hasIntent(context, intent)) {
            return intent;
        }
        intent.setClassName("com.android.packageinstaller", "com.android.packageinstaller.permission.ui.ManagePermissionsActivity");
        if (hasIntent(context, intent)) {
            return intent;
        }
        intent.setComponent(new android.content.ComponentName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity"));
        return intent;
    }

    private static android.content.Intent xiaomi(android.content.Context context) {
        android.content.Intent intent = new android.content.Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.putExtra("extra_pkgname", context.getPackageName());
        if (hasIntent(context, intent)) {
            return intent;
        }
        intent.setPackage("com.miui.securitycenter");
        if (hasIntent(context, intent)) {
            return intent;
        }
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        if (hasIntent(context, intent)) {
            return intent;
        }
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
        return intent;
    }
}
