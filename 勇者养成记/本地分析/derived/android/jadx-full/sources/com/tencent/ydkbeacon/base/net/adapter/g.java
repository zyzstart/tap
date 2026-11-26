package com.tencent.ydkbeacon.base.net.adapter;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class g extends com.tencent.ydkbeacon.base.net.adapter.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tencent.ydkbeacon.base.net.b.c f1221a = new com.tencent.ydkbeacon.base.net.b.e();
    private com.tencent.ydkbeacon.base.net.b.c b = new com.tencent.ydkbeacon.base.net.b.d();

    private g() {
    }

    public static com.tencent.ydkbeacon.base.net.adapter.c a() {
        return new com.tencent.ydkbeacon.base.net.adapter.g();
    }

    private java.net.Socket a(java.lang.String str, int i) throws java.net.SocketException {
        com.tencent.ydkbeacon.a.e.c.a("SocketAdapter", "create socket domain: %s, port: %d", str, java.lang.Integer.valueOf(i));
        java.net.Socket socket = new java.net.Socket(java.net.InetAddress.getByName(str).getHostAddress(), i);
        socket.setSoTimeout(30000);
        return socket;
    }

    private void a(com.tencent.ydkbeacon.base.net.a.b bVar, java.lang.String str, com.tencent.ydkbeacon.pack.SocketResponsePackage socketResponsePackage) {
        java.lang.String str2 = socketResponsePackage.msg;
        if (str2 == null || !str2.equals("decrypt Data fail!")) {
            bVar.a(socketResponsePackage.body);
        } else {
            bVar.a(new com.tencent.ydkbeacon.base.net.e(str, "405", socketResponsePackage.statusCode, "server encrypt-status error!"));
        }
    }

    private void a(java.net.Socket socket, com.tencent.ydkbeacon.pack.SocketRequestPackage socketRequestPackage) throws java.io.IOException {
        com.tencent.ydkbeacon.pack.b bVar = new com.tencent.ydkbeacon.pack.b();
        socketRequestPackage.writeTo(bVar);
        java.io.OutputStream outputStream = socket.getOutputStream();
        byte[] bArrB = bVar.b();
        outputStream.write(a(bArrB, bArrB.length));
        outputStream.flush();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private byte[] a(java.net.Socket socket, boolean z) throws java.lang.Throwable {
        java.lang.Throwable th;
        java.io.InputStream inputStream;
        java.io.ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            inputStream = socket.getInputStream();
            try {
                java.io.ByteArrayOutputStream byteArrayOutputStream2 = new java.io.ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int i = inputStream.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        byteArrayOutputStream2.write(bArr, 0, i);
                    }
                    byteArrayOutputStream2.flush();
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    if (!z) {
                        java.nio.ByteBuffer byteBufferAllocate = java.nio.ByteBuffer.allocate(byteArray.length - 4);
                        byteBufferAllocate.put(byteArray, 2, byteArray.length - 4);
                        byteArray = byteBufferAllocate.array();
                    }
                    byteArrayOutputStream2.close();
                    inputStream.close();
                    com.tencent.ydkbeacon.a.e.b.a(inputStream, byteArrayOutputStream2);
                    return byteArray;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    try {
                        com.tencent.ydkbeacon.a.e.c.a(th);
                        com.tencent.ydkbeacon.a.e.b.a(inputStream, byteArrayOutputStream);
                        throw th;
                    } catch (java.lang.Throwable th3) {
                        com.tencent.ydkbeacon.a.e.b.a(inputStream, byteArrayOutputStream);
                        throw th3;
                    }
                }
            } catch (java.lang.Throwable th4) {
                th = th4;
            }
        } catch (java.lang.Throwable th5) {
            th = th5;
            inputStream = null;
        }
    }

    private byte[] a(byte[] bArr, int i) {
        int i2 = i + 4;
        java.nio.ByteBuffer byteBufferAllocate = java.nio.ByteBuffer.allocate(i2);
        byteBufferAllocate.order(java.nio.ByteOrder.BIG_ENDIAN);
        byteBufferAllocate.putShort((short) (i2 & android.support.v4.internal.view.SupportMenu.USER_MASK));
        byteBufferAllocate.put(bArr);
        byteBufferAllocate.put((byte) 13);
        byteBufferAllocate.put((byte) 10);
        if (i >= 65532) {
            com.tencent.ydkbeacon.a.e.c.b("[Error] send bytes exceed 64kB will failure!", new java.lang.Object[0]);
        }
        return byteBufferAllocate.array();
    }

    @Override // com.tencent.ydkbeacon.base.net.adapter.c
    public void a(com.tencent.ydkbeacon.base.net.a.f fVar, com.tencent.ydkbeacon.base.net.a.b bVar) {
    }

    @Override // com.tencent.ydkbeacon.base.net.adapter.c
    public void a(com.tencent.ydkbeacon.base.net.a.k kVar, com.tencent.ydkbeacon.base.net.a.b bVar) {
        com.tencent.ydkbeacon.base.net.e eVar;
        java.lang.String strC = kVar.c();
        if (android.text.TextUtils.isEmpty(strC)) {
            return;
        }
        java.lang.String strName = kVar.g().name();
        try {
            java.net.Socket socketA = a(strC, kVar.e());
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("send data size: ");
            sb.append(kVar.b().length);
            com.tencent.ydkbeacon.a.e.c.a("SocketAdapter", 0, sb.toString(), new java.lang.Object[0]);
            a(socketA, (com.tencent.ydkbeacon.pack.SocketRequestPackage) this.b.a(kVar));
            byte[] bArrA = a(socketA, kVar.g() == com.tencent.ydkbeacon.base.net.RequestType.EVENT);
            if (bArrA == null || bArrA.length <= 0) {
                bVar.a(new com.tencent.ydkbeacon.base.net.e(strName, "402", -1, "receiveData == null"));
                return;
            }
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("receivedData: ");
            sb2.append(bArrA.length);
            com.tencent.ydkbeacon.a.e.c.a("SocketAdapter", 1, sb2.toString(), new java.lang.Object[0]);
            com.tencent.ydkbeacon.pack.SocketResponsePackage socketResponsePackage = (com.tencent.ydkbeacon.pack.SocketResponsePackage) this.f1221a.a(bArrA);
            if (socketResponsePackage == null) {
                bVar.a(new com.tencent.ydkbeacon.base.net.e(strName, "402", -1, "responsePackage == null"));
                return;
            }
            com.tencent.ydkbeacon.a.e.c.a("SocketAdapter", 2, "socket response code: %s, header: %s, msg: %s", java.lang.Integer.valueOf(socketResponsePackage.statusCode), socketResponsePackage.header, socketResponsePackage.msg);
            if (socketResponsePackage.statusCode == 200) {
                a(bVar, strName, socketResponsePackage);
                return;
            }
            int i = socketResponsePackage.statusCode;
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
            sb3.append("responsePackage msg: ");
            sb3.append(socketResponsePackage.msg);
            bVar.a(new com.tencent.ydkbeacon.base.net.e(strName, "402", i, sb3.toString()));
        } catch (java.net.ConnectException e) {
            eVar = new com.tencent.ydkbeacon.base.net.e(strName, "401", -1, " connect time more than 30s", e);
            bVar.a(eVar);
            com.tencent.ydkbeacon.base.net.d.c().b(this);
        } catch (java.net.SocketTimeoutException e2) {
            eVar = new com.tencent.ydkbeacon.base.net.e(strName, "401", -1, " request time more than 30s", e2);
            bVar.a(eVar);
            com.tencent.ydkbeacon.base.net.d.c().b(this);
        } catch (java.lang.Throwable th) {
            com.tencent.ydkbeacon.a.e.c.b("SocketAdapter socket request error: %s", th.getMessage());
            com.tencent.ydkbeacon.a.e.c.a(th);
            eVar = new com.tencent.ydkbeacon.base.net.e(strName, "449", -1, " unknown request error!", th);
            bVar.a(eVar);
            com.tencent.ydkbeacon.base.net.d.c().b(this);
        }
    }
}
