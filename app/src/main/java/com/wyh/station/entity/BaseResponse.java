package com.wyh.station.entity;

import com.wyh.station.Constant;

public class BaseResponse<T> {
    public int code;
    public String msg;
    public T data;


    public boolean isSuccess() {
        return code == Constant.CODE_RESPONSE;
    }

}
