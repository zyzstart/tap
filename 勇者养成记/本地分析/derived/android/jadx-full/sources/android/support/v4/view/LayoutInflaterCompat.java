package android.support.v4.view;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class LayoutInflaterCompat {
    static final android.support.v4.view.LayoutInflaterCompat.LayoutInflaterCompatBaseImpl IMPL;
    private static final java.lang.String TAG = "LayoutInflaterCompatHC";
    private static boolean sCheckedField;
    private static java.lang.reflect.Field sLayoutInflaterFactory2Field;

    static class Factory2Wrapper implements android.view.LayoutInflater.Factory2 {
        final android.support.v4.view.LayoutInflaterFactory mDelegateFactory;

        Factory2Wrapper(android.support.v4.view.LayoutInflaterFactory layoutInflaterFactory) {
            this.mDelegateFactory = layoutInflaterFactory;
        }

        @Override // android.view.LayoutInflater.Factory2
        public android.view.View onCreateView(android.view.View view, java.lang.String str, android.content.Context context, android.util.AttributeSet attributeSet) {
            return this.mDelegateFactory.onCreateView(view, str, context, attributeSet);
        }

        @Override // android.view.LayoutInflater.Factory
        public android.view.View onCreateView(java.lang.String str, android.content.Context context, android.util.AttributeSet attributeSet) {
            return this.mDelegateFactory.onCreateView(null, str, context, attributeSet);
        }

        public java.lang.String toString() {
            return getClass().getName() + "{" + this.mDelegateFactory + "}";
        }
    }

    @android.support.annotation.RequiresApi(21)
    static class LayoutInflaterCompatApi21Impl extends android.support.v4.view.LayoutInflaterCompat.LayoutInflaterCompatBaseImpl {
        LayoutInflaterCompatApi21Impl() {
        }

        @Override // android.support.v4.view.LayoutInflaterCompat.LayoutInflaterCompatBaseImpl
        public void setFactory(android.view.LayoutInflater layoutInflater, android.support.v4.view.LayoutInflaterFactory layoutInflaterFactory) {
            layoutInflater.setFactory2(layoutInflaterFactory != null ? new android.support.v4.view.LayoutInflaterCompat.Factory2Wrapper(layoutInflaterFactory) : null);
        }

        @Override // android.support.v4.view.LayoutInflaterCompat.LayoutInflaterCompatBaseImpl
        public void setFactory2(android.view.LayoutInflater layoutInflater, android.view.LayoutInflater.Factory2 factory2) {
            layoutInflater.setFactory2(factory2);
        }
    }

    static class LayoutInflaterCompatBaseImpl {
        LayoutInflaterCompatBaseImpl() {
        }

        public android.support.v4.view.LayoutInflaterFactory getFactory(android.view.LayoutInflater layoutInflater) {
            android.view.LayoutInflater.Factory factory = layoutInflater.getFactory();
            if (factory instanceof android.support.v4.view.LayoutInflaterCompat.Factory2Wrapper) {
                return ((android.support.v4.view.LayoutInflaterCompat.Factory2Wrapper) factory).mDelegateFactory;
            }
            return null;
        }

        public void setFactory(android.view.LayoutInflater layoutInflater, android.support.v4.view.LayoutInflaterFactory layoutInflaterFactory) {
            setFactory2(layoutInflater, layoutInflaterFactory != null ? new android.support.v4.view.LayoutInflaterCompat.Factory2Wrapper(layoutInflaterFactory) : null);
        }

        public void setFactory2(android.view.LayoutInflater layoutInflater, android.view.LayoutInflater.Factory2 factory2) {
            layoutInflater.setFactory2(factory2);
            android.view.LayoutInflater.Factory factory = layoutInflater.getFactory();
            if (factory instanceof android.view.LayoutInflater.Factory2) {
                android.support.v4.view.LayoutInflaterCompat.forceSetFactory2(layoutInflater, (android.view.LayoutInflater.Factory2) factory);
            } else {
                android.support.v4.view.LayoutInflaterCompat.forceSetFactory2(layoutInflater, factory2);
            }
        }
    }

    static {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            IMPL = new android.support.v4.view.LayoutInflaterCompat.LayoutInflaterCompatApi21Impl();
        } else {
            IMPL = new android.support.v4.view.LayoutInflaterCompat.LayoutInflaterCompatBaseImpl();
        }
    }

    private LayoutInflaterCompat() {
    }

    static void forceSetFactory2(android.view.LayoutInflater layoutInflater, android.view.LayoutInflater.Factory2 factory2) {
        if (!sCheckedField) {
            try {
                sLayoutInflaterFactory2Field = android.view.LayoutInflater.class.getDeclaredField("mFactory2");
                sLayoutInflaterFactory2Field.setAccessible(true);
            } catch (java.lang.NoSuchFieldException e) {
                android.util.Log.e(TAG, "forceSetFactory2 Could not find field 'mFactory2' on class " + android.view.LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
            }
            sCheckedField = true;
        }
        java.lang.reflect.Field field = sLayoutInflaterFactory2Field;
        if (field != null) {
            try {
                field.set(layoutInflater, factory2);
            } catch (java.lang.IllegalAccessException e2) {
                android.util.Log.e(TAG, "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e2);
            }
        }
    }

    @java.lang.Deprecated
    public static android.support.v4.view.LayoutInflaterFactory getFactory(android.view.LayoutInflater layoutInflater) {
        return IMPL.getFactory(layoutInflater);
    }

    @java.lang.Deprecated
    public static void setFactory(@android.support.annotation.NonNull android.view.LayoutInflater layoutInflater, @android.support.annotation.NonNull android.support.v4.view.LayoutInflaterFactory layoutInflaterFactory) {
        IMPL.setFactory(layoutInflater, layoutInflaterFactory);
    }

    public static void setFactory2(@android.support.annotation.NonNull android.view.LayoutInflater layoutInflater, @android.support.annotation.NonNull android.view.LayoutInflater.Factory2 factory2) {
        IMPL.setFactory2(layoutInflater, factory2);
    }
}
