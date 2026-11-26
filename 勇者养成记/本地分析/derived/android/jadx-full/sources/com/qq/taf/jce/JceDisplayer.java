package com.qq.taf.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class JceDisplayer {
    private int _level;
    private java.lang.StringBuilder sb;

    public JceDisplayer(java.lang.StringBuilder sb) {
        this._level = 0;
        this.sb = sb;
    }

    public JceDisplayer(java.lang.StringBuilder sb, int i) {
        this._level = 0;
        this.sb = sb;
        this._level = i;
    }

    public static void main(java.lang.String[] strArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(1.2d);
        java.lang.System.out.println(sb.toString());
    }

    private void ps(java.lang.String str) {
        for (int i = 0; i < this._level; i++) {
            this.sb.append('\t');
        }
        if (str != null) {
            java.lang.StringBuilder sb = this.sb;
            sb.append(str);
            sb.append(": ");
        }
    }

    public com.qq.taf.jce.JceDisplayer display(byte b, java.lang.String str) {
        ps(str);
        java.lang.StringBuilder sb = this.sb;
        sb.append((int) b);
        sb.append('\n');
        return this;
    }

    public com.qq.taf.jce.JceDisplayer display(char c, java.lang.String str) {
        ps(str);
        java.lang.StringBuilder sb = this.sb;
        sb.append(c);
        sb.append('\n');
        return this;
    }

    public com.qq.taf.jce.JceDisplayer display(double d, java.lang.String str) {
        ps(str);
        java.lang.StringBuilder sb = this.sb;
        sb.append(d);
        sb.append('\n');
        return this;
    }

    public com.qq.taf.jce.JceDisplayer display(float f, java.lang.String str) {
        ps(str);
        java.lang.StringBuilder sb = this.sb;
        sb.append(f);
        sb.append('\n');
        return this;
    }

    public com.qq.taf.jce.JceDisplayer display(int i, java.lang.String str) {
        ps(str);
        java.lang.StringBuilder sb = this.sb;
        sb.append(i);
        sb.append('\n');
        return this;
    }

    public com.qq.taf.jce.JceDisplayer display(long j, java.lang.String str) {
        ps(str);
        java.lang.StringBuilder sb = this.sb;
        sb.append(j);
        sb.append('\n');
        return this;
    }

    public com.qq.taf.jce.JceDisplayer display(com.qq.taf.jce.JceStruct jceStruct, java.lang.String str) {
        display('{', str);
        if (jceStruct == null) {
            java.lang.StringBuilder sb = this.sb;
            sb.append('\t');
            sb.append("null");
        } else {
            jceStruct.display(this.sb, this._level + 1);
        }
        display('}', (java.lang.String) null);
        return this;
    }

    public com.qq.taf.jce.JceDisplayer display(java.lang.Object obj, java.lang.String str) {
        if (obj == null) {
            java.lang.StringBuilder sb = this.sb;
            sb.append("null");
            sb.append('\n');
        } else if (obj instanceof java.lang.Byte) {
            display(((java.lang.Byte) obj).byteValue(), str);
        } else if (obj instanceof java.lang.Boolean) {
            display(((java.lang.Boolean) obj).booleanValue(), str);
        } else if (obj instanceof java.lang.Short) {
            display(((java.lang.Short) obj).shortValue(), str);
        } else if (obj instanceof java.lang.Integer) {
            display(((java.lang.Integer) obj).intValue(), str);
        } else if (obj instanceof java.lang.Long) {
            display(((java.lang.Long) obj).longValue(), str);
        } else if (obj instanceof java.lang.Float) {
            display(((java.lang.Float) obj).floatValue(), str);
        } else if (obj instanceof java.lang.Double) {
            display(((java.lang.Double) obj).doubleValue(), str);
        } else if (obj instanceof java.lang.String) {
            display((java.lang.String) obj, str);
        } else if (obj instanceof java.util.Map) {
            display((java.util.Map) obj, str);
        } else if (obj instanceof java.util.List) {
            display((java.util.Collection) obj, str);
        } else if (obj instanceof com.qq.taf.jce.JceStruct) {
            display((com.qq.taf.jce.JceStruct) obj, str);
        } else if (obj instanceof byte[]) {
            display((byte[]) obj, str);
        } else if (obj instanceof boolean[]) {
            display((boolean[]) obj, str);
        } else if (obj instanceof short[]) {
            display((short[]) obj, str);
        } else if (obj instanceof int[]) {
            display((int[]) obj, str);
        } else if (obj instanceof long[]) {
            display((long[]) obj, str);
        } else if (obj instanceof float[]) {
            display((float[]) obj, str);
        } else if (obj instanceof double[]) {
            display((double[]) obj, str);
        } else {
            if (!obj.getClass().isArray()) {
                throw new com.qq.taf.jce.JceEncodeException("write object error: unsupport type.");
            }
            display((java.lang.Object[]) obj, str);
        }
        return this;
    }

    public com.qq.taf.jce.JceDisplayer display(java.lang.String str, java.lang.String str2) {
        ps(str2);
        if (str == null) {
            java.lang.StringBuilder sb = this.sb;
            sb.append("null");
            sb.append('\n');
        } else {
            java.lang.StringBuilder sb2 = this.sb;
            sb2.append(str);
            sb2.append('\n');
        }
        return this;
    }

    public com.qq.taf.jce.JceDisplayer display(java.util.Collection collection, java.lang.String str) {
        if (collection != null) {
            return display(collection.toArray(), str);
        }
        ps(str);
        java.lang.StringBuilder sb = this.sb;
        sb.append("null");
        sb.append('\t');
        return this;
    }

    public com.qq.taf.jce.JceDisplayer display(java.util.Map map, java.lang.String str) {
        ps(str);
        if (map == null) {
            java.lang.StringBuilder sb = this.sb;
            sb.append("null");
            sb.append('\n');
            return this;
        }
        if (map.isEmpty()) {
            java.lang.StringBuilder sb2 = this.sb;
            sb2.append(map.size());
            sb2.append(", {}");
            sb2.append('\n');
            return this;
        }
        java.lang.StringBuilder sb3 = this.sb;
        sb3.append(map.size());
        sb3.append(", {");
        sb3.append('\n');
        com.qq.taf.jce.JceDisplayer jceDisplayer = new com.qq.taf.jce.JceDisplayer(this.sb, this._level + 1);
        com.qq.taf.jce.JceDisplayer jceDisplayer2 = new com.qq.taf.jce.JceDisplayer(this.sb, this._level + 2);
        for (java.util.Map.Entry entry : map.entrySet()) {
            jceDisplayer.display('(', (java.lang.String) null);
            jceDisplayer2.display(entry.getKey(), (java.lang.String) null);
            jceDisplayer2.display(entry.getValue(), (java.lang.String) null);
            jceDisplayer.display(')', (java.lang.String) null);
        }
        display('}', (java.lang.String) null);
        return this;
    }

    public com.qq.taf.jce.JceDisplayer display(short s, java.lang.String str) {
        ps(str);
        java.lang.StringBuilder sb = this.sb;
        sb.append((int) s);
        sb.append('\n');
        return this;
    }

    public com.qq.taf.jce.JceDisplayer display(boolean z, java.lang.String str) {
        ps(str);
        java.lang.StringBuilder sb = this.sb;
        sb.append(z ? 'T' : 'F');
        sb.append('\n');
        return this;
    }

    public com.qq.taf.jce.JceDisplayer display(byte[] bArr, java.lang.String str) {
        ps(str);
        if (bArr == null) {
            java.lang.StringBuilder sb = this.sb;
            sb.append("null");
            sb.append('\n');
            return this;
        }
        if (bArr.length == 0) {
            java.lang.StringBuilder sb2 = this.sb;
            sb2.append(bArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        }
        java.lang.StringBuilder sb3 = this.sb;
        sb3.append(bArr.length);
        sb3.append(", [");
        sb3.append('\n');
        com.qq.taf.jce.JceDisplayer jceDisplayer = new com.qq.taf.jce.JceDisplayer(this.sb, this._level + 1);
        for (byte b : bArr) {
            jceDisplayer.display(b, (java.lang.String) null);
        }
        display(']', (java.lang.String) null);
        return this;
    }

    public com.qq.taf.jce.JceDisplayer display(char[] cArr, java.lang.String str) {
        ps(str);
        if (cArr == null) {
            java.lang.StringBuilder sb = this.sb;
            sb.append("null");
            sb.append('\n');
            return this;
        }
        if (cArr.length == 0) {
            java.lang.StringBuilder sb2 = this.sb;
            sb2.append(cArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        }
        java.lang.StringBuilder sb3 = this.sb;
        sb3.append(cArr.length);
        sb3.append(", [");
        sb3.append('\n');
        com.qq.taf.jce.JceDisplayer jceDisplayer = new com.qq.taf.jce.JceDisplayer(this.sb, this._level + 1);
        for (char c : cArr) {
            jceDisplayer.display(c, (java.lang.String) null);
        }
        display(']', (java.lang.String) null);
        return this;
    }

    public com.qq.taf.jce.JceDisplayer display(double[] dArr, java.lang.String str) {
        ps(str);
        if (dArr == null) {
            java.lang.StringBuilder sb = this.sb;
            sb.append("null");
            sb.append('\n');
            return this;
        }
        if (dArr.length == 0) {
            java.lang.StringBuilder sb2 = this.sb;
            sb2.append(dArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        }
        java.lang.StringBuilder sb3 = this.sb;
        sb3.append(dArr.length);
        sb3.append(", [");
        sb3.append('\n');
        com.qq.taf.jce.JceDisplayer jceDisplayer = new com.qq.taf.jce.JceDisplayer(this.sb, this._level + 1);
        for (double d : dArr) {
            jceDisplayer.display(d, (java.lang.String) null);
        }
        display(']', (java.lang.String) null);
        return this;
    }

    public com.qq.taf.jce.JceDisplayer display(float[] fArr, java.lang.String str) {
        ps(str);
        if (fArr == null) {
            java.lang.StringBuilder sb = this.sb;
            sb.append("null");
            sb.append('\n');
            return this;
        }
        if (fArr.length == 0) {
            java.lang.StringBuilder sb2 = this.sb;
            sb2.append(fArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        }
        java.lang.StringBuilder sb3 = this.sb;
        sb3.append(fArr.length);
        sb3.append(", [");
        sb3.append('\n');
        com.qq.taf.jce.JceDisplayer jceDisplayer = new com.qq.taf.jce.JceDisplayer(this.sb, this._level + 1);
        for (float f : fArr) {
            jceDisplayer.display(f, (java.lang.String) null);
        }
        display(']', (java.lang.String) null);
        return this;
    }

    public com.qq.taf.jce.JceDisplayer display(int[] iArr, java.lang.String str) {
        ps(str);
        if (iArr == null) {
            java.lang.StringBuilder sb = this.sb;
            sb.append("null");
            sb.append('\n');
            return this;
        }
        if (iArr.length == 0) {
            java.lang.StringBuilder sb2 = this.sb;
            sb2.append(iArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        }
        java.lang.StringBuilder sb3 = this.sb;
        sb3.append(iArr.length);
        sb3.append(", [");
        sb3.append('\n');
        com.qq.taf.jce.JceDisplayer jceDisplayer = new com.qq.taf.jce.JceDisplayer(this.sb, this._level + 1);
        for (int i : iArr) {
            jceDisplayer.display(i, (java.lang.String) null);
        }
        display(']', (java.lang.String) null);
        return this;
    }

    public com.qq.taf.jce.JceDisplayer display(long[] jArr, java.lang.String str) {
        ps(str);
        if (jArr == null) {
            java.lang.StringBuilder sb = this.sb;
            sb.append("null");
            sb.append('\n');
            return this;
        }
        if (jArr.length == 0) {
            java.lang.StringBuilder sb2 = this.sb;
            sb2.append(jArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        }
        java.lang.StringBuilder sb3 = this.sb;
        sb3.append(jArr.length);
        sb3.append(", [");
        sb3.append('\n');
        com.qq.taf.jce.JceDisplayer jceDisplayer = new com.qq.taf.jce.JceDisplayer(this.sb, this._level + 1);
        for (long j : jArr) {
            jceDisplayer.display(j, (java.lang.String) null);
        }
        display(']', (java.lang.String) null);
        return this;
    }

    public com.qq.taf.jce.JceDisplayer display(java.lang.Object[] objArr, java.lang.String str) {
        ps(str);
        if (objArr == null) {
            java.lang.StringBuilder sb = this.sb;
            sb.append("null");
            sb.append('\n');
            return this;
        }
        if (objArr.length == 0) {
            java.lang.StringBuilder sb2 = this.sb;
            sb2.append(objArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        }
        java.lang.StringBuilder sb3 = this.sb;
        sb3.append(objArr.length);
        sb3.append(", [");
        sb3.append('\n');
        com.qq.taf.jce.JceDisplayer jceDisplayer = new com.qq.taf.jce.JceDisplayer(this.sb, this._level + 1);
        for (java.lang.Object obj : objArr) {
            jceDisplayer.display(obj, (java.lang.String) null);
        }
        display(']', (java.lang.String) null);
        return this;
    }

    public com.qq.taf.jce.JceDisplayer display(short[] sArr, java.lang.String str) {
        ps(str);
        if (sArr == null) {
            java.lang.StringBuilder sb = this.sb;
            sb.append("null");
            sb.append('\n');
            return this;
        }
        if (sArr.length == 0) {
            java.lang.StringBuilder sb2 = this.sb;
            sb2.append(sArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        }
        java.lang.StringBuilder sb3 = this.sb;
        sb3.append(sArr.length);
        sb3.append(", [");
        sb3.append('\n');
        com.qq.taf.jce.JceDisplayer jceDisplayer = new com.qq.taf.jce.JceDisplayer(this.sb, this._level + 1);
        for (short s : sArr) {
            jceDisplayer.display(s, (java.lang.String) null);
        }
        display(']', (java.lang.String) null);
        return this;
    }

    public com.qq.taf.jce.JceDisplayer displaySimple(byte b, boolean z) {
        this.sb.append((int) b);
        if (z) {
            this.sb.append("|");
        }
        return this;
    }

    public com.qq.taf.jce.JceDisplayer displaySimple(char c, boolean z) {
        this.sb.append(c);
        if (z) {
            this.sb.append("|");
        }
        return this;
    }

    public com.qq.taf.jce.JceDisplayer displaySimple(double d, boolean z) {
        this.sb.append(d);
        if (z) {
            this.sb.append("|");
        }
        return this;
    }

    public com.qq.taf.jce.JceDisplayer displaySimple(float f, boolean z) {
        this.sb.append(f);
        if (z) {
            this.sb.append("|");
        }
        return this;
    }

    public com.qq.taf.jce.JceDisplayer displaySimple(int i, boolean z) {
        this.sb.append(i);
        if (z) {
            this.sb.append("|");
        }
        return this;
    }

    public com.qq.taf.jce.JceDisplayer displaySimple(long j, boolean z) {
        this.sb.append(j);
        if (z) {
            this.sb.append("|");
        }
        return this;
    }

    public com.qq.taf.jce.JceDisplayer displaySimple(com.qq.taf.jce.JceStruct jceStruct, boolean z) {
        this.sb.append("{");
        if (jceStruct == null) {
            java.lang.StringBuilder sb = this.sb;
            sb.append('\t');
            sb.append("null");
        } else {
            jceStruct.displaySimple(this.sb, this._level + 1);
        }
        this.sb.append("}");
        if (z) {
            this.sb.append("|");
        }
        return this;
    }

    public com.qq.taf.jce.JceDisplayer displaySimple(java.lang.Object obj, boolean z) {
        if (obj == null) {
            java.lang.StringBuilder sb = this.sb;
            sb.append("null");
            sb.append('\n');
        } else if (obj instanceof java.lang.Byte) {
            displaySimple(((java.lang.Byte) obj).byteValue(), z);
        } else if (obj instanceof java.lang.Boolean) {
            displaySimple(((java.lang.Boolean) obj).booleanValue(), z);
        } else if (obj instanceof java.lang.Short) {
            displaySimple(((java.lang.Short) obj).shortValue(), z);
        } else if (obj instanceof java.lang.Integer) {
            displaySimple(((java.lang.Integer) obj).intValue(), z);
        } else if (obj instanceof java.lang.Long) {
            displaySimple(((java.lang.Long) obj).longValue(), z);
        } else if (obj instanceof java.lang.Float) {
            displaySimple(((java.lang.Float) obj).floatValue(), z);
        } else if (obj instanceof java.lang.Double) {
            displaySimple(((java.lang.Double) obj).doubleValue(), z);
        } else if (obj instanceof java.lang.String) {
            displaySimple((java.lang.String) obj, z);
        } else if (obj instanceof java.util.Map) {
            displaySimple((java.util.Map) obj, z);
        } else if (obj instanceof java.util.List) {
            displaySimple((java.util.Collection) obj, z);
        } else if (obj instanceof com.qq.taf.jce.JceStruct) {
            displaySimple((com.qq.taf.jce.JceStruct) obj, z);
        } else if (obj instanceof byte[]) {
            displaySimple((byte[]) obj, z);
        } else if (obj instanceof boolean[]) {
            displaySimple((boolean[]) obj, z);
        } else if (obj instanceof short[]) {
            displaySimple((short[]) obj, z);
        } else if (obj instanceof int[]) {
            displaySimple((int[]) obj, z);
        } else if (obj instanceof long[]) {
            displaySimple((long[]) obj, z);
        } else if (obj instanceof float[]) {
            displaySimple((float[]) obj, z);
        } else if (obj instanceof double[]) {
            displaySimple((double[]) obj, z);
        } else {
            if (!obj.getClass().isArray()) {
                throw new com.qq.taf.jce.JceEncodeException("write object error: unsupport type.");
            }
            displaySimple((java.lang.Object[]) obj, z);
        }
        return this;
    }

    public com.qq.taf.jce.JceDisplayer displaySimple(java.lang.String str, boolean z) {
        if (str == null) {
            this.sb.append("null");
        } else {
            this.sb.append(str);
        }
        if (z) {
            this.sb.append("|");
        }
        return this;
    }

    public com.qq.taf.jce.JceDisplayer displaySimple(java.util.Collection collection, boolean z) {
        if (collection != null) {
            return displaySimple(collection.toArray(), z);
        }
        this.sb.append("[]");
        if (z) {
            this.sb.append("|");
        }
        return this;
    }

    public com.qq.taf.jce.JceDisplayer displaySimple(java.util.Map map, boolean z) {
        if (map == null || map.isEmpty()) {
            this.sb.append("{}");
            if (z) {
                this.sb.append("|");
            }
            return this;
        }
        this.sb.append("{");
        com.qq.taf.jce.JceDisplayer jceDisplayer = new com.qq.taf.jce.JceDisplayer(this.sb, this._level + 2);
        boolean z2 = true;
        for (java.util.Map.Entry entry : map.entrySet()) {
            if (!z2) {
                this.sb.append(",");
            }
            jceDisplayer.displaySimple(entry.getKey(), true);
            jceDisplayer.displaySimple(entry.getValue(), false);
            z2 = false;
        }
        this.sb.append("}");
        if (z) {
            this.sb.append("|");
        }
        return this;
    }

    public com.qq.taf.jce.JceDisplayer displaySimple(short s, boolean z) {
        this.sb.append((int) s);
        if (z) {
            this.sb.append("|");
        }
        return this;
    }

    public com.qq.taf.jce.JceDisplayer displaySimple(boolean z, boolean z2) {
        this.sb.append(z ? 'T' : 'F');
        if (z2) {
            this.sb.append("|");
        }
        return this;
    }

    public com.qq.taf.jce.JceDisplayer displaySimple(byte[] bArr, boolean z) {
        if (bArr == null || bArr.length == 0) {
            if (z) {
                this.sb.append("|");
            }
            return this;
        }
        this.sb.append(com.qq.taf.jce.HexUtil.bytes2HexStr(bArr));
        if (z) {
            this.sb.append("|");
        }
        return this;
    }

    public com.qq.taf.jce.JceDisplayer displaySimple(char[] cArr, boolean z) {
        if (cArr == null || cArr.length == 0) {
            if (z) {
                this.sb.append("|");
            }
            return this;
        }
        this.sb.append(new java.lang.String(cArr));
        if (z) {
            this.sb.append("|");
        }
        return this;
    }

    public com.qq.taf.jce.JceDisplayer displaySimple(double[] dArr, boolean z) {
        if (dArr == null || dArr.length == 0) {
            this.sb.append("[]");
            if (z) {
                this.sb.append("|");
            }
            return this;
        }
        this.sb.append("[");
        com.qq.taf.jce.JceDisplayer jceDisplayer = new com.qq.taf.jce.JceDisplayer(this.sb, this._level + 1);
        for (int i = 0; i < dArr.length; i++) {
            double d = dArr[i];
            if (i != 0) {
                this.sb.append("|");
            }
            jceDisplayer.displaySimple(d, false);
        }
        this.sb.append("[");
        if (z) {
            this.sb.append("|");
        }
        return this;
    }

    public com.qq.taf.jce.JceDisplayer displaySimple(float[] fArr, boolean z) {
        if (fArr == null || fArr.length == 0) {
            this.sb.append("[]");
            if (z) {
                this.sb.append("|");
            }
            return this;
        }
        this.sb.append("[");
        com.qq.taf.jce.JceDisplayer jceDisplayer = new com.qq.taf.jce.JceDisplayer(this.sb, this._level + 1);
        for (int i = 0; i < fArr.length; i++) {
            float f = fArr[i];
            if (i != 0) {
                this.sb.append("|");
            }
            jceDisplayer.displaySimple(f, false);
        }
        this.sb.append("]");
        if (z) {
            this.sb.append("|");
        }
        return this;
    }

    public com.qq.taf.jce.JceDisplayer displaySimple(int[] iArr, boolean z) {
        if (iArr == null || iArr.length == 0) {
            this.sb.append("[]");
            if (z) {
                this.sb.append("|");
            }
            return this;
        }
        this.sb.append("[");
        com.qq.taf.jce.JceDisplayer jceDisplayer = new com.qq.taf.jce.JceDisplayer(this.sb, this._level + 1);
        for (int i = 0; i < iArr.length; i++) {
            int i2 = iArr[i];
            if (i != 0) {
                this.sb.append("|");
            }
            jceDisplayer.displaySimple(i2, false);
        }
        this.sb.append("]");
        if (z) {
            this.sb.append("|");
        }
        return this;
    }

    public com.qq.taf.jce.JceDisplayer displaySimple(long[] jArr, boolean z) {
        if (jArr == null || jArr.length == 0) {
            this.sb.append("[]");
            if (z) {
                this.sb.append("|");
            }
            return this;
        }
        this.sb.append("[");
        com.qq.taf.jce.JceDisplayer jceDisplayer = new com.qq.taf.jce.JceDisplayer(this.sb, this._level + 1);
        for (int i = 0; i < jArr.length; i++) {
            long j = jArr[i];
            if (i != 0) {
                this.sb.append("|");
            }
            jceDisplayer.displaySimple(j, false);
        }
        this.sb.append("]");
        if (z) {
            this.sb.append("|");
        }
        return this;
    }

    public com.qq.taf.jce.JceDisplayer displaySimple(java.lang.Object[] objArr, boolean z) {
        if (objArr == null || objArr.length == 0) {
            this.sb.append("[]");
            if (z) {
                this.sb.append("|");
            }
            return this;
        }
        this.sb.append("[");
        com.qq.taf.jce.JceDisplayer jceDisplayer = new com.qq.taf.jce.JceDisplayer(this.sb, this._level + 1);
        for (int i = 0; i < objArr.length; i++) {
            java.lang.Object obj = objArr[i];
            if (i != 0) {
                this.sb.append("|");
            }
            jceDisplayer.displaySimple(obj, false);
        }
        this.sb.append("]");
        if (z) {
            this.sb.append("|");
        }
        return this;
    }

    public com.qq.taf.jce.JceDisplayer displaySimple(short[] sArr, boolean z) {
        if (sArr == null || sArr.length == 0) {
            this.sb.append("[]");
            if (z) {
                this.sb.append("|");
            }
            return this;
        }
        this.sb.append("[");
        com.qq.taf.jce.JceDisplayer jceDisplayer = new com.qq.taf.jce.JceDisplayer(this.sb, this._level + 1);
        for (int i = 0; i < sArr.length; i++) {
            short s = sArr[i];
            if (i != 0) {
                this.sb.append("|");
            }
            jceDisplayer.displaySimple(s, false);
        }
        this.sb.append("]");
        if (z) {
            this.sb.append("|");
        }
        return this;
    }
}
