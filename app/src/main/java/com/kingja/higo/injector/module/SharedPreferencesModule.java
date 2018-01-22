package com.kingja.higo.injector.module;

import android.app.Application;


import com.kingja.higo.util.SharedPreferencesIO;
import com.kingja.higo.util.SharedPreferencesManager;

import dagger.Module;
import dagger.Provides;

/**
 * 项目名称：
 * 类描述：TODO
 * 创建人：KingJA
 * 创建时间：2016/6/13 9:48
 * 修改备注：
 */
@Module
public class SharedPreferencesModule {
    public SharedPreferencesModule() {
    }

    @Provides
    public SharedPreferencesIO provideSharedPreferencesIO(Application application) {
        return new SharedPreferencesIO(application);
    }

    @Provides
    public SharedPreferencesManager provideSharedPreferencesManager(SharedPreferencesIO sharedPreferencesIO) {
        return new SharedPreferencesManager(sharedPreferencesIO);
    }

}
