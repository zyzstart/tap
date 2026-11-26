package com.tencent.beacon.core.network.volley;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class DiskBasedCache implements com.tencent.beacon.core.network.volley.Cache {
    private static final int CACHE_MAGIC = 538247942;
    private static final int DEFAULT_DISK_USAGE_BYTES = 5242880;
    static final float HYSTERESIS_FACTOR = 0.9f;
    private final java.util.Map mEntries;
    private final int mMaxCacheSizeInBytes;
    private final com.tencent.beacon.core.network.volley.DiskBasedCache.FileSupplier mRootDirectorySupplier;
    private long mTotalSize;

    static class CacheHeader {
        final java.util.List allResponseHeaders;
        final java.lang.String etag;
        final java.lang.String key;
        final long lastModified;
        final long serverDate;
        long size;
        final long softTtl;
        final long ttl;

        CacheHeader(java.lang.String str, com.tencent.beacon.core.network.volley.Cache.Entry entry) {
            this(str, entry.etag, entry.serverDate, entry.lastModified, entry.ttl, entry.softTtl, getAllResponseHeaders(entry));
        }

        private CacheHeader(java.lang.String str, java.lang.String str2, long j, long j2, long j3, long j4, java.util.List list) {
            this.key = str;
            this.etag = "".equals(str2) ? null : str2;
            this.serverDate = j;
            this.lastModified = j2;
            this.ttl = j3;
            this.softTtl = j4;
            this.allResponseHeaders = list;
        }

        private static java.util.List getAllResponseHeaders(com.tencent.beacon.core.network.volley.Cache.Entry entry) {
            java.util.List list = entry.allResponseHeaders;
            return list != null ? list : com.tencent.beacon.core.network.volley.HttpHeaderParser.toAllHeaderList(entry.responseHeaders);
        }

        static com.tencent.beacon.core.network.volley.DiskBasedCache.CacheHeader readHeader(com.tencent.beacon.core.network.volley.DiskBasedCache.CountingInputStream countingInputStream) throws java.io.IOException {
            if (com.tencent.beacon.core.network.volley.DiskBasedCache.readInt(countingInputStream) == com.tencent.beacon.core.network.volley.DiskBasedCache.CACHE_MAGIC) {
                return new com.tencent.beacon.core.network.volley.DiskBasedCache.CacheHeader(com.tencent.beacon.core.network.volley.DiskBasedCache.readString(countingInputStream), com.tencent.beacon.core.network.volley.DiskBasedCache.readString(countingInputStream), com.tencent.beacon.core.network.volley.DiskBasedCache.readLong(countingInputStream), com.tencent.beacon.core.network.volley.DiskBasedCache.readLong(countingInputStream), com.tencent.beacon.core.network.volley.DiskBasedCache.readLong(countingInputStream), com.tencent.beacon.core.network.volley.DiskBasedCache.readLong(countingInputStream), com.tencent.beacon.core.network.volley.DiskBasedCache.readHeaderList(countingInputStream));
            }
            throw new java.io.IOException();
        }

        com.tencent.beacon.core.network.volley.Cache.Entry toCacheEntry(byte[] bArr) {
            com.tencent.beacon.core.network.volley.Cache.Entry entry = new com.tencent.beacon.core.network.volley.Cache.Entry();
            entry.data = bArr;
            entry.etag = this.etag;
            entry.serverDate = this.serverDate;
            entry.lastModified = this.lastModified;
            entry.ttl = this.ttl;
            entry.softTtl = this.softTtl;
            entry.responseHeaders = com.tencent.beacon.core.network.volley.HttpHeaderParser.toHeaderMap(this.allResponseHeaders);
            entry.allResponseHeaders = java.util.Collections.unmodifiableList(this.allResponseHeaders);
            return entry;
        }

        boolean writeHeader(java.io.OutputStream outputStream) {
            try {
                com.tencent.beacon.core.network.volley.DiskBasedCache.writeInt(outputStream, com.tencent.beacon.core.network.volley.DiskBasedCache.CACHE_MAGIC);
                com.tencent.beacon.core.network.volley.DiskBasedCache.writeString(outputStream, this.key);
                com.tencent.beacon.core.network.volley.DiskBasedCache.writeString(outputStream, this.etag == null ? "" : this.etag);
                com.tencent.beacon.core.network.volley.DiskBasedCache.writeLong(outputStream, this.serverDate);
                com.tencent.beacon.core.network.volley.DiskBasedCache.writeLong(outputStream, this.lastModified);
                com.tencent.beacon.core.network.volley.DiskBasedCache.writeLong(outputStream, this.ttl);
                com.tencent.beacon.core.network.volley.DiskBasedCache.writeLong(outputStream, this.softTtl);
                com.tencent.beacon.core.network.volley.DiskBasedCache.writeHeaderList(this.allResponseHeaders, outputStream);
                outputStream.flush();
                return true;
            } catch (java.io.IOException e) {
                com.tencent.beacon.core.network.volley.VolleyLog.d("%s", e.toString());
                return false;
            }
        }
    }

    static class CountingInputStream extends java.io.FilterInputStream {
        private long bytesRead;
        private final long length;

        CountingInputStream(java.io.InputStream inputStream, long j) {
            super(inputStream);
            this.length = j;
        }

        long bytesRead() {
            return this.bytesRead;
        }

        long bytesRemaining() {
            return this.length - this.bytesRead;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws java.io.IOException {
            int i = super.read();
            if (i != -1) {
                this.bytesRead++;
            }
            return i;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
            int i3 = super.read(bArr, i, i2);
            if (i3 != -1) {
                this.bytesRead += (long) i3;
            }
            return i3;
        }
    }

    public interface FileSupplier {
        java.io.File get();
    }

    public DiskBasedCache(com.tencent.beacon.core.network.volley.DiskBasedCache.FileSupplier fileSupplier) {
        this(fileSupplier, DEFAULT_DISK_USAGE_BYTES);
    }

    public DiskBasedCache(com.tencent.beacon.core.network.volley.DiskBasedCache.FileSupplier fileSupplier, int i) {
        this.mEntries = new java.util.LinkedHashMap(16, 0.75f, true);
        this.mTotalSize = 0L;
        this.mRootDirectorySupplier = fileSupplier;
        this.mMaxCacheSizeInBytes = i;
    }

    public DiskBasedCache(java.io.File file) {
        this(file, DEFAULT_DISK_USAGE_BYTES);
    }

    public DiskBasedCache(final java.io.File file, int i) {
        this.mEntries = new java.util.LinkedHashMap(16, 0.75f, true);
        this.mTotalSize = 0L;
        this.mRootDirectorySupplier = new com.tencent.beacon.core.network.volley.DiskBasedCache.FileSupplier() { // from class: com.tencent.beacon.core.network.volley.DiskBasedCache.1
            @Override // com.tencent.beacon.core.network.volley.DiskBasedCache.FileSupplier
            public java.io.File get() {
                return file;
            }
        };
        this.mMaxCacheSizeInBytes = i;
    }

    private java.lang.String getFilenameForKey(java.lang.String str) {
        int length = str.length() / 2;
        return java.lang.String.valueOf(str.substring(0, length).hashCode()) + java.lang.String.valueOf(str.substring(length).hashCode());
    }

    private void initializeIfRootDirectoryDeleted() {
        if (this.mRootDirectorySupplier.get().exists()) {
            return;
        }
        com.tencent.beacon.core.network.volley.VolleyLog.d("Re-initializing cache after external clearing.", new java.lang.Object[0]);
        this.mEntries.clear();
        this.mTotalSize = 0L;
        initialize();
    }

    private void pruneIfNeeded() {
        if (this.mTotalSize < this.mMaxCacheSizeInBytes) {
            return;
        }
        if (com.tencent.beacon.core.network.volley.VolleyLog.DEBUG) {
            com.tencent.beacon.core.network.volley.VolleyLog.v("Pruning old cache entries.", new java.lang.Object[0]);
        }
        long j = this.mTotalSize;
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
        java.util.Iterator it = this.mEntries.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            com.tencent.beacon.core.network.volley.DiskBasedCache.CacheHeader cacheHeader = (com.tencent.beacon.core.network.volley.DiskBasedCache.CacheHeader) ((java.util.Map.Entry) it.next()).getValue();
            if (getFileForKey(cacheHeader.key).delete()) {
                this.mTotalSize -= cacheHeader.size;
            } else {
                java.lang.String str = cacheHeader.key;
                com.tencent.beacon.core.network.volley.VolleyLog.d("Could not delete cache entry for key=%s, filename=%s", str, getFilenameForKey(str));
            }
            it.remove();
            i++;
            if (this.mTotalSize < this.mMaxCacheSizeInBytes * HYSTERESIS_FACTOR) {
                break;
            }
        }
        if (com.tencent.beacon.core.network.volley.VolleyLog.DEBUG) {
            com.tencent.beacon.core.network.volley.VolleyLog.v("pruned %d files, %d bytes, %d ms", java.lang.Integer.valueOf(i), java.lang.Long.valueOf(this.mTotalSize - j), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime() - jElapsedRealtime));
        }
    }

    private void putEntry(java.lang.String str, com.tencent.beacon.core.network.volley.DiskBasedCache.CacheHeader cacheHeader) {
        if (this.mEntries.containsKey(str)) {
            this.mTotalSize += cacheHeader.size - ((com.tencent.beacon.core.network.volley.DiskBasedCache.CacheHeader) this.mEntries.get(str)).size;
        } else {
            this.mTotalSize += cacheHeader.size;
        }
        this.mEntries.put(str, cacheHeader);
    }

    private static int read(java.io.InputStream inputStream) throws java.io.IOException {
        int i = inputStream.read();
        if (i != -1) {
            return i;
        }
        throw new java.io.EOFException();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static java.util.List readHeaderList(com.tencent.beacon.core.network.volley.DiskBasedCache.CountingInputStream countingInputStream) throws java.io.IOException {
        int i = readInt(countingInputStream);
        if (i < 0) {
            throw new java.io.IOException("readHeaderList size=" + i);
        }
        java.util.List listEmptyList = i == 0 ? java.util.Collections.emptyList() : new java.util.ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            listEmptyList.add(new com.tencent.beacon.core.network.volley.Header(readString(countingInputStream).intern(), readString(countingInputStream).intern()));
        }
        return listEmptyList;
    }

    static int readInt(java.io.InputStream inputStream) {
        return (read(inputStream) << 24) | (read(inputStream) << 0) | 0 | (read(inputStream) << 8) | (read(inputStream) << 16);
    }

    static long readLong(java.io.InputStream inputStream) {
        return ((((long) read(inputStream)) & 255) << 0) | 0 | ((((long) read(inputStream)) & 255) << 8) | ((((long) read(inputStream)) & 255) << 16) | ((((long) read(inputStream)) & 255) << 24) | ((((long) read(inputStream)) & 255) << 32) | ((((long) read(inputStream)) & 255) << 40) | ((((long) read(inputStream)) & 255) << 48) | ((255 & ((long) read(inputStream))) << 56);
    }

    static java.lang.String readString(com.tencent.beacon.core.network.volley.DiskBasedCache.CountingInputStream countingInputStream) {
        return new java.lang.String(streamToBytes(countingInputStream, readLong(countingInputStream)), "UTF-8");
    }

    private void removeEntry(java.lang.String str) {
        com.tencent.beacon.core.network.volley.DiskBasedCache.CacheHeader cacheHeader = (com.tencent.beacon.core.network.volley.DiskBasedCache.CacheHeader) this.mEntries.remove(str);
        if (cacheHeader != null) {
            this.mTotalSize -= cacheHeader.size;
        }
    }

    static byte[] streamToBytes(com.tencent.beacon.core.network.volley.DiskBasedCache.CountingInputStream countingInputStream, long j) throws java.io.IOException {
        long jBytesRemaining = countingInputStream.bytesRemaining();
        if (j >= 0 && j <= jBytesRemaining) {
            int i = (int) j;
            if (i == j) {
                byte[] bArr = new byte[i];
                new java.io.DataInputStream(countingInputStream).readFully(bArr);
                return bArr;
            }
        }
        throw new java.io.IOException("streamToBytes length=" + j + ", maxLength=" + jBytesRemaining);
    }

    static void writeHeaderList(java.util.List list, java.io.OutputStream outputStream) throws java.io.IOException {
        if (list == null) {
            writeInt(outputStream, 0);
            return;
        }
        writeInt(outputStream, list.size());
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            com.tencent.beacon.core.network.volley.Header header = (com.tencent.beacon.core.network.volley.Header) it.next();
            writeString(outputStream, header.getName());
            writeString(outputStream, header.getValue());
        }
    }

    static void writeInt(java.io.OutputStream outputStream, int i) throws java.io.IOException {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    static void writeLong(java.io.OutputStream outputStream, long j) throws java.io.IOException {
        outputStream.write((byte) (j >>> 0));
        outputStream.write((byte) (j >>> 8));
        outputStream.write((byte) (j >>> 16));
        outputStream.write((byte) (j >>> 24));
        outputStream.write((byte) (j >>> 32));
        outputStream.write((byte) (j >>> 40));
        outputStream.write((byte) (j >>> 48));
        outputStream.write((byte) (j >>> 56));
    }

    static void writeString(java.io.OutputStream outputStream, java.lang.String str) throws java.io.IOException {
        byte[] bytes = str.getBytes("UTF-8");
        writeLong(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.tencent.beacon.core.network.volley.Cache
    public synchronized void clear() {
        java.io.File[] fileArrListFiles = this.mRootDirectorySupplier.get().listFiles();
        if (fileArrListFiles != null) {
            for (java.io.File file : fileArrListFiles) {
                file.delete();
            }
        }
        this.mEntries.clear();
        this.mTotalSize = 0L;
        com.tencent.beacon.core.network.volley.VolleyLog.d("Cache cleared.", new java.lang.Object[0]);
    }

    java.io.InputStream createInputStream(java.io.File file) {
        return new java.io.FileInputStream(file);
    }

    java.io.OutputStream createOutputStream(java.io.File file) {
        return new java.io.FileOutputStream(file);
    }

    @Override // com.tencent.beacon.core.network.volley.Cache
    public synchronized com.tencent.beacon.core.network.volley.Cache.Entry get(java.lang.String str) {
        com.tencent.beacon.core.network.volley.DiskBasedCache.CacheHeader cacheHeader = (com.tencent.beacon.core.network.volley.DiskBasedCache.CacheHeader) this.mEntries.get(str);
        if (cacheHeader == null) {
            return null;
        }
        java.io.File fileForKey = getFileForKey(str);
        try {
            com.tencent.beacon.core.network.volley.DiskBasedCache.CountingInputStream countingInputStream = new com.tencent.beacon.core.network.volley.DiskBasedCache.CountingInputStream(new java.io.BufferedInputStream(createInputStream(fileForKey)), fileForKey.length());
            try {
                com.tencent.beacon.core.network.volley.DiskBasedCache.CacheHeader header = com.tencent.beacon.core.network.volley.DiskBasedCache.CacheHeader.readHeader(countingInputStream);
                if (android.text.TextUtils.equals(str, header.key)) {
                    com.tencent.beacon.core.network.volley.Cache.Entry cacheEntry = cacheHeader.toCacheEntry(streamToBytes(countingInputStream, countingInputStream.bytesRemaining()));
                    countingInputStream.close();
                    return cacheEntry;
                }
                com.tencent.beacon.core.network.volley.VolleyLog.d("%s: key=%s, found=%s", fileForKey.getAbsolutePath(), str, header.key);
                removeEntry(str);
                countingInputStream.close();
                return null;
            } catch (java.lang.Throwable th) {
                countingInputStream.close();
                throw th;
            }
        } catch (java.io.IOException e) {
            com.tencent.beacon.core.network.volley.VolleyLog.d("%s: %s", fileForKey.getAbsolutePath(), e.toString());
            remove(str);
            return null;
        }
    }

    public java.io.File getFileForKey(java.lang.String str) {
        return new java.io.File(this.mRootDirectorySupplier.get(), getFilenameForKey(str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.tencent.beacon.core.network.volley.Cache
    public synchronized void initialize() {
        java.io.File file = this.mRootDirectorySupplier.get();
        if (!file.exists()) {
            if (!file.mkdirs()) {
                com.tencent.beacon.core.network.volley.VolleyLog.e("Unable to create cache dir %s", file.getAbsolutePath());
            }
            return;
        }
        java.io.File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (java.io.File file2 : fileArrListFiles) {
            try {
                long length = file2.length();
                com.tencent.beacon.core.network.volley.DiskBasedCache.CountingInputStream countingInputStream = new com.tencent.beacon.core.network.volley.DiskBasedCache.CountingInputStream(new java.io.BufferedInputStream(createInputStream(file2)), length);
                try {
                    com.tencent.beacon.core.network.volley.DiskBasedCache.CacheHeader header = com.tencent.beacon.core.network.volley.DiskBasedCache.CacheHeader.readHeader(countingInputStream);
                    header.size = length;
                    putEntry(header.key, header);
                    countingInputStream.close();
                } catch (java.lang.Throwable th) {
                    countingInputStream.close();
                    throw th;
                }
            } catch (java.io.IOException unused) {
                file2.delete();
            }
        }
    }

    @Override // com.tencent.beacon.core.network.volley.Cache
    public synchronized void invalidate(java.lang.String str, boolean z) {
        com.tencent.beacon.core.network.volley.Cache.Entry entry = get(str);
        if (entry != null) {
            entry.softTtl = 0L;
            if (z) {
                entry.ttl = 0L;
            }
            put(str, entry);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r4v0, types: [long] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.tencent.beacon.core.network.volley.DiskBasedCache] */
    @Override // com.tencent.beacon.core.network.volley.Cache
    public synchronized void put(java.lang.String str, com.tencent.beacon.core.network.volley.Cache.Entry entry) {
        java.io.BufferedOutputStream bufferedOutputStream;
        long j = this.mTotalSize;
        byte[] bArr = entry.data;
        long length = j + ((long) bArr.length);
        int i = this.mMaxCacheSizeInBytes;
        ?? r4 = i;
        if (length > r4 && bArr.length > i * HYSTERESIS_FACTOR) {
            return;
        }
        java.io.File fileForKey = getFileForKey(str);
        ?? r1 = 0;
        try {
            try {
                bufferedOutputStream = new java.io.BufferedOutputStream(createOutputStream(fileForKey));
                try {
                    com.tencent.beacon.core.network.volley.DiskBasedCache.CacheHeader cacheHeader = new com.tencent.beacon.core.network.volley.DiskBasedCache.CacheHeader(str, entry);
                    if (!cacheHeader.writeHeader(bufferedOutputStream)) {
                        bufferedOutputStream.close();
                        com.tencent.beacon.core.network.volley.VolleyLog.d("Failed to write header for %s", fileForKey.getAbsolutePath());
                        throw new java.io.IOException();
                    }
                    bufferedOutputStream.write(entry.data);
                    cacheHeader.size = fileForKey.length();
                    putEntry(str, cacheHeader);
                    pruneIfNeeded();
                    com.tencent.beacon.core.e.b.a((java.io.Closeable) bufferedOutputStream);
                } catch (java.io.IOException unused) {
                    if (!fileForKey.delete()) {
                        com.tencent.beacon.core.network.volley.VolleyLog.d("Could not clean up file %s", fileForKey.getAbsolutePath());
                    }
                    initializeIfRootDirectoryDeleted();
                }
            } catch (java.lang.Throwable th) {
                th = th;
                r1 = r4;
                com.tencent.beacon.core.e.b.a((java.io.Closeable) r1);
                throw th;
            }
        } catch (java.io.IOException unused2) {
            bufferedOutputStream = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            com.tencent.beacon.core.e.b.a((java.io.Closeable) r1);
            throw th;
        }
    }

    @Override // com.tencent.beacon.core.network.volley.Cache
    public synchronized void remove(java.lang.String str) {
        boolean zDelete = getFileForKey(str).delete();
        removeEntry(str);
        if (!zDelete) {
            com.tencent.beacon.core.network.volley.VolleyLog.d("Could not delete cache entry for key=%s, filename=%s", str, getFilenameForKey(str));
        }
    }
}
