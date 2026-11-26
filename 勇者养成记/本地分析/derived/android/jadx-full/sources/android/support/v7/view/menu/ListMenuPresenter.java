package android.support.v7.view.menu;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class ListMenuPresenter implements android.support.v7.view.menu.MenuPresenter, android.widget.AdapterView.OnItemClickListener {
    private static final java.lang.String TAG = "ListMenuPresenter";
    public static final java.lang.String VIEWS_TAG = "android:menu:list";
    android.support.v7.view.menu.ListMenuPresenter.MenuAdapter mAdapter;
    private android.support.v7.view.menu.MenuPresenter.Callback mCallback;
    android.content.Context mContext;
    private int mId;
    android.view.LayoutInflater mInflater;
    int mItemIndexOffset;
    int mItemLayoutRes;
    android.support.v7.view.menu.MenuBuilder mMenu;
    android.support.v7.view.menu.ExpandedMenuView mMenuView;
    int mThemeRes;

    private class MenuAdapter extends android.widget.BaseAdapter {
        private int mExpandedIndex = -1;

        public MenuAdapter() {
            findExpandedIndex();
        }

        void findExpandedIndex() {
            android.support.v7.view.menu.MenuItemImpl expandedItem = android.support.v7.view.menu.ListMenuPresenter.this.mMenu.getExpandedItem();
            if (expandedItem != null) {
                java.util.ArrayList<android.support.v7.view.menu.MenuItemImpl> nonActionItems = android.support.v7.view.menu.ListMenuPresenter.this.mMenu.getNonActionItems();
                int size = nonActionItems.size();
                for (int i = 0; i < size; i++) {
                    if (nonActionItems.get(i) == expandedItem) {
                        this.mExpandedIndex = i;
                        return;
                    }
                }
            }
            this.mExpandedIndex = -1;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = android.support.v7.view.menu.ListMenuPresenter.this.mMenu.getNonActionItems().size() - android.support.v7.view.menu.ListMenuPresenter.this.mItemIndexOffset;
            return this.mExpandedIndex < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        public android.support.v7.view.menu.MenuItemImpl getItem(int i) {
            java.util.ArrayList<android.support.v7.view.menu.MenuItemImpl> nonActionItems = android.support.v7.view.menu.ListMenuPresenter.this.mMenu.getNonActionItems();
            int i2 = i + android.support.v7.view.menu.ListMenuPresenter.this.mItemIndexOffset;
            int i3 = this.mExpandedIndex;
            if (i3 >= 0 && i2 >= i3) {
                i2++;
            }
            return nonActionItems.get(i2);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public android.view.View getView(int i, android.view.View view, android.view.ViewGroup viewGroup) {
            if (view == null) {
                view = android.support.v7.view.menu.ListMenuPresenter.this.mInflater.inflate(android.support.v7.view.menu.ListMenuPresenter.this.mItemLayoutRes, viewGroup, false);
            }
            ((android.support.v7.view.menu.MenuView.ItemView) view).initialize(getItem(i), 0);
            return view;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            findExpandedIndex();
            super.notifyDataSetChanged();
        }
    }

    public ListMenuPresenter(int i, int i2) {
        this.mItemLayoutRes = i;
        this.mThemeRes = i2;
    }

    public ListMenuPresenter(android.content.Context context, int i) {
        this(i, 0);
        this.mContext = context;
        this.mInflater = android.view.LayoutInflater.from(this.mContext);
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public boolean collapseItemActionView(android.support.v7.view.menu.MenuBuilder menuBuilder, android.support.v7.view.menu.MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public boolean expandItemActionView(android.support.v7.view.menu.MenuBuilder menuBuilder, android.support.v7.view.menu.MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    public android.widget.ListAdapter getAdapter() {
        if (this.mAdapter == null) {
            this.mAdapter = new android.support.v7.view.menu.ListMenuPresenter.MenuAdapter();
        }
        return this.mAdapter;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public int getId() {
        return this.mId;
    }

    int getItemIndexOffset() {
        return this.mItemIndexOffset;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public android.support.v7.view.menu.MenuView getMenuView(android.view.ViewGroup viewGroup) {
        if (this.mMenuView == null) {
            this.mMenuView = (android.support.v7.view.menu.ExpandedMenuView) this.mInflater.inflate(android.support.v7.appcompat.R.layout.abc_expanded_menu_layout, viewGroup, false);
            if (this.mAdapter == null) {
                this.mAdapter = new android.support.v7.view.menu.ListMenuPresenter.MenuAdapter();
            }
            this.mMenuView.setAdapter((android.widget.ListAdapter) this.mAdapter);
            this.mMenuView.setOnItemClickListener(this);
        }
        return this.mMenuView;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public void initForMenu(android.content.Context context, android.support.v7.view.menu.MenuBuilder menuBuilder) {
        int i = this.mThemeRes;
        if (i != 0) {
            this.mContext = new android.view.ContextThemeWrapper(context, i);
            this.mInflater = android.view.LayoutInflater.from(this.mContext);
        } else if (this.mContext != null) {
            this.mContext = context;
            if (this.mInflater == null) {
                this.mInflater = android.view.LayoutInflater.from(this.mContext);
            }
        }
        this.mMenu = menuBuilder;
        android.support.v7.view.menu.ListMenuPresenter.MenuAdapter menuAdapter = this.mAdapter;
        if (menuAdapter != null) {
            menuAdapter.notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public void onCloseMenu(android.support.v7.view.menu.MenuBuilder menuBuilder, boolean z) {
        android.support.v7.view.menu.MenuPresenter.Callback callback = this.mCallback;
        if (callback != null) {
            callback.onCloseMenu(menuBuilder, z);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(android.widget.AdapterView<?> adapterView, android.view.View view, int i, long j) {
        this.mMenu.performItemAction(this.mAdapter.getItem(i), this, 0);
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public void onRestoreInstanceState(android.os.Parcelable parcelable) {
        restoreHierarchyState((android.os.Bundle) parcelable);
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public android.os.Parcelable onSaveInstanceState() {
        if (this.mMenuView == null) {
            return null;
        }
        android.os.Bundle bundle = new android.os.Bundle();
        saveHierarchyState(bundle);
        return bundle;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public boolean onSubMenuSelected(android.support.v7.view.menu.SubMenuBuilder subMenuBuilder) {
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        new android.support.v7.view.menu.MenuDialogHelper(subMenuBuilder).show(null);
        android.support.v7.view.menu.MenuPresenter.Callback callback = this.mCallback;
        if (callback == null) {
            return true;
        }
        callback.onOpenSubMenu(subMenuBuilder);
        return true;
    }

    public void restoreHierarchyState(android.os.Bundle bundle) {
        android.util.SparseArray<android.os.Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(VIEWS_TAG);
        if (sparseParcelableArray != null) {
            this.mMenuView.restoreHierarchyState(sparseParcelableArray);
        }
    }

    public void saveHierarchyState(android.os.Bundle bundle) {
        android.util.SparseArray<android.os.Parcelable> sparseArray = new android.util.SparseArray<>();
        android.support.v7.view.menu.ExpandedMenuView expandedMenuView = this.mMenuView;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray(VIEWS_TAG, sparseArray);
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public void setCallback(android.support.v7.view.menu.MenuPresenter.Callback callback) {
        this.mCallback = callback;
    }

    public void setId(int i) {
        this.mId = i;
    }

    public void setItemIndexOffset(int i) {
        this.mItemIndexOffset = i;
        if (this.mMenuView != null) {
            updateMenuView(false);
        }
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        android.support.v7.view.menu.ListMenuPresenter.MenuAdapter menuAdapter = this.mAdapter;
        if (menuAdapter != null) {
            menuAdapter.notifyDataSetChanged();
        }
    }
}
