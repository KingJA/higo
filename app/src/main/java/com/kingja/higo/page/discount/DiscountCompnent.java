package com.kingja.higo.page.discount;


import com.kingja.higo.injector.annotation.PerActivity;
import com.kingja.higo.injector.component.AppComponent;
import com.kingja.higo.page.message.MsgActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class)
public interface DiscountCompnent {
    void inject(DiscountActivity activity);
}
