package android.support.graphics.drawable;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class AnimatorInflaterCompat {
    private static final boolean DBG_ANIMATOR_INFLATER = false;
    private static final int MAX_NUM_POINTS = 100;
    private static final java.lang.String TAG = "AnimatorInflater";
    private static final int TOGETHER = 0;
    private static final int VALUE_TYPE_COLOR = 3;
    private static final int VALUE_TYPE_FLOAT = 0;
    private static final int VALUE_TYPE_INT = 1;
    private static final int VALUE_TYPE_PATH = 2;
    private static final int VALUE_TYPE_UNDEFINED = 4;

    private static class PathDataEvaluator implements android.animation.TypeEvaluator<android.support.v4.graphics.PathParser.PathDataNode[]> {
        private android.support.v4.graphics.PathParser.PathDataNode[] mNodeArray;

        private PathDataEvaluator() {
        }

        PathDataEvaluator(android.support.v4.graphics.PathParser.PathDataNode[] pathDataNodeArr) {
            this.mNodeArray = pathDataNodeArr;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.animation.TypeEvaluator
        public android.support.v4.graphics.PathParser.PathDataNode[] evaluate(float f, android.support.v4.graphics.PathParser.PathDataNode[] pathDataNodeArr, android.support.v4.graphics.PathParser.PathDataNode[] pathDataNodeArr2) {
            if (!android.support.v4.graphics.PathParser.canMorph(pathDataNodeArr, pathDataNodeArr2)) {
                throw new java.lang.IllegalArgumentException("Can't interpolate between two incompatible pathData");
            }
            android.support.v4.graphics.PathParser.PathDataNode[] pathDataNodeArr3 = this.mNodeArray;
            if (pathDataNodeArr3 == null || !android.support.v4.graphics.PathParser.canMorph(pathDataNodeArr3, pathDataNodeArr)) {
                this.mNodeArray = android.support.v4.graphics.PathParser.deepCopyNodes(pathDataNodeArr);
            }
            for (int i = 0; i < pathDataNodeArr.length; i++) {
                this.mNodeArray[i].interpolatePathDataNode(pathDataNodeArr[i], pathDataNodeArr2[i], f);
            }
            return this.mNodeArray;
        }
    }

    private static android.animation.Animator createAnimatorFromXml(android.content.Context context, android.content.res.Resources resources, android.content.res.Resources.Theme theme, org.xmlpull.v1.XmlPullParser xmlPullParser, float f) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        return createAnimatorFromXml(context, resources, theme, xmlPullParser, android.util.Xml.asAttributeSet(xmlPullParser), null, 0, f);
    }

    private static android.animation.Animator createAnimatorFromXml(android.content.Context context, android.content.res.Resources resources, android.content.res.Resources.Theme theme, org.xmlpull.v1.XmlPullParser xmlPullParser, android.util.AttributeSet attributeSet, android.animation.AnimatorSet animatorSet, int i, float f) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        int i2;
        int depth = xmlPullParser.getDepth();
        android.animation.Animator animatorLoadAnimator = null;
        java.util.ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            i2 = 0;
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                break;
            }
            if (next == 2) {
                java.lang.String name = xmlPullParser.getName();
                if (name.equals("objectAnimator")) {
                    animatorLoadAnimator = loadObjectAnimator(context, resources, theme, attributeSet, f, xmlPullParser);
                } else if (name.equals("animator")) {
                    animatorLoadAnimator = loadAnimator(context, resources, theme, attributeSet, null, f, xmlPullParser);
                } else if (name.equals("set")) {
                    android.animation.AnimatorSet animatorSet2 = new android.animation.AnimatorSet();
                    android.content.res.TypedArray typedArrayObtainAttributes = android.support.v4.content.res.TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, android.support.graphics.drawable.AndroidResources.STYLEABLE_ANIMATOR_SET);
                    createAnimatorFromXml(context, resources, theme, xmlPullParser, attributeSet, animatorSet2, android.support.v4.content.res.TypedArrayUtils.getNamedInt(typedArrayObtainAttributes, xmlPullParser, "ordering", 0, 0), f);
                    typedArrayObtainAttributes.recycle();
                    animatorLoadAnimator = animatorSet2;
                } else {
                    if (!name.equals("propertyValuesHolder")) {
                        throw new java.lang.RuntimeException("Unknown animator name: " + xmlPullParser.getName());
                    }
                    android.animation.PropertyValuesHolder[] propertyValuesHolderArrLoadValues = loadValues(context, resources, theme, xmlPullParser, android.util.Xml.asAttributeSet(xmlPullParser));
                    if (propertyValuesHolderArrLoadValues != null && animatorLoadAnimator != null && (animatorLoadAnimator instanceof android.animation.ValueAnimator)) {
                        ((android.animation.ValueAnimator) animatorLoadAnimator).setValues(propertyValuesHolderArrLoadValues);
                    }
                    i2 = 1;
                }
                if (animatorSet != null && i2 == 0) {
                    if (arrayList == null) {
                        arrayList = new java.util.ArrayList();
                    }
                    arrayList.add(animatorLoadAnimator);
                }
            }
        }
        if (animatorSet != null && arrayList != null) {
            android.animation.Animator[] animatorArr = new android.animation.Animator[arrayList.size()];
            java.util.Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                animatorArr[i2] = (android.animation.Animator) it.next();
                i2++;
            }
            if (i == 0) {
                animatorSet.playTogether(animatorArr);
            } else {
                animatorSet.playSequentially(animatorArr);
            }
        }
        return animatorLoadAnimator;
    }

    private static android.animation.Keyframe createNewKeyframe(android.animation.Keyframe keyframe, float f) {
        if (keyframe.getType() == java.lang.Float.TYPE) {
            return android.animation.Keyframe.ofFloat(f);
        }
        return keyframe.getType() == java.lang.Integer.TYPE ? android.animation.Keyframe.ofInt(f) : android.animation.Keyframe.ofObject(f);
    }

    private static void distributeKeyframes(android.animation.Keyframe[] keyframeArr, float f, int i, int i2) {
        float f2 = f / ((i2 - i) + 2);
        while (i <= i2) {
            keyframeArr[i].setFraction(keyframeArr[i - 1].getFraction() + f2);
            i++;
        }
    }

    private static void dumpKeyframes(java.lang.Object[] objArr, java.lang.String str) {
        if (objArr == null || objArr.length == 0) {
            return;
        }
        android.util.Log.d(TAG, str);
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            android.animation.Keyframe keyframe = (android.animation.Keyframe) objArr[i];
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Keyframe ");
            sb.append(i);
            sb.append(": fraction ");
            sb.append(keyframe.getFraction() < 0.0f ? "null" : java.lang.Float.valueOf(keyframe.getFraction()));
            sb.append(", ");
            sb.append(", value : ");
            sb.append(keyframe.hasValue() ? keyframe.getValue() : "null");
            android.util.Log.d(TAG, sb.toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static android.animation.PropertyValuesHolder getPVH(android.content.res.TypedArray typedArray, int i, int i2, int i3, java.lang.String str) {
        int color;
        int color2;
        int color3;
        android.util.TypedValue typedValuePeekValue = typedArray.peekValue(i2);
        boolean z = typedValuePeekValue != null;
        int i4 = z ? typedValuePeekValue.type : 0;
        android.util.TypedValue typedValuePeekValue2 = typedArray.peekValue(i3);
        boolean z2 = typedValuePeekValue2 != null;
        int i5 = z2 ? typedValuePeekValue2.type : 0;
        if (i == 4) {
            i = ((z && isColorType(i4)) || (z2 && isColorType(i5))) ? 3 : 0;
        }
        boolean z3 = i == 0;
        android.animation.PropertyValuesHolder propertyValuesHolderOfInt = null;
        java.lang.Object[] objArr = 0;
        java.lang.Object[] objArr2 = 0;
        if (i == 2) {
            java.lang.String string = typedArray.getString(i2);
            java.lang.String string2 = typedArray.getString(i3);
            android.support.v4.graphics.PathParser.PathDataNode[] pathDataNodeArrCreateNodesFromPathData = android.support.v4.graphics.PathParser.createNodesFromPathData(string);
            android.support.v4.graphics.PathParser.PathDataNode[] pathDataNodeArrCreateNodesFromPathData2 = android.support.v4.graphics.PathParser.createNodesFromPathData(string2);
            if (pathDataNodeArrCreateNodesFromPathData == null && pathDataNodeArrCreateNodesFromPathData2 == null) {
                return null;
            }
            if (pathDataNodeArrCreateNodesFromPathData == null) {
                if (pathDataNodeArrCreateNodesFromPathData2 != null) {
                    return android.animation.PropertyValuesHolder.ofObject(str, new android.support.graphics.drawable.AnimatorInflaterCompat.PathDataEvaluator(), pathDataNodeArrCreateNodesFromPathData2);
                }
                return null;
            }
            android.support.graphics.drawable.AnimatorInflaterCompat.PathDataEvaluator pathDataEvaluator = new android.support.graphics.drawable.AnimatorInflaterCompat.PathDataEvaluator();
            if (pathDataNodeArrCreateNodesFromPathData2 == null) {
                return android.animation.PropertyValuesHolder.ofObject(str, pathDataEvaluator, pathDataNodeArrCreateNodesFromPathData);
            }
            if (android.support.v4.graphics.PathParser.canMorph(pathDataNodeArrCreateNodesFromPathData, pathDataNodeArrCreateNodesFromPathData2)) {
                return android.animation.PropertyValuesHolder.ofObject(str, pathDataEvaluator, pathDataNodeArrCreateNodesFromPathData, pathDataNodeArrCreateNodesFromPathData2);
            }
            throw new android.view.InflateException(" Can't morph from " + string + " to " + string2);
        }
        android.support.graphics.drawable.ArgbEvaluator argbEvaluator = i == 3 ? android.support.graphics.drawable.ArgbEvaluator.getInstance() : null;
        if (z3) {
            if (z) {
                float dimension = i4 == 5 ? typedArray.getDimension(i2, 0.0f) : typedArray.getFloat(i2, 0.0f);
                if (z2) {
                    propertyValuesHolderOfInt = android.animation.PropertyValuesHolder.ofFloat(str, dimension, i5 == 5 ? typedArray.getDimension(i3, 0.0f) : typedArray.getFloat(i3, 0.0f));
                } else {
                    propertyValuesHolderOfInt = android.animation.PropertyValuesHolder.ofFloat(str, dimension);
                }
            } else {
                propertyValuesHolderOfInt = android.animation.PropertyValuesHolder.ofFloat(str, i5 == 5 ? typedArray.getDimension(i3, 0.0f) : typedArray.getFloat(i3, 0.0f));
            }
        } else if (z) {
            if (i4 == 5) {
                color2 = (int) typedArray.getDimension(i2, 0.0f);
            } else {
                color2 = isColorType(i4) ? typedArray.getColor(i2, 0) : typedArray.getInt(i2, 0);
            }
            if (z2) {
                if (i5 == 5) {
                    color3 = (int) typedArray.getDimension(i3, 0.0f);
                } else {
                    color3 = isColorType(i5) ? typedArray.getColor(i3, 0) : typedArray.getInt(i3, 0);
                }
                propertyValuesHolderOfInt = android.animation.PropertyValuesHolder.ofInt(str, color2, color3);
            } else {
                propertyValuesHolderOfInt = android.animation.PropertyValuesHolder.ofInt(str, color2);
            }
        } else if (z2) {
            if (i5 == 5) {
                color = (int) typedArray.getDimension(i3, 0.0f);
            } else {
                color = isColorType(i5) ? typedArray.getColor(i3, 0) : typedArray.getInt(i3, 0);
            }
            propertyValuesHolderOfInt = android.animation.PropertyValuesHolder.ofInt(str, color);
        }
        if (propertyValuesHolderOfInt == null || argbEvaluator == null) {
            return propertyValuesHolderOfInt;
        }
        propertyValuesHolderOfInt.setEvaluator(argbEvaluator);
        return propertyValuesHolderOfInt;
    }

    private static int inferValueTypeFromValues(android.content.res.TypedArray typedArray, int i, int i2) {
        android.util.TypedValue typedValuePeekValue = typedArray.peekValue(i);
        boolean z = typedValuePeekValue != null;
        int i3 = z ? typedValuePeekValue.type : 0;
        android.util.TypedValue typedValuePeekValue2 = typedArray.peekValue(i2);
        boolean z2 = typedValuePeekValue2 != null;
        return ((z && isColorType(i3)) || (z2 && isColorType(z2 ? typedValuePeekValue2.type : 0))) ? 3 : 0;
    }

    private static int inferValueTypeOfKeyframe(android.content.res.Resources resources, android.content.res.Resources.Theme theme, android.util.AttributeSet attributeSet, org.xmlpull.v1.XmlPullParser xmlPullParser) {
        android.content.res.TypedArray typedArrayObtainAttributes = android.support.v4.content.res.TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, android.support.graphics.drawable.AndroidResources.STYLEABLE_KEYFRAME);
        int i = 0;
        android.util.TypedValue typedValuePeekNamedValue = android.support.v4.content.res.TypedArrayUtils.peekNamedValue(typedArrayObtainAttributes, xmlPullParser, com.qq.gdt.action.ActionUtils.PAYMENT_AMOUNT, 0);
        if ((typedValuePeekNamedValue != null) && isColorType(typedValuePeekNamedValue.type)) {
            i = 3;
        }
        typedArrayObtainAttributes.recycle();
        return i;
    }

    private static boolean isColorType(int i) {
        return i >= 28 && i <= 31;
    }

    public static android.animation.Animator loadAnimator(android.content.Context context, @android.support.annotation.AnimatorRes int i) throws android.content.res.Resources.NotFoundException {
        return android.os.Build.VERSION.SDK_INT >= 24 ? android.animation.AnimatorInflater.loadAnimator(context, i) : loadAnimator(context, context.getResources(), context.getTheme(), i);
    }

    public static android.animation.Animator loadAnimator(android.content.Context context, android.content.res.Resources resources, android.content.res.Resources.Theme theme, @android.support.annotation.AnimatorRes int i) throws android.content.res.Resources.NotFoundException {
        return loadAnimator(context, resources, theme, i, 1.0f);
    }

    public static android.animation.Animator loadAnimator(android.content.Context context, android.content.res.Resources resources, android.content.res.Resources.Theme theme, @android.support.annotation.AnimatorRes int i, float f) throws android.content.res.Resources.NotFoundException {
        android.content.res.XmlResourceParser animation = null;
        try {
            try {
                animation = resources.getAnimation(i);
                android.animation.Animator animatorCreateAnimatorFromXml = createAnimatorFromXml(context, resources, theme, animation, f);
                if (animation != null) {
                    animation.close();
                }
                return animatorCreateAnimatorFromXml;
            } catch (java.io.IOException e) {
                android.content.res.Resources.NotFoundException notFoundException = new android.content.res.Resources.NotFoundException("Can't load animation resource ID #0x" + java.lang.Integer.toHexString(i));
                notFoundException.initCause(e);
                throw notFoundException;
            } catch (org.xmlpull.v1.XmlPullParserException e2) {
                android.content.res.Resources.NotFoundException notFoundException2 = new android.content.res.Resources.NotFoundException("Can't load animation resource ID #0x" + java.lang.Integer.toHexString(i));
                notFoundException2.initCause(e2);
                throw notFoundException2;
            }
        } catch (java.lang.Throwable th) {
            if (animation != null) {
                animation.close();
            }
            throw th;
        }
    }

    private static android.animation.ValueAnimator loadAnimator(android.content.Context context, android.content.res.Resources resources, android.content.res.Resources.Theme theme, android.util.AttributeSet attributeSet, android.animation.ValueAnimator valueAnimator, float f, org.xmlpull.v1.XmlPullParser xmlPullParser) throws android.content.res.Resources.NotFoundException {
        android.content.res.TypedArray typedArrayObtainAttributes = android.support.v4.content.res.TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, android.support.graphics.drawable.AndroidResources.STYLEABLE_ANIMATOR);
        android.content.res.TypedArray typedArrayObtainAttributes2 = android.support.v4.content.res.TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, android.support.graphics.drawable.AndroidResources.STYLEABLE_PROPERTY_ANIMATOR);
        if (valueAnimator == null) {
            valueAnimator = new android.animation.ValueAnimator();
        }
        parseAnimatorFromTypeArray(valueAnimator, typedArrayObtainAttributes, typedArrayObtainAttributes2, f, xmlPullParser);
        int namedResourceId = android.support.v4.content.res.TypedArrayUtils.getNamedResourceId(typedArrayObtainAttributes, xmlPullParser, "interpolator", 0, 0);
        if (namedResourceId > 0) {
            valueAnimator.setInterpolator(android.support.graphics.drawable.AnimationUtilsCompat.loadInterpolator(context, namedResourceId));
        }
        typedArrayObtainAttributes.recycle();
        if (typedArrayObtainAttributes2 != null) {
            typedArrayObtainAttributes2.recycle();
        }
        return valueAnimator;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0041  */
    private static android.animation.Keyframe loadKeyframe(android.content.Context context, android.content.res.Resources resources, android.content.res.Resources.Theme theme, android.util.AttributeSet attributeSet, int i, org.xmlpull.v1.XmlPullParser xmlPullParser) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        android.animation.Keyframe keyframeOfFloat;
        android.content.res.TypedArray typedArrayObtainAttributes = android.support.v4.content.res.TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, android.support.graphics.drawable.AndroidResources.STYLEABLE_KEYFRAME);
        float namedFloat = android.support.v4.content.res.TypedArrayUtils.getNamedFloat(typedArrayObtainAttributes, xmlPullParser, "fraction", 3, -1.0f);
        android.util.TypedValue typedValuePeekNamedValue = android.support.v4.content.res.TypedArrayUtils.peekNamedValue(typedArrayObtainAttributes, xmlPullParser, com.qq.gdt.action.ActionUtils.PAYMENT_AMOUNT, 0);
        boolean z = typedValuePeekNamedValue != null;
        if (i == 4) {
            i = (z && isColorType(typedValuePeekNamedValue.type)) ? 3 : 0;
        }
        if (!z) {
            keyframeOfFloat = i == 0 ? android.animation.Keyframe.ofFloat(namedFloat) : android.animation.Keyframe.ofInt(namedFloat);
        } else if (i != 3) {
            switch (i) {
                case 0:
                    keyframeOfFloat = android.animation.Keyframe.ofFloat(namedFloat, android.support.v4.content.res.TypedArrayUtils.getNamedFloat(typedArrayObtainAttributes, xmlPullParser, com.qq.gdt.action.ActionUtils.PAYMENT_AMOUNT, 0, 0.0f));
                    break;
                case 1:
                    keyframeOfFloat = android.animation.Keyframe.ofInt(namedFloat, android.support.v4.content.res.TypedArrayUtils.getNamedInt(typedArrayObtainAttributes, xmlPullParser, com.qq.gdt.action.ActionUtils.PAYMENT_AMOUNT, 0, 0));
                    break;
                default:
                    keyframeOfFloat = null;
                    break;
            }
        } else {
            keyframeOfFloat = android.animation.Keyframe.ofInt(namedFloat, android.support.v4.content.res.TypedArrayUtils.getNamedInt(typedArrayObtainAttributes, xmlPullParser, com.qq.gdt.action.ActionUtils.PAYMENT_AMOUNT, 0, 0));
        }
        int namedResourceId = android.support.v4.content.res.TypedArrayUtils.getNamedResourceId(typedArrayObtainAttributes, xmlPullParser, "interpolator", 1, 0);
        if (namedResourceId > 0) {
            keyframeOfFloat.setInterpolator(android.support.graphics.drawable.AnimationUtilsCompat.loadInterpolator(context, namedResourceId));
        }
        typedArrayObtainAttributes.recycle();
        return keyframeOfFloat;
    }

    private static android.animation.ObjectAnimator loadObjectAnimator(android.content.Context context, android.content.res.Resources resources, android.content.res.Resources.Theme theme, android.util.AttributeSet attributeSet, float f, org.xmlpull.v1.XmlPullParser xmlPullParser) throws android.content.res.Resources.NotFoundException {
        android.animation.ObjectAnimator objectAnimator = new android.animation.ObjectAnimator();
        loadAnimator(context, resources, theme, attributeSet, objectAnimator, f, xmlPullParser);
        return objectAnimator;
    }

    private static android.animation.PropertyValuesHolder loadPvh(android.content.Context context, android.content.res.Resources resources, android.content.res.Resources.Theme theme, org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, int i) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        int size;
        android.animation.PropertyValuesHolder propertyValuesHolderOfKeyframe = null;
        int iInferValueTypeOfKeyframe = i;
        java.util.ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 3 || next == 1) {
                break;
            }
            if (xmlPullParser.getName().equals("keyframe")) {
                if (iInferValueTypeOfKeyframe == 4) {
                    iInferValueTypeOfKeyframe = inferValueTypeOfKeyframe(resources, theme, android.util.Xml.asAttributeSet(xmlPullParser), xmlPullParser);
                }
                android.animation.Keyframe keyframeLoadKeyframe = loadKeyframe(context, resources, theme, android.util.Xml.asAttributeSet(xmlPullParser), iInferValueTypeOfKeyframe, xmlPullParser);
                if (keyframeLoadKeyframe != null) {
                    if (arrayList == null) {
                        arrayList = new java.util.ArrayList();
                    }
                    arrayList.add(keyframeLoadKeyframe);
                }
                xmlPullParser.next();
            }
        }
        if (arrayList != null && (size = arrayList.size()) > 0) {
            android.animation.Keyframe keyframe = (android.animation.Keyframe) arrayList.get(0);
            android.animation.Keyframe keyframe2 = (android.animation.Keyframe) arrayList.get(size - 1);
            float fraction = keyframe2.getFraction();
            if (fraction < 1.0f) {
                if (fraction < 0.0f) {
                    keyframe2.setFraction(1.0f);
                } else {
                    arrayList.add(arrayList.size(), createNewKeyframe(keyframe2, 1.0f));
                    size++;
                }
            }
            float fraction2 = keyframe.getFraction();
            if (fraction2 != 0.0f) {
                if (fraction2 < 0.0f) {
                    keyframe.setFraction(0.0f);
                } else {
                    arrayList.add(0, createNewKeyframe(keyframe, 0.0f));
                    size++;
                }
            }
            android.animation.Keyframe[] keyframeArr = new android.animation.Keyframe[size];
            arrayList.toArray(keyframeArr);
            for (int i2 = 0; i2 < size; i2++) {
                android.animation.Keyframe keyframe3 = keyframeArr[i2];
                if (keyframe3.getFraction() < 0.0f) {
                    if (i2 == 0) {
                        keyframe3.setFraction(0.0f);
                    } else {
                        int i3 = size - 1;
                        if (i2 == i3) {
                            keyframe3.setFraction(1.0f);
                        } else {
                            int i4 = i2;
                            for (int i5 = i2 + 1; i5 < i3 && keyframeArr[i5].getFraction() < 0.0f; i5++) {
                                i4 = i5;
                            }
                            distributeKeyframes(keyframeArr, keyframeArr[i4 + 1].getFraction() - keyframeArr[i2 - 1].getFraction(), i2, i4);
                        }
                    }
                }
            }
            propertyValuesHolderOfKeyframe = android.animation.PropertyValuesHolder.ofKeyframe(str, keyframeArr);
            if (iInferValueTypeOfKeyframe == 3) {
                propertyValuesHolderOfKeyframe.setEvaluator(android.support.graphics.drawable.ArgbEvaluator.getInstance());
            }
        }
        return propertyValuesHolderOfKeyframe;
    }

    private static android.animation.PropertyValuesHolder[] loadValues(android.content.Context context, android.content.res.Resources resources, android.content.res.Resources.Theme theme, org.xmlpull.v1.XmlPullParser xmlPullParser, android.util.AttributeSet attributeSet) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        int i;
        android.animation.PropertyValuesHolder[] propertyValuesHolderArr = null;
        java.util.ArrayList arrayList = null;
        while (true) {
            int eventType = xmlPullParser.getEventType();
            if (eventType == 3 || eventType == 1) {
                break;
            }
            if (eventType != 2) {
                xmlPullParser.next();
            } else {
                if (xmlPullParser.getName().equals("propertyValuesHolder")) {
                    android.content.res.TypedArray typedArrayObtainAttributes = android.support.v4.content.res.TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, android.support.graphics.drawable.AndroidResources.STYLEABLE_PROPERTY_VALUES_HOLDER);
                    java.lang.String namedString = android.support.v4.content.res.TypedArrayUtils.getNamedString(typedArrayObtainAttributes, xmlPullParser, "propertyName", 3);
                    int namedInt = android.support.v4.content.res.TypedArrayUtils.getNamedInt(typedArrayObtainAttributes, xmlPullParser, "valueType", 2, 4);
                    android.animation.PropertyValuesHolder propertyValuesHolderLoadPvh = loadPvh(context, resources, theme, xmlPullParser, namedString, namedInt);
                    if (propertyValuesHolderLoadPvh == null) {
                        propertyValuesHolderLoadPvh = getPVH(typedArrayObtainAttributes, namedInt, 0, 1, namedString);
                    }
                    if (propertyValuesHolderLoadPvh != null) {
                        if (arrayList == null) {
                            arrayList = new java.util.ArrayList();
                        }
                        arrayList.add(propertyValuesHolderLoadPvh);
                    }
                    typedArrayObtainAttributes.recycle();
                }
                xmlPullParser.next();
            }
        }
        if (arrayList != null) {
            int size = arrayList.size();
            propertyValuesHolderArr = new android.animation.PropertyValuesHolder[size];
            for (i = 0; i < size; i++) {
                propertyValuesHolderArr[i] = (android.animation.PropertyValuesHolder) arrayList.get(i);
            }
        }
        return propertyValuesHolderArr;
    }

    private static void parseAnimatorFromTypeArray(android.animation.ValueAnimator valueAnimator, android.content.res.TypedArray typedArray, android.content.res.TypedArray typedArray2, float f, org.xmlpull.v1.XmlPullParser xmlPullParser) {
        long namedInt = android.support.v4.content.res.TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "duration", 1, 300);
        long namedInt2 = android.support.v4.content.res.TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "startOffset", 2, 0);
        int namedInt3 = android.support.v4.content.res.TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "valueType", 7, 4);
        if (android.support.v4.content.res.TypedArrayUtils.hasAttribute(xmlPullParser, "valueFrom") && android.support.v4.content.res.TypedArrayUtils.hasAttribute(xmlPullParser, "valueTo")) {
            if (namedInt3 == 4) {
                namedInt3 = inferValueTypeFromValues(typedArray, 5, 6);
            }
            android.animation.PropertyValuesHolder pvh = getPVH(typedArray, namedInt3, 5, 6, "");
            if (pvh != null) {
                valueAnimator.setValues(pvh);
            }
        }
        valueAnimator.setDuration(namedInt);
        valueAnimator.setStartDelay(namedInt2);
        valueAnimator.setRepeatCount(android.support.v4.content.res.TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "repeatCount", 3, 0));
        valueAnimator.setRepeatMode(android.support.v4.content.res.TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "repeatMode", 4, 1));
        if (typedArray2 != null) {
            setupObjectAnimator(valueAnimator, typedArray2, namedInt3, f, xmlPullParser);
        }
    }

    private static void setupObjectAnimator(android.animation.ValueAnimator valueAnimator, android.content.res.TypedArray typedArray, int i, float f, org.xmlpull.v1.XmlPullParser xmlPullParser) {
        android.animation.ObjectAnimator objectAnimator = (android.animation.ObjectAnimator) valueAnimator;
        java.lang.String namedString = android.support.v4.content.res.TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "pathData", 1);
        if (namedString == null) {
            objectAnimator.setPropertyName(android.support.v4.content.res.TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "propertyName", 0));
            return;
        }
        java.lang.String namedString2 = android.support.v4.content.res.TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "propertyXName", 2);
        java.lang.String namedString3 = android.support.v4.content.res.TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "propertyYName", 3);
        if (i != 2) {
        }
        if (namedString2 != null || namedString3 != null) {
            setupPathMotion(android.support.v4.graphics.PathParser.createPathFromPathData(namedString), objectAnimator, f * 0.5f, namedString2, namedString3);
            return;
        }
        throw new android.view.InflateException(typedArray.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
    }

    private static void setupPathMotion(android.graphics.Path path, android.animation.ObjectAnimator objectAnimator, float f, java.lang.String str, java.lang.String str2) {
        char c = 0;
        android.graphics.PathMeasure pathMeasure = new android.graphics.PathMeasure(path, false);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(java.lang.Float.valueOf(0.0f));
        float length = 0.0f;
        do {
            length += pathMeasure.getLength();
            arrayList.add(java.lang.Float.valueOf(length));
        } while (pathMeasure.nextContour());
        android.graphics.PathMeasure pathMeasure2 = new android.graphics.PathMeasure(path, false);
        int iMin = java.lang.Math.min(100, ((int) (length / f)) + 1);
        float[] fArr = new float[iMin];
        float[] fArr2 = new float[iMin];
        float[] fArr3 = new float[2];
        float f2 = length / (iMin - 1);
        int i = 0;
        float fFloatValue = 0.0f;
        int i2 = 0;
        while (true) {
            if (i >= iMin) {
                break;
            }
            pathMeasure2.getPosTan(fFloatValue, fArr3, null);
            pathMeasure2.getPosTan(fFloatValue, fArr3, null);
            fArr[i] = fArr3[c];
            fArr2[i] = fArr3[1];
            fFloatValue += f2;
            int i3 = i2 + 1;
            if (i3 < arrayList.size() && fFloatValue > ((java.lang.Float) arrayList.get(i3)).floatValue()) {
                fFloatValue -= ((java.lang.Float) arrayList.get(i3)).floatValue();
                pathMeasure2.nextContour();
                i2 = i3;
            }
            i++;
            c = 0;
        }
        android.animation.PropertyValuesHolder propertyValuesHolderOfFloat = str != null ? android.animation.PropertyValuesHolder.ofFloat(str, fArr) : null;
        android.animation.PropertyValuesHolder propertyValuesHolderOfFloat2 = str2 != null ? android.animation.PropertyValuesHolder.ofFloat(str2, fArr2) : null;
        if (propertyValuesHolderOfFloat == null) {
            objectAnimator.setValues(propertyValuesHolderOfFloat2);
        } else if (propertyValuesHolderOfFloat2 == null) {
            objectAnimator.setValues(propertyValuesHolderOfFloat);
        } else {
            objectAnimator.setValues(propertyValuesHolderOfFloat, propertyValuesHolderOfFloat2);
        }
    }
}
