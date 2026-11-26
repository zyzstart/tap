package com.dodjoy.permissions;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class ManifestRegisterException extends java.lang.RuntimeException {
    /* JADX WARN: Illegal instructions before constructor call */
    ManifestRegisterException(java.lang.String str) {
        java.lang.String str2;
        if (str == null) {
            str2 = "No permissions are registered in the manifest file";
        } else {
            str2 = str + ": Permissions are not registered in the manifest file";
        }
        super(str2);
    }
}
