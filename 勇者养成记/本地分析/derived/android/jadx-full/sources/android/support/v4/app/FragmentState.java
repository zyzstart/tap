package android.support.v4.app;

/* JADX INFO: compiled from: Fragment.java */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class FragmentState implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<android.support.v4.app.FragmentState> CREATOR = new android.os.Parcelable.Creator<android.support.v4.app.FragmentState>() { // from class: android.support.v4.app.FragmentState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public android.support.v4.app.FragmentState createFromParcel(android.os.Parcel parcel) {
            return new android.support.v4.app.FragmentState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public android.support.v4.app.FragmentState[] newArray(int i) {
            return new android.support.v4.app.FragmentState[i];
        }
    };
    final android.os.Bundle mArguments;
    final java.lang.String mClassName;
    final int mContainerId;
    final boolean mDetached;
    final int mFragmentId;
    final boolean mFromLayout;
    final boolean mHidden;
    final int mIndex;
    android.support.v4.app.Fragment mInstance;
    final boolean mRetainInstance;
    android.os.Bundle mSavedFragmentState;
    final java.lang.String mTag;

    public FragmentState(android.os.Parcel parcel) {
        this.mClassName = parcel.readString();
        this.mIndex = parcel.readInt();
        this.mFromLayout = parcel.readInt() != 0;
        this.mFragmentId = parcel.readInt();
        this.mContainerId = parcel.readInt();
        this.mTag = parcel.readString();
        this.mRetainInstance = parcel.readInt() != 0;
        this.mDetached = parcel.readInt() != 0;
        this.mArguments = parcel.readBundle();
        this.mHidden = parcel.readInt() != 0;
        this.mSavedFragmentState = parcel.readBundle();
    }

    public FragmentState(android.support.v4.app.Fragment fragment) {
        this.mClassName = fragment.getClass().getName();
        this.mIndex = fragment.mIndex;
        this.mFromLayout = fragment.mFromLayout;
        this.mFragmentId = fragment.mFragmentId;
        this.mContainerId = fragment.mContainerId;
        this.mTag = fragment.mTag;
        this.mRetainInstance = fragment.mRetainInstance;
        this.mDetached = fragment.mDetached;
        this.mArguments = fragment.mArguments;
        this.mHidden = fragment.mHidden;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public android.support.v4.app.Fragment instantiate(android.support.v4.app.FragmentHostCallback fragmentHostCallback, android.support.v4.app.FragmentContainer fragmentContainer, android.support.v4.app.Fragment fragment, android.support.v4.app.FragmentManagerNonConfig fragmentManagerNonConfig) {
        if (this.mInstance == null) {
            android.content.Context context = fragmentHostCallback.getContext();
            android.os.Bundle bundle = this.mArguments;
            if (bundle != null) {
                bundle.setClassLoader(context.getClassLoader());
            }
            if (fragmentContainer != null) {
                this.mInstance = fragmentContainer.instantiate(context, this.mClassName, this.mArguments);
            } else {
                this.mInstance = android.support.v4.app.Fragment.instantiate(context, this.mClassName, this.mArguments);
            }
            android.os.Bundle bundle2 = this.mSavedFragmentState;
            if (bundle2 != null) {
                bundle2.setClassLoader(context.getClassLoader());
                this.mInstance.mSavedFragmentState = this.mSavedFragmentState;
            }
            this.mInstance.setIndex(this.mIndex, fragment);
            android.support.v4.app.Fragment fragment2 = this.mInstance;
            fragment2.mFromLayout = this.mFromLayout;
            fragment2.mRestored = true;
            fragment2.mFragmentId = this.mFragmentId;
            fragment2.mContainerId = this.mContainerId;
            fragment2.mTag = this.mTag;
            fragment2.mRetainInstance = this.mRetainInstance;
            fragment2.mDetached = this.mDetached;
            fragment2.mHidden = this.mHidden;
            fragment2.mFragmentManager = fragmentHostCallback.mFragmentManager;
            if (android.support.v4.app.FragmentManagerImpl.DEBUG) {
                android.util.Log.v("FragmentManager", "Instantiated fragment " + this.mInstance);
            }
        }
        android.support.v4.app.Fragment fragment3 = this.mInstance;
        fragment3.mChildNonConfig = fragmentManagerNonConfig;
        return fragment3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.mClassName);
        parcel.writeInt(this.mIndex);
        parcel.writeInt(this.mFromLayout ? 1 : 0);
        parcel.writeInt(this.mFragmentId);
        parcel.writeInt(this.mContainerId);
        parcel.writeString(this.mTag);
        parcel.writeInt(this.mRetainInstance ? 1 : 0);
        parcel.writeInt(this.mDetached ? 1 : 0);
        parcel.writeBundle(this.mArguments);
        parcel.writeInt(this.mHidden ? 1 : 0);
        parcel.writeBundle(this.mSavedFragmentState);
    }
}
