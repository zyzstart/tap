package com.tencent.beacon.core.event;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class t {
    public static int a(android.content.Context context, java.lang.String str) {
        com.tencent.beacon.core.e.d.a("[db] start", new java.lang.Object[0]);
        if (context != null) {
            return com.tencent.beacon.core.a.a.b.b(context, str, new int[]{1, 2, 3, 4}, -1L, Long.MAX_VALUE);
        }
        com.tencent.beacon.core.e.d.b("[db] context is null.", new java.lang.Object[0]);
        return -1;
    }

    public static int a(android.content.Context context, java.lang.String str, java.lang.Long[] lArr) {
        com.tencent.beacon.core.e.d.a("[db] start", new java.lang.Object[0]);
        if (context == null) {
            com.tencent.beacon.core.e.d.b("[db] have null args!", new java.lang.Object[0]);
            return -1;
        }
        com.tencent.beacon.core.e.d.a("[db] end", new java.lang.Object[0]);
        return com.tencent.beacon.core.a.a.b.a(context, str, lArr);
    }

    public static int a(android.content.Context context, java.lang.String str, java.lang.String[] strArr, long j, long j2) {
        int[] iArr;
        int iValueOf;
        int i;
        com.tencent.beacon.core.e.d.a("[db] start", new java.lang.Object[0]);
        if (strArr == null) {
            iArr = new int[]{1, 2, 3, 4};
        } else {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (strArr[i2].equals(com.tencent.beacon.core.event.RDBean.TP_UA)) {
                    i = 1;
                } else if (strArr[i2].equals(com.tencent.beacon.core.event.RDBean.TP_DN)) {
                    i = 3;
                } else {
                    if (strArr[i2].equals("IP")) {
                        i = 2;
                    } else if (strArr[i2].equals(com.tencent.beacon.core.event.RDBean.TP_HO)) {
                        iValueOf = 4;
                        arrayList.add(iValueOf);
                    }
                }
                iValueOf = java.lang.Integer.valueOf(i);
                arrayList.add(iValueOf);
            }
            iArr = new int[arrayList.size()];
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                iArr[i3] = ((java.lang.Integer) arrayList.get(i3)).intValue();
            }
        }
        return com.tencent.beacon.core.a.a.b.a(context, str, iArr, j, j2);
    }

    public static java.util.List a(android.content.Context context, java.lang.String str, java.lang.String[] strArr, int i) {
        int[] iArr;
        int iValueOf;
        int i2;
        com.tencent.beacon.core.e.d.a("[db] start", new java.lang.Object[0]);
        if (context == null) {
            com.tencent.beacon.core.e.d.b("[db] have null args!", new java.lang.Object[0]);
            return null;
        }
        if (strArr == null) {
            iArr = new int[]{1, 2, 3, 4};
        } else {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (int i3 = 0; i3 < strArr.length; i3++) {
                if (strArr[i3].equals(com.tencent.beacon.core.event.RDBean.TP_UA)) {
                    i2 = 1;
                } else if (strArr[i3].equals(com.tencent.beacon.core.event.RDBean.TP_DN)) {
                    i2 = 3;
                } else {
                    if (strArr[i3].equals("IP")) {
                        i2 = 2;
                    } else if (strArr[i3].equals(com.tencent.beacon.core.event.RDBean.TP_HO)) {
                        iValueOf = 4;
                        arrayList.add(iValueOf);
                    }
                }
                iValueOf = java.lang.Integer.valueOf(i2);
                arrayList.add(iValueOf);
            }
            iArr = new int[arrayList.size()];
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                iArr[i4] = ((java.lang.Integer) arrayList.get(i4)).intValue();
            }
        }
        java.util.List listA = com.tencent.beacon.core.a.a.b.a(context, str, iArr, 1, 2, i);
        if (listA == null || listA.size() <= 0) {
            return null;
        }
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.util.Iterator it = listA.iterator();
        while (it.hasNext()) {
            com.tencent.beacon.core.a.a.a aVar = (com.tencent.beacon.core.a.a.a) it.next();
            try {
                java.lang.Object objA = com.tencent.beacon.core.e.b.a(aVar.e);
                if (objA != null && com.tencent.beacon.core.event.RDBean.class.isInstance(objA)) {
                    com.tencent.beacon.core.event.RDBean rDBean = (com.tencent.beacon.core.event.RDBean) com.tencent.beacon.core.event.RDBean.class.cast(objA);
                    rDBean.setCid(aVar.f126a);
                    arrayList2.add(rDBean);
                    it.remove();
                }
            } catch (java.lang.Throwable th) {
                com.tencent.beacon.core.e.d.a(th);
                com.tencent.beacon.core.e.d.b("[db] query have error!", new java.lang.Object[0]);
            }
        }
        if (listA.size() > 0) {
            com.tencent.beacon.core.e.d.i("[db] there are error data ,should be remove " + listA.size(), new java.lang.Object[0]);
            java.lang.Long[] lArr = new java.lang.Long[listA.size()];
            for (int i5 = 0; i5 < listA.size(); i5++) {
                lArr[i5] = java.lang.Long.valueOf(((com.tencent.beacon.core.a.a.a) listA.get(i5)).f126a);
            }
            com.tencent.beacon.core.a.a.b.a(context, str, lArr);
        }
        com.tencent.beacon.core.e.d.a("[db] end", new java.lang.Object[0]);
        return arrayList2;
    }

    public static java.lang.Long[] a(android.content.Context context, java.lang.String str, java.util.List list) {
        java.lang.Object[] objArr;
        java.lang.String str2;
        int i;
        int i2;
        int i3 = 0;
        com.tencent.beacon.core.e.d.a("[db] start", new java.lang.Object[0]);
        if (context == null || list == null) {
            com.tencent.beacon.core.e.d.b("[db] have null args!", new java.lang.Object[0]);
            return null;
        }
        int size = list.size();
        if (size == 0) {
            com.tencent.beacon.core.e.d.b("[db] insert list size(0) return.", new java.lang.Object[0]);
            return null;
        }
        java.lang.Long[] lArr = new java.lang.Long[size];
        java.util.ArrayList<com.tencent.beacon.core.a.a.a> arrayList = new java.util.ArrayList();
        for (int i4 = 0; i4 < size; i4++) {
            com.tencent.beacon.core.event.RDBean rDBean = (com.tencent.beacon.core.event.RDBean) list.get(i4);
            if (rDBean == null) {
                objArr = new java.lang.Object[0];
                str2 = "[db] bean is null!";
            } else {
                if (rDBean.getTP().equals(com.tencent.beacon.core.event.RDBean.TP_UA)) {
                    i = 1;
                    i2 = 3;
                } else {
                    if (rDBean.getTP().equals("IP")) {
                        i = 2;
                    } else if (rDBean.getTP().equals(com.tencent.beacon.core.event.RDBean.TP_DN)) {
                        i = 3;
                    } else if (rDBean.getTP().equals(com.tencent.beacon.core.event.RDBean.TP_HO)) {
                        i = 4;
                    } else {
                        objArr = new java.lang.Object[0];
                        str2 = "[db] bean's type is error!";
                    }
                    i2 = 0;
                }
                try {
                    arrayList.add(new com.tencent.beacon.core.a.a.a(i, i2, rDBean.getTM(), com.tencent.beacon.core.e.b.a(rDBean)));
                } catch (java.lang.Throwable th) {
                    com.tencent.beacon.core.e.d.b("[db] bean: %s add to analyticsList error!", rDBean.getEN());
                    com.tencent.beacon.core.e.d.a(th);
                }
            }
            com.tencent.beacon.core.e.d.i(str2, objArr);
        }
        if (!com.tencent.beacon.core.a.a.b.a(context, str, arrayList)) {
            com.tencent.beacon.core.e.d.a("[db] AnalyticsDAO.insert beans fail!", new java.lang.Object[0]);
            return null;
        }
        com.tencent.beacon.core.e.d.a("[db] AnalyticsDAO.insert beans success!", new java.lang.Object[0]);
        for (com.tencent.beacon.core.a.a.a aVar : arrayList) {
            if (i3 < size) {
                lArr[i3] = java.lang.Long.valueOf(aVar.f126a);
            }
            i3++;
        }
        return lArr;
    }
}
