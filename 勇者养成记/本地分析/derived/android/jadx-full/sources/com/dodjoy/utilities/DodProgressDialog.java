package com.dodjoy.utilities;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class DodProgressDialog extends android.app.Dialog {
    public DodProgressDialog(android.content.Context context) {
        super(context, context.getResources().getIdentifier("DodLibCustomDialog", "style", context.getPackageName()));
    }

    @Override // android.app.Dialog
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        setContentView(getContext().getResources().getIdentifier("dodlib_waiting_progress", "layout", getContext().getPackageName()));
    }
}
