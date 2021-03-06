package com.kingja.higo.injector.component;


import com.kingja.higo.injector.module.AppModule;
import com.kingja.higo.injector.module.SpModule;
import com.kingja.higo.util.AddTokenInterceptor;
import com.kingja.higo.util.SpManager;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 项目名称：
 * 类描述：TODO
 * 创建人：KingJA
 * 创建时间：2016/6/13 9:42
 * 修改备注：*/

@Singleton
@Component(modules = {SpModule.class, AppModule.class})
public interface SpComponent {
    SpManager getSpManager();
    void inject(AddTokenInterceptor target);

}
