package com.tencent.ysdk.shell.framework.timertask;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class TaskManager {
    private static final java.lang.String LOG_TAG = "YSDK_TASK";
    private static final int PERIOD = 60000;
    private static volatile com.tencent.ysdk.shell.framework.timertask.TaskManager instance;
    protected java.util.Timer timer = null;
    protected boolean started = false;
    protected long mPeriod = 60000;
    protected java.util.concurrent.ConcurrentHashMap<java.lang.String, com.tencent.ysdk.shell.framework.timertask.BaseTask> mTaskList = new java.util.concurrent.ConcurrentHashMap<>();

    private class TaskDispatcher extends java.util.TimerTask {
        private TaskDispatcher() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            synchronized (com.tencent.ysdk.shell.framework.timertask.TaskManager.this.mTaskList) {
                java.util.Iterator<java.util.Map.Entry<java.lang.String, com.tencent.ysdk.shell.framework.timertask.BaseTask>> it = com.tencent.ysdk.shell.framework.timertask.TaskManager.this.mTaskList.entrySet().iterator();
                while (it.hasNext()) {
                    com.tencent.ysdk.shell.framework.timertask.BaseTask value = it.next().getValue();
                    if (value.getNotifiedTimes() == value.getMyInterval()) {
                        value.run();
                        value.resetNotifiedTimes();
                    }
                    value.increaseNotifiedTimes();
                }
            }
        }
    }

    private TaskManager() {
    }

    public static com.tencent.ysdk.shell.framework.timertask.TaskManager getInstance() {
        if (instance == null) {
            synchronized (com.tencent.ysdk.shell.framework.timertask.TaskManager.class) {
                if (instance == null) {
                    instance = new com.tencent.ysdk.shell.framework.timertask.TaskManager();
                }
            }
        }
        return instance;
    }

    public int addTask(com.tencent.ysdk.shell.framework.timertask.BaseTask baseTask) {
        int i;
        com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "add task:" + baseTask.getTaskName());
        if (this.mTaskList.containsKey(baseTask.getTaskName())) {
            i = -1;
        } else {
            synchronized (this.mTaskList) {
                this.mTaskList.put(baseTask.getTaskName(), baseTask);
                baseTask.resetNotifiedTimes();
            }
            i = 0;
        }
        if (!this.started) {
            startTimer();
        }
        return i;
    }

    public com.tencent.ysdk.shell.framework.timertask.BaseTask getTaskByName(java.lang.String str) {
        if (this.mTaskList.containsKey(str)) {
            return this.mTaskList.get(str);
        }
        return null;
    }

    public java.lang.Boolean removeTask(java.lang.String str) {
        com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "remove task:" + str);
        if (str == null || !this.mTaskList.containsKey(str)) {
            return false;
        }
        synchronized (this.mTaskList) {
            this.mTaskList.remove(str);
        }
        return true;
    }

    public void startTimer() {
        if (this.started) {
            return;
        }
        this.timer = new java.util.Timer();
        this.timer.schedule(new com.tencent.ysdk.shell.framework.timertask.TaskManager.TaskDispatcher(), 0L, this.mPeriod);
        this.started = true;
    }

    public void stopTimer() {
        java.util.Timer timer = this.timer;
        if (timer == null || !this.started) {
            return;
        }
        timer.cancel();
        this.timer = null;
        this.started = false;
    }
}
