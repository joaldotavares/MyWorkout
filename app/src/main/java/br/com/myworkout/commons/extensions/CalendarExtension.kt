package br.com.myworkout.commons.extensions

import com.applandeo.materialcalendarview.utils.setMidnight
import java.util.Calendar

val midnightCalendar: Calendar
    get() = Calendar.getInstance().apply {
        this.setMidnight()
    }

fun Calendar.setMidnight() = this.apply {
    set(Calendar.HOUR_OF_DAY, 0)
    set(Calendar.MINUTE, 0)
    set(Calendar.SECOND, 0)
    set(Calendar.MILLISECOND, 0)
}