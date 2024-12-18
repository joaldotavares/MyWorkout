package br.com.myworkout.commons.extensions

import com.applandeo.materialcalendarview.utils.setMidnight
import java.util.Calendar

val midnightCalendar: Calendar
    get() = Calendar.getInstance().apply {
        this.setMidnight()
    }
