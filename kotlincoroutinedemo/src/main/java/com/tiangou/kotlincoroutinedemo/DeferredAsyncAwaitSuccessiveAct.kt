package com.tiangou.kotlincoroutinedemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import butterknife.ButterKnife
import butterknife.OnClick
import kotlinx.android.synthetic.main.activity_sequential_coroutine_jobs.*
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class DeferredAsyncAwaitSuccessiveAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deferred_async_await_successive)
        ButterKnife.bind(this)
    }

    @OnClick(R.id.start_button)
    fun buttonClicked() {


        setNewText("Click!")


        CoroutineScope(Dispatchers.IO).launch {
            println("debug: CoroutineScope")
            fakeApiRequest()
        }

    }

    suspend fun getResult1FromApi(): String {
        // Does not block thread. Just suspends the coroutine inside the thread
        delay(1000)
        return "Result #1"
    }

    suspend fun getResult2FromApi(result1: String): String {
        delay(1700)
        return "Result #2"
    }

    suspend fun setTextOnMainThread(input: String) {

        withContext(Dispatchers.Main) {
            setNewText(input)
        }
    }

    /**
     * Comparison between async/await and job/launch patterns.
     * Major difference is async/await can return a value wrapped in a Deferred type.
     */
    suspend fun fakeApiRequest() {



        withContext(Dispatchers.IO) {


            val executionTime = measureTimeMillis {

                // Classic job/launch
//                var result1 = ""
//                val job1 = launch {
//                    println("debug: launching job1: ${Thread.currentThread().name}")
//                    result1 = getResult1FromApi()
//                }
//                job1.join()


                val result1 = async {
                    println("debug: launching job1: ${Thread.currentThread().name}")
                    getResult1FromApi()
                }.await()

                println("debug: Got result1: $result1")


                val result2 = async {

                    println("debug: launching job2: ${Thread.currentThread().name}")
                    getResult2FromApi(result1)
                }
                result2.await()
                println("debug: Got result2: $result2")

            }

            println("debug: job1 and job2 are complete. It took ${executionTime} ms")

        }
    }

    fun setNewText(input: String) {

        val newText = content_text.text.toString() + "\n$input"

        content_text.text = newText

    }
}
