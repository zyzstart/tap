package com.tencent.tmapkupdatesdk.internal.logic.protocol.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class GetAppUpdateResponse extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable {
    static java.util.Map cache_appUpdateInfoGroup;
    public java.util.Map appUpdateInfoGroup;
    public java.util.ArrayList appUpdateInfoList;
    public int ret;
    static final /* synthetic */ boolean $assertionsDisabled = !com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.GetAppUpdateResponse.class.desiredAssertionStatus();
    static java.util.ArrayList cache_appUpdateInfoList = new java.util.ArrayList();

    static {
        cache_appUpdateInfoList.add(new com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.AppUpdateInfo());
        cache_appUpdateInfoGroup = new java.util.HashMap();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(new com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.AppUpdateInfo());
        cache_appUpdateInfoGroup.put(0, arrayList);
    }

    public GetAppUpdateResponse() {
        this.ret = 0;
        this.appUpdateInfoList = null;
        this.appUpdateInfoGroup = null;
    }

    public GetAppUpdateResponse(int i, java.util.ArrayList arrayList, java.util.Map map) {
        this.ret = 0;
        this.appUpdateInfoList = null;
        this.appUpdateInfoGroup = null;
        this.ret = i;
        this.appUpdateInfoList = arrayList;
        this.appUpdateInfoGroup = map;
    }

    public java.lang.String className() {
        return "jce.GetAppUpdateResponse";
    }

    public java.lang.Object clone() {
        try {
            return super.clone();
        } catch (java.lang.CloneNotSupportedException unused) {
            if ($assertionsDisabled) {
                return null;
            }
            throw new java.lang.AssertionError();
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void display(java.lang.StringBuilder sb, int i) {
        com.qq.taf.jce.JceDisplayer jceDisplayer = new com.qq.taf.jce.JceDisplayer(sb, i);
        jceDisplayer.display(this.ret, "ret");
        jceDisplayer.display((java.util.Collection) this.appUpdateInfoList, "appUpdateInfoList");
        jceDisplayer.display(this.appUpdateInfoGroup, "appUpdateInfoGroup");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(java.lang.StringBuilder sb, int i) {
        com.qq.taf.jce.JceDisplayer jceDisplayer = new com.qq.taf.jce.JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.ret, true);
        jceDisplayer.displaySimple((java.util.Collection) this.appUpdateInfoList, true);
        jceDisplayer.displaySimple(this.appUpdateInfoGroup, false);
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == null) {
            return false;
        }
        com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.GetAppUpdateResponse getAppUpdateResponse = (com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.GetAppUpdateResponse) obj;
        return com.qq.taf.jce.JceUtil.equals(this.ret, getAppUpdateResponse.ret) && com.qq.taf.jce.JceUtil.equals(this.appUpdateInfoList, getAppUpdateResponse.appUpdateInfoList) && com.qq.taf.jce.JceUtil.equals(this.appUpdateInfoGroup, getAppUpdateResponse.appUpdateInfoGroup);
    }

    public java.lang.String fullClassName() {
        return "com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.GetAppUpdateResponse";
    }

    public java.util.Map getAppUpdateInfoGroup() {
        return this.appUpdateInfoGroup;
    }

    public java.util.ArrayList getAppUpdateInfoList() {
        return this.appUpdateInfoList;
    }

    public int getRet() {
        return this.ret;
    }

    public int hashCode() {
        try {
            throw new java.lang.Exception("Need define key first!");
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(com.qq.taf.jce.JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, true);
        this.appUpdateInfoList = (java.util.ArrayList) jceInputStream.read((java.lang.Object) cache_appUpdateInfoList, 1, true);
        this.appUpdateInfoGroup = (java.util.Map) jceInputStream.read((java.lang.Object) cache_appUpdateInfoGroup, 2, false);
    }

    public void setAppUpdateInfoGroup(java.util.Map map) {
        this.appUpdateInfoGroup = map;
    }

    public void setAppUpdateInfoList(java.util.ArrayList arrayList) {
        this.appUpdateInfoList = arrayList;
    }

    public void setRet(int i) {
        this.ret = i;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        jceOutputStream.write((java.util.Collection) this.appUpdateInfoList, 1);
        java.util.Map map = this.appUpdateInfoGroup;
        if (map != null) {
            jceOutputStream.write(map, 2);
        }
    }
}
