package android.support.v4.util;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ObjectsCompat {
    private static final android.support.v4.util.ObjectsCompat.ImplBase IMPL;

    @android.support.annotation.RequiresApi(19)
    private static class ImplApi19 extends android.support.v4.util.ObjectsCompat.ImplBase {
        private ImplApi19() {
            super();
        }

        @Override // android.support.v4.util.ObjectsCompat.ImplBase
        public boolean equals(java.lang.Object obj, java.lang.Object obj2) {
            return java.util.Objects.equals(obj, obj2);
        }
    }

    private static class ImplBase {
        private ImplBase() {
        }

        public boolean equals(java.lang.Object obj, java.lang.Object obj2) {
            return obj == obj2 || (obj != null && obj.equals(obj2));
        }
    }

    static {
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            IMPL = new android.support.v4.util.ObjectsCompat.ImplApi19();
        } else {
            IMPL = new android.support.v4.util.ObjectsCompat.ImplBase();
        }
    }

    private ObjectsCompat() {
    }

    public static boolean equals(java.lang.Object obj, java.lang.Object obj2) {
        return IMPL.equals(obj, obj2);
    }
}
