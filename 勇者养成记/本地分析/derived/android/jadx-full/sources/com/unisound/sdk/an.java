package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class an extends java.lang.Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f1518a = 30;
    private com.unisound.sdk.as e;
    private android.content.Context j;
    private java.lang.String m;
    private com.unisound.sdk.ak b = null;
    private java.util.concurrent.BlockingQueue<byte[]> c = new java.util.concurrent.LinkedBlockingQueue();
    private com.unisound.sdk.ai d = new com.unisound.sdk.ai();
    private java.lang.String f = "";
    private volatile boolean g = false;
    private java.lang.String h = "";
    private java.lang.String i = "";
    private java.lang.String k = "";
    private boolean l = true;

    public an(com.unisound.sdk.as asVar, android.content.Context context, java.lang.String str) {
        this.m = "";
        this.j = context;
        this.e = asVar;
        com.unisound.sdk.ai.f1515a = true;
        this.m = java.lang.System.currentTimeMillis() + "";
    }

    private void a(int i) {
        com.unisound.common.y.c("NetRecognition --> RecognitionEvent = " + i);
        com.unisound.sdk.ak akVar = this.b;
        if (akVar != null) {
            akVar.k(i);
        }
    }

    private void a(int i, cn.yunzhisheng.asr.JniUscClient jniUscClient) throws java.lang.Throwable {
        com.unisound.sdk.ak akVar = this.b;
        b();
        com.unisound.common.y.a(jniUscClient);
        if (akVar != null) {
            akVar.a(i);
        }
    }

    /* JADX WARN: Code duplicated, block: B:52:0x021e  */
    /* JADX WARN: Code duplicated, block: B:54:0x0226  */
    /* JADX WARN: Code duplicated, block: B:58:0x0233  */
    /* JADX WARN: Code duplicated, block: B:61:0x025f  */
    /* JADX WARN: Code duplicated, block: B:64:0x028a  */
    /* JADX WARN: Code duplicated, block: B:67:0x02b1  */
    /* JADX WARN: Code duplicated, block: B:72:0x0343  */
    /* JADX WARN: Code duplicated, block: B:74:0x0351  */
    /* JADX WARN: Instruction removed from duplicated block: B:58:0x0233, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:61:0x025f, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:64:0x028a, please report this as an issue */
    private void a(cn.yunzhisheng.asr.JniUscClient jniUscClient) {
        java.lang.String str;
        java.lang.String str2;
        if (this.e.ap()) {
            jniUscClient.a(com.tencent.smtt.sdk.TbsListener.ErrorCode.EXCEED_DEXOPT_RETRY_NUM, 3);
            jniUscClient.a(com.tencent.smtt.sdk.TbsListener.ErrorCode.DEXOPT_EXCEPTION, 3);
        }
        if (com.unisound.common.y.l) {
            jniUscClient.a(com.tencent.smtt.sdk.TbsListener.ErrorCode.EXCEED_DEXOPT_RETRY_NUM, 3);
            jniUscClient.a(com.tencent.smtt.sdk.TbsListener.ErrorCode.DEXOPT_EXCEPTION, 3);
        }
        com.unisound.common.y.a("init", (java.lang.String) null, (java.util.Map<java.lang.String, java.lang.String>) null, (java.lang.String) null, (java.lang.String) null, (java.lang.String) null);
        com.unisound.common.a aVarBb = this.e.bb();
        long jA = jniUscClient.a(aVarBb.b(), aVarBb.c());
        com.unisound.common.y.c("NetRecognition -- > server = ", aVarBb.b(), " ip = ", aVarBb.a(), " port = ", java.lang.Integer.valueOf(aVarBb.c()));
        java.util.HashMap map = new java.util.HashMap();
        map.put("server", aVarBb.a());
        map.put("port", java.lang.String.valueOf(aVarBb.c()));
        com.unisound.common.y.a(com.unisound.common.y.z, (java.lang.String) null, map, (java.lang.String) null, (java.lang.String) null, (java.lang.String) null);
        if (jA == 0) {
            com.unisound.common.y.a(com.unisound.common.y.z, "error", map, (java.lang.String) null, (java.lang.String) null, "handle=0");
            com.unisound.common.y.c(toString(), "juc.create() returns ", java.lang.Long.valueOf(jA));
        }
        jniUscClient.a(0, this.e.bb);
        jniUscClient.a(1, this.e.bc);
        jniUscClient.a(6, this.e.ba);
        jniUscClient.a(4, this.e.bd);
        java.util.HashMap map2 = new java.util.HashMap();
        map2.put("enable_vad", java.lang.String.valueOf(this.e.bb));
        map2.put("vad_timeout", java.lang.String.valueOf(this.e.bc));
        map2.put("pcm_compress", java.lang.String.valueOf(this.e.ba));
        map2.put("result_timeout", java.lang.String.valueOf(this.e.bd));
        com.unisound.common.y.a(com.unisound.common.y.z, (java.lang.String) null, map2, (java.lang.String) null, (java.lang.String) null, (java.lang.String) null);
        c(jniUscClient);
        b(jniUscClient);
        if (!this.e.an()) {
            a(jniUscClient, "Start");
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            if (this.e.aX().y()) {
                if ((!this.e.aW().f() || this.e.aX().w()) && ((!this.e.aW().f() && this.e.aX().w()) || (this.e.aW().f() && this.e.aX().w()))) {
                    sb.append(this.i);
                }
                str = "filterName=nlu2;";
            } else if (this.e.aW().f() && !this.e.aX().w()) {
                str = "filterName=;";
            } else if ((this.e.aW().f() || !this.e.aX().w()) && !(this.e.aW().f() && this.e.aX().w())) {
                if (this.e.aS() == null && !"".equals(this.e.aS())) {
                    str2 = "additionalService=" + this.e.aS() + ";";
                } else if (this.e.aR()) {
                    str2 = "additionalService=wx_adapt;";
                } else {
                    if (this.e.bt() > 0) {
                        sb.append("req_nlu_length=");
                        sb.append(this.e.bt() + ";");
                    }
                    if (this.e.aX().z() != -1) {
                        sb.append("appendLength=");
                        sb.append(this.e.aX().z() + ";");
                    }
                    if (this.e.bv()) {
                        sb.append("maxWell=");
                        sb.append(this.e.bv() + ";");
                    }
                    if (this.e.bw() != null && !this.e.bw().equals("")) {
                        sb.append("retType=");
                        sb.append(this.e.bw() + ";");
                    }
                    sb.append("fullDuplex=");
                    sb.append(this.e.bz() + ";");
                    sb.append("audioUrl=");
                    sb.append(this.e.by() + ";");
                    sb.append("filterUrl=");
                    sb.append(this.e.bq() + ";");
                    if (this.e.aT() != null || this.e.aT().equals("")) {
                        jniUscClient.a(201, sb.toString());
                        com.unisound.common.y.c("juc init traficParams = ", sb.toString());
                    }
                }
                sb.append(str2);
                if (this.e.bt() > 0) {
                    sb.append("req_nlu_length=");
                    sb.append(this.e.bt() + ";");
                }
                if (this.e.aX().z() != -1) {
                    sb.append("appendLength=");
                    sb.append(this.e.aX().z() + ";");
                }
                if (this.e.bv()) {
                    sb.append("maxWell=");
                    sb.append(this.e.bv() + ";");
                }
                if (this.e.bw() != null) {
                    sb.append("retType=");
                    sb.append(this.e.bw() + ";");
                }
                sb.append("fullDuplex=");
                sb.append(this.e.bz() + ";");
                sb.append("audioUrl=");
                sb.append(this.e.by() + ";");
                sb.append("filterUrl=");
                sb.append(this.e.bq() + ";");
                if (this.e.aT() != null) {
                    jniUscClient.a(201, sb.toString());
                    com.unisound.common.y.c("juc init traficParams = ", sb.toString());
                } else {
                    jniUscClient.a(201, sb.toString());
                    com.unisound.common.y.c("juc init traficParams = ", sb.toString());
                }
            } else {
                sb.append(this.i);
                str = "filterName=search;";
            }
            sb.append(str);
            if (this.e.aS() == null) {
                if (this.e.aR()) {
                    str2 = "additionalService=wx_adapt;";
                    sb.append(str2);
                }
            } else if (this.e.aR()) {
                str2 = "additionalService=wx_adapt;";
                sb.append(str2);
            }
            if (this.e.bt() > 0) {
                sb.append("req_nlu_length=");
                sb.append(this.e.bt() + ";");
            }
            if (this.e.aX().z() != -1) {
                sb.append("appendLength=");
                sb.append(this.e.aX().z() + ";");
            }
            if (this.e.bv()) {
                sb.append("maxWell=");
                sb.append(this.e.bv() + ";");
            }
            if (this.e.bw() != null) {
                sb.append("retType=");
                sb.append(this.e.bw() + ";");
            }
            sb.append("fullDuplex=");
            sb.append(this.e.bz() + ";");
            sb.append("audioUrl=");
            sb.append(this.e.by() + ";");
            sb.append("filterUrl=");
            sb.append(this.e.bq() + ";");
            if (this.e.aT() != null) {
                jniUscClient.a(201, sb.toString());
                com.unisound.common.y.c("juc init traficParams = ", sb.toString());
            } else {
                jniUscClient.a(201, sb.toString());
                com.unisound.common.y.c("juc init traficParams = ", sb.toString());
            }
        }
        if (this.e.aT() != null && !this.e.aT().equals("")) {
            jniUscClient.a(201, this.e.aT());
            com.unisound.common.y.c("juc init external setting traficParams = ", this.e.aT());
        }
        if (this.e.aP() != this.e.be()) {
            jniUscClient.a(cn.yunzhisheng.asr.JniUscClient.au, this.e.aP());
            jniUscClient.a(321, this.e.be());
        }
        com.unisound.common.y.x = 0;
        com.unisound.common.y.c("juc init success");
    }

    private void a(cn.yunzhisheng.asr.JniUscClient jniUscClient, com.unisound.common.ak akVar) {
        if (akVar == null || !akVar.a()) {
            return;
        }
        com.unisound.common.y.a("updateAsrScene " + akVar.c() + " res : " + jniUscClient.a(31, akVar.c()));
        akVar.a(false);
    }

    private void a(cn.yunzhisheng.asr.JniUscClient jniUscClient, java.lang.String str) {
        com.unisound.sdk.cm cmVarAX = this.e.aX();
        cmVarAX.b(java.lang.System.currentTimeMillis());
        if (cmVarAX == null || !cmVarAX.w()) {
            return;
        }
        this.i = cmVarAX.A();
        com.unisound.common.y.c("NetRecognition --> ", str, " NluParams : ", cmVarAX.A());
        java.util.HashMap map = new java.util.HashMap();
        map.put("nlu_sendParams", cmVarAX.A());
        com.unisound.common.y.a(com.unisound.common.y.B, (java.lang.String) null, map, (java.lang.String) null, (java.lang.String) null, str);
    }

    private void a(cn.yunzhisheng.asr.JniUscClient jniUscClient, java.lang.String str, java.lang.String str2, boolean z) throws java.lang.Throwable {
        if (str2.equals("null")) {
            return;
        }
        com.unisound.sdk.al alVar = new com.unisound.sdk.al();
        alVar.a(com.unisound.sdk.am.NET);
        alVar.b(str);
        java.lang.String strC = jniUscClient.c(61);
        alVar.a(strC);
        if (str2.equals(cn.yunzhisheng.asr.JniUscClient.aB)) {
            alVar.b(true);
        } else {
            if (z) {
                java.lang.String strC2 = jniUscClient.c(62);
                if (android.text.TextUtils.isEmpty(strC2) || java.lang.Integer.valueOf(strC2).intValue() <= 0) {
                    alVar.a(true);
                } else {
                    alVar.a(false);
                }
            }
            alVar.b(false);
        }
        a(alVar);
        if (!android.text.TextUtils.isEmpty(strC) && b(strC).a() != 0) {
            this.l = false;
        }
        if (this.l) {
            return;
        }
        a(com.unisound.client.ErrorCode.ASR_TOKEN_ERROR, jniUscClient);
    }

    private void a(cn.yunzhisheng.asr.JniUscClient jniUscClient, java.lang.String str, boolean z) throws java.lang.Throwable {
        while (true) {
            java.lang.String strC = jniUscClient.c(60);
            if (strC.equals(cn.yunzhisheng.asr.JniUscClient.aA)) {
                return;
            } else {
                a(jniUscClient, str, strC, z);
            }
        }
    }

    private void a(com.unisound.sdk.al alVar) {
        com.unisound.common.y.c("NetRecognition --> onRecognitionResult=>" + alVar.toString());
        com.unisound.sdk.ak akVar = this.b;
        if (akVar != null) {
            akVar.a(alVar);
        }
    }

    private java.lang.String[] a(java.lang.String str) {
        int i = 0;
        if (str.contains("}{\"asr_recongize\"")) {
            java.lang.String[] strArrSplit = str.split("\\}\\{\"asr_recongize\"");
            while (i < strArrSplit.length) {
                if (i == 0) {
                    strArrSplit[i] = strArrSplit[i] + "}";
                } else if (i == strArrSplit.length - 1) {
                    strArrSplit[i] = "{\"asr_recongize\"" + strArrSplit[i];
                } else {
                    strArrSplit[i] = "{\"asr_recongize\"" + strArrSplit[i] + "}";
                }
                i++;
            }
            return strArrSplit;
        }
        if (!str.contains("}{\"gender\"")) {
            return new java.lang.String[]{str};
        }
        java.lang.String[] strArrSplit2 = str.split("\\}\\{\"gender\"");
        while (i < strArrSplit2.length) {
            if (i == 0) {
                strArrSplit2[i] = strArrSplit2[i] + "}";
            } else if (i == strArrSplit2.length - 1) {
                strArrSplit2[i] = "{\"gender\"" + strArrSplit2[i];
            } else {
                strArrSplit2[i] = "{\"gender\"" + strArrSplit2[i] + "}";
            }
            i++;
        }
        return strArrSplit2;
    }

    private com.unisound.sdk.cv b(java.lang.String str) {
        java.lang.String string;
        com.unisound.sdk.cv cvVar = new com.unisound.sdk.cv();
        com.unisound.common.y.d("partial=", str);
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            if (str.contains("returnCode")) {
                int i = jSONObject.getInt("returnCode");
                com.unisound.common.y.d("USCDEBUG", "returnCode=" + i);
                cvVar.a(i);
                if (i == 0) {
                    string = "";
                    com.unisound.common.y.d("errorInfo=");
                } else {
                    string = jSONObject.getString("errorInfo");
                    com.unisound.common.y.d("USCDEBUG", "errorInfo=" + string);
                }
                cvVar.a(string);
            }
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        return cvVar;
    }

    private void b(cn.yunzhisheng.asr.JniUscClient jniUscClient) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("PN=" + com.unisound.c.a.s);
        sb.append(":");
        sb.append("OS=0");
        sb.append(":");
        sb.append("CR=" + com.unisound.c.a.r);
        sb.append(":");
        sb.append("NT=" + this.e.aZ);
        sb.append(":");
        sb.append("MD=" + com.unisound.c.a.t);
        sb.append(":");
        sb.append("SV=" + com.unisound.common.an.a());
        sb.append(":");
        sb.append("RPT=" + this.e.bm());
        sb.append(":");
        sb.append("SID=" + this.e.bj());
        sb.append(":");
        sb.append("NPT=" + this.e.bo());
        sb.append(":");
        sb.append("IP=" + com.unisound.common.ae.a(this.j));
        sb.append(":");
        sb.append("EC=" + this.e.bn());
        sb.append("\t" + com.unisound.common.y.x + ":" + cn.yunzhisheng.asr.JniUscClient.l + ":" + cn.yunzhisheng.asr.JniUscClient.m);
        jniUscClient.a(15, sb.toString());
        this.e.Q(0);
        this.e.k(0L);
        this.e.x("");
        java.util.HashMap map = new java.util.HashMap();
        map.put("nlu_sendParams", sb.toString());
        com.unisound.common.y.c("collected_info = ", sb.toString());
        com.unisound.common.y.a(com.unisound.common.y.C, (java.lang.String) null, map, (java.lang.String) null, (java.lang.String) null, (java.lang.String) null);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x00d9  */
    private void c(cn.yunzhisheng.asr.JniUscClient jniUscClient) {
        java.lang.String str;
        com.unisound.sdk.i iVarBa = this.e.ba();
        if (iVarBa.a()) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            com.unisound.sdk.cu cuVarAW = this.e.aW();
            if (cuVarAW.f()) {
                jniUscClient.a(1015, 8);
                jniUscClient.a(1020, 1);
                jniUscClient.a(1019, this.e.bi());
                sb.append("serviceTypeName=");
                if (cuVarAW.g() == 1) {
                    str = "bindClient";
                } else if (cuVarAW.g() == 2) {
                    str = "recognizeUser";
                } else {
                    if (cuVarAW.g() == 5) {
                        str = "unBindClient";
                    }
                    sb.append(";");
                    sb.append("subSystemId=");
                    sb.append(cuVarAW.b());
                    sb.append(";");
                    sb.append("bindMode=");
                    sb.append(cuVarAW.a());
                    sb.append(";");
                    sb.append("customizedName=");
                    sb.append(cuVarAW.d());
                    sb.append(";");
                    sb.append("inputDataType=");
                    sb.append("audio");
                    sb.append(";");
                    sb.append("returnType=");
                    sb.append("json");
                    sb.append(";");
                    sb.append("scene=");
                    sb.append(cuVarAW.c());
                    sb.append(";");
                    com.unisound.common.y.c("vpr params:  ", sb.toString());
                    if (this.e.br() != null) {
                        sb.append(";");
                        sb.append(this.e.br());
                    }
                    java.util.HashMap map = new java.util.HashMap();
                    map.put("vpr_init", java.lang.String.valueOf(8));
                    map.put("vpr_md5_check", java.lang.String.valueOf(1));
                    map.put("[REDACTED]", this.e.bi());
                    map.put("vpr_sendParams", sb.toString());
                    com.unisound.common.y.a(com.unisound.common.y.A, (java.lang.String) null, map, (java.lang.String) null, (java.lang.String) null, (java.lang.String) null);
                }
                sb.append(str);
                sb.append(";");
                sb.append("subSystemId=");
                sb.append(cuVarAW.b());
                sb.append(";");
                sb.append("bindMode=");
                sb.append(cuVarAW.a());
                sb.append(";");
                sb.append("customizedName=");
                sb.append(cuVarAW.d());
                sb.append(";");
                sb.append("inputDataType=");
                sb.append("audio");
                sb.append(";");
                sb.append("returnType=");
                sb.append("json");
                sb.append(";");
                sb.append("scene=");
                sb.append(cuVarAW.c());
                sb.append(";");
                com.unisound.common.y.c("vpr params:  ", sb.toString());
                if (this.e.br() != null) {
                    sb.append(";");
                    sb.append(this.e.br());
                }
                java.util.HashMap map2 = new java.util.HashMap();
                map2.put("vpr_init", java.lang.String.valueOf(8));
                map2.put("vpr_md5_check", java.lang.String.valueOf(1));
                map2.put("[REDACTED]", this.e.bi());
                map2.put("vpr_sendParams", sb.toString());
                com.unisound.common.y.a(com.unisound.common.y.A, (java.lang.String) null, map2, (java.lang.String) null, (java.lang.String) null, (java.lang.String) null);
            }
            java.util.HashMap map3 = new java.util.HashMap();
            sb.append(iVarBa.toString());
            jniUscClient.a(34, sb.toString());
            map3.put("engine_parameter", iVarBa.toString());
            com.unisound.common.y.c("NetRecognition --> AsrParams : ", iVarBa.toString().replaceAll(":", "=").replaceAll("\\n", ";"));
            a(jniUscClient, this.e.aY());
            if (this.e.aG) {
                jniUscClient.a(20, this.e.aJ ? cn.yunzhisheng.asr.JniUscClient.r : cn.yunzhisheng.asr.JniUscClient.s);
            }
            if (this.e.aW != 0) {
                jniUscClient.a(32, this.e.aW);
            }
            jniUscClient.a(this.e.bf());
            if (!android.text.TextUtils.isEmpty(this.e.aq()) && "pcm".equals(this.e.aq())) {
                com.unisound.common.y.c("NetRecognition --> setAudioFormat : ", java.lang.Integer.valueOf(jniUscClient.a("pcm")));
            }
        }
        jniUscClient.a(9, this.e.aZ());
        jniUscClient.a(8, com.unisound.c.a.q);
        java.lang.String strA = com.unisound.c.a.a(this.e.aZ());
        jniUscClient.a(14, this.e.bu() != null ? this.e.bu() : strA);
        jniUscClient.a(22, strA);
        com.unisound.common.y.c("[REDACTED]", this.e.aZ(), "[REDACTED]", com.unisound.c.a.q, "[REDACTED]", strA, "[REDACTED]", strA);
        if (this.e.bh()) {
            jniUscClient.a(17, cn.yunzhisheng.asr.JniUscClient.p);
        }
        if (this.e.br() != null) {
            jniUscClient.a(cn.yunzhisheng.asr.JniUscClient.ac, this.e.br());
        }
    }

    private void d(cn.yunzhisheng.asr.JniUscClient jniUscClient) throws java.lang.Throwable {
        com.unisound.sdk.ak akVar = this.b;
        b();
        com.unisound.common.y.a(jniUscClient);
        if (akVar != null) {
            akVar.i();
        }
    }

    private void e(cn.yunzhisheng.asr.JniUscClient jniUscClient) throws java.lang.Throwable {
        com.unisound.sdk.ak akVar = this.b;
        b();
        com.unisound.common.y.a(jniUscClient);
        if (akVar != null) {
            akVar.m();
        }
    }

    private int f(cn.yunzhisheng.asr.JniUscClient jniUscClient) throws java.lang.Throwable {
        com.unisound.common.y.c("NetRecognition --> continue recognize");
        jniUscClient.b();
        if (this.e.ar()) {
            java.lang.String strAs = this.e.as();
            if (!android.text.TextUtils.isEmpty(strAs)) {
                com.unisound.common.j.a(strAs + java.io.File.separator + this.e.bj() + ".wav", 1, this.e.be());
            }
        }
        a(jniUscClient, this.f, true);
        if (!this.l) {
            return -1;
        }
        this.f = "";
        com.unisound.common.y.c("NetRecognition --> start called ");
        a(jniUscClient);
        com.unisound.common.y.c("RecognitionThread : Service Mode =  ", java.lang.Integer.valueOf(this.e.aQ()));
        jniUscClient.a(1015, this.e.aQ());
        jniUscClient.a(207, this.e.bs());
        int iA = jniUscClient.a();
        this.f = jniUscClient.c(21);
        this.e.x(this.f);
        a(com.unisound.client.SpeechConstants.ASR_EVENT_SESSIONID_CHANGED);
        com.unisound.common.y.c("NetRecognition --> sessionId = ", this.f);
        this.k = "";
        java.lang.String str = this.f;
        if (str != null && str.length() > 10) {
            this.k = this.f.substring(0, 10);
        }
        if (iA == 0) {
            return 0;
        }
        com.unisound.common.y.a(com.unisound.common.y.D, "error", (java.util.Map<java.lang.String, java.lang.String>) null, (java.lang.String) null, java.lang.String.valueOf(iA), (java.lang.String) null);
        com.unisound.common.y.c("NetRecognition --> continue Recognition start error occured! , startCode = ", java.lang.Integer.valueOf(iA), ", sessionId = ", this.f);
        a(iA, jniUscClient);
        jniUscClient.e();
        this.e.bc();
        return -1;
    }

    public void a(com.unisound.sdk.ak akVar) {
        this.b = akVar;
    }

    public void a(java.util.Collection<? extends byte[]> collection) {
        this.c.addAll(collection);
    }

    public void a(java.util.List<byte[]> list) {
        java.util.Iterator<byte[]> it = list.iterator();
        while (it.hasNext()) {
            this.c.add(it.next());
        }
    }

    public void a(byte[] bArr) {
        this.d.a(bArr, 0, bArr.length);
        if (this.d.b()) {
            this.c.add(bArr);
        }
    }

    public boolean a() {
        return this.g;
    }

    public void b() throws java.lang.Throwable {
        this.g = true;
        if (com.unisound.common.y.s) {
            com.unisound.common.j.a("/sdcard/asrtest/" + this.m + ".wav", 1, this.e.be());
        }
    }

    public void c() throws java.lang.Throwable {
        this.b = null;
        b();
    }

    public boolean d() {
        return this.b == null;
    }

    public java.lang.String e() {
        return this.f;
    }

    public void f() {
        com.unisound.sdk.ak akVar = this.b;
        if (akVar != null) {
            akVar.A();
        }
    }

    public void g() throws java.lang.Throwable {
        com.unisound.common.y.c("NetRecognitionThread waitEnd called");
        c();
        if (isAlive()) {
            try {
                join(3900L);
                com.unisound.common.y.c("NetRecognitionThread::waitEnd()");
            } catch (java.lang.InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public java.lang.String h() {
        return this.h;
    }

    /* JADX WARN: Code duplicated, block: B:114:0x038f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:115:? A[LOOP:0: B:107:0x0120->B:115:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x0257 A[Catch: Exception -> 0x03aa, PHI: r7
  0x0257: PHI (r7v12 long) = (r7v10 long), (r7v18 long), (r7v18 long), (r7v18 long), (r7v18 long), (r7v18 long), (r7v10 long) binds: [B:19:0x012c, B:69:0x022a, B:63:0x0204, B:60:0x01e8, B:57:0x01d6, B:55:0x01cd, B:27:0x0143] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {Exception -> 0x03aa, blocks: (B:18:0x0120, B:20:0x012e, B:22:0x0131, B:24:0x0137, B:26:0x013d, B:29:0x0147, B:31:0x014d, B:33:0x0154, B:35:0x0158, B:44:0x0186, B:46:0x018e, B:48:0x019a, B:49:0x01bc, B:51:0x01c0, B:52:0x01c5, B:55:0x01cd, B:57:0x01d6, B:60:0x01e8, B:63:0x0204, B:66:0x021e, B:68:0x0226, B:71:0x022d, B:37:0x015c, B:39:0x0164, B:43:0x017c, B:73:0x0257, B:75:0x025f, B:77:0x0267, B:80:0x0273, B:82:0x0277, B:84:0x027f, B:101:0x0389, B:103:0x038f), top: B:107:0x0120 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x025f A[Catch: Exception -> 0x03aa, TryCatch #0 {Exception -> 0x03aa, blocks: (B:18:0x0120, B:20:0x012e, B:22:0x0131, B:24:0x0137, B:26:0x013d, B:29:0x0147, B:31:0x014d, B:33:0x0154, B:35:0x0158, B:44:0x0186, B:46:0x018e, B:48:0x019a, B:49:0x01bc, B:51:0x01c0, B:52:0x01c5, B:55:0x01cd, B:57:0x01d6, B:60:0x01e8, B:63:0x0204, B:66:0x021e, B:68:0x0226, B:71:0x022d, B:37:0x015c, B:39:0x0164, B:43:0x017c, B:73:0x0257, B:75:0x025f, B:77:0x0267, B:80:0x0273, B:82:0x0277, B:84:0x027f, B:101:0x0389, B:103:0x038f), top: B:107:0x0120 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x0273 A[Catch: Exception -> 0x03aa, TryCatch #0 {Exception -> 0x03aa, blocks: (B:18:0x0120, B:20:0x012e, B:22:0x0131, B:24:0x0137, B:26:0x013d, B:29:0x0147, B:31:0x014d, B:33:0x0154, B:35:0x0158, B:44:0x0186, B:46:0x018e, B:48:0x019a, B:49:0x01bc, B:51:0x01c0, B:52:0x01c5, B:55:0x01cd, B:57:0x01d6, B:60:0x01e8, B:63:0x0204, B:66:0x021e, B:68:0x0226, B:71:0x022d, B:37:0x015c, B:39:0x0164, B:43:0x017c, B:73:0x0257, B:75:0x025f, B:77:0x0267, B:80:0x0273, B:82:0x0277, B:84:0x027f, B:101:0x0389, B:103:0x038f), top: B:107:0x0120 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x0277 A[Catch: Exception -> 0x03aa, TryCatch #0 {Exception -> 0x03aa, blocks: (B:18:0x0120, B:20:0x012e, B:22:0x0131, B:24:0x0137, B:26:0x013d, B:29:0x0147, B:31:0x014d, B:33:0x0154, B:35:0x0158, B:44:0x0186, B:46:0x018e, B:48:0x019a, B:49:0x01bc, B:51:0x01c0, B:52:0x01c5, B:55:0x01cd, B:57:0x01d6, B:60:0x01e8, B:63:0x0204, B:66:0x021e, B:68:0x0226, B:71:0x022d, B:37:0x015c, B:39:0x0164, B:43:0x017c, B:73:0x0257, B:75:0x025f, B:77:0x0267, B:80:0x0273, B:82:0x0277, B:84:0x027f, B:101:0x0389, B:103:0x038f), top: B:107:0x0120 }] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws java.lang.Throwable {
        com.unisound.common.y.c("NetRecogniton -> run start");
        if (com.unisound.common.y.l) {
            com.unisound.common.y.d("RecognitionThread -> ThreadName = ", java.lang.Thread.currentThread().getName(), ", ThreadId = ", java.lang.Long.valueOf(java.lang.Thread.currentThread().getId()));
        }
        com.unisound.common.y.g("RecognitionThread start");
        cn.yunzhisheng.asr.JniUscClient jniUscClient = new cn.yunzhisheng.asr.JniUscClient();
        a(jniUscClient);
        com.unisound.common.y.c("RecognitionThread : Service Mode =  ", java.lang.Integer.valueOf(this.e.aQ()));
        jniUscClient.a(1015, this.e.aQ());
        jniUscClient.a(207, this.e.bs());
        this.f = "";
        com.unisound.common.y.c("NetRecognition --> start called ");
        int iA = jniUscClient.a();
        this.f = jniUscClient.c(21);
        this.e.x(this.f);
        a(com.unisound.client.SpeechConstants.ASR_EVENT_SESSIONID_CHANGED);
        com.unisound.common.y.c("NetRecognition --> sessionId = ", this.f);
        this.k = "";
        java.lang.String str = this.f;
        if (str != null && str.length() > 10) {
            this.k = this.f.substring(0, 10);
        }
        if (iA != 0) {
            com.unisound.common.y.a(com.unisound.common.y.D, "error", (java.util.Map<java.lang.String, java.lang.String>) null, (java.lang.String) null, java.lang.String.valueOf(iA), (java.lang.String) null);
            com.unisound.common.y.c("NetRecognition --> start error occured! , startCode = ", java.lang.Integer.valueOf(iA), ", sessionId = ", this.f);
            a(iA, jniUscClient);
            jniUscClient.e();
            this.e.bc();
            return;
        }
        com.unisound.common.y.a(com.unisound.common.y.D, com.unisound.common.y.J, (java.util.Map<java.lang.String, java.lang.String>) null, (java.lang.String) null, (java.lang.String) null, (java.lang.String) null);
        if (d()) {
            jniUscClient.d();
            com.unisound.common.y.a(com.unisound.common.y.G, (java.lang.String) null, (java.util.Map<java.lang.String, java.lang.String>) null, (java.lang.String) null, (java.lang.String) null, "cancel(start)");
            com.unisound.common.y.c("NetRecognition --> cancel(start)");
            jniUscClient.e();
            return;
        }
        long length = 0;
        while (true) {
            try {
                byte[] bArrPoll = this.c.poll(30L, java.util.concurrent.TimeUnit.MILLISECONDS);
                if (bArrPoll == null) {
                    if (!this.e.al() && this.e.an()) {
                        int iF = f(jniUscClient);
                        this.e.v(false);
                        if (iF != 0) {
                            break;
                        }
                        if (!this.g) {
                        }
                        if (d()) {
                            jniUscClient.d();
                            com.unisound.common.y.a(com.unisound.common.y.E, (java.lang.String) null, (java.util.Map<java.lang.String, java.lang.String>) null, (java.lang.String) null, (java.lang.String) null, "cancel(recognizer)");
                            com.unisound.common.y.c("NetRecognition --> cancel(recognizer)");
                            jniUscClient.e();
                            return;
                        }
                    } else if (!this.g && this.c.isEmpty()) {
                        com.unisound.common.y.c("NetRecognition --> break");
                        break;
                    } else if (d()) {
                        jniUscClient.d();
                        com.unisound.common.y.a(com.unisound.common.y.E, (java.lang.String) null, (java.util.Map<java.lang.String, java.lang.String>) null, (java.lang.String) null, (java.lang.String) null, "cancel(recognizer)");
                        com.unisound.common.y.c("NetRecognition --> cancel(recognizer)");
                        jniUscClient.e();
                        return;
                    }
                } else if (bArrPoll.length != 1 || (bArrPoll[0] != 100 && bArrPoll[0] != 99)) {
                    int iA2 = !d() ? jniUscClient.a(bArrPoll, bArrPoll.length) : 0;
                    if ((com.unisound.common.y.r || com.unisound.common.y.s) && !android.text.TextUtils.isEmpty(this.m)) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("/sdcard/asrtest/");
                        sb.append(this.m);
                        sb.append(com.unisound.common.y.s ? ".wav" : ".pcm");
                        com.unisound.common.j.a(bArrPoll, sb.toString());
                    }
                    if (this.e.ar()) {
                        java.lang.String strAs = this.e.as();
                        if (!android.text.TextUtils.isEmpty(strAs)) {
                            com.unisound.common.j.a(bArrPoll, strAs + java.io.File.separator + this.e.bj() + ".wav");
                        }
                    }
                    if (com.unisound.common.y.q) {
                        com.unisound.common.j.a(bArrPoll, "/sdcard/asrtest/oneshotonline.pcm");
                    }
                    length += (long) bArrPoll.length;
                    if (iA2 >= 0 && iA2 != 5) {
                        a(jniUscClient, this.f, false);
                    } else if (iA2 != 5) {
                        if (iA2 != -30002) {
                            if (iA2 != -30001) {
                                if (iA2 == -91155 && this.e.an()) {
                                    if (f(jniUscClient) == 0) {
                                        break;
                                    } else {
                                        break;
                                    }
                                }
                                com.unisound.common.y.a(com.unisound.common.y.E, "error", (java.util.Map<java.lang.String, java.lang.String>) null, (java.lang.String) null, java.lang.String.valueOf(iA2), (java.lang.String) null);
                                com.unisound.common.y.c("NetRecognition --> error:", java.lang.Integer.valueOf(iA2));
                                a(iA2, jniUscClient);
                                jniUscClient.e();
                                this.e.bc();
                                return;
                            }
                            com.unisound.common.y.a(com.unisound.common.y.E, (java.lang.String) null, (java.util.Map<java.lang.String, java.lang.String>) null, (java.lang.String) null, (java.lang.String) null, "vad timeout");
                            com.unisound.common.y.c("NetRecognition --> vad timeout");
                        } else {
                            com.unisound.common.y.a(com.unisound.common.y.E, (java.lang.String) null, (java.util.Map<java.lang.String, java.lang.String>) null, (java.lang.String) null, (java.lang.String) null, "max speech timeout");
                            com.unisound.common.y.c("NetRecognition --> max speech timeout");
                            e(jniUscClient);
                        }
                    } else {
                        com.unisound.common.y.c("NetRecognition --> server vad stop");
                        f();
                    }
                    if (!this.e.al()) {
                        if (!this.g) {
                        }
                        if (d()) {
                            jniUscClient.d();
                            com.unisound.common.y.a(com.unisound.common.y.E, (java.lang.String) null, (java.util.Map<java.lang.String, java.lang.String>) null, (java.lang.String) null, (java.lang.String) null, "cancel(recognizer)");
                            com.unisound.common.y.c("NetRecognition --> cancel(recognizer)");
                            jniUscClient.e();
                            return;
                        }
                    } else {
                        if (!this.g) {
                        }
                        if (d()) {
                            jniUscClient.d();
                            com.unisound.common.y.a(com.unisound.common.y.E, (java.lang.String) null, (java.util.Map<java.lang.String, java.lang.String>) null, (java.lang.String) null, (java.lang.String) null, "cancel(recognizer)");
                            com.unisound.common.y.c("NetRecognition --> cancel(recognizer)");
                            jniUscClient.e();
                            return;
                        }
                    }
                } else {
                    if (!this.e.an()) {
                        break;
                    }
                    if (!this.e.al()) {
                        if (!this.g) {
                        }
                        if (d()) {
                            jniUscClient.d();
                            com.unisound.common.y.a(com.unisound.common.y.E, (java.lang.String) null, (java.util.Map<java.lang.String, java.lang.String>) null, (java.lang.String) null, (java.lang.String) null, "cancel(recognizer)");
                            com.unisound.common.y.c("NetRecognition --> cancel(recognizer)");
                            jniUscClient.e();
                            return;
                        }
                    } else {
                        if (!this.g) {
                        }
                        if (d()) {
                            jniUscClient.d();
                            com.unisound.common.y.a(com.unisound.common.y.E, (java.lang.String) null, (java.util.Map<java.lang.String, java.lang.String>) null, (java.lang.String) null, (java.lang.String) null, "cancel(recognizer)");
                            com.unisound.common.y.c("NetRecognition --> cancel(recognizer)");
                            jniUscClient.e();
                            return;
                        }
                    }
                }
            } catch (java.lang.Exception unused) {
                com.unisound.common.y.a("NetRecognition --> exception");
                com.unisound.common.y.a(com.unisound.common.y.E, "error", (java.util.Map<java.lang.String, java.lang.String>) null, (java.lang.String) null, java.lang.String.valueOf(com.unisound.client.ErrorCode.RECOGNITION_EXCEPTION), "recognition exception");
                a(com.unisound.client.ErrorCode.RECOGNITION_EXCEPTION, jniUscClient);
                cn.yunzhisheng.asr.JniUscClient.l = com.unisound.client.ErrorCode.RECOGNITION_EXCEPTION;
                cn.yunzhisheng.asr.JniUscClient.m = 0;
                jniUscClient.e();
                return;
            }
        }
        this.e.j(java.lang.System.currentTimeMillis());
        this.h = "";
        if (!this.e.an()) {
            a(jniUscClient, "Stop");
        }
        com.unisound.common.y.c("NetRecognition --> stop called , bufferLength = ", java.lang.Long.valueOf(length), ", sessionId = ", this.k);
        int iB = jniUscClient.b();
        if (this.e.ar()) {
            java.lang.String strAs2 = this.e.as();
            if (!android.text.TextUtils.isEmpty(strAs2)) {
                com.unisound.common.j.a(strAs2 + java.io.File.separator + this.e.bj() + ".wav", 1, this.e.be());
            }
        }
        if (iB < 0) {
            com.unisound.common.y.c("NetRecognition --> stop error occured! , stopCode = ", java.lang.Integer.valueOf(iB), ", sessionId = ", this.f);
            com.unisound.common.y.a(com.unisound.common.y.F, "error", (java.util.Map<java.lang.String, java.lang.String>) null, (java.lang.String) null, java.lang.String.valueOf(iB), (java.lang.String) null);
            a(iB, jniUscClient);
            jniUscClient.e();
            return;
        }
        com.unisound.common.y.a(com.unisound.common.y.F, com.unisound.common.y.J, (java.util.Map<java.lang.String, java.lang.String>) null, (java.lang.String) null, (java.lang.String) null, (java.lang.String) null);
        if (this.e.aW != 0) {
            this.e.aY = com.unisound.common.t.a(jniUscClient.c(25));
            com.unisound.common.y.c("NetRecognition --> asrRspSpeakerInfo=", java.lang.Integer.valueOf(this.e.aY));
        }
        a(jniUscClient, this.f, true);
        d(jniUscClient);
        com.unisound.common.y.c("NetRecognition --> released");
        jniUscClient.e();
        this.c.clear();
        com.unisound.common.y.g("RecognitionThread stop");
        com.unisound.common.y.c("NetRecognition --> run stop");
    }
}
