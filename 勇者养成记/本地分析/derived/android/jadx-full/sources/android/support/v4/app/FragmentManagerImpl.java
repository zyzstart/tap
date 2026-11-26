package android.support.v4.app;

/* JADX INFO: compiled from: FragmentManager.java */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class FragmentManagerImpl extends android.support.v4.app.FragmentManager implements android.view.LayoutInflater.Factory2 {
    static final int ANIM_DUR = 220;
    public static final int ANIM_STYLE_CLOSE_ENTER = 3;
    public static final int ANIM_STYLE_CLOSE_EXIT = 4;
    public static final int ANIM_STYLE_FADE_ENTER = 5;
    public static final int ANIM_STYLE_FADE_EXIT = 6;
    public static final int ANIM_STYLE_OPEN_ENTER = 1;
    public static final int ANIM_STYLE_OPEN_EXIT = 2;
    static boolean DEBUG = false;
    static final java.lang.String TAG = "FragmentManager";
    static final java.lang.String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
    static final java.lang.String TARGET_STATE_TAG = "android:target_state";
    static final java.lang.String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
    static final java.lang.String VIEW_STATE_TAG = "android:view_state";
    static java.lang.reflect.Field sAnimationListenerField;
    android.util.SparseArray<android.support.v4.app.Fragment> mActive;
    java.util.ArrayList<java.lang.Integer> mAvailBackStackIndices;
    java.util.ArrayList<android.support.v4.app.BackStackRecord> mBackStack;
    java.util.ArrayList<android.support.v4.app.FragmentManager.OnBackStackChangedListener> mBackStackChangeListeners;
    java.util.ArrayList<android.support.v4.app.BackStackRecord> mBackStackIndices;
    android.support.v4.app.FragmentContainer mContainer;
    java.util.ArrayList<android.support.v4.app.Fragment> mCreatedMenus;
    boolean mDestroyed;
    boolean mExecutingActions;
    boolean mHavePendingDeferredStart;
    android.support.v4.app.FragmentHostCallback mHost;
    boolean mNeedMenuInvalidate;
    java.lang.String mNoTransactionsBecause;
    android.support.v4.app.Fragment mParent;
    java.util.ArrayList<android.support.v4.app.FragmentManagerImpl.OpGenerator> mPendingActions;
    java.util.ArrayList<android.support.v4.app.FragmentManagerImpl.StartEnterTransitionListener> mPostponedTransactions;
    android.support.v4.app.Fragment mPrimaryNav;
    android.support.v4.app.FragmentManagerNonConfig mSavedNonConfig;
    boolean mStateSaved;
    java.util.ArrayList<android.support.v4.app.Fragment> mTmpAddedFragments;
    java.util.ArrayList<java.lang.Boolean> mTmpIsPop;
    java.util.ArrayList<android.support.v4.app.BackStackRecord> mTmpRecords;
    static final android.view.animation.Interpolator DECELERATE_QUINT = new android.view.animation.DecelerateInterpolator(2.5f);
    static final android.view.animation.Interpolator DECELERATE_CUBIC = new android.view.animation.DecelerateInterpolator(1.5f);
    static final android.view.animation.Interpolator ACCELERATE_QUINT = new android.view.animation.AccelerateInterpolator(2.5f);
    static final android.view.animation.Interpolator ACCELERATE_CUBIC = new android.view.animation.AccelerateInterpolator(1.5f);
    int mNextFragmentIndex = 0;
    final java.util.ArrayList<android.support.v4.app.Fragment> mAdded = new java.util.ArrayList<>();
    private final java.util.concurrent.CopyOnWriteArrayList<android.support.v4.util.Pair<android.support.v4.app.FragmentManager.FragmentLifecycleCallbacks, java.lang.Boolean>> mLifecycleCallbacks = new java.util.concurrent.CopyOnWriteArrayList<>();
    int mCurState = 0;
    android.os.Bundle mStateBundle = null;
    android.util.SparseArray<android.os.Parcelable> mStateArray = null;
    java.lang.Runnable mExecCommit = new java.lang.Runnable() { // from class: android.support.v4.app.FragmentManagerImpl.1
        @Override // java.lang.Runnable
        public void run() {
            android.support.v4.app.FragmentManagerImpl.this.execPendingActions();
        }
    };

    /* JADX INFO: compiled from: FragmentManager.java */
    private static class AnimateOnHWLayerIfNeededListener extends android.support.v4.app.FragmentManagerImpl.AnimationListenerWrapper {
        android.view.View mView;

        AnimateOnHWLayerIfNeededListener(android.view.View view, android.view.animation.Animation.AnimationListener animationListener) {
            super(animationListener);
            this.mView = view;
        }

        @Override // android.support.v4.app.FragmentManagerImpl.AnimationListenerWrapper, android.view.animation.Animation.AnimationListener
        @android.support.annotation.CallSuper
        public void onAnimationEnd(android.view.animation.Animation animation) {
            if (android.support.v4.view.ViewCompat.isAttachedToWindow(this.mView) || android.os.Build.VERSION.SDK_INT >= 24) {
                this.mView.post(new java.lang.Runnable() { // from class: android.support.v4.app.FragmentManagerImpl.AnimateOnHWLayerIfNeededListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        android.support.v4.app.FragmentManagerImpl.AnimateOnHWLayerIfNeededListener.this.mView.setLayerType(0, null);
                    }
                });
            } else {
                this.mView.setLayerType(0, null);
            }
            super.onAnimationEnd(animation);
        }
    }

    /* JADX INFO: compiled from: FragmentManager.java */
    private static class AnimationListenerWrapper implements android.view.animation.Animation.AnimationListener {
        private final android.view.animation.Animation.AnimationListener mWrapped;

        private AnimationListenerWrapper(android.view.animation.Animation.AnimationListener animationListener) {
            this.mWrapped = animationListener;
        }

        @Override // android.view.animation.Animation.AnimationListener
        @android.support.annotation.CallSuper
        public void onAnimationEnd(android.view.animation.Animation animation) {
            android.view.animation.Animation.AnimationListener animationListener = this.mWrapped;
            if (animationListener != null) {
                animationListener.onAnimationEnd(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        @android.support.annotation.CallSuper
        public void onAnimationRepeat(android.view.animation.Animation animation) {
            android.view.animation.Animation.AnimationListener animationListener = this.mWrapped;
            if (animationListener != null) {
                animationListener.onAnimationRepeat(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        @android.support.annotation.CallSuper
        public void onAnimationStart(android.view.animation.Animation animation) {
            android.view.animation.Animation.AnimationListener animationListener = this.mWrapped;
            if (animationListener != null) {
                animationListener.onAnimationStart(animation);
            }
        }
    }

    /* JADX INFO: compiled from: FragmentManager.java */
    private static class AnimationOrAnimator {
        public final android.view.animation.Animation animation;
        public final android.animation.Animator animator;

        private AnimationOrAnimator(android.animation.Animator animator) {
            this.animation = null;
            this.animator = animator;
            if (animator == null) {
                throw new java.lang.IllegalStateException("Animator cannot be null");
            }
        }

        private AnimationOrAnimator(android.view.animation.Animation animation) {
            this.animation = animation;
            this.animator = null;
            if (animation == null) {
                throw new java.lang.IllegalStateException("Animation cannot be null");
            }
        }
    }

    /* JADX INFO: compiled from: FragmentManager.java */
    private static class AnimatorOnHWLayerIfNeededListener extends android.animation.AnimatorListenerAdapter {
        android.view.View mView;

        AnimatorOnHWLayerIfNeededListener(android.view.View view) {
            this.mView = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            this.mView.setLayerType(0, null);
            animator.removeListener(this);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(android.animation.Animator animator) {
            this.mView.setLayerType(2, null);
        }
    }

    /* JADX INFO: compiled from: FragmentManager.java */
    static class FragmentTag {
        public static final int[] Fragment = {android.R.attr.name, android.R.attr.id, android.R.attr.tag};
        public static final int Fragment_id = 1;
        public static final int Fragment_name = 0;
        public static final int Fragment_tag = 2;

        FragmentTag() {
        }
    }

    /* JADX INFO: compiled from: FragmentManager.java */
    interface OpGenerator {
        boolean generateOps(java.util.ArrayList<android.support.v4.app.BackStackRecord> arrayList, java.util.ArrayList<java.lang.Boolean> arrayList2);
    }

    /* JADX INFO: compiled from: FragmentManager.java */
    private class PopBackStackState implements android.support.v4.app.FragmentManagerImpl.OpGenerator {
        final int mFlags;
        final int mId;
        final java.lang.String mName;

        PopBackStackState(java.lang.String str, int i, int i2) {
            this.mName = str;
            this.mId = i;
            this.mFlags = i2;
        }

        @Override // android.support.v4.app.FragmentManagerImpl.OpGenerator
        public boolean generateOps(java.util.ArrayList<android.support.v4.app.BackStackRecord> arrayList, java.util.ArrayList<java.lang.Boolean> arrayList2) {
            android.support.v4.app.FragmentManager fragmentManagerPeekChildFragmentManager;
            if (android.support.v4.app.FragmentManagerImpl.this.mPrimaryNav == null || this.mId >= 0 || this.mName != null || (fragmentManagerPeekChildFragmentManager = android.support.v4.app.FragmentManagerImpl.this.mPrimaryNav.peekChildFragmentManager()) == null || !fragmentManagerPeekChildFragmentManager.popBackStackImmediate()) {
                return android.support.v4.app.FragmentManagerImpl.this.popBackStackState(arrayList, arrayList2, this.mName, this.mId, this.mFlags);
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: FragmentManager.java */
    static class StartEnterTransitionListener implements android.support.v4.app.Fragment.OnStartEnterTransitionListener {
        private final boolean mIsBack;
        private int mNumPostponed;
        private final android.support.v4.app.BackStackRecord mRecord;

        StartEnterTransitionListener(android.support.v4.app.BackStackRecord backStackRecord, boolean z) {
            this.mIsBack = z;
            this.mRecord = backStackRecord;
        }

        public void cancelTransaction() {
            this.mRecord.mManager.completeExecute(this.mRecord, this.mIsBack, false, false);
        }

        public void completeTransaction() {
            boolean z = this.mNumPostponed > 0;
            android.support.v4.app.FragmentManagerImpl fragmentManagerImpl = this.mRecord.mManager;
            int size = fragmentManagerImpl.mAdded.size();
            for (int i = 0; i < size; i++) {
                android.support.v4.app.Fragment fragment = fragmentManagerImpl.mAdded.get(i);
                fragment.setOnStartEnterTransitionListener(null);
                if (z && fragment.isPostponed()) {
                    fragment.startPostponedEnterTransition();
                }
            }
            this.mRecord.mManager.completeExecute(this.mRecord, this.mIsBack, !z, true);
        }

        public boolean isReady() {
            return this.mNumPostponed == 0;
        }

        @Override // android.support.v4.app.Fragment.OnStartEnterTransitionListener
        public void onStartEnterTransition() {
            this.mNumPostponed--;
            if (this.mNumPostponed != 0) {
                return;
            }
            this.mRecord.mManager.scheduleCommit();
        }

        @Override // android.support.v4.app.Fragment.OnStartEnterTransitionListener
        public void startListening() {
            this.mNumPostponed++;
        }
    }

    FragmentManagerImpl() {
    }

    private void addAddedFragments(android.support.v4.util.ArraySet<android.support.v4.app.Fragment> arraySet) {
        int i = this.mCurState;
        if (i < 1) {
            return;
        }
        int iMin = java.lang.Math.min(i, 4);
        int size = this.mAdded.size();
        for (int i2 = 0; i2 < size; i2++) {
            android.support.v4.app.Fragment fragment = this.mAdded.get(i2);
            if (fragment.mState < iMin) {
                moveToState(fragment, iMin, fragment.getNextAnim(), fragment.getNextTransition(), false);
                if (fragment.mView != null && !fragment.mHidden && fragment.mIsNewlyAdded) {
                    arraySet.add(fragment);
                }
            }
        }
    }

    private void animateRemoveFragment(@android.support.annotation.NonNull final android.support.v4.app.Fragment fragment, @android.support.annotation.NonNull android.support.v4.app.FragmentManagerImpl.AnimationOrAnimator animationOrAnimator, int i) {
        final android.view.View view = fragment.mView;
        fragment.setStateAfterAnimating(i);
        if (animationOrAnimator.animation != null) {
            android.view.animation.Animation animation = animationOrAnimator.animation;
            fragment.setAnimatingAway(fragment.mView);
            animation.setAnimationListener(new android.support.v4.app.FragmentManagerImpl.AnimationListenerWrapper(getAnimationListener(animation)) { // from class: android.support.v4.app.FragmentManagerImpl.2
                @Override // android.support.v4.app.FragmentManagerImpl.AnimationListenerWrapper, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(android.view.animation.Animation animation2) {
                    super.onAnimationEnd(animation2);
                    if (fragment.getAnimatingAway() != null) {
                        fragment.setAnimatingAway(null);
                        android.support.v4.app.FragmentManagerImpl fragmentManagerImpl = android.support.v4.app.FragmentManagerImpl.this;
                        android.support.v4.app.Fragment fragment2 = fragment;
                        fragmentManagerImpl.moveToState(fragment2, fragment2.getStateAfterAnimating(), 0, 0, false);
                    }
                }
            });
            setHWLayerAnimListenerIfAlpha(view, animationOrAnimator);
            fragment.mView.startAnimation(animation);
            return;
        }
        android.animation.Animator animator = animationOrAnimator.animator;
        fragment.setAnimator(animationOrAnimator.animator);
        final android.view.ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            viewGroup.startViewTransition(view);
        }
        animator.addListener(new android.animation.AnimatorListenerAdapter() { // from class: android.support.v4.app.FragmentManagerImpl.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator2) {
                android.view.ViewGroup viewGroup2 = viewGroup;
                if (viewGroup2 != null) {
                    viewGroup2.endViewTransition(view);
                }
                if (fragment.getAnimator() != null) {
                    fragment.setAnimator(null);
                    android.support.v4.app.FragmentManagerImpl fragmentManagerImpl = android.support.v4.app.FragmentManagerImpl.this;
                    android.support.v4.app.Fragment fragment2 = fragment;
                    fragmentManagerImpl.moveToState(fragment2, fragment2.getStateAfterAnimating(), 0, 0, false);
                }
            }
        });
        animator.setTarget(fragment.mView);
        setHWLayerAnimListenerIfAlpha(fragment.mView, animationOrAnimator);
        animator.start();
    }

    private void burpActive() {
        android.util.SparseArray<android.support.v4.app.Fragment> sparseArray = this.mActive;
        if (sparseArray != null) {
            for (int size = sparseArray.size() - 1; size >= 0; size--) {
                if (this.mActive.valueAt(size) == null) {
                    android.util.SparseArray<android.support.v4.app.Fragment> sparseArray2 = this.mActive;
                    sparseArray2.delete(sparseArray2.keyAt(size));
                }
            }
        }
    }

    private void checkStateLoss() {
        if (this.mStateSaved) {
            throw new java.lang.IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.mNoTransactionsBecause == null) {
            return;
        }
        throw new java.lang.IllegalStateException("Can not perform this action inside of " + this.mNoTransactionsBecause);
    }

    private void cleanupExec() {
        this.mExecutingActions = false;
        this.mTmpIsPop.clear();
        this.mTmpRecords.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void completeExecute(android.support.v4.app.BackStackRecord backStackRecord, boolean z, boolean z2, boolean z3) {
        if (z) {
            backStackRecord.executePopOps(z3);
        } else {
            backStackRecord.executeOps();
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(1);
        java.util.ArrayList arrayList2 = new java.util.ArrayList(1);
        arrayList.add(backStackRecord);
        arrayList2.add(java.lang.Boolean.valueOf(z));
        if (z2) {
            android.support.v4.app.FragmentTransition.startTransitions(this, arrayList, arrayList2, 0, 1, true);
        }
        if (z3) {
            moveToState(this.mCurState, true);
        }
        android.util.SparseArray<android.support.v4.app.Fragment> sparseArray = this.mActive;
        if (sparseArray != null) {
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
                android.support.v4.app.Fragment fragmentValueAt = this.mActive.valueAt(i);
                if (fragmentValueAt != null && fragmentValueAt.mView != null && fragmentValueAt.mIsNewlyAdded && backStackRecord.interactsWith(fragmentValueAt.mContainerId)) {
                    if (fragmentValueAt.mPostponedAlpha > 0.0f) {
                        fragmentValueAt.mView.setAlpha(fragmentValueAt.mPostponedAlpha);
                    }
                    if (z3) {
                        fragmentValueAt.mPostponedAlpha = 0.0f;
                    } else {
                        fragmentValueAt.mPostponedAlpha = -1.0f;
                        fragmentValueAt.mIsNewlyAdded = false;
                    }
                }
            }
        }
    }

    private void dispatchStateChange(int i) {
        try {
            this.mExecutingActions = true;
            moveToState(i, false);
            this.mExecutingActions = false;
            execPendingActions();
        } catch (java.lang.Throwable th) {
            this.mExecutingActions = false;
            throw th;
        }
    }

    private void endAnimatingAwayFragments() {
        android.util.SparseArray<android.support.v4.app.Fragment> sparseArray = this.mActive;
        int size = sparseArray == null ? 0 : sparseArray.size();
        for (int i = 0; i < size; i++) {
            android.support.v4.app.Fragment fragmentValueAt = this.mActive.valueAt(i);
            if (fragmentValueAt != null) {
                if (fragmentValueAt.getAnimatingAway() != null) {
                    int stateAfterAnimating = fragmentValueAt.getStateAfterAnimating();
                    android.view.View animatingAway = fragmentValueAt.getAnimatingAway();
                    fragmentValueAt.setAnimatingAway(null);
                    android.view.animation.Animation animation = animatingAway.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        animatingAway.clearAnimation();
                    }
                    moveToState(fragmentValueAt, stateAfterAnimating, 0, 0, false);
                } else if (fragmentValueAt.getAnimator() != null) {
                    fragmentValueAt.getAnimator().end();
                }
            }
        }
    }

    private void ensureExecReady(boolean z) {
        if (this.mExecutingActions) {
            throw new java.lang.IllegalStateException("FragmentManager is already executing transactions");
        }
        if (android.os.Looper.myLooper() != this.mHost.getHandler().getLooper()) {
            throw new java.lang.IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z) {
            checkStateLoss();
        }
        if (this.mTmpRecords == null) {
            this.mTmpRecords = new java.util.ArrayList<>();
            this.mTmpIsPop = new java.util.ArrayList<>();
        }
        this.mExecutingActions = true;
        try {
            executePostponedTransaction(null, null);
        } finally {
            this.mExecutingActions = false;
        }
    }

    private static void executeOps(java.util.ArrayList<android.support.v4.app.BackStackRecord> arrayList, java.util.ArrayList<java.lang.Boolean> arrayList2, int i, int i2) {
        while (i < i2) {
            android.support.v4.app.BackStackRecord backStackRecord = arrayList.get(i);
            if (arrayList2.get(i).booleanValue()) {
                backStackRecord.bumpBackStackNesting(-1);
                backStackRecord.executePopOps(i == i2 + (-1));
            } else {
                backStackRecord.bumpBackStackNesting(1);
                backStackRecord.executeOps();
            }
            i++;
        }
    }

    private void executeOpsTogether(java.util.ArrayList<android.support.v4.app.BackStackRecord> arrayList, java.util.ArrayList<java.lang.Boolean> arrayList2, int i, int i2) {
        int i3;
        int i4 = i;
        boolean z = arrayList.get(i4).mReorderingAllowed;
        java.util.ArrayList<android.support.v4.app.Fragment> arrayList3 = this.mTmpAddedFragments;
        if (arrayList3 == null) {
            this.mTmpAddedFragments = new java.util.ArrayList<>();
        } else {
            arrayList3.clear();
        }
        this.mTmpAddedFragments.addAll(this.mAdded);
        android.support.v4.app.Fragment primaryNavigationFragment = getPrimaryNavigationFragment();
        boolean z2 = false;
        for (int i5 = i4; i5 < i2; i5++) {
            android.support.v4.app.BackStackRecord backStackRecord = arrayList.get(i5);
            primaryNavigationFragment = !arrayList2.get(i5).booleanValue() ? backStackRecord.expandOps(this.mTmpAddedFragments, primaryNavigationFragment) : backStackRecord.trackAddedFragmentsInPop(this.mTmpAddedFragments, primaryNavigationFragment);
            z2 = z2 || backStackRecord.mAddToBackStack;
        }
        this.mTmpAddedFragments.clear();
        if (!z) {
            android.support.v4.app.FragmentTransition.startTransitions(this, arrayList, arrayList2, i, i2, false);
        }
        executeOps(arrayList, arrayList2, i, i2);
        if (z) {
            android.support.v4.util.ArraySet<android.support.v4.app.Fragment> arraySet = new android.support.v4.util.ArraySet<>();
            addAddedFragments(arraySet);
            int iPostponePostponableTransactions = postponePostponableTransactions(arrayList, arrayList2, i, i2, arraySet);
            makeRemovedFragmentsInvisible(arraySet);
            i3 = iPostponePostponableTransactions;
        } else {
            i3 = i2;
        }
        if (i3 != i4 && z) {
            android.support.v4.app.FragmentTransition.startTransitions(this, arrayList, arrayList2, i, i3, true);
            moveToState(this.mCurState, true);
        }
        while (i4 < i2) {
            android.support.v4.app.BackStackRecord backStackRecord2 = arrayList.get(i4);
            if (arrayList2.get(i4).booleanValue() && backStackRecord2.mIndex >= 0) {
                freeBackStackIndex(backStackRecord2.mIndex);
                backStackRecord2.mIndex = -1;
            }
            backStackRecord2.runOnCommitRunnables();
            i4++;
        }
        if (z2) {
            reportBackStackChanged();
        }
    }

    private void executePostponedTransaction(java.util.ArrayList<android.support.v4.app.BackStackRecord> arrayList, java.util.ArrayList<java.lang.Boolean> arrayList2) {
        int iIndexOf;
        int iIndexOf2;
        java.util.ArrayList<android.support.v4.app.FragmentManagerImpl.StartEnterTransitionListener> arrayList3 = this.mPostponedTransactions;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i = 0;
        while (i < size) {
            android.support.v4.app.FragmentManagerImpl.StartEnterTransitionListener startEnterTransitionListener = this.mPostponedTransactions.get(i);
            if (arrayList != null && !startEnterTransitionListener.mIsBack && (iIndexOf2 = arrayList.indexOf(startEnterTransitionListener.mRecord)) != -1 && arrayList2.get(iIndexOf2).booleanValue()) {
                startEnterTransitionListener.cancelTransaction();
            } else if (startEnterTransitionListener.isReady() || (arrayList != null && startEnterTransitionListener.mRecord.interactsWith(arrayList, 0, arrayList.size()))) {
                this.mPostponedTransactions.remove(i);
                i--;
                size--;
                if (arrayList == null || startEnterTransitionListener.mIsBack || (iIndexOf = arrayList.indexOf(startEnterTransitionListener.mRecord)) == -1 || !arrayList2.get(iIndexOf).booleanValue()) {
                    startEnterTransitionListener.completeTransaction();
                } else {
                    startEnterTransitionListener.cancelTransaction();
                }
            }
            i++;
        }
    }

    private android.support.v4.app.Fragment findFragmentUnder(android.support.v4.app.Fragment fragment) {
        android.view.ViewGroup viewGroup = fragment.mContainer;
        android.view.View view = fragment.mView;
        if (viewGroup == null || view == null) {
            return null;
        }
        for (int iIndexOf = this.mAdded.indexOf(fragment) - 1; iIndexOf >= 0; iIndexOf--) {
            android.support.v4.app.Fragment fragment2 = this.mAdded.get(iIndexOf);
            if (fragment2.mContainer == viewGroup && fragment2.mView != null) {
                return fragment2;
            }
        }
        return null;
    }

    private void forcePostponedTransactions() {
        if (this.mPostponedTransactions != null) {
            while (!this.mPostponedTransactions.isEmpty()) {
                this.mPostponedTransactions.remove(0).completeTransaction();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean generateOpsForPendingActions(java.util.ArrayList<android.support.v4.app.BackStackRecord> arrayList, java.util.ArrayList<java.lang.Boolean> arrayList2) {
        synchronized (this) {
            if (this.mPendingActions != null && this.mPendingActions.size() != 0) {
                int size = this.mPendingActions.size();
                boolean zGenerateOps = false;
                for (int i = 0; i < size; i++) {
                    zGenerateOps |= this.mPendingActions.get(i).generateOps(arrayList, arrayList2);
                }
                this.mPendingActions.clear();
                this.mHost.getHandler().removeCallbacks(this.mExecCommit);
                return zGenerateOps;
            }
            return false;
        }
    }

    private static android.view.animation.Animation.AnimationListener getAnimationListener(android.view.animation.Animation animation) {
        try {
            if (sAnimationListenerField == null) {
                sAnimationListenerField = android.view.animation.Animation.class.getDeclaredField("mListener");
                sAnimationListenerField.setAccessible(true);
            }
            return (android.view.animation.Animation.AnimationListener) sAnimationListenerField.get(animation);
        } catch (java.lang.IllegalAccessException e) {
            android.util.Log.e(TAG, "Cannot access Animation's mListener field", e);
            return null;
        } catch (java.lang.NoSuchFieldException e2) {
            android.util.Log.e(TAG, "No field with the name mListener is found in Animation class", e2);
            return null;
        }
    }

    static android.support.v4.app.FragmentManagerImpl.AnimationOrAnimator makeFadeAnimation(android.content.Context context, float f, float f2) {
        android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(DECELERATE_CUBIC);
        alphaAnimation.setDuration(220L);
        return new android.support.v4.app.FragmentManagerImpl.AnimationOrAnimator(alphaAnimation);
    }

    static android.support.v4.app.FragmentManagerImpl.AnimationOrAnimator makeOpenCloseAnimation(android.content.Context context, float f, float f2, float f3, float f4) {
        android.view.animation.AnimationSet animationSet = new android.view.animation.AnimationSet(false);
        android.view.animation.ScaleAnimation scaleAnimation = new android.view.animation.ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(DECELERATE_QUINT);
        scaleAnimation.setDuration(220L);
        animationSet.addAnimation(scaleAnimation);
        android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(f3, f4);
        alphaAnimation.setInterpolator(DECELERATE_CUBIC);
        alphaAnimation.setDuration(220L);
        animationSet.addAnimation(alphaAnimation);
        return new android.support.v4.app.FragmentManagerImpl.AnimationOrAnimator(animationSet);
    }

    private void makeRemovedFragmentsInvisible(android.support.v4.util.ArraySet<android.support.v4.app.Fragment> arraySet) {
        int size = arraySet.size();
        for (int i = 0; i < size; i++) {
            android.support.v4.app.Fragment fragmentValueAt = arraySet.valueAt(i);
            if (!fragmentValueAt.mAdded) {
                android.view.View view = fragmentValueAt.getView();
                fragmentValueAt.mPostponedAlpha = view.getAlpha();
                view.setAlpha(0.0f);
            }
        }
    }

    static boolean modifiesAlpha(android.animation.Animator animator) {
        if (animator == null) {
            return false;
        }
        if (animator instanceof android.animation.ValueAnimator) {
            for (android.animation.PropertyValuesHolder propertyValuesHolder : ((android.animation.ValueAnimator) animator).getValues()) {
                if ("alpha".equals(propertyValuesHolder.getPropertyName())) {
                    return true;
                }
            }
        } else if (animator instanceof android.animation.AnimatorSet) {
            java.util.ArrayList<android.animation.Animator> childAnimations = ((android.animation.AnimatorSet) animator).getChildAnimations();
            for (int i = 0; i < childAnimations.size(); i++) {
                if (modifiesAlpha(childAnimations.get(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean modifiesAlpha(android.support.v4.app.FragmentManagerImpl.AnimationOrAnimator animationOrAnimator) {
        if (animationOrAnimator.animation instanceof android.view.animation.AlphaAnimation) {
            return true;
        }
        if (!(animationOrAnimator.animation instanceof android.view.animation.AnimationSet)) {
            return modifiesAlpha(animationOrAnimator.animator);
        }
        java.util.List<android.view.animation.Animation> animations = ((android.view.animation.AnimationSet) animationOrAnimator.animation).getAnimations();
        for (int i = 0; i < animations.size(); i++) {
            if (animations.get(i) instanceof android.view.animation.AlphaAnimation) {
                return true;
            }
        }
        return false;
    }

    private boolean popBackStackImmediate(java.lang.String str, int i, int i2) {
        android.support.v4.app.FragmentManager fragmentManagerPeekChildFragmentManager;
        execPendingActions();
        ensureExecReady(true);
        android.support.v4.app.Fragment fragment = this.mPrimaryNav;
        if (fragment != null && i < 0 && str == null && (fragmentManagerPeekChildFragmentManager = fragment.peekChildFragmentManager()) != null && fragmentManagerPeekChildFragmentManager.popBackStackImmediate()) {
            return true;
        }
        boolean zPopBackStackState = popBackStackState(this.mTmpRecords, this.mTmpIsPop, str, i, i2);
        if (zPopBackStackState) {
            this.mExecutingActions = true;
            try {
                removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
                cleanupExec();
            } catch (java.lang.Throwable th) {
                cleanupExec();
                throw th;
            }
        }
        doPendingDeferredStart();
        burpActive();
        return zPopBackStackState;
    }

    private int postponePostponableTransactions(java.util.ArrayList<android.support.v4.app.BackStackRecord> arrayList, java.util.ArrayList<java.lang.Boolean> arrayList2, int i, int i2, android.support.v4.util.ArraySet<android.support.v4.app.Fragment> arraySet) {
        int i3 = i2;
        for (int i4 = i2 - 1; i4 >= i; i4--) {
            android.support.v4.app.BackStackRecord backStackRecord = arrayList.get(i4);
            boolean zBooleanValue = arrayList2.get(i4).booleanValue();
            if (backStackRecord.isPostponed() && !backStackRecord.interactsWith(arrayList, i4 + 1, i2)) {
                if (this.mPostponedTransactions == null) {
                    this.mPostponedTransactions = new java.util.ArrayList<>();
                }
                android.support.v4.app.FragmentManagerImpl.StartEnterTransitionListener startEnterTransitionListener = new android.support.v4.app.FragmentManagerImpl.StartEnterTransitionListener(backStackRecord, zBooleanValue);
                this.mPostponedTransactions.add(startEnterTransitionListener);
                backStackRecord.setOnStartPostponedListener(startEnterTransitionListener);
                if (zBooleanValue) {
                    backStackRecord.executeOps();
                } else {
                    backStackRecord.executePopOps(false);
                }
                i3--;
                if (i4 != i3) {
                    arrayList.remove(i4);
                    arrayList.add(i3, backStackRecord);
                }
                addAddedFragments(arraySet);
            }
        }
        return i3;
    }

    private void removeRedundantOperationsAndExecute(java.util.ArrayList<android.support.v4.app.BackStackRecord> arrayList, java.util.ArrayList<java.lang.Boolean> arrayList2) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
            throw new java.lang.IllegalStateException("Internal error with the back stack records");
        }
        executePostponedTransaction(arrayList, arrayList2);
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            if (!arrayList.get(i).mReorderingAllowed) {
                if (i2 != i) {
                    executeOpsTogether(arrayList, arrayList2, i2, i);
                }
                i2 = i + 1;
                if (arrayList2.get(i).booleanValue()) {
                    while (i2 < size && arrayList2.get(i2).booleanValue() && !arrayList.get(i2).mReorderingAllowed) {
                        i2++;
                    }
                }
                executeOpsTogether(arrayList, arrayList2, i, i2);
                i = i2 - 1;
            }
            i++;
        }
        if (i2 != size) {
            executeOpsTogether(arrayList, arrayList2, i2, size);
        }
    }

    public static int reverseTransit(int i) {
        if (i == 4097) {
            return 8194;
        }
        if (i == 4099) {
            return android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE;
        }
        if (i != 8194) {
            return 0;
        }
        return android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleCommit() {
        synchronized (this) {
            boolean z = false;
            boolean z2 = (this.mPostponedTransactions == null || this.mPostponedTransactions.isEmpty()) ? false : true;
            if (this.mPendingActions != null && this.mPendingActions.size() == 1) {
                z = true;
            }
            if (z2 || z) {
                this.mHost.getHandler().removeCallbacks(this.mExecCommit);
                this.mHost.getHandler().post(this.mExecCommit);
            }
        }
    }

    private static void setHWLayerAnimListenerIfAlpha(android.view.View view, android.support.v4.app.FragmentManagerImpl.AnimationOrAnimator animationOrAnimator) {
        if (view == null || animationOrAnimator == null || !shouldRunOnHWLayer(view, animationOrAnimator)) {
            return;
        }
        if (animationOrAnimator.animator != null) {
            animationOrAnimator.animator.addListener(new android.support.v4.app.FragmentManagerImpl.AnimatorOnHWLayerIfNeededListener(view));
            return;
        }
        android.view.animation.Animation.AnimationListener animationListener = getAnimationListener(animationOrAnimator.animation);
        view.setLayerType(2, null);
        animationOrAnimator.animation.setAnimationListener(new android.support.v4.app.FragmentManagerImpl.AnimateOnHWLayerIfNeededListener(view, animationListener));
    }

    private static void setRetaining(android.support.v4.app.FragmentManagerNonConfig fragmentManagerNonConfig) {
        if (fragmentManagerNonConfig == null) {
            return;
        }
        java.util.List<android.support.v4.app.Fragment> fragments = fragmentManagerNonConfig.getFragments();
        if (fragments != null) {
            java.util.Iterator<android.support.v4.app.Fragment> it = fragments.iterator();
            while (it.hasNext()) {
                it.next().mRetaining = true;
            }
        }
        java.util.List<android.support.v4.app.FragmentManagerNonConfig> childNonConfigs = fragmentManagerNonConfig.getChildNonConfigs();
        if (childNonConfigs != null) {
            java.util.Iterator<android.support.v4.app.FragmentManagerNonConfig> it2 = childNonConfigs.iterator();
            while (it2.hasNext()) {
                setRetaining(it2.next());
            }
        }
    }

    static boolean shouldRunOnHWLayer(android.view.View view, android.support.v4.app.FragmentManagerImpl.AnimationOrAnimator animationOrAnimator) {
        return view != null && animationOrAnimator != null && android.os.Build.VERSION.SDK_INT >= 19 && view.getLayerType() == 0 && android.support.v4.view.ViewCompat.hasOverlappingRendering(view) && modifiesAlpha(animationOrAnimator);
    }

    private void throwException(java.lang.RuntimeException runtimeException) {
        android.util.Log.e(TAG, runtimeException.getMessage());
        android.util.Log.e(TAG, "Activity state:");
        java.io.PrintWriter printWriter = new java.io.PrintWriter(new android.support.v4.util.LogWriter(TAG));
        android.support.v4.app.FragmentHostCallback fragmentHostCallback = this.mHost;
        if (fragmentHostCallback != null) {
            try {
                fragmentHostCallback.onDump("  ", null, printWriter, new java.lang.String[0]);
                throw runtimeException;
            } catch (java.lang.Exception e) {
                android.util.Log.e(TAG, "Failed dumping state", e);
                throw runtimeException;
            }
        }
        try {
            dump("  ", null, printWriter, new java.lang.String[0]);
            throw runtimeException;
        } catch (java.lang.Exception e2) {
            android.util.Log.e(TAG, "Failed dumping state", e2);
            throw runtimeException;
        }
    }

    public static int transitToStyleIndex(int i, boolean z) {
        if (i == 4097) {
            return z ? 1 : 2;
        }
        if (i == 4099) {
            return z ? 5 : 6;
        }
        if (i != 8194) {
            return -1;
        }
        return z ? 3 : 4;
    }

    void addBackStackState(android.support.v4.app.BackStackRecord backStackRecord) {
        if (this.mBackStack == null) {
            this.mBackStack = new java.util.ArrayList<>();
        }
        this.mBackStack.add(backStackRecord);
    }

    public void addFragment(android.support.v4.app.Fragment fragment, boolean z) {
        if (DEBUG) {
            android.util.Log.v(TAG, "add: " + fragment);
        }
        makeActive(fragment);
        if (fragment.mDetached) {
            return;
        }
        if (this.mAdded.contains(fragment)) {
            throw new java.lang.IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.mAdded) {
            this.mAdded.add(fragment);
        }
        fragment.mAdded = true;
        fragment.mRemoving = false;
        if (fragment.mView == null) {
            fragment.mHiddenChanged = false;
        }
        if (fragment.mHasMenu && fragment.mMenuVisible) {
            this.mNeedMenuInvalidate = true;
        }
        if (z) {
            moveToState(fragment);
        }
    }

    @Override // android.support.v4.app.FragmentManager
    public void addOnBackStackChangedListener(android.support.v4.app.FragmentManager.OnBackStackChangedListener onBackStackChangedListener) {
        if (this.mBackStackChangeListeners == null) {
            this.mBackStackChangeListeners = new java.util.ArrayList<>();
        }
        this.mBackStackChangeListeners.add(onBackStackChangedListener);
    }

    public int allocBackStackIndex(android.support.v4.app.BackStackRecord backStackRecord) {
        synchronized (this) {
            if (this.mAvailBackStackIndices != null && this.mAvailBackStackIndices.size() > 0) {
                int iIntValue = this.mAvailBackStackIndices.remove(this.mAvailBackStackIndices.size() - 1).intValue();
                if (DEBUG) {
                    android.util.Log.v(TAG, "Adding back stack index " + iIntValue + " with " + backStackRecord);
                }
                this.mBackStackIndices.set(iIntValue, backStackRecord);
                return iIntValue;
            }
            if (this.mBackStackIndices == null) {
                this.mBackStackIndices = new java.util.ArrayList<>();
            }
            int size = this.mBackStackIndices.size();
            if (DEBUG) {
                android.util.Log.v(TAG, "Setting back stack index " + size + " to " + backStackRecord);
            }
            this.mBackStackIndices.add(backStackRecord);
            return size;
        }
    }

    public void attachController(android.support.v4.app.FragmentHostCallback fragmentHostCallback, android.support.v4.app.FragmentContainer fragmentContainer, android.support.v4.app.Fragment fragment) {
        if (this.mHost != null) {
            throw new java.lang.IllegalStateException("Already attached");
        }
        this.mHost = fragmentHostCallback;
        this.mContainer = fragmentContainer;
        this.mParent = fragment;
    }

    public void attachFragment(android.support.v4.app.Fragment fragment) {
        if (DEBUG) {
            android.util.Log.v(TAG, "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            if (this.mAdded.contains(fragment)) {
                throw new java.lang.IllegalStateException("Fragment already added: " + fragment);
            }
            if (DEBUG) {
                android.util.Log.v(TAG, "add from attach: " + fragment);
            }
            synchronized (this.mAdded) {
                this.mAdded.add(fragment);
            }
            fragment.mAdded = true;
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.mNeedMenuInvalidate = true;
            }
        }
    }

    @Override // android.support.v4.app.FragmentManager
    public android.support.v4.app.FragmentTransaction beginTransaction() {
        return new android.support.v4.app.BackStackRecord(this);
    }

    void completeShowHideFragment(final android.support.v4.app.Fragment fragment) {
        if (fragment.mView != null) {
            android.support.v4.app.FragmentManagerImpl.AnimationOrAnimator animationOrAnimatorLoadAnimation = loadAnimation(fragment, fragment.getNextTransition(), !fragment.mHidden, fragment.getNextTransitionStyle());
            if (animationOrAnimatorLoadAnimation == null || animationOrAnimatorLoadAnimation.animator == null) {
                if (animationOrAnimatorLoadAnimation != null) {
                    setHWLayerAnimListenerIfAlpha(fragment.mView, animationOrAnimatorLoadAnimation);
                    fragment.mView.startAnimation(animationOrAnimatorLoadAnimation.animation);
                    animationOrAnimatorLoadAnimation.animation.start();
                }
                fragment.mView.setVisibility((!fragment.mHidden || fragment.isHideReplaced()) ? 0 : 8);
                if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                }
            } else {
                animationOrAnimatorLoadAnimation.animator.setTarget(fragment.mView);
                if (!fragment.mHidden) {
                    fragment.mView.setVisibility(0);
                } else if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                } else {
                    final android.view.ViewGroup viewGroup = fragment.mContainer;
                    final android.view.View view = fragment.mView;
                    viewGroup.startViewTransition(view);
                    animationOrAnimatorLoadAnimation.animator.addListener(new android.animation.AnimatorListenerAdapter() { // from class: android.support.v4.app.FragmentManagerImpl.4
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(android.animation.Animator animator) {
                            viewGroup.endViewTransition(view);
                            animator.removeListener(this);
                            if (fragment.mView != null) {
                                fragment.mView.setVisibility(8);
                            }
                        }
                    });
                }
                setHWLayerAnimListenerIfAlpha(fragment.mView, animationOrAnimatorLoadAnimation);
                animationOrAnimatorLoadAnimation.animator.start();
            }
        }
        if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible) {
            this.mNeedMenuInvalidate = true;
        }
        fragment.mHiddenChanged = false;
        fragment.onHiddenChanged(fragment.mHidden);
    }

    public void detachFragment(android.support.v4.app.Fragment fragment) {
        if (DEBUG) {
            android.util.Log.v(TAG, "detach: " + fragment);
        }
        if (fragment.mDetached) {
            return;
        }
        fragment.mDetached = true;
        if (fragment.mAdded) {
            if (DEBUG) {
                android.util.Log.v(TAG, "remove from detach: " + fragment);
            }
            synchronized (this.mAdded) {
                this.mAdded.remove(fragment);
            }
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.mNeedMenuInvalidate = true;
            }
            fragment.mAdded = false;
        }
    }

    public void dispatchActivityCreated() {
        this.mStateSaved = false;
        dispatchStateChange(2);
    }

    public void dispatchConfigurationChanged(android.content.res.Configuration configuration) {
        for (int i = 0; i < this.mAdded.size(); i++) {
            android.support.v4.app.Fragment fragment = this.mAdded.get(i);
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
            }
        }
    }

    public boolean dispatchContextItemSelected(android.view.MenuItem menuItem) {
        for (int i = 0; i < this.mAdded.size(); i++) {
            android.support.v4.app.Fragment fragment = this.mAdded.get(i);
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void dispatchCreate() {
        this.mStateSaved = false;
        dispatchStateChange(1);
    }

    public boolean dispatchCreateOptionsMenu(android.view.Menu menu, android.view.MenuInflater menuInflater) {
        java.util.ArrayList<android.support.v4.app.Fragment> arrayList = null;
        boolean z = false;
        for (int i = 0; i < this.mAdded.size(); i++) {
            android.support.v4.app.Fragment fragment = this.mAdded.get(i);
            if (fragment != null && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new java.util.ArrayList<>();
                }
                arrayList.add(fragment);
                z = true;
            }
        }
        if (this.mCreatedMenus != null) {
            for (int i2 = 0; i2 < this.mCreatedMenus.size(); i2++) {
                android.support.v4.app.Fragment fragment2 = this.mCreatedMenus.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.mCreatedMenus = arrayList;
        return z;
    }

    public void dispatchDestroy() {
        this.mDestroyed = true;
        execPendingActions();
        dispatchStateChange(0);
        this.mHost = null;
        this.mContainer = null;
        this.mParent = null;
    }

    public void dispatchDestroyView() {
        dispatchStateChange(1);
    }

    public void dispatchLowMemory() {
        for (int i = 0; i < this.mAdded.size(); i++) {
            android.support.v4.app.Fragment fragment = this.mAdded.get(i);
            if (fragment != null) {
                fragment.performLowMemory();
            }
        }
    }

    public void dispatchMultiWindowModeChanged(boolean z) {
        for (int size = this.mAdded.size() - 1; size >= 0; size--) {
            android.support.v4.app.Fragment fragment = this.mAdded.get(size);
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z);
            }
        }
    }

    void dispatchOnFragmentActivityCreated(android.support.v4.app.Fragment fragment, android.os.Bundle bundle, boolean z) {
        android.support.v4.app.Fragment fragment2 = this.mParent;
        if (fragment2 != null) {
            android.support.v4.app.FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof android.support.v4.app.FragmentManagerImpl) {
                ((android.support.v4.app.FragmentManagerImpl) fragmentManager).dispatchOnFragmentActivityCreated(fragment, bundle, true);
            }
        }
        for (android.support.v4.util.Pair<android.support.v4.app.FragmentManager.FragmentLifecycleCallbacks, java.lang.Boolean> pair : this.mLifecycleCallbacks) {
            if (!z || pair.second.booleanValue()) {
                pair.first.onFragmentActivityCreated(this, fragment, bundle);
            }
        }
    }

    void dispatchOnFragmentAttached(android.support.v4.app.Fragment fragment, android.content.Context context, boolean z) {
        android.support.v4.app.Fragment fragment2 = this.mParent;
        if (fragment2 != null) {
            android.support.v4.app.FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof android.support.v4.app.FragmentManagerImpl) {
                ((android.support.v4.app.FragmentManagerImpl) fragmentManager).dispatchOnFragmentAttached(fragment, context, true);
            }
        }
        for (android.support.v4.util.Pair<android.support.v4.app.FragmentManager.FragmentLifecycleCallbacks, java.lang.Boolean> pair : this.mLifecycleCallbacks) {
            if (!z || pair.second.booleanValue()) {
                pair.first.onFragmentAttached(this, fragment, context);
            }
        }
    }

    void dispatchOnFragmentCreated(android.support.v4.app.Fragment fragment, android.os.Bundle bundle, boolean z) {
        android.support.v4.app.Fragment fragment2 = this.mParent;
        if (fragment2 != null) {
            android.support.v4.app.FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof android.support.v4.app.FragmentManagerImpl) {
                ((android.support.v4.app.FragmentManagerImpl) fragmentManager).dispatchOnFragmentCreated(fragment, bundle, true);
            }
        }
        for (android.support.v4.util.Pair<android.support.v4.app.FragmentManager.FragmentLifecycleCallbacks, java.lang.Boolean> pair : this.mLifecycleCallbacks) {
            if (!z || pair.second.booleanValue()) {
                pair.first.onFragmentCreated(this, fragment, bundle);
            }
        }
    }

    void dispatchOnFragmentDestroyed(android.support.v4.app.Fragment fragment, boolean z) {
        android.support.v4.app.Fragment fragment2 = this.mParent;
        if (fragment2 != null) {
            android.support.v4.app.FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof android.support.v4.app.FragmentManagerImpl) {
                ((android.support.v4.app.FragmentManagerImpl) fragmentManager).dispatchOnFragmentDestroyed(fragment, true);
            }
        }
        for (android.support.v4.util.Pair<android.support.v4.app.FragmentManager.FragmentLifecycleCallbacks, java.lang.Boolean> pair : this.mLifecycleCallbacks) {
            if (!z || pair.second.booleanValue()) {
                pair.first.onFragmentDestroyed(this, fragment);
            }
        }
    }

    void dispatchOnFragmentDetached(android.support.v4.app.Fragment fragment, boolean z) {
        android.support.v4.app.Fragment fragment2 = this.mParent;
        if (fragment2 != null) {
            android.support.v4.app.FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof android.support.v4.app.FragmentManagerImpl) {
                ((android.support.v4.app.FragmentManagerImpl) fragmentManager).dispatchOnFragmentDetached(fragment, true);
            }
        }
        for (android.support.v4.util.Pair<android.support.v4.app.FragmentManager.FragmentLifecycleCallbacks, java.lang.Boolean> pair : this.mLifecycleCallbacks) {
            if (!z || pair.second.booleanValue()) {
                pair.first.onFragmentDetached(this, fragment);
            }
        }
    }

    void dispatchOnFragmentPaused(android.support.v4.app.Fragment fragment, boolean z) {
        android.support.v4.app.Fragment fragment2 = this.mParent;
        if (fragment2 != null) {
            android.support.v4.app.FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof android.support.v4.app.FragmentManagerImpl) {
                ((android.support.v4.app.FragmentManagerImpl) fragmentManager).dispatchOnFragmentPaused(fragment, true);
            }
        }
        for (android.support.v4.util.Pair<android.support.v4.app.FragmentManager.FragmentLifecycleCallbacks, java.lang.Boolean> pair : this.mLifecycleCallbacks) {
            if (!z || pair.second.booleanValue()) {
                pair.first.onFragmentPaused(this, fragment);
            }
        }
    }

    void dispatchOnFragmentPreAttached(android.support.v4.app.Fragment fragment, android.content.Context context, boolean z) {
        android.support.v4.app.Fragment fragment2 = this.mParent;
        if (fragment2 != null) {
            android.support.v4.app.FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof android.support.v4.app.FragmentManagerImpl) {
                ((android.support.v4.app.FragmentManagerImpl) fragmentManager).dispatchOnFragmentPreAttached(fragment, context, true);
            }
        }
        for (android.support.v4.util.Pair<android.support.v4.app.FragmentManager.FragmentLifecycleCallbacks, java.lang.Boolean> pair : this.mLifecycleCallbacks) {
            if (!z || pair.second.booleanValue()) {
                pair.first.onFragmentPreAttached(this, fragment, context);
            }
        }
    }

    void dispatchOnFragmentPreCreated(android.support.v4.app.Fragment fragment, android.os.Bundle bundle, boolean z) {
        android.support.v4.app.Fragment fragment2 = this.mParent;
        if (fragment2 != null) {
            android.support.v4.app.FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof android.support.v4.app.FragmentManagerImpl) {
                ((android.support.v4.app.FragmentManagerImpl) fragmentManager).dispatchOnFragmentPreCreated(fragment, bundle, true);
            }
        }
        for (android.support.v4.util.Pair<android.support.v4.app.FragmentManager.FragmentLifecycleCallbacks, java.lang.Boolean> pair : this.mLifecycleCallbacks) {
            if (!z || pair.second.booleanValue()) {
                pair.first.onFragmentPreCreated(this, fragment, bundle);
            }
        }
    }

    void dispatchOnFragmentResumed(android.support.v4.app.Fragment fragment, boolean z) {
        android.support.v4.app.Fragment fragment2 = this.mParent;
        if (fragment2 != null) {
            android.support.v4.app.FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof android.support.v4.app.FragmentManagerImpl) {
                ((android.support.v4.app.FragmentManagerImpl) fragmentManager).dispatchOnFragmentResumed(fragment, true);
            }
        }
        for (android.support.v4.util.Pair<android.support.v4.app.FragmentManager.FragmentLifecycleCallbacks, java.lang.Boolean> pair : this.mLifecycleCallbacks) {
            if (!z || pair.second.booleanValue()) {
                pair.first.onFragmentResumed(this, fragment);
            }
        }
    }

    void dispatchOnFragmentSaveInstanceState(android.support.v4.app.Fragment fragment, android.os.Bundle bundle, boolean z) {
        android.support.v4.app.Fragment fragment2 = this.mParent;
        if (fragment2 != null) {
            android.support.v4.app.FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof android.support.v4.app.FragmentManagerImpl) {
                ((android.support.v4.app.FragmentManagerImpl) fragmentManager).dispatchOnFragmentSaveInstanceState(fragment, bundle, true);
            }
        }
        for (android.support.v4.util.Pair<android.support.v4.app.FragmentManager.FragmentLifecycleCallbacks, java.lang.Boolean> pair : this.mLifecycleCallbacks) {
            if (!z || pair.second.booleanValue()) {
                pair.first.onFragmentSaveInstanceState(this, fragment, bundle);
            }
        }
    }

    void dispatchOnFragmentStarted(android.support.v4.app.Fragment fragment, boolean z) {
        android.support.v4.app.Fragment fragment2 = this.mParent;
        if (fragment2 != null) {
            android.support.v4.app.FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof android.support.v4.app.FragmentManagerImpl) {
                ((android.support.v4.app.FragmentManagerImpl) fragmentManager).dispatchOnFragmentStarted(fragment, true);
            }
        }
        for (android.support.v4.util.Pair<android.support.v4.app.FragmentManager.FragmentLifecycleCallbacks, java.lang.Boolean> pair : this.mLifecycleCallbacks) {
            if (!z || pair.second.booleanValue()) {
                pair.first.onFragmentStarted(this, fragment);
            }
        }
    }

    void dispatchOnFragmentStopped(android.support.v4.app.Fragment fragment, boolean z) {
        android.support.v4.app.Fragment fragment2 = this.mParent;
        if (fragment2 != null) {
            android.support.v4.app.FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof android.support.v4.app.FragmentManagerImpl) {
                ((android.support.v4.app.FragmentManagerImpl) fragmentManager).dispatchOnFragmentStopped(fragment, true);
            }
        }
        for (android.support.v4.util.Pair<android.support.v4.app.FragmentManager.FragmentLifecycleCallbacks, java.lang.Boolean> pair : this.mLifecycleCallbacks) {
            if (!z || pair.second.booleanValue()) {
                pair.first.onFragmentStopped(this, fragment);
            }
        }
    }

    void dispatchOnFragmentViewCreated(android.support.v4.app.Fragment fragment, android.view.View view, android.os.Bundle bundle, boolean z) {
        android.support.v4.app.Fragment fragment2 = this.mParent;
        if (fragment2 != null) {
            android.support.v4.app.FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof android.support.v4.app.FragmentManagerImpl) {
                ((android.support.v4.app.FragmentManagerImpl) fragmentManager).dispatchOnFragmentViewCreated(fragment, view, bundle, true);
            }
        }
        for (android.support.v4.util.Pair<android.support.v4.app.FragmentManager.FragmentLifecycleCallbacks, java.lang.Boolean> pair : this.mLifecycleCallbacks) {
            if (!z || pair.second.booleanValue()) {
                pair.first.onFragmentViewCreated(this, fragment, view, bundle);
            }
        }
    }

    void dispatchOnFragmentViewDestroyed(android.support.v4.app.Fragment fragment, boolean z) {
        android.support.v4.app.Fragment fragment2 = this.mParent;
        if (fragment2 != null) {
            android.support.v4.app.FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof android.support.v4.app.FragmentManagerImpl) {
                ((android.support.v4.app.FragmentManagerImpl) fragmentManager).dispatchOnFragmentViewDestroyed(fragment, true);
            }
        }
        for (android.support.v4.util.Pair<android.support.v4.app.FragmentManager.FragmentLifecycleCallbacks, java.lang.Boolean> pair : this.mLifecycleCallbacks) {
            if (!z || pair.second.booleanValue()) {
                pair.first.onFragmentViewDestroyed(this, fragment);
            }
        }
    }

    public boolean dispatchOptionsItemSelected(android.view.MenuItem menuItem) {
        for (int i = 0; i < this.mAdded.size(); i++) {
            android.support.v4.app.Fragment fragment = this.mAdded.get(i);
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void dispatchOptionsMenuClosed(android.view.Menu menu) {
        for (int i = 0; i < this.mAdded.size(); i++) {
            android.support.v4.app.Fragment fragment = this.mAdded.get(i);
            if (fragment != null) {
                fragment.performOptionsMenuClosed(menu);
            }
        }
    }

    public void dispatchPause() {
        dispatchStateChange(4);
    }

    public void dispatchPictureInPictureModeChanged(boolean z) {
        for (int size = this.mAdded.size() - 1; size >= 0; size--) {
            android.support.v4.app.Fragment fragment = this.mAdded.get(size);
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z);
            }
        }
    }

    public boolean dispatchPrepareOptionsMenu(android.view.Menu menu) {
        boolean z = false;
        for (int i = 0; i < this.mAdded.size(); i++) {
            android.support.v4.app.Fragment fragment = this.mAdded.get(i);
            if (fragment != null && fragment.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    public void dispatchReallyStop() {
        dispatchStateChange(2);
    }

    public void dispatchResume() {
        this.mStateSaved = false;
        dispatchStateChange(5);
    }

    public void dispatchStart() {
        this.mStateSaved = false;
        dispatchStateChange(4);
    }

    public void dispatchStop() {
        this.mStateSaved = true;
        dispatchStateChange(3);
    }

    void doPendingDeferredStart() {
        if (this.mHavePendingDeferredStart) {
            boolean zHasRunningLoaders = false;
            for (int i = 0; i < this.mActive.size(); i++) {
                android.support.v4.app.Fragment fragmentValueAt = this.mActive.valueAt(i);
                if (fragmentValueAt != null && fragmentValueAt.mLoaderManager != null) {
                    zHasRunningLoaders |= fragmentValueAt.mLoaderManager.hasRunningLoaders();
                }
            }
            if (zHasRunningLoaders) {
                return;
            }
            this.mHavePendingDeferredStart = false;
            startPendingDeferredFragments();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.support.v4.app.FragmentManager
    public void dump(java.lang.String str, java.io.FileDescriptor fileDescriptor, java.io.PrintWriter printWriter, java.lang.String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        int size5;
        java.lang.String str2 = str + "    ";
        android.util.SparseArray<android.support.v4.app.Fragment> sparseArray = this.mActive;
        if (sparseArray != null && (size5 = sparseArray.size()) > 0) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(java.lang.Integer.toHexString(java.lang.System.identityHashCode(this)));
            printWriter.println(":");
            for (int i = 0; i < size5; i++) {
                android.support.v4.app.Fragment fragmentValueAt = this.mActive.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(fragmentValueAt);
                if (fragmentValueAt != null) {
                    fragmentValueAt.dump(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        int size6 = this.mAdded.size();
        if (size6 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size6; i2++) {
                android.support.v4.app.Fragment fragment = this.mAdded.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
        java.util.ArrayList<android.support.v4.app.Fragment> arrayList = this.mCreatedMenus;
        if (arrayList != null && (size4 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i3 = 0; i3 < size4; i3++) {
                android.support.v4.app.Fragment fragment2 = this.mCreatedMenus.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(fragment2.toString());
            }
        }
        java.util.ArrayList<android.support.v4.app.BackStackRecord> arrayList2 = this.mBackStack;
        if (arrayList2 != null && (size3 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i4 = 0; i4 < size3; i4++) {
                android.support.v4.app.BackStackRecord backStackRecord = this.mBackStack.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(backStackRecord.toString());
                backStackRecord.dump(str2, fileDescriptor, printWriter, strArr);
            }
        }
        synchronized (this) {
            if (this.mBackStackIndices != null && (size2 = this.mBackStackIndices.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i5 = 0; i5 < size2; i5++) {
                    java.lang.Object obj = (android.support.v4.app.BackStackRecord) this.mBackStackIndices.get(i5);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i5);
                    printWriter.print(": ");
                    printWriter.println(obj);
                }
            }
            if (this.mAvailBackStackIndices != null && this.mAvailBackStackIndices.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(java.util.Arrays.toString(this.mAvailBackStackIndices.toArray()));
            }
        }
        java.util.ArrayList<android.support.v4.app.FragmentManagerImpl.OpGenerator> arrayList3 = this.mPendingActions;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i6 = 0; i6 < size; i6++) {
                java.lang.Object obj2 = (android.support.v4.app.FragmentManagerImpl.OpGenerator) this.mPendingActions.get(i6);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i6);
                printWriter.print(": ");
                printWriter.println(obj2);
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.mHost);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.mContainer);
        if (this.mParent != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.mParent);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.mCurState);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.mStateSaved);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.mDestroyed);
        if (this.mNeedMenuInvalidate) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.mNeedMenuInvalidate);
        }
        if (this.mNoTransactionsBecause != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.mNoTransactionsBecause);
        }
    }

    public void enqueueAction(android.support.v4.app.FragmentManagerImpl.OpGenerator opGenerator, boolean z) {
        if (!z) {
            checkStateLoss();
        }
        synchronized (this) {
            if (!this.mDestroyed && this.mHost != null) {
                if (this.mPendingActions == null) {
                    this.mPendingActions = new java.util.ArrayList<>();
                }
                this.mPendingActions.add(opGenerator);
                scheduleCommit();
                return;
            }
            if (!z) {
                throw new java.lang.IllegalStateException("Activity has been destroyed");
            }
        }
    }

    void ensureInflatedFragmentView(android.support.v4.app.Fragment fragment) {
        if (!fragment.mFromLayout || fragment.mPerformedCreateView) {
            return;
        }
        fragment.mView = fragment.performCreateView(fragment.performGetLayoutInflater(fragment.mSavedFragmentState), null, fragment.mSavedFragmentState);
        if (fragment.mView == null) {
            fragment.mInnerView = null;
            return;
        }
        fragment.mInnerView = fragment.mView;
        fragment.mView.setSaveFromParentEnabled(false);
        if (fragment.mHidden) {
            fragment.mView.setVisibility(8);
        }
        fragment.onViewCreated(fragment.mView, fragment.mSavedFragmentState);
        dispatchOnFragmentViewCreated(fragment, fragment.mView, fragment.mSavedFragmentState, false);
    }

    public boolean execPendingActions() {
        ensureExecReady(true);
        boolean z = false;
        while (generateOpsForPendingActions(this.mTmpRecords, this.mTmpIsPop)) {
            this.mExecutingActions = true;
            try {
                removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
                cleanupExec();
                z = true;
            } catch (java.lang.Throwable th) {
                cleanupExec();
                throw th;
            }
        }
        doPendingDeferredStart();
        burpActive();
        return z;
    }

    public void execSingleAction(android.support.v4.app.FragmentManagerImpl.OpGenerator opGenerator, boolean z) {
        if (z && (this.mHost == null || this.mDestroyed)) {
            return;
        }
        ensureExecReady(z);
        if (opGenerator.generateOps(this.mTmpRecords, this.mTmpIsPop)) {
            this.mExecutingActions = true;
            try {
                removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
                cleanupExec();
            } catch (java.lang.Throwable th) {
                cleanupExec();
                throw th;
            }
        }
        doPendingDeferredStart();
        burpActive();
    }

    @Override // android.support.v4.app.FragmentManager
    public boolean executePendingTransactions() {
        boolean zExecPendingActions = execPendingActions();
        forcePostponedTransactions();
        return zExecPendingActions;
    }

    @Override // android.support.v4.app.FragmentManager
    public android.support.v4.app.Fragment findFragmentById(int i) {
        for (int size = this.mAdded.size() - 1; size >= 0; size--) {
            android.support.v4.app.Fragment fragment = this.mAdded.get(size);
            if (fragment != null && fragment.mFragmentId == i) {
                return fragment;
            }
        }
        android.util.SparseArray<android.support.v4.app.Fragment> sparseArray = this.mActive;
        if (sparseArray == null) {
            return null;
        }
        for (int size2 = sparseArray.size() - 1; size2 >= 0; size2--) {
            android.support.v4.app.Fragment fragmentValueAt = this.mActive.valueAt(size2);
            if (fragmentValueAt != null && fragmentValueAt.mFragmentId == i) {
                return fragmentValueAt;
            }
        }
        return null;
    }

    @Override // android.support.v4.app.FragmentManager
    public android.support.v4.app.Fragment findFragmentByTag(java.lang.String str) {
        if (str != null) {
            for (int size = this.mAdded.size() - 1; size >= 0; size--) {
                android.support.v4.app.Fragment fragment = this.mAdded.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        android.util.SparseArray<android.support.v4.app.Fragment> sparseArray = this.mActive;
        if (sparseArray == null || str == null) {
            return null;
        }
        for (int size2 = sparseArray.size() - 1; size2 >= 0; size2--) {
            android.support.v4.app.Fragment fragmentValueAt = this.mActive.valueAt(size2);
            if (fragmentValueAt != null && str.equals(fragmentValueAt.mTag)) {
                return fragmentValueAt;
            }
        }
        return null;
    }

    public android.support.v4.app.Fragment findFragmentByWho(java.lang.String str) {
        android.support.v4.app.Fragment fragmentFindFragmentByWho;
        android.util.SparseArray<android.support.v4.app.Fragment> sparseArray = this.mActive;
        if (sparseArray == null || str == null) {
            return null;
        }
        for (int size = sparseArray.size() - 1; size >= 0; size--) {
            android.support.v4.app.Fragment fragmentValueAt = this.mActive.valueAt(size);
            if (fragmentValueAt != null && (fragmentFindFragmentByWho = fragmentValueAt.findFragmentByWho(str)) != null) {
                return fragmentFindFragmentByWho;
            }
        }
        return null;
    }

    public void freeBackStackIndex(int i) {
        synchronized (this) {
            this.mBackStackIndices.set(i, null);
            if (this.mAvailBackStackIndices == null) {
                this.mAvailBackStackIndices = new java.util.ArrayList<>();
            }
            if (DEBUG) {
                android.util.Log.v(TAG, "Freeing back stack index " + i);
            }
            this.mAvailBackStackIndices.add(java.lang.Integer.valueOf(i));
        }
    }

    int getActiveFragmentCount() {
        android.util.SparseArray<android.support.v4.app.Fragment> sparseArray = this.mActive;
        if (sparseArray == null) {
            return 0;
        }
        return sparseArray.size();
    }

    java.util.List<android.support.v4.app.Fragment> getActiveFragments() {
        android.util.SparseArray<android.support.v4.app.Fragment> sparseArray = this.mActive;
        if (sparseArray == null) {
            return null;
        }
        int size = sparseArray.size();
        java.util.ArrayList arrayList = new java.util.ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(this.mActive.valueAt(i));
        }
        return arrayList;
    }

    @Override // android.support.v4.app.FragmentManager
    public android.support.v4.app.FragmentManager.BackStackEntry getBackStackEntryAt(int i) {
        return this.mBackStack.get(i);
    }

    @Override // android.support.v4.app.FragmentManager
    public int getBackStackEntryCount() {
        java.util.ArrayList<android.support.v4.app.BackStackRecord> arrayList = this.mBackStack;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.support.v4.app.FragmentManager
    public android.support.v4.app.Fragment getFragment(android.os.Bundle bundle, java.lang.String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        android.support.v4.app.Fragment fragment = this.mActive.get(i);
        if (fragment == null) {
            throwException(new java.lang.IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        }
        return fragment;
    }

    @Override // android.support.v4.app.FragmentManager
    public java.util.List<android.support.v4.app.Fragment> getFragments() {
        java.util.List<android.support.v4.app.Fragment> list;
        if (this.mAdded.isEmpty()) {
            return java.util.Collections.EMPTY_LIST;
        }
        synchronized (this.mAdded) {
            list = (java.util.List) this.mAdded.clone();
        }
        return list;
    }

    android.view.LayoutInflater.Factory2 getLayoutInflaterFactory() {
        return this;
    }

    @Override // android.support.v4.app.FragmentManager
    public android.support.v4.app.Fragment getPrimaryNavigationFragment() {
        return this.mPrimaryNav;
    }

    public void hideFragment(android.support.v4.app.Fragment fragment) {
        if (DEBUG) {
            android.util.Log.v(TAG, "hide: " + fragment);
        }
        if (fragment.mHidden) {
            return;
        }
        fragment.mHidden = true;
        fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
    }

    @Override // android.support.v4.app.FragmentManager
    public boolean isDestroyed() {
        return this.mDestroyed;
    }

    boolean isStateAtLeast(int i) {
        return this.mCurState >= i;
    }

    @Override // android.support.v4.app.FragmentManager
    public boolean isStateSaved() {
        return this.mStateSaved;
    }

    android.support.v4.app.FragmentManagerImpl.AnimationOrAnimator loadAnimation(android.support.v4.app.Fragment fragment, int i, boolean z, int i2) {
        int iTransitToStyleIndex;
        int nextAnim = fragment.getNextAnim();
        android.view.animation.Animation animationOnCreateAnimation = fragment.onCreateAnimation(i, z, nextAnim);
        if (animationOnCreateAnimation != null) {
            return new android.support.v4.app.FragmentManagerImpl.AnimationOrAnimator(animationOnCreateAnimation);
        }
        android.animation.Animator animatorOnCreateAnimator = fragment.onCreateAnimator(i, z, nextAnim);
        if (animatorOnCreateAnimator != null) {
            return new android.support.v4.app.FragmentManagerImpl.AnimationOrAnimator(animatorOnCreateAnimator);
        }
        if (nextAnim != 0) {
            boolean zEquals = "anim".equals(this.mHost.getContext().getResources().getResourceTypeName(nextAnim));
            boolean z2 = false;
            if (zEquals) {
                try {
                    android.view.animation.Animation animationLoadAnimation = android.view.animation.AnimationUtils.loadAnimation(this.mHost.getContext(), nextAnim);
                    if (animationLoadAnimation != null) {
                        return new android.support.v4.app.FragmentManagerImpl.AnimationOrAnimator(animationLoadAnimation);
                    }
                    z2 = true;
                } catch (android.content.res.Resources.NotFoundException e) {
                    throw e;
                } catch (java.lang.RuntimeException unused) {
                }
            }
            if (!z2) {
                try {
                    android.animation.Animator animatorLoadAnimator = android.animation.AnimatorInflater.loadAnimator(this.mHost.getContext(), nextAnim);
                    if (animatorLoadAnimator != null) {
                        return new android.support.v4.app.FragmentManagerImpl.AnimationOrAnimator(animatorLoadAnimator);
                    }
                } catch (java.lang.RuntimeException e2) {
                    if (zEquals) {
                        throw e2;
                    }
                    android.view.animation.Animation animationLoadAnimation2 = android.view.animation.AnimationUtils.loadAnimation(this.mHost.getContext(), nextAnim);
                    if (animationLoadAnimation2 != null) {
                        return new android.support.v4.app.FragmentManagerImpl.AnimationOrAnimator(animationLoadAnimation2);
                    }
                }
            }
        }
        if (i == 0 || (iTransitToStyleIndex = transitToStyleIndex(i, z)) < 0) {
            return null;
        }
        switch (iTransitToStyleIndex) {
            case 1:
                return makeOpenCloseAnimation(this.mHost.getContext(), 1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return makeOpenCloseAnimation(this.mHost.getContext(), 1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return makeOpenCloseAnimation(this.mHost.getContext(), 0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return makeOpenCloseAnimation(this.mHost.getContext(), 1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return makeFadeAnimation(this.mHost.getContext(), 0.0f, 1.0f);
            case 6:
                return makeFadeAnimation(this.mHost.getContext(), 1.0f, 0.0f);
            default:
                if (i2 == 0 && this.mHost.onHasWindowAnimations()) {
                    i2 = this.mHost.onGetWindowAnimations();
                }
                return i2 == 0 ? null : null;
        }
    }

    void makeActive(android.support.v4.app.Fragment fragment) {
        if (fragment.mIndex >= 0) {
            return;
        }
        int i = this.mNextFragmentIndex;
        this.mNextFragmentIndex = i + 1;
        fragment.setIndex(i, this.mParent);
        if (this.mActive == null) {
            this.mActive = new android.util.SparseArray<>();
        }
        this.mActive.put(fragment.mIndex, fragment);
        if (DEBUG) {
            android.util.Log.v(TAG, "Allocated fragment index " + fragment);
        }
    }

    void makeInactive(android.support.v4.app.Fragment fragment) {
        if (fragment.mIndex < 0) {
            return;
        }
        if (DEBUG) {
            android.util.Log.v(TAG, "Freeing fragment index " + fragment);
        }
        this.mActive.put(fragment.mIndex, null);
        this.mHost.inactivateFragment(fragment.mWho);
        fragment.initState();
    }

    void moveFragmentToExpectedState(android.support.v4.app.Fragment fragment) {
        int iMin;
        if (fragment == null) {
            return;
        }
        int i = this.mCurState;
        if (fragment.mRemoving) {
            iMin = fragment.isInBackStack() ? java.lang.Math.min(i, 1) : java.lang.Math.min(i, 0);
        } else {
            iMin = i;
        }
        moveToState(fragment, iMin, fragment.getNextTransition(), fragment.getNextTransitionStyle(), false);
        if (fragment.mView != null) {
            android.support.v4.app.Fragment fragmentFindFragmentUnder = findFragmentUnder(fragment);
            if (fragmentFindFragmentUnder != null) {
                android.view.View view = fragmentFindFragmentUnder.mView;
                android.view.ViewGroup viewGroup = fragment.mContainer;
                int iIndexOfChild = viewGroup.indexOfChild(view);
                int iIndexOfChild2 = viewGroup.indexOfChild(fragment.mView);
                if (iIndexOfChild2 < iIndexOfChild) {
                    viewGroup.removeViewAt(iIndexOfChild2);
                    viewGroup.addView(fragment.mView, iIndexOfChild);
                }
            }
            if (fragment.mIsNewlyAdded && fragment.mContainer != null) {
                if (fragment.mPostponedAlpha > 0.0f) {
                    fragment.mView.setAlpha(fragment.mPostponedAlpha);
                }
                fragment.mPostponedAlpha = 0.0f;
                fragment.mIsNewlyAdded = false;
                android.support.v4.app.FragmentManagerImpl.AnimationOrAnimator animationOrAnimatorLoadAnimation = loadAnimation(fragment, fragment.getNextTransition(), true, fragment.getNextTransitionStyle());
                if (animationOrAnimatorLoadAnimation != null) {
                    setHWLayerAnimListenerIfAlpha(fragment.mView, animationOrAnimatorLoadAnimation);
                    if (animationOrAnimatorLoadAnimation.animation != null) {
                        fragment.mView.startAnimation(animationOrAnimatorLoadAnimation.animation);
                    } else {
                        animationOrAnimatorLoadAnimation.animator.setTarget(fragment.mView);
                        animationOrAnimatorLoadAnimation.animator.start();
                    }
                }
            }
        }
        if (fragment.mHiddenChanged) {
            completeShowHideFragment(fragment);
        }
    }

    void moveToState(int i, boolean z) {
        android.support.v4.app.FragmentHostCallback fragmentHostCallback;
        if (this.mHost == null && i != 0) {
            throw new java.lang.IllegalStateException("No activity");
        }
        if (z || i != this.mCurState) {
            this.mCurState = i;
            if (this.mActive != null) {
                int size = this.mAdded.size();
                boolean zHasRunningLoaders = false;
                for (int i2 = 0; i2 < size; i2++) {
                    android.support.v4.app.Fragment fragment = this.mAdded.get(i2);
                    moveFragmentToExpectedState(fragment);
                    if (fragment.mLoaderManager != null) {
                        zHasRunningLoaders |= fragment.mLoaderManager.hasRunningLoaders();
                    }
                }
                int size2 = this.mActive.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    android.support.v4.app.Fragment fragmentValueAt = this.mActive.valueAt(i3);
                    if (fragmentValueAt != null && ((fragmentValueAt.mRemoving || fragmentValueAt.mDetached) && !fragmentValueAt.mIsNewlyAdded)) {
                        moveFragmentToExpectedState(fragmentValueAt);
                        if (fragmentValueAt.mLoaderManager != null) {
                            zHasRunningLoaders |= fragmentValueAt.mLoaderManager.hasRunningLoaders();
                        }
                    }
                }
                if (!zHasRunningLoaders) {
                    startPendingDeferredFragments();
                }
                if (this.mNeedMenuInvalidate && (fragmentHostCallback = this.mHost) != null && this.mCurState == 5) {
                    fragmentHostCallback.onSupportInvalidateOptionsMenu();
                    this.mNeedMenuInvalidate = false;
                }
            }
        }
    }

    void moveToState(android.support.v4.app.Fragment fragment) {
        moveToState(fragment, this.mCurState, 0, 0, false);
    }

    /* JADX WARN: Code duplicated, block: B:216:0x044c A[FALL_THROUGH] */
    void moveToState(android.support.v4.app.Fragment fragment, int i, int i2, int i3, boolean z) {
        int i4;
        android.view.ViewGroup viewGroup;
        java.lang.String resourceName;
        int i5 = 1;
        if (!fragment.mAdded || fragment.mDetached) {
            i4 = i;
            if (i4 > 1) {
                i4 = 1;
            }
        } else {
            i4 = i;
        }
        if (fragment.mRemoving && i4 > fragment.mState) {
            i4 = (fragment.mState == 0 && fragment.isInBackStack()) ? 1 : fragment.mState;
        }
        int i6 = (!fragment.mDeferStart || fragment.mState >= 4 || i4 <= 3) ? i4 : 3;
        if (fragment.mState <= i6) {
            if (fragment.mFromLayout && !fragment.mInLayout) {
                return;
            }
            if (fragment.getAnimatingAway() != null || fragment.getAnimator() != null) {
                fragment.setAnimatingAway(null);
                fragment.setAnimator(null);
                moveToState(fragment, fragment.getStateAfterAnimating(), 0, 0, true);
            }
            switch (fragment.mState) {
                case 0:
                    if (i6 > 0) {
                        if (DEBUG) {
                            android.util.Log.v(TAG, "moveto CREATED: " + fragment);
                        }
                        if (fragment.mSavedFragmentState != null) {
                            fragment.mSavedFragmentState.setClassLoader(this.mHost.getContext().getClassLoader());
                            fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray(VIEW_STATE_TAG);
                            fragment.mTarget = getFragment(fragment.mSavedFragmentState, TARGET_STATE_TAG);
                            if (fragment.mTarget != null) {
                                fragment.mTargetRequestCode = fragment.mSavedFragmentState.getInt(TARGET_REQUEST_CODE_STATE_TAG, 0);
                            }
                            fragment.mUserVisibleHint = fragment.mSavedFragmentState.getBoolean(USER_VISIBLE_HINT_TAG, true);
                            if (!fragment.mUserVisibleHint) {
                                fragment.mDeferStart = true;
                                if (i6 > 3) {
                                    i6 = 3;
                                }
                            }
                        }
                        android.support.v4.app.FragmentHostCallback fragmentHostCallback = this.mHost;
                        fragment.mHost = fragmentHostCallback;
                        android.support.v4.app.Fragment fragment2 = this.mParent;
                        fragment.mParentFragment = fragment2;
                        fragment.mFragmentManager = fragment2 != null ? fragment2.mChildFragmentManager : fragmentHostCallback.getFragmentManagerImpl();
                        if (fragment.mTarget != null) {
                            if (this.mActive.get(fragment.mTarget.mIndex) != fragment.mTarget) {
                                throw new java.lang.IllegalStateException("Fragment " + fragment + " declared target fragment " + fragment.mTarget + " that does not belong to this FragmentManager!");
                            }
                            if (fragment.mTarget.mState < 1) {
                                moveToState(fragment.mTarget, 1, 0, 0, true);
                            }
                        }
                        dispatchOnFragmentPreAttached(fragment, this.mHost.getContext(), false);
                        fragment.mCalled = false;
                        fragment.onAttach(this.mHost.getContext());
                        if (!fragment.mCalled) {
                            throw new android.support.v4.app.SuperNotCalledException("Fragment " + fragment + " did not call through to super.onAttach()");
                        }
                        if (fragment.mParentFragment == null) {
                            this.mHost.onAttachFragment(fragment);
                        } else {
                            fragment.mParentFragment.onAttachFragment(fragment);
                        }
                        dispatchOnFragmentAttached(fragment, this.mHost.getContext(), false);
                        if (fragment.mIsCreated) {
                            fragment.restoreChildFragmentState(fragment.mSavedFragmentState);
                            fragment.mState = 1;
                        } else {
                            dispatchOnFragmentPreCreated(fragment, fragment.mSavedFragmentState, false);
                            fragment.performCreate(fragment.mSavedFragmentState);
                            dispatchOnFragmentCreated(fragment, fragment.mSavedFragmentState, false);
                        }
                        fragment.mRetaining = false;
                        break;
                    }
                case 1:
                    ensureInflatedFragmentView(fragment);
                    if (i6 > 1) {
                        if (DEBUG) {
                            android.util.Log.v(TAG, "moveto ACTIVITY_CREATED: " + fragment);
                        }
                        if (!fragment.mFromLayout) {
                            if (fragment.mContainerId != 0) {
                                if (fragment.mContainerId == -1) {
                                    throwException(new java.lang.IllegalArgumentException("Cannot create fragment " + fragment + " for a container view with no id"));
                                }
                                viewGroup = (android.view.ViewGroup) this.mContainer.onFindViewById(fragment.mContainerId);
                                if (viewGroup == null && !fragment.mRestored) {
                                    try {
                                        resourceName = fragment.getResources().getResourceName(fragment.mContainerId);
                                    } catch (android.content.res.Resources.NotFoundException unused) {
                                        resourceName = android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
                                    }
                                    throwException(new java.lang.IllegalArgumentException("No view found for id 0x" + java.lang.Integer.toHexString(fragment.mContainerId) + " (" + resourceName + ") for fragment " + fragment));
                                }
                            } else {
                                viewGroup = null;
                            }
                            fragment.mContainer = viewGroup;
                            fragment.mView = fragment.performCreateView(fragment.performGetLayoutInflater(fragment.mSavedFragmentState), viewGroup, fragment.mSavedFragmentState);
                            if (fragment.mView != null) {
                                fragment.mInnerView = fragment.mView;
                                fragment.mView.setSaveFromParentEnabled(false);
                                if (viewGroup != null) {
                                    viewGroup.addView(fragment.mView);
                                }
                                if (fragment.mHidden) {
                                    fragment.mView.setVisibility(8);
                                }
                                fragment.onViewCreated(fragment.mView, fragment.mSavedFragmentState);
                                dispatchOnFragmentViewCreated(fragment, fragment.mView, fragment.mSavedFragmentState, false);
                                fragment.mIsNewlyAdded = fragment.mView.getVisibility() == 0 && fragment.mContainer != null;
                            } else {
                                fragment.mInnerView = null;
                            }
                        }
                        fragment.performActivityCreated(fragment.mSavedFragmentState);
                        dispatchOnFragmentActivityCreated(fragment, fragment.mSavedFragmentState, false);
                        if (fragment.mView != null) {
                            fragment.restoreViewState(fragment.mSavedFragmentState);
                        }
                        fragment.mSavedFragmentState = null;
                        break;
                    }
                case 2:
                    if (i6 > 2) {
                        fragment.mState = 3;
                        break;
                    }
                case 3:
                    if (i6 > 3) {
                        if (DEBUG) {
                            android.util.Log.v(TAG, "moveto STARTED: " + fragment);
                        }
                        fragment.performStart();
                        dispatchOnFragmentStarted(fragment, false);
                        break;
                    }
                case 4:
                    if (i6 > 4) {
                        if (DEBUG) {
                            android.util.Log.v(TAG, "moveto RESUMED: " + fragment);
                        }
                        fragment.performResume();
                        dispatchOnFragmentResumed(fragment, false);
                        fragment.mSavedFragmentState = null;
                        fragment.mSavedViewState = null;
                    }
                    i5 = i6;
                    break;
                default:
                    i5 = i6;
                    break;
            }
        } else if (fragment.mState > i6) {
            switch (fragment.mState) {
                case 5:
                    if (i6 < 5) {
                        if (DEBUG) {
                            android.util.Log.v(TAG, "movefrom RESUMED: " + fragment);
                        }
                        fragment.performPause();
                        dispatchOnFragmentPaused(fragment, false);
                        break;
                    }
                case 4:
                    if (i6 < 4) {
                        if (DEBUG) {
                            android.util.Log.v(TAG, "movefrom STARTED: " + fragment);
                        }
                        fragment.performStop();
                        dispatchOnFragmentStopped(fragment, false);
                        break;
                    }
                case 3:
                    if (i6 < 3) {
                        if (DEBUG) {
                            android.util.Log.v(TAG, "movefrom STOPPED: " + fragment);
                        }
                        fragment.performReallyStop();
                        break;
                    }
                case 2:
                    if (i6 < 2) {
                        if (DEBUG) {
                            android.util.Log.v(TAG, "movefrom ACTIVITY_CREATED: " + fragment);
                        }
                        if (fragment.mView != null && this.mHost.onShouldSaveFragmentState(fragment) && fragment.mSavedViewState == null) {
                            saveFragmentViewState(fragment);
                        }
                        fragment.performDestroyView();
                        dispatchOnFragmentViewDestroyed(fragment, false);
                        if (fragment.mView != null && fragment.mContainer != null) {
                            fragment.mView.clearAnimation();
                            fragment.mContainer.endViewTransition(fragment.mView);
                            android.support.v4.app.FragmentManagerImpl.AnimationOrAnimator animationOrAnimatorLoadAnimation = (this.mCurState <= 0 || this.mDestroyed || fragment.mView.getVisibility() != 0 || fragment.mPostponedAlpha < 0.0f) ? null : loadAnimation(fragment, i2, false, i3);
                            fragment.mPostponedAlpha = 0.0f;
                            if (animationOrAnimatorLoadAnimation != null) {
                                animateRemoveFragment(fragment, animationOrAnimatorLoadAnimation, i6);
                            }
                            fragment.mContainer.removeView(fragment.mView);
                        }
                        fragment.mContainer = null;
                        fragment.mView = null;
                        fragment.mInnerView = null;
                        fragment.mInLayout = false;
                        break;
                    }
                case 1:
                    if (i6 < 1) {
                        if (this.mDestroyed) {
                            if (fragment.getAnimatingAway() != null) {
                                android.view.View animatingAway = fragment.getAnimatingAway();
                                fragment.setAnimatingAway(null);
                                animatingAway.clearAnimation();
                            } else if (fragment.getAnimator() != null) {
                                android.animation.Animator animator = fragment.getAnimator();
                                fragment.setAnimator(null);
                                animator.cancel();
                            }
                        }
                        if (fragment.getAnimatingAway() == null && fragment.getAnimator() == null) {
                            if (DEBUG) {
                                android.util.Log.v(TAG, "movefrom CREATED: " + fragment);
                            }
                            if (fragment.mRetaining) {
                                fragment.mState = 0;
                            } else {
                                fragment.performDestroy();
                                dispatchOnFragmentDestroyed(fragment, false);
                            }
                            fragment.performDetach();
                            dispatchOnFragmentDetached(fragment, false);
                            if (!z) {
                                if (!fragment.mRetaining) {
                                    makeInactive(fragment);
                                } else {
                                    fragment.mHost = null;
                                    fragment.mParentFragment = null;
                                    fragment.mFragmentManager = null;
                                }
                            }
                        } else {
                            fragment.setStateAfterAnimating(i6);
                        }
                        break;
                    }
                default:
                    i5 = i6;
                    break;
            }
        } else {
            i5 = i6;
        }
        if (fragment.mState != i5) {
            android.util.Log.w(TAG, "moveToState: Fragment state for " + fragment + " not updated inline; expected state " + i5 + " found " + fragment.mState);
            fragment.mState = i5;
        }
    }

    public void noteStateNotSaved() {
        this.mSavedNonConfig = null;
        this.mStateSaved = false;
        int size = this.mAdded.size();
        for (int i = 0; i < size; i++) {
            android.support.v4.app.Fragment fragment = this.mAdded.get(i);
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    @Override // android.view.LayoutInflater.Factory2
    public android.view.View onCreateView(android.view.View view, java.lang.String str, android.content.Context context, android.util.AttributeSet attributeSet) {
        android.support.v4.app.Fragment fragment;
        if (!"fragment".equals(str)) {
            return null;
        }
        java.lang.String attributeValue = attributeSet.getAttributeValue(null, "class");
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.v4.app.FragmentManagerImpl.FragmentTag.Fragment);
        java.lang.String string = attributeValue == null ? typedArrayObtainStyledAttributes.getString(0) : attributeValue;
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(1, -1);
        java.lang.String string2 = typedArrayObtainStyledAttributes.getString(2);
        typedArrayObtainStyledAttributes.recycle();
        if (!android.support.v4.app.Fragment.isSupportFragmentClass(this.mHost.getContext(), string)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string2 == null) {
            throw new java.lang.IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + string);
        }
        android.support.v4.app.Fragment fragmentFindFragmentById = resourceId != -1 ? findFragmentById(resourceId) : null;
        if (fragmentFindFragmentById == null && string2 != null) {
            fragmentFindFragmentById = findFragmentByTag(string2);
        }
        if (fragmentFindFragmentById == null && id != -1) {
            fragmentFindFragmentById = findFragmentById(id);
        }
        if (DEBUG) {
            android.util.Log.v(TAG, "onCreateView: id=0x" + java.lang.Integer.toHexString(resourceId) + " fname=" + string + " existing=" + fragmentFindFragmentById);
        }
        if (fragmentFindFragmentById == null) {
            android.support.v4.app.Fragment fragmentInstantiate = this.mContainer.instantiate(context, string, null);
            fragmentInstantiate.mFromLayout = true;
            fragmentInstantiate.mFragmentId = resourceId != 0 ? resourceId : id;
            fragmentInstantiate.mContainerId = id;
            fragmentInstantiate.mTag = string2;
            fragmentInstantiate.mInLayout = true;
            fragmentInstantiate.mFragmentManager = this;
            android.support.v4.app.FragmentHostCallback fragmentHostCallback = this.mHost;
            fragmentInstantiate.mHost = fragmentHostCallback;
            fragmentInstantiate.onInflate(fragmentHostCallback.getContext(), attributeSet, fragmentInstantiate.mSavedFragmentState);
            addFragment(fragmentInstantiate, true);
            fragment = fragmentInstantiate;
        } else {
            if (fragmentFindFragmentById.mInLayout) {
                throw new java.lang.IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + java.lang.Integer.toHexString(resourceId) + ", tag " + string2 + ", or parent id 0x" + java.lang.Integer.toHexString(id) + " with another fragment for " + string);
            }
            fragmentFindFragmentById.mInLayout = true;
            fragmentFindFragmentById.mHost = this.mHost;
            if (!fragmentFindFragmentById.mRetaining) {
                fragmentFindFragmentById.onInflate(this.mHost.getContext(), attributeSet, fragmentFindFragmentById.mSavedFragmentState);
            }
            fragment = fragmentFindFragmentById;
        }
        if (this.mCurState >= 1 || !fragment.mFromLayout) {
            moveToState(fragment);
        } else {
            moveToState(fragment, 1, 0, 0, false);
        }
        if (fragment.mView != null) {
            if (resourceId != 0) {
                fragment.mView.setId(resourceId);
            }
            if (fragment.mView.getTag() == null) {
                fragment.mView.setTag(string2);
            }
            return fragment.mView;
        }
        throw new java.lang.IllegalStateException("Fragment " + string + " did not create a view.");
    }

    @Override // android.view.LayoutInflater.Factory
    public android.view.View onCreateView(java.lang.String str, android.content.Context context, android.util.AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    public void performPendingDeferredStart(android.support.v4.app.Fragment fragment) {
        if (fragment.mDeferStart) {
            if (this.mExecutingActions) {
                this.mHavePendingDeferredStart = true;
            } else {
                fragment.mDeferStart = false;
                moveToState(fragment, this.mCurState, 0, 0, false);
            }
        }
    }

    @Override // android.support.v4.app.FragmentManager
    public void popBackStack() {
        enqueueAction(new android.support.v4.app.FragmentManagerImpl.PopBackStackState(null, -1, 0), false);
    }

    @Override // android.support.v4.app.FragmentManager
    public void popBackStack(int i, int i2) {
        if (i >= 0) {
            enqueueAction(new android.support.v4.app.FragmentManagerImpl.PopBackStackState(null, i, i2), false);
            return;
        }
        throw new java.lang.IllegalArgumentException("Bad id: " + i);
    }

    @Override // android.support.v4.app.FragmentManager
    public void popBackStack(java.lang.String str, int i) {
        enqueueAction(new android.support.v4.app.FragmentManagerImpl.PopBackStackState(str, -1, i), false);
    }

    @Override // android.support.v4.app.FragmentManager
    public boolean popBackStackImmediate() {
        checkStateLoss();
        return popBackStackImmediate(null, -1, 0);
    }

    @Override // android.support.v4.app.FragmentManager
    public boolean popBackStackImmediate(int i, int i2) {
        checkStateLoss();
        execPendingActions();
        if (i >= 0) {
            return popBackStackImmediate(null, i, i2);
        }
        throw new java.lang.IllegalArgumentException("Bad id: " + i);
    }

    @Override // android.support.v4.app.FragmentManager
    public boolean popBackStackImmediate(java.lang.String str, int i) {
        checkStateLoss();
        return popBackStackImmediate(str, -1, i);
    }

    boolean popBackStackState(java.util.ArrayList<android.support.v4.app.BackStackRecord> arrayList, java.util.ArrayList<java.lang.Boolean> arrayList2, java.lang.String str, int i, int i2) {
        int size;
        java.util.ArrayList<android.support.v4.app.BackStackRecord> arrayList3 = this.mBackStack;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i < 0 && (i2 & 1) == 0) {
            int size2 = arrayList3.size() - 1;
            if (size2 < 0) {
                return false;
            }
            arrayList.add(this.mBackStack.remove(size2));
            arrayList2.add(true);
        } else {
            if (str != null || i >= 0) {
                size = this.mBackStack.size() - 1;
                while (size >= 0) {
                    android.support.v4.app.BackStackRecord backStackRecord = this.mBackStack.get(size);
                    if ((str != null && str.equals(backStackRecord.getName())) || (i >= 0 && i == backStackRecord.mIndex)) {
                        break;
                    }
                    size--;
                }
                if (size < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    size--;
                    while (size >= 0) {
                        android.support.v4.app.BackStackRecord backStackRecord2 = this.mBackStack.get(size);
                        if ((str == null || !str.equals(backStackRecord2.getName())) && (i < 0 || i != backStackRecord2.mIndex)) {
                            break;
                        }
                        size--;
                    }
                }
            } else {
                size = -1;
            }
            if (size == this.mBackStack.size() - 1) {
                return false;
            }
            for (int size3 = this.mBackStack.size() - 1; size3 > size; size3--) {
                arrayList.add(this.mBackStack.remove(size3));
                arrayList2.add(true);
            }
        }
        return true;
    }

    @Override // android.support.v4.app.FragmentManager
    public void putFragment(android.os.Bundle bundle, java.lang.String str, android.support.v4.app.Fragment fragment) {
        if (fragment.mIndex < 0) {
            throwException(new java.lang.IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, fragment.mIndex);
    }

    @Override // android.support.v4.app.FragmentManager
    public void registerFragmentLifecycleCallbacks(android.support.v4.app.FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z) {
        this.mLifecycleCallbacks.add(new android.support.v4.util.Pair<>(fragmentLifecycleCallbacks, java.lang.Boolean.valueOf(z)));
    }

    public void removeFragment(android.support.v4.app.Fragment fragment) {
        if (DEBUG) {
            android.util.Log.v(TAG, "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean z = !fragment.isInBackStack();
        if (!fragment.mDetached || z) {
            synchronized (this.mAdded) {
                this.mAdded.remove(fragment);
            }
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.mNeedMenuInvalidate = true;
            }
            fragment.mAdded = false;
            fragment.mRemoving = true;
        }
    }

    @Override // android.support.v4.app.FragmentManager
    public void removeOnBackStackChangedListener(android.support.v4.app.FragmentManager.OnBackStackChangedListener onBackStackChangedListener) {
        java.util.ArrayList<android.support.v4.app.FragmentManager.OnBackStackChangedListener> arrayList = this.mBackStackChangeListeners;
        if (arrayList != null) {
            arrayList.remove(onBackStackChangedListener);
        }
    }

    void reportBackStackChanged() {
        if (this.mBackStackChangeListeners != null) {
            for (int i = 0; i < this.mBackStackChangeListeners.size(); i++) {
                this.mBackStackChangeListeners.get(i).onBackStackChanged();
            }
        }
    }

    void restoreAllState(android.os.Parcelable parcelable, android.support.v4.app.FragmentManagerNonConfig fragmentManagerNonConfig) {
        java.util.List<android.support.v4.app.FragmentManagerNonConfig> childNonConfigs;
        if (parcelable == null) {
            return;
        }
        android.support.v4.app.FragmentManagerState fragmentManagerState = (android.support.v4.app.FragmentManagerState) parcelable;
        if (fragmentManagerState.mActive == null) {
            return;
        }
        if (fragmentManagerNonConfig != null) {
            java.util.List<android.support.v4.app.Fragment> fragments = fragmentManagerNonConfig.getFragments();
            childNonConfigs = fragmentManagerNonConfig.getChildNonConfigs();
            int size = fragments != null ? fragments.size() : 0;
            for (int i = 0; i < size; i++) {
                android.support.v4.app.Fragment fragment = fragments.get(i);
                if (DEBUG) {
                    android.util.Log.v(TAG, "restoreAllState: re-attaching retained " + fragment);
                }
                int i2 = 0;
                while (i2 < fragmentManagerState.mActive.length && fragmentManagerState.mActive[i2].mIndex != fragment.mIndex) {
                    i2++;
                }
                if (i2 == fragmentManagerState.mActive.length) {
                    throwException(new java.lang.IllegalStateException("Could not find active fragment with index " + fragment.mIndex));
                }
                android.support.v4.app.FragmentState fragmentState = fragmentManagerState.mActive[i2];
                fragmentState.mInstance = fragment;
                fragment.mSavedViewState = null;
                fragment.mBackStackNesting = 0;
                fragment.mInLayout = false;
                fragment.mAdded = false;
                fragment.mTarget = null;
                if (fragmentState.mSavedFragmentState != null) {
                    fragmentState.mSavedFragmentState.setClassLoader(this.mHost.getContext().getClassLoader());
                    fragment.mSavedViewState = fragmentState.mSavedFragmentState.getSparseParcelableArray(VIEW_STATE_TAG);
                    fragment.mSavedFragmentState = fragmentState.mSavedFragmentState;
                }
            }
        } else {
            childNonConfigs = null;
        }
        this.mActive = new android.util.SparseArray<>(fragmentManagerState.mActive.length);
        int i3 = 0;
        while (i3 < fragmentManagerState.mActive.length) {
            android.support.v4.app.FragmentState fragmentState2 = fragmentManagerState.mActive[i3];
            if (fragmentState2 != null) {
                android.support.v4.app.Fragment fragmentInstantiate = fragmentState2.instantiate(this.mHost, this.mContainer, this.mParent, (childNonConfigs == null || i3 >= childNonConfigs.size()) ? null : childNonConfigs.get(i3));
                if (DEBUG) {
                    android.util.Log.v(TAG, "restoreAllState: active #" + i3 + ": " + fragmentInstantiate);
                }
                this.mActive.put(fragmentInstantiate.mIndex, fragmentInstantiate);
                fragmentState2.mInstance = null;
            }
            i3++;
        }
        if (fragmentManagerNonConfig != null) {
            java.util.List<android.support.v4.app.Fragment> fragments2 = fragmentManagerNonConfig.getFragments();
            int size2 = fragments2 != null ? fragments2.size() : 0;
            for (int i4 = 0; i4 < size2; i4++) {
                android.support.v4.app.Fragment fragment2 = fragments2.get(i4);
                if (fragment2.mTargetIndex >= 0) {
                    fragment2.mTarget = this.mActive.get(fragment2.mTargetIndex);
                    if (fragment2.mTarget == null) {
                        android.util.Log.w(TAG, "Re-attaching retained fragment " + fragment2 + " target no longer exists: " + fragment2.mTargetIndex);
                    }
                }
            }
        }
        this.mAdded.clear();
        if (fragmentManagerState.mAdded != null) {
            for (int i5 = 0; i5 < fragmentManagerState.mAdded.length; i5++) {
                android.support.v4.app.Fragment fragment3 = this.mActive.get(fragmentManagerState.mAdded[i5]);
                if (fragment3 == null) {
                    throwException(new java.lang.IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.mAdded[i5]));
                }
                fragment3.mAdded = true;
                if (DEBUG) {
                    android.util.Log.v(TAG, "restoreAllState: added #" + i5 + ": " + fragment3);
                }
                if (this.mAdded.contains(fragment3)) {
                    throw new java.lang.IllegalStateException("Already added!");
                }
                synchronized (this.mAdded) {
                    this.mAdded.add(fragment3);
                }
            }
        }
        if (fragmentManagerState.mBackStack != null) {
            this.mBackStack = new java.util.ArrayList<>(fragmentManagerState.mBackStack.length);
            for (int i6 = 0; i6 < fragmentManagerState.mBackStack.length; i6++) {
                android.support.v4.app.BackStackRecord backStackRecordInstantiate = fragmentManagerState.mBackStack[i6].instantiate(this);
                if (DEBUG) {
                    android.util.Log.v(TAG, "restoreAllState: back stack #" + i6 + " (index " + backStackRecordInstantiate.mIndex + "): " + backStackRecordInstantiate);
                    java.io.PrintWriter printWriter = new java.io.PrintWriter(new android.support.v4.util.LogWriter(TAG));
                    backStackRecordInstantiate.dump("  ", printWriter, false);
                    printWriter.close();
                }
                this.mBackStack.add(backStackRecordInstantiate);
                if (backStackRecordInstantiate.mIndex >= 0) {
                    setBackStackIndex(backStackRecordInstantiate.mIndex, backStackRecordInstantiate);
                }
            }
        } else {
            this.mBackStack = null;
        }
        if (fragmentManagerState.mPrimaryNavActiveIndex >= 0) {
            this.mPrimaryNav = this.mActive.get(fragmentManagerState.mPrimaryNavActiveIndex);
        }
        this.mNextFragmentIndex = fragmentManagerState.mNextFragmentIndex;
    }

    android.support.v4.app.FragmentManagerNonConfig retainNonConfig() {
        setRetaining(this.mSavedNonConfig);
        return this.mSavedNonConfig;
    }

    android.os.Parcelable saveAllState() {
        int[] iArr;
        int size;
        forcePostponedTransactions();
        endAnimatingAwayFragments();
        execPendingActions();
        this.mStateSaved = true;
        android.support.v4.app.BackStackState[] backStackStateArr = null;
        this.mSavedNonConfig = null;
        android.util.SparseArray<android.support.v4.app.Fragment> sparseArray = this.mActive;
        if (sparseArray == null || sparseArray.size() <= 0) {
            return null;
        }
        int size2 = this.mActive.size();
        android.support.v4.app.FragmentState[] fragmentStateArr = new android.support.v4.app.FragmentState[size2];
        boolean z = false;
        for (int i = 0; i < size2; i++) {
            android.support.v4.app.Fragment fragmentValueAt = this.mActive.valueAt(i);
            if (fragmentValueAt != null) {
                if (fragmentValueAt.mIndex < 0) {
                    throwException(new java.lang.IllegalStateException("Failure saving state: active " + fragmentValueAt + " has cleared index: " + fragmentValueAt.mIndex));
                }
                android.support.v4.app.FragmentState fragmentState = new android.support.v4.app.FragmentState(fragmentValueAt);
                fragmentStateArr[i] = fragmentState;
                if (fragmentValueAt.mState <= 0 || fragmentState.mSavedFragmentState != null) {
                    fragmentState.mSavedFragmentState = fragmentValueAt.mSavedFragmentState;
                } else {
                    fragmentState.mSavedFragmentState = saveFragmentBasicState(fragmentValueAt);
                    if (fragmentValueAt.mTarget != null) {
                        if (fragmentValueAt.mTarget.mIndex < 0) {
                            throwException(new java.lang.IllegalStateException("Failure saving state: " + fragmentValueAt + " has target not in fragment manager: " + fragmentValueAt.mTarget));
                        }
                        if (fragmentState.mSavedFragmentState == null) {
                            fragmentState.mSavedFragmentState = new android.os.Bundle();
                        }
                        putFragment(fragmentState.mSavedFragmentState, TARGET_STATE_TAG, fragmentValueAt.mTarget);
                        if (fragmentValueAt.mTargetRequestCode != 0) {
                            fragmentState.mSavedFragmentState.putInt(TARGET_REQUEST_CODE_STATE_TAG, fragmentValueAt.mTargetRequestCode);
                        }
                    }
                }
                if (DEBUG) {
                    android.util.Log.v(TAG, "Saved state of " + fragmentValueAt + ": " + fragmentState.mSavedFragmentState);
                }
                z = true;
            }
        }
        if (!z) {
            if (DEBUG) {
                android.util.Log.v(TAG, "saveAllState: no fragments!");
            }
            return null;
        }
        int size3 = this.mAdded.size();
        if (size3 > 0) {
            iArr = new int[size3];
            for (int i2 = 0; i2 < size3; i2++) {
                iArr[i2] = this.mAdded.get(i2).mIndex;
                if (iArr[i2] < 0) {
                    throwException(new java.lang.IllegalStateException("Failure saving state: active " + this.mAdded.get(i2) + " has cleared index: " + iArr[i2]));
                }
                if (DEBUG) {
                    android.util.Log.v(TAG, "saveAllState: adding fragment #" + i2 + ": " + this.mAdded.get(i2));
                }
            }
        } else {
            iArr = null;
        }
        java.util.ArrayList<android.support.v4.app.BackStackRecord> arrayList = this.mBackStack;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            backStackStateArr = new android.support.v4.app.BackStackState[size];
            for (int i3 = 0; i3 < size; i3++) {
                backStackStateArr[i3] = new android.support.v4.app.BackStackState(this.mBackStack.get(i3));
                if (DEBUG) {
                    android.util.Log.v(TAG, "saveAllState: adding back stack #" + i3 + ": " + this.mBackStack.get(i3));
                }
            }
        }
        android.support.v4.app.FragmentManagerState fragmentManagerState = new android.support.v4.app.FragmentManagerState();
        fragmentManagerState.mActive = fragmentStateArr;
        fragmentManagerState.mAdded = iArr;
        fragmentManagerState.mBackStack = backStackStateArr;
        android.support.v4.app.Fragment fragment = this.mPrimaryNav;
        if (fragment != null) {
            fragmentManagerState.mPrimaryNavActiveIndex = fragment.mIndex;
        }
        fragmentManagerState.mNextFragmentIndex = this.mNextFragmentIndex;
        saveNonConfig();
        return fragmentManagerState;
    }

    android.os.Bundle saveFragmentBasicState(android.support.v4.app.Fragment fragment) {
        android.os.Bundle bundle;
        if (this.mStateBundle == null) {
            this.mStateBundle = new android.os.Bundle();
        }
        fragment.performSaveInstanceState(this.mStateBundle);
        dispatchOnFragmentSaveInstanceState(fragment, this.mStateBundle, false);
        if (this.mStateBundle.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.mStateBundle;
            this.mStateBundle = null;
        }
        if (fragment.mView != null) {
            saveFragmentViewState(fragment);
        }
        if (fragment.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new android.os.Bundle();
            }
            bundle.putSparseParcelableArray(VIEW_STATE_TAG, fragment.mSavedViewState);
        }
        if (!fragment.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new android.os.Bundle();
            }
            bundle.putBoolean(USER_VISIBLE_HINT_TAG, fragment.mUserVisibleHint);
        }
        return bundle;
    }

    @Override // android.support.v4.app.FragmentManager
    public android.support.v4.app.Fragment.SavedState saveFragmentInstanceState(android.support.v4.app.Fragment fragment) {
        android.os.Bundle bundleSaveFragmentBasicState;
        if (fragment.mIndex < 0) {
            throwException(new java.lang.IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        if (fragment.mState <= 0 || (bundleSaveFragmentBasicState = saveFragmentBasicState(fragment)) == null) {
            return null;
        }
        return new android.support.v4.app.Fragment.SavedState(bundleSaveFragmentBasicState);
    }

    void saveFragmentViewState(android.support.v4.app.Fragment fragment) {
        if (fragment.mInnerView == null) {
            return;
        }
        android.util.SparseArray<android.os.Parcelable> sparseArray = this.mStateArray;
        if (sparseArray == null) {
            this.mStateArray = new android.util.SparseArray<>();
        } else {
            sparseArray.clear();
        }
        fragment.mInnerView.saveHierarchyState(this.mStateArray);
        if (this.mStateArray.size() > 0) {
            fragment.mSavedViewState = this.mStateArray;
            this.mStateArray = null;
        }
    }

    void saveNonConfig() {
        java.util.ArrayList arrayList;
        java.util.ArrayList arrayList2;
        android.support.v4.app.FragmentManagerNonConfig fragmentManagerNonConfig;
        if (this.mActive != null) {
            arrayList = null;
            arrayList2 = null;
            for (int i = 0; i < this.mActive.size(); i++) {
                android.support.v4.app.Fragment fragmentValueAt = this.mActive.valueAt(i);
                if (fragmentValueAt != null) {
                    if (fragmentValueAt.mRetainInstance) {
                        if (arrayList == null) {
                            arrayList = new java.util.ArrayList();
                        }
                        arrayList.add(fragmentValueAt);
                        fragmentValueAt.mTargetIndex = fragmentValueAt.mTarget != null ? fragmentValueAt.mTarget.mIndex : -1;
                        if (DEBUG) {
                            android.util.Log.v(TAG, "retainNonConfig: keeping retained " + fragmentValueAt);
                        }
                    }
                    if (fragmentValueAt.mChildFragmentManager != null) {
                        fragmentValueAt.mChildFragmentManager.saveNonConfig();
                        fragmentManagerNonConfig = fragmentValueAt.mChildFragmentManager.mSavedNonConfig;
                    } else {
                        fragmentManagerNonConfig = fragmentValueAt.mChildNonConfig;
                    }
                    if (arrayList2 == null && fragmentManagerNonConfig != null) {
                        arrayList2 = new java.util.ArrayList(this.mActive.size());
                        for (int i2 = 0; i2 < i; i2++) {
                            arrayList2.add(null);
                        }
                    }
                    if (arrayList2 != null) {
                        arrayList2.add(fragmentManagerNonConfig);
                    }
                }
            }
        } else {
            arrayList = null;
            arrayList2 = null;
        }
        if (arrayList == null && arrayList2 == null) {
            this.mSavedNonConfig = null;
        } else {
            this.mSavedNonConfig = new android.support.v4.app.FragmentManagerNonConfig(arrayList, arrayList2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setBackStackIndex(int i, android.support.v4.app.BackStackRecord backStackRecord) {
        synchronized (this) {
            if (this.mBackStackIndices == null) {
                this.mBackStackIndices = new java.util.ArrayList<>();
            }
            int size = this.mBackStackIndices.size();
            if (i < size) {
                if (DEBUG) {
                    android.util.Log.v(TAG, "Setting back stack index " + i + " to " + backStackRecord);
                }
                this.mBackStackIndices.set(i, backStackRecord);
            } else {
                while (size < i) {
                    this.mBackStackIndices.add(null);
                    if (this.mAvailBackStackIndices == null) {
                        this.mAvailBackStackIndices = new java.util.ArrayList<>();
                    }
                    if (DEBUG) {
                        android.util.Log.v(TAG, "Adding available back stack index " + size);
                    }
                    this.mAvailBackStackIndices.add(java.lang.Integer.valueOf(size));
                    size++;
                }
                if (DEBUG) {
                    android.util.Log.v(TAG, "Adding back stack index " + i + " with " + backStackRecord);
                }
                this.mBackStackIndices.add(backStackRecord);
            }
        }
    }

    public void setPrimaryNavigationFragment(android.support.v4.app.Fragment fragment) {
        if (fragment == null || (this.mActive.get(fragment.mIndex) == fragment && (fragment.mHost == null || fragment.getFragmentManager() == this))) {
            this.mPrimaryNav = fragment;
            return;
        }
        throw new java.lang.IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public void showFragment(android.support.v4.app.Fragment fragment) {
        if (DEBUG) {
            android.util.Log.v(TAG, "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    void startPendingDeferredFragments() {
        if (this.mActive == null) {
            return;
        }
        for (int i = 0; i < this.mActive.size(); i++) {
            android.support.v4.app.Fragment fragmentValueAt = this.mActive.valueAt(i);
            if (fragmentValueAt != null) {
                performPendingDeferredStart(fragmentValueAt);
            }
        }
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(java.lang.Integer.toHexString(java.lang.System.identityHashCode(this)));
        sb.append(" in ");
        android.support.v4.app.Fragment fragment = this.mParent;
        if (fragment != null) {
            android.support.v4.util.DebugUtils.buildShortClassTag(fragment, sb);
        } else {
            android.support.v4.util.DebugUtils.buildShortClassTag(this.mHost, sb);
        }
        sb.append("}}");
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.support.v4.app.FragmentManager
    public void unregisterFragmentLifecycleCallbacks(android.support.v4.app.FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks) {
        synchronized (this.mLifecycleCallbacks) {
            int size = this.mLifecycleCallbacks.size();
            for (int i = 0; i < size; i++) {
                if (this.mLifecycleCallbacks.get(i).first == fragmentLifecycleCallbacks) {
                    this.mLifecycleCallbacks.remove(i);
                    break;
                }
            }
        }
    }
}
