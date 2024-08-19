package com.example.iconapplication.Utilities;

import android.app.Application;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoader.initImageLoader(this);
    }
}
