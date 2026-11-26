package android.support.v4.provider;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class FontRequest {
    private final java.util.List<java.util.List<byte[]>> mCertificates;
    private final int mCertificatesArray;
    private final java.lang.String mIdentifier;
    private final java.lang.String mProviderAuthority;
    private final java.lang.String mProviderPackage;
    private final java.lang.String mQuery;

    public FontRequest(@android.support.annotation.NonNull java.lang.String str, @android.support.annotation.NonNull java.lang.String str2, @android.support.annotation.NonNull java.lang.String str3, @android.support.annotation.ArrayRes int i) {
        this.mProviderAuthority = (java.lang.String) android.support.v4.util.Preconditions.checkNotNull(str);
        this.mProviderPackage = (java.lang.String) android.support.v4.util.Preconditions.checkNotNull(str2);
        this.mQuery = (java.lang.String) android.support.v4.util.Preconditions.checkNotNull(str3);
        this.mCertificates = null;
        android.support.v4.util.Preconditions.checkArgument(i != 0);
        this.mCertificatesArray = i;
        this.mIdentifier = this.mProviderAuthority + "-" + this.mProviderPackage + "-" + this.mQuery;
    }

    public FontRequest(@android.support.annotation.NonNull java.lang.String str, @android.support.annotation.NonNull java.lang.String str2, @android.support.annotation.NonNull java.lang.String str3, @android.support.annotation.NonNull java.util.List<java.util.List<byte[]>> list) {
        this.mProviderAuthority = (java.lang.String) android.support.v4.util.Preconditions.checkNotNull(str);
        this.mProviderPackage = (java.lang.String) android.support.v4.util.Preconditions.checkNotNull(str2);
        this.mQuery = (java.lang.String) android.support.v4.util.Preconditions.checkNotNull(str3);
        this.mCertificates = (java.util.List) android.support.v4.util.Preconditions.checkNotNull(list);
        this.mCertificatesArray = 0;
        this.mIdentifier = this.mProviderAuthority + "-" + this.mProviderPackage + "-" + this.mQuery;
    }

    @android.support.annotation.Nullable
    public java.util.List<java.util.List<byte[]>> getCertificates() {
        return this.mCertificates;
    }

    @android.support.annotation.ArrayRes
    public int getCertificatesArrayResId() {
        return this.mCertificatesArray;
    }

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public java.lang.String getIdentifier() {
        return this.mIdentifier;
    }

    public java.lang.String getProviderAuthority() {
        return this.mProviderAuthority;
    }

    public java.lang.String getProviderPackage() {
        return this.mProviderPackage;
    }

    public java.lang.String getQuery() {
        return this.mQuery;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.mProviderAuthority + ", mProviderPackage: " + this.mProviderPackage + ", mQuery: " + this.mQuery + ", mCertificates:");
        for (int i = 0; i < this.mCertificates.size(); i++) {
            sb.append(" [");
            java.util.List<byte[]> list = this.mCertificates.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(android.util.Base64.encodeToString(list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.mCertificatesArray);
        return sb.toString();
    }
}
