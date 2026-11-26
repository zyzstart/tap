package oicq.wlogin_sdk.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class WloginProvider extends android.content.ContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private oicq.wlogin_sdk.request.WloginProvider.a f1675a;
    private java.lang.String f;
    private android.content.Context h;
    private android.net.Uri j;
    private android.database.sqlite.SQLiteDatabase b = null;
    private final java.lang.String c = "wlogin_provider.db";
    private final int d = 4;
    private final java.lang.String e = "rsa_pubkey";
    private final int g = 1;
    private android.content.UriMatcher i = new android.content.UriMatcher(-1);

    private class a extends android.database.sqlite.SQLiteOpenHelper {
        public a(android.content.Context context, java.lang.String str, android.database.sqlite.SQLiteDatabase.CursorFactory cursorFactory, int i) {
            super(context, str, cursorFactory, i);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(java.lang.String.format("CREATE TABLE %s (id INTEGER PRIMARY KEY AUTOINCREMENT, appid INTEGER, subappid INTEGER, pubkey TEXT, pubkey_md5 TEXT)", "rsa_pubkey"));
            } catch (java.lang.Exception e) {
                oicq.wlogin_sdk.tools.util.printException(e, "");
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS rsa_pubkey");
            onCreate(sQLiteDatabase);
        }
    }

    @Override // android.content.ContentProvider
    public int delete(android.net.Uri uri, java.lang.String str, java.lang.String[] strArr) {
        if (this.i.match(uri) == 1) {
            int iDelete = this.b.delete("rsa_pubkey", str, strArr);
            this.h.getContentResolver().notifyChange(uri, null);
            return iDelete;
        }
        throw new java.lang.IllegalArgumentException("Unnown URI" + uri);
    }

    @Override // android.content.ContentProvider
    public java.lang.String getType(android.net.Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public android.net.Uri insert(android.net.Uri uri, android.content.ContentValues contentValues) {
        if (this.i.match(uri) != 1) {
            throw new java.lang.IllegalArgumentException("Unknown URI " + uri);
        }
        long jInsert = this.b.insert("rsa_pubkey", null, contentValues);
        if (jInsert > 0) {
            android.net.Uri uriWithAppendedId = android.content.ContentUris.withAppendedId(this.j, jInsert);
            this.h.getContentResolver().notifyChange(uriWithAppendedId, null);
            return uriWithAppendedId;
        }
        throw new android.database.SQLException("Failed to insert row into " + uri);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.h = getContext();
        this.f = "oicq.wlogin_sdk.WloginProvider";
        this.j = android.net.Uri.parse("content://" + this.f + "/rsa_pubkey");
        this.i.addURI(this.f, "rsa_pubkey", 1);
        oicq.wlogin_sdk.tools.util.LOGI("oncreated!");
        oicq.wlogin_sdk.request.WloginProvider.a aVar = new oicq.wlogin_sdk.request.WloginProvider.a(this.h, "wlogin_provider.db", null, 4);
        this.f1675a = aVar;
        android.database.sqlite.SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
        this.b = writableDatabase;
        return writableDatabase != null;
    }

    @Override // android.content.ContentProvider
    public android.database.Cursor query(android.net.Uri uri, java.lang.String[] strArr, java.lang.String str, java.lang.String[] strArr2, java.lang.String str2) {
        if (this.i.match(uri) == 1) {
            android.database.Cursor cursorQuery = this.b.query("rsa_pubkey", strArr, str, strArr2, null, null, str2);
            cursorQuery.setNotificationUri(this.h.getContentResolver(), uri);
            return cursorQuery;
        }
        throw new java.lang.IllegalArgumentException("Unnown URI" + uri);
    }

    @Override // android.content.ContentProvider
    public int update(android.net.Uri uri, android.content.ContentValues contentValues, java.lang.String str, java.lang.String[] strArr) {
        if (this.i.match(uri) == 1) {
            return this.b.update("rsa_pubkey", contentValues, str, strArr);
        }
        throw new java.lang.IllegalArgumentException("Unnown URI" + uri);
    }
}
