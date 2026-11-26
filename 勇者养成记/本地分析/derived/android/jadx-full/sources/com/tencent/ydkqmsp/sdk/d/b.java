package com.tencent.ydkqmsp.sdk.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.util.List f1333a = new java.util.ArrayList();
    private android.content.SharedPreferences b;

    public b() {
        this.b = null;
        this.b = com.tencent.ydkqmsp.sdk.app.a.getContext().getSharedPreferences(a(com.tencent.ydkqmsp.sdk.d.d.b), 0);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0067  */
    /* JADX WARN: Code duplicated, block: B:20:0x006d  */
    private java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.io.File filesDir;
        java.lang.String str4;
        java.lang.StringBuilder sb;
        java.lang.String parent = "";
        if (!android.text.TextUtils.isEmpty(str) && !str.equals("1")) {
            if (str.equals("2")) {
                filesDir = com.tencent.ydkqmsp.sdk.app.a.getContext().getExternalFilesDir(null);
            }
            if (!parent.endsWith(java.io.File.separator) && !str2.startsWith(java.io.File.separator)) {
                parent = parent + java.io.File.separator;
            }
            str4 = parent + str2;
            if (str2.endsWith(java.io.File.separator)) {
                sb = new java.lang.StringBuilder();
            } else {
                sb = new java.lang.StringBuilder();
                sb.append(str4);
                str4 = java.io.File.separator;
            }
            sb.append(str4);
            sb.append(str3);
            return sb.toString();
        }
        filesDir = com.tencent.ydkqmsp.sdk.app.a.getContext().getFilesDir();
        parent = filesDir.getParent();
        if (!parent.endsWith(java.io.File.separator)) {
            parent = parent + java.io.File.separator;
        }
        str4 = parent + str2;
        if (str2.endsWith(java.io.File.separator)) {
            sb = new java.lang.StringBuilder();
        } else {
            sb = new java.lang.StringBuilder();
            sb.append(str4);
            str4 = java.io.File.separator;
        }
        sb.append(str4);
        sb.append(str3);
        return sb.toString();
    }

    private java.lang.String a(byte[] bArr) {
        return com.tencent.ydkqmsp.sdk.f.k.a(bArr);
    }

    private boolean a(java.lang.String str, long j, long j2) {
        if (str == null || !str.equals("android") || j < 0 || j2 < 0) {
            return false;
        }
        long j3 = android.os.Build.VERSION.SDK_INT;
        if (j == 0 && j2 == 0) {
            return true;
        }
        if (j == 0 && j2 > 0) {
            return j3 <= j2;
        }
        if (j <= 0 || j2 != 0) {
            return j > 0 && j2 > 0 && j3 >= j && j3 <= j2;
        }
        return j3 >= j;
    }

    private boolean a(java.lang.String str, java.lang.String str2) {
        if (str != null && str2 != null) {
            java.lang.String strReplace = str.replace(" ", "");
            java.lang.String strReplace2 = str2.replace(" ", "");
            boolean zEquals = strReplace.equals("*");
            boolean zEquals2 = strReplace2.equals("*");
            if (zEquals && zEquals2) {
                return true;
            }
            java.lang.String strC = com.tencent.ydkqmsp.sdk.a.c.c();
            if (android.text.TextUtils.isEmpty(strC)) {
                return false;
            }
            try {
                if (zEquals && !zEquals2) {
                    return b(strC, strReplace2) <= 0;
                }
                if (zEquals || !zEquals2) {
                    return !zEquals && !zEquals2 && b(strC, strReplace2) <= 0 && b(strC, strReplace) >= 0;
                }
                return b(strC, strReplace) >= 0;
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private int b(java.lang.String str, java.lang.String str2) {
        java.lang.String[] strArrSplit = str.split("\\.");
        java.lang.String[] strArrSplit2 = str2.split("\\.");
        int length = strArrSplit.length < strArrSplit2.length ? strArrSplit.length : strArrSplit2.length;
        for (int i = 0; i < length; i++) {
            int i2 = java.lang.Integer.parseInt(strArrSplit[i]);
            int i3 = java.lang.Integer.parseInt(strArrSplit2[i]);
            if (i2 > i3) {
                return 1;
            }
            if (i2 < i3) {
                return -1;
            }
        }
        return 0;
    }

    private java.lang.String b() {
        return com.tencent.ydkqmsp.sdk.a.b.c() + a(com.tencent.ydkqmsp.sdk.d.d.f1338a);
    }

    private boolean b(java.lang.String str) {
        if (str == null) {
            return false;
        }
        java.lang.String strReplace = str.replace(" ", "");
        if (strReplace.equals("*")) {
            return true;
        }
        java.lang.String str2 = android.os.Build.CPU_ABI;
        java.lang.String[] strArrSplit = strReplace.split(",");
        if (strArrSplit == null) {
            return false;
        }
        for (java.lang.String str3 : strArrSplit) {
            if (str2.contains(str3)) {
                return true;
            }
        }
        return false;
    }

    private boolean c(java.lang.String str) {
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            jSONObject.getLong(a(com.tencent.ydkqmsp.sdk.d.d.g[0]));
            jSONObject.getBoolean(a(com.tencent.ydkqmsp.sdk.d.d.g[1]));
            org.json.JSONArray jSONArray = jSONObject.getJSONArray(a(com.tencent.ydkqmsp.sdk.d.d.g[2]));
            for (int i = 0; i < jSONArray.length(); i++) {
                com.tencent.ydkqmsp.sdk.d.d.b bVar = new com.tencent.ydkqmsp.sdk.d.d.b();
                org.json.JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                bVar.f1340a = jSONObject2.getLong(a(com.tencent.ydkqmsp.sdk.d.d.g[3]));
                bVar.b = jSONObject2.getLong(a(com.tencent.ydkqmsp.sdk.d.d.g[4]));
                jSONObject2.getLong(a(com.tencent.ydkqmsp.sdk.d.d.g[7]));
                bVar.c = jSONObject2.getString(a(com.tencent.ydkqmsp.sdk.d.d.g[5]));
                bVar.d = jSONObject2.getString(a(com.tencent.ydkqmsp.sdk.d.d.g[6]));
                bVar.e = jSONObject2.getString(a(com.tencent.ydkqmsp.sdk.d.d.g[8]));
                bVar.f = jSONObject2.getLong(a(com.tencent.ydkqmsp.sdk.d.d.g[15]));
                bVar.g = jSONObject2.getLong(a(com.tencent.ydkqmsp.sdk.d.d.g[16]));
                bVar.j = jSONObject2.getString(a(com.tencent.ydkqmsp.sdk.d.d.g[18]));
                bVar.h = jSONObject2.getString(a(com.tencent.ydkqmsp.sdk.d.d.g[10]));
                bVar.i = jSONObject2.getString(a(com.tencent.ydkqmsp.sdk.d.d.g[11]));
                java.lang.String string = jSONObject2.getString(a(com.tencent.ydkqmsp.sdk.d.d.g[9]));
                bVar.k = string;
                bVar.m = a(string, bVar.f, bVar.g);
                bVar.n = b(bVar.j);
                bVar.l = a(bVar.h, bVar.i);
                if (jSONObject2.has(a(com.tencent.ydkqmsp.sdk.d.d.g[20]))) {
                    bVar.u = jSONObject2.getInt(a(com.tencent.ydkqmsp.sdk.d.d.g[20]));
                }
                org.json.JSONArray jSONArray2 = jSONObject2.getJSONArray(a(com.tencent.ydkqmsp.sdk.d.d.g[12]));
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    org.json.JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                    com.tencent.ydkqmsp.sdk.d.d.a aVar = new com.tencent.ydkqmsp.sdk.d.d.a();
                    jSONObject3.getLong(a(com.tencent.ydkqmsp.sdk.d.d.g[7]));
                    aVar.d = jSONObject3.getString(a(com.tencent.ydkqmsp.sdk.d.d.g[13]));
                    aVar.e = jSONObject3.getString(a(com.tencent.ydkqmsp.sdk.d.d.g[14]));
                    java.lang.String string2 = jSONObject3.getString(a(com.tencent.ydkqmsp.sdk.d.d.g[5]));
                    aVar.f1339a = string2;
                    aVar.f = a(aVar.d, aVar.e, string2);
                    aVar.b = jSONObject3.getString(a(com.tencent.ydkqmsp.sdk.d.d.g[6]));
                    aVar.h = jSONObject3.getLong(a(com.tencent.ydkqmsp.sdk.d.d.g[17]));
                    if (jSONObject3.has(a(com.tencent.ydkqmsp.sdk.d.d.g[19]))) {
                        aVar.i = jSONObject3.getString(a(com.tencent.ydkqmsp.sdk.d.d.g[19]));
                    }
                    bVar.o.add(aVar);
                }
                arrayList.add(bVar);
            }
            this.f1333a = arrayList;
            return true;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.tencent.ydkqmsp.sdk.f.g.a("Qp.QPUpdate", 1, "[SFU] parsing config error");
            return false;
        }
    }

    public java.util.List a() {
        return this.f1333a;
    }

    public java.util.List a(long j) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (a(b()) && !this.f1333a.isEmpty()) {
            for (int i = 0; i < this.f1333a.size(); i++) {
                com.tencent.ydkqmsp.sdk.d.d.b bVar = (com.tencent.ydkqmsp.sdk.d.d.b) this.f1333a.get(i);
                if (bVar.b == j) {
                    for (int i2 = 0; i2 < bVar.o.size(); i2++) {
                        com.tencent.ydkqmsp.sdk.d.d.a aVar = (com.tencent.ydkqmsp.sdk.d.d.a) bVar.o.get(i2);
                        aVar.g = this.b.getString(aVar.f, "");
                    }
                    for (int i3 = 0; i3 < bVar.q.size(); i3++) {
                        com.tencent.ydkqmsp.sdk.d.d.a aVar2 = (com.tencent.ydkqmsp.sdk.d.d.a) bVar.q.get(i3);
                        aVar2.g = this.b.getString(aVar2.f, "");
                    }
                    for (int i4 = 0; i4 < bVar.p.size(); i4++) {
                        com.tencent.ydkqmsp.sdk.d.d.a aVar3 = (com.tencent.ydkqmsp.sdk.d.d.a) bVar.p.get(i4);
                        aVar3.g = this.b.getString(aVar3.f, "");
                    }
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    public boolean a(java.lang.String str) throws java.lang.Throwable {
        byte[] bArrA = com.tencent.ydkqmsp.sdk.d.e.a(new java.io.File(str), null);
        if (bArrA != null) {
            return c(new java.lang.String(bArrA));
        }
        com.tencent.ydkqmsp.sdk.f.g.a("Qp.QPUpdate", 1, java.lang.String.format("[SFU] invalid sig of config: %s", str));
        return false;
    }
}
