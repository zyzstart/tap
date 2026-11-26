package android.support.graphics.drawable;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class AnimationUtilsCompat {
    private static android.view.animation.Interpolator createInterpolatorFromXml(android.content.Context context, android.content.res.Resources resources, android.content.res.Resources.Theme theme, org.xmlpull.v1.XmlPullParser xmlPullParser) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        int depth = xmlPullParser.getDepth();
        android.view.animation.Interpolator linearInterpolator = null;
        while (true) {
            int next = xmlPullParser.next();
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                break;
            }
            if (next == 2) {
                android.util.AttributeSet attributeSetAsAttributeSet = android.util.Xml.asAttributeSet(xmlPullParser);
                java.lang.String name = xmlPullParser.getName();
                if (name.equals("linearInterpolator")) {
                    linearInterpolator = new android.view.animation.LinearInterpolator();
                } else if (name.equals("accelerateInterpolator")) {
                    linearInterpolator = new android.view.animation.AccelerateInterpolator(context, attributeSetAsAttributeSet);
                } else if (name.equals("decelerateInterpolator")) {
                    linearInterpolator = new android.view.animation.DecelerateInterpolator(context, attributeSetAsAttributeSet);
                } else if (name.equals("accelerateDecelerateInterpolator")) {
                    linearInterpolator = new android.view.animation.AccelerateDecelerateInterpolator();
                } else if (name.equals("cycleInterpolator")) {
                    linearInterpolator = new android.view.animation.CycleInterpolator(context, attributeSetAsAttributeSet);
                } else if (name.equals("anticipateInterpolator")) {
                    linearInterpolator = new android.view.animation.AnticipateInterpolator(context, attributeSetAsAttributeSet);
                } else if (name.equals("overshootInterpolator")) {
                    linearInterpolator = new android.view.animation.OvershootInterpolator(context, attributeSetAsAttributeSet);
                } else if (name.equals("anticipateOvershootInterpolator")) {
                    linearInterpolator = new android.view.animation.AnticipateOvershootInterpolator(context, attributeSetAsAttributeSet);
                } else if (name.equals("bounceInterpolator")) {
                    linearInterpolator = new android.view.animation.BounceInterpolator();
                } else {
                    if (!name.equals("pathInterpolator")) {
                        throw new java.lang.RuntimeException("Unknown interpolator name: " + xmlPullParser.getName());
                    }
                    linearInterpolator = new android.support.graphics.drawable.PathInterpolatorCompat(context, attributeSetAsAttributeSet, xmlPullParser);
                }
            }
        }
        return linearInterpolator;
    }

    public static android.view.animation.Interpolator loadInterpolator(android.content.Context context, int i) throws android.content.res.Resources.NotFoundException {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            return android.view.animation.AnimationUtils.loadInterpolator(context, i);
        }
        android.content.res.XmlResourceParser xmlResourceParser = null;
        try {
            try {
                if (i == 17563663) {
                    return new android.support.v4.view.animation.FastOutLinearInInterpolator();
                }
                if (i == 17563661) {
                    return new android.support.v4.view.animation.FastOutSlowInInterpolator();
                }
                if (i == 17563662) {
                    return new android.support.v4.view.animation.LinearOutSlowInInterpolator();
                }
                android.content.res.XmlResourceParser animation = context.getResources().getAnimation(i);
                android.view.animation.Interpolator interpolatorCreateInterpolatorFromXml = createInterpolatorFromXml(context, context.getResources(), context.getTheme(), animation);
                if (animation != null) {
                    animation.close();
                }
                return interpolatorCreateInterpolatorFromXml;
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
            if (0 != 0) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }
}
