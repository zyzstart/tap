package android.support.v4.hardware.fingerprint;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class FingerprintManagerCompat {
    static final android.support.v4.hardware.fingerprint.FingerprintManagerCompat.FingerprintManagerCompatImpl IMPL;
    private android.content.Context mContext;

    @android.support.annotation.RequiresApi(23)
    private static class Api23FingerprintManagerCompatImpl implements android.support.v4.hardware.fingerprint.FingerprintManagerCompat.FingerprintManagerCompatImpl {
        static android.support.v4.hardware.fingerprint.FingerprintManagerCompat.CryptoObject unwrapCryptoObject(android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23.CryptoObject cryptoObject) {
            if (cryptoObject == null) {
                return null;
            }
            if (cryptoObject.getCipher() != null) {
                return new android.support.v4.hardware.fingerprint.FingerprintManagerCompat.CryptoObject(cryptoObject.getCipher());
            }
            if (cryptoObject.getSignature() != null) {
                return new android.support.v4.hardware.fingerprint.FingerprintManagerCompat.CryptoObject(cryptoObject.getSignature());
            }
            if (cryptoObject.getMac() != null) {
                return new android.support.v4.hardware.fingerprint.FingerprintManagerCompat.CryptoObject(cryptoObject.getMac());
            }
            return null;
        }

        private static android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23.AuthenticationCallback wrapCallback(final android.support.v4.hardware.fingerprint.FingerprintManagerCompat.AuthenticationCallback authenticationCallback) {
            return new android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23.AuthenticationCallback() { // from class: android.support.v4.hardware.fingerprint.FingerprintManagerCompat.Api23FingerprintManagerCompatImpl.1
                @Override // android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23.AuthenticationCallback
                public void onAuthenticationError(int i, java.lang.CharSequence charSequence) {
                    authenticationCallback.onAuthenticationError(i, charSequence);
                }

                @Override // android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23.AuthenticationCallback
                public void onAuthenticationFailed() {
                    authenticationCallback.onAuthenticationFailed();
                }

                @Override // android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23.AuthenticationCallback
                public void onAuthenticationHelp(int i, java.lang.CharSequence charSequence) {
                    authenticationCallback.onAuthenticationHelp(i, charSequence);
                }

                @Override // android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23.AuthenticationCallback
                public void onAuthenticationSucceeded(android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23.AuthenticationResultInternal authenticationResultInternal) {
                    authenticationCallback.onAuthenticationSucceeded(new android.support.v4.hardware.fingerprint.FingerprintManagerCompat.AuthenticationResult(android.support.v4.hardware.fingerprint.FingerprintManagerCompat.Api23FingerprintManagerCompatImpl.unwrapCryptoObject(authenticationResultInternal.getCryptoObject())));
                }
            };
        }

        private static android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23.CryptoObject wrapCryptoObject(android.support.v4.hardware.fingerprint.FingerprintManagerCompat.CryptoObject cryptoObject) {
            if (cryptoObject == null) {
                return null;
            }
            if (cryptoObject.getCipher() != null) {
                return new android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23.CryptoObject(cryptoObject.getCipher());
            }
            if (cryptoObject.getSignature() != null) {
                return new android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23.CryptoObject(cryptoObject.getSignature());
            }
            if (cryptoObject.getMac() != null) {
                return new android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23.CryptoObject(cryptoObject.getMac());
            }
            return null;
        }

        @Override // android.support.v4.hardware.fingerprint.FingerprintManagerCompat.FingerprintManagerCompatImpl
        public void authenticate(android.content.Context context, android.support.v4.hardware.fingerprint.FingerprintManagerCompat.CryptoObject cryptoObject, int i, android.support.v4.os.CancellationSignal cancellationSignal, android.support.v4.hardware.fingerprint.FingerprintManagerCompat.AuthenticationCallback authenticationCallback, android.os.Handler handler) {
            android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23.authenticate(context, wrapCryptoObject(cryptoObject), i, cancellationSignal != null ? cancellationSignal.getCancellationSignalObject() : null, wrapCallback(authenticationCallback), handler);
        }

        @Override // android.support.v4.hardware.fingerprint.FingerprintManagerCompat.FingerprintManagerCompatImpl
        public boolean hasEnrolledFingerprints(android.content.Context context) {
            return android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23.hasEnrolledFingerprints(context);
        }

        @Override // android.support.v4.hardware.fingerprint.FingerprintManagerCompat.FingerprintManagerCompatImpl
        public boolean isHardwareDetected(android.content.Context context) {
            return android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23.isHardwareDetected(context);
        }
    }

    public static abstract class AuthenticationCallback {
        public void onAuthenticationError(int i, java.lang.CharSequence charSequence) {
        }

        public void onAuthenticationFailed() {
        }

        public void onAuthenticationHelp(int i, java.lang.CharSequence charSequence) {
        }

        public void onAuthenticationSucceeded(android.support.v4.hardware.fingerprint.FingerprintManagerCompat.AuthenticationResult authenticationResult) {
        }
    }

    public static final class AuthenticationResult {
        private android.support.v4.hardware.fingerprint.FingerprintManagerCompat.CryptoObject mCryptoObject;

        public AuthenticationResult(android.support.v4.hardware.fingerprint.FingerprintManagerCompat.CryptoObject cryptoObject) {
            this.mCryptoObject = cryptoObject;
        }

        public android.support.v4.hardware.fingerprint.FingerprintManagerCompat.CryptoObject getCryptoObject() {
            return this.mCryptoObject;
        }
    }

    public static class CryptoObject {
        private final javax.crypto.Cipher mCipher;
        private final javax.crypto.Mac mMac;
        private final java.security.Signature mSignature;

        public CryptoObject(java.security.Signature signature) {
            this.mSignature = signature;
            this.mCipher = null;
            this.mMac = null;
        }

        public CryptoObject(javax.crypto.Cipher cipher) {
            this.mCipher = cipher;
            this.mSignature = null;
            this.mMac = null;
        }

        public CryptoObject(javax.crypto.Mac mac) {
            this.mMac = mac;
            this.mCipher = null;
            this.mSignature = null;
        }

        public javax.crypto.Cipher getCipher() {
            return this.mCipher;
        }

        public javax.crypto.Mac getMac() {
            return this.mMac;
        }

        public java.security.Signature getSignature() {
            return this.mSignature;
        }
    }

    private interface FingerprintManagerCompatImpl {
        void authenticate(android.content.Context context, android.support.v4.hardware.fingerprint.FingerprintManagerCompat.CryptoObject cryptoObject, int i, android.support.v4.os.CancellationSignal cancellationSignal, android.support.v4.hardware.fingerprint.FingerprintManagerCompat.AuthenticationCallback authenticationCallback, android.os.Handler handler);

        boolean hasEnrolledFingerprints(android.content.Context context);

        boolean isHardwareDetected(android.content.Context context);
    }

    private static class LegacyFingerprintManagerCompatImpl implements android.support.v4.hardware.fingerprint.FingerprintManagerCompat.FingerprintManagerCompatImpl {
        @Override // android.support.v4.hardware.fingerprint.FingerprintManagerCompat.FingerprintManagerCompatImpl
        public void authenticate(android.content.Context context, android.support.v4.hardware.fingerprint.FingerprintManagerCompat.CryptoObject cryptoObject, int i, android.support.v4.os.CancellationSignal cancellationSignal, android.support.v4.hardware.fingerprint.FingerprintManagerCompat.AuthenticationCallback authenticationCallback, android.os.Handler handler) {
        }

        @Override // android.support.v4.hardware.fingerprint.FingerprintManagerCompat.FingerprintManagerCompatImpl
        public boolean hasEnrolledFingerprints(android.content.Context context) {
            return false;
        }

        @Override // android.support.v4.hardware.fingerprint.FingerprintManagerCompat.FingerprintManagerCompatImpl
        public boolean isHardwareDetected(android.content.Context context) {
            return false;
        }
    }

    static {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            IMPL = new android.support.v4.hardware.fingerprint.FingerprintManagerCompat.Api23FingerprintManagerCompatImpl();
        } else {
            IMPL = new android.support.v4.hardware.fingerprint.FingerprintManagerCompat.LegacyFingerprintManagerCompatImpl();
        }
    }

    private FingerprintManagerCompat(android.content.Context context) {
        this.mContext = context;
    }

    public static android.support.v4.hardware.fingerprint.FingerprintManagerCompat from(android.content.Context context) {
        return new android.support.v4.hardware.fingerprint.FingerprintManagerCompat(context);
    }

    public void authenticate(@android.support.annotation.Nullable android.support.v4.hardware.fingerprint.FingerprintManagerCompat.CryptoObject cryptoObject, int i, @android.support.annotation.Nullable android.support.v4.os.CancellationSignal cancellationSignal, @android.support.annotation.NonNull android.support.v4.hardware.fingerprint.FingerprintManagerCompat.AuthenticationCallback authenticationCallback, @android.support.annotation.Nullable android.os.Handler handler) {
        IMPL.authenticate(this.mContext, cryptoObject, i, cancellationSignal, authenticationCallback, handler);
    }

    public boolean hasEnrolledFingerprints() {
        return IMPL.hasEnrolledFingerprints(this.mContext);
    }

    public boolean isHardwareDetected() {
        return IMPL.isHardwareDetected(this.mContext);
    }
}
