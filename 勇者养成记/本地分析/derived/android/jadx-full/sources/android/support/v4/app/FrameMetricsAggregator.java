package android.support.v4.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class FrameMetricsAggregator {
    public static final int ANIMATION_DURATION = 256;
    public static final int ANIMATION_INDEX = 8;
    public static final int COMMAND_DURATION = 32;
    public static final int COMMAND_INDEX = 5;
    private static final boolean DBG = false;
    public static final int DELAY_DURATION = 128;
    public static final int DELAY_INDEX = 7;
    public static final int DRAW_DURATION = 8;
    public static final int DRAW_INDEX = 3;
    public static final int EVERY_DURATION = 511;
    public static final int INPUT_DURATION = 2;
    public static final int INPUT_INDEX = 1;
    private static final int LAST_INDEX = 8;
    public static final int LAYOUT_MEASURE_DURATION = 4;
    public static final int LAYOUT_MEASURE_INDEX = 2;
    public static final int SWAP_DURATION = 64;
    public static final int SWAP_INDEX = 6;
    public static final int SYNC_DURATION = 16;
    public static final int SYNC_INDEX = 4;
    private static final java.lang.String TAG = "FrameMetrics";
    public static final int TOTAL_DURATION = 1;
    public static final int TOTAL_INDEX = 0;
    private android.support.v4.app.FrameMetricsAggregator.FrameMetricsBaseImpl mInstance;

    @android.support.annotation.RequiresApi(24)
    private static class FrameMetricsApi24Impl extends android.support.v4.app.FrameMetricsAggregator.FrameMetricsBaseImpl {
        private static final int NANOS_PER_MS = 1000000;
        private static final int NANOS_ROUNDING_VALUE = 500000;
        private static android.os.Handler sHandler;
        private static android.os.HandlerThread sHandlerThread;
        private java.util.ArrayList<java.lang.ref.WeakReference<android.app.Activity>> mActivities;
        android.view.Window.OnFrameMetricsAvailableListener mListener;
        private android.util.SparseIntArray[] mMetrics;
        private int mTrackingFlags;

        FrameMetricsApi24Impl(int i) {
            super();
            this.mMetrics = new android.util.SparseIntArray[9];
            this.mActivities = new java.util.ArrayList<>();
            this.mListener = new android.view.Window.OnFrameMetricsAvailableListener() { // from class: android.support.v4.app.FrameMetricsAggregator.FrameMetricsApi24Impl.1
                @Override // android.view.Window.OnFrameMetricsAvailableListener
                public void onFrameMetricsAvailable(android.view.Window window, android.view.FrameMetrics frameMetrics, int i2) {
                    if ((android.support.v4.app.FrameMetricsAggregator.FrameMetricsApi24Impl.this.mTrackingFlags & 1) != 0) {
                        android.support.v4.app.FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl = android.support.v4.app.FrameMetricsAggregator.FrameMetricsApi24Impl.this;
                        frameMetricsApi24Impl.addDurationItem(frameMetricsApi24Impl.mMetrics[0], frameMetrics.getMetric(8));
                    }
                    if ((android.support.v4.app.FrameMetricsAggregator.FrameMetricsApi24Impl.this.mTrackingFlags & 2) != 0) {
                        android.support.v4.app.FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl2 = android.support.v4.app.FrameMetricsAggregator.FrameMetricsApi24Impl.this;
                        frameMetricsApi24Impl2.addDurationItem(frameMetricsApi24Impl2.mMetrics[1], frameMetrics.getMetric(1));
                    }
                    if ((android.support.v4.app.FrameMetricsAggregator.FrameMetricsApi24Impl.this.mTrackingFlags & 4) != 0) {
                        android.support.v4.app.FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl3 = android.support.v4.app.FrameMetricsAggregator.FrameMetricsApi24Impl.this;
                        frameMetricsApi24Impl3.addDurationItem(frameMetricsApi24Impl3.mMetrics[2], frameMetrics.getMetric(3));
                    }
                    if ((android.support.v4.app.FrameMetricsAggregator.FrameMetricsApi24Impl.this.mTrackingFlags & 8) != 0) {
                        android.support.v4.app.FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl4 = android.support.v4.app.FrameMetricsAggregator.FrameMetricsApi24Impl.this;
                        frameMetricsApi24Impl4.addDurationItem(frameMetricsApi24Impl4.mMetrics[3], frameMetrics.getMetric(4));
                    }
                    if ((android.support.v4.app.FrameMetricsAggregator.FrameMetricsApi24Impl.this.mTrackingFlags & 16) != 0) {
                        android.support.v4.app.FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl5 = android.support.v4.app.FrameMetricsAggregator.FrameMetricsApi24Impl.this;
                        frameMetricsApi24Impl5.addDurationItem(frameMetricsApi24Impl5.mMetrics[4], frameMetrics.getMetric(5));
                    }
                    if ((android.support.v4.app.FrameMetricsAggregator.FrameMetricsApi24Impl.this.mTrackingFlags & 64) != 0) {
                        android.support.v4.app.FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl6 = android.support.v4.app.FrameMetricsAggregator.FrameMetricsApi24Impl.this;
                        frameMetricsApi24Impl6.addDurationItem(frameMetricsApi24Impl6.mMetrics[6], frameMetrics.getMetric(7));
                    }
                    if ((android.support.v4.app.FrameMetricsAggregator.FrameMetricsApi24Impl.this.mTrackingFlags & 32) != 0) {
                        android.support.v4.app.FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl7 = android.support.v4.app.FrameMetricsAggregator.FrameMetricsApi24Impl.this;
                        frameMetricsApi24Impl7.addDurationItem(frameMetricsApi24Impl7.mMetrics[5], frameMetrics.getMetric(6));
                    }
                    if ((android.support.v4.app.FrameMetricsAggregator.FrameMetricsApi24Impl.this.mTrackingFlags & 128) != 0) {
                        android.support.v4.app.FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl8 = android.support.v4.app.FrameMetricsAggregator.FrameMetricsApi24Impl.this;
                        frameMetricsApi24Impl8.addDurationItem(frameMetricsApi24Impl8.mMetrics[7], frameMetrics.getMetric(0));
                    }
                    if ((android.support.v4.app.FrameMetricsAggregator.FrameMetricsApi24Impl.this.mTrackingFlags & 256) != 0) {
                        android.support.v4.app.FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl9 = android.support.v4.app.FrameMetricsAggregator.FrameMetricsApi24Impl.this;
                        frameMetricsApi24Impl9.addDurationItem(frameMetricsApi24Impl9.mMetrics[8], frameMetrics.getMetric(2));
                    }
                }
            };
            this.mTrackingFlags = i;
        }

        @Override // android.support.v4.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public void add(android.app.Activity activity) {
            if (sHandlerThread == null) {
                sHandlerThread = new android.os.HandlerThread("FrameMetricsAggregator");
                sHandlerThread.start();
                sHandler = new android.os.Handler(sHandlerThread.getLooper());
            }
            for (int i = 0; i <= 8; i++) {
                android.util.SparseIntArray[] sparseIntArrayArr = this.mMetrics;
                if (sparseIntArrayArr[i] == null && (this.mTrackingFlags & (1 << i)) != 0) {
                    sparseIntArrayArr[i] = new android.util.SparseIntArray();
                }
            }
            activity.getWindow().addOnFrameMetricsAvailableListener(this.mListener, sHandler);
            this.mActivities.add(new java.lang.ref.WeakReference<>(activity));
        }

        void addDurationItem(android.util.SparseIntArray sparseIntArray, long j) {
            if (sparseIntArray != null) {
                int i = (int) ((500000 + j) / 1000000);
                if (j >= 0) {
                    sparseIntArray.put(i, sparseIntArray.get(i) + 1);
                }
            }
        }

        @Override // android.support.v4.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public android.util.SparseIntArray[] getMetrics() {
            return this.mMetrics;
        }

        @Override // android.support.v4.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public android.util.SparseIntArray[] remove(android.app.Activity activity) {
            for (java.lang.ref.WeakReference<android.app.Activity> weakReference : this.mActivities) {
                if (weakReference.get() == activity) {
                    this.mActivities.remove(weakReference);
                    break;
                }
            }
            activity.getWindow().removeOnFrameMetricsAvailableListener(this.mListener);
            return this.mMetrics;
        }

        @Override // android.support.v4.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public android.util.SparseIntArray[] reset() {
            android.util.SparseIntArray[] sparseIntArrayArr = this.mMetrics;
            this.mMetrics = new android.util.SparseIntArray[9];
            return sparseIntArrayArr;
        }

        @Override // android.support.v4.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public android.util.SparseIntArray[] stop() {
            for (int size = this.mActivities.size() - 1; size >= 0; size--) {
                java.lang.ref.WeakReference<android.app.Activity> weakReference = this.mActivities.get(size);
                android.app.Activity activity = weakReference.get();
                if (weakReference.get() != null) {
                    activity.getWindow().removeOnFrameMetricsAvailableListener(this.mListener);
                    this.mActivities.remove(size);
                }
            }
            return this.mMetrics;
        }
    }

    private static class FrameMetricsBaseImpl {
        private FrameMetricsBaseImpl() {
        }

        public void add(android.app.Activity activity) {
        }

        public android.util.SparseIntArray[] getMetrics() {
            return null;
        }

        public android.util.SparseIntArray[] remove(android.app.Activity activity) {
            return null;
        }

        public android.util.SparseIntArray[] reset() {
            return null;
        }

        public android.util.SparseIntArray[] stop() {
            return null;
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface MetricType {
    }

    public FrameMetricsAggregator() {
        this(1);
    }

    public FrameMetricsAggregator(int i) {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            this.mInstance = new android.support.v4.app.FrameMetricsAggregator.FrameMetricsApi24Impl(i);
        } else {
            this.mInstance = new android.support.v4.app.FrameMetricsAggregator.FrameMetricsBaseImpl();
        }
    }

    public void add(@android.support.annotation.NonNull android.app.Activity activity) {
        this.mInstance.add(activity);
    }

    @android.support.annotation.Nullable
    public android.util.SparseIntArray[] getMetrics() {
        return this.mInstance.getMetrics();
    }

    @android.support.annotation.Nullable
    public android.util.SparseIntArray[] remove(@android.support.annotation.NonNull android.app.Activity activity) {
        return this.mInstance.remove(activity);
    }

    @android.support.annotation.Nullable
    public android.util.SparseIntArray[] reset() {
        return this.mInstance.reset();
    }

    @android.support.annotation.Nullable
    public android.util.SparseIntArray[] stop() {
        return this.mInstance.stop();
    }
}
