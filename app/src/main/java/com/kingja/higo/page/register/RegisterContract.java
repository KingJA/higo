package com.kingja.higo.page.register;

import com.kingja.higo.base.BasePresenter;
import com.kingja.higo.base.BaseView;

/**
 * Description：TODO
 * Create Time：2016/10/10 14:38
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public interface RegisterContract {
    interface View extends BaseView {
        void onRegisterSuccess();
    }

    interface Presenter extends BasePresenter<View> {
        void register(String mobile, String password, String code);

    }
}
