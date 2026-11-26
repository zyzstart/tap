package com.pay.network.model;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APMpAns extends com.pay.http.APBaseHttpAns {
    private java.lang.String beginTime;
    private java.lang.String endTime;
    private java.lang.String firstsave_present_count;
    private java.util.List mGoodsList;
    private java.lang.String mpJson;
    private java.util.List mpList;
    private java.util.List mpPresentList;
    private java.util.List mpValueList;
    private java.lang.String rate;

    public APMpAns(com.pay.http.APHttpHandle aPHttpHandle, com.pay.http.IAPHttpAnsObserver iAPHttpAnsObserver, java.util.HashMap map, java.lang.String str) {
        super(aPHttpHandle, iAPHttpAnsObserver, map, str);
        this.rate = "";
        this.firstsave_present_count = "";
        this.beginTime = "";
        this.endTime = "";
        this.mpJson = "";
        this.mpValueList = new java.util.ArrayList();
        this.mpPresentList = new java.util.ArrayList();
        this.mpList = new java.util.ArrayList();
        this.mGoodsList = new java.util.ArrayList();
    }

    public java.lang.String getBeginTime() {
        return this.beginTime;
    }

    public java.lang.String getEndTime() {
        return this.endTime;
    }

    public java.lang.String getFirstsave_present_count() {
        return this.firstsave_present_count;
    }

    public java.lang.String getMpJson() {
        return this.mpJson;
    }

    public java.util.List getMpList() {
        return this.mpList;
    }

    public java.util.List getMpPresentList() {
        return this.mpPresentList;
    }

    public java.util.List getMpValueList() {
        return this.mpValueList;
    }

    public java.util.List getProductList() {
        return this.mGoodsList;
    }

    public java.lang.String getRate() {
        return this.rate;
    }

    @Override // com.pay.http.APBaseHttpAns
    public void onErrorAns(com.pay.http.APBaseHttpReq aPBaseHttpReq) {
    }

    @Override // com.pay.http.APBaseHttpAns
    public void onFinishAns(byte[] bArr, com.pay.http.APBaseHttpReq aPBaseHttpReq) {
        super.onFinishAns(bArr, aPBaseHttpReq);
        java.lang.String str = new java.lang.String(bArr);
        this.mpJson = str;
        com.tencent.midas.comm.APLog.i("APMpAns", "resultData=" + str);
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            int i = java.lang.Integer.parseInt(jSONObject.getString("ret").toString());
            this.resultCode = i;
            if (i != 0) {
                this.resultMsg = jSONObject.getString("msg");
                java.lang.String string = jSONObject.getString("err_code").toString();
                if (string.equals("")) {
                    return;
                }
                this.resultMsg = "系统繁忙,请稍后再试\n(" + string + ")";
                return;
            }
            if (jSONObject.has("product_list")) {
                org.json.JSONArray jSONArray = jSONObject.getJSONArray("product_list");
                this.mGoodsList.clear();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    org.json.JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    com.pay.tool.APProductItem aPProductItem = new com.pay.tool.APProductItem();
                    try {
                        aPProductItem.name = jSONObject2.getString("name");
                        aPProductItem.productId = jSONObject2.getString("productid");
                        aPProductItem.price = jSONObject2.getString("price");
                        aPProductItem.num = jSONObject2.getString("num");
                        this.mGoodsList.add(aPProductItem);
                    } catch (java.lang.Exception unused) {
                    }
                }
            }
            this.rate = jSONObject.getString("rate");
            com.pay.network.model.APCommMethod.transformStrToList(jSONObject.getString("list"), this.mpList);
            this.firstsave_present_count = jSONObject.getString("firstsave_present_count");
            com.pay.network.model.APCommMethod.transformStrToMpInfoList(jSONObject.getString("present_level"), this.mpValueList, this.mpPresentList);
            this.beginTime = jSONObject.getString("begin_time");
            this.endTime = jSONObject.getString("end_time");
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.pay.http.APBaseHttpAns
    public void onReceiveAns(byte[] bArr, int i, long j, com.pay.http.APBaseHttpReq aPBaseHttpReq) {
    }

    @Override // com.pay.http.APBaseHttpAns
    public void onStartAns(com.pay.http.APBaseHttpReq aPBaseHttpReq) {
    }

    @Override // com.pay.http.APBaseHttpAns
    public void onStopAns(com.pay.http.APBaseHttpReq aPBaseHttpReq) {
    }

    public void setBeginTime(java.lang.String str) {
        this.beginTime = str;
    }

    public void setEndTime(java.lang.String str) {
        this.endTime = str;
    }

    public void setFirstsave_present_count(java.lang.String str) {
        this.firstsave_present_count = str;
    }

    public void setMpList(java.util.List list) {
        this.mpList = list;
    }

    public void setMpPresentList(java.util.List list) {
        this.mpPresentList = list;
    }

    public void setMpValueList(java.util.List list) {
        this.mpValueList = list;
    }

    public void setRate(java.lang.String str) {
        this.rate = str;
    }
}
