package com.tencent.tmapkupdatesdk.internal.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f991a = new byte[4096];

    private void a(com.tencent.tmapkupdatesdk.internal.a.b bVar, java.io.DataInputStream dataInputStream, java.io.DataOutputStream dataOutputStream) throws java.io.IOException {
        com.tencent.tmapkupdatesdk.internal.a.g.a(bVar, dataOutputStream);
        int i = bVar.h;
        int i2 = 0;
        while (i > 0 && i2 >= 0) {
            i2 = dataInputStream.read(this.f991a, 0, i <= 4096 ? i : 4096);
            if (i2 > 0) {
                dataOutputStream.write(this.f991a, 0, i2);
                i -= i2;
            }
        }
        if (bVar.a()) {
            com.tencent.tmapkupdatesdk.internal.a.c.a(bVar, dataOutputStream);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void a(com.tencent.tmapkupdatesdk.internal.a.b bVar, java.io.RandomAccessFile randomAccessFile, com.tencent.tmapkupdatesdk.internal.a.h hVar, java.io.DataOutputStream dataOutputStream) throws java.lang.Exception {
        java.lang.String str = new java.lang.String(bVar.s, com.unisound.b.f.b);
        com.tencent.tmapkupdatesdk.internal.a.b bVarB = hVar.b(str);
        if (bVarB == null) {
            throw new java.lang.Exception();
        }
        bVar.d = bVarB.d;
        bVar.h = bVarB.h;
        bVar.g = bVarB.g;
        bVar.k = bVarB.k;
        bVar.t = bVarB.t;
        bVar.l = bVarB.l;
        bVar.u = bVarB.u;
        com.tencent.tmapkupdatesdk.internal.a.g.a(bVar, dataOutputStream);
        int i = bVar.h;
        if (i > 0) {
            randomAccessFile.seek(hVar.c(str));
            while (i > 0) {
                int i2 = randomAccessFile.read(this.f991a, 0, i <= 4096 ? i : 4096);
                if (i2 > 0) {
                    dataOutputStream.write(this.f991a, 0, i2);
                    i -= i2;
                }
            }
        }
        if (bVar.a()) {
            com.tencent.tmapkupdatesdk.internal.a.c.a(bVar, dataOutputStream);
        }
    }

    public static int b(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.tencent.tmassistantbase.util.TMLog.i("GenNewApkV2", "enter");
        com.tencent.tmassistantbase.util.TMLog.i("GenNewApkV2", "packageName: " + str + ", patchPath: " + str2 + ", newGenApkPath: " + str3);
        android.content.pm.PackageManager packageManager = com.tencent.tmapkupdatesdk.internal.logic.protocol.b.a().b().getPackageManager();
        try {
            android.content.pm.PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo == null) {
                com.tencent.tmassistantbase.util.TMLog.i("GenNewApkV2", "exit");
                return -1;
            }
            int iA = new com.tencent.tmapkupdatesdk.internal.a.e().a(packageInfo.applicationInfo.sourceDir, str2, str3);
            if (iA == 0) {
                com.tencent.tmassistantbase.util.TMLog.i("GenNewApkV2", "genNewApk succeed");
                if (packageManager.getPackageArchiveInfo(str3, 1) == null) {
                    com.tencent.tmassistantbase.util.TMLog.i("GenNewApkV2", "exit");
                    return -11;
                }
            } else {
                com.tencent.tmassistantbase.util.TMLog.i("GenNewApkV2", "genNewApk failed errcode: " + iA);
            }
            com.tencent.tmassistantbase.util.TMLog.i("GenNewApkV2", "exit");
            return iA;
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            com.tencent.tmassistantbase.util.TMLog.e("GenNewApkV2", "exception: ", e);
            return -1;
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0145 */
    /* JADX WARN: Code duplicated, block: B:132:0x01b3 A[EXC_TOP_SPLITTER, PHI: r2 r4
  0x01b3: PHI (r2v5 int) = (r2v3 int), (r2v0 int), (r2v0 int) binds: [B:107:0x01b1, B:47:0x00f2, B:44:0x00ec] A[DONT_GENERATE, DONT_INLINE]
  0x01b3: PHI (r4v3 java.io.DataInputStream) = (r4v2 java.io.DataInputStream), (r4v5 java.io.DataInputStream), (r4v5 java.io.DataInputStream) binds: [B:107:0x01b1, B:47:0x00f2, B:44:0x00ec] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:152:0x0191 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:166:0x01a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x0136 -> B:162:0x0172). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int a(java.lang.String r8, java.lang.String r9, java.lang.String r10) {
        /*
            Method dump skipped, instruction units count: 512
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tmapkupdatesdk.internal.a.e.a(java.lang.String, java.lang.String, java.lang.String):int");
    }
}
