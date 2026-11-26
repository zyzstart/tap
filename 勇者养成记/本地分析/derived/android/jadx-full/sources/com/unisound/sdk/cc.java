package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class cc extends com.unisound.common.ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f1548a = 100;
    private static final int b = 101;
    private static final int c = 102;
    private com.unisound.client.TextUnderstanderListener d;
    private com.unisound.sdk.cn e;
    private com.unisound.sdk.cm f;
    private android.content.Context g;
    private com.unisound.sdk.cl h = new com.unisound.sdk.cd(this);

    protected cc(android.content.Context context, java.lang.String str, java.lang.String str2) {
        this.g = context;
        this.f = new com.unisound.sdk.cm(str, str2);
        this.f.f(com.unisound.c.a.s);
    }

    private void a(java.lang.String str) {
        com.unisound.sdk.cn cnVar = this.e;
        if (cnVar != null) {
            cnVar.c();
        }
        this.e = new com.unisound.sdk.cn(this.f);
        this.e.a(str);
        this.e.a(this.h);
        this.e.start();
    }

    protected void cancel() {
        com.unisound.sdk.cn cnVar = this.e;
        if (cnVar != null) {
            cnVar.c();
            this.e = null;
        }
    }

    protected java.lang.Object getOption(int i) {
        if (i == 1036) {
            return com.unisound.c.a.a(this.f.b());
        }
        switch (i) {
            case 1021:
                return this.f.n();
            case com.unisound.client.SpeechConstants.NLU_SERVER_ADDR /* 1022 */:
                return this.f.t();
            case com.unisound.client.SpeechConstants.NLU_PARAMS /* 1023 */:
                return this.f.x();
            default:
                switch (i) {
                    case com.unisound.client.SpeechConstants.GENERAL_HISTORY /* 1030 */:
                        return this.f.i();
                    case com.unisound.client.SpeechConstants.GENERAL_CITY /* 1031 */:
                        return this.f.j();
                    case 1032:
                        return this.f.m();
                    case 1033:
                        return this.f.f();
                    default:
                        return null;
                }
        }
    }

    @Override // com.unisound.common.ab, android.os.Handler
    public void handleMessage(android.os.Message message) {
        switch (message.what) {
            case 100:
                java.lang.String str = (java.lang.String) message.obj;
                com.unisound.client.TextUnderstanderListener textUnderstanderListener = this.d;
                if (textUnderstanderListener != null) {
                    textUnderstanderListener.onResult(1000, str);
                }
                break;
            case 101:
                if (this.d != null) {
                    this.d.onEvent(((java.lang.Integer) message.obj).intValue());
                }
                break;
            case 102:
                if (this.d != null) {
                    int iIntValue = ((java.lang.Integer) message.obj).intValue();
                    this.d.onError(iIntValue, com.unisound.client.ErrorCode.toMessage(iIntValue));
                }
                break;
        }
    }

    protected int init(java.lang.String str) {
        try {
            com.unisound.c.a.a(this.g);
            return 0;
        } catch (java.lang.Exception e) {
            if (this.d != null) {
                sendMessage(102, java.lang.Integer.valueOf(com.unisound.client.ErrorCode.GENERAL_NO_READ_PHONE_STATE_PERMISSION));
            }
            e.printStackTrace();
            return 0;
        }
    }

    protected void setListener(com.unisound.client.TextUnderstanderListener textUnderstanderListener) {
        this.d = textUnderstanderListener;
    }

    protected void setOption(int i, java.lang.Object obj) {
        java.lang.String str;
        switch (i) {
            case 1021:
                try {
                    this.f.k((java.lang.String) obj);
                    return;
                } catch (java.lang.Exception unused) {
                    str = "set nlu_scenario Error.";
                }
                break;
            case com.unisound.client.SpeechConstants.NLU_SERVER_ADDR /* 1022 */:
                try {
                    java.lang.String str2 = (java.lang.String) obj;
                    if (str2 != null && str2.contains(":")) {
                        java.lang.String[] strArrSplit = str2.split(":");
                        java.lang.String str3 = strArrSplit[0];
                        try {
                            this.f.a(str3, java.lang.Integer.parseInt(strArrSplit[1]));
                        } catch (java.lang.NumberFormatException unused2) {
                            com.unisound.common.y.a("nlu server set Error.");
                        }
                        break;
                    } else {
                        com.unisound.common.y.a("nlu server set Error.");
                    }
                    return;
                } catch (java.lang.Exception unused3) {
                    str = "set nlu_server_address Error.";
                }
                break;
            case com.unisound.client.SpeechConstants.NLU_PARAMS /* 1023 */:
                try {
                    this.f.a((com.unisound.sdk.cm) obj);
                    return;
                } catch (java.lang.Exception unused4) {
                    str = "set nlu_params Error.";
                }
                break;
            case 1024:
                try {
                    this.f.d(java.lang.String.valueOf(obj));
                    return;
                } catch (java.lang.Exception unused5) {
                    str = "set nlu_ver Error.";
                }
                break;
            case 1025:
                try {
                    this.f.f(java.lang.String.valueOf(obj));
                    return;
                } catch (java.lang.Exception unused6) {
                    str = "set nlu_appver Error.";
                }
                break;
            default:
                switch (i) {
                    case com.unisound.client.SpeechConstants.GENERAL_HISTORY /* 1030 */:
                        try {
                            this.f.h((java.lang.String) obj);
                            return;
                        } catch (java.lang.Exception unused7) {
                            str = "set history Error.";
                        }
                        break;
                    case com.unisound.client.SpeechConstants.GENERAL_CITY /* 1031 */:
                        try {
                            this.f.i((java.lang.String) obj);
                            return;
                        } catch (java.lang.Exception unused8) {
                            str = "set city Error.";
                        }
                        break;
                    case 1032:
                        try {
                            this.f.j((java.lang.String) obj);
                            return;
                        } catch (java.lang.Exception unused9) {
                            str = "set voiceID Error.";
                        }
                        break;
                    case 1033:
                        try {
                            this.f.e((java.lang.String) obj);
                            return;
                        } catch (java.lang.Exception unused10) {
                            str = "set gps Error.";
                        }
                        break;
                    default:
                        switch (i) {
                            case com.unisound.client.SpeechConstants.DEBUG_SAVE_PCM /* 1601 */:
                                com.unisound.common.y.r = ((java.lang.Boolean) obj).booleanValue();
                                break;
                            case com.unisound.client.SpeechConstants.DEBUG_SAVE_WAV /* 1602 */:
                                com.unisound.common.y.s = ((java.lang.Boolean) obj).booleanValue();
                                break;
                        }
                        return;
                }
                break;
        }
        com.unisound.common.y.a(str);
    }

    protected void setText(java.lang.String str) {
        if (str == null || str.length() == 0) {
            sendMessage(100, "");
        } else {
            a(str);
        }
    }
}
