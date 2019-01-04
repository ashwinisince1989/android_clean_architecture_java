package com.techespo.android_clean_architecture_java.view.activity;

import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.techespo.android_clean_architecture_java.App;
import com.techespo.android_clean_architecture_java.R;
import com.techespo.android_clean_architecture_java.view.base.view.BaseActivity;
import com.techespo.android_clean_architecture_java.view.presenter.UserPresenter;
import com.techespo.android_clean_architecture_java.view.viewmodel.UserViewModel;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity implements UserPresenter.View{

    private final static String TEAM_FLAG_KEY = "team_flag_key";
    @Inject
    UserPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override public void initView() {
        super.initView();
        initializeToolbar();
        initializeDagger();
        initializePresenter();
    }
    @Override protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    private void initializeDagger() {
        App euroApplication = (App) getApplication();
        euroApplication.getMainComponent().inject(this);
    }

    private void initializePresenter() {
        presenter.setView(this);
        String id = getTeamFlagKey();
        presenter.setUserId(id);
        presenter.initialize();
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        presenter.destroy();
    }

    private String getTeamFlagKey() {
        return getIntent().getExtras().getString(TEAM_FLAG_KEY);
    }

    @Override public void showUser(UserViewModel teamViewModel) {

        if (getToolbar() != null) {
            getToolbar().setTitle(teamViewModel.getName());
        }
    /*    detailHeader.initializeHeader(teamViewModel.getDisclaimer(), teamViewModel.getNickName());
        getImage(teamViewModel.getPictureOfDetail(), imageDetailHistory);
        labelBestResult.setText(teamViewModel.getBestResult());
        labelCoach.setText(teamViewModel.getCoach());
        labelLeadingScorer.setText(teamViewModel.getLeadingScorer());
        labelStadium.setText(teamViewModel.getStadium());
        labelDescription1.setText(teamViewModel.getDescriptionPart1());
        labelMatchesPlayed.setText(teamViewModel.getMatchesPlayed());
        labelOverall.setText(teamViewModel.getOverall());
        labelFinalTournament.setText(teamViewModel.getFinalTournament());
        getImage(teamViewModel.getPictureOfProfile(), imageDetailProfile);
        labelDescription2.setText(teamViewModel.getDescriptionPart2());
        labelDescription3.setText(teamViewModel.getDescriptionPart3());*/
    }

    private void getImage(String photo, ImageView photoImageView) {
        Picasso.with(photoImageView.getContext()).load(photo).fit().centerCrop().into(photoImageView);
    }

    private void initializeToolbar() {
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(
                    ContextCompat.getColor(SplashActivity.this, R.color.colorPrimaryDark));
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override public void showLoading() {
        // I´m thinking...
    }

    @Override public void hideLoading() {
        // I´m thinking...
    }
}