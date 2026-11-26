package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class l {
    public java.lang.String d;
    public float e;
    public cn.yunzhisheng.nlu.OfflineNlu h;
    private java.lang.String i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public java.util.List<java.lang.String> f1567a = new java.util.ArrayList();
    public boolean b = true;
    public boolean c = false;
    public boolean f = false;
    public java.lang.String g = "";

    public static java.lang.String a(float f, java.lang.String str) {
        java.lang.String[] strArrSplit = str.split("\n");
        int length = strArrSplit.length - 1;
        if (length > 0) {
            return f > b(strArrSplit[length]) ? "" : str.replace(strArrSplit[length], "").trim();
        }
        return str;
    }

    private java.lang.String a(java.lang.String str, java.lang.String str2) {
        com.unisound.common.y.c("RecognizeResult", "rmIgnoreTag : result before ignoreTag :=", str2);
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append("<");
        stringBuffer.append(str);
        stringBuffer.append(">");
        java.lang.StringBuffer stringBuffer2 = new java.lang.StringBuffer();
        stringBuffer2.append("</");
        stringBuffer2.append(str);
        stringBuffer2.append(">");
        java.lang.String strReplaceAll = java.util.regex.Pattern.compile(stringBuffer2.toString()).matcher(java.util.regex.Pattern.compile(stringBuffer.toString()).matcher(str2).replaceAll("")).replaceAll("");
        com.unisound.common.y.c("RecognizeResult", "rmIgnoreTag : result end ignoreTag :=", strReplaceAll);
        return strReplaceAll;
    }

    public static float b(java.lang.String str) {
        try {
            return java.lang.Float.parseFloat(str);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return -100.0f;
        }
    }

    public static float d(java.lang.String str) {
        java.lang.String[] strArrSplit = str.split("\n");
        int length = strArrSplit.length - 1;
        if (length > 0) {
            return b(strArrSplit[length]);
        }
        return -25.0f;
    }

    public static java.lang.String e(java.lang.String str) {
        if (str.indexOf("<s>") >= 0) {
            str = str.substring(str.indexOf("<s>"));
        }
        java.lang.String strReplaceAll = str.replaceAll(" ", "");
        java.util.regex.Pattern patternCompile = java.util.regex.Pattern.compile("<s>|</s>");
        return java.util.regex.Pattern.compile("<[\\w]*>").matcher(java.util.regex.Pattern.compile("<[\\w]*>").matcher(patternCompile.matcher(strReplaceAll).replaceAll("")).replaceAll("").replaceAll("/", "")).replaceAll("").split("\n")[0].trim();
    }

    public java.lang.String a() {
        java.util.Iterator<java.lang.String> it = this.f1567a.iterator();
        return it.hasNext() ? it.next() : "";
    }

    public boolean a(java.lang.String str) {
        java.lang.String str2;
        this.d = "";
        if (str == null || str.length() == 0) {
            return false;
        }
        java.lang.String[] strArrSplit = java.util.regex.Pattern.compile("<[\\w]*>").matcher(java.util.regex.Pattern.compile("<[\\w]*>").matcher(java.util.regex.Pattern.compile("<s>|</s>").matcher(str).replaceAll("")).replaceAll("\n").replaceAll("/", "").replaceAll("\n\n", "\n")).replaceAll("").split("\n");
        this.e = -25.0f;
        int length = strArrSplit.length - 1;
        if (length <= 0) {
            return false;
        }
        this.e = b(strArrSplit[length]);
        if (length == 1) {
            str2 = strArrSplit[0];
        } else {
            str2 = strArrSplit[0] + strArrSplit[length - 1];
        }
        this.d = str2;
        return true;
    }

    public boolean a(java.lang.String str, boolean z, java.lang.String str2) {
        this.f1567a.clear();
        int i = 0;
        if (str == null || str.length() == 0) {
            return false;
        }
        if (str.split("\n").length < 2) {
            com.unisound.common.y.a("FixrecognizeResult -> setResultList: RecognitionResult error for lessing than two lines!");
            return false;
        }
        if (str.indexOf("<s>") >= 0) {
            str = str.substring(str.indexOf("<s>"));
        }
        if (this.f && !z) {
            if (this.g.equals("") || this.h == null) {
                com.unisound.common.y.e("RecognizeResult", "setResultList : nluConfigFile didn't exists or OfflineNlu is null");
                return false;
            }
            java.lang.String[] strArrSplit = str.split("\n");
            this.e = -25.0f;
            int length = strArrSplit.length - 1;
            if (length <= 0) {
                return false;
            }
            this.e = b(strArrSplit[length]);
            while (i < length) {
                this.f1567a.add(this.h.a("[" + strArrSplit[i] + "]", ""));
                i++;
            }
            return true;
        }
        if (this.c) {
            if (!android.text.TextUtils.isEmpty(str2)) {
                str = a(str2, str);
            }
            java.lang.String[] strArrSplit2 = str.split("\n");
            this.e = -25.0f;
            int length2 = strArrSplit2.length - 1;
            com.unisound.common.y.c("RecognizeResult", "setResultList : arrayOfstring.length =", java.lang.Integer.valueOf(strArrSplit2.length));
            if (length2 <= 0) {
                return false;
            }
            this.e = b(strArrSplit2[length2]);
            while (i < length2) {
                try {
                    this.f1567a.add(com.unisound.common.ai.b(strArrSplit2[i], this.e, this.i + "result.xml").toString().replace(" ", "").replace("_", ""));
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
                i++;
            }
            return true;
        }
        if (!this.b) {
            java.lang.String[] strArrSplit3 = str.split("\n");
            this.e = -25.0f;
            int length3 = strArrSplit3.length - 1;
            if (length3 <= 0) {
                return false;
            }
            this.e = b(strArrSplit3[length3]);
            while (i < length3) {
                this.f1567a.add(strArrSplit3[i]);
                i++;
            }
            return true;
        }
        java.lang.String[] strArrSplit4 = java.util.regex.Pattern.compile("<[\\w]*>").matcher(java.util.regex.Pattern.compile("<[\\w]*>").matcher(java.util.regex.Pattern.compile("<s>|</s>").matcher(str).replaceAll("")).replaceAll("").replaceAll("/", "")).replaceAll("").split("\n");
        this.e = -25.0f;
        int length4 = strArrSplit4.length - 1;
        if (length4 <= 0) {
            return false;
        }
        this.e = b(strArrSplit4[length4]);
        while (i < length4) {
            this.f1567a.add(strArrSplit4[i]);
            i++;
        }
        return true;
    }

    public void c(java.lang.String str) {
        this.i = str;
    }

    public java.lang.String toString() {
        java.lang.String str = this.d;
        if (str == null || str.length() <= 0) {
            return "";
        }
        return this.d + "\n" + this.e;
    }
}
