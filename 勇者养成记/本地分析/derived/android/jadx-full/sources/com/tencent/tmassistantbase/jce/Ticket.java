package com.tencent.tmassistantbase.jce;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class Ticket extends com.qq.taf.jce.JceStruct implements java.lang.Cloneable {
    public byte type;
    public byte[] value;
    static final /* synthetic */ boolean b = !com.tencent.tmassistantbase.jce.Ticket.class.desiredAssertionStatus();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static byte[] f1041a = {0};

    public Ticket() {
        this.type = (byte) 0;
        this.value = null;
    }

    public Ticket(byte b2, byte[] bArr) {
        this.type = (byte) 0;
        this.value = null;
        this.type = b2;
        this.value = bArr;
    }

    public java.lang.String className() {
        return "SDKSys.Ticket";
    }

    public java.lang.Object clone() {
        try {
            return super.clone();
        } catch (java.lang.CloneNotSupportedException unused) {
            if (b) {
                return null;
            }
            throw new java.lang.AssertionError();
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void display(java.lang.StringBuilder sb, int i) {
        com.qq.taf.jce.JceDisplayer jceDisplayer = new com.qq.taf.jce.JceDisplayer(sb, i);
        jceDisplayer.display(this.type, com.tencent.open.SocialConstants.PARAM_TYPE);
        jceDisplayer.display(this.value, com.qq.gdt.action.ActionUtils.PAYMENT_AMOUNT);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(java.lang.StringBuilder sb, int i) {
        com.qq.taf.jce.JceDisplayer jceDisplayer = new com.qq.taf.jce.JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.type, true);
        jceDisplayer.displaySimple(this.value, false);
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == null) {
            return false;
        }
        com.tencent.tmassistantbase.jce.Ticket ticket = (com.tencent.tmassistantbase.jce.Ticket) obj;
        return com.qq.taf.jce.JceUtil.equals(this.type, ticket.type) && com.qq.taf.jce.JceUtil.equals(this.value, ticket.value);
    }

    public java.lang.String fullClassName() {
        return "com.tencent.tmdownloader.internal.protocol.SDKSys.Ticket";
    }

    public byte getType() {
        return this.type;
    }

    public byte[] getValue() {
        return this.value;
    }

    public int hashCode() {
        try {
            throw new java.lang.Exception("Need define key first!");
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(com.qq.taf.jce.JceInputStream jceInputStream) {
        this.type = jceInputStream.read(this.type, 0, true);
        this.value = jceInputStream.read(f1041a, 1, true);
    }

    public void setType(byte b2) {
        this.type = b2;
    }

    public void setValue(byte[] bArr) {
        this.value = bArr;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(com.qq.taf.jce.JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.type, 0);
        jceOutputStream.write(this.value, 1);
    }
}
