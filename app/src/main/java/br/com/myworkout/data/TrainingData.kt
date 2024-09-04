package br.com.myworkout.data

import java.io.Serializable

data class TrainingData(
    var exercises: MutableList<Exercise> = mutableListOf()
): Serializable
