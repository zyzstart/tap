package com.tencent.connect.avatar;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ImageActivity extends android.app.Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    android.widget.RelativeLayout f484a;
    private com.tencent.connect.auth.QQToken b;
    private java.lang.String c;
    private android.os.Handler d;
    private com.tencent.connect.avatar.c e;
    private android.widget.Button f;
    private android.widget.Button g;
    private com.tencent.connect.avatar.b h;
    private android.widget.TextView i;
    private android.widget.ProgressBar j;
    private java.lang.String r;
    private android.graphics.Bitmap s;
    private int k = 0;
    private boolean l = false;
    private long m = 0;
    private int n = 0;
    private final int o = 640;
    private final int p = 640;
    private android.graphics.Rect q = new android.graphics.Rect();
    private final android.view.View.OnClickListener t = new android.view.View.OnClickListener() { // from class: com.tencent.connect.avatar.ImageActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            com.tencent.connect.avatar.ImageActivity imageActivity;
            java.lang.String str;
            com.tencent.connect.avatar.ImageActivity.this.j.setVisibility(0);
            com.tencent.connect.avatar.ImageActivity.this.g.setEnabled(false);
            com.tencent.connect.avatar.ImageActivity.this.g.setTextColor(android.graphics.Color.rgb(21, 21, 21));
            com.tencent.connect.avatar.ImageActivity.this.f.setEnabled(false);
            com.tencent.connect.avatar.ImageActivity.this.f.setTextColor(android.graphics.Color.rgb(36, 94, 134));
            new java.lang.Thread(new java.lang.Runnable() { // from class: com.tencent.connect.avatar.ImageActivity.2.1
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.connect.avatar.ImageActivity.this.c();
                }
            }).start();
            if (com.tencent.connect.avatar.ImageActivity.this.l) {
                imageActivity = com.tencent.connect.avatar.ImageActivity.this;
                str = "10657";
            } else {
                com.tencent.connect.avatar.ImageActivity.this.a("10655", java.lang.System.currentTimeMillis() - com.tencent.connect.avatar.ImageActivity.this.m);
                if (!com.tencent.connect.avatar.ImageActivity.this.e.b) {
                    return;
                }
                imageActivity = com.tencent.connect.avatar.ImageActivity.this;
                str = "10654";
            }
            imageActivity.a(str, 0L);
        }
    };
    private final android.view.View.OnClickListener u = new android.view.View.OnClickListener() { // from class: com.tencent.connect.avatar.ImageActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            com.tencent.connect.avatar.ImageActivity.this.a("10656", java.lang.System.currentTimeMillis() - com.tencent.connect.avatar.ImageActivity.this.m);
            com.tencent.connect.avatar.ImageActivity.this.setResult(0);
            com.tencent.connect.avatar.ImageActivity.this.d();
        }
    };
    private final com.tencent.tauth.IUiListener v = new com.tencent.tauth.DefaultUiListener() { // from class: com.tencent.connect.avatar.ImageActivity.5
        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(java.lang.Object obj) {
            com.tencent.connect.avatar.ImageActivity.this.g.setEnabled(true);
            int i = -1;
            com.tencent.connect.avatar.ImageActivity.this.g.setTextColor(-1);
            com.tencent.connect.avatar.ImageActivity.this.f.setEnabled(true);
            com.tencent.connect.avatar.ImageActivity.this.f.setTextColor(-1);
            com.tencent.connect.avatar.ImageActivity.this.j.setVisibility(8);
            org.json.JSONObject jSONObject = (org.json.JSONObject) obj;
            try {
                i = jSONObject.getInt("ret");
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
            if (i != 0) {
                com.tencent.connect.avatar.ImageActivity.this.a("设置出错了，请重新登录再尝试下呢：）", 1);
                com.tencent.open.a.d.a().a(com.tencent.connect.avatar.ImageActivity.this.b.getOpenId(), com.tencent.connect.avatar.ImageActivity.this.b.getAppId(), com.tencent.connect.common.Constants.VIA_SET_AVATAR_SUCCEED, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SET_AVATAR, com.tencent.connect.common.Constants.VIA_ACT_TYPE_NINETEEN, "1");
                return;
            }
            com.tencent.connect.avatar.ImageActivity.this.a("设置成功", 0);
            com.tencent.connect.avatar.ImageActivity.this.a("10658", 0L);
            com.tencent.open.a.d.a().a(com.tencent.connect.avatar.ImageActivity.this.b.getOpenId(), com.tencent.connect.avatar.ImageActivity.this.b.getAppId(), com.tencent.connect.common.Constants.VIA_SET_AVATAR_SUCCEED, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SET_AVATAR, "3", "0");
            com.tencent.connect.avatar.ImageActivity imageActivity = com.tencent.connect.avatar.ImageActivity.this;
            if (imageActivity.c != null && !"".equals(com.tencent.connect.avatar.ImageActivity.this.c)) {
                android.content.Intent intent = new android.content.Intent();
                intent.setClassName(imageActivity, com.tencent.connect.avatar.ImageActivity.this.c);
                if (imageActivity.getPackageManager().resolveActivity(intent, 0) != null) {
                    imageActivity.startActivity(intent);
                }
            }
            com.tencent.connect.avatar.ImageActivity.this.a(0, jSONObject.toString(), null, null);
            com.tencent.connect.avatar.ImageActivity.this.d();
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(com.tencent.tauth.UiError uiError) {
            com.tencent.connect.avatar.ImageActivity.this.g.setEnabled(true);
            com.tencent.connect.avatar.ImageActivity.this.g.setTextColor(-1);
            com.tencent.connect.avatar.ImageActivity.this.f.setEnabled(true);
            com.tencent.connect.avatar.ImageActivity.this.f.setTextColor(-1);
            com.tencent.connect.avatar.ImageActivity.this.f.setText("重试");
            com.tencent.connect.avatar.ImageActivity.this.j.setVisibility(8);
            com.tencent.connect.avatar.ImageActivity.this.l = true;
            com.tencent.connect.avatar.ImageActivity.this.a(uiError.errorMessage, 1);
            com.tencent.connect.avatar.ImageActivity.this.a("10660", 0L);
        }
    };
    private final com.tencent.tauth.IUiListener w = new com.tencent.tauth.DefaultUiListener() { // from class: com.tencent.connect.avatar.ImageActivity.6
        private void a(int i) {
            if (com.tencent.connect.avatar.ImageActivity.this.k < 2) {
                com.tencent.connect.avatar.ImageActivity.this.e();
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(java.lang.Object obj) {
            com.tencent.connect.avatar.ImageActivity imageActivity;
            java.lang.String str;
            org.json.JSONObject jSONObject = (org.json.JSONObject) obj;
            int i = -1;
            try {
                i = jSONObject.getInt("ret");
                if (i == 0) {
                    final java.lang.String string = jSONObject.getString("nickname");
                    com.tencent.connect.avatar.ImageActivity.this.d.post(new java.lang.Runnable() { // from class: com.tencent.connect.avatar.ImageActivity.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.connect.avatar.ImageActivity.this.c(string);
                        }
                    });
                    imageActivity = com.tencent.connect.avatar.ImageActivity.this;
                    str = "10659";
                } else {
                    imageActivity = com.tencent.connect.avatar.ImageActivity.this;
                    str = "10661";
                }
                imageActivity.a(str, 0L);
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
            if (i != 0) {
                a(i);
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(com.tencent.tauth.UiError uiError) {
            a(0);
        }
    };

    private class QQAvatarImp extends com.tencent.connect.common.BaseApi {
        public QQAvatarImp(com.tencent.connect.auth.QQToken qQToken) {
            super(qQToken);
        }

        public void setAvator(android.graphics.Bitmap bitmap, com.tencent.tauth.IUiListener iUiListener) {
            android.os.Bundle bundleA = a();
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 40, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            bitmap.recycle();
            com.tencent.connect.common.BaseApi.TempRequestListener tempRequestListener = new com.tencent.connect.common.BaseApi.TempRequestListener(iUiListener);
            bundleA.putByteArray("picture", byteArray);
            com.tencent.open.utils.HttpUtils.requestAsync(this.c, com.tencent.open.utils.f.a(), "user/set_user_face", bundleA, com.tencent.connect.common.Constants.HTTP_POST, tempRequestListener);
            com.tencent.open.a.d.a().a(this.c.getOpenId(), this.c.getAppId(), com.tencent.connect.common.Constants.VIA_SET_AVATAR_SUCCEED, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SET_AVATAR, com.tencent.connect.common.Constants.VIA_ACT_TYPE_NINETEEN, "0");
        }
    }

    class a extends android.view.View {
        public a(android.content.Context context) {
            super(context);
        }

        public void a(android.widget.Button button) {
            android.graphics.drawable.StateListDrawable stateListDrawable = new android.graphics.drawable.StateListDrawable();
            android.graphics.drawable.Drawable drawableB = com.tencent.connect.avatar.ImageActivity.this.b("com.tencent.plus.blue_normal.png");
            android.graphics.drawable.Drawable drawableB2 = com.tencent.connect.avatar.ImageActivity.this.b("com.tencent.plus.blue_down.png");
            android.graphics.drawable.Drawable drawableB3 = com.tencent.connect.avatar.ImageActivity.this.b("com.tencent.plus.blue_disable.png");
            stateListDrawable.addState(android.view.View.PRESSED_ENABLED_STATE_SET, drawableB2);
            stateListDrawable.addState(android.view.View.ENABLED_FOCUSED_STATE_SET, drawableB);
            stateListDrawable.addState(android.view.View.ENABLED_STATE_SET, drawableB);
            stateListDrawable.addState(android.view.View.FOCUSED_STATE_SET, drawableB);
            stateListDrawable.addState(android.view.View.EMPTY_STATE_SET, drawableB3);
            button.setBackgroundDrawable(stateListDrawable);
        }

        public void b(android.widget.Button button) {
            android.graphics.drawable.StateListDrawable stateListDrawable = new android.graphics.drawable.StateListDrawable();
            android.graphics.drawable.Drawable drawableB = com.tencent.connect.avatar.ImageActivity.this.b("com.tencent.plus.gray_normal.png");
            android.graphics.drawable.Drawable drawableB2 = com.tencent.connect.avatar.ImageActivity.this.b("com.tencent.plus.gray_down.png");
            android.graphics.drawable.Drawable drawableB3 = com.tencent.connect.avatar.ImageActivity.this.b("com.tencent.plus.gray_disable.png");
            stateListDrawable.addState(android.view.View.PRESSED_ENABLED_STATE_SET, drawableB2);
            stateListDrawable.addState(android.view.View.ENABLED_FOCUSED_STATE_SET, drawableB);
            stateListDrawable.addState(android.view.View.ENABLED_STATE_SET, drawableB);
            stateListDrawable.addState(android.view.View.FOCUSED_STATE_SET, drawableB);
            stateListDrawable.addState(android.view.View.EMPTY_STATE_SET, drawableB3);
            button.setBackgroundDrawable(stateListDrawable);
        }
    }

    private android.graphics.Bitmap a(java.lang.String str) throws java.io.IOException {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        int i = 1;
        options.inJustDecodeBounds = true;
        android.net.Uri uri = android.net.Uri.parse(str);
        java.io.InputStream inputStreamOpenInputStream = getContentResolver().openInputStream(uri);
        if (inputStreamOpenInputStream == null) {
            return null;
        }
        try {
            android.graphics.BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
        } catch (java.lang.OutOfMemoryError e) {
            e.printStackTrace();
        }
        inputStreamOpenInputStream.close();
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        while (i2 * i3 > 4194304) {
            i2 /= 2;
            i3 /= 2;
            i *= 2;
        }
        options.inJustDecodeBounds = false;
        options.inSampleSize = i;
        try {
            return android.graphics.BitmapFactory.decodeStream(getContentResolver().openInputStream(uri), null, options);
        } catch (java.lang.OutOfMemoryError e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private android.view.View a() {
        android.view.ViewGroup.LayoutParams layoutParams = new android.view.ViewGroup.LayoutParams(-1, -1);
        android.view.ViewGroup.LayoutParams layoutParams2 = new android.view.ViewGroup.LayoutParams(-1, -1);
        android.view.ViewGroup.LayoutParams layoutParams3 = new android.view.ViewGroup.LayoutParams(-2, -2);
        android.widget.RelativeLayout relativeLayout = new android.widget.RelativeLayout(this);
        this.f484a = relativeLayout;
        relativeLayout.setLayoutParams(layoutParams);
        this.f484a.setBackgroundColor(-16777216);
        android.widget.RelativeLayout relativeLayout2 = new android.widget.RelativeLayout(this);
        relativeLayout2.setLayoutParams(layoutParams3);
        this.f484a.addView(relativeLayout2);
        com.tencent.connect.avatar.c cVar = new com.tencent.connect.avatar.c(this);
        this.e = cVar;
        cVar.setLayoutParams(layoutParams2);
        this.e.setScaleType(android.widget.ImageView.ScaleType.MATRIX);
        relativeLayout2.addView(this.e);
        this.h = new com.tencent.connect.avatar.b(this);
        android.widget.RelativeLayout.LayoutParams layoutParams4 = new android.widget.RelativeLayout.LayoutParams(layoutParams2);
        layoutParams4.addRule(14, -1);
        layoutParams4.addRule(15, -1);
        this.h.setLayoutParams(layoutParams4);
        relativeLayout2.addView(this.h);
        android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(this);
        android.widget.RelativeLayout.LayoutParams layoutParams5 = new android.widget.RelativeLayout.LayoutParams(-2, com.tencent.connect.avatar.a.a(this, 80.0f));
        layoutParams5.addRule(14, -1);
        linearLayout.setLayoutParams(layoutParams5);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        this.f484a.addView(linearLayout);
        android.widget.ImageView imageView = new android.widget.ImageView(this);
        imageView.setLayoutParams(new android.widget.LinearLayout.LayoutParams(com.tencent.connect.avatar.a.a(this, 24.0f), com.tencent.connect.avatar.a.a(this, 24.0f)));
        imageView.setImageDrawable(b("com.tencent.plus.logo.png"));
        linearLayout.addView(imageView);
        this.i = new android.widget.TextView(this);
        android.widget.LinearLayout.LayoutParams layoutParams6 = new android.widget.LinearLayout.LayoutParams(layoutParams3);
        layoutParams6.leftMargin = com.tencent.connect.avatar.a.a(this, 7.0f);
        this.i.setLayoutParams(layoutParams6);
        this.i.setEllipsize(android.text.TextUtils.TruncateAt.END);
        this.i.setSingleLine();
        this.i.setTextColor(-1);
        this.i.setTextSize(24.0f);
        this.i.setVisibility(8);
        linearLayout.addView(this.i);
        android.widget.RelativeLayout relativeLayout3 = new android.widget.RelativeLayout(this);
        android.widget.RelativeLayout.LayoutParams layoutParams7 = new android.widget.RelativeLayout.LayoutParams(-1, com.tencent.connect.avatar.a.a(this, 60.0f));
        layoutParams7.addRule(12, -1);
        layoutParams7.addRule(9, -1);
        relativeLayout3.setLayoutParams(layoutParams7);
        relativeLayout3.setBackgroundDrawable(b("com.tencent.plus.bar.png"));
        int iA = com.tencent.connect.avatar.a.a(this, 10.0f);
        relativeLayout3.setPadding(iA, iA, iA, 0);
        this.f484a.addView(relativeLayout3);
        com.tencent.connect.avatar.ImageActivity.a aVar = new com.tencent.connect.avatar.ImageActivity.a(this);
        int iA2 = com.tencent.connect.avatar.a.a(this, 14.0f);
        int iA3 = com.tencent.connect.avatar.a.a(this, 7.0f);
        this.g = new android.widget.Button(this);
        this.g.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(com.tencent.connect.avatar.a.a(this, 78.0f), com.tencent.connect.avatar.a.a(this, 45.0f)));
        this.g.setText("取消");
        this.g.setTextColor(-1);
        this.g.setTextSize(18.0f);
        this.g.setPadding(iA2, iA3, iA2, iA3);
        aVar.b(this.g);
        relativeLayout3.addView(this.g);
        this.f = new android.widget.Button(this);
        android.widget.RelativeLayout.LayoutParams layoutParams8 = new android.widget.RelativeLayout.LayoutParams(com.tencent.connect.avatar.a.a(this, 78.0f), com.tencent.connect.avatar.a.a(this, 45.0f));
        layoutParams8.addRule(11, -1);
        this.f.setLayoutParams(layoutParams8);
        this.f.setTextColor(-1);
        this.f.setTextSize(18.0f);
        this.f.setPadding(iA2, iA3, iA2, iA3);
        this.f.setText("选取");
        aVar.a(this.f);
        relativeLayout3.addView(this.f);
        android.widget.TextView textView = new android.widget.TextView(this);
        android.widget.RelativeLayout.LayoutParams layoutParams9 = new android.widget.RelativeLayout.LayoutParams(layoutParams3);
        layoutParams9.addRule(13, -1);
        textView.setLayoutParams(layoutParams9);
        textView.setText("移动和缩放");
        textView.setPadding(0, com.tencent.connect.avatar.a.a(this, 3.0f), 0, 0);
        textView.setTextSize(18.0f);
        textView.setTextColor(-1);
        relativeLayout3.addView(textView);
        this.j = new android.widget.ProgressBar(this);
        android.widget.RelativeLayout.LayoutParams layoutParams10 = new android.widget.RelativeLayout.LayoutParams(layoutParams3);
        layoutParams10.addRule(14, -1);
        layoutParams10.addRule(15, -1);
        this.j.setLayoutParams(layoutParams10);
        this.j.setVisibility(8);
        this.f484a.addView(this.j);
        return this.f484a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        android.content.Intent intent = new android.content.Intent();
        intent.putExtra(com.tencent.connect.common.Constants.KEY_ERROR_CODE, i);
        intent.putExtra(com.tencent.connect.common.Constants.KEY_ERROR_MSG, str2);
        intent.putExtra(com.tencent.connect.common.Constants.KEY_ERROR_DETAIL, str3);
        intent.putExtra(com.tencent.connect.common.Constants.KEY_RESPONSE, str);
        setResult(-1, intent);
    }

    private void a(android.graphics.Bitmap bitmap) {
        new com.tencent.connect.avatar.ImageActivity.QQAvatarImp(this.b).setAvator(bitmap, this.v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final java.lang.String str, final int i) {
        this.d.post(new java.lang.Runnable() { // from class: com.tencent.connect.avatar.ImageActivity.4
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.connect.avatar.ImageActivity.this.b(str, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.graphics.drawable.Drawable b(java.lang.String str) {
        return com.tencent.open.utils.l.a(str, this);
    }

    private void b() {
        try {
            android.graphics.Bitmap bitmapA = a(this.r);
            this.s = bitmapA;
            if (bitmapA != null) {
                this.e.setImageBitmap(bitmapA);
                this.f.setOnClickListener(this.t);
                this.g.setOnClickListener(this.u);
                this.f484a.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.connect.avatar.ImageActivity.1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        com.tencent.connect.avatar.ImageActivity.this.f484a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                        com.tencent.connect.avatar.ImageActivity imageActivity = com.tencent.connect.avatar.ImageActivity.this;
                        imageActivity.q = imageActivity.h.a();
                        com.tencent.connect.avatar.ImageActivity.this.e.a(com.tencent.connect.avatar.ImageActivity.this.q);
                    }
                });
                return;
            }
            throw new java.io.IOException("cannot read picture: '" + this.r + "'!");
        } catch (java.io.IOException e) {
            e.printStackTrace();
            a(com.tencent.connect.common.Constants.MSG_IMAGE_ERROR, 1);
            a(-5, null, com.tencent.connect.common.Constants.MSG_IMAGE_ERROR, e.getMessage());
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(java.lang.String str, int i) {
        android.widget.Toast toastMakeText = android.widget.Toast.makeText(this, str, 1);
        android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) toastMakeText.getView();
        ((android.widget.TextView) linearLayout.getChildAt(0)).setPadding(8, 0, 0, 0);
        android.widget.ImageView imageView = new android.widget.ImageView(this);
        imageView.setLayoutParams(new android.widget.LinearLayout.LayoutParams(com.tencent.connect.avatar.a.a(this, 16.0f), com.tencent.connect.avatar.a.a(this, 16.0f)));
        imageView.setImageDrawable(b(i == 0 ? "com.tencent.plus.ic_success.png" : "com.tencent.plus.ic_error.png"));
        linearLayout.addView(imageView, 0);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        toastMakeText.setView(linearLayout);
        toastMakeText.setGravity(17, 0, 0);
        toastMakeText.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        float fWidth = this.q.width();
        android.graphics.Matrix imageMatrix = this.e.getImageMatrix();
        float[] fArr = new float[9];
        imageMatrix.getValues(fArr);
        float f = fArr[2];
        float f2 = fArr[5];
        float f3 = fArr[0];
        float f4 = 640.0f / fWidth;
        int i = (int) ((this.q.left - f) / f3);
        int i2 = i < 0 ? 0 : i;
        int i3 = (int) ((this.q.top - f2) / f3);
        int i4 = i3 < 0 ? 0 : i3;
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.set(imageMatrix);
        matrix.postScale(f4, f4);
        int i5 = (int) (650.0f / f3);
        try {
            android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(this.s, i2, i4, java.lang.Math.min(this.s.getWidth() - i2, i5), java.lang.Math.min(this.s.getHeight() - i4, i5), matrix, true);
            android.graphics.Bitmap bitmapCreateBitmap2 = android.graphics.Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, 640, 640);
            bitmapCreateBitmap.recycle();
            a(bitmapCreateBitmap2);
        } catch (java.lang.IllegalArgumentException e) {
            e.printStackTrace();
            a(com.tencent.connect.common.Constants.MSG_IMAGE_ERROR, 1);
            a(-5, null, com.tencent.connect.common.Constants.MSG_IMAGE_ERROR, e.getMessage());
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(java.lang.String str) {
        java.lang.String strD = d(str);
        if ("".equals(strD)) {
            return;
        }
        this.i.setText(strD);
        this.i.setVisibility(0);
    }

    private java.lang.String d(java.lang.String str) {
        return str.replaceAll("&gt;", ">").replaceAll("&lt;", "<").replaceAll("&quot;", "\"").replaceAll("&#39;", "'").replaceAll("&amp;", "&");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        finish();
        int i = this.n;
        if (i != 0) {
            overridePendingTransition(0, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.k++;
        new com.tencent.connect.UserInfo(this, this.b).getUserInfo(this.w);
    }

    public void a(java.lang.String str, long j) {
        com.tencent.open.utils.l.a(this, str, j, this.b.getAppId());
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0);
        d();
    }

    @Override // android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setRequestedOrientation(1);
        setContentView(a());
        this.d = new android.os.Handler();
        android.os.Bundle bundleExtra = getIntent().getBundleExtra(com.tencent.connect.common.Constants.KEY_PARAMS);
        this.r = bundleExtra.getString("picture");
        this.c = bundleExtra.getString("return_activity");
        java.lang.String string = bundleExtra.getString("appid");
        java.lang.String string2 = bundleExtra.getString(com.tencent.connect.common.Constants.PARAM_ACCESS_TOKEN);
        long j = bundleExtra.getLong(com.tencent.connect.common.Constants.PARAM_EXPIRES_IN);
        java.lang.String string3 = bundleExtra.getString("openid");
        this.n = bundleExtra.getInt("exitAnim");
        com.tencent.connect.auth.QQToken qQToken = new com.tencent.connect.auth.QQToken(string);
        this.b = qQToken;
        qQToken.setAccessToken(string2, ((j - java.lang.System.currentTimeMillis()) / 1000) + "[REDACTED]");
        this.b.setOpenId(string3);
        b();
        e();
        this.m = java.lang.System.currentTimeMillis();
        a("10653", 0L);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.e.setImageBitmap(null);
        android.graphics.Bitmap bitmap = this.s;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.s.recycle();
    }
}
