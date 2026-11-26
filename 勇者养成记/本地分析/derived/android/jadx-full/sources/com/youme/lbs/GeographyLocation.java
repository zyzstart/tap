package com.youme.lbs;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class GeographyLocation {
    private static final short LOCATION_FAILED = 1;
    private static final short LOCATION_SUCCESS = 0;
    private static final short LOCATION_TIMEOUT = 2;
    private static final int LOCATION_TIMEOUT_MAX = 90000;
    private static final int LOCATION_TIMEOUT_MIN = 10000;
    private static final java.lang.String LOG_TAG = "GeographyLocation";
    private static final float MIN_DISTANCE = 1000.0f;
    private static final int MIN_TIME = 60000;
    private static final int TWO_MINUTES = 120000;
    private android.content.Context m_context;
    private int m_currentTimeout;
    private com.youme.lbs.GeographyLocation.LBSThread m_lbsThread;
    private android.os.Looper m_threadLooper;
    private android.location.LocationManager m_locactionManager = null;
    private com.youme.lbs.IGeographyLocationCallback m_callback = null;
    private boolean mIsRunning = false;
    private boolean mIsAuthorize = true;
    private android.location.Location m_currentBestLocation = null;
    private android.location.Location m_lastLocation = null;
    private int m_updateCount = 0;
    private java.util.Timer m_timer = null;
    private java.util.TimerTask m_timerTask = null;
    private java.util.Map<java.lang.String, com.youme.lbs.GeographyLocation.GeoLocationListener> m_geoLocationListeners = new java.util.HashMap();

    private class GeoLocationListener implements android.location.LocationListener {
        private GeoLocationListener() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(android.location.Location location) {
            com.youme.im.IMEngine.WriteLog(com.youme.im.CommonConst.LogLevel.LOG_LEVEL_INFO, "location changed longtitude:" + location.getLongitude() + " latitude:" + location.getLatitude() + " provider:" + location.getProvider());
            com.youme.lbs.GeographyLocation geographyLocation = com.youme.lbs.GeographyLocation.this;
            if (geographyLocation.IsBetterLocation(location, geographyLocation.m_currentBestLocation)) {
                com.youme.lbs.GeographyLocation.this.m_currentBestLocation = location;
            }
            if (location.getProvider() == "gps" && com.youme.lbs.GeographyLocation.this.m_geoLocationListeners.containsKey("gps")) {
                com.youme.lbs.GeographyLocation.this.m_locactionManager.removeUpdates((android.location.LocationListener) com.youme.lbs.GeographyLocation.this.m_geoLocationListeners.get("gps"));
            }
            if (location.getProvider() == "network" && com.youme.lbs.GeographyLocation.this.m_geoLocationListeners.containsKey("network")) {
                com.youme.lbs.GeographyLocation.this.m_locactionManager.removeUpdates((android.location.LocationListener) com.youme.lbs.GeographyLocation.this.m_geoLocationListeners.get("network"));
            }
            if (com.youme.lbs.GeographyLocation.access$304(com.youme.lbs.GeographyLocation.this) >= com.youme.lbs.GeographyLocation.this.m_geoLocationListeners.size()) {
                com.youme.lbs.GeographyLocation.this.StopTimer(0);
            } else {
                com.youme.lbs.GeographyLocation.this.NotifyLocationResult(0);
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(java.lang.String str) {
            android.util.Log.i(com.youme.lbs.GeographyLocation.LOG_TAG, "provider disabled name:" + str);
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(java.lang.String str) {
            android.util.Log.i(com.youme.lbs.GeographyLocation.LOG_TAG, "provider enabled name:" + str);
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(java.lang.String str, int i, android.os.Bundle bundle) {
            android.util.Log.i(com.youme.lbs.GeographyLocation.LOG_TAG, "onStatusChanged provider:" + str + " status:" + i);
        }
    }

    public class LBSThread extends java.lang.Thread {
        public LBSThread() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            com.youme.im.IMEngine.WriteLog(com.youme.im.CommonConst.LogLevel.LOG_LEVEL_INFO, "thread start");
            android.os.Looper.prepare();
            com.youme.lbs.GeographyLocation.this.m_threadLooper = android.os.Looper.myLooper();
            if (!com.youme.lbs.GeographyLocation.this.mIsAuthorize) {
                try {
                    java.lang.Thread.sleep(com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewConstants.HIDE_BUBBLE_TASK_DELAY);
                } catch (java.lang.InterruptedException e) {
                    e.printStackTrace();
                    com.youme.lbs.GeographyLocation.this.StopTimer(1);
                    return;
                }
            }
            if (!com.youme.lbs.GeographyLocation.this.StartRequestLocationUpdates()) {
                com.youme.lbs.GeographyLocation.this.StopTimer(1);
                com.youme.im.IMEngine.WriteLog(com.youme.im.CommonConst.LogLevel.LOG_LEVEL_ERROR, "start location failed");
            } else {
                com.youme.im.IMEngine.WriteLog(com.youme.im.CommonConst.LogLevel.LOG_LEVEL_INFO, "thread running");
                android.os.Looper.loop();
                com.youme.im.IMEngine.WriteLog(com.youme.im.CommonConst.LogLevel.LOG_LEVEL_INFO, "thread exit");
            }
        }
    }

    private boolean IsSameProvider(java.lang.String str, java.lang.String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equals(str2);
    }

    private void StartTimer() {
        java.util.Timer timer;
        if (this.m_timerTask == null) {
            this.m_timerTask = new java.util.TimerTask() { // from class: com.youme.lbs.GeographyLocation.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (com.youme.lbs.GeographyLocation.this.m_currentTimeout != 10000) {
                        com.youme.im.IMEngine.WriteLog(com.youme.im.CommonConst.LogLevel.LOG_LEVEL_INFO, "timer reached 2");
                        com.youme.lbs.GeographyLocation.this.StopTimer(2);
                        return;
                    }
                    com.youme.im.IMEngine.WriteLog(com.youme.im.CommonConst.LogLevel.LOG_LEVEL_INFO, "timer reached 1");
                    com.youme.lbs.GeographyLocation.this.m_currentTimeout = com.youme.lbs.GeographyLocation.LOCATION_TIMEOUT_MAX;
                    if (com.youme.lbs.GeographyLocation.this.m_callback == null || com.youme.lbs.GeographyLocation.this.m_lastLocation == null || com.youme.lbs.GeographyLocation.this.m_updateCount != 0) {
                        return;
                    }
                    android.location.Location location = com.youme.lbs.GeographyLocation.this.m_lastLocation;
                    if (com.youme.lbs.GeographyLocation.this.m_currentBestLocation != null) {
                        com.youme.lbs.GeographyLocation geographyLocation = com.youme.lbs.GeographyLocation.this;
                        if (geographyLocation.IsBetterLocation(geographyLocation.m_currentBestLocation, com.youme.lbs.GeographyLocation.this.m_lastLocation)) {
                            location = com.youme.lbs.GeographyLocation.this.m_currentBestLocation;
                            com.youme.lbs.GeographyLocation geographyLocation2 = com.youme.lbs.GeographyLocation.this;
                            geographyLocation2.m_lastLocation = geographyLocation2.m_currentBestLocation;
                        }
                    }
                    com.youme.lbs.GeographyLocation.this.m_callback.OnUploadGeoLocation(com.youme.lbs.IGeographyLocationCallback.LocationErrorcode.LOCATIONERROR_SUCCESS, location.getLongitude(), location.getLatitude());
                }
            };
        }
        if (this.m_timer == null) {
            this.m_timer = new java.util.Timer();
        }
        java.util.TimerTask timerTask = this.m_timerTask;
        if (timerTask == null || (timer = this.m_timer) == null) {
            return;
        }
        if (this.m_lastLocation != null) {
            this.m_currentTimeout = 10000;
            timer.schedule(timerTask, this.m_currentTimeout, 80000L);
        } else {
            this.m_currentTimeout = LOCATION_TIMEOUT_MAX;
            timer.schedule(timerTask, this.m_currentTimeout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void StopTimer(int i) {
        android.os.Looper looper = this.m_threadLooper;
        if (looper != null) {
            looper.quit();
            this.m_threadLooper = null;
        }
        if (this.m_lbsThread != null) {
            this.m_lbsThread = null;
        }
        StopRequestLocationUpdates();
        java.util.Timer timer = this.m_timer;
        if (timer != null) {
            timer.cancel();
        }
        java.util.TimerTask timerTask = this.m_timerTask;
        if (timerTask != null) {
            timerTask.cancel();
        }
        this.m_timer = null;
        this.m_timerTask = null;
        this.mIsRunning = false;
        NotifyLocationResult(i);
    }

    static /* synthetic */ int access$304(com.youme.lbs.GeographyLocation geographyLocation) {
        int i = geographyLocation.m_updateCount + 1;
        geographyLocation.m_updateCount = i;
        return i;
    }

    public com.youme.lbs.IGeographyLocationCallback.LocationErrorcode GetLocation() {
        android.content.Context context;
        if (this.mIsRunning) {
            com.youme.im.IMEngine.WriteLog(com.youme.im.CommonConst.LogLevel.LOG_LEVEL_INFO, "location running");
            return com.youme.lbs.IGeographyLocationCallback.LocationErrorcode.LOCATIONERROR_RUNNING;
        }
        this.mIsRunning = true;
        if (android.os.Build.VERSION.SDK_INT >= 23 && (context = this.m_context) != null && (context instanceof android.app.Activity) && context.getApplicationInfo().targetSdkVersion > 22) {
            try {
                if (com.anthonycr.grant.PermissionsManager.getInstance().hasPermission(this.m_context, "android.permission.ACCESS_FINE_LOCATION")) {
                    this.mIsAuthorize = true;
                } else {
                    this.mIsAuthorize = false;
                    com.anthonycr.grant.PermissionsManager.getInstance().requestPermissionsIfNecessaryForResult((android.app.Activity) this.m_context, new java.lang.String[]{"android.permission.ACCESS_FINE_LOCATION"}, new com.anthonycr.grant.PermissionsResultAction() { // from class: com.youme.lbs.GeographyLocation.2
                        @Override // com.anthonycr.grant.PermissionsResultAction
                        public void onDenied(java.lang.String str) {
                            com.youme.lbs.GeographyLocation.this.mIsRunning = false;
                            com.youme.im.IMEngine.WriteLog(com.youme.im.CommonConst.LogLevel.LOG_LEVEL_WARNING, "Decline granted ACCESS_FINE_LOCATION permission.");
                        }

                        @Override // com.anthonycr.grant.PermissionsResultAction
                        public void onGranted() {
                            android.util.Log.i(com.youme.lbs.GeographyLocation.LOG_TAG, " Success granted ACCESS_FINE_LOCATION permission.");
                        }
                    });
                    com.youme.im.IMEngine.WriteLog(com.youme.im.CommonConst.LogLevel.LOG_LEVEL_WARNING, "Not granted ACCESS_FINE_LOCATION permission");
                    if (!this.mIsRunning) {
                        return com.youme.lbs.IGeographyLocationCallback.LocationErrorcode.LOCATIONERROR_AUTHORIZE;
                    }
                }
            } catch (java.lang.Exception e) {
                android.util.Log.e(LOG_TAG, e.toString());
                com.youme.im.IMEngine.WriteLog(com.youme.im.CommonConst.LogLevel.LOG_LEVEL_ERROR, "location permission exception");
                return com.youme.lbs.IGeographyLocationCallback.LocationErrorcode.LOCATIONERROR_AUTHORIZE;
            }
        }
        if (this.m_locactionManager == null) {
            this.m_locactionManager = (android.location.LocationManager) this.m_context.getSystemService("location");
            if (this.m_locactionManager == null) {
                com.youme.im.IMEngine.WriteLog(com.youme.im.CommonConst.LogLevel.LOG_LEVEL_ERROR, "get location service failed");
                this.m_locactionManager = (android.location.LocationManager) this.m_context.getSystemService("location");
                this.mIsRunning = false;
                return com.youme.lbs.IGeographyLocationCallback.LocationErrorcode.LOCATIONERROR_INIT_FAILED;
            }
        }
        boolean zIsProviderEnabled = this.m_locactionManager.isProviderEnabled("gps");
        boolean zIsProviderEnabled2 = this.m_locactionManager.isProviderEnabled("network");
        boolean zIsProviderEnabled3 = this.m_locactionManager.isProviderEnabled("passive");
        if (!zIsProviderEnabled) {
            this.m_geoLocationListeners.remove("gps");
        } else if (!this.m_geoLocationListeners.containsKey("gps")) {
            this.m_geoLocationListeners.put("gps", new com.youme.lbs.GeographyLocation.GeoLocationListener());
        }
        if (!zIsProviderEnabled2) {
            this.m_geoLocationListeners.remove("network");
        } else if (!this.m_geoLocationListeners.containsKey("network")) {
            this.m_geoLocationListeners.put("network", new com.youme.lbs.GeographyLocation.GeoLocationListener());
        }
        com.youme.im.IMEngine.WriteLog(com.youme.im.CommonConst.LogLevel.LOG_LEVEL_INFO, "gps:" + zIsProviderEnabled + " network:" + zIsProviderEnabled2 + " passive:" + zIsProviderEnabled3 + " total:" + this.m_geoLocationListeners.size());
        if (this.m_geoLocationListeners.size() == 0) {
            com.youme.im.IMEngine.WriteLog(com.youme.im.CommonConst.LogLevel.LOG_LEVEL_ERROR, "location unenable");
            this.mIsRunning = false;
            return com.youme.lbs.IGeographyLocationCallback.LocationErrorcode.LOCATIONERROR_AUTHORIZE;
        }
        android.location.Criteria criteria = new android.location.Criteria();
        criteria.setAccuracy(1);
        criteria.setPowerRequirement(1);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setCostAllowed(true);
        criteria.setSpeedRequired(false);
        this.m_currentBestLocation = null;
        java.lang.String bestProvider = this.m_locactionManager.getBestProvider(criteria, true);
        if (bestProvider != null) {
            android.util.Log.d(LOG_TAG, " provider:" + bestProvider);
            android.location.Location lastKnownLocation = this.m_locactionManager.getLastKnownLocation(bestProvider);
            if (lastKnownLocation != null) {
                this.m_currentBestLocation = lastKnownLocation;
                com.youme.im.IMEngine.WriteLog(com.youme.im.CommonConst.LogLevel.LOG_LEVEL_INFO, "last location:" + this.m_currentBestLocation.getLongitude() + "x" + this.m_currentBestLocation.getLatitude() + " provider:" + bestProvider);
            }
        }
        StartTimer();
        this.m_lbsThread = new com.youme.lbs.GeographyLocation.LBSThread();
        this.m_lbsThread.start();
        return com.youme.lbs.IGeographyLocationCallback.LocationErrorcode.LOCATIONERROR_SUCCESS;
    }

    public void Init(android.content.Context context) {
        this.m_context = context;
    }

    protected boolean IsBetterLocation(android.location.Location location, android.location.Location location2) {
        if (location2 == null) {
            return true;
        }
        long time = location.getTime() - location2.getTime();
        boolean z = time > 120000;
        boolean z2 = time < -120000;
        boolean z3 = time > 0;
        if (z) {
            return true;
        }
        if (z2) {
            return false;
        }
        int accuracy = (int) (location.getAccuracy() - location2.getAccuracy());
        boolean z4 = accuracy > 0;
        boolean z5 = accuracy < 0;
        boolean z6 = accuracy > 200;
        boolean zIsSameProvider = IsSameProvider(location.getProvider(), location2.getProvider());
        if (z5) {
            return true;
        }
        if (!z3 || z4) {
            return z3 && !z6 && zIsSameProvider;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0055  */
    public void NotifyLocationResult(int i) {
        com.youme.lbs.IGeographyLocationCallback.LocationErrorcode locationErrorcode;
        com.youme.im.IMEngine.WriteLog(com.youme.im.CommonConst.LogLevel.LOG_LEVEL_INFO, "NotifyLocationResult result:" + i);
        com.youme.lbs.IGeographyLocationCallback.LocationErrorcode locationErrorcode2 = com.youme.lbs.IGeographyLocationCallback.LocationErrorcode.LOCATIONERROR_SUCCESS;
        android.location.Location location = null;
        if (i == 0) {
            if (this.m_updateCount == 0 || IsBetterLocation(this.m_currentBestLocation, this.m_lastLocation)) {
                location = this.m_currentBestLocation;
                locationErrorcode = locationErrorcode2;
            } else {
                locationErrorcode = locationErrorcode2;
            }
        } else if (1 == i) {
            locationErrorcode = com.youme.lbs.IGeographyLocationCallback.LocationErrorcode.LOCATIONERROR_FAILED;
        } else if (2 == i) {
            android.location.Location location2 = this.m_currentBestLocation;
            if (location2 == null) {
                locationErrorcode = com.youme.lbs.IGeographyLocationCallback.LocationErrorcode.LOCATIONERROR_TIMEOUT;
            } else {
                android.location.Location location3 = this.m_lastLocation;
                if (location3 == null) {
                    location = location2;
                    locationErrorcode = locationErrorcode2;
                } else {
                    if (location2 == null || location3 == null || !IsBetterLocation(location2, location3)) {
                        return;
                    }
                    location = this.m_currentBestLocation;
                    locationErrorcode = locationErrorcode2;
                }
            }
        } else {
            locationErrorcode = locationErrorcode2;
        }
        android.location.Location location4 = this.m_currentBestLocation;
        if (location4 != null) {
            this.m_lastLocation = location4;
        }
        com.youme.lbs.IGeographyLocationCallback iGeographyLocationCallback = this.m_callback;
        if (iGeographyLocationCallback != null) {
            if (location != null) {
                iGeographyLocationCallback.OnUploadGeoLocation(locationErrorcode, location.getLongitude(), location.getLatitude());
            } else {
                iGeographyLocationCallback.OnUploadGeoLocation(locationErrorcode, -180.0d, -180.0d);
            }
        }
    }

    public void SetCallback(com.youme.lbs.IGeographyLocationCallback iGeographyLocationCallback) {
        this.m_callback = iGeographyLocationCallback;
    }

    public boolean StartRequestLocationUpdates() {
        this.m_updateCount = 0;
        try {
            if (this.m_geoLocationListeners.containsKey("gps")) {
                this.m_locactionManager.requestLocationUpdates("gps", 60000L, MIN_DISTANCE, this.m_geoLocationListeners.get("gps"));
            }
            if (!this.m_geoLocationListeners.containsKey("network")) {
                return true;
            }
            this.m_locactionManager.requestLocationUpdates("network", 60000L, MIN_DISTANCE, this.m_geoLocationListeners.get("network"));
            return true;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void StopRequestLocationUpdates() {
        android.util.Log.d(LOG_TAG, "stop listen");
        if (this.m_geoLocationListeners.containsKey("gps")) {
            this.m_locactionManager.removeUpdates(this.m_geoLocationListeners.get("gps"));
        }
        if (this.m_geoLocationListeners.containsKey("network")) {
            this.m_locactionManager.removeUpdates(this.m_geoLocationListeners.get("network"));
        }
    }
}
