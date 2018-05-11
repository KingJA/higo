package com.kingja.higo.page.setting;


import com.kingja.higo.injector.annotation.PerActivity;
import com.kingja.higo.injector.component.AppComponent;

import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class)
public interface SettingCompnent {
    void inject(SettingActivity activity);
}
