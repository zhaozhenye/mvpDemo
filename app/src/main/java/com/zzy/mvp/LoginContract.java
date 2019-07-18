package com.zzy.mvp;

public class LoginContract {

    public interface IloginView extends BaseView{

        void loginSuccess();
        void onfail();
    }
    public interface IloginPresenter extends Ipresenter<IloginView>{
        void login(String name,String pwd);
    }
}
