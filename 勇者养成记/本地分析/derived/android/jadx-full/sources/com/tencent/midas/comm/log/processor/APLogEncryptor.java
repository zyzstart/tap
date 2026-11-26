package com.tencent.midas.comm.log.processor;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APLogEncryptor {
    private static java.lang.String ENCRYPT_KEY = "}VjZtoJF;dE+7iJs";
    private static final byte MAGIC_END = 0;
    private static final byte MAGIC_START = 2;
    private static byte PROTOCOL_VERSION = 1;
    private static byte[] header = new byte[7];
    private javax.crypto.Cipher encryptCipher = null;

    private static byte[] assembleHeader(int i) {
        java.lang.System.arraycopy(com.tencent.midas.comm.log.util.APBytesUtil.int2bytes(i), 0, header, 3, 4);
        return header;
    }

    public static com.tencent.midas.comm.log.processor.APLogEncryptor create() {
        com.tencent.midas.comm.log.processor.APLogEncryptor aPLogEncryptor = new com.tencent.midas.comm.log.processor.APLogEncryptor();
        aPLogEncryptor.init();
        return aPLogEncryptor;
    }

    private void init() {
        try {
            header[0] = 2;
            header[1] = PROTOCOL_VERSION;
            javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(ENCRYPT_KEY.getBytes(), "[REDACTED]");
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/ECB/NoPadding");
            this.encryptCipher = cipher;
            cipher.init(1, secretKeySpec);
        } catch (java.security.InvalidKeyException e) {
            e.printStackTrace();
        } catch (java.security.NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        } catch (javax.crypto.NoSuchPaddingException e3) {
            e3.printStackTrace();
        }
    }

    public static void setEncryptKey(java.lang.String str) {
        ENCRYPT_KEY = str;
    }

    public static void setProtocolVersion(byte b) {
        PROTOCOL_VERSION = b;
    }

    public void close() {
        this.encryptCipher = null;
    }

    public byte[] encrypt(byte[] bArr) {
        int length = bArr.length;
        int i = length % 16;
        if (i != 0) {
            try {
                byte[] bArr2 = new byte[(16 - i) + length];
                java.lang.System.arraycopy(bArr, 0, bArr2, 0, length);
                bArr = bArr2;
            } catch (javax.crypto.BadPaddingException e) {
                e.printStackTrace();
            } catch (javax.crypto.IllegalBlockSizeException e2) {
                e2.printStackTrace();
            }
        }
        bArr = this.encryptCipher.doFinal(bArr);
        byte[] bArrAssembleHeader = assembleHeader(length);
        int length2 = bArrAssembleHeader.length + bArr.length + 1;
        byte[] bArr3 = new byte[length2];
        java.lang.System.arraycopy(bArrAssembleHeader, 0, bArr3, 0, bArrAssembleHeader.length);
        java.lang.System.arraycopy(bArr, 0, bArr3, bArrAssembleHeader.length, bArr.length);
        bArr3[length2 - 1] = 0;
        return bArr3;
    }
}
