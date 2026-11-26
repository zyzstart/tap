package android.support.v4.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class FragmentManagerNonConfig {
    private final java.util.List<android.support.v4.app.FragmentManagerNonConfig> mChildNonConfigs;
    private final java.util.List<android.support.v4.app.Fragment> mFragments;

    FragmentManagerNonConfig(java.util.List<android.support.v4.app.Fragment> list, java.util.List<android.support.v4.app.FragmentManagerNonConfig> list2) {
        this.mFragments = list;
        this.mChildNonConfigs = list2;
    }

    java.util.List<android.support.v4.app.FragmentManagerNonConfig> getChildNonConfigs() {
        return this.mChildNonConfigs;
    }

    java.util.List<android.support.v4.app.Fragment> getFragments() {
        return this.mFragments;
    }
}
