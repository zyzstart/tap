package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class bq extends android.os.Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.unisound.sdk.bg f1541a;

    public bq(com.unisound.sdk.bg bgVar) {
        this.f1541a = bgVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bq(com.unisound.sdk.bg bgVar, android.os.Looper looper) {
        super(looper);
        this.f1541a = bgVar;
    }

    @Override // android.os.Handler
    public void handleMessage(android.os.Message message) {
        com.unisound.client.SpeechUnderstanderListener speechUnderstanderListener;
        int i;
        com.unisound.client.SpeechUnderstanderListener speechUnderstanderListener2;
        int i2;
        java.lang.String jsonMessage;
        com.unisound.client.SpeechUnderstanderListener speechUnderstanderListener3;
        int i3;
        int i4 = message.what;
        switch (i4) {
            case 5:
                com.unisound.common.y.c("recognition End");
                if (this.f1541a.z != null && !this.f1541a.av) {
                    this.f1541a.z.onEvent(com.unisound.client.SpeechConstants.ASR_EVENT_RECOGNITION_END, (int) java.lang.System.currentTimeMillis());
                }
                this.f1541a.u.clear();
                this.f1541a.v.clear();
                this.f1541a.w.clear();
                com.unisound.common.v.a();
                this.f1541a.ax = false;
                return;
            case 6:
                if (this.f1541a.z == null || this.f1541a.av) {
                    return;
                }
                speechUnderstanderListener = this.f1541a.z;
                i = com.unisound.client.SpeechConstants.ASR_EVENT_LOCAL_END;
                break;
            case 7:
                if (this.f1541a.z == null || this.f1541a.av) {
                    return;
                }
                speechUnderstanderListener = this.f1541a.z;
                i = com.unisound.client.SpeechConstants.ASR_EVENT_NET_END;
                break;
            default:
                switch (i4) {
                    case 11:
                        if (this.f1541a.z != null && !this.f1541a.av) {
                            speechUnderstanderListener = this.f1541a.z;
                            i = com.unisound.client.SpeechConstants.ASR_EVENT_RECORDING_START;
                            break;
                        }
                        break;
                    case 12:
                        if (this.f1541a.z != null && !this.f1541a.av) {
                            this.f1541a.z.onEvent(com.unisound.client.SpeechConstants.ASR_EVENT_RECORDING_STOP, (int) java.lang.System.currentTimeMillis());
                            this.f1541a.ay = true;
                            if (this.f1541a.ax) {
                                this.f1541a.z.onEvent(com.unisound.client.SpeechConstants.ASR_EVENT_RECOGNITION_END, (int) java.lang.System.currentTimeMillis());
                            }
                            break;
                        }
                        break;
                    case 13:
                        if (this.f1541a.z != null && !this.f1541a.av) {
                            speechUnderstanderListener = this.f1541a.z;
                            i = com.unisound.client.SpeechConstants.ASR_EVENT_SPEECH_DETECTED;
                            break;
                        }
                        break;
                    case 14:
                        if (this.f1541a.z == null || this.f1541a.av) {
                        }
                        this.f1541a.z.onEvent(1131, (int) java.lang.System.currentTimeMillis());
                        break;
                    case 15:
                        if (this.f1541a.z != null) {
                            speechUnderstanderListener = this.f1541a.z;
                            i = com.unisound.client.SpeechConstants.ASR_EVENT_CANCEL;
                        }
                        break;
                    case 16:
                        if (this.f1541a.z != null) {
                            speechUnderstanderListener = this.f1541a.z;
                            i = com.unisound.client.SpeechConstants.ASR_EVENT_USERDATA_UPLOADED;
                        }
                        break;
                    case 17:
                        if (this.f1541a.z != null && !this.f1541a.av) {
                            speechUnderstanderListener = this.f1541a.z;
                            i = com.unisound.client.SpeechConstants.ASR_EVENT_VOLUMECHANGE;
                            break;
                        }
                        break;
                    case 18:
                        if (this.f1541a.z != null && !this.f1541a.av) {
                            speechUnderstanderListener = this.f1541a.z;
                            i = com.unisound.client.SpeechConstants.ASR_EVENT_VAD_TIMEOUT;
                            break;
                        }
                        break;
                    default:
                        switch (i4) {
                            case 20:
                                if (this.f1541a.z != null && !this.f1541a.av) {
                                    speechUnderstanderListener = this.f1541a.z;
                                    i = com.unisound.client.SpeechConstants.ASR_EVENT_SPEECH_END;
                                    break;
                                }
                                break;
                            case 21:
                                if (this.f1541a.z == null) {
                                }
                                this.f1541a.z.onEvent(1131, (int) java.lang.System.currentTimeMillis());
                                break;
                            case 22:
                                if (this.f1541a.z != null) {
                                    speechUnderstanderListener = this.f1541a.z;
                                    i = com.unisound.client.SpeechConstants.ASR_EVENT_COMPILE_VOCAB_DONE;
                                }
                                break;
                            case 23:
                                if (this.f1541a.z != null) {
                                    speechUnderstanderListener = this.f1541a.z;
                                    i = com.unisound.client.SpeechConstants.ASR_EVENT_COMPILE_WAKEUP_WORD_DONE;
                                }
                                break;
                            case 24:
                                if (this.f1541a.z != null) {
                                    speechUnderstanderListener = this.f1541a.z;
                                    i = com.unisound.client.SpeechConstants.ASR_EVENT_COMPILER_INIT_DONE;
                                }
                                break;
                            default:
                                switch (i4) {
                                    case 53:
                                        if (this.f1541a.z != null) {
                                            speechUnderstanderListener2 = this.f1541a.z;
                                            i2 = 3301;
                                            jsonMessage = com.unisound.client.ErrorCode.toJsonMessage(((java.lang.Integer) message.obj).intValue());
                                            speechUnderstanderListener2.onError(i2, jsonMessage);
                                        }
                                        break;
                                    case 54:
                                        if (this.f1541a.z != null) {
                                            speechUnderstanderListener2 = this.f1541a.z;
                                            i2 = com.unisound.client.SpeechConstants.ASR_ERROR;
                                            jsonMessage = com.unisound.client.ErrorCode.toJsonMessage(((java.lang.Integer) message.obj).intValue());
                                            speechUnderstanderListener2.onError(i2, jsonMessage);
                                        }
                                        break;
                                    default:
                                        switch (i4) {
                                            case 60:
                                                if (this.f1541a.z != null) {
                                                    speechUnderstanderListener2 = this.f1541a.z;
                                                    i2 = message.arg1;
                                                    jsonMessage = (java.lang.String) message.obj;
                                                    speechUnderstanderListener2.onError(i2, jsonMessage);
                                                }
                                                break;
                                            case 61:
                                                if (this.f1541a.z != null) {
                                                    speechUnderstanderListener3 = this.f1541a.z;
                                                    i3 = message.arg1;
                                                    speechUnderstanderListener3.onResult(i3, (java.lang.String) message.obj);
                                                }
                                                break;
                                            case 62:
                                                if (this.f1541a.z != null) {
                                                    this.f1541a.z.onEvent(message.arg1, message.arg2);
                                                }
                                                break;
                                            default:
                                                switch (i4) {
                                                    case 1201:
                                                        if (this.f1541a.z != null && !this.f1541a.av) {
                                                            speechUnderstanderListener3 = this.f1541a.z;
                                                            i3 = 1201;
                                                            speechUnderstanderListener3.onResult(i3, (java.lang.String) message.obj);
                                                            break;
                                                        }
                                                        break;
                                                    case 1202:
                                                        if (this.f1541a.z != null && !this.f1541a.av) {
                                                            speechUnderstanderListener3 = this.f1541a.z;
                                                            i3 = 1202;
                                                            speechUnderstanderListener3.onResult(i3, (java.lang.String) message.obj);
                                                            break;
                                                        }
                                                        break;
                                                    default:
                                                        switch (i4) {
                                                            case 1:
                                                                if (this.f1541a.z != null && !this.f1541a.av) {
                                                                    speechUnderstanderListener = this.f1541a.z;
                                                                    i = 3103;
                                                                    break;
                                                                }
                                                                break;
                                                            case 30:
                                                                if (this.f1541a.z != null) {
                                                                    speechUnderstanderListener = this.f1541a.z;
                                                                    i = com.unisound.client.SpeechConstants.ASR_EVENT_SESSIONID_CHANGED;
                                                                }
                                                                break;
                                                            case 40:
                                                                if (this.f1541a.z != null) {
                                                                    speechUnderstanderListener = this.f1541a.z;
                                                                    i = com.unisound.client.SpeechConstants.ASR_EVENT_ACTIVATE_SUCCESS;
                                                                }
                                                                break;
                                                            case 50:
                                                                if (this.f1541a.z != null) {
                                                                    speechUnderstanderListener = this.f1541a.z;
                                                                    i = com.unisound.client.SpeechConstants.ASR_EVENT_UPLOAD_ONLINE_ONESHOT_WAKEUPWORD_SUCCESS;
                                                                }
                                                                break;
                                                            case com.unisound.client.SpeechConstants.ASR_EVENT_INIT_DONE /* 1129 */:
                                                                if (this.f1541a.z != null && !this.f1541a.av) {
                                                                    speechUnderstanderListener = this.f1541a.z;
                                                                    i = com.unisound.client.SpeechConstants.ASR_EVENT_INIT_DONE;
                                                                    break;
                                                                }
                                                                break;
                                                            case com.unisound.client.SpeechConstants.ASR_RESULT_RECOGNITION /* 1210 */:
                                                                if (this.f1541a.z != null && !this.f1541a.av) {
                                                                    speechUnderstanderListener3 = this.f1541a.z;
                                                                    i3 = com.unisound.client.SpeechConstants.ASR_RESULT_RECOGNITION;
                                                                    speechUnderstanderListener3.onResult(i3, (java.lang.String) message.obj);
                                                                    break;
                                                                }
                                                                break;
                                                            case 3201:
                                                                if (this.f1541a.z != null && !this.f1541a.av) {
                                                                    speechUnderstanderListener3 = this.f1541a.z;
                                                                    i3 = 3201;
                                                                    speechUnderstanderListener3.onResult(i3, (java.lang.String) message.obj);
                                                                    break;
                                                                }
                                                                break;
                                                            default:
                                                                if (this.f1541a.z != null) {
                                                                    this.f1541a.z.onEvent(message.what, (int) java.lang.System.currentTimeMillis());
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
                return;
        }
        speechUnderstanderListener.onEvent(i, (int) java.lang.System.currentTimeMillis());
    }
}
