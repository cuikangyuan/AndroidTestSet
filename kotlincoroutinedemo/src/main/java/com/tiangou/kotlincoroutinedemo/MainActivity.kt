package com.tiangou.kotlincoroutinedemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import butterknife.ButterKnife
import butterknife.OnClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ButterKnife.bind(this)
    }


    @OnClick(R.id.sequential_coroutine_jobs)
    fun startSequentialCoroutineJobsAct() {

        val intent = Intent(this, SequentialCoroutineJobsAct::class.java)
        startActivity(intent)

    }

    @OnClick(R.id.deferred_async_await_successive)
    fun startAct1() {

        val intent = Intent(this, DeferredAsyncAwaitSuccessiveAct::class.java)
        startActivity(intent)

    }



}
