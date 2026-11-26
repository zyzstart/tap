package com.bun.miitmdid.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.Keep
public class b {

    @android.support.annotation.Keep
    private static boolean h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @android.support.annotation.Keep
    private java.lang.String f21a = null;

    @android.support.annotation.Keep
    private com.bun.miitmdid.b.b.InterfaceC0004b b = null;

    @android.support.annotation.Keep
    private java.lang.Object c = null;

    @android.support.annotation.Keep
    private java.util.Map<java.lang.String, java.lang.String> d = new java.util.HashMap();

    @android.support.annotation.Keep
    private java.util.Map<java.lang.String, java.lang.String> e = new java.util.HashMap();

    @android.support.annotation.Keep
    private java.util.Map<java.lang.String, java.lang.String> f = new java.util.HashMap();

    @android.support.annotation.Keep
    private java.lang.String g = com.tencent.connect.common.Constants.HTTP_GET;

    @android.support.annotation.Keep
    class a extends android.os.AsyncTask<java.lang.Void, java.lang.Void, com.bun.miitmdid.b.b.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @android.support.annotation.Keep
        com.bun.miitmdid.b.b f22a;

        @android.support.annotation.Keep
        a() {
            this.f22a = com.bun.miitmdid.b.b.this;
        }

        @android.support.annotation.Keep
        protected native com.bun.miitmdid.b.b.c a(java.lang.Void... voidArr);

        @android.support.annotation.Keep
        protected native void a(com.bun.miitmdid.b.b.c cVar);

        @Override // android.os.AsyncTask
        @android.support.annotation.Keep
        protected native /* bridge */ /* synthetic */ com.bun.miitmdid.b.b.c doInBackground(java.lang.Void[] voidArr);

        @Override // android.os.AsyncTask
        @android.support.annotation.Keep
        protected native /* bridge */ /* synthetic */ void onPostExecute(com.bun.miitmdid.b.b.c cVar);
    }

    /* JADX INFO: renamed from: com.bun.miitmdid.b.b$b, reason: collision with other inner class name */
    @android.support.annotation.Keep
    public interface InterfaceC0004b {
        @android.support.annotation.Keep
        void a(java.lang.Exception exc, int i, java.lang.String str);
    }

    @android.support.annotation.Keep
    private class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @android.support.annotation.Keep
        private java.lang.String f23a;

        @android.support.annotation.Keep
        private int b;

        @android.support.annotation.Keep
        private java.lang.Exception c;

        @android.support.annotation.Keep
        public c(com.bun.miitmdid.b.b bVar, java.lang.String str, java.lang.Exception exc, int i) {
            this.f23a = str;
            this.c = exc;
            this.b = i;
        }

        @android.support.annotation.Keep
        static native /* synthetic */ java.lang.Exception a(com.bun.miitmdid.b.b.c cVar);

        @android.support.annotation.Keep
        static native /* synthetic */ int b(com.bun.miitmdid.b.b.c cVar);

        @android.support.annotation.Keep
        static native /* synthetic */ java.lang.String c(com.bun.miitmdid.b.b.c cVar);
    }

    @android.support.annotation.Keep
    private b(android.content.Context context) {
    }

    @android.support.annotation.Keep
    public static native com.bun.miitmdid.b.b a(@android.support.annotation.NonNull android.content.Context context);

    @android.support.annotation.Keep
    static native /* synthetic */ java.lang.String a(com.bun.miitmdid.b.b bVar);

    @android.support.annotation.Keep
    private native void a(java.net.HttpURLConnection httpURLConnection);

    @android.support.annotation.Keep
    private native com.bun.miitmdid.b.b.c b();

    @android.support.annotation.Keep
    static native /* synthetic */ com.bun.miitmdid.b.b.c b(com.bun.miitmdid.b.b bVar);

    @android.support.annotation.Keep
    private static native void b(@android.support.annotation.NonNull java.lang.String str);

    @android.support.annotation.Keep
    private native com.bun.miitmdid.b.b.c c();

    @android.support.annotation.Keep
    static native /* synthetic */ com.bun.miitmdid.b.b.c c(com.bun.miitmdid.b.b bVar);

    @android.support.annotation.Keep
    static native /* synthetic */ com.bun.miitmdid.b.b.InterfaceC0004b d(com.bun.miitmdid.b.b bVar);

    @android.support.annotation.Keep
    private native java.lang.String d();

    @android.support.annotation.Keep
    public native com.bun.miitmdid.b.b a();

    @android.support.annotation.Keep
    public native com.bun.miitmdid.b.b a(com.bun.miitmdid.b.b.InterfaceC0004b interfaceC0004b);

    @android.support.annotation.Keep
    public native com.bun.miitmdid.b.b a(java.lang.Object obj);

    @android.support.annotation.Keep
    public native com.bun.miitmdid.b.b a(@android.support.annotation.NonNull java.lang.String str);

    @android.support.annotation.Keep
    public native com.bun.miitmdid.b.b a(@android.support.annotation.NonNull java.lang.String str, @android.support.annotation.NonNull java.lang.String str2);

    @android.support.annotation.Keep
    public native com.bun.miitmdid.b.b a(java.util.Map<java.lang.String, java.lang.String> map);
}
