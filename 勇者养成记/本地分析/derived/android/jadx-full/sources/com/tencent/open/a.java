package com.tencent.open;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected java.util.HashMap f684a = new java.util.HashMap();

    /* JADX INFO: renamed from: com.tencent.open.a$a, reason: collision with other inner class name */
    public static class C0028a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected java.lang.ref.WeakReference f685a;
        protected long b;
        protected java.lang.String c;

        public C0028a(android.webkit.WebView webView, long j, java.lang.String str) {
            this.f685a = new java.lang.ref.WeakReference(webView);
            this.b = j;
            this.c = str;
        }

        public void a() {
            android.webkit.WebView webView = (android.webkit.WebView) this.f685a.get();
            if (webView == null) {
                return;
            }
            webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.b + ",{'r':1,'result':'no such method'})");
        }

        public void a(java.lang.Object obj) {
            android.webkit.WebView webView = (android.webkit.WebView) this.f685a.get();
            if (webView == null) {
                return;
            }
            java.lang.String string = "'undefined'";
            if (obj instanceof java.lang.String) {
                string = "'" + ((java.lang.Object) ((java.lang.String) obj).replace("\\", "\\\\").replace("'", "\\'")) + "'";
            } else if ((obj instanceof java.lang.Number) || (obj instanceof java.lang.Long) || (obj instanceof java.lang.Integer) || (obj instanceof java.lang.Double) || (obj instanceof java.lang.Float) || (obj instanceof java.lang.Boolean)) {
                string = obj.toString();
            }
            webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.b + ",{'r':0,'result':" + string + "});");
        }

        public void a(java.lang.String str) {
            android.webkit.WebView webView = (android.webkit.WebView) this.f685a.get();
            if (webView != null) {
                webView.loadUrl("javascript:" + str);
            }
        }
    }

    public static class b {
        public void call(java.lang.String str, java.util.List list, com.tencent.open.a.C0028a c0028a) {
            java.lang.reflect.Method method;
            java.lang.Object[] objArr;
            java.lang.reflect.Method[] declaredMethods = getClass().getDeclaredMethods();
            int length = declaredMethods.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    method = null;
                    break;
                }
                method = declaredMethods[i];
                if (method.getName().equals(str) && method.getParameterTypes().length == list.size()) {
                    break;
                } else {
                    i++;
                }
            }
            if (method == null) {
                if (c0028a != null) {
                    c0028a.a();
                    return;
                }
                return;
            }
            try {
                switch (list.size()) {
                    case 0:
                        objArr = new java.lang.Object[0];
                        break;
                    case 1:
                        objArr = new java.lang.Object[]{list.get(0)};
                        break;
                    case 2:
                        objArr = new java.lang.Object[]{list.get(0), list.get(1)};
                        break;
                    case 3:
                        objArr = new java.lang.Object[]{list.get(0), list.get(1), list.get(2)};
                        break;
                    case 4:
                        objArr = new java.lang.Object[]{list.get(0), list.get(1), list.get(2), list.get(3)};
                        break;
                    case 5:
                        objArr = new java.lang.Object[]{list.get(0), list.get(1), list.get(2), list.get(3), list.get(4)};
                        break;
                    default:
                        objArr = new java.lang.Object[6];
                        objArr[0] = list.get(0);
                        objArr[1] = list.get(1);
                        objArr[2] = list.get(2);
                        objArr[3] = list.get(3);
                        objArr[4] = list.get(4);
                        objArr[5] = list.get(5);
                        break;
                }
                java.lang.Object objInvoke = method.invoke(this, objArr);
                java.lang.Class<?> returnType = method.getReturnType();
                com.tencent.open.log.SLog.d("openSDK_LOG.JsBridge", "-->call, result: " + objInvoke + " | ReturnType: " + returnType.getName());
                if (!"void".equals(returnType.getName()) && returnType != java.lang.Void.class) {
                    if (c0028a == null || !customCallback()) {
                        return;
                    }
                    c0028a.a(objInvoke != null ? objInvoke.toString() : null);
                    return;
                }
                if (c0028a != null) {
                    c0028a.a((java.lang.Object) null);
                }
            } catch (java.lang.Exception e) {
                com.tencent.open.log.SLog.e("openSDK_LOG.JsBridge", "-->handler call mehtod ex. targetMethod: " + method, e);
                if (c0028a != null) {
                    c0028a.a();
                }
            }
        }

        public boolean customCallback() {
            return false;
        }
    }

    public void a(com.tencent.open.a.b bVar, java.lang.String str) {
        this.f684a.put(str, bVar);
    }

    public void a(java.lang.String str, java.lang.String str2, java.util.List list, com.tencent.open.a.C0028a c0028a) {
        com.tencent.open.log.SLog.v("openSDK_LOG.JsBridge", "getResult---objName = " + str + " methodName = " + str2);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                list.set(i, java.net.URLDecoder.decode((java.lang.String) list.get(i), "UTF-8"));
            } catch (java.io.UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        com.tencent.open.a.b bVar = (com.tencent.open.a.b) this.f684a.get(str);
        if (bVar != null) {
            com.tencent.open.log.SLog.d("openSDK_LOG.JsBridge", "call----");
            bVar.call(str2, list, c0028a);
        } else {
            com.tencent.open.log.SLog.d("openSDK_LOG.JsBridge", "not call----objName NOT FIND");
            if (c0028a != null) {
                c0028a.a();
            }
        }
    }

    public boolean a(android.webkit.WebView webView, java.lang.String str) {
        com.tencent.open.log.SLog.v("openSDK_LOG.JsBridge", "-->canHandleUrl---url = " + str);
        if (str == null || !android.net.Uri.parse(str).getScheme().equals("jsbridge")) {
            return false;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(java.util.Arrays.asList((str + "/#").split("/")));
        if (arrayList.size() < 6) {
            return false;
        }
        java.lang.String str2 = (java.lang.String) arrayList.get(2);
        java.lang.String str3 = (java.lang.String) arrayList.get(3);
        java.util.List listSubList = arrayList.subList(4, arrayList.size() - 1);
        com.tencent.open.a.C0028a c0028a = new com.tencent.open.a.C0028a(webView, 4L, str);
        webView.getUrl();
        a(str2, str3, listSubList, c0028a);
        return true;
    }
}
