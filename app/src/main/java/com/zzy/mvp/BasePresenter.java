package com.zzy.mvp;

import java.lang.ref.WeakReference;

public class BasePresenter<V extends BaseView> implements Ipresenter<V> {
    private WeakReference<V> viewRef;

    protected V getView() {
        return viewRef.get();
    }

    protected boolean isViewAttached() {
        return (viewRef != null && viewRef.get() != null);
    }

    @Override
    public void onMvpAttachView(V view) {
        viewRef = new WeakReference<>(view);
    }

    @Override
    public void onMvpStart() {

    }

    @Override
    public void onMvpResume() {

    }

    @Override
    public void onMvpPause() {

    }

    @Override
    public void onMvpStop() {

    }

    @Override
    public void onMvpDestroy() {

    }

    @Override
    public void onMvpDetachView() {
        if (viewRef != null) {
            viewRef.clear();
            viewRef = null;
        }
    }
}
