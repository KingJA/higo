package com.kingja.higo.page.login;

import com.kingja.higo.base.BasePresenter;
import com.kingja.higo.base.BaseView;
import com.kingja.higo.model.entiy.Login;

/**
 * Description：TODO
 * Create Time：2016/10/10 14:38
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public interface LoginContract {
    interface View extends BaseView {
        void onLoginSuccess(Login account);
    }

    interface Presenter extends BasePresenter<View> {
        void login(String username, String password);

    }
}
