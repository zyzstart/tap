package android.support.v7.widget;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public final class AppCompatDrawableManager {
    private static final boolean DEBUG = false;
    private static android.support.v7.widget.AppCompatDrawableManager INSTANCE = null;
    private static final java.lang.String PLATFORM_VD_CLAZZ = "android.graphics.drawable.VectorDrawable";
    private static final java.lang.String SKIP_DRAWABLE_TAG = "appcompat_skip_skip";
    private static final java.lang.String TAG = "AppCompatDrawableManager";
    private android.support.v4.util.ArrayMap<java.lang.String, android.support.v7.widget.AppCompatDrawableManager.InflateDelegate> mDelegates;
    private final java.lang.Object mDrawableCacheLock = new java.lang.Object();
    private final java.util.WeakHashMap<android.content.Context, android.support.v4.util.LongSparseArray<java.lang.ref.WeakReference<android.graphics.drawable.Drawable.ConstantState>>> mDrawableCaches = new java.util.WeakHashMap<>(0);
    private boolean mHasCheckedVectorDrawableSetup;
    private android.support.v4.util.SparseArrayCompat<java.lang.String> mKnownDrawableIdTags;
    private java.util.WeakHashMap<android.content.Context, android.support.v4.util.SparseArrayCompat<android.content.res.ColorStateList>> mTintLists;
    private android.util.TypedValue mTypedValue;
    private static final android.graphics.PorterDuff.Mode DEFAULT_MODE = android.graphics.PorterDuff.Mode.SRC_IN;
    private static final android.support.v7.widget.AppCompatDrawableManager.ColorFilterLruCache COLOR_FILTER_CACHE = new android.support.v7.widget.AppCompatDrawableManager.ColorFilterLruCache(6);
    private static final int[] COLORFILTER_TINT_COLOR_CONTROL_NORMAL = {android.support.v7.appcompat.R.drawable.abc_textfield_search_default_mtrl_alpha, android.support.v7.appcompat.R.drawable.abc_textfield_default_mtrl_alpha, android.support.v7.appcompat.R.drawable.abc_ab_share_pack_mtrl_alpha};
    private static final int[] TINT_COLOR_CONTROL_NORMAL = {android.support.v7.appcompat.R.drawable.abc_ic_commit_search_api_mtrl_alpha, android.support.v7.appcompat.R.drawable.abc_seekbar_tick_mark_material, android.support.v7.appcompat.R.drawable.abc_ic_menu_share_mtrl_alpha, android.support.v7.appcompat.R.drawable.abc_ic_menu_copy_mtrl_am_alpha, android.support.v7.appcompat.R.drawable.abc_ic_menu_cut_mtrl_alpha, android.support.v7.appcompat.R.drawable.abc_ic_menu_selectall_mtrl_alpha, android.support.v7.appcompat.R.drawable.abc_ic_menu_paste_mtrl_am_alpha};
    private static final int[] COLORFILTER_COLOR_CONTROL_ACTIVATED = {android.support.v7.appcompat.R.drawable.abc_textfield_activated_mtrl_alpha, android.support.v7.appcompat.R.drawable.abc_textfield_search_activated_mtrl_alpha, android.support.v7.appcompat.R.drawable.abc_cab_background_top_mtrl_alpha, android.support.v7.appcompat.R.drawable.abc_text_cursor_material, android.support.v7.appcompat.R.drawable.abc_text_select_handle_left_mtrl_dark, android.support.v7.appcompat.R.drawable.abc_text_select_handle_middle_mtrl_dark, android.support.v7.appcompat.R.drawable.abc_text_select_handle_right_mtrl_dark, android.support.v7.appcompat.R.drawable.abc_text_select_handle_left_mtrl_light, android.support.v7.appcompat.R.drawable.abc_text_select_handle_middle_mtrl_light, android.support.v7.appcompat.R.drawable.abc_text_select_handle_right_mtrl_light};
    private static final int[] COLORFILTER_COLOR_BACKGROUND_MULTIPLY = {android.support.v7.appcompat.R.drawable.abc_popup_background_mtrl_mult, android.support.v7.appcompat.R.drawable.abc_cab_background_internal_bg, android.support.v7.appcompat.R.drawable.abc_menu_hardkey_panel_mtrl_mult};
    private static final int[] TINT_COLOR_CONTROL_STATE_LIST = {android.support.v7.appcompat.R.drawable.abc_tab_indicator_material, android.support.v7.appcompat.R.drawable.abc_textfield_search_material};
    private static final int[] TINT_CHECKABLE_BUTTON_LIST = {android.support.v7.appcompat.R.drawable.abc_btn_check_material, android.support.v7.appcompat.R.drawable.abc_btn_radio_material};

    @android.support.annotation.RequiresApi(11)
    private static class AvdcInflateDelegate implements android.support.v7.widget.AppCompatDrawableManager.InflateDelegate {
        AvdcInflateDelegate() {
        }

        @Override // android.support.v7.widget.AppCompatDrawableManager.InflateDelegate
        public android.graphics.drawable.Drawable createFromXmlInner(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.NonNull org.xmlpull.v1.XmlPullParser xmlPullParser, @android.support.annotation.NonNull android.util.AttributeSet attributeSet, @android.support.annotation.Nullable android.content.res.Resources.Theme theme) {
            try {
                return android.support.graphics.drawable.AnimatedVectorDrawableCompat.createFromXmlInner(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (java.lang.Exception e) {
                android.util.Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
                return null;
            }
        }
    }

    private static class ColorFilterLruCache extends android.support.v4.util.LruCache<java.lang.Integer, android.graphics.PorterDuffColorFilter> {
        public ColorFilterLruCache(int i) {
            super(i);
        }

        private static int generateCacheKey(int i, android.graphics.PorterDuff.Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }

        android.graphics.PorterDuffColorFilter get(int i, android.graphics.PorterDuff.Mode mode) {
            return get(java.lang.Integer.valueOf(generateCacheKey(i, mode)));
        }

        android.graphics.PorterDuffColorFilter put(int i, android.graphics.PorterDuff.Mode mode, android.graphics.PorterDuffColorFilter porterDuffColorFilter) {
            return put(java.lang.Integer.valueOf(generateCacheKey(i, mode)), porterDuffColorFilter);
        }
    }

    private interface InflateDelegate {
        android.graphics.drawable.Drawable createFromXmlInner(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.NonNull org.xmlpull.v1.XmlPullParser xmlPullParser, @android.support.annotation.NonNull android.util.AttributeSet attributeSet, @android.support.annotation.Nullable android.content.res.Resources.Theme theme);
    }

    private static class VdcInflateDelegate implements android.support.v7.widget.AppCompatDrawableManager.InflateDelegate {
        VdcInflateDelegate() {
        }

        @Override // android.support.v7.widget.AppCompatDrawableManager.InflateDelegate
        public android.graphics.drawable.Drawable createFromXmlInner(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.NonNull org.xmlpull.v1.XmlPullParser xmlPullParser, @android.support.annotation.NonNull android.util.AttributeSet attributeSet, @android.support.annotation.Nullable android.content.res.Resources.Theme theme) {
            try {
                return android.support.graphics.drawable.VectorDrawableCompat.createFromXmlInner(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (java.lang.Exception e) {
                android.util.Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
                return null;
            }
        }
    }

    private void addDelegate(@android.support.annotation.NonNull java.lang.String str, @android.support.annotation.NonNull android.support.v7.widget.AppCompatDrawableManager.InflateDelegate inflateDelegate) {
        if (this.mDelegates == null) {
            this.mDelegates = new android.support.v4.util.ArrayMap<>();
        }
        this.mDelegates.put(str, inflateDelegate);
    }

    private boolean addDrawableToCache(@android.support.annotation.NonNull android.content.Context context, long j, @android.support.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        android.graphics.drawable.Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        synchronized (this.mDrawableCacheLock) {
            android.support.v4.util.LongSparseArray<java.lang.ref.WeakReference<android.graphics.drawable.Drawable.ConstantState>> longSparseArray = this.mDrawableCaches.get(context);
            if (longSparseArray == null) {
                longSparseArray = new android.support.v4.util.LongSparseArray<>();
                this.mDrawableCaches.put(context, longSparseArray);
            }
            longSparseArray.put(j, new java.lang.ref.WeakReference<>(constantState));
        }
        return true;
    }

    private void addTintListToCache(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.DrawableRes int i, @android.support.annotation.NonNull android.content.res.ColorStateList colorStateList) {
        if (this.mTintLists == null) {
            this.mTintLists = new java.util.WeakHashMap<>();
        }
        android.support.v4.util.SparseArrayCompat<android.content.res.ColorStateList> sparseArrayCompat = this.mTintLists.get(context);
        if (sparseArrayCompat == null) {
            sparseArrayCompat = new android.support.v4.util.SparseArrayCompat<>();
            this.mTintLists.put(context, sparseArrayCompat);
        }
        sparseArrayCompat.append(i, colorStateList);
    }

    private static boolean arrayContains(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private void checkVectorDrawableSetup(@android.support.annotation.NonNull android.content.Context context) {
        if (this.mHasCheckedVectorDrawableSetup) {
            return;
        }
        this.mHasCheckedVectorDrawableSetup = true;
        android.graphics.drawable.Drawable drawable = getDrawable(context, android.support.v7.appcompat.R.drawable.abc_vector_test);
        if (drawable == null || !isVectorDrawable(drawable)) {
            this.mHasCheckedVectorDrawableSetup = false;
            throw new java.lang.IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    private android.content.res.ColorStateList createBorderlessButtonColorStateList(@android.support.annotation.NonNull android.content.Context context) {
        return createButtonColorStateList(context, 0);
    }

    private android.content.res.ColorStateList createButtonColorStateList(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.ColorInt int i) {
        int themeAttrColor = android.support.v7.widget.ThemeUtils.getThemeAttrColor(context, android.support.v7.appcompat.R.attr.colorControlHighlight);
        return new android.content.res.ColorStateList(new int[][]{android.support.v7.widget.ThemeUtils.DISABLED_STATE_SET, android.support.v7.widget.ThemeUtils.PRESSED_STATE_SET, android.support.v7.widget.ThemeUtils.FOCUSED_STATE_SET, android.support.v7.widget.ThemeUtils.EMPTY_STATE_SET}, new int[]{android.support.v7.widget.ThemeUtils.getDisabledThemeAttrColor(context, android.support.v7.appcompat.R.attr.colorButtonNormal), android.support.v4.graphics.ColorUtils.compositeColors(themeAttrColor, i), android.support.v4.graphics.ColorUtils.compositeColors(themeAttrColor, i), i});
    }

    private static long createCacheKey(android.util.TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    private android.content.res.ColorStateList createColoredButtonColorStateList(@android.support.annotation.NonNull android.content.Context context) {
        return createButtonColorStateList(context, android.support.v7.widget.ThemeUtils.getThemeAttrColor(context, android.support.v7.appcompat.R.attr.colorAccent));
    }

    private android.content.res.ColorStateList createDefaultButtonColorStateList(@android.support.annotation.NonNull android.content.Context context) {
        return createButtonColorStateList(context, android.support.v7.widget.ThemeUtils.getThemeAttrColor(context, android.support.v7.appcompat.R.attr.colorButtonNormal));
    }

    private android.graphics.drawable.Drawable createDrawableIfNeeded(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.DrawableRes int i) {
        if (this.mTypedValue == null) {
            this.mTypedValue = new android.util.TypedValue();
        }
        android.util.TypedValue typedValue = this.mTypedValue;
        context.getResources().getValue(i, typedValue, true);
        long jCreateCacheKey = createCacheKey(typedValue);
        android.graphics.drawable.Drawable cachedDrawable = getCachedDrawable(context, jCreateCacheKey);
        if (cachedDrawable != null) {
            return cachedDrawable;
        }
        if (i == android.support.v7.appcompat.R.drawable.abc_cab_background_top_material) {
            cachedDrawable = new android.graphics.drawable.LayerDrawable(new android.graphics.drawable.Drawable[]{getDrawable(context, android.support.v7.appcompat.R.drawable.abc_cab_background_internal_bg), getDrawable(context, android.support.v7.appcompat.R.drawable.abc_cab_background_top_mtrl_alpha)});
        }
        if (cachedDrawable != null) {
            cachedDrawable.setChangingConfigurations(typedValue.changingConfigurations);
            addDrawableToCache(context, jCreateCacheKey, cachedDrawable);
        }
        return cachedDrawable;
    }

    private android.content.res.ColorStateList createSwitchThumbColorStateList(android.content.Context context) {
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        android.content.res.ColorStateList themeAttrColorStateList = android.support.v7.widget.ThemeUtils.getThemeAttrColorStateList(context, android.support.v7.appcompat.R.attr.colorSwitchThumbNormal);
        if (themeAttrColorStateList == null || !themeAttrColorStateList.isStateful()) {
            iArr[0] = android.support.v7.widget.ThemeUtils.DISABLED_STATE_SET;
            iArr2[0] = android.support.v7.widget.ThemeUtils.getDisabledThemeAttrColor(context, android.support.v7.appcompat.R.attr.colorSwitchThumbNormal);
            iArr[1] = android.support.v7.widget.ThemeUtils.CHECKED_STATE_SET;
            iArr2[1] = android.support.v7.widget.ThemeUtils.getThemeAttrColor(context, android.support.v7.appcompat.R.attr.colorControlActivated);
            iArr[2] = android.support.v7.widget.ThemeUtils.EMPTY_STATE_SET;
            iArr2[2] = android.support.v7.widget.ThemeUtils.getThemeAttrColor(context, android.support.v7.appcompat.R.attr.colorSwitchThumbNormal);
        } else {
            iArr[0] = android.support.v7.widget.ThemeUtils.DISABLED_STATE_SET;
            iArr2[0] = themeAttrColorStateList.getColorForState(iArr[0], 0);
            iArr[1] = android.support.v7.widget.ThemeUtils.CHECKED_STATE_SET;
            iArr2[1] = android.support.v7.widget.ThemeUtils.getThemeAttrColor(context, android.support.v7.appcompat.R.attr.colorControlActivated);
            iArr[2] = android.support.v7.widget.ThemeUtils.EMPTY_STATE_SET;
            iArr2[2] = themeAttrColorStateList.getDefaultColor();
        }
        return new android.content.res.ColorStateList(iArr, iArr2);
    }

    private static android.graphics.PorterDuffColorFilter createTintFilter(android.content.res.ColorStateList colorStateList, android.graphics.PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return getPorterDuffColorFilter(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static android.support.v7.widget.AppCompatDrawableManager get() {
        if (INSTANCE == null) {
            INSTANCE = new android.support.v7.widget.AppCompatDrawableManager();
            installDefaultInflateDelegates(INSTANCE);
        }
        return INSTANCE;
    }

    private android.graphics.drawable.Drawable getCachedDrawable(@android.support.annotation.NonNull android.content.Context context, long j) {
        synchronized (this.mDrawableCacheLock) {
            android.support.v4.util.LongSparseArray<java.lang.ref.WeakReference<android.graphics.drawable.Drawable.ConstantState>> longSparseArray = this.mDrawableCaches.get(context);
            if (longSparseArray == null) {
                return null;
            }
            java.lang.ref.WeakReference<android.graphics.drawable.Drawable.ConstantState> weakReference = longSparseArray.get(j);
            if (weakReference != null) {
                android.graphics.drawable.Drawable.ConstantState constantState = weakReference.get();
                if (constantState != null) {
                    return constantState.newDrawable(context.getResources());
                }
                longSparseArray.delete(j);
            }
            return null;
        }
    }

    public static android.graphics.PorterDuffColorFilter getPorterDuffColorFilter(int i, android.graphics.PorterDuff.Mode mode) {
        android.graphics.PorterDuffColorFilter porterDuffColorFilter = COLOR_FILTER_CACHE.get(i, mode);
        if (porterDuffColorFilter != null) {
            return porterDuffColorFilter;
        }
        android.graphics.PorterDuffColorFilter porterDuffColorFilter2 = new android.graphics.PorterDuffColorFilter(i, mode);
        COLOR_FILTER_CACHE.put(i, mode, porterDuffColorFilter2);
        return porterDuffColorFilter2;
    }

    private android.content.res.ColorStateList getTintListFromCache(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.DrawableRes int i) {
        android.support.v4.util.SparseArrayCompat<android.content.res.ColorStateList> sparseArrayCompat;
        java.util.WeakHashMap<android.content.Context, android.support.v4.util.SparseArrayCompat<android.content.res.ColorStateList>> weakHashMap = this.mTintLists;
        if (weakHashMap == null || (sparseArrayCompat = weakHashMap.get(context)) == null) {
            return null;
        }
        return sparseArrayCompat.get(i);
    }

    static android.graphics.PorterDuff.Mode getTintMode(int i) {
        if (i == android.support.v7.appcompat.R.drawable.abc_switch_thumb_material) {
            return android.graphics.PorterDuff.Mode.MULTIPLY;
        }
        return null;
    }

    private static void installDefaultInflateDelegates(@android.support.annotation.NonNull android.support.v7.widget.AppCompatDrawableManager appCompatDrawableManager) {
        if (android.os.Build.VERSION.SDK_INT < 24) {
            appCompatDrawableManager.addDelegate("vector", new android.support.v7.widget.AppCompatDrawableManager.VdcInflateDelegate());
            if (android.os.Build.VERSION.SDK_INT >= 11) {
                appCompatDrawableManager.addDelegate("animated-vector", new android.support.v7.widget.AppCompatDrawableManager.AvdcInflateDelegate());
            }
        }
    }

    private static boolean isVectorDrawable(@android.support.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        return (drawable instanceof android.support.graphics.drawable.VectorDrawableCompat) || PLATFORM_VD_CLAZZ.equals(drawable.getClass().getName());
    }

    private android.graphics.drawable.Drawable loadDrawableFromDelegates(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.DrawableRes int i) {
        int next;
        android.support.v4.util.ArrayMap<java.lang.String, android.support.v7.widget.AppCompatDrawableManager.InflateDelegate> arrayMap = this.mDelegates;
        if (arrayMap == null || arrayMap.isEmpty()) {
            return null;
        }
        android.support.v4.util.SparseArrayCompat<java.lang.String> sparseArrayCompat = this.mKnownDrawableIdTags;
        if (sparseArrayCompat != null) {
            java.lang.String str = sparseArrayCompat.get(i);
            if (SKIP_DRAWABLE_TAG.equals(str) || (str != null && this.mDelegates.get(str) == null)) {
                return null;
            }
        } else {
            this.mKnownDrawableIdTags = new android.support.v4.util.SparseArrayCompat<>();
        }
        if (this.mTypedValue == null) {
            this.mTypedValue = new android.util.TypedValue();
        }
        android.util.TypedValue typedValue = this.mTypedValue;
        android.content.res.Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        long jCreateCacheKey = createCacheKey(typedValue);
        android.graphics.drawable.Drawable cachedDrawable = getCachedDrawable(context, jCreateCacheKey);
        if (cachedDrawable != null) {
            return cachedDrawable;
        }
        if (typedValue.string != null && typedValue.string.toString().endsWith(".xml")) {
            try {
                android.content.res.XmlResourceParser xml = resources.getXml(i);
                android.util.AttributeSet attributeSetAsAttributeSet = android.util.Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new org.xmlpull.v1.XmlPullParserException("No start tag found");
                }
                java.lang.String name = xml.getName();
                this.mKnownDrawableIdTags.append(i, name);
                android.support.v7.widget.AppCompatDrawableManager.InflateDelegate inflateDelegate = this.mDelegates.get(name);
                if (inflateDelegate != null) {
                    cachedDrawable = inflateDelegate.createFromXmlInner(context, xml, attributeSetAsAttributeSet, context.getTheme());
                }
                if (cachedDrawable != null) {
                    cachedDrawable.setChangingConfigurations(typedValue.changingConfigurations);
                    addDrawableToCache(context, jCreateCacheKey, cachedDrawable);
                }
            } catch (java.lang.Exception e) {
                android.util.Log.e(TAG, "Exception while inflating drawable", e);
            }
        }
        if (cachedDrawable == null) {
            this.mKnownDrawableIdTags.append(i, SKIP_DRAWABLE_TAG);
        }
        return cachedDrawable;
    }

    private void removeDelegate(@android.support.annotation.NonNull java.lang.String str, @android.support.annotation.NonNull android.support.v7.widget.AppCompatDrawableManager.InflateDelegate inflateDelegate) {
        android.support.v4.util.ArrayMap<java.lang.String, android.support.v7.widget.AppCompatDrawableManager.InflateDelegate> arrayMap = this.mDelegates;
        if (arrayMap == null || arrayMap.get(str) != inflateDelegate) {
            return;
        }
        this.mDelegates.remove(str);
    }

    private static void setPorterDuffColorFilter(android.graphics.drawable.Drawable drawable, int i, android.graphics.PorterDuff.Mode mode) {
        if (android.support.v7.widget.DrawableUtils.canSafelyMutateDrawable(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = DEFAULT_MODE;
        }
        drawable.setColorFilter(getPorterDuffColorFilter(i, mode));
    }

    private android.graphics.drawable.Drawable tintDrawable(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.DrawableRes int i, boolean z, @android.support.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        android.content.res.ColorStateList tintList = getTintList(context, i);
        if (tintList != null) {
            if (android.support.v7.widget.DrawableUtils.canSafelyMutateDrawable(drawable)) {
                drawable = drawable.mutate();
            }
            android.graphics.drawable.Drawable drawableWrap = android.support.v4.graphics.drawable.DrawableCompat.wrap(drawable);
            android.support.v4.graphics.drawable.DrawableCompat.setTintList(drawableWrap, tintList);
            android.graphics.PorterDuff.Mode tintMode = getTintMode(i);
            if (tintMode == null) {
                return drawableWrap;
            }
            android.support.v4.graphics.drawable.DrawableCompat.setTintMode(drawableWrap, tintMode);
            return drawableWrap;
        }
        if (i == android.support.v7.appcompat.R.drawable.abc_seekbar_track_material) {
            android.graphics.drawable.LayerDrawable layerDrawable = (android.graphics.drawable.LayerDrawable) drawable;
            setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(android.R.id.background), android.support.v7.widget.ThemeUtils.getThemeAttrColor(context, android.support.v7.appcompat.R.attr.colorControlNormal), DEFAULT_MODE);
            setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(android.R.id.secondaryProgress), android.support.v7.widget.ThemeUtils.getThemeAttrColor(context, android.support.v7.appcompat.R.attr.colorControlNormal), DEFAULT_MODE);
            setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(android.R.id.progress), android.support.v7.widget.ThemeUtils.getThemeAttrColor(context, android.support.v7.appcompat.R.attr.colorControlActivated), DEFAULT_MODE);
            return drawable;
        }
        if (i != android.support.v7.appcompat.R.drawable.abc_ratingbar_material && i != android.support.v7.appcompat.R.drawable.abc_ratingbar_indicator_material && i != android.support.v7.appcompat.R.drawable.abc_ratingbar_small_material) {
            if (tintDrawableUsingColorFilter(context, i, drawable) || !z) {
                return drawable;
            }
            return null;
        }
        android.graphics.drawable.LayerDrawable layerDrawable2 = (android.graphics.drawable.LayerDrawable) drawable;
        setPorterDuffColorFilter(layerDrawable2.findDrawableByLayerId(android.R.id.background), android.support.v7.widget.ThemeUtils.getDisabledThemeAttrColor(context, android.support.v7.appcompat.R.attr.colorControlNormal), DEFAULT_MODE);
        setPorterDuffColorFilter(layerDrawable2.findDrawableByLayerId(android.R.id.secondaryProgress), android.support.v7.widget.ThemeUtils.getThemeAttrColor(context, android.support.v7.appcompat.R.attr.colorControlActivated), DEFAULT_MODE);
        setPorterDuffColorFilter(layerDrawable2.findDrawableByLayerId(android.R.id.progress), android.support.v7.widget.ThemeUtils.getThemeAttrColor(context, android.support.v7.appcompat.R.attr.colorControlActivated), DEFAULT_MODE);
        return drawable;
    }

    static void tintDrawable(android.graphics.drawable.Drawable drawable, android.support.v7.widget.TintInfo tintInfo, int[] iArr) {
        if (android.support.v7.widget.DrawableUtils.canSafelyMutateDrawable(drawable) && drawable.mutate() != drawable) {
            android.util.Log.d(TAG, "Mutated drawable is not the same instance as the input.");
            return;
        }
        if (tintInfo.mHasTintList || tintInfo.mHasTintMode) {
            drawable.setColorFilter(createTintFilter(tintInfo.mHasTintList ? tintInfo.mTintList : null, tintInfo.mHasTintMode ? tintInfo.mTintMode : DEFAULT_MODE, iArr));
        } else {
            drawable.clearColorFilter();
        }
        if (android.os.Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    static boolean tintDrawableUsingColorFilter(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.DrawableRes int i, @android.support.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        boolean z;
        int iRound;
        android.graphics.PorterDuff.Mode mode = DEFAULT_MODE;
        boolean zArrayContains = arrayContains(COLORFILTER_TINT_COLOR_CONTROL_NORMAL, i);
        int i2 = android.R.attr.colorBackground;
        if (zArrayContains) {
            i2 = android.support.v7.appcompat.R.attr.colorControlNormal;
            z = true;
            iRound = -1;
        } else if (arrayContains(COLORFILTER_COLOR_CONTROL_ACTIVATED, i)) {
            i2 = android.support.v7.appcompat.R.attr.colorControlActivated;
            z = true;
            iRound = -1;
        } else if (arrayContains(COLORFILTER_COLOR_BACKGROUND_MULTIPLY, i)) {
            mode = android.graphics.PorterDuff.Mode.MULTIPLY;
            z = true;
            iRound = -1;
        } else if (i == android.support.v7.appcompat.R.drawable.abc_list_divider_mtrl_alpha) {
            i2 = android.R.attr.colorForeground;
            iRound = java.lang.Math.round(40.8f);
            z = true;
        } else if (i == android.support.v7.appcompat.R.drawable.abc_dialog_material_background) {
            z = true;
            iRound = -1;
        } else {
            z = false;
            iRound = -1;
            i2 = 0;
        }
        if (!z) {
            return false;
        }
        if (android.support.v7.widget.DrawableUtils.canSafelyMutateDrawable(drawable)) {
            drawable = drawable.mutate();
        }
        drawable.setColorFilter(getPorterDuffColorFilter(android.support.v7.widget.ThemeUtils.getThemeAttrColor(context, i2), mode));
        if (iRound != -1) {
            drawable.setAlpha(iRound);
        }
        return true;
    }

    public android.graphics.drawable.Drawable getDrawable(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.DrawableRes int i) {
        return getDrawable(context, i, false);
    }

    android.graphics.drawable.Drawable getDrawable(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.DrawableRes int i, boolean z) {
        checkVectorDrawableSetup(context);
        android.graphics.drawable.Drawable drawableLoadDrawableFromDelegates = loadDrawableFromDelegates(context, i);
        if (drawableLoadDrawableFromDelegates == null) {
            drawableLoadDrawableFromDelegates = createDrawableIfNeeded(context, i);
        }
        if (drawableLoadDrawableFromDelegates == null) {
            drawableLoadDrawableFromDelegates = android.support.v4.content.ContextCompat.getDrawable(context, i);
        }
        if (drawableLoadDrawableFromDelegates != null) {
            drawableLoadDrawableFromDelegates = tintDrawable(context, i, z, drawableLoadDrawableFromDelegates);
        }
        if (drawableLoadDrawableFromDelegates != null) {
            android.support.v7.widget.DrawableUtils.fixDrawable(drawableLoadDrawableFromDelegates);
        }
        return drawableLoadDrawableFromDelegates;
    }

    android.content.res.ColorStateList getTintList(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.DrawableRes int i) {
        android.content.res.ColorStateList tintListFromCache = getTintListFromCache(context, i);
        if (tintListFromCache == null) {
            if (i == android.support.v7.appcompat.R.drawable.abc_edit_text_material) {
                tintListFromCache = android.support.v7.content.res.AppCompatResources.getColorStateList(context, android.support.v7.appcompat.R.color.abc_tint_edittext);
            } else if (i == android.support.v7.appcompat.R.drawable.abc_switch_track_mtrl_alpha) {
                tintListFromCache = android.support.v7.content.res.AppCompatResources.getColorStateList(context, android.support.v7.appcompat.R.color.abc_tint_switch_track);
            } else if (i == android.support.v7.appcompat.R.drawable.abc_switch_thumb_material) {
                tintListFromCache = createSwitchThumbColorStateList(context);
            } else if (i == android.support.v7.appcompat.R.drawable.abc_btn_default_mtrl_shape) {
                tintListFromCache = createDefaultButtonColorStateList(context);
            } else if (i == android.support.v7.appcompat.R.drawable.abc_btn_borderless_material) {
                tintListFromCache = createBorderlessButtonColorStateList(context);
            } else if (i == android.support.v7.appcompat.R.drawable.abc_btn_colored_material) {
                tintListFromCache = createColoredButtonColorStateList(context);
            } else if (i == android.support.v7.appcompat.R.drawable.abc_spinner_mtrl_am_alpha || i == android.support.v7.appcompat.R.drawable.abc_spinner_textfield_background_material) {
                tintListFromCache = android.support.v7.content.res.AppCompatResources.getColorStateList(context, android.support.v7.appcompat.R.color.abc_tint_spinner);
            } else if (arrayContains(TINT_COLOR_CONTROL_NORMAL, i)) {
                tintListFromCache = android.support.v7.widget.ThemeUtils.getThemeAttrColorStateList(context, android.support.v7.appcompat.R.attr.colorControlNormal);
            } else if (arrayContains(TINT_COLOR_CONTROL_STATE_LIST, i)) {
                tintListFromCache = android.support.v7.content.res.AppCompatResources.getColorStateList(context, android.support.v7.appcompat.R.color.abc_tint_default);
            } else if (arrayContains(TINT_CHECKABLE_BUTTON_LIST, i)) {
                tintListFromCache = android.support.v7.content.res.AppCompatResources.getColorStateList(context, android.support.v7.appcompat.R.color.abc_tint_btn_checkable);
            } else if (i == android.support.v7.appcompat.R.drawable.abc_seekbar_thumb_material) {
                tintListFromCache = android.support.v7.content.res.AppCompatResources.getColorStateList(context, android.support.v7.appcompat.R.color.abc_tint_seek_thumb);
            }
            if (tintListFromCache != null) {
                addTintListToCache(context, i, tintListFromCache);
            }
        }
        return tintListFromCache;
    }

    public void onConfigurationChanged(@android.support.annotation.NonNull android.content.Context context) {
        synchronized (this.mDrawableCacheLock) {
            android.support.v4.util.LongSparseArray<java.lang.ref.WeakReference<android.graphics.drawable.Drawable.ConstantState>> longSparseArray = this.mDrawableCaches.get(context);
            if (longSparseArray != null) {
                longSparseArray.clear();
            }
        }
    }

    android.graphics.drawable.Drawable onDrawableLoadedFromResources(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.NonNull android.support.v7.widget.VectorEnabledTintResources vectorEnabledTintResources, @android.support.annotation.DrawableRes int i) {
        android.graphics.drawable.Drawable drawableLoadDrawableFromDelegates = loadDrawableFromDelegates(context, i);
        if (drawableLoadDrawableFromDelegates == null) {
            drawableLoadDrawableFromDelegates = vectorEnabledTintResources.superGetDrawable(i);
        }
        if (drawableLoadDrawableFromDelegates != null) {
            return tintDrawable(context, i, false, drawableLoadDrawableFromDelegates);
        }
        return null;
    }
}
