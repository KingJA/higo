package com.kingja.higo.injector.component;


import android.app.Application;

import com.kingja.higo.imgaeloader.IImageLoader;
import com.kingja.higo.injector.module.ApiModule;
import com.kingja.higo.injector.module.AppModule;
import com.kingja.higo.injector.module.ImageLoaderModule;
import com.kingja.higo.injector.module.SharedPreferencesModule;
import com.kingja.higo.model.Api;
import com.kingja.higo.util.SharedPreferencesManager;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 项目名称：
 * 类描述：TODO
 * 创建人：KingJA
 * 创建时间：2016/6/13 9:42
 * 修改备注：
 */
@Singleton
@Component(modules = {ApiModule.class, AppModule.class, SharedPreferencesModule.class,ImageLoaderModule.class})
public interface AppComponent {
    Api getApi();
    SharedPreferencesManager getSharedPreferencesManager();
    Application getApplication();
    IImageLoader getImageLoader();
}
