package com.wyh.station.net.base;

import com.wyh.station.net.Factory;
import com.wyh.station.net.interfaces.RetrieveApiListener;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Model
 * wangyuhang
 * created 2018/10/23 9:11
 * 统一处理请求，并将结果回调给请求发起者
 */
public abstract class Model<T> {
    protected void obtain(RetrieveApiListener<T> listener, final DataCallBack<T> callBack) {
        Factory.getInstance()
                .retrieveObservable(listener)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DataObserver<>(callBack));
    }
}
