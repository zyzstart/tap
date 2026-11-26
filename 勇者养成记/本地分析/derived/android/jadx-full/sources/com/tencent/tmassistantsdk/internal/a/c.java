package com.tencent.tmassistantsdk.internal.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1066a = -1;
    public java.lang.String b;
    public int c;
    public java.lang.String d;
    public java.lang.String e;
    public int f;
    public java.lang.String g;
    public long h;
    public long i;
    public int j;
    public byte[] k;

    public c(java.lang.String str, int i, java.lang.String str2, int i2, java.lang.String str3, long j, long j2, int i3, java.lang.String str4, byte[] bArr) {
        this.b = "";
        this.c = 0;
        this.d = "";
        this.e = "";
        this.f = 0;
        this.g = "";
        this.h = 0L;
        this.i = 0L;
        this.j = 0;
        this.k = null;
        this.b = str;
        if (str == null) {
            this.b = "";
        }
        this.c = i;
        this.d = str2;
        if (str2 == null) {
            this.d = "";
        }
        this.f = i2;
        this.g = str3;
        if (str3 == null) {
            this.g = "";
        }
        this.h = j;
        this.i = j2;
        this.j = i3;
        this.e = str4;
        this.k = bArr;
    }

    public static com.tencent.tmassistantsdk.internal.a.c a(byte[] bArr) {
        byte[] bArrA;
        java.lang.String string;
        if (bArr != null && bArr.length > 0 && (bArrA = new com.tencent.tmassistantbase.util.g().a(bArr, "&-*)Wb5_U,[^!9'+".getBytes())) != null) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(new java.lang.String(bArrA, "UTF-8"));
                java.lang.String string2 = jSONObject.getString("mHostPackageName");
                int i = jSONObject.getInt("mHostVersion");
                java.lang.String string3 = jSONObject.getString("mHostUserIdentity");
                int i2 = jSONObject.getInt("mDataItemType");
                java.lang.String string4 = jSONObject.getString("mDataItemAction");
                long j = jSONObject.getLong("mDataItemStartTime");
                long j2 = jSONObject.getLong("mDataItemEndTime");
                int i3 = jSONObject.getInt("mDataItemVersion");
                return new com.tencent.tmassistantsdk.internal.a.c(string2, i, string3, i2, string4, j, j2, i3, jSONObject.getString("mCutEocdMd5"), (i3 < 1 || (string = jSONObject.getString("mIPCData")) == null) ? null : com.tencent.tmassistantbase.util.b.a(string, 0));
            } catch (java.io.UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (org.json.JSONException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public byte[] a() {
        byte[] bytes;
        java.lang.String strB;
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("mHostPackageName", this.b);
            jSONObject.put("mHostVersion", this.c);
            jSONObject.put("mHostUserIdentity", this.d);
            jSONObject.put("mDataItemType", this.f);
            jSONObject.put("mDataItemAction", this.g);
            jSONObject.put("mDataItemStartTime", this.h);
            jSONObject.put("mDataItemEndTime", this.i);
            jSONObject.put("mDataItemVersion", this.j);
            jSONObject.put("mCutEocdMd5", this.e);
            if (this.j >= 1 && this.k != null && (strB = com.tencent.tmassistantbase.util.b.b(this.k, 0)) != null) {
                jSONObject.put("mIPCData", strB);
            }
            java.lang.String string = jSONObject.toString();
            if (string == null || (bytes = string.getBytes("UTF-8")) == null) {
                return null;
            }
            return new com.tencent.tmassistantbase.util.g().b(bytes, "&-*)Wb5_U,[^!9'+".getBytes());
        } catch (java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        } catch (org.json.JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
