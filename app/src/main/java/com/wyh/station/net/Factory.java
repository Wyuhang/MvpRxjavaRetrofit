package com.wyh.station.net;

import com.wyh.station.Constant;
import com.wyh.station.net.interfaces.RetrieveApiListener;
import com.wyh.station.net.interfaces.StationApi;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Factory {
    private StationApi mStationApi;

    private Factory() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(5000, TimeUnit.MILLISECONDS);
        builder.readTimeout(5000, TimeUnit.MILLISECONDS);
        builder.writeTimeout(5000, TimeUnit.MILLISECONDS);
        builder.retryOnConnectionFailure(true);
        OkHttpClient client = builder.build();

//        Interceptor interceptor = new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                //获取请求的Url
//                HttpUrl httpUrl = chain.request().url();
//                //为httpUrl添加固定请求参数
//                HttpUrl fixParamUrl = httpUrl
//                        .newBuilder()
//                        .addQueryParameter("key", "param")
//                        .build();
//
//                Request request = chain
//                        .request()
//                        .newBuilder()
//                        .addHeader("name","value")
//                         .url(fixParamUrl)
//                        .build();
//                Response response = chain.proceed(request);
//                return response.newBuilder().body(response.body()).build();
//
//            }
//        };
//
//        client.interceptors().add(interceptor);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();

        mStationApi = retrofit.create(StationApi.class);
    }

    public <T> Observable<T> retrieveObservable(RetrieveApiListener<T> listener) {
        return listener.retrieve(mStationApi);
    }

    private static final class Builder {
        private static final Factory INSTANCE = new Factory();
    }

    public static Factory getInstance() {
        return Builder.INSTANCE;
    }
}
