package com.youme.im;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class IMEngine {
    private static int ENGINE_NOT_INIT = 1;
    private static java.lang.String m_appKey = null;
    private static java.lang.String m_appSecret = null;
    public static boolean m_init = false;
    private static boolean m_loadedLibrary = false;
    private static int m_serverZone;
    private static android.content.BroadcastReceiver s_netStatusReceiver;

    public class IntegerVal {
        private int iValue = 0;

        public IntegerVal() {
        }

        public int getValue() {
            return this.iValue;
        }

        public void setValue(int i) {
            this.iValue = i;
        }
    }

    public class MessageRequestId {
        private long requestId;

        public MessageRequestId() {
        }

        public long getId() {
            return this.requestId;
        }

        public void setId(long j) {
            this.requestId = j;
        }
    }

    public static int IM_Accusation(java.lang.String str, int i, int i2, java.lang.String str2, java.lang.String str3) {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.Accusation(str, i, i2, str2, str3);
    }

    public static int IM_BlackFriend(int i, java.lang.String str) {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.BlackFriend(i, str);
    }

    public static int IM_BlockUser(java.lang.String str, boolean z) {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.BlockUser(str, z);
    }

    public static int IM_CancleAudioMessage() {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.CancleAudioMessage();
    }

    public static boolean IM_ClearAudioCachePath() {
        return com.youme.im.NativeEngine.ClearAudioCachePath();
    }

    public static int IM_ConvertAMRToWav(java.lang.String str, java.lang.String str2) {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.ConvertAMRToWav(str, str2);
    }

    public static int IM_DealBeRequestAddFriend(java.lang.String str, int i) {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.DealBeRequestAddFriend(str, i);
    }

    public static int IM_DeleteFriend(java.lang.String str, int i) {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.DeleteFriend(str, i);
    }

    public static int IM_DeleteHistoryMessage(int i, long j) {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.DeleteHistoryMessage(i, j);
    }

    public static int IM_DeleteHistoryMessageByID(long j) {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.DeleteHistoryMessageByID(j);
    }

    public static int IM_DeleteHistoryMessageByTarget(java.lang.String str, int i, long j, int i2) {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.DeleteHistoryMessageByTarget(str, i, j, i2);
    }

    public static int IM_DeleteSpecifiedHistoryMessage(java.lang.String str, int i, long[] jArr) {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.DeleteSpecifiedHistoryMessage(str, i, jArr);
    }

    public static int IM_DownloadAudioFile(long j, java.lang.String str) {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.DownloadAudioFile(j, str);
    }

    public static int IM_DownloadFileByURL(java.lang.String str, java.lang.String str2, int i) {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.DownloadFileByURL(str, str2, i);
    }

    public static int IM_FindUser(int i, java.lang.String str) {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.FindUser(i, str);
    }

    public static java.lang.String IM_GetAudioCachePath() {
        return com.youme.im.NativeEngine.GetAudioCachePath();
    }

    public static int IM_GetBlockUsers() {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.GetBlockUsers();
    }

    public static int IM_GetCurrentLocation() {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.GetCurrentLocation();
    }

    public static int IM_GetDistance(java.lang.String str) {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.GetDistance(str);
    }

    public static java.lang.String IM_GetFilterText(java.lang.String str, com.youme.im.IMEngine.IntegerVal integerVal) {
        if (m_init) {
            return str == null ? str : com.youme.im.NativeEngine.GetFilterText(str, integerVal);
        }
        return "";
    }

    public static int IM_GetForbiddenSpeakInfo() {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.GetForbiddenSpeakInfo();
    }

    public static int IM_GetHistoryContact() {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.GetHistoryContact();
    }

    public static byte[] IM_GetMessage() {
        if (m_init) {
            return com.youme.im.NativeEngine.GetMessage();
        }
        return null;
    }

    public static void IM_GetMicrophoneStatus() {
        if (m_init) {
            com.youme.im.NativeEngine.GetMicrophoneStatus();
        }
    }

    public static int IM_GetNearbyObjects(int i, java.lang.String str, int i2, boolean z) {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.GetNearbyObjects(i, str, i2, z);
    }

    public static int IM_GetNewMessage(java.lang.String str) {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.GetNewMessage(str);
    }

    public static int IM_GetRoomMemberCount(java.lang.String str) {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.GetRoomMemberCount(str);
    }

    public static int IM_GetSDKVer() {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.GetSDKVer();
    }

    public static int IM_GetUserInfo(java.lang.String str) {
        if (!m_init) {
            return ENGINE_NOT_INIT;
        }
        if (str == null || "".equals(str)) {
            return 3;
        }
        return com.youme.im.NativeEngine.GetUserInfo(str);
    }

    public static int IM_GetUserProfileInfo(java.lang.String str) {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.GetUserProfileInfo(str);
    }

    public static int IM_Init(android.content.Context context, java.lang.String str, java.lang.String str2, int i) {
        m_appKey = str;
        m_appSecret = str2;
        m_serverZone = i;
        if (!loadLibrary()) {
            return -1;
        }
        initIMEngine(context);
        com.youme.im.NativeEngine.SetServerZone(i);
        return com.youme.im.NativeEngine.Init(str, str2);
    }

    public static boolean IM_IsPlaying() {
        if (m_init) {
            return com.youme.im.NativeEngine.IsPlaying();
        }
        return false;
    }

    public static int IM_JoinChatRoom(java.lang.String str) {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.JoinChatRoom(str);
    }

    public static int IM_LeaveAllChatRooms() {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.LeaveAllChatRooms();
    }

    public static int IM_LeaveChatRoom(java.lang.String str) {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.LeaveChatRoom(str);
    }

    public static int IM_LoadLibray(android.content.Context context, java.lang.String str) {
        android.util.Log.i("YIM_NATIVE", "load library path:" + str);
        if (!m_loadedLibrary) {
            try {
                java.lang.System.load(str);
                m_loadedLibrary = true;
            } catch (java.lang.Exception e) {
                android.util.Log.d("YIM_NATIVE", "loadLibrary error: " + e.toString());
                return -1;
            } catch (java.lang.UnsatisfiedLinkError e2) {
                android.util.Log.d("YIM_NATIVE", "UnsatisfiedLinkError: " + e2.toString());
                return -1;
            } catch (java.lang.Throwable th) {
                android.util.Log.d("YIM_NATIVE", "loadLibrary error: " + th.toString());
                return -1;
            }
        }
        initIMEngine(context);
        try {
            com.youme.im.NativeEngine.SetServerZone(m_serverZone);
            if (m_appKey != null && m_appKey.length() > 0 && m_appSecret != null && m_appSecret.length() > 0) {
                return com.youme.im.NativeEngine.Init(m_appKey, m_appSecret);
            }
        } catch (java.lang.Throwable th2) {
            th2.printStackTrace();
        }
        return -1;
    }

    public static int IM_Login(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.Login(str, str2, str3);
    }

    public static int IM_Logout() {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.Logout();
    }

    public static int IM_MultiSendTextMessage(java.lang.String str, java.lang.String str2) {
        if (!m_init) {
            return ENGINE_NOT_INIT;
        }
        if (str == null || "".equals(str)) {
            return 3;
        }
        return com.youme.im.NativeEngine.MultiSendTextMessage(str, str2);
    }

    public static void IM_OnPause(boolean z) {
        if (m_init) {
            com.youme.im.NativeEngine.OnPause(z);
        }
    }

    public static void IM_OnResume() {
        if (m_init) {
            com.youme.im.NativeEngine.OnResume();
        }
    }

    public static void IM_PopMessage() {
        if (m_init) {
            com.youme.im.NativeEngine.PopMessage();
        }
    }

    public static int IM_QueryFriendRequestList(int i, int i2) {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.QueryFriendRequestList(i, i2);
    }

    public static int IM_QueryFriends(int i, int i2, int i3) {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.QueryFriends(i, i2, i3);
    }

    public static int IM_QueryHistoryMessage(java.lang.String str, int i, long j, int i2, int i3) {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.QueryHistoryMessage(str, i, j, i2, i3);
    }

    public static int IM_QueryNotice() {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.QueryNotice();
    }

    public static int IM_QueryRoomHistoryMessageFromServer(java.lang.String str, int i, int i2) {
        if (!m_init) {
            return ENGINE_NOT_INIT;
        }
        if (str == null || "".equals(str)) {
            return 3;
        }
        return com.youme.im.NativeEngine.QueryRoomHistoryMessageFromServer(str, i, i2);
    }

    public static int IM_QueryUserStatus(java.lang.String str) {
        if (!m_init) {
            return ENGINE_NOT_INIT;
        }
        if (str == null || "".equals(str)) {
            return 3;
        }
        return com.youme.im.NativeEngine.QueryUserStatus(str);
    }

    public static int IM_RequestAddFriend(java.lang.String str, java.lang.String str2) {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.RequestAddFriend(str, str2);
    }

    public static int IM_SendAudioMessage(java.lang.String str, int i, com.youme.im.IMEngine.MessageRequestId messageRequestId) {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.SendAudioMessage(str, i, messageRequestId);
    }

    public static int IM_SendCustomMessage(java.lang.String str, int i, byte[] bArr, int i2, com.youme.im.IMEngine.MessageRequestId messageRequestId) {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.SendCustomMessage(str, i, bArr, i2, messageRequestId);
    }

    public static int IM_SendFile(java.lang.String str, int i, java.lang.String str2, java.lang.String str3, int i2, com.youme.im.IMEngine.MessageRequestId messageRequestId) {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.SendFile(str, i, str2, str3, i2, messageRequestId);
    }

    public static int IM_SendGift(java.lang.String str, java.lang.String str2, int i, int i2, java.lang.String str3, com.youme.im.IMEngine.MessageRequestId messageRequestId) {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.SendGift(str, str2, i, i2, str3, messageRequestId);
    }

    public static int IM_SendOnlyAudioMessage(java.lang.String str, int i, com.youme.im.IMEngine.MessageRequestId messageRequestId) {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.SendOnlyAudioMessage(str, i, messageRequestId);
    }

    public static int IM_SendTextMessage(java.lang.String str, int i, java.lang.String str2, java.lang.String str3, com.youme.im.IMEngine.MessageRequestId messageRequestId) {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.SendTextMessage(str, i, str2, str3, messageRequestId);
    }

    public static int IM_SetAddPermission(boolean z, int i) {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.SetAddPermission(z, i);
    }

    public static int IM_SetAllMessageRead(java.lang.String str, boolean z) {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.SetAllMessageRead(str, z);
    }

    public static int IM_SetDownloadAudioMessageSwitch(boolean z) {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.SetDownloadAudioMessageSwitch(z);
    }

    public static int IM_SetDownloadDir(java.lang.String str) {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.SetDownloadDir(str);
    }

    public static int IM_SetLoginAddress(java.lang.String str, int i) {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.SetLoginAddress(str, i);
    }

    public static int IM_SetMessageRead(long j, boolean z) {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.SetMessageRead(j, z);
    }

    public static void IM_SetMode(int i) {
        if (m_init) {
            com.youme.im.NativeEngine.SetMode(i);
        }
    }

    public static int IM_SetOnlyRecognizeSpeechText(boolean z) {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.SetOnlyRecognizeSpeechText(z);
    }

    public static int IM_SetReceiveMessageSwitch(java.lang.String str, boolean z) {
        if (!m_init) {
            return ENGINE_NOT_INIT;
        }
        if (str == null || "".equals(str)) {
            return 3;
        }
        return com.youme.im.NativeEngine.SetReceiveMessageSwitch(str, z);
    }

    public static int IM_SetRoomHistoryMessageSwitch(java.lang.String str, boolean z) {
        if (!m_init) {
            return ENGINE_NOT_INIT;
        }
        if (str == null || "".equals(str)) {
            return 3;
        }
        return com.youme.im.NativeEngine.SetRoomHistoryMessageSwitch(str, z);
    }

    public static void IM_SetServerZone(int i) {
        if (m_init) {
            com.youme.im.NativeEngine.SetServerZone(i);
        }
    }

    public static int IM_SetSpeechRecognizeLanguage(int i) {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.SetSpeechRecognizeLanguage(i);
    }

    public static void IM_SetUpdateInterval(int i) {
        if (m_init) {
            com.youme.im.NativeEngine.SetUpdateInterval(i);
        }
    }

    public static int IM_SetUserInfo(java.lang.String str) {
        if (!m_init) {
            return ENGINE_NOT_INIT;
        }
        if (str == null || "".equals(str)) {
            return 3;
        }
        return com.youme.im.NativeEngine.SetUserInfo(str);
    }

    public static int IM_SetUserProfileInfo(java.lang.String str) {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.SetUserProfileInfo(str);
    }

    public static int IM_SetUserProfilePhoto(java.lang.String str) {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.SetUserProfilePhoto(str);
    }

    public static int IM_SetVoiceMsgPlayed(long j, boolean z) {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.SetVoiceMsgPlayed(j, z);
    }

    public static void IM_SetVolume(float f) {
        if (m_init) {
            com.youme.im.NativeEngine.SetVolume(f);
        }
    }

    public static int IM_StartAudioSpeech(com.youme.im.IMEngine.MessageRequestId messageRequestId, boolean z) {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.StartAudioSpeech(messageRequestId, z);
    }

    public static int IM_StartPlayAudio(java.lang.String str) {
        if (!m_init) {
            return ENGINE_NOT_INIT;
        }
        if (str == null || "".equals(str)) {
            return 3;
        }
        return com.youme.im.NativeEngine.StartPlayAudio(str);
    }

    public static int IM_StopAudioMessage(java.lang.String str) {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.StopAudioMessage(str);
    }

    public static int IM_StopAudioSpeech() {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.StopAudioSpeech();
    }

    public static int IM_StopPlayAudio() {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.StopPlayAudio();
    }

    public static int IM_SwitchMsgTransType(int i) {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.SwitchMsgTransType(i);
    }

    public static int IM_SwitchUserStatus(java.lang.String str, int i) {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.SwitchUserStatus(str, i);
    }

    public static int IM_TranslateText(com.youme.im.IMEngine.IntegerVal integerVal, java.lang.String str, int i, int i2) {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.TranslateText(integerVal, str, i, i2);
    }

    public static int IM_UnBlockAllUser() {
        return !m_init ? ENGINE_NOT_INIT : com.youme.im.NativeEngine.UnBlockAllUser();
    }

    public static void IM_Uninit() {
        if (m_init) {
            com.youme.im.NativeEngine.Uninit();
        }
    }

    public static boolean IsInit() {
        return m_init;
    }

    public static void WriteLog(com.youme.im.CommonConst.LogLevel logLevel, java.lang.String str) {
        com.youme.im.NativeEngine.WriteLog(logLevel.ordinal(), str);
    }

    public static int init(android.content.Context context) {
        if (!loadLibrary()) {
            return -1;
        }
        initIMEngine(context);
        return 0;
    }

    private static void initIMEngine(android.content.Context context) {
        if (m_init) {
            return;
        }
        try {
            com.youme.im.AppPara.initPara(context);
            com.youme.voice.VoiceManager.Instance().Init(context);
            com.youme.lbs.GeographyLocationManager.Instance().Init(context);
            if (s_netStatusReceiver == null) {
                s_netStatusReceiver = new com.youme.im.NetworkStatusReceiver2();
                android.content.IntentFilter intentFilter = new android.content.IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                context.registerReceiver(s_netStatusReceiver, intentFilter);
            }
            m_init = true;
        } catch (java.lang.Throwable th) {
            android.util.Log.d("YIM_NATIVE", "initIMEngine error: " + th.toString());
        }
    }

    private static boolean loadLibrary() {
        if (!m_loadedLibrary) {
            try {
                java.lang.System.loadLibrary("yim");
            } catch (java.lang.Exception e) {
                android.util.Log.d("YIM_NATIVE", "loadLibrary error: " + e.toString());
            } catch (java.lang.UnsatisfiedLinkError e2) {
                android.util.Log.d("YIM_NATIVE", "UnsatisfiedLinkError: " + e2.toString());
            } catch (java.lang.Throwable th) {
                android.util.Log.d("YIM_NATIVE", "loadLibrary error: " + th.toString());
            }
            m_loadedLibrary = true;
        }
        return true;
    }
}
