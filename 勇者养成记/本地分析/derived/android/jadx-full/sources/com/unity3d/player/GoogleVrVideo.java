package com.unity3d.player;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface GoogleVrVideo {

    public interface GoogleVrVideoCallbacks {
        void onFrameAvailable();

        void onSurfaceAvailable(android.view.Surface surface);

        void onSurfaceUnavailable();
    }

    void deregisterGoogleVrVideoListener(com.unity3d.player.GoogleVrVideo.GoogleVrVideoCallbacks googleVrVideoCallbacks);

    void registerGoogleVrVideoListener(com.unity3d.player.GoogleVrVideo.GoogleVrVideoCallbacks googleVrVideoCallbacks);

    void setVideoLocationTransform(float[] fArr);
}
