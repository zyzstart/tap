package com.tencent.hlyyb.common.d.b.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.tencent.hlyyb.common.d.b.a.c f569a = new com.tencent.hlyyb.common.d.b.a.c();
    private java.util.Map b = new com.tencent.hlyyb.common.d.b.a.d(this, 8, 1.0f, true);

    private c() {
        a(com.tencent.hlyyb.common.d.j.b("HalleyOperInfo_" + com.tencent.hlyyb.common.a.c(), "", true), false);
    }

    public static com.tencent.hlyyb.common.d.b.a.c a() {
        return f569a;
    }

    public static java.lang.String a(int i) {
        if (i == 1) {
            return "cm";
        }
        if (i == 3) {
            return "ct";
        }
        return i == 2 ? "uni" : "";
    }

    public final java.lang.String a(java.lang.String str) {
        if (com.tencent.hlyyb.common.f.c.a(str) || android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN.equals(str)) {
            return "";
        }
        synchronized (this.b) {
            java.lang.String str2 = (java.lang.String) this.b.get(str);
            return !com.tencent.hlyyb.common.f.c.a(str2) ? str2 : "";
        }
    }

    public final void a(java.lang.String str, java.lang.String str2) {
        if (com.tencent.hlyyb.common.f.c.a(str) || android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN.equals(str) || com.tencent.hlyyb.common.f.c.a(str2) || android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN.equals(str2)) {
            return;
        }
        synchronized (this.b) {
            if (!str2.equals((java.lang.String) this.b.get(str))) {
                this.b.put(str, str2);
                com.tencent.hlyyb.common.d.j.a("HalleyOperInfo_" + com.tencent.hlyyb.common.a.c(), b(), true);
            }
        }
    }

    public final void a(java.lang.String str, boolean z) {
        try {
            if (com.tencent.hlyyb.common.f.c.a(str)) {
                return;
            }
            synchronized (this.b) {
                this.b.clear();
                java.lang.String[] strArrSplit = str.split("h;l");
                if (strArrSplit != null) {
                    for (java.lang.String str2 : strArrSplit) {
                        java.lang.String[] strArrSplit2 = str2.split("h,l");
                        if (strArrSplit2.length == 2) {
                            this.b.put(strArrSplit2[0], strArrSplit2[1]);
                        }
                    }
                }
            }
            if (z) {
                com.tencent.hlyyb.common.d.j.a("HalleyOperInfo_" + com.tencent.hlyyb.common.a.c(), str, true);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final java.lang.String b() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        synchronized (this.b) {
            java.util.ArrayList arrayList = new java.util.ArrayList(this.b.keySet());
            java.util.ArrayList arrayList2 = new java.util.ArrayList(this.b.values());
            for (int i = 0; i < arrayList.size(); i++) {
                java.lang.String str = (java.lang.String) arrayList.get(i);
                java.lang.String str2 = (java.lang.String) arrayList2.get(i);
                sb.append(str);
                sb.append("h,l");
                sb.append(str2);
                sb.append("h;l");
            }
        }
        return sb.toString();
    }
}
