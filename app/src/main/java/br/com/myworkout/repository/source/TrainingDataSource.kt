package br.com.myworkout.repository.source

import br.com.myworkout.data.Exercise
import br.com.myworkout.data.TrainingData

interface TrainingDataSource {
    fun getExercisesSP(): TrainingData?
    fun updateExercisesSP(
        id: String,
        name: String,
        series: String,
        repetitions: String,
        load: String,
        type: String,
        image: String?,
        isChecked: Boolean
    )

    fun <T> save(key: String, data: T)

    fun isFirstAccess() : Boolean
    fun setNotFirstAccess()
    fun addExerciseSP(exercise: Exercise)
    fun deleteExerciseSP(exercise: Exercise)
}
