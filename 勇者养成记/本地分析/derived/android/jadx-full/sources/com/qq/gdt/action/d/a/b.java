package com.qq.gdt.action.d.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class b extends com.qq.gdt.action.d.a.a<com.qq.gdt.action.d.a> {
    public b() {
        super(false);
    }

    @Override // com.qq.gdt.action.d.a.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.qq.gdt.action.d.a b(com.qq.gdt.action.d.b.i iVar) throws java.lang.Exception {
        com.qq.gdt.action.d.b.j jVarE;
        com.qq.gdt.action.d.a aVar = new com.qq.gdt.action.d.a(-1, "Unknown message");
        if (iVar != null && (jVarE = iVar.e()) != null) {
            java.lang.String strB = jVarE.b();
            if (!android.text.TextUtils.isEmpty(strB)) {
                org.json.JSONObject jSONObject = new org.json.JSONObject(strB);
                aVar.a(jSONObject.optInt("ret", -1));
                aVar.a(jSONObject.optString("msg", "Unknown message"));
            }
        }
        return aVar;
    }
}
