package android.support.v4.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.RequiresApi(16)
class RemoteInputCompatJellybean {
    private static final java.lang.String EXTRA_DATA_TYPE_RESULTS_DATA = "android.remoteinput.dataTypeResultsData";
    private static final java.lang.String KEY_ALLOWED_DATA_TYPES = "allowedDataTypes";
    private static final java.lang.String KEY_ALLOW_FREE_FORM_INPUT = "allowFreeFormInput";
    private static final java.lang.String KEY_CHOICES = "choices";
    private static final java.lang.String KEY_EXTRAS = "extras";
    private static final java.lang.String KEY_LABEL = "label";
    private static final java.lang.String KEY_RESULT_KEY = "resultKey";

    RemoteInputCompatJellybean() {
    }

    public static void addDataResultToIntent(android.support.v4.app.RemoteInput remoteInput, android.content.Intent intent, java.util.Map<java.lang.String, android.net.Uri> map) {
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
        android.content.Intent clipDataIntentFromIntent = getClipDataIntentFromIntent(intent);
        if (clipDataIntentFromIntent == null) {
            clipDataIntentFromIntent = new android.content.Intent();
        }
        android.os.Bundle bundleExtra = clipDataIntentFromIntent.getBundleExtra(android.support.v4.app.RemoteInput.EXTRA_RESULTS_DATA);
        if (bundleExtra == null) {
            bundleExtra = new android.os.Bundle();
        }
        for (android.support.v4.app.RemoteInputCompatBase.RemoteInput remoteInput : remoteInputArr) {
            java.lang.Object obj = bundle.get(remoteInput.getResultKey());
            if (obj instanceof java.lang.CharSequence) {
                bundleExtra.putCharSequence(remoteInput.getResultKey(), (java.lang.CharSequence) obj);
            }
        }
        clipDataIntentFromIntent.putExtra(android.support.v4.app.RemoteInput.EXTRA_RESULTS_DATA, bundleExtra);
        intent.setClipData(android.content.ClipData.newIntent(android.support.v4.app.RemoteInput.RESULTS_CLIP_LABEL, clipDataIntentFromIntent));
    }

    static android.support.v4.app.RemoteInputCompatBase.RemoteInput fromBundle(android.os.Bundle bundle, android.support.v4.app.RemoteInputCompatBase.RemoteInput.Factory factory) {
        java.util.ArrayList<java.lang.String> stringArrayList = bundle.getStringArrayList(KEY_ALLOWED_DATA_TYPES);
        java.util.HashSet hashSet = new java.util.HashSet();
        if (stringArrayList != null) {
            java.util.Iterator<java.lang.String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                hashSet.add(it.next());
            }
        }
        return factory.build(bundle.getString(KEY_RESULT_KEY), bundle.getCharSequence(KEY_LABEL), bundle.getCharSequenceArray(KEY_CHOICES), bundle.getBoolean(KEY_ALLOW_FREE_FORM_INPUT), bundle.getBundle(KEY_EXTRAS), hashSet);
    }

    static android.support.v4.app.RemoteInputCompatBase.RemoteInput[] fromBundleArray(android.os.Bundle[] bundleArr, android.support.v4.app.RemoteInputCompatBase.RemoteInput.Factory factory) {
        if (bundleArr == null) {
            return null;
        }
        android.support.v4.app.RemoteInputCompatBase.RemoteInput[] remoteInputArrNewArray = factory.newArray(bundleArr.length);
        for (int i = 0; i < bundleArr.length; i++) {
            remoteInputArrNewArray[i] = fromBundle(bundleArr[i], factory);
        }
        return remoteInputArrNewArray;
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
        android.content.Intent clipDataIntentFromIntent = getClipDataIntentFromIntent(intent);
        if (clipDataIntentFromIntent == null) {
            return null;
        }
        return (android.os.Bundle) clipDataIntentFromIntent.getExtras().getParcelable(android.support.v4.app.RemoteInput.EXTRA_RESULTS_DATA);
    }

    static android.os.Bundle toBundle(android.support.v4.app.RemoteInputCompatBase.RemoteInput remoteInput) {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString(KEY_RESULT_KEY, remoteInput.getResultKey());
        bundle.putCharSequence(KEY_LABEL, remoteInput.getLabel());
        bundle.putCharSequenceArray(KEY_CHOICES, remoteInput.getChoices());
        bundle.putBoolean(KEY_ALLOW_FREE_FORM_INPUT, remoteInput.getAllowFreeFormInput());
        bundle.putBundle(KEY_EXTRAS, remoteInput.getExtras());
        java.util.Set<java.lang.String> allowedDataTypes = remoteInput.getAllowedDataTypes();
        if (allowedDataTypes != null && !allowedDataTypes.isEmpty()) {
            java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>(allowedDataTypes.size());
            java.util.Iterator<java.lang.String> it = allowedDataTypes.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            bundle.putStringArrayList(KEY_ALLOWED_DATA_TYPES, arrayList);
        }
        return bundle;
    }

    static android.os.Bundle[] toBundleArray(android.support.v4.app.RemoteInputCompatBase.RemoteInput[] remoteInputArr) {
        if (remoteInputArr == null) {
            return null;
        }
        android.os.Bundle[] bundleArr = new android.os.Bundle[remoteInputArr.length];
        for (int i = 0; i < remoteInputArr.length; i++) {
            bundleArr[i] = toBundle(remoteInputArr[i]);
        }
        return bundleArr;
    }
}
