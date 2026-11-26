package com.tencent.ysdk.shell.module.stat;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class StatConstants {

    public enum EventType {
        Default(com.tencent.ysdk.shell.framework.request.HttpRequest.ENCRYPT_TYPE_DEFAULT_VAL),
        Show("view"),
        Click("click"),
        Media("media");

        private java.lang.String value;

        EventType(java.lang.String str) {
            this.value = str;
        }

        public java.lang.String val() {
            return java.lang.String.valueOf(this.value);
        }
    }

    public enum PageType {
        PopWindow(1),
        FloatWindow(2);

        private int value;

        PageType(int i) {
            this.value = i;
        }

        public java.lang.String val() {
            return java.lang.String.valueOf(this.value);
        }
    }
}
