package com.youme.lbs;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface IGeographyLocationCallback {

    public enum LocationErrorcode {
        LOCATIONERROR_SUCCESS(0),
        LOCATIONERROR_INIT_FAILED(1),
        LOCATIONERROR_AUTHORIZE(2),
        LOCATIONERROR_FAILED(3),
        LOCATIONERROR_RUNNING(4),
        LOCATIONERROR_TIMEOUT(5),
        LOCATIONERROR_START_FAILED(6),
        LOCATIONERROR_RESOLVE_FAILED(7),
        LOCATIONERROR_OTHER(99);

        private int value;

        LocationErrorcode(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    void OnUploadGeoLocation(com.youme.lbs.IGeographyLocationCallback.LocationErrorcode locationErrorcode, double d, double d2);
}
