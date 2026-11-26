package oicq.wlogin_sdk.report;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class report_t3 extends oicq.wlogin_sdk.report.report_t {
    private static final long serialVersionUID = 1;
    public int _cmd = 0;
    public int _sub = 0;
    public int _rst2 = 0;
    public int _used = 0;
    public int _try = 0;
    public java.lang.String _host = new java.lang.String("");
    public java.lang.String _ip = new java.lang.String("");
    public int _port = 0;
    public int _conn = 0;
    public int _net = 0;
    public java.lang.String _str = new java.lang.String("");
    public int _rlen = 0;
    public int _slen = 0;
    public int _wap = 0;

    public org.json.JSONObject toJasonObj() {
        java.lang.Exception e;
        org.json.JSONObject jSONObject;
        try {
            jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put("cmd", java.lang.String.format("0x%x", java.lang.Integer.valueOf(this._cmd)));
                jSONObject.put("sub", java.lang.String.format("0x%x", java.lang.Integer.valueOf(this._sub)));
                jSONObject.put("rst2", java.lang.String.format("%d", java.lang.Integer.valueOf(this._rst2)));
                jSONObject.put("used", java.lang.String.format("%d", java.lang.Integer.valueOf(this._used)));
                jSONObject.put("try", java.lang.String.format("%d", java.lang.Integer.valueOf(this._try)));
                jSONObject.put("host", this._host);
                jSONObject.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_IP, this._ip);
                jSONObject.put("port", java.lang.String.format("%d", java.lang.Integer.valueOf(this._port)));
                jSONObject.put("conn", java.lang.String.format("%d", java.lang.Integer.valueOf(this._conn)));
                jSONObject.put("net", java.lang.String.format("%d", java.lang.Integer.valueOf(this._net)));
                jSONObject.put("str", this._str);
                jSONObject.put("rlen", java.lang.String.format("%d", java.lang.Integer.valueOf(this._rlen)));
                jSONObject.put("slen", java.lang.String.format("%d", java.lang.Integer.valueOf(this._slen)));
                jSONObject.put("wap", java.lang.String.format("%d", java.lang.Integer.valueOf(this._wap)));
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
