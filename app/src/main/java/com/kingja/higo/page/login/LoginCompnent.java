package com.kingja.higo.page.login;


import com.kingja.higo.injector.annotation.PerActivity;
import com.kingja.higo.injector.component.AppComponent;
import com.kingja.higo.injector.module.ActivityModule;

import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class})
public interface LoginCompnent {
    void inject(LoginActivity activity);
}
