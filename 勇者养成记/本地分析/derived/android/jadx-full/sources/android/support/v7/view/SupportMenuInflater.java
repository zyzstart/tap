package android.support.v7.view;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class SupportMenuInflater extends android.view.MenuInflater {
    static final java.lang.String LOG_TAG = "SupportMenuInflater";
    static final int NO_ID = 0;
    private static final java.lang.String XML_GROUP = "group";
    private static final java.lang.String XML_ITEM = "item";
    private static final java.lang.String XML_MENU = "menu";
    final java.lang.Object[] mActionProviderConstructorArguments;
    final java.lang.Object[] mActionViewConstructorArguments;
    android.content.Context mContext;
    private java.lang.Object mRealOwner;
    static final java.lang.Class<?>[] ACTION_VIEW_CONSTRUCTOR_SIGNATURE = {android.content.Context.class};
    static final java.lang.Class<?>[] ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = ACTION_VIEW_CONSTRUCTOR_SIGNATURE;

    private static class InflatedOnMenuItemClickListener implements android.view.MenuItem.OnMenuItemClickListener {
        private static final java.lang.Class<?>[] PARAM_TYPES = {android.view.MenuItem.class};
        private java.lang.reflect.Method mMethod;
        private java.lang.Object mRealOwner;

        public InflatedOnMenuItemClickListener(java.lang.Object obj, java.lang.String str) {
            this.mRealOwner = obj;
            java.lang.Class<?> cls = obj.getClass();
            try {
                this.mMethod = cls.getMethod(str, PARAM_TYPES);
            } catch (java.lang.Exception e) {
                android.view.InflateException inflateException = new android.view.InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(android.view.MenuItem menuItem) {
            try {
                if (this.mMethod.getReturnType() == java.lang.Boolean.TYPE) {
                    return ((java.lang.Boolean) this.mMethod.invoke(this.mRealOwner, menuItem)).booleanValue();
                }
                this.mMethod.invoke(this.mRealOwner, menuItem);
                return true;
            } catch (java.lang.Exception e) {
                throw new java.lang.RuntimeException(e);
            }
        }
    }

    private class MenuState {
        private static final int defaultGroupId = 0;
        private static final int defaultItemCategory = 0;
        private static final int defaultItemCheckable = 0;
        private static final boolean defaultItemChecked = false;
        private static final boolean defaultItemEnabled = true;
        private static final int defaultItemId = 0;
        private static final int defaultItemOrder = 0;
        private static final boolean defaultItemVisible = true;
        private int groupCategory;
        private int groupCheckable;
        private boolean groupEnabled;
        private int groupId;
        private int groupOrder;
        private boolean groupVisible;
        android.support.v4.view.ActionProvider itemActionProvider;
        private java.lang.String itemActionProviderClassName;
        private java.lang.String itemActionViewClassName;
        private int itemActionViewLayout;
        private boolean itemAdded;
        private int itemAlphabeticModifiers;
        private char itemAlphabeticShortcut;
        private int itemCategoryOrder;
        private int itemCheckable;
        private boolean itemChecked;
        private java.lang.CharSequence itemContentDescription;
        private boolean itemEnabled;
        private int itemIconResId;
        private android.content.res.ColorStateList itemIconTintList = null;
        private android.graphics.PorterDuff.Mode itemIconTintMode = null;
        private int itemId;
        private java.lang.String itemListenerMethodName;
        private int itemNumericModifiers;
        private char itemNumericShortcut;
        private int itemShowAsAction;
        private java.lang.CharSequence itemTitle;
        private java.lang.CharSequence itemTitleCondensed;
        private java.lang.CharSequence itemTooltipText;
        private boolean itemVisible;
        private android.view.Menu menu;

        public MenuState(android.view.Menu menu) {
            this.menu = menu;
            resetGroup();
        }

        private char getShortcut(java.lang.String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        private <T> T newInstance(java.lang.String str, java.lang.Class<?>[] clsArr, java.lang.Object[] objArr) {
            try {
                java.lang.reflect.Constructor<?> constructor = android.support.v7.view.SupportMenuInflater.this.mContext.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (java.lang.Exception e) {
                android.util.Log.w(android.support.v7.view.SupportMenuInflater.LOG_TAG, "Cannot instantiate class: " + str, e);
                return null;
            }
        }

        private void setItem(android.view.MenuItem menuItem) {
            boolean z = false;
            menuItem.setChecked(this.itemChecked).setVisible(this.itemVisible).setEnabled(this.itemEnabled).setCheckable(this.itemCheckable >= 1).setTitleCondensed(this.itemTitleCondensed).setIcon(this.itemIconResId);
            int i = this.itemShowAsAction;
            if (i >= 0) {
                menuItem.setShowAsAction(i);
            }
            if (this.itemListenerMethodName != null) {
                if (android.support.v7.view.SupportMenuInflater.this.mContext.isRestricted()) {
                    throw new java.lang.IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new android.support.v7.view.SupportMenuInflater.InflatedOnMenuItemClickListener(android.support.v7.view.SupportMenuInflater.this.getRealOwner(), this.itemListenerMethodName));
            }
            boolean z2 = menuItem instanceof android.support.v7.view.menu.MenuItemImpl;
            if (z2) {
            }
            if (this.itemCheckable >= 2) {
                if (z2) {
                    ((android.support.v7.view.menu.MenuItemImpl) menuItem).setExclusiveCheckable(true);
                } else if (menuItem instanceof android.support.v7.view.menu.MenuItemWrapperICS) {
                    ((android.support.v7.view.menu.MenuItemWrapperICS) menuItem).setExclusiveCheckable(true);
                }
            }
            java.lang.String str = this.itemActionViewClassName;
            if (str != null) {
                menuItem.setActionView((android.view.View) newInstance(str, android.support.v7.view.SupportMenuInflater.ACTION_VIEW_CONSTRUCTOR_SIGNATURE, android.support.v7.view.SupportMenuInflater.this.mActionViewConstructorArguments));
                z = true;
            }
            int i2 = this.itemActionViewLayout;
            if (i2 > 0) {
                if (z) {
                    android.util.Log.w(android.support.v7.view.SupportMenuInflater.LOG_TAG, "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    menuItem.setActionView(i2);
                }
            }
            android.support.v4.view.ActionProvider actionProvider = this.itemActionProvider;
            if (actionProvider != null) {
                android.support.v4.view.MenuItemCompat.setActionProvider(menuItem, actionProvider);
            }
            android.support.v4.view.MenuItemCompat.setContentDescription(menuItem, this.itemContentDescription);
            android.support.v4.view.MenuItemCompat.setTooltipText(menuItem, this.itemTooltipText);
            android.support.v4.view.MenuItemCompat.setAlphabeticShortcut(menuItem, this.itemAlphabeticShortcut, this.itemAlphabeticModifiers);
            android.support.v4.view.MenuItemCompat.setNumericShortcut(menuItem, this.itemNumericShortcut, this.itemNumericModifiers);
            android.graphics.PorterDuff.Mode mode = this.itemIconTintMode;
            if (mode != null) {
                android.support.v4.view.MenuItemCompat.setIconTintMode(menuItem, mode);
            }
            android.content.res.ColorStateList colorStateList = this.itemIconTintList;
            if (colorStateList != null) {
                android.support.v4.view.MenuItemCompat.setIconTintList(menuItem, colorStateList);
            }
        }

        public void addItem() {
            this.itemAdded = true;
            setItem(this.menu.add(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle));
        }

        public android.view.SubMenu addSubMenuItem() {
            this.itemAdded = true;
            android.view.SubMenu subMenuAddSubMenu = this.menu.addSubMenu(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle);
            setItem(subMenuAddSubMenu.getItem());
            return subMenuAddSubMenu;
        }

        public boolean hasAddedItem() {
            return this.itemAdded;
        }

        public void readGroup(android.util.AttributeSet attributeSet) {
            android.content.res.TypedArray typedArrayObtainStyledAttributes = android.support.v7.view.SupportMenuInflater.this.mContext.obtainStyledAttributes(attributeSet, android.support.v7.appcompat.R.styleable.MenuGroup);
            this.groupId = typedArrayObtainStyledAttributes.getResourceId(android.support.v7.appcompat.R.styleable.MenuGroup_android_id, 0);
            this.groupCategory = typedArrayObtainStyledAttributes.getInt(android.support.v7.appcompat.R.styleable.MenuGroup_android_menuCategory, 0);
            this.groupOrder = typedArrayObtainStyledAttributes.getInt(android.support.v7.appcompat.R.styleable.MenuGroup_android_orderInCategory, 0);
            this.groupCheckable = typedArrayObtainStyledAttributes.getInt(android.support.v7.appcompat.R.styleable.MenuGroup_android_checkableBehavior, 0);
            this.groupVisible = typedArrayObtainStyledAttributes.getBoolean(android.support.v7.appcompat.R.styleable.MenuGroup_android_visible, true);
            this.groupEnabled = typedArrayObtainStyledAttributes.getBoolean(android.support.v7.appcompat.R.styleable.MenuGroup_android_enabled, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        public void readItem(android.util.AttributeSet attributeSet) {
            android.content.res.TypedArray typedArrayObtainStyledAttributes = android.support.v7.view.SupportMenuInflater.this.mContext.obtainStyledAttributes(attributeSet, android.support.v7.appcompat.R.styleable.MenuItem);
            this.itemId = typedArrayObtainStyledAttributes.getResourceId(android.support.v7.appcompat.R.styleable.MenuItem_android_id, 0);
            this.itemCategoryOrder = (typedArrayObtainStyledAttributes.getInt(android.support.v7.appcompat.R.styleable.MenuItem_android_menuCategory, this.groupCategory) & android.support.v4.internal.view.SupportMenu.CATEGORY_MASK) | (typedArrayObtainStyledAttributes.getInt(android.support.v7.appcompat.R.styleable.MenuItem_android_orderInCategory, this.groupOrder) & android.support.v4.internal.view.SupportMenu.USER_MASK);
            this.itemTitle = typedArrayObtainStyledAttributes.getText(android.support.v7.appcompat.R.styleable.MenuItem_android_title);
            this.itemTitleCondensed = typedArrayObtainStyledAttributes.getText(android.support.v7.appcompat.R.styleable.MenuItem_android_titleCondensed);
            this.itemIconResId = typedArrayObtainStyledAttributes.getResourceId(android.support.v7.appcompat.R.styleable.MenuItem_android_icon, 0);
            this.itemAlphabeticShortcut = getShortcut(typedArrayObtainStyledAttributes.getString(android.support.v7.appcompat.R.styleable.MenuItem_android_alphabeticShortcut));
            this.itemAlphabeticModifiers = typedArrayObtainStyledAttributes.getInt(android.support.v7.appcompat.R.styleable.MenuItem_alphabeticModifiers, 4096);
            this.itemNumericShortcut = getShortcut(typedArrayObtainStyledAttributes.getString(android.support.v7.appcompat.R.styleable.MenuItem_android_numericShortcut));
            this.itemNumericModifiers = typedArrayObtainStyledAttributes.getInt(android.support.v7.appcompat.R.styleable.MenuItem_numericModifiers, 4096);
            if (typedArrayObtainStyledAttributes.hasValue(android.support.v7.appcompat.R.styleable.MenuItem_android_checkable)) {
                this.itemCheckable = typedArrayObtainStyledAttributes.getBoolean(android.support.v7.appcompat.R.styleable.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.itemCheckable = this.groupCheckable;
            }
            this.itemChecked = typedArrayObtainStyledAttributes.getBoolean(android.support.v7.appcompat.R.styleable.MenuItem_android_checked, false);
            this.itemVisible = typedArrayObtainStyledAttributes.getBoolean(android.support.v7.appcompat.R.styleable.MenuItem_android_visible, this.groupVisible);
            this.itemEnabled = typedArrayObtainStyledAttributes.getBoolean(android.support.v7.appcompat.R.styleable.MenuItem_android_enabled, this.groupEnabled);
            this.itemShowAsAction = typedArrayObtainStyledAttributes.getInt(android.support.v7.appcompat.R.styleable.MenuItem_showAsAction, -1);
            this.itemListenerMethodName = typedArrayObtainStyledAttributes.getString(android.support.v7.appcompat.R.styleable.MenuItem_android_onClick);
            this.itemActionViewLayout = typedArrayObtainStyledAttributes.getResourceId(android.support.v7.appcompat.R.styleable.MenuItem_actionLayout, 0);
            this.itemActionViewClassName = typedArrayObtainStyledAttributes.getString(android.support.v7.appcompat.R.styleable.MenuItem_actionViewClass);
            this.itemActionProviderClassName = typedArrayObtainStyledAttributes.getString(android.support.v7.appcompat.R.styleable.MenuItem_actionProviderClass);
            boolean z = this.itemActionProviderClassName != null;
            if (z && this.itemActionViewLayout == 0 && this.itemActionViewClassName == null) {
                this.itemActionProvider = (android.support.v4.view.ActionProvider) newInstance(this.itemActionProviderClassName, android.support.v7.view.SupportMenuInflater.ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE, android.support.v7.view.SupportMenuInflater.this.mActionProviderConstructorArguments);
            } else {
                if (z) {
                    android.util.Log.w(android.support.v7.view.SupportMenuInflater.LOG_TAG, "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.itemActionProvider = null;
            }
            this.itemContentDescription = typedArrayObtainStyledAttributes.getText(android.support.v7.appcompat.R.styleable.MenuItem_contentDescription);
            this.itemTooltipText = typedArrayObtainStyledAttributes.getText(android.support.v7.appcompat.R.styleable.MenuItem_tooltipText);
            if (typedArrayObtainStyledAttributes.hasValue(android.support.v7.appcompat.R.styleable.MenuItem_iconTintMode)) {
                this.itemIconTintMode = android.support.v7.widget.DrawableUtils.parseTintMode(typedArrayObtainStyledAttributes.getInt(android.support.v7.appcompat.R.styleable.MenuItem_iconTintMode, -1), this.itemIconTintMode);
            } else {
                this.itemIconTintMode = null;
            }
            if (typedArrayObtainStyledAttributes.hasValue(android.support.v7.appcompat.R.styleable.MenuItem_iconTint)) {
                this.itemIconTintList = typedArrayObtainStyledAttributes.getColorStateList(android.support.v7.appcompat.R.styleable.MenuItem_iconTint);
            } else {
                this.itemIconTintList = null;
            }
            typedArrayObtainStyledAttributes.recycle();
            this.itemAdded = false;
        }

        public void resetGroup() {
            this.groupId = 0;
            this.groupCategory = 0;
            this.groupOrder = 0;
            this.groupCheckable = 0;
            this.groupVisible = true;
            this.groupEnabled = true;
        }
    }

    public SupportMenuInflater(android.content.Context context) {
        super(context);
        this.mContext = context;
        this.mActionViewConstructorArguments = new java.lang.Object[]{context};
        this.mActionProviderConstructorArguments = this.mActionViewConstructorArguments;
    }

    private java.lang.Object findRealOwner(java.lang.Object obj) {
        return (!(obj instanceof android.app.Activity) && (obj instanceof android.content.ContextWrapper)) ? findRealOwner(((android.content.ContextWrapper) obj).getBaseContext()) : obj;
    }

    private void parseMenu(org.xmlpull.v1.XmlPullParser xmlPullParser, android.util.AttributeSet attributeSet, android.view.Menu menu) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        android.support.v7.view.SupportMenuInflater.MenuState menuState = new android.support.v7.view.SupportMenuInflater.MenuState(menu);
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                java.lang.String name = xmlPullParser.getName();
                if (name.equals(XML_MENU)) {
                    eventType = xmlPullParser.next();
                    break;
                }
                throw new java.lang.RuntimeException("Expecting menu, got " + name);
            }
            eventType = xmlPullParser.next();
        } while (eventType != 1);
        int next = eventType;
        java.lang.String str = null;
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            switch (next) {
                case 1:
                    throw new java.lang.RuntimeException("Unexpected end of document");
                case 2:
                    if (!z2) {
                        java.lang.String name2 = xmlPullParser.getName();
                        if (name2.equals(XML_GROUP)) {
                            menuState.readGroup(attributeSet);
                        } else if (name2.equals(XML_ITEM)) {
                            menuState.readItem(attributeSet);
                        } else if (!name2.equals(XML_MENU)) {
                            str = name2;
                            z2 = true;
                        } else {
                            parseMenu(xmlPullParser, attributeSet, menuState.addSubMenuItem());
                        }
                    }
                    break;
                case 3:
                    java.lang.String name3 = xmlPullParser.getName();
                    if (z2 && name3.equals(str)) {
                        str = null;
                        z2 = false;
                    } else if (name3.equals(XML_GROUP)) {
                        menuState.resetGroup();
                    } else if (!name3.equals(XML_ITEM)) {
                        if (name3.equals(XML_MENU)) {
                            z = true;
                        }
                    } else if (!menuState.hasAddedItem()) {
                        if (menuState.itemActionProvider != null && menuState.itemActionProvider.hasSubMenu()) {
                            menuState.addSubMenuItem();
                        } else {
                            menuState.addItem();
                        }
                    }
                    break;
            }
            next = xmlPullParser.next();
        }
    }

    java.lang.Object getRealOwner() {
        if (this.mRealOwner == null) {
            this.mRealOwner = findRealOwner(this.mContext);
        }
        return this.mRealOwner;
    }

    @Override // android.view.MenuInflater
    public void inflate(int i, android.view.Menu menu) {
        if (!(menu instanceof android.support.v4.internal.view.SupportMenu)) {
            super.inflate(i, menu);
            return;
        }
        android.content.res.XmlResourceParser layout = null;
        try {
            try {
                try {
                    layout = this.mContext.getResources().getLayout(i);
                    parseMenu(layout, android.util.Xml.asAttributeSet(layout), menu);
                    if (layout != null) {
                        layout.close();
                    }
                } catch (org.xmlpull.v1.XmlPullParserException e) {
                    throw new android.view.InflateException("Error inflating menu XML", e);
                }
            } catch (java.io.IOException e2) {
                throw new android.view.InflateException("Error inflating menu XML", e2);
            }
        } catch (java.lang.Throwable th) {
            if (layout != null) {
                layout.close();
            }
            throw th;
        }
    }
}
