package com.kingja.higo.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.kingja.higo.callback.EmptyCallback;
import com.kingja.higo.callback.EmptyCartCallback;
import com.kingja.higo.callback.EmptyDealCallback;
import com.kingja.higo.callback.EmptyMsgCallback;
import com.kingja.higo.callback.EmptyOrderCallback;
import com.kingja.higo.callback.ErrorNetworkCallback;
import com.kingja.higo.callback.LoadingCallback;
import com.kingja.higo.constant.Constants;
import com.kingja.higo.injector.component.AppComponent;
import com.kingja.higo.injector.component.DaggerAppComponent;
import com.kingja.higo.injector.module.ApiModule;
import com.kingja.higo.injector.module.AppModule;
import com.kingja.higo.injector.module.SpModule;
import com.kingja.loadsir.core.LoadSir;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;

import java.util.ArrayList;


/**
 * Description：App
 * Create Time：2016/10/14:04
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class App extends MultiDexApplication {
    private static App sInstance;
    private AppComponent appComponent;
    private static SharedPreferences mSharedPreferences;
    private AppModule appModule;

    @Override
    public void onCreate() {
        super.onCreate();
        initLoadSir();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        Logger.addLogAdapter(new AndroidLogAdapter());
        LeakCanary.install(this);
        sInstance = this;
        mSharedPreferences = getSharedPreferences(Constants.APPLICATION_NAME, MODE_PRIVATE);
        setupComponent();
    }

    private void initLoadSir() {
        LoadSir.beginBuilder()
                .addCallback(new ErrorNetworkCallback())
                .addCallback(new EmptyCallback())
                .addCallback(new LoadingCallback())
                .addCallback(new EmptyCartCallback())
                .addCallback(new EmptyOrderCallback())
                .addCallback(new EmptyMsgCallback())
                .addCallback(new EmptyDealCallback())
                .commit();
    }

    private void setupComponent() {
        appComponent = DaggerAppComponent.builder()
                .apiModule(new ApiModule())
                .appModule(new AppModule(this))
                .spModule(new SpModule()).build();
        appModule = new AppModule(this);
    }

    public static App getContext() {
        return sInstance;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public AppModule getAppModule() {
        return appModule;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);/*64K说拜拜*/
    }
}
