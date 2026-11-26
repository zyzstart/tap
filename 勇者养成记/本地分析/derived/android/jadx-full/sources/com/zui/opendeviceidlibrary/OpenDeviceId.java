package com.zui.opendeviceidlibrary;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.Keep
public class OpenDeviceId {

    @android.support.annotation.Keep
    private static java.lang.String c = "OpenDeviceId library";

    @android.support.annotation.Keep
    private static boolean d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @android.support.annotation.Keep
    private com.zui.deviceidservice.IDeviceidInterface f1653a;

    @android.support.annotation.Keep
    private com.zui.opendeviceidlibrary.OpenDeviceId.CallBack b;

    /* JADX INFO: renamed from: com.zui.opendeviceidlibrary.OpenDeviceId$1, reason: invalid class name */
    @android.support.annotation.Keep
    class AnonymousClass1 implements android.content.ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @android.support.annotation.Keep
        final /* synthetic */ com.zui.opendeviceidlibrary.OpenDeviceId f1654a;

        @Override // android.content.ServiceConnection
        @android.support.annotation.Keep
        public native synchronized void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder);

        @Override // android.content.ServiceConnection
        @android.support.annotation.Keep
        public native void onServiceDisconnected(android.content.ComponentName componentName);
    }

    @android.support.annotation.Keep
    public interface CallBack {
        @android.support.annotation.Keep
        void a(com.zui.opendeviceidlibrary.OpenDeviceId openDeviceId);
    }

    @android.support.annotation.Keep
    static native /* synthetic */ com.zui.deviceidservice.IDeviceidInterface a(com.zui.opendeviceidlibrary.OpenDeviceId openDeviceId, com.zui.deviceidservice.IDeviceidInterface iDeviceidInterface);

    @android.support.annotation.Keep
    static native /* synthetic */ com.zui.opendeviceidlibrary.OpenDeviceId.CallBack a(com.zui.opendeviceidlibrary.OpenDeviceId openDeviceId);

    @android.support.annotation.Keep
    static native /* synthetic */ void a(com.zui.opendeviceidlibrary.OpenDeviceId openDeviceId, java.lang.String str);

    @android.support.annotation.Keep
    private native void a(java.lang.String str);
}
