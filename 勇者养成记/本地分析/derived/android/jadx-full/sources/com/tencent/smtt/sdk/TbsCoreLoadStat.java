package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class TbsCoreLoadStat {
    private static com.tencent.smtt.sdk.TbsCoreLoadStat d = null;
    public static volatile int mLoadErrorCode = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tencent.smtt.sdk.TbsCoreLoadStat.TbsSequenceQueue f854a = null;
    private boolean b = false;
    private final int c = 3;

    public class TbsSequenceQueue {
        private int b;
        private int c;
        private int[] d;
        private int e;
        private int f;

        public TbsSequenceQueue() {
            this.b = 10;
            this.e = 0;
            this.f = 0;
            this.c = 10;
            this.d = new int[10];
        }

        public TbsSequenceQueue(int i, int i2) {
            this.b = 10;
            this.e = 0;
            this.f = 0;
            this.c = i2;
            int[] iArr = new int[i2];
            this.d = iArr;
            iArr[0] = i;
            this.f = 1;
        }

        public void add(int i) {
            int i2 = this.f;
            if (i2 > this.c - 1) {
                throw new java.lang.IndexOutOfBoundsException("sequeue is full");
            }
            int[] iArr = this.d;
            this.f = i2 + 1;
            iArr[i2] = i;
        }

        public void clear() {
            java.util.Arrays.fill(this.d, 0);
            this.e = 0;
            this.f = 0;
        }

        public int element() {
            if (empty()) {
                throw new java.lang.IndexOutOfBoundsException("sequeue is null");
            }
            return this.d[this.e];
        }

        public boolean empty() {
            return this.f == this.e;
        }

        public int length() {
            return this.f - this.e;
        }

        public int remove() {
            if (empty()) {
                throw new java.lang.IndexOutOfBoundsException("sequeue is null");
            }
            int[] iArr = this.d;
            int i = this.e;
            int i2 = iArr[i];
            this.e = i + 1;
            iArr[i] = 0;
            return i2;
        }

        public java.lang.String toString() {
            if (empty()) {
                return "";
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder("[");
            for (int i = this.e; i < this.f; i++) {
                sb.append(java.lang.String.valueOf(this.d[i]) + ",");
            }
            int length = sb.length();
            java.lang.StringBuilder sbDelete = sb.delete(length - 1, length);
            sbDelete.append("]");
            return sbDelete.toString();
        }
    }

    private TbsCoreLoadStat() {
    }

    public static com.tencent.smtt.sdk.TbsCoreLoadStat getInstance() {
        if (d == null) {
            d = new com.tencent.smtt.sdk.TbsCoreLoadStat();
        }
        return d;
    }

    void a() {
        com.tencent.smtt.sdk.TbsCoreLoadStat.TbsSequenceQueue tbsSequenceQueue = this.f854a;
        if (tbsSequenceQueue != null) {
            tbsSequenceQueue.clear();
        }
        this.b = false;
    }

    void a(android.content.Context context, int i) {
        a(context, i, null);
        com.tencent.smtt.utils.TbsLog.e(com.tencent.smtt.sdk.TbsListener.tag_load_error, "" + i);
    }

    synchronized void a(android.content.Context context, int i, java.lang.Throwable th) {
        if (mLoadErrorCode != -1) {
            com.tencent.smtt.utils.TbsLog.w("TbsCoreLoadStat", "setLoadErrorCode :: error(" + mLoadErrorCode + ") was already reported; " + i + " is duplicated. Try to remove it!");
            return;
        }
        mLoadErrorCode = i;
        com.tencent.smtt.utils.TbsLog.addLog(com.tencent.smtt.utils.TbsLog.TBSLOG_CODE_SDK_LOAD_ERROR, "code=%d,desc=%s", java.lang.Integer.valueOf(i), java.lang.String.valueOf(th));
        if (th != null) {
            com.tencent.smtt.sdk.TbsLogReport.getInstance(context).setLoadErrorCode(i, th);
        } else {
            com.tencent.smtt.utils.TbsLog.e("TbsCoreLoadStat", "setLoadErrorCode :: error is null with errorCode: " + i + "; Check & correct it!");
        }
    }
}
