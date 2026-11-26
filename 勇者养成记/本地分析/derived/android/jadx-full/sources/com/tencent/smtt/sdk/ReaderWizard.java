package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ReaderWizard {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tencent.smtt.export.external.DexLoader f827a;
    private com.tencent.smtt.sdk.TbsReaderView.ReaderCallback b;

    public ReaderWizard(com.tencent.smtt.sdk.TbsReaderView.ReaderCallback readerCallback) {
        this.f827a = null;
        this.b = null;
        this.f827a = a();
        this.b = readerCallback;
    }

    private static com.tencent.smtt.export.external.DexLoader a() {
        com.tencent.smtt.sdk.s sVarC = com.tencent.smtt.sdk.d.a(true).c();
        if (sVarC != null) {
            return sVarC.b();
        }
        return null;
    }

    public static android.graphics.drawable.Drawable getResDrawable(int i) {
        com.tencent.smtt.export.external.DexLoader dexLoaderA = a();
        if (dexLoaderA != null) {
            java.lang.Object objInvokeStaticMethod = dexLoaderA.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "getResDrawable", new java.lang.Class[]{java.lang.Integer.class}, java.lang.Integer.valueOf(i));
            if (objInvokeStaticMethod instanceof android.graphics.drawable.Drawable) {
                return (android.graphics.drawable.Drawable) objInvokeStaticMethod;
            }
        }
        return null;
    }

    public static java.lang.String getResString(int i) {
        com.tencent.smtt.export.external.DexLoader dexLoaderA = a();
        if (dexLoaderA == null) {
            return "";
        }
        java.lang.Object objInvokeStaticMethod = dexLoaderA.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "getResString", new java.lang.Class[]{java.lang.Integer.class}, java.lang.Integer.valueOf(i));
        return objInvokeStaticMethod instanceof java.lang.String ? (java.lang.String) objInvokeStaticMethod : "";
    }

    public static boolean isSupportCurrentPlatform(android.content.Context context) {
        com.tencent.smtt.export.external.DexLoader dexLoaderA = a();
        if (dexLoaderA == null) {
            return false;
        }
        java.lang.Object objInvokeStaticMethod = dexLoaderA.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "isSupportCurrentPlatform", new java.lang.Class[]{android.content.Context.class}, context);
        if (objInvokeStaticMethod instanceof java.lang.Boolean) {
            return ((java.lang.Boolean) objInvokeStaticMethod).booleanValue();
        }
        return false;
    }

    public static boolean isSupportExt(java.lang.String str) {
        com.tencent.smtt.export.external.DexLoader dexLoaderA = a();
        if (dexLoaderA == null) {
            return false;
        }
        java.lang.Object objInvokeStaticMethod = dexLoaderA.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "isSupportExt", new java.lang.Class[]{java.lang.String.class}, str);
        if (objInvokeStaticMethod instanceof java.lang.Boolean) {
            return ((java.lang.Boolean) objInvokeStaticMethod).booleanValue();
        }
        return false;
    }

    public boolean checkPlugin(java.lang.Object obj, android.content.Context context, java.lang.String str, boolean z) {
        java.lang.String str2;
        java.lang.String str3;
        com.tencent.smtt.export.external.DexLoader dexLoader = this.f827a;
        if (dexLoader == null) {
            str2 = "ReaderWizard";
            str3 = "checkPlugin:Unexpect null object!";
        } else {
            java.lang.Object objInvokeMethod = dexLoader.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "checkPlugin", new java.lang.Class[]{android.content.Context.class, java.lang.String.class, java.lang.Boolean.class}, context, str, java.lang.Boolean.valueOf(z));
            if (objInvokeMethod instanceof java.lang.Boolean) {
                return ((java.lang.Boolean) objInvokeMethod).booleanValue();
            }
            str2 = "ReaderWizard";
            str3 = "Unexpect return value type of call checkPlugin!";
        }
        android.util.Log.e(str2, str3);
        return false;
    }

    public void destroy(java.lang.Object obj) {
        this.b = null;
        com.tencent.smtt.export.external.DexLoader dexLoader = this.f827a;
        if (dexLoader == null || obj == null) {
            android.util.Log.e("ReaderWizard", "destroy:Unexpect null object!");
        } else {
            dexLoader.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "destroy", new java.lang.Class[0], new java.lang.Object[0]);
        }
    }

    public void doCommand(java.lang.Object obj, java.lang.Integer num, java.lang.Object obj2, java.lang.Object obj3) {
        com.tencent.smtt.export.external.DexLoader dexLoader = this.f827a;
        if (dexLoader == null) {
            android.util.Log.e("ReaderWizard", "doCommand:Unexpect null object!");
        } else {
            dexLoader.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "doCommand", new java.lang.Class[]{java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class}, new java.lang.Integer(num.intValue()), obj2, obj3);
        }
    }

    public java.lang.Object getTbsReader() {
        return this.f827a.newInstance("com.tencent.tbs.reader.TbsReader", new java.lang.Class[0], new java.lang.Object[0]);
    }

    public boolean initTbsReader(java.lang.Object obj, android.content.Context context) {
        java.lang.String str;
        java.lang.String str2;
        com.tencent.smtt.export.external.DexLoader dexLoader = this.f827a;
        if (dexLoader == null || obj == null) {
            str = "ReaderWizard";
            str2 = "initTbsReader:Unexpect null object!";
        } else {
            java.lang.Object objInvokeMethod = dexLoader.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "init", new java.lang.Class[]{android.content.Context.class, com.tencent.smtt.export.external.DexLoader.class, java.lang.Object.class}, context, dexLoader, this);
            if (objInvokeMethod instanceof java.lang.Boolean) {
                return ((java.lang.Boolean) objInvokeMethod).booleanValue();
            }
            str = "ReaderWizard";
            str2 = "Unexpect return value type of call initTbsReader!";
        }
        android.util.Log.e(str, str2);
        return false;
    }

    public void onCallBackAction(java.lang.Integer num, java.lang.Object obj, java.lang.Object obj2) {
        com.tencent.smtt.sdk.TbsReaderView.ReaderCallback readerCallback = this.b;
        if (readerCallback != null) {
            readerCallback.onCallBackAction(num, obj, obj2);
        }
    }

    public void onSizeChanged(java.lang.Object obj, int i, int i2) {
        com.tencent.smtt.export.external.DexLoader dexLoader = this.f827a;
        if (dexLoader == null) {
            android.util.Log.e("ReaderWizard", "onSizeChanged:Unexpect null object!");
        } else {
            dexLoader.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "onSizeChanged", new java.lang.Class[]{java.lang.Integer.class, java.lang.Integer.class}, new java.lang.Integer(i), new java.lang.Integer(i2));
        }
    }

    public boolean openFile(java.lang.Object obj, android.content.Context context, android.os.Bundle bundle, android.widget.FrameLayout frameLayout) {
        java.lang.String str;
        java.lang.String str2;
        com.tencent.smtt.export.external.DexLoader dexLoader = this.f827a;
        if (dexLoader == null) {
            str = "ReaderWizard";
            str2 = "openFile:Unexpect null object!";
        } else {
            java.lang.Object objInvokeMethod = dexLoader.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "openFile", new java.lang.Class[]{android.content.Context.class, android.os.Bundle.class, android.widget.FrameLayout.class}, context, bundle, frameLayout);
            if (objInvokeMethod instanceof java.lang.Boolean) {
                return ((java.lang.Boolean) objInvokeMethod).booleanValue();
            }
            str = "ReaderWizard";
            str2 = "Unexpect return value type of call openFile!";
        }
        android.util.Log.e(str, str2);
        return false;
    }

    public void userStatistics(java.lang.Object obj, java.lang.String str) {
        com.tencent.smtt.export.external.DexLoader dexLoader = this.f827a;
        if (dexLoader == null) {
            android.util.Log.e("ReaderWizard", "userStatistics:Unexpect null object!");
        } else {
            dexLoader.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "userStatistics", new java.lang.Class[]{java.lang.String.class}, str);
        }
    }
}
