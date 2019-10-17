package com.example.tiangou.a1218test.AnimationTest;

import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.tiangou.a1218test.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main16Activity extends AppCompatActivity {

    @BindView(R.id.ll_image)
    LinearLayout linearLayout;

    @BindView(R.id.add)
    Button add;

    @BindView(R.id.remove)
    Button remove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main16);

        ButterKnife.bind(this);

        LayoutTransition layoutTransition = new LayoutTransition();


        layoutTransition.setStagger(LayoutTransition.CHANGE_APPEARING, 30);
        layoutTransition.setDuration(LayoutTransition.CHANGE_APPEARING, layoutTransition.getDuration(LayoutTransition.CHANGE_APPEARING));
        layoutTransition.setStartDelay(LayoutTransition.CHANGE_APPEARING, 0);


        ObjectAnimator appearingAnimator = ObjectAnimator
                .ofPropertyValuesHolder(
                        (Object) null,
                        PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f),
                        PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f),
                        PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f)
                );

        layoutTransition.setAnimator(LayoutTransition.APPEARING, appearingAnimator);
        layoutTransition.setDuration(LayoutTransition.APPEARING, layoutTransition.getDuration(LayoutTransition.APPEARING));
        layoutTransition.setStartDelay(LayoutTransition.APPEARING, layoutTransition.getDuration(LayoutTransition.CHANGE_APPEARING));


        ObjectAnimator disappearingAnimator = ObjectAnimator
                .ofPropertyValuesHolder(
                        (Object) null,
                        PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.0f),
                        PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.0f),
                        PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.0f)

                );


        layoutTransition.setAnimator(LayoutTransition.DISAPPEARING, disappearingAnimator);
        layoutTransition.setDuration(LayoutTransition.DISAPPEARING, layoutTransition.getDuration(LayoutTransition.DISAPPEARING));
        layoutTransition.setStartDelay(LayoutTransition.DISAPPEARING, 0);


        layoutTransition.setStagger(LayoutTransition.CHANGE_DISAPPEARING, 30);
        layoutTransition.setDuration(LayoutTransition.CHANGE_DISAPPEARING, layoutTransition.getDuration(LayoutTransition.CHANGE_DISAPPEARING));
        layoutTransition.setStartDelay(LayoutTransition.CHANGE_DISAPPEARING, layoutTransition.getDuration(LayoutTransition.DISAPPEARING));


        linearLayout.setLayoutTransition(layoutTransition);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView imageView = new ImageView(Main16Activity.this);

                imageView.setImageResource(R.mipmap.ic_launcher);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                linearLayout.addView(imageView);
            }
        });

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int count = linearLayout.getChildCount();

                if (count > 0) {

                    linearLayout.removeViewAt(0);
                }

            }
        });


    }

}
