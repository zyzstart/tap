package qfc;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class ad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static java.lang.String f1694a;

    public static void a(java.util.HashMap map) {
        map.put("vmp_number", h());
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_APP_PARAM_PACKAGE_NAME, java.lang.String.valueOf(qfc.v.h()));
        map.put("report_time", qfc.x.b(qfc.x.a.PATTERN2.S));
        map.put("version_code", com.tencent.connect.common.Constants.VIA_SHARE_TYPE_PUBLISHVIDEO);
        map.put("version_name", "1.0.8");
        map.put("unique_id3", java.lang.String.valueOf(com.tencent.tgpa.simple.gradish.GradishWrapper.getCommonUniqueIDL2()));
        map.put("unique_id", java.lang.String.valueOf(com.tencent.tgpa.simple.gradish.GradishWrapper.getCommonUniqueIDWithoutFlag()));
        map.put("xid", java.lang.String.valueOf(com.tencent.tgpa.simple.gradish.GradishWrapper.getCommonUniqueID2WithoutFlag()));
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_USER_PARAM_OAID, java.lang.String.valueOf(qfc.o.h()));
        map.put("manufacturer", android.os.Build.MANUFACTURER);
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_MODEL, android.os.Build.MODEL);
        map.put("sdk_type", "simple");
    }

    public static void b(java.util.HashMap map) {
        a(map);
        qfc.w.a(qfc.g.VMP_DOWNLOAD_CONFIG, qfc.w.b.ReportNow, map);
    }

    private static java.lang.String h() {
        java.lang.String str = f1694a;
        if (str != null) {
            return str;
        }
        java.lang.String str2 = qfc.x.b(qfc.x.a.PATTERN1.S) + "_" + java.lang.String.valueOf(com.tencent.tgpa.simple.gradish.GradishWrapper.getCommonUniqueID());
        f1694a = str2;
        return str2;
    }
}
