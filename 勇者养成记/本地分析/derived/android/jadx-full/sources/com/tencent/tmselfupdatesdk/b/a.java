package com.tencent.tmselfupdatesdk.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a implements java.lang.reflect.InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.lang.Object f1150a;

    public a(java.lang.Object obj) {
        this.f1150a = obj;
    }

    private void a(java.lang.Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return;
        }
        android.os.Parcel parcelObtain = android.os.Parcel.obtain();
        for (int i = 0; i < objArr.length; i++) {
            if (objArr[i] != null && !objArr[i].getClass().isPrimitive() && (objArr[i] instanceof android.os.Parcelable)) {
                com.tencent.tmselfupdatesdk.util.c.a(objArr[i]).a("writeToParcel", parcelObtain, 0);
                parcelObtain.setDataPosition(0);
                objArr[i] = com.tencent.tmselfupdatesdk.util.c.a(com.tencent.tmselfupdatesdk.util.c.a(objArr[i].getClass().getName()).b("CREATOR")).a("createFromParcel", parcelObtain).a();
            }
        }
    }

    @Override // java.lang.reflect.InvocationHandler
    public java.lang.Object invoke(java.lang.Object obj, java.lang.reflect.Method method, java.lang.Object[] objArr) {
        a(objArr);
        return com.tencent.tmselfupdatesdk.util.c.a(this.f1150a).a(method.getName(), objArr).a();
    }
}
