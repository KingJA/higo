package com.kingja.higo.page.wallet;


import com.kingja.higo.injector.annotation.PerActivity;
import com.kingja.higo.injector.component.AppComponent;

import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class)
public interface WalletCompnent {
    void inject(WalletActivity activity);
}
