package com.tencent.tmassistantbase.kapalai;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class MobileModelConfig implements com.tencent.tmassistantbase.kapalai.IMoblieModelConfig {
    private static com.tencent.tmassistantbase.kapalai.MobileModelConfig mInstance;

    /* JADX INFO: renamed from: com.tencent.tmassistantbase.kapalai.MobileModelConfig$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1042a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;
        static final /* synthetic */ int[] d;
        static final /* synthetic */ int[] e;
        static final /* synthetic */ int[] f;
        static final /* synthetic */ int[] g;
        static final /* synthetic */ int[] h;
        static final /* synthetic */ int[] i;
        static final /* synthetic */ int[] j;
        static final /* synthetic */ int[] k;
        static final /* synthetic */ int[] l;
        static final /* synthetic */ int[] m;

        static {
            int[] iArr = new int[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.YULONG.values().length];
            m = iArr;
            try {
                iArr[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.YULONG._8020.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                m[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.YULONG._8022.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                m[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.YULONG._8060.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                m[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.YULONG._5860A.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                m[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.YULONG._COOLPAD_5950.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.GIONEE.values().length];
            l = iArr2;
            try {
                iArr2[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.GIONEE._V182.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                l[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.GIONEE._GN137.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.OPPO.values().length];
            k = iArr3;
            try {
                iArr3[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.OPPO._R821T.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            try {
                k[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.OPPO._R819T.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused9) {
            }
            try {
                k[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.OPPO._R831T.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused10) {
            }
            try {
                k[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.OPPO._R827T.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused11) {
            }
            try {
                k[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.OPPO._R829T.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused12) {
            }
            try {
                k[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.OPPO._R815T.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused13) {
            }
            try {
                k[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.OPPO._R823T.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused14) {
            }
            try {
                k[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.OPPO._U707T.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused15) {
            }
            try {
                k[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.OPPO._R833T.ordinal()] = 9;
            } catch (java.lang.NoSuchFieldError unused16) {
            }
            try {
                k[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.OPPO._R813T.ordinal()] = 10;
            } catch (java.lang.NoSuchFieldError unused17) {
            }
            int[] iArr4 = new int[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.SONY.values().length];
            j = iArr4;
            try {
                iArr4[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.SONY._S39H.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused18) {
            }
            try {
                j[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.SONY._MT15I.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused19) {
            }
            try {
                j[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.SONY._LT26I.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused20) {
            }
            try {
                j[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.SONY._LT26II.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused21) {
            }
            int[] iArr5 = new int[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.BBK.values().length];
            i = iArr5;
            try {
                iArr5[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.BBK._VIVO_Y11.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused22) {
            }
            try {
                i[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.BBK._VIVO_Y17T.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused23) {
            }
            try {
                i[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.BBK._VIVO_Y11I_T.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused24) {
            }
            try {
                i[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.BBK._VIVO_Y15T.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused25) {
            }
            try {
                i[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.BBK._VIVO_S7T.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused26) {
            }
            try {
                i[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.BBK._VIVO_X1ST.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused27) {
            }
            try {
                i[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.BBK._VIVO_Y13.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused28) {
            }
            try {
                i[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.BBK._VIVO_S7.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused29) {
            }
            try {
                i[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.BBK._VIVO_Y19T.ordinal()] = 9;
            } catch (java.lang.NoSuchFieldError unused30) {
            }
            try {
                i[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.BBK._VIVO_S11T.ordinal()] = 10;
            } catch (java.lang.NoSuchFieldError unused31) {
            }
            try {
                i[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.BBK._VIVO_Y3T.ordinal()] = 11;
            } catch (java.lang.NoSuchFieldError unused32) {
            }
            try {
                i[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.BBK._VIVO_Y20T.ordinal()] = 12;
            } catch (java.lang.NoSuchFieldError unused33) {
            }
            try {
                i[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.BBK._VIVO_S9.ordinal()] = 13;
            } catch (java.lang.NoSuchFieldError unused34) {
            }
            int[] iArr6 = new int[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.LENOVO.values().length];
            h = iArr6;
            try {
                iArr6[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.LENOVO._LENOVO_A390T.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused35) {
            }
            try {
                h[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.LENOVO._LENOVO_A630T.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused36) {
            }
            try {
                h[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.LENOVO._LENOVO_A308T.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused37) {
            }
            try {
                h[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.LENOVO._LENOVO_A820T.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused38) {
            }
            try {
                h[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.LENOVO._LENOVO_A850.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused39) {
            }
            try {
                h[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.LENOVO._LENOVO_A670T.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused40) {
            }
            try {
                h[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.LENOVO._LENOVO_A278T.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused41) {
            }
            try {
                h[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.LENOVO._LENOVO_S720.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused42) {
            }
            try {
                h[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.LENOVO._LENOVO_A789.ordinal()] = 9;
            } catch (java.lang.NoSuchFieldError unused43) {
            }
            try {
                h[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.LENOVO._S890.ordinal()] = 10;
            } catch (java.lang.NoSuchFieldError unused44) {
            }
            try {
                h[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.LENOVO._LENOVO_S890.ordinal()] = 11;
            } catch (java.lang.NoSuchFieldError unused45) {
            }
            try {
                h[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.LENOVO._LENOVO_A820.ordinal()] = 12;
            } catch (java.lang.NoSuchFieldError unused46) {
            }
            int[] iArr7 = new int[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.COOLPAD.values().length];
            g = iArr7;
            try {
                iArr7[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.COOLPAD._COOLPAD_8297.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused47) {
            }
            try {
                g[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.COOLPAD._COOLPAD_8079.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused48) {
            }
            try {
                g[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.COOLPAD._COOLPAD_7296.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused49) {
            }
            try {
                g[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.COOLPAD._COOLPAD_7295C.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused50) {
            }
            try {
                g[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.COOLPAD._COOLPAD_7295A.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused51) {
            }
            try {
                g[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.COOLPAD._COOLPAD_8076D.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused52) {
            }
            try {
                g[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.COOLPAD._COOLPAD7295.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused53) {
            }
            try {
                g[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.COOLPAD._8720.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused54) {
            }
            try {
                g[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.COOLPAD._COOLPAD_7270.ordinal()] = 9;
            } catch (java.lang.NoSuchFieldError unused55) {
            }
            int[] iArr8 = new int[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.ALPS.values().length];
            f = iArr8;
            try {
                iArr8[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.ALPS._R811.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused56) {
            }
            try {
                f[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.ALPS._R801.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused57) {
            }
            try {
                f[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.ALPS._U701.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused58) {
            }
            int[] iArr9 = new int[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.XIAOMI.values().length];
            e = iArr9;
            try {
                iArr9[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.XIAOMI._MI_1S.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused59) {
            }
            try {
                e[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.XIAOMI._2013022.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused60) {
            }
            try {
                e[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.XIAOMI._HM_1SC.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused61) {
            }
            try {
                e[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.XIAOMI._HM_NOTE_1TD.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused62) {
            }
            int[] iArr10 = new int[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.ZTE.values().length];
            d = iArr10;
            try {
                iArr10[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.ZTE._ZTE_V889D.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused63) {
            }
            int[] iArr11 = new int[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.HUAWEI.values().length];
            c = iArr11;
            try {
                iArr11[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.HUAWEI._HUAWEI_Y511_T00.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused64) {
            }
            try {
                c[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.HUAWEI._H30_T00.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused65) {
            }
            try {
                c[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.HUAWEI._HUAWEI_G520_0000.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused66) {
            }
            try {
                c[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.HUAWEI._HUAWEI_G610_U00.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused67) {
            }
            try {
                c[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.HUAWEI._HUAWEI_G610_T11.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused68) {
            }
            try {
                c[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.HUAWEI._H30_U10.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused69) {
            }
            try {
                c[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.HUAWEI._HUAWEI_P6_C00.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused70) {
            }
            try {
                c[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.HUAWEI._H30_T10.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused71) {
            }
            try {
                c[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.HUAWEI._HUAWEI_A199.ordinal()] = 9;
            } catch (java.lang.NoSuchFieldError unused72) {
            }
            try {
                c[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.HUAWEI._HUAWEI_Y321_C00.ordinal()] = 10;
            } catch (java.lang.NoSuchFieldError unused73) {
            }
            try {
                c[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.HUAWEI._HUAWEI_C8813D.ordinal()] = 11;
            } catch (java.lang.NoSuchFieldError unused74) {
            }
            try {
                c[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.HUAWEI._HUAWEI_U8825D.ordinal()] = 12;
            } catch (java.lang.NoSuchFieldError unused75) {
            }
            try {
                c[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.HUAWEI._HUAWEI_Y325_T00.ordinal()] = 13;
            } catch (java.lang.NoSuchFieldError unused76) {
            }
            try {
                c[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.HUAWEI._HUAWEI_G610_C00.ordinal()] = 14;
            } catch (java.lang.NoSuchFieldError unused77) {
            }
            try {
                c[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.HUAWEI._HUAWEI_Y320_T00.ordinal()] = 15;
            } catch (java.lang.NoSuchFieldError unused78) {
            }
            try {
                c[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.HUAWEI._HUAWEI_G750_T00.ordinal()] = 16;
            } catch (java.lang.NoSuchFieldError unused79) {
            }
            int[] iArr12 = new int[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.HTC.values().length];
            b = iArr12;
            try {
                iArr12[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.HTC._HTC_T328T.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused80) {
            }
            try {
                b[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.HTC._HTC_T528T.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused81) {
            }
            try {
                b[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.HTC._HTC_T528W.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused82) {
            }
            try {
                b[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.HTC._HTC_INCREDIBLE_S.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused83) {
            }
            try {
                b[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.HTC._HTC_EVO_3D_X515m.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused84) {
            }
            try {
                b[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.HTC._HTC_T328W.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused85) {
            }
            try {
                b[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.HTC._HTC_D816W.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused86) {
            }
            try {
                b[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.HTC._HTC_T328D.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused87) {
            }
            try {
                b[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.HTC._HTC_T528D.ordinal()] = 9;
            } catch (java.lang.NoSuchFieldError unused88) {
            }
            int[] iArr13 = new int[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.SAMSUNG.values().length];
            f1042a = iArr13;
            try {
                iArr13[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.SAMSUNG._GT_I8552.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused89) {
            }
            try {
                f1042a[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.SAMSUNG._GT_S7572.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused90) {
            }
            try {
                f1042a[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.SAMSUNG._GT_I8262D.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused91) {
            }
            try {
                f1042a[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.SAMSUNG._GT_N7102.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused92) {
            }
            try {
                f1042a[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.SAMSUNG._SM_N9009.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused93) {
            }
            try {
                f1042a[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.SAMSUNG._GT_I9152.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused94) {
            }
            try {
                f1042a[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.SAMSUNG._GT_S7562I.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused95) {
            }
            try {
                f1042a[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.SAMSUNG._SCH_I959.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused96) {
            }
            try {
                f1042a[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.SAMSUNG._GT_I8558.ordinal()] = 9;
            } catch (java.lang.NoSuchFieldError unused97) {
            }
            try {
                f1042a[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.SAMSUNG._SM_N9002.ordinal()] = 10;
            } catch (java.lang.NoSuchFieldError unused98) {
            }
            try {
                f1042a[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.SAMSUNG._SCH_I869.ordinal()] = 11;
            } catch (java.lang.NoSuchFieldError unused99) {
            }
            try {
                f1042a[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.SAMSUNG._SCH_N719.ordinal()] = 12;
            } catch (java.lang.NoSuchFieldError unused100) {
            }
            try {
                f1042a[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.SAMSUNG._GT_I9502.ordinal()] = 13;
            } catch (java.lang.NoSuchFieldError unused101) {
            }
            try {
                f1042a[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.SAMSUNG._GT_I9082.ordinal()] = 14;
            } catch (java.lang.NoSuchFieldError unused102) {
            }
            try {
                f1042a[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.SAMSUNG._SCH_I829.ordinal()] = 15;
            } catch (java.lang.NoSuchFieldError unused103) {
            }
            try {
                f1042a[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.SAMSUNG._GT_I9158.ordinal()] = 16;
            } catch (java.lang.NoSuchFieldError unused104) {
            }
            try {
                f1042a[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.SAMSUNG._SCH_I879.ordinal()] = 17;
            } catch (java.lang.NoSuchFieldError unused105) {
            }
            try {
                f1042a[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.SAMSUNG._SM_G3812.ordinal()] = 18;
            } catch (java.lang.NoSuchFieldError unused106) {
            }
            try {
                f1042a[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.SAMSUNG._SM_G7108.ordinal()] = 19;
            } catch (java.lang.NoSuchFieldError unused107) {
            }
            try {
                f1042a[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.SAMSUNG._SM_G3502U.ordinal()] = 20;
            } catch (java.lang.NoSuchFieldError unused108) {
            }
            try {
                f1042a[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.SAMSUNG._SM_G3502.ordinal()] = 21;
            } catch (java.lang.NoSuchFieldError unused109) {
            }
            try {
                f1042a[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.SAMSUNG._GT_S6352.ordinal()] = 22;
            } catch (java.lang.NoSuchFieldError unused110) {
            }
            try {
                f1042a[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.SAMSUNG._SCH_W2013.ordinal()] = 23;
            } catch (java.lang.NoSuchFieldError unused111) {
            }
            try {
                f1042a[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.SAMSUNG._SM_G3819D.ordinal()] = 24;
            } catch (java.lang.NoSuchFieldError unused112) {
            }
            try {
                f1042a[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.SAMSUNG._SCH_I939.ordinal()] = 25;
            } catch (java.lang.NoSuchFieldError unused113) {
            }
            try {
                f1042a[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.SAMSUNG._SM_G7106.ordinal()] = 26;
            } catch (java.lang.NoSuchFieldError unused114) {
            }
            try {
                f1042a[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.SAMSUNG._GT_I9082I.ordinal()] = 27;
            } catch (java.lang.NoSuchFieldError unused115) {
            }
        }
    }

    private MobileModelConfig() {
    }

    public static com.tencent.tmassistantbase.kapalai.MobileModelConfig getInstance() {
        if (mInstance == null) {
            synchronized (com.tencent.tmassistantbase.kapalai.MobileModelConfig.class) {
                if (mInstance == null) {
                    mInstance = new com.tencent.tmassistantbase.kapalai.MobileModelConfig();
                }
            }
        }
        return mInstance;
    }

    private java.lang.String transformToUnderLine(java.lang.String str) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("_");
        stringBuffer.append(str.replaceAll("[-\\s]", "_").toUpperCase());
        return stringBuffer.toString();
    }

    public void updateAlpsConfig(java.lang.String str) {
        try {
            int i = com.tencent.tmassistantbase.kapalai.MobileModelConfig.AnonymousClass1.f[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.ALPS.valueOf(transformToUnderLine(str)).ordinal()];
            if (i == 1) {
                com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                int[] iArr = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                iArr[0] = 0;
                iArr[1] = 1;
                return;
            }
            if (i == 2) {
                com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                int[] iArr2 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                iArr2[0] = 0;
                iArr2[1] = 1;
                return;
            }
            if (i != 3) {
                return;
            }
            com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
            int[] iArr3 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
            iArr3[0] = 0;
            iArr3[1] = 1;
        } catch (java.lang.Exception unused) {
        }
    }

    public void updateBBKConfig(java.lang.String str) {
        try {
            switch (com.tencent.tmassistantbase.kapalai.MobileModelConfig.AnonymousClass1.i[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.BBK.valueOf(transformToUnderLine(str)).ordinal()]) {
                case 1:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr[0] = 0;
                    iArr[1] = 1;
                    break;
                case 2:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr2 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr2[0] = 0;
                    iArr2[1] = 1;
                    break;
                case 3:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr3 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr3[0] = 0;
                    iArr3[1] = 1;
                    break;
                case 4:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr4 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr4[0] = 0;
                    iArr4[1] = 1;
                    break;
                case 5:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDeleteContactGroup = false;
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr5 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr5[0] = 0;
                    iArr5[1] = 1;
                    break;
                case 6:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDeleteContactGroup = false;
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr6 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr6[0] = 0;
                    iArr6[1] = 1;
                    break;
                case 7:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr7 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr7[0] = 0;
                    iArr7[1] = 1;
                    break;
                case 8:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr8 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr8[0] = 0;
                    iArr8[1] = 1;
                    break;
                case 9:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr9 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr9[0] = 0;
                    iArr9[1] = 1;
                    break;
                case 10:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDeleteContactGroup = false;
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr10 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr10[0] = 0;
                    iArr10[1] = 1;
                    break;
                case 11:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDeleteContactGroup = false;
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr11 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr11[0] = 0;
                    iArr11[1] = 1;
                    break;
                case 12:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr12 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr12[0] = 0;
                    iArr12[1] = 1;
                    break;
                case 13:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr13 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr13[0] = 0;
                    iArr13[1] = 1;
                    break;
            }
        } catch (java.lang.Exception unused) {
        }
    }

    public void updateCoolpadConfig(java.lang.String str) {
        try {
            switch (com.tencent.tmassistantbase.kapalai.MobileModelConfig.AnonymousClass1.g[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.COOLPAD.valueOf(transformToUnderLine(str)).ordinal()]) {
                case 1:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr[0] = 0;
                    iArr[1] = 1;
                    break;
                case 2:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr2 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr2[0] = 2;
                    iArr2[1] = 2;
                    break;
                case 3:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr3 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr3[0] = 0;
                    iArr3[1] = 1;
                    break;
                case 4:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr4 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr4[0] = 0;
                    iArr4[1] = 1;
                    break;
                case 5:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr5 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr5[0] = 0;
                    iArr5[1] = 1;
                    break;
                case 6:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr6 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr6[0] = 2;
                    iArr6[1] = 2;
                    break;
                case 7:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr7 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr7[0] = 0;
                    iArr7[1] = 1;
                    break;
                case 8:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr8 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr8[0] = 0;
                    iArr8[1] = 1;
                    break;
                case 9:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr9 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr9[0] = 0;
                    iArr9[1] = 6;
                    break;
            }
        } catch (java.lang.Exception unused) {
        }
    }

    public void updateGioneeConfig(java.lang.String str) {
        try {
            int i = com.tencent.tmassistantbase.kapalai.MobileModelConfig.AnonymousClass1.l[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.GIONEE.valueOf(transformToUnderLine(str)).ordinal()];
            if (i == 1) {
                com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                int[] iArr = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                iArr[0] = 0;
                iArr[1] = 1;
                return;
            }
            if (i != 2) {
                return;
            }
            com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
            int[] iArr2 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
            iArr2[0] = 0;
            iArr2[1] = 1;
        } catch (java.lang.Exception unused) {
        }
    }

    public void updateHisenseConfig(java.lang.String str) {
        try {
            com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.HISENSE.valueOf(transformToUnderLine(str));
        } catch (java.lang.Exception unused) {
        }
    }

    public void updateHtcConfig(java.lang.String str) {
        try {
            switch (com.tencent.tmassistantbase.kapalai.MobileModelConfig.AnonymousClass1.b[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.HTC.valueOf(transformToUnderLine(str)).ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportInsertContactGroup = false;
                    break;
                case 6:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportInsertContactGroup = false;
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMEI = false;
                    int[] iArr = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr[0] = 0;
                    iArr[1] = 7;
                    int[] iArr2 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMEISolutionNum;
                    iArr2[0] = 7;
                    iArr2[1] = 7;
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.IMEIPos[1] = 0;
                    break;
                case 7:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMEI = false;
                    int[] iArr3 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMEISolutionNum;
                    iArr3[0] = 7;
                    iArr3[1] = 7;
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.IMEIPos[1] = 0;
                    break;
                case 8:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportInsertContactGroup = false;
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMEI = false;
                    int[] iArr4 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMEISolutionNum;
                    iArr4[0] = 8;
                    iArr4[1] = 7;
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.IMEIPos[1] = 0;
                    break;
                case 9:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMEI = false;
                    int[] iArr5 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMEISolutionNum;
                    iArr5[0] = 8;
                    iArr5[1] = 7;
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.IMEIPos[1] = 0;
                    break;
            }
        } catch (java.lang.Exception unused) {
        }
    }

    public void updateHuaWeiConfig(java.lang.String str) {
        try {
            switch (com.tencent.tmassistantbase.kapalai.MobileModelConfig.AnonymousClass1.c[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.HUAWEI.valueOf(transformToUnderLine(str)).ordinal()]) {
                case 1:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr[0] = 0;
                    iArr[1] = 0;
                    break;
                case 2:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr2 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr2[0] = 0;
                    iArr2[1] = 3;
                    break;
                case 3:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr3 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr3[0] = 0;
                    iArr3[1] = 3;
                    break;
                case 4:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr4 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr4[0] = 0;
                    iArr4[1] = 3;
                    break;
                case 5:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr5 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr5[0] = 0;
                    iArr5[1] = 1;
                    break;
                case 6:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr6 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr6[0] = 0;
                    iArr6[1] = 1;
                    break;
                case 7:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr7 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr7[0] = 0;
                    iArr7[1] = 3;
                    break;
                case 8:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr8 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr8[0] = 0;
                    iArr8[1] = 1;
                    break;
                case 9:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr9 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr9[0] = 0;
                    iArr9[1] = 5;
                    break;
                case 10:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr10 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr10[0] = 0;
                    iArr10[1] = 5;
                    break;
                case 11:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr11 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr11[0] = 0;
                    iArr11[1] = 3;
                    break;
                case 12:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr12 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr12[0] = 0;
                    iArr12[1] = 5;
                    break;
                case 13:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr13 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr13[0] = 0;
                    iArr13[1] = 1;
                    break;
                case 14:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr14 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr14[0] = 0;
                    iArr14[1] = 3;
                    break;
                case 15:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr15 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr15[0] = 0;
                    iArr15[1] = 5;
                    break;
                case 16:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr16 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr16[0] = 0;
                    iArr16[1] = 1;
                    break;
            }
        } catch (java.lang.Exception unused) {
        }
    }

    public void updateK_TouchConfig(java.lang.String str) {
        try {
            com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.K_TOUCH.valueOf(transformToUnderLine(str));
        } catch (java.lang.Exception unused) {
        }
    }

    public void updateLenovoConfig(java.lang.String str) {
        try {
            switch (com.tencent.tmassistantbase.kapalai.MobileModelConfig.AnonymousClass1.h[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.LENOVO.valueOf(transformToUnderLine(str)).ordinal()]) {
                case 1:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr[0] = 2;
                    iArr[1] = 2;
                    break;
                case 2:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr2 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr2[0] = 0;
                    iArr2[1] = 1;
                    break;
                case 3:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr3 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr3[0] = 0;
                    iArr3[1] = 1;
                    break;
                case 4:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr4 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr4[0] = 0;
                    iArr4[1] = 1;
                    break;
                case 5:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr5 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr5[0] = 0;
                    iArr5[1] = 1;
                    break;
                case 6:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr6 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr6[0] = 0;
                    iArr6[1] = 1;
                    break;
                case 7:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr7 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr7[0] = 2;
                    iArr7[1] = 2;
                    break;
                case 8:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr8 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr8[0] = 0;
                    iArr8[1] = 1;
                    break;
                case 9:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr9 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr9[0] = 0;
                    iArr9[1] = 1;
                    break;
                case 10:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr10 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr10[0] = 0;
                    iArr10[1] = 1;
                    break;
                case 11:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr11 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr11[0] = 0;
                    iArr11[1] = 1;
                    break;
                case 12:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr12 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr12[0] = 0;
                    iArr12[1] = 1;
                    break;
            }
        } catch (java.lang.Exception unused) {
        }
    }

    public void updateMeizuConfig(java.lang.String str) {
        try {
            com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.MEIZU.valueOf(transformToUnderLine(str));
        } catch (java.lang.Exception unused) {
        }
    }

    public void updateMotorolaConfig(java.lang.String str) {
        try {
            com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.MOTOROLA.valueOf(transformToUnderLine(str));
        } catch (java.lang.Exception unused) {
        }
    }

    public void updateOppoConfig(java.lang.String str) {
        try {
            switch (com.tencent.tmassistantbase.kapalai.MobileModelConfig.AnonymousClass1.k[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.OPPO.valueOf(transformToUnderLine(str)).ordinal()]) {
                case 1:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr[0] = 0;
                    iArr[1] = 1;
                    break;
                case 2:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr2 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr2[0] = 0;
                    iArr2[1] = 1;
                    break;
                case 3:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr3 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr3[0] = 0;
                    iArr3[1] = 1;
                    break;
                case 4:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr4 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr4[0] = 0;
                    iArr4[1] = 0;
                    break;
                case 5:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr5 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr5[0] = 0;
                    iArr5[1] = 0;
                    break;
                case 6:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr6 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr6[0] = 0;
                    iArr6[1] = 1;
                    break;
                case 7:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr7 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr7[0] = 0;
                    iArr7[1] = 1;
                    break;
                case 8:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr8 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr8[0] = 0;
                    iArr8[1] = 1;
                    break;
                case 9:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr9 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr9[0] = 0;
                    iArr9[1] = 0;
                    break;
                case 10:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr10 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr10[0] = 0;
                    iArr10[1] = 1;
                    break;
            }
        } catch (java.lang.Exception unused) {
        }
    }

    public void updateOtherPhoneConfig(java.lang.String str) {
        try {
            com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.OTHERPHONE.valueOf(transformToUnderLine(str));
        } catch (java.lang.Exception unused) {
        }
    }

    public void updateSamSungConfig(java.lang.String str) {
        try {
            switch (com.tencent.tmassistantbase.kapalai.MobileModelConfig.AnonymousClass1.f1042a[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.SAMSUNG.valueOf(transformToUnderLine(str)).ordinal()]) {
                case 1:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr[0] = 0;
                    iArr[1] = 3;
                    break;
                case 2:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr2 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr2[0] = 0;
                    iArr2[1] = 3;
                    break;
                case 3:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr3 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr3[0] = 0;
                    iArr3[1] = 3;
                    break;
                case 4:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMEI = false;
                    int[] iArr4 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr4[0] = 0;
                    iArr4[1] = 0;
                    int[] iArr5 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMEISolutionNum;
                    iArr5[0] = 0;
                    iArr5[1] = 0;
                    break;
                case 5:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMEI = false;
                    int[] iArr6 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr6[0] = 0;
                    iArr6[1] = 0;
                    int[] iArr7 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMEISolutionNum;
                    iArr7[0] = 8;
                    iArr7[1] = 0;
                    break;
                case 6:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMEI = false;
                    int[] iArr8 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr8[0] = 0;
                    iArr8[1] = 0;
                    int[] iArr9 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMEISolutionNum;
                    iArr9[0] = 8;
                    iArr9[1] = 0;
                    break;
                case 7:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr10 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr10[0] = 0;
                    iArr10[1] = 5;
                    break;
                case 8:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMEI = false;
                    int[] iArr11 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr11[0] = 0;
                    iArr11[1] = 0;
                    int[] iArr12 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMEISolutionNum;
                    iArr12[0] = 8;
                    iArr12[1] = 0;
                    break;
                case 9:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr13 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr13[0] = 0;
                    iArr13[1] = 0;
                    break;
                case 10:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr14 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr14[0] = 0;
                    iArr14[1] = 0;
                    break;
                case 11:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMEI = false;
                    int[] iArr15 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr15[0] = 0;
                    iArr15[1] = 0;
                    int[] iArr16 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMEISolutionNum;
                    iArr16[0] = 8;
                    iArr16[1] = 0;
                    break;
                case 12:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMEI = false;
                    int[] iArr17 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr17[0] = 0;
                    iArr17[1] = 0;
                    int[] iArr18 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMEISolutionNum;
                    iArr18[0] = 8;
                    iArr18[1] = 0;
                    break;
                case 13:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMEI = false;
                    int[] iArr19 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr19[0] = 0;
                    iArr19[1] = 0;
                    int[] iArr20 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMEISolutionNum;
                    iArr20[0] = 8;
                    iArr20[1] = 0;
                    break;
                case 14:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMEI = false;
                    int[] iArr21 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr21[0] = 0;
                    iArr21[1] = 0;
                    int[] iArr22 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMEISolutionNum;
                    iArr22[0] = 8;
                    iArr22[1] = 0;
                    break;
                case 15:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMEI = false;
                    int[] iArr23 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr23[0] = 0;
                    iArr23[1] = 0;
                    int[] iArr24 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMEISolutionNum;
                    iArr24[0] = 8;
                    iArr24[1] = 0;
                    break;
                case 16:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr25 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr25[0] = 0;
                    iArr25[1] = 0;
                    break;
                case 17:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMEI = false;
                    int[] iArr26 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr26[0] = 0;
                    iArr26[1] = 0;
                    int[] iArr27 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMEISolutionNum;
                    iArr27[0] = 8;
                    iArr27[1] = 0;
                    break;
                case 18:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr28 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr28[0] = 0;
                    iArr28[1] = 0;
                    break;
                case 19:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr29 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr29[0] = 0;
                    iArr29[1] = 8;
                    break;
                case 20:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr30 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr30[0] = 0;
                    iArr30[1] = 0;
                    break;
                case 21:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr31 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr31[0] = 0;
                    iArr31[1] = 0;
                    break;
                case 22:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMEI = false;
                    int[] iArr32 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr32[0] = 0;
                    iArr32[1] = 0;
                    int[] iArr33 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMEISolutionNum;
                    iArr33[0] = 8;
                    iArr33[1] = 0;
                    break;
                case 23:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMEI = false;
                    int[] iArr34 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr34[0] = 0;
                    iArr34[1] = 0;
                    int[] iArr35 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMEISolutionNum;
                    iArr35[0] = 8;
                    iArr35[1] = 0;
                    break;
                case 24:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr36 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr36[0] = 0;
                    iArr36[1] = 3;
                    break;
                case 25:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMEI = false;
                    int[] iArr37 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMEISolutionNum;
                    iArr37[0] = 8;
                    iArr37[1] = 0;
                    break;
                case 26:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMEI = false;
                    int[] iArr38 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMEISolutionNum;
                    iArr38[0] = 8;
                    iArr38[1] = 0;
                    break;
                case 27:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMEI = false;
                    int[] iArr39 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMEISolutionNum;
                    iArr39[0] = 8;
                    iArr39[1] = 0;
                    break;
            }
        } catch (java.lang.Exception unused) {
        }
    }

    public void updateSonyConfig(java.lang.String str) {
        try {
            switch (com.tencent.tmassistantbase.kapalai.MobileModelConfig.AnonymousClass1.j[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.SONY.valueOf(transformToUnderLine(str)).ordinal()]) {
                case 1:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr[0] = 0;
                    iArr[1] = 1;
                    break;
                case 2:
                case 3:
                case 4:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportInsertContactGroup = false;
                    break;
            }
        } catch (java.lang.Exception unused) {
        }
    }

    public void updateXiaomiConfig(java.lang.String str) {
        try {
            switch (com.tencent.tmassistantbase.kapalai.MobileModelConfig.AnonymousClass1.e[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.XIAOMI.valueOf(transformToUnderLine(str)).ordinal()]) {
                case 1:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isHasShortcutUri = false;
                    break;
                case 2:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr[0] = 0;
                    iArr[1] = 1;
                    break;
                case 3:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr2 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr2[0] = 3;
                    iArr2[1] = 3;
                    break;
                case 4:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr3 = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr3[0] = 0;
                    iArr3[1] = 1;
                    break;
            }
        } catch (java.lang.Exception unused) {
        }
    }

    public void updateYulongConfig(java.lang.String str) {
        try {
            switch (com.tencent.tmassistantbase.kapalai.MobileModelConfig.AnonymousClass1.m[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.YULONG.valueOf(transformToUnderLine(str)).ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDeleteContactGroup = false;
                    break;
                case 5:
                    com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportDualSimIMSI = false;
                    int[] iArr = com.tencent.tmassistantbase.kapalai.MobileIssueSettings.dualSimIMSISolutionNum;
                    iArr[0] = 0;
                    iArr[1] = 6;
                    break;
            }
        } catch (java.lang.Exception unused) {
        }
    }

    public void updateZteConfig(java.lang.String str) {
        try {
            if (com.tencent.tmassistantbase.kapalai.MobileModelConfig.AnonymousClass1.d[com.tencent.tmassistantbase.kapalai.IMoblieModelConfig.ZTE.valueOf(transformToUnderLine(str)).ordinal()] != 1) {
                return;
            }
            com.tencent.tmassistantbase.kapalai.MobileIssueSettings.isSupportInsertContactGroup = false;
        } catch (java.lang.Exception unused) {
        }
    }
}
