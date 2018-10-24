package com.wyh.station;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.wyh.station.net.interfaces.ViewPortCallBack;
import com.wyh.station.net.presenter.LoginPresenter;

import io.reactivex.disposables.Disposable;

public class LoginActivity extends AppCompatActivity implements ViewPortCallBack {
    //登录请求识别码
    public static final int CODE_LOGIN = 1;
    //其他请求识别码，当页面有多个请求的时候以此区分
    public static final int CODE_OTHER = 2;

    private LoginPresenter mLoginPresenter;


    private EditText mEtUserName;
    private EditText mEtPassword;
    private Button mBtnLoginIn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        addListener();
    }

    private void initViews() {
        mEtUserName = findViewById(R.id.et_user_name);
        mEtPassword = findViewById(R.id.et_passsword);
        mBtnLoginIn = findViewById(R.id.btn_login_in);
    }

    private void addListener() {
        mBtnLoginIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
//    mLoginPresenter = new LoginPresenter();
//        mLoginPresenter.attach(this);
//
//        mLoginPresenter.attemptLogin("username", "password", CODE_LOGIN);

    @Override
    public void onSuccess(Object data, int identification) {
        switch (identification) {
            case CODE_LOGIN:
                break;
            case CODE_OTHER:
                break;
        }
    }

    @Override
    public void onFailed(String msg, int code, int identification) {

    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onAhead(int identification, Disposable disposable) {

    }

    @Override
    public void onFinish(int identification) {

    }
}
