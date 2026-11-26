package com.tencent.midas.plugin;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.annotation.SuppressLint({"NewApi"})
public class APLayoutInflaterFactory implements android.view.LayoutInflater.Factory2 {
    private final java.util.HashMap constructorMap = new java.util.HashMap();
    private final java.lang.Class[] constructorSign = {android.content.Context.class, android.util.AttributeSet.class};
    private final java.lang.Object[] constructorArgs = new java.lang.Object[2];

    /* JADX WARN: Code duplicated, block: B:26:0x007e  */
    /* JADX WARN: Code duplicated, block: B:27:0x0081 A[Catch: all -> 0x0065, TRY_ENTER, TryCatch #3 {all -> 0x0065, blocks: (B:10:0x002d, B:11:0x003b, B:18:0x0051, B:24:0x0069, B:28:0x0085, B:29:0x0092, B:27:0x0081, B:31:0x0094, B:32:0x00b4, B:34:0x00b6, B:35:0x00d6, B:37:0x00d8, B:38:0x00f8), top: B:43:0x002b, inners: #6, #7 }] */
    @Override // android.view.LayoutInflater.Factory2
    public android.view.View onCreateView(android.view.View view, java.lang.String str, android.content.Context context, android.util.AttributeSet attributeSet) {
        java.lang.Class cls;
        java.lang.String name;
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        if (-1 == str.indexOf(46)) {
            return null;
        }
        java.lang.Object[] objArr = this.constructorArgs;
        android.content.Context context2 = (android.content.Context) objArr[0];
        objArr[0] = context;
        java.lang.reflect.Constructor constructor = (java.lang.reflect.Constructor) this.constructorMap.get(str);
        try {
            if (constructor == null) {
                try {
                    try {
                        try {
                            java.lang.Class clsAsSubclass = context.getClassLoader().loadClass(str).asSubclass(android.view.View.class);
                            try {
                                java.lang.reflect.Constructor constructor2 = clsAsSubclass.getConstructor(this.constructorSign);
                                this.constructorMap.put(str, constructor2);
                                cls = clsAsSubclass;
                                constructor = constructor2;
                            } catch (java.lang.Exception e) {
                                e = e;
                                cls = clsAsSubclass;
                                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                                sb.append(attributeSet.getPositionDescription());
                                sb.append(": Error inflating class ");
                                if (cls == null) {
                                    name = "<unknown>";
                                } else {
                                    name = cls.getName();
                                }
                                sb.append(name);
                                android.view.InflateException inflateException = new android.view.InflateException(sb.toString());
                                inflateException.initCause(e);
                                throw inflateException;
                            }
                        } catch (java.lang.Exception e2) {
                            e = e2;
                            cls = null;
                        }
                    } catch (java.lang.NoSuchMethodException e3) {
                        android.view.InflateException inflateException2 = new android.view.InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
                        inflateException2.initCause(e3);
                        throw inflateException2;
                    }
                } catch (java.lang.ClassCastException e4) {
                    android.view.InflateException inflateException3 = new android.view.InflateException(attributeSet.getPositionDescription() + ": Class is not a View " + str);
                    inflateException3.initCause(e4);
                    throw inflateException3;
                } catch (java.lang.ClassNotFoundException e5) {
                    android.view.InflateException inflateException4 = new android.view.InflateException(attributeSet.getPositionDescription() + ": Class not found " + str);
                    inflateException4.initCause(e5);
                    throw inflateException4;
                }
            } else {
                cls = null;
            }
            try {
                java.lang.Object[] objArr2 = this.constructorArgs;
                objArr2[1] = attributeSet;
                constructor.setAccessible(true);
                android.view.View view2 = (android.view.View) constructor.newInstance(objArr2);
                java.lang.Object[] objArr3 = this.constructorArgs;
                objArr3[0] = context2;
                objArr3[1] = null;
                return view2;
            } catch (java.lang.Exception e6) {
                e = e6;
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append(attributeSet.getPositionDescription());
                sb2.append(": Error inflating class ");
                if (cls == null) {
                    name = "<unknown>";
                } else {
                    name = cls.getName();
                }
                sb2.append(name);
                android.view.InflateException inflateException5 = new android.view.InflateException(sb2.toString());
                inflateException5.initCause(e);
                throw inflateException5;
            }
        } catch (java.lang.Throwable th) {
            java.lang.Object[] objArr4 = this.constructorArgs;
            objArr4[0] = context2;
            objArr4[1] = null;
            throw th;
        }
    }

    @Override // android.view.LayoutInflater.Factory
    public android.view.View onCreateView(java.lang.String str, android.content.Context context, android.util.AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
