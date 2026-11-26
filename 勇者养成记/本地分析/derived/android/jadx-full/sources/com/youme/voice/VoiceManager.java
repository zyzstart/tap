package com.youme.voice;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class VoiceManager implements com.youme.voice.IAudioRecordListener, com.youme.voice.IAudioPlayListener {
    private static com.youme.voice.VoiceManager s_instance;
    private android.content.Context m_context;
    private java.lang.String m_recognizeAppID;
    private java.lang.String m_recognizeSecret;
    private java.lang.String m_recordCacheDir = "";
    private int m_sampleRate = 16000;
    private int m_channel = 1;
    private int m_sampleBitSize = 16;
    private com.youme.voice.ISpeechRecognize m_speechRecognizer = null;
    private boolean m_speechOnly = false;
    private com.youme.voice.ISpeechRecognize.RecognizeLanguage m_recognizeLanguage = com.youme.voice.ISpeechRecognize.RecognizeLanguage.RECOGNIZELANG_MANDARIN;
    private com.youme.voice.AudioRecognizeType m_recognizeType = com.youme.voice.AudioRecognizeType.RECOGNIZETYPE_NO;
    private boolean m_isInit = false;
    private com.youme.voice.AudioPlayer m_audioPlayer = null;
    private float m_playVolume = 1.0f;

    public static int CancleSpeech() {
        try {
            if (Instance().m_speechOnly) {
                return !Instance().m_isInit ? com.youme.voice.AudioErrorCode.AUDIOERROR_NOT_START_RECORD.getValue() : com.youme.voice.YouMeAudioRecorder.Instance().CancleSpeech().getValue();
            }
            return Instance().m_speechRecognizer == null ? com.youme.voice.AudioErrorCode.AUDIOERROR_NOT_START_RECORD.getValue() : Instance().m_speechRecognizer.CancleSpeech().getValue();
        } catch (java.lang.Throwable th) {
            android.util.Log.e(com.youme.im.CommonConst.LOG_TAG, th.toString());
            return com.youme.voice.AudioErrorCode.AUDIOERROR_OTHREERROR.getValue();
        }
    }

    public static java.lang.String GetAudioRecordCacheDir() {
        return Instance().m_recordCacheDir;
    }

    public static int GetMicrophoneStatus() {
        if (!Instance().m_isInit) {
            InitYouMeAudioRecord();
        }
        return com.youme.voice.YouMeAudioRecorder.Instance().GetMicrophoneStatus().ordinal();
    }

    public static int GetNetworkType() {
        return com.youme.im.NetworkStatusReceiver2.GetNetworkType(Instance().m_context).ordinal();
    }

    private static void InitSpeechRecognizer() {
        if (Instance().m_speechRecognizer != null) {
            return;
        }
        if (com.youme.voice.AudioRecognizeType.RECOGNIZETYPE_IFLY_STREAM == Instance().m_recognizeType || com.youme.voice.AudioRecognizeType.RECOGNIZETYPE_IFLY_RECORD == Instance().m_recognizeType) {
            Instance().m_speechRecognizer = new com.youme.speech.IflySpeechRecognizer();
        } else if (com.youme.voice.AudioRecognizeType.RECOGNIZETYPE_USC == Instance().m_recognizeType) {
            Instance().m_speechRecognizer = new com.youme.speech.UscSpeechRecognizer();
        } else {
            if (com.youme.voice.AudioRecognizeType.RECOGNIZETYPE_ALI != Instance().m_recognizeType) {
                return;
            }
            Instance().m_speechRecognizer = new com.youme.speech.AliSpeechRecognizer();
        }
        Instance().m_speechRecognizer.Init(Instance().m_context);
        Instance().m_speechRecognizer.InitSpeechRecognizer(Instance().m_recognizeAppID, Instance().m_recognizeSecret, Instance().m_recognizeType);
        Instance().m_speechRecognizer.SetAudioRecordListener(Instance());
        Instance().m_speechRecognizer.SetAudioRecordParam(Instance().m_sampleRate, Instance().m_channel, Instance().m_sampleBitSize);
        Instance().m_speechRecognizer.SetRecognizeLanguage(Instance().m_recognizeLanguage);
    }

    public static void InitSpeechRecognizer(java.lang.String str, java.lang.String str2, int i) {
        Instance().m_recognizeAppID = str;
        Instance().m_recognizeSecret = str2;
        Instance().m_recognizeType = com.youme.voice.AudioRecognizeType.values()[i];
        if (Instance().m_recognizeType != com.youme.voice.AudioRecognizeType.RECOGNIZETYPE_IFLY_RECORD) {
            InitYouMeAudioRecord();
        }
    }

    private static void InitYouMeAudioRecord() {
        if (Instance().m_isInit) {
            return;
        }
        Instance().m_isInit = true;
        com.youme.voice.YouMeAudioRecorder.Instance().Init(Instance().m_context);
        com.youme.voice.YouMeAudioRecorder.Instance().SetAudioRecordListener(Instance());
        com.youme.voice.YouMeAudioRecorder.Instance().SetAudioRecordParam(Instance().m_sampleRate, Instance().m_channel, Instance().m_sampleBitSize);
    }

    public static com.youme.voice.VoiceManager Instance() {
        if (s_instance == null) {
            s_instance = new com.youme.voice.VoiceManager();
        }
        return s_instance;
    }

    public static boolean IsPlaying() {
        try {
            if (Instance().m_audioPlayer == null) {
                return false;
            }
            return Instance().m_audioPlayer.IsPlaying();
        } catch (java.lang.Throwable th) {
            android.util.Log.e(com.youme.im.CommonConst.LOG_TAG, th.toString());
            return false;
        }
    }

    public static void SetAudioRecordCacheDir(java.lang.String str) {
        if (str.length() == 0) {
            Instance().m_recordCacheDir = Instance().m_context.getCacheDir().getAbsolutePath() + "/AudioRecord/";
            java.io.File file = new java.io.File(Instance().m_recordCacheDir);
            if (file.exists()) {
                return;
            }
            file.mkdirs();
            return;
        }
        java.io.File file2 = new java.io.File(str);
        if ((file2.exists() && file2.isDirectory()) || file2.mkdirs()) {
            Instance().m_recordCacheDir = str;
        } else {
            com.youme.im.IMEngine.WriteLog(com.youme.im.CommonConst.LogLevel.LOG_LEVEL_ERROR, "create dir failed:" + str);
        }
        if (Instance().m_recordCacheDir.isEmpty() || str.charAt(str.length() - 1) == '/') {
            return;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        com.youme.voice.VoiceManager voiceManagerInstance = Instance();
        sb.append(voiceManagerInstance.m_recordCacheDir);
        sb.append("/");
        voiceManagerInstance.m_recordCacheDir = sb.toString();
    }

    public static void SetAudioRecordParam(int i, int i2, int i3) {
        Instance().m_sampleRate = i;
        Instance().m_channel = i2;
        Instance().m_sampleBitSize = i3;
        if (Instance().m_recognizeType != com.youme.voice.AudioRecognizeType.RECOGNIZETYPE_IFLY_RECORD) {
            com.youme.voice.YouMeAudioRecorder.Instance().SetAudioRecordParam(Instance().m_sampleRate, Instance().m_channel, Instance().m_sampleBitSize);
        }
        if (Instance().m_speechRecognizer != null) {
            Instance().m_speechRecognizer.SetAudioRecordParam(i, i2, i3);
        }
    }

    public static void SetPlayVolume(float f) {
        Instance().m_playVolume = f;
        if (Instance().m_audioPlayer != null) {
            Instance().m_audioPlayer.SetPlayVolume(f);
        }
    }

    public static void SetRecognizeLanguage(int i) {
        Instance().m_recognizeLanguage = com.youme.voice.ISpeechRecognize.RecognizeLanguage.values()[i];
        if (Instance().m_speechRecognizer != null) {
            Instance().m_speechRecognizer.SetRecognizeLanguage(Instance().m_recognizeLanguage);
        }
    }

    public static int StartOnlySpeech(long j) {
        if (android.os.Build.VERSION.SDK_INT >= 23 && Instance().m_context != null && (Instance().m_context instanceof android.app.Activity) && Instance().m_context.getApplicationInfo().targetSdkVersion > 22) {
            try {
                if (!com.anthonycr.grant.PermissionsManager.getInstance().hasPermission(Instance().m_context, "android.permission.RECORD_AUDIO")) {
                    com.anthonycr.grant.PermissionsManager.getInstance().requestPermissionsIfNecessaryForResult((android.app.Activity) Instance().m_context, new java.lang.String[]{"android.permission.RECORD_AUDIO"}, new com.anthonycr.grant.PermissionsResultAction() { // from class: com.youme.voice.VoiceManager.2
                        @Override // com.anthonycr.grant.PermissionsResultAction
                        public void onDenied(java.lang.String str) {
                            com.youme.im.IMEngine.WriteLog(com.youme.im.CommonConst.LogLevel.LOG_LEVEL_WARNING, "Decline granted RECORD_AUDIO permission.");
                        }

                        @Override // com.anthonycr.grant.PermissionsResultAction
                        public void onGranted() {
                            android.util.Log.e(com.youme.im.CommonConst.LOG_TAG, " Success granted RECORD_AUDIO permission.");
                        }
                    });
                    com.youme.im.IMEngine.WriteLog(com.youme.im.CommonConst.LogLevel.LOG_LEVEL_WARNING, "Not granted RECORD_AUDIO permission.");
                    return com.youme.voice.AudioErrorCode.AUDIOERROR_AUTHORIZE.getValue();
                }
            } catch (java.lang.Throwable th) {
                android.util.Log.e(com.youme.im.CommonConst.LOG_TAG, th.toString());
                com.youme.im.IMEngine.WriteLog(com.youme.im.CommonConst.LogLevel.LOG_LEVEL_ERROR, "record permission exception");
                return -1;
            }
        }
        try {
            if (!Instance().m_isInit) {
                InitYouMeAudioRecord();
            }
            java.lang.String str = Instance().m_recordCacheDir + java.util.UUID.randomUUID().toString() + ".wav";
            Instance().m_speechOnly = true;
            return com.youme.voice.YouMeAudioRecorder.Instance().StartSpeech(str, j, com.youme.voice.AudioRecognizeType.RECOGNIZETYPE_NO).getValue();
        } catch (java.lang.Throwable th2) {
            android.util.Log.e(com.youme.im.CommonConst.LOG_TAG, th2.toString());
            com.youme.im.IMEngine.WriteLog(com.youme.im.CommonConst.LogLevel.LOG_LEVEL_ERROR, "speechOnly init error");
            return -1;
        }
    }

    public static int StartPlayAudio(java.lang.String str) {
        try {
            if (Instance().m_audioPlayer == null) {
                Instance().InitAudioPlayer();
            }
            return Instance().m_audioPlayer.Play(str).getValue();
        } catch (java.lang.Throwable th) {
            android.util.Log.e(com.youme.im.CommonConst.LOG_TAG, th.toString());
            return com.youme.voice.AudioErrorCode.AUDIOERROR_OTHREERROR.getValue();
        }
    }

    public static int StartSpeech(long j) {
        if (android.os.Build.VERSION.SDK_INT >= 23 && Instance().m_context != null && (Instance().m_context instanceof android.app.Activity) && Instance().m_context.getApplicationInfo().targetSdkVersion > 22) {
            try {
                if (!com.anthonycr.grant.PermissionsManager.getInstance().hasPermission(Instance().m_context, "android.permission.RECORD_AUDIO")) {
                    com.anthonycr.grant.PermissionsManager.getInstance().requestPermissionsIfNecessaryForResult((android.app.Activity) Instance().m_context, new java.lang.String[]{"android.permission.RECORD_AUDIO"}, new com.anthonycr.grant.PermissionsResultAction() { // from class: com.youme.voice.VoiceManager.1
                        @Override // com.anthonycr.grant.PermissionsResultAction
                        public void onDenied(java.lang.String str) {
                            com.youme.im.IMEngine.WriteLog(com.youme.im.CommonConst.LogLevel.LOG_LEVEL_WARNING, "Decline granted RECORD_AUDIO permission.");
                        }

                        @Override // com.anthonycr.grant.PermissionsResultAction
                        public void onGranted() {
                            android.util.Log.e(com.youme.im.CommonConst.LOG_TAG, " Success granted RECORD_AUDIO permission.");
                        }
                    });
                    com.youme.im.IMEngine.WriteLog(com.youme.im.CommonConst.LogLevel.LOG_LEVEL_WARNING, "Not granted RECORD_AUDIO permission.");
                    return com.youme.voice.AudioErrorCode.AUDIOERROR_AUTHORIZE.getValue();
                }
            } catch (java.lang.Exception e) {
                android.util.Log.e(com.youme.im.CommonConst.LOG_TAG, e.toString());
                com.youme.im.IMEngine.WriteLog(com.youme.im.CommonConst.LogLevel.LOG_LEVEL_ERROR, "record permission exception");
                return -1;
            }
        }
        if (Instance().m_speechRecognizer == null) {
            InitSpeechRecognizer();
        }
        java.lang.String str = Instance().m_recordCacheDir + java.util.UUID.randomUUID().toString() + ".wav";
        Instance().m_speechOnly = false;
        return Instance().m_speechRecognizer.StartSpeech(str, j);
    }

    public static int StopPlayAudio() {
        try {
            return Instance().m_audioPlayer == null ? com.youme.voice.AudioErrorCode.AUDIOERROR_NOT_START_PLAY.getValue() : Instance().m_audioPlayer.Stop().getValue();
        } catch (java.lang.Throwable th) {
            android.util.Log.e(com.youme.im.CommonConst.LOG_TAG, th.toString());
            return com.youme.voice.AudioErrorCode.AUDIOERROR_OTHREERROR.getValue();
        }
    }

    public static int StopSpeech() {
        try {
            if (Instance().m_speechOnly) {
                if (Instance().m_isInit) {
                    return com.youme.voice.YouMeAudioRecorder.Instance().StopSpeech().getValue();
                }
                com.youme.im.IMEngine.WriteLog(com.youme.im.CommonConst.LogLevel.LOG_LEVEL_ERROR, "VoiceManager not init");
                return com.youme.voice.AudioErrorCode.AUDIOERROR_NOT_START_RECORD.getValue();
            }
            if (Instance().m_speechRecognizer != null) {
                return Instance().m_speechRecognizer.StopSpeech().getValue();
            }
            com.youme.im.IMEngine.WriteLog(com.youme.im.CommonConst.LogLevel.LOG_LEVEL_ERROR, "m_speechRecognizer is null");
            return com.youme.voice.AudioErrorCode.AUDIOERROR_NOT_START_RECORD.getValue();
        } catch (java.lang.Throwable th) {
            android.util.Log.e(com.youme.im.CommonConst.LOG_TAG, th.toString());
            return com.youme.voice.AudioErrorCode.AUDIOERROR_OTHREERROR.getValue();
        }
    }

    public static void UnInit() {
        if (Instance().m_speechRecognizer != null) {
            Instance().m_speechRecognizer.UnInit();
        }
    }

    public static void UpdateToken(java.lang.String str) {
        Instance().m_recognizeSecret = str;
        if (Instance().m_speechRecognizer != null) {
            Instance().m_speechRecognizer.UpdateToken(str);
        }
    }

    public void Init(android.content.Context context) {
        Instance().m_context = context;
        if (this.m_recordCacheDir.isEmpty()) {
            SetAudioRecordCacheDir("");
        }
    }

    void InitAudioPlayer() {
        try {
            if (Instance().m_audioPlayer != null) {
                return;
            }
            Instance().m_audioPlayer = new com.youme.voice.AudioPlayer();
            Instance().m_audioPlayer.SetPlayListener(this);
            Instance().m_audioPlayer.SetPlayVolume(this.m_playVolume);
        } catch (java.lang.Throwable th) {
            android.util.Log.e(com.youme.im.CommonConst.LOG_TAG, th.toString());
        }
    }

    @Override // com.youme.voice.IAudioPlayListener
    public void OnPlayData(byte[] bArr, int i) {
        com.youme.im.NativeEngine.OnPlayData(bArr, i);
    }

    @Override // com.youme.voice.IAudioPlayListener
    public void OnPlayFinish(com.youme.voice.AudioErrorCode audioErrorCode, java.lang.String str) {
        com.youme.im.NativeEngine.OnPlayFinish(audioErrorCode.getValue(), str);
    }

    @Override // com.youme.voice.IAudioRecordListener
    public byte[] OnRecordData(byte[] bArr, int i) {
        int i2;
        if ((com.youme.voice.AudioRecognizeType.RECOGNIZETYPE_IFLY_STREAM == this.m_recognizeType || com.youme.voice.AudioRecognizeType.RECOGNIZETYPE_USC == this.m_recognizeType) && (i2 = this.m_sampleRate) != 16000 && i2 != 8000) {
            return com.youme.im.NativeEngine.OnRecordData(bArr, i, true);
        }
        if (com.youme.voice.AudioRecognizeType.RECOGNIZETYPE_ALI == this.m_recognizeType) {
            return com.youme.im.NativeEngine.OnRecordData(bArr, i, this.m_sampleRate != 16000);
        }
        if (com.youme.voice.AudioRecognizeType.RECOGNIZETYPE_NO == this.m_recognizeType || this.m_speechOnly) {
            return com.youme.im.NativeEngine.OnRecordData(bArr, i, false);
        }
        return null;
    }

    @Override // com.youme.voice.IAudioRecordListener
    public void OnRecordFinish(int i, java.lang.String str, long j, java.lang.String str2) {
        android.util.Log.d(com.youme.im.CommonConst.LOG_TAG, "VoiceManager OnRecordFinish errorcode:" + i + " serial:" + j + " path:" + str + " text:" + str2);
        com.youme.im.NativeEngine.OnRecordFinish(i, str, j, str2);
    }

    @Override // com.youme.voice.IAudioRecordListener
    public void OnRecordVolumeChange(int i, com.youme.voice.AudioRecognizeType audioRecognizeType) {
        com.youme.im.NativeEngine.NotifyVolumeChange(i, audioRecognizeType.ordinal());
    }
}
