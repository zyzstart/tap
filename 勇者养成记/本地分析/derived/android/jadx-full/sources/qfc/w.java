package qfc;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class w {
    private static qfc.w.a an = null;
    private static qfc.w.c ao = null;
    private static boolean p = false;
    private static boolean r = false;

    static class a {
    }

    public enum b {
        ReportNow(0),
        ReportLater(1);

        int ar;

        b(int i) {
            this.ar = i;
        }
    }

    static class c {
        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }

        static boolean a() {
            try {
                qfc.ac.a("TGPA_Report", "checkTDM: uuid: " + java.lang.String.valueOf(com.tencent.tdm.TDataMaster.getInstance().getTDMUID()));
                return true;
            } catch (java.lang.Throwable unused) {
                return false;
            }
        }
    }

    public static void a() {
        ao = new qfc.w.c((byte) 0);
        if (qfc.w.c.a()) {
            android.util.Log.d("TGPA_Report", "checkTDM: tdm is available in this app.");
            r = true;
        } else {
            r = false;
            ao = null;
            android.util.Log.d("TGPA_Report", "checkTDM: tdm is not available in this app.");
            android.util.Log.d("TGPA_Report", "No report sdk is available, use self report.");
        }
    }

    public static void a(qfc.g gVar, qfc.w.b bVar, java.util.HashMap map) {
        qfc.ac.a(gVar.S, map);
        if (r && ao != null) {
            com.tencent.tdm.TDataMaster.getInstance().reportEvent(2007, gVar.S, map);
            return;
        }
        if (!p || an == null) {
            new qfc.ae().execute(gVar.S, new org.json.JSONObject(map).toString());
            return;
        }
        java.lang.String str = gVar.S;
        int i = bVar.ar;
        if (i == 0) {
            com.tencent.beacon.event.UserAction.onUserAction(str, true, -1L, -1L, map, true, true);
        } else if (i == 1) {
            com.tencent.beacon.event.UserAction.onUserAction(str, true, -1L, -1L, map, false, false);
        }
    }
}
