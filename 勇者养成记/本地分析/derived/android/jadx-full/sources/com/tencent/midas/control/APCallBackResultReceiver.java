package com.tencent.midas.control;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APCallBackResultReceiver extends android.os.ResultReceiver {
    private com.tencent.midas.control.APCallBackResultReceiver.Receiver mReceiver;

    public interface Receiver {
        void onReceiveResult(int i, android.os.Bundle bundle);
    }

    public APCallBackResultReceiver(android.os.Handler handler) {
        super(handler);
    }

    @Override // android.os.ResultReceiver
    protected void onReceiveResult(int i, android.os.Bundle bundle) {
        com.tencent.midas.comm.APLog.i("APCallBackResultReceiver", "onReceiveResult resultCode:" + i + " mReceiver:" + this.mReceiver);
        com.tencent.midas.control.APCallBackResultReceiver.Receiver receiver = this.mReceiver;
        if (receiver != null) {
            receiver.onReceiveResult(i, bundle);
        }
    }

    public void setReceiver(com.tencent.midas.control.APCallBackResultReceiver.Receiver receiver) {
        this.mReceiver = receiver;
    }
}
