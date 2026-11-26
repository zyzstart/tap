package oicq.wlogin_sdk.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private oicq.wlogin_sdk.request.t f1683a;
    private int b;
    private int c;
    private oicq.wlogin_sdk.tools.ErrMsg d;

    public i(oicq.wlogin_sdk.request.t tVar, int i, int i2, oicq.wlogin_sdk.tools.ErrMsg errMsg) {
        this.f1683a = tVar;
        this.b = i;
        this.c = i2;
        this.d = errMsg;
    }

    int a(byte[] bArr) {
        byte[] bArr2;
        oicq.wlogin_sdk.tools.util.LOGI("notice len " + bArr.length, this.f1683a.f + "");
        byte[] bArrString_to_buf = oicq.wlogin_sdk.tools.util.string_to_buf("[REDACTED_HEX_CONSTANT]");
        java.nio.ByteBuffer byteBufferWrap = java.nio.ByteBuffer.wrap(bArr);
        byte[] bArr3 = null;
        try {
            byte[] bArr4 = new byte[byteBufferWrap.getShort()];
            byteBufferWrap.get(bArr4);
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(2, (java.security.interfaces.RSAPublicKey) java.security.KeyFactory.getInstance("RSA").generatePublic(new java.security.spec.X509EncodedKeySpec(bArrString_to_buf)));
            byte[] bArrDoFinal = cipher.doFinal(bArr4);
            if (bArrDoFinal != null && bArrDoFinal.length != 0) {
                java.nio.ByteBuffer byteBufferWrap2 = java.nio.ByteBuffer.wrap(bArrDoFinal);
                bArr2 = new byte[byteBufferWrap2.getShort()];
                try {
                    byteBufferWrap2.get(bArr2);
                    bArr3 = new byte[byteBufferWrap2.getShort()];
                    byteBufferWrap2.get(bArr3);
                    byteBufferWrap2.getInt();
                } catch (java.lang.Exception e) {
                    e = e;
                    oicq.wlogin_sdk.tools.util.printException(e);
                }
                if (bArr2 != null && bArr3 != null) {
                    int iLimit = byteBufferWrap.limit() - byteBufferWrap.position();
                    byte[] bArr5 = new byte[iLimit];
                    byteBufferWrap.get(bArr5);
                    byte[] bArrDecrypt = oicq.wlogin_sdk.tools.cryptor.decrypt(bArr5, 0, iLimit, bArr2);
                    if (bArrDecrypt == null || bArrDecrypt.length == 0 || !java.util.Arrays.equals(bArr3, oicq.wlogin_sdk.tools.MD5.toMD5Byte(bArrDecrypt))) {
                        return -1000;
                    }
                    java.nio.ByteBuffer byteBufferWrap3 = java.nio.ByteBuffer.wrap(bArrDecrypt);
                    byteBufferWrap3.getShort();
                    short s = byteBufferWrap3.getShort();
                    if (s == 0) {
                        return -1000;
                    }
                    for (int i = 0; i < s; i++) {
                        short s2 = byteBufferWrap3.getShort();
                        byte[] bArr6 = new byte[byteBufferWrap3.getShort()];
                        byteBufferWrap3.get(bArr6);
                        if (s2 == 1281) {
                            java.nio.ByteBuffer byteBufferWrap4 = java.nio.ByteBuffer.wrap(bArr6);
                            int i2 = byteBufferWrap4.getInt();
                            oicq.wlogin_sdk.tools.util.LOGI("what " + i2, "");
                            if (i2 != 0) {
                                return -1000;
                            }
                            int i3 = byteBufferWrap4.getShort();
                            byte[] bArr7 = new byte[i3];
                            oicq.wlogin_sdk.tools.util.LOGI("msg len " + i3, "");
                            if (i3 == 0) {
                                return -1000;
                            }
                            byteBufferWrap4.get(bArr7);
                            this.d.setMessage(new java.lang.String(bArr7));
                            this.d.setType(257);
                        } else if (s2 == 1282) {
                            this.d.setTitle(new java.lang.String(bArr6));
                        }
                    }
                    return this.d.getType();
                }
                return -1000;
            }
            return -1000;
        } catch (java.lang.Exception e2) {
            e = e2;
            bArr2 = null;
        }
    }

    byte[] a(int i) {
        java.nio.ByteBuffer byteBufferAllocate = java.nio.ByteBuffer.allocate(43);
        oicq.wlogin_sdk.request.async_context async_contextVarB = oicq.wlogin_sdk.request.t.b(this.f1683a.h);
        byteBufferAllocate.put(oicq.wlogin_sdk.request.t.ad);
        byteBufferAllocate.putInt((int) async_contextVarB._sappid);
        byteBufferAllocate.putInt((int) async_contextVarB._sub_appid);
        byteBufferAllocate.putShort((short) 0);
        byteBufferAllocate.putLong(this.f1683a.f);
        byteBufferAllocate.putShort((short) 10);
        byteBufferAllocate.put(oicq.wlogin_sdk.tools.util.SDK_VERSION.getBytes());
        byteBufferAllocate.putShort((short) this.b);
        byteBufferAllocate.putShort((short) this.c);
        byteBufferAllocate.put((byte) (i == -1000 ? 1 : 0));
        byteBufferAllocate.putInt(i);
        byte[] bArr = new oicq.wlogin_sdk.tlv_type.tlv_t8().get_tlv_8(0, oicq.wlogin_sdk.request.t.u, 0);
        java.nio.ByteBuffer byteBufferAllocate2 = java.nio.ByteBuffer.allocate(byteBufferAllocate.capacity() + 4 + 4 + oicq.wlogin_sdk.tlv_type.tlv_t508.userBuf.length + 4 + 8 + bArr.length);
        byteBufferAllocate2.putShort((short) 2);
        byteBufferAllocate2.putShort((short) 3);
        byteBufferAllocate2.putShort((short) 512);
        byteBufferAllocate2.putShort((short) byteBufferAllocate.capacity());
        byteBufferAllocate2.put(byteBufferAllocate.array());
        byteBufferAllocate2.putShort((short) 513);
        byteBufferAllocate2.putShort((short) 4);
        byteBufferAllocate2.putInt(2);
        byteBufferAllocate2.putShort((short) 2);
        byteBufferAllocate2.putShort((short) oicq.wlogin_sdk.tlv_type.tlv_t508.userBuf.length);
        byteBufferAllocate2.put(oicq.wlogin_sdk.tlv_type.tlv_t508.userBuf);
        byteBufferAllocate2.put(bArr);
        byte[] bArrEncrypt = oicq.wlogin_sdk.tools.cryptor.encrypt(byteBufferAllocate2.array(), 0, byteBufferAllocate2.position(), this.f1683a.c);
        if (bArrEncrypt == null) {
            bArrEncrypt = new byte[0];
        }
        java.nio.ByteBuffer byteBufferAllocate3 = java.nio.ByteBuffer.allocate(this.f1683a.c.length + 2 + 2 + bArrEncrypt.length);
        byteBufferAllocate3.putShort((short) this.f1683a.c.length);
        byteBufferAllocate3.put(this.f1683a.c);
        byteBufferAllocate3.putShort((short) bArrEncrypt.length);
        byteBufferAllocate3.put(bArrEncrypt);
        return byteBufferAllocate3.array();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int b(int i) throws java.lang.Throwable {
        java.net.HttpURLConnection httpURLConnection;
        java.net.HttpURLConnection httpURLConnection2 = null;
        try {
            try {
                byte[] bArrA = a(i);
                httpURLConnection = (java.net.HttpURLConnection) new java.net.URL("http://" + (new java.lang.String[]{"ts7", "ts8", "ts9"}[((int) java.lang.Math.round(java.lang.Math.random() * 1000.0d)) % 3] + ".qq.com:8080") + "/msg").openConnection();
                try {
                    httpURLConnection.setRequestMethod(com.tencent.connect.common.Constants.HTTP_POST);
                    httpURLConnection.setRequestProperty("Content-Length", bArrA.length + "");
                    httpURLConnection.setRequestProperty("Content-Type", "application/octet-stream");
                    httpURLConnection.setConnectTimeout(oicq.wlogin_sdk.tlv_type.tlv_t508.timeout);
                    httpURLConnection.setReadTimeout(oicq.wlogin_sdk.tlv_type.tlv_t508.timeout);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    if (!oicq.wlogin_sdk.request.j.a(httpURLConnection, this.f1683a.l)) {
                        oicq.wlogin_sdk.tools.util.LOGI("notice request connect failed", "" + this.f1683a.f);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return -1000;
                    }
                    java.io.OutputStream outputStream = httpURLConnection.getOutputStream();
                    outputStream.write(bArrA);
                    outputStream.close();
                    int responseCode = httpURLConnection.getResponseCode();
                    oicq.wlogin_sdk.tools.util.LOGI("notice request response code=" + responseCode, "" + this.f1683a.f);
                    if (200 != responseCode) {
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return -1000;
                    }
                    oicq.wlogin_sdk.tools.util.LOGI("recv notice ...", "" + this.f1683a.f);
                    java.io.InputStream inputStream = httpURLConnection.getInputStream();
                    java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i2 = inputStream.read(bArr);
                        if (i2 == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, i2);
                    }
                    boolean z = a(byteArrayOutputStream.toByteArray()) != -1000;
                    byteArrayOutputStream.close();
                    if (!z) {
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return -1000;
                    }
                    if (httpURLConnection == null) {
                        return 257;
                    }
                    httpURLConnection.disconnect();
                    return 257;
                } catch (java.lang.Exception e) {
                    e = e;
                    httpURLConnection2 = httpURLConnection;
                    oicq.wlogin_sdk.tools.util.printException(e);
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return -1000;
                } catch (java.lang.Throwable th) {
                    th = th;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                httpURLConnection = httpURLConnection2;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
        }
    }
}
