package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class TbsReaderPredownload {
    public static final int READER_SO_SUCCESS = 2;
    public static final int READER_WAIT_IN_QUEUE = 3;
    static final java.lang.String[] b = {"docx", "pptx", "xlsx", "pdf", "epub", "txt"};
    com.tencent.smtt.sdk.TbsReaderPredownload.ReaderPreDownloadCallback i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    android.os.Handler f871a = null;
    java.util.LinkedList c = new java.util.LinkedList();
    boolean d = false;
    com.tencent.smtt.sdk.ReaderWizard e = null;
    com.tencent.smtt.sdk.TbsReaderView.ReaderCallback f = null;
    java.lang.Object g = null;
    android.content.Context h = null;
    java.lang.String j = "";

    public interface ReaderPreDownloadCallback {
        public static final int NOTIFY_PLUGIN_FAILED = -1;
        public static final int NOTIFY_PLUGIN_SUCCESS = 0;

        void onEvent(java.lang.String str, int i, boolean z);
    }

    public TbsReaderPredownload(com.tencent.smtt.sdk.TbsReaderPredownload.ReaderPreDownloadCallback readerPreDownloadCallback) {
        this.i = null;
        this.i = readerPreDownloadCallback;
        for (java.lang.String str : b) {
            this.c.add(str);
        }
        a();
    }

    private void b() {
        b(3);
    }

    void a() {
        this.f871a = new android.os.Handler(android.os.Looper.getMainLooper()) { // from class: com.tencent.smtt.sdk.TbsReaderPredownload.2
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                if (message.what == 3 && !com.tencent.smtt.sdk.TbsReaderPredownload.this.c.isEmpty()) {
                    com.tencent.smtt.sdk.TbsReaderPredownload tbsReaderPredownload = com.tencent.smtt.sdk.TbsReaderPredownload.this;
                    if (tbsReaderPredownload.d) {
                        return;
                    }
                    java.lang.String str = (java.lang.String) tbsReaderPredownload.c.removeFirst();
                    com.tencent.smtt.sdk.TbsReaderPredownload tbsReaderPredownload2 = com.tencent.smtt.sdk.TbsReaderPredownload.this;
                    tbsReaderPredownload2.j = str;
                    if (tbsReaderPredownload2.a(str)) {
                        return;
                    }
                    com.tencent.smtt.sdk.TbsReaderPredownload.this.a(-1);
                }
            }
        };
    }

    void a(int i) {
        if (this.i != null) {
            this.i.onEvent(this.j, i, this.c.isEmpty());
        }
    }

    void a(int i, int i2) {
        this.f871a.sendMessageDelayed(this.f871a.obtainMessage(i), i2);
    }

    boolean a(java.lang.String str) {
        if (this.g == null || this.e == null || !com.tencent.smtt.sdk.ReaderWizard.isSupportExt(str)) {
            return false;
        }
        return this.e.checkPlugin(this.g, this.h, str, true);
    }

    void b(int i) {
        this.f871a.removeMessages(i);
    }

    boolean c(int i) {
        return this.f871a.hasMessages(i);
    }

    public boolean init(android.content.Context context) {
        if (context == null) {
            return false;
        }
        this.h = context.getApplicationContext();
        boolean zA = com.tencent.smtt.sdk.TbsReaderView.a(context.getApplicationContext());
        com.tencent.smtt.sdk.TbsReaderView.ReaderCallback readerCallback = new com.tencent.smtt.sdk.TbsReaderView.ReaderCallback() { // from class: com.tencent.smtt.sdk.TbsReaderPredownload.1
            @Override // com.tencent.smtt.sdk.TbsReaderView.ReaderCallback
            public void onCallBackAction(java.lang.Integer num, java.lang.Object obj, java.lang.Object obj2) {
                int iIntValue;
                com.tencent.smtt.sdk.TbsReaderPredownload tbsReaderPredownload;
                int i;
                if (num.intValue() == 5012 && 5014 != (iIntValue = ((java.lang.Integer) obj).intValue())) {
                    if (5013 == iIntValue || iIntValue == 0) {
                        tbsReaderPredownload = com.tencent.smtt.sdk.TbsReaderPredownload.this;
                        i = 0;
                    } else {
                        tbsReaderPredownload = com.tencent.smtt.sdk.TbsReaderPredownload.this;
                        i = -1;
                    }
                    tbsReaderPredownload.a(i);
                    com.tencent.smtt.sdk.TbsReaderPredownload tbsReaderPredownload2 = com.tencent.smtt.sdk.TbsReaderPredownload.this;
                    tbsReaderPredownload2.j = "";
                    tbsReaderPredownload2.a(3, 100);
                }
            }
        };
        this.f = readerCallback;
        try {
            if (this.e == null) {
                this.e = new com.tencent.smtt.sdk.ReaderWizard(readerCallback);
            }
            if (this.g == null) {
                this.g = this.e.getTbsReader();
            }
            return this.g != null ? this.e.initTbsReader(this.g, context.getApplicationContext()) : zA;
        } catch (java.lang.NullPointerException unused) {
            android.util.Log.e("TbsReaderPredownload", "Unexpect null object!");
            return false;
        }
    }

    public void pause() {
        this.d = true;
    }

    public void shutdown() {
        this.i = null;
        this.d = false;
        this.c.clear();
        b();
        com.tencent.smtt.sdk.ReaderWizard readerWizard = this.e;
        if (readerWizard != null) {
            readerWizard.destroy(this.g);
            this.g = null;
        }
        this.h = null;
    }

    public void start(java.lang.String str) {
        this.d = false;
        b(3);
        this.c.add(str);
        a(3, 100);
    }

    public void startAll() {
        this.d = false;
        if (!false && !c(3)) {
            a(3, 100);
        }
    }
}
