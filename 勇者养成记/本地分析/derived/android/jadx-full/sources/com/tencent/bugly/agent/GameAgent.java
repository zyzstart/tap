package com.tencent.bugly.agent;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class GameAgent {
    private static final java.lang.String CLASS_COCOS_ACTIVITY = "org.cocos2dx.lib.Cocos2dxActivity";
    private static final java.lang.String CLASS_UNITY_PLAYER = "com.unity3d.player.UnityPlayer";
    private static final java.lang.String CRASH_REPORT_CLASS_SUFFIX = "crashreport.CrashReport";
    public static final int GAME_TYPE_COCOS = 1;
    public static final int GAME_TYPE_UNITY = 2;
    public static final int GAME_TYPE_UNKNOWN = 0;
    private static final int LOG_LEVEL_DEBUG = 1;
    private static final int LOG_LEVEL_ERROR = 4;
    private static final int LOG_LEVEL_INFO = 2;
    private static final int LOG_LEVEL_VERBOSE = 0;
    private static final int LOG_LEVEL_WARN = 3;
    private static final java.lang.String LOG_TAG = "CrashReport-GameAgent";
    private static final java.lang.String OLD_STRATEGY_CLASS_SUFFIX = "crashreport.CrashReport$UserStrategy";
    private static final java.lang.String STRATEGY_CLASS_SUFFIX = "BuglyStrategy";
    private static final int TYPE_COCOS2DX_JS_CRASH = 5;
    private static final int TYPE_COCOS2DX_LUA_CRASH = 6;
    private static final int TYPE_U3D_CRASH = 4;
    private static final java.lang.String VERSION = "3.2";
    private static boolean hasGuessed = false;
    private static java.lang.ref.WeakReference<android.app.Activity> sActivity = null;
    private static java.lang.String sAppChannel = null;
    private static java.lang.String sAppVersion = null;
    private static java.lang.ref.WeakReference<android.content.Context> sContext = null;
    private static int sGameType = 0;
    private static android.os.Handler sHandler = null;
    private static boolean sIsDebug = false;
    private static java.lang.String sUserId = null;
    private static java.lang.String sdkPackageName = "com.tencent.bugly";

    private static class Reflection {
        private Reflection() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static java.lang.Object getStaticField(java.lang.String str, java.lang.String str2, java.lang.Object obj) {
            try {
                java.lang.reflect.Field declaredField = java.lang.Class.forName(str).getDeclaredField(str2);
                declaredField.setAccessible(true);
                return declaredField.get(obj);
            } catch (java.lang.ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            } catch (java.lang.IllegalAccessException e2) {
                e2.printStackTrace();
                return null;
            } catch (java.lang.NoSuchFieldException e3) {
                e3.printStackTrace();
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static java.lang.Object invokeStaticMethod(java.lang.String str, java.lang.String str2, java.lang.Object[] objArr, java.lang.Class<?>... clsArr) {
            try {
                java.lang.reflect.Method declaredMethod = java.lang.Class.forName(str).getDeclaredMethod(str2, clsArr);
                declaredMethod.setAccessible(true);
                return declaredMethod.invoke(null, objArr);
            } catch (java.lang.ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            } catch (java.lang.IllegalAccessException e2) {
                e2.printStackTrace();
                return null;
            } catch (java.lang.NoSuchMethodException e3) {
                e3.printStackTrace();
                return null;
            } catch (java.lang.reflect.InvocationTargetException e4) {
                e4.printStackTrace();
                return null;
            } catch (java.lang.Exception e5) {
                e5.printStackTrace();
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static java.lang.Object newInstance(java.lang.String str, java.lang.Object[] objArr, java.lang.Class<?>... clsArr) {
            try {
                java.lang.Class<?> cls = java.lang.Class.forName(str);
                return objArr == null ? cls.newInstance() : cls.getConstructor(clsArr).newInstance(objArr);
            } catch (java.lang.ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            } catch (java.lang.IllegalAccessException e2) {
                e2.printStackTrace();
                return null;
            } catch (java.lang.InstantiationException e3) {
                e3.printStackTrace();
                return null;
            } catch (java.lang.NoSuchMethodException e4) {
                e4.printStackTrace();
                return null;
            } catch (java.lang.reflect.InvocationTargetException e5) {
                e5.printStackTrace();
                return null;
            } catch (java.lang.Exception e6) {
                e6.printStackTrace();
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String convertToCanonicalName(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (sdkPackageName == null) {
            sdkPackageName = "com.tencent.bugly";
        }
        sb.append(sdkPackageName);
        sb.append(".");
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void delayExit(long j) {
        long jMax = java.lang.Math.max(0L, j);
        android.os.Handler handler = sHandler;
        if (handler != null) {
            handler.postDelayed(new java.lang.Runnable() { // from class: com.tencent.bugly.agent.GameAgent.1
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.bugly.agent.GameAgent.exitApplication();
                }
            }, jMax);
            return;
        }
        try {
            java.lang.Thread.sleep(jMax);
            exitApplication();
        } catch (java.lang.InterruptedException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void exitApplication() {
        int iMyPid = android.os.Process.myPid();
        printLog(3, java.lang.String.format(java.util.Locale.US, "Exit application by kill process[%d]", java.lang.Integer.valueOf(iMyPid)));
        android.os.Process.killProcess(iMyPid);
    }

    private static android.app.Activity getActivity() {
        android.app.Activity cocosActivity;
        java.lang.ref.WeakReference<android.app.Activity> weakReference = sActivity;
        if (weakReference == null || weakReference.get() == null) {
            switch (sGameType) {
                case 1:
                    cocosActivity = getCocosActivity();
                    break;
                case 2:
                    cocosActivity = getUnityActivity();
                    break;
                default:
                    android.util.Log.w(LOG_TAG, "Game type has not been set.");
                    cocosActivity = guessActivity();
                    break;
            }
            if (cocosActivity != null) {
                sActivity = new java.lang.ref.WeakReference<>(cocosActivity);
            }
        }
        java.lang.ref.WeakReference<android.app.Activity> weakReference2 = sActivity;
        if (weakReference2 != null) {
            return weakReference2.get();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static android.content.Context getApplicationContext() {
        android.app.Activity activity;
        java.lang.ref.WeakReference<android.content.Context> weakReference = sContext;
        if ((weakReference == null || weakReference.get() == null) && (activity = getActivity()) != null) {
            sContext = new java.lang.ref.WeakReference<>(activity.getApplicationContext());
        }
        java.lang.ref.WeakReference<android.content.Context> weakReference2 = sContext;
        if (weakReference2 != null) {
            return weakReference2.get();
        }
        return null;
    }

    public static android.app.Activity getCocosActivity() {
        try {
            java.lang.Object objInvokeStaticMethod = com.tencent.bugly.agent.GameAgent.Reflection.invokeStaticMethod(CLASS_COCOS_ACTIVITY, "getContext", null, new java.lang.Class[0]);
            if (objInvokeStaticMethod != null && (objInvokeStaticMethod instanceof android.app.Activity)) {
                return (android.app.Activity) objInvokeStaticMethod;
            }
        } catch (java.lang.Exception unused) {
            android.util.Log.w(LOG_TAG, "Failed to get activity of Cocos.");
        }
        return null;
    }

    public static android.app.Activity getUnityActivity() {
        try {
            java.lang.Object staticField = com.tencent.bugly.agent.GameAgent.Reflection.getStaticField(CLASS_UNITY_PLAYER, "currentActivity", null);
            if (staticField != null && (staticField instanceof android.app.Activity)) {
                return (android.app.Activity) staticField;
            }
        } catch (java.lang.Exception unused) {
            android.util.Log.w(LOG_TAG, "Failed to get activity of Unity.");
        }
        return null;
    }

    public static java.lang.String getVersion() {
        return VERSION;
    }

    private static android.app.Activity guessActivity() {
        if (hasGuessed) {
            return null;
        }
        hasGuessed = true;
        android.app.Activity activity = sGameType != 0 ? getActivity() : null;
        if (activity == null) {
            sGameType = 1;
            activity = getActivity();
        }
        if (activity == null) {
            sGameType = 2;
            activity = getActivity();
        }
        if (activity == null) {
            sGameType = 0;
        }
        return activity;
    }

    private static void initCrashReport(final java.lang.String str, java.lang.String str2, java.lang.String str3, final java.lang.String str4, long j) {
        final android.content.Context applicationContext = getApplicationContext();
        if (applicationContext == null) {
            printLog(4, "Context is null. bugly initialize terminated.");
        } else {
            if (android.text.TextUtils.isEmpty(str)) {
                printLog(4, "Please input appid when initCrashReport.");
                return;
            }
            sHandler = new android.os.Handler(android.os.Looper.getMainLooper());
            final java.lang.Object objNewStrategy = newStrategy(applicationContext, str2, str3, j);
            runTaskInUiThread(new java.lang.Runnable() { // from class: com.tencent.bugly.agent.GameAgent.2
                /* JADX WARN: Code duplicated, block: B:13:0x0055  */
                @Override // java.lang.Runnable
                public void run() {
                    boolean z;
                    boolean z2 = com.tencent.bugly.agent.GameAgent.sIsDebug;
                    if (objNewStrategy != null) {
                        java.lang.Class<?> cls = null;
                        try {
                            cls = java.lang.Class.forName(com.tencent.bugly.agent.GameAgent.convertToCanonicalName(com.tencent.bugly.agent.GameAgent.OLD_STRATEGY_CLASS_SUFFIX));
                        } catch (java.lang.ClassNotFoundException e) {
                            e.printStackTrace();
                        } catch (java.lang.Exception e2) {
                            e2.printStackTrace();
                        }
                        if (cls != null) {
                            com.tencent.bugly.agent.GameAgent.Reflection.invokeStaticMethod(com.tencent.bugly.agent.GameAgent.convertToCanonicalName(com.tencent.bugly.agent.GameAgent.CRASH_REPORT_CLASS_SUFFIX), "initCrashReport", new java.lang.Object[]{applicationContext, str, java.lang.Boolean.valueOf(z2), objNewStrategy}, android.content.Context.class, java.lang.String.class, java.lang.Boolean.TYPE, cls);
                            z = true;
                        } else {
                            z = false;
                        }
                    } else {
                        z = false;
                    }
                    if (!z) {
                        com.tencent.bugly.agent.GameAgent.Reflection.invokeStaticMethod(com.tencent.bugly.agent.GameAgent.convertToCanonicalName(com.tencent.bugly.agent.GameAgent.CRASH_REPORT_CLASS_SUFFIX), "initCrashReport", new java.lang.Object[]{applicationContext, str, java.lang.Boolean.valueOf(z2)}, android.content.Context.class, java.lang.String.class, java.lang.Boolean.TYPE);
                    }
                    com.tencent.bugly.agent.GameAgent.setUserId(str4);
                }
            });
        }
    }

    public static void initCrashReport(java.lang.String str, boolean z) {
        setLogEnable(z);
        initCrashReport(str, sAppChannel, sAppVersion, sUserId, 0L);
    }

    private static java.lang.Object newStrategy(android.content.Context context, java.lang.String str, java.lang.String str2, long j) {
        java.lang.Object objNewInstance;
        if (context != null && ((!android.text.TextUtils.isEmpty(str) || !android.text.TextUtils.isEmpty(str2)) && (objNewInstance = com.tencent.bugly.agent.GameAgent.Reflection.newInstance(convertToCanonicalName(OLD_STRATEGY_CLASS_SUFFIX), new java.lang.Object[]{context}, android.content.Context.class)) != null)) {
            try {
                java.lang.Class<?> cls = java.lang.Class.forName(convertToCanonicalName(STRATEGY_CLASS_SUFFIX));
                cls.getDeclaredMethod("setAppChannel", java.lang.String.class).invoke(objNewInstance, str);
                cls.getDeclaredMethod("setAppVersion", java.lang.String.class).invoke(objNewInstance, str2);
                cls.getDeclaredMethod("setAppReportDelay", java.lang.Long.TYPE).invoke(objNewInstance, java.lang.Long.valueOf(j));
                return objNewInstance;
            } catch (java.lang.IllegalAccessException e) {
                e.printStackTrace();
            } catch (java.lang.IllegalArgumentException e2) {
                e2.printStackTrace();
            } catch (java.lang.NoSuchMethodException e3) {
                e3.printStackTrace();
            } catch (java.lang.reflect.InvocationTargetException e4) {
                e4.printStackTrace();
            } catch (java.lang.Exception e5) {
                e5.printStackTrace();
            }
        }
        return null;
    }

    private static void postCocosJsException(final int i, final java.lang.String str, final java.lang.String str2, final java.lang.String str3, final boolean z) {
        runTaskInUiThread(new java.lang.Runnable() { // from class: com.tencent.bugly.agent.GameAgent.12
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.bugly.agent.GameAgent.Reflection.invokeStaticMethod(com.tencent.bugly.agent.GameAgent.convertToCanonicalName("crashreport.inner.InnerApi"), "postCocos2dxCrashAsync", new java.lang.Object[]{java.lang.Integer.valueOf(i), str, str2, str3}, java.lang.Integer.TYPE, java.lang.String.class, java.lang.String.class, java.lang.String.class);
                if (z) {
                    com.tencent.bugly.agent.GameAgent.delayExit(3000L);
                }
            }
        });
    }

    private static void postCocosLuaException(final int i, java.lang.String str, final java.lang.String str2, java.lang.String str3, final boolean z) {
        final java.lang.String str4;
        final java.lang.String str5;
        try {
            if (str3.startsWith("stack traceback")) {
                str3 = str3.substring(str3.indexOf("\n") + 1, str3.length()).trim();
            }
            int iIndexOf = str3.indexOf("\n");
            if (iIndexOf > 0) {
                str3 = str3.substring(iIndexOf + 1, str3.length());
            }
            int iIndexOf2 = str3.indexOf("\n");
            java.lang.String strSubstring = iIndexOf2 > 0 ? str3.substring(0, iIndexOf2) : str3;
            int iIndexOf3 = strSubstring.indexOf("]:");
            if (str == null || str.length() == 0) {
                str = iIndexOf3 != -1 ? strSubstring.substring(0, iIndexOf3 + 1) : str2;
            }
            str4 = str;
            str5 = str3;
        } catch (java.lang.Throwable unused) {
            if (str == null || str.length() == 0) {
                str4 = str2;
                str5 = str3;
            } else {
                str4 = str;
                str5 = str3;
            }
        }
        runTaskInUiThread(new java.lang.Runnable() { // from class: com.tencent.bugly.agent.GameAgent.11
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.bugly.agent.GameAgent.Reflection.invokeStaticMethod(com.tencent.bugly.agent.GameAgent.convertToCanonicalName("crashreport.inner.InnerApi"), "postCocos2dxCrashAsync", new java.lang.Object[]{java.lang.Integer.valueOf(i), str4, str2, str5}, java.lang.Integer.TYPE, java.lang.String.class, java.lang.String.class, java.lang.String.class);
                if (z) {
                    com.tencent.bugly.agent.GameAgent.delayExit(3000L);
                }
            }
        });
    }

    public static void postException(int i, java.lang.String str, java.lang.String str2, java.lang.String str3, boolean z) {
        switch (i) {
            case 4:
                postUnityException(str, str2, str3, z);
                break;
            case 5:
                postCocosJsException(i, str, str2, str3, z);
                break;
            case 6:
                postCocosLuaException(i, str, str2, str3, z);
                break;
            default:
                printLog(4, "The category of exception posted is unknown: " + java.lang.String.valueOf(i));
                break;
        }
    }

    private static void postUnityException(final java.lang.String str, final java.lang.String str2, final java.lang.String str3, final boolean z) {
        runTaskInUiThread(new java.lang.Runnable() { // from class: com.tencent.bugly.agent.GameAgent.13
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.bugly.agent.GameAgent.Reflection.invokeStaticMethod(com.tencent.bugly.agent.GameAgent.convertToCanonicalName("crashreport.inner.InnerApi"), "postU3dCrashAsync", new java.lang.Object[]{str, str2, str3}, java.lang.String.class, java.lang.String.class, java.lang.String.class);
                if (z) {
                    com.tencent.bugly.agent.GameAgent.delayExit(3000L);
                }
            }
        });
    }

    private static void printLog(int i, java.lang.String str) {
        setLog(i, LOG_TAG, str);
    }

    public static void printLog(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        if (str.startsWith("<Log>")) {
            printLog(2, str);
            return;
        }
        if (str.startsWith("<LogDebug>")) {
            printLog(1, str);
            return;
        }
        if (str.startsWith("<LogInfo>")) {
            printLog(2, str);
            return;
        }
        if (str.startsWith("<LogWarning>")) {
            printLog(3, str);
            return;
        }
        if (str.startsWith("<LogAssert>")) {
            printLog(3, str);
            return;
        }
        if (str.startsWith("<LogError>")) {
            printLog(4, str);
        } else if (str.startsWith("<LogException>")) {
            printLog(4, str);
        } else {
            printLog(0, str);
        }
    }

    public static void putUserData(final java.lang.String str, final java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        runTaskInUiThread(new java.lang.Runnable() { // from class: com.tencent.bugly.agent.GameAgent.7
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.bugly.agent.GameAgent.Reflection.invokeStaticMethod(com.tencent.bugly.agent.GameAgent.convertToCanonicalName(com.tencent.bugly.agent.GameAgent.CRASH_REPORT_CLASS_SUFFIX), "putUserData", new java.lang.Object[]{com.tencent.bugly.agent.GameAgent.getApplicationContext(), str, str2}, android.content.Context.class, java.lang.String.class, java.lang.String.class);
            }
        });
    }

    public static void removeUserData(final java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        runTaskInUiThread(new java.lang.Runnable() { // from class: com.tencent.bugly.agent.GameAgent.8
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.bugly.agent.GameAgent.Reflection.invokeStaticMethod(com.tencent.bugly.agent.GameAgent.convertToCanonicalName(com.tencent.bugly.agent.GameAgent.CRASH_REPORT_CLASS_SUFFIX), "removeUserData", new java.lang.Object[]{com.tencent.bugly.agent.GameAgent.getApplicationContext(), str}, android.content.Context.class, java.lang.String.class);
            }
        });
    }

    private static void runTaskInUiThread(java.lang.Runnable runnable) {
        android.app.Activity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(runnable);
        } else {
            new java.lang.Thread(runnable).start();
        }
    }

    public static void setAppChannel(final java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        sAppChannel = str;
        runTaskInUiThread(new java.lang.Runnable() { // from class: com.tencent.bugly.agent.GameAgent.4
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.bugly.agent.GameAgent.Reflection.invokeStaticMethod(com.tencent.bugly.agent.GameAgent.convertToCanonicalName(com.tencent.bugly.agent.GameAgent.CRASH_REPORT_CLASS_SUFFIX), "setAppChannel", new java.lang.Object[]{com.tencent.bugly.agent.GameAgent.getApplicationContext(), str}, android.content.Context.class, java.lang.String.class);
            }
        });
    }

    public static void setAppVersion(final java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        sAppVersion = str;
        runTaskInUiThread(new java.lang.Runnable() { // from class: com.tencent.bugly.agent.GameAgent.3
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.bugly.agent.GameAgent.Reflection.invokeStaticMethod(com.tencent.bugly.agent.GameAgent.convertToCanonicalName(com.tencent.bugly.agent.GameAgent.CRASH_REPORT_CLASS_SUFFIX), "setAppVersion", new java.lang.Object[]{com.tencent.bugly.agent.GameAgent.getApplicationContext(), str}, android.content.Context.class, java.lang.String.class);
            }
        });
    }

    public static void setGameType(int i) {
        sGameType = i;
    }

    public static void setLog(int i, final java.lang.String str, final java.lang.String str2) {
        final java.lang.String str3;
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        switch (i) {
            case 0:
                str3 = "v";
                break;
            case 1:
                str3 = "d";
                break;
            case 2:
                str3 = "i";
                break;
            case 3:
                str3 = "w";
                break;
            case 4:
                str3 = "e";
                break;
            default:
                str3 = null;
                break;
        }
        if (str3 != null) {
            runTaskInUiThread(new java.lang.Runnable() { // from class: com.tencent.bugly.agent.GameAgent.10
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.bugly.agent.GameAgent.Reflection.invokeStaticMethod(com.tencent.bugly.agent.GameAgent.convertToCanonicalName("crashreport.BuglyLog"), str3, new java.lang.Object[]{str, str2}, java.lang.String.class, java.lang.String.class);
                }
            });
        }
    }

    public static void setLogEnable(boolean z) {
        sIsDebug = z;
    }

    public static void setSdkConfig(final java.lang.String str, final java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        runTaskInUiThread(new java.lang.Runnable() { // from class: com.tencent.bugly.agent.GameAgent.9
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.bugly.agent.GameAgent.Reflection.invokeStaticMethod(com.tencent.bugly.agent.GameAgent.convertToCanonicalName(com.tencent.bugly.agent.GameAgent.CRASH_REPORT_CLASS_SUFFIX), "putSdkData", new java.lang.Object[]{com.tencent.bugly.agent.GameAgent.getApplicationContext(), "SDK_" + str, str2}, android.content.Context.class, java.lang.String.class, java.lang.String.class);
            }
        });
    }

    public static void setSdkPackageName(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        sdkPackageName = str;
    }

    public static void setUserId(final java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        sUserId = str;
        runTaskInUiThread(new java.lang.Runnable() { // from class: com.tencent.bugly.agent.GameAgent.5
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.bugly.agent.GameAgent.Reflection.invokeStaticMethod(com.tencent.bugly.agent.GameAgent.convertToCanonicalName(com.tencent.bugly.agent.GameAgent.CRASH_REPORT_CLASS_SUFFIX), "setUserId", new java.lang.Object[]{com.tencent.bugly.agent.GameAgent.getApplicationContext(), str}, android.content.Context.class, java.lang.String.class);
            }
        });
    }

    public static void setUserSceneTag(final int i) {
        runTaskInUiThread(new java.lang.Runnable() { // from class: com.tencent.bugly.agent.GameAgent.6
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.bugly.agent.GameAgent.Reflection.invokeStaticMethod(com.tencent.bugly.agent.GameAgent.convertToCanonicalName(com.tencent.bugly.agent.GameAgent.CRASH_REPORT_CLASS_SUFFIX), "setUserSceneTag", new java.lang.Object[]{com.tencent.bugly.agent.GameAgent.getApplicationContext(), java.lang.Integer.valueOf(i)}, android.content.Context.class, java.lang.Integer.TYPE);
            }
        });
    }
}
