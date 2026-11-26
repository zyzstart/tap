package android.support.v7.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class AppCompatDialogFragment extends android.support.v4.app.DialogFragment {
    @Override // android.support.v4.app.DialogFragment
    public android.app.Dialog onCreateDialog(android.os.Bundle bundle) {
        return new android.support.v7.app.AppCompatDialog(getContext(), getTheme());
    }

    @Override // android.support.v4.app.DialogFragment
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public void setupDialog(android.app.Dialog dialog, int i) {
        if (!(dialog instanceof android.support.v7.app.AppCompatDialog)) {
            super.setupDialog(dialog, i);
            return;
        }
        android.support.v7.app.AppCompatDialog appCompatDialog = (android.support.v7.app.AppCompatDialog) dialog;
        switch (i) {
            case 1:
            case 2:
                break;
            case 3:
                dialog.getWindow().addFlags(24);
                break;
            default:
                return;
        }
        appCompatDialog.supportRequestWindowFeature(1);
    }
}
