package com.wyh.station.net.presenter;

import com.wyh.station.entity.BaseResponse;
import com.wyh.station.net.base.Presenter;
import com.wyh.station.net.base.DataCallBack;
import com.wyh.station.net.model.LoginModel;

public class LoginPresenter extends Presenter {
    /**
     * 登录
     *
     * @param name           用户名
     * @param password       密码
     * @param identification 请求识别码
     */
    public void attemptLogin(String name, String password, int identification) {
        mModelManager.getLoginModel().attemptLogin(name, password, new DataCallBack<BaseResponse<LoginModel>>(getPortCallBack(),identification));
    }
}
