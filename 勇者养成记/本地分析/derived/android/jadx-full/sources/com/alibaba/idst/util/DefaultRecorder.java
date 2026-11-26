package com.alibaba.idst.util;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class DefaultRecorder implements java.lang.Runnable {
    static final int STATUS_FAILED = -1;
    static final int STATUS_READY = 0;
    static final int STATUS_STARTING = 1;
    static final int STATUS_STOPPING = 7;
    static final int STATUS_WORKING = 6;
    private static final java.lang.String TAG = "AliSpeechSDK";
    int SAMPLES_PER_FRAME = 640;
    private com.alibaba.idst.util.RecorderCallbackWithStatus callback;
    private android.media.AudioRecord mAudioRecorder;
    private volatile int status;
    private java.lang.Thread thread;

    public DefaultRecorder(com.alibaba.idst.util.RecorderCallbackWithStatus recorderCallbackWithStatus) {
        this.callback = recorderCallbackWithStatus;
        android.util.Log.d(TAG, "init audio recorder");
        this.mAudioRecorder = new android.media.AudioRecord(1, 16000, 16, 2, android.media.AudioRecord.getMinBufferSize(16000, 16, 2) * 2);
        android.util.Log.d(TAG, "inited audio recorder");
        this.status = 0;
    }

    private int calculateVolume(byte[] bArr, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3 += 2) {
            int i4 = (bArr[i3] & 255) + ((bArr[i3 + 1] & 255) << 8);
            if (i4 >= 32768) {
                i4 = android.support.v4.internal.view.SupportMenu.USER_MASK - i4;
            }
            if (i4 > i2) {
                i2 = i4;
            }
        }
        double d = i2 >> 7;
        java.lang.Double.isNaN(d);
        return (int) (d / 2.55d);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            android.util.Log.d(TAG, "DefaultRecorder before onPre()");
            this.callback.onPre();
            android.util.Log.d(TAG, "DefaultRecorder after onPre()");
            byte[] bArr = new byte[this.SAMPLES_PER_FRAME];
            while (this.status == 6) {
                int i = this.mAudioRecorder.read(bArr, 0, this.SAMPLES_PER_FRAME);
                byte[] bArr2 = new byte[this.SAMPLES_PER_FRAME];
                if (i > 0 && this.status == 6) {
                    try {
                        this.callback.onVoiceData(bArr, i);
                        this.callback.onVoiceVolume(calculateVolume(bArr, i));
                    } catch (java.lang.Exception e) {
                        android.util.Log.d(TAG, e.toString());
                        android.util.Log.i(TAG, "Stopping AudioRecord...");
                        this.mAudioRecorder.stop();
                        android.util.Log.i(TAG, "AudioRecord stopped.");
                        this.status = 0;
                        android.util.Log.d(TAG, "DefaultRecorder before onPost()");
                        this.callback.onPost();
                        android.util.Log.d(TAG, "DefaultRecorder after onPost()");
                    }
                } else if (i < 0) {
                    android.util.Log.w(TAG, "Can't read audio from recorder.");
                }
            }
            android.util.Log.i(TAG, "Stopping AudioRecord...");
            this.mAudioRecorder.stop();
            android.util.Log.i(TAG, "AudioRecord stopped.");
            this.status = 0;
            android.util.Log.d(TAG, "DefaultRecorder before onPost()");
            this.callback.onPost();
            android.util.Log.d(TAG, "DefaultRecorder after onPost()");
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    public void start() {
        android.media.AudioRecord audioRecord = this.mAudioRecorder;
        if (audioRecord == null || audioRecord.getState() == 0) {
            throw new java.lang.IllegalStateException("Failed to initialize AudioRecord!");
        }
        if (this.status != 0) {
            android.util.Log.i(TAG, "AudioRecord is already working!");
            return;
        }
        android.util.Log.i(TAG, "Starting AudioRecord...");
        this.status = 1;
        this.mAudioRecorder.startRecording();
        android.util.Log.i(TAG, "AudioRecord started.");
        this.status = 6;
        this.thread = new java.lang.Thread(this);
        this.thread.start();
    }

    public void stop() {
        if (this.status != 6) {
            android.util.Log.i(TAG, "AudioRecord is not working!");
        } else {
            this.status = 7;
        }
    }
}
