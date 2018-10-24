package com.wyh.station.net;

import com.wyh.station.net.model.LoginModel;

public class ModelBuilder {

    private LoginModel mLoginModel;

    private ModelBuilder() {
        mLoginModel = new LoginModel();
    }

    private static class Builder {
        private static final ModelBuilder INSTANCE = new ModelBuilder();
    }

    public static ModelBuilder getInstance() {
        return Builder.INSTANCE;
    }

    public LoginModel getLoginModel() {
        return mLoginModel;
    }

}
