package com.youme.voice;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class AudioRecorder {
    private static com.youme.voice.AudioRecorder s_instance;
    private android.content.Context m_context;
    private java.lang.Thread recordThread;
    private int m_sampleRate = 16000;
    private int m_channel = 16;
    private int m_audioFormat = 2;
    private int m_recordBufferSize = 12800;
    private com.youme.voice.RecordStatus m_recordStatus = com.youme.voice.RecordStatus.RECORDSTATUS_IDLE;
    private com.youme.voice.WAVHeadInfo m_wavHeadInfo = null;
    private android.media.AudioRecord m_audioRecord = null;
    private android.media.AudioManager m_audioManager = null;
    private com.youme.voice.IAudioRecordListener m_recordListener = null;
    private boolean m_isInit = false;

    private int GetVolume(byte[] bArr, int i) {
        int iAbs = 0;
        for (int i2 = 0; i2 < i; i2 += 2) {
            short s = (short) ((bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8));
            if (java.lang.Math.abs((int) s) > iAbs) {
                iAbs = java.lang.Math.abs((int) s);
            }
        }
        return iAbs;
    }

    public static com.youme.voice.AudioRecorder Instance() {
        if (s_instance == null) {
            s_instance = new com.youme.voice.AudioRecorder();
        }
        return s_instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Record(java.lang.String str, long j) {
        int i;
        int i2;
        boolean z;
        boolean z2;
        int i3;
        android.util.Log.i(com.youme.im.CommonConst.LOG_TAG, "AudioRecorder Record enter");
        if (com.youme.voice.RecordStatus.RECORDSTATUS_STOP == this.m_recordStatus) {
            android.util.Log.i(com.youme.im.CommonConst.LOG_TAG, "Record leave stop");
            this.m_recordStatus = com.youme.voice.RecordStatus.RECORDSTATUS_IDLE;
            this.m_recordListener.OnRecordFinish(com.youme.voice.AudioErrorCode.AUDIOERROR_RECORD_TIME_TOO_SHORT.getValue(), "", j, "");
            return;
        }
        if (com.youme.voice.RecordStatus.RECORDSTATUS_CANCEL == this.m_recordStatus) {
            android.util.Log.i(com.youme.im.CommonConst.LOG_TAG, "Record leave cancel");
            this.m_recordStatus = com.youme.voice.RecordStatus.RECORDSTATUS_IDLE;
            return;
        }
        try {
            this.m_audioRecord.startRecording();
            if (this.m_audioRecord.getRecordingState() != 3) {
                com.youme.im.IMEngine.WriteLog(com.youme.im.CommonConst.LogLevel.LOG_LEVEL_ERROR, "start record failed status:" + this.m_audioRecord.getRecordingState());
                this.m_recordStatus = com.youme.voice.RecordStatus.RECORDSTATUS_IDLE;
                this.m_recordListener.OnRecordFinish(com.youme.voice.AudioErrorCode.AUDIOERROR_AUTHORIZE.getValue(), str, j, "");
                return;
            }
            java.io.File file = new java.io.File(str);
            if (file.exists()) {
                file.delete();
            }
            try {
                java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
                try {
                    fileOutputStream.write(new byte[44]);
                    long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
                    byte[] bArr = new byte[this.m_recordBufferSize];
                    int i4 = ((this.m_sampleRate * 2) / 1000) * 50;
                    int i5 = 50;
                    while (i4 > this.m_recordBufferSize && i5 > 0) {
                        i5 -= 10;
                        i4 = ((this.m_sampleRate * 2) / 1000) * i5;
                        android.util.Log.i(com.youme.im.CommonConst.LOG_TAG, "buffer size:" + i4 + "," + this.m_recordBufferSize);
                        com.youme.im.IMEngine.WriteLog(com.youme.im.CommonConst.LogLevel.LOG_LEVEL_DEBUG, "buffer size:" + i4 + "," + this.m_recordBufferSize);
                    }
                    if (i5 == 0) {
                        com.youme.im.IMEngine.WriteLog(com.youme.im.CommonConst.LogLevel.LOG_LEVEL_ERROR, "read buffer size error");
                        try {
                            fileOutputStream.close();
                        } catch (java.io.IOException e) {
                            com.youme.im.IMEngine.WriteLog(com.youme.im.CommonConst.LogLevel.LOG_LEVEL_ERROR, "close file error");
                            e.printStackTrace();
                        }
                        this.m_recordStatus = com.youme.voice.RecordStatus.RECORDSTATUS_IDLE;
                        this.m_recordListener.OnRecordFinish(com.youme.voice.AudioErrorCode.AUDIOERROR_START_RECORD_FAILED.getValue(), str, j, "");
                        return;
                    }
                    byte[] bArr2 = new byte[i4 * 5];
                    android.util.Log.i(com.youme.im.CommonConst.LOG_TAG, "readBufferSieze:  " + i4 + " m_recordBufferSize:" + this.m_recordBufferSize + " 0");
                    long j2 = 0L;
                    int i6 = 0;
                    int i7 = 0;
                    int i8 = 0;
                    int i9 = 0;
                    while (true) {
                        if (this.m_recordStatus != com.youme.voice.RecordStatus.RECORDSTATUS_RECORDING) {
                            i = i4;
                            i2 = i5;
                            z = false;
                            z2 = true;
                            break;
                        }
                        int i10 = this.m_audioRecord.read(bArr, 0, i4);
                        if (i10 > 0) {
                            java.lang.System.arraycopy(bArr, 0, bArr2, i7, i10);
                            i7 += i10;
                            i = i4;
                            i2 = i5;
                            j2 += (long) i10;
                            i8++;
                            if (i8 == 5) {
                                try {
                                    fileOutputStream.write(bArr2, 0, i7);
                                    if (i6 < 20) {
                                        i6++;
                                        if (GetVolume(bArr2, i7) == 0) {
                                            int i11 = i9 + 1;
                                            if (i11 == 20) {
                                                z = false;
                                                z2 = false;
                                                break;
                                            }
                                            i9 = i11;
                                        }
                                    }
                                    i7 = 0;
                                    i8 = 0;
                                } catch (java.io.IOException e2) {
                                    e2.printStackTrace();
                                    z = false;
                                    z2 = true;
                                }
                            }
                        } else {
                            i = i4;
                            i2 = i5;
                        }
                        if (i10 > 0) {
                            this.m_recordListener.OnRecordData(bArr, i10);
                        }
                        if (android.os.SystemClock.elapsedRealtime() - jElapsedRealtime > 60000) {
                            z = true;
                            z2 = true;
                            break;
                        } else {
                            i4 = i;
                            i5 = i2;
                        }
                    }
                    if (z2) {
                        i3 = i;
                        int i12 = this.m_audioRecord.read(bArr, 0, i3);
                        if (i12 > 0) {
                            j2 += (long) i12;
                            try {
                                fileOutputStream.write(bArr, 0, i12);
                            } catch (java.io.IOException e3) {
                                e3.printStackTrace();
                            }
                            this.m_recordListener.OnRecordData(bArr, i12);
                        }
                    } else {
                        i3 = i;
                    }
                    this.m_audioRecord.stop();
                    try {
                        fileOutputStream.close();
                        if (com.youme.voice.RecordStatus.RECORDSTATUS_CANCEL == this.m_recordStatus) {
                            file.delete();
                            this.m_recordStatus = com.youme.voice.RecordStatus.RECORDSTATUS_IDLE;
                            return;
                        }
                        this.m_recordStatus = com.youme.voice.RecordStatus.RECORDSTATUS_IDLE;
                        if (z2) {
                            long j3 = j2 / ((long) (i3 / i2));
                            long jElapsedRealtime2 = android.os.SystemClock.elapsedRealtime() - jElapsedRealtime;
                            com.youme.im.IMEngine.WriteLog(com.youme.im.CommonConst.LogLevel.LOG_LEVEL_DEBUG, "AudioRecorder data time:" + j3 + " duration:" + jElapsedRealtime2);
                            if (jElapsedRealtime2 < 1000 || jElapsedRealtime2 < j3 - 1000) {
                                file.delete();
                                this.m_recordListener.OnRecordFinish(com.youme.voice.AudioErrorCode.AUDIOERROR_RECORD_TIME_TOO_SHORT.getValue(), "", j, "");
                            } else if (this.m_wavHeadInfo.WriteHeadInfo(str)) {
                                this.m_recordListener.OnRecordFinish((z ? com.youme.voice.AudioErrorCode.AUDIOERROR_RECORD_TIMEOUT : com.youme.voice.AudioErrorCode.AUDIOERROR_SUCCESS).getValue(), str, j, "");
                            } else {
                                this.m_recordListener.OnRecordFinish(com.youme.voice.AudioErrorCode.AUDIOERROR_READWRITE_FILE_ERROR.getValue(), str, j, "");
                            }
                        } else {
                            file.delete();
                            this.m_recordListener.OnRecordFinish(com.youme.voice.AudioErrorCode.AUDIOERROR_AUTHORIZE.getValue(), str, j, "");
                        }
                        android.util.Log.i(com.youme.im.CommonConst.LOG_TAG, "AudioRecorder Record leave");
                    } catch (java.io.IOException e4) {
                        com.youme.im.IMEngine.WriteLog(com.youme.im.CommonConst.LogLevel.LOG_LEVEL_ERROR, "close file error");
                        e4.printStackTrace();
                        this.m_recordStatus = com.youme.voice.RecordStatus.RECORDSTATUS_IDLE;
                        this.m_recordListener.OnRecordFinish(com.youme.voice.AudioErrorCode.AUDIOERROR_READWRITE_FILE_ERROR.getValue(), str, j, "");
                    }
                } catch (java.io.IOException e5) {
                    com.youme.im.IMEngine.WriteLog(com.youme.im.CommonConst.LogLevel.LOG_LEVEL_ERROR, "write file error");
                    e5.printStackTrace();
                    this.m_recordStatus = com.youme.voice.RecordStatus.RECORDSTATUS_IDLE;
                    this.m_recordListener.OnRecordFinish(com.youme.voice.AudioErrorCode.AUDIOERROR_READWRITE_FILE_ERROR.getValue(), "", j, "");
                }
            } catch (java.io.FileNotFoundException e6) {
                e6.printStackTrace();
                this.m_recordStatus = com.youme.voice.RecordStatus.RECORDSTATUS_IDLE;
                com.youme.im.IMEngine.WriteLog(com.youme.im.CommonConst.LogLevel.LOG_LEVEL_DEBUG, "Record create file failed");
                this.m_recordListener.OnRecordFinish(com.youme.voice.AudioErrorCode.AUDIOERROR_CREATE_FILE_FAILED.getValue(), str, j, "");
            }
        } catch (java.lang.Throwable th) {
            this.m_recordStatus = com.youme.voice.RecordStatus.RECORDSTATUS_IDLE;
            th.printStackTrace();
            this.m_recordListener.OnRecordFinish(com.youme.voice.AudioErrorCode.AUDIOERROR_START_RECORD_FAILED.getValue(), "", j, "");
        }
    }

    public com.youme.voice.AudioErrorCode CancelRecord() {
        com.youme.im.IMEngine.WriteLog(com.youme.im.CommonConst.LogLevel.LOG_LEVEL_DEBUG, "CancelRecord enter");
        if (!IsRecording()) {
            return com.youme.voice.AudioErrorCode.AUDIOERROR_NOT_START_RECORD;
        }
        this.m_recordStatus = com.youme.voice.RecordStatus.RECORDSTATUS_CANCEL;
        android.util.Log.i(com.youme.im.CommonConst.LOG_TAG, "CancelRecord leave");
        return com.youme.voice.AudioErrorCode.AUDIOERROR_SUCCESS;
    }

    public com.youme.voice.AudioDeviceStatus GetMicrophoneStatus() {
        if (!HasAudioPermission()) {
            return com.youme.voice.AudioDeviceStatus.AUDIOSTATUS_NO_AUTHORIZE;
        }
        android.media.AudioManager audioManager = this.m_audioManager;
        if (audioManager == null) {
            android.util.Log.i(com.youme.im.CommonConst.LOG_TAG, "AudioManager is null");
            return com.youme.voice.AudioDeviceStatus.AUDIOSTATUS_NOT_AVIAIBLE;
        }
        if (!audioManager.isMicrophoneMute() && this.m_audioManager.getStreamVolume(3) != 0) {
            return com.youme.voice.AudioDeviceStatus.AUDIOSTATUS_AVIAIBLE;
        }
        return com.youme.voice.AudioDeviceStatus.AUDIOSTATUS_MUTE;
    }

    public boolean HasAudioPermission() {
        android.content.Context context;
        boolean z = true;
        if (android.os.Build.VERSION.SDK_INT >= 23 && (context = this.m_context) != null && (context instanceof android.app.Activity) && context.getApplicationInfo().targetSdkVersion > 22) {
            try {
                if (!com.anthonycr.grant.PermissionsManager.getInstance().hasPermission(this.m_context, "android.permission.RECORD_AUDIO")) {
                    com.anthonycr.grant.PermissionsManager.getInstance().requestPermissionsIfNecessaryForResult((android.app.Activity) this.m_context, new java.lang.String[]{"android.permission.RECORD_AUDIO"}, new com.anthonycr.grant.PermissionsResultAction() { // from class: com.youme.voice.AudioRecorder.2
                        @Override // com.anthonycr.grant.PermissionsResultAction
                        public void onDenied(java.lang.String str) {
                            com.youme.im.IMEngine.WriteLog(com.youme.im.CommonConst.LogLevel.LOG_LEVEL_WARNING, "Decline granted RECORD_AUDIO permission.");
                        }

                        @Override // com.anthonycr.grant.PermissionsResultAction
                        public void onGranted() {
                            android.util.Log.e(com.youme.im.CommonConst.LOG_TAG, " Success granted RECORD_AUDIO permission.");
                        }
                    });
                    com.youme.im.IMEngine.WriteLog(com.youme.im.CommonConst.LogLevel.LOG_LEVEL_WARNING, "Not granted ACCESS_FINE_LOCATION permission");
                    return false;
                }
            } catch (java.lang.Exception e) {
                android.util.Log.e(com.youme.im.CommonConst.LOG_TAG, e.toString());
                return false;
            }
        }
        android.media.AudioRecord audioRecord = this.m_audioRecord;
        if (audioRecord != null && audioRecord.getRecordingState() == 3) {
            return true;
        }
        int minBufferSize = android.media.AudioRecord.getMinBufferSize(8000, this.m_channel, this.m_audioFormat);
        try {
            android.media.AudioRecord audioRecord2 = new android.media.AudioRecord(1, 8000, this.m_channel, this.m_audioFormat, minBufferSize);
            audioRecord2.startRecording();
            if (audioRecord2.getRecordingState() != 3) {
                z = false;
            } else {
                int i = 0;
                for (int i2 = 0; i2 < 20; i2++) {
                    byte[] bArr = new byte[minBufferSize];
                    int i3 = audioRecord2.read(bArr, 0, minBufferSize);
                    if (i3 <= 0) {
                        z = false;
                        break;
                    }
                    if (GetVolume(bArr, i3) == 0) {
                        i++;
                    }
                }
                if (i == 20) {
                    z = false;
                }
            }
            try {
                audioRecord2.stop();
                audioRecord2.release();
                return z;
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
                return false;
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean Init(android.content.Context context) {
        if (this.m_isInit) {
            return true;
        }
        this.m_context = context;
        this.m_audioManager = (android.media.AudioManager) context.getSystemService("audio");
        if (this.m_audioManager == null) {
            com.youme.im.IMEngine.WriteLog(com.youme.im.CommonConst.LogLevel.LOG_LEVEL_ERROR, "audiomanager is null");
            return false;
        }
        this.m_wavHeadInfo = new com.youme.voice.WAVHeadInfo();
        SetAudioRecordParam(16000, 1, 16);
        this.m_isInit = true;
        return true;
    }

    public boolean IsRecording() {
        return this.m_recordStatus != com.youme.voice.RecordStatus.RECORDSTATUS_IDLE;
    }

    public void SetAudioRecordParam(int i, int i2, int i3) {
        this.m_sampleRate = i;
        if (i2 == 1) {
            this.m_channel = 16;
        } else if (i2 == 2) {
            this.m_channel = 12;
        }
        if (i3 == 8) {
            this.m_audioFormat = 3;
        } else if (i3 == 16) {
            this.m_audioFormat = 2;
        } else {
            this.m_audioFormat = 1;
        }
        this.m_wavHeadInfo.SetAudioProperty(i, i2, i3);
        this.m_recordBufferSize = android.media.AudioRecord.getMinBufferSize(this.m_sampleRate, this.m_channel, this.m_audioFormat) * 2;
    }

    public void SetRecordListener(com.youme.voice.IAudioRecordListener iAudioRecordListener) {
        this.m_recordListener = iAudioRecordListener;
    }

    public com.youme.voice.AudioErrorCode StartRecord(final long j, final java.lang.String str) {
        com.youme.im.IMEngine.WriteLog(com.youme.im.CommonConst.LogLevel.LOG_LEVEL_DEBUG, "AudioRecorder StartRecord enter");
        if (IsRecording()) {
            android.util.Log.i(com.youme.im.CommonConst.LOG_TAG, "AudioRecorder StartRecord leave recording");
            return com.youme.voice.AudioErrorCode.AUDIOERROR_RECORDING;
        }
        try {
            if (this.m_audioRecord != null && this.m_audioRecord.getRecordingState() != 1) {
                com.youme.im.IMEngine.WriteLog(com.youme.im.CommonConst.LogLevel.LOG_LEVEL_DEBUG, "AudioRecorder StartRecord is recording");
                return com.youme.voice.AudioErrorCode.AUDIOERROR_RECORDING;
            }
            if (this.m_audioRecord != null) {
                this.m_audioRecord.release();
                this.m_audioRecord = null;
            }
            android.media.AudioManager audioManager = this.m_audioManager;
            com.youme.im.IMEngine.WriteLog(com.youme.im.CommonConst.LogLevel.LOG_LEVEL_DEBUG, "create AudioRecorder");
            this.m_audioRecord = new android.media.AudioRecord(1, this.m_sampleRate, this.m_channel, this.m_audioFormat, this.m_recordBufferSize);
            if (this.m_audioRecord == null || this.m_audioRecord.getState() != 1 || this.m_audioRecord.getRecordingState() != 1) {
                com.youme.im.IMEngine.WriteLog(com.youme.im.CommonConst.LogLevel.LOG_LEVEL_DEBUG, "AudioRecorder StartRecord init failed");
                return com.youme.voice.AudioErrorCode.AUDIOERROR_INIT_FAILED;
            }
            this.m_recordStatus = com.youme.voice.RecordStatus.RECORDSTATUS_RECORDING;
            com.youme.im.IMEngine.WriteLog(com.youme.im.CommonConst.LogLevel.LOG_LEVEL_DEBUG, "create Record thread");
            this.recordThread = new java.lang.Thread(new java.lang.Runnable() { // from class: com.youme.voice.AudioRecorder.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        com.youme.voice.AudioRecorder.this.Record(str, j);
                    } catch (java.lang.Throwable th) {
                        th.printStackTrace();
                    }
                }
            }, "AudioRecorder Thread");
            this.recordThread.start();
            android.util.Log.i(com.youme.im.CommonConst.LOG_TAG, "AudioRecorder StartRecord leave");
            return com.youme.voice.AudioErrorCode.AUDIOERROR_SUCCESS;
        } catch (java.lang.Throwable th) {
            com.youme.im.IMEngine.WriteLog(com.youme.im.CommonConst.LogLevel.LOG_LEVEL_ERROR, "init audiorecord failed");
            th.printStackTrace();
            return com.youme.voice.AudioErrorCode.AUDIOERROR_INIT_FAILED;
        }
    }

    public com.youme.voice.AudioErrorCode StopRecord() {
        com.youme.im.IMEngine.WriteLog(com.youme.im.CommonConst.LogLevel.LOG_LEVEL_DEBUG, "AudioRecorder StopRecord enter status:" + this.m_recordStatus);
        if (IsRecording()) {
            this.m_recordStatus = com.youme.voice.RecordStatus.RECORDSTATUS_STOP;
            android.util.Log.i(com.youme.im.CommonConst.LOG_TAG, "StopRecord leave");
            return com.youme.voice.AudioErrorCode.AUDIOERROR_SUCCESS;
        }
        com.youme.im.IMEngine.WriteLog(com.youme.im.CommonConst.LogLevel.LOG_LEVEL_DEBUG, "record status:" + this.m_recordStatus);
        return com.youme.voice.AudioErrorCode.AUDIOERROR_NOT_START_RECORD;
    }

    public void Uninit() {
        android.media.AudioRecord audioRecord = this.m_audioRecord;
        if (audioRecord != null) {
            audioRecord.stop();
            this.m_audioRecord.release();
            this.m_audioRecord = null;
        }
        this.m_isInit = false;
    }
}
