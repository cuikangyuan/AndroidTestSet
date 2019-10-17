package com.example.tiangou.a1218test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.tiangou.a1218test.videoView.ControlPanel;
import com.example.tiangou.a1218test.videoView.MediaPlayerManager;
import com.example.tiangou.a1218test.videoView.VideoView;

public class VideoTestAct extends AppCompatActivity {



    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_test);

        videoView = (VideoView) findViewById(R.id.video_view);
        //videoView.setUp("http://vfx.mtime.cn/Video/2018/06/01/mp4/180601113115887894.mp4");
        videoView.setControlPanel(new ControlPanel(this));

        videoView.setUp("https://test.img.tg-img.com/upload/201906/13/F9E899E8-20C5-4996-ACD1-B6F4B2DDC1EE.mp4");

        //videoView.start();
        //videoView.start();
        //optional: set cover
//        Glide.with(VideoTestAct.this)
//                .load("http://img5.mtime.cn/mg/2018/07/06/093947.51483272.jpg")
//                .into((ImageView) controlPanel.findViewById(R.id.video_cover));
    }

    @Override
    public void onBackPressed() {

        //MediaPlayerManager.instance().backPress();

        setResult(RESULT_CANCELED);
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        MediaPlayerManager.instance().pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MediaPlayerManager.instance().releasePlayerAndView(this);
    }
}
