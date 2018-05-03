package com.kingja.higo.page.modify_nickname;


import com.kingja.higo.injector.annotation.PerActivity;
import com.kingja.higo.injector.component.AppComponent;
import com.kingja.higo.page.forgetpassword.ForgetPasswordActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class)
public interface ModifyNicknameCompnent {
    void inject(ModifyNicknameActivity activity);
}
