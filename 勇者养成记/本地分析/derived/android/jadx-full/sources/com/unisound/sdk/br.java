package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class br extends android.os.AsyncTask<java.util.List<java.lang.String>, java.lang.Integer, java.lang.Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.unisound.sdk.bg f1542a;

    br(com.unisound.sdk.bg bgVar) {
        this.f1542a = bgVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public java.lang.Integer doInBackground(java.util.List<java.lang.String>... listArr) {
        return java.lang.Integer.valueOf(this.f1542a.b((java.util.List<java.lang.String>) listArr[0]));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(java.lang.Integer num) {
        com.unisound.sdk.bg bgVar;
        int i;
        if (num.intValue() == 0) {
            this.f1542a.ap.sendEmptyMessage(50);
            return;
        }
        switch (num.intValue()) {
            case 800:
                bgVar = this.f1542a;
                i = com.unisound.client.ErrorCode.ASR_SDK_UPLOAD_ONESHOT_ERR_ILLEGAL_CHAR;
                break;
            case 801:
                bgVar = this.f1542a;
                i = com.unisound.client.ErrorCode.ASR_SDK_UPLOAD_ONESHOT_ERR_TOO_MANY_WORDS;
                break;
            case 802:
                bgVar = this.f1542a;
                i = com.unisound.client.ErrorCode.ASR_SDK_UPLOAD_ONESHOT_ERR_NO_WORD;
                break;
            case 803:
                bgVar = this.f1542a;
                i = com.unisound.client.ErrorCode.ASR_SDK_UPLOAD_ONESHOT_ERR_DECODE;
                break;
            case com.unisound.client.ErrorCode.ERR_IO /* 804 */:
                bgVar = this.f1542a;
                i = com.unisound.client.ErrorCode.ASR_SDK_UPLOAD_ONESHOT_ERR_IO;
                break;
            case com.unisound.client.ErrorCode.ERR_NOT_CONSISTENCY /* 805 */:
                bgVar = this.f1542a;
                i = com.unisound.client.ErrorCode.ASR_SDK_UPLOAD_ONESHOT_ERR_NOT_CONSISTENCY;
                break;
            case com.unisound.client.ErrorCode.ERR_WRONG_NEW_WORDS /* 806 */:
                bgVar = this.f1542a;
                i = com.unisound.client.ErrorCode.ASR_SDK_UPLOAD_ONESHOT_ERR_WRONG_NEW_WORDS;
                break;
            case com.unisound.client.ErrorCode.ERR_BAD_PARA /* 807 */:
                bgVar = this.f1542a;
                i = com.unisound.client.ErrorCode.ASR_SDK_UPLOAD_ONESHOT_ERR_BAD_PARA;
                break;
            case com.unisound.client.ErrorCode.ERR_SAME_DATA /* 808 */:
                bgVar = this.f1542a;
                i = com.unisound.client.ErrorCode.ASR_SDK_UPLOAD_ONESHOT_ERR_SAME_DATA;
                break;
            default:
                this.f1542a.q(num.intValue());
                return;
        }
        bgVar.q(i);
    }
}
