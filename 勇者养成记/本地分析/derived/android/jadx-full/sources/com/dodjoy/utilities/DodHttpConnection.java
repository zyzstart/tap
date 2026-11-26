package com.dodjoy.utilities;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class DodHttpConnection {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static java.lang.String connect(java.lang.String str, java.util.List<android.util.Pair<java.lang.String, java.lang.String>> list, int i) throws java.lang.Exception {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.net.URL httpUrl = getHttpUrl(str, list);
        java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) httpUrl.openConnection();
        httpURLConnection.setConnectTimeout(i * 1000);
        httpURLConnection.setReadTimeout(3000);
        httpURLConnection.setChunkedStreamingMode(0);
        if (httpURLConnection.getResponseCode() != 200) {
            java.lang.String str2 = "request url " + httpUrl.getPath() + " response code " + httpURLConnection.getResponseCode();
            com.dodjoy.utils.DodLog.e(com.dodjoy.utils.DodLog.TAG, str2);
            throw new java.lang.Exception(str2);
        }
        java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(httpURLConnection.getInputStream()));
        while (true) {
            java.lang.String line = bufferedReader.readLine();
            if (line == null) {
                com.dodjoy.utils.DodLog.i(com.dodjoy.utils.DodLog.TAG, "http connect ret " + sb.toString());
                return sb.toString();
            }
            sb.append(line);
        }
    }

    private static java.net.URL getHttpUrl(java.lang.String str, java.util.List<android.util.Pair<java.lang.String, java.lang.String>> list) throws java.net.MalformedURLException, java.io.UnsupportedEncodingException {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(str);
        if (list.size() > 0) {
            sb.append('?');
            for (android.util.Pair<java.lang.String, java.lang.String> pair : list) {
                sb.append(java.lang.String.format("%s=%s&", pair.first, java.net.URLEncoder.encode((java.lang.String) pair.second, "UTF-8")));
            }
        }
        com.dodjoy.utils.DodLog.i(com.dodjoy.utils.DodLog.TAG, "request url " + sb.toString());
        return new java.net.URL(sb.toString());
    }
}
