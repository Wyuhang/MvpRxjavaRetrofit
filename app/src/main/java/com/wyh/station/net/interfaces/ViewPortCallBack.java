package com.wyh.station.net.interfaces;

import io.reactivex.disposables.Disposable;

/**
 * ViewPortCallBack
 * wangyuhang
 * created 2018/10/22 15:24
 * 用于将获取到的数据回调给发送请求的activity(fragment)
 */
public interface ViewPortCallBack {

    /**
     * @param data           成功返回的数据
     * @param identification 请求识别码
     *                       请求成功的回调方法
     */
    void onSuccess(Object data, int identification);

    /**
     * @param msg            服务器端发生错误的信息
     * @param code           服务器端错误代码
     * @param identification 请求识别码
     *                       请求失败，服务器端发生错误的回调
     */
    void onFailed(String msg, int code, int identification);

    /**
     * 请求发生异常
     *
     * @param throwable 异常信息
     */
    void onError(Throwable throwable);

    /**
     * @param identification 请求识别码
     * @param disposable     用于中断请求
     *                       请求发起之前，可以执行加载动画的操作等
     */
    void onAhead(int identification, Disposable disposable);

    /**
     * @param identification 请求识别码
     *                       请求数据成功后，结束加载动画
     */
    void onFinish(int identification);
}
