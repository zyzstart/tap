package com.soundcloud.android.crop;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class Crop {
    public static final int REQUEST_CROP = 6709;
    public static final int REQUEST_PICK = 9162;
    public static final int RESULT_ERROR = 404;
    private android.content.Intent cropIntent = new android.content.Intent();

    interface Extra {
        public static final java.lang.String ASPECT_X = "aspect_x";
        public static final java.lang.String ASPECT_Y = "aspect_y";
        public static final java.lang.String AS_PNG = "as_png";
        public static final java.lang.String ERROR = "error";
        public static final java.lang.String MAX_X = "max_x";
        public static final java.lang.String MAX_Y = "max_y";
    }

    private Crop(android.net.Uri uri, android.net.Uri uri2) {
        this.cropIntent.setData(uri);
        this.cropIntent.putExtra("output", uri2);
    }

    public static java.lang.Throwable getError(android.content.Intent intent) {
        return (java.lang.Throwable) intent.getSerializableExtra("error");
    }

    private static android.content.Intent getImagePicker() {
        return new android.content.Intent("android.intent.action.GET_CONTENT").setType("image/*");
    }

    public static android.net.Uri getOutput(android.content.Intent intent) {
        return (android.net.Uri) intent.getParcelableExtra("output");
    }

    public static com.soundcloud.android.crop.Crop of(android.net.Uri uri, android.net.Uri uri2) {
        return new com.soundcloud.android.crop.Crop(uri, uri2);
    }

    public static void pickImage(android.app.Activity activity) {
        pickImage(activity, REQUEST_PICK);
    }

    public static void pickImage(android.app.Activity activity, int i) {
        try {
            activity.startActivityForResult(getImagePicker(), i);
        } catch (android.content.ActivityNotFoundException unused) {
            showImagePickerError(activity);
        }
    }

    public static void pickImage(android.content.Context context, android.app.Fragment fragment) {
        pickImage(context, fragment, REQUEST_PICK);
    }

    @android.annotation.TargetApi(11)
    public static void pickImage(android.content.Context context, android.app.Fragment fragment, int i) {
        try {
            fragment.startActivityForResult(getImagePicker(), i);
        } catch (android.content.ActivityNotFoundException unused) {
            showImagePickerError(context);
        }
    }

    public static void pickImage(android.content.Context context, android.support.v4.app.Fragment fragment) {
        pickImage(context, fragment, REQUEST_PICK);
    }

    public static void pickImage(android.content.Context context, android.support.v4.app.Fragment fragment, int i) {
        try {
            fragment.startActivityForResult(getImagePicker(), i);
        } catch (android.content.ActivityNotFoundException unused) {
            showImagePickerError(context);
        }
    }

    private static void showImagePickerError(android.content.Context context) {
        android.widget.Toast.makeText(context.getApplicationContext(), context.getApplicationContext().getResources().getIdentifier("crop__pick_error", "string", context.getApplicationContext().getPackageName()), 0).show();
    }

    public com.soundcloud.android.crop.Crop asPng(boolean z) {
        this.cropIntent.putExtra(com.soundcloud.android.crop.Crop.Extra.AS_PNG, z);
        return this;
    }

    public com.soundcloud.android.crop.Crop asSquare() {
        this.cropIntent.putExtra(com.soundcloud.android.crop.Crop.Extra.ASPECT_X, 1);
        this.cropIntent.putExtra(com.soundcloud.android.crop.Crop.Extra.ASPECT_Y, 1);
        return this;
    }

    public android.content.Intent getIntent(android.content.Context context) {
        this.cropIntent.setClass(context, com.soundcloud.android.crop.CropImageActivity.class);
        return this.cropIntent;
    }

    public void start(android.app.Activity activity) {
        start(activity, REQUEST_CROP);
    }

    public void start(android.app.Activity activity, int i) {
        activity.startActivityForResult(getIntent(activity), i);
    }

    public void start(android.content.Context context, android.app.Fragment fragment) {
        start(context, fragment, REQUEST_CROP);
    }

    @android.annotation.TargetApi(11)
    public void start(android.content.Context context, android.app.Fragment fragment, int i) {
        fragment.startActivityForResult(getIntent(context), i);
    }

    public void start(android.content.Context context, android.support.v4.app.Fragment fragment) {
        start(context, fragment, REQUEST_CROP);
    }

    public void start(android.content.Context context, android.support.v4.app.Fragment fragment, int i) {
        fragment.startActivityForResult(getIntent(context), i);
    }

    public com.soundcloud.android.crop.Crop withAspect(int i, int i2) {
        this.cropIntent.putExtra(com.soundcloud.android.crop.Crop.Extra.ASPECT_X, i);
        this.cropIntent.putExtra(com.soundcloud.android.crop.Crop.Extra.ASPECT_Y, i2);
        return this;
    }

    public com.soundcloud.android.crop.Crop withMaxSize(int i, int i2) {
        this.cropIntent.putExtra(com.soundcloud.android.crop.Crop.Extra.MAX_X, i);
        this.cropIntent.putExtra(com.soundcloud.android.crop.Crop.Extra.MAX_Y, i2);
        return this;
    }
}
