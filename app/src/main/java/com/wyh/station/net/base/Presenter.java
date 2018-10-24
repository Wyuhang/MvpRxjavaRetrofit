package com.wyh.station.net.base;

import com.wyh.station.net.ModelBuilder;
import com.wyh.station.net.interfaces.ViewPortCallBack;

public abstract class Presenter {

    private ViewPortCallBack mPortCallBack;
    protected ModelBuilder mModelManager;

    public void attach(ViewPortCallBack callBack) {
        mPortCallBack = callBack;
        mModelManager = ModelBuilder.getInstance();
    }

    public void detach() {
        mPortCallBack = null;
    }

    public ViewPortCallBack getPortCallBack() {
        return mPortCallBack;
    }
}
