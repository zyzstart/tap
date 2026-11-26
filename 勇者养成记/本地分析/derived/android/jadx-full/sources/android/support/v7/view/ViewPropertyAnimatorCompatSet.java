package android.support.v7.view;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class ViewPropertyAnimatorCompatSet {
    private android.view.animation.Interpolator mInterpolator;
    private boolean mIsStarted;
    android.support.v4.view.ViewPropertyAnimatorListener mListener;
    private long mDuration = -1;
    private final android.support.v4.view.ViewPropertyAnimatorListenerAdapter mProxyListener = new android.support.v4.view.ViewPropertyAnimatorListenerAdapter() { // from class: android.support.v7.view.ViewPropertyAnimatorCompatSet.1
        private boolean mProxyStarted = false;
        private int mProxyEndCount = 0;

        @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(android.view.View view) {
            int i = this.mProxyEndCount + 1;
            this.mProxyEndCount = i;
            if (i == android.support.v7.view.ViewPropertyAnimatorCompatSet.this.mAnimators.size()) {
                if (android.support.v7.view.ViewPropertyAnimatorCompatSet.this.mListener != null) {
                    android.support.v7.view.ViewPropertyAnimatorCompatSet.this.mListener.onAnimationEnd(null);
                }
                onEnd();
            }
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
        public void onAnimationStart(android.view.View view) {
            if (this.mProxyStarted) {
                return;
            }
            this.mProxyStarted = true;
            if (android.support.v7.view.ViewPropertyAnimatorCompatSet.this.mListener != null) {
                android.support.v7.view.ViewPropertyAnimatorCompatSet.this.mListener.onAnimationStart(null);
            }
        }

        void onEnd() {
            this.mProxyEndCount = 0;
            this.mProxyStarted = false;
            android.support.v7.view.ViewPropertyAnimatorCompatSet.this.onAnimationsEnded();
        }
    };
    final java.util.ArrayList<android.support.v4.view.ViewPropertyAnimatorCompat> mAnimators = new java.util.ArrayList<>();

    public void cancel() {
        if (this.mIsStarted) {
            java.util.Iterator<android.support.v4.view.ViewPropertyAnimatorCompat> it = this.mAnimators.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
            this.mIsStarted = false;
        }
    }

    void onAnimationsEnded() {
        this.mIsStarted = false;
    }

    public android.support.v7.view.ViewPropertyAnimatorCompatSet play(android.support.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
        if (!this.mIsStarted) {
            this.mAnimators.add(viewPropertyAnimatorCompat);
        }
        return this;
    }

    public android.support.v7.view.ViewPropertyAnimatorCompatSet playSequentially(android.support.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, android.support.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2) {
        this.mAnimators.add(viewPropertyAnimatorCompat);
        viewPropertyAnimatorCompat2.setStartDelay(viewPropertyAnimatorCompat.getDuration());
        this.mAnimators.add(viewPropertyAnimatorCompat2);
        return this;
    }

    public android.support.v7.view.ViewPropertyAnimatorCompatSet setDuration(long j) {
        if (!this.mIsStarted) {
            this.mDuration = j;
        }
        return this;
    }

    public android.support.v7.view.ViewPropertyAnimatorCompatSet setInterpolator(android.view.animation.Interpolator interpolator) {
        if (!this.mIsStarted) {
            this.mInterpolator = interpolator;
        }
        return this;
    }

    public android.support.v7.view.ViewPropertyAnimatorCompatSet setListener(android.support.v4.view.ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (!this.mIsStarted) {
            this.mListener = viewPropertyAnimatorListener;
        }
        return this;
    }

    public void start() {
        if (this.mIsStarted) {
            return;
        }
        for (android.support.v4.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat : this.mAnimators) {
            long j = this.mDuration;
            if (j >= 0) {
                viewPropertyAnimatorCompat.setDuration(j);
            }
            android.view.animation.Interpolator interpolator = this.mInterpolator;
            if (interpolator != null) {
                viewPropertyAnimatorCompat.setInterpolator(interpolator);
            }
            if (this.mListener != null) {
                viewPropertyAnimatorCompat.setListener(this.mProxyListener);
            }
            viewPropertyAnimatorCompat.start();
        }
        this.mIsStarted = true;
    }
}
