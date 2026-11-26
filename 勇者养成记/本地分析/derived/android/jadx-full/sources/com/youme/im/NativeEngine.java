package com.youme.im;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class NativeEngine {
    public static native int Accusation(java.lang.String str, int i, int i2, java.lang.String str2, java.lang.String str3);

    public static native int BlackFriend(int i, java.lang.String str);

    public static native int BlockUser(java.lang.String str, boolean z);

    public static native int CancleAudioMessage();

    public static native boolean ClearAudioCachePath();

    public static native int ConvertAMRToWav(java.lang.String str, java.lang.String str2);

    public static native int DealBeRequestAddFriend(java.lang.String str, int i);

    public static native int DeleteFriend(java.lang.String str, int i);

    public static native int DeleteHistoryMessage(int i, long j);

    public static native int DeleteHistoryMessageByID(long j);

    public static native int DeleteHistoryMessageByTarget(java.lang.String str, int i, long j, int i2);

    public static native int DeleteSpecifiedHistoryMessage(java.lang.String str, int i, long[] jArr);

    public static native int DownloadAudioFile(long j, java.lang.String str);

    public static native int DownloadFileByURL(java.lang.String str, java.lang.String str2, int i);

    public static native int FindUser(int i, java.lang.String str);

    public static native java.lang.String GetAudioCachePath();

    public static native int GetBlockUsers();

    public static native int GetCurrentLocation();

    public static native int GetDistance(java.lang.String str);

    public static native java.lang.String GetFilterText(java.lang.String str, com.youme.im.IMEngine.IntegerVal integerVal);

    public static native int GetForbiddenSpeakInfo();

    public static native int GetHistoryContact();

    public static native byte[] GetMessage();

    public static native void GetMicrophoneStatus();

    public static native int GetNearbyObjects(int i, java.lang.String str, int i2, boolean z);

    public static native int GetNewMessage(java.lang.String str);

    public static native int GetRoomMemberCount(java.lang.String str);

    public static native int GetSDKVer();

    public static native int GetUserInfo(java.lang.String str);

    public static native int GetUserProfileInfo(java.lang.String str);

    public static native int Init(java.lang.String str, java.lang.String str2);

    public static native boolean IsPlaying();

    public static native int JoinChatRoom(java.lang.String str);

    public static native int LeaveAllChatRooms();

    public static native int LeaveChatRoom(java.lang.String str);

    public static native int Login(java.lang.String str, java.lang.String str2, java.lang.String str3);

    public static native int Logout();

    public static native int MultiSendTextMessage(java.lang.String str, java.lang.String str2);

    public static native void NotifyVolumeChange(int i, int i2);

    public static native void OnPause(boolean z);

    public static native void OnPlayData(byte[] bArr, int i);

    public static native void OnPlayFinish(int i, java.lang.String str);

    public static native byte[] OnRecordData(byte[] bArr, int i, boolean z);

    public static native void OnRecordFinish(int i, java.lang.String str, long j, java.lang.String str2);

    public static native void OnResume();

    public static native void OnUpdateLocation(int i, double d, double d2);

    public static native void PopMessage();

    public static native int QueryFriendRequestList(int i, int i2);

    public static native int QueryFriends(int i, int i2, int i3);

    public static native int QueryHistoryMessage(java.lang.String str, int i, long j, int i2, int i3);

    public static native int QueryNotice();

    public static native int QueryRoomHistoryMessageFromServer(java.lang.String str, int i, int i2);

    public static native int QueryUserStatus(java.lang.String str);

    public static native int RequestAddFriend(java.lang.String str, java.lang.String str2);

    public static native int SendAudioMessage(java.lang.String str, int i, com.youme.im.IMEngine.MessageRequestId messageRequestId);

    public static native int SendCustomMessage(java.lang.String str, int i, byte[] bArr, int i2, com.youme.im.IMEngine.MessageRequestId messageRequestId);

    public static native int SendFile(java.lang.String str, int i, java.lang.String str2, java.lang.String str3, int i2, com.youme.im.IMEngine.MessageRequestId messageRequestId);

    public static native int SendGift(java.lang.String str, java.lang.String str2, int i, int i2, java.lang.String str3, com.youme.im.IMEngine.MessageRequestId messageRequestId);

    public static native int SendOnlyAudioMessage(java.lang.String str, int i, com.youme.im.IMEngine.MessageRequestId messageRequestId);

    public static native int SendTextMessage(java.lang.String str, int i, java.lang.String str2, java.lang.String str3, com.youme.im.IMEngine.MessageRequestId messageRequestId);

    public static native int SetAddPermission(boolean z, int i);

    public static native int SetAllMessageRead(java.lang.String str, boolean z);

    public static native int SetDownloadAudioMessageSwitch(boolean z);

    public static native int SetDownloadDir(java.lang.String str);

    public static native int SetLoginAddress(java.lang.String str, int i);

    public static native int SetMessageRead(long j, boolean z);

    public static native void SetMode(int i);

    public static native int SetOnlyRecognizeSpeechText(boolean z);

    public static native int SetReceiveMessageSwitch(java.lang.String str, boolean z);

    public static native int SetRoomHistoryMessageSwitch(java.lang.String str, boolean z);

    public static native void SetServerZone(int i);

    public static native int SetSpeechRecognizeLanguage(int i);

    public static native void SetUpdateInterval(int i);

    public static native int SetUserInfo(java.lang.String str);

    public static native int SetUserProfileInfo(java.lang.String str);

    public static native int SetUserProfilePhoto(java.lang.String str);

    public static native int SetVoiceMsgPlayed(long j, boolean z);

    public static native void SetVolume(float f);

    public static native int StartAudioSpeech(com.youme.im.IMEngine.MessageRequestId messageRequestId, boolean z);

    public static native int StartPlayAudio(java.lang.String str);

    public static native int StopAudioMessage(java.lang.String str);

    public static native int StopAudioSpeech();

    public static native int StopPlayAudio();

    public static native int SwitchMsgTransType(int i);

    public static native int SwitchUserStatus(java.lang.String str, int i);

    public static native int TranslateText(com.youme.im.IMEngine.IntegerVal integerVal, java.lang.String str, int i, int i2);

    public static native int UnBlockAllUser();

    public static native void Uninit();

    public static native void WriteLog(int i, java.lang.String str);

    public static native void onNetWorkChanged(int i);

    public static native void setBrand(java.lang.String str);

    public static native void setCPUArch(java.lang.String str);

    public static native void setCPUChip(java.lang.String str);

    public static native void setDeviceIMEI(java.lang.String str);

    public static native void setDocumentPath(java.lang.String str);

    public static native void setModel(java.lang.String str);

    public static native void setPackageName(java.lang.String str);

    public static native void setSysVersion(java.lang.String str);
}
