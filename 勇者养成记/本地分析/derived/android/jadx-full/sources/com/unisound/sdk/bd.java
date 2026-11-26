package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class bd extends com.unisound.common.ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.unisound.sdk.az f1530a;

    public bd(com.unisound.sdk.az azVar) {
        this.f1530a = azVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bd(com.unisound.sdk.az azVar, android.os.Looper looper) {
        super(looper);
        this.f1530a = azVar;
    }

    @Override // com.unisound.common.ab
    public boolean a(android.os.Message message) {
        int i;
        com.unisound.client.SpeechSynthesizerListener speechSynthesizerListener = this.f1530a.f;
        if (speechSynthesizerListener == null) {
            return false;
        }
        int i2 = message.what;
        if (i2 != 114) {
            if (i2 != 225) {
                switch (i2) {
                    case 101:
                        i = com.unisound.client.SpeechConstants.TTS_EVENT_INIT;
                        break;
                    case 102:
                        i = com.unisound.client.SpeechConstants.TTS_EVENT_SYNTHESIZER_START;
                        break;
                    case 103:
                        i = com.unisound.client.SpeechConstants.TTS_EVENT_SYNTHESIZER_END;
                        break;
                    case 104:
                        i = com.unisound.client.SpeechConstants.TTS_EVENT_BUFFER_BEGIN;
                        break;
                    case 105:
                        i = com.unisound.client.SpeechConstants.TTS_EVENT_BUFFER_READY;
                        break;
                    case 106:
                        i = com.unisound.client.SpeechConstants.TTS_EVENT_PLAYING_START;
                        break;
                    case 107:
                        i = com.unisound.client.SpeechConstants.TTS_EVENT_PLAYING_END;
                        break;
                    case 108:
                        i = com.unisound.client.SpeechConstants.TTS_EVENT_PAUSE;
                        break;
                    case 109:
                        i = com.unisound.client.SpeechConstants.TTS_EVENT_RESUME;
                        break;
                    case 110:
                        return true;
                    case 111:
                        i = com.unisound.client.SpeechConstants.TTS_EVENT_STOP;
                        break;
                    case 112:
                        i = com.unisound.client.SpeechConstants.TTS_EVENT_RELEASE;
                        break;
                    default:
                        switch (i2) {
                            case 200:
                            case 201:
                            case 202:
                                break;
                            default:
                                switch (i2) {
                                    case 210:
                                    case 211:
                                    case 212:
                                        break;
                                    default:
                                        return false;
                                }
                                break;
                        }
                        break;
                }
            }
            speechSynthesizerListener.onError(com.unisound.client.SpeechConstants.TTS_ERROR, (java.lang.String) message.obj);
            return true;
        }
        i = com.unisound.client.SpeechConstants.TTS_EVENT_SWITCH_FRONTEND_MODEL_SUCCESS;
        speechSynthesizerListener.onEvent(i);
        return true;
    }

    @Override // com.unisound.common.ab
    public void sendMessage(int i) {
        super.sendMessage(i);
    }
}
