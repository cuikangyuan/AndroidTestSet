package com.tiangou.diffutiltest

import android.os.Bundle
import android.support.v7.util.DiffUtil

class DiffCallback(var mOldData: List<TestBean>, var mNewData: List<TestBean>): DiffUtil.Callback() {




    override fun areItemsTheSame(oldItemPos: Int, newItemPos: Int): Boolean {

        return mOldData[oldItemPos].name.equals(mNewData[newItemPos].name)

    }

    override fun getOldListSize(): Int {

        return if(mOldData != null) mOldData.size else 0

    }

    override fun getNewListSize(): Int {

        return if(mNewData != null) mNewData.size else 0

    }

    override fun areContentsTheSame(oldItemPos: Int, newItemPos: Int): Boolean {


        return mOldData[oldItemPos].desc.equals(mNewData[newItemPos].desc)
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {


        val oldTestBean = mOldData[oldItemPosition]
        val newTestBean = mNewData[newItemPosition]

        val payload = Bundle()

        if (!oldTestBean.desc.equals(newTestBean.desc)) {

            payload.putString("DESC", newTestBean.desc)
        }




        return if(payload.size() > 0) payload else null



    }
}