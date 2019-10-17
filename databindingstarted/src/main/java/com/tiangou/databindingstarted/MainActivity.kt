package com.tiangou.databindingstarted

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.tiangou.databindingstarted.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.math.BigDecimal
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)


        var product1 = Product(
                "title1",
                "description1",
                R.mipmap.orange_hat,
                BigDecimal(1.123),
                BigDecimal(0.123),
                1,
                BigDecimal(1),
                1234567,
                "9")

        var product2 = Product(
                "title2",
                "description2",
                R.mipmap.white_hat,
                BigDecimal(1.123),
                BigDecimal(0.123),
                2,
                BigDecimal(2),
                1234567,
                "9")

        binding.product = product1
        binding.quantity = 1234
        //binding.testUrl = "https://i.redd.it/lntb7cl5uzs31.jpg"


//        CoroutineScope(Dispatchers.Main).launch {
//
//            delay(10000)
//
//            binding.product = product2
//
//        }

    }
}
