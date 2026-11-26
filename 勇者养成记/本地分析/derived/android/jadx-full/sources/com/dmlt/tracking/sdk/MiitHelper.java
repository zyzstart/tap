package com.dmlt.tracking.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class MiitHelper implements com.bun.supplier.IIdentifierListener {
    private com.dmlt.tracking.sdk.MiitHelper.AppIdsUpdater _listener;

    public interface AppIdsUpdater {
        void OnIdsAvalid(@androidx.annotation.NonNull java.lang.String str);

        void OnIdsOAID(@androidx.annotation.NonNull java.lang.String str);
    }

    public MiitHelper(com.dmlt.tracking.sdk.MiitHelper.AppIdsUpdater appIdsUpdater) {
        this._listener = appIdsUpdater;
    }

    private int CallFromReflect(android.content.Context context) {
        return com.bun.miitmdid.core.MdidSdkHelper.InitSdk(context, true, this);
    }

    @Override // com.bun.supplier.IIdentifierListener
    public void OnSupport(boolean z, com.bun.supplier.IdSupplier idSupplier) {
        if (idSupplier == null) {
            return;
        }
        java.lang.String oaid = idSupplier.getOAID();
        java.lang.String vaid = idSupplier.getVAID();
        java.lang.String aaid = idSupplier.getAAID();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("support: ");
        sb.append(z ? com.tencent.ysdk.shell.framework.config.Config.VALUE_SWITCH_ON : "false");
        sb.append("\n");
        sb.append("OAID: ");
        sb.append(oaid);
        sb.append("\n");
        sb.append("VAID: ");
        sb.append(vaid);
        sb.append("\n");
        sb.append("AAID: ");
        sb.append(aaid);
        sb.append("\n");
        java.lang.String string = sb.toString();
        com.dmlt.tracking.sdk.MiitHelper.AppIdsUpdater appIdsUpdater = this._listener;
        if (appIdsUpdater != null) {
            appIdsUpdater.OnIdsAvalid(string);
            this._listener.OnIdsOAID(oaid);
        }
    }

    public void getDeviceIds(android.content.Context context) {
        java.lang.System.currentTimeMillis();
        int iCallFromReflect = CallFromReflect(context);
        java.lang.System.currentTimeMillis();
        if (iCallFromReflect != 1008612 && iCallFromReflect != 1008613 && iCallFromReflect == 1008611) {
        }
        android.util.Log.d(getClass().getSimpleName(), "return value: " + java.lang.String.valueOf(iCallFromReflect));
    }
}
