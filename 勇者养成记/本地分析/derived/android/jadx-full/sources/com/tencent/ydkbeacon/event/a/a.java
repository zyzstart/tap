package com.tencent.ydkbeacon.event.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a implements com.tencent.ydkbeacon.a.d.d {
    private android.database.sqlite.SQLiteDatabase b;
    private android.database.sqlite.SQLiteDatabase c;
    private final android.database.sqlite.SQLiteStatement d;
    private final android.database.sqlite.SQLiteStatement e;
    private long f;
    private long g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tencent.ydkbeacon.event.c.b f1249a = com.tencent.ydkbeacon.event.c.b.a();
    private final java.lang.Object h = new java.lang.Object();
    private final java.lang.Object i = new java.lang.Object();

    public a() {
        com.tencent.ydkbeacon.a.d.c cVar = new com.tencent.ydkbeacon.a.d.c(com.tencent.ydkbeacon.a.c.b.c(com.tencent.ydkbeacon.a.c.c.d().c()));
        this.b = cVar.getWritableDatabase();
        android.database.sqlite.SQLiteDatabase readableDatabase = cVar.getReadableDatabase();
        this.c = readableDatabase;
        this.d = readableDatabase.compileStatement("[REDACTED]");
        this.e = this.c.compileStatement("[REDACTED]");
        this.f = a("t_r_e");
        long jA = a("t_n_e");
        this.g = jA;
        if (this.f == 0 && jA == 0) {
            return;
        }
        java.lang.String str = " realtime: " + this.f + ", normal: " + this.g;
        com.tencent.ydkbeacon.a.e.c.a("[EventDAO]", str, new java.lang.Object[0]);
        com.tencent.ydkbeacon.a.b.d.b().a("607", "[EventDAO]" + str);
    }

    private java.util.List a(android.database.Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        while (cursor.moveToNext()) {
            com.tencent.ydkbeacon.event.a.b bVar = new com.tencent.ydkbeacon.event.a.b();
            bVar.f1250a = cursor.getLong(0);
            bVar.d = cursor.getString(1);
            bVar.b = cursor.getInt(2);
            bVar.c = cursor.getLong(3);
            bVar.e = cursor.getBlob(4);
            arrayList.add((com.tencent.ydkbeacon.event.EventBean) this.f1249a.c().a(bVar));
        }
        if (!cursor.isClosed()) {
            cursor.close();
        }
        return arrayList;
    }

    private void a(boolean z, boolean z2, long j) {
        if (z) {
            synchronized (this.h) {
                try {
                    this.f = z2 ? this.f + j : this.f - j;
                    com.tencent.ydkbeacon.a.e.c.a("[EventDAO]", "current db realtime:%s", java.lang.Long.valueOf(this.f));
                } catch (java.lang.Throwable th) {
                    throw th;
                }
            }
            return;
        }
        synchronized (this.i) {
            try {
                this.g = z2 ? this.g + j : this.g - j;
                com.tencent.ydkbeacon.a.e.c.a("[EventDAO]", "current db normal:%s", java.lang.Long.valueOf(this.g));
            } catch (java.lang.Throwable th2) {
                throw th2;
            }
        }
    }

    public long a(java.lang.String str) {
        long j = -1;
        android.database.Cursor cursorRawQuery = null;
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("SELECT count(?) FROM ");
            sb.append(str);
            java.lang.String string = sb.toString();
            java.lang.String[] strArr = new java.lang.String[1];
            strArr[0] = "_id";
            cursorRawQuery = this.c.rawQuery(string, strArr);
            cursorRawQuery.moveToFirst();
            j = cursorRawQuery.getLong(0);
        } catch (java.lang.Exception e) {
            com.tencent.ydkbeacon.a.b.d dVarB = com.tencent.ydkbeacon.a.b.d.b();
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("type: ");
            sb2.append(str);
            sb2.append(" query err: ");
            sb2.append(e.getMessage());
            dVarB.a("605", sb2.toString(), e);
            com.tencent.ydkbeacon.a.e.c.a(e);
        } finally {
            if (cursorRawQuery != null && !cursorRawQuery.isClosed()) {
                cursorRawQuery.close();
            }
        }
        return j;
    }

    public java.util.List a(@android.support.annotation.NonNull java.lang.String str, java.lang.String str2, int i) {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        java.util.List listA = null;
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(" SELECT * FROM ");
            sb.append(str);
            sb.append(" WHERE ");
            sb.append("_id");
            sb.append(" NOT IN (");
            sb.append(str2);
            sb.append(") ORDER BY ");
            sb.append("_time");
            sb.append(" DESC LIMIT ");
            sb.append(i);
            listA = a(this.c.rawQuery(sb.toString(), null));
        } catch (java.lang.Exception e) {
            com.tencent.ydkbeacon.a.e.c.a(e);
            com.tencent.ydkbeacon.a.b.d.b().a("605", "type: " + str + " query err: " + e.getMessage(), e);
        }
        com.tencent.ydkbeacon.a.e.c.a("[EventDAO]", "query tableName: %s, args: %s", str, str2);
        com.tencent.ydkbeacon.a.e.c.a("[EventDAO]", "query cost time: %s", java.lang.Long.valueOf(java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
        return listA;
    }

    public boolean a(int i) {
        boolean z;
        if (i == 1) {
            synchronized (this.h) {
                z = this.f >= ((long) com.tencent.ydkbeacon.d.b.a().b());
            }
            return z;
        }
        synchronized (this.i) {
            z = this.g >= ((long) com.tencent.ydkbeacon.d.b.a().b());
        }
        return z;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x007a  */
    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "Object.hashCode()" because "this.second" is null
    	at jadx.core.utils.Pair.hashCode(Pair.java:35)
    	at java.base/java.util.HashMap.hash(Unknown Source)
    	at java.base/java.util.HashMap.getNode(Unknown Source)
    	at java.base/java.util.HashMap.containsKey(Unknown Source)
    	at jadx.core.dex.visitors.finaly.traverser.state.TraverserGlobalCommonState.hasBlocksBeenCached(TraverserGlobalCommonState.java:35)
    	at jadx.core.dex.visitors.finaly.traverser.handlers.MergePathActivePathTraverserHandler.handle(MergePathActivePathTraverserHandler.java:174)
    	at jadx.core.dex.visitors.finaly.traverser.handlers.AbstractActivePathTraverserHandler.process(AbstractActivePathTraverserHandler.java:19)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.processHandlerImplementations(TraverserController.java:43)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.advance(TraverserController.java:156)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.process(TraverserController.java:79)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.findCommonInsns(MarkFinallyVisitor.java:404)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.extractFinally(MarkFinallyVisitor.java:284)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.processTryBlock(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:135)
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean a(com.tencent.ydkbeacon.event.EventBean eventBean) {
        boolean z;
        android.database.sqlite.SQLiteStatement sQLiteStatement;
        byte[] bArr;
        if (eventBean == null) {
            return false;
        }
        com.tencent.ydkbeacon.event.a.b bVar = (com.tencent.ydkbeacon.event.a.b) this.f1249a.b().a(eventBean);
        boolean zA = com.tencent.ydkbeacon.event.c.c.a(eventBean.getEventType());
        try {
            try {
                this.b.beginTransactionNonExclusive();
                this.d.clearBindings();
                if (zA) {
                    this.d.bindString(1, bVar.d);
                    this.d.bindLong(2, bVar.b);
                    this.d.bindLong(3, bVar.c);
                    sQLiteStatement = this.d;
                    bArr = bVar.e;
                } else {
                    this.e.bindString(1, bVar.d);
                    this.e.bindLong(2, bVar.b);
                    this.e.bindLong(3, bVar.c);
                    sQLiteStatement = this.e;
                    bArr = bVar.e;
                }
                sQLiteStatement.bindBlob(4, bArr);
                if (zA) {
                    if (this.d.executeInsert() >= 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else if (this.e.executeInsert() >= 0) {
                    z = true;
                } else {
                    z = false;
                }
                try {
                    this.b.setTransactionSuccessful();
                    this.b.endTransaction();
                } catch (java.lang.Exception e) {
                    com.tencent.ydkbeacon.a.b.d.b().a("603", "type: " + zA + " insert err: " + e.getMessage(), e);
                    com.tencent.ydkbeacon.a.e.c.a(e);
                }
            } catch (java.lang.Throwable th) {
                try {
                    this.b.setTransactionSuccessful();
                    this.b.endTransaction();
                } catch (java.lang.Exception e2) {
                    com.tencent.ydkbeacon.a.b.d.b().a("603", "type: " + zA + " insert err: " + e2.getMessage(), e2);
                    com.tencent.ydkbeacon.a.e.c.a(e2);
                }
                throw th;
            }
        } catch (java.lang.Exception e3) {
            com.tencent.ydkbeacon.a.b.d dVarB = com.tencent.ydkbeacon.a.b.d.b();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("type: ");
            sb.append(zA);
            sb.append(" insert err: ");
            sb.append(e3.getMessage());
            dVarB.a("603", sb.toString(), e3);
            com.tencent.ydkbeacon.a.e.c.a(e3);
            try {
                this.b.setTransactionSuccessful();
                this.b.endTransaction();
            } catch (java.lang.Exception e4) {
                com.tencent.ydkbeacon.a.b.d.b().a("603", "type: " + zA + " insert err: " + e4.getMessage(), e4);
                com.tencent.ydkbeacon.a.e.c.a(e4);
            }
            z = false;
        }
        if (z) {
            a(zA, true, 1L);
        } else {
            com.tencent.ydkbeacon.a.b.d.b().a("603", "type: " + zA + " insert result: false");
        }
        return z;
    }

    public boolean a(@android.support.annotation.NonNull java.lang.String str, java.lang.String str2) {
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("_id IN (");
            sb.append(str2);
            sb.append(")");
            int iDelete = this.b.delete(str, sb.toString(), null);
            a(str.equals("t_r_e"), false, iDelete);
            return iDelete >= 0;
        } catch (java.lang.Exception e) {
            com.tencent.ydkbeacon.a.b.d.b().a("606", "type: " + str + " delete err: " + e.getMessage() + " target: " + str2, e);
            com.tencent.ydkbeacon.a.e.c.a(e);
            return false;
        }
    }
}
