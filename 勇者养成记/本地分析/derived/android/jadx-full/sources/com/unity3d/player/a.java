package com.unity3d.player;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a {
    private static android.hardware.camera2.CameraManager b;
    private static java.lang.String[] c;
    private static java.util.concurrent.Semaphore e = new java.util.concurrent.Semaphore(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.unity3d.player.d f1619a;
    private android.hardware.camera2.CameraDevice d;
    private android.os.HandlerThread f;
    private android.os.Handler g;
    private android.graphics.Rect h;
    private android.graphics.Rect i;
    private int j;
    private int k;
    private int n;
    private int o;
    private android.util.Range q;
    private android.media.Image s;
    private android.hardware.camera2.CaptureRequest.Builder t;
    private int w;
    private android.graphics.SurfaceTexture x;
    private float l = -1.0f;
    private float m = -1.0f;
    private boolean p = false;
    private android.media.ImageReader r = null;
    private android.hardware.camera2.CameraCaptureSession u = null;
    private java.lang.Object v = new java.lang.Object();
    private android.view.Surface y = null;
    private int z = com.unity3d.player.a.EnumC0072a.c;
    private android.hardware.camera2.CameraCaptureSession.CaptureCallback A = new android.hardware.camera2.CameraCaptureSession.CaptureCallback() { // from class: com.unity3d.player.a.1
        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public final void onCaptureCompleted(android.hardware.camera2.CameraCaptureSession cameraCaptureSession, android.hardware.camera2.CaptureRequest captureRequest, android.hardware.camera2.TotalCaptureResult totalCaptureResult) {
            com.unity3d.player.a.this.a(captureRequest.getTag());
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public final void onCaptureFailed(android.hardware.camera2.CameraCaptureSession cameraCaptureSession, android.hardware.camera2.CaptureRequest captureRequest, android.hardware.camera2.CaptureFailure captureFailure) {
            com.unity3d.player.g.Log(5, "Camera2: Capture session failed " + captureRequest.getTag() + " reason " + captureFailure.getReason());
            com.unity3d.player.a.this.a(captureRequest.getTag());
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public final void onCaptureSequenceAborted(android.hardware.camera2.CameraCaptureSession cameraCaptureSession, int i) {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public final void onCaptureSequenceCompleted(android.hardware.camera2.CameraCaptureSession cameraCaptureSession, int i, long j) {
        }
    };
    private final android.hardware.camera2.CameraDevice.StateCallback B = new android.hardware.camera2.CameraDevice.StateCallback() { // from class: com.unity3d.player.a.3
        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onClosed(android.hardware.camera2.CameraDevice cameraDevice) {
            com.unity3d.player.a.e.release();
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onDisconnected(android.hardware.camera2.CameraDevice cameraDevice) {
            com.unity3d.player.g.Log(5, "Camera2: CameraDevice disconnected.");
            com.unity3d.player.a.this.a(cameraDevice);
            com.unity3d.player.a.e.release();
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onError(android.hardware.camera2.CameraDevice cameraDevice, int i) {
            com.unity3d.player.g.Log(6, "Camera2: Error opeining CameraDevice " + i);
            com.unity3d.player.a.this.a(cameraDevice);
            com.unity3d.player.a.e.release();
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onOpened(android.hardware.camera2.CameraDevice cameraDevice) {
            com.unity3d.player.a.this.d = cameraDevice;
            com.unity3d.player.a.e.release();
        }
    };
    private final android.media.ImageReader.OnImageAvailableListener C = new android.media.ImageReader.OnImageAvailableListener() { // from class: com.unity3d.player.a.4
        @Override // android.media.ImageReader.OnImageAvailableListener
        public final void onImageAvailable(android.media.ImageReader imageReader) {
            if (com.unity3d.player.a.e.tryAcquire()) {
                android.media.Image imageAcquireNextImage = imageReader.acquireNextImage();
                if (imageAcquireNextImage != null) {
                    android.media.Image.Plane[] planes = imageAcquireNextImage.getPlanes();
                    if (imageAcquireNextImage.getFormat() == 35 && planes != null && planes.length == 3) {
                        com.unity3d.player.a.this.f1619a.a(planes[0].getBuffer(), planes[1].getBuffer(), planes[2].getBuffer(), planes[0].getRowStride(), planes[1].getRowStride(), planes[1].getPixelStride());
                    } else {
                        com.unity3d.player.g.Log(6, "Camera2: Wrong image format.");
                    }
                    if (com.unity3d.player.a.this.s != null) {
                        com.unity3d.player.a.this.s.close();
                    }
                    com.unity3d.player.a.this.s = imageAcquireNextImage;
                }
                com.unity3d.player.a.e.release();
            }
        }
    };
    private final android.graphics.SurfaceTexture.OnFrameAvailableListener D = new android.graphics.SurfaceTexture.OnFrameAvailableListener() { // from class: com.unity3d.player.a.5
        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public final void onFrameAvailable(android.graphics.SurfaceTexture surfaceTexture) {
            com.unity3d.player.a.this.f1619a.a(surfaceTexture);
        }
    };

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: renamed from: com.unity3d.player.a$a, reason: collision with other inner class name */
    private static final class EnumC0072a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f1625a = 1;
        public static final int b = 2;
        public static final int c = 3;
        private static final /* synthetic */ int[] d = {f1625a, b, c};
    }

    protected a(com.unity3d.player.d dVar) {
        this.f1619a = null;
        this.f1619a = dVar;
        g();
    }

    public static int a(android.content.Context context) {
        return c(context).length;
    }

    public static int a(android.content.Context context, int i) {
        try {
            return ((java.lang.Integer) b(context).getCameraCharacteristics(c(context)[i]).get(android.hardware.camera2.CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
        } catch (android.hardware.camera2.CameraAccessException e2) {
            com.unity3d.player.g.Log(6, "Camera2: CameraAccessException " + e2);
            return 0;
        }
    }

    private static int a(android.util.Range[] rangeArr, int i) {
        int i2 = -1;
        double d = Double.MAX_VALUE;
        for (int i3 = 0; i3 < rangeArr.length; i3++) {
            int iIntValue = ((java.lang.Integer) rangeArr[i3].getLower()).intValue();
            int iIntValue2 = ((java.lang.Integer) rangeArr[i3].getUpper()).intValue();
            float f = i;
            if (f + 0.1f > iIntValue && f - 0.1f < iIntValue2) {
                return i;
            }
            double dMin = java.lang.Math.min(java.lang.Math.abs(i - iIntValue), java.lang.Math.abs(i - iIntValue2));
            if (dMin < d) {
                i2 = i3;
                d = dMin;
            }
        }
        return ((java.lang.Integer) (i > ((java.lang.Integer) rangeArr[i2].getUpper()).intValue() ? rangeArr[i2].getUpper() : rangeArr[i2].getLower())).intValue();
    }

    private static android.graphics.Rect a(android.util.Size[] sizeArr, double d, double d2) {
        double d3 = Double.MAX_VALUE;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < sizeArr.length; i3++) {
            int width = sizeArr[i3].getWidth();
            int height = sizeArr[i3].getHeight();
            double d4 = width;
            java.lang.Double.isNaN(d4);
            double dAbs = java.lang.Math.abs(java.lang.Math.log(d / d4));
            double d5 = height;
            java.lang.Double.isNaN(d5);
            double dAbs2 = dAbs + java.lang.Math.abs(java.lang.Math.log(d2 / d5));
            if (dAbs2 < d3) {
                i = width;
                i2 = height;
                d3 = dAbs2;
            }
        }
        return new android.graphics.Rect(0, 0, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(android.hardware.camera2.CameraDevice cameraDevice) {
        synchronized (this.v) {
            this.u = null;
        }
        cameraDevice.close();
        this.d = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.lang.Object obj) {
        if (obj != "Focus") {
            if (obj == "Cancel focus") {
                synchronized (this.v) {
                    if (this.u != null) {
                        j();
                    }
                }
                return;
            }
            return;
        }
        this.p = false;
        synchronized (this.v) {
            if (this.u != null) {
                try {
                    this.t.set(android.hardware.camera2.CaptureRequest.CONTROL_AF_TRIGGER, 0);
                    this.t.setTag("Regular");
                    this.u.setRepeatingRequest(this.t.build(), this.A, this.g);
                } catch (android.hardware.camera2.CameraAccessException e2) {
                    com.unity3d.player.g.Log(6, "Camera2: CameraAccessException " + e2);
                }
            }
        }
    }

    private static android.util.Size[] a(android.hardware.camera2.CameraCharacteristics cameraCharacteristics) {
        java.lang.String str;
        android.hardware.camera2.params.StreamConfigurationMap streamConfigurationMap = (android.hardware.camera2.params.StreamConfigurationMap) cameraCharacteristics.get(android.hardware.camera2.CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap == null) {
            str = "Camera2: configuration map is not available.";
        } else {
            android.util.Size[] outputSizes = streamConfigurationMap.getOutputSizes(35);
            if (outputSizes != null && outputSizes.length != 0) {
                return outputSizes;
            }
            str = "Camera2: output sizes for YUV_420_888 format are not avialable.";
        }
        com.unity3d.player.g.Log(6, str);
        return null;
    }

    private static android.hardware.camera2.CameraManager b(android.content.Context context) {
        if (b == null) {
            b = (android.hardware.camera2.CameraManager) context.getSystemService("camera");
        }
        return b;
    }

    private void b(android.hardware.camera2.CameraCharacteristics cameraCharacteristics) {
        this.k = ((java.lang.Integer) cameraCharacteristics.get(android.hardware.camera2.CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue();
        if (this.k > 0) {
            this.i = (android.graphics.Rect) cameraCharacteristics.get(android.hardware.camera2.CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
            float fWidth = this.i.width() / this.i.height();
            float fWidth2 = this.h.width() / this.h.height();
            if (fWidth2 > fWidth) {
                this.n = 0;
                this.o = (int) ((this.i.height() - (this.i.width() / fWidth2)) / 2.0f);
            } else {
                this.o = 0;
                this.n = (int) ((this.i.width() - (this.i.height() * fWidth2)) / 2.0f);
            }
            this.j = java.lang.Math.min(this.i.width(), this.i.height()) / 20;
        }
    }

    public static boolean b(android.content.Context context, int i) {
        try {
            return ((java.lang.Integer) b(context).getCameraCharacteristics(c(context)[i]).get(android.hardware.camera2.CameraCharacteristics.LENS_FACING)).intValue() == 0;
        } catch (android.hardware.camera2.CameraAccessException e2) {
            com.unity3d.player.g.Log(6, "Camera2: CameraAccessException " + e2);
            return false;
        }
    }

    public static boolean c(android.content.Context context, int i) {
        try {
            return ((java.lang.Integer) b(context).getCameraCharacteristics(c(context)[i]).get(android.hardware.camera2.CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue() > 0;
        } catch (android.hardware.camera2.CameraAccessException e2) {
            com.unity3d.player.g.Log(6, "Camera2: CameraAccessException " + e2);
            return false;
        }
    }

    private static java.lang.String[] c(android.content.Context context) {
        if (c == null) {
            try {
                c = b(context).getCameraIdList();
            } catch (android.hardware.camera2.CameraAccessException e2) {
                com.unity3d.player.g.Log(6, "Camera2: CameraAccessException " + e2);
                c = new java.lang.String[0];
            }
        }
        return c;
    }

    public static int[] d(android.content.Context context, int i) {
        try {
            android.util.Size[] sizeArrA = a(b(context).getCameraCharacteristics(c(context)[i]));
            if (sizeArrA == null) {
                return null;
            }
            int[] iArr = new int[sizeArrA.length * 2];
            for (int i2 = 0; i2 < sizeArrA.length; i2++) {
                int i3 = i2 * 2;
                iArr[i3] = sizeArrA[i2].getWidth();
                iArr[i3 + 1] = sizeArrA[i2].getHeight();
            }
            return iArr;
        } catch (android.hardware.camera2.CameraAccessException e2) {
            com.unity3d.player.g.Log(6, "Camera2: CameraAccessException " + e2);
            return null;
        }
    }

    private void g() {
        this.f = new android.os.HandlerThread("CameraBackground");
        this.f.start();
        this.g = new android.os.Handler(this.f.getLooper());
    }

    private void h() {
        this.f.quit();
        try {
            this.f.join(4000L);
            this.f = null;
            this.g = null;
        } catch (java.lang.InterruptedException e2) {
            this.f.interrupt();
            com.unity3d.player.g.Log(6, "Camera2: Interrupted while waiting for the background thread to finish " + e2);
        }
    }

    private void i() {
        try {
            if (!e.tryAcquire(4L, java.util.concurrent.TimeUnit.SECONDS)) {
                com.unity3d.player.g.Log(5, "Camera2: Timeout waiting to lock camera for closing.");
                return;
            }
            this.d.close();
            try {
                if (!e.tryAcquire(4L, java.util.concurrent.TimeUnit.SECONDS)) {
                    com.unity3d.player.g.Log(5, "Camera2: Timeout waiting to close camera.");
                }
            } catch (java.lang.InterruptedException e2) {
                com.unity3d.player.g.Log(6, "Camera2: Interrupted while waiting to close camera " + e2);
            }
            this.d = null;
            e.release();
        } catch (java.lang.InterruptedException e3) {
            com.unity3d.player.g.Log(6, "Camera2: Interrupted while trying to lock camera for closing " + e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        try {
            if (this.k != 0 && this.l >= 0.0f && this.l <= 1.0f && this.m >= 0.0f && this.m <= 1.0f) {
                this.p = true;
                int iWidth = (int) (((this.i.width() - (this.n * 2)) * this.l) + this.n);
                double dHeight = this.i.height() - (this.o * 2);
                double d = this.m;
                java.lang.Double.isNaN(d);
                java.lang.Double.isNaN(dHeight);
                double d2 = dHeight * (1.0d - d);
                double d3 = this.o;
                java.lang.Double.isNaN(d3);
                this.t.set(android.hardware.camera2.CaptureRequest.CONTROL_AF_REGIONS, new android.hardware.camera2.params.MeteringRectangle[]{new android.hardware.camera2.params.MeteringRectangle(java.lang.Math.max(this.j + 1, java.lang.Math.min(iWidth, (this.i.width() - this.j) - 1)) - this.j, java.lang.Math.max(this.j + 1, java.lang.Math.min((int) (d2 + d3), (this.i.height() - this.j) - 1)) - this.j, this.j * 2, this.j * 2, 999)});
                this.t.set(android.hardware.camera2.CaptureRequest.CONTROL_AF_MODE, 1);
                this.t.set(android.hardware.camera2.CaptureRequest.CONTROL_AF_TRIGGER, 1);
                this.t.setTag("Focus");
                this.u.capture(this.t.build(), this.A, this.g);
                return;
            }
            this.t.set(android.hardware.camera2.CaptureRequest.CONTROL_AF_MODE, 4);
            this.t.setTag("Regular");
            if (this.u != null) {
                this.u.setRepeatingRequest(this.t.build(), this.A, this.g);
            }
        } catch (android.hardware.camera2.CameraAccessException e2) {
            com.unity3d.player.g.Log(6, "Camera2: CameraAccessException " + e2);
        }
    }

    private void k() {
        try {
            if (this.u != null) {
                this.u.stopRepeating();
                this.t.set(android.hardware.camera2.CaptureRequest.CONTROL_AF_TRIGGER, 2);
                this.t.set(android.hardware.camera2.CaptureRequest.CONTROL_AF_MODE, 0);
                this.t.setTag("Cancel focus");
                this.u.capture(this.t.build(), this.A, this.g);
            }
        } catch (android.hardware.camera2.CameraAccessException e2) {
            com.unity3d.player.g.Log(6, "Camera2: CameraAccessException " + e2);
        }
    }

    public final android.graphics.Rect a() {
        return this.h;
    }

    public final boolean a(float f, float f2) {
        if (this.k <= 0) {
            return false;
        }
        if (this.p) {
            com.unity3d.player.g.Log(5, "Camera2: Setting manual focus point already started.");
            return false;
        }
        this.l = f;
        this.m = f2;
        synchronized (this.v) {
            if (this.u != null && this.z != com.unity3d.player.a.EnumC0072a.b) {
                k();
            }
        }
        return true;
    }

    public final boolean a(android.content.Context context, int i, int i2, int i3, int i4, int i5) {
        try {
            android.hardware.camera2.CameraCharacteristics cameraCharacteristics = b.getCameraCharacteristics(c(context)[i]);
            if (((java.lang.Integer) cameraCharacteristics.get(android.hardware.camera2.CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)).intValue() == 2) {
                com.unity3d.player.g.Log(5, "Camera2: only LEGACY hardware level is supported.");
                return false;
            }
            android.util.Size[] sizeArrA = a(cameraCharacteristics);
            if (sizeArrA != null && sizeArrA.length != 0) {
                this.h = a(sizeArrA, i2, i3);
                android.util.Range[] rangeArr = (android.util.Range[]) cameraCharacteristics.get(android.hardware.camera2.CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
                if (rangeArr == null || rangeArr.length == 0) {
                    com.unity3d.player.g.Log(6, "Camera2: target FPS ranges are not avialable.");
                } else {
                    int iA = a(rangeArr, i4);
                    this.q = new android.util.Range(java.lang.Integer.valueOf(iA), java.lang.Integer.valueOf(iA));
                    try {
                        if (!e.tryAcquire(4L, java.util.concurrent.TimeUnit.SECONDS)) {
                            com.unity3d.player.g.Log(5, "Camera2: Timeout waiting to lock camera for opening.");
                            return false;
                        }
                        try {
                            b.openCamera(c(context)[i], this.B, this.g);
                            try {
                                if (!e.tryAcquire(4L, java.util.concurrent.TimeUnit.SECONDS)) {
                                    com.unity3d.player.g.Log(5, "Camera2: Timeout waiting to open camera.");
                                    return false;
                                }
                                e.release();
                                this.w = i5;
                                b(cameraCharacteristics);
                                return this.d != null;
                            } catch (java.lang.InterruptedException e2) {
                                com.unity3d.player.g.Log(6, "Camera2: Interrupted while waiting to open camera " + e2);
                            }
                        } catch (android.hardware.camera2.CameraAccessException e3) {
                            com.unity3d.player.g.Log(6, "Camera2: CameraAccessException " + e3);
                            e.release();
                            return false;
                        }
                    } catch (java.lang.InterruptedException e4) {
                        com.unity3d.player.g.Log(6, "Camera2: Interrupted while trying to lock camera for opening " + e4);
                        return false;
                    }
                }
            }
            return false;
        } catch (android.hardware.camera2.CameraAccessException e5) {
            com.unity3d.player.g.Log(6, "Camera2: CameraAccessException " + e5);
            return false;
        }
    }

    public final void b() {
        if (this.d != null) {
            e();
            i();
            this.A = null;
            this.y = null;
            this.x = null;
            android.media.Image image = this.s;
            if (image != null) {
                image.close();
                this.s = null;
            }
            android.media.ImageReader imageReader = this.r;
            if (imageReader != null) {
                imageReader.close();
                this.r = null;
            }
        }
        h();
    }

    public final void c() {
        if (this.r == null) {
            this.r = android.media.ImageReader.newInstance(this.h.width(), this.h.height(), 35, 2);
            this.r.setOnImageAvailableListener(this.C, this.g);
            this.s = null;
            int i = this.w;
            if (i != 0) {
                this.x = new android.graphics.SurfaceTexture(i);
                this.x.setDefaultBufferSize(this.h.width(), this.h.height());
                this.x.setOnFrameAvailableListener(this.D, this.g);
                this.y = new android.view.Surface(this.x);
            }
        }
        try {
            if (this.u == null) {
                this.d.createCaptureSession(java.util.Arrays.asList(this.y != null ? new android.view.Surface[]{this.y, this.r.getSurface()} : new android.view.Surface[]{this.r.getSurface()}), new android.hardware.camera2.CameraCaptureSession.StateCallback() { // from class: com.unity3d.player.a.2
                    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
                    public final void onConfigureFailed(android.hardware.camera2.CameraCaptureSession cameraCaptureSession) {
                        com.unity3d.player.g.Log(6, "Camera2: CaptureSession configuration failed.");
                    }

                    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
                    public final void onConfigured(android.hardware.camera2.CameraCaptureSession cameraCaptureSession) {
                        if (com.unity3d.player.a.this.d == null) {
                            return;
                        }
                        synchronized (com.unity3d.player.a.this.v) {
                            com.unity3d.player.a.this.u = cameraCaptureSession;
                            try {
                                com.unity3d.player.a.this.t = com.unity3d.player.a.this.d.createCaptureRequest(1);
                                if (com.unity3d.player.a.this.y != null) {
                                    com.unity3d.player.a.this.t.addTarget(com.unity3d.player.a.this.y);
                                }
                                com.unity3d.player.a.this.t.addTarget(com.unity3d.player.a.this.r.getSurface());
                                com.unity3d.player.a.this.t.set(android.hardware.camera2.CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, com.unity3d.player.a.this.q);
                                com.unity3d.player.a.this.j();
                            } catch (android.hardware.camera2.CameraAccessException e2) {
                                com.unity3d.player.g.Log(6, "Camera2: CameraAccessException " + e2);
                            }
                        }
                    }
                }, this.g);
            } else if (this.z == com.unity3d.player.a.EnumC0072a.b) {
                this.u.setRepeatingRequest(this.t.build(), this.A, this.g);
            }
            this.z = com.unity3d.player.a.EnumC0072a.f1625a;
        } catch (android.hardware.camera2.CameraAccessException e2) {
            com.unity3d.player.g.Log(6, "Camera2: CameraAccessException " + e2);
        }
    }

    public final void d() {
        synchronized (this.v) {
            if (this.u != null) {
                try {
                    this.u.stopRepeating();
                    this.z = com.unity3d.player.a.EnumC0072a.b;
                } catch (android.hardware.camera2.CameraAccessException e2) {
                    com.unity3d.player.g.Log(6, "Camera2: CameraAccessException " + e2);
                }
            }
        }
    }

    public final void e() {
        synchronized (this.v) {
            if (this.u != null) {
                try {
                    this.u.abortCaptures();
                } catch (android.hardware.camera2.CameraAccessException e2) {
                    com.unity3d.player.g.Log(6, "Camera2: CameraAccessException " + e2);
                }
                this.u.close();
                this.u = null;
                this.z = com.unity3d.player.a.EnumC0072a.c;
            }
        }
    }
}
