package com.tencent.beacon.core.network.volley;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface Cache {

    public static class Entry {
        public java.util.List allResponseHeaders;
        public byte[] data;
        public java.lang.String etag;
        public long lastModified;
        public java.util.Map responseHeaders = java.util.Collections.emptyMap();
        public long serverDate;
        public long softTtl;
        public long ttl;

        public boolean isExpired() {
            return this.ttl < java.lang.System.currentTimeMillis();
        }

        public boolean refreshNeeded() {
            return this.softTtl < java.lang.System.currentTimeMillis();
        }
    }

    void clear();

    com.tencent.beacon.core.network.volley.Cache.Entry get(java.lang.String str);

    void initialize();

    void invalidate(java.lang.String str, boolean z);

    void put(java.lang.String str, com.tencent.beacon.core.network.volley.Cache.Entry entry);

    void remove(java.lang.String str);
}
