package com.qq.gdt.action.h;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class e {
    public static void a() {
        android.content.SharedPreferences.Editor editorEdit = com.qq.gdt.action.e.a().c().getApplicationContext().getSharedPreferences("BuglySdkInfos", 0).edit();
        editorEdit.putString("f11874d335", com.qq.gdt.action.f.a());
        editorEdit.commit();
    }
}
