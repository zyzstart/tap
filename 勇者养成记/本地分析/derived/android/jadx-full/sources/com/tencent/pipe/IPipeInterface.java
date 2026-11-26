package com.tencent.pipe;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface IPipeInterface extends android.os.IInterface {
    public static final java.lang.String CMD_MIDASPAYCALLBACK = "MidasPayCallBack";
    public static final java.lang.String CMD_MIDASPAYNEEDLOGIN = "MidasPayNeedLogin";
    public static final java.lang.String CMD_PLUGIN_FAILED = "PluginLoadFailed";
    public static final int EVENT_CRASH_INSTALL_APK = 304;
    public static final int EVENT_FREE_LOGIN = 16;
    public static final int EVENT_INSTALL_APK = 303;
    public static final int EVENT_MARK_SANDBOX = 1;
    public static final int EVENT_PAY_CALLBACK = 302;
    public static final int EVENT_PAY_GOODS = 4096;
    public static final int EVENT_PAY_IS_LOGIN = 301;
    public static final int EVENT_PAY_RECHARGE = 256;
    public static final int EVENT_PLUGIN_QQ_LOGIN = 402;
    public static final int EVENT_SANDBOX_QQ_LOGIN = 401;
    public static final java.lang.String KEY_APP_ID = "appid";
    public static final java.lang.String KEY_CALLBACK_CMD = "callback_cmd";
    public static final java.lang.String KEY_IS_LOGIN = "isLogin";
    public static final java.lang.String KEY_LOGIN_INFO = "loginInfo";
    public static final java.lang.String KEY_NEED_LOGIN_INFO = "need_login_info";
    public static final java.lang.String KEY_OFFER_ID = "offerid";
    public static final java.lang.String KEY_OPEN_ID = "openid";
    public static final java.lang.String KEY_PACKAGENAME = "packageName";
    public static final java.lang.String KEY_PAY_ID = "payid";
    public static final java.lang.String KEY_REQUEST = "pay_request";
    public static final java.lang.String KEY_SESSION_ID = "sessionId";
    public static final java.lang.String KEY_SESSION_TYPE = "sessionType";

    public static class Default implements com.tencent.pipe.IPipeInterface {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.pipe.IPipeInterface
        public java.util.Map sendEvent(int i, java.util.Map map) {
            return null;
        }
    }

    public static abstract class Stub extends android.os.Binder implements com.tencent.pipe.IPipeInterface {
        private static final java.lang.String DESCRIPTOR = "com.tencent.pipe.IPipeInterface";
        static final int TRANSACTION_sendEvent = 1;

        private static class Proxy implements com.tencent.pipe.IPipeInterface {
            public static com.tencent.pipe.IPipeInterface sDefaultImpl;
            private android.os.IBinder mRemote;

            Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            public java.lang.String getInterfaceDescriptor() {
                return com.tencent.pipe.IPipeInterface.Stub.DESCRIPTOR;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.tencent.pipe.IPipeInterface
            public java.util.Map sendEvent(int i, java.util.Map map) {
                java.util.Map hashMap;
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.tencent.pipe.IPipeInterface.Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeMap(map);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || com.tencent.pipe.IPipeInterface.Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        hashMap = parcelObtain2.readHashMap(getClass().getClassLoader());
                    } else {
                        hashMap = com.tencent.pipe.IPipeInterface.Stub.getDefaultImpl().sendEvent(i, map);
                    }
                    return hashMap;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static com.tencent.pipe.IPipeInterface asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof com.tencent.pipe.IPipeInterface)) ? new com.tencent.pipe.IPipeInterface.Stub.Proxy(iBinder) : (com.tencent.pipe.IPipeInterface) iInterfaceQueryLocalInterface;
        }

        public static com.tencent.pipe.IPipeInterface getDefaultImpl() {
            return com.tencent.pipe.IPipeInterface.Stub.Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(com.tencent.pipe.IPipeInterface iPipeInterface) {
            if (com.tencent.pipe.IPipeInterface.Stub.Proxy.sDefaultImpl != null || iPipeInterface == null) {
                return false;
            }
            com.tencent.pipe.IPipeInterface.Stub.Proxy.sDefaultImpl = iPipeInterface;
            return true;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            java.util.Map mapSendEvent = sendEvent(parcel.readInt(), parcel.readHashMap(getClass().getClassLoader()));
            parcel2.writeNoException();
            parcel2.writeMap(mapSendEvent);
            return true;
        }
    }

    java.util.Map sendEvent(int i, java.util.Map map);
}
