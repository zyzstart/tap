package android.support.v4.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@java.lang.Deprecated
class RemoteInputCompatBase {

    public static abstract class RemoteInput {

        public interface Factory {
            android.support.v4.app.RemoteInputCompatBase.RemoteInput build(java.lang.String str, java.lang.CharSequence charSequence, java.lang.CharSequence[] charSequenceArr, boolean z, android.os.Bundle bundle, java.util.Set<java.lang.String> set);

            android.support.v4.app.RemoteInputCompatBase.RemoteInput[] newArray(int i);
        }

        protected abstract boolean getAllowFreeFormInput();

        protected abstract java.util.Set<java.lang.String> getAllowedDataTypes();

        protected abstract java.lang.CharSequence[] getChoices();

        protected abstract android.os.Bundle getExtras();

        protected abstract java.lang.CharSequence getLabel();

        protected abstract java.lang.String getResultKey();
    }

    RemoteInputCompatBase() {
    }
}
