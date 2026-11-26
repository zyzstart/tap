package com.youme.lbs;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class GeographyLocationManager implements com.youme.lbs.IGeographyLocationCallback {
    private static com.youme.lbs.GeographyLocation geographyLocation;
    private static com.youme.lbs.GeographyLocationManager s_instance;

    public static int GetGeographyLocation() {
        com.youme.lbs.GeographyLocation geographyLocation2 = geographyLocation;
        return geographyLocation2 != null ? geographyLocation2.GetLocation().ordinal() : com.youme.lbs.IGeographyLocationCallback.LocationErrorcode.LOCATIONERROR_INIT_FAILED.getValue();
    }

    public static com.youme.lbs.GeographyLocationManager Instance() {
        if (s_instance == null) {
            s_instance = new com.youme.lbs.GeographyLocationManager();
        }
        return s_instance;
    }

    public void Init(android.content.Context context) {
        geographyLocation = new com.youme.lbs.GeographyLocation();
        geographyLocation.Init(context);
        geographyLocation.SetCallback(this);
    }

    @Override // com.youme.lbs.IGeographyLocationCallback
    public void OnUploadGeoLocation(com.youme.lbs.IGeographyLocationCallback.LocationErrorcode locationErrorcode, double d, double d2) {
        com.youme.im.NativeEngine.OnUpdateLocation(locationErrorcode.ordinal(), d, d2);
    }
}
