package com.kingja.higo.page.mine;


import com.kingja.higo.injector.annotation.PerActivity;
import com.kingja.higo.injector.component.AppComponent;

import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class)
public interface MineCompnent {
    void inject(MineFragment fragment);
}
