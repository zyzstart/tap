package android.support.v4.os;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
interface LocaleListInterface {
    boolean equals(java.lang.Object obj);

    java.util.Locale get(int i);

    @android.support.annotation.Nullable
    java.util.Locale getFirstMatch(java.lang.String[] strArr);

    java.lang.Object getLocaleList();

    int hashCode();

    @android.support.annotation.IntRange(from = android.support.v4.media.session.PlaybackStateCompat.PLAYBACK_POSITION_UNKNOWN)
    int indexOf(java.util.Locale locale);

    boolean isEmpty();

    void setLocaleList(@android.support.annotation.NonNull java.util.Locale... localeArr);

    @android.support.annotation.IntRange(from = android.support.v4.media.MediaDescriptionCompat.BT_FOLDER_TYPE_MIXED)
    int size();

    java.lang.String toLanguageTags();

    java.lang.String toString();
}
