package com.tencent.tmdownloader.internal.logreport;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class h extends com.tencent.tmassistantbase.network.f {
    protected com.tencent.tmdownloader.internal.logreport.f d = null;

    public void a(com.tencent.tmdownloader.internal.logreport.f fVar) {
        this.d = fVar;
    }

    @Override // com.tencent.tmassistantbase.network.f
    protected void a(byte[] bArr, byte[] bArr2, int i) {
        java.lang.String str;
        java.lang.String str2;
        byte[] bArr3;
        com.tencent.tmassistantbase.util.TMLog.i("LogReportHttpRequest", "http onFinished! + errorCode:" + i);
        if (bArr2 == null || i != 0) {
            com.tencent.tmdownloader.internal.logreport.f fVar = this.d;
            if (fVar != null) {
                fVar.a(this, false);
                return;
            }
            return;
        }
        if (this.d != null) {
            com.tencent.tmassistantbase.jce.Response responseA = com.tencent.tmassistantbase.common.d.a(bArr2);
            com.qq.taf.jce.JceStruct jceStructB = com.tencent.tmassistantbase.common.d.b(((com.tencent.tmassistantbase.jce.Request) com.tencent.tmassistantbase.common.d.b(bArr, com.tencent.tmassistantbase.jce.Request.class)).body, com.tencent.tmassistantbase.jce.ReportLogRequest.class);
            com.tencent.tmassistantbase.util.TMLog.i("LogReportHttpRequest", "jceResp.head.ret:" + responseA.head.ret);
            if (responseA == null || (bArr3 = responseA.body) == null || responseA.head.ret != 0) {
                this.d.a(this, false);
                str = "LogReportHttpRequest";
                str2 = "jceResp is null !";
            } else {
                com.qq.taf.jce.JceStruct jceStructA = com.tencent.tmassistantbase.common.d.a(jceStructB, bArr3);
                if (jceStructA == null) {
                    str = "LogReportHttpRequest";
                    str2 = "jceResponse is null !";
                } else {
                    if (jceStructA instanceof com.tencent.tmassistantbase.jce.ReportLogResponse) {
                        if (((com.tencent.tmassistantbase.jce.ReportLogResponse) jceStructA).ret == 0) {
                            this.d.a(this, true);
                            return;
                        } else {
                            this.d.a(this, false);
                            return;
                        }
                    }
                    str = "LogReportHttpRequest";
                    str2 = "response isn't instanceof ReportLogResponse !";
                }
            }
            com.tencent.tmassistantbase.util.TMLog.i(str, str2);
        }
    }

    public boolean a(byte b, com.tencent.tmdownloader.internal.b.c.b bVar) {
        if (bVar == null) {
            return false;
        }
        com.tencent.tmassistantbase.jce.ReportLogRequest reportLogRequest = (com.tencent.tmassistantbase.jce.ReportLogRequest) com.tencent.tmassistantbase.common.d.a(b, bVar.b, com.tencent.tmassistantbase.util.k.b(com.tencent.tmassistantbase.util.k.a().b()), com.tencent.tmassistantbase.util.k.c(com.tencent.tmassistantbase.util.k.a().b()), "");
        byte[] bArrA = com.tencent.tmassistantbase.common.d.a(com.tencent.tmassistantbase.common.d.b(reportLogRequest));
        com.tencent.tmassistantbase.util.TMLog.i("LogReportHttpRequest", "logReport:" + reportLogRequest + " dataSize:" + bVar.b.size());
        return super.a(bArrA);
    }
}
