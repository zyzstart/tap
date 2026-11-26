package android.support.v4.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class NotificationCompatBase {

    public static abstract class Action {

        public interface Factory {
            android.support.v4.app.NotificationCompatBase.Action build(int i, java.lang.CharSequence charSequence, android.app.PendingIntent pendingIntent, android.os.Bundle bundle, android.support.v4.app.RemoteInputCompatBase.RemoteInput[] remoteInputArr, android.support.v4.app.RemoteInputCompatBase.RemoteInput[] remoteInputArr2, boolean z);

            android.support.v4.app.NotificationCompatBase.Action[] newArray(int i);
        }

        public abstract android.app.PendingIntent getActionIntent();

        public abstract boolean getAllowGeneratedReplies();

        public abstract android.support.v4.app.RemoteInputCompatBase.RemoteInput[] getDataOnlyRemoteInputs();

        public abstract android.os.Bundle getExtras();

        public abstract int getIcon();

        public abstract android.support.v4.app.RemoteInputCompatBase.RemoteInput[] getRemoteInputs();

        public abstract java.lang.CharSequence getTitle();
    }

    public static abstract class UnreadConversation {

        public interface Factory {
            android.support.v4.app.NotificationCompatBase.UnreadConversation build(java.lang.String[] strArr, android.support.v4.app.RemoteInputCompatBase.RemoteInput remoteInput, android.app.PendingIntent pendingIntent, android.app.PendingIntent pendingIntent2, java.lang.String[] strArr2, long j);
        }

        abstract long getLatestTimestamp();

        abstract java.lang.String[] getMessages();

        abstract java.lang.String getParticipant();

        abstract java.lang.String[] getParticipants();

        abstract android.app.PendingIntent getReadPendingIntent();

        abstract android.support.v4.app.RemoteInputCompatBase.RemoteInput getRemoteInput();

        abstract android.app.PendingIntent getReplyPendingIntent();
    }
}
