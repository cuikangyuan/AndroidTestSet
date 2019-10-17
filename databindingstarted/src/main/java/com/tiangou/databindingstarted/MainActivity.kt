package com.tiangou.databindingstarted

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.tiangou.databindingstarted.databinding.ActivityMainBinding
import java.math.BigDecimal

class MainActivity : AppCompatActivity(), IMainActivity {


    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val imageUrl :String= "https://img1.tg-img.com/seller/201910/15/8EB3E394-4387-446B-8F92-19FF1356F985.gif!y"

        var product1 = Product(
                "title1",
                "description1",
                R.mipmap.orange_hat,
                BigDecimal(10.123),
                BigDecimal(8.123),
                1,
                BigDecimal(1.4),
                1234567,
                "9",
                imageUrl)

        var product2 = Product(
                "title2",
                "description2",
                R.mipmap.white_hat,
                BigDecimal(10.123),
                BigDecimal(5.123),
                2,
                BigDecimal(2),
                1234567,
                "9",
                imageUrl)

        binding.product = product1
        binding.quantity = 1
        binding.testUrl = imageUrl
        binding.iMainActivity = this

//        CoroutineScope(Dispatchers.Main).launch {
//
//            delay(10000)
//
//            binding.product = product2
//
//        }

    }


    override fun inflateQuantityDialog() {

        val dialog = ChooseQuantityDialog()
        dialog.show(supportFragmentManager, getString(R.string.dialog_choose_quantity))


    }

    override fun setQuantity(quantity: Int) {

        binding.quantity = quantity

    }

}
