package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@java.lang.Deprecated
public class WebIconDatabase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.tencent.smtt.sdk.WebIconDatabase f882a;

    @java.lang.Deprecated
    public interface a {
        void a(java.lang.String str, android.graphics.Bitmap bitmap);
    }

    private WebIconDatabase() {
    }

    private static synchronized com.tencent.smtt.sdk.WebIconDatabase a() {
        if (f882a == null) {
            f882a = new com.tencent.smtt.sdk.WebIconDatabase();
        }
        return f882a;
    }

    public static com.tencent.smtt.sdk.WebIconDatabase getInstance() {
        return a();
    }

    public void bulkRequestIconForPageUrl(android.content.ContentResolver contentResolver, java.lang.String str, com.tencent.smtt.sdk.WebIconDatabase.a aVar) {
    }

    public void close() {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        if (uVarA == null || !uVarA.b()) {
            android.webkit.WebIconDatabase.getInstance().close();
        } else {
            uVarA.c().m();
        }
    }

    public void open(java.lang.String str) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        if (uVarA == null || !uVarA.b()) {
            android.webkit.WebIconDatabase.getInstance().open(str);
        } else {
            uVarA.c().b(str);
        }
    }

    public void releaseIconForPageUrl(java.lang.String str) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        if (uVarA == null || !uVarA.b()) {
            android.webkit.WebIconDatabase.getInstance().releaseIconForPageUrl(str);
        } else {
            uVarA.c().d(str);
        }
    }

    public void removeAllIcons() {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        if (uVarA == null || !uVarA.b()) {
            android.webkit.WebIconDatabase.getInstance().removeAllIcons();
        } else {
            uVarA.c().l();
        }
    }

    public void requestIconForPageUrl(java.lang.String str, final com.tencent.smtt.sdk.WebIconDatabase.a aVar) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        if (uVarA == null || !uVarA.b()) {
            android.webkit.WebIconDatabase.getInstance().requestIconForPageUrl(str, new android.webkit.WebIconDatabase.IconListener() { // from class: com.tencent.smtt.sdk.WebIconDatabase.2
                @Override // android.webkit.WebIconDatabase.IconListener
                public void onReceivedIcon(java.lang.String str2, android.graphics.Bitmap bitmap) {
                    aVar.a(str2, bitmap);
                }
            });
        } else {
            uVarA.c().a(str, new com.tencent.smtt.export.external.interfaces.IconListener() { // from class: com.tencent.smtt.sdk.WebIconDatabase.1
                @Override // com.tencent.smtt.export.external.interfaces.IconListener
                public void onReceivedIcon(java.lang.String str2, android.graphics.Bitmap bitmap) {
                    aVar.a(str2, bitmap);
                }
            });
        }
    }

    public void retainIconForPageUrl(java.lang.String str) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        if (uVarA == null || !uVarA.b()) {
            android.webkit.WebIconDatabase.getInstance().retainIconForPageUrl(str);
        } else {
            uVarA.c().c(str);
        }
    }
}
