package android.support.v4.graphics;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class ColorUtils {
    private static final int MIN_ALPHA_SEARCH_MAX_ITERATIONS = 10;
    private static final int MIN_ALPHA_SEARCH_PRECISION = 1;
    private static final java.lang.ThreadLocal<double[]> TEMP_ARRAY = new java.lang.ThreadLocal<>();
    private static final double XYZ_EPSILON = 0.008856d;
    private static final double XYZ_KAPPA = 903.3d;
    private static final double XYZ_WHITE_REFERENCE_X = 95.047d;
    private static final double XYZ_WHITE_REFERENCE_Y = 100.0d;
    private static final double XYZ_WHITE_REFERENCE_Z = 108.883d;

    private ColorUtils() {
    }

    @android.support.annotation.ColorInt
    public static int HSLToColor(@android.support.annotation.NonNull float[] fArr) {
        int iRound;
        int iRound2;
        int iRound3;
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float fAbs = (1.0f - java.lang.Math.abs((f3 * 2.0f) - 1.0f)) * f2;
        float f4 = f3 - (0.5f * fAbs);
        float fAbs2 = (1.0f - java.lang.Math.abs(((f / 60.0f) % 2.0f) - 1.0f)) * fAbs;
        switch (((int) f) / 60) {
            case 0:
                iRound = java.lang.Math.round((fAbs + f4) * 255.0f);
                iRound2 = java.lang.Math.round((fAbs2 + f4) * 255.0f);
                iRound3 = java.lang.Math.round(f4 * 255.0f);
                break;
            case 1:
                iRound = java.lang.Math.round((fAbs2 + f4) * 255.0f);
                iRound2 = java.lang.Math.round((fAbs + f4) * 255.0f);
                iRound3 = java.lang.Math.round(f4 * 255.0f);
                break;
            case 2:
                iRound = java.lang.Math.round(f4 * 255.0f);
                iRound2 = java.lang.Math.round((fAbs + f4) * 255.0f);
                iRound3 = java.lang.Math.round((fAbs2 + f4) * 255.0f);
                break;
            case 3:
                iRound = java.lang.Math.round(f4 * 255.0f);
                iRound2 = java.lang.Math.round((fAbs2 + f4) * 255.0f);
                iRound3 = java.lang.Math.round((fAbs + f4) * 255.0f);
                break;
            case 4:
                iRound = java.lang.Math.round((fAbs2 + f4) * 255.0f);
                iRound2 = java.lang.Math.round(f4 * 255.0f);
                iRound3 = java.lang.Math.round((fAbs + f4) * 255.0f);
                break;
            case 5:
            case 6:
                iRound = java.lang.Math.round((fAbs + f4) * 255.0f);
                iRound2 = java.lang.Math.round(f4 * 255.0f);
                iRound3 = java.lang.Math.round((fAbs2 + f4) * 255.0f);
                break;
            default:
                iRound3 = 0;
                iRound = 0;
                iRound2 = 0;
                break;
        }
        return android.graphics.Color.rgb(constrain(iRound, 0, 255), constrain(iRound2, 0, 255), constrain(iRound3, 0, 255));
    }

    @android.support.annotation.ColorInt
    public static int LABToColor(@android.support.annotation.FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_Y) double d, @android.support.annotation.FloatRange(from = -128.0d, to = 127.0d) double d2, @android.support.annotation.FloatRange(from = -128.0d, to = 127.0d) double d3) {
        double[] tempDouble3Array = getTempDouble3Array();
        LABToXYZ(d, d2, d3, tempDouble3Array);
        return XYZToColor(tempDouble3Array[0], tempDouble3Array[1], tempDouble3Array[2]);
    }

    public static void LABToXYZ(@android.support.annotation.FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_Y) double d, @android.support.annotation.FloatRange(from = -128.0d, to = 127.0d) double d2, @android.support.annotation.FloatRange(from = -128.0d, to = 127.0d) double d3, @android.support.annotation.NonNull double[] dArr) {
        double d4 = (d + 16.0d) / 116.0d;
        double d5 = (d2 / 500.0d) + d4;
        double d6 = d4 - (d3 / 200.0d);
        double dPow = java.lang.Math.pow(d5, 3.0d);
        if (dPow <= XYZ_EPSILON) {
            dPow = ((d5 * 116.0d) - 16.0d) / XYZ_KAPPA;
        }
        double dPow2 = d > 7.9996247999999985d ? java.lang.Math.pow(d4, 3.0d) : d / XYZ_KAPPA;
        double dPow3 = java.lang.Math.pow(d6, 3.0d);
        if (dPow3 <= XYZ_EPSILON) {
            dPow3 = ((d6 * 116.0d) - 16.0d) / XYZ_KAPPA;
        }
        dArr[0] = dPow * XYZ_WHITE_REFERENCE_X;
        dArr[1] = dPow2 * XYZ_WHITE_REFERENCE_Y;
        dArr[2] = dPow3 * XYZ_WHITE_REFERENCE_Z;
    }

    public static void RGBToHSL(@android.support.annotation.IntRange(from = android.support.v4.media.MediaDescriptionCompat.BT_FOLDER_TYPE_MIXED, to = 255) int i, @android.support.annotation.IntRange(from = android.support.v4.media.MediaDescriptionCompat.BT_FOLDER_TYPE_MIXED, to = 255) int i2, @android.support.annotation.IntRange(from = android.support.v4.media.MediaDescriptionCompat.BT_FOLDER_TYPE_MIXED, to = 255) int i3, @android.support.annotation.NonNull float[] fArr) {
        float f;
        float fAbs;
        float f2 = i / 255.0f;
        float f3 = i2 / 255.0f;
        float f4 = i3 / 255.0f;
        float fMax = java.lang.Math.max(f2, java.lang.Math.max(f3, f4));
        float fMin = java.lang.Math.min(f2, java.lang.Math.min(f3, f4));
        float f5 = fMax - fMin;
        float f6 = (fMax + fMin) / 2.0f;
        if (fMax == fMin) {
            f = 0.0f;
            fAbs = 0.0f;
        } else {
            if (fMax == f2) {
                f = ((f3 - f4) / f5) % 6.0f;
            } else {
                f = fMax == f3 ? ((f4 - f2) / f5) + 2.0f : ((f2 - f3) / f5) + 4.0f;
            }
            fAbs = f5 / (1.0f - java.lang.Math.abs((2.0f * f6) - 1.0f));
        }
        float f7 = (f * 60.0f) % 360.0f;
        if (f7 < 0.0f) {
            f7 += 360.0f;
        }
        fArr[0] = constrain(f7, 0.0f, 360.0f);
        fArr[1] = constrain(fAbs, 0.0f, 1.0f);
        fArr[2] = constrain(f6, 0.0f, 1.0f);
    }

    public static void RGBToLAB(@android.support.annotation.IntRange(from = android.support.v4.media.MediaDescriptionCompat.BT_FOLDER_TYPE_MIXED, to = 255) int i, @android.support.annotation.IntRange(from = android.support.v4.media.MediaDescriptionCompat.BT_FOLDER_TYPE_MIXED, to = 255) int i2, @android.support.annotation.IntRange(from = android.support.v4.media.MediaDescriptionCompat.BT_FOLDER_TYPE_MIXED, to = 255) int i3, @android.support.annotation.NonNull double[] dArr) {
        RGBToXYZ(i, i2, i3, dArr);
        XYZToLAB(dArr[0], dArr[1], dArr[2], dArr);
    }

    public static void RGBToXYZ(@android.support.annotation.IntRange(from = android.support.v4.media.MediaDescriptionCompat.BT_FOLDER_TYPE_MIXED, to = 255) int i, @android.support.annotation.IntRange(from = android.support.v4.media.MediaDescriptionCompat.BT_FOLDER_TYPE_MIXED, to = 255) int i2, @android.support.annotation.IntRange(from = android.support.v4.media.MediaDescriptionCompat.BT_FOLDER_TYPE_MIXED, to = 255) int i3, @android.support.annotation.NonNull double[] dArr) {
        if (dArr.length != 3) {
            throw new java.lang.IllegalArgumentException("outXyz must have a length of 3.");
        }
        double d = i;
        java.lang.Double.isNaN(d);
        double d2 = d / 255.0d;
        double dPow = d2 < 0.04045d ? d2 / 12.92d : java.lang.Math.pow((d2 + 0.055d) / 1.055d, 2.4d);
        double d3 = i2;
        java.lang.Double.isNaN(d3);
        double d4 = d3 / 255.0d;
        double dPow2 = d4 < 0.04045d ? d4 / 12.92d : java.lang.Math.pow((d4 + 0.055d) / 1.055d, 2.4d);
        double d5 = i3;
        java.lang.Double.isNaN(d5);
        double d6 = d5 / 255.0d;
        double dPow3 = d6 < 0.04045d ? d6 / 12.92d : java.lang.Math.pow((d6 + 0.055d) / 1.055d, 2.4d);
        dArr[0] = ((0.4124d * dPow) + (0.3576d * dPow2) + (0.1805d * dPow3)) * XYZ_WHITE_REFERENCE_Y;
        dArr[1] = ((0.2126d * dPow) + (0.7152d * dPow2) + (0.0722d * dPow3)) * XYZ_WHITE_REFERENCE_Y;
        dArr[2] = ((dPow * 0.0193d) + (dPow2 * 0.1192d) + (dPow3 * 0.9505d)) * XYZ_WHITE_REFERENCE_Y;
    }

    @android.support.annotation.ColorInt
    public static int XYZToColor(@android.support.annotation.FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_X) double d, @android.support.annotation.FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_Y) double d2, @android.support.annotation.FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_Z) double d3) {
        double d4 = (((3.2406d * d) + ((-1.5372d) * d2)) + ((-0.4986d) * d3)) / XYZ_WHITE_REFERENCE_Y;
        double d5 = ((((-0.9689d) * d) + (1.8758d * d2)) + (0.0415d * d3)) / XYZ_WHITE_REFERENCE_Y;
        double d6 = (((0.0557d * d) + ((-0.204d) * d2)) + (1.057d * d3)) / XYZ_WHITE_REFERENCE_Y;
        return android.graphics.Color.rgb(constrain((int) java.lang.Math.round((d4 > 0.0031308d ? (java.lang.Math.pow(d4, 0.4166666666666667d) * 1.055d) - 0.055d : d4 * 12.92d) * 255.0d), 0, 255), constrain((int) java.lang.Math.round((d5 > 0.0031308d ? (java.lang.Math.pow(d5, 0.4166666666666667d) * 1.055d) - 0.055d : d5 * 12.92d) * 255.0d), 0, 255), constrain((int) java.lang.Math.round((d6 > 0.0031308d ? (java.lang.Math.pow(d6, 0.4166666666666667d) * 1.055d) - 0.055d : d6 * 12.92d) * 255.0d), 0, 255));
    }

    public static void XYZToLAB(@android.support.annotation.FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_X) double d, @android.support.annotation.FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_Y) double d2, @android.support.annotation.FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_Z) double d3, @android.support.annotation.NonNull double[] dArr) {
        if (dArr.length != 3) {
            throw new java.lang.IllegalArgumentException("outLab must have a length of 3.");
        }
        double dPivotXyzComponent = pivotXyzComponent(d / XYZ_WHITE_REFERENCE_X);
        double dPivotXyzComponent2 = pivotXyzComponent(d2 / XYZ_WHITE_REFERENCE_Y);
        double dPivotXyzComponent3 = pivotXyzComponent(d3 / XYZ_WHITE_REFERENCE_Z);
        dArr[0] = java.lang.Math.max(0.0d, (116.0d * dPivotXyzComponent2) - 16.0d);
        dArr[1] = (dPivotXyzComponent - dPivotXyzComponent2) * 500.0d;
        dArr[2] = (dPivotXyzComponent2 - dPivotXyzComponent3) * 200.0d;
    }

    @android.support.annotation.ColorInt
    public static int blendARGB(@android.support.annotation.ColorInt int i, @android.support.annotation.ColorInt int i2, @android.support.annotation.FloatRange(from = 0.0d, to = com.unisound.sdk.cu.f1558a) float f) {
        float f2 = 1.0f - f;
        return android.graphics.Color.argb((int) ((android.graphics.Color.alpha(i) * f2) + (android.graphics.Color.alpha(i2) * f)), (int) ((android.graphics.Color.red(i) * f2) + (android.graphics.Color.red(i2) * f)), (int) ((android.graphics.Color.green(i) * f2) + (android.graphics.Color.green(i2) * f)), (int) ((android.graphics.Color.blue(i) * f2) + (android.graphics.Color.blue(i2) * f)));
    }

    public static void blendHSL(@android.support.annotation.NonNull float[] fArr, @android.support.annotation.NonNull float[] fArr2, @android.support.annotation.FloatRange(from = 0.0d, to = com.unisound.sdk.cu.f1558a) float f, @android.support.annotation.NonNull float[] fArr3) {
        if (fArr3.length != 3) {
            throw new java.lang.IllegalArgumentException("result must have a length of 3.");
        }
        float f2 = 1.0f - f;
        fArr3[0] = circularInterpolate(fArr[0], fArr2[0], f);
        fArr3[1] = (fArr[1] * f2) + (fArr2[1] * f);
        fArr3[2] = (fArr[2] * f2) + (fArr2[2] * f);
    }

    public static void blendLAB(@android.support.annotation.NonNull double[] dArr, @android.support.annotation.NonNull double[] dArr2, @android.support.annotation.FloatRange(from = 0.0d, to = com.unisound.sdk.cu.f1558a) double d, @android.support.annotation.NonNull double[] dArr3) {
        if (dArr3.length != 3) {
            throw new java.lang.IllegalArgumentException("outResult must have a length of 3.");
        }
        double d2 = 1.0d - d;
        dArr3[0] = (dArr[0] * d2) + (dArr2[0] * d);
        dArr3[1] = (dArr[1] * d2) + (dArr2[1] * d);
        dArr3[2] = (dArr[2] * d2) + (dArr2[2] * d);
    }

    public static double calculateContrast(@android.support.annotation.ColorInt int i, @android.support.annotation.ColorInt int i2) {
        if (android.graphics.Color.alpha(i2) != 255) {
            throw new java.lang.IllegalArgumentException("background can not be translucent: #" + java.lang.Integer.toHexString(i2));
        }
        if (android.graphics.Color.alpha(i) < 255) {
            i = compositeColors(i, i2);
        }
        double dCalculateLuminance = calculateLuminance(i) + 0.05d;
        double dCalculateLuminance2 = calculateLuminance(i2) + 0.05d;
        return java.lang.Math.max(dCalculateLuminance, dCalculateLuminance2) / java.lang.Math.min(dCalculateLuminance, dCalculateLuminance2);
    }

    @android.support.annotation.FloatRange(from = 0.0d, to = com.unisound.sdk.cu.f1558a)
    public static double calculateLuminance(@android.support.annotation.ColorInt int i) {
        double[] tempDouble3Array = getTempDouble3Array();
        colorToXYZ(i, tempDouble3Array);
        return tempDouble3Array[1] / XYZ_WHITE_REFERENCE_Y;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int calculateMinimumAlpha(@android.support.annotation.ColorInt int i, @android.support.annotation.ColorInt int i2, float f) {
        int i3 = 255;
        if (android.graphics.Color.alpha(i2) != 255) {
            throw new java.lang.IllegalArgumentException("background can not be translucent: #" + java.lang.Integer.toHexString(i2));
        }
        double d = f;
        if (calculateContrast(setAlphaComponent(i, 255), i2) < d) {
            return -1;
        }
        int i4 = 0;
        for (int i5 = 0; i5 <= 10 && i3 - i4 > 1; i5++) {
            int i6 = (i4 + i3) / 2;
            if (calculateContrast(setAlphaComponent(i, i6), i2) < d) {
                i4 = i6;
            } else {
                i3 = i6;
            }
        }
        return i3;
    }

    @android.support.annotation.VisibleForTesting
    static float circularInterpolate(float f, float f2, float f3) {
        if (java.lang.Math.abs(f2 - f) > 180.0f) {
            if (f2 > f) {
                f += 360.0f;
            } else {
                f2 += 360.0f;
            }
        }
        return (f + ((f2 - f) * f3)) % 360.0f;
    }

    public static void colorToHSL(@android.support.annotation.ColorInt int i, @android.support.annotation.NonNull float[] fArr) {
        RGBToHSL(android.graphics.Color.red(i), android.graphics.Color.green(i), android.graphics.Color.blue(i), fArr);
    }

    public static void colorToLAB(@android.support.annotation.ColorInt int i, @android.support.annotation.NonNull double[] dArr) {
        RGBToLAB(android.graphics.Color.red(i), android.graphics.Color.green(i), android.graphics.Color.blue(i), dArr);
    }

    public static void colorToXYZ(@android.support.annotation.ColorInt int i, @android.support.annotation.NonNull double[] dArr) {
        RGBToXYZ(android.graphics.Color.red(i), android.graphics.Color.green(i), android.graphics.Color.blue(i), dArr);
    }

    private static int compositeAlpha(int i, int i2) {
        return 255 - (((255 - i2) * (255 - i)) / 255);
    }

    public static int compositeColors(@android.support.annotation.ColorInt int i, @android.support.annotation.ColorInt int i2) {
        int iAlpha = android.graphics.Color.alpha(i2);
        int iAlpha2 = android.graphics.Color.alpha(i);
        int iCompositeAlpha = compositeAlpha(iAlpha2, iAlpha);
        return android.graphics.Color.argb(iCompositeAlpha, compositeComponent(android.graphics.Color.red(i), iAlpha2, android.graphics.Color.red(i2), iAlpha, iCompositeAlpha), compositeComponent(android.graphics.Color.green(i), iAlpha2, android.graphics.Color.green(i2), iAlpha, iCompositeAlpha), compositeComponent(android.graphics.Color.blue(i), iAlpha2, android.graphics.Color.blue(i2), iAlpha, iCompositeAlpha));
    }

    private static int compositeComponent(int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            return 0;
        }
        return (((i * 255) * i2) + ((i3 * i4) * (255 - i2))) / (i5 * 255);
    }

    private static float constrain(float f, float f2, float f3) {
        if (f < f2) {
            return f2;
        }
        return f > f3 ? f3 : f;
    }

    private static int constrain(int i, int i2, int i3) {
        if (i < i2) {
            return i2;
        }
        return i > i3 ? i3 : i;
    }

    public static double distanceEuclidean(@android.support.annotation.NonNull double[] dArr, @android.support.annotation.NonNull double[] dArr2) {
        return java.lang.Math.sqrt(java.lang.Math.pow(dArr[0] - dArr2[0], 2.0d) + java.lang.Math.pow(dArr[1] - dArr2[1], 2.0d) + java.lang.Math.pow(dArr[2] - dArr2[2], 2.0d));
    }

    private static double[] getTempDouble3Array() {
        double[] dArr = TEMP_ARRAY.get();
        if (dArr != null) {
            return dArr;
        }
        double[] dArr2 = new double[3];
        TEMP_ARRAY.set(dArr2);
        return dArr2;
    }

    private static double pivotXyzComponent(double d) {
        return d > XYZ_EPSILON ? java.lang.Math.pow(d, 0.3333333333333333d) : ((d * XYZ_KAPPA) + 16.0d) / 116.0d;
    }

    @android.support.annotation.ColorInt
    public static int setAlphaComponent(@android.support.annotation.ColorInt int i, @android.support.annotation.IntRange(from = android.support.v4.media.MediaDescriptionCompat.BT_FOLDER_TYPE_MIXED, to = 255) int i2) {
        if (i2 < 0 || i2 > 255) {
            throw new java.lang.IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (i & android.support.v4.view.ViewCompat.MEASURED_SIZE_MASK) | (i2 << 24);
    }
}
