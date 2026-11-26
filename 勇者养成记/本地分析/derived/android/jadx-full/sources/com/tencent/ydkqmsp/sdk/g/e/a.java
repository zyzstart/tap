package com.tencent.ydkqmsp.sdk.g.e;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a extends android.content.BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        boolean z = false;
        int intExtra = intent.getIntExtra("openIdNotifyFlag", 0);
        com.tencent.ydkqmsp.sdk.g.e.c.b("shouldUpdateId, notifyFlag : " + intExtra);
        if (intExtra != 1) {
            if (intExtra == 2) {
                java.util.ArrayList<java.lang.String> stringArrayListExtra = intent.getStringArrayListExtra("openIdPackageList");
                if (stringArrayListExtra == null) {
                    return;
                }
                boolean zContains = stringArrayListExtra.contains(context.getPackageName());
                if (zContains) {
                    com.tencent.ydkqmsp.sdk.g.e.b bVarA = com.tencent.ydkqmsp.sdk.g.e.c.a().a(intent.getStringExtra("openIdType"));
                    if (bVarA != null) {
                        bVarA.b();
                        return;
                    }
                    return;
                }
                z = zContains;
            } else {
                z = true;
            }
            if (intExtra == 0 && z) {
                com.tencent.ydkqmsp.sdk.g.e.b bVarA2 = com.tencent.ydkqmsp.sdk.g.e.c.a().a(intent.getStringExtra("openIdType"));
                if (bVarA2 != null) {
                    bVarA2.b();
                    return;
                }
                return;
            }
        } else if (android.text.TextUtils.equals(intent.getStringExtra("openIdPackage"), context.getPackageName())) {
            z = true;
        }
        if (z) {
            com.tencent.ydkqmsp.sdk.g.e.b bVarA3 = com.tencent.ydkqmsp.sdk.g.e.c.a().a(intent.getStringExtra("openIdType"));
            if (bVarA3 != null) {
                bVarA3.b();
            }
        }
    }
}
