package br.com.myworkout.repository.source

import android.content.Context
import android.content.SharedPreferences
import br.com.myworkout.data.Exercise
import br.com.myworkout.data.TrainingData
import com.google.gson.Gson

class TrainingDataSourceImpl(
    val context: Context
) : TrainingDataSource {

    private val sharedPreferences =
        context.applicationContext.getSharedPreferences(DATABASE_NAME, Context.MODE_PRIVATE)

    private val gson: Gson = Gson()

    override fun getExercisesSP(): TrainingData? {
        return gson.fromJson(sharedPreferences.getString(EXERCISES, null), TrainingData::class.java)
    }

    override fun updateExercisesSP(
        id: String,
        name: String,
        series: String,
        repetitions: String,
        load: String,
        type: String,
        image: String?
    ) {
        val lista =
            gson.fromJson(sharedPreferences.getString(EXERCISES, null), TrainingData::class.java)
        lista?.exercises?.find {
            it.id == id
        }?.apply {
            this.name = name
            this.series = series
            this.repetitions = repetitions
            this.load = load
            this.type = type
        }
        save(EXERCISES, lista)
    }

    override fun addExerciseSP(exercise: Exercise) {
        val lista =
            gson.fromJson(sharedPreferences.getString(EXERCISES, null), TrainingData::class.java)
        lista.exercises.add(exercise)
        save(EXERCISES, lista)
    }

    override fun deleteExerciseSP(exercise: Exercise) {
        val lista =
        gson.fromJson(sharedPreferences.getString(EXERCISES, null), TrainingData::class.java)
        lista.exercises.remove(exercise)
        save(EXERCISES, lista)
    }

    override fun <T> save(key: String, data: T) {
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString(key, gson.toJson(data)).apply()
    }

    override fun isFirstAccess(): Boolean {
        return sharedPreferences.getBoolean(FIRST_ACCESS, true)
    }

    override fun setNotFirstAccess() {
        sharedPreferences.edit().run {
            putBoolean(FIRST_ACCESS, false)
        }.apply()
    }

    companion object {
        const val DATABASE_NAME = "my_workout_database"
        const val EXERCISES = "get_exercises_list"
        const val FIRST_ACCESS = "is_first_access"
    }

    init {
        if (isFirstAccess()) {
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString(EXERCISES, gson.toJson(TrainingData(mutableListOf()))).apply()
        } else {
            setNotFirstAccess()
        }
    }
}