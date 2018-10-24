package com.wyh.station.net.model;


import com.wyh.station.entity.BaseResponse;
import com.wyh.station.net.base.Model;
import com.wyh.station.net.base.DataCallBack;
import com.wyh.station.net.interfaces.RetrieveApiListener;
import com.wyh.station.net.interfaces.StationApi;

import io.reactivex.Observable;

public class LoginModel extends Model<BaseResponse<LoginModel>> {

    public void attemptLogin(final String name, final String password, DataCallBack<BaseResponse<LoginModel>> callBack) {
        obtain(new RetrieveApiListener<BaseResponse<LoginModel>>() {
            @Override
            public Observable<BaseResponse<LoginModel>> retrieve(StationApi api) {
                return api.login(name,password);
            }
        }, callBack);
    }
}
