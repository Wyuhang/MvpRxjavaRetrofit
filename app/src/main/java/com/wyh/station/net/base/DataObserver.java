package com.wyh.station.net.base;

import com.wyh.station.utils.Utils;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class DataObserver<T> implements Observer<T> {
    private DataCallBack mDataCallBack;

    public DataObserver(DataCallBack callBack) {
        mDataCallBack = callBack;
    }

    @Override
    public void onSubscribe(Disposable d) {
        if (Utils.isNull(mDataCallBack))
            mDataCallBack.onAhead(d);
        else {
            if (d != null && !d.isDisposed())
                d.dispose();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onNext(T o) {
        mDataCallBack.onSuccess(o);
    }

    @Override
    public void onError(Throwable e) {
        mDataCallBack.onError(e);
    }

    @Override
    public void onComplete() {
        mDataCallBack.onFinish();
    }
}
