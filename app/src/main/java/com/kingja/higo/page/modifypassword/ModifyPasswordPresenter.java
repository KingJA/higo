package com.kingja.higo.page.modifypassword;

import android.support.annotation.NonNull;

import com.kingja.higo.model.api.UserApi;
import com.kingja.higo.rx.ResultObserver;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * Description：TODO
 * Create Time：2016/10/10 16:05
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class ModifyPasswordPresenter implements ModifyPasswordContract.Presenter {
    private UserApi mApi;
    private ModifyPasswordContract.View mView;

    @Inject
    public ModifyPasswordPresenter(UserApi mApi) {
        this.mApi = mApi;
    }

    @Override
    public void attachView(@NonNull ModifyPasswordContract.View view) {
        this.mView = view;
    }

    @Override
    public void detachView() {

    }

    @Override
    public void modifyPassword(String newPassword, String repeatPassword) {
        mApi.getUserService().modifyPassword(newPassword, repeatPassword).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers
                .mainThread()).subscribe
                (new ResultObserver<Object>(mView) {
                    @Override
                    protected void onSuccess(Object obj) {
                        mView.onModifyPasswordSuccess();
                    }
                });
    }
}