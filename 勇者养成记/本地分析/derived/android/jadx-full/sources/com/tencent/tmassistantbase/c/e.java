package com.tencent.tmassistantbase.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class e extends com.tencent.tmassistantbase.network.f {
    protected com.tencent.tmassistantbase.c.a d = null;

    public int a(java.util.ArrayList arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            com.tencent.tmassistantbase.jce.StatItem statItem = (com.tencent.tmassistantbase.jce.StatItem) it.next();
            com.tencent.tmassistantbase.util.TMLog.i("SDKREPORT", ">>sendRequest type = " + statItem.type + " data = " + com.tencent.tmassistantbase.util.s.a(statItem.records));
        }
        com.tencent.tmassistantbase.jce.StatReportRequest statReportRequest = new com.tencent.tmassistantbase.jce.StatReportRequest();
        statReportRequest.data = arrayList;
        com.tencent.tmassistantbase.jce.Request requestB = com.tencent.tmassistantbase.common.d.b(statReportRequest);
        int i = requestB.head.requestId;
        com.tencent.tmassistantbase.util.TMLog.i("StatReportEngine", "selfUpdateReport sendStatReportRequest ret = " + i);
        byte[] bArrA = com.tencent.tmassistantbase.common.d.a(requestB);
        com.tencent.tmassistantbase.util.TMLog.i("StatReportEngine", "selfUpdateReport sendStatReportRequest");
        super.a(bArrA);
        return i;
    }

    public void a(com.tencent.tmassistantbase.c.a aVar) {
        this.d = aVar;
    }

    @Override // com.tencent.tmassistantbase.network.f
    protected void a(byte[] bArr, byte[] bArr2, int i) {
        byte[] bArr3;
        com.qq.taf.jce.JceStruct jceStructA;
        com.tencent.tmassistantbase.c.a aVar;
        com.tencent.tmassistantbase.jce.ReqHead reqHead;
        com.tencent.tmassistantbase.util.TMLog.i("StatReportEngine", "errorCode: " + i);
        com.tencent.tmassistantbase.jce.Response responseA = com.tencent.tmassistantbase.common.d.a(bArr2);
        com.tencent.tmassistantbase.jce.Request request = (com.tencent.tmassistantbase.jce.Request) com.tencent.tmassistantbase.common.d.b(bArr, com.tencent.tmassistantbase.jce.Request.class);
        int i2 = (request == null || (reqHead = request.head) == null) ? 0 : reqHead.requestId;
        if (bArr2 == null) {
            com.tencent.tmassistantbase.util.TMLog.i("StatReportEngine", "response is null");
            this.d.a(i2, null, null, i);
            return;
        }
        if (responseA == null || (bArr3 = responseA.body) == null || (jceStructA = com.tencent.tmassistantbase.common.d.a(bArr3, com.tencent.tmassistantbase.jce.StatReportResponse.class)) == null || (aVar = this.d) == null || i != 0) {
            this.d.a(i2, null, null, i);
        } else if (jceStructA instanceof com.tencent.tmassistantbase.jce.StatReportResponse) {
            com.tencent.tmassistantbase.jce.StatReportResponse statReportResponse = (com.tencent.tmassistantbase.jce.StatReportResponse) jceStructA;
            int i3 = statReportResponse.ret;
            if (i3 == 0) {
                aVar.a(i2, null, statReportResponse, 0);
            } else {
                aVar.a(i2, null, statReportResponse, i3);
            }
        }
        com.tencent.tmassistantbase.util.TMLog.i("StatReportEngine", "exit");
    }
}
