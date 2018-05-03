package com.kingja.higo.page.forgetpassword;


import com.kingja.higo.injector.annotation.PerActivity;
import com.kingja.higo.injector.component.AppComponent;
import com.kingja.higo.page.register.RegisterActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class)
public interface ForgetPasswordCompnent {
    void inject(ForgetPasswordActivity activity);
}
