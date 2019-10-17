package com.tiangou.diffutiltest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.util.DiffUtil
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Button


class MainActivity : AppCompatActivity() {


    var mData = ArrayList<TestBean>()
    lateinit var mRv: RecyclerView
    lateinit var mAdapter: DiffAdapter
    lateinit var mButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        initData()


        mButton = findViewById(R.id.button)
        mRv = findViewById(R.id.recycler_view)
        mRv.layoutManager = LinearLayoutManager(this)
        mAdapter = DiffAdapter(this, mData)
        mRv.adapter = mAdapter


        mButton.setOnClickListener {
            refreshData()
        }
    }


    fun refreshData() {

        val newData = ArrayList<TestBean>()

//        for (i in 0 until mData.size) {
//
//
//
//        }

//        for (itemData in mData) {
//
//            newData.add(itemData.copy())
//
//        }

        for ((index, elem) in mData.withIndex()) {

            val copy = elem.copy()

            if(index == 0) {

                copy.desc = "desc desc 1"

            }

            newData.add(copy)

        }

        mAdapter.data = newData

        val calculateResult = DiffUtil.calculateDiff(DiffCallback(mOldData = mData, mNewData = newData))

        calculateResult.dispatchUpdatesTo(mAdapter)

        mData = newData


    }

    fun initData() {


        mData.add(TestBean("name1", "desc1"))
        mData.add(TestBean("name2", "desc2"))
        mData.add(TestBean("name3", "desc3"))
        mData.add(TestBean("name4", "desc4"))
        mData.add(TestBean("name5", "desc5"))
        mData.add(TestBean("name6", "desc6"))
        mData.add(TestBean("name7", "desc7"))
        mData.add(TestBean("name8", "desc8"))
        mData.add(TestBean("name9", "desc9"))
        mData.add(TestBean("name10", "desc10"))

        mData.add(TestBean("name11", "desc11"))
        mData.add(TestBean("name12", "desc12"))
        mData.add(TestBean("name23", "desc13"))
        mData.add(TestBean("name14", "desc14"))
        mData.add(TestBean("name15", "desc15"))
        mData.add(TestBean("name16", "desc16"))
        mData.add(TestBean("name17", "desc17"))
        mData.add(TestBean("name18", "desc18"))
        mData.add(TestBean("name19", "desc19"))
        mData.add(TestBean("name20", "desc20"))




    }
}
