package com.dodjoy.dodlib;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class DodHotIl2cpp extends com.dodjoy.dodlib.DodLibBaseMgr {
    private java.lang.String mDataDir;

    public DodHotIl2cpp(java.lang.String str) {
        this.mDataDir = str;
    }

    private native java.lang.String GetArchAbi();

    private native void HotPatchIl2cpp(java.lang.String str);

    /* JADX WARN: Code duplicated, block: B:22:0x0030 A[Catch: all -> 0x0034, Throwable -> 0x0036, TRY_ENTER, TryCatch #6 {, blocks: (B:3:0x0006, B:10:0x001a, B:22:0x0030, B:23:0x0033), top: B:36:0x0006, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x002c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @android.annotation.TargetApi(19)
    private void copy(java.io.File file, java.io.File file2) throws java.io.IOException {
        java.lang.Throwable th;
        java.lang.Throwable th2;
        java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
        try {
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file2);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = fileInputStream.read(bArr);
                    if (i <= 0) {
                        fileOutputStream.close();
                        fileInputStream.close();
                        return;
                    }
                    fileOutputStream.write(bArr, 0, i);
                }
            } catch (java.lang.Throwable th3) {
                try {
                    throw th3;
                } catch (java.lang.Throwable th4) {
                    th = th3;
                    th2 = th4;
                    if (th == null) {
                        fileOutputStream.close();
                        throw th2;
                    }
                    fileOutputStream.close();
                    throw th2;
                }
            }
        } catch (java.lang.Throwable th5) {
            if (0 != 0) {
                try {
                    fileInputStream.close();
                } catch (java.lang.Throwable unused) {
                }
            } else {
                fileInputStream.close();
            }
            throw th5;
        }
    }

    private java.lang.String readVerFromRoot(java.lang.String str) {
        try {
            java.io.File file = new java.io.File(str);
            return !file.exists() ? "" : new org.json.JSONObject(com.dodjoy.dodlib.DodLibUtil.ReadText(new java.io.FileInputStream(file))).getString("ver");
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.dodjoy.dodlib.DodLibBaseMgr
    public boolean Create(android.app.Activity activity) {
        java.lang.System.loadLibrary("main");
        java.lang.System.loadLibrary("unity");
        java.lang.System.loadLibrary("dod_hot_il2cpp");
        android.util.Log.e("Unity", "cur archi abi is " + GetArchAbi());
        java.lang.String str = GetArchAbi() + "_libil2cpp.so";
        java.lang.String str2 = this.mDataDir + "/StreamingAssets/ab/";
        java.lang.String str3 = str2 + "global-metadata.dat";
        java.io.File file = new java.io.File(str2 + str);
        java.lang.String str4 = str2 + "asset_time.bytes";
        java.lang.String str5 = str2 + "root.bytes";
        java.lang.String str6 = activity.getApplicationContext().getFilesDir().getPath() + "/";
        java.lang.String str7 = str2 + "patch-global-metadata.dat";
        java.lang.String str8 = str6 + "libil2cpp.so";
        java.lang.String str9 = str6 + "root.bytes";
        java.io.File file2 = new java.io.File(str3);
        java.lang.String strReadText = "";
        java.lang.String strReadText2 = "";
        try {
            strReadText = com.dodjoy.dodlib.DodLibUtil.ReadText(activity.getResources().getAssets().open("ab/asset_time.bytes"));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        try {
            strReadText2 = com.dodjoy.dodlib.DodLibUtil.ReadText(new java.io.FileInputStream(new java.io.File(str4)));
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
        if (!strReadText.equals(strReadText2)) {
            try {
                file.delete();
                file2.delete();
                new java.io.File(str7).delete();
                new java.io.File(str9).delete();
            } catch (java.lang.Exception e3) {
                e3.printStackTrace();
            }
            return true;
        }
        if (file.exists() && file2.exists()) {
            java.lang.String verFromRoot = readVerFromRoot(str5);
            java.lang.String verFromRoot2 = readVerFromRoot(str9);
            android.util.Log.e("Unity", verFromRoot + " " + verFromRoot2);
            if (!verFromRoot.equals(verFromRoot2)) {
                try {
                    android.util.Log.e("Unity", "start patch so");
                    copy(file, new java.io.File(str8));
                    copy(new java.io.File(str5), new java.io.File(str9));
                    copy(new java.io.File(str3), new java.io.File(str7));
                } catch (java.lang.Exception e4) {
                    e4.printStackTrace();
                }
            }
            HotPatchIl2cpp(str8);
        }
        return true;
    }

    public java.lang.String getArchName() {
        return GetArchAbi();
    }
}
