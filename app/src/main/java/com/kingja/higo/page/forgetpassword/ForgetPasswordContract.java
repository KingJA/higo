package com.kingja.higo.page.forgetpassword;

import com.kingja.higo.base.BasePresenter;
import com.kingja.higo.base.BaseView;

/**
 * Description：TODO
 * Create Time：2016/10/10 14:38
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public interface ForgetPasswordContract {
    interface View extends BaseView {
        void onModifyPasswordSuccess();
        void onGetCodeSuccess();
    }

    interface Presenter extends BasePresenter<View> {
        void modifyPassword(String mobile, String password, String code);

        void getCode(String mobile, String type);

    }
}
