package com.zzy.mvp;

public interface Ipresenter<V extends BaseView> {
    void onMvpAttachView(V view);
    void onMvpStart();
    void onMvpResume();
    void onMvpPause();
    void onMvpStop();
    void onMvpDestroy();
    void onMvpDetachView();

}
