package com.tencent.mobileqq.openpay.api;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface IOpenApi {
    boolean execApi(com.tencent.mobileqq.openpay.data.base.BaseApi baseApi);

    boolean handleIntent(android.content.Intent intent, com.tencent.mobileqq.openpay.api.IOpenApiListener iOpenApiListener);

    boolean isMobileQQInstalled();

    boolean isMobileQQSupportApi(java.lang.String str);
}
