package com.tencent.ydkqmsp.sdk.base;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class e implements com.tencent.ydkqmsp.sdk.base.IVendorCallback {
    private static boolean c = false;
    private static java.lang.String d = "b2FpZA";
    private static java.lang.String e = "b2FpZA";
    private static android.content.Context f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tencent.ydkqmsp.sdk.base.b f1305a = null;
    private com.tencent.ydkqmsp.sdk.base.IVendorCallback b = null;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1306a;

        static {
            int[] iArr = new int[com.tencent.ydkqmsp.sdk.base.d.values().length];
            f1306a = iArr;
            try {
                iArr[com.tencent.ydkqmsp.sdk.base.d.XIAOMI.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                f1306a[com.tencent.ydkqmsp.sdk.base.d.BLACKSHARK.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                f1306a[com.tencent.ydkqmsp.sdk.base.d.VIVO.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                f1306a[com.tencent.ydkqmsp.sdk.base.d.HUA_WEI.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                f1306a[com.tencent.ydkqmsp.sdk.base.d.OPPO.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                f1306a[com.tencent.ydkqmsp.sdk.base.d.ONEPLUS.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                f1306a[com.tencent.ydkqmsp.sdk.base.d.MOTO.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                f1306a[com.tencent.ydkqmsp.sdk.base.d.LENOVO.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            try {
                f1306a[com.tencent.ydkqmsp.sdk.base.d.ASUS.ordinal()] = 9;
            } catch (java.lang.NoSuchFieldError unused9) {
            }
            try {
                f1306a[com.tencent.ydkqmsp.sdk.base.d.SAMSUNG.ordinal()] = 10;
            } catch (java.lang.NoSuchFieldError unused10) {
            }
            try {
                f1306a[com.tencent.ydkqmsp.sdk.base.d.MEIZU.ordinal()] = 11;
            } catch (java.lang.NoSuchFieldError unused11) {
            }
            try {
                f1306a[com.tencent.ydkqmsp.sdk.base.d.ALPS.ordinal()] = 12;
            } catch (java.lang.NoSuchFieldError unused12) {
            }
            try {
                f1306a[com.tencent.ydkqmsp.sdk.base.d.NUBIA.ordinal()] = 13;
            } catch (java.lang.NoSuchFieldError unused13) {
            }
            try {
                f1306a[com.tencent.ydkqmsp.sdk.base.d.ZTE.ordinal()] = 14;
            } catch (java.lang.NoSuchFieldError unused14) {
            }
            try {
                f1306a[com.tencent.ydkqmsp.sdk.base.d.FREEMEOS.ordinal()] = 15;
            } catch (java.lang.NoSuchFieldError unused15) {
            }
            try {
                f1306a[com.tencent.ydkqmsp.sdk.base.d.SSUIOS.ordinal()] = 16;
            } catch (java.lang.NoSuchFieldError unused16) {
            }
        }
    }

    public static java.lang.String a(android.content.Context context, java.lang.String str, int i) {
        java.lang.String str2 = null;
        if (context == null) {
            return null;
        }
        try {
            if (!(context instanceof android.content.Context)) {
                return null;
            }
            android.content.SharedPreferences sharedPreferences = context.getSharedPreferences(d, 0);
            java.lang.String string = sharedPreferences.getString(e, null);
            java.lang.String str3 = !android.text.TextUtils.isEmpty(string) ? new java.lang.String(android.util.Base64.decode(string.getBytes("UTF-8"), 0)) : null;
            if (i == 1) {
                try {
                    if (c) {
                        android.content.SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                        editorEdit.putString(e, android.text.TextUtils.isEmpty(str) ? null : android.util.Base64.encodeToString(str.getBytes("UTF-8"), 0));
                        editorEdit.commit();
                    }
                } catch (java.lang.Exception e2) {
                    e = e2;
                    str2 = str3;
                }
            }
            return str3;
        } catch (java.lang.Exception e3) {
            e = e3;
        }
        e.printStackTrace();
        return str2;
    }

    public static void a(android.content.Context context) {
        if (context != null) {
            try {
                if (context instanceof android.content.Context) {
                    context.getSharedPreferences(d, 0).edit().clear().commit();
                }
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(android.content.Context context, boolean z, boolean z2) {
        c = z;
        f = context;
        com.tencent.ydkqmsp.sdk.base.c.a(z2);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0061  */
    /* JADX WARN: Code duplicated, block: B:24:0x006c  */
    /* JADX WARN: Code duplicated, block: B:32:0x008c  */
    /* JADX WARN: Code duplicated, block: B:43:0x0080 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public int a(com.tencent.ydkqmsp.sdk.base.IVendorCallback iVendorCallback) {
        com.tencent.ydkqmsp.sdk.base.b aVar;
        this.b = iVendorCallback;
        com.tencent.ydkqmsp.sdk.base.d dVarA = com.tencent.ydkqmsp.sdk.base.d.a(android.os.Build.MANUFACTURER);
        if (dVarA == com.tencent.ydkqmsp.sdk.base.d.UNSUPPORT) {
            onResult(false, null, null);
            return com.tencent.ydkqmsp.sdk.base.a.f1302a;
        }
        switch (com.tencent.ydkqmsp.sdk.base.e.a.f1306a[dVarA.ordinal()]) {
            case 1:
            case 2:
                aVar = new com.tencent.ydkqmsp.sdk.g.j.a();
                break;
            case 3:
                aVar = new com.tencent.ydkqmsp.sdk.g.i.b();
                break;
            case 4:
                aVar = new com.tencent.ydkqmsp.sdk.g.b.c();
                break;
            case 5:
            case 6:
                aVar = new com.tencent.ydkqmsp.sdk.g.g.c();
                break;
            case 7:
            case 8:
                aVar = new com.tencent.ydkqmsp.sdk.g.c.b();
                break;
            case 9:
                aVar = new com.tencent.ydkqmsp.sdk.g.a.c();
                break;
            case 10:
                aVar = new com.tencent.ydkqmsp.sdk.g.h.c();
                break;
            case 11:
            case 12:
                aVar = new com.tencent.ydkqmsp.sdk.g.e.f();
                break;
            case 13:
                aVar = new com.tencent.ydkqmsp.sdk.g.f.a();
                break;
            case 14:
            case 15:
            case 16:
                aVar = new com.tencent.ydkqmsp.sdk.g.d.e();
                break;
            default:
                if (this.f1305a == null) {
                    com.tencent.ydkqmsp.sdk.base.c.b("vendorInfo == null");
                    onResult(false, null, null);
                    return com.tencent.ydkqmsp.sdk.base.a.b;
                }
                com.tencent.ydkqmsp.sdk.base.c.b("init");
                try {
                    this.f1305a.a(f, this);
                    if (!this.f1305a.d()) {
                        try {
                            this.f1305a.c();
                        } catch (java.lang.Exception unused) {
                            onResult(false, null, null);
                            return com.tencent.ydkqmsp.sdk.base.a.c;
                        }
                        break;
                    } else {
                        com.tencent.ydkqmsp.sdk.base.c.b("sync");
                        try {
                            onResult(this.f1305a.e(), this.f1305a.b(), this.f1305a.a());
                        } catch (java.lang.Exception unused2) {
                            onResult(false, null, null);
                        }
                        break;
                    }
                    return 0;
                } catch (java.lang.Exception unused3) {
                    onResult(false, null, null);
                    return com.tencent.ydkqmsp.sdk.base.a.c;
                }
        }
        this.f1305a = aVar;
        if (this.f1305a == null) {
            com.tencent.ydkqmsp.sdk.base.c.b("vendorInfo == null");
            onResult(false, null, null);
            return com.tencent.ydkqmsp.sdk.base.a.b;
        }
        com.tencent.ydkqmsp.sdk.base.c.b("init");
        this.f1305a.a(f, this);
        if (!this.f1305a.d()) {
            this.f1305a.c();
        } else {
            com.tencent.ydkqmsp.sdk.base.c.b("sync");
            onResult(this.f1305a.e(), this.f1305a.b(), this.f1305a.a());
        }
        return 0;
    }

    @Override // com.tencent.ydkqmsp.sdk.base.IVendorCallback
    public void onResult(boolean z, java.lang.String str, java.lang.String str2) {
        com.tencent.ydkqmsp.sdk.base.c.c("vm onResult " + z);
        if (android.text.TextUtils.isEmpty(str2)) {
            str2 = a(f, (java.lang.String) null, 0);
        } else {
            a(f, str2, 1);
        }
        com.tencent.ydkqmsp.sdk.base.IVendorCallback iVendorCallback = this.b;
        if (iVendorCallback != null) {
            iVendorCallback.onResult(z, str, str2);
        }
        com.tencent.ydkqmsp.sdk.base.b bVar = this.f1305a;
        if (bVar != null) {
            bVar.f();
        }
    }
}
