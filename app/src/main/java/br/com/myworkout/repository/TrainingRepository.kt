package br.com.myworkout.repository

import br.com.myworkout.data.Exercise
import br.com.myworkout.data.TrainingData

interface TrainingRepository {
    fun getTrainingData(): TrainingData?
    fun updateExercise(
        id: String,
        name: String,
        series: String,
        repetitions: String,
        load: String,
        type: String,
        image: String? = null
    )
    fun addExercise(exercise: Exercise)
}
