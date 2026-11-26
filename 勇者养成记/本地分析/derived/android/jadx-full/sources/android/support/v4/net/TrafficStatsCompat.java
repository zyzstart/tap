package android.support.v4.net;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class TrafficStatsCompat {
    private static final android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatBaseImpl IMPL;

    @android.support.annotation.RequiresApi(24)
    static class TrafficStatsCompatApi24Impl extends android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatBaseImpl {
        TrafficStatsCompatApi24Impl() {
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatBaseImpl
        public void tagDatagramSocket(java.net.DatagramSocket datagramSocket) throws java.net.SocketException {
            android.net.TrafficStats.tagDatagramSocket(datagramSocket);
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatBaseImpl
        public void untagDatagramSocket(java.net.DatagramSocket datagramSocket) throws java.net.SocketException {
            android.net.TrafficStats.untagDatagramSocket(datagramSocket);
        }
    }

    static class TrafficStatsCompatBaseImpl {
        TrafficStatsCompatBaseImpl() {
        }

        public void tagDatagramSocket(java.net.DatagramSocket datagramSocket) throws java.net.SocketException {
            android.os.ParcelFileDescriptor parcelFileDescriptorFromDatagramSocket = android.os.ParcelFileDescriptor.fromDatagramSocket(datagramSocket);
            android.net.TrafficStats.tagSocket(new android.support.v4.net.DatagramSocketWrapper(datagramSocket, parcelFileDescriptorFromDatagramSocket.getFileDescriptor()));
            parcelFileDescriptorFromDatagramSocket.detachFd();
        }

        public void untagDatagramSocket(java.net.DatagramSocket datagramSocket) throws java.net.SocketException {
            android.os.ParcelFileDescriptor parcelFileDescriptorFromDatagramSocket = android.os.ParcelFileDescriptor.fromDatagramSocket(datagramSocket);
            android.net.TrafficStats.untagSocket(new android.support.v4.net.DatagramSocketWrapper(datagramSocket, parcelFileDescriptorFromDatagramSocket.getFileDescriptor()));
            parcelFileDescriptorFromDatagramSocket.detachFd();
        }
    }

    static {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            IMPL = new android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatApi24Impl();
        } else {
            IMPL = new android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatBaseImpl();
        }
    }

    private TrafficStatsCompat() {
    }

    @java.lang.Deprecated
    public static void clearThreadStatsTag() {
        android.net.TrafficStats.clearThreadStatsTag();
    }

    @java.lang.Deprecated
    public static int getThreadStatsTag() {
        return android.net.TrafficStats.getThreadStatsTag();
    }

    @java.lang.Deprecated
    public static void incrementOperationCount(int i) {
        android.net.TrafficStats.incrementOperationCount(i);
    }

    @java.lang.Deprecated
    public static void incrementOperationCount(int i, int i2) {
        android.net.TrafficStats.incrementOperationCount(i, i2);
    }

    @java.lang.Deprecated
    public static void setThreadStatsTag(int i) {
        android.net.TrafficStats.setThreadStatsTag(i);
    }

    public static void tagDatagramSocket(java.net.DatagramSocket datagramSocket) throws java.net.SocketException {
        IMPL.tagDatagramSocket(datagramSocket);
    }

    @java.lang.Deprecated
    public static void tagSocket(java.net.Socket socket) throws java.net.SocketException {
        android.net.TrafficStats.tagSocket(socket);
    }

    public static void untagDatagramSocket(java.net.DatagramSocket datagramSocket) throws java.net.SocketException {
        IMPL.untagDatagramSocket(datagramSocket);
    }

    @java.lang.Deprecated
    public static void untagSocket(java.net.Socket socket) throws java.net.SocketException {
        android.net.TrafficStats.untagSocket(socket);
    }
}
