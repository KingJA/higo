package com.kingja.higo.rx;

import com.kingja.higo.base.BaseView;
import com.kingja.higo.model.HttpResult;
import com.kingja.higo.util.ToastUtil;
import com.orhanobut.logger.Logger;

import io.reactivex.observers.DefaultObserver;

/**
 * Description：TODO
 * Create Time：2016/10/12 15:56
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public abstract class ResultObserver<T> extends DefaultObserver<HttpResult<T>> {
    private BaseView baseView;

    public ResultObserver(BaseView baseView) {
        this.baseView = baseView;
    }

    @Override
    protected void onStart() {
        super.onStart();
        baseView.showLoading();
        RxRe.getInstance().add(baseView, this);
    }

    @Override
    public void onNext(HttpResult<T> httpResult) {
        baseView.hideLoading();
        if (httpResult.getResultCode() == 0) {
            onSuccess(httpResult.getResultData());
        } else {
            ToastUtil.showText(httpResult.getResultText());
        }
    }

    protected abstract void onSuccess(T t);

    @Override
    public void onError(Throwable e) {
        //记录错误
        Logger.e(e.toString());
        baseView.hideLoading();
    }

    @Override
    public void onComplete() {

    }

    public void cancleRequest() {
        cancel();
    }
}
