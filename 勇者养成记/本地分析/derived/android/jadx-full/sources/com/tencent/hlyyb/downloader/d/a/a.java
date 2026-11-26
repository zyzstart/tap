package com.tencent.hlyyb.downloader.d.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f611a;
    public long b;
    public java.lang.String c;
    public java.lang.String d;
    public java.lang.String e;
    public java.util.List f;
    public java.util.List g;
    public java.util.Map h = new java.util.HashMap();
    private java.lang.String i;
    private java.util.List j;

    public a(org.json.JSONObject jSONObject, java.lang.String str) {
        a(jSONObject, str);
    }

    private void a(org.json.JSONObject jSONObject, java.lang.String str) {
        this.f611a = false;
        try {
            jSONObject.optString("ipinfo");
            org.json.JSONObject jSONObject2 = new org.json.JSONObject(jSONObject.optString("resultmap"));
            java.util.Iterator<java.lang.String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                java.lang.String next = itKeys.next();
                this.i = next;
                if (next.equals(str)) {
                    org.json.JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject(this.i);
                    jSONObjectOptJSONObject.optInt("code");
                    this.b = jSONObjectOptJSONObject.optLong("size");
                    this.c = jSONObjectOptJSONObject.optString("md5");
                    this.d = jSONObjectOptJSONObject.optString("schedulecode");
                    this.e = jSONObjectOptJSONObject.optString("featuresmd5");
                    org.json.JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("reselements");
                    this.j = new java.util.ArrayList();
                    if (jSONArrayOptJSONArray != null) {
                        int length = jSONArrayOptJSONArray.length();
                        for (int i = 0; i < length; i++) {
                            org.json.JSONObject jSONObject3 = jSONArrayOptJSONArray.getJSONObject(i);
                            com.tencent.hlyyb.downloader.d.a.b bVar = new com.tencent.hlyyb.downloader.d.a.b((byte) 0);
                            bVar.f612a = jSONObject3.optInt(com.tencent.open.SocialConstants.PARAM_TYPE);
                            jSONObject3.optString("realurl");
                            org.json.JSONArray jSONArrayOptJSONArray2 = jSONObject3.optJSONArray("iplist");
                            bVar.b = new java.util.ArrayList();
                            if (jSONArrayOptJSONArray2 != null) {
                                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                                    bVar.b.add((java.lang.String) jSONArrayOptJSONArray2.get(i2));
                                }
                            }
                            bVar.c = jSONObject3.optString("scheurl");
                            org.json.JSONObject jSONObjectOptJSONObject2 = jSONObject3.optJSONObject("headers");
                            java.util.Iterator<java.lang.String> itKeys2 = jSONObjectOptJSONObject2.keys();
                            while (itKeys2.hasNext()) {
                                java.lang.String next2 = itKeys2.next();
                                bVar.d.put(next2, jSONObjectOptJSONObject2.optString(next2));
                            }
                            this.j.add(bVar);
                        }
                    }
                    org.json.JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray("features");
                    if (jSONArrayOptJSONArray3 != null) {
                        this.f = new java.util.ArrayList();
                        for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                            org.json.JSONObject jSONObject4 = jSONArrayOptJSONArray3.getJSONObject(i3);
                            this.f.add(new com.tencent.hlyyb.downloader.d.a(jSONObject4.optLong("offset"), jSONObject4.optInt("length")));
                        }
                    }
                    this.g = new java.util.ArrayList();
                    for (com.tencent.hlyyb.downloader.d.a.b bVar2 : this.j) {
                        if (bVar2.f612a == 0) {
                            this.g.add(bVar2.c);
                            java.util.Iterator it = bVar2.b.iterator();
                            while (it.hasNext()) {
                                this.g.add(com.tencent.hlyyb.common.f.c.a(bVar2.c, (java.lang.String) it.next()));
                            }
                        } else if (bVar2.f612a == 1) {
                            this.g.add(bVar2.c);
                        }
                        if (bVar2.d.size() > 0) {
                            this.h.put(java.lang.Integer.valueOf(bVar2.f612a), bVar2.d);
                        }
                    }
                }
            }
            this.f611a = true;
        } catch (java.lang.Exception e) {
            this.f611a = false;
            e.printStackTrace();
        }
    }
}
