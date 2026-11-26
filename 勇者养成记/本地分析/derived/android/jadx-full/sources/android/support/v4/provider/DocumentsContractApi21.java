package android.support.v4.provider;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RequiresApi(21)
class DocumentsContractApi21 {
    private static final java.lang.String TAG = "DocumentFile";

    DocumentsContractApi21() {
    }

    private static void closeQuietly(java.lang.AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (java.lang.RuntimeException e) {
                throw e;
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public static android.net.Uri createDirectory(android.content.Context context, android.net.Uri uri, java.lang.String str) {
        return createFile(context, uri, "vnd.android.document/directory", str);
    }

    public static android.net.Uri createFile(android.content.Context context, android.net.Uri uri, java.lang.String str, java.lang.String str2) {
        try {
            return android.provider.DocumentsContract.createDocument(context.getContentResolver(), uri, str, str2);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static android.net.Uri[] listFiles(android.content.Context context, android.net.Uri uri) {
        android.content.ContentResolver contentResolver = context.getContentResolver();
        android.net.Uri uriBuildChildDocumentsUriUsingTree = android.provider.DocumentsContract.buildChildDocumentsUriUsingTree(uri, android.provider.DocumentsContract.getDocumentId(uri));
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.database.Cursor cursorQuery = null;
        try {
            cursorQuery = contentResolver.query(uriBuildChildDocumentsUriUsingTree, new java.lang.String[]{"document_id"}, null, null, null);
            while (cursorQuery.moveToNext()) {
                arrayList.add(android.provider.DocumentsContract.buildDocumentUriUsingTree(uri, cursorQuery.getString(0)));
            }
        } catch (java.lang.Exception e) {
            android.util.Log.w(TAG, "Failed query: " + e);
        } finally {
            closeQuietly(cursorQuery);
        }
        return (android.net.Uri[]) arrayList.toArray(new android.net.Uri[arrayList.size()]);
    }

    public static android.net.Uri prepareTreeUri(android.net.Uri uri) {
        return android.provider.DocumentsContract.buildDocumentUriUsingTree(uri, android.provider.DocumentsContract.getTreeDocumentId(uri));
    }

    public static android.net.Uri renameTo(android.content.Context context, android.net.Uri uri, java.lang.String str) {
        try {
            return android.provider.DocumentsContract.renameDocument(context.getContentResolver(), uri, str);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }
}
