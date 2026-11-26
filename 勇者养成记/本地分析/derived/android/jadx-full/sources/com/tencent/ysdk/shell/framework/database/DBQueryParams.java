package com.tencent.ysdk.shell.framework.database;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class DBQueryParams {
    private java.lang.String[] mColumns;
    private java.lang.String mGroupBy;
    private java.lang.String mHaving;
    private java.lang.String mLimit;
    private java.lang.String mOrderBy;
    private java.lang.String mSelection;
    private java.lang.String[] mSelectionArgs;
    private java.lang.String mTable;

    public java.lang.String[] getColumns() {
        return this.mColumns;
    }

    public java.lang.String getGroupBy() {
        return this.mGroupBy;
    }

    public java.lang.String getHaving() {
        return this.mHaving;
    }

    public java.lang.String getLimit() {
        return this.mLimit;
    }

    public java.lang.String getOrderBy() {
        return this.mOrderBy;
    }

    public java.lang.String getSelection() {
        return this.mSelection;
    }

    public java.lang.String[] getSelectionArgs() {
        return this.mSelectionArgs;
    }

    public java.lang.String getTable() {
        return this.mTable;
    }

    public void setColumns(java.lang.String[] strArr) {
        this.mColumns = strArr;
    }

    public void setGroupBy(java.lang.String str) {
        this.mGroupBy = str;
    }

    public void setHaving(java.lang.String str) {
        this.mHaving = str;
    }

    public void setLimit(java.lang.String str) {
        this.mLimit = str;
    }

    public void setOrderBy(java.lang.String str) {
        this.mOrderBy = str;
    }

    public void setSelection(java.lang.String str) {
        this.mSelection = str;
    }

    public void setSelectionArgs(java.lang.String[] strArr) {
        this.mSelectionArgs = strArr;
    }

    public void setTable(java.lang.String str) {
        this.mTable = str;
    }
}
