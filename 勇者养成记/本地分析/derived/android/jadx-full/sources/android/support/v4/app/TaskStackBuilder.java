package android.support.v4.app;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class TaskStackBuilder implements java.lang.Iterable<android.content.Intent> {
    private static final android.support.v4.app.TaskStackBuilder.TaskStackBuilderBaseImpl IMPL;
    private static final java.lang.String TAG = "TaskStackBuilder";
    private final java.util.ArrayList<android.content.Intent> mIntents = new java.util.ArrayList<>();
    private final android.content.Context mSourceContext;

    public interface SupportParentable {
        android.content.Intent getSupportParentActivityIntent();
    }

    @android.support.annotation.RequiresApi(16)
    static class TaskStackBuilderApi16Impl extends android.support.v4.app.TaskStackBuilder.TaskStackBuilderBaseImpl {
        TaskStackBuilderApi16Impl() {
        }

        @Override // android.support.v4.app.TaskStackBuilder.TaskStackBuilderBaseImpl
        public android.app.PendingIntent getPendingIntent(android.content.Context context, android.content.Intent[] intentArr, int i, int i2, android.os.Bundle bundle) {
            intentArr[0] = new android.content.Intent(intentArr[0]).addFlags(268484608);
            return android.app.PendingIntent.getActivities(context, i, intentArr, i2, bundle);
        }
    }

    static class TaskStackBuilderBaseImpl {
        TaskStackBuilderBaseImpl() {
        }

        public android.app.PendingIntent getPendingIntent(android.content.Context context, android.content.Intent[] intentArr, int i, int i2, android.os.Bundle bundle) {
            intentArr[0] = new android.content.Intent(intentArr[0]).addFlags(268484608);
            return android.app.PendingIntent.getActivities(context, i, intentArr, i2);
        }
    }

    static {
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            IMPL = new android.support.v4.app.TaskStackBuilder.TaskStackBuilderApi16Impl();
        } else {
            IMPL = new android.support.v4.app.TaskStackBuilder.TaskStackBuilderBaseImpl();
        }
    }

    private TaskStackBuilder(android.content.Context context) {
        this.mSourceContext = context;
    }

    public static android.support.v4.app.TaskStackBuilder create(android.content.Context context) {
        return new android.support.v4.app.TaskStackBuilder(context);
    }

    @java.lang.Deprecated
    public static android.support.v4.app.TaskStackBuilder from(android.content.Context context) {
        return create(context);
    }

    public android.support.v4.app.TaskStackBuilder addNextIntent(android.content.Intent intent) {
        this.mIntents.add(intent);
        return this;
    }

    public android.support.v4.app.TaskStackBuilder addNextIntentWithParentStack(android.content.Intent intent) {
        android.content.ComponentName component = intent.getComponent();
        if (component == null) {
            component = intent.resolveActivity(this.mSourceContext.getPackageManager());
        }
        if (component != null) {
            addParentStack(component);
        }
        addNextIntent(intent);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public android.support.v4.app.TaskStackBuilder addParentStack(android.app.Activity activity) {
        android.content.Intent supportParentActivityIntent = activity instanceof android.support.v4.app.TaskStackBuilder.SupportParentable ? ((android.support.v4.app.TaskStackBuilder.SupportParentable) activity).getSupportParentActivityIntent() : null;
        if (supportParentActivityIntent == null) {
            supportParentActivityIntent = android.support.v4.app.NavUtils.getParentActivityIntent(activity);
        }
        if (supportParentActivityIntent != null) {
            android.content.ComponentName component = supportParentActivityIntent.getComponent();
            if (component == null) {
                component = supportParentActivityIntent.resolveActivity(this.mSourceContext.getPackageManager());
            }
            addParentStack(component);
            addNextIntent(supportParentActivityIntent);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public android.support.v4.app.TaskStackBuilder addParentStack(android.content.ComponentName componentName) {
        int size = this.mIntents.size();
        try {
            android.content.Intent parentActivityIntent = android.support.v4.app.NavUtils.getParentActivityIntent(this.mSourceContext, componentName);
            while (parentActivityIntent != null) {
                this.mIntents.add(size, parentActivityIntent);
                parentActivityIntent = android.support.v4.app.NavUtils.getParentActivityIntent(this.mSourceContext, parentActivityIntent.getComponent());
            }
            return this;
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            android.util.Log.e(TAG, "Bad ComponentName while traversing activity parent metadata");
            throw new java.lang.IllegalArgumentException(e);
        }
    }

    public android.support.v4.app.TaskStackBuilder addParentStack(java.lang.Class<?> cls) {
        return addParentStack(new android.content.ComponentName(this.mSourceContext, cls));
    }

    public android.content.Intent editIntentAt(int i) {
        return this.mIntents.get(i);
    }

    @java.lang.Deprecated
    public android.content.Intent getIntent(int i) {
        return editIntentAt(i);
    }

    public int getIntentCount() {
        return this.mIntents.size();
    }

    public android.content.Intent[] getIntents() {
        android.content.Intent[] intentArr = new android.content.Intent[this.mIntents.size()];
        if (intentArr.length == 0) {
            return intentArr;
        }
        intentArr[0] = new android.content.Intent(this.mIntents.get(0)).addFlags(268484608);
        for (int i = 1; i < intentArr.length; i++) {
            intentArr[i] = new android.content.Intent(this.mIntents.get(i));
        }
        return intentArr;
    }

    public android.app.PendingIntent getPendingIntent(int i, int i2) {
        return getPendingIntent(i, i2, null);
    }

    public android.app.PendingIntent getPendingIntent(int i, int i2, android.os.Bundle bundle) {
        if (this.mIntents.isEmpty()) {
            throw new java.lang.IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
        }
        java.util.ArrayList<android.content.Intent> arrayList = this.mIntents;
        android.content.Intent[] intentArr = (android.content.Intent[]) arrayList.toArray(new android.content.Intent[arrayList.size()]);
        intentArr[0] = new android.content.Intent(intentArr[0]).addFlags(268484608);
        return IMPL.getPendingIntent(this.mSourceContext, intentArr, i, i2, bundle);
    }

    @Override // java.lang.Iterable
    @java.lang.Deprecated
    public java.util.Iterator<android.content.Intent> iterator() {
        return this.mIntents.iterator();
    }

    public void startActivities() {
        startActivities(null);
    }

    public void startActivities(android.os.Bundle bundle) {
        if (this.mIntents.isEmpty()) {
            throw new java.lang.IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        java.util.ArrayList<android.content.Intent> arrayList = this.mIntents;
        android.content.Intent[] intentArr = (android.content.Intent[]) arrayList.toArray(new android.content.Intent[arrayList.size()]);
        intentArr[0] = new android.content.Intent(intentArr[0]).addFlags(268484608);
        if (android.support.v4.content.ContextCompat.startActivities(this.mSourceContext, intentArr, bundle)) {
            return;
        }
        android.content.Intent intent = new android.content.Intent(intentArr[intentArr.length - 1]);
        intent.addFlags(268435456);
        this.mSourceContext.startActivity(intent);
    }
}
