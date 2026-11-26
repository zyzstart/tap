package android.support.v4.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RequiresApi(20)
class RemoteInputCompatApi20 {
    private static final java.lang.String EXTRA_DATA_TYPE_RESULTS_DATA = "android.remoteinput.dataTypeResultsData";

    RemoteInputCompatApi20() {
    }

    public static void addDataResultToIntent(android.support.v4.app.RemoteInputCompatBase.RemoteInput remoteInput, android.content.Intent intent, java.util.Map<java.lang.String, android.net.Uri> map) {
        android.content.Intent clipDataIntentFromIntent = getClipDataIntentFromIntent(intent);
        if (clipDataIntentFromIntent == null) {
            clipDataIntentFromIntent = new android.content.Intent();
        }
        for (java.util.Map.Entry<java.lang.String, android.net.Uri> entry : map.entrySet()) {
            java.lang.String key = entry.getKey();
            android.net.Uri value = entry.getValue();
            if (key != null) {
                android.os.Bundle bundleExtra = clipDataIntentFromIntent.getBundleExtra(getExtraResultsKeyForData(key));
                if (bundleExtra == null) {
                    bundleExtra = new android.os.Bundle();
                }
                bundleExtra.putString(remoteInput.getResultKey(), value.toString());
                clipDataIntentFromIntent.putExtra(getExtraResultsKeyForData(key), bundleExtra);
            }
        }
        intent.setClipData(android.content.ClipData.newIntent(android.support.v4.app.RemoteInput.RESULTS_CLIP_LABEL, clipDataIntentFromIntent));
    }

    static void addResultsToIntent(android.support.v4.app.RemoteInputCompatBase.RemoteInput[] remoteInputArr, android.content.Intent intent, android.os.Bundle bundle) {
        android.os.Bundle resultsFromIntent = getResultsFromIntent(intent);
        if (resultsFromIntent != null) {
            resultsFromIntent.putAll(bundle);
            bundle = resultsFromIntent;
        }
        for (android.support.v4.app.RemoteInputCompatBase.RemoteInput remoteInput : remoteInputArr) {
            java.util.Map<java.lang.String, android.net.Uri> dataResultsFromIntent = getDataResultsFromIntent(intent, remoteInput.getResultKey());
            android.app.RemoteInput.addResultsToIntent(fromCompat(new android.support.v4.app.RemoteInputCompatBase.RemoteInput[]{remoteInput}), intent, bundle);
            if (dataResultsFromIntent != null) {
                addDataResultToIntent(remoteInput, intent, dataResultsFromIntent);
            }
        }
    }

    static android.app.RemoteInput[] fromCompat(android.support.v4.app.RemoteInputCompatBase.RemoteInput[] remoteInputArr) {
        if (remoteInputArr == null) {
            return null;
        }
        android.app.RemoteInput[] remoteInputArr2 = new android.app.RemoteInput[remoteInputArr.length];
        for (int i = 0; i < remoteInputArr.length; i++) {
            android.support.v4.app.RemoteInputCompatBase.RemoteInput remoteInput = remoteInputArr[i];
            remoteInputArr2[i] = new android.app.RemoteInput.Builder(remoteInput.getResultKey()).setLabel(remoteInput.getLabel()).setChoices(remoteInput.getChoices()).setAllowFreeFormInput(remoteInput.getAllowFreeFormInput()).addExtras(remoteInput.getExtras()).build();
        }
        return remoteInputArr2;
    }

    private static android.content.Intent getClipDataIntentFromIntent(android.content.Intent intent) {
        android.content.ClipData clipData = intent.getClipData();
        if (clipData == null) {
            return null;
        }
        android.content.ClipDescription description = clipData.getDescription();
        if (description.hasMimeType("text/vnd.android.intent") && description.getLabel().equals(android.support.v4.app.RemoteInput.RESULTS_CLIP_LABEL)) {
            return clipData.getItemAt(0).getIntent();
        }
        return null;
    }

    static java.util.Map<java.lang.String, android.net.Uri> getDataResultsFromIntent(android.content.Intent intent, java.lang.String str) {
        java.lang.String strSubstring;
        java.lang.String string;
        android.content.Intent clipDataIntentFromIntent = getClipDataIntentFromIntent(intent);
        if (clipDataIntentFromIntent == null) {
            return null;
        }
        java.util.HashMap map = new java.util.HashMap();
        for (java.lang.String str2 : clipDataIntentFromIntent.getExtras().keySet()) {
            if (str2.startsWith(EXTRA_DATA_TYPE_RESULTS_DATA) && (strSubstring = str2.substring(39)) != null && !strSubstring.isEmpty() && (string = clipDataIntentFromIntent.getBundleExtra(str2).getString(str)) != null && !string.isEmpty()) {
                map.put(strSubstring, android.net.Uri.parse(string));
            }
        }
        if (map.isEmpty()) {
            return null;
        }
        return map;
    }

    private static java.lang.String getExtraResultsKeyForData(java.lang.String str) {
        return EXTRA_DATA_TYPE_RESULTS_DATA + str;
    }

    static android.os.Bundle getResultsFromIntent(android.content.Intent intent) {
        return android.app.RemoteInput.getResultsFromIntent(intent);
    }

    static android.support.v4.app.RemoteInputCompatBase.RemoteInput[] toCompat(android.app.RemoteInput[] remoteInputArr, android.support.v4.app.RemoteInputCompatBase.RemoteInput.Factory factory) {
        if (remoteInputArr == null) {
            return null;
        }
        android.support.v4.app.RemoteInputCompatBase.RemoteInput[] remoteInputArrNewArray = factory.newArray(remoteInputArr.length);
        for (int i = 0; i < remoteInputArr.length; i++) {
            android.app.RemoteInput remoteInput = remoteInputArr[i];
            remoteInputArrNewArray[i] = factory.build(remoteInput.getResultKey(), remoteInput.getLabel(), remoteInput.getChoices(), remoteInput.getAllowFreeFormInput(), remoteInput.getExtras(), null);
        }
        return remoteInputArrNewArray;
    }
}
