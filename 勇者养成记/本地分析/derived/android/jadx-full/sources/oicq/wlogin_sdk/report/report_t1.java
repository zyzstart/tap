package oicq.wlogin_sdk.report;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class report_t1 extends oicq.wlogin_sdk.report.report_t {
    private static final long serialVersionUID = 1;
    public int _os = 2;
    public java.lang.String _os_v = new java.lang.String("");
    public java.lang.String _app_v = new java.lang.String("");
    public java.lang.String _sdk_v = new java.lang.Integer(5).toString();
    public java.lang.String _ksid = new java.lang.String("");
    public java.lang.String _app_n = new java.lang.String("");
    public java.lang.String _disp_name = new java.lang.String("");
    public java.lang.String _device = new java.lang.String("");
    public java.lang.String _app_sig = new java.lang.String("");
    public java.lang.String _btime = oicq.wlogin_sdk.tools.util.get_release_time();
    public java.lang.String _bver = oicq.wlogin_sdk.tools.util.SDK_VERSION;
    public java.util.TreeMap _lst = new java.util.TreeMap();

    public synchronized void add_t2(oicq.wlogin_sdk.report.report_t2 report_t2Var) {
        if (this._lst.size() >= 10) {
            java.util.TreeMap treeMap = this._lst;
            treeMap.remove(java.lang.Integer.valueOf(treeMap.size() - 1));
        }
        java.util.TreeMap treeMap2 = this._lst;
        treeMap2.put(java.lang.Integer.valueOf(treeMap2.size()), report_t2Var);
    }

    public synchronized void add_t3(oicq.wlogin_sdk.report.report_t3 report_t3Var) {
        if (this._lst.size() <= 0) {
            return;
        }
        java.util.TreeMap treeMap = this._lst;
        ((oicq.wlogin_sdk.report.report_t2) treeMap.get(java.lang.Integer.valueOf(treeMap.size() - 1))).add_t3(report_t3Var);
    }

    public synchronized void attr_api(int i) {
        add_t2(new oicq.wlogin_sdk.report.report_t2(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void clear_t2() {
        java.util.Iterator it = this._lst.keySet().iterator();
        while (it.hasNext()) {
            ((oicq.wlogin_sdk.report.report_t2) this._lst.get(it.next())).clear_t3();
        }
        this._lst.clear();
    }

    public synchronized void commit(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8, java.lang.String str9, java.lang.String str10) {
        this._os_v = str;
        this._app_v = str2;
        this._ksid = str4;
        this._app_n = str5;
        this._disp_name = str6;
        this._device = str7;
        this._app_sig = str8;
        this._btime = str9;
        this._bver = str10;
    }

    public synchronized void commit_t2(long j, java.lang.String str, int i, int i2) {
        if (this._lst.size() <= 0) {
            return;
        }
        java.util.TreeMap treeMap = this._lst;
        ((oicq.wlogin_sdk.report.report_t2) treeMap.get(java.lang.Integer.valueOf(treeMap.size() - 1))).commit(j, str, i, i2);
        oicq.wlogin_sdk.tools.LogCallBack logCallBack = oicq.wlogin_sdk.tools.util.LCB;
        if (logCallBack != null) {
            java.util.TreeMap treeMap2 = this._lst;
            logCallBack.OnLog(((oicq.wlogin_sdk.report.report_t2) treeMap2.get(java.lang.Integer.valueOf(treeMap2.size() - 1))).toJasonObj());
        }
    }

    public synchronized org.json.JSONObject toJasonObj() {
        org.json.JSONObject jSONObject;
        jSONObject = null;
        try {
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            try {
                int i = 0;
                jSONObject2.put("os", java.lang.String.format("%d", java.lang.Integer.valueOf(this._os)));
                jSONObject2.put("os_v", this._os_v);
                jSONObject2.put("app_v", this._app_v);
                jSONObject2.put("sdk_v", this._sdk_v);
                jSONObject2.put("ksid", this._ksid);
                jSONObject2.put("app_n", this._app_n);
                jSONObject2.put("disp_name", this._disp_name);
                jSONObject2.put(com.tencent.ysdk.shell.module.report.impl.ReportComm.DEVICE, this._device);
                jSONObject2.put("app_sig", this._app_sig);
                jSONObject2.put("btime", this._btime);
                jSONObject2.put("bver", this._bver);
                org.json.JSONArray jSONArray = new org.json.JSONArray();
                java.util.Iterator it = this._lst.keySet().iterator();
                while (it.hasNext()) {
                    jSONArray.put(i, ((oicq.wlogin_sdk.report.report_t2) this._lst.get(it.next())).toJasonObj());
                    i++;
                }
                jSONObject2.put("lst", jSONArray);
            } catch (java.lang.Exception unused) {
            }
            jSONObject = jSONObject2;
        } catch (java.lang.Exception unused2) {
        }
        return jSONObject;
    }
}
