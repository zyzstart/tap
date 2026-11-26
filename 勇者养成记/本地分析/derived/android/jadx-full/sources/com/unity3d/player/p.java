package com.unity3d.player;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class p extends android.widget.FrameLayout implements android.media.MediaPlayer.OnBufferingUpdateListener, android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnPreparedListener, android.media.MediaPlayer.OnVideoSizeChangedListener, android.view.SurfaceHolder.Callback, android.widget.MediaController.MediaPlayerControl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f1643a = false;
    private final android.content.Context b;
    private final android.view.SurfaceView c;
    private final android.view.SurfaceHolder d;
    private final java.lang.String e;
    private final int f;
    private final int g;
    private final boolean h;
    private final long i;
    private final long j;
    private final android.widget.FrameLayout k;
    private final android.view.Display l;
    private int m;
    private int n;
    private int o;
    private int p;
    private android.media.MediaPlayer q;
    private android.widget.MediaController r;
    private boolean s;
    private boolean t;
    private int u;
    private boolean v;
    private boolean w;
    private com.unity3d.player.p.a x;
    private com.unity3d.player.p.b y;
    private volatile int z;

    public interface a {
        void a(int i);
    }

    public class b implements java.lang.Runnable {
        private com.unity3d.player.p b;
        private boolean c = false;

        public b(com.unity3d.player.p pVar) {
            this.b = pVar;
        }

        public final void a() {
            this.c = true;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                java.lang.Thread.sleep(5000L);
            } catch (java.lang.InterruptedException unused) {
                java.lang.Thread.currentThread().interrupt();
            }
            if (this.c) {
                return;
            }
            if (com.unity3d.player.p.f1643a) {
                com.unity3d.player.p.b("Stopping the video player due to timeout.");
            }
            this.b.CancelOnPrepare();
        }
    }

    protected p(android.content.Context context, java.lang.String str, int i, int i2, int i3, boolean z, long j, long j2, com.unity3d.player.p.a aVar) {
        super(context);
        this.s = false;
        this.t = false;
        this.u = 0;
        this.v = false;
        this.w = false;
        this.z = 0;
        this.x = aVar;
        this.b = context;
        this.k = this;
        this.c = new android.view.SurfaceView(context);
        this.d = this.c.getHolder();
        this.d.addCallback(this);
        this.k.setBackgroundColor(i);
        this.k.addView(this.c);
        this.l = ((android.view.WindowManager) this.b.getSystemService("window")).getDefaultDisplay();
        this.e = str;
        this.f = i2;
        this.g = i3;
        this.h = z;
        this.i = j;
        this.j = j2;
        if (f1643a) {
            b("fileName: " + this.e);
        }
        if (f1643a) {
            b("backgroundColor: " + i);
        }
        if (f1643a) {
            b("controlMode: " + this.f);
        }
        if (f1643a) {
            b("scalingMode: " + this.g);
        }
        if (f1643a) {
            b("isURL: " + this.h);
        }
        if (f1643a) {
            b("videoOffset: " + this.i);
        }
        if (f1643a) {
            b("videoLength: " + this.j);
        }
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    private void a(int i) {
        this.z = i;
        com.unity3d.player.p.a aVar = this.x;
        if (aVar != null) {
            aVar.a(this.z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(java.lang.String str) {
        android.util.Log.i("Video", "VideoPlayer: " + str);
    }

    private void c() {
        java.io.FileInputStream fileInputStream;
        android.media.MediaPlayer mediaPlayer = this.q;
        if (mediaPlayer != null) {
            mediaPlayer.setDisplay(this.d);
            if (this.v) {
                return;
            }
            if (f1643a) {
                b("Resuming playback");
            }
            this.q.start();
            return;
        }
        a(0);
        doCleanUp();
        try {
            this.q = new android.media.MediaPlayer();
            if (this.h) {
                this.q.setDataSource(this.b, android.net.Uri.parse(this.e));
            } else {
                if (this.j != 0) {
                    fileInputStream = new java.io.FileInputStream(this.e);
                    this.q.setDataSource(fileInputStream.getFD(), this.i, this.j);
                } else {
                    try {
                        android.content.res.AssetFileDescriptor assetFileDescriptorOpenFd = getResources().getAssets().openFd(this.e);
                        this.q.setDataSource(assetFileDescriptorOpenFd.getFileDescriptor(), assetFileDescriptorOpenFd.getStartOffset(), assetFileDescriptorOpenFd.getLength());
                        assetFileDescriptorOpenFd.close();
                    } catch (java.io.IOException unused) {
                        fileInputStream = new java.io.FileInputStream(this.e);
                        this.q.setDataSource(fileInputStream.getFD());
                        fileInputStream.close();
                    }
                }
                fileInputStream.close();
            }
            this.q.setDisplay(this.d);
            this.q.setScreenOnWhilePlaying(true);
            this.q.setOnBufferingUpdateListener(this);
            this.q.setOnCompletionListener(this);
            this.q.setOnPreparedListener(this);
            this.q.setOnVideoSizeChangedListener(this);
            this.q.setAudioStreamType(3);
            this.q.prepareAsync();
            this.y = new com.unity3d.player.p.b(this);
            new java.lang.Thread(this.y).start();
        } catch (java.lang.Exception e) {
            if (f1643a) {
                b("error: " + e.getMessage() + e);
            }
            a(2);
        }
    }

    private void d() {
        if (isPlaying()) {
            return;
        }
        a(1);
        if (f1643a) {
            b("startVideoPlayback");
        }
        updateVideoLayout();
        if (this.v) {
            return;
        }
        start();
    }

    public final void CancelOnPrepare() {
        a(2);
    }

    final boolean a() {
        return this.v;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canPause() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canSeekBackward() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canSeekForward() {
        return true;
    }

    protected final void destroyPlayer() {
        if (f1643a) {
            b("destroyPlayer");
        }
        if (!this.v) {
            pause();
        }
        doCleanUp();
    }

    protected final void doCleanUp() {
        com.unity3d.player.p.b bVar = this.y;
        if (bVar != null) {
            bVar.a();
            this.y = null;
        }
        android.media.MediaPlayer mediaPlayer = this.q;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.q = null;
        }
        this.o = 0;
        this.p = 0;
        this.t = false;
        this.s = false;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getBufferPercentage() {
        if (this.h) {
            return this.u;
        }
        return 100;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getCurrentPosition() {
        android.media.MediaPlayer mediaPlayer = this.q;
        if (mediaPlayer == null) {
            return 0;
        }
        return mediaPlayer.getCurrentPosition();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getDuration() {
        android.media.MediaPlayer mediaPlayer = this.q;
        if (mediaPlayer == null) {
            return 0;
        }
        return mediaPlayer.getDuration();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean isPlaying() {
        boolean z = this.t && this.s;
        android.media.MediaPlayer mediaPlayer = this.q;
        if (mediaPlayer == null) {
            return !z;
        }
        return mediaPlayer.isPlaying() || !z;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public final void onBufferingUpdate(android.media.MediaPlayer mediaPlayer, int i) {
        if (f1643a) {
            b("onBufferingUpdate percent:" + i);
        }
        this.u = i;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(android.media.MediaPlayer mediaPlayer) {
        if (f1643a) {
            b("onCompletion called");
        }
        destroyPlayer();
        a(3);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
        if (i != 4 && (this.f != 2 || i == 0 || keyEvent.isSystem())) {
            android.widget.MediaController mediaController = this.r;
            return mediaController != null ? mediaController.onKeyDown(i, keyEvent) : super.onKeyDown(i, keyEvent);
        }
        destroyPlayer();
        a(3);
        return true;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(android.media.MediaPlayer mediaPlayer) {
        if (f1643a) {
            b("onPrepared called");
        }
        com.unity3d.player.p.b bVar = this.y;
        if (bVar != null) {
            bVar.a();
            this.y = null;
        }
        int i = this.f;
        if (i == 0 || i == 1) {
            this.r = new android.widget.MediaController(this.b);
            this.r.setMediaPlayer(this);
            this.r.setAnchorView(this);
            this.r.setEnabled(true);
            android.content.Context context = this.b;
            if (context instanceof android.app.Activity) {
                this.r.setSystemUiVisibility(((android.app.Activity) context).getWindow().getDecorView().getSystemUiVisibility());
            }
            this.r.show();
        }
        this.t = true;
        if (this.t && this.s) {
            d();
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (this.f != 2 || action != 0) {
            android.widget.MediaController mediaController = this.r;
            return mediaController != null ? mediaController.onTouchEvent(motionEvent) : super.onTouchEvent(motionEvent);
        }
        destroyPlayer();
        a(3);
        return true;
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public final void onVideoSizeChanged(android.media.MediaPlayer mediaPlayer, int i, int i2) {
        if (f1643a) {
            b("onVideoSizeChanged called " + i + "x" + i2);
        }
        if (i != 0 && i2 != 0) {
            this.s = true;
            this.o = i;
            this.p = i2;
            if (this.t && this.s) {
                d();
                return;
            }
            return;
        }
        if (f1643a) {
            b("invalid video width(" + i + ") or height(" + i2 + ")");
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final void pause() {
        android.media.MediaPlayer mediaPlayer = this.q;
        if (mediaPlayer == null) {
            return;
        }
        if (this.w) {
            mediaPlayer.pause();
        }
        this.v = true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final void seekTo(int i) {
        android.media.MediaPlayer mediaPlayer = this.q;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.seekTo(i);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final void start() {
        if (f1643a) {
            b("Start");
        }
        android.media.MediaPlayer mediaPlayer = this.q;
        if (mediaPlayer == null) {
            return;
        }
        if (this.w) {
            mediaPlayer.start();
        }
        this.v = false;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(android.view.SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (f1643a) {
            b("surfaceChanged called " + i + " " + i2 + "x" + i3);
        }
        if (this.m == i2 && this.n == i3) {
            return;
        }
        this.m = i2;
        this.n = i3;
        if (this.w) {
            updateVideoLayout();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(android.view.SurfaceHolder surfaceHolder) {
        if (f1643a) {
            b("surfaceCreated called");
        }
        this.w = true;
        c();
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(android.view.SurfaceHolder surfaceHolder) {
        if (f1643a) {
            b("surfaceDestroyed called");
        }
        this.w = false;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x004f  */
    /* JADX WARN: Code duplicated, block: B:20:0x0053  */
    protected final void updateVideoLayout() {
        if (f1643a) {
            b("updateVideoLayout");
        }
        if (this.q == null) {
            return;
        }
        if (this.m == 0 || this.n == 0) {
            android.view.WindowManager windowManager = (android.view.WindowManager) this.b.getSystemService("window");
            android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            this.m = displayMetrics.widthPixels;
            this.n = displayMetrics.heightPixels;
        }
        int i = this.m;
        int i2 = this.n;
        if (this.s) {
            int i3 = this.o;
            int i4 = this.p;
            float f = i3 / i4;
            float f2 = i / i2;
            int i5 = this.g;
            if (i5 == 1) {
                if (f2 <= f) {
                    i2 = (int) (i / f);
                } else {
                    i = (int) (i2 * f);
                }
            } else if (i5 == 2) {
                if (f2 >= f) {
                    i2 = (int) (i / f);
                } else {
                    i = (int) (i2 * f);
                }
            } else if (i5 == 0) {
                i = i3;
                i2 = i4;
            }
        } else if (f1643a) {
            b("updateVideoLayout: Video size is not known yet");
        }
        if (this.m == i && this.n == i2) {
            return;
        }
        if (f1643a) {
            b("frameWidth = " + i + "; frameHeight = " + i2);
        }
        this.k.updateViewLayout(this.c, new android.widget.FrameLayout.LayoutParams(i, i2, 17));
    }
}
