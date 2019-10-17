package com.tiangou.databindingstarted

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import com.tiangou.databindingstarted.databinding.DialogChooseQuantityBinding

class ChooseQuantityDialog: DialogFragment() {


    lateinit var mBinding: DialogChooseQuantityBinding

    val mOnItemClickListener = object :AdapterView.OnItemClickListener {

        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            val iMainActivity = activity as IMainActivity


            val value = parent!!.getItemAtPosition(position) as String

            iMainActivity.setQuantity(value.toInt())



            dialog.dismiss()

        }

    }

    val mCloseDialogListener = object : View.OnClickListener {
        override fun onClick(v: View?) {



            dialog.dismiss()
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        mBinding = DialogChooseQuantityBinding.inflate(inflater)
        mBinding.listView.setOnItemClickListener(mOnItemClickListener)
        mBinding.closeDialog.setOnClickListener(mCloseDialogListener)


        return mBinding.root

    }
}