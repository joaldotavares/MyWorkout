package br.com.myworkout.data

import java.io.Serializable

data class Exercise(
    val id: String,
    var name: String,
    var series: String,
    var repetitions: String,
    var load: String,
    var type: String,
    var image: String? = null
): Serializable
