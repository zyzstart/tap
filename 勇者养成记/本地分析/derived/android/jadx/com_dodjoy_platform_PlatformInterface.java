package com.dodjoy.platform;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class PlatformInterface {
    private static boolean isFirstUse;
    private static android.app.Activity mActivity;
    private static java.lang.String mListenerName;
    private static org.json.JSONObject mSdkCfgJson;
    static com.dodjoy.platform.IThirdPlatform sPlatform;
    private static com.dodjoy.platform.PlatformStatisticsData sStatisticsData = new com.dodjoy.platform.PlatformStatisticsData();
    private static boolean m_haveInitCfg = false;
    private static boolean mHaveAdTracking = false;
    private static boolean mEnteredGame = false;

    public class PlatformDealType {
        public static final int PDTAchievementUnlocked = 25;
        public static final int PDTAuthFailed = 23;
        public static final int PDTAuthInfo = 20;
        public static final int PDTChargeSuccess = 18;
        public static final int PDTClickCurrencyAdd = 39;
        public static final int PDTClickStore = 38;
        public static final int PDTClickVnWebCharge = 40;
        public static final int PDTCreateRole = 11;
        public static final int PDTCustomData = 1000;
        public static final int PDTDailycheck = 28;
        public static final int PDTEnterGame = 12;
        public static final int PDTEventLog = 37;
        public static final int PDTExitGame = 16;
        public static final int PDTFinishLoading = 31;
        public static final int PDTFirstPay = 27;
        public static final int PDTLevelStage = 36;
        public static final int PDTLoadDir = 34;
        public static final int PDTLoadDirSuc = 35;
        public static final int PDTNaver = 32;
        public static final int PDTSelectRole = 21;
        public static final int PDTSetAreaID = 1;
        public static final int PDTSetAreaName = 2;
        public static final int PDTSetCorpName = 9;
        public static final int PDTSetFightVal = 10;
        public static final int PDTSetGender = 19;
        public static final int PDTSetGold = 7;
        public static final int PDTSetMergeAreaID = 41;
        public static final int PDTSetMergeAreaName = 42;
        public static final int PDTSetPayUrl = 17;
        public static final int PDTSetRoleCreateTime = 15;
        public static final int PDTSetRoleID = 3;
        public static final int PDTSetRoleJob = 6;
        public static final int PDTSetRoleLevel = 5;
        public static final int PDTSetRoleName = 4;
        public static final int PDTSetVipLevel = 14;
        public static final int PDTSetYuan = 8;
        public static final int PDTShowCustomerService = 29;
        public static final int PDTShowFullBanner = 30;
        public static final int PDTSubscribeMonthCard = 26;
        public static final int PDTTurorialCompletion = 24;
        public static final int PDTUpgrade = 22;
        public static final int PDTUpgradeSuc = 33;
        public static final int PDTUserCenter = 13;

        public PlatformDealType() {
        }
    }

    private static void ClearData() {
        com.dodjoy.utils.DodLog.Log("on clear data");
        sStatisticsData.ClearData();
        mEnteredGame = false;
    }

    public static void DealMessage(int i, java.lang.String str) {
        com.dodjoy.utils.DodLog.Log("type is " + i + " mess is " + str);
        switch (i) {
            case 1:
                com.dodjoy.platform.PlatformStatisticsData platformStatisticsData = sStatisticsData;
                platformStatisticsData.m_areaID = str;
                com.dodjoy.platform.ThirdStatistics.tdgaSetGameServer(platformStatisticsData.m_areaID);
                break;
            case 2:
                sStatisticsData.m_areaName = str;
                break;
            case 3:
                sStatisticsData.m_roleID = str;
                break;
            case 4:
                com.dodjoy.platform.PlatformStatisticsData platformStatisticsData2 = sStatisticsData;
                platformStatisticsData2.m_roleName = str;
                com.dodjoy.platform.ThirdStatistics.tdgaSetAccountName(platformStatisticsData2.m_roleName);
                break;
            case 5:
                sStatisticsData.m_roleLevel = str;
                if (mEnteredGame && mHaveAdTracking) {
                    try {
                        com.dodjoy.platform.ThirdStatistics.tdgaSetLevel(java.lang.Integer.parseInt(getLevel()));
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 6:
                sStatisticsData.m_roleJob = str;
                break;
            case 7:
                sStatisticsData.m_gameGoldBalance = str;
                break;
            case 8:
                sStatisticsData.m_rmbVal = str;
                break;
            case 9:
                sStatisticsData.m_gameUnionName = str;
                break;
            case 10:
                sStatisticsData.m_fightVal = str;
                break;
            case 11:
                if (mHaveAdTracking) {
                    try {
                        java.lang.Long.valueOf(getRoleID()).longValue();
                        com.dmlt.tracking.sdk.Tracking.setRoleInfo(getRoleID(), java.lang.Integer.valueOf(getAreaID()).intValue(), 1, getRoleName());
                        com.dmlt.tracking.sdk.Tracking.reportCreateRole();
                    } catch (java.lang.Exception e2) {
                        e2.printStackTrace();
                    }
                }
                break;
            case 12:
                mEnteredGame = true;
                if (mHaveAdTracking) {
                    try {
                        com.dmlt.tracking.sdk.Tracking.setUinInfo(java.lang.Integer.valueOf(getAccountID()).intValue(), GetRegion(), GetChannelName());
                        com.dmlt.tracking.sdk.Tracking.setRoleInfo(getRoleID(), java.lang.Integer.valueOf(getAreaID()).intValue(), java.lang.Integer.valueOf(getLevel()).intValue(), getRoleName());
                        com.dmlt.tracking.sdk.Tracking.reportLogin();
                    } catch (java.lang.Exception e3) {
                        e3.printStackTrace();
                    }
                }
                break;
            default:
                switch (i) {
                    case 14:
                        sStatisticsData.m_vipLv = str;
                        break;
                    case 15:
                        sStatisticsData.m_roleCreateTime = str;
                        break;
                    default:
                        switch (i) {
                            case 18:
                                if (mHaveAdTracking) {
                                    try {
                                        org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                                        com.dmlt.tracking.sdk.Tracking.reportRecharge(jSONObject.getString("GoodID"), jSONObject.getString("OrderID"), java.lang.Integer.valueOf(jSONObject.getString("Price")).intValue());
                                    } catch (java.lang.Exception e4) {
                                        e4.printStackTrace();
                                    }
                                }
                                break;
                            case 19:
                                sStatisticsData.m_gender = str;
                                break;
                            case 20:
                                try {
                                    org.json.JSONObject jSONObject2 = new org.json.JSONObject(str);
                                    int i2 = jSONObject2.getInt("uin");
                                    sStatisticsData.m_accountID = java.lang.String.valueOf(i2);
                                    com.dodjoy.platform.ThirdStatistics.tdgaSetAccount(sStatisticsData.m_accountID);
                                    com.dodjoy.platform.ThirdStatistics.tdgaSetAccountType(0);
                                    if (mHaveAdTracking && jSONObject2.getInt("authtime") == java.lang.Integer.parseInt(jSONObject2.getString("createtime"))) {
                                        com.dmlt.tracking.sdk.Tracking.setUinInfo(i2, GetRegion(), GetChannelName());
                                        com.dmlt.tracking.sdk.Tracking.reportRegister();
                                    }
                                } catch (java.lang.Exception e5) {
                                    e5.printStackTrace();
                                }
                                break;
                            default:
                                switch (i) {
                                    case 41:
                                        sStatisticsData.m_mergeAreaId = str;
                                        break;
                                    case 42:
                                        sStatisticsData.m_mergeAreaName = str;
                                        break;
                                }
                                break;
                        }
                        break;
                }
                break;
        }
        com.dodjoy.platform.IThirdPlatform iThirdPlatform = sPlatform;
        if (iThirdPlatform != null) {
            iThirdPlatform.DealMessage(i, str);
        }
    }

    public static int ExitGame() {
        com.dodjoy.platform.IThirdPlatform iThirdPlatform = sPlatform;
        if (iThirdPlatform != null) {
            return iThirdPlatform.exitGame();
        }
        return 0;
    }

    public static void GameToPlatformLogout() {
        com.dodjoy.utils.DodLog.i(com.dodjoy.utils.DodLog.TAG, "GameToPlatformLogout");
        com.dodjoy.platform.IThirdPlatform iThirdPlatform = sPlatform;
        if (iThirdPlatform != null) {
            iThirdPlatform.GameToPlatformLogout();
        }
    }

    public static java.lang.String GetChannelName() {
        try {
            java.lang.String strGetDodSdkCfg = GetDodSdkCfg("DodStaticsName");
            return android.text.TextUtils.isEmpty(strGetDodSdkCfg) ? "guanwang" : strGetDodSdkCfg;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "guanwang";
        }
    }

    public static java.lang.String GetDodSdkCfg(java.lang.String str) {
        org.json.JSONObject jSONObject = mSdkCfgJson;
        if (jSONObject == null || !jSONObject.has(str)) {
            return "";
        }
        try {
            return mSdkCfgJson.getString(str);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static org.json.JSONObject GetDodSdkCfgJson() {
        return mSdkCfgJson;
    }

    public static java.lang.String GetLocalLanguage() {
        java.util.Locale locale = android.os.Build.VERSION.SDK_INT >= 24 ? mActivity.getResources().getConfiguration().getLocales().get(0) : mActivity.getResources().getConfiguration().locale;
        java.lang.String language = locale.getLanguage();
        if (language.equals("in")) {
            language = "id";
        }
        if (language.equals("iw")) {
            language = "he";
        }
        if (language.equals("ji")) {
            language = "yi";
        }
        return language + "-" + locale.getCountry();
    }

    public static com.dodjoy.platform.IThirdPlatform GetPlatformObj() {
        return sPlatform;
    }

    public static int GetRegion() {
        try {
            java.lang.String strGetDodSdkCfg = GetDodSdkCfg("region");
            if (android.text.TextUtils.isEmpty(strGetDodSdkCfg)) {
                return 1;
            }
            return java.lang.Integer.valueOf(strGetDodSdkCfg).intValue();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    public static java.lang.String GetSdkCountryInfo() {
        com.dodjoy.platform.IThirdPlatform iThirdPlatform = sPlatform;
        return iThirdPlatform != null ? iThirdPlatform.getSdkCountryInfo() : "";
    }

    private static void InitSdkCfg(android.content.Context context) {
        if (m_haveInitCfg) {
            return;
        }
        m_haveInitCfg = true;
        try {
            java.io.InputStream inputStreamOpen = context.getResources().getAssets().open("SdkCfg.bytes");
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            while (true) {
                int i = inputStreamOpen.read();
                if (i == -1) {
                    mSdkCfgJson = new org.json.JSONObject(byteArrayOutputStream.toString());
                    return;
                }
                byteArrayOutputStream.write(i);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void OnPlatformExit(boolean z) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("showGameExit", z ? 1 : 0);
            sendU3dMessage("OnPlatformExit", jSONObject);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public static void PlatformToGameLogout() {
        com.dodjoy.utils.DodLog.i(com.dodjoy.utils.DodLog.TAG, "PlatformToGameLogout");
        if (mHaveAdTracking) {
            try {
                java.lang.Integer.parseInt(getAccountID());
                java.lang.Long.parseLong(getRoleID());
                java.lang.Integer.parseInt(getAreaID());
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        ClearData();
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put(com.tencent.midas.api.APMidasPayAPI.ENV_TEST, com.tencent.midas.api.APMidasPayAPI.ENV_TEST);
            sendU3dMessage("PlatformToGameLogout", jSONObject);
        } catch (org.json.JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void PreventIndulge() {
        com.dodjoy.platform.IThirdPlatform iThirdPlatform = sPlatform;
        if (iThirdPlatform != null) {
            iThirdPlatform.preventIndulge();
        }
    }

    public static void ReqSpringGameFBAct(int i, boolean z) {
        com.dodjoy.platform.IThirdPlatform iThirdPlatform = sPlatform;
        if (iThirdPlatform != null) {
            iThirdPlatform.reqSpringGameFBAct(i, z);
        }
    }

    public static void RequestPermission(java.lang.String str) {
        com.dodjoy.utils.DodLog.Log("sdk RequestPermission");
        com.dodjoy.utils.XXPermissionHelper.RequestPermission(mActivity, str);
    }

    public static void RequestPermissionList(java.lang.String str) {
        com.dodjoy.utils.DodLog.Log("sdk RequestPermission array");
        try {
            org.json.JSONArray jSONArray = new org.json.JSONArray(str);
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.getString(i));
            }
            com.dodjoy.utils.XXPermissionHelper.RequestPermission(mActivity, (java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()]));
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }

    public static void SetListener(java.lang.String str) {
        mListenerName = str;
    }

    public static void attachBaseContext(android.content.Context context) {
        try {
            if (sPlatform != null) {
                sPlatform.attachBaseContext(context);
            }
        } catch (java.lang.Exception unused) {
        }
        InitSdkCfg(context);
        if (!android.text.TextUtils.isEmpty(GetDodSdkCfg("[REDACTED]"))) {
            mHaveAdTracking = true;
            try {
                com.bun.miitmdid.core.JLibrary.InitEntry(context);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        com.dodjoy.platform.ActivityLifeCirleMgr.getInstance().attachBaseContext(context);
    }

    static void checkInit() {
        if (com.dodjoy.utils.DodSdkEngine.getDodApiHandler() == null) {
            throw new java.lang.IllegalStateException("please invoke PlatformInterface.init() first");
        }
    }

    public static int doSdkLogin() {
        com.dodjoy.utils.DodLog.Log("on call sdk login");
        com.dodjoy.platform.IThirdPlatform iThirdPlatform = sPlatform;
        if (iThirdPlatform == null) {
            android.util.Log.e("Unity", "splatform is null");
            return 0;
        }
        if (iThirdPlatform.quickLogin()) {
            return 1;
        }
        return sPlatform.login();
    }

    public static void doSdkPay(java.lang.String str, java.lang.String str2, java.lang.String str3, int i, float f, java.lang.String str4) {
        com.dodjoy.platform.IThirdPlatform iThirdPlatform = sPlatform;
        if (iThirdPlatform != null) {
            iThirdPlatform.doSdkPay(str, str2, str3, i, f, str4);
        }
    }

    public static java.lang.String getAccountID() {
        return sStatisticsData.m_accountID;
    }

    public static java.lang.String getAppName() {
        android.app.Activity activity = mActivity;
        if (activity == null) {
            return "";
        }
        android.content.res.Resources resources = activity.getResources();
        android.app.Activity activity2 = mActivity;
        return activity2.getString(resources.getIdentifier("app_name", "string", activity2.getPackageName()));
    }

    public static java.lang.String getAreaID() {
        return sStatisticsData.m_areaID;
    }

    public static java.lang.String getAreaName() {
        return sStatisticsData.m_areaName;
    }

    public static java.lang.String getChannelName() {
        com.dodjoy.platform.IThirdPlatform iThirdPlatform = sPlatform;
        return iThirdPlatform != null ? iThirdPlatform.getChannelName() : "";
    }

    public static android.app.Activity getCurActivity() {
        return mActivity;
    }

    public static java.lang.String getFightVal() {
        return sStatisticsData.m_fightVal;
    }

    public static java.lang.String getGameGoldBalance() {
        return sStatisticsData.m_gameGoldBalance;
    }

    public static java.lang.String getGameUnionName() {
        return sStatisticsData.m_gameUnionName;
    }

    public static java.lang.String getGender() {
        return sStatisticsData.m_gender;
    }

    public static java.lang.String getLevel() {
        return sStatisticsData.m_roleLevel;
    }

    public static java.lang.String getMergeAreaID() {
        return sStatisticsData.m_mergeAreaId;
    }

    public static java.lang.String getMergeAreaName() {
        return sStatisticsData.m_mergeAreaName;
    }

    public static java.lang.String getRMBVal() {
        return sStatisticsData.m_rmbVal;
    }

    public static java.lang.String getRoleCreateTime() {
        return sStatisticsData.m_roleCreateTime;
    }

    public static java.lang.String getRoleID() {
        return sStatisticsData.m_roleID;
    }

    public static java.lang.String getRoleJob() {
        return sStatisticsData.m_roleJob;
    }

    public static java.lang.String getRoleName() {
        return sStatisticsData.m_roleName;
    }

    public static java.lang.String getVipLv() {
        return sStatisticsData.m_vipLv;
    }

    public static void init(com.dodjoy.utilities.IUnityPlayer iUnityPlayer, java.lang.String str, final android.os.Bundle bundle) {
        android.util.Log.e("Unity", "init ");
        com.dodjoy.utilities.DodBaseContext.SetUnityPlayer(iUnityPlayer);
        mActivity = iUnityPlayer.GetGameActivity();
        com.dodjoy.utils.DodLog.enableLog(false);
        com.dodjoy.utils.DodSdkEngine.getInstance().start();
        com.dodjoy.platform.PlatformConfig.Init(mActivity);
        ClearData();
        InitSdkCfg(mActivity);
        sPlatform = com.dodjoy.thirdPlatform.ThirdPlatformFactory.create();
        final android.content.SharedPreferences sharedPreferences = mActivity.getSharedPreferences("isFirstUse", 0);
        isFirstUse = sharedPreferences.getBoolean("isFirstUse", true);
        android.util.Log.d("m_haveBAIDU", "isFirstUse: " + isFirstUse);
        com.dodjoy.privacy.DodPrivacyHelper.getInstance().Init(mActivity, new com.dodjoy.privacy.DodPrivacyCallback() { // from class: com.dodjoy.platform.PlatformInterface.1
            @Override // com.dodjoy.privacy.DodPrivacyCallback
            public void agree() {
                java.lang.String str2;
                if (com.dodjoy.platform.PlatformInterface.sPlatform != null) {
                    com.dodjoy.platform.PlatformInterface.sPlatform.initWithInstance(com.dodjoy.platform.PlatformInterface.mActivity, bundle);
                }
                android.os.Bundle bundleGetMetaData = com.dodjoy.platform.PlatformConfig.GetMetaData();
                java.lang.String metaString = com.dodjoy.platform.PlatformInterface.readMetaString(bundleGetMetaData, "[REDACTED]");
                if (com.dodjoy.platform.PlatformInterface.isFirstUse) {
                    android.content.SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    editorEdit.putBoolean("isFirstUse", false);
                    editorEdit.commit();
                    com.dodjoy.utils.XXPermissionHelper.RequestPermission(com.dodjoy.platform.PlatformInterface.mActivity, "android.permission.READ_PHONE_STATE");
                }
                java.lang.String strGetDodSdkCfg = com.dodjoy.platform.PlatformInterface.GetDodSdkCfg("DodTeaAppID");
                if (android.text.TextUtils.isEmpty(metaString)) {
                    java.lang.String strGetDodSdkCfg2 = com.dodjoy.platform.PlatformInterface.GetDodSdkCfg("[REDACTED]");
                    if (!android.text.TextUtils.isEmpty(strGetDodSdkCfg2)) {
                        boolean unused = com.dodjoy.platform.PlatformInterface.mHaveAdTracking = true;
                        java.lang.String strGetDodSdkCfg3 = com.dodjoy.platform.PlatformInterface.GetDodSdkCfg("DodAdChannel");
                        java.lang.String strGetDodSdkCfg4 = com.dodjoy.platform.PlatformInterface.GetDodSdkCfg("DodAID");
                        java.lang.String strGetDodSdkCfg5 = com.dodjoy.platform.PlatformInterface.GetDodSdkCfg("DodCID");
                        java.lang.String channel = com.bytedance.hume.readapk.HumeSDK.getChannel(com.dodjoy.platform.PlatformInterface.mActivity);
                        com.dmlt.tracking.sdk.Tracking.init(com.dodjoy.platform.PlatformInterface.mActivity, strGetDodSdkCfg2, strGetDodSdkCfg4, android.text.TextUtils.isEmpty(channel) ? strGetDodSdkCfg5 : channel, strGetDodSdkCfg3, com.dodjoy.platform.PlatformInterface.GetDodSdkCfg("DodSubChannel"), false);
                    }
                } else {
                    com.dodjoy.utils.XXPermissionHelper.RequestPermission(com.dodjoy.platform.PlatformInterface.mActivity, "android.permission.READ_PHONE_STATE");
                    boolean unused2 = com.dodjoy.platform.PlatformInterface.mHaveAdTracking = true;
                    java.lang.String metaString2 = com.dodjoy.platform.PlatformInterface.readMetaString(bundleGetMetaData, "AdChannel");
                    java.lang.String metaString3 = com.dodjoy.platform.PlatformInterface.readMetaString(bundleGetMetaData, "AID");
                    java.lang.String metaString4 = com.dodjoy.platform.PlatformInterface.readMetaString(bundleGetMetaData, "CID");
                    if (android.text.TextUtils.isEmpty(strGetDodSdkCfg)) {
                        str2 = metaString4;
                    } else {
                        java.lang.String channel2 = com.bytedance.hume.readapk.HumeSDK.getChannel(com.dodjoy.platform.PlatformInterface.mActivity);
                        com.dodjoy.utils.DodLog.Log("cid = " + channel2);
                        str2 = channel2;
                    }
                    com.dmlt.tracking.sdk.Tracking.init(com.dodjoy.platform.PlatformInterface.mActivity, metaString, metaString3, str2, metaString2, com.dodjoy.platform.PlatformInterface.readMetaString(bundleGetMetaData, "SubChannel"), false);
                }
                com.dodjoy.platform.ThirdStatistics.init(com.dodjoy.platform.PlatformInterface.mActivity, com.dodjoy.platform.PlatformInterface.readMetaString(bundleGetMetaData, "DodTDID"), com.dodjoy.platform.PlatformInterface.getChannelName());
            }

            @Override // com.dodjoy.privacy.DodPrivacyCallback
            public void cancel() {
            }
        });
    }

    public static void initThirdSdk() {
        com.dodjoy.utils.DodLog.Log("on init thrid sdk");
        com.dodjoy.platform.IThirdPlatform iThirdPlatform = sPlatform;
        if (iThirdPlatform != null) {
            iThirdPlatform.initThirdSdk();
        }
    }

    public static void onActivityResult(int i, int i2, android.content.Intent intent) {
        com.dodjoy.platform.IThirdPlatform iThirdPlatform = sPlatform;
        if (iThirdPlatform != null) {
            iThirdPlatform.onActivityResult(i, i2, intent);
        }
        com.dodjoy.platform.ActivityLifeCirleMgr.getInstance().onActivityResult(i, i2, intent);
    }

    public static void onBackPressed() {
        com.dodjoy.platform.IThirdPlatform iThirdPlatform = sPlatform;
        if (iThirdPlatform != null) {
            iThirdPlatform.onBackPressed();
        }
    }

    public static void onConfigurationChanged(android.content.res.Configuration configuration) {
        com.dodjoy.platform.IThirdPlatform iThirdPlatform = sPlatform;
        if (iThirdPlatform != null) {
            iThirdPlatform.onConfigurationChanged(configuration);
        }
        com.dodjoy.platform.ActivityLifeCirleMgr.getInstance().onConfigurationChanged(configuration);
    }

    public static void onDestroy() {
        com.dodjoy.platform.IThirdPlatform iThirdPlatform = sPlatform;
        if (iThirdPlatform != null) {
            iThirdPlatform.onDestroy();
        }
        com.dodjoy.thirdPlatform.ThirdPlatformAd.onDestroy();
        com.dodjoy.platform.ActivityLifeCirleMgr.getInstance().onDestroy();
    }

    public static void onLoginCancel(org.json.JSONObject jSONObject) {
        sendU3dMessage("LoginCancel", jSONObject);
    }

    public static void onLoginSuccess(org.json.JSONObject jSONObject) {
        sendU3dMessage("LoginSuccess", jSONObject);
    }

    public static void onNewIntent(android.content.Intent intent) {
        com.dodjoy.platform.IThirdPlatform iThirdPlatform = sPlatform;
        if (iThirdPlatform != null) {
            iThirdPlatform.onNewIntent(intent);
        }
        com.dodjoy.platform.ActivityLifeCirleMgr.getInstance().onNewIntent(intent);
    }

    public static void onPause() {
        com.dodjoy.platform.IThirdPlatform iThirdPlatform = sPlatform;
        if (iThirdPlatform != null) {
            iThirdPlatform.onPause();
        }
        com.dodjoy.thirdPlatform.ThirdPlatformAd.onPause();
        com.dodjoy.platform.ThirdStatistics.onPause(mActivity);
        com.dodjoy.platform.ActivityLifeCirleMgr.getInstance().onPause();
    }

    public static void onPayCancel(int i) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put(com.tencent.open.SocialConstants.PARAM_TYPE, i);
            sendU3dMessage("onPayCancel", jSONObject);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public static void onPaySuccess(org.json.JSONObject jSONObject) {
        sendU3dMessage("onPaySuccess", jSONObject);
    }

    public static void onRequestPermissionsResult(int i, java.lang.String[] strArr, int[] iArr) {
        com.dodjoy.platform.IThirdPlatform iThirdPlatform = sPlatform;
        if (iThirdPlatform != null) {
            iThirdPlatform.onRequestPermissionsResult(i, strArr, iArr);
        }
        com.dodjoy.platform.ActivityLifeCirleMgr.getInstance().onRequestPermissionsResult(i, strArr, iArr);
    }

    public static void onRestart() {
        com.dodjoy.platform.IThirdPlatform iThirdPlatform = sPlatform;
        if (iThirdPlatform != null) {
            iThirdPlatform.onRestart();
        }
        com.dodjoy.platform.ActivityLifeCirleMgr.getInstance().onRestart();
    }

    public static void onResume() {
        com.dodjoy.platform.IThirdPlatform iThirdPlatform = sPlatform;
        if (iThirdPlatform != null) {
            iThirdPlatform.onResume();
        }
        com.dodjoy.thirdPlatform.ThirdPlatformAd.onResume();
        com.dodjoy.platform.ThirdStatistics.onResume(mActivity);
        com.dodjoy.platform.ActivityLifeCirleMgr.getInstance().onResume();
    }

    public static void onSaveInstanceState(android.os.Bundle bundle) {
        com.dodjoy.platform.IThirdPlatform iThirdPlatform = sPlatform;
        if (iThirdPlatform != null) {
            iThirdPlatform.onSaveInstanceState(bundle);
        }
        com.dodjoy.platform.ActivityLifeCirleMgr.getInstance().onSaveInstanceState(bundle);
    }

    public static void onStart() {
        com.dodjoy.platform.IThirdPlatform iThirdPlatform = sPlatform;
        if (iThirdPlatform != null) {
            iThirdPlatform.onStart();
        }
        com.dodjoy.platform.ActivityLifeCirleMgr.getInstance().onStart();
    }

    public static void onStop() {
        com.dodjoy.platform.IThirdPlatform iThirdPlatform = sPlatform;
        if (iThirdPlatform != null) {
            iThirdPlatform.onStop();
        }
        com.dodjoy.platform.ActivityLifeCirleMgr.getInstance().onStop();
    }

    public static boolean quickLogin() {
        com.dodjoy.platform.IThirdPlatform iThirdPlatform = sPlatform;
        if (iThirdPlatform != null) {
            return iThirdPlatform.quickLogin();
        }
        return false;
    }

    public static java.lang.String readMetaString(android.os.Bundle bundle, java.lang.String str) {
        if (!bundle.containsKey(str)) {
            return "";
        }
        java.lang.Object obj = bundle.get(str);
        if (obj instanceof java.lang.String) {
            return (java.lang.String) obj;
        }
        return obj instanceof java.lang.Integer ? java.lang.String.valueOf(((java.lang.Integer) obj).intValue()) : "";
    }

    public static void sendU3dMessage(java.lang.String str, org.json.JSONObject jSONObject) {
        if (jSONObject != null) {
            com.dodjoy.utilities.DodBaseContext.UnitySendMessage(mListenerName, str, jSONObject.toString());
        } else {
            com.dodjoy.utilities.DodBaseContext.UnitySendMessage(mListenerName, str, "");
        }
    }

    public static boolean supportSwitchAccount() {
        com.dodjoy.platform.IThirdPlatform iThirdPlatform = sPlatform;
        if (iThirdPlatform != null) {
            return iThirdPlatform.supportSwitchAccount();
        }
        return false;
    }
}
