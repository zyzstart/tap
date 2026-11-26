package com.qq.gdt.action.f;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c {
    public static boolean a(int i, org.json.JSONObject jSONObject) {
        int iG = com.qq.gdt.action.b.a(com.qq.gdt.action.e.a().c()).g();
        if (iG != 0) {
            switch (iG) {
                case 2:
                    return false;
                case 3:
                default:
                    return true;
            }
        }
        if (jSONObject != null) {
            return !"TICKET".equals(jSONObject.optString("actionType"));
        }
        return true;
    }

    public static boolean a(com.qq.gdt.action.a.a aVar) {
        switch (com.qq.gdt.action.b.a(com.qq.gdt.action.e.a().c()).f()) {
            case 0:
                return (aVar == null || aVar.b().equals("TICKET")) ? false : true;
            case 1:
                return aVar != null && com.qq.gdt.action.b.a(com.qq.gdt.action.e.a().c()).a(aVar.b());
            case 2:
                return false;
            case 3:
            default:
                return true;
        }
    }
}
