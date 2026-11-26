package com.unisound.client;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class SpeechSynthesizer extends com.unisound.sdk.az {
    public SpeechSynthesizer(android.content.Context context, java.lang.String str, java.lang.String str2) {
        super(context, str, str2);
    }

    @Override // com.unisound.sdk.az
    public int cancel() {
        return super.cancel();
    }

    @Override // com.unisound.sdk.az
    public java.lang.Object getOption(int i) {
        return super.getOption(i);
    }

    @Override // com.unisound.sdk.az
    public int getStatus() {
        return super.getStatus();
    }

    @Override // com.unisound.sdk.az
    public java.lang.String getVersion() {
        return super.getVersion();
    }

    @Override // com.unisound.sdk.az
    public int init(java.lang.String str) {
        return super.init(str);
    }

    @Override // com.unisound.sdk.az
    public void pause() {
        super.pause();
    }

    @Override // com.unisound.sdk.az
    public void playBuffer(byte[] bArr) {
        super.playBuffer(bArr);
    }

    @Override // com.unisound.sdk.az
    public void playSynWav() {
        super.playSynWav();
    }

    @Override // com.unisound.sdk.az
    public int playText(java.lang.String str) {
        return super.playText(str);
    }

    @Override // com.unisound.sdk.az
    public int predictVoiceLength(java.lang.String str) {
        return super.predictVoiceLength(str);
    }

    @Override // com.unisound.sdk.az
    public int release(int i, java.lang.String str) {
        return super.release(i, str);
    }

    @Override // com.unisound.sdk.az
    public void resume() {
        super.resume();
    }

    @Override // com.unisound.sdk.az
    public int setAudioSource(com.unisound.client.IAudioSource iAudioSource) {
        return super.setAudioSource(iAudioSource);
    }

    @Override // com.unisound.sdk.az
    public void setOption(int i, java.lang.Object obj) {
        super.setOption(i, obj);
    }

    @Override // com.unisound.sdk.az
    public void setTTSListener(com.unisound.client.SpeechSynthesizerListener speechSynthesizerListener) {
        super.setTTSListener(speechSynthesizerListener);
    }

    @Override // com.unisound.sdk.az
    public void stop() {
        super.stop();
    }

    @Override // com.unisound.sdk.az
    public void synthesizeText(java.lang.String str) {
        super.synthesizeText(str);
    }
}
