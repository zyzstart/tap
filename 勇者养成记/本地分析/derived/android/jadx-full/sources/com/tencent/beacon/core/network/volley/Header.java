package com.tencent.beacon.core.network.volley;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class Header {
    private final java.lang.String mName;
    private final java.lang.String mValue;

    public Header(java.lang.String str, java.lang.String str2) {
        this.mName = str;
        this.mValue = str2;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || com.tencent.beacon.core.network.volley.Header.class != obj.getClass()) {
            return false;
        }
        com.tencent.beacon.core.network.volley.Header header = (com.tencent.beacon.core.network.volley.Header) obj;
        return android.text.TextUtils.equals(this.mName, header.mName) && android.text.TextUtils.equals(this.mValue, header.mValue);
    }

    public final java.lang.String getName() {
        return this.mName;
    }

    public final java.lang.String getValue() {
        return this.mValue;
    }

    public int hashCode() {
        return (this.mName.hashCode() * 31) + this.mValue.hashCode();
    }

    public java.lang.String toString() {
        return "Header[name=" + this.mName + ",value=" + this.mValue + "]";
    }
}
