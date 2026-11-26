package com.tencent.beacon.core.network.volley;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ExecutorDelivery implements com.tencent.beacon.core.network.volley.ResponseDelivery {
    private final java.util.concurrent.Executor mResponsePoster;

    private static class ResponseDeliveryRunnable implements java.lang.Runnable {
        private final com.tencent.beacon.core.network.volley.Request mRequest;
        private final com.tencent.beacon.core.network.volley.Response mResponse;
        private final java.lang.Runnable mRunnable;

        public ResponseDeliveryRunnable(com.tencent.beacon.core.network.volley.Request request, com.tencent.beacon.core.network.volley.Response response, java.lang.Runnable runnable) {
            this.mRequest = request;
            this.mResponse = response;
            this.mRunnable = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mRequest.isCanceled()) {
                this.mRequest.finish("canceled-at-delivery");
                return;
            }
            if (this.mResponse.isSuccess()) {
                this.mRequest.deliverResponse(this.mResponse.result);
            } else {
                this.mRequest.deliverError(this.mResponse.error);
            }
            if (this.mResponse.intermediate) {
                this.mRequest.addMarker("intermediate-response");
            } else {
                this.mRequest.finish("done");
            }
            java.lang.Runnable runnable = this.mRunnable;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public ExecutorDelivery(final android.os.Handler handler) {
        this.mResponsePoster = new java.util.concurrent.Executor() { // from class: com.tencent.beacon.core.network.volley.ExecutorDelivery.1
            @Override // java.util.concurrent.Executor
            public void execute(java.lang.Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    public ExecutorDelivery(java.util.concurrent.Executor executor) {
        this.mResponsePoster = executor;
    }

    @Override // com.tencent.beacon.core.network.volley.ResponseDelivery
    public void postError(com.tencent.beacon.core.network.volley.Request request, com.tencent.beacon.core.network.volley.VolleyError volleyError) {
        request.addMarker("post-error");
        this.mResponsePoster.execute(new com.tencent.beacon.core.network.volley.ExecutorDelivery.ResponseDeliveryRunnable(request, com.tencent.beacon.core.network.volley.Response.error(volleyError), null));
    }

    @Override // com.tencent.beacon.core.network.volley.ResponseDelivery
    public void postResponse(com.tencent.beacon.core.network.volley.Request request, com.tencent.beacon.core.network.volley.Response response) {
        postResponse(request, response, null);
    }

    @Override // com.tencent.beacon.core.network.volley.ResponseDelivery
    public void postResponse(com.tencent.beacon.core.network.volley.Request request, com.tencent.beacon.core.network.volley.Response response, java.lang.Runnable runnable) {
        request.markDelivered();
        request.addMarker("post-response");
        this.mResponsePoster.execute(new com.tencent.beacon.core.network.volley.ExecutorDelivery.ResponseDeliveryRunnable(request, response, runnable));
    }
}
