package com.unity3d.player;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class k extends android.app.Dialog implements android.text.TextWatcher, android.view.View.OnClickListener {
    private static int c = 1627389952;
    private static int d = -1;
    private static int e = 134217728;
    private static int f = 67108864;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.content.Context f1632a;
    private com.unity3d.player.UnityPlayer b;

    public k(android.content.Context context, com.unity3d.player.UnityPlayer unityPlayer, java.lang.String str, int i, boolean z, boolean z2, boolean z3, java.lang.String str2, int i2, boolean z4) {
        super(context);
        this.f1632a = null;
        this.b = null;
        this.f1632a = context;
        this.b = unityPlayer;
        a(z4);
        getWindow().requestFeature(1);
        getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(0));
        setContentView(createSoftInputView());
        getWindow().setLayout(-1, -2);
        getWindow().clearFlags(2);
        if (com.unity3d.player.j.f1631a) {
            getWindow().clearFlags(e);
            getWindow().clearFlags(f);
        }
        android.widget.EditText editText = (android.widget.EditText) findViewById(1057292289);
        android.widget.Button button = (android.widget.Button) findViewById(1057292290);
        a(editText, str, i, z, z2, z3, str2, i2);
        button.setOnClickListener(this);
        editText.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() { // from class: com.unity3d.player.k.1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(android.view.View view, boolean z5) {
                if (z5) {
                    com.unity3d.player.k.this.getWindow().setSoftInputMode(5);
                }
            }
        });
        editText.requestFocus();
    }

    private static int a(int i, boolean z, boolean z2, boolean z3) {
        int i2 = (z ? 32768 : 524288) | (z2 ? 131072 : 0) | (z3 ? 128 : 0);
        if (i < 0 || i > 10) {
            return i2;
        }
        int[] iArr = {1, 16385, 12290, 17, 2, 3, 8289, 33, 1, 16417, 17};
        return (iArr[i] & 2) != 0 ? iArr[i] : iArr[i] | i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String a() {
        android.widget.EditText editText = (android.widget.EditText) findViewById(1057292289);
        if (editText == null) {
            return null;
        }
        return editText.getText().toString().trim();
    }

    private void a(android.widget.EditText editText, java.lang.String str, int i, boolean z, boolean z2, boolean z3, java.lang.String str2, int i2) {
        editText.setImeOptions(6);
        editText.setText(str);
        editText.setHint(str2);
        editText.setHintTextColor(c);
        editText.setInputType(a(i, z, z2, z3));
        editText.setImeOptions(oicq.wlogin_sdk.request.WtloginHelper.SigType.WLOGIN_DA2);
        if (i2 > 0) {
            editText.setFilters(new android.text.InputFilter[]{new android.text.InputFilter.LengthFilter(i2)});
        }
        editText.addTextChangedListener(this);
        editText.setSelection(editText.getText().length());
        editText.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.lang.String str, boolean z) {
        ((android.widget.EditText) findViewById(1057292289)).setSelection(0, 0);
        this.b.reportSoftInputStr(str, 1, z);
    }

    public final void a(int i) {
        android.widget.EditText editText = (android.widget.EditText) findViewById(1057292289);
        if (editText != null) {
            if (i > 0) {
                editText.setFilters(new android.text.InputFilter[]{new android.text.InputFilter.LengthFilter(i)});
            } else {
                editText.setFilters(new android.text.InputFilter[0]);
            }
        }
    }

    public final void a(int i, int i2) {
        int i3;
        android.widget.EditText editText = (android.widget.EditText) findViewById(1057292289);
        if (editText == null || editText.getText().length() < (i3 = i2 + i)) {
            return;
        }
        editText.setSelection(i, i3);
    }

    public final void a(java.lang.String str) {
        android.widget.EditText editText = (android.widget.EditText) findViewById(1057292289);
        if (editText != null) {
            editText.setText(str);
            editText.setSelection(str.length());
        }
    }

    public final void a(boolean z) {
        int i;
        android.view.Window window = getWindow();
        android.view.WindowManager.LayoutParams attributes = window.getAttributes();
        if (z) {
            attributes.gravity = 8;
            i = cn.yunzhisheng.asr.a.b;
        } else {
            attributes.gravity = 80;
            i = 0;
        }
        attributes.x = i;
        attributes.y = i;
        window.setAttributes(attributes);
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(android.text.Editable editable) {
        this.b.reportSoftInputStr(editable.toString(), 0, false);
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
    }

    protected final android.view.View createSoftInputView() {
        android.widget.RelativeLayout relativeLayout = new android.widget.RelativeLayout(this.f1632a);
        relativeLayout.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
        relativeLayout.setBackgroundColor(d);
        android.widget.EditText editText = new android.widget.EditText(this.f1632a) { // from class: com.unity3d.player.k.2
            @Override // android.widget.TextView, android.view.View
            public final boolean onKeyPreIme(int i, android.view.KeyEvent keyEvent) {
                if (i == 4) {
                    com.unity3d.player.k kVar = com.unity3d.player.k.this;
                    kVar.a(kVar.a(), true);
                    return true;
                }
                if (i == 84) {
                    return true;
                }
                return super.onKeyPreIme(i, keyEvent);
            }

            @Override // android.widget.TextView
            protected final void onSelectionChanged(int i, int i2) {
                com.unity3d.player.k.this.b.reportSoftInputSelection(i, i2 - i);
            }

            @Override // android.widget.TextView, android.view.View
            public final void onWindowFocusChanged(boolean z) {
                super.onWindowFocusChanged(z);
                if (z) {
                    ((android.view.inputmethod.InputMethodManager) com.unity3d.player.k.this.f1632a.getSystemService("input_method")).showSoftInput(this, 0);
                }
            }
        };
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(0, 1057292290);
        editText.setLayoutParams(layoutParams);
        editText.setId(1057292289);
        relativeLayout.addView(editText);
        android.widget.Button button = new android.widget.Button(this.f1632a);
        button.setText(this.f1632a.getResources().getIdentifier("ok", "string", "android"));
        android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(15);
        layoutParams2.addRule(11);
        button.setLayoutParams(layoutParams2);
        button.setId(1057292290);
        button.setBackgroundColor(0);
        relativeLayout.addView(button);
        ((android.widget.EditText) relativeLayout.findViewById(1057292289)).setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() { // from class: com.unity3d.player.k.3
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(android.widget.TextView textView, int i, android.view.KeyEvent keyEvent) {
                if (i == 6) {
                    com.unity3d.player.k kVar = com.unity3d.player.k.this;
                    kVar.a(kVar.a(), false);
                }
                return false;
            }
        });
        relativeLayout.setPadding(16, 16, 16, 16);
        return relativeLayout;
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        a(a(), true);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        a(a(), false);
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
    }
}
