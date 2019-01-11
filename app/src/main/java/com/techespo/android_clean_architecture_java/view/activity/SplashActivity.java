package com.techespo.android_clean_architecture_java.view.activity;

import com.techespo.android_clean_architecture_java.App;
import com.techespo.android_clean_architecture_java.R;
import com.techespo.android_clean_architecture_java.view.base.view.BaseActivity;
import com.techespo.android_clean_architecture_java.view.fragment.UserProfileFragment;
import com.techespo.android_clean_architecture_java.view.presenter.SplashPresenter;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity implements SplashPresenter.View{

    @Inject SplashPresenter presenter;

    @Override public void initView() {
        super.initView();
        initializeDagger();
        initializePresenter();
        //disableTitleFromToolbar();
        //initializeToolbar();
        presenter.initialize();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, UserProfileFragment.newInstance())
                .commit();
    }
    @Override protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    private void initializePresenter() {
        presenter.setView(this);
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        presenter.destroy();
    }

    private void initializeDagger() {
        App euroApplication = (App) getApplication();
        euroApplication.getMainComponent().inject(this);
    }

    /*private void initializeToolbar() {
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(
                    ContextCompat.getColor(SplashActivity.this, R.color.colorPrimaryDark));
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }*/

    @Override public void showLoading() {
        // I´m thinking...
    }

    @Override public void hideLoading() {
        // I have done...
    }

    @Override
    public void openDashboard() {
        //If user already login open user dashboard
    }

    @Override
    public void openOption() {
        //If user already not login open user choose option
    }

    @Override
    public void openTour() {
      //If user first time come into app open tour
    }

    @Override
    public void openLogin() {
        //If user already not login open user Login
    }
   /* private void disableTitleFromToolbar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }*/
}