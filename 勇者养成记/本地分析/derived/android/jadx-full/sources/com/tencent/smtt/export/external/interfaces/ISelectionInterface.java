package com.tencent.smtt.export.external.interfaces;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface ISelectionInterface {
    public static final int CARETSELECTION = 1;
    public static final int EDITABLESELECTION = 4;
    public static final short HELD_FIRST_WIDGET = 0;
    public static final short HELD_NOTHING = -1;
    public static final short HELD_SECOND_WIDGET = 1;
    public static final int INPUTSELECTION = 2;
    public static final int NONESELECTION = 0;
    public static final int NORMALSELECTION = 3;

    java.lang.String getText();

    void hideSelectionView();

    void onRetrieveFingerSearchContextResponse(java.lang.String str, java.lang.String str2, int i);

    void onSelectCancel();

    void onSelectionBegin(android.graphics.Rect rect, android.graphics.Rect rect2, int i, int i2, short s);

    void onSelectionBeginFailed(int i, int i2);

    void onSelectionChange(android.graphics.Rect rect, android.graphics.Rect rect2, int i, int i2, short s);

    void onSelectionDone(android.graphics.Rect rect, boolean z);

    void setText(java.lang.String str, boolean z);

    void updateHelperWidget(android.graphics.Rect rect, android.graphics.Rect rect2);
}
