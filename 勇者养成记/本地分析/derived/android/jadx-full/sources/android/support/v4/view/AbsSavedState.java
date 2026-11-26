package android.support.v4.view;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class AbsSavedState implements android.os.Parcelable {
    private final android.os.Parcelable mSuperState;
    public static final android.support.v4.view.AbsSavedState EMPTY_STATE = new android.support.v4.view.AbsSavedState() { // from class: android.support.v4.view.AbsSavedState.1
    };
    public static final android.os.Parcelable.Creator<android.support.v4.view.AbsSavedState> CREATOR = new android.os.Parcelable.ClassLoaderCreator<android.support.v4.view.AbsSavedState>() { // from class: android.support.v4.view.AbsSavedState.2
        @Override // android.os.Parcelable.Creator
        public android.support.v4.view.AbsSavedState createFromParcel(android.os.Parcel parcel) {
            return createFromParcel(parcel, (java.lang.ClassLoader) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.ClassLoaderCreator
        public android.support.v4.view.AbsSavedState createFromParcel(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return android.support.v4.view.AbsSavedState.EMPTY_STATE;
            }
            throw new java.lang.IllegalStateException("superState must be null");
        }

        @Override // android.os.Parcelable.Creator
        public android.support.v4.view.AbsSavedState[] newArray(int i) {
            return new android.support.v4.view.AbsSavedState[i];
        }
    };

    private AbsSavedState() {
        this.mSuperState = null;
    }

    protected AbsSavedState(android.os.Parcel parcel) {
        this(parcel, null);
    }

    protected AbsSavedState(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
        android.os.Parcelable parcelable = parcel.readParcelable(classLoader);
        this.mSuperState = parcelable == null ? EMPTY_STATE : parcelable;
    }

    protected AbsSavedState(android.os.Parcelable parcelable) {
        if (parcelable == null) {
            throw new java.lang.IllegalArgumentException("superState must not be null");
        }
        this.mSuperState = parcelable == EMPTY_STATE ? null : parcelable;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final android.os.Parcelable getSuperState() {
        return this.mSuperState;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeParcelable(this.mSuperState, i);
    }
}
