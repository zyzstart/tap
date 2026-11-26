package com.tencent.bugly.opengame.crashreport.common.info;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class PlugInBean implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() { // from class: com.tencent.bugly.opengame.crashreport.common.info.PlugInBean.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel parcel) {
            return new com.tencent.bugly.opengame.crashreport.common.info.PlugInBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ java.lang.Object[] newArray(int i) {
            return new com.tencent.bugly.opengame.crashreport.common.info.PlugInBean[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final java.lang.String f341a;
    public final java.lang.String b;
    public final java.lang.String c;

    public PlugInBean(android.os.Parcel parcel) {
        this.f341a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
    }

    public PlugInBean(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.f341a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.lang.String toString() {
        return "plid:" + this.f341a + " plV:" + this.b + " plUUID:" + this.c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.f341a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }
}
