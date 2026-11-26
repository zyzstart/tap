package oicq.wlogin_sdk.report;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class report_t2 extends oicq.wlogin_sdk.report.report_t {
    private static final long serialVersionUID = 1;
    public long _app;
    public long[] _app_list;
    public java.lang.String _oper;
    public long _start;
    public long _sub_app;
    public java.lang.String _type;
    public int attr;
    public int _used = 0;
    public long _uin = 0;
    public java.lang.String _name = new java.lang.String("");
    public int _rst1 = 0;
    public int _rst2 = 0;
    public int _rlen = 0;
    public int _slen = 0;
    public java.util.TreeMap _log = new java.util.TreeMap();

    public report_t2(int i) {
        this._type = new java.lang.String("");
        this._oper = new java.lang.String("");
        this._start = 0L;
        this._app = 0L;
        this._sub_app = 0L;
        this._app_list = null;
        this._type = "login";
        this._oper = "null";
        this._start = java.lang.System.currentTimeMillis();
        this._app = 0L;
        this._sub_app = 0L;
        this._app_list = null;
        this.attr = i;
    }

    public report_t2(java.lang.String str, java.lang.String str2, long j, long j2, long j3, long[] jArr) {
        this._type = new java.lang.String("");
        this._oper = new java.lang.String("");
        this._start = 0L;
        this._app = 0L;
        this._sub_app = 0L;
        this._app_list = null;
        this._type = str;
        this._oper = str2;
        this._start = j;
        this._app = j2;
        this._sub_app = j3;
        this._app_list = jArr;
    }

    public void add_t3(oicq.wlogin_sdk.report.report_t3 report_t3Var) {
        this._rlen += report_t3Var._rlen;
        this._slen += report_t3Var._slen;
        java.util.TreeMap treeMap = this._log;
        treeMap.put(java.lang.Integer.valueOf(treeMap.size()), report_t3Var);
    }

    public void clear_t3() {
        this._log.clear();
    }

    public void commit(long j, java.lang.String str, int i, int i2) {
        this._uin = j;
        this._name = str;
        this._rst1 = i;
        this._rst2 = i2;
        this._used = (int) (java.lang.System.currentTimeMillis() - this._start);
    }

    public org.json.JSONObject toJasonObj() {
        java.lang.Exception e;
        org.json.JSONObject jSONObject;
        java.lang.StringBuilder sb;
        java.lang.String str;
        try {
            jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put(com.tencent.open.SocialConstants.PARAM_TYPE, this._type);
                jSONObject.put("oper", this._oper);
                int i = 0;
                jSONObject.put(com.unisound.common.y.D, java.lang.String.format("%d", java.lang.Long.valueOf((this._start / 1000) & 4294967295L)));
                jSONObject.put("used", java.lang.String.format("%d", java.lang.Long.valueOf(((long) this._used) & 4294967295L)));
                jSONObject.put("uin", java.lang.String.format("%d", java.lang.Long.valueOf(this._uin & 4294967295L)));
                jSONObject.put("app", java.lang.String.format("%d", java.lang.Long.valueOf(this._app & 4294967295L)));
                jSONObject.put("subapp", java.lang.String.format("%d", java.lang.Long.valueOf(this._sub_app & 4294967295L)));
                jSONObject.put(android.support.v4.app.NotificationCompat.CATEGORY_EMAIL, this._name);
                jSONObject.put("attr", this.attr);
                java.lang.String str2 = "";
                if (this._app_list != null) {
                    java.lang.String string = "";
                    for (int i2 = 0; i2 < this._app_list.length; i2++) {
                        if (i2 == this._app_list.length - 1) {
                            sb = new java.lang.StringBuilder();
                            sb.append(string);
                            str = java.lang.String.format("%d", java.lang.Long.valueOf(this._app_list[i2] & 4294967295L));
                        } else {
                            sb = new java.lang.StringBuilder();
                            sb.append(string);
                            str = java.lang.String.format("%d,", java.lang.Long.valueOf(this._app_list[i2] & 4294967295L));
                        }
                        sb.append(str);
                        string = sb.toString();
                    }
                    str2 = string;
                }
                jSONObject.put("applist", str2);
                jSONObject.put("rst1", java.lang.String.format("%d", java.lang.Long.valueOf(((long) this._rst1) & 4294967295L)));
                jSONObject.put("rst2", java.lang.String.format("%d", java.lang.Long.valueOf(4294967295L & ((long) this._rst2))));
                org.json.JSONArray jSONArray = new org.json.JSONArray();
                java.util.Iterator it = this._log.keySet().iterator();
                while (it.hasNext()) {
                    jSONArray.put(i, ((oicq.wlogin_sdk.report.report_t3) this._log.get(it.next())).toJasonObj());
                    i++;
                }
                jSONObject.put("log", jSONArray);
            } catch (java.lang.Exception e2) {
                e = e2;
                java.io.StringWriter stringWriter = new java.io.StringWriter();
                java.io.PrintWriter printWriter = new java.io.PrintWriter((java.io.Writer) stringWriter, true);
                e.printStackTrace(printWriter);
                printWriter.flush();
                stringWriter.flush();
                oicq.wlogin_sdk.tools.util.LOGD("exception", stringWriter.toString());
            }
        } catch (java.lang.Exception e3) {
            e = e3;
            jSONObject = null;
        }
        return jSONObject;
    }
}
