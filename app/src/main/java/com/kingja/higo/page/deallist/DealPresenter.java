package com.kingja.higo.page.deallist;

import android.support.annotation.NonNull;

import com.kingja.higo.model.api.UserApi;
import com.kingja.higo.model.entiy.Deal;
import com.kingja.higo.model.entiy.Message;
import com.kingja.higo.page.message.MessageContract;
import com.kingja.higo.rx.ResultObserver;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * Description：TODO
 * Create Time：2016/10/10 16:05
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class DealPresenter implements DealContract.Presenter {
    private UserApi mApi;
    private DealContract.View mView;

    @Inject
    public DealPresenter(UserApi mApi) {
        this.mApi = mApi;
    }

    @Override
    public void attachView(@NonNull DealContract.View view) {
        this.mView = view;
    }

    @Override
    public void detachView() {

    }

    @Override
    public void getDealList() {
        mApi.getUserService().getDealList().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers
                .mainThread()).subscribe
                (new ResultObserver<List<Deal>>(mView) {
                    @Override
                    protected void onSuccess(List<Deal> deals) {
                        mView.onGetDealListSuccess(deals);
                    }
                });
    }
}