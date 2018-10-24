package com.wyh.station.net.interfaces;

import com.wyh.station.entity.BaseResponse;
import com.wyh.station.entity.TestEntity;
import com.wyh.station.net.model.LoginModel;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * StationApi
 * <p>
 * created 2018/10/22 15:36
 * 网络请求接口
 */
public interface StationApi {

    @FormUrlEncoded
    @POST("/user/login")
    Observable<BaseResponse<LoginModel>> login(@Field("userName") String name, @Field("password") String password);

    @GET("users/yuhang")
    Observable<TestEntity> test();
}
