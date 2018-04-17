package com.kingja.higo.util;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Description:TODO
 * Create Time:2018/4/17 17:06
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class AddTokenInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (request.body() instanceof FormBody) {
            FormBody.Builder bodyBuilder = new FormBody.Builder();
            FormBody formBody = (FormBody) request.body();
            //把原来的参数添加到新的构造器，（因为没找到直接添加，所以就new新的）
            for (int i = 0; i < formBody.size(); i++) {
                bodyBuilder.addEncoded(formBody.encodedName(i), formBody.encodedValue(i));
            }
            formBody = bodyBuilder
                    .addEncoded("token", "KingJA")
                    .build();
            request = request.newBuilder().post(formBody).build();
        }
        return chain.proceed(request);
    }
}
