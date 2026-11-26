package com.tencent.ysdk.shell.module.icon.impl.bubble;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class AbstractBubbleCommand implements com.tencent.ysdk.module.icon.IBubbleCommand {
    private static final java.lang.String TAG = "AbstractBubbleCommand";

    AbstractBubbleCommand() {
    }

    @Override // com.tencent.ysdk.module.icon.IBubbleCommand
    public final void execute() {
        try {
            if (interceptBubble()) {
                return;
            }
            executeInner();
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, e);
        }
    }

    protected abstract void executeInner();

    protected boolean interceptBubble() {
        return false;
    }
}
