package com.kingja.higo.page.wallet;

import com.kingja.higo.base.BasePresenter;
import com.kingja.higo.base.BaseView;
import com.kingja.higo.model.entiy.Discount;
import com.kingja.higo.model.entiy.Wallet;

import java.util.List;

/**
 * Description：TODO
 * Create Time：2016/10/10 14:38
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public interface WalletContract {
    interface View extends BaseView {
        void onGetWalletSuccess(Wallet wallet);
    }

    interface Presenter extends BasePresenter<View> {
        void getWallet();

    }
}
