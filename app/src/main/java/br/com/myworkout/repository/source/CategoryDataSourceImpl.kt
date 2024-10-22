package br.com.myworkout.repository.source

import android.content.Context
import android.content.SharedPreferences
import br.com.myworkout.data.Category
import br.com.myworkout.data.Exercise
import com.google.gson.Gson

class CategoryDataSourceImpl(
    val context: Context
) : CategoryDataSource {

    private val sharedPreferences =
        context.applicationContext.getSharedPreferences(TrainingDataSourceImpl.DATABASE_NAME, Context.MODE_PRIVATE)

    private val gson: Gson = Gson()

    override fun getCategories(): Category {
        return gson.fromJson(sharedPreferences.getString(CATEGORIES, null), Category::class.java)
    }

    private val categoryList = listOf(
        Category(
            name = "Peitoral",
            exercises = listOf(
                Exercise(
                    id = "",
                    name = "",
                    series = "",
                    repetitions = "12 a 15",
                    load = "",
                    type = "",
                    image = "",
                    check = false
                )
            ),
            urlToImage = "https://photos.fife.usercontent.google.com/pw/AP1GczOk1uP31FUpCFg8OGEhz-uLHUOgfW_P1SnAo8OcJdRlNQ1wtuVyIFvK=w107-h110-s-no-gm?authuser=0"
        ),
        Category(
            name = "Biceps",
            exercises = listOf(
                Exercise(
                    id = "",
                    name = "",
                    series = "",
                    repetitions = "12 a 15",
                    load = "",
                    type = "",
                    image = "",
                    check = false
                )
            ),
            urlToImage = "https://photos.fife.usercontent.google.com/pw/AP1GczO2-5QTGXaST_RGb7_Aolj7Er6rHd_1xQ2ihk7aOa7C1JPaSohTHN9z=w165-h131-s-no-gm?authuser=0"
        ),
        Category(
            name = "Deltóides",
            exercises = listOf(
                Exercise(
                    id = "",
                    name = "",
                    series = "",
                    repetitions = "12 a 15",
                    load = "",
                    type = "",
                    image = "",
                    check = false
                )
            ),
            urlToImage = "https://photos.fife.usercontent.google.com/pw/AP1GczNuofybIzjJR3gT2kRVrTIk88pfwY4SHtd2ssHVwNKSTMy1gy91abJy=w165-h131-s-no-gm?authuser=0"
        ),
        Category(
            name = "Costas",
            exercises = listOf(
                Exercise(
                    id = "",
                    name = "",
                    series = "",
                    repetitions = "12 a 15",
                    load = "",
                    type = "",
                    image = "",
                    check = false
                )
            ),
            urlToImage = "https://photos.fife.usercontent.google.com/pw/AP1GczNLTcMIuLwTEEGYH9TEXdQMc4MgONFKZ1EsCoNL1MMSJBx9aSQEeRMn=w165-h131-s-no-gm?authuser=0"
        ),
        Category(
            name = "Abdominais",
            exercises = listOf(
                Exercise(
                    id = "",
                    name = "",
                    series = "",
                    repetitions = "12 a 15",
                    load = "",
                    type = "",
                    image = "",
                    check = false
                )
            ),
            urlToImage = "https://photos.fife.usercontent.google.com/pw/AP1GczO-Pe7_S3DNvc9ku6xTjDIz3iTXdEpQdLVOYhYan9AXTuACXCKWPiub=w165-h131-s-no-gm?authuser=0"
        ),
        Category(
            name = "Quadriceps",
            exercises = listOf(
                Exercise(
                    id = "",
                    name = "",
                    series = "",
                    repetitions = "12 a 15",
                    load = "",
                    type = "",
                    image = "",
                    check = false
                )
            ),
            urlToImage = "https://photos.fife.usercontent.google.com/pw/AP1GczNgTiEsI-t9Ajm-o_7lNkcH_d7XXBILqwSpBARK7SAMWAh-_mJuFXkH=w165-h131-s-no-gm?authuser=0"
        ),
        Category(
            name = "Posteriores",
            exercises = listOf(
                Exercise(
                    id = "",
                    name = "",
                    series = "",
                    repetitions = "12 a 15",
                    load = "",
                    type = "",
                    image = "",
                    check = false
                )
            ),
            urlToImage = "https://photos.fife.usercontent.google.com/pw/AP1GczObKniV9BSZ1jXUkJVzOKLt1Viqplk9V4SmE7q3YgOe0QAL-4Rn5ArS=w165-h131-s-no-gm?authuser=0"
        ),
        Category(
            name = "Glúteos",
            exercises = listOf(
                Exercise(
                    id = "",
                    name = "",
                    series = "",
                    repetitions = "12 a 15",
                    load = "",
                    type = "",
                    image = "",
                    check = false
                )
            ),
            urlToImage = "https://photos.fife.usercontent.google.com/pw/AP1GczPMK1bP7gkSUGu1TnDVrzMlTkhUC6VhxNlZ4hmRgdgFl1x7uiyg29vz=w165-h131-s-no-gm?authuser=0"
        ),
        Category(
            name = "Tríceps",
            exercises = listOf(
                Exercise(
                    id = "",
                    name = "",
                    series = "",
                    repetitions = "12 a 15",
                    load = "",
                    type = "",
                    image = "",
                    check = false
                )
            ),
            urlToImage = "https://photos.fife.usercontent.google.com/pw/AP1GczMcxL-QCPUot5e0mZ4ia18O964MLCZsUw-6G2HOnVmgbV4iKNbgL73A=w165-h131-s-no-gm?authuser=0"
        ),
    )

    init {
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString(CATEGORIES, gson.toJson(categoryList)).apply()
    }

    companion object {
        const val CATEGORIES = "get_categories_list"
    }
}