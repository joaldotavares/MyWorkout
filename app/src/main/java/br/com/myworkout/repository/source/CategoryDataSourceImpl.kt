package br.com.myworkout.repository.source

import android.content.Context
import android.content.SharedPreferences
import br.com.myworkout.data.Category
import br.com.myworkout.data.Exercise
import br.com.myworkout.data.SelectExercise
import com.google.gson.Gson
import java.util.UUID

class CategoryDataSourceImpl(
    val context: Context
) : CategoryDataSource {

    private val sharedPreferences =
        context.applicationContext.getSharedPreferences(
            TrainingDataSourceImpl.DATABASE_NAME,
            Context.MODE_PRIVATE
        )

    private val gson: Gson = Gson()

    override fun getCategories(): SelectExercise {
        return gson.fromJson(
            sharedPreferences.getString(CATEGORIES, null),
            SelectExercise::class.java
        )
    }

    private val categoryList = SelectExercise(
        listOf(
            Category(
                name = "Peitoral",
                exercises = listOf(
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Supino Reto",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "",
                        check = false
                    )
                ),
                urlToImage = "https://github.com/joaldotavares/Images/blob/main/categorias/chest_category.jpg?raw=true"
            ),
            Category(
                name = "Biceps",
                exercises = listOf(
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Rosca Direta com Barra W",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "",
                        check = false
                    )
                ),
                urlToImage = "https://github.com/joaldotavares/Images/blob/main/categorias/biceps_category.jpg?raw=true"
            ),
            Category(
                name = "Deltóides",
                exercises = listOf(
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Elevação Lateral",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "",
                        check = false
                    )
                ),
                urlToImage = "https://github.com/joaldotavares/Images/blob/main/categorias/deltoid_category.jpg?raw=true"
            ),
            Category(
                name = "Costas",
                exercises = listOf(
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Puxada Frente",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "",
                        check = false
                    )
                ),
                urlToImage = "https://github.com/joaldotavares/Images/blob/main/categorias/back_category.jpg?raw=true"
            ),
            Category(
                name = "Abdominais",
                exercises = listOf(
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Abdominal na Maquina",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "",
                        check = false
                    )
                ),
                urlToImage = "https://github.com/joaldotavares/Images/blob/main/categorias/abs_category.jpg?raw=true"
            ),
            Category(
                name = "Quadriceps",
                exercises = listOf(
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Agachamento Livre com Barra",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "xxxx",
                        check = false
                    ),
                ),
                urlToImage = "https://github.com/joaldotavares/Images/blob/main/categorias/quadriceps_category.jpg?raw=true"
            ),
            Category(
                name = "Posteriores",
                exercises = listOf(
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Mesa Flexora",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "",
                        check = false
                    )
                ),
                urlToImage = "https://github.com/joaldotavares/Images/blob/main/categorias/later_category.jpg?raw=true"
            ),
            Category(
                name = "Glúteos",
                exercises = listOf(
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Stiff com Halters",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "",
                        check = false
                    )
                ),
                urlToImage = "https://github.com/joaldotavares/Images/blob/main/categorias/glutes_category.jpg?raw=true"
            ),
            Category(
                name = "Tríceps",
                exercises = listOf(
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Triceps Pulley",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "",
                        check = false
                    )
                ),
                urlToImage = "https://github.com/joaldotavares/Images/blob/main/categorias/triceps_category.jpg?raw=true"
            ),
        )
    )

    init {
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString(CATEGORIES, gson.toJson(categoryList)).apply()
    }

    companion object {
        const val CATEGORIES = "get_categories_list"
    }
}