package android.support.v4.media;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RequiresApi(21)
class ParceledListSliceAdapterApi21 {
    private static java.lang.reflect.Constructor sConstructor;

    static {
        try {
            sConstructor = java.lang.Class.forName("android.content.pm.ParceledListSlice").getConstructor(java.util.List.class);
        } catch (java.lang.ClassNotFoundException | java.lang.NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    ParceledListSliceAdapterApi21() {
    }

    static java.lang.Object newInstance(java.util.List<android.media.browse.MediaBrowser.MediaItem> list) {
        try {
            return sConstructor.newInstance(list);
        } catch (java.lang.IllegalAccessException | java.lang.InstantiationException | java.lang.reflect.InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }
}
