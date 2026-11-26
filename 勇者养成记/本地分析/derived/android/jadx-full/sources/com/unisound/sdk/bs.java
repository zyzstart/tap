package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class bs {
    private java.lang.String g;
    private java.lang.String h;
    private java.lang.String i;
    private boolean j;
    private java.lang.String k;
    private java.lang.String l;
    private java.lang.String m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1543a = 0;
    private int b = 1;
    private boolean c = false;
    private boolean d = true;
    private boolean e = false;
    private int f = 500;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private boolean q = false;

    protected bs() {
    }

    protected bs(java.lang.String str) {
        com.unisound.common.v.a(str, l());
    }

    public java.lang.String a() {
        return this.l;
    }

    public void a(int i) {
        this.f = i;
    }

    public void a(java.lang.String str) {
        this.l = str;
    }

    public void a(boolean z) {
        this.j = z;
    }

    public java.lang.String b() {
        return this.k;
    }

    protected void b(int i) {
        this.f1543a = i;
    }

    public void b(java.lang.String str) {
        this.k = str;
    }

    public void b(boolean z) {
        this.e = z;
    }

    public void c(int i) {
        this.b = i;
    }

    public void c(java.lang.String str) {
        this.h = str;
    }

    public void c(boolean z) {
        this.c = z;
    }

    public boolean c() {
        return this.j;
    }

    public java.lang.String d() {
        return this.h;
    }

    public void d(java.lang.String str) {
        this.g = str;
    }

    public void d(boolean z) {
        this.d = z;
    }

    public java.lang.String e() {
        return this.g;
    }

    protected java.lang.String e(java.lang.String str) {
        return "";
    }

    public void e(boolean z) {
        this.n = z;
    }

    public void f(java.lang.String str) {
        this.m = str;
    }

    public void f(boolean z) {
        this.o = z;
    }

    public boolean f() {
        return this.e;
    }

    public int g() {
        return this.f;
    }

    public void g(java.lang.String str) {
        this.i = str;
    }

    public void g(boolean z) {
        this.p = z;
    }

    protected int h() {
        return this.f1543a;
    }

    public void h(boolean z) {
        this.q = z;
    }

    public int i() {
        return this.b;
    }

    public java.lang.String j() {
        return this.m;
    }

    public java.lang.String k() {
        return this.i;
    }

    public java.util.Map<java.lang.String, java.lang.Integer> l() {
        java.util.HashMap map = new java.util.HashMap();
        map.put(com.unisound.client.SpeechConstants.ASR_SERVICE_MODE_JSONKEY, 1001);
        map.put(com.unisound.client.SpeechConstants.ASR_VOICE_FIELD_JSONKEY, 1003);
        map.put(com.unisound.client.SpeechConstants.ASR_LANGUAGE_JSONKEY, 1004);
        map.put(com.unisound.client.SpeechConstants.ASR_DOMAIN_JSONKEY, 1008);
        map.put(com.unisound.client.SpeechConstants.ASR_SERVER_ADDR_JSONKEY, 1009);
        map.put(com.unisound.client.SpeechConstants.ASR_VAD_TIMEOUT_FRONTSIL_JSONKEY, 1010);
        map.put(com.unisound.client.SpeechConstants.ASR_VAD_TIMEOUT_BACKSIL_JSONKEY, 1011);
        map.put(com.unisound.client.SpeechConstants.ASR_WAKEUP_WORD_JSONKEY, 1013);
        map.put(com.unisound.client.SpeechConstants.ASR_NET_TIMEOUT_JSONKEY, 1014);
        map.put(com.unisound.client.SpeechConstants.NLU_ENABLE_JSONKEY, 1020);
        map.put(com.unisound.client.SpeechConstants.NLU_SCENARIO_JSONKEY, 1021);
        map.put(com.unisound.client.SpeechConstants.NLU_SERVER_ADDR_JSONKEY, java.lang.Integer.valueOf(com.unisound.client.SpeechConstants.NLU_SERVER_ADDR));
        map.put(com.unisound.client.SpeechConstants.GENERAL_HISTORY_JSONKEY, java.lang.Integer.valueOf(com.unisound.client.SpeechConstants.GENERAL_HISTORY));
        map.put(com.unisound.client.SpeechConstants.GENERAL_CITY_JSONKEY, java.lang.Integer.valueOf(com.unisound.client.SpeechConstants.GENERAL_CITY));
        map.put(com.unisound.client.SpeechConstants.GENERAL_VOICEID_JSONKEY, 1032);
        map.put(com.unisound.client.SpeechConstants.GENERAL_GPS_JSONKEY, 1033);
        map.put(com.unisound.client.SpeechConstants.ASR_SAMPLING_RATE_JSONKEY, java.lang.Integer.valueOf(com.unisound.client.SpeechConstants.ASR_SAMPLING_RATE));
        map.put(com.unisound.client.SpeechConstants.ASR_OPT_ENGINE_TAG_JSONKEY, java.lang.Integer.valueOf(com.unisound.client.SpeechConstants.ASR_OPT_ENGINE_TAG));
        map.put(com.unisound.client.SpeechConstants.ASR_OPT_RESULT_FILTER_JSONKEY, java.lang.Integer.valueOf(com.unisound.client.SpeechConstants.ASR_OPT_RESULT_FILTER));
        map.put(com.unisound.client.SpeechConstants.ASR_OPT_RECORDING_ENABLED_JSONKEY, java.lang.Integer.valueOf(com.unisound.client.SpeechConstants.ASR_OPT_RECORDING_ENABLED));
        map.put(com.unisound.client.SpeechConstants.ASR_OPT_PRINT_LOG_JSONKEY, java.lang.Integer.valueOf(com.unisound.client.SpeechConstants.ASR_OPT_PRINT_LOG));
        map.put(com.unisound.client.SpeechConstants.ASR_OPT_FIX_ASR_CONTINUOUS_JSONKEY, java.lang.Integer.valueOf(com.unisound.client.SpeechConstants.ASR_OPT_FIX_ASR_CONTINUOUS));
        map.put(com.unisound.client.SpeechConstants.ASR_OPT_VAD_ENABLED_JSONKEY, java.lang.Integer.valueOf(com.unisound.client.SpeechConstants.ASR_OPT_WAKEUP_VAD_ENABLED));
        map.put(com.unisound.client.SpeechConstants.ASR_OPT_FRONT_VAD_ENABLED_JSONKEY, java.lang.Integer.valueOf(com.unisound.client.SpeechConstants.ASR_OPT_FRONT_VAD_ENABLED));
        map.put(com.unisound.client.SpeechConstants.ASR_OPT_SAVE_RECORDING_DATA_JSONKEY, java.lang.Integer.valueOf(com.unisound.client.SpeechConstants.ASR_OPT_SAVE_RECORDING_DATA));
        map.put(com.unisound.client.SpeechConstants.ASR_OPT_RESULT_JSON_JSONKEY, java.lang.Integer.valueOf(com.unisound.client.SpeechConstants.ASR_OPT_RESULT_JSON));
        map.put(com.unisound.client.SpeechConstants.ASR_OPT_FRONT_CACHE_TIME_JSONKEY, java.lang.Integer.valueOf(com.unisound.client.SpeechConstants.ASR_OPT_FRONT_CACHE_TIME));
        map.put(com.unisound.client.SpeechConstants.ASR_OPT_PRINT_ENGINE_LOG_JSONKEY, java.lang.Integer.valueOf(com.unisound.client.SpeechConstants.ASR_OPT_PRINT_ENGINE_LOG));
        map.put(com.unisound.client.SpeechConstants.ASR_OPT_PRINT_TIME_LOG_JSONKEY, java.lang.Integer.valueOf(com.unisound.client.SpeechConstants.ASR_OPT_PRINT_TIME_LOG));
        map.put(com.unisound.client.SpeechConstants.ASR_OPT_FRONT_RESET_CACHE_BYTE_TIME_JSONKEY, java.lang.Integer.valueOf(com.unisound.client.SpeechConstants.ASR_OPT_FRONT_RESET_CACHE_BYTE_TIME));
        map.put(com.unisound.client.SpeechConstants.ASR_OPT_DEBUG_SAVELOG_JSONKEY, java.lang.Integer.valueOf(com.unisound.client.SpeechConstants.ASR_OPT_DEBUG_SAVELOG));
        map.put(com.unisound.client.SpeechConstants.ASR_OPT_DEBUG_POSTLOG_JSONKEY, java.lang.Integer.valueOf(com.unisound.client.SpeechConstants.ASR_OPT_DEBUG_POSTLOG));
        map.put(com.unisound.client.SpeechConstants.ASR_OPT_USE_HANDLERTHREAD_JSONKEY, java.lang.Integer.valueOf(com.unisound.client.SpeechConstants.ASR_OPT_USE_HANDLERTHREAD));
        map.put(com.unisound.client.SpeechConstants.ASR_OPT_SAVE_AFTERVAD_RECORDING_DATA_JSONKEY, java.lang.Integer.valueOf(com.unisound.client.SpeechConstants.ASR_OPT_SAVE_AFTERVAD_RECORDING_DATA));
        map.put(com.unisound.client.SpeechConstants.ASR_OPT_MARK_VAD_JSONKEY, java.lang.Integer.valueOf(com.unisound.client.SpeechConstants.ASR_OPT_MARK_VAD));
        map.put(com.unisound.client.SpeechConstants.ASR_OPT_RESULT_JSON_JSONKEY, java.lang.Integer.valueOf(com.unisound.client.SpeechConstants.ASR_OPT_RESULT_JSON));
        map.put(com.unisound.client.SpeechConstants.ASR_OPT_RESULT_JSON_JSONKEY, java.lang.Integer.valueOf(com.unisound.client.SpeechConstants.ASR_OPT_RESULT_JSON));
        map.put(com.unisound.client.SpeechConstants.ASR_OPT_RESULT_JSON_JSONKEY, java.lang.Integer.valueOf(com.unisound.client.SpeechConstants.ASR_OPT_RESULT_JSON));
        map.put(com.unisound.client.SpeechConstants.WAKEUP_OPT_THRESHOLD_VALUE_JSONKEY, java.lang.Integer.valueOf(com.unisound.client.SpeechConstants.WAKEUP_OPT_THRESHOLD_VALUE));
        return map;
    }

    public boolean m() {
        return this.c;
    }

    public boolean n() {
        return this.d;
    }

    public boolean o() {
        return this.n;
    }

    public boolean p() {
        return this.o;
    }

    public boolean q() {
        return this.p;
    }

    public boolean r() {
        return this.q;
    }
}
