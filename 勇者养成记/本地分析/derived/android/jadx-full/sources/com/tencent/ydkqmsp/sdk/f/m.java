package com.tencent.ydkqmsp.sdk.f;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class m {
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0124, code lost:
    
        if (r9 != null) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x013f, code lost:
    
        if (r9 != null) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x015a, code lost:
    
        if (r9 != null) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x015c, code lost:
    
        r9.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int a(java.lang.String r9, java.lang.String r10) {
        /*
            Method dump skipped, instruction units count: 395
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.ydkqmsp.sdk.f.m.a(java.lang.String, java.lang.String):int");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void a(com.tencent.ydkqmsp.sdk.f.i iVar, java.io.File file) {
        java.lang.StringBuilder sb;
        byte[] bArr = new byte[8192];
        com.tencent.ydkqmsp.sdk.f.j jVarA = null;
        try {
            jVarA = com.tencent.ydkqmsp.sdk.f.j.a(new java.io.FileOutputStream(file));
            while (true) {
                int i = iVar.read(bArr, 0, 8192);
                if (i == -1) {
                    break;
                } else {
                    jVarA.write(bArr, 0, i);
                }
                sb.append("unZipFile2 Unzip the error");
                sb.append(e);
                java.lang.String string = sb.toString();
                return;
            }
            if (jVarA == null) {
                return;
            }
            try {
            } catch (java.io.IOException e) {
                e = e;
                sb = new java.lang.StringBuilder();
            }
        } catch (java.lang.Exception e2) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("unZipFile2 Unzip the error");
            sb2.append(e2);
            com.tencent.ydkqmsp.sdk.f.g.b("Qp.ZU", 1, sb2.toString());
            if (jVarA == null) {
                return;
            }
            try {
            } catch (java.io.IOException e3) {
                e = e3;
                sb = new java.lang.StringBuilder();
            }
        } finally {
            if (jVarA != null) {
                try {
                    jVarA.close();
                } catch (java.io.IOException e4) {
                    com.tencent.ydkqmsp.sdk.f.g.b("Qp.ZU", 1, "unZipFile2 Unzip the error" + e4);
                }
            }
        }
    }
}
