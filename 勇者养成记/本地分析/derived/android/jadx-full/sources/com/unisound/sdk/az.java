package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class az {
    private static java.lang.Object t = new java.lang.Object();
    private cn.yunzhisheng.tts.offline.lib.YzsTts b;
    private com.unisound.sdk.bu c;
    private com.unisound.sdk.bv d;
    private com.unisound.sdk.by e;
    private com.unisound.client.SpeechSynthesizerListener f;
    private android.content.Context h;
    private com.unisound.client.IAudioSource l;
    private com.unisound.sdk.be m;
    private android.os.HandlerThread o;
    private com.unisound.common.ab p;
    private com.unisound.common.ag q;
    private int g = 16000;
    private int i = 0;
    private com.unisound.sdk.bx j = com.unisound.sdk.bx.a();
    private java.lang.String k = "";
    private java.lang.Integer n = 2;
    private com.unisound.sdk.ca r = new com.unisound.sdk.ba(this);
    private com.unisound.sdk.bz s = new com.unisound.sdk.bb(this);
    private boolean u = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    com.unisound.sdk.cg f1525a = new com.unisound.sdk.cg(new com.unisound.sdk.bc(this));

    public az(android.content.Context context, java.lang.String str, java.lang.String str2) {
        this.h = context;
        this.j.b(str);
        this.j.c(str2);
        this.p = new com.unisound.sdk.bd(this, context.getMainLooper());
        this.q = new com.unisound.common.ag(context);
    }

    private int a(java.lang.String str, com.unisound.sdk.be beVar) {
        java.lang.Object[] objArr;
        this.u = true;
        this.m = beVar;
        if (this.p == null) {
            this.f.onError(com.unisound.client.SpeechConstants.TTS_ERROR, com.unisound.client.ErrorCode.toJsonMessage(com.unisound.client.ErrorCode.GENERAL_INIT_ERROR));
            return -1;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            com.unisound.common.y.a("SpeechSynthesizerInterface beginTts: text is unusable");
            sendMsg(this.p, 202, com.unisound.client.ErrorCode.toJsonMessage(com.unisound.client.ErrorCode.TTS_ERROR_TEXT_UNUSEABLE));
            return -1;
        }
        h();
        c();
        f();
        i();
        d();
        g();
        com.unisound.sdk.bu buVar = this.c;
        if (buVar != null) {
            buVar.b(10000);
        }
        com.unisound.sdk.by byVar = this.e;
        if (byVar != null) {
            byVar.c(10000);
        }
        if (this.n.intValue() == 1 || k()) {
            this.j.b(com.unisound.sdk.bx.k);
            this.c = null;
            this.c = new com.unisound.sdk.bu(str, this.j);
            this.c.setName("TTSOfflineSynthesizerThread");
            this.c.a(this.r);
        } else {
            this.j.b(this.g);
            try {
                this.j.f1545a = com.unisound.c.a.b();
            } catch (java.lang.Exception unused) {
                com.unisound.common.y.c("SpeechSynthesizerInterface getNetType error");
            }
            this.d = null;
            this.d = new com.unisound.sdk.bv(str, this.j);
            this.d.setName("TTSOnlineSynthesizerThread");
            this.d.a(this.r);
        }
        a();
        if (this.n.intValue() == 1 || k()) {
            this.c.start();
            objArr = new java.lang.Object[]{"SpeechSynthesizerInterface beginTts: mOfflineSynthesizeThread.start()"};
        } else {
            this.d.start();
            objArr = new java.lang.Object[]{"SpeechSynthesizerInterface beginTts: mOnlineSynthesizerThread.start(text)"};
        }
        com.unisound.common.y.b(objArr);
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.Object a(java.lang.Object... objArr) {
        if (this.b.a((java.lang.String) objArr[0], (java.lang.String) objArr[1], (java.lang.String) objArr[2], (java.lang.String) objArr[3]) || this.b.a(this.j.k(), this.j.l(), this.j.m(), this.j.n())) {
            sendEmptyMsg(this.p, 101);
            return true;
        }
        sendMsg(this.p, 201, com.unisound.client.ErrorCode.toJsonMessage(com.unisound.client.ErrorCode.TTS_ERROR_LOAD_MODEL));
        return false;
    }

    private void a() {
        this.e = null;
        this.e = new com.unisound.sdk.by(this.j);
        this.e.setName("TTSPlayThread");
        this.e.a(this.s);
        this.e.a(this.l);
        if (this.m == com.unisound.sdk.be.onlySyn) {
            this.e.a((java.lang.Boolean) false);
            com.unisound.common.y.b("SpeechSynthesizerInterface beginTts: onlySynthesize executed");
        }
        this.e.start();
        com.unisound.common.y.b("SpeechSynthesizerInterface beginTts: mTTSPlayThread.start()");
    }

    private void b() {
        if (this.q.a("android.permission.ACCESS_FINE_LOCATION") != 0) {
            com.unisound.common.y.a("no ACCESS_FINE_LOCATION permission");
            com.unisound.client.SpeechSynthesizerListener speechSynthesizerListener = this.f;
            if (speechSynthesizerListener != null) {
                speechSynthesizerListener.onEvent(com.unisound.client.SpeechConstants.GENERAL_EVENT_REQUIRE_ACCESS_FINE_LOCATION_PERMISSION);
            }
        }
        if (this.q.a("android.permission.READ_PHONE_STATE") != 0) {
            com.unisound.common.y.a("no READ_PHONE_STATE permission");
            com.unisound.client.SpeechSynthesizerListener speechSynthesizerListener2 = this.f;
            if (speechSynthesizerListener2 != null) {
                speechSynthesizerListener2.onEvent(1151);
            }
        }
        if (this.q.a("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            com.unisound.common.y.a("no WRITE_EXTERNAL_STORAGE permission");
            com.unisound.client.SpeechSynthesizerListener speechSynthesizerListener3 = this.f;
            if (speechSynthesizerListener3 != null) {
                speechSynthesizerListener3.onEvent(com.unisound.client.SpeechConstants.GENERAL_EVENT_REQUIRE_WRITE_EXTERNAL_STORAGE_PERMISSION);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(java.lang.String str) {
        this.j.b(com.unisound.sdk.bx.k);
        h();
        f();
        i();
        g();
        this.c = null;
        this.c = new com.unisound.sdk.bu(str, this.j);
        this.c.setName("TTSOfflineSynthesizerThread");
        this.c.a(this.r);
        a();
        this.c.start();
        com.unisound.common.y.b("SpeechSynthesizerInterface changeTts: mOfflineSynthesizeThread.start()");
    }

    private int c() {
        com.unisound.sdk.bu buVar = this.c;
        if (buVar == null) {
            return -1;
        }
        buVar.h();
        return 0;
    }

    private int d() {
        com.unisound.sdk.bu buVar = this.c;
        if (buVar == null) {
            return -1;
        }
        buVar.b();
        return 0;
    }

    private int e() {
        com.unisound.sdk.bu buVar = this.c;
        if (buVar == null) {
            return -1;
        }
        buVar.g();
        return 0;
    }

    private int f() {
        com.unisound.sdk.bv bvVar = this.d;
        if (bvVar == null) {
            return -1;
        }
        bvVar.g();
        return 0;
    }

    private int g() {
        com.unisound.sdk.bv bvVar = this.d;
        if (bvVar == null) {
            return -1;
        }
        bvVar.b();
        return 0;
    }

    private int h() {
        com.unisound.sdk.by byVar = this.e;
        if (byVar == null) {
            return -1;
        }
        byVar.j();
        return 0;
    }

    private int i() {
        com.unisound.sdk.by byVar = this.e;
        if (byVar == null) {
            return -1;
        }
        byVar.b();
        return 0;
    }

    private void j() {
        if (this.p.hasMessages(107)) {
            com.unisound.common.y.b("SpeechSynthesizerInterface removeMessage : remvoeMessage = ", 107);
            this.p.removeMessages(107);
        }
        if (this.p.hasMessages(103)) {
            com.unisound.common.y.b("SpeechSynthesizerInterface removeMessage : remvoeMessage = ", 103);
            this.p.removeMessages(103);
        }
        if (this.p.hasMessages(102)) {
            com.unisound.common.y.b("SpeechSynthesizerInterface removeMessage : remvoeMessage = ", 102);
            this.p.removeMessages(102);
        }
        if (this.p.hasMessages(104)) {
            com.unisound.common.y.b("SpeechSynthesizerInterface removeMessage : remvoeMessage = ", 104);
            this.p.removeMessages(104);
        }
        if (this.p.hasMessages(105)) {
            com.unisound.common.y.b("SpeechSynthesizerInterface removeMessage : remvoeMessage = ", 105);
            this.p.removeMessages(105);
        }
        if (this.p.hasMessages(106)) {
            com.unisound.common.y.b("SpeechSynthesizerInterface removeMessage : remvoeMessage = ", 106);
            this.p.removeMessages(106);
        }
        if (this.p.hasMessages(101)) {
            com.unisound.common.y.b("SpeechSynthesizerInterface removeMessage : remvoeMessage = ", 101);
            this.p.removeMessages(101);
        }
        if (this.p.hasMessages(108)) {
            com.unisound.common.y.b("SpeechSynthesizerInterface removeMessage : remvoeMessage = ", 108);
            this.p.removeMessages(108);
        }
        if (this.p.hasMessages(109)) {
            com.unisound.common.y.b("SpeechSynthesizerInterface removeMessage : remvoeMessage = ", 109);
            this.p.removeMessages(109);
        }
        if (this.p.hasMessages(111)) {
            com.unisound.common.y.b("SpeechSynthesizerInterface removeMessage : remvoeMessage = ", 111);
            this.p.removeMessages(111);
        }
        if (this.p.hasMessages(112)) {
            com.unisound.common.y.b("SpeechSynthesizerInterface removeMessage : remvoeMessage = ", 112);
            this.p.removeMessages(112);
        }
    }

    private boolean k() {
        return this.j.H().intValue() == 3 && !com.unisound.common.ae.b(this.h);
    }

    private void l() {
        com.unisound.common.y.b("SpeechSynthesizerInterface switchSpeeker begin");
        cn.yunzhisheng.tts.offline.lib.YzsTts yzsTts = this.b;
        if (yzsTts == null) {
            sendMsg(this.p, 225, com.unisound.client.ErrorCode.toJsonMessage(com.unisound.client.ErrorCode.TTS_ERROR_OFFLINE_ENGINE_NOT_INIT));
            return;
        }
        int iA = yzsTts.a(this.j.g());
        if (iA != 114) {
            switch (iA) {
                case com.unisound.client.ErrorCode.TTS_ERROR_OFFLINE_CHANGE_SPEAKER_FAIL /* -73310 */:
                case com.unisound.client.ErrorCode.TTS_ERROR_OFFLINE_ENGINE_IS_PROCESSING /* -73309 */:
                case com.unisound.client.ErrorCode.TTS_ERROR_OFFLINE_ENGINE_NOT_INIT /* -73308 */:
                    sendMsg(this.p, 225, com.unisound.client.ErrorCode.toJsonMessage(iA));
                    break;
            }
        } else {
            sendEmptyMsg(this.p, iA);
        }
        com.unisound.common.y.b("SpeechSynthesizerInterface switchSpeeker end");
    }

    private void m() {
        java.util.List<java.lang.Integer> listD = this.j.D();
        if (listD.size() > 0) {
            for (java.lang.Integer num : listD) {
                this.b.d(num.intValue());
                com.unisound.common.y.c("setTtsField....", num);
            }
            listD.clear();
        }
    }

    public static void sendEmptyMsg(com.unisound.common.ab abVar, int i) {
        synchronized (t) {
            if (com.unisound.common.y.l) {
                com.unisound.common.y.d("SpeechSynthesizerInterface ->sendEmptyMsg what = ", java.lang.Integer.valueOf(i));
            }
            abVar.sendEmptyMessage(i);
        }
    }

    public static void sendMsg(com.unisound.common.ab abVar, int i, java.lang.String str) {
        synchronized (t) {
            if (com.unisound.common.y.l) {
                com.unisound.common.y.d("SpeechSynthesizerInterface ->sendMsg what = ", java.lang.Integer.valueOf(i), " obj = ", str);
            }
            abVar.sendMessage(i, str);
        }
    }

    protected int a(java.lang.String str) {
        return 0;
    }

    protected int a(java.lang.String str, java.lang.String str2) {
        return 0;
    }

    protected int cancel() {
        int iH;
        int iC;
        int iF;
        com.unisound.common.y.c("SpeechSynthesizerInterface cancel begin");
        synchronized (t) {
            iH = h();
            iC = c();
            iF = f();
            j();
        }
        if (com.unisound.common.y.l) {
            com.unisound.common.y.d("SpeechSynthesizerInterface->cancel:stop() start");
        }
        stop();
        if (com.unisound.common.y.l) {
            com.unisound.common.y.d("SpeechSynthesizerInterface->cancel:stop() end");
        }
        if ((iF == iC || iH == -1) && com.unisound.common.y.l) {
            com.unisound.common.y.d("SpeechSynthesizerInterface cancel end -1");
        }
        com.unisound.common.y.b("SpeechSynthesizerInterface cancel end");
        return 0;
    }

    protected java.lang.Object getOption(int i) {
        if (i == 1036) {
            return com.unisound.c.a.a(this.j.F());
        }
        if (i == 2020) {
            return this.j.H();
        }
        if (i == 2033) {
            cn.yunzhisheng.tts.offline.lib.YzsTts yzsTts = this.b;
            if (yzsTts != null) {
                return yzsTts.f();
            }
            sendMsg(this.p, 225, com.unisound.client.ErrorCode.toJsonMessage(com.unisound.client.ErrorCode.TTS_ERROR_GET_ENGINE_INFO));
            return "";
        }
        if (i == 2040) {
            return java.lang.Integer.valueOf(this.j.N());
        }
        switch (i) {
            case 2001:
                return java.lang.Integer.valueOf(this.j.y());
            case 2002:
                return java.lang.Integer.valueOf(this.j.z());
            case 2003:
                return java.lang.Integer.valueOf(this.j.A());
            case 2004:
                return java.lang.Integer.valueOf(this.j.C());
            case com.unisound.client.SpeechConstants.TTS_KEY_VOICE_NAME /* 2005 */:
                return this.j.x();
            default:
                switch (i) {
                    case com.unisound.client.SpeechConstants.TTS_KEY_SERVER_ADDR /* 2011 */:
                        return this.j.f().a();
                    case com.unisound.client.SpeechConstants.TTS_KEY_PLAY_START_BUFFER_TIME /* 2012 */:
                        return java.lang.Integer.valueOf(this.j.B());
                    case com.unisound.client.SpeechConstants.TTS_KEY_STREAM_TYPE /* 2013 */:
                        return java.lang.Integer.valueOf(this.j.E());
                    case com.unisound.client.SpeechConstants.TTS_KEY_IS_DEBUG /* 2014 */:
                        return this.j.v();
                    default:
                        return null;
                }
        }
    }

    public com.unisound.sdk.bx getParams() {
        return this.j;
    }

    public java.lang.String getSessionId() {
        return this.k;
    }

    protected int getStatus() {
        return this.i;
    }

    protected java.lang.String getVersion() {
        return com.unisound.common.an.f1472a;
    }

    protected int init(java.lang.String str) {
        java.lang.Object[] objArr;
        b();
        try {
            com.unisound.c.a.a(this.h);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.unisound.client.SpeechSynthesizerListener speechSynthesizerListener = this.f;
            if (speechSynthesizerListener != null) {
                speechSynthesizerListener.onError(com.unisound.client.SpeechConstants.TTS_ERROR, com.unisound.client.ErrorCode.toJsonMessage(com.unisound.client.ErrorCode.GENERAL_NO_READ_PHONE_STATE_PERMISSION));
            }
        }
        if (str != null && !str.equals("")) {
            java.util.Map<java.lang.Integer, java.lang.Object> mapA = com.unisound.common.v.a(str, this.j.I());
            java.util.Iterator<java.lang.Integer> it = mapA.keySet().iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                if (mapA.get(java.lang.Integer.valueOf(iIntValue)) != null) {
                    setOption(iIntValue, mapA.get(java.lang.Integer.valueOf(iIntValue)));
                }
            }
            com.unisound.common.y.b("SpeechSynthesizerInterface init: jsonString init param executed");
        }
        if (this.j.p()) {
            this.o = new android.os.HandlerThread("ht_outer");
            this.o.start();
            this.p = new com.unisound.sdk.bd(this, this.o.getLooper());
        }
        if (this.n.intValue() == 1 || this.n.intValue() == 3) {
            com.unisound.common.y.b("SpeechSynthesizerInterface init: TTS_SERVICE_MODE_LOCAL");
            this.b = cn.yunzhisheng.tts.offline.lib.YzsTts.b();
            com.unisound.common.y.b("getDicModelPath= ", this.j.h(), " getSpeakerModelPath= ", this.j.g(), " getAnnotationFilePath = ", this.j.i(), " getUserDictFilePath = ", this.j.j());
            if (!this.f1525a.c() && !this.b.d()) {
                this.f1525a.a(this.j.h(), this.j.g(), this.j.i(), this.j.j());
                this.f1525a.a();
                objArr = new java.lang.Object[]{"SpeechSynthesizerInterface init: asyncTask.start()"};
            } else if (this.b.d()) {
                sendEmptyMsg(this.p, 101);
                objArr = new java.lang.Object[]{"SpeechSynthesizerInterface init: mTts.isInit()"};
            }
            com.unisound.common.y.b(objArr);
        } else if (this.n.intValue() == 2) {
            objArr = new java.lang.Object[]{"SpeechSynthesizerInterface init: TTS_SERVICE_MODE_NET"};
            com.unisound.common.y.b(objArr);
        }
        return 0;
    }

    public boolean isPlaying() {
        com.unisound.sdk.by byVar = this.e;
        if (byVar != null) {
            return byVar.k();
        }
        return false;
    }

    protected void pause() {
        com.unisound.common.y.b("SpeechSynthesizerInterface pause begin");
        com.unisound.sdk.by byVar = this.e;
        if (byVar != null) {
            byVar.d();
        }
        com.unisound.common.y.b("SpeechSynthesizerInterface pause end");
    }

    protected void playBuffer(byte[] bArr) {
        com.unisound.sdk.by byVar = this.e;
        if (byVar != null) {
            byVar.c(10000);
        }
        this.e = null;
        this.e = new com.unisound.sdk.by(this.j);
        this.e.setName("TTSPlayThread");
        this.e.a(this.s);
        this.e.a(this.l);
        this.e.start();
        this.e.a(bArr);
        this.e.h();
    }

    protected void playSynWav() {
        com.unisound.sdk.by byVar = this.e;
        if (byVar != null) {
            byVar.a((java.lang.Boolean) true);
        }
    }

    protected int playText(java.lang.String str) {
        return a(str, com.unisound.sdk.be.synAndPlay);
    }

    public int predictVoiceLength(java.lang.String str) {
        java.lang.String str2;
        if (android.text.TextUtils.isEmpty(str)) {
            return 0;
        }
        if (this.u) {
            this.r.a(com.unisound.client.ErrorCode.TTS_ERROR_OFFLINE_SYNTHESIZER_SET_TEXT);
            str2 = "predictVoiceLength(): predictVoiceLength must called before playTxt() or after play stop ";
        } else {
            if (this.n.intValue() != 1 && this.n.intValue() != 3) {
                return 0;
            }
            this.b = cn.yunzhisheng.tts.offline.lib.YzsTts.b();
            cn.yunzhisheng.tts.offline.lib.YzsTts yzsTts = this.b;
            if (yzsTts.setText(yzsTts.a(), str) == 0) {
                return this.b.g();
            }
            this.r.a(com.unisound.client.ErrorCode.TTS_ERROR_OFFLINE_SYNTHESIZER_SET_TEXT);
            str2 = "predictVoiceLength(): setText error ";
        }
        com.unisound.common.y.a(str2);
        return 0;
    }

    protected int release(int i, java.lang.String str) {
        int iE;
        com.unisound.common.y.b("SpeechSynthesizerInterface release begin");
        if (i != 2401) {
            com.unisound.common.y.a("SpeechSynthesizerInterface release : release type error");
            iE = 0;
        } else {
            stop();
            if (this.c != null) {
                iE = e();
            } else {
                cn.yunzhisheng.tts.offline.lib.YzsTts yzsTts = this.b;
                if (yzsTts != null) {
                    yzsTts.c();
                    this.b = null;
                    sendEmptyMsg(this.p, 112);
                }
                iE = 0;
            }
            com.unisound.sdk.bu buVar = this.c;
            if (buVar != null) {
                buVar.b(10000);
            }
            com.unisound.sdk.by byVar = this.e;
            if (byVar != null) {
                byVar.c(10000);
            }
        }
        com.unisound.common.y.b("SpeechSynthesizerInterface release end");
        return iE;
    }

    protected void resume() {
        com.unisound.common.y.b("SpeechSynthesizerInterface resume begin");
        com.unisound.sdk.by byVar = this.e;
        if (byVar != null) {
            byVar.f();
        }
        com.unisound.common.y.b("SpeechSynthesizerInterface resume end");
    }

    protected int setAudioSource(com.unisound.client.IAudioSource iAudioSource) {
        this.l = iAudioSource;
        return 0;
    }

    protected void setOption(int i, java.lang.Object obj) {
        if (i == 1) {
            this.j.D(obj);
        }
        if (i == 2505) {
            this.j.a(((java.lang.Integer) obj).intValue());
            return;
        }
        switch (i) {
            case com.unisound.client.SpeechConstants.DEBUG_SAVE_PCM /* 1601 */:
                com.unisound.common.y.r = ((java.lang.Boolean) obj).booleanValue();
                break;
            case com.unisound.client.SpeechConstants.DEBUG_SAVE_WAV /* 1602 */:
                com.unisound.common.y.s = ((java.lang.Boolean) obj).booleanValue();
                break;
            default:
                switch (i) {
                    case 2001:
                        this.j.n(obj);
                        break;
                    case 2002:
                        this.j.o(obj);
                        break;
                    case 2003:
                        this.j.p(obj);
                        break;
                    case 2004:
                        java.lang.Integer num = (java.lang.Integer) obj;
                        this.j.b(num.intValue());
                        this.g = num.intValue();
                        break;
                    case com.unisound.client.SpeechConstants.TTS_KEY_VOICE_NAME /* 2005 */:
                        this.j.m(obj);
                        break;
                    default:
                        switch (i) {
                            case com.unisound.client.SpeechConstants.TTS_KEY_SERVER_ADDR /* 2011 */:
                                this.j.t(obj);
                                break;
                            case com.unisound.client.SpeechConstants.TTS_KEY_PLAY_START_BUFFER_TIME /* 2012 */:
                                this.j.q(obj);
                                break;
                            case com.unisound.client.SpeechConstants.TTS_KEY_STREAM_TYPE /* 2013 */:
                                this.j.u(obj);
                                break;
                            case com.unisound.client.SpeechConstants.TTS_KEY_IS_DEBUG /* 2014 */:
                                this.j.k(obj);
                                com.unisound.common.y.k = this.j.v().booleanValue();
                                com.unisound.c.a.b(((java.lang.Boolean) obj).booleanValue());
                                break;
                            case 2015:
                                this.j.l(obj);
                                break;
                            case 2016:
                                this.j.j(obj);
                                break;
                            default:
                                switch (i) {
                                    case com.unisound.client.SpeechConstants.TTS_SERVICE_MODE /* 2020 */:
                                        this.n = (java.lang.Integer) obj;
                                        this.j.w(obj);
                                        break;
                                    case com.unisound.client.SpeechConstants.TTS_KEY_IS_READ_ENLISH_IN_PINYIN /* 2021 */:
                                        this.j.g(obj);
                                        break;
                                    case com.unisound.client.SpeechConstants.TTS_KEY_FRONT_SILENCE /* 2022 */:
                                        this.j.h(obj);
                                        break;
                                    case com.unisound.client.SpeechConstants.TTS_KEY_BACK_SILENCE /* 2023 */:
                                        this.j.i(obj);
                                        break;
                                    case com.unisound.client.SpeechConstants.TTS_KEY_IS_URGENT_AUDIO /* 2024 */:
                                        this.j.f(obj);
                                        break;
                                    case com.unisound.client.SpeechConstants.TTS_KEY_IS_USE_HANDLERTHREAD /* 2025 */:
                                        this.j.e(obj);
                                        break;
                                    default:
                                        switch (i) {
                                            case com.unisound.client.SpeechConstants.TTS_KEY_FRONTEND_MODEL_PATH /* 2030 */:
                                                this.j.b(obj);
                                                break;
                                            case com.unisound.client.SpeechConstants.TTS_KEY_BACKEND_MODEL_PATH /* 2031 */:
                                                this.j.a(obj);
                                                break;
                                            case com.unisound.client.SpeechConstants.TTS_KEY_SWITCH_BACKEND_MODEL_PATH /* 2032 */:
                                                cancel();
                                                com.unisound.common.y.b("SpeechSynthesizerInterface setOption switch backend_model: ", obj);
                                                this.j.a(obj);
                                                l();
                                                break;
                                            default:
                                                switch (i) {
                                                    case com.unisound.client.SpeechConstants.TTS_KEY_ANNOTATION_FILE_PATH /* 2034 */:
                                                        this.j.c(obj);
                                                        break;
                                                    case com.unisound.client.SpeechConstants.TTS_KEY_USER_DICT_FILE_PATH /* 2035 */:
                                                        this.j.d(obj);
                                                        break;
                                                    case com.unisound.client.SpeechConstants.TTS_KEY_USE_SENTENCE_MODE /* 2036 */:
                                                        this.j.y(obj);
                                                        break;
                                                    case com.unisound.client.SpeechConstants.TTS_KEY_SENTENCE_MAX_TIME /* 2037 */:
                                                        this.j.x(obj);
                                                        break;
                                                    case com.unisound.client.SpeechConstants.TTS_KEY_SENTENCE_BUFFER_TIMES /* 2038 */:
                                                        this.j.z(obj);
                                                        break;
                                                    case com.unisound.client.SpeechConstants.TTS_KEY_DEBUG_RTF /* 2039 */:
                                                        this.j.A(obj);
                                                        break;
                                                    case com.unisound.client.SpeechConstants.TTS_KEY_VOICE_LOUD /* 2040 */:
                                                        this.j.B(obj);
                                                        break;
                                                    case com.unisound.client.SpeechConstants.TTS_KEY_DOMAIN /* 2041 */:
                                                        this.j.C(obj);
                                                        break;
                                                    default:
                                                        switch (i) {
                                                            case com.unisound.client.SpeechConstants.TTS_KEY_FRONTEND_MODEL_STREAM /* 2130 */:
                                                                this.j.a((java.io.InputStream) obj);
                                                                break;
                                                            case com.unisound.client.SpeechConstants.TTS_KEY_BACKEND_MODEL_STREAM /* 2131 */:
                                                                this.j.b((java.io.InputStream) obj);
                                                                break;
                                                            default:
                                                                switch (i) {
                                                                    case com.unisound.client.SpeechConstants.TTS_KEY_ANNOTATION_FILE_STREAM /* 2134 */:
                                                                        this.j.c((java.io.InputStream) obj);
                                                                        break;
                                                                    case com.unisound.client.SpeechConstants.TTS_KEY_USER_DICT_FILE_STREAM /* 2135 */:
                                                                        this.j.d((java.io.InputStream) obj);
                                                                        break;
                                                                }
                                                                break;
                                                        }
                                                        break;
                                                }
                                                break;
                                        }
                                        break;
                                }
                                break;
                        }
                        break;
                }
                break;
        }
    }

    public void setServer(java.lang.String str, short s) {
        this.j.a(new java.lang.String(str), s);
    }

    protected void setTTSListener(com.unisound.client.SpeechSynthesizerListener speechSynthesizerListener) {
        this.f = speechSynthesizerListener;
    }

    protected void stop() {
        com.unisound.common.y.c("SpeechSynthesizerInterface stop begin");
        i();
        d();
        g();
        com.unisound.common.y.c("SpeechSynthesizerInterface stop end");
    }

    protected void synthesizeText(java.lang.String str) {
        a(str, com.unisound.sdk.be.onlySyn);
    }
}
