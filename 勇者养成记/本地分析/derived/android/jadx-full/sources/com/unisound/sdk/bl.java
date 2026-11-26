package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class bl implements com.unisound.sdk.ad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.unisound.sdk.bg f1536a;

    bl(com.unisound.sdk.bg bgVar) {
        this.f1536a = bgVar;
    }

    @Override // com.unisound.sdk.e
    public void a() {
    }

    @Override // com.unisound.sdk.e
    public void a(int i) {
    }

    @Override // com.unisound.common.ar
    public void a(int i, int i2, java.lang.Object obj) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:40:0x00cc  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.unisound.sdk.ah
    public void a(com.unisound.sdk.al alVar) {
        android.os.Message messageObtainMessage;
        android.os.Handler handler;
        int i;
        byte b = 1;
        this.f1536a.aH = true;
        java.lang.String strA = alVar.a();
        boolean zC = alVar.c();
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(strA);
            if (jSONObject.has("speakerResult")) {
                this.f1536a.ap.obtainMessage(61, com.unisound.client.SpeechConstants.SPEAKER_RESULT, 0, jSONObject.getJSONObject("speakerResult").toString()).sendToTarget();
            }
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        this.f1536a.i.a(strA, zC);
        if (this.f1536a.W()) {
            com.unisound.common.y.c("SpeechUnderstanderInterface", "onResult : result = ", strA, " , isLast = ", java.lang.Boolean.valueOf(zC));
            if (zC) {
                strA = this.f1536a.n(strA);
            }
            com.unisound.common.VoiceprintResult voiceprintResult = new com.unisound.common.VoiceprintResult(strA);
            java.lang.String code = voiceprintResult.getCode();
            int iHashCode = code.hashCode();
            if (iHashCode != 49586) {
                if (iHashCode != 50547) {
                    if (iHashCode != 1477632) {
                        switch (iHashCode) {
                            case 48625:
                                if (!code.equals("100")) {
                                    b = -1;
                                } else {
                                    b = 0;
                                }
                                break;
                            case 48626:
                                if (!code.equals("101")) {
                                    b = -1;
                                }
                                break;
                            case 48627:
                                if (!code.equals("102")) {
                                    b = -1;
                                } else {
                                    b = 3;
                                }
                                break;
                            default:
                                b = -1;
                                break;
                        }
                    } else if (code.equals("0000")) {
                        b = 2;
                    } else {
                        b = -1;
                    }
                } else if (code.equals("300")) {
                    b = 5;
                } else {
                    b = -1;
                }
            } else if (code.equals("200")) {
                b = 4;
            } else {
                b = -1;
            }
            switch (b) {
                case 0:
                    handler = this.f1536a.ap;
                    i = 4222;
                    messageObtainMessage = handler.obtainMessage(62, i, 0, voiceprintResult.getVprResult());
                    break;
                case 1:
                    handler = this.f1536a.ap;
                    i = 4223;
                    messageObtainMessage = handler.obtainMessage(62, i, 0, voiceprintResult.getVprResult());
                    break;
                case 2:
                    messageObtainMessage = this.f1536a.ap.obtainMessage(61, 4221, 0, voiceprintResult.getVprResult());
                    break;
                case 3:
                    handler = this.f1536a.ap;
                    i = 4224;
                    messageObtainMessage = handler.obtainMessage(62, i, 0, voiceprintResult.getVprResult());
                    break;
                case 4:
                    handler = this.f1536a.ap;
                    i = 4225;
                    messageObtainMessage = handler.obtainMessage(62, i, 0, voiceprintResult.getVprResult());
                    break;
                case 5:
                    this.f1536a.ap.obtainMessage(60, com.unisound.client.SpeechConstants.VPR_ERROR, 0, voiceprintResult.getVprResult()).sendToTarget();
                default:
                    messageObtainMessage = this.f1536a.ap.obtainMessage(60, 0, 0, voiceprintResult.getVprResult());
                    break;
            }
            messageObtainMessage.sendToTarget();
        }
        if (this.f1536a.V()) {
            java.lang.String strB = alVar.b();
            if (!this.f1536a.aE.equals(strB)) {
                com.unisound.common.v.a();
                this.f1536a.v.clear();
            }
            this.f1536a.aE = strB;
            if (this.f1536a.X()) {
                this.f1536a.a(alVar);
                this.f1536a.b(alVar);
            }
            this.f1536a.c(alVar);
        }
        this.f1536a.b.aW().b(0);
        this.f1536a.aH = false;
    }

    @Override // com.unisound.sdk.ad
    public void a(boolean z, byte[] bArr, int i, int i2) {
    }

    @Override // com.unisound.sdk.e
    public void b() {
    }

    @Override // com.unisound.sdk.ad
    public void b(int i) throws java.lang.Throwable {
        android.content.Context context;
        boolean z;
        this.f1536a.aH = true;
        com.unisound.sdk.bg bgVar = this.f1536a;
        bgVar.E = bgVar.o.f();
        if (i != 0) {
            this.f1536a.b.Q(i);
            if (i == -69001) {
                com.unisound.c.a.a(true);
                this.f1536a.refreshActivate();
            }
            this.f1536a.q(i);
            if (this.f1536a.D) {
                this.f1536a.e.b();
            }
        }
        if (this.f1536a.z != null) {
            this.f1536a.C = true;
            this.f1536a.ap.sendEmptyMessage(7);
            this.f1536a.K();
        }
        if (i != 0) {
            context = this.f1536a.l;
            z = true;
        } else {
            context = this.f1536a.l;
            z = false;
        }
        com.unisound.common.y.a(context, z, this.f1536a.x, this.f1536a.E, i, com.unisound.client.ErrorCode.toMessage(i));
        this.f1536a.aH = false;
    }

    @Override // com.unisound.sdk.e
    public void c() {
        if (this.f1536a.ap != null) {
            this.f1536a.ap.sendEmptyMessage(25);
        }
    }

    @Override // com.unisound.sdk.ad
    public void c(int i) {
        this.f1536a.l(i);
    }

    @Override // com.unisound.sdk.ad
    public void d() {
    }

    @Override // com.unisound.sdk.ad
    public void d(int i) {
        if (this.f1536a.z != null) {
            this.f1536a.q(i);
        }
    }

    @Override // com.unisound.sdk.ad
    public void e() {
    }

    @Override // com.unisound.sdk.ad
    public void f() {
    }

    @Override // com.unisound.sdk.ad
    public void g() {
    }

    @Override // com.unisound.sdk.ad
    public void h() {
        if (this.f1536a.z != null) {
            this.f1536a.ap.sendEmptyMessage(30);
        }
    }
}
