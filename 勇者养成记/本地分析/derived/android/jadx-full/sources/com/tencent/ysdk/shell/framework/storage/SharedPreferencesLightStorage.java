package com.tencent.ysdk.shell.framework.storage;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class SharedPreferencesLightStorage implements com.tencent.ysdk.shell.framework.storage.ILightStorage {
    private android.content.SharedPreferences mSharedPreferences;

    public SharedPreferencesLightStorage(android.content.SharedPreferences sharedPreferences) {
        this.mSharedPreferences = sharedPreferences;
    }

    private boolean write(java.lang.String str, java.lang.Object obj, boolean z) {
        if (this.mSharedPreferences == null || obj == null) {
            return false;
        }
        return writeInner(str, obj, z);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x004e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:21:0x004f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:22:0x0051  */
    /* JADX WARN: Code duplicated, block: B:23:0x0055  */
    private boolean writeInner(java.lang.String str, java.lang.Object obj, boolean z) {
        boolean z2;
        android.content.SharedPreferences.Editor editorEdit = this.mSharedPreferences.edit();
        if (obj instanceof java.lang.Integer) {
            editorEdit.putInt(str, ((java.lang.Integer) obj).intValue());
        } else if (obj instanceof java.lang.Boolean) {
            editorEdit.putBoolean(str, ((java.lang.Boolean) obj).booleanValue());
        } else if (obj instanceof java.lang.Float) {
            editorEdit.putFloat(str, ((java.lang.Float) obj).floatValue());
        } else {
            if (!(obj instanceof java.lang.String)) {
                if (obj instanceof java.lang.Long) {
                    editorEdit.putLong(str, ((java.lang.Long) obj).longValue());
                } else {
                    z2 = false;
                }
                if (!z2) {
                    return false;
                }
                if (z) {
                    editorEdit.commit();
                } else {
                    editorEdit.apply();
                }
                return true;
            }
            editorEdit.putString(str, (java.lang.String) obj);
        }
        z2 = true;
        if (!z2) {
            return false;
        }
        if (z) {
            editorEdit.commit();
        } else {
            editorEdit.apply();
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> boolean writeMapWithType(android.content.SharedPreferences.Editor editor, java.lang.String str, T t) {
        if (t instanceof java.lang.Integer) {
            editor.putInt(str, ((java.lang.Integer) t).intValue());
            return true;
        }
        if (t instanceof java.lang.Boolean) {
            editor.putBoolean(str, ((java.lang.Boolean) t).booleanValue());
            return true;
        }
        if (t instanceof java.lang.Float) {
            editor.putFloat(str, ((java.lang.Float) t).floatValue());
            return true;
        }
        if (t instanceof java.lang.String) {
            editor.putString(str, (java.lang.String) t);
            return true;
        }
        if (!(t instanceof java.lang.Long)) {
            return false;
        }
        editor.putLong(str, ((java.lang.Long) t).longValue());
        return true;
    }

    @Override // com.tencent.ysdk.shell.framework.storage.ILightStorage
    public void clear() {
        this.mSharedPreferences.edit().clear().commit();
    }

    @Override // com.tencent.ysdk.shell.framework.storage.ILightStorage
    public boolean contains(java.lang.String str) {
        android.content.SharedPreferences sharedPreferences = this.mSharedPreferences;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.contains(str);
    }

    @Override // com.tencent.ysdk.shell.framework.storage.ILightStorage
    public java.util.Map<java.lang.String, ?> readAll() {
        android.content.SharedPreferences sharedPreferences = this.mSharedPreferences;
        return sharedPreferences == null ? new java.util.HashMap() : sharedPreferences.getAll();
    }

    @Override // com.tencent.ysdk.shell.framework.storage.ILightStorage
    public java.lang.Boolean readBoolean(java.lang.String str, boolean z) {
        android.content.SharedPreferences sharedPreferences = this.mSharedPreferences;
        return (sharedPreferences == null || !sharedPreferences.contains(str)) ? java.lang.Boolean.valueOf(z) : java.lang.Boolean.valueOf(this.mSharedPreferences.getBoolean(str, z));
    }

    @Override // com.tencent.ysdk.shell.framework.storage.ILightStorage
    public java.lang.Float readFloat(java.lang.String str, java.lang.Float f) {
        android.content.SharedPreferences sharedPreferences = this.mSharedPreferences;
        return (sharedPreferences == null || !sharedPreferences.contains(str)) ? f : java.lang.Float.valueOf(this.mSharedPreferences.getFloat(str, f.floatValue()));
    }

    @Override // com.tencent.ysdk.shell.framework.storage.ILightStorage
    public java.lang.Integer readInt(java.lang.String str, int i) {
        android.content.SharedPreferences sharedPreferences = this.mSharedPreferences;
        return (sharedPreferences == null || !sharedPreferences.contains(str)) ? java.lang.Integer.valueOf(i) : java.lang.Integer.valueOf(this.mSharedPreferences.getInt(str, i));
    }

    @Override // com.tencent.ysdk.shell.framework.storage.ILightStorage
    public java.lang.Long readLong(java.lang.String str, long j) {
        android.content.SharedPreferences sharedPreferences = this.mSharedPreferences;
        return (sharedPreferences == null || !sharedPreferences.contains(str)) ? java.lang.Long.valueOf(j) : java.lang.Long.valueOf(this.mSharedPreferences.getLong(str, j));
    }

    @Override // com.tencent.ysdk.shell.framework.storage.ILightStorage
    public java.lang.String readString(java.lang.String str, java.lang.String str2) {
        android.content.SharedPreferences sharedPreferences = this.mSharedPreferences;
        return (sharedPreferences == null || !sharedPreferences.contains(str)) ? str2 : this.mSharedPreferences.getString(str, str2);
    }

    @Override // com.tencent.ysdk.shell.framework.storage.ILightStorage
    public boolean write(java.lang.String str, java.lang.Object obj) {
        return write(str, obj, false);
    }

    @Override // com.tencent.ysdk.shell.framework.storage.ILightStorage
    public boolean writeAndCommit(java.lang.String str, java.lang.Object obj) {
        return write(str, obj, true);
    }

    @Override // com.tencent.ysdk.shell.framework.storage.ILightStorage
    public <T> boolean writeMap(java.util.Map<java.lang.String, T> map) {
        if (this.mSharedPreferences == null || map == null || map.isEmpty()) {
            return false;
        }
        android.content.SharedPreferences.Editor editorEdit = this.mSharedPreferences.edit();
        boolean zWriteMapWithType = true;
        for (java.util.Map.Entry<java.lang.String, T> entry : map.entrySet()) {
            zWriteMapWithType = writeMapWithType(editorEdit, entry.getKey(), entry.getValue());
            if (!zWriteMapWithType) {
                break;
            }
        }
        if (!zWriteMapWithType) {
            return false;
        }
        editorEdit.commit();
        return true;
    }
}
