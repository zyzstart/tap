package com.qq.gdt.action.d.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final java.util.regex.Pattern f93a = java.util.regex.Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private static final java.util.regex.Pattern b = java.util.regex.Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    private final java.lang.String c;
    private final java.lang.String d;
    private final java.lang.String e;
    private final java.lang.String f;

    private f(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
    }

    public static com.qq.gdt.action.d.b.f a(java.lang.String str) {
        java.util.regex.Matcher matcher = f93a.matcher(str);
        if (!matcher.lookingAt()) {
            return null;
        }
        java.lang.String lowerCase = matcher.group(1).toLowerCase(java.util.Locale.US);
        java.lang.String lowerCase2 = matcher.group(2).toLowerCase(java.util.Locale.US);
        java.util.regex.Matcher matcher2 = b.matcher(str);
        java.lang.String str2 = null;
        for (int iEnd = matcher.end(); iEnd < str.length(); iEnd = matcher2.end()) {
            matcher2.region(iEnd, str.length());
            if (!matcher2.lookingAt()) {
                return null;
            }
            java.lang.String strGroup = matcher2.group(1);
            if (strGroup != null && strGroup.equalsIgnoreCase("charset")) {
                java.lang.String strGroup2 = matcher2.group(2) != null ? matcher2.group(2) : matcher2.group(3);
                if (str2 != null && !strGroup2.equalsIgnoreCase(str2)) {
                    throw new java.lang.IllegalArgumentException("Multiple different charsets: " + str);
                }
                str2 = strGroup2;
            }
        }
        return new com.qq.gdt.action.d.b.f(str, lowerCase, lowerCase2, str2);
    }

    public boolean equals(java.lang.Object obj) {
        return (obj instanceof com.qq.gdt.action.d.b.f) && ((com.qq.gdt.action.d.b.f) obj).c.equals(this.c);
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    public java.lang.String toString() {
        return this.c;
    }
}
