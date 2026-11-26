package com.tencent.ysdk.framework.dynamic.invoke;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class PluginCall {
    private com.tencent.ysdk.framework.dynamic.utils.Reflect reflect;

    private PluginCall(java.lang.String str) {
        com.tencent.ysdk.framework.dynamic.manager.LoadedPluginInfo loadedPluginInfo = com.tencent.ysdk.framework.dynamic.manager.PluginManager.getInstance().getLoadedPluginInfo();
        if (loadedPluginInfo != null) {
            this.reflect = com.tencent.ysdk.framework.dynamic.utils.Reflect.on(str, loadedPluginInfo.getClassLoader());
        }
    }

    public static com.tencent.ysdk.framework.dynamic.invoke.PluginCall on(java.lang.String str) {
        return new com.tencent.ysdk.framework.dynamic.invoke.PluginCall(str);
    }

    public com.tencent.ysdk.framework.dynamic.invoke.PluginCall call(java.lang.String str, java.lang.Object... objArr) {
        com.tencent.ysdk.framework.dynamic.utils.Reflect reflect = this.reflect;
        if (reflect == null) {
            throw new com.tencent.ysdk.framework.dynamic.exception.PluginCallException("reflect object is null! the plugin may not loaded!");
        }
        this.reflect = reflect.call(str, objArr);
        return this;
    }

    public java.lang.Object get() {
        return this.reflect.get();
    }
}
