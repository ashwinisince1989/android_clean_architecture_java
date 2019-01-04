package com.techespo.android_clean_architecture_java.view.widget;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.techespo.android_clean_architecture_java.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HeaderView  extends LinearLayout {

    @BindView(R.id.txt_header_title)
    TextView titleLabel;
    @BindView(R.id.txt_header_subtitle) TextView subTitleLabel;

    public HeaderView(Context context) {
        super(context);
    }

    public HeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override protected void onFinishInflate() {
        super.onFinishInflate();
        View view = LayoutInflater.from(getContext()).inflate(R.layout.header_detail, this, true);
        ButterKnife.bind(view);
    }

    public void initializeHeader(String disclaimer, String nickName) {
        titleLabel.setText(disclaimer);
        subTitleLabel.setText(nickName);
    }
}
