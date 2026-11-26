package android.support.v4.widget;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@java.lang.Deprecated
public final class SearchViewCompat {

    @java.lang.Deprecated
    public interface OnCloseListener {
        boolean onClose();
    }

    @java.lang.Deprecated
    public static abstract class OnCloseListenerCompat implements android.support.v4.widget.SearchViewCompat.OnCloseListener {
        @Override // android.support.v4.widget.SearchViewCompat.OnCloseListener
        public boolean onClose() {
            return false;
        }
    }

    @java.lang.Deprecated
    public interface OnQueryTextListener {
        boolean onQueryTextChange(java.lang.String str);

        boolean onQueryTextSubmit(java.lang.String str);
    }

    @java.lang.Deprecated
    public static abstract class OnQueryTextListenerCompat implements android.support.v4.widget.SearchViewCompat.OnQueryTextListener {
        @Override // android.support.v4.widget.SearchViewCompat.OnQueryTextListener
        public boolean onQueryTextChange(java.lang.String str) {
            return false;
        }

        @Override // android.support.v4.widget.SearchViewCompat.OnQueryTextListener
        public boolean onQueryTextSubmit(java.lang.String str) {
            return false;
        }
    }

    private SearchViewCompat(android.content.Context context) {
    }

    private static void checkIfLegalArg(android.view.View view) {
        if (view == null) {
            throw new java.lang.IllegalArgumentException("searchView must be non-null");
        }
        if (!(view instanceof android.widget.SearchView)) {
            throw new java.lang.IllegalArgumentException("searchView must be an instance of android.widget.SearchView");
        }
    }

    @java.lang.Deprecated
    public static java.lang.CharSequence getQuery(android.view.View view) {
        checkIfLegalArg(view);
        return ((android.widget.SearchView) view).getQuery();
    }

    @java.lang.Deprecated
    public static boolean isIconified(android.view.View view) {
        checkIfLegalArg(view);
        return ((android.widget.SearchView) view).isIconified();
    }

    @java.lang.Deprecated
    public static boolean isQueryRefinementEnabled(android.view.View view) {
        checkIfLegalArg(view);
        return ((android.widget.SearchView) view).isQueryRefinementEnabled();
    }

    @java.lang.Deprecated
    public static boolean isSubmitButtonEnabled(android.view.View view) {
        checkIfLegalArg(view);
        return ((android.widget.SearchView) view).isSubmitButtonEnabled();
    }

    private static android.widget.SearchView.OnCloseListener newOnCloseListener(final android.support.v4.widget.SearchViewCompat.OnCloseListener onCloseListener) {
        return new android.widget.SearchView.OnCloseListener() { // from class: android.support.v4.widget.SearchViewCompat.2
            @Override // android.widget.SearchView.OnCloseListener
            public boolean onClose() {
                return onCloseListener.onClose();
            }
        };
    }

    private static android.widget.SearchView.OnQueryTextListener newOnQueryTextListener(final android.support.v4.widget.SearchViewCompat.OnQueryTextListener onQueryTextListener) {
        return new android.widget.SearchView.OnQueryTextListener() { // from class: android.support.v4.widget.SearchViewCompat.1
            @Override // android.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextChange(java.lang.String str) {
                return onQueryTextListener.onQueryTextChange(str);
            }

            @Override // android.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextSubmit(java.lang.String str) {
                return onQueryTextListener.onQueryTextSubmit(str);
            }
        };
    }

    @java.lang.Deprecated
    public static android.view.View newSearchView(android.content.Context context) {
        return new android.widget.SearchView(context);
    }

    @java.lang.Deprecated
    public static void setIconified(android.view.View view, boolean z) {
        checkIfLegalArg(view);
        ((android.widget.SearchView) view).setIconified(z);
    }

    @java.lang.Deprecated
    public static void setImeOptions(android.view.View view, int i) {
        checkIfLegalArg(view);
        ((android.widget.SearchView) view).setImeOptions(i);
    }

    @java.lang.Deprecated
    public static void setInputType(android.view.View view, int i) {
        checkIfLegalArg(view);
        ((android.widget.SearchView) view).setInputType(i);
    }

    @java.lang.Deprecated
    public static void setMaxWidth(android.view.View view, int i) {
        checkIfLegalArg(view);
        ((android.widget.SearchView) view).setMaxWidth(i);
    }

    @java.lang.Deprecated
    public static void setOnCloseListener(android.view.View view, android.support.v4.widget.SearchViewCompat.OnCloseListener onCloseListener) {
        checkIfLegalArg(view);
        ((android.widget.SearchView) view).setOnCloseListener(newOnCloseListener(onCloseListener));
    }

    @java.lang.Deprecated
    public static void setOnQueryTextListener(android.view.View view, android.support.v4.widget.SearchViewCompat.OnQueryTextListener onQueryTextListener) {
        checkIfLegalArg(view);
        ((android.widget.SearchView) view).setOnQueryTextListener(newOnQueryTextListener(onQueryTextListener));
    }

    @java.lang.Deprecated
    public static void setQuery(android.view.View view, java.lang.CharSequence charSequence, boolean z) {
        checkIfLegalArg(view);
        ((android.widget.SearchView) view).setQuery(charSequence, z);
    }

    @java.lang.Deprecated
    public static void setQueryHint(android.view.View view, java.lang.CharSequence charSequence) {
        checkIfLegalArg(view);
        ((android.widget.SearchView) view).setQueryHint(charSequence);
    }

    @java.lang.Deprecated
    public static void setQueryRefinementEnabled(android.view.View view, boolean z) {
        checkIfLegalArg(view);
        ((android.widget.SearchView) view).setQueryRefinementEnabled(z);
    }

    @java.lang.Deprecated
    public static void setSearchableInfo(android.view.View view, android.content.ComponentName componentName) {
        checkIfLegalArg(view);
        ((android.widget.SearchView) view).setSearchableInfo(((android.app.SearchManager) view.getContext().getSystemService("search")).getSearchableInfo(componentName));
    }

    @java.lang.Deprecated
    public static void setSubmitButtonEnabled(android.view.View view, boolean z) {
        checkIfLegalArg(view);
        ((android.widget.SearchView) view).setSubmitButtonEnabled(z);
    }
}
