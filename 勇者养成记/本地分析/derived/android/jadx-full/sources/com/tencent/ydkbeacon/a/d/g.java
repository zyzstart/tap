package com.tencent.ydkbeacon.a.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.nio.channels.FileChannel f1196a;
    private java.nio.MappedByteBuffer c;
    private long d;
    private java.lang.Runnable e;
    private boolean g;
    private boolean h;
    private org.json.JSONObject b = new org.json.JSONObject();
    private final java.lang.Object f = new java.lang.Object();

    private g(java.io.File file) throws java.io.IOException {
        java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(file, "rw");
        this.f1196a = randomAccessFile.getChannel();
        this.d = randomAccessFile.length();
        com.tencent.ydkbeacon.a.e.c.a("[properties]", "file size: " + this.d, new java.lang.Object[0]);
        f();
    }

    public static com.tencent.ydkbeacon.a.d.g a(android.content.Context context, java.lang.String str) {
        java.io.File file = new java.io.File(context.getFilesDir(), "beacon");
        if (!(!file.exists() ? file.mkdirs() : true)) {
            com.tencent.ydkbeacon.a.e.e.a("mkdir " + file.getName() + " exception!");
        }
        return new com.tencent.ydkbeacon.a.d.g(new java.io.File(file, str + "ydkbeacon_V1"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        if (j > 2097152) {
            throw new java.lang.IllegalArgumentException("file size to reach maximum!");
        }
        this.c.rewind();
        this.c = this.f1196a.map(java.nio.channels.FileChannel.MapMode.READ_WRITE, 0L, j);
    }

    private void a(java.lang.Runnable runnable) {
        com.tencent.ydkbeacon.a.b.a.a().a(new com.tencent.ydkbeacon.a.d.f(this, runnable));
    }

    private byte[] a(java.nio.ByteBuffer byteBuffer) {
        int i = byteBuffer.getInt(0);
        if (i <= 1 || i > 2097152 || byteBuffer.capacity() <= 10) {
            return null;
        }
        byteBuffer.position(10);
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr, 0, i);
        return bArr;
    }

    public static byte[] a(byte[] bArr) {
        return com.tencent.ydkbeacon.base.net.c.c.b(3, "BEACONDEFAULTAES", bArr);
    }

    private static byte[] a(byte[] bArr, java.lang.String str) {
        try {
            return com.tencent.ydkbeacon.base.net.c.c.a(3, str, bArr);
        } catch (java.lang.Throwable th) {
            com.tencent.ydkbeacon.a.e.c.a(th);
            com.tencent.ydkbeacon.a.b.d.b().a("513", "unEncrypt error: key=" + str, th);
            return null;
        }
    }

    public static byte[] b(byte[] bArr) {
        byte[] bArrA = a(bArr, "BEACONDEFAULTAES");
        if (bArrA != null) {
            return bArrA;
        }
        byte[] bArrA2 = a(bArr, com.tencent.ydkbeacon.a.c.f.p().e());
        return bArrA2 != null ? bArrA2 : a(bArr, "");
    }

    private java.lang.Object c(@android.support.annotation.NonNull java.lang.String str) {
        java.lang.Object obj = null;
        try {
            synchronized (this.f) {
                obj = this.b.get(str);
            }
        } catch (java.lang.Exception unused) {
            com.tencent.ydkbeacon.a.e.c.a("[properties]", "current jsonObject not exist key: " + str, new java.lang.Object[0]);
        }
        return obj;
    }

    private boolean d() {
        if (!this.g) {
            return false;
        }
        com.tencent.ydkbeacon.a.e.c.a("[properties]", "File is close!", new java.lang.Object[0]);
        return true;
    }

    private java.lang.Runnable e() {
        if (this.e == null) {
            this.e = new com.tencent.ydkbeacon.a.d.e(this);
        }
        return this.e;
    }

    private void f() throws java.io.IOException {
        if (this.d <= 10) {
            this.h = true;
            this.d = 4L;
        }
        java.nio.MappedByteBuffer map = this.f1196a.map(java.nio.channels.FileChannel.MapMode.READ_WRITE, 0L, this.d);
        this.c = map;
        map.rewind();
        if (this.h) {
            this.c.putInt(0, 1);
            a(e());
            return;
        }
        byte[] bArrA = a(this.c);
        if (bArrA == null) {
            return;
        }
        try {
            this.b = new org.json.JSONObject(new java.lang.String(b(bArrA), "ISO8859-1"));
        } catch (java.lang.Exception e) {
            com.tencent.ydkbeacon.a.e.c.a("[properties]", "init error" + e.getMessage(), new java.lang.Object[0]);
            com.tencent.ydkbeacon.a.b.d.b().a("504", "[properties] init error! msg: " + e.getMessage() + ". file size: " + this.d, e);
        }
        com.tencent.ydkbeacon.a.e.c.a("[properties]", "init json: " + this.b.toString(), new java.lang.Object[0]);
    }

    public synchronized java.lang.Object a(@android.support.annotation.NonNull java.lang.String str, @android.support.annotation.NonNull java.lang.Object obj) {
        if (d()) {
            return obj;
        }
        java.lang.Object objC = c(str);
        if (objC == null) {
            objC = obj;
        }
        return objC;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized java.util.Set a(@android.support.annotation.NonNull java.lang.String str, @android.support.annotation.Nullable java.util.Set set) {
        org.json.JSONObject jSONObject;
        if (d()) {
            return set;
        }
        try {
            java.util.HashSet hashSet = new java.util.HashSet();
            synchronized (this.f) {
                jSONObject = this.b.getJSONObject(str);
            }
            if (jSONObject != null) {
                java.util.Iterator<java.lang.String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    hashSet.add(jSONObject.get(itKeys.next()));
                }
            }
            if (!hashSet.isEmpty()) {
                set = hashSet;
            }
        } catch (org.json.JSONException e) {
            com.tencent.ydkbeacon.a.b.d.b().a("504", "[properties] JSON getSet error!", e);
            com.tencent.ydkbeacon.a.e.c.b("[properties] JSON get error!" + e.getMessage(), new java.lang.Object[0]);
        }
        return set;
    }

    public synchronized void a() {
        this.b = new org.json.JSONObject();
        a(e());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean a(java.lang.String str) {
        synchronized (this.f) {
            java.util.Iterator<java.lang.String> itKeys = this.b.keys();
            if (itKeys != null) {
                while (itKeys.hasNext()) {
                    if (str.equals(itKeys.next())) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public java.util.Map b() {
        synchronized (this.f) {
            if (this.b == null) {
                return null;
            }
            java.util.Iterator<java.lang.String> itKeys = this.b.keys();
            java.util.HashMap map = new java.util.HashMap();
            while (itKeys.hasNext()) {
                java.lang.String next = itKeys.next();
                try {
                    map.put(next, this.b.get(next));
                } catch (org.json.JSONException e) {
                    com.tencent.ydkbeacon.a.e.c.a(e);
                }
            }
            return map;
        }
    }

    public synchronized void b(java.lang.String str) {
        synchronized (this.f) {
            this.b.remove(str);
        }
        a(e());
    }

    public synchronized void b(@android.support.annotation.NonNull java.lang.String str, @android.support.annotation.NonNull java.lang.Object obj) {
        if (d()) {
            return;
        }
        try {
            java.lang.Object objC = c(str);
            if (objC == null || !objC.equals(obj)) {
                if (obj instanceof java.lang.String) {
                    if (android.text.TextUtils.isEmpty((java.lang.String) obj)) {
                        return;
                    }
                    if (!com.tencent.ydkbeacon.a.e.f.b((java.lang.String) obj)) {
                        com.tencent.ydkbeacon.a.e.c.b("[properties] JSON put value not english ! !", new java.lang.Object[0]);
                        return;
                    }
                }
                synchronized (this.f) {
                    this.b.put(str, obj);
                }
                a(e());
            }
        } catch (java.lang.Exception e) {
            com.tencent.ydkbeacon.a.b.d.b().a("504", "[properties] JSON put error!", e);
            com.tencent.ydkbeacon.a.e.c.b("[properties] JSON put error!" + e.getMessage(), new java.lang.Object[0]);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void b(@android.support.annotation.NonNull java.lang.String str, @android.support.annotation.NonNull java.util.Set set) {
        if (d()) {
            return;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            java.util.Iterator it = set.iterator();
            for (int i = 0; i < set.size(); i++) {
                if (it.hasNext()) {
                    jSONObject.put(java.lang.String.valueOf(i), it.next());
                }
            }
            b(str, jSONObject);
        } catch (org.json.JSONException e) {
            com.tencent.ydkbeacon.a.e.c.a(e);
            com.tencent.ydkbeacon.a.b.d.b().a("504", "[properties] JSON put set error!", e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0060 A[EXC_TOP_SPLITTER, PHI: r1
  0x0060: PHI (r1v5 java.nio.channels.FileLock) = (r1v4 java.nio.channels.FileLock), (r1v7 java.nio.channels.FileLock) binds: [B:19:0x005e, B:8:0x0037] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public void c() {
        synchronized (this.f) {
            java.nio.channels.FileLock fileLockLock = null;
            try {
                try {
                    fileLockLock = this.f1196a.lock();
                    this.c.clear();
                    java.nio.MappedByteBuffer map = this.f1196a.map(java.nio.channels.FileChannel.MapMode.READ_WRITE, 0L, this.f1196a.size());
                    this.c = map;
                    this.b = new org.json.JSONObject(new java.lang.String(b(a(map)), "ISO8859-1"));
                    if (fileLockLock != null) {
                        try {
                            fileLockLock.release();
                        } catch (java.io.IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (java.lang.Exception e2) {
                    if (!this.h) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("loadStoreData error: ");
                        sb.append(e2.getMessage());
                        com.tencent.ydkbeacon.a.e.c.a("[properties]", sb.toString(), new java.lang.Object[0]);
                    }
                    if (fileLockLock != null) {
                        fileLockLock.release();
                    }
                }
            } catch (java.lang.Throwable th) {
                if (fileLockLock != null) {
                    try {
                        fileLockLock.release();
                    } catch (java.io.IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        }
    }
}
