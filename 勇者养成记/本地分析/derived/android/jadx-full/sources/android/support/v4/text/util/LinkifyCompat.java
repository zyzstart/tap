package android.support.v4.text.util;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class LinkifyCompat {
    private static final java.lang.String[] EMPTY_STRING = new java.lang.String[0];
    private static final java.util.Comparator<android.support.v4.text.util.LinkifyCompat.LinkSpec> COMPARATOR = new java.util.Comparator<android.support.v4.text.util.LinkifyCompat.LinkSpec>() { // from class: android.support.v4.text.util.LinkifyCompat.1
        @Override // java.util.Comparator
        public final int compare(android.support.v4.text.util.LinkifyCompat.LinkSpec linkSpec, android.support.v4.text.util.LinkifyCompat.LinkSpec linkSpec2) {
            if (linkSpec.start < linkSpec2.start) {
                return -1;
            }
            if (linkSpec.start <= linkSpec2.start && linkSpec.end >= linkSpec2.end) {
                return linkSpec.end > linkSpec2.end ? -1 : 0;
            }
            return 1;
        }
    };

    private static class LinkSpec {
        int end;
        android.text.style.URLSpan frameworkAddedSpan;
        int start;
        java.lang.String url;

        LinkSpec() {
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface LinkifyMask {
    }

    private LinkifyCompat() {
    }

    private static void addLinkMovementMethod(@android.support.annotation.NonNull android.widget.TextView textView) {
        android.text.method.MovementMethod movementMethod = textView.getMovementMethod();
        if ((movementMethod == null || !(movementMethod instanceof android.text.method.LinkMovementMethod)) && textView.getLinksClickable()) {
            textView.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
        }
    }

    public static final void addLinks(@android.support.annotation.NonNull android.widget.TextView textView, @android.support.annotation.NonNull java.util.regex.Pattern pattern, @android.support.annotation.Nullable java.lang.String str) {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            android.text.util.Linkify.addLinks(textView, pattern, str);
        } else {
            addLinks(textView, pattern, str, (java.lang.String[]) null, (android.text.util.Linkify.MatchFilter) null, (android.text.util.Linkify.TransformFilter) null);
        }
    }

    public static final void addLinks(@android.support.annotation.NonNull android.widget.TextView textView, @android.support.annotation.NonNull java.util.regex.Pattern pattern, @android.support.annotation.Nullable java.lang.String str, @android.support.annotation.Nullable android.text.util.Linkify.MatchFilter matchFilter, @android.support.annotation.Nullable android.text.util.Linkify.TransformFilter transformFilter) {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            android.text.util.Linkify.addLinks(textView, pattern, str, matchFilter, transformFilter);
        } else {
            addLinks(textView, pattern, str, (java.lang.String[]) null, matchFilter, transformFilter);
        }
    }

    public static final void addLinks(@android.support.annotation.NonNull android.widget.TextView textView, @android.support.annotation.NonNull java.util.regex.Pattern pattern, @android.support.annotation.Nullable java.lang.String str, @android.support.annotation.Nullable java.lang.String[] strArr, @android.support.annotation.Nullable android.text.util.Linkify.MatchFilter matchFilter, @android.support.annotation.Nullable android.text.util.Linkify.TransformFilter transformFilter) {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            android.text.util.Linkify.addLinks(textView, pattern, str, strArr, matchFilter, transformFilter);
            return;
        }
        android.text.SpannableString spannableStringValueOf = android.text.SpannableString.valueOf(textView.getText());
        if (addLinks(spannableStringValueOf, pattern, str, strArr, matchFilter, transformFilter)) {
            textView.setText(spannableStringValueOf);
            addLinkMovementMethod(textView);
        }
    }

    public static final boolean addLinks(@android.support.annotation.NonNull android.text.Spannable spannable, int i) {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            return android.text.util.Linkify.addLinks(spannable, i);
        }
        if (i == 0) {
            return false;
        }
        android.text.style.URLSpan[] uRLSpanArr = (android.text.style.URLSpan[]) spannable.getSpans(0, spannable.length(), android.text.style.URLSpan.class);
        for (int length = uRLSpanArr.length - 1; length >= 0; length--) {
            spannable.removeSpan(uRLSpanArr[length]);
        }
        if ((i & 4) != 0) {
            android.text.util.Linkify.addLinks(spannable, 4);
        }
        java.util.ArrayList<android.support.v4.text.util.LinkifyCompat.LinkSpec> arrayList = new java.util.ArrayList();
        if ((i & 1) != 0) {
            gatherLinks(arrayList, spannable, android.support.v4.util.PatternsCompat.AUTOLINK_WEB_URL, new java.lang.String[]{"http://", "https://", "rtsp://"}, android.text.util.Linkify.sUrlMatchFilter, null);
        }
        if ((i & 2) != 0) {
            gatherLinks(arrayList, spannable, android.support.v4.util.PatternsCompat.AUTOLINK_EMAIL_ADDRESS, new java.lang.String[]{com.tencent.smtt.sdk.WebView.SCHEME_MAILTO}, null, null);
        }
        if ((i & 8) != 0) {
            gatherMapLinks(arrayList, spannable);
        }
        pruneOverlaps(arrayList, spannable);
        if (arrayList.size() == 0) {
            return false;
        }
        for (android.support.v4.text.util.LinkifyCompat.LinkSpec linkSpec : arrayList) {
            if (linkSpec.frameworkAddedSpan == null) {
                applyLink(linkSpec.url, linkSpec.start, linkSpec.end, spannable);
            }
        }
        return true;
    }

    public static final boolean addLinks(@android.support.annotation.NonNull android.text.Spannable spannable, @android.support.annotation.NonNull java.util.regex.Pattern pattern, @android.support.annotation.Nullable java.lang.String str) {
        return android.os.Build.VERSION.SDK_INT >= 26 ? android.text.util.Linkify.addLinks(spannable, pattern, str) : addLinks(spannable, pattern, str, (java.lang.String[]) null, (android.text.util.Linkify.MatchFilter) null, (android.text.util.Linkify.TransformFilter) null);
    }

    public static final boolean addLinks(@android.support.annotation.NonNull android.text.Spannable spannable, @android.support.annotation.NonNull java.util.regex.Pattern pattern, @android.support.annotation.Nullable java.lang.String str, @android.support.annotation.Nullable android.text.util.Linkify.MatchFilter matchFilter, @android.support.annotation.Nullable android.text.util.Linkify.TransformFilter transformFilter) {
        return android.os.Build.VERSION.SDK_INT >= 26 ? android.text.util.Linkify.addLinks(spannable, pattern, str, matchFilter, transformFilter) : addLinks(spannable, pattern, str, (java.lang.String[]) null, matchFilter, transformFilter);
    }

    public static final boolean addLinks(@android.support.annotation.NonNull android.text.Spannable spannable, @android.support.annotation.NonNull java.util.regex.Pattern pattern, @android.support.annotation.Nullable java.lang.String str, @android.support.annotation.Nullable java.lang.String[] strArr, @android.support.annotation.Nullable android.text.util.Linkify.MatchFilter matchFilter, @android.support.annotation.Nullable android.text.util.Linkify.TransformFilter transformFilter) {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            return android.text.util.Linkify.addLinks(spannable, pattern, str, strArr, matchFilter, transformFilter);
        }
        if (str == null) {
            str = "";
        }
        if (strArr == null || strArr.length < 1) {
            strArr = EMPTY_STRING;
        }
        java.lang.String[] strArr2 = new java.lang.String[strArr.length + 1];
        strArr2[0] = str.toLowerCase(java.util.Locale.ROOT);
        int i = 0;
        while (i < strArr.length) {
            java.lang.String str2 = strArr[i];
            i++;
            strArr2[i] = str2 == null ? "" : str2.toLowerCase(java.util.Locale.ROOT);
        }
        java.util.regex.Matcher matcher = pattern.matcher(spannable);
        boolean z = false;
        while (matcher.find()) {
            int iStart = matcher.start();
            int iEnd = matcher.end();
            if (matchFilter != null ? matchFilter.acceptMatch(spannable, iStart, iEnd) : true) {
                applyLink(makeUrl(matcher.group(0), strArr2, matcher, transformFilter), iStart, iEnd, spannable);
                z = true;
            }
        }
        return z;
    }

    public static final boolean addLinks(@android.support.annotation.NonNull android.widget.TextView textView, int i) {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            return android.text.util.Linkify.addLinks(textView, i);
        }
        if (i == 0) {
            return false;
        }
        java.lang.CharSequence text = textView.getText();
        if (text instanceof android.text.Spannable) {
            if (!addLinks((android.text.Spannable) text, i)) {
                return false;
            }
            addLinkMovementMethod(textView);
            return true;
        }
        android.text.SpannableString spannableStringValueOf = android.text.SpannableString.valueOf(text);
        if (!addLinks(spannableStringValueOf, i)) {
            return false;
        }
        addLinkMovementMethod(textView);
        textView.setText(spannableStringValueOf);
        return true;
    }

    private static void applyLink(java.lang.String str, int i, int i2, android.text.Spannable spannable) {
        spannable.setSpan(new android.text.style.URLSpan(str), i, i2, 33);
    }

    private static void gatherLinks(java.util.ArrayList<android.support.v4.text.util.LinkifyCompat.LinkSpec> arrayList, android.text.Spannable spannable, java.util.regex.Pattern pattern, java.lang.String[] strArr, android.text.util.Linkify.MatchFilter matchFilter, android.text.util.Linkify.TransformFilter transformFilter) {
        java.util.regex.Matcher matcher = pattern.matcher(spannable);
        while (matcher.find()) {
            int iStart = matcher.start();
            int iEnd = matcher.end();
            if (matchFilter == null || matchFilter.acceptMatch(spannable, iStart, iEnd)) {
                android.support.v4.text.util.LinkifyCompat.LinkSpec linkSpec = new android.support.v4.text.util.LinkifyCompat.LinkSpec();
                linkSpec.url = makeUrl(matcher.group(0), strArr, matcher, transformFilter);
                linkSpec.start = iStart;
                linkSpec.end = iEnd;
                arrayList.add(linkSpec);
            }
        }
    }

    private static final void gatherMapLinks(java.util.ArrayList<android.support.v4.text.util.LinkifyCompat.LinkSpec> arrayList, android.text.Spannable spannable) {
        int iIndexOf;
        java.lang.String string = spannable.toString();
        int i = 0;
        while (true) {
            try {
                java.lang.String strFindAddress = android.webkit.WebView.findAddress(string);
                if (strFindAddress != null && (iIndexOf = string.indexOf(strFindAddress)) >= 0) {
                    android.support.v4.text.util.LinkifyCompat.LinkSpec linkSpec = new android.support.v4.text.util.LinkifyCompat.LinkSpec();
                    int length = strFindAddress.length() + iIndexOf;
                    linkSpec.start = iIndexOf + i;
                    i += length;
                    linkSpec.end = i;
                    string = string.substring(length);
                    try {
                        linkSpec.url = com.tencent.smtt.sdk.WebView.SCHEME_GEO + java.net.URLEncoder.encode(strFindAddress, "UTF-8");
                        arrayList.add(linkSpec);
                    } catch (java.io.UnsupportedEncodingException unused) {
                    }
                }
                return;
            } catch (java.lang.UnsupportedOperationException unused2) {
                return;
            }
        }
    }

    private static java.lang.String makeUrl(@android.support.annotation.NonNull java.lang.String str, @android.support.annotation.NonNull java.lang.String[] strArr, java.util.regex.Matcher matcher, @android.support.annotation.Nullable android.text.util.Linkify.TransformFilter transformFilter) {
        boolean z;
        if (transformFilter != null) {
            str = transformFilter.transformUrl(matcher, str);
        }
        int i = 0;
        while (true) {
            z = true;
            if (i >= strArr.length) {
                z = false;
                break;
            }
            if (str.regionMatches(true, 0, strArr[i], 0, strArr[i].length())) {
                if (!str.regionMatches(false, 0, strArr[i], 0, strArr[i].length())) {
                    str = strArr[i] + str.substring(strArr[i].length());
                    break;
                }
                break;
            }
            i++;
        }
        if (z || strArr.length <= 0) {
            return str;
        }
        return strArr[0] + str;
    }

    private static final void pruneOverlaps(java.util.ArrayList<android.support.v4.text.util.LinkifyCompat.LinkSpec> arrayList, android.text.Spannable spannable) {
        int i = 0;
        android.text.style.URLSpan[] uRLSpanArr = (android.text.style.URLSpan[]) spannable.getSpans(0, spannable.length(), android.text.style.URLSpan.class);
        for (int i2 = 0; i2 < uRLSpanArr.length; i2++) {
            android.support.v4.text.util.LinkifyCompat.LinkSpec linkSpec = new android.support.v4.text.util.LinkifyCompat.LinkSpec();
            linkSpec.frameworkAddedSpan = uRLSpanArr[i2];
            linkSpec.start = spannable.getSpanStart(uRLSpanArr[i2]);
            linkSpec.end = spannable.getSpanEnd(uRLSpanArr[i2]);
            arrayList.add(linkSpec);
        }
        java.util.Collections.sort(arrayList, COMPARATOR);
        int size = arrayList.size();
        while (i < size - 1) {
            android.support.v4.text.util.LinkifyCompat.LinkSpec linkSpec2 = arrayList.get(i);
            int i3 = i + 1;
            android.support.v4.text.util.LinkifyCompat.LinkSpec linkSpec3 = arrayList.get(i3);
            if (linkSpec2.start <= linkSpec3.start && linkSpec2.end > linkSpec3.start) {
                int i4 = (linkSpec3.end > linkSpec2.end && linkSpec2.end - linkSpec2.start <= linkSpec3.end - linkSpec3.start) ? linkSpec2.end - linkSpec2.start < linkSpec3.end - linkSpec3.start ? i : -1 : i3;
                if (i4 != -1) {
                    java.lang.Object obj = arrayList.get(i4).frameworkAddedSpan;
                    if (obj != null) {
                        spannable.removeSpan(obj);
                    }
                    arrayList.remove(i4);
                    size--;
                }
            }
            i = i3;
        }
    }
}
