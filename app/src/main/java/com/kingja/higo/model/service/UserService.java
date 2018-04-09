package com.kingja.higo.model.service;

import com.kingja.higo.model.HttpResult;
import com.kingja.higo.model.entiy.User;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * 项目名称：和Api相关联
 * 类描述：TODO
 * 创建人：KingJA
 * 创建时间：2016/6/12 16:32
 * 修改备注：
 */
public interface UserService {

    @FormUrlEncoded
    @POST("api/admin/login")
    Observable<HttpResult<User>> login(@Field("username") String uername, @Field("password") String password);
}
