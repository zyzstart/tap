package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class TbsMediaPlayer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tencent.smtt.sdk.n f870a;

    public interface TbsMediaPlayerListener {
        public static final int MEDIA_EXTRA_AUDIOTRACK_INDEX = 104;
        public static final int MEDIA_EXTRA_AUDIOTRACK_TITLES = 103;
        public static final int MEDIA_EXTRA_SUBTITLE_COUNT = 101;
        public static final int MEDIA_EXTRA_SUBTITLE_INDEX = 102;
        public static final int MEDIA_INFO_BAD_INTERLEAVING = 800;
        public static final int MEDIA_INFO_BUFFERING_END = 702;
        public static final int MEDIA_INFO_BUFFERING_PERCENTAGE = 790;
        public static final int MEDIA_INFO_BUFFERING_START = 701;
        public static final int MEDIA_INFO_EXTERNAL_METADATA_UPDATE = 803;
        public static final int MEDIA_INFO_HAVE_VIDEO_DATA = 752;
        public static final int MEDIA_INFO_METADATA_UPDATE = 802;
        public static final int MEDIA_INFO_NETWORK_BANDWIDTH = 703;
        public static final int MEDIA_INFO_NOT_SEEKABLE = 801;
        public static final int MEDIA_INFO_NO_VIDEO_DATA = 751;
        public static final int MEDIA_INFO_SUBTITLE_TIMED_OUT = 902;
        public static final int MEDIA_INFO_TIMED_TEXT_ERROR = 900;
        public static final int MEDIA_INFO_UNSUPPORTED_SUBTITLE = 901;
        public static final int MEDIA_INFO_VIDEO_TRACK_LAGGING = 700;
        public static final int ROTATE_ACTION_HASROTATE = 3;
        public static final int ROTATE_ACTION_NOTHING = 1;
        public static final int ROTATE_ACTION_SETDEGREE = 2;
        public static final int ROTATE_ACTION_UNKNOWN = 0;

        void onBufferingUpdate(float f);

        void onPlayerCompleted();

        void onPlayerError(java.lang.String str, int i, int i2, java.lang.Throwable th);

        void onPlayerExtra(int i, java.lang.Object obj);

        void onPlayerInfo(int i, int i2);

        void onPlayerPaused();

        void onPlayerPlaying();

        void onPlayerPrepared(long j, int i, int i2, int i3, int i4);

        void onPlayerProgress(long j);

        void onPlayerSeeked(long j);

        void onPlayerSubtitle(java.lang.String str);
    }

    public TbsMediaPlayer(com.tencent.smtt.sdk.n nVar) {
        this.f870a = null;
        this.f870a = nVar;
    }

    public void audio(int i) {
        this.f870a.b(i);
    }

    public void close() {
        this.f870a.e();
    }

    public float getVolume() {
        return this.f870a.b();
    }

    public boolean isAvailable() {
        return this.f870a.a();
    }

    public void pause() {
        this.f870a.c();
    }

    public void play() {
        this.f870a.d();
    }

    public void seek(long j) {
        this.f870a.a(j);
    }

    public void setPlayerListener(com.tencent.smtt.sdk.TbsMediaPlayer.TbsMediaPlayerListener tbsMediaPlayerListener) {
        this.f870a.a(tbsMediaPlayerListener);
    }

    public void setSurfaceTexture(android.graphics.SurfaceTexture surfaceTexture) {
        this.f870a.a(surfaceTexture);
    }

    public void setVolume(float f) {
        this.f870a.a(f);
    }

    public void startPlay(java.lang.String str, android.os.Bundle bundle) {
        this.f870a.a(str, bundle);
    }

    public void subtitle(int i) {
        this.f870a.a(i);
    }
}
