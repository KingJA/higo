package com.kingja.higo.page.message;


import com.kingja.higo.injector.annotation.PerActivity;
import com.kingja.higo.injector.component.AppComponent;

import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class)
public interface MessageCompnent {
    void inject(MessageActivity activity);
}
