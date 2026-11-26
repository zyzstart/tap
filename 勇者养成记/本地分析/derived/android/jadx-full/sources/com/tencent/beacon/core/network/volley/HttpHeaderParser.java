package com.tencent.beacon.core.network.volley;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class HttpHeaderParser {
    private static final java.lang.String DEFAULT_CONTENT_CHARSET = "ISO-8859-1";
    static final java.lang.String HEADER_CONTENT_TYPE = "Content-Type";
    private static final java.lang.String RFC1123_OUTPUT_FORMAT = "EEE, dd MMM yyyy HH:mm:ss 'GMT'";
    private static final java.lang.String RFC1123_PARSE_FORMAT = "EEE, dd MMM yyyy HH:mm:ss zzz";

    static java.lang.String formatEpochAsRfc1123(long j) {
        return newUsGmtFormatter(RFC1123_OUTPUT_FORMAT).format(new java.util.Date(j));
    }

    private static java.text.SimpleDateFormat newUsGmtFormatter(java.lang.String str) {
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(str, java.util.Locale.US);
        simpleDateFormat.setTimeZone(java.util.TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    public static com.tencent.beacon.core.network.volley.Cache.Entry parseCacheHeaders(com.tencent.beacon.core.network.volley.NetworkResponse networkResponse) {
        long j;
        long j2;
        boolean z;
        long j3;
        long j4;
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        java.util.Map map = networkResponse.headers;
        java.lang.String str = (java.lang.String) map.get("Date");
        long dateAsEpoch = str != null ? parseDateAsEpoch(str) : 0L;
        java.lang.String str2 = (java.lang.String) map.get("Cache-Control");
        int i = 0;
        if (str2 != null) {
            java.lang.String[] strArrSplit = str2.split(",", 0);
            int i2 = 0;
            j = 0;
            j2 = 0;
            while (i < strArrSplit.length) {
                java.lang.String strTrim = strArrSplit[i].trim();
                if (strTrim.equals("no-cache") || strTrim.equals("no-store")) {
                    return null;
                }
                if (strTrim.startsWith("max-age=")) {
                    try {
                        j = java.lang.Long.parseLong(strTrim.substring(8));
                    } catch (java.lang.Exception unused) {
                    }
                } else if (strTrim.startsWith("stale-while-revalidate=")) {
                    j2 = java.lang.Long.parseLong(strTrim.substring(23));
                } else if (strTrim.equals("must-revalidate") || strTrim.equals("proxy-revalidate")) {
                    i2 = 1;
                }
                i++;
            }
            i = i2;
            z = true;
        } else {
            j = 0;
            j2 = 0;
            z = false;
        }
        java.lang.String str3 = (java.lang.String) map.get("Expires");
        long dateAsEpoch2 = str3 != null ? parseDateAsEpoch(str3) : 0L;
        java.lang.String str4 = (java.lang.String) map.get("Last-Modified");
        long dateAsEpoch3 = str4 != null ? parseDateAsEpoch(str4) : 0L;
        java.lang.String str5 = (java.lang.String) map.get("ETag");
        if (z) {
            j3 = jCurrentTimeMillis + (j * 1000);
            if (i != 0) {
                j4 = j3;
            } else {
                java.lang.Long.signum(j2);
                j4 = (j2 * 1000) + j3;
            }
        } else if (dateAsEpoch <= 0 || dateAsEpoch2 < dateAsEpoch) {
            j3 = 0;
            j4 = j3;
        } else {
            j4 = (dateAsEpoch2 - dateAsEpoch) + jCurrentTimeMillis;
            j3 = j4;
        }
        com.tencent.beacon.core.network.volley.Cache.Entry entry = new com.tencent.beacon.core.network.volley.Cache.Entry();
        entry.data = networkResponse.data;
        entry.etag = str5;
        entry.softTtl = j3;
        entry.ttl = j4;
        entry.serverDate = dateAsEpoch;
        entry.lastModified = dateAsEpoch3;
        entry.responseHeaders = map;
        entry.allResponseHeaders = networkResponse.allHeaders;
        return entry;
    }

    public static java.lang.String parseCharset(java.util.Map map) {
        return parseCharset(map, DEFAULT_CONTENT_CHARSET);
    }

    public static java.lang.String parseCharset(java.util.Map map, java.lang.String str) {
        java.lang.String str2 = (java.lang.String) map.get(HEADER_CONTENT_TYPE);
        if (str2 != null) {
            java.lang.String[] strArrSplit = str2.split(";", 0);
            for (int i = 1; i < strArrSplit.length; i++) {
                java.lang.String[] strArrSplit2 = strArrSplit[i].trim().split("=", 0);
                if (strArrSplit2.length == 2 && strArrSplit2[0].equals("charset")) {
                    return strArrSplit2[1];
                }
            }
        }
        return str;
    }

    public static long parseDateAsEpoch(java.lang.String str) {
        try {
            return newUsGmtFormatter(RFC1123_PARSE_FORMAT).parse(str).getTime();
        } catch (java.text.ParseException e) {
            if ("0".equals(str) || "-1".equals(str)) {
                com.tencent.beacon.core.network.volley.VolleyLog.v("Unable to parse dateStr: %s, falling back to 0", str);
                return 0L;
            }
            com.tencent.beacon.core.network.volley.VolleyLog.e(e, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0L;
        }
    }

    static java.util.List toAllHeaderList(java.util.Map map) {
        java.util.ArrayList arrayList = new java.util.ArrayList(map.size());
        for (java.util.Map.Entry entry : map.entrySet()) {
            arrayList.add(new com.tencent.beacon.core.network.volley.Header((java.lang.String) entry.getKey(), (java.lang.String) entry.getValue()));
        }
        return arrayList;
    }

    static java.util.Map toHeaderMap(java.util.List list) {
        java.util.TreeMap treeMap = new java.util.TreeMap(java.lang.String.CASE_INSENSITIVE_ORDER);
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            com.tencent.beacon.core.network.volley.Header header = (com.tencent.beacon.core.network.volley.Header) it.next();
            treeMap.put(header.getName(), header.getValue());
        }
        return treeMap;
    }
}
