package com.tencent.ysdk.shell.module.icon.impl.memclean;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class MemoryAccelerateManager {
    private static final java.lang.String TAG = "YSDK MemoryAccelerate";
    private static volatile com.tencent.ysdk.shell.module.icon.impl.memclean.MemoryAccelerateManager instance;
    private android.app.ActivityManager mActivityManager;
    private java.util.HashSet<java.lang.Integer> mImportantUids;
    private android.content.pm.PackageManager mPackageManager;
    private java.lang.ref.ReferenceQueue<com.tencent.ysdk.shell.module.icon.impl.memclean.MemCleanListener> mMemCleanWeakQueue = new java.lang.ref.ReferenceQueue<>();
    private java.util.concurrent.ConcurrentLinkedQueue<java.lang.ref.WeakReference<com.tencent.ysdk.shell.module.icon.impl.memclean.MemCleanListener>> mMemCleanCallbacks = new java.util.concurrent.ConcurrentLinkedQueue<>();
    private java.util.HashMap<android.content.ComponentName, android.content.pm.ServiceInfo> mServiceCaches = new java.util.HashMap<>();
    private java.util.List<java.lang.String> mInnerWhiteList = new java.util.ArrayList();
    private android.content.Context context = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext();

    private class ProcessKillRunnable implements java.lang.Runnable {
        private java.util.List<java.lang.String> mPkgs = new java.util.ArrayList();
        private java.util.List<android.app.ActivityManager.RunningServiceInfo> mRunningServices = new java.util.ArrayList();
        private boolean usePerRoot;

        public ProcessKillRunnable(java.util.List<java.lang.String> list, java.util.List<android.app.ActivityManager.RunningServiceInfo> list2) {
            this.mPkgs.clear();
            this.mPkgs.addAll(list);
            this.mRunningServices.clear();
            this.mRunningServices.addAll(list2);
        }

        private android.content.pm.ServiceInfo checkAndGetServiceInfo(android.app.ActivityManager.RunningServiceInfo runningServiceInfo, android.content.pm.ServiceInfo serviceInfo) {
            if (serviceInfo == null) {
                try {
                    serviceInfo = com.tencent.ysdk.shell.module.icon.impl.memclean.MemoryAccelerateManager.this.mPackageManager.getServiceInfo(runningServiceInfo.service, 0);
                } catch (java.lang.Throwable unused) {
                }
                if (serviceInfo != null) {
                    com.tencent.ysdk.shell.module.icon.impl.memclean.MemoryAccelerateManager.this.mServiceCaches.put(runningServiceInfo.service, serviceInfo);
                }
            }
            return serviceInfo;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private synchronized void killRunningProcesses(java.lang.String str) {
            android.content.pm.ServiceInfo serviceInfoCheckAndGetServiceInfo;
            if (com.tencent.ysdk.shell.module.icon.impl.memclean.MemoryAccelerateManager.this.context.checkCallingOrSelfPermission("android.permission.KILL_BACKGROUND_PROCESSES") != 0) {
                return;
            }
            if (this.mRunningServices == null) {
                com.tencent.ysdk.shell.module.icon.impl.memclean.MemoryAccelerateManager.this.mActivityManager.killBackgroundProcesses(str);
                return;
            }
            for (android.app.ActivityManager.RunningServiceInfo runningServiceInfo : this.mRunningServices) {
                if (runningServiceInfo.service.getPackageName().equals(str) && (serviceInfoCheckAndGetServiceInfo = checkAndGetServiceInfo(runningServiceInfo, (android.content.pm.ServiceInfo) com.tencent.ysdk.shell.module.icon.impl.memclean.MemoryAccelerateManager.this.mServiceCaches.get(runningServiceInfo.service))) != null && serviceInfoCheckAndGetServiceInfo.permission == null && serviceInfoCheckAndGetServiceInfo.exported) {
                    android.content.Intent intent = new android.content.Intent();
                    intent.setComponent(runningServiceInfo.service);
                    try {
                        com.tencent.ysdk.shell.module.icon.impl.memclean.MemoryAccelerateManager.this.context.stopService(intent);
                    } catch (java.lang.Exception unused) {
                    }
                }
            }
            com.tencent.ysdk.shell.module.icon.impl.memclean.MemoryAccelerateManager.this.mActivityManager.killBackgroundProcesses(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            java.util.List<java.lang.String> list = this.mPkgs;
            if (list == null || list.isEmpty()) {
                return;
            }
            java.util.Iterator<java.lang.String> it = this.mPkgs.iterator();
            while (it.hasNext()) {
                killRunningProcesses(it.next());
            }
        }
    }

    private MemoryAccelerateManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doMemoryClean(java.util.ArrayList<java.lang.String> arrayList, com.tencent.ysdk.shell.module.icon.impl.memclean.MemCleanListener memCleanListener) {
        if (arrayList.size() == 0) {
            return;
        }
        new com.tencent.ysdk.shell.module.icon.impl.memclean.MemoryAccelerateManager.ProcessKillRunnable(arrayList, this.mActivityManager.getRunningServices(android.support.v7.widget.ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED)).run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.util.ArrayList<com.tencent.ysdk.shell.module.icon.impl.memclean.MemCleanAppInfo> doMemoryScan(boolean z) {
        java.util.HashMap map = new java.util.HashMap();
        java.util.ArrayList arrayList = new java.util.ArrayList(this.mInnerWhiteList);
        java.util.List<android.app.ActivityManager.RunningAppProcessInfo> runningAppProcesses = this.mActivityManager.getRunningAppProcesses();
        if (runningAppProcesses == null || runningAppProcesses.isEmpty()) {
            return new java.util.ArrayList<>(map.values());
        }
        doScanMemoryInner(z, map, arrayList, runningAppProcesses);
        return new java.util.ArrayList<>(map.values());
    }

    private void doScanMemoryInner(boolean z, java.util.Map<java.lang.String, com.tencent.ysdk.shell.module.icon.impl.memclean.MemCleanAppInfo> map, java.util.List<java.lang.String> list, java.util.List<android.app.ActivityManager.RunningAppProcessInfo> list2) {
        com.tencent.ysdk.shell.module.icon.impl.memclean.MemCleanAppInfo memCleanAppInfo;
        for (android.app.ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list2) {
            if (!isSystemImportantProcess(runningAppProcessInfo)) {
                java.lang.String str = !runningAppProcessInfo.processName.contains(":") ? runningAppProcessInfo.processName : runningAppProcessInfo.processName.split(":")[0];
                if (!isNeedAdd2IgnoreList(runningAppProcessInfo, list, str)) {
                    if (map.containsKey(str)) {
                        memCleanAppInfo = map.get(str);
                    } else {
                        memCleanAppInfo = new com.tencent.ysdk.shell.module.icon.impl.memclean.MemCleanAppInfo();
                        memCleanAppInfo.packageName = str;
                        getAppNameIfNeed(z, str, memCleanAppInfo);
                        map.put(str, memCleanAppInfo);
                    }
                    android.os.Debug.MemoryInfo[] processMemoryInfo = this.mActivityManager.getProcessMemoryInfo(new int[]{runningAppProcessInfo.pid});
                    if (processMemoryInfo != null && processMemoryInfo.length > 0) {
                        memCleanAppInfo.totlaMemory += (long) (processMemoryInfo[0].getTotalPss() * 1024);
                    }
                } else if (!list.contains(str)) {
                    list.add(str);
                }
            }
        }
    }

    private void getAppNameIfNeed(boolean z, java.lang.String str, com.tencent.ysdk.shell.module.icon.impl.memclean.MemCleanAppInfo memCleanAppInfo) {
        if (z) {
            try {
                android.content.pm.ApplicationInfo applicationInfo = this.mPackageManager.getApplicationInfo(str, 0);
                memCleanAppInfo.isSystem = (applicationInfo.flags & 1) > 0;
                memCleanAppInfo.appName = applicationInfo.loadLabel(this.mPackageManager).toString();
            } catch (java.lang.Throwable unused) {
                memCleanAppInfo.appName = str;
                memCleanAppInfo.isSystem = true;
            }
        }
    }

    public static com.tencent.ysdk.shell.module.icon.impl.memclean.MemoryAccelerateManager getInstance() {
        if (instance == null) {
            synchronized (com.tencent.ysdk.shell.module.user.UserApi.class) {
                if (instance == null) {
                    instance = new com.tencent.ysdk.shell.module.icon.impl.memclean.MemoryAccelerateManager();
                }
            }
        }
        return instance;
    }

    private boolean isNeedAdd2IgnoreList(android.app.ActivityManager.RunningAppProcessInfo runningAppProcessInfo, java.util.List<java.lang.String> list, java.lang.String str) {
        return isVisiableProcess(runningAppProcessInfo) || list.contains(str) || str.equals(this.context.getPackageName());
    }

    private boolean isSystemImportantProcess(android.app.ActivityManager.RunningAppProcessInfo runningAppProcessInfo) {
        return this.mImportantUids.contains(java.lang.Integer.valueOf(runningAppProcessInfo.uid));
    }

    private boolean isVisiableProcess(android.app.ActivityManager.RunningAppProcessInfo runningAppProcessInfo) {
        return runningAppProcessInfo.importance <= 100;
    }

    public void registerMemCleanCallback(com.tencent.ysdk.shell.module.icon.impl.memclean.MemCleanListener memCleanListener) {
        if (memCleanListener == null) {
            return;
        }
        while (true) {
            java.lang.ref.WeakReference weakReference = (java.lang.ref.WeakReference) this.mMemCleanWeakQueue.poll();
            if (weakReference == null) {
                break;
            } else {
                this.mMemCleanCallbacks.remove(weakReference);
            }
        }
        boolean z = true;
        java.util.Iterator<java.lang.ref.WeakReference<com.tencent.ysdk.shell.module.icon.impl.memclean.MemCleanListener>> it = this.mMemCleanCallbacks.iterator();
        while (it.hasNext()) {
            if (it.next().get() == memCleanListener) {
                z = false;
                break;
            }
        }
        if (z) {
            this.mMemCleanCallbacks.add(new java.lang.ref.WeakReference<>(memCleanListener, this.mMemCleanWeakQueue));
        }
    }

    public void startMemoryScanAndClean(final com.tencent.ysdk.shell.module.icon.impl.memclean.MemCleanListener memCleanListener) {
        this.mActivityManager = (android.app.ActivityManager) this.context.getSystemService("activity");
        this.mPackageManager = this.context.getPackageManager();
        this.mImportantUids = new java.util.HashSet<>(java.util.Arrays.asList(com.tencent.ysdk.shell.module.icon.impl.memclean.MemConstant.STSTEM_UIDS));
        this.mInnerWhiteList = java.util.Arrays.asList(com.tencent.ysdk.shell.module.icon.impl.memclean.MemConstant.INNER_WHITE_LIST);
        com.tencent.ysdk.shell.libware.thread.YSDKThreadManager.getInstance().start(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.module.icon.impl.memclean.MemoryAccelerateManager.1
            @Override // java.lang.Runnable
            public void run() {
                java.util.ArrayList<com.tencent.ysdk.shell.module.icon.impl.memclean.MemCleanAppInfo> arrayListDoMemoryScan = com.tencent.ysdk.shell.module.icon.impl.memclean.MemoryAccelerateManager.this.doMemoryScan(false);
                memCleanListener.onScanFinished(arrayListDoMemoryScan);
                android.util.Log.d(com.tencent.ysdk.shell.module.icon.impl.memclean.MemoryAccelerateManager.TAG, "appList: " + arrayListDoMemoryScan);
                long j = 0;
                if (arrayListDoMemoryScan == null || arrayListDoMemoryScan.isEmpty()) {
                    memCleanListener.onCleanFinished(0L);
                    return;
                }
                if (com.tencent.ysdk.shell.module.icon.impl.memclean.MemoryAccelerateManager.this.mInnerWhiteList != null && !com.tencent.ysdk.shell.module.icon.impl.memclean.MemoryAccelerateManager.this.mInnerWhiteList.isEmpty()) {
                    java.util.Iterator<com.tencent.ysdk.shell.module.icon.impl.memclean.MemCleanAppInfo> it = arrayListDoMemoryScan.iterator();
                    while (it.hasNext()) {
                        com.tencent.ysdk.shell.module.icon.impl.memclean.MemCleanAppInfo next = it.next();
                        java.util.Iterator it2 = com.tencent.ysdk.shell.module.icon.impl.memclean.MemoryAccelerateManager.this.mInnerWhiteList.iterator();
                        while (it2.hasNext()) {
                            if (((java.lang.String) it2.next()).equals(next.packageName)) {
                                it.remove();
                                break;
                            }
                        }
                    }
                }
                java.util.ArrayList arrayList = new java.util.ArrayList();
                for (com.tencent.ysdk.shell.module.icon.impl.memclean.MemCleanAppInfo memCleanAppInfo : arrayListDoMemoryScan) {
                    arrayList.add(memCleanAppInfo.packageName);
                    j += memCleanAppInfo.totlaMemory;
                }
                android.util.Log.d(com.tencent.ysdk.shell.module.icon.impl.memclean.MemoryAccelerateManager.TAG, "pkgToKill----->" + arrayList.toString() + "memFree--->" + j);
                memCleanListener.onCleanFinished(j);
                com.tencent.ysdk.shell.module.icon.impl.memclean.MemoryAccelerateManager.this.doMemoryClean(arrayList, memCleanListener);
            }
        });
    }
}
