package com.zzy.mvp;

import android.os.Bundle;

public abstract class BaseMvpActivity<V extends BaseView,P extends Ipresenter<V>> extends BaseActivity {

    protected P mPresenter;

    protected abstract P createPresenter();

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        if (mPresenter == null) {
            throw new NullPointerException("presenter is null ");
        }
        mPresenter.onMvpAttachView((V)this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mPresenter != null) {
            mPresenter.onMvpStart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mPresenter != null) {
            mPresenter.onMvpResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mPresenter != null) {
            mPresenter.onMvpPause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onMvpDetachView();
            mPresenter.onMvpDestroy();
        }
    }
}
