package com.youme.im;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class NetworkStatusReceiver2 extends android.content.BroadcastReceiver {
    private static boolean m_isLastConnected = true;
    private static android.net.NetworkInfo m_lastActiveNetworkInfo;
    private static android.net.wifi.WifiInfo m_lastWifiInfo;

    public enum NetworkType {
        NETWORKTYPE_NONETWORK,
        NETWORKTYPE_MOBILE,
        NETWORKTYPE_WIFI,
        NETWORKTYPE_UNINET,
        NETWORKTYPE_UNIWAP,
        NETWORKTYPE_WAP_3G,
        NETWORKTYPE_NET_3G,
        NETWORKTYPE_CMWAP,
        NETWORKTYPE_CMNET,
        NETWORKTYPE_CTWAP,
        NETWORKTYPE_CTNET,
        NETWORKTYPE_LTE
    }

    public static com.youme.im.NetworkStatusReceiver2.NetworkType GetNetworkType(android.content.Context context) {
        android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return com.youme.im.NetworkStatusReceiver2.NetworkType.NETWORKTYPE_NONETWORK;
        }
        android.net.NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return com.youme.im.NetworkStatusReceiver2.NetworkType.NETWORKTYPE_NONETWORK;
        }
        return activeNetworkInfo.getType() == 1 ? com.youme.im.NetworkStatusReceiver2.NetworkType.NETWORKTYPE_WIFI : com.youme.im.NetworkStatusReceiver2.NetworkType.NETWORKTYPE_MOBILE;
    }

    public boolean IsNetworkChange(android.content.Context context, android.net.NetworkInfo networkInfo) {
        if (networkInfo.getType() == 1) {
            try {
                android.net.wifi.WifiInfo connectionInfo = ((android.net.wifi.WifiManager) context.getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo != null && m_lastWifiInfo != null && m_lastWifiInfo.getBSSID().equals(connectionInfo.getBSSID()) && m_lastWifiInfo.getSSID().equals(connectionInfo.getSSID()) && m_lastWifiInfo.getNetworkId() == connectionInfo.getNetworkId()) {
                    android.util.Log.i("NetworkStatusReceiver", "return same Wifi");
                    return false;
                }
                m_lastWifiInfo = connectionInfo;
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                android.util.Log.e("NetworkStatusReceiver", "getConnectionInfo failed.");
            }
        } else {
            android.net.NetworkInfo networkInfo2 = m_lastActiveNetworkInfo;
            if (networkInfo2 != null && networkInfo2.getExtraInfo() != null && networkInfo.getExtraInfo() != null && m_lastActiveNetworkInfo.getExtraInfo().equals(networkInfo.getExtraInfo()) && m_lastActiveNetworkInfo.getSubtype() == networkInfo.getSubtype() && m_lastActiveNetworkInfo.getType() == networkInfo.getType()) {
                android.util.Log.i("NetworkStatusReceiver", "return same newtwork");
                return false;
            }
            android.net.NetworkInfo networkInfo3 = m_lastActiveNetworkInfo;
            if (networkInfo3 != null && networkInfo3.getExtraInfo() == null && networkInfo.getExtraInfo() == null && m_lastActiveNetworkInfo.getSubtype() == networkInfo.getSubtype() && m_lastActiveNetworkInfo.getType() == networkInfo.getType()) {
                android.util.Log.i("NetworkStatusReceiver", "return same newtwork 2");
                return false;
            }
        }
        m_lastActiveNetworkInfo = networkInfo;
        return true;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        android.net.NetworkInfo activeNetworkInfo;
        if (context == null || intent == null) {
            return;
        }
        try {
            activeNetworkInfo = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            android.util.Log.e("NetworkStatusReceiver", "getActiveNetworkInfo failed.");
            activeNetworkInfo = null;
        }
        if (activeNetworkInfo == null) {
            m_lastActiveNetworkInfo = null;
            m_lastWifiInfo = null;
            if (com.youme.im.IMEngine.m_init) {
                com.youme.im.NativeEngine.onNetWorkChanged(com.youme.im.NetworkStatusReceiver2.NetworkType.NETWORKTYPE_NONETWORK.ordinal());
                return;
            }
            return;
        }
        if (activeNetworkInfo.getDetailedState() != android.net.NetworkInfo.DetailedState.CONNECTED) {
            if (m_isLastConnected) {
                m_lastActiveNetworkInfo = null;
                m_lastWifiInfo = null;
                if (com.youme.im.IMEngine.m_init) {
                    com.youme.im.NativeEngine.onNetWorkChanged(com.youme.im.NetworkStatusReceiver2.NetworkType.NETWORKTYPE_NONETWORK.ordinal());
                }
            }
            m_isLastConnected = false;
            return;
        }
        if (IsNetworkChange(context, activeNetworkInfo)) {
            com.youme.im.NetworkStatusReceiver2.NetworkType networkType = com.youme.im.NetworkStatusReceiver2.NetworkType.NETWORKTYPE_NONETWORK;
            com.youme.im.NetworkStatusReceiver2.NetworkType networkType2 = activeNetworkInfo.getType() == 1 ? com.youme.im.NetworkStatusReceiver2.NetworkType.NETWORKTYPE_WIFI : com.youme.im.NetworkStatusReceiver2.NetworkType.NETWORKTYPE_MOBILE;
            if (com.youme.im.IMEngine.m_init) {
                com.youme.im.NativeEngine.onNetWorkChanged(networkType2.ordinal());
            }
        }
        m_isLastConnected = true;
    }
}
