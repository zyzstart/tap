package com.unity3d.player;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class i extends android.app.Fragment {
    @Override // android.app.Fragment
    public final void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        requestPermissions(new java.lang.String[]{getArguments().getString("PermissionNames")}, 96489);
    }

    @Override // android.app.Fragment
    public final void onRequestPermissionsResult(int i, java.lang.String[] strArr, int[] iArr) {
        if (i != 96489) {
            return;
        }
        if (strArr.length == 0) {
            requestPermissions(new java.lang.String[]{getArguments().getString("PermissionNames")}, 96489);
            return;
        }
        android.app.FragmentTransaction fragmentTransactionBeginTransaction = getActivity().getFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.remove(this);
        fragmentTransactionBeginTransaction.commit();
    }
}
