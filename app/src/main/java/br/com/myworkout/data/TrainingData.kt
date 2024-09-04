package br.com.myworkout.data

import br.com.myworkout.data.Exercise
import java.io.Serializable

data class TrainingData(
    var exercises: MutableList<Exercise> = mutableListOf()
): Serializable
