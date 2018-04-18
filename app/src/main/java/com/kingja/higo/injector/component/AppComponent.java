package com.kingja.higo.injector.component;


import android.app.Application;

import com.kingja.higo.imgaeloader.IImageLoader;
import com.kingja.higo.injector.module.ApiModule;
import com.kingja.higo.injector.module.AppModule;
import com.kingja.higo.injector.module.ImageLoaderModule;
import com.kingja.higo.injector.module.SpModule;
import com.kingja.higo.model.api.UserApi;
import com.kingja.higo.util.SpManager;

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
@Component(modules = {ApiModule.class, AppModule.class, SpModule.class,ImageLoaderModule.class})
public interface AppComponent {
    UserApi getApi();
    SpManager getSpManager();
    Application getApplication();
    IImageLoader getImageLoader();
}
