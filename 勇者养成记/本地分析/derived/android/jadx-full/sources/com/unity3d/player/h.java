package com.unity3d.player;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class h implements com.unity3d.player.e {
    private static boolean a(android.content.pm.PackageItemInfo packageItemInfo) {
        try {
            return packageItemInfo.metaData.getBoolean("unityplayer.SkipPermissionsDialog");
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    @Override // com.unity3d.player.e
    public final void a(android.app.Activity activity, java.lang.String str) {
        if (activity == null || str == null) {
            return;
        }
        android.app.FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("96489") == null) {
            com.unity3d.player.i iVar = new com.unity3d.player.i();
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString("PermissionNames", str);
            iVar.setArguments(bundle);
            android.app.FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
            fragmentTransactionBeginTransaction.add(0, iVar, "96489");
            fragmentTransactionBeginTransaction.commit();
        }
    }

    @Override // com.unity3d.player.e
    public final boolean a(android.app.Activity activity) {
        try {
            android.content.pm.PackageManager packageManager = activity.getPackageManager();
            return a(packageManager.getActivityInfo(activity.getComponentName(), 128)) || a(packageManager.getApplicationInfo(activity.getPackageName(), 128));
        } catch (java.lang.Exception unused) {
            return false;
        }
    }
}
