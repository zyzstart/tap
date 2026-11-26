package com.qq.gdt.action;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile com.qq.gdt.action.a f62a;
    private final android.content.Context b;
    private final com.qq.gdt.action.a.C0016a c = new com.qq.gdt.action.a.C0016a();

    /* JADX INFO: renamed from: com.qq.gdt.action.a$a, reason: collision with other inner class name */
    private class C0016a {
        private final java.lang.Object b = new java.lang.Object();
        private android.os.Handler c;

        /* JADX INFO: renamed from: com.qq.gdt.action.a$a$a, reason: collision with other inner class name */
        private class HandlerC0017a extends android.os.Handler {
            private final java.util.Set<java.lang.Long> b;
            private boolean c;
            private final java.util.Map<java.lang.String, com.qq.gdt.action.a.a> d;
            private final java.util.Set<java.lang.String> e;
            private final com.qq.gdt.action.a.b f;
            private boolean g;

            HandlerC0017a(android.os.Looper looper) {
                super(looper);
                this.b = java.util.Collections.newSetFromMap(new java.util.concurrent.ConcurrentHashMap());
                this.c = false;
                this.d = new java.util.concurrent.ConcurrentHashMap();
                this.e = java.util.Collections.newSetFromMap(new java.util.concurrent.ConcurrentHashMap());
                this.g = false;
                this.f = com.qq.gdt.action.a.b.a(com.qq.gdt.action.a.this.b);
            }

            private void a() throws java.lang.Throwable {
                com.qq.gdt.action.h.l.a("======>Action reporter running now.", new java.lang.Object[0]);
                this.g = true;
                b();
                c();
            }

            private void a(int i) throws java.lang.Throwable {
                java.lang.String str;
                java.lang.Object[] objArr;
                if (com.qq.gdt.action.h.m.a(com.qq.gdt.action.a.this.b)) {
                    long jMax = 0;
                    while (true) {
                        java.util.List<com.qq.gdt.action.a.a> listA = this.f.a(i, 50L, jMax);
                        if (com.qq.gdt.action.h.f.a(listA)) {
                            break;
                        }
                        java.util.Iterator<com.qq.gdt.action.a.a> it = listA.iterator();
                        while (it.hasNext()) {
                            com.qq.gdt.action.a.a next = it.next();
                            jMax = java.lang.Math.max(jMax, next.e());
                            if (!this.b.contains(java.lang.Long.valueOf(next.e()))) {
                                if (next.b().equals("ACTIVATE_APP")) {
                                    if (!this.c) {
                                        if (com.qq.gdt.action.h.c.a(com.qq.gdt.action.a.this.b)) {
                                            this.c = true;
                                        } else {
                                            this.f.a(java.util.Collections.singletonList(java.lang.Long.valueOf(next.e())), 3);
                                        }
                                    }
                                }
                            }
                            it.remove();
                        }
                        if (!com.qq.gdt.action.h.f.a(listA)) {
                            java.util.Iterator<com.qq.gdt.action.a.a> it2 = listA.iterator();
                            while (it2.hasNext()) {
                                this.b.add(java.lang.Long.valueOf(it2.next().e()));
                            }
                            com.qq.gdt.action.h.l.a(com.qq.gdt.action.h.t.a("Flushing %d actions(status=%d)", java.lang.Integer.valueOf(listA.size()), java.lang.Integer.valueOf(i)), new java.lang.Object[0]);
                            a(listA, i);
                        }
                    }
                    str = "No more actions in status(%d), bravo!";
                    objArr = new java.lang.Object[]{java.lang.Integer.valueOf(i)};
                } else {
                    str = "Network not available while flush actions(status=%d), schedule later.";
                    objArr = new java.lang.Object[]{java.lang.Integer.valueOf(i)};
                }
                com.qq.gdt.action.h.l.a(com.qq.gdt.action.h.t.a(str, objArr), new java.lang.Object[0]);
            }

            private void a(android.os.Message message) {
                java.util.List<com.qq.gdt.action.a.a> list = (java.util.List) message.obj;
                if (this.f.a(list)) {
                    if (!b(list) && this.f.a(0) < 5) {
                        return;
                    }
                } else if (!a(list)) {
                    return;
                }
                c();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a(com.qq.gdt.action.a.a aVar, boolean z) {
                if (aVar == null) {
                    return;
                }
                long jC = aVar.c();
                long jG = aVar.g();
                if (jG <= 0 && com.qq.gdt.action.h.u.a()) {
                    jG = com.qq.gdt.action.h.u.b();
                }
                long j = jG;
                if ("ACTIVATE_APP".equals(aVar.b())) {
                    com.qq.gdt.action.h.q.a(com.qq.gdt.action.a.this.b, z, jC, j);
                    this.c = false;
                }
                if (com.qq.gdt.action.ActionType.START_APP.equals(aVar.b())) {
                    com.qq.gdt.action.h.q.a(com.qq.gdt.action.a.this.b, jC, j);
                }
            }

            private void a(java.util.List<com.qq.gdt.action.a.a> list, final int i) {
                com.qq.gdt.action.g.c.a(list, new com.qq.gdt.action.g.c.a() { // from class: com.qq.gdt.action.a.a.a.1
                    @Override // com.qq.gdt.action.g.c.a
                    public void a(java.util.List<com.qq.gdt.action.a.a> list2, int i2, java.lang.String str, int i3) {
                        if (com.qq.gdt.action.h.f.b(list2)) {
                            java.util.ArrayList arrayList = new java.util.ArrayList();
                            for (com.qq.gdt.action.a.a aVar : list2) {
                                if (aVar.e() > 0) {
                                    arrayList.add(java.lang.Long.valueOf(aVar.e()));
                                } else {
                                    com.qq.gdt.action.a.C0016a.HandlerC0017a.this.e.remove(aVar.a());
                                }
                                if (i3 != 200 || i2 <= 0) {
                                    com.qq.gdt.action.h.l.b(com.qq.gdt.action.h.t.a("LogAction failed(scheduled retry %d milliseconds later): actionType = %s , actionParams = %s", java.lang.Integer.valueOf(com.qq.gdt.action.b.a(com.qq.gdt.action.a.this.b).c()), aVar.b(), aVar.d()));
                                } else {
                                    com.qq.gdt.action.h.l.c(com.qq.gdt.action.h.t.a("LogAction failed(errorCode = %d, errorMessage = %s): actionType = %s , actionParams = %s", java.lang.Integer.valueOf(i2), str, aVar.b(), aVar.d()));
                                }
                                if ("ACTIVATE_APP".equals(aVar.b())) {
                                    com.qq.gdt.action.a.C0016a.HandlerC0017a.this.c = false;
                                }
                            }
                            if (com.qq.gdt.action.h.f.b(arrayList)) {
                                if (i3 == 200 && i2 > 0) {
                                    com.qq.gdt.action.a.C0016a.HandlerC0017a.this.b(arrayList, 4);
                                } else if (i != 2) {
                                    com.qq.gdt.action.a.C0016a.HandlerC0017a.this.b(arrayList, 2);
                                }
                                com.qq.gdt.action.a.C0016a.HandlerC0017a.this.b.removeAll(arrayList);
                                com.qq.gdt.action.h.l.b(com.qq.gdt.action.h.t.a("Flush actions(status=%d) failed(http status = %d): code = %d, msg = %s", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i3), java.lang.Integer.valueOf(i2), str));
                            }
                        }
                    }

                    @Override // com.qq.gdt.action.g.c.a
                    public void a(java.util.List<com.qq.gdt.action.a.a> list2, boolean z) {
                        if (com.qq.gdt.action.h.f.b(list2)) {
                            java.util.ArrayList arrayList = new java.util.ArrayList();
                            for (com.qq.gdt.action.a.a aVar : list2) {
                                if (aVar.e() > 0) {
                                    arrayList.add(java.lang.Long.valueOf(aVar.e()));
                                } else {
                                    com.qq.gdt.action.a.C0016a.HandlerC0017a.this.d.remove(aVar.a());
                                    com.qq.gdt.action.a.C0016a.HandlerC0017a.this.e.remove(aVar.a());
                                }
                                com.qq.gdt.action.a.C0016a.HandlerC0017a.this.a(aVar, z);
                                if (com.qq.gdt.action.GDTAction.isAutoCollectionAction(aVar)) {
                                    com.qq.gdt.action.h.l.a(com.qq.gdt.action.h.t.a("LogAction success: actionType = %s, actionParams = %s", aVar.b(), aVar.d()), new java.lang.Object[0]);
                                } else {
                                    com.qq.gdt.action.h.l.a(com.qq.gdt.action.h.t.a("LogAction success: actionType = %s, actionParams = %s", aVar.b(), aVar.d()));
                                }
                            }
                            if (arrayList.isEmpty()) {
                                return;
                            }
                            com.qq.gdt.action.a.C0016a.HandlerC0017a.this.b(arrayList, 1);
                            com.qq.gdt.action.a.C0016a.HandlerC0017a.this.b.removeAll(arrayList);
                            com.qq.gdt.action.h.l.a(com.qq.gdt.action.h.t.a("Flushed %d Actions in status(%d)", java.lang.Integer.valueOf(list2.size()), java.lang.Integer.valueOf(i)), new java.lang.Object[0]);
                        }
                    }
                });
            }

            private boolean a(java.util.List<com.qq.gdt.action.a.a> list) {
                boolean z = false;
                for (com.qq.gdt.action.a.a aVar : list) {
                    if (com.qq.gdt.action.b.a(com.qq.gdt.action.a.this.b).a(aVar.b())) {
                        this.d.put(aVar.a(), aVar);
                        z = true;
                    }
                }
                return z;
            }

            private void b() throws java.lang.Throwable {
                com.qq.gdt.action.h.l.a("Cleaning old actions.", new java.lang.Object[0]);
                this.f.a();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void b(java.util.List<java.lang.Long> list, int i) {
                if (!com.qq.gdt.action.h.f.a(list) && this.f.a(list, i) < 0) {
                    com.qq.gdt.action.h.l.c("Update action status error");
                }
            }

            private boolean b(java.util.List<com.qq.gdt.action.a.a> list) {
                java.util.Iterator<com.qq.gdt.action.a.a> it = list.iterator();
                while (it.hasNext()) {
                    if (com.qq.gdt.action.b.a(com.qq.gdt.action.a.this.b).a(it.next().b())) {
                        return true;
                    }
                }
                return false;
            }

            private void c() {
                if (this.g) {
                    com.qq.gdt.action.h.l.a("Flush all actions.", new java.lang.Object[0]);
                    try {
                        e();
                        f();
                    } catch (java.lang.Throwable unused) {
                    }
                    d();
                }
            }

            private void d() {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                java.util.ArrayList arrayList2 = new java.util.ArrayList();
                for (com.qq.gdt.action.a.a aVar : this.d.values()) {
                    if (!this.e.contains(aVar.a())) {
                        if ("ACTIVATE_APP".equals(aVar.b())) {
                            if (!this.c) {
                                if (com.qq.gdt.action.h.c.a(com.qq.gdt.action.a.this.b)) {
                                    this.c = true;
                                } else {
                                    arrayList2.add(aVar.a());
                                }
                            }
                        }
                        arrayList.add(aVar);
                        this.e.add(aVar.a());
                    }
                }
                java.util.Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    this.d.remove((java.lang.String) it.next());
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                if (arrayList.size() <= 50) {
                    a(arrayList, -1);
                    return;
                }
                java.util.Iterator it2 = com.qq.gdt.action.h.f.a(arrayList, 50).iterator();
                while (it2.hasNext()) {
                    a((java.util.List<com.qq.gdt.action.a.a>) it2.next(), -1);
                }
            }

            private void e() throws java.lang.Throwable {
                com.qq.gdt.action.h.l.a("Flush all pending actions.", new java.lang.Object[0]);
                a(0);
            }

            private void f() throws java.lang.Throwable {
                com.qq.gdt.action.h.l.a("Flush all failed actions.", new java.lang.Object[0]);
                a(2);
            }

            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                try {
                    com.qq.gdt.action.h.l.a("Handle message: " + message.what, new java.lang.Object[0]);
                    int i = message.what;
                    if (i != 1) {
                        switch (i) {
                            case 5:
                                a();
                                break;
                            case 6:
                                a(message);
                                break;
                            default:
                                com.qq.gdt.action.h.l.a("Unexpected message received by reporter: " + message);
                                break;
                        }
                    } else {
                        c();
                    }
                } catch (java.lang.Throwable th) {
                    com.qq.gdt.action.h.l.a("Worker handle message threw an unhandled exception", th);
                }
                try {
                    if (hasMessages(1)) {
                        return;
                    }
                    android.os.Message messageObtain = android.os.Message.obtain();
                    messageObtain.what = 1;
                    sendMessageDelayed(messageObtain, com.qq.gdt.action.b.a(com.qq.gdt.action.a.this.b).c());
                } catch (java.lang.Throwable th2) {
                    com.qq.gdt.action.h.l.b("Send Delay 'FLUSH_ACTION' message failed", th2);
                }
            }
        }

        C0016a() {
            android.os.HandlerThread handlerThread = new android.os.HandlerThread("com.qq.gdt.action.ActionReporter.Worker", 10);
            handlerThread.start();
            this.c = new com.qq.gdt.action.a.C0016a.HandlerC0017a(handlerThread.getLooper());
        }

        void a(android.os.Message message) {
            synchronized (this.b) {
                if (this.c == null) {
                    com.qq.gdt.action.h.l.c("Dropping a message: " + message.what);
                } else {
                    this.c.sendMessage(message);
                }
            }
        }
    }

    private a(android.content.Context context) {
        this.b = context;
    }

    public static com.qq.gdt.action.a a(android.content.Context context) {
        if (f62a == null) {
            synchronized (com.qq.gdt.action.a.class) {
                if (f62a == null) {
                    f62a = new com.qq.gdt.action.a(context);
                }
            }
        }
        return f62a;
    }

    public void a() {
        android.os.Message messageObtain = android.os.Message.obtain();
        messageObtain.what = 1;
        this.c.a(messageObtain);
    }

    public void a(boolean z) {
        android.os.Message messageObtain = android.os.Message.obtain();
        messageObtain.what = 5;
        messageObtain.obj = java.lang.Boolean.valueOf(z);
        this.c.a(messageObtain);
    }

    public void a(com.qq.gdt.action.a.a... aVarArr) {
        android.os.Message messageObtain = android.os.Message.obtain();
        messageObtain.what = 6;
        messageObtain.obj = java.util.Arrays.asList(aVarArr);
        this.c.a(messageObtain);
    }
}
