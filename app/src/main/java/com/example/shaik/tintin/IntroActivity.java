package com.example.shaik.tintin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

/**
 * Created by shaik on 9/19/2018.
 */

public class IntroActivity extends AppIntro {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addSlide(AppIntroFragment.newInstance("Step1:", "Slide Left if the answer is NO", R.drawable.ic_swipe_left,getColor(R.color.purple)));
        addSlide(AppIntroFragment.newInstance("Step2:", "Slide Right if the answer is Yes", R.drawable.swipe_right,getColor(R.color.purple)));
        addSlide(AppIntroFragment.newInstance("Step3:", "Enjoy!", R.drawable.ic_skip_white,getColor(R.color.purple)));
        setZoomAnimation();
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        // Do something when users tap on Skip button.
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        // Do something when users tap on Done button.
        startActivity(new Intent(IntroActivity.this,MainActivity.class));
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
        // Do something when the slide changes.
    }
}
