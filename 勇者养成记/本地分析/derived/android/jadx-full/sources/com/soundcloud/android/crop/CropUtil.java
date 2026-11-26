package com.soundcloud.android.crop;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class CropUtil {
    private static final java.lang.String SCHEME_CONTENT = "content";
    private static final java.lang.String SCHEME_FILE = "file";

    private static class BackgroundJob extends com.soundcloud.android.crop.MonitoredActivity.LifeCycleAdapter implements java.lang.Runnable {
        private final com.soundcloud.android.crop.MonitoredActivity activity;
        private final java.lang.Runnable cleanupRunner = new java.lang.Runnable() { // from class: com.soundcloud.android.crop.CropUtil.BackgroundJob.1
            @Override // java.lang.Runnable
            public void run() {
                com.soundcloud.android.crop.CropUtil.BackgroundJob.this.activity.removeLifeCycleListener(com.soundcloud.android.crop.CropUtil.BackgroundJob.this);
                if (com.soundcloud.android.crop.CropUtil.BackgroundJob.this.dialog.getWindow() != null) {
                    com.soundcloud.android.crop.CropUtil.BackgroundJob.this.dialog.dismiss();
                }
            }
        };
        private final android.app.ProgressDialog dialog;
        private final android.os.Handler handler;
        private final java.lang.Runnable job;

        public BackgroundJob(com.soundcloud.android.crop.MonitoredActivity monitoredActivity, java.lang.Runnable runnable, android.app.ProgressDialog progressDialog, android.os.Handler handler) {
            this.activity = monitoredActivity;
            this.dialog = progressDialog;
            this.job = runnable;
            this.activity.addLifeCycleListener(this);
            this.handler = handler;
        }

        @Override // com.soundcloud.android.crop.MonitoredActivity.LifeCycleAdapter, com.soundcloud.android.crop.MonitoredActivity.LifeCycleListener
        public void onActivityDestroyed(com.soundcloud.android.crop.MonitoredActivity monitoredActivity) {
            this.cleanupRunner.run();
            this.handler.removeCallbacks(this.cleanupRunner);
        }

        @Override // com.soundcloud.android.crop.MonitoredActivity.LifeCycleAdapter, com.soundcloud.android.crop.MonitoredActivity.LifeCycleListener
        public void onActivityStarted(com.soundcloud.android.crop.MonitoredActivity monitoredActivity) {
            this.dialog.show();
        }

        @Override // com.soundcloud.android.crop.MonitoredActivity.LifeCycleAdapter, com.soundcloud.android.crop.MonitoredActivity.LifeCycleListener
        public void onActivityStopped(com.soundcloud.android.crop.MonitoredActivity monitoredActivity) {
            this.dialog.hide();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.job.run();
            } finally {
                this.handler.post(this.cleanupRunner);
            }
        }
    }

    CropUtil() {
    }

    public static void closeSilently(@android.support.annotation.Nullable java.io.Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (java.lang.Throwable unused) {
        }
    }

    public static boolean copyExifRotation(java.io.File file, java.io.File file2) {
        if (file == null || file2 == null) {
            return false;
        }
        try {
            android.media.ExifInterface exifInterface = new android.media.ExifInterface(file.getAbsolutePath());
            android.media.ExifInterface exifInterface2 = new android.media.ExifInterface(file2.getAbsolutePath());
            exifInterface2.setAttribute("Orientation", exifInterface.getAttribute("Orientation"));
            exifInterface2.saveAttributes();
            return true;
        } catch (java.io.IOException e) {
            com.soundcloud.android.crop.Log.e("Error copying Exif data", e);
            return false;
        }
    }

    public static int getExifRotation(java.io.File file) {
        if (file == null) {
            return 0;
        }
        try {
            int attributeInt = new android.media.ExifInterface(file.getAbsolutePath()).getAttributeInt("Orientation", 0);
            if (attributeInt == 3) {
                return oicq.wlogin_sdk.tools.util.S_ROLL_BACK;
            }
            if (attributeInt != 6) {
                return attributeInt != 8 ? 0 : 270;
            }
            return 90;
        } catch (java.io.IOException e) {
            com.soundcloud.android.crop.Log.e("Error getting Exif data", e);
            return 0;
        }
    }

    @android.support.annotation.Nullable
    public static java.io.File getFromMediaUri(android.content.Context context, android.content.ContentResolver contentResolver, android.net.Uri uri) throws java.lang.Throwable {
        android.database.Cursor cursorQuery;
        android.database.Cursor cursor = null;
        if (uri == null) {
            return null;
        }
        if (SCHEME_FILE.equals(uri.getScheme())) {
            return new java.io.File(uri.getPath());
        }
        if (SCHEME_CONTENT.equals(uri.getScheme())) {
            try {
                try {
                    cursorQuery = contentResolver.query(uri, new java.lang.String[]{"_data", "_display_name"}, null, null, null);
                    if (cursorQuery != null) {
                        try {
                            if (cursorQuery.moveToFirst()) {
                                int columnIndex = uri.toString().startsWith("content://com.google.android.gallery3d") ? cursorQuery.getColumnIndex("_display_name") : cursorQuery.getColumnIndex("_data");
                                if (columnIndex != -1) {
                                    java.lang.String string = cursorQuery.getString(columnIndex);
                                    if (!android.text.TextUtils.isEmpty(string)) {
                                        java.io.File file = new java.io.File(string);
                                        if (cursorQuery != null) {
                                            cursorQuery.close();
                                        }
                                        return file;
                                    }
                                }
                            }
                        } catch (java.lang.IllegalArgumentException unused) {
                            cursor = cursorQuery;
                            java.io.File fromMediaUriPfd = getFromMediaUriPfd(context, contentResolver, uri);
                            if (cursor != null) {
                                cursor.close();
                            }
                            return fromMediaUriPfd;
                        } catch (java.lang.SecurityException unused2) {
                            if (cursorQuery != null) {
                            }
                            return null;
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
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    cursorQuery = cursor;
                }
            } catch (java.lang.IllegalArgumentException unused3) {
            } catch (java.lang.SecurityException unused4) {
                cursorQuery = null;
            }
        }
        return null;
    }

    @android.support.annotation.Nullable
    private static java.io.File getFromMediaUriPfd(android.content.Context context, android.content.ContentResolver contentResolver, android.net.Uri uri) throws java.lang.Throwable {
        java.io.FileInputStream fileInputStream;
        java.io.FileOutputStream fileOutputStream;
        java.io.FileOutputStream fileOutputStream2 = null;
        if (uri == null) {
            return null;
        }
        try {
            fileInputStream = new java.io.FileInputStream(contentResolver.openFileDescriptor(uri, "r").getFileDescriptor());
            try {
                java.lang.String tempFilename = getTempFilename(context);
                fileOutputStream = new java.io.FileOutputStream(tempFilename);
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i = fileInputStream.read(bArr);
                        if (i == -1) {
                            java.io.File file = new java.io.File(tempFilename);
                            closeSilently(fileInputStream);
                            closeSilently(fileOutputStream);
                            return file;
                        }
                        fileOutputStream.write(bArr, 0, i);
                    }
                } catch (java.io.IOException unused) {
                    closeSilently(fileInputStream);
                    closeSilently(fileOutputStream);
                    return null;
                } catch (java.lang.Throwable th) {
                    th = th;
                    fileOutputStream2 = fileOutputStream;
                    closeSilently(fileInputStream);
                    closeSilently(fileOutputStream2);
                    throw th;
                }
            } catch (java.io.IOException unused2) {
                fileOutputStream = null;
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.io.IOException unused3) {
            fileOutputStream = null;
            fileInputStream = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    private static java.lang.String getTempFilename(android.content.Context context) throws java.io.IOException {
        return java.io.File.createTempFile("image", "tmp", context.getCacheDir()).getAbsolutePath();
    }

    public static void startBackgroundJob(com.soundcloud.android.crop.MonitoredActivity monitoredActivity, java.lang.String str, java.lang.String str2, java.lang.Runnable runnable, android.os.Handler handler) {
        new java.lang.Thread(new com.soundcloud.android.crop.CropUtil.BackgroundJob(monitoredActivity, runnable, android.app.ProgressDialog.show(monitoredActivity, str, str2, true, false), handler)).start();
    }
}
