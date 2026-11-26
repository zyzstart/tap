package com.meizu.flyme.openidsdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.Keep
public class b {

    @android.support.annotation.Keep
    public static volatile com.meizu.flyme.openidsdk.b g;

    @android.support.annotation.Keep
    public static boolean h;

    @android.support.annotation.Keep
    public java.lang.Boolean e;

    @android.support.annotation.Keep
    public android.content.BroadcastReceiver f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @android.support.annotation.Keep
    public com.meizu.flyme.openidsdk.OpenId f61a = new com.meizu.flyme.openidsdk.OpenId("udid");

    @android.support.annotation.Keep
    public com.meizu.flyme.openidsdk.OpenId b = new com.meizu.flyme.openidsdk.OpenId(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_USER_PARAM_OAID);

    @android.support.annotation.Keep
    public com.meizu.flyme.openidsdk.OpenId d = new com.meizu.flyme.openidsdk.OpenId("vaid");

    @android.support.annotation.Keep
    public com.meizu.flyme.openidsdk.OpenId c = new com.meizu.flyme.openidsdk.OpenId("aaid");

    @android.support.annotation.Keep
    public b() {
    }

    @android.support.annotation.Keep
    public static native com.meizu.flyme.openidsdk.ValueData a(android.database.Cursor cursor);

    @android.support.annotation.Keep
    public static final native com.meizu.flyme.openidsdk.b a();

    @android.support.annotation.Keep
    public static native void b(java.lang.String str);

    @android.support.annotation.Keep
    public native com.meizu.flyme.openidsdk.OpenId a(java.lang.String str);

    @android.support.annotation.Keep
    public final native java.lang.String a(android.content.Context context, com.meizu.flyme.openidsdk.OpenId openId);

    @android.support.annotation.Keep
    public final native synchronized void a(android.content.Context context);

    @android.support.annotation.Keep
    public final native boolean a(android.content.Context context, boolean z);
}
