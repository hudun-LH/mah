package top.jplayer.baseprolibrary.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;

import java.lang.ref.WeakReference;

/**
 * Created by Obl on 2018/1/18.
 * top.jplayer.baseprolibrary.utils
 */

public class ActivityUtils {
    private static ActivityUtils activityUtils;

    public static synchronized ActivityUtils init() {
        if (activityUtils == null) {
            synchronized (ActivityUtils.class) {
                if (activityUtils == null) {
                    activityUtils = new ActivityUtils();
                }
            }
        }
        return activityUtils;
    }

    public void start(Context context, Class tClass, MotionEvent event) {
        Intent i = new Intent(context, tClass);
        i.putExtra("x", (int) event.getX());
        i.putExtra("y", (int) event.getY());
        context.startActivity(i);
    }

    public void start(Context context, Class tClass, String title, Bundle bundle) {
        WeakReference<Context> weakReference = new WeakReference<>(context);
        Intent i = new Intent(context, tClass);
        if (title != null) i.putExtra("title", title);
        if (bundle != null) i.putExtra("bundle", bundle);
        weakReference.get().startActivity(i);
    }

    public void startConversion(Context context, Class clazz, String uid) {
        WeakReference<Context> weakReference = new WeakReference<>(context);
        Intent intent = new Intent(weakReference.get(), clazz);
        intent.putExtra("title", "客服");
        intent.putExtra("uid", uid);
        intent.setAction("android.groupIntent.action.VIEW");
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setData(Uri.parse("rong://com.ilanchuang.xiaoi/conversation/private/?targetId=" + uid));
        weakReference.get().startActivity(intent);
    }

    public void start(Context context, Class tClass) {
        start(context, tClass, null, null);
    }

    public void start(Context context, Class tClass, String title) {
        start(context, tClass, title, null);
    }
}
