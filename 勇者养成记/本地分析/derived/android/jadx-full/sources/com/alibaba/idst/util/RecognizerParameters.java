package com.alibaba.idst.util;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class RecognizerParameters {
    private java.lang.String appkey;
    private java.lang.Boolean intermediateResult;
    private java.lang.Boolean inverseTextNormalization;
    private java.lang.Integer maxEndSilence;
    private java.lang.Integer maxStartSilence;
    private java.lang.String params;
    private java.lang.Boolean punctuationPrediction;
    private java.lang.String token;
    private java.lang.Boolean voiceDetection;

    public void enableVoiceDetection(java.lang.Boolean bool) {
        this.voiceDetection = bool;
    }

    public java.lang.String getAppkey() {
        return this.appkey;
    }

    public java.lang.Boolean getIntermediateResult() {
        return this.intermediateResult;
    }

    public java.lang.Boolean getInverseTextNormalization() {
        return this.inverseTextNormalization;
    }

    public java.lang.Integer getMaxEndSilence() {
        return this.maxEndSilence;
    }

    public java.lang.Integer getMaxStartSilence() {
        return this.maxStartSilence;
    }

    public java.lang.String getParams() {
        return this.params;
    }

    public java.lang.Boolean getPunctuationPrediction() {
        return this.punctuationPrediction;
    }

    public java.lang.String getToken() {
        return this.token;
    }

    public java.lang.Boolean getVoiceDetection() {
        return this.voiceDetection;
    }

    public void setAppkey(java.lang.String str) {
        this.appkey = str;
    }

    public void setIntermediateResult(java.lang.Boolean bool) {
        this.intermediateResult = bool;
    }

    public void setInverseTextNormalization(java.lang.Boolean bool) {
        this.inverseTextNormalization = bool;
    }

    public void setMaxEndSilence(java.lang.Integer num) {
        this.maxEndSilence = num;
    }

    public void setMaxStartSilence(java.lang.Integer num) {
        this.maxStartSilence = num;
    }

    public void setParams(java.lang.String str) {
        this.params = str;
    }

    public void setPunctuationPrediction(java.lang.Boolean bool) {
        this.punctuationPrediction = bool;
    }

    public void setPunctuationPrediction(boolean z) {
        this.punctuationPrediction = java.lang.Boolean.valueOf(z);
    }

    public void setToken(java.lang.String str) {
        this.token = str;
    }
}
