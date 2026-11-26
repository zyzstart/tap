package com.tencent.tmassistantbase.kapalai;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class KapalaiAdapterUtil {
    private static com.tencent.tmassistantbase.kapalai.commonmethods.IDualSimInfo[] allDualSimInfo = {new com.tencent.tmassistantbase.kapalai.commonmethods.CommonDualSimInfo00(), new com.tencent.tmassistantbase.kapalai.commonmethods.CommonDualSimInfo01(), new com.tencent.tmassistantbase.kapalai.commonmethods.CommonDualSimInfo02(), new com.tencent.tmassistantbase.kapalai.commonmethods.CommonDualSimInfo03(), new com.tencent.tmassistantbase.kapalai.commonmethods.CommonDualSimInfo04(), new com.tencent.tmassistantbase.kapalai.commonmethods.CommonDualSimInfo05(), new com.tencent.tmassistantbase.kapalai.commonmethods.CommonDualSimInfo06(), new com.tencent.tmassistantbase.kapalai.commonmethods.CommonDualSimInfo07(), new com.tencent.tmassistantbase.kapalai.commonmethods.CommonDualSimInfo08()};

    class KAUHolder {
        public static final com.tencent.tmassistantbase.kapalai.KapalaiAdapterUtil kauInstance = new com.tencent.tmassistantbase.kapalai.KapalaiAdapterUtil();

        private KAUHolder() {
        }
    }

    private KapalaiAdapterUtil() {
    }

    public static com.tencent.tmassistantbase.kapalai.KapalaiAdapterUtil getKAUInstance() {
        return com.tencent.tmassistantbase.kapalai.KapalaiAdapterUtil.KAUHolder.kauInstance;
    }

    public java.lang.String[] getContactGroupAccountNameAndType(android.content.Context context) {
        java.lang.String[] strArr = new java.lang.String[2];
        java.lang.String str = "";
        java.lang.String str2 = "";
        java.lang.String lowerCase = android.os.Build.MANUFACTURER.toLowerCase();
        java.lang.String lowerCase2 = android.os.Build.MODEL.toLowerCase();
        int i = android.os.Build.VERSION.SDK_INT;
        if (lowerCase2.equals("galaxy nexus") && i >= 14) {
            android.accounts.Account[] accounts = android.accounts.AccountManager.get(context).getAccounts();
            if (accounts.length > 0) {
                strArr[0] = accounts[0].name;
                strArr[1] = accounts[0].type;
                return strArr;
            }
        }
        if (lowerCase.indexOf("samsung") >= 0 || lowerCase.indexOf("samsng") >= 0) {
            str = "vnd.sec.contact.phone";
            str2 = "vnd.sec.contact.phone";
        } else if (lowerCase.indexOf("htc") >= 0) {
            str = "pcsc";
            str2 = "com.htc.android.pcsc";
        } else if (lowerCase.indexOf("sony ericsson") >= 0) {
            str = "Phone contacts";
            str2 = "com.sonyericsson.localcontacts";
        } else if (lowerCase.indexOf("zte") >= 0) {
            str = "local@ztespecial_local.com";
            str2 = "ztespecial_local.com";
        } else if (lowerCase.indexOf("moto") >= 0) {
            str = "phone-contacts";
            str2 = "com.contacts.phone";
        }
        strArr[0] = str;
        strArr[1] = str2;
        return strArr;
    }

    public android.net.Uri getContactGroupUri(long j) {
        return android.content.ContentUris.withAppendedId(android.provider.ContactsContract.Groups.CONTENT_URI, j).buildUpon().appendQueryParameter("caller_is_syncadapter", com.tencent.ysdk.shell.framework.config.Config.VALUE_SWITCH_ON).build();
    }

    public java.lang.String[] getDualSimIMEIInfoMethod(android.content.Context context) {
        java.lang.String[] strArr = new java.lang.String[2];
        for (int i = 0; i < 2; i++) {
            strArr[i] = allDualSimInfo[com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMEISolutionNum[i]].getKapalaiDualSimIMEI(com.tencent.tmassistantbase.kapalai.MobileIssueSettings.IMEIPos[i], context);
        }
        return strArr;
    }

    public java.lang.String[] getDualSimIMEIInfoNormalMethod(android.content.Context context) {
        java.lang.String[] strArr = new java.lang.String[2];
        int length = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.CommonIMEIPos.length;
        int i = 0;
        for (int i2 = 0; i2 < length && i < 2; i2++) {
            int length2 = allDualSimInfo.length;
            for (int i3 = 0; i3 < length2; i3++) {
                java.lang.String kapalaiDualSimIMEI = allDualSimInfo[i3].getKapalaiDualSimIMEI(com.tencent.tmassistantbase.kapalai.MobileIssueSettings.CommonIMEIPos[i2], context);
                if (kapalaiDualSimIMEI != null && kapalaiDualSimIMEI.length() != 0 && !kapalaiDualSimIMEI.equals(strArr[0])) {
                    strArr[i] = kapalaiDualSimIMEI;
                    i++;
                    break;
                }
            }
        }
        return strArr;
    }

    public java.lang.String[] getDualSimIMSIInfoMethod(android.content.Context context) {
        java.lang.String[] strArr = new java.lang.String[2];
        for (int i = 0; i < 2; i++) {
            strArr[i] = allDualSimInfo[com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum[i]].getKapalaiDualSimIMSI(com.tencent.tmassistantbase.kapalai.MobileIssueSettings.IMSISimPos[i], context);
        }
        return strArr;
    }

    public java.lang.String[] getDualSimIMSIInfoNormalMethod(android.content.Context context) {
        java.lang.String[] strArr = new java.lang.String[2];
        for (int i = 0; i < 2; i++) {
            int length = allDualSimInfo.length;
            for (int i2 = 0; i2 < length; i2++) {
                strArr[i] = allDualSimInfo[i2].getKapalaiDualSimIMSI(com.tencent.tmassistantbase.kapalai.MobileIssueSettings.IMSISimPos[i], context);
                if (strArr[i] != null && strArr[i].length() != 0) {
                    break;
                }
            }
        }
        return strArr;
    }

    public java.lang.String getHasShortcutUri() {
        java.lang.String lowerCase = android.os.Build.MODEL.toLowerCase();
        if (lowerCase.equals("gt-i9300")) {
            return "content://com.sec.android.app.launcher.settings/favorites?notify=true";
        }
        return lowerCase.equals("mi 1s") ? "content://com.miui.home.launcher.settings/favorites?notify=true" : "content://com.android.launcher.settings/favorites?notify=true";
    }

    public boolean getNotSupportBluetoothInAirplaneMode(android.content.Context context) {
        android.content.ContentResolver contentResolver = context.getContentResolver();
        return contentResolver != null && android.provider.Settings.System.getInt(contentResolver, "airplane_mode_on", 0) == 1;
    }
}
