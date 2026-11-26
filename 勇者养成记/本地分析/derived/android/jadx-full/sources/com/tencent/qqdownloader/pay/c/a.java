package com.tencent.qqdownloader.pay.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f761a;
    java.lang.String b;
    java.lang.String c;
    java.lang.String d;
    java.lang.String e;

    public a(org.json.JSONObject jSONObject, java.lang.String str, java.lang.String str2) {
        try {
            this.e = str2;
            this.d = str;
            this.f761a = com.tencent.qqdownloader.pay.utils.c.a(jSONObject, "ret", (java.lang.Integer) (-50)).intValue();
            this.b = com.tencent.qqdownloader.pay.utils.c.a(jSONObject, com.tencent.open.SocialOperation.GAME_SIGNATURE, "");
            this.c = com.tencent.qqdownloader.pay.utils.c.a(jSONObject, "random", "");
            if (this.f761a == 0) {
                this.f761a = c() ? 0 : -51;
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private boolean c() throws java.security.spec.InvalidKeySpecException, java.security.NoSuchAlgorithmException, java.security.SignatureException, java.security.InvalidKeyException {
        com.tencent.qqdownloader.pay.utils.i.a("http.auth", "clientRandom:" + this.d + "|" + this.c + "|" + this.b);
        java.security.PublicKey publicKeyGeneratePublic = java.security.KeyFactory.getInstance("RSA").generatePublic(new java.security.spec.X509EncodedKeySpec(com.tencent.qqdownloader.pay.utils.a.a(this.e)));
        java.security.Signature signature = java.security.Signature.getInstance("SHA256withRSA");
        signature.initVerify(publicKeyGeneratePublic);
        signature.update(("client=" + this.d + "&server=" + this.c).getBytes());
        return signature.verify(com.tencent.qqdownloader.pay.utils.a.a(this.b));
    }

    public int a() {
        return this.f761a;
    }

    public boolean b() {
        return this.f761a == 0;
    }
}
