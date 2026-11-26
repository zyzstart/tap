package oicq.wlogin_sdk.report;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class report_t implements java.io.Serializable {
    public static java.lang.String FILE_NAME = "report_data";
    private static final long serialVersionUID = 1;

    public static synchronized void delete_file(android.content.Context context) {
        context.deleteFile(FILE_NAME);
    }

    public static synchronized oicq.wlogin_sdk.report.Reporter read_fromfile(android.content.Context context) {
        oicq.wlogin_sdk.report.Reporter reporter;
        try {
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(new java.io.File(FILE_NAME));
            java.io.BufferedInputStream bufferedInputStream = new java.io.BufferedInputStream(fileInputStream);
            reporter = (oicq.wlogin_sdk.report.Reporter) new java.io.ObjectInputStream(bufferedInputStream).readObject();
            bufferedInputStream.close();
            fileInputStream.close();
        } catch (java.lang.Exception unused) {
            oicq.wlogin_sdk.tools.util.LOGI("read " + FILE_NAME + "failed");
            return null;
        }
        return reporter;
    }

    public static synchronized int write_tofile(oicq.wlogin_sdk.report.Reporter reporter, android.content.Context context) {
        try {
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream(8192);
            java.io.ObjectOutputStream objectOutputStream = new java.io.ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(reporter);
            objectOutputStream.flush();
            objectOutputStream.close();
            java.io.FileOutputStream fileOutputStreamOpenFileOutput = context.openFileOutput(FILE_NAME, 0);
            byteArrayOutputStream.writeTo(fileOutputStreamOpenFileOutput);
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            fileOutputStreamOpenFileOutput.close();
        } catch (java.lang.Exception e) {
            oicq.wlogin_sdk.tools.util.LOGI(e.getStackTrace().toString());
            return -1;
        }
        return 0;
    }
}
