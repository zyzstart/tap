package com.tencent.ydkbeacon.a.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a implements android.content.SharedPreferences {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile com.tencent.ydkbeacon.a.d.a f1191a;
    private boolean b;
    private com.tencent.ydkbeacon.a.d.g c;
    private com.tencent.ydkbeacon.a.d.a.SharedPreferencesEditorC0041a d;
    private android.content.SharedPreferences e;

    /* JADX INFO: renamed from: com.tencent.ydkbeacon.a.d.a$a, reason: collision with other inner class name */
    public static class SharedPreferencesEditorC0041a implements android.content.SharedPreferences.Editor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.tencent.ydkbeacon.a.d.g f1192a;

        SharedPreferencesEditorC0041a(com.tencent.ydkbeacon.a.d.g gVar) {
            this.f1192a = gVar;
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
        }

        @Override // android.content.SharedPreferences.Editor
        public android.content.SharedPreferences.Editor clear() {
            this.f1192a.a();
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            return true;
        }

        @Override // android.content.SharedPreferences.Editor
        public android.content.SharedPreferences.Editor putBoolean(@android.support.annotation.NonNull java.lang.String str, boolean z) {
            this.f1192a.b(str, java.lang.Boolean.valueOf(z));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public android.content.SharedPreferences.Editor putFloat(@android.support.annotation.NonNull java.lang.String str, float f) {
            this.f1192a.b(str, java.lang.Float.valueOf(f));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public android.content.SharedPreferences.Editor putInt(@android.support.annotation.NonNull java.lang.String str, int i) {
            this.f1192a.b(str, java.lang.Integer.valueOf(i));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public android.content.SharedPreferences.Editor putLong(@android.support.annotation.NonNull java.lang.String str, long j) {
            this.f1192a.b(str, java.lang.Long.valueOf(j));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public android.content.SharedPreferences.Editor putString(@android.support.annotation.NonNull java.lang.String str, @android.support.annotation.NonNull java.lang.String str2) {
            this.f1192a.b(str, str2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public android.content.SharedPreferences.Editor putStringSet(@android.support.annotation.NonNull java.lang.String str, @android.support.annotation.NonNull java.util.Set set) {
            this.f1192a.b(str, set);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public android.content.SharedPreferences.Editor remove(java.lang.String str) {
            this.f1192a.b(str);
            return this;
        }
    }

    private a() {
    }

    public static com.tencent.ydkbeacon.a.d.a a() {
        if (f1191a == null) {
            synchronized (com.tencent.ydkbeacon.a.d.a.class) {
                if (f1191a == null) {
                    f1191a = new com.tencent.ydkbeacon.a.d.a();
                }
            }
        }
        return f1191a;
    }

    private java.lang.Object a(@android.support.annotation.NonNull java.lang.String str, java.lang.Object obj) {
        if (!this.b) {
            return obj;
        }
        java.lang.Object objA = this.c.a(str, obj);
        if (objA == null || objA == obj) {
            android.content.Context contextC = com.tencent.ydkbeacon.a.c.c.d().c();
            if (this.e == null) {
                this.e = contextC.getSharedPreferences("DENGTA_META", 0);
            }
            if (obj instanceof java.lang.Boolean) {
                objA = java.lang.Boolean.valueOf(this.e.getBoolean(str, ((java.lang.Boolean) obj).booleanValue()));
            } else if (obj instanceof java.lang.String) {
                objA = this.e.getString(str, (java.lang.String) obj);
            } else if (obj instanceof java.lang.Integer) {
                objA = java.lang.Integer.valueOf(this.e.getInt(str, ((java.lang.Integer) obj).intValue()));
            } else if (obj instanceof java.lang.Long) {
                objA = java.lang.Long.valueOf(this.e.getLong(str, ((java.lang.Long) obj).longValue()));
            } else if (obj instanceof java.lang.Float) {
                objA = java.lang.Float.valueOf(this.e.getFloat(str, ((java.lang.Float) obj).floatValue()));
            }
            if (objA != null && objA != obj) {
                this.c.b(str, objA);
            }
        }
        return objA == null ? obj : objA;
    }

    public synchronized void a(android.content.Context context) {
        if (this.b || context == null) {
            return;
        }
        try {
            java.lang.String strReplace = com.tencent.ydkbeacon.a.c.b.c(context).replace(context.getPackageName(), "");
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("prop_");
            sb.append(strReplace);
            com.tencent.ydkbeacon.a.d.g gVarA = com.tencent.ydkbeacon.a.d.g.a(context, sb.toString());
            this.c = gVarA;
            this.d = new com.tencent.ydkbeacon.a.d.a.SharedPreferencesEditorC0041a(gVarA);
            this.b = true;
        } catch (java.io.IOException e) {
            com.tencent.ydkbeacon.a.e.c.a(e);
            com.tencent.ydkbeacon.a.b.d.b().a("504", "[properties] PropertiesFile create error!", e);
            this.b = false;
        }
    }

    @Override // android.content.SharedPreferences
    public boolean contains(java.lang.String str) {
        return this.c.a(str);
    }

    @Override // android.content.SharedPreferences
    public com.tencent.ydkbeacon.a.d.a.SharedPreferencesEditorC0041a edit() {
        if (!this.b) {
            com.tencent.ydkbeacon.a.e.e.a("BeaconProperties has not init!");
            a(com.tencent.ydkbeacon.a.c.c.d().c());
        }
        return this.d;
    }

    @Override // android.content.SharedPreferences
    public java.util.Map getAll() {
        return this.c.b();
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(@android.support.annotation.NonNull java.lang.String str, boolean z) {
        return ((java.lang.Boolean) a(str, java.lang.Boolean.valueOf(z))).booleanValue();
    }

    @Override // android.content.SharedPreferences
    public float getFloat(@android.support.annotation.NonNull java.lang.String str, float f) {
        return ((java.lang.Number) a(str, java.lang.Float.valueOf(f))).floatValue();
    }

    @Override // android.content.SharedPreferences
    public int getInt(@android.support.annotation.NonNull java.lang.String str, int i) {
        return ((java.lang.Number) a(str, java.lang.Integer.valueOf(i))).intValue();
    }

    @Override // android.content.SharedPreferences
    public long getLong(@android.support.annotation.NonNull java.lang.String str, long j) {
        return ((java.lang.Number) a(str, java.lang.Long.valueOf(j))).longValue();
    }

    @Override // android.content.SharedPreferences
    public java.lang.String getString(@android.support.annotation.NonNull java.lang.String str, @android.support.annotation.NonNull java.lang.String str2) {
        return (java.lang.String) a(str, str2);
    }

    @Override // android.content.SharedPreferences
    public java.util.Set getStringSet(@android.support.annotation.NonNull java.lang.String str, @android.support.annotation.Nullable java.util.Set set) {
        return !this.b ? set : this.c.a(str, set);
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(android.content.SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(android.content.SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }
}
