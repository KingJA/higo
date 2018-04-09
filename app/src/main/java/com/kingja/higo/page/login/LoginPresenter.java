package com.kingja.higo.page.login;

import android.support.annotation.NonNull;

import com.kingja.higo.model.api.UserApi;
import com.kingja.higo.model.entiy.User;
import com.kingja.higo.rx.ResultObserver;

import javax.inject.Inject;


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
    public void login(String username, String password) {
        mView.showLoading();
        mApi.login(username, password).subscribe(new ResultObserver<User>(mView) {
            @Override
            protected void onSuccess(User user) {
                mView.onLoginSuccess(user);
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