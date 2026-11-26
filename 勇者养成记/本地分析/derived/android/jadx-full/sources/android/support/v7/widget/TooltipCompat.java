package android.support.v7.widget;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class TooltipCompat {
    private static final android.support.v7.widget.TooltipCompat.ViewCompatImpl IMPL;

    @android.annotation.TargetApi(26)
    private static class Api26ViewCompatImpl implements android.support.v7.widget.TooltipCompat.ViewCompatImpl {
        private Api26ViewCompatImpl() {
        }

        @Override // android.support.v7.widget.TooltipCompat.ViewCompatImpl
        public void setTooltipText(@android.support.annotation.NonNull android.view.View view, @android.support.annotation.Nullable java.lang.CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    private static class BaseViewCompatImpl implements android.support.v7.widget.TooltipCompat.ViewCompatImpl {
        private BaseViewCompatImpl() {
        }

        @Override // android.support.v7.widget.TooltipCompat.ViewCompatImpl
        public void setTooltipText(@android.support.annotation.NonNull android.view.View view, @android.support.annotation.Nullable java.lang.CharSequence charSequence) {
            android.support.v7.widget.TooltipCompatHandler.setTooltipText(view, charSequence);
        }
    }

    private interface ViewCompatImpl {
        void setTooltipText(@android.support.annotation.NonNull android.view.View view, @android.support.annotation.Nullable java.lang.CharSequence charSequence);
    }

    static {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            IMPL = new android.support.v7.widget.TooltipCompat.Api26ViewCompatImpl();
        } else {
            IMPL = new android.support.v7.widget.TooltipCompat.BaseViewCompatImpl();
        }
    }

    private TooltipCompat() {
    }

    public static void setTooltipText(@android.support.annotation.NonNull android.view.View view, @android.support.annotation.Nullable java.lang.CharSequence charSequence) {
        IMPL.setTooltipText(view, charSequence);
    }
}
