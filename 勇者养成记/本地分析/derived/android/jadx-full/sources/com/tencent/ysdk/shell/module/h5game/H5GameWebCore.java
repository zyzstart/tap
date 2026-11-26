package com.tencent.ysdk.shell.module.h5game;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class H5GameWebCore extends com.tencent.smtt.sdk.WebView {
    private com.tencent.ysdk.shell.framework.web.jsbridge.YYBJsBridgeProxy mJsBridge;

    public H5GameWebCore(android.content.Context context) {
        super(context);
        initJsBridge(context);
    }

    public H5GameWebCore(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        initJsBridge(context);
    }

    public H5GameWebCore(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initJsBridge(context);
    }

    public H5GameWebCore(android.content.Context context, android.util.AttributeSet attributeSet, int i, java.util.Map<java.lang.String, java.lang.Object> map, boolean z) {
        super(context, attributeSet, i, map, z);
        initJsBridge(context);
    }

    public H5GameWebCore(android.content.Context context, android.util.AttributeSet attributeSet, int i, boolean z) {
        super(context, attributeSet, i, z);
        initJsBridge(context);
    }

    private void initJsBridge(android.content.Context context) {
        this.mJsBridge = new com.tencent.ysdk.shell.framework.web.jsbridge.YYBJsBridgeProxy(this, context);
    }

    public com.tencent.ysdk.shell.framework.web.jsbridge.YYBJsBridgeProxy getJsBridge() {
        return this.mJsBridge;
    }
}
