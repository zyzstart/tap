package com.tencent.ydkqmsp.sdk.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class e {
    private static final byte[] f = {51, 117, -95};
    private static final byte[] g = {38, 114, -96};
    private static final byte[] h = {20, 125, -96, 80, 13, 57, 57, -7, 36, 100};
    private static final byte[] i = {20, 125, -96, 80, 13, 57, 91, -20, 49};
    private static final byte[] j = {52, 100};
    private static final byte[] k = {20, 125, -96, 80, 96, 24, 117};
    private static final byte[][] l = {new byte[]{54, 100}, new byte[]{49, 99, -70}, new byte[]{54, 115}};
    private static com.tencent.ydkqmsp.sdk.c.e m;
    private android.content.SharedPreferences c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.util.concurrent.ConcurrentHashMap f1309a = new java.util.concurrent.ConcurrentHashMap();
    private java.util.concurrent.CopyOnWriteArrayList b = new java.util.concurrent.CopyOnWriteArrayList();
    private long d = com.tencent.ydkqmsp.sdk.app.a.getAtomCbTimeout().get();
    private int e = 0;

    class a implements java.lang.Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.ydkqmsp.sdk.c.e.this.a(false);
        }
    }

    class b implements com.tencent.ydkqmsp.sdk.b.e {
        b() {
        }

        @Override // com.tencent.ydkqmsp.sdk.b.e
        public void a(int i, org.json.JSONObject jSONObject) throws java.lang.Throwable {
            if (i != 161 || jSONObject == null) {
                return;
            }
            com.tencent.ydkqmsp.sdk.c.e.this.a(jSONObject);
        }
    }

    public interface c {
        void a(java.util.List list);
    }

    private e() throws java.lang.Throwable {
        this.c = null;
        this.c = com.tencent.ydkqmsp.sdk.app.a.getContext().getSharedPreferences(a(i), 0);
        b();
    }

    private int a(int i2, int i3) {
        return a(new android.util.Pair(java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3)));
    }

    private int a(android.util.Pair pair) {
        if (pair == null) {
            return -1;
        }
        switch (((java.lang.Integer) pair.first).intValue()) {
            case 10000:
                if (com.tencent.ydkqmsp.sdk.app.a.getAtomConnTimeOut().get() != ((java.lang.Integer) pair.second).intValue() && ((java.lang.Integer) pair.second).intValue() > 5000) {
                    com.tencent.ydkqmsp.sdk.app.a.getAtomConnTimeOut().set(((java.lang.Integer) pair.second).intValue());
                    com.tencent.ydkqmsp.sdk.f.g.a(a(k), 1, "[CB-CYC] Socket Conn TimeOut: " + com.tencent.ydkqmsp.sdk.app.a.getAtomConnTimeOut().get());
                }
                return 0;
            case 10001:
                if (com.tencent.ydkqmsp.sdk.app.a.getAtomReadTimeOut().get() != ((java.lang.Integer) pair.second).intValue() && ((java.lang.Integer) pair.second).intValue() > 5000) {
                    com.tencent.ydkqmsp.sdk.app.a.getAtomReadTimeOut().set(((java.lang.Integer) pair.second).intValue());
                    com.tencent.ydkqmsp.sdk.f.g.a(a(k), 1, "[CB-CYC] Socket Read TimeOut: " + com.tencent.ydkqmsp.sdk.app.a.getAtomReadTimeOut().get());
                }
                return 0;
            case com.unisound.client.SpeechConstants.ASR_INIT_MODE /* 10002 */:
                if (com.tencent.ydkqmsp.sdk.app.a.getAtomCbTimeout().get() != ((java.lang.Integer) pair.second).intValue() && ((java.lang.Integer) pair.second).intValue() > 3600000) {
                    com.tencent.ydkqmsp.sdk.app.a.getAtomCbTimeout().set(((java.lang.Integer) pair.second).intValue());
                    com.tencent.ydkqmsp.sdk.f.g.a(a(k), 1, "[CB-CYC] CB Ruery TimeOut : " + com.tencent.ydkqmsp.sdk.app.a.getAtomCbTimeout().get());
                }
                return 0;
            case com.unisound.client.SpeechConstants.ASR_OPT_SET_COMPILE_MAX_PRONUNCIATION /* 10003 */:
                if (com.tencent.ydkqmsp.sdk.app.a.getAtomUpdateInterval().get() != ((java.lang.Integer) pair.second).intValue() && ((java.lang.Integer) pair.second).intValue() > 3600000) {
                    com.tencent.ydkqmsp.sdk.app.a.getAtomUpdateInterval().set(((java.lang.Integer) pair.second).intValue());
                    com.tencent.ydkqmsp.sdk.f.g.a(a(k), 1, "[CB-CYC] Plugin Ruery TimeOut : " + com.tencent.ydkqmsp.sdk.app.a.getAtomUpdateInterval().get());
                }
                return 0;
            default:
                return -1;
        }
    }

    private android.util.Pair a(java.lang.String str, org.json.JSONObject jSONObject) {
        try {
            return new android.util.Pair(java.lang.Integer.valueOf(java.lang.Integer.parseInt(str)), java.lang.Integer.valueOf(jSONObject.getInt(str)));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private java.lang.String a(byte[] bArr) {
        return com.tencent.ydkqmsp.sdk.f.k.a(bArr);
    }

    private void a(int i2, int i3, int i4) {
        com.tencent.ydkqmsp.sdk.f.g.a(a(k), 1, java.lang.String.format("[CB] report: funType=%d, result=%d,  NowTaskID=%d", java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3), java.lang.Integer.valueOf(i4)));
        com.tencent.ydkqmsp.sdk.a.g gVar = new com.tencent.ydkqmsp.sdk.a.g();
        try {
            gVar.a(i2).a(i3).a(i4);
            com.tencent.ydkqmsp.sdk.a.f.a(gVar.toString(), 1);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.tencent.ydkqmsp.sdk.f.g.b(com.tencent.ydkqmsp.sdk.f.g.f1347a, 0, "onReport error!");
        }
    }

    private void a(long j2) {
        com.tencent.ydkqmsp.sdk.c.f.i().c().postDelayed(new com.tencent.ydkqmsp.sdk.c.e.a(), j2);
    }

    private void a(java.lang.String str) throws java.lang.Throwable {
        java.util.Iterator<java.lang.String> itKeys;
        java.util.LinkedList linkedList = new java.util.LinkedList();
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            if (jSONObject.getInt(a(f)) != 1) {
                return;
            }
            org.json.JSONObject jSONObject2 = jSONObject.getJSONObject(a(g));
            if (jSONObject2 != null && (itKeys = jSONObject2.keys()) != null) {
                while (itKeys.hasNext()) {
                    android.util.Pair pairA = a(itKeys.next(), jSONObject2);
                    if (pairA != null) {
                        a(pairA);
                        java.lang.Integer num = (java.lang.Integer) this.f1309a.get(pairA.first);
                        if (num == null || num.byteValue() != ((java.lang.Integer) pairA.second).intValue()) {
                            linkedList.add(pairA);
                        }
                        this.f1309a.put(pairA.first, pairA.second);
                    }
                }
            }
        } catch (java.lang.Exception e) {
            a(1002, -1, this.e);
            e.printStackTrace();
        }
        g();
        if (linkedList.isEmpty()) {
            return;
        }
        java.util.Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((com.tencent.ydkqmsp.sdk.c.e.c) it.next()).a(linkedList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(org.json.JSONObject jSONObject) throws java.lang.Throwable {
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("cb-->Result: ");
            sb.append(jSONObject);
            com.tencent.ydkqmsp.sdk.f.g.a("Task: ", 0, sb.toString());
            int iOptInt = -1;
            if (!jSONObject.isNull(a(l[0])) && !jSONObject.isNull(a(l[1])) && !jSONObject.isNull(a(l[2]))) {
                iOptInt = jSONObject.optInt(a(l[0]));
                this.e = java.lang.Integer.valueOf(jSONObject.optString(a(l[1]))).intValue();
                java.lang.String strOptString = jSONObject.optString(a(l[2]));
                if (iOptInt == 0 && strOptString != null && !strOptString.equals("")) {
                    a(strOptString);
                }
            }
            a(1001, iOptInt, this.e);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0042 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void b(byte[] bArr) throws java.lang.Throwable {
        java.io.DataInputStream dataInputStream;
        java.io.DataInputStream dataInputStream2 = null;
        try {
            dataInputStream = new java.io.DataInputStream(new java.io.ByteArrayInputStream(bArr));
            while (dataInputStream.available() != 0) {
                try {
                    try {
                        int i2 = dataInputStream.readInt();
                        int i3 = dataInputStream.readInt();
                        a(i2, i3);
                        this.f1309a.put(java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3));
                    } catch (java.io.IOException e) {
                        e = e;
                        e.printStackTrace();
                        if (dataInputStream == null) {
                            return;
                        }
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    dataInputStream2 = dataInputStream;
                    if (dataInputStream2 != null) {
                        try {
                            dataInputStream2.close();
                        } catch (java.io.IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        } catch (java.io.IOException e3) {
            e = e3;
            dataInputStream = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            if (dataInputStream2 != null) {
                dataInputStream2.close();
            }
            throw th;
        }
        try {
            dataInputStream.close();
        } catch (java.io.IOException e4) {
            e4.printStackTrace();
        }
    }

    private org.json.JSONObject c() {
        try {
            android.content.SharedPreferences.Editor editorEdit = this.c.edit();
            editorEdit.putLong(a(j), java.lang.System.currentTimeMillis());
            editorEdit.commit();
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            org.json.JSONObject jSONObjectA = com.tencent.ydkqmsp.sdk.a.d.a(1);
            if (jSONObjectA == null) {
                com.tencent.ydkqmsp.sdk.f.g.d(a(k), 0, "make query head Fail!");
            }
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put(com.tencent.ydkqmsp.sdk.a.e.a(20), 1);
            jSONObject2.put(com.tencent.ydkqmsp.sdk.a.e.a(21), 512);
            jSONObject.put(com.tencent.ydkqmsp.sdk.a.e.a(15), jSONObjectA);
            jSONObject.put(com.tencent.ydkqmsp.sdk.a.e.a(16), jSONObject2);
            return jSONObject;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static com.tencent.ydkqmsp.sdk.c.e d() {
        if (m == null) {
            synchronized (com.tencent.ydkqmsp.sdk.c.e.class) {
                if (m == null) {
                    m = new com.tencent.ydkqmsp.sdk.c.e();
                }
            }
        }
        return m;
    }

    private java.lang.String e() {
        return com.tencent.ydkqmsp.sdk.a.b.a() + java.io.File.separator + a(h);
    }

    private boolean f() {
        try {
            this.d = com.tencent.ydkqmsp.sdk.app.a.getAtomCbTimeout().get();
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis() - this.c.getLong(a(j), 0L);
            if (jCurrentTimeMillis < 0) {
                jCurrentTimeMillis = 0;
            }
            if (jCurrentTimeMillis >= com.tencent.ydkqmsp.sdk.app.a.getAtomCbTimeout().get()) {
                return true;
            }
            this.d -= jCurrentTimeMillis;
            return false;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    private void g() throws java.lang.Throwable {
        byte[] bArrH = h();
        if (bArrH != null) {
            new com.tencent.ydkqmsp.sdk.c.l().a(e(), bArrH, null, 1);
        }
    }

    /* JADX WARN: Code duplicated, block: B:55:0x0083 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:61:0x008d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:? A[SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private byte[] h() throws java.lang.Throwable {
        java.lang.Throwable th;
        java.io.DataOutputStream dataOutputStream;
        java.io.IOException e;
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.io.DataOutputStream dataOutputStream2;
        java.io.ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            try {
                dataOutputStream2 = new java.io.DataOutputStream(byteArrayOutputStream);
                try {
                    try {
                        for (java.util.Map.Entry entry : this.f1309a.entrySet()) {
                            dataOutputStream2.writeInt(((java.lang.Integer) entry.getKey()).intValue());
                            dataOutputStream2.writeInt(((java.lang.Integer) entry.getValue()).intValue());
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        try {
                            byteArrayOutputStream.close();
                        } catch (java.io.IOException e2) {
                            e2.printStackTrace();
                        }
                        try {
                            dataOutputStream2.close();
                        } catch (java.io.IOException e3) {
                            e3.printStackTrace();
                        }
                        return byteArray;
                    } catch (java.io.IOException e4) {
                        e = e4;
                        e.printStackTrace();
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (java.io.IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        if (dataOutputStream2 != null) {
                            try {
                                dataOutputStream2.close();
                            } catch (java.io.IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        return null;
                    }
                } catch (java.lang.Throwable th2) {
                    java.io.DataOutputStream dataOutputStream3 = dataOutputStream2;
                    th = th2;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    dataOutputStream = dataOutputStream3;
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (java.io.IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    if (dataOutputStream != null) {
                        throw th;
                    }
                    try {
                        dataOutputStream.close();
                        throw th;
                    } catch (java.io.IOException e8) {
                        e8.printStackTrace();
                        throw th;
                    }
                }
            } catch (java.io.IOException e9) {
                e = e9;
                dataOutputStream2 = null;
            } catch (java.lang.Throwable th3) {
                th = th3;
                dataOutputStream = null;
                byteArrayOutputStream2 = byteArrayOutputStream;
                if (byteArrayOutputStream2 != null) {
                    byteArrayOutputStream2.close();
                }
                if (dataOutputStream != null) {
                    throw th;
                }
                dataOutputStream.close();
                throw th;
            }
        } catch (java.io.IOException e10) {
            e = e10;
            byteArrayOutputStream = null;
            dataOutputStream2 = null;
        } catch (java.lang.Throwable th4) {
            th = th4;
            dataOutputStream = null;
        }
    }

    private void i() {
        try {
            a(1003, 0, this.e);
            org.json.JSONObject jSONObjectC = c();
            java.lang.String strA = a(k);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("CB: ");
            sb.append(jSONObjectC.toString());
            com.tencent.ydkqmsp.sdk.f.g.d(strA, 0, sb.toString());
            com.tencent.ydkqmsp.sdk.b.g.b().a(1, com.tencent.ydkqmsp.sdk.app.a.getAppID(), 1, jSONObjectC, new com.tencent.ydkqmsp.sdk.c.e.b());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public int a(int i2) {
        java.lang.Integer num = (java.lang.Integer) this.f1309a.get(java.lang.Integer.valueOf(i2));
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public void a() {
        if (m != null) {
            m = null;
        }
    }

    public void a(com.tencent.ydkqmsp.sdk.c.e.c cVar) {
        this.b.add(cVar);
    }

    public void a(boolean z) {
        java.lang.String strA;
        java.lang.StringBuilder sb;
        if (!com.tencent.ydkqmsp.sdk.app.a.getTaskStatus()) {
            com.tencent.ydkqmsp.sdk.f.g.a(a(k), 1, "cb Task Finish！");
            return;
        }
        try {
            com.tencent.ydkqmsp.sdk.f.g.a(a(k), 1, "Start to query cb!");
            if (!z) {
                if (f()) {
                    i();
                } else {
                    com.tencent.ydkqmsp.sdk.f.g.a(a(k), 1, "time has not arrived!");
                }
            }
            strA = a(k);
            sb = new java.lang.StringBuilder();
        } catch (java.lang.Throwable th) {
            try {
                th.printStackTrace();
                strA = a(k);
                sb = new java.lang.StringBuilder();
            } finally {
                com.tencent.ydkqmsp.sdk.f.g.a(a(k), 0, "next time: " + this.d);
                a(this.d);
            }
        }
        sb.append("next time: ");
        sb.append(this.d);
        com.tencent.ydkqmsp.sdk.f.g.a(strA, 0, sb.toString());
    }

    public void b() throws java.lang.Throwable {
        byte[] bArrA = new com.tencent.ydkqmsp.sdk.c.l().a(e(), null, 1);
        if (bArrA != null) {
            b(bArrA);
        }
    }
}
