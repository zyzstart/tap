package oicq.wlogin_sdk.quicklogin;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class QuickLoginWebViewActivity extends android.app.Activity {
    @Override // android.app.Activity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        oicq.wlogin_sdk.quicklogin.QuickLoginWebViewLoader.load(this, getIntent());
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        oicq.wlogin_sdk.tools.util.LOGI("device back button clicked", "");
        finish();
        if (oicq.wlogin_sdk.quicklogin.QuickLoginWebViewLoader.finishAnimEnter == 0 && oicq.wlogin_sdk.quicklogin.QuickLoginWebViewLoader.finishAnimExit == 0) {
            return false;
        }
        overridePendingTransition(oicq.wlogin_sdk.quicklogin.QuickLoginWebViewLoader.finishAnimEnter, oicq.wlogin_sdk.quicklogin.QuickLoginWebViewLoader.finishAnimExit);
        return false;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(android.view.MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        oicq.wlogin_sdk.tools.util.LOGI("onOptionsItemSelected clicked", "");
        finish();
        return super.onOptionsItemSelected(menuItem);
    }
}
