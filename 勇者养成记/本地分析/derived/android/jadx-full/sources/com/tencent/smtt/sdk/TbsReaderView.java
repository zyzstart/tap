package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class TbsReaderView extends android.widget.FrameLayout {
    public static final java.lang.String IS_BAR_ANIMATING = "is_bar_animating";
    public static final java.lang.String IS_BAR_SHOWING = "is_bar_show";
    public static final java.lang.String IS_INTO_DOWNLOADING = "into_downloading";
    public static final java.lang.String KEY_FILE_PATH = "filePath";
    public static final java.lang.String KEY_TEMP_PATH = "tempPath";
    public static final int READER_CHANNEL_DOC_ID = 10965;
    public static final int READER_CHANNEL_PDF_ID = 10834;
    public static final int READER_CHANNEL_PPT_ID = 10833;
    public static final int READER_CHANNEL_TXT_ID = 10835;
    public static final java.lang.String READER_STATISTICS_COUNT_CANCEL_LOADED_BTN = "AHNG802";
    public static final java.lang.String READER_STATISTICS_COUNT_CLICK_LOADED_BTN = "AHNG801";
    public static final java.lang.String READER_STATISTICS_COUNT_DOC_INTO_BROWSER = "AHNG829";
    public static final java.lang.String READER_STATISTICS_COUNT_DOC_INTO_DIALOG = "AHNG827";
    public static final java.lang.String READER_STATISTICS_COUNT_DOC_INTO_DOWNLOAD = "AHNG828";
    public static final java.lang.String READER_STATISTICS_COUNT_DOC_SEARCH_BTN = "AHNG826";
    public static final java.lang.String READER_STATISTICS_COUNT_PDF_FOLDER_BTN = "AHNG810";
    public static final java.lang.String READER_STATISTICS_COUNT_PDF_INTO_BROWSER = "AHNG813";
    public static final java.lang.String READER_STATISTICS_COUNT_PDF_INTO_DIALOG = "AHNG811";
    public static final java.lang.String READER_STATISTICS_COUNT_PDF_INTO_DOWNLOAD = "AHNG812";
    public static final java.lang.String READER_STATISTICS_COUNT_PPT_INTO_BROWSER = "AHNG809";
    public static final java.lang.String READER_STATISTICS_COUNT_PPT_INTO_DIALOG = "AHNG807";
    public static final java.lang.String READER_STATISTICS_COUNT_PPT_INTO_DOWNLOAD = "AHNG808";
    public static final java.lang.String READER_STATISTICS_COUNT_PPT_PLAY_BTN = "AHNG806";
    public static final java.lang.String READER_STATISTICS_COUNT_RETRY_BTN = "AHNG803";
    public static final java.lang.String READER_STATISTICS_COUNT_TXT_INTO_BROWSER = "AHNG817";
    public static final java.lang.String READER_STATISTICS_COUNT_TXT_INTO_DIALOG = "AHNG815";
    public static final java.lang.String READER_STATISTICS_COUNT_TXT_INTO_DOWNLOAD = "AHNG816";
    public static final java.lang.String READER_STATISTICS_COUNT_TXT_NOVEL_BTN = "AHNG814";
    public static final java.lang.String TAG = "TbsReaderView";
    static boolean f = false;
    public static java.lang.String gReaderPackName = "";
    public static java.lang.String gReaderPackVersion = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    android.content.Context f874a;
    com.tencent.smtt.sdk.ReaderWizard b;
    java.lang.Object c;
    com.tencent.smtt.sdk.TbsReaderView.ReaderCallback d;
    com.tencent.smtt.sdk.TbsReaderView.ReaderCallback e;

    public interface ReaderCallback {
        public static final int COPY_SELECT_TEXT = 5003;
        public static final int GET_BAR_ANIMATING = 5000;
        public static final int GET_BAR_ISSHOWING = 5024;
        public static final int HIDDEN_BAR = 5001;
        public static final int INSTALL_QB = 5011;
        public static final int NOTIFY_CANDISPLAY = 12;
        public static final int NOTIFY_ERRORCODE = 19;
        public static final int READER_OPEN_QQ_FILE_LIST = 5031;
        public static final int READER_PDF_LIST = 5008;
        public static final int READER_PLUGIN_ACTIVITY_PAUSE = 5032;
        public static final int READER_PLUGIN_CANLOAD = 5013;
        public static final int READER_PLUGIN_COMMAND_FIXSCREEN = 5015;
        public static final int READER_PLUGIN_COMMAND_PDF_LIST = 5036;
        public static final int READER_PLUGIN_COMMAND_PPT_PLAYER = 5035;
        public static final int READER_PLUGIN_COMMAND_ROTATESCREEN = 5018;
        public static final int READER_PLUGIN_COMMAND_TEXT_FIND = 5038;
        public static final int READER_PLUGIN_COMMAND_TEXT_FIND_CLEAR = 5041;
        public static final int READER_PLUGIN_COMMAND_TEXT_FIND_NEXT = 5039;
        public static final int READER_PLUGIN_COMMAND_TEXT_FIND_PREV = 5040;
        public static final int READER_PLUGIN_DOWNLOADING = 5014;
        public static final int READER_PLUGIN_RES_DOC_GUIDE = 5029;
        public static final int READER_PLUGIN_RES_FIXSCREEN_NORMAL = 5016;
        public static final int READER_PLUGIN_RES_FIXSCREEN_PRESS = 5017;
        public static final int READER_PLUGIN_RES_PDF_GUIDE = 5023;
        public static final int READER_PLUGIN_RES_PPT_GUIDE = 5021;
        public static final int READER_PLUGIN_RES_ROTATESCREEN_NORMAL = 5019;
        public static final int READER_PLUGIN_RES_ROTATESCREEN_PRESS = 5020;
        public static final int READER_PLUGIN_RES_TXT_GUIDE = 5022;
        public static final int READER_PLUGIN_SO_ERR = 5025;
        public static final int READER_PLUGIN_SO_INTO_START = 5027;
        public static final int READER_PLUGIN_SO_PROGRESS = 5028;
        public static final int READER_PLUGIN_SO_VERSION = 5030;
        public static final int READER_PLUGIN_STATUS = 5012;
        public static final int READER_PLUGIN_TEXT_FIND_RESULT = 5042;
        public static final int READER_PPT_PLAY_MODEL = 5009;
        public static final int READER_SEARCH_IN_DOCUMENT = 5026;
        public static final int READER_TOAST = 5005;
        public static final int READER_TXT_READING_MODEL = 5010;
        public static final int SEARCH_SELECT_TEXT = 5004;
        public static final int SHOW_BAR = 5002;
        public static final int SHOW_DIALOG = 5006;

        void onCallBackAction(java.lang.Integer num, java.lang.Object obj, java.lang.Object obj2);
    }

    public TbsReaderView(android.content.Context context, com.tencent.smtt.sdk.TbsReaderView.ReaderCallback readerCallback) {
        super(context.getApplicationContext());
        this.f874a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        if (!(context instanceof android.app.Activity)) {
            throw new java.lang.RuntimeException("error: unexpect context(none Activity)");
        }
        this.d = readerCallback;
        this.f874a = context;
        this.e = new com.tencent.smtt.sdk.TbsReaderView.ReaderCallback() { // from class: com.tencent.smtt.sdk.TbsReaderView.1
            @Override // com.tencent.smtt.sdk.TbsReaderView.ReaderCallback
            public void onCallBackAction(java.lang.Integer num, java.lang.Object obj, java.lang.Object obj2) {
                com.tencent.smtt.sdk.TbsReaderView tbsReaderView;
                java.lang.String str;
                android.os.Bundle bundle;
                com.tencent.smtt.sdk.TbsReaderView tbsReaderView2;
                java.lang.String str2;
                int iIntValue = num.intValue();
                android.os.Bundle bundle2 = null;
                boolean z = true;
                if (iIntValue != 5026) {
                    if (iIntValue != 5030) {
                        switch (iIntValue) {
                            case com.tencent.smtt.sdk.TbsReaderView.ReaderCallback.READER_PDF_LIST /* 5008 */:
                                if (!com.tencent.smtt.sdk.a.c.c(com.tencent.smtt.sdk.TbsReaderView.this.f874a)) {
                                    num = java.lang.Integer.valueOf(com.tencent.smtt.sdk.TbsReaderView.ReaderCallback.INSTALL_QB);
                                    java.lang.String resString = com.tencent.smtt.sdk.TbsReaderView.getResString(com.tencent.smtt.sdk.TbsReaderView.this.f874a, com.tencent.smtt.sdk.TbsReaderView.ReaderCallback.READER_PLUGIN_RES_PDF_GUIDE);
                                    bundle = new android.os.Bundle();
                                    bundle.putString("tip", resString);
                                    bundle.putString("statistics", com.tencent.smtt.sdk.TbsReaderView.READER_STATISTICS_COUNT_PDF_INTO_DOWNLOAD);
                                    bundle.putInt("channel_id", com.tencent.smtt.sdk.TbsReaderView.READER_CHANNEL_PDF_ID);
                                    tbsReaderView2 = com.tencent.smtt.sdk.TbsReaderView.this;
                                    str2 = com.tencent.smtt.sdk.TbsReaderView.READER_STATISTICS_COUNT_PDF_INTO_DIALOG;
                                    tbsReaderView2.userStatistics(str2);
                                    obj = bundle;
                                    z = false;
                                } else {
                                    java.lang.String string = "";
                                    if (obj != null) {
                                        bundle2 = (android.os.Bundle) obj;
                                        string = bundle2.getString("docpath");
                                    }
                                    com.tencent.smtt.sdk.QbSdk.startQBForDoc(com.tencent.smtt.sdk.TbsReaderView.this.f874a, string, 4, 0, "pdf", bundle2);
                                    tbsReaderView = com.tencent.smtt.sdk.TbsReaderView.this;
                                    str = com.tencent.smtt.sdk.TbsReaderView.READER_STATISTICS_COUNT_PDF_INTO_BROWSER;
                                    tbsReaderView.userStatistics(str);
                                }
                                break;
                            case com.tencent.smtt.sdk.TbsReaderView.ReaderCallback.READER_PPT_PLAY_MODEL /* 5009 */:
                                if (!com.tencent.smtt.sdk.a.c.c(com.tencent.smtt.sdk.TbsReaderView.this.f874a)) {
                                    num = java.lang.Integer.valueOf(com.tencent.smtt.sdk.TbsReaderView.ReaderCallback.INSTALL_QB);
                                    java.lang.String resString2 = com.tencent.smtt.sdk.TbsReaderView.getResString(com.tencent.smtt.sdk.TbsReaderView.this.f874a, com.tencent.smtt.sdk.TbsReaderView.ReaderCallback.READER_PLUGIN_RES_PPT_GUIDE);
                                    bundle = new android.os.Bundle();
                                    bundle.putString("tip", resString2);
                                    bundle.putString("statistics", com.tencent.smtt.sdk.TbsReaderView.READER_STATISTICS_COUNT_PPT_INTO_DOWNLOAD);
                                    bundle.putInt("channel_id", com.tencent.smtt.sdk.TbsReaderView.READER_CHANNEL_PPT_ID);
                                    tbsReaderView2 = com.tencent.smtt.sdk.TbsReaderView.this;
                                    str2 = com.tencent.smtt.sdk.TbsReaderView.READER_STATISTICS_COUNT_PPT_INTO_DIALOG;
                                    tbsReaderView2.userStatistics(str2);
                                    obj = bundle;
                                    z = false;
                                } else {
                                    java.lang.String string2 = "";
                                    if (obj != null) {
                                        bundle2 = (android.os.Bundle) obj;
                                        string2 = bundle2.getString("docpath");
                                    }
                                    com.tencent.smtt.sdk.QbSdk.startQBForDoc(com.tencent.smtt.sdk.TbsReaderView.this.f874a, string2, 4, 0, "", bundle2);
                                    tbsReaderView = com.tencent.smtt.sdk.TbsReaderView.this;
                                    str = com.tencent.smtt.sdk.TbsReaderView.READER_STATISTICS_COUNT_PPT_INTO_BROWSER;
                                    tbsReaderView.userStatistics(str);
                                }
                                break;
                            case com.tencent.smtt.sdk.TbsReaderView.ReaderCallback.READER_TXT_READING_MODEL /* 5010 */:
                                if (!com.tencent.smtt.sdk.a.c.c(com.tencent.smtt.sdk.TbsReaderView.this.f874a)) {
                                    num = java.lang.Integer.valueOf(com.tencent.smtt.sdk.TbsReaderView.ReaderCallback.INSTALL_QB);
                                    java.lang.String resString3 = com.tencent.smtt.sdk.TbsReaderView.getResString(com.tencent.smtt.sdk.TbsReaderView.this.f874a, com.tencent.smtt.sdk.TbsReaderView.ReaderCallback.READER_PLUGIN_RES_TXT_GUIDE);
                                    bundle = new android.os.Bundle();
                                    bundle.putString("tip", resString3);
                                    bundle.putString("statistics", com.tencent.smtt.sdk.TbsReaderView.READER_STATISTICS_COUNT_TXT_INTO_DOWNLOAD);
                                    bundle.putInt("channel_id", com.tencent.smtt.sdk.TbsReaderView.READER_CHANNEL_TXT_ID);
                                    tbsReaderView2 = com.tencent.smtt.sdk.TbsReaderView.this;
                                    str2 = com.tencent.smtt.sdk.TbsReaderView.READER_STATISTICS_COUNT_TXT_INTO_DIALOG;
                                    tbsReaderView2.userStatistics(str2);
                                    obj = bundle;
                                    z = false;
                                } else {
                                    java.lang.String string3 = "";
                                    if (obj != null) {
                                        bundle2 = (android.os.Bundle) obj;
                                        string3 = bundle2.getString("docpath");
                                    }
                                    com.tencent.smtt.sdk.QbSdk.startQBForDoc(com.tencent.smtt.sdk.TbsReaderView.this.f874a, string3, 4, 0, "txt", bundle2);
                                }
                                break;
                            default:
                                z = false;
                                break;
                        }
                    } else if (obj != null) {
                        android.os.Bundle bundle3 = (android.os.Bundle) obj;
                        com.tencent.smtt.sdk.TbsReaderView.gReaderPackName = bundle3.getString("name");
                        com.tencent.smtt.sdk.TbsReaderView.gReaderPackVersion = bundle3.getString(com.tencent.ysdk.shell.framework.request.HttpRequest.PARAM_VERSION);
                    }
                } else if (com.tencent.smtt.sdk.a.c.c(com.tencent.smtt.sdk.TbsReaderView.this.f874a)) {
                    java.lang.String string4 = "";
                    if (obj != null) {
                        bundle2 = (android.os.Bundle) obj;
                        string4 = bundle2.getString("docpath");
                    }
                    com.tencent.smtt.sdk.QbSdk.startQBForDoc(com.tencent.smtt.sdk.TbsReaderView.this.f874a, string4, 4, 0, "doc", bundle2);
                    tbsReaderView = com.tencent.smtt.sdk.TbsReaderView.this;
                    str = com.tencent.smtt.sdk.TbsReaderView.READER_STATISTICS_COUNT_DOC_INTO_BROWSER;
                    tbsReaderView.userStatistics(str);
                } else {
                    num = java.lang.Integer.valueOf(com.tencent.smtt.sdk.TbsReaderView.ReaderCallback.INSTALL_QB);
                    java.lang.String resString4 = com.tencent.smtt.sdk.TbsReaderView.getResString(com.tencent.smtt.sdk.TbsReaderView.this.f874a, com.tencent.smtt.sdk.TbsReaderView.ReaderCallback.READER_PLUGIN_RES_DOC_GUIDE);
                    bundle = new android.os.Bundle();
                    bundle.putString("tip", resString4);
                    bundle.putString("statistics", com.tencent.smtt.sdk.TbsReaderView.READER_STATISTICS_COUNT_DOC_INTO_DOWNLOAD);
                    bundle.putInt("channel_id", com.tencent.smtt.sdk.TbsReaderView.READER_CHANNEL_DOC_ID);
                    tbsReaderView2 = com.tencent.smtt.sdk.TbsReaderView.this;
                    str2 = com.tencent.smtt.sdk.TbsReaderView.READER_STATISTICS_COUNT_DOC_INTO_DIALOG;
                    tbsReaderView2.userStatistics(str2);
                    obj = bundle;
                    z = false;
                }
                com.tencent.smtt.sdk.TbsReaderView.ReaderCallback readerCallback2 = com.tencent.smtt.sdk.TbsReaderView.this.d;
                if (readerCallback2 == null || z) {
                    return;
                }
                readerCallback2.onCallBackAction(num, obj, obj2);
            }
        };
    }

    static boolean a(android.content.Context context) {
        if (!f) {
            com.tencent.smtt.sdk.d.a(true).a(context.getApplicationContext(), true, false);
            f = com.tencent.smtt.sdk.d.a(false).b();
        }
        return f;
    }

    public static android.graphics.drawable.Drawable getResDrawable(android.content.Context context, int i) {
        if (a(context)) {
            return com.tencent.smtt.sdk.ReaderWizard.getResDrawable(i);
        }
        return null;
    }

    public static java.lang.String getResString(android.content.Context context, int i) {
        return a(context) ? com.tencent.smtt.sdk.ReaderWizard.getResString(i) : "";
    }

    public static boolean isSupportExt(android.content.Context context, java.lang.String str) {
        return a(context) && com.tencent.smtt.sdk.ReaderWizard.isSupportCurrentPlatform(context) && com.tencent.smtt.sdk.ReaderWizard.isSupportExt(str);
    }

    boolean a() {
        try {
            if (this.b == null) {
                this.b = new com.tencent.smtt.sdk.ReaderWizard(this.e);
            }
            if (this.c == null) {
                this.c = this.b.getTbsReader();
            }
            if (this.c != null) {
                return this.b.initTbsReader(this.c, this.f874a);
            }
            return false;
        } catch (java.lang.NullPointerException unused) {
            android.util.Log.e(TAG, "Unexpect null object!");
            return false;
        }
    }

    public void doCommand(java.lang.Integer num, java.lang.Object obj, java.lang.Object obj2) {
        java.lang.Object obj3;
        com.tencent.smtt.sdk.ReaderWizard readerWizard = this.b;
        if (readerWizard == null || (obj3 = this.c) == null) {
            return;
        }
        readerWizard.doCommand(obj3, num, obj, obj2);
    }

    public boolean downloadPlugin(java.lang.String str) {
        java.lang.Object obj = this.c;
        if (obj != null) {
            return this.b.checkPlugin(obj, this.f874a, str, true);
        }
        android.util.Log.e(TAG, "downloadPlugin failed!");
        return false;
    }

    public void onSizeChanged(int i, int i2) {
        java.lang.Object obj;
        com.tencent.smtt.sdk.ReaderWizard readerWizard = this.b;
        if (readerWizard == null || (obj = this.c) == null) {
            return;
        }
        readerWizard.onSizeChanged(obj, i, i2);
    }

    public void onStop() {
        com.tencent.smtt.sdk.ReaderWizard readerWizard = this.b;
        if (readerWizard != null) {
            readerWizard.destroy(this.c);
            this.c = null;
        }
        this.f874a = null;
        f = false;
    }

    public void openFile(android.os.Bundle bundle) {
        if (this.c == null || bundle == null) {
            android.util.Log.e(TAG, "init failed!");
            return;
        }
        bundle.putBoolean("browser6.0", com.tencent.smtt.sdk.a.c.c(this.f874a) | (!com.tencent.smtt.sdk.a.c.b(this.f874a)));
        bundle.putBoolean("browser6.1", com.tencent.smtt.sdk.a.c.a(this.f874a, 6101625L, 610000L) | (!com.tencent.smtt.sdk.a.c.b(this.f874a)));
        if (this.b.openFile(this.c, this.f874a, bundle, this)) {
            return;
        }
        android.util.Log.e(TAG, "OpenFile failed!");
    }

    public boolean preOpen(java.lang.String str, boolean z) {
        if (!isSupportExt(this.f874a, str)) {
            android.util.Log.e(TAG, "not supported by:" + str);
            return false;
        }
        boolean zA = a(this.f874a);
        if (!zA) {
            return zA;
        }
        boolean zA2 = a();
        if (z && zA2) {
            return this.b.checkPlugin(this.c, this.f874a, str, com.tencent.smtt.utils.Apn.getApnType(this.f874a) == 3);
        }
        return zA2;
    }

    public void userStatistics(java.lang.String str) {
        com.tencent.smtt.sdk.ReaderWizard readerWizard = this.b;
        if (readerWizard != null) {
            readerWizard.userStatistics(this.c, str);
        }
    }
}
