package administrator.duomengde.com.base;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.Build;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import administrator.duomengde.com.utils.NetBroadcastReceiver;

public class BaseApp extends Application {
    protected static BaseApp mBasseApp;
    protected NetBroadcastReceiver mNetBroadcastReceiver;

    public static BaseApp getInstance() {
        return mBasseApp;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        mBasseApp =this;

        if (Build.VERSION.SDK_INT >= 28) {
            closeAndroidPDialog();
        }

    }

    public static Context getAppContext(){
        return mBasseApp.getApplicationContext();
    }

    /**
     * 通过反射解决在Android 9.0 (Android P) 出现的错误弹窗
     */
    private void closeAndroidPDialog() {
        try {
            @SuppressLint("PrivateApi") Class aClass = Class.forName("android.content.pm.PackageParser$Package");
            Constructor declaredConstructor = aClass.getDeclaredConstructor(String.class);
            declaredConstructor.setAccessible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            @SuppressLint("PrivateApi") Class cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread");
            declaredMethod.setAccessible(true);
            Object activityThread = declaredMethod.invoke(null);
            Field mHiddenApiWarningShown = cls.getDeclaredField("mHiddenApiWarningShown");
            mHiddenApiWarningShown.setAccessible(true);
            mHiddenApiWarningShown.setBoolean(activityThread, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
