package com.soundcloud.android.crop;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
abstract class MonitoredActivity extends android.app.Activity {
    private final java.util.ArrayList<com.soundcloud.android.crop.MonitoredActivity.LifeCycleListener> listeners = new java.util.ArrayList<>();

    public static class LifeCycleAdapter implements com.soundcloud.android.crop.MonitoredActivity.LifeCycleListener {
        @Override // com.soundcloud.android.crop.MonitoredActivity.LifeCycleListener
        public void onActivityCreated(com.soundcloud.android.crop.MonitoredActivity monitoredActivity) {
        }

        @Override // com.soundcloud.android.crop.MonitoredActivity.LifeCycleListener
        public void onActivityDestroyed(com.soundcloud.android.crop.MonitoredActivity monitoredActivity) {
        }

        @Override // com.soundcloud.android.crop.MonitoredActivity.LifeCycleListener
        public void onActivityStarted(com.soundcloud.android.crop.MonitoredActivity monitoredActivity) {
        }

        @Override // com.soundcloud.android.crop.MonitoredActivity.LifeCycleListener
        public void onActivityStopped(com.soundcloud.android.crop.MonitoredActivity monitoredActivity) {
        }
    }

    public interface LifeCycleListener {
        void onActivityCreated(com.soundcloud.android.crop.MonitoredActivity monitoredActivity);

        void onActivityDestroyed(com.soundcloud.android.crop.MonitoredActivity monitoredActivity);

        void onActivityStarted(com.soundcloud.android.crop.MonitoredActivity monitoredActivity);

        void onActivityStopped(com.soundcloud.android.crop.MonitoredActivity monitoredActivity);
    }

    MonitoredActivity() {
    }

    public void addLifeCycleListener(com.soundcloud.android.crop.MonitoredActivity.LifeCycleListener lifeCycleListener) {
        if (this.listeners.contains(lifeCycleListener)) {
            return;
        }
        this.listeners.add(lifeCycleListener);
    }

    @Override // android.app.Activity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        java.util.Iterator<com.soundcloud.android.crop.MonitoredActivity.LifeCycleListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onActivityCreated(this);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        java.util.Iterator<com.soundcloud.android.crop.MonitoredActivity.LifeCycleListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onActivityDestroyed(this);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        java.util.Iterator<com.soundcloud.android.crop.MonitoredActivity.LifeCycleListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onActivityStarted(this);
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        java.util.Iterator<com.soundcloud.android.crop.MonitoredActivity.LifeCycleListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onActivityStopped(this);
        }
    }

    public void removeLifeCycleListener(com.soundcloud.android.crop.MonitoredActivity.LifeCycleListener lifeCycleListener) {
        this.listeners.remove(lifeCycleListener);
    }
}
