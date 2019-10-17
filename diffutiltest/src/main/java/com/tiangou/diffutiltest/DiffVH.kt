package com.tiangou.diffutiltest

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class DiffVH(var rootView: ViewGroup) : RecyclerView.ViewHolder(rootView) {

    var nameText: TextView
    var descText: TextView



    init {

        nameText = rootView.findViewById(R.id.name)
        descText = rootView.findViewById(R.id.desc)

    }

}