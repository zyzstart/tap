package com.tencent.beaconselfupdate.a.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final java.lang.String[][] f224a;

    static {
        java.lang.String[][] strArr = new java.lang.String[4][];
        f224a = strArr;
        strArr[0] = new java.lang.String[]{"t_event", java.lang.String.format(java.util.Locale.US, "CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s int , %s int , %s int , %s int , %s text)", "t_event", "_id", "_time", "_type", "_prority", "_length", "_datas")};
        f224a[1] = new java.lang.String[]{"t_strategy", java.lang.String.format(java.util.Locale.US, "CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s int unique , %s int , %s blob)", "t_strategy", "_id", "_key", "_ut", "_datas")};
        f224a[2] = new java.lang.String[]{"t_req_data", java.lang.String.format(java.util.Locale.US, "CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s text unique , %s int , %s int , %s blob)", "t_req_data", "_id", "_rid", "_time", "_cnt", "_datas")};
        f224a[3] = new java.lang.String[]{"t_conf", java.lang.String.format(java.util.Locale.US, "CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s text unique , %s text , %s int , %s int)", "t_conf", "_id", "_key", "_value", "_vdate", "_time")};
    }
}
