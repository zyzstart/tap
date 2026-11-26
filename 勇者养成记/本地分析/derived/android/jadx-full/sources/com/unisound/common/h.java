package com.unisound.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class h {
    public static boolean a(android.content.Context context) {
        android.media.AudioManager audioManager;
        if (b(context) && (audioManager = (android.media.AudioManager) context.getSystemService("audio")) != null) {
            audioManager.setBluetoothScoOn(true);
            audioManager.startBluetoothSco();
        }
        return true;
    }

    public static boolean b(android.content.Context context) {
        return true;
    }

    public static boolean c(android.content.Context context) {
        android.media.AudioManager audioManager;
        if (!b(context) || (audioManager = (android.media.AudioManager) context.getSystemService("audio")) == null) {
            return true;
        }
        audioManager.setBluetoothScoOn(false);
        audioManager.stopBluetoothSco();
        return true;
    }
}
