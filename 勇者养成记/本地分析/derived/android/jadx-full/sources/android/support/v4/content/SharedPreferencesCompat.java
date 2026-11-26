package android.support.v4.content;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class SharedPreferencesCompat {

    public static final class EditorCompat {
        private static android.support.v4.content.SharedPreferencesCompat.EditorCompat sInstance;
        private final android.support.v4.content.SharedPreferencesCompat.EditorCompat.Helper mHelper = new android.support.v4.content.SharedPreferencesCompat.EditorCompat.Helper();

        private static class Helper {
            Helper() {
            }

            public void apply(@android.support.annotation.NonNull android.content.SharedPreferences.Editor editor) {
                try {
                    editor.apply();
                } catch (java.lang.AbstractMethodError unused) {
                    editor.commit();
                }
            }
        }

        private EditorCompat() {
        }

        public static android.support.v4.content.SharedPreferencesCompat.EditorCompat getInstance() {
            if (sInstance == null) {
                sInstance = new android.support.v4.content.SharedPreferencesCompat.EditorCompat();
            }
            return sInstance;
        }

        public void apply(@android.support.annotation.NonNull android.content.SharedPreferences.Editor editor) {
            this.mHelper.apply(editor);
        }
    }

    private SharedPreferencesCompat() {
    }
}
