package android.support.v7.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class AppCompatViewInflater {
    private static final java.lang.String LOG_TAG = "AppCompatViewInflater";
    private final java.lang.Object[] mConstructorArgs = new java.lang.Object[2];
    private static final java.lang.Class<?>[] sConstructorSignature = {android.content.Context.class, android.util.AttributeSet.class};
    private static final int[] sOnClickAttrs = {android.R.attr.onClick};
    private static final java.lang.String[] sClassPrefixList = {"android.widget.", "android.view.", "android.webkit."};
    private static final java.util.Map<java.lang.String, java.lang.reflect.Constructor<? extends android.view.View>> sConstructorMap = new android.support.v4.util.ArrayMap();

    private static class DeclaredOnClickListener implements android.view.View.OnClickListener {
        private final android.view.View mHostView;
        private final java.lang.String mMethodName;
        private android.content.Context mResolvedContext;
        private java.lang.reflect.Method mResolvedMethod;

        public DeclaredOnClickListener(@android.support.annotation.NonNull android.view.View view, @android.support.annotation.NonNull java.lang.String str) {
            this.mHostView = view;
            this.mMethodName = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @android.support.annotation.NonNull
        private void resolveMethod(@android.support.annotation.Nullable android.content.Context context, @android.support.annotation.NonNull java.lang.String str) {
            java.lang.String str2;
            java.lang.reflect.Method method;
            while (context != null) {
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(this.mMethodName, android.view.View.class)) != null) {
                        this.mResolvedMethod = method;
                        this.mResolvedContext = context;
                        return;
                    }
                } catch (java.lang.NoSuchMethodException unused) {
                }
                context = context instanceof android.content.ContextWrapper ? ((android.content.ContextWrapper) context).getBaseContext() : null;
            }
            int id = this.mHostView.getId();
            if (id == -1) {
                str2 = "";
            } else {
                str2 = " with id '" + this.mHostView.getContext().getResources().getResourceEntryName(id) + "'";
            }
            throw new java.lang.IllegalStateException("Could not find method " + this.mMethodName + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.mHostView.getClass() + str2);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@android.support.annotation.NonNull android.view.View view) {
            if (this.mResolvedMethod == null) {
                resolveMethod(this.mHostView.getContext(), this.mMethodName);
            }
            try {
                this.mResolvedMethod.invoke(this.mResolvedContext, view);
            } catch (java.lang.IllegalAccessException e) {
                throw new java.lang.IllegalStateException("Could not execute non-public method for android:onClick", e);
            } catch (java.lang.reflect.InvocationTargetException e2) {
                throw new java.lang.IllegalStateException("Could not execute method for android:onClick", e2);
            }
        }
    }

    AppCompatViewInflater() {
    }

    private void checkOnClickListener(android.view.View view, android.util.AttributeSet attributeSet) {
        android.content.Context context = view.getContext();
        if (context instanceof android.content.ContextWrapper) {
            if (android.os.Build.VERSION.SDK_INT < 15 || android.support.v4.view.ViewCompat.hasOnClickListeners(view)) {
                android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, sOnClickAttrs);
                java.lang.String string = typedArrayObtainStyledAttributes.getString(0);
                if (string != null) {
                    view.setOnClickListener(new android.support.v7.app.AppCompatViewInflater.DeclaredOnClickListener(view, string));
                }
                typedArrayObtainStyledAttributes.recycle();
            }
        }
    }

    private android.view.View createView(android.content.Context context, java.lang.String str, java.lang.String str2) throws android.view.InflateException, java.lang.ClassNotFoundException {
        java.lang.String str3;
        java.lang.reflect.Constructor<? extends android.view.View> constructor = sConstructorMap.get(str);
        if (constructor == null) {
            try {
                java.lang.ClassLoader classLoader = context.getClassLoader();
                if (str2 != null) {
                    str3 = str2 + str;
                } else {
                    str3 = str;
                }
                constructor = classLoader.loadClass(str3).asSubclass(android.view.View.class).getConstructor(sConstructorSignature);
                sConstructorMap.put(str, constructor);
            } catch (java.lang.Exception unused) {
                return null;
            }
        }
        constructor.setAccessible(true);
        return constructor.newInstance(this.mConstructorArgs);
    }

    private android.view.View createViewFromTag(android.content.Context context, java.lang.String str, android.util.AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            this.mConstructorArgs[0] = context;
            this.mConstructorArgs[1] = attributeSet;
            if (-1 != str.indexOf(46)) {
                return createView(context, str, null);
            }
            for (int i = 0; i < sClassPrefixList.length; i++) {
                android.view.View viewCreateView = createView(context, str, sClassPrefixList[i]);
                if (viewCreateView != null) {
                    return viewCreateView;
                }
            }
            return null;
        } catch (java.lang.Exception unused) {
            return null;
        } finally {
            java.lang.Object[] objArr = this.mConstructorArgs;
            objArr[0] = null;
            objArr[1] = null;
        }
    }

    private static android.content.Context themifyContext(android.content.Context context, android.util.AttributeSet attributeSet, boolean z, boolean z2) {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.v7.appcompat.R.styleable.View, 0, 0);
        int resourceId = z ? typedArrayObtainStyledAttributes.getResourceId(android.support.v7.appcompat.R.styleable.View_android_theme, 0) : 0;
        if (z2 && resourceId == 0 && (resourceId = typedArrayObtainStyledAttributes.getResourceId(android.support.v7.appcompat.R.styleable.View_theme, 0)) != 0) {
            android.util.Log.i(LOG_TAG, "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        typedArrayObtainStyledAttributes.recycle();
        if (resourceId != 0) {
            return ((context instanceof android.support.v7.view.ContextThemeWrapper) && ((android.support.v7.view.ContextThemeWrapper) context).getThemeResId() == resourceId) ? context : new android.support.v7.view.ContextThemeWrapper(context, resourceId);
        }
        return context;
    }

    public final android.view.View createView(android.view.View view, java.lang.String str, @android.support.annotation.NonNull android.content.Context context, @android.support.annotation.NonNull android.util.AttributeSet attributeSet, boolean z, boolean z2, boolean z3, boolean z4) {
        android.content.Context context2 = (!z || view == null) ? context : view.getContext();
        if (z2 || z3) {
            context2 = themifyContext(context2, attributeSet, z2, z3);
        }
        if (z4) {
            context2 = android.support.v7.widget.TintContextWrapper.wrap(context2);
        }
        android.view.View viewCreateViewFromTag = null;
        switch (str) {
            case "TextView":
                viewCreateViewFromTag = new android.support.v7.widget.AppCompatTextView(context2, attributeSet);
                break;
            case "ImageView":
                viewCreateViewFromTag = new android.support.v7.widget.AppCompatImageView(context2, attributeSet);
                break;
            case "Button":
                viewCreateViewFromTag = new android.support.v7.widget.AppCompatButton(context2, attributeSet);
                break;
            case "EditText":
                viewCreateViewFromTag = new android.support.v7.widget.AppCompatEditText(context2, attributeSet);
                break;
            case "Spinner":
                viewCreateViewFromTag = new android.support.v7.widget.AppCompatSpinner(context2, attributeSet);
                break;
            case "ImageButton":
                viewCreateViewFromTag = new android.support.v7.widget.AppCompatImageButton(context2, attributeSet);
                break;
            case "CheckBox":
                viewCreateViewFromTag = new android.support.v7.widget.AppCompatCheckBox(context2, attributeSet);
                break;
            case "RadioButton":
                viewCreateViewFromTag = new android.support.v7.widget.AppCompatRadioButton(context2, attributeSet);
                break;
            case "CheckedTextView":
                viewCreateViewFromTag = new android.support.v7.widget.AppCompatCheckedTextView(context2, attributeSet);
                break;
            case "AutoCompleteTextView":
                viewCreateViewFromTag = new android.support.v7.widget.AppCompatAutoCompleteTextView(context2, attributeSet);
                break;
            case "MultiAutoCompleteTextView":
                viewCreateViewFromTag = new android.support.v7.widget.AppCompatMultiAutoCompleteTextView(context2, attributeSet);
                break;
            case "RatingBar":
                viewCreateViewFromTag = new android.support.v7.widget.AppCompatRatingBar(context2, attributeSet);
                break;
            case "SeekBar":
                viewCreateViewFromTag = new android.support.v7.widget.AppCompatSeekBar(context2, attributeSet);
                break;
        }
        if (viewCreateViewFromTag == null && context != context2) {
            viewCreateViewFromTag = createViewFromTag(context2, str, attributeSet);
        }
        if (viewCreateViewFromTag != null) {
            checkOnClickListener(viewCreateViewFromTag, attributeSet);
        }
        return viewCreateViewFromTag;
    }
}
