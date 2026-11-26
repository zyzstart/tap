package com.tencent.ysdk.shell.libware.file;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ByteArrayPool {
    protected static final java.util.Comparator<byte[]> BUF_COMPARATOR = new java.util.Comparator<byte[]>() { // from class: com.tencent.ysdk.shell.libware.file.ByteArrayPool.1
        @Override // java.util.Comparator
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    };
    public static final java.lang.String LOG_TAG = "UserAPI";
    public static final int MAX_BYTE_ARRAY_POOL_SIZE = 1048576;
    public static final boolean USE_POOL = true;
    private static volatile com.tencent.ysdk.shell.libware.file.ByteArrayPool instance;
    public java.util.List<byte[]> mBuffersByLastUse = new java.util.LinkedList();
    public java.util.List<byte[]> mBuffersBySize = new java.util.ArrayList(64);
    public int mCurrentSize = 0;
    public final int mSizeLimit;

    public ByteArrayPool(int i) {
        this.mSizeLimit = i;
    }

    public static com.tencent.ysdk.shell.libware.file.ByteArrayPool getInstance() {
        if (instance == null) {
            synchronized (com.tencent.ysdk.shell.libware.file.ByteArrayPool.class) {
                if (instance == null) {
                    instance = new com.tencent.ysdk.shell.libware.file.ByteArrayPool(1048576);
                }
            }
        }
        return instance;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized byte[] getBuf(int i) {
        for (int i2 = 0; i2 < this.mBuffersBySize.size(); i2++) {
            byte[] bArr = this.mBuffersBySize.get(i2);
            if (bArr.length >= i) {
                this.mCurrentSize -= bArr.length;
                this.mBuffersBySize.remove(i2);
                this.mBuffersByLastUse.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }

    public synchronized void returnBuf(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.mSizeLimit) {
                this.mBuffersByLastUse.add(bArr);
                int iBinarySearch = java.util.Collections.binarySearch(this.mBuffersBySize, bArr, BUF_COMPARATOR);
                if (iBinarySearch < 0) {
                    iBinarySearch = (-iBinarySearch) - 1;
                }
                this.mBuffersBySize.add(iBinarySearch, bArr);
                this.mCurrentSize += bArr.length;
                trim();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void trim() {
        while (this.mCurrentSize > this.mSizeLimit) {
            byte[] bArrRemove = this.mBuffersByLastUse.remove(0);
            this.mBuffersBySize.remove(bArrRemove);
            this.mCurrentSize -= bArrRemove.length;
            int length = bArrRemove.length;
        }
    }
}
