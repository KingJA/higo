package com.kingja.higo.page.deallist;


import com.kingja.higo.injector.annotation.PerActivity;
import com.kingja.higo.injector.component.AppComponent;
import com.kingja.higo.page.message.MessageActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class)
public interface DealCompnent {
    void inject(DealListActivity activity);
}
