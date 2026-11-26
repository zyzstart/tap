package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class cp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static java.lang.String f1555a = "http://rtc.hivoice.cn";
    private static final int d = 10000;
    private java.lang.String b = "/data-process-service/oneshot";
    private cn.yunzhisheng.casr.EncodeContent c = new cn.yunzhisheng.casr.EncodeContent();
    private android.content.Context e;
    private java.lang.String f;

    public cp(android.content.Context context, java.lang.String str) {
        this.e = context;
        this.f = str;
    }

    private java.util.Set<java.lang.String> a(android.content.Context context) {
        return context.getSharedPreferences("onlinewakeup", 0).getStringSet("onlineWakeupWord", null);
    }

    public static boolean a(java.lang.String str) {
        return java.util.regex.Pattern.compile("[`~!@#$%^&*()_\\+\\-\\={}|\\\\\\[\\]\\:\";'<>?,./~·！@#￥%……&*（）——\\+\\-\\={}|【】、：“”；‘’《》？，。、｀～！＠＃＄％＾＆＊（）＿＋－＝｛｝｜［］＼：＂＂；＇＇＜＞？，．／·～！＠＃￥％……＆×（）——＋－＝｛｝｜【】＼：“”；‘’《》？，。、]").matcher(str).find();
    }

    public java.lang.String a(int i) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("status", i);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public java.lang.String a(java.lang.String str, java.lang.String str2) {
        java.lang.String strA;
        com.unisound.common.y.b("UploadOneShotOnlineWakeupData onlineWakeupWord => ", str2);
        a(0);
        try {
            byte[] bytes = str.getBytes();
            byte[] bytes2 = str2.getBytes();
            byte[] bArr = new byte[bytes.length + bytes2.length + 10];
            if (this.c.EncodeTotalContent(bytes, bytes2, bArr) != 0) {
                strA = a(com.unisound.client.ErrorCode.ASR_SDK_UPLOAD_ONESHOT_ONLINE_ENCODE_ERROR);
            } else {
                java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(f1555a + this.b).openConnection();
                httpURLConnection.setRequestMethod(com.tencent.connect.common.Constants.HTTP_POST);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setConnectTimeout(10000);
                java.io.OutputStream outputStream = httpURLConnection.getOutputStream();
                com.unisound.common.y.b("UploadOneShotOnlineWakeupData conn param => ", httpURLConnection.toString());
                outputStream.write(bArr);
                outputStream.flush();
                outputStream.close();
                if (httpURLConnection.getResponseCode() == 200) {
                    strA = new java.io.BufferedReader(new java.io.InputStreamReader(httpURLConnection.getInputStream())).readLine();
                    com.unisound.common.y.c("upload response codeStr=", strA);
                } else {
                    strA = a(com.unisound.client.ErrorCode.ASR_SDK_UPLOAD_ONESHOT_ONLINE_NETWORK_ERROR);
                }
            }
            return strA;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.unisound.common.y.a("UploadOneShotOnlineWakeupData exception =>" + e.getMessage());
            return a(com.unisound.client.ErrorCode.ASR_SDK_UPLOAD_ONESHOT_ONLINE_ERROR);
        }
    }

    public java.lang.String a(java.util.List<java.lang.String> list) {
        com.unisound.common.af afVar = new com.unisound.common.af();
        afVar.a("1.0");
        afVar.b(this.f);
        afVar.c(com.unisound.c.a.a(this.f));
        afVar.a(a(this.e));
        java.util.HashSet hashSet = new java.util.HashSet();
        hashSet.addAll(list);
        afVar.b(hashSet);
        return afVar.g();
    }

    public void a(java.util.Set<java.lang.String> set) {
        android.content.SharedPreferences.Editor editorEdit = this.e.getSharedPreferences("onlinewakeup", 0).edit();
        editorEdit.putStringSet("onlineWakeupWord", set);
        editorEdit.commit();
    }
}
