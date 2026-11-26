package com.tencent.smtt.export.external;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class DexLoader {
    private static final java.lang.String JAVACORE_PACKAGE_PREFIX = "org.chromium";
    private static final java.lang.String TAF_PACKAGE_PREFIX = "com.taf";
    private static final java.lang.String TAG = "DexLoader";
    private static final java.lang.String TBS_FUSION_DEX = "tbs_jars_fusion_dex";
    private static final java.lang.String TBS_WEBVIEW_DEX = "webview_dex";
    private static final java.lang.String TENCENT_PACKAGE_PREFIX = "com.tencent";
    static boolean mCanUseDexLoaderProviderService = true;
    private static boolean mMttClassUseCorePrivate = false;
    private static boolean mUseSpeedyClassLoader = false;
    private static boolean mUseTbsCorePrivateClassLoader = false;
    private dalvik.system.DexClassLoader mClassLoader;

    private static class TbsCorePrivateClassLoader extends dalvik.system.DexClassLoader {
        public TbsCorePrivateClassLoader(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.ClassLoader classLoader) {
            super(str, str2, str3, classLoader);
        }

        @Override // java.lang.ClassLoader
        protected java.lang.Class loadClass(java.lang.String str, boolean z) {
            java.lang.ClassLoader parent;
            if (str == null) {
                return super.loadClass(str, z);
            }
            boolean zStartsWith = str.startsWith(com.tencent.smtt.export.external.DexLoader.JAVACORE_PACKAGE_PREFIX);
            if (com.tencent.smtt.export.external.DexLoader.mMttClassUseCorePrivate) {
                zStartsWith = zStartsWith || str.startsWith(com.tencent.smtt.export.external.DexLoader.TENCENT_PACKAGE_PREFIX) || str.startsWith(com.tencent.smtt.export.external.DexLoader.TAF_PACKAGE_PREFIX);
            }
            if (!zStartsWith) {
                return super.loadClass(str, z);
            }
            java.lang.Class<?> clsFindLoadedClass = findLoadedClass(str);
            if (clsFindLoadedClass != null) {
                return clsFindLoadedClass;
            }
            try {
                android.util.Log.d(com.tencent.smtt.export.external.DexLoader.TAG, "WebCoreClassLoader - loadClass(" + str + "," + z + ")...");
                clsFindLoadedClass = findClass(str);
            } catch (java.lang.ClassNotFoundException unused) {
            }
            return (clsFindLoadedClass != null || (parent = getParent()) == null) ? clsFindLoadedClass : parent.loadClass(str);
        }
    }

    public DexLoader(android.content.Context context, java.lang.String str, java.lang.String str2) {
        this(context, new java.lang.String[]{str}, str2);
    }

    public DexLoader(android.content.Context context, java.lang.String[] strArr, java.lang.String str) {
        this((java.lang.String) null, context, strArr, str);
    }

    public DexLoader(android.content.Context context, java.lang.String[] strArr, java.lang.String str, com.tencent.smtt.export.external.DexLoader dexLoader) {
        dalvik.system.DexClassLoader classLoader = dexLoader.getClassLoader();
        for (java.lang.String str2 : strArr) {
            classLoader = createDexClassLoader(str2, str, context.getApplicationInfo().nativeLibraryDir, classLoader, context);
            this.mClassLoader = classLoader;
        }
    }

    public DexLoader(android.content.Context context, java.lang.String[] strArr, java.lang.String str, java.lang.String str2) {
        java.lang.ClassLoader classLoader = context.getClassLoader();
        java.lang.String str3 = context.getApplicationInfo().nativeLibraryDir;
        if (!android.text.TextUtils.isEmpty(str2)) {
            str3 = str3 + java.io.File.pathSeparator + str2;
        }
        int i = 0;
        java.lang.ClassLoader classLoader2 = classLoader;
        while (i < strArr.length) {
            dalvik.system.DexClassLoader dexClassLoaderCreateDexClassLoader = createDexClassLoader(strArr[i], str, str3, classLoader2, context);
            this.mClassLoader = dexClassLoaderCreateDexClassLoader;
            i++;
            classLoader2 = dexClassLoaderCreateDexClassLoader;
        }
    }

    public DexLoader(java.lang.String str, android.content.Context context, java.lang.String[] strArr, java.lang.String str2) {
        this(str, context, strArr, str2, null);
    }

    public DexLoader(java.lang.String str, android.content.Context context, java.lang.String[] strArr, java.lang.String str2, java.util.Map map) {
        initTbsSettings(map);
        java.lang.ClassLoader callingClassLoader = dalvik.system.VMStack.getCallingClassLoader();
        callingClassLoader = callingClassLoader == null ? context.getClassLoader() : callingClassLoader;
        android.util.Log.d("dexloader", "Set base classLoader for DexClassLoader: " + callingClassLoader);
        int i = 0;
        java.lang.ClassLoader classLoader = callingClassLoader;
        while (i < strArr.length) {
            dalvik.system.DexClassLoader dexClassLoaderCreateDexClassLoader = createDexClassLoader(strArr[i], str2, str, classLoader, context);
            this.mClassLoader = dexClassLoaderCreateDexClassLoader;
            i++;
            classLoader = dexClassLoaderCreateDexClassLoader;
        }
    }

    private dalvik.system.DexClassLoader createDexClassLoader(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.ClassLoader classLoader, android.content.Context context) {
        dalvik.system.DexClassLoader dexClassLoader;
        android.util.Log.d("dexloader", "createDexClassLoader: " + str);
        if (shouldUseTbsCorePrivateClassLoader(str)) {
            dexClassLoader = new com.tencent.smtt.export.external.DexLoader.TbsCorePrivateClassLoader(str, str2, str3, classLoader);
        } else {
            int i = android.os.Build.VERSION.SDK_INT;
            if (i < 21 || i > 25 || !mUseSpeedyClassLoader) {
                android.util.Log.d("dexloader", "sync odex...new DexClassLoader");
                dexClassLoader = new dalvik.system.DexClassLoader(str, str2, str3, classLoader);
            } else {
                android.util.Log.d("dexloader", "async odex...DexClassLoaderProvider.createDexClassLoader");
                try {
                    dexClassLoader = com.tencent.smtt.export.external.DexClassLoaderProvider.createDexClassLoader(str, str2, str3, classLoader, context);
                } catch (java.lang.Throwable th) {
                    android.util.Log.e("dexloader", "createDexClassLoader exception: " + th);
                    android.util.Log.d("dexloader", "sync odex...new DexClassLoader#2");
                    dexClassLoader = new dalvik.system.DexClassLoader(str, str2, str3, classLoader);
                }
            }
        }
        android.util.Log.d("dexloader", "createDexClassLoader result: " + dexClassLoader);
        return dexClassLoader;
    }

    public static void initTbsSettings(java.util.Map map) {
        android.util.Log.d(TAG, "initTbsSettings - " + map);
        if (map != null) {
            try {
                java.lang.Object obj = map.get(com.tencent.smtt.export.external.TbsCoreSettings.TBS_SETTINGS_USE_PRIVATE_CLASSLOADER);
                if (obj instanceof java.lang.Boolean) {
                    mUseTbsCorePrivateClassLoader = ((java.lang.Boolean) obj).booleanValue();
                }
                java.lang.Object obj2 = map.get(com.tencent.smtt.export.external.TbsCoreSettings.TBS_SETTINGS_USE_SPEEDY_CLASSLOADER);
                if (obj2 instanceof java.lang.Boolean) {
                    mUseSpeedyClassLoader = ((java.lang.Boolean) obj2).booleanValue();
                }
                java.lang.Object obj3 = map.get(com.tencent.smtt.export.external.TbsCoreSettings.TBS_SETTINGS_USE_DEXLOADER_SERVICE);
                if (obj3 instanceof java.lang.Boolean) {
                    mCanUseDexLoaderProviderService = ((java.lang.Boolean) obj3).booleanValue();
                }
                java.lang.Object obj4 = map.get(com.tencent.smtt.export.external.TbsCoreSettings.TBS_SETTINGS_PRAVITE_MTT_CLASSES);
                if (obj4 instanceof java.lang.Boolean) {
                    mMttClassUseCorePrivate = ((java.lang.Boolean) obj4).booleanValue();
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private boolean shouldUseTbsCorePrivateClassLoader(java.lang.String str) {
        if (mUseTbsCorePrivateClassLoader) {
            return str.contains(TBS_FUSION_DEX) || str.contains(TBS_WEBVIEW_DEX);
        }
        return false;
    }

    public dalvik.system.DexClassLoader getClassLoader() {
        return this.mClassLoader;
    }

    public java.lang.Object getStaticField(java.lang.String str, java.lang.String str2) {
        try {
            java.lang.reflect.Field field = this.mClassLoader.loadClass(str).getField(str2);
            field.setAccessible(true);
            return field.get(null);
        } catch (java.lang.Throwable th) {
            android.util.Log.e(com.tencent.smtt.export.external.DexLoader.class.getSimpleName(), "'" + str + "' get field '" + str2 + "' failed", th);
            return null;
        }
    }

    public java.lang.Object invokeMethod(java.lang.Object obj, java.lang.String str, java.lang.String str2, java.lang.Class[] clsArr, java.lang.Object... objArr) {
        try {
            java.lang.reflect.Method method = this.mClassLoader.loadClass(str).getMethod(str2, clsArr);
            method.setAccessible(true);
            return method.invoke(obj, objArr);
        } catch (java.lang.Throwable th) {
            android.util.Log.e(com.tencent.smtt.export.external.DexLoader.class.getSimpleName(), "'" + str + "' invoke method '" + str2 + "' failed", th);
            return null;
        }
    }

    public java.lang.Object invokeStaticMethod(java.lang.String str, java.lang.String str2, java.lang.Class[] clsArr, java.lang.Object... objArr) {
        try {
            java.lang.reflect.Method method = this.mClassLoader.loadClass(str).getMethod(str2, clsArr);
            method.setAccessible(true);
            return method.invoke(null, objArr);
        } catch (java.lang.Throwable th) {
            if (str2 == null || !str2.equalsIgnoreCase("initTesRuntimeEnvironment")) {
                android.util.Log.e(com.tencent.smtt.export.external.DexLoader.class.getSimpleName(), "'" + str + "' invoke static method '" + str2 + "' failed", th);
                return null;
            }
            android.util.Log.e(com.tencent.smtt.export.external.DexLoader.class.getSimpleName(), "'" + str + "' invoke static method '" + str2 + "' failed", th);
            return th;
        }
    }

    public java.lang.Class loadClass(java.lang.String str) {
        try {
            return this.mClassLoader.loadClass(str);
        } catch (java.lang.Throwable th) {
            android.util.Log.e(com.tencent.smtt.export.external.DexLoader.class.getSimpleName(), "loadClass '" + str + "' failed", th);
            return null;
        }
    }

    public java.lang.Object newInstance(java.lang.String str) {
        try {
            return this.mClassLoader.loadClass(str).newInstance();
        } catch (java.lang.Throwable th) {
            android.util.Log.e(com.tencent.smtt.export.external.DexLoader.class.getSimpleName(), "create " + str + " instance failed", th);
            return null;
        }
    }

    public java.lang.Object newInstance(java.lang.String str, java.lang.Class[] clsArr, java.lang.Object... objArr) {
        try {
            return this.mClassLoader.loadClass(str).getConstructor(clsArr).newInstance(objArr);
        } catch (java.lang.Throwable th) {
            if ("com.tencent.smtt.webkit.adapter.X5WebViewAdapter".equalsIgnoreCase(str)) {
                android.util.Log.e(com.tencent.smtt.export.external.DexLoader.class.getSimpleName(), "'newInstance " + str + " failed", th);
                return th;
            }
            android.util.Log.e(com.tencent.smtt.export.external.DexLoader.class.getSimpleName(), "create '" + str + "' instance failed", th);
            return null;
        }
    }

    public void setStaticField(java.lang.String str, java.lang.String str2, java.lang.Object obj) {
        try {
            java.lang.reflect.Field field = this.mClassLoader.loadClass(str).getField(str2);
            field.setAccessible(true);
            field.set(null, obj);
        } catch (java.lang.Throwable th) {
            android.util.Log.e(com.tencent.smtt.export.external.DexLoader.class.getSimpleName(), "'" + str + "' set field '" + str2 + "' failed", th);
        }
    }
}
