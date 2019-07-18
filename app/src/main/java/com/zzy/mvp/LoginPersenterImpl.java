package com.zzy.mvp;

public class LoginPersenterImpl extends BasePresenter<LoginContract.IloginView> implements LoginContract.IloginPresenter {
    LoginModel model;
    @Override
    public void login(String name, String pwd) {
        if (isViewAttached()){
            model = new LoginModel();
        }
        model.login(name, pwd, new ModelListener() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess() {
                getView().loginSuccess();
            }

            @Override
            public void onFailed() {
                getView().onfail();
            }
        });
    }

    @Override
    public void onMvpAttachView(LoginContract.IloginView view) {
        super.onMvpAttachView(view);
    }



    @Override
    public void onMvpDestroy() {
        super.onMvpDestroy();
    }
}
