package com.kingja.higo.page.login;

import android.support.annotation.NonNull;

import com.kingja.higo.model.api.UserApi;
import com.kingja.higo.model.entiy.Login;
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
public class LoginPresenter implements LoginContract.Presenter {
    private UserApi mApi;
    private LoginContract.View mView;

    @Inject
    public LoginPresenter(UserApi mApi) {
        this.mApi = mApi;
    }

    @Override
    public void login(String mobile, String password) {
        mApi.getUserService().login(mobile, password).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe
                (new ResultObserver<Login>(mView) {
            @Override
            protected void onSuccess(Login login) {
                mView.onLoginSuccess(login);
            }
        });
    }


    @Override
    public void attachView(@NonNull LoginContract.View view) {
        this.mView = view;
    }

    @Override
    public void detachView() {

    }

}