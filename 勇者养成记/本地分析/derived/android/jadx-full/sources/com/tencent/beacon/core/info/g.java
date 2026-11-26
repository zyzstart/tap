package com.tencent.beacon.core.info;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class g extends com.tencent.beacon.core.info.b {
    private static volatile com.tencent.beacon.core.info.g q;
    private android.content.Context r;
    private java.util.Map s;
    private java.lang.String t;

    public g(android.content.Context context) {
        super(context);
        this.s = new java.util.HashMap();
        this.t = "";
        this.r = context;
    }

    public static com.tencent.beacon.core.info.g b(android.content.Context context) {
        if (q == null) {
            synchronized (com.tencent.beacon.core.info.g.class) {
                if (q == null) {
                    q = new com.tencent.beacon.core.info.g(context);
                }
            }
        }
        return q;
    }

    @Override // com.tencent.beacon.core.info.b
    public synchronized java.lang.String a(java.lang.String str) {
        com.tencent.beacon.upload.TunnelInfo tunnelInfo;
        return (com.tencent.beacon.core.e.j.b(str) || (tunnelInfo = (com.tencent.beacon.upload.TunnelInfo) this.s.get(str)) == null || com.tencent.beacon.core.e.j.b(tunnelInfo.version)) ? com.tencent.beacon.core.info.b.b(this.r).a(str) : tunnelInfo.version;
    }

    public synchronized void a(java.lang.String str, com.tencent.beacon.upload.TunnelInfo tunnelInfo) {
        this.s.put(str, tunnelInfo);
    }

    @Override // com.tencent.beacon.core.info.b
    public synchronized java.lang.String b(java.lang.String str) {
        com.tencent.beacon.upload.TunnelInfo tunnelInfo;
        return (com.tencent.beacon.core.e.j.b(str) || (tunnelInfo = (com.tencent.beacon.upload.TunnelInfo) this.s.get(str)) == null || com.tencent.beacon.core.e.j.b(tunnelInfo.channel)) ? com.tencent.beacon.core.info.b.b(this.r).b(str) : tunnelInfo.channel;
    }

    @Override // com.tencent.beacon.core.info.b
    public synchronized java.lang.String d() {
        return com.tencent.beacon.core.info.b.b(this.r).d();
    }

    public void d(java.lang.String str) {
        if (str != null) {
            this.t = str;
            com.tencent.beacon.core.e.d.a("[core] -> JavaScript clientID:" + this.t, new java.lang.Object[0]);
        }
    }

    @Override // com.tencent.beacon.core.info.b
    public synchronized long j() {
        return com.tencent.beacon.core.info.b.b(this.r).j();
    }

    public synchronized java.lang.String l() {
        return this.t;
    }
}
