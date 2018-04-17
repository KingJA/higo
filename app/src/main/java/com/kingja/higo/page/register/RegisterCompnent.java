package com.kingja.higo.page.register;


import com.kingja.higo.injector.annotation.PerActivity;
import com.kingja.higo.injector.component.AppComponent;

import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class)
public interface RegisterCompnent {
    void inject(RegisterActivity activity);
}
