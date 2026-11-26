package com.unisound.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class aj {
    public static java.lang.String a() {
        return java.util.UUID.randomUUID().toString().toUpperCase(java.util.Locale.getDefault());
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        try {
            return new java.lang.String(str.getBytes(str2), "UTF-8");
        } catch (java.io.UnsupportedEncodingException e) {
            throw new java.lang.IllegalArgumentException(e);
        }
    }

    public static java.lang.String a(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        java.lang.String strEncode;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str);
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START);
        java.lang.String str2 = "";
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            sb.append(str2);
            sb.append(entry.getKey());
            sb.append("=");
            try {
                strEncode = java.net.URLEncoder.encode(entry.getValue(), "UTF-8");
            } catch (java.io.UnsupportedEncodingException unused) {
                strEncode = "";
            }
            sb.append(strEncode);
            str2 = "&";
        }
        return sb.toString();
    }

    public static java.lang.String a(java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str) {
        return a(map, null, str);
    }

    public static java.lang.String a(java.util.Map<java.lang.String, java.lang.String> map, java.util.List<java.lang.String> list, java.lang.String str) {
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList(map.size());
            arrayList.addAll(map.keySet());
            if (list != null && list.size() > 0) {
                java.util.Iterator<java.lang.String> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.remove(it.next());
                }
            }
            java.util.Collections.sort(arrayList);
            sb.append(str);
            sb.append("&");
            for (java.lang.String str2 : arrayList) {
                sb.append(str2);
                sb.append("=");
                sb.append(map.get(str2));
                sb.append("&");
            }
            sb.append(str);
            return a(a(sb.toString()));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static java.lang.String a(byte[] bArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (byte b : bArr) {
            java.lang.String hexString = java.lang.Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString.toUpperCase(java.util.Locale.getDefault()));
        }
        return sb.toString();
    }

    private static byte[] a(java.lang.String str) throws java.lang.Exception {
        try {
            return java.security.MessageDigest.getInstance("SHA-1").digest(str.getBytes("UTF-8"));
        } catch (java.lang.Exception e) {
            throw new java.lang.Exception(e);
        }
    }
}
