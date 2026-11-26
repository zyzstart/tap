package com.tencent.beacon.model;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.beacon.model.ModuleImpl f204a;

    a(com.tencent.beacon.model.ModuleImpl moduleImpl) {
        this.f204a = moduleImpl;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.tencent.beacon.core.info.c.a(((com.tencent.beacon.core.c) this.f204a).mContext) == null) {
            com.tencent.beacon.core.e.d.b("[model] detail user info is null.", new java.lang.Object[0]);
            return;
        }
        com.tencent.beacon.core.info.e eVarD = com.tencent.beacon.core.info.e.d(((com.tencent.beacon.core.c) this.f204a).mContext);
        java.util.HashMap map = new java.util.HashMap();
        map.put("A9", eVarD.d());
        map.put("A10", eVarD.h());
        map.put("A11", eVarD.g());
        map.put("A12", eVarD.j());
        map.put("A13", this.f204a.getSensor());
        map.put("A14", eVarD.q() + "m");
        map.put("A15", eVarD.o() + "m");
        map.put("A16", this.f204a.getCpuProductorName());
        map.put("A17", eVarD.m(((com.tencent.beacon.core.c) this.f204a).mContext));
        map.put("A18", "");
        map.put("A20", eVarD.p(((com.tencent.beacon.core.c) this.f204a).mContext));
        map.put("A22", this.f204a.hasGPSDevice());
        map.put("A30", this.f204a.getSDCardSize() + "m");
        map.put("A33", eVarD.k(((com.tencent.beacon.core.c) this.f204a).mContext));
        map.put("A52", "" + eVarD.n(((com.tencent.beacon.core.c) this.f204a).mContext));
        map.put("A53", "" + eVarD.e() + "m");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("");
        sb.append(eVarD.m());
        map.put("A54", sb.toString());
        map.put("A55", eVarD.f());
        map.put("A56", eVarD.s() ? "Y" : "N");
        map.put("A57", this.f204a.getSensor2());
        map.put("A58", eVarD.i() ? "Y" : "N");
        map.put("A59", this.f204a.getFreeMem2() + "m");
        map.put("A69", this.f204a.getWifiSSID());
        map.put("A82", this.f204a.getRomFingerPrint());
        com.tencent.beacon.event.UserAction.onUserAction("rqd_model", true, 0L, 0L, map, true);
    }
}
