package com.tencent.ysdk.shell.framework.floatingwindow;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class AbstractFloatingWindowCommand implements com.tencent.ysdk.shell.framework.floatingwindow.IShowFloatingWindowCommand {
    private static final java.lang.String TAG = "FloatingWindowCommand";
    private int floatingWindowType;

    public AbstractFloatingWindowCommand(int i) {
        this.floatingWindowType = i;
    }

    @Override // com.tencent.ysdk.shell.framework.floatingwindow.IShowFloatingWindowCommand
    public final void execute() {
        try {
            executeWithTryCatch();
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, e);
        }
    }

    protected abstract void executeWithTryCatch();

    @Override // com.tencent.ysdk.shell.framework.floatingwindow.IShowFloatingWindowCommand
    public int getFloatingWindowType() {
        return this.floatingWindowType;
    }
}
