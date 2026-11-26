package com.yasirkula.unity;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class NativeGalleryMediaPickerFragment extends android.app.Fragment {
    public static final java.lang.String IMAGE_MODE_ID = "NGMP_IMAGE_MODE";
    public static final java.lang.String MAX_SIZE = "NGMP_MAXSIZE";
    private static final int MEDIA_REQUEST_CODE = 987455;
    public static final java.lang.String MIME_ID = "NGMP_MIME";
    public static final java.lang.String SELECT_MULTIPLE_ID = "NGMP_MULTIPLE";
    public static final java.lang.String TITLE_ID = "NGMP_TITLE";
    private static java.lang.String secondaryStoragePath;
    private int maxSize;
    private final com.yasirkula.unity.NativeGalleryMediaReceiver mediaReceiver;
    private java.util.ArrayList<java.lang.String> savedFiles;
    private boolean selectMultiple;

    public NativeGalleryMediaPickerFragment() {
        this.mediaReceiver = null;
    }

    public NativeGalleryMediaPickerFragment(com.yasirkula.unity.NativeGalleryMediaReceiver nativeGalleryMediaReceiver) {
        this.mediaReceiver = nativeGalleryMediaReceiver;
    }

    @android.annotation.TargetApi(18)
    private void allowMultipleMedia(android.content.Intent intent) {
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0029  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private java.lang.String copyToTempFile(android.net.Uri uri) throws java.lang.Throwable {
        android.database.Cursor cursorQuery;
        java.lang.String string;
        java.lang.String str;
        java.io.FileOutputStream fileOutputStream;
        android.content.ContentResolver contentResolver = getActivity().getContentResolver();
        try {
            cursorQuery = contentResolver.query(uri, null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        string = cursorQuery.getString(cursorQuery.getColumnIndex("_display_name"));
                    } else {
                        string = null;
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            } else {
                string = null;
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            if (string == null || string.length() < 3) {
                string = "temp";
            }
            java.lang.String type = contentResolver.getType(uri);
            if (type != null) {
                str = "." + android.webkit.MimeTypeMap.getSingleton().getExtensionFromMimeType(type);
            } else {
                str = ".tmp";
            }
            if (string.endsWith(str)) {
                string = string.substring(0, string.length() - str.length());
            }
            try {
                java.io.InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uri);
                if (inputStreamOpenInputStream == null) {
                    return null;
                }
                java.lang.String str2 = string + str;
                if (this.savedFiles != null) {
                    java.lang.String str3 = str2;
                    int i = 0;
                    int i2 = 1;
                    while (i < this.savedFiles.size()) {
                        if (this.savedFiles.get(i).equals(str3)) {
                            i2++;
                            str3 = string + i2 + str;
                            i = -1;
                        }
                        i++;
                    }
                    str2 = str3;
                }
                java.io.File file = new java.io.File(getActivity().getCacheDir(), str2);
                try {
                    fileOutputStream = new java.io.FileOutputStream(file, false);
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int i3 = inputStreamOpenInputStream.read(bArr);
                            if (i3 <= 0) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, i3);
                        }
                        if (this.selectMultiple) {
                            if (this.savedFiles == null) {
                                this.savedFiles = new java.util.ArrayList<>();
                            }
                            this.savedFiles.add(str2);
                        }
                        java.lang.String absolutePath = file.getAbsolutePath();
                        fileOutputStream.close();
                        inputStreamOpenInputStream.close();
                        return absolutePath;
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        inputStreamOpenInputStream.close();
                        throw th;
                    }
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                }
            } catch (java.lang.Exception e) {
                android.util.Log.e("Unity", "Exception:", e);
                return null;
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
            cursorQuery = null;
        }
    }

    @android.annotation.TargetApi(18)
    private void fetchPathsOfMultipleMedia(java.util.ArrayList<java.lang.String> arrayList, android.content.Intent intent) {
        if (intent.getClipData() == null) {
            if (intent.getData() != null) {
                arrayList.add(getPathFromURI(intent.getData()));
            }
        } else {
            int itemCount = intent.getClipData().getItemCount();
            for (int i = 0; i < itemCount; i++) {
                arrayList.add(getPathFromURI(intent.getClipData().getItemAt(i).getUri()));
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00de  */
    private java.lang.String getPathFromURI(android.net.Uri uri) throws java.lang.Throwable {
        java.lang.String str;
        java.lang.String[] strArr;
        android.database.Cursor cursorQuery;
        java.lang.String string;
        if (uri == null) {
            return null;
        }
        android.util.Log.d("Unity", "Selected media uri: " + uri.toString());
        try {
            if (android.os.Build.VERSION.SDK_INT < 19 || !android.provider.DocumentsContract.isDocumentUri(getActivity().getApplicationContext(), uri)) {
                str = null;
                strArr = null;
            } else {
                if ("com.android.externalstorage.documents".equals(uri.getAuthority())) {
                    java.lang.String[] strArrSplit = android.provider.DocumentsContract.getDocumentId(uri).split(":");
                    if (!"primary".equalsIgnoreCase(strArrSplit[0])) {
                        return getSecondaryStoragePathFor(strArrSplit[1]);
                    }
                    return android.os.Environment.getExternalStorageDirectory() + java.io.File.separator + strArrSplit[1];
                }
                if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                    uri = android.content.ContentUris.withAppendedId(android.net.Uri.parse("content://downloads/public_downloads"), java.lang.Long.valueOf(android.provider.DocumentsContract.getDocumentId(uri)).longValue());
                    str = null;
                    strArr = null;
                } else if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                    java.lang.String[] strArrSplit2 = android.provider.DocumentsContract.getDocumentId(uri).split(":");
                    java.lang.String str2 = strArrSplit2[0];
                    if ("image".equals(str2)) {
                        uri = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if ("video".equals(str2)) {
                        uri = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if ("audio".equals(str2)) {
                        uri = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    strArr = new java.lang.String[]{strArrSplit2[1]};
                    str = "_id=?";
                } else {
                    str = null;
                    strArr = null;
                }
            }
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                try {
                    cursorQuery = getActivity().getContentResolver().query(uri, new java.lang.String[]{"_data"}, str, strArr, null);
                    if (cursorQuery != null) {
                        try {
                            int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("_data");
                            if (cursorQuery.moveToFirst() && (string = cursorQuery.getString(columnIndexOrThrow)) != null && string.length() > 0) {
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                return string;
                            }
                        } catch (java.lang.Exception unused) {
                            if (cursorQuery != null) {
                            }
                            return copyToTempFile(uri);
                        } catch (java.lang.Throwable th) {
                            th = th;
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            throw th;
                        }
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } catch (java.lang.Exception unused2) {
                    cursorQuery = null;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    cursorQuery = null;
                }
            } else if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
            return copyToTempFile(uri);
        } catch (java.lang.Exception e) {
            android.util.Log.e("Unity", "Exception:", e);
            return null;
        }
    }

    private java.lang.String getSecondaryStoragePathFor(java.lang.String str) {
        java.lang.String str2 = secondaryStoragePath;
        if (str2 != null) {
            if (str2.equals("_NulL_")) {
                return null;
            }
            return secondaryStoragePath + java.io.File.separator + str;
        }
        java.lang.String absolutePath = android.os.Environment.getExternalStorageDirectory().getAbsolutePath();
        java.lang.String str3 = java.lang.System.getenv("SECONDARY_STORAGE");
        if (str3 == null || str3.length() == 0) {
            str3 = java.lang.System.getenv("EXTERNAL_SDCARD_STORAGE");
        }
        if (str3 != null && str3.length() > 0) {
            if (!str3.contains(":")) {
                str3 = str3 + ":";
            }
            for (java.lang.String str4 : str3.split(":")) {
                if (str4 != null && str4.length() > 0) {
                    java.io.File file = new java.io.File(str4);
                    if (file.exists() && file.isDirectory() && file.canRead() && !file.getAbsolutePath().equalsIgnoreCase(absolutePath)) {
                        java.lang.String str5 = file.getAbsolutePath() + java.io.File.separator + str;
                        if (new java.io.File(str5).exists()) {
                            secondaryStoragePath = file.getAbsolutePath();
                            return str5;
                        }
                    }
                }
            }
        }
        for (java.lang.String str6 : new java.lang.String[]{"/storage", "/mnt", "/storage/removable", "/removable", "/data", "/mnt/media_rw", "/mnt/sdcard0"}) {
            try {
                for (java.io.File file2 : new java.io.File(str6).listFiles()) {
                    if (file2.exists() && file2.isDirectory() && file2.canRead() && !file2.getAbsolutePath().equalsIgnoreCase(absolutePath)) {
                        java.lang.String str7 = file2.getAbsolutePath() + java.io.File.separator + str;
                        if (new java.io.File(str7).exists()) {
                            secondaryStoragePath = file2.getAbsolutePath();
                            return str7;
                        }
                    }
                }
            } catch (java.lang.Exception unused) {
            }
        }
        secondaryStoragePath = "_NulL_";
        return null;
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        java.lang.String pathFromURI;
        if (i == MEDIA_REQUEST_CODE) {
            if (this.selectMultiple) {
                java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>();
                if (i2 == -1) {
                    fetchPathsOfMultipleMedia(arrayList, intent);
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (arrayList.get(size) == null || arrayList.get(size).length() == 0 || !new java.io.File(arrayList.get(size)).exists()) {
                        arrayList.remove(size);
                    }
                }
                java.lang.String str = "";
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    str = i3 == 0 ? str + arrayList.get(i3) : str + ">" + arrayList.get(i3);
                }
                com.yasirkula.unity.NativeGalleryMediaReceiver nativeGalleryMediaReceiver = this.mediaReceiver;
                if (nativeGalleryMediaReceiver != null) {
                    nativeGalleryMediaReceiver.OnMultipleMediaReceived(str);
                }
                getFragmentManager().beginTransaction().remove(this).commit();
            } else {
                if (i2 != -1 || (pathFromURI = getPathFromURI(intent.getData())) == null) {
                    pathFromURI = "";
                }
                if (pathFromURI.length() > 0 && !new java.io.File(pathFromURI).exists()) {
                    pathFromURI = "";
                }
                if (pathFromURI.length() > 0) {
                    openCropActivity(pathFromURI);
                } else {
                    com.yasirkula.unity.NativeGalleryMediaReceiver nativeGalleryMediaReceiver2 = this.mediaReceiver;
                    if (nativeGalleryMediaReceiver2 != null) {
                        nativeGalleryMediaReceiver2.OnMediaReceived(pathFromURI);
                    }
                    getFragmentManager().beginTransaction().remove(this).commit();
                }
            }
        }
        if (i == 6709) {
            java.lang.String path = i2 != -1 ? "" : com.soundcloud.android.crop.Crop.getOutput(intent).getPath();
            android.util.Log.e("Unity", "result is " + path);
            com.yasirkula.unity.NativeGalleryMediaReceiver nativeGalleryMediaReceiver3 = this.mediaReceiver;
            if (nativeGalleryMediaReceiver3 != null) {
                nativeGalleryMediaReceiver3.OnMediaReceived(path);
            }
            getFragmentManager().beginTransaction().remove(this).commit();
        }
    }

    @Override // android.app.Fragment
    public void onCreate(android.os.Bundle bundle) {
        android.content.Intent intent;
        super.onCreate(bundle);
        if (this.mediaReceiver == null) {
            getFragmentManager().beginTransaction().remove(this).commit();
            return;
        }
        boolean z = getArguments().getBoolean(IMAGE_MODE_ID);
        java.lang.String string = getArguments().getString(MIME_ID);
        java.lang.String string2 = getArguments().getString(TITLE_ID);
        this.selectMultiple = getArguments().getBoolean(SELECT_MULTIPLE_ID);
        this.maxSize = getArguments().getInt(MAX_SIZE);
        if (this.selectMultiple) {
            intent = new android.content.Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            allowMultipleMedia(intent);
        } else {
            intent = z ? new android.content.Intent("android.intent.action.PICK", android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI) : new android.content.Intent("android.intent.action.PICK", android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
        }
        intent.setType(string);
        if (string2 != null && string2.length() > 0) {
            intent.putExtra("android.intent.extra.TITLE", string2);
        }
        startActivityForResult(android.content.Intent.createChooser(intent, string2), MEDIA_REQUEST_CODE);
    }

    public void openCropActivity(java.lang.String str) {
        com.soundcloud.android.crop.Crop cropAsSquare = com.soundcloud.android.crop.Crop.of(android.net.Uri.fromFile(new java.io.File(str)), android.net.Uri.fromFile(new java.io.File(getActivity().getCacheDir(), "JPEG_" + new java.text.SimpleDateFormat("yyyyMMdd_HHmmss", java.util.Locale.ENGLISH).format(new java.util.Date()) + ".jpg"))).asSquare();
        int i = this.maxSize;
        cropAsSquare.withMaxSize(i, i).start(getActivity(), this);
    }
}
