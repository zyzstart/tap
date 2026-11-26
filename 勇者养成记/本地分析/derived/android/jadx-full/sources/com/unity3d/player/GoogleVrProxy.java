package com.unity3d.player;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class GoogleVrProxy extends com.unity3d.player.c implements com.unity3d.player.GoogleVrVideo {
    private boolean f;
    private boolean g;
    private java.lang.Runnable h;
    private java.util.Vector i;
    private android.view.SurfaceView j;
    private com.unity3d.player.GoogleVrProxy.a k;
    private java.lang.Thread l;
    private android.os.Handler m;

    class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f1583a = false;
        public boolean b = false;
        public boolean c = false;
        public boolean d = false;
        public boolean e = true;
        public boolean f = false;

        a() {
        }

        public final boolean a() {
            return this.f1583a && this.b;
        }

        public final void b() {
            this.f1583a = false;
            this.b = false;
            this.d = false;
            this.e = true;
            this.f = false;
        }
    }

    public GoogleVrProxy(com.unity3d.player.f fVar) {
        super("Google VR", fVar);
        this.f = false;
        this.g = false;
        this.h = null;
        this.i = new java.util.Vector();
        this.j = null;
        this.k = new com.unity3d.player.GoogleVrProxy.a();
        this.l = null;
        this.m = new android.os.Handler(android.os.Looper.getMainLooper()) { // from class: com.unity3d.player.GoogleVrProxy.1
            @Override // android.os.Handler
            public final void handleMessage(android.os.Message message) {
                if (message.what != 135711) {
                    super.handleMessage(message);
                }
                switch (message.arg1) {
                    case 2147483645:
                        java.util.Iterator it = com.unity3d.player.GoogleVrProxy.this.i.iterator();
                        while (it.hasNext()) {
                            ((com.unity3d.player.GoogleVrVideo.GoogleVrVideoCallbacks) it.next()).onFrameAvailable();
                        }
                        break;
                    case 2147483646:
                        android.view.Surface surface = (android.view.Surface) message.obj;
                        java.util.Iterator it2 = com.unity3d.player.GoogleVrProxy.this.i.iterator();
                        while (it2.hasNext()) {
                            ((com.unity3d.player.GoogleVrVideo.GoogleVrVideoCallbacks) it2.next()).onSurfaceAvailable(surface);
                        }
                        break;
                    default:
                        super.handleMessage(message);
                        break;
                }
            }
        };
        initVrJni();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        this.k.d = z;
    }

    private static boolean a(int i) {
        return android.os.Build.VERSION.SDK_INT >= i;
    }

    private boolean a(java.lang.ClassLoader classLoader) {
        try {
            java.lang.Class<?> clsLoadClass = classLoader.loadClass("com.unity3d.unitygvr.GoogleVR");
            com.unity3d.player.o oVar = new com.unity3d.player.o(clsLoadClass, clsLoadClass.getConstructor(new java.lang.Class[0]).newInstance(new java.lang.Object[0]));
            oVar.a("initialize", new java.lang.Class[]{android.app.Activity.class, android.content.Context.class, android.view.SurfaceView.class, java.lang.Boolean.TYPE, android.os.Handler.class});
            oVar.a("deinitialize", new java.lang.Class[0]);
            oVar.a("load", new java.lang.Class[]{java.lang.Boolean.TYPE, java.lang.Boolean.TYPE, java.lang.Boolean.TYPE, java.lang.Boolean.TYPE, java.lang.Boolean.TYPE, java.lang.Runnable.class});
            oVar.a("enable", new java.lang.Class[]{java.lang.Boolean.TYPE});
            oVar.a("unload", new java.lang.Class[0]);
            oVar.a("pause", new java.lang.Class[0]);
            oVar.a("resume", new java.lang.Class[0]);
            oVar.a("getGvrLayout", new java.lang.Class[0]);
            oVar.a("getVideoSurfaceId", new java.lang.Class[0]);
            oVar.a("getVideoSurface", new java.lang.Class[0]);
            this.f1628a = oVar;
            return true;
        } catch (java.lang.Exception e) {
            reportError("Exception initializing GoogleVR from Unity library. " + e.getLocalizedMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        return this.k.d;
    }

    private void e() {
        android.app.Activity activity = (android.app.Activity) this.c;
        if (!this.g || this.k.f || activity == null) {
            return;
        }
        this.k.f = true;
        android.content.Intent intent = new android.content.Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        intent.setFlags(268435456);
        activity.startActivity(intent);
    }

    private final native void initVrJni();

    private final native boolean isQuiting();

    private final native void setVrVideoTransform(float[][] fArr);

    public final void a(android.content.Intent intent) {
        if (intent == null || !intent.getBooleanExtra("android.intent.extra.VR_LAUNCH", false)) {
            return;
        }
        this.g = true;
    }

    public final boolean a() {
        return this.k.f1583a;
    }

    public final boolean a(android.app.Activity activity, android.content.Context context, android.view.SurfaceView surfaceView, java.lang.Runnable runnable) {
        java.lang.String str;
        boolean zBooleanValue;
        if (activity == null || context == null || surfaceView == null || runnable == null) {
            str = "Invalid parameters passed to Google VR initiialization.";
        } else {
            this.k.b();
            this.c = context;
            this.h = runnable;
            if (!a(19)) {
                str = "Google VR requires a device that supports an api version of 19 (KitKat) or better.";
            } else if (this.g && !a(24)) {
                str = "Daydream requires a device that supports an api version of 24 (Nougat) or better.";
            } else {
                if (!a(com.unity3d.player.UnityPlayer.class.getClassLoader())) {
                    return false;
                }
                try {
                    zBooleanValue = ((java.lang.Boolean) this.f1628a.a("initialize", activity, context, surfaceView, java.lang.Boolean.valueOf(this.g), this.m)).booleanValue();
                } catch (java.lang.Exception e) {
                    reportError("Exception while trying to intialize Unity Google VR Library. " + e.getLocalizedMessage());
                    zBooleanValue = false;
                }
                if (zBooleanValue) {
                    this.j = surfaceView;
                    this.k.f1583a = true;
                    this.d = "";
                    return true;
                }
                str = "Unable to initialize GoogleVR library.";
            }
        }
        reportError(str);
        return false;
    }

    public final void b() {
        resumeGvrLayout();
    }

    public final void c() {
        android.view.SurfaceView surfaceView = this.j;
        if (surfaceView != null) {
            surfaceView.getHolder().setSizeFromLayout();
        }
    }

    @Override // com.unity3d.player.GoogleVrVideo
    public void deregisterGoogleVrVideoListener(com.unity3d.player.GoogleVrVideo.GoogleVrVideoCallbacks googleVrVideoCallbacks) {
        if (this.i.contains(googleVrVideoCallbacks)) {
            googleVrVideoCallbacks.onSurfaceUnavailable();
            this.i.remove(googleVrVideoCallbacks);
        }
    }

    protected java.lang.Object getVideoSurface() {
        if (d() && !this.k.e) {
            try {
                return this.f1628a.a("getVideoSurface", new java.lang.Object[0]);
            } catch (java.lang.Exception e) {
                reportError("Exception caught while Getting GoogleVR Video Surface. " + e.getLocalizedMessage());
            }
        }
        return null;
    }

    protected int getVideoSurfaceId() {
        if (d() && !this.k.e) {
            try {
                return ((java.lang.Integer) this.f1628a.a("getVideoSurfaceId", new java.lang.Object[0])).intValue();
            } catch (java.lang.Exception e) {
                reportError("Exception caught while getting Video Surface ID from GoogleVR. " + e.getLocalizedMessage());
            }
        }
        return -1;
    }

    protected long loadGoogleVr(final boolean z, final boolean z2, final boolean z3, final boolean z4, final boolean z5) {
        if (!this.k.f1583a) {
            return 0L;
        }
        final java.util.concurrent.atomic.AtomicLong atomicLong = new java.util.concurrent.atomic.AtomicLong(0L);
        this.d = (z || z2) ? "Daydream" : "Cardboard";
        if (!runOnUiThreadWithSync(new java.lang.Runnable() { // from class: com.unity3d.player.GoogleVrProxy.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    atomicLong.set(((java.lang.Long) com.unity3d.player.GoogleVrProxy.this.f1628a.a("load", java.lang.Boolean.valueOf(z), java.lang.Boolean.valueOf(z2), java.lang.Boolean.valueOf(z3), java.lang.Boolean.valueOf(z4), java.lang.Boolean.valueOf(z5), com.unity3d.player.GoogleVrProxy.this.h)).longValue());
                    com.unity3d.player.GoogleVrProxy.this.k.b = true;
                } catch (java.lang.Exception e) {
                    com.unity3d.player.GoogleVrProxy.this.reportError("Exception caught while loading GoogleVR. " + e.getLocalizedMessage());
                    atomicLong.set(0L);
                }
            }
        }) || atomicLong.longValue() == 0) {
            reportError("Google VR had a fatal issue while loading. VR will not be available.");
        }
        return atomicLong.longValue();
    }

    protected void pauseGvrLayout() {
        if (this.k.a() && !this.k.e) {
            if (d()) {
                java.util.Iterator it = this.i.iterator();
                while (it.hasNext()) {
                    ((com.unity3d.player.GoogleVrVideo.GoogleVrVideoCallbacks) it.next()).onSurfaceUnavailable();
                }
            }
            if (this.f1628a != null) {
                this.f1628a.a("pause", new java.lang.Object[0]);
            }
            this.k.e = true;
        }
    }

    @Override // com.unity3d.player.GoogleVrVideo
    public void registerGoogleVrVideoListener(com.unity3d.player.GoogleVrVideo.GoogleVrVideoCallbacks googleVrVideoCallbacks) {
        if (this.i.contains(googleVrVideoCallbacks)) {
            return;
        }
        this.i.add(googleVrVideoCallbacks);
        android.view.Surface surface = (android.view.Surface) getVideoSurface();
        if (surface != null) {
            googleVrVideoCallbacks.onSurfaceAvailable(surface);
        }
    }

    protected void resumeGvrLayout() {
        if (this.k.a() && this.k.e) {
            if (this.f1628a != null) {
                this.f1628a.a("resume", new java.lang.Object[0]);
            }
            this.k.e = false;
        }
    }

    protected void setGoogleVrModeEnabled(final boolean z) {
        if (!this.k.a() || this.b == null || this.c == null) {
            return;
        }
        if (!z && isQuiting()) {
            e();
        }
        runOnUiThread(new java.lang.Runnable() { // from class: com.unity3d.player.GoogleVrProxy.3
            @Override // java.lang.Runnable
            public final void run() {
                if (z == com.unity3d.player.GoogleVrProxy.this.d()) {
                    return;
                }
                try {
                    if (z && !com.unity3d.player.GoogleVrProxy.this.d()) {
                        if (com.unity3d.player.GoogleVrProxy.this.f1628a != null && com.unity3d.player.GoogleVrProxy.this.b != null && !com.unity3d.player.GoogleVrProxy.this.b.addViewToPlayer((android.view.View) com.unity3d.player.GoogleVrProxy.this.f1628a.a("getGvrLayout", new java.lang.Object[0]), true)) {
                            com.unity3d.player.GoogleVrProxy.this.reportError("Unable to add Google VR to view hierarchy.");
                            return;
                        }
                        if (com.unity3d.player.GoogleVrProxy.this.f1628a != null) {
                            com.unity3d.player.GoogleVrProxy.this.f1628a.a("enable", true);
                        }
                        com.unity3d.player.GoogleVrProxy.this.a(true);
                        return;
                    }
                    if (z || !com.unity3d.player.GoogleVrProxy.this.d()) {
                        return;
                    }
                    com.unity3d.player.GoogleVrProxy.this.a(false);
                    if (com.unity3d.player.GoogleVrProxy.this.f1628a != null) {
                        com.unity3d.player.GoogleVrProxy.this.f1628a.a("enable", false);
                    }
                    if (com.unity3d.player.GoogleVrProxy.this.f1628a == null || com.unity3d.player.GoogleVrProxy.this.b == null) {
                        return;
                    }
                    com.unity3d.player.GoogleVrProxy.this.b.removeViewFromPlayer((android.view.View) com.unity3d.player.GoogleVrProxy.this.f1628a.a("getGvrLayout", new java.lang.Object[0]));
                } catch (java.lang.Exception e) {
                    com.unity3d.player.GoogleVrProxy.this.reportError("Exception enabling Google VR on UI Thread. " + e.getLocalizedMessage());
                }
            }
        });
    }

    @Override // com.unity3d.player.GoogleVrVideo
    public void setVideoLocationTransform(float[] fArr) {
        float[][] fArr2 = (float[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) float.class, 4, 4);
        for (int i = 0; i < 4; i++) {
            for (int i2 = 0; i2 < 4; i2++) {
                fArr2[i][i2] = fArr[(i * 4) + i2];
            }
        }
        setVrVideoTransform(fArr2);
    }

    protected void unloadGoogleVr() {
        if (this.k.d) {
            setGoogleVrModeEnabled(false);
        }
        if (this.k.c) {
            this.k.c = false;
        }
        this.j = null;
        runOnUiThread(new java.lang.Runnable() { // from class: com.unity3d.player.GoogleVrProxy.4
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (com.unity3d.player.GoogleVrProxy.this.f1628a != null) {
                        com.unity3d.player.GoogleVrProxy.this.f1628a.a("unload", new java.lang.Object[0]);
                        com.unity3d.player.GoogleVrProxy.this.f1628a.a("deinitialize", new java.lang.Object[0]);
                        com.unity3d.player.GoogleVrProxy.this.f1628a = null;
                    }
                    com.unity3d.player.GoogleVrProxy.this.k.b = false;
                } catch (java.lang.Exception e) {
                    com.unity3d.player.GoogleVrProxy.this.reportError("Exception unloading Google VR on UI Thread. " + e.getLocalizedMessage());
                }
            }
        });
    }
}
