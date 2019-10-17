package com.tiangou.databindingstarted

import java.math.BigDecimal
import java.text.DecimalFormat

object BigDecimalUtil {

    public fun getValue(value: BigDecimal): String {

        val df = DecimalFormat("###,###,###.00")

        return df.format(value)

    }


    public fun getFloat(value: BigDecimal): Float {
        return value.toFloat()
    }
}