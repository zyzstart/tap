package com.tencent.hlyyb.common.b.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public java.lang.String f544a;
    private boolean b;
    private boolean c;
    private int d;
    private java.net.URL e;
    private java.lang.String f;
    private int g;

    public b(java.net.URL url, java.lang.String str) {
        this.b = com.tencent.hlyyb.common.a.e.a("direct_access_use_schedule", 0, 1, 1) == 1;
        this.c = com.tencent.hlyyb.common.a.e.a("direct_https_use_sche", 0, 1, 1) == 1;
        this.d = com.tencent.hlyyb.common.a.e.a("direct_access_domain_try_times", 1, 8, 2);
        this.f544a = "";
        this.e = url;
        this.f = str;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0070  */
    /* JADX WARN: Code duplicated, block: B:19:0x0078  */
    /* JADX WARN: Code duplicated, block: B:20:0x007e  */
    /* JADX WARN: Code duplicated, block: B:24:0x009e  */
    /* JADX WARN: Code duplicated, block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:24:0x009e, please report this as an issue */
    public final java.lang.String a(com.tencent.hlyyb.common.a.a aVar) {
        java.lang.StringBuilder sb;
        int iC;
        java.lang.String string;
        java.lang.String file;
        java.lang.String ref;
        java.lang.StringBuilder sb2;
        if (aVar.e()) {
            return this.f;
        }
        if (this.e.getProtocol().startsWith("https")) {
            if (this.g != 0) {
                sb = new java.lang.StringBuilder("https://");
                sb.append(aVar.a());
                sb.append(":");
                iC = this.g;
            } else {
                sb = new java.lang.StringBuilder("https://");
                sb.append(aVar.a());
                sb.append(":443");
            }
            string = sb.toString();
            file = this.e.getFile();
            if (!android.text.TextUtils.isEmpty(file)) {
                if (file.startsWith("/")) {
                    sb2 = new java.lang.StringBuilder();
                } else {
                    sb2 = new java.lang.StringBuilder();
                    sb2.append(string);
                    string = "/";
                }
                sb2.append(string);
                sb2.append(file);
                string = sb2.toString();
            }
            ref = this.e.getRef();
            if (!android.text.TextUtils.isEmpty(ref)) {
                return string;
            }
            return string + "#" + ref;
        }
        sb = new java.lang.StringBuilder("http://");
        sb.append(aVar.a());
        sb.append(":");
        iC = aVar.c();
        sb.append(iC);
        string = sb.toString();
        file = this.e.getFile();
        if (!android.text.TextUtils.isEmpty(file)) {
            if (file.startsWith("/")) {
                sb2 = new java.lang.StringBuilder();
            } else {
                sb2 = new java.lang.StringBuilder();
                sb2.append(string);
                string = "/";
            }
            sb2.append(string);
            sb2.append(file);
            string = sb2.toString();
        }
        ref = this.e.getRef();
        if (!android.text.TextUtils.isEmpty(ref)) {
            return string;
        }
        return string + "#" + ref;
    }

    public final java.util.List a(com.tencent.hlyyb.common.b.a aVar, boolean z, boolean z2) {
        com.tencent.hlyyb.common.a.a aVar2 = new com.tencent.hlyyb.common.a.a(this.e.getHost(), -1);
        int i = 3;
        aVar2.a((byte) 3);
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            if (!z) {
                arrayList.add(aVar2);
                aVar2.f519a = 1;
                return arrayList;
            }
            if (!com.tencent.hlyyb.common.a.f.j() && this.b && (!z2 || this.c)) {
                com.tencent.hlyyb.common.a.c.b bVarA = com.tencent.hlyyb.common.b.a.a(this.e.getHost());
                java.util.List list = bVarA.c;
                this.g = bVarA.d;
                this.f544a = bVarA.b;
                return list;
            }
            for (int i2 = 0; i2 < this.d; i2++) {
                arrayList.add(aVar2);
            }
            if (com.tencent.hlyyb.common.a.f.j()) {
                i = 2;
            } else if (this.b) {
                i = 4;
            }
            aVar2.f519a = i;
            return arrayList;
        } catch (java.lang.Exception unused) {
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            for (int i3 = 0; i3 < this.d; i3++) {
                arrayList2.add(aVar2);
            }
            aVar2.f519a = 8;
            return arrayList2;
        }
    }
}
