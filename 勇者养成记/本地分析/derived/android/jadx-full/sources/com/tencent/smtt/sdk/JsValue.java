package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class JsValue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.tencent.smtt.sdk.JsContext f812a;
    private final com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue b;

    private static class a implements com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue.JsValueFactory {
        private a() {
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue.JsValueFactory
        public java.lang.String getJsValueClassName() {
            return com.tencent.smtt.sdk.JsValue.class.getName();
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue.JsValueFactory
        public com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue unwrap(java.lang.Object obj) {
            if (obj == null || !(obj instanceof com.tencent.smtt.sdk.JsValue)) {
                return null;
            }
            return ((com.tencent.smtt.sdk.JsValue) obj).b;
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue.JsValueFactory
        public java.lang.Object wrap(com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue iX5JsValue) {
            com.tencent.smtt.sdk.JsContext jsContextCurrent;
            if (iX5JsValue == null || (jsContextCurrent = com.tencent.smtt.sdk.JsContext.current()) == null) {
                return null;
            }
            return new com.tencent.smtt.sdk.JsValue(jsContextCurrent, iX5JsValue);
        }
    }

    protected JsValue(com.tencent.smtt.sdk.JsContext jsContext, com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue iX5JsValue) {
        this.f812a = jsContext;
        this.b = iX5JsValue;
    }

    protected static com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue.JsValueFactory a() {
        return new com.tencent.smtt.sdk.JsValue.a();
    }

    private com.tencent.smtt.sdk.JsValue a(com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue iX5JsValue) {
        if (iX5JsValue == null) {
            return null;
        }
        return new com.tencent.smtt.sdk.JsValue(this.f812a, iX5JsValue);
    }

    public com.tencent.smtt.sdk.JsValue call(java.lang.Object... objArr) {
        return a(this.b.call(objArr));
    }

    public com.tencent.smtt.sdk.JsValue construct(java.lang.Object... objArr) {
        return a(this.b.construct(objArr));
    }

    public com.tencent.smtt.sdk.JsContext context() {
        return this.f812a;
    }

    public boolean isArray() {
        return this.b.isArray();
    }

    public boolean isArrayBufferOrArrayBufferView() {
        return this.b.isArrayBufferOrArrayBufferView();
    }

    public boolean isBoolean() {
        return this.b.isBoolean();
    }

    public boolean isFunction() {
        return this.b.isFunction();
    }

    public boolean isInteger() {
        return this.b.isInteger();
    }

    public boolean isJavascriptInterface() {
        return this.b.isJavascriptInterface();
    }

    public boolean isNull() {
        return this.b.isNull();
    }

    public boolean isNumber() {
        return this.b.isNumber();
    }

    public boolean isObject() {
        return this.b.isObject();
    }

    public boolean isPromise() {
        return this.b.isPromise();
    }

    public boolean isString() {
        return this.b.isString();
    }

    public boolean isUndefined() {
        return this.b.isUndefined();
    }

    public void reject(java.lang.Object obj) {
        this.b.resolveOrReject(obj, false);
    }

    public void resolve(java.lang.Object obj) {
        this.b.resolveOrReject(obj, true);
    }

    public boolean toBoolean() {
        return this.b.toBoolean();
    }

    public java.nio.ByteBuffer toByteBuffer() {
        return this.b.toByteBuffer();
    }

    public int toInteger() {
        return this.b.toInteger();
    }

    public java.lang.Object toJavascriptInterface() {
        return this.b.toJavascriptInterface();
    }

    public java.lang.Number toNumber() {
        return this.b.toNumber();
    }

    public java.lang.Object toObject(java.lang.Class cls) {
        return this.b.toObject(cls);
    }

    public java.lang.String toString() {
        return this.b.toString();
    }
}
