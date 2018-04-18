package com.kingja.higo.model.service;

import com.kingja.higo.model.HttpResult;
import com.kingja.higo.model.entiy.Discount;
import com.kingja.higo.model.entiy.Login;
import com.kingja.higo.model.entiy.Message;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
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
//    @POST("login")
    @POST("api/admin/login2")
    Observable<HttpResult<Login>> login(@Field("mobile") String mobile, @Field("password") String password);

    @POST("register")
    Observable<HttpResult<Object>> register(@Field("mobile") String mobile, @Field("password") String password,
                                            @Field("code") String code);

    @POST("modify_password")
    Observable<HttpResult<Object>> modifyPassword(@Field("password") String password, @Field("c_password") String c_password);

    @GET("api/admin/message")
    Observable<HttpResult<List<Message>>> message();

    @GET("me/voucher")
    Observable<HttpResult<List<Discount>>> voucher();
}
