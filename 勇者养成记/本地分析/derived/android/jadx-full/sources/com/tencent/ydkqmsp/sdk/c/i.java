package com.tencent.ydkqmsp.sdk.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class i {
    private static final byte[][] c = {new byte[]{20, 67, -74, 67, 2, 50, 117, -18}, new byte[]{51, 117, -95, 83, 39, 52, 121}, new byte[]{9, 121, -79, 101, 32, 47, 101, -28}, new byte[]{44, 116}, new byte[]{49, 105, -93, 69}, new byte[]{35, 124, -78, 71, 61}, new byte[]{53, 113, -89, 72}, new byte[]{43, 113, -66, 69}, new byte[]{51, 113, -65, 85, 43}, new byte[]{51, 117, -95}, new byte[]{20, 125, -96, 80, 96, 63, 118, -23}};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.util.List f1318a;
    private int b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1319a;
        int b;
        int c;
        java.lang.String d;
        java.lang.String e;
    }

    public i() throws java.lang.Throwable {
        this.b = 1;
        android.util.Pair pairA = a(c(), 1);
        if (pairA != null) {
            this.b = ((java.lang.Integer) pairA.first).intValue();
            this.f1318a = (java.util.List) pairA.second;
        }
        if (this.f1318a == null) {
            this.f1318a = new java.util.LinkedList();
        }
    }

    private int a(org.w3c.dom.Element element) {
        try {
            org.w3c.dom.NamedNodeMap attributes = element.getAttributes();
            if (attributes == null) {
                return 0;
            }
            for (int i = 0; i < attributes.getLength(); i++) {
                org.w3c.dom.Node nodeItem = attributes.item(i);
                java.lang.String nodeName = nodeItem.getNodeName();
                if (nodeName != null && nodeName.equalsIgnoreCase(b(1))) {
                    return java.lang.Integer.parseInt(nodeItem.getNodeValue());
                }
            }
            return 0;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private android.util.Pair a(java.lang.String str, int i) throws java.lang.Throwable {
        byte[] bArrA = new com.tencent.ydkqmsp.sdk.c.l().a(str, null, 1);
        if (bArrA != null) {
            return a(bArrA, i);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:59:0x0096 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0093: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:49:0x0093 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private android.util.Pair a(byte[] bArr, int i) throws java.lang.Throwable {
        java.io.ByteArrayInputStream byteArrayInputStream;
        java.io.ByteArrayInputStream byteArrayInputStream2;
        java.lang.String nodeName;
        com.tencent.ydkqmsp.sdk.c.i.a aVarA;
        java.io.ByteArrayInputStream byteArrayInputStream3 = null;
        try {
            try {
                javax.xml.parsers.DocumentBuilder documentBuilderNewDocumentBuilder = javax.xml.parsers.DocumentBuilderFactory.newInstance().newDocumentBuilder();
                byteArrayInputStream = new java.io.ByteArrayInputStream(bArr);
                try {
                    org.w3c.dom.Element documentElement = documentBuilderNewDocumentBuilder.parse(byteArrayInputStream).getDocumentElement();
                    int iA = a(documentElement);
                    if (iA != 0 && iA <= i) {
                        java.util.LinkedList linkedList = new java.util.LinkedList();
                        org.w3c.dom.NodeList childNodes = documentElement.getChildNodes();
                        int length = childNodes.getLength();
                        for (int i2 = 0; i2 < length; i2++) {
                            org.w3c.dom.Node nodeItem = childNodes.item(i2);
                            if (nodeItem.getNodeType() == 1 && (nodeName = nodeItem.getNodeName()) != null && nodeName.equalsIgnoreCase(b(2)) && (aVarA = a(nodeItem)) != null) {
                                linkedList.add(aVarA);
                            }
                        }
                        android.util.Pair pair = new android.util.Pair(java.lang.Integer.valueOf(iA), linkedList);
                        try {
                            byteArrayInputStream.close();
                        } catch (java.io.IOException e) {
                            e.printStackTrace();
                        }
                        return pair;
                    }
                    android.util.Pair pair2 = new android.util.Pair(java.lang.Integer.valueOf(iA), null);
                    try {
                        byteArrayInputStream.close();
                    } catch (java.io.IOException e2) {
                        e2.printStackTrace();
                    }
                    return pair2;
                } catch (java.lang.Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (java.io.IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    return null;
                }
            } catch (java.lang.Throwable th) {
                th = th;
                byteArrayInputStream3 = byteArrayInputStream2;
                if (byteArrayInputStream3 != null) {
                    try {
                        byteArrayInputStream3.close();
                    } catch (java.io.IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (java.lang.Exception e6) {
            e = e6;
            byteArrayInputStream = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            if (byteArrayInputStream3 != null) {
                byteArrayInputStream3.close();
            }
            throw th;
        }
    }

    private com.tencent.ydkqmsp.sdk.c.i.a a(org.w3c.dom.Node node) {
        try {
            org.w3c.dom.NamedNodeMap attributes = node.getAttributes();
            if (attributes == null) {
                return null;
            }
            com.tencent.ydkqmsp.sdk.c.i.a aVar = new com.tencent.ydkqmsp.sdk.c.i.a();
            int length = attributes.getLength();
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                org.w3c.dom.Node nodeItem = attributes.item(i2);
                if (nodeItem.getNodeType() == 2) {
                    java.lang.String nodeName = nodeItem.getNodeName();
                    java.lang.String nodeValue = nodeItem.getNodeValue();
                    if (nodeName != null && nodeValue != null) {
                        if (nodeName.equalsIgnoreCase(b(3))) {
                            aVar.f1319a = java.lang.Integer.parseInt(nodeValue);
                        } else if (nodeName.equalsIgnoreCase(b(4))) {
                            aVar.b = java.lang.Integer.parseInt(nodeValue);
                        } else if (nodeName.equalsIgnoreCase(b(5))) {
                            aVar.c = java.lang.Integer.parseInt(nodeValue);
                        } else if (nodeName.equalsIgnoreCase(b(6))) {
                            aVar.e = nodeValue;
                        } else if (nodeName.equalsIgnoreCase(b(9))) {
                            aVar.d = nodeValue;
                        }
                        i++;
                    }
                }
            }
            if (i != 5) {
                return null;
            }
            b(node);
            return aVar;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean a(java.lang.String str, int i, java.util.List list) throws java.lang.Throwable {
        byte[] bArrA = a(i, list);
        if (bArrA == null) {
            return false;
        }
        return new com.tencent.ydkqmsp.sdk.c.l().a(str, bArrA, null, 1);
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00b6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x00b3: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:29:0x00b3 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private byte[] a(int i, java.util.List list) throws java.lang.Throwable {
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.io.ByteArrayOutputStream byteArrayOutputStream2;
        java.io.ByteArrayOutputStream byteArrayOutputStream3 = null;
        try {
            try {
                org.xmlpull.v1.XmlSerializer xmlSerializerNewSerializer = android.util.Xml.newSerializer();
                byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                try {
                    xmlSerializerNewSerializer.setOutput(byteArrayOutputStream, "UTF-8");
                    xmlSerializerNewSerializer.startDocument(null, java.lang.Boolean.TRUE);
                    xmlSerializerNewSerializer.startTag(null, b(0));
                    xmlSerializerNewSerializer.attribute(null, b(1), java.lang.Integer.toString(i));
                    java.util.Iterator it = list.iterator();
                    while (it.hasNext()) {
                        com.tencent.ydkqmsp.sdk.c.i.a aVar = (com.tencent.ydkqmsp.sdk.c.i.a) it.next();
                        xmlSerializerNewSerializer.startTag(null, b(2));
                        xmlSerializerNewSerializer.attribute(null, b(3), java.lang.Integer.toString(aVar.f1319a));
                        xmlSerializerNewSerializer.attribute(null, b(4), java.lang.Integer.toString(aVar.b));
                        xmlSerializerNewSerializer.attribute(null, b(5), java.lang.Integer.toString(aVar.c));
                        xmlSerializerNewSerializer.attribute(null, b(9), aVar.d);
                        xmlSerializerNewSerializer.attribute(null, b(6), aVar.e);
                        xmlSerializerNewSerializer.endTag(null, b(2));
                    }
                    xmlSerializerNewSerializer.endTag(null, b(0));
                    xmlSerializerNewSerializer.endDocument();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                    } catch (java.io.IOException e) {
                        e.printStackTrace();
                    }
                    return byteArray;
                } catch (java.lang.Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (java.io.IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return null;
                }
            } catch (java.lang.Throwable th) {
                th = th;
                byteArrayOutputStream3 = byteArrayOutputStream2;
                if (byteArrayOutputStream3 != null) {
                    try {
                        byteArrayOutputStream3.close();
                    } catch (java.io.IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (java.lang.Exception e5) {
            e = e5;
            byteArrayOutputStream = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            if (byteArrayOutputStream3 != null) {
                byteArrayOutputStream3.close();
            }
            throw th;
        }
    }

    private android.os.Bundle b(org.w3c.dom.Node node) {
        org.w3c.dom.NamedNodeMap attributes;
        org.w3c.dom.Node namedItem;
        java.lang.String nodeValue;
        org.w3c.dom.Node namedItem2;
        java.lang.String nodeValue2;
        try {
            android.os.Bundle bundle = new android.os.Bundle();
            org.w3c.dom.NodeList childNodes = node.getChildNodes();
            int length = childNodes.getLength();
            for (int i = 0; i < length; i++) {
                org.w3c.dom.Node nodeItem = childNodes.item(i);
                if (nodeItem.getNodeType() == 1 && (attributes = nodeItem.getAttributes()) != null && (namedItem = attributes.getNamedItem(b(7))) != null && namedItem.getNodeType() == 2 && (nodeValue = namedItem.getNodeValue()) != null && (namedItem2 = attributes.getNamedItem(b(8))) != null && namedItem2.getNodeType() == 2 && (nodeValue2 = namedItem2.getNodeValue()) != null) {
                    bundle.putString(nodeValue, nodeValue2);
                }
            }
            return bundle;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private java.lang.String b(int i) {
        return com.tencent.ydkqmsp.sdk.f.k.a(c[i]);
    }

    private java.lang.String c() {
        return com.tencent.ydkqmsp.sdk.a.b.a() + java.io.File.separator + b(10);
    }

    private boolean c(int i) {
        return d(i) != null;
    }

    private com.tencent.ydkqmsp.sdk.c.i.a d(int i) {
        for (com.tencent.ydkqmsp.sdk.c.i.a aVar : this.f1318a) {
            if (aVar.f1319a == i) {
                return aVar;
            }
        }
        return null;
    }

    public com.tencent.ydkqmsp.sdk.c.i.a a(int i) {
        return d(i);
    }

    public void a(int i, boolean z) throws java.lang.Throwable {
        com.tencent.ydkqmsp.sdk.c.i.a aVarD = d(i);
        if (aVarD == null) {
            return;
        }
        this.f1318a.remove(aVarD);
        if (z) {
            a(c(), this.b, this.f1318a);
        }
    }

    public boolean a() {
        return a(c(), this.b, this.f1318a);
    }

    public boolean a(com.tencent.ydkqmsp.sdk.c.i.a aVar, boolean z) {
        if (c(aVar.f1319a)) {
            return false;
        }
        this.f1318a.add(aVar);
        if (z) {
            return a();
        }
        return true;
    }

    public java.util.List b() {
        return this.f1318a;
    }
}
