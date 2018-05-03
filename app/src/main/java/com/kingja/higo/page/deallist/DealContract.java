package com.kingja.higo.page.deallist;

import com.kingja.higo.base.BasePresenter;
import com.kingja.higo.base.BaseView;
import com.kingja.higo.model.entiy.Deal;
import com.kingja.higo.model.entiy.Message;

import java.util.List;

/**
 * Description：TODO
 * Create Time：2016/10/10 14:38
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public interface DealContract {
    interface View extends BaseView {
        void onGetDealListSuccess(List<Deal> deals);
    }

    interface Presenter extends BasePresenter<View> {
        void getDealList();

    }
}
