package oicq.wlogin_sdk.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface WtTicketPromise {
    void Done(oicq.wlogin_sdk.request.Ticket ticket);

    void Failed(oicq.wlogin_sdk.tools.ErrMsg errMsg);

    void Timeout(oicq.wlogin_sdk.tools.ErrMsg errMsg);
}
