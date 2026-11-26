package com.tencent.beacon.core.event;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class u implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.util.Map f177a = new java.util.HashMap();

    private java.lang.String a(java.util.List list) {
        java.nio.ByteBuffer byteBufferAllocate = java.nio.ByteBuffer.allocate(list.size() * 4);
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            byteBufferAllocate.putFloat(((java.lang.Float) it.next()).floatValue());
        }
        return android.util.Base64.encodeToString(byteBufferAllocate.array(), 0);
    }

    public void a() {
        com.tencent.beacon.core.a.d.a().a(this);
    }

    public void a(java.lang.String str, float[] fArr) {
        java.util.List arrayList = (java.util.List) this.f177a.get(str);
        if (arrayList == null) {
            arrayList = new java.util.ArrayList();
            this.f177a.put(str, arrayList);
        }
        for (float f : fArr) {
            arrayList.add(java.lang.Float.valueOf(f));
        }
    }

    public java.util.Map b() {
        java.util.HashMap map = new java.util.HashMap();
        for (java.util.Map.Entry entry : this.f177a.entrySet()) {
            java.lang.String strReplace = a((java.util.List) entry.getValue()).replace("=", "%3D").replace("/", "%2F").replace("+", "%2B").replace("\n", "");
            map.put(entry.getKey(), strReplace + ";");
        }
        return map;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.tencent.beacon.event.UserAction.onUserAction("rqd_sensor", true, -1L, -1L, b(), true, true);
    }
}
