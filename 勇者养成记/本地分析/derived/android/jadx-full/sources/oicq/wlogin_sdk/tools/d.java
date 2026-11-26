package oicq.wlogin_sdk.tools;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static oicq.wlogin_sdk.tools.d.a f1691a = null;
    static java.util.LinkedList b = new java.util.LinkedList();
    private static boolean c = false;
    private static java.lang.String d = "";
    private static java.io.BufferedWriter e;
    private static android.os.HandlerThread f;

    static class a extends android.os.Handler {
        public a(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            java.lang.String string;
            int i = message.what;
            if (i == 1) {
                oicq.wlogin_sdk.tools.d.b();
                oicq.wlogin_sdk.tools.d.f1691a.removeMessages(1);
            } else {
                if (i != 2) {
                    return;
                }
                android.os.Bundle data = message.getData();
                if (data != null && (string = data.getString("msg")) != null) {
                    oicq.wlogin_sdk.tools.d.b.add(string);
                }
                oicq.wlogin_sdk.tools.d.f1691a.sendEmptyMessageDelayed(1, 5000L);
            }
        }
    }

    public static void a(android.content.Context context) {
        if (true == c) {
            return;
        }
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("WTLog");
        f = handlerThread;
        try {
            handlerThread.start();
            if (true == f.isAlive()) {
                f1691a = new oicq.wlogin_sdk.tools.d.a(f.getLooper());
            }
            d = oicq.wlogin_sdk.tools.util.getLogFileName(context, oicq.wlogin_sdk.tools.util.getCurrentDay());
            c = true;
        } catch (java.lang.Exception unused) {
        }
    }

    public static void a(java.lang.String str, java.lang.String str2) {
        if (f1691a == null) {
            return;
        }
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("msg", oicq.wlogin_sdk.tools.util.getDate() + oicq.wlogin_sdk.tools.util.getThreadId() + oicq.wlogin_sdk.tools.util.getLineInfo(3) + oicq.wlogin_sdk.tools.util.getSdkVersion() + oicq.wlogin_sdk.tools.util.getUser(str2) + str + "\n");
        android.os.Message message = new android.os.Message();
        message.setData(bundle);
        message.what = 2;
        f1691a.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b() {
        try {
            if (e == null) {
                java.io.File file = new java.io.File(d);
                if (!file.exists()) {
                    java.io.File parentFile = file.getParentFile();
                    if (parentFile == null) {
                        return;
                    }
                    parentFile.mkdirs();
                    if (!parentFile.isDirectory()) {
                        return;
                    } else {
                        file.createNewFile();
                    }
                }
                e = new java.io.BufferedWriter(new java.io.FileWriter(file, true));
            }
            while (true) {
                e.write((java.lang.String) b.removeFirst());
            }
        } catch (java.util.NoSuchElementException | java.lang.Exception unused) {
            try {
                e.close();
                e = null;
            } catch (java.lang.Exception unused2) {
                e = null;
            }
        }
    }
}
