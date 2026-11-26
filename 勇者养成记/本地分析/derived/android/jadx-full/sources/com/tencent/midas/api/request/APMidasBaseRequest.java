package com.tencent.midas.api.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class APMidasBaseRequest implements java.io.Serializable {
    public static final int MALL_TYPE_DEFAULT = 0;
    public static final int MALL_TYPE_GROUPBUY = 1;
    public static final int MALL_TYPE_VMALL = 2;
    private static final long serialVersionUID = -9123623786877679280L;
    public java.lang.String h5Url;
    public int mallType;
    public byte[] resData;
    public java.lang.String reserv;
    public java.lang.String offerId = "";
    public java.lang.String openId = "";
    public java.lang.String openKey = "";
    public java.lang.String sessionId = "";
    public java.lang.String sessionType = "";
    public java.lang.String zoneId = "";
    public java.lang.String pf = "";
    public java.lang.String pfKey = "";
    public int resId = 0;
    public java.lang.String acctType = "common";
    public java.lang.String saveValue = "";
    public boolean isCanChange = true;
    public java.lang.String remark = "";
    public com.tencent.midas.api.request.APMidasBaseRequest.APMidasMPInfo mpInfo = new com.tencent.midas.api.request.APMidasBaseRequest.APMidasMPInfo();
    public com.tencent.midas.api.request.APMidasBaseRequest.APMidasExtendInfo extendInfo = new com.tencent.midas.api.request.APMidasBaseRequest.APMidasExtendInfo();

    public class APMidasExtendInfo implements java.io.Serializable {
        private static final long serialVersionUID = -5387967973327966068L;
        public java.lang.String unit = "";
        public boolean isShowNum = true;
        public boolean isShowListOtherNum = true;

        public APMidasExtendInfo() {
        }
    }

    public class APMidasMPInfo implements java.io.Serializable {
        private static final long serialVersionUID = 631101753621041424L;
        public java.lang.String discoutId;
        public java.lang.String drmInfo;
        public java.lang.String extras;
        public java.lang.String payChannel = "";
        public java.lang.String discountType = "";
        public java.lang.String discountUrl = "";

        public APMidasMPInfo() {
            this.drmInfo = "";
            this.discoutId = "";
            this.extras = "";
            this.drmInfo = "";
            this.discoutId = "";
            this.extras = "";
        }
    }

    public APMidasBaseRequest() {
        this.mallType = 0;
        this.h5Url = "";
        this.mallType = 0;
        this.h5Url = "";
    }

    public java.lang.String getAcctType() {
        return this.acctType;
    }

    public java.lang.String getDiscountType() {
        return this.mpInfo.discountType;
    }

    public java.lang.String getDiscountUrl() {
        return this.mpInfo.discountUrl;
    }

    public java.lang.String getDiscoutId() {
        return this.mpInfo.discoutId;
    }

    public java.lang.String getDrmInfo() {
        return this.mpInfo.drmInfo;
    }

    public java.lang.String getExtras() {
        return this.mpInfo.extras;
    }

    public java.lang.String getH5Url() {
        return this.h5Url;
    }

    public boolean getIsCanChange() {
        return this.isCanChange;
    }

    public int getMallType() {
        return this.mallType;
    }

    public java.lang.String getOfferId() {
        return this.offerId;
    }

    public java.lang.String getOpenId() {
        return this.openId;
    }

    public java.lang.String getOpenKey() {
        return this.openKey;
    }

    public java.lang.String getPayChannel() {
        return this.mpInfo.payChannel;
    }

    public java.lang.String getPf() {
        return this.pf;
    }

    public java.lang.String getPfKey() {
        return this.pfKey;
    }

    public java.lang.String getRemark() {
        return this.remark;
    }

    public byte[] getResData() {
        return this.resData;
    }

    public int getResId() {
        return this.resId;
    }

    public java.lang.String getReserv() {
        return this.reserv;
    }

    public java.lang.String getSaveValue() {
        return this.saveValue;
    }

    public java.lang.String getSessionId() {
        return this.sessionId;
    }

    public java.lang.String getSessionType() {
        return this.sessionType;
    }

    public boolean getShowListOtherNum() {
        return this.extendInfo.isShowListOtherNum;
    }

    public boolean getShowNum() {
        return this.extendInfo.isShowNum;
    }

    public java.lang.String getUnit() {
        return this.extendInfo.unit;
    }

    public java.lang.String getZoneId() {
        return this.zoneId;
    }

    public void setAcctType(java.lang.String str) {
        this.acctType = str;
    }

    public void setDiscountType(java.lang.String str) {
        this.mpInfo.discountType = str;
    }

    public void setDiscountUrl(java.lang.String str) {
        this.mpInfo.discountUrl = str;
    }

    public void setDiscoutId(java.lang.String str) {
        this.mpInfo.discoutId = str;
    }

    public void setDrmInfo(java.lang.String str) {
        this.mpInfo.drmInfo = str;
    }

    public void setExtras(java.lang.String str) {
        this.mpInfo.extras = str;
    }

    public void setH5Url(java.lang.String str) {
        this.h5Url = str;
    }

    public void setIsCanChange(boolean z) {
        this.isCanChange = z;
    }

    public void setMallType(int i) {
        this.mallType = i;
    }

    public void setOfferId(java.lang.String str) {
        this.offerId = str;
    }

    public void setOpenId(java.lang.String str) {
        this.openId = str;
    }

    public void setOpenKey(java.lang.String str) {
        this.openKey = str;
    }

    public void setPayChannel(java.lang.String str) {
        this.mpInfo.payChannel = str;
    }

    public void setPf(java.lang.String str) {
        this.pf = str;
    }

    public void setPfKey(java.lang.String str) {
        this.pfKey = str;
    }

    public void setRemark(java.lang.String str) {
        this.remark = str;
    }

    public void setResData(byte[] bArr) {
        this.resData = bArr;
    }

    public void setResId(int i) {
        this.resId = i;
    }

    public void setReserv(java.lang.String str) {
        this.reserv = str;
    }

    public void setSaveValue(java.lang.String str) {
        this.saveValue = str;
    }

    public void setSessionId(java.lang.String str) {
        this.sessionId = str;
    }

    public void setSessionType(java.lang.String str) {
        this.sessionType = str;
    }

    public void setShowListOtherNum(boolean z) {
        this.extendInfo.isShowListOtherNum = z;
    }

    public void setShowNum(boolean z) {
        this.extendInfo.isShowNum = z;
    }

    public void setUnit(java.lang.String str) {
        this.extendInfo.unit = str;
    }

    public void setZoneId(java.lang.String str) {
        this.zoneId = str;
    }
}
