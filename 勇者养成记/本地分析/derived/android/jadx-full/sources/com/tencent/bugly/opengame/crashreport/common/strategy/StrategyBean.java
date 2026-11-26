package com.tencent.bugly.opengame.crashreport.common.strategy;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class StrategyBean implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() { // from class: com.tencent.bugly.opengame.crashreport.common.strategy.StrategyBean.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel parcel) {
            return new com.tencent.bugly.opengame.crashreport.common.strategy.StrategyBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ java.lang.Object[] newArray(int i) {
            return new com.tencent.bugly.opengame.crashreport.common.strategy.StrategyBean[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static java.lang.String f344a = "http://rqd.uu.qq.com/rqd/sync";
    public static java.lang.String b = "http://android.bugly.qq.com/rqd/async";
    public static java.lang.String c = "http://android.bugly.qq.com/rqd/async";
    public static java.lang.String d;
    public long e;
    public long f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public long p;
    public long q;
    public java.lang.String r;
    public java.lang.String s;
    public java.lang.String t;
    public java.lang.String u;
    public java.util.Map v;
    public int w;
    public long x;
    public long y;

    public StrategyBean() {
        this.e = -1L;
        this.f = -1L;
        this.g = true;
        this.h = true;
        this.i = true;
        this.j = true;
        this.k = false;
        this.l = true;
        this.m = true;
        this.n = true;
        this.o = true;
        this.q = 30000L;
        this.r = b;
        this.s = c;
        this.t = f344a;
        this.w = 10;
        this.x = 300000L;
        this.y = -1L;
        this.f = java.lang.System.currentTimeMillis();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("S(@L@L");
        sb.append("@)");
        d = sb.toString();
        sb.setLength(0);
        sb.append("*^@K#K");
        sb.append("@!");
        this.u = sb.toString();
    }

    public StrategyBean(android.os.Parcel parcel) {
        this.e = -1L;
        this.f = -1L;
        boolean z = true;
        this.g = true;
        this.h = true;
        this.i = true;
        this.j = true;
        this.k = false;
        this.l = true;
        this.m = true;
        this.n = true;
        this.o = true;
        this.q = 30000L;
        this.r = b;
        this.s = c;
        this.t = f344a;
        this.w = 10;
        this.x = 300000L;
        this.y = -1L;
        try {
            d = "S(@L@L@)";
            this.f = parcel.readLong();
            this.g = parcel.readByte() == 1;
            this.h = parcel.readByte() == 1;
            this.i = parcel.readByte() == 1;
            this.r = parcel.readString();
            this.s = parcel.readString();
            this.u = parcel.readString();
            this.v = com.tencent.bugly.opengame.proguard.z.b(parcel);
            this.j = parcel.readByte() == 1;
            this.k = parcel.readByte() == 1;
            this.n = parcel.readByte() == 1;
            this.o = parcel.readByte() == 1;
            this.q = parcel.readLong();
            this.l = parcel.readByte() == 1;
            if (parcel.readByte() != 1) {
                z = false;
            }
            this.m = z;
            this.p = parcel.readLong();
            this.w = parcel.readInt();
            this.x = parcel.readLong();
            this.y = parcel.readLong();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeLong(this.f);
        parcel.writeByte(this.g ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.h ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.i ? (byte) 1 : (byte) 0);
        parcel.writeString(this.r);
        parcel.writeString(this.s);
        parcel.writeString(this.u);
        com.tencent.bugly.opengame.proguard.z.b(parcel, this.v);
        parcel.writeByte(this.j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.k ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.n ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.o ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.q);
        parcel.writeByte(this.l ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.m ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.p);
        parcel.writeInt(this.w);
        parcel.writeLong(this.x);
        parcel.writeLong(this.y);
    }
}
