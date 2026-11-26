package com.tencent.beaconselfupdate.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.tencent.beaconselfupdate.a.e f238a;

    private e() {
    }

    public static int a(android.content.Context context, java.lang.Long[] lArr) {
        com.tencent.beaconselfupdate.c.a.a(" RecordDAO.deleteRecordList() start", new java.lang.Object[0]);
        if (context == null) {
            com.tencent.beaconselfupdate.c.a.d(" deleteRecordList() have null args!", new java.lang.Object[0]);
            return -1;
        }
        com.tencent.beaconselfupdate.c.a.a(" RecordDAO.deleteRecordList() end", new java.lang.Object[0]);
        return com.tencent.beaconselfupdate.a.a.a.a(context, lArr);
    }

    public static synchronized com.tencent.beaconselfupdate.a.e a(android.content.Context context) {
        if (f238a == null && context != null) {
            f238a = new com.tencent.beaconselfupdate.a.e();
        }
        return f238a;
    }

    public static com.tencent.beaconselfupdate.b.a.b a(int i, com.tencent.beaconselfupdate.a.c cVar, byte[] bArr, int i2, int i3) {
        java.lang.String str;
        java.lang.String str2;
        com.tencent.beaconselfupdate.c.a.b("en2Req", new java.lang.Object[0]);
        if (cVar == null) {
            com.tencent.beaconselfupdate.c.a.d("error no com info! ", new java.lang.Object[0]);
            return null;
        }
        try {
            com.tencent.beaconselfupdate.b.a.b bVar = new com.tencent.beaconselfupdate.b.a.b();
            synchronized (cVar) {
                bVar.j = cVar.a();
                bVar.k = cVar.b();
                bVar.f241a = cVar.c();
                bVar.b = cVar.j();
                bVar.c = cVar.d();
                bVar.d = cVar.e();
                bVar.e = cVar.f();
                bVar.l = "";
                if (i == 100) {
                    java.util.HashMap map = new java.util.HashMap();
                    map.put("A1", com.tencent.beaconselfupdate.event.UserAction.getUserID());
                    map.put("A2", cVar.i());
                    com.tencent.beaconselfupdate.event.c cVarA = com.tencent.beaconselfupdate.event.c.a(cVar.l());
                    map.put("A4", cVarA.c());
                    map.put("A6", cVarA.b());
                    map.put("A7", cVarA.d());
                    map.put("A3", cVarA.e());
                    map.put("A23", cVar.k());
                    map.put("A31", cVarA.f());
                    a(cVar.l());
                    map.put("A33", g(cVar.l()));
                    if (com.tencent.beaconselfupdate.a.a.g(cVar.l())) {
                        str = "A66";
                        str2 = "F";
                    } else {
                        str = "A66";
                        str2 = "B";
                    }
                    map.put(str, str2);
                    map.put("A67", com.tencent.beaconselfupdate.a.a.i(cVar.l()));
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append(com.tencent.beaconselfupdate.a.a.h(cVar.l()));
                    map.put("A68", sb.toString());
                    map.put("A85", com.tencent.beaconselfupdate.a.a.b ? "Y" : "N");
                    bVar.l = a((java.util.Map) map);
                }
            }
            if (i == 4 || i == 2 || i == 1) {
                bVar.l = a(com.tencent.beaconselfupdate.event.UserAction.getAdditionalInfo());
            }
            bVar.f = i;
            bVar.h = (byte) i3;
            bVar.i = (byte) i2;
            if (bArr == null) {
                bArr = "".getBytes();
            }
            bVar.g = bArr;
            return bVar;
        } catch (java.lang.Throwable th) {
            com.tencent.beaconselfupdate.c.a.a(th);
            return null;
        }
    }

    public static com.tencent.beaconselfupdate.b.b.a a(com.tencent.beaconselfupdate.event.h hVar) {
        java.util.Map mapE;
        if (hVar == null || !com.tencent.beacon.core.event.RDBean.TP_UA.equals(hVar.b()) || (mapE = hVar.e()) == null) {
            return null;
        }
        try {
            com.tencent.beaconselfupdate.b.b.a aVar = new com.tencent.beaconselfupdate.b.b.a();
            java.lang.String str = (java.lang.String) mapE.get("A19");
            java.lang.String str2 = (java.lang.String) mapE.get("A28");
            if (str != null) {
                aVar.f243a = str;
            }
            aVar.c = hVar.d();
            aVar.h = hVar.c();
            if (str2 != null) {
                aVar.b = str2;
            }
            java.lang.String str3 = (java.lang.String) mapE.get("A26");
            long j = 0;
            aVar.f = str3 == null ? 0L : java.lang.Long.parseLong(str3);
            aVar.d = java.lang.Boolean.parseBoolean((java.lang.String) mapE.get("A25"));
            java.lang.String str4 = (java.lang.String) mapE.get("A27");
            if (str4 != null) {
                j = java.lang.Long.parseLong(str4);
            }
            aVar.e = j;
            mapE.remove("A19");
            mapE.remove("A28");
            mapE.remove("A26");
            mapE.remove("A25");
            mapE.remove("A27");
            aVar.g = a(mapE);
            return aVar;
        } catch (java.lang.Throwable th) {
            com.tencent.beaconselfupdate.c.a.a(th);
            com.tencent.beaconselfupdate.c.a.d(th.getMessage(), new java.lang.Object[0]);
            return null;
        }
    }

    public static com.tencent.beaconselfupdate.event.h a(android.content.Context context, java.lang.String str, boolean z, long j, long j2, java.util.Map map, boolean z2) {
        if (str == null) {
            return null;
        }
        com.tencent.beaconselfupdate.a.c cVarM = com.tencent.beaconselfupdate.a.c.m();
        boolean z3 = false;
        if (cVarM == null) {
            com.tencent.beaconselfupdate.c.a.d("  CommonInfo or DeviceInfo have not been Created return null!", new java.lang.Object[0]);
            return null;
        }
        com.tencent.beaconselfupdate.event.UserAction.getUserID();
        long time = new java.util.Date().getTime() + cVarM.h();
        java.lang.String strG = cVarM.g();
        java.lang.String strN = n(context);
        if (strN == null) {
            strN = "null";
        }
        java.util.HashMap map2 = new java.util.HashMap();
        if (map != null) {
            map2.putAll(map);
        }
        if (com.tencent.beaconselfupdate.event.j.d().g().h() && !str.startsWith("rqd_")) {
            z3 = true;
        }
        com.tencent.beaconselfupdate.event.c cVarA = com.tencent.beaconselfupdate.event.c.a(context);
        if (!z3) {
            java.lang.String qq = com.tencent.beaconselfupdate.event.UserAction.getQQ();
            if (qq != null && !qq.equals("")) {
                map2.put(com.tencent.connect.common.Constants.SOURCE_QQ, qq);
            }
            map2.put("A2", cVarM.i());
            map2.put("A4", cVarA.c());
            map2.put("A6", cVarA.b());
            map2.put("A7", cVarA.d());
            map2.put("A23", cVarM.k());
            map2.put("A31", cVarA.f());
            map2.put("A67", com.tencent.beaconselfupdate.a.a.i(context));
            map2.put("A76", com.tencent.beaconselfupdate.a.a.a());
            map2.put("A95", com.tencent.beaconselfupdate.a.a.e(context));
        }
        map2.put("A19", strN);
        map2.put("A28", strG);
        map2.put("A25", java.lang.String.valueOf(z));
        map2.put("A26", java.lang.String.valueOf(j));
        map2.put("A27", java.lang.String.valueOf(j2));
        com.tencent.beaconselfupdate.event.h hVar = new com.tencent.beaconselfupdate.event.h();
        hVar.b(str);
        hVar.b(time);
        hVar.a(com.tencent.beacon.core.event.RDBean.TP_UA);
        hVar.a(map2);
        hVar.a(z2);
        return hVar;
    }

    public static java.lang.String a() {
        try {
            return android.os.Build.MODEL;
        } catch (java.lang.Throwable th) {
            com.tencent.beaconselfupdate.c.a.d("getDeviceName error", new java.lang.Object[0]);
            com.tencent.beaconselfupdate.c.a.a(th);
            return "";
        }
    }

    private static java.lang.String a(java.util.Map map) {
        java.util.Set<java.lang.String> setKeySet;
        com.tencent.beaconselfupdate.c.a.b("map 2 str", new java.lang.Object[0]);
        if (map == null || (setKeySet = map.keySet()) == null) {
            return "";
        }
        if (setKeySet.size() > 50) {
            com.tencent.beaconselfupdate.c.a.c("The Map<String, String> params size is more than 50, effective size is <= 50!", new java.lang.Object[0]);
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (java.lang.String str : setKeySet) {
            int length = str.trim().length();
            if (length <= 0 || !d(str)) {
                com.tencent.beaconselfupdate.c.a.c("The Map<String, String> params key is invalid!! key should be ASCII code in 32-126! key:" + str, new java.lang.Object[0]);
            } else {
                java.lang.String strTrim = str.trim();
                if (length > 64) {
                    strTrim = strTrim.substring(0, 64);
                }
                stringBuffer.append("&");
                stringBuffer.append(strTrim.replace("|", "%7C").replace("&", "%26").replace("=", "%3D"));
                stringBuffer.append("=");
                java.lang.String str2 = (java.lang.String) map.get(str);
                if (str2 != null) {
                    java.lang.String strTrim2 = str2.trim();
                    if (strTrim2.contains(";")) {
                        if (strTrim2.length() > 10240) {
                            java.lang.String strSubstring = strTrim2.substring(0, 10240);
                            strTrim2 = strSubstring.substring(0, strSubstring.lastIndexOf(";"));
                        }
                    } else if (strTrim2.length() > 1024) {
                        strTrim2 = strTrim2.substring(0, 1024);
                    }
                    stringBuffer.append(strTrim2.replace('\n', ' ').replace('\r', ' ').replace("|", "%7C").replace("&", "%26").replace("=", "%3D"));
                }
            }
        }
        java.lang.String strSubstring2 = stringBuffer.substring(1);
        stringBuffer.setLength(0);
        return strSubstring2;
    }

    public static java.util.HashSet a(java.util.ArrayList arrayList) {
        int size = arrayList.size();
        if (arrayList == null || size <= 0) {
            return null;
        }
        java.util.HashSet hashSet = new java.util.HashSet(size);
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            hashSet.add((java.lang.String) it.next());
        }
        return hashSet;
    }

    public static java.util.List a(android.content.Context context, int i) {
        java.lang.Object objB;
        com.tencent.beaconselfupdate.c.a.a(" RecordDAO.queryRecentRecord() start", new java.lang.Object[0]);
        java.util.ArrayList arrayList = null;
        if (context == null) {
            com.tencent.beaconselfupdate.c.a.d(" queryRecentRecord() have null args!", new java.lang.Object[0]);
            return null;
        }
        java.util.List listA = com.tencent.beaconselfupdate.a.a.a.a(context, new int[]{1}, i);
        if (listA != null && listA.size() > 0) {
            arrayList = new java.util.ArrayList();
            java.util.Iterator it = listA.iterator();
            while (it.hasNext()) {
                com.tencent.beaconselfupdate.a.a.a aVar = (com.tencent.beaconselfupdate.a.a.a) it.next();
                try {
                    byte[] bArrDecode = android.util.Base64.decode(aVar.b, 0);
                    if (bArrDecode != null && bArrDecode.length > 0 && aVar.c == bArrDecode.length && (objB = b(bArrDecode)) != null && com.tencent.beaconselfupdate.event.h.class.isInstance(objB)) {
                        com.tencent.beaconselfupdate.event.h hVar = (com.tencent.beaconselfupdate.event.h) com.tencent.beaconselfupdate.event.h.class.cast(objB);
                        hVar.a(aVar.f223a);
                        arrayList.add(hVar);
                        it.remove();
                    }
                } catch (java.lang.Throwable th) {
                    com.tencent.beaconselfupdate.c.a.a(th);
                    com.tencent.beaconselfupdate.c.a.d(" query have error!", new java.lang.Object[0]);
                }
            }
            if (listA.size() > 0) {
                com.tencent.beaconselfupdate.c.a.a(" there are error datas ,should be remove " + listA.size(), new java.lang.Object[0]);
                java.lang.Long[] lArr = new java.lang.Long[listA.size()];
                for (int i2 = 0; i2 < listA.size(); i2++) {
                    lArr[i2] = java.lang.Long.valueOf(((com.tencent.beaconselfupdate.a.a.a) listA.get(i2)).f223a);
                }
                com.tencent.beaconselfupdate.a.a.a.a(context, lArr);
            }
            com.tencent.beaconselfupdate.c.a.a(" RecordDAO.queryRecentRecord() end", new java.lang.Object[0]);
        }
        return arrayList;
    }

    public static synchronized boolean a(android.content.Context context, com.tencent.beaconselfupdate.a.b.g gVar) {
        android.content.ContentValues contentValues;
        boolean z = false;
        if (context == null || gVar == null) {
            com.tencent.beaconselfupdate.c.a.c("context == null || bean == null}", new java.lang.Object[0]);
            return false;
        }
        try {
            android.database.sqlite.SQLiteDatabase writableDatabase = com.tencent.beaconselfupdate.a.a.c.a(context).getWritableDatabase();
            if (writableDatabase == null) {
                com.tencent.beaconselfupdate.c.a.d("get db fail!,return false ", new java.lang.Object[0]);
                return false;
            }
            if (gVar == null) {
                contentValues = null;
            } else {
                contentValues = new android.content.ContentValues();
                if (gVar.a() >= 0) {
                    contentValues.put("_id", java.lang.Long.valueOf(gVar.a()));
                }
                contentValues.put("_key", java.lang.Integer.valueOf(gVar.b()));
                contentValues.put("_datas", gVar.c());
            }
            if (contentValues != null) {
                long jReplace = writableDatabase.replace("t_strategy", "_id", contentValues);
                if (jReplace < 0) {
                    com.tencent.beaconselfupdate.c.a.c("insert failure! return false ", new java.lang.Object[0]);
                } else {
                    gVar.a(jReplace);
                    com.tencent.beaconselfupdate.c.a.e("update strategy  %d true ", java.lang.Integer.valueOf(gVar.b()));
                    z = true;
                }
            }
            return z;
        } catch (java.lang.Throwable th) {
            com.tencent.beaconselfupdate.c.a.d("Error strategy update!  %s", th.toString());
        }
    }

    public static boolean a(android.content.Context context, java.lang.String str, java.lang.Object[] objArr) {
        synchronized (com.tencent.beaconselfupdate.a.a.c.f225a) {
            boolean z = false;
            if (context != null && str != null && objArr != null) {
                if (objArr.length != 0) {
                    try {
                        android.database.sqlite.SQLiteDatabase writableDatabase = com.tencent.beaconselfupdate.a.a.c.a(context).getWritableDatabase();
                        writableDatabase.delete("t_conf", "_key = '" + str + "'", null);
                        android.content.ContentValues contentValues = new android.content.ContentValues();
                        contentValues.put("_key", str);
                        contentValues.put("_value", (java.lang.String) objArr[0]);
                        contentValues.put("_vdate", (java.lang.Long) objArr[1]);
                        contentValues.put("_time", java.lang.Long.valueOf(new java.util.Date().getTime()));
                        if (writableDatabase.insert("t_conf", null, contentValues) < 0) {
                            com.tencent.beaconselfupdate.c.a.d(" insertOrUpdateByKey failure! return false!", new java.lang.Object[0]);
                        } else {
                            z = true;
                        }
                    } catch (java.lang.Exception unused) {
                    }
                    return z;
                }
            }
            return false;
        }
    }

    private static byte[] a(java.lang.Object obj) {
        java.io.ObjectOutputStream objectOutputStream;
        com.tencent.beaconselfupdate.c.a.b("en obj 2 bytes ", new java.lang.Object[0]);
        if (obj == null || !java.io.Serializable.class.isInstance(obj)) {
            com.tencent.beaconselfupdate.c.a.c("not serial obj ", new java.lang.Object[0]);
            return null;
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            objectOutputStream = new java.io.ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(obj);
                objectOutputStream.flush();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    objectOutputStream.close();
                } catch (java.io.IOException e) {
                    com.tencent.beaconselfupdate.c.a.a(e);
                }
                try {
                    byteArrayOutputStream.close();
                } catch (java.io.IOException e2) {
                    com.tencent.beaconselfupdate.c.a.a(e2);
                }
                return byteArray;
            } catch (java.lang.Throwable th) {
                th = th;
                try {
                    com.tencent.beaconselfupdate.c.a.a(th);
                    return null;
                } finally {
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (java.io.IOException e3) {
                            com.tencent.beaconselfupdate.c.a.a(e3);
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (java.io.IOException e4) {
                        com.tencent.beaconselfupdate.c.a.a(e4);
                    }
                }
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            objectOutputStream = null;
        }
    }

    public static byte[] a(java.lang.String str) {
        if (str == null) {
            return null;
        }
        try {
            java.security.interfaces.RSAPublicKey rSAPublicKey = (java.security.interfaces.RSAPublicKey) java.security.KeyFactory.getInstance("RSA", "BC").generatePublic(new java.security.spec.X509EncodedKeySpec(android.util.Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCsAxNCSLyNUCOP1QqYStE8ZeiU\nv4afaMqEmoLCKb0mUZYvYOoVN7LPMi2IVY2MRaFJvuND3glVw1RDm2VJJtjQkwUd\n3kpR9TrHAf7UQOVTpNo3Vi7pXTOqZ6bh3ZA/fs56jDCCKV6+wT/pCeu8N6vVnPrD\nz3SdHIeNeWb/woazCwIDAQAB", 0)));
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, rSAPublicKey);
            return cipher.doFinal(str.getBytes());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] a(java.lang.String str, byte[] bArr) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        if (str == null || bArr == null) {
            return null;
        }
        for (int length = str.length(); length < 16; length++) {
            str = str + "0";
        }
        java.lang.String strSubstring = str.substring(0, 16);
        javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(strSubstring.getBytes(), "[REDACTED]");
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(com.tencent.ysdk.shell.libware.encrypt.AESHelper.DEFAULT_ALGORITHM);
        cipher.init(2, secretKeySpec, new javax.crypto.spec.IvParameterSpec(strSubstring.getBytes()));
        return cipher.doFinal(bArr);
    }

    private static byte[] a(byte[] bArr) throws java.io.IOException {
        java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(bArr);
        java.util.zip.GZIPInputStream gZIPInputStream = new java.util.zip.GZIPInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[1024];
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        while (true) {
            int i = gZIPInputStream.read(bArr2, 0, 1024);
            if (i == -1) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                gZIPInputStream.close();
                byteArrayInputStream.close();
                return byteArray;
            }
            byteArrayOutputStream.write(bArr2, 0, i);
        }
    }

    private static byte[] a(byte[] bArr, int i) {
        if (bArr == null || i == -1) {
            return bArr;
        }
        com.tencent.beaconselfupdate.c.a.b("zp: %s len: %s", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(bArr.length));
        try {
            if (i != 1) {
                if (i == 2) {
                    java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                    java.util.zip.GZIPOutputStream gZIPOutputStream = new java.util.zip.GZIPOutputStream(byteArrayOutputStream);
                    gZIPOutputStream.write(bArr);
                    gZIPOutputStream.finish();
                    gZIPOutputStream.close();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return byteArray;
                }
                return null;
            }
            java.io.ByteArrayOutputStream byteArrayOutputStream2 = new java.io.ByteArrayOutputStream();
            java.util.zip.ZipOutputStream zipOutputStream = new java.util.zip.ZipOutputStream(byteArrayOutputStream2);
            java.util.zip.ZipEntry zipEntry = new java.util.zip.ZipEntry("zip");
            zipEntry.setSize(bArr.length);
            zipOutputStream.putNextEntry(zipEntry);
            zipOutputStream.write(bArr);
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
            byteArrayOutputStream2.close();
            return byteArray2;
        } catch (java.lang.Throwable th) {
            com.tencent.beaconselfupdate.c.a.a(th);
            com.tencent.beaconselfupdate.c.a.d("err zp : %s", th.toString());
        }
    }

    public static byte[] a(byte[] bArr, int i, int i2, java.lang.String str) {
        if (bArr == null) {
            return null;
        }
        try {
            return a(a(bArr, i), i2, str);
        } catch (java.lang.Throwable th) {
            com.tencent.beaconselfupdate.c.a.a(th);
            return null;
        }
    }

    private static byte[] a(byte[] bArr, int i, java.lang.String str) {
        if (bArr == null || i == -1) {
            return bArr;
        }
        com.tencent.beaconselfupdate.c.a.b("enD:} %d %d", java.lang.Integer.valueOf(bArr.length), java.lang.Integer.valueOf(i));
        try {
            if (i != 1) {
                if (i == 3) {
                    return b(str, bArr);
                }
                return null;
            }
            if (str == null || bArr == null) {
                return null;
            }
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("DES/CBC/PKCS5Padding");
            cipher.init(1, javax.crypto.SecretKeyFactory.getInstance("[REDACTED]").generateSecret(new javax.crypto.spec.DESKeySpec(str.getBytes("[REDACTED]"))), new javax.crypto.spec.IvParameterSpec(str.getBytes("[REDACTED]")));
            return cipher.doFinal(bArr);
        } catch (java.lang.Throwable th) {
            com.tencent.beaconselfupdate.c.a.a(th);
            com.tencent.beaconselfupdate.c.a.d("err enD: %s", th.toString());
        }
    }

    public static java.lang.Long[] a(android.content.Context context, java.util.List list) {
        int i = 0;
        com.tencent.beaconselfupdate.c.a.a(" RecordDAO.insertList() start", new java.lang.Object[0]);
        if (context == null || list == null) {
            com.tencent.beaconselfupdate.c.a.d(" insertList() have null args!", new java.lang.Object[0]);
            return null;
        }
        int size = list.size();
        if (size == 0) {
            com.tencent.beaconselfupdate.c.a.b(" list siez == 0 , return true!", new java.lang.Object[0]);
            return null;
        }
        java.lang.Long[] lArr = new java.lang.Long[size];
        java.util.ArrayList<com.tencent.beaconselfupdate.a.a.a> arrayList = new java.util.ArrayList();
        for (int i2 = 0; i2 < size; i2++) {
            com.tencent.beaconselfupdate.event.h hVar = (com.tencent.beaconselfupdate.event.h) list.get(i2);
            if (hVar == null || hVar.b() == null || !hVar.b().equals(com.tencent.beacon.core.event.RDBean.TP_UA)) {
                com.tencent.beaconselfupdate.c.a.d(" bean's type is error!", new java.lang.Object[0]);
            } else {
                try {
                    byte[] bArrA = a((java.lang.Object) hVar);
                    arrayList.add(new com.tencent.beaconselfupdate.a.a.a(hVar.c(), android.util.Base64.encodeToString(bArrA, 0), bArrA.length));
                } catch (java.lang.Throwable th) {
                    com.tencent.beaconselfupdate.c.a.a(th);
                }
            }
        }
        if (!com.tencent.beaconselfupdate.a.a.a.a(context, arrayList)) {
            return null;
        }
        for (com.tencent.beaconselfupdate.a.a.a aVar : arrayList) {
            if (i < size) {
                lArr[i] = java.lang.Long.valueOf(aVar.f223a);
            }
            i++;
        }
        return lArr;
    }

    public static java.lang.Object[] a(android.content.Context context, java.lang.String str) {
        android.database.Cursor cursorQuery;
        synchronized (com.tencent.beaconselfupdate.a.a.c.f225a) {
            android.database.Cursor cursor = null;
            try {
                if (context == null) {
                    com.tencent.beaconselfupdate.c.a.c("context == null ", new java.lang.Object[0]);
                    return null;
                }
                if (str == null) {
                    com.tencent.beaconselfupdate.c.a.c("key == null ", new java.lang.Object[0]);
                    return null;
                }
                try {
                    android.database.sqlite.SQLiteDatabase writableDatabase = com.tencent.beaconselfupdate.a.a.c.a(context).getWritableDatabase();
                    if (writableDatabase == null) {
                        com.tencent.beaconselfupdate.c.a.c("getWritableDatabase fail! ", new java.lang.Object[0]);
                        return null;
                    }
                    cursorQuery = writableDatabase.query("t_conf", null, "_key = '" + str + "'", null, null, null, null);
                    if (cursorQuery != null) {
                        try {
                            if (cursorQuery.moveToNext()) {
                                java.lang.Object[] objArr = {str, cursorQuery.getString(cursorQuery.getColumnIndex("_value")), java.lang.Long.valueOf(cursorQuery.getLong(cursorQuery.getColumnIndex("_vdate")))};
                                if (cursorQuery != null && !cursorQuery.isClosed()) {
                                    cursorQuery.close();
                                }
                                return objArr;
                            }
                        } catch (java.lang.Exception unused) {
                            if (cursorQuery != null && !cursorQuery.isClosed()) {
                            }
                            return null;
                        } catch (java.lang.Throwable th) {
                            cursor = cursorQuery;
                            th = th;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            throw th;
                        }
                    }
                    if (cursorQuery != null && !cursorQuery.isClosed()) {
                        cursorQuery.close();
                    }
                    return null;
                } catch (java.lang.Exception unused2) {
                    cursorQuery = null;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                }
            } catch (java.lang.Throwable th3) {
                throw th3;
            }
        }
    }

    private static java.lang.Object b(byte[] bArr) {
        java.lang.Throwable th;
        java.io.ObjectInputStream objectInputStream;
        com.tencent.beaconselfupdate.c.a.b("de byte 2 obj ", new java.lang.Object[0]);
        if (bArr == null || bArr.length < 0) {
            return null;
        }
        java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(bArr);
        try {
            objectInputStream = new java.io.ObjectInputStream(byteArrayInputStream);
            try {
                java.lang.Object object = objectInputStream.readObject();
                try {
                    objectInputStream.close();
                } catch (java.io.IOException e) {
                    com.tencent.beaconselfupdate.c.a.a(e);
                }
                try {
                    byteArrayInputStream.close();
                } catch (java.io.IOException e2) {
                    com.tencent.beaconselfupdate.c.a.a(e2);
                }
                return object;
            } catch (java.lang.Throwable th2) {
                th = th2;
                try {
                    com.tencent.beaconselfupdate.c.a.a(th);
                    return null;
                } finally {
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (java.io.IOException e3) {
                            com.tencent.beaconselfupdate.c.a.a(e3);
                        }
                    }
                    try {
                        byteArrayInputStream.close();
                    } catch (java.io.IOException e4) {
                        com.tencent.beaconselfupdate.c.a.a(e4);
                    }
                }
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            objectInputStream = null;
        }
    }

    public static java.lang.String b() {
        try {
            return android.os.Build.VERSION.RELEASE;
        } catch (java.lang.Throwable th) {
            com.tencent.beaconselfupdate.c.a.d("getVersion error", new java.lang.Object[0]);
            com.tencent.beaconselfupdate.c.a.a(th);
            return "";
        }
    }

    public static java.lang.String b(android.content.Context context) {
        java.lang.String lowerCase = "";
        if (context == null) {
            com.tencent.beaconselfupdate.c.a.d("getImei but context == null!", new java.lang.Object[0]);
            return "";
        }
        try {
            if (com.tencent.beaconselfupdate.a.a.f(context)) {
                java.lang.String deviceId = ((android.telephony.TelephonyManager) context.getSystemService("phone")).getDeviceId();
                lowerCase = deviceId == null ? "" : deviceId.toLowerCase();
            }
            com.tencent.beaconselfupdate.c.a.a("IMEI:" + lowerCase, new java.lang.Object[0]);
        } catch (java.lang.Throwable unused) {
            com.tencent.beaconselfupdate.c.a.d("getImei error!", new java.lang.Object[0]);
        }
        return lowerCase;
    }

    public static java.lang.String b(android.content.Context context, int i) {
        try {
            com.tencent.beaconselfupdate.event.c cVarA = com.tencent.beaconselfupdate.event.c.a(context);
            return h(cVarA.a() + "_" + cVarA.b() + "_" + new java.util.Date().getTime() + "_" + i);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static java.lang.String b(java.lang.String str) {
        java.lang.String strTrim = str.replace('|', '_').trim();
        if (d(strTrim)) {
            if (strTrim.length() < 5) {
                com.tencent.beaconselfupdate.c.a.c(" userID is invalid!! userID is too short, length < 5!", new java.lang.Object[0]);
            }
            return strTrim.length() > 128 ? strTrim.substring(0, 128) : strTrim;
        }
        com.tencent.beaconselfupdate.c.a.c("userID is invalid!! userID should be ASCII code in 32-126! userID:" + str, new java.lang.Object[0]);
        return "10000";
    }

    private static byte[] b(java.lang.String str, byte[] bArr) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        if (str == null || bArr == null) {
            return null;
        }
        for (int length = str.length(); length < 16; length++) {
            str = str + "0";
        }
        java.lang.String strSubstring = str.substring(0, 16);
        javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(strSubstring.getBytes(), "[REDACTED]");
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(com.tencent.ysdk.shell.libware.encrypt.AESHelper.DEFAULT_ALGORITHM);
        cipher.init(1, secretKeySpec, new javax.crypto.spec.IvParameterSpec(strSubstring.getBytes()));
        return cipher.doFinal(bArr);
    }

    private static byte[] b(byte[] bArr, int i) {
        if (bArr == null || i == -1) {
            return bArr;
        }
        com.tencent.beaconselfupdate.c.a.b("unzp: %s len: %s", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(bArr.length));
        try {
            if (i != 1) {
                if (i == 2) {
                    return a(bArr);
                }
                return null;
            }
            java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(bArr);
            java.util.zip.ZipInputStream zipInputStream = new java.util.zip.ZipInputStream(byteArrayInputStream);
            byte[] byteArray = null;
            while (zipInputStream.getNextEntry() != null) {
                byte[] bArr2 = new byte[1024];
                java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                while (true) {
                    int i2 = zipInputStream.read(bArr2, 0, 1024);
                    if (i2 != -1) {
                        byteArrayOutputStream.write(bArr2, 0, i2);
                    }
                }
                byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
            }
            zipInputStream.close();
            byteArrayInputStream.close();
            return byteArray;
        } catch (java.lang.Throwable th) {
            com.tencent.beaconselfupdate.c.a.a(th);
            com.tencent.beaconselfupdate.c.a.d("err unzp}" + th.toString(), new java.lang.Object[0]);
        }
    }

    public static byte[] b(byte[] bArr, int i, int i2, java.lang.String str) {
        try {
            return b(b(bArr, i2, str), i);
        } catch (java.lang.Exception e) {
            com.tencent.beaconselfupdate.c.a.a(e);
            return null;
        }
    }

    private static byte[] b(byte[] bArr, int i, java.lang.String str) {
        if (bArr == null || i == -1) {
            return bArr;
        }
        try {
            if (i != 1) {
                if (i == 3) {
                    return a(str, bArr);
                }
                return null;
            }
            if (str == null || bArr == null) {
                return null;
            }
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("DES/CBC/PKCS5Padding");
            cipher.init(2, javax.crypto.SecretKeyFactory.getInstance("[REDACTED]").generateSecret(new javax.crypto.spec.DESKeySpec(str.getBytes("[REDACTED]"))), new javax.crypto.spec.IvParameterSpec(str.getBytes("[REDACTED]")));
            return cipher.doFinal(bArr);
        } catch (java.lang.Throwable th) {
            com.tencent.beaconselfupdate.c.a.a(th);
            com.tencent.beaconselfupdate.c.a.d("err unD: %s", th.toString());
        }
    }

    public static java.lang.String c() {
        try {
            return android.os.Build.VERSION.SDK;
        } catch (java.lang.Throwable th) {
            com.tencent.beaconselfupdate.c.a.d("getApiLevel error", new java.lang.Object[0]);
            com.tencent.beaconselfupdate.c.a.a(th);
            return "";
        }
    }

    public static java.lang.String c(android.content.Context context) {
        java.lang.String subscriberId;
        if (context == null) {
            com.tencent.beaconselfupdate.c.a.d("getImsi but context == null!", new java.lang.Object[0]);
            return "";
        }
        try {
            return (!com.tencent.beaconselfupdate.a.a.f(context) || (subscriberId = ((android.telephony.TelephonyManager) context.getSystemService("phone")).getSubscriberId()) == null) ? "" : subscriberId.toLowerCase();
        } catch (java.lang.Throwable unused) {
            com.tencent.beaconselfupdate.c.a.d("getImsi error!", new java.lang.Object[0]);
            return "";
        }
    }

    public static java.lang.String c(java.lang.String str) {
        boolean z;
        if (str != null && str.trim().length() != 0) {
            java.lang.String strTrim = str.trim();
            int length = strTrim.length();
            while (true) {
                length--;
                if (length < 0) {
                    z = true;
                    break;
                }
                char cCharAt = strTrim.charAt(length);
                if (cCharAt < '0' || cCharAt > '9') {
                    z = false;
                    break;
                }
            }
            if (z) {
                java.lang.String strTrim2 = str.trim();
                return strTrim2.length() > 16 ? strTrim2.substring(0, 16) : strTrim2;
            }
            com.tencent.beaconselfupdate.c.a.c("channelID is invalid!! channelID should be Numeric! channelID:" + str, new java.lang.Object[0]);
        }
        return android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
    }

    public static java.lang.String d() {
        try {
            return android.os.Build.BRAND;
        } catch (java.lang.Throwable th) {
            com.tencent.beaconselfupdate.c.a.d("getBrand error!", new java.lang.Object[0]);
            com.tencent.beaconselfupdate.c.a.a(th);
            return null;
        }
    }

    public static java.lang.String d(android.content.Context context) {
        if (context == null) {
            com.tencent.beaconselfupdate.c.a.d("getAndroidId but context == null!", new java.lang.Object[0]);
            return "";
        }
        try {
            java.lang.String string = android.provider.Settings.Secure.getString(context.getContentResolver(), com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_ANDROID_ID_PHONE);
            return string == null ? "" : string.toLowerCase();
        } catch (java.lang.Throwable th) {
            com.tencent.beaconselfupdate.c.a.d("getAndroidId error!", new java.lang.Object[0]);
            com.tencent.beaconselfupdate.c.a.a(th);
            return "";
        }
    }

    public static boolean d(java.lang.String str) {
        int length = str.length();
        boolean z = true;
        while (true) {
            length--;
            if (length < 0) {
                return z;
            }
            char cCharAt = str.charAt(length);
            if (cCharAt < ' ' || cCharAt >= 127) {
                z = false;
            }
        }
    }

    public static java.lang.String e() {
        try {
            android.os.StatFs statFs = new android.os.StatFs(android.os.Environment.getDataDirectory().getPath());
            long blockSize = statFs.getBlockSize();
            long blockCount = statFs.getBlockCount();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(((blockCount * blockSize) / 1024) / 1024);
            return sb.toString();
        } catch (java.lang.Throwable th) {
            com.tencent.beaconselfupdate.c.a.d("getDisplayMetrics error!", new java.lang.Object[0]);
            com.tencent.beaconselfupdate.c.a.a(th);
            return null;
        }
    }

    public static java.lang.String e(android.content.Context context) {
        java.lang.String strTrim = "";
        if (context == null) {
            com.tencent.beaconselfupdate.c.a.d("getMacAddress but context == null!", new java.lang.Object[0]);
            return "";
        }
        try {
            if (java.lang.Integer.valueOf(android.os.Build.VERSION.SDK).intValue() >= 23) {
                java.lang.String[] strArr = {"/sys/class/net/wlan0/address", "/sys/devices/virtual/net/wlan0/address"};
                for (int i = 0; i < 2; i++) {
                    strTrim = f(strArr[i]).toString().trim();
                    if (strTrim == null || strTrim.length() <= 0) {
                    }
                }
                return strTrim;
            }
            strTrim = ((android.net.wifi.WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
            if (strTrim == null) {
                return "";
            }
            return strTrim.toLowerCase();
        } catch (java.lang.Throwable th) {
            com.tencent.beaconselfupdate.c.a.a(th);
        }
    }

    public static java.util.Date e(java.lang.String str) {
        if (str != null && str.trim().length() > 0) {
            try {
                return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.US).parse(str);
            } catch (java.text.ParseException e) {
                com.tencent.beaconselfupdate.c.a.a(e);
            }
        }
        return null;
    }

    public static java.lang.String f() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        try {
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.FileReader(new java.io.File("/sys/block/mmcblk0/device/type")));
            java.lang.String line = bufferedReader.readLine();
            bufferedReader.close();
            sb.append(line);
            sb.append(",");
            java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(new java.io.FileReader(new java.io.File("/sys/block/mmcblk0/device/name")));
            java.lang.String line2 = bufferedReader2.readLine();
            bufferedReader2.close();
            sb.append(line2);
            sb.append(",");
            java.io.BufferedReader bufferedReader3 = new java.io.BufferedReader(new java.io.FileReader(new java.io.File("/sys/block/mmcblk0/device/cid")));
            java.lang.String line3 = bufferedReader3.readLine();
            bufferedReader3.close();
            sb.append(line3);
        } catch (java.lang.Exception e) {
            com.tencent.beaconselfupdate.c.a.a(e);
        }
        return sb.toString();
    }

    public static java.lang.String f(android.content.Context context) {
        return f238a != null ? g(context) : android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
    }

    public static java.lang.String f(java.lang.String str) {
        java.lang.String string = "";
        try {
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(str);
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            string = org.apache.http.util.EncodingUtils.getString(bArr, "UTF-8");
            fileInputStream.close();
            return string;
        } catch (java.lang.Exception unused) {
            com.tencent.beaconselfupdate.c.a.d("Read file %s failed.", str);
            return string;
        }
    }

    public static java.lang.String g() {
        try {
            return new java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.US).format(new java.util.Date());
        } catch (java.lang.Throwable th) {
            com.tencent.beaconselfupdate.c.a.a(th);
            return "";
        }
    }

    public static java.lang.String g(android.content.Context context) {
        android.telephony.TelephonyManager telephonyManager;
        java.lang.String str;
        try {
            android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
            }
            if (activeNetworkInfo.getType() != 1) {
                if (activeNetworkInfo.getType() == 0 && (telephonyManager = (android.telephony.TelephonyManager) context.getSystemService("phone")) != null) {
                    switch (telephonyManager.getNetworkType()) {
                        case 1:
                            str = "GPRS";
                            break;
                        case 2:
                            str = "EDGE";
                            break;
                        case 3:
                            str = "UMTS";
                            break;
                        case 4:
                            str = "CDMA";
                            break;
                        case 5:
                            str = "EVDO_0";
                            break;
                        case 6:
                            str = "EVDO_A";
                            break;
                        case 7:
                            str = "1xRTT";
                            break;
                        case 8:
                            str = "HSDPA";
                            break;
                        case 9:
                            str = "HSUPA";
                            break;
                        case 10:
                            str = "HSPA";
                            break;
                        case 11:
                            str = "iDen";
                            break;
                        case 12:
                            str = "EVDO_B";
                            break;
                        case 13:
                            str = "LTE";
                            break;
                        case 14:
                            str = "eHRPD";
                            break;
                        case 15:
                            str = "HSPA+";
                            break;
                        default:
                            str = android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
                            break;
                    }
                } else {
                    return android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
                }
            } else {
                str = "wifi";
            }
            return str;
        } catch (java.lang.Exception e) {
            com.tencent.beaconselfupdate.c.a.a(e);
            return android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
        }
    }

    private static java.lang.String g(java.lang.String str) {
        try {
            byte[] bArrDigest = java.security.MessageDigest.getInstance("MD5").digest(str.getBytes());
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            for (byte b : bArrDigest) {
                int i = b & 255;
                if (i < 16) {
                    stringBuffer.append(0);
                }
                stringBuffer.append(java.lang.Integer.toHexString(i));
            }
            return stringBuffer.toString();
        } catch (java.lang.Exception e) {
            com.tencent.beaconselfupdate.c.a.a(e);
            return str;
        }
    }

    public static synchronized com.tencent.beaconselfupdate.a.b.g h(android.content.Context context) {
        java.lang.Throwable th;
        android.database.Cursor cursorQuery;
        com.tencent.beaconselfupdate.a.b.g gVar = null;
        if (context == null) {
            com.tencent.beaconselfupdate.c.a.c("context == null}", new java.lang.Object[0]);
            return null;
        }
        try {
            android.database.sqlite.SQLiteDatabase writableDatabase = com.tencent.beaconselfupdate.a.a.c.a(context).getWritableDatabase();
            if (writableDatabase == null) {
                com.tencent.beaconselfupdate.c.a.c("getWritableDatabase fail! ", new java.lang.Object[0]);
                return null;
            }
            cursorQuery = writableDatabase.query("t_strategy", null, java.lang.String.format(java.util.Locale.US, " %s = %d ", "_key", 101), null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToNext()) {
                        if (cursorQuery != null && !cursorQuery.isBeforeFirst() && !cursorQuery.isAfterLast()) {
                            com.tencent.beaconselfupdate.c.a.b("parse bean}", new java.lang.Object[0]);
                            com.tencent.beaconselfupdate.a.b.g gVar2 = new com.tencent.beaconselfupdate.a.b.g();
                            gVar2.a(cursorQuery.getLong(cursorQuery.getColumnIndex("_id")));
                            gVar2.a(cursorQuery.getInt(cursorQuery.getColumnIndex("_key")));
                            gVar2.a(cursorQuery.getBlob(cursorQuery.getColumnIndex("_datas")));
                            gVar = gVar2;
                        }
                        if (gVar != null) {
                            com.tencent.beaconselfupdate.c.a.g("read strategy key: %d", java.lang.Integer.valueOf(gVar.b()));
                        }
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    try {
                        com.tencent.beaconselfupdate.c.a.a(th);
                        if (cursorQuery != null && !cursorQuery.isClosed()) {
                        }
                        return gVar;
                    } catch (java.lang.Throwable th3) {
                        if (cursorQuery != null && !cursorQuery.isClosed()) {
                            cursorQuery.close();
                        }
                        throw th3;
                    }
                }
            }
            if (cursorQuery != null && !cursorQuery.isClosed()) {
                cursorQuery.close();
            }
            return gVar;
        } catch (java.lang.Throwable th4) {
            th = th4;
            cursorQuery = null;
        }
    }

    private static java.lang.String h(java.lang.String str) {
        java.lang.String strG = g(str);
        if (strG == null) {
            return strG;
        }
        try {
            return strG.substring(8, 24);
        } catch (java.lang.Exception unused) {
            return strG;
        }
    }

    public static synchronized int i(android.content.Context context) {
        int i = 0;
        try {
            if (context == null) {
                com.tencent.beaconselfupdate.c.a.c("context == null ||key < -1}", new java.lang.Object[0]);
                return 0;
            }
            try {
                android.database.sqlite.SQLiteDatabase writableDatabase = com.tencent.beaconselfupdate.a.a.c.a(context).getWritableDatabase();
                if (writableDatabase == null) {
                    com.tencent.beaconselfupdate.c.a.d("get db fail!,return ", new java.lang.Object[0]);
                    return 0;
                }
                int iDelete = writableDatabase.delete("t_strategy", java.lang.String.format("%s = %d", "_key", 101), null);
                try {
                    com.tencent.beaconselfupdate.c.a.g("delete Strategy key} %d , num} %d", 101, java.lang.Integer.valueOf(iDelete));
                } catch (java.lang.Throwable th) {
                    i = iDelete;
                    th = th;
                    com.tencent.beaconselfupdate.c.a.a(th);
                    iDelete = i;
                }
                return iDelete;
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.lang.Throwable th3) {
            throw th3;
        }
    }

    public static int j(android.content.Context context) {
        com.tencent.beaconselfupdate.c.a.a(" RecordDAO.countRecordNum() start", new java.lang.Object[0]);
        if (context != null) {
            return com.tencent.beaconselfupdate.a.a.a.b(context, new int[]{1});
        }
        com.tencent.beaconselfupdate.c.a.d(" countRecordNum() have null args!", new java.lang.Object[0]);
        return -1;
    }

    public static java.lang.String k(android.content.Context context) {
        try {
            java.lang.String strD = com.tencent.beaconselfupdate.event.c.a(context).d();
            com.tencent.beaconselfupdate.a.c cVarM = com.tencent.beaconselfupdate.a.c.m();
            return h((cVarM != null ? cVarM.j() : "") + "_" + strD + "_" + new java.util.Date().getTime() + "_" + ((int) (java.lang.Math.random() * 2.147483647E9d)));
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static boolean l(android.content.Context context) {
        android.net.NetworkInfo networkInfoO = o(context);
        return networkInfoO != null && networkInfoO.getType() == 1;
    }

    public static boolean m(android.content.Context context) {
        android.net.NetworkInfo networkInfoO = o(context);
        return networkInfoO != null && networkInfoO.isConnected();
    }

    public static java.lang.String n(android.content.Context context) {
        android.net.NetworkInfo networkInfoO = o(context);
        if (networkInfoO == null) {
            return android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
        }
        if (networkInfoO.getType() == 1) {
            return "wifi";
        }
        java.lang.String extraInfo = networkInfoO.getExtraInfo();
        return (extraInfo == null || extraInfo.length() <= 64) ? extraInfo : extraInfo.substring(0, 64);
    }

    private static android.net.NetworkInfo o(android.content.Context context) {
        try {
            android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return null;
            }
            return connectivityManager.getActiveNetworkInfo();
        } catch (java.lang.Throwable th) {
            com.tencent.beaconselfupdate.c.a.a(th);
            return null;
        }
    }
}
