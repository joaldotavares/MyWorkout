package br.com.myworkout.repository.source

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import br.com.myworkout.data.Category
import br.com.myworkout.data.Exercise
import br.com.myworkout.data.SelectCategory
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import java.io.FileOutputStream
import java.io.InputStreamReader
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

    override fun getCategories(): SelectCategory {

        return gson.fromJson(
            sharedPreferences.getString(CATEGORIES, null),
            SelectCategory::class.java
        )
    }

    private fun getSelectedCategoryToJson(): SelectCategory {
        val inputStream = context.applicationContext.assets.open("response.json").bufferedReader().use { it.readText() }

        return gson.fromJson(
            inputStream,
            SelectCategory::class.java
        )
    }

    init {
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString(CATEGORIES, gson.toJson(getSelectedCategoryToJson())).apply()
    }

    companion object {
        const val CATEGORIES = "get_categories_list"
    }
}
