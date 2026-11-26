package com.tencent.ysdk.shell.framework.floatingwindow;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface IShowFloatingWindowCommand {

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface FloatingWindowType {
        public static final int FLOATING_AD = 3;
        public static final int FLOATING_BALL = 1;
        public static final int FLOATING_GUEST = 4;
        public static final int FLOATING_MSG = 2;
    }

    void execute();

    int getFloatingWindowType();
}
