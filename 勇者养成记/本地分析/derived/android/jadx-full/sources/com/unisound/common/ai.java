package com.unisound.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ai {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f1469a = true;
    private static final java.lang.String b = "ResultToJsonUtil";

    public static org.json.JSONObject a(java.io.InputStream inputStream, float f) throws org.json.JSONException {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        org.json.JSONArray jSONArray2 = new org.json.JSONArray();
        org.w3c.dom.NodeList childNodes = ((org.w3c.dom.Element) javax.xml.parsers.DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream).getChildNodes().item(0)).getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            if (childNodes.item(i).getNodeType() == 1) {
                a(new org.json.JSONObject(), jSONArray, new org.json.JSONArray(), 0.0f, childNodes.item(i).getNodeName(), childNodes.item(i).getFirstChild().getNodeValue());
            }
        }
        jSONObject.put("l", jSONArray);
        jSONObject.put("score", f);
        jSONArray2.put(jSONObject);
        return new org.json.JSONObject().put("c", jSONArray2);
    }

    public static org.json.JSONObject a(java.lang.String str, float f, java.lang.String str2) throws org.json.JSONException {
        a(str2, str);
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        org.json.JSONArray jSONArray2 = new org.json.JSONArray();
        org.w3c.dom.NodeList childNodes = javax.xml.parsers.DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new java.io.File(str2)).getChildNodes();
        if (f1469a) {
            com.unisound.common.y.c(b, "FileUtiles -Node.length =", java.lang.Integer.valueOf(childNodes.getLength()), ", node:value =", childNodes.item(0).getNodeName());
        }
        org.w3c.dom.Element element = (org.w3c.dom.Element) childNodes.item(0);
        org.w3c.dom.NodeList childNodes2 = element.getChildNodes();
        if (f1469a) {
            com.unisound.common.y.c(b, "FileUtiles -childElement =", element.getNodeValue());
        }
        for (int i = 0; i < childNodes2.getLength(); i++) {
            if (childNodes2.item(i).getNodeType() == 1) {
                a(new org.json.JSONObject(), jSONArray, new org.json.JSONArray(), 0.0f, childNodes2.item(i).getNodeName().replace("_", ""), childNodes2.item(i).getFirstChild().getNodeValue());
            }
        }
        jSONObject.put("l", jSONArray);
        jSONObject.put("score", f);
        jSONArray2.put(jSONObject);
        return new org.json.JSONObject().put("c", jSONArray2);
    }

    public static void a(java.lang.String str, java.lang.String str2) {
        try {
            java.lang.String str3 = "<?xml version='1.0' encoding='utf-8'?>" + str2.replace("[", "").replace("]", "").trim();
            if (f1469a) {
                com.unisound.common.y.c(b, "xmlText = ", str3);
            }
            a(new java.io.File(str));
            java.io.FileWriter fileWriter = new java.io.FileWriter(str, true);
            fileWriter.write(str3);
            fileWriter.flush();
            fileWriter.close();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private static void a(org.json.JSONObject jSONObject, org.json.JSONArray jSONArray, org.json.JSONArray jSONArray2, float f, java.lang.String str, java.lang.String str2) {
        try {
            jSONObject.put("s", f);
            jSONObject.put("t", str);
            jSONObject.put("w", str2);
            jSONArray2.put(jSONObject);
            jSONArray.put(new org.json.JSONObject().put("c", jSONArray2));
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }

    private static boolean a(java.io.File file) {
        if (!file.exists()) {
            b(file.getParentFile());
        }
        file.delete();
        return file.createNewFile();
    }

    public static org.json.JSONObject b(java.lang.String str, float f, java.lang.String str2) throws org.xmlpull.v1.XmlPullParserException, org.json.JSONException {
        org.xmlpull.v1.XmlPullParser xmlPullParser;
        java.lang.String strSubstring;
        if (f1469a) {
            com.unisound.common.y.c("ResultTOJsonUtil", "result before format : ", str);
        }
        java.lang.String strTrim = str.replace("[", "").replace("]", "").trim();
        a(str2, str);
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        org.json.JSONArray jSONArray2 = new org.json.JSONArray();
        org.xmlpull.v1.XmlPullParser xmlPullParserNewPullParser = org.xmlpull.v1.XmlPullParserFactory.newInstance().newPullParser();
        xmlPullParserNewPullParser.setInput(new java.io.FileInputStream(new java.io.File(str2)), com.unisound.b.f.b);
        int eventType = xmlPullParserNewPullParser.getEventType();
        while (eventType != 1) {
            if (eventType != 0) {
                switch (eventType) {
                    case 2:
                        if (f1469a) {
                            com.unisound.common.y.c("ResultTOJsonUtil", "START_TAG : ", xmlPullParserNewPullParser.getName());
                        }
                        java.lang.String name = xmlPullParserNewPullParser.getName();
                        if (!"s".equals(xmlPullParserNewPullParser.getName())) {
                            java.lang.String name2 = xmlPullParserNewPullParser.getName();
                            try {
                                strSubstring = xmlPullParserNewPullParser.nextText();
                                break;
                            } catch (java.lang.Exception e) {
                                com.unisound.common.y.e("ResultTOJsonUtil", name, "的nextText不存在或其TAG没有正常结束 ********");
                                e.printStackTrace();
                                strSubstring = strTrim.substring(strTrim.lastIndexOf(">") + 1);
                                com.unisound.common.y.e("ResultTOJsonUtil", "MissedTagValue =", strSubstring);
                                if ("".equals(strSubstring)) {
                                    strSubstring = "";
                                } else if (strSubstring.contains("<")) {
                                    strSubstring = strSubstring.substring(0, strSubstring.indexOf("<"));
                                }
                            }
                            if (!"".endsWith(strSubstring)) {
                                if (f1469a) {
                                    com.unisound.common.y.c("ResultTOJsonUtil", "START_TAG : tagName =", name2, ", tagValue =", strSubstring);
                                }
                                xmlPullParser = xmlPullParserNewPullParser;
                                a(new org.json.JSONObject(), jSONArray, new org.json.JSONArray(), 0.0f, name2, strSubstring);
                            }
                        }
                        break;
                    case 3:
                        if (f1469a) {
                            com.unisound.common.y.c("ResultTOJsonUtil", "END_TAG : ", xmlPullParserNewPullParser.getName());
                        }
                        break;
                }
                xmlPullParser = xmlPullParserNewPullParser;
            } else {
                xmlPullParser = xmlPullParserNewPullParser;
                if (f1469a) {
                    com.unisound.common.y.c("ResultTOJsonUtil", "START_DOCUMENT : ", xmlPullParser.getName());
                }
            }
            try {
                eventType = xmlPullParser.next();
                xmlPullParserNewPullParser = xmlPullParser;
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
                com.unisound.common.y.e("ResultTOJsonUtil", "TAG 名称不全 ****************");
            }
        }
        jSONObject.put("l", jSONArray);
        jSONObject.put("score", f);
        jSONArray2.put(jSONObject);
        return new org.json.JSONObject().put("c", jSONArray2);
    }

    private static void b(java.io.File file) {
        if (!file.getParentFile().exists()) {
            b(file.getParentFile());
        }
        file.mkdir();
    }
}
