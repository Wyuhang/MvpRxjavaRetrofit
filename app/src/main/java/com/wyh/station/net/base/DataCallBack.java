package com.wyh.station.net.base;


import com.wyh.station.entity.BaseResponse;
import com.wyh.station.net.interfaces.ViewPortCallBack;
import com.wyh.station.utils.Utils;

import io.reactivex.disposables.Disposable;

/**
 * DataCallBack
 * wangyuhang
 * created 2018/10/23 10:15
 * 将{@link DataObserver}的数据回调给发送请求的presenter
 */
public class DataCallBack<T> {
    public static final String TAG = "DataCallBack";
    private ViewPortCallBack mViewPortCallBack;
    private int mIdentification;

    public DataCallBack(ViewPortCallBack callBack, int identification) {
        mViewPortCallBack = callBack;
        mIdentification = identification;
    }

    public void onSuccess(T data) {
        if (data instanceof BaseResponse) {
            BaseResponse response = (BaseResponse) data;
            if (response.isSuccess())
                mViewPortCallBack.onSuccess(((BaseResponse) data).data, mIdentification);
            else {
                mViewPortCallBack.onFailed(response.msg, response.code, mIdentification);
            }
        } else {
            //如果不是 BaseResponse类型数据，直接返回
            mViewPortCallBack.onSuccess(data, mIdentification);
        }
    }

    public void onError(Throwable throwable) {
        mViewPortCallBack.onError(throwable);
    }

    public void onAhead(Disposable disposable) {
        if (Utils.isNull(mViewPortCallBack))
            mViewPortCallBack.onAhead(mIdentification, disposable);
    }

    public void onFinish() {
        mViewPortCallBack.onFinish(mIdentification);
    }
}
