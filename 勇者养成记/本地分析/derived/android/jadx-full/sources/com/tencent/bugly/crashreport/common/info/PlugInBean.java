package com.tencent.bugly.crashreport.common.info;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class PlugInBean implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.tencent.bugly.crashreport.common.info.PlugInBean> CREATOR = new android.os.Parcelable.Creator<com.tencent.bugly.crashreport.common.info.PlugInBean>() { // from class: com.tencent.bugly.crashreport.common.info.PlugInBean.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.tencent.bugly.crashreport.common.info.PlugInBean createFromParcel(android.os.Parcel parcel) {
            return new com.tencent.bugly.crashreport.common.info.PlugInBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.tencent.bugly.crashreport.common.info.PlugInBean[] newArray(int i) {
            return new com.tencent.bugly.crashreport.common.info.PlugInBean[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final java.lang.String f291a;
    public final java.lang.String b;
    public final java.lang.String c;

    public PlugInBean(android.os.Parcel parcel) {
        this.f291a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
    }

    public PlugInBean(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.f291a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.lang.String toString() {
        return "plid:" + this.f291a + " plV:" + this.b + " plUUID:" + this.c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.f291a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }
}
