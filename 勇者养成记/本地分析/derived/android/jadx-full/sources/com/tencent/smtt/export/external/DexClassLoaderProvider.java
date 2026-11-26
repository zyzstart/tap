package com.tencent.smtt.export.external;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class DexClassLoaderProvider extends dalvik.system.DexClassLoader {
    private static final java.lang.String IS_FIRST_LOAD_DEX_FLAG_FILE = "is_first_load_dex_flag_file";
    private static final java.lang.String LAST_DEX_NAME = "tbs_jars_fusion_dex.jar";
    private static final long LOAD_DEX_DELAY = 3000;
    private static final java.lang.String LOGTAG = "dexloader";
    protected static dalvik.system.DexClassLoader mClassLoaderOriginal = null;
    private static android.content.Context mContext = null;
    private static boolean mForceLoadDexFlag = false;
    private static com.tencent.smtt.export.external.DexClassLoaderProvider mInstance;
    private static java.lang.String mRealDexPath;
    protected static android.app.Service mService;
    private com.tencent.smtt.export.external.DexClassLoaderProvider.SpeedyDexClassLoader mClassLoader;

    private static class SpeedyDexClassLoader extends dalvik.system.BaseDexClassLoader {
        public SpeedyDexClassLoader(java.lang.String str, java.io.File file, java.lang.String str2, java.lang.ClassLoader classLoader) {
            super(str, null, str2, classLoader);
        }

        @Override // java.lang.ClassLoader
        public java.lang.Package definePackage(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.net.URL url) {
            return super.definePackage(str, str2, str3, str4, str5, str6, str7, url);
        }

        @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
        public java.lang.Class findClass(java.lang.String str) {
            return super.findClass(str);
        }

        @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
        public java.net.URL findResource(java.lang.String str) {
            return super.findResource(str);
        }

        @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
        public java.util.Enumeration findResources(java.lang.String str) {
            return super.findResources(str);
        }

        @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
        public synchronized java.lang.Package getPackage(java.lang.String str) {
            return super.getPackage(str);
        }

        @Override // java.lang.ClassLoader
        public java.lang.Package[] getPackages() {
            return super.getPackages();
        }

        @Override // java.lang.ClassLoader
        public java.lang.Class loadClass(java.lang.String str, boolean z) {
            return super.loadClass(str, z);
        }
    }

    private DexClassLoaderProvider(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.ClassLoader classLoader, boolean z) {
        super(str, str2, str3, classLoader);
        this.mClassLoader = null;
        if (z) {
            android.util.Log.e(LOGTAG, "SpeedyDexClassLoader: " + mRealDexPath);
            this.mClassLoader = new com.tencent.smtt.export.external.DexClassLoaderProvider.SpeedyDexClassLoader(mRealDexPath, null, str3, classLoader);
            return;
        }
        android.util.Log.e(LOGTAG, "DexClassLoader: " + mRealDexPath);
        this.mClassLoader = null;
    }

    public static dalvik.system.DexClassLoader createDexClassLoader(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.ClassLoader classLoader, android.content.Context context) {
        android.util.Log.i(LOGTAG, "new DexClassLoaderDelegate: " + str + ", context: " + context);
        mContext = context.getApplicationContext();
        mRealDexPath = str;
        int iLastIndexOf = str.lastIndexOf("/") + 1;
        java.lang.String str4 = str.substring(0, iLastIndexOf) + "fake_dex.jar";
        java.lang.String strSubstring = str.substring(iLastIndexOf);
        if (supportSpeedyClassLoader() && is_first_load_tbs_dex(str2, strSubstring)) {
            android.util.Log.d(LOGTAG, "new DexClassLoaderDelegate -- fake: " + str4);
            set_first_load_tbs_dex(str2, strSubstring);
            mInstance = new com.tencent.smtt.export.external.DexClassLoaderProvider(str4, str2, str3, classLoader, true);
            doAsyncDexLoad(strSubstring, str, str2, str3, classLoader);
        } else {
            android.util.Log.d(LOGTAG, "new DexClassLoaderDelegate -- real: " + str);
            mInstance = new com.tencent.smtt.export.external.DexClassLoaderProvider(str, str2, str3, classLoader, false);
        }
        return mInstance;
    }

    private static void doAsyncDexLoad(final java.lang.String str, final java.lang.String str2, final java.lang.String str3, final java.lang.String str4, final java.lang.ClassLoader classLoader) {
        if (shouldUseDexLoaderService()) {
            new java.util.Timer().schedule(new java.util.TimerTask() { // from class: com.tencent.smtt.export.external.DexClassLoaderProvider.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    try {
                        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>(4);
                        arrayList.add(0, str);
                        arrayList.add(1, str2);
                        arrayList.add(2, str3);
                        arrayList.add(3, str4);
                        android.content.Intent intent = new android.content.Intent(com.tencent.smtt.export.external.DexClassLoaderProvider.mContext, (java.lang.Class<?>) com.tencent.smtt.export.external.DexClassLoaderProviderService.class);
                        intent.putStringArrayListExtra("dex2oat", arrayList);
                        com.tencent.smtt.export.external.DexClassLoaderProvider.mContext.startService(intent);
                        android.util.Log.d(com.tencent.smtt.export.external.DexClassLoaderProvider.LOGTAG, "shouldUseDexLoaderService(" + str + ", " + intent + ")");
                    } catch (java.lang.SecurityException e) {
                        android.util.Log.e(com.tencent.smtt.export.external.DexClassLoaderProvider.LOGTAG, "start DexLoaderService exception", e);
                    } catch (java.lang.Throwable th) {
                        android.util.Log.e(com.tencent.smtt.export.external.DexClassLoaderProvider.LOGTAG, "after shouldUseDexLoaderService exception: " + th);
                    }
                }
            }, LOAD_DEX_DELAY);
            return;
        }
        android.util.Log.d(LOGTAG, "Background real dex loading(" + str + ")");
        new java.util.Timer().schedule(new java.util.TimerTask() { // from class: com.tencent.smtt.export.external.DexClassLoaderProvider.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                boolean z;
                try {
                    java.io.File file = new java.io.File(str2.replace(".jar", ".dex"));
                    if (!file.exists() || file.length() == 0) {
                        android.util.Log.d(com.tencent.smtt.export.external.DexClassLoaderProvider.LOGTAG, "" + file + " does not existed!");
                        z = false;
                    } else {
                        android.util.Log.d(com.tencent.smtt.export.external.DexClassLoaderProvider.LOGTAG, "" + file + " existed!");
                        z = true;
                    }
                    java.io.File file2 = new java.io.File(str3);
                    java.io.File file3 = new java.io.File(str2);
                    boolean zExists = file2.exists();
                    boolean zIsDirectory = file2.isDirectory();
                    boolean zExists2 = file3.exists();
                    if (zExists && zIsDirectory && zExists2) {
                        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                        new dalvik.system.DexClassLoader(str2, str3, str4, classLoader);
                        android.util.Log.d(com.tencent.smtt.export.external.DexClassLoaderProvider.LOGTAG, "" + java.lang.String.format("load_dex completed -- cl_cost: %d, existed: %b", java.lang.Long.valueOf(java.lang.System.currentTimeMillis() - jCurrentTimeMillis), java.lang.Boolean.valueOf(z)));
                        if (com.tencent.smtt.export.external.DexClassLoaderProvider.mForceLoadDexFlag && com.tencent.smtt.export.external.DexClassLoaderProvider.LAST_DEX_NAME.equals(str)) {
                            android.util.Log.d(com.tencent.smtt.export.external.DexClassLoaderProvider.LOGTAG, "Stop provider service after loading " + str);
                            if (com.tencent.smtt.export.external.DexClassLoaderProvider.mService != null) {
                                android.util.Log.d(com.tencent.smtt.export.external.DexClassLoaderProvider.LOGTAG, "##Stop service##... ");
                                com.tencent.smtt.export.external.DexClassLoaderProvider.mService.stopSelf();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    android.util.Log.d(com.tencent.smtt.export.external.DexClassLoaderProvider.LOGTAG, "dex loading exception(" + zExists + ", " + zIsDirectory + ", " + zExists2 + ")");
                } catch (java.lang.Throwable th) {
                    android.util.Log.e(com.tencent.smtt.export.external.DexClassLoaderProvider.LOGTAG, "@AsyncDexLoad task exception: " + th);
                }
            }
        }, LOAD_DEX_DELAY);
    }

    private static boolean is_first_load_tbs_dex(java.lang.String str, java.lang.String str2) {
        if (mForceLoadDexFlag) {
            return true;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str2);
        sb.append("_");
        sb.append(IS_FIRST_LOAD_DEX_FLAG_FILE);
        return !new java.io.File(str, sb.toString()).exists();
    }

    static void setForceLoadDexFlag(boolean z, android.app.Service service) {
        mForceLoadDexFlag = z;
        mService = service;
    }

    private static void set_first_load_tbs_dex(java.lang.String str, java.lang.String str2) {
        java.io.File file = new java.io.File(str, str2 + "_" + IS_FIRST_LOAD_DEX_FLAG_FILE);
        if (file.exists()) {
            return;
        }
        try {
            file.createNewFile();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    private static boolean shouldUseDexLoaderService() {
        return !mForceLoadDexFlag && com.tencent.smtt.export.external.DexLoader.mCanUseDexLoaderProviderService;
    }

    private static boolean supportSpeedyClassLoader() {
        return android.os.Build.VERSION.SDK_INT != 21 || com.tencent.smtt.export.external.DexLoader.mCanUseDexLoaderProviderService;
    }

    private boolean useSelfClassloader() {
        return this.mClassLoader == null;
    }

    @Override // java.lang.ClassLoader
    public void clearAssertionStatus() {
        if (useSelfClassloader()) {
            super.clearAssertionStatus();
        } else {
            this.mClassLoader.clearAssertionStatus();
        }
    }

    @Override // java.lang.ClassLoader
    protected java.lang.Package definePackage(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.net.URL url) {
        return useSelfClassloader() ? super.definePackage(str, str2, str3, str4, str5, str6, str7, url) : this.mClassLoader.definePackage(str, str2, str3, str4, str5, str6, str7, url);
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    protected java.lang.Class findClass(java.lang.String str) {
        return useSelfClassloader() ? super.findClass(str) : this.mClassLoader.findClass(str);
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public java.lang.String findLibrary(java.lang.String str) {
        return useSelfClassloader() ? super.findLibrary(str) : this.mClassLoader.findLibrary(str);
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    protected java.net.URL findResource(java.lang.String str) {
        return useSelfClassloader() ? super.findResource(str) : this.mClassLoader.findResource(str);
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    protected java.util.Enumeration findResources(java.lang.String str) {
        return useSelfClassloader() ? super.findResources(str) : this.mClassLoader.findResources(str);
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    protected synchronized java.lang.Package getPackage(java.lang.String str) {
        if (useSelfClassloader()) {
            return super.getPackage(str);
        }
        return this.mClassLoader.getPackage(str);
    }

    @Override // java.lang.ClassLoader
    protected java.lang.Package[] getPackages() {
        return useSelfClassloader() ? super.getPackages() : this.mClassLoader.getPackages();
    }

    @Override // java.lang.ClassLoader
    public java.net.URL getResource(java.lang.String str) {
        return useSelfClassloader() ? super.getResource(str) : this.mClassLoader.getResource(str);
    }

    @Override // java.lang.ClassLoader
    public java.io.InputStream getResourceAsStream(java.lang.String str) {
        return useSelfClassloader() ? getResourceAsStream(str) : this.mClassLoader.getResourceAsStream(str);
    }

    @Override // java.lang.ClassLoader
    public java.util.Enumeration getResources(java.lang.String str) {
        return useSelfClassloader() ? super.getResources(str) : this.mClassLoader.getResources(str);
    }

    @Override // java.lang.ClassLoader
    public java.lang.Class loadClass(java.lang.String str) {
        return useSelfClassloader() ? super.loadClass(str) : this.mClassLoader.loadClass(str);
    }

    @Override // java.lang.ClassLoader
    protected java.lang.Class loadClass(java.lang.String str, boolean z) {
        return useSelfClassloader() ? super.loadClass(str, z) : this.mClassLoader.loadClass(str, z);
    }

    @Override // java.lang.ClassLoader
    public void setClassAssertionStatus(java.lang.String str, boolean z) {
        if (useSelfClassloader()) {
            super.setClassAssertionStatus(str, z);
        } else {
            this.mClassLoader.setClassAssertionStatus(str, z);
        }
    }

    @Override // java.lang.ClassLoader
    public void setDefaultAssertionStatus(boolean z) {
        if (useSelfClassloader()) {
            super.setDefaultAssertionStatus(z);
        } else {
            this.mClassLoader.setDefaultAssertionStatus(z);
        }
    }

    @Override // java.lang.ClassLoader
    public void setPackageAssertionStatus(java.lang.String str, boolean z) {
        if (useSelfClassloader()) {
            super.setPackageAssertionStatus(str, z);
        } else {
            this.mClassLoader.setPackageAssertionStatus(str, z);
        }
    }

    @Override // dalvik.system.BaseDexClassLoader
    public java.lang.String toString() {
        return useSelfClassloader() ? super.toString() : this.mClassLoader.toString();
    }
}
