package com.tencent.midas.api.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APInventory {
    public java.util.Map mPurchaseMap = new java.util.HashMap();
    public java.util.ArrayList mPurchaseList = new java.util.ArrayList();

    public APInventory(java.lang.String str) {
        parsePurchse(str);
    }

    private void parsePurchse(java.lang.String str) {
        new java.util.ArrayList();
        try {
            org.json.JSONArray jSONArray = new org.json.JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                com.tencent.midas.api.request.APPurchase aPPurchase = new com.tencent.midas.api.request.APPurchase((java.lang.String) jSONArray.getJSONObject(i).get(com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameFreeloginResponse.HTTP_RESP_PARAM_DATA), (java.lang.String) jSONArray.getJSONObject(i).get("sign"));
                this.mPurchaseMap.put(aPPurchase.getSku(), aPPurchase);
                this.mPurchaseList.add(aPPurchase);
            }
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }

    public void erasePurchase(java.lang.String str) {
        if (this.mPurchaseMap.containsKey(str)) {
            this.mPurchaseMap.remove(str);
        }
    }

    java.util.List getAllOwnedSkus() {
        return new java.util.ArrayList(this.mPurchaseMap.keySet());
    }

    java.util.List getAllPurchases() {
        return new java.util.ArrayList(this.mPurchaseMap.values());
    }

    public com.tencent.midas.api.request.APPurchase getPurchase(java.lang.String str) {
        return (com.tencent.midas.api.request.APPurchase) this.mPurchaseMap.get(str);
    }

    public java.util.List getPurchaseList() {
        return this.mPurchaseList;
    }

    public boolean hasPurchase(java.lang.String str) {
        return this.mPurchaseMap.containsKey(str);
    }
}
