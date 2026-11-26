package com.tencent.beacon.core.network.volley;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class NetworkResponse {
    public final java.util.List allHeaders;
    public final byte[] data;
    public final java.util.Map headers;
    public final long networkTimeMs;
    public final boolean notModified;
    public final int statusCode;

    private NetworkResponse(int i, byte[] bArr, java.util.Map map, java.util.List list, boolean z, long j) {
        this.statusCode = i;
        this.data = bArr;
        this.headers = map;
        this.allHeaders = list == null ? null : java.util.Collections.unmodifiableList(list);
        this.notModified = z;
        this.networkTimeMs = j;
    }

    @java.lang.Deprecated
    public NetworkResponse(int i, byte[] bArr, java.util.Map map, boolean z) {
        this(i, bArr, map, z, 0L);
    }

    @java.lang.Deprecated
    public NetworkResponse(int i, byte[] bArr, java.util.Map map, boolean z, long j) {
        this(i, bArr, map, toAllHeaderList(map), z, j);
    }

    public NetworkResponse(int i, byte[] bArr, boolean z, long j, java.util.List list) {
        this(i, bArr, toHeaderMap(list), list, z, j);
    }

    public NetworkResponse(byte[] bArr) {
        this(200, bArr, false, 0L, java.util.Collections.emptyList());
    }

    @java.lang.Deprecated
    public NetworkResponse(byte[] bArr, java.util.Map map) {
        this(200, bArr, map, false, 0L);
    }

    private static java.util.List toAllHeaderList(java.util.Map map) {
        if (map == null) {
            return null;
        }
        if (map.isEmpty()) {
            return java.util.Collections.emptyList();
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(map.size());
        for (java.util.Map.Entry entry : map.entrySet()) {
            arrayList.add(new com.tencent.beacon.core.network.volley.Header((java.lang.String) entry.getKey(), (java.lang.String) entry.getValue()));
        }
        return arrayList;
    }

    private static java.util.Map toHeaderMap(java.util.List list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return java.util.Collections.emptyMap();
        }
        java.util.TreeMap treeMap = new java.util.TreeMap(java.lang.String.CASE_INSENSITIVE_ORDER);
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            com.tencent.beacon.core.network.volley.Header header = (com.tencent.beacon.core.network.volley.Header) it.next();
            treeMap.put(header.getName(), header.getValue());
        }
        return treeMap;
    }
}
