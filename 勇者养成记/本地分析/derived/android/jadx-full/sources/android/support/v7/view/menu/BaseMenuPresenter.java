package android.support.v7.view.menu;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public abstract class BaseMenuPresenter implements android.support.v7.view.menu.MenuPresenter {
    private android.support.v7.view.menu.MenuPresenter.Callback mCallback;
    protected android.content.Context mContext;
    private int mId;
    protected android.view.LayoutInflater mInflater;
    private int mItemLayoutRes;
    protected android.support.v7.view.menu.MenuBuilder mMenu;
    private int mMenuLayoutRes;
    protected android.support.v7.view.menu.MenuView mMenuView;
    protected android.content.Context mSystemContext;
    protected android.view.LayoutInflater mSystemInflater;

    public BaseMenuPresenter(android.content.Context context, int i, int i2) {
        this.mSystemContext = context;
        this.mSystemInflater = android.view.LayoutInflater.from(context);
        this.mMenuLayoutRes = i;
        this.mItemLayoutRes = i2;
    }

    protected void addItemView(android.view.View view, int i) {
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((android.view.ViewGroup) this.mMenuView).addView(view, i);
    }

    public abstract void bindItemView(android.support.v7.view.menu.MenuItemImpl menuItemImpl, android.support.v7.view.menu.MenuView.ItemView itemView);

    @Override // android.support.v7.view.menu.MenuPresenter
    public boolean collapseItemActionView(android.support.v7.view.menu.MenuBuilder menuBuilder, android.support.v7.view.menu.MenuItemImpl menuItemImpl) {
        return false;
    }

    public android.support.v7.view.menu.MenuView.ItemView createItemView(android.view.ViewGroup viewGroup) {
        return (android.support.v7.view.menu.MenuView.ItemView) this.mSystemInflater.inflate(this.mItemLayoutRes, viewGroup, false);
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public boolean expandItemActionView(android.support.v7.view.menu.MenuBuilder menuBuilder, android.support.v7.view.menu.MenuItemImpl menuItemImpl) {
        return false;
    }

    protected boolean filterLeftoverView(android.view.ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    public android.support.v7.view.menu.MenuPresenter.Callback getCallback() {
        return this.mCallback;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public int getId() {
        return this.mId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public android.view.View getItemView(android.support.v7.view.menu.MenuItemImpl menuItemImpl, android.view.View view, android.view.ViewGroup viewGroup) {
        android.support.v7.view.menu.MenuView.ItemView itemViewCreateItemView = view instanceof android.support.v7.view.menu.MenuView.ItemView ? (android.support.v7.view.menu.MenuView.ItemView) view : createItemView(viewGroup);
        bindItemView(menuItemImpl, itemViewCreateItemView);
        return (android.view.View) itemViewCreateItemView;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public android.support.v7.view.menu.MenuView getMenuView(android.view.ViewGroup viewGroup) {
        if (this.mMenuView == null) {
            this.mMenuView = (android.support.v7.view.menu.MenuView) this.mSystemInflater.inflate(this.mMenuLayoutRes, viewGroup, false);
            this.mMenuView.initialize(this.mMenu);
            updateMenuView(true);
        }
        return this.mMenuView;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public void initForMenu(android.content.Context context, android.support.v7.view.menu.MenuBuilder menuBuilder) {
        this.mContext = context;
        this.mInflater = android.view.LayoutInflater.from(this.mContext);
        this.mMenu = menuBuilder;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public void onCloseMenu(android.support.v7.view.menu.MenuBuilder menuBuilder, boolean z) {
        android.support.v7.view.menu.MenuPresenter.Callback callback = this.mCallback;
        if (callback != null) {
            callback.onCloseMenu(menuBuilder, z);
        }
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public boolean onSubMenuSelected(android.support.v7.view.menu.SubMenuBuilder subMenuBuilder) {
        android.support.v7.view.menu.MenuPresenter.Callback callback = this.mCallback;
        if (callback != null) {
            return callback.onOpenSubMenu(subMenuBuilder);
        }
        return false;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public void setCallback(android.support.v7.view.menu.MenuPresenter.Callback callback) {
        this.mCallback = callback;
    }

    public void setId(int i) {
        this.mId = i;
    }

    public boolean shouldIncludeItem(int i, android.support.v7.view.menu.MenuItemImpl menuItemImpl) {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.support.v7.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) this.mMenuView;
        if (viewGroup == null) {
            return;
        }
        android.support.v7.view.menu.MenuBuilder menuBuilder = this.mMenu;
        int i = 0;
        if (menuBuilder != null) {
            menuBuilder.flagActionItems();
            java.util.ArrayList<android.support.v7.view.menu.MenuItemImpl> visibleItems = this.mMenu.getVisibleItems();
            int size = visibleItems.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                android.support.v7.view.menu.MenuItemImpl menuItemImpl = visibleItems.get(i3);
                if (shouldIncludeItem(i2, menuItemImpl)) {
                    android.view.View childAt = viewGroup.getChildAt(i2);
                    android.support.v7.view.menu.MenuItemImpl itemData = childAt instanceof android.support.v7.view.menu.MenuView.ItemView ? ((android.support.v7.view.menu.MenuView.ItemView) childAt).getItemData() : null;
                    android.view.View itemView = getItemView(menuItemImpl, childAt, viewGroup);
                    if (menuItemImpl != itemData) {
                        itemView.setPressed(false);
                        itemView.jumpDrawablesToCurrentState();
                    }
                    if (itemView != childAt) {
                        addItemView(itemView, i2);
                    }
                    i2++;
                }
            }
            i = i2;
        }
        while (i < viewGroup.getChildCount()) {
            if (!filterLeftoverView(viewGroup, i)) {
                i++;
            }
        }
    }
}
