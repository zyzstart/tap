package com.dodjoy.dodlib;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class BatteryMgr extends com.dodjoy.dodlib.DodLibBaseMgr {
    private android.app.Activity mActivity;
    private android.content.BroadcastReceiver mBroadcastReceiver = null;
    private int mBatteryLevel = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public void SetBatteryLevel(int i) {
        this.mBatteryLevel = i;
    }

    @Override // com.dodjoy.dodlib.DodLibBaseMgr
    public boolean Create(android.app.Activity activity) {
        this.mBroadcastReceiver = new android.content.BroadcastReceiver() { // from class: com.dodjoy.dodlib.BatteryMgr.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(android.content.Context context, android.content.Intent intent) {
                int i = -1;
                int intExtra = intent.getIntExtra(com.qq.gdt.action.ActionUtils.LEVEL, -1);
                int intExtra2 = intent.getIntExtra("scale", -1);
                if (intExtra >= 0 && intExtra2 > 0) {
                    i = (intExtra * 100) / intExtra2;
                }
                com.dodjoy.dodlib.BatteryMgr.this.SetBatteryLevel(i);
            }
        };
        activity.registerReceiver(this.mBroadcastReceiver, new android.content.IntentFilter("android.intent.action.BATTERY_CHANGED"));
        this.mActivity = activity;
        return true;
    }

    @Override // com.dodjoy.dodlib.DodLibBaseMgr
    public void Destroy() {
        android.content.BroadcastReceiver broadcastReceiver;
        android.app.Activity activity = this.mActivity;
        if (activity == null || (broadcastReceiver = this.mBroadcastReceiver) == null) {
            return;
        }
        activity.unregisterReceiver(broadcastReceiver);
        this.mBroadcastReceiver = null;
        this.mActivity = null;
    }

    public int GetBatteryLevel() {
        return this.mBatteryLevel;
    }
}
