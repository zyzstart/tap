package oicq.wlogin_sdk.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class WtloginHelper extends oicq.wlogin_sdk.request.WtloginListener {
    static final java.lang.Object __sync_top = new java.lang.Object();
    static int __top;
    private boolean isForLocal;
    private long mAysncSeq;
    private android.content.Context mContext;
    private oicq.wlogin_sdk.request.t mG;
    private android.os.Handler mHelperHandler;
    private oicq.wlogin_sdk.request.WtloginListener mListener;
    private int mMainSigMap;
    private int mMiscBitmap;
    private long mOpenAppid;
    private oicq.wlogin_sdk.a.h mRegStatus;
    private int mSubSigMap;

    private static class A1SRC {
        public static final int A1SRC_PASSWORD = 1;
        public static final int A1SRC_PTSIG = 4;
        public static final int A1SRC_QUICKLOGIN = 2;
        public static final int A1SRC_SMS = 3;

        private A1SRC() {
        }
    }

    public class HelperThread extends java.lang.Thread {
        boolean isSelfLooper;
        byte[] mAppName2;
        byte[] mAppSign2;
        byte[] mAppVer2;
        long mAppid1;
        long mAppid2;
        long mDwAppid;
        long mDwDstAppPri;
        long mDwDstAppid;
        long[] mDwDstSubAppidList;
        int mDwMainSigMap;
        long[] mDwSubAppidList;
        long mDwSubDstAppid;
        int mEncrypt;
        oicq.wlogin_sdk.request.WFastLoginInfo mFastLoginInfo;
        android.os.Handler mHandler;
        oicq.wlogin_sdk.request.WtloginHelper mHelper;
        boolean mIsSmslogin;
        java.lang.String mMsgCode;
        byte[] mPictureData;
        oicq.wlogin_sdk.request.WtTicketPromise mPromise;
        boolean mPwdMd5;
        int mReportErrType;
        oicq.wlogin_sdk.request.TransReqContext mReqContext;
        int mReqType;
        byte[][] mReserve;
        long mRole;
        byte[][] mST;
        byte[] mST1;
        byte[] mST1Key;
        long mSmsAppid;
        long mSsoVer2;
        long mSubAppid1;
        long mSubAppid2;
        long mUIN;
        java.lang.String mUserAccount;
        byte[] mUserInput;
        java.lang.String mUserPasswd;
        oicq.wlogin_sdk.request.WUserSigInfo mUserSigInfo;
        java.lang.String ptSig;
        oicq.wlogin_sdk.request.WtloginHelper.QuickLoginParam quickLoginParam;

        HelperThread(oicq.wlogin_sdk.request.WtloginHelper wtloginHelper, android.os.Handler handler) {
            this.isSelfLooper = false;
            this.mUserSigInfo = null;
            this.mIsSmslogin = false;
            this.mHelper = wtloginHelper;
            this.mHandler = handler;
        }

        HelperThread(oicq.wlogin_sdk.request.WtloginHelper wtloginHelper, android.os.Handler handler, int i, java.lang.String str, long j, long j2, oicq.wlogin_sdk.request.TransReqContext transReqContext, java.lang.String str2) {
            this.isSelfLooper = false;
            this.mUserSigInfo = null;
            this.mIsSmslogin = false;
            this.mHelper = wtloginHelper;
            this.mHandler = handler;
            this.mEncrypt = i;
            this.mUserAccount = str;
            this.mDwAppid = j;
            this.mRole = j2;
            this.mReqContext = transReqContext;
            setName(str2);
        }

        HelperThread(oicq.wlogin_sdk.request.WtloginHelper wtloginHelper, android.os.Handler handler, int i, java.lang.String str, long j, long j2, oicq.wlogin_sdk.request.TransReqContext transReqContext, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo, java.lang.String str2) {
            this.isSelfLooper = false;
            this.mUserSigInfo = null;
            this.mIsSmslogin = false;
            this.mHelper = wtloginHelper;
            this.mHandler = handler;
            this.mEncrypt = i;
            this.mUserAccount = str;
            this.mDwAppid = j;
            this.mRole = j2;
            this.mReqContext = transReqContext;
            this.mUserSigInfo = wUserSigInfo;
            setName(str2);
        }

        HelperThread(oicq.wlogin_sdk.request.WtloginHelper wtloginHelper, android.os.Handler handler, long j, long j2, java.lang.String str, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo, java.lang.String str2) {
            this.isSelfLooper = false;
            this.mUserSigInfo = null;
            this.mIsSmslogin = false;
            this.mHelper = wtloginHelper;
            this.mHandler = handler;
            this.mUserAccount = str;
            this.mAppid1 = j;
            this.mSubAppid1 = j2;
            this.mUserSigInfo = wUserSigInfo;
            setName(str2);
        }

        HelperThread(oicq.wlogin_sdk.request.WtloginHelper wtloginHelper, android.os.Handler handler, java.lang.String str, long j, int i, long j2, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo, java.lang.String str2) {
            this.isSelfLooper = false;
            this.mUserSigInfo = null;
            this.mIsSmslogin = false;
            this.mHelper = wtloginHelper;
            this.mHandler = handler;
            this.mUserAccount = str;
            this.mDwAppid = j;
            this.mDwMainSigMap = i;
            this.mDwSubDstAppid = j2;
            this.mUserSigInfo = wUserSigInfo;
            setName(str2);
        }

        HelperThread(oicq.wlogin_sdk.request.WtloginHelper wtloginHelper, android.os.Handler handler, java.lang.String str, long j, int i, long j2, long[] jArr, boolean z, java.lang.String str2, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo, byte[][] bArr, boolean z2, java.lang.String str3) {
            this.isSelfLooper = false;
            this.mUserSigInfo = null;
            this.mIsSmslogin = false;
            this.mHelper = wtloginHelper;
            this.mHandler = handler;
            this.mUserAccount = str;
            this.mDwAppid = j;
            this.mDwMainSigMap = i;
            this.mDwSubDstAppid = j2;
            this.mDwSubAppidList = jArr;
            this.mPwdMd5 = z;
            this.mUserPasswd = str2;
            this.mUserSigInfo = wUserSigInfo;
            this.mST = bArr;
            this.mIsSmslogin = z2;
            setName(str3);
        }

        HelperThread(oicq.wlogin_sdk.request.WtloginHelper wtloginHelper, android.os.Handler handler, java.lang.String str, long j, long j2, int i, byte[] bArr, long j3, long j4, long j5, byte[] bArr2, byte[] bArr3, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo, oicq.wlogin_sdk.request.WFastLoginInfo wFastLoginInfo, java.lang.String str2) {
            this.isSelfLooper = false;
            this.mUserSigInfo = null;
            this.mIsSmslogin = false;
            this.mHelper = wtloginHelper;
            this.mHandler = handler;
            this.mUserAccount = str;
            this.mAppid1 = j;
            this.mSubAppid1 = j2;
            this.mDwMainSigMap = i;
            this.mAppName2 = bArr;
            this.mSsoVer2 = j4;
            this.mAppid2 = j4;
            this.mSubAppid2 = j5;
            this.mAppVer2 = bArr2;
            this.mAppSign2 = bArr3;
            this.mUserSigInfo = wUserSigInfo;
            this.mFastLoginInfo = wFastLoginInfo;
            setName(str2);
        }

        HelperThread(oicq.wlogin_sdk.request.WtloginHelper wtloginHelper, android.os.Handler handler, java.lang.String str, long j, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo, java.lang.String str2) {
            this.isSelfLooper = false;
            this.mUserSigInfo = null;
            this.mIsSmslogin = false;
            this.mHelper = wtloginHelper;
            this.mHandler = handler;
            this.mUserAccount = str;
            this.mSmsAppid = j;
            this.mUserSigInfo = wUserSigInfo;
            setName(str2);
        }

        HelperThread(oicq.wlogin_sdk.request.WtloginHelper wtloginHelper, android.os.Handler handler, java.lang.String str, java.lang.String str2, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo, java.lang.String str3) {
            this.isSelfLooper = false;
            this.mUserSigInfo = null;
            this.mIsSmslogin = false;
            this.mHelper = wtloginHelper;
            this.mHandler = handler;
            this.mUserAccount = str;
            this.mMsgCode = str2;
            this.mUserSigInfo = wUserSigInfo;
            setName(str3);
        }

        HelperThread(oicq.wlogin_sdk.request.WtloginHelper wtloginHelper, android.os.Handler handler, java.lang.String str, java.lang.String str2, oicq.wlogin_sdk.request.WtloginHelper.QuickLoginParam quickLoginParam, java.lang.String str3) {
            this.isSelfLooper = false;
            this.mUserSigInfo = null;
            this.mIsSmslogin = false;
            this.mHelper = wtloginHelper;
            this.mHandler = handler;
            this.mUserAccount = str;
            this.ptSig = str2;
            this.quickLoginParam = quickLoginParam;
            this.mUserSigInfo = quickLoginParam.userSigInfo;
            setName(str3);
        }

        HelperThread(oicq.wlogin_sdk.request.WtloginHelper wtloginHelper, android.os.Handler handler, java.lang.String str, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo, java.lang.String str2) {
            this.isSelfLooper = false;
            this.mUserSigInfo = null;
            this.mIsSmslogin = false;
            this.mHelper = wtloginHelper;
            this.mHandler = handler;
            this.mUserAccount = str;
            this.mUserSigInfo = wUserSigInfo;
            setName(str2);
        }

        HelperThread(oicq.wlogin_sdk.request.WtloginHelper wtloginHelper, android.os.Handler handler, java.lang.String str, oicq.wlogin_sdk.request.WtloginHelper.QuickLoginParam quickLoginParam, java.lang.String str2) {
            this.isSelfLooper = false;
            this.mUserSigInfo = null;
            this.mIsSmslogin = false;
            this.mHelper = wtloginHelper;
            this.mHandler = handler;
            this.mUserAccount = str;
            this.quickLoginParam = quickLoginParam;
            this.mUserSigInfo = quickLoginParam.userSigInfo;
            setName(str2);
        }

        HelperThread(oicq.wlogin_sdk.request.WtloginHelper wtloginHelper, android.os.Handler handler, java.lang.String str, byte[] bArr, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo, byte[][] bArr2, java.lang.String str2) {
            this.isSelfLooper = false;
            this.mUserSigInfo = null;
            this.mIsSmslogin = false;
            this.mHelper = wtloginHelper;
            this.mHandler = handler;
            this.mUserAccount = str;
            this.mUserInput = bArr;
            this.mUserSigInfo = wUserSigInfo;
            this.mST = bArr2;
            setName(str2);
        }

        HelperThread(oicq.wlogin_sdk.request.WtloginHelper wtloginHelper, android.os.Handler handler, oicq.wlogin_sdk.request.WtTicketPromise wtTicketPromise, java.lang.String str, long j, long j2, long j3, int i, long j4, long[] jArr, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo, byte[][] bArr, byte[][] bArr2, java.lang.String str2) {
            this.isSelfLooper = false;
            this.mUserSigInfo = null;
            this.mIsSmslogin = false;
            this.mHelper = wtloginHelper;
            this.mHandler = handler;
            this.mPromise = wtTicketPromise;
            this.mUserAccount = str;
            this.mDwAppid = j;
            this.mDwDstAppid = j2;
            this.mDwDstAppPri = j3;
            this.mDwMainSigMap = i;
            this.mDwSubDstAppid = j4;
            this.mDwDstSubAppidList = jArr;
            this.mUserSigInfo = wUserSigInfo;
            this.mST = bArr;
            this.mReserve = bArr2;
            setName(str2);
        }

        HelperThread(oicq.wlogin_sdk.request.WtloginHelper wtloginHelper, android.os.Handler handler, byte[] bArr, byte[] bArr2, long j, long j2, int i, java.lang.String str) {
            this.isSelfLooper = false;
            this.mUserSigInfo = null;
            this.mIsSmslogin = false;
            this.mHelper = wtloginHelper;
            this.mHandler = handler;
            this.mST1 = bArr;
            this.mST1Key = bArr2;
            this.mUIN = j;
            this.mDwAppid = j2;
            this.mReportErrType = i;
            setName(str);
        }

        HelperThread(oicq.wlogin_sdk.request.WtloginHelper wtloginHelper, android.os.Handler handler, byte[] bArr, byte[] bArr2, long j, long j2, java.lang.String str) {
            this.isSelfLooper = false;
            this.mUserSigInfo = null;
            this.mIsSmslogin = false;
            this.mHelper = wtloginHelper;
            this.mHandler = handler;
            this.mST1 = bArr;
            this.mST1Key = bArr2;
            this.mUIN = j;
            this.mDwAppid = j2;
            setName(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void quitSelfLooper() {
            try {
                if (this.isSelfLooper) {
                    android.os.Looper looperMyLooper = android.os.Looper.myLooper();
                    if (looperMyLooper != null) {
                        looperMyLooper.quit();
                    }
                    this.mHandler = null;
                }
            } catch (java.lang.Exception e) {
                oicq.wlogin_sdk.tools.util.printException(e, "");
            }
        }

        public void RunReq(int i) {
            this.mReqType = i;
            if (i == 7) {
                start();
                return;
            }
            synchronized (oicq.wlogin_sdk.request.WtloginHelper.__sync_top) {
                java.util.Timer timer = new java.util.Timer();
                java.util.TimerTask timerTask = new java.util.TimerTask() { // from class: oicq.wlogin_sdk.request.WtloginHelper.HelperThread.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.start();
                    }
                };
                int i2 = oicq.wlogin_sdk.request.WtloginHelper.__top;
                oicq.wlogin_sdk.request.WtloginHelper.__top = i2 + 1;
                timer.schedule(timerTask, i2 * 500);
                oicq.wlogin_sdk.tools.util.LOGI("push queue " + oicq.wlogin_sdk.request.WtloginHelper.__top, "");
            }
        }

        /* JADX WARN: Code duplicated, block: B:122:0x030c A[ORIG_RETURN, RETURN] */
        /* JADX WARN: Code duplicated, block: B:144:0x0291 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:82:0x0286  */
        /* JADX WARN: Code duplicated, block: B:85:0x028e  */
        /* JADX WARN: Code duplicated, block: B:89:0x0295 A[Catch: all -> 0x02b5, TryCatch #2 {, blocks: (B:87:0x0291, B:89:0x0295, B:90:0x029b, B:91:0x02b3), top: B:144:0x0291 }] */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            final int i;
            android.os.Handler handler;
            java.lang.Runnable runnable;
            final int i2;
            android.os.Handler handler2;
            java.lang.Runnable runnable2;
            if (this.mHelper.mListener == null && this.mPromise == null) {
                return;
            }
            final int i3 = this.mHelper.mG.s;
            boolean z = this.mHandler == null;
            this.isSelfLooper = z;
            if (z) {
                android.os.Looper.prepare();
                this.mHandler = oicq.wlogin_sdk.request.WtloginHelper.this.newHelperHandler();
            }
            try {
                try {
                    try {
                        if (this.mHandler == null) {
                            throw new java.lang.Exception("Handler should not be null!");
                        }
                        if (this.mReqType == 0) {
                            final int iGetStWithPasswd = this.mHelper.GetStWithPasswd(this.mUserAccount, this.mDwAppid, this.mDwMainSigMap, this.mDwSubDstAppid, this.mDwSubAppidList, this.mPwdMd5, this.mUserPasswd, this.mUserSigInfo, this.mST, this.mIsSmslogin, 1);
                            handler2 = this.mHandler;
                            runnable2 = new java.lang.Runnable() { // from class: oicq.wlogin_sdk.request.WtloginHelper.HelperThread.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.quitSelfLooper();
                                    if (i3 != 0) {
                                        return;
                                    }
                                    oicq.wlogin_sdk.request.async_context async_contextVarB = oicq.wlogin_sdk.request.t.b(oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mUserSigInfo._seqence);
                                    oicq.wlogin_sdk.tools.ErrMsg errMsg = async_contextVarB._last_err_msg;
                                    if (oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mHelper.mListener == null) {
                                        oicq.wlogin_sdk.tools.util.LOGW("login helper listener is null", oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mUserAccount);
                                        return;
                                    }
                                    if (iGetStWithPasswd == 0 && async_contextVarB.tlv528 != null) {
                                        oicq.wlogin_sdk.tools.util.LOGI("context from seq " + oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mUserSigInfo._seqence + " tlv528 length " + async_contextVarB.tlv528.get_data_len(), oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mUserAccount);
                                        oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mUserSigInfo.loginResultTLVMap.put(new java.lang.Integer(1320), async_contextVarB.tlv528);
                                    }
                                    oicq.wlogin_sdk.request.WtloginHelper.HelperThread helperThread = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this;
                                    if (helperThread.mDwSubAppidList == null) {
                                        if (helperThread.mIsSmslogin) {
                                            oicq.wlogin_sdk.request.WtloginListener wtloginListener = helperThread.mHelper.mListener;
                                            oicq.wlogin_sdk.request.WtloginHelper.HelperThread helperThread2 = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this;
                                            wtloginListener.OnGetStViaSMSVerifyLogin(helperThread2.mUserAccount, helperThread2.mDwAppid, helperThread2.mDwMainSigMap, helperThread2.mDwSubDstAppid, helperThread2.mUserSigInfo, iGetStWithPasswd, errMsg);
                                            return;
                                        } else {
                                            oicq.wlogin_sdk.request.WtloginListener wtloginListener2 = helperThread.mHelper.mListener;
                                            oicq.wlogin_sdk.request.WtloginHelper.HelperThread helperThread3 = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this;
                                            wtloginListener2.OnGetStWithPasswd(helperThread3.mUserAccount, helperThread3.mDwAppid, helperThread3.mDwMainSigMap, helperThread3.mDwSubDstAppid, helperThread3.mUserPasswd, helperThread3.mUserSigInfo, iGetStWithPasswd, errMsg);
                                            return;
                                        }
                                    }
                                    if (helperThread.mIsSmslogin) {
                                        oicq.wlogin_sdk.request.WtloginListener wtloginListener3 = helperThread.mHelper.mListener;
                                        oicq.wlogin_sdk.request.WtloginHelper.HelperThread helperThread4 = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this;
                                        wtloginListener3.OnGetStViaSMSVerifyLogin(helperThread4.mUserAccount, helperThread4.mDwAppid, helperThread4.mDwMainSigMap, helperThread4.mDwSubDstAppid, helperThread4.mDwSubAppidList, helperThread4.mUserSigInfo, helperThread4.mST, iGetStWithPasswd, errMsg);
                                    } else {
                                        oicq.wlogin_sdk.request.WtloginListener wtloginListener4 = helperThread.mHelper.mListener;
                                        oicq.wlogin_sdk.request.WtloginHelper.HelperThread helperThread5 = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this;
                                        wtloginListener4.OnGetStWithPasswd(helperThread5.mUserAccount, helperThread5.mDwAppid, helperThread5.mDwMainSigMap, helperThread5.mDwSubDstAppid, helperThread5.mDwSubAppidList, helperThread5.mUserPasswd, helperThread5.mUserSigInfo, helperThread5.mST, iGetStWithPasswd, errMsg);
                                    }
                                }
                            };
                        } else if (this.mReqType == 1) {
                            final int iRefreshPictureData = this.mHelper.RefreshPictureData(this.mUserAccount, this.mUserSigInfo, 1);
                            handler2 = this.mHandler;
                            runnable2 = new java.lang.Runnable() { // from class: oicq.wlogin_sdk.request.WtloginHelper.HelperThread.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.quitSelfLooper();
                                    if (i3 != 0) {
                                        return;
                                    }
                                    if (oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mHelper.mListener == null) {
                                        oicq.wlogin_sdk.tools.util.LOGW("login helper listener is null", oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mUserAccount);
                                        return;
                                    }
                                    oicq.wlogin_sdk.request.async_context async_contextVarB = oicq.wlogin_sdk.request.t.b(oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mUserSigInfo._seqence);
                                    oicq.wlogin_sdk.tools.ErrMsg errMsg = async_contextVarB._last_err_msg;
                                    oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mPictureData = async_contextVarB._t105.get_pic();
                                    oicq.wlogin_sdk.request.WtloginListener wtloginListener = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mHelper.mListener;
                                    oicq.wlogin_sdk.request.WtloginHelper.HelperThread helperThread = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this;
                                    wtloginListener.OnRefreshPictureData(helperThread.mUserAccount, helperThread.mUserSigInfo, helperThread.mPictureData, iRefreshPictureData, errMsg);
                                }
                            };
                        } else if (this.mReqType == 2) {
                            final int iCheckPictureAndGetSt = this.mHelper.CheckPictureAndGetSt(this.mUserAccount, this.mUserInput, this.mUserSigInfo, this.mST, 1);
                            handler2 = this.mHandler;
                            runnable2 = new java.lang.Runnable() { // from class: oicq.wlogin_sdk.request.WtloginHelper.HelperThread.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.quitSelfLooper();
                                    if (i3 != 0) {
                                        return;
                                    }
                                    oicq.wlogin_sdk.tools.ErrMsg errMsg = oicq.wlogin_sdk.request.t.b(oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mUserSigInfo._seqence)._last_err_msg;
                                    if (oicq.wlogin_sdk.request.o.I) {
                                        oicq.wlogin_sdk.request.WtloginHelper.HelperThread helperThread = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this;
                                        if (helperThread.mST == null) {
                                            oicq.wlogin_sdk.request.WtloginListener wtloginListener = helperThread.mHelper.mListener;
                                            oicq.wlogin_sdk.request.WtloginHelper.HelperThread helperThread2 = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this;
                                            wtloginListener.OnCheckWebsigAndGetSt(helperThread2.mUserAccount, helperThread2.mUserInput, helperThread2.mUserSigInfo, iCheckPictureAndGetSt, errMsg);
                                            return;
                                        } else {
                                            oicq.wlogin_sdk.request.WtloginListener wtloginListener2 = helperThread.mHelper.mListener;
                                            oicq.wlogin_sdk.request.WtloginHelper.HelperThread helperThread3 = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this;
                                            wtloginListener2.OnCheckWebsigAndGetSt(helperThread3.mUserAccount, helperThread3.mUserInput, helperThread3.mUserSigInfo, helperThread3.mST, iCheckPictureAndGetSt, errMsg);
                                            return;
                                        }
                                    }
                                    oicq.wlogin_sdk.request.WtloginHelper.HelperThread helperThread4 = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this;
                                    if (helperThread4.mST == null) {
                                        oicq.wlogin_sdk.request.WtloginListener wtloginListener3 = helperThread4.mHelper.mListener;
                                        oicq.wlogin_sdk.request.WtloginHelper.HelperThread helperThread5 = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this;
                                        wtloginListener3.OnCheckPictureAndGetSt(helperThread5.mUserAccount, helperThread5.mUserInput, helperThread5.mUserSigInfo, iCheckPictureAndGetSt, errMsg);
                                    } else {
                                        oicq.wlogin_sdk.request.WtloginListener wtloginListener4 = helperThread4.mHelper.mListener;
                                        oicq.wlogin_sdk.request.WtloginHelper.HelperThread helperThread6 = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this;
                                        wtloginListener4.OnCheckPictureAndGetSt(helperThread6.mUserAccount, helperThread6.mUserInput, helperThread6.mUserSigInfo, helperThread6.mST, iCheckPictureAndGetSt, errMsg);
                                    }
                                }
                            };
                        } else {
                            if (this.mReqType != 3) {
                                if (this.mReqType == 4) {
                                    final int iCheckSMSAndGetSt = this.mHelper.CheckSMSAndGetSt(this.mUserAccount, this.mUserInput, this.mUserSigInfo, this.mST, 1);
                                    handler2 = this.mHandler;
                                    runnable2 = new java.lang.Runnable() { // from class: oicq.wlogin_sdk.request.WtloginHelper.HelperThread.6
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.quitSelfLooper();
                                            if (i3 != 0) {
                                                return;
                                            }
                                            oicq.wlogin_sdk.tools.ErrMsg errMsg = oicq.wlogin_sdk.request.t.b(oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mUserSigInfo._seqence)._last_err_msg;
                                            oicq.wlogin_sdk.request.WtloginHelper.HelperThread helperThread = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this;
                                            if (helperThread.mST == null) {
                                                oicq.wlogin_sdk.request.WtloginListener wtloginListener = helperThread.mHelper.mListener;
                                                oicq.wlogin_sdk.request.WtloginHelper.HelperThread helperThread2 = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this;
                                                wtloginListener.OnCheckSMSAndGetSt(helperThread2.mUserAccount, helperThread2.mUserInput, helperThread2.mUserSigInfo, iCheckSMSAndGetSt, errMsg);
                                            } else {
                                                oicq.wlogin_sdk.request.WtloginListener wtloginListener2 = helperThread.mHelper.mListener;
                                                oicq.wlogin_sdk.request.WtloginHelper.HelperThread helperThread3 = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this;
                                                wtloginListener2.OnCheckSMSAndGetSt(helperThread3.mUserAccount, helperThread3.mUserInput, helperThread3.mUserSigInfo, helperThread3.mST, iCheckSMSAndGetSt, errMsg);
                                            }
                                        }
                                    };
                                } else {
                                    try {
                                        if (this.mReqType == 5) {
                                            i2 = i3;
                                            final int iGetStWithoutPasswd = this.mHelper.GetStWithoutPasswd(this.mUserAccount, this.mDwAppid, this.mDwDstAppid, this.mDwDstAppPri, this.mDwMainSigMap, this.mDwSubDstAppid, this.mDwDstSubAppidList, this.mUserSigInfo, this.mST, this.mReserve, 1, this.mPromise);
                                            handler = this.mHandler;
                                            runnable = new java.lang.Runnable() { // from class: oicq.wlogin_sdk.request.WtloginHelper.HelperThread.7
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.quitSelfLooper();
                                                    if (i2 != 0) {
                                                        return;
                                                    }
                                                    oicq.wlogin_sdk.tools.ErrMsg errMsg = oicq.wlogin_sdk.request.t.b(oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mUserSigInfo._seqence)._last_err_msg;
                                                    oicq.wlogin_sdk.request.t.c(oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mUserSigInfo._seqence);
                                                    oicq.wlogin_sdk.request.WtloginHelper.HelperThread helperThread = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this;
                                                    if (helperThread.mDwDstAppid == oicq.wlogin_sdk.request.WtloginHelper.this.mOpenAppid) {
                                                        oicq.wlogin_sdk.request.WtloginHelper.HelperThread helperThread2 = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this;
                                                        helperThread2.mDwDstAppid = helperThread2.mDwSubDstAppid;
                                                        helperThread2.mDwSubDstAppid = 0L;
                                                    }
                                                    oicq.wlogin_sdk.request.WtloginHelper.HelperThread helperThread3 = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this;
                                                    if (helperThread3.mPromise != null) {
                                                        errMsg.setType(iGetStWithoutPasswd);
                                                        int i4 = iGetStWithoutPasswd;
                                                        if (i4 == 0) {
                                                            oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mPromise.Done(null);
                                                            return;
                                                        } else if (i4 == -1000) {
                                                            oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mPromise.Timeout(errMsg);
                                                            return;
                                                        } else {
                                                            oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mPromise.Failed(errMsg);
                                                            return;
                                                        }
                                                    }
                                                    if (helperThread3.mHelper.mListener == null) {
                                                        return;
                                                    }
                                                    oicq.wlogin_sdk.request.WtloginHelper.HelperThread helperThread4 = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this;
                                                    if (helperThread4.mDwDstSubAppidList != null || oicq.wlogin_sdk.request.WtloginHelper.this.mG.e()) {
                                                        oicq.wlogin_sdk.request.WtloginListener wtloginListener = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mHelper.mListener;
                                                        oicq.wlogin_sdk.request.WtloginHelper.HelperThread helperThread5 = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this;
                                                        wtloginListener.OnGetStWithoutPasswd(helperThread5.mUserAccount, helperThread5.mDwAppid, helperThread5.mDwDstAppid, helperThread5.mDwMainSigMap, helperThread5.mDwSubDstAppid, helperThread5.mDwDstSubAppidList, helperThread5.mUserSigInfo, helperThread5.mST, iGetStWithoutPasswd, errMsg);
                                                    } else {
                                                        oicq.wlogin_sdk.request.WtloginListener wtloginListener2 = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mHelper.mListener;
                                                        oicq.wlogin_sdk.request.WtloginHelper.HelperThread helperThread6 = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this;
                                                        wtloginListener2.OnGetStWithoutPasswd(helperThread6.mUserAccount, helperThread6.mDwAppid, helperThread6.mDwDstAppid, helperThread6.mDwMainSigMap, helperThread6.mDwSubDstAppid, helperThread6.mUserSigInfo, iGetStWithoutPasswd, errMsg);
                                                    }
                                                }
                                            };
                                        } else if (this.mReqType == 6) {
                                            i2 = i3;
                                            final int iGetA1WithA1 = this.mHelper.GetA1WithA1(this.mUserAccount, this.mAppid1, this.mSubAppid1, this.mDwMainSigMap, this.mAppName2, this.mSsoVer2, this.mAppid2, this.mSubAppid2, this.mAppVer2, this.mAppSign2, this.mUserSigInfo, this.mFastLoginInfo, 1);
                                            handler = this.mHandler;
                                            runnable = new java.lang.Runnable() { // from class: oicq.wlogin_sdk.request.WtloginHelper.HelperThread.8
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.quitSelfLooper();
                                                    if (i2 != 0) {
                                                        return;
                                                    }
                                                    oicq.wlogin_sdk.tools.ErrMsg errMsg = oicq.wlogin_sdk.request.t.b(oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mUserSigInfo._seqence)._last_err_msg;
                                                    oicq.wlogin_sdk.request.t.c(oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mUserSigInfo._seqence);
                                                    oicq.wlogin_sdk.request.WtloginListener wtloginListener = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mHelper.mListener;
                                                    oicq.wlogin_sdk.request.WtloginHelper.HelperThread helperThread = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this;
                                                    wtloginListener.onGetA1WithA1(helperThread.mUserAccount, helperThread.mAppid1, helperThread.mDwMainSigMap, helperThread.mSubAppid1, helperThread.mAppName2, helperThread.mSsoVer2, helperThread.mAppid2, helperThread.mSubAppid2, helperThread.mAppVer2, helperThread.mAppSign2, helperThread.mUserSigInfo, helperThread.mFastLoginInfo, iGetA1WithA1, errMsg);
                                                }
                                            };
                                        } else if (this.mReqType == 7) {
                                            this.mHelper.RequestReport(1, this.mST1, this.mST1Key, this.mUIN, this.mDwAppid);
                                        } else {
                                            if (this.mReqType == 9) {
                                                final int iRequestTransport = this.mHelper.RequestTransport(1, this.mEncrypt, this.mUserAccount, this.mDwAppid, this.mRole, this.mReqContext, this.mUserSigInfo);
                                                handler = this.mHandler;
                                                runnable = new java.lang.Runnable() { // from class: oicq.wlogin_sdk.request.WtloginHelper.HelperThread.9
                                                    @Override // java.lang.Runnable
                                                    public void run() {
                                                        oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.quitSelfLooper();
                                                        if (i3 != 0) {
                                                            return;
                                                        }
                                                        if (oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mReqContext.is_register_req()) {
                                                            oicq.wlogin_sdk.request.WtloginHelper.HelperThread helperThread = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this;
                                                            helperThread.mHelper.OnRequestRegister(helperThread.mUserAccount, helperThread.mDwAppid, helperThread.mRole, helperThread.mReqContext, helperThread.mUserSigInfo, iRequestTransport);
                                                            return;
                                                        }
                                                        if (oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mReqContext.is_code2d_func_req()) {
                                                            oicq.wlogin_sdk.request.WtloginHelper.HelperThread helperThread2 = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this;
                                                            helperThread2.mHelper.OnRequestCode2d(helperThread2.mUserAccount, helperThread2.mDwAppid, helperThread2.mRole, helperThread2.mReqContext, helperThread2.mUserSigInfo, iRequestTransport);
                                                        } else if (oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mReqContext.is_devlock_req()) {
                                                            oicq.wlogin_sdk.request.WtloginHelper.HelperThread helperThread3 = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this;
                                                            helperThread3.mHelper.OnDeviceLockRequest(helperThread3.mUserAccount, helperThread3.mDwAppid, helperThread3.mRole, helperThread3.mReqContext, helperThread3.mUserSigInfo, iRequestTransport);
                                                        } else {
                                                            oicq.wlogin_sdk.request.WtloginListener wtloginListener = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mHelper.mListener;
                                                            oicq.wlogin_sdk.request.WtloginHelper.HelperThread helperThread4 = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this;
                                                            wtloginListener.OnRequestTransport(helperThread4.mUserAccount, helperThread4.mDwAppid, helperThread4.mRole, helperThread4.mReqContext, helperThread4.mUserSigInfo, iRequestTransport);
                                                        }
                                                    }
                                                };
                                            } else if (this.mReqType == 10) {
                                                final int iRequestTransportMsf = this.mHelper.RequestTransportMsf(1, this.mEncrypt, this.mUserAccount, this.mDwAppid, this.mRole, this.mReqContext);
                                                handler = this.mHandler;
                                                runnable = new java.lang.Runnable() { // from class: oicq.wlogin_sdk.request.WtloginHelper.HelperThread.10
                                                    @Override // java.lang.Runnable
                                                    public void run() {
                                                        oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.quitSelfLooper();
                                                        if (i3 != 0) {
                                                            return;
                                                        }
                                                        oicq.wlogin_sdk.request.WtloginListener wtloginListener = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mHelper.mListener;
                                                        oicq.wlogin_sdk.request.WtloginHelper.HelperThread helperThread = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this;
                                                        wtloginListener.OnRequestTransport(helperThread.mUserAccount, helperThread.mDwAppid, helperThread.mRole, helperThread.mReqContext, iRequestTransportMsf);
                                                    }
                                                };
                                            } else if (this.mReqType == 12) {
                                                final int iCheckSMSVerifyLoginAccount = this.mHelper.CheckSMSVerifyLoginAccount(this.mAppid1, this.mSubAppid1, this.mUserAccount, this.mUserSigInfo, 1);
                                                handler = this.mHandler;
                                                runnable = new java.lang.Runnable() { // from class: oicq.wlogin_sdk.request.WtloginHelper.HelperThread.11
                                                    @Override // java.lang.Runnable
                                                    public void run() {
                                                        oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.quitSelfLooper();
                                                        if (i3 != 0) {
                                                            return;
                                                        }
                                                        oicq.wlogin_sdk.request.async_context async_contextVarB = oicq.wlogin_sdk.request.t.b(oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mUserSigInfo._seqence);
                                                        oicq.wlogin_sdk.tools.ErrMsg errMsg = async_contextVarB._last_err_msg;
                                                        oicq.wlogin_sdk.request.WtloginListener wtloginListener = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mHelper.mListener;
                                                        oicq.wlogin_sdk.request.WtloginHelper.HelperThread helperThread = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this;
                                                        wtloginListener.OnCheckSMSVerifyLoginAccount(helperThread.mAppid1, helperThread.mSubAppid1, helperThread.mUserAccount, async_contextVarB._smslogin_msg, async_contextVarB._smslogin_msgcnt, async_contextVarB._smslogin_timelimit, helperThread.mUserSigInfo, iCheckSMSVerifyLoginAccount, errMsg);
                                                    }
                                                };
                                            } else if (this.mReqType == 13) {
                                                final int iVerifySMSVerifyLoginCode = this.mHelper.VerifySMSVerifyLoginCode(this.mUserAccount, this.mMsgCode, this.mUserSigInfo, 1);
                                                handler = this.mHandler;
                                                runnable = new java.lang.Runnable() { // from class: oicq.wlogin_sdk.request.WtloginHelper.HelperThread.12
                                                    @Override // java.lang.Runnable
                                                    public void run() {
                                                        oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.quitSelfLooper();
                                                        if (i3 != 0) {
                                                            return;
                                                        }
                                                        oicq.wlogin_sdk.tools.ErrMsg errMsg = oicq.wlogin_sdk.request.t.b(oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mUserSigInfo._seqence)._last_err_msg;
                                                        oicq.wlogin_sdk.request.WtloginListener wtloginListener = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mHelper.mListener;
                                                        oicq.wlogin_sdk.request.WtloginHelper.HelperThread helperThread = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this;
                                                        wtloginListener.OnVerifySMSVerifyLoginCode(helperThread.mUserAccount, helperThread.mMsgCode, helperThread.mUserSigInfo, iVerifySMSVerifyLoginCode, errMsg);
                                                    }
                                                };
                                            } else if (this.mReqType == 14) {
                                                final int iRefreshSMSVerifyLoginCode = this.mHelper.RefreshSMSVerifyLoginCode(this.mUserAccount, this.mUserSigInfo, 1);
                                                handler = this.mHandler;
                                                runnable = new java.lang.Runnable() { // from class: oicq.wlogin_sdk.request.WtloginHelper.HelperThread.13
                                                    @Override // java.lang.Runnable
                                                    public void run() {
                                                        oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.quitSelfLooper();
                                                        if (i3 != 0) {
                                                            return;
                                                        }
                                                        oicq.wlogin_sdk.request.async_context async_contextVarB = oicq.wlogin_sdk.request.t.b(oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mUserSigInfo._seqence);
                                                        oicq.wlogin_sdk.tools.ErrMsg errMsg = async_contextVarB._last_err_msg;
                                                        oicq.wlogin_sdk.request.WtloginListener wtloginListener = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mHelper.mListener;
                                                        oicq.wlogin_sdk.request.WtloginHelper.HelperThread helperThread = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this;
                                                        wtloginListener.OnRefreshSMSVerifyLoginCode(helperThread.mUserAccount, async_contextVarB._smslogin_msg, async_contextVarB._smslogin_msgcnt, async_contextVarB._smslogin_timelimit, helperThread.mUserSigInfo, iRefreshSMSVerifyLoginCode, errMsg);
                                                    }
                                                };
                                            } else if (this.mReqType == 8) {
                                                this.mHelper.RequestReportError(1, this.mST1, this.mST1Key, this.mUIN, this.mDwAppid, this.mReportErrType);
                                            } else if (this.mReqType == 15) {
                                                final int stWithQQSig = this.mHelper.getStWithQQSig(this.mUserAccount, this.quickLoginParam, 1);
                                                handler = this.mHandler;
                                                runnable = new java.lang.Runnable() { // from class: oicq.wlogin_sdk.request.WtloginHelper.HelperThread.14
                                                    @Override // java.lang.Runnable
                                                    public void run() {
                                                        oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.quitSelfLooper();
                                                        if (i3 != 0) {
                                                            return;
                                                        }
                                                        if (oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mHelper.mListener == null) {
                                                            oicq.wlogin_sdk.tools.util.LOGW("login helper listener is null", oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mUserAccount);
                                                            return;
                                                        }
                                                        oicq.wlogin_sdk.tools.ErrMsg errMsg = oicq.wlogin_sdk.request.t.b(oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mUserSigInfo._seqence)._last_err_msg;
                                                        oicq.wlogin_sdk.request.WtloginListener wtloginListener = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mHelper.mListener;
                                                        oicq.wlogin_sdk.request.WtloginHelper.HelperThread helperThread = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this;
                                                        wtloginListener.onQuickLogin(helperThread.mUserAccount, helperThread.quickLoginParam, stWithQQSig, errMsg);
                                                    }
                                                };
                                            } else if (this.mReqType == 16) {
                                                final int stWithPtSig = this.mHelper.getStWithPtSig(this.mUserAccount, this.ptSig, this.quickLoginParam, 1);
                                                handler = this.mHandler;
                                                runnable = new java.lang.Runnable() { // from class: oicq.wlogin_sdk.request.WtloginHelper.HelperThread.15
                                                    @Override // java.lang.Runnable
                                                    public void run() {
                                                        oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.quitSelfLooper();
                                                        if (i3 != 0) {
                                                            return;
                                                        }
                                                        if (oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mHelper.mListener == null) {
                                                            oicq.wlogin_sdk.tools.util.LOGW("login helper listener is null", oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mUserAccount);
                                                            return;
                                                        }
                                                        oicq.wlogin_sdk.tools.ErrMsg errMsg = oicq.wlogin_sdk.request.t.b(oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mUserSigInfo._seqence)._last_err_msg;
                                                        oicq.wlogin_sdk.request.WtloginListener wtloginListener = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mHelper.mListener;
                                                        oicq.wlogin_sdk.request.WtloginHelper.HelperThread helperThread = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this;
                                                        wtloginListener.onQuickLogin(helperThread.mUserAccount, helperThread.quickLoginParam, stWithPtSig, errMsg);
                                                    }
                                                };
                                            } else if (this.mReqType == 17) {
                                                final int stWithQrSig = this.mHelper.getStWithQrSig(this.mUserAccount, this.mDwAppid, this.mDwSubDstAppid, this.mDwMainSigMap, this.mUserSigInfo, 1);
                                                handler = this.mHandler;
                                                runnable = new java.lang.Runnable() { // from class: oicq.wlogin_sdk.request.WtloginHelper.HelperThread.16
                                                    @Override // java.lang.Runnable
                                                    public void run() {
                                                        oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.quitSelfLooper();
                                                        if (i3 != 0) {
                                                            return;
                                                        }
                                                        if (oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mHelper.mListener == null) {
                                                            oicq.wlogin_sdk.tools.util.LOGW("login helper listener is null", oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mUserAccount);
                                                            return;
                                                        }
                                                        oicq.wlogin_sdk.tools.ErrMsg errMsg = oicq.wlogin_sdk.request.t.b(oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mUserSigInfo._seqence)._last_err_msg;
                                                        oicq.wlogin_sdk.request.WtloginListener wtloginListener = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mHelper.mListener;
                                                        oicq.wlogin_sdk.request.WtloginHelper.HelperThread helperThread = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this;
                                                        wtloginListener.onGetStWithQrSig(helperThread.mUserAccount, helperThread.mDwAppid, helperThread.mDwMainSigMap, helperThread.mDwSubDstAppid, helperThread.mUserSigInfo, stWithQrSig, errMsg);
                                                    }
                                                };
                                            }
                                            handler.post(runnable);
                                        }
                                        handler.post(runnable);
                                    } catch (java.lang.Exception e) {
                                        e = e;
                                        i = i2;
                                        oicq.wlogin_sdk.tools.util.printException(e, "");
                                        this.mHandler.post(new java.lang.Runnable() { // from class: oicq.wlogin_sdk.request.WtloginHelper.HelperThread.17
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.quitSelfLooper();
                                                if (i != 0) {
                                                    return;
                                                }
                                                if (oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mHelper.mListener == null) {
                                                    oicq.wlogin_sdk.tools.util.LOGW("login helper listener is null", oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mUserAccount);
                                                    return;
                                                }
                                                oicq.wlogin_sdk.request.WtloginListener wtloginListener = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mHelper.mListener;
                                                oicq.wlogin_sdk.tools.ErrMsg errMsg = new oicq.wlogin_sdk.tools.ErrMsg();
                                                oicq.wlogin_sdk.request.WtloginHelper.HelperThread helperThread = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this;
                                                wtloginListener.OnException(errMsg, helperThread.mReqType, helperThread.mUserSigInfo);
                                            }
                                        });
                                        if (this.isSelfLooper) {
                                            android.os.Looper.loop();
                                        }
                                        if (this.mReqType != 7) {
                                            synchronized (oicq.wlogin_sdk.request.WtloginHelper.__sync_top) {
                                                if (oicq.wlogin_sdk.request.WtloginHelper.__top > 0) {
                                                    oicq.wlogin_sdk.request.WtloginHelper.__top--;
                                                }
                                                oicq.wlogin_sdk.tools.util.LOGI("pop queue " + oicq.wlogin_sdk.request.WtloginHelper.__top, "");
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                }
                                if (this.isSelfLooper) {
                                    android.os.Looper.loop();
                                }
                                if (this.mReqType != 7) {
                                    synchronized (oicq.wlogin_sdk.request.WtloginHelper.__sync_top) {
                                        if (oicq.wlogin_sdk.request.WtloginHelper.__top > 0) {
                                            oicq.wlogin_sdk.request.WtloginHelper.__top--;
                                        }
                                        oicq.wlogin_sdk.tools.util.LOGI("pop queue " + oicq.wlogin_sdk.request.WtloginHelper.__top, "");
                                    }
                                }
                            }
                            final int iRefreshSMSData = this.mHelper.RefreshSMSData(this.mUserAccount, this.mSmsAppid, this.mUserSigInfo, 1);
                            handler2 = this.mHandler;
                            runnable2 = new java.lang.Runnable() { // from class: oicq.wlogin_sdk.request.WtloginHelper.HelperThread.5
                                @Override // java.lang.Runnable
                                public void run() {
                                    oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.quitSelfLooper();
                                    if (i3 != 0) {
                                        return;
                                    }
                                    oicq.wlogin_sdk.request.async_context async_contextVarB = oicq.wlogin_sdk.request.t.b(oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mUserSigInfo._seqence);
                                    oicq.wlogin_sdk.tools.ErrMsg errMsg = async_contextVarB._last_err_msg;
                                    int i4 = async_contextVarB._t17b.get_available_msg_cnt();
                                    int i5 = async_contextVarB._t17b.get_time_limit();
                                    oicq.wlogin_sdk.request.WtloginListener wtloginListener = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this.mHelper.mListener;
                                    oicq.wlogin_sdk.request.WtloginHelper.HelperThread helperThread = oicq.wlogin_sdk.request.WtloginHelper.HelperThread.this;
                                    wtloginListener.OnRefreshSMSData(helperThread.mUserAccount, helperThread.mSmsAppid, helperThread.mUserSigInfo, i4, i5, iRefreshSMSData, errMsg);
                                }
                            };
                        }
                        handler2.post(runnable2);
                        if (this.isSelfLooper) {
                            android.os.Looper.loop();
                        }
                        if (this.mReqType != 7) {
                            synchronized (oicq.wlogin_sdk.request.WtloginHelper.__sync_top) {
                                if (oicq.wlogin_sdk.request.WtloginHelper.__top > 0) {
                                    oicq.wlogin_sdk.request.WtloginHelper.__top--;
                                }
                                oicq.wlogin_sdk.tools.util.LOGI("pop queue " + oicq.wlogin_sdk.request.WtloginHelper.__top, "");
                            }
                        }
                    } catch (java.lang.Exception e2) {
                        e = e2;
                    }
                } catch (java.lang.Throwable th) {
                    if (this.isSelfLooper) {
                        android.os.Looper.loop();
                    }
                    if (this.mReqType != 7) {
                        synchronized (oicq.wlogin_sdk.request.WtloginHelper.__sync_top) {
                            if (oicq.wlogin_sdk.request.WtloginHelper.__top > 0) {
                                oicq.wlogin_sdk.request.WtloginHelper.__top--;
                            }
                            oicq.wlogin_sdk.tools.util.LOGI("pop queue " + oicq.wlogin_sdk.request.WtloginHelper.__top, "");
                        }
                    }
                    throw th;
                }
            } catch (java.lang.Exception e3) {
                e = e3;
                i = i3;
            }
        }
    }

    public static class LoginSourceType {
        public static final int IM = 10;
        public static final int QQConn = 20;
        public static final int QQWallet = 40;
        public static final int unknown = 0;
        public static final int webView = 30;
        public static final int webViewForceRefresh = 31;
        public static final int webViewOnTimeRefresh = 32;
    }

    public static class QuickLoginParam {
        public long appid;
        public long dstAppid;
        public long[] dstSubAppidList;
        public int sigMap;
        public java.lang.String userAccount;
        public java.lang.String webViewActivityClassName;
        public boolean forceWebLogin = false;
        public boolean isUserAccountLocked = false;
        public java.lang.String titleBackgroundColor = "#3F51B5";
        public java.lang.String titleTextColor = "#FFFFFF";
        public int startAnimEnter = 0;
        public int startAnimExit = 0;
        public int finishAnimEnter = 0;
        public int finishAnimExit = 0;
        public long subAppid = 1;
        public oicq.wlogin_sdk.request.WUserSigInfo userSigInfo = new oicq.wlogin_sdk.request.WUserSigInfo();
    }

    public class QuickLoginRequestCode {
        public static final int REQUEST_PT_LOGIN = 1202;
        public static final int REQUEST_QQ_LOGIN = 1201;

        public QuickLoginRequestCode() {
        }
    }

    public static class RegTLVType {
        public static final int ADDRESS_BOOK = 7;
        public static final int APPID = 2;
        public static final int APPNAME = 14;
        public static final int CALL_BACK_URL = 5;
        public static final int EMAIL_URL = 4;
        public static final int GUID = 10;
        public static final int HAS_ADDRESS_BOOK = 8;
        public static final int ID = 1;
        public static final int LANGUAGE = 3;
        public static final int MPASSWD = 11;
        public static final int MSALT = 12;
        public static final int NEW_UIN = 31;
        public static final int NICK_NAME = 6;
        public static final int NOPASSWD_REG = 9;
        public static final int PHONE_NUMBER = 30;
        public static final int PHONE_NUMBER_BOUND_UIN = 36;
        public static final int PICTURE_ID = 17;
        public static final int PICTURE_URL = 40;
        public static final int REGISTER_SIG = 16;
        public static final int REG_SIG = 33;
        public static final int SET_DEVLOCK_FLG = 15;
        public static final int SUBAPPID = 13;
    }

    public static final class SigType {
        public static final int WLOGIN_A2 = 64;
        public static final int WLOGIN_A5 = 2;
        public static final int WLOGIN_AQSIG = 2097152;
        public static final int WLOGIN_D2 = 262144;
        public static final int WLOGIN_DA2 = 33554432;
        public static final int WLOGIN_LHSIG = 4194304;
        public static final int WLOGIN_LSKEY = 512;
        public static final int WLOGIN_OPENKEY = 16384;
        public static final int WLOGIN_PAYTOKEN = 8388608;
        public static final int WLOGIN_PF = 16777216;
        public static final int WLOGIN_PSKEY = 1048576;
        public static final int WLOGIN_PT4Token = 134217728;
        public static final int WLOGIN_QRPUSH = 67108864;
        public static final int WLOGIN_RESERVED = 16;
        public static final int WLOGIN_SID = 524288;
        public static final int WLOGIN_SIG64 = 8192;
        public static final int WLOGIN_SKEY = 4096;
        public static final int WLOGIN_ST = 128;
        public static final int WLOGIN_STWEB = 32;
        public static final int WLOGIN_TOKEN = 32768;
        public static final int WLOGIN_VKEY = 131072;
    }

    public WtloginHelper(android.content.Context context) {
        this.mG = new oicq.wlogin_sdk.request.t(null);
        this.mHelperHandler = newHelperHandler();
        this.mContext = null;
        this.mListener = null;
        this.mRegStatus = new oicq.wlogin_sdk.a.h();
        this.mMainSigMap = 16724722;
        this.mSubSigMap = 66560;
        this.mMiscBitmap = 16252796;
        this.mOpenAppid = 715019303L;
        this.mAysncSeq = 0L;
        this.isForLocal = false;
        this.isForLocal = false;
        this.mContext = context;
        this.mG.b(context);
        RequestInit();
    }

    public WtloginHelper(android.content.Context context, java.lang.Object obj) {
        this.mG = new oicq.wlogin_sdk.request.t(null);
        this.mHelperHandler = newHelperHandler();
        this.mContext = null;
        this.mListener = null;
        this.mRegStatus = new oicq.wlogin_sdk.a.h();
        this.mMainSigMap = 16724722;
        this.mSubSigMap = 66560;
        this.mMiscBitmap = 16252796;
        this.mOpenAppid = 715019303L;
        this.mAysncSeq = 0L;
        this.isForLocal = false;
        oicq.wlogin_sdk.request.WtloginMsfListener.TicketMgr = obj;
        localInit(context, false);
    }

    public WtloginHelper(android.content.Context context, boolean z) {
        this.mG = new oicq.wlogin_sdk.request.t(null);
        this.mHelperHandler = newHelperHandler();
        this.mContext = null;
        this.mListener = null;
        this.mRegStatus = new oicq.wlogin_sdk.a.h();
        this.mMainSigMap = 16724722;
        this.mSubSigMap = 66560;
        this.mMiscBitmap = 16252796;
        this.mOpenAppid = 715019303L;
        this.mAysncSeq = 0L;
        this.isForLocal = false;
        localInit(context, z);
    }

    private void AsyncGenRSAKey() {
        if (this.isForLocal) {
            return;
        }
        new java.lang.Thread("AsyncGenRSAKey") { // from class: oicq.wlogin_sdk.request.WtloginHelper.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() throws java.lang.Throwable {
                new oicq.wlogin_sdk.tools.RSACrypt(oicq.wlogin_sdk.request.WtloginHelper.this.mContext).GenRSAKey();
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:103:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:112:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:115:0x02e8  */
    /* JADX WARN: Code duplicated, block: B:120:0x0301  */
    /* JADX WARN: Code duplicated, block: B:122:0x0306  */
    /* JADX WARN: Code duplicated, block: B:132:0x018e A[ADDED_TO_REGION, EDGE_INSN: B:132:0x018e->B:67:0x018e BREAK  A[LOOP:0: B:59:0x0164->B:66:0x018b], REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:136:0x02c8 A[ADDED_TO_REGION, EDGE_INSN: B:136:0x02c8->B:109:0x02c8 BREAK  A[LOOP:1: B:101:0x029e->B:108:0x02c5], REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0094  */
    /* JADX WARN: Code duplicated, block: B:26:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:31:0x00de  */
    /* JADX WARN: Code duplicated, block: B:33:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:36:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:40:0x00fd A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:42:0x0106  */
    /* JADX WARN: Code duplicated, block: B:44:0x011d  */
    /* JADX WARN: Code duplicated, block: B:45:0x0121  */
    /* JADX WARN: Code duplicated, block: B:47:0x0126  */
    /* JADX WARN: Code duplicated, block: B:50:0x0148  */
    /* JADX WARN: Code duplicated, block: B:53:0x0153  */
    /* JADX WARN: Code duplicated, block: B:55:0x015a A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:61:0x0168  */
    /* JADX WARN: Code duplicated, block: B:68:0x0191  */
    /* JADX WARN: Code duplicated, block: B:70:0x0196  */
    /* JADX WARN: Code duplicated, block: B:73:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:76:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:78:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:80:0x0208  */
    /* JADX WARN: Code duplicated, block: B:81:0x020b  */
    /* JADX WARN: Code duplicated, block: B:84:0x024f  */
    /* JADX WARN: Code duplicated, block: B:85:0x0260  */
    /* JADX WARN: Code duplicated, block: B:87:0x0263 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:89:0x0266  */
    /* JADX WARN: Code duplicated, block: B:91:0x027f  */
    /* JADX WARN: Code duplicated, block: B:92:0x0281  */
    /* JADX WARN: Code duplicated, block: B:94:0x0289  */
    /* JADX WARN: Code duplicated, block: B:95:0x028e  */
    /* JADX WARN: Code duplicated, block: B:97:0x0295 A[ADDED_TO_REGION] */
    /* JADX WARN: Instruction removed from duplicated block: B:23:0x0094, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:42:0x0106, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:89:0x0266, please report this as an issue */
    public int CheckPictureAndGetSt(java.lang.String str, byte[] bArr, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo, byte[][] bArr2, int i) {
        long jB;
        boolean z;
        boolean z2;
        int iA;
        long jB2;
        byte[] bArr3;
        oicq.wlogin_sdk.sharemem.WloginSigInfo wloginSigInfoA;
        byte[] bArr4;
        byte[] bArr5;
        byte[] bArr6;
        oicq.wlogin_sdk.request.async_context async_contextVar;
        int i2;
        int iA2;
        int iA3;
        long jB3;
        oicq.wlogin_sdk.sharemem.WloginSigInfo wloginSigInfoA2;
        long[] jArr;
        int i3;
        long[] jArr2;
        int i4;
        long[] jArr3;
        int i5;
        long[] jArr4;
        oicq.wlogin_sdk.request.Ticket ticketGetUserSigInfoTicket;
        oicq.wlogin_sdk.request.Ticket ticket;
        oicq.wlogin_sdk.tlv_type.tlv_t150 tlv_t150Var;
        byte[] bArr7;
        if (str == null || bArr == null || wUserSigInfo == null) {
            return oicq.wlogin_sdk.tools.util.E_INPUT;
        }
        if (i == 0) {
            new oicq.wlogin_sdk.request.WtloginHelper.HelperThread(this, this.mHelperHandler, str, bArr, wUserSigInfo, bArr2, "CheckPictureAndGetSt").RunReq(2);
            return oicq.wlogin_sdk.tools.util.E_PENDING;
        }
        if (wUserSigInfo._seqence == 0) {
            wUserSigInfo._seqence = this.mAysncSeq;
        }
        oicq.wlogin_sdk.request.t tVarA = this.mG.a(wUserSigInfo._seqence);
        long j = tVarA.h;
        wUserSigInfo._seqence = j;
        oicq.wlogin_sdk.request.async_context async_contextVarB = oicq.wlogin_sdk.request.t.b(j);
        oicq.wlogin_sdk.tools.util.LOGI("user:" + str + " CheckPictureAndGetSt Seq:" + tVarA.h + " ...", str);
        tVarA.g = str;
        async_contextVarB._last_err_msg = new oicq.wlogin_sdk.tools.ErrMsg();
        if (!oicq.wlogin_sdk.tools.util.check_uin_account(str).booleanValue()) {
            jB = tVarA.b(str);
            if (jB == 0) {
                z = false;
            }
            if (z) {
                tVarA.f = jB;
                wUserSigInfo.uin = jB + "";
            }
            z2 = z;
            iA = new oicq.wlogin_sdk.request.o(tVarA).a(bArr, this.mMiscBitmap, this.mSubSigMap, async_contextVarB._sub_appid_list, wUserSigInfo);
            if (iA == 204) {
                iA = new oicq.wlogin_sdk.request.q(tVarA).a(this.mMiscBitmap, this.mSubSigMap, async_contextVarB._sub_appid_list, wUserSigInfo);
            }
            if (iA != 0 || iA == 160) {
                if (oicq.wlogin_sdk.tools.util.check_uin_account(str).booleanValue()) {
                    jB2 = java.lang.Long.parseLong(str);
                } else {
                    jB2 = tVarA.b(str);
                    if (jB2 != 0) {
                    }
                    if (async_contextVarB._msalt == 0 || z2) {
                        tVarA.f = jB2;
                        wUserSigInfo.uin = jB2 + "";
                        if (iA == 160) {
                            i4 = iA;
                            async_contextVar = async_contextVarB;
                        } else {
                            bArr3 = wUserSigInfo._reserveData;
                            if (bArr3 != null || bArr3.length <= 3) {
                                tVarA.i = 0;
                            } else {
                                tVarA.i = oicq.wlogin_sdk.tools.util.buf_to_int32(bArr3, 0);
                                oicq.wlogin_sdk.tools.util.LOGI("MSF SSO SEQ:" + tVarA.i, str);
                            }
                            wloginSigInfoA = tVarA.a(jB2, async_contextVarB._appid);
                            if (wloginSigInfoA != null) {
                                wUserSigInfo.get_clone(wloginSigInfoA);
                                jArr3 = async_contextVarB._sub_appid_list;
                                if (jArr3 != null && bArr2 != null && jArr3.length * 2 == bArr2.length) {
                                    i5 = 0;
                                    while (true) {
                                        jArr4 = async_contextVarB._sub_appid_list;
                                        if (jArr4 != null || i5 >= jArr4.length) {
                                            break;
                                        }
                                        oicq.wlogin_sdk.sharemem.WloginSigInfo wloginSigInfoA3 = tVarA.a(jB2, jArr4[i5]);
                                        if (wloginSigInfoA3 != null) {
                                            int i6 = i5 * 2;
                                            bArr2[i6] = (byte[]) wloginSigInfoA3._userSt_Key.clone();
                                            bArr2[i6 + 1] = (byte[]) wloginSigInfoA3._userStSig.clone();
                                        }
                                        i5++;
                                    }
                                }
                                async_contextVar = async_contextVarB;
                            } else {
                                bArr4 = wUserSigInfo._in_ksid;
                                if (bArr4 != null || bArr4.length <= 0) {
                                    bArr5 = oicq.wlogin_sdk.request.t.aa;
                                } else {
                                    bArr5 = (byte[]) bArr4.clone();
                                }
                                bArr6 = bArr5;
                                if (async_contextVarB._tmp_pwd_type != 0) {
                                    oicq.wlogin_sdk.request.l lVar = new oicq.wlogin_sdk.request.l(tVarA, this.mContext);
                                    lVar.g();
                                    long j2 = async_contextVarB._appid;
                                    long j3 = async_contextVarB._sub_appid;
                                    async_contextVar = async_contextVarB;
                                    iA2 = lVar.a(j2, j3, tVarA.f, 0, oicq.wlogin_sdk.request.t.ad, async_contextVar._tmp_pwd, null, this.mMiscBitmap, this.mSubSigMap, async_contextVar._sub_appid_list, async_contextVar._main_sigmap, j3, oicq.wlogin_sdk.request.t.y, 0, 0, 1, bArr6, wUserSigInfo);
                                } else {
                                    async_contextVar = async_contextVarB;
                                    byte[] bArr8 = new byte[4];
                                    oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr8, 0, (java.lang.System.currentTimeMillis() / 1000) + oicq.wlogin_sdk.request.t.ac);
                                    if (async_contextVar._isSmslogin) {
                                        i2 = 3;
                                    } else {
                                        i2 = 1;
                                    }
                                    oicq.wlogin_sdk.request.l lVar2 = new oicq.wlogin_sdk.request.l(tVarA, this.mContext);
                                    lVar2.g();
                                    long j4 = async_contextVar._appid;
                                    long j5 = async_contextVar._sub_appid;
                                    iA2 = lVar2.a(j4, j5, tVarA.f, 0, oicq.wlogin_sdk.request.t.ad, bArr8, async_contextVar._tmp_pwd, i2, this.mMiscBitmap, this.mSubSigMap, async_contextVar._sub_appid_list, async_contextVar._main_sigmap, j5, oicq.wlogin_sdk.request.t.y, 0, 0, 1, bArr6, wUserSigInfo);
                                }
                                if (iA2 == 204) {
                                    iA3 = new oicq.wlogin_sdk.request.q(tVarA).a(this.mMiscBitmap, this.mSubSigMap, async_contextVar._sub_appid_list, wUserSigInfo);
                                } else {
                                    iA3 = iA2;
                                }
                                if (iA3 != 0 || iA3 == 160) {
                                    jB3 = tVarA.b(str);
                                    wUserSigInfo.uin = jB3 + "";
                                    if (iA3 == 160) {
                                        i4 = iA3;
                                    } else {
                                        wloginSigInfoA2 = tVarA.a(jB3, async_contextVar._appid);
                                        if (wloginSigInfoA2 == null) {
                                            i4 = oicq.wlogin_sdk.tools.util.E_NO_KEY;
                                        } else {
                                            wUserSigInfo.get_clone(wloginSigInfoA2);
                                            jArr = async_contextVar._sub_appid_list;
                                            if (jArr != null && bArr2 != null && jArr.length * 2 == bArr2.length) {
                                                i3 = 0;
                                                while (true) {
                                                    jArr2 = async_contextVar._sub_appid_list;
                                                    if (jArr2 != null || i3 >= jArr2.length) {
                                                        break;
                                                    }
                                                    oicq.wlogin_sdk.sharemem.WloginSigInfo wloginSigInfoA4 = tVarA.a(jB3, jArr2[i3]);
                                                    if (wloginSigInfoA4 != null) {
                                                        int i7 = i3 * 2;
                                                        bArr2[i7] = (byte[]) wloginSigInfoA4._userSt_Key.clone();
                                                        bArr2[i7 + 1] = (byte[]) wloginSigInfoA4._userStSig.clone();
                                                    }
                                                    i3++;
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    i4 = iA3;
                                }
                            }
                            i4 = 0;
                        }
                    } else {
                        async_contextVar = async_contextVarB;
                        i4 = oicq.wlogin_sdk.tools.util.E_NO_UIN;
                    }
                }
                z2 = true;
                if (async_contextVarB._msalt == 0) {
                    tVarA.f = jB2;
                    wUserSigInfo.uin = jB2 + "";
                    if (iA == 160) {
                        i4 = iA;
                        async_contextVar = async_contextVarB;
                    } else {
                        bArr3 = wUserSigInfo._reserveData;
                        if (bArr3 != null) {
                            tVarA.i = 0;
                        } else {
                            tVarA.i = 0;
                        }
                        wloginSigInfoA = tVarA.a(jB2, async_contextVarB._appid);
                        if (wloginSigInfoA != null) {
                            wUserSigInfo.get_clone(wloginSigInfoA);
                            jArr3 = async_contextVarB._sub_appid_list;
                            if (jArr3 != null) {
                                i5 = 0;
                                while (true) {
                                    jArr4 = async_contextVarB._sub_appid_list;
                                    if (jArr4 != null) {
                                        break;
                                    }
                                    break;
                                    break;
                                    i5++;
                                }
                            }
                            async_contextVar = async_contextVarB;
                        } else {
                            bArr4 = wUserSigInfo._in_ksid;
                            if (bArr4 != null) {
                                bArr5 = oicq.wlogin_sdk.request.t.aa;
                            } else {
                                bArr5 = oicq.wlogin_sdk.request.t.aa;
                            }
                            bArr6 = bArr5;
                            if (async_contextVarB._tmp_pwd_type != 0) {
                                oicq.wlogin_sdk.request.l lVar3 = new oicq.wlogin_sdk.request.l(tVarA, this.mContext);
                                lVar3.g();
                                long j6 = async_contextVarB._appid;
                                long j7 = async_contextVarB._sub_appid;
                                async_contextVar = async_contextVarB;
                                iA2 = lVar3.a(j6, j7, tVarA.f, 0, oicq.wlogin_sdk.request.t.ad, async_contextVar._tmp_pwd, null, this.mMiscBitmap, this.mSubSigMap, async_contextVar._sub_appid_list, async_contextVar._main_sigmap, j7, oicq.wlogin_sdk.request.t.y, 0, 0, 1, bArr6, wUserSigInfo);
                            } else {
                                async_contextVar = async_contextVarB;
                                byte[] bArr9 = new byte[4];
                                oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr9, 0, (java.lang.System.currentTimeMillis() / 1000) + oicq.wlogin_sdk.request.t.ac);
                                if (async_contextVar._isSmslogin) {
                                    i2 = 3;
                                } else {
                                    i2 = 1;
                                }
                                oicq.wlogin_sdk.request.l lVar4 = new oicq.wlogin_sdk.request.l(tVarA, this.mContext);
                                lVar4.g();
                                long j8 = async_contextVar._appid;
                                long j9 = async_contextVar._sub_appid;
                                iA2 = lVar4.a(j8, j9, tVarA.f, 0, oicq.wlogin_sdk.request.t.ad, bArr9, async_contextVar._tmp_pwd, i2, this.mMiscBitmap, this.mSubSigMap, async_contextVar._sub_appid_list, async_contextVar._main_sigmap, j9, oicq.wlogin_sdk.request.t.y, 0, 0, 1, bArr6, wUserSigInfo);
                            }
                            if (iA2 == 204) {
                                iA3 = new oicq.wlogin_sdk.request.q(tVarA).a(this.mMiscBitmap, this.mSubSigMap, async_contextVar._sub_appid_list, wUserSigInfo);
                            } else {
                                iA3 = iA2;
                            }
                            if (iA3 != 0) {
                                jB3 = tVarA.b(str);
                                wUserSigInfo.uin = jB3 + "";
                                if (iA3 == 160) {
                                    i4 = iA3;
                                } else {
                                    wloginSigInfoA2 = tVarA.a(jB3, async_contextVar._appid);
                                    if (wloginSigInfoA2 == null) {
                                        i4 = oicq.wlogin_sdk.tools.util.E_NO_KEY;
                                    } else {
                                        wUserSigInfo.get_clone(wloginSigInfoA2);
                                        jArr = async_contextVar._sub_appid_list;
                                        if (jArr != null) {
                                            i3 = 0;
                                            while (true) {
                                                jArr2 = async_contextVar._sub_appid_list;
                                                if (jArr2 != null) {
                                                    break;
                                                }
                                                break;
                                                break;
                                                i3++;
                                            }
                                        }
                                    }
                                }
                            } else {
                                jB3 = tVarA.b(str);
                                wUserSigInfo.uin = jB3 + "";
                                if (iA3 == 160) {
                                    i4 = iA3;
                                } else {
                                    wloginSigInfoA2 = tVarA.a(jB3, async_contextVar._appid);
                                    if (wloginSigInfoA2 == null) {
                                        i4 = oicq.wlogin_sdk.tools.util.E_NO_KEY;
                                    } else {
                                        wUserSigInfo.get_clone(wloginSigInfoA2);
                                        jArr = async_contextVar._sub_appid_list;
                                        if (jArr != null) {
                                            i3 = 0;
                                            while (true) {
                                                jArr2 = async_contextVar._sub_appid_list;
                                                if (jArr2 != null) {
                                                    break;
                                                    break;
                                                }
                                                break;
                                                break;
                                                i3++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i4 = 0;
                    }
                } else {
                    tVarA.f = jB2;
                    wUserSigInfo.uin = jB2 + "";
                    if (iA == 160) {
                        i4 = iA;
                        async_contextVar = async_contextVarB;
                    } else {
                        bArr3 = wUserSigInfo._reserveData;
                        if (bArr3 != null) {
                            tVarA.i = 0;
                        } else {
                            tVarA.i = 0;
                        }
                        wloginSigInfoA = tVarA.a(jB2, async_contextVarB._appid);
                        if (wloginSigInfoA != null) {
                            wUserSigInfo.get_clone(wloginSigInfoA);
                            jArr3 = async_contextVarB._sub_appid_list;
                            if (jArr3 != null) {
                                i5 = 0;
                                while (true) {
                                    jArr4 = async_contextVarB._sub_appid_list;
                                    if (jArr4 != null) {
                                        break;
                                        break;
                                    }
                                    break;
                                    break;
                                    i5++;
                                }
                            }
                            async_contextVar = async_contextVarB;
                        } else {
                            bArr4 = wUserSigInfo._in_ksid;
                            if (bArr4 != null) {
                                bArr5 = oicq.wlogin_sdk.request.t.aa;
                            } else {
                                bArr5 = oicq.wlogin_sdk.request.t.aa;
                            }
                            bArr6 = bArr5;
                            if (async_contextVarB._tmp_pwd_type != 0) {
                                oicq.wlogin_sdk.request.l lVar5 = new oicq.wlogin_sdk.request.l(tVarA, this.mContext);
                                lVar5.g();
                                long j10 = async_contextVarB._appid;
                                long j11 = async_contextVarB._sub_appid;
                                async_contextVar = async_contextVarB;
                                iA2 = lVar5.a(j10, j11, tVarA.f, 0, oicq.wlogin_sdk.request.t.ad, async_contextVar._tmp_pwd, null, this.mMiscBitmap, this.mSubSigMap, async_contextVar._sub_appid_list, async_contextVar._main_sigmap, j11, oicq.wlogin_sdk.request.t.y, 0, 0, 1, bArr6, wUserSigInfo);
                            } else {
                                async_contextVar = async_contextVarB;
                                byte[] bArr10 = new byte[4];
                                oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr10, 0, (java.lang.System.currentTimeMillis() / 1000) + oicq.wlogin_sdk.request.t.ac);
                                if (async_contextVar._isSmslogin) {
                                    i2 = 3;
                                } else {
                                    i2 = 1;
                                }
                                oicq.wlogin_sdk.request.l lVar6 = new oicq.wlogin_sdk.request.l(tVarA, this.mContext);
                                lVar6.g();
                                long j12 = async_contextVar._appid;
                                long j13 = async_contextVar._sub_appid;
                                iA2 = lVar6.a(j12, j13, tVarA.f, 0, oicq.wlogin_sdk.request.t.ad, bArr10, async_contextVar._tmp_pwd, i2, this.mMiscBitmap, this.mSubSigMap, async_contextVar._sub_appid_list, async_contextVar._main_sigmap, j13, oicq.wlogin_sdk.request.t.y, 0, 0, 1, bArr6, wUserSigInfo);
                            }
                            if (iA2 == 204) {
                                iA3 = new oicq.wlogin_sdk.request.q(tVarA).a(this.mMiscBitmap, this.mSubSigMap, async_contextVar._sub_appid_list, wUserSigInfo);
                            } else {
                                iA3 = iA2;
                            }
                            if (iA3 != 0) {
                                jB3 = tVarA.b(str);
                                wUserSigInfo.uin = jB3 + "";
                                if (iA3 == 160) {
                                    i4 = iA3;
                                } else {
                                    wloginSigInfoA2 = tVarA.a(jB3, async_contextVar._appid);
                                    if (wloginSigInfoA2 == null) {
                                        i4 = oicq.wlogin_sdk.tools.util.E_NO_KEY;
                                    } else {
                                        wUserSigInfo.get_clone(wloginSigInfoA2);
                                        jArr = async_contextVar._sub_appid_list;
                                        if (jArr != null) {
                                            i3 = 0;
                                            while (true) {
                                                jArr2 = async_contextVar._sub_appid_list;
                                                if (jArr2 != null) {
                                                    break;
                                                    break;
                                                }
                                                break;
                                                break;
                                                i3++;
                                            }
                                        }
                                    }
                                }
                            } else {
                                jB3 = tVarA.b(str);
                                wUserSigInfo.uin = jB3 + "";
                                if (iA3 == 160) {
                                    i4 = iA3;
                                } else {
                                    wloginSigInfoA2 = tVarA.a(jB3, async_contextVar._appid);
                                    if (wloginSigInfoA2 == null) {
                                        i4 = oicq.wlogin_sdk.tools.util.E_NO_KEY;
                                    } else {
                                        wUserSigInfo.get_clone(wloginSigInfoA2);
                                        jArr = async_contextVar._sub_appid_list;
                                        if (jArr != null) {
                                            i3 = 0;
                                            while (true) {
                                                jArr2 = async_contextVar._sub_appid_list;
                                                if (jArr2 != null) {
                                                    break;
                                                    break;
                                                }
                                                break;
                                                break;
                                                i3++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i4 = 0;
                    }
                }
            } else {
                i4 = iA;
                async_contextVar = async_contextVarB;
            }
            ticketGetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo, 128);
            if (ticketGetUserSigInfoTicket == null) {
                ticketGetUserSigInfoTicket = new oicq.wlogin_sdk.request.Ticket();
            }
            ticket = ticketGetUserSigInfoTicket;
            oicq.wlogin_sdk.request.t.an.commit_t2(tVarA.f, tVarA.g, oicq.wlogin_sdk.tools.util.format_ret_code(i4), i4);
            if (i4 == 0) {
                bArr7 = ticket._sig;
                if (bArr7 == null && bArr7.length != 0) {
                    RequestReport(0, bArr7, ticket._sig_key, tVarA.f, async_contextVar._appid);
                }
            } else {
                async_contextVar = async_contextVar;
                ticket = ticket;
                i4 = i4;
                RequestReportError(0, ticket._sig, ticket._sig_key, tVarA.f, async_contextVar._appid, 0);
            }
            tlv_t150Var = tVarA.d;
            if (tlv_t150Var != null && tlv_t150Var.get_bitmap() != 0) {
                this.mG.d = tVarA.d;
                RequestReportError(0, ticket._sig, ticket._sig_key, tVarA.f, async_contextVar._appid, 1);
            }
            oicq.wlogin_sdk.request.t.b();
            tVarA.h();
            oicq.wlogin_sdk.tools.util.LOGI("user:" + str + " CheckPictureAndGetSt Seq:" + tVarA.h + " ret=" + i4, "" + tVarA.f);
            return i4;
        }
        jB = java.lang.Long.parseLong(str);
        z = true;
        if (z) {
            tVarA.f = jB;
            wUserSigInfo.uin = jB + "";
        }
        z2 = z;
        iA = new oicq.wlogin_sdk.request.o(tVarA).a(bArr, this.mMiscBitmap, this.mSubSigMap, async_contextVarB._sub_appid_list, wUserSigInfo);
        if (iA == 204) {
            iA = new oicq.wlogin_sdk.request.q(tVarA).a(this.mMiscBitmap, this.mSubSigMap, async_contextVarB._sub_appid_list, wUserSigInfo);
        }
        if (iA != 0) {
            if (oicq.wlogin_sdk.tools.util.check_uin_account(str).booleanValue()) {
                jB2 = tVarA.b(str);
                if (jB2 != 0) {
                }
                if (async_contextVarB._msalt == 0) {
                    tVarA.f = jB2;
                    wUserSigInfo.uin = jB2 + "";
                    if (iA == 160) {
                        i4 = iA;
                        async_contextVar = async_contextVarB;
                    } else {
                        bArr3 = wUserSigInfo._reserveData;
                        if (bArr3 != null) {
                            tVarA.i = 0;
                        } else {
                            tVarA.i = 0;
                        }
                        wloginSigInfoA = tVarA.a(jB2, async_contextVarB._appid);
                        if (wloginSigInfoA != null) {
                            wUserSigInfo.get_clone(wloginSigInfoA);
                            jArr3 = async_contextVarB._sub_appid_list;
                            if (jArr3 != null) {
                                i5 = 0;
                                while (true) {
                                    jArr4 = async_contextVarB._sub_appid_list;
                                    if (jArr4 != null) {
                                        break;
                                        break;
                                    }
                                    break;
                                    break;
                                    i5++;
                                }
                            }
                            async_contextVar = async_contextVarB;
                        } else {
                            bArr4 = wUserSigInfo._in_ksid;
                            if (bArr4 != null) {
                                bArr5 = oicq.wlogin_sdk.request.t.aa;
                            } else {
                                bArr5 = oicq.wlogin_sdk.request.t.aa;
                            }
                            bArr6 = bArr5;
                            if (async_contextVarB._tmp_pwd_type != 0) {
                                oicq.wlogin_sdk.request.l lVar7 = new oicq.wlogin_sdk.request.l(tVarA, this.mContext);
                                lVar7.g();
                                long j14 = async_contextVarB._appid;
                                long j15 = async_contextVarB._sub_appid;
                                async_contextVar = async_contextVarB;
                                iA2 = lVar7.a(j14, j15, tVarA.f, 0, oicq.wlogin_sdk.request.t.ad, async_contextVar._tmp_pwd, null, this.mMiscBitmap, this.mSubSigMap, async_contextVar._sub_appid_list, async_contextVar._main_sigmap, j15, oicq.wlogin_sdk.request.t.y, 0, 0, 1, bArr6, wUserSigInfo);
                            } else {
                                async_contextVar = async_contextVarB;
                                byte[] bArr11 = new byte[4];
                                oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr11, 0, (java.lang.System.currentTimeMillis() / 1000) + oicq.wlogin_sdk.request.t.ac);
                                if (async_contextVar._isSmslogin) {
                                    i2 = 3;
                                } else {
                                    i2 = 1;
                                }
                                oicq.wlogin_sdk.request.l lVar8 = new oicq.wlogin_sdk.request.l(tVarA, this.mContext);
                                lVar8.g();
                                long j16 = async_contextVar._appid;
                                long j17 = async_contextVar._sub_appid;
                                iA2 = lVar8.a(j16, j17, tVarA.f, 0, oicq.wlogin_sdk.request.t.ad, bArr11, async_contextVar._tmp_pwd, i2, this.mMiscBitmap, this.mSubSigMap, async_contextVar._sub_appid_list, async_contextVar._main_sigmap, j17, oicq.wlogin_sdk.request.t.y, 0, 0, 1, bArr6, wUserSigInfo);
                            }
                            if (iA2 == 204) {
                                iA3 = new oicq.wlogin_sdk.request.q(tVarA).a(this.mMiscBitmap, this.mSubSigMap, async_contextVar._sub_appid_list, wUserSigInfo);
                            } else {
                                iA3 = iA2;
                            }
                            if (iA3 != 0) {
                                jB3 = tVarA.b(str);
                                wUserSigInfo.uin = jB3 + "";
                                if (iA3 == 160) {
                                    i4 = iA3;
                                } else {
                                    wloginSigInfoA2 = tVarA.a(jB3, async_contextVar._appid);
                                    if (wloginSigInfoA2 == null) {
                                        i4 = oicq.wlogin_sdk.tools.util.E_NO_KEY;
                                    } else {
                                        wUserSigInfo.get_clone(wloginSigInfoA2);
                                        jArr = async_contextVar._sub_appid_list;
                                        if (jArr != null) {
                                            i3 = 0;
                                            while (true) {
                                                jArr2 = async_contextVar._sub_appid_list;
                                                if (jArr2 != null) {
                                                    break;
                                                    break;
                                                }
                                                break;
                                                break;
                                                i3++;
                                            }
                                        }
                                    }
                                }
                            } else {
                                jB3 = tVarA.b(str);
                                wUserSigInfo.uin = jB3 + "";
                                if (iA3 == 160) {
                                    i4 = iA3;
                                } else {
                                    wloginSigInfoA2 = tVarA.a(jB3, async_contextVar._appid);
                                    if (wloginSigInfoA2 == null) {
                                        i4 = oicq.wlogin_sdk.tools.util.E_NO_KEY;
                                    } else {
                                        wUserSigInfo.get_clone(wloginSigInfoA2);
                                        jArr = async_contextVar._sub_appid_list;
                                        if (jArr != null) {
                                            i3 = 0;
                                            while (true) {
                                                jArr2 = async_contextVar._sub_appid_list;
                                                if (jArr2 != null) {
                                                    break;
                                                    break;
                                                }
                                                break;
                                                break;
                                                i3++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i4 = 0;
                    }
                } else {
                    tVarA.f = jB2;
                    wUserSigInfo.uin = jB2 + "";
                    if (iA == 160) {
                        i4 = iA;
                        async_contextVar = async_contextVarB;
                    } else {
                        bArr3 = wUserSigInfo._reserveData;
                        if (bArr3 != null) {
                            tVarA.i = 0;
                        } else {
                            tVarA.i = 0;
                        }
                        wloginSigInfoA = tVarA.a(jB2, async_contextVarB._appid);
                        if (wloginSigInfoA != null) {
                            wUserSigInfo.get_clone(wloginSigInfoA);
                            jArr3 = async_contextVarB._sub_appid_list;
                            if (jArr3 != null) {
                                i5 = 0;
                                while (true) {
                                    jArr4 = async_contextVarB._sub_appid_list;
                                    if (jArr4 != null) {
                                        break;
                                        break;
                                    }
                                    break;
                                    break;
                                    i5++;
                                }
                            }
                            async_contextVar = async_contextVarB;
                        } else {
                            bArr4 = wUserSigInfo._in_ksid;
                            if (bArr4 != null) {
                                bArr5 = oicq.wlogin_sdk.request.t.aa;
                            } else {
                                bArr5 = oicq.wlogin_sdk.request.t.aa;
                            }
                            bArr6 = bArr5;
                            if (async_contextVarB._tmp_pwd_type != 0) {
                                oicq.wlogin_sdk.request.l lVar9 = new oicq.wlogin_sdk.request.l(tVarA, this.mContext);
                                lVar9.g();
                                long j18 = async_contextVarB._appid;
                                long j19 = async_contextVarB._sub_appid;
                                async_contextVar = async_contextVarB;
                                iA2 = lVar9.a(j18, j19, tVarA.f, 0, oicq.wlogin_sdk.request.t.ad, async_contextVar._tmp_pwd, null, this.mMiscBitmap, this.mSubSigMap, async_contextVar._sub_appid_list, async_contextVar._main_sigmap, j19, oicq.wlogin_sdk.request.t.y, 0, 0, 1, bArr6, wUserSigInfo);
                            } else {
                                async_contextVar = async_contextVarB;
                                byte[] bArr12 = new byte[4];
                                oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr12, 0, (java.lang.System.currentTimeMillis() / 1000) + oicq.wlogin_sdk.request.t.ac);
                                if (async_contextVar._isSmslogin) {
                                    i2 = 3;
                                } else {
                                    i2 = 1;
                                }
                                oicq.wlogin_sdk.request.l lVar10 = new oicq.wlogin_sdk.request.l(tVarA, this.mContext);
                                lVar10.g();
                                long j110 = async_contextVar._appid;
                                long j111 = async_contextVar._sub_appid;
                                iA2 = lVar10.a(j110, j111, tVarA.f, 0, oicq.wlogin_sdk.request.t.ad, bArr12, async_contextVar._tmp_pwd, i2, this.mMiscBitmap, this.mSubSigMap, async_contextVar._sub_appid_list, async_contextVar._main_sigmap, j111, oicq.wlogin_sdk.request.t.y, 0, 0, 1, bArr6, wUserSigInfo);
                            }
                            if (iA2 == 204) {
                                iA3 = new oicq.wlogin_sdk.request.q(tVarA).a(this.mMiscBitmap, this.mSubSigMap, async_contextVar._sub_appid_list, wUserSigInfo);
                            } else {
                                iA3 = iA2;
                            }
                            if (iA3 != 0) {
                                jB3 = tVarA.b(str);
                                wUserSigInfo.uin = jB3 + "";
                                if (iA3 == 160) {
                                    i4 = iA3;
                                } else {
                                    wloginSigInfoA2 = tVarA.a(jB3, async_contextVar._appid);
                                    if (wloginSigInfoA2 == null) {
                                        i4 = oicq.wlogin_sdk.tools.util.E_NO_KEY;
                                    } else {
                                        wUserSigInfo.get_clone(wloginSigInfoA2);
                                        jArr = async_contextVar._sub_appid_list;
                                        if (jArr != null) {
                                            i3 = 0;
                                            while (true) {
                                                jArr2 = async_contextVar._sub_appid_list;
                                                if (jArr2 != null) {
                                                    break;
                                                    break;
                                                }
                                                break;
                                                break;
                                                i3++;
                                            }
                                        }
                                    }
                                }
                            } else {
                                jB3 = tVarA.b(str);
                                wUserSigInfo.uin = jB3 + "";
                                if (iA3 == 160) {
                                    i4 = iA3;
                                } else {
                                    wloginSigInfoA2 = tVarA.a(jB3, async_contextVar._appid);
                                    if (wloginSigInfoA2 == null) {
                                        i4 = oicq.wlogin_sdk.tools.util.E_NO_KEY;
                                    } else {
                                        wUserSigInfo.get_clone(wloginSigInfoA2);
                                        jArr = async_contextVar._sub_appid_list;
                                        if (jArr != null) {
                                            i3 = 0;
                                            while (true) {
                                                jArr2 = async_contextVar._sub_appid_list;
                                                if (jArr2 != null) {
                                                    break;
                                                    break;
                                                }
                                                break;
                                                break;
                                                i3++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i4 = 0;
                    }
                }
            } else {
                jB2 = java.lang.Long.parseLong(str);
            }
            z2 = true;
            if (async_contextVarB._msalt == 0) {
                tVarA.f = jB2;
                wUserSigInfo.uin = jB2 + "";
                if (iA == 160) {
                    i4 = iA;
                    async_contextVar = async_contextVarB;
                } else {
                    bArr3 = wUserSigInfo._reserveData;
                    if (bArr3 != null) {
                        tVarA.i = 0;
                    } else {
                        tVarA.i = 0;
                    }
                    wloginSigInfoA = tVarA.a(jB2, async_contextVarB._appid);
                    if (wloginSigInfoA != null) {
                        wUserSigInfo.get_clone(wloginSigInfoA);
                        jArr3 = async_contextVarB._sub_appid_list;
                        if (jArr3 != null) {
                            i5 = 0;
                            while (true) {
                                jArr4 = async_contextVarB._sub_appid_list;
                                if (jArr4 != null) {
                                    break;
                                    break;
                                }
                                break;
                                break;
                                i5++;
                            }
                        }
                        async_contextVar = async_contextVarB;
                    } else {
                        bArr4 = wUserSigInfo._in_ksid;
                        if (bArr4 != null) {
                            bArr5 = oicq.wlogin_sdk.request.t.aa;
                        } else {
                            bArr5 = oicq.wlogin_sdk.request.t.aa;
                        }
                        bArr6 = bArr5;
                        if (async_contextVarB._tmp_pwd_type != 0) {
                            oicq.wlogin_sdk.request.l lVar11 = new oicq.wlogin_sdk.request.l(tVarA, this.mContext);
                            lVar11.g();
                            long j112 = async_contextVarB._appid;
                            long j113 = async_contextVarB._sub_appid;
                            async_contextVar = async_contextVarB;
                            iA2 = lVar11.a(j112, j113, tVarA.f, 0, oicq.wlogin_sdk.request.t.ad, async_contextVar._tmp_pwd, null, this.mMiscBitmap, this.mSubSigMap, async_contextVar._sub_appid_list, async_contextVar._main_sigmap, j113, oicq.wlogin_sdk.request.t.y, 0, 0, 1, bArr6, wUserSigInfo);
                        } else {
                            async_contextVar = async_contextVarB;
                            byte[] bArr13 = new byte[4];
                            oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr13, 0, (java.lang.System.currentTimeMillis() / 1000) + oicq.wlogin_sdk.request.t.ac);
                            if (async_contextVar._isSmslogin) {
                                i2 = 3;
                            } else {
                                i2 = 1;
                            }
                            oicq.wlogin_sdk.request.l lVar12 = new oicq.wlogin_sdk.request.l(tVarA, this.mContext);
                            lVar12.g();
                            long j114 = async_contextVar._appid;
                            long j115 = async_contextVar._sub_appid;
                            iA2 = lVar12.a(j114, j115, tVarA.f, 0, oicq.wlogin_sdk.request.t.ad, bArr13, async_contextVar._tmp_pwd, i2, this.mMiscBitmap, this.mSubSigMap, async_contextVar._sub_appid_list, async_contextVar._main_sigmap, j115, oicq.wlogin_sdk.request.t.y, 0, 0, 1, bArr6, wUserSigInfo);
                        }
                        if (iA2 == 204) {
                            iA3 = new oicq.wlogin_sdk.request.q(tVarA).a(this.mMiscBitmap, this.mSubSigMap, async_contextVar._sub_appid_list, wUserSigInfo);
                        } else {
                            iA3 = iA2;
                        }
                        if (iA3 != 0) {
                            jB3 = tVarA.b(str);
                            wUserSigInfo.uin = jB3 + "";
                            if (iA3 == 160) {
                                i4 = iA3;
                            } else {
                                wloginSigInfoA2 = tVarA.a(jB3, async_contextVar._appid);
                                if (wloginSigInfoA2 == null) {
                                    i4 = oicq.wlogin_sdk.tools.util.E_NO_KEY;
                                } else {
                                    wUserSigInfo.get_clone(wloginSigInfoA2);
                                    jArr = async_contextVar._sub_appid_list;
                                    if (jArr != null) {
                                        i3 = 0;
                                        while (true) {
                                            jArr2 = async_contextVar._sub_appid_list;
                                            if (jArr2 != null) {
                                                break;
                                                break;
                                            }
                                            break;
                                            break;
                                            i3++;
                                        }
                                    }
                                }
                            }
                        } else {
                            jB3 = tVarA.b(str);
                            wUserSigInfo.uin = jB3 + "";
                            if (iA3 == 160) {
                                i4 = iA3;
                            } else {
                                wloginSigInfoA2 = tVarA.a(jB3, async_contextVar._appid);
                                if (wloginSigInfoA2 == null) {
                                    i4 = oicq.wlogin_sdk.tools.util.E_NO_KEY;
                                } else {
                                    wUserSigInfo.get_clone(wloginSigInfoA2);
                                    jArr = async_contextVar._sub_appid_list;
                                    if (jArr != null) {
                                        i3 = 0;
                                        while (true) {
                                            jArr2 = async_contextVar._sub_appid_list;
                                            if (jArr2 != null) {
                                                break;
                                                break;
                                            }
                                            break;
                                            break;
                                            i3++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    i4 = 0;
                }
            } else {
                tVarA.f = jB2;
                wUserSigInfo.uin = jB2 + "";
                if (iA == 160) {
                    i4 = iA;
                    async_contextVar = async_contextVarB;
                } else {
                    bArr3 = wUserSigInfo._reserveData;
                    if (bArr3 != null) {
                        tVarA.i = 0;
                    } else {
                        tVarA.i = 0;
                    }
                    wloginSigInfoA = tVarA.a(jB2, async_contextVarB._appid);
                    if (wloginSigInfoA != null) {
                        wUserSigInfo.get_clone(wloginSigInfoA);
                        jArr3 = async_contextVarB._sub_appid_list;
                        if (jArr3 != null) {
                            i5 = 0;
                            while (true) {
                                jArr4 = async_contextVarB._sub_appid_list;
                                if (jArr4 != null) {
                                    break;
                                    break;
                                }
                                break;
                                break;
                                i5++;
                            }
                        }
                        async_contextVar = async_contextVarB;
                    } else {
                        bArr4 = wUserSigInfo._in_ksid;
                        if (bArr4 != null) {
                            bArr5 = oicq.wlogin_sdk.request.t.aa;
                        } else {
                            bArr5 = oicq.wlogin_sdk.request.t.aa;
                        }
                        bArr6 = bArr5;
                        if (async_contextVarB._tmp_pwd_type != 0) {
                            oicq.wlogin_sdk.request.l lVar13 = new oicq.wlogin_sdk.request.l(tVarA, this.mContext);
                            lVar13.g();
                            long j116 = async_contextVarB._appid;
                            long j117 = async_contextVarB._sub_appid;
                            async_contextVar = async_contextVarB;
                            iA2 = lVar13.a(j116, j117, tVarA.f, 0, oicq.wlogin_sdk.request.t.ad, async_contextVar._tmp_pwd, null, this.mMiscBitmap, this.mSubSigMap, async_contextVar._sub_appid_list, async_contextVar._main_sigmap, j117, oicq.wlogin_sdk.request.t.y, 0, 0, 1, bArr6, wUserSigInfo);
                        } else {
                            async_contextVar = async_contextVarB;
                            byte[] bArr14 = new byte[4];
                            oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr14, 0, (java.lang.System.currentTimeMillis() / 1000) + oicq.wlogin_sdk.request.t.ac);
                            if (async_contextVar._isSmslogin) {
                                i2 = 3;
                            } else {
                                i2 = 1;
                            }
                            oicq.wlogin_sdk.request.l lVar14 = new oicq.wlogin_sdk.request.l(tVarA, this.mContext);
                            lVar14.g();
                            long j118 = async_contextVar._appid;
                            long j119 = async_contextVar._sub_appid;
                            iA2 = lVar14.a(j118, j119, tVarA.f, 0, oicq.wlogin_sdk.request.t.ad, bArr14, async_contextVar._tmp_pwd, i2, this.mMiscBitmap, this.mSubSigMap, async_contextVar._sub_appid_list, async_contextVar._main_sigmap, j119, oicq.wlogin_sdk.request.t.y, 0, 0, 1, bArr6, wUserSigInfo);
                        }
                        if (iA2 == 204) {
                            iA3 = new oicq.wlogin_sdk.request.q(tVarA).a(this.mMiscBitmap, this.mSubSigMap, async_contextVar._sub_appid_list, wUserSigInfo);
                        } else {
                            iA3 = iA2;
                        }
                        if (iA3 != 0) {
                            jB3 = tVarA.b(str);
                            wUserSigInfo.uin = jB3 + "";
                            if (iA3 == 160) {
                                i4 = iA3;
                            } else {
                                wloginSigInfoA2 = tVarA.a(jB3, async_contextVar._appid);
                                if (wloginSigInfoA2 == null) {
                                    i4 = oicq.wlogin_sdk.tools.util.E_NO_KEY;
                                } else {
                                    wUserSigInfo.get_clone(wloginSigInfoA2);
                                    jArr = async_contextVar._sub_appid_list;
                                    if (jArr != null) {
                                        i3 = 0;
                                        while (true) {
                                            jArr2 = async_contextVar._sub_appid_list;
                                            if (jArr2 != null) {
                                                break;
                                                break;
                                            }
                                            break;
                                            break;
                                            i3++;
                                        }
                                    }
                                }
                            }
                        } else {
                            jB3 = tVarA.b(str);
                            wUserSigInfo.uin = jB3 + "";
                            if (iA3 == 160) {
                                i4 = iA3;
                            } else {
                                wloginSigInfoA2 = tVarA.a(jB3, async_contextVar._appid);
                                if (wloginSigInfoA2 == null) {
                                    i4 = oicq.wlogin_sdk.tools.util.E_NO_KEY;
                                } else {
                                    wUserSigInfo.get_clone(wloginSigInfoA2);
                                    jArr = async_contextVar._sub_appid_list;
                                    if (jArr != null) {
                                        i3 = 0;
                                        while (true) {
                                            jArr2 = async_contextVar._sub_appid_list;
                                            if (jArr2 != null) {
                                                break;
                                                break;
                                            }
                                            break;
                                            break;
                                            i3++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    i4 = 0;
                }
            }
        } else {
            if (oicq.wlogin_sdk.tools.util.check_uin_account(str).booleanValue()) {
                jB2 = tVarA.b(str);
                if (jB2 != 0) {
                }
                if (async_contextVarB._msalt == 0) {
                    tVarA.f = jB2;
                    wUserSigInfo.uin = jB2 + "";
                    if (iA == 160) {
                        i4 = iA;
                        async_contextVar = async_contextVarB;
                    } else {
                        bArr3 = wUserSigInfo._reserveData;
                        if (bArr3 != null) {
                            tVarA.i = 0;
                        } else {
                            tVarA.i = 0;
                        }
                        wloginSigInfoA = tVarA.a(jB2, async_contextVarB._appid);
                        if (wloginSigInfoA != null) {
                            wUserSigInfo.get_clone(wloginSigInfoA);
                            jArr3 = async_contextVarB._sub_appid_list;
                            if (jArr3 != null) {
                                i5 = 0;
                                while (true) {
                                    jArr4 = async_contextVarB._sub_appid_list;
                                    if (jArr4 != null) {
                                        break;
                                        break;
                                    }
                                    break;
                                    break;
                                    i5++;
                                }
                            }
                            async_contextVar = async_contextVarB;
                        } else {
                            bArr4 = wUserSigInfo._in_ksid;
                            if (bArr4 != null) {
                                bArr5 = oicq.wlogin_sdk.request.t.aa;
                            } else {
                                bArr5 = oicq.wlogin_sdk.request.t.aa;
                            }
                            bArr6 = bArr5;
                            if (async_contextVarB._tmp_pwd_type != 0) {
                                oicq.wlogin_sdk.request.l lVar15 = new oicq.wlogin_sdk.request.l(tVarA, this.mContext);
                                lVar15.g();
                                long j1110 = async_contextVarB._appid;
                                long j1111 = async_contextVarB._sub_appid;
                                async_contextVar = async_contextVarB;
                                iA2 = lVar15.a(j1110, j1111, tVarA.f, 0, oicq.wlogin_sdk.request.t.ad, async_contextVar._tmp_pwd, null, this.mMiscBitmap, this.mSubSigMap, async_contextVar._sub_appid_list, async_contextVar._main_sigmap, j1111, oicq.wlogin_sdk.request.t.y, 0, 0, 1, bArr6, wUserSigInfo);
                            } else {
                                async_contextVar = async_contextVarB;
                                byte[] bArr15 = new byte[4];
                                oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr15, 0, (java.lang.System.currentTimeMillis() / 1000) + oicq.wlogin_sdk.request.t.ac);
                                if (async_contextVar._isSmslogin) {
                                    i2 = 3;
                                } else {
                                    i2 = 1;
                                }
                                oicq.wlogin_sdk.request.l lVar16 = new oicq.wlogin_sdk.request.l(tVarA, this.mContext);
                                lVar16.g();
                                long j1112 = async_contextVar._appid;
                                long j1113 = async_contextVar._sub_appid;
                                iA2 = lVar16.a(j1112, j1113, tVarA.f, 0, oicq.wlogin_sdk.request.t.ad, bArr15, async_contextVar._tmp_pwd, i2, this.mMiscBitmap, this.mSubSigMap, async_contextVar._sub_appid_list, async_contextVar._main_sigmap, j1113, oicq.wlogin_sdk.request.t.y, 0, 0, 1, bArr6, wUserSigInfo);
                            }
                            if (iA2 == 204) {
                                iA3 = new oicq.wlogin_sdk.request.q(tVarA).a(this.mMiscBitmap, this.mSubSigMap, async_contextVar._sub_appid_list, wUserSigInfo);
                            } else {
                                iA3 = iA2;
                            }
                            if (iA3 != 0) {
                                jB3 = tVarA.b(str);
                                wUserSigInfo.uin = jB3 + "";
                                if (iA3 == 160) {
                                    i4 = iA3;
                                } else {
                                    wloginSigInfoA2 = tVarA.a(jB3, async_contextVar._appid);
                                    if (wloginSigInfoA2 == null) {
                                        i4 = oicq.wlogin_sdk.tools.util.E_NO_KEY;
                                    } else {
                                        wUserSigInfo.get_clone(wloginSigInfoA2);
                                        jArr = async_contextVar._sub_appid_list;
                                        if (jArr != null) {
                                            i3 = 0;
                                            while (true) {
                                                jArr2 = async_contextVar._sub_appid_list;
                                                if (jArr2 != null) {
                                                    break;
                                                    break;
                                                }
                                                break;
                                                break;
                                                i3++;
                                            }
                                        }
                                    }
                                }
                            } else {
                                jB3 = tVarA.b(str);
                                wUserSigInfo.uin = jB3 + "";
                                if (iA3 == 160) {
                                    i4 = iA3;
                                } else {
                                    wloginSigInfoA2 = tVarA.a(jB3, async_contextVar._appid);
                                    if (wloginSigInfoA2 == null) {
                                        i4 = oicq.wlogin_sdk.tools.util.E_NO_KEY;
                                    } else {
                                        wUserSigInfo.get_clone(wloginSigInfoA2);
                                        jArr = async_contextVar._sub_appid_list;
                                        if (jArr != null) {
                                            i3 = 0;
                                            while (true) {
                                                jArr2 = async_contextVar._sub_appid_list;
                                                if (jArr2 != null) {
                                                    break;
                                                    break;
                                                }
                                                break;
                                                break;
                                                i3++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i4 = 0;
                    }
                } else {
                    tVarA.f = jB2;
                    wUserSigInfo.uin = jB2 + "";
                    if (iA == 160) {
                        i4 = iA;
                        async_contextVar = async_contextVarB;
                    } else {
                        bArr3 = wUserSigInfo._reserveData;
                        if (bArr3 != null) {
                            tVarA.i = 0;
                        } else {
                            tVarA.i = 0;
                        }
                        wloginSigInfoA = tVarA.a(jB2, async_contextVarB._appid);
                        if (wloginSigInfoA != null) {
                            wUserSigInfo.get_clone(wloginSigInfoA);
                            jArr3 = async_contextVarB._sub_appid_list;
                            if (jArr3 != null) {
                                i5 = 0;
                                while (true) {
                                    jArr4 = async_contextVarB._sub_appid_list;
                                    if (jArr4 != null) {
                                        break;
                                        break;
                                    }
                                    break;
                                    break;
                                    i5++;
                                }
                            }
                            async_contextVar = async_contextVarB;
                        } else {
                            bArr4 = wUserSigInfo._in_ksid;
                            if (bArr4 != null) {
                                bArr5 = oicq.wlogin_sdk.request.t.aa;
                            } else {
                                bArr5 = oicq.wlogin_sdk.request.t.aa;
                            }
                            bArr6 = bArr5;
                            if (async_contextVarB._tmp_pwd_type != 0) {
                                oicq.wlogin_sdk.request.l lVar17 = new oicq.wlogin_sdk.request.l(tVarA, this.mContext);
                                lVar17.g();
                                long j1114 = async_contextVarB._appid;
                                long j1115 = async_contextVarB._sub_appid;
                                async_contextVar = async_contextVarB;
                                iA2 = lVar17.a(j1114, j1115, tVarA.f, 0, oicq.wlogin_sdk.request.t.ad, async_contextVar._tmp_pwd, null, this.mMiscBitmap, this.mSubSigMap, async_contextVar._sub_appid_list, async_contextVar._main_sigmap, j1115, oicq.wlogin_sdk.request.t.y, 0, 0, 1, bArr6, wUserSigInfo);
                            } else {
                                async_contextVar = async_contextVarB;
                                byte[] bArr16 = new byte[4];
                                oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr16, 0, (java.lang.System.currentTimeMillis() / 1000) + oicq.wlogin_sdk.request.t.ac);
                                if (async_contextVar._isSmslogin) {
                                    i2 = 3;
                                } else {
                                    i2 = 1;
                                }
                                oicq.wlogin_sdk.request.l lVar18 = new oicq.wlogin_sdk.request.l(tVarA, this.mContext);
                                lVar18.g();
                                long j1116 = async_contextVar._appid;
                                long j1117 = async_contextVar._sub_appid;
                                iA2 = lVar18.a(j1116, j1117, tVarA.f, 0, oicq.wlogin_sdk.request.t.ad, bArr16, async_contextVar._tmp_pwd, i2, this.mMiscBitmap, this.mSubSigMap, async_contextVar._sub_appid_list, async_contextVar._main_sigmap, j1117, oicq.wlogin_sdk.request.t.y, 0, 0, 1, bArr6, wUserSigInfo);
                            }
                            if (iA2 == 204) {
                                iA3 = new oicq.wlogin_sdk.request.q(tVarA).a(this.mMiscBitmap, this.mSubSigMap, async_contextVar._sub_appid_list, wUserSigInfo);
                            } else {
                                iA3 = iA2;
                            }
                            if (iA3 != 0) {
                                jB3 = tVarA.b(str);
                                wUserSigInfo.uin = jB3 + "";
                                if (iA3 == 160) {
                                    i4 = iA3;
                                } else {
                                    wloginSigInfoA2 = tVarA.a(jB3, async_contextVar._appid);
                                    if (wloginSigInfoA2 == null) {
                                        i4 = oicq.wlogin_sdk.tools.util.E_NO_KEY;
                                    } else {
                                        wUserSigInfo.get_clone(wloginSigInfoA2);
                                        jArr = async_contextVar._sub_appid_list;
                                        if (jArr != null) {
                                            i3 = 0;
                                            while (true) {
                                                jArr2 = async_contextVar._sub_appid_list;
                                                if (jArr2 != null) {
                                                    break;
                                                    break;
                                                }
                                                break;
                                                break;
                                                i3++;
                                            }
                                        }
                                    }
                                }
                            } else {
                                jB3 = tVarA.b(str);
                                wUserSigInfo.uin = jB3 + "";
                                if (iA3 == 160) {
                                    i4 = iA3;
                                } else {
                                    wloginSigInfoA2 = tVarA.a(jB3, async_contextVar._appid);
                                    if (wloginSigInfoA2 == null) {
                                        i4 = oicq.wlogin_sdk.tools.util.E_NO_KEY;
                                    } else {
                                        wUserSigInfo.get_clone(wloginSigInfoA2);
                                        jArr = async_contextVar._sub_appid_list;
                                        if (jArr != null) {
                                            i3 = 0;
                                            while (true) {
                                                jArr2 = async_contextVar._sub_appid_list;
                                                if (jArr2 != null) {
                                                    break;
                                                    break;
                                                }
                                                break;
                                                break;
                                                i3++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i4 = 0;
                    }
                }
            } else {
                jB2 = java.lang.Long.parseLong(str);
            }
            z2 = true;
            if (async_contextVarB._msalt == 0) {
                tVarA.f = jB2;
                wUserSigInfo.uin = jB2 + "";
                if (iA == 160) {
                    i4 = iA;
                    async_contextVar = async_contextVarB;
                } else {
                    bArr3 = wUserSigInfo._reserveData;
                    if (bArr3 != null) {
                        tVarA.i = 0;
                    } else {
                        tVarA.i = 0;
                    }
                    wloginSigInfoA = tVarA.a(jB2, async_contextVarB._appid);
                    if (wloginSigInfoA != null) {
                        wUserSigInfo.get_clone(wloginSigInfoA);
                        jArr3 = async_contextVarB._sub_appid_list;
                        if (jArr3 != null) {
                            i5 = 0;
                            while (true) {
                                jArr4 = async_contextVarB._sub_appid_list;
                                if (jArr4 != null) {
                                    break;
                                    break;
                                }
                                break;
                                break;
                                i5++;
                            }
                        }
                        async_contextVar = async_contextVarB;
                    } else {
                        bArr4 = wUserSigInfo._in_ksid;
                        if (bArr4 != null) {
                            bArr5 = oicq.wlogin_sdk.request.t.aa;
                        } else {
                            bArr5 = oicq.wlogin_sdk.request.t.aa;
                        }
                        bArr6 = bArr5;
                        if (async_contextVarB._tmp_pwd_type != 0) {
                            oicq.wlogin_sdk.request.l lVar19 = new oicq.wlogin_sdk.request.l(tVarA, this.mContext);
                            lVar19.g();
                            long j1118 = async_contextVarB._appid;
                            long j1119 = async_contextVarB._sub_appid;
                            async_contextVar = async_contextVarB;
                            iA2 = lVar19.a(j1118, j1119, tVarA.f, 0, oicq.wlogin_sdk.request.t.ad, async_contextVar._tmp_pwd, null, this.mMiscBitmap, this.mSubSigMap, async_contextVar._sub_appid_list, async_contextVar._main_sigmap, j1119, oicq.wlogin_sdk.request.t.y, 0, 0, 1, bArr6, wUserSigInfo);
                        } else {
                            async_contextVar = async_contextVarB;
                            byte[] bArr17 = new byte[4];
                            oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr17, 0, (java.lang.System.currentTimeMillis() / 1000) + oicq.wlogin_sdk.request.t.ac);
                            if (async_contextVar._isSmslogin) {
                                i2 = 3;
                            } else {
                                i2 = 1;
                            }
                            oicq.wlogin_sdk.request.l lVar110 = new oicq.wlogin_sdk.request.l(tVarA, this.mContext);
                            lVar110.g();
                            long j11110 = async_contextVar._appid;
                            long j11111 = async_contextVar._sub_appid;
                            iA2 = lVar110.a(j11110, j11111, tVarA.f, 0, oicq.wlogin_sdk.request.t.ad, bArr17, async_contextVar._tmp_pwd, i2, this.mMiscBitmap, this.mSubSigMap, async_contextVar._sub_appid_list, async_contextVar._main_sigmap, j11111, oicq.wlogin_sdk.request.t.y, 0, 0, 1, bArr6, wUserSigInfo);
                        }
                        if (iA2 == 204) {
                            iA3 = new oicq.wlogin_sdk.request.q(tVarA).a(this.mMiscBitmap, this.mSubSigMap, async_contextVar._sub_appid_list, wUserSigInfo);
                        } else {
                            iA3 = iA2;
                        }
                        if (iA3 != 0) {
                            jB3 = tVarA.b(str);
                            wUserSigInfo.uin = jB3 + "";
                            if (iA3 == 160) {
                                i4 = iA3;
                            } else {
                                wloginSigInfoA2 = tVarA.a(jB3, async_contextVar._appid);
                                if (wloginSigInfoA2 == null) {
                                    i4 = oicq.wlogin_sdk.tools.util.E_NO_KEY;
                                } else {
                                    wUserSigInfo.get_clone(wloginSigInfoA2);
                                    jArr = async_contextVar._sub_appid_list;
                                    if (jArr != null) {
                                        i3 = 0;
                                        while (true) {
                                            jArr2 = async_contextVar._sub_appid_list;
                                            if (jArr2 != null) {
                                                break;
                                                break;
                                            }
                                            break;
                                            break;
                                            i3++;
                                        }
                                    }
                                }
                            }
                        } else {
                            jB3 = tVarA.b(str);
                            wUserSigInfo.uin = jB3 + "";
                            if (iA3 == 160) {
                                i4 = iA3;
                            } else {
                                wloginSigInfoA2 = tVarA.a(jB3, async_contextVar._appid);
                                if (wloginSigInfoA2 == null) {
                                    i4 = oicq.wlogin_sdk.tools.util.E_NO_KEY;
                                } else {
                                    wUserSigInfo.get_clone(wloginSigInfoA2);
                                    jArr = async_contextVar._sub_appid_list;
                                    if (jArr != null) {
                                        i3 = 0;
                                        while (true) {
                                            jArr2 = async_contextVar._sub_appid_list;
                                            if (jArr2 != null) {
                                                break;
                                                break;
                                            }
                                            break;
                                            break;
                                            i3++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    i4 = 0;
                }
            } else {
                tVarA.f = jB2;
                wUserSigInfo.uin = jB2 + "";
                if (iA == 160) {
                    i4 = iA;
                    async_contextVar = async_contextVarB;
                } else {
                    bArr3 = wUserSigInfo._reserveData;
                    if (bArr3 != null) {
                        tVarA.i = 0;
                    } else {
                        tVarA.i = 0;
                    }
                    wloginSigInfoA = tVarA.a(jB2, async_contextVarB._appid);
                    if (wloginSigInfoA != null) {
                        wUserSigInfo.get_clone(wloginSigInfoA);
                        jArr3 = async_contextVarB._sub_appid_list;
                        if (jArr3 != null) {
                            i5 = 0;
                            while (true) {
                                jArr4 = async_contextVarB._sub_appid_list;
                                if (jArr4 != null) {
                                    break;
                                    break;
                                }
                                break;
                                break;
                                i5++;
                            }
                        }
                        async_contextVar = async_contextVarB;
                    } else {
                        bArr4 = wUserSigInfo._in_ksid;
                        if (bArr4 != null) {
                            bArr5 = oicq.wlogin_sdk.request.t.aa;
                        } else {
                            bArr5 = oicq.wlogin_sdk.request.t.aa;
                        }
                        bArr6 = bArr5;
                        if (async_contextVarB._tmp_pwd_type != 0) {
                            oicq.wlogin_sdk.request.l lVar111 = new oicq.wlogin_sdk.request.l(tVarA, this.mContext);
                            lVar111.g();
                            long j11112 = async_contextVarB._appid;
                            long j11113 = async_contextVarB._sub_appid;
                            async_contextVar = async_contextVarB;
                            iA2 = lVar111.a(j11112, j11113, tVarA.f, 0, oicq.wlogin_sdk.request.t.ad, async_contextVar._tmp_pwd, null, this.mMiscBitmap, this.mSubSigMap, async_contextVar._sub_appid_list, async_contextVar._main_sigmap, j11113, oicq.wlogin_sdk.request.t.y, 0, 0, 1, bArr6, wUserSigInfo);
                        } else {
                            async_contextVar = async_contextVarB;
                            byte[] bArr18 = new byte[4];
                            oicq.wlogin_sdk.tools.util.int64_to_buf32(bArr18, 0, (java.lang.System.currentTimeMillis() / 1000) + oicq.wlogin_sdk.request.t.ac);
                            if (async_contextVar._isSmslogin) {
                                i2 = 3;
                            } else {
                                i2 = 1;
                            }
                            oicq.wlogin_sdk.request.l lVar112 = new oicq.wlogin_sdk.request.l(tVarA, this.mContext);
                            lVar112.g();
                            long j11114 = async_contextVar._appid;
                            long j11115 = async_contextVar._sub_appid;
                            iA2 = lVar112.a(j11114, j11115, tVarA.f, 0, oicq.wlogin_sdk.request.t.ad, bArr18, async_contextVar._tmp_pwd, i2, this.mMiscBitmap, this.mSubSigMap, async_contextVar._sub_appid_list, async_contextVar._main_sigmap, j11115, oicq.wlogin_sdk.request.t.y, 0, 0, 1, bArr6, wUserSigInfo);
                        }
                        if (iA2 == 204) {
                            iA3 = new oicq.wlogin_sdk.request.q(tVarA).a(this.mMiscBitmap, this.mSubSigMap, async_contextVar._sub_appid_list, wUserSigInfo);
                        } else {
                            iA3 = iA2;
                        }
                        if (iA3 != 0) {
                            jB3 = tVarA.b(str);
                            wUserSigInfo.uin = jB3 + "";
                            if (iA3 == 160) {
                                i4 = iA3;
                            } else {
                                wloginSigInfoA2 = tVarA.a(jB3, async_contextVar._appid);
                                if (wloginSigInfoA2 == null) {
                                    i4 = oicq.wlogin_sdk.tools.util.E_NO_KEY;
                                } else {
                                    wUserSigInfo.get_clone(wloginSigInfoA2);
                                    jArr = async_contextVar._sub_appid_list;
                                    if (jArr != null) {
                                        i3 = 0;
                                        while (true) {
                                            jArr2 = async_contextVar._sub_appid_list;
                                            if (jArr2 != null) {
                                                break;
                                                break;
                                            }
                                            break;
                                            break;
                                            i3++;
                                        }
                                    }
                                }
                            }
                        } else {
                            jB3 = tVarA.b(str);
                            wUserSigInfo.uin = jB3 + "";
                            if (iA3 == 160) {
                                i4 = iA3;
                            } else {
                                wloginSigInfoA2 = tVarA.a(jB3, async_contextVar._appid);
                                if (wloginSigInfoA2 == null) {
                                    i4 = oicq.wlogin_sdk.tools.util.E_NO_KEY;
                                } else {
                                    wUserSigInfo.get_clone(wloginSigInfoA2);
                                    jArr = async_contextVar._sub_appid_list;
                                    if (jArr != null) {
                                        i3 = 0;
                                        while (true) {
                                            jArr2 = async_contextVar._sub_appid_list;
                                            if (jArr2 != null) {
                                                break;
                                                break;
                                            }
                                            break;
                                            break;
                                            i3++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    i4 = 0;
                }
            }
        }
        ticketGetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo, 128);
        if (ticketGetUserSigInfoTicket == null) {
            ticketGetUserSigInfoTicket = new oicq.wlogin_sdk.request.Ticket();
        }
        ticket = ticketGetUserSigInfoTicket;
        oicq.wlogin_sdk.request.t.an.commit_t2(tVarA.f, tVarA.g, oicq.wlogin_sdk.tools.util.format_ret_code(i4), i4);
        if (i4 == 0) {
            bArr7 = ticket._sig;
            if (bArr7 == null) {
            }
        } else {
            async_contextVar = async_contextVar;
            ticket = ticket;
            i4 = i4;
            RequestReportError(0, ticket._sig, ticket._sig_key, tVarA.f, async_contextVar._appid, 0);
        }
        tlv_t150Var = tVarA.d;
        if (tlv_t150Var != null) {
            this.mG.d = tVarA.d;
            RequestReportError(0, ticket._sig, ticket._sig_key, tVarA.f, async_contextVar._appid, 1);
        }
        oicq.wlogin_sdk.request.t.b();
        tVarA.h();
        oicq.wlogin_sdk.tools.util.LOGI("user:" + str + " CheckPictureAndGetSt Seq:" + tVarA.h + " ret=" + i4, "" + tVarA.f);
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:48:0x0150  */
    /* JADX WARN: Code duplicated, block: B:51:0x0166  */
    /* JADX WARN: Code duplicated, block: B:56:0x0179  */
    public int CheckSMSAndGetSt(java.lang.String str, byte[] bArr, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo, byte[][] bArr2, int i) {
        long jB;
        int i2;
        oicq.wlogin_sdk.request.Ticket ticketGetUserSigInfoTicket;
        oicq.wlogin_sdk.request.Ticket ticket;
        oicq.wlogin_sdk.tlv_type.tlv_t150 tlv_t150Var;
        byte[] bArr3;
        if (str == null || bArr == null || wUserSigInfo == null) {
            return oicq.wlogin_sdk.tools.util.E_INPUT;
        }
        if (i == 0) {
            new oicq.wlogin_sdk.request.WtloginHelper.HelperThread(this, this.mHelperHandler, str, bArr, wUserSigInfo, bArr2, "CheckSMSAndGetSt").RunReq(4);
            return oicq.wlogin_sdk.tools.util.E_PENDING;
        }
        if (wUserSigInfo._seqence == 0) {
            wUserSigInfo._seqence = this.mAysncSeq;
        }
        oicq.wlogin_sdk.request.t tVarA = this.mG.a(wUserSigInfo._seqence);
        long j = tVarA.h;
        wUserSigInfo._seqence = j;
        oicq.wlogin_sdk.request.async_context async_contextVarB = oicq.wlogin_sdk.request.t.b(j);
        oicq.wlogin_sdk.tools.util.LOGI("user:" + str + " CheckSMSAndGetSt Seq:" + tVarA.h + " ...", str);
        tVarA.g = str;
        tVarA.f = 0L;
        async_contextVarB._last_err_msg = new oicq.wlogin_sdk.tools.ErrMsg();
        byte[] bArr4 = wUserSigInfo._reserveData;
        if (bArr4 == null || bArr4.length <= 3) {
            tVarA.i = 0;
        } else {
            tVarA.i = oicq.wlogin_sdk.tools.util.buf_to_int32(bArr4, 0);
            oicq.wlogin_sdk.tools.util.LOGI("MSF SSO SEQ:" + tVarA.i, str);
        }
        if (!oicq.wlogin_sdk.tools.util.check_uin_account(str).booleanValue()) {
            jB = tVarA.b(str);
            if (jB == 0) {
                oicq.wlogin_sdk.tools.util.LOGI("user:" + str + " have not found uin record.", str);
                i2 = oicq.wlogin_sdk.tools.util.E_NO_UIN;
            }
            ticketGetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo, 128);
            if (ticketGetUserSigInfoTicket == null) {
                ticketGetUserSigInfoTicket = new oicq.wlogin_sdk.request.Ticket();
            }
            ticket = ticketGetUserSigInfoTicket;
            oicq.wlogin_sdk.request.t.an.commit_t2(tVarA.f, tVarA.g, oicq.wlogin_sdk.tools.util.format_ret_code(i2), i2);
            if (i2 == 0) {
                bArr3 = ticket._sig;
                if (bArr3 != null && bArr3.length != 0) {
                    RequestReport(0, bArr3, ticket._sig_key, tVarA.f, async_contextVarB._appid);
                }
            } else {
                RequestReportError(0, ticket._sig, ticket._sig_key, tVarA.f, async_contextVarB._appid, 0);
            }
            tlv_t150Var = tVarA.d;
            if (tlv_t150Var != null && tlv_t150Var.get_bitmap() != 0) {
                this.mG.d = tVarA.d;
                RequestReportError(0, ticket._sig, ticket._sig_key, tVarA.f, async_contextVarB._appid, 1);
            }
            oicq.wlogin_sdk.request.t.b();
            tVarA.h();
            oicq.wlogin_sdk.tools.util.LOGI("user:" + str + " CheckSMSAndGetSt Seq:" + tVarA.h + " ret=" + i2, "" + tVarA.f);
            return i2;
        }
        jB = java.lang.Long.parseLong(str);
        long j2 = jB;
        tVarA.f = j2;
        wUserSigInfo.uin = j2 + "";
        int iA = new oicq.wlogin_sdk.request.p(tVarA).a(bArr, this.mMiscBitmap, this.mSubSigMap, async_contextVarB._sub_appid_list, wUserSigInfo);
        if (iA != 0) {
            i2 = iA;
        } else {
            oicq.wlogin_sdk.sharemem.WloginSigInfo wloginSigInfoA = tVarA.a(j2, async_contextVarB._appid);
            if (wloginSigInfoA == null) {
                i2 = oicq.wlogin_sdk.tools.util.E_NO_KEY;
            } else {
                wUserSigInfo.get_clone(wloginSigInfoA);
                long[] jArr = async_contextVarB._sub_appid_list;
                if (jArr != null && bArr2 != null && jArr.length * 2 == bArr2.length) {
                    int i3 = 0;
                    while (true) {
                        long[] jArr2 = async_contextVarB._sub_appid_list;
                        if (jArr2 == null || i3 >= jArr2.length) {
                            break;
                        }
                        oicq.wlogin_sdk.sharemem.WloginSigInfo wloginSigInfoA2 = tVarA.a(j2, jArr2[i3]);
                        if (wloginSigInfoA2 != null) {
                            int i4 = i3 * 2;
                            bArr2[i4] = (byte[]) wloginSigInfoA2._userSt_Key.clone();
                            bArr2[i4 + 1] = (byte[]) wloginSigInfoA2._userStSig.clone();
                        }
                        i3++;
                    }
                }
                i2 = 0;
            }
        }
        ticketGetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo, 128);
        if (ticketGetUserSigInfoTicket == null) {
            ticketGetUserSigInfoTicket = new oicq.wlogin_sdk.request.Ticket();
        }
        ticket = ticketGetUserSigInfoTicket;
        oicq.wlogin_sdk.request.t.an.commit_t2(tVarA.f, tVarA.g, oicq.wlogin_sdk.tools.util.format_ret_code(i2), i2);
        if (i2 == 0) {
            bArr3 = ticket._sig;
            if (bArr3 != null) {
                RequestReport(0, bArr3, ticket._sig_key, tVarA.f, async_contextVarB._appid);
            }
        } else {
            RequestReportError(0, ticket._sig, ticket._sig_key, tVarA.f, async_contextVarB._appid, 0);
        }
        tlv_t150Var = tVarA.d;
        if (tlv_t150Var != null) {
            this.mG.d = tVarA.d;
            RequestReportError(0, ticket._sig, ticket._sig_key, tVarA.f, async_contextVarB._appid, 1);
        }
        oicq.wlogin_sdk.request.t.b();
        tVarA.h();
        oicq.wlogin_sdk.tools.util.LOGI("user:" + str + " CheckSMSAndGetSt Seq:" + tVarA.h + " ret=" + i2, "" + tVarA.f);
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int CheckSMSVerifyLoginAccount(long j, long j2, java.lang.String str, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo, int i) {
        oicq.wlogin_sdk.a.h.x = false;
        oicq.wlogin_sdk.a.h.y = 0L;
        if (str == null || wUserSigInfo == null) {
            return oicq.wlogin_sdk.tools.util.E_INPUT;
        }
        if (i == 0) {
            new oicq.wlogin_sdk.request.WtloginHelper.HelperThread(this, this.mHelperHandler, j, j2, str, wUserSigInfo, "CheckSMSVerifyLoginAccount").RunReq(12);
            return oicq.wlogin_sdk.tools.util.E_PENDING;
        }
        oicq.wlogin_sdk.request.t tVarA = this.mG.a(0L);
        long j3 = tVarA.h;
        wUserSigInfo._seqence = j3;
        this.mAysncSeq = j3;
        oicq.wlogin_sdk.request.async_context async_contextVarB = oicq.wlogin_sdk.request.t.b(j3);
        tVarA.g = str;
        oicq.wlogin_sdk.tools.util.LOGI("user:" + str + " Seq:" + tVarA.h + " CheckSMSVerifyLoginAccount ...", str);
        async_contextVarB._login_bitmap = wUserSigInfo._login_bitmap;
        async_contextVarB._last_err_msg = new oicq.wlogin_sdk.tools.ErrMsg();
        int iA = new oicq.wlogin_sdk.request.v(tVarA).a(j, j2, this.mMainSigMap, oicq.wlogin_sdk.request.t.aa, str, this.mMiscBitmap, this.mSubSigMap, (long[]) null, wUserSigInfo);
        int i2 = iA != 208 ? iA : 0;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("user:");
        sb.append(tVarA.g);
        sb.append(" Seq:");
        sb.append(tVarA.h);
        sb.append(" CheckSMSVerifyLoginAccount ret=");
        sb.append(i2 > 0 ? java.lang.Integer.toHexString(i2) : java.lang.Integer.valueOf(i2));
        oicq.wlogin_sdk.tools.util.LOGI(sb.toString(), str);
        return i2;
    }

    private oicq.wlogin_sdk.sharemem.WloginSigInfo FindUserSig(long j, long j2) {
        return this.mG.a(j, j2);
    }

    private byte[] GetA1ByAccount(java.lang.String str, long j) {
        long jB;
        oicq.wlogin_sdk.sharemem.WloginSigInfo wloginSigInfoA;
        byte[] bArr;
        if (str == null) {
            return null;
        }
        if (!oicq.wlogin_sdk.tools.util.check_uin_account(str).booleanValue()) {
            jB = this.mG.b(str);
            if (jB == 0) {
                wloginSigInfoA = null;
            }
            if (wloginSigInfoA != null || (bArr = wloginSigInfoA._en_A1) == null || bArr.length <= 0) {
                oicq.wlogin_sdk.tools.util.LOGI("userAccount:" + str + " dwAppid:" + j + " GetA1ByAccount return: null", str);
                return null;
            }
            oicq.wlogin_sdk.tools.util.LOGI("userAccount:" + str + " dwAppid:" + j + " GetA1ByAccount return: not null", str);
            return (byte[]) wloginSigInfoA._en_A1.clone();
        }
        jB = java.lang.Long.parseLong(str);
        wloginSigInfoA = this.mG.a(jB, j);
        if (wloginSigInfoA != null) {
        }
        oicq.wlogin_sdk.tools.util.LOGI("userAccount:" + str + " dwAppid:" + j + " GetA1ByAccount return: null", str);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:38:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:41:0x020e  */
    /* JADX WARN: Code duplicated, block: B:46:0x022c  */
    /* JADX WARN: Code duplicated, block: B:48:0x0234  */
    public int GetA1WithA1(java.lang.String str, long j, long j2, int i, byte[] bArr, long j3, long j4, long j5, byte[] bArr2, byte[] bArr3, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo, oicq.wlogin_sdk.request.WFastLoginInfo wFastLoginInfo, int i2) {
        long jB;
        int iA;
        oicq.wlogin_sdk.request.Ticket ticketGetUserSigInfoTicket;
        oicq.wlogin_sdk.request.Ticket ticket;
        int i3;
        oicq.wlogin_sdk.tlv_type.tlv_t150 tlv_t150Var;
        byte[] bArr4;
        long j6 = j;
        if (str == null || bArr == null || bArr2 == null || bArr3 == null || wUserSigInfo == null || wFastLoginInfo == null) {
            return oicq.wlogin_sdk.tools.util.E_INPUT;
        }
        int i4 = i | 192;
        if (i2 == 0) {
            new oicq.wlogin_sdk.request.WtloginHelper.HelperThread(this, this.mHelperHandler, str, j, j2, i4, bArr, j3, j4, j5, bArr2, bArr3, wUserSigInfo, wFastLoginInfo, "GetA1WithA1").RunReq(6);
            return oicq.wlogin_sdk.tools.util.E_PENDING;
        }
        int i5 = i4;
        oicq.wlogin_sdk.request.t tVarA = this.mG.a(0L);
        long j7 = tVarA.h;
        wUserSigInfo._seqence = j7;
        oicq.wlogin_sdk.request.async_context async_contextVarB = oicq.wlogin_sdk.request.t.b(j7);
        oicq.wlogin_sdk.tools.util.LOGI("wtlogin login with GetA1WithA1:" + str + " dwSrcAppid:" + j6 + " dwMainSigMap:" + i5 + " dwSubSrcAppid:" + j2 + " dstAppName:" + new java.lang.String(bArr) + " dwDstAppid:" + j4 + " dwSubDstAppid:" + j5 + " Seq:" + tVarA.h + " ...", str);
        int i6 = oicq.wlogin_sdk.tools.util.get_saved_network_type(this.mContext);
        int i7 = oicq.wlogin_sdk.tools.util.get_network_type(this.mContext);
        oicq.wlogin_sdk.request.t.D = i7;
        if (i6 != i7) {
            oicq.wlogin_sdk.tools.util.set_net_retry_type(this.mContext, 0);
            oicq.wlogin_sdk.tools.util.save_network_type(this.mContext, oicq.wlogin_sdk.request.t.D);
        }
        oicq.wlogin_sdk.request.t.F = oicq.wlogin_sdk.tools.util.get_apn_string(this.mContext).getBytes();
        tVarA.g = str;
        tVarA.f = 0L;
        async_contextVarB._sappid = j6;
        async_contextVarB._appid = j6;
        async_contextVarB._sub_appid = j2;
        async_contextVarB._main_sigmap = i5;
        async_contextVarB._last_err_msg = new oicq.wlogin_sdk.tools.ErrMsg();
        oicq.wlogin_sdk.request.t.an.add_t2(new oicq.wlogin_sdk.report.report_t2("login", new java.lang.String(oicq.wlogin_sdk.request.t.C), java.lang.System.currentTimeMillis(), j4, j5, null));
        if (!oicq.wlogin_sdk.tools.util.check_uin_account(str).booleanValue()) {
            jB = tVarA.b(str);
            if (jB == 0) {
                oicq.wlogin_sdk.tools.util.LOGI("user:" + str + " have not found uin record.", str);
                iA = oicq.wlogin_sdk.tools.util.E_NO_UIN;
            }
            ticketGetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo, 128);
            if (ticketGetUserSigInfoTicket == null) {
                ticketGetUserSigInfoTicket = new oicq.wlogin_sdk.request.Ticket();
            }
            ticket = ticketGetUserSigInfoTicket;
            oicq.wlogin_sdk.request.t.an.commit_t2(tVarA.f, tVarA.g, oicq.wlogin_sdk.tools.util.format_ret_code(iA), iA);
            if (iA == 0) {
                bArr4 = ticket._sig;
                if (bArr4 != null || bArr4.length == 0) {
                    i3 = iA;
                } else {
                    RequestReport(0, bArr4, ticket._sig_key, tVarA.f, j);
                    i3 = iA;
                }
            } else {
                ticket = ticket;
                i5 = i5;
                tVarA = tVarA;
                j6 = j6;
                i3 = iA;
                RequestReportError(0, ticket._sig, ticket._sig_key, tVarA.f, j, 0);
            }
            tlv_t150Var = tVarA.d;
            if (tlv_t150Var != null && tlv_t150Var.get_bitmap() != 0) {
                this.mG.d = tVarA.d;
                RequestReportError(0, ticket._sig, ticket._sig_key, tVarA.f, j, 1);
            }
            oicq.wlogin_sdk.request.t.b();
            tVarA.h();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("wtlogin login with GetA1WithA1:");
            sb.append(str);
            sb.append(" dwSrcAppid:");
            sb.append(j6);
            sb.append(" dwMainSigMap:");
            sb.append(i5);
            sb.append(" dwSubSrcAppid:");
            sb.append(j2);
            sb.append(" dstAppName:");
            sb.append(new java.lang.String(bArr));
            sb.append(" dwDstAppid:");
            sb.append(j4);
            sb.append(" dwSubDstAppid:");
            sb.append(j5);
            sb.append(" Seq:");
            sb.append(tVarA.h);
            sb.append(" ret=");
            int i8 = i3;
            sb.append(i8);
            oicq.wlogin_sdk.tools.util.LOGI(sb.toString(), str);
            return i8;
        }
        jB = java.lang.Long.parseLong(str);
        tVarA.f = jB;
        tVarA.j();
        byte[] bArrGetA1ByAccount = GetA1ByAccount(str, j);
        byte[] bArrGetNoPicSigByAccount = GetNoPicSigByAccount(str, j);
        if (bArrGetA1ByAccount == null || bArrGetA1ByAccount.length <= 0) {
            oicq.wlogin_sdk.tools.util.LOGI("user:" + str + " have no a1 or pic_sig.", str);
            iA = oicq.wlogin_sdk.tools.util.E_A1_FORMAT;
        } else {
            oicq.wlogin_sdk.tools.util.LOGI("user:" + str + " login with A1 exchange A1.", str);
            iA = new oicq.wlogin_sdk.request.m(tVarA).a(jB, j, j2, 1, i5, bArrGetA1ByAccount, bArrGetNoPicSigByAccount, this.mMiscBitmap, this.mSubSigMap, (long[]) null, bArr, j3, j4, j5, bArr2, bArr3, wUserSigInfo);
            if (iA == 0) {
                oicq.wlogin_sdk.sharemem.WloginSigInfo wloginSigInfoA = tVarA.a(jB, j6);
                if (wloginSigInfoA == null) {
                    iA = oicq.wlogin_sdk.tools.util.E_NO_KEY;
                } else {
                    wUserSigInfo.get_clone(wloginSigInfoA);
                    wFastLoginInfo.get_clone(tVarA.j);
                }
            }
        }
        ticketGetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo, 128);
        if (ticketGetUserSigInfoTicket == null) {
            ticketGetUserSigInfoTicket = new oicq.wlogin_sdk.request.Ticket();
        }
        ticket = ticketGetUserSigInfoTicket;
        oicq.wlogin_sdk.request.t.an.commit_t2(tVarA.f, tVarA.g, oicq.wlogin_sdk.tools.util.format_ret_code(iA), iA);
        if (iA == 0) {
            bArr4 = ticket._sig;
            if (bArr4 != null) {
                i3 = iA;
            } else {
                i3 = iA;
            }
        } else {
            ticket = ticket;
            i5 = i5;
            tVarA = tVarA;
            j6 = j6;
            i3 = iA;
            RequestReportError(0, ticket._sig, ticket._sig_key, tVarA.f, j, 0);
        }
        tlv_t150Var = tVarA.d;
        if (tlv_t150Var != null) {
            this.mG.d = tVarA.d;
            RequestReportError(0, ticket._sig, ticket._sig_key, tVarA.f, j, 1);
        }
        oicq.wlogin_sdk.request.t.b();
        tVarA.h();
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append("wtlogin login with GetA1WithA1:");
        sb2.append(str);
        sb2.append(" dwSrcAppid:");
        sb2.append(j6);
        sb2.append(" dwMainSigMap:");
        sb2.append(i5);
        sb2.append(" dwSubSrcAppid:");
        sb2.append(j2);
        sb2.append(" dstAppName:");
        sb2.append(new java.lang.String(bArr));
        sb2.append(" dwDstAppid:");
        sb2.append(j4);
        sb2.append(" dwSubDstAppid:");
        sb2.append(j5);
        sb2.append(" Seq:");
        sb2.append(tVarA.h);
        sb2.append(" ret=");
        int i9 = i3;
        sb2.append(i9);
        oicq.wlogin_sdk.tools.util.LOGI(sb2.toString(), str);
        return i9;
    }

    private int GetFastLoginInfo(byte[] bArr, oicq.wlogin_sdk.request.async_context async_contextVar) throws java.lang.Throwable {
        java.lang.String str;
        if (bArr == null || bArr.length <= 3 || async_contextVar == null) {
            return oicq.wlogin_sdk.tools.util.E_INPUT;
        }
        oicq.wlogin_sdk.tlv_type.tlv_t106 tlv_t106Var = new oicq.wlogin_sdk.tlv_type.tlv_t106();
        oicq.wlogin_sdk.tlv_type.tlv_t10c tlv_t10cVar = new oicq.wlogin_sdk.tlv_type.tlv_t10c();
        oicq.wlogin_sdk.tlv_type.tlv_t16a tlv_t16aVar = new oicq.wlogin_sdk.tlv_type.tlv_t16a();
        oicq.wlogin_sdk.tlv_type.tlv_t145 tlv_t145Var = new oicq.wlogin_sdk.tlv_type.tlv_t145();
        int length = bArr.length;
        if (tlv_t106Var.get_tlv(bArr, 3, length) < 0) {
            str = "fast login info no tgtgt data";
        } else if (tlv_t10cVar.get_tlv(bArr, 3, length) < 0) {
            str = "fast login info no gtkey data";
        } else {
            if (tlv_t16aVar.get_tlv(bArr, 3, length) >= 0) {
                if (tlv_t145Var.get_tlv(bArr, 3, length) > 0) {
                    byte[] bArr2 = tlv_t145Var.get_data();
                    byte[] bArr3 = oicq.wlogin_sdk.request.t.A;
                    oicq.wlogin_sdk.tools.util.LOGD("new guid:" + oicq.wlogin_sdk.tools.util.buf_to_string(bArr2) + " old guid:" + oicq.wlogin_sdk.tools.util.buf_to_string(bArr3));
                    if (!java.util.Arrays.equals(bArr2, bArr3)) {
                        oicq.wlogin_sdk.tools.util.LOGI("fast login info guid not equal", "");
                        oicq.wlogin_sdk.tools.util.saveGuidToFile(oicq.wlogin_sdk.request.t.t, bArr2);
                        oicq.wlogin_sdk.request.t.A = (byte[]) bArr2.clone();
                        oicq.wlogin_sdk.request.t.B = (byte[]) bArr2.clone();
                    }
                }
                async_contextVar._tmp_pwd = oicq.wlogin_sdk.request.oicq_request.b(tlv_t106Var.get_data(), tlv_t10cVar.get_data());
                async_contextVar._tmp_no_pic_sig = tlv_t16aVar.get_data();
                return 0;
            }
            str = "fast login info no nopicsig data";
        }
        oicq.wlogin_sdk.tools.util.LOGI(str, "");
        return oicq.wlogin_sdk.tools.util.E_INPUT;
    }

    public static oicq.wlogin_sdk.request.WFastLoginInfo GetFastLoginUrl(java.lang.String str, long j) {
        java.lang.StringBuilder sb;
        java.lang.String str2;
        if (str != null) {
            try {
                if (str.length() != 0) {
                    oicq.wlogin_sdk.tools.util.LOGI("packageName:" + str + " uin:" + j, "");
                    if (j == 1689053018) {
                        sb = new java.lang.StringBuilder();
                        sb.append("http://imgcache.qq.com/wtlogin");
                        str2 = "/test";
                    } else {
                        sb = new java.lang.StringBuilder();
                        sb.append("http://imgcache.qq.com/wtlogin");
                        str2 = "/app";
                    }
                    sb.append(str2);
                    java.lang.String string = sb.toString();
                    for (java.lang.String str3 : str.split("\\.")) {
                        string = (string + "/") + str3;
                    }
                    oicq.wlogin_sdk.request.WFastLoginInfo wFastLoginInfo = new oicq.wlogin_sdk.request.WFastLoginInfo();
                    wFastLoginInfo.iconUrl = string + "/icon.png";
                    wFastLoginInfo.adUrl = string + "/ad_img.png";
                    wFastLoginInfo.profileUrl = string + "/profile.js";
                    return wFastLoginInfo;
                }
            } catch (java.lang.Exception unused) {
            }
        }
        return null;
    }

    private byte[] GetNoPicSigByAccount(java.lang.String str, long j) {
        long jB;
        oicq.wlogin_sdk.sharemem.WloginSigInfo wloginSigInfoA;
        byte[] bArr;
        if (str == null) {
            return null;
        }
        if (!oicq.wlogin_sdk.tools.util.check_uin_account(str).booleanValue()) {
            jB = this.mG.b(str);
            if (jB == 0) {
                wloginSigInfoA = null;
            }
            if (wloginSigInfoA != null || (bArr = wloginSigInfoA._noPicSig) == null || bArr.length <= 0) {
                oicq.wlogin_sdk.tools.util.LOGI("userAccount:" + str + " dwAppid:" + j + " GetNoPicSigByAccount return: null", str);
                return null;
            }
            oicq.wlogin_sdk.tools.util.LOGI("userAccount:" + str + " dwAppid:" + j + " GetNoPicSigByAccount return: not null", str);
            return (byte[]) wloginSigInfoA._noPicSig.clone();
        }
        jB = java.lang.Long.parseLong(str);
        wloginSigInfoA = this.mG.a(jB, j);
        if (wloginSigInfoA != null) {
        }
        oicq.wlogin_sdk.tools.util.LOGI("userAccount:" + str + " dwAppid:" + j + " GetNoPicSigByAccount return: null", str);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int GetStWithPasswd(java.lang.String str, long j, int i, long j2, long[] jArr, boolean z, java.lang.String str2, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo, byte[][] bArr, boolean z2, int i2) {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:109:0x042f  */
    /* JADX WARN: Code duplicated, block: B:112:0x0438  */
    /* JADX WARN: Code duplicated, block: B:114:0x043d  */
    /* JADX WARN: Code duplicated, block: B:121:0x044c  */
    /* JADX WARN: Code duplicated, block: B:123:0x0454  */
    /* JADX WARN: Code duplicated, block: B:124:0x046d  */
    /* JADX WARN: Code duplicated, block: B:126:0x0471  */
    /* JADX WARN: Code duplicated, block: B:128:0x0475 A[PHI: r3
  0x0475: PHI (r3v8 oicq.wlogin_sdk.request.async_context) = (r3v6 oicq.wlogin_sdk.request.async_context), (r3v9 oicq.wlogin_sdk.request.async_context) binds: [B:77:0x02be, B:110:0x0435] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:131:0x047f  */
    /* JADX WARN: Code duplicated, block: B:134:0x049e  */
    /* JADX WARN: Code duplicated, block: B:139:0x04c3  */
    /* JADX WARN: Code duplicated, block: B:141:0x04ce  */
    public int GetStWithoutPasswd(java.lang.String str, long j, long j2, long j3, int i, long j4, long[] jArr, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo, byte[][] bArr, byte[][] bArr2, int i2, oicq.wlogin_sdk.request.WtTicketPromise wtTicketPromise) {
        long jB;
        long j5;
        oicq.wlogin_sdk.request.async_context async_contextVar;
        byte[] bArr3;
        long j6;
        long[] jArr2;
        int iA;
        byte[] bArr4;
        int i3;
        byte[] bArr5;
        oicq.wlogin_sdk.request.n nVar;
        long j7;
        int i4;
        int i5;
        int i6;
        oicq.wlogin_sdk.sharemem.WloginSigInfo wloginSigInfoA;
        int i7;
        oicq.wlogin_sdk.sharemem.WloginSigInfo wloginSigInfoA2;
        oicq.wlogin_sdk.request.Ticket ticketGetUserSigInfoTicket;
        oicq.wlogin_sdk.request.Ticket ticket;
        oicq.wlogin_sdk.request.async_context async_contextVar2;
        oicq.wlogin_sdk.request.t tVar;
        oicq.wlogin_sdk.tlv_type.tlv_t150 tlv_t150Var;
        byte[] bArr6;
        if (str == null || wUserSigInfo == null) {
            return oicq.wlogin_sdk.tools.util.E_INPUT;
        }
        int i8 = i | 192;
        if (2 == j4) {
            i8 &= -33554433;
        }
        int i9 = i8;
        if (i2 == 0) {
            new oicq.wlogin_sdk.request.WtloginHelper.HelperThread(this, this.mHelperHandler, wtTicketPromise, str, j, j2, j3, i9, j4, jArr, wUserSigInfo, bArr, bArr2, "[REDACTED]").RunReq(5);
            return oicq.wlogin_sdk.tools.util.E_PENDING;
        }
        oicq.wlogin_sdk.request.t tVarA = this.mG.a(0L);
        long j8 = tVarA.h;
        wUserSigInfo._seqence = j8;
        oicq.wlogin_sdk.request.async_context async_contextVarB = oicq.wlogin_sdk.request.t.b(j8);
        oicq.wlogin_sdk.tools.util.LOGI("[REDACTED]" + str + "[REDACTED]" + j + "[REDACTED]" + j2 + "[REDACTED]" + j3 + "[REDACTED]" + java.lang.Integer.toHexString(i9) + "[REDACTED]" + j4 + "[REDACTED]" + tVarA.h, str);
        int i10 = oicq.wlogin_sdk.tools.util.get_saved_network_type(this.mContext);
        int i11 = oicq.wlogin_sdk.tools.util.get_network_type(this.mContext);
        oicq.wlogin_sdk.request.t.D = i11;
        if (i10 != i11) {
            oicq.wlogin_sdk.tools.util.set_net_retry_type(this.mContext, 0);
            oicq.wlogin_sdk.tools.util.save_network_type(this.mContext, oicq.wlogin_sdk.request.t.D);
        }
        oicq.wlogin_sdk.request.t.F = oicq.wlogin_sdk.tools.util.get_apn_string(this.mContext).getBytes();
        tVarA.g = str;
        tVarA.f = 0L;
        async_contextVarB._sappid = j;
        async_contextVarB._appid = j2;
        async_contextVarB._sub_appid = j4;
        int i12 = i9;
        async_contextVarB._main_sigmap = i12;
        async_contextVarB._last_err_msg = new oicq.wlogin_sdk.tools.ErrMsg();
        if (jArr != null) {
            async_contextVarB._sub_appid_list = (long[]) jArr.clone();
        }
        byte[] bArr7 = wUserSigInfo._reserveData;
        if (bArr7 == null || bArr7.length <= 3) {
            tVarA.i = 0;
        } else {
            tVarA.i = oicq.wlogin_sdk.tools.util.buf_to_int32(bArr7, 0);
            oicq.wlogin_sdk.tools.util.LOGI("MSF SSO SEQ:" + tVarA.i, str);
        }
        oicq.wlogin_sdk.request.t.an.add_t2(new oicq.wlogin_sdk.report.report_t2("exchg", new java.lang.String(oicq.wlogin_sdk.request.t.C), java.lang.System.currentTimeMillis(), j2, j4, jArr));
        if (!oicq.wlogin_sdk.tools.util.check_uin_account(str).booleanValue()) {
            jB = tVarA.b(str);
            if (jB == 0) {
                oicq.wlogin_sdk.tools.util.LOGI("user:" + str + " have not found uin record.", str);
                async_contextVar = async_contextVarB;
                i6 = oicq.wlogin_sdk.tools.util.E_NO_UIN;
            }
            ticketGetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo, 128);
            if (ticketGetUserSigInfoTicket == null) {
                ticketGetUserSigInfoTicket = new oicq.wlogin_sdk.request.Ticket();
            }
            ticket = ticketGetUserSigInfoTicket;
            oicq.wlogin_sdk.request.t.an.commit_t2(tVarA.f, tVarA.g, oicq.wlogin_sdk.tools.util.format_ret_code(i6), i6);
            if (i6 == 0) {
                bArr6 = ticket._sig;
                if (bArr6 != null || bArr6.length == 0) {
                    async_contextVar2 = async_contextVar;
                    tVar = tVarA;
                } else {
                    RequestReport(0, bArr6, ticket._sig_key, tVarA.f, async_contextVar._appid);
                    tVar = tVarA;
                    async_contextVar2 = async_contextVar;
                }
            } else {
                i12 = i12;
                async_contextVar2 = async_contextVar;
                tVar = tVarA;
                i6 = i6;
                RequestReportError(0, ticket._sig, ticket._sig_key, tVarA.f, async_contextVar2._appid, 0);
            }
            tlv_t150Var = tVar.d;
            if (tlv_t150Var != null && tlv_t150Var.get_bitmap() != 0) {
                this.mG.d = tVar.d;
                RequestReportError(0, ticket._sig, ticket._sig_key, tVar.f, async_contextVar2._appid, 1);
            }
            oicq.wlogin_sdk.request.t.b();
            tVar.h();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("[REDACTED]");
            sb.append(str);
            sb.append(" dwSrcAppid:");
            oicq.wlogin_sdk.request.t tVar2 = tVar;
            sb.append(j);
            sb.append(" dwDstAppid:");
            sb.append(j2);
            sb.append(" dwDstAppPri:");
            sb.append(j3);
            sb.append(" dwMainSigMap:0x");
            sb.append(java.lang.Integer.toHexString(i12));
            sb.append(" dwSubDstAppid:");
            sb.append(j4);
            sb.append(" Seq:");
            sb.append(tVar2.h);
            sb.append(" ret=");
            int i13 = i6;
            sb.append(i13);
            oicq.wlogin_sdk.tools.util.LOGI(sb.toString(), "" + tVar2.f);
            return i13;
        }
        jB = java.lang.Long.parseLong(str);
        long j9 = jB;
        tVarA.f = j9;
        wUserSigInfo.uin = "" + j9;
        if (bArr2 != null && bArr2.length == 4 && bArr2[0] != null && bArr2[0].length == 1 && bArr2[0][0] == 1) {
            oicq.wlogin_sdk.tools.util.LOGI("user:" + str + " exchange A2 from A2/D2/KEY.", "" + tVarA.f);
            if (bArr2[1] != null && bArr2[1].length != 0 && bArr2[2] != null && bArr2[2].length != 0 && bArr2[3] != null && bArr2[3].length != 0) {
                tVarA.b = oicq.wlogin_sdk.tools.MD5.toMD5Byte(bArr2[3]);
                oicq.wlogin_sdk.request.n nVar2 = new oicq.wlogin_sdk.request.n(tVarA);
                bArr4 = bArr2[1];
                int i14 = this.mMiscBitmap;
                int i15 = this.mSubSigMap;
                bArr5 = bArr2[2];
                i3 = 1;
                nVar = nVar2;
                j7 = j9;
                j5 = j9;
                i4 = i14;
                i5 = i15;
                async_contextVar = async_contextVarB;
                iA = nVar.a(j7, j2, j4, i3, i12, bArr4, i4, i5, jArr, bArr5, wUserSigInfo);
                j6 = j5;
                jArr2 = jArr;
                if (iA == 0) {
                    wloginSigInfoA = tVarA.a(j6, j2);
                    if (wloginSigInfoA == null) {
                        i6 = oicq.wlogin_sdk.tools.util.E_NO_KEY;
                    } else {
                        wUserSigInfo.get_clone(wloginSigInfoA);
                        if (jArr2 != null) {
                            for (i7 = 0; i7 < jArr2.length; i7++) {
                                wloginSigInfoA2 = tVarA.a(j6, jArr2[i7]);
                                if (wloginSigInfoA2 != null) {
                                    int i16 = i7 * 2;
                                    bArr[i16] = (byte[]) wloginSigInfoA2._userSt_Key.clone();
                                    bArr[i16 + 1] = (byte[]) wloginSigInfoA2._userStSig.clone();
                                }
                            }
                        }
                    }
                }
                i6 = iA;
            }
            async_contextVar = async_contextVarB;
            i6 = oicq.wlogin_sdk.tools.util.E_NO_KEY;
        } else {
            j5 = j9;
            if (bArr2 != null && bArr2.length == 3 && bArr2[0] != null && bArr2[0].length == 1 && bArr2[0][0] == 2) {
                oicq.wlogin_sdk.tools.util.LOGI("user:" + str + " exchange A2 from A2/A2KEY.", "" + tVarA.f);
                if (bArr2[1] != null && bArr2[1].length != 0 && bArr2[2] != null && bArr2[2].length != 0) {
                    tVarA.b = bArr2[2];
                    oicq.wlogin_sdk.request.n nVar3 = new oicq.wlogin_sdk.request.n(tVarA);
                    bArr4 = bArr2[1];
                    i3 = 1;
                    bArr5 = null;
                    nVar = nVar3;
                    j7 = j5;
                    i4 = this.mMiscBitmap;
                    i5 = this.mSubSigMap;
                    async_contextVar = async_contextVarB;
                    iA = nVar.a(j7, j2, j4, i3, i12, bArr4, i4, i5, jArr, bArr5, wUserSigInfo);
                    j6 = j5;
                    jArr2 = jArr;
                    if (iA == 0) {
                        wloginSigInfoA = tVarA.a(j6, j2);
                        if (wloginSigInfoA == null) {
                            i6 = oicq.wlogin_sdk.tools.util.E_NO_KEY;
                        } else {
                            wUserSigInfo.get_clone(wloginSigInfoA);
                            if (jArr2 != null) {
                                while (i7 < jArr2.length) {
                                    wloginSigInfoA2 = tVarA.a(j6, jArr2[i7]);
                                    if (wloginSigInfoA2 != null) {
                                        int i17 = i7 * 2;
                                        bArr[i17] = (byte[]) wloginSigInfoA2._userSt_Key.clone();
                                        bArr[i17 + 1] = (byte[]) wloginSigInfoA2._userStSig.clone();
                                    }
                                }
                            }
                        }
                    }
                    i6 = iA;
                }
                async_contextVar = async_contextVarB;
                i6 = oicq.wlogin_sdk.tools.util.E_NO_KEY;
            } else {
                tVarA.j();
                byte[] bArrGetA1ByAccount = GetA1ByAccount(java.lang.String.valueOf(tVarA.f), j);
                byte[] bArrGetNoPicSigByAccount = GetNoPicSigByAccount(java.lang.String.valueOf(tVarA.f), j);
                if (bArrGetA1ByAccount == null || bArrGetA1ByAccount.length <= 0 || bArrGetNoPicSigByAccount == null || bArrGetNoPicSigByAccount.length <= 0) {
                    async_contextVar = async_contextVarB;
                    oicq.wlogin_sdk.tools.util.LOGI("user:" + str + " exchange A2 from A2.", "" + tVarA.f);
                    oicq.wlogin_sdk.sharemem.WloginSigInfo wloginSigInfoA3 = tVarA.a(j5, j);
                    if (wloginSigInfoA3 != null && (bArr3 = wloginSigInfoA3._TGT) != null && bArr3.length != 0 && !wloginSigInfoA3.iSExpireA2(oicq.wlogin_sdk.request.t.f())) {
                        oicq.wlogin_sdk.tools.util.LOGI("user:" + str + " exchange A2 from A2 without Priority.", "" + tVarA.f);
                        printTicket(wloginSigInfoA3);
                        tVarA.b = wloginSigInfoA3._TGTKey;
                        j6 = j5;
                        jArr2 = jArr;
                        iA = new oicq.wlogin_sdk.request.n(tVarA).a(j5, j2, j4, 1, i12, wloginSigInfoA3._TGT, this.mMiscBitmap, this.mSubSigMap, jArr, null, wUserSigInfo);
                    }
                    i6 = oicq.wlogin_sdk.tools.util.E_NO_KEY;
                } else {
                    oicq.wlogin_sdk.tools.util.LOGI("user:" + str + " exchange A2 from A1.", "" + tVarA.f);
                    async_contextVarB._tmp_pwd = bArrGetA1ByAccount;
                    async_contextVarB._tmp_no_pic_sig = bArrGetNoPicSigByAccount;
                    byte[] bArr8 = wUserSigInfo._in_ksid;
                    byte[] bArr9 = (bArr8 == null || bArr8.length <= 0) ? oicq.wlogin_sdk.request.t.aa : (byte[]) bArr8.clone();
                    oicq.wlogin_sdk.request.y yVar = new oicq.wlogin_sdk.request.y(tVarA, this.mContext);
                    oicq.wlogin_sdk.sharemem.WloginSigInfo wloginSigInfoFindUserSig = FindUserSig(j5, j);
                    if (wloginSigInfoFindUserSig != null) {
                        yVar.a(wloginSigInfoFindUserSig);
                    }
                    j6 = j5;
                    async_contextVar = async_contextVarB;
                    iA = yVar.a(j2, 1, tVarA.f, 0, oicq.wlogin_sdk.request.t.ad, bArrGetA1ByAccount, bArrGetNoPicSigByAccount, this.mMiscBitmap, this.mSubSigMap, jArr, i12, j4, 1, oicq.wlogin_sdk.request.t.y, 0, 0, 1, bArr9, j, wUserSigInfo);
                    if (iA == 204) {
                        iA = new oicq.wlogin_sdk.request.q(tVarA).a(this.mMiscBitmap, this.mSubSigMap, jArr, wUserSigInfo);
                        jArr2 = jArr;
                    } else {
                        jArr2 = jArr;
                    }
                }
                if (iA == 0) {
                    wloginSigInfoA = tVarA.a(j6, j2);
                    if (wloginSigInfoA == null) {
                        i6 = oicq.wlogin_sdk.tools.util.E_NO_KEY;
                    } else {
                        wUserSigInfo.get_clone(wloginSigInfoA);
                        if (jArr2 != null && bArr != null && jArr2.length * 2 == bArr.length) {
                            while (i7 < jArr2.length) {
                                wloginSigInfoA2 = tVarA.a(j6, jArr2[i7]);
                                if (wloginSigInfoA2 != null) {
                                    int i18 = i7 * 2;
                                    bArr[i18] = (byte[]) wloginSigInfoA2._userSt_Key.clone();
                                    bArr[i18 + 1] = (byte[]) wloginSigInfoA2._userStSig.clone();
                                }
                            }
                        }
                    }
                }
                i6 = iA;
            }
        }
        ticketGetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo, 128);
        if (ticketGetUserSigInfoTicket == null) {
            ticketGetUserSigInfoTicket = new oicq.wlogin_sdk.request.Ticket();
        }
        ticket = ticketGetUserSigInfoTicket;
        oicq.wlogin_sdk.request.t.an.commit_t2(tVarA.f, tVarA.g, oicq.wlogin_sdk.tools.util.format_ret_code(i6), i6);
        if (i6 == 0) {
            bArr6 = ticket._sig;
            if (bArr6 != null) {
                async_contextVar2 = async_contextVar;
                tVar = tVarA;
            } else {
                async_contextVar2 = async_contextVar;
                tVar = tVarA;
            }
        } else {
            i12 = i12;
            async_contextVar2 = async_contextVar;
            tVar = tVarA;
            i6 = i6;
            RequestReportError(0, ticket._sig, ticket._sig_key, tVarA.f, async_contextVar2._appid, 0);
        }
        tlv_t150Var = tVar.d;
        if (tlv_t150Var != null) {
            this.mG.d = tVar.d;
            RequestReportError(0, ticket._sig, ticket._sig_key, tVar.f, async_contextVar2._appid, 1);
        }
        oicq.wlogin_sdk.request.t.b();
        tVar.h();
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append("[REDACTED]");
        sb2.append(str);
        sb2.append(" dwSrcAppid:");
        oicq.wlogin_sdk.request.t tVar3 = tVar;
        sb2.append(j);
        sb2.append(" dwDstAppid:");
        sb2.append(j2);
        sb2.append(" dwDstAppPri:");
        sb2.append(j3);
        sb2.append(" dwMainSigMap:0x");
        sb2.append(java.lang.Integer.toHexString(i12));
        sb2.append(" dwSubDstAppid:");
        sb2.append(j4);
        sb2.append(" Seq:");
        sb2.append(tVar3.h);
        sb2.append(" ret=");
        int i19 = i6;
        sb2.append(i19);
        oicq.wlogin_sdk.tools.util.LOGI(sb2.toString(), "" + tVar3.f);
        return i19;
    }

    private int GetStWithoutPasswd(java.lang.String str, long j, long j2, long j3, int i, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo, oicq.wlogin_sdk.request.WtTicketPromise wtTicketPromise) {
        return GetStWithoutPasswd(str, j, j2, -1L, i, j3, null, wUserSigInfo, null, null, 0, wtTicketPromise);
    }

    public static byte[] GetTicketSig(oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo, int i) {
        oicq.wlogin_sdk.request.Ticket ticketGetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo, i);
        return ticketGetUserSigInfoTicket != null ? ticketGetUserSigInfoTicket._sig : new byte[0];
    }

    public static byte[] GetTicketSigKey(oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo, int i) {
        if (i != 64 && i != 262144 && i != 128 && i != 16384 && i != 32768 && i != 16777216) {
            throw null;
        }
        oicq.wlogin_sdk.request.Ticket ticketGetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo, i);
        return ticketGetUserSigInfoTicket != null ? ticketGetUserSigInfoTicket._sig_key : new byte[0];
    }

    public static oicq.wlogin_sdk.request.Ticket GetUserSigInfoTicket(oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo, int i) {
        if (i == 4194304) {
            oicq.wlogin_sdk.tools.util.LOGI("get lhsig", "");
            return new oicq.wlogin_sdk.request.Ticket(4194304, oicq.wlogin_sdk.sharemem.WloginSigInfo._LHSig, (byte[]) null, oicq.wlogin_sdk.request.t.f(), 0L);
        }
        if (i == 67108864) {
            oicq.wlogin_sdk.tools.util.LOGI("get qrpushsig", "");
            return new oicq.wlogin_sdk.request.Ticket(oicq.wlogin_sdk.request.WtloginHelper.SigType.WLOGIN_QRPUSH, oicq.wlogin_sdk.sharemem.WloginSigInfo._QRPUSHSig, (byte[]) null, oicq.wlogin_sdk.request.t.f(), 0L);
        }
        if (wUserSigInfo == null) {
            oicq.wlogin_sdk.tools.util.LOGI("userInfo is null " + java.lang.Integer.toHexString(i), "");
            return null;
        }
        if (wUserSigInfo._tickets == null) {
            oicq.wlogin_sdk.tools.util.LOGI("tickets is null " + java.lang.Integer.toHexString(i), wUserSigInfo.uin);
            return null;
        }
        oicq.wlogin_sdk.tools.util.LOGI("GetUserSigInfoTicket ticket type:0x" + java.lang.Integer.toHexString(i), "");
        if (wUserSigInfo._tickets != null) {
            for (int i2 = 0; i2 < wUserSigInfo._tickets.size(); i2++) {
                oicq.wlogin_sdk.request.Ticket ticket = (oicq.wlogin_sdk.request.Ticket) wUserSigInfo._tickets.get(i2);
                if (ticket._type == i) {
                    oicq.wlogin_sdk.tools.util.LOGI("GetUserSigInfoTicket type:0x" + java.lang.Integer.toHexString(i) + " sig:" + oicq.wlogin_sdk.tools.util.buf_len(ticket._sig) + " key:" + oicq.wlogin_sdk.tools.util.buf_len(ticket._sig_key) + " create time:" + ticket._create_time + " expire time:" + ticket._expire_time, "");
                    oicq.wlogin_sdk.tools.util.LOGI(ticket.getContent(), wUserSigInfo.uin);
                    return ticket;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OnDeviceLockRequest(java.lang.String str, long j, long j2, oicq.wlogin_sdk.request.TransReqContext transReqContext, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo, int i) {
        oicq.wlogin_sdk.devicelock.DevlockRst devlockRst = oicq.wlogin_sdk.devicelock.DevlockBase.rst;
        devlockRst.commRsp = new oicq.wlogin_sdk.devicelock.TLV_CommRsp();
        oicq.wlogin_sdk.devicelock.DevlockInfo devlockInfo = new oicq.wlogin_sdk.devicelock.DevlockInfo();
        oicq.wlogin_sdk.tools.ErrMsg errMsg = new oicq.wlogin_sdk.tools.ErrMsg(0, "", "", "");
        if (i != 0) {
            oicq.wlogin_sdk.tools.util.LOGI("OnDeviceLockRequest ret:" + i, str);
            errMsg.setMessage(oicq.wlogin_sdk.tools.util.get_error_msg(i));
            errMsg.setTitle(oicq.wlogin_sdk.tools.InternationMsg.a(oicq.wlogin_sdk.tools.InternationMsg.MSG_TYPE.MSG_5));
        }
        int i2 = transReqContext.get_subcmd();
        if (i2 == 5) {
            if (i == 0) {
                i = new oicq.wlogin_sdk.devicelock.a().parse_rsp(transReqContext.get_body());
                oicq.wlogin_sdk.tools.util.LOGI("CheckDevLockStatus ret:" + i, str);
                if (i != -1009) {
                    tlvCommRsp2ErrMsg(devlockRst.commRsp, errMsg);
                    oicq.wlogin_sdk.devicelock.i iVar = devlockRst.devSetupInfo;
                    if (iVar != null && iVar.get_data_len() > 0) {
                        oicq.wlogin_sdk.devicelock.i iVar2 = devlockRst.devSetupInfo;
                        devlockInfo.DevSetup = iVar2.f1662a;
                        devlockInfo.AllowSet = iVar2.b;
                        oicq.wlogin_sdk.devicelock.h hVar = devlockRst.devGuideInfo;
                        devlockInfo.ProtectIntro = (hVar == null || hVar.get_data_len() <= 0) ? new java.lang.String(devlockRst.devSetupInfo.d) : new java.lang.String(devlockRst.devGuideInfo.f1661a);
                        devlockInfo.WarningInfo = new java.lang.String(devlockRst.devSetupInfo.g);
                        devlockInfo.WarningTitle = new java.lang.String(devlockRst.devSetupInfo.e);
                        devlockInfo.WarningMsg = new java.lang.String(devlockRst.devSetupInfo.f);
                        devlockInfo.WarningInfoType = devlockRst.devSetupInfo.c;
                    }
                    oicq.wlogin_sdk.devicelock.k kVar = devlockRst.mbMobileInfo;
                    if (kVar != null && kVar.get_data_len() > 0) {
                        devlockInfo.CountryCode = new java.lang.String(devlockRst.mbMobileInfo.f1664a);
                        devlockInfo.Mobile = new java.lang.String(devlockRst.mbMobileInfo.b);
                        oicq.wlogin_sdk.devicelock.k kVar2 = devlockRst.mbMobileInfo;
                        devlockInfo.MbItemSmsCodeStatus = kVar2.c;
                        devlockInfo.AvailableMsgCount = kVar2.d;
                        devlockInfo.TimeLimit = kVar2.e;
                    }
                    oicq.wlogin_sdk.devicelock.j jVar = devlockRst.mbGuideInfo;
                    if (jVar != null && jVar.get_data_len() > 0) {
                        oicq.wlogin_sdk.devicelock.j jVar2 = devlockRst.mbGuideInfo;
                        devlockInfo.MbGuideType = jVar2.c;
                        devlockInfo.MbGuideInfoType = jVar2.d;
                        devlockInfo.MbGuideInfo = new java.lang.String(devlockRst.mbGuideInfo.b);
                        devlockInfo.MbGuideMsg = new java.lang.String(devlockRst.mbGuideInfo.f1663a);
                    }
                    oicq.wlogin_sdk.devicelock.e eVar = devlockRst.transferInfo;
                    if (eVar != null && eVar.get_data_len() > 0) {
                        devlockInfo.TransferInfo = devlockRst.transferInfo.get_data();
                    }
                }
            }
            oicq.wlogin_sdk.request.WtloginListener wtloginListener = this.mListener;
            if (wtloginListener != null) {
                wtloginListener.OnCheckDevLockStatus(wUserSigInfo, devlockInfo, i, errMsg);
                return;
            }
            return;
        }
        if (i2 == 12) {
            if (i == 0) {
                i = new oicq.wlogin_sdk.devicelock.b().parse_rsp(transReqContext.get_body());
                oicq.wlogin_sdk.tools.util.LOGI("CloseDevLock ret:" + i, str);
                if (i != -1009) {
                    tlvCommRsp2ErrMsg(devlockRst.commRsp, errMsg);
                    try {
                        this.mG.b(!oicq.wlogin_sdk.tools.util.check_uin_account(str).booleanValue() ? this.mG.b(str) : java.lang.Long.parseLong(str), j);
                        for (int i3 = 0; i3 < wUserSigInfo._tickets.size(); i3++) {
                            if (((oicq.wlogin_sdk.request.Ticket) wUserSigInfo._tickets.get(i3))._type == 33554432) {
                                wUserSigInfo._tickets.remove(i3);
                            }
                        }
                    } catch (java.lang.Exception e) {
                        oicq.wlogin_sdk.tools.util.printException(e);
                    }
                }
            }
            oicq.wlogin_sdk.request.WtloginListener wtloginListener2 = this.mListener;
            if (wtloginListener2 != null) {
                wtloginListener2.OnCloseDevLock(wUserSigInfo, i, errMsg);
                return;
            }
            return;
        }
        if (i2 != 7) {
            if (i2 != 8) {
                return;
            }
            if (i == 0) {
                i = new oicq.wlogin_sdk.devicelock.f().parse_rsp(transReqContext.get_body());
                oicq.wlogin_sdk.tools.util.LOGI("CheckDevLockSms ret:" + i, str);
                if (i != -1009) {
                    tlvCommRsp2ErrMsg(devlockRst.commRsp, errMsg);
                }
            }
            oicq.wlogin_sdk.request.WtloginListener wtloginListener3 = this.mListener;
            if (wtloginListener3 != null) {
                wtloginListener3.OnCheckDevLockSms(wUserSigInfo, i, errMsg);
                return;
            }
            return;
        }
        if (i == 0) {
            i = new oicq.wlogin_sdk.devicelock.d().parse_rsp(transReqContext.get_body());
            oicq.wlogin_sdk.tools.util.LOGI("AskDevLockSms ret:" + i, str);
            if (i != -1009) {
                tlvCommRsp2ErrMsg(devlockRst.commRsp, errMsg);
                oicq.wlogin_sdk.devicelock.m mVar = devlockRst.smsInfo;
                if (mVar != null) {
                    devlockInfo.AvailableMsgCount = mVar.f1666a;
                    devlockInfo.TimeLimit = mVar.b;
                }
            }
        }
        oicq.wlogin_sdk.request.WtloginListener wtloginListener4 = this.mListener;
        if (wtloginListener4 != null) {
            wtloginListener4.OnAskDevLockSms(wUserSigInfo, devlockInfo, i, errMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OnRequestCode2d(java.lang.String str, long j, long j2, oicq.wlogin_sdk.request.TransReqContext transReqContext, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo, int i) {
        byte[] bArr;
        int i2 = i;
        if (this.mListener == null) {
        }
        oicq.wlogin_sdk.code2d.c cVar = oicq.wlogin_sdk.code2d.b._status;
        if (i2 != 0) {
            oicq.wlogin_sdk.tools.util.LOGI("OnRequestCode2d ret:" + i2, str);
        }
        int i3 = transReqContext.get_subcmd();
        if (i3 == 49) {
            if (i2 == 0) {
                int i4 = new oicq.wlogin_sdk.code2d.fetch_code().get_response(transReqContext.get_body());
                oicq.wlogin_sdk.tools.util.LOGI("FetchCodeSig ret:" + cVar.b, str);
                i2 = i4;
            }
            this.mListener.OnFetchCodeSig(cVar.j, cVar.k, cVar.l, wUserSigInfo, cVar.f, i2);
            return;
        }
        switch (i3) {
            case 18:
                if (i2 == 0) {
                    int iA = new oicq.wlogin_sdk.code2d.d().a(transReqContext.get_body());
                    oicq.wlogin_sdk.tools.util.LOGI("QueryCodeResult ret:" + cVar.b, str);
                    i2 = iA;
                }
                this.mListener.OnQueryCodeResult(cVar.f1658a, cVar.e, cVar.c, wUserSigInfo, cVar.f, i2);
                break;
            case 19:
                if (i2 == 0) {
                    cVar.b = new oicq.wlogin_sdk.code2d.e().a(transReqContext.get_body());
                    oicq.wlogin_sdk.tools.util.LOGI("VerifyCode ret:" + cVar.b, str);
                    if (cVar.b == 0 && (bArr = cVar.g) != null && bArr.length > 0) {
                        this.mG.a(cVar.f1658a, j, bArr);
                    }
                    this.mListener.OnVerifyCode(str, cVar.d, cVar.c, cVar.e, wUserSigInfo, cVar.f, cVar.b);
                } else {
                    this.mListener.OnVerifyCode(str, cVar.d, cVar.c, cVar.e, wUserSigInfo, cVar.f, i);
                }
                break;
            case 20:
                if (i2 == 0) {
                    oicq.wlogin_sdk.code2d.a aVar = new oicq.wlogin_sdk.code2d.a();
                    oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo2 = wUserSigInfo == null ? new oicq.wlogin_sdk.request.WUserSigInfo() : wUserSigInfo;
                    cVar.b = aVar.a(transReqContext.get_body(), j, oicq.wlogin_sdk.request.t.t, wUserSigInfo2.loginTLVMap);
                    oicq.wlogin_sdk.tools.util.LOGI("CloseCode ret:" + cVar.b, str);
                    oicq.wlogin_sdk.code2d.c.t = false;
                    this.mListener.OnCloseCode(str, cVar.d, cVar.c, wUserSigInfo2, cVar.f, cVar.b);
                } else {
                    this.mListener.OnCloseCode(str, cVar.d, cVar.c, wUserSigInfo, cVar.f, i);
                }
                break;
            default:
                oicq.wlogin_sdk.tools.util.LOGW("OnRequestName unhandle cmd", "", str);
                this.mListener.OnException(new oicq.wlogin_sdk.tools.ErrMsg(), 9, wUserSigInfo);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OnRequestRegister(java.lang.String str, long j, long j2, oicq.wlogin_sdk.request.TransReqContext transReqContext, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo, int i) {
        oicq.wlogin_sdk.request.WtloginListener wtloginListener;
        oicq.wlogin_sdk.request.WtloginListener wtloginListener2;
        int i2;
        byte[] bytes;
        oicq.wlogin_sdk.request.WtloginListener wtloginListener3;
        oicq.wlogin_sdk.request.WtloginListener wtloginListener4;
        int iA;
        oicq.wlogin_sdk.request.WtloginListener wtloginListener5;
        oicq.wlogin_sdk.request.WtloginListener wtloginListener6;
        int iB;
        oicq.wlogin_sdk.request.WtloginListener wtloginListener7;
        if (this.mListener == null) {
            return;
        }
        java.lang.String strA = oicq.wlogin_sdk.tools.InternationMsg.a(oicq.wlogin_sdk.tools.InternationMsg.MSG_TYPE.MSG_3);
        if (i != 0) {
            oicq.wlogin_sdk.request.WtloginListener wtloginListener8 = this.mListener;
            if (wtloginListener8 != null) {
                wtloginListener8.OnRegError(wUserSigInfo, i, strA.getBytes());
                return;
            }
            return;
        }
        oicq.wlogin_sdk.a.h hVar = this.mRegStatus;
        int i3 = transReqContext.get_subcmd();
        if (i3 != 10) {
            if (i3 == 16) {
                int iE = oicq.wlogin_sdk.a.a.e(transReqContext.get_body(), hVar);
                if (iE != 0 && (wtloginListener3 = this.mListener) != null) {
                    wtloginListener3.OnRegError(wUserSigInfo, iE, strA.getBytes());
                }
                oicq.wlogin_sdk.tools.util.LOGI("reg cmd:" + transReqContext.get_subcmd() + " ret:" + hVar.d, "");
                this.mListener.OnQuickRegisterCheckAccount(wUserSigInfo, hVar.d, hVar.f);
                return;
            }
            if (i3 == 17) {
                int iF = oicq.wlogin_sdk.a.a.f(transReqContext.get_body(), hVar);
                if (iF != 0 && (wtloginListener4 = this.mListener) != null) {
                    wtloginListener4.OnRegError(wUserSigInfo, iF, strA.getBytes());
                }
                oicq.wlogin_sdk.tools.util.LOGI("reg cmd:" + transReqContext.get_subcmd() + " ret:" + hVar.d, "");
                wUserSigInfo.regTLVMap = hVar.B;
                hVar.B = new java.util.HashMap();
                this.mListener.OnQuickRegisterGetAccount(wUserSigInfo, hVar.d, hVar.f);
                return;
            }
            switch (i3) {
                case 3:
                    iA = oicq.wlogin_sdk.a.a.a(3, transReqContext.get_body(), hVar);
                    if (iA == 0) {
                        oicq.wlogin_sdk.tools.util.LOGI("reg cmd:" + transReqContext.get_subcmd() + " ret:" + hVar.d, "");
                        int i4 = hVar.d;
                        if (i4 == 0 || i4 == 4 || i4 == 31 || i4 == 118) {
                            if (hVar.d == 0) {
                                wUserSigInfo.regTLVMap = hVar.B;
                                hVar.B = new java.util.HashMap();
                            }
                            this.mListener.OnRegQueryClientSentMsgStatus(wUserSigInfo, hVar.d, hVar.s, hVar.t, new java.lang.String(hVar.f));
                        } else if (i4 != 3) {
                            oicq.wlogin_sdk.tools.util.LOGW("OnRequestRegister 0x3 return code:", java.lang.String.valueOf(i4), str);
                            wtloginListener = this.mListener;
                            if (wtloginListener == null) {
                            }
                            i2 = hVar.d;
                            bytes = hVar.f;
                        } else {
                            wtloginListener2 = this.mListener;
                            if (wtloginListener2 == null) {
                            }
                            wtloginListener2.OnRegCheckValidUrl(wUserSigInfo, hVar.r);
                        }
                    } else {
                        wtloginListener5 = this.mListener;
                        if (wtloginListener5 == null) {
                        }
                        wtloginListener5.OnRegError(wUserSigInfo, iA, strA.getBytes());
                    }
                    break;
                case 4:
                    iA = oicq.wlogin_sdk.a.a.a(transReqContext.get_body(), hVar);
                    if (iA == 0) {
                        oicq.wlogin_sdk.tools.util.LOGI("reg cmd:" + transReqContext.get_subcmd() + " ret:" + hVar.d, "");
                        int i5 = hVar.d;
                        if (i5 == 0) {
                            wtloginListener6 = this.mListener;
                            if (wtloginListener6 == null) {
                            }
                        } else if (i5 == 3) {
                            wtloginListener2 = this.mListener;
                            if (wtloginListener2 == null) {
                            }
                            wtloginListener2.OnRegCheckValidUrl(wUserSigInfo, hVar.r);
                            break;
                        } else if (i5 != 5) {
                            oicq.wlogin_sdk.tools.util.LOGW("OnRequestRegister 0x4 return code:", java.lang.String.valueOf(i5), str);
                            wtloginListener = this.mListener;
                            if (wtloginListener == null) {
                            }
                            i2 = hVar.d;
                            bytes = hVar.f;
                            break;
                        } else {
                            wtloginListener6 = this.mListener;
                            if (wtloginListener6 == null) {
                            }
                        }
                        wtloginListener6.OnRegRequestServerResendMsg(wUserSigInfo, i5, hVar.s, hVar.t);
                    } else {
                        wtloginListener5 = this.mListener;
                        if (wtloginListener5 == null) {
                        }
                        wtloginListener5.OnRegError(wUserSigInfo, iA, strA.getBytes());
                    }
                    break;
                case 5:
                    iB = oicq.wlogin_sdk.a.a.b(transReqContext.get_body(), hVar);
                    if (iB == 0) {
                        wUserSigInfo.regTLVMap = hVar.B;
                        hVar.B = new java.util.HashMap();
                        oicq.wlogin_sdk.tools.util.LOGI("reg cmd:" + transReqContext.get_subcmd() + " ret:" + hVar.d, "");
                        oicq.wlogin_sdk.request.WtloginListener wtloginListener9 = this.mListener;
                        if (wtloginListener9 != null) {
                            wtloginListener9.OnRegSubmitMsgChk(wUserSigInfo, hVar.d, hVar.f);
                        }
                    } else {
                        wtloginListener7 = this.mListener;
                        if (wtloginListener7 == null) {
                        }
                        wtloginListener7.OnRegError(wUserSigInfo, iB, strA.getBytes());
                    }
                    break;
                case 6:
                    iB = oicq.wlogin_sdk.a.a.c(transReqContext.get_body(), hVar);
                    if (iB == 0) {
                        wUserSigInfo.regTLVMap = hVar.B;
                        hVar.B = new java.util.HashMap();
                        oicq.wlogin_sdk.tools.util.LOGI("reg cmd:" + transReqContext.get_subcmd() + " ret:" + hVar.d, "");
                        if (this.mListener != null) {
                            java.lang.String str2 = hVar.b;
                            if (str2 != null && str2.indexOf("-") > 0) {
                                int iIndexOf = hVar.b.indexOf("-");
                                java.lang.String strSubstring = hVar.b.substring(0, iIndexOf);
                                hVar.b = strSubstring.equals("86") ? hVar.b.substring(iIndexOf + 1) : "00" + strSubstring + hVar.b.substring(iIndexOf + 1);
                            }
                            java.lang.String str3 = hVar.b;
                            if (str3 != null && str3.length() != 0) {
                                this.mG.d(hVar.b);
                                this.mG.a(hVar.b, java.lang.Long.valueOf(hVar.u));
                            }
                            oicq.wlogin_sdk.tools.util.LOGI("reg userAccount: " + hVar.b, hVar.u + "");
                            if (oicq.wlogin_sdk.a.h.z.length() <= 0) {
                                this.mListener.OnRegGetAccount(wUserSigInfo, hVar.d, hVar.u, hVar.v, hVar.w, hVar.f);
                            } else {
                                this.mListener.OnRegGetSMSVerifyLoginAccount(wUserSigInfo, hVar.d, hVar.u, hVar.v, hVar.w, hVar.f);
                            }
                        }
                    } else {
                        wtloginListener7 = this.mListener;
                        if (wtloginListener7 == null) {
                        }
                        wtloginListener7.OnRegError(wUserSigInfo, iB, strA.getBytes());
                    }
                    break;
                case 7:
                    int iD = oicq.wlogin_sdk.a.a.d(transReqContext.get_body(), hVar);
                    if (iD == 0) {
                        oicq.wlogin_sdk.tools.util.LOGI("reg cmd:" + transReqContext.get_subcmd() + " ret:" + hVar.d, "");
                        oicq.wlogin_sdk.request.WtloginListener wtloginListener10 = this.mListener;
                        if (wtloginListener10 != null) {
                            wtloginListener10.OnRegQueryAccount(wUserSigInfo, hVar.d, hVar.f);
                        }
                    } else {
                        oicq.wlogin_sdk.request.WtloginListener wtloginListener11 = this.mListener;
                        if (wtloginListener11 != null) {
                            wtloginListener11.OnRegError(wUserSigInfo, iD, strA.getBytes());
                        }
                    }
                    break;
                default:
                    oicq.wlogin_sdk.tools.util.LOGW("OnRequestRegister unhandle cmd:" + transReqContext.get_subcmd(), "", str);
                    wtloginListener = this.mListener;
                    if (wtloginListener != null) {
                        bytes = strA.getBytes();
                        i2 = oicq.wlogin_sdk.tools.util.E_NO_REG_CMD;
                    }
                    break;
            }
            return;
        }
        int iA2 = oicq.wlogin_sdk.a.a.a(transReqContext.get_body(), hVar);
        if (iA2 != 0) {
            oicq.wlogin_sdk.request.WtloginListener wtloginListener12 = this.mListener;
            if (wtloginListener12 != null) {
                wtloginListener12.OnRegError(wUserSigInfo, iA2, strA.getBytes());
                return;
            }
            return;
        }
        oicq.wlogin_sdk.tools.util.LOGI("reg cmd:" + transReqContext.get_subcmd() + " ret:" + hVar.d, "");
        int i6 = hVar.d;
        if (i6 == 0) {
            oicq.wlogin_sdk.request.WtloginListener wtloginListener13 = this.mListener;
            if (wtloginListener13 != null) {
                wtloginListener13.OnRegCheckDownloadMsg(wUserSigInfo, hVar.m, hVar.n);
                return;
            }
            return;
        }
        if (i6 == 2) {
            oicq.wlogin_sdk.request.WtloginListener wtloginListener14 = this.mListener;
            if (wtloginListener14 != null) {
                wtloginListener14.OnRegCheckUploadMsg(wUserSigInfo, new java.lang.String(hVar.q));
                return;
            }
            return;
        }
        if (i6 == 3) {
            wtloginListener2 = this.mListener;
            if (wtloginListener2 == null) {
                return;
            }
            wtloginListener2.OnRegCheckValidUrl(wUserSigInfo, hVar.r);
            return;
        }
        if (i6 == 6 || i6 == 44) {
            oicq.wlogin_sdk.request.WtloginListener wtloginListener15 = this.mListener;
            if (wtloginListener15 != null) {
                wtloginListener15.OnRegCheckWebSig(wUserSigInfo, new java.lang.String(hVar.r), new java.lang.String(hVar.f));
            }
            hVar.r = new byte[0];
            return;
        }
        oicq.wlogin_sdk.tools.util.LOGW("OnRequestRegister 0xa return code:", java.lang.String.valueOf(i6), str);
        wtloginListener = this.mListener;
        if (wtloginListener == null) {
            return;
        }
        i2 = hVar.d;
        bytes = hVar.f;
        wtloginListener.OnRegError(wUserSigInfo, i2, bytes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:21:0x0093  */
    /* JADX WARN: Code duplicated, block: B:24:0x00a7  */
    public int RefreshPictureData(java.lang.String str, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo, int i) {
        long jB;
        boolean z;
        int iA;
        if (str == null || wUserSigInfo == null) {
            return oicq.wlogin_sdk.tools.util.E_INPUT;
        }
        if (i == 0) {
            new oicq.wlogin_sdk.request.WtloginHelper.HelperThread(this, this.mHelperHandler, str, wUserSigInfo, "RefreshPictureData").RunReq(1);
            return oicq.wlogin_sdk.tools.util.E_PENDING;
        }
        if (wUserSigInfo._seqence == 0) {
            wUserSigInfo._seqence = this.mAysncSeq;
        }
        oicq.wlogin_sdk.request.t tVarA = this.mG.a(wUserSigInfo._seqence);
        long j = tVarA.h;
        wUserSigInfo._seqence = j;
        oicq.wlogin_sdk.request.async_context async_contextVarB = oicq.wlogin_sdk.request.t.b(j);
        oicq.wlogin_sdk.tools.util.LOGI("user:" + str + " Seq:" + tVarA.h + " RefreshPictureData ...", "" + str);
        tVarA.g = str;
        async_contextVarB._last_err_msg = new oicq.wlogin_sdk.tools.ErrMsg();
        if (!oicq.wlogin_sdk.tools.util.check_uin_account(str).booleanValue()) {
            jB = tVarA.b(str);
            if (jB == 0) {
                z = false;
            }
            if (z) {
                tVarA.f = jB;
            }
            iA = new oicq.wlogin_sdk.request.r(tVarA).a(this.mMiscBitmap, this.mSubSigMap, async_contextVarB._sub_appid_list, wUserSigInfo);
            if (iA == 2) {
                iA = 0;
            }
            oicq.wlogin_sdk.tools.util.LOGI("user:" + str + " Seq:" + tVarA.h + " RefreshPictureData ret=" + iA, "" + str);
            return iA;
        }
        jB = java.lang.Long.parseLong(str);
        z = true;
        if (z) {
            tVarA.f = jB;
        }
        iA = new oicq.wlogin_sdk.request.r(tVarA).a(this.mMiscBitmap, this.mSubSigMap, async_contextVarB._sub_appid_list, wUserSigInfo);
        if (iA == 2) {
            iA = 0;
        }
        oicq.wlogin_sdk.tools.util.LOGI("user:" + str + " Seq:" + tVarA.h + " RefreshPictureData ret=" + iA, "" + str);
        return iA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:21:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:24:0x00c4  */
    public int RefreshSMSData(java.lang.String str, long j, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo, int i) {
        long jB;
        boolean z;
        int iA;
        if (str == null || wUserSigInfo == null) {
            return oicq.wlogin_sdk.tools.util.E_INPUT;
        }
        if (i == 0) {
            new oicq.wlogin_sdk.request.WtloginHelper.HelperThread(this, this.mHelperHandler, str, j, wUserSigInfo, "RefreshSMSData").RunReq(3);
            return oicq.wlogin_sdk.tools.util.E_PENDING;
        }
        if (wUserSigInfo._seqence == 0) {
            wUserSigInfo._seqence = this.mAysncSeq;
        }
        oicq.wlogin_sdk.request.t tVarA = this.mG.a(wUserSigInfo._seqence);
        long j2 = tVarA.h;
        wUserSigInfo._seqence = j2;
        oicq.wlogin_sdk.request.async_context async_contextVarB = oicq.wlogin_sdk.request.t.b(j2);
        oicq.wlogin_sdk.tools.util.LOGI("user:" + str + " smsAppid:" + j + " Seq:" + tVarA.h + " RefreshSMSData ...", "" + str);
        tVarA.g = str;
        async_contextVarB._last_err_msg = new oicq.wlogin_sdk.tools.ErrMsg();
        if (!oicq.wlogin_sdk.tools.util.check_uin_account(str).booleanValue()) {
            jB = tVarA.b(str);
            if (jB == 0) {
                z = false;
            }
            if (z) {
                tVarA.f = jB;
            }
            iA = new oicq.wlogin_sdk.request.s(tVarA).a(j, this.mMiscBitmap, this.mSubSigMap, async_contextVarB._sub_appid_list, wUserSigInfo);
            if (iA == 160) {
                iA = 0;
            }
            oicq.wlogin_sdk.tools.util.LOGI("user:" + str + " smsAppid:" + j + " Seq:" + tVarA.h + " RefreshSMSData ret=" + iA, "" + str);
            return iA;
        }
        jB = java.lang.Long.parseLong(str);
        z = true;
        if (z) {
            tVarA.f = jB;
        }
        iA = new oicq.wlogin_sdk.request.s(tVarA).a(j, this.mMiscBitmap, this.mSubSigMap, async_contextVarB._sub_appid_list, wUserSigInfo);
        if (iA == 160) {
            iA = 0;
        }
        oicq.wlogin_sdk.tools.util.LOGI("user:" + str + " smsAppid:" + j + " Seq:" + tVarA.h + " RefreshSMSData ret=" + iA, "" + str);
        return iA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int RefreshSMSVerifyLoginCode(java.lang.String str, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo, int i) {
        if (str == null || str.length() == 0) {
            return oicq.wlogin_sdk.tools.util.E_INPUT;
        }
        if (i == 0) {
            new oicq.wlogin_sdk.request.WtloginHelper.HelperThread(this, this.mHelperHandler, str, wUserSigInfo, "RefreshSMSVerifyLoginCode").RunReq(14);
            return oicq.wlogin_sdk.tools.util.E_PENDING;
        }
        if (wUserSigInfo._seqence == 0) {
            wUserSigInfo._seqence = this.mAysncSeq;
        }
        oicq.wlogin_sdk.request.t tVarA = this.mG.a(wUserSigInfo._seqence);
        long j = tVarA.h;
        wUserSigInfo._seqence = j;
        oicq.wlogin_sdk.request.async_context async_contextVarB = oicq.wlogin_sdk.request.t.b(j);
        oicq.wlogin_sdk.tools.util.LOGI("user:" + str + " Seq:" + tVarA.h + " RefreshSMSVerifyLoginCode ...", str);
        tVarA.g = str;
        async_contextVarB._last_err_msg = new oicq.wlogin_sdk.tools.ErrMsg();
        int iA = new oicq.wlogin_sdk.request.w(tVarA).a(this.mMiscBitmap, this.mSubSigMap, (long[]) null, wUserSigInfo);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("user:");
        sb.append(tVarA.g);
        sb.append(" Seq:");
        sb.append(tVarA.h);
        sb.append(" RefreshSMSVerifyLoginCode ret=");
        sb.append(iA > 0 ? java.lang.Integer.toHexString(iA) : java.lang.Integer.valueOf(iA));
        oicq.wlogin_sdk.tools.util.LOGI(sb.toString(), str);
        return iA;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0038 A[PHI: r4
  0x0038: PHI (r4v1 long) = (r4v0 long), (r4v19 long), (r4v19 long) binds: [B:13:0x0023, B:15:0x002f, B:17:0x0033] A[DONT_GENERATE, DONT_INLINE]] */
    private int RegSubmitMobile(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i, int i2, int i3, long j, long j2, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        byte[] bArr5;
        long j3;
        byte[] bArr6;
        if (bArr2 == null || bArr2.length <= 0 || bArr4 == null) {
            return oicq.wlogin_sdk.tools.util.E_INPUT;
        }
        byte[] bArr7 = bArr == null ? new byte[0] : bArr;
        byte[] bArr8 = oicq.wlogin_sdk.request.t.E;
        long j4 = 0;
        byte[] bArr9 = new byte[0];
        oicq.wlogin_sdk.request.WloginLastLoginInfo wloginLastLoginInfoGetLastLoginInfo = GetLastLoginInfo();
        if (wloginLastLoginInfoGetLastLoginInfo != null) {
            j4 = wloginLastLoginInfoGetLastLoginInfo.mUin;
            oicq.wlogin_sdk.request.Ticket ticketGetLocalTicket = GetLocalTicket(wloginLastLoginInfoGetLastLoginInfo.mAccount, j, 64);
            if (ticketGetLocalTicket == null || (bArr6 = ticketGetLocalTicket._sig) == null) {
                bArr5 = bArr9;
                j3 = j4;
            } else {
                j3 = j4;
                bArr5 = bArr6;
            }
        } else {
            bArr5 = bArr9;
            j3 = j4;
        }
        oicq.wlogin_sdk.tools.util.LOGI("has uin? " + j3 + ", a2: " + bArr5.length);
        oicq.wlogin_sdk.tools.util.LOGI("RegSubmitMobile mobile ..." + new java.lang.String(bArr2) + " appname: " + new java.lang.String(bArr8) + "...", "");
        this.mRegStatus.c = new java.lang.String(bArr2);
        oicq.wlogin_sdk.a.f fVar = new oicq.wlogin_sdk.a.f();
        oicq.wlogin_sdk.request.TransReqContext transReqContext = new oicq.wlogin_sdk.request.TransReqContext();
        oicq.wlogin_sdk.a.h hVar = this.mRegStatus;
        hVar.k = bArr2;
        hVar.g = j;
        hVar.h = j2;
        transReqContext.set_register_req();
        transReqContext.set_subcmd(fVar.a());
        transReqContext._body = fVar.a(bArr2, bArr8, bArr4, i, i2, i3, j, j2, null, oicq.wlogin_sdk.tools.util.generateGuid(this.mContext), oicq.wlogin_sdk.tools.util.get_IMSI(this.mContext), oicq.wlogin_sdk.request.t.aa, j3, bArr5, GetGuid(), bArr7, wUserSigInfo.extraRegTLVMap);
        return RequestTransport(0, 1, null, 0L, hVar.i, transReqContext, wUserSigInfo);
    }

    private int RequestInit() {
        int iShareKeyInit;
        oicq.wlogin_sdk.tools.d.a(this.mContext);
        synchronized (this) {
            int i = oicq.wlogin_sdk.tools.util.get_saved_network_type(this.mContext);
            oicq.wlogin_sdk.request.t.d();
            iShareKeyInit = ShareKeyInit();
            AsyncGenRSAKey();
            oicq.wlogin_sdk.tools.util.LOGI("init ok ret:" + iShareKeyInit + " os ver:" + new java.lang.String(oicq.wlogin_sdk.request.t.J) + " saved_network_type:" + i + " network_type:" + oicq.wlogin_sdk.request.t.D + " svn " + oicq.wlogin_sdk.tools.util.SVN_VER + " at " + oicq.wlogin_sdk.request.t.l(), "");
        }
        return iShareKeyInit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int RequestReport(int i, byte[] bArr, byte[] bArr2, long j, long j2) {
        if (i == 0) {
            new oicq.wlogin_sdk.request.WtloginHelper.HelperThread(this, this.mHelperHandler, bArr, bArr2, j, j2, "RequestReport").RunReq(7);
            return oicq.wlogin_sdk.tools.util.E_PENDING;
        }
        oicq.wlogin_sdk.request.t tVarA = this.mG.a(0L);
        tVarA.f = j;
        oicq.wlogin_sdk.tools.util.LOGI("user:" + j + " appid:" + j2 + " Seq:" + tVarA.h + " RequestReport...", "" + j);
        int iA = new oicq.wlogin_sdk.request.z(tVarA).a(j, (byte[]) null, bArr, bArr2, j2, new oicq.wlogin_sdk.request.WUserSigInfo());
        tVarA.i();
        oicq.wlogin_sdk.tools.util.LOGI("user:" + j + " appid:" + j2 + " Seq:" + tVarA.h + " RequestReport ret=" + iA, "" + j);
        return iA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int RequestReportError(int i, byte[] bArr, byte[] bArr2, long j, long j2, int i2) {
        if (i == 0) {
            new oicq.wlogin_sdk.request.WtloginHelper.HelperThread(this, this.mHelperHandler, bArr, bArr2, j, j2, i2, "RequestReportError").RunReq(8);
            return oicq.wlogin_sdk.tools.util.E_PENDING;
        }
        oicq.wlogin_sdk.request.t tVarA = this.mG.a(0L);
        tVarA.d = this.mG.d;
        tVarA.f = j;
        oicq.wlogin_sdk.tools.util.LOGI("user:" + j + " appid:" + j2 + " Seq:" + tVarA.h + " RequestReportError...", "" + j);
        int iA = new oicq.wlogin_sdk.request.u(tVarA).a(j, null, bArr, bArr2, j2, i2);
        oicq.wlogin_sdk.tools.util.LOGI("user:" + j + " appid:" + j2 + " Seq:" + tVarA.h + " RequestReportError ret=" + iA, "" + j);
        return iA;
    }

    private int ShareKeyInit() {
        oicq.wlogin_sdk.tools.util.LOGI("start ShareKeyInit", "");
        oicq.wlogin_sdk.tools.EcdhCrypt ecdhCrypt = new oicq.wlogin_sdk.tools.EcdhCrypt(this.mContext);
        if (this.isForLocal) {
            return ecdhCrypt.initShareKeyByDefault();
        }
        int iInitShareKey = ecdhCrypt.initShareKey();
        oicq.wlogin_sdk.tools.util.LOGI("end ShareKeyInit", "");
        this.mG.n = ecdhCrypt.get_c_pub_key();
        this.mG.p = ecdhCrypt.get_g_share_key();
        return iInitShareKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int VerifySMSVerifyLoginCode(java.lang.String str, java.lang.String str2, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo, int i) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            return oicq.wlogin_sdk.tools.util.E_INPUT;
        }
        if (i == 0) {
            new oicq.wlogin_sdk.request.WtloginHelper.HelperThread(this, this.mHelperHandler, str, str2, wUserSigInfo, "VerifySMSVerifyLoginCode").RunReq(13);
            return oicq.wlogin_sdk.tools.util.E_PENDING;
        }
        if (wUserSigInfo._seqence == 0) {
            wUserSigInfo._seqence = this.mAysncSeq;
        }
        oicq.wlogin_sdk.request.t tVarA = this.mG.a(wUserSigInfo._seqence);
        long j = tVarA.h;
        wUserSigInfo._seqence = j;
        oicq.wlogin_sdk.request.async_context async_contextVarB = oicq.wlogin_sdk.request.t.b(j);
        oicq.wlogin_sdk.tools.util.LOGI("user:" + tVarA.g + " code:" + str2 + " Seq:" + tVarA.h + " VerifySMSVerifyLoginCode ...", str);
        tVarA.g = str;
        async_contextVarB._last_err_msg = new oicq.wlogin_sdk.tools.ErrMsg();
        async_contextVarB._mpasswd = oicq.wlogin_sdk.tools.util.get_mpasswd();
        int iA = new oicq.wlogin_sdk.request.x(tVarA).a(str2, this.mMiscBitmap, this.mSubSigMap, null, wUserSigInfo);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("user:");
        sb.append(str);
        sb.append(" code:");
        sb.append(str2);
        sb.append(" Seq:");
        sb.append(tVarA.h);
        sb.append(" VerifySMSVerifyLoginAccount ret=");
        sb.append(iA > 0 ? java.lang.Integer.toHexString(iA) : java.lang.Integer.valueOf(iA));
        oicq.wlogin_sdk.tools.util.LOGI(sb.toString(), str);
        return iA;
    }

    public static void customizeLogDir(java.lang.String str) {
        oicq.wlogin_sdk.request.t.at = str;
        oicq.wlogin_sdk.tools.util.LOGI("set log dir " + str, "");
    }

    public static java.lang.String getLoginResultField(oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        oicq.wlogin_sdk.tlv_type.tlv_t tlv_tVar = (oicq.wlogin_sdk.tlv_type.tlv_t) wUserSigInfo.loginResultTLVMap.get(new java.lang.Integer(1320));
        if (tlv_tVar == null) {
            oicq.wlogin_sdk.tools.util.LOGI("getLoginResultField get null", wUserSigInfo.uin);
            return "";
        }
        java.lang.String str = new java.lang.String(tlv_tVar.get_data());
        oicq.wlogin_sdk.tools.util.LOGI("getLoginResultField get str " + str, wUserSigInfo.uin);
        return str;
    }

    public static byte[] getLoginTlvValue(oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo, int i) {
        oicq.wlogin_sdk.tlv_type.tlv_t tlv_tVar = (oicq.wlogin_sdk.tlv_type.tlv_t) wUserSigInfo.loginTLVMap.get(new java.lang.Integer(i));
        if (tlv_tVar != null) {
            return tlv_tVar.get_data();
        }
        return null;
    }

    public static byte[] getRegTlvValue(oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo, int i) {
        oicq.wlogin_sdk.tlv_type.tlv_t tlv_tVar = (oicq.wlogin_sdk.tlv_type.tlv_t) wUserSigInfo.regTLVMap.get(new java.lang.Integer(i));
        if (tlv_tVar != null) {
            return tlv_tVar.get_data();
        }
        return null;
    }

    private int getStWithPtSig(java.lang.String str, java.lang.String str2, oicq.wlogin_sdk.request.WtloginHelper.QuickLoginParam quickLoginParam) {
        return getStWithPtSig(str, str2, quickLoginParam, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getStWithPtSig(java.lang.String str, java.lang.String str2, oicq.wlogin_sdk.request.WtloginHelper.QuickLoginParam quickLoginParam, int i) {
        int i2;
        oicq.wlogin_sdk.request.Ticket ticket;
        oicq.wlogin_sdk.request.async_context async_contextVar;
        oicq.wlogin_sdk.tlv_type.tlv_t150 tlv_t150Var;
        if (i == 0) {
            new oicq.wlogin_sdk.request.WtloginHelper.HelperThread(this, this.mHelperHandler, str, str2, quickLoginParam, "getStWithPtSig").RunReq(16);
            return oicq.wlogin_sdk.tools.util.E_PENDING;
        }
        oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo = quickLoginParam.userSigInfo;
        wUserSigInfo.uin = str;
        oicq.wlogin_sdk.request.t tVarA = this.mG.a(0L);
        tVarA.f = java.lang.Long.parseLong(str);
        tVarA.g = quickLoginParam.userAccount;
        long j = tVarA.h;
        wUserSigInfo._seqence = j;
        this.mAysncSeq = j;
        oicq.wlogin_sdk.request.async_context async_contextVarB = oicq.wlogin_sdk.request.t.b(j);
        oicq.wlogin_sdk.tools.util.LOGI("getStWithPtSig seq:" + tVarA.h, str);
        async_contextVarB._last_err_msg = new oicq.wlogin_sdk.tools.ErrMsg();
        quickLoginParam.sigMap = quickLoginParam.sigMap | 192;
        async_contextVarB._mpasswd = oicq.wlogin_sdk.tools.util.get_mpasswd();
        async_contextVarB._msalt = oicq.wlogin_sdk.tools.util.constructSalt();
        long j2 = quickLoginParam.appid;
        async_contextVarB._sappid = j2;
        async_contextVarB._appid = j2;
        async_contextVarB._sub_appid = quickLoginParam.subAppid;
        async_contextVarB._main_sigmap = quickLoginParam.sigMap;
        async_contextVarB._sub_appid_list = quickLoginParam.dstSubAppidList;
        int iA = new oicq.wlogin_sdk.request.c(tVarA, str2).a(this.mMiscBitmap, this.mSubSigMap, wUserSigInfo);
        if (iA != 0) {
            oicq.wlogin_sdk.tools.util.LOGI("VerifyPTSig seq " + tVarA.h + " ret " + iA, str);
            return iA;
        }
        async_contextVarB._tmp_pwd = oicq.wlogin_sdk.tools.MD5.toMD5Byte(async_contextVarB._mpasswd.getBytes());
        oicq.wlogin_sdk.request.l lVar = new oicq.wlogin_sdk.request.l(tVarA, this.mContext);
        lVar.g();
        int iA2 = lVar.a(quickLoginParam.appid, quickLoginParam.subAppid, tVarA.f, 0, oicq.wlogin_sdk.request.t.ad, oicq.wlogin_sdk.tools.util.getRequestInitTime(), async_contextVarB._tmp_pwd, 4, this.mMiscBitmap, this.mSubSigMap, quickLoginParam.dstSubAppidList, quickLoginParam.sigMap, quickLoginParam.subAppid, oicq.wlogin_sdk.request.t.y, 0, 0, 1, oicq.wlogin_sdk.request.t.aa, wUserSigInfo);
        if (iA2 == 204) {
            iA2 = new oicq.wlogin_sdk.request.q(tVarA).a(this.mMiscBitmap, this.mSubSigMap, quickLoginParam.dstSubAppidList, wUserSigInfo);
        }
        int i3 = iA2;
        if (i3 != 0) {
            oicq.wlogin_sdk.tools.util.LOGI("getStWithPtSig seq:" + tVarA.h + " ret:" + i3, str);
            return i3;
        }
        oicq.wlogin_sdk.sharemem.WloginSigInfo wloginSigInfoA = tVarA.a(tVarA.f, quickLoginParam.appid);
        if (wloginSigInfoA == null) {
            return oicq.wlogin_sdk.tools.util.E_NO_KEY;
        }
        wUserSigInfo.get_clone(wloginSigInfoA);
        long[] jArr = quickLoginParam.dstSubAppidList;
        if (jArr != null) {
            wUserSigInfo.stList = new byte[jArr.length * 2][];
            int i4 = 0;
            while (true) {
                long[] jArr2 = quickLoginParam.dstSubAppidList;
                if (i4 >= jArr2.length) {
                    break;
                }
                oicq.wlogin_sdk.sharemem.WloginSigInfo wloginSigInfoA2 = tVarA.a(tVarA.f, jArr2[i4]);
                if (wloginSigInfoA2 != null) {
                    int i5 = i4 * 2;
                    wUserSigInfo.stList[i5] = (byte[]) wloginSigInfoA2._userSt_Key.clone();
                    wUserSigInfo.stList[i5 + 1] = (byte[]) wloginSigInfoA2._userStSig.clone();
                }
                i4++;
            }
        }
        oicq.wlogin_sdk.request.Ticket ticketGetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo, 128);
        if (ticketGetUserSigInfoTicket == null) {
            ticketGetUserSigInfoTicket = new oicq.wlogin_sdk.request.Ticket();
        }
        oicq.wlogin_sdk.request.Ticket ticket2 = ticketGetUserSigInfoTicket;
        oicq.wlogin_sdk.request.t.an.commit_t2(tVarA.f, tVarA.g, oicq.wlogin_sdk.tools.util.format_ret_code(i3), i3);
        if (i3 != 0) {
            i2 = i3;
            ticket = ticket2;
            async_contextVar = async_contextVarB;
            if (i2 != 2 && i2 != 160) {
                RequestReportError(0, ticket._sig, ticket._sig_key, tVarA.f, async_contextVar._appid, 0);
            }
            tlv_t150Var = tVarA.d;
            if (tlv_t150Var != null && tlv_t150Var.get_bitmap() != 0) {
                this.mG.d = tVarA.d;
                RequestReportError(0, ticket._sig, ticket._sig_key, tVarA.f, async_contextVar._appid, 1);
            }
            oicq.wlogin_sdk.request.t.b();
            tVarA.h();
            oicq.wlogin_sdk.tools.util.LOGI("getStWithPtSig seq:" + tVarA.h + " ret " + i2, str);
            return i2;
        }
        byte[] bArr = ticket2._sig;
        if (bArr == null || bArr.length == 0) {
            i2 = i3;
            ticket = ticket2;
            async_contextVar = async_contextVarB;
        } else {
            i2 = i3;
            ticket = ticket2;
            async_contextVar = async_contextVarB;
            RequestReport(0, bArr, ticket2._sig_key, tVarA.f, async_contextVarB._appid);
        }
        tlv_t150Var = tVarA.d;
        if (tlv_t150Var != null) {
            this.mG.d = tVarA.d;
            RequestReportError(0, ticket._sig, ticket._sig_key, tVarA.f, async_contextVar._appid, 1);
        }
        oicq.wlogin_sdk.request.t.b();
        tVarA.h();
        oicq.wlogin_sdk.tools.util.LOGI("getStWithPtSig seq:" + tVarA.h + " ret " + i2, str);
        return i2;
    }

    private int getStWithQQSig(java.lang.String str, oicq.wlogin_sdk.request.WtloginHelper.QuickLoginParam quickLoginParam) {
        return getStWithQQSig(str, quickLoginParam, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getStWithQQSig(java.lang.String str, oicq.wlogin_sdk.request.WtloginHelper.QuickLoginParam quickLoginParam, int i) {
        java.lang.StringBuilder sb;
        int i2;
        oicq.wlogin_sdk.request.Ticket ticket;
        oicq.wlogin_sdk.request.async_context async_contextVar;
        int i3;
        oicq.wlogin_sdk.tlv_type.tlv_t150 tlv_t150Var;
        if (i == 0) {
            new oicq.wlogin_sdk.request.WtloginHelper.HelperThread(this, this.mHelperHandler, str, quickLoginParam, "getStWithQQSig").RunReq(15);
            return oicq.wlogin_sdk.tools.util.E_PENDING;
        }
        oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo = quickLoginParam.userSigInfo;
        wUserSigInfo.uin = str;
        oicq.wlogin_sdk.request.t tVarA = this.mG.a(0L);
        long j = tVarA.h;
        wUserSigInfo._seqence = j;
        this.mAysncSeq = j;
        oicq.wlogin_sdk.request.async_context async_contextVarB = oicq.wlogin_sdk.request.t.b(j);
        int i4 = oicq.wlogin_sdk.tools.util.get_saved_network_type(this.mContext);
        int i5 = oicq.wlogin_sdk.tools.util.get_network_type(this.mContext);
        oicq.wlogin_sdk.request.t.D = i5;
        int i6 = 0;
        if (i4 != i5) {
            oicq.wlogin_sdk.tools.util.set_net_retry_type(this.mContext, 0);
            oicq.wlogin_sdk.tools.util.save_network_type(this.mContext, oicq.wlogin_sdk.request.t.D);
        }
        oicq.wlogin_sdk.request.t.F = oicq.wlogin_sdk.tools.util.get_apn_string(this.mContext).getBytes();
        quickLoginParam.sigMap |= 192;
        tVarA.g = str;
        tVarA.f = java.lang.Long.parseLong(str);
        long j2 = quickLoginParam.appid;
        async_contextVarB._sappid = j2;
        async_contextVarB._appid = j2;
        async_contextVarB._sub_appid = quickLoginParam.subAppid;
        async_contextVarB._main_sigmap = quickLoginParam.sigMap;
        async_contextVarB._login_bitmap = wUserSigInfo._login_bitmap;
        async_contextVarB._last_err_msg = new oicq.wlogin_sdk.tools.ErrMsg();
        long[] jArr = quickLoginParam.dstSubAppidList;
        async_contextVarB._sub_appid_list = jArr != null ? (long[]) jArr.clone() : null;
        byte[] bArr = wUserSigInfo._reserveData;
        if (bArr == null || bArr.length <= 3) {
            tVarA.i = 0;
        } else {
            tVarA.i = oicq.wlogin_sdk.tools.util.buf_to_int32(bArr, 0);
            oicq.wlogin_sdk.tools.util.LOGI("MSF SSO SEQ:" + tVarA.i, str);
        }
        byte[] bArr2 = wUserSigInfo._fastLoginBuf;
        if (bArr2 == null || bArr2.length == 0) {
            sb = new java.lang.StringBuilder();
            sb.append("fast login buff is null seq:");
            i2 = tVarA.i;
        } else {
            if (GetFastLoginInfo(bArr2, async_contextVarB) >= 0) {
                oicq.wlogin_sdk.request.l lVar = new oicq.wlogin_sdk.request.l(tVarA, this.mContext);
                lVar.g();
                long j3 = quickLoginParam.appid;
                long j4 = quickLoginParam.subAppid;
                int iA = lVar.a(j3, j4, tVarA.f, 0, oicq.wlogin_sdk.request.t.ad, async_contextVarB._tmp_pwd, async_contextVarB._tmp_no_pic_sig, this.mMiscBitmap, this.mSubSigMap, quickLoginParam.dstSubAppidList, quickLoginParam.sigMap, j4, oicq.wlogin_sdk.request.t.y, 0, 0, 1, oicq.wlogin_sdk.request.t.aa, wUserSigInfo);
                if (iA == 204) {
                    iA = new oicq.wlogin_sdk.request.q(tVarA).a(this.mMiscBitmap, this.mSubSigMap, quickLoginParam.dstSubAppidList, wUserSigInfo);
                }
                int i7 = iA;
                if (i7 != 0) {
                    oicq.wlogin_sdk.tools.util.LOGI("getStWithQQSig seq:" + tVarA.h + " ret:" + i7, str);
                    return i7;
                }
                oicq.wlogin_sdk.sharemem.WloginSigInfo wloginSigInfoA = tVarA.a(tVarA.f, quickLoginParam.appid);
                if (wloginSigInfoA == null) {
                    return oicq.wlogin_sdk.tools.util.E_NO_KEY;
                }
                wUserSigInfo.get_clone(wloginSigInfoA);
                long[] jArr2 = quickLoginParam.dstSubAppidList;
                if (jArr2 != null) {
                    wUserSigInfo.stList = new byte[jArr2.length * 2][];
                    while (true) {
                        long[] jArr3 = quickLoginParam.dstSubAppidList;
                        if (i6 >= jArr3.length) {
                            break;
                        }
                        oicq.wlogin_sdk.sharemem.WloginSigInfo wloginSigInfoA2 = tVarA.a(tVarA.f, jArr3[i6]);
                        if (wloginSigInfoA2 != null) {
                            int i8 = i6 * 2;
                            wUserSigInfo.stList[i8] = (byte[]) wloginSigInfoA2._userSt_Key.clone();
                            wUserSigInfo.stList[i8 + 1] = (byte[]) wloginSigInfoA2._userStSig.clone();
                        }
                        i6++;
                    }
                }
                oicq.wlogin_sdk.request.Ticket ticketGetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo, 128);
                if (ticketGetUserSigInfoTicket == null) {
                    ticketGetUserSigInfoTicket = new oicq.wlogin_sdk.request.Ticket();
                }
                oicq.wlogin_sdk.request.Ticket ticket2 = ticketGetUserSigInfoTicket;
                oicq.wlogin_sdk.request.t.an.commit_t2(tVarA.f, tVarA.g, oicq.wlogin_sdk.tools.util.format_ret_code(i7), i7);
                if (i7 != 0) {
                    ticket = ticket2;
                    async_contextVar = async_contextVarB;
                    i3 = i7;
                    if (i3 != 2 && i3 != 160) {
                        RequestReportError(0, ticket._sig, ticket._sig_key, tVarA.f, async_contextVar._appid, 0);
                    }
                    tlv_t150Var = tVarA.d;
                    if (tlv_t150Var != null && tlv_t150Var.get_bitmap() != 0) {
                        this.mG.d = tVarA.d;
                        RequestReportError(0, ticket._sig, ticket._sig_key, tVarA.f, async_contextVar._appid, 1);
                    }
                    oicq.wlogin_sdk.request.t.b();
                    tVarA.h();
                    oicq.wlogin_sdk.tools.util.LOGI("getStWithQQSig seq:" + tVarA.h + " ret:" + i3, str);
                    return i3;
                }
                byte[] bArr3 = ticket2._sig;
                if (bArr3 == null || bArr3.length == 0) {
                    ticket = ticket2;
                    async_contextVar = async_contextVarB;
                    i3 = i7;
                } else {
                    ticket = ticket2;
                    async_contextVar = async_contextVarB;
                    i3 = i7;
                    RequestReport(0, bArr3, ticket2._sig_key, tVarA.f, async_contextVarB._appid);
                }
                tlv_t150Var = tVarA.d;
                if (tlv_t150Var != null) {
                    this.mG.d = tVarA.d;
                    RequestReportError(0, ticket._sig, ticket._sig_key, tVarA.f, async_contextVar._appid, 1);
                }
                oicq.wlogin_sdk.request.t.b();
                tVarA.h();
                oicq.wlogin_sdk.tools.util.LOGI("getStWithQQSig seq:" + tVarA.h + " ret:" + i3, str);
                return i3;
            }
            sb = new java.lang.StringBuilder();
            sb.append("GetFastLoginInfo fast login buff is failed seq:");
            i2 = tVarA.i;
        }
        sb.append(i2);
        oicq.wlogin_sdk.tools.util.LOGI(sb.toString(), str);
        return oicq.wlogin_sdk.tools.util.E_INPUT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getStWithQrSig(java.lang.String str, long j, long j2, int i, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo, int i2) {
        int i3;
        int i4;
        oicq.wlogin_sdk.request.t tVar;
        oicq.wlogin_sdk.request.async_context async_contextVar;
        int i5;
        oicq.wlogin_sdk.request.Ticket ticket;
        int i6;
        int i7;
        oicq.wlogin_sdk.request.Ticket ticket2;
        int iA;
        java.lang.String str2;
        if (str == null || wUserSigInfo == null) {
            return oicq.wlogin_sdk.tools.util.E_INPUT;
        }
        int i8 = i | 192;
        if (i2 == 0) {
            new oicq.wlogin_sdk.request.WtloginHelper.HelperThread(this, this.mHelperHandler, str, j, i8, j2, wUserSigInfo, "getStWithQrSig").RunReq(17);
            return oicq.wlogin_sdk.tools.util.E_PENDING;
        }
        oicq.wlogin_sdk.request.t tVarA = this.mG.a(0L);
        long j3 = tVarA.h;
        wUserSigInfo._seqence = j3;
        this.mAysncSeq = j3;
        oicq.wlogin_sdk.a.h.z = "";
        oicq.wlogin_sdk.request.async_context async_contextVarB = oicq.wlogin_sdk.request.t.b(j3);
        oicq.wlogin_sdk.tools.util.LOGI("start getStWithQrSig:user:" + str + " appid:" + j + " sigMap:0x" + java.lang.Integer.toHexString(i8) + " subAppid:" + j2 + " Seq:" + tVarA.h, str);
        int i9 = oicq.wlogin_sdk.tools.util.get_saved_network_type(this.mContext);
        int i10 = oicq.wlogin_sdk.tools.util.get_network_type(this.mContext);
        oicq.wlogin_sdk.request.t.D = i10;
        if (i9 != i10) {
            oicq.wlogin_sdk.tools.util.set_net_retry_type(this.mContext, 0);
            oicq.wlogin_sdk.tools.util.save_network_type(this.mContext, oicq.wlogin_sdk.request.t.D);
        }
        oicq.wlogin_sdk.request.t.F = oicq.wlogin_sdk.tools.util.get_apn_string(this.mContext).getBytes();
        if (!oicq.wlogin_sdk.tools.util.check_uin_account(str).booleanValue()) {
            oicq.wlogin_sdk.tools.util.LOGI("userAccount " + str + " isn't valid", "");
            return oicq.wlogin_sdk.tools.util.E_INPUT;
        }
        long j4 = java.lang.Long.parseLong(str);
        wUserSigInfo.uin = str;
        tVarA.g = str;
        tVarA.f = j4;
        async_contextVarB._sappid = j;
        async_contextVarB._appid = j;
        async_contextVarB._sub_appid_list = null;
        async_contextVarB._sub_appid = j2;
        async_contextVarB._main_sigmap = i8;
        async_contextVarB._login_bitmap = wUserSigInfo._login_bitmap;
        async_contextVarB._last_err_msg = new oicq.wlogin_sdk.tools.ErrMsg();
        byte[] bArr = wUserSigInfo._reserveData;
        if (bArr == null || bArr.length <= 3) {
            tVarA.i = 0;
        } else {
            tVarA.i = oicq.wlogin_sdk.tools.util.buf_to_int32(bArr, 0);
            oicq.wlogin_sdk.tools.util.LOGI("MSF SSO SEQ:" + tVarA.i, str);
        }
        oicq.wlogin_sdk.request.t.an.add_t2(new oicq.wlogin_sdk.report.report_t2("login", new java.lang.String(oicq.wlogin_sdk.request.t.C), java.lang.System.currentTimeMillis(), j, j2, null));
        byte[] bArr2 = oicq.wlogin_sdk.code2d.c.q;
        if (bArr2 != null && bArr2.length > 0) {
            async_contextVarB._tmp_pwd = bArr2;
            byte[] bArr3 = oicq.wlogin_sdk.code2d.c.r;
            async_contextVarB._tmp_no_pic_sig = bArr3;
            if (bArr3 == null || bArr3.length == 0) {
                str2 = "no pic sig length is 0";
            } else {
                str2 = "no pic sig length " + async_contextVarB._tmp_no_pic_sig.length;
            }
            oicq.wlogin_sdk.tools.util.LOGI(str2, str);
            async_contextVarB.tgtQR = oicq.wlogin_sdk.code2d.c.s;
            oicq.wlogin_sdk.code2d.c.q = null;
            oicq.wlogin_sdk.code2d.c.r = null;
            oicq.wlogin_sdk.code2d.c.s = null;
        }
        byte[] bArr4 = async_contextVarB._tmp_pwd;
        if (bArr4 == null || bArr4.length < 16) {
            i3 = oicq.wlogin_sdk.tools.util.E_A1_FORMAT;
        } else {
            async_contextVarB._tmp_pwd_type = 1;
            byte[] bArr5 = wUserSigInfo._in_ksid;
            byte[] bArr6 = (bArr5 == null || bArr5.length <= 0) ? oicq.wlogin_sdk.request.t.aa : (byte[]) bArr5.clone();
            if (async_contextVarB._tmp_pwd_type != 0) {
                oicq.wlogin_sdk.tools.util.LOGI("user:" + str + " login with qrsig", str);
                oicq.wlogin_sdk.request.l lVar = new oicq.wlogin_sdk.request.l(tVarA, this.mContext);
                lVar.g();
                iA = lVar.a(j, j2, tVarA.f, 0, oicq.wlogin_sdk.request.t.ad, async_contextVarB._tmp_pwd, async_contextVarB._tmp_no_pic_sig, this.mMiscBitmap, this.mSubSigMap, null, i8, j2, oicq.wlogin_sdk.request.t.y, 0, 0, 1, bArr6, wUserSigInfo);
            } else {
                iA = 0;
            }
            if (iA == 204) {
                iA = new oicq.wlogin_sdk.request.q(tVarA).a(this.mMiscBitmap, this.mSubSigMap, (long[]) null, wUserSigInfo);
            }
            if (iA == 0 || iA == 160) {
                oicq.wlogin_sdk.sharemem.WloginSigInfo wloginSigInfoA = tVarA.a(j4, j);
                if (wloginSigInfoA == null) {
                    i3 = oicq.wlogin_sdk.tools.util.E_NO_KEY;
                } else {
                    wUserSigInfo.get_clone(wloginSigInfoA);
                    i3 = iA;
                }
            } else {
                i3 = iA;
            }
        }
        oicq.wlogin_sdk.request.Ticket ticketGetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo, 128);
        if (ticketGetUserSigInfoTicket == null) {
            ticketGetUserSigInfoTicket = new oicq.wlogin_sdk.request.Ticket();
        }
        oicq.wlogin_sdk.request.Ticket ticket3 = ticketGetUserSigInfoTicket;
        oicq.wlogin_sdk.request.t.an.commit_t2(tVarA.f, tVarA.g, oicq.wlogin_sdk.tools.util.format_ret_code(i3), i3);
        if (i3 == 0) {
            byte[] bArr7 = ticket3._sig;
            if (bArr7 == null || bArr7.length == 0) {
                tVar = tVarA;
                async_contextVar = async_contextVarB;
                i7 = i3;
                ticket2 = ticket3;
                i6 = i8;
            } else {
                i4 = i3;
                i5 = i8;
                ticket = ticket3;
                tVar = tVarA;
                async_contextVar = async_contextVarB;
                RequestReport(0, bArr7, ticket3._sig_key, tVarA.f, async_contextVarB._appid);
                i6 = i5;
                i7 = i4;
                ticket2 = ticket;
            }
        } else {
            i4 = i3;
            tVar = tVarA;
            async_contextVar = async_contextVarB;
            i5 = i8;
            ticket = ticket3;
            if (i4 == 2 || i4 == 160) {
                i6 = i5;
                i7 = i4;
                ticket2 = ticket;
            } else {
                i6 = i5;
                i7 = i4;
                ticket2 = ticket;
                RequestReportError(0, ticket._sig, ticket._sig_key, tVar.f, async_contextVar._appid, 0);
            }
        }
        oicq.wlogin_sdk.tlv_type.tlv_t150 tlv_t150Var = tVar.d;
        if (tlv_t150Var != null && tlv_t150Var.get_bitmap() != 0) {
            this.mG.d = tVar.d;
            RequestReportError(0, ticket2._sig, ticket2._sig_key, tVar.f, async_contextVar._appid, 1);
        }
        oicq.wlogin_sdk.request.t.b();
        tVar.h();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("end getStWithQrSig user:");
        sb.append(str);
        sb.append(" appid:");
        sb.append(j);
        sb.append(" sigMap:0x");
        sb.append(java.lang.Integer.toHexString(i6));
        sb.append(" subAppid:");
        sb.append(j2);
        sb.append(" Seq:");
        sb.append(tVar.h);
        sb.append(" ret=");
        int i11 = i7;
        sb.append(i11);
        oicq.wlogin_sdk.tools.util.LOGI(sb.toString(), "" + tVar.f);
        return i11;
    }

    private int isPskeyExpired(int i, java.lang.String[] strArr, oicq.wlogin_sdk.request.Ticket ticket, long j, int i2) {
        java.lang.String strSubstring;
        boolean z;
        boolean z2;
        int i3;
        if (i != 1048576 || strArr == null || strArr.length <= 0) {
            return 0;
        }
        int length = strArr.length;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            boolean z3 = true;
            if (i4 >= length) {
                break;
            }
            java.lang.String str = strArr[i4];
            if (str != null && str.length() != 0) {
                int iIndexOf = str.indexOf(40);
                int iIndexOf2 = str.indexOf(41);
                if (iIndexOf != 0 || iIndexOf2 <= 0) {
                    strSubstring = str;
                    z = false;
                    z2 = true;
                } else {
                    int iIntValue = java.lang.Integer.valueOf(str.substring(iIndexOf + 1, iIndexOf2)).intValue();
                    z2 = (iIntValue & 1048576) > 0;
                    z = (iIntValue & oicq.wlogin_sdk.request.WtloginHelper.SigType.WLOGIN_PT4Token) > 0;
                    strSubstring = str.substring(iIndexOf2 + 1);
                }
                boolean z4 = z2 && (ticket._pskey_map.get(strSubstring) == null || oicq.wlogin_sdk.request.Ticket.isPskeyExpired(((java.lang.Long) ticket._pskey_expire.get(strSubstring)).longValue()));
                if (!z || (ticket._pt4token_map.get(strSubstring) != null && !oicq.wlogin_sdk.request.Ticket.isPskeyExpired(((java.lang.Long) ticket._pt4token_expire.get(strSubstring)).longValue()))) {
                    z3 = false;
                }
                if (z4 || z3) {
                    i3 = i5 + 1;
                    strArr[i5] = str;
                    oicq.wlogin_sdk.tools.util.LOGI("[REDACTED]" + strSubstring + "[REDACTED]" + z4 + "[REDACTED]" + z3, "[REDACTED]");
                } else {
                    i3 = i5;
                }
                oicq.wlogin_sdk.tools.util.LOGI("[REDACTED]" + strSubstring + "[REDACTED]" + z2 + "[REDACTED]" + z, "[REDACTED]");
                i5 = i3;
            }
            i4++;
        }
        if (i5 == 0) {
            return 3;
        }
        while (i5 < strArr.length) {
            oicq.wlogin_sdk.tools.util.LOGI("isPskeyExpired domain " + strArr[i5] + " cleared", "");
            strArr[i5] = null;
            i5++;
        }
        if (i2 == 1) {
            return 1;
        }
        RefreshMemorySig();
        return 2;
    }

    private void localInit(android.content.Context context, boolean z) {
        this.isForLocal = z;
        try {
            this.mContext = context.getApplicationContext();
        } catch (java.lang.Throwable th) {
            this.mContext = context;
            oicq.wlogin_sdk.tools.util.printThrowable(th, "");
        }
        this.mG.b(context);
        RequestInit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.os.Handler newHelperHandler() {
        try {
            if (android.os.Looper.myLooper() == null) {
                return null;
            }
            return new android.os.Handler();
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    private void printTicket(oicq.wlogin_sdk.sharemem.WloginSigInfo wloginSigInfo) {
        oicq.wlogin_sdk.tools.util.LOGI("a1 " + wloginSigInfo._en_A1.length);
        oicq.wlogin_sdk.tools.util.LOGI("a2 " + wloginSigInfo._TGT.length);
        oicq.wlogin_sdk.tools.util.LOGI("skey " + wloginSigInfo._sKey.length);
        oicq.wlogin_sdk.tools.util.LOGI("pskey " + wloginSigInfo._psKey.length);
        oicq.wlogin_sdk.tools.util.LOGI("superkey " + wloginSigInfo._superKey.length);
        oicq.wlogin_sdk.tools.util.LOGI("d2 " + wloginSigInfo._D2.length);
        oicq.wlogin_sdk.tools.util.LOGI("d2key " + wloginSigInfo._D2Key.length);
    }

    public static void setCustomerGuid(android.content.Context context, byte[] bArr) throws java.lang.Throwable {
        oicq.wlogin_sdk.tools.util.LOGI("set customer guid " + oicq.wlogin_sdk.tools.util.buf_to_string(bArr), "");
        oicq.wlogin_sdk.request.t.ai = bArr;
        oicq.wlogin_sdk.tools.util.saveGuidToFile(context, bArr);
    }

    public static void setExtraLoginTlvValue(oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo, int i, byte[] bArr) {
        java.lang.Integer num = new java.lang.Integer(i);
        oicq.wlogin_sdk.tlv_type.tlv_t tlv_tVar = new oicq.wlogin_sdk.tlv_type.tlv_t(i);
        tlv_tVar.set_data(bArr, bArr.length);
        wUserSigInfo.extraLoginTLVMap.put(num, tlv_tVar);
    }

    public static void setExtraRegTlvValue(oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo, int i, byte[] bArr) {
        java.lang.Integer num = new java.lang.Integer(i);
        oicq.wlogin_sdk.tlv_type.RegTLV regTLV = new oicq.wlogin_sdk.tlv_type.RegTLV(i);
        regTLV.set_data(bArr, bArr.length);
        wUserSigInfo.extraRegTLVMap.put(num, regTLV);
    }

    public static void setExtraRegTlvValueWatchQQLicense(oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo, byte[] bArr) {
        setExtraRegTlvValue(wUserSigInfo, 38, bArr);
    }

    public static void setLoadEncryptSo(boolean z) {
        oicq.wlogin_sdk.tools.util.loadEncryptSo = z;
    }

    public static void setLoadSoFlg(boolean z) {
        oicq.wlogin_sdk.request.t.as = z;
    }

    public static void setProductType(int i) {
        oicq.wlogin_sdk.request.t.au = i;
    }

    public static void setRegisterFlg(int i) {
        oicq.wlogin_sdk.request.t.ah = i | oicq.wlogin_sdk.request.t.ah;
    }

    private void tlvCommRsp2ErrMsg(oicq.wlogin_sdk.devicelock.TLV_CommRsp tLV_CommRsp, oicq.wlogin_sdk.tools.ErrMsg errMsg) {
        if (tLV_CommRsp == null || tLV_CommRsp.get_data_len() == 0) {
            return;
        }
        errMsg.setType(tLV_CommRsp.ErrInfoType);
        errMsg.setOtherinfo(new java.lang.String(tLV_CommRsp.ErrInfo));
        errMsg.setTitle(new java.lang.String(tLV_CommRsp.ErrTitle));
        errMsg.setMessage(new java.lang.String(tLV_CommRsp.ErrMsg));
    }

    public int AskDevLockSms(java.lang.String str, long j, long j2, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        if (str == null) {
            return oicq.wlogin_sdk.tools.util.E_INPUT;
        }
        oicq.wlogin_sdk.sharemem.WloginSimpleInfo wloginSimpleInfo = new oicq.wlogin_sdk.sharemem.WloginSimpleInfo();
        if (!GetBasicUserInfo(str, wloginSimpleInfo).booleanValue()) {
            return oicq.wlogin_sdk.tools.util.E_NO_UIN;
        }
        long j3 = wloginSimpleInfo._uin;
        oicq.wlogin_sdk.tools.util.LOGI("AskDevLockSms ...", str);
        oicq.wlogin_sdk.devicelock.d dVar = new oicq.wlogin_sdk.devicelock.d();
        oicq.wlogin_sdk.request.TransReqContext transReqContext = new oicq.wlogin_sdk.request.TransReqContext();
        transReqContext.set_devlock_req();
        transReqContext.set_subcmd(dVar.get_msgType());
        byte[] bArrA = dVar.a(j3, j, j2);
        transReqContext._body = bArrA;
        return (bArrA == null || bArrA.length == 0) ? oicq.wlogin_sdk.tools.util.E_INPUT : RequestTransport(0, 1, str, j, dVar.Role, transReqContext, wUserSigInfo);
    }

    public void CancelRequest() {
        this.mG.s = 1;
    }

    public int CheckDevLockSms(java.lang.String str, long j, long j2, java.lang.String str2, byte[] bArr, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        if (str == null) {
            return oicq.wlogin_sdk.tools.util.E_INPUT;
        }
        oicq.wlogin_sdk.sharemem.WloginSimpleInfo wloginSimpleInfo = new oicq.wlogin_sdk.sharemem.WloginSimpleInfo();
        if (!GetBasicUserInfo(str, wloginSimpleInfo).booleanValue()) {
            return oicq.wlogin_sdk.tools.util.E_NO_UIN;
        }
        long j3 = wloginSimpleInfo._uin;
        oicq.wlogin_sdk.sharemem.WloginSigInfo wloginSigInfoFindUserSig = FindUserSig(j3, j);
        if (wloginSigInfoFindUserSig == null) {
            return oicq.wlogin_sdk.tools.util.E_NO_KEY;
        }
        if (bArr != null && bArr.length > 0) {
            oicq.wlogin_sdk.devicelock.DevlockBase.rst.setSppKey(bArr);
        }
        oicq.wlogin_sdk.tools.util.LOGI("CheckDevLockSms ...", str);
        oicq.wlogin_sdk.devicelock.f fVar = new oicq.wlogin_sdk.devicelock.f();
        oicq.wlogin_sdk.request.TransReqContext transReqContext = new oicq.wlogin_sdk.request.TransReqContext();
        java.lang.String str3 = android.os.Build.VERSION.RELEASE;
        if (str3 == null) {
            str3 = "";
        }
        transReqContext.set_devlock_req();
        transReqContext.set_subcmd(fVar.get_msgType());
        transReqContext.setSTEncryptMethod();
        transReqContext.setWtST(wloginSigInfoFindUserSig);
        byte[] bArrA = fVar.a(j3, j, j2, wloginSigInfoFindUserSig._TGT, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.E, oicq.wlogin_sdk.tools.util.SDK_VERSION.getBytes(), "android".getBytes(), str3.getBytes(), str2 == null ? null : str2.getBytes());
        transReqContext._body = bArrA;
        return (bArrA == null || bArrA.length == 0) ? oicq.wlogin_sdk.tools.util.E_INPUT : RequestTransport(0, 1, str, j, fVar.Role, transReqContext, wUserSigInfo);
    }

    public int CheckDevLockStatus(java.lang.String str, long j, long j2, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        if (str == null) {
            return oicq.wlogin_sdk.tools.util.E_INPUT;
        }
        oicq.wlogin_sdk.sharemem.WloginSimpleInfo wloginSimpleInfo = new oicq.wlogin_sdk.sharemem.WloginSimpleInfo();
        if (!GetBasicUserInfo(str, wloginSimpleInfo).booleanValue()) {
            return oicq.wlogin_sdk.tools.util.E_NO_UIN;
        }
        long j3 = wloginSimpleInfo._uin;
        oicq.wlogin_sdk.sharemem.WloginSigInfo wloginSigInfoFindUserSig = FindUserSig(j3, j);
        if (wloginSigInfoFindUserSig == null) {
            return oicq.wlogin_sdk.tools.util.E_NO_KEY;
        }
        oicq.wlogin_sdk.tools.util.LOGI("CheckDevLockStatus ...", str);
        oicq.wlogin_sdk.devicelock.DevlockBase.rst = new oicq.wlogin_sdk.devicelock.DevlockRst();
        oicq.wlogin_sdk.devicelock.a aVar = new oicq.wlogin_sdk.devicelock.a();
        oicq.wlogin_sdk.request.TransReqContext transReqContext = new oicq.wlogin_sdk.request.TransReqContext();
        transReqContext.set_devlock_req();
        transReqContext.set_subcmd(aVar.get_msgType());
        transReqContext.setSTEncryptMethod();
        transReqContext.setWtST(wloginSigInfoFindUserSig);
        byte[] bArrA = aVar.a(j3, j, j2, wloginSigInfoFindUserSig._TGT, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.E, oicq.wlogin_sdk.tools.util.SDK_VERSION.getBytes(), oicq.wlogin_sdk.request.t.K, oicq.wlogin_sdk.request.t.J);
        transReqContext._body = bArrA;
        return (bArrA == null || bArrA.length == 0) ? oicq.wlogin_sdk.tools.util.E_INPUT : RequestTransport(0, 1, str, j, aVar.Role, transReqContext, wUserSigInfo);
    }

    public int CheckPictureAndGetSt(java.lang.String str, byte[] bArr, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        oicq.wlogin_sdk.request.o.I = false;
        return CheckPictureAndGetSt(str, bArr, wUserSigInfo, null, 0);
    }

    public int CheckPictureAndGetSt(java.lang.String str, byte[] bArr, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo, byte[][] bArr2) {
        oicq.wlogin_sdk.request.o.I = false;
        return CheckPictureAndGetSt(str, bArr, wUserSigInfo, bArr2, 0);
    }

    public int CheckSMSAndGetSt(java.lang.String str, byte[] bArr, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        return CheckSMSAndGetSt(str, bArr, wUserSigInfo, null, 0);
    }

    public int CheckSMSAndGetSt(java.lang.String str, byte[] bArr, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo, byte[][] bArr2) {
        return CheckSMSAndGetSt(str, bArr, wUserSigInfo, bArr2, 0);
    }

    public int CheckSMSVerifyLoginAccount(long j, long j2, java.lang.String str, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        return CheckSMSVerifyLoginAccount(j, j2, str, wUserSigInfo, 0);
    }

    public int CheckWebsigAndGetSt(java.lang.String str, java.lang.String str2, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        oicq.wlogin_sdk.request.o.I = true;
        return CheckPictureAndGetSt(str, str2.getBytes(), wUserSigInfo, null, 0);
    }

    public int CheckWebsigAndGetSt(java.lang.String str, java.lang.String str2, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo, byte[][] bArr) {
        oicq.wlogin_sdk.request.o.I = true;
        return CheckPictureAndGetSt(str, str2.getBytes(), wUserSigInfo, bArr, 0);
    }

    public void ClearPSkey(java.lang.String str, long j) {
        long jB;
        oicq.wlogin_sdk.tools.util.LOGI("user:" + str + " appid:" + j + " ClearPSkey ...", str);
        if (str == null || str.length() <= 0) {
            return;
        }
        boolean z = true;
        synchronized (this) {
            if (oicq.wlogin_sdk.tools.util.check_uin_account(str).booleanValue()) {
                jB = java.lang.Long.parseLong(str);
            } else {
                jB = this.mG.b(str);
                if (jB == 0) {
                    z = false;
                }
            }
            if (z) {
                this.mG.d(jB, j);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0052 A[Catch: all -> 0x0063, TryCatch #0 {, blocks: (B:8:0x002b, B:10:0x0037, B:17:0x0052, B:18:0x0057, B:13:0x0045, B:14:0x004b), top: B:26:0x002b }] */
    public java.lang.Boolean ClearUserLoginData(java.lang.String str, long j) {
        long jB;
        boolean z;
        oicq.wlogin_sdk.tools.util.LOGI("user:" + str + " appid:" + j + " ClearUserLoginData ...", str);
        if (str == null || str.length() <= 0) {
            return java.lang.Boolean.TRUE;
        }
        synchronized (this) {
            if (oicq.wlogin_sdk.tools.util.check_uin_account(str).booleanValue()) {
                jB = java.lang.Long.parseLong(str);
            } else {
                jB = this.mG.b(str);
                if (jB == 0) {
                    z = false;
                } else {
                    this.mG.d(str);
                }
                if (z) {
                    this.mG.e(jB, j);
                }
            }
            z = true;
            if (z) {
                this.mG.e(jB, j);
            }
        }
        oicq.wlogin_sdk.sharemem.WloginSigInfo._QRPUSHSig = new byte[0];
        oicq.wlogin_sdk.sharemem.WloginSigInfo._LHSig = new byte[0];
        return java.lang.Boolean.TRUE;
    }

    public int CloseCode(java.lang.String str, long j, byte[] bArr, int i, java.util.List list, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        oicq.wlogin_sdk.sharemem.WloginSimpleInfo wloginSimpleInfo = new oicq.wlogin_sdk.sharemem.WloginSimpleInfo();
        if (!GetBasicUserInfo(str, wloginSimpleInfo).booleanValue()) {
            return oicq.wlogin_sdk.tools.util.E_NO_UIN;
        }
        long j2 = wloginSimpleInfo._uin;
        this.mG.j();
        oicq.wlogin_sdk.sharemem.WloginSigInfo wloginSigInfoFindUserSig = FindUserSig(j2, j);
        if (wloginSigInfoFindUserSig == null) {
            return oicq.wlogin_sdk.tools.util.E_NO_KEY;
        }
        oicq.wlogin_sdk.tools.util.LOGI("user:" + str + " CloseCode ...", str);
        oicq.wlogin_sdk.code2d.a aVar = new oicq.wlogin_sdk.code2d.a();
        oicq.wlogin_sdk.request.TransReqContext transReqContext = new oicq.wlogin_sdk.request.TransReqContext();
        transReqContext.set_code2d_func_req();
        transReqContext.set_subcmd(aVar.get_cmd());
        transReqContext.setSTEncryptMethod();
        transReqContext.setWtST(wloginSigInfoFindUserSig);
        transReqContext._body = aVar.a(j2, j, 1L, bArr, wloginSigInfoFindUserSig._userStSig, oicq.wlogin_sdk.request.t.A, i, list, wloginSigInfoFindUserSig._en_A1, wloginSigInfoFindUserSig._noPicSig, this.mMiscBitmap, 0L);
        return RequestTransport(0, 1, str, j, aVar._role, transReqContext, wUserSigInfo);
    }

    public int CloseDevLock(java.lang.String str, long j, long j2, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        if (str == null) {
            return oicq.wlogin_sdk.tools.util.E_INPUT;
        }
        oicq.wlogin_sdk.sharemem.WloginSimpleInfo wloginSimpleInfo = new oicq.wlogin_sdk.sharemem.WloginSimpleInfo();
        if (!GetBasicUserInfo(str, wloginSimpleInfo).booleanValue()) {
            return oicq.wlogin_sdk.tools.util.E_NO_UIN;
        }
        long j3 = wloginSimpleInfo._uin;
        oicq.wlogin_sdk.sharemem.WloginSigInfo wloginSigInfoFindUserSig = FindUserSig(j3, j);
        if (wloginSigInfoFindUserSig == null) {
            return oicq.wlogin_sdk.tools.util.E_NO_KEY;
        }
        oicq.wlogin_sdk.tools.util.LOGI("CloseDevLock ...", str);
        oicq.wlogin_sdk.devicelock.b bVar = new oicq.wlogin_sdk.devicelock.b();
        oicq.wlogin_sdk.request.TransReqContext transReqContext = new oicq.wlogin_sdk.request.TransReqContext();
        java.lang.String str2 = android.os.Build.VERSION.RELEASE;
        if (str2 == null) {
            str2 = "";
        }
        transReqContext.set_devlock_req();
        transReqContext.set_subcmd(bVar.get_msgType());
        transReqContext.setSTEncryptMethod();
        transReqContext.setWtST(wloginSigInfoFindUserSig);
        byte[] bArrA = bVar.a(j3, j, j2, wloginSigInfoFindUserSig._TGT, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.E, oicq.wlogin_sdk.tools.util.SDK_VERSION.getBytes(), "android".getBytes(), str2.getBytes());
        transReqContext._body = bArrA;
        return (bArrA == null || bArrA.length == 0) ? oicq.wlogin_sdk.tools.util.E_INPUT : RequestTransport(0, 1, str, j, bVar.Role, transReqContext, wUserSigInfo);
    }

    public int FetchCodeSig(long j, long j2, oicq.wlogin_sdk.code2d.fetch_code.QRCodeCustom qRCodeCustom, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        oicq.wlogin_sdk.tools.util.LOGI(" FetchCodeSig ...", "");
        oicq.wlogin_sdk.code2d.fetch_code fetch_codeVar = new oicq.wlogin_sdk.code2d.fetch_code();
        oicq.wlogin_sdk.request.TransReqContext transReqContext = new oicq.wlogin_sdk.request.TransReqContext();
        transReqContext.set_code2d_func_req();
        transReqContext.set_subcmd(fetch_codeVar.get_cmd());
        transReqContext._body = fetch_codeVar.get_request(0L, j, j2, new byte[0], qRCodeCustom, this.mMiscBitmap, 0L, oicq.wlogin_sdk.sharemem.WloginSigInfo._QRPUSHSig);
        return RequestTransport(0, 1, null, j, fetch_codeVar._role, transReqContext, wUserSigInfo);
    }

    public int GetA1WithA1(java.lang.String str, long j, long j2, byte[] bArr, long j3, long j4, long j5, byte[] bArr2, byte[] bArr3, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo, oicq.wlogin_sdk.request.WFastLoginInfo wFastLoginInfo) {
        return GetA1WithA1(str, j, j2, this.mMainSigMap, bArr, j3, j4, j5, bArr2, bArr3, wUserSigInfo, wFastLoginInfo, 0);
    }

    public byte[] GetA2A2KeyBuf(java.lang.String str, long j) {
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3;
        oicq.wlogin_sdk.request.Ticket ticketGetLocalTicket = GetLocalTicket(str, j, 64);
        if (ticketGetLocalTicket == null || (bArr = ticketGetLocalTicket._sig) == null || bArr.length <= 0 || (bArr2 = ticketGetLocalTicket._sig_key) == null || bArr2.length <= 0 || (bArr3 = oicq.wlogin_sdk.request.t.B) == null || bArr3.length <= 0) {
            return null;
        }
        int length = str.getBytes().length + 2 + 8 + 2 + ticketGetLocalTicket._sig.length + 2 + ticketGetLocalTicket._sig_key.length;
        byte[] bArr4 = new byte[length];
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr4, 0, str.getBytes().length);
        java.lang.System.arraycopy(str.getBytes(), 0, bArr4, 2, str.getBytes().length);
        int length2 = str.getBytes().length + 2;
        oicq.wlogin_sdk.tools.util.int64_to_buf(bArr4, length2, j);
        int i = length2 + 8;
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr4, i, ticketGetLocalTicket._sig.length);
        int i2 = i + 2;
        byte[] bArr5 = ticketGetLocalTicket._sig;
        java.lang.System.arraycopy(bArr5, 0, bArr4, i2, bArr5.length);
        int length3 = i2 + ticketGetLocalTicket._sig.length;
        oicq.wlogin_sdk.tools.util.int16_to_buf(bArr4, length3, ticketGetLocalTicket._sig_key.length);
        byte[] bArr6 = ticketGetLocalTicket._sig_key;
        java.lang.System.arraycopy(bArr6, 0, bArr4, length3 + 2, bArr6.length);
        int length4 = ticketGetLocalTicket._sig_key.length;
        return oicq.wlogin_sdk.tools.cryptor.encrypt(bArr4, 0, length, oicq.wlogin_sdk.request.t.B);
    }

    public java.util.List GetAllLoginInfo() {
        return this.mG.k();
    }

    public long GetAppidFromUrl(java.lang.String str) {
        int iIndexOf;
        int i;
        if (str == null || (iIndexOf = str.indexOf("f=")) == -1 || (i = iIndexOf + 2) >= str.length()) {
            return -1L;
        }
        java.lang.String str2 = "";
        for (i = iIndexOf + 2; i < str.length() && str.charAt(i) != '&'; i++) {
            str2 = str2 + str.charAt(i);
        }
        try {
            return java.lang.Long.parseLong(str2);
        } catch (java.lang.Exception unused) {
            return -1L;
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0026  */
    /* JADX WARN: Code duplicated, block: B:15:0x002e  */
    /* JADX WARN: Code duplicated, block: B:16:0x0030  */
    /* JADX WARN: Code duplicated, block: B:18:0x005f  */
    public java.lang.Boolean GetBasicUserInfo(java.lang.String str, oicq.wlogin_sdk.sharemem.WloginSimpleInfo wloginSimpleInfo) {
        long jB;
        boolean z;
        oicq.wlogin_sdk.sharemem.WloginSimpleInfo wloginSimpleInfoD;
        if (str == null) {
            return java.lang.Boolean.FALSE;
        }
        if (!oicq.wlogin_sdk.tools.util.check_uin_account(str).booleanValue()) {
            jB = this.mG.b(str);
            z = jB != 0;
            if (z) {
                wloginSimpleInfoD = this.mG.d(jB);
                if (wloginSimpleInfoD == null) {
                    z = false;
                } else {
                    wloginSimpleInfo.setUin(wloginSimpleInfoD._uin);
                    wloginSimpleInfo.setFace(wloginSimpleInfoD._face);
                    wloginSimpleInfo.setGender(wloginSimpleInfoD._gender);
                    wloginSimpleInfo.setNick(wloginSimpleInfoD._nick);
                    wloginSimpleInfo.setAge(wloginSimpleInfoD._age);
                    wloginSimpleInfo.setImgType(wloginSimpleInfoD._img_type);
                    wloginSimpleInfo.setImgFormat(wloginSimpleInfoD._img_format);
                    wloginSimpleInfo.setImgUrl(wloginSimpleInfoD._img_url);
                    wloginSimpleInfo.setMainDisplayName(wloginSimpleInfoD.mainDisplayName);
                }
            }
            return java.lang.Boolean.valueOf(z);
        }
        jB = java.lang.Long.parseLong(str);
        if (z) {
            wloginSimpleInfoD = this.mG.d(jB);
            if (wloginSimpleInfoD == null) {
                z = false;
            } else {
                wloginSimpleInfo.setUin(wloginSimpleInfoD._uin);
                wloginSimpleInfo.setFace(wloginSimpleInfoD._face);
                wloginSimpleInfo.setGender(wloginSimpleInfoD._gender);
                wloginSimpleInfo.setNick(wloginSimpleInfoD._nick);
                wloginSimpleInfo.setAge(wloginSimpleInfoD._age);
                wloginSimpleInfo.setImgType(wloginSimpleInfoD._img_type);
                wloginSimpleInfo.setImgFormat(wloginSimpleInfoD._img_format);
                wloginSimpleInfo.setImgUrl(wloginSimpleInfoD._img_url);
                wloginSimpleInfo.setMainDisplayName(wloginSimpleInfoD.mainDisplayName);
            }
        }
        return java.lang.Boolean.valueOf(z);
    }

    public oicq.wlogin_sdk.devicelock.DevlockInfo GetDevLockInfo(java.lang.String str) {
        return GetDevLockInfo(str, 0L);
    }

    public oicq.wlogin_sdk.devicelock.DevlockInfo GetDevLockInfo(java.lang.String str, long j) {
        if (j <= 0) {
            j = this.mAysncSeq;
        }
        return oicq.wlogin_sdk.request.t.b(j)._devlock_info;
    }

    public byte[] GetGuid() {
        byte[] bArrA = oicq.wlogin_sdk.request.t.a(this.mContext);
        if (bArrA != null) {
            return bArrA;
        }
        byte[] bArr = oicq.wlogin_sdk.request.t.A;
        if (bArr != null && bArr.length > 0) {
            bArrA = new byte[bArr.length];
            java.lang.System.arraycopy(bArr, 0, bArrA, 0, bArr.length);
        }
        oicq.wlogin_sdk.tools.util.LOGI("get guid " + oicq.wlogin_sdk.tools.util.buf_to_string(bArrA), "");
        return bArrA;
    }

    public oicq.wlogin_sdk.request.WloginLastLoginInfo GetLastLoginInfo() {
        java.util.List<oicq.wlogin_sdk.sharemem.WloginLoginInfo> listK = this.mG.k();
        if (listK == null) {
            return null;
        }
        oicq.wlogin_sdk.sharemem.WloginLoginInfo wloginLoginInfo = null;
        for (oicq.wlogin_sdk.sharemem.WloginLoginInfo wloginLoginInfo2 : listK) {
            if (wloginLoginInfo == null || wloginLoginInfo2.mCreateTime > wloginLoginInfo.mCreateTime) {
                wloginLoginInfo = wloginLoginInfo2;
            }
        }
        if (wloginLoginInfo == null) {
            return null;
        }
        java.lang.String str = wloginLoginInfo.mAccount;
        return (str == null || str.length() <= 0) ? new oicq.wlogin_sdk.request.WloginLastLoginInfo(java.lang.String.valueOf(wloginLoginInfo.mUin), wloginLoginInfo.mUin) : new oicq.wlogin_sdk.request.WloginLastLoginInfo(wloginLoginInfo.mAccount, wloginLoginInfo.mUin);
    }

    public oicq.wlogin_sdk.request.WUserSigInfo GetLocalSig(java.lang.String str, long j) {
        long jB;
        oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo = null;
        if (str == null) {
            oicq.wlogin_sdk.tools.util.LOGI("userAccount null", "");
            return null;
        }
        try {
            if (oicq.wlogin_sdk.tools.util.check_uin_account(str).booleanValue()) {
                jB = java.lang.Long.parseLong(str);
            } else {
                jB = this.mG.b(str);
                if (jB == 0) {
                    return null;
                }
            }
            oicq.wlogin_sdk.sharemem.WloginSigInfo wloginSigInfoA = this.mG.a(jB, j);
            if (wloginSigInfoA == null) {
                return null;
            }
            oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo2 = new oicq.wlogin_sdk.request.WUserSigInfo();
            try {
                wUserSigInfo2.uin = str;
                wUserSigInfo2.get_clone(wloginSigInfoA);
                oicq.wlogin_sdk.tools.util.LOGI("skey in sigInfo " + oicq.wlogin_sdk.tools.util.getMaskBytes(wloginSigInfoA._sKey, 2, 2), str);
                return wUserSigInfo2;
            } catch (java.lang.Exception e) {
                e = e;
                wUserSigInfo = wUserSigInfo2;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
        }
        oicq.wlogin_sdk.tools.util.printException(e, str);
        return wUserSigInfo;
    }

    public oicq.wlogin_sdk.request.Ticket GetLocalTicket(java.lang.String str, long j, int i) {
        oicq.wlogin_sdk.tools.util.LOGI("GetLocalTicket appid " + j + " type 0x" + java.lang.String.format("%x", java.lang.Integer.valueOf(i)), str);
        if (str != null) {
            return GetUserSigInfoTicket(GetLocalSig(str, j), i);
        }
        oicq.wlogin_sdk.tools.util.LOGI("userAccount null", "");
        return null;
    }

    public int GetOpenKeyWithoutPasswd(java.lang.String str, long j, long j2, int i, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        return GetStWithoutPasswd(str, j, this.mOpenAppid, -1L, i, j2, null, wUserSigInfo, null, null, 0, null);
    }

    public byte[] GetPictureData(java.lang.String str) {
        return GetPictureData(str, 0L);
    }

    public byte[] GetPictureData(java.lang.String str, long j) {
        if (j <= 0) {
            j = this.mAysncSeq;
        }
        return oicq.wlogin_sdk.request.t.b(j)._t105.get_pic();
    }

    @java.lang.Deprecated
    public byte[] GetPicturePrompt(java.lang.String str) {
        return GetPicturePrompt(str, 0L);
    }

    @java.lang.Deprecated
    public byte[] GetPicturePrompt(java.lang.String str, long j) {
        if (j <= 0) {
            j = this.mAysncSeq;
        }
        return oicq.wlogin_sdk.request.t.b(j)._t165.get_data();
    }

    public java.lang.String GetPicturePromptValue(java.lang.String str) {
        return GetPicturePromptValue(str, 0L);
    }

    public java.lang.String GetPicturePromptValue(java.lang.String str, long j) {
        int iBuf_to_int8;
        int iBuf_to_int9;
        int iBuf_to_int32;
        int i;
        int iBuf_to_int33;
        byte[] bArrGetPicturePrompt = GetPicturePrompt(str, j);
        if (bArrGetPicturePrompt == null || bArrGetPicturePrompt.length <= 3) {
            return "";
        }
        int i2 = 0;
        int iBuf_to_int34 = oicq.wlogin_sdk.tools.util.buf_to_int32(bArrGetPicturePrompt, 0);
        int i3 = 4;
        while (i2 < iBuf_to_int34) {
            int i4 = i3 + 1;
            if (bArrGetPicturePrompt.length < i4 || bArrGetPicturePrompt.length < (iBuf_to_int9 = i4 + (iBuf_to_int8 = oicq.wlogin_sdk.tools.util.buf_to_int8(bArrGetPicturePrompt, i3)))) {
                return "";
            }
            java.lang.String str2 = new java.lang.String(bArrGetPicturePrompt, i4, iBuf_to_int8);
            if (bArrGetPicturePrompt.length < iBuf_to_int9 + 2 || bArrGetPicturePrompt.length < (iBuf_to_int33 = (i = iBuf_to_int9 + 4) + (iBuf_to_int32 = oicq.wlogin_sdk.tools.util.buf_to_int32(bArrGetPicturePrompt, iBuf_to_int9)))) {
                return "";
            }
            java.lang.String str3 = new java.lang.String(bArrGetPicturePrompt, i, iBuf_to_int32);
            if (str2.equals("pic_reason")) {
                return str3;
            }
            i2++;
            i3 = iBuf_to_int33;
        }
        return "";
    }

    public oicq.wlogin_sdk.request.Ticket GetPskey(java.lang.String str, long j, java.lang.String[] strArr, oicq.wlogin_sdk.request.WtTicketPromise wtTicketPromise) {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putStringArray("domains", strArr);
        java.lang.String str2 = "";
        for (java.lang.String str3 : strArr) {
            str2 = str2 + str3 + ",";
        }
        oicq.wlogin_sdk.tools.util.LOGI("GetPskey appid " + j + " domains " + str2, str);
        return GetTicket(str, j, 1048576, wtTicketPromise, bundle);
    }

    public oicq.wlogin_sdk.request.Ticket GetSkey(java.lang.String str, long j, oicq.wlogin_sdk.request.WtTicketPromise wtTicketPromise) {
        return GetTicket(str, j, 4096, wtTicketPromise, null);
    }

    public int GetStViaSMSVerifyLogin(java.lang.String str, long j, long j2, int i, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        oicq.wlogin_sdk.tools.util.LOGI("user:" + str + " GetStViaSMSVerifyLogin ...", str);
        return GetStWithPasswd(str, j, i, j2, null, false, oicq.wlogin_sdk.a.h.x ? oicq.wlogin_sdk.a.h.z : "[REDACTED]", wUserSigInfo, null, true, 0);
    }

    public int GetStViaSMSVerifyLogin(java.lang.String str, long j, long j2, long[] jArr, int i, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        byte[][] bArr = (jArr == null || jArr.length <= 0) ? null : (byte[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) byte.class, jArr.length, 0);
        oicq.wlogin_sdk.tools.util.LOGI("user:" + str + " GetStViaSMSVerifyLogin ...", str);
        return GetStWithPasswd(str, j, i, j2, jArr, false, oicq.wlogin_sdk.a.h.x ? oicq.wlogin_sdk.a.h.z : "[REDACTED]", wUserSigInfo, bArr, true, 0);
    }

    public int GetStWithPasswdMd5(java.lang.String str, long j, long j2, int i, java.lang.String str2, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        return GetStWithPasswd(str, j, i, j2, null, true, str2, wUserSigInfo, null, false, 0);
    }

    @java.lang.Deprecated
    public int GetStWithPasswdMd5(java.lang.String str, long j, java.lang.String str2, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        return GetStWithPasswd(str, j, this.mMainSigMap, 1L, null, true, str2, wUserSigInfo, null, false, 0);
    }

    public int GetStWithPasswdReserved(java.lang.String str, long j, int i, long j2, long[] jArr, boolean z, java.lang.String str2, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo, byte[][] bArr) {
        return GetStWithPasswd(str, j, i, j2, jArr, z, str2, wUserSigInfo, bArr, false, 0);
    }

    public int GetStWithPasswdReserved(java.lang.String str, long j, long j2, int i, java.lang.String str2, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        return GetStWithPasswd(str, j, i, j2, null, false, str2, wUserSigInfo, null, false, 0);
    }

    @java.lang.Deprecated
    public int GetStWithPasswdReserved(java.lang.String str, long j, java.lang.String str2, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        return GetStWithPasswd(str, j, this.mMainSigMap, 1L, null, false, str2, wUserSigInfo, null, false, 0);
    }

    public int GetStWithoutPasswd(java.lang.String str, long j, long j2, long j3, int i, long j4, long[] jArr, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo, byte[][] bArr, byte[][] bArr2) {
        return GetStWithoutPasswd(str, j, j2, j3, i, j4, jArr, wUserSigInfo, bArr, bArr2, 0, null);
    }

    public int GetStWithoutPasswd(java.lang.String str, long j, long j2, long j3, int i, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        return GetStWithoutPasswd(str, j, j2, -1L, i, j3, null, wUserSigInfo, null, null, 0, null);
    }

    public int GetStWithoutPasswd(java.lang.String str, long j, long j2, long j3, int i, byte[] bArr, byte[] bArr2, byte[] bArr3, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        bArr[0][0] = 1;
        byte[][] bArr4 = {new byte[1], bArr, bArr2, bArr3};
        return GetStWithoutPasswd(str, j, j2, -1L, i, j3, null, wUserSigInfo, null, bArr4, 0, null);
    }

    @java.lang.Deprecated
    public int GetStWithoutPasswd(java.lang.String str, long j, long j2, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        return GetStWithoutPasswd(str, j, j2, -1L, this.mMainSigMap, 1L, null, wUserSigInfo, null, null, 0, null);
    }

    public int GetStWithoutPasswd(byte[] bArr, long j, int i, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        byte[] bArrDecrypt;
        int iBuf_to_int16;
        int i2;
        int iBuf_to_int17;
        int i3;
        int iBuf_to_int18;
        if (bArr != null && bArr.length > 0 && (bArrDecrypt = oicq.wlogin_sdk.tools.cryptor.decrypt(bArr, 0, bArr.length, oicq.wlogin_sdk.request.t.B)) != null && bArrDecrypt.length > 0 && 2 <= bArrDecrypt.length && (iBuf_to_int16 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArrDecrypt, 0)) > 0 && (i2 = iBuf_to_int16 + 2) <= bArrDecrypt.length) {
            java.lang.String str = new java.lang.String(bArrDecrypt, 2, iBuf_to_int16);
            int i4 = i2 + 8;
            if (i4 > bArrDecrypt.length) {
                return oicq.wlogin_sdk.tools.util.E_INPUT;
            }
            long jBuf_to_int64 = oicq.wlogin_sdk.tools.util.buf_to_int64(bArrDecrypt, i2);
            int i5 = i4 + 2;
            if (i5 <= bArrDecrypt.length && (iBuf_to_int17 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArrDecrypt, i4)) > 0 && (i3 = i5 + iBuf_to_int17) <= bArrDecrypt.length) {
                byte[] bArr2 = new byte[iBuf_to_int17];
                java.lang.System.arraycopy(bArrDecrypt, i5, bArr2, 0, iBuf_to_int17);
                int i6 = i3 + 2;
                if (i6 <= bArrDecrypt.length && (iBuf_to_int18 = oicq.wlogin_sdk.tools.util.buf_to_int16(bArrDecrypt, i3)) > 0 && i6 + iBuf_to_int18 <= bArrDecrypt.length) {
                    byte[] bArr3 = new byte[iBuf_to_int18];
                    java.lang.System.arraycopy(bArrDecrypt, i6, bArr3, 0, iBuf_to_int18);
                    bArr[0][0] = 2;
                    byte[][] bArr4 = {new byte[1], bArr2, bArr3};
                    return GetStWithoutPasswd(str, jBuf_to_int64, j, -1L, i, 1L, null, wUserSigInfo, null, bArr4, 0, null);
                }
            }
        }
        return oicq.wlogin_sdk.tools.util.E_INPUT;
    }

    public oicq.wlogin_sdk.request.Ticket GetTicket(final java.lang.String str, final long j, final int i, final oicq.wlogin_sdk.request.WtTicketPromise wtTicketPromise, final android.os.Bundle bundle) {
        int i2;
        byte[] bArr;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("GetTicket ");
        sb.append(str);
        sb.append(", ");
        sb.append(j);
        sb.append(" sig ");
        sb.append(java.lang.Integer.toHexString(i));
        sb.append(" ");
        sb.append(bundle == null ? "null" : java.lang.Integer.valueOf(bundle.size()));
        oicq.wlogin_sdk.tools.util.LOGI(sb.toString(), "");
        java.lang.String[] stringArray = null;
        int i3 = 2;
        do {
            oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfoGetLocalSig = GetLocalSig(str, j);
            if (wUserSigInfoGetLocalSig != null) {
                oicq.wlogin_sdk.request.Ticket ticketGetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfoGetLocalSig, i);
                if (ticketGetUserSigInfoTicket != null && (bArr = ticketGetUserSigInfoTicket._sig) != null && bArr.length != 0) {
                    long jF = oicq.wlogin_sdk.request.t.f();
                    if (bundle != null && i == 1048576) {
                        stringArray = bundle.getStringArray("domains");
                    }
                    java.lang.String[] strArr = stringArray;
                    i2 = 1;
                    int iIsPskeyExpired = isPskeyExpired(i, strArr, ticketGetUserSigInfoTicket, jF, i3);
                    if (iIsPskeyExpired != 1) {
                        if (iIsPskeyExpired == 2) {
                            i3--;
                            stringArray = strArr;
                        } else {
                            if (iIsPskeyExpired == 3) {
                                return ticketGetUserSigInfoTicket;
                            }
                            oicq.wlogin_sdk.tools.util.LOGI("GetTicket sigType:0x" + java.lang.Integer.toHexString(i) + " expires in " + (((ticketGetUserSigInfoTicket._expire_time - jF) / 60) / 60) + "h", "");
                            if (i == 4096) {
                                if (true != oicq.wlogin_sdk.request.Ticket.isSkeyExpired(ticketGetUserSigInfoTicket._expire_time)) {
                                    return ticketGetUserSigInfoTicket;
                                }
                                if (i3 == 1) {
                                }
                                stringArray = strArr;
                                RefreshMemorySig();
                                i3--;
                            } else {
                                if (jF < ticketGetUserSigInfoTicket._expire_time) {
                                    return ticketGetUserSigInfoTicket;
                                }
                                if (i3 == 1) {
                                }
                                stringArray = strArr;
                                RefreshMemorySig();
                                i3--;
                            }
                        }
                    }
                    stringArray = strArr;
                    break;
                }
                i2 = 1;
                if (i3 == 1) {
                    break;
                }
                RefreshMemorySig();
                i3--;
            } else {
                if (i3 == 1) {
                    i2 = 1;
                    break;
                }
                i2 = 1;
                RefreshMemorySig();
                i3--;
            }
        } while (i3 > 0);
        if (IsNeedLoginWithPasswd(str, j).booleanValue()) {
            oicq.wlogin_sdk.tools.ErrMsg errMsg = new oicq.wlogin_sdk.tools.ErrMsg();
            errMsg.setType(oicq.wlogin_sdk.tools.util.E_NO_KEY);
            if (wtTicketPromise != null) {
                wtTicketPromise.Failed(errMsg);
            }
        } else {
            oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo = new oicq.wlogin_sdk.request.WUserSigInfo();
            if (bundle != null) {
                i2 = bundle.getInt("subappid", i2);
            }
            if (stringArray != null) {
                int iMin = java.lang.Math.min(20, stringArray.length);
                for (int i4 = 0; i4 < iMin; i4++) {
                    java.lang.String str2 = stringArray[i4];
                    if (str2 != null && str2.length() > 0) {
                        wUserSigInfo._domains.add(str2);
                    }
                }
            }
            GetStWithoutPasswd(str, j, j, i2, i, wUserSigInfo, new oicq.wlogin_sdk.request.WtTicketPromise() { // from class: oicq.wlogin_sdk.request.WtloginHelper.1
                @Override // oicq.wlogin_sdk.request.WtTicketPromise
                public void Done(oicq.wlogin_sdk.request.Ticket ticket) {
                    oicq.wlogin_sdk.request.WtTicketPromise wtTicketPromise2 = wtTicketPromise;
                    if (wtTicketPromise2 != null) {
                        wtTicketPromise2.Done(oicq.wlogin_sdk.request.WtloginHelper.this.GetTicket(str, j, i, null, bundle));
                    }
                }

                @Override // oicq.wlogin_sdk.request.WtTicketPromise
                public void Failed(oicq.wlogin_sdk.tools.ErrMsg errMsg2) {
                    oicq.wlogin_sdk.request.WtTicketPromise wtTicketPromise2 = wtTicketPromise;
                    if (wtTicketPromise2 != null) {
                        wtTicketPromise2.Failed(errMsg2);
                    }
                }

                @Override // oicq.wlogin_sdk.request.WtTicketPromise
                public void Timeout(oicq.wlogin_sdk.tools.ErrMsg errMsg2) {
                    oicq.wlogin_sdk.request.WtTicketPromise wtTicketPromise2 = wtTicketPromise;
                    if (wtTicketPromise2 != null) {
                        wtTicketPromise2.Timeout(errMsg2);
                    }
                }
            });
        }
        oicq.wlogin_sdk.tools.util.LOGI("get null for sigType:0x" + java.lang.Integer.toHexString(i), str);
        return null;
    }

    public long GetTimeDifference() {
        return oicq.wlogin_sdk.request.t.ab;
    }

    public java.lang.Boolean IsNeedLoginWithPasswd(java.lang.String str, long j) {
        boolean z;
        long jB;
        int i;
        if (str == null) {
            return java.lang.Boolean.TRUE;
        }
        synchronized (this) {
            z = true;
            if (oicq.wlogin_sdk.tools.util.check_uin_account(str).booleanValue()) {
                jB = java.lang.Long.parseLong(str);
            } else {
                jB = this.mG.b(str);
                if (jB == 0) {
                    i = 1;
                }
            }
            oicq.wlogin_sdk.sharemem.WloginSigInfo wloginSigInfoA = this.mG.a(jB, j);
            if (wloginSigInfoA != null && wloginSigInfoA._en_A1 != null && wloginSigInfoA._en_A1.length != 0 && wloginSigInfoA._noPicSig != null && wloginSigInfoA._noPicSig.length != 0) {
                i = 2;
            } else if (wloginSigInfoA == null || wloginSigInfoA._TGT == null || wloginSigInfoA._TGT.length == 0 || wloginSigInfoA.iSExpireA2(oicq.wlogin_sdk.request.t.f())) {
                i = 3;
            } else {
                i = 0;
            }
            z = false;
        }
        oicq.wlogin_sdk.tools.util.LOGI("[REDACTED]" + str + "[REDACTED]" + j + "[REDACTED]" + z + "[REDACTED]" + i, str);
        return java.lang.Boolean.valueOf(z);
    }

    public java.lang.Boolean IsUserHaveA1(java.lang.String str, long j) {
        long jB;
        oicq.wlogin_sdk.sharemem.WloginSigInfo wloginSigInfoA;
        byte[] bArr;
        if (str == null) {
            return java.lang.Boolean.FALSE;
        }
        if (!oicq.wlogin_sdk.tools.util.check_uin_account(str).booleanValue()) {
            jB = this.mG.b(str);
            if (jB == 0) {
                wloginSigInfoA = null;
            }
            if (wloginSigInfoA != null || (bArr = wloginSigInfoA._en_A1) == null || bArr.length <= 0) {
                oicq.wlogin_sdk.tools.util.LOGI("userAccount:" + str + " dwAppid:" + j + " IsUserHaveA1 return: null", str);
                return java.lang.Boolean.FALSE;
            }
            oicq.wlogin_sdk.tools.util.LOGI("userAccount:" + str + " dwAppid:" + j + " IsUserHaveA1 return: not null", str);
            return java.lang.Boolean.TRUE;
        }
        jB = java.lang.Long.parseLong(str);
        wloginSigInfoA = this.mG.a(jB, j);
        if (wloginSigInfoA != null) {
        }
        oicq.wlogin_sdk.tools.util.LOGI("userAccount:" + str + " dwAppid:" + j + " IsUserHaveA1 return: null", str);
        return java.lang.Boolean.FALSE;
    }

    public boolean IsWtLoginUrl(java.lang.String str) {
        int iIndexOf;
        int i;
        int i2;
        if (str == null || (iIndexOf = str.indexOf("?k=")) == -1 || (i2 = (i = iIndexOf + 3) + 32) > str.length()) {
            return false;
        }
        java.lang.String strSubstring = str.substring(i, i2);
        return oicq.wlogin_sdk.tools.util.base64_decode_url(strSubstring.getBytes(), strSubstring.length()) != null;
    }

    public byte[] PickupQRCode(java.lang.String str) {
        if (str == null || !str.matches(".*[?&]k=([^&$]+).*")) {
            return null;
        }
        java.lang.String strReplaceAll = str.replaceAll(".*[?&]k=([^&$]+).*", "$1");
        return oicq.wlogin_sdk.tools.util.base64_decode_url(strReplaceAll.getBytes(), strReplaceAll.length());
    }

    public android.content.Intent PrepareQloginIntent(long j, long j2, java.lang.String str) {
        java.lang.String str2 = "com.tencent.mobileqq";
        boolean zIsMQQExist = oicq.wlogin_sdk.tools.util.isMQQExist(this.mContext);
        boolean zIsPackageExist = oicq.wlogin_sdk.tools.util.isPackageExist(this.mContext, com.tencent.connect.common.Constants.PACKAGE_QQ_PAD);
        if (!zIsMQQExist) {
            if (!zIsPackageExist) {
                return null;
            }
            str2 = com.tencent.connect.common.Constants.PACKAGE_QQ_PAD;
        }
        byte[] bArrString_to_buf = oicq.wlogin_sdk.tools.util.get_rsa_pubkey(this.mContext);
        if (bArrString_to_buf == null || bArrString_to_buf.length == 0) {
            bArrString_to_buf = oicq.wlogin_sdk.tools.util.string_to_buf(oicq.wlogin_sdk.tools.RSACrypt.DEFAULT_PUB_KEY);
        }
        android.content.Intent intent = new android.content.Intent();
        intent.setClassName(str2, "com.tencent.open.agent.AgentActivity");
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putLong("dstSsoVer", 1L);
        bundle.putLong("dstAppid", j);
        bundle.putLong("subDstAppid", j2);
        bundle.putByteArray("dstAppVer", str.getBytes());
        bundle.putByteArray("publickey", bArrString_to_buf);
        intent.putExtra(com.tencent.connect.common.Constants.KEY_PARAMS, bundle);
        intent.putExtra(com.tencent.connect.common.Constants.KEY_ACTION, "action_quick_login");
        return intent;
    }

    public android.content.Intent PrepareQloginResult(java.lang.String str, long j, long j2, int i, oicq.wlogin_sdk.request.WFastLoginInfo wFastLoginInfo) {
        android.content.Intent intent = new android.content.Intent();
        intent.putExtra("quicklogin_uin", str);
        byte[] bArr = (byte[]) wFastLoginInfo._outA1.clone();
        if (bArr != null && bArr.length > 0) {
            intent.putExtra("quicklogin_buff", new oicq.wlogin_sdk.tools.RSACrypt(this.mContext).EncryptData(oicq.wlogin_sdk.tools.util.get_cp_pubkey(this.mContext, j, j2), bArr));
        }
        intent.putExtra("quicklogin_ret", i);
        return intent;
    }

    public android.content.Intent PrepareSilenceLoginIntent(long j, long j2, java.lang.String str) {
        byte[] bArrString_to_buf = oicq.wlogin_sdk.tools.util.get_rsa_pubkey(this.mContext);
        if (bArrString_to_buf == null || bArrString_to_buf.length == 0) {
            bArrString_to_buf = oicq.wlogin_sdk.tools.util.string_to_buf(oicq.wlogin_sdk.tools.RSACrypt.DEFAULT_PUB_KEY);
        }
        android.content.Intent intent = new android.content.Intent();
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putLong("dstSsoVer", 1L);
        bundle.putLong("dstAppid", j);
        bundle.putLong("subDstAppid", j2);
        bundle.putByteArray("dstAppVer", str.getBytes());
        bundle.putByteArray("publickey", bArrString_to_buf);
        intent.putExtra(com.tencent.connect.common.Constants.KEY_PARAMS, bundle);
        intent.putExtra(com.tencent.connect.common.Constants.KEY_ACTION, "action_quick_login");
        return intent;
    }

    public int QueryCodeResult(long j, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        oicq.wlogin_sdk.tools.util.LOGI(" QueryCodeResult ...", "");
        oicq.wlogin_sdk.code2d.d dVar = new oicq.wlogin_sdk.code2d.d();
        oicq.wlogin_sdk.request.TransReqContext transReqContext = new oicq.wlogin_sdk.request.TransReqContext();
        transReqContext.set_code2d_func_req();
        transReqContext.set_subcmd(dVar.get_cmd());
        oicq.wlogin_sdk.tools.util.LOGI("qrsig " + oicq.wlogin_sdk.tools.util.buf_to_string(oicq.wlogin_sdk.code2d.c.i));
        transReqContext._body = dVar.a(0L, j, oicq.wlogin_sdk.code2d.c.i, new byte[0]);
        return RequestTransport(0, 1, null, j, dVar._role, transReqContext, wUserSigInfo);
    }

    public void RefreshMemorySig() {
        this.mG.j();
    }

    public int RefreshPictureData(java.lang.String str, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        if (wUserSigInfo == null) {
            wUserSigInfo = new oicq.wlogin_sdk.request.WUserSigInfo();
        }
        return RefreshPictureData(str, wUserSigInfo, 0);
    }

    public int RefreshSMSData(java.lang.String str, long j, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        if (wUserSigInfo == null) {
            wUserSigInfo = new oicq.wlogin_sdk.request.WUserSigInfo();
        }
        return RefreshSMSData(str, j, wUserSigInfo, 0);
    }

    public int RefreshSMSVerifyLoginCode(java.lang.String str, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        return RefreshSMSVerifyLoginCode(str, wUserSigInfo, 0);
    }

    public int RegGetAccount(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        if (bArr3 == null || bArr3.length <= 0) {
            return oicq.wlogin_sdk.tools.util.E_INPUT;
        }
        oicq.wlogin_sdk.tools.util.LOGI("RegGetAccount ...", "");
        oicq.wlogin_sdk.a.b bVar = new oicq.wlogin_sdk.a.b();
        oicq.wlogin_sdk.request.TransReqContext transReqContext = new oicq.wlogin_sdk.request.TransReqContext();
        oicq.wlogin_sdk.a.h hVar = this.mRegStatus;
        hVar.j = bArr != null ? (byte[]) bArr.clone() : new byte[0];
        if (i == 4) {
            hVar.b = "";
        }
        transReqContext.set_register_req();
        transReqContext.set_subcmd(bVar.a());
        transReqContext._body = bVar.a(hVar.e, bArr, bArr3, bArr4, i, hVar.b.getBytes(), bArr2, false, GetGuid(), 0L, oicq.wlogin_sdk.request.t.E, oicq.wlogin_sdk.request.t.z, wUserSigInfo.extraRegTLVMap);
        return RequestTransport(0, 1, null, 0L, hVar.i, transReqContext, wUserSigInfo);
    }

    public int RegGetSMSVerifyLoginAccount(byte[] bArr, byte[] bArr2, byte[] bArr3, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        oicq.wlogin_sdk.tools.util.LOGI("RegGetSMSVerifyLoginAccount ...", "");
        oicq.wlogin_sdk.a.b bVar = new oicq.wlogin_sdk.a.b();
        oicq.wlogin_sdk.request.TransReqContext transReqContext = new oicq.wlogin_sdk.request.TransReqContext();
        oicq.wlogin_sdk.a.h hVar = this.mRegStatus;
        hVar.j = bArr != null ? (byte[]) bArr.clone() : new byte[0];
        oicq.wlogin_sdk.a.h.x = true;
        oicq.wlogin_sdk.a.h.z = oicq.wlogin_sdk.tools.util.get_mpasswd();
        transReqContext.set_register_req();
        transReqContext.set_subcmd(bVar.a());
        transReqContext._body = bVar.a(hVar.e, bArr, oicq.wlogin_sdk.a.h.z.getBytes(), bArr3, 1, hVar.b.getBytes(), bArr2, true, GetGuid(), hVar.h, oicq.wlogin_sdk.request.t.E, oicq.wlogin_sdk.request.t.z, wUserSigInfo.extraRegTLVMap);
        return RequestTransport(0, 1, null, 0L, hVar.i, transReqContext, wUserSigInfo);
    }

    public int RegQueryAccount(int i, byte[] bArr, long j, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        byte[] bArr2 = bArr == null ? new byte[0] : bArr;
        oicq.wlogin_sdk.tools.util.LOGI("RegQueryAccount ...", "");
        oicq.wlogin_sdk.a.h hVar = new oicq.wlogin_sdk.a.h();
        this.mRegStatus = hVar;
        hVar.b = new java.lang.String(bArr2);
        oicq.wlogin_sdk.a.c cVar = new oicq.wlogin_sdk.a.c();
        oicq.wlogin_sdk.request.TransReqContext transReqContext = new oicq.wlogin_sdk.request.TransReqContext();
        oicq.wlogin_sdk.a.h hVar2 = this.mRegStatus;
        transReqContext.set_register_req();
        transReqContext.set_subcmd(cVar.a());
        transReqContext._body = cVar.a(i, bArr2, j);
        return RequestTransport(0, 1, null, 0L, hVar2.i, transReqContext, wUserSigInfo);
    }

    public int RegQueryClientSentMsgStatus(oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        oicq.wlogin_sdk.tools.util.LOGI("RegQueryClientSentMsgStatus ...", "");
        oicq.wlogin_sdk.a.d dVar = new oicq.wlogin_sdk.a.d();
        oicq.wlogin_sdk.request.TransReqContext transReqContext = new oicq.wlogin_sdk.request.TransReqContext();
        oicq.wlogin_sdk.a.h hVar = this.mRegStatus;
        transReqContext.set_register_req();
        transReqContext.set_subcmd(dVar.a());
        transReqContext._body = dVar.b(hVar.e, this.mRegStatus.p);
        return RequestTransport(0, 1, null, 0L, hVar.i, transReqContext, wUserSigInfo);
    }

    public int RegRequestServerResendMsg(oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        oicq.wlogin_sdk.tools.util.LOGI("RegRequestServerResendMsg ...", "");
        oicq.wlogin_sdk.a.e eVar = new oicq.wlogin_sdk.a.e();
        oicq.wlogin_sdk.request.TransReqContext transReqContext = new oicq.wlogin_sdk.request.TransReqContext();
        oicq.wlogin_sdk.a.h hVar = this.mRegStatus;
        transReqContext.set_register_req();
        transReqContext.set_subcmd(eVar.a());
        transReqContext._body = eVar.b(hVar.e, (byte[]) null);
        return RequestTransport(0, 1, null, 0L, hVar.i, transReqContext, wUserSigInfo);
    }

    public int RegSubmitMobile(java.lang.String str, byte[] bArr, byte[] bArr2, int i, int i2, int i3, long j, long j2, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        return RegSubmitMobile(str == null ? new byte[0] : str.getBytes(), bArr, null, bArr2, i, i2, i3, j, j2, wUserSigInfo);
    }

    public int RegSubmitMobile(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2, int i3, long j, long j2, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        return RegSubmitMobile(null, bArr, bArr2, bArr3, i, i2, i3, j, j2, wUserSigInfo);
    }

    public int RegSubmitMsgChk(byte[] bArr, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        if (bArr == null) {
            return oicq.wlogin_sdk.tools.util.E_INPUT;
        }
        oicq.wlogin_sdk.tools.util.LOGI("RegSubmitMsgChk ...", "");
        oicq.wlogin_sdk.a.g gVar = new oicq.wlogin_sdk.a.g();
        oicq.wlogin_sdk.request.TransReqContext transReqContext = new oicq.wlogin_sdk.request.TransReqContext();
        oicq.wlogin_sdk.a.h hVar = this.mRegStatus;
        transReqContext.set_register_req();
        transReqContext.set_subcmd(gVar.a());
        transReqContext._body = gVar.b(hVar.e, bArr);
        return RequestTransport(0, 1, null, 0L, hVar.i, transReqContext, wUserSigInfo);
    }

    public int RequestTransport(int i, int i2, java.lang.String str, long j, long j2, oicq.wlogin_sdk.request.TransReqContext transReqContext, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        oicq.wlogin_sdk.request.z zVar;
        byte[] bArr;
        byte[] bArr2;
        long j3;
        int iA;
        if (i == 0) {
            new oicq.wlogin_sdk.request.WtloginHelper.HelperThread(this, this.mHelperHandler, i2, str, j, j2, transReqContext, wUserSigInfo, "RequestTransport").RunReq(9);
            return oicq.wlogin_sdk.tools.util.E_PENDING;
        }
        oicq.wlogin_sdk.request.t tVarA = this.mG.a(0L);
        oicq.wlogin_sdk.tools.util.LOGI("user:" + str + " encrypt:" + i2 + " appid:" + j + " role:" + j2 + " Seq:" + tVarA.h + " RequestTransport...", str);
        tVarA.g = str;
        if (i2 != 0) {
            if (str == null) {
                tVarA.m = 0;
                zVar = new oicq.wlogin_sdk.request.z(tVarA);
                j3 = 0;
                bArr = null;
                bArr2 = null;
            } else {
                oicq.wlogin_sdk.sharemem.WloginSimpleInfo wloginSimpleInfo = new oicq.wlogin_sdk.sharemem.WloginSimpleInfo();
                if (str == null || !GetBasicUserInfo(str, wloginSimpleInfo).booleanValue()) {
                    iA = oicq.wlogin_sdk.tools.util.E_NO_UIN;
                } else {
                    oicq.wlogin_sdk.sharemem.WloginSigInfo wloginSigInfoA = tVarA.a(wloginSimpleInfo._uin, j);
                    if (wloginSigInfoA == null) {
                        iA = oicq.wlogin_sdk.tools.util.E_NO_KEY;
                    } else {
                        tVarA.f = wloginSimpleInfo._uin;
                        zVar = new oicq.wlogin_sdk.request.z(tVarA);
                        j3 = wloginSimpleInfo._uin;
                        bArr = wloginSigInfoA._userStSig;
                        bArr2 = wloginSigInfoA._userSt_Key;
                        iA = zVar.a(j3, transReqContext, bArr, bArr2, j, j2, wUserSigInfo);
                    }
                }
            }
            tVarA.i();
            oicq.wlogin_sdk.tools.util.LOGI("user:" + str + " encrypt:" + i2 + " appid:" + j + " role:" + j2 + " Seq:" + tVarA.h + " RequestTransport ret=" + iA, str);
            return iA;
        }
        tVarA.f = 0L;
        zVar = new oicq.wlogin_sdk.request.z(tVarA);
        bArr = null;
        bArr2 = null;
        j3 = tVarA.f;
        iA = zVar.a(j3, transReqContext, bArr, bArr2, j, j2, wUserSigInfo);
        tVarA.i();
        oicq.wlogin_sdk.tools.util.LOGI("user:" + str + " encrypt:" + i2 + " appid:" + j + " role:" + j2 + " Seq:" + tVarA.h + " RequestTransport ret=" + iA, str);
        return iA;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:33:0x0113  */
    public int RequestTransportMsf(int i, int i2, java.lang.String str, long j, long j2, oicq.wlogin_sdk.request.TransReqContext transReqContext) {
        oicq.wlogin_sdk.request.z zVar;
        long j3;
        byte[] bArr;
        oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo;
        byte[] bArr2;
        byte[] bArr3;
        byte[] bArr4;
        int iA;
        if (i == 0) {
            new oicq.wlogin_sdk.request.WtloginHelper.HelperThread(this, this.mHelperHandler, i2, str, j, j2, transReqContext, "RequestTransportMsf").RunReq(10);
            return oicq.wlogin_sdk.tools.util.E_PENDING;
        }
        oicq.wlogin_sdk.request.t tVarA = this.mG.a(0L);
        oicq.wlogin_sdk.tools.util.LOGI("user:" + str + " encrypt:" + i2 + " appid:" + j + " role:" + j2 + " Seq:" + tVarA.h + " RequestTransportMsf...", str);
        tVarA.g = str;
        if (i2 != 0) {
            oicq.wlogin_sdk.sharemem.WloginSimpleInfo wloginSimpleInfo = new oicq.wlogin_sdk.sharemem.WloginSimpleInfo();
            if (str == null || !GetBasicUserInfo(str, wloginSimpleInfo).booleanValue()) {
                iA = oicq.wlogin_sdk.tools.util.E_NO_UIN;
            } else {
                oicq.wlogin_sdk.sharemem.WloginSigInfo wloginSigInfoA = tVarA.a(wloginSimpleInfo._uin, j);
                if (wloginSigInfoA == null) {
                    iA = oicq.wlogin_sdk.tools.util.E_NO_KEY;
                } else {
                    tVarA.f = wloginSimpleInfo._uin;
                    zVar = new oicq.wlogin_sdk.request.z(tVarA);
                    j3 = wloginSimpleInfo._uin;
                    byte[] bArr5 = wloginSigInfoA._userStSig;
                    byte[] bArr6 = wloginSigInfoA._userSt_Key;
                    byte[] bArr7 = wloginSigInfoA._TGT;
                    wUserSigInfo = new oicq.wlogin_sdk.request.WUserSigInfo();
                    bArr2 = bArr5;
                    bArr3 = bArr6;
                    bArr4 = bArr7;
                    iA = zVar.a(j3, transReqContext, bArr2, bArr3, bArr4, j, j2, wUserSigInfo);
                }
            }
        } else {
            if (oicq.wlogin_sdk.tools.util.check_uin_account(str).booleanValue() && java.lang.Long.parseLong(str) == 0) {
                tVarA.f = 0L;
                zVar = new oicq.wlogin_sdk.request.z(tVarA);
                bArr = new byte[0];
                wUserSigInfo = new oicq.wlogin_sdk.request.WUserSigInfo();
                j3 = 0;
            } else {
                oicq.wlogin_sdk.sharemem.WloginSimpleInfo wloginSimpleInfo2 = new oicq.wlogin_sdk.sharemem.WloginSimpleInfo();
                if (str == null || !GetBasicUserInfo(str, wloginSimpleInfo2).booleanValue()) {
                    iA = oicq.wlogin_sdk.tools.util.E_NO_UIN;
                } else {
                    oicq.wlogin_sdk.sharemem.WloginSigInfo wloginSigInfoA2 = tVarA.a(wloginSimpleInfo2._uin, j);
                    if (wloginSigInfoA2 == null) {
                        iA = oicq.wlogin_sdk.tools.util.E_NO_KEY;
                    } else {
                        tVarA.f = wloginSimpleInfo2._uin;
                        zVar = new oicq.wlogin_sdk.request.z(tVarA);
                        j3 = wloginSimpleInfo2._uin;
                        bArr = wloginSigInfoA2._TGT;
                        wUserSigInfo = new oicq.wlogin_sdk.request.WUserSigInfo();
                    }
                }
            }
            bArr2 = null;
            bArr3 = null;
            bArr4 = bArr;
            iA = zVar.a(j3, transReqContext, bArr2, bArr3, bArr4, j, j2, wUserSigInfo);
        }
        tVarA.i();
        oicq.wlogin_sdk.tools.util.LOGI("user:" + str + " encrypt:" + i2 + " appid:" + j + " role:" + j2 + " Seq:" + tVarA.h + " RequestTransportMsf ret=" + iA, str);
        return iA;
    }

    public oicq.wlogin_sdk.request.WUserSigInfo ResolveQloginIntentReserved(android.content.Intent intent) {
        if (intent == null || intent.getExtras().getInt("quicklogin_ret") != 0) {
            return null;
        }
        java.lang.String string = intent.getExtras().getString("quicklogin_uin");
        byte[] byteArray = intent.getExtras().getByteArray("quicklogin_buff");
        if (string == null || byteArray == null) {
            return null;
        }
        oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo = new oicq.wlogin_sdk.request.WUserSigInfo();
        byte[] bArrDecryptData = new oicq.wlogin_sdk.tools.RSACrypt(this.mContext).DecryptData(null, byteArray);
        wUserSigInfo._fastLoginBuf = bArrDecryptData;
        if (bArrDecryptData == null) {
            oicq.wlogin_sdk.tools.util.LOGI("rsa decrypt failed", "");
            return null;
        }
        wUserSigInfo.uin = string;
        return wUserSigInfo;
    }

    public void SetAppClientVersion(int i) {
        oicq.wlogin_sdk.request.t.w = i;
    }

    public void SetCanWebVerify(int i) {
        oicq.wlogin_sdk.request.l.I = i;
    }

    public void SetDevlockMobileType(int i) {
        oicq.wlogin_sdk.request.s.I = i;
    }

    public void SetImgType(int i) {
        oicq.wlogin_sdk.request.t.x = i;
        this.mMiscBitmap |= 128;
    }

    public oicq.wlogin_sdk.request.WtloginListener SetListener(oicq.wlogin_sdk.request.WtloginListener wtloginListener) {
        oicq.wlogin_sdk.request.WtloginListener wtloginListener2 = this.mListener;
        this.mListener = wtloginListener;
        return wtloginListener2;
    }

    public void SetLocalId(int i) {
        oicq.wlogin_sdk.request.t.u = i;
    }

    public void SetMsfTransportFlag(int i) {
        oicq.wlogin_sdk.request.t tVar = this.mG;
        tVar.k = i;
        if (i != 0) {
            oicq.wlogin_sdk.request.t.ad = new byte[4];
            oicq.wlogin_sdk.request.t.ac = 0L;
            tVar.l = 45000;
        }
    }

    public int SetNeedForPayToken(java.lang.String str, java.lang.String str2, byte[] bArr) {
        if (str == null || str.length() <= 0) {
            return -1;
        }
        oicq.wlogin_sdk.request.l.J = str.getBytes();
        if (bArr != null) {
            oicq.wlogin_sdk.request.l.L = bArr;
        }
        if (str2 == null || str2.length() == 0) {
            str2 = oicq.wlogin_sdk.tools.util.getChannelId(this.mContext, null);
        }
        oicq.wlogin_sdk.request.l.K = str2.getBytes();
        return (str2 == null || str2.length() == 0) ? -2 : 0;
    }

    public void SetPicType(int i) {
        oicq.wlogin_sdk.request.t.y = i;
    }

    public void SetRegDevLockFlag(int i) {
        oicq.wlogin_sdk.request.t.z = i;
    }

    public void SetSigMap(int i) {
        this.mMainSigMap = i | 192;
    }

    public void SetTestHost(int i, java.lang.String str) {
        oicq.wlogin_sdk.request.oicq_request.a(i, str);
    }

    public void SetTimeOut(int i) {
        this.mG.l = i;
    }

    public int VerifyCode(java.lang.String str, long j, boolean z, byte[] bArr, int[] iArr, int i, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        byte[] bArr2;
        byte[] bArr3;
        byte[] bArr4;
        oicq.wlogin_sdk.sharemem.WloginSimpleInfo wloginSimpleInfo = new oicq.wlogin_sdk.sharemem.WloginSimpleInfo();
        if (!GetBasicUserInfo(str, wloginSimpleInfo).booleanValue()) {
            return oicq.wlogin_sdk.tools.util.E_NO_UIN;
        }
        long j2 = wloginSimpleInfo._uin;
        oicq.wlogin_sdk.sharemem.WloginSigInfo wloginSigInfoFindUserSig = FindUserSig(j2, j);
        if (wloginSigInfoFindUserSig == null) {
            return oicq.wlogin_sdk.tools.util.E_NO_KEY;
        }
        oicq.wlogin_sdk.tlv_type.tlv_t400 tlv_t400Var = new oicq.wlogin_sdk.tlv_type.tlv_t400();
        byte[] bArr5 = new byte[0];
        byte[] bArr6 = wloginSigInfoFindUserSig._G;
        if (bArr6 == null || bArr6.length <= 0 || (bArr3 = wloginSigInfoFindUserSig._dpwd) == null || bArr3.length <= 0 || (bArr4 = wloginSigInfoFindUserSig._randseed) == null || bArr4.length <= 0) {
            bArr2 = bArr5;
        } else {
            tlv_t400Var.get_tlv_400(bArr6, j2, oicq.wlogin_sdk.request.t.A, bArr3, j, 1L, bArr4);
            bArr2 = tlv_t400Var.get_data();
        }
        oicq.wlogin_sdk.tools.util.LOGI("user:" + str + " VerifyCode ...", str);
        oicq.wlogin_sdk.code2d.e eVar = new oicq.wlogin_sdk.code2d.e();
        oicq.wlogin_sdk.request.TransReqContext transReqContext = new oicq.wlogin_sdk.request.TransReqContext();
        transReqContext.set_code2d_func_req();
        transReqContext.set_subcmd(eVar.get_cmd());
        transReqContext.setSTEncryptMethod();
        transReqContext.setWtST(wloginSigInfoFindUserSig);
        transReqContext._body = eVar.a(j2, j, z, bArr, iArr, wloginSigInfoFindUserSig._userStSig, oicq.wlogin_sdk.request.t.A, oicq.wlogin_sdk.request.t.E, i, bArr2);
        return RequestTransport(0, 1, str, j, eVar._role, transReqContext, wUserSigInfo);
    }

    public int VerifySMSVerifyLoginCode(java.lang.String str, java.lang.String str2, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        return VerifySMSVerifyLoginCode(str, str2, wUserSigInfo, 0);
    }

    public boolean getHasPassword(long j) {
        oicq.wlogin_sdk.request.UinInfo uinInfoC;
        java.lang.String strE = this.mG.e(j);
        oicq.wlogin_sdk.tools.util.LOGI("[REDACTED]" + java.lang.String.valueOf(strE), "[REDACTED]" + j);
        if (strE == null || (uinInfoC = this.mG.c(strE)) == null) {
            return true;
        }
        boolean hasPassword = uinInfoC.getHasPassword();
        oicq.wlogin_sdk.tools.util.LOGI("[REDACTED]" + strE + "[REDACTED]" + j + "[REDACTED]" + hasPassword, "[REDACTED]");
        return hasPassword;
    }

    public int getStWithQrSig(java.lang.String str, long j, long j2, int i, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        return getStWithQrSig(str, j, j2, i, wUserSigInfo, 0);
    }

    public java.lang.String getUserAccountFromQuickLoginResultData(android.content.Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra("isRetFromWeb", false);
        oicq.wlogin_sdk.tools.util.LOGI("getUserAccountFromQuickLoginResultData isRetFromWeb " + booleanExtra);
        java.lang.String stringExtra = intent.getStringExtra(!booleanExtra ? "quicklogin_uin" : "uin");
        return stringExtra == null ? "" : stringExtra;
    }

    public java.lang.String getUserInputFromQuickLoginResultData(android.content.Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra("isRetFromWeb", false);
        oicq.wlogin_sdk.tools.util.LOGI("getUserAccountFromQuickLoginResultData isRetFromWeb " + booleanExtra);
        return true == booleanExtra ? intent.getStringExtra("input") : "";
    }

    public int onQuickLoginActivityResultData(oicq.wlogin_sdk.request.WtloginHelper.QuickLoginParam quickLoginParam, android.content.Intent intent) {
        java.lang.String str;
        if (intent == null) {
            str = "onActivityResultData data is null";
        } else if (quickLoginParam == null) {
            str = "onActivityResultData quickLoginParam is null";
        } else {
            boolean booleanExtra = intent.getBooleanExtra("isRetFromWeb", false);
            oicq.wlogin_sdk.tools.util.LOGI("onQuickLoginActivityResultData isRetFromWeb " + booleanExtra);
            if (booleanExtra) {
                quickLoginParam.userAccount = getUserInputFromQuickLoginResultData(intent);
                return getStWithPtSig(intent.getStringExtra("uin"), intent.getStringExtra(com.tencent.ysdk.shell.framework.request.HttpRequest.PARAM_SIG), quickLoginParam);
            }
            oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfoResolveQloginIntentReserved = ResolveQloginIntentReserved(intent);
            if (wUserSigInfoResolveQloginIntentReserved != null) {
                oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo = quickLoginParam.userSigInfo;
                wUserSigInfo.uin = wUserSigInfoResolveQloginIntentReserved.uin;
                wUserSigInfo._fastLoginBuf = wUserSigInfoResolveQloginIntentReserved._fastLoginBuf;
                return getStWithQQSig("" + wUserSigInfoResolveQloginIntentReserved.uin, quickLoginParam);
            }
            str = "onActivityResultData ResolveQloginIntent failed";
        }
        oicq.wlogin_sdk.tools.util.LOGI(str, "");
        return oicq.wlogin_sdk.tools.util.E_INPUT;
    }

    public int quickLogin(android.app.Activity activity, long j, long j2, java.lang.String str, oicq.wlogin_sdk.request.WtloginHelper.QuickLoginParam quickLoginParam) {
        try {
            java.lang.reflect.Method method = java.lang.Class.forName("oicq.wlogin_sdk.quicklogin.QuickLogin").getMethod("jumpToLoginActivity", android.content.Context.class, android.app.Activity.class, java.lang.Long.TYPE, java.lang.Long.TYPE, java.lang.String.class, oicq.wlogin_sdk.request.WtloginHelper.QuickLoginParam.class);
            java.lang.Object[] objArr = new java.lang.Object[6];
            try {
                objArr[0] = this.mContext;
                objArr[1] = activity;
                objArr[2] = java.lang.Long.valueOf(j);
                objArr[3] = java.lang.Long.valueOf(j2);
                objArr[4] = str;
                objArr[5] = quickLoginParam;
                return ((java.lang.Integer) method.invoke(null, objArr)).intValue();
            } catch (java.lang.Exception unused) {
                return 0;
            }
        } catch (java.lang.Exception unused2) {
        }
    }

    public int quickRegisterCheckAccount(long j, long j2, int i, int i2, byte[] bArr, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        return 0;
    }

    public int quickRegisterGetAccount(long j, long j2, int i, int i2, byte[] bArr, byte[] bArr2, java.lang.String str, oicq.wlogin_sdk.request.WUserSigInfo wUserSigInfo) {
        return 0;
    }

    public void setBabyQFlg(boolean z) {
        oicq.wlogin_sdk.request.t.ag = z;
    }

    public void setCallSource(int i) {
        oicq.wlogin_sdk.request.t.af = i;
    }

    public void setForQCall() {
        oicq.wlogin_sdk.request.t.ar = true;
        oicq.wlogin_sdk.request.WtloginMsfListener.CLIENT_CLASSNAME = "com.tencent.lightalk.msf.core.auth.WtProvider";
    }

    public void setHasPassword(long j, boolean z) {
        java.lang.String strE = this.mG.e(j);
        oicq.wlogin_sdk.tools.util.LOGI("[REDACTED]" + java.lang.String.valueOf(strE), "[REDACTED]");
        if (strE == null) {
            return;
        }
        this.mG.a(strE, java.lang.Long.valueOf(j), z);
        oicq.wlogin_sdk.tools.util.LOGI("[REDACTED]" + strE + "[REDACTED]" + j + "[REDACTED]" + z, "[REDACTED]");
    }

    public void setMsgType(int i, int i2, int i3) {
        oicq.wlogin_sdk.devicelock.DevlockBase.a.f1660a = i;
        oicq.wlogin_sdk.devicelock.DevlockBase.a.b = i2;
        oicq.wlogin_sdk.devicelock.DevlockBase.a.c = i3;
    }
}
