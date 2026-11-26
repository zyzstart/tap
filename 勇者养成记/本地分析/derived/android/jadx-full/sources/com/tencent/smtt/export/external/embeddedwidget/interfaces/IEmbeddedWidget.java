package com.tencent.smtt.export.external.embeddedwidget.interfaces;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface IEmbeddedWidget {

    public enum EventResponseType {
        UNKNOWN,
        CONSUME_EVENT,
        NOT_CONSUME_EVENT
    }

    void evaluateJavascript(java.lang.String str, android.webkit.ValueCallback valueCallback);

    long getWidgetId();

    void onClientError(com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient iEmbeddedWidgetClient);

    void setEventResponseType(com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidget.EventResponseType eventResponseType);
}
