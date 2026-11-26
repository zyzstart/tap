package com.tencent.bugly.crashreport.crash;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class CrashDetailBean implements android.os.Parcelable, java.lang.Comparable<com.tencent.bugly.crashreport.crash.CrashDetailBean> {
    public static final android.os.Parcelable.Creator<com.tencent.bugly.crashreport.crash.CrashDetailBean> CREATOR = new android.os.Parcelable.Creator<com.tencent.bugly.crashreport.crash.CrashDetailBean>() { // from class: com.tencent.bugly.crashreport.crash.CrashDetailBean.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.tencent.bugly.crashreport.crash.CrashDetailBean createFromParcel(android.os.Parcel parcel) {
            return new com.tencent.bugly.crashreport.crash.CrashDetailBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.tencent.bugly.crashreport.crash.CrashDetailBean[] newArray(int i) {
            return new com.tencent.bugly.crashreport.crash.CrashDetailBean[i];
        }
    };
    public java.lang.String A;
    public java.lang.String B;
    public long C;
    public long D;
    public long E;
    public long F;
    public long G;
    public long H;
    public java.lang.String I;
    public java.lang.String J;
    public java.lang.String K;
    public java.lang.String L;
    public long M;
    public boolean N;
    public java.util.Map<java.lang.String, java.lang.String> O;
    public int P;
    public int Q;
    public java.util.Map<java.lang.String, java.lang.String> R;
    public java.util.Map<java.lang.String, java.lang.String> S;
    public byte[] T;
    public java.lang.String U;
    public java.lang.String V;
    private java.lang.String W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f299a;
    public int b;
    public java.lang.String c;
    public boolean d;
    public java.lang.String e;
    public java.lang.String f;
    public java.lang.String g;
    public java.util.Map<java.lang.String, com.tencent.bugly.crashreport.common.info.PlugInBean> h;
    public java.util.Map<java.lang.String, com.tencent.bugly.crashreport.common.info.PlugInBean> i;
    public boolean j;
    public boolean k;
    public int l;
    public java.lang.String m;
    public java.lang.String n;
    public java.lang.String o;
    public java.lang.String p;
    public java.lang.String q;
    public long r;
    public java.lang.String s;
    public int t;
    public java.lang.String u;
    public java.lang.String v;
    public java.lang.String w;
    public java.lang.String x;
    public byte[] y;
    public java.util.Map<java.lang.String, java.lang.String> z;

    public CrashDetailBean() {
        this.f299a = -1L;
        this.b = 0;
        this.c = java.util.UUID.randomUUID().toString();
        this.d = false;
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = null;
        this.i = null;
        this.j = false;
        this.k = false;
        this.l = 0;
        this.m = "";
        this.n = "";
        this.o = "";
        this.p = "";
        this.q = "";
        this.r = -1L;
        this.s = null;
        this.t = 0;
        this.u = "";
        this.v = "";
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = "";
        this.B = "";
        this.C = -1L;
        this.D = -1L;
        this.E = -1L;
        this.F = -1L;
        this.G = -1L;
        this.H = -1L;
        this.I = "";
        this.W = "";
        this.J = "";
        this.K = "";
        this.L = "";
        this.M = -1L;
        this.N = false;
        this.O = null;
        this.P = -1;
        this.Q = -1;
        this.R = null;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
    }

    public CrashDetailBean(android.os.Parcel parcel) {
        this.f299a = -1L;
        this.b = 0;
        this.c = java.util.UUID.randomUUID().toString();
        this.d = false;
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = null;
        this.i = null;
        this.j = false;
        this.k = false;
        this.l = 0;
        this.m = "";
        this.n = "";
        this.o = "";
        this.p = "";
        this.q = "";
        this.r = -1L;
        this.s = null;
        this.t = 0;
        this.u = "";
        this.v = "";
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = "";
        this.B = "";
        this.C = -1L;
        this.D = -1L;
        this.E = -1L;
        this.F = -1L;
        this.G = -1L;
        this.H = -1L;
        this.I = "";
        this.W = "";
        this.J = "";
        this.K = "";
        this.L = "";
        this.M = -1L;
        this.N = false;
        this.O = null;
        this.P = -1;
        this.Q = -1;
        this.R = null;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.b = parcel.readInt();
        this.c = parcel.readString();
        this.d = parcel.readByte() == 1;
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.j = parcel.readByte() == 1;
        this.k = parcel.readByte() == 1;
        this.l = parcel.readInt();
        this.m = parcel.readString();
        this.n = parcel.readString();
        this.o = parcel.readString();
        this.p = parcel.readString();
        this.q = parcel.readString();
        this.r = parcel.readLong();
        this.s = parcel.readString();
        this.t = parcel.readInt();
        this.u = parcel.readString();
        this.v = parcel.readString();
        this.w = parcel.readString();
        this.z = com.tencent.bugly.proguard.z.b(parcel);
        this.A = parcel.readString();
        this.B = parcel.readString();
        this.C = parcel.readLong();
        this.D = parcel.readLong();
        this.E = parcel.readLong();
        this.F = parcel.readLong();
        this.G = parcel.readLong();
        this.H = parcel.readLong();
        this.I = parcel.readString();
        this.W = parcel.readString();
        this.J = parcel.readString();
        this.K = parcel.readString();
        this.L = parcel.readString();
        this.M = parcel.readLong();
        this.N = parcel.readByte() == 1;
        this.O = com.tencent.bugly.proguard.z.b(parcel);
        this.h = com.tencent.bugly.proguard.z.a(parcel);
        this.i = com.tencent.bugly.proguard.z.a(parcel);
        this.P = parcel.readInt();
        this.Q = parcel.readInt();
        this.R = com.tencent.bugly.proguard.z.b(parcel);
        this.S = com.tencent.bugly.proguard.z.b(parcel);
        this.T = parcel.createByteArray();
        this.y = parcel.createByteArray();
        this.U = parcel.readString();
        this.V = parcel.readString();
        this.x = parcel.readString();
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(com.tencent.bugly.crashreport.crash.CrashDetailBean crashDetailBean) {
        com.tencent.bugly.crashreport.crash.CrashDetailBean crashDetailBean2 = crashDetailBean;
        if (crashDetailBean2 == null) {
            return 1;
        }
        long j = this.r - crashDetailBean2.r;
        if (j <= 0) {
            return j < 0 ? -1 : 0;
        }
        return 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeInt(this.b);
        parcel.writeString(this.c);
        parcel.writeByte(this.d ? (byte) 1 : (byte) 0);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeByte(this.j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.k ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.l);
        parcel.writeString(this.m);
        parcel.writeString(this.n);
        parcel.writeString(this.o);
        parcel.writeString(this.p);
        parcel.writeString(this.q);
        parcel.writeLong(this.r);
        parcel.writeString(this.s);
        parcel.writeInt(this.t);
        parcel.writeString(this.u);
        parcel.writeString(this.v);
        parcel.writeString(this.w);
        com.tencent.bugly.proguard.z.b(parcel, this.z);
        parcel.writeString(this.A);
        parcel.writeString(this.B);
        parcel.writeLong(this.C);
        parcel.writeLong(this.D);
        parcel.writeLong(this.E);
        parcel.writeLong(this.F);
        parcel.writeLong(this.G);
        parcel.writeLong(this.H);
        parcel.writeString(this.I);
        parcel.writeString(this.W);
        parcel.writeString(this.J);
        parcel.writeString(this.K);
        parcel.writeString(this.L);
        parcel.writeLong(this.M);
        parcel.writeByte(this.N ? (byte) 1 : (byte) 0);
        com.tencent.bugly.proguard.z.b(parcel, this.O);
        com.tencent.bugly.proguard.z.a(parcel, this.h);
        com.tencent.bugly.proguard.z.a(parcel, this.i);
        parcel.writeInt(this.P);
        parcel.writeInt(this.Q);
        com.tencent.bugly.proguard.z.b(parcel, this.R);
        com.tencent.bugly.proguard.z.b(parcel, this.S);
        parcel.writeByteArray(this.T);
        parcel.writeByteArray(this.y);
        parcel.writeString(this.U);
        parcel.writeString(this.V);
        parcel.writeString(this.x);
    }
}
