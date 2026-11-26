package com.unisound.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class z implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.String f1504a;

    z(java.lang.String str) {
        this.f1504a = str;
    }

    @Override // java.lang.Runnable
    public void run() throws java.lang.Throwable {
        java.lang.String strB;
        synchronized (com.unisound.common.y.T) {
            try {
                boolean unused = com.unisound.common.y.R = true;
                try {
                    java.io.File file = new java.io.File(this.f1504a);
                    if (file.exists() && file.isDirectory()) {
                        java.io.File[] fileArrListFiles = file.listFiles();
                        if (fileArrListFiles.length > 0) {
                            for (int i = 0; i < fileArrListFiles.length; i++) {
                                if (com.unisound.common.y.R && (strB = com.unisound.common.y.b(fileArrListFiles[i])) != null && !strB.equals("")) {
                                    try {
                                        org.json.JSONObject jSONObject = new org.json.JSONObject(strB);
                                        if (new com.unisound.common.w().a(new com.unisound.common.x(jSONObject.getString(com.unisound.common.x.f1502a), jSONObject.getString("imei"), jSONObject.getString(com.unisound.common.x.c), jSONObject.getString(com.unisound.common.x.e), jSONObject.getString("packageName"), jSONObject.getInt("status"), jSONObject.getString(com.unisound.common.x.h), jSONObject.getString(com.unisound.common.x.i), jSONObject.getString(com.unisound.common.x.j))) == 0) {
                                            int unused2 = com.unisound.common.y.S = 0;
                                            fileArrListFiles[i].delete();
                                            boolean unused3 = com.unisound.common.y.R = true;
                                        } else {
                                            com.unisound.common.y.d();
                                            com.unisound.common.y.a("postLogError " + com.unisound.common.y.S + " times");
                                            boolean unused4 = com.unisound.common.y.R = false;
                                        }
                                    } catch (java.lang.Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        }
    }
}
