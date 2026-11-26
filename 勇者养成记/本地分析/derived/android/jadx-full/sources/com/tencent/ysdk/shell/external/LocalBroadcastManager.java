package com.tencent.ysdk.shell.external;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class LocalBroadcastManager {
    private static final boolean DEBUG = false;
    static final int MSG_EXEC_PENDING_BROADCASTS = 1;
    private static final java.lang.String TAG = "LocalBroadcastManager";
    private static com.tencent.ysdk.shell.external.LocalBroadcastManager mInstance;
    private static final java.lang.Object mLock = new java.lang.Object();
    private final android.content.Context mAppContext;
    private final android.os.Handler mHandler;
    private final java.util.HashMap<android.content.BroadcastReceiver, java.util.ArrayList<com.tencent.ysdk.shell.external.LocalBroadcastManager.ReceiverRecord>> mReceivers = new java.util.HashMap<>();
    private final java.util.HashMap<java.lang.String, java.util.ArrayList<com.tencent.ysdk.shell.external.LocalBroadcastManager.ReceiverRecord>> mActions = new java.util.HashMap<>();
    private final java.util.ArrayList<com.tencent.ysdk.shell.external.LocalBroadcastManager.BroadcastRecord> mPendingBroadcasts = new java.util.ArrayList<>();

    private static final class BroadcastRecord {
        final android.content.Intent intent;
        final java.util.ArrayList<com.tencent.ysdk.shell.external.LocalBroadcastManager.ReceiverRecord> receivers;

        BroadcastRecord(android.content.Intent intent, java.util.ArrayList<com.tencent.ysdk.shell.external.LocalBroadcastManager.ReceiverRecord> arrayList) {
            this.intent = intent;
            this.receivers = arrayList;
        }
    }

    private static final class ReceiverRecord {
        boolean broadcasting;
        boolean dead;
        final android.content.IntentFilter filter;
        final android.content.BroadcastReceiver receiver;

        ReceiverRecord(android.content.IntentFilter intentFilter, android.content.BroadcastReceiver broadcastReceiver) {
            this.filter = intentFilter;
            this.receiver = broadcastReceiver;
        }

        public java.lang.String toString() {
            java.lang.StringBuilder sb = new java.lang.StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.receiver);
            sb.append(" filter=");
            sb.append(this.filter);
            if (this.dead) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    private LocalBroadcastManager(android.content.Context context) {
        this.mAppContext = context;
        this.mHandler = new android.os.Handler(context.getMainLooper()) { // from class: com.tencent.ysdk.shell.external.LocalBroadcastManager.1
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                if (message.what != 1) {
                    super.handleMessage(message);
                } else {
                    com.tencent.ysdk.shell.external.LocalBroadcastManager.this.executePendingBroadcasts();
                }
            }
        };
    }

    public static com.tencent.ysdk.shell.external.LocalBroadcastManager getInstance(android.content.Context context) {
        com.tencent.ysdk.shell.external.LocalBroadcastManager localBroadcastManager;
        synchronized (mLock) {
            if (mInstance == null) {
                mInstance = new com.tencent.ysdk.shell.external.LocalBroadcastManager(context.getApplicationContext());
            }
            localBroadcastManager = mInstance;
        }
        return localBroadcastManager;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void executePendingBroadcasts() {
        com.tencent.ysdk.shell.external.LocalBroadcastManager.BroadcastRecord[] broadcastRecordArr;
        while (true) {
            synchronized (this.mReceivers) {
                int size = this.mPendingBroadcasts.size();
                if (size <= 0) {
                    return;
                }
                broadcastRecordArr = new com.tencent.ysdk.shell.external.LocalBroadcastManager.BroadcastRecord[size];
                this.mPendingBroadcasts.toArray(broadcastRecordArr);
                this.mPendingBroadcasts.clear();
            }
            for (com.tencent.ysdk.shell.external.LocalBroadcastManager.BroadcastRecord broadcastRecord : broadcastRecordArr) {
                int size2 = broadcastRecord.receivers.size();
                for (int i = 0; i < size2; i++) {
                    com.tencent.ysdk.shell.external.LocalBroadcastManager.ReceiverRecord receiverRecord = broadcastRecord.receivers.get(i);
                    if (!receiverRecord.dead) {
                        receiverRecord.receiver.onReceive(this.mAppContext, broadcastRecord.intent);
                    }
                }
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void registerReceiver(android.content.BroadcastReceiver broadcastReceiver, android.content.IntentFilter intentFilter) {
        synchronized (this.mReceivers) {
            com.tencent.ysdk.shell.external.LocalBroadcastManager.ReceiverRecord receiverRecord = new com.tencent.ysdk.shell.external.LocalBroadcastManager.ReceiverRecord(intentFilter, broadcastReceiver);
            java.util.ArrayList<com.tencent.ysdk.shell.external.LocalBroadcastManager.ReceiverRecord> arrayList = this.mReceivers.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new java.util.ArrayList<>(1);
                this.mReceivers.put(broadcastReceiver, arrayList);
            }
            arrayList.add(receiverRecord);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                java.lang.String action = intentFilter.getAction(i);
                java.util.ArrayList<com.tencent.ysdk.shell.external.LocalBroadcastManager.ReceiverRecord> arrayList2 = this.mActions.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new java.util.ArrayList<>(1);
                    this.mActions.put(action, arrayList2);
                }
                arrayList2.add(receiverRecord);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean sendBroadcast(android.content.Intent intent) {
        java.lang.String str;
        java.util.ArrayList arrayList;
        int i;
        java.util.ArrayList<com.tencent.ysdk.shell.external.LocalBroadcastManager.ReceiverRecord> arrayList2;
        java.lang.String str2;
        java.lang.String str3;
        synchronized (this.mReceivers) {
            java.lang.String action = intent.getAction();
            java.lang.String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.mAppContext.getContentResolver());
            android.net.Uri data = intent.getData();
            java.lang.String scheme = intent.getScheme();
            java.util.Set<java.lang.String> categories = intent.getCategories();
            boolean z = (intent.getFlags() & 8) != 0;
            if (z) {
                android.util.Log.v(TAG, "Resolving type " + strResolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            java.util.ArrayList<com.tencent.ysdk.shell.external.LocalBroadcastManager.ReceiverRecord> arrayList3 = this.mActions.get(intent.getAction());
            if (arrayList3 != null) {
                if (z) {
                    android.util.Log.v(TAG, "Action list: " + arrayList3);
                }
                java.util.ArrayList arrayList4 = null;
                int i2 = 0;
                while (i2 < arrayList3.size()) {
                    com.tencent.ysdk.shell.external.LocalBroadcastManager.ReceiverRecord receiverRecord = arrayList3.get(i2);
                    if (z) {
                        android.util.Log.v(TAG, "Matching against filter " + receiverRecord.filter);
                    }
                    if (!receiverRecord.broadcasting) {
                        str = action;
                        arrayList = arrayList4;
                        i = i2;
                        arrayList2 = arrayList3;
                        str2 = strResolveTypeIfNeeded;
                        int iMatch = receiverRecord.filter.match(action, strResolveTypeIfNeeded, scheme, data, categories, TAG);
                        if (iMatch >= 0) {
                            if (z) {
                                android.util.Log.v(TAG, "  Filter matched!  match=0x" + java.lang.Integer.toHexString(iMatch));
                            }
                            arrayList4 = arrayList == null ? new java.util.ArrayList() : arrayList;
                            arrayList4.add(receiverRecord);
                            receiverRecord.broadcasting = true;
                        } else if (z) {
                            switch (iMatch) {
                                case -4:
                                    str3 = "category";
                                    break;
                                case -3:
                                    str3 = com.tencent.tauth.AuthActivity.ACTION_KEY;
                                    break;
                                case -2:
                                    str3 = com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameFreeloginResponse.HTTP_RESP_PARAM_DATA;
                                    break;
                                case -1:
                                    str3 = com.tencent.open.SocialConstants.PARAM_TYPE;
                                    break;
                                default:
                                    str3 = "unknown reason";
                                    break;
                            }
                            android.util.Log.v(TAG, "  Filter did not match: " + str3);
                        }
                        i2 = i + 1;
                        action = str;
                        arrayList3 = arrayList2;
                        strResolveTypeIfNeeded = str2;
                    } else if (z) {
                        android.util.Log.v(TAG, "  Filter's target already added");
                        i = i2;
                        arrayList2 = arrayList3;
                        str = action;
                        str2 = strResolveTypeIfNeeded;
                        arrayList = arrayList4;
                    } else {
                        i = i2;
                        arrayList2 = arrayList3;
                        str = action;
                        str2 = strResolveTypeIfNeeded;
                        arrayList = arrayList4;
                    }
                    arrayList4 = arrayList;
                    i2 = i + 1;
                    action = str;
                    arrayList3 = arrayList2;
                    strResolveTypeIfNeeded = str2;
                }
                java.util.ArrayList arrayList5 = arrayList4;
                if (arrayList5 != null) {
                    for (int i3 = 0; i3 < arrayList5.size(); i3++) {
                        ((com.tencent.ysdk.shell.external.LocalBroadcastManager.ReceiverRecord) arrayList5.get(i3)).broadcasting = false;
                    }
                    this.mPendingBroadcasts.add(new com.tencent.ysdk.shell.external.LocalBroadcastManager.BroadcastRecord(intent, arrayList5));
                    if (!this.mHandler.hasMessages(1)) {
                        this.mHandler.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public void sendBroadcastSync(android.content.Intent intent) {
        if (sendBroadcast(intent)) {
            executePendingBroadcasts();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void unregisterReceiver(android.content.BroadcastReceiver broadcastReceiver) {
        synchronized (this.mReceivers) {
            java.util.ArrayList<com.tencent.ysdk.shell.external.LocalBroadcastManager.ReceiverRecord> arrayListRemove = this.mReceivers.remove(broadcastReceiver);
            if (arrayListRemove == null) {
                return;
            }
            for (int size = arrayListRemove.size() - 1; size >= 0; size--) {
                com.tencent.ysdk.shell.external.LocalBroadcastManager.ReceiverRecord receiverRecord = arrayListRemove.get(size);
                receiverRecord.dead = true;
                for (int i = 0; i < receiverRecord.filter.countActions(); i++) {
                    java.lang.String action = receiverRecord.filter.getAction(i);
                    java.util.ArrayList<com.tencent.ysdk.shell.external.LocalBroadcastManager.ReceiverRecord> arrayList = this.mActions.get(action);
                    if (arrayList != null) {
                        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                            com.tencent.ysdk.shell.external.LocalBroadcastManager.ReceiverRecord receiverRecord2 = arrayList.get(size2);
                            if (receiverRecord2.receiver == broadcastReceiver) {
                                receiverRecord2.dead = true;
                                arrayList.remove(size2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            this.mActions.remove(action);
                        }
                    }
                }
            }
        }
    }
}
