package com.tiangou.diffutiltest

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup

class DiffAdapter(var context: Context, var data: List<TestBean>) : RecyclerView.Adapter<DiffVH>() {


    companion object {
        const val TAG = "DiffAdapter"
    }

    constructor(context: Context) : this(context, ArrayList<TestBean>()) {

    }


    fun setAdapterData(newData: List<TestBean>) {

        data = newData

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiffVH {

        val itemView = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)

        return DiffVH(itemView as ViewGroup)
    }

    override fun getItemCount(): Int {

        return data.size
    }

    override fun onBindViewHolder(holder: DiffVH, position: Int) {

        val get = data.get(position)

        holder.nameText.setText(get.name)
        holder.descText.setText(get.desc)


        Log.d(TAG, "onBindViewHolder1: position=$position, name=${get.name}, desc=${get.desc}")

    }


    override fun onBindViewHolder(holder: DiffVH, position: Int, payloads: MutableList<Any>) {

        if(payloads.isEmpty()) {

            onBindViewHolder(holder, position)

        } else {


            val payload: Bundle = payloads[0] as Bundle

            val string = payload.getString("DESC")

            holder.descText.setText(string)

            Log.d(TAG, "onBindViewHolder2: position=$position, desc=${string}")


        }

    }
}