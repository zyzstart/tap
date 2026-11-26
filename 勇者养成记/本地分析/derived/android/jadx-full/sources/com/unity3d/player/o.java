package com.unity3d.player;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.util.HashMap f1641a = new java.util.HashMap();
    private java.lang.Class b;
    private java.lang.Object c;

    class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public java.lang.Class[] f1642a;
        public java.lang.reflect.Method b = null;

        public a(java.lang.Class[] clsArr) {
            this.f1642a = clsArr;
        }
    }

    public o(java.lang.Class cls, java.lang.Object obj) {
        this.b = null;
        this.c = null;
        this.b = cls;
        this.c = obj;
    }

    private void a(java.lang.String str, com.unity3d.player.o.a aVar) {
        try {
            aVar.b = this.b.getMethod(str, aVar.f1642a);
        } catch (java.lang.Exception e) {
            com.unity3d.player.g.Log(6, "Exception while trying to get method " + str + ". " + e.getLocalizedMessage());
            aVar.b = null;
        }
    }

    public final java.lang.Object a(java.lang.String str, java.lang.Object... objArr) {
        java.lang.StringBuilder sb;
        java.lang.Object objInvoke = null;
        if (this.f1641a.containsKey(str)) {
            com.unity3d.player.o.a aVar = (com.unity3d.player.o.a) this.f1641a.get(str);
            if (aVar.b == null) {
                a(str, aVar);
            }
            if (aVar.b != null) {
                try {
                    objInvoke = objArr.length == 0 ? aVar.b.invoke(this.c, new java.lang.Object[0]) : aVar.b.invoke(this.c, objArr);
                } catch (java.lang.Exception e) {
                    com.unity3d.player.g.Log(6, "Error trying to call delegated method " + str + ". " + e.getLocalizedMessage());
                }
                return objInvoke;
            }
            sb = new java.lang.StringBuilder("Unable to create method: ");
        } else {
            sb = new java.lang.StringBuilder("No definition for method ");
            sb.append(str);
            str = " can be found";
        }
        sb.append(str);
        com.unity3d.player.g.Log(6, sb.toString());
        return null;
    }

    public final void a(java.lang.String str, java.lang.Class[] clsArr) {
        this.f1641a.put(str, new com.unity3d.player.o.a(clsArr));
    }
}
