package com.tencent.mobileqq.openpay.api;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class OpenApiFactory {
    private OpenApiFactory() {
        throw new java.lang.RuntimeException(java.lang.String.valueOf(com.tencent.mobileqq.openpay.api.OpenApiFactory.class.getSimpleName()) + " should not be created.");
    }

    public static com.tencent.mobileqq.openpay.api.IOpenApi getInstance(android.content.Context context, java.lang.String str) {
        if (context == null || android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        return new com.tencent.mobileqq.openpay.api.a(context);
    }
}
