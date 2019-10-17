package com.tiangou.databindingstarted

object StringUtil {

    //method below called from data binding layout. not working...

    //add @JvmStatic solve it


    @JvmStatic
    fun getQuantityString(quantity: Int): String {

        return "Qty: $quantity"

    }

    @JvmStatic
    fun convertIntToString(value: Int): String {

        return "($value)"
    }



}