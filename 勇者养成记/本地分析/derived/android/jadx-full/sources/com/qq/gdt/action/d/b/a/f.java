package com.qq.gdt.action.d.b.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class f implements com.qq.gdt.action.d.b.a.b {
    @Override // com.qq.gdt.action.d.b.a.b
    public com.qq.gdt.action.d.b.i a(com.qq.gdt.action.d.b.a.b.a aVar) throws java.io.IOException {
        java.util.List<java.lang.String> list;
        com.qq.gdt.action.d.b.g gVarA = aVar.a();
        java.util.Map<java.lang.String, java.lang.String> mapD = gVarA.d();
        if (mapD != null) {
            mapD.put("Client-Time", java.lang.String.valueOf(java.lang.System.currentTimeMillis()));
        }
        com.qq.gdt.action.d.b.i iVarA = aVar.a(gVarA);
        java.util.Map<java.lang.String, java.util.List<java.lang.String>> mapD2 = iVarA.d();
        if (mapD2 != null && (list = mapD2.get("Server-Time")) != null && list.size() > 0) {
            try {
                com.qq.gdt.action.h.u.a(java.lang.Long.parseLong(list.get(0)));
            } catch (java.lang.NumberFormatException e) {
                com.qq.gdt.action.h.l.b("fail to parse server time !", e);
            }
        }
        return iVarA;
    }
}
