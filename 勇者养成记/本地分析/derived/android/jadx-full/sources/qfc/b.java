package qfc;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b implements com.tencent.safecloud.device.openlib.SCCallback {
    private com.tencent.safecloud.device.openlib.SCCallback h;

    public b(com.tencent.safecloud.device.openlib.SCCallback sCCallback) {
        this.h = sCCallback;
    }

    @Override // com.tencent.safecloud.device.openlib.SCCallback
    public void onFail(int i) {
        com.tencent.safecloud.device.openlib.LogUtil.e(com.tencent.safecloud.device.openlib.ErrorManager.getErrorMsgAll());
        com.tencent.safecloud.device.openlib.SCCallback sCCallback = this.h;
        if (sCCallback != null) {
            sCCallback.onFail(i);
        }
    }

    @Override // com.tencent.safecloud.device.openlib.SCCallback
    public void onSuccess() {
        com.tencent.safecloud.device.openlib.SCCallback sCCallback = this.h;
        if (sCCallback != null) {
            sCCallback.onSuccess();
        }
    }
}
