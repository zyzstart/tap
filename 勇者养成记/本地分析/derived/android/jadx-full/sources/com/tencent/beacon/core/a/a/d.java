package com.tencent.beacon.core.a.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f127a = 30;
    public static final java.lang.String[][] b;

    static {
        java.lang.String[][] strArr = new java.lang.String[7][];
        b = strArr;
        strArr[0] = new java.lang.String[]{"t_event", java.lang.String.format(java.util.Locale.US, "CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s int , %s int , %s int , %s int , %s blob)", "t_event", "_id", "_time", "_type", "_prority", "_length", "_datas")};
        b[1] = new java.lang.String[]{"t_count_event", java.lang.String.format(java.util.Locale.US, "CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s varchar(255) unique  , %s int , %s int , %s int , %s int , %s int , %s text)", "t_count_event", "_id", "_countid", "_prority", "_local", "_stime", "_utime", "_ctime", "_cparams")};
        b[2] = new java.lang.String[]{"t_strategy", java.lang.String.format(java.util.Locale.US, "CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s int unique , %s int , %s blob)", "t_strategy", "_id", "_key", "_ut", "_datas")};
        b[3] = new java.lang.String[]{"t_file", java.lang.String.format(java.util.Locale.US, "CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s text , %s int , %s int , %s text , %s text , %s text , %s text)", "t_file", "_id", "_n", "_ut", "_sz", "_ac", "_sa", "_t", "_p")};
        b[4] = new java.lang.String[]{"t_req_data", java.lang.String.format(java.util.Locale.US, "CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s text unique , %s int , %s int , %s blob)", "t_req_data", "_id", "_rid", "_time", "_cnt", "_datas")};
        b[5] = new java.lang.String[]{"t_apple", java.lang.String.format(java.util.Locale.US, "CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s blob unique , %s int , %s int, %s int)", "t_apple", "_id", "_a", "_b", "_c", "_d")};
        b[6] = new java.lang.String[]{"t_conf", java.lang.String.format(java.util.Locale.US, "CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s text unique , %s text , %s int , %s int)", "t_conf", "_id", "_key", "_value", "_vdate", "_time")};
    }
}
