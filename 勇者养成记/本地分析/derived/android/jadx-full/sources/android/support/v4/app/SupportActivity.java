package android.support.v4.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class SupportActivity extends android.app.Activity {
    private android.support.v4.util.SimpleArrayMap<java.lang.Class<? extends android.support.v4.app.SupportActivity.ExtraData>, android.support.v4.app.SupportActivity.ExtraData> mExtraDataMap = new android.support.v4.util.SimpleArrayMap<>();

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public static class ExtraData {
    }

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public <T extends android.support.v4.app.SupportActivity.ExtraData> T getExtraData(java.lang.Class<T> cls) {
        return (T) this.mExtraDataMap.get(cls);
    }

    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public void putExtraData(android.support.v4.app.SupportActivity.ExtraData extraData) {
        this.mExtraDataMap.put((java.lang.Class<? extends android.support.v4.app.SupportActivity.ExtraData>) extraData.getClass(), extraData);
    }
}
