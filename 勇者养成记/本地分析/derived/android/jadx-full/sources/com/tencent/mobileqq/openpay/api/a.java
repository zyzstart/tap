package com.tencent.mobileqq.openpay.api;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class a implements com.tencent.mobileqq.openpay.api.IOpenApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final java.lang.String[] f642a = {"pay"};
    private android.content.Context mContext;

    a(android.content.Context context) {
        this.mContext = context;
    }

    private static int a(java.lang.String str, java.lang.String str2) {
        if (str == null) {
            return -1;
        }
        java.lang.String[] strArrSplit = str.split("\\.");
        java.lang.String[] strArrSplit2 = str2.split("\\.");
        int i = 0;
        while (i < strArrSplit.length && i < strArrSplit2.length) {
            try {
                int i2 = java.lang.Integer.parseInt(strArrSplit[i]);
                int i3 = java.lang.Integer.parseInt(strArrSplit2[i]);
                if (i2 < i3) {
                    return -1;
                }
                if (i2 > i3) {
                    return 1;
                }
                i++;
            } catch (java.lang.NumberFormatException e) {
                e.printStackTrace();
                return str.compareTo(str2);
            }
        }
        if (strArrSplit.length > i) {
            return 1;
        }
        return strArrSplit2.length > i ? -1 : 0;
    }

    private java.lang.String a() {
        try {
            android.content.pm.PackageInfo packageInfo = this.mContext.getPackageManager().getPackageInfo("com.tencent.mobileqq", 0);
            if (packageInfo != null && !android.text.TextUtils.isEmpty(packageInfo.versionName)) {
                return packageInfo.versionName;
            }
            return null;
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private boolean a(com.tencent.mobileqq.openpay.data.base.BaseApi baseApi) {
        android.os.Bundle bundle = new android.os.Bundle();
        baseApi.toBundle(bundle);
        try {
            java.lang.String packageName = this.mContext.getPackageName();
            if (android.text.TextUtils.isEmpty(packageName)) {
                return false;
            }
            bundle.putString("_mqqpay_payapi_packageName", packageName);
            android.content.Intent intent = new android.content.Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(android.net.Uri.parse("mqqwallet://open_pay/"));
            intent.setPackage("com.tencent.mobileqq");
            intent.putExtras(bundle);
            intent.addFlags(268435456).addFlags(oicq.wlogin_sdk.request.WtloginHelper.SigType.WLOGIN_PT4Token);
            this.mContext.startActivity(intent);
            return true;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean b(com.tencent.mobileqq.openpay.data.base.BaseApi baseApi) {
        try {
            java.lang.String packageName = this.mContext.getPackageName();
            if (android.text.TextUtils.isEmpty(packageName)) {
                return false;
            }
            android.os.Bundle bundle = new android.os.Bundle();
            baseApi.toBundle(bundle);
            bundle.putString("_mqqpay_baseapi_pkgname", packageName);
            android.content.Intent intent = new android.content.Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(android.net.Uri.parse("mqqwallet://open_pay/"));
            intent.setPackage("com.tencent.mobileqq");
            intent.putExtras(bundle);
            intent.addFlags(268435456).addFlags(oicq.wlogin_sdk.request.WtloginHelper.SigType.WLOGIN_PT4Token);
            this.mContext.startActivity(intent);
            return true;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.tencent.mobileqq.openpay.api.IOpenApi
    public final boolean execApi(com.tencent.mobileqq.openpay.data.base.BaseApi baseApi) {
        java.lang.String strA;
        if (baseApi != null && baseApi.checkParams() && "pay".compareTo(baseApi.getApiName()) == 0 && (strA = a()) != null) {
            if (a(strA, "5.3.0") >= 0) {
                return a(baseApi);
            }
            if (a(strA, "4.7.2") >= 0) {
                return b(baseApi);
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.openpay.api.IOpenApi
    public final boolean handleIntent(android.content.Intent intent, com.tencent.mobileqq.openpay.api.IOpenApiListener iOpenApiListener) {
        android.os.Bundle extras;
        if (intent != null && iOpenApiListener != null) {
            java.lang.String stringExtra = intent.getStringExtra("com_tencent_mobileqq_open_pay");
            if (android.text.TextUtils.isEmpty(stringExtra) || stringExtra.compareTo("com.tencent.mobileqq.open.pay") != 0 || (extras = intent.getExtras()) == null) {
                return false;
            }
            com.tencent.mobileqq.openpay.data.pay.PayResponse payResponse = null;
            if (extras.getInt("_mqqpay_baseapi_apimark", -1) == 1) {
                payResponse = new com.tencent.mobileqq.openpay.data.pay.PayResponse();
                payResponse.fromBundle(extras);
            }
            if (payResponse != null && payResponse.checkParams()) {
                iOpenApiListener.onOpenResponse(payResponse);
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.openpay.api.IOpenApi
    public final boolean isMobileQQInstalled() {
        return a() != null;
    }

    @Override // com.tencent.mobileqq.openpay.api.IOpenApi
    public final boolean isMobileQQSupportApi(java.lang.String str) {
        java.lang.String strA;
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        int i = 0;
        while (true) {
            java.lang.String[] strArr = this.f642a;
            if (i > 0 || str.compareTo(strArr[0]) == 0) {
                break;
            }
            i++;
        }
        return i <= 0 && (strA = a()) != null && a(strA, "4.7.2") >= 0;
    }
}
