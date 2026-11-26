package com.unisound.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final java.util.regex.Pattern f1491a = java.util.regex.Pattern.compile("[零一二三四五六七八九十][一二三四五六七八九十零百千万亿]*(点[零一二三四五六七八九]+)?");
    private static final char[] b = {38646, 19968, 20108, 19977, 22235, 20116, 20845, 19971, 20843, 20061};
    private static java.util.Map<java.lang.Character, java.lang.Integer> c;
    private static java.util.Map<java.lang.Character, java.lang.Integer> d;
    private static java.util.Map<java.lang.Character, java.lang.Integer> e;

    static {
        a();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static java.lang.String a(java.lang.String str) {
        if (f1491a.matcher(str).matches()) {
            if (e(str)) {
                java.lang.String[] strArrSplit = str.split("点");
                return strArrSplit.length == 1 ? c(strArrSplit[0]) : java.lang.String.format("%s.%s", c(strArrSplit[0]), d(strArrSplit[1]));
            }
            java.lang.String[] strArrSplit2 = str.split("点");
            return strArrSplit2.length == 1 ? d(strArrSplit2[0]) : java.lang.String.format("%s.%s", d(strArrSplit2[0]), d(strArrSplit2[1]));
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            }
            if (f1491a.matcher(java.lang.String.valueOf(charArray[i])).matches()) {
                break;
            }
            i++;
        }
        if (i == -1) {
            return str;
        }
        int i2 = length - 1;
        int i3 = i2;
        while (true) {
            if (i3 < 0) {
                i3 = -1;
                break;
            }
            if (f1491a.matcher(java.lang.String.valueOf(charArray[i3])).matches()) {
                int i4 = i3;
                while (true) {
                    if (i3 >= charArray.length) {
                        i3 = i4;
                        break;
                    }
                    int i5 = i3 + 2;
                    if (i5 <= charArray.length) {
                        if (!f1491a.matcher(str.substring(i3, i5)).matches()) {
                            break;
                        }
                        i4 = i3 + 1;
                    }
                    i3++;
                }
            } else {
                i3--;
            }
        }
        if (i == 0 && i3 == i2) {
            int i6 = -1;
            for (int i7 = i; i7 < i3; i7++) {
                if (!f1491a.matcher(java.lang.String.valueOf(charArray[i7])).matches()) {
                    i6 = i7 + 1;
                    if (i7 < length && !f1491a.matcher(str.substring(0, i6 + 1)).matches()) {
                        break;
                    }
                }
            }
            if (i6 != -1) {
                return a(str.substring(0, i6)) + a(str.substring(i6));
            }
        }
        if (i == 0) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            int i8 = i3 + 1;
            sb.append(a(str.substring(i, i8)));
            sb.append(str.substring(i8));
            return sb.toString();
        }
        if (i3 == i2) {
            return str.substring(0, i) + a(str.substring(i, i3 + 1));
        }
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append(str.substring(0, i));
        int i9 = i3 + 1;
        sb2.append(a(str.substring(i, i9)));
        sb2.append(str.substring(i9));
        return sb2.toString();
    }

    public static void a() {
        c = new java.util.HashMap();
        int i = 0;
        while (true) {
            char[] cArr = b;
            if (i >= cArr.length) {
                d = new java.util.HashMap();
                d.put((char) 21313, 10);
                d.put((char) 30334, 100);
                d.put((char) 21315, 1000);
                e = new java.util.HashMap();
                e.put((char) 19975, 10000);
                e.put((char) 20159, 100000000);
                return;
            }
            c.put(java.lang.Character.valueOf(cArr[i]), java.lang.Integer.valueOf(i));
            i++;
        }
    }

    public static java.lang.String b(java.lang.String str) {
        if (f1491a.matcher(str).matches()) {
            java.lang.String[] strArrSplit = str.split("点");
            return strArrSplit.length == 1 ? c(strArrSplit[0]) : java.lang.String.format("%s.%s", c(strArrSplit[0]), d(strArrSplit[1]));
        }
        throw new java.lang.IllegalArgumentException(str + " is not a valid chinese number");
    }

    private static java.lang.String c(java.lang.String str) {
        boolean z = false;
        int i = 0;
        int iIntValue = 1;
        int iIntValue2 = 0;
        for (char c2 : str.toCharArray()) {
            if (c.containsKey(java.lang.Character.valueOf(c2))) {
                iIntValue = c.get(java.lang.Character.valueOf(c2)).intValue();
                z = true;
            } else if (d.containsKey(java.lang.Character.valueOf(c2))) {
                int iIntValue3 = d.get(java.lang.Character.valueOf(c2)).intValue();
                if (iIntValue == 0 && iIntValue3 == 10) {
                    iIntValue = 1;
                }
                i += iIntValue3 * iIntValue;
                z = false;
            } else if (e.containsKey(java.lang.Character.valueOf(c2))) {
                if (z) {
                    i += iIntValue;
                }
                iIntValue2 += i * e.get(java.lang.Character.valueOf(c2)).intValue();
                z = false;
                i = 0;
            }
        }
        if (z) {
            i += iIntValue;
        }
        return java.lang.Integer.toString(iIntValue2 + i);
    }

    private static java.lang.String d(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (char c2 : str.toCharArray()) {
            sb.append(java.lang.Integer.toString(c.get(java.lang.Character.valueOf(c2)).intValue()));
        }
        return sb.toString();
    }

    private static boolean e(java.lang.String str) {
        if (str != null) {
            return str.contains("十") || str.contains("百") || str.contains("千") || str.contains("万") || str.contains("亿");
        }
        return false;
    }
}
