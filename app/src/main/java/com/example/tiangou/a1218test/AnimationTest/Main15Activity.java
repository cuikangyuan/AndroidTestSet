package com.example.tiangou.a1218test.AnimationTest;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.tiangou.a1218test.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main15Activity extends AppCompatActivity {


    @BindView(R.id.imageview)
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main15);

        ButterKnife.bind(this);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.pingyi);

        animation.setFillAfter(true);

        imageView.startAnimation(animation);

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imageView, "alpha", 1, 0, 1);

    }
}
