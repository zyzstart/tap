package com.youme.voice;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class AudioPlayer implements android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnPreparedListener, android.media.MediaPlayer.OnErrorListener {
    private android.media.MediaPlayer m_mediaPlayer;
    private boolean m_isPaused = false;
    private boolean m_lastStateIsStop = true;
    private com.youme.voice.IAudioPlayListener m_playerListener = null;
    private java.lang.String m_audioPath = "";
    private float m_playVolume = 1.0f;

    public AudioPlayer() {
        this.m_mediaPlayer = null;
        this.m_mediaPlayer = new android.media.MediaPlayer();
        this.m_mediaPlayer.setOnPreparedListener(this);
        this.m_mediaPlayer.setOnCompletionListener(this);
        this.m_mediaPlayer.setOnErrorListener(this);
    }

    public boolean IsPaused() {
        return this.m_isPaused;
    }

    public boolean IsPlaying() {
        android.media.MediaPlayer mediaPlayer = this.m_mediaPlayer;
        if (mediaPlayer != null) {
            return mediaPlayer.isPlaying();
        }
        return false;
    }

    public boolean Pause() {
        android.media.MediaPlayer mediaPlayer = this.m_mediaPlayer;
        if (mediaPlayer == null) {
            return true;
        }
        if (!mediaPlayer.isPlaying()) {
            return false;
        }
        try {
            this.m_mediaPlayer.pause();
            this.m_isPaused = true;
        } catch (java.lang.IllegalStateException e) {
            e.printStackTrace();
            this.m_isPaused = false;
        }
        return this.m_isPaused;
    }

    public com.youme.voice.AudioErrorCode Play(java.lang.String str) {
        if (!new java.io.File(str).exists()) {
            return com.youme.voice.AudioErrorCode.AUDIOERROR_FILE_NOT_EXIT;
        }
        if (this.m_mediaPlayer == null) {
            this.m_mediaPlayer = new android.media.MediaPlayer();
            this.m_mediaPlayer.setOnPreparedListener(this);
            this.m_mediaPlayer.setOnCompletionListener(this);
            this.m_mediaPlayer.setOnErrorListener(this);
        }
        if (this.m_mediaPlayer == null) {
            return com.youme.voice.AudioErrorCode.AUDIOERROR_START_PLAY_FAILED;
        }
        this.m_isPaused = false;
        com.youme.voice.AudioErrorCode audioErrorCode = com.youme.voice.AudioErrorCode.AUDIOERROR_SUCCESS;
        if (this.m_mediaPlayer.isPlaying()) {
            this.m_mediaPlayer.stop();
            audioErrorCode = com.youme.voice.AudioErrorCode.AUDIOERROR_PLAYING;
        }
        this.m_audioPath = str;
        try {
            this.m_mediaPlayer.reset();
            this.m_mediaPlayer.setOnPreparedListener(this);
            this.m_mediaPlayer.setOnCompletionListener(this);
            this.m_mediaPlayer.setOnErrorListener(this);
            this.m_mediaPlayer.setAudioStreamType(3);
            this.m_mediaPlayer.setDataSource(str);
            this.m_lastStateIsStop = false;
            this.m_mediaPlayer.setVolume(this.m_playVolume, this.m_playVolume);
            this.m_mediaPlayer.prepareAsync();
            android.util.Log.d(com.youme.im.CommonConst.LOG_TAG, "prepareAsync4");
            return audioErrorCode;
        } catch (java.lang.Exception e) {
            this.m_lastStateIsStop = true;
            e.printStackTrace();
            return com.youme.voice.AudioErrorCode.AUDIOERROR_START_PLAY_FAILED;
        }
    }

    public boolean ResumePlay() {
        android.media.MediaPlayer mediaPlayer = this.m_mediaPlayer;
        if (mediaPlayer == null || !this.m_isPaused || mediaPlayer.isPlaying()) {
            return false;
        }
        this.m_mediaPlayer.start();
        return true;
    }

    public void SetPlayListener(com.youme.voice.IAudioPlayListener iAudioPlayListener) {
        this.m_playerListener = iAudioPlayListener;
    }

    public void SetPlayVolume(float f) {
        android.util.Log.d(com.youme.im.CommonConst.LOG_TAG, "SetVolume: " + f);
        this.m_playVolume = f;
    }

    public com.youme.voice.AudioErrorCode Stop() {
        android.media.MediaPlayer mediaPlayer = this.m_mediaPlayer;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return com.youme.voice.AudioErrorCode.AUDIOERROR_NOT_START_PLAY;
        }
        this.m_isPaused = false;
        this.m_lastStateIsStop = true;
        try {
            this.m_mediaPlayer.stop();
            return com.youme.voice.AudioErrorCode.AUDIOERROR_SUCCESS;
        } catch (java.lang.IllegalStateException unused) {
            return com.youme.voice.AudioErrorCode.AUDIOERROR_STOP_PLAY_FAILED;
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(android.media.MediaPlayer mediaPlayer) {
        android.util.Log.d(com.youme.im.CommonConst.LOG_TAG, "onCompletion");
        this.m_mediaPlayer.reset();
        com.youme.voice.IAudioPlayListener iAudioPlayListener = this.m_playerListener;
        if (iAudioPlayListener != null) {
            iAudioPlayListener.OnPlayFinish(com.youme.voice.AudioErrorCode.AUDIOERROR_SUCCESS, this.m_audioPath);
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(android.media.MediaPlayer mediaPlayer, int i, int i2) {
        android.util.Log.d(com.youme.im.CommonConst.LOG_TAG, "what:" + i + " extra:" + i2);
        android.media.MediaPlayer mediaPlayer2 = this.m_mediaPlayer;
        if (mediaPlayer2 != null) {
            mediaPlayer2.reset();
        }
        com.youme.voice.AudioErrorCode audioErrorCode = com.youme.voice.AudioErrorCode.AUDIOERROR_OTHREERROR;
        if (100 == i) {
            android.media.MediaPlayer mediaPlayer3 = this.m_mediaPlayer;
            if (mediaPlayer3 != null) {
                mediaPlayer3.release();
            }
            this.m_mediaPlayer = new android.media.MediaPlayer();
            this.m_mediaPlayer.setOnPreparedListener(this);
            this.m_mediaPlayer.setOnCompletionListener(this);
            this.m_mediaPlayer.setOnErrorListener(this);
        }
        if (-1010 == i2) {
            audioErrorCode = com.youme.voice.AudioErrorCode.AUDIOERROR_UNSUPPORT_FORMAT;
        } else if (-110 == i2) {
            audioErrorCode = com.youme.voice.AudioErrorCode.AUDIOERROR_PLAY_TIMEOUT;
        }
        com.youme.voice.IAudioPlayListener iAudioPlayListener = this.m_playerListener;
        if (iAudioPlayListener == null) {
            return true;
        }
        iAudioPlayListener.OnPlayFinish(audioErrorCode, this.m_audioPath);
        return true;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(android.media.MediaPlayer mediaPlayer) {
        android.util.Log.d(com.youme.im.CommonConst.LOG_TAG, "onPrepared");
        if (this.m_lastStateIsStop) {
            return;
        }
        android.util.Log.d(com.youme.im.CommonConst.LOG_TAG, "start play");
        this.m_mediaPlayer.start();
    }
}
