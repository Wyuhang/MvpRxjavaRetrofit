package com.wyh.station.net.interfaces;

import com.wyh.station.net.base.Model;

import io.reactivex.Observable;

/**
 * RetrieveApiListener
 * wangyuhang
 * created 2018/10/23 9:46
 * 将{@link com.wyh.station.net.Factory#mStationApi}
 * 回调给{@link Model}的子类
 * 使用。将请求参数拼装成符合{@link StationApi}要求的Observable
 */
public interface RetrieveApiListener<T> {
    Observable<T> retrieve(StationApi api);
}
