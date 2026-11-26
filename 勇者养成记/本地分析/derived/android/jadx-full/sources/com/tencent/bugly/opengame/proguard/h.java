package com.tencent.bugly.opengame.proguard;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.lang.StringBuilder f393a;
    private int b;

    public h(java.lang.StringBuilder sb, int i) {
        this.b = 0;
        this.f393a = sb;
        this.b = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private com.tencent.bugly.opengame.proguard.h a(java.lang.Object obj, java.lang.String str) {
        java.lang.StringBuilder sb;
        java.lang.String str2;
        java.lang.Object[] array;
        java.lang.StringBuilder sb2;
        int length;
        java.lang.StringBuilder sb3;
        java.lang.StringBuilder sb4;
        int iIntValue;
        if (obj != null) {
            if (obj instanceof java.lang.Byte) {
                iIntValue = ((java.lang.Byte) obj).byteValue();
            } else {
                if (obj instanceof java.lang.Boolean) {
                    boolean zBooleanValue = ((java.lang.Boolean) obj).booleanValue();
                    a(str);
                    sb4 = this.f393a;
                    sb4.append(zBooleanValue ? 'T' : 'F');
                } else if (obj instanceof java.lang.Short) {
                    iIntValue = ((java.lang.Short) obj).shortValue();
                } else if (obj instanceof java.lang.Integer) {
                    iIntValue = ((java.lang.Integer) obj).intValue();
                } else {
                    if (obj instanceof java.lang.Long) {
                        long jLongValue = ((java.lang.Long) obj).longValue();
                        a(str);
                        sb3 = this.f393a;
                        sb3.append(jLongValue);
                    } else if (obj instanceof java.lang.Float) {
                        float fFloatValue = ((java.lang.Float) obj).floatValue();
                        a(str);
                        sb4 = this.f393a;
                        sb4.append(fFloatValue);
                    } else if (obj instanceof java.lang.Double) {
                        double dDoubleValue = ((java.lang.Double) obj).doubleValue();
                        a(str);
                        sb3 = this.f393a;
                        sb3.append(dDoubleValue);
                    } else if (obj instanceof java.lang.String) {
                        a((java.lang.String) obj, str);
                    } else if (obj instanceof java.util.Map) {
                        a((java.util.Map) obj, str);
                    } else {
                        if (obj instanceof java.util.List) {
                            java.util.List list = (java.util.List) obj;
                            if (list == null) {
                                a(str);
                                sb = this.f393a;
                                str2 = "null\t";
                                sb.append(str2);
                            } else {
                                array = list.toArray();
                            }
                        } else if (obj instanceof com.tencent.bugly.opengame.proguard.k) {
                            a((com.tencent.bugly.opengame.proguard.k) obj, str);
                        } else if (obj instanceof byte[]) {
                            a((byte[]) obj, str);
                        } else if (obj instanceof boolean[]) {
                            a((boolean[]) obj, str);
                        } else {
                            int i = 0;
                            if (obj instanceof short[]) {
                                short[] sArr = (short[]) obj;
                                a(str);
                                if (sArr != null) {
                                    if (sArr.length == 0) {
                                        sb2 = this.f393a;
                                        length = sArr.length;
                                        sb2.append(length);
                                        sb2.append(", []\n");
                                    } else {
                                        java.lang.StringBuilder sb5 = this.f393a;
                                        sb5.append(sArr.length);
                                        sb5.append(", [\n");
                                        com.tencent.bugly.opengame.proguard.h hVar = new com.tencent.bugly.opengame.proguard.h(this.f393a, this.b + 1);
                                        int length2 = sArr.length;
                                        while (i < length2) {
                                            short s = sArr[i];
                                            hVar.a(null);
                                            java.lang.StringBuilder sb6 = hVar.f393a;
                                            sb6.append((int) s);
                                            sb6.append('\n');
                                            i++;
                                        }
                                        a(null);
                                        sb3 = this.f393a;
                                        sb3.append(']');
                                    }
                                }
                                sb = this.f393a;
                                str2 = "null\n";
                                sb.append(str2);
                            } else if (obj instanceof int[]) {
                                int[] iArr = (int[]) obj;
                                a(str);
                                if (iArr != null) {
                                    if (iArr.length == 0) {
                                        sb2 = this.f393a;
                                        length = iArr.length;
                                        sb2.append(length);
                                        sb2.append(", []\n");
                                    } else {
                                        java.lang.StringBuilder sb7 = this.f393a;
                                        sb7.append(iArr.length);
                                        sb7.append(", [\n");
                                        com.tencent.bugly.opengame.proguard.h hVar2 = new com.tencent.bugly.opengame.proguard.h(this.f393a, this.b + 1);
                                        int length3 = iArr.length;
                                        while (i < length3) {
                                            int i2 = iArr[i];
                                            hVar2.a(null);
                                            java.lang.StringBuilder sb8 = hVar2.f393a;
                                            sb8.append(i2);
                                            sb8.append('\n');
                                            i++;
                                        }
                                        a(null);
                                        sb3 = this.f393a;
                                        sb3.append(']');
                                    }
                                }
                                sb = this.f393a;
                                str2 = "null\n";
                                sb.append(str2);
                            } else if (obj instanceof long[]) {
                                long[] jArr = (long[]) obj;
                                a(str);
                                if (jArr != null) {
                                    if (jArr.length == 0) {
                                        sb2 = this.f393a;
                                        length = jArr.length;
                                        sb2.append(length);
                                        sb2.append(", []\n");
                                    } else {
                                        java.lang.StringBuilder sb9 = this.f393a;
                                        sb9.append(jArr.length);
                                        sb9.append(", [\n");
                                        com.tencent.bugly.opengame.proguard.h hVar3 = new com.tencent.bugly.opengame.proguard.h(this.f393a, this.b + 1);
                                        int length4 = jArr.length;
                                        while (i < length4) {
                                            long j = jArr[i];
                                            hVar3.a(null);
                                            java.lang.StringBuilder sb10 = hVar3.f393a;
                                            sb10.append(j);
                                            sb10.append('\n');
                                            i++;
                                        }
                                        a(null);
                                        sb3 = this.f393a;
                                        sb3.append(']');
                                    }
                                }
                                sb = this.f393a;
                                str2 = "null\n";
                                sb.append(str2);
                            } else if (obj instanceof float[]) {
                                float[] fArr = (float[]) obj;
                                a(str);
                                if (fArr != null) {
                                    if (fArr.length == 0) {
                                        sb2 = this.f393a;
                                        length = fArr.length;
                                        sb2.append(length);
                                        sb2.append(", []\n");
                                    } else {
                                        java.lang.StringBuilder sb11 = this.f393a;
                                        sb11.append(fArr.length);
                                        sb11.append(", [\n");
                                        com.tencent.bugly.opengame.proguard.h hVar4 = new com.tencent.bugly.opengame.proguard.h(this.f393a, this.b + 1);
                                        int length5 = fArr.length;
                                        while (i < length5) {
                                            float f = fArr[i];
                                            hVar4.a(null);
                                            java.lang.StringBuilder sb12 = hVar4.f393a;
                                            sb12.append(f);
                                            sb12.append('\n');
                                            i++;
                                        }
                                        a(null);
                                        sb3 = this.f393a;
                                        sb3.append(']');
                                    }
                                }
                                sb = this.f393a;
                                str2 = "null\n";
                                sb.append(str2);
                            } else if (obj instanceof double[]) {
                                double[] dArr = (double[]) obj;
                                a(str);
                                if (dArr != null) {
                                    if (dArr.length == 0) {
                                        sb2 = this.f393a;
                                        length = dArr.length;
                                        sb2.append(length);
                                        sb2.append(", []\n");
                                    } else {
                                        java.lang.StringBuilder sb13 = this.f393a;
                                        sb13.append(dArr.length);
                                        sb13.append(", [\n");
                                        com.tencent.bugly.opengame.proguard.h hVar5 = new com.tencent.bugly.opengame.proguard.h(this.f393a, this.b + 1);
                                        int length6 = dArr.length;
                                        while (i < length6) {
                                            double d = dArr[i];
                                            hVar5.a(null);
                                            java.lang.StringBuilder sb14 = hVar5.f393a;
                                            sb14.append(d);
                                            sb14.append('\n');
                                            i++;
                                        }
                                        a(null);
                                        sb3 = this.f393a;
                                        sb3.append(']');
                                    }
                                }
                                sb = this.f393a;
                                str2 = "null\n";
                                sb.append(str2);
                            } else {
                                if (!obj.getClass().isArray()) {
                                    throw new com.tencent.bugly.opengame.proguard.b("write object error: unsupport type.");
                                }
                                array = (java.lang.Object[]) obj;
                            }
                        }
                        a(array, str);
                    }
                    sb3.append('\n');
                }
                sb4.append('\n');
            }
            a(str);
            sb4 = this.f393a;
            sb4.append(iIntValue);
            sb4.append('\n');
        } else {
            sb = this.f393a;
            str2 = "null\n";
            sb.append(str2);
        }
        return this;
    }

    private com.tencent.bugly.opengame.proguard.h a(java.lang.Object[] objArr, java.lang.String str) {
        a(str);
        if (objArr == null) {
            this.f393a.append("null\n");
            return this;
        }
        if (objArr.length == 0) {
            java.lang.StringBuilder sb = this.f393a;
            sb.append(objArr.length);
            sb.append(", []\n");
            return this;
        }
        java.lang.StringBuilder sb2 = this.f393a;
        sb2.append(objArr.length);
        sb2.append(", [\n");
        com.tencent.bugly.opengame.proguard.h hVar = new com.tencent.bugly.opengame.proguard.h(this.f393a, this.b + 1);
        for (java.lang.Object obj : objArr) {
            hVar.a(obj, (java.lang.String) null);
        }
        a(null);
        java.lang.StringBuilder sb3 = this.f393a;
        sb3.append(']');
        sb3.append('\n');
        return this;
    }

    private void a(java.lang.String str) {
        for (int i = 0; i < this.b; i++) {
            this.f393a.append('\t');
        }
        if (str != null) {
            java.lang.StringBuilder sb = this.f393a;
            sb.append(str);
            sb.append(": ");
        }
    }

    public final com.tencent.bugly.opengame.proguard.h a(byte b, java.lang.String str) {
        a(str);
        java.lang.StringBuilder sb = this.f393a;
        sb.append((int) b);
        sb.append('\n');
        return this;
    }

    public final com.tencent.bugly.opengame.proguard.h a(int i, java.lang.String str) {
        a(str);
        java.lang.StringBuilder sb = this.f393a;
        sb.append(i);
        sb.append('\n');
        return this;
    }

    public final com.tencent.bugly.opengame.proguard.h a(long j, java.lang.String str) {
        a(str);
        java.lang.StringBuilder sb = this.f393a;
        sb.append(j);
        sb.append('\n');
        return this;
    }

    public final com.tencent.bugly.opengame.proguard.h a(com.tencent.bugly.opengame.proguard.k kVar, java.lang.String str) {
        a(str);
        java.lang.StringBuilder sb = this.f393a;
        sb.append('{');
        sb.append('\n');
        if (kVar == null) {
            java.lang.StringBuilder sb2 = this.f393a;
            sb2.append('\t');
            sb2.append("null");
        } else {
            kVar.a(this.f393a, this.b + 1);
        }
        a(null);
        java.lang.StringBuilder sb3 = this.f393a;
        sb3.append('}');
        sb3.append('\n');
        return this;
    }

    public final com.tencent.bugly.opengame.proguard.h a(java.lang.String str, java.lang.String str2) {
        a(str2);
        if (str == null) {
            this.f393a.append("null\n");
        } else {
            java.lang.StringBuilder sb = this.f393a;
            sb.append(str);
            sb.append('\n');
        }
        return this;
    }

    public final com.tencent.bugly.opengame.proguard.h a(java.util.Map map, java.lang.String str) {
        a(str);
        if (map == null) {
            this.f393a.append("null\n");
            return this;
        }
        if (map.isEmpty()) {
            java.lang.StringBuilder sb = this.f393a;
            sb.append(map.size());
            sb.append(", {}\n");
            return this;
        }
        java.lang.StringBuilder sb2 = this.f393a;
        sb2.append(map.size());
        sb2.append(", {\n");
        com.tencent.bugly.opengame.proguard.h hVar = new com.tencent.bugly.opengame.proguard.h(this.f393a, this.b + 1);
        com.tencent.bugly.opengame.proguard.h hVar2 = new com.tencent.bugly.opengame.proguard.h(this.f393a, this.b + 2);
        for (java.util.Map.Entry entry : map.entrySet()) {
            hVar.a(null);
            java.lang.StringBuilder sb3 = hVar.f393a;
            sb3.append('(');
            sb3.append('\n');
            hVar2.a(entry.getKey(), (java.lang.String) null);
            hVar2.a(entry.getValue(), (java.lang.String) null);
            hVar.a(null);
            java.lang.StringBuilder sb4 = hVar.f393a;
            sb4.append(')');
            sb4.append('\n');
        }
        a(null);
        java.lang.StringBuilder sb5 = this.f393a;
        sb5.append('}');
        sb5.append('\n');
        return this;
    }

    public final com.tencent.bugly.opengame.proguard.h a(short s, java.lang.String str) {
        a(str);
        java.lang.StringBuilder sb = this.f393a;
        sb.append((int) s);
        sb.append('\n');
        return this;
    }

    public final com.tencent.bugly.opengame.proguard.h a(boolean z, java.lang.String str) {
        a(str);
        java.lang.StringBuilder sb = this.f393a;
        sb.append(z ? 'T' : 'F');
        sb.append('\n');
        return this;
    }

    public final com.tencent.bugly.opengame.proguard.h a(byte[] bArr, java.lang.String str) {
        a(str);
        if (bArr == null) {
            this.f393a.append("null\n");
            return this;
        }
        if (bArr.length == 0) {
            java.lang.StringBuilder sb = this.f393a;
            sb.append(bArr.length);
            sb.append(", []\n");
            return this;
        }
        java.lang.StringBuilder sb2 = this.f393a;
        sb2.append(bArr.length);
        sb2.append(", [\n");
        com.tencent.bugly.opengame.proguard.h hVar = new com.tencent.bugly.opengame.proguard.h(this.f393a, this.b + 1);
        for (byte b : bArr) {
            hVar.a(null);
            java.lang.StringBuilder sb3 = hVar.f393a;
            sb3.append((int) b);
            sb3.append('\n');
        }
        a(null);
        java.lang.StringBuilder sb4 = this.f393a;
        sb4.append(']');
        sb4.append('\n');
        return this;
    }
}
