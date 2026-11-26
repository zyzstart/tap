package qfc;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class d {
    private static volatile qfc.d m;
    public qfc.d.a n = new qfc.d.a();

    public class a {
        public boolean o = false;
        public boolean p = false;
        public boolean q = false;
        public boolean r = false;
        public boolean s = true;
        public boolean t = true;

        public a() {
        }
    }

    private d() {
    }

    public static qfc.d b() {
        if (m == null) {
            synchronized (qfc.d.class) {
                if (m == null) {
                    m = new qfc.d();
                }
            }
        }
        return m;
    }

    public final boolean a(java.lang.String str) {
        try {
            org.json.JSONObject jSONObjectOptJSONObject = new org.json.JSONObject(str).optJSONObject("switch");
            if (jSONObjectOptJSONObject == null) {
                return false;
            }
            this.n.o = jSONObjectOptJSONObject.optBoolean("globalSwitch");
            this.n.p = jSONObjectOptJSONObject.optBoolean("debugMode");
            this.n.q = jSONObjectOptJSONObject.optBoolean("reportAll");
            this.n.r = jSONObjectOptJSONObject.optBoolean("uniqueIdReport");
            this.n.s = jSONObjectOptJSONObject.optBoolean("safeUniqueIdReport");
            this.n.t = jSONObjectOptJSONObject.optBoolean("vendorOAIDReport");
            return true;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
