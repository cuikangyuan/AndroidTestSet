package com.tiangou.kotlincoroutinedemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import butterknife.ButterKnife
import butterknife.OnClick
import kotlinx.android.synthetic.main.activity_sequential_coroutine_jobs.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime

class SequentialCoroutineJobsAct : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sequential_coroutine_jobs)

        ButterKnife.bind(this)


    }



    @OnClick(R.id.start_button)
    fun buttonClicked() {


        setNewText("Click!")


        CoroutineScope(IO).launch {
            println("debug: CoroutineScope")
            fakeApiRequest()
        }

    }

    suspend fun getResult1FromApi(): String {
        // Does not block thread. Just suspends the coroutine inside the thread
        delay(1000)
        return "Result #1"
    }



    suspend fun getResult2FromApi(): String {
        delay(1000)
        return "Result #2"
    }
    suspend fun setTextOnMainThread(input: String) {

        withContext(Main) {
            setNewText(input)
        }
    }



    suspend fun fakeApiRequest() {


        coroutineScope {

            val parentJob = launch {

                val job1 = launch {

                    println("debug: launching job1 in thread:  ${Thread.currentThread().name}")
                    val result1 = getResult1FromApi()
                    setTextOnMainThread("Got $result1")


                }

                //join job1 to parent job (blocking until completion)
                job1.join()

                val job2 = launch {

                    println("debug: launching job2 in thread:  ${Thread.currentThread().name}")
                    val result2 = getResult2FromApi()
                    setTextOnMainThread("Got $result2")
                }

                // join job2 to parent job (blocking until completion)
                job2.join()

                println("debug: job1 and job2 are complete.")


            }

            // Separate job within the same coroutine context that runs independently of parentJob, Job1 and Job2
            val launch = launch {

                for (delay in arrayOf(1, 2, 3, 4, 5, 6)) {

                    delay(500)

                    println("debug: is parent job active?: ${parentJob.isActive}")

                }

            }

        }
    }

    fun setNewText(input: String) {

        val newText = content_text.text.toString() + "\n$input"

        content_text.text = newText

    }
}
