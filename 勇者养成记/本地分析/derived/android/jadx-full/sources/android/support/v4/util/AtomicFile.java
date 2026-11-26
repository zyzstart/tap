package android.support.v4.util;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class AtomicFile {
    private final java.io.File mBackupName;
    private final java.io.File mBaseName;

    public AtomicFile(java.io.File file) {
        this.mBaseName = file;
        this.mBackupName = new java.io.File(file.getPath() + ".bak");
    }

    static boolean sync(java.io.FileOutputStream fileOutputStream) {
        if (fileOutputStream == null) {
            return true;
        }
        try {
            fileOutputStream.getFD().sync();
            return true;
        } catch (java.io.IOException unused) {
            return false;
        }
    }

    public void delete() {
        this.mBaseName.delete();
        this.mBackupName.delete();
    }

    public void failWrite(java.io.FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            sync(fileOutputStream);
            try {
                fileOutputStream.close();
                this.mBaseName.delete();
                this.mBackupName.renameTo(this.mBaseName);
            } catch (java.io.IOException e) {
                android.util.Log.w("AtomicFile", "failWrite: Got exception:", e);
            }
        }
    }

    public void finishWrite(java.io.FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            sync(fileOutputStream);
            try {
                fileOutputStream.close();
                this.mBackupName.delete();
            } catch (java.io.IOException e) {
                android.util.Log.w("AtomicFile", "finishWrite: Got exception:", e);
            }
        }
    }

    public java.io.File getBaseFile() {
        return this.mBaseName;
    }

    public java.io.FileInputStream openRead() throws java.io.FileNotFoundException {
        if (this.mBackupName.exists()) {
            this.mBaseName.delete();
            this.mBackupName.renameTo(this.mBaseName);
        }
        return new java.io.FileInputStream(this.mBaseName);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public byte[] readFully() throws java.io.IOException {
        java.io.FileInputStream fileInputStreamOpenRead = openRead();
        try {
            byte[] bArr = new byte[fileInputStreamOpenRead.available()];
            int i = 0;
            while (true) {
                int i2 = fileInputStreamOpenRead.read(bArr, i, bArr.length - i);
                if (i2 <= 0) {
                    fileInputStreamOpenRead.close();
                    return bArr;
                }
                i += i2;
                int iAvailable = fileInputStreamOpenRead.available();
                if (iAvailable > bArr.length - i) {
                    byte[] bArr2 = new byte[iAvailable + i];
                    java.lang.System.arraycopy(bArr, 0, bArr2, 0, i);
                    bArr = bArr2;
                }
            }
        } catch (java.lang.Throwable th) {
            fileInputStreamOpenRead.close();
            throw th;
        }
    }

    public java.io.FileOutputStream startWrite() throws java.io.IOException {
        if (this.mBaseName.exists()) {
            if (this.mBackupName.exists()) {
                this.mBaseName.delete();
            } else if (!this.mBaseName.renameTo(this.mBackupName)) {
                android.util.Log.w("AtomicFile", "Couldn't rename file " + this.mBaseName + " to backup file " + this.mBackupName);
            }
        }
        try {
            return new java.io.FileOutputStream(this.mBaseName);
        } catch (java.io.FileNotFoundException unused) {
            if (!this.mBaseName.getParentFile().mkdirs()) {
                throw new java.io.IOException("Couldn't create directory " + this.mBaseName);
            }
            try {
                return new java.io.FileOutputStream(this.mBaseName);
            } catch (java.io.FileNotFoundException unused2) {
                throw new java.io.IOException("Couldn't create " + this.mBaseName);
            }
        }
    }
}
