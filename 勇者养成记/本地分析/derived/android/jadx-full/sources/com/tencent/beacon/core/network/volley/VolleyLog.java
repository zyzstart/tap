package com.tencent.beacon.core.network.volley;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class VolleyLog {
    public static java.lang.String TAG = "Beacon.Volley";
    public static boolean DEBUG = android.util.Log.isLoggable(TAG, 2);
    private static final java.lang.String CLASS_NAME = com.tencent.beacon.core.network.volley.VolleyLog.class.getName();

    static class MarkerLog {
        public static final boolean ENABLED = com.tencent.beacon.core.network.volley.VolleyLog.DEBUG;
        private static final long MIN_DURATION_FOR_LOGGING_MS = 0;
        private final java.util.List mMarkers = new java.util.ArrayList();
        private boolean mFinished = false;

        private static class Marker {
            public final java.lang.String name;
            public final long thread;
            public final long time;

            public Marker(java.lang.String str, long j, long j2) {
                this.name = str;
                this.thread = j;
                this.time = j2;
            }
        }

        MarkerLog() {
        }

        private long getTotalDuration() {
            if (this.mMarkers.size() == 0) {
                return 0L;
            }
            long j = ((com.tencent.beacon.core.network.volley.VolleyLog.MarkerLog.Marker) this.mMarkers.get(0)).time;
            java.util.List list = this.mMarkers;
            return ((com.tencent.beacon.core.network.volley.VolleyLog.MarkerLog.Marker) list.get(list.size() - 1)).time - j;
        }

        public synchronized void add(java.lang.String str, long j) {
            if (this.mFinished) {
                throw new java.lang.IllegalStateException("Marker added to finished log");
            }
            this.mMarkers.add(new com.tencent.beacon.core.network.volley.VolleyLog.MarkerLog.Marker(str, j, android.os.SystemClock.elapsedRealtime()));
        }

        protected synchronized void finalize() {
            if (!this.mFinished) {
                finish("Request on the loose");
                com.tencent.beacon.core.network.volley.VolleyLog.e("Marker log finalized without finish() - uncaught exit point for request", new java.lang.Object[0]);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public synchronized void finish(java.lang.String str) {
            this.mFinished = true;
            long totalDuration = getTotalDuration();
            if (totalDuration <= 0) {
                return;
            }
            long j = ((com.tencent.beacon.core.network.volley.VolleyLog.MarkerLog.Marker) this.mMarkers.get(0)).time;
            com.tencent.beacon.core.network.volley.VolleyLog.d("(%-4d ms) %s", java.lang.Long.valueOf(totalDuration), str);
            for (com.tencent.beacon.core.network.volley.VolleyLog.MarkerLog.Marker marker : this.mMarkers) {
                long j2 = marker.time;
                com.tencent.beacon.core.network.volley.VolleyLog.d("(+%-4d) [%2d] %s", java.lang.Long.valueOf(j2 - j), java.lang.Long.valueOf(marker.thread), marker.name);
                j = j2;
            }
        }
    }

    private static java.lang.String buildMessage(java.lang.String str, java.lang.Object... objArr) {
        if (objArr != null) {
            str = java.lang.String.format(java.util.Locale.US, str, objArr);
        }
        java.lang.StackTraceElement[] stackTrace = new java.lang.Throwable().fillInStackTrace().getStackTrace();
        java.lang.String str2 = "<unknown>";
        for (int i = 2; i < stackTrace.length; i++) {
            if (!stackTrace[i].getClassName().equals(CLASS_NAME)) {
                java.lang.String className = stackTrace[i].getClassName();
                java.lang.String strSubstring = className.substring(className.lastIndexOf(46) + 1);
                str2 = strSubstring.substring(strSubstring.lastIndexOf(36) + 1) + "." + stackTrace[i].getMethodName();
                break;
            }
        }
        return java.lang.String.format(java.util.Locale.US, "[%d] %s: %s", java.lang.Long.valueOf(java.lang.Thread.currentThread().getId()), str2, str);
    }

    public static void d(java.lang.String str, java.lang.Object... objArr) {
        com.tencent.beacon.core.e.d.a(TAG, buildMessage(str, objArr));
    }

    public static void e(java.lang.String str, java.lang.Object... objArr) {
        com.tencent.beacon.core.e.d.b(TAG, buildMessage(str, objArr));
    }

    public static void e(java.lang.Throwable th, java.lang.String str, java.lang.Object... objArr) {
        com.tencent.beacon.core.e.d.b(TAG, buildMessage(str, objArr), th);
    }

    public static void setTag(java.lang.String str) {
        d("Changing log tag to %s", str);
        TAG = str;
        DEBUG = android.util.Log.isLoggable(str, 2);
    }

    public static void v(java.lang.String str, java.lang.Object... objArr) {
        if (DEBUG) {
            com.tencent.beacon.core.e.d.d(TAG, buildMessage(str, objArr));
        }
    }

    public static void wtf(java.lang.String str, java.lang.Object... objArr) {
        com.tencent.beacon.core.e.d.b(TAG, buildMessage(str, objArr));
    }

    public static void wtf(java.lang.Throwable th, java.lang.String str, java.lang.Object... objArr) {
        com.tencent.beacon.core.e.d.b(TAG, buildMessage(str, objArr), th);
    }
}
