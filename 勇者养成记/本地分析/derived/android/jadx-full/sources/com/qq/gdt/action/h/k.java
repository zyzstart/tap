package com.qq.gdt.action.h;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class k {
    /* JADX WARN: Code duplicated, block: B:22:0x003f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:23:0x0041 A[Catch: Exception -> 0x0077, TryCatch #0 {Exception -> 0x0077, blocks: (B:3:0x0002, B:6:0x000c, B:7:0x0015, B:9:0x001b, B:21:0x003b, B:33:0x006b, B:23:0x0041, B:24:0x004a, B:26:0x004f, B:27:0x0058, B:30:0x005f, B:32:0x0068, B:34:0x006f), top: B:40:0x0002 }] */
    public static java.lang.String a(java.lang.String str) {
        if (str == null) {
            return "";
        }
        try {
            if ("".equals(str)) {
                return "";
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            int i = 0;
            char c = 0;
            boolean z = false;
            int i2 = 0;
            while (i < str.length()) {
                char cCharAt = str.charAt(i);
                if (cCharAt != '\"') {
                    if (cCharAt != ',') {
                        if (cCharAt != '[') {
                            if (cCharAt == ']') {
                                if (!z) {
                                    sb.append('\n');
                                    i2--;
                                    a(sb, i2);
                                }
                            } else if (cCharAt != '{') {
                                if (cCharAt == '}') {
                                    if (!z) {
                                        sb.append('\n');
                                        i2--;
                                        a(sb, i2);
                                    }
                                }
                            }
                        }
                        sb.append(cCharAt);
                        if (!z) {
                            sb.append('\n');
                            i2++;
                            a(sb, i2);
                        }
                    } else {
                        sb.append(cCharAt);
                        if (c != '\\' && !z) {
                            sb.append('\n');
                            a(sb, i2);
                        }
                    }
                    i++;
                    c = cCharAt;
                } else if (c != '\\') {
                    z = !z;
                }
                sb.append(cCharAt);
                i++;
                c = cCharAt;
            }
            return sb.toString();
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    private static void a(java.lang.StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            try {
                sb.append('\t');
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }
}
