package com.unity3d.player;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class UnityPlayer extends android.widget.FrameLayout implements com.unity3d.player.f {
    public static android.app.Activity currentActivity;
    private static boolean s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    com.unity3d.player.UnityPlayer.e f1587a;
    com.unity3d.player.k b;
    private int c;
    private boolean d;
    private boolean e;
    private com.unity3d.player.n f;
    private final java.util.concurrent.ConcurrentLinkedQueue g;
    private android.content.BroadcastReceiver h;
    private boolean i;
    private com.unity3d.player.UnityPlayer.c j;
    private android.telephony.TelephonyManager k;
    private android.content.ClipboardManager l;
    private com.unity3d.player.l m;
    private com.unity3d.player.GoogleARCoreApi n;
    private com.unity3d.player.UnityPlayer.a o;
    private com.unity3d.player.Camera2Wrapper p;
    private android.content.Context q;
    private android.view.SurfaceView r;
    private boolean t;
    private com.unity3d.player.q u;

    class a implements android.hardware.SensorEventListener {
        a() {
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(android.hardware.Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(android.hardware.SensorEvent sensorEvent) {
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f1612a = 1;
        public static final int b = 2;
        public static final int c = 3;
        private static final /* synthetic */ int[] d = {f1612a, b, c};
    }

    private class c extends android.telephony.PhoneStateListener {
        private c() {
        }

        /* synthetic */ c(com.unity3d.player.UnityPlayer unityPlayer, byte b) {
            this();
        }

        @Override // android.telephony.PhoneStateListener
        public final void onCallStateChanged(int i, java.lang.String str) {
            com.unity3d.player.UnityPlayer.this.nativeMuteMasterAudio(i == 1);
        }
    }

    enum d {
        PAUSE,
        RESUME,
        QUIT,
        SURFACE_LOST,
        SURFACE_ACQUIRED,
        FOCUS_LOST,
        FOCUS_GAINED,
        NEXT_FRAME
    }

    private class e extends java.lang.Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        android.os.Handler f1615a;
        boolean b;
        boolean c;
        int d;
        int e;

        private e() {
            this.b = false;
            this.c = false;
            this.d = com.unity3d.player.UnityPlayer.b.b;
            this.e = 5;
        }

        /* synthetic */ e(com.unity3d.player.UnityPlayer unityPlayer, byte b) {
            this();
        }

        private void a(com.unity3d.player.UnityPlayer.d dVar) {
            android.os.Handler handler = this.f1615a;
            if (handler != null) {
                android.os.Message.obtain(handler, 2269, dVar).sendToTarget();
            }
        }

        public final void a() {
            a(com.unity3d.player.UnityPlayer.d.QUIT);
        }

        public final void a(java.lang.Runnable runnable) {
            if (this.f1615a == null) {
                return;
            }
            a(com.unity3d.player.UnityPlayer.d.PAUSE);
            android.os.Message.obtain(this.f1615a, runnable).sendToTarget();
        }

        public final void b() {
            a(com.unity3d.player.UnityPlayer.d.RESUME);
        }

        public final void b(java.lang.Runnable runnable) {
            if (this.f1615a == null) {
                return;
            }
            a(com.unity3d.player.UnityPlayer.d.SURFACE_LOST);
            android.os.Message.obtain(this.f1615a, runnable).sendToTarget();
        }

        public final void c() {
            a(com.unity3d.player.UnityPlayer.d.FOCUS_GAINED);
        }

        public final void c(java.lang.Runnable runnable) {
            android.os.Handler handler = this.f1615a;
            if (handler == null) {
                return;
            }
            android.os.Message.obtain(handler, runnable).sendToTarget();
            a(com.unity3d.player.UnityPlayer.d.SURFACE_ACQUIRED);
        }

        public final void d() {
            a(com.unity3d.player.UnityPlayer.d.FOCUS_LOST);
        }

        public final void d(java.lang.Runnable runnable) {
            android.os.Handler handler = this.f1615a;
            if (handler != null) {
                android.os.Message.obtain(handler, runnable).sendToTarget();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            setName("UnityMain");
            android.os.Looper.prepare();
            this.f1615a = new android.os.Handler(new android.os.Handler.Callback() { // from class: com.unity3d.player.UnityPlayer.e.1
                private void a() {
                    if (com.unity3d.player.UnityPlayer.e.this.d == com.unity3d.player.UnityPlayer.b.c && com.unity3d.player.UnityPlayer.e.this.c) {
                        com.unity3d.player.UnityPlayer.this.nativeFocusChanged(true);
                        com.unity3d.player.UnityPlayer.e.this.d = com.unity3d.player.UnityPlayer.b.f1612a;
                    }
                }

                @Override // android.os.Handler.Callback
                public final boolean handleMessage(android.os.Message message) {
                    if (message.what != 2269) {
                        return false;
                    }
                    com.unity3d.player.UnityPlayer.d dVar = (com.unity3d.player.UnityPlayer.d) message.obj;
                    if (dVar == com.unity3d.player.UnityPlayer.d.NEXT_FRAME) {
                        return true;
                    }
                    if (dVar == com.unity3d.player.UnityPlayer.d.QUIT) {
                        android.os.Looper.myLooper().quit();
                    } else if (dVar == com.unity3d.player.UnityPlayer.d.RESUME) {
                        com.unity3d.player.UnityPlayer.e.this.b = true;
                    } else if (dVar == com.unity3d.player.UnityPlayer.d.PAUSE) {
                        com.unity3d.player.UnityPlayer.e.this.b = false;
                    } else if (dVar == com.unity3d.player.UnityPlayer.d.SURFACE_LOST) {
                        com.unity3d.player.UnityPlayer.e.this.c = false;
                    } else {
                        if (dVar == com.unity3d.player.UnityPlayer.d.SURFACE_ACQUIRED) {
                            com.unity3d.player.UnityPlayer.e.this.c = true;
                        } else if (dVar == com.unity3d.player.UnityPlayer.d.FOCUS_LOST) {
                            if (com.unity3d.player.UnityPlayer.e.this.d == com.unity3d.player.UnityPlayer.b.f1612a) {
                                com.unity3d.player.UnityPlayer.this.nativeFocusChanged(false);
                            }
                            com.unity3d.player.UnityPlayer.e.this.d = com.unity3d.player.UnityPlayer.b.b;
                        } else if (dVar == com.unity3d.player.UnityPlayer.d.FOCUS_GAINED) {
                            com.unity3d.player.UnityPlayer.e.this.d = com.unity3d.player.UnityPlayer.b.c;
                        }
                        a();
                    }
                    return true;
                }
            });
            android.os.Looper.myQueue().addIdleHandler(new android.os.MessageQueue.IdleHandler() { // from class: com.unity3d.player.UnityPlayer.e.2
                @Override // android.os.MessageQueue.IdleHandler
                public final boolean queueIdle() {
                    com.unity3d.player.UnityPlayer.this.executeGLThreadJobs();
                    if (!com.unity3d.player.UnityPlayer.e.this.b || !com.unity3d.player.UnityPlayer.e.this.c) {
                        return true;
                    }
                    if (com.unity3d.player.UnityPlayer.e.this.e >= 0) {
                        if (com.unity3d.player.UnityPlayer.e.this.e == 0 && com.unity3d.player.UnityPlayer.this.k()) {
                            com.unity3d.player.UnityPlayer.this.a();
                        }
                        com.unity3d.player.UnityPlayer.e.this.e--;
                    }
                    if (!com.unity3d.player.UnityPlayer.this.isFinishing() && !com.unity3d.player.UnityPlayer.this.nativeRender()) {
                        com.unity3d.player.UnityPlayer.this.e();
                    }
                    android.os.Message.obtain(com.unity3d.player.UnityPlayer.e.this.f1615a, 2269, com.unity3d.player.UnityPlayer.d.NEXT_FRAME).sendToTarget();
                    return true;
                }
            });
            android.os.Looper.loop();
        }
    }

    private abstract class f implements java.lang.Runnable {
        private f() {
        }

        /* synthetic */ f(com.unity3d.player.UnityPlayer unityPlayer, byte b) {
            this();
        }

        public abstract void a();

        @Override // java.lang.Runnable
        public final void run() {
            if (com.unity3d.player.UnityPlayer.this.isFinishing()) {
                return;
            }
            a();
        }
    }

    static {
        new com.unity3d.player.m().a();
        s = false;
        s = loadLibraryStatic("main");
    }

    public UnityPlayer(android.content.Context context) {
        super(context);
        this.c = -1;
        byte b2 = 0;
        this.d = false;
        this.e = true;
        this.f = new com.unity3d.player.n();
        this.g = new java.util.concurrent.ConcurrentLinkedQueue();
        this.h = null;
        this.f1587a = new com.unity3d.player.UnityPlayer.e(this, b2);
        this.i = false;
        this.j = new com.unity3d.player.UnityPlayer.c(this, b2);
        this.n = null;
        this.o = new com.unity3d.player.UnityPlayer.a();
        this.p = null;
        this.b = null;
        if (context instanceof android.app.Activity) {
            currentActivity = (android.app.Activity) context;
            this.c = currentActivity.getRequestedOrientation();
        }
        a(currentActivity);
        this.q = context;
        if (currentActivity != null && k()) {
            this.m = new com.unity3d.player.l(this.q, com.unity3d.player.l.a.a()[getSplashMode()]);
            addView(this.m);
        }
        a(this.q.getApplicationInfo());
        if (!com.unity3d.player.n.c()) {
            android.app.AlertDialog alertDialogCreate = new android.app.AlertDialog.Builder(this.q).setTitle("Failure to initialize!").setPositiveButton("OK", new android.content.DialogInterface.OnClickListener() { // from class: com.unity3d.player.UnityPlayer.1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(android.content.DialogInterface dialogInterface, int i) {
                    com.unity3d.player.UnityPlayer.this.e();
                }
            }).setMessage("Your hardware does not support this application, sorry!").create();
            alertDialogCreate.setCancelable(false);
            alertDialogCreate.show();
            return;
        }
        initJni(context);
        this.f.c(true);
        this.r = c();
        this.r.setContentDescription(a(context));
        addView(this.r);
        bringChildToFront(this.m);
        this.t = false;
        nativeInitWebRequest(com.unity3d.player.UnityWebRequest.class);
        m();
        this.k = (android.telephony.TelephonyManager) this.q.getSystemService("phone");
        this.l = (android.content.ClipboardManager) this.q.getSystemService("clipboard");
        this.p = new com.unity3d.player.Camera2Wrapper(this.q);
        this.f1587a.start();
    }

    public static void UnitySendMessage(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (com.unity3d.player.n.c()) {
            try {
                nativeUnitySendMessage(str, str2, str3.getBytes("UTF-8"));
                return;
            } catch (java.io.UnsupportedEncodingException unused) {
                return;
            }
        }
        com.unity3d.player.g.Log(5, "Native libraries not loaded - dropping message for " + str + "." + str2);
    }

    private static java.lang.String a(android.content.Context context) {
        return context.getResources().getString(context.getResources().getIdentifier("game_view_content_description", "string", context.getPackageName()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        a(new java.lang.Runnable() { // from class: com.unity3d.player.UnityPlayer.17
            @Override // java.lang.Runnable
            public final void run() {
                com.unity3d.player.UnityPlayer unityPlayer = com.unity3d.player.UnityPlayer.this;
                unityPlayer.removeView(unityPlayer.m);
                com.unity3d.player.UnityPlayer.f(com.unity3d.player.UnityPlayer.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, android.view.Surface surface) {
        if (this.d) {
            return;
        }
        b(0, surface);
    }

    private static void a(android.app.Activity activity) {
        android.view.View decorView;
        if (activity == null || !activity.getIntent().getBooleanExtra("android.intent.extra.VR_LAUNCH", false) || activity.getWindow() == null || (decorView = activity.getWindow().getDecorView()) == null) {
            return;
        }
        decorView.setSystemUiVisibility(7);
    }

    private static void a(android.content.pm.ApplicationInfo applicationInfo) {
        if (s && com.unity3d.player.NativeLoader.load(applicationInfo.nativeLibraryDir)) {
            com.unity3d.player.n.a();
        }
    }

    private void a(android.view.View view, android.view.View view2) {
        boolean z;
        if (this.f.d()) {
            z = false;
        } else {
            pause();
            z = true;
        }
        if (view != null) {
            android.view.ViewParent parent = view.getParent();
            if (!(parent instanceof com.unity3d.player.UnityPlayer) || ((com.unity3d.player.UnityPlayer) parent) != this) {
                if (parent instanceof android.view.ViewGroup) {
                    ((android.view.ViewGroup) parent).removeView(view);
                }
                addView(view);
                bringChildToFront(view);
                view.setVisibility(0);
            }
        }
        if (view2 != null && view2.getParent() == this) {
            view2.setVisibility(8);
            removeView(view2);
        }
        if (z) {
            resume();
        }
    }

    private void a(com.unity3d.player.UnityPlayer.f fVar) {
        if (isFinishing()) {
            return;
        }
        b(fVar);
    }

    private void b(java.lang.Runnable runnable) {
        if (com.unity3d.player.n.c()) {
            if (java.lang.Thread.currentThread() == this.f1587a) {
                runnable.run();
            } else {
                this.g.add(runnable);
            }
        }
    }

    private static boolean b() {
        if (currentActivity == null) {
            return false;
        }
        android.util.TypedValue typedValue = new android.util.TypedValue();
        return currentActivity.getTheme().resolveAttribute(android.R.attr.windowIsTranslucent, typedValue, true) && typedValue.type == 18 && typedValue.data != 0;
    }

    private boolean b(final int i, final android.view.Surface surface) {
        if (!com.unity3d.player.n.c() || !this.f.e()) {
            return false;
        }
        final java.util.concurrent.Semaphore semaphore = new java.util.concurrent.Semaphore(0);
        java.lang.Runnable runnable = new java.lang.Runnable() { // from class: com.unity3d.player.UnityPlayer.20
            @Override // java.lang.Runnable
            public final void run() {
                com.unity3d.player.UnityPlayer.this.nativeRecreateGfxState(i, surface);
                semaphore.release();
            }
        };
        if (i != 0) {
            runnable.run();
        } else if (surface == null) {
            this.f1587a.b(runnable);
        } else {
            this.f1587a.c(runnable);
        }
        if (surface != null || i != 0) {
            return true;
        }
        try {
            if (semaphore.tryAcquire(4L, java.util.concurrent.TimeUnit.SECONDS)) {
                return true;
            }
            com.unity3d.player.g.Log(5, "Timeout while trying detaching primary window.");
            return true;
        } catch (java.lang.InterruptedException unused) {
            com.unity3d.player.g.Log(5, "UI thread got interrupted while trying to detach the primary window from the Unity Engine.");
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.view.SurfaceView c() {
        android.view.SurfaceView surfaceView = new android.view.SurfaceView(this.q);
        if (b()) {
            surfaceView.getHolder().setFormat(-3);
            surfaceView.setZOrderOnTop(true);
        } else {
            surfaceView.getHolder().setFormat(-1);
        }
        surfaceView.getHolder().addCallback(new android.view.SurfaceHolder.Callback() { // from class: com.unity3d.player.UnityPlayer.18
            @Override // android.view.SurfaceHolder.Callback
            public final void surfaceChanged(android.view.SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                com.unity3d.player.UnityPlayer.this.a(0, surfaceHolder.getSurface());
                com.unity3d.player.UnityPlayer.this.d();
            }

            @Override // android.view.SurfaceHolder.Callback
            public final void surfaceCreated(android.view.SurfaceHolder surfaceHolder) {
                com.unity3d.player.UnityPlayer.this.a(0, surfaceHolder.getSurface());
            }

            @Override // android.view.SurfaceHolder.Callback
            public final void surfaceDestroyed(android.view.SurfaceHolder surfaceHolder) {
                com.unity3d.player.UnityPlayer.this.a(0, (android.view.Surface) null);
            }
        });
        surfaceView.setFocusable(true);
        surfaceView.setFocusableInTouchMode(true);
        return surfaceView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (com.unity3d.player.n.c() && this.f.e()) {
            this.f1587a.d(new java.lang.Runnable() { // from class: com.unity3d.player.UnityPlayer.19
                @Override // java.lang.Runnable
                public final void run() {
                    com.unity3d.player.UnityPlayer.this.nativeSendSurfaceChangedEvent();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        android.content.Context context = this.q;
        if (!(context instanceof android.app.Activity) || ((android.app.Activity) context).isFinishing()) {
            return;
        }
        ((android.app.Activity) this.q).finish();
    }

    static /* synthetic */ com.unity3d.player.l f(com.unity3d.player.UnityPlayer unityPlayer) {
        unityPlayer.m = null;
        return null;
    }

    private void f() {
        reportSoftInputStr(null, 1, true);
        if (this.f.g()) {
            if (com.unity3d.player.n.c()) {
                final java.util.concurrent.Semaphore semaphore = new java.util.concurrent.Semaphore(0);
                this.f1587a.a(isFinishing() ? new java.lang.Runnable() { // from class: com.unity3d.player.UnityPlayer.22
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.unity3d.player.UnityPlayer.this.g();
                        semaphore.release();
                    }
                } : new java.lang.Runnable() { // from class: com.unity3d.player.UnityPlayer.23
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (!com.unity3d.player.UnityPlayer.this.nativePause()) {
                            semaphore.release();
                            return;
                        }
                        com.unity3d.player.UnityPlayer.m(com.unity3d.player.UnityPlayer.this);
                        com.unity3d.player.UnityPlayer.this.g();
                        semaphore.release(2);
                    }
                });
                try {
                    if (!semaphore.tryAcquire(4L, java.util.concurrent.TimeUnit.SECONDS)) {
                        com.unity3d.player.g.Log(5, "Timeout while trying to pause the Unity Engine.");
                    }
                } catch (java.lang.InterruptedException unused) {
                    com.unity3d.player.g.Log(5, "UI thread got interrupted while trying to pause the Unity Engine.");
                }
                if (semaphore.drainPermits() > 0) {
                    destroy();
                }
            }
            this.f.d(false);
            this.f.b(true);
            if (this.i) {
                this.k.listen(this.j, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        nativeDone();
        this.f.c(false);
    }

    private void h() {
        if (this.f.f()) {
            this.f.d(true);
            b(new java.lang.Runnable() { // from class: com.unity3d.player.UnityPlayer.3
                @Override // java.lang.Runnable
                public final void run() {
                    com.unity3d.player.UnityPlayer.this.nativeResume();
                }
            });
            this.f1587a.b();
        }
    }

    private static void i() {
        if (com.unity3d.player.n.c()) {
            if (!com.unity3d.player.NativeLoader.unload()) {
                throw new java.lang.UnsatisfiedLinkError("Unable to unload libraries from libmain.so");
            }
            com.unity3d.player.n.b();
        }
    }

    private final native void initJni(android.content.Context context);

    private android.content.pm.ApplicationInfo j() {
        return this.q.getPackageManager().getApplicationInfo(this.q.getPackageName(), 128);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k() {
        try {
            return j().metaData.getBoolean("unity.splash-enable");
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    private boolean l() {
        try {
            return j().metaData.getBoolean("unity.tango-enable");
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    protected static boolean loadLibraryStatic(java.lang.String str) {
        java.lang.StringBuilder sb;
        try {
            java.lang.System.loadLibrary(str);
            return true;
        } catch (java.lang.Exception e2) {
            sb = new java.lang.StringBuilder("Unknown error ");
            sb.append(e2);
            com.unity3d.player.g.Log(6, sb.toString());
            return false;
        } catch (java.lang.UnsatisfiedLinkError unused) {
            sb = new java.lang.StringBuilder("Unable to find ");
            sb.append(str);
            com.unity3d.player.g.Log(6, sb.toString());
            return false;
        }
    }

    private void m() {
        android.content.Context context = this.q;
        if (context instanceof android.app.Activity) {
            ((android.app.Activity) context).getWindow().setFlags(1024, 1024);
        }
    }

    static /* synthetic */ boolean m(com.unity3d.player.UnityPlayer unityPlayer) {
        unityPlayer.t = true;
        return true;
    }

    private final native void nativeDone();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeFocusChanged(boolean z);

    private final native void nativeInitWebRequest(java.lang.Class cls);

    private final native boolean nativeInjectEvent(android.view.InputEvent inputEvent);

    /* JADX INFO: Access modifiers changed from: private */
    public final native boolean nativeIsAutorotationOn();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeLowMemory();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeMuteMasterAudio(boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public final native boolean nativePause();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeRecreateGfxState(int i, android.view.Surface surface);

    /* JADX INFO: Access modifiers changed from: private */
    public final native boolean nativeRender();

    private final native void nativeRestartActivityIndicator();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeResume();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeSendSurfaceChangedEvent();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeSetInputSelection(int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeSetInputString(java.lang.String str);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeSoftInputCanceled();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeSoftInputClosed();

    private final native void nativeSoftInputLostFocus();

    private static native void nativeUnitySendMessage(java.lang.String str, java.lang.String str2, byte[] bArr);

    static /* synthetic */ com.unity3d.player.q t(com.unity3d.player.UnityPlayer unityPlayer) {
        unityPlayer.u = null;
        return null;
    }

    final void a(java.lang.Runnable runnable) {
        android.content.Context context = this.q;
        if (context instanceof android.app.Activity) {
            ((android.app.Activity) context).runOnUiThread(runnable);
        } else {
            com.unity3d.player.g.Log(5, "Not running Unity from an Activity; ignored...");
        }
    }

    protected void addPhoneCallListener() {
        this.i = true;
        this.k.listen(this.j, 32);
    }

    @Override // com.unity3d.player.f
    public boolean addViewToPlayer(android.view.View view, boolean z) {
        a(view, z ? this.r : null);
        boolean z2 = true;
        boolean z3 = view.getParent() == this;
        boolean z4 = z && this.r.getParent() == null;
        boolean z5 = this.r.getParent() == this;
        if (!z3 || (!z4 && !z5)) {
            z2 = false;
        }
        if (!z2) {
            if (!z3) {
                com.unity3d.player.g.Log(6, "addViewToPlayer: Failure adding view to hierarchy");
            }
            if (!z4 && !z5) {
                com.unity3d.player.g.Log(6, "addViewToPlayer: Failure removing old view from hierarchy");
            }
        }
        return z2;
    }

    public void configurationChanged(android.content.res.Configuration configuration) {
        android.view.SurfaceView surfaceView = this.r;
        if (surfaceView instanceof android.view.SurfaceView) {
            surfaceView.getHolder().setSizeFromLayout();
        }
        com.unity3d.player.q qVar = this.u;
        if (qVar != null) {
            qVar.c();
        }
        com.unity3d.player.GoogleVrProxy googleVrProxyB = com.unity3d.player.GoogleVrApi.b();
        if (googleVrProxyB != null) {
            googleVrProxyB.c();
        }
    }

    public void destroy() {
        if (com.unity3d.player.GoogleVrApi.b() != null) {
            com.unity3d.player.GoogleVrApi.a();
        }
        com.unity3d.player.Camera2Wrapper camera2Wrapper = this.p;
        if (camera2Wrapper != null) {
            camera2Wrapper.a();
            this.p = null;
        }
        this.t = true;
        if (!this.f.d()) {
            pause();
        }
        this.f1587a.a();
        try {
            this.f1587a.join(4000L);
        } catch (java.lang.InterruptedException unused) {
            this.f1587a.interrupt();
        }
        android.content.BroadcastReceiver broadcastReceiver = this.h;
        if (broadcastReceiver != null) {
            this.q.unregisterReceiver(broadcastReceiver);
        }
        this.h = null;
        if (com.unity3d.player.n.c()) {
            removeAllViews();
        }
        kill();
        i();
    }

    protected void disableLogger() {
        com.unity3d.player.g.f1630a = true;
    }

    public boolean displayChanged(int i, android.view.Surface surface) {
        if (i == 0) {
            this.d = surface != null;
            a(new java.lang.Runnable() { // from class: com.unity3d.player.UnityPlayer.21
                @Override // java.lang.Runnable
                public final void run() {
                    if (com.unity3d.player.UnityPlayer.this.d) {
                        com.unity3d.player.UnityPlayer unityPlayer = com.unity3d.player.UnityPlayer.this;
                        unityPlayer.removeView(unityPlayer.r);
                    } else {
                        com.unity3d.player.UnityPlayer unityPlayer2 = com.unity3d.player.UnityPlayer.this;
                        unityPlayer2.addView(unityPlayer2.r);
                    }
                }
            });
        }
        return b(i, surface);
    }

    protected void executeGLThreadJobs() {
        while (true) {
            java.lang.Runnable runnable = (java.lang.Runnable) this.g.poll();
            if (runnable == null) {
                return;
            } else {
                runnable.run();
            }
        }
    }

    protected java.lang.String getClipboardText() {
        android.content.ClipData primaryClip = this.l.getPrimaryClip();
        return primaryClip != null ? primaryClip.getItemAt(0).coerceToText(this.q).toString() : "";
    }

    public android.os.Bundle getSettings() {
        return android.os.Bundle.EMPTY;
    }

    protected int getSplashMode() {
        try {
            return j().metaData.getInt("unity.splash-mode");
        } catch (java.lang.Exception unused) {
            return 0;
        }
    }

    public android.view.View getView() {
        return this;
    }

    protected void hideSoftInput() {
        final java.lang.Runnable runnable = new java.lang.Runnable() { // from class: com.unity3d.player.UnityPlayer.5
            @Override // java.lang.Runnable
            public final void run() {
                if (com.unity3d.player.UnityPlayer.this.b != null) {
                    com.unity3d.player.UnityPlayer.this.b.dismiss();
                    com.unity3d.player.UnityPlayer.this.b = null;
                }
            }
        };
        if (com.unity3d.player.j.b) {
            a(new com.unity3d.player.UnityPlayer.f() { // from class: com.unity3d.player.UnityPlayer.6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(com.unity3d.player.UnityPlayer.this, (byte) 0);
                }

                @Override // com.unity3d.player.UnityPlayer.f
                public final void a() {
                    com.unity3d.player.UnityPlayer.this.a(runnable);
                }
            });
        } else {
            a(runnable);
        }
    }

    public void init(int i, boolean z) {
    }

    protected boolean initializeGoogleAr() {
        if (this.n != null || currentActivity == null || !l()) {
            return false;
        }
        this.n = new com.unity3d.player.GoogleARCoreApi();
        this.n.initializeARCore(currentActivity);
        if (this.f.d()) {
            return false;
        }
        this.n.resumeARCore();
        return false;
    }

    protected boolean initializeGoogleVr() {
        final com.unity3d.player.GoogleVrProxy googleVrProxyB = com.unity3d.player.GoogleVrApi.b();
        if (googleVrProxyB == null) {
            com.unity3d.player.GoogleVrApi.a(this);
            googleVrProxyB = com.unity3d.player.GoogleVrApi.b();
            if (googleVrProxyB == null) {
                com.unity3d.player.g.Log(6, "Unable to create Google VR subsystem.");
                return false;
            }
        }
        final java.util.concurrent.Semaphore semaphore = new java.util.concurrent.Semaphore(0);
        final java.lang.Runnable runnable = new java.lang.Runnable() { // from class: com.unity3d.player.UnityPlayer.13
            @Override // java.lang.Runnable
            public final void run() {
                com.unity3d.player.UnityPlayer.this.injectEvent(new android.view.KeyEvent(0, 4));
                com.unity3d.player.UnityPlayer.this.injectEvent(new android.view.KeyEvent(1, 4));
            }
        };
        a(new java.lang.Runnable() { // from class: com.unity3d.player.UnityPlayer.14
            @Override // java.lang.Runnable
            public final void run() {
                if (!googleVrProxyB.a(com.unity3d.player.UnityPlayer.currentActivity, com.unity3d.player.UnityPlayer.this.q, com.unity3d.player.UnityPlayer.this.c(), runnable)) {
                    com.unity3d.player.g.Log(6, "Unable to initialize Google VR subsystem.");
                }
                if (com.unity3d.player.UnityPlayer.currentActivity != null) {
                    googleVrProxyB.a(com.unity3d.player.UnityPlayer.currentActivity.getIntent());
                }
                semaphore.release();
            }
        });
        try {
            if (semaphore.tryAcquire(4L, java.util.concurrent.TimeUnit.SECONDS)) {
                return googleVrProxyB.a();
            }
            com.unity3d.player.g.Log(5, "Timeout while trying to initialize Google VR.");
            return false;
        } catch (java.lang.InterruptedException e2) {
            com.unity3d.player.g.Log(5, "UI thread was interrupted while initializing Google VR. " + e2.getLocalizedMessage());
            return false;
        }
    }

    public boolean injectEvent(android.view.InputEvent inputEvent) {
        if (com.unity3d.player.n.c()) {
            return nativeInjectEvent(inputEvent);
        }
        return false;
    }

    protected boolean isFinishing() {
        if (!this.t) {
            android.content.Context context = this.q;
            boolean z = (context instanceof android.app.Activity) && ((android.app.Activity) context).isFinishing();
            this.t = z;
            if (!z) {
                return false;
            }
        }
        return true;
    }

    protected void kill() {
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    protected boolean loadLibrary(java.lang.String str) {
        return loadLibraryStatic(str);
    }

    public void lowMemory() {
        if (com.unity3d.player.n.c()) {
            b(new java.lang.Runnable() { // from class: com.unity3d.player.UnityPlayer.2
                @Override // java.lang.Runnable
                public final void run() {
                    com.unity3d.player.UnityPlayer.this.nativeLowMemory();
                }
            });
        }
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(android.view.MotionEvent motionEvent) {
        return injectEvent(motionEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i, android.view.KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i, int i2, android.view.KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, android.view.KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        return injectEvent(motionEvent);
    }

    public void pause() {
        com.unity3d.player.GoogleARCoreApi googleARCoreApi = this.n;
        if (googleARCoreApi != null) {
            googleARCoreApi.pauseARCore();
        }
        com.unity3d.player.q qVar = this.u;
        if (qVar != null) {
            qVar.a();
        }
        com.unity3d.player.GoogleVrProxy googleVrProxyB = com.unity3d.player.GoogleVrApi.b();
        if (googleVrProxyB != null) {
            googleVrProxyB.pauseGvrLayout();
        }
        f();
    }

    public void quit() {
        destroy();
    }

    @Override // com.unity3d.player.f
    public void removeViewFromPlayer(android.view.View view) {
        a(this.r, view);
        boolean z = view.getParent() == null;
        boolean z2 = this.r.getParent() == this;
        if (z && z2) {
            return;
        }
        if (!z) {
            com.unity3d.player.g.Log(6, "removeViewFromPlayer: Failure removing view from hierarchy");
        }
        if (z2) {
            return;
        }
        com.unity3d.player.g.Log(6, "removeVireFromPlayer: Failure agging old view to hierarchy");
    }

    @Override // com.unity3d.player.f
    public void reportError(java.lang.String str, java.lang.String str2) {
        com.unity3d.player.g.Log(6, str + ": " + str2);
    }

    protected void reportSoftInputSelection(final int i, final int i2) {
        a(new com.unity3d.player.UnityPlayer.f() { // from class: com.unity3d.player.UnityPlayer.12
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(com.unity3d.player.UnityPlayer.this, (byte) 0);
            }

            @Override // com.unity3d.player.UnityPlayer.f
            public final void a() {
                com.unity3d.player.UnityPlayer.this.nativeSetInputSelection(i, i2);
            }
        });
    }

    protected void reportSoftInputStr(final java.lang.String str, final int i, final boolean z) {
        if (i == 1) {
            hideSoftInput();
        }
        a(new com.unity3d.player.UnityPlayer.f() { // from class: com.unity3d.player.UnityPlayer.11
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(com.unity3d.player.UnityPlayer.this, (byte) 0);
            }

            @Override // com.unity3d.player.UnityPlayer.f
            public final void a() {
                if (z) {
                    com.unity3d.player.UnityPlayer.this.nativeSoftInputCanceled();
                } else {
                    java.lang.String str2 = str;
                    if (str2 != null) {
                        com.unity3d.player.UnityPlayer.this.nativeSetInputString(str2);
                    }
                }
                if (i == 1) {
                    com.unity3d.player.UnityPlayer.this.nativeSoftInputClosed();
                }
            }
        });
    }

    protected void requestUserAuthorization(java.lang.String str) {
        if (!com.unity3d.player.j.c || str == null || str.isEmpty() || currentActivity == null) {
            return;
        }
        com.unity3d.player.j.d.a(currentActivity, str);
    }

    public void resume() {
        com.unity3d.player.GoogleARCoreApi googleARCoreApi = this.n;
        if (googleARCoreApi != null) {
            googleARCoreApi.resumeARCore();
        }
        this.f.b(false);
        com.unity3d.player.q qVar = this.u;
        if (qVar != null) {
            qVar.b();
        }
        h();
        nativeRestartActivityIndicator();
        com.unity3d.player.GoogleVrProxy googleVrProxyB = com.unity3d.player.GoogleVrApi.b();
        if (googleVrProxyB != null) {
            googleVrProxyB.b();
        }
    }

    protected void setCharacterLimit(final int i) {
        a(new java.lang.Runnable() { // from class: com.unity3d.player.UnityPlayer.8
            @Override // java.lang.Runnable
            public final void run() {
                if (com.unity3d.player.UnityPlayer.this.b != null) {
                    com.unity3d.player.UnityPlayer.this.b.a(i);
                }
            }
        });
    }

    protected void setClipboardText(java.lang.String str) {
        this.l.setPrimaryClip(android.content.ClipData.newPlainText("Text", str));
    }

    protected void setHideInputField(final boolean z) {
        a(new java.lang.Runnable() { // from class: com.unity3d.player.UnityPlayer.9
            @Override // java.lang.Runnable
            public final void run() {
                if (com.unity3d.player.UnityPlayer.this.b != null) {
                    com.unity3d.player.UnityPlayer.this.b.a(z);
                }
            }
        });
    }

    protected void setSelection(final int i, final int i2) {
        a(new java.lang.Runnable() { // from class: com.unity3d.player.UnityPlayer.10
            @Override // java.lang.Runnable
            public final void run() {
                if (com.unity3d.player.UnityPlayer.this.b != null) {
                    com.unity3d.player.UnityPlayer.this.b.a(i, i2);
                }
            }
        });
    }

    protected void setSoftInputStr(final java.lang.String str) {
        a(new java.lang.Runnable() { // from class: com.unity3d.player.UnityPlayer.7
            @Override // java.lang.Runnable
            public final void run() {
                if (com.unity3d.player.UnityPlayer.this.b == null || str == null) {
                    return;
                }
                com.unity3d.player.UnityPlayer.this.b.a(str);
            }
        });
    }

    protected void showSoftInput(final java.lang.String str, final int i, final boolean z, final boolean z2, final boolean z3, final boolean z4, final java.lang.String str2, final int i2, final boolean z5) {
        a(new java.lang.Runnable() { // from class: com.unity3d.player.UnityPlayer.4
            @Override // java.lang.Runnable
            public final void run() {
                com.unity3d.player.UnityPlayer unityPlayer = com.unity3d.player.UnityPlayer.this;
                unityPlayer.b = new com.unity3d.player.k(unityPlayer.q, this, str, i, z, z2, z3, str2, i2, z5);
                com.unity3d.player.UnityPlayer.this.b.show();
            }
        });
    }

    protected boolean showVideoPlayer(java.lang.String str, int i, int i2, int i3, boolean z, int i4, int i5) {
        if (this.u == null) {
            this.u = new com.unity3d.player.q(this);
        }
        boolean zA = this.u.a(this.q, str, i, i2, i3, z, i4, i5, new com.unity3d.player.q.a() { // from class: com.unity3d.player.UnityPlayer.15
            @Override // com.unity3d.player.q.a
            public final void a() {
                com.unity3d.player.UnityPlayer.t(com.unity3d.player.UnityPlayer.this);
            }
        });
        if (zA) {
            a(new java.lang.Runnable() { // from class: com.unity3d.player.UnityPlayer.16
                @Override // java.lang.Runnable
                public final void run() {
                    if (com.unity3d.player.UnityPlayer.this.nativeIsAutorotationOn() && (com.unity3d.player.UnityPlayer.this.q instanceof android.app.Activity)) {
                        ((android.app.Activity) com.unity3d.player.UnityPlayer.this.q).setRequestedOrientation(com.unity3d.player.UnityPlayer.this.c);
                    }
                }
            });
        }
        return zA;
    }

    protected boolean skipPermissionsDialog() {
        if (!com.unity3d.player.j.c || currentActivity == null) {
            return false;
        }
        return com.unity3d.player.j.d.a(currentActivity);
    }

    public void start() {
    }

    public void stop() {
    }

    protected void toggleGyroscopeSensor(boolean z) {
        android.hardware.SensorManager sensorManager = (android.hardware.SensorManager) this.q.getSystemService("sensor");
        android.hardware.Sensor defaultSensor = sensorManager.getDefaultSensor(11);
        if (z) {
            sensorManager.registerListener(this.o, defaultSensor, 1);
        } else {
            sensorManager.unregisterListener(this.o);
        }
    }

    public void windowFocusChanged(boolean z) {
        this.f.a(z);
        if (this.f.e()) {
            if (z && this.b != null) {
                nativeSoftInputLostFocus();
                reportSoftInputStr(null, 1, false);
            }
            if (z) {
                this.f1587a.c();
            } else {
                this.f1587a.d();
            }
            h();
        }
    }
}
