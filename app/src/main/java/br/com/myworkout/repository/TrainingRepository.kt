package br.com.myworkout.repository

import br.com.myworkout.data.CalendarData
import br.com.myworkout.data.Exercise
import br.com.myworkout.data.TrainingData
import java.util.Calendar

interface TrainingRepository {
    fun getTrainingData(): TrainingData?
    fun updateExercise(
        id: String,
        name: String,
        series: String,
        repetitions: String,
        load: String,
        type: String,
        image: String? = null,
        isChecked: Boolean
    )

    fun insertExercise(exercise: Exercise)

    fun deleteExercise(exercise: Exercise)

    fun updateCalendar(calendar: Calendar)

    fun getCalendar(): CalendarData?
}
