package com.tiangou.databindingstarted

class StringUtil1 {


    //method below called from data binding layout. not working...

    //add @JvmStatic solve it

    companion object {

        @JvmStatic
        fun getQuantityString(quantity: Int): String {

            return "Qty: $quantity"

        }

        @JvmStatic
        fun convertIntToString(value: Int): String {

            return "($value)"
        }
    }
}