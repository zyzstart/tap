package com.qq.gdt.action.f;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class b extends android.os.Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.util.Set<com.qq.gdt.action.f.a.a> f113a;
    private java.util.Set<com.qq.gdt.action.f.a.b> b;

    b(android.os.Looper looper) {
        super(looper);
        this.f113a = new java.util.HashSet();
        this.b = new java.util.HashSet();
        sendEmptyMessageDelayed(1, 30000L);
    }

    private com.qq.gdt.action.c.h a() {
        return com.qq.gdt.action.c.d.a("action_records", com.qq.gdt.action.f.a.a.class, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.util.List<com.qq.gdt.action.f.a.a> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        android.os.Message messageObtainMessage = obtainMessage(6);
        messageObtainMessage.obj = list;
        sendMessage(messageObtainMessage);
    }

    private com.qq.gdt.action.c.h b() {
        return com.qq.gdt.action.c.d.a("events", com.qq.gdt.action.f.a.b.class, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(java.util.List<com.qq.gdt.action.f.a.b> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        android.os.Message messageObtainMessage = obtainMessage(7);
        messageObtainMessage.obj = list;
        sendMessage(messageObtainMessage);
    }

    private void c(final java.util.List<com.qq.gdt.action.f.a.a> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        for (com.qq.gdt.action.f.a.a aVar : list) {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.putOpt("eventId", 1011).putOpt("actionType", aVar.f()).putOpt("uniqActionId", aVar.e()).putOpt(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_SESSION_ID, aVar.d());
                jSONArray.put(jSONObject);
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        }
        if (com.qq.gdt.action.g.a.a(jSONArray, null, true, new com.qq.gdt.action.d.a.b() { // from class: com.qq.gdt.action.f.b.1
            @Override // com.qq.gdt.action.d.a.a
            public void a(int i, com.qq.gdt.action.d.a aVar2) {
                com.qq.gdt.action.f.b.this.a(list);
                if (aVar2.a() == 0) {
                    android.os.Message messageObtainMessage = com.qq.gdt.action.f.b.this.obtainMessage(8);
                    messageObtainMessage.obj = list;
                    com.qq.gdt.action.f.b.this.sendMessage(messageObtainMessage);
                }
            }

            @Override // com.qq.gdt.action.d.a.a
            public void b(java.lang.Throwable th) {
                com.qq.gdt.action.f.b.this.a(list);
            }
        })) {
            return;
        }
        a(list);
    }

    private void d(final java.util.List<com.qq.gdt.action.f.a.b> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        java.util.Iterator<com.qq.gdt.action.f.a.b> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().d());
        }
        if (com.qq.gdt.action.g.a.a(jSONArray, null, true, new com.qq.gdt.action.d.a.b() { // from class: com.qq.gdt.action.f.b.2
            @Override // com.qq.gdt.action.d.a.a
            public void a(int i, com.qq.gdt.action.d.a aVar) {
                com.qq.gdt.action.f.b.this.b(list);
                if (aVar.a() == 0) {
                    android.os.Message messageObtainMessage = com.qq.gdt.action.f.b.this.obtainMessage(9);
                    messageObtainMessage.obj = list;
                    com.qq.gdt.action.f.b.this.sendMessage(messageObtainMessage);
                }
            }

            @Override // com.qq.gdt.action.d.a.a
            public void b(java.lang.Throwable th) {
                com.qq.gdt.action.f.b.this.b(list);
            }
        })) {
            return;
        }
        b(list);
    }

    @Override // android.os.Handler
    public void handleMessage(android.os.Message message) {
        com.qq.gdt.action.c.a aVar;
        com.qq.gdt.action.c.h hVarA;
        java.lang.String str;
        java.lang.String str2;
        java.util.List list;
        java.util.Set set;
        java.util.List list2;
        com.qq.gdt.action.c.h hVarA2;
        switch (message.what) {
            case 1:
                com.qq.gdt.action.h.l.a("RecorderHandler", "轮询，间隔30s", new java.lang.Object[0]);
                com.qq.gdt.action.f.d.a();
                sendEmptyMessageDelayed(1, 30000L);
                break;
            case 2:
                aVar = (com.qq.gdt.action.c.a) message.obj;
                com.qq.gdt.action.h.l.a("RecorderHandler_Action", "记录Action : %s", aVar);
                hVarA = a();
                hVarA.a(aVar);
                break;
            case 3:
                aVar = (com.qq.gdt.action.c.a) message.obj;
                com.qq.gdt.action.h.l.a("RecorderHandler_Event", "记录Event : %s", aVar);
                hVarA = b();
                hVarA.a(aVar);
                break;
            case 4:
                if (!com.qq.gdt.action.h.m.a(com.qq.gdt.action.e.a().c())) {
                    str = "RecorderHandler_Action";
                    str2 = "上报Action，无网络";
                    com.qq.gdt.action.h.l.a(str, str2, new java.lang.Object[0]);
                } else {
                    com.qq.gdt.action.h.l.a("RecorderHandler_Action", "上报Action，有网络", new java.lang.Object[0]);
                    java.util.List<com.qq.gdt.action.c.a> listA = a().a(30);
                    if (listA != null) {
                        listA.removeAll(this.f113a);
                        this.f113a.addAll(listA);
                        c(listA);
                    }
                }
                break;
            case 5:
                if (!com.qq.gdt.action.h.m.a(com.qq.gdt.action.e.a().c())) {
                    str = "RecorderHandler_Event";
                    str2 = "上报Event，无网络";
                    com.qq.gdt.action.h.l.a(str, str2, new java.lang.Object[0]);
                } else {
                    com.qq.gdt.action.h.l.a("RecorderHandler_Event", "上报Event，有网络", new java.lang.Object[0]);
                    java.util.List<com.qq.gdt.action.c.a> listA2 = b().a(30);
                    if (listA2 != null) {
                        listA2.removeAll(this.b);
                        this.b.addAll(listA2);
                        d(listA2);
                    }
                }
                break;
            case 6:
                list = (java.util.List) message.obj;
                set = this.f113a;
                set.removeAll(list);
                break;
            case 7:
                list = (java.util.List) message.obj;
                set = this.b;
                set.removeAll(list);
                break;
            case 8:
                list2 = (java.util.List) message.obj;
                hVarA2 = a();
                hVarA2.a(list2);
                break;
            case 9:
                list2 = (java.util.List) message.obj;
                hVarA2 = b();
                hVarA2.a(list2);
                break;
        }
    }
}
