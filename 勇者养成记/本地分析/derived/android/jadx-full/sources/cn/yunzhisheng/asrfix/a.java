package cn.yunzhisheng.asrfix;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class a extends java.lang.Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ cn.yunzhisheng.asrfix.JniAsrFix f6a;
    private com.unisound.sdk.w b;

    public a(cn.yunzhisheng.asrfix.JniAsrFix jniAsrFix, com.unisound.sdk.w wVar) {
        this.f6a = jniAsrFix;
        this.b = wVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        com.unisound.sdk.u uVar;
        int i;
        long jCurrentTimeMillis;
        com.unisound.common.y.g("Recognizer.loadModel Reset thread start");
        com.unisound.common.y.c("Recognizer.loadModel Reset thread start");
        this.f6a.T = true;
        synchronized (cn.yunzhisheng.asrfix.JniAsrFix.D) {
            this.f6a.S = false;
            while (!this.f6a.S) {
                if (!this.f6a.N) {
                    this.f6a.O = com.unisound.client.SpeechConstants.ASR_STATUS_LOCAL_RESET;
                    this.f6a.P.a(this.f6a.O);
                    while (!this.f6a.B.isEmpty()) {
                        java.lang.String strPoll = this.f6a.B.poll();
                        java.lang.String strPoll2 = this.f6a.B.poll();
                        java.lang.String strPoll3 = this.f6a.B.poll();
                        com.unisound.common.y.c("Recognizer.loadModel reseting ", strPoll, " ", strPoll2);
                        int iReset = this.f6a.reset(strPoll, "");
                        this.f6a.O = com.unisound.client.SpeechConstants.ASR_STATUS_LOCAL_IDEL;
                        if (iReset == 0) {
                            this.f6a.P.a(this.f6a.O);
                            if (com.unisound.sdk.cx.f1560a == strPoll2) {
                                uVar = this.f6a.P;
                                i = 3105;
                                jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                            } else {
                                if (com.tencent.assistant.sdk.remote.SDKConst.KEY_REALTED_COMMAND == strPoll2) {
                                    this.b.a(strPoll3, true);
                                    uVar = this.f6a.P;
                                    i = com.unisound.client.SpeechConstants.ASR_EVENT_LOADGRAMMAR_DONE;
                                    jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                                } else {
                                    com.unisound.common.y.a("Recognizer.loadModel no cmd type error");
                                }
                                com.unisound.common.y.c("Recognizer.loadModel reset ok");
                            }
                            uVar.a(i, (int) jCurrentTimeMillis);
                            com.unisound.common.y.c("Recognizer.loadModel reset ok");
                        } else {
                            if (com.tencent.assistant.sdk.remote.SDKConst.KEY_REALTED_COMMAND == strPoll2) {
                                this.b.a(strPoll3, false);
                            }
                            this.f6a.P.b(com.unisound.client.SpeechConstants.ASR_ERROR, com.unisound.client.ErrorCode.ASR_SDK_FIX_LOADGRAMMAR_ERROR);
                            com.unisound.common.y.a("Recognizer.loadModel reset error:" + iReset);
                        }
                    }
                    this.f6a.T = false;
                    this.f6a.S = true;
                    this.f6a.O = com.unisound.client.SpeechConstants.ASR_STATUS_LOCAL_IDEL;
                }
                try {
                    java.lang.Thread.sleep(50L);
                } catch (java.lang.InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        com.unisound.common.y.c("Recognizer.loadModel Reset thread stop");
        com.unisound.common.y.g("Recognizer.loadModel Reset thread stop");
    }
}
