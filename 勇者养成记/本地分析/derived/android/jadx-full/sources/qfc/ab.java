package qfc;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class ab {
    public int ax = 1000;
    public int ay = 1000;

    private static java.lang.String a(java.io.InputStream inputStream) throws java.io.IOException {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream, com.unisound.b.f.b));
        while (true) {
            java.lang.String line = bufferedReader.readLine();
            if (line == null) {
                inputStream.close();
                return sb.toString();
            }
            sb.append(line);
        }
    }

    public final java.lang.String b(java.lang.String str) {
        try {
            java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
            httpURLConnection.setConnectTimeout(this.ax);
            httpURLConnection.setReadTimeout(this.ay);
            return a(new java.io.BufferedInputStream(httpURLConnection.getInputStream()));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
