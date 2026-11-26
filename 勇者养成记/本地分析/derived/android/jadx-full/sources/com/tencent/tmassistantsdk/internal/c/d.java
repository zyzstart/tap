package com.tencent.tmassistantsdk.internal.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class d extends com.tencent.tmassistantbase.network.f {
    protected com.tencent.tmassistantsdk.internal.c.c d = null;

    public void a(com.tencent.tmassistantsdk.internal.c.c cVar) {
        this.d = cVar;
    }

    @Override // com.tencent.tmassistantbase.network.f
    protected void a(byte[] bArr, byte[] bArr2, int i) {
        java.lang.String str;
        java.lang.String str2;
        byte[] bArr3;
        if (bArr2 == null) {
            com.tencent.tmassistantsdk.internal.c.c cVar = this.d;
            if (cVar != null) {
                cVar.a(this, false);
                return;
            }
            return;
        }
        if (this.d == null) {
            str = "LogReportHttpRequest";
            str2 = "mListener is null !";
        } else {
            if (bArr2 == null || bArr2.length <= 4 || i != 0) {
                this.d.a(this, false);
                return;
            }
            com.tencent.tmassistantbase.jce.Response responseA = com.tencent.tmassistantbase.common.d.a(bArr2);
            com.qq.taf.jce.JceStruct jceStructB = com.tencent.tmassistantbase.common.d.b(((com.tencent.tmassistantbase.jce.Request) com.tencent.tmassistantbase.common.d.b(bArr, com.tencent.tmassistantbase.jce.Request.class)).body, com.tencent.tmassistantbase.jce.ReportLogRequest.class);
            if (responseA == null || (bArr3 = responseA.body) == null) {
                return;
            }
            com.qq.taf.jce.JceStruct jceStructA = com.tencent.tmassistantbase.common.d.a(jceStructB, bArr3);
            if (jceStructA instanceof com.tencent.tmassistantbase.jce.ReportLogResponse) {
                com.tencent.tmassistantbase.jce.ReportLogResponse reportLogResponse = (com.tencent.tmassistantbase.jce.ReportLogResponse) jceStructA;
                if (reportLogResponse.ret == 0) {
                    this.d.a(this, true);
                    return;
                }
                this.d.a(this, false);
                com.tencent.tmassistantbase.util.TMLog.i("LogReportHttpRequest", "response ret:" + reportLogResponse.ret);
                return;
            }
            str = "LogReportHttpRequest";
            str2 = "response isn't instanceof ReportLogResponse !";
        }
        com.tencent.tmassistantbase.util.TMLog.i(str, str2);
    }

    public boolean a(byte b, com.tencent.tmassistantsdk.internal.e.a.b bVar) {
        com.tencent.tmassistantbase.util.TMLog.i("LogReportHttpRequest", "sendLogDataToServer logType:" + ((int) b) + " logDataWrapper:" + bVar);
        if (bVar == null) {
            return false;
        }
        return super.a(com.tencent.tmassistantbase.common.d.a(com.tencent.tmassistantbase.common.d.b((com.tencent.tmassistantbase.jce.ReportLogRequest) com.tencent.tmassistantbase.common.d.a(b, bVar.b, com.tencent.tmassistantbase.util.k.b(com.tencent.tmassistantbase.util.k.a().b()), com.tencent.tmassistantbase.util.k.c(com.tencent.tmassistantbase.util.k.a().b()), ""))));
    }
}
