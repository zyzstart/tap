package com.dodjoy.platform;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ThirdStatistics {
    private static com.dodjoy.platform.ThirdStatisticsImpl ThirdImpl = null;
    private static boolean need = true;

    public static java.util.Map<java.lang.String, java.lang.Object> getMapForJson(java.lang.String str) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            java.util.Iterator<java.lang.String> itKeys = jSONObject.keys();
            java.util.HashMap map = new java.util.HashMap();
            while (itKeys.hasNext()) {
                java.lang.String next = itKeys.next();
                map.put(next, jSONObject.get(next));
            }
            return map;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void init(android.app.Activity activity, java.lang.String str, java.lang.String str2) {
        need = !str.isEmpty();
        if (need && ThirdImpl == null) {
            ThirdImpl = new com.dodjoy.platform.ThirdStatisticsTD();
        }
        if (need) {
            ThirdImpl.init(activity, str, str2);
        }
    }

    public static void onPause(android.app.Activity activity) {
        com.dodjoy.platform.ThirdStatisticsImpl thirdStatisticsImpl;
        if (!need || (thirdStatisticsImpl = ThirdImpl) == null) {
            return;
        }
        thirdStatisticsImpl.onPause(activity);
    }

    public static void onResume(android.app.Activity activity) {
        com.dodjoy.platform.ThirdStatisticsImpl thirdStatisticsImpl;
        if (!need || (thirdStatisticsImpl = ThirdImpl) == null) {
            return;
        }
        thirdStatisticsImpl.onResume(activity);
    }

    public static void tdgaOnBegin(java.lang.String str) {
        com.dodjoy.platform.ThirdStatisticsImpl thirdStatisticsImpl;
        if (!need || (thirdStatisticsImpl = ThirdImpl) == null) {
            return;
        }
        thirdStatisticsImpl.onBegin(str);
    }

    public static void tdgaOnChargeRequest(java.lang.String str, java.lang.String str2, double d, java.lang.String str3, double d2, java.lang.String str4) {
        com.dodjoy.platform.ThirdStatisticsImpl thirdStatisticsImpl;
        if (!need || (thirdStatisticsImpl = ThirdImpl) == null) {
            return;
        }
        thirdStatisticsImpl.onChargeRequest(str, str2, d, str3, d2, str4);
    }

    public static void tdgaOnChargeSuccess(java.lang.String str) {
        com.dodjoy.platform.ThirdStatisticsImpl thirdStatisticsImpl;
        if (!need || (thirdStatisticsImpl = ThirdImpl) == null) {
            return;
        }
        thirdStatisticsImpl.onChargeSuccess(str);
    }

    public static void tdgaOnCompleted(java.lang.String str) {
        com.dodjoy.platform.ThirdStatisticsImpl thirdStatisticsImpl;
        if (!need || (thirdStatisticsImpl = ThirdImpl) == null) {
            return;
        }
        thirdStatisticsImpl.onCompleted(str);
    }

    public static void tdgaOnEvent(java.lang.String str, java.lang.String str2) {
        com.dodjoy.platform.ThirdStatisticsImpl thirdStatisticsImpl;
        if (!need || (thirdStatisticsImpl = ThirdImpl) == null) {
            return;
        }
        thirdStatisticsImpl.onEvent(str, getMapForJson(str2));
    }

    public static void tdgaOnFailed(java.lang.String str, java.lang.String str2) {
        com.dodjoy.platform.ThirdStatisticsImpl thirdStatisticsImpl;
        if (!need || (thirdStatisticsImpl = ThirdImpl) == null) {
            return;
        }
        thirdStatisticsImpl.onFailed(str, str2);
    }

    public static void tdgaOnPurchase(java.lang.String str, int i, double d) {
        com.dodjoy.platform.ThirdStatisticsImpl thirdStatisticsImpl;
        if (!need || (thirdStatisticsImpl = ThirdImpl) == null) {
            return;
        }
        thirdStatisticsImpl.onPurchase(str, i, d);
    }

    public static void tdgaOnReward(double d, java.lang.String str) {
        com.dodjoy.platform.ThirdStatisticsImpl thirdStatisticsImpl;
        if (!need || (thirdStatisticsImpl = ThirdImpl) == null) {
            return;
        }
        thirdStatisticsImpl.onReward(d, str);
    }

    public static void tdgaOnUse(java.lang.String str, int i) {
        com.dodjoy.platform.ThirdStatisticsImpl thirdStatisticsImpl;
        if (!need || (thirdStatisticsImpl = ThirdImpl) == null) {
            return;
        }
        thirdStatisticsImpl.onUse(str, i);
    }

    public static void tdgaSetAccount(java.lang.String str) {
        com.dodjoy.platform.ThirdStatisticsImpl thirdStatisticsImpl;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("call tdga set account ");
        sb.append(need);
        sb.append(" ");
        sb.append(ThirdImpl);
        com.dodjoy.utils.DodLog.e("Unity", sb.toString() != null);
        if (!need || (thirdStatisticsImpl = ThirdImpl) == null) {
            return;
        }
        thirdStatisticsImpl.setAccount(str);
    }

    public static void tdgaSetAccountName(java.lang.String str) {
        com.dodjoy.platform.ThirdStatisticsImpl thirdStatisticsImpl;
        if (!need || (thirdStatisticsImpl = ThirdImpl) == null) {
            return;
        }
        thirdStatisticsImpl.setAccountName(str);
    }

    public static void tdgaSetAccountType(int i) {
        com.dodjoy.platform.ThirdStatisticsImpl thirdStatisticsImpl;
        if (!need || (thirdStatisticsImpl = ThirdImpl) == null) {
            return;
        }
        thirdStatisticsImpl.setAccountType(i);
    }

    public static void tdgaSetAge(int i) {
        com.dodjoy.platform.ThirdStatisticsImpl thirdStatisticsImpl;
        if (!need || (thirdStatisticsImpl = ThirdImpl) == null) {
            return;
        }
        thirdStatisticsImpl.setAge(i);
    }

    public static void tdgaSetCreateAccount() {
        com.dodjoy.platform.ThirdStatisticsImpl thirdStatisticsImpl;
        if (!need || (thirdStatisticsImpl = ThirdImpl) == null) {
            return;
        }
        thirdStatisticsImpl.setCreateAccount();
    }

    public static void tdgaSetGameServer(java.lang.String str) {
        com.dodjoy.platform.ThirdStatisticsImpl thirdStatisticsImpl;
        if (!need || (thirdStatisticsImpl = ThirdImpl) == null) {
            return;
        }
        thirdStatisticsImpl.setGameServer(str);
    }

    public static void tdgaSetGender(int i) {
        com.dodjoy.platform.ThirdStatisticsImpl thirdStatisticsImpl;
        if (!need || (thirdStatisticsImpl = ThirdImpl) == null) {
            return;
        }
        thirdStatisticsImpl.setGender(i);
    }

    public static void tdgaSetLevel(int i) {
        if (need) {
            ThirdImpl.setLevel(i);
        }
    }
}
