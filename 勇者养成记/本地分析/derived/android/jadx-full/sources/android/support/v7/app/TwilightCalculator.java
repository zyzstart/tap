package android.support.v7.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class TwilightCalculator {
    private static final float ALTIDUTE_CORRECTION_CIVIL_TWILIGHT = -0.10471976f;
    private static final float C1 = 0.0334196f;
    private static final float C2 = 3.49066E-4f;
    private static final float C3 = 5.236E-6f;
    public static final int DAY = 0;
    private static final float DEGREES_TO_RADIANS = 0.017453292f;
    private static final float J0 = 9.0E-4f;
    public static final int NIGHT = 1;
    private static final float OBLIQUITY = 0.4092797f;
    private static final long UTC_2000 = 946728000000L;
    private static android.support.v7.app.TwilightCalculator sInstance;
    public int state;
    public long sunrise;
    public long sunset;

    TwilightCalculator() {
    }

    static android.support.v7.app.TwilightCalculator getInstance() {
        if (sInstance == null) {
            sInstance = new android.support.v7.app.TwilightCalculator();
        }
        return sInstance;
    }

    public void calculateTwilight(long j, double d, double d2) {
        float f = (j - UTC_2000) / 8.64E7f;
        float f2 = (0.01720197f * f) + 6.24006f;
        double d3 = f2;
        double dSin = java.lang.Math.sin(d3) * 0.03341960161924362d;
        java.lang.Double.isNaN(d3);
        double dSin2 = dSin + d3 + (java.lang.Math.sin(2.0f * f2) * 3.4906598739326E-4d) + (java.lang.Math.sin(f2 * 3.0f) * 5.236000106378924E-6d) + 1.796593063d + 3.141592653589793d;
        double d4 = (-d2) / 360.0d;
        double d5 = f - J0;
        java.lang.Double.isNaN(d5);
        double dRound = java.lang.Math.round(d5 - d4) + J0;
        java.lang.Double.isNaN(dRound);
        double dSin3 = dRound + d4 + (java.lang.Math.sin(d3) * 0.0053d) + (java.lang.Math.sin(2.0d * dSin2) * (-0.0069d));
        double dAsin = java.lang.Math.asin(java.lang.Math.sin(dSin2) * java.lang.Math.sin(0.4092797040939331d));
        double d6 = 0.01745329238474369d * d;
        double dSin4 = (java.lang.Math.sin(-0.10471975803375244d) - (java.lang.Math.sin(d6) * java.lang.Math.sin(dAsin))) / (java.lang.Math.cos(d6) * java.lang.Math.cos(dAsin));
        if (dSin4 >= 1.0d) {
            this.state = 1;
            this.sunset = -1L;
            this.sunrise = -1L;
            return;
        }
        if (dSin4 <= -1.0d) {
            this.state = 0;
            this.sunset = -1L;
            this.sunrise = -1L;
            return;
        }
        double dAcos = (float) (java.lang.Math.acos(dSin4) / 6.283185307179586d);
        java.lang.Double.isNaN(dAcos);
        this.sunset = java.lang.Math.round((dSin3 + dAcos) * 8.64E7d) + UTC_2000;
        java.lang.Double.isNaN(dAcos);
        this.sunrise = java.lang.Math.round((dSin3 - dAcos) * 8.64E7d) + UTC_2000;
        if (this.sunrise >= j || this.sunset <= j) {
            this.state = 1;
        } else {
            this.state = 0;
        }
    }
}
