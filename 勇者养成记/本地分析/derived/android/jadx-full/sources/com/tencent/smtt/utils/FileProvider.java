package com.tencent.smtt.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class FileProvider extends android.content.ContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final java.lang.String[] f953a = {"_display_name", "_size"};
    private static final java.io.File b = new java.io.File("/");
    private static java.util.HashMap c = new java.util.HashMap();
    private com.tencent.smtt.utils.FileProvider.a d;

    interface a {
        android.net.Uri a(java.io.File file);

        java.io.File a(android.net.Uri uri);
    }

    static class b implements com.tencent.smtt.utils.FileProvider.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final java.lang.String f954a;
        private final java.util.HashMap b = new java.util.HashMap();

        public b(java.lang.String str) {
            this.f954a = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.tencent.smtt.utils.FileProvider.a
        public android.net.Uri a(java.io.File file) {
            try {
                java.lang.String canonicalPath = file.getCanonicalPath();
                java.util.Map.Entry entry = null;
                for (java.util.Map.Entry entry2 : this.b.entrySet()) {
                    java.lang.String path = ((java.io.File) entry2.getValue()).getPath();
                    if (canonicalPath.startsWith(path) && (entry == null || path.length() > ((java.io.File) entry.getValue()).getPath().length())) {
                        entry = entry2;
                    }
                }
                if (entry == null) {
                    throw new java.lang.IllegalArgumentException("Failed to find configured root that contains " + canonicalPath);
                }
                java.lang.String path2 = ((java.io.File) entry.getValue()).getPath();
                return new android.net.Uri.Builder().scheme("content").authority(this.f954a).encodedPath(android.net.Uri.encode((java.lang.String) entry.getKey()) + '/' + android.net.Uri.encode(canonicalPath.substring(path2.endsWith("/") ? path2.length() : path2.length() + 1), "/")).build();
            } catch (java.io.IOException unused) {
                throw new java.lang.IllegalArgumentException("Failed to resolve canonical path for " + file);
            }
        }

        @Override // com.tencent.smtt.utils.FileProvider.a
        public java.io.File a(android.net.Uri uri) {
            java.lang.String encodedPath = uri.getEncodedPath();
            int iIndexOf = encodedPath.indexOf(47, 1);
            java.lang.String strDecode = android.net.Uri.decode(encodedPath.substring(1, iIndexOf));
            java.lang.String strDecode2 = android.net.Uri.decode(encodedPath.substring(iIndexOf + 1));
            java.io.File file = (java.io.File) this.b.get(strDecode);
            if (file == null) {
                throw new java.lang.IllegalArgumentException("Unable to find configured root for " + uri);
            }
            java.io.File file2 = new java.io.File(file, strDecode2);
            try {
                java.io.File canonicalFile = file2.getCanonicalFile();
                if (canonicalFile.getPath().startsWith(file.getPath())) {
                    return canonicalFile;
                }
                throw new java.lang.SecurityException("Resolved path jumped beyond configured root");
            } catch (java.io.IOException unused) {
                throw new java.lang.IllegalArgumentException("Failed to resolve canonical path for " + file2);
            }
        }

        public void a(java.lang.String str, java.io.File file) {
            if (android.text.TextUtils.isEmpty(str)) {
                throw new java.lang.IllegalArgumentException("Name must not be empty");
            }
            try {
                this.b.put(str, file.getCanonicalFile());
            } catch (java.io.IOException e) {
                throw new java.lang.IllegalArgumentException("Failed to resolve canonical path for " + file, e);
            }
        }
    }

    private static int a(java.lang.String str) {
        if ("r".equals(str)) {
            return 268435456;
        }
        if ("w".equals(str) || "wt".equals(str)) {
            return 738197504;
        }
        if ("wa".equals(str)) {
            return 704643072;
        }
        if ("rw".equals(str)) {
            return 939524096;
        }
        if ("rwt".equals(str)) {
            return 1006632960;
        }
        throw new java.lang.IllegalArgumentException("Invalid mode: " + str);
    }

    static android.net.Uri a(android.content.Context context, java.io.File file) {
        java.lang.reflect.Method declaredMethod;
        java.lang.String str = "";
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            try {
                str = context.getPackageManager().getProviderInfo(new android.content.ComponentName(context.getPackageName(), "android.support.v4.content.FileProvider"), 0).authority;
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
            if (!android.text.TextUtils.isEmpty(str)) {
                try {
                    java.lang.Class<?> cls = java.lang.Class.forName("android.support.v4.content.FileProvider");
                    if (cls != null && (declaredMethod = cls.getDeclaredMethod("getUriForFile", android.content.Context.class, java.lang.String.class, java.io.File.class)) != null) {
                        java.lang.Object objInvoke = declaredMethod.invoke(null, context, str, file);
                        if (objInvoke instanceof android.net.Uri) {
                            return (android.net.Uri) objInvoke;
                        }
                    }
                } catch (java.lang.Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return null;
    }

    public static android.net.Uri a(android.content.Context context, java.lang.String str) {
        android.net.Uri uriA = null;
        if (context != null && context.getApplicationContext() != null && "com.tencent.mobileqq".equals(context.getApplicationContext().getApplicationInfo().packageName)) {
            try {
                return (android.net.Uri) com.tencent.smtt.utils.k.a((java.lang.Class) java.lang.Class.forName("com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper"), "getUriForFile", new java.lang.Class[]{android.content.Context.class, java.io.File.class}, context, new java.io.File(str));
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        if (context != null && context.getApplicationInfo().targetSdkVersion >= 24 && android.os.Build.VERSION.SDK_INT >= 24 && (uriA = a(context, new java.io.File(str))) == null && com.tencent.smtt.sdk.QbSdk.checkContentProviderPrivilage(context)) {
            uriA = a(context, context.getApplicationInfo().packageName + ".provider", new java.io.File(str));
        }
        if (uriA != null) {
            return uriA;
        }
        try {
            return android.net.Uri.fromFile(new java.io.File(str));
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            android.util.Log.e("FileProvider", "create uri failed,please check again");
            return uriA;
        }
    }

    public static android.net.Uri a(android.content.Context context, java.lang.String str, java.io.File file) {
        return b(context, str).a(file);
    }

    private static java.io.File a(java.io.File file, java.lang.String... strArr) {
        for (java.lang.String str : strArr) {
            if (str != null) {
                file = new java.io.File(file, str);
            }
        }
        return file;
    }

    private static java.lang.Object[] a(java.lang.Object[] objArr, int i) {
        java.lang.Object[] objArr2 = new java.lang.Object[i];
        java.lang.System.arraycopy(objArr, 0, objArr2, 0, i);
        return objArr2;
    }

    private static java.lang.String[] a(java.lang.String[] strArr, int i) {
        java.lang.String[] strArr2 = new java.lang.String[i];
        java.lang.System.arraycopy(strArr, 0, strArr2, 0, i);
        return strArr2;
    }

    private static com.tencent.smtt.utils.FileProvider.a b(android.content.Context context, java.lang.String str) {
        com.tencent.smtt.utils.FileProvider.a aVarC;
        synchronized (c) {
            aVarC = (com.tencent.smtt.utils.FileProvider.a) c.get(str);
            if (aVarC == null) {
                try {
                    aVarC = c(context, str);
                    c.put(str, aVarC);
                } catch (java.io.IOException e) {
                    throw new java.lang.IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e);
                } catch (org.xmlpull.v1.XmlPullParserException e2) {
                    throw new java.lang.IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e2);
                }
            }
        }
        return aVarC;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0081 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x001d A[SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static com.tencent.smtt.utils.FileProvider.a c(android.content.Context context, java.lang.String str) {
        java.io.File externalStorageDirectory;
        java.lang.String[] strArr;
        com.tencent.smtt.utils.FileProvider.b bVar = new com.tencent.smtt.utils.FileProvider.b(str);
        android.content.pm.ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider(str, 128);
        if (providerInfoResolveContentProvider == null) {
            throw new java.lang.RuntimeException("Must declare com.tencent.smtt.utils.FileProvider in AndroidManifest above Android 7.0,please view document in x5.tencent.com");
        }
        android.content.res.XmlResourceParser xmlResourceParserLoadXmlMetaData = providerInfoResolveContentProvider.loadXmlMetaData(context.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
        if (xmlResourceParserLoadXmlMetaData == null) {
            throw new java.lang.IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
        }
        while (true) {
            int next = xmlResourceParserLoadXmlMetaData.next();
            if (next == 1) {
                return bVar;
            }
            if (next == 2) {
                java.lang.String name = xmlResourceParserLoadXmlMetaData.getName();
                java.io.File fileA = null;
                java.lang.String attributeValue = xmlResourceParserLoadXmlMetaData.getAttributeValue(null, "name");
                java.lang.String attributeValue2 = xmlResourceParserLoadXmlMetaData.getAttributeValue(null, "path");
                if ("root-path".equals(name)) {
                    externalStorageDirectory = b;
                    strArr = new java.lang.String[]{attributeValue2};
                } else if ("files-path".equals(name)) {
                    externalStorageDirectory = context.getFilesDir();
                    strArr = new java.lang.String[]{attributeValue2};
                } else if ("cache-path".equals(name)) {
                    externalStorageDirectory = context.getCacheDir();
                    strArr = new java.lang.String[]{attributeValue2};
                } else if ("external-path".equals(name)) {
                    externalStorageDirectory = android.os.Environment.getExternalStorageDirectory();
                    strArr = new java.lang.String[]{attributeValue2};
                } else if (fileA != null) {
                    bVar.a(attributeValue, fileA);
                }
                fileA = a(externalStorageDirectory, strArr);
                if (fileA != null) {
                    bVar.a(attributeValue, fileA);
                }
            }
        }
    }

    @Override // android.content.ContentProvider
    public void attachInfo(android.content.Context context, android.content.pm.ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new java.lang.SecurityException("Provider must not be exported");
        }
        if (!providerInfo.grantUriPermissions) {
            throw new java.lang.SecurityException("Provider must grant uri permissions");
        }
        this.d = b(context, providerInfo.authority);
    }

    @Override // android.content.ContentProvider
    public int delete(android.net.Uri uri, java.lang.String str, java.lang.String[] strArr) {
        return this.d.a(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    public java.lang.String getType(android.net.Uri uri) {
        java.io.File fileA = this.d.a(uri);
        int iLastIndexOf = fileA.getName().lastIndexOf(46);
        if (iLastIndexOf < 0) {
            return "application/octet-stream";
        }
        java.lang.String mimeTypeFromExtension = android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileA.getName().substring(iLastIndexOf + 1));
        return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public android.net.Uri insert(android.net.Uri uri, android.content.ContentValues contentValues) {
        throw new java.lang.UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public android.os.ParcelFileDescriptor openFile(android.net.Uri uri, java.lang.String str) {
        return android.os.ParcelFileDescriptor.open(this.d.a(uri), a(str));
    }

    @Override // android.content.ContentProvider
    public android.database.Cursor query(android.net.Uri uri, java.lang.String[] strArr, java.lang.String str, java.lang.String[] strArr2, java.lang.String str2) {
        int i;
        java.io.File fileA = this.d.a(uri);
        if (strArr == null) {
            strArr = f953a;
        }
        java.lang.String[] strArr3 = new java.lang.String[strArr.length];
        java.lang.Object[] objArr = new java.lang.Object[strArr.length];
        int i2 = 0;
        for (java.lang.String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i2] = "_display_name";
                i = i2 + 1;
                objArr[i2] = fileA.getName();
            } else {
                if ("_size".equals(str3)) {
                    strArr3[i2] = "_size";
                    i = i2 + 1;
                    objArr[i2] = java.lang.Long.valueOf(fileA.length());
                }
            }
            i2 = i;
        }
        java.lang.String[] strArrA = a(strArr3, i2);
        java.lang.Object[] objArrA = a(objArr, i2);
        android.database.MatrixCursor matrixCursor = new android.database.MatrixCursor(strArrA, 1);
        matrixCursor.addRow(objArrA);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(android.net.Uri uri, android.content.ContentValues contentValues, java.lang.String str, java.lang.String[] strArr) {
        throw new java.lang.UnsupportedOperationException("No external updates");
    }
}
