package com.dodjoy.utilities;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class DodRequest {
    private static com.dodjoy.utilities.DodProgressDialog mProgressDialog;

    /* JADX INFO: Access modifiers changed from: private */
    public static void hideProgressDialog() {
        android.app.Activity activityGetGameActivity = com.dodjoy.utilities.DodBaseContext.GetGameActivity();
        if (activityGetGameActivity == null) {
            return;
        }
        activityGetGameActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.dodjoy.utilities.DodRequest.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.dodjoy.utilities.DodRequest.mProgressDialog == null || !com.dodjoy.utilities.DodRequest.mProgressDialog.isShowing()) {
                    return;
                }
                com.dodjoy.utilities.DodRequest.mProgressDialog.dismiss();
            }
        });
    }

    public static void request(final java.lang.String str, final java.util.List<android.util.Pair<java.lang.String, java.lang.String>> list, final int i, final com.dodjoy.utilities.RequestCallback requestCallback) {
        showProgressDialog();
        com.dodjoy.utils.DodSdkEngine.post(new java.lang.Runnable() { // from class: com.dodjoy.utilities.DodRequest.1
            @Override // java.lang.Runnable
            public void run() {
                java.lang.String strConnect = "";
                try {
                    strConnect = com.dodjoy.utilities.DodHttpConnection.connect(str, list, i);
                    if (android.text.TextUtils.isEmpty(strConnect)) {
                        com.dodjoy.utilities.DodRequest.hideProgressDialog();
                        requestCallback.onFail("-1");
                        return;
                    }
                } catch (java.net.MalformedURLException e) {
                    com.dodjoy.utilities.DodRequest.hideProgressDialog();
                    e.printStackTrace();
                    requestCallback.onFail("-2");
                    return;
                } catch (java.io.IOException e2) {
                    com.dodjoy.utilities.DodRequest.hideProgressDialog();
                    e2.printStackTrace();
                    requestCallback.onFail("-3");
                    return;
                } catch (java.lang.Exception e3) {
                    com.dodjoy.utilities.DodRequest.hideProgressDialog();
                    e3.printStackTrace();
                    requestCallback.onFail("-4");
                }
                com.dodjoy.utilities.DodRequest.hideProgressDialog();
                try {
                    requestCallback.onSuccess(new org.json.JSONObject(strConnect));
                } catch (java.lang.Exception e4) {
                    e4.printStackTrace();
                    requestCallback.onFail(e4.getMessage());
                }
            }
        });
    }

    public static void request(java.lang.String str, java.util.List<android.util.Pair<java.lang.String, java.lang.String>> list, com.dodjoy.utilities.RequestCallback requestCallback) {
        request(str, list, 8, requestCallback);
    }

    private static void showProgressDialog() {
        hideProgressDialog();
        final android.app.Activity activityGetGameActivity = com.dodjoy.utilities.DodBaseContext.GetGameActivity();
        if (activityGetGameActivity == null) {
            android.util.Log.e("Unity", "SDK showProgressDialog faield, no game activity found ");
        } else {
            activityGetGameActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.dodjoy.utilities.DodRequest.2
                @Override // java.lang.Runnable
                public void run() {
                    com.dodjoy.utilities.DodProgressDialog unused = com.dodjoy.utilities.DodRequest.mProgressDialog = null;
                    try {
                        com.dodjoy.utilities.DodProgressDialog unused2 = com.dodjoy.utilities.DodRequest.mProgressDialog = new com.dodjoy.utilities.DodProgressDialog(activityGetGameActivity);
                        com.dodjoy.utilities.DodRequest.mProgressDialog.setCanceledOnTouchOutside(false);
                        com.dodjoy.utilities.DodRequest.mProgressDialog.show();
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
