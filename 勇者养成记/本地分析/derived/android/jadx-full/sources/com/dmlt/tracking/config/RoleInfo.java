package com.dmlt.tracking.config;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class RoleInfo {
    private int level;
    private java.lang.String roleId;
    private java.lang.String roleName;
    private int worldId;

    public RoleInfo(java.lang.String str, int i, int i2, java.lang.String str2) {
        this.roleId = str;
        this.worldId = i;
        this.level = i2;
        this.roleName = str2;
    }

    public int getLevel() {
        return this.level;
    }

    public java.lang.String getRoleId() {
        return this.roleId;
    }

    public java.lang.String getRoleName() {
        return this.roleName;
    }

    public int getWorldId() {
        return this.worldId;
    }
}
