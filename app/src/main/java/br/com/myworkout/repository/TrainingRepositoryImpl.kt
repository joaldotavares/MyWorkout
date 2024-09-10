package br.com.myworkout.repository

import br.com.myworkout.data.Exercise
import br.com.myworkout.data.TrainingData
import br.com.myworkout.repository.source.TrainingDataSource

class TrainingRepositoryImpl(
    private val dataSource: TrainingDataSource
) : TrainingRepository {

    override fun getTrainingData(): TrainingData? {
        dataSource.setNotFirstAccess()
        return dataSource.getExercisesSP()
    }

    override fun updateExercise(
        id: String,
        name: String,
        series: String,
        repetitions: String,
        load: String,
        type: String,
        image: String?
    ) {
        dataSource.updateExercisesSP(
            id = id,
            name = name,
            series = series,
            repetitions = repetitions,
            load = load,
            type = type,
            image = image
        )
    }

    override fun insertExercise(exercise: Exercise) {
        dataSource.addExerciseSP(exercise)
    }

    override fun deleteExercise(exercise: Exercise) {
        dataSource.deleteExerciseSP(exercise)
    }

}