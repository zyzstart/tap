package com.tencent.smtt.export.external.jscore.interfaces;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface IX5JsValue {

    public interface JsValueFactory {
        java.lang.String getJsValueClassName();

        com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue unwrap(java.lang.Object obj);

        java.lang.Object wrap(com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue iX5JsValue);
    }

    com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue call(java.lang.Object[] objArr);

    com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue construct(java.lang.Object[] objArr);

    boolean isArray();

    boolean isArrayBufferOrArrayBufferView();

    boolean isBoolean();

    boolean isFunction();

    boolean isInteger();

    boolean isJavascriptInterface();

    boolean isNull();

    boolean isNumber();

    boolean isObject();

    boolean isPromise();

    boolean isString();

    boolean isUndefined();

    void resolveOrReject(java.lang.Object obj, boolean z);

    boolean toBoolean();

    java.nio.ByteBuffer toByteBuffer();

    int toInteger();

    java.lang.Object toJavascriptInterface();

    java.lang.Number toNumber();

    java.lang.Object toObject(java.lang.Class cls);

    java.lang.String toString();
}
