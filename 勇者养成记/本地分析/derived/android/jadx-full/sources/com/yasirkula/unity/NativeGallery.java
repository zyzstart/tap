package com.yasirkula.unity;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class NativeGallery {
    public static boolean CanSelectMultipleMedia() {
        return android.os.Build.VERSION.SDK_INT >= 18;
    }

    @android.annotation.TargetApi(23)
    public static int CheckPermission(android.content.Context context) {
        if (android.os.Build.VERSION.SDK_INT < 23) {
            return 1;
        }
        return (context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0 && context.checkSelfPermission(com.dodjoy.permissions.Permission.READ_EXTERNAL_STORAGE) == 0) ? 1 : 0;
    }

    private static android.graphics.BitmapFactory.Options GetImageMetadata(java.lang.String str) {
        try {
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            android.graphics.BitmapFactory.decodeFile(str, options);
            return options;
        } catch (java.lang.Exception e) {
            android.util.Log.e("Unity", "Exception:", e);
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0072 A[PHI: r1
  0x0072: PHI (r1v3 android.database.Cursor) = (r1v2 android.database.Cursor), (r1v4 android.database.Cursor) binds: [B:40:0x0070, B:33:0x0065] A[DONT_GENERATE, DONT_INLINE]] */
    private static int GetImageOrientation(android.content.Context context, java.lang.String str) {
        try {
            int attributeInt = new android.media.ExifInterface(str).getAttributeInt("Orientation", 0);
            if (attributeInt != 0) {
                return attributeInt;
            }
        } catch (java.lang.Exception unused) {
        }
        android.database.Cursor cursorQuery = null;
        try {
            cursorQuery = context.getContentResolver().query(android.net.Uri.fromFile(new java.io.File(str)), new java.lang.String[]{com.tencent.ysdk.shell.framework.request.HttpRequest.PARAM_ORIENTATION}, null, null, null);
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                int i = cursorQuery.getInt(cursorQuery.getColumnIndex(com.tencent.ysdk.shell.framework.request.HttpRequest.PARAM_ORIENTATION));
                if (i == 90) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return 6;
                }
                if (i == 180) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return 3;
                }
                if (i == 270) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return 8;
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return 1;
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (java.lang.Exception unused2) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (java.lang.Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
        return 0;
    }

    private static android.graphics.Matrix GetImageOrientationCorrectionMatrix(int i, float f) {
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        switch (i) {
            case 2:
                matrix.postScale(-f, f);
                return matrix;
            case 3:
                matrix.postRotate(180.0f);
                matrix.postScale(f, f);
                return matrix;
            case 4:
                matrix.postScale(f, -f);
                return matrix;
            case 5:
                matrix.postRotate(90.0f);
                matrix.postScale(-f, f);
                return matrix;
            case 6:
                matrix.postRotate(90.0f);
                matrix.postScale(f, f);
                return matrix;
            case 7:
                matrix.postRotate(270.0f);
                matrix.postScale(-f, f);
                return matrix;
            case 8:
                matrix.postRotate(270.0f);
                matrix.postScale(f, f);
                return matrix;
            default:
                matrix.postScale(f, f);
                return matrix;
        }
    }

    public static java.lang.String GetImageProperties(android.content.Context context, java.lang.String str) {
        android.graphics.BitmapFactory.Options optionsGetImageMetadata = GetImageMetadata(str);
        if (optionsGetImageMetadata == null) {
            return "";
        }
        int i = optionsGetImageMetadata.outWidth;
        int i2 = optionsGetImageMetadata.outHeight;
        java.lang.String str2 = optionsGetImageMetadata.outMimeType;
        if (str2 == null) {
            str2 = "";
        }
        int iGetImageOrientation = GetImageOrientation(context, str);
        int i3 = 4;
        if (iGetImageOrientation == 0) {
            i3 = -1;
        } else if (iGetImageOrientation == 1) {
            i3 = 0;
        } else if (iGetImageOrientation == 6) {
            i3 = 1;
        } else if (iGetImageOrientation == 3) {
            i3 = 2;
        } else if (iGetImageOrientation == 8) {
            i3 = 3;
        } else if (iGetImageOrientation != 2) {
            if (iGetImageOrientation == 5) {
                i3 = 5;
            } else if (iGetImageOrientation == 4) {
                i3 = 6;
            } else {
                i3 = iGetImageOrientation == 7 ? 7 : -1;
            }
        }
        if (iGetImageOrientation == 6 || iGetImageOrientation == 8 || iGetImageOrientation == 5 || iGetImageOrientation == 7) {
            i2 = i;
            i = i2;
        }
        return i + ">" + i2 + ">" + str2 + ">" + i3;
    }

    public static java.lang.String GetMediaPath(java.lang.String str) {
        java.lang.String absolutePath = android.os.Environment.getExternalStoragePublicDirectory(android.os.Environment.DIRECTORY_DCIM).getAbsolutePath();
        if (absolutePath.charAt(absolutePath.length() - 1) != java.io.File.separatorChar) {
            absolutePath = absolutePath + java.io.File.separator;
        }
        if (str.charAt(str.length() - 1) == '/' || str.charAt(str.length() - 1) == '\\') {
            str = str.substring(0, str.length() - 1);
        }
        java.lang.String str2 = absolutePath + str + java.io.File.separatorChar;
        new java.io.File(str2).mkdirs();
        return str2;
    }

    @android.annotation.TargetApi(17)
    public static java.lang.String GetVideoProperties(android.content.Context context, java.lang.String str) {
        android.media.MediaMetadataRetriever mediaMetadataRetriever = new android.media.MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        java.lang.String strExtractMetadata = mediaMetadataRetriever.extractMetadata(18);
        java.lang.String strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
        java.lang.String strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(9);
        java.lang.String strExtractMetadata4 = android.os.Build.VERSION.SDK_INT >= 17 ? mediaMetadataRetriever.extractMetadata(24) : "0";
        if (strExtractMetadata == null) {
            strExtractMetadata = "0";
        }
        if (strExtractMetadata2 == null) {
            strExtractMetadata2 = "0";
        }
        if (strExtractMetadata3 == null) {
            strExtractMetadata3 = "0";
        }
        if (strExtractMetadata4 == null) {
            strExtractMetadata4 = "0";
        }
        return strExtractMetadata + ">" + strExtractMetadata2 + ">" + strExtractMetadata3 + ">" + strExtractMetadata4;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x0112 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x010d  */
    public static java.lang.String LoadImageAtPath(android.content.Context context, java.lang.String str, java.lang.String str2, int i) throws java.lang.Throwable {
        android.graphics.Bitmap bitmapDecodeFile;
        java.io.FileOutputStream fileOutputStream;
        android.graphics.BitmapFactory.Options optionsGetImageMetadata = GetImageMetadata(str);
        if (optionsGetImageMetadata == null) {
            return str;
        }
        boolean z = optionsGetImageMetadata.outWidth > i || optionsGetImageMetadata.outHeight > i;
        if (optionsGetImageMetadata.outMimeType != null && !optionsGetImageMetadata.outMimeType.equals("image/jpeg") && !optionsGetImageMetadata.outMimeType.equals("image/png")) {
            z = true;
        }
        int iGetImageOrientation = GetImageOrientation(context, str);
        if (iGetImageOrientation != 1 && iGetImageOrientation != 0) {
            z = true;
        }
        if (!z) {
            return str;
        }
        java.io.FileOutputStream fileOutputStream2 = null;
        fileOutputStream2 = null;
        android.graphics.Bitmap bitmap = null;
        try {
            int i2 = optionsGetImageMetadata.outHeight / 2;
            int i3 = optionsGetImageMetadata.outWidth / 2;
            int i4 = 1;
            while (true) {
                if (i2 / i4 < i && i3 / i4 < i) {
                    break;
                }
                i4 *= 2;
            }
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inSampleSize = i4;
            options.inJustDecodeBounds = false;
            bitmapDecodeFile = android.graphics.BitmapFactory.decodeFile(str, options);
            try {
                float width = bitmapDecodeFile.getWidth() > i ? i / bitmapDecodeFile.getWidth() : 1.0f;
                float height = bitmapDecodeFile.getHeight() > i ? i / bitmapDecodeFile.getHeight() : 1.0f;
                if (width < height) {
                    height = width;
                }
                if (height < 1.0f || (iGetImageOrientation != 1 && iGetImageOrientation != 0)) {
                    android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(bitmapDecodeFile, 0, 0, bitmapDecodeFile.getWidth(), bitmapDecodeFile.getHeight(), GetImageOrientationCorrectionMatrix(iGetImageOrientation, height), true);
                    if (bitmapCreateBitmap != bitmapDecodeFile) {
                        bitmapDecodeFile.recycle();
                        bitmapDecodeFile = bitmapCreateBitmap;
                    }
                }
                fileOutputStream = new java.io.FileOutputStream(str2);
                try {
                    if (optionsGetImageMetadata.outMimeType == null || !optionsGetImageMetadata.outMimeType.equals("image/jpeg")) {
                        bitmapDecodeFile.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                    } else {
                        bitmapDecodeFile.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                    }
                    if (bitmapDecodeFile != null) {
                        bitmapDecodeFile.recycle();
                    }
                    try {
                        fileOutputStream.close();
                    } catch (java.lang.Exception unused) {
                    }
                    return str2;
                } catch (java.lang.Exception e) {
                    e = e;
                    bitmap = bitmapDecodeFile;
                    try {
                        android.util.Log.e("Unity", "Exception:", e);
                        try {
                            java.io.File file = new java.io.File(str2);
                            if (file.exists()) {
                                file.delete();
                            }
                        } catch (java.lang.Exception unused2) {
                        }
                        if (bitmap != null) {
                            bitmap.recycle();
                        }
                        if (fileOutputStream == null) {
                            return str;
                        }
                        try {
                            fileOutputStream.close();
                            return str;
                        } catch (java.lang.Exception unused3) {
                            return str;
                        }
                    } catch (java.lang.Throwable th) {
                        th = th;
                        bitmapDecodeFile = bitmap;
                        fileOutputStream2 = fileOutputStream;
                        if (bitmapDecodeFile != null) {
                            bitmapDecodeFile.recycle();
                        }
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (java.lang.Exception unused4) {
                            }
                        }
                        throw th;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    if (bitmapDecodeFile != null) {
                        bitmapDecodeFile.recycle();
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    throw th;
                }
            } catch (java.lang.Exception e2) {
                e = e2;
                fileOutputStream = null;
            } catch (java.lang.Throwable th3) {
                th = th3;
                if (bitmapDecodeFile != null) {
                    bitmapDecodeFile.recycle();
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                throw th;
            }
        } catch (java.lang.Exception e3) {
            e = e3;
            fileOutputStream = null;
        } catch (java.lang.Throwable th4) {
            th = th4;
            bitmapDecodeFile = null;
        }
    }

    public static void MediaDeleteFile(android.content.Context context, java.lang.String str, boolean z) {
        if (z) {
            context.getContentResolver().delete(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_data=?", new java.lang.String[]{str});
        } else {
            context.getContentResolver().delete(android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI, "_data=?", new java.lang.String[]{str});
        }
    }

    public static void MediaScanFile(android.content.Context context, java.lang.String str) {
        android.media.MediaScannerConnection.scanFile(context, new java.lang.String[]{str}, null, null);
    }

    public static void OpenSettings(android.content.Context context) {
        android.net.Uri uriFromParts = android.net.Uri.fromParts("package", context.getPackageName(), null);
        android.content.Intent intent = new android.content.Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(uriFromParts);
        context.startActivity(intent);
    }

    public static void PickMedia(android.content.Context context, com.yasirkula.unity.NativeGalleryMediaReceiver nativeGalleryMediaReceiver, boolean z, boolean z2, java.lang.String str, java.lang.String str2, int i) {
        if (CheckPermission(context) != 1) {
            if (z2) {
                nativeGalleryMediaReceiver.OnMultipleMediaReceived("");
                return;
            } else {
                nativeGalleryMediaReceiver.OnMediaReceived("");
                return;
            }
        }
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putBoolean(com.yasirkula.unity.NativeGalleryMediaPickerFragment.IMAGE_MODE_ID, z);
        bundle.putBoolean(com.yasirkula.unity.NativeGalleryMediaPickerFragment.SELECT_MULTIPLE_ID, z2);
        bundle.putString(com.yasirkula.unity.NativeGalleryMediaPickerFragment.MIME_ID, str);
        bundle.putString(com.yasirkula.unity.NativeGalleryMediaPickerFragment.TITLE_ID, str2);
        bundle.putInt(com.yasirkula.unity.NativeGalleryMediaPickerFragment.MAX_SIZE, i);
        com.yasirkula.unity.NativeGalleryMediaPickerFragment nativeGalleryMediaPickerFragment = new com.yasirkula.unity.NativeGalleryMediaPickerFragment(nativeGalleryMediaReceiver);
        nativeGalleryMediaPickerFragment.setArguments(bundle);
        ((android.app.Activity) context).getFragmentManager().beginTransaction().add(0, nativeGalleryMediaPickerFragment).commit();
    }

    public static void RequestPermission(android.content.Context context, com.yasirkula.unity.NativeGalleryPermissionReceiver nativeGalleryPermissionReceiver, int i) {
        if (CheckPermission(context) == 1) {
            nativeGalleryPermissionReceiver.OnPermissionResult(1);
        } else if (i == 0) {
            nativeGalleryPermissionReceiver.OnPermissionResult(0);
        } else {
            ((android.app.Activity) context).getFragmentManager().beginTransaction().add(0, new com.yasirkula.unity.NativeGalleryPermissionFragment(nativeGalleryPermissionReceiver)).commit();
        }
    }
}
