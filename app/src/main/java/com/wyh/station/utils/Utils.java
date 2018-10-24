package com.wyh.station.utils;

public class Utils {

    /**
     * 判断所给对象是否为空
     *
     * @param parameter 被判断的对象
     * @param <T>       对象类型
     * @return true no-null  false others
     */
    public static <T> boolean isNull(T parameter) {
        return parameter != null;
    }
}
