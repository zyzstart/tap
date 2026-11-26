package com.tencent.tgpa.simple;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class TGPAManager {
    private static com.tencent.tgpa.simple.Callback i;

    public static void enableDebugMode() {
        qfc.u.j();
    }

    public static java.lang.String getOAID() {
        if (qfc.v.U != null) {
            return qfc.o.h();
        }
        qfc.ac.b("TGPA", "context is null, you should init first.");
        return "-1";
    }

    public static java.lang.String getXID() {
        if (qfc.v.U != null) {
            return com.tencent.tgpa.simple.gradish.GradishWrapper.getCommonUniqueID2WithoutFlag();
        }
        qfc.ac.b("TGPA", "context is null, you should init first.");
        return "-1";
    }

    /* JADX WARN: Code duplicated, block: B:58:0x0128  */
    public static void init(android.content.Context context) {
        int i2;
        java.lang.String oaid;
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        java.lang.String str5;
        java.lang.String str6;
        java.lang.String str7;
        java.lang.String str8;
        java.lang.String str9;
        java.lang.String str10;
        java.lang.String str11;
        java.lang.String str12;
        android.os.Bundle bundleCall;
        if (qfc.u.o) {
            android.util.Log.e("TGPA", "Init: sdk has inited.");
            return;
        }
        if (context == null) {
            android.util.Log.e("TGPA", "Init: context is null.");
            return;
        }
        qfc.v.U = context.getApplicationContext();
        java.lang.String strD = qfc.v.d();
        if (qfc.ac.a(strD + "/" + qfc.e.b)) {
            qfc.ac.j("found log file. print log to vmpdebug.log.");
        }
        if (qfc.aa.g(strD + "/" + qfc.e.v)) {
            qfc.ac.j("found debug file. use debug mode.");
            qfc.u.j();
        }
        if (qfc.d.b().n.p) {
            qfc.ac.j("cloud config is debug mode. ");
            qfc.u.j();
        }
        qfc.w.a();
        qfc.c.a();
        if (qfc.d.b().n.t) {
            qfc.o oVar = new qfc.o(i);
            qfc.ac.a("TGPA_MID", "start to get vendor oaid.");
            if (qfc.d.b().n.t) {
                android.content.Context context2 = qfc.v.U;
                if (context2 == null) {
                    android.util.Log.e("TGPA_MID", "OAID get failed, context is null.");
                    oVar.a(-1);
                } else {
                    qfc.o.AnonymousClass1 anonymousClass1 = new qfc.n() { // from class: qfc.o.1
                        public AnonymousClass1() {
                        }

                        @Override // qfc.n
                        public final void f(java.lang.String str13) {
                            qfc.ac.a("TGPA_MID", "vender oaid get success. oaid: " + java.lang.String.valueOf(str13));
                            java.lang.String unused = qfc.o.f1702a = str13;
                            if (qfc.o.this.ae == null || qfc.o.f1702a == null) {
                                return;
                            }
                            qfc.o.this.ae.getInfo("OAID", qfc.o.f1702a);
                        }
                    };
                    try {
                        switch (android.os.Build.MANUFACTURER.toLowerCase()) {
                            case "xiaomi":
                                oaid = com.tencent.tgpa.simple.gradish.GradishWrapper.getOAID(1);
                                qfc.o.f1702a = oaid;
                                anonymousClass1.f(oaid);
                                break;
                            case "vivo":
                                oaid = com.tencent.tgpa.simple.gradish.GradishWrapper.getOAID(2);
                                qfc.o.f1702a = oaid;
                                anonymousClass1.f(oaid);
                                break;
                            case "meizu":
                                oaid = com.tencent.tgpa.simple.gradish.GradishWrapper.getOAID(3);
                                qfc.o.f1702a = oaid;
                                anonymousClass1.f(oaid);
                                break;
                            case "asus":
                                qfc.h hVar = new qfc.h(context2, anonymousClass1);
                                try {
                                    android.content.Intent intent = new android.content.Intent("com.asus.msa.action.ACCESS_DID");
                                    android.content.ComponentName componentName = new android.content.ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService");
                                    android.content.Intent intent2 = new android.content.Intent(intent);
                                    intent2.setComponent(componentName);
                                    boolean zBindService = hVar.U.bindService(intent2, hVar.X, 1);
                                    hVar.q = zBindService;
                                    if (zBindService) {
                                        str = "TGPA_MID";
                                        str2 = "bind ASUS service success!";
                                    } else {
                                        str = "TGPA_MID";
                                        str2 = "bind ASUS service failed!";
                                    }
                                    qfc.ac.a(str, str2);
                                    break;
                                } catch (java.lang.Exception e) {
                                    e = e;
                                    qfc.ac.a("TGPA_MID", "bind huawei service exception. ");
                                    e.printStackTrace();
                                    break;
                                }
                                break;
                            case "huawei":
                                qfc.j jVar = new qfc.j(context2, anonymousClass1);
                                try {
                                    jVar.U.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
                                    android.content.Intent intent3 = new android.content.Intent("com.uodis.opendevice.OPENIDS_SERVICE");
                                    intent3.setPackage("com.huawei.hwid");
                                    boolean zBindService2 = jVar.U.bindService(intent3, jVar.X, 1);
                                    jVar.q = zBindService2;
                                    if (zBindService2) {
                                        str3 = "TGPA_MID";
                                        str4 = "bind huawei service success!";
                                    } else {
                                        str3 = "TGPA_MID";
                                        str4 = "bind huawei service failed!";
                                    }
                                    qfc.ac.a(str3, str4);
                                    break;
                                } catch (java.lang.Exception e2) {
                                    e = e2;
                                    qfc.ac.a("TGPA_MID", "bind huawei service exception. ");
                                    e.printStackTrace();
                                    break;
                                }
                                break;
                            case "lenovo":
                                qfc.l lVar = new qfc.l(context2, anonymousClass1);
                                try {
                                    android.content.Intent intent4 = new android.content.Intent();
                                    intent4.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
                                    boolean zBindService3 = lVar.U.bindService(intent4, lVar.X, 1);
                                    lVar.q = zBindService3;
                                    if (zBindService3) {
                                        str5 = "TGPA_MID";
                                        str6 = "bind Lenovo service success!";
                                    } else {
                                        str5 = "TGPA_MID";
                                        str6 = "bind Lenovo service failed!";
                                    }
                                    qfc.ac.a(str5, str6);
                                    break;
                                } catch (java.lang.Exception e3) {
                                    e3.printStackTrace();
                                    qfc.ac.a("TGPA_MID", "bind Lenovo service exception. ");
                                    break;
                                }
                                break;
                            case "oppo":
                                qfc.q qVar = new qfc.q(context2, anonymousClass1);
                                try {
                                    android.content.Intent intent5 = new android.content.Intent();
                                    intent5.setComponent(new android.content.ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
                                    intent5.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
                                    boolean zBindService4 = qVar.U.bindService(intent5, qVar.X, 1);
                                    qVar.r = zBindService4;
                                    if (zBindService4) {
                                        str7 = "TGPA_MID";
                                        str8 = "bind OPPO service success!";
                                    } else {
                                        str7 = "TGPA_MID";
                                        str8 = "bind OPPO service failed!";
                                    }
                                    qfc.ac.a(str7, str8);
                                    break;
                                } catch (java.lang.Exception e4) {
                                    e = e4;
                                    qfc.ac.a("TGPA_MID", "bind OPPO service exception. ");
                                    e.printStackTrace();
                                    break;
                                }
                                break;
                            case "samsung":
                                qfc.s sVar = new qfc.s(context2, anonymousClass1);
                                try {
                                    sVar.U.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0);
                                    android.content.Intent intent6 = new android.content.Intent();
                                    intent6.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
                                    boolean zBindService5 = sVar.U.bindService(intent6, sVar.X, 1);
                                    sVar.q = zBindService5;
                                    if (zBindService5) {
                                        str9 = "TGPA_MID";
                                        str10 = "bind Sumsung service success.";
                                    } else {
                                        str9 = "TGPA_MID";
                                        str10 = "bind Sumsung service failed.";
                                    }
                                    android.util.Log.d(str9, str10);
                                    break;
                                } catch (java.lang.Exception e5) {
                                    e = e5;
                                    qfc.ac.a("TGPA_MID", "bind Sumsung service exception. ");
                                    e.printStackTrace();
                                    break;
                                }
                                break;
                            case "nubia":
                                qfc.p pVar = new qfc.p(context2, anonymousClass1);
                                java.lang.String string = null;
                                try {
                                    if (android.os.Build.VERSION.SDK_INT >= 17) {
                                        android.content.ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = pVar.ah.getContentResolver().acquireUnstableContentProviderClient(pVar.ag);
                                        android.os.Bundle bundleCall2 = contentProviderClientAcquireUnstableContentProviderClient.call("getOAID", null, null);
                                        if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                                            if (android.os.Build.VERSION.SDK_INT >= 24) {
                                                contentProviderClientAcquireUnstableContentProviderClient.close();
                                            } else {
                                                contentProviderClientAcquireUnstableContentProviderClient.release();
                                            }
                                        }
                                        bundleCall = bundleCall2;
                                    } else {
                                        bundleCall = android.os.Build.VERSION.SDK_INT >= 11 ? pVar.ah.getContentResolver().call(pVar.ag, "getOAID", (java.lang.String) null, (android.os.Bundle) null) : null;
                                    }
                                    if (bundleCall != null && bundleCall.getInt("code", -1) == 0) {
                                        string = bundleCall.getString("id");
                                    }
                                    break;
                                } catch (java.lang.Exception e6) {
                                    android.util.Log.d("TGPA_MID", "MSA Nubia get oaid exception.");
                                    e6.printStackTrace();
                                }
                                if (pVar.ai != null) {
                                    pVar.ai.f(string);
                                    break;
                                } else {
                                    str11 = "TGPA_MID";
                                    str12 = "MSA oaid callback is null.";
                                    android.util.Log.d(str11, str12);
                                    break;
                                }
                                break;
                            default:
                                oVar.a(0);
                                str11 = "TGPA_MID";
                                str12 = "OAID get failed, this manufacture doesn't support msa id. ";
                                android.util.Log.d(str11, str12);
                                break;
                        }
                    } catch (java.lang.Exception e7) {
                        android.util.Log.e("TGPA_MID", "OAID get exception, ple call sdk provider.");
                        e7.printStackTrace();
                        i2 = -3;
                        oVar.a(i2);
                    }
                }
            } else {
                i2 = -2;
            }
            oVar.a(i2);
        }
        java.util.HashMap map = new java.util.HashMap();
        qfc.ad.a(map);
        map.put("flag1", java.lang.String.valueOf(com.tencent.tgpa.simple.gradish.GradishWrapper.getFlag1()));
        map.put("flag2", java.lang.String.valueOf(com.tencent.tgpa.simple.gradish.GradishWrapper.getFlag2()));
        map.put("flagL2", java.lang.String.valueOf(com.tencent.tgpa.simple.gradish.GradishWrapper.getFlagL2()));
        qfc.w.a(qfc.g.VMP_INIT, qfc.w.b.ReportNow, map);
        qfc.u.o = true;
    }

    public static void init(android.content.Context context, com.tencent.tgpa.simple.Callback callback) {
        i = callback;
        init(context);
    }

    public static void init(android.content.Context context, boolean z, boolean z2) {
        if (z) {
            enableDebugMode();
        }
        if (z2) {
            setLogAble(true);
        }
        init(context);
    }

    public static void reportUserInfo(java.util.HashMap map) {
        if (qfc.v.U == null) {
            qfc.ac.b("TGPA", "context is null, you should init first.");
            return;
        }
        if (map == null || map.size() <= 0) {
            qfc.ac.b("TGPA", "you should send some user data.");
            return;
        }
        if (!qfc.d.b().n.s) {
            qfc.ac.b("TGPA_XID", "xid func is not open in cloud.");
            return;
        }
        java.util.HashMap map2 = new java.util.HashMap();
        for (java.util.Map.Entry entry : map.entrySet()) {
            map2.put(java.lang.String.valueOf(entry.getKey()), java.lang.String.valueOf(entry.getValue()));
        }
        qfc.ad.a(map2);
        map2.put("flag1", java.lang.String.valueOf(com.tencent.tgpa.simple.gradish.GradishWrapper.getFlag1()));
        map2.put("flag2", java.lang.String.valueOf(com.tencent.tgpa.simple.gradish.GradishWrapper.getFlag2()));
        map2.put("flagL2", java.lang.String.valueOf(com.tencent.tgpa.simple.gradish.GradishWrapper.getFlagL2()));
        map2.put("debug_id", java.lang.String.valueOf(com.tencent.tgpa.simple.gradish.GradishWrapper.getDebugID()));
        qfc.w.a(qfc.g.VMP_REPORT_UNIQUE_ID, qfc.w.b.ReportNow, map2);
    }

    public static void setLogAble(boolean z) {
        if (z) {
            qfc.ac.a();
        }
    }
}
