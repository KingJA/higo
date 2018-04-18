package com.kingja.higo.page.modifypassword;


import com.kingja.higo.injector.annotation.PerActivity;
import com.kingja.higo.injector.component.AppComponent;
import com.kingja.higo.injector.module.ActivityModule;
import com.kingja.higo.page.login.LoginActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class})
public interface ModifyPasswordCompnent {
    void inject(ModifyPasswordActivity activity);
}
