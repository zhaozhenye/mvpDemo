package com.zzy.mvp;

public class LoginModel {

    public void login(String name, String pwd, ModelListener listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                listener.onStart();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (name.equals("zzy") && pwd.equals("123456")) {
                    listener.onSuccess();
                } else {
                    listener.onFailed();
                }

            }

        }).start();
    }
}
