package com.kingja.higo.page.discount;

import com.kingja.higo.base.BasePresenter;
import com.kingja.higo.base.BaseView;
import com.kingja.higo.model.entiy.Discount;
import com.kingja.higo.model.entiy.Message;

import java.util.List;

/**
 * Description：TODO
 * Create Time：2016/10/10 14:38
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public interface DiscountContract {
    interface View extends BaseView {
        void onGetDiscountSuccess(List<Discount> discounts);
    }

    interface Presenter extends BasePresenter<View> {
        void getDiscount();

    }
}
