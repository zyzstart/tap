package android.support.v4.os;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class ConfigurationCompat {
    private ConfigurationCompat() {
    }

    public static android.support.v4.os.LocaleListCompat getLocales(android.content.res.Configuration configuration) {
        return android.os.Build.VERSION.SDK_INT >= 24 ? android.support.v4.os.LocaleListCompat.wrap(configuration.getLocales()) : android.support.v4.os.LocaleListCompat.create(configuration.locale);
    }
}
