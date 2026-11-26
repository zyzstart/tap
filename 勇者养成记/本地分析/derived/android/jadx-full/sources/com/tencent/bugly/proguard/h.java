package com.tencent.bugly.proguard;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.lang.StringBuilder f435a;
    private int b;

    public h(java.lang.StringBuilder sb, int i) {
        this.b = 0;
        this.f435a = sb;
        this.b = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private <T> com.tencent.bugly.proguard.h a(T t, java.lang.String str) {
        if (t == 0) {
            this.f435a.append("null\n");
        } else if (t instanceof java.lang.Byte) {
            byte bByteValue = ((java.lang.Byte) t).byteValue();
            a(str);
            java.lang.StringBuilder sb = this.f435a;
            sb.append((int) bByteValue);
            sb.append('\n');
        } else if (t instanceof java.lang.Boolean) {
            boolean zBooleanValue = ((java.lang.Boolean) t).booleanValue();
            a(str);
            java.lang.StringBuilder sb2 = this.f435a;
            sb2.append(zBooleanValue ? 'T' : 'F');
            sb2.append('\n');
        } else if (t instanceof java.lang.Short) {
            short sShortValue = ((java.lang.Short) t).shortValue();
            a(str);
            java.lang.StringBuilder sb3 = this.f435a;
            sb3.append((int) sShortValue);
            sb3.append('\n');
        } else if (t instanceof java.lang.Integer) {
            int iIntValue = ((java.lang.Integer) t).intValue();
            a(str);
            java.lang.StringBuilder sb4 = this.f435a;
            sb4.append(iIntValue);
            sb4.append('\n');
        } else if (t instanceof java.lang.Long) {
            long jLongValue = ((java.lang.Long) t).longValue();
            a(str);
            java.lang.StringBuilder sb5 = this.f435a;
            sb5.append(jLongValue);
            sb5.append('\n');
        } else if (t instanceof java.lang.Float) {
            float fFloatValue = ((java.lang.Float) t).floatValue();
            a(str);
            java.lang.StringBuilder sb6 = this.f435a;
            sb6.append(fFloatValue);
            sb6.append('\n');
        } else if (t instanceof java.lang.Double) {
            double dDoubleValue = ((java.lang.Double) t).doubleValue();
            a(str);
            java.lang.StringBuilder sb7 = this.f435a;
            sb7.append(dDoubleValue);
            sb7.append('\n');
        } else if (t instanceof java.lang.String) {
            a((java.lang.String) t, str);
        } else if (t instanceof java.util.Map) {
            a((java.util.Map) t, str);
        } else if (t instanceof java.util.List) {
            java.util.List list = (java.util.List) t;
            if (list == null) {
                a(str);
                this.f435a.append("null\t");
            } else {
                a(list.toArray(), str);
            }
        } else if (t instanceof com.tencent.bugly.proguard.k) {
            a((com.tencent.bugly.proguard.k) t, str);
        } else if (t instanceof byte[]) {
            a((byte[]) t, str);
        } else if (t instanceof boolean[]) {
            a((boolean[]) t, str);
        } else {
            int i = 0;
            if (t instanceof short[]) {
                short[] sArr = (short[]) t;
                a(str);
                if (sArr == null) {
                    this.f435a.append("null\n");
                } else if (sArr.length == 0) {
                    java.lang.StringBuilder sb8 = this.f435a;
                    sb8.append(sArr.length);
                    sb8.append(", []\n");
                } else {
                    java.lang.StringBuilder sb9 = this.f435a;
                    sb9.append(sArr.length);
                    sb9.append(", [\n");
                    com.tencent.bugly.proguard.h hVar = new com.tencent.bugly.proguard.h(this.f435a, this.b + 1);
                    int length = sArr.length;
                    while (i < length) {
                        short s = sArr[i];
                        hVar.a(null);
                        java.lang.StringBuilder sb10 = hVar.f435a;
                        sb10.append((int) s);
                        sb10.append('\n');
                        i++;
                    }
                    a(null);
                    java.lang.StringBuilder sb11 = this.f435a;
                    sb11.append(']');
                    sb11.append('\n');
                }
            } else if (t instanceof int[]) {
                int[] iArr = (int[]) t;
                a(str);
                if (iArr == null) {
                    this.f435a.append("null\n");
                } else if (iArr.length == 0) {
                    java.lang.StringBuilder sb12 = this.f435a;
                    sb12.append(iArr.length);
                    sb12.append(", []\n");
                } else {
                    java.lang.StringBuilder sb13 = this.f435a;
                    sb13.append(iArr.length);
                    sb13.append(", [\n");
                    com.tencent.bugly.proguard.h hVar2 = new com.tencent.bugly.proguard.h(this.f435a, this.b + 1);
                    int length2 = iArr.length;
                    while (i < length2) {
                        int i2 = iArr[i];
                        hVar2.a(null);
                        java.lang.StringBuilder sb14 = hVar2.f435a;
                        sb14.append(i2);
                        sb14.append('\n');
                        i++;
                    }
                    a(null);
                    java.lang.StringBuilder sb15 = this.f435a;
                    sb15.append(']');
                    sb15.append('\n');
                }
            } else if (t instanceof long[]) {
                long[] jArr = (long[]) t;
                a(str);
                if (jArr == null) {
                    this.f435a.append("null\n");
                } else if (jArr.length == 0) {
                    java.lang.StringBuilder sb16 = this.f435a;
                    sb16.append(jArr.length);
                    sb16.append(", []\n");
                } else {
                    java.lang.StringBuilder sb17 = this.f435a;
                    sb17.append(jArr.length);
                    sb17.append(", [\n");
                    com.tencent.bugly.proguard.h hVar3 = new com.tencent.bugly.proguard.h(this.f435a, this.b + 1);
                    int length3 = jArr.length;
                    while (i < length3) {
                        long j = jArr[i];
                        hVar3.a(null);
                        java.lang.StringBuilder sb18 = hVar3.f435a;
                        sb18.append(j);
                        sb18.append('\n');
                        i++;
                    }
                    a(null);
                    java.lang.StringBuilder sb19 = this.f435a;
                    sb19.append(']');
                    sb19.append('\n');
                }
            } else if (t instanceof float[]) {
                float[] fArr = (float[]) t;
                a(str);
                if (fArr == null) {
                    this.f435a.append("null\n");
                } else if (fArr.length == 0) {
                    java.lang.StringBuilder sb20 = this.f435a;
                    sb20.append(fArr.length);
                    sb20.append(", []\n");
                } else {
                    java.lang.StringBuilder sb21 = this.f435a;
                    sb21.append(fArr.length);
                    sb21.append(", [\n");
                    com.tencent.bugly.proguard.h hVar4 = new com.tencent.bugly.proguard.h(this.f435a, this.b + 1);
                    int length4 = fArr.length;
                    while (i < length4) {
                        float f = fArr[i];
                        hVar4.a(null);
                        java.lang.StringBuilder sb22 = hVar4.f435a;
                        sb22.append(f);
                        sb22.append('\n');
                        i++;
                    }
                    a(null);
                    java.lang.StringBuilder sb23 = this.f435a;
                    sb23.append(']');
                    sb23.append('\n');
                }
            } else if (t instanceof double[]) {
                double[] dArr = (double[]) t;
                a(str);
                if (dArr == null) {
                    this.f435a.append("null\n");
                } else if (dArr.length == 0) {
                    java.lang.StringBuilder sb24 = this.f435a;
                    sb24.append(dArr.length);
                    sb24.append(", []\n");
                } else {
                    java.lang.StringBuilder sb25 = this.f435a;
                    sb25.append(dArr.length);
                    sb25.append(", [\n");
                    com.tencent.bugly.proguard.h hVar5 = new com.tencent.bugly.proguard.h(this.f435a, this.b + 1);
                    int length5 = dArr.length;
                    while (i < length5) {
                        double d = dArr[i];
                        hVar5.a(null);
                        java.lang.StringBuilder sb26 = hVar5.f435a;
                        sb26.append(d);
                        sb26.append('\n');
                        i++;
                    }
                    a(null);
                    java.lang.StringBuilder sb27 = this.f435a;
                    sb27.append(']');
                    sb27.append('\n');
                }
            } else {
                if (!t.getClass().isArray()) {
                    throw new com.tencent.bugly.proguard.b("write object error: unsupport type.");
                }
                a((java.lang.Object[]) t, str);
            }
        }
        return this;
    }

    private <T> com.tencent.bugly.proguard.h a(T[] tArr, java.lang.String str) {
        a(str);
        if (tArr == null) {
            this.f435a.append("null\n");
            return this;
        }
        if (tArr.length == 0) {
            java.lang.StringBuilder sb = this.f435a;
            sb.append(tArr.length);
            sb.append(", []\n");
            return this;
        }
        java.lang.StringBuilder sb2 = this.f435a;
        sb2.append(tArr.length);
        sb2.append(", [\n");
        com.tencent.bugly.proguard.h hVar = new com.tencent.bugly.proguard.h(this.f435a, this.b + 1);
        for (T t : tArr) {
            hVar.a(t, (java.lang.String) null);
        }
        a(null);
        java.lang.StringBuilder sb3 = this.f435a;
        sb3.append(']');
        sb3.append('\n');
        return this;
    }

    private void a(java.lang.String str) {
        for (int i = 0; i < this.b; i++) {
            this.f435a.append('\t');
        }
        if (str != null) {
            java.lang.StringBuilder sb = this.f435a;
            sb.append(str);
            sb.append(": ");
        }
    }

    public final com.tencent.bugly.proguard.h a(byte b, java.lang.String str) {
        a(str);
        java.lang.StringBuilder sb = this.f435a;
        sb.append((int) b);
        sb.append('\n');
        return this;
    }

    public final com.tencent.bugly.proguard.h a(int i, java.lang.String str) {
        a(str);
        java.lang.StringBuilder sb = this.f435a;
        sb.append(i);
        sb.append('\n');
        return this;
    }

    public final com.tencent.bugly.proguard.h a(long j, java.lang.String str) {
        a(str);
        java.lang.StringBuilder sb = this.f435a;
        sb.append(j);
        sb.append('\n');
        return this;
    }

    public final com.tencent.bugly.proguard.h a(com.tencent.bugly.proguard.k kVar, java.lang.String str) {
        a(str);
        java.lang.StringBuilder sb = this.f435a;
        sb.append('{');
        sb.append('\n');
        if (kVar == null) {
            java.lang.StringBuilder sb2 = this.f435a;
            sb2.append('\t');
            sb2.append("null");
        } else {
            kVar.a(this.f435a, this.b + 1);
        }
        a(null);
        java.lang.StringBuilder sb3 = this.f435a;
        sb3.append('}');
        sb3.append('\n');
        return this;
    }

    public final com.tencent.bugly.proguard.h a(java.lang.String str, java.lang.String str2) {
        a(str2);
        if (str == null) {
            this.f435a.append("null\n");
        } else {
            java.lang.StringBuilder sb = this.f435a;
            sb.append(str);
            sb.append('\n');
        }
        return this;
    }

    public final <K, V> com.tencent.bugly.proguard.h a(java.util.Map<K, V> map, java.lang.String str) {
        a(str);
        if (map == null) {
            this.f435a.append("null\n");
            return this;
        }
        if (map.isEmpty()) {
            java.lang.StringBuilder sb = this.f435a;
            sb.append(map.size());
            sb.append(", {}\n");
            return this;
        }
        java.lang.StringBuilder sb2 = this.f435a;
        sb2.append(map.size());
        sb2.append(", {\n");
        com.tencent.bugly.proguard.h hVar = new com.tencent.bugly.proguard.h(this.f435a, this.b + 1);
        com.tencent.bugly.proguard.h hVar2 = new com.tencent.bugly.proguard.h(this.f435a, this.b + 2);
        for (java.util.Map.Entry<K, V> entry : map.entrySet()) {
            hVar.a(null);
            java.lang.StringBuilder sb3 = hVar.f435a;
            sb3.append('(');
            sb3.append('\n');
            hVar2.a(entry.getKey(), (java.lang.String) null);
            hVar2.a(entry.getValue(), (java.lang.String) null);
            hVar.a(null);
            java.lang.StringBuilder sb4 = hVar.f435a;
            sb4.append(')');
            sb4.append('\n');
        }
        a(null);
        java.lang.StringBuilder sb5 = this.f435a;
        sb5.append('}');
        sb5.append('\n');
        return this;
    }

    public final com.tencent.bugly.proguard.h a(short s, java.lang.String str) {
        a(str);
        java.lang.StringBuilder sb = this.f435a;
        sb.append((int) s);
        sb.append('\n');
        return this;
    }

    public final com.tencent.bugly.proguard.h a(boolean z, java.lang.String str) {
        a(str);
        java.lang.StringBuilder sb = this.f435a;
        sb.append(z ? 'T' : 'F');
        sb.append('\n');
        return this;
    }

    public final com.tencent.bugly.proguard.h a(byte[] bArr, java.lang.String str) {
        a(str);
        if (bArr == null) {
            this.f435a.append("null\n");
            return this;
        }
        if (bArr.length == 0) {
            java.lang.StringBuilder sb = this.f435a;
            sb.append(bArr.length);
            sb.append(", []\n");
            return this;
        }
        java.lang.StringBuilder sb2 = this.f435a;
        sb2.append(bArr.length);
        sb2.append(", [\n");
        com.tencent.bugly.proguard.h hVar = new com.tencent.bugly.proguard.h(this.f435a, this.b + 1);
        for (byte b : bArr) {
            hVar.a(null);
            java.lang.StringBuilder sb3 = hVar.f435a;
            sb3.append((int) b);
            sb3.append('\n');
        }
        a(null);
        java.lang.StringBuilder sb4 = this.f435a;
        sb4.append(']');
        sb4.append('\n');
        return this;
    }
}
