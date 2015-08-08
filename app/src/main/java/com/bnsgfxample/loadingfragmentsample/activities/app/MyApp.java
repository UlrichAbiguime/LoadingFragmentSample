package com.bnsgfxample.loadingfragmentsample.activities.app;

import android.app.Application;

/**
 * Created by UlrichAbiguime at Shenzhen.
 */
public class MyApp extends Application {


    // 杀进程
    @Override
    public void onLowMemory() {
        // TODO Auto-generated method stub
        super.onLowMemory();
        System.gc();
    }
}
