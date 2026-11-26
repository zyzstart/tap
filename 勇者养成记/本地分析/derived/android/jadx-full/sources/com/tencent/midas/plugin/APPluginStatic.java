package com.tencent.midas.plugin;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class APPluginStatic {
    public static final java.lang.String PARAM_CLASS_STATISTICS_UPLOADER = "clsUploader";
    public static final java.lang.String PARAM_CLEAR_TOP = "cleartop";
    static final java.lang.String PARAM_IS_IN_PLUGIN = "pluginsdk_IsPluginActivity";
    public static final java.lang.String PARAM_LAUNCH_ACTIVITY = "pluginsdk_launchActivity";
    public static final java.lang.String PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY = "PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY";
    public static final java.lang.String PARAM_PLUGIN_IS_NEW_PROCESS = "pluginsdk_isNewProcess";
    public static final java.lang.String PARAM_PLUGIN_LOCATION = "pluginsdk_pluginLocation";
    public static final java.lang.String PARAM_PLUGIN_LOG_ENABLE = "pluginsdk_logEnable";
    public static final java.lang.String PARAM_PLUGIN_NAME = "pluginsdk_pluginName";
    public static final java.lang.String PARAM_PLUGIN_PATH = "pluginsdk_pluginpath";
    public static final java.lang.String PARAM_PLUGIN_RECEIVER_CLASS_NAME = "pluginsdk_launchReceiver";
    private static final java.lang.String TAG = "APPluginStatic";
    public static final int USER_QQ_RESOURCES_NO = -1;
    public static final int USER_QQ_RESOURCES_YES = 1;
    static final java.util.concurrent.ConcurrentHashMap sPackageInfoMap = new java.util.concurrent.ConcurrentHashMap();
    private static java.util.ArrayList sInstances = new java.util.ArrayList();

    static void add(com.tencent.midas.plugin.IAPPluginActivity iAPPluginActivity) {
        updateReference();
        synchronized (sInstances) {
            sInstances.add(new java.lang.ref.WeakReference(iAPPluginActivity));
        }
    }

    static java.util.List getActivitys() {
        return sInstances;
    }

    public static java.lang.ClassLoader getOrCreateClassLoader(android.content.Context context, java.lang.String str) {
        return com.tencent.midas.plugin.APPluginLoader.getOrCreateClassLoader(context, str);
    }

    public static void release() {
        com.tencent.midas.plugin.APPluginLoader.release();
        sPackageInfoMap.clear();
        com.tencent.midas.comm.APLog.d(TAG, "release sInstances size: " + sInstances.size());
    }

    static void remove(com.tencent.midas.plugin.IAPPluginActivity iAPPluginActivity) {
        updateReference();
        removeActivity(iAPPluginActivity);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean removeActivity(com.tencent.midas.plugin.IAPPluginActivity iAPPluginActivity) {
        synchronized (sInstances) {
            for (int i = 0; i < sInstances.size(); i++) {
                if (((java.lang.ref.WeakReference) sInstances.get(i)).get() == iAPPluginActivity) {
                    sInstances.remove(i);
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void removeAll() {
        updateReference();
        synchronized (sInstances) {
            int i = 0;
            while (i < sInstances.size()) {
                com.tencent.midas.plugin.IAPPluginActivity iAPPluginActivity = (com.tencent.midas.plugin.IAPPluginActivity) ((java.lang.ref.WeakReference) sInstances.get(i)).get();
                if (iAPPluginActivity != null) {
                    iAPPluginActivity.IFinish();
                    sInstances.remove(i);
                    i--;
                }
                i++;
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void updateReference() {
        synchronized (sInstances) {
            int i = 0;
            while (i < sInstances.size()) {
                if (((java.lang.ref.WeakReference) sInstances.get(i)).get() == null) {
                    sInstances.remove(i);
                    i--;
                }
                i++;
            }
        }
    }
}
