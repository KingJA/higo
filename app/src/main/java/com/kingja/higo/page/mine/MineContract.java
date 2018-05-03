package com.kingja.higo.page.mine;

import com.kingja.higo.base.BasePresenter;
import com.kingja.higo.base.BaseView;
import com.kingja.higo.model.entiy.Message;
import com.kingja.higo.model.entiy.PersonalInfo;

import java.util.List;

/**
 * Description：TODO
 * Create Time：2016/10/10 14:38
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public interface MineContract {
    interface View extends BaseView {
        void onGetPersonalInfoSuccess(PersonalInfo personalInfo);
    }

    interface Presenter extends BasePresenter<View> {
        void getPersonalInfo(String uid);

    }
}
