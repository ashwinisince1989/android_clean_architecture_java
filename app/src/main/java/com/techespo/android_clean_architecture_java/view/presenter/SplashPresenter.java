package com.techespo.android_clean_architecture_java.view.presenter;

import javax.inject.Inject;

public class SplashPresenter extends Presenter<SplashPresenter.View> {

    @Inject
    public SplashPresenter() {
    }
    public void destroy() {
        setView(null);
    }
    public interface View extends Presenter.View {
        void openDashboard();
        void openOption();
        void openTour();
        void openLogin();
    }
}
