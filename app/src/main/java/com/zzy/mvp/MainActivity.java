package com.zzy.mvp;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author zhaozy
 */
public class MainActivity extends BaseMvpActivity<LoginContract.IloginView,LoginContract.IloginPresenter> implements LoginContract.IloginView {

    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.btn_register)
    Button btnRegister;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.progress)
    ProgressBar progress;

    private Context context;

    Handler handler;

    @Override
    protected LoginContract.IloginPresenter createPresenter() {
        return new LoginPersenterImpl();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        this.context = this;
        handler = new Handler();
    }

    @OnClick({R.id.btn_register, R.id.btn_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_register:
                break;
            case R.id.btn_login:
                mPresenter.login(etName.getText().toString(), etPwd.getText().toString());
                break;
        }
    }


    @Override
    public void loginSuccess() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, "登录成功", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onfail() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, "登录失败", Toast.LENGTH_LONG).show();
            }
        });
    }
}
