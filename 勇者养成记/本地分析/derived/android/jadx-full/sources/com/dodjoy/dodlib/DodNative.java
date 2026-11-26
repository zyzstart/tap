package com.dodjoy.dodlib;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class DodNative extends com.dodjoy.dodlib.DodLibBaseMgr {
    private java.lang.String mDataDir;
    private boolean mReadMonoFromSdcard = false;

    public DodNative(java.lang.String str) {
        this.mDataDir = str;
    }

    private native void AddMonoDll(java.lang.String str);

    private boolean CompareAbVersion(java.lang.String str, java.lang.String str2) {
        java.lang.String[] strArrSplit = str.split("\\.");
        if (strArrSplit.length != 2) {
            return false;
        }
        java.lang.String[] strArrSplit2 = str2.split("\\.");
        if (strArrSplit2.length != 2) {
            return false;
        }
        try {
            if (java.lang.Integer.parseInt(strArrSplit[0]) == java.lang.Integer.parseInt(strArrSplit2[0])) {
                if (java.lang.Integer.parseInt(strArrSplit[1]) < java.lang.Integer.parseInt(strArrSplit2[1])) {
                    return false;
                }
            } else if (java.lang.Integer.parseInt(strArrSplit[0]) < java.lang.Integer.parseInt(strArrSplit2[0])) {
                return false;
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    private native int DestroyNative();

    private void ReadNeedLoadMonoFromSdcard(android.content.Context context, java.lang.String str) {
        java.lang.String string = "";
        java.lang.String string2 = "";
        try {
            string = new org.json.JSONObject(com.dodjoy.dodlib.DodLibUtil.ReadText(context.getResources().getAssets().open("ab/root.bytes"))).getString("ver");
        } catch (java.lang.Exception e) {
            android.util.Log.e("dodjoy", "Read app inner root failed:" + e.toString());
        }
        try {
            string2 = new org.json.JSONObject(com.dodjoy.dodlib.DodLibUtil.ReadText(new java.io.FileInputStream(new java.io.File(str + "/StreamingAssets/ab/root.bytes")))).getString("ver");
        } catch (java.lang.Exception e2) {
            android.util.Log.e("dodjoy", "Read asset root failed:" + e2.toString());
        }
        if (string2.isEmpty()) {
            this.mReadMonoFromSdcard = false;
            return;
        }
        this.mReadMonoFromSdcard = !CompareAbVersion(string, string2);
        com.dodjoy.utils.DodLog.e(com.dodjoy.utils.DodLog.TAG, "CompareAbVersion " + string + " sd " + string2 + ", result: " + this.mReadMonoFromSdcard);
    }

    private void RegistMonoDll() {
        AddMonoDll("Assembly");
        AddMonoDll("GameBase");
        AddMonoDll("GameProto");
        AddMonoDll("GameLogic");
        AddMonoDll("GameNative");
        AddMonoDll("GameTerrain");
        AddMonoDll("BattleCore");
        AddMonoDll("Dod");
        AddMonoDll("XGameLib");
    }

    private native int SetupNative(java.lang.String str, int i);

    @Override // com.dodjoy.dodlib.DodLibBaseMgr
    public boolean Create(android.app.Activity activity) {
        java.lang.System.loadLibrary("xzlib");
        java.lang.System.loadLibrary("dodjoy");
        android.os.Bundle bundleGetMetaData = com.dodjoy.platform.PlatformConfig.GetMetaData();
        if (bundleGetMetaData.containsKey(com.dodjoy.dodlib.DodLibMeta.DodUseMonoBdwgc) ? bundleGetMetaData.getBoolean(com.dodjoy.dodlib.DodLibMeta.DodUseMonoBdwgc) : false) {
            java.lang.System.loadLibrary("monobdwgc-2.0");
        } else {
            java.lang.System.loadLibrary("mono");
        }
        java.lang.String str = this.mDataDir;
        ReadNeedLoadMonoFromSdcard(activity, str);
        SetupNative(str + "/StreamingAssets/ab/", this.mReadMonoFromSdcard ? 1 : 0);
        RegistMonoDll();
        return true;
    }

    @Override // com.dodjoy.dodlib.DodLibBaseMgr
    public void Destroy() {
        DestroyNative();
    }
}
