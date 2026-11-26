package com.tencent.mm.opensdk.openapi;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class MMSharedPreferences implements android.content.SharedPreferences {
    private static final java.lang.String TAG = "MicroMsg.SDK.SharedPreferences";
    private final android.content.ContentResolver cr;
    private final java.lang.String[] columns = {"_id", "key", com.tencent.open.SocialConstants.PARAM_TYPE, com.qq.gdt.action.ActionUtils.PAYMENT_AMOUNT};
    private final java.util.HashMap values = new java.util.HashMap();
    private com.tencent.mm.opensdk.openapi.MMSharedPreferences.REditor editor = null;

    private static class REditor implements android.content.SharedPreferences.Editor {
        private android.content.ContentResolver cr;
        private java.util.Map values = new java.util.HashMap();
        private java.util.Set remove = new java.util.HashSet();
        private boolean clear = false;

        public REditor(android.content.ContentResolver contentResolver) {
            this.cr = contentResolver;
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
        }

        @Override // android.content.SharedPreferences.Editor
        public android.content.SharedPreferences.Editor clear() {
            this.clear = true;
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:36:0x009c  */
        /* JADX WARN: Code duplicated, block: B:37:0x009e  */
        /* JADX WARN: Code duplicated, block: B:43:0x00b3 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:45:0x003f A[SYNTHETIC] */
        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            int i;
            boolean z;
            android.content.ContentValues contentValues = new android.content.ContentValues();
            if (this.clear) {
                this.cr.delete(com.tencent.mm.opensdk.utils.c.b.CONTENT_URI, null, null);
                this.clear = false;
            }
            java.util.Iterator it = this.remove.iterator();
            while (it.hasNext()) {
                this.cr.delete(com.tencent.mm.opensdk.utils.c.b.CONTENT_URI, "key = ?", new java.lang.String[]{(java.lang.String) it.next()});
            }
            for (java.util.Map.Entry entry : this.values.entrySet()) {
                java.lang.Object value = entry.getValue();
                if (value == null) {
                    com.tencent.mm.opensdk.utils.Log.e("MicroMsg.SDK.PluginProvider.Resolver", "unresolve failed, null value");
                } else {
                    if (value instanceof java.lang.Integer) {
                        i = 1;
                    } else if (value instanceof java.lang.Long) {
                        i = 2;
                    } else if (value instanceof java.lang.String) {
                        i = 3;
                    } else if (value instanceof java.lang.Boolean) {
                        i = 4;
                    } else if (value instanceof java.lang.Float) {
                        i = 5;
                    } else if (value instanceof java.lang.Double) {
                        i = 6;
                    } else {
                        com.tencent.mm.opensdk.utils.Log.e("MicroMsg.SDK.PluginProvider.Resolver", "unresolve failed, unknown type=" + value.getClass().toString());
                    }
                    if (i == 0) {
                        z = false;
                    } else {
                        contentValues.put(com.tencent.open.SocialConstants.PARAM_TYPE, java.lang.Integer.valueOf(i));
                        contentValues.put(com.qq.gdt.action.ActionUtils.PAYMENT_AMOUNT, value.toString());
                        z = true;
                    }
                    if (z) {
                        this.cr.update(com.tencent.mm.opensdk.utils.c.b.CONTENT_URI, contentValues, "key = ?", new java.lang.String[]{(java.lang.String) entry.getKey()});
                    }
                }
                i = 0;
                if (i == 0) {
                    z = false;
                } else {
                    contentValues.put(com.tencent.open.SocialConstants.PARAM_TYPE, java.lang.Integer.valueOf(i));
                    contentValues.put(com.qq.gdt.action.ActionUtils.PAYMENT_AMOUNT, value.toString());
                    z = true;
                }
                if (z) {
                    this.cr.update(com.tencent.mm.opensdk.utils.c.b.CONTENT_URI, contentValues, "key = ?", new java.lang.String[]{(java.lang.String) entry.getKey()});
                }
            }
            return true;
        }

        @Override // android.content.SharedPreferences.Editor
        public android.content.SharedPreferences.Editor putBoolean(java.lang.String str, boolean z) {
            this.values.put(str, java.lang.Boolean.valueOf(z));
            this.remove.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public android.content.SharedPreferences.Editor putFloat(java.lang.String str, float f) {
            this.values.put(str, java.lang.Float.valueOf(f));
            this.remove.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public android.content.SharedPreferences.Editor putInt(java.lang.String str, int i) {
            this.values.put(str, java.lang.Integer.valueOf(i));
            this.remove.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public android.content.SharedPreferences.Editor putLong(java.lang.String str, long j) {
            this.values.put(str, java.lang.Long.valueOf(j));
            this.remove.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public android.content.SharedPreferences.Editor putString(java.lang.String str, java.lang.String str2) {
            this.values.put(str, str2);
            this.remove.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public android.content.SharedPreferences.Editor putStringSet(java.lang.String str, java.util.Set set) {
            return null;
        }

        @Override // android.content.SharedPreferences.Editor
        public android.content.SharedPreferences.Editor remove(java.lang.String str) {
            this.remove.add(str);
            return this;
        }
    }

    public MMSharedPreferences(android.content.Context context) {
        this.cr = context.getContentResolver();
    }

    private java.lang.Object getValue(java.lang.String str) {
        try {
            android.database.Cursor cursorQuery = this.cr.query(com.tencent.mm.opensdk.utils.c.b.CONTENT_URI, this.columns, "key = ?", new java.lang.String[]{str}, null);
            if (cursorQuery == null) {
                return null;
            }
            java.lang.Object objA = cursorQuery.moveToFirst() ? com.tencent.mm.opensdk.utils.c.a.a(cursorQuery.getInt(cursorQuery.getColumnIndex(com.tencent.open.SocialConstants.PARAM_TYPE)), cursorQuery.getString(cursorQuery.getColumnIndex(com.qq.gdt.action.ActionUtils.PAYMENT_AMOUNT))) : null;
            cursorQuery.close();
            return objA;
        } catch (java.lang.Exception e) {
            com.tencent.mm.opensdk.utils.Log.e(TAG, "getValue exception:" + e.getMessage());
            return null;
        }
    }

    @Override // android.content.SharedPreferences
    public boolean contains(java.lang.String str) {
        return getValue(str) != null;
    }

    @Override // android.content.SharedPreferences
    public android.content.SharedPreferences.Editor edit() {
        if (this.editor == null) {
            this.editor = new com.tencent.mm.opensdk.openapi.MMSharedPreferences.REditor(this.cr);
        }
        return this.editor;
    }

    @Override // android.content.SharedPreferences
    public java.util.Map getAll() {
        try {
            android.database.Cursor cursorQuery = this.cr.query(com.tencent.mm.opensdk.utils.c.b.CONTENT_URI, this.columns, null, null, null);
            if (cursorQuery == null) {
                return null;
            }
            int columnIndex = cursorQuery.getColumnIndex("key");
            int columnIndex2 = cursorQuery.getColumnIndex(com.tencent.open.SocialConstants.PARAM_TYPE);
            int columnIndex3 = cursorQuery.getColumnIndex(com.qq.gdt.action.ActionUtils.PAYMENT_AMOUNT);
            while (cursorQuery.moveToNext()) {
                this.values.put(cursorQuery.getString(columnIndex), com.tencent.mm.opensdk.utils.c.a.a(cursorQuery.getInt(columnIndex2), cursorQuery.getString(columnIndex3)));
            }
            cursorQuery.close();
            return this.values;
        } catch (java.lang.Exception e) {
            com.tencent.mm.opensdk.utils.Log.e(TAG, "getAll exception:" + e.getMessage());
            return this.values;
        }
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(java.lang.String str, boolean z) {
        java.lang.Object value = getValue(str);
        return (value == null || !(value instanceof java.lang.Boolean)) ? z : ((java.lang.Boolean) value).booleanValue();
    }

    @Override // android.content.SharedPreferences
    public float getFloat(java.lang.String str, float f) {
        java.lang.Object value = getValue(str);
        return (value == null || !(value instanceof java.lang.Float)) ? f : ((java.lang.Float) value).floatValue();
    }

    @Override // android.content.SharedPreferences
    public int getInt(java.lang.String str, int i) {
        java.lang.Object value = getValue(str);
        return (value == null || !(value instanceof java.lang.Integer)) ? i : ((java.lang.Integer) value).intValue();
    }

    @Override // android.content.SharedPreferences
    public long getLong(java.lang.String str, long j) {
        java.lang.Object value = getValue(str);
        return (value == null || !(value instanceof java.lang.Long)) ? j : ((java.lang.Long) value).longValue();
    }

    @Override // android.content.SharedPreferences
    public java.lang.String getString(java.lang.String str, java.lang.String str2) {
        java.lang.Object value = getValue(str);
        return (value == null || !(value instanceof java.lang.String)) ? str2 : (java.lang.String) value;
    }

    @Override // android.content.SharedPreferences
    public java.util.Set getStringSet(java.lang.String str, java.util.Set set) {
        return null;
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(android.content.SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(android.content.SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }
}
