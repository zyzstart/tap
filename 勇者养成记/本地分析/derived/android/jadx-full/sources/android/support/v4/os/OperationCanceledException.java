package android.support.v4.os;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class OperationCanceledException extends java.lang.RuntimeException {
    public OperationCanceledException() {
        this(null);
    }

    public OperationCanceledException(java.lang.String str) {
        super(str == null ? "The operation has been canceled." : str);
    }
}
