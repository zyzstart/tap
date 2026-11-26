package com.tencent.ydkqmsp.sdk.g.i;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.content.Context f1384a;

    public a(android.content.Context context) {
        this.f1384a = context;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x003c  */
    /* JADX WARN: Code duplicated, block: B:17:0x0042  */
    /* JADX WARN: Code duplicated, block: B:19:0x0048  */
    public java.lang.String a(int i, java.lang.String str) {
        java.lang.String string;
        android.net.Uri uri;
        android.database.Cursor cursorQuery;
        java.lang.StringBuilder sb;
        java.lang.String str2;
        java.lang.String string2 = null;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    uri = null;
                } else {
                    sb = new java.lang.StringBuilder();
                    str2 = "content://com.vivo.vms.IdProvider/IdentifierId/AAID_";
                }
                cursorQuery = this.f1384a.getContentResolver().query(uri, null, null, null, null);
                if (cursorQuery == null) {
                    com.tencent.ydkqmsp.sdk.base.c.b("return cursor is null,return");
                } else {
                    string2 = cursorQuery.moveToNext() ? cursorQuery.getString(cursorQuery.getColumnIndex(com.qq.gdt.action.ActionUtils.PAYMENT_AMOUNT)) : null;
                    cursorQuery.close();
                }
                return string2;
            }
            sb = new java.lang.StringBuilder();
            str2 = "content://com.vivo.vms.IdProvider/IdentifierId/VAID_";
            sb.append(str2);
            sb.append(str);
            string = sb.toString();
        } else {
            string = "content://com.vivo.vms.IdProvider/IdentifierId/OAID";
        }
        uri = android.net.Uri.parse(string);
        cursorQuery = this.f1384a.getContentResolver().query(uri, null, null, null, null);
        if (cursorQuery == null) {
            com.tencent.ydkqmsp.sdk.base.c.b("return cursor is null,return");
        } else {
            if (cursorQuery.moveToNext()) {
            }
            cursorQuery.close();
        }
        return string2;
    }
}
