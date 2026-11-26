package android.support.v4.app;

/* JADX INFO: compiled from: FragmentManager.java */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class FragmentManagerState implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<android.support.v4.app.FragmentManagerState> CREATOR = new android.os.Parcelable.Creator<android.support.v4.app.FragmentManagerState>() { // from class: android.support.v4.app.FragmentManagerState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public android.support.v4.app.FragmentManagerState createFromParcel(android.os.Parcel parcel) {
            return new android.support.v4.app.FragmentManagerState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public android.support.v4.app.FragmentManagerState[] newArray(int i) {
            return new android.support.v4.app.FragmentManagerState[i];
        }
    };
    android.support.v4.app.FragmentState[] mActive;
    int[] mAdded;
    android.support.v4.app.BackStackState[] mBackStack;
    int mNextFragmentIndex;
    int mPrimaryNavActiveIndex;

    public FragmentManagerState() {
        this.mPrimaryNavActiveIndex = -1;
    }

    public FragmentManagerState(android.os.Parcel parcel) {
        this.mPrimaryNavActiveIndex = -1;
        this.mActive = (android.support.v4.app.FragmentState[]) parcel.createTypedArray(android.support.v4.app.FragmentState.CREATOR);
        this.mAdded = parcel.createIntArray();
        this.mBackStack = (android.support.v4.app.BackStackState[]) parcel.createTypedArray(android.support.v4.app.BackStackState.CREATOR);
        this.mPrimaryNavActiveIndex = parcel.readInt();
        this.mNextFragmentIndex = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeTypedArray(this.mActive, i);
        parcel.writeIntArray(this.mAdded);
        parcel.writeTypedArray(this.mBackStack, i);
        parcel.writeInt(this.mPrimaryNavActiveIndex);
        parcel.writeInt(this.mNextFragmentIndex);
    }
}
