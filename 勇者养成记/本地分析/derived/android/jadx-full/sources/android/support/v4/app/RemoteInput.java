package android.support.v4.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class RemoteInput extends android.support.v4.app.RemoteInputCompatBase.RemoteInput {
    private static final java.lang.String EXTRA_DATA_TYPE_RESULTS_DATA = "android.remoteinput.dataTypeResultsData";
    public static final java.lang.String EXTRA_RESULTS_DATA = "android.remoteinput.resultsData";

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public static final android.support.v4.app.RemoteInputCompatBase.RemoteInput.Factory FACTORY;
    private static final android.support.v4.app.RemoteInput.Impl IMPL;
    public static final java.lang.String RESULTS_CLIP_LABEL = "android.remoteinput.results";
    private static final java.lang.String TAG = "RemoteInput";
    private final boolean mAllowFreeFormTextInput;
    private final java.util.Set<java.lang.String> mAllowedDataTypes;
    private final java.lang.CharSequence[] mChoices;
    private final android.os.Bundle mExtras;
    private final java.lang.CharSequence mLabel;
    private final java.lang.String mResultKey;

    public static final class Builder {
        private java.lang.CharSequence[] mChoices;
        private java.lang.CharSequence mLabel;
        private final java.lang.String mResultKey;
        private boolean mAllowFreeFormTextInput = true;
        private android.os.Bundle mExtras = new android.os.Bundle();
        private final java.util.Set<java.lang.String> mAllowedDataTypes = new java.util.HashSet();

        public Builder(java.lang.String str) {
            if (str == null) {
                throw new java.lang.IllegalArgumentException("Result key can't be null");
            }
            this.mResultKey = str;
        }

        public android.support.v4.app.RemoteInput.Builder addExtras(android.os.Bundle bundle) {
            if (bundle != null) {
                this.mExtras.putAll(bundle);
            }
            return this;
        }

        public android.support.v4.app.RemoteInput build() {
            return new android.support.v4.app.RemoteInput(this.mResultKey, this.mLabel, this.mChoices, this.mAllowFreeFormTextInput, this.mExtras, this.mAllowedDataTypes);
        }

        public android.os.Bundle getExtras() {
            return this.mExtras;
        }

        public android.support.v4.app.RemoteInput.Builder setAllowDataType(java.lang.String str, boolean z) {
            if (z) {
                this.mAllowedDataTypes.add(str);
            } else {
                this.mAllowedDataTypes.remove(str);
            }
            return this;
        }

        public android.support.v4.app.RemoteInput.Builder setAllowFreeFormInput(boolean z) {
            this.mAllowFreeFormTextInput = z;
            return this;
        }

        public android.support.v4.app.RemoteInput.Builder setChoices(java.lang.CharSequence[] charSequenceArr) {
            this.mChoices = charSequenceArr;
            return this;
        }

        public android.support.v4.app.RemoteInput.Builder setLabel(java.lang.CharSequence charSequence) {
            this.mLabel = charSequence;
            return this;
        }
    }

    interface Impl {
        void addDataResultToIntent(android.support.v4.app.RemoteInput remoteInput, android.content.Intent intent, java.util.Map<java.lang.String, android.net.Uri> map);

        void addResultsToIntent(android.support.v4.app.RemoteInput[] remoteInputArr, android.content.Intent intent, android.os.Bundle bundle);

        java.util.Map<java.lang.String, android.net.Uri> getDataResultsFromIntent(android.content.Intent intent, java.lang.String str);

        android.os.Bundle getResultsFromIntent(android.content.Intent intent);
    }

    @android.support.annotation.RequiresApi(20)
    static class ImplApi20 implements android.support.v4.app.RemoteInput.Impl {
        ImplApi20() {
        }

        @Override // android.support.v4.app.RemoteInput.Impl
        public void addDataResultToIntent(android.support.v4.app.RemoteInput remoteInput, android.content.Intent intent, java.util.Map<java.lang.String, android.net.Uri> map) {
            android.support.v4.app.RemoteInputCompatApi20.addDataResultToIntent(remoteInput, intent, map);
        }

        @Override // android.support.v4.app.RemoteInput.Impl
        public void addResultsToIntent(android.support.v4.app.RemoteInput[] remoteInputArr, android.content.Intent intent, android.os.Bundle bundle) {
            android.support.v4.app.RemoteInputCompatApi20.addResultsToIntent(remoteInputArr, intent, bundle);
        }

        @Override // android.support.v4.app.RemoteInput.Impl
        public java.util.Map<java.lang.String, android.net.Uri> getDataResultsFromIntent(android.content.Intent intent, java.lang.String str) {
            return android.support.v4.app.RemoteInputCompatApi20.getDataResultsFromIntent(intent, str);
        }

        @Override // android.support.v4.app.RemoteInput.Impl
        public android.os.Bundle getResultsFromIntent(android.content.Intent intent) {
            return android.support.v4.app.RemoteInputCompatApi20.getResultsFromIntent(intent);
        }
    }

    static class ImplBase implements android.support.v4.app.RemoteInput.Impl {
        ImplBase() {
        }

        @Override // android.support.v4.app.RemoteInput.Impl
        public void addDataResultToIntent(android.support.v4.app.RemoteInput remoteInput, android.content.Intent intent, java.util.Map<java.lang.String, android.net.Uri> map) {
            android.util.Log.w(android.support.v4.app.RemoteInput.TAG, "RemoteInput is only supported from API Level 16");
        }

        @Override // android.support.v4.app.RemoteInput.Impl
        public void addResultsToIntent(android.support.v4.app.RemoteInput[] remoteInputArr, android.content.Intent intent, android.os.Bundle bundle) {
            android.util.Log.w(android.support.v4.app.RemoteInput.TAG, "RemoteInput is only supported from API Level 16");
        }

        @Override // android.support.v4.app.RemoteInput.Impl
        public java.util.Map<java.lang.String, android.net.Uri> getDataResultsFromIntent(android.content.Intent intent, java.lang.String str) {
            android.util.Log.w(android.support.v4.app.RemoteInput.TAG, "RemoteInput is only supported from API Level 16");
            return null;
        }

        @Override // android.support.v4.app.RemoteInput.Impl
        public android.os.Bundle getResultsFromIntent(android.content.Intent intent) {
            android.util.Log.w(android.support.v4.app.RemoteInput.TAG, "RemoteInput is only supported from API Level 16");
            return null;
        }
    }

    @android.support.annotation.RequiresApi(16)
    static class ImplJellybean implements android.support.v4.app.RemoteInput.Impl {
        ImplJellybean() {
        }

        @Override // android.support.v4.app.RemoteInput.Impl
        public void addDataResultToIntent(android.support.v4.app.RemoteInput remoteInput, android.content.Intent intent, java.util.Map<java.lang.String, android.net.Uri> map) {
            android.support.v4.app.RemoteInputCompatJellybean.addDataResultToIntent(remoteInput, intent, map);
        }

        @Override // android.support.v4.app.RemoteInput.Impl
        public void addResultsToIntent(android.support.v4.app.RemoteInput[] remoteInputArr, android.content.Intent intent, android.os.Bundle bundle) {
            android.support.v4.app.RemoteInputCompatJellybean.addResultsToIntent(remoteInputArr, intent, bundle);
        }

        @Override // android.support.v4.app.RemoteInput.Impl
        public java.util.Map<java.lang.String, android.net.Uri> getDataResultsFromIntent(android.content.Intent intent, java.lang.String str) {
            return android.support.v4.app.RemoteInputCompatJellybean.getDataResultsFromIntent(intent, str);
        }

        @Override // android.support.v4.app.RemoteInput.Impl
        public android.os.Bundle getResultsFromIntent(android.content.Intent intent) {
            return android.support.v4.app.RemoteInputCompatJellybean.getResultsFromIntent(intent);
        }
    }

    static {
        if (android.os.Build.VERSION.SDK_INT >= 20) {
            IMPL = new android.support.v4.app.RemoteInput.ImplApi20();
        } else if (android.os.Build.VERSION.SDK_INT >= 16) {
            IMPL = new android.support.v4.app.RemoteInput.ImplJellybean();
        } else {
            IMPL = new android.support.v4.app.RemoteInput.ImplBase();
        }
        FACTORY = new android.support.v4.app.RemoteInputCompatBase.RemoteInput.Factory() { // from class: android.support.v4.app.RemoteInput.1
            @Override // android.support.v4.app.RemoteInputCompatBase.RemoteInput.Factory
            public android.support.v4.app.RemoteInput build(java.lang.String str, java.lang.CharSequence charSequence, java.lang.CharSequence[] charSequenceArr, boolean z, android.os.Bundle bundle, java.util.Set<java.lang.String> set) {
                return new android.support.v4.app.RemoteInput(str, charSequence, charSequenceArr, z, bundle, set);
            }

            @Override // android.support.v4.app.RemoteInputCompatBase.RemoteInput.Factory
            public /* bridge */ /* synthetic */ android.support.v4.app.RemoteInputCompatBase.RemoteInput build(java.lang.String str, java.lang.CharSequence charSequence, java.lang.CharSequence[] charSequenceArr, boolean z, android.os.Bundle bundle, java.util.Set set) {
                return build(str, charSequence, charSequenceArr, z, bundle, (java.util.Set<java.lang.String>) set);
            }

            @Override // android.support.v4.app.RemoteInputCompatBase.RemoteInput.Factory
            public android.support.v4.app.RemoteInput[] newArray(int i) {
                return new android.support.v4.app.RemoteInput[i];
            }
        };
    }

    RemoteInput(java.lang.String str, java.lang.CharSequence charSequence, java.lang.CharSequence[] charSequenceArr, boolean z, android.os.Bundle bundle, java.util.Set<java.lang.String> set) {
        this.mResultKey = str;
        this.mLabel = charSequence;
        this.mChoices = charSequenceArr;
        this.mAllowFreeFormTextInput = z;
        this.mExtras = bundle;
        this.mAllowedDataTypes = set;
    }

    public static void addDataResultToIntent(android.support.v4.app.RemoteInput remoteInput, android.content.Intent intent, java.util.Map<java.lang.String, android.net.Uri> map) {
        IMPL.addDataResultToIntent(remoteInput, intent, map);
    }

    public static void addResultsToIntent(android.support.v4.app.RemoteInput[] remoteInputArr, android.content.Intent intent, android.os.Bundle bundle) {
        IMPL.addResultsToIntent(remoteInputArr, intent, bundle);
    }

    public static java.util.Map<java.lang.String, android.net.Uri> getDataResultsFromIntent(android.content.Intent intent, java.lang.String str) {
        return IMPL.getDataResultsFromIntent(intent, str);
    }

    public static android.os.Bundle getResultsFromIntent(android.content.Intent intent) {
        return IMPL.getResultsFromIntent(intent);
    }

    @Override // android.support.v4.app.RemoteInputCompatBase.RemoteInput
    public boolean getAllowFreeFormInput() {
        return this.mAllowFreeFormTextInput;
    }

    @Override // android.support.v4.app.RemoteInputCompatBase.RemoteInput
    public java.util.Set<java.lang.String> getAllowedDataTypes() {
        return this.mAllowedDataTypes;
    }

    @Override // android.support.v4.app.RemoteInputCompatBase.RemoteInput
    public java.lang.CharSequence[] getChoices() {
        return this.mChoices;
    }

    @Override // android.support.v4.app.RemoteInputCompatBase.RemoteInput
    public android.os.Bundle getExtras() {
        return this.mExtras;
    }

    @Override // android.support.v4.app.RemoteInputCompatBase.RemoteInput
    public java.lang.CharSequence getLabel() {
        return this.mLabel;
    }

    @Override // android.support.v4.app.RemoteInputCompatBase.RemoteInput
    public java.lang.String getResultKey() {
        return this.mResultKey;
    }

    public boolean isDataOnly() {
        return (getAllowFreeFormInput() || (getChoices() != null && getChoices().length != 0) || getAllowedDataTypes() == null || getAllowedDataTypes().isEmpty()) ? false : true;
    }
}
