package br.com.myworkout.data

import java.io.Serializable
import java.util.Calendar

data class CalendarData(
    var calendar: MutableList<Calendar> = mutableListOf()
) : Serializable
