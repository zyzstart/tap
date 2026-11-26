package android.support.v4.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class FragmentTransition {
    private static final int[] INVERSE_OPS = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8};

    static class FragmentContainerTransition {
        public android.support.v4.app.Fragment firstOut;
        public boolean firstOutIsPop;
        public android.support.v4.app.BackStackRecord firstOutTransaction;
        public android.support.v4.app.Fragment lastIn;
        public boolean lastInIsPop;
        public android.support.v4.app.BackStackRecord lastInTransaction;

        FragmentContainerTransition() {
        }
    }

    FragmentTransition() {
    }

    private static void addSharedElementsWithMatchingNames(java.util.ArrayList<android.view.View> arrayList, android.support.v4.util.ArrayMap<java.lang.String, android.view.View> arrayMap, java.util.Collection<java.lang.String> collection) {
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            android.view.View viewValueAt = arrayMap.valueAt(size);
            if (collection.contains(android.support.v4.view.ViewCompat.getTransitionName(viewValueAt))) {
                arrayList.add(viewValueAt);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:60:0x0090 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:61:0x0092  */
    /* JADX WARN: Code duplicated, block: B:62:0x0095  */
    /* JADX WARN: Code duplicated, block: B:67:0x009f  */
    private static void addToFirstInLastOut(android.support.v4.app.BackStackRecord backStackRecord, android.support.v4.app.BackStackRecord.Op op, android.util.SparseArray<android.support.v4.app.FragmentTransition.FragmentContainerTransition> sparseArray, boolean z, boolean z2) {
        int i;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        android.support.v4.app.FragmentTransition.FragmentContainerTransition fragmentContainerTransitionEnsureContainer;
        boolean z7;
        boolean z8;
        boolean z9;
        android.support.v4.app.Fragment fragment = op.fragment;
        if (fragment == null || (i = fragment.mContainerId) == 0) {
            return;
        }
        int i2 = z ? INVERSE_OPS[op.cmd] : op.cmd;
        boolean z10 = false;
        if (i2 != 1) {
            switch (i2) {
                case 3:
                case 6:
                    if (z2) {
                        z7 = !fragment.mAdded && fragment.mView != null && fragment.mView.getVisibility() == 0 && fragment.mPostponedAlpha >= 0.0f;
                    } else {
                        z7 = fragment.mAdded && !fragment.mHidden;
                    }
                    z6 = z7;
                    z4 = false;
                    z5 = true;
                    break;
                case 4:
                    if (z2) {
                        z8 = fragment.mHiddenChanged && fragment.mAdded && fragment.mHidden;
                    } else {
                        z8 = fragment.mAdded && !fragment.mHidden;
                    }
                    z6 = z8;
                    z4 = false;
                    z5 = true;
                    break;
                case 5:
                    if (z2) {
                        z9 = fragment.mHiddenChanged && !fragment.mHidden && fragment.mAdded;
                    } else {
                        z9 = fragment.mHidden;
                    }
                    z10 = z9;
                    z4 = true;
                    z5 = false;
                    z6 = false;
                    break;
                case 7:
                    if (z2) {
                        z3 = fragment.mIsNewlyAdded;
                    } else if (!fragment.mAdded || fragment.mHidden) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    z10 = z3;
                    z4 = true;
                    z5 = false;
                    z6 = false;
                    break;
                default:
                    z4 = false;
                    z5 = false;
                    z6 = false;
                    break;
            }
        } else {
            if (z2) {
                z3 = fragment.mIsNewlyAdded;
            } else if (fragment.mAdded) {
                z3 = false;
            } else {
                z3 = false;
            }
            z10 = z3;
            z4 = true;
            z5 = false;
            z6 = false;
        }
        android.support.v4.app.FragmentTransition.FragmentContainerTransition fragmentContainerTransition = sparseArray.get(i);
        if (z10) {
            android.support.v4.app.FragmentTransition.FragmentContainerTransition fragmentContainerTransitionEnsureContainer2 = ensureContainer(fragmentContainerTransition, sparseArray, i);
            fragmentContainerTransitionEnsureContainer2.lastIn = fragment;
            fragmentContainerTransitionEnsureContainer2.lastInIsPop = z;
            fragmentContainerTransitionEnsureContainer2.lastInTransaction = backStackRecord;
            fragmentContainerTransitionEnsureContainer = fragmentContainerTransitionEnsureContainer2;
        } else {
            fragmentContainerTransitionEnsureContainer = fragmentContainerTransition;
        }
        if (!z2 && z4) {
            if (fragmentContainerTransitionEnsureContainer != null && fragmentContainerTransitionEnsureContainer.firstOut == fragment) {
                fragmentContainerTransitionEnsureContainer.firstOut = null;
            }
            android.support.v4.app.FragmentManagerImpl fragmentManagerImpl = backStackRecord.mManager;
            if (fragment.mState < 1 && fragmentManagerImpl.mCurState >= 1 && !backStackRecord.mReorderingAllowed) {
                fragmentManagerImpl.makeActive(fragment);
                fragmentManagerImpl.moveToState(fragment, 1, 0, 0, false);
            }
        }
        if (z6 && (fragmentContainerTransitionEnsureContainer == null || fragmentContainerTransitionEnsureContainer.firstOut == null)) {
            fragmentContainerTransitionEnsureContainer = ensureContainer(fragmentContainerTransitionEnsureContainer, sparseArray, i);
            fragmentContainerTransitionEnsureContainer.firstOut = fragment;
            fragmentContainerTransitionEnsureContainer.firstOutIsPop = z;
            fragmentContainerTransitionEnsureContainer.firstOutTransaction = backStackRecord;
        }
        if (z2 || !z5 || fragmentContainerTransitionEnsureContainer == null || fragmentContainerTransitionEnsureContainer.lastIn != fragment) {
            return;
        }
        fragmentContainerTransitionEnsureContainer.lastIn = null;
    }

    public static void calculateFragments(android.support.v4.app.BackStackRecord backStackRecord, android.util.SparseArray<android.support.v4.app.FragmentTransition.FragmentContainerTransition> sparseArray, boolean z) {
        int size = backStackRecord.mOps.size();
        for (int i = 0; i < size; i++) {
            addToFirstInLastOut(backStackRecord, backStackRecord.mOps.get(i), sparseArray, false, z);
        }
    }

    private static android.support.v4.util.ArrayMap<java.lang.String, java.lang.String> calculateNameOverrides(int i, java.util.ArrayList<android.support.v4.app.BackStackRecord> arrayList, java.util.ArrayList<java.lang.Boolean> arrayList2, int i2, int i3) {
        java.util.ArrayList<java.lang.String> arrayList3;
        java.util.ArrayList<java.lang.String> arrayList4;
        android.support.v4.util.ArrayMap<java.lang.String, java.lang.String> arrayMap = new android.support.v4.util.ArrayMap<>();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            android.support.v4.app.BackStackRecord backStackRecord = arrayList.get(i4);
            if (backStackRecord.interactsWith(i)) {
                boolean zBooleanValue = arrayList2.get(i4).booleanValue();
                if (backStackRecord.mSharedElementSourceNames != null) {
                    int size = backStackRecord.mSharedElementSourceNames.size();
                    if (zBooleanValue) {
                        arrayList3 = backStackRecord.mSharedElementSourceNames;
                        arrayList4 = backStackRecord.mSharedElementTargetNames;
                    } else {
                        java.util.ArrayList<java.lang.String> arrayList5 = backStackRecord.mSharedElementSourceNames;
                        arrayList3 = backStackRecord.mSharedElementTargetNames;
                        arrayList4 = arrayList5;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        java.lang.String str = arrayList4.get(i5);
                        java.lang.String str2 = arrayList3.get(i5);
                        java.lang.String strRemove = arrayMap.remove(str2);
                        if (strRemove != null) {
                            arrayMap.put(str, strRemove);
                        } else {
                            arrayMap.put(str, str2);
                        }
                    }
                }
            }
        }
        return arrayMap;
    }

    public static void calculatePopFragments(android.support.v4.app.BackStackRecord backStackRecord, android.util.SparseArray<android.support.v4.app.FragmentTransition.FragmentContainerTransition> sparseArray, boolean z) {
        if (backStackRecord.mManager.mContainer.onHasView()) {
            for (int size = backStackRecord.mOps.size() - 1; size >= 0; size--) {
                addToFirstInLastOut(backStackRecord, backStackRecord.mOps.get(size), sparseArray, true, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void callSharedElementStartEnd(android.support.v4.app.Fragment fragment, android.support.v4.app.Fragment fragment2, boolean z, android.support.v4.util.ArrayMap<java.lang.String, android.view.View> arrayMap, boolean z2) {
        android.support.v4.app.SharedElementCallback enterTransitionCallback = z ? fragment2.getEnterTransitionCallback() : fragment.getEnterTransitionCallback();
        if (enterTransitionCallback != null) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            int size = arrayMap == null ? 0 : arrayMap.size();
            for (int i = 0; i < size; i++) {
                arrayList2.add(arrayMap.keyAt(i));
                arrayList.add(arrayMap.valueAt(i));
            }
            if (z2) {
                enterTransitionCallback.onSharedElementStart(arrayList2, arrayList, null);
            } else {
                enterTransitionCallback.onSharedElementEnd(arrayList2, arrayList, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @android.support.annotation.RequiresApi(21)
    public static android.support.v4.util.ArrayMap<java.lang.String, android.view.View> captureInSharedElements(android.support.v4.util.ArrayMap<java.lang.String, java.lang.String> arrayMap, java.lang.Object obj, android.support.v4.app.FragmentTransition.FragmentContainerTransition fragmentContainerTransition) {
        android.support.v4.app.SharedElementCallback enterTransitionCallback;
        java.util.ArrayList<java.lang.String> arrayList;
        java.lang.String strFindKeyForValue;
        android.support.v4.app.Fragment fragment = fragmentContainerTransition.lastIn;
        android.view.View view = fragment.getView();
        if (arrayMap.isEmpty() || obj == null || view == null) {
            arrayMap.clear();
            return null;
        }
        android.support.v4.util.ArrayMap<java.lang.String, android.view.View> arrayMap2 = new android.support.v4.util.ArrayMap<>();
        android.support.v4.app.FragmentTransitionCompat21.findNamedViews(arrayMap2, view);
        android.support.v4.app.BackStackRecord backStackRecord = fragmentContainerTransition.lastInTransaction;
        if (fragmentContainerTransition.lastInIsPop) {
            enterTransitionCallback = fragment.getExitTransitionCallback();
            arrayList = backStackRecord.mSharedElementSourceNames;
        } else {
            enterTransitionCallback = fragment.getEnterTransitionCallback();
            arrayList = backStackRecord.mSharedElementTargetNames;
        }
        if (arrayList != null) {
            arrayMap2.retainAll(arrayList);
        }
        if (enterTransitionCallback != null) {
            enterTransitionCallback.onMapSharedElements(arrayList, arrayMap2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                java.lang.String str = arrayList.get(size);
                android.view.View view2 = arrayMap2.get(str);
                if (view2 == null) {
                    java.lang.String strFindKeyForValue2 = findKeyForValue(arrayMap, str);
                    if (strFindKeyForValue2 != null) {
                        arrayMap.remove(strFindKeyForValue2);
                    }
                } else if (!str.equals(android.support.v4.view.ViewCompat.getTransitionName(view2)) && (strFindKeyForValue = findKeyForValue(arrayMap, str)) != null) {
                    arrayMap.put(strFindKeyForValue, android.support.v4.view.ViewCompat.getTransitionName(view2));
                }
            }
        } else {
            retainValues(arrayMap, arrayMap2);
        }
        return arrayMap2;
    }

    @android.support.annotation.RequiresApi(21)
    private static android.support.v4.util.ArrayMap<java.lang.String, android.view.View> captureOutSharedElements(android.support.v4.util.ArrayMap<java.lang.String, java.lang.String> arrayMap, java.lang.Object obj, android.support.v4.app.FragmentTransition.FragmentContainerTransition fragmentContainerTransition) {
        android.support.v4.app.SharedElementCallback exitTransitionCallback;
        java.util.ArrayList<java.lang.String> arrayList;
        if (arrayMap.isEmpty() || obj == null) {
            arrayMap.clear();
            return null;
        }
        android.support.v4.app.Fragment fragment = fragmentContainerTransition.firstOut;
        android.support.v4.util.ArrayMap<java.lang.String, android.view.View> arrayMap2 = new android.support.v4.util.ArrayMap<>();
        android.support.v4.app.FragmentTransitionCompat21.findNamedViews(arrayMap2, fragment.getView());
        android.support.v4.app.BackStackRecord backStackRecord = fragmentContainerTransition.firstOutTransaction;
        if (fragmentContainerTransition.firstOutIsPop) {
            exitTransitionCallback = fragment.getEnterTransitionCallback();
            arrayList = backStackRecord.mSharedElementTargetNames;
        } else {
            exitTransitionCallback = fragment.getExitTransitionCallback();
            arrayList = backStackRecord.mSharedElementSourceNames;
        }
        arrayMap2.retainAll(arrayList);
        if (exitTransitionCallback != null) {
            exitTransitionCallback.onMapSharedElements(arrayList, arrayMap2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                java.lang.String str = arrayList.get(size);
                android.view.View view = arrayMap2.get(str);
                if (view == null) {
                    arrayMap.remove(str);
                } else if (!str.equals(android.support.v4.view.ViewCompat.getTransitionName(view))) {
                    arrayMap.put(android.support.v4.view.ViewCompat.getTransitionName(view), arrayMap.remove(str));
                }
            }
        } else {
            arrayMap.retainAll(arrayMap2.keySet());
        }
        return arrayMap2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @android.support.annotation.RequiresApi(21)
    public static java.util.ArrayList<android.view.View> configureEnteringExitingViews(java.lang.Object obj, android.support.v4.app.Fragment fragment, java.util.ArrayList<android.view.View> arrayList, android.view.View view) {
        if (obj == null) {
            return null;
        }
        java.util.ArrayList<android.view.View> arrayList2 = new java.util.ArrayList<>();
        android.view.View view2 = fragment.getView();
        if (view2 != null) {
            android.support.v4.app.FragmentTransitionCompat21.captureTransitioningViews(arrayList2, view2);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        android.support.v4.app.FragmentTransitionCompat21.addTargets(obj, arrayList2);
        return arrayList2;
    }

    @android.support.annotation.RequiresApi(21)
    private static java.lang.Object configureSharedElementsOrdered(android.view.ViewGroup viewGroup, final android.view.View view, final android.support.v4.util.ArrayMap<java.lang.String, java.lang.String> arrayMap, final android.support.v4.app.FragmentTransition.FragmentContainerTransition fragmentContainerTransition, final java.util.ArrayList<android.view.View> arrayList, final java.util.ArrayList<android.view.View> arrayList2, final java.lang.Object obj, java.lang.Object obj2) {
        java.lang.Object obj3;
        android.graphics.Rect rect;
        final android.support.v4.app.Fragment fragment = fragmentContainerTransition.lastIn;
        final android.support.v4.app.Fragment fragment2 = fragmentContainerTransition.firstOut;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        final boolean z = fragmentContainerTransition.lastInIsPop;
        java.lang.Object sharedElementTransition = arrayMap.isEmpty() ? null : getSharedElementTransition(fragment, fragment2, z);
        android.support.v4.util.ArrayMap<java.lang.String, android.view.View> arrayMapCaptureOutSharedElements = captureOutSharedElements(arrayMap, sharedElementTransition, fragmentContainerTransition);
        if (arrayMap.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(arrayMapCaptureOutSharedElements.values());
            obj3 = sharedElementTransition;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        callSharedElementStartEnd(fragment, fragment2, z, arrayMapCaptureOutSharedElements, true);
        if (obj3 != null) {
            android.graphics.Rect rect2 = new android.graphics.Rect();
            android.support.v4.app.FragmentTransitionCompat21.setSharedElementTargets(obj3, view, arrayList);
            setOutEpicenter(obj3, obj2, arrayMapCaptureOutSharedElements, fragmentContainerTransition.firstOutIsPop, fragmentContainerTransition.firstOutTransaction);
            if (obj != null) {
                android.support.v4.app.FragmentTransitionCompat21.setEpicenter(obj, rect2);
            }
            rect = rect2;
        } else {
            rect = null;
        }
        final java.lang.Object obj4 = obj3;
        final android.graphics.Rect rect3 = rect;
        android.support.v4.app.OneShotPreDrawListener.add(viewGroup, new java.lang.Runnable() { // from class: android.support.v4.app.FragmentTransition.4
            @Override // java.lang.Runnable
            public void run() {
                android.support.v4.util.ArrayMap arrayMapCaptureInSharedElements = android.support.v4.app.FragmentTransition.captureInSharedElements(arrayMap, obj4, fragmentContainerTransition);
                if (arrayMapCaptureInSharedElements != null) {
                    arrayList2.addAll(arrayMapCaptureInSharedElements.values());
                    arrayList2.add(view);
                }
                android.support.v4.app.FragmentTransition.callSharedElementStartEnd(fragment, fragment2, z, arrayMapCaptureInSharedElements, false);
                java.lang.Object obj5 = obj4;
                if (obj5 != null) {
                    android.support.v4.app.FragmentTransitionCompat21.swapSharedElementTargets(obj5, arrayList, arrayList2);
                    android.view.View inEpicenterView = android.support.v4.app.FragmentTransition.getInEpicenterView(arrayMapCaptureInSharedElements, fragmentContainerTransition, obj, z);
                    if (inEpicenterView != null) {
                        android.support.v4.app.FragmentTransitionCompat21.getBoundsOnScreen(inEpicenterView, rect3);
                    }
                }
            }
        });
        return obj3;
    }

    @android.support.annotation.RequiresApi(21)
    private static java.lang.Object configureSharedElementsReordered(android.view.ViewGroup viewGroup, android.view.View view, android.support.v4.util.ArrayMap<java.lang.String, java.lang.String> arrayMap, android.support.v4.app.FragmentTransition.FragmentContainerTransition fragmentContainerTransition, java.util.ArrayList<android.view.View> arrayList, java.util.ArrayList<android.view.View> arrayList2, java.lang.Object obj, java.lang.Object obj2) {
        final android.view.View view2;
        final android.graphics.Rect rect;
        final android.support.v4.app.Fragment fragment = fragmentContainerTransition.lastIn;
        final android.support.v4.app.Fragment fragment2 = fragmentContainerTransition.firstOut;
        if (fragment != null) {
            fragment.getView().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        final boolean z = fragmentContainerTransition.lastInIsPop;
        java.lang.Object sharedElementTransition = arrayMap.isEmpty() ? null : getSharedElementTransition(fragment, fragment2, z);
        android.support.v4.util.ArrayMap<java.lang.String, android.view.View> arrayMapCaptureOutSharedElements = captureOutSharedElements(arrayMap, sharedElementTransition, fragmentContainerTransition);
        final android.support.v4.util.ArrayMap<java.lang.String, android.view.View> arrayMapCaptureInSharedElements = captureInSharedElements(arrayMap, sharedElementTransition, fragmentContainerTransition);
        if (arrayMap.isEmpty()) {
            if (arrayMapCaptureOutSharedElements != null) {
                arrayMapCaptureOutSharedElements.clear();
            }
            if (arrayMapCaptureInSharedElements != null) {
                arrayMapCaptureInSharedElements.clear();
            }
            sharedElementTransition = null;
        } else {
            addSharedElementsWithMatchingNames(arrayList, arrayMapCaptureOutSharedElements, arrayMap.keySet());
            addSharedElementsWithMatchingNames(arrayList2, arrayMapCaptureInSharedElements, arrayMap.values());
        }
        if (obj == null && obj2 == null && sharedElementTransition == null) {
            return null;
        }
        callSharedElementStartEnd(fragment, fragment2, z, arrayMapCaptureOutSharedElements, true);
        if (sharedElementTransition != null) {
            arrayList2.add(view);
            android.support.v4.app.FragmentTransitionCompat21.setSharedElementTargets(sharedElementTransition, view, arrayList);
            setOutEpicenter(sharedElementTransition, obj2, arrayMapCaptureOutSharedElements, fragmentContainerTransition.firstOutIsPop, fragmentContainerTransition.firstOutTransaction);
            android.graphics.Rect rect2 = new android.graphics.Rect();
            android.view.View inEpicenterView = getInEpicenterView(arrayMapCaptureInSharedElements, fragmentContainerTransition, obj, z);
            if (inEpicenterView != null) {
                android.support.v4.app.FragmentTransitionCompat21.setEpicenter(obj, rect2);
            }
            rect = rect2;
            view2 = inEpicenterView;
        } else {
            view2 = null;
            rect = null;
        }
        android.support.v4.app.OneShotPreDrawListener.add(viewGroup, new java.lang.Runnable() { // from class: android.support.v4.app.FragmentTransition.3
            @Override // java.lang.Runnable
            public void run() {
                android.support.v4.app.FragmentTransition.callSharedElementStartEnd(fragment, fragment2, z, arrayMapCaptureInSharedElements, false);
                android.view.View view3 = view2;
                if (view3 != null) {
                    android.support.v4.app.FragmentTransitionCompat21.getBoundsOnScreen(view3, rect);
                }
            }
        });
        return sharedElementTransition;
    }

    @android.support.annotation.RequiresApi(21)
    private static void configureTransitionsOrdered(android.support.v4.app.FragmentManagerImpl fragmentManagerImpl, int i, android.support.v4.app.FragmentTransition.FragmentContainerTransition fragmentContainerTransition, android.view.View view, android.support.v4.util.ArrayMap<java.lang.String, java.lang.String> arrayMap) {
        java.lang.Object obj;
        android.view.ViewGroup viewGroup = fragmentManagerImpl.mContainer.onHasView() ? (android.view.ViewGroup) fragmentManagerImpl.mContainer.onFindViewById(i) : null;
        if (viewGroup == null) {
            return;
        }
        android.support.v4.app.Fragment fragment = fragmentContainerTransition.lastIn;
        android.support.v4.app.Fragment fragment2 = fragmentContainerTransition.firstOut;
        boolean z = fragmentContainerTransition.lastInIsPop;
        boolean z2 = fragmentContainerTransition.firstOutIsPop;
        java.lang.Object enterTransition = getEnterTransition(fragment, z);
        java.lang.Object exitTransition = getExitTransition(fragment2, z2);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.lang.Object objConfigureSharedElementsOrdered = configureSharedElementsOrdered(viewGroup, view, arrayMap, fragmentContainerTransition, arrayList, arrayList2, enterTransition, exitTransition);
        if (enterTransition == null && objConfigureSharedElementsOrdered == null) {
            obj = exitTransition;
            if (obj == null) {
                return;
            }
        } else {
            obj = exitTransition;
        }
        java.util.ArrayList<android.view.View> arrayListConfigureEnteringExitingViews = configureEnteringExitingViews(obj, fragment2, arrayList, view);
        java.lang.Object obj2 = (arrayListConfigureEnteringExitingViews == null || arrayListConfigureEnteringExitingViews.isEmpty()) ? null : obj;
        android.support.v4.app.FragmentTransitionCompat21.addTarget(enterTransition, view);
        java.lang.Object objMergeTransitions = mergeTransitions(enterTransition, obj2, objConfigureSharedElementsOrdered, fragment, fragmentContainerTransition.lastInIsPop);
        if (objMergeTransitions != null) {
            java.util.ArrayList arrayList3 = new java.util.ArrayList();
            android.support.v4.app.FragmentTransitionCompat21.scheduleRemoveTargets(objMergeTransitions, enterTransition, arrayList3, obj2, arrayListConfigureEnteringExitingViews, objConfigureSharedElementsOrdered, arrayList2);
            scheduleTargetChange(viewGroup, fragment, view, arrayList2, enterTransition, arrayList3, obj2, arrayListConfigureEnteringExitingViews);
            android.support.v4.app.FragmentTransitionCompat21.setNameOverridesOrdered(viewGroup, arrayList2, arrayMap);
            android.support.v4.app.FragmentTransitionCompat21.beginDelayedTransition(viewGroup, objMergeTransitions);
            android.support.v4.app.FragmentTransitionCompat21.scheduleNameReset(viewGroup, arrayList2, arrayMap);
        }
    }

    @android.support.annotation.RequiresApi(21)
    private static void configureTransitionsReordered(android.support.v4.app.FragmentManagerImpl fragmentManagerImpl, int i, android.support.v4.app.FragmentTransition.FragmentContainerTransition fragmentContainerTransition, android.view.View view, android.support.v4.util.ArrayMap<java.lang.String, java.lang.String> arrayMap) {
        java.lang.Object obj;
        android.view.ViewGroup viewGroup = fragmentManagerImpl.mContainer.onHasView() ? (android.view.ViewGroup) fragmentManagerImpl.mContainer.onFindViewById(i) : null;
        if (viewGroup == null) {
            return;
        }
        android.support.v4.app.Fragment fragment = fragmentContainerTransition.lastIn;
        android.support.v4.app.Fragment fragment2 = fragmentContainerTransition.firstOut;
        boolean z = fragmentContainerTransition.lastInIsPop;
        boolean z2 = fragmentContainerTransition.firstOutIsPop;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.lang.Object enterTransition = getEnterTransition(fragment, z);
        java.lang.Object exitTransition = getExitTransition(fragment2, z2);
        java.lang.Object objConfigureSharedElementsReordered = configureSharedElementsReordered(viewGroup, view, arrayMap, fragmentContainerTransition, arrayList2, arrayList, enterTransition, exitTransition);
        if (enterTransition == null && objConfigureSharedElementsReordered == null) {
            obj = exitTransition;
            if (obj == null) {
                return;
            }
        } else {
            obj = exitTransition;
        }
        java.util.ArrayList<android.view.View> arrayListConfigureEnteringExitingViews = configureEnteringExitingViews(obj, fragment2, arrayList2, view);
        java.util.ArrayList<android.view.View> arrayListConfigureEnteringExitingViews2 = configureEnteringExitingViews(enterTransition, fragment, arrayList, view);
        setViewVisibility(arrayListConfigureEnteringExitingViews2, 4);
        java.lang.Object objMergeTransitions = mergeTransitions(enterTransition, obj, objConfigureSharedElementsReordered, fragment, z);
        if (objMergeTransitions != null) {
            replaceHide(obj, fragment2, arrayListConfigureEnteringExitingViews);
            java.util.ArrayList<java.lang.String> arrayListPrepareSetNameOverridesReordered = android.support.v4.app.FragmentTransitionCompat21.prepareSetNameOverridesReordered(arrayList);
            android.support.v4.app.FragmentTransitionCompat21.scheduleRemoveTargets(objMergeTransitions, enterTransition, arrayListConfigureEnteringExitingViews2, obj, arrayListConfigureEnteringExitingViews, objConfigureSharedElementsReordered, arrayList);
            android.support.v4.app.FragmentTransitionCompat21.beginDelayedTransition(viewGroup, objMergeTransitions);
            android.support.v4.app.FragmentTransitionCompat21.setNameOverridesReordered(viewGroup, arrayList2, arrayList, arrayListPrepareSetNameOverridesReordered, arrayMap);
            setViewVisibility(arrayListConfigureEnteringExitingViews2, 0);
            android.support.v4.app.FragmentTransitionCompat21.swapSharedElementTargets(objConfigureSharedElementsReordered, arrayList2, arrayList);
        }
    }

    private static android.support.v4.app.FragmentTransition.FragmentContainerTransition ensureContainer(android.support.v4.app.FragmentTransition.FragmentContainerTransition fragmentContainerTransition, android.util.SparseArray<android.support.v4.app.FragmentTransition.FragmentContainerTransition> sparseArray, int i) {
        if (fragmentContainerTransition != null) {
            return fragmentContainerTransition;
        }
        android.support.v4.app.FragmentTransition.FragmentContainerTransition fragmentContainerTransition2 = new android.support.v4.app.FragmentTransition.FragmentContainerTransition();
        sparseArray.put(i, fragmentContainerTransition2);
        return fragmentContainerTransition2;
    }

    private static java.lang.String findKeyForValue(android.support.v4.util.ArrayMap<java.lang.String, java.lang.String> arrayMap, java.lang.String str) {
        int size = arrayMap.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(arrayMap.valueAt(i))) {
                return arrayMap.keyAt(i);
            }
        }
        return null;
    }

    @android.support.annotation.RequiresApi(21)
    private static java.lang.Object getEnterTransition(android.support.v4.app.Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return android.support.v4.app.FragmentTransitionCompat21.cloneTransition(z ? fragment.getReenterTransition() : fragment.getEnterTransition());
    }

    @android.support.annotation.RequiresApi(21)
    private static java.lang.Object getExitTransition(android.support.v4.app.Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return android.support.v4.app.FragmentTransitionCompat21.cloneTransition(z ? fragment.getReturnTransition() : fragment.getExitTransition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static android.view.View getInEpicenterView(android.support.v4.util.ArrayMap<java.lang.String, android.view.View> arrayMap, android.support.v4.app.FragmentTransition.FragmentContainerTransition fragmentContainerTransition, java.lang.Object obj, boolean z) {
        android.support.v4.app.BackStackRecord backStackRecord = fragmentContainerTransition.lastInTransaction;
        if (obj == null || arrayMap == null || backStackRecord.mSharedElementSourceNames == null || backStackRecord.mSharedElementSourceNames.isEmpty()) {
            return null;
        }
        return arrayMap.get(z ? backStackRecord.mSharedElementSourceNames.get(0) : backStackRecord.mSharedElementTargetNames.get(0));
    }

    @android.support.annotation.RequiresApi(21)
    private static java.lang.Object getSharedElementTransition(android.support.v4.app.Fragment fragment, android.support.v4.app.Fragment fragment2, boolean z) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        return android.support.v4.app.FragmentTransitionCompat21.wrapTransitionInSet(android.support.v4.app.FragmentTransitionCompat21.cloneTransition(z ? fragment2.getSharedElementReturnTransition() : fragment.getSharedElementEnterTransition()));
    }

    @android.support.annotation.RequiresApi(21)
    private static java.lang.Object mergeTransitions(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, android.support.v4.app.Fragment fragment, boolean z) {
        boolean allowReturnTransitionOverlap;
        if (obj == null || obj2 == null || fragment == null) {
            allowReturnTransitionOverlap = true;
        } else {
            allowReturnTransitionOverlap = z ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap();
        }
        return allowReturnTransitionOverlap ? android.support.v4.app.FragmentTransitionCompat21.mergeTransitionsTogether(obj2, obj, obj3) : android.support.v4.app.FragmentTransitionCompat21.mergeTransitionsInSequence(obj2, obj, obj3);
    }

    @android.support.annotation.RequiresApi(21)
    private static void replaceHide(java.lang.Object obj, android.support.v4.app.Fragment fragment, final java.util.ArrayList<android.view.View> arrayList) {
        if (fragment != null && obj != null && fragment.mAdded && fragment.mHidden && fragment.mHiddenChanged) {
            fragment.setHideReplaced(true);
            android.support.v4.app.FragmentTransitionCompat21.scheduleHideFragmentView(obj, fragment.getView(), arrayList);
            android.support.v4.app.OneShotPreDrawListener.add(fragment.mContainer, new java.lang.Runnable() { // from class: android.support.v4.app.FragmentTransition.1
                @Override // java.lang.Runnable
                public void run() {
                    android.support.v4.app.FragmentTransition.setViewVisibility(arrayList, 4);
                }
            });
        }
    }

    private static void retainValues(android.support.v4.util.ArrayMap<java.lang.String, java.lang.String> arrayMap, android.support.v4.util.ArrayMap<java.lang.String, android.view.View> arrayMap2) {
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            if (!arrayMap2.containsKey(arrayMap.valueAt(size))) {
                arrayMap.removeAt(size);
            }
        }
    }

    @android.support.annotation.RequiresApi(21)
    private static void scheduleTargetChange(android.view.ViewGroup viewGroup, final android.support.v4.app.Fragment fragment, final android.view.View view, final java.util.ArrayList<android.view.View> arrayList, final java.lang.Object obj, final java.util.ArrayList<android.view.View> arrayList2, final java.lang.Object obj2, final java.util.ArrayList<android.view.View> arrayList3) {
        android.support.v4.app.OneShotPreDrawListener.add(viewGroup, new java.lang.Runnable() { // from class: android.support.v4.app.FragmentTransition.2
            @Override // java.lang.Runnable
            public void run() {
                java.lang.Object obj3 = obj;
                if (obj3 != null) {
                    android.support.v4.app.FragmentTransitionCompat21.removeTarget(obj3, view);
                    arrayList2.addAll(android.support.v4.app.FragmentTransition.configureEnteringExitingViews(obj, fragment, arrayList, view));
                }
                if (arrayList3 != null) {
                    if (obj2 != null) {
                        java.util.ArrayList arrayList4 = new java.util.ArrayList();
                        arrayList4.add(view);
                        android.support.v4.app.FragmentTransitionCompat21.replaceTargets(obj2, arrayList3, arrayList4);
                    }
                    arrayList3.clear();
                    arrayList3.add(view);
                }
            }
        });
    }

    @android.support.annotation.RequiresApi(21)
    private static void setOutEpicenter(java.lang.Object obj, java.lang.Object obj2, android.support.v4.util.ArrayMap<java.lang.String, android.view.View> arrayMap, boolean z, android.support.v4.app.BackStackRecord backStackRecord) {
        if (backStackRecord.mSharedElementSourceNames == null || backStackRecord.mSharedElementSourceNames.isEmpty()) {
            return;
        }
        android.view.View view = arrayMap.get(z ? backStackRecord.mSharedElementTargetNames.get(0) : backStackRecord.mSharedElementSourceNames.get(0));
        android.support.v4.app.FragmentTransitionCompat21.setEpicenter(obj, view);
        if (obj2 != null) {
            android.support.v4.app.FragmentTransitionCompat21.setEpicenter(obj2, view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setViewVisibility(java.util.ArrayList<android.view.View> arrayList, int i) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i);
        }
    }

    static void startTransitions(android.support.v4.app.FragmentManagerImpl fragmentManagerImpl, java.util.ArrayList<android.support.v4.app.BackStackRecord> arrayList, java.util.ArrayList<java.lang.Boolean> arrayList2, int i, int i2, boolean z) {
        if (fragmentManagerImpl.mCurState >= 1 && android.os.Build.VERSION.SDK_INT >= 21) {
            android.util.SparseArray sparseArray = new android.util.SparseArray();
            for (int i3 = i; i3 < i2; i3++) {
                android.support.v4.app.BackStackRecord backStackRecord = arrayList.get(i3);
                if (arrayList2.get(i3).booleanValue()) {
                    calculatePopFragments(backStackRecord, sparseArray, z);
                } else {
                    calculateFragments(backStackRecord, sparseArray, z);
                }
            }
            if (sparseArray.size() != 0) {
                android.view.View view = new android.view.View(fragmentManagerImpl.mHost.getContext());
                int size = sparseArray.size();
                for (int i4 = 0; i4 < size; i4++) {
                    int iKeyAt = sparseArray.keyAt(i4);
                    android.support.v4.util.ArrayMap<java.lang.String, java.lang.String> arrayMapCalculateNameOverrides = calculateNameOverrides(iKeyAt, arrayList, arrayList2, i, i2);
                    android.support.v4.app.FragmentTransition.FragmentContainerTransition fragmentContainerTransition = (android.support.v4.app.FragmentTransition.FragmentContainerTransition) sparseArray.valueAt(i4);
                    if (z) {
                        configureTransitionsReordered(fragmentManagerImpl, iKeyAt, fragmentContainerTransition, view, arrayMapCalculateNameOverrides);
                    } else {
                        configureTransitionsOrdered(fragmentManagerImpl, iKeyAt, fragmentContainerTransition, view, arrayMapCalculateNameOverrides);
                    }
                }
            }
        }
    }
}
