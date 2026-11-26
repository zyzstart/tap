package com.dodjoy.thirdPlatform;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ThirdPlatformFactory {
    public static com.dodjoy.platform.IThirdPlatform create() {
        try {
            return (com.dodjoy.platform.IThirdPlatform) java.lang.Class.forName("com.dodjoy.thirdPlatform.ThirdPlatform").newInstance();
        } catch (java.lang.ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (java.lang.IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (java.lang.InstantiationException e3) {
            e3.printStackTrace();
            return null;
        }
    }
}
