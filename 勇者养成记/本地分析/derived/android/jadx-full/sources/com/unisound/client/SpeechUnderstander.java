package com.unisound.client;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class SpeechUnderstander extends com.unisound.sdk.bg {
    public SpeechUnderstander(android.content.Context context, java.lang.String str, java.lang.String str2) {
        super(context, str, str2);
    }

    @Override // com.unisound.sdk.bg, com.unisound.sdk.o
    public void cancel() {
        super.cancel();
    }

    @Override // com.unisound.sdk.bg
    public java.lang.String convertToArabicNumber(java.lang.String str) {
        return super.convertToArabicNumber(str);
    }

    @Override // com.unisound.sdk.bg, com.unisound.sdk.o
    public java.lang.Object getOption(int i) {
        return super.getOption(i);
    }

    @Override // com.unisound.sdk.bg, com.unisound.sdk.o
    public java.lang.String getVersion() {
        return super.getVersion();
    }

    @Override // com.unisound.sdk.bg
    public void init(java.lang.String str) {
        super.init(str);
    }

    @Override // com.unisound.sdk.bg
    public int insertVocab(java.util.List<java.lang.String> list, java.lang.String str) {
        return super.insertVocab(list, str);
    }

    @Override // com.unisound.sdk.bg
    public int insertVocab_ext(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return super.insertVocab_ext(str, str2, str3);
    }

    @Override // com.unisound.sdk.bg
    public int insertVocab_ext(java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.util.List<java.lang.String>> map) {
        return super.insertVocab_ext(str, str2, map);
    }

    @Override // com.unisound.sdk.bg
    public int release(int i, java.lang.String str) {
        return super.release(i, str);
    }

    @Override // com.unisound.sdk.bg, com.unisound.sdk.o
    public int setAudioSource(com.unisound.client.IAudioSource iAudioSource) {
        return super.setAudioSource(iAudioSource);
    }

    @Override // com.unisound.sdk.bg
    public void setListener(com.unisound.client.SpeechUnderstanderListener speechUnderstanderListener) {
        super.setListener(speechUnderstanderListener);
    }

    @Override // com.unisound.sdk.bg
    public java.lang.String setOnlineWakeupWord(java.util.List<java.lang.String> list) {
        return super.setOnlineWakeupWord(list);
    }

    @Override // com.unisound.sdk.bg, com.unisound.sdk.o
    public void setOption(int i, java.lang.Object obj) {
        super.setOption(i, obj);
    }

    @Override // com.unisound.sdk.bg, com.unisound.sdk.o
    public void start() throws java.lang.Throwable {
        super.start();
    }

    @Override // com.unisound.sdk.bg, com.unisound.sdk.o
    public void stop() throws java.lang.Throwable {
        super.stop();
    }

    @Override // com.unisound.sdk.bg
    public void uploadUserData(java.util.Map<java.lang.Integer, java.util.List<java.lang.String>> map) {
        super.uploadUserData(map);
    }
}
