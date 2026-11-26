package com.tencent.ysdk.shell.libware.ui;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ViewUtils {
    private static float DEVICE_DENSITY = 0.0f;
    private static java.lang.String TAG = "ViewUtils";
    private static int statusBarHeight;

    public static int dip2px(android.content.Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int getNavigationBarHeight(android.app.Activity activity) {
        int identifier;
        try {
            if (!isUserVirtualBar(activity) || (identifier = activity.getResources().getIdentifier("navigation_bar_height", "dimen", "android")) <= 0) {
                return 0;
            }
            return activity.getResources().getDimensionPixelSize(identifier);
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.shell.module.stat.StatHelper.reportStatError(null, e);
            return 0;
        }
    }

    public static int getRealScreenSizeX(android.content.Context context) {
        if (android.os.Build.VERSION.SDK_INT <= 17) {
            return getScreenWidth(context);
        }
        android.view.Display defaultDisplay = ((android.view.WindowManager) context.getSystemService("window")).getDefaultDisplay();
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int getRealScreenSizeY(android.content.Context context) {
        if (android.os.Build.VERSION.SDK_INT <= 17) {
            return getScreenHeight(context);
        }
        android.view.Display defaultDisplay = ((android.view.WindowManager) context.getSystemService("window")).getDefaultDisplay();
        android.graphics.Point point = new android.graphics.Point();
        defaultDisplay.getRealSize(point);
        return point.y;
    }

    public static int getScreenAvailabe(android.app.Activity activity) {
        return activity.getWindow().getAttributes().flags == 1024 ? getScreenHeight(activity) : getScreenHeight(activity) - getStatusBarHeight(activity);
    }

    public static int getScreenHeight(android.content.Context context) {
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        ((android.view.WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int getScreenWidth(android.content.Context context) {
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        ((android.view.WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int getScreenWindowHeight(android.app.Activity activity) {
        if (activity != null) {
            return activity.getWindow().getDecorView().getHeight();
        }
        return 0;
    }

    public static int getScreenWindowWidth(android.app.Activity activity) {
        if (activity != null) {
            return activity.getWindow().getDecorView().getWidth();
        }
        return 0;
    }

    public static int getStatusBarHeight(android.content.Context context) {
        int identifier;
        if (statusBarHeight == 0 && (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android")) > 0) {
            statusBarHeight = context.getResources().getDimensionPixelSize(identifier);
        }
        return statusBarHeight;
    }

    private static boolean isUserVirtualBar(android.app.Activity activity) {
        boolean z;
        if (android.os.Build.VERSION.SDK_INT < 17) {
            return false;
        }
        android.view.WindowManager windowManager = activity.getWindowManager();
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        android.view.Display defaultDisplay = windowManager.getDefaultDisplay();
        defaultDisplay.getRealMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        android.util.DisplayMetrics displayMetrics2 = new android.util.DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics2);
        int i2 = i - displayMetrics2.widthPixels;
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) activity.getWindow().getDecorView();
        int childCount = viewGroup.getChildCount();
        int i3 = 0;
        while (true) {
            if (i3 >= childCount) {
                z = false;
                break;
            }
            android.view.View childAt = viewGroup.getChildAt(i3);
            if ((childAt == null || childAt.getId() == -1 || !"navigationBarBackground".equals(activity.getResources().getResourceEntryName(childAt.getId()))) ? false : true) {
                z = true;
                break;
            }
            i3++;
        }
        return z && i2 > 0;
    }

    public static android.graphics.Bitmap loadBitmapFromView(android.view.View view) {
        if (view == null) {
            return null;
        }
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(view.getWidth(), view.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapCreateBitmap);
        canvas.translate(-view.getScrollX(), -view.getScrollY());
        view.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static int px2dip(float f, float f2) {
        return (int) ((f / f2) + 0.5f);
    }

    public static int px2dip(android.content.Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
