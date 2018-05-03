package com.kingja.higo.page.mine_friends;


import com.kingja.higo.injector.annotation.PerActivity;
import com.kingja.higo.injector.component.AppComponent;

import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class)
public interface MineFriendsCompnent {
    void inject(MineFriendsActivity activity);
}
