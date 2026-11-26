package com.tencent.beaconselfupdate.upload;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    org.apache.http.HttpResponse f269a;
    org.apache.http.client.methods.HttpPost b;
    org.apache.http.client.HttpClient c;

    public b(org.apache.http.HttpResponse httpResponse, org.apache.http.client.methods.HttpPost httpPost, org.apache.http.client.HttpClient httpClient) {
        this.f269a = null;
        this.b = null;
        this.c = null;
        this.f269a = httpResponse;
        this.b = httpPost;
        this.c = httpClient;
    }
}
