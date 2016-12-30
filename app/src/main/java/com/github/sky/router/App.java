package com.github.sky.router;

import android.app.Application;

/**
 * Created by fuyuxian on 2016/12/30.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RouterManager.init();
    }
}
